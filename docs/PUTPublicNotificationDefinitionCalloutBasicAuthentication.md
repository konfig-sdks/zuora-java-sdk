

# PUTPublicNotificationDefinitionCalloutBasicAuthentication


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**description** | **String** | Description for the callout. |  [optional] |
|**active** | **Boolean** | The status of the callout. The default value is &#x60;true&#x60;. |  [optional] |
|**calloutBaseurl** | **String** | The callout URL. It must start with &#39;https://&#39; |  [optional] |
|**calloutParams** | **Map&lt;String, String&gt;** | A key-value map of merge fields of this callout.  |  [optional] |
|**calloutRetry** | **Boolean** | Specified whether to retry the callout when the callout fails. The default value is &#x60;true&#x60;. |  [optional] |
|**httpMethod** | [**HttpMethodEnum**](#HttpMethodEnum) | The HTTP method of the callout. |  [optional] |
|**name** | **String** | The name of the created callout. |  [optional] |
|**requiredAuth** | **Boolean** | Indicates whether Basic authentication is enabled for the callout.  |  [optional] |
|**calloutAuth** | [**CalloutAuth**](CalloutAuth.md) |  |  [optional] |



## Enum: HttpMethodEnum

| Name | Value |
|---- | -----|
| GET | &quot;GET&quot; |
| PUT | &quot;PUT&quot; |
| POST | &quot;POST&quot; |
| DELETE | &quot;DELETE&quot; |



