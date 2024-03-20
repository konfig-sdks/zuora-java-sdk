# MetadataApi

All URIs are relative to *https://rest.zuora.com*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**compareDeployProductCatalog**](MetadataApi.md#compareDeployProductCatalog) | **POST** /deployment-manager/deployments/tenant/product_catalog | Compare and deploy the product catalog of a tenant to a target tenant |
| [**compareDeployTenantTemplate**](MetadataApi.md#compareDeployTenantTemplate) | **POST** /deployment-manager/deployments/templates | Compare and deploy a template to a tenant |
| [**compareDeployTenantToTarget**](MetadataApi.md#compareDeployTenantToTarget) | **POST** /deployment-manager/deployments/tenants | Compare and deploy a source tenant to a target tenant |
| [**deployTenantTemplate**](MetadataApi.md#deployTenantTemplate) | **POST** /deployment-manager/deployments/template/product_catalog | Compare and deploy a template for product catalog to a tenant |
| [**getDeploymentLog**](MetadataApi.md#getDeploymentLog) | **GET** /deployment-manager/deployments/{migrationId} | Retrieve a deployment log |
| [**revertDeployment**](MetadataApi.md#revertDeployment) | **POST** /deployment-manager/deployments/{migrationId}/revert | Revert a deployment |


<a name="compareDeployProductCatalog"></a>
# **compareDeployProductCatalog**
> DeploymentManagerResponse compareDeployProductCatalog(description, name, sendEmail, inActiveProducts, activeProducts, activeRatePlans, inActiveRatePlans, compareField, sourceTenantId, metadataCompareDeployProductCatalogRequest).zuoraEntityIds(zuoraEntityIds).emails(emails).comments(comments).execute();

Compare and deploy the product catalog of a tenant to a target tenant

Compare and deploy the product catalog of a tenant to a target tenant. 

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Zuora;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.MetadataApi;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Example {
  public static void main(String[] args) {
    Configuration configuration = new Configuration();
    configuration.host = "https://rest.zuora.com";
    Zuora client = new Zuora(configuration);
    String description = "description_example"; // Deployment's description.
    String name = "name_example"; // Deployment's name.
    Boolean sendEmail = true; // Specifies if an email should be sent.
    Boolean inActiveProducts = true; // Specifies if inactive products needs to be migrated.
    Boolean activeProducts = true; // Specifies if active products needs to be migrated.
    Boolean activeRatePlans = true; // Specifies if active rate plans needs to be migrated.
    Boolean inActiveRatePlans = true; // Specifies if inactive active rate plans needs to be migrated.
    String compareField = "name"; // Specifies the compare field to be using during migration.
    String sourceTenantId = "sourceTenantId_example"; // Specifies the source tenant id.
    String zuoraEntityIds = "zuoraEntityIds_example"; // An entity ID. If you have [Zuora Multi-entity](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Multi-entity) enabled and the OAuth token is valid for more than one entity, you must use this header to specify which entity to perform the operation in. If the OAuth token is only valid for a single entity, or you do not have Zuora Multi-entity enabled, you do not need to set this header.  
    String emails = "emails_example"; // If sendEmail parameter is set to true, comma separated values of emails can be specified. Example  email1@test.com,email2@test.com.
    String comments = "comments_example"; // Content of the email to be sent.
    try {
      DeploymentManagerResponse result = client
              .metadata
              .compareDeployProductCatalog(description, name, sendEmail, inActiveProducts, activeProducts, activeRatePlans, inActiveRatePlans, compareField, sourceTenantId)
              .zuoraEntityIds(zuoraEntityIds)
              .emails(emails)
              .comments(comments)
              .execute();
      System.out.println(result);
      System.out.println(result.getId());
      System.out.println(result.getStatus());
    } catch (ApiException e) {
      System.err.println("Exception when calling MetadataApi#compareDeployProductCatalog");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<DeploymentManagerResponse> response = client
              .metadata
              .compareDeployProductCatalog(description, name, sendEmail, inActiveProducts, activeProducts, activeRatePlans, inActiveRatePlans, compareField, sourceTenantId)
              .zuoraEntityIds(zuoraEntityIds)
              .emails(emails)
              .comments(comments)
              .executeWithHttpInfo();
      System.out.println(response.getResponseBody());
      System.out.println(response.getResponseHeaders());
      System.out.println(response.getStatusCode());
      System.out.println(response.getRoundTripTime());
      System.out.println(response.getRequest());
    } catch (ApiException e) {
      System.err.println("Exception when calling MetadataApi#compareDeployProductCatalog");
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
| **description** | **String**| Deployment&#39;s description. | |
| **name** | **String**| Deployment&#39;s name. | |
| **sendEmail** | **Boolean**| Specifies if an email should be sent. | |
| **inActiveProducts** | **Boolean**| Specifies if inactive products needs to be migrated. | |
| **activeProducts** | **Boolean**| Specifies if active products needs to be migrated. | |
| **activeRatePlans** | **Boolean**| Specifies if active rate plans needs to be migrated. | |
| **inActiveRatePlans** | **Boolean**| Specifies if inactive active rate plans needs to be migrated. | |
| **compareField** | **String**| Specifies the compare field to be using during migration. | [enum: name, sku] |
| **sourceTenantId** | **String**| Specifies the source tenant id. | |
| **metadataCompareDeployProductCatalogRequest** | [**MetadataCompareDeployProductCatalogRequest**](MetadataCompareDeployProductCatalogRequest.md)|  | |
| **zuoraEntityIds** | **String**| An entity ID. If you have [Zuora Multi-entity](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Multi-entity) enabled and the OAuth token is valid for more than one entity, you must use this header to specify which entity to perform the operation in. If the OAuth token is only valid for a single entity, or you do not have Zuora Multi-entity enabled, you do not need to set this header.   | [optional] |
| **emails** | **String**| If sendEmail parameter is set to true, comma separated values of emails can be specified. Example  email1@test.com,email2@test.com. | [optional] |
| **comments** | **String**| Content of the email to be sent. | [optional] |

### Return type

[**DeploymentManagerResponse**](DeploymentManagerResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: multipart/form-data
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** |  |  * RateLimit-Remaining - The number of requests remaining in the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Reset - The number of seconds until the quota resets for the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Content-Encoding - This header is returned if you specify the &#x60;Accept-Encoding: gzip&#x60; request header and the response contains over 1000 bytes of data. Note that only the following MIME types support gzipped responses:   - &#x60;application/json&#x60;   - &#x60;application/xml&#x60;   - &#x60;text/html&#x60;   - &#x60;text/csv&#x60;   - &#x60;text/plain&#x60;  <br>  * RateLimit-Limit - The request limit quota for the time window closest to exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Zuora-Request-Id - The Zuora internal identifier of the API call. You cannot control the value of this header.  <br>  * Zuora-Track-Id - A custom identifier for tracing the API call. If you specified a tracing identifier in the request headers, Zuora returns the same tracing identifier. Otherwise, Zuora does not set this header.  <br>  |

<a name="compareDeployTenantTemplate"></a>
# **compareDeployTenantTemplate**
> DeploymentManagerResponse compareDeployTenantTemplate(description, name, sendEmail, template, metadataCompareDeployTenantTemplateRequest).zuoraEntityIds(zuoraEntityIds).emails(emails).comments(comments).execute();

Compare and deploy a template to a tenant

Compare and deploy a template to a tenant. 

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Zuora;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.MetadataApi;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Example {
  public static void main(String[] args) {
    Configuration configuration = new Configuration();
    configuration.host = "https://rest.zuora.com";
    Zuora client = new Zuora(configuration);
    String description = "description_example"; // Deployment's description.
    String name = "name_example"; // Deployment's name
    Boolean sendEmail = true; // Specifies if an email should be sent.
    File template = new File("/path/to/file"); // Template file.
    String zuoraEntityIds = "zuoraEntityIds_example"; // An entity ID. If you have [Zuora Multi-entity](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Multi-entity) enabled and the OAuth token is valid for more than one entity, you must use this header to specify which entity to perform the operation in. If the OAuth token is only valid for a single entity, or you do not have Zuora Multi-entity enabled, you do not need to set this header.  
    String emails = "emails_example"; // If sendEmail parameter is set to true, comma separated values of emails can be specified. Example  email1@test.com,email2@test.com.
    String comments = "comments_example"; // Content of the email to be sent.
    try {
      DeploymentManagerResponse result = client
              .metadata
              .compareDeployTenantTemplate(description, name, sendEmail, template)
              .zuoraEntityIds(zuoraEntityIds)
              .emails(emails)
              .comments(comments)
              .execute();
      System.out.println(result);
      System.out.println(result.getId());
      System.out.println(result.getStatus());
    } catch (ApiException e) {
      System.err.println("Exception when calling MetadataApi#compareDeployTenantTemplate");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<DeploymentManagerResponse> response = client
              .metadata
              .compareDeployTenantTemplate(description, name, sendEmail, template)
              .zuoraEntityIds(zuoraEntityIds)
              .emails(emails)
              .comments(comments)
              .executeWithHttpInfo();
      System.out.println(response.getResponseBody());
      System.out.println(response.getResponseHeaders());
      System.out.println(response.getStatusCode());
      System.out.println(response.getRoundTripTime());
      System.out.println(response.getRequest());
    } catch (ApiException e) {
      System.err.println("Exception when calling MetadataApi#compareDeployTenantTemplate");
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
| **description** | **String**| Deployment&#39;s description. | |
| **name** | **String**| Deployment&#39;s name | |
| **sendEmail** | **Boolean**| Specifies if an email should be sent. | |
| **template** | **File**| Template file. | |
| **metadataCompareDeployTenantTemplateRequest** | [**MetadataCompareDeployTenantTemplateRequest**](MetadataCompareDeployTenantTemplateRequest.md)|  | |
| **zuoraEntityIds** | **String**| An entity ID. If you have [Zuora Multi-entity](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Multi-entity) enabled and the OAuth token is valid for more than one entity, you must use this header to specify which entity to perform the operation in. If the OAuth token is only valid for a single entity, or you do not have Zuora Multi-entity enabled, you do not need to set this header.   | [optional] |
| **emails** | **String**| If sendEmail parameter is set to true, comma separated values of emails can be specified. Example  email1@test.com,email2@test.com. | [optional] |
| **comments** | **String**| Content of the email to be sent. | [optional] |

### Return type

[**DeploymentManagerResponse**](DeploymentManagerResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: multipart/form-data
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** |  |  * RateLimit-Remaining - The number of requests remaining in the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Reset - The number of seconds until the quota resets for the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Content-Encoding - This header is returned if you specify the &#x60;Accept-Encoding: gzip&#x60; request header and the response contains over 1000 bytes of data. Note that only the following MIME types support gzipped responses:   - &#x60;application/json&#x60;   - &#x60;application/xml&#x60;   - &#x60;text/html&#x60;   - &#x60;text/csv&#x60;   - &#x60;text/plain&#x60;  <br>  * RateLimit-Limit - The request limit quota for the time window closest to exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Zuora-Request-Id - The Zuora internal identifier of the API call. You cannot control the value of this header.  <br>  * Zuora-Track-Id - A custom identifier for tracing the API call. If you specified a tracing identifier in the request headers, Zuora returns the same tracing identifier. Otherwise, Zuora does not set this header.  <br>  |

<a name="compareDeployTenantToTarget"></a>
# **compareDeployTenantToTarget**
> DeploymentManagerResponse compareDeployTenantToTarget(description, name, sendEmail, settings, notifications, workflows, customFields, productCatalog, userRoles, reporting, sourceTenantId, metadataCompareDeployTenantToTargetRequest).zuoraEntityIds(zuoraEntityIds).emails(emails).comments(comments).customObjects(customObjects).taxation(taxation).execute();

Compare and deploy a source tenant to a target tenant

Compare and deploy a source tenant to a target tenant. 

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Zuora;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.MetadataApi;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Example {
  public static void main(String[] args) {
    Configuration configuration = new Configuration();
    configuration.host = "https://rest.zuora.com";
    Zuora client = new Zuora(configuration);
    String description = "description_example"; // Deployment's description.
    String name = "name_example"; // Deployment's name.
    Boolean sendEmail = true; // Specifies if an email should be sent.
    Boolean settings = true; // Specified if settings module should be considered in the deployment process.
    Boolean notifications = true; // Specified if notifications module should be considered in the deployment process.
    Boolean workflows = true; // Specified if workflows module should be considered in the deployment process.
    Boolean customFields = true; // Specified if customFields module should be considered in the deployment process.
    Boolean productCatalog = true; // Specified if productCatalog module should be considered in the deployment process.
    Boolean userRoles = true; // Specified if userRoles module should be considered in the deployment process.
    Boolean reporting = true; // Specified if reporting module should be considered in the deployment process.
    String sourceTenantId = "sourceTenantId_example"; // Id of the source tenant.
    String zuoraEntityIds = "zuoraEntityIds_example"; // An entity ID. If you have [Zuora Multi-entity](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Multi-entity) enabled and the OAuth token is valid for more than one entity, you must use this header to specify which entity to perform the operation in. If the OAuth token is only valid for a single entity, or you do not have Zuora Multi-entity enabled, you do not need to set this header.  
    String emails = "emails_example"; // If sendEmail parameter is set to true, comma separated values of emails can be specified. Example  email1@test.com,email2@test.com.
    String comments = "comments_example"; // Content of the email to be sent.
    Boolean customObjects = true; // Specified if customObjects module should be considered in the deployment process.
    Boolean taxation = true; // Specified if taxation module should be considered in the deployment process.
    try {
      DeploymentManagerResponse result = client
              .metadata
              .compareDeployTenantToTarget(description, name, sendEmail, settings, notifications, workflows, customFields, productCatalog, userRoles, reporting, sourceTenantId)
              .zuoraEntityIds(zuoraEntityIds)
              .emails(emails)
              .comments(comments)
              .customObjects(customObjects)
              .taxation(taxation)
              .execute();
      System.out.println(result);
      System.out.println(result.getId());
      System.out.println(result.getStatus());
    } catch (ApiException e) {
      System.err.println("Exception when calling MetadataApi#compareDeployTenantToTarget");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<DeploymentManagerResponse> response = client
              .metadata
              .compareDeployTenantToTarget(description, name, sendEmail, settings, notifications, workflows, customFields, productCatalog, userRoles, reporting, sourceTenantId)
              .zuoraEntityIds(zuoraEntityIds)
              .emails(emails)
              .comments(comments)
              .customObjects(customObjects)
              .taxation(taxation)
              .executeWithHttpInfo();
      System.out.println(response.getResponseBody());
      System.out.println(response.getResponseHeaders());
      System.out.println(response.getStatusCode());
      System.out.println(response.getRoundTripTime());
      System.out.println(response.getRequest());
    } catch (ApiException e) {
      System.err.println("Exception when calling MetadataApi#compareDeployTenantToTarget");
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
| **description** | **String**| Deployment&#39;s description. | |
| **name** | **String**| Deployment&#39;s name. | |
| **sendEmail** | **Boolean**| Specifies if an email should be sent. | |
| **settings** | **Boolean**| Specified if settings module should be considered in the deployment process. | |
| **notifications** | **Boolean**| Specified if notifications module should be considered in the deployment process. | |
| **workflows** | **Boolean**| Specified if workflows module should be considered in the deployment process. | |
| **customFields** | **Boolean**| Specified if customFields module should be considered in the deployment process. | |
| **productCatalog** | **Boolean**| Specified if productCatalog module should be considered in the deployment process. | |
| **userRoles** | **Boolean**| Specified if userRoles module should be considered in the deployment process. | |
| **reporting** | **Boolean**| Specified if reporting module should be considered in the deployment process. | |
| **sourceTenantId** | **String**| Id of the source tenant. | |
| **metadataCompareDeployTenantToTargetRequest** | [**MetadataCompareDeployTenantToTargetRequest**](MetadataCompareDeployTenantToTargetRequest.md)|  | |
| **zuoraEntityIds** | **String**| An entity ID. If you have [Zuora Multi-entity](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Multi-entity) enabled and the OAuth token is valid for more than one entity, you must use this header to specify which entity to perform the operation in. If the OAuth token is only valid for a single entity, or you do not have Zuora Multi-entity enabled, you do not need to set this header.   | [optional] |
| **emails** | **String**| If sendEmail parameter is set to true, comma separated values of emails can be specified. Example  email1@test.com,email2@test.com. | [optional] |
| **comments** | **String**| Content of the email to be sent. | [optional] |
| **customObjects** | **Boolean**| Specified if customObjects module should be considered in the deployment process. | [optional] |
| **taxation** | **Boolean**| Specified if taxation module should be considered in the deployment process. | [optional] |

### Return type

[**DeploymentManagerResponse**](DeploymentManagerResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: multipart/form-data
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** |  |  * RateLimit-Remaining - The number of requests remaining in the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Reset - The number of seconds until the quota resets for the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Content-Encoding - This header is returned if you specify the &#x60;Accept-Encoding: gzip&#x60; request header and the response contains over 1000 bytes of data. Note that only the following MIME types support gzipped responses:   - &#x60;application/json&#x60;   - &#x60;application/xml&#x60;   - &#x60;text/html&#x60;   - &#x60;text/csv&#x60;   - &#x60;text/plain&#x60;  <br>  * RateLimit-Limit - The request limit quota for the time window closest to exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Zuora-Request-Id - The Zuora internal identifier of the API call. You cannot control the value of this header.  <br>  * Zuora-Track-Id - A custom identifier for tracing the API call. If you specified a tracing identifier in the request headers, Zuora returns the same tracing identifier. Otherwise, Zuora does not set this header.  <br>  |

<a name="deployTenantTemplate"></a>
# **deployTenantTemplate**
> DeploymentManagerResponse deployTenantTemplate(description, name, sendEmail, template, inActiveProducts, activeProducts, activeRatePlans, inActiveRatePlans, compareField, metadataDeployTenantTemplateRequest).zuoraEntityIds(zuoraEntityIds).emails(emails).comments(comments).execute();

Compare and deploy a template for product catalog to a tenant

Compare and deploy a template for product catalog to a tenant. 

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Zuora;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.MetadataApi;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Example {
  public static void main(String[] args) {
    Configuration configuration = new Configuration();
    configuration.host = "https://rest.zuora.com";
    Zuora client = new Zuora(configuration);
    String description = "description_example"; // Deployment's description.
    String name = "name_example"; // Deployment's name.
    Boolean sendEmail = true; // Specifies if an email should be sent.
    File template = new File("/path/to/file"); // Template file.
    Boolean inActiveProducts = true; // Specifies if inactive products needs to be migrated.
    Boolean activeProducts = true; // Specifies if active products needs to be migrated.
    Boolean activeRatePlans = true; // Specifies if active rate plans needs to be migrated.
    Boolean inActiveRatePlans = true; // Specifies if inactive rate plans needs to be migrated.
    String compareField = "name"; // Specifies the compare field to be using during migration.
    String zuoraEntityIds = "zuoraEntityIds_example"; // An entity ID. If you have [Zuora Multi-entity](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Multi-entity) enabled and the OAuth token is valid for more than one entity, you must use this header to specify which entity to perform the operation in. If the OAuth token is only valid for a single entity, or you do not have Zuora Multi-entity enabled, you do not need to set this header.  
    String emails = "emails_example"; // If sendEmail parameter is set to true, comma separated values of emails can be specified.
    String comments = "comments_example"; // Content of the email to be sent.
    try {
      DeploymentManagerResponse result = client
              .metadata
              .deployTenantTemplate(description, name, sendEmail, template, inActiveProducts, activeProducts, activeRatePlans, inActiveRatePlans, compareField)
              .zuoraEntityIds(zuoraEntityIds)
              .emails(emails)
              .comments(comments)
              .execute();
      System.out.println(result);
      System.out.println(result.getId());
      System.out.println(result.getStatus());
    } catch (ApiException e) {
      System.err.println("Exception when calling MetadataApi#deployTenantTemplate");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<DeploymentManagerResponse> response = client
              .metadata
              .deployTenantTemplate(description, name, sendEmail, template, inActiveProducts, activeProducts, activeRatePlans, inActiveRatePlans, compareField)
              .zuoraEntityIds(zuoraEntityIds)
              .emails(emails)
              .comments(comments)
              .executeWithHttpInfo();
      System.out.println(response.getResponseBody());
      System.out.println(response.getResponseHeaders());
      System.out.println(response.getStatusCode());
      System.out.println(response.getRoundTripTime());
      System.out.println(response.getRequest());
    } catch (ApiException e) {
      System.err.println("Exception when calling MetadataApi#deployTenantTemplate");
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
| **description** | **String**| Deployment&#39;s description. | |
| **name** | **String**| Deployment&#39;s name. | |
| **sendEmail** | **Boolean**| Specifies if an email should be sent. | |
| **template** | **File**| Template file. | |
| **inActiveProducts** | **Boolean**| Specifies if inactive products needs to be migrated. | |
| **activeProducts** | **Boolean**| Specifies if active products needs to be migrated. | |
| **activeRatePlans** | **Boolean**| Specifies if active rate plans needs to be migrated. | |
| **inActiveRatePlans** | **Boolean**| Specifies if inactive rate plans needs to be migrated. | |
| **compareField** | **String**| Specifies the compare field to be using during migration. | [enum: name, sku] |
| **metadataDeployTenantTemplateRequest** | [**MetadataDeployTenantTemplateRequest**](MetadataDeployTenantTemplateRequest.md)|  | |
| **zuoraEntityIds** | **String**| An entity ID. If you have [Zuora Multi-entity](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Multi-entity) enabled and the OAuth token is valid for more than one entity, you must use this header to specify which entity to perform the operation in. If the OAuth token is only valid for a single entity, or you do not have Zuora Multi-entity enabled, you do not need to set this header.   | [optional] |
| **emails** | **String**| If sendEmail parameter is set to true, comma separated values of emails can be specified. | [optional] |
| **comments** | **String**| Content of the email to be sent. | [optional] |

### Return type

[**DeploymentManagerResponse**](DeploymentManagerResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: multipart/form-data
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** |  |  * RateLimit-Remaining - The number of requests remaining in the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Reset - The number of seconds until the quota resets for the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Content-Encoding - This header is returned if you specify the &#x60;Accept-Encoding: gzip&#x60; request header and the response contains over 1000 bytes of data. Note that only the following MIME types support gzipped responses:   - &#x60;application/json&#x60;   - &#x60;application/xml&#x60;   - &#x60;text/html&#x60;   - &#x60;text/csv&#x60;   - &#x60;text/plain&#x60;  <br>  * RateLimit-Limit - The request limit quota for the time window closest to exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Zuora-Request-Id - The Zuora internal identifier of the API call. You cannot control the value of this header.  <br>  * Zuora-Track-Id - A custom identifier for tracing the API call. If you specified a tracing identifier in the request headers, Zuora returns the same tracing identifier. Otherwise, Zuora does not set this header.  <br>  |

<a name="getDeploymentLog"></a>
# **getDeploymentLog**
> MetadataGetDeploymentLogResponse getDeploymentLog(migrationId).zuoraEntityIds(zuoraEntityIds).execute();

Retrieve a deployment log

Retrieve a deployment log. 

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Zuora;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.MetadataApi;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Example {
  public static void main(String[] args) {
    Configuration configuration = new Configuration();
    configuration.host = "https://rest.zuora.com";
    Zuora client = new Zuora(configuration);
    String migrationId = "migrationId_example"; // The unique ID of a migration. 
    String zuoraEntityIds = "zuoraEntityIds_example"; // An entity ID. If you have [Zuora Multi-entity](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Multi-entity) enabled and the OAuth token is valid for more than one entity, you must use this header to specify which entity to perform the operation in. If the OAuth token is only valid for a single entity, or you do not have Zuora Multi-entity enabled, you do not need to set this header.  
    try {
      MetadataGetDeploymentLogResponse result = client
              .metadata
              .getDeploymentLog(migrationId)
              .zuoraEntityIds(zuoraEntityIds)
              .execute();
      System.out.println(result);
      System.out.println(result.getDescription());
      System.out.println(result.getId());
      System.out.println(result.getName());
      System.out.println(result.getStatus());
      System.out.println(result.getTargetTenant());
      System.out.println(result.getDeploymentDate());
      System.out.println(result.getRunBy());
      System.out.println(result.getSucceeded());
      System.out.println(result.getFailed());
      System.out.println(result.getSkipped());
    } catch (ApiException e) {
      System.err.println("Exception when calling MetadataApi#getDeploymentLog");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<MetadataGetDeploymentLogResponse> response = client
              .metadata
              .getDeploymentLog(migrationId)
              .zuoraEntityIds(zuoraEntityIds)
              .executeWithHttpInfo();
      System.out.println(response.getResponseBody());
      System.out.println(response.getResponseHeaders());
      System.out.println(response.getStatusCode());
      System.out.println(response.getRoundTripTime());
      System.out.println(response.getRequest());
    } catch (ApiException e) {
      System.err.println("Exception when calling MetadataApi#getDeploymentLog");
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
| **migrationId** | **String**| The unique ID of a migration.  | |
| **zuoraEntityIds** | **String**| An entity ID. If you have [Zuora Multi-entity](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Multi-entity) enabled and the OAuth token is valid for more than one entity, you must use this header to specify which entity to perform the operation in. If the OAuth token is only valid for a single entity, or you do not have Zuora Multi-entity enabled, you do not need to set this header.   | [optional] |

### Return type

[**MetadataGetDeploymentLogResponse**](MetadataGetDeploymentLogResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** |  |  -  |

<a name="revertDeployment"></a>
# **revertDeployment**
> MetadataRevertDeploymentResponse revertDeployment(migrationId).zuoraEntityIds(zuoraEntityIds).execute();

Revert a deployment

Revert a deployment. 

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Zuora;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.MetadataApi;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Example {
  public static void main(String[] args) {
    Configuration configuration = new Configuration();
    configuration.host = "https://rest.zuora.com";
    Zuora client = new Zuora(configuration);
    String migrationId = "migrationId_example"; // The unique ID of a migration. 
    String zuoraEntityIds = "zuoraEntityIds_example"; // An entity ID. If you have [Zuora Multi-entity](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Multi-entity) enabled and the OAuth token is valid for more than one entity, you must use this header to specify which entity to perform the operation in. If the OAuth token is only valid for a single entity, or you do not have Zuora Multi-entity enabled, you do not need to set this header.  
    try {
      MetadataRevertDeploymentResponse result = client
              .metadata
              .revertDeployment(migrationId)
              .zuoraEntityIds(zuoraEntityIds)
              .execute();
      System.out.println(result);
      System.out.println(result.getDescription());
      System.out.println(result.getId());
      System.out.println(result.getName());
      System.out.println(result.getSourceTenantName());
      System.out.println(result.getSourceTenantDescription());
      System.out.println(result.getStatus());
      System.out.println(result.getStartTime());
      System.out.println(result.getEndTime());
      System.out.println(result.getMigratedBy());
      System.out.println(result.getType());
      System.out.println(result.getEnvironment());
      System.out.println(result.getEmailIds());
      System.out.println(result.getProductCatalog());
      System.out.println(result.getErrors());
    } catch (ApiException e) {
      System.err.println("Exception when calling MetadataApi#revertDeployment");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<MetadataRevertDeploymentResponse> response = client
              .metadata
              .revertDeployment(migrationId)
              .zuoraEntityIds(zuoraEntityIds)
              .executeWithHttpInfo();
      System.out.println(response.getResponseBody());
      System.out.println(response.getResponseHeaders());
      System.out.println(response.getStatusCode());
      System.out.println(response.getRoundTripTime());
      System.out.println(response.getRequest());
    } catch (ApiException e) {
      System.err.println("Exception when calling MetadataApi#revertDeployment");
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
| **migrationId** | **String**| The unique ID of a migration.  | |
| **zuoraEntityIds** | **String**| An entity ID. If you have [Zuora Multi-entity](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Multi-entity) enabled and the OAuth token is valid for more than one entity, you must use this header to specify which entity to perform the operation in. If the OAuth token is only valid for a single entity, or you do not have Zuora Multi-entity enabled, you do not need to set this header.   | [optional] |

### Return type

[**MetadataRevertDeploymentResponse**](MetadataRevertDeploymentResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** |  |  * RateLimit-Remaining - The number of requests remaining in the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Reset - The number of seconds until the quota resets for the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Content-Encoding - This header is returned if you specify the &#x60;Accept-Encoding: gzip&#x60; request header and the response contains over 1000 bytes of data. Note that only the following MIME types support gzipped responses:   - &#x60;application/json&#x60;   - &#x60;application/xml&#x60;   - &#x60;text/html&#x60;   - &#x60;text/csv&#x60;   - &#x60;text/plain&#x60;  <br>  * RateLimit-Limit - The request limit quota for the time window closest to exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Zuora-Request-Id - The Zuora internal identifier of the API call. You cannot control the value of this header.  <br>  * Zuora-Track-Id - A custom identifier for tracing the API call. If you specified a tracing identifier in the request headers, Zuora returns the same tracing identifier. Otherwise, Zuora does not set this header.  <br>  |

