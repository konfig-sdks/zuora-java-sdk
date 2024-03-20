# PaymentsApi

All URIs are relative to *https://rest.zuora.com*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**applyPayment**](PaymentsApi.md#applyPayment) | **PUT** /v1/payments/{paymentKey}/apply | Apply a payment |
| [**cancelPayment**](PaymentsApi.md#cancelPayment) | **PUT** /v1/payments/{paymentKey}/cancel | Cancel a payment |
| [**createPayment**](PaymentsApi.md#createPayment) | **POST** /v1/payments | Create a payment |
| [**payment**](PaymentsApi.md#payment) | **GET** /v1/payments/{paymentKey} | Retrieve a payment |
| [**paymentItemPart**](PaymentsApi.md#paymentItemPart) | **GET** /v1/payments/{paymentKey}/parts/{partid}/itemparts/{itempartid} | Retrieve a payment part item |
| [**paymentItemParts**](PaymentsApi.md#paymentItemParts) | **GET** /v1/payments/{paymentKey}/parts/{partid}/itemparts | List all payment part items |
| [**paymentPart**](PaymentsApi.md#paymentPart) | **GET** /v1/payments/{paymentKey}/parts/{partid} | Retrieve a payment part |
| [**paymentParts**](PaymentsApi.md#paymentParts) | **GET** /v1/payments/{paymentKey}/parts | List all parts of a payment |
| [**payment_0**](PaymentsApi.md#payment_0) | **DELETE** /v1/payments/{paymentKey} | Delete a payment |
| [**refundPayment**](PaymentsApi.md#refundPayment) | **POST** /v1/payments/{paymentKey}/refunds | Refund a payment |
| [**refundPaymentwithAutoUnapply**](PaymentsApi.md#refundPaymentwithAutoUnapply) | **POST** /v1/payments/{paymentKey}/refunds/unapply | Refund a payment with auto-unapplying |
| [**retrieveAllPayments**](PaymentsApi.md#retrieveAllPayments) | **GET** /v1/payments | List payments |
| [**transferPayment**](PaymentsApi.md#transferPayment) | **PUT** /v1/payments/{paymentKey}/transfer | Transfer a payment |
| [**unapplyPayment**](PaymentsApi.md#unapplyPayment) | **PUT** /v1/payments/{paymentKey}/unapply | Unapply a payment |
| [**updatePayment**](PaymentsApi.md#updatePayment) | **PUT** /v1/payments/{paymentId} | Update a payment |


<a name="applyPayment"></a>
# **applyPayment**
> GETARPaymentType applyPayment(paymentKey, applyPaymentType).acceptEncoding(acceptEncoding).contentEncoding(contentEncoding).authorization(authorization).zuoraTrackId(zuoraTrackId).zuoraEntityIds(zuoraEntityIds).zuoraOrgIds(zuoraOrgIds).execute();

Apply a payment

**Note:** This operation is only available if you have [Invoice Settlement](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/Invoice_Settlement) enabled. The Invoice Settlement feature is generally available as of Zuora Billing Release 296 (March 2021). This feature includes Unapplied Payments, Credit and Debit Memo, and Invoice Item Settlement. If you want to enable Invoice Settlement, see [Invoice Settlement Enablement and Checklist Guide](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/Invoice_Settlement/Invoice_Settlement_Migration_Checklist_and_Guide) for more information.   Applies an unapplied payment to invoices and debit memos.  When you apply a payment, the total number of invoice items and debit memo items that the payment will apply to must be less than or equal to 15,000.          If the limit is hit, you can follow the instructions: - If you want to apply one payment to multiple invoices or debit memos, decrease the number of invoices or debit memos in the request. - If you want to apply one payment to a single invoice or debit memo with a large volume of items, you have to specify invoice items in the request. The maximum number of invoice items that you can specify in the request is 1,000.  For more information, see [Apply Unapplied Payments to Invoices and Debit Memos](https://knowledgecenter.zuora.com/CB_Billing/Invoice_Settlement/A_Unapplied_Payments/Management_of_Unapplied_Payments/Apply_Unapplied_Payments_to_Invoices_and_Debit_Memos). 

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Zuora;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.PaymentsApi;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Example {
  public static void main(String[] args) {
    Configuration configuration = new Configuration();
    configuration.host = "https://rest.zuora.com";
    Zuora client = new Zuora(configuration);
    String paymentKey = "paymentKey_example"; // The unique ID or number of an unapplied payment. For example, `8a8082e65b27f6c3015b89e4344c16b1`, or `P-00000001`. 
    List<PaymentDebitMemoApplicationApplyRequestType> debitMemos = Arrays.asList(); // Container for debit memos. The maximum number of debit memos is 1,000. 
    LocalDate effectiveDate = LocalDate.now(); // The date when the payment application takes effect, in `yyyy-mm-dd` format. The effective date must be later than or equal to the maximum effective date of the payment. 
    List<PaymentInvoiceApplicationApplyRequestType> invoices = Arrays.asList(); // Container for invoices. The maximum number of invoices is 1,000. 
    String acceptEncoding = "acceptEncoding_example"; // Include the `Accept-Encoding: gzip` header to compress responses as a gzipped file. It can significantly reduce the bandwidth required for a response.   If specified, Zuora automatically compresses responses that contain over 1000 bytes of data, and the response contains a `Content-Encoding` header with the compression algorithm so that your client can decompress it. 
    String contentEncoding = "contentEncoding_example"; // Include the `Content-Encoding: gzip` header to compress a request. With this header specified, you should upload a gzipped file for the request payload instead of sending the JSON payload. 
    String authorization = "authorization_example"; // The value is in the `Bearer {token}` format where {token} is a valid OAuth token generated by calling [Create an OAuth token](https://developer.zuora.com/api-references/api/operation/createToken). 
    String zuoraTrackId = "zuoraTrackId_example"; // A custom identifier for tracing the API call. If you set a value for this header, Zuora returns the same value in the response headers. This header enables you to associate your system process identifiers with Zuora API calls, to assist with troubleshooting in the event of an issue.  The value of this field must use the US-ASCII character set and must not include any of the following characters: colon (`:`), semicolon (`;`), double quote (`\"`), and quote (`'`). 
    String zuoraEntityIds = "zuoraEntityIds_example"; // An entity ID. If you have [Zuora Multi-entity](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Multi-entity) enabled and the OAuth token is valid for more than one entity, you must use this header to specify which entity to perform the operation in. If the OAuth token is only valid for a single entity, or you do not have Zuora Multi-entity enabled, you do not need to set this header. 
    String zuoraOrgIds = "zuoraOrgIds_example"; // Comma separated IDs. If you have <a href=\"https://knowledgecenter.zuora.com/Zuora_Central_Platform/Multi-Org\" target=\"_blank\">Zuora Multi-Org</a> enabled,  you can use this header to specify which orgs to perform the operation in. If you do not have Zuora Multi-Org enabled, you should not set this header.  The IDs must be a sub-set of the user's accessible orgs. If you specify an org that the user does not have access to, the operation fails.  If the header is not set, the operation is performed in scope of the user's accessible orgs. 
    try {
      GETARPaymentType result = client
              .payments
              .applyPayment(paymentKey)
              .debitMemos(debitMemos)
              .effectiveDate(effectiveDate)
              .invoices(invoices)
              .acceptEncoding(acceptEncoding)
              .contentEncoding(contentEncoding)
              .authorization(authorization)
              .zuoraTrackId(zuoraTrackId)
              .zuoraEntityIds(zuoraEntityIds)
              .zuoraOrgIds(zuoraOrgIds)
              .execute();
      System.out.println(result);
      System.out.println(result.getAccountId());
      System.out.println(result.getAccountNumber());
      System.out.println(result.getAmount());
      System.out.println(result.getAppliedAmount());
      System.out.println(result.getAuthTransactionId());
      System.out.println(result.getBankIdentificationNumber());
      System.out.println(result.getCancelledOn());
      System.out.println(result.getComment());
      System.out.println(result.getCreatedById());
      System.out.println(result.getCreatedDate());
      System.out.println(result.getCreditBalanceAmount());
      System.out.println(result.getCurrency());
      System.out.println(result.getEffectiveDate());
      System.out.println(result.getFinanceInformation());
      System.out.println(result.getGatewayId());
      System.out.println(result.getGatewayOrderId());
      System.out.println(result.getGatewayReconciliationReason());
      System.out.println(result.getGatewayReconciliationStatus());
      System.out.println(result.getGatewayResponse());
      System.out.println(result.getGatewayResponseCode());
      System.out.println(result.getGatewayState());
      System.out.println(result.getId());
      System.out.println(result.getMarkedForSubmissionOn());
      System.out.println(result.getNumber());
      System.out.println(result.getOrganizationLabel());
      System.out.println(result.getPaymentGatewayNumber());
      System.out.println(result.getPaymentMethodId());
      System.out.println(result.getPaymentMethodSnapshotId());
      System.out.println(result.getPaymentScheduleKey());
      System.out.println(result.getPayoutId());
      System.out.println(result.getPrepayment());
      System.out.println(result.getReferenceId());
      System.out.println(result.getRefundAmount());
      System.out.println(result.getSecondPaymentReferenceId());
      System.out.println(result.getSettledOn());
      System.out.println(result.getSoftDescriptor());
      System.out.println(result.getSoftDescriptorPhone());
      System.out.println(result.getStandalone());
      System.out.println(result.getStatus());
      System.out.println(result.getSubmittedOn());
      System.out.println(result.getSuccess());
      System.out.println(result.getType());
      System.out.println(result.getUnappliedAmount());
      System.out.println(result.getUpdatedById());
      System.out.println(result.getUpdatedDate());
      System.out.println(result.getIntegrationIdNS());
      System.out.println(result.getIntegrationStatusNS());
      System.out.println(result.getOriginNS());
      System.out.println(result.getSyncDateNS());
      System.out.println(result.getTransactionNS());
    } catch (ApiException e) {
      System.err.println("Exception when calling PaymentsApi#applyPayment");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<GETARPaymentType> response = client
              .payments
              .applyPayment(paymentKey)
              .debitMemos(debitMemos)
              .effectiveDate(effectiveDate)
              .invoices(invoices)
              .acceptEncoding(acceptEncoding)
              .contentEncoding(contentEncoding)
              .authorization(authorization)
              .zuoraTrackId(zuoraTrackId)
              .zuoraEntityIds(zuoraEntityIds)
              .zuoraOrgIds(zuoraOrgIds)
              .executeWithHttpInfo();
      System.out.println(response.getResponseBody());
      System.out.println(response.getResponseHeaders());
      System.out.println(response.getStatusCode());
      System.out.println(response.getRoundTripTime());
      System.out.println(response.getRequest());
    } catch (ApiException e) {
      System.err.println("Exception when calling PaymentsApi#applyPayment");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}

```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **paymentKey** | **String**| The unique ID or number of an unapplied payment. For example, &#x60;8a8082e65b27f6c3015b89e4344c16b1&#x60;, or &#x60;P-00000001&#x60;.  | |
| **applyPaymentType** | [**ApplyPaymentType**](ApplyPaymentType.md)|  | |
| **acceptEncoding** | **String**| Include the &#x60;Accept-Encoding: gzip&#x60; header to compress responses as a gzipped file. It can significantly reduce the bandwidth required for a response.   If specified, Zuora automatically compresses responses that contain over 1000 bytes of data, and the response contains a &#x60;Content-Encoding&#x60; header with the compression algorithm so that your client can decompress it.  | [optional] |
| **contentEncoding** | **String**| Include the &#x60;Content-Encoding: gzip&#x60; header to compress a request. With this header specified, you should upload a gzipped file for the request payload instead of sending the JSON payload.  | [optional] |
| **authorization** | **String**| The value is in the &#x60;Bearer {token}&#x60; format where {token} is a valid OAuth token generated by calling [Create an OAuth token](https://developer.zuora.com/api-references/api/operation/createToken).  | [optional] |
| **zuoraTrackId** | **String**| A custom identifier for tracing the API call. If you set a value for this header, Zuora returns the same value in the response headers. This header enables you to associate your system process identifiers with Zuora API calls, to assist with troubleshooting in the event of an issue.  The value of this field must use the US-ASCII character set and must not include any of the following characters: colon (&#x60;:&#x60;), semicolon (&#x60;;&#x60;), double quote (&#x60;\&quot;&#x60;), and quote (&#x60;&#39;&#x60;).  | [optional] |
| **zuoraEntityIds** | **String**| An entity ID. If you have [Zuora Multi-entity](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Multi-entity) enabled and the OAuth token is valid for more than one entity, you must use this header to specify which entity to perform the operation in. If the OAuth token is only valid for a single entity, or you do not have Zuora Multi-entity enabled, you do not need to set this header.  | [optional] |
| **zuoraOrgIds** | **String**| Comma separated IDs. If you have &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Central_Platform/Multi-Org\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Zuora Multi-Org&lt;/a&gt; enabled,  you can use this header to specify which orgs to perform the operation in. If you do not have Zuora Multi-Org enabled, you should not set this header.  The IDs must be a sub-set of the user&#39;s accessible orgs. If you specify an org that the user does not have access to, the operation fails.  If the header is not set, the operation is performed in scope of the user&#39;s accessible orgs.  | [optional] |

### Return type

[**GETARPaymentType**](GETARPaymentType.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** |  |  * Content-Encoding - This header is returned if you specify the &#x60;Accept-Encoding: gzip&#x60; request header and the response contains over 1000 bytes of data. Note that only the following MIME types support gzipped responses:   - &#x60;application/json&#x60;   - &#x60;application/xml&#x60;   - &#x60;text/html&#x60;   - &#x60;text/csv&#x60;   - &#x60;text/plain&#x60;  <br>  * RateLimit-Limit - The request limit quota for the time window closest to exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Remaining - The number of requests remaining in the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Reset - The number of seconds until the quota resets for the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Zuora-Request-Id - The Zuora internal identifier of the API call. You cannot control the value of this header.  <br>  * Zuora-Track-Id - A custom identifier for tracing the API call. If you specified a tracing identifier in the request headers, Zuora returns the same tracing identifier. Otherwise, Zuora does not set this header.  <br>  |

<a name="cancelPayment"></a>
# **cancelPayment**
> GETARPaymentType cancelPayment(paymentKey).acceptEncoding(acceptEncoding).contentEncoding(contentEncoding).authorization(authorization).zuoraTrackId(zuoraTrackId).zuoraEntityIds(zuoraEntityIds).zuoraOrgIds(zuoraOrgIds).execute();

Cancel a payment

**Note:** This operation is only available if you have [Invoice Settlement](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/Invoice_Settlement) enabled. The Invoice Settlement feature is generally available as of Zuora Billing Release 296 (March 2021). This feature includes Unapplied Payments, Credit and Debit Memo, and Invoice Item Settlement. If you want to enable Invoice Settlement, see [Invoice Settlement Enablement and Checklist Guide](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/Invoice_Settlement/Invoice_Settlement_Migration_Checklist_and_Guide) for more information.   Cancels a payment.   If you have the Invoice Settlement feature enabled, overpayments applied to credit balance cannot be cancelled. 

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Zuora;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.PaymentsApi;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Example {
  public static void main(String[] args) {
    Configuration configuration = new Configuration();
    configuration.host = "https://rest.zuora.com";
    Zuora client = new Zuora(configuration);
    String paymentKey = "paymentKey_example"; // The unique ID or number of an unapplied payment. For example, `8a8082e65b27f6c3015b89e4344c16b1`, or `P-00000001`. 
    String acceptEncoding = "acceptEncoding_example"; // Include the `Accept-Encoding: gzip` header to compress responses as a gzipped file. It can significantly reduce the bandwidth required for a response.   If specified, Zuora automatically compresses responses that contain over 1000 bytes of data, and the response contains a `Content-Encoding` header with the compression algorithm so that your client can decompress it. 
    String contentEncoding = "contentEncoding_example"; // Include the `Content-Encoding: gzip` header to compress a request. With this header specified, you should upload a gzipped file for the request payload instead of sending the JSON payload. 
    String authorization = "authorization_example"; // The value is in the `Bearer {token}` format where {token} is a valid OAuth token generated by calling [Create an OAuth token](https://developer.zuora.com/api-references/api/operation/createToken). 
    String zuoraTrackId = "zuoraTrackId_example"; // A custom identifier for tracing the API call. If you set a value for this header, Zuora returns the same value in the response headers. This header enables you to associate your system process identifiers with Zuora API calls, to assist with troubleshooting in the event of an issue.  The value of this field must use the US-ASCII character set and must not include any of the following characters: colon (`:`), semicolon (`;`), double quote (`\"`), and quote (`'`). 
    String zuoraEntityIds = "zuoraEntityIds_example"; // An entity ID. If you have [Zuora Multi-entity](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Multi-entity) enabled and the OAuth token is valid for more than one entity, you must use this header to specify which entity to perform the operation in. If the OAuth token is only valid for a single entity, or you do not have Zuora Multi-entity enabled, you do not need to set this header. 
    String zuoraOrgIds = "zuoraOrgIds_example"; // Comma separated IDs. If you have <a href=\"https://knowledgecenter.zuora.com/Zuora_Central_Platform/Multi-Org\" target=\"_blank\">Zuora Multi-Org</a> enabled,  you can use this header to specify which orgs to perform the operation in. If you do not have Zuora Multi-Org enabled, you should not set this header.  The IDs must be a sub-set of the user's accessible orgs. If you specify an org that the user does not have access to, the operation fails.  If the header is not set, the operation is performed in scope of the user's accessible orgs. 
    try {
      GETARPaymentType result = client
              .payments
              .cancelPayment(paymentKey)
              .acceptEncoding(acceptEncoding)
              .contentEncoding(contentEncoding)
              .authorization(authorization)
              .zuoraTrackId(zuoraTrackId)
              .zuoraEntityIds(zuoraEntityIds)
              .zuoraOrgIds(zuoraOrgIds)
              .execute();
      System.out.println(result);
      System.out.println(result.getAccountId());
      System.out.println(result.getAccountNumber());
      System.out.println(result.getAmount());
      System.out.println(result.getAppliedAmount());
      System.out.println(result.getAuthTransactionId());
      System.out.println(result.getBankIdentificationNumber());
      System.out.println(result.getCancelledOn());
      System.out.println(result.getComment());
      System.out.println(result.getCreatedById());
      System.out.println(result.getCreatedDate());
      System.out.println(result.getCreditBalanceAmount());
      System.out.println(result.getCurrency());
      System.out.println(result.getEffectiveDate());
      System.out.println(result.getFinanceInformation());
      System.out.println(result.getGatewayId());
      System.out.println(result.getGatewayOrderId());
      System.out.println(result.getGatewayReconciliationReason());
      System.out.println(result.getGatewayReconciliationStatus());
      System.out.println(result.getGatewayResponse());
      System.out.println(result.getGatewayResponseCode());
      System.out.println(result.getGatewayState());
      System.out.println(result.getId());
      System.out.println(result.getMarkedForSubmissionOn());
      System.out.println(result.getNumber());
      System.out.println(result.getOrganizationLabel());
      System.out.println(result.getPaymentGatewayNumber());
      System.out.println(result.getPaymentMethodId());
      System.out.println(result.getPaymentMethodSnapshotId());
      System.out.println(result.getPaymentScheduleKey());
      System.out.println(result.getPayoutId());
      System.out.println(result.getPrepayment());
      System.out.println(result.getReferenceId());
      System.out.println(result.getRefundAmount());
      System.out.println(result.getSecondPaymentReferenceId());
      System.out.println(result.getSettledOn());
      System.out.println(result.getSoftDescriptor());
      System.out.println(result.getSoftDescriptorPhone());
      System.out.println(result.getStandalone());
      System.out.println(result.getStatus());
      System.out.println(result.getSubmittedOn());
      System.out.println(result.getSuccess());
      System.out.println(result.getType());
      System.out.println(result.getUnappliedAmount());
      System.out.println(result.getUpdatedById());
      System.out.println(result.getUpdatedDate());
      System.out.println(result.getIntegrationIdNS());
      System.out.println(result.getIntegrationStatusNS());
      System.out.println(result.getOriginNS());
      System.out.println(result.getSyncDateNS());
      System.out.println(result.getTransactionNS());
    } catch (ApiException e) {
      System.err.println("Exception when calling PaymentsApi#cancelPayment");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<GETARPaymentType> response = client
              .payments
              .cancelPayment(paymentKey)
              .acceptEncoding(acceptEncoding)
              .contentEncoding(contentEncoding)
              .authorization(authorization)
              .zuoraTrackId(zuoraTrackId)
              .zuoraEntityIds(zuoraEntityIds)
              .zuoraOrgIds(zuoraOrgIds)
              .executeWithHttpInfo();
      System.out.println(response.getResponseBody());
      System.out.println(response.getResponseHeaders());
      System.out.println(response.getStatusCode());
      System.out.println(response.getRoundTripTime());
      System.out.println(response.getRequest());
    } catch (ApiException e) {
      System.err.println("Exception when calling PaymentsApi#cancelPayment");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}

```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **paymentKey** | **String**| The unique ID or number of an unapplied payment. For example, &#x60;8a8082e65b27f6c3015b89e4344c16b1&#x60;, or &#x60;P-00000001&#x60;.  | |
| **acceptEncoding** | **String**| Include the &#x60;Accept-Encoding: gzip&#x60; header to compress responses as a gzipped file. It can significantly reduce the bandwidth required for a response.   If specified, Zuora automatically compresses responses that contain over 1000 bytes of data, and the response contains a &#x60;Content-Encoding&#x60; header with the compression algorithm so that your client can decompress it.  | [optional] |
| **contentEncoding** | **String**| Include the &#x60;Content-Encoding: gzip&#x60; header to compress a request. With this header specified, you should upload a gzipped file for the request payload instead of sending the JSON payload.  | [optional] |
| **authorization** | **String**| The value is in the &#x60;Bearer {token}&#x60; format where {token} is a valid OAuth token generated by calling [Create an OAuth token](https://developer.zuora.com/api-references/api/operation/createToken).  | [optional] |
| **zuoraTrackId** | **String**| A custom identifier for tracing the API call. If you set a value for this header, Zuora returns the same value in the response headers. This header enables you to associate your system process identifiers with Zuora API calls, to assist with troubleshooting in the event of an issue.  The value of this field must use the US-ASCII character set and must not include any of the following characters: colon (&#x60;:&#x60;), semicolon (&#x60;;&#x60;), double quote (&#x60;\&quot;&#x60;), and quote (&#x60;&#39;&#x60;).  | [optional] |
| **zuoraEntityIds** | **String**| An entity ID. If you have [Zuora Multi-entity](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Multi-entity) enabled and the OAuth token is valid for more than one entity, you must use this header to specify which entity to perform the operation in. If the OAuth token is only valid for a single entity, or you do not have Zuora Multi-entity enabled, you do not need to set this header.  | [optional] |
| **zuoraOrgIds** | **String**| Comma separated IDs. If you have &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Central_Platform/Multi-Org\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Zuora Multi-Org&lt;/a&gt; enabled,  you can use this header to specify which orgs to perform the operation in. If you do not have Zuora Multi-Org enabled, you should not set this header.  The IDs must be a sub-set of the user&#39;s accessible orgs. If you specify an org that the user does not have access to, the operation fails.  If the header is not set, the operation is performed in scope of the user&#39;s accessible orgs.  | [optional] |

### Return type

[**GETARPaymentType**](GETARPaymentType.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** |  |  * Content-Encoding - This header is returned if you specify the &#x60;Accept-Encoding: gzip&#x60; request header and the response contains over 1000 bytes of data. Note that only the following MIME types support gzipped responses:   - &#x60;application/json&#x60;   - &#x60;application/xml&#x60;   - &#x60;text/html&#x60;   - &#x60;text/csv&#x60;   - &#x60;text/plain&#x60;  <br>  * RateLimit-Limit - The request limit quota for the time window closest to exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Remaining - The number of requests remaining in the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Reset - The number of seconds until the quota resets for the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Zuora-Request-Id - The Zuora internal identifier of the API call. You cannot control the value of this header.  <br>  * Zuora-Track-Id - A custom identifier for tracing the API call. If you specified a tracing identifier in the request headers, Zuora returns the same tracing identifier. Otherwise, Zuora does not set this header.  <br>  |

<a name="createPayment"></a>
# **createPayment**
> GETARPaymentTypeWithPaymentOption createPayment(createPaymentType).idempotencyKey(idempotencyKey).acceptEncoding(acceptEncoding).contentEncoding(contentEncoding).authorization(authorization).zuoraTrackId(zuoraTrackId).zuoraEntityIds(zuoraEntityIds).zuoraOrgIds(zuoraOrgIds).execute();

Create a payment

**Note:** This operation is only available if you have [Invoice Settlement](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/Invoice_Settlement) enabled. The Invoice Settlement feature is generally available as of Zuora Billing Release 296 (March 2021). This feature includes Unapplied Payments, Credit and Debit Memo, and Invoice Item Settlement. If you want to enable Invoice Settlement, see [Invoice Settlement Enablement and Checklist Guide](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/Invoice_Settlement/Invoice_Settlement_Migration_Checklist_and_Guide) for more information.   Creates a payment in the following scenarios:  - A full or partial payment on an invoice or a debit memo - A full or partial payment on several invoices and debit memos - An unapplied payment in the following situations:   - You do not know which customer account the payment belongs to.   - You know which customer account the payment belongs to, but you do not know which invoice the payment is applied to.   - You receive a payment from your customer that exceeds the balance on the invoice.   - You receive a payment from your customer before the invoice has been created.   - You intend to create a payment without any invoices or debit memos. - A standalone payment. If you only need to create and process an electronic payment in Zuora through a Zuora gateway integration but settle the payment outside of Zuora, you can create a standalone payment. For a standalone payment, you can specify a currency different from the payment currency in the customer account settings. When Standalone Payment is not enabled, the currency of the standalone payment can be different from the payment currency defined in the customer account settings if you have the [Multiple Currencies](https://knowledgecenter.zuora.com/Zuora_Billing/Bill_your_customers/Flexible_Billing/Multiple_Currencies) feature enabled.     The support for standalone payments is in the Early Adopter phase. To manage and access this feature through the self-service interface, see [Manage Features](https://knowledgecenter.zuora.com/Zuora_Payments/Payments_Settings/Manage_Features) in the Knowledge Center.   If you do not know to which customer account the payment belongs, you can create a payment without specifying a customer account.  When you create a payment, the total number of invoice items and debit memo items that the payment will apply to should be less than or equal to 15,000.  For more information, see [Create Payments](https://knowledgecenter.zuora.com/CB_Billing/Invoice_Settlement/A_Unapplied_Payments/Management_of_Unapplied_Payments/AA_Create_Payments) and [Create Payments Without Specifying Customer Accounts](https://knowledgecenter.zuora.com/CB_Billing/Invoice_Settlement/A_Unapplied_Payments/Management_of_Unapplied_Payments/AA_Create_Payments_Without_Specifying_Customer_Accounts).      

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Zuora;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.PaymentsApi;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Example {
  public static void main(String[] args) {
    Configuration configuration = new Configuration();
    configuration.host = "https://rest.zuora.com";
    Zuora client = new Zuora(configuration);
    String accountId = "accountId_example"; // The ID of the customer account that the payment is created for. 
    String accountNumber = "accountNumber_example"; // The number of the customer account that the payment is created for, such as `A00000001`.  You can specify either `accountNumber` or `accountId` for a customer account. If both of them are specified, they must refer to the same customer account. 
    Double amount = 3.4D; // The total amount of the payment. 
    String authTransactionId = "authTransactionId_example"; // The authorization transaction ID from the payment gateway. Use this field for electronic payments, such as credit cards.  When you create a payment for capturing the authorized funds, it is highly recommended to pass in the gatewayOrderId that you used when authorizing the funds by using the [Create authorization](https://www.zuora.com/developer/api-references/api/operation/POST_CreateAuthorization) operation, together with the `authTransactionId` field.  The following payment gateways support this field:   - Adyen Integration v2.0   - CyberSource 1.28   - CyberSource 1.97   - CyberSource 2.0   - Chase Paymentech Orbital   - Ingenico ePayments   - SlimPay   - Stripe v2   - Verifi Global Payment Gateway   - WePay Payment Gateway Integration 
    String comment = "comment_example"; // Additional information related to the payment. 
    String currency = "currency_example"; // When Standalone Payment is not enabled, the `currency` of the payment must be the same as the payment currency defined in the customer account settings through Zuora UI. But if you have the [Multiple Currencies](https://knowledgecenter.zuora.com/Zuora_Billing/Bill_your_customers/Flexible_Billing/Multiple_Currencies) feature enabled, you can have a different payment currency.  When Standalone Payment is enabled and `standalone` is `true`, the `currency` of the standalone payment can be different from the payment currency defined in the customer account settings. The amount will not be summed up to the account balance or key metrics regardless of currency. 
    List<PaymentWithCustomRatesType> customRates = Arrays.asList(); // It contains Home currency and Reporting currency custom rates currencies. The maximum number of items is 2 (you can pass the Home currency item or Reporting currency item or both).  **Note**: The API custom rate feature is permission controlled. 
    List<PaymentDebitMemoApplicationCreateRequestType> debitMemos = Arrays.asList(); // Container for debit memos. The maximum number of debit memos is 1,000. 
    LocalDate effectiveDate = LocalDate.now(); // The date when the payment takes effect, in `yyyy-mm-dd` format.  **Note:**   - This field is required for only electronic payments. It's an optional field for external payments.   - When specified, this field must be set to the date of today.   - When applying or transferring payments, this field must be later than or equal to the maximum effective date of the payment. 
    CreatePaymentTypeAllOfFinanceInformation financeInformation = new CreatePaymentTypeAllOfFinanceInformation();
    String gatewayId = "gatewayId_example"; // The ID of the gateway instance that processes the payment. The ID must be a valid gateway instance ID and this gateway must support the specific payment method.  - If <a href=\\\"https://knowledgecenter.zuora.com/Zuora_Payments/Payment_gateway_integrations/Payment_Gateway_Routing\\\" target=\\\"_blank\\\">Payment Gateway Routing</a> is enabled, when creating electronic payments, this field is optional.      - If this field is not specified, gateway routing rules will be invoked.     - If this field is specified, the specified gateway will be used to process the payment.  - If Payment Gateway Routing is disabled, when creating electronic payments, this field is required.  - When creating external payments, this field is optional.  Use the same gateway instance if both `paymentGatewayNumber` and `gatewayId` are sent in the request. 
    CreatePaymentTypeAllOfGatewayOptions gatewayOptions = new CreatePaymentTypeAllOfGatewayOptions();
    String gatewayOrderId = "gatewayOrderId_example"; // A merchant-specified natural key value that can be passed to the electronic payment gateway when a payment is created. If not specified, the payment number will be passed in instead.  Gateways check duplicates on the gateway order ID to ensure that the merchant do not accidentally enter the same transaction twice. This ID can also be used to do reconciliation and tie the payment to a natural key in external systems. The source of this ID varies by merchant. Some merchants use their shopping cart order IDs, and others use something different. Merchants use this ID to track transactions in their eCommerce systems.  When you create a payment for capturing the authorized funds, it is highly recommended to pass in the gatewayOrderId that you used when authorizing the funds by using the [Create authorization](https://www.zuora.com/developer/api-references/api/operation/POST_CreateAuthorization) operation, together with the `authTransactionId` field. 
    List<PaymentInvoiceApplicationCreateRequestType> invoices = Arrays.asList(); // Container for invoices. The maximum number of invoices is 1,000. 
    String mitTransactionSource = "C_Unscheduled"; // Payment transaction source used to differentiate the transaction source in Stored Credential Transaction framework.   - `C_Unscheduled`: Cardholder-initiated transaction (CIT) that does not occur on scheduled or regularly occurring dates.   - `M_Recurring`: Merchant-initiated transaction (MIT) that occurs at regular intervals.   - `M_Unscheduled`: Merchant-initiated transaction (MIT) that does not occur on scheduled or regularly occurring dates.   - `M_MOTO`: Mail Order Telephone Order (MOTO) payment transaction. This option is only available for credit card payments on Stripe v2. See [Overview of Stripe payment gateway integration](https://knowledgecenter.zuora.com/Zuora_Collect/Payment_gateway_integrations/Supported_payment_gateways/Stripe_Payment_Gateway/A_Overview_of_Stripe_payment_gateway_integration) for more information. 
    String paymentGatewayNumber = "paymentGatewayNumber_example"; // The natural key for the payment gateway.   Use the same gateway instance if both `paymentGatewayNumber` and `gatewayId` are sent in the request. 
    String paymentMethodId = "paymentMethodId_example"; // The unique ID of the payment method that the customer used to make the payment.   If no payment method ID is specified in the request body, the default payment method for the customer account is used automatically. If the default payment method is different from the type of payments that you want to create, an error occurs. 
    String paymentMethodType = "paymentMethodType_example"; // The type of the payment method that the customer used to make the payment.   Specify this value when you are creating an external payment method. If both `paymentMethodType` and `paymentMethodId` are specified, only the `paymentMethodId` value is used to create the payment. 
    List<PaymentSchedulePaymentOptionFields> paymentOption = Arrays.asList(); // Container for the paymentOption items, which describe the transactional level rules for processing payments. Currently, only the Gateway Options type is supported.  Here is an example: ``` \\\"paymentOption\\\": [   {     \\\"type\\\": \\\"GatewayOptions\\\",     \\\"detail\\\": {       \\\"SecCode\\\":\\\"WEB\\\"     }   } ] ```  `paymentOption` of the payment schedule takes precedence over `paymentOption` of the payment schedule item.  You can use this field or the `gatewayOptions` field to pass the Gateway Options fields supported by a payment gateway. However, the Gateway Options fields passed through the `paymentOption` field will be stored in the Payment Option object and can be easily retrieved. 
    String paymentScheduleKey = "paymentScheduleKey_example"; // The unique ID or the number of the payment schedule to be linked with the payment. See [Link payments to payment schedules](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/Payment_Schedules/Link_payments_with_payment_schedules) for more information.
    Boolean prepayment = true; // Indicates whether the payment will be used as a reserved payment. See [Prepaid Cash with Drawdown](https://knowledgecenter.zuora.com/Zuora_Billing/Billing_and_Invoicing/JA_Advanced_Consumption_Billing/Prepaid_Cash_with_Drawdown) for more information. 
    String referenceId = "referenceId_example"; // The transaction ID returned by the payment gateway. Use this field to reconcile payments between your gateway and Zuora Payments. 
    String softDescriptor = "softDescriptor_example"; // A payment gateway-specific field that maps to Zuora for the gateways, Orbital, Vantiv and Verifi.
    String softDescriptorPhone = "softDescriptorPhone_example"; // A payment gateway-specific field that maps to Zuora for the gateways, Orbital, Vantiv and Verifi.
    Boolean standalone = false; // This field is only available if support for standalone payments is enabled.  Specify `true` to create a standalone payment that will be processed in Zuora through Zuora gateway integration but will be settled outside of Zuora.  When `standalone` is set to `true`:   - `accountId`, `amount`, `currency`, and `type` are required.    - `type` must be `Electronic`.   - `currency` of the payment can be different from the payment currency in the customer account settings.   - The amount will not be summed up into the account balance and key metrics regardless of the payment currency.   - No settlement data will be created.   - Either the applied amount or the unapplied amount of the payment is zero.   - The standalone payment cannot be applied, unapplied, or transferred.  Specify `false` to create an ordinary payment that will be created, processed, and settled in Zuora. The `currency` of an ordinary payment must be the same as the currency in the customer account settings. 
    String type = "External"; // The type of the payment.  **Note**:  If you specify the type as `Electronic`, you must specify the value for `accountId` or `accountNumber`. 
    String integrationIdNS = "integrationIdNS_example"; // ID of the corresponding object in NetSuite. Only available if you have installed the [Zuora Connector for NetSuite](https://www.zuora.com/connect/app/?appId=265). 
    String integrationStatusNS = "integrationStatusNS_example"; // Status of the payment's synchronization with NetSuite. Only available if you have installed the [Zuora Connector for NetSuite](https://www.zuora.com/connect/app/?appId=265). 
    String originNS = "originNS_example"; // Origin of the corresponding object in NetSuite. Only available if you have installed the [Zuora Connector for NetSuite](https://www.zuora.com/connect/app/?appId=265). 
    String syncDateNS = "syncDateNS_example"; // Date when the payment was synchronized with NetSuite. Only available if you have installed the [Zuora Connector for NetSuite](https://www.zuora.com/connect/app/?appId=265). 
    String transactionNS = "transactionNS_example"; // Related transaction in NetSuite. Only available if you have installed the [Zuora Connector for NetSuite](https://www.zuora.com/connect/app/?appId=265). 
    String idempotencyKey = "idempotencyKey_example"; // Specify a unique idempotency key if you want to perform an idempotent POST or PATCH request. Do not use this header in other request types.   With this header specified, the Zuora server can identify subsequent retries of the same request using this value, which prevents the same operation from being performed multiple times by accident.  
    String acceptEncoding = "acceptEncoding_example"; // Include the `Accept-Encoding: gzip` header to compress responses as a gzipped file. It can significantly reduce the bandwidth required for a response.   If specified, Zuora automatically compresses responses that contain over 1000 bytes of data, and the response contains a `Content-Encoding` header with the compression algorithm so that your client can decompress it. 
    String contentEncoding = "contentEncoding_example"; // Include the `Content-Encoding: gzip` header to compress a request. With this header specified, you should upload a gzipped file for the request payload instead of sending the JSON payload. 
    String authorization = "authorization_example"; // The value is in the `Bearer {token}` format where {token} is a valid OAuth token generated by calling [Create an OAuth token](https://developer.zuora.com/api-references/api/operation/createToken). 
    String zuoraTrackId = "zuoraTrackId_example"; // A custom identifier for tracing the API call. If you set a value for this header, Zuora returns the same value in the response headers. This header enables you to associate your system process identifiers with Zuora API calls, to assist with troubleshooting in the event of an issue.  The value of this field must use the US-ASCII character set and must not include any of the following characters: colon (`:`), semicolon (`;`), double quote (`\"`), and quote (`'`). 
    String zuoraEntityIds = "zuoraEntityIds_example"; // An entity ID. If you have [Zuora Multi-entity](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Multi-entity) enabled and the OAuth token is valid for more than one entity, you must use this header to specify which entity to perform the operation in. If the OAuth token is only valid for a single entity, or you do not have Zuora Multi-entity enabled, you do not need to set this header. 
    String zuoraOrgIds = "zuoraOrgIds_example"; // Comma separated IDs. If you have <a href=\"https://knowledgecenter.zuora.com/Zuora_Central_Platform/Multi-Org\" target=\"_blank\">Zuora Multi-Org</a> enabled,  you can use this header to specify which orgs to perform the operation in. If you do not have Zuora Multi-Org enabled, you should not set this header.  The IDs must be a sub-set of the user's accessible orgs. If you specify an org that the user does not have access to, the operation fails.  If the header is not set, the operation is performed in scope of the user's accessible orgs. 
    try {
      GETARPaymentTypeWithPaymentOption result = client
              .payments
              .createPayment()
              .accountId(accountId)
              .accountNumber(accountNumber)
              .amount(amount)
              .authTransactionId(authTransactionId)
              .comment(comment)
              .currency(currency)
              .customRates(customRates)
              .debitMemos(debitMemos)
              .effectiveDate(effectiveDate)
              .financeInformation(financeInformation)
              .gatewayId(gatewayId)
              .gatewayOptions(gatewayOptions)
              .gatewayOrderId(gatewayOrderId)
              .invoices(invoices)
              .mitTransactionSource(mitTransactionSource)
              .paymentGatewayNumber(paymentGatewayNumber)
              .paymentMethodId(paymentMethodId)
              .paymentMethodType(paymentMethodType)
              .paymentOption(paymentOption)
              .paymentScheduleKey(paymentScheduleKey)
              .prepayment(prepayment)
              .referenceId(referenceId)
              .softDescriptor(softDescriptor)
              .softDescriptorPhone(softDescriptorPhone)
              .standalone(standalone)
              .type(type)
              .integrationIdNS(integrationIdNS)
              .integrationStatusNS(integrationStatusNS)
              .originNS(originNS)
              .syncDateNS(syncDateNS)
              .transactionNS(transactionNS)
              .idempotencyKey(idempotencyKey)
              .acceptEncoding(acceptEncoding)
              .contentEncoding(contentEncoding)
              .authorization(authorization)
              .zuoraTrackId(zuoraTrackId)
              .zuoraEntityIds(zuoraEntityIds)
              .zuoraOrgIds(zuoraOrgIds)
              .execute();
      System.out.println(result);
      System.out.println(result.getAccountId());
      System.out.println(result.getAccountNumber());
      System.out.println(result.getAmount());
      System.out.println(result.getAppliedAmount());
      System.out.println(result.getAuthTransactionId());
      System.out.println(result.getBankIdentificationNumber());
      System.out.println(result.getCancelledOn());
      System.out.println(result.getComment());
      System.out.println(result.getCreatedById());
      System.out.println(result.getCreatedDate());
      System.out.println(result.getCreditBalanceAmount());
      System.out.println(result.getCurrency());
      System.out.println(result.getEffectiveDate());
      System.out.println(result.getFinanceInformation());
      System.out.println(result.getGatewayId());
      System.out.println(result.getGatewayOrderId());
      System.out.println(result.getGatewayReconciliationReason());
      System.out.println(result.getGatewayReconciliationStatus());
      System.out.println(result.getGatewayResponse());
      System.out.println(result.getGatewayResponseCode());
      System.out.println(result.getGatewayState());
      System.out.println(result.getId());
      System.out.println(result.getMarkedForSubmissionOn());
      System.out.println(result.getNumber());
      System.out.println(result.getOrganizationLabel());
      System.out.println(result.getPaymentGatewayNumber());
      System.out.println(result.getPaymentMethodId());
      System.out.println(result.getPaymentMethodSnapshotId());
      System.out.println(result.getPaymentOption());
      System.out.println(result.getPaymentScheduleKey());
      System.out.println(result.getPayoutId());
      System.out.println(result.getPrepayment());
      System.out.println(result.getReferenceId());
      System.out.println(result.getRefundAmount());
      System.out.println(result.getSecondPaymentReferenceId());
      System.out.println(result.getSettledOn());
      System.out.println(result.getSoftDescriptor());
      System.out.println(result.getSoftDescriptorPhone());
      System.out.println(result.getStandalone());
      System.out.println(result.getStatus());
      System.out.println(result.getSubmittedOn());
      System.out.println(result.getSuccess());
      System.out.println(result.getType());
      System.out.println(result.getUnappliedAmount());
      System.out.println(result.getUpdatedById());
      System.out.println(result.getUpdatedDate());
      System.out.println(result.getIntegrationIdNS());
      System.out.println(result.getIntegrationStatusNS());
      System.out.println(result.getOriginNS());
      System.out.println(result.getSyncDateNS());
      System.out.println(result.getTransactionNS());
    } catch (ApiException e) {
      System.err.println("Exception when calling PaymentsApi#createPayment");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<GETARPaymentTypeWithPaymentOption> response = client
              .payments
              .createPayment()
              .accountId(accountId)
              .accountNumber(accountNumber)
              .amount(amount)
              .authTransactionId(authTransactionId)
              .comment(comment)
              .currency(currency)
              .customRates(customRates)
              .debitMemos(debitMemos)
              .effectiveDate(effectiveDate)
              .financeInformation(financeInformation)
              .gatewayId(gatewayId)
              .gatewayOptions(gatewayOptions)
              .gatewayOrderId(gatewayOrderId)
              .invoices(invoices)
              .mitTransactionSource(mitTransactionSource)
              .paymentGatewayNumber(paymentGatewayNumber)
              .paymentMethodId(paymentMethodId)
              .paymentMethodType(paymentMethodType)
              .paymentOption(paymentOption)
              .paymentScheduleKey(paymentScheduleKey)
              .prepayment(prepayment)
              .referenceId(referenceId)
              .softDescriptor(softDescriptor)
              .softDescriptorPhone(softDescriptorPhone)
              .standalone(standalone)
              .type(type)
              .integrationIdNS(integrationIdNS)
              .integrationStatusNS(integrationStatusNS)
              .originNS(originNS)
              .syncDateNS(syncDateNS)
              .transactionNS(transactionNS)
              .idempotencyKey(idempotencyKey)
              .acceptEncoding(acceptEncoding)
              .contentEncoding(contentEncoding)
              .authorization(authorization)
              .zuoraTrackId(zuoraTrackId)
              .zuoraEntityIds(zuoraEntityIds)
              .zuoraOrgIds(zuoraOrgIds)
              .executeWithHttpInfo();
      System.out.println(response.getResponseBody());
      System.out.println(response.getResponseHeaders());
      System.out.println(response.getStatusCode());
      System.out.println(response.getRoundTripTime());
      System.out.println(response.getRequest());
    } catch (ApiException e) {
      System.err.println("Exception when calling PaymentsApi#createPayment");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}

```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **createPaymentType** | [**CreatePaymentType**](CreatePaymentType.md)|  | |
| **idempotencyKey** | **String**| Specify a unique idempotency key if you want to perform an idempotent POST or PATCH request. Do not use this header in other request types.   With this header specified, the Zuora server can identify subsequent retries of the same request using this value, which prevents the same operation from being performed multiple times by accident.   | [optional] |
| **acceptEncoding** | **String**| Include the &#x60;Accept-Encoding: gzip&#x60; header to compress responses as a gzipped file. It can significantly reduce the bandwidth required for a response.   If specified, Zuora automatically compresses responses that contain over 1000 bytes of data, and the response contains a &#x60;Content-Encoding&#x60; header with the compression algorithm so that your client can decompress it.  | [optional] |
| **contentEncoding** | **String**| Include the &#x60;Content-Encoding: gzip&#x60; header to compress a request. With this header specified, you should upload a gzipped file for the request payload instead of sending the JSON payload.  | [optional] |
| **authorization** | **String**| The value is in the &#x60;Bearer {token}&#x60; format where {token} is a valid OAuth token generated by calling [Create an OAuth token](https://developer.zuora.com/api-references/api/operation/createToken).  | [optional] |
| **zuoraTrackId** | **String**| A custom identifier for tracing the API call. If you set a value for this header, Zuora returns the same value in the response headers. This header enables you to associate your system process identifiers with Zuora API calls, to assist with troubleshooting in the event of an issue.  The value of this field must use the US-ASCII character set and must not include any of the following characters: colon (&#x60;:&#x60;), semicolon (&#x60;;&#x60;), double quote (&#x60;\&quot;&#x60;), and quote (&#x60;&#39;&#x60;).  | [optional] |
| **zuoraEntityIds** | **String**| An entity ID. If you have [Zuora Multi-entity](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Multi-entity) enabled and the OAuth token is valid for more than one entity, you must use this header to specify which entity to perform the operation in. If the OAuth token is only valid for a single entity, or you do not have Zuora Multi-entity enabled, you do not need to set this header.  | [optional] |
| **zuoraOrgIds** | **String**| Comma separated IDs. If you have &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Central_Platform/Multi-Org\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Zuora Multi-Org&lt;/a&gt; enabled,  you can use this header to specify which orgs to perform the operation in. If you do not have Zuora Multi-Org enabled, you should not set this header.  The IDs must be a sub-set of the user&#39;s accessible orgs. If you specify an org that the user does not have access to, the operation fails.  If the header is not set, the operation is performed in scope of the user&#39;s accessible orgs.  | [optional] |

### Return type

[**GETARPaymentTypeWithPaymentOption**](GETARPaymentTypeWithPaymentOption.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** |  |  * Content-Encoding - This header is returned if you specify the &#x60;Accept-Encoding: gzip&#x60; request header and the response contains over 1000 bytes of data. Note that only the following MIME types support gzipped responses:   - &#x60;application/json&#x60;   - &#x60;application/xml&#x60;   - &#x60;text/html&#x60;   - &#x60;text/csv&#x60;   - &#x60;text/plain&#x60;  <br>  * RateLimit-Limit - The request limit quota for the time window closest to exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Remaining - The number of requests remaining in the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Reset - The number of seconds until the quota resets for the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Zuora-Request-Id - The Zuora internal identifier of the API call. You cannot control the value of this header.  <br>  * Zuora-Track-Id - A custom identifier for tracing the API call. If you specified a tracing identifier in the request headers, Zuora returns the same tracing identifier. Otherwise, Zuora does not set this header.  <br>  |

<a name="payment"></a>
# **payment**
> GETARPaymentType payment(paymentKey).acceptEncoding(acceptEncoding).contentEncoding(contentEncoding).authorization(authorization).zuoraTrackId(zuoraTrackId).zuoraEntityIds(zuoraEntityIds).zuoraOrgIds(zuoraOrgIds).execute();

Retrieve a payment

**Note:** This operation is only available if you have [Invoice Settlement](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/Invoice_Settlement) enabled. The Invoice Settlement feature is generally available as of Zuora Billing Release 296 (March 2021). This feature includes Unapplied Payments, Credit and Debit Memo, and Invoice Item Settlement. If you want to enable Invoice Settlement, see [Invoice Settlement Enablement and Checklist Guide](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/Invoice_Settlement/Invoice_Settlement_Migration_Checklist_and_Guide) for more information.   Retrieves the information about one specific payment. 

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Zuora;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.PaymentsApi;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Example {
  public static void main(String[] args) {
    Configuration configuration = new Configuration();
    configuration.host = "https://rest.zuora.com";
    Zuora client = new Zuora(configuration);
    String paymentKey = "paymentKey_example"; // The unique ID or number of an unapplied payment. For example, `8a8082e65b27f6c3015b89e4344c16b1`, or `P-00000001`. 
    String acceptEncoding = "acceptEncoding_example"; // Include the `Accept-Encoding: gzip` header to compress responses as a gzipped file. It can significantly reduce the bandwidth required for a response.   If specified, Zuora automatically compresses responses that contain over 1000 bytes of data, and the response contains a `Content-Encoding` header with the compression algorithm so that your client can decompress it. 
    String contentEncoding = "contentEncoding_example"; // Include the `Content-Encoding: gzip` header to compress a request. With this header specified, you should upload a gzipped file for the request payload instead of sending the JSON payload. 
    String authorization = "authorization_example"; // The value is in the `Bearer {token}` format where {token} is a valid OAuth token generated by calling [Create an OAuth token](https://developer.zuora.com/api-references/api/operation/createToken). 
    String zuoraTrackId = "zuoraTrackId_example"; // A custom identifier for tracing the API call. If you set a value for this header, Zuora returns the same value in the response headers. This header enables you to associate your system process identifiers with Zuora API calls, to assist with troubleshooting in the event of an issue.  The value of this field must use the US-ASCII character set and must not include any of the following characters: colon (`:`), semicolon (`;`), double quote (`\"`), and quote (`'`). 
    String zuoraEntityIds = "zuoraEntityIds_example"; // An entity ID. If you have [Zuora Multi-entity](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Multi-entity) enabled and the OAuth token is valid for more than one entity, you must use this header to specify which entity to perform the operation in. If the OAuth token is only valid for a single entity, or you do not have Zuora Multi-entity enabled, you do not need to set this header. 
    String zuoraOrgIds = "zuoraOrgIds_example"; // Comma separated IDs. If you have <a href=\"https://knowledgecenter.zuora.com/Zuora_Central_Platform/Multi-Org\" target=\"_blank\">Zuora Multi-Org</a> enabled,  you can use this header to specify which orgs to perform the operation in. If you do not have Zuora Multi-Org enabled, you should not set this header.  The IDs must be a sub-set of the user's accessible orgs. If you specify an org that the user does not have access to, the operation fails.  If the header is not set, the operation is performed in scope of the user's accessible orgs. 
    try {
      GETARPaymentType result = client
              .payments
              .payment(paymentKey)
              .acceptEncoding(acceptEncoding)
              .contentEncoding(contentEncoding)
              .authorization(authorization)
              .zuoraTrackId(zuoraTrackId)
              .zuoraEntityIds(zuoraEntityIds)
              .zuoraOrgIds(zuoraOrgIds)
              .execute();
      System.out.println(result);
      System.out.println(result.getAccountId());
      System.out.println(result.getAccountNumber());
      System.out.println(result.getAmount());
      System.out.println(result.getAppliedAmount());
      System.out.println(result.getAuthTransactionId());
      System.out.println(result.getBankIdentificationNumber());
      System.out.println(result.getCancelledOn());
      System.out.println(result.getComment());
      System.out.println(result.getCreatedById());
      System.out.println(result.getCreatedDate());
      System.out.println(result.getCreditBalanceAmount());
      System.out.println(result.getCurrency());
      System.out.println(result.getEffectiveDate());
      System.out.println(result.getFinanceInformation());
      System.out.println(result.getGatewayId());
      System.out.println(result.getGatewayOrderId());
      System.out.println(result.getGatewayReconciliationReason());
      System.out.println(result.getGatewayReconciliationStatus());
      System.out.println(result.getGatewayResponse());
      System.out.println(result.getGatewayResponseCode());
      System.out.println(result.getGatewayState());
      System.out.println(result.getId());
      System.out.println(result.getMarkedForSubmissionOn());
      System.out.println(result.getNumber());
      System.out.println(result.getOrganizationLabel());
      System.out.println(result.getPaymentGatewayNumber());
      System.out.println(result.getPaymentMethodId());
      System.out.println(result.getPaymentMethodSnapshotId());
      System.out.println(result.getPaymentScheduleKey());
      System.out.println(result.getPayoutId());
      System.out.println(result.getPrepayment());
      System.out.println(result.getReferenceId());
      System.out.println(result.getRefundAmount());
      System.out.println(result.getSecondPaymentReferenceId());
      System.out.println(result.getSettledOn());
      System.out.println(result.getSoftDescriptor());
      System.out.println(result.getSoftDescriptorPhone());
      System.out.println(result.getStandalone());
      System.out.println(result.getStatus());
      System.out.println(result.getSubmittedOn());
      System.out.println(result.getSuccess());
      System.out.println(result.getType());
      System.out.println(result.getUnappliedAmount());
      System.out.println(result.getUpdatedById());
      System.out.println(result.getUpdatedDate());
      System.out.println(result.getIntegrationIdNS());
      System.out.println(result.getIntegrationStatusNS());
      System.out.println(result.getOriginNS());
      System.out.println(result.getSyncDateNS());
      System.out.println(result.getTransactionNS());
    } catch (ApiException e) {
      System.err.println("Exception when calling PaymentsApi#payment");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<GETARPaymentType> response = client
              .payments
              .payment(paymentKey)
              .acceptEncoding(acceptEncoding)
              .contentEncoding(contentEncoding)
              .authorization(authorization)
              .zuoraTrackId(zuoraTrackId)
              .zuoraEntityIds(zuoraEntityIds)
              .zuoraOrgIds(zuoraOrgIds)
              .executeWithHttpInfo();
      System.out.println(response.getResponseBody());
      System.out.println(response.getResponseHeaders());
      System.out.println(response.getStatusCode());
      System.out.println(response.getRoundTripTime());
      System.out.println(response.getRequest());
    } catch (ApiException e) {
      System.err.println("Exception when calling PaymentsApi#payment");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}

```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **paymentKey** | **String**| The unique ID or number of an unapplied payment. For example, &#x60;8a8082e65b27f6c3015b89e4344c16b1&#x60;, or &#x60;P-00000001&#x60;.  | |
| **acceptEncoding** | **String**| Include the &#x60;Accept-Encoding: gzip&#x60; header to compress responses as a gzipped file. It can significantly reduce the bandwidth required for a response.   If specified, Zuora automatically compresses responses that contain over 1000 bytes of data, and the response contains a &#x60;Content-Encoding&#x60; header with the compression algorithm so that your client can decompress it.  | [optional] |
| **contentEncoding** | **String**| Include the &#x60;Content-Encoding: gzip&#x60; header to compress a request. With this header specified, you should upload a gzipped file for the request payload instead of sending the JSON payload.  | [optional] |
| **authorization** | **String**| The value is in the &#x60;Bearer {token}&#x60; format where {token} is a valid OAuth token generated by calling [Create an OAuth token](https://developer.zuora.com/api-references/api/operation/createToken).  | [optional] |
| **zuoraTrackId** | **String**| A custom identifier for tracing the API call. If you set a value for this header, Zuora returns the same value in the response headers. This header enables you to associate your system process identifiers with Zuora API calls, to assist with troubleshooting in the event of an issue.  The value of this field must use the US-ASCII character set and must not include any of the following characters: colon (&#x60;:&#x60;), semicolon (&#x60;;&#x60;), double quote (&#x60;\&quot;&#x60;), and quote (&#x60;&#39;&#x60;).  | [optional] |
| **zuoraEntityIds** | **String**| An entity ID. If you have [Zuora Multi-entity](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Multi-entity) enabled and the OAuth token is valid for more than one entity, you must use this header to specify which entity to perform the operation in. If the OAuth token is only valid for a single entity, or you do not have Zuora Multi-entity enabled, you do not need to set this header.  | [optional] |
| **zuoraOrgIds** | **String**| Comma separated IDs. If you have &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Central_Platform/Multi-Org\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Zuora Multi-Org&lt;/a&gt; enabled,  you can use this header to specify which orgs to perform the operation in. If you do not have Zuora Multi-Org enabled, you should not set this header.  The IDs must be a sub-set of the user&#39;s accessible orgs. If you specify an org that the user does not have access to, the operation fails.  If the header is not set, the operation is performed in scope of the user&#39;s accessible orgs.  | [optional] |

### Return type

[**GETARPaymentType**](GETARPaymentType.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** |  |  * Content-Encoding - This header is returned if you specify the &#x60;Accept-Encoding: gzip&#x60; request header and the response contains over 1000 bytes of data. Note that only the following MIME types support gzipped responses:   - &#x60;application/json&#x60;   - &#x60;application/xml&#x60;   - &#x60;text/html&#x60;   - &#x60;text/csv&#x60;   - &#x60;text/plain&#x60;  <br>  * RateLimit-Limit - The request limit quota for the time window closest to exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Remaining - The number of requests remaining in the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Reset - The number of seconds until the quota resets for the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Zuora-Request-Id - The Zuora internal identifier of the API call. You cannot control the value of this header.  <br>  * Zuora-Track-Id - A custom identifier for tracing the API call. If you specified a tracing identifier in the request headers, Zuora returns the same tracing identifier. Otherwise, Zuora does not set this header.  <br>  |

<a name="paymentItemPart"></a>
# **paymentItemPart**
> GETPaymentItemPartType paymentItemPart(partid, itempartid, paymentKey).acceptEncoding(acceptEncoding).contentEncoding(contentEncoding).authorization(authorization).zuoraTrackId(zuoraTrackId).zuoraEntityIds(zuoraEntityIds).zuoraOrgIds(zuoraOrgIds).execute();

Retrieve a payment part item

**Note:** This operation is only available if you have the [Invoice Item Settlement](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/Invoice_Settlement/C_Invoice_Item_Settlement) feature enabled. Invoice Item Settlement must be used together with other Invoice Settlement features (Unapplied Payments, and Credit and Debit memos).  If you wish to enable Invoice Settlement, see [Invoice Settlement Enablement and Checklist Guide](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/Invoice_Settlement/Invoice_Settlement_Migration_Checklist_and_Guide) for more information.  Retrieves the information about a specific payment part item. A payment part item is a single line item in a payment part. A payment part can consist of several different types of items. 

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Zuora;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.PaymentsApi;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Example {
  public static void main(String[] args) {
    Configuration configuration = new Configuration();
    configuration.host = "https://rest.zuora.com";
    Zuora client = new Zuora(configuration);
    String partid = "partid_example"; // The unique ID of a specific payment part. You can get the payment part ID from the response of [List all parts of a payment](https://www.zuora.com/developer/api-references/api/operation/GET_PaymentParts). 
    String itempartid = "itempartid_example"; // The unique ID of a specific payment part item. You can get the payment part item ID from the response of [List all payment part items](https://www.zuora.com/developer/api-references/api/operation/GET_PaymentItemParts). 
    String paymentKey = "paymentKey_example"; // The unique ID or number of an unapplied payment. For example, `8a8082e65b27f6c3015b89e4344c16b1`, or `P-00000001`. 
    String acceptEncoding = "acceptEncoding_example"; // Include the `Accept-Encoding: gzip` header to compress responses as a gzipped file. It can significantly reduce the bandwidth required for a response.   If specified, Zuora automatically compresses responses that contain over 1000 bytes of data, and the response contains a `Content-Encoding` header with the compression algorithm so that your client can decompress it. 
    String contentEncoding = "contentEncoding_example"; // Include the `Content-Encoding: gzip` header to compress a request. With this header specified, you should upload a gzipped file for the request payload instead of sending the JSON payload. 
    String authorization = "authorization_example"; // The value is in the `Bearer {token}` format where {token} is a valid OAuth token generated by calling [Create an OAuth token](https://developer.zuora.com/api-references/api/operation/createToken). 
    String zuoraTrackId = "zuoraTrackId_example"; // A custom identifier for tracing the API call. If you set a value for this header, Zuora returns the same value in the response headers. This header enables you to associate your system process identifiers with Zuora API calls, to assist with troubleshooting in the event of an issue.  The value of this field must use the US-ASCII character set and must not include any of the following characters: colon (`:`), semicolon (`;`), double quote (`\"`), and quote (`'`). 
    String zuoraEntityIds = "zuoraEntityIds_example"; // An entity ID. If you have [Zuora Multi-entity](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Multi-entity) enabled and the OAuth token is valid for more than one entity, you must use this header to specify which entity to perform the operation in. If the OAuth token is only valid for a single entity, or you do not have Zuora Multi-entity enabled, you do not need to set this header. 
    String zuoraOrgIds = "zuoraOrgIds_example"; // Comma separated IDs. If you have <a href=\"https://knowledgecenter.zuora.com/Zuora_Central_Platform/Multi-Org\" target=\"_blank\">Zuora Multi-Org</a> enabled,  you can use this header to specify which orgs to perform the operation in. If you do not have Zuora Multi-Org enabled, you should not set this header.  The IDs must be a sub-set of the user's accessible orgs. If you specify an org that the user does not have access to, the operation fails.  If the header is not set, the operation is performed in scope of the user's accessible orgs. 
    try {
      GETPaymentItemPartType result = client
              .payments
              .paymentItemPart(partid, itempartid, paymentKey)
              .acceptEncoding(acceptEncoding)
              .contentEncoding(contentEncoding)
              .authorization(authorization)
              .zuoraTrackId(zuoraTrackId)
              .zuoraEntityIds(zuoraEntityIds)
              .zuoraOrgIds(zuoraOrgIds)
              .execute();
      System.out.println(result);
      System.out.println(result.getAmount());
      System.out.println(result.getCreatedById());
      System.out.println(result.getCreatedDate());
      System.out.println(result.getDebitMemoItemId());
      System.out.println(result.getId());
      System.out.println(result.getInvoiceItemId());
      System.out.println(result.getOrganizationLabel());
      System.out.println(result.getSuccess());
      System.out.println(result.getTaxItemId());
      System.out.println(result.getUpdatedById());
      System.out.println(result.getUpdatedDate());
    } catch (ApiException e) {
      System.err.println("Exception when calling PaymentsApi#paymentItemPart");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<GETPaymentItemPartType> response = client
              .payments
              .paymentItemPart(partid, itempartid, paymentKey)
              .acceptEncoding(acceptEncoding)
              .contentEncoding(contentEncoding)
              .authorization(authorization)
              .zuoraTrackId(zuoraTrackId)
              .zuoraEntityIds(zuoraEntityIds)
              .zuoraOrgIds(zuoraOrgIds)
              .executeWithHttpInfo();
      System.out.println(response.getResponseBody());
      System.out.println(response.getResponseHeaders());
      System.out.println(response.getStatusCode());
      System.out.println(response.getRoundTripTime());
      System.out.println(response.getRequest());
    } catch (ApiException e) {
      System.err.println("Exception when calling PaymentsApi#paymentItemPart");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}

```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **partid** | **String**| The unique ID of a specific payment part. You can get the payment part ID from the response of [List all parts of a payment](https://www.zuora.com/developer/api-references/api/operation/GET_PaymentParts).  | |
| **itempartid** | **String**| The unique ID of a specific payment part item. You can get the payment part item ID from the response of [List all payment part items](https://www.zuora.com/developer/api-references/api/operation/GET_PaymentItemParts).  | |
| **paymentKey** | **String**| The unique ID or number of an unapplied payment. For example, &#x60;8a8082e65b27f6c3015b89e4344c16b1&#x60;, or &#x60;P-00000001&#x60;.  | |
| **acceptEncoding** | **String**| Include the &#x60;Accept-Encoding: gzip&#x60; header to compress responses as a gzipped file. It can significantly reduce the bandwidth required for a response.   If specified, Zuora automatically compresses responses that contain over 1000 bytes of data, and the response contains a &#x60;Content-Encoding&#x60; header with the compression algorithm so that your client can decompress it.  | [optional] |
| **contentEncoding** | **String**| Include the &#x60;Content-Encoding: gzip&#x60; header to compress a request. With this header specified, you should upload a gzipped file for the request payload instead of sending the JSON payload.  | [optional] |
| **authorization** | **String**| The value is in the &#x60;Bearer {token}&#x60; format where {token} is a valid OAuth token generated by calling [Create an OAuth token](https://developer.zuora.com/api-references/api/operation/createToken).  | [optional] |
| **zuoraTrackId** | **String**| A custom identifier for tracing the API call. If you set a value for this header, Zuora returns the same value in the response headers. This header enables you to associate your system process identifiers with Zuora API calls, to assist with troubleshooting in the event of an issue.  The value of this field must use the US-ASCII character set and must not include any of the following characters: colon (&#x60;:&#x60;), semicolon (&#x60;;&#x60;), double quote (&#x60;\&quot;&#x60;), and quote (&#x60;&#39;&#x60;).  | [optional] |
| **zuoraEntityIds** | **String**| An entity ID. If you have [Zuora Multi-entity](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Multi-entity) enabled and the OAuth token is valid for more than one entity, you must use this header to specify which entity to perform the operation in. If the OAuth token is only valid for a single entity, or you do not have Zuora Multi-entity enabled, you do not need to set this header.  | [optional] |
| **zuoraOrgIds** | **String**| Comma separated IDs. If you have &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Central_Platform/Multi-Org\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Zuora Multi-Org&lt;/a&gt; enabled,  you can use this header to specify which orgs to perform the operation in. If you do not have Zuora Multi-Org enabled, you should not set this header.  The IDs must be a sub-set of the user&#39;s accessible orgs. If you specify an org that the user does not have access to, the operation fails.  If the header is not set, the operation is performed in scope of the user&#39;s accessible orgs.  | [optional] |

### Return type

[**GETPaymentItemPartType**](GETPaymentItemPartType.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** |  |  * Content-Encoding - This header is returned if you specify the &#x60;Accept-Encoding: gzip&#x60; request header and the response contains over 1000 bytes of data. Note that only the following MIME types support gzipped responses:   - &#x60;application/json&#x60;   - &#x60;application/xml&#x60;   - &#x60;text/html&#x60;   - &#x60;text/csv&#x60;   - &#x60;text/plain&#x60;  <br>  * RateLimit-Limit - The request limit quota for the time window closest to exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Remaining - The number of requests remaining in the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Reset - The number of seconds until the quota resets for the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Zuora-Request-Id - The Zuora internal identifier of the API call. You cannot control the value of this header.  <br>  * Zuora-Track-Id - A custom identifier for tracing the API call. If you specified a tracing identifier in the request headers, Zuora returns the same tracing identifier. Otherwise, Zuora does not set this header.  <br>  |

<a name="paymentItemParts"></a>
# **paymentItemParts**
> GETPaymentItemPartCollectionType paymentItemParts(partid, paymentKey).acceptEncoding(acceptEncoding).contentEncoding(contentEncoding).authorization(authorization).zuoraTrackId(zuoraTrackId).zuoraEntityIds(zuoraEntityIds).zuoraOrgIds(zuoraOrgIds).page(page).pageSize(pageSize).execute();

List all payment part items

**Note:** This operation is only available if you have the [Invoice Item Settlement](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/Invoice_Settlement/C_Invoice_Item_Settlement) feature enabled. Invoice Item Settlement must be used together with other Invoice Settlement features (Unapplied Payments, and Credit and Debit memos).  If you wish to enable Invoice Settlement, see [Invoice Settlement Enablement and Checklist Guide](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/Invoice_Settlement/Invoice_Settlement_Migration_Checklist_and_Guide) for more information.   Retrieves the information about all items of a payment part. A payment part item is a single line item in a payment part. A payment part can consist of several different types of items. 

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Zuora;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.PaymentsApi;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Example {
  public static void main(String[] args) {
    Configuration configuration = new Configuration();
    configuration.host = "https://rest.zuora.com";
    Zuora client = new Zuora(configuration);
    String partid = "partid_example"; // The unique ID of a specific payment part. You can get the payment part ID from the response of [List all parts of a payment](https://www.zuora.com/developer/api-references/api/operation/GET_PaymentParts). 
    String paymentKey = "paymentKey_example"; // The unique ID or number of an unapplied payment. For example, `8a8082e65b27f6c3015b89e4344c16b1`, or `P-00000001`. 
    String acceptEncoding = "acceptEncoding_example"; // Include the `Accept-Encoding: gzip` header to compress responses as a gzipped file. It can significantly reduce the bandwidth required for a response.   If specified, Zuora automatically compresses responses that contain over 1000 bytes of data, and the response contains a `Content-Encoding` header with the compression algorithm so that your client can decompress it. 
    String contentEncoding = "contentEncoding_example"; // Include the `Content-Encoding: gzip` header to compress a request. With this header specified, you should upload a gzipped file for the request payload instead of sending the JSON payload. 
    String authorization = "authorization_example"; // The value is in the `Bearer {token}` format where {token} is a valid OAuth token generated by calling [Create an OAuth token](https://developer.zuora.com/api-references/api/operation/createToken). 
    String zuoraTrackId = "zuoraTrackId_example"; // A custom identifier for tracing the API call. If you set a value for this header, Zuora returns the same value in the response headers. This header enables you to associate your system process identifiers with Zuora API calls, to assist with troubleshooting in the event of an issue.  The value of this field must use the US-ASCII character set and must not include any of the following characters: colon (`:`), semicolon (`;`), double quote (`\"`), and quote (`'`). 
    String zuoraEntityIds = "zuoraEntityIds_example"; // An entity ID. If you have [Zuora Multi-entity](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Multi-entity) enabled and the OAuth token is valid for more than one entity, you must use this header to specify which entity to perform the operation in. If the OAuth token is only valid for a single entity, or you do not have Zuora Multi-entity enabled, you do not need to set this header. 
    String zuoraOrgIds = "zuoraOrgIds_example"; // Comma separated IDs. If you have <a href=\"https://knowledgecenter.zuora.com/Zuora_Central_Platform/Multi-Org\" target=\"_blank\">Zuora Multi-Org</a> enabled,  you can use this header to specify which orgs to perform the operation in. If you do not have Zuora Multi-Org enabled, you should not set this header.  The IDs must be a sub-set of the user's accessible orgs. If you specify an org that the user does not have access to, the operation fails.  If the header is not set, the operation is performed in scope of the user's accessible orgs. 
    Integer page = 1; // The index number of the page that you want to retrieve. This parameter is dependent on `pageSize`. You must set `pageSize` before specifying `page`. For example, if you set `pageSize` to `20` and `page` to `2`, the 21st to 40th records are returned in the response. 
    Integer pageSize = 20; // The number of records returned per page in the response. 
    try {
      GETPaymentItemPartCollectionType result = client
              .payments
              .paymentItemParts(partid, paymentKey)
              .acceptEncoding(acceptEncoding)
              .contentEncoding(contentEncoding)
              .authorization(authorization)
              .zuoraTrackId(zuoraTrackId)
              .zuoraEntityIds(zuoraEntityIds)
              .zuoraOrgIds(zuoraOrgIds)
              .page(page)
              .pageSize(pageSize)
              .execute();
      System.out.println(result);
      System.out.println(result.getItemParts());
      System.out.println(result.getNextPage());
      System.out.println(result.getSuccess());
    } catch (ApiException e) {
      System.err.println("Exception when calling PaymentsApi#paymentItemParts");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<GETPaymentItemPartCollectionType> response = client
              .payments
              .paymentItemParts(partid, paymentKey)
              .acceptEncoding(acceptEncoding)
              .contentEncoding(contentEncoding)
              .authorization(authorization)
              .zuoraTrackId(zuoraTrackId)
              .zuoraEntityIds(zuoraEntityIds)
              .zuoraOrgIds(zuoraOrgIds)
              .page(page)
              .pageSize(pageSize)
              .executeWithHttpInfo();
      System.out.println(response.getResponseBody());
      System.out.println(response.getResponseHeaders());
      System.out.println(response.getStatusCode());
      System.out.println(response.getRoundTripTime());
      System.out.println(response.getRequest());
    } catch (ApiException e) {
      System.err.println("Exception when calling PaymentsApi#paymentItemParts");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}

```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **partid** | **String**| The unique ID of a specific payment part. You can get the payment part ID from the response of [List all parts of a payment](https://www.zuora.com/developer/api-references/api/operation/GET_PaymentParts).  | |
| **paymentKey** | **String**| The unique ID or number of an unapplied payment. For example, &#x60;8a8082e65b27f6c3015b89e4344c16b1&#x60;, or &#x60;P-00000001&#x60;.  | |
| **acceptEncoding** | **String**| Include the &#x60;Accept-Encoding: gzip&#x60; header to compress responses as a gzipped file. It can significantly reduce the bandwidth required for a response.   If specified, Zuora automatically compresses responses that contain over 1000 bytes of data, and the response contains a &#x60;Content-Encoding&#x60; header with the compression algorithm so that your client can decompress it.  | [optional] |
| **contentEncoding** | **String**| Include the &#x60;Content-Encoding: gzip&#x60; header to compress a request. With this header specified, you should upload a gzipped file for the request payload instead of sending the JSON payload.  | [optional] |
| **authorization** | **String**| The value is in the &#x60;Bearer {token}&#x60; format where {token} is a valid OAuth token generated by calling [Create an OAuth token](https://developer.zuora.com/api-references/api/operation/createToken).  | [optional] |
| **zuoraTrackId** | **String**| A custom identifier for tracing the API call. If you set a value for this header, Zuora returns the same value in the response headers. This header enables you to associate your system process identifiers with Zuora API calls, to assist with troubleshooting in the event of an issue.  The value of this field must use the US-ASCII character set and must not include any of the following characters: colon (&#x60;:&#x60;), semicolon (&#x60;;&#x60;), double quote (&#x60;\&quot;&#x60;), and quote (&#x60;&#39;&#x60;).  | [optional] |
| **zuoraEntityIds** | **String**| An entity ID. If you have [Zuora Multi-entity](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Multi-entity) enabled and the OAuth token is valid for more than one entity, you must use this header to specify which entity to perform the operation in. If the OAuth token is only valid for a single entity, or you do not have Zuora Multi-entity enabled, you do not need to set this header.  | [optional] |
| **zuoraOrgIds** | **String**| Comma separated IDs. If you have &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Central_Platform/Multi-Org\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Zuora Multi-Org&lt;/a&gt; enabled,  you can use this header to specify which orgs to perform the operation in. If you do not have Zuora Multi-Org enabled, you should not set this header.  The IDs must be a sub-set of the user&#39;s accessible orgs. If you specify an org that the user does not have access to, the operation fails.  If the header is not set, the operation is performed in scope of the user&#39;s accessible orgs.  | [optional] |
| **page** | **Integer**| The index number of the page that you want to retrieve. This parameter is dependent on &#x60;pageSize&#x60;. You must set &#x60;pageSize&#x60; before specifying &#x60;page&#x60;. For example, if you set &#x60;pageSize&#x60; to &#x60;20&#x60; and &#x60;page&#x60; to &#x60;2&#x60;, the 21st to 40th records are returned in the response.  | [optional] [default to 1] |
| **pageSize** | **Integer**| The number of records returned per page in the response.  | [optional] [default to 20] |

### Return type

[**GETPaymentItemPartCollectionType**](GETPaymentItemPartCollectionType.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** |  |  * Content-Encoding - This header is returned if you specify the &#x60;Accept-Encoding: gzip&#x60; request header and the response contains over 1000 bytes of data. Note that only the following MIME types support gzipped responses:   - &#x60;application/json&#x60;   - &#x60;application/xml&#x60;   - &#x60;text/html&#x60;   - &#x60;text/csv&#x60;   - &#x60;text/plain&#x60;  <br>  * RateLimit-Limit - The request limit quota for the time window closest to exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Remaining - The number of requests remaining in the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Reset - The number of seconds until the quota resets for the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Zuora-Request-Id - The Zuora internal identifier of the API call. You cannot control the value of this header.  <br>  * Zuora-Track-Id - A custom identifier for tracing the API call. If you specified a tracing identifier in the request headers, Zuora returns the same tracing identifier. Otherwise, Zuora does not set this header.  <br>  |

<a name="paymentPart"></a>
# **paymentPart**
> GETPaymentPartType paymentPart(partid, paymentKey).acceptEncoding(acceptEncoding).contentEncoding(contentEncoding).authorization(authorization).zuoraTrackId(zuoraTrackId).zuoraEntityIds(zuoraEntityIds).zuoraOrgIds(zuoraOrgIds).execute();

Retrieve a payment part

**Note:** This operation is only available if you have [Invoice Settlement](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/Invoice_Settlement) enabled. The Invoice Settlement feature is generally available as of Zuora Billing Release 296 (March 2021). This feature includes Unapplied Payments, Credit and Debit Memo, and Invoice Item Settlement. If you want to enable Invoice Settlement, see [Invoice Settlement Enablement and Checklist Guide](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/Invoice_Settlement/Invoice_Settlement_Migration_Checklist_and_Guide) for more information.   Retrieves the information about a specific payment part. A payment can consist of an unapplied part, and several parts applied to invoices and debit memos.  A fully refunded payment does not contain any payment part. 

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Zuora;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.PaymentsApi;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Example {
  public static void main(String[] args) {
    Configuration configuration = new Configuration();
    configuration.host = "https://rest.zuora.com";
    Zuora client = new Zuora(configuration);
    String partid = "partid_example"; // The unique ID of a specific payment part. You can get the payment part ID from the response of [List all parts of a payment](https://www.zuora.com/developer/api-references/api/operation/GET_PaymentParts). 
    String paymentKey = "paymentKey_example"; // The unique ID or number of an unapplied payment. For example, `8a8082e65b27f6c3015b89e4344c16b1`, or `P-00000001`. 
    String acceptEncoding = "acceptEncoding_example"; // Include the `Accept-Encoding: gzip` header to compress responses as a gzipped file. It can significantly reduce the bandwidth required for a response.   If specified, Zuora automatically compresses responses that contain over 1000 bytes of data, and the response contains a `Content-Encoding` header with the compression algorithm so that your client can decompress it. 
    String contentEncoding = "contentEncoding_example"; // Include the `Content-Encoding: gzip` header to compress a request. With this header specified, you should upload a gzipped file for the request payload instead of sending the JSON payload. 
    String authorization = "authorization_example"; // The value is in the `Bearer {token}` format where {token} is a valid OAuth token generated by calling [Create an OAuth token](https://developer.zuora.com/api-references/api/operation/createToken). 
    String zuoraTrackId = "zuoraTrackId_example"; // A custom identifier for tracing the API call. If you set a value for this header, Zuora returns the same value in the response headers. This header enables you to associate your system process identifiers with Zuora API calls, to assist with troubleshooting in the event of an issue.  The value of this field must use the US-ASCII character set and must not include any of the following characters: colon (`:`), semicolon (`;`), double quote (`\"`), and quote (`'`). 
    String zuoraEntityIds = "zuoraEntityIds_example"; // An entity ID. If you have [Zuora Multi-entity](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Multi-entity) enabled and the OAuth token is valid for more than one entity, you must use this header to specify which entity to perform the operation in. If the OAuth token is only valid for a single entity, or you do not have Zuora Multi-entity enabled, you do not need to set this header. 
    String zuoraOrgIds = "zuoraOrgIds_example"; // Comma separated IDs. If you have <a href=\"https://knowledgecenter.zuora.com/Zuora_Central_Platform/Multi-Org\" target=\"_blank\">Zuora Multi-Org</a> enabled,  you can use this header to specify which orgs to perform the operation in. If you do not have Zuora Multi-Org enabled, you should not set this header.  The IDs must be a sub-set of the user's accessible orgs. If you specify an org that the user does not have access to, the operation fails.  If the header is not set, the operation is performed in scope of the user's accessible orgs. 
    try {
      GETPaymentPartType result = client
              .payments
              .paymentPart(partid, paymentKey)
              .acceptEncoding(acceptEncoding)
              .contentEncoding(contentEncoding)
              .authorization(authorization)
              .zuoraTrackId(zuoraTrackId)
              .zuoraEntityIds(zuoraEntityIds)
              .zuoraOrgIds(zuoraOrgIds)
              .execute();
      System.out.println(result);
      System.out.println(result.getAmount());
      System.out.println(result.getCreatedById());
      System.out.println(result.getCreatedDate());
      System.out.println(result.getDebitMemoId());
      System.out.println(result.getId());
      System.out.println(result.getInvoiceId());
      System.out.println(result.getOrganizationLabel());
      System.out.println(result.getSuccess());
      System.out.println(result.getUpdatedById());
      System.out.println(result.getUpdatedDate());
    } catch (ApiException e) {
      System.err.println("Exception when calling PaymentsApi#paymentPart");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<GETPaymentPartType> response = client
              .payments
              .paymentPart(partid, paymentKey)
              .acceptEncoding(acceptEncoding)
              .contentEncoding(contentEncoding)
              .authorization(authorization)
              .zuoraTrackId(zuoraTrackId)
              .zuoraEntityIds(zuoraEntityIds)
              .zuoraOrgIds(zuoraOrgIds)
              .executeWithHttpInfo();
      System.out.println(response.getResponseBody());
      System.out.println(response.getResponseHeaders());
      System.out.println(response.getStatusCode());
      System.out.println(response.getRoundTripTime());
      System.out.println(response.getRequest());
    } catch (ApiException e) {
      System.err.println("Exception when calling PaymentsApi#paymentPart");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}

```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **partid** | **String**| The unique ID of a specific payment part. You can get the payment part ID from the response of [List all parts of a payment](https://www.zuora.com/developer/api-references/api/operation/GET_PaymentParts).  | |
| **paymentKey** | **String**| The unique ID or number of an unapplied payment. For example, &#x60;8a8082e65b27f6c3015b89e4344c16b1&#x60;, or &#x60;P-00000001&#x60;.  | |
| **acceptEncoding** | **String**| Include the &#x60;Accept-Encoding: gzip&#x60; header to compress responses as a gzipped file. It can significantly reduce the bandwidth required for a response.   If specified, Zuora automatically compresses responses that contain over 1000 bytes of data, and the response contains a &#x60;Content-Encoding&#x60; header with the compression algorithm so that your client can decompress it.  | [optional] |
| **contentEncoding** | **String**| Include the &#x60;Content-Encoding: gzip&#x60; header to compress a request. With this header specified, you should upload a gzipped file for the request payload instead of sending the JSON payload.  | [optional] |
| **authorization** | **String**| The value is in the &#x60;Bearer {token}&#x60; format where {token} is a valid OAuth token generated by calling [Create an OAuth token](https://developer.zuora.com/api-references/api/operation/createToken).  | [optional] |
| **zuoraTrackId** | **String**| A custom identifier for tracing the API call. If you set a value for this header, Zuora returns the same value in the response headers. This header enables you to associate your system process identifiers with Zuora API calls, to assist with troubleshooting in the event of an issue.  The value of this field must use the US-ASCII character set and must not include any of the following characters: colon (&#x60;:&#x60;), semicolon (&#x60;;&#x60;), double quote (&#x60;\&quot;&#x60;), and quote (&#x60;&#39;&#x60;).  | [optional] |
| **zuoraEntityIds** | **String**| An entity ID. If you have [Zuora Multi-entity](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Multi-entity) enabled and the OAuth token is valid for more than one entity, you must use this header to specify which entity to perform the operation in. If the OAuth token is only valid for a single entity, or you do not have Zuora Multi-entity enabled, you do not need to set this header.  | [optional] |
| **zuoraOrgIds** | **String**| Comma separated IDs. If you have &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Central_Platform/Multi-Org\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Zuora Multi-Org&lt;/a&gt; enabled,  you can use this header to specify which orgs to perform the operation in. If you do not have Zuora Multi-Org enabled, you should not set this header.  The IDs must be a sub-set of the user&#39;s accessible orgs. If you specify an org that the user does not have access to, the operation fails.  If the header is not set, the operation is performed in scope of the user&#39;s accessible orgs.  | [optional] |

### Return type

[**GETPaymentPartType**](GETPaymentPartType.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** |  |  * Content-Encoding - This header is returned if you specify the &#x60;Accept-Encoding: gzip&#x60; request header and the response contains over 1000 bytes of data. Note that only the following MIME types support gzipped responses:   - &#x60;application/json&#x60;   - &#x60;application/xml&#x60;   - &#x60;text/html&#x60;   - &#x60;text/csv&#x60;   - &#x60;text/plain&#x60;  <br>  * RateLimit-Limit - The request limit quota for the time window closest to exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Remaining - The number of requests remaining in the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Reset - The number of seconds until the quota resets for the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Zuora-Request-Id - The Zuora internal identifier of the API call. You cannot control the value of this header.  <br>  * Zuora-Track-Id - A custom identifier for tracing the API call. If you specified a tracing identifier in the request headers, Zuora returns the same tracing identifier. Otherwise, Zuora does not set this header.  <br>  |

<a name="paymentParts"></a>
# **paymentParts**
> GETPaymentPartsCollectionType paymentParts(paymentKey).acceptEncoding(acceptEncoding).contentEncoding(contentEncoding).authorization(authorization).zuoraTrackId(zuoraTrackId).zuoraEntityIds(zuoraEntityIds).zuoraOrgIds(zuoraOrgIds).page(page).pageSize(pageSize).execute();

List all parts of a payment

**Note:** This operation is only available if you have [Invoice Settlement](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/Invoice_Settlement) enabled. The Invoice Settlement feature is generally available as of Zuora Billing Release 296 (March 2021). This feature includes Unapplied Payments, Credit and Debit Memo, and Invoice Item Settlement. If you want to enable Invoice Settlement, see [Invoice Settlement Enablement and Checklist Guide](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/Invoice_Settlement/Invoice_Settlement_Migration_Checklist_and_Guide) for more information.   Retrieves the information about all parts of a payment. A payment can consist of an unapplied part, and several parts applied to invoices and debit memos. You can use this operation to get all the applied and unapplied portions of a payment. Note that a fully refunded payment does not contain any payment part. 

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Zuora;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.PaymentsApi;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Example {
  public static void main(String[] args) {
    Configuration configuration = new Configuration();
    configuration.host = "https://rest.zuora.com";
    Zuora client = new Zuora(configuration);
    String paymentKey = "paymentKey_example"; // The unique ID or number of an unapplied payment. For example, `8a8082e65b27f6c3015b89e4344c16b1`, or `P-00000001`. 
    String acceptEncoding = "acceptEncoding_example"; // Include the `Accept-Encoding: gzip` header to compress responses as a gzipped file. It can significantly reduce the bandwidth required for a response.   If specified, Zuora automatically compresses responses that contain over 1000 bytes of data, and the response contains a `Content-Encoding` header with the compression algorithm so that your client can decompress it. 
    String contentEncoding = "contentEncoding_example"; // Include the `Content-Encoding: gzip` header to compress a request. With this header specified, you should upload a gzipped file for the request payload instead of sending the JSON payload. 
    String authorization = "authorization_example"; // The value is in the `Bearer {token}` format where {token} is a valid OAuth token generated by calling [Create an OAuth token](https://developer.zuora.com/api-references/api/operation/createToken). 
    String zuoraTrackId = "zuoraTrackId_example"; // A custom identifier for tracing the API call. If you set a value for this header, Zuora returns the same value in the response headers. This header enables you to associate your system process identifiers with Zuora API calls, to assist with troubleshooting in the event of an issue.  The value of this field must use the US-ASCII character set and must not include any of the following characters: colon (`:`), semicolon (`;`), double quote (`\"`), and quote (`'`). 
    String zuoraEntityIds = "zuoraEntityIds_example"; // An entity ID. If you have [Zuora Multi-entity](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Multi-entity) enabled and the OAuth token is valid for more than one entity, you must use this header to specify which entity to perform the operation in. If the OAuth token is only valid for a single entity, or you do not have Zuora Multi-entity enabled, you do not need to set this header. 
    String zuoraOrgIds = "zuoraOrgIds_example"; // Comma separated IDs. If you have <a href=\"https://knowledgecenter.zuora.com/Zuora_Central_Platform/Multi-Org\" target=\"_blank\">Zuora Multi-Org</a> enabled,  you can use this header to specify which orgs to perform the operation in. If you do not have Zuora Multi-Org enabled, you should not set this header.  The IDs must be a sub-set of the user's accessible orgs. If you specify an org that the user does not have access to, the operation fails.  If the header is not set, the operation is performed in scope of the user's accessible orgs. 
    Integer page = 1; // The index number of the page that you want to retrieve. This parameter is dependent on `pageSize`. You must set `pageSize` before specifying `page`. For example, if you set `pageSize` to `20` and `page` to `2`, the 21st to 40th records are returned in the response. 
    Integer pageSize = 20; // The number of records returned per page in the response. 
    try {
      GETPaymentPartsCollectionType result = client
              .payments
              .paymentParts(paymentKey)
              .acceptEncoding(acceptEncoding)
              .contentEncoding(contentEncoding)
              .authorization(authorization)
              .zuoraTrackId(zuoraTrackId)
              .zuoraEntityIds(zuoraEntityIds)
              .zuoraOrgIds(zuoraOrgIds)
              .page(page)
              .pageSize(pageSize)
              .execute();
      System.out.println(result);
      System.out.println(result.getNextPage());
      System.out.println(result.getParts());
      System.out.println(result.getSuccess());
    } catch (ApiException e) {
      System.err.println("Exception when calling PaymentsApi#paymentParts");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<GETPaymentPartsCollectionType> response = client
              .payments
              .paymentParts(paymentKey)
              .acceptEncoding(acceptEncoding)
              .contentEncoding(contentEncoding)
              .authorization(authorization)
              .zuoraTrackId(zuoraTrackId)
              .zuoraEntityIds(zuoraEntityIds)
              .zuoraOrgIds(zuoraOrgIds)
              .page(page)
              .pageSize(pageSize)
              .executeWithHttpInfo();
      System.out.println(response.getResponseBody());
      System.out.println(response.getResponseHeaders());
      System.out.println(response.getStatusCode());
      System.out.println(response.getRoundTripTime());
      System.out.println(response.getRequest());
    } catch (ApiException e) {
      System.err.println("Exception when calling PaymentsApi#paymentParts");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}

```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **paymentKey** | **String**| The unique ID or number of an unapplied payment. For example, &#x60;8a8082e65b27f6c3015b89e4344c16b1&#x60;, or &#x60;P-00000001&#x60;.  | |
| **acceptEncoding** | **String**| Include the &#x60;Accept-Encoding: gzip&#x60; header to compress responses as a gzipped file. It can significantly reduce the bandwidth required for a response.   If specified, Zuora automatically compresses responses that contain over 1000 bytes of data, and the response contains a &#x60;Content-Encoding&#x60; header with the compression algorithm so that your client can decompress it.  | [optional] |
| **contentEncoding** | **String**| Include the &#x60;Content-Encoding: gzip&#x60; header to compress a request. With this header specified, you should upload a gzipped file for the request payload instead of sending the JSON payload.  | [optional] |
| **authorization** | **String**| The value is in the &#x60;Bearer {token}&#x60; format where {token} is a valid OAuth token generated by calling [Create an OAuth token](https://developer.zuora.com/api-references/api/operation/createToken).  | [optional] |
| **zuoraTrackId** | **String**| A custom identifier for tracing the API call. If you set a value for this header, Zuora returns the same value in the response headers. This header enables you to associate your system process identifiers with Zuora API calls, to assist with troubleshooting in the event of an issue.  The value of this field must use the US-ASCII character set and must not include any of the following characters: colon (&#x60;:&#x60;), semicolon (&#x60;;&#x60;), double quote (&#x60;\&quot;&#x60;), and quote (&#x60;&#39;&#x60;).  | [optional] |
| **zuoraEntityIds** | **String**| An entity ID. If you have [Zuora Multi-entity](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Multi-entity) enabled and the OAuth token is valid for more than one entity, you must use this header to specify which entity to perform the operation in. If the OAuth token is only valid for a single entity, or you do not have Zuora Multi-entity enabled, you do not need to set this header.  | [optional] |
| **zuoraOrgIds** | **String**| Comma separated IDs. If you have &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Central_Platform/Multi-Org\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Zuora Multi-Org&lt;/a&gt; enabled,  you can use this header to specify which orgs to perform the operation in. If you do not have Zuora Multi-Org enabled, you should not set this header.  The IDs must be a sub-set of the user&#39;s accessible orgs. If you specify an org that the user does not have access to, the operation fails.  If the header is not set, the operation is performed in scope of the user&#39;s accessible orgs.  | [optional] |
| **page** | **Integer**| The index number of the page that you want to retrieve. This parameter is dependent on &#x60;pageSize&#x60;. You must set &#x60;pageSize&#x60; before specifying &#x60;page&#x60;. For example, if you set &#x60;pageSize&#x60; to &#x60;20&#x60; and &#x60;page&#x60; to &#x60;2&#x60;, the 21st to 40th records are returned in the response.  | [optional] [default to 1] |
| **pageSize** | **Integer**| The number of records returned per page in the response.  | [optional] [default to 20] |

### Return type

[**GETPaymentPartsCollectionType**](GETPaymentPartsCollectionType.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** |  |  * Content-Encoding - This header is returned if you specify the &#x60;Accept-Encoding: gzip&#x60; request header and the response contains over 1000 bytes of data. Note that only the following MIME types support gzipped responses:   - &#x60;application/json&#x60;   - &#x60;application/xml&#x60;   - &#x60;text/html&#x60;   - &#x60;text/csv&#x60;   - &#x60;text/plain&#x60;  <br>  * RateLimit-Limit - The request limit quota for the time window closest to exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Remaining - The number of requests remaining in the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Reset - The number of seconds until the quota resets for the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Zuora-Request-Id - The Zuora internal identifier of the API call. You cannot control the value of this header.  <br>  * Zuora-Track-Id - A custom identifier for tracing the API call. If you specified a tracing identifier in the request headers, Zuora returns the same tracing identifier. Otherwise, Zuora does not set this header.  <br>  |

<a name="payment_0"></a>
# **payment_0**
> CommonResponse payment_0(paymentKey).acceptEncoding(acceptEncoding).contentEncoding(contentEncoding).authorization(authorization).zuoraTrackId(zuoraTrackId).zuoraEntityIds(zuoraEntityIds).zuoraOrgIds(zuoraOrgIds).execute();

Delete a payment

**Note:** This operation is only available if you have [Invoice Settlement](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/Invoice_Settlement) enabled. The Invoice Settlement feature is generally available as of Zuora Billing Release 296 (March 2021). This feature includes Unapplied Payments, Credit and Debit Memo, and Invoice Item Settlement. If you want to enable Invoice Settlement, see [Invoice Settlement Enablement and Checklist Guide](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/Invoice_Settlement/Invoice_Settlement_Migration_Checklist_and_Guide) for more information.   Deletes a payment. Only payments with the Cancelled status can be deleted.   If you have the Invoice Settlement feature enabled, overpayments applied to credit balance cannot be deleted. 

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Zuora;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.PaymentsApi;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Example {
  public static void main(String[] args) {
    Configuration configuration = new Configuration();
    configuration.host = "https://rest.zuora.com";
    Zuora client = new Zuora(configuration);
    String paymentKey = "paymentKey_example"; // The unique ID or number of an unapplied payment. For example, `8a8082e65b27f6c3015b89e4344c16b1`, or `P-00000001`. 
    String acceptEncoding = "acceptEncoding_example"; // Include the `Accept-Encoding: gzip` header to compress responses as a gzipped file. It can significantly reduce the bandwidth required for a response.   If specified, Zuora automatically compresses responses that contain over 1000 bytes of data, and the response contains a `Content-Encoding` header with the compression algorithm so that your client can decompress it. 
    String contentEncoding = "contentEncoding_example"; // Include the `Content-Encoding: gzip` header to compress a request. With this header specified, you should upload a gzipped file for the request payload instead of sending the JSON payload. 
    String authorization = "authorization_example"; // The value is in the `Bearer {token}` format where {token} is a valid OAuth token generated by calling [Create an OAuth token](https://developer.zuora.com/api-references/api/operation/createToken). 
    String zuoraTrackId = "zuoraTrackId_example"; // A custom identifier for tracing the API call. If you set a value for this header, Zuora returns the same value in the response headers. This header enables you to associate your system process identifiers with Zuora API calls, to assist with troubleshooting in the event of an issue.  The value of this field must use the US-ASCII character set and must not include any of the following characters: colon (`:`), semicolon (`;`), double quote (`\"`), and quote (`'`). 
    String zuoraEntityIds = "zuoraEntityIds_example"; // An entity ID. If you have [Zuora Multi-entity](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Multi-entity) enabled and the OAuth token is valid for more than one entity, you must use this header to specify which entity to perform the operation in. If the OAuth token is only valid for a single entity, or you do not have Zuora Multi-entity enabled, you do not need to set this header. 
    String zuoraOrgIds = "zuoraOrgIds_example"; // Comma separated IDs. If you have <a href=\"https://knowledgecenter.zuora.com/Zuora_Central_Platform/Multi-Org\" target=\"_blank\">Zuora Multi-Org</a> enabled,  you can use this header to specify which orgs to perform the operation in. If you do not have Zuora Multi-Org enabled, you should not set this header.  The IDs must be a sub-set of the user's accessible orgs. If you specify an org that the user does not have access to, the operation fails.  If the header is not set, the operation is performed in scope of the user's accessible orgs. 
    try {
      CommonResponse result = client
              .payments
              .payment_0(paymentKey)
              .acceptEncoding(acceptEncoding)
              .contentEncoding(contentEncoding)
              .authorization(authorization)
              .zuoraTrackId(zuoraTrackId)
              .zuoraEntityIds(zuoraEntityIds)
              .zuoraOrgIds(zuoraOrgIds)
              .execute();
      System.out.println(result);
      System.out.println(result.getProcessId());
      System.out.println(result.getReasons());
      System.out.println(result.getRequestId());
      System.out.println(result.getSuccess());
    } catch (ApiException e) {
      System.err.println("Exception when calling PaymentsApi#payment_0");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<CommonResponse> response = client
              .payments
              .payment_0(paymentKey)
              .acceptEncoding(acceptEncoding)
              .contentEncoding(contentEncoding)
              .authorization(authorization)
              .zuoraTrackId(zuoraTrackId)
              .zuoraEntityIds(zuoraEntityIds)
              .zuoraOrgIds(zuoraOrgIds)
              .executeWithHttpInfo();
      System.out.println(response.getResponseBody());
      System.out.println(response.getResponseHeaders());
      System.out.println(response.getStatusCode());
      System.out.println(response.getRoundTripTime());
      System.out.println(response.getRequest());
    } catch (ApiException e) {
      System.err.println("Exception when calling PaymentsApi#payment_0");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}

```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **paymentKey** | **String**| The unique ID or number of an unapplied payment. For example, &#x60;8a8082e65b27f6c3015b89e4344c16b1&#x60;, or &#x60;P-00000001&#x60;.  | |
| **acceptEncoding** | **String**| Include the &#x60;Accept-Encoding: gzip&#x60; header to compress responses as a gzipped file. It can significantly reduce the bandwidth required for a response.   If specified, Zuora automatically compresses responses that contain over 1000 bytes of data, and the response contains a &#x60;Content-Encoding&#x60; header with the compression algorithm so that your client can decompress it.  | [optional] |
| **contentEncoding** | **String**| Include the &#x60;Content-Encoding: gzip&#x60; header to compress a request. With this header specified, you should upload a gzipped file for the request payload instead of sending the JSON payload.  | [optional] |
| **authorization** | **String**| The value is in the &#x60;Bearer {token}&#x60; format where {token} is a valid OAuth token generated by calling [Create an OAuth token](https://developer.zuora.com/api-references/api/operation/createToken).  | [optional] |
| **zuoraTrackId** | **String**| A custom identifier for tracing the API call. If you set a value for this header, Zuora returns the same value in the response headers. This header enables you to associate your system process identifiers with Zuora API calls, to assist with troubleshooting in the event of an issue.  The value of this field must use the US-ASCII character set and must not include any of the following characters: colon (&#x60;:&#x60;), semicolon (&#x60;;&#x60;), double quote (&#x60;\&quot;&#x60;), and quote (&#x60;&#39;&#x60;).  | [optional] |
| **zuoraEntityIds** | **String**| An entity ID. If you have [Zuora Multi-entity](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Multi-entity) enabled and the OAuth token is valid for more than one entity, you must use this header to specify which entity to perform the operation in. If the OAuth token is only valid for a single entity, or you do not have Zuora Multi-entity enabled, you do not need to set this header.  | [optional] |
| **zuoraOrgIds** | **String**| Comma separated IDs. If you have &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Central_Platform/Multi-Org\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Zuora Multi-Org&lt;/a&gt; enabled,  you can use this header to specify which orgs to perform the operation in. If you do not have Zuora Multi-Org enabled, you should not set this header.  The IDs must be a sub-set of the user&#39;s accessible orgs. If you specify an org that the user does not have access to, the operation fails.  If the header is not set, the operation is performed in scope of the user&#39;s accessible orgs.  | [optional] |

### Return type

[**CommonResponse**](CommonResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** |  |  * Content-Encoding - This header is returned if you specify the &#x60;Accept-Encoding: gzip&#x60; request header and the response contains over 1000 bytes of data. Note that only the following MIME types support gzipped responses:   - &#x60;application/json&#x60;   - &#x60;application/xml&#x60;   - &#x60;text/html&#x60;   - &#x60;text/csv&#x60;   - &#x60;text/plain&#x60;  <br>  * RateLimit-Limit - The request limit quota for the time window closest to exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Remaining - The number of requests remaining in the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Reset - The number of seconds until the quota resets for the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Zuora-Request-Id - The Zuora internal identifier of the API call. You cannot control the value of this header.  <br>  * Zuora-Track-Id - A custom identifier for tracing the API call. If you specified a tracing identifier in the request headers, Zuora returns the same tracing identifier. Otherwise, Zuora does not set this header.  <br>  |

<a name="refundPayment"></a>
# **refundPayment**
> GETRefundPaymentType refundPayment(paymentKey, postRefundType).idempotencyKey(idempotencyKey).acceptEncoding(acceptEncoding).contentEncoding(contentEncoding).authorization(authorization).zuoraTrackId(zuoraTrackId).zuoraEntityIds(zuoraEntityIds).zuoraOrgIds(zuoraOrgIds).execute();

Refund a payment

**Note:** This operation is only available if you have [Invoice Settlement](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/Invoice_Settlement) enabled. The Invoice Settlement feature is generally available as of Zuora Billing Release 296 (March 2021). This feature includes Unapplied Payments, Credit and Debit Memo, and Invoice Item Settlement. If you want to enable Invoice Settlement, see [Invoice Settlement Enablement and Checklist Guide](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/Invoice_Settlement/Invoice_Settlement_Migration_Checklist_and_Guide) for more information.   Refunds a full or partial unapplied payment to your customers. To refund applied payments, you must unapply the applied payments from the invoices or debit memos, and then refund the unapplied payments to customers.  For more information, see [Refund Payments](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/Invoice_Settlement/A_Unapplied_Payments/Management_of_Unapplied_Payments/Y_Refund_Payments). 

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Zuora;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.PaymentsApi;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Example {
  public static void main(String[] args) {
    Configuration configuration = new Configuration();
    configuration.host = "https://rest.zuora.com";
    Zuora client = new Zuora(configuration);
    String paymentKey = "paymentKey_example"; // The unique ID or number of an unapplied payment. For example, `8a8082e65b27f6c3015b89e4344c16b1`, or `P-00000001`. 
    String comment = "comment_example"; // Comments about the refund. 
    List<PaymentWithCustomRatesType> customRates = Arrays.asList(); // It contains Home currency and Reporting currency custom rates currencies. The maximum number of items is 2 (you can pass the Home currency item, Reporting currency item, or both).  **Note**: The API custom rate feature is permission controlled. 
    PostRefundTypeAllOfFinanceInformation financeInformation = new PostRefundTypeAllOfFinanceInformation();
    PostRefundTypeAllOfGatewayOptions gatewayOptions = new PostRefundTypeAllOfGatewayOptions();
    String methodType = "ACH"; // How an external refund was issued to a customer. This field is required for an external refund and must be left empty for an electronic refund. You can issue an external refund on an electronic payment. 
    String reasonCode = "reasonCode_example"; // A code identifying the reason for the transaction. The value must be an existing reason code or empty. If you do not specify a value, Zuora uses the default reason code. 
    String referenceId = "referenceId_example"; // The transaction ID returned by the payment gateway for an electronic refund. Use this field to reconcile refunds between your gateway and Zuora Payments. 
    LocalDate refundDate = LocalDate.now(); // The date when the refund takes effect, in `yyyy-mm-dd` format. The date of the refund cannot be before the payment date. Specify this field only for external refunds. Zuora automatically generates this field for electronic refunds. 
    String secondRefundReferenceId = "secondRefundReferenceId_example"; // The transaction ID returned by the payment gateway if there is an additional transaction for the refund. Use this field to reconcile payments between your gateway and Zuora Payments. 
    String softDescriptor = "softDescriptor_example"; // A payment gateway-specific field that maps to Zuora for the gateways, Orbital, Vantiv and Verifi.
    String softDescriptorPhone = "softDescriptorPhone_example"; // A payment gateway-specific field that maps to Zuora for the gateways, Orbital, Vantiv and Verifi.
    Double totalAmount = 3.4D; // The total amount of the refund. The amount cannot exceed the unapplied amount of the associated payment. If the original payment was applied to one or more invoices or debit memos, you have to unapply a full or partial payment from the invoices or debit memos, and then refund the full or partial unapplied payment to your customers.  
    String type = "External"; // The type of the refund. 
    String refundTransactionType = "Chargeback"; // The transaction type of the refund. 
    String integrationIdNS = "integrationIdNS_example"; // ID of the corresponding object in NetSuite. Only available if you have installed the [Zuora Connector for NetSuite](https://www.zuora.com/connect/app/?appId=265). 
    String integrationStatusNS = "integrationStatusNS_example"; // Status of the refund's synchronization with NetSuite. Only available if you have installed the [Zuora Connector for NetSuite](https://www.zuora.com/connect/app/?appId=265). 
    String originNS = "originNS_example"; // Origin of the corresponding object in NetSuite. Only available if you have installed the [Zuora Connector for NetSuite](https://www.zuora.com/connect/app/?appId=265). 
    String syncDateNS = "syncDateNS_example"; // Date when the refund was synchronized with NetSuite. Only available if you have installed the [Zuora Connector for NetSuite](https://www.zuora.com/connect/app/?appId=265). 
    String synctoNetSuiteNS = "synctoNetSuiteNS_example"; // Specifies whether the refund should be synchronized with NetSuite. Only available if you have installed the [Zuora Connector for NetSuite](https://www.zuora.com/connect/app/?appId=265). 
    String idempotencyKey = "idempotencyKey_example"; // Specify a unique idempotency key if you want to perform an idempotent POST or PATCH request. Do not use this header in other request types.   With this header specified, the Zuora server can identify subsequent retries of the same request using this value, which prevents the same operation from being performed multiple times by accident.  
    String acceptEncoding = "acceptEncoding_example"; // Include the `Accept-Encoding: gzip` header to compress responses as a gzipped file. It can significantly reduce the bandwidth required for a response.   If specified, Zuora automatically compresses responses that contain over 1000 bytes of data, and the response contains a `Content-Encoding` header with the compression algorithm so that your client can decompress it. 
    String contentEncoding = "contentEncoding_example"; // Include the `Content-Encoding: gzip` header to compress a request. With this header specified, you should upload a gzipped file for the request payload instead of sending the JSON payload. 
    String authorization = "authorization_example"; // The value is in the `Bearer {token}` format where {token} is a valid OAuth token generated by calling [Create an OAuth token](https://developer.zuora.com/api-references/api/operation/createToken). 
    String zuoraTrackId = "zuoraTrackId_example"; // A custom identifier for tracing the API call. If you set a value for this header, Zuora returns the same value in the response headers. This header enables you to associate your system process identifiers with Zuora API calls, to assist with troubleshooting in the event of an issue.  The value of this field must use the US-ASCII character set and must not include any of the following characters: colon (`:`), semicolon (`;`), double quote (`\"`), and quote (`'`). 
    String zuoraEntityIds = "zuoraEntityIds_example"; // An entity ID. If you have [Zuora Multi-entity](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Multi-entity) enabled and the OAuth token is valid for more than one entity, you must use this header to specify which entity to perform the operation in. If the OAuth token is only valid for a single entity, or you do not have Zuora Multi-entity enabled, you do not need to set this header. 
    String zuoraOrgIds = "zuoraOrgIds_example"; // Comma separated IDs. If you have <a href=\"https://knowledgecenter.zuora.com/Zuora_Central_Platform/Multi-Org\" target=\"_blank\">Zuora Multi-Org</a> enabled,  you can use this header to specify which orgs to perform the operation in. If you do not have Zuora Multi-Org enabled, you should not set this header.  The IDs must be a sub-set of the user's accessible orgs. If you specify an org that the user does not have access to, the operation fails.  If the header is not set, the operation is performed in scope of the user's accessible orgs. 
    try {
      GETRefundPaymentType result = client
              .payments
              .refundPayment(paymentKey)
              .comment(comment)
              .customRates(customRates)
              .financeInformation(financeInformation)
              .gatewayOptions(gatewayOptions)
              .methodType(methodType)
              .reasonCode(reasonCode)
              .referenceId(referenceId)
              .refundDate(refundDate)
              .secondRefundReferenceId(secondRefundReferenceId)
              .softDescriptor(softDescriptor)
              .softDescriptorPhone(softDescriptorPhone)
              .totalAmount(totalAmount)
              .type(type)
              .refundTransactionType(refundTransactionType)
              .integrationIdNS(integrationIdNS)
              .integrationStatusNS(integrationStatusNS)
              .originNS(originNS)
              .syncDateNS(syncDateNS)
              .synctoNetSuiteNS(synctoNetSuiteNS)
              .idempotencyKey(idempotencyKey)
              .acceptEncoding(acceptEncoding)
              .contentEncoding(contentEncoding)
              .authorization(authorization)
              .zuoraTrackId(zuoraTrackId)
              .zuoraEntityIds(zuoraEntityIds)
              .zuoraOrgIds(zuoraOrgIds)
              .execute();
      System.out.println(result);
      System.out.println(result.getAccountId());
      System.out.println(result.getAmount());
      System.out.println(result.getCancelledOn());
      System.out.println(result.getComment());
      System.out.println(result.getCreatedById());
      System.out.println(result.getCreatedDate());
      System.out.println(result.getCreditMemoId());
      System.out.println(result.getFinanceInformation());
      System.out.println(result.getGatewayId());
      System.out.println(result.getGatewayReconciliationReason());
      System.out.println(result.getGatewayReconciliationStatus());
      System.out.println(result.getGatewayResponse());
      System.out.println(result.getGatewayResponseCode());
      System.out.println(result.getGatewayState());
      System.out.println(result.getId());
      System.out.println(result.getMarkedForSubmissionOn());
      System.out.println(result.getMethodType());
      System.out.println(result.getNumber());
      System.out.println(result.getOrganizationLabel());
      System.out.println(result.getPaymentGatewayNumber());
      System.out.println(result.getPaymentId());
      System.out.println(result.getPaymentMethodId());
      System.out.println(result.getPaymentMethodSnapshotId());
      System.out.println(result.getPayoutId());
      System.out.println(result.getReasonCode());
      System.out.println(result.getReferenceId());
      System.out.println(result.getRefundDate());
      System.out.println(result.getRefundTransactionTime());
      System.out.println(result.getSecondRefundReferenceId());
      System.out.println(result.getSettledOn());
      System.out.println(result.getSoftDescriptor());
      System.out.println(result.getSoftDescriptorPhone());
      System.out.println(result.getStatus());
      System.out.println(result.getSubmittedOn());
      System.out.println(result.getSuccess());
      System.out.println(result.getType());
      System.out.println(result.getUpdatedById());
      System.out.println(result.getUpdatedDate());
      System.out.println(result.getIntegrationIdNS());
      System.out.println(result.getIntegrationStatusNS());
      System.out.println(result.getOriginNS());
      System.out.println(result.getSyncDateNS());
      System.out.println(result.getSynctoNetSuiteNS());
    } catch (ApiException e) {
      System.err.println("Exception when calling PaymentsApi#refundPayment");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<GETRefundPaymentType> response = client
              .payments
              .refundPayment(paymentKey)
              .comment(comment)
              .customRates(customRates)
              .financeInformation(financeInformation)
              .gatewayOptions(gatewayOptions)
              .methodType(methodType)
              .reasonCode(reasonCode)
              .referenceId(referenceId)
              .refundDate(refundDate)
              .secondRefundReferenceId(secondRefundReferenceId)
              .softDescriptor(softDescriptor)
              .softDescriptorPhone(softDescriptorPhone)
              .totalAmount(totalAmount)
              .type(type)
              .refundTransactionType(refundTransactionType)
              .integrationIdNS(integrationIdNS)
              .integrationStatusNS(integrationStatusNS)
              .originNS(originNS)
              .syncDateNS(syncDateNS)
              .synctoNetSuiteNS(synctoNetSuiteNS)
              .idempotencyKey(idempotencyKey)
              .acceptEncoding(acceptEncoding)
              .contentEncoding(contentEncoding)
              .authorization(authorization)
              .zuoraTrackId(zuoraTrackId)
              .zuoraEntityIds(zuoraEntityIds)
              .zuoraOrgIds(zuoraOrgIds)
              .executeWithHttpInfo();
      System.out.println(response.getResponseBody());
      System.out.println(response.getResponseHeaders());
      System.out.println(response.getStatusCode());
      System.out.println(response.getRoundTripTime());
      System.out.println(response.getRequest());
    } catch (ApiException e) {
      System.err.println("Exception when calling PaymentsApi#refundPayment");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}

```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **paymentKey** | **String**| The unique ID or number of an unapplied payment. For example, &#x60;8a8082e65b27f6c3015b89e4344c16b1&#x60;, or &#x60;P-00000001&#x60;.  | |
| **postRefundType** | [**PostRefundType**](PostRefundType.md)|  | |
| **idempotencyKey** | **String**| Specify a unique idempotency key if you want to perform an idempotent POST or PATCH request. Do not use this header in other request types.   With this header specified, the Zuora server can identify subsequent retries of the same request using this value, which prevents the same operation from being performed multiple times by accident.   | [optional] |
| **acceptEncoding** | **String**| Include the &#x60;Accept-Encoding: gzip&#x60; header to compress responses as a gzipped file. It can significantly reduce the bandwidth required for a response.   If specified, Zuora automatically compresses responses that contain over 1000 bytes of data, and the response contains a &#x60;Content-Encoding&#x60; header with the compression algorithm so that your client can decompress it.  | [optional] |
| **contentEncoding** | **String**| Include the &#x60;Content-Encoding: gzip&#x60; header to compress a request. With this header specified, you should upload a gzipped file for the request payload instead of sending the JSON payload.  | [optional] |
| **authorization** | **String**| The value is in the &#x60;Bearer {token}&#x60; format where {token} is a valid OAuth token generated by calling [Create an OAuth token](https://developer.zuora.com/api-references/api/operation/createToken).  | [optional] |
| **zuoraTrackId** | **String**| A custom identifier for tracing the API call. If you set a value for this header, Zuora returns the same value in the response headers. This header enables you to associate your system process identifiers with Zuora API calls, to assist with troubleshooting in the event of an issue.  The value of this field must use the US-ASCII character set and must not include any of the following characters: colon (&#x60;:&#x60;), semicolon (&#x60;;&#x60;), double quote (&#x60;\&quot;&#x60;), and quote (&#x60;&#39;&#x60;).  | [optional] |
| **zuoraEntityIds** | **String**| An entity ID. If you have [Zuora Multi-entity](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Multi-entity) enabled and the OAuth token is valid for more than one entity, you must use this header to specify which entity to perform the operation in. If the OAuth token is only valid for a single entity, or you do not have Zuora Multi-entity enabled, you do not need to set this header.  | [optional] |
| **zuoraOrgIds** | **String**| Comma separated IDs. If you have &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Central_Platform/Multi-Org\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Zuora Multi-Org&lt;/a&gt; enabled,  you can use this header to specify which orgs to perform the operation in. If you do not have Zuora Multi-Org enabled, you should not set this header.  The IDs must be a sub-set of the user&#39;s accessible orgs. If you specify an org that the user does not have access to, the operation fails.  If the header is not set, the operation is performed in scope of the user&#39;s accessible orgs.  | [optional] |

### Return type

[**GETRefundPaymentType**](GETRefundPaymentType.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** |  |  * Content-Encoding - This header is returned if you specify the &#x60;Accept-Encoding: gzip&#x60; request header and the response contains over 1000 bytes of data. Note that only the following MIME types support gzipped responses:   - &#x60;application/json&#x60;   - &#x60;application/xml&#x60;   - &#x60;text/html&#x60;   - &#x60;text/csv&#x60;   - &#x60;text/plain&#x60;  <br>  * RateLimit-Limit - The request limit quota for the time window closest to exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Remaining - The number of requests remaining in the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Reset - The number of seconds until the quota resets for the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Zuora-Request-Id - The Zuora internal identifier of the API call. You cannot control the value of this header.  <br>  * Zuora-Track-Id - A custom identifier for tracing the API call. If you specified a tracing identifier in the request headers, Zuora returns the same tracing identifier. Otherwise, Zuora does not set this header.  <br>  |

<a name="refundPaymentwithAutoUnapply"></a>
# **refundPaymentwithAutoUnapply**
> GETRefundPaymentTypeAutoUnapply refundPaymentwithAutoUnapply(paymentKey, postRefundwithAutoUnapplyType).idempotencyKey(idempotencyKey).acceptEncoding(acceptEncoding).contentEncoding(contentEncoding).authorization(authorization).zuoraTrackId(zuoraTrackId).zuoraEntityIds(zuoraEntityIds).zuoraOrgIds(zuoraOrgIds).execute();

Refund a payment with auto-unapplying

**Note:** This operation is only available if you have [Invoice Settlement](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/Invoice_Settlement) enabled. The Invoice Settlement feature is generally available as of Zuora Billing Release 296 (March 2021). This feature includes Unapplied Payments, Credit and Debit Memo, and Invoice Item Settlement. If you want to enable Invoice Settlement, see [Invoice Settlement Enablement and Checklist Guide](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/Invoice_Settlement/Invoice_Settlement_Migration_Checklist_and_Guide) for more information.   Refunds a full or partial unapplied payment to your customers, without the need to unapply the payment first, followed by processing the refund. To refund applied payments, you can now leverage this API to unapply and refund the payment simultaneously.  For more information, see [Refund Payments](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/Invoice_Settlement/A_Unapplied_Payments/Management_of_Unapplied_Payments/Y_Refund_Payments). 

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Zuora;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.PaymentsApi;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Example {
  public static void main(String[] args) {
    Configuration configuration = new Configuration();
    configuration.host = "https://rest.zuora.com";
    Zuora client = new Zuora(configuration);
    String paymentKey = "paymentKey_example"; // The unique ID or number of an unapplied payment. For example, `8a8082e65b27f6c3015b89e4344c16b1`, or `P-00000001`. 
    String comment = "comment_example"; // Comments about the refund. 
    List<PaymentDebitMemoApplicationApplyRequestType> debitMemos = Arrays.asList(); // Container for debit memos. The maximum number of debit memos is 1,000. 
    PostRefundTypeAllOfFinanceInformation financeInformation = new PostRefundTypeAllOfFinanceInformation();
    PostRefundTypeAllOfGatewayOptions gatewayOptions = new PostRefundTypeAllOfGatewayOptions();
    List<PaymentInvoiceApplicationApplyRequestType> invoices = Arrays.asList(); // Container for invoices. The maximum number of invoices is 1,000. 
    String methodType = "ACH"; // How an external refund was issued to a customer. This field is required for an external refund and must be left empty for an electronic refund. You can issue an external refund on an electronic payment. 
    String reasonCode = "reasonCode_example"; // A code identifying the reason for the transaction. The value must be an existing reason code or empty. If you do not specify a value, Zuora uses the default reason code. 
    String referenceId = "referenceId_example"; // The transaction ID returned by the payment gateway for an electronic refund. Use this field to reconcile refunds between your gateway and Zuora Payments. 
    LocalDate refundDate = LocalDate.now(); // The date when the refund takes effect, in `yyyy-mm-dd` format. The date of the refund cannot be before the payment date. Specify this field only for external refunds. Zuora automatically generates this field for electronic refunds. 
    String secondRefundReferenceId = "secondRefundReferenceId_example"; // The transaction ID returned by the payment gateway if there is an additional transaction for the refund. Use this field to reconcile payments between your gateway and Zuora Payments. 
    String softDescriptor = "softDescriptor_example"; // A payment gateway-specific field that maps to Zuora for the gateways, Orbital, Vantiv and Verifi.
    String softDescriptorPhone = "softDescriptorPhone_example"; // A payment gateway-specific field that maps to Zuora for the gateways, Orbital, Vantiv and Verifi.
    Double totalAmount = 3.4D; // The total amount of the refund. If you do not specify a value, Zuora initiates a full refund of the payment amount, which is the sum of the applied and unapplied payment amounts.    - `Full Refund`: If the refund amount and debit memo/ invoice are not specified, then the payment will be unapplied completely, followed by processing a full refund.   - `Partial Refund`:        - If the total amount is specified, and the debit memo/invoice is not specified, you can unapply the refund amount from the available debit memo/invoice and refund the unapplied payment to the customer.        - If the total amount is specified, along with the debit memo and the invoice, you can unapply the applied payments from the mentioned invoices and debit memos, and refund the unapplied payments to customers.   
    String type = "External"; // The type of the refund. 
    String refundTransactionType = "Chargeback"; // The transaction type of the refund. 
    Boolean writeOff = false; // Indicates whether to write off a document. 
    PostRefundwithAutoUnapplyTypeAllOfWriteOffOptions writeOffOptions = new PostRefundwithAutoUnapplyTypeAllOfWriteOffOptions();
    String integrationIdNS = "integrationIdNS_example"; // ID of the corresponding object in NetSuite. Only available if you have installed the [Zuora Connector for NetSuite](https://www.zuora.com/connect/app/?appId=265). 
    String integrationStatusNS = "integrationStatusNS_example"; // Status of the refund's synchronization with NetSuite. Only available if you have installed the [Zuora Connector for NetSuite](https://www.zuora.com/connect/app/?appId=265). 
    String originNS = "originNS_example"; // Origin of the corresponding object in NetSuite. Only available if you have installed the [Zuora Connector for NetSuite](https://www.zuora.com/connect/app/?appId=265). 
    String syncDateNS = "syncDateNS_example"; // Date when the refund was synchronized with NetSuite. Only available if you have installed the [Zuora Connector for NetSuite](https://www.zuora.com/connect/app/?appId=265). 
    String synctoNetSuiteNS = "synctoNetSuiteNS_example"; // Specifies whether the refund should be synchronized with NetSuite. Only available if you have installed the [Zuora Connector for NetSuite](https://www.zuora.com/connect/app/?appId=265). 
    String idempotencyKey = "idempotencyKey_example"; // Specify a unique idempotency key if you want to perform an idempotent POST or PATCH request. Do not use this header in other request types.   With this header specified, the Zuora server can identify subsequent retries of the same request using this value, which prevents the same operation from being performed multiple times by accident.  
    String acceptEncoding = "acceptEncoding_example"; // Include the `Accept-Encoding: gzip` header to compress responses as a gzipped file. It can significantly reduce the bandwidth required for a response.   If specified, Zuora automatically compresses responses that contain over 1000 bytes of data, and the response contains a `Content-Encoding` header with the compression algorithm so that your client can decompress it. 
    String contentEncoding = "contentEncoding_example"; // Include the `Content-Encoding: gzip` header to compress a request. With this header specified, you should upload a gzipped file for the request payload instead of sending the JSON payload. 
    String authorization = "authorization_example"; // The value is in the `Bearer {token}` format where {token} is a valid OAuth token generated by calling [Create an OAuth token](https://developer.zuora.com/api-references/api/operation/createToken). 
    String zuoraTrackId = "zuoraTrackId_example"; // A custom identifier for tracing the API call. If you set a value for this header, Zuora returns the same value in the response headers. This header enables you to associate your system process identifiers with Zuora API calls, to assist with troubleshooting in the event of an issue.  The value of this field must use the US-ASCII character set and must not include any of the following characters: colon (`:`), semicolon (`;`), double quote (`\"`), and quote (`'`). 
    String zuoraEntityIds = "zuoraEntityIds_example"; // An entity ID. If you have [Zuora Multi-entity](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Multi-entity) enabled and the OAuth token is valid for more than one entity, you must use this header to specify which entity to perform the operation in. If the OAuth token is only valid for a single entity, or you do not have Zuora Multi-entity enabled, you do not need to set this header. 
    String zuoraOrgIds = "zuoraOrgIds_example"; // Comma separated IDs. If you have <a href=\"https://knowledgecenter.zuora.com/Zuora_Central_Platform/Multi-Org\" target=\"_blank\">Zuora Multi-Org</a> enabled,  you can use this header to specify which orgs to perform the operation in. If you do not have Zuora Multi-Org enabled, you should not set this header.  The IDs must be a sub-set of the user's accessible orgs. If you specify an org that the user does not have access to, the operation fails.  If the header is not set, the operation is performed in scope of the user's accessible orgs. 
    try {
      GETRefundPaymentTypeAutoUnapply result = client
              .payments
              .refundPaymentwithAutoUnapply(paymentKey)
              .comment(comment)
              .debitMemos(debitMemos)
              .financeInformation(financeInformation)
              .gatewayOptions(gatewayOptions)
              .invoices(invoices)
              .methodType(methodType)
              .reasonCode(reasonCode)
              .referenceId(referenceId)
              .refundDate(refundDate)
              .secondRefundReferenceId(secondRefundReferenceId)
              .softDescriptor(softDescriptor)
              .softDescriptorPhone(softDescriptorPhone)
              .totalAmount(totalAmount)
              .type(type)
              .refundTransactionType(refundTransactionType)
              .writeOff(writeOff)
              .writeOffOptions(writeOffOptions)
              .integrationIdNS(integrationIdNS)
              .integrationStatusNS(integrationStatusNS)
              .originNS(originNS)
              .syncDateNS(syncDateNS)
              .synctoNetSuiteNS(synctoNetSuiteNS)
              .idempotencyKey(idempotencyKey)
              .acceptEncoding(acceptEncoding)
              .contentEncoding(contentEncoding)
              .authorization(authorization)
              .zuoraTrackId(zuoraTrackId)
              .zuoraEntityIds(zuoraEntityIds)
              .zuoraOrgIds(zuoraOrgIds)
              .execute();
      System.out.println(result);
      System.out.println(result.getAccountId());
      System.out.println(result.getAmount());
      System.out.println(result.getCancelledOn());
      System.out.println(result.getComment());
      System.out.println(result.getCreatedById());
      System.out.println(result.getCreatedDate());
      System.out.println(result.getCreditMemoId());
      System.out.println(result.getFinanceInformation());
      System.out.println(result.getGatewayId());
      System.out.println(result.getGatewayReconciliationReason());
      System.out.println(result.getGatewayReconciliationStatus());
      System.out.println(result.getGatewayResponse());
      System.out.println(result.getGatewayResponseCode());
      System.out.println(result.getGatewayState());
      System.out.println(result.getId());
      System.out.println(result.getMarkedForSubmissionOn());
      System.out.println(result.getMethodType());
      System.out.println(result.getNumber());
      System.out.println(result.getPaymentGatewayNumber());
      System.out.println(result.getPaymentId());
      System.out.println(result.getPaymentMethodId());
      System.out.println(result.getPaymentMethodSnapshotId());
      System.out.println(result.getPayoutId());
      System.out.println(result.getReasonCode());
      System.out.println(result.getReferenceId());
      System.out.println(result.getRefundDate());
      System.out.println(result.getRefundTransactionTime());
      System.out.println(result.getSecondRefundReferenceId());
      System.out.println(result.getSettledOn());
      System.out.println(result.getSoftDescriptor());
      System.out.println(result.getSoftDescriptorPhone());
      System.out.println(result.getStatus());
      System.out.println(result.getSubmittedOn());
      System.out.println(result.getSuccess());
      System.out.println(result.getType());
      System.out.println(result.getUpdatedById());
      System.out.println(result.getUpdatedDate());
      System.out.println(result.getWriteOffResults());
      System.out.println(result.getIntegrationIdNS());
      System.out.println(result.getIntegrationStatusNS());
      System.out.println(result.getOriginNS());
      System.out.println(result.getSyncDateNS());
      System.out.println(result.getSynctoNetSuiteNS());
    } catch (ApiException e) {
      System.err.println("Exception when calling PaymentsApi#refundPaymentwithAutoUnapply");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<GETRefundPaymentTypeAutoUnapply> response = client
              .payments
              .refundPaymentwithAutoUnapply(paymentKey)
              .comment(comment)
              .debitMemos(debitMemos)
              .financeInformation(financeInformation)
              .gatewayOptions(gatewayOptions)
              .invoices(invoices)
              .methodType(methodType)
              .reasonCode(reasonCode)
              .referenceId(referenceId)
              .refundDate(refundDate)
              .secondRefundReferenceId(secondRefundReferenceId)
              .softDescriptor(softDescriptor)
              .softDescriptorPhone(softDescriptorPhone)
              .totalAmount(totalAmount)
              .type(type)
              .refundTransactionType(refundTransactionType)
              .writeOff(writeOff)
              .writeOffOptions(writeOffOptions)
              .integrationIdNS(integrationIdNS)
              .integrationStatusNS(integrationStatusNS)
              .originNS(originNS)
              .syncDateNS(syncDateNS)
              .synctoNetSuiteNS(synctoNetSuiteNS)
              .idempotencyKey(idempotencyKey)
              .acceptEncoding(acceptEncoding)
              .contentEncoding(contentEncoding)
              .authorization(authorization)
              .zuoraTrackId(zuoraTrackId)
              .zuoraEntityIds(zuoraEntityIds)
              .zuoraOrgIds(zuoraOrgIds)
              .executeWithHttpInfo();
      System.out.println(response.getResponseBody());
      System.out.println(response.getResponseHeaders());
      System.out.println(response.getStatusCode());
      System.out.println(response.getRoundTripTime());
      System.out.println(response.getRequest());
    } catch (ApiException e) {
      System.err.println("Exception when calling PaymentsApi#refundPaymentwithAutoUnapply");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}

```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **paymentKey** | **String**| The unique ID or number of an unapplied payment. For example, &#x60;8a8082e65b27f6c3015b89e4344c16b1&#x60;, or &#x60;P-00000001&#x60;.  | |
| **postRefundwithAutoUnapplyType** | [**PostRefundwithAutoUnapplyType**](PostRefundwithAutoUnapplyType.md)|  | |
| **idempotencyKey** | **String**| Specify a unique idempotency key if you want to perform an idempotent POST or PATCH request. Do not use this header in other request types.   With this header specified, the Zuora server can identify subsequent retries of the same request using this value, which prevents the same operation from being performed multiple times by accident.   | [optional] |
| **acceptEncoding** | **String**| Include the &#x60;Accept-Encoding: gzip&#x60; header to compress responses as a gzipped file. It can significantly reduce the bandwidth required for a response.   If specified, Zuora automatically compresses responses that contain over 1000 bytes of data, and the response contains a &#x60;Content-Encoding&#x60; header with the compression algorithm so that your client can decompress it.  | [optional] |
| **contentEncoding** | **String**| Include the &#x60;Content-Encoding: gzip&#x60; header to compress a request. With this header specified, you should upload a gzipped file for the request payload instead of sending the JSON payload.  | [optional] |
| **authorization** | **String**| The value is in the &#x60;Bearer {token}&#x60; format where {token} is a valid OAuth token generated by calling [Create an OAuth token](https://developer.zuora.com/api-references/api/operation/createToken).  | [optional] |
| **zuoraTrackId** | **String**| A custom identifier for tracing the API call. If you set a value for this header, Zuora returns the same value in the response headers. This header enables you to associate your system process identifiers with Zuora API calls, to assist with troubleshooting in the event of an issue.  The value of this field must use the US-ASCII character set and must not include any of the following characters: colon (&#x60;:&#x60;), semicolon (&#x60;;&#x60;), double quote (&#x60;\&quot;&#x60;), and quote (&#x60;&#39;&#x60;).  | [optional] |
| **zuoraEntityIds** | **String**| An entity ID. If you have [Zuora Multi-entity](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Multi-entity) enabled and the OAuth token is valid for more than one entity, you must use this header to specify which entity to perform the operation in. If the OAuth token is only valid for a single entity, or you do not have Zuora Multi-entity enabled, you do not need to set this header.  | [optional] |
| **zuoraOrgIds** | **String**| Comma separated IDs. If you have &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Central_Platform/Multi-Org\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Zuora Multi-Org&lt;/a&gt; enabled,  you can use this header to specify which orgs to perform the operation in. If you do not have Zuora Multi-Org enabled, you should not set this header.  The IDs must be a sub-set of the user&#39;s accessible orgs. If you specify an org that the user does not have access to, the operation fails.  If the header is not set, the operation is performed in scope of the user&#39;s accessible orgs.  | [optional] |

### Return type

[**GETRefundPaymentTypeAutoUnapply**](GETRefundPaymentTypeAutoUnapply.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** |  |  * Content-Encoding - This header is returned if you specify the &#x60;Accept-Encoding: gzip&#x60; request header and the response contains over 1000 bytes of data. Note that only the following MIME types support gzipped responses:   - &#x60;application/json&#x60;   - &#x60;application/xml&#x60;   - &#x60;text/html&#x60;   - &#x60;text/csv&#x60;   - &#x60;text/plain&#x60;  <br>  * RateLimit-Limit - The request limit quota for the time window closest to exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Remaining - The number of requests remaining in the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Reset - The number of seconds until the quota resets for the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Zuora-Request-Id - The Zuora internal identifier of the API call. You cannot control the value of this header.  <br>  * Zuora-Track-Id - A custom identifier for tracing the API call. If you specified a tracing identifier in the request headers, Zuora returns the same tracing identifier. Otherwise, Zuora does not set this header.  <br>  |

<a name="retrieveAllPayments"></a>
# **retrieveAllPayments**
> PaymentCollectionResponseType retrieveAllPayments().acceptEncoding(acceptEncoding).contentEncoding(contentEncoding).authorization(authorization).zuoraTrackId(zuoraTrackId).zuoraEntityIds(zuoraEntityIds).zuoraOrgIds(zuoraOrgIds).page(page).pageSize(pageSize).accountId(accountId).amount(amount).appliedAmount(appliedAmount).createdById(createdById).createdDate(createdDate).creditBalanceAmount(creditBalanceAmount).currency(currency).effectiveDate(effectiveDate).number(number).refundAmount(refundAmount).status(status).type(type).unappliedAmount(unappliedAmount).updatedById(updatedById).updatedDate(updatedDate).sort(sort).execute();

List payments

**Note:** This operation is only available if you have [Invoice Settlement](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/Invoice_Settlement) enabled. The Invoice Settlement feature is generally available as of Zuora Billing Release 296 (March 2021). This feature includes Unapplied Payments, Credit and Debit Memo, and Invoice Item Settlement. If you want to enable Invoice Settlement, see [Invoice Settlement Enablement and Checklist Guide](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/Invoice_Settlement/Invoice_Settlement_Migration_Checklist_and_Guide) for more information.   Retrieves the information about all payments from all your customer accounts.  ### Filtering  You can use query parameters to restrict the data returned in the response. Each query parameter corresponds to one field in the response body.  If the value of a filterable field is string, you can set the corresponding query parameter to &#x60;null&#x60; when filtering. Then, you can get the response data with this field value being &#x60;null&#x60;.  Examples:  - /v1/payments?status&#x3D;Processed  - /v1/payments?currency&#x3D;USD&amp;status&#x3D;Processed  - /v1/payments?status&#x3D;Processed&amp;type&#x3D;External&amp;sort&#x3D;+number 

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Zuora;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.PaymentsApi;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Example {
  public static void main(String[] args) {
    Configuration configuration = new Configuration();
    configuration.host = "https://rest.zuora.com";
    Zuora client = new Zuora(configuration);
    String acceptEncoding = "acceptEncoding_example"; // Include the `Accept-Encoding: gzip` header to compress responses as a gzipped file. It can significantly reduce the bandwidth required for a response.   If specified, Zuora automatically compresses responses that contain over 1000 bytes of data, and the response contains a `Content-Encoding` header with the compression algorithm so that your client can decompress it. 
    String contentEncoding = "contentEncoding_example"; // Include the `Content-Encoding: gzip` header to compress a request. With this header specified, you should upload a gzipped file for the request payload instead of sending the JSON payload. 
    String authorization = "authorization_example"; // The value is in the `Bearer {token}` format where {token} is a valid OAuth token generated by calling [Create an OAuth token](https://developer.zuora.com/api-references/api/operation/createToken). 
    String zuoraTrackId = "zuoraTrackId_example"; // A custom identifier for tracing the API call. If you set a value for this header, Zuora returns the same value in the response headers. This header enables you to associate your system process identifiers with Zuora API calls, to assist with troubleshooting in the event of an issue.  The value of this field must use the US-ASCII character set and must not include any of the following characters: colon (`:`), semicolon (`;`), double quote (`\"`), and quote (`'`). 
    String zuoraEntityIds = "zuoraEntityIds_example"; // An entity ID. If you have [Zuora Multi-entity](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Multi-entity) enabled and the OAuth token is valid for more than one entity, you must use this header to specify which entity to perform the operation in. If the OAuth token is only valid for a single entity, or you do not have Zuora Multi-entity enabled, you do not need to set this header. 
    String zuoraOrgIds = "zuoraOrgIds_example"; // Comma separated IDs. If you have <a href=\"https://knowledgecenter.zuora.com/Zuora_Central_Platform/Multi-Org\" target=\"_blank\">Zuora Multi-Org</a> enabled,  you can use this header to specify which orgs to perform the operation in. If you do not have Zuora Multi-Org enabled, you should not set this header.  The IDs must be a sub-set of the user's accessible orgs. If you specify an org that the user does not have access to, the operation fails.  If the header is not set, the operation is performed in scope of the user's accessible orgs. 
    Integer page = 1; // The index number of the page that you want to retrieve. This parameter is dependent on `pageSize`. You must set `pageSize` before specifying `page`. For example, if you set `pageSize` to `20` and `page` to `2`, the 21st to 40th records are returned in the response. 
    Integer pageSize = 20; // The number of records returned per page in the response. 
    String accountId = "accountId_example"; // This parameter filters the response based on the `accountId` field. 
    Double amount = 3.4D; // This parameter filters the response based on the `amount` field. 
    Double appliedAmount = 3.4D; // This parameter filters the response based on the `appliedAmount` field. 
    String createdById = "createdById_example"; // This parameter filters the response based on the `createdById` field. 
    OffsetDateTime createdDate = OffsetDateTime.now(); // This parameter filters the response based on the `createdDate` field. 
    Double creditBalanceAmount = 3.4D; // This parameter filters the response based on the `creditBalanceAmount` field. 
    String currency = "currency_example"; // This parameter filters the response based on the `currency` field. 
    OffsetDateTime effectiveDate = OffsetDateTime.now(); // This parameter filters the response based on the `effectiveDate` field. 
    String number = "number_example"; // This parameter filters the response based on the `number` field. 
    Double refundAmount = 3.4D; // This parameter filters the response based on the `refundAmount` field. 
    String status = "Draft"; // This parameter filters the response based on the `status` field. 
    String type = "External"; // This parameter filters the response based on the `type` field. 
    Double unappliedAmount = 3.4D; // This parameter filters the response based on the `unappliedAmount` field. 
    String updatedById = "updatedById_example"; // This parameter filters the response based on the `updatedById` field. 
    OffsetDateTime updatedDate = OffsetDateTime.now(); // This parameter filters the response based on the `updatedDate` field. 
    String sort = "sort_example"; // This parameter restricts the order of the data returned in the response. You can use this parameter to supply a dimension you want to sort on.  A sortable field uses the following form:   *operator* *field_name*  You can use at most two sortable fields in one URL path. Use a comma to separate sortable fields. For example:  *operator* *field_name*, *operator* *field_name*    *operator* is used to mark the order of sequencing. The operator is optional. If you only specify the sortable field without any operator, the response data is sorted in descending order by this field.    - The `-` operator indicates an ascending order.   - The `+` operator indicates a descending order.  By default, the response data is displayed in descending order by payment number.  *field_name* indicates the name of a sortable field. The supported sortable fields of this operation are as below:    - number   - accountId   - amount   - appliedAmount   - unappliedAmount   - refundAmount   - creditBalanceAmount   - effectiveDate   - createdDate   - createdById   - updatedDate   - updatedById      Examples:  - /v1/payments?sort=+number  - /v1/payments?status=Processed&sort=-number,+amount 
    try {
      PaymentCollectionResponseType result = client
              .payments
              .retrieveAllPayments()
              .acceptEncoding(acceptEncoding)
              .contentEncoding(contentEncoding)
              .authorization(authorization)
              .zuoraTrackId(zuoraTrackId)
              .zuoraEntityIds(zuoraEntityIds)
              .zuoraOrgIds(zuoraOrgIds)
              .page(page)
              .pageSize(pageSize)
              .accountId(accountId)
              .amount(amount)
              .appliedAmount(appliedAmount)
              .createdById(createdById)
              .createdDate(createdDate)
              .creditBalanceAmount(creditBalanceAmount)
              .currency(currency)
              .effectiveDate(effectiveDate)
              .number(number)
              .refundAmount(refundAmount)
              .status(status)
              .type(type)
              .unappliedAmount(unappliedAmount)
              .updatedById(updatedById)
              .updatedDate(updatedDate)
              .sort(sort)
              .execute();
      System.out.println(result);
      System.out.println(result.getNextPage());
      System.out.println(result.getPayments());
      System.out.println(result.getSuccess());
    } catch (ApiException e) {
      System.err.println("Exception when calling PaymentsApi#retrieveAllPayments");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<PaymentCollectionResponseType> response = client
              .payments
              .retrieveAllPayments()
              .acceptEncoding(acceptEncoding)
              .contentEncoding(contentEncoding)
              .authorization(authorization)
              .zuoraTrackId(zuoraTrackId)
              .zuoraEntityIds(zuoraEntityIds)
              .zuoraOrgIds(zuoraOrgIds)
              .page(page)
              .pageSize(pageSize)
              .accountId(accountId)
              .amount(amount)
              .appliedAmount(appliedAmount)
              .createdById(createdById)
              .createdDate(createdDate)
              .creditBalanceAmount(creditBalanceAmount)
              .currency(currency)
              .effectiveDate(effectiveDate)
              .number(number)
              .refundAmount(refundAmount)
              .status(status)
              .type(type)
              .unappliedAmount(unappliedAmount)
              .updatedById(updatedById)
              .updatedDate(updatedDate)
              .sort(sort)
              .executeWithHttpInfo();
      System.out.println(response.getResponseBody());
      System.out.println(response.getResponseHeaders());
      System.out.println(response.getStatusCode());
      System.out.println(response.getRoundTripTime());
      System.out.println(response.getRequest());
    } catch (ApiException e) {
      System.err.println("Exception when calling PaymentsApi#retrieveAllPayments");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}

```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **acceptEncoding** | **String**| Include the &#x60;Accept-Encoding: gzip&#x60; header to compress responses as a gzipped file. It can significantly reduce the bandwidth required for a response.   If specified, Zuora automatically compresses responses that contain over 1000 bytes of data, and the response contains a &#x60;Content-Encoding&#x60; header with the compression algorithm so that your client can decompress it.  | [optional] |
| **contentEncoding** | **String**| Include the &#x60;Content-Encoding: gzip&#x60; header to compress a request. With this header specified, you should upload a gzipped file for the request payload instead of sending the JSON payload.  | [optional] |
| **authorization** | **String**| The value is in the &#x60;Bearer {token}&#x60; format where {token} is a valid OAuth token generated by calling [Create an OAuth token](https://developer.zuora.com/api-references/api/operation/createToken).  | [optional] |
| **zuoraTrackId** | **String**| A custom identifier for tracing the API call. If you set a value for this header, Zuora returns the same value in the response headers. This header enables you to associate your system process identifiers with Zuora API calls, to assist with troubleshooting in the event of an issue.  The value of this field must use the US-ASCII character set and must not include any of the following characters: colon (&#x60;:&#x60;), semicolon (&#x60;;&#x60;), double quote (&#x60;\&quot;&#x60;), and quote (&#x60;&#39;&#x60;).  | [optional] |
| **zuoraEntityIds** | **String**| An entity ID. If you have [Zuora Multi-entity](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Multi-entity) enabled and the OAuth token is valid for more than one entity, you must use this header to specify which entity to perform the operation in. If the OAuth token is only valid for a single entity, or you do not have Zuora Multi-entity enabled, you do not need to set this header.  | [optional] |
| **zuoraOrgIds** | **String**| Comma separated IDs. If you have &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Central_Platform/Multi-Org\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Zuora Multi-Org&lt;/a&gt; enabled,  you can use this header to specify which orgs to perform the operation in. If you do not have Zuora Multi-Org enabled, you should not set this header.  The IDs must be a sub-set of the user&#39;s accessible orgs. If you specify an org that the user does not have access to, the operation fails.  If the header is not set, the operation is performed in scope of the user&#39;s accessible orgs.  | [optional] |
| **page** | **Integer**| The index number of the page that you want to retrieve. This parameter is dependent on &#x60;pageSize&#x60;. You must set &#x60;pageSize&#x60; before specifying &#x60;page&#x60;. For example, if you set &#x60;pageSize&#x60; to &#x60;20&#x60; and &#x60;page&#x60; to &#x60;2&#x60;, the 21st to 40th records are returned in the response.  | [optional] [default to 1] |
| **pageSize** | **Integer**| The number of records returned per page in the response.  | [optional] [default to 20] |
| **accountId** | **String**| This parameter filters the response based on the &#x60;accountId&#x60; field.  | [optional] |
| **amount** | **Double**| This parameter filters the response based on the &#x60;amount&#x60; field.  | [optional] |
| **appliedAmount** | **Double**| This parameter filters the response based on the &#x60;appliedAmount&#x60; field.  | [optional] |
| **createdById** | **String**| This parameter filters the response based on the &#x60;createdById&#x60; field.  | [optional] |
| **createdDate** | **OffsetDateTime**| This parameter filters the response based on the &#x60;createdDate&#x60; field.  | [optional] |
| **creditBalanceAmount** | **Double**| This parameter filters the response based on the &#x60;creditBalanceAmount&#x60; field.  | [optional] |
| **currency** | **String**| This parameter filters the response based on the &#x60;currency&#x60; field.  | [optional] |
| **effectiveDate** | **OffsetDateTime**| This parameter filters the response based on the &#x60;effectiveDate&#x60; field.  | [optional] |
| **number** | **String**| This parameter filters the response based on the &#x60;number&#x60; field.  | [optional] |
| **refundAmount** | **Double**| This parameter filters the response based on the &#x60;refundAmount&#x60; field.  | [optional] |
| **status** | **String**| This parameter filters the response based on the &#x60;status&#x60; field.  | [optional] [enum: Draft, Processing, Processed, Error, Canceled, Posted] |
| **type** | **String**| This parameter filters the response based on the &#x60;type&#x60; field.  | [optional] [enum: External, Electronic] |
| **unappliedAmount** | **Double**| This parameter filters the response based on the &#x60;unappliedAmount&#x60; field.  | [optional] |
| **updatedById** | **String**| This parameter filters the response based on the &#x60;updatedById&#x60; field.  | [optional] |
| **updatedDate** | **OffsetDateTime**| This parameter filters the response based on the &#x60;updatedDate&#x60; field.  | [optional] |
| **sort** | **String**| This parameter restricts the order of the data returned in the response. You can use this parameter to supply a dimension you want to sort on.  A sortable field uses the following form:   *operator* *field_name*  You can use at most two sortable fields in one URL path. Use a comma to separate sortable fields. For example:  *operator* *field_name*, *operator* *field_name*    *operator* is used to mark the order of sequencing. The operator is optional. If you only specify the sortable field without any operator, the response data is sorted in descending order by this field.    - The &#x60;-&#x60; operator indicates an ascending order.   - The &#x60;+&#x60; operator indicates a descending order.  By default, the response data is displayed in descending order by payment number.  *field_name* indicates the name of a sortable field. The supported sortable fields of this operation are as below:    - number   - accountId   - amount   - appliedAmount   - unappliedAmount   - refundAmount   - creditBalanceAmount   - effectiveDate   - createdDate   - createdById   - updatedDate   - updatedById      Examples:  - /v1/payments?sort&#x3D;+number  - /v1/payments?status&#x3D;Processed&amp;sort&#x3D;-number,+amount  | [optional] |

### Return type

[**PaymentCollectionResponseType**](PaymentCollectionResponseType.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** |  |  * Content-Encoding - This header is returned if you specify the &#x60;Accept-Encoding: gzip&#x60; request header and the response contains over 1000 bytes of data. Note that only the following MIME types support gzipped responses:   - &#x60;application/json&#x60;   - &#x60;application/xml&#x60;   - &#x60;text/html&#x60;   - &#x60;text/csv&#x60;   - &#x60;text/plain&#x60;  <br>  * RateLimit-Limit - The request limit quota for the time window closest to exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Remaining - The number of requests remaining in the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Reset - The number of seconds until the quota resets for the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Zuora-Request-Id - The Zuora internal identifier of the API call. You cannot control the value of this header.  <br>  * Zuora-Track-Id - A custom identifier for tracing the API call. If you specified a tracing identifier in the request headers, Zuora returns the same tracing identifier. Otherwise, Zuora does not set this header.  <br>  |

<a name="transferPayment"></a>
# **transferPayment**
> GETARPaymentType transferPayment(paymentKey, transferPaymentType).acceptEncoding(acceptEncoding).contentEncoding(contentEncoding).authorization(authorization).zuoraTrackId(zuoraTrackId).zuoraEntityIds(zuoraEntityIds).zuoraOrgIds(zuoraOrgIds).execute();

Transfer a payment

**Note:** This operation is only available if you have [Invoice Settlement](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/Invoice_Settlement) enabled. The Invoice Settlement feature is generally available as of Zuora Billing Release 296 (March 2021). This feature includes Unapplied Payments, Credit and Debit Memo, and Invoice Item Settlement. If you want to enable Invoice Settlement, see [Invoice Settlement Enablement and Checklist Guide](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/Invoice_Settlement/Invoice_Settlement_Migration_Checklist_and_Guide) for more information.   Transfers an unapplied payment.  For more information, see [Transfer Unapplied Payments](https://knowledgecenter.zuora.com/CB_Billing/Invoice_Settlement/A_Unapplied_Payments/Management_of_Unapplied_Payments/Transfer_Unapplied_Payments). 

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Zuora;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.PaymentsApi;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Example {
  public static void main(String[] args) {
    Configuration configuration = new Configuration();
    configuration.host = "https://rest.zuora.com";
    Zuora client = new Zuora(configuration);
    String paymentKey = "paymentKey_example"; // The unique ID or number of an unapplied payment. For example, `8a8082e65b27f6c3015b89e4344c16b1`, or `P-00000001`.           
    String accountId = "accountId_example"; // The ID of the customer account that the payment is transferred to. Unassign a payment by setting this field to an empty string. This will automatically transfer the payment to a null account. 
    String acceptEncoding = "acceptEncoding_example"; // Include the `Accept-Encoding: gzip` header to compress responses as a gzipped file. It can significantly reduce the bandwidth required for a response.   If specified, Zuora automatically compresses responses that contain over 1000 bytes of data, and the response contains a `Content-Encoding` header with the compression algorithm so that your client can decompress it. 
    String contentEncoding = "contentEncoding_example"; // Include the `Content-Encoding: gzip` header to compress a request. With this header specified, you should upload a gzipped file for the request payload instead of sending the JSON payload. 
    String authorization = "authorization_example"; // The value is in the `Bearer {token}` format where {token} is a valid OAuth token generated by calling [Create an OAuth token](https://developer.zuora.com/api-references/api/operation/createToken). 
    String zuoraTrackId = "zuoraTrackId_example"; // A custom identifier for tracing the API call. If you set a value for this header, Zuora returns the same value in the response headers. This header enables you to associate your system process identifiers with Zuora API calls, to assist with troubleshooting in the event of an issue.  The value of this field must use the US-ASCII character set and must not include any of the following characters: colon (`:`), semicolon (`;`), double quote (`\"`), and quote (`'`). 
    String zuoraEntityIds = "zuoraEntityIds_example"; // An entity ID. If you have [Zuora Multi-entity](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Multi-entity) enabled and the OAuth token is valid for more than one entity, you must use this header to specify which entity to perform the operation in. If the OAuth token is only valid for a single entity, or you do not have Zuora Multi-entity enabled, you do not need to set this header. 
    String zuoraOrgIds = "zuoraOrgIds_example"; // Comma separated IDs. If you have <a href=\"https://knowledgecenter.zuora.com/Zuora_Central_Platform/Multi-Org\" target=\"_blank\">Zuora Multi-Org</a> enabled,  you can use this header to specify which orgs to perform the operation in. If you do not have Zuora Multi-Org enabled, you should not set this header.  The IDs must be a sub-set of the user's accessible orgs. If you specify an org that the user does not have access to, the operation fails.  If the header is not set, the operation is performed in scope of the user's accessible orgs. 
    try {
      GETARPaymentType result = client
              .payments
              .transferPayment(paymentKey)
              .accountId(accountId)
              .acceptEncoding(acceptEncoding)
              .contentEncoding(contentEncoding)
              .authorization(authorization)
              .zuoraTrackId(zuoraTrackId)
              .zuoraEntityIds(zuoraEntityIds)
              .zuoraOrgIds(zuoraOrgIds)
              .execute();
      System.out.println(result);
      System.out.println(result.getAccountId());
      System.out.println(result.getAccountNumber());
      System.out.println(result.getAmount());
      System.out.println(result.getAppliedAmount());
      System.out.println(result.getAuthTransactionId());
      System.out.println(result.getBankIdentificationNumber());
      System.out.println(result.getCancelledOn());
      System.out.println(result.getComment());
      System.out.println(result.getCreatedById());
      System.out.println(result.getCreatedDate());
      System.out.println(result.getCreditBalanceAmount());
      System.out.println(result.getCurrency());
      System.out.println(result.getEffectiveDate());
      System.out.println(result.getFinanceInformation());
      System.out.println(result.getGatewayId());
      System.out.println(result.getGatewayOrderId());
      System.out.println(result.getGatewayReconciliationReason());
      System.out.println(result.getGatewayReconciliationStatus());
      System.out.println(result.getGatewayResponse());
      System.out.println(result.getGatewayResponseCode());
      System.out.println(result.getGatewayState());
      System.out.println(result.getId());
      System.out.println(result.getMarkedForSubmissionOn());
      System.out.println(result.getNumber());
      System.out.println(result.getOrganizationLabel());
      System.out.println(result.getPaymentGatewayNumber());
      System.out.println(result.getPaymentMethodId());
      System.out.println(result.getPaymentMethodSnapshotId());
      System.out.println(result.getPaymentScheduleKey());
      System.out.println(result.getPayoutId());
      System.out.println(result.getPrepayment());
      System.out.println(result.getReferenceId());
      System.out.println(result.getRefundAmount());
      System.out.println(result.getSecondPaymentReferenceId());
      System.out.println(result.getSettledOn());
      System.out.println(result.getSoftDescriptor());
      System.out.println(result.getSoftDescriptorPhone());
      System.out.println(result.getStandalone());
      System.out.println(result.getStatus());
      System.out.println(result.getSubmittedOn());
      System.out.println(result.getSuccess());
      System.out.println(result.getType());
      System.out.println(result.getUnappliedAmount());
      System.out.println(result.getUpdatedById());
      System.out.println(result.getUpdatedDate());
      System.out.println(result.getIntegrationIdNS());
      System.out.println(result.getIntegrationStatusNS());
      System.out.println(result.getOriginNS());
      System.out.println(result.getSyncDateNS());
      System.out.println(result.getTransactionNS());
    } catch (ApiException e) {
      System.err.println("Exception when calling PaymentsApi#transferPayment");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<GETARPaymentType> response = client
              .payments
              .transferPayment(paymentKey)
              .accountId(accountId)
              .acceptEncoding(acceptEncoding)
              .contentEncoding(contentEncoding)
              .authorization(authorization)
              .zuoraTrackId(zuoraTrackId)
              .zuoraEntityIds(zuoraEntityIds)
              .zuoraOrgIds(zuoraOrgIds)
              .executeWithHttpInfo();
      System.out.println(response.getResponseBody());
      System.out.println(response.getResponseHeaders());
      System.out.println(response.getStatusCode());
      System.out.println(response.getRoundTripTime());
      System.out.println(response.getRequest());
    } catch (ApiException e) {
      System.err.println("Exception when calling PaymentsApi#transferPayment");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}

```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **paymentKey** | **String**| The unique ID or number of an unapplied payment. For example, &#x60;8a8082e65b27f6c3015b89e4344c16b1&#x60;, or &#x60;P-00000001&#x60;.            | |
| **transferPaymentType** | [**TransferPaymentType**](TransferPaymentType.md)|  | |
| **acceptEncoding** | **String**| Include the &#x60;Accept-Encoding: gzip&#x60; header to compress responses as a gzipped file. It can significantly reduce the bandwidth required for a response.   If specified, Zuora automatically compresses responses that contain over 1000 bytes of data, and the response contains a &#x60;Content-Encoding&#x60; header with the compression algorithm so that your client can decompress it.  | [optional] |
| **contentEncoding** | **String**| Include the &#x60;Content-Encoding: gzip&#x60; header to compress a request. With this header specified, you should upload a gzipped file for the request payload instead of sending the JSON payload.  | [optional] |
| **authorization** | **String**| The value is in the &#x60;Bearer {token}&#x60; format where {token} is a valid OAuth token generated by calling [Create an OAuth token](https://developer.zuora.com/api-references/api/operation/createToken).  | [optional] |
| **zuoraTrackId** | **String**| A custom identifier for tracing the API call. If you set a value for this header, Zuora returns the same value in the response headers. This header enables you to associate your system process identifiers with Zuora API calls, to assist with troubleshooting in the event of an issue.  The value of this field must use the US-ASCII character set and must not include any of the following characters: colon (&#x60;:&#x60;), semicolon (&#x60;;&#x60;), double quote (&#x60;\&quot;&#x60;), and quote (&#x60;&#39;&#x60;).  | [optional] |
| **zuoraEntityIds** | **String**| An entity ID. If you have [Zuora Multi-entity](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Multi-entity) enabled and the OAuth token is valid for more than one entity, you must use this header to specify which entity to perform the operation in. If the OAuth token is only valid for a single entity, or you do not have Zuora Multi-entity enabled, you do not need to set this header.  | [optional] |
| **zuoraOrgIds** | **String**| Comma separated IDs. If you have &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Central_Platform/Multi-Org\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Zuora Multi-Org&lt;/a&gt; enabled,  you can use this header to specify which orgs to perform the operation in. If you do not have Zuora Multi-Org enabled, you should not set this header.  The IDs must be a sub-set of the user&#39;s accessible orgs. If you specify an org that the user does not have access to, the operation fails.  If the header is not set, the operation is performed in scope of the user&#39;s accessible orgs.  | [optional] |

### Return type

[**GETARPaymentType**](GETARPaymentType.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** |  |  * Content-Encoding - This header is returned if you specify the &#x60;Accept-Encoding: gzip&#x60; request header and the response contains over 1000 bytes of data. Note that only the following MIME types support gzipped responses:   - &#x60;application/json&#x60;   - &#x60;application/xml&#x60;   - &#x60;text/html&#x60;   - &#x60;text/csv&#x60;   - &#x60;text/plain&#x60;  <br>  * RateLimit-Limit - The request limit quota for the time window closest to exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Remaining - The number of requests remaining in the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Reset - The number of seconds until the quota resets for the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Zuora-Request-Id - The Zuora internal identifier of the API call. You cannot control the value of this header.  <br>  * Zuora-Track-Id - A custom identifier for tracing the API call. If you specified a tracing identifier in the request headers, Zuora returns the same tracing identifier. Otherwise, Zuora does not set this header.  <br>  |

<a name="unapplyPayment"></a>
# **unapplyPayment**
> GETARPaymentType unapplyPayment(paymentKey, unapplyPaymentType).acceptEncoding(acceptEncoding).contentEncoding(contentEncoding).authorization(authorization).zuoraTrackId(zuoraTrackId).zuoraEntityIds(zuoraEntityIds).zuoraOrgIds(zuoraOrgIds).execute();

Unapply a payment

**Note:** This operation is only available if you have [Invoice Settlement](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/Invoice_Settlement) enabled. The Invoice Settlement feature is generally available as of Zuora Billing Release 296 (March 2021). This feature includes Unapplied Payments, Credit and Debit Memo, and Invoice Item Settlement. If you want to enable Invoice Settlement, see [Invoice Settlement Enablement and Checklist Guide](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/Invoice_Settlement/Invoice_Settlement_Migration_Checklist_and_Guide) for more information.   Unapplies an applied payment from invoices and debit memos.  When you unapply a payment, the total number of invoice items and debit memo items that the payment will unapply from must be less than or equal to 15,000.  If the limit is hit, you can follow the instructions: - If you want to unapply one payment without specifying invoices or debit memos, you have to specify the invoices or debit memos in the request. - If you want to unapply one payment from multiple specified invoices or debit memos, decrease the number of invoices or debit memos in the request. - If you want to unapply one payment from a single invoice or debit memo with a large volume of items, you have to specify invoice items in the request. The maximum number of invoice items that you can specify in the request is 1,000.  For more information, see [Unapply Payments from Invoices and Debit Memos](https://knowledgecenter.zuora.com/CB_Billing/Invoice_Settlement/A_Unapplied_Payments/Management_of_Unapplied_Payments/Unapply_Payments_from_Invoices_and_Debit_Memos). 

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Zuora;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.PaymentsApi;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Example {
  public static void main(String[] args) {
    Configuration configuration = new Configuration();
    configuration.host = "https://rest.zuora.com";
    Zuora client = new Zuora(configuration);
    String paymentKey = "paymentKey_example"; // The unique ID or number of an unapplied payment. For example, `8a8082e65b27f6c3015b89e4344c16b1`, or `P-00000001`. 
    List<PaymentDebitMemoApplicationUnapplyRequestType> debitMemos = Arrays.asList(); // Container for debit memos. The maximum number of debit memos is 1,000. 
    LocalDate effectiveDate = LocalDate.now(); // The date when the payment is unapplied, in `yyyy-mm-dd` format. The effective date must be later than or equal to the maximum effective date of the payment. 
    List<PaymentInvoiceApplicationUnapplyRequestType> invoices = Arrays.asList(); // Container for invoices. The maximum number of invoice is 1,000. 
    String acceptEncoding = "acceptEncoding_example"; // Include the `Accept-Encoding: gzip` header to compress responses as a gzipped file. It can significantly reduce the bandwidth required for a response.   If specified, Zuora automatically compresses responses that contain over 1000 bytes of data, and the response contains a `Content-Encoding` header with the compression algorithm so that your client can decompress it. 
    String contentEncoding = "contentEncoding_example"; // Include the `Content-Encoding: gzip` header to compress a request. With this header specified, you should upload a gzipped file for the request payload instead of sending the JSON payload. 
    String authorization = "authorization_example"; // The value is in the `Bearer {token}` format where {token} is a valid OAuth token generated by calling [Create an OAuth token](https://developer.zuora.com/api-references/api/operation/createToken). 
    String zuoraTrackId = "zuoraTrackId_example"; // A custom identifier for tracing the API call. If you set a value for this header, Zuora returns the same value in the response headers. This header enables you to associate your system process identifiers with Zuora API calls, to assist with troubleshooting in the event of an issue.  The value of this field must use the US-ASCII character set and must not include any of the following characters: colon (`:`), semicolon (`;`), double quote (`\"`), and quote (`'`). 
    String zuoraEntityIds = "zuoraEntityIds_example"; // An entity ID. If you have [Zuora Multi-entity](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Multi-entity) enabled and the OAuth token is valid for more than one entity, you must use this header to specify which entity to perform the operation in. If the OAuth token is only valid for a single entity, or you do not have Zuora Multi-entity enabled, you do not need to set this header. 
    String zuoraOrgIds = "zuoraOrgIds_example"; // Comma separated IDs. If you have <a href=\"https://knowledgecenter.zuora.com/Zuora_Central_Platform/Multi-Org\" target=\"_blank\">Zuora Multi-Org</a> enabled,  you can use this header to specify which orgs to perform the operation in. If you do not have Zuora Multi-Org enabled, you should not set this header.  The IDs must be a sub-set of the user's accessible orgs. If you specify an org that the user does not have access to, the operation fails.  If the header is not set, the operation is performed in scope of the user's accessible orgs. 
    try {
      GETARPaymentType result = client
              .payments
              .unapplyPayment(paymentKey)
              .debitMemos(debitMemos)
              .effectiveDate(effectiveDate)
              .invoices(invoices)
              .acceptEncoding(acceptEncoding)
              .contentEncoding(contentEncoding)
              .authorization(authorization)
              .zuoraTrackId(zuoraTrackId)
              .zuoraEntityIds(zuoraEntityIds)
              .zuoraOrgIds(zuoraOrgIds)
              .execute();
      System.out.println(result);
      System.out.println(result.getAccountId());
      System.out.println(result.getAccountNumber());
      System.out.println(result.getAmount());
      System.out.println(result.getAppliedAmount());
      System.out.println(result.getAuthTransactionId());
      System.out.println(result.getBankIdentificationNumber());
      System.out.println(result.getCancelledOn());
      System.out.println(result.getComment());
      System.out.println(result.getCreatedById());
      System.out.println(result.getCreatedDate());
      System.out.println(result.getCreditBalanceAmount());
      System.out.println(result.getCurrency());
      System.out.println(result.getEffectiveDate());
      System.out.println(result.getFinanceInformation());
      System.out.println(result.getGatewayId());
      System.out.println(result.getGatewayOrderId());
      System.out.println(result.getGatewayReconciliationReason());
      System.out.println(result.getGatewayReconciliationStatus());
      System.out.println(result.getGatewayResponse());
      System.out.println(result.getGatewayResponseCode());
      System.out.println(result.getGatewayState());
      System.out.println(result.getId());
      System.out.println(result.getMarkedForSubmissionOn());
      System.out.println(result.getNumber());
      System.out.println(result.getOrganizationLabel());
      System.out.println(result.getPaymentGatewayNumber());
      System.out.println(result.getPaymentMethodId());
      System.out.println(result.getPaymentMethodSnapshotId());
      System.out.println(result.getPaymentScheduleKey());
      System.out.println(result.getPayoutId());
      System.out.println(result.getPrepayment());
      System.out.println(result.getReferenceId());
      System.out.println(result.getRefundAmount());
      System.out.println(result.getSecondPaymentReferenceId());
      System.out.println(result.getSettledOn());
      System.out.println(result.getSoftDescriptor());
      System.out.println(result.getSoftDescriptorPhone());
      System.out.println(result.getStandalone());
      System.out.println(result.getStatus());
      System.out.println(result.getSubmittedOn());
      System.out.println(result.getSuccess());
      System.out.println(result.getType());
      System.out.println(result.getUnappliedAmount());
      System.out.println(result.getUpdatedById());
      System.out.println(result.getUpdatedDate());
      System.out.println(result.getIntegrationIdNS());
      System.out.println(result.getIntegrationStatusNS());
      System.out.println(result.getOriginNS());
      System.out.println(result.getSyncDateNS());
      System.out.println(result.getTransactionNS());
    } catch (ApiException e) {
      System.err.println("Exception when calling PaymentsApi#unapplyPayment");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<GETARPaymentType> response = client
              .payments
              .unapplyPayment(paymentKey)
              .debitMemos(debitMemos)
              .effectiveDate(effectiveDate)
              .invoices(invoices)
              .acceptEncoding(acceptEncoding)
              .contentEncoding(contentEncoding)
              .authorization(authorization)
              .zuoraTrackId(zuoraTrackId)
              .zuoraEntityIds(zuoraEntityIds)
              .zuoraOrgIds(zuoraOrgIds)
              .executeWithHttpInfo();
      System.out.println(response.getResponseBody());
      System.out.println(response.getResponseHeaders());
      System.out.println(response.getStatusCode());
      System.out.println(response.getRoundTripTime());
      System.out.println(response.getRequest());
    } catch (ApiException e) {
      System.err.println("Exception when calling PaymentsApi#unapplyPayment");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}

```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **paymentKey** | **String**| The unique ID or number of an unapplied payment. For example, &#x60;8a8082e65b27f6c3015b89e4344c16b1&#x60;, or &#x60;P-00000001&#x60;.  | |
| **unapplyPaymentType** | [**UnapplyPaymentType**](UnapplyPaymentType.md)|  | |
| **acceptEncoding** | **String**| Include the &#x60;Accept-Encoding: gzip&#x60; header to compress responses as a gzipped file. It can significantly reduce the bandwidth required for a response.   If specified, Zuora automatically compresses responses that contain over 1000 bytes of data, and the response contains a &#x60;Content-Encoding&#x60; header with the compression algorithm so that your client can decompress it.  | [optional] |
| **contentEncoding** | **String**| Include the &#x60;Content-Encoding: gzip&#x60; header to compress a request. With this header specified, you should upload a gzipped file for the request payload instead of sending the JSON payload.  | [optional] |
| **authorization** | **String**| The value is in the &#x60;Bearer {token}&#x60; format where {token} is a valid OAuth token generated by calling [Create an OAuth token](https://developer.zuora.com/api-references/api/operation/createToken).  | [optional] |
| **zuoraTrackId** | **String**| A custom identifier for tracing the API call. If you set a value for this header, Zuora returns the same value in the response headers. This header enables you to associate your system process identifiers with Zuora API calls, to assist with troubleshooting in the event of an issue.  The value of this field must use the US-ASCII character set and must not include any of the following characters: colon (&#x60;:&#x60;), semicolon (&#x60;;&#x60;), double quote (&#x60;\&quot;&#x60;), and quote (&#x60;&#39;&#x60;).  | [optional] |
| **zuoraEntityIds** | **String**| An entity ID. If you have [Zuora Multi-entity](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Multi-entity) enabled and the OAuth token is valid for more than one entity, you must use this header to specify which entity to perform the operation in. If the OAuth token is only valid for a single entity, or you do not have Zuora Multi-entity enabled, you do not need to set this header.  | [optional] |
| **zuoraOrgIds** | **String**| Comma separated IDs. If you have &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Central_Platform/Multi-Org\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Zuora Multi-Org&lt;/a&gt; enabled,  you can use this header to specify which orgs to perform the operation in. If you do not have Zuora Multi-Org enabled, you should not set this header.  The IDs must be a sub-set of the user&#39;s accessible orgs. If you specify an org that the user does not have access to, the operation fails.  If the header is not set, the operation is performed in scope of the user&#39;s accessible orgs.  | [optional] |

### Return type

[**GETARPaymentType**](GETARPaymentType.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** |  |  * Content-Encoding - This header is returned if you specify the &#x60;Accept-Encoding: gzip&#x60; request header and the response contains over 1000 bytes of data. Note that only the following MIME types support gzipped responses:   - &#x60;application/json&#x60;   - &#x60;application/xml&#x60;   - &#x60;text/html&#x60;   - &#x60;text/csv&#x60;   - &#x60;text/plain&#x60;  <br>  * RateLimit-Limit - The request limit quota for the time window closest to exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Remaining - The number of requests remaining in the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Reset - The number of seconds until the quota resets for the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Zuora-Request-Id - The Zuora internal identifier of the API call. You cannot control the value of this header.  <br>  * Zuora-Track-Id - A custom identifier for tracing the API call. If you specified a tracing identifier in the request headers, Zuora returns the same tracing identifier. Otherwise, Zuora does not set this header.  <br>  |

<a name="updatePayment"></a>
# **updatePayment**
> GETARPaymentType updatePayment(paymentId, updatePaymentType).acceptEncoding(acceptEncoding).contentEncoding(contentEncoding).authorization(authorization).zuoraTrackId(zuoraTrackId).zuoraEntityIds(zuoraEntityIds).zuoraOrgIds(zuoraOrgIds).execute();

Update a payment

**Note:** This operation is only available if you have [Invoice Settlement](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/Invoice_Settlement) enabled. The Invoice Settlement feature is generally available as of Zuora Billing Release 296 (March 2021). This feature includes Unapplied Payments, Credit and Debit Memo, and Invoice Item Settlement. If you want to enable Invoice Settlement, see [Invoice Settlement Enablement and Checklist Guide](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/Invoice_Settlement/Invoice_Settlement_Migration_Checklist_and_Guide) for more information.   Updates a payment. 

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Zuora;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.PaymentsApi;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Example {
  public static void main(String[] args) {
    Configuration configuration = new Configuration();
    configuration.host = "https://rest.zuora.com";
    Zuora client = new Zuora(configuration);
    String paymentId = "paymentId_example"; // The unique ID of an unapplied payment. For example, `8a8082e65b27f6c3015b89e4344c16b1`. 
    String comment = "comment_example"; // Comments about the payment. 
    UpdatePaymentTypeAllOfFinanceInformation financeInformation = new UpdatePaymentTypeAllOfFinanceInformation();
    String gatewayState = "NotSubmitted"; // This field is mainly used for gateway reconciliation. See <a href=\\\"https://knowledgecenter.zuora.com/Zuora_Payments/Payment_Operations/DA_Electronic_Payment_Processing#Gateway_Reconciliation_Consideration\\\" target=\\\"_blank\\\">Electronic payment processing</a> for details.  You must have the **Edit Payment Gateway Status** <a href=\\\"https://knowledgecenter.zuora.com/Zuora_Central_Platform/Tenant_Management/A_Administrator_Settings/User_Roles/e_Payments_Roles\\\" target=\\\"_blank\\\">user permission</a> to update this field. 
    String paymentScheduleKey = "paymentScheduleKey_example"; // The unique ID or the number of the payment schedule to be linked with the payment. See [Link payments to payment schedules](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/Payment_Schedules/Link_payments_with_payment_schedules) for more information.
    String referenceId = "referenceId_example"; // The transaction ID returned by the payment gateway. Use this field to reconcile payments between your gateway and Zuora Payments.  You can only update the reference ID for external payments. 
    String integrationIdNS = "integrationIdNS_example"; // ID of the corresponding object in NetSuite. Only available if you have installed the [Zuora Connector for NetSuite](https://www.zuora.com/connect/app/?appId=265). 
    String integrationStatusNS = "integrationStatusNS_example"; // Status of the payment's synchronization with NetSuite. Only available if you have installed the [Zuora Connector for NetSuite](https://www.zuora.com/connect/app/?appId=265). 
    String originNS = "originNS_example"; // Origin of the corresponding object in NetSuite. Only available if you have installed the [Zuora Connector for NetSuite](https://www.zuora.com/connect/app/?appId=265). 
    String syncDateNS = "syncDateNS_example"; // Date when the payment was synchronized with NetSuite. Only available if you have installed the [Zuora Connector for NetSuite](https://www.zuora.com/connect/app/?appId=265). 
    String transactionNS = "transactionNS_example"; // Related transaction in NetSuite. Only available if you have installed the [Zuora Connector for NetSuite](https://www.zuora.com/connect/app/?appId=265). 
    String acceptEncoding = "acceptEncoding_example"; // Include the `Accept-Encoding: gzip` header to compress responses as a gzipped file. It can significantly reduce the bandwidth required for a response.   If specified, Zuora automatically compresses responses that contain over 1000 bytes of data, and the response contains a `Content-Encoding` header with the compression algorithm so that your client can decompress it. 
    String contentEncoding = "contentEncoding_example"; // Include the `Content-Encoding: gzip` header to compress a request. With this header specified, you should upload a gzipped file for the request payload instead of sending the JSON payload. 
    String authorization = "authorization_example"; // The value is in the `Bearer {token}` format where {token} is a valid OAuth token generated by calling [Create an OAuth token](https://developer.zuora.com/api-references/api/operation/createToken). 
    String zuoraTrackId = "zuoraTrackId_example"; // A custom identifier for tracing the API call. If you set a value for this header, Zuora returns the same value in the response headers. This header enables you to associate your system process identifiers with Zuora API calls, to assist with troubleshooting in the event of an issue.  The value of this field must use the US-ASCII character set and must not include any of the following characters: colon (`:`), semicolon (`;`), double quote (`\"`), and quote (`'`). 
    String zuoraEntityIds = "zuoraEntityIds_example"; // An entity ID. If you have [Zuora Multi-entity](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Multi-entity) enabled and the OAuth token is valid for more than one entity, you must use this header to specify which entity to perform the operation in. If the OAuth token is only valid for a single entity, or you do not have Zuora Multi-entity enabled, you do not need to set this header. 
    String zuoraOrgIds = "zuoraOrgIds_example"; // Comma separated IDs. If you have <a href=\"https://knowledgecenter.zuora.com/Zuora_Central_Platform/Multi-Org\" target=\"_blank\">Zuora Multi-Org</a> enabled,  you can use this header to specify which orgs to perform the operation in. If you do not have Zuora Multi-Org enabled, you should not set this header.  The IDs must be a sub-set of the user's accessible orgs. If you specify an org that the user does not have access to, the operation fails.  If the header is not set, the operation is performed in scope of the user's accessible orgs. 
    try {
      GETARPaymentType result = client
              .payments
              .updatePayment(paymentId)
              .comment(comment)
              .financeInformation(financeInformation)
              .gatewayState(gatewayState)
              .paymentScheduleKey(paymentScheduleKey)
              .referenceId(referenceId)
              .integrationIdNS(integrationIdNS)
              .integrationStatusNS(integrationStatusNS)
              .originNS(originNS)
              .syncDateNS(syncDateNS)
              .transactionNS(transactionNS)
              .acceptEncoding(acceptEncoding)
              .contentEncoding(contentEncoding)
              .authorization(authorization)
              .zuoraTrackId(zuoraTrackId)
              .zuoraEntityIds(zuoraEntityIds)
              .zuoraOrgIds(zuoraOrgIds)
              .execute();
      System.out.println(result);
      System.out.println(result.getAccountId());
      System.out.println(result.getAccountNumber());
      System.out.println(result.getAmount());
      System.out.println(result.getAppliedAmount());
      System.out.println(result.getAuthTransactionId());
      System.out.println(result.getBankIdentificationNumber());
      System.out.println(result.getCancelledOn());
      System.out.println(result.getComment());
      System.out.println(result.getCreatedById());
      System.out.println(result.getCreatedDate());
      System.out.println(result.getCreditBalanceAmount());
      System.out.println(result.getCurrency());
      System.out.println(result.getEffectiveDate());
      System.out.println(result.getFinanceInformation());
      System.out.println(result.getGatewayId());
      System.out.println(result.getGatewayOrderId());
      System.out.println(result.getGatewayReconciliationReason());
      System.out.println(result.getGatewayReconciliationStatus());
      System.out.println(result.getGatewayResponse());
      System.out.println(result.getGatewayResponseCode());
      System.out.println(result.getGatewayState());
      System.out.println(result.getId());
      System.out.println(result.getMarkedForSubmissionOn());
      System.out.println(result.getNumber());
      System.out.println(result.getOrganizationLabel());
      System.out.println(result.getPaymentGatewayNumber());
      System.out.println(result.getPaymentMethodId());
      System.out.println(result.getPaymentMethodSnapshotId());
      System.out.println(result.getPaymentScheduleKey());
      System.out.println(result.getPayoutId());
      System.out.println(result.getPrepayment());
      System.out.println(result.getReferenceId());
      System.out.println(result.getRefundAmount());
      System.out.println(result.getSecondPaymentReferenceId());
      System.out.println(result.getSettledOn());
      System.out.println(result.getSoftDescriptor());
      System.out.println(result.getSoftDescriptorPhone());
      System.out.println(result.getStandalone());
      System.out.println(result.getStatus());
      System.out.println(result.getSubmittedOn());
      System.out.println(result.getSuccess());
      System.out.println(result.getType());
      System.out.println(result.getUnappliedAmount());
      System.out.println(result.getUpdatedById());
      System.out.println(result.getUpdatedDate());
      System.out.println(result.getIntegrationIdNS());
      System.out.println(result.getIntegrationStatusNS());
      System.out.println(result.getOriginNS());
      System.out.println(result.getSyncDateNS());
      System.out.println(result.getTransactionNS());
    } catch (ApiException e) {
      System.err.println("Exception when calling PaymentsApi#updatePayment");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<GETARPaymentType> response = client
              .payments
              .updatePayment(paymentId)
              .comment(comment)
              .financeInformation(financeInformation)
              .gatewayState(gatewayState)
              .paymentScheduleKey(paymentScheduleKey)
              .referenceId(referenceId)
              .integrationIdNS(integrationIdNS)
              .integrationStatusNS(integrationStatusNS)
              .originNS(originNS)
              .syncDateNS(syncDateNS)
              .transactionNS(transactionNS)
              .acceptEncoding(acceptEncoding)
              .contentEncoding(contentEncoding)
              .authorization(authorization)
              .zuoraTrackId(zuoraTrackId)
              .zuoraEntityIds(zuoraEntityIds)
              .zuoraOrgIds(zuoraOrgIds)
              .executeWithHttpInfo();
      System.out.println(response.getResponseBody());
      System.out.println(response.getResponseHeaders());
      System.out.println(response.getStatusCode());
      System.out.println(response.getRoundTripTime());
      System.out.println(response.getRequest());
    } catch (ApiException e) {
      System.err.println("Exception when calling PaymentsApi#updatePayment");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}

```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **paymentId** | **String**| The unique ID of an unapplied payment. For example, &#x60;8a8082e65b27f6c3015b89e4344c16b1&#x60;.  | |
| **updatePaymentType** | [**UpdatePaymentType**](UpdatePaymentType.md)|  | |
| **acceptEncoding** | **String**| Include the &#x60;Accept-Encoding: gzip&#x60; header to compress responses as a gzipped file. It can significantly reduce the bandwidth required for a response.   If specified, Zuora automatically compresses responses that contain over 1000 bytes of data, and the response contains a &#x60;Content-Encoding&#x60; header with the compression algorithm so that your client can decompress it.  | [optional] |
| **contentEncoding** | **String**| Include the &#x60;Content-Encoding: gzip&#x60; header to compress a request. With this header specified, you should upload a gzipped file for the request payload instead of sending the JSON payload.  | [optional] |
| **authorization** | **String**| The value is in the &#x60;Bearer {token}&#x60; format where {token} is a valid OAuth token generated by calling [Create an OAuth token](https://developer.zuora.com/api-references/api/operation/createToken).  | [optional] |
| **zuoraTrackId** | **String**| A custom identifier for tracing the API call. If you set a value for this header, Zuora returns the same value in the response headers. This header enables you to associate your system process identifiers with Zuora API calls, to assist with troubleshooting in the event of an issue.  The value of this field must use the US-ASCII character set and must not include any of the following characters: colon (&#x60;:&#x60;), semicolon (&#x60;;&#x60;), double quote (&#x60;\&quot;&#x60;), and quote (&#x60;&#39;&#x60;).  | [optional] |
| **zuoraEntityIds** | **String**| An entity ID. If you have [Zuora Multi-entity](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Multi-entity) enabled and the OAuth token is valid for more than one entity, you must use this header to specify which entity to perform the operation in. If the OAuth token is only valid for a single entity, or you do not have Zuora Multi-entity enabled, you do not need to set this header.  | [optional] |
| **zuoraOrgIds** | **String**| Comma separated IDs. If you have &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Central_Platform/Multi-Org\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Zuora Multi-Org&lt;/a&gt; enabled,  you can use this header to specify which orgs to perform the operation in. If you do not have Zuora Multi-Org enabled, you should not set this header.  The IDs must be a sub-set of the user&#39;s accessible orgs. If you specify an org that the user does not have access to, the operation fails.  If the header is not set, the operation is performed in scope of the user&#39;s accessible orgs.  | [optional] |

### Return type

[**GETARPaymentType**](GETARPaymentType.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** |  |  * Content-Encoding - This header is returned if you specify the &#x60;Accept-Encoding: gzip&#x60; request header and the response contains over 1000 bytes of data. Note that only the following MIME types support gzipped responses:   - &#x60;application/json&#x60;   - &#x60;application/xml&#x60;   - &#x60;text/html&#x60;   - &#x60;text/csv&#x60;   - &#x60;text/plain&#x60;  <br>  * RateLimit-Limit - The request limit quota for the time window closest to exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Remaining - The number of requests remaining in the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Reset - The number of seconds until the quota resets for the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Zuora-Request-Id - The Zuora internal identifier of the API call. You cannot control the value of this header.  <br>  * Zuora-Track-Id - A custom identifier for tracing the API call. If you specified a tracing identifier in the request headers, Zuora returns the same tracing identifier. Otherwise, Zuora does not set this header.  <br>  |

