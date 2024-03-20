

# OrderActionRatePlanChargeUpdate

The JSON object containing the information for a charge update in the 'UpdateProduct' type order action.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**description** | **String** | Description of the charge.  |  [optional] |
|**billing** | [**OrderActionRatePlanBillingUpdate**](OrderActionRatePlanBillingUpdate.md) | Billing information about the charge.  |  [optional] |
|**chargeNumber** | **String** | Read only. Identifies the charge to be updated.  |  [optional] |
|**customFields** | **Map&lt;String, Object&gt;** | Container for custom fields of a Rate Plan Charge object.  |  [optional] |
|**effectiveDate** | [**OrderActionRatePlanTriggerParams**](OrderActionRatePlanTriggerParams.md) |  |  [optional] |
|**pricing** | [**OrderActionRatePlanPricingUpdate**](OrderActionRatePlanPricingUpdate.md) | Pricing information about the charge.  |  [optional] |
|**uniqueToken** | **String** | A unique string to represent the rate plan charge in the order. The unique token is used to perform multiple actions against a newly added rate plan. For example, if you want to add and update a product in the same order, you would assign a unique token to the product rate plan when added and use that token in future order actions.  |  [optional] |



