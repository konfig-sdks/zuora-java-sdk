

# GetOrderActionRatePlanResponse


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**processId** | **String** | The ID of the process that handles the operation.  |  [optional] |
|**reasons** | [**List&lt;CommonResponseReasonsInner&gt;**](CommonResponseReasonsInner.md) |  |  [optional] |
|**requestId** | **UUID** | Unique identifier of the request.  |  [optional] |
|**success** | **Boolean** | Indicates whether the call succeeded.  |  [optional] |
|**amendment** | [**OrderActionRatePlanAmendment**](OrderActionRatePlanAmendment.md) |  |  [optional] |
|**externallyManagedPlanId** | **String** | The unique identifier for the rate plan purchased on a third-party store. This field is used to represent a subscription rate plan created through third-party stores.  |  [optional] |
|**id** | **String** | Unique subscription rate-plan ID. |  [optional] |
|**lastChangeType** | **String** | Latest change type. Possible values are:  - New - Update - Remove  |  [optional] |
|**order** | [**OrderActionRatePlanOrder**](OrderActionRatePlanOrder.md) |  |  [optional] |
|**productId** | **String** | Product ID  |  [optional] |
|**productName** | **String** | The name of the product.  |  [optional] |
|**productRatePlanId** | **String** | Product rate plan ID  |  [optional] |
|**productSku** | **String** | The unique SKU for the product.  |  [optional] |
|**ratePlanName** | **String** | The name of the rate plan.  |  [optional] |
|**subscriptionId** | **String** | Subscription ID.  |  [optional] |
|**subscriptionVersion** | **Object** | The version of the subscription.  |  [optional] |



