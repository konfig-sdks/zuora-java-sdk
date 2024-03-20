

# GetOperationJobResponseType


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**id** | **String** | The ID of the operation job to retrieve information about.  |  [optional] |
|**objectId** | **String** | The ID of the business object which is being operated.  |  [optional] |
|**objectType** | [**ObjectTypeEnum**](#ObjectTypeEnum) | The object type of the job.   |  [optional] |
|**operationType** | [**OperationTypeEnum**](#OperationTypeEnum) | The operation type of the job.  |  [optional] |
|**reasons** | [**List&lt;DeleteAccountResponseTypeReasonsInner&gt;**](DeleteAccountResponseTypeReasonsInner.md) |  |  [optional] |
|**status** | [**StatusEnum**](#StatusEnum) | The status of the operation job.   |  [optional] |
|**success** | **Boolean** | Whether the call succeeded.  |  [optional] |



## Enum: ObjectTypeEnum

| Name | Value |
|---- | -----|
| INVOICE | &quot;Invoice&quot; |



## Enum: OperationTypeEnum

| Name | Value |
|---- | -----|
| DELETE | &quot;Delete&quot; |



## Enum: StatusEnum

| Name | Value |
|---- | -----|
| PENDING | &quot;Pending&quot; |
| PROCESSING | &quot;Processing&quot; |
| FAILED | &quot;Failed&quot; |
| COMPLETED | &quot;Completed&quot; |



