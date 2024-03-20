

# OrderActionRatePlanChargeRemove

The JSON object containing the information for a charge update(custom fields only) in the 'RemoveProduct' type order action. A custom field of rate plan charge can be updated from a subscription through one order action. - If you update customFields of a charge while removing a rate plan, specify the following fields:   - `chargeNumber`   - `productRatePlanChargeId`   - `productRatePlanNumber`   - `uniqueToken`   - `customFields` 

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**chargeNumber** | **String** | Read only. Identifies the charge to be updated.  |  [optional] |
|**productRatePlanChargeId** | **String** | Identifier of the rate plan that was updated.  |  [optional] |
|**productRatePlanNumber** | **String** | Number of a product rate plan for this subscription.  |  [optional] |
|**uniqueToken** | **String** | A unique string to represent the rate plan charge in the order. The unique token is used to perform multiple actions against a newly added rate plan. For example, if you want to add and update a product in the same order, you would assign a unique token to the product rate plan when added and use that token in future order actions.  |  [optional] |
|**customFields** | **Map&lt;String, Object&gt;** | Container for custom fields of a Rate Plan Charge object.  |  [optional] |



