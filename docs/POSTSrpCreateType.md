

# POSTSrpCreateType


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**chargeOverrides** | [**List&lt;POSTScCreateType&gt;**](POSTScCreateType.md) | This optional container is used to override the quantity of one or more product rate plan charges for this subscription.  |  [optional] |
|**externalCatalogPlanId** | **String** | An external ID of the product rate plan to be added. You can use this field to specify a product rate plan that is imported from an external system. The value of the &#x60;externalCatalogPlanId&#x60; field must match one of the values that are predefined in the &#x60;externallyManagedPlanIds&#x60; field on a product rate plan.  **Note:** If both &#x60;externalCatalogPlanId&#x60; and &#x60;productRatePlanId&#x60; are provided. They must point to the same product rate plan. Otherwise, the request would fail.  |  [optional] |
|**externalIdSourceSystem** | **String** | The ID of the external source system. You can use this field and &#x60;externalCatalogPlanId&#x60; to specify a product rate plan that is imported from an external system.  **Note:** If both &#x60;externalCatalogPlanId&#x60;, &#x60;externalIdSourceSystem&#x60; and &#x60;productRatePlanId&#x60; are provided. They must point to the same product rate plan. Otherwise, the request would fail.  |  [optional] |
|**externallyManagedPlanId** | **String** | Indicates the unique identifier for the rate plan purchased on a third-party store. This field is used to represent a subscription rate plan created through third-party stores.  |  [optional] |
|**productRatePlanId** | **String** | ID of a product rate plan for this subscription.  |  [optional] |
|**productRatePlanNumber** | **String** | Number of a product rate plan for this subscription.  |  [optional] |



