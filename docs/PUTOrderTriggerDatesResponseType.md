

# PUTOrderTriggerDatesResponseType


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**processId** | **String** | The ID of the process that handles the operation.  |  [optional] |
|**reasons** | [**List&lt;CommonResponseReasonsInner&gt;**](CommonResponseReasonsInner.md) |  |  [optional] |
|**requestId** | **UUID** | Unique identifier of the request.  |  [optional] |
|**success** | **Boolean** | Indicates whether the call succeeded.  |  [optional] |
|**accountNumber** | **String** | The account number for the order. |  [optional] |
|**orderNumber** | **String** | The order number of the order updated. |  [optional] |
|**status** | [**StatusEnum**](#StatusEnum) | Status of the order. |  [optional] |
|**subscriptions** | [**List&lt;PUTOrderTriggerDatesResponseTypeAllOfSubscriptions&gt;**](PUTOrderTriggerDatesResponseTypeAllOfSubscriptions.md) | The subscriptions updated. |  [optional] |



## Enum: StatusEnum

| Name | Value |
|---- | -----|
| COMPLETED | &quot;Completed&quot; |
| PENDING | &quot;Pending&quot; |



