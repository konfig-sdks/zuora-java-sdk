

# ChargeUpdate

The JSON object containing the information for a charge update in the 'UpdateProduct' type order action.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**description** | **String** |  |  [optional] |
|**billing** | [**BillingUpdate**](BillingUpdate.md) |  |  [optional] |
|**chargeNumber** | **String** | The number of the charge to be updated. The value of this field is inherited from the &#x60;subscriptions&#x60; &gt; &#x60;orderActions&#x60; &gt; &#x60;addProduct&#x60; &gt; &#x60;chargeOverrides&#x60; &gt; &#x60;chargeNumber&#x60; field.   |  [optional] |
|**customFields** | **Map&lt;String, Object&gt;** | Container for custom fields of a Rate Plan Charge object.  |  [optional] |
|**effectiveDate** | [**TriggerParams**](TriggerParams.md) |  |  [optional] |
|**pricing** | [**PricingUpdate**](PricingUpdate.md) | Pricing information about the charge.  |  [optional] |
|**uniqueToken** | **String** | description: |   A unique string to represent the rate plan charge in the order. The unique token is used to perform multiple actions against a newly added rate plan charge. For example, if you want to add and update a product in the same order, assign a unique token to the newly added rate plan charge and use that token in future order actions.  |  [optional] |



