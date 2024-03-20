

# CreateOrderOrderAction


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**addProduct** | [**CreateOrderRatePlanOverride**](CreateOrderRatePlanOverride.md) |  |  [optional] |
|**cancelSubscription** | [**CancelSubscription**](CancelSubscription.md) |  |  [optional] |
|**changePlan** | [**CreateChangePlan**](CreateChangePlan.md) |  |  [optional] |
|**changeReason** | **String** | The change reason set for an order action when an order is created.  |  [optional] |
|**createSubscription** | [**CreateOrderCreateSubscription**](CreateOrderCreateSubscription.md) |  |  [optional] |
|**customFields** | **Map&lt;String, Object&gt;** | Container for custom fields of an Order Action object.  |  [optional] |
|**ownerTransfer** | [**OwnerTransfer**](OwnerTransfer.md) |  |  [optional] |
|**removeProduct** | [**RemoveProduct**](RemoveProduct.md) |  |  [optional] |
|**renewSubscription** | [**RenewSubscription**](RenewSubscription.md) |  |  [optional] |
|**resume** | [**CreateOrderResume**](CreateOrderResume.md) |  |  [optional] |
|**suspend** | [**CreateOrderSuspend**](CreateOrderSuspend.md) |  |  [optional] |
|**termsAndConditions** | [**CreateOrderTermsAndConditions**](CreateOrderTermsAndConditions.md) |  |  [optional] |
|**triggerDates** | [**List&lt;TriggerDate&gt;**](TriggerDate.md) | Container for the contract effective, service activation, and customer acceptance dates of the order action.   If [Zuora is configured to require service activation](https://knowledgecenter.zuora.com/CB_Billing/Billing_Settings/Define_Default_Subscription_Settings#Require_Service_Activation_of_Orders.3F) and the &#x60;ServiceActivation&#x60; field is not set for a &#x60;CreateSubscription&#x60; order action, a &#x60;Pending&#x60; order and a &#x60;Pending Activation&#x60; subscription are created.  If [Zuora is configured to require customer acceptance](https://knowledgecenter.zuora.com/CB_Billing/Billing_Settings/Define_Default_Subscription_Settings#Require_Customer_Acceptance_of_Orders.3F) and the &#x60;CustomerAcceptance&#x60; field is not set for a &#x60;CreateSubscription&#x60; order action, a &#x60;Pending&#x60; order and a &#x60;Pending Acceptance&#x60; subscription are created. At the same time, if the service activation date field is also required and not set, a &#x60;Pending&#x60; order and a &#x60;Pending Activation&#x60; subscription are created instead.  If [Zuora is configured to require service activation](https://knowledgecenter.zuora.com/CB_Billing/Billing_Settings/Define_Default_Subscription_Settings#Require_Service_Activation_of_Orders.3F) and the &#x60;ServiceActivation&#x60; field is not set for either of the following order actions, a &#x60;Pending&#x60; order is created. The subscription status is not impacted. **Note:** This feature is in **Limited Availability**. If you want to have access to the feature, submit a request at [Zuora Global Support](http://support.zuora.com/).  * AddProduct  * UpdateProduct  * RemoveProduct  * RenewSubscription  * TermsAndConditions  If [Zuora is configured to require customer acceptance](https://knowledgecenter.zuora.com/CB_Billing/Billing_Settings/Define_Default_Subscription_Settings#Require_Customer_Acceptance_of_Orders.3F) and the &#x60;CustomerAcceptance&#x60; field is not set for either of the following order actions, a &#x60;Pending&#x60; order is created. The subscription status is not impacted. **Note:** This feature is in **Limited Availability**. If you want to have access to the feature, submit a request at [Zuora Global Support](http://support.zuora.com/).  * AddProduct  * UpdateProduct  * RemoveProduct  * RenewSubscription  * TermsAndConditions  |  [optional] |
|**type** | [**TypeEnum**](#TypeEnum) | Type of order action.  Unless the type of order action is &#x60;RenewSubscription&#x60;, you must use the corresponding field to provide information about the order action. For example, if the type of order action is &#x60;AddProduct&#x60;, you must set the &#x60;addProduct&#x60; field.  Zuora returns an error if you set a field that corresponds to a different type of order action. For example, if the type of order action is &#x60;AddProduct&#x60;, Zuora returns an error if you set the &#x60;updateProduct&#x60; field.  A [pending order](https://knowledgecenter.zuora.com/BC_Subscription_Management/Orders/Pending_Order_and_Subscription) supports the following order actions:  * CreateSubscription  * AddProduct  * UpdateProduct  * RemoveProduct  * RenewSubscription  * TermsAndConditions  * ChangePlan  However, pending orders created through all order actions except for \&quot;Create new subscription\&quot;:  * Do not impact the subscription status.  * Are in **Limited Availability**. If you want to have access to the feature, submit a request at [Zuora Global Support](https://support.zuora.com).   A pending order is created in either of the following conditions:  * [Zuora is configured to require service activation](https://knowledgecenter.zuora.com/CB_Billing/Billing_Settings/Define_Default_Subscription_Settings#Require_Service_Activation_of_Orders.3F) and the service activation date is not set in your \&quot;Create an order\&quot; call.  * [Zuora is configured to require customer acceptance](https://knowledgecenter.zuora.com/CB_Billing/Billing_Settings/Define_Default_Subscription_Settings#Require_Customer_Acceptance_of_Orders.3F) and the customer acceptance date is not set in your \&quot;Create an order\&quot; call.  * When a charge in the subscription has its &#x60;triggerEvent&#x60; field set as &#x60;SpecificDate&#x60; and the &#x60;specificTriggerDate&#x60; field is not set in your \&quot;Create an order\&quot; API call.  **Note**: The change plan type of order action is currently not supported for Billing - Revenue Integration. When Billing - Revenue Integration is enabled, the change plan type of order action will no longer be applicable in Zuora Billing.  |  |
|**updateProduct** | [**CreateOrderRatePlanUpdate**](CreateOrderRatePlanUpdate.md) |  |  [optional] |



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



