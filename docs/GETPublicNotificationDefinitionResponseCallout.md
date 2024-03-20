

# GETPublicNotificationDefinitionResponseCallout


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**description** | **String** | Description for the callout. |  [optional] |
|**active** | **Boolean** | The status of the callout. The default value is &#x60;true&#x60;. |  [optional] |
|**calloutAuth** | [**CalloutAuth**](CalloutAuth.md) |  |  [optional] |
|**calloutBaseurl** | **String** | The callout URL. It must start with &#39;https://&#39; |  [optional] |
|**calloutParams** | **Map&lt;String, String&gt;** | A key-value map of merge fields of this callout.  |  [optional] |
|**calloutRetry** | **Boolean** | Specified whether to retry the callout when the callout fails. The default value is &#x60;true&#x60;. |  [optional] |
|**eventTypeName** | **String** | The name of the custom event type. |  [optional] |
|**httpMethod** | [**HttpMethodEnum**](#HttpMethodEnum) | The HTTP method of the callout. |  [optional] |
|**id** | **UUID** | The ID of the callout. If &#x60;calloutActive&#x60; is &#x60;true&#x60;, a callout is required. The eventTypeName of the callout MUST be the same as the eventTypeName. |  [optional] |
|**name** | **String** | The name of the created callout. |  [optional] |
|**oauth2ProviderId** | **String** | The ID of the OAuth 2.0 provider in your tenant that provides access tokens for the callout. |  [optional] |
|**requiredAuth** | **Boolean** | Indicates whether Basic authentication is enabled for the callout. |  [optional] |
|**requiredOauth2** | **Boolean** | Indicates whether OAuth 2.0 authentication is enabled for the callout. |  [optional] |



## Enum: HttpMethodEnum

| Name | Value |
|---- | -----|
| GET | &quot;GET&quot; |
| PUT | &quot;PUT&quot; |
| POST | &quot;POST&quot; |
| DELETE | &quot;DELETE&quot; |



