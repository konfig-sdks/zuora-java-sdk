

# OrderActionRatePlanOrderAction

Represents the processed order action.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**addProduct** | [**OrderActionRatePlanRatePlanOverride**](OrderActionRatePlanRatePlanOverride.md) |  |  [optional] |
|**customFields** | **Map&lt;String, Object&gt;** | Container for custom fields of an Order Action object.  |  [optional] |
|**id** | **String** | The Id of the order action processed in the order. |  [optional] |
|**removeProduct** | [**OrderActionRatePlanRemoveProduct**](OrderActionRatePlanRemoveProduct.md) |  |  [optional] |
|**type** | [**TypeEnum**](#TypeEnum) | Type of the order action. |  [optional] |
|**updateProduct** | [**OrderActionRatePlanRatePlanUpdate**](OrderActionRatePlanRatePlanUpdate.md) |  |  [optional] |



## Enum: TypeEnum

| Name | Value |
|---- | -----|
| ADDPRODUCT | &quot;AddProduct&quot; |
| UPDATEPRODUCT | &quot;UpdateProduct&quot; |
| REMOVEPRODUCT | &quot;RemoveProduct&quot; |



