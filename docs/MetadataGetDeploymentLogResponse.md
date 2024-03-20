

# MetadataGetDeploymentLogResponse


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**description** | **String** | Description of the migration. |  [optional] |
|**id** | **String** | ID of the migration process. |  [optional] |
|**name** | **String** | Name of the migration. |  [optional] |
|**status** | **String** | Migration status. |  [optional] |
|**targetTenant** | [**MetadataGetDeploymentLogResponseTargetTenant**](MetadataGetDeploymentLogResponseTargetTenant.md) |  |  [optional] |
|**deploymentDate** | **String** | Deployment timestamp. |  [optional] |
|**runBy** | **String** | Name of the user who executed the migration. |  [optional] |
|**succeeded** | [**List&lt;MetadataGetDeploymentLogResponseSucceededInner&gt;**](MetadataGetDeploymentLogResponseSucceededInner.md) |  |  [optional] |
|**failed** | [**List&lt;MetadataGetDeploymentLogResponseFailedInner&gt;**](MetadataGetDeploymentLogResponseFailedInner.md) |  |  [optional] |
|**skipped** | [**List&lt;MetadataGetDeploymentLogResponseSkippedInner&gt;**](MetadataGetDeploymentLogResponseSkippedInner.md) |  |  [optional] |



