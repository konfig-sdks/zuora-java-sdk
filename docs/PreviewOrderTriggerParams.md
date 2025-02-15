

# PreviewOrderTriggerParams

Specifies when a charge becomes active. 

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**specificTriggerDate** | **LocalDate** | Date in YYYY-MM-DD format. Only applicable if the value of the &#x60;triggerEvent&#x60; field is &#x60;SpecificDate&#x60;.   While this field is applicable, if this field is not set, your &#x60;CreateSubscription&#x60; order action creates a &#x60;Pending&#x60; order and a &#x60;Pending Acceptance&#x60; subscription. If at the same time the service activation date is required and not set, a &#x60;Pending Activation&#x60; subscription is created.  |  [optional] |
|**triggerEvent** | [**TriggerEventEnum**](#TriggerEventEnum) | Condition for the charge to become active.  If the value of this field is &#x60;SpecificDate&#x60;, use the &#x60;specificTriggerDate&#x60; field to specify the date when the charge becomes active.  |  [optional] |



## Enum: TriggerEventEnum

| Name | Value |
|---- | -----|
| CONTRACTEFFECTIVE | &quot;ContractEffective&quot; |
| SERVICEACTIVATION | &quot;ServiceActivation&quot; |
| CUSTOMERACCEPTANCE | &quot;CustomerAcceptance&quot; |
| SPECIFICDATE | &quot;SpecificDate&quot; |



