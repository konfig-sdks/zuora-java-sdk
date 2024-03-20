

# GETAdjustmentsResponseType


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**processId** | **String** | The ID of the process that handles the operation.  |  [optional] |
|**reasons** | [**List&lt;CommonResponseReasonsInner&gt;**](CommonResponseReasonsInner.md) |  |  [optional] |
|**requestId** | **UUID** | Unique identifier of the request.  |  [optional] |
|**success** | **Boolean** | Indicates whether the call succeeded.  |  [optional] |
|**adjustments** | [**List&lt;POSTAdjustmentResponseType&gt;**](POSTAdjustmentResponseType.md) | Container for delivery adjustments of a subscription.  |  [optional] |
|**ineligibleAdjustments** | [**List&lt;POSTIneligibleAdjustmentResponseType&gt;**](POSTIneligibleAdjustmentResponseType.md) | Container for ineligible delivery adjustments of a subscription.  |  [optional] |
|**totalAmount** | **BigDecimal** | The total amount of all the delivery adjustments.  |  [optional] |
|**totalNumberOfDeliveries** | **Double** | The total number of all delivery adjustments.  |  [optional] |



