

# OrderAction

Represents the processed order action.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**addProduct** | [**RatePlanOverride**](RatePlanOverride.md) |  |  [optional] |
|**cancelSubscription** | [**CancelSubscription**](CancelSubscription.md) |  |  [optional] |
|**changePlan** | [**ChangePlan**](ChangePlan.md) |  |  [optional] |
|**changeReason** | **String** | The change reason set for an order action when an order is created.  |  [optional] |
|**createSubscription** | [**CreateSubscription**](CreateSubscription.md) |  |  [optional] |
|**customFields** | **Map&lt;String, Object&gt;** | Container for custom fields of an Order Action object.  |  [optional] |
|**id** | **String** | The Id of the order action processed in the order. |  [optional] |
|**orderItems** | [**List&lt;OrderItem&gt;**](OrderItem.md) | The &#x60;orderItems&#x60; nested field is only available to existing Orders customers who already have access to the field.  **Note:** The following Order Metrics have been deprecated. Any new customers who onboard on [Orders](https://knowledgecenter.zuora.com/Billing/Subscriptions/Orders/AA_Overview_of_Orders) or [Orders Harmonization](https://knowledgecenter.zuora.com/Billing/Subscriptions/Orders/Orders_Harmonization/Orders_Harmonization) will not get these metrics. * The Order ELP and Order Item objects  * The \&quot;Generated Reason\&quot; and \&quot;Order Item ID\&quot; fields in the Order MRR, Order TCB, Order TCV, and Order Quantity objects  Existing Orders customers who have these metrics will continue to be supported.  |  [optional] |
|**orderMetrics** | [**List&lt;OrderMetric&gt;**](OrderMetric.md) | The container for order metrics.  **Note:** The following Order Metrics have been deprecated. Any new customers who onboard on [Orders](https://knowledgecenter.zuora.com/Billing/Subscriptions/Orders/AA_Overview_of_Orders) or [Orders Harmonization](https://knowledgecenter.zuora.com/Billing/Subscriptions/Orders/Orders_Harmonization/Orders_Harmonization) will not get these metrics. * The Order ELP and Order Item objects  * The \&quot;Generated Reason\&quot; and \&quot;Order Item ID\&quot; fields in the Order MRR, Order TCB, Order TCV, and Order Quantity objects  Existing Orders customers who have these metrics will continue to be supported.  **Note:** As of Zuora Billing Release 306, Zuora has upgraded the methodologies for calculating metrics in [Orders](https://knowledgecenter.zuora.com/Billing/Subscriptions/Orders). The new methodologies are reflected in the following Order Delta Metrics objects.  * [Order Delta Mrr](https://knowledgecenter.zuora.com/Billing/Subscriptions/Orders/Order_Delta_Metrics/Order_Delta_Mrr) * [Order Delta Tcv](https://knowledgecenter.zuora.com/Billing/Subscriptions/Orders/Order_Delta_Metrics/Order_Delta_Tcv) * [Order Delta Tcb](https://knowledgecenter.zuora.com/Billing/Subscriptions/Orders/Order_Delta_Metrics/Order_Delta_Tcb)  It is recommended that all customers use the new [Order Delta Metrics](https://knowledgecenter.zuora.com/Billing/Subscriptions/Orders/Order_Delta_Metrics/AA_Overview_of_Order_Delta_Metrics). If you are an existing [Order Metrics](https://knowledgecenter.zuora.com/Billing/Subscriptions/Orders/AA_Overview_of_Orders/Key_Metrics_for_Orders) customer and want to migrate to Order Delta Metrics, submit a request at [Zuora Global Support](https://support.zuora.com/).  Whereas new customers, and existing customers not currently on [Order Metrics](https://knowledgecenter.zuora.com/Billing/Subscriptions/Orders/AA_Overview_of_Orders/Key_Metrics_for_Orders), will no longer have access to Order Metrics, existing customers currently using Order Metrics will continue to be supported.  |  [optional] |
|**ownerTransfer** | [**OwnerTransfer**](OwnerTransfer.md) |  |  [optional] |
|**removeProduct** | [**RemoveProduct**](RemoveProduct.md) |  |  [optional] |
|**renewSubscription** | [**RenewSubscription**](RenewSubscription.md) |  |  [optional] |
|**resume** | [**GetOrderResume**](GetOrderResume.md) |  |  [optional] |
|**sequence** | **Integer** | The sequence of the order actions processed in the order. |  [optional] |
|**suspend** | [**GetOrderSuspend**](GetOrderSuspend.md) |  |  [optional] |
|**termsAndConditions** | [**TermsAndConditions**](TermsAndConditions.md) |  |  [optional] |
|**triggerDates** | [**List&lt;TriggerDate&gt;**](TriggerDate.md) | Container for the contract effective, service activation, and customer acceptance dates of the order action.   If [Zuora is configured to require service activation](https://knowledgecenter.zuora.com/CB_Billing/Billing_Settings/Define_Default_Subscription_Settings#Require_Service_Activation_of_Orders.3F) and the &#x60;ServiceActivation&#x60; field is not set for a &#x60;CreateSubscription&#x60; order action, a &#x60;Pending&#x60; order and a &#x60;Pending Activation&#x60; subscription are created.  If [Zuora is configured to require customer acceptance](https://knowledgecenter.zuora.com/CB_Billing/Billing_Settings/Define_Default_Subscription_Settings#Require_Customer_Acceptance_of_Orders.3F) and the &#x60;CustomerAcceptance&#x60; field is not set for a &#x60;CreateSubscription&#x60; order action, a &#x60;Pending&#x60; order and a &#x60;Pending Acceptance&#x60; subscription are created. At the same time, if the service activation date field is also required and not set, a &#x60;Pending&#x60; order and a &#x60;Pending Activation&#x60; subscription are created instead.  If [Zuora is configured to require service activation](https://knowledgecenter.zuora.com/CB_Billing/Billing_Settings/Define_Default_Subscription_Settings#Require_Service_Activation_of_Orders.3F) and the &#x60;ServiceActivation&#x60; field is not set for either of the following order actions, a &#x60;Pending&#x60; order is created. The subscription status is not impacted. **Note:** This feature is in **Limited Availability**. If you want to have access to the feature, submit a request at [Zuora Global Support](http://support.zuora.com/).  * AddProduct  * UpdateProduct  * RemoveProduct  * RenewSubscription  * TermsAndConditions  If [Zuora is configured to require customer acceptance](https://knowledgecenter.zuora.com/CB_Billing/Billing_Settings/Define_Default_Subscription_Settings#Require_Customer_Acceptance_of_Orders.3F) and the &#x60;CustomerAcceptance&#x60; field is not set for either of the following order actions, a &#x60;Pending&#x60; order is created. The subscription status is not impacted. **Note:** This feature is in **Limited Availability**. If you want to have access to the feature, submit a request at [Zuora Global Support](http://support.zuora.com/).  * AddProduct  * UpdateProduct  * RemoveProduct  * RenewSubscription  * TermsAndConditions  |  [optional] |
|**type** | [**TypeEnum**](#TypeEnum) | Type of the order action.  **Note**: The change plan type of order action is currently not supported for Billing - Revenue Integration. When Billing - Revenue Integration is enabled, the change plan type of order action will no longer be applicable in Zuora Billing.  |  [optional] |
|**updateProduct** | [**RatePlanUpdate**](RatePlanUpdate.md) |  |  [optional] |



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



