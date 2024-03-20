

# WorkflowInstance

A instance workflow object.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**createdAt** | **String** | The date and time when the workflow is created, in the &#x60;YYYY-MM-DD HH:MM:SS&#x60; format.  |  [optional] |
|**id** | **Integer** | The unique ID of the workflow.  |  [optional] |
|**name** | **String** | The run number of this workflow instance  |  [optional] |
|**originalWorkflowId** | **Integer** | The identifier of the workflow template that is used to create this instance.  |  [optional] |
|**status** | [**StatusEnum**](#StatusEnum) | Describes the current state of this workflow instance:   - Queued: The workflow is in queue for being processed.   - Processing: The workflow is in process.  |  [optional] |
|**updatedAt** | **String** | The date and time the last time when the workflow is updated, in the &#x60;YYYY-MM-DD HH:MM:SS&#x60; format.  |  [optional] |



## Enum: StatusEnum

| Name | Value |
|---- | -----|
| QUEUED | &quot;Queued&quot; |
| PROCESSING | &quot;Processing&quot; |



