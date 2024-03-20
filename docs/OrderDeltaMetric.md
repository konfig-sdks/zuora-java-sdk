

# OrderDeltaMetric


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**chargeNumber** | **String** | The charge number for the associated Rate Plan Charge. This field can be null if the metric is generated for an Order Line Item.  |  [optional] |
|**currency** | **String** | ISO 3-letter currency code (uppercase). For example, USD.  |  [optional] |
|**endDate** | **LocalDate** | The end date for the order delta metric.  |  [optional] |
|**grossAmount** | **Double** | The gross amount for the metric. The is the amount excluding applied discount.  |  [optional] |
|**netAmount** | **Double** | The net amount for the metric. The is the amount with discounts applied  |  [optional] |
|**orderActionId** | **String** | The Id for the related Order Action. This field can be null if the metric is generated for an Order Line Item.  |  [optional] |
|**orderActionSequence** | **String** | The sequence for the related Order Action. This field can be null if the metric is generated for an Order Line Item.  |  [optional] |
|**orderActionType** | **String** | The type for the related Order Action. This field can be null if the metric is generated for an Order Line Item.  |  [optional] |
|**orderLineItemNumber** | **String** | A sequential number auto-assigned for each of order line items in a order, used as an index, for example, \&quot;1\&quot;.  |  [optional] |
|**productRatePlanChargeId** | **String** | The Id for the associated Product Rate Plan Charge. This field can be null if the Order Line Item is not associated with a Product Rate Plan Charge.  |  [optional] |
|**ratePlanChargeId** | **String** | The id for the associated Rate Plan Charge. This field can be null if the metric is generated for an Order Line Item.  |  [optional] |
|**startDate** | **LocalDate** | The start date for the order delta metric.  |  [optional] |
|**subscriptionNumber** | **String** | The number of the subscription. This field can be null if the metric is generated for an Order Line Item.  |  [optional] |



