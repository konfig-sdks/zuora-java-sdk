# EInvoicingApi

All URIs are relative to *https://rest.zuora.com*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**createEInvoiceFileTemplate**](EInvoicingApi.md#createEInvoiceFileTemplate) | **POST** /v1/einvoice/templates | Create an e-invoice file template |
| [**createEInvoicingBusinessRegion**](EInvoicingApi.md#createEInvoicingBusinessRegion) | **POST** /v1/einvoice/business-regions | Create an e-invoicing business region |
| [**eInvoiceFileTemplate**](EInvoicingApi.md#eInvoiceFileTemplate) | **GET** /v1/einvoice/templates/{key} | Retrieve an e-invoice file template |
| [**eInvoiceFileTemplate_0**](EInvoicingApi.md#eInvoiceFileTemplate_0) | **PUT** /v1/einvoice/templates/{key} | Update an e-invoice file template |
| [**eInvoiceFileTemplate_1**](EInvoicingApi.md#eInvoiceFileTemplate_1) | **DELETE** /v1/einvoice/templates/{key} | Delete an e-invoice file template |
| [**eInvoiceFileTemplates**](EInvoicingApi.md#eInvoiceFileTemplates) | **GET** /v1/einvoice/templates | List e-invoice file templates |
| [**eInvoicingBusinessRegion**](EInvoicingApi.md#eInvoicingBusinessRegion) | **GET** /v1/einvoice/business-regions/{key} | Retrieve an e-invoicing business region |
| [**eInvoicingBusinessRegion_0**](EInvoicingApi.md#eInvoicingBusinessRegion_0) | **DELETE** /v1/einvoice/business-regions/{key} | Delete an e-invoicing business region |
| [**eInvoicingBusinessRegions**](EInvoicingApi.md#eInvoicingBusinessRegions) | **GET** /v1/einvoice/business-regions | List e-invoicing business regions |
| [**eInvoicingServiceProvider**](EInvoicingApi.md#eInvoicingServiceProvider) | **POST** /v1/einvoice/service-providers | Create an e-invoicing service provider |
| [**eInvoicingServiceProvider_0**](EInvoicingApi.md#eInvoicingServiceProvider_0) | **GET** /v1/einvoice/service-providers/{key} | Retrieve an e-invoicing service provider |
| [**eInvoicingServiceProvider_1**](EInvoicingApi.md#eInvoicingServiceProvider_1) | **DELETE** /v1/einvoice/service-providers/{key} | Delete an e-invoicing service provider |
| [**eInvoicingServiceProviders**](EInvoicingApi.md#eInvoicingServiceProviders) | **GET** /v1/einvoice/service-providers | List e-invoicing service providers |
| [**updateEInvoicingBusinessRegion**](EInvoicingApi.md#updateEInvoicingBusinessRegion) | **PUT** /v1/einvoice/business-regions/{key} | Update an e-invoicing business region |
| [**updateEInvoicingServiceProvider**](EInvoicingApi.md#updateEInvoicingServiceProvider) | **PUT** /v1/einvoice/service-providers/{key} | Update an e-invoicing service provider |


<a name="createEInvoiceFileTemplate"></a>
# **createEInvoiceFileTemplate**
> GetEInvoiceFileTemplateResponse createEInvoiceFileTemplate(createEInvoiceFileTemplateRequest).idempotencyKey(idempotencyKey).acceptEncoding(acceptEncoding).contentEncoding(contentEncoding).authorization(authorization).zuoraTrackId(zuoraTrackId).zuoraEntityIds(zuoraEntityIds).zuoraOrgIds(zuoraOrgIds).execute();

Create an e-invoice file template

Creates an e-invoice file templates for your billing documents, including invoices, credit memos, and debit memos.   Zuora provides default e-invoice file templates, so you can just customize them as needed. For example, some country specific fields like HSN (Harmonized System of Nomenclature) might be stored on product rate plan charges.  **Note**: This operation is available only if you have the &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Bill_your_customers/E-Invoicing\&quot; target&#x3D;\&quot;_blank\&quot;&gt;E-Invoicing&lt;/a&gt; feature in **Early Adopter** phase enabled. 

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Zuora;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.EInvoicingApi;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Example {
  public static void main(String[] args) {
    Configuration configuration = new Configuration();
    configuration.host = "https://rest.zuora.com";
    Zuora client = new Zuora(configuration);
    String content = "content_example"; // The content of the e-invoice file template, which must be encoded in Base64 format. 
    String country = "country_example"; // The short name of of a country or region where you must comply with e-invoicing requirements. For example, `IN` for India. For the full list of country names and codes, see <a href=\\\"https://knowledgecenter.zuora.com/Quick_References/Country%2C_State%2C_and_Province_Codes/A_Country_Names_and_Their_ISO_Codes\\\" target=\\\"_blank\\\">ISO Standard Country Codes</a>. 
    String documentType = "Invoice"; // The type of billing documents, which the e-invoice file template is intended for. 
    String name = "name_example"; // The name of the e-invoice file template. 
    String provider = "Sovos"; // The name of an e-invoicing service provider that assists in generating e-invoice files. 
    String idempotencyKey = "idempotencyKey_example"; // Specify a unique idempotency key if you want to perform an idempotent POST or PATCH request. Do not use this header in other request types.   With this header specified, the Zuora server can identify subsequent retries of the same request using this value, which prevents the same operation from being performed multiple times by accident.  
    String acceptEncoding = "acceptEncoding_example"; // Include the `Accept-Encoding: gzip` header to compress responses as a gzipped file. It can significantly reduce the bandwidth required for a response.   If specified, Zuora automatically compresses responses that contain over 1000 bytes of data, and the response contains a `Content-Encoding` header with the compression algorithm so that your client can decompress it. 
    String contentEncoding = "contentEncoding_example"; // Include the `Content-Encoding: gzip` header to compress a request. With this header specified, you should upload a gzipped file for the request payload instead of sending the JSON payload. 
    String authorization = "authorization_example"; // The value is in the `Bearer {token}` format where {token} is a valid OAuth token generated by calling [Create an OAuth token](https://developer.zuora.com/api-references/api/operation/createToken). 
    String zuoraTrackId = "zuoraTrackId_example"; // A custom identifier for tracing the API call. If you set a value for this header, Zuora returns the same value in the response headers. This header enables you to associate your system process identifiers with Zuora API calls, to assist with troubleshooting in the event of an issue.  The value of this field must use the US-ASCII character set and must not include any of the following characters: colon (`:`), semicolon (`;`), double quote (`\"`), and quote (`'`). 
    String zuoraEntityIds = "zuoraEntityIds_example"; // An entity ID. If you have [Zuora Multi-entity](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Multi-entity) enabled and the OAuth token is valid for more than one entity, you must use this header to specify which entity to perform the operation in. If the OAuth token is only valid for a single entity, or you do not have Zuora Multi-entity enabled, you do not need to set this header. 
    String zuoraOrgIds = "zuoraOrgIds_example"; // Comma separated IDs. If you have <a href=\"https://knowledgecenter.zuora.com/Zuora_Central_Platform/Multi-Org\" target=\"_blank\">Zuora Multi-Org</a> enabled,  you can use this header to specify which orgs to perform the operation in. If you do not have Zuora Multi-Org enabled, you should not set this header.  The IDs must be a sub-set of the user's accessible orgs. If you specify an org that the user does not have access to, the operation fails.  If the header is not set, the operation is performed in scope of the user's accessible orgs. 
    try {
      GetEInvoiceFileTemplateResponse result = client
              .eInvoicing
              .createEInvoiceFileTemplate()
              .content(content)
              .country(country)
              .documentType(documentType)
              .name(name)
              .provider(provider)
              .idempotencyKey(idempotencyKey)
              .acceptEncoding(acceptEncoding)
              .contentEncoding(contentEncoding)
              .authorization(authorization)
              .zuoraTrackId(zuoraTrackId)
              .zuoraEntityIds(zuoraEntityIds)
              .zuoraOrgIds(zuoraOrgIds)
              .execute();
      System.out.println(result);
      System.out.println(result.getContent());
      System.out.println(result.getCountry());
      System.out.println(result.getDocumentType());
      System.out.println(result.getId());
      System.out.println(result.getName());
      System.out.println(result.getProvider());
      System.out.println(result.getTemplateNumber());
    } catch (ApiException e) {
      System.err.println("Exception when calling EInvoicingApi#createEInvoiceFileTemplate");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<GetEInvoiceFileTemplateResponse> response = client
              .eInvoicing
              .createEInvoiceFileTemplate()
              .content(content)
              .country(country)
              .documentType(documentType)
              .name(name)
              .provider(provider)
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
      System.err.println("Exception when calling EInvoicingApi#createEInvoiceFileTemplate");
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
| **createEInvoiceFileTemplateRequest** | [**CreateEInvoiceFileTemplateRequest**](CreateEInvoiceFileTemplateRequest.md)|  | |
| **idempotencyKey** | **String**| Specify a unique idempotency key if you want to perform an idempotent POST or PATCH request. Do not use this header in other request types.   With this header specified, the Zuora server can identify subsequent retries of the same request using this value, which prevents the same operation from being performed multiple times by accident.   | [optional] |
| **acceptEncoding** | **String**| Include the &#x60;Accept-Encoding: gzip&#x60; header to compress responses as a gzipped file. It can significantly reduce the bandwidth required for a response.   If specified, Zuora automatically compresses responses that contain over 1000 bytes of data, and the response contains a &#x60;Content-Encoding&#x60; header with the compression algorithm so that your client can decompress it.  | [optional] |
| **contentEncoding** | **String**| Include the &#x60;Content-Encoding: gzip&#x60; header to compress a request. With this header specified, you should upload a gzipped file for the request payload instead of sending the JSON payload.  | [optional] |
| **authorization** | **String**| The value is in the &#x60;Bearer {token}&#x60; format where {token} is a valid OAuth token generated by calling [Create an OAuth token](https://developer.zuora.com/api-references/api/operation/createToken).  | [optional] |
| **zuoraTrackId** | **String**| A custom identifier for tracing the API call. If you set a value for this header, Zuora returns the same value in the response headers. This header enables you to associate your system process identifiers with Zuora API calls, to assist with troubleshooting in the event of an issue.  The value of this field must use the US-ASCII character set and must not include any of the following characters: colon (&#x60;:&#x60;), semicolon (&#x60;;&#x60;), double quote (&#x60;\&quot;&#x60;), and quote (&#x60;&#39;&#x60;).  | [optional] |
| **zuoraEntityIds** | **String**| An entity ID. If you have [Zuora Multi-entity](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Multi-entity) enabled and the OAuth token is valid for more than one entity, you must use this header to specify which entity to perform the operation in. If the OAuth token is only valid for a single entity, or you do not have Zuora Multi-entity enabled, you do not need to set this header.  | [optional] |
| **zuoraOrgIds** | **String**| Comma separated IDs. If you have &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Central_Platform/Multi-Org\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Zuora Multi-Org&lt;/a&gt; enabled,  you can use this header to specify which orgs to perform the operation in. If you do not have Zuora Multi-Org enabled, you should not set this header.  The IDs must be a sub-set of the user&#39;s accessible orgs. If you specify an org that the user does not have access to, the operation fails.  If the header is not set, the operation is performed in scope of the user&#39;s accessible orgs.  | [optional] |

### Return type

[**GetEInvoiceFileTemplateResponse**](GetEInvoiceFileTemplateResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** |  |  * Content-Encoding - This header is returned if you specify the &#x60;Accept-Encoding: gzip&#x60; request header and the response contains over 1000 bytes of data. Note that only the following MIME types support gzipped responses:   - &#x60;application/json&#x60;   - &#x60;application/xml&#x60;   - &#x60;text/html&#x60;   - &#x60;text/csv&#x60;   - &#x60;text/plain&#x60;  <br>  * RateLimit-Limit - The request limit quota for the time window closest to exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Remaining - The number of requests remaining in the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Reset - The number of seconds until the quota resets for the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Zuora-Request-Id - The Zuora internal identifier of the API call. You cannot control the value of this header.  <br>  * Zuora-Track-Id - A custom identifier for tracing the API call. If you specified a tracing identifier in the request headers, Zuora returns the same tracing identifier. Otherwise, Zuora does not set this header.  <br>  |

<a name="createEInvoicingBusinessRegion"></a>
# **createEInvoicingBusinessRegion**
> GetEInvoicingBusinessRegionResponse createEInvoicingBusinessRegion(createEInvoicingBusinessRegionRequest).idempotencyKey(idempotencyKey).acceptEncoding(acceptEncoding).contentEncoding(contentEncoding).authorization(authorization).zuoraTrackId(zuoraTrackId).zuoraEntityIds(zuoraEntityIds).zuoraOrgIds(zuoraOrgIds).execute();

Create an e-invoicing business region

Creates an e-invoicing business region.  You must create business regions to store the business detail information as a seller. If you have multiple GSTINs for different states, you can create multiple business region objects for India.  The business region objects can be looked up according to the country and state, and its related fields can be mapped accordingly within the e-invoice file template.  **Note**: This operation is available only if you have the &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Bill_your_customers/E-Invoicing\&quot; target&#x3D;\&quot;_blank\&quot;&gt;E-Invoicing&lt;/a&gt; feature in **Early Adopter** phase enabled. 

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Zuora;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.EInvoicingApi;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Example {
  public static void main(String[] args) {
    Configuration configuration = new Configuration();
    configuration.host = "https://rest.zuora.com";
    Zuora client = new Zuora(configuration);
    String addressLine1 = "addressLine1_example"; // The first line of the Seller’s address, which is often a street address or business name. 
    String addressLine2 = "addressLine2_example"; // The second line of the Seller’s address, which is often the name of a building. 
    String businessName = "businessName_example"; // The full official name that the Seller is registered with the relevant legal authority. 
    String businessNumber = "businessNumber_example"; // The specify the unique identifier number of the legal entity or person that you do business with.  For example, you must use a GSTIN for India and Tax Identification Number (TIN) for Saudi Arabia. 
    String businessNumberSchemaId = "businessNumberSchemaId_example"; // The identification scheme identifier that an official registrar issues to identify the Seller as a legal entity or person. 
    String city = "city_example"; // The the name of the city where the business is located. 
    String contactName = "contactName_example"; // The name of the Seller contact to receive e-invoicing data. 
    String country = "country_example"; // The short name of a country or region where you must comply with e-invoicing requirements. For example, `IN` for India. For the full list of country names and codes, see <a href=\\\"https://knowledgecenter.zuora.com/Quick_References/Country%2C_State%2C_and_Province_Codes/A_Country_Names_and_Their_ISO_Codes\\\" target=\\\"_blank\\\">ISO Standard Country Codes</a>. 
    Boolean digitalSignatureEnable = false; // Whether the e-invoicing service provider signs PDF files for billing documents. 
    Boolean digitalSignatureBoxEnable = false; // Whether the digital signature box is displayed on PDF files for billing documents. 
    Double digitalSignatureBoxPosX = 3.4D; // The X-coordinate to determine where the digital signature box is displayed on PDF files for billing documents. 
    Double digitalSignatureBoxPosY = 3.4D; // The Y-coordinate to determine where the digital signature box is displayed on PDF files for billing documents.  
    String email = "email_example"; // The email address of the Seller contact to receive e-invoicing data. 
    String endpointId = "endpointId_example"; // The Seller's electronic address, to which the application-level response to the e-invoice file might be delivered. 
    String endpointSchemeId = "endpointSchemeId_example"; // The identification scheme identifier of the Seller’s electronic address. 
    String phoneNumber = "phoneNumber_example"; // The business phone number of the Seller contact to receive e-invoicing data. 
    String postalCode = "postalCode_example"; // The short code that can identify the business address. 
    String serviceProviderId = "serviceProviderId_example"; // The unique ID of the e-invoicing service provider that is associated to the business region. 
    String state = "state_example"; // The name of the state or province where the business is located. 
    String taxRegisterNumber = "taxRegisterNumber_example"; // The Seller's VAT identifier (also known as Seller VAT identification number) or the local identification (defined by the Seller’s address) of the Seller for tax purposes, or a reference that enables the Seller to state the registered tax status. 
    String tradeName = "tradeName_example"; // The name that the Seller is known as, other than the legal business name. 
    String idempotencyKey = "idempotencyKey_example"; // Specify a unique idempotency key if you want to perform an idempotent POST or PATCH request. Do not use this header in other request types.   With this header specified, the Zuora server can identify subsequent retries of the same request using this value, which prevents the same operation from being performed multiple times by accident.  
    String acceptEncoding = "acceptEncoding_example"; // Include the `Accept-Encoding: gzip` header to compress responses as a gzipped file. It can significantly reduce the bandwidth required for a response.   If specified, Zuora automatically compresses responses that contain over 1000 bytes of data, and the response contains a `Content-Encoding` header with the compression algorithm so that your client can decompress it. 
    String contentEncoding = "contentEncoding_example"; // Include the `Content-Encoding: gzip` header to compress a request. With this header specified, you should upload a gzipped file for the request payload instead of sending the JSON payload. 
    String authorization = "authorization_example"; // The value is in the `Bearer {token}` format where {token} is a valid OAuth token generated by calling [Create an OAuth token](https://developer.zuora.com/api-references/api/operation/createToken). 
    String zuoraTrackId = "zuoraTrackId_example"; // A custom identifier for tracing the API call. If you set a value for this header, Zuora returns the same value in the response headers. This header enables you to associate your system process identifiers with Zuora API calls, to assist with troubleshooting in the event of an issue.  The value of this field must use the US-ASCII character set and must not include any of the following characters: colon (`:`), semicolon (`;`), double quote (`\"`), and quote (`'`). 
    String zuoraEntityIds = "zuoraEntityIds_example"; // An entity ID. If you have [Zuora Multi-entity](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Multi-entity) enabled and the OAuth token is valid for more than one entity, you must use this header to specify which entity to perform the operation in. If the OAuth token is only valid for a single entity, or you do not have Zuora Multi-entity enabled, you do not need to set this header. 
    String zuoraOrgIds = "zuoraOrgIds_example"; // Comma separated IDs. If you have <a href=\"https://knowledgecenter.zuora.com/Zuora_Central_Platform/Multi-Org\" target=\"_blank\">Zuora Multi-Org</a> enabled,  you can use this header to specify which orgs to perform the operation in. If you do not have Zuora Multi-Org enabled, you should not set this header.  The IDs must be a sub-set of the user's accessible orgs. If you specify an org that the user does not have access to, the operation fails.  If the header is not set, the operation is performed in scope of the user's accessible orgs. 
    try {
      GetEInvoicingBusinessRegionResponse result = client
              .eInvoicing
              .createEInvoicingBusinessRegion()
              .addressLine1(addressLine1)
              .addressLine2(addressLine2)
              .businessName(businessName)
              .businessNumber(businessNumber)
              .businessNumberSchemaId(businessNumberSchemaId)
              .city(city)
              .contactName(contactName)
              .country(country)
              .digitalSignatureEnable(digitalSignatureEnable)
              .digitalSignatureBoxEnable(digitalSignatureBoxEnable)
              .digitalSignatureBoxPosX(digitalSignatureBoxPosX)
              .digitalSignatureBoxPosY(digitalSignatureBoxPosY)
              .email(email)
              .endpointId(endpointId)
              .endpointSchemeId(endpointSchemeId)
              .phoneNumber(phoneNumber)
              .postalCode(postalCode)
              .serviceProviderId(serviceProviderId)
              .state(state)
              .taxRegisterNumber(taxRegisterNumber)
              .tradeName(tradeName)
              .idempotencyKey(idempotencyKey)
              .acceptEncoding(acceptEncoding)
              .contentEncoding(contentEncoding)
              .authorization(authorization)
              .zuoraTrackId(zuoraTrackId)
              .zuoraEntityIds(zuoraEntityIds)
              .zuoraOrgIds(zuoraOrgIds)
              .execute();
      System.out.println(result);
      System.out.println(result.getAddressLine1());
      System.out.println(result.getAddressLine2());
      System.out.println(result.getBusinessName());
      System.out.println(result.getBusinessNumber());
      System.out.println(result.getBusinessNumberSchemaId());
      System.out.println(result.getBusinessRegionNumber());
      System.out.println(result.getCity());
      System.out.println(result.getContactName());
      System.out.println(result.getCountry());
      System.out.println(result.getDigitalSignatureEnable());
      System.out.println(result.getDigitalSignatureBoxEnable());
      System.out.println(result.getDigitalSignatureBoxPosX());
      System.out.println(result.getDigitalSignatureBoxPosY());
      System.out.println(result.getEmail());
      System.out.println(result.getEndpointId());
      System.out.println(result.getEndpointSchemeId());
      System.out.println(result.getId());
      System.out.println(result.getSuccess());
      System.out.println(result.getPhoneNumber());
      System.out.println(result.getPostalCode());
      System.out.println(result.getServiceProviderId());
      System.out.println(result.getState());
      System.out.println(result.getTaxRegisterNumber());
      System.out.println(result.getTradeName());
    } catch (ApiException e) {
      System.err.println("Exception when calling EInvoicingApi#createEInvoicingBusinessRegion");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<GetEInvoicingBusinessRegionResponse> response = client
              .eInvoicing
              .createEInvoicingBusinessRegion()
              .addressLine1(addressLine1)
              .addressLine2(addressLine2)
              .businessName(businessName)
              .businessNumber(businessNumber)
              .businessNumberSchemaId(businessNumberSchemaId)
              .city(city)
              .contactName(contactName)
              .country(country)
              .digitalSignatureEnable(digitalSignatureEnable)
              .digitalSignatureBoxEnable(digitalSignatureBoxEnable)
              .digitalSignatureBoxPosX(digitalSignatureBoxPosX)
              .digitalSignatureBoxPosY(digitalSignatureBoxPosY)
              .email(email)
              .endpointId(endpointId)
              .endpointSchemeId(endpointSchemeId)
              .phoneNumber(phoneNumber)
              .postalCode(postalCode)
              .serviceProviderId(serviceProviderId)
              .state(state)
              .taxRegisterNumber(taxRegisterNumber)
              .tradeName(tradeName)
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
      System.err.println("Exception when calling EInvoicingApi#createEInvoicingBusinessRegion");
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
| **createEInvoicingBusinessRegionRequest** | [**CreateEInvoicingBusinessRegionRequest**](CreateEInvoicingBusinessRegionRequest.md)|  | |
| **idempotencyKey** | **String**| Specify a unique idempotency key if you want to perform an idempotent POST or PATCH request. Do not use this header in other request types.   With this header specified, the Zuora server can identify subsequent retries of the same request using this value, which prevents the same operation from being performed multiple times by accident.   | [optional] |
| **acceptEncoding** | **String**| Include the &#x60;Accept-Encoding: gzip&#x60; header to compress responses as a gzipped file. It can significantly reduce the bandwidth required for a response.   If specified, Zuora automatically compresses responses that contain over 1000 bytes of data, and the response contains a &#x60;Content-Encoding&#x60; header with the compression algorithm so that your client can decompress it.  | [optional] |
| **contentEncoding** | **String**| Include the &#x60;Content-Encoding: gzip&#x60; header to compress a request. With this header specified, you should upload a gzipped file for the request payload instead of sending the JSON payload.  | [optional] |
| **authorization** | **String**| The value is in the &#x60;Bearer {token}&#x60; format where {token} is a valid OAuth token generated by calling [Create an OAuth token](https://developer.zuora.com/api-references/api/operation/createToken).  | [optional] |
| **zuoraTrackId** | **String**| A custom identifier for tracing the API call. If you set a value for this header, Zuora returns the same value in the response headers. This header enables you to associate your system process identifiers with Zuora API calls, to assist with troubleshooting in the event of an issue.  The value of this field must use the US-ASCII character set and must not include any of the following characters: colon (&#x60;:&#x60;), semicolon (&#x60;;&#x60;), double quote (&#x60;\&quot;&#x60;), and quote (&#x60;&#39;&#x60;).  | [optional] |
| **zuoraEntityIds** | **String**| An entity ID. If you have [Zuora Multi-entity](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Multi-entity) enabled and the OAuth token is valid for more than one entity, you must use this header to specify which entity to perform the operation in. If the OAuth token is only valid for a single entity, or you do not have Zuora Multi-entity enabled, you do not need to set this header.  | [optional] |
| **zuoraOrgIds** | **String**| Comma separated IDs. If you have &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Central_Platform/Multi-Org\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Zuora Multi-Org&lt;/a&gt; enabled,  you can use this header to specify which orgs to perform the operation in. If you do not have Zuora Multi-Org enabled, you should not set this header.  The IDs must be a sub-set of the user&#39;s accessible orgs. If you specify an org that the user does not have access to, the operation fails.  If the header is not set, the operation is performed in scope of the user&#39;s accessible orgs.  | [optional] |

### Return type

[**GetEInvoicingBusinessRegionResponse**](GetEInvoicingBusinessRegionResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** |  |  * Content-Encoding - This header is returned if you specify the &#x60;Accept-Encoding: gzip&#x60; request header and the response contains over 1000 bytes of data. Note that only the following MIME types support gzipped responses:   - &#x60;application/json&#x60;   - &#x60;application/xml&#x60;   - &#x60;text/html&#x60;   - &#x60;text/csv&#x60;   - &#x60;text/plain&#x60;  <br>  * RateLimit-Limit - The request limit quota for the time window closest to exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Remaining - The number of requests remaining in the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Reset - The number of seconds until the quota resets for the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Zuora-Request-Id - The Zuora internal identifier of the API call. You cannot control the value of this header.  <br>  * Zuora-Track-Id - A custom identifier for tracing the API call. If you specified a tracing identifier in the request headers, Zuora returns the same tracing identifier. Otherwise, Zuora does not set this header.  <br>  |

<a name="eInvoiceFileTemplate"></a>
# **eInvoiceFileTemplate**
> GetEInvoiceFileTemplateResponse eInvoiceFileTemplate(key).acceptEncoding(acceptEncoding).contentEncoding(contentEncoding).authorization(authorization).zuoraTrackId(zuoraTrackId).zuoraEntityIds(zuoraEntityIds).zuoraOrgIds(zuoraOrgIds).execute();

Retrieve an e-invoice file template

Retrieves information about an e-invoice file template.  **Note**: This operation is available only if you have the &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Bill_your_customers/E-Invoicing\&quot; target&#x3D;\&quot;_blank\&quot;&gt;E-Invoicing&lt;/a&gt; feature in **Early Adopter** phase enabled. 

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Zuora;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.EInvoicingApi;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Example {
  public static void main(String[] args) {
    Configuration configuration = new Configuration();
    configuration.host = "https://rest.zuora.com";
    Zuora client = new Zuora(configuration);
    String key = "key_example"; // The unique number or ID of the e-invoice file template that you want to retrieve information about. 
    String acceptEncoding = "acceptEncoding_example"; // Include the `Accept-Encoding: gzip` header to compress responses as a gzipped file. It can significantly reduce the bandwidth required for a response.   If specified, Zuora automatically compresses responses that contain over 1000 bytes of data, and the response contains a `Content-Encoding` header with the compression algorithm so that your client can decompress it. 
    String contentEncoding = "contentEncoding_example"; // Include the `Content-Encoding: gzip` header to compress a request. With this header specified, you should upload a gzipped file for the request payload instead of sending the JSON payload. 
    String authorization = "authorization_example"; // The value is in the `Bearer {token}` format where {token} is a valid OAuth token generated by calling [Create an OAuth token](https://developer.zuora.com/api-references/api/operation/createToken). 
    String zuoraTrackId = "zuoraTrackId_example"; // A custom identifier for tracing the API call. If you set a value for this header, Zuora returns the same value in the response headers. This header enables you to associate your system process identifiers with Zuora API calls, to assist with troubleshooting in the event of an issue.  The value of this field must use the US-ASCII character set and must not include any of the following characters: colon (`:`), semicolon (`;`), double quote (`\"`), and quote (`'`). 
    String zuoraEntityIds = "zuoraEntityIds_example"; // An entity ID. If you have [Zuora Multi-entity](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Multi-entity) enabled and the OAuth token is valid for more than one entity, you must use this header to specify which entity to perform the operation in. If the OAuth token is only valid for a single entity, or you do not have Zuora Multi-entity enabled, you do not need to set this header. 
    String zuoraOrgIds = "zuoraOrgIds_example"; // Comma separated IDs. If you have <a href=\"https://knowledgecenter.zuora.com/Zuora_Central_Platform/Multi-Org\" target=\"_blank\">Zuora Multi-Org</a> enabled,  you can use this header to specify which orgs to perform the operation in. If you do not have Zuora Multi-Org enabled, you should not set this header.  The IDs must be a sub-set of the user's accessible orgs. If you specify an org that the user does not have access to, the operation fails.  If the header is not set, the operation is performed in scope of the user's accessible orgs. 
    try {
      GetEInvoiceFileTemplateResponse result = client
              .eInvoicing
              .eInvoiceFileTemplate(key)
              .acceptEncoding(acceptEncoding)
              .contentEncoding(contentEncoding)
              .authorization(authorization)
              .zuoraTrackId(zuoraTrackId)
              .zuoraEntityIds(zuoraEntityIds)
              .zuoraOrgIds(zuoraOrgIds)
              .execute();
      System.out.println(result);
      System.out.println(result.getContent());
      System.out.println(result.getCountry());
      System.out.println(result.getDocumentType());
      System.out.println(result.getId());
      System.out.println(result.getName());
      System.out.println(result.getProvider());
      System.out.println(result.getTemplateNumber());
    } catch (ApiException e) {
      System.err.println("Exception when calling EInvoicingApi#eInvoiceFileTemplate");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<GetEInvoiceFileTemplateResponse> response = client
              .eInvoicing
              .eInvoiceFileTemplate(key)
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
      System.err.println("Exception when calling EInvoicingApi#eInvoiceFileTemplate");
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
| **key** | **String**| The unique number or ID of the e-invoice file template that you want to retrieve information about.  | |
| **acceptEncoding** | **String**| Include the &#x60;Accept-Encoding: gzip&#x60; header to compress responses as a gzipped file. It can significantly reduce the bandwidth required for a response.   If specified, Zuora automatically compresses responses that contain over 1000 bytes of data, and the response contains a &#x60;Content-Encoding&#x60; header with the compression algorithm so that your client can decompress it.  | [optional] |
| **contentEncoding** | **String**| Include the &#x60;Content-Encoding: gzip&#x60; header to compress a request. With this header specified, you should upload a gzipped file for the request payload instead of sending the JSON payload.  | [optional] |
| **authorization** | **String**| The value is in the &#x60;Bearer {token}&#x60; format where {token} is a valid OAuth token generated by calling [Create an OAuth token](https://developer.zuora.com/api-references/api/operation/createToken).  | [optional] |
| **zuoraTrackId** | **String**| A custom identifier for tracing the API call. If you set a value for this header, Zuora returns the same value in the response headers. This header enables you to associate your system process identifiers with Zuora API calls, to assist with troubleshooting in the event of an issue.  The value of this field must use the US-ASCII character set and must not include any of the following characters: colon (&#x60;:&#x60;), semicolon (&#x60;;&#x60;), double quote (&#x60;\&quot;&#x60;), and quote (&#x60;&#39;&#x60;).  | [optional] |
| **zuoraEntityIds** | **String**| An entity ID. If you have [Zuora Multi-entity](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Multi-entity) enabled and the OAuth token is valid for more than one entity, you must use this header to specify which entity to perform the operation in. If the OAuth token is only valid for a single entity, or you do not have Zuora Multi-entity enabled, you do not need to set this header.  | [optional] |
| **zuoraOrgIds** | **String**| Comma separated IDs. If you have &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Central_Platform/Multi-Org\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Zuora Multi-Org&lt;/a&gt; enabled,  you can use this header to specify which orgs to perform the operation in. If you do not have Zuora Multi-Org enabled, you should not set this header.  The IDs must be a sub-set of the user&#39;s accessible orgs. If you specify an org that the user does not have access to, the operation fails.  If the header is not set, the operation is performed in scope of the user&#39;s accessible orgs.  | [optional] |

### Return type

[**GetEInvoiceFileTemplateResponse**](GetEInvoiceFileTemplateResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** |  |  * Content-Encoding - This header is returned if you specify the &#x60;Accept-Encoding: gzip&#x60; request header and the response contains over 1000 bytes of data. Note that only the following MIME types support gzipped responses:   - &#x60;application/json&#x60;   - &#x60;application/xml&#x60;   - &#x60;text/html&#x60;   - &#x60;text/csv&#x60;   - &#x60;text/plain&#x60;  <br>  * RateLimit-Limit - The request limit quota for the time window closest to exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Remaining - The number of requests remaining in the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Reset - The number of seconds until the quota resets for the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Zuora-Request-Id - The Zuora internal identifier of the API call. You cannot control the value of this header.  <br>  * Zuora-Track-Id - A custom identifier for tracing the API call. If you specified a tracing identifier in the request headers, Zuora returns the same tracing identifier. Otherwise, Zuora does not set this header.  <br>  |

<a name="eInvoiceFileTemplate_0"></a>
# **eInvoiceFileTemplate_0**
> GetEInvoiceFileTemplateResponse eInvoiceFileTemplate_0(key, updateEInvoiceFileTemplateRequest).acceptEncoding(acceptEncoding).contentEncoding(contentEncoding).authorization(authorization).zuoraTrackId(zuoraTrackId).zuoraEntityIds(zuoraEntityIds).zuoraOrgIds(zuoraOrgIds).execute();

Update an e-invoice file template

Updates information about an e-invoice file template.  **Note**: This operation is available only if you have the &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Bill_your_customers/E-Invoicing\&quot; target&#x3D;\&quot;_blank\&quot;&gt;E-Invoicing&lt;/a&gt; feature in **Early Adopter** phase enabled. 

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Zuora;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.EInvoicingApi;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Example {
  public static void main(String[] args) {
    Configuration configuration = new Configuration();
    configuration.host = "https://rest.zuora.com";
    Zuora client = new Zuora(configuration);
    String key = "key_example"; // The unique number or ID of the e-invoice file template that you want to update. 
    String content = "content_example"; // The content of the e-invoice file template, which must be encoded in Base64 format. 
    String country = "country_example"; // The short name of of a country or region where you must comply with e-invoicing requirements. For example, `IN` for India. For the full list of country names and codes, see <a href=\\\"https://knowledgecenter.zuora.com/Quick_References/Country%2C_State%2C_and_Province_Codes/A_Country_Names_and_Their_ISO_Codes\\\" target=\\\"_blank\\\">ISO Standard Country Codes</a>. 
    String documentType = "Invoice"; // The type of billing documents, which the e-invoice file template is intended for. 
    String name = "name_example"; // The name of the e-invoice file template. 
    String provider = "Sovos"; // The name of an e-invoicing service provider that assists in generating e-invoice files. 
    String acceptEncoding = "acceptEncoding_example"; // Include the `Accept-Encoding: gzip` header to compress responses as a gzipped file. It can significantly reduce the bandwidth required for a response.   If specified, Zuora automatically compresses responses that contain over 1000 bytes of data, and the response contains a `Content-Encoding` header with the compression algorithm so that your client can decompress it. 
    String contentEncoding = "contentEncoding_example"; // Include the `Content-Encoding: gzip` header to compress a request. With this header specified, you should upload a gzipped file for the request payload instead of sending the JSON payload. 
    String authorization = "authorization_example"; // The value is in the `Bearer {token}` format where {token} is a valid OAuth token generated by calling [Create an OAuth token](https://developer.zuora.com/api-references/api/operation/createToken). 
    String zuoraTrackId = "zuoraTrackId_example"; // A custom identifier for tracing the API call. If you set a value for this header, Zuora returns the same value in the response headers. This header enables you to associate your system process identifiers with Zuora API calls, to assist with troubleshooting in the event of an issue.  The value of this field must use the US-ASCII character set and must not include any of the following characters: colon (`:`), semicolon (`;`), double quote (`\"`), and quote (`'`). 
    String zuoraEntityIds = "zuoraEntityIds_example"; // An entity ID. If you have [Zuora Multi-entity](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Multi-entity) enabled and the OAuth token is valid for more than one entity, you must use this header to specify which entity to perform the operation in. If the OAuth token is only valid for a single entity, or you do not have Zuora Multi-entity enabled, you do not need to set this header. 
    String zuoraOrgIds = "zuoraOrgIds_example"; // Comma separated IDs. If you have <a href=\"https://knowledgecenter.zuora.com/Zuora_Central_Platform/Multi-Org\" target=\"_blank\">Zuora Multi-Org</a> enabled,  you can use this header to specify which orgs to perform the operation in. If you do not have Zuora Multi-Org enabled, you should not set this header.  The IDs must be a sub-set of the user's accessible orgs. If you specify an org that the user does not have access to, the operation fails.  If the header is not set, the operation is performed in scope of the user's accessible orgs. 
    try {
      GetEInvoiceFileTemplateResponse result = client
              .eInvoicing
              .eInvoiceFileTemplate_0(key)
              .content(content)
              .country(country)
              .documentType(documentType)
              .name(name)
              .provider(provider)
              .acceptEncoding(acceptEncoding)
              .contentEncoding(contentEncoding)
              .authorization(authorization)
              .zuoraTrackId(zuoraTrackId)
              .zuoraEntityIds(zuoraEntityIds)
              .zuoraOrgIds(zuoraOrgIds)
              .execute();
      System.out.println(result);
      System.out.println(result.getContent());
      System.out.println(result.getCountry());
      System.out.println(result.getDocumentType());
      System.out.println(result.getId());
      System.out.println(result.getName());
      System.out.println(result.getProvider());
      System.out.println(result.getTemplateNumber());
    } catch (ApiException e) {
      System.err.println("Exception when calling EInvoicingApi#eInvoiceFileTemplate_0");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<GetEInvoiceFileTemplateResponse> response = client
              .eInvoicing
              .eInvoiceFileTemplate_0(key)
              .content(content)
              .country(country)
              .documentType(documentType)
              .name(name)
              .provider(provider)
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
      System.err.println("Exception when calling EInvoicingApi#eInvoiceFileTemplate_0");
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
| **key** | **String**| The unique number or ID of the e-invoice file template that you want to update.  | |
| **updateEInvoiceFileTemplateRequest** | [**UpdateEInvoiceFileTemplateRequest**](UpdateEInvoiceFileTemplateRequest.md)|  | |
| **acceptEncoding** | **String**| Include the &#x60;Accept-Encoding: gzip&#x60; header to compress responses as a gzipped file. It can significantly reduce the bandwidth required for a response.   If specified, Zuora automatically compresses responses that contain over 1000 bytes of data, and the response contains a &#x60;Content-Encoding&#x60; header with the compression algorithm so that your client can decompress it.  | [optional] |
| **contentEncoding** | **String**| Include the &#x60;Content-Encoding: gzip&#x60; header to compress a request. With this header specified, you should upload a gzipped file for the request payload instead of sending the JSON payload.  | [optional] |
| **authorization** | **String**| The value is in the &#x60;Bearer {token}&#x60; format where {token} is a valid OAuth token generated by calling [Create an OAuth token](https://developer.zuora.com/api-references/api/operation/createToken).  | [optional] |
| **zuoraTrackId** | **String**| A custom identifier for tracing the API call. If you set a value for this header, Zuora returns the same value in the response headers. This header enables you to associate your system process identifiers with Zuora API calls, to assist with troubleshooting in the event of an issue.  The value of this field must use the US-ASCII character set and must not include any of the following characters: colon (&#x60;:&#x60;), semicolon (&#x60;;&#x60;), double quote (&#x60;\&quot;&#x60;), and quote (&#x60;&#39;&#x60;).  | [optional] |
| **zuoraEntityIds** | **String**| An entity ID. If you have [Zuora Multi-entity](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Multi-entity) enabled and the OAuth token is valid for more than one entity, you must use this header to specify which entity to perform the operation in. If the OAuth token is only valid for a single entity, or you do not have Zuora Multi-entity enabled, you do not need to set this header.  | [optional] |
| **zuoraOrgIds** | **String**| Comma separated IDs. If you have &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Central_Platform/Multi-Org\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Zuora Multi-Org&lt;/a&gt; enabled,  you can use this header to specify which orgs to perform the operation in. If you do not have Zuora Multi-Org enabled, you should not set this header.  The IDs must be a sub-set of the user&#39;s accessible orgs. If you specify an org that the user does not have access to, the operation fails.  If the header is not set, the operation is performed in scope of the user&#39;s accessible orgs.  | [optional] |

### Return type

[**GetEInvoiceFileTemplateResponse**](GetEInvoiceFileTemplateResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** |  |  * Content-Encoding - This header is returned if you specify the &#x60;Accept-Encoding: gzip&#x60; request header and the response contains over 1000 bytes of data. Note that only the following MIME types support gzipped responses:   - &#x60;application/json&#x60;   - &#x60;application/xml&#x60;   - &#x60;text/html&#x60;   - &#x60;text/csv&#x60;   - &#x60;text/plain&#x60;  <br>  * RateLimit-Limit - The request limit quota for the time window closest to exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Remaining - The number of requests remaining in the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Reset - The number of seconds until the quota resets for the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Zuora-Request-Id - The Zuora internal identifier of the API call. You cannot control the value of this header.  <br>  * Zuora-Track-Id - A custom identifier for tracing the API call. If you specified a tracing identifier in the request headers, Zuora returns the same tracing identifier. Otherwise, Zuora does not set this header.  <br>  |

<a name="eInvoiceFileTemplate_1"></a>
# **eInvoiceFileTemplate_1**
> CommonResponse eInvoiceFileTemplate_1(key).acceptEncoding(acceptEncoding).contentEncoding(contentEncoding).authorization(authorization).zuoraTrackId(zuoraTrackId).zuoraEntityIds(zuoraEntityIds).zuoraOrgIds(zuoraOrgIds).execute();

Delete an e-invoice file template

Deletes an e-invoice file template by key. The key can be the unique ID or number of an e-invoice file template.  **Note**: This operation is available only if you have the &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Bill_your_customers/E-Invoicing\&quot; target&#x3D;\&quot;_blank\&quot;&gt;E-Invoicing&lt;/a&gt; feature in **Early Adopter** phase enabled. 

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Zuora;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.EInvoicingApi;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Example {
  public static void main(String[] args) {
    Configuration configuration = new Configuration();
    configuration.host = "https://rest.zuora.com";
    Zuora client = new Zuora(configuration);
    String key = "key_example"; // The unique ID or number of the e-invoice file template that you want to delete. 
    String acceptEncoding = "acceptEncoding_example"; // Include the `Accept-Encoding: gzip` header to compress responses as a gzipped file. It can significantly reduce the bandwidth required for a response.   If specified, Zuora automatically compresses responses that contain over 1000 bytes of data, and the response contains a `Content-Encoding` header with the compression algorithm so that your client can decompress it. 
    String contentEncoding = "contentEncoding_example"; // Include the `Content-Encoding: gzip` header to compress a request. With this header specified, you should upload a gzipped file for the request payload instead of sending the JSON payload. 
    String authorization = "authorization_example"; // The value is in the `Bearer {token}` format where {token} is a valid OAuth token generated by calling [Create an OAuth token](https://developer.zuora.com/api-references/api/operation/createToken). 
    String zuoraTrackId = "zuoraTrackId_example"; // A custom identifier for tracing the API call. If you set a value for this header, Zuora returns the same value in the response headers. This header enables you to associate your system process identifiers with Zuora API calls, to assist with troubleshooting in the event of an issue.  The value of this field must use the US-ASCII character set and must not include any of the following characters: colon (`:`), semicolon (`;`), double quote (`\"`), and quote (`'`). 
    String zuoraEntityIds = "zuoraEntityIds_example"; // An entity ID. If you have [Zuora Multi-entity](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Multi-entity) enabled and the OAuth token is valid for more than one entity, you must use this header to specify which entity to perform the operation in. If the OAuth token is only valid for a single entity, or you do not have Zuora Multi-entity enabled, you do not need to set this header. 
    String zuoraOrgIds = "zuoraOrgIds_example"; // Comma separated IDs. If you have <a href=\"https://knowledgecenter.zuora.com/Zuora_Central_Platform/Multi-Org\" target=\"_blank\">Zuora Multi-Org</a> enabled,  you can use this header to specify which orgs to perform the operation in. If you do not have Zuora Multi-Org enabled, you should not set this header.  The IDs must be a sub-set of the user's accessible orgs. If you specify an org that the user does not have access to, the operation fails.  If the header is not set, the operation is performed in scope of the user's accessible orgs. 
    try {
      CommonResponse result = client
              .eInvoicing
              .eInvoiceFileTemplate_1(key)
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
      System.err.println("Exception when calling EInvoicingApi#eInvoiceFileTemplate_1");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<CommonResponse> response = client
              .eInvoicing
              .eInvoiceFileTemplate_1(key)
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
      System.err.println("Exception when calling EInvoicingApi#eInvoiceFileTemplate_1");
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
| **key** | **String**| The unique ID or number of the e-invoice file template that you want to delete.  | |
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

<a name="eInvoiceFileTemplates"></a>
# **eInvoiceFileTemplates**
> ListEInvoiceFileTemplatesResponse eInvoiceFileTemplates(country, documentType, provider).acceptEncoding(acceptEncoding).contentEncoding(contentEncoding).authorization(authorization).zuoraTrackId(zuoraTrackId).zuoraEntityIds(zuoraEntityIds).zuoraOrgIds(zuoraOrgIds).execute();

List e-invoice file templates

Lists information about e-invoice file templates.  You can query e-invoice file templates by conditions. For example, if your service provider is Sovos, you can use the following example URL to retrieve information about a list of e-invoice file templates for invoices in India: &#x60;/v1/einvoice/templates?country&#x3D;IN&amp;documentType&#x3D;Invoice&amp;provider&#x3D;Sovos&#x60;  **Note**: This operation is available only if you have the &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Bill_your_customers/E-Invoicing\&quot; target&#x3D;\&quot;_blank\&quot;&gt;E-Invoicing&lt;/a&gt; feature in **Early Adopter** phase enabled. 

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Zuora;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.EInvoicingApi;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Example {
  public static void main(String[] args) {
    Configuration configuration = new Configuration();
    configuration.host = "https://rest.zuora.com";
    Zuora client = new Zuora(configuration);
    String country = "country_example"; // The short name of a country or region where you must comply with e-invoicing requirements. For example, `IN` for India. For the full list of country names and codes, see <a href=\"https://knowledgecenter.zuora.com/Quick_References/Country%2C_State%2C_and_Province_Codes/A_Country_Names_and_Their_ISO_Codes\" target=\"_blank\">ISO Standard Country Codes</a>. 
    String documentType = "Invoice"; // The type of billing documents for which the e-invoice file template is intended. 
    String provider = "provider_example"; // The name of the e-invoicing service provider that assists in generating e-invoice files.  
    String acceptEncoding = "acceptEncoding_example"; // Include the `Accept-Encoding: gzip` header to compress responses as a gzipped file. It can significantly reduce the bandwidth required for a response.   If specified, Zuora automatically compresses responses that contain over 1000 bytes of data, and the response contains a `Content-Encoding` header with the compression algorithm so that your client can decompress it. 
    String contentEncoding = "contentEncoding_example"; // Include the `Content-Encoding: gzip` header to compress a request. With this header specified, you should upload a gzipped file for the request payload instead of sending the JSON payload. 
    String authorization = "authorization_example"; // The value is in the `Bearer {token}` format where {token} is a valid OAuth token generated by calling [Create an OAuth token](https://developer.zuora.com/api-references/api/operation/createToken). 
    String zuoraTrackId = "zuoraTrackId_example"; // A custom identifier for tracing the API call. If you set a value for this header, Zuora returns the same value in the response headers. This header enables you to associate your system process identifiers with Zuora API calls, to assist with troubleshooting in the event of an issue.  The value of this field must use the US-ASCII character set and must not include any of the following characters: colon (`:`), semicolon (`;`), double quote (`\"`), and quote (`'`). 
    String zuoraEntityIds = "zuoraEntityIds_example"; // An entity ID. If you have [Zuora Multi-entity](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Multi-entity) enabled and the OAuth token is valid for more than one entity, you must use this header to specify which entity to perform the operation in. If the OAuth token is only valid for a single entity, or you do not have Zuora Multi-entity enabled, you do not need to set this header. 
    String zuoraOrgIds = "zuoraOrgIds_example"; // Comma separated IDs. If you have <a href=\"https://knowledgecenter.zuora.com/Zuora_Central_Platform/Multi-Org\" target=\"_blank\">Zuora Multi-Org</a> enabled,  you can use this header to specify which orgs to perform the operation in. If you do not have Zuora Multi-Org enabled, you should not set this header.  The IDs must be a sub-set of the user's accessible orgs. If you specify an org that the user does not have access to, the operation fails.  If the header is not set, the operation is performed in scope of the user's accessible orgs. 
    try {
      ListEInvoiceFileTemplatesResponse result = client
              .eInvoicing
              .eInvoiceFileTemplates(country, documentType, provider)
              .acceptEncoding(acceptEncoding)
              .contentEncoding(contentEncoding)
              .authorization(authorization)
              .zuoraTrackId(zuoraTrackId)
              .zuoraEntityIds(zuoraEntityIds)
              .zuoraOrgIds(zuoraOrgIds)
              .execute();
      System.out.println(result);
      System.out.println(result.getSuccess());
      System.out.println(result.getTemplates());
    } catch (ApiException e) {
      System.err.println("Exception when calling EInvoicingApi#eInvoiceFileTemplates");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<ListEInvoiceFileTemplatesResponse> response = client
              .eInvoicing
              .eInvoiceFileTemplates(country, documentType, provider)
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
      System.err.println("Exception when calling EInvoicingApi#eInvoiceFileTemplates");
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
| **country** | **String**| The short name of a country or region where you must comply with e-invoicing requirements. For example, &#x60;IN&#x60; for India. For the full list of country names and codes, see &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Quick_References/Country%2C_State%2C_and_Province_Codes/A_Country_Names_and_Their_ISO_Codes\&quot; target&#x3D;\&quot;_blank\&quot;&gt;ISO Standard Country Codes&lt;/a&gt;.  | |
| **documentType** | **String**| The type of billing documents for which the e-invoice file template is intended.  | [enum: Invoice, CreditMemo, DebitMemo] |
| **provider** | **String**| The name of the e-invoicing service provider that assists in generating e-invoice files.   | |
| **acceptEncoding** | **String**| Include the &#x60;Accept-Encoding: gzip&#x60; header to compress responses as a gzipped file. It can significantly reduce the bandwidth required for a response.   If specified, Zuora automatically compresses responses that contain over 1000 bytes of data, and the response contains a &#x60;Content-Encoding&#x60; header with the compression algorithm so that your client can decompress it.  | [optional] |
| **contentEncoding** | **String**| Include the &#x60;Content-Encoding: gzip&#x60; header to compress a request. With this header specified, you should upload a gzipped file for the request payload instead of sending the JSON payload.  | [optional] |
| **authorization** | **String**| The value is in the &#x60;Bearer {token}&#x60; format where {token} is a valid OAuth token generated by calling [Create an OAuth token](https://developer.zuora.com/api-references/api/operation/createToken).  | [optional] |
| **zuoraTrackId** | **String**| A custom identifier for tracing the API call. If you set a value for this header, Zuora returns the same value in the response headers. This header enables you to associate your system process identifiers with Zuora API calls, to assist with troubleshooting in the event of an issue.  The value of this field must use the US-ASCII character set and must not include any of the following characters: colon (&#x60;:&#x60;), semicolon (&#x60;;&#x60;), double quote (&#x60;\&quot;&#x60;), and quote (&#x60;&#39;&#x60;).  | [optional] |
| **zuoraEntityIds** | **String**| An entity ID. If you have [Zuora Multi-entity](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Multi-entity) enabled and the OAuth token is valid for more than one entity, you must use this header to specify which entity to perform the operation in. If the OAuth token is only valid for a single entity, or you do not have Zuora Multi-entity enabled, you do not need to set this header.  | [optional] |
| **zuoraOrgIds** | **String**| Comma separated IDs. If you have &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Central_Platform/Multi-Org\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Zuora Multi-Org&lt;/a&gt; enabled,  you can use this header to specify which orgs to perform the operation in. If you do not have Zuora Multi-Org enabled, you should not set this header.  The IDs must be a sub-set of the user&#39;s accessible orgs. If you specify an org that the user does not have access to, the operation fails.  If the header is not set, the operation is performed in scope of the user&#39;s accessible orgs.  | [optional] |

### Return type

[**ListEInvoiceFileTemplatesResponse**](ListEInvoiceFileTemplatesResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** |  |  * Content-Encoding - This header is returned if you specify the &#x60;Accept-Encoding: gzip&#x60; request header and the response contains over 1000 bytes of data. Note that only the following MIME types support gzipped responses:   - &#x60;application/json&#x60;   - &#x60;application/xml&#x60;   - &#x60;text/html&#x60;   - &#x60;text/csv&#x60;   - &#x60;text/plain&#x60;  <br>  * RateLimit-Limit - The request limit quota for the time window closest to exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Remaining - The number of requests remaining in the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Reset - The number of seconds until the quota resets for the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Zuora-Request-Id - The Zuora internal identifier of the API call. You cannot control the value of this header.  <br>  * Zuora-Track-Id - A custom identifier for tracing the API call. If you specified a tracing identifier in the request headers, Zuora returns the same tracing identifier. Otherwise, Zuora does not set this header.  <br>  |

<a name="eInvoicingBusinessRegion"></a>
# **eInvoicingBusinessRegion**
> GetEInvoicingBusinessRegionResponse eInvoicingBusinessRegion(key).acceptEncoding(acceptEncoding).contentEncoding(contentEncoding).authorization(authorization).zuoraTrackId(zuoraTrackId).zuoraEntityIds(zuoraEntityIds).zuoraOrgIds(zuoraOrgIds).execute();

Retrieve an e-invoicing business region

Retrieves information about an e-invoicing business region.  You can search for an e-invoicing business region by key. The key can be the unique ID or number of an e-invoicing business region.  **Note**: This operation is available only if you have the &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Bill_your_customers/E-Invoicing\&quot; target&#x3D;\&quot;_blank\&quot;&gt;E-Invoicing&lt;/a&gt; feature in **Early Adopter** phase enabled. 

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Zuora;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.EInvoicingApi;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Example {
  public static void main(String[] args) {
    Configuration configuration = new Configuration();
    configuration.host = "https://rest.zuora.com";
    Zuora client = new Zuora(configuration);
    String key = "key_example"; // The unqiue ID or number of the e-invoicing business region that you want to retrieve information about. 
    String acceptEncoding = "acceptEncoding_example"; // Include the `Accept-Encoding: gzip` header to compress responses as a gzipped file. It can significantly reduce the bandwidth required for a response.   If specified, Zuora automatically compresses responses that contain over 1000 bytes of data, and the response contains a `Content-Encoding` header with the compression algorithm so that your client can decompress it. 
    String contentEncoding = "contentEncoding_example"; // Include the `Content-Encoding: gzip` header to compress a request. With this header specified, you should upload a gzipped file for the request payload instead of sending the JSON payload. 
    String authorization = "authorization_example"; // The value is in the `Bearer {token}` format where {token} is a valid OAuth token generated by calling [Create an OAuth token](https://developer.zuora.com/api-references/api/operation/createToken). 
    String zuoraTrackId = "zuoraTrackId_example"; // A custom identifier for tracing the API call. If you set a value for this header, Zuora returns the same value in the response headers. This header enables you to associate your system process identifiers with Zuora API calls, to assist with troubleshooting in the event of an issue.  The value of this field must use the US-ASCII character set and must not include any of the following characters: colon (`:`), semicolon (`;`), double quote (`\"`), and quote (`'`). 
    String zuoraEntityIds = "zuoraEntityIds_example"; // An entity ID. If you have [Zuora Multi-entity](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Multi-entity) enabled and the OAuth token is valid for more than one entity, you must use this header to specify which entity to perform the operation in. If the OAuth token is only valid for a single entity, or you do not have Zuora Multi-entity enabled, you do not need to set this header. 
    String zuoraOrgIds = "zuoraOrgIds_example"; // Comma separated IDs. If you have <a href=\"https://knowledgecenter.zuora.com/Zuora_Central_Platform/Multi-Org\" target=\"_blank\">Zuora Multi-Org</a> enabled,  you can use this header to specify which orgs to perform the operation in. If you do not have Zuora Multi-Org enabled, you should not set this header.  The IDs must be a sub-set of the user's accessible orgs. If you specify an org that the user does not have access to, the operation fails.  If the header is not set, the operation is performed in scope of the user's accessible orgs. 
    try {
      GetEInvoicingBusinessRegionResponse result = client
              .eInvoicing
              .eInvoicingBusinessRegion(key)
              .acceptEncoding(acceptEncoding)
              .contentEncoding(contentEncoding)
              .authorization(authorization)
              .zuoraTrackId(zuoraTrackId)
              .zuoraEntityIds(zuoraEntityIds)
              .zuoraOrgIds(zuoraOrgIds)
              .execute();
      System.out.println(result);
      System.out.println(result.getAddressLine1());
      System.out.println(result.getAddressLine2());
      System.out.println(result.getBusinessName());
      System.out.println(result.getBusinessNumber());
      System.out.println(result.getBusinessNumberSchemaId());
      System.out.println(result.getBusinessRegionNumber());
      System.out.println(result.getCity());
      System.out.println(result.getContactName());
      System.out.println(result.getCountry());
      System.out.println(result.getDigitalSignatureEnable());
      System.out.println(result.getDigitalSignatureBoxEnable());
      System.out.println(result.getDigitalSignatureBoxPosX());
      System.out.println(result.getDigitalSignatureBoxPosY());
      System.out.println(result.getEmail());
      System.out.println(result.getEndpointId());
      System.out.println(result.getEndpointSchemeId());
      System.out.println(result.getId());
      System.out.println(result.getSuccess());
      System.out.println(result.getPhoneNumber());
      System.out.println(result.getPostalCode());
      System.out.println(result.getServiceProviderId());
      System.out.println(result.getState());
      System.out.println(result.getTaxRegisterNumber());
      System.out.println(result.getTradeName());
    } catch (ApiException e) {
      System.err.println("Exception when calling EInvoicingApi#eInvoicingBusinessRegion");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<GetEInvoicingBusinessRegionResponse> response = client
              .eInvoicing
              .eInvoicingBusinessRegion(key)
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
      System.err.println("Exception when calling EInvoicingApi#eInvoicingBusinessRegion");
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
| **key** | **String**| The unqiue ID or number of the e-invoicing business region that you want to retrieve information about.  | |
| **acceptEncoding** | **String**| Include the &#x60;Accept-Encoding: gzip&#x60; header to compress responses as a gzipped file. It can significantly reduce the bandwidth required for a response.   If specified, Zuora automatically compresses responses that contain over 1000 bytes of data, and the response contains a &#x60;Content-Encoding&#x60; header with the compression algorithm so that your client can decompress it.  | [optional] |
| **contentEncoding** | **String**| Include the &#x60;Content-Encoding: gzip&#x60; header to compress a request. With this header specified, you should upload a gzipped file for the request payload instead of sending the JSON payload.  | [optional] |
| **authorization** | **String**| The value is in the &#x60;Bearer {token}&#x60; format where {token} is a valid OAuth token generated by calling [Create an OAuth token](https://developer.zuora.com/api-references/api/operation/createToken).  | [optional] |
| **zuoraTrackId** | **String**| A custom identifier for tracing the API call. If you set a value for this header, Zuora returns the same value in the response headers. This header enables you to associate your system process identifiers with Zuora API calls, to assist with troubleshooting in the event of an issue.  The value of this field must use the US-ASCII character set and must not include any of the following characters: colon (&#x60;:&#x60;), semicolon (&#x60;;&#x60;), double quote (&#x60;\&quot;&#x60;), and quote (&#x60;&#39;&#x60;).  | [optional] |
| **zuoraEntityIds** | **String**| An entity ID. If you have [Zuora Multi-entity](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Multi-entity) enabled and the OAuth token is valid for more than one entity, you must use this header to specify which entity to perform the operation in. If the OAuth token is only valid for a single entity, or you do not have Zuora Multi-entity enabled, you do not need to set this header.  | [optional] |
| **zuoraOrgIds** | **String**| Comma separated IDs. If you have &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Central_Platform/Multi-Org\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Zuora Multi-Org&lt;/a&gt; enabled,  you can use this header to specify which orgs to perform the operation in. If you do not have Zuora Multi-Org enabled, you should not set this header.  The IDs must be a sub-set of the user&#39;s accessible orgs. If you specify an org that the user does not have access to, the operation fails.  If the header is not set, the operation is performed in scope of the user&#39;s accessible orgs.  | [optional] |

### Return type

[**GetEInvoicingBusinessRegionResponse**](GetEInvoicingBusinessRegionResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** |  |  * Content-Encoding - This header is returned if you specify the &#x60;Accept-Encoding: gzip&#x60; request header and the response contains over 1000 bytes of data. Note that only the following MIME types support gzipped responses:   - &#x60;application/json&#x60;   - &#x60;application/xml&#x60;   - &#x60;text/html&#x60;   - &#x60;text/csv&#x60;   - &#x60;text/plain&#x60;  <br>  * RateLimit-Limit - The request limit quota for the time window closest to exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Remaining - The number of requests remaining in the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Reset - The number of seconds until the quota resets for the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Zuora-Request-Id - The Zuora internal identifier of the API call. You cannot control the value of this header.  <br>  * Zuora-Track-Id - A custom identifier for tracing the API call. If you specified a tracing identifier in the request headers, Zuora returns the same tracing identifier. Otherwise, Zuora does not set this header.  <br>  |

<a name="eInvoicingBusinessRegion_0"></a>
# **eInvoicingBusinessRegion_0**
> CommonResponse eInvoicingBusinessRegion_0(key).acceptEncoding(acceptEncoding).contentEncoding(contentEncoding).authorization(authorization).zuoraTrackId(zuoraTrackId).zuoraEntityIds(zuoraEntityIds).zuoraOrgIds(zuoraOrgIds).execute();

Delete an e-invoicing business region

Deletes an e-invoicing business region by key. The key can be the unique ID or number of an e-invoicing business region.  **Note**: This operation is available only if you have the &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Bill_your_customers/E-Invoicing\&quot; target&#x3D;\&quot;_blank\&quot;&gt;E-Invoicing&lt;/a&gt; feature in **Early Adopter** phase enabled. 

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Zuora;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.EInvoicingApi;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Example {
  public static void main(String[] args) {
    Configuration configuration = new Configuration();
    configuration.host = "https://rest.zuora.com";
    Zuora client = new Zuora(configuration);
    String key = "key_example"; // The unqiue ID or number of the e-invoicing business region that you want to delete. 
    String acceptEncoding = "acceptEncoding_example"; // Include the `Accept-Encoding: gzip` header to compress responses as a gzipped file. It can significantly reduce the bandwidth required for a response.   If specified, Zuora automatically compresses responses that contain over 1000 bytes of data, and the response contains a `Content-Encoding` header with the compression algorithm so that your client can decompress it. 
    String contentEncoding = "contentEncoding_example"; // Include the `Content-Encoding: gzip` header to compress a request. With this header specified, you should upload a gzipped file for the request payload instead of sending the JSON payload. 
    String authorization = "authorization_example"; // The value is in the `Bearer {token}` format where {token} is a valid OAuth token generated by calling [Create an OAuth token](https://developer.zuora.com/api-references/api/operation/createToken). 
    String zuoraTrackId = "zuoraTrackId_example"; // A custom identifier for tracing the API call. If you set a value for this header, Zuora returns the same value in the response headers. This header enables you to associate your system process identifiers with Zuora API calls, to assist with troubleshooting in the event of an issue.  The value of this field must use the US-ASCII character set and must not include any of the following characters: colon (`:`), semicolon (`;`), double quote (`\"`), and quote (`'`). 
    String zuoraEntityIds = "zuoraEntityIds_example"; // An entity ID. If you have [Zuora Multi-entity](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Multi-entity) enabled and the OAuth token is valid for more than one entity, you must use this header to specify which entity to perform the operation in. If the OAuth token is only valid for a single entity, or you do not have Zuora Multi-entity enabled, you do not need to set this header. 
    String zuoraOrgIds = "zuoraOrgIds_example"; // Comma separated IDs. If you have <a href=\"https://knowledgecenter.zuora.com/Zuora_Central_Platform/Multi-Org\" target=\"_blank\">Zuora Multi-Org</a> enabled,  you can use this header to specify which orgs to perform the operation in. If you do not have Zuora Multi-Org enabled, you should not set this header.  The IDs must be a sub-set of the user's accessible orgs. If you specify an org that the user does not have access to, the operation fails.  If the header is not set, the operation is performed in scope of the user's accessible orgs. 
    try {
      CommonResponse result = client
              .eInvoicing
              .eInvoicingBusinessRegion_0(key)
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
      System.err.println("Exception when calling EInvoicingApi#eInvoicingBusinessRegion_0");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<CommonResponse> response = client
              .eInvoicing
              .eInvoicingBusinessRegion_0(key)
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
      System.err.println("Exception when calling EInvoicingApi#eInvoicingBusinessRegion_0");
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
| **key** | **String**| The unqiue ID or number of the e-invoicing business region that you want to delete.  | |
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

<a name="eInvoicingBusinessRegions"></a>
# **eInvoicingBusinessRegions**
> ListEInvoicingBusinessRegionsResponse eInvoicingBusinessRegions().acceptEncoding(acceptEncoding).contentEncoding(contentEncoding).authorization(authorization).zuoraTrackId(zuoraTrackId).zuoraEntityIds(zuoraEntityIds).zuoraOrgIds(zuoraOrgIds).execute();

List e-invoicing business regions

Lists information about e-invoicing business regions.  **Note**: This operation is available only if you have the &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Bill_your_customers/E-Invoicing\&quot; target&#x3D;\&quot;_blank\&quot;&gt;E-Invoicing&lt;/a&gt; feature in **Early Adopter** phase enabled. 

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Zuora;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.EInvoicingApi;
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
    try {
      ListEInvoicingBusinessRegionsResponse result = client
              .eInvoicing
              .eInvoicingBusinessRegions()
              .acceptEncoding(acceptEncoding)
              .contentEncoding(contentEncoding)
              .authorization(authorization)
              .zuoraTrackId(zuoraTrackId)
              .zuoraEntityIds(zuoraEntityIds)
              .zuoraOrgIds(zuoraOrgIds)
              .execute();
      System.out.println(result);
      System.out.println(result.getRegions());
      System.out.println(result.getSuccess());
    } catch (ApiException e) {
      System.err.println("Exception when calling EInvoicingApi#eInvoicingBusinessRegions");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<ListEInvoicingBusinessRegionsResponse> response = client
              .eInvoicing
              .eInvoicingBusinessRegions()
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
      System.err.println("Exception when calling EInvoicingApi#eInvoicingBusinessRegions");
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

### Return type

[**ListEInvoicingBusinessRegionsResponse**](ListEInvoicingBusinessRegionsResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** |  |  * Content-Encoding - This header is returned if you specify the &#x60;Accept-Encoding: gzip&#x60; request header and the response contains over 1000 bytes of data. Note that only the following MIME types support gzipped responses:   - &#x60;application/json&#x60;   - &#x60;application/xml&#x60;   - &#x60;text/html&#x60;   - &#x60;text/csv&#x60;   - &#x60;text/plain&#x60;  <br>  * RateLimit-Limit - The request limit quota for the time window closest to exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Remaining - The number of requests remaining in the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Reset - The number of seconds until the quota resets for the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Zuora-Request-Id - The Zuora internal identifier of the API call. You cannot control the value of this header.  <br>  * Zuora-Track-Id - A custom identifier for tracing the API call. If you specified a tracing identifier in the request headers, Zuora returns the same tracing identifier. Otherwise, Zuora does not set this header.  <br>  |

<a name="eInvoicingServiceProvider"></a>
# **eInvoicingServiceProvider**
> GetEInvoicingServiceProviderResponse eInvoicingServiceProvider(createEInvoicingServiceProviderRequest).idempotencyKey(idempotencyKey).acceptEncoding(acceptEncoding).contentEncoding(contentEncoding).authorization(authorization).zuoraTrackId(zuoraTrackId).zuoraEntityIds(zuoraEntityIds).zuoraOrgIds(zuoraOrgIds).execute();

Create an e-invoicing service provider

Creates an e-invoicing service provider.  **Note**: This operation is available only if you have the &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Bill_your_customers/E-Invoicing\&quot; target&#x3D;\&quot;_blank\&quot;&gt;E-Invoicing&lt;/a&gt; feature in **Early Adopter** phase enabled. 

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Zuora;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.EInvoicingApi;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Example {
  public static void main(String[] args) {
    Configuration configuration = new Configuration();
    configuration.host = "https://rest.zuora.com";
    Zuora client = new Zuora(configuration);
    String companyIdentifier = "companyIdentifier_example"; // The identifier of the company used to create a sender system ID, which serves to identify the system where the transactions are sent. 
    String name = "name_example"; // The name of the e-invoicing service provider. 
    String provider = "Sovos"; // The name of the e-invoicing service provider that can help you generate e-invoice files for billing documents. 
    Boolean test = true; // Whether the e-invoicing service provider's configuration is intended for testing.   - If you set this field to `true`, requests are directed to the testing integration endpoints. If you set this field to `false`, requests are directed to the production integration endpoints. 
    String idempotencyKey = "idempotencyKey_example"; // Specify a unique idempotency key if you want to perform an idempotent POST or PATCH request. Do not use this header in other request types.   With this header specified, the Zuora server can identify subsequent retries of the same request using this value, which prevents the same operation from being performed multiple times by accident.  
    String acceptEncoding = "acceptEncoding_example"; // Include the `Accept-Encoding: gzip` header to compress responses as a gzipped file. It can significantly reduce the bandwidth required for a response.   If specified, Zuora automatically compresses responses that contain over 1000 bytes of data, and the response contains a `Content-Encoding` header with the compression algorithm so that your client can decompress it. 
    String contentEncoding = "contentEncoding_example"; // Include the `Content-Encoding: gzip` header to compress a request. With this header specified, you should upload a gzipped file for the request payload instead of sending the JSON payload. 
    String authorization = "authorization_example"; // The value is in the `Bearer {token}` format where {token} is a valid OAuth token generated by calling [Create an OAuth token](https://developer.zuora.com/api-references/api/operation/createToken). 
    String zuoraTrackId = "zuoraTrackId_example"; // A custom identifier for tracing the API call. If you set a value for this header, Zuora returns the same value in the response headers. This header enables you to associate your system process identifiers with Zuora API calls, to assist with troubleshooting in the event of an issue.  The value of this field must use the US-ASCII character set and must not include any of the following characters: colon (`:`), semicolon (`;`), double quote (`\"`), and quote (`'`). 
    String zuoraEntityIds = "zuoraEntityIds_example"; // An entity ID. If you have [Zuora Multi-entity](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Multi-entity) enabled and the OAuth token is valid for more than one entity, you must use this header to specify which entity to perform the operation in. If the OAuth token is only valid for a single entity, or you do not have Zuora Multi-entity enabled, you do not need to set this header. 
    String zuoraOrgIds = "zuoraOrgIds_example"; // Comma separated IDs. If you have <a href=\"https://knowledgecenter.zuora.com/Zuora_Central_Platform/Multi-Org\" target=\"_blank\">Zuora Multi-Org</a> enabled,  you can use this header to specify which orgs to perform the operation in. If you do not have Zuora Multi-Org enabled, you should not set this header.  The IDs must be a sub-set of the user's accessible orgs. If you specify an org that the user does not have access to, the operation fails.  If the header is not set, the operation is performed in scope of the user's accessible orgs. 
    try {
      GetEInvoicingServiceProviderResponse result = client
              .eInvoicing
              .eInvoicingServiceProvider()
              .companyIdentifier(companyIdentifier)
              .name(name)
              .provider(provider)
              .test(test)
              .idempotencyKey(idempotencyKey)
              .acceptEncoding(acceptEncoding)
              .contentEncoding(contentEncoding)
              .authorization(authorization)
              .zuoraTrackId(zuoraTrackId)
              .zuoraEntityIds(zuoraEntityIds)
              .zuoraOrgIds(zuoraOrgIds)
              .execute();
      System.out.println(result);
      System.out.println(result.getCompanyIdentifier());
      System.out.println(result.getId());
      System.out.println(result.getName());
      System.out.println(result.getProvider());
      System.out.println(result.getServiceProviderNumber());
      System.out.println(result.getTest());
    } catch (ApiException e) {
      System.err.println("Exception when calling EInvoicingApi#eInvoicingServiceProvider");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<GetEInvoicingServiceProviderResponse> response = client
              .eInvoicing
              .eInvoicingServiceProvider()
              .companyIdentifier(companyIdentifier)
              .name(name)
              .provider(provider)
              .test(test)
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
      System.err.println("Exception when calling EInvoicingApi#eInvoicingServiceProvider");
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
| **createEInvoicingServiceProviderRequest** | [**CreateEInvoicingServiceProviderRequest**](CreateEInvoicingServiceProviderRequest.md)|  | |
| **idempotencyKey** | **String**| Specify a unique idempotency key if you want to perform an idempotent POST or PATCH request. Do not use this header in other request types.   With this header specified, the Zuora server can identify subsequent retries of the same request using this value, which prevents the same operation from being performed multiple times by accident.   | [optional] |
| **acceptEncoding** | **String**| Include the &#x60;Accept-Encoding: gzip&#x60; header to compress responses as a gzipped file. It can significantly reduce the bandwidth required for a response.   If specified, Zuora automatically compresses responses that contain over 1000 bytes of data, and the response contains a &#x60;Content-Encoding&#x60; header with the compression algorithm so that your client can decompress it.  | [optional] |
| **contentEncoding** | **String**| Include the &#x60;Content-Encoding: gzip&#x60; header to compress a request. With this header specified, you should upload a gzipped file for the request payload instead of sending the JSON payload.  | [optional] |
| **authorization** | **String**| The value is in the &#x60;Bearer {token}&#x60; format where {token} is a valid OAuth token generated by calling [Create an OAuth token](https://developer.zuora.com/api-references/api/operation/createToken).  | [optional] |
| **zuoraTrackId** | **String**| A custom identifier for tracing the API call. If you set a value for this header, Zuora returns the same value in the response headers. This header enables you to associate your system process identifiers with Zuora API calls, to assist with troubleshooting in the event of an issue.  The value of this field must use the US-ASCII character set and must not include any of the following characters: colon (&#x60;:&#x60;), semicolon (&#x60;;&#x60;), double quote (&#x60;\&quot;&#x60;), and quote (&#x60;&#39;&#x60;).  | [optional] |
| **zuoraEntityIds** | **String**| An entity ID. If you have [Zuora Multi-entity](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Multi-entity) enabled and the OAuth token is valid for more than one entity, you must use this header to specify which entity to perform the operation in. If the OAuth token is only valid for a single entity, or you do not have Zuora Multi-entity enabled, you do not need to set this header.  | [optional] |
| **zuoraOrgIds** | **String**| Comma separated IDs. If you have &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Central_Platform/Multi-Org\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Zuora Multi-Org&lt;/a&gt; enabled,  you can use this header to specify which orgs to perform the operation in. If you do not have Zuora Multi-Org enabled, you should not set this header.  The IDs must be a sub-set of the user&#39;s accessible orgs. If you specify an org that the user does not have access to, the operation fails.  If the header is not set, the operation is performed in scope of the user&#39;s accessible orgs.  | [optional] |

### Return type

[**GetEInvoicingServiceProviderResponse**](GetEInvoicingServiceProviderResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** |  |  * Content-Encoding - This header is returned if you specify the &#x60;Accept-Encoding: gzip&#x60; request header and the response contains over 1000 bytes of data. Note that only the following MIME types support gzipped responses:   - &#x60;application/json&#x60;   - &#x60;application/xml&#x60;   - &#x60;text/html&#x60;   - &#x60;text/csv&#x60;   - &#x60;text/plain&#x60;  <br>  * RateLimit-Limit - The request limit quota for the time window closest to exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Remaining - The number of requests remaining in the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Reset - The number of seconds until the quota resets for the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Zuora-Request-Id - The Zuora internal identifier of the API call. You cannot control the value of this header.  <br>  * Zuora-Track-Id - A custom identifier for tracing the API call. If you specified a tracing identifier in the request headers, Zuora returns the same tracing identifier. Otherwise, Zuora does not set this header.  <br>  |

<a name="eInvoicingServiceProvider_0"></a>
# **eInvoicingServiceProvider_0**
> GetEInvoicingServiceProviderResponse eInvoicingServiceProvider_0(key).acceptEncoding(acceptEncoding).contentEncoding(contentEncoding).authorization(authorization).zuoraTrackId(zuoraTrackId).zuoraEntityIds(zuoraEntityIds).zuoraOrgIds(zuoraOrgIds).execute();

Retrieve an e-invoicing service provider

Retrieves information about an e-invoicing service privider.  **Note**: This operation is available only if you have the &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Bill_your_customers/E-Invoicing\&quot; target&#x3D;\&quot;_blank\&quot;&gt;E-Invoicing&lt;/a&gt; feature in **Early Adopter** phase enabled. 

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Zuora;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.EInvoicingApi;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Example {
  public static void main(String[] args) {
    Configuration configuration = new Configuration();
    configuration.host = "https://rest.zuora.com";
    Zuora client = new Zuora(configuration);
    String key = "key_example"; // The unique ID or number of the e-invoicing service provider that you want to retrieve information about. 
    String acceptEncoding = "acceptEncoding_example"; // Include the `Accept-Encoding: gzip` header to compress responses as a gzipped file. It can significantly reduce the bandwidth required for a response.   If specified, Zuora automatically compresses responses that contain over 1000 bytes of data, and the response contains a `Content-Encoding` header with the compression algorithm so that your client can decompress it. 
    String contentEncoding = "contentEncoding_example"; // Include the `Content-Encoding: gzip` header to compress a request. With this header specified, you should upload a gzipped file for the request payload instead of sending the JSON payload. 
    String authorization = "authorization_example"; // The value is in the `Bearer {token}` format where {token} is a valid OAuth token generated by calling [Create an OAuth token](https://developer.zuora.com/api-references/api/operation/createToken). 
    String zuoraTrackId = "zuoraTrackId_example"; // A custom identifier for tracing the API call. If you set a value for this header, Zuora returns the same value in the response headers. This header enables you to associate your system process identifiers with Zuora API calls, to assist with troubleshooting in the event of an issue.  The value of this field must use the US-ASCII character set and must not include any of the following characters: colon (`:`), semicolon (`;`), double quote (`\"`), and quote (`'`). 
    String zuoraEntityIds = "zuoraEntityIds_example"; // An entity ID. If you have [Zuora Multi-entity](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Multi-entity) enabled and the OAuth token is valid for more than one entity, you must use this header to specify which entity to perform the operation in. If the OAuth token is only valid for a single entity, or you do not have Zuora Multi-entity enabled, you do not need to set this header. 
    String zuoraOrgIds = "zuoraOrgIds_example"; // Comma separated IDs. If you have <a href=\"https://knowledgecenter.zuora.com/Zuora_Central_Platform/Multi-Org\" target=\"_blank\">Zuora Multi-Org</a> enabled,  you can use this header to specify which orgs to perform the operation in. If you do not have Zuora Multi-Org enabled, you should not set this header.  The IDs must be a sub-set of the user's accessible orgs. If you specify an org that the user does not have access to, the operation fails.  If the header is not set, the operation is performed in scope of the user's accessible orgs. 
    try {
      GetEInvoicingServiceProviderResponse result = client
              .eInvoicing
              .eInvoicingServiceProvider_0(key)
              .acceptEncoding(acceptEncoding)
              .contentEncoding(contentEncoding)
              .authorization(authorization)
              .zuoraTrackId(zuoraTrackId)
              .zuoraEntityIds(zuoraEntityIds)
              .zuoraOrgIds(zuoraOrgIds)
              .execute();
      System.out.println(result);
      System.out.println(result.getCompanyIdentifier());
      System.out.println(result.getId());
      System.out.println(result.getName());
      System.out.println(result.getProvider());
      System.out.println(result.getServiceProviderNumber());
      System.out.println(result.getTest());
    } catch (ApiException e) {
      System.err.println("Exception when calling EInvoicingApi#eInvoicingServiceProvider_0");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<GetEInvoicingServiceProviderResponse> response = client
              .eInvoicing
              .eInvoicingServiceProvider_0(key)
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
      System.err.println("Exception when calling EInvoicingApi#eInvoicingServiceProvider_0");
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
| **key** | **String**| The unique ID or number of the e-invoicing service provider that you want to retrieve information about.  | |
| **acceptEncoding** | **String**| Include the &#x60;Accept-Encoding: gzip&#x60; header to compress responses as a gzipped file. It can significantly reduce the bandwidth required for a response.   If specified, Zuora automatically compresses responses that contain over 1000 bytes of data, and the response contains a &#x60;Content-Encoding&#x60; header with the compression algorithm so that your client can decompress it.  | [optional] |
| **contentEncoding** | **String**| Include the &#x60;Content-Encoding: gzip&#x60; header to compress a request. With this header specified, you should upload a gzipped file for the request payload instead of sending the JSON payload.  | [optional] |
| **authorization** | **String**| The value is in the &#x60;Bearer {token}&#x60; format where {token} is a valid OAuth token generated by calling [Create an OAuth token](https://developer.zuora.com/api-references/api/operation/createToken).  | [optional] |
| **zuoraTrackId** | **String**| A custom identifier for tracing the API call. If you set a value for this header, Zuora returns the same value in the response headers. This header enables you to associate your system process identifiers with Zuora API calls, to assist with troubleshooting in the event of an issue.  The value of this field must use the US-ASCII character set and must not include any of the following characters: colon (&#x60;:&#x60;), semicolon (&#x60;;&#x60;), double quote (&#x60;\&quot;&#x60;), and quote (&#x60;&#39;&#x60;).  | [optional] |
| **zuoraEntityIds** | **String**| An entity ID. If you have [Zuora Multi-entity](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Multi-entity) enabled and the OAuth token is valid for more than one entity, you must use this header to specify which entity to perform the operation in. If the OAuth token is only valid for a single entity, or you do not have Zuora Multi-entity enabled, you do not need to set this header.  | [optional] |
| **zuoraOrgIds** | **String**| Comma separated IDs. If you have &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Central_Platform/Multi-Org\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Zuora Multi-Org&lt;/a&gt; enabled,  you can use this header to specify which orgs to perform the operation in. If you do not have Zuora Multi-Org enabled, you should not set this header.  The IDs must be a sub-set of the user&#39;s accessible orgs. If you specify an org that the user does not have access to, the operation fails.  If the header is not set, the operation is performed in scope of the user&#39;s accessible orgs.  | [optional] |

### Return type

[**GetEInvoicingServiceProviderResponse**](GetEInvoicingServiceProviderResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** |  |  * Content-Encoding - This header is returned if you specify the &#x60;Accept-Encoding: gzip&#x60; request header and the response contains over 1000 bytes of data. Note that only the following MIME types support gzipped responses:   - &#x60;application/json&#x60;   - &#x60;application/xml&#x60;   - &#x60;text/html&#x60;   - &#x60;text/csv&#x60;   - &#x60;text/plain&#x60;  <br>  * RateLimit-Limit - The request limit quota for the time window closest to exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Remaining - The number of requests remaining in the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Reset - The number of seconds until the quota resets for the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Zuora-Request-Id - The Zuora internal identifier of the API call. You cannot control the value of this header.  <br>  * Zuora-Track-Id - A custom identifier for tracing the API call. If you specified a tracing identifier in the request headers, Zuora returns the same tracing identifier. Otherwise, Zuora does not set this header.  <br>  |

<a name="eInvoicingServiceProvider_1"></a>
# **eInvoicingServiceProvider_1**
> CommonResponse eInvoicingServiceProvider_1(key).acceptEncoding(acceptEncoding).contentEncoding(contentEncoding).authorization(authorization).zuoraTrackId(zuoraTrackId).zuoraEntityIds(zuoraEntityIds).zuoraOrgIds(zuoraOrgIds).execute();

Delete an e-invoicing service provider

Deletes an e-invoicing service privider.  **Note**: This operation is available only if you have the &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Bill_your_customers/E-Invoicing\&quot; target&#x3D;\&quot;_blank\&quot;&gt;E-Invoicing&lt;/a&gt; feature in **Early Adopter** phase enabled. 

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Zuora;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.EInvoicingApi;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Example {
  public static void main(String[] args) {
    Configuration configuration = new Configuration();
    configuration.host = "https://rest.zuora.com";
    Zuora client = new Zuora(configuration);
    String key = "key_example"; // The unique ID or number of the e-invoicing service provider that you want to  
    String acceptEncoding = "acceptEncoding_example"; // Include the `Accept-Encoding: gzip` header to compress responses as a gzipped file. It can significantly reduce the bandwidth required for a response.   If specified, Zuora automatically compresses responses that contain over 1000 bytes of data, and the response contains a `Content-Encoding` header with the compression algorithm so that your client can decompress it. 
    String contentEncoding = "contentEncoding_example"; // Include the `Content-Encoding: gzip` header to compress a request. With this header specified, you should upload a gzipped file for the request payload instead of sending the JSON payload. 
    String authorization = "authorization_example"; // The value is in the `Bearer {token}` format where {token} is a valid OAuth token generated by calling [Create an OAuth token](https://developer.zuora.com/api-references/api/operation/createToken). 
    String zuoraTrackId = "zuoraTrackId_example"; // A custom identifier for tracing the API call. If you set a value for this header, Zuora returns the same value in the response headers. This header enables you to associate your system process identifiers with Zuora API calls, to assist with troubleshooting in the event of an issue.  The value of this field must use the US-ASCII character set and must not include any of the following characters: colon (`:`), semicolon (`;`), double quote (`\"`), and quote (`'`). 
    String zuoraEntityIds = "zuoraEntityIds_example"; // An entity ID. If you have [Zuora Multi-entity](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Multi-entity) enabled and the OAuth token is valid for more than one entity, you must use this header to specify which entity to perform the operation in. If the OAuth token is only valid for a single entity, or you do not have Zuora Multi-entity enabled, you do not need to set this header. 
    String zuoraOrgIds = "zuoraOrgIds_example"; // Comma separated IDs. If you have <a href=\"https://knowledgecenter.zuora.com/Zuora_Central_Platform/Multi-Org\" target=\"_blank\">Zuora Multi-Org</a> enabled,  you can use this header to specify which orgs to perform the operation in. If you do not have Zuora Multi-Org enabled, you should not set this header.  The IDs must be a sub-set of the user's accessible orgs. If you specify an org that the user does not have access to, the operation fails.  If the header is not set, the operation is performed in scope of the user's accessible orgs. 
    try {
      CommonResponse result = client
              .eInvoicing
              .eInvoicingServiceProvider_1(key)
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
      System.err.println("Exception when calling EInvoicingApi#eInvoicingServiceProvider_1");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<CommonResponse> response = client
              .eInvoicing
              .eInvoicingServiceProvider_1(key)
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
      System.err.println("Exception when calling EInvoicingApi#eInvoicingServiceProvider_1");
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
| **key** | **String**| The unique ID or number of the e-invoicing service provider that you want to   | |
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

<a name="eInvoicingServiceProviders"></a>
# **eInvoicingServiceProviders**
> ListEInvoicingServiceProvidersResponse eInvoicingServiceProviders().acceptEncoding(acceptEncoding).contentEncoding(contentEncoding).authorization(authorization).zuoraTrackId(zuoraTrackId).zuoraEntityIds(zuoraEntityIds).zuoraOrgIds(zuoraOrgIds).execute();

List e-invoicing service providers

Lists information about e-invoicing service providers.  **Note**: This operation is available only if you have the &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Bill_your_customers/E-Invoicing\&quot; target&#x3D;\&quot;_blank\&quot;&gt;E-Invoicing&lt;/a&gt; feature in **Early Adopter** phase enabled. 

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Zuora;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.EInvoicingApi;
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
    try {
      ListEInvoicingServiceProvidersResponse result = client
              .eInvoicing
              .eInvoicingServiceProviders()
              .acceptEncoding(acceptEncoding)
              .contentEncoding(contentEncoding)
              .authorization(authorization)
              .zuoraTrackId(zuoraTrackId)
              .zuoraEntityIds(zuoraEntityIds)
              .zuoraOrgIds(zuoraOrgIds)
              .execute();
      System.out.println(result);
      System.out.println(result.getServiceProviders());
      System.out.println(result.getSuccess());
    } catch (ApiException e) {
      System.err.println("Exception when calling EInvoicingApi#eInvoicingServiceProviders");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<ListEInvoicingServiceProvidersResponse> response = client
              .eInvoicing
              .eInvoicingServiceProviders()
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
      System.err.println("Exception when calling EInvoicingApi#eInvoicingServiceProviders");
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

### Return type

[**ListEInvoicingServiceProvidersResponse**](ListEInvoicingServiceProvidersResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** |  |  * Content-Encoding - This header is returned if you specify the &#x60;Accept-Encoding: gzip&#x60; request header and the response contains over 1000 bytes of data. Note that only the following MIME types support gzipped responses:   - &#x60;application/json&#x60;   - &#x60;application/xml&#x60;   - &#x60;text/html&#x60;   - &#x60;text/csv&#x60;   - &#x60;text/plain&#x60;  <br>  * RateLimit-Limit - The request limit quota for the time window closest to exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Remaining - The number of requests remaining in the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Reset - The number of seconds until the quota resets for the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Zuora-Request-Id - The Zuora internal identifier of the API call. You cannot control the value of this header.  <br>  * Zuora-Track-Id - A custom identifier for tracing the API call. If you specified a tracing identifier in the request headers, Zuora returns the same tracing identifier. Otherwise, Zuora does not set this header.  <br>  |

<a name="updateEInvoicingBusinessRegion"></a>
# **updateEInvoicingBusinessRegion**
> GetEInvoicingBusinessRegionResponse updateEInvoicingBusinessRegion(key, updateEInvoicingBusinessRegionRequest).acceptEncoding(acceptEncoding).contentEncoding(contentEncoding).authorization(authorization).zuoraTrackId(zuoraTrackId).zuoraEntityIds(zuoraEntityIds).zuoraOrgIds(zuoraOrgIds).execute();

Update an e-invoicing business region

Updates an e-invoicing business region by key. The key can be the unique ID or number of an e-invoicing business region.  **Note**: This operation is available only if you have the &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Bill_your_customers/E-Invoicing\&quot; target&#x3D;\&quot;_blank\&quot;&gt;E-Invoicing&lt;/a&gt; feature in **Early Adopter** phase enabled.  

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Zuora;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.EInvoicingApi;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Example {
  public static void main(String[] args) {
    Configuration configuration = new Configuration();
    configuration.host = "https://rest.zuora.com";
    Zuora client = new Zuora(configuration);
    String key = "key_example"; // The unqiue ID or number of the e-invoicing business region that you want to update. 
    String addressLine1 = "addressLine1_example"; // The first line of the Seller’s address, which is often a street address or business name. 
    String addressLine2 = "addressLine2_example"; // The second line of the Seller’s address, which is often the name of a building. 
    String businessName = "businessName_example"; // The full official name that the Seller is registered with the relevant legal authority. 
    String businessNumber = "businessNumber_example"; // The specify the unique identifier number of the legal entity or person that you do business with.  For example, you must use a GSTIN for India and Tax Identification Number (TIN) for Saudi Arabia. 
    String businessNumberSchemaId = "businessNumberSchemaId_example"; // The identification scheme identifier that an official registrar issues to identify the Seller as a legal entity or person. 
    String city = "city_example"; // The the name of the city where the business is located. 
    String contactName = "contactName_example"; // The name of the Seller contact to receive e-invoicing data. 
    String country = "country_example"; // The short name of a country or region where you must comply with e-invoicing requirements. For example, `IN` for India. For the full list of country names and codes, see <a href=\\\"https://knowledgecenter.zuora.com/Quick_References/Country%2C_State%2C_and_Province_Codes/A_Country_Names_and_Their_ISO_Codes\\\" target=\\\"_blank\\\">ISO Standard Country Codes</a>. 
    Boolean digitalSignatureEnable = false; // Whether the e-invoicing service provider signs PDF files for billing documents. 
    Boolean digitalSignatureBoxEnable = false; // Whether the digital signature box is displayed on PDF files for billing documents. 
    Double digitalSignatureBoxPosX = 3.4D; // The X-coordinate to determine where the digital signature box is displayed on PDF files for billing documents. 
    Double digitalSignatureBoxPosY = 3.4D; // The Y-coordinate to determine where the digital signature box is displayed on PDF files for billing documents.  
    String email = "email_example"; // The email address of the Seller contact to receive e-invoicing data. 
    String endpointId = "endpointId_example"; // The Seller's electronic address, to which the application-level response to the e-invoice file might be delivered. 
    String endpointSchemeId = "endpointSchemeId_example"; // The identification scheme identifier of the Seller’s electronic address. 
    String phoneNumber = "phoneNumber_example"; // The business phone number of the Seller contact to receive e-invoicing data. 
    String postalCode = "postalCode_example"; // The short code that can identify the business address. 
    String serviceProviderId = "serviceProviderId_example"; // The unique ID of the e-invoicing service provider that is associated to the business region. 
    String state = "state_example"; // The name of the state or province where the business is located. 
    String taxRegisterNumber = "taxRegisterNumber_example"; // The Seller's VAT identifier (also known as Seller VAT identification number) or the local identification (defined by the Seller’s address) of the Seller for tax purposes, or a reference that enables the Seller to state the registered tax status. 
    String tradeName = "tradeName_example"; // The name that the Seller is known as, other than the legal business name. 
    String acceptEncoding = "acceptEncoding_example"; // Include the `Accept-Encoding: gzip` header to compress responses as a gzipped file. It can significantly reduce the bandwidth required for a response.   If specified, Zuora automatically compresses responses that contain over 1000 bytes of data, and the response contains a `Content-Encoding` header with the compression algorithm so that your client can decompress it. 
    String contentEncoding = "contentEncoding_example"; // Include the `Content-Encoding: gzip` header to compress a request. With this header specified, you should upload a gzipped file for the request payload instead of sending the JSON payload. 
    String authorization = "authorization_example"; // The value is in the `Bearer {token}` format where {token} is a valid OAuth token generated by calling [Create an OAuth token](https://developer.zuora.com/api-references/api/operation/createToken). 
    String zuoraTrackId = "zuoraTrackId_example"; // A custom identifier for tracing the API call. If you set a value for this header, Zuora returns the same value in the response headers. This header enables you to associate your system process identifiers with Zuora API calls, to assist with troubleshooting in the event of an issue.  The value of this field must use the US-ASCII character set and must not include any of the following characters: colon (`:`), semicolon (`;`), double quote (`\"`), and quote (`'`). 
    String zuoraEntityIds = "zuoraEntityIds_example"; // An entity ID. If you have [Zuora Multi-entity](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Multi-entity) enabled and the OAuth token is valid for more than one entity, you must use this header to specify which entity to perform the operation in. If the OAuth token is only valid for a single entity, or you do not have Zuora Multi-entity enabled, you do not need to set this header. 
    String zuoraOrgIds = "zuoraOrgIds_example"; // Comma separated IDs. If you have <a href=\"https://knowledgecenter.zuora.com/Zuora_Central_Platform/Multi-Org\" target=\"_blank\">Zuora Multi-Org</a> enabled,  you can use this header to specify which orgs to perform the operation in. If you do not have Zuora Multi-Org enabled, you should not set this header.  The IDs must be a sub-set of the user's accessible orgs. If you specify an org that the user does not have access to, the operation fails.  If the header is not set, the operation is performed in scope of the user's accessible orgs. 
    try {
      GetEInvoicingBusinessRegionResponse result = client
              .eInvoicing
              .updateEInvoicingBusinessRegion(key)
              .addressLine1(addressLine1)
              .addressLine2(addressLine2)
              .businessName(businessName)
              .businessNumber(businessNumber)
              .businessNumberSchemaId(businessNumberSchemaId)
              .city(city)
              .contactName(contactName)
              .country(country)
              .digitalSignatureEnable(digitalSignatureEnable)
              .digitalSignatureBoxEnable(digitalSignatureBoxEnable)
              .digitalSignatureBoxPosX(digitalSignatureBoxPosX)
              .digitalSignatureBoxPosY(digitalSignatureBoxPosY)
              .email(email)
              .endpointId(endpointId)
              .endpointSchemeId(endpointSchemeId)
              .phoneNumber(phoneNumber)
              .postalCode(postalCode)
              .serviceProviderId(serviceProviderId)
              .state(state)
              .taxRegisterNumber(taxRegisterNumber)
              .tradeName(tradeName)
              .acceptEncoding(acceptEncoding)
              .contentEncoding(contentEncoding)
              .authorization(authorization)
              .zuoraTrackId(zuoraTrackId)
              .zuoraEntityIds(zuoraEntityIds)
              .zuoraOrgIds(zuoraOrgIds)
              .execute();
      System.out.println(result);
      System.out.println(result.getAddressLine1());
      System.out.println(result.getAddressLine2());
      System.out.println(result.getBusinessName());
      System.out.println(result.getBusinessNumber());
      System.out.println(result.getBusinessNumberSchemaId());
      System.out.println(result.getBusinessRegionNumber());
      System.out.println(result.getCity());
      System.out.println(result.getContactName());
      System.out.println(result.getCountry());
      System.out.println(result.getDigitalSignatureEnable());
      System.out.println(result.getDigitalSignatureBoxEnable());
      System.out.println(result.getDigitalSignatureBoxPosX());
      System.out.println(result.getDigitalSignatureBoxPosY());
      System.out.println(result.getEmail());
      System.out.println(result.getEndpointId());
      System.out.println(result.getEndpointSchemeId());
      System.out.println(result.getId());
      System.out.println(result.getSuccess());
      System.out.println(result.getPhoneNumber());
      System.out.println(result.getPostalCode());
      System.out.println(result.getServiceProviderId());
      System.out.println(result.getState());
      System.out.println(result.getTaxRegisterNumber());
      System.out.println(result.getTradeName());
    } catch (ApiException e) {
      System.err.println("Exception when calling EInvoicingApi#updateEInvoicingBusinessRegion");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<GetEInvoicingBusinessRegionResponse> response = client
              .eInvoicing
              .updateEInvoicingBusinessRegion(key)
              .addressLine1(addressLine1)
              .addressLine2(addressLine2)
              .businessName(businessName)
              .businessNumber(businessNumber)
              .businessNumberSchemaId(businessNumberSchemaId)
              .city(city)
              .contactName(contactName)
              .country(country)
              .digitalSignatureEnable(digitalSignatureEnable)
              .digitalSignatureBoxEnable(digitalSignatureBoxEnable)
              .digitalSignatureBoxPosX(digitalSignatureBoxPosX)
              .digitalSignatureBoxPosY(digitalSignatureBoxPosY)
              .email(email)
              .endpointId(endpointId)
              .endpointSchemeId(endpointSchemeId)
              .phoneNumber(phoneNumber)
              .postalCode(postalCode)
              .serviceProviderId(serviceProviderId)
              .state(state)
              .taxRegisterNumber(taxRegisterNumber)
              .tradeName(tradeName)
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
      System.err.println("Exception when calling EInvoicingApi#updateEInvoicingBusinessRegion");
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
| **key** | **String**| The unqiue ID or number of the e-invoicing business region that you want to update.  | |
| **updateEInvoicingBusinessRegionRequest** | [**UpdateEInvoicingBusinessRegionRequest**](UpdateEInvoicingBusinessRegionRequest.md)|  | |
| **acceptEncoding** | **String**| Include the &#x60;Accept-Encoding: gzip&#x60; header to compress responses as a gzipped file. It can significantly reduce the bandwidth required for a response.   If specified, Zuora automatically compresses responses that contain over 1000 bytes of data, and the response contains a &#x60;Content-Encoding&#x60; header with the compression algorithm so that your client can decompress it.  | [optional] |
| **contentEncoding** | **String**| Include the &#x60;Content-Encoding: gzip&#x60; header to compress a request. With this header specified, you should upload a gzipped file for the request payload instead of sending the JSON payload.  | [optional] |
| **authorization** | **String**| The value is in the &#x60;Bearer {token}&#x60; format where {token} is a valid OAuth token generated by calling [Create an OAuth token](https://developer.zuora.com/api-references/api/operation/createToken).  | [optional] |
| **zuoraTrackId** | **String**| A custom identifier for tracing the API call. If you set a value for this header, Zuora returns the same value in the response headers. This header enables you to associate your system process identifiers with Zuora API calls, to assist with troubleshooting in the event of an issue.  The value of this field must use the US-ASCII character set and must not include any of the following characters: colon (&#x60;:&#x60;), semicolon (&#x60;;&#x60;), double quote (&#x60;\&quot;&#x60;), and quote (&#x60;&#39;&#x60;).  | [optional] |
| **zuoraEntityIds** | **String**| An entity ID. If you have [Zuora Multi-entity](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Multi-entity) enabled and the OAuth token is valid for more than one entity, you must use this header to specify which entity to perform the operation in. If the OAuth token is only valid for a single entity, or you do not have Zuora Multi-entity enabled, you do not need to set this header.  | [optional] |
| **zuoraOrgIds** | **String**| Comma separated IDs. If you have &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Central_Platform/Multi-Org\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Zuora Multi-Org&lt;/a&gt; enabled,  you can use this header to specify which orgs to perform the operation in. If you do not have Zuora Multi-Org enabled, you should not set this header.  The IDs must be a sub-set of the user&#39;s accessible orgs. If you specify an org that the user does not have access to, the operation fails.  If the header is not set, the operation is performed in scope of the user&#39;s accessible orgs.  | [optional] |

### Return type

[**GetEInvoicingBusinessRegionResponse**](GetEInvoicingBusinessRegionResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** |  |  * Content-Encoding - This header is returned if you specify the &#x60;Accept-Encoding: gzip&#x60; request header and the response contains over 1000 bytes of data. Note that only the following MIME types support gzipped responses:   - &#x60;application/json&#x60;   - &#x60;application/xml&#x60;   - &#x60;text/html&#x60;   - &#x60;text/csv&#x60;   - &#x60;text/plain&#x60;  <br>  * RateLimit-Limit - The request limit quota for the time window closest to exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Remaining - The number of requests remaining in the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Reset - The number of seconds until the quota resets for the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Zuora-Request-Id - The Zuora internal identifier of the API call. You cannot control the value of this header.  <br>  * Zuora-Track-Id - A custom identifier for tracing the API call. If you specified a tracing identifier in the request headers, Zuora returns the same tracing identifier. Otherwise, Zuora does not set this header.  <br>  |

<a name="updateEInvoicingServiceProvider"></a>
# **updateEInvoicingServiceProvider**
> GetEInvoicingServiceProviderResponse updateEInvoicingServiceProvider(key, updateEInvoicingServiceProviderRequest).acceptEncoding(acceptEncoding).contentEncoding(contentEncoding).authorization(authorization).zuoraTrackId(zuoraTrackId).zuoraEntityIds(zuoraEntityIds).zuoraOrgIds(zuoraOrgIds).execute();

Update an e-invoicing service provider

Updates information about an e-invoicing service privider.  **Note**: This operation is available only if you have the &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Bill_your_customers/E-Invoicing\&quot; target&#x3D;\&quot;_blank\&quot;&gt;E-Invoicing&lt;/a&gt; feature in **Early Adopter** phase enabled. 

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Zuora;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.EInvoicingApi;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Example {
  public static void main(String[] args) {
    Configuration configuration = new Configuration();
    configuration.host = "https://rest.zuora.com";
    Zuora client = new Zuora(configuration);
    String key = "key_example"; // The unique ID or number of the e-invoicing service provider that you want to update. 
    String companyIdentifier = "companyIdentifier_example"; // The identifier of the company used to create a sender system ID, which serves to identify the system where the transactions are sent. 
    String name = "name_example"; // The name of the e-invoicing service provider. 
    Boolean test = true; // Whether the e-invoicing service provider's configuration is intended for testing.   - If you set this field to `true`, requests are directed to the testing integration endpoints. If you set this field to `false`, requests are directed to the production integration endpoints. 
    String acceptEncoding = "acceptEncoding_example"; // Include the `Accept-Encoding: gzip` header to compress responses as a gzipped file. It can significantly reduce the bandwidth required for a response.   If specified, Zuora automatically compresses responses that contain over 1000 bytes of data, and the response contains a `Content-Encoding` header with the compression algorithm so that your client can decompress it. 
    String contentEncoding = "contentEncoding_example"; // Include the `Content-Encoding: gzip` header to compress a request. With this header specified, you should upload a gzipped file for the request payload instead of sending the JSON payload. 
    String authorization = "authorization_example"; // The value is in the `Bearer {token}` format where {token} is a valid OAuth token generated by calling [Create an OAuth token](https://developer.zuora.com/api-references/api/operation/createToken). 
    String zuoraTrackId = "zuoraTrackId_example"; // A custom identifier for tracing the API call. If you set a value for this header, Zuora returns the same value in the response headers. This header enables you to associate your system process identifiers with Zuora API calls, to assist with troubleshooting in the event of an issue.  The value of this field must use the US-ASCII character set and must not include any of the following characters: colon (`:`), semicolon (`;`), double quote (`\"`), and quote (`'`). 
    String zuoraEntityIds = "zuoraEntityIds_example"; // An entity ID. If you have [Zuora Multi-entity](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Multi-entity) enabled and the OAuth token is valid for more than one entity, you must use this header to specify which entity to perform the operation in. If the OAuth token is only valid for a single entity, or you do not have Zuora Multi-entity enabled, you do not need to set this header. 
    String zuoraOrgIds = "zuoraOrgIds_example"; // Comma separated IDs. If you have <a href=\"https://knowledgecenter.zuora.com/Zuora_Central_Platform/Multi-Org\" target=\"_blank\">Zuora Multi-Org</a> enabled,  you can use this header to specify which orgs to perform the operation in. If you do not have Zuora Multi-Org enabled, you should not set this header.  The IDs must be a sub-set of the user's accessible orgs. If you specify an org that the user does not have access to, the operation fails.  If the header is not set, the operation is performed in scope of the user's accessible orgs. 
    try {
      GetEInvoicingServiceProviderResponse result = client
              .eInvoicing
              .updateEInvoicingServiceProvider(key)
              .companyIdentifier(companyIdentifier)
              .name(name)
              .test(test)
              .acceptEncoding(acceptEncoding)
              .contentEncoding(contentEncoding)
              .authorization(authorization)
              .zuoraTrackId(zuoraTrackId)
              .zuoraEntityIds(zuoraEntityIds)
              .zuoraOrgIds(zuoraOrgIds)
              .execute();
      System.out.println(result);
      System.out.println(result.getCompanyIdentifier());
      System.out.println(result.getId());
      System.out.println(result.getName());
      System.out.println(result.getProvider());
      System.out.println(result.getServiceProviderNumber());
      System.out.println(result.getTest());
    } catch (ApiException e) {
      System.err.println("Exception when calling EInvoicingApi#updateEInvoicingServiceProvider");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<GetEInvoicingServiceProviderResponse> response = client
              .eInvoicing
              .updateEInvoicingServiceProvider(key)
              .companyIdentifier(companyIdentifier)
              .name(name)
              .test(test)
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
      System.err.println("Exception when calling EInvoicingApi#updateEInvoicingServiceProvider");
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
| **key** | **String**| The unique ID or number of the e-invoicing service provider that you want to update.  | |
| **updateEInvoicingServiceProviderRequest** | [**UpdateEInvoicingServiceProviderRequest**](UpdateEInvoicingServiceProviderRequest.md)|  | |
| **acceptEncoding** | **String**| Include the &#x60;Accept-Encoding: gzip&#x60; header to compress responses as a gzipped file. It can significantly reduce the bandwidth required for a response.   If specified, Zuora automatically compresses responses that contain over 1000 bytes of data, and the response contains a &#x60;Content-Encoding&#x60; header with the compression algorithm so that your client can decompress it.  | [optional] |
| **contentEncoding** | **String**| Include the &#x60;Content-Encoding: gzip&#x60; header to compress a request. With this header specified, you should upload a gzipped file for the request payload instead of sending the JSON payload.  | [optional] |
| **authorization** | **String**| The value is in the &#x60;Bearer {token}&#x60; format where {token} is a valid OAuth token generated by calling [Create an OAuth token](https://developer.zuora.com/api-references/api/operation/createToken).  | [optional] |
| **zuoraTrackId** | **String**| A custom identifier for tracing the API call. If you set a value for this header, Zuora returns the same value in the response headers. This header enables you to associate your system process identifiers with Zuora API calls, to assist with troubleshooting in the event of an issue.  The value of this field must use the US-ASCII character set and must not include any of the following characters: colon (&#x60;:&#x60;), semicolon (&#x60;;&#x60;), double quote (&#x60;\&quot;&#x60;), and quote (&#x60;&#39;&#x60;).  | [optional] |
| **zuoraEntityIds** | **String**| An entity ID. If you have [Zuora Multi-entity](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Multi-entity) enabled and the OAuth token is valid for more than one entity, you must use this header to specify which entity to perform the operation in. If the OAuth token is only valid for a single entity, or you do not have Zuora Multi-entity enabled, you do not need to set this header.  | [optional] |
| **zuoraOrgIds** | **String**| Comma separated IDs. If you have &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Central_Platform/Multi-Org\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Zuora Multi-Org&lt;/a&gt; enabled,  you can use this header to specify which orgs to perform the operation in. If you do not have Zuora Multi-Org enabled, you should not set this header.  The IDs must be a sub-set of the user&#39;s accessible orgs. If you specify an org that the user does not have access to, the operation fails.  If the header is not set, the operation is performed in scope of the user&#39;s accessible orgs.  | [optional] |

### Return type

[**GetEInvoicingServiceProviderResponse**](GetEInvoicingServiceProviderResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** |  |  * Content-Encoding - This header is returned if you specify the &#x60;Accept-Encoding: gzip&#x60; request header and the response contains over 1000 bytes of data. Note that only the following MIME types support gzipped responses:   - &#x60;application/json&#x60;   - &#x60;application/xml&#x60;   - &#x60;text/html&#x60;   - &#x60;text/csv&#x60;   - &#x60;text/plain&#x60;  <br>  * RateLimit-Limit - The request limit quota for the time window closest to exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Remaining - The number of requests remaining in the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Reset - The number of seconds until the quota resets for the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Zuora-Request-Id - The Zuora internal identifier of the API call. You cannot control the value of this header.  <br>  * Zuora-Track-Id - A custom identifier for tracing the API call. If you specified a tracing identifier in the request headers, Zuora returns the same tracing identifier. Otherwise, Zuora does not set this header.  <br>  |

