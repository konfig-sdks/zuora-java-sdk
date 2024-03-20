# BillingPreviewRunApi

All URIs are relative to *https://rest.zuora.com*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**billingPreviewRun**](BillingPreviewRunApi.md#billingPreviewRun) | **POST** /v1/billing-preview-runs | Create a billing preview run |
| [**billingPreviewRun_0**](BillingPreviewRunApi.md#billingPreviewRun_0) | **GET** /v1/billing-preview-runs/{billingPreviewRunId} | Retrieve a billing preview run |


<a name="billingPreviewRun"></a>
# **billingPreviewRun**
> PostBillingPreviewRunResponse billingPreviewRun(postBillingPreviewRunParam).idempotencyKey(idempotencyKey).acceptEncoding(acceptEncoding).contentEncoding(contentEncoding).authorization(authorization).zuoraTrackId(zuoraTrackId).zuoraEntityIds(zuoraEntityIds).zuoraOrgIds(zuoraOrgIds).zuoraVersion(zuoraVersion).execute();

Create a billing preview run

Creates a billing preview run for multiple customer accounts.  The maximum supported preview duration is 20 years, calculated from the current date to the target date.  You can run up to 20 billing preview runs in batches concurrently. A single batch of customer accounts can only have one billing preview run at a time. So you can have up to 20 batches running at the same time. If you create a billing preview run for all customer batches, you cannot create another billing preview run until this preview run is completed.  Note that the preview results for each billing preview run will be stored in the system for 180 days; after that they will be purged. 

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Zuora;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.BillingPreviewRunApi;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Example {
  public static void main(String[] args) {
    Configuration configuration = new Configuration();
    configuration.host = "https://rest.zuora.com";
    Zuora client = new Zuora(configuration);
    LocalDate targetDate = LocalDate.now(); // The target date for the billing preview run. The billing preview run generates preview invoice item data and credit memo item data from the first day of the customer's next billing period to the target date.   The value for the `targetDate` field must be in _`YYYY-MM-DD`_ format.  If the target date is later than the subscription current term end date, the preview invoice item data and credit memo item data is generated from the first day of the customer's next billing period to the current term end date. If you want to generate preview invoice item data and credit memo item data past the end of the subscription current term, specify the AssumeRenewal field in the request.  **Note:** The credit memo item data is only available if you have Invoice Settlement feature enabled. The Invoice Settlement feature is generally available as of Zuora Billing Release 296 (March 2021). This feature includes Unapplied Payments, Credit and Debit Memo, and Invoice Item Settlement. If you want to enable Invoice Settlement, see [Invoice Settlement Enablement and Checklist Guide](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/Invoice_Settlement/Invoice_Settlement_Migration_Checklist_and_Guide) for more information. 
    String assumeRenewal = "assumeRenewal_example"; // Indicates whether to generate a preview of future invoice items and credit memo items with the assumption that the subscriptions are renewed.  Set one of the following values in this field to decide how the assumption is applied in the billing preview.    * **All:** The assumption is applied to all the subscriptions. Zuora generates preview invoice item data and credit memo item data from the first day of the customer's next billing period to the target date.      * **None:** (Default) The assumption is not applied to the subscriptions. Zuora generates preview invoice item data and credit memo item data based on the current term end date and the target date.        * If the target date is later than the current term end date, Zuora generates preview invoice item data and credit memo item data from the first day of the customer's next billing period to the current term end date.      * If the target date is earlier than the current term end date, Zuora generates preview invoice item data and credit memeo item data from the first day of the customer's next billing period to the target date.    * **Autorenew:** The assumption is applied to the subscriptions that have auto-renew enabled. Zuora generates preview invoice item data and credit memo item data from the first day of the customer's next billing period to the target date.      **Note:**    - This field can only be used if the subscription renewal term is not set to 0.           - The credit memo item data is only available if you have Invoice Settlement feature enabled. The Invoice Settlement feature is generally available as of Zuora Billing Release 296 (March 2021). This feature includes Unapplied Payments, Credit and Debit Memo, and Invoice Item Settlement. If you want to enable Invoice Settlement, see [Invoice Settlement Enablement and Checklist Guide](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/Invoice_Settlement/Invoice_Settlement_Migration_Checklist_and_Guide) for more information.  
    String batch = "batch_example"; // The customer batch to include in the billing preview run. If not specified, all customer batches are included.   **Note**:    - **Note**: By default, you have 50 configurable account batches. To increase the limit to 200 batches, you must have the <a href=\\\"https://knowledgecenter.zuora.com/Zuora_Central_Platform/Performance_Booster_Elite\\\" target=\\\"_blank\\\">Performance Booster Elite</a> package.   - This field is not available if you set the `zuora-version` request header to `314.0` or later [available versions](https://developer.zuora.com/api-references/api/overview/#section/API-Versions/Minor-Version). 
    String batches = "batches_example"; // The customer batches to include in the billing preview run. You can specify multiple batches separated by comma. If not specified, all customer batches are included.  **Note**:    - By default, you have 50 configurable account batches. To increase the limit to 200 batches, you must have the <a href=\\\"https://knowledgecenter.zuora.com/Zuora_Central_Platform/Performance_Booster_Elite\\\" target=\\\"_blank\\\">Performance Booster Elite</a> package.   - This field is only available if you set the `zuora-version` request header to `314.0` or later [available versions](https://developer.zuora.com/api-references/api/overview/#section/API-Versions/Minor-Version). 
    String chargeTypeToExclude = "chargeTypeToExclude_example"; // The charge types to exclude from the forecast run.  **Possible values:** OneTime, Recurring, Usage, and any comma-separated combination of these values. 
    Boolean includingDraftItems = true; // Whether draft document items are included in the billing preview run. By default, draft document items are not included.  This field loads draft invoice items and credit memo items. The `chargeTypeToExclude`, `targetDate`, `includingEvergreenSubscription`, and `assumeRenewal` fields do not affect the behavior of the `includingDraftItems` field. 
    Boolean includingEvergreenSubscription = true; // Whether evergreen subscriptions are included in the billing preview run. By default, evergreen subscriptions are not included. 
    List<GETCatalogGroupProductRatePlanResponseOrganizationLabelsInner> organizationLabels = Arrays.asList(); // The organization(s) that this billing preview run is created for.   For each item in the array, either the `organizationId` or the `organizationName` field is required.  This field is only required when you have already turned on Multi-Org feature. 
    String storageOption = "Csv"; // The saving options. The default value is `Csv`. 
    String idempotencyKey = "idempotencyKey_example"; // Specify a unique idempotency key if you want to perform an idempotent POST or PATCH request. Do not use this header in other request types.   With this header specified, the Zuora server can identify subsequent retries of the same request using this value, which prevents the same operation from being performed multiple times by accident.  
    String acceptEncoding = "acceptEncoding_example"; // Include the `Accept-Encoding: gzip` header to compress responses as a gzipped file. It can significantly reduce the bandwidth required for a response.   If specified, Zuora automatically compresses responses that contain over 1000 bytes of data, and the response contains a `Content-Encoding` header with the compression algorithm so that your client can decompress it. 
    String contentEncoding = "contentEncoding_example"; // Include the `Content-Encoding: gzip` header to compress a request. With this header specified, you should upload a gzipped file for the request payload instead of sending the JSON payload. 
    String authorization = "authorization_example"; // The value is in the `Bearer {token}` format where {token} is a valid OAuth token generated by calling [Create an OAuth token](https://developer.zuora.com/api-references/api/operation/createToken). 
    String zuoraTrackId = "zuoraTrackId_example"; // A custom identifier for tracing the API call. If you set a value for this header, Zuora returns the same value in the response headers. This header enables you to associate your system process identifiers with Zuora API calls, to assist with troubleshooting in the event of an issue.  The value of this field must use the US-ASCII character set and must not include any of the following characters: colon (`:`), semicolon (`;`), double quote (`\"`), and quote (`'`). 
    String zuoraEntityIds = "zuoraEntityIds_example"; // An entity ID. If you have [Zuora Multi-entity](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Multi-entity) enabled and the OAuth token is valid for more than one entity, you must use this header to specify which entity to perform the operation in. If the OAuth token is only valid for a single entity, or you do not have Zuora Multi-entity enabled, you do not need to set this header. 
    String zuoraOrgIds = "zuoraOrgIds_example"; // Comma separated IDs. If you have <a href=\"https://knowledgecenter.zuora.com/Zuora_Central_Platform/Multi-Org\" target=\"_blank\">Zuora Multi-Org</a> enabled,  you can use this header to specify which orgs to perform the operation in. If you do not have Zuora Multi-Org enabled, you should not set this header.  The IDs must be a sub-set of the user's accessible orgs. If you specify an org that the user does not have access to, the operation fails.  If the header is not set, the operation is performed in scope of the user's accessible orgs. 
    String zuoraVersion = "zuoraVersion_example"; //  The minor version of the Zuora REST API. See [Minor Version](https://developer.zuora.com/api-references/api/overview/#section/API-Versions/Minor-Version) for information about REST API version control.   This header affects the availability of the following request fields: * `batch` * `batches`         
    try {
      PostBillingPreviewRunResponse result = client
              .billingPreviewRun
              .billingPreviewRun(targetDate)
              .assumeRenewal(assumeRenewal)
              .batch(batch)
              .batches(batches)
              .chargeTypeToExclude(chargeTypeToExclude)
              .includingDraftItems(includingDraftItems)
              .includingEvergreenSubscription(includingEvergreenSubscription)
              .organizationLabels(organizationLabels)
              .storageOption(storageOption)
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
      System.out.println(result.getBillingPreviewRunId());
      System.out.println(result.getSuccess());
    } catch (ApiException e) {
      System.err.println("Exception when calling BillingPreviewRunApi#billingPreviewRun");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<PostBillingPreviewRunResponse> response = client
              .billingPreviewRun
              .billingPreviewRun(targetDate)
              .assumeRenewal(assumeRenewal)
              .batch(batch)
              .batches(batches)
              .chargeTypeToExclude(chargeTypeToExclude)
              .includingDraftItems(includingDraftItems)
              .includingEvergreenSubscription(includingEvergreenSubscription)
              .organizationLabels(organizationLabels)
              .storageOption(storageOption)
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
      System.err.println("Exception when calling BillingPreviewRunApi#billingPreviewRun");
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
| **postBillingPreviewRunParam** | [**PostBillingPreviewRunParam**](PostBillingPreviewRunParam.md)|  | |
| **idempotencyKey** | **String**| Specify a unique idempotency key if you want to perform an idempotent POST or PATCH request. Do not use this header in other request types.   With this header specified, the Zuora server can identify subsequent retries of the same request using this value, which prevents the same operation from being performed multiple times by accident.   | [optional] |
| **acceptEncoding** | **String**| Include the &#x60;Accept-Encoding: gzip&#x60; header to compress responses as a gzipped file. It can significantly reduce the bandwidth required for a response.   If specified, Zuora automatically compresses responses that contain over 1000 bytes of data, and the response contains a &#x60;Content-Encoding&#x60; header with the compression algorithm so that your client can decompress it.  | [optional] |
| **contentEncoding** | **String**| Include the &#x60;Content-Encoding: gzip&#x60; header to compress a request. With this header specified, you should upload a gzipped file for the request payload instead of sending the JSON payload.  | [optional] |
| **authorization** | **String**| The value is in the &#x60;Bearer {token}&#x60; format where {token} is a valid OAuth token generated by calling [Create an OAuth token](https://developer.zuora.com/api-references/api/operation/createToken).  | [optional] |
| **zuoraTrackId** | **String**| A custom identifier for tracing the API call. If you set a value for this header, Zuora returns the same value in the response headers. This header enables you to associate your system process identifiers with Zuora API calls, to assist with troubleshooting in the event of an issue.  The value of this field must use the US-ASCII character set and must not include any of the following characters: colon (&#x60;:&#x60;), semicolon (&#x60;;&#x60;), double quote (&#x60;\&quot;&#x60;), and quote (&#x60;&#39;&#x60;).  | [optional] |
| **zuoraEntityIds** | **String**| An entity ID. If you have [Zuora Multi-entity](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Multi-entity) enabled and the OAuth token is valid for more than one entity, you must use this header to specify which entity to perform the operation in. If the OAuth token is only valid for a single entity, or you do not have Zuora Multi-entity enabled, you do not need to set this header.  | [optional] |
| **zuoraOrgIds** | **String**| Comma separated IDs. If you have &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Central_Platform/Multi-Org\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Zuora Multi-Org&lt;/a&gt; enabled,  you can use this header to specify which orgs to perform the operation in. If you do not have Zuora Multi-Org enabled, you should not set this header.  The IDs must be a sub-set of the user&#39;s accessible orgs. If you specify an org that the user does not have access to, the operation fails.  If the header is not set, the operation is performed in scope of the user&#39;s accessible orgs.  | [optional] |
| **zuoraVersion** | **String**|  The minor version of the Zuora REST API. See [Minor Version](https://developer.zuora.com/api-references/api/overview/#section/API-Versions/Minor-Version) for information about REST API version control.   This header affects the availability of the following request fields: * &#x60;batch&#x60; * &#x60;batches&#x60;          | [optional] |

### Return type

[**PostBillingPreviewRunResponse**](PostBillingPreviewRunResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** |  |  * Content-Encoding - This header is returned if you specify the &#x60;Accept-Encoding: gzip&#x60; request header and the response contains over 1000 bytes of data. Note that only the following MIME types support gzipped responses:   - &#x60;application/json&#x60;   - &#x60;application/xml&#x60;   - &#x60;text/html&#x60;   - &#x60;text/csv&#x60;   - &#x60;text/plain&#x60;  <br>  * RateLimit-Limit - The request limit quota for the time window closest to exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Remaining - The number of requests remaining in the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Reset - The number of seconds until the quota resets for the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Zuora-Request-Id - The Zuora internal identifier of the API call. You cannot control the value of this header.  <br>  * Zuora-Track-Id - A custom identifier for tracing the API call. If you specified a tracing identifier in the request headers, Zuora returns the same tracing identifier. Otherwise, Zuora does not set this header.  <br>  |

<a name="billingPreviewRun_0"></a>
# **billingPreviewRun_0**
> GetBillingPreviewRunResponse billingPreviewRun_0(billingPreviewRunId).acceptEncoding(acceptEncoding).contentEncoding(contentEncoding).authorization(authorization).zuoraTrackId(zuoraTrackId).zuoraEntityIds(zuoraEntityIds).zuoraOrgIds(zuoraOrgIds).zuoraVersion(zuoraVersion).execute();

Retrieve a billing preview run

Retrieves a preview of future invoice items for multiple customer accounts through a billing preview run. If you have the Invoice Settlement feature enabled,  you can also retrieve a preview of future credit memo items. The Invoice Settlement feature is generally available as of Zuora Billing Release 296 (March 2021). This feature includes Unapplied Payments, Credit and Debit Memo, and Invoice Item Settlement. If you want to enable Invoice Settlement, see [Invoice Settlement Enablement and Checklist Guide](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/Invoice_Settlement/Invoice_Settlement_Migration_Checklist_and_Guide) for more information.   A billing preview run asynchronously generates a downloadable CSV file containing a preview of invoice item data and credit memo item data for a batch of customer accounts. Note that if you set &#x60;storageOption&#x60; to &#x60;Database&#x60;, no CSV file is generate; instead, you can have a record in the billing preview result. You can use data source to query &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Central_Platform/Reporting/D_Data_Sources_and_Exports/C_Data_Source_Reference/Billing_Preview_Run_Result_data_source\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Billing Preview Run Result&lt;/a&gt;.  

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Zuora;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.BillingPreviewRunApi;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Example {
  public static void main(String[] args) {
    Configuration configuration = new Configuration();
    configuration.host = "https://rest.zuora.com";
    Zuora client = new Zuora(configuration);
    String billingPreviewRunId = "billingPreviewRunId_example"; // Id of the billing preview run. 
    String acceptEncoding = "acceptEncoding_example"; // Include the `Accept-Encoding: gzip` header to compress responses as a gzipped file. It can significantly reduce the bandwidth required for a response.   If specified, Zuora automatically compresses responses that contain over 1000 bytes of data, and the response contains a `Content-Encoding` header with the compression algorithm so that your client can decompress it. 
    String contentEncoding = "contentEncoding_example"; // Include the `Content-Encoding: gzip` header to compress a request. With this header specified, you should upload a gzipped file for the request payload instead of sending the JSON payload. 
    String authorization = "authorization_example"; // The value is in the `Bearer {token}` format where {token} is a valid OAuth token generated by calling [Create an OAuth token](https://developer.zuora.com/api-references/api/operation/createToken). 
    String zuoraTrackId = "zuoraTrackId_example"; // A custom identifier for tracing the API call. If you set a value for this header, Zuora returns the same value in the response headers. This header enables you to associate your system process identifiers with Zuora API calls, to assist with troubleshooting in the event of an issue.  The value of this field must use the US-ASCII character set and must not include any of the following characters: colon (`:`), semicolon (`;`), double quote (`\"`), and quote (`'`). 
    String zuoraEntityIds = "zuoraEntityIds_example"; // An entity ID. If you have [Zuora Multi-entity](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Multi-entity) enabled and the OAuth token is valid for more than one entity, you must use this header to specify which entity to perform the operation in. If the OAuth token is only valid for a single entity, or you do not have Zuora Multi-entity enabled, you do not need to set this header. 
    String zuoraOrgIds = "zuoraOrgIds_example"; // Comma separated IDs. If you have <a href=\"https://knowledgecenter.zuora.com/Zuora_Central_Platform/Multi-Org\" target=\"_blank\">Zuora Multi-Org</a> enabled,  you can use this header to specify which orgs to perform the operation in. If you do not have Zuora Multi-Org enabled, you should not set this header.  The IDs must be a sub-set of the user's accessible orgs. If you specify an org that the user does not have access to, the operation fails.  If the header is not set, the operation is performed in scope of the user's accessible orgs. 
    String zuoraVersion = "zuoraVersion_example"; //  The minor version of the Zuora REST API. See [Minor Version](https://developer.zuora.com/api-references/api/overview/#section/API-Versions/Minor-Version) for information about REST API version control.   This header affects the availability of the following request fields: * `batch` * `batches` 
    try {
      GetBillingPreviewRunResponse result = client
              .billingPreviewRun
              .billingPreviewRun_0(billingPreviewRunId)
              .acceptEncoding(acceptEncoding)
              .contentEncoding(contentEncoding)
              .authorization(authorization)
              .zuoraTrackId(zuoraTrackId)
              .zuoraEntityIds(zuoraEntityIds)
              .zuoraOrgIds(zuoraOrgIds)
              .zuoraVersion(zuoraVersion)
              .execute();
      System.out.println(result);
      System.out.println(result.getAssumeRenewal());
      System.out.println(result.getBatch());
      System.out.println(result.getBatches());
      System.out.println(result.getChargeTypeToExclude());
      System.out.println(result.getCreatedById());
      System.out.println(result.getCreatedDate());
      System.out.println(result.getEndDate());
      System.out.println(result.getErrorMessage());
      System.out.println(result.getIncludingDraftItems());
      System.out.println(result.getIncludingEvergreenSubscription());
      System.out.println(result.getOrganizationLabels());
      System.out.println(result.getResultFileUrl());
      System.out.println(result.getRunNumber());
      System.out.println(result.getStartDate());
      System.out.println(result.getStatus());
      System.out.println(result.getStorageOption());
      System.out.println(result.getSucceededAccounts());
      System.out.println(result.getSuccess());
      System.out.println(result.getTargetDate());
      System.out.println(result.getTotalAccounts());
      System.out.println(result.getUpdatedById());
      System.out.println(result.getUpdatedDate());
    } catch (ApiException e) {
      System.err.println("Exception when calling BillingPreviewRunApi#billingPreviewRun_0");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<GetBillingPreviewRunResponse> response = client
              .billingPreviewRun
              .billingPreviewRun_0(billingPreviewRunId)
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
      System.err.println("Exception when calling BillingPreviewRunApi#billingPreviewRun_0");
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
| **billingPreviewRunId** | **String**| Id of the billing preview run.  | |
| **acceptEncoding** | **String**| Include the &#x60;Accept-Encoding: gzip&#x60; header to compress responses as a gzipped file. It can significantly reduce the bandwidth required for a response.   If specified, Zuora automatically compresses responses that contain over 1000 bytes of data, and the response contains a &#x60;Content-Encoding&#x60; header with the compression algorithm so that your client can decompress it.  | [optional] |
| **contentEncoding** | **String**| Include the &#x60;Content-Encoding: gzip&#x60; header to compress a request. With this header specified, you should upload a gzipped file for the request payload instead of sending the JSON payload.  | [optional] |
| **authorization** | **String**| The value is in the &#x60;Bearer {token}&#x60; format where {token} is a valid OAuth token generated by calling [Create an OAuth token](https://developer.zuora.com/api-references/api/operation/createToken).  | [optional] |
| **zuoraTrackId** | **String**| A custom identifier for tracing the API call. If you set a value for this header, Zuora returns the same value in the response headers. This header enables you to associate your system process identifiers with Zuora API calls, to assist with troubleshooting in the event of an issue.  The value of this field must use the US-ASCII character set and must not include any of the following characters: colon (&#x60;:&#x60;), semicolon (&#x60;;&#x60;), double quote (&#x60;\&quot;&#x60;), and quote (&#x60;&#39;&#x60;).  | [optional] |
| **zuoraEntityIds** | **String**| An entity ID. If you have [Zuora Multi-entity](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Multi-entity) enabled and the OAuth token is valid for more than one entity, you must use this header to specify which entity to perform the operation in. If the OAuth token is only valid for a single entity, or you do not have Zuora Multi-entity enabled, you do not need to set this header.  | [optional] |
| **zuoraOrgIds** | **String**| Comma separated IDs. If you have &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Central_Platform/Multi-Org\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Zuora Multi-Org&lt;/a&gt; enabled,  you can use this header to specify which orgs to perform the operation in. If you do not have Zuora Multi-Org enabled, you should not set this header.  The IDs must be a sub-set of the user&#39;s accessible orgs. If you specify an org that the user does not have access to, the operation fails.  If the header is not set, the operation is performed in scope of the user&#39;s accessible orgs.  | [optional] |
| **zuoraVersion** | **String**|  The minor version of the Zuora REST API. See [Minor Version](https://developer.zuora.com/api-references/api/overview/#section/API-Versions/Minor-Version) for information about REST API version control.   This header affects the availability of the following request fields: * &#x60;batch&#x60; * &#x60;batches&#x60;  | [optional] |

### Return type

[**GetBillingPreviewRunResponse**](GetBillingPreviewRunResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** |  |  * Content-Encoding - This header is returned if you specify the &#x60;Accept-Encoding: gzip&#x60; request header and the response contains over 1000 bytes of data. Note that only the following MIME types support gzipped responses:   - &#x60;application/json&#x60;   - &#x60;application/xml&#x60;   - &#x60;text/html&#x60;   - &#x60;text/csv&#x60;   - &#x60;text/plain&#x60;  <br>  * RateLimit-Limit - The request limit quota for the time window closest to exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Remaining - The number of requests remaining in the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Reset - The number of seconds until the quota resets for the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Zuora-Request-Id - The Zuora internal identifier of the API call. You cannot control the value of this header.  <br>  * Zuora-Track-Id - A custom identifier for tracing the API call. If you specified a tracing identifier in the request headers, Zuora returns the same tracing identifier. Otherwise, Zuora does not set this header.  <br>  |

