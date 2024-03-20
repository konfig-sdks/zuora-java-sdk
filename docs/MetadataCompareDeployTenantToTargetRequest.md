

# MetadataCompareDeployTenantToTargetRequest


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**description** | **String** | Deployment&#39;s description. |  |
|**name** | **String** | Deployment&#39;s name. |  |
|**sendEmail** | **Boolean** | Specifies if an email should be sent. |  |
|**emails** | **String** | If sendEmail parameter is set to true, comma separated values of emails can be specified. Example  email1@test.com,email2@test.com. |  [optional] |
|**comments** | **String** | Content of the email to be sent. |  [optional] |
|**settings** | **Boolean** | Specified if settings module should be considered in the deployment process. |  |
|**notifications** | **Boolean** | Specified if notifications module should be considered in the deployment process. |  |
|**workflows** | **Boolean** | Specified if workflows module should be considered in the deployment process. |  |
|**customFields** | **Boolean** | Specified if customFields module should be considered in the deployment process. |  |
|**customObjects** | **Boolean** | Specified if customObjects module should be considered in the deployment process. |  [optional] |
|**productCatalog** | **Boolean** | Specified if productCatalog module should be considered in the deployment process. |  |
|**taxation** | **Boolean** | Specified if taxation module should be considered in the deployment process. |  [optional] |
|**userRoles** | **Boolean** | Specified if userRoles module should be considered in the deployment process. |  |
|**reporting** | **Boolean** | Specified if reporting module should be considered in the deployment process. |  |
|**sourceTenantId** | **String** | Id of the source tenant. |  |



