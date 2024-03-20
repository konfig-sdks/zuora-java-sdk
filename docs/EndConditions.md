

# EndConditions

Specifies when a charge becomes inactive. 

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**endDateCondition** | [**EndDateConditionEnum**](#EndDateConditionEnum) | Condition for the charge to become inactive.  - If the value of this field is &#x60;Fixed_Period&#x60;, the charge is active for a predefined duration based on the value of the &#x60;upToPeriodsType&#x60; and &#x60;upToPeriods&#x60; fields. - If the value of this field is &#x60;Specific_End_Date&#x60;, use the &#x60;specificEndDate&#x60; field to specify the date when the charge becomes inactive.  |  [optional] |
|**endDatePolicy** | [**EndDatePolicyEnum**](#EndDatePolicyEnum) | End date policy of the discount charge to become active when the **Apply to billing period partially** checkbox is selected from the product catalog UI or the &#x60;applyToBillingPeriodPartially&#x60; field is set as true from the \&quot;CRUD: Create a product rate plan charge\&quot; operation.   - If the value of this field is &#x60;FixedPeriod&#x60;, the charge is active for a predefined duration based on the value of the &#x60;upToPeriodsType&#x60; and &#x60;upToPeriods&#x60; fields. - If the value of this field is &#x60;SpecificEndDate&#x60;, use the &#x60;specificEndDate&#x60; field to specify the date when the charge becomes inactive.  **Notes**:  - You must enable the [Enhanced Discounts](https://knowledgecenter.zuora.com/Zuora_Billing/Build_products_and_prices/Basic_concepts_and_terms/B_Charge_Models/D_Manage_Enhanced_Discount) feature to access this field. - You can use either &#x60;endDateCondition&#x60; or &#x60;endDatePolicy&#x60; to define when a discount charge ends, but not both at the same time.  |  [optional] |
|**specificEndDate** | **LocalDate** | Date in YYYY-MM-DD format. Only applicable if the value of the &#x60;endDateCondition&#x60; field is &#x60;Specific_End_Date&#x60;.  |  [optional] |
|**upToPeriods** | **Integer** | Duration of the charge in billing periods, days, weeks, months, or years, depending on the value of the &#x60;upToPeriodsType&#x60; field. Only applicable if the value of the &#x60;endDateCondition&#x60; field is &#x60;Fixed_Period&#x60;.  |  [optional] |
|**upToPeriodsType** | [**UpToPeriodsTypeEnum**](#UpToPeriodsTypeEnum) | Unit of time that the charge duration is measured in. Only applicable if the value of the &#x60;endDateCondition&#x60; field is &#x60;Fixed_Period&#x60;.  |  [optional] |



## Enum: EndDateConditionEnum

| Name | Value |
|---- | -----|
| SUBSCRIPTION_END | &quot;Subscription_End&quot; |
| FIXED_PERIOD | &quot;Fixed_Period&quot; |
| SPECIFIC_END_DATE | &quot;Specific_End_Date&quot; |



## Enum: EndDatePolicyEnum

| Name | Value |
|---- | -----|
| ALIGNTOAPPLYTOCHARGE | &quot;AlignToApplyToCharge&quot; |
| SPECIFICENDDATE | &quot;SpecificEndDate&quot; |
| FIXEDPERIOD | &quot;FixedPeriod&quot; |



## Enum: UpToPeriodsTypeEnum

| Name | Value |
|---- | -----|
| BILLING_PERIODS | &quot;Billing_Periods&quot; |
| DAYS | &quot;Days&quot; |
| WEEKS | &quot;Weeks&quot; |
| MONTHS | &quot;Months&quot; |
| YEARS | &quot;Years&quot; |



