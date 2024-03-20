

# POSTPublicNotificationDefinitionCalloutOauth2AuthenticationAllOf

The OAuth 2.0 Authentication information for callout notifications. 

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**requiredOauth2** | **Boolean** | Indicates whether OAuth 2.0 authentication is enabled for the callout.  When creating callout notifications with OAuth 2.0 authentication enabled, you must set this field to &#x60;true&#x60; and specify the OAuth 2.0 provider ID in &#x60;oauth2ProviderId&#x60;.  |  |
|**oauth2ProviderId** | **Object** | The ID of the OAuth 2.0 provider in your tenant that provides access tokens for the callout. This field is required if &#x60;requiredOauth2&#x60; is &#x60;true&#x60;.  For more information about how to get the ID of an OAuth 2.0 provider, see &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Central_Platform/Tenant_Management/A_Administrator_Settings/Add_an_OAuth_2.0_Provider#Retrieve_the_ID_of_an_OAuth_2.0_provider\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Retrieve the ID of an OAuth 2.0 provider&lt;/a&gt;.  |  [optional] |



