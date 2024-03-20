

# NotificationsHistoryDeletionTaskResponse

The notification history deletion task information.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**accountId** | **UUID** | The ID of the account whose notification histories are deleted by the current deletion task. |  [optional] |
|**createdBy** | **UUID** | The ID of the user who submits the notification history deletion task. |  [optional] |
|**createdOn** | **Integer** | The timestamp when the notification history deletion task is created. |  [optional] |
|**id** | **UUID** | The ID of the notification history deletion task. |  [optional] |
|**status** | [**StatusEnum**](#StatusEnum) | The status of the notification history deletion task. |  [optional] |
|**tenantId** | **String** | The ID of the tenant where the notification history deletion task runs. |  [optional] |



## Enum: StatusEnum

| Name | Value |
|---- | -----|
| RUNNING | &quot;RUNNING&quot; |
| FINISHED | &quot;FINISHED&quot; |
| FAILED | &quot;FAILED&quot; |



