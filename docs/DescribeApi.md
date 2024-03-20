# DescribeApi

All URIs are relative to *https://rest.zuora.com*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**describe**](DescribeApi.md#describe) | **GET** /v1/describe/{object} | Describe an object |


<a name="describe"></a>
# **describe**
> String describe(_object).acceptEncoding(acceptEncoding).contentEncoding(contentEncoding).authorization(authorization).zuoraTrackId(zuoraTrackId).zuoraEntityIds(zuoraEntityIds).zuoraOrgIds(zuoraOrgIds).showCurrencyConversionInformation(showCurrencyConversionInformation).execute();

Describe an object

Provides a reference listing of each object that is available in your Zuora tenant.  The information returned by this call is useful if you are using [CRUD: Create Export](https://developer.zuora.com/api-references/api/operation/Object_POSTExport) or the [AQuA API](https://knowledgecenter.zuora.com/DC_Developers/T_Aggregate_Query_API) to create a data source export. See [Export ZOQL](https://knowledgecenter.zuora.com/DC_Developers/M_Export_ZOQL) for more information.  ### Response The response contains an XML document that lists the fields of the specified object. Each of the object&#39;s fields is represented by a &#x60;&lt;field&gt;&#x60; element in the XML document.      Each &#x60;&lt;field&gt;&#x60; element contains the following elements:  | Element      | Description                                                                                                                                                                                                                                                                                  | |--------------|----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------| | &#x60;&lt;name&gt;&#x60;     | API name of the field.                                                                                                                                                                                                                                                                       | | &#x60;&lt;label&gt;&#x60;    | Name of the field in the Zuora user interface.                                                                                                                                                                                                                                               | | &#x60;&lt;type&gt;&#x60;     | Data type of the field. The possible data types are: &#x60;boolean&#x60;, &#x60;date&#x60;, &#x60;datetime&#x60;, &#x60;decimal&#x60;, &#x60;integer&#x60;, &#x60;picklist&#x60;, &#x60;text&#x60;, &#x60;timestamp&#x60;, and &#x60;ZOQL&#x60;. If the data type is &#x60;picklist&#x60;, the &#x60;&lt;field&gt;&#x60; element contains an &#x60;&lt;options&gt;&#x60; element that lists the possible values of the field.    | | &#x60;&lt;contexts&gt;&#x60; | Specifies the availability of the field. If the &#x60;&lt;contexts&gt;&#x60; element lists the &#x60;export&#x60; context, the field is available for use in data source exports.                                                                                                                                                |  The &#x60;&lt;field&gt;&#x60; element contains other elements that provide legacy information about the field. This information is not directly related to the REST API.  Response sample: &#x60;&#x60;&#x60;xml &lt;?xml version&#x3D;\&quot;1.0\&quot; encoding&#x3D;\&quot;UTF-8\&quot;?&gt; &lt;object&gt;   &lt;name&gt;ProductRatePlanCharge&lt;/name&gt;   &lt;label&gt;Product Rate Plan Charge&lt;/label&gt;   &lt;fields&gt;     ...     &lt;field&gt;       &lt;name&gt;TaxMode&lt;/name&gt;       &lt;label&gt;Tax Mode&lt;/label&gt;       &lt;type&gt;picklist&lt;/type&gt;       &lt;options&gt;         &lt;option&gt;TaxExclusive&lt;/option&gt;         &lt;option&gt;TaxInclusive&lt;/option&gt;       &lt;/options&gt;       &lt;contexts&gt;         &lt;context&gt;export&lt;/context&gt;       &lt;/contexts&gt;       ...     &lt;/field&gt;     ...   &lt;/fields&gt; &lt;/object&gt; &#x60;&#x60;&#x60;  It is strongly recommended that your integration checks &#x60;&lt;contexts&gt;&#x60; elements in the response. If your integration does not check &#x60;&lt;contexts&gt;&#x60; elements, your integration may process fields that are not available for use in data source exports. See [Changes to the Describe API](https://knowledgecenter.zuora.com/DC_Developers/M_Export_ZOQL/Changes_to_the_Describe_API) for more information. 

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Zuora;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.DescribeApi;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Example {
  public static void main(String[] args) {
    Configuration configuration = new Configuration();
    configuration.host = "https://rest.zuora.com";
    Zuora client = new Zuora(configuration);
    String _object = "_object_example"; // API name of an object in your Zuora tenant. For example, `InvoiceItem`. See [Zuora Object Model](https://developer.zuora.com/rest-api/general-concepts/object-model/) for the list of valid object names.  Depending on the features enabled in your Zuora tenant, you may not be able to list the fields of some objects. 
    String acceptEncoding = "acceptEncoding_example"; // Include the `Accept-Encoding: gzip` header to compress responses as a gzipped file. It can significantly reduce the bandwidth required for a response.   If specified, Zuora automatically compresses responses that contain over 1000 bytes of data, and the response contains a `Content-Encoding` header with the compression algorithm so that your client can decompress it. 
    String contentEncoding = "contentEncoding_example"; // Include the `Content-Encoding: gzip` header to compress a request. With this header specified, you should upload a gzipped file for the request payload instead of sending the JSON payload. 
    String authorization = "authorization_example"; // The value is in the `Bearer {token}` format where {token} is a valid OAuth token generated by calling [Create an OAuth token](https://developer.zuora.com/api-references/api/operation/createToken). 
    String zuoraTrackId = "zuoraTrackId_example"; // A custom identifier for tracing the API call. If you set a value for this header, Zuora returns the same value in the response headers. This header enables you to associate your system process identifiers with Zuora API calls, to assist with troubleshooting in the event of an issue.  The value of this field must use the US-ASCII character set and must not include any of the following characters: colon (`:`), semicolon (`;`), double quote (`\"`), and quote (`'`). 
    String zuoraEntityIds = "zuoraEntityIds_example"; // An entity ID. If you have [Zuora Multi-entity](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Multi-entity) enabled and the OAuth token is valid for more than one entity, you must use this header to specify which entity to perform the operation in. If the OAuth token is only valid for a single entity, or you do not have Zuora Multi-entity enabled, you do not need to set this header. 
    String zuoraOrgIds = "zuoraOrgIds_example"; // Comma separated IDs. If you have <a href=\"https://knowledgecenter.zuora.com/Zuora_Central_Platform/Multi-Org\" target=\"_blank\">Zuora Multi-Org</a> enabled,  you can use this header to specify which orgs to perform the operation in. If you do not have Zuora Multi-Org enabled, you should not set this header.  The IDs must be a sub-set of the user's accessible orgs. If you specify an org that the user does not have access to, the operation fails.  If the header is not set, the operation is performed in scope of the user's accessible orgs. 
    String showCurrencyConversionInformation = "showCurrencyConversionInformation_example"; // Set the value to `yes` to get additional currency conversion information in the result. **Notes:**  - When **Automatically include additional Currency Conversion information** in currency conversion settings is checked, you can pass `yes` to get additional fields in the result. See [Configure Foreign Currency Conversion](https://knowledgecenter.zuora.com/Zuora_Payments/Zuora_Finance/D_Finance_Settings/F_Foreign_Currency_Conversion#:~:text=Automatically%20include%20additional%20Currency%20Conversion%20information%20in%20data%20source%20exports%3A%C2%A0Select%20this%20check%20box%20if%20you%20want%20to%20access%20foreign%20currency%20conversion%20data%20through%20data%20source%20exports.) to check the **Automatically include additional Currency Conversion information**. - By default if you need additional Currency Conversion information, submit a request at <a href=\"https://support.zuora.com/hc/en-us\" target=\"_blank\">Zuora Global Support</a>. Set this parameter value to `no` to not include the additional currency conversion information in the result. 
    try {
      String result = client
              .describe
              .describe(_object)
              .acceptEncoding(acceptEncoding)
              .contentEncoding(contentEncoding)
              .authorization(authorization)
              .zuoraTrackId(zuoraTrackId)
              .zuoraEntityIds(zuoraEntityIds)
              .zuoraOrgIds(zuoraOrgIds)
              .showCurrencyConversionInformation(showCurrencyConversionInformation)
              .execute();
    } catch (ApiException e) {
      System.err.println("Exception when calling DescribeApi#describe");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<String> response = client
              .describe
              .describe(_object)
              .acceptEncoding(acceptEncoding)
              .contentEncoding(contentEncoding)
              .authorization(authorization)
              .zuoraTrackId(zuoraTrackId)
              .zuoraEntityIds(zuoraEntityIds)
              .zuoraOrgIds(zuoraOrgIds)
              .showCurrencyConversionInformation(showCurrencyConversionInformation)
              .executeWithHttpInfo();
      System.out.println(response.getResponseBody());
      System.out.println(response.getResponseHeaders());
      System.out.println(response.getStatusCode());
      System.out.println(response.getRoundTripTime());
      System.out.println(response.getRequest());
    } catch (ApiException e) {
      System.err.println("Exception when calling DescribeApi#describe");
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
| **_object** | **String**| API name of an object in your Zuora tenant. For example, &#x60;InvoiceItem&#x60;. See [Zuora Object Model](https://developer.zuora.com/rest-api/general-concepts/object-model/) for the list of valid object names.  Depending on the features enabled in your Zuora tenant, you may not be able to list the fields of some objects.  | |
| **acceptEncoding** | **String**| Include the &#x60;Accept-Encoding: gzip&#x60; header to compress responses as a gzipped file. It can significantly reduce the bandwidth required for a response.   If specified, Zuora automatically compresses responses that contain over 1000 bytes of data, and the response contains a &#x60;Content-Encoding&#x60; header with the compression algorithm so that your client can decompress it.  | [optional] |
| **contentEncoding** | **String**| Include the &#x60;Content-Encoding: gzip&#x60; header to compress a request. With this header specified, you should upload a gzipped file for the request payload instead of sending the JSON payload.  | [optional] |
| **authorization** | **String**| The value is in the &#x60;Bearer {token}&#x60; format where {token} is a valid OAuth token generated by calling [Create an OAuth token](https://developer.zuora.com/api-references/api/operation/createToken).  | [optional] |
| **zuoraTrackId** | **String**| A custom identifier for tracing the API call. If you set a value for this header, Zuora returns the same value in the response headers. This header enables you to associate your system process identifiers with Zuora API calls, to assist with troubleshooting in the event of an issue.  The value of this field must use the US-ASCII character set and must not include any of the following characters: colon (&#x60;:&#x60;), semicolon (&#x60;;&#x60;), double quote (&#x60;\&quot;&#x60;), and quote (&#x60;&#39;&#x60;).  | [optional] |
| **zuoraEntityIds** | **String**| An entity ID. If you have [Zuora Multi-entity](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Multi-entity) enabled and the OAuth token is valid for more than one entity, you must use this header to specify which entity to perform the operation in. If the OAuth token is only valid for a single entity, or you do not have Zuora Multi-entity enabled, you do not need to set this header.  | [optional] |
| **zuoraOrgIds** | **String**| Comma separated IDs. If you have &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Central_Platform/Multi-Org\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Zuora Multi-Org&lt;/a&gt; enabled,  you can use this header to specify which orgs to perform the operation in. If you do not have Zuora Multi-Org enabled, you should not set this header.  The IDs must be a sub-set of the user&#39;s accessible orgs. If you specify an org that the user does not have access to, the operation fails.  If the header is not set, the operation is performed in scope of the user&#39;s accessible orgs.  | [optional] |
| **showCurrencyConversionInformation** | **String**| Set the value to &#x60;yes&#x60; to get additional currency conversion information in the result. **Notes:**  - When **Automatically include additional Currency Conversion information** in currency conversion settings is checked, you can pass &#x60;yes&#x60; to get additional fields in the result. See [Configure Foreign Currency Conversion](https://knowledgecenter.zuora.com/Zuora_Payments/Zuora_Finance/D_Finance_Settings/F_Foreign_Currency_Conversion#:~:text&#x3D;Automatically%20include%20additional%20Currency%20Conversion%20information%20in%20data%20source%20exports%3A%C2%A0Select%20this%20check%20box%20if%20you%20want%20to%20access%20foreign%20currency%20conversion%20data%20through%20data%20source%20exports.) to check the **Automatically include additional Currency Conversion information**. - By default if you need additional Currency Conversion information, submit a request at &lt;a href&#x3D;\&quot;https://support.zuora.com/hc/en-us\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Zuora Global Support&lt;/a&gt;. Set this parameter value to &#x60;no&#x60; to not include the additional currency conversion information in the result.  | [optional] |

### Return type

**String**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: text/xml; charset=utf-8

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Returns an XML document that lists the fields of the specified object  |  * Content-Encoding - This header is returned if you specify the &#x60;Accept-Encoding: gzip&#x60; request header and the response contains over 1000 bytes of data. Note that only the following MIME types support gzipped responses:   - &#x60;application/json&#x60;   - &#x60;application/xml&#x60;   - &#x60;text/html&#x60;   - &#x60;text/csv&#x60;   - &#x60;text/plain&#x60;  <br>  * RateLimit-Limit - The request limit quota for the time window closest to exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Remaining - The number of requests remaining in the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Reset - The number of seconds until the quota resets for the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Zuora-Request-Id - The Zuora internal identifier of the API call. You cannot control the value of this header.  <br>  * Zuora-Track-Id - A custom identifier for tracing the API call. If you specified a tracing identifier in the request headers, Zuora returns the same tracing identifier. Otherwise, Zuora does not set this header.  <br>  |

