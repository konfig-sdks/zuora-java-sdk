

# RemoveProduct

Information about an order action of type `RemoveProduct`. 

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**externalCatalogPlanId** | **String** | An external ID of the rate plan to be removed. You can use this field to specify an existing rate plan in your subscription. The value of the &#x60;externalCatalogPlanId&#x60; field must match one of the values that are predefined in the &#x60;externallyManagedPlanIds&#x60; field on a product rate plan. However, if there are multiple rate plans with the same &#x60;productRatePlanId&#x60; value existing in the subscription, you must use the &#x60;ratePlanId&#x60; field to remove the rate plan. The &#x60;externalCatalogPlanId&#x60; field cannot be used to distinguish multiple rate plans in this case.  **Note:** If both &#x60;externalCatalogPlanId&#x60; and &#x60;ratePlanId&#x60; are provided. They must point to the same product rate plan. Otherwise, the request would fail.  |  [optional] |
|**productRatePlanNumber** | **String** | Number of a product rate plan for this subscription.  |  [optional] |
|**ratePlanId** | **String** | ID of the rate plan to remove. This can be the latest version or any history version of ID.  |  [optional] |
|**subscriptionRatePlanNumber** | **String** | Number of a rate plan for this subscription.  |  [optional] |
|**uniqueToken** | **String** | Unique identifier for the rate plan. This identifier enables you to refer to the rate plan before the rate plan has an internal identifier in Zuora. |  [optional] |
|**customFields** | **Map&lt;String, Object&gt;** | Container for custom fields of a Rate Plan object.  |  [optional] |
|**chargeUpdates** | [**List&lt;OrderActionRatePlanChargeRemove&gt;**](OrderActionRatePlanChargeRemove.md) |  |  [optional] |



