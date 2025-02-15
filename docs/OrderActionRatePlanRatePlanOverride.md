

# OrderActionRatePlanRatePlanOverride

Rate plan associated with a subscription. 

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**chargeOverrides** | [**List&lt;OrderActionRatePlanChargeOverride&gt;**](OrderActionRatePlanChargeOverride.md) | List of charges associated with the rate plan.  |  [optional] |
|**customFields** | **Map&lt;String, Object&gt;** | Container for custom fields of a Rate Plan object.  |  [optional] |
|**newRatePlanId** | **String** | Internal identifier of the rate plan.  |  [optional] |
|**productRatePlanId** | **String** | Internal identifier of the product rate plan that the rate plan is based on.  |  |
|**uniqueToken** | **String** | Unique identifier for the rate plan. This identifier enables you to refer to the rate plan before the rate plan has an internal identifier in Zuora.  For instance, suppose that you want to use a single order to add a product to a subscription and later update the same product. When you add the product, you can set a unique identifier for the rate plan. Then when you update the product, you can use the same unique identifier to specify which rate plan to modify.  |  [optional] |



