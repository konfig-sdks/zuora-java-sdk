

# MetadataRevertDeploymentResponse


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**description** | **String** | Description of the Deployment Manager migration process. |  [optional] |
|**id** | **String** | ID of the Deployment Manager migration process. |  [optional] |
|**name** | **String** | Name of the Deployment Manager migration process. |  [optional] |
|**sourceTenantName** | **String** | Name of the source Tenant. |  [optional] |
|**sourceTenantDescription** | **String** | Description of the source Tenant. |  [optional] |
|**status** | [**StatusEnum**](#StatusEnum) | Status of the Deployment Manager migration process. |  [optional] |
|**startTime** | **String** | start timestamp of the Deployment Manager migration process. |  [optional] |
|**endTime** | **String** | end timestamp of the Deployment Manager migration process. |  [optional] |
|**migratedBy** | **String** | User who initiated the Deployment Manager migration process. |  [optional] |
|**type** | **String** | Type of the Deployment Manager migration process. |  [optional] |
|**environment** | **String** | Environment of the Deployment Manager migration process. |  [optional] |
|**emailIds** | **String** | emailIds notified of the Deployment Manager migration process. |  [optional] |
|**productCatalog** | **Boolean** | Boolean flag specifies if the migration process includes product catalog module. |  [optional] |
|**errors** | **String** | Errors of the Deployment Manager migration process. |  [optional] |



## Enum: StatusEnum

| Name | Value |
|---- | -----|
| DEPLOYING | &quot;DEPLOYING&quot; |
| REVERTING | &quot;REVERTING&quot; |
| PARTIALLY_REVERTED | &quot;PARTIALLY-REVERTED&quot; |
| FAILED | &quot;FAILED&quot; |
| ROLLBACK_FAILED | &quot;ROLLBACK-FAILED&quot; |
| REVERTED | &quot;REVERTED&quot; |
| COMPARING | &quot;COMPARING&quot; |
| SUBMITTED | &quot;SUBMITTED&quot; |
| SKIPPED | &quot;SKIPPED&quot; |
| IDENTICAL | &quot;IDENTICAL&quot; |
| COMPARE_DONE | &quot;COMPARE-DONE&quot; |
| COMPARE_FAILED | &quot;COMPARE-FAILED&quot; |
| CANCELLED | &quot;CANCELLED&quot; |



