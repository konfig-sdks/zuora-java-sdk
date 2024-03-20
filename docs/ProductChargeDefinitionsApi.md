# ProductChargeDefinitionsApi

All URIs are relative to *https://rest.zuora.com*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**createProductChargeDefinition**](ProductChargeDefinitionsApi.md#createProductChargeDefinition) | **POST** /v1/product-charge-definitions | Create a product charge definition |
| [**createProductChargeDefinitionBulk**](ProductChargeDefinitionsApi.md#createProductChargeDefinitionBulk) | **POST** /v1/product-charge-definitions/bulk | Create product charge definitions |
| [**productChargeDefnition**](ProductChargeDefinitionsApi.md#productChargeDefnition) | **DELETE** /v1/product-charge-definitions/{product-charge-definition-key} | Delete a product charge definition |
| [**retrieveProductChargeDefinition**](ProductChargeDefinitionsApi.md#retrieveProductChargeDefinition) | **GET** /v1/product-charge-definitions/{product-charge-definition-key} | Retrieve a product charge definition |
| [**retrieveProductChargeDefinitions**](ProductChargeDefinitionsApi.md#retrieveProductChargeDefinitions) | **GET** /v1/product-charge-definitions | List product charge definitions |
| [**updateProductChargeDefinition**](ProductChargeDefinitionsApi.md#updateProductChargeDefinition) | **PUT** /v1/product-charge-definitions/{product-charge-definition-key} | Update a product charge definition |
| [**updateProductChargeDefinitionBulk**](ProductChargeDefinitionsApi.md#updateProductChargeDefinitionBulk) | **PUT** /v1/product-charge-definitions/bulk | Update product charge definitions |


<a name="createProductChargeDefinition"></a>
# **createProductChargeDefinition**
> POSTChargeDefinitionResponse createProductChargeDefinition(poSTChargeDefinitionRequest).idempotencyKey(idempotencyKey).acceptEncoding(acceptEncoding).contentEncoding(contentEncoding).authorization(authorization).zuoraTrackId(zuoraTrackId).zuoraEntityIds(zuoraEntityIds).execute();

Create a product charge definition

Creates a product charge definition for a charge. You can create as many product charge definitions as needed for one charge.  In the request, you must specify the unique ID or number of the charge for which this charge definition is to be created.  The ID or number of a product rate plan is optional.  **Note**: This operation requires the [Attribute-based Pricing](https://knowledgecenter.zuora.com/Zuora_Billing/Build_products_and_prices/Attribute_based_pricing/AA_Overview_of_Attribute-based_Pricing) feature to be enabled, which is in the **Early Adopter** phase.      

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Zuora;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.ProductChargeDefinitionsApi;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Example {
  public static void main(String[] args) {
    Configuration configuration = new Configuration();
    configuration.host = "https://rest.zuora.com";
    Zuora client = new Zuora(configuration);
    String billingPeriod = "billingPeriod_example"; // The billing period for the product charge definition. 
    String billingTiming = "IN_ADVANCE"; // The billing timing setting for the product charge definition. 
    String chargeModel = "DiscountFixedAmount"; // Determines how to calculate charges. Charge models must be individually activated in Zuora Billing administration. 
    Double defaultQuantity = 3.4D; // The default quantity.   This field is applicable only for one-time and recurring charges. 
    OffsetDateTime effectiveEndDate = OffsetDateTime.now(); // The effective end date of the product charge definition. 
    OffsetDateTime effectiveStartDate = OffsetDateTime.now(); // The effective start date of the product charge definition. 
    String listPriceBase = "Per_Billing_Period"; // The list price base.   This field is applicable only for recurring charges.  **Note**: The `Per_Year` enum value is available only if you have the <a href=\\\"https://knowledgecenter.zuora.com/Billing/Subscriptions/Product_Catalog/I_Annual_List_Price\\\" target=\\\"_blank\\\">Annual List Price</a> feature enabled. 
    List<POSTProductChargeDefinitionPricing> prices = Arrays.asList(); // Container for the prices of the product charge definition. 
    String productRatePlanChargeId = "productRatePlanChargeId_example"; // The unique ID of the charge of the charge definition. 
    String productRatePlanChargeNumber = "productRatePlanChargeNumber_example"; // The unique number (natural key) of the charge of the charge definition. 
    String productRatePlanId = "productRatePlanId_example"; // The unique ID of the product rate plan that uses this charge definition. 
    String productRatePlanNumber = "productRatePlanNumber_example"; // The unique number (natural key) of the product rate plan that uses this charge definition. 
    Double specificBillingPeriod = 3.4D; // The specific number of billing periods for the product charge definition. 
    Integer specificListPriceBase = 56; // The number of months for the list price base of the charge definition.  This field is `null` if the `listPriceBase` field is not set to `Per_Specific_Months`. 
    String taxCode = "taxCode_example"; // Specifies the tax code for taxation rules. This field is required when the `Taxable` field is set to `True`.  **Note**: This value affects the tax calculation of the charge. 
    String taxMode = "TaxExclusive"; // Determines how to define taxation for the charge. This field is required when the `Taxable` field is set to `True`.  **Note**: This value affects the tax calculation of the charge. 
    Boolean taxable = true; // Determines whether the charge definition is taxable. When this field is set to `True`, the `TaxMode` and `TaxCode` fields are required.  **Character limit**: 5  **Values**: `True`, `False`  **Note**: This value affects the tax calculation of the charge. 
    Double term = 3.4D; // The number of periods of a termed subscription that is eligible for this charge definition. This field is applicable when the `termType` field is set to `TERMED`,  and is to be used together with the `termPeriodType` field. 
    String termPeriodType = "Month"; // Specifies the period type for the subscription term that is eligible for this charge definition. 
    String termType = "TERMED"; // The type of the subscription that is eligible for this charge definition. 
    String uom = "uom_example"; // Describes the unit of measure (UOM) configured in **Settings > Billing** for the charge. 
    String idempotencyKey = "idempotencyKey_example"; // Specify a unique idempotency key if you want to perform an idempotent POST or PATCH request. Do not use this header in other request types.   With this header specified, the Zuora server can identify subsequent retries of the same request using this value, which prevents the same operation from being performed multiple times by accident.  
    String acceptEncoding = "acceptEncoding_example"; // Include the `Accept-Encoding: gzip` header to compress responses as a gzipped file. It can significantly reduce the bandwidth required for a response.   If specified, Zuora automatically compresses responses that contain over 1000 bytes of data, and the response contains a `Content-Encoding` header with the compression algorithm so that your client can decompress it. 
    String contentEncoding = "contentEncoding_example"; // Include the `Content-Encoding: gzip` header to compress a request. With this header specified, you should upload a gzipped file for the request payload instead of sending the JSON payload. 
    String authorization = "authorization_example"; // The value is in the `Bearer {token}` format where {token} is a valid OAuth token generated by calling [Create an OAuth token](https://developer.zuora.com/api-references/api/operation/createToken). 
    String zuoraTrackId = "zuoraTrackId_example"; // A custom identifier for tracing the API call. If you set a value for this header, Zuora returns the same value in the response headers. This header enables you to associate your system process identifiers with Zuora API calls, to assist with troubleshooting in the event of an issue.  The value of this field must use the US-ASCII character set and must not include any of the following characters: colon (`:`), semicolon (`;`), double quote (`\"`), and quote (`'`). 
    String zuoraEntityIds = "zuoraEntityIds_example"; // An entity ID. If you have [Zuora Multi-entity](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Multi-entity) enabled and the OAuth token is valid for more than one entity, you must use this header to specify which entity to perform the operation in. If the OAuth token is only valid for a single entity, or you do not have Zuora Multi-entity enabled, you do not need to set this header. 
    try {
      POSTChargeDefinitionResponse result = client
              .productChargeDefinitions
              .createProductChargeDefinition()
              .billingPeriod(billingPeriod)
              .billingTiming(billingTiming)
              .chargeModel(chargeModel)
              .defaultQuantity(defaultQuantity)
              .effectiveEndDate(effectiveEndDate)
              .effectiveStartDate(effectiveStartDate)
              .listPriceBase(listPriceBase)
              .prices(prices)
              .productRatePlanChargeId(productRatePlanChargeId)
              .productRatePlanChargeNumber(productRatePlanChargeNumber)
              .productRatePlanId(productRatePlanId)
              .productRatePlanNumber(productRatePlanNumber)
              .specificBillingPeriod(specificBillingPeriod)
              .specificListPriceBase(specificListPriceBase)
              .taxCode(taxCode)
              .taxMode(taxMode)
              .taxable(taxable)
              .term(term)
              .termPeriodType(termPeriodType)
              .termType(termType)
              .uom(uom)
              .idempotencyKey(idempotencyKey)
              .acceptEncoding(acceptEncoding)
              .contentEncoding(contentEncoding)
              .authorization(authorization)
              .zuoraTrackId(zuoraTrackId)
              .zuoraEntityIds(zuoraEntityIds)
              .execute();
      System.out.println(result);
      System.out.println(result.getChargeDefinitionId());
      System.out.println(result.getChargeDefinitionNumber());
      System.out.println(result.getSuccess());
    } catch (ApiException e) {
      System.err.println("Exception when calling ProductChargeDefinitionsApi#createProductChargeDefinition");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<POSTChargeDefinitionResponse> response = client
              .productChargeDefinitions
              .createProductChargeDefinition()
              .billingPeriod(billingPeriod)
              .billingTiming(billingTiming)
              .chargeModel(chargeModel)
              .defaultQuantity(defaultQuantity)
              .effectiveEndDate(effectiveEndDate)
              .effectiveStartDate(effectiveStartDate)
              .listPriceBase(listPriceBase)
              .prices(prices)
              .productRatePlanChargeId(productRatePlanChargeId)
              .productRatePlanChargeNumber(productRatePlanChargeNumber)
              .productRatePlanId(productRatePlanId)
              .productRatePlanNumber(productRatePlanNumber)
              .specificBillingPeriod(specificBillingPeriod)
              .specificListPriceBase(specificListPriceBase)
              .taxCode(taxCode)
              .taxMode(taxMode)
              .taxable(taxable)
              .term(term)
              .termPeriodType(termPeriodType)
              .termType(termType)
              .uom(uom)
              .idempotencyKey(idempotencyKey)
              .acceptEncoding(acceptEncoding)
              .contentEncoding(contentEncoding)
              .authorization(authorization)
              .zuoraTrackId(zuoraTrackId)
              .zuoraEntityIds(zuoraEntityIds)
              .executeWithHttpInfo();
      System.out.println(response.getResponseBody());
      System.out.println(response.getResponseHeaders());
      System.out.println(response.getStatusCode());
      System.out.println(response.getRoundTripTime());
      System.out.println(response.getRequest());
    } catch (ApiException e) {
      System.err.println("Exception when calling ProductChargeDefinitionsApi#createProductChargeDefinition");
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
| **poSTChargeDefinitionRequest** | [**POSTChargeDefinitionRequest**](POSTChargeDefinitionRequest.md)|  | |
| **idempotencyKey** | **String**| Specify a unique idempotency key if you want to perform an idempotent POST or PATCH request. Do not use this header in other request types.   With this header specified, the Zuora server can identify subsequent retries of the same request using this value, which prevents the same operation from being performed multiple times by accident.   | [optional] |
| **acceptEncoding** | **String**| Include the &#x60;Accept-Encoding: gzip&#x60; header to compress responses as a gzipped file. It can significantly reduce the bandwidth required for a response.   If specified, Zuora automatically compresses responses that contain over 1000 bytes of data, and the response contains a &#x60;Content-Encoding&#x60; header with the compression algorithm so that your client can decompress it.  | [optional] |
| **contentEncoding** | **String**| Include the &#x60;Content-Encoding: gzip&#x60; header to compress a request. With this header specified, you should upload a gzipped file for the request payload instead of sending the JSON payload.  | [optional] |
| **authorization** | **String**| The value is in the &#x60;Bearer {token}&#x60; format where {token} is a valid OAuth token generated by calling [Create an OAuth token](https://developer.zuora.com/api-references/api/operation/createToken).  | [optional] |
| **zuoraTrackId** | **String**| A custom identifier for tracing the API call. If you set a value for this header, Zuora returns the same value in the response headers. This header enables you to associate your system process identifiers with Zuora API calls, to assist with troubleshooting in the event of an issue.  The value of this field must use the US-ASCII character set and must not include any of the following characters: colon (&#x60;:&#x60;), semicolon (&#x60;;&#x60;), double quote (&#x60;\&quot;&#x60;), and quote (&#x60;&#39;&#x60;).  | [optional] |
| **zuoraEntityIds** | **String**| An entity ID. If you have [Zuora Multi-entity](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Multi-entity) enabled and the OAuth token is valid for more than one entity, you must use this header to specify which entity to perform the operation in. If the OAuth token is only valid for a single entity, or you do not have Zuora Multi-entity enabled, you do not need to set this header.  | [optional] |

### Return type

[**POSTChargeDefinitionResponse**](POSTChargeDefinitionResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** |  |  * Content-Encoding - This header is returned if you specify the &#x60;Accept-Encoding: gzip&#x60; request header and the response contains over 1000 bytes of data. Note that only the following MIME types support gzipped responses:   - &#x60;application/json&#x60;   - &#x60;application/xml&#x60;   - &#x60;text/html&#x60;   - &#x60;text/csv&#x60;   - &#x60;text/plain&#x60;  <br>  * RateLimit-Limit - The request limit quota for the time window closest to exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Remaining - The number of requests remaining in the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Reset - The number of seconds until the quota resets for the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Zuora-Request-Id - The Zuora internal identifier of the API call. You cannot control the value of this header.  <br>  * Zuora-Track-Id - A custom identifier for tracing the API call. If you specified a tracing identifier in the request headers, Zuora returns the same tracing identifier. Otherwise, Zuora does not set this header.  <br>  |

<a name="createProductChargeDefinitionBulk"></a>
# **createProductChargeDefinitionBulk**
> POSTChargeDefinitionBulkResponse createProductChargeDefinitionBulk(poSTChargeDefinitionRequestBulk).idempotencyKey(idempotencyKey).acceptEncoding(acceptEncoding).contentEncoding(contentEncoding).authorization(authorization).zuoraTrackId(zuoraTrackId).zuoraEntityIds(zuoraEntityIds).execute();

Create product charge definitions

Bulk creates product charge definitions for a charge. You can create up to 1000 product charge definitions at a given time for a specific charge.  In the request, you must specify the unique ID or number of the charge for which this charge definition is to be created.  The ID or number of a product rate plan is optional.  **Note**: This operation requires the [Attribute-based Pricing](https://knowledgecenter.zuora.com/Zuora_Billing/Build_products_and_prices/Attribute_based_pricing/AA_Overview_of_Attribute-based_Pricing) feature to be enabled, which is in the **Early Adopter** phase.  

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Zuora;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.ProductChargeDefinitionsApi;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Example {
  public static void main(String[] args) {
    Configuration configuration = new Configuration();
    configuration.host = "https://rest.zuora.com";
    Zuora client = new Zuora(configuration);
    List<POSTChargeDefinitionRequest> productChargeDefinitions = Arrays.asList(); // Container for the array of product charge definition. 
    String idempotencyKey = "idempotencyKey_example"; // Specify a unique idempotency key if you want to perform an idempotent POST or PATCH request. Do not use this header in other request types.   With this header specified, the Zuora server can identify subsequent retries of the same request using this value, which prevents the same operation from being performed multiple times by accident.  
    String acceptEncoding = "acceptEncoding_example"; // Include the `Accept-Encoding: gzip` header to compress responses as a gzipped file. It can significantly reduce the bandwidth required for a response.   If specified, Zuora automatically compresses responses that contain over 1000 bytes of data, and the response contains a `Content-Encoding` header with the compression algorithm so that your client can decompress it. 
    String contentEncoding = "contentEncoding_example"; // Include the `Content-Encoding: gzip` header to compress a request. With this header specified, you should upload a gzipped file for the request payload instead of sending the JSON payload. 
    String authorization = "authorization_example"; // The value is in the `Bearer {token}` format where {token} is a valid OAuth token generated by calling [Create an OAuth token](https://developer.zuora.com/api-references/api/operation/createToken). 
    String zuoraTrackId = "zuoraTrackId_example"; // A custom identifier for tracing the API call. If you set a value for this header, Zuora returns the same value in the response headers. This header enables you to associate your system process identifiers with Zuora API calls, to assist with troubleshooting in the event of an issue.  The value of this field must use the US-ASCII character set and must not include any of the following characters: colon (`:`), semicolon (`;`), double quote (`\"`), and quote (`'`). 
    String zuoraEntityIds = "zuoraEntityIds_example"; // An entity ID. If you have [Zuora Multi-entity](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Multi-entity) enabled and the OAuth token is valid for more than one entity, you must use this header to specify which entity to perform the operation in. If the OAuth token is only valid for a single entity, or you do not have Zuora Multi-entity enabled, you do not need to set this header. 
    try {
      POSTChargeDefinitionBulkResponse result = client
              .productChargeDefinitions
              .createProductChargeDefinitionBulk()
              .productChargeDefinitions(productChargeDefinitions)
              .idempotencyKey(idempotencyKey)
              .acceptEncoding(acceptEncoding)
              .contentEncoding(contentEncoding)
              .authorization(authorization)
              .zuoraTrackId(zuoraTrackId)
              .zuoraEntityIds(zuoraEntityIds)
              .execute();
      System.out.println(result);
      System.out.println(result.getProductChargeDefinitions());
    } catch (ApiException e) {
      System.err.println("Exception when calling ProductChargeDefinitionsApi#createProductChargeDefinitionBulk");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<POSTChargeDefinitionBulkResponse> response = client
              .productChargeDefinitions
              .createProductChargeDefinitionBulk()
              .productChargeDefinitions(productChargeDefinitions)
              .idempotencyKey(idempotencyKey)
              .acceptEncoding(acceptEncoding)
              .contentEncoding(contentEncoding)
              .authorization(authorization)
              .zuoraTrackId(zuoraTrackId)
              .zuoraEntityIds(zuoraEntityIds)
              .executeWithHttpInfo();
      System.out.println(response.getResponseBody());
      System.out.println(response.getResponseHeaders());
      System.out.println(response.getStatusCode());
      System.out.println(response.getRoundTripTime());
      System.out.println(response.getRequest());
    } catch (ApiException e) {
      System.err.println("Exception when calling ProductChargeDefinitionsApi#createProductChargeDefinitionBulk");
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
| **poSTChargeDefinitionRequestBulk** | [**POSTChargeDefinitionRequestBulk**](POSTChargeDefinitionRequestBulk.md)|  | |
| **idempotencyKey** | **String**| Specify a unique idempotency key if you want to perform an idempotent POST or PATCH request. Do not use this header in other request types.   With this header specified, the Zuora server can identify subsequent retries of the same request using this value, which prevents the same operation from being performed multiple times by accident.   | [optional] |
| **acceptEncoding** | **String**| Include the &#x60;Accept-Encoding: gzip&#x60; header to compress responses as a gzipped file. It can significantly reduce the bandwidth required for a response.   If specified, Zuora automatically compresses responses that contain over 1000 bytes of data, and the response contains a &#x60;Content-Encoding&#x60; header with the compression algorithm so that your client can decompress it.  | [optional] |
| **contentEncoding** | **String**| Include the &#x60;Content-Encoding: gzip&#x60; header to compress a request. With this header specified, you should upload a gzipped file for the request payload instead of sending the JSON payload.  | [optional] |
| **authorization** | **String**| The value is in the &#x60;Bearer {token}&#x60; format where {token} is a valid OAuth token generated by calling [Create an OAuth token](https://developer.zuora.com/api-references/api/operation/createToken).  | [optional] |
| **zuoraTrackId** | **String**| A custom identifier for tracing the API call. If you set a value for this header, Zuora returns the same value in the response headers. This header enables you to associate your system process identifiers with Zuora API calls, to assist with troubleshooting in the event of an issue.  The value of this field must use the US-ASCII character set and must not include any of the following characters: colon (&#x60;:&#x60;), semicolon (&#x60;;&#x60;), double quote (&#x60;\&quot;&#x60;), and quote (&#x60;&#39;&#x60;).  | [optional] |
| **zuoraEntityIds** | **String**| An entity ID. If you have [Zuora Multi-entity](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Multi-entity) enabled and the OAuth token is valid for more than one entity, you must use this header to specify which entity to perform the operation in. If the OAuth token is only valid for a single entity, or you do not have Zuora Multi-entity enabled, you do not need to set this header.  | [optional] |

### Return type

[**POSTChargeDefinitionBulkResponse**](POSTChargeDefinitionBulkResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** |  |  * Content-Encoding - This header is returned if you specify the &#x60;Accept-Encoding: gzip&#x60; request header and the response contains over 1000 bytes of data. Note that only the following MIME types support gzipped responses:   - &#x60;application/json&#x60;   - &#x60;application/xml&#x60;   - &#x60;text/html&#x60;   - &#x60;text/csv&#x60;   - &#x60;text/plain&#x60;  <br>  * RateLimit-Limit - The request limit quota for the time window closest to exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Remaining - The number of requests remaining in the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Reset - The number of seconds until the quota resets for the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Zuora-Request-Id - The Zuora internal identifier of the API call. You cannot control the value of this header.  <br>  * Zuora-Track-Id - A custom identifier for tracing the API call. If you specified a tracing identifier in the request headers, Zuora returns the same tracing identifier. Otherwise, Zuora does not set this header.  <br>  |

<a name="productChargeDefnition"></a>
# **productChargeDefnition**
> CommonResponse productChargeDefnition(productChargeDefinitionKey).acceptEncoding(acceptEncoding).contentEncoding(contentEncoding).authorization(authorization).zuoraTrackId(zuoraTrackId).zuoraEntityIds(zuoraEntityIds).execute();

Delete a product charge definition

Deletes a product charge definition.  **Note**: This operation requires the [Attribute-based Pricing](https://knowledgecenter.zuora.com/Zuora_Billing/Build_products_and_prices/Attribute_based_pricing/AA_Overview_of_Attribute-based_Pricing) feature to be enabled, which is in the **Early Adopter** phase.  

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Zuora;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.ProductChargeDefinitionsApi;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Example {
  public static void main(String[] args) {
    Configuration configuration = new Configuration();
    configuration.host = "https://rest.zuora.com";
    Zuora client = new Zuora(configuration);
    String productChargeDefinitionKey = "productChargeDefinitionKey_example"; // The unique number or ID of the product charge definition to be deleted. 
    String acceptEncoding = "acceptEncoding_example"; // Include the `Accept-Encoding: gzip` header to compress responses as a gzipped file. It can significantly reduce the bandwidth required for a response.   If specified, Zuora automatically compresses responses that contain over 1000 bytes of data, and the response contains a `Content-Encoding` header with the compression algorithm so that your client can decompress it. 
    String contentEncoding = "contentEncoding_example"; // Include the `Content-Encoding: gzip` header to compress a request. With this header specified, you should upload a gzipped file for the request payload instead of sending the JSON payload. 
    String authorization = "authorization_example"; // The value is in the `Bearer {token}` format where {token} is a valid OAuth token generated by calling [Create an OAuth token](https://developer.zuora.com/api-references/api/operation/createToken). 
    String zuoraTrackId = "zuoraTrackId_example"; // A custom identifier for tracing the API call. If you set a value for this header, Zuora returns the same value in the response headers. This header enables you to associate your system process identifiers with Zuora API calls, to assist with troubleshooting in the event of an issue.  The value of this field must use the US-ASCII character set and must not include any of the following characters: colon (`:`), semicolon (`;`), double quote (`\"`), and quote (`'`). 
    String zuoraEntityIds = "zuoraEntityIds_example"; // An entity ID. If you have [Zuora Multi-entity](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Multi-entity) enabled and the OAuth token is valid for more than one entity, you must use this header to specify which entity to perform the operation in. If the OAuth token is only valid for a single entity, or you do not have Zuora Multi-entity enabled, you do not need to set this header. 
    try {
      CommonResponse result = client
              .productChargeDefinitions
              .productChargeDefnition(productChargeDefinitionKey)
              .acceptEncoding(acceptEncoding)
              .contentEncoding(contentEncoding)
              .authorization(authorization)
              .zuoraTrackId(zuoraTrackId)
              .zuoraEntityIds(zuoraEntityIds)
              .execute();
      System.out.println(result);
      System.out.println(result.getProcessId());
      System.out.println(result.getReasons());
      System.out.println(result.getRequestId());
      System.out.println(result.getSuccess());
    } catch (ApiException e) {
      System.err.println("Exception when calling ProductChargeDefinitionsApi#productChargeDefnition");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<CommonResponse> response = client
              .productChargeDefinitions
              .productChargeDefnition(productChargeDefinitionKey)
              .acceptEncoding(acceptEncoding)
              .contentEncoding(contentEncoding)
              .authorization(authorization)
              .zuoraTrackId(zuoraTrackId)
              .zuoraEntityIds(zuoraEntityIds)
              .executeWithHttpInfo();
      System.out.println(response.getResponseBody());
      System.out.println(response.getResponseHeaders());
      System.out.println(response.getStatusCode());
      System.out.println(response.getRoundTripTime());
      System.out.println(response.getRequest());
    } catch (ApiException e) {
      System.err.println("Exception when calling ProductChargeDefinitionsApi#productChargeDefnition");
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
| **productChargeDefinitionKey** | **String**| The unique number or ID of the product charge definition to be deleted.  | |
| **acceptEncoding** | **String**| Include the &#x60;Accept-Encoding: gzip&#x60; header to compress responses as a gzipped file. It can significantly reduce the bandwidth required for a response.   If specified, Zuora automatically compresses responses that contain over 1000 bytes of data, and the response contains a &#x60;Content-Encoding&#x60; header with the compression algorithm so that your client can decompress it.  | [optional] |
| **contentEncoding** | **String**| Include the &#x60;Content-Encoding: gzip&#x60; header to compress a request. With this header specified, you should upload a gzipped file for the request payload instead of sending the JSON payload.  | [optional] |
| **authorization** | **String**| The value is in the &#x60;Bearer {token}&#x60; format where {token} is a valid OAuth token generated by calling [Create an OAuth token](https://developer.zuora.com/api-references/api/operation/createToken).  | [optional] |
| **zuoraTrackId** | **String**| A custom identifier for tracing the API call. If you set a value for this header, Zuora returns the same value in the response headers. This header enables you to associate your system process identifiers with Zuora API calls, to assist with troubleshooting in the event of an issue.  The value of this field must use the US-ASCII character set and must not include any of the following characters: colon (&#x60;:&#x60;), semicolon (&#x60;;&#x60;), double quote (&#x60;\&quot;&#x60;), and quote (&#x60;&#39;&#x60;).  | [optional] |
| **zuoraEntityIds** | **String**| An entity ID. If you have [Zuora Multi-entity](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Multi-entity) enabled and the OAuth token is valid for more than one entity, you must use this header to specify which entity to perform the operation in. If the OAuth token is only valid for a single entity, or you do not have Zuora Multi-entity enabled, you do not need to set this header.  | [optional] |

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

<a name="retrieveProductChargeDefinition"></a>
# **retrieveProductChargeDefinition**
> GETProductChargeDefinitionResponse retrieveProductChargeDefinition(productChargeDefinitionKey).acceptEncoding(acceptEncoding).contentEncoding(contentEncoding).authorization(authorization).zuoraTrackId(zuoraTrackId).zuoraEntityIds(zuoraEntityIds).hideInheritedValues(hideInheritedValues).execute();

Retrieve a product charge definition

Retrieves basic information about a product charge definition.  **Note**: This operation requires the [Attribute-based Pricing](https://knowledgecenter.zuora.com/Zuora_Billing/Build_products_and_prices/Attribute_based_pricing/AA_Overview_of_Attribute-based_Pricing) feature to be enabled, which is in the **Early Adopter** phase.  

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Zuora;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.ProductChargeDefinitionsApi;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Example {
  public static void main(String[] args) {
    Configuration configuration = new Configuration();
    configuration.host = "https://rest.zuora.com";
    Zuora client = new Zuora(configuration);
    String productChargeDefinitionKey = "productChargeDefinitionKey_example"; // The unique number or ID of the product charge definition to be retrieved. 
    String acceptEncoding = "acceptEncoding_example"; // Include the `Accept-Encoding: gzip` header to compress responses as a gzipped file. It can significantly reduce the bandwidth required for a response.   If specified, Zuora automatically compresses responses that contain over 1000 bytes of data, and the response contains a `Content-Encoding` header with the compression algorithm so that your client can decompress it. 
    String contentEncoding = "contentEncoding_example"; // Include the `Content-Encoding: gzip` header to compress a request. With this header specified, you should upload a gzipped file for the request payload instead of sending the JSON payload. 
    String authorization = "authorization_example"; // The value is in the `Bearer {token}` format where {token} is a valid OAuth token generated by calling [Create an OAuth token](https://developer.zuora.com/api-references/api/operation/createToken). 
    String zuoraTrackId = "zuoraTrackId_example"; // A custom identifier for tracing the API call. If you set a value for this header, Zuora returns the same value in the response headers. This header enables you to associate your system process identifiers with Zuora API calls, to assist with troubleshooting in the event of an issue.  The value of this field must use the US-ASCII character set and must not include any of the following characters: colon (`:`), semicolon (`;`), double quote (`\"`), and quote (`'`). 
    String zuoraEntityIds = "zuoraEntityIds_example"; // An entity ID. If you have [Zuora Multi-entity](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Multi-entity) enabled and the OAuth token is valid for more than one entity, you must use this header to specify which entity to perform the operation in. If the OAuth token is only valid for a single entity, or you do not have Zuora Multi-entity enabled, you do not need to set this header. 
    Boolean hideInheritedValues = true; // The flag that controls whether the response will merge the default charge definition fields for those fields that are not overridden. 
    try {
      GETProductChargeDefinitionResponse result = client
              .productChargeDefinitions
              .retrieveProductChargeDefinition(productChargeDefinitionKey)
              .acceptEncoding(acceptEncoding)
              .contentEncoding(contentEncoding)
              .authorization(authorization)
              .zuoraTrackId(zuoraTrackId)
              .zuoraEntityIds(zuoraEntityIds)
              .hideInheritedValues(hideInheritedValues)
              .execute();
      System.out.println(result);
      System.out.println(result.getDescription());
      System.out.println(result.getApplyDiscountTo());
      System.out.println(result.getBillingDay());
      System.out.println(result.getBillingPeriod());
      System.out.println(result.getBillingPeriodAlignment());
      System.out.println(result.getBillingTiming());
      System.out.println(result.getChargeModel());
      System.out.println(result.getChargeType());
      System.out.println(result.getCustomFields());
      System.out.println(result.getDefaultQuantity());
      System.out.println(result.getDeliverySchedule());
      System.out.println(result.getDiscountClass());
      System.out.println(result.getDiscountLevel());
      System.out.println(result.getEffectiveEndDate());
      System.out.println(result.getEffectiveStartDate());
      System.out.println(result.getEndDateCondition());
      System.out.println(result.getFinanceInformation());
      System.out.println(result.getIsDefault());
      System.out.println(result.getIsStackedDiscount());
      System.out.println(result.getNumberOfPeriods());
      System.out.println(result.getListPriceBase());
      System.out.println(result.getNumberOfPeriod());
      System.out.println(result.getOverageCalculationOption());
      System.out.println(result.getOverageUnusedUnitsCreditOption());
      System.out.println(result.getPriceChangeOption());
      System.out.println(result.getPriceIncreaseOption());
      System.out.println(result.getPriceIncreasePercentage());
      System.out.println(result.getPrices());
      System.out.println(result.getProductChargeDefinitionId());
      System.out.println(result.getProductChargeDefinitionNumber());
      System.out.println(result.getProductDiscountApplyDetails());
      System.out.println(result.getProductRatePlanChargeId());
      System.out.println(result.getProductRatePlanChargeNumber());
      System.out.println(result.getProductRatePlanId());
      System.out.println(result.getProductRatePlanName());
      System.out.println(result.getProductRatePlanNumber());
      System.out.println(result.getRatingGroup());
      System.out.println(result.getRecognizedRevenueAccount());
      System.out.println(result.getRevRecCode());
      System.out.println(result.getRevRecTriggerCondition());
      System.out.println(result.getRevenueRecognitionRuleName());
      System.out.println(result.getSmoothingModel());
      System.out.println(result.getSpecificBillingPeriod());
      System.out.println(result.getSpecificListPriceBase());
      System.out.println(result.getSuccess());
      System.out.println(result.getTaxCode());
      System.out.println(result.getTaxMode());
      System.out.println(result.getTaxable());
      System.out.println(result.getTerm());
      System.out.println(result.getTermPeriodType());
      System.out.println(result.getTermType());
      System.out.println(result.getTriggerEvent());
      System.out.println(result.getUom());
      System.out.println(result.getUpToPeriods());
      System.out.println(result.getUpToPeriodsType());
      System.out.println(result.getUsageRecordRatingOption());
      System.out.println(result.getUseDiscountSpecificAccountingCode());
      System.out.println(result.getUseTenantDefaultForPriceChange());
      System.out.println(result.getExcludeItemBillingFromRevenueAccounting());
      System.out.println(result.getExcludeItemBookingFromRevenueAccounting());
      System.out.println(result.getIsAllocationEligible());
      System.out.println(result.getIsUnbilled());
      System.out.println(result.getProductCategory());
      System.out.println(result.getProductClass());
      System.out.println(result.getProductFamily());
      System.out.println(result.getProductLine());
      System.out.println(result.getRevenueRecognitionTiming());
      System.out.println(result.getRevenueAmortizationMethod());
    } catch (ApiException e) {
      System.err.println("Exception when calling ProductChargeDefinitionsApi#retrieveProductChargeDefinition");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<GETProductChargeDefinitionResponse> response = client
              .productChargeDefinitions
              .retrieveProductChargeDefinition(productChargeDefinitionKey)
              .acceptEncoding(acceptEncoding)
              .contentEncoding(contentEncoding)
              .authorization(authorization)
              .zuoraTrackId(zuoraTrackId)
              .zuoraEntityIds(zuoraEntityIds)
              .hideInheritedValues(hideInheritedValues)
              .executeWithHttpInfo();
      System.out.println(response.getResponseBody());
      System.out.println(response.getResponseHeaders());
      System.out.println(response.getStatusCode());
      System.out.println(response.getRoundTripTime());
      System.out.println(response.getRequest());
    } catch (ApiException e) {
      System.err.println("Exception when calling ProductChargeDefinitionsApi#retrieveProductChargeDefinition");
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
| **productChargeDefinitionKey** | **String**| The unique number or ID of the product charge definition to be retrieved.  | |
| **acceptEncoding** | **String**| Include the &#x60;Accept-Encoding: gzip&#x60; header to compress responses as a gzipped file. It can significantly reduce the bandwidth required for a response.   If specified, Zuora automatically compresses responses that contain over 1000 bytes of data, and the response contains a &#x60;Content-Encoding&#x60; header with the compression algorithm so that your client can decompress it.  | [optional] |
| **contentEncoding** | **String**| Include the &#x60;Content-Encoding: gzip&#x60; header to compress a request. With this header specified, you should upload a gzipped file for the request payload instead of sending the JSON payload.  | [optional] |
| **authorization** | **String**| The value is in the &#x60;Bearer {token}&#x60; format where {token} is a valid OAuth token generated by calling [Create an OAuth token](https://developer.zuora.com/api-references/api/operation/createToken).  | [optional] |
| **zuoraTrackId** | **String**| A custom identifier for tracing the API call. If you set a value for this header, Zuora returns the same value in the response headers. This header enables you to associate your system process identifiers with Zuora API calls, to assist with troubleshooting in the event of an issue.  The value of this field must use the US-ASCII character set and must not include any of the following characters: colon (&#x60;:&#x60;), semicolon (&#x60;;&#x60;), double quote (&#x60;\&quot;&#x60;), and quote (&#x60;&#39;&#x60;).  | [optional] |
| **zuoraEntityIds** | **String**| An entity ID. If you have [Zuora Multi-entity](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Multi-entity) enabled and the OAuth token is valid for more than one entity, you must use this header to specify which entity to perform the operation in. If the OAuth token is only valid for a single entity, or you do not have Zuora Multi-entity enabled, you do not need to set this header.  | [optional] |
| **hideInheritedValues** | **Boolean**| The flag that controls whether the response will merge the default charge definition fields for those fields that are not overridden.  | [optional] |

### Return type

[**GETProductChargeDefinitionResponse**](GETProductChargeDefinitionResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** |  |  * Content-Encoding - This header is returned if you specify the &#x60;Accept-Encoding: gzip&#x60; request header and the response contains over 1000 bytes of data. Note that only the following MIME types support gzipped responses:   - &#x60;application/json&#x60;   - &#x60;application/xml&#x60;   - &#x60;text/html&#x60;   - &#x60;text/csv&#x60;   - &#x60;text/plain&#x60;  <br>  * RateLimit-Limit - The request limit quota for the time window closest to exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Remaining - The number of requests remaining in the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Reset - The number of seconds until the quota resets for the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Zuora-Request-Id - The Zuora internal identifier of the API call. You cannot control the value of this header.  <br>  * Zuora-Track-Id - A custom identifier for tracing the API call. If you specified a tracing identifier in the request headers, Zuora returns the same tracing identifier. Otherwise, Zuora does not set this header.  <br>  |

<a name="retrieveProductChargeDefinitions"></a>
# **retrieveProductChargeDefinitions**
> GETProductChargeDefinitionsResponse retrieveProductChargeDefinitions().acceptEncoding(acceptEncoding).contentEncoding(contentEncoding).authorization(authorization).zuoraTrackId(zuoraTrackId).zuoraEntityIds(zuoraEntityIds).charge(charge).rateplan(rateplan).hideInheritedValues(hideInheritedValues).execute();

List product charge definitions

Retrieves basic information about the product charge definitions.   **Note**: This operation requires the [Attribute-based Pricing](https://knowledgecenter.zuora.com/Zuora_Billing/Build_products_and_prices/Attribute_based_pricing/AA_Overview_of_Attribute-based_Pricing) feature to be enabled, which is in the **Early Adopter** phase.  

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Zuora;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.ProductChargeDefinitionsApi;
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
    String charge = "charge_example"; // The unique number or ID of the charge for which the product charge definitions are to be retrieved. 
    String rateplan = "rateplan_example"; // The unique number or ID of the product rate plan for which the product charge definitions are to be retrieved. 
    Boolean hideInheritedValues = true; // The flag that controls whether the response will merge the default charge definition fields for those fields that are not overridden. 
    try {
      GETProductChargeDefinitionsResponse result = client
              .productChargeDefinitions
              .retrieveProductChargeDefinitions()
              .acceptEncoding(acceptEncoding)
              .contentEncoding(contentEncoding)
              .authorization(authorization)
              .zuoraTrackId(zuoraTrackId)
              .zuoraEntityIds(zuoraEntityIds)
              .charge(charge)
              .rateplan(rateplan)
              .hideInheritedValues(hideInheritedValues)
              .execute();
      System.out.println(result);
      System.out.println(result.getChargeDefinitions());
      System.out.println(result.getSuccess());
    } catch (ApiException e) {
      System.err.println("Exception when calling ProductChargeDefinitionsApi#retrieveProductChargeDefinitions");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<GETProductChargeDefinitionsResponse> response = client
              .productChargeDefinitions
              .retrieveProductChargeDefinitions()
              .acceptEncoding(acceptEncoding)
              .contentEncoding(contentEncoding)
              .authorization(authorization)
              .zuoraTrackId(zuoraTrackId)
              .zuoraEntityIds(zuoraEntityIds)
              .charge(charge)
              .rateplan(rateplan)
              .hideInheritedValues(hideInheritedValues)
              .executeWithHttpInfo();
      System.out.println(response.getResponseBody());
      System.out.println(response.getResponseHeaders());
      System.out.println(response.getStatusCode());
      System.out.println(response.getRoundTripTime());
      System.out.println(response.getRequest());
    } catch (ApiException e) {
      System.err.println("Exception when calling ProductChargeDefinitionsApi#retrieveProductChargeDefinitions");
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
| **charge** | **String**| The unique number or ID of the charge for which the product charge definitions are to be retrieved.  | [optional] |
| **rateplan** | **String**| The unique number or ID of the product rate plan for which the product charge definitions are to be retrieved.  | [optional] |
| **hideInheritedValues** | **Boolean**| The flag that controls whether the response will merge the default charge definition fields for those fields that are not overridden.  | [optional] |

### Return type

[**GETProductChargeDefinitionsResponse**](GETProductChargeDefinitionsResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** |  |  * Content-Encoding - This header is returned if you specify the &#x60;Accept-Encoding: gzip&#x60; request header and the response contains over 1000 bytes of data. Note that only the following MIME types support gzipped responses:   - &#x60;application/json&#x60;   - &#x60;application/xml&#x60;   - &#x60;text/html&#x60;   - &#x60;text/csv&#x60;   - &#x60;text/plain&#x60;  <br>  * RateLimit-Limit - The request limit quota for the time window closest to exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Remaining - The number of requests remaining in the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Reset - The number of seconds until the quota resets for the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Zuora-Request-Id - The Zuora internal identifier of the API call. You cannot control the value of this header.  <br>  * Zuora-Track-Id - A custom identifier for tracing the API call. If you specified a tracing identifier in the request headers, Zuora returns the same tracing identifier. Otherwise, Zuora does not set this header.  <br>  |

<a name="updateProductChargeDefinition"></a>
# **updateProductChargeDefinition**
> GETProductChargeDefinitionResponse updateProductChargeDefinition(productChargeDefinitionKey, puTProductChargeDefinitionRequest).acceptEncoding(acceptEncoding).contentEncoding(contentEncoding).authorization(authorization).zuoraTrackId(zuoraTrackId).zuoraEntityIds(zuoraEntityIds).execute();

Update a product charge definition

Update a product charge definition.  **Note**: This operation requires the [Attribute-based Pricing](https://knowledgecenter.zuora.com/Zuora_Billing/Build_products_and_prices/Attribute_based_pricing/AA_Overview_of_Attribute-based_Pricing) feature to be enabled, which is in the **Early Adopter** phase.  

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Zuora;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.ProductChargeDefinitionsApi;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Example {
  public static void main(String[] args) {
    Configuration configuration = new Configuration();
    configuration.host = "https://rest.zuora.com";
    Zuora client = new Zuora(configuration);
    String productChargeDefinitionKey = "productChargeDefinitionKey_example"; // The unique number or ID of the product charge definition to be updated. 
    String billingPeriod = "billingPeriod_example"; // The override value of the billingPeriod for the product charge definition. 
    String billingTiming = "IN_ADVANCE"; // The override value of the billingTiming for the product charge definition. 
    String chargeModel = "DiscountFixedAmount"; // Determines how to calculate charges. Charge models must be individually activated in Zuora Billing administration. 
    Double defaultQuantity = 3.4D; // The default quantity.   This field is applicable only for one-time and recurring charges. 
    OffsetDateTime effectiveEndDate = OffsetDateTime.now(); // The effective end date of the product charge definition. 
    OffsetDateTime effectiveStartDate = OffsetDateTime.now(); // The effective start date of the product charge definition. 
    String listPriceBase = "Per_Billing_Period"; // The list price base.   This field is applicable only for recurring charges.  **Note**: The `Per_Year` enum value is available only if you have the <a href=\\\"https://knowledgecenter.zuora.com/Billing/Subscriptions/Product_Catalog/I_Annual_List_Price\\\" target=\\\"_blank\\\">Annual List Price</a> feature enabled. 
    List<POSTProductChargeDefinitionPricing> prices = Arrays.asList(); // Container for the new prices to override the existing prices of the product charge definition. 
    Double specificBillingPeriod = 3.4D; // The override value of the specificBillingPeriod for the product charge definition. 
    Integer specificListPriceBase = 56; // The number of months for the list price base of the charge definition.  The field is `null` if the `listPriceBase` field is not set to `Per_Specific_Months`. 
    String taxCode = "taxCode_example"; // Specifies the tax code for taxation rules. This field is equired when the `Taxable` field is set to `True`.  **Note**: This value affects the tax calculation of the charge. 
    String taxMode = "TaxExclusive"; // Determines how to define taxation for the charge. This field is equired when the `Taxable` field is set to `True`.  **Note**: This value affects the tax calculation of the charge. 
    Boolean taxable = true; // Determines whether the charge definition is taxable. When this field is set to `True`, the `TaxMode` and `TaxCode` fields are required.  **Character limit**: 5  **Values**: `True`, `False`  **Note**: This value affects the tax calculation of the charge. 
    Double term = 3.4D; // The number of periods of a termed subscription that is eligible for this charge definition. This field is applicable when the `termType` field is set to `TERMED`,  and is to be used together with the `termPeriodType` field. 
    String termPeriodType = "Month"; // Specifies the period type for the subscription term that is eligible for this charge definition. 
    String termType = "TERMED"; // The type of the subscription that is eligible for this charge definition. 
    String uom = "uom_example"; // Describes the unit of measure (UOM) configured in **Settings > Billing**.  **Values**: `Each`, `License`, `Seat`, or `null` 
    String acceptEncoding = "acceptEncoding_example"; // Include the `Accept-Encoding: gzip` header to compress responses as a gzipped file. It can significantly reduce the bandwidth required for a response.   If specified, Zuora automatically compresses responses that contain over 1000 bytes of data, and the response contains a `Content-Encoding` header with the compression algorithm so that your client can decompress it. 
    String contentEncoding = "contentEncoding_example"; // Include the `Content-Encoding: gzip` header to compress a request. With this header specified, you should upload a gzipped file for the request payload instead of sending the JSON payload. 
    String authorization = "authorization_example"; // The value is in the `Bearer {token}` format where {token} is a valid OAuth token generated by calling [Create an OAuth token](https://developer.zuora.com/api-references/api/operation/createToken). 
    String zuoraTrackId = "zuoraTrackId_example"; // A custom identifier for tracing the API call. If you set a value for this header, Zuora returns the same value in the response headers. This header enables you to associate your system process identifiers with Zuora API calls, to assist with troubleshooting in the event of an issue.  The value of this field must use the US-ASCII character set and must not include any of the following characters: colon (`:`), semicolon (`;`), double quote (`\"`), and quote (`'`). 
    String zuoraEntityIds = "zuoraEntityIds_example"; // An entity ID. If you have [Zuora Multi-entity](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Multi-entity) enabled and the OAuth token is valid for more than one entity, you must use this header to specify which entity to perform the operation in. If the OAuth token is only valid for a single entity, or you do not have Zuora Multi-entity enabled, you do not need to set this header. 
    try {
      GETProductChargeDefinitionResponse result = client
              .productChargeDefinitions
              .updateProductChargeDefinition(productChargeDefinitionKey)
              .billingPeriod(billingPeriod)
              .billingTiming(billingTiming)
              .chargeModel(chargeModel)
              .defaultQuantity(defaultQuantity)
              .effectiveEndDate(effectiveEndDate)
              .effectiveStartDate(effectiveStartDate)
              .listPriceBase(listPriceBase)
              .prices(prices)
              .specificBillingPeriod(specificBillingPeriod)
              .specificListPriceBase(specificListPriceBase)
              .taxCode(taxCode)
              .taxMode(taxMode)
              .taxable(taxable)
              .term(term)
              .termPeriodType(termPeriodType)
              .termType(termType)
              .uom(uom)
              .acceptEncoding(acceptEncoding)
              .contentEncoding(contentEncoding)
              .authorization(authorization)
              .zuoraTrackId(zuoraTrackId)
              .zuoraEntityIds(zuoraEntityIds)
              .execute();
      System.out.println(result);
      System.out.println(result.getDescription());
      System.out.println(result.getApplyDiscountTo());
      System.out.println(result.getBillingDay());
      System.out.println(result.getBillingPeriod());
      System.out.println(result.getBillingPeriodAlignment());
      System.out.println(result.getBillingTiming());
      System.out.println(result.getChargeModel());
      System.out.println(result.getChargeType());
      System.out.println(result.getCustomFields());
      System.out.println(result.getDefaultQuantity());
      System.out.println(result.getDeliverySchedule());
      System.out.println(result.getDiscountClass());
      System.out.println(result.getDiscountLevel());
      System.out.println(result.getEffectiveEndDate());
      System.out.println(result.getEffectiveStartDate());
      System.out.println(result.getEndDateCondition());
      System.out.println(result.getFinanceInformation());
      System.out.println(result.getIsDefault());
      System.out.println(result.getIsStackedDiscount());
      System.out.println(result.getNumberOfPeriods());
      System.out.println(result.getListPriceBase());
      System.out.println(result.getNumberOfPeriod());
      System.out.println(result.getOverageCalculationOption());
      System.out.println(result.getOverageUnusedUnitsCreditOption());
      System.out.println(result.getPriceChangeOption());
      System.out.println(result.getPriceIncreaseOption());
      System.out.println(result.getPriceIncreasePercentage());
      System.out.println(result.getPrices());
      System.out.println(result.getProductChargeDefinitionId());
      System.out.println(result.getProductChargeDefinitionNumber());
      System.out.println(result.getProductDiscountApplyDetails());
      System.out.println(result.getProductRatePlanChargeId());
      System.out.println(result.getProductRatePlanChargeNumber());
      System.out.println(result.getProductRatePlanId());
      System.out.println(result.getProductRatePlanName());
      System.out.println(result.getProductRatePlanNumber());
      System.out.println(result.getRatingGroup());
      System.out.println(result.getRecognizedRevenueAccount());
      System.out.println(result.getRevRecCode());
      System.out.println(result.getRevRecTriggerCondition());
      System.out.println(result.getRevenueRecognitionRuleName());
      System.out.println(result.getSmoothingModel());
      System.out.println(result.getSpecificBillingPeriod());
      System.out.println(result.getSpecificListPriceBase());
      System.out.println(result.getSuccess());
      System.out.println(result.getTaxCode());
      System.out.println(result.getTaxMode());
      System.out.println(result.getTaxable());
      System.out.println(result.getTerm());
      System.out.println(result.getTermPeriodType());
      System.out.println(result.getTermType());
      System.out.println(result.getTriggerEvent());
      System.out.println(result.getUom());
      System.out.println(result.getUpToPeriods());
      System.out.println(result.getUpToPeriodsType());
      System.out.println(result.getUsageRecordRatingOption());
      System.out.println(result.getUseDiscountSpecificAccountingCode());
      System.out.println(result.getUseTenantDefaultForPriceChange());
      System.out.println(result.getExcludeItemBillingFromRevenueAccounting());
      System.out.println(result.getExcludeItemBookingFromRevenueAccounting());
      System.out.println(result.getIsAllocationEligible());
      System.out.println(result.getIsUnbilled());
      System.out.println(result.getProductCategory());
      System.out.println(result.getProductClass());
      System.out.println(result.getProductFamily());
      System.out.println(result.getProductLine());
      System.out.println(result.getRevenueRecognitionTiming());
      System.out.println(result.getRevenueAmortizationMethod());
    } catch (ApiException e) {
      System.err.println("Exception when calling ProductChargeDefinitionsApi#updateProductChargeDefinition");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<GETProductChargeDefinitionResponse> response = client
              .productChargeDefinitions
              .updateProductChargeDefinition(productChargeDefinitionKey)
              .billingPeriod(billingPeriod)
              .billingTiming(billingTiming)
              .chargeModel(chargeModel)
              .defaultQuantity(defaultQuantity)
              .effectiveEndDate(effectiveEndDate)
              .effectiveStartDate(effectiveStartDate)
              .listPriceBase(listPriceBase)
              .prices(prices)
              .specificBillingPeriod(specificBillingPeriod)
              .specificListPriceBase(specificListPriceBase)
              .taxCode(taxCode)
              .taxMode(taxMode)
              .taxable(taxable)
              .term(term)
              .termPeriodType(termPeriodType)
              .termType(termType)
              .uom(uom)
              .acceptEncoding(acceptEncoding)
              .contentEncoding(contentEncoding)
              .authorization(authorization)
              .zuoraTrackId(zuoraTrackId)
              .zuoraEntityIds(zuoraEntityIds)
              .executeWithHttpInfo();
      System.out.println(response.getResponseBody());
      System.out.println(response.getResponseHeaders());
      System.out.println(response.getStatusCode());
      System.out.println(response.getRoundTripTime());
      System.out.println(response.getRequest());
    } catch (ApiException e) {
      System.err.println("Exception when calling ProductChargeDefinitionsApi#updateProductChargeDefinition");
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
| **productChargeDefinitionKey** | **String**| The unique number or ID of the product charge definition to be updated.  | |
| **puTProductChargeDefinitionRequest** | [**PUTProductChargeDefinitionRequest**](PUTProductChargeDefinitionRequest.md)|  | |
| **acceptEncoding** | **String**| Include the &#x60;Accept-Encoding: gzip&#x60; header to compress responses as a gzipped file. It can significantly reduce the bandwidth required for a response.   If specified, Zuora automatically compresses responses that contain over 1000 bytes of data, and the response contains a &#x60;Content-Encoding&#x60; header with the compression algorithm so that your client can decompress it.  | [optional] |
| **contentEncoding** | **String**| Include the &#x60;Content-Encoding: gzip&#x60; header to compress a request. With this header specified, you should upload a gzipped file for the request payload instead of sending the JSON payload.  | [optional] |
| **authorization** | **String**| The value is in the &#x60;Bearer {token}&#x60; format where {token} is a valid OAuth token generated by calling [Create an OAuth token](https://developer.zuora.com/api-references/api/operation/createToken).  | [optional] |
| **zuoraTrackId** | **String**| A custom identifier for tracing the API call. If you set a value for this header, Zuora returns the same value in the response headers. This header enables you to associate your system process identifiers with Zuora API calls, to assist with troubleshooting in the event of an issue.  The value of this field must use the US-ASCII character set and must not include any of the following characters: colon (&#x60;:&#x60;), semicolon (&#x60;;&#x60;), double quote (&#x60;\&quot;&#x60;), and quote (&#x60;&#39;&#x60;).  | [optional] |
| **zuoraEntityIds** | **String**| An entity ID. If you have [Zuora Multi-entity](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Multi-entity) enabled and the OAuth token is valid for more than one entity, you must use this header to specify which entity to perform the operation in. If the OAuth token is only valid for a single entity, or you do not have Zuora Multi-entity enabled, you do not need to set this header.  | [optional] |

### Return type

[**GETProductChargeDefinitionResponse**](GETProductChargeDefinitionResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** |  |  * Content-Encoding - This header is returned if you specify the &#x60;Accept-Encoding: gzip&#x60; request header and the response contains over 1000 bytes of data. Note that only the following MIME types support gzipped responses:   - &#x60;application/json&#x60;   - &#x60;application/xml&#x60;   - &#x60;text/html&#x60;   - &#x60;text/csv&#x60;   - &#x60;text/plain&#x60;  <br>  * RateLimit-Limit - The request limit quota for the time window closest to exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Remaining - The number of requests remaining in the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Reset - The number of seconds until the quota resets for the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Zuora-Request-Id - The Zuora internal identifier of the API call. You cannot control the value of this header.  <br>  * Zuora-Track-Id - A custom identifier for tracing the API call. If you specified a tracing identifier in the request headers, Zuora returns the same tracing identifier. Otherwise, Zuora does not set this header.  <br>  |

<a name="updateProductChargeDefinitionBulk"></a>
# **updateProductChargeDefinitionBulk**
> GETProductChargeDefinitionsResponse updateProductChargeDefinitionBulk(puTProductChargeDefinitionBulkRequest).acceptEncoding(acceptEncoding).contentEncoding(contentEncoding).authorization(authorization).zuoraTrackId(zuoraTrackId).zuoraEntityIds(zuoraEntityIds).execute();

Update product charge definitions

Bulk updates multiple product charge definitions.  **Note**: This operation requires the [Attribute-based Pricing](https://knowledgecenter.zuora.com/Zuora_Billing/Build_products_and_prices/Attribute_based_pricing/AA_Overview_of_Attribute-based_Pricing) feature to be enabled, which is in the **Early Adopter** phase.  

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Zuora;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.ProductChargeDefinitionsApi;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Example {
  public static void main(String[] args) {
    Configuration configuration = new Configuration();
    configuration.host = "https://rest.zuora.com";
    Zuora client = new Zuora(configuration);
    List<PUTBulkProductChargeDefinitionRequest> productChargeDefinitions = Arrays.asList(); // The list of updated product charge definitions. 
    String acceptEncoding = "acceptEncoding_example"; // Include the `Accept-Encoding: gzip` header to compress responses as a gzipped file. It can significantly reduce the bandwidth required for a response.   If specified, Zuora automatically compresses responses that contain over 1000 bytes of data, and the response contains a `Content-Encoding` header with the compression algorithm so that your client can decompress it. 
    String contentEncoding = "contentEncoding_example"; // Include the `Content-Encoding: gzip` header to compress a request. With this header specified, you should upload a gzipped file for the request payload instead of sending the JSON payload. 
    String authorization = "authorization_example"; // The value is in the `Bearer {token}` format where {token} is a valid OAuth token generated by calling [Create an OAuth token](https://developer.zuora.com/api-references/api/operation/createToken). 
    String zuoraTrackId = "zuoraTrackId_example"; // A custom identifier for tracing the API call. If you set a value for this header, Zuora returns the same value in the response headers. This header enables you to associate your system process identifiers with Zuora API calls, to assist with troubleshooting in the event of an issue.  The value of this field must use the US-ASCII character set and must not include any of the following characters: colon (`:`), semicolon (`;`), double quote (`\"`), and quote (`'`). 
    String zuoraEntityIds = "zuoraEntityIds_example"; // An entity ID. If you have [Zuora Multi-entity](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Multi-entity) enabled and the OAuth token is valid for more than one entity, you must use this header to specify which entity to perform the operation in. If the OAuth token is only valid for a single entity, or you do not have Zuora Multi-entity enabled, you do not need to set this header. 
    try {
      GETProductChargeDefinitionsResponse result = client
              .productChargeDefinitions
              .updateProductChargeDefinitionBulk()
              .productChargeDefinitions(productChargeDefinitions)
              .acceptEncoding(acceptEncoding)
              .contentEncoding(contentEncoding)
              .authorization(authorization)
              .zuoraTrackId(zuoraTrackId)
              .zuoraEntityIds(zuoraEntityIds)
              .execute();
      System.out.println(result);
      System.out.println(result.getChargeDefinitions());
      System.out.println(result.getSuccess());
    } catch (ApiException e) {
      System.err.println("Exception when calling ProductChargeDefinitionsApi#updateProductChargeDefinitionBulk");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<GETProductChargeDefinitionsResponse> response = client
              .productChargeDefinitions
              .updateProductChargeDefinitionBulk()
              .productChargeDefinitions(productChargeDefinitions)
              .acceptEncoding(acceptEncoding)
              .contentEncoding(contentEncoding)
              .authorization(authorization)
              .zuoraTrackId(zuoraTrackId)
              .zuoraEntityIds(zuoraEntityIds)
              .executeWithHttpInfo();
      System.out.println(response.getResponseBody());
      System.out.println(response.getResponseHeaders());
      System.out.println(response.getStatusCode());
      System.out.println(response.getRoundTripTime());
      System.out.println(response.getRequest());
    } catch (ApiException e) {
      System.err.println("Exception when calling ProductChargeDefinitionsApi#updateProductChargeDefinitionBulk");
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
| **puTProductChargeDefinitionBulkRequest** | [**PUTProductChargeDefinitionBulkRequest**](PUTProductChargeDefinitionBulkRequest.md)|  | |
| **acceptEncoding** | **String**| Include the &#x60;Accept-Encoding: gzip&#x60; header to compress responses as a gzipped file. It can significantly reduce the bandwidth required for a response.   If specified, Zuora automatically compresses responses that contain over 1000 bytes of data, and the response contains a &#x60;Content-Encoding&#x60; header with the compression algorithm so that your client can decompress it.  | [optional] |
| **contentEncoding** | **String**| Include the &#x60;Content-Encoding: gzip&#x60; header to compress a request. With this header specified, you should upload a gzipped file for the request payload instead of sending the JSON payload.  | [optional] |
| **authorization** | **String**| The value is in the &#x60;Bearer {token}&#x60; format where {token} is a valid OAuth token generated by calling [Create an OAuth token](https://developer.zuora.com/api-references/api/operation/createToken).  | [optional] |
| **zuoraTrackId** | **String**| A custom identifier for tracing the API call. If you set a value for this header, Zuora returns the same value in the response headers. This header enables you to associate your system process identifiers with Zuora API calls, to assist with troubleshooting in the event of an issue.  The value of this field must use the US-ASCII character set and must not include any of the following characters: colon (&#x60;:&#x60;), semicolon (&#x60;;&#x60;), double quote (&#x60;\&quot;&#x60;), and quote (&#x60;&#39;&#x60;).  | [optional] |
| **zuoraEntityIds** | **String**| An entity ID. If you have [Zuora Multi-entity](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Multi-entity) enabled and the OAuth token is valid for more than one entity, you must use this header to specify which entity to perform the operation in. If the OAuth token is only valid for a single entity, or you do not have Zuora Multi-entity enabled, you do not need to set this header.  | [optional] |

### Return type

[**GETProductChargeDefinitionsResponse**](GETProductChargeDefinitionsResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** |  |  * Content-Encoding - This header is returned if you specify the &#x60;Accept-Encoding: gzip&#x60; request header and the response contains over 1000 bytes of data. Note that only the following MIME types support gzipped responses:   - &#x60;application/json&#x60;   - &#x60;application/xml&#x60;   - &#x60;text/html&#x60;   - &#x60;text/csv&#x60;   - &#x60;text/plain&#x60;  <br>  * RateLimit-Limit - The request limit quota for the time window closest to exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Remaining - The number of requests remaining in the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Reset - The number of seconds until the quota resets for the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Zuora-Request-Id - The Zuora internal identifier of the API call. You cannot control the value of this header.  <br>  * Zuora-Track-Id - A custom identifier for tracing the API call. If you specified a tracing identifier in the request headers, Zuora returns the same tracing identifier. Otherwise, Zuora does not set this header.  <br>  |

