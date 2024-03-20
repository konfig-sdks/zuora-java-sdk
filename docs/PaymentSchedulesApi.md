# PaymentSchedulesApi

All URIs are relative to *https://rest.zuora.com*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**addItemsToCustomPaymentSchedule**](PaymentSchedulesApi.md#addItemsToCustomPaymentSchedule) | **POST** /v1/payment-schedules/{paymentScheduleKey}/items | Add payment schedule items to a custom payment schedule |
| [**cancelPaymentSchedule**](PaymentSchedulesApi.md#cancelPaymentSchedule) | **PUT** /v1/payment-schedules/{paymentScheduleKey}/cancel | Cancel a payment schedule |
| [**cancelPaymentScheduleItem**](PaymentSchedulesApi.md#cancelPaymentScheduleItem) | **PUT** /v1/payment-schedule-items/{item-id}/cancel | Cancel a payment schedule item |
| [**paymentSchedule**](PaymentSchedulesApi.md#paymentSchedule) | **POST** /v1/payment-schedules | Create a payment schedule |
| [**paymentScheduleItem**](PaymentSchedulesApi.md#paymentScheduleItem) | **GET** /v1/payment-schedule-items/{item-id} | Retrieve a payment schedule item |
| [**paymentScheduleItem_0**](PaymentSchedulesApi.md#paymentScheduleItem_0) | **PUT** /v1/payment-schedule-items/{item-id} | Update a payment schedule item |
| [**paymentScheduleStatistic**](PaymentSchedulesApi.md#paymentScheduleStatistic) | **GET** /v1/payment-schedules/statistics/{yyyy-mm-dd} | Retrieve payment schedule statistic of a date |
| [**paymentScheduleUpdatePreview**](PaymentSchedulesApi.md#paymentScheduleUpdatePreview) | **PUT** /v1/payment-schedules/{paymentScheduleKey}/preview | Preview the result of payment schedule updates |
| [**paymentSchedule_0**](PaymentSchedulesApi.md#paymentSchedule_0) | **GET** /v1/payment-schedules/{paymentScheduleKey} | Retrieve a payment schedule |
| [**paymentSchedule_1**](PaymentSchedulesApi.md#paymentSchedule_1) | **PUT** /v1/payment-schedules/{paymentScheduleKey} | Update a payment schedule |
| [**paymentSchedules**](PaymentSchedulesApi.md#paymentSchedules) | **GET** /v1/payment-schedules | List payment schedules by customer account |
| [**paymentSchedules_0**](PaymentSchedulesApi.md#paymentSchedules_0) | **POST** /v1/payment-schedules/batch | Create multiple payment schedules at once |
| [**retryPaymentScheduleItem**](PaymentSchedulesApi.md#retryPaymentScheduleItem) | **POST** /v1/payment-schedule-items/retry-payment | Retry failed payment schedule items |
| [**skipPaymentScheduleItem**](PaymentSchedulesApi.md#skipPaymentScheduleItem) | **PUT** /v1/payment-schedule-items/{item-id}/skip | Skip a payment schedule item |


<a name="addItemsToCustomPaymentSchedule"></a>
# **addItemsToCustomPaymentSchedule**
> GETPaymentScheduleResponse addItemsToCustomPaymentSchedule(paymentScheduleKey, poSTAddItemsToPaymentScheduleRequest).idempotencyKey(idempotencyKey).acceptEncoding(acceptEncoding).contentEncoding(contentEncoding).authorization(authorization).zuoraTrackId(zuoraTrackId).zuoraEntityIds(zuoraEntityIds).zuoraOrgIds(zuoraOrgIds).zuoraVersion(zuoraVersion).execute();

Add payment schedule items to a custom payment schedule

Adds payment schedule items to a custom payment schedule. You cannot use this operation to add payment schedule items to recurring payment schedules.  **Note:** - The Payment Schedules feature is in the **Early Adopter** phase. We are actively soliciting feedback from a small set of early adopters before releasing it as generally available. To manage and access this feature through the self-service interface, see [Manage Features](https://knowledgecenter.zuora.com/Zuora_Payments/Payments_Settings/Manage_Features) in the Knowledge Center. - This operation is only available if you have [Invoice Settlement](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/Invoice_Settlement) enabled. 

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Zuora;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.PaymentSchedulesApi;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Example {
  public static void main(String[] args) {
    Configuration configuration = new Configuration();
    configuration.host = "https://rest.zuora.com";
    Zuora client = new Zuora(configuration);
    String paymentScheduleKey = "paymentScheduleKey_example"; // The unique ID or number of a payment schedule. For example, `8a90857b822459cd018224dcb9eb13be`, or `PS-00000007`. 
    List<PaymentScheduleItemCommon> items = Arrays.asList();
    String idempotencyKey = "idempotencyKey_example"; // Specify a unique idempotency key if you want to perform an idempotent POST or PATCH request. Do not use this header in other request types.   With this header specified, the Zuora server can identify subsequent retries of the same request using this value, which prevents the same operation from being performed multiple times by accident.  
    String acceptEncoding = "acceptEncoding_example"; // Include the `Accept-Encoding: gzip` header to compress responses as a gzipped file. It can significantly reduce the bandwidth required for a response.   If specified, Zuora automatically compresses responses that contain over 1000 bytes of data, and the response contains a `Content-Encoding` header with the compression algorithm so that your client can decompress it. 
    String contentEncoding = "contentEncoding_example"; // Include the `Content-Encoding: gzip` header to compress a request. With this header specified, you should upload a gzipped file for the request payload instead of sending the JSON payload. 
    String authorization = "authorization_example"; // The value is in the `Bearer {token}` format where {token} is a valid OAuth token generated by calling [Create an OAuth token](https://developer.zuora.com/api-references/api/operation/createToken). 
    String zuoraTrackId = "zuoraTrackId_example"; // A custom identifier for tracing the API call. If you set a value for this header, Zuora returns the same value in the response headers. This header enables you to associate your system process identifiers with Zuora API calls, to assist with troubleshooting in the event of an issue.  The value of this field must use the US-ASCII character set and must not include any of the following characters: colon (`:`), semicolon (`;`), double quote (`\"`), and quote (`'`). 
    String zuoraEntityIds = "zuoraEntityIds_example"; // An entity ID. If you have [Zuora Multi-entity](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Multi-entity) enabled and the OAuth token is valid for more than one entity, you must use this header to specify which entity to perform the operation in. If the OAuth token is only valid for a single entity, or you do not have Zuora Multi-entity enabled, you do not need to set this header. 
    String zuoraOrgIds = "zuoraOrgIds_example"; // Comma separated IDs. If you have <a href=\"https://knowledgecenter.zuora.com/Zuora_Central_Platform/Multi-Org\" target=\"_blank\">Zuora Multi-Org</a> enabled,  you can use this header to specify which orgs to perform the operation in. If you do not have Zuora Multi-Org enabled, you should not set this header.  The IDs must be a sub-set of the user's accessible orgs. If you specify an org that the user does not have access to, the operation fails.  If the header is not set, the operation is performed in scope of the user's accessible orgs. 
    String zuoraVersion = "zuoraVersion_example"; // The minor version of the Zuora REST API. See [Minor Version](https://developer.zuora.com/api-references/api/overview/#section/API-Versions/Minor-Version) for information about REST API version control.   This header affects the availability of the following fields: - `items` > `paymentId` 
    try {
      GETPaymentScheduleResponse result = client
              .paymentSchedules
              .addItemsToCustomPaymentSchedule(paymentScheduleKey)
              .items(items)
              .idempotencyKey(idempotencyKey)
              .acceptEncoding(acceptEncoding)
              .contentEncoding(contentEncoding)
              .authorization(authorization)
              .zuoraTrackId(zuoraTrackId)
              .zuoraEntityIds(zuoraEntityIds)
              .zuoraOrgIds(zuoraOrgIds)
              .zuoraVersion(zuoraVersion)
              .execute();
      System.out.println(result);
      System.out.println(result.getDescription());
      System.out.println(result.getAccountId());
      System.out.println(result.getAccountNumber());
      System.out.println(result.getBillingDocument());
      System.out.println(result.getCreatedById());
      System.out.println(result.getCreatedDate());
      System.out.println(result.getId());
      System.out.println(result.getIsCustom());
      System.out.println(result.getItems());
      System.out.println(result.getNextPaymentDate());
      System.out.println(result.getOccurrences());
      System.out.println(result.getPaymentOption());
      System.out.println(result.getPaymentScheduleNumber());
      System.out.println(result.getPeriod());
      System.out.println(result.getPrepayment());
      System.out.println(result.getRecentPaymentDate());
      System.out.println(result.getRunHour());
      System.out.println(result.getStandalone());
      System.out.println(result.getStartDate());
      System.out.println(result.getStatus());
      System.out.println(result.getSuccess());
      System.out.println(result.getTotalAmount());
      System.out.println(result.getTotalPaymentsErrored());
      System.out.println(result.getTotalPaymentsProcessed());
      System.out.println(result.getUpdatedById());
      System.out.println(result.getUpdatedDate());
    } catch (ApiException e) {
      System.err.println("Exception when calling PaymentSchedulesApi#addItemsToCustomPaymentSchedule");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<GETPaymentScheduleResponse> response = client
              .paymentSchedules
              .addItemsToCustomPaymentSchedule(paymentScheduleKey)
              .items(items)
              .idempotencyKey(idempotencyKey)
              .acceptEncoding(acceptEncoding)
              .contentEncoding(contentEncoding)
              .authorization(authorization)
              .zuoraTrackId(zuoraTrackId)
              .zuoraEntityIds(zuoraEntityIds)
              .zuoraOrgIds(zuoraOrgIds)
              .zuoraVersion(zuoraVersion)
              .executeWithHttpInfo();
      System.out.println(response.getResponseBody());
      System.out.println(response.getResponseHeaders());
      System.out.println(response.getStatusCode());
      System.out.println(response.getRoundTripTime());
      System.out.println(response.getRequest());
    } catch (ApiException e) {
      System.err.println("Exception when calling PaymentSchedulesApi#addItemsToCustomPaymentSchedule");
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
| **paymentScheduleKey** | **String**| The unique ID or number of a payment schedule. For example, &#x60;8a90857b822459cd018224dcb9eb13be&#x60;, or &#x60;PS-00000007&#x60;.  | |
| **poSTAddItemsToPaymentScheduleRequest** | [**POSTAddItemsToPaymentScheduleRequest**](POSTAddItemsToPaymentScheduleRequest.md)|  | |
| **idempotencyKey** | **String**| Specify a unique idempotency key if you want to perform an idempotent POST or PATCH request. Do not use this header in other request types.   With this header specified, the Zuora server can identify subsequent retries of the same request using this value, which prevents the same operation from being performed multiple times by accident.   | [optional] |
| **acceptEncoding** | **String**| Include the &#x60;Accept-Encoding: gzip&#x60; header to compress responses as a gzipped file. It can significantly reduce the bandwidth required for a response.   If specified, Zuora automatically compresses responses that contain over 1000 bytes of data, and the response contains a &#x60;Content-Encoding&#x60; header with the compression algorithm so that your client can decompress it.  | [optional] |
| **contentEncoding** | **String**| Include the &#x60;Content-Encoding: gzip&#x60; header to compress a request. With this header specified, you should upload a gzipped file for the request payload instead of sending the JSON payload.  | [optional] |
| **authorization** | **String**| The value is in the &#x60;Bearer {token}&#x60; format where {token} is a valid OAuth token generated by calling [Create an OAuth token](https://developer.zuora.com/api-references/api/operation/createToken).  | [optional] |
| **zuoraTrackId** | **String**| A custom identifier for tracing the API call. If you set a value for this header, Zuora returns the same value in the response headers. This header enables you to associate your system process identifiers with Zuora API calls, to assist with troubleshooting in the event of an issue.  The value of this field must use the US-ASCII character set and must not include any of the following characters: colon (&#x60;:&#x60;), semicolon (&#x60;;&#x60;), double quote (&#x60;\&quot;&#x60;), and quote (&#x60;&#39;&#x60;).  | [optional] |
| **zuoraEntityIds** | **String**| An entity ID. If you have [Zuora Multi-entity](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Multi-entity) enabled and the OAuth token is valid for more than one entity, you must use this header to specify which entity to perform the operation in. If the OAuth token is only valid for a single entity, or you do not have Zuora Multi-entity enabled, you do not need to set this header.  | [optional] |
| **zuoraOrgIds** | **String**| Comma separated IDs. If you have &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Central_Platform/Multi-Org\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Zuora Multi-Org&lt;/a&gt; enabled,  you can use this header to specify which orgs to perform the operation in. If you do not have Zuora Multi-Org enabled, you should not set this header.  The IDs must be a sub-set of the user&#39;s accessible orgs. If you specify an org that the user does not have access to, the operation fails.  If the header is not set, the operation is performed in scope of the user&#39;s accessible orgs.  | [optional] |
| **zuoraVersion** | **String**| The minor version of the Zuora REST API. See [Minor Version](https://developer.zuora.com/api-references/api/overview/#section/API-Versions/Minor-Version) for information about REST API version control.   This header affects the availability of the following fields: - &#x60;items&#x60; &gt; &#x60;paymentId&#x60;  | [optional] |

### Return type

[**GETPaymentScheduleResponse**](GETPaymentScheduleResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** |  |  * Content-Encoding - This header is returned if you specify the &#x60;Accept-Encoding: gzip&#x60; request header and the response contains over 1000 bytes of data. Note that only the following MIME types support gzipped responses:   - &#x60;application/json&#x60;   - &#x60;application/xml&#x60;   - &#x60;text/html&#x60;   - &#x60;text/csv&#x60;   - &#x60;text/plain&#x60;  <br>  * RateLimit-Limit - The request limit quota for the time window closest to exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Remaining - The number of requests remaining in the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Reset - The number of seconds until the quota resets for the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Zuora-Request-Id - The Zuora internal identifier of the API call. You cannot control the value of this header.  <br>  * Zuora-Track-Id - A custom identifier for tracing the API call. If you specified a tracing identifier in the request headers, Zuora returns the same tracing identifier. Otherwise, Zuora does not set this header.  <br>  |

<a name="cancelPaymentSchedule"></a>
# **cancelPaymentSchedule**
> GETPaymentScheduleResponse cancelPaymentSchedule(paymentScheduleKey, puTCancelPaymentScheduleRequest).acceptEncoding(acceptEncoding).contentEncoding(contentEncoding).authorization(authorization).zuoraTrackId(zuoraTrackId).zuoraEntityIds(zuoraEntityIds).zuoraOrgIds(zuoraOrgIds).zuoraVersion(zuoraVersion).execute();

Cancel a payment schedule

Cancels a payment schedule.  **Note:** - All pending payment schedule items will be canceled, effective from &#x60;cancelDate&#x60;.  - The Payment Schedules feature is in the **Early Adopter** phase. We are actively soliciting feedback from a small set of early adopters before releasing it as generally available. To manage and access this feature through the self-service interface, see [Manage Features](https://knowledgecenter.zuora.com/Zuora_Payments/Payments_Settings/Manage_Features) in the Knowledge Center. - This operation is only available if you have [Invoice Settlement](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/Invoice_Settlement) enabled. 

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Zuora;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.PaymentSchedulesApi;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Example {
  public static void main(String[] args) {
    Configuration configuration = new Configuration();
    configuration.host = "https://rest.zuora.com";
    Zuora client = new Zuora(configuration);
    LocalDate cancelDate = LocalDate.now(); // Specifies when the payment schedule will be canceled. 
    String paymentScheduleKey = "paymentScheduleKey_example"; // The unique ID or number of a payment schedule. For example, `8a90857b822459cd018224dcb9eb13be`, or `PS-00000007`. 
    String acceptEncoding = "acceptEncoding_example"; // Include the `Accept-Encoding: gzip` header to compress responses as a gzipped file. It can significantly reduce the bandwidth required for a response.   If specified, Zuora automatically compresses responses that contain over 1000 bytes of data, and the response contains a `Content-Encoding` header with the compression algorithm so that your client can decompress it. 
    String contentEncoding = "contentEncoding_example"; // Include the `Content-Encoding: gzip` header to compress a request. With this header specified, you should upload a gzipped file for the request payload instead of sending the JSON payload. 
    String authorization = "authorization_example"; // The value is in the `Bearer {token}` format where {token} is a valid OAuth token generated by calling [Create an OAuth token](https://developer.zuora.com/api-references/api/operation/createToken). 
    String zuoraTrackId = "zuoraTrackId_example"; // A custom identifier for tracing the API call. If you set a value for this header, Zuora returns the same value in the response headers. This header enables you to associate your system process identifiers with Zuora API calls, to assist with troubleshooting in the event of an issue.  The value of this field must use the US-ASCII character set and must not include any of the following characters: colon (`:`), semicolon (`;`), double quote (`\"`), and quote (`'`). 
    String zuoraEntityIds = "zuoraEntityIds_example"; // An entity ID. If you have [Zuora Multi-entity](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Multi-entity) enabled and the OAuth token is valid for more than one entity, you must use this header to specify which entity to perform the operation in. If the OAuth token is only valid for a single entity, or you do not have Zuora Multi-entity enabled, you do not need to set this header. 
    String zuoraOrgIds = "zuoraOrgIds_example"; // Comma separated IDs. If you have <a href=\"https://knowledgecenter.zuora.com/Zuora_Central_Platform/Multi-Org\" target=\"_blank\">Zuora Multi-Org</a> enabled,  you can use this header to specify which orgs to perform the operation in. If you do not have Zuora Multi-Org enabled, you should not set this header.  The IDs must be a sub-set of the user's accessible orgs. If you specify an org that the user does not have access to, the operation fails.  If the header is not set, the operation is performed in scope of the user's accessible orgs. 
    String zuoraVersion = "zuoraVersion_example"; // The minor version of the Zuora REST API. See [Minor Version](https://developer.zuora.com/api-references/api/overview/#section/API-Versions/Minor-Version) for information about REST API version control.   This header affects the availability of the followiing response fields:   - `items` > `paymentId` 
    try {
      GETPaymentScheduleResponse result = client
              .paymentSchedules
              .cancelPaymentSchedule(cancelDate, paymentScheduleKey)
              .acceptEncoding(acceptEncoding)
              .contentEncoding(contentEncoding)
              .authorization(authorization)
              .zuoraTrackId(zuoraTrackId)
              .zuoraEntityIds(zuoraEntityIds)
              .zuoraOrgIds(zuoraOrgIds)
              .zuoraVersion(zuoraVersion)
              .execute();
      System.out.println(result);
      System.out.println(result.getDescription());
      System.out.println(result.getAccountId());
      System.out.println(result.getAccountNumber());
      System.out.println(result.getBillingDocument());
      System.out.println(result.getCreatedById());
      System.out.println(result.getCreatedDate());
      System.out.println(result.getId());
      System.out.println(result.getIsCustom());
      System.out.println(result.getItems());
      System.out.println(result.getNextPaymentDate());
      System.out.println(result.getOccurrences());
      System.out.println(result.getPaymentOption());
      System.out.println(result.getPaymentScheduleNumber());
      System.out.println(result.getPeriod());
      System.out.println(result.getPrepayment());
      System.out.println(result.getRecentPaymentDate());
      System.out.println(result.getRunHour());
      System.out.println(result.getStandalone());
      System.out.println(result.getStartDate());
      System.out.println(result.getStatus());
      System.out.println(result.getSuccess());
      System.out.println(result.getTotalAmount());
      System.out.println(result.getTotalPaymentsErrored());
      System.out.println(result.getTotalPaymentsProcessed());
      System.out.println(result.getUpdatedById());
      System.out.println(result.getUpdatedDate());
    } catch (ApiException e) {
      System.err.println("Exception when calling PaymentSchedulesApi#cancelPaymentSchedule");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<GETPaymentScheduleResponse> response = client
              .paymentSchedules
              .cancelPaymentSchedule(cancelDate, paymentScheduleKey)
              .acceptEncoding(acceptEncoding)
              .contentEncoding(contentEncoding)
              .authorization(authorization)
              .zuoraTrackId(zuoraTrackId)
              .zuoraEntityIds(zuoraEntityIds)
              .zuoraOrgIds(zuoraOrgIds)
              .zuoraVersion(zuoraVersion)
              .executeWithHttpInfo();
      System.out.println(response.getResponseBody());
      System.out.println(response.getResponseHeaders());
      System.out.println(response.getStatusCode());
      System.out.println(response.getRoundTripTime());
      System.out.println(response.getRequest());
    } catch (ApiException e) {
      System.err.println("Exception when calling PaymentSchedulesApi#cancelPaymentSchedule");
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
| **paymentScheduleKey** | **String**| The unique ID or number of a payment schedule. For example, &#x60;8a90857b822459cd018224dcb9eb13be&#x60;, or &#x60;PS-00000007&#x60;.  | |
| **puTCancelPaymentScheduleRequest** | [**PUTCancelPaymentScheduleRequest**](PUTCancelPaymentScheduleRequest.md)|  | |
| **acceptEncoding** | **String**| Include the &#x60;Accept-Encoding: gzip&#x60; header to compress responses as a gzipped file. It can significantly reduce the bandwidth required for a response.   If specified, Zuora automatically compresses responses that contain over 1000 bytes of data, and the response contains a &#x60;Content-Encoding&#x60; header with the compression algorithm so that your client can decompress it.  | [optional] |
| **contentEncoding** | **String**| Include the &#x60;Content-Encoding: gzip&#x60; header to compress a request. With this header specified, you should upload a gzipped file for the request payload instead of sending the JSON payload.  | [optional] |
| **authorization** | **String**| The value is in the &#x60;Bearer {token}&#x60; format where {token} is a valid OAuth token generated by calling [Create an OAuth token](https://developer.zuora.com/api-references/api/operation/createToken).  | [optional] |
| **zuoraTrackId** | **String**| A custom identifier for tracing the API call. If you set a value for this header, Zuora returns the same value in the response headers. This header enables you to associate your system process identifiers with Zuora API calls, to assist with troubleshooting in the event of an issue.  The value of this field must use the US-ASCII character set and must not include any of the following characters: colon (&#x60;:&#x60;), semicolon (&#x60;;&#x60;), double quote (&#x60;\&quot;&#x60;), and quote (&#x60;&#39;&#x60;).  | [optional] |
| **zuoraEntityIds** | **String**| An entity ID. If you have [Zuora Multi-entity](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Multi-entity) enabled and the OAuth token is valid for more than one entity, you must use this header to specify which entity to perform the operation in. If the OAuth token is only valid for a single entity, or you do not have Zuora Multi-entity enabled, you do not need to set this header.  | [optional] |
| **zuoraOrgIds** | **String**| Comma separated IDs. If you have &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Central_Platform/Multi-Org\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Zuora Multi-Org&lt;/a&gt; enabled,  you can use this header to specify which orgs to perform the operation in. If you do not have Zuora Multi-Org enabled, you should not set this header.  The IDs must be a sub-set of the user&#39;s accessible orgs. If you specify an org that the user does not have access to, the operation fails.  If the header is not set, the operation is performed in scope of the user&#39;s accessible orgs.  | [optional] |
| **zuoraVersion** | **String**| The minor version of the Zuora REST API. See [Minor Version](https://developer.zuora.com/api-references/api/overview/#section/API-Versions/Minor-Version) for information about REST API version control.   This header affects the availability of the followiing response fields:   - &#x60;items&#x60; &gt; &#x60;paymentId&#x60;  | [optional] |

### Return type

[**GETPaymentScheduleResponse**](GETPaymentScheduleResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** |  |  * Content-Encoding - This header is returned if you specify the &#x60;Accept-Encoding: gzip&#x60; request header and the response contains over 1000 bytes of data. Note that only the following MIME types support gzipped responses:   - &#x60;application/json&#x60;   - &#x60;application/xml&#x60;   - &#x60;text/html&#x60;   - &#x60;text/csv&#x60;   - &#x60;text/plain&#x60;  <br>  * RateLimit-Limit - The request limit quota for the time window closest to exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Remaining - The number of requests remaining in the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Reset - The number of seconds until the quota resets for the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Zuora-Request-Id - The Zuora internal identifier of the API call. You cannot control the value of this header.  <br>  * Zuora-Track-Id - A custom identifier for tracing the API call. If you specified a tracing identifier in the request headers, Zuora returns the same tracing identifier. Otherwise, Zuora does not set this header.  <br>  |

<a name="cancelPaymentScheduleItem"></a>
# **cancelPaymentScheduleItem**
> PUTPaymentScheduleItemResponse cancelPaymentScheduleItem(itemId).acceptEncoding(acceptEncoding).contentEncoding(contentEncoding).authorization(authorization).zuoraTrackId(zuoraTrackId).zuoraEntityIds(zuoraEntityIds).zuoraOrgIds(zuoraOrgIds).zuoraVersion(zuoraVersion).execute();

Cancel a payment schedule item

Cancels a payment schedule item by ID.  **Note:** - The Payment Schedules feature is in the **Early Adopter** phase. We are actively soliciting feedback from a small set of early adopters before releasing it as generally available. To manage and access this feature through the self-service interface, see [Manage Features](https://knowledgecenter.zuora.com/Zuora_Payments/Payments_Settings/Manage_Features) in the Knowledge Center. - This operation is only available if you have [Invoice Settlement](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/Invoice_Settlement) enabled. 

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Zuora;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.PaymentSchedulesApi;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Example {
  public static void main(String[] args) {
    Configuration configuration = new Configuration();
    configuration.host = "https://rest.zuora.com";
    Zuora client = new Zuora(configuration);
    String itemId = "itemId_example"; // The unique ID of a payment schedule item.      
    String acceptEncoding = "acceptEncoding_example"; // Include the `Accept-Encoding: gzip` header to compress responses as a gzipped file. It can significantly reduce the bandwidth required for a response.   If specified, Zuora automatically compresses responses that contain over 1000 bytes of data, and the response contains a `Content-Encoding` header with the compression algorithm so that your client can decompress it. 
    String contentEncoding = "contentEncoding_example"; // Include the `Content-Encoding: gzip` header to compress a request. With this header specified, you should upload a gzipped file for the request payload instead of sending the JSON payload. 
    String authorization = "authorization_example"; // The value is in the `Bearer {token}` format where {token} is a valid OAuth token generated by calling [Create an OAuth token](https://developer.zuora.com/api-references/api/operation/createToken). 
    String zuoraTrackId = "zuoraTrackId_example"; // A custom identifier for tracing the API call. If you set a value for this header, Zuora returns the same value in the response headers. This header enables you to associate your system process identifiers with Zuora API calls, to assist with troubleshooting in the event of an issue.  The value of this field must use the US-ASCII character set and must not include any of the following characters: colon (`:`), semicolon (`;`), double quote (`\"`), and quote (`'`). 
    String zuoraEntityIds = "zuoraEntityIds_example"; // An entity ID. If you have [Zuora Multi-entity](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Multi-entity) enabled and the OAuth token is valid for more than one entity, you must use this header to specify which entity to perform the operation in. If the OAuth token is only valid for a single entity, or you do not have Zuora Multi-entity enabled, you do not need to set this header. 
    String zuoraOrgIds = "zuoraOrgIds_example"; // Comma separated IDs. If you have <a href=\"https://knowledgecenter.zuora.com/Zuora_Central_Platform/Multi-Org\" target=\"_blank\">Zuora Multi-Org</a> enabled,  you can use this header to specify which orgs to perform the operation in. If you do not have Zuora Multi-Org enabled, you should not set this header.  The IDs must be a sub-set of the user's accessible orgs. If you specify an org that the user does not have access to, the operation fails.  If the header is not set, the operation is performed in scope of the user's accessible orgs. 
    String zuoraVersion = "zuoraVersion_example"; // The minor version of the Zuora REST API. See [Minor Version](https://developer.zuora.com/api-references/api/overview/#section/API-Versions/Minor-Version) for information about REST API version control.   This header affects the availability of the following response fields: - `paymentId` 
    try {
      PUTPaymentScheduleItemResponse result = client
              .paymentSchedules
              .cancelPaymentScheduleItem(itemId)
              .acceptEncoding(acceptEncoding)
              .contentEncoding(contentEncoding)
              .authorization(authorization)
              .zuoraTrackId(zuoraTrackId)
              .zuoraEntityIds(zuoraEntityIds)
              .zuoraOrgIds(zuoraOrgIds)
              .zuoraVersion(zuoraVersion)
              .execute();
      System.out.println(result);
      System.out.println(result.getDescription());
      System.out.println(result.getAccountId());
      System.out.println(result.getAmount());
      System.out.println(result.getBalance());
      System.out.println(result.getBillingDocument());
      System.out.println(result.getCancellationReason());
      System.out.println(result.getCreatedById());
      System.out.println(result.getCreatedDate());
      System.out.println(result.getCurrency());
      System.out.println(result.getErrorMessage());
      System.out.println(result.getId());
      System.out.println(result.getNumber());
      System.out.println(result.getPaymentGatewayId());
      System.out.println(result.getPaymentId());
      System.out.println(result.getPaymentMethodId());
      System.out.println(result.getPaymentOption());
      System.out.println(result.getPaymentScheduleId());
      System.out.println(result.getPaymentScheduleNumber());
      System.out.println(result.getPsiPayments());
      System.out.println(result.getRunHour());
      System.out.println(result.getScheduledDate());
      System.out.println(result.getStandalone());
      System.out.println(result.getStatus());
      System.out.println(result.getSuccess());
      System.out.println(result.getUpdatedById());
      System.out.println(result.getUpdatedDate());
    } catch (ApiException e) {
      System.err.println("Exception when calling PaymentSchedulesApi#cancelPaymentScheduleItem");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<PUTPaymentScheduleItemResponse> response = client
              .paymentSchedules
              .cancelPaymentScheduleItem(itemId)
              .acceptEncoding(acceptEncoding)
              .contentEncoding(contentEncoding)
              .authorization(authorization)
              .zuoraTrackId(zuoraTrackId)
              .zuoraEntityIds(zuoraEntityIds)
              .zuoraOrgIds(zuoraOrgIds)
              .zuoraVersion(zuoraVersion)
              .executeWithHttpInfo();
      System.out.println(response.getResponseBody());
      System.out.println(response.getResponseHeaders());
      System.out.println(response.getStatusCode());
      System.out.println(response.getRoundTripTime());
      System.out.println(response.getRequest());
    } catch (ApiException e) {
      System.err.println("Exception when calling PaymentSchedulesApi#cancelPaymentScheduleItem");
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
| **itemId** | **String**| The unique ID of a payment schedule item.       | |
| **acceptEncoding** | **String**| Include the &#x60;Accept-Encoding: gzip&#x60; header to compress responses as a gzipped file. It can significantly reduce the bandwidth required for a response.   If specified, Zuora automatically compresses responses that contain over 1000 bytes of data, and the response contains a &#x60;Content-Encoding&#x60; header with the compression algorithm so that your client can decompress it.  | [optional] |
| **contentEncoding** | **String**| Include the &#x60;Content-Encoding: gzip&#x60; header to compress a request. With this header specified, you should upload a gzipped file for the request payload instead of sending the JSON payload.  | [optional] |
| **authorization** | **String**| The value is in the &#x60;Bearer {token}&#x60; format where {token} is a valid OAuth token generated by calling [Create an OAuth token](https://developer.zuora.com/api-references/api/operation/createToken).  | [optional] |
| **zuoraTrackId** | **String**| A custom identifier for tracing the API call. If you set a value for this header, Zuora returns the same value in the response headers. This header enables you to associate your system process identifiers with Zuora API calls, to assist with troubleshooting in the event of an issue.  The value of this field must use the US-ASCII character set and must not include any of the following characters: colon (&#x60;:&#x60;), semicolon (&#x60;;&#x60;), double quote (&#x60;\&quot;&#x60;), and quote (&#x60;&#39;&#x60;).  | [optional] |
| **zuoraEntityIds** | **String**| An entity ID. If you have [Zuora Multi-entity](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Multi-entity) enabled and the OAuth token is valid for more than one entity, you must use this header to specify which entity to perform the operation in. If the OAuth token is only valid for a single entity, or you do not have Zuora Multi-entity enabled, you do not need to set this header.  | [optional] |
| **zuoraOrgIds** | **String**| Comma separated IDs. If you have &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Central_Platform/Multi-Org\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Zuora Multi-Org&lt;/a&gt; enabled,  you can use this header to specify which orgs to perform the operation in. If you do not have Zuora Multi-Org enabled, you should not set this header.  The IDs must be a sub-set of the user&#39;s accessible orgs. If you specify an org that the user does not have access to, the operation fails.  If the header is not set, the operation is performed in scope of the user&#39;s accessible orgs.  | [optional] |
| **zuoraVersion** | **String**| The minor version of the Zuora REST API. See [Minor Version](https://developer.zuora.com/api-references/api/overview/#section/API-Versions/Minor-Version) for information about REST API version control.   This header affects the availability of the following response fields: - &#x60;paymentId&#x60;  | [optional] |

### Return type

[**PUTPaymentScheduleItemResponse**](PUTPaymentScheduleItemResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** |  |  * Content-Encoding - This header is returned if you specify the &#x60;Accept-Encoding: gzip&#x60; request header and the response contains over 1000 bytes of data. Note that only the following MIME types support gzipped responses:   - &#x60;application/json&#x60;   - &#x60;application/xml&#x60;   - &#x60;text/html&#x60;   - &#x60;text/csv&#x60;   - &#x60;text/plain&#x60;  <br>  * RateLimit-Limit - The request limit quota for the time window closest to exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Remaining - The number of requests remaining in the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Reset - The number of seconds until the quota resets for the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Zuora-Request-Id - The Zuora internal identifier of the API call. You cannot control the value of this header.  <br>  * Zuora-Track-Id - A custom identifier for tracing the API call. If you specified a tracing identifier in the request headers, Zuora returns the same tracing identifier. Otherwise, Zuora does not set this header.  <br>  |

<a name="paymentSchedule"></a>
# **paymentSchedule**
> POSTPaymentScheduleResponse paymentSchedule(poSTPaymentScheduleRequest).idempotencyKey(idempotencyKey).acceptEncoding(acceptEncoding).contentEncoding(contentEncoding).authorization(authorization).zuoraTrackId(zuoraTrackId).zuoraEntityIds(zuoraEntityIds).zuoraOrgIds(zuoraOrgIds).zuoraVersion(zuoraVersion).execute();

Create a payment schedule

Creates a payment schedule. You can create either recurring payment schedules or custom payment schedules.  **Note:** - This operation is only available if you have [Invoice Settlement](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/Invoice_Settlement) enabled. - You can choose to use payment schedules to process payments associated with billing documents or unapplied payments. If Standalone Payment is enabled, you can also use payment schedules to process standalone payments. - This operation is version controlled. If you set &#x60;zuora-version&#x60; to &#x60;329.0&#x60;, when creating custom payment schedules associated with billing documents, you need to specify the billing document for each payment schedule item; If &#x60;zuora-version&#x60; is set to &#x60;330.0&#x60;, when creating custom payment schedules associated with billing documents, you only need to specify the billing documents at the payment schedule level. The default version number is &#x60;329.0&#x60;. However, we recommend that you specify the version to &#x60;330.0&#x60;. &#x60;329.0&#x60; will be deprecated soon. 

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Zuora;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.PaymentSchedulesApi;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Example {
  public static void main(String[] args) {
    Configuration configuration = new Configuration();
    configuration.host = "https://rest.zuora.com";
    Zuora client = new Zuora(configuration);
    String description = "description_example"; // Description of the payment schedule. Max length is 255. 
    String accountId = "accountId_example"; // ID of the customer account the payment schedule belongs to.  **Note:** `accountId` and `accountNumber` cannot both be `null`. When both fields are specified, the two values must match each other.           
    String accountNumber = "accountNumber_example"; // Account number of the customer account the payment schedule belongs to.  **Note:** `accountId` and `accountNumber` cannot both be `null`. When both fields are specified, the two values must match each other.           
    Double amount = 3.4D; // The amount of each payment schedule item in the payment schedule.  **Note:** - This field is required when `items` is not specified. - This field will be ignored when `items` is specified. - When creating recurring payment schedules, there are 2 options to specify amounts:     - Specify `totalAmount` and `occurrences`, `amount` will be calculated.   - Specify `amount` and `occurrences`, `totalAmount` will be calculated.   You must specify either `totalAmount` or `amount`. Specifying both fields at the same time is not allowed. 
    POSTPaymentScheduleRequestAllOfBillingDocument billingDocument = new POSTPaymentScheduleRequestAllOfBillingDocument();
    String currency = "currency_example"; // Currency of the payment schedule.  **Note:** - This field is optional. The default value is the account's default currency. - This field will be ignored when `items` is specified. 
    List<Object> items = null; // Container array for payment schedule items. 
    Integer occurrences = 56; // The number of payment schedule item to be created. Maximum value is 1000.  **Note:** - This field is required when `items` is not specified. - This field will be ignored when `items` is specified.  
    String paymentGatewayId = "paymentGatewayId_example"; // ID of the payment gateway.  **Note:** - This field is optional. The default value is the account's default payment gateway ID. If no payment gateway ID is found on the cusotmer account level, the default value will be the tenant's default payment gateway ID. - This field will be ignored when `items` is specified. 
    String paymentMethodId = "paymentMethodId_example"; // ID of the payment method.  **Note:** - This field is optional. The default value is the account's default payment method ID. - This field will be ignored when `items` is specified.   
    List<PaymentSchedulePaymentOptionFields> paymentOption = Arrays.asList(); // Container for the paymentOption items, which describe the transactional level rules for processing payments. Currently, only the Gateway Options type is supported.   Here is an example: ``` \\\"paymentOption\\\": [   {     \\\"type\\\": \\\"GatewayOptions\\\",     \\\"detail\\\": {       \\\"SecCode\\\":\\\"WEB\\\"     }   } ] ```  `paymentOption` of the payment schedule takes precedence over `paymentOption` of the payment schedule item. 
    String paymentScheduleNumber = "paymentScheduleNumber_example"; // You can use this field to specify the number of the payment schedule. Only characters from the following sets are allowed: A-Z, a-z, 0-9, and `-`.  Payment numbers must start with a letter. In addition,`-` can only be used at most once and cannot be placed at the beginning or the end of the payment numbers.          
    String period = "Monthly"; // The frequency for the payment collection since the `startDate`.  **Note:** - Thie field is required when `items` is not specified. - This field will be ignored when `items` is specified. - If `startDate` is `30` or `31` and `period` is `Monthly`, when in February, payment schedule will use the last day of February for payment collection.  
    Boolean prepayment = true; // Indicates whether the payments created by the payment schedule will be used as reserved payments. This field will only be available if the prepaid cash drawdown permission is enabled. See [Prepaid Cash with Drawdown](https://knowledgecenter.zuora.com/Zuora_Billing/Billing_and_Invoicing/JA_Advanced_Consumption_Billing/Prepaid_Cash_with_Drawdown) for more information. 
    Integer runHour = 56; // Specifies at which hour in the day in the tenant’s time zone when this payment will be collected. Available values: `[0,1,2,~,22,23]`.  **Note:** - If the time difference between your tenant’s timezone and the timezone where Zuora servers are is not in full hours, for example, 2.5 hours, the payment schedule items will be triggered half hour later than your scheduled time. - If the payment `runHour` and `scheduledDate` are backdated, the system will collect the payment when the next runHour occurs. - This field is optional. The default value is `0`. - This field will be ignored when `items` is specified.              
    Boolean standalone = true; // Indicate whether the payments created by the payment schedule are standalone payments or not. When setting to `true`, standalone payments will be created. When setting to `false`, you can either specify a billing document, or not specifying any billing documents. In the later case, unapplied payments will be created. If set to `null`, standalone payment will be created.  **Note**:  - This field is only available if the Standalone Payment is enabled. Do not include this field if Standalone Payment is not enabled. - If Standalone Payment is enabled, default value is `true`. 
    LocalDate startDate = LocalDate.now(); // The date for the first payment collection.  **Note:** - This field is required when `items` is not specified. - This field will be ignored when `items` is specified.               
    Double totalAmount = 3.4D; // The total amount of that the payment schedule will collect. This field is only available for recurring payment schedules.   **Note**: - When creating recurring payment schedules, there are 2 options to specify amounts:      - Specify `totalAmount` and `occurrences`, `amount` will be calculated.   - Specify `amount` and `occurrences`, `totalAmount` will be calculated.      You must specify either `totalAmount` or `amount`. Specifying both fields at the same time is not allowed. - If the Standalone Payments feature is enabled and `standalone` is set to `true` for the payment schedule, `totalAmount` will be ignored. 
    String idempotencyKey = "idempotencyKey_example"; // Specify a unique idempotency key if you want to perform an idempotent POST or PATCH request. Do not use this header in other request types.   With this header specified, the Zuora server can identify subsequent retries of the same request using this value, which prevents the same operation from being performed multiple times by accident.  
    String acceptEncoding = "acceptEncoding_example"; // Include the `Accept-Encoding: gzip` header to compress responses as a gzipped file. It can significantly reduce the bandwidth required for a response.   If specified, Zuora automatically compresses responses that contain over 1000 bytes of data, and the response contains a `Content-Encoding` header with the compression algorithm so that your client can decompress it. 
    String contentEncoding = "contentEncoding_example"; // Include the `Content-Encoding: gzip` header to compress a request. With this header specified, you should upload a gzipped file for the request payload instead of sending the JSON payload. 
    String authorization = "authorization_example"; // The value is in the `Bearer {token}` format where {token} is a valid OAuth token generated by calling [Create an OAuth token](https://developer.zuora.com/api-references/api/operation/createToken). 
    String zuoraTrackId = "zuoraTrackId_example"; // A custom identifier for tracing the API call. If you set a value for this header, Zuora returns the same value in the response headers. This header enables you to associate your system process identifiers with Zuora API calls, to assist with troubleshooting in the event of an issue.  The value of this field must use the US-ASCII character set and must not include any of the following characters: colon (`:`), semicolon (`;`), double quote (`\"`), and quote (`'`). 
    String zuoraEntityIds = "zuoraEntityIds_example"; // An entity ID. If you have [Zuora Multi-entity](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Multi-entity) enabled and the OAuth token is valid for more than one entity, you must use this header to specify which entity to perform the operation in. If the OAuth token is only valid for a single entity, or you do not have Zuora Multi-entity enabled, you do not need to set this header. 
    String zuoraOrgIds = "zuoraOrgIds_example"; // Comma separated IDs. If you have <a href=\"https://knowledgecenter.zuora.com/Zuora_Central_Platform/Multi-Org\" target=\"_blank\">Zuora Multi-Org</a> enabled,  you can use this header to specify which orgs to perform the operation in. If you do not have Zuora Multi-Org enabled, you should not set this header.  The IDs must be a sub-set of the user's accessible orgs. If you specify an org that the user does not have access to, the operation fails.  If the header is not set, the operation is performed in scope of the user's accessible orgs. 
    String zuoraVersion = "zuoraVersion_example"; // The minor version of the Zuora REST API. See [Minor Version](https://developer.zuora.com/api-references/api/overview/#section/API-Versions/Minor-Version) for information about REST API version control.   This header affects the availability of the following request fields: * `billingDocument` * `items` > `billingDocument` 
    try {
      POSTPaymentScheduleResponse result = client
              .paymentSchedules
              .paymentSchedule()
              .description(description)
              .accountId(accountId)
              .accountNumber(accountNumber)
              .amount(amount)
              .billingDocument(billingDocument)
              .currency(currency)
              .items(items)
              .occurrences(occurrences)
              .paymentGatewayId(paymentGatewayId)
              .paymentMethodId(paymentMethodId)
              .paymentOption(paymentOption)
              .paymentScheduleNumber(paymentScheduleNumber)
              .period(period)
              .prepayment(prepayment)
              .runHour(runHour)
              .standalone(standalone)
              .startDate(startDate)
              .totalAmount(totalAmount)
              .idempotencyKey(idempotencyKey)
              .acceptEncoding(acceptEncoding)
              .contentEncoding(contentEncoding)
              .authorization(authorization)
              .zuoraTrackId(zuoraTrackId)
              .zuoraEntityIds(zuoraEntityIds)
              .zuoraOrgIds(zuoraOrgIds)
              .zuoraVersion(zuoraVersion)
              .execute();
      System.out.println(result);
      System.out.println(result.getDescription());
      System.out.println(result.getAccountId());
      System.out.println(result.getAccountNumber());
      System.out.println(result.getBillingDocument());
      System.out.println(result.getCreatedById());
      System.out.println(result.getCreatedDate());
      System.out.println(result.getId());
      System.out.println(result.getIsCustom());
      System.out.println(result.getItems());
      System.out.println(result.getNextPaymentDate());
      System.out.println(result.getOccurrences());
      System.out.println(result.getPaymentOption());
      System.out.println(result.getPaymentScheduleNumber());
      System.out.println(result.getPeriod());
      System.out.println(result.getPrepayment());
      System.out.println(result.getRecentPaymentDate());
      System.out.println(result.getRunHour());
      System.out.println(result.getStandalone());
      System.out.println(result.getStartDate());
      System.out.println(result.getStatus());
      System.out.println(result.getSuccess());
      System.out.println(result.getTotalAmount());
      System.out.println(result.getTotalPaymentsErrored());
      System.out.println(result.getTotalPaymentsProcessed());
      System.out.println(result.getUpdatedById());
      System.out.println(result.getUpdatedDate());
    } catch (ApiException e) {
      System.err.println("Exception when calling PaymentSchedulesApi#paymentSchedule");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<POSTPaymentScheduleResponse> response = client
              .paymentSchedules
              .paymentSchedule()
              .description(description)
              .accountId(accountId)
              .accountNumber(accountNumber)
              .amount(amount)
              .billingDocument(billingDocument)
              .currency(currency)
              .items(items)
              .occurrences(occurrences)
              .paymentGatewayId(paymentGatewayId)
              .paymentMethodId(paymentMethodId)
              .paymentOption(paymentOption)
              .paymentScheduleNumber(paymentScheduleNumber)
              .period(period)
              .prepayment(prepayment)
              .runHour(runHour)
              .standalone(standalone)
              .startDate(startDate)
              .totalAmount(totalAmount)
              .idempotencyKey(idempotencyKey)
              .acceptEncoding(acceptEncoding)
              .contentEncoding(contentEncoding)
              .authorization(authorization)
              .zuoraTrackId(zuoraTrackId)
              .zuoraEntityIds(zuoraEntityIds)
              .zuoraOrgIds(zuoraOrgIds)
              .zuoraVersion(zuoraVersion)
              .executeWithHttpInfo();
      System.out.println(response.getResponseBody());
      System.out.println(response.getResponseHeaders());
      System.out.println(response.getStatusCode());
      System.out.println(response.getRoundTripTime());
      System.out.println(response.getRequest());
    } catch (ApiException e) {
      System.err.println("Exception when calling PaymentSchedulesApi#paymentSchedule");
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
| **poSTPaymentScheduleRequest** | [**POSTPaymentScheduleRequest**](POSTPaymentScheduleRequest.md)|  | |
| **idempotencyKey** | **String**| Specify a unique idempotency key if you want to perform an idempotent POST or PATCH request. Do not use this header in other request types.   With this header specified, the Zuora server can identify subsequent retries of the same request using this value, which prevents the same operation from being performed multiple times by accident.   | [optional] |
| **acceptEncoding** | **String**| Include the &#x60;Accept-Encoding: gzip&#x60; header to compress responses as a gzipped file. It can significantly reduce the bandwidth required for a response.   If specified, Zuora automatically compresses responses that contain over 1000 bytes of data, and the response contains a &#x60;Content-Encoding&#x60; header with the compression algorithm so that your client can decompress it.  | [optional] |
| **contentEncoding** | **String**| Include the &#x60;Content-Encoding: gzip&#x60; header to compress a request. With this header specified, you should upload a gzipped file for the request payload instead of sending the JSON payload.  | [optional] |
| **authorization** | **String**| The value is in the &#x60;Bearer {token}&#x60; format where {token} is a valid OAuth token generated by calling [Create an OAuth token](https://developer.zuora.com/api-references/api/operation/createToken).  | [optional] |
| **zuoraTrackId** | **String**| A custom identifier for tracing the API call. If you set a value for this header, Zuora returns the same value in the response headers. This header enables you to associate your system process identifiers with Zuora API calls, to assist with troubleshooting in the event of an issue.  The value of this field must use the US-ASCII character set and must not include any of the following characters: colon (&#x60;:&#x60;), semicolon (&#x60;;&#x60;), double quote (&#x60;\&quot;&#x60;), and quote (&#x60;&#39;&#x60;).  | [optional] |
| **zuoraEntityIds** | **String**| An entity ID. If you have [Zuora Multi-entity](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Multi-entity) enabled and the OAuth token is valid for more than one entity, you must use this header to specify which entity to perform the operation in. If the OAuth token is only valid for a single entity, or you do not have Zuora Multi-entity enabled, you do not need to set this header.  | [optional] |
| **zuoraOrgIds** | **String**| Comma separated IDs. If you have &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Central_Platform/Multi-Org\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Zuora Multi-Org&lt;/a&gt; enabled,  you can use this header to specify which orgs to perform the operation in. If you do not have Zuora Multi-Org enabled, you should not set this header.  The IDs must be a sub-set of the user&#39;s accessible orgs. If you specify an org that the user does not have access to, the operation fails.  If the header is not set, the operation is performed in scope of the user&#39;s accessible orgs.  | [optional] |
| **zuoraVersion** | **String**| The minor version of the Zuora REST API. See [Minor Version](https://developer.zuora.com/api-references/api/overview/#section/API-Versions/Minor-Version) for information about REST API version control.   This header affects the availability of the following request fields: * &#x60;billingDocument&#x60; * &#x60;items&#x60; &gt; &#x60;billingDocument&#x60;  | [optional] |

### Return type

[**POSTPaymentScheduleResponse**](POSTPaymentScheduleResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** |  |  * Content-Encoding - This header is returned if you specify the &#x60;Accept-Encoding: gzip&#x60; request header and the response contains over 1000 bytes of data. Note that only the following MIME types support gzipped responses:   - &#x60;application/json&#x60;   - &#x60;application/xml&#x60;   - &#x60;text/html&#x60;   - &#x60;text/csv&#x60;   - &#x60;text/plain&#x60;  <br>  * RateLimit-Limit - The request limit quota for the time window closest to exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Remaining - The number of requests remaining in the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Reset - The number of seconds until the quota resets for the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Zuora-Request-Id - The Zuora internal identifier of the API call. You cannot control the value of this header.  <br>  * Zuora-Track-Id - A custom identifier for tracing the API call. If you specified a tracing identifier in the request headers, Zuora returns the same tracing identifier. Otherwise, Zuora does not set this header.  <br>  |

<a name="paymentScheduleItem"></a>
# **paymentScheduleItem**
> GETPaymentScheduleItemResponse paymentScheduleItem(itemId).acceptEncoding(acceptEncoding).contentEncoding(contentEncoding).authorization(authorization).zuoraTrackId(zuoraTrackId).zuoraEntityIds(zuoraEntityIds).zuoraOrgIds(zuoraOrgIds).zuoraVersion(zuoraVersion).execute();

Retrieve a payment schedule item

Retrieves a payment schedule item by ID.  **Note:** - The Payment Schedules feature is in the **Early Adopter** phase. We are actively soliciting feedback from a small set of early adopters before releasing it as generally available. To manage and access this feature through the self-service interface, see [Manage Features](https://knowledgecenter.zuora.com/Zuora_Payments/Payments_Settings/Manage_Features) in the Knowledge Center. - This operation is only available if you have [Invoice Settlement](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/Invoice_Settlement) enabled. 

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Zuora;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.PaymentSchedulesApi;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Example {
  public static void main(String[] args) {
    Configuration configuration = new Configuration();
    configuration.host = "https://rest.zuora.com";
    Zuora client = new Zuora(configuration);
    String itemId = "itemId_example"; // The unique ID of a payment schedule item. 
    String acceptEncoding = "acceptEncoding_example"; // Include the `Accept-Encoding: gzip` header to compress responses as a gzipped file. It can significantly reduce the bandwidth required for a response.   If specified, Zuora automatically compresses responses that contain over 1000 bytes of data, and the response contains a `Content-Encoding` header with the compression algorithm so that your client can decompress it. 
    String contentEncoding = "contentEncoding_example"; // Include the `Content-Encoding: gzip` header to compress a request. With this header specified, you should upload a gzipped file for the request payload instead of sending the JSON payload. 
    String authorization = "authorization_example"; // The value is in the `Bearer {token}` format where {token} is a valid OAuth token generated by calling [Create an OAuth token](https://developer.zuora.com/api-references/api/operation/createToken). 
    String zuoraTrackId = "zuoraTrackId_example"; // A custom identifier for tracing the API call. If you set a value for this header, Zuora returns the same value in the response headers. This header enables you to associate your system process identifiers with Zuora API calls, to assist with troubleshooting in the event of an issue.  The value of this field must use the US-ASCII character set and must not include any of the following characters: colon (`:`), semicolon (`;`), double quote (`\"`), and quote (`'`). 
    String zuoraEntityIds = "zuoraEntityIds_example"; // An entity ID. If you have [Zuora Multi-entity](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Multi-entity) enabled and the OAuth token is valid for more than one entity, you must use this header to specify which entity to perform the operation in. If the OAuth token is only valid for a single entity, or you do not have Zuora Multi-entity enabled, you do not need to set this header. 
    String zuoraOrgIds = "zuoraOrgIds_example"; // Comma separated IDs. If you have <a href=\"https://knowledgecenter.zuora.com/Zuora_Central_Platform/Multi-Org\" target=\"_blank\">Zuora Multi-Org</a> enabled,  you can use this header to specify which orgs to perform the operation in. If you do not have Zuora Multi-Org enabled, you should not set this header.  The IDs must be a sub-set of the user's accessible orgs. If you specify an org that the user does not have access to, the operation fails.  If the header is not set, the operation is performed in scope of the user's accessible orgs. 
    String zuoraVersion = "zuoraVersion_example"; // The minor version of the Zuora REST API. See [Minor Version](https://developer.zuora.com/api-references/api/overview/#section/API-Versions/Minor-Version) for information about REST API version control.   This header affects the availability of the following response fields: - `paymentId` 
    try {
      GETPaymentScheduleItemResponse result = client
              .paymentSchedules
              .paymentScheduleItem(itemId)
              .acceptEncoding(acceptEncoding)
              .contentEncoding(contentEncoding)
              .authorization(authorization)
              .zuoraTrackId(zuoraTrackId)
              .zuoraEntityIds(zuoraEntityIds)
              .zuoraOrgIds(zuoraOrgIds)
              .zuoraVersion(zuoraVersion)
              .execute();
      System.out.println(result);
      System.out.println(result.getDescription());
      System.out.println(result.getAccountId());
      System.out.println(result.getAmount());
      System.out.println(result.getBalance());
      System.out.println(result.getBillingDocument());
      System.out.println(result.getCancellationReason());
      System.out.println(result.getCreatedById());
      System.out.println(result.getCreatedDate());
      System.out.println(result.getCurrency());
      System.out.println(result.getErrorMessage());
      System.out.println(result.getId());
      System.out.println(result.getNumber());
      System.out.println(result.getPaymentGatewayId());
      System.out.println(result.getPaymentId());
      System.out.println(result.getPaymentMethodId());
      System.out.println(result.getPaymentOption());
      System.out.println(result.getPaymentScheduleId());
      System.out.println(result.getPaymentScheduleNumber());
      System.out.println(result.getPsiPayments());
      System.out.println(result.getRunHour());
      System.out.println(result.getScheduledDate());
      System.out.println(result.getStandalone());
      System.out.println(result.getStatus());
      System.out.println(result.getSuccess());
      System.out.println(result.getUpdatedById());
      System.out.println(result.getUpdatedDate());
    } catch (ApiException e) {
      System.err.println("Exception when calling PaymentSchedulesApi#paymentScheduleItem");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<GETPaymentScheduleItemResponse> response = client
              .paymentSchedules
              .paymentScheduleItem(itemId)
              .acceptEncoding(acceptEncoding)
              .contentEncoding(contentEncoding)
              .authorization(authorization)
              .zuoraTrackId(zuoraTrackId)
              .zuoraEntityIds(zuoraEntityIds)
              .zuoraOrgIds(zuoraOrgIds)
              .zuoraVersion(zuoraVersion)
              .executeWithHttpInfo();
      System.out.println(response.getResponseBody());
      System.out.println(response.getResponseHeaders());
      System.out.println(response.getStatusCode());
      System.out.println(response.getRoundTripTime());
      System.out.println(response.getRequest());
    } catch (ApiException e) {
      System.err.println("Exception when calling PaymentSchedulesApi#paymentScheduleItem");
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
| **itemId** | **String**| The unique ID of a payment schedule item.  | |
| **acceptEncoding** | **String**| Include the &#x60;Accept-Encoding: gzip&#x60; header to compress responses as a gzipped file. It can significantly reduce the bandwidth required for a response.   If specified, Zuora automatically compresses responses that contain over 1000 bytes of data, and the response contains a &#x60;Content-Encoding&#x60; header with the compression algorithm so that your client can decompress it.  | [optional] |
| **contentEncoding** | **String**| Include the &#x60;Content-Encoding: gzip&#x60; header to compress a request. With this header specified, you should upload a gzipped file for the request payload instead of sending the JSON payload.  | [optional] |
| **authorization** | **String**| The value is in the &#x60;Bearer {token}&#x60; format where {token} is a valid OAuth token generated by calling [Create an OAuth token](https://developer.zuora.com/api-references/api/operation/createToken).  | [optional] |
| **zuoraTrackId** | **String**| A custom identifier for tracing the API call. If you set a value for this header, Zuora returns the same value in the response headers. This header enables you to associate your system process identifiers with Zuora API calls, to assist with troubleshooting in the event of an issue.  The value of this field must use the US-ASCII character set and must not include any of the following characters: colon (&#x60;:&#x60;), semicolon (&#x60;;&#x60;), double quote (&#x60;\&quot;&#x60;), and quote (&#x60;&#39;&#x60;).  | [optional] |
| **zuoraEntityIds** | **String**| An entity ID. If you have [Zuora Multi-entity](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Multi-entity) enabled and the OAuth token is valid for more than one entity, you must use this header to specify which entity to perform the operation in. If the OAuth token is only valid for a single entity, or you do not have Zuora Multi-entity enabled, you do not need to set this header.  | [optional] |
| **zuoraOrgIds** | **String**| Comma separated IDs. If you have &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Central_Platform/Multi-Org\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Zuora Multi-Org&lt;/a&gt; enabled,  you can use this header to specify which orgs to perform the operation in. If you do not have Zuora Multi-Org enabled, you should not set this header.  The IDs must be a sub-set of the user&#39;s accessible orgs. If you specify an org that the user does not have access to, the operation fails.  If the header is not set, the operation is performed in scope of the user&#39;s accessible orgs.  | [optional] |
| **zuoraVersion** | **String**| The minor version of the Zuora REST API. See [Minor Version](https://developer.zuora.com/api-references/api/overview/#section/API-Versions/Minor-Version) for information about REST API version control.   This header affects the availability of the following response fields: - &#x60;paymentId&#x60;  | [optional] |

### Return type

[**GETPaymentScheduleItemResponse**](GETPaymentScheduleItemResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** |  |  * Content-Encoding - This header is returned if you specify the &#x60;Accept-Encoding: gzip&#x60; request header and the response contains over 1000 bytes of data. Note that only the following MIME types support gzipped responses:   - &#x60;application/json&#x60;   - &#x60;application/xml&#x60;   - &#x60;text/html&#x60;   - &#x60;text/csv&#x60;   - &#x60;text/plain&#x60;  <br>  * RateLimit-Limit - The request limit quota for the time window closest to exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Remaining - The number of requests remaining in the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Reset - The number of seconds until the quota resets for the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Zuora-Request-Id - The Zuora internal identifier of the API call. You cannot control the value of this header.  <br>  * Zuora-Track-Id - A custom identifier for tracing the API call. If you specified a tracing identifier in the request headers, Zuora returns the same tracing identifier. Otherwise, Zuora does not set this header.  <br>  |

<a name="paymentScheduleItem_0"></a>
# **paymentScheduleItem_0**
> PUTPaymentScheduleItemResponse paymentScheduleItem_0(itemId, puTPaymentScheduleItemRequest).acceptEncoding(acceptEncoding).contentEncoding(contentEncoding).authorization(authorization).zuoraTrackId(zuoraTrackId).zuoraEntityIds(zuoraEntityIds).zuoraOrgIds(zuoraOrgIds).zuoraVersion(zuoraVersion).execute();

Update a payment schedule item

Updates a payment schedule item by ID.  **Note:** - The Payment Schedules feature is in the **Early Adopter** phase. We are actively soliciting feedback from a small set of early adopters before releasing it as generally available. To manag](https://knowledgecenter.zuora.com/Zuora_Payments/Payments_Settings/Manage_Features). - This operation is only available if you have [Invoice Settlement](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/Invoice_Settlement) enabled. - To link a single payment to the payment schedule item, specify the &#x60;paymentID&#x60; field in the request body and set &#x60;zuora-version&#x60; to equal to or smaller than &#x60;336.0&#x60;; To link or unlink multiple payments with the item, specify the &#x60;linkPayments&#x60; and &#x60;unlinkPayments&#x60; field in the request body.  - The maximum number of payments that are allowed to be linked to a payment schedule item is &#x60;10&#x60;. - When unlinking and linking payments with the payment schedule item in one request, Zuora will first unlink the linked payments, and then link new payments to the item. 

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Zuora;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.PaymentSchedulesApi;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Example {
  public static void main(String[] args) {
    Configuration configuration = new Configuration();
    configuration.host = "https://rest.zuora.com";
    Zuora client = new Zuora(configuration);
    String itemId = "itemId_example"; // The unique ID of a payment schedule item. 
    String description = "description_example"; // The description of the payment schedule item. 
    Double amount = 3.4D; // The amount of the payment. 
    String currency = "currency_example"; // The currency of the payment. 
    List<String> linkPayments = Arrays.asList(); // Container for payments linked to the payment schedule item. 
    String paymentGatewayId = "paymentGatewayId_example"; // ID of the payment gateway of the payment schedule item. 
    String paymentId = "paymentId_example"; // ID of the payment to be linked to the payment schedule item.  **Note**: This feild is version controlled. To enable this field, you must set `zuora-version` to equal or smaller than `336.0`. 
    String paymentMethodId = "paymentMethodId_example"; // ID of the payment method of the payment schedule item. 
    List<PaymentSchedulePaymentOptionFields> paymentOption = Arrays.asList(); // Container for the paymentOption items, which describe the transactional level rules for processing payments. Currently, only the Gateway Options type is supported.  Here is an example: ``` \\\"paymentOption\\\": [   {     \\\"type\\\": \\\"GatewayOptions\\\",     \\\"detail\\\": {       \\\"SecCode\\\":\\\"WEB\\\"     }   } ] ```  `paymentOption` of the payment schedule takes precedence over `paymentOption` of the payment schedule item. 
    Integer runHour = 56; // At which hour of the day in the tenant’s timezone this payment will be collected. If the payment `runHour` and `scheduledDate` are backdated, the system will collect the payment when the next runHour occurs. 
    LocalDate scheduledDate = LocalDate.now(); // The scheduled date when the payment is processed. 
    List<String> unlinkPayments = Arrays.asList(); // Container for payments to be unlinked from the payment schedule item. 
    String acceptEncoding = "acceptEncoding_example"; // Include the `Accept-Encoding: gzip` header to compress responses as a gzipped file. It can significantly reduce the bandwidth required for a response.   If specified, Zuora automatically compresses responses that contain over 1000 bytes of data, and the response contains a `Content-Encoding` header with the compression algorithm so that your client can decompress it. 
    String contentEncoding = "contentEncoding_example"; // Include the `Content-Encoding: gzip` header to compress a request. With this header specified, you should upload a gzipped file for the request payload instead of sending the JSON payload. 
    String authorization = "authorization_example"; // The value is in the `Bearer {token}` format where {token} is a valid OAuth token generated by calling [Create an OAuth token](https://developer.zuora.com/api-references/api/operation/createToken). 
    String zuoraTrackId = "zuoraTrackId_example"; // A custom identifier for tracing the API call. If you set a value for this header, Zuora returns the same value in the response headers. This header enables you to associate your system process identifiers with Zuora API calls, to assist with troubleshooting in the event of an issue.  The value of this field must use the US-ASCII character set and must not include any of the following characters: colon (`:`), semicolon (`;`), double quote (`\"`), and quote (`'`). 
    String zuoraEntityIds = "zuoraEntityIds_example"; // An entity ID. If you have [Zuora Multi-entity](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Multi-entity) enabled and the OAuth token is valid for more than one entity, you must use this header to specify which entity to perform the operation in. If the OAuth token is only valid for a single entity, or you do not have Zuora Multi-entity enabled, you do not need to set this header. 
    String zuoraOrgIds = "zuoraOrgIds_example"; // Comma separated IDs. If you have <a href=\"https://knowledgecenter.zuora.com/Zuora_Central_Platform/Multi-Org\" target=\"_blank\">Zuora Multi-Org</a> enabled,  you can use this header to specify which orgs to perform the operation in. If you do not have Zuora Multi-Org enabled, you should not set this header.  The IDs must be a sub-set of the user's accessible orgs. If you specify an org that the user does not have access to, the operation fails.  If the header is not set, the operation is performed in scope of the user's accessible orgs. 
    String zuoraVersion = "zuoraVersion_example"; // The minor version of the Zuora REST API. See [Minor Version](https://developer.zuora.com/api-references/api/overview/#section/API-Versions/Minor-Version) for information about REST API version control.   This header affects the availability of the following request fields: * `paymentId` * `linkPayments` * `unlinkPayments`  This header affects the availability of the following response fields: * `paymentId`             
    try {
      PUTPaymentScheduleItemResponse result = client
              .paymentSchedules
              .paymentScheduleItem_0(itemId)
              .description(description)
              .amount(amount)
              .currency(currency)
              .linkPayments(linkPayments)
              .paymentGatewayId(paymentGatewayId)
              .paymentId(paymentId)
              .paymentMethodId(paymentMethodId)
              .paymentOption(paymentOption)
              .runHour(runHour)
              .scheduledDate(scheduledDate)
              .unlinkPayments(unlinkPayments)
              .acceptEncoding(acceptEncoding)
              .contentEncoding(contentEncoding)
              .authorization(authorization)
              .zuoraTrackId(zuoraTrackId)
              .zuoraEntityIds(zuoraEntityIds)
              .zuoraOrgIds(zuoraOrgIds)
              .zuoraVersion(zuoraVersion)
              .execute();
      System.out.println(result);
      System.out.println(result.getDescription());
      System.out.println(result.getAccountId());
      System.out.println(result.getAmount());
      System.out.println(result.getBalance());
      System.out.println(result.getBillingDocument());
      System.out.println(result.getCancellationReason());
      System.out.println(result.getCreatedById());
      System.out.println(result.getCreatedDate());
      System.out.println(result.getCurrency());
      System.out.println(result.getErrorMessage());
      System.out.println(result.getId());
      System.out.println(result.getNumber());
      System.out.println(result.getPaymentGatewayId());
      System.out.println(result.getPaymentId());
      System.out.println(result.getPaymentMethodId());
      System.out.println(result.getPaymentOption());
      System.out.println(result.getPaymentScheduleId());
      System.out.println(result.getPaymentScheduleNumber());
      System.out.println(result.getPsiPayments());
      System.out.println(result.getRunHour());
      System.out.println(result.getScheduledDate());
      System.out.println(result.getStandalone());
      System.out.println(result.getStatus());
      System.out.println(result.getSuccess());
      System.out.println(result.getUpdatedById());
      System.out.println(result.getUpdatedDate());
    } catch (ApiException e) {
      System.err.println("Exception when calling PaymentSchedulesApi#paymentScheduleItem_0");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<PUTPaymentScheduleItemResponse> response = client
              .paymentSchedules
              .paymentScheduleItem_0(itemId)
              .description(description)
              .amount(amount)
              .currency(currency)
              .linkPayments(linkPayments)
              .paymentGatewayId(paymentGatewayId)
              .paymentId(paymentId)
              .paymentMethodId(paymentMethodId)
              .paymentOption(paymentOption)
              .runHour(runHour)
              .scheduledDate(scheduledDate)
              .unlinkPayments(unlinkPayments)
              .acceptEncoding(acceptEncoding)
              .contentEncoding(contentEncoding)
              .authorization(authorization)
              .zuoraTrackId(zuoraTrackId)
              .zuoraEntityIds(zuoraEntityIds)
              .zuoraOrgIds(zuoraOrgIds)
              .zuoraVersion(zuoraVersion)
              .executeWithHttpInfo();
      System.out.println(response.getResponseBody());
      System.out.println(response.getResponseHeaders());
      System.out.println(response.getStatusCode());
      System.out.println(response.getRoundTripTime());
      System.out.println(response.getRequest());
    } catch (ApiException e) {
      System.err.println("Exception when calling PaymentSchedulesApi#paymentScheduleItem_0");
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
| **itemId** | **String**| The unique ID of a payment schedule item.  | |
| **puTPaymentScheduleItemRequest** | [**PUTPaymentScheduleItemRequest**](PUTPaymentScheduleItemRequest.md)|  | |
| **acceptEncoding** | **String**| Include the &#x60;Accept-Encoding: gzip&#x60; header to compress responses as a gzipped file. It can significantly reduce the bandwidth required for a response.   If specified, Zuora automatically compresses responses that contain over 1000 bytes of data, and the response contains a &#x60;Content-Encoding&#x60; header with the compression algorithm so that your client can decompress it.  | [optional] |
| **contentEncoding** | **String**| Include the &#x60;Content-Encoding: gzip&#x60; header to compress a request. With this header specified, you should upload a gzipped file for the request payload instead of sending the JSON payload.  | [optional] |
| **authorization** | **String**| The value is in the &#x60;Bearer {token}&#x60; format where {token} is a valid OAuth token generated by calling [Create an OAuth token](https://developer.zuora.com/api-references/api/operation/createToken).  | [optional] |
| **zuoraTrackId** | **String**| A custom identifier for tracing the API call. If you set a value for this header, Zuora returns the same value in the response headers. This header enables you to associate your system process identifiers with Zuora API calls, to assist with troubleshooting in the event of an issue.  The value of this field must use the US-ASCII character set and must not include any of the following characters: colon (&#x60;:&#x60;), semicolon (&#x60;;&#x60;), double quote (&#x60;\&quot;&#x60;), and quote (&#x60;&#39;&#x60;).  | [optional] |
| **zuoraEntityIds** | **String**| An entity ID. If you have [Zuora Multi-entity](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Multi-entity) enabled and the OAuth token is valid for more than one entity, you must use this header to specify which entity to perform the operation in. If the OAuth token is only valid for a single entity, or you do not have Zuora Multi-entity enabled, you do not need to set this header.  | [optional] |
| **zuoraOrgIds** | **String**| Comma separated IDs. If you have &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Central_Platform/Multi-Org\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Zuora Multi-Org&lt;/a&gt; enabled,  you can use this header to specify which orgs to perform the operation in. If you do not have Zuora Multi-Org enabled, you should not set this header.  The IDs must be a sub-set of the user&#39;s accessible orgs. If you specify an org that the user does not have access to, the operation fails.  If the header is not set, the operation is performed in scope of the user&#39;s accessible orgs.  | [optional] |
| **zuoraVersion** | **String**| The minor version of the Zuora REST API. See [Minor Version](https://developer.zuora.com/api-references/api/overview/#section/API-Versions/Minor-Version) for information about REST API version control.   This header affects the availability of the following request fields: * &#x60;paymentId&#x60; * &#x60;linkPayments&#x60; * &#x60;unlinkPayments&#x60;  This header affects the availability of the following response fields: * &#x60;paymentId&#x60;              | [optional] |

### Return type

[**PUTPaymentScheduleItemResponse**](PUTPaymentScheduleItemResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** |  |  * Content-Encoding - This header is returned if you specify the &#x60;Accept-Encoding: gzip&#x60; request header and the response contains over 1000 bytes of data. Note that only the following MIME types support gzipped responses:   - &#x60;application/json&#x60;   - &#x60;application/xml&#x60;   - &#x60;text/html&#x60;   - &#x60;text/csv&#x60;   - &#x60;text/plain&#x60;  <br>  * RateLimit-Limit - The request limit quota for the time window closest to exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Remaining - The number of requests remaining in the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Reset - The number of seconds until the quota resets for the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Zuora-Request-Id - The Zuora internal identifier of the API call. You cannot control the value of this header.  <br>  * Zuora-Track-Id - A custom identifier for tracing the API call. If you specified a tracing identifier in the request headers, Zuora returns the same tracing identifier. Otherwise, Zuora does not set this header.  <br>  |

<a name="paymentScheduleStatistic"></a>
# **paymentScheduleStatistic**
> GETPaymentScheduleStatisticResponse paymentScheduleStatistic(yyyyMmDd).acceptEncoding(acceptEncoding).contentEncoding(contentEncoding).authorization(authorization).zuoraTrackId(zuoraTrackId).zuoraEntityIds(zuoraEntityIds).zuoraOrgIds(zuoraOrgIds).execute();

Retrieve payment schedule statistic of a date

Retrieves the payment schedule statistic of a specific date.  **Note:** - The Payment Schedules feature is in the **Early Adopter** phase. We are actively soliciting feedback from a small set of early adopters before releasing it as generally available. To manage and access this feature through the self-service interface, see [Manage Features](https://knowledgecenter.zuora.com/Zuora_Payments/Payments_Settings/Manage_Features) in the Knowledge Center. 

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Zuora;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.PaymentSchedulesApi;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Example {
  public static void main(String[] args) {
    Configuration configuration = new Configuration();
    configuration.host = "https://rest.zuora.com";
    Zuora client = new Zuora(configuration);
    LocalDate yyyyMmDd = LocalDate.now(); // Specifies the date of the payment schedule statistic you want to view.  
    String acceptEncoding = "acceptEncoding_example"; // Include the `Accept-Encoding: gzip` header to compress responses as a gzipped file. It can significantly reduce the bandwidth required for a response.   If specified, Zuora automatically compresses responses that contain over 1000 bytes of data, and the response contains a `Content-Encoding` header with the compression algorithm so that your client can decompress it. 
    String contentEncoding = "contentEncoding_example"; // Include the `Content-Encoding: gzip` header to compress a request. With this header specified, you should upload a gzipped file for the request payload instead of sending the JSON payload. 
    String authorization = "authorization_example"; // The value is in the `Bearer {token}` format where {token} is a valid OAuth token generated by calling [Create an OAuth token](https://developer.zuora.com/api-references/api/operation/createToken). 
    String zuoraTrackId = "zuoraTrackId_example"; // A custom identifier for tracing the API call. If you set a value for this header, Zuora returns the same value in the response headers. This header enables you to associate your system process identifiers with Zuora API calls, to assist with troubleshooting in the event of an issue.  The value of this field must use the US-ASCII character set and must not include any of the following characters: colon (`:`), semicolon (`;`), double quote (`\"`), and quote (`'`). 
    String zuoraEntityIds = "zuoraEntityIds_example"; // An entity ID. If you have [Zuora Multi-entity](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Multi-entity) enabled and the OAuth token is valid for more than one entity, you must use this header to specify which entity to perform the operation in. If the OAuth token is only valid for a single entity, or you do not have Zuora Multi-entity enabled, you do not need to set this header. 
    String zuoraOrgIds = "zuoraOrgIds_example"; // Comma separated IDs. If you have <a href=\"https://knowledgecenter.zuora.com/Zuora_Central_Platform/Multi-Org\" target=\"_blank\">Zuora Multi-Org</a> enabled,  you can use this header to specify which orgs to perform the operation in. If you do not have Zuora Multi-Org enabled, you should not set this header.  The IDs must be a sub-set of the user's accessible orgs. If you specify an org that the user does not have access to, the operation fails.  If the header is not set, the operation is performed in scope of the user's accessible orgs. 
    try {
      GETPaymentScheduleStatisticResponse result = client
              .paymentSchedules
              .paymentScheduleStatistic(yyyyMmDd)
              .acceptEncoding(acceptEncoding)
              .contentEncoding(contentEncoding)
              .authorization(authorization)
              .zuoraTrackId(zuoraTrackId)
              .zuoraEntityIds(zuoraEntityIds)
              .zuoraOrgIds(zuoraOrgIds)
              .execute();
      System.out.println(result);
      System.out.println(result.getDate());
      System.out.println(result.getPaymentRuns());
      System.out.println(result.getPaymentScheduleItems());
      System.out.println(result.getSuccess());
    } catch (ApiException e) {
      System.err.println("Exception when calling PaymentSchedulesApi#paymentScheduleStatistic");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<GETPaymentScheduleStatisticResponse> response = client
              .paymentSchedules
              .paymentScheduleStatistic(yyyyMmDd)
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
      System.err.println("Exception when calling PaymentSchedulesApi#paymentScheduleStatistic");
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
| **yyyyMmDd** | **LocalDate**| Specifies the date of the payment schedule statistic you want to view.   | |
| **acceptEncoding** | **String**| Include the &#x60;Accept-Encoding: gzip&#x60; header to compress responses as a gzipped file. It can significantly reduce the bandwidth required for a response.   If specified, Zuora automatically compresses responses that contain over 1000 bytes of data, and the response contains a &#x60;Content-Encoding&#x60; header with the compression algorithm so that your client can decompress it.  | [optional] |
| **contentEncoding** | **String**| Include the &#x60;Content-Encoding: gzip&#x60; header to compress a request. With this header specified, you should upload a gzipped file for the request payload instead of sending the JSON payload.  | [optional] |
| **authorization** | **String**| The value is in the &#x60;Bearer {token}&#x60; format where {token} is a valid OAuth token generated by calling [Create an OAuth token](https://developer.zuora.com/api-references/api/operation/createToken).  | [optional] |
| **zuoraTrackId** | **String**| A custom identifier for tracing the API call. If you set a value for this header, Zuora returns the same value in the response headers. This header enables you to associate your system process identifiers with Zuora API calls, to assist with troubleshooting in the event of an issue.  The value of this field must use the US-ASCII character set and must not include any of the following characters: colon (&#x60;:&#x60;), semicolon (&#x60;;&#x60;), double quote (&#x60;\&quot;&#x60;), and quote (&#x60;&#39;&#x60;).  | [optional] |
| **zuoraEntityIds** | **String**| An entity ID. If you have [Zuora Multi-entity](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Multi-entity) enabled and the OAuth token is valid for more than one entity, you must use this header to specify which entity to perform the operation in. If the OAuth token is only valid for a single entity, or you do not have Zuora Multi-entity enabled, you do not need to set this header.  | [optional] |
| **zuoraOrgIds** | **String**| Comma separated IDs. If you have &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Central_Platform/Multi-Org\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Zuora Multi-Org&lt;/a&gt; enabled,  you can use this header to specify which orgs to perform the operation in. If you do not have Zuora Multi-Org enabled, you should not set this header.  The IDs must be a sub-set of the user&#39;s accessible orgs. If you specify an org that the user does not have access to, the operation fails.  If the header is not set, the operation is performed in scope of the user&#39;s accessible orgs.  | [optional] |

### Return type

[**GETPaymentScheduleStatisticResponse**](GETPaymentScheduleStatisticResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** |  |  * Content-Encoding - This header is returned if you specify the &#x60;Accept-Encoding: gzip&#x60; request header and the response contains over 1000 bytes of data. Note that only the following MIME types support gzipped responses:   - &#x60;application/json&#x60;   - &#x60;application/xml&#x60;   - &#x60;text/html&#x60;   - &#x60;text/csv&#x60;   - &#x60;text/plain&#x60;  <br>  * RateLimit-Limit - The request limit quota for the time window closest to exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Remaining - The number of requests remaining in the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Reset - The number of seconds until the quota resets for the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Zuora-Request-Id - The Zuora internal identifier of the API call. You cannot control the value of this header.  <br>  * Zuora-Track-Id - A custom identifier for tracing the API call. If you specified a tracing identifier in the request headers, Zuora returns the same tracing identifier. Otherwise, Zuora does not set this header.  <br>  |

<a name="paymentScheduleUpdatePreview"></a>
# **paymentScheduleUpdatePreview**
> GETPaymentScheduleResponse paymentScheduleUpdatePreview(paymentScheduleKey, puTPreviewPaymentScheduleRequest).acceptEncoding(acceptEncoding).contentEncoding(contentEncoding).authorization(authorization).zuoraTrackId(zuoraTrackId).zuoraEntityIds(zuoraEntityIds).zuoraOrgIds(zuoraOrgIds).zuoraVersion(zuoraVersion).execute();

Preview the result of payment schedule updates

Preview the result of a payment schedule update. This operation only provides a preview. No changes will be made to the database. For custom payment schedules, only the custom fields on the payment schedules can be udpated. Use the [Update a payment schedule item](https://developer.zuora.com/api-references/api/tag/PUT_PaymentScheduleItem) operation to update payment schedule items of custom payment schedule.  Note the following rules for the &#x60;periodStartDate&#x60;, &#x60;period&#x60;, and &#x60;occurrences&#x60;:  - If &#x60;periodStartDate&#x60; is specified, all pending payment schedule items will be rescheduled using this new &#x60;periodStartDate&#x60;. If &#x60;period&#x60; is changed, we recommend passing in &#x60;periodStartDate&#x60;. Otherwise, the system would use the original start date if there is no processed or canceled items, or the last processed or canceled &#39;&#x60;scheduleDate&#x60; + 1 &#x60;period&#x60;&#39; as the new &#x60;periodStartDate&#x60;. - If only &#x60;occurrences&#x60; is updated, the new item will start with the last processed or canceled &#39;&#x60;scheduleDate&#x60; + 1 &#x60;period&#x60;&#39;.  **Note:** - The Payment Schedules feature is in the **Early Adopter** phase. We are actively soliciting feedback from a small set of early adopters before releasing it as generally available. To manage and access this feature through the self-service interface, see [Manage Features](https://knowledgecenter.zuora.com/Zuora_Payments/Payments_Settings/Manage_Features) in the Knowledge Center. 

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Zuora;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.PaymentSchedulesApi;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Example {
  public static void main(String[] args) {
    Configuration configuration = new Configuration();
    configuration.host = "https://rest.zuora.com";
    Zuora client = new Zuora(configuration);
    String paymentScheduleKey = "paymentScheduleKey_example"; // The unique ID or number of a payment schedule. For example, `8a90857b822459cd018224dcb9eb13be`, or `PS-00000007`. 
    Double amount = 3.4D; // Indicates the updated amount of the pending payment schedule items. 
    String currency = "currency_example"; // Indicates the updated currency of the pending payment schedule items.       
    Integer occurrences = 56; // Indicates the updated number of payment schedule items that are created by the payment schedule. 
    String paymentGatewayId = "paymentGatewayId_example"; // Indicates the updated payment gateway ID of the pending payment schedule items. 
    String paymentMethodId = "paymentMethodId_example"; // Indicates the updated payment method ID of the pending payment schedule items.  
    List<PaymentSchedulePaymentOptionFields> paymentOption = Arrays.asList(); // Container for the paymentOption items, which describe the transactional level rules for processing payments. Currently, only the Gateway Options type is supported.  Here is an example: ``` \\\"paymentOption\\\": [   {     \\\"type\\\": \\\"GatewayOptions\\\",     \\\"detail\\\": {       \\\"SecCode\\\":\\\"WEB\\\"     }   } ] ```  `paymentOption` of the payment schedule takes precedence over `paymentOption` of the payment schedule item. 
    String period = "Monthly"; // Indicates the updated period of the pending payment schedule items. 
    LocalDate periodStartDate = LocalDate.now(); // Indicates the updated collection date for the next pending payment schedule item. 
    Integer runHour = 56; // Specifies at which hour of the day in the tenant’s time zone this payment will be collected. Available values: `[0,1,2,~,22,23]`.    If the time difference between your tenant’s timezone and the timezone where Zuora servers are is not in full hours, for example, 2.5 hours, the payment schedule items will be triggered half hour later than your scheduled time. If the payment `runHour` and `scheduledDate` are backdated, the system will collect the payment when the next runHour occurs. 
    String acceptEncoding = "acceptEncoding_example"; // Include the `Accept-Encoding: gzip` header to compress responses as a gzipped file. It can significantly reduce the bandwidth required for a response.   If specified, Zuora automatically compresses responses that contain over 1000 bytes of data, and the response contains a `Content-Encoding` header with the compression algorithm so that your client can decompress it. 
    String contentEncoding = "contentEncoding_example"; // Include the `Content-Encoding: gzip` header to compress a request. With this header specified, you should upload a gzipped file for the request payload instead of sending the JSON payload. 
    String authorization = "authorization_example"; // The value is in the `Bearer {token}` format where {token} is a valid OAuth token generated by calling [Create an OAuth token](https://developer.zuora.com/api-references/api/operation/createToken). 
    String zuoraTrackId = "zuoraTrackId_example"; // A custom identifier for tracing the API call. If you set a value for this header, Zuora returns the same value in the response headers. This header enables you to associate your system process identifiers with Zuora API calls, to assist with troubleshooting in the event of an issue.  The value of this field must use the US-ASCII character set and must not include any of the following characters: colon (`:`), semicolon (`;`), double quote (`\"`), and quote (`'`). 
    String zuoraEntityIds = "zuoraEntityIds_example"; // An entity ID. If you have [Zuora Multi-entity](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Multi-entity) enabled and the OAuth token is valid for more than one entity, you must use this header to specify which entity to perform the operation in. If the OAuth token is only valid for a single entity, or you do not have Zuora Multi-entity enabled, you do not need to set this header. 
    String zuoraOrgIds = "zuoraOrgIds_example"; // Comma separated IDs. If you have <a href=\"https://knowledgecenter.zuora.com/Zuora_Central_Platform/Multi-Org\" target=\"_blank\">Zuora Multi-Org</a> enabled,  you can use this header to specify which orgs to perform the operation in. If you do not have Zuora Multi-Org enabled, you should not set this header.  The IDs must be a sub-set of the user's accessible orgs. If you specify an org that the user does not have access to, the operation fails.  If the header is not set, the operation is performed in scope of the user's accessible orgs. 
    String zuoraVersion = "zuoraVersion_example"; // The minor version of the Zuora REST API. See [Minor Version](https://developer.zuora.com/api-references/api/overview/#section/API-Versions/Minor-Version) for information about REST API version control.   This header affects the availability of the following fields: - `items` > `paymentId` 
    try {
      GETPaymentScheduleResponse result = client
              .paymentSchedules
              .paymentScheduleUpdatePreview(paymentScheduleKey)
              .amount(amount)
              .currency(currency)
              .occurrences(occurrences)
              .paymentGatewayId(paymentGatewayId)
              .paymentMethodId(paymentMethodId)
              .paymentOption(paymentOption)
              .period(period)
              .periodStartDate(periodStartDate)
              .runHour(runHour)
              .acceptEncoding(acceptEncoding)
              .contentEncoding(contentEncoding)
              .authorization(authorization)
              .zuoraTrackId(zuoraTrackId)
              .zuoraEntityIds(zuoraEntityIds)
              .zuoraOrgIds(zuoraOrgIds)
              .zuoraVersion(zuoraVersion)
              .execute();
      System.out.println(result);
      System.out.println(result.getDescription());
      System.out.println(result.getAccountId());
      System.out.println(result.getAccountNumber());
      System.out.println(result.getBillingDocument());
      System.out.println(result.getCreatedById());
      System.out.println(result.getCreatedDate());
      System.out.println(result.getId());
      System.out.println(result.getIsCustom());
      System.out.println(result.getItems());
      System.out.println(result.getNextPaymentDate());
      System.out.println(result.getOccurrences());
      System.out.println(result.getPaymentOption());
      System.out.println(result.getPaymentScheduleNumber());
      System.out.println(result.getPeriod());
      System.out.println(result.getPrepayment());
      System.out.println(result.getRecentPaymentDate());
      System.out.println(result.getRunHour());
      System.out.println(result.getStandalone());
      System.out.println(result.getStartDate());
      System.out.println(result.getStatus());
      System.out.println(result.getSuccess());
      System.out.println(result.getTotalAmount());
      System.out.println(result.getTotalPaymentsErrored());
      System.out.println(result.getTotalPaymentsProcessed());
      System.out.println(result.getUpdatedById());
      System.out.println(result.getUpdatedDate());
    } catch (ApiException e) {
      System.err.println("Exception when calling PaymentSchedulesApi#paymentScheduleUpdatePreview");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<GETPaymentScheduleResponse> response = client
              .paymentSchedules
              .paymentScheduleUpdatePreview(paymentScheduleKey)
              .amount(amount)
              .currency(currency)
              .occurrences(occurrences)
              .paymentGatewayId(paymentGatewayId)
              .paymentMethodId(paymentMethodId)
              .paymentOption(paymentOption)
              .period(period)
              .periodStartDate(periodStartDate)
              .runHour(runHour)
              .acceptEncoding(acceptEncoding)
              .contentEncoding(contentEncoding)
              .authorization(authorization)
              .zuoraTrackId(zuoraTrackId)
              .zuoraEntityIds(zuoraEntityIds)
              .zuoraOrgIds(zuoraOrgIds)
              .zuoraVersion(zuoraVersion)
              .executeWithHttpInfo();
      System.out.println(response.getResponseBody());
      System.out.println(response.getResponseHeaders());
      System.out.println(response.getStatusCode());
      System.out.println(response.getRoundTripTime());
      System.out.println(response.getRequest());
    } catch (ApiException e) {
      System.err.println("Exception when calling PaymentSchedulesApi#paymentScheduleUpdatePreview");
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
| **paymentScheduleKey** | **String**| The unique ID or number of a payment schedule. For example, &#x60;8a90857b822459cd018224dcb9eb13be&#x60;, or &#x60;PS-00000007&#x60;.  | |
| **puTPreviewPaymentScheduleRequest** | [**PUTPreviewPaymentScheduleRequest**](PUTPreviewPaymentScheduleRequest.md)|  | |
| **acceptEncoding** | **String**| Include the &#x60;Accept-Encoding: gzip&#x60; header to compress responses as a gzipped file. It can significantly reduce the bandwidth required for a response.   If specified, Zuora automatically compresses responses that contain over 1000 bytes of data, and the response contains a &#x60;Content-Encoding&#x60; header with the compression algorithm so that your client can decompress it.  | [optional] |
| **contentEncoding** | **String**| Include the &#x60;Content-Encoding: gzip&#x60; header to compress a request. With this header specified, you should upload a gzipped file for the request payload instead of sending the JSON payload.  | [optional] |
| **authorization** | **String**| The value is in the &#x60;Bearer {token}&#x60; format where {token} is a valid OAuth token generated by calling [Create an OAuth token](https://developer.zuora.com/api-references/api/operation/createToken).  | [optional] |
| **zuoraTrackId** | **String**| A custom identifier for tracing the API call. If you set a value for this header, Zuora returns the same value in the response headers. This header enables you to associate your system process identifiers with Zuora API calls, to assist with troubleshooting in the event of an issue.  The value of this field must use the US-ASCII character set and must not include any of the following characters: colon (&#x60;:&#x60;), semicolon (&#x60;;&#x60;), double quote (&#x60;\&quot;&#x60;), and quote (&#x60;&#39;&#x60;).  | [optional] |
| **zuoraEntityIds** | **String**| An entity ID. If you have [Zuora Multi-entity](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Multi-entity) enabled and the OAuth token is valid for more than one entity, you must use this header to specify which entity to perform the operation in. If the OAuth token is only valid for a single entity, or you do not have Zuora Multi-entity enabled, you do not need to set this header.  | [optional] |
| **zuoraOrgIds** | **String**| Comma separated IDs. If you have &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Central_Platform/Multi-Org\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Zuora Multi-Org&lt;/a&gt; enabled,  you can use this header to specify which orgs to perform the operation in. If you do not have Zuora Multi-Org enabled, you should not set this header.  The IDs must be a sub-set of the user&#39;s accessible orgs. If you specify an org that the user does not have access to, the operation fails.  If the header is not set, the operation is performed in scope of the user&#39;s accessible orgs.  | [optional] |
| **zuoraVersion** | **String**| The minor version of the Zuora REST API. See [Minor Version](https://developer.zuora.com/api-references/api/overview/#section/API-Versions/Minor-Version) for information about REST API version control.   This header affects the availability of the following fields: - &#x60;items&#x60; &gt; &#x60;paymentId&#x60;  | [optional] |

### Return type

[**GETPaymentScheduleResponse**](GETPaymentScheduleResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** |  |  * Content-Encoding - This header is returned if you specify the &#x60;Accept-Encoding: gzip&#x60; request header and the response contains over 1000 bytes of data. Note that only the following MIME types support gzipped responses:   - &#x60;application/json&#x60;   - &#x60;application/xml&#x60;   - &#x60;text/html&#x60;   - &#x60;text/csv&#x60;   - &#x60;text/plain&#x60;  <br>  * RateLimit-Limit - The request limit quota for the time window closest to exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Remaining - The number of requests remaining in the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Reset - The number of seconds until the quota resets for the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Zuora-Request-Id - The Zuora internal identifier of the API call. You cannot control the value of this header.  <br>  * Zuora-Track-Id - A custom identifier for tracing the API call. If you specified a tracing identifier in the request headers, Zuora returns the same tracing identifier. Otherwise, Zuora does not set this header.  <br>  |

<a name="paymentSchedule_0"></a>
# **paymentSchedule_0**
> GETPaymentScheduleResponse paymentSchedule_0(paymentScheduleKey).acceptEncoding(acceptEncoding).contentEncoding(contentEncoding).authorization(authorization).zuoraTrackId(zuoraTrackId).zuoraEntityIds(zuoraEntityIds).zuoraOrgIds(zuoraOrgIds).nextPendingItems(nextPendingItems).lastProcessedItems(lastProcessedItems).zuoraVersion(zuoraVersion).execute();

Retrieve a payment schedule

Retrieves a payment schedule by payment schedule key.  **Note:** - The Payment Schedules feature is in the **Early Adopter** phase. We are actively soliciting feedback from a small set of early adopters before releasing it as generally available. To manage and access this feature through the self-service interface, see [Manage Features](https://knowledgecenter.zuora.com/Zuora_Payments/Payments_Settings/Manage_Features) in the Knowledge Center. - This operation is only available if you have [Invoice Settlement](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/Invoice_Settlement) enabled. 

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Zuora;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.PaymentSchedulesApi;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Example {
  public static void main(String[] args) {
    Configuration configuration = new Configuration();
    configuration.host = "https://rest.zuora.com";
    Zuora client = new Zuora(configuration);
    String paymentScheduleKey = "paymentScheduleKey_example"; // The unique ID or number of a payment schedule. For example, `8a90857b822459cd018224dcb9eb13be`, or `PS-00000007`. 
    String acceptEncoding = "acceptEncoding_example"; // Include the `Accept-Encoding: gzip` header to compress responses as a gzipped file. It can significantly reduce the bandwidth required for a response.   If specified, Zuora automatically compresses responses that contain over 1000 bytes of data, and the response contains a `Content-Encoding` header with the compression algorithm so that your client can decompress it. 
    String contentEncoding = "contentEncoding_example"; // Include the `Content-Encoding: gzip` header to compress a request. With this header specified, you should upload a gzipped file for the request payload instead of sending the JSON payload. 
    String authorization = "authorization_example"; // The value is in the `Bearer {token}` format where {token} is a valid OAuth token generated by calling [Create an OAuth token](https://developer.zuora.com/api-references/api/operation/createToken). 
    String zuoraTrackId = "zuoraTrackId_example"; // A custom identifier for tracing the API call. If you set a value for this header, Zuora returns the same value in the response headers. This header enables you to associate your system process identifiers with Zuora API calls, to assist with troubleshooting in the event of an issue.  The value of this field must use the US-ASCII character set and must not include any of the following characters: colon (`:`), semicolon (`;`), double quote (`\"`), and quote (`'`). 
    String zuoraEntityIds = "zuoraEntityIds_example"; // An entity ID. If you have [Zuora Multi-entity](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Multi-entity) enabled and the OAuth token is valid for more than one entity, you must use this header to specify which entity to perform the operation in. If the OAuth token is only valid for a single entity, or you do not have Zuora Multi-entity enabled, you do not need to set this header. 
    String zuoraOrgIds = "zuoraOrgIds_example"; // Comma separated IDs. If you have <a href=\"https://knowledgecenter.zuora.com/Zuora_Central_Platform/Multi-Org\" target=\"_blank\">Zuora Multi-Org</a> enabled,  you can use this header to specify which orgs to perform the operation in. If you do not have Zuora Multi-Org enabled, you should not set this header.  The IDs must be a sub-set of the user's accessible orgs. If you specify an org that the user does not have access to, the operation fails.  If the header is not set, the operation is performed in scope of the user's accessible orgs. 
    Integer nextPendingItems = 56; // Number of next pending payment schedule items displayed in the response body. 
    Integer lastProcessedItems = 56; // Number of the most recent processed payment schedule items dispalyed in the response body. 
    String zuoraVersion = "zuoraVersion_example"; // The minor version of the Zuora REST API. See [Minor Version](https://developer.zuora.com/api-references/api/overview/#section/API-Versions/Minor-Version) for information about REST API version control.   This header affects the availability of the following response fields:   - `items` > `paymentId` 
    try {
      GETPaymentScheduleResponse result = client
              .paymentSchedules
              .paymentSchedule_0(paymentScheduleKey)
              .acceptEncoding(acceptEncoding)
              .contentEncoding(contentEncoding)
              .authorization(authorization)
              .zuoraTrackId(zuoraTrackId)
              .zuoraEntityIds(zuoraEntityIds)
              .zuoraOrgIds(zuoraOrgIds)
              .nextPendingItems(nextPendingItems)
              .lastProcessedItems(lastProcessedItems)
              .zuoraVersion(zuoraVersion)
              .execute();
      System.out.println(result);
      System.out.println(result.getDescription());
      System.out.println(result.getAccountId());
      System.out.println(result.getAccountNumber());
      System.out.println(result.getBillingDocument());
      System.out.println(result.getCreatedById());
      System.out.println(result.getCreatedDate());
      System.out.println(result.getId());
      System.out.println(result.getIsCustom());
      System.out.println(result.getItems());
      System.out.println(result.getNextPaymentDate());
      System.out.println(result.getOccurrences());
      System.out.println(result.getPaymentOption());
      System.out.println(result.getPaymentScheduleNumber());
      System.out.println(result.getPeriod());
      System.out.println(result.getPrepayment());
      System.out.println(result.getRecentPaymentDate());
      System.out.println(result.getRunHour());
      System.out.println(result.getStandalone());
      System.out.println(result.getStartDate());
      System.out.println(result.getStatus());
      System.out.println(result.getSuccess());
      System.out.println(result.getTotalAmount());
      System.out.println(result.getTotalPaymentsErrored());
      System.out.println(result.getTotalPaymentsProcessed());
      System.out.println(result.getUpdatedById());
      System.out.println(result.getUpdatedDate());
    } catch (ApiException e) {
      System.err.println("Exception when calling PaymentSchedulesApi#paymentSchedule_0");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<GETPaymentScheduleResponse> response = client
              .paymentSchedules
              .paymentSchedule_0(paymentScheduleKey)
              .acceptEncoding(acceptEncoding)
              .contentEncoding(contentEncoding)
              .authorization(authorization)
              .zuoraTrackId(zuoraTrackId)
              .zuoraEntityIds(zuoraEntityIds)
              .zuoraOrgIds(zuoraOrgIds)
              .nextPendingItems(nextPendingItems)
              .lastProcessedItems(lastProcessedItems)
              .zuoraVersion(zuoraVersion)
              .executeWithHttpInfo();
      System.out.println(response.getResponseBody());
      System.out.println(response.getResponseHeaders());
      System.out.println(response.getStatusCode());
      System.out.println(response.getRoundTripTime());
      System.out.println(response.getRequest());
    } catch (ApiException e) {
      System.err.println("Exception when calling PaymentSchedulesApi#paymentSchedule_0");
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
| **paymentScheduleKey** | **String**| The unique ID or number of a payment schedule. For example, &#x60;8a90857b822459cd018224dcb9eb13be&#x60;, or &#x60;PS-00000007&#x60;.  | |
| **acceptEncoding** | **String**| Include the &#x60;Accept-Encoding: gzip&#x60; header to compress responses as a gzipped file. It can significantly reduce the bandwidth required for a response.   If specified, Zuora automatically compresses responses that contain over 1000 bytes of data, and the response contains a &#x60;Content-Encoding&#x60; header with the compression algorithm so that your client can decompress it.  | [optional] |
| **contentEncoding** | **String**| Include the &#x60;Content-Encoding: gzip&#x60; header to compress a request. With this header specified, you should upload a gzipped file for the request payload instead of sending the JSON payload.  | [optional] |
| **authorization** | **String**| The value is in the &#x60;Bearer {token}&#x60; format where {token} is a valid OAuth token generated by calling [Create an OAuth token](https://developer.zuora.com/api-references/api/operation/createToken).  | [optional] |
| **zuoraTrackId** | **String**| A custom identifier for tracing the API call. If you set a value for this header, Zuora returns the same value in the response headers. This header enables you to associate your system process identifiers with Zuora API calls, to assist with troubleshooting in the event of an issue.  The value of this field must use the US-ASCII character set and must not include any of the following characters: colon (&#x60;:&#x60;), semicolon (&#x60;;&#x60;), double quote (&#x60;\&quot;&#x60;), and quote (&#x60;&#39;&#x60;).  | [optional] |
| **zuoraEntityIds** | **String**| An entity ID. If you have [Zuora Multi-entity](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Multi-entity) enabled and the OAuth token is valid for more than one entity, you must use this header to specify which entity to perform the operation in. If the OAuth token is only valid for a single entity, or you do not have Zuora Multi-entity enabled, you do not need to set this header.  | [optional] |
| **zuoraOrgIds** | **String**| Comma separated IDs. If you have &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Central_Platform/Multi-Org\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Zuora Multi-Org&lt;/a&gt; enabled,  you can use this header to specify which orgs to perform the operation in. If you do not have Zuora Multi-Org enabled, you should not set this header.  The IDs must be a sub-set of the user&#39;s accessible orgs. If you specify an org that the user does not have access to, the operation fails.  If the header is not set, the operation is performed in scope of the user&#39;s accessible orgs.  | [optional] |
| **nextPendingItems** | **Integer**| Number of next pending payment schedule items displayed in the response body.  | [optional] |
| **lastProcessedItems** | **Integer**| Number of the most recent processed payment schedule items dispalyed in the response body.  | [optional] |
| **zuoraVersion** | **String**| The minor version of the Zuora REST API. See [Minor Version](https://developer.zuora.com/api-references/api/overview/#section/API-Versions/Minor-Version) for information about REST API version control.   This header affects the availability of the following response fields:   - &#x60;items&#x60; &gt; &#x60;paymentId&#x60;  | [optional] |

### Return type

[**GETPaymentScheduleResponse**](GETPaymentScheduleResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** |  |  * Content-Encoding - This header is returned if you specify the &#x60;Accept-Encoding: gzip&#x60; request header and the response contains over 1000 bytes of data. Note that only the following MIME types support gzipped responses:   - &#x60;application/json&#x60;   - &#x60;application/xml&#x60;   - &#x60;text/html&#x60;   - &#x60;text/csv&#x60;   - &#x60;text/plain&#x60;  <br>  * RateLimit-Limit - The request limit quota for the time window closest to exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Remaining - The number of requests remaining in the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Reset - The number of seconds until the quota resets for the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Zuora-Request-Id - The Zuora internal identifier of the API call. You cannot control the value of this header.  <br>  * Zuora-Track-Id - A custom identifier for tracing the API call. If you specified a tracing identifier in the request headers, Zuora returns the same tracing identifier. Otherwise, Zuora does not set this header.  <br>  |

<a name="paymentSchedule_1"></a>
# **paymentSchedule_1**
> GETPaymentScheduleResponse paymentSchedule_1(paymentScheduleKey, puTPaymentScheduleRequest).acceptEncoding(acceptEncoding).contentEncoding(contentEncoding).authorization(authorization).zuoraTrackId(zuoraTrackId).zuoraEntityIds(zuoraEntityIds).zuoraOrgIds(zuoraOrgIds).zuoraVersion(zuoraVersion).execute();

Update a payment schedule

Updates a payment schedule. For custom payment schedules, only the custom fields on the payment schedules can be udpated. Use the [Update a payment schedule item](https://developer.zuora.com/api-references/api/operation/PUT_PaymentScheduleItem/) operation to update payment schedule items of custom payment schedule.  Note the following rules for the &#x60;periodStartDate&#x60;, &#x60;period&#x60;, and &#x60;occurrences&#x60;:  - If &#x60;periodStartDate&#x60; is specified, all pending payment schedule items will be rescheduled using this new &#x60;periodStartDate&#x60;. If &#x60;period&#x60; is changed, we recommend passing in &#x60;periodStartDate&#x60;. Otherwise, the system would use the original start date if there is no processed or canceled items, or the last processed or canceled &#39;&#x60;scheduleDate&#x60; + 1 &#x60;period&#x60;&#39; as the new &#x60;periodStartDate&#x60;. - If only &#x60;occurrences&#x60; is updated, the new item will start with the last processed or canceled &#39;&#x60;scheduleDate&#x60; + 1 &#x60;period&#x60;&#39;.  **Note:** - The Payment Schedules feature is in the **Early Adopter** phase. We are actively soliciting feedback from a small set of early adopters before releasing it as generally available. To manage and access this feature through the self-service interface, see [Manage Features](https://knowledgecenter.zuora.com/Zuora_Payments/Payments_Settings/Manage_Features) in the Knowledge Center. - This operation is only available if you have [Invoice Settlement](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/Invoice_Settlement) enabled. 

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Zuora;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.PaymentSchedulesApi;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Example {
  public static void main(String[] args) {
    Configuration configuration = new Configuration();
    configuration.host = "https://rest.zuora.com";
    Zuora client = new Zuora(configuration);
    String paymentScheduleKey = "paymentScheduleKey_example"; // The unique ID or number of a payment schedule. For example, `8a90857b822459cd018224dcb9eb13be`, or `PS-00000007`. 
    Double amount = 3.4D; // Indicates the updated amount of the pending payment schedule items. 
    String currency = "currency_example"; // Indicates the updated currency of the pending payment schedule items.       
    Integer occurrences = 56; // Indicates the updated number of payment schedule items that are created by the payment schedule.  **Note:**   - If \\\"updated `occurrences` > existing `occurrences`\\\", the following number of pending payment schedule item will be added to the payment schedule: “updated `occurrences` - existing `occurrences`”.   - If \\\"existing `occurrences` > updated `occurrences` >= the number of `processed`/`errored`/`canceled` payment schedule items\\\", the following number of pending items will be removed by descending order of the schedule dates: \\\"existing `occurrences` - updated `occurrences`\\\".   - If \\\"updated `occurrences` < the number of `processed`/`erroed`/`canceled` payment schedule items\\\", a validation error will be returned. 
    String paymentGatewayId = "paymentGatewayId_example"; // Indicates the updated payment gateway ID of the pending payment schedule items. 
    String paymentMethodId = "paymentMethodId_example"; // Indicates the updated payment method ID of the pending payment schedule items.  
    List<PaymentSchedulePaymentOptionFields> paymentOption = Arrays.asList(); // Container for the paymentOption items, which describe the transactional level rules for processing payments. Currently, only the Gateway Options type is supported.  Here is an example: ``` \\\"paymentOption\\\": [   {     \\\"type\\\": \\\"GatewayOptions\\\",     \\\"detail\\\": {       \\\"SecCode\\\":\\\"WEB\\\"     }   } ] ```  `paymentOption` of the payment schedule takes precedence over `paymentOption` of the payment schedule item.   **Note:** To enable this field, submit a request at [Zuora Global Support](https://support.zuora.com/). 
    String period = "Monthly"; // Indicates the updated period of the pending payment schedule items. 
    LocalDate periodStartDate = LocalDate.now(); // Indicates the updated collection date for the next pending payment schedule item. 
    Integer runHour = 56; // Specifies at which hour of the day in the tenant’s time zone this payment will be collected. Available values: `[0,1,2,~,22,23]`.    If the time difference between your tenant’s timezone and the timezone where Zuora servers are is not in full hours, for example, 2.5 hours, the payment schedule items will be triggered half hour later than your scheduled time. If the payment `runHour` and `scheduledDate` are backdated, the system will collect the payment when the next runHour occurs. 
    String acceptEncoding = "acceptEncoding_example"; // Include the `Accept-Encoding: gzip` header to compress responses as a gzipped file. It can significantly reduce the bandwidth required for a response.   If specified, Zuora automatically compresses responses that contain over 1000 bytes of data, and the response contains a `Content-Encoding` header with the compression algorithm so that your client can decompress it. 
    String contentEncoding = "contentEncoding_example"; // Include the `Content-Encoding: gzip` header to compress a request. With this header specified, you should upload a gzipped file for the request payload instead of sending the JSON payload. 
    String authorization = "authorization_example"; // The value is in the `Bearer {token}` format where {token} is a valid OAuth token generated by calling [Create an OAuth token](https://developer.zuora.com/api-references/api/operation/createToken). 
    String zuoraTrackId = "zuoraTrackId_example"; // A custom identifier for tracing the API call. If you set a value for this header, Zuora returns the same value in the response headers. This header enables you to associate your system process identifiers with Zuora API calls, to assist with troubleshooting in the event of an issue.  The value of this field must use the US-ASCII character set and must not include any of the following characters: colon (`:`), semicolon (`;`), double quote (`\"`), and quote (`'`). 
    String zuoraEntityIds = "zuoraEntityIds_example"; // An entity ID. If you have [Zuora Multi-entity](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Multi-entity) enabled and the OAuth token is valid for more than one entity, you must use this header to specify which entity to perform the operation in. If the OAuth token is only valid for a single entity, or you do not have Zuora Multi-entity enabled, you do not need to set this header. 
    String zuoraOrgIds = "zuoraOrgIds_example"; // Comma separated IDs. If you have <a href=\"https://knowledgecenter.zuora.com/Zuora_Central_Platform/Multi-Org\" target=\"_blank\">Zuora Multi-Org</a> enabled,  you can use this header to specify which orgs to perform the operation in. If you do not have Zuora Multi-Org enabled, you should not set this header.  The IDs must be a sub-set of the user's accessible orgs. If you specify an org that the user does not have access to, the operation fails.  If the header is not set, the operation is performed in scope of the user's accessible orgs. 
    String zuoraVersion = "zuoraVersion_example"; // The minor version of the Zuora REST API. See [Minor Version](https://developer.zuora.com/api-references/api/overview/#section/API-Versions/Minor-Version) for information about REST API version control.   This header affects the availability of the following fields: - `items` > `paymentId` 
    try {
      GETPaymentScheduleResponse result = client
              .paymentSchedules
              .paymentSchedule_1(paymentScheduleKey)
              .amount(amount)
              .currency(currency)
              .occurrences(occurrences)
              .paymentGatewayId(paymentGatewayId)
              .paymentMethodId(paymentMethodId)
              .paymentOption(paymentOption)
              .period(period)
              .periodStartDate(periodStartDate)
              .runHour(runHour)
              .acceptEncoding(acceptEncoding)
              .contentEncoding(contentEncoding)
              .authorization(authorization)
              .zuoraTrackId(zuoraTrackId)
              .zuoraEntityIds(zuoraEntityIds)
              .zuoraOrgIds(zuoraOrgIds)
              .zuoraVersion(zuoraVersion)
              .execute();
      System.out.println(result);
      System.out.println(result.getDescription());
      System.out.println(result.getAccountId());
      System.out.println(result.getAccountNumber());
      System.out.println(result.getBillingDocument());
      System.out.println(result.getCreatedById());
      System.out.println(result.getCreatedDate());
      System.out.println(result.getId());
      System.out.println(result.getIsCustom());
      System.out.println(result.getItems());
      System.out.println(result.getNextPaymentDate());
      System.out.println(result.getOccurrences());
      System.out.println(result.getPaymentOption());
      System.out.println(result.getPaymentScheduleNumber());
      System.out.println(result.getPeriod());
      System.out.println(result.getPrepayment());
      System.out.println(result.getRecentPaymentDate());
      System.out.println(result.getRunHour());
      System.out.println(result.getStandalone());
      System.out.println(result.getStartDate());
      System.out.println(result.getStatus());
      System.out.println(result.getSuccess());
      System.out.println(result.getTotalAmount());
      System.out.println(result.getTotalPaymentsErrored());
      System.out.println(result.getTotalPaymentsProcessed());
      System.out.println(result.getUpdatedById());
      System.out.println(result.getUpdatedDate());
    } catch (ApiException e) {
      System.err.println("Exception when calling PaymentSchedulesApi#paymentSchedule_1");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<GETPaymentScheduleResponse> response = client
              .paymentSchedules
              .paymentSchedule_1(paymentScheduleKey)
              .amount(amount)
              .currency(currency)
              .occurrences(occurrences)
              .paymentGatewayId(paymentGatewayId)
              .paymentMethodId(paymentMethodId)
              .paymentOption(paymentOption)
              .period(period)
              .periodStartDate(periodStartDate)
              .runHour(runHour)
              .acceptEncoding(acceptEncoding)
              .contentEncoding(contentEncoding)
              .authorization(authorization)
              .zuoraTrackId(zuoraTrackId)
              .zuoraEntityIds(zuoraEntityIds)
              .zuoraOrgIds(zuoraOrgIds)
              .zuoraVersion(zuoraVersion)
              .executeWithHttpInfo();
      System.out.println(response.getResponseBody());
      System.out.println(response.getResponseHeaders());
      System.out.println(response.getStatusCode());
      System.out.println(response.getRoundTripTime());
      System.out.println(response.getRequest());
    } catch (ApiException e) {
      System.err.println("Exception when calling PaymentSchedulesApi#paymentSchedule_1");
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
| **paymentScheduleKey** | **String**| The unique ID or number of a payment schedule. For example, &#x60;8a90857b822459cd018224dcb9eb13be&#x60;, or &#x60;PS-00000007&#x60;.  | |
| **puTPaymentScheduleRequest** | [**PUTPaymentScheduleRequest**](PUTPaymentScheduleRequest.md)|  | |
| **acceptEncoding** | **String**| Include the &#x60;Accept-Encoding: gzip&#x60; header to compress responses as a gzipped file. It can significantly reduce the bandwidth required for a response.   If specified, Zuora automatically compresses responses that contain over 1000 bytes of data, and the response contains a &#x60;Content-Encoding&#x60; header with the compression algorithm so that your client can decompress it.  | [optional] |
| **contentEncoding** | **String**| Include the &#x60;Content-Encoding: gzip&#x60; header to compress a request. With this header specified, you should upload a gzipped file for the request payload instead of sending the JSON payload.  | [optional] |
| **authorization** | **String**| The value is in the &#x60;Bearer {token}&#x60; format where {token} is a valid OAuth token generated by calling [Create an OAuth token](https://developer.zuora.com/api-references/api/operation/createToken).  | [optional] |
| **zuoraTrackId** | **String**| A custom identifier for tracing the API call. If you set a value for this header, Zuora returns the same value in the response headers. This header enables you to associate your system process identifiers with Zuora API calls, to assist with troubleshooting in the event of an issue.  The value of this field must use the US-ASCII character set and must not include any of the following characters: colon (&#x60;:&#x60;), semicolon (&#x60;;&#x60;), double quote (&#x60;\&quot;&#x60;), and quote (&#x60;&#39;&#x60;).  | [optional] |
| **zuoraEntityIds** | **String**| An entity ID. If you have [Zuora Multi-entity](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Multi-entity) enabled and the OAuth token is valid for more than one entity, you must use this header to specify which entity to perform the operation in. If the OAuth token is only valid for a single entity, or you do not have Zuora Multi-entity enabled, you do not need to set this header.  | [optional] |
| **zuoraOrgIds** | **String**| Comma separated IDs. If you have &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Central_Platform/Multi-Org\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Zuora Multi-Org&lt;/a&gt; enabled,  you can use this header to specify which orgs to perform the operation in. If you do not have Zuora Multi-Org enabled, you should not set this header.  The IDs must be a sub-set of the user&#39;s accessible orgs. If you specify an org that the user does not have access to, the operation fails.  If the header is not set, the operation is performed in scope of the user&#39;s accessible orgs.  | [optional] |
| **zuoraVersion** | **String**| The minor version of the Zuora REST API. See [Minor Version](https://developer.zuora.com/api-references/api/overview/#section/API-Versions/Minor-Version) for information about REST API version control.   This header affects the availability of the following fields: - &#x60;items&#x60; &gt; &#x60;paymentId&#x60;  | [optional] |

### Return type

[**GETPaymentScheduleResponse**](GETPaymentScheduleResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** |  |  * Content-Encoding - This header is returned if you specify the &#x60;Accept-Encoding: gzip&#x60; request header and the response contains over 1000 bytes of data. Note that only the following MIME types support gzipped responses:   - &#x60;application/json&#x60;   - &#x60;application/xml&#x60;   - &#x60;text/html&#x60;   - &#x60;text/csv&#x60;   - &#x60;text/plain&#x60;  <br>  * RateLimit-Limit - The request limit quota for the time window closest to exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Remaining - The number of requests remaining in the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Reset - The number of seconds until the quota resets for the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Zuora-Request-Id - The Zuora internal identifier of the API call. You cannot control the value of this header.  <br>  * Zuora-Track-Id - A custom identifier for tracing the API call. If you specified a tracing identifier in the request headers, Zuora returns the same tracing identifier. Otherwise, Zuora does not set this header.  <br>  |

<a name="paymentSchedules"></a>
# **paymentSchedules**
> List&lt;PaymentScheduleCommonResponse&gt; paymentSchedules().acceptEncoding(acceptEncoding).contentEncoding(contentEncoding).authorization(authorization).zuoraTrackId(zuoraTrackId).zuoraEntityIds(zuoraEntityIds).zuoraOrgIds(zuoraOrgIds).lastProcessedItems(lastProcessedItems).nextPendingItems(nextPendingItems).accountId(accountId).accountNumber(accountNumber).zuoraVersion(zuoraVersion).execute();

List payment schedules by customer account

Retrieves payment schedules of a customer account.  **Note:** - The Payment Schedules feature is in the **Early Adopter** phase. We are actively soliciting feedback from a small set of early adopters before releasing it as generally available. To manage and access this feature through the self-service interface, see [Manage Features](https://knowledgecenter.zuora.com/Zuora_Payments/Payments_Settings/Manage_Features) in the Knowledge Center. - This operation is only available if you have [Invoice Settlement](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/Invoice_Settlement) enabled. 

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Zuora;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.PaymentSchedulesApi;
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
    Integer lastProcessedItems = 56; // Number of the most recent processed payment schedules dispalyed in the response body. 
    Integer nextPendingItems = 56; // Number of next pending payment schedule items displayed in the response body. 
    String accountId = "accountId_example"; // The ID of the customer account. If neither `accountId` nor `accountNumber` is specified, all payment schedules will be returned.  
    Integer accountNumber = 56; // The number of the customer account. If neither `accountId` nor `accountNumber` is specified, all payment schedules will be returned.  
    String zuoraVersion = "zuoraVersion_example"; // The minor version of the Zuora REST API. See [Minor Version](https://developer.zuora.com/api-references/api/overview/#section/API-Versions/Minor-Version) for information about REST API version control.   This header affects the availability of the following fields: * `items` > `paymentId`           
    try {
      List<PaymentScheduleCommonResponse> result = client
              .paymentSchedules
              .paymentSchedules()
              .acceptEncoding(acceptEncoding)
              .contentEncoding(contentEncoding)
              .authorization(authorization)
              .zuoraTrackId(zuoraTrackId)
              .zuoraEntityIds(zuoraEntityIds)
              .zuoraOrgIds(zuoraOrgIds)
              .lastProcessedItems(lastProcessedItems)
              .nextPendingItems(nextPendingItems)
              .accountId(accountId)
              .accountNumber(accountNumber)
              .zuoraVersion(zuoraVersion)
              .execute();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling PaymentSchedulesApi#paymentSchedules");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<List<PaymentScheduleCommonResponse>> response = client
              .paymentSchedules
              .paymentSchedules()
              .acceptEncoding(acceptEncoding)
              .contentEncoding(contentEncoding)
              .authorization(authorization)
              .zuoraTrackId(zuoraTrackId)
              .zuoraEntityIds(zuoraEntityIds)
              .zuoraOrgIds(zuoraOrgIds)
              .lastProcessedItems(lastProcessedItems)
              .nextPendingItems(nextPendingItems)
              .accountId(accountId)
              .accountNumber(accountNumber)
              .zuoraVersion(zuoraVersion)
              .executeWithHttpInfo();
      System.out.println(response.getResponseBody());
      System.out.println(response.getResponseHeaders());
      System.out.println(response.getStatusCode());
      System.out.println(response.getRoundTripTime());
      System.out.println(response.getRequest());
    } catch (ApiException e) {
      System.err.println("Exception when calling PaymentSchedulesApi#paymentSchedules");
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
| **lastProcessedItems** | **Integer**| Number of the most recent processed payment schedules dispalyed in the response body.  | [optional] |
| **nextPendingItems** | **Integer**| Number of next pending payment schedule items displayed in the response body.  | [optional] |
| **accountId** | **String**| The ID of the customer account. If neither &#x60;accountId&#x60; nor &#x60;accountNumber&#x60; is specified, all payment schedules will be returned.   | [optional] |
| **accountNumber** | **Integer**| The number of the customer account. If neither &#x60;accountId&#x60; nor &#x60;accountNumber&#x60; is specified, all payment schedules will be returned.   | [optional] |
| **zuoraVersion** | **String**| The minor version of the Zuora REST API. See [Minor Version](https://developer.zuora.com/api-references/api/overview/#section/API-Versions/Minor-Version) for information about REST API version control.   This header affects the availability of the following fields: * &#x60;items&#x60; &gt; &#x60;paymentId&#x60;            | [optional] |

### Return type

[**List&lt;PaymentScheduleCommonResponse&gt;**](PaymentScheduleCommonResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** |  |  * Content-Encoding - This header is returned if you specify the &#x60;Accept-Encoding: gzip&#x60; request header and the response contains over 1000 bytes of data. Note that only the following MIME types support gzipped responses:   - &#x60;application/json&#x60;   - &#x60;application/xml&#x60;   - &#x60;text/html&#x60;   - &#x60;text/csv&#x60;   - &#x60;text/plain&#x60;  <br>  * RateLimit-Limit - The request limit quota for the time window closest to exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Remaining - The number of requests remaining in the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Reset - The number of seconds until the quota resets for the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Zuora-Request-Id - The Zuora internal identifier of the API call. You cannot control the value of this header.  <br>  * Zuora-Track-Id - A custom identifier for tracing the API call. If you specified a tracing identifier in the request headers, Zuora returns the same tracing identifier. Otherwise, Zuora does not set this header.  <br>  |

<a name="paymentSchedules_0"></a>
# **paymentSchedules_0**
> POSTPaymentSchedulesResponse paymentSchedules_0(poSTPaymentSchedulesRequest).idempotencyKey(idempotencyKey).acceptEncoding(acceptEncoding).contentEncoding(contentEncoding).authorization(authorization).zuoraTrackId(zuoraTrackId).zuoraEntityIds(zuoraEntityIds).zuoraOrgIds(zuoraOrgIds).zuoraVersion(zuoraVersion).execute();

Create multiple payment schedules at once

Creates multiple payment schedules at once. You can create both recurring payment schedules and custom payment schedules in one request. The maximum number of payment schedules that can be created by a single request is 50. The maximum number of payment schedule items that each payment schedule can contain is 1000, i.e., you must specify less than 1000 items for a custom payment schedule, and the &#x60;occurrences&#x60; field must be less than 1000 for a recurring payment schedule.  **Note:** - The Payment Schedules feature is in the **Early Adopter** phase. We are actively soliciting feedback from a small set of early adopters before releasing it as generally available. To manage and access this feature through the self-service interface, see [Manage Features](https://knowledgecenter.zuora.com/Zuora_Payments/Payments_Settings/Manage_Features) in the Knowledge Center. - This operation is only available if you have [Invoice Settlement](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/Invoice_Settlement) enabled. - If Standalone Payment is enabled, you can choose to use payment schedules to process payments associated with billing documents, standalone payments, or unapplied payments. If Standalone Payment is not enabled, you can only use payment schedules to process unapplied payments or payments associated with billing documents. - This operation is version controlled. If you set &#x60;zuora-version&#x60; to &#x60;329.0&#x60;, when creating custom payment schedules associated with billing documents, you need to specify the billing document for each payment schedule item; If &#x60;zuora-version&#x60; is set to &#x60;330.0&#x60;, when creating custom payment schedules associated with billing documents, you only need to specify the billing documents at the payment schedule level. The default version number is &#x60;329.0&#x60;. However, we recommend that you specify the version to &#x60;330.0&#x60;. &#x60;329.0&#x60; will be deprecated soon. 

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Zuora;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.PaymentSchedulesApi;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Example {
  public static void main(String[] args) {
    Configuration configuration = new Configuration();
    configuration.host = "https://rest.zuora.com";
    Zuora client = new Zuora(configuration);
    List<POSTPaymentScheduleRequest> paymentSchedules = Arrays.asList(); // Container of the payment schedules to be created. 
    String idempotencyKey = "idempotencyKey_example"; // Specify a unique idempotency key if you want to perform an idempotent POST or PATCH request. Do not use this header in other request types.   With this header specified, the Zuora server can identify subsequent retries of the same request using this value, which prevents the same operation from being performed multiple times by accident.  
    String acceptEncoding = "acceptEncoding_example"; // Include the `Accept-Encoding: gzip` header to compress responses as a gzipped file. It can significantly reduce the bandwidth required for a response.   If specified, Zuora automatically compresses responses that contain over 1000 bytes of data, and the response contains a `Content-Encoding` header with the compression algorithm so that your client can decompress it. 
    String contentEncoding = "contentEncoding_example"; // Include the `Content-Encoding: gzip` header to compress a request. With this header specified, you should upload a gzipped file for the request payload instead of sending the JSON payload. 
    String authorization = "authorization_example"; // The value is in the `Bearer {token}` format where {token} is a valid OAuth token generated by calling [Create an OAuth token](https://developer.zuora.com/api-references/api/operation/createToken). 
    String zuoraTrackId = "zuoraTrackId_example"; // A custom identifier for tracing the API call. If you set a value for this header, Zuora returns the same value in the response headers. This header enables you to associate your system process identifiers with Zuora API calls, to assist with troubleshooting in the event of an issue.  The value of this field must use the US-ASCII character set and must not include any of the following characters: colon (`:`), semicolon (`;`), double quote (`\"`), and quote (`'`). 
    String zuoraEntityIds = "zuoraEntityIds_example"; // An entity ID. If you have [Zuora Multi-entity](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Multi-entity) enabled and the OAuth token is valid for more than one entity, you must use this header to specify which entity to perform the operation in. If the OAuth token is only valid for a single entity, or you do not have Zuora Multi-entity enabled, you do not need to set this header. 
    String zuoraOrgIds = "zuoraOrgIds_example"; // Comma separated IDs. If you have <a href=\"https://knowledgecenter.zuora.com/Zuora_Central_Platform/Multi-Org\" target=\"_blank\">Zuora Multi-Org</a> enabled,  you can use this header to specify which orgs to perform the operation in. If you do not have Zuora Multi-Org enabled, you should not set this header.  The IDs must be a sub-set of the user's accessible orgs. If you specify an org that the user does not have access to, the operation fails.  If the header is not set, the operation is performed in scope of the user's accessible orgs. 
    String zuoraVersion = "zuoraVersion_example"; // The minor version of the Zuora REST API. See [Minor Version](https://developer.zuora.com/api-references/api/overview/#section/API-Versions/Minor-Version) for information about REST API version control.   This header affects the availability of the following request fields: * `paymentSchedules` > `billingDocument` * `paymentSchedules` > `items` > `billingDocument` 
    try {
      POSTPaymentSchedulesResponse result = client
              .paymentSchedules
              .paymentSchedules_0()
              .paymentSchedules(paymentSchedules)
              .idempotencyKey(idempotencyKey)
              .acceptEncoding(acceptEncoding)
              .contentEncoding(contentEncoding)
              .authorization(authorization)
              .zuoraTrackId(zuoraTrackId)
              .zuoraEntityIds(zuoraEntityIds)
              .zuoraOrgIds(zuoraOrgIds)
              .zuoraVersion(zuoraVersion)
              .execute();
      System.out.println(result);
      System.out.println(result.getPaymentSchedules());
      System.out.println(result.getSuccess());
    } catch (ApiException e) {
      System.err.println("Exception when calling PaymentSchedulesApi#paymentSchedules_0");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<POSTPaymentSchedulesResponse> response = client
              .paymentSchedules
              .paymentSchedules_0()
              .paymentSchedules(paymentSchedules)
              .idempotencyKey(idempotencyKey)
              .acceptEncoding(acceptEncoding)
              .contentEncoding(contentEncoding)
              .authorization(authorization)
              .zuoraTrackId(zuoraTrackId)
              .zuoraEntityIds(zuoraEntityIds)
              .zuoraOrgIds(zuoraOrgIds)
              .zuoraVersion(zuoraVersion)
              .executeWithHttpInfo();
      System.out.println(response.getResponseBody());
      System.out.println(response.getResponseHeaders());
      System.out.println(response.getStatusCode());
      System.out.println(response.getRoundTripTime());
      System.out.println(response.getRequest());
    } catch (ApiException e) {
      System.err.println("Exception when calling PaymentSchedulesApi#paymentSchedules_0");
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
| **poSTPaymentSchedulesRequest** | [**POSTPaymentSchedulesRequest**](POSTPaymentSchedulesRequest.md)|  | |
| **idempotencyKey** | **String**| Specify a unique idempotency key if you want to perform an idempotent POST or PATCH request. Do not use this header in other request types.   With this header specified, the Zuora server can identify subsequent retries of the same request using this value, which prevents the same operation from being performed multiple times by accident.   | [optional] |
| **acceptEncoding** | **String**| Include the &#x60;Accept-Encoding: gzip&#x60; header to compress responses as a gzipped file. It can significantly reduce the bandwidth required for a response.   If specified, Zuora automatically compresses responses that contain over 1000 bytes of data, and the response contains a &#x60;Content-Encoding&#x60; header with the compression algorithm so that your client can decompress it.  | [optional] |
| **contentEncoding** | **String**| Include the &#x60;Content-Encoding: gzip&#x60; header to compress a request. With this header specified, you should upload a gzipped file for the request payload instead of sending the JSON payload.  | [optional] |
| **authorization** | **String**| The value is in the &#x60;Bearer {token}&#x60; format where {token} is a valid OAuth token generated by calling [Create an OAuth token](https://developer.zuora.com/api-references/api/operation/createToken).  | [optional] |
| **zuoraTrackId** | **String**| A custom identifier for tracing the API call. If you set a value for this header, Zuora returns the same value in the response headers. This header enables you to associate your system process identifiers with Zuora API calls, to assist with troubleshooting in the event of an issue.  The value of this field must use the US-ASCII character set and must not include any of the following characters: colon (&#x60;:&#x60;), semicolon (&#x60;;&#x60;), double quote (&#x60;\&quot;&#x60;), and quote (&#x60;&#39;&#x60;).  | [optional] |
| **zuoraEntityIds** | **String**| An entity ID. If you have [Zuora Multi-entity](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Multi-entity) enabled and the OAuth token is valid for more than one entity, you must use this header to specify which entity to perform the operation in. If the OAuth token is only valid for a single entity, or you do not have Zuora Multi-entity enabled, you do not need to set this header.  | [optional] |
| **zuoraOrgIds** | **String**| Comma separated IDs. If you have &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Central_Platform/Multi-Org\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Zuora Multi-Org&lt;/a&gt; enabled,  you can use this header to specify which orgs to perform the operation in. If you do not have Zuora Multi-Org enabled, you should not set this header.  The IDs must be a sub-set of the user&#39;s accessible orgs. If you specify an org that the user does not have access to, the operation fails.  If the header is not set, the operation is performed in scope of the user&#39;s accessible orgs.  | [optional] |
| **zuoraVersion** | **String**| The minor version of the Zuora REST API. See [Minor Version](https://developer.zuora.com/api-references/api/overview/#section/API-Versions/Minor-Version) for information about REST API version control.   This header affects the availability of the following request fields: * &#x60;paymentSchedules&#x60; &gt; &#x60;billingDocument&#x60; * &#x60;paymentSchedules&#x60; &gt; &#x60;items&#x60; &gt; &#x60;billingDocument&#x60;  | [optional] |

### Return type

[**POSTPaymentSchedulesResponse**](POSTPaymentSchedulesResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** |  |  * Content-Encoding - This header is returned if you specify the &#x60;Accept-Encoding: gzip&#x60; request header and the response contains over 1000 bytes of data. Note that only the following MIME types support gzipped responses:   - &#x60;application/json&#x60;   - &#x60;application/xml&#x60;   - &#x60;text/html&#x60;   - &#x60;text/csv&#x60;   - &#x60;text/plain&#x60;  <br>  * RateLimit-Limit - The request limit quota for the time window closest to exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Remaining - The number of requests remaining in the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Reset - The number of seconds until the quota resets for the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Zuora-Request-Id - The Zuora internal identifier of the API call. You cannot control the value of this header.  <br>  * Zuora-Track-Id - A custom identifier for tracing the API call. If you specified a tracing identifier in the request headers, Zuora returns the same tracing identifier. Otherwise, Zuora does not set this header.  <br>  |

<a name="retryPaymentScheduleItem"></a>
# **retryPaymentScheduleItem**
> POSTRetryPaymentScheduleItemResponse retryPaymentScheduleItem(poSTRetryPaymentScheduleItemRequest).idempotencyKey(idempotencyKey).acceptEncoding(acceptEncoding).contentEncoding(contentEncoding).authorization(authorization).zuoraTrackId(zuoraTrackId).zuoraEntityIds(zuoraEntityIds).zuoraOrgIds(zuoraOrgIds).zuoraVersion(zuoraVersion).execute();

Retry failed payment schedule items

Retries failed payment schedule items. The payment method and payment gateway of the failed payment can be updated to new values before the retry.  Note that you can retry a payment schedule item only when the payment schedule item is either in the &#x60;Error&#x60; or &#x60;Pending&#x60; status.  **Note:** - The Payment Schedules feature is in the **Early Adopter** phase. We are actively soliciting feedback from a small set of early adopters before releasing it as generally available. To manage and access this feature through the self-service interface, see [Manage Features](https://knowledgecenter.zuora.com/Zuora_Payments/Payments_Settings/Manage_Features) in the Knowledge Center. - This operation is only available if you have [Invoice Settlement](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/Invoice_Settlement) enabled. 

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Zuora;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.PaymentSchedulesApi;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Example {
  public static void main(String[] args) {
    Configuration configuration = new Configuration();
    configuration.host = "https://rest.zuora.com";
    Zuora client = new Zuora(configuration);
    List<POSTRetryPaymentScheduleItemInfo> items = Arrays.asList(); // The maximum number of items allowable to pass is 10. 
    String idempotencyKey = "idempotencyKey_example"; // Specify a unique idempotency key if you want to perform an idempotent POST or PATCH request. Do not use this header in other request types.   With this header specified, the Zuora server can identify subsequent retries of the same request using this value, which prevents the same operation from being performed multiple times by accident.  
    String acceptEncoding = "acceptEncoding_example"; // Include the `Accept-Encoding: gzip` header to compress responses as a gzipped file. It can significantly reduce the bandwidth required for a response.   If specified, Zuora automatically compresses responses that contain over 1000 bytes of data, and the response contains a `Content-Encoding` header with the compression algorithm so that your client can decompress it. 
    String contentEncoding = "contentEncoding_example"; // Include the `Content-Encoding: gzip` header to compress a request. With this header specified, you should upload a gzipped file for the request payload instead of sending the JSON payload. 
    String authorization = "authorization_example"; // The value is in the `Bearer {token}` format where {token} is a valid OAuth token generated by calling [Create an OAuth token](https://developer.zuora.com/api-references/api/operation/createToken). 
    String zuoraTrackId = "zuoraTrackId_example"; // A custom identifier for tracing the API call. If you set a value for this header, Zuora returns the same value in the response headers. This header enables you to associate your system process identifiers with Zuora API calls, to assist with troubleshooting in the event of an issue.  The value of this field must use the US-ASCII character set and must not include any of the following characters: colon (`:`), semicolon (`;`), double quote (`\"`), and quote (`'`). 
    String zuoraEntityIds = "zuoraEntityIds_example"; // An entity ID. If you have [Zuora Multi-entity](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Multi-entity) enabled and the OAuth token is valid for more than one entity, you must use this header to specify which entity to perform the operation in. If the OAuth token is only valid for a single entity, or you do not have Zuora Multi-entity enabled, you do not need to set this header. 
    String zuoraOrgIds = "zuoraOrgIds_example"; // Comma separated IDs. If you have <a href=\"https://knowledgecenter.zuora.com/Zuora_Central_Platform/Multi-Org\" target=\"_blank\">Zuora Multi-Org</a> enabled,  you can use this header to specify which orgs to perform the operation in. If you do not have Zuora Multi-Org enabled, you should not set this header.  The IDs must be a sub-set of the user's accessible orgs. If you specify an org that the user does not have access to, the operation fails.  If the header is not set, the operation is performed in scope of the user's accessible orgs. 
    String zuoraVersion = "zuoraVersion_example"; // The minor version of the Zuora REST API. See [Minor Version](https://developer.zuora.com/api-references/api/overview/#section/API-Versions/Minor-Version) for information about REST API version control.   This header affects the availability of the following response fields: - `items` > `paymentId` 
    try {
      POSTRetryPaymentScheduleItemResponse result = client
              .paymentSchedules
              .retryPaymentScheduleItem()
              .items(items)
              .idempotencyKey(idempotencyKey)
              .acceptEncoding(acceptEncoding)
              .contentEncoding(contentEncoding)
              .authorization(authorization)
              .zuoraTrackId(zuoraTrackId)
              .zuoraEntityIds(zuoraEntityIds)
              .zuoraOrgIds(zuoraOrgIds)
              .zuoraVersion(zuoraVersion)
              .execute();
      System.out.println(result);
      System.out.println(result.getItems());
      System.out.println(result.getSuccess());
    } catch (ApiException e) {
      System.err.println("Exception when calling PaymentSchedulesApi#retryPaymentScheduleItem");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<POSTRetryPaymentScheduleItemResponse> response = client
              .paymentSchedules
              .retryPaymentScheduleItem()
              .items(items)
              .idempotencyKey(idempotencyKey)
              .acceptEncoding(acceptEncoding)
              .contentEncoding(contentEncoding)
              .authorization(authorization)
              .zuoraTrackId(zuoraTrackId)
              .zuoraEntityIds(zuoraEntityIds)
              .zuoraOrgIds(zuoraOrgIds)
              .zuoraVersion(zuoraVersion)
              .executeWithHttpInfo();
      System.out.println(response.getResponseBody());
      System.out.println(response.getResponseHeaders());
      System.out.println(response.getStatusCode());
      System.out.println(response.getRoundTripTime());
      System.out.println(response.getRequest());
    } catch (ApiException e) {
      System.err.println("Exception when calling PaymentSchedulesApi#retryPaymentScheduleItem");
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
| **poSTRetryPaymentScheduleItemRequest** | [**POSTRetryPaymentScheduleItemRequest**](POSTRetryPaymentScheduleItemRequest.md)|  | |
| **idempotencyKey** | **String**| Specify a unique idempotency key if you want to perform an idempotent POST or PATCH request. Do not use this header in other request types.   With this header specified, the Zuora server can identify subsequent retries of the same request using this value, which prevents the same operation from being performed multiple times by accident.   | [optional] |
| **acceptEncoding** | **String**| Include the &#x60;Accept-Encoding: gzip&#x60; header to compress responses as a gzipped file. It can significantly reduce the bandwidth required for a response.   If specified, Zuora automatically compresses responses that contain over 1000 bytes of data, and the response contains a &#x60;Content-Encoding&#x60; header with the compression algorithm so that your client can decompress it.  | [optional] |
| **contentEncoding** | **String**| Include the &#x60;Content-Encoding: gzip&#x60; header to compress a request. With this header specified, you should upload a gzipped file for the request payload instead of sending the JSON payload.  | [optional] |
| **authorization** | **String**| The value is in the &#x60;Bearer {token}&#x60; format where {token} is a valid OAuth token generated by calling [Create an OAuth token](https://developer.zuora.com/api-references/api/operation/createToken).  | [optional] |
| **zuoraTrackId** | **String**| A custom identifier for tracing the API call. If you set a value for this header, Zuora returns the same value in the response headers. This header enables you to associate your system process identifiers with Zuora API calls, to assist with troubleshooting in the event of an issue.  The value of this field must use the US-ASCII character set and must not include any of the following characters: colon (&#x60;:&#x60;), semicolon (&#x60;;&#x60;), double quote (&#x60;\&quot;&#x60;), and quote (&#x60;&#39;&#x60;).  | [optional] |
| **zuoraEntityIds** | **String**| An entity ID. If you have [Zuora Multi-entity](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Multi-entity) enabled and the OAuth token is valid for more than one entity, you must use this header to specify which entity to perform the operation in. If the OAuth token is only valid for a single entity, or you do not have Zuora Multi-entity enabled, you do not need to set this header.  | [optional] |
| **zuoraOrgIds** | **String**| Comma separated IDs. If you have &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Central_Platform/Multi-Org\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Zuora Multi-Org&lt;/a&gt; enabled,  you can use this header to specify which orgs to perform the operation in. If you do not have Zuora Multi-Org enabled, you should not set this header.  The IDs must be a sub-set of the user&#39;s accessible orgs. If you specify an org that the user does not have access to, the operation fails.  If the header is not set, the operation is performed in scope of the user&#39;s accessible orgs.  | [optional] |
| **zuoraVersion** | **String**| The minor version of the Zuora REST API. See [Minor Version](https://developer.zuora.com/api-references/api/overview/#section/API-Versions/Minor-Version) for information about REST API version control.   This header affects the availability of the following response fields: - &#x60;items&#x60; &gt; &#x60;paymentId&#x60;  | [optional] |

### Return type

[**POSTRetryPaymentScheduleItemResponse**](POSTRetryPaymentScheduleItemResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** |  |  * Content-Encoding - This header is returned if you specify the &#x60;Accept-Encoding: gzip&#x60; request header and the response contains over 1000 bytes of data. Note that only the following MIME types support gzipped responses:   - &#x60;application/json&#x60;   - &#x60;application/xml&#x60;   - &#x60;text/html&#x60;   - &#x60;text/csv&#x60;   - &#x60;text/plain&#x60;  <br>  * RateLimit-Limit - The request limit quota for the time window closest to exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Remaining - The number of requests remaining in the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Reset - The number of seconds until the quota resets for the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Zuora-Request-Id - The Zuora internal identifier of the API call. You cannot control the value of this header.  <br>  * Zuora-Track-Id - A custom identifier for tracing the API call. If you specified a tracing identifier in the request headers, Zuora returns the same tracing identifier. Otherwise, Zuora does not set this header.  <br>  |

<a name="skipPaymentScheduleItem"></a>
# **skipPaymentScheduleItem**
> PUTSkipPaymentScheduleItemResponse skipPaymentScheduleItem(itemId).acceptEncoding(acceptEncoding).contentEncoding(contentEncoding).authorization(authorization).zuoraTrackId(zuoraTrackId).zuoraEntityIds(zuoraEntityIds).zuoraOrgIds(zuoraOrgIds).zuoraVersion(zuoraVersion).execute();

Skip a payment schedule item

Skips a payment schedule item by ID. The skipped payment schedule item will turn to the &#x60;canceled&#x60; status, and a new item will be scheduled on the next recurring date after the last existing scheduled date.  **Note:** - Only payment schedule items in recurring payment schedules can be skipped, and the item must be in the &#x60;pending&#x60; status. - The Payment Schedules feature is in the **Early Adopter** phase. We are actively soliciting feedback from a small set of early adopters before releasing it as generally available. To manage and access this feature through the self-service interface, see [Manage Features](https://knowledgecenter.zuora.com/Zuora_Payments/Payments_Settings/Manage_Features) in the Knowledge Center. - This operation is only available if you have [Invoice Settlement](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/Invoice_Settlement) enabled. 

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Zuora;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.PaymentSchedulesApi;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Example {
  public static void main(String[] args) {
    Configuration configuration = new Configuration();
    configuration.host = "https://rest.zuora.com";
    Zuora client = new Zuora(configuration);
    String itemId = "itemId_example"; // The unique ID of a payment schedule item.    
    String acceptEncoding = "acceptEncoding_example"; // Include the `Accept-Encoding: gzip` header to compress responses as a gzipped file. It can significantly reduce the bandwidth required for a response.   If specified, Zuora automatically compresses responses that contain over 1000 bytes of data, and the response contains a `Content-Encoding` header with the compression algorithm so that your client can decompress it. 
    String contentEncoding = "contentEncoding_example"; // Include the `Content-Encoding: gzip` header to compress a request. With this header specified, you should upload a gzipped file for the request payload instead of sending the JSON payload. 
    String authorization = "authorization_example"; // The value is in the `Bearer {token}` format where {token} is a valid OAuth token generated by calling [Create an OAuth token](https://developer.zuora.com/api-references/api/operation/createToken). 
    String zuoraTrackId = "zuoraTrackId_example"; // A custom identifier for tracing the API call. If you set a value for this header, Zuora returns the same value in the response headers. This header enables you to associate your system process identifiers with Zuora API calls, to assist with troubleshooting in the event of an issue.  The value of this field must use the US-ASCII character set and must not include any of the following characters: colon (`:`), semicolon (`;`), double quote (`\"`), and quote (`'`). 
    String zuoraEntityIds = "zuoraEntityIds_example"; // An entity ID. If you have [Zuora Multi-entity](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Multi-entity) enabled and the OAuth token is valid for more than one entity, you must use this header to specify which entity to perform the operation in. If the OAuth token is only valid for a single entity, or you do not have Zuora Multi-entity enabled, you do not need to set this header. 
    String zuoraOrgIds = "zuoraOrgIds_example"; // Comma separated IDs. If you have <a href=\"https://knowledgecenter.zuora.com/Zuora_Central_Platform/Multi-Org\" target=\"_blank\">Zuora Multi-Org</a> enabled,  you can use this header to specify which orgs to perform the operation in. If you do not have Zuora Multi-Org enabled, you should not set this header.  The IDs must be a sub-set of the user's accessible orgs. If you specify an org that the user does not have access to, the operation fails.  If the header is not set, the operation is performed in scope of the user's accessible orgs. 
    String zuoraVersion = "zuoraVersion_example"; // The minor version of the Zuora REST API. See [Minor Version](https://developer.zuora.com/api-references/api/overview/#section/API-Versions/Minor-Version) for information about REST API version control.   This header affects the availability of the following response fields: - `paymentId` 
    try {
      PUTSkipPaymentScheduleItemResponse result = client
              .paymentSchedules
              .skipPaymentScheduleItem(itemId)
              .acceptEncoding(acceptEncoding)
              .contentEncoding(contentEncoding)
              .authorization(authorization)
              .zuoraTrackId(zuoraTrackId)
              .zuoraEntityIds(zuoraEntityIds)
              .zuoraOrgIds(zuoraOrgIds)
              .zuoraVersion(zuoraVersion)
              .execute();
      System.out.println(result);
      System.out.println(result.getDescription());
      System.out.println(result.getAmount());
      System.out.println(result.getBillingDocument());
      System.out.println(result.getCancellationReason());
      System.out.println(result.getCreatedById());
      System.out.println(result.getCreatedDate());
      System.out.println(result.getCurrency());
      System.out.println(result.getErrorMessage());
      System.out.println(result.getId());
      System.out.println(result.getNumber());
      System.out.println(result.getPaymentGatewayId());
      System.out.println(result.getPaymentId());
      System.out.println(result.getPaymentMethodId());
      System.out.println(result.getPaymentOption());
      System.out.println(result.getPaymentScheduleId());
      System.out.println(result.getPaymentScheduleNumber());
      System.out.println(result.getPsiPayments());
      System.out.println(result.getRunHour());
      System.out.println(result.getScheduledDate());
      System.out.println(result.getStandalone());
      System.out.println(result.getStatus());
      System.out.println(result.getSuccess());
      System.out.println(result.getUpdatedById());
      System.out.println(result.getUpdatedDate());
    } catch (ApiException e) {
      System.err.println("Exception when calling PaymentSchedulesApi#skipPaymentScheduleItem");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<PUTSkipPaymentScheduleItemResponse> response = client
              .paymentSchedules
              .skipPaymentScheduleItem(itemId)
              .acceptEncoding(acceptEncoding)
              .contentEncoding(contentEncoding)
              .authorization(authorization)
              .zuoraTrackId(zuoraTrackId)
              .zuoraEntityIds(zuoraEntityIds)
              .zuoraOrgIds(zuoraOrgIds)
              .zuoraVersion(zuoraVersion)
              .executeWithHttpInfo();
      System.out.println(response.getResponseBody());
      System.out.println(response.getResponseHeaders());
      System.out.println(response.getStatusCode());
      System.out.println(response.getRoundTripTime());
      System.out.println(response.getRequest());
    } catch (ApiException e) {
      System.err.println("Exception when calling PaymentSchedulesApi#skipPaymentScheduleItem");
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
| **itemId** | **String**| The unique ID of a payment schedule item.     | |
| **acceptEncoding** | **String**| Include the &#x60;Accept-Encoding: gzip&#x60; header to compress responses as a gzipped file. It can significantly reduce the bandwidth required for a response.   If specified, Zuora automatically compresses responses that contain over 1000 bytes of data, and the response contains a &#x60;Content-Encoding&#x60; header with the compression algorithm so that your client can decompress it.  | [optional] |
| **contentEncoding** | **String**| Include the &#x60;Content-Encoding: gzip&#x60; header to compress a request. With this header specified, you should upload a gzipped file for the request payload instead of sending the JSON payload.  | [optional] |
| **authorization** | **String**| The value is in the &#x60;Bearer {token}&#x60; format where {token} is a valid OAuth token generated by calling [Create an OAuth token](https://developer.zuora.com/api-references/api/operation/createToken).  | [optional] |
| **zuoraTrackId** | **String**| A custom identifier for tracing the API call. If you set a value for this header, Zuora returns the same value in the response headers. This header enables you to associate your system process identifiers with Zuora API calls, to assist with troubleshooting in the event of an issue.  The value of this field must use the US-ASCII character set and must not include any of the following characters: colon (&#x60;:&#x60;), semicolon (&#x60;;&#x60;), double quote (&#x60;\&quot;&#x60;), and quote (&#x60;&#39;&#x60;).  | [optional] |
| **zuoraEntityIds** | **String**| An entity ID. If you have [Zuora Multi-entity](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Multi-entity) enabled and the OAuth token is valid for more than one entity, you must use this header to specify which entity to perform the operation in. If the OAuth token is only valid for a single entity, or you do not have Zuora Multi-entity enabled, you do not need to set this header.  | [optional] |
| **zuoraOrgIds** | **String**| Comma separated IDs. If you have &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Central_Platform/Multi-Org\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Zuora Multi-Org&lt;/a&gt; enabled,  you can use this header to specify which orgs to perform the operation in. If you do not have Zuora Multi-Org enabled, you should not set this header.  The IDs must be a sub-set of the user&#39;s accessible orgs. If you specify an org that the user does not have access to, the operation fails.  If the header is not set, the operation is performed in scope of the user&#39;s accessible orgs.  | [optional] |
| **zuoraVersion** | **String**| The minor version of the Zuora REST API. See [Minor Version](https://developer.zuora.com/api-references/api/overview/#section/API-Versions/Minor-Version) for information about REST API version control.   This header affects the availability of the following response fields: - &#x60;paymentId&#x60;  | [optional] |

### Return type

[**PUTSkipPaymentScheduleItemResponse**](PUTSkipPaymentScheduleItemResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** |  |  * Content-Encoding - This header is returned if you specify the &#x60;Accept-Encoding: gzip&#x60; request header and the response contains over 1000 bytes of data. Note that only the following MIME types support gzipped responses:   - &#x60;application/json&#x60;   - &#x60;application/xml&#x60;   - &#x60;text/html&#x60;   - &#x60;text/csv&#x60;   - &#x60;text/plain&#x60;  <br>  * RateLimit-Limit - The request limit quota for the time window closest to exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Remaining - The number of requests remaining in the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Reset - The number of seconds until the quota resets for the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Zuora-Request-Id - The Zuora internal identifier of the API call. You cannot control the value of this header.  <br>  * Zuora-Track-Id - A custom identifier for tracing the API call. If you specified a tracing identifier in the request headers, Zuora returns the same tracing identifier. Otherwise, Zuora does not set this header.  <br>  |

