

# RegenerateBookingRequest


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**itemNumber** | **String** | The item number.  |  [optional] |
|**orderLineItemId** | **String** | The order line item ID.  |  [optional] |
|**orderNumber** | **String** | The order number.  |  [optional] |
|**subscriptionId** | **String** | The subscription ID.  |  [optional] |
|**subscriptionNumber** | **String** | The subscription number.  |  [optional] |
|**subscriptionVersion** | **Integer** | The subscription version.  |  [optional] |
|**type** | [**TypeEnum**](#TypeEnum) | The type of business object for which you want to generate the transactions.  |  [optional] |



## Enum: TypeEnum

| Name | Value |
|---- | -----|
| SUBSCRIPTION | &quot;Subscription&quot; |
| ORDERLINEITEM | &quot;OrderLineItem&quot; |



