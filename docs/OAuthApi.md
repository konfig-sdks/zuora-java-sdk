# OAuthApi

All URIs are relative to *https://rest.zuora.com*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**createToken**](OAuthApi.md#createToken) | **POST** /oauth/token | Create an OAuth token |


<a name="createToken"></a>
# **createToken**
> TokenResponse createToken(clientId, clientSecret, grantType, oauthCreateTokenRequest).zuoraTrackId(zuoraTrackId).execute();

Create an OAuth token

Creates a bearer token that enables an OAuth client to authenticate with the Zuora REST API. The OAuth client must have been created using the Zuora UI. See [Authentication](https://developer.zuora.com/rest-api/general-concepts/authentication/) for more information.  **Note:** When using this operation, do not set any authentication headers such as &#x60;Authorization&#x60;, &#x60;apiAccessKeyId&#x60;, or &#x60;apiSecretAccessKey&#x60;.  You should not use this operation to generate a large number of bearer tokens in a short period of time; each token should be used until it expires. If you receive a 429 Too Many Requests response when using this operation, reduce the frequency of requests. This endpoint is rate limited by IP address.  For the rate limit information of authentication, see [Rate and concurrent request limits](https://developer.zuora.com/rest-api/general-concepts/rate-concurrency-limits/). 

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Zuora;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.OAuthApi;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Example {
  public static void main(String[] args) {
    Configuration configuration = new Configuration();
    configuration.host = "https://rest.zuora.com";
    Zuora client = new Zuora(configuration);
    String clientId = "clientId_example"; // The Client ID of the OAuth client. 
    String clientSecret = "clientSecret_example"; // The Client Secret that was displayed when the OAuth client was created. 
    String grantType = "client_credentials"; // The OAuth grant type that will be used to generate the token. The value of this parameter must be `client_credentials`. 
    String zuoraTrackId = "zuoraTrackId_example"; // A custom identifier for tracing the API call. If you set a value for this header, Zuora returns the same value in the response headers. This header enables you to associate your system process identifiers with Zuora API calls, to assist with troubleshooting in the event of an issue.  The value of this field must use the US-ASCII character set and must not include any of the following characters: colon (`:`), semicolon (`;`), double quote (`\"`), and quote (`'`). 
    try {
      TokenResponse result = client
              .oAuth
              .createToken(clientId, clientSecret, grantType)
              .zuoraTrackId(zuoraTrackId)
              .execute();
      System.out.println(result);
      System.out.println(result.getAccessToken());
      System.out.println(result.getExpiresIn());
      System.out.println(result.getJti());
      System.out.println(result.getScope());
      System.out.println(result.getTokenType());
    } catch (ApiException e) {
      System.err.println("Exception when calling OAuthApi#createToken");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<TokenResponse> response = client
              .oAuth
              .createToken(clientId, clientSecret, grantType)
              .zuoraTrackId(zuoraTrackId)
              .executeWithHttpInfo();
      System.out.println(response.getResponseBody());
      System.out.println(response.getResponseHeaders());
      System.out.println(response.getStatusCode());
      System.out.println(response.getRoundTripTime());
      System.out.println(response.getRequest());
    } catch (ApiException e) {
      System.err.println("Exception when calling OAuthApi#createToken");
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
| **clientId** | **String**| The Client ID of the OAuth client.  | |
| **clientSecret** | **String**| The Client Secret that was displayed when the OAuth client was created.  | |
| **grantType** | **String**| The OAuth grant type that will be used to generate the token. The value of this parameter must be &#x60;client_credentials&#x60;.  | [enum: client_credentials] |
| **oauthCreateTokenRequest** | [**OAuthCreateTokenRequest**](OAuthCreateTokenRequest.md)|  | |
| **zuoraTrackId** | **String**| A custom identifier for tracing the API call. If you set a value for this header, Zuora returns the same value in the response headers. This header enables you to associate your system process identifiers with Zuora API calls, to assist with troubleshooting in the event of an issue.  The value of this field must use the US-ASCII character set and must not include any of the following characters: colon (&#x60;:&#x60;), semicolon (&#x60;;&#x60;), double quote (&#x60;\&quot;&#x60;), and quote (&#x60;&#39;&#x60;).  | [optional] |

### Return type

[**TokenResponse**](TokenResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/x-www-form-urlencoded
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  * X-RateLimit-Limit-minute - The rate limit of this operation, in requests per minute. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * X-RateLimit-Remaining-minute - The number of requests that you may make in the next minute. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Zuora-Request-Id - The Zuora internal identifier of the API call. You cannot control the value of this header.  <br>  * Zuora-Track-Id - A custom identifier for tracing the API call. If you specified a tracing identifier in the request headers, Zuora returns the same tracing identifier. Otherwise, Zuora does not set this header.  <br>  |
| **429** | Too Many Requests |  * X-RateLimit-Limit-minute - The rate limit of this operation, in requests per minute. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * X-RateLimit-Remaining-minute - The number of requests that you may make in the next minute. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Zuora-Request-Id - The Zuora internal identifier of the API call. You cannot control the value of this header.  <br>  * Zuora-Track-Id - A custom identifier for tracing the API call. If you specified a tracing identifier in the request headers, Zuora returns the same tracing identifier. Otherwise, Zuora does not set this header.  <br>  |

