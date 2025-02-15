

# CreateOrderUpdateProductTriggerParams

Specifies when a charge becomes active. 

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**specificTriggerDate** | **LocalDate** | Date in YYYY-MM-DD format. Only applicable if the value of the &#x60;triggerEvent&#x60; field is &#x60;SpecificDate&#x60;.   While this field is applicable, if this field is not set, your &#x60;CreateSubscription&#x60; order action creates a &#x60;Pending&#x60; order and a &#x60;Pending Acceptance&#x60; subscription. If at the same time the service activation date is required and not set, a &#x60;Pending Activation&#x60; subscription is created.  While this field is applicable, if this field is not set, the following order actions create a &#x60;Pending&#x60; order but do not impact the subscription status. **Note**: This feature is in **Limited Availability**. If you want to have access to the feature, submit a request at [Zuora Global Support](http://support.zuora.com/).  * AddProduct  * UpdateProduct  * RemoveProduct  * RenewSubscription  * TermsAndConditions  While this field is applicable, for the &#x60;updateProduct&#x60; order action, if the Pending order feature as above is not enabled, this field must not be set to null.  |  [optional] |
|**triggerEvent** | [**TriggerEventEnum**](#TriggerEventEnum) | Condition for the charge to become active. If this field is not specified, the value of the field will be defaulted to the trigger event value defined in the product catalog.  If the value of this field is &#x60;SpecificDate&#x60;, use the &#x60;specificTriggerDate&#x60; field to specify the date when the charge becomes active.  |  [optional] |



## Enum: TriggerEventEnum

| Name | Value |
|---- | -----|
| CONTRACTEFFECTIVE | &quot;ContractEffective&quot; |
| SERVICEACTIVATION | &quot;ServiceActivation&quot; |
| CUSTOMERACCEPTANCE | &quot;CustomerAcceptance&quot; |
| SPECIFICDATE | &quot;SpecificDate&quot; |



