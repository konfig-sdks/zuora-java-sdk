

# PUTOrderTriggerDatesResponseTypeAllOf


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**accountNumber** | **String** | The account number for the order. |  [optional] |
|**orderNumber** | **String** | The order number of the order updated. |  [optional] |
|**status** | [**StatusEnum**](#StatusEnum) | Status of the order. |  [optional] |
|**subscriptions** | [**List&lt;PUTOrderTriggerDatesResponseTypeAllOfSubscriptions&gt;**](PUTOrderTriggerDatesResponseTypeAllOfSubscriptions.md) | The subscriptions updated. |  [optional] |



## Enum: StatusEnum

| Name | Value |
|---- | -----|
| COMPLETED | &quot;Completed&quot; |
| PENDING | &quot;Pending&quot; |



