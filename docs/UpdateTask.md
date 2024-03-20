

# UpdateTask

A task. 

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**tags** | **List&lt;String&gt;** | The array of filter tags.  |  [optional] |
|**actionType** | **String** | The type of task.  |  [optional] |
|**callType** | **String** | The type of the API used.  |  [optional] |
|**concurrentLimit** | **Integer** | The maximum number of this task that can run concurrently.  |  [optional] |
|**id** | **Integer** | The unique ID of the task.  |  |
|**name** | **String** | The name of the task.  |  [optional] |
|**_object** | **String** | The selected object for the task.  |  [optional] |
|**objectId** | **String** | The ID of the selected object of the task.  |  [optional] |
|**status** | [**StatusEnum**](#StatusEnum) | The status of the task instance.  |  [optional] |
|**workflowId** | **Integer** | The ID of the workflow the task belongs to.  |  [optional] |



## Enum: StatusEnum

| Name | Value |
|---- | -----|
| QUEUED | &quot;Queued&quot; |
| PROCESSING | &quot;Processing&quot; |
| PENDING | &quot;Pending&quot; |
| SUCCESS | &quot;Success&quot; |
| STOPPED | &quot;Stopped&quot; |
| ERROR | &quot;Error&quot; |



