

# DeploymentManagerResponse


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**id** | **String** | ID of the Deployment Manager migration process |  [optional] |
|**status** | [**StatusEnum**](#StatusEnum) | Status of the Deployment Manager migration process |  [optional] |



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



