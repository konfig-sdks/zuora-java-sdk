

# CreateChangePlan

Information about an order action of type `ChangePlan`.   Use the change plan type of order action to replace the existing rate plans in a subscription with other rate plans.  **Note**: The change plan type of order action is currently not supported for Billing - Revenue Integration. When Billing - Revenue Integration is enabled, the change plan type of order action will no longer be applicable in Zuora Billing.  If you want to create a pending order through the \"change plan\" order action, and if the charge's trigger condition is `Specific Date`, you must set a charge number in the `chargeNumber` field for the \"change plan\" order action. In this case, if you do not set it, Zuora will not generate the charge number for you.  See more information about pending orders in <a href=\"https://knowledgecenter.zuora.com/Zuora_Billing/Subscriptions/Subscriptions/Orders/AA_Overview_of_Orders/Pending_orders_and_subscriptions\" target=\"_blank\">Pending orders and subscriptions</a>. 

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**effectivePolicy** | [**EffectivePolicyEnum**](#EffectivePolicyEnum) | The default value for the &#x60;effectivePolicy&#x60; field is as follows:   * If the rate plan change (from old to new) is an upgrade, the effective policy is &#x60;EffectiveImmediately&#x60; by default.   * If the rate plan change (from old to new) is a downgrade, the effective policy is &#x60;EffectiveEndOfBillingPeriod&#x60; by default.   * Otherwise, the effective policy is &#x60;SpecificDate&#x60; by default.  **Notes**:    * When setting this field to &#x60;EffectiveEndOfBillingPeriod&#x60;, you cannot set the &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Subscriptions/Subscriptions/W_Subscription_and_Amendment_Dates#Billing_Trigger_Dates\&quot; target&#x3D;\&quot;_blank\&quot;&gt;billing trigger dates&lt;/a&gt; for the subscription as the system will automatically set the trigger dates to the end of billing period, and you cannot set the following billing trigger date settings to &#x60;Yes&#x60;:     * &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Billing_and_Invoicing/Billing_Settings/Define_Default_Subscription_and_Order_Settings#Require_Customer_Acceptance_of_Orders.3F\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Require Customer Acceptance of Orders?&lt;/a&gt;     * &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Billing_and_Invoicing/Billing_Settings/Define_Default_Subscription_and_Order_Settings#Require_Service_Activation_of_Orders.3F\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Require Service Activation of Orders?&lt;/a&gt;      * When setting this field to &#x60;SpecificDate&#x60;, you must also set the contract effective date in the &#x60;triggerDates&#x60; field as follows:     * Set the &#x60;name&#x60; field as &#x60;ContractEffective&#x60;     * Specify a date for the &#x60;triggerDate&#x60; field  |  [optional] |
|**externalCatalogPlanId** | **String** | An external ID of the rate plan to be removed. You can use this field to specify an existing rate plan in your subscription. The value of the &#x60;externalCatalogPlanId&#x60; field must match one of the values that are predefined in the &#x60;externallyManagedPlanIds&#x60; field on a product rate plan. However, if there are multiple rate plans with the same &#x60;productRatePlanId&#x60; value existing in the subscription, you must use the &#x60;ratePlanId&#x60; field to remove the rate plan. The &#x60;externalCatalogPlanId&#x60; field cannot be used to distinguish multiple rate plans in this case.  **Note:** Please provide only one of &#x60;externalCatalogPlanId&#x60;, &#x60;ratePlanId&#x60; or &#x60;productRatePlanId&#x60;. If more than 1 field is provided then the request would fail.  |  [optional] |
|**newProductRatePlan** | [**CreateOrderChangePlanRatePlanOverride**](CreateOrderChangePlanRatePlanOverride.md) |  |  |
|**productRatePlanId** | **String** | ID of the product rate plan that the removed rate plan is based on.  |  [optional] |
|**productRatePlanNumber** | **String** | Number of a product rate plan for this subscription.  |  [optional] |
|**ratePlanId** | **String** | ID of the rate plan to remove. This can be the latest version or any history version of ID. Note that the removal of a rate plan through the Change Plan order action supports the function of &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Subscriptions/Subscriptions/Orders/Order_actions_tutorials/E2_Remove_rate_plan_on_subscription_before_future-dated_removals\&quot; target&#x3D;\&quot;_blank\&quot;&gt;removal before future-dated removals&lt;/a&gt;, as in a Remove Product order action.  |  [optional] |
|**resetBcd** | **Boolean** | If resetBcd is true then reset the Account BCD to the effective date; if it is false keep the original BCD.  |  [optional] |
|**subType** | [**SubTypeEnum**](#SubTypeEnum) | Use this field to choose the sub type for your change plan order action.  However, if you do not set this field, the field will be automatically generated by the system according to the following rules:  When the old and new rate plans are within the same Grading catalog group: * If the grade of new plan is greater than that of the old plan, this is an \&quot;Upgrade\&quot;. * If the grade of new plan is less than that of the old plan, this is a \&quot;Downgrade\&quot;. * If the grade of new plan equals that of the old plan, this is a \&quot;Crossgrade\&quot;.  When the old and new rate plans are not in the same Grading catalog group, or either has no group, this is \&quot;PlanChanged\&quot;.  |  [optional] |
|**subscriptionRatePlanNumber** | **String** | Number of a rate plan for this subscription.  |  [optional] |



## Enum: EffectivePolicyEnum

| Name | Value |
|---- | -----|
| EFFECTIVEIMMEDIATELY | &quot;EffectiveImmediately&quot; |
| EFFECTIVEENDOFBILLINGPERIOD | &quot;EffectiveEndOfBillingPeriod&quot; |
| SPECIFICDATE | &quot;SpecificDate&quot; |



## Enum: SubTypeEnum

| Name | Value |
|---- | -----|
| UPGRADE | &quot;Upgrade&quot; |
| DOWNGRADE | &quot;Downgrade&quot; |
| CROSSGRADE | &quot;Crossgrade&quot; |
| PLANCHANGED | &quot;PlanChanged&quot; |



