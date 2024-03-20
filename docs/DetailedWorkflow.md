

# DetailedWorkflow

A workflow. 

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**description** | **String** | The description of the workflow.  |  [optional] |
|**version** | **String** | The version number of the active workflow version.              |  [optional] |
|**callType** | **String** | The call type of the active workflow version.  |  [optional] |
|**calloutTrigger** | **Boolean** | Indicates whether the callout trigger is enabled for the retrieved workflow.  |  [optional] |
|**createdAt** | **String** | The date and time when the workflow is created, in the &#x60;YYYY-MM-DD HH:MM:SS&#x60; format.  |  [optional] |
|**finishedAt** | **String** | The date and time when the instance of the workflow version finished at.  |  [optional] |
|**id** | **Integer** | The unique ID of the workflow.  |  [optional] |
|**interval** | **String** | The schedule of the workflow, in a CRON expression. Returns null if the schedued trigger is disabled.  |  [optional] |
|**name** | **String** | The name of the workflow.  |  [optional] |
|**ondemandTrigger** | **Boolean** | Indicates whether the ondemand trigger is enabled for the workflow.  |  [optional] |
|**originalWorkflowId** | **Integer** | The unique ID of the original workflow version.  |  [optional] |
|**priority** | **String** | The priority of the active workflow version.   |  [optional] |
|**scheduledTrigger** | **Boolean** | Indicates whether the scheduled trigger is enabled for the workflow.  |  [optional] |
|**startedAt** | **String** | The date and time when the instance of the workflow version started at.  |  [optional] |
|**status** | **Integer** | The status of the active workflow version.  |  [optional] |
|**syncTrigger** | **Boolean** | Indicates whether the workflow version is enabled for the sync mode.  |  [optional] |
|**timezone** | **String** | The timezone that is configured for the scheduler of the workflow. Returns null if the scheduled trigger is disabled.  |  [optional] |
|**type** | [**TypeEnum**](#TypeEnum) | The type of the workflow. Currently the only valid value is &#39;Workflow::Setup&#39;.  |  [optional] |
|**updatedAt** | **String** | The date and time when the workflow is updated the last time, in the &#x60;YYYY-MM-DD HH:MM:SS&#x60; format.  |  [optional] |



## Enum: TypeEnum

| Name | Value |
|---- | -----|
| SETUP | &quot;Workflow::Setup&quot; |
| INSTANCE | &quot;Workflow::Instance&quot; |



