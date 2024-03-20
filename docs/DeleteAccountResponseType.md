

# DeleteAccountResponseType


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**id** | **String** | The ID of the deleted account.  |  [optional] |
|**jobId** | **String** | The ID of the job that handles the account deletion operation.   You can specify the value of this field as the value of the &#x60;jobId&#x60; path parameter in the [Retrieve an operation job](https://developer.zuora.com/api-references/api/operation/GET_OperationJob/) API operation to query job information.  |  [optional] |
|**jobStatus** | [**JobStatusEnum**](#JobStatusEnum) | The status of the account deletion operation.   |  [optional] |
|**reasons** | [**List&lt;DeleteAccountResponseTypeReasonsInner&gt;**](DeleteAccountResponseTypeReasonsInner.md) |  |  [optional] |
|**success** | **Boolean** | Whether the call succeeded.  |  [optional] |



## Enum: JobStatusEnum

| Name | Value |
|---- | -----|
| PENDING | &quot;Pending&quot; |



