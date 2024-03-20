

# OrderActionRatePlanChargeOverride

Charge associated with a rate plan. 

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**description** | **String** | Description of the charge.  |  [optional] |
|**billing** | [**PreviewOrderChargeOverrideBilling**](PreviewOrderChargeOverrideBilling.md) |  |  [optional] |
|**chargeNumber** | **String** | Charge number of the charge. For example, C-00000307.  If you do not set this field, Zuora will generate the charge number.  |  [optional] |
|**customFields** | **Map&lt;String, Object&gt;** | Container for custom fields of a Rate Plan Charge object.  |  [optional] |
|**endDate** | [**OrderActionRatePlanEndConditions**](OrderActionRatePlanEndConditions.md) |  |  [optional] |
|**pricing** | [**OrderActionRatePlanChargeOverridePricing**](OrderActionRatePlanChargeOverridePricing.md) |  |  [optional] |
|**productRatePlanChargeId** | **String** | Internal identifier of the product rate plan charge that the charge is based on.  |  |
|**revRecCode** | **String** | Revenue Recognition Code  |  [optional] |
|**revRecTriggerCondition** | [**RevRecTriggerConditionEnum**](#RevRecTriggerConditionEnum) | Specifies the revenue recognition trigger condition.    * &#x60;Contract Effective Date&#x60;   * &#x60;Service Activation Date&#x60;   * &#x60;Customer Acceptance Date&#x60;  |  [optional] |
|**revenueRecognitionRuleName** | [**RevenueRecognitionRuleNameEnum**](#RevenueRecognitionRuleNameEnum) | Specifies the revenue recognition rule.    * &#x60;Recognize upon invoicing&#x60;   * &#x60;Recognize daily over time&#x60;  |  [optional] |
|**startDate** | [**OrderActionRatePlanTriggerParams**](OrderActionRatePlanTriggerParams.md) |  |  [optional] |
|**uniqueToken** | **String** | Unique identifier for the charge. This identifier enables you to refer to the charge before the charge has an internal identifier in Zuora.  For instance, suppose that you want to use a single order to add a product to a subscription and later update the same product. When you add the product, you can set a unique identifier for the charge. Then when you update the product, you can use the same unique identifier to specify which charge to modify.  |  [optional] |



## Enum: RevRecTriggerConditionEnum

| Name | Value |
|---- | -----|
| CONTRACT_EFFECTIVE_DATE | &quot;Contract Effective Date&quot; |
| SERVICE_ACTIVATION_DATE | &quot;Service Activation Date&quot; |
| CUSTOMER_ACCEPTANCE_DATE | &quot;Customer Acceptance Date&quot; |



## Enum: RevenueRecognitionRuleNameEnum

| Name | Value |
|---- | -----|
| UPON_INVOICING | &quot;Recognize upon invoicing&quot; |
| DAILY_OVER_TIME | &quot;Recognize daily over time&quot; |



