

# OrderActionRatePlanEndConditions

Specifies when a charge becomes inactive. 

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**endDateCondition** | [**EndDateConditionEnum**](#EndDateConditionEnum) | Condition for the charge to become inactive.  If the value of this field is &#x60;Fixed_Period&#x60;, the charge is active for a predefined duration based on the value of the &#x60;upToPeriodsType&#x60; and &#x60;upToPeriods&#x60; fields.  If the value of this field is &#x60;Specific_End_Date&#x60;, use the &#x60;specificEndDate&#x60; field to specify the date when then charge becomes inactive.  |  [optional] |
|**specificEndDate** | **LocalDate** | Date in YYYY-MM-DD format. Only applicable if the value of the &#x60;endDateCondition&#x60; field is &#x60;Specific_End_Date&#x60;.  |  [optional] |
|**upToPeriods** | **Integer** | Duration of the charge in billing periods, days, weeks, months, or years, depending on the value of the &#x60;upToPeriodsType&#x60; field. Only applicable if the value of the &#x60;endDateCondition&#x60; field is &#x60;Fixed_Period&#x60;.  |  [optional] |
|**upToPeriodsType** | [**UpToPeriodsTypeEnum**](#UpToPeriodsTypeEnum) | Unit of time that the charge duration is measured in. Only applicable if the value of the &#x60;endDateCondition&#x60; field is &#x60;Fixed_Period&#x60;.  |  [optional] |



## Enum: EndDateConditionEnum

| Name | Value |
|---- | -----|
| SUBSCRIPTION_END | &quot;Subscription_End&quot; |
| FIXED_PERIOD | &quot;Fixed_Period&quot; |
| SPECIFIC_END_DATE | &quot;Specific_End_Date&quot; |



## Enum: UpToPeriodsTypeEnum

| Name | Value |
|---- | -----|
| BILLING_PERIODS | &quot;Billing_Periods&quot; |
| DAYS | &quot;Days&quot; |
| WEEKS | &quot;Weeks&quot; |
| MONTHS | &quot;Months&quot; |
| YEARS | &quot;Years&quot; |



