

# GetJobStatusAndResponseResponse


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**errors** | **String** | Error messages returned if the job failed. |  [optional] |
|**result** | [**JobResult**](JobResult.md) |  |  [optional] |
|**status** | [**StatusEnum**](#StatusEnum) | Type of job status. |  [optional] |
|**success** | **Boolean** | Indicates whether the operation call succeeded. |  [optional] |



## Enum: StatusEnum

| Name | Value |
|---- | -----|
| PROCESSING | &quot;Processing&quot; |
| FAILED | &quot;Failed&quot; |
| COMPLETED | &quot;Completed&quot; |



