

# GetWorkflowResponse


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**cpuTime** | **String** | The overall CPU time for the execution of the workflow.  |  [optional] |
|**createdAt** | **String** | The date and time when the workflow is created, in the &#x60;YYYY-MM-DD HH:MM:SS&#x60; format..  |  [optional] |
|**finishedAt** | **String** | The date and time when the execution of the workflow completes, in the &#x60;YYYY-MM-DD HH:MM:SS&#x60; format.  |  [optional] |
|**id** | **Integer** | The unique ID of the workflow.  |  [optional] |
|**messages** | **Object** | Messages from tasks.   **Note:** This field is only returned in Production.  |  [optional] |
|**name** | **String** | The unique run number of the workflow.  |  [optional] |
|**originalWorkflowId** | **String** | The ID of the workflow setup.  |  [optional] |
|**runTime** | **Double** | The execution time of the workflow including the waiting time, in seconds.  |  [optional] |
|**status** | [**StatusEnum**](#StatusEnum) | The status of the workflow:   - Queued: The workflow is in queue for being processed.   - Processing: The workflow is in process.   - Stopping: The workflow is being stopped through Zuora UI.   - Stopped: The workflow is stopped through Zuora UI.   - Finished: The workflow is finished. When a workflow is finished, it might have tasks pending for retry or delay. Pending tasks do not block the onfinish branch of the workflow, but they block the oncomplete branch of the iterate.   |  [optional] |
|**tasks** | [**GetWorkflowResponseTasks**](GetWorkflowResponseTasks.md) |  |  [optional] |
|**type** | **String** | The type of the current workflow. Possible values:   - &#x60;Workflow::Setup&#x60;: The workflow is a setup and is used for creating workflow instances.   - &#x60;Workflow::Instance&#x60;: The workflow is an execution that has data.  |  [optional] |
|**updatedAt** | **String** | The date and time when the workflow is updated the last time, in the &#x60;YYYY-MM-DD HH:MM:SS&#x60; format.  |  [optional] |



## Enum: StatusEnum

| Name | Value |
|---- | -----|
| QUEUED | &quot;Queued&quot; |
| PROCESSING | &quot;Processing&quot; |
| STOPPING | &quot;Stopping&quot; |
| STOPPED | &quot;Stopped&quot; |
| FINISHED | &quot;Finished&quot; |



