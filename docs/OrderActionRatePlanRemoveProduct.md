

# OrderActionRatePlanRemoveProduct

Information about an order action of type `RemoveProduct`. 

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**ratePlanId** | **String** | Internal identifier of the rate plan to remove.  |  [optional] |
|**uniqueToken** | **String** | A unique string to represent the rate plan charge in the order. The unique token is used to perform multiple actions against a newly added rate plan. For example, if you want to add and update a product in the same order, you would assign a unique token to the product rate plan when added and use that token in future order actions.A unique string in the order to represent the rate plan. |  [optional] |



