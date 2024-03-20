

# Linkage

Used to represent the relationship between workflow tasks

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**linkageType** | [**LinkageTypeEnum**](#LinkageTypeEnum) |  |  [optional] |
|**sourceTaskId** | **Integer** | the task that spawned the target task |  [optional] |
|**sourceWorkflowId** | **Integer** | the workflow the target task is associated with |  [optional] |
|**targetTaskId** | **Integer** | the task that the source task is linked to. |  [optional] |



## Enum: LinkageTypeEnum

| Name | Value |
|---- | -----|
| START | &quot;Start&quot; |
| SUCCESS | &quot;Success&quot; |
| FAILURE | &quot;Failure&quot; |
| ITERATE | &quot;Iterate&quot; |
| TRUE | &quot;True&quot; |
| FALSE | &quot;False&quot; |
| APPROVE | &quot;Approve&quot; |
| REJECT | &quot;Reject&quot; |



