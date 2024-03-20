

# PUTPublicNotificationDefinitionCalloutOauth2Authentication


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
|**requiredOauth2** | **Boolean** | Indicates whether OAuth 2.0 authentication is enabled for the callout.  |  [optional] |
|**oauth2ProviderId** | **Object** | The ID of the OAuth 2.0 provider in your tenant that provides access tokens for the callout.  For more information about how to get the ID of an OAuth 2.0 provider, see &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Central_Platform/Tenant_Management/A_Administrator_Settings/Add_an_OAuth_2.0_Provider#Retrieve_the_ID_of_an_OAuth_2.0_provider\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Retrieve the ID of an OAuth 2.0 provider&lt;/a&gt;.  |  [optional] |



## Enum: HttpMethodEnum

| Name | Value |
|---- | -----|
| GET | &quot;GET&quot; |
| PUT | &quot;PUT&quot; |
| POST | &quot;POST&quot; |
| DELETE | &quot;DELETE&quot; |



