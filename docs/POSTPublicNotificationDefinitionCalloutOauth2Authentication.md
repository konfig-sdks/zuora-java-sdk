

# POSTPublicNotificationDefinitionCalloutOauth2Authentication


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
|**requiredOauth2** | **Boolean** | Indicates whether OAuth 2.0 authentication is enabled for the callout.  When creating callout notifications with OAuth 2.0 authentication enabled, you must set this field to &#x60;true&#x60; and specify the OAuth 2.0 provider ID in &#x60;oauth2ProviderId&#x60;.  |  |
|**oauth2ProviderId** | **Object** | The ID of the OAuth 2.0 provider in your tenant that provides access tokens for the callout. This field is required if &#x60;requiredOauth2&#x60; is &#x60;true&#x60;.  For more information about how to get the ID of an OAuth 2.0 provider, see &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Central_Platform/Tenant_Management/A_Administrator_Settings/Add_an_OAuth_2.0_Provider#Retrieve_the_ID_of_an_OAuth_2.0_provider\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Retrieve the ID of an OAuth 2.0 provider&lt;/a&gt;.  |  [optional] |



## Enum: HttpMethodEnum

| Name | Value |
|---- | -----|
| GET | &quot;GET&quot; |
| PUT | &quot;PUT&quot; |
| POST | &quot;POST&quot; |
| DELETE | &quot;DELETE&quot; |



