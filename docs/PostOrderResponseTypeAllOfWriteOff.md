

# PostOrderResponseTypeAllOfWriteOff


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**amount** | **Double** | The amount written off from the invoice balance. |  [optional] |
|**failedReason** | **String** | The reason of write-off failure. |  [optional] |
|**invoiceNumber** | **String** | The number of the invoice that is written off. For example, &#x60;INV00051208&#x60;. |  [optional] |
|**status** | [**StatusEnum**](#StatusEnum) | The status of the write-off. |  [optional] |
|**writeOffCreditMemoNumber** | **String** | The number of the credit memo that is written off. |  [optional] |



## Enum: StatusEnum

| Name | Value |
|---- | -----|
| SUCCESS | &quot;Success&quot; |
| FAILED | &quot;Failed&quot; |



