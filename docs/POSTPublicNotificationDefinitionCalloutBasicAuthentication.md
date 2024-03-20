

# POSTPublicNotificationDefinitionCalloutBasicAuthentication


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**description** | **String** | Description for the callout. |  [optional] |
|**active** | **Boolean** | The status of the callout. The default is &#x60;true&#x60;. |  [optional] |
|**calloutBaseurl** | **String** | The callout URL. It must start with &#39;https://&#39; |  |
|**calloutParams** | **Map&lt;String, String&gt;** | A key-value map of merge fields of this callout.  |  [optional] |
|**calloutRetry** | **Boolean** | Specified whether to retry the callout when the callout fails. The default value is &#x60;true&#x60;. |  [optional] |
|**eventTypeName** | **String** | The name of the event type. The value must be the same as the parent-level &#x60;eventTypeName&#x60; field. |  [optional] |
|**httpMethod** | [**HttpMethodEnum**](#HttpMethodEnum) | The HTTP method of the callout. |  |
|**name** | **String** | The name of the created callout. |  |
|**requiredAuth** | **Boolean** | Indicates whether Basic authentication is enabled for the callout.  When creating callout notifications with Basic authentication enabled, you must set this field to &#x60;true&#x60; and specify the username and password in &#x60;calloutAuth&#x60;.  |  |
|**calloutAuth** | [**CalloutAuth**](CalloutAuth.md) |  |  [optional] |



## Enum: HttpMethodEnum

| Name | Value |
|---- | -----|
| GET | &quot;GET&quot; |
| PUT | &quot;PUT&quot; |
| POST | &quot;POST&quot; |
| DELETE | &quot;DELETE&quot; |



