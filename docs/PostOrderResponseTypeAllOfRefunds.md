

# PostOrderResponseTypeAllOfRefunds


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**number** | **String** | The refund number. For example, &#x60;R-00009564&#x60;. |  [optional] |
|**refundInvoiceNumbers** | **List&lt;String&gt;** | An array of the refunded invoice numbers generated in this order request. |  [optional] |
|**status** | [**StatusEnum**](#StatusEnum) | The status of the refund. |  [optional] |



## Enum: StatusEnum

| Name | Value |
|---- | -----|
| SUCCESS | &quot;Success&quot; |
| ERROR | &quot;Error&quot; |



