

# PreviewOrderOrderAction


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**addProduct** | [**PreviewOrderRatePlanOverride**](PreviewOrderRatePlanOverride.md) |  |  [optional] |
|**cancelSubscription** | [**CancelSubscription**](CancelSubscription.md) |  |  [optional] |
|**changePlan** | [**CreateChangePlan**](CreateChangePlan.md) |  |  [optional] |
|**changeReason** | **String** | The change reason set for an order action when an order is created.  |  [optional] |
|**createSubscription** | [**PreviewOrderCreateSubscription**](PreviewOrderCreateSubscription.md) |  |  [optional] |
|**customFields** | **Map&lt;String, Object&gt;** | Container for custom fields of an Order Action object.  |  [optional] |
|**ownerTransfer** | [**OwnerTransfer**](OwnerTransfer.md) |  |  [optional] |
|**removeProduct** | [**RemoveProduct**](RemoveProduct.md) |  |  [optional] |
|**renewSubscription** | [**RenewSubscription**](RenewSubscription.md) |  |  [optional] |
|**resume** | [**CreateOrderResume**](CreateOrderResume.md) |  |  [optional] |
|**suspend** | [**CreateOrderSuspend**](CreateOrderSuspend.md) |  |  [optional] |
|**termsAndConditions** | [**CreateOrderTermsAndConditions**](CreateOrderTermsAndConditions.md) |  |  [optional] |
|**triggerDates** | [**List&lt;TriggerDate&gt;**](TriggerDate.md) | Container for the contract effective, service activation, and customer acceptance dates of the order action.   If the service activation date is set as a required field in Default Subscription Settings, skipping this field in a &#x60;CreateSubscription&#x60; order action of your JSON request will result in a &#x60;Pending&#x60; order and a &#x60;Pending Activation&#x60; subscription.  If the customer acceptance date is set as a required field in Default Subscription Settings, skipping this field in a &#x60;CreateSubscription&#x60; order action of your JSON request will result in a &#x60;Pending&#x60; order and a &#x60;Pending Acceptance&#x60; subscription. If the service activation date field is at the same time required and skipped (or set as null), it will be a &#x60;Pending Activation&#x60; subscription.  |  [optional] |
|**type** | [**TypeEnum**](#TypeEnum) | Type of order action.  Unless the type of order action is &#x60;RenewSubscription&#x60;, you must use the corresponding field to provide information about the order action. For example, if the type of order action is &#x60;AddProduct&#x60;, you must set the &#x60;addProduct&#x60; field.  Zuora returns an error if you set a field that corresponds to a different type of order action. For example, if the type of order action is &#x60;AddProduct&#x60;, Zuora returns an error if you set the &#x60;updateProduct&#x60; field.  **Note**: The change plan type of order action is currently not supported for Billing - Revenue Integration. When Billing - Revenue Integration is enabled, the change plan type of order action will no longer be applicable in Zuora Billing.  |  |
|**updateProduct** | [**PreviewOrderRatePlanUpdate**](PreviewOrderRatePlanUpdate.md) |  |  [optional] |



## Enum: TypeEnum

| Name | Value |
|---- | -----|
| CREATESUBSCRIPTION | &quot;CreateSubscription&quot; |
| TERMSANDCONDITIONS | &quot;TermsAndConditions&quot; |
| ADDPRODUCT | &quot;AddProduct&quot; |
| UPDATEPRODUCT | &quot;UpdateProduct&quot; |
| REMOVEPRODUCT | &quot;RemoveProduct&quot; |
| RENEWSUBSCRIPTION | &quot;RenewSubscription&quot; |
| CANCELSUBSCRIPTION | &quot;CancelSubscription&quot; |
| OWNERTRANSFER | &quot;OwnerTransfer&quot; |
| SUSPEND | &quot;Suspend&quot; |
| RESUME | &quot;Resume&quot; |
| CHANGEPLAN | &quot;ChangePlan&quot; |



