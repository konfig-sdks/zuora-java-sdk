

# MetadataCompareDeployProductCatalogRequest


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**description** | **String** | Deployment&#39;s description. |  |
|**name** | **String** | Deployment&#39;s name. |  |
|**sendEmail** | **Boolean** | Specifies if an email should be sent. |  |
|**emails** | **String** | If sendEmail parameter is set to true, comma separated values of emails can be specified. Example  email1@test.com,email2@test.com. |  [optional] |
|**comments** | **String** | Content of the email to be sent. |  [optional] |
|**inActiveProducts** | **Boolean** | Specifies if inactive products needs to be migrated. |  |
|**activeProducts** | **Boolean** | Specifies if active products needs to be migrated. |  |
|**activeRatePlans** | **Boolean** | Specifies if active rate plans needs to be migrated. |  |
|**inActiveRatePlans** | **Boolean** | Specifies if inactive active rate plans needs to be migrated. |  |
|**compareField** | [**CompareFieldEnum**](#CompareFieldEnum) | Specifies the compare field to be using during migration. |  |
|**sourceTenantId** | **String** | Specifies the source tenant id. |  |



## Enum: CompareFieldEnum

| Name | Value |
|---- | -----|
| NAME | &quot;name&quot; |
| SKU | &quot;sku&quot; |



