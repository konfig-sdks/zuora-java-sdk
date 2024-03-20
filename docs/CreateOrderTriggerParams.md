

# CreateOrderTriggerParams

Specifies when a charge becomes active. 

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**periodsAfterChargeStart** | **Integer** | Duration of the discount charge in days, weeks, months, or years, depending on the value of the &#x60;startPeriodsType&#x60; field. Only applicable if the value of the &#x60;startDatePolicy&#x60; field is &#x60;FixedPeriodAfterApplyToChargeStartDate&#x60;.  **Note**: You must enable the [Enhanced Discounts](https://knowledgecenter.zuora.com/Zuora_Billing/Build_products_and_prices/Basic_concepts_and_terms/B_Charge_Models/D_Manage_Enhanced_Discount) feature to access this field.  |  [optional] |
|**specificTriggerDate** | **LocalDate** | Date in YYYY-MM-DD format. Only applicable if the value of the &#x60;triggerEvent&#x60; field is &#x60;SpecificDate&#x60;.   While this field is applicable, if this field is not set, your &#x60;CreateSubscription&#x60; order action creates a &#x60;Pending&#x60; order and a &#x60;Pending Acceptance&#x60; subscription. If at the same time the service activation date is required and not set, a &#x60;Pending Activation&#x60; subscription is created.  While this field is applicable, if this field is not set, the following order actions create a &#x60;Pending&#x60; order but do not impact the subscription status. **Note**: This feature is in **Limited Availability**. If you want to have access to the feature, submit a request at [Zuora Global Support](http://support.zuora.com/).  * AddProduct  * UpdateProduct  * RemoveProduct  * RenewSubscription  * TermsAndConditions  |  [optional] |
|**startDatePolicy** | [**StartDatePolicyEnum**](#StartDatePolicyEnum) | Start date policy of the discount charge to become active when the **Apply to billing period partially** checkbox is selected from the product catalog UI or the &#x60;applyToBillingPeriodPartially&#x60; field is set as true from the \&quot;CRUD: Create a product rate plan charge\&quot; operation.  - If the value of this field is &#x60;SpecificDate&#x60;, use the &#x60;specificTriggerDate&#x60; field to specify the date when the charge becomes active. - If the value of this field is &#x60;FixedPeriodAfterApplyToChargeStartDate&#x60;, the charge is active for a predefined duration based on the value of the &#x60;upToPeriodsType&#x60; and &#x60;upToPeriods&#x60; fields.  **Notes**:    - You must enable the [Enhanced Discounts](https://knowledgecenter.zuora.com/Zuora_Billing/Build_products_and_prices/Basic_concepts_and_terms/B_Charge_Models/D_Manage_Enhanced_Discount) feature to access this field.    - You can use either &#x60;triggerEvent&#x60; or &#x60;startDatePolicy&#x60; to define when a discount charge starts, but not both at the same time.  |  [optional] |
|**startPeriodsType** | [**StartPeriodsTypeEnum**](#StartPeriodsTypeEnum) | Unit of time that the discount charge duration is measured in. Only applicable if the value of the &#x60;startDatePolicy&#x60; field is &#x60;FixedPeriodAfterApplyToChargeStartDate&#x60;.  **Note**: You must enable the [Enhanced Discounts](https://knowledgecenter.zuora.com/Zuora_Billing/Build_products_and_prices/Basic_concepts_and_terms/B_Charge_Models/D_Manage_Enhanced_Discount) feature to access this field.  |  [optional] |
|**triggerEvent** | [**TriggerEventEnum**](#TriggerEventEnum) | Condition for the charge to become active.  If the value of this field is &#x60;SpecificDate&#x60;, use the &#x60;specificTriggerDate&#x60; field to specify the date when the charge becomes active.  |  [optional] |



## Enum: StartDatePolicyEnum

| Name | Value |
|---- | -----|
| ALIGNTOAPPLYTOCHARGE | &quot;AlignToApplyToCharge&quot; |
| SPECIFICDATE | &quot;SpecificDate&quot; |
| ENDOFLASTINVOICEPERIODOFAPPLYTOCHARGE | &quot;EndOfLastInvoicePeriodOfApplyToCharge&quot; |
| FIXEDPERIODAFTERAPPLYTOCHARGESTARTDATE | &quot;FixedPeriodAfterApplyToChargeStartDate&quot; |



## Enum: StartPeriodsTypeEnum

| Name | Value |
|---- | -----|
| DAYS | &quot;Days&quot; |
| WEEKS | &quot;Weeks&quot; |
| MONTHS | &quot;Months&quot; |
| YEARS | &quot;Years&quot; |



## Enum: TriggerEventEnum

| Name | Value |
|---- | -----|
| CONTRACTEFFECTIVE | &quot;ContractEffective&quot; |
| SERVICEACTIVATION | &quot;ServiceActivation&quot; |
| CUSTOMERACCEPTANCE | &quot;CustomerAcceptance&quot; |
| SPECIFICDATE | &quot;SpecificDate&quot; |



