

# PutOrderCancelResponse


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**processId** | **String** | The ID of the process that handles the operation.  |  [optional] |
|**reasons** | [**List&lt;CommonResponseReasonsInner&gt;**](CommonResponseReasonsInner.md) |  |  [optional] |
|**requestId** | **UUID** | Unique identifier of the request.  |  [optional] |
|**success** | **Boolean** | Indicates whether the call succeeded.  |  [optional] |
|**accountNumber** | **String** | The account number for the order. |  [optional] |
|**cancelReason** | **String** | The reason for cancelling the order. |  [optional] |
|**orderNumber** | **String** | The order number of the order created. |  [optional] |
|**status** | [**StatusEnum**](#StatusEnum) | Status of the order. &#x60;Cancelled&#x60; is only valid value. |  [optional] |



## Enum: StatusEnum

| Name | Value |
|---- | -----|
| CANCELLED | &quot;Cancelled&quot; |



