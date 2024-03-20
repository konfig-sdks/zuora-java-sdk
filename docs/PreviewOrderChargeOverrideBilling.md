

# PreviewOrderChargeOverrideBilling

Billing information about the charge. 

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**billCycleDay** | **Integer** | Day of the month that each billing period begins on. Only applicable if the value of the &#x60;billCycleType&#x60; field is &#x60;SpecificDayofMonth&#x60;.  |  [optional] |
|**billCycleType** | [**BillCycleTypeEnum**](#BillCycleTypeEnum) | Specifies how Zuora determines the day that each billing period begins on.    * &#x60;DefaultFromCustomer&#x60; - Each billing period begins on the bill cycle day of the account that owns the subscription.   * &#x60;SpecificDayofMonth&#x60; - Use the &#x60;billCycleDay&#x60; field to specify the day of the month that each billing period begins on.   * &#x60;SubscriptionStartDay&#x60; - Each billing period begins on the same day of the month as the start date of the subscription.   * &#x60;ChargeTriggerDay&#x60; - Each billing period begins on the same day of the month as the date when the charge becomes active.   * &#x60;SpecificDayofWeek&#x60; - Use the &#x60;weeklyBillCycleDay&#x60; field to specify the day of the week that each billing period begins on.  |  [optional] |
|**billingPeriod** | [**BillingPeriodEnum**](#BillingPeriodEnum) | Billing frequency of the charge. The value of this field controls the duration of each billing period.  If the value of this field is &#x60;Specific_Months&#x60; or &#x60;Specific_Weeks&#x60;, use the &#x60;specificBillingPeriod&#x60; field to specify the duration of each billing period.  |  [optional] |
|**billingPeriodAlignment** | [**BillingPeriodAlignmentEnum**](#BillingPeriodAlignmentEnum) | Specifies how Zuora determines when to start new billing periods. You can use this field to align the billing periods of different charges.  * &#x60;AlignToCharge&#x60; - Zuora starts a new billing period on the first billing day that falls on or after the date when the charge becomes active. * &#x60;AlignToSubscriptionStart&#x60; - Zuora starts a new billing period on the first billing day that falls on or after the start date of the subscription. * &#x60;AlignToTermStart&#x60; - For each term of the subscription, Zuora starts a new billing period on the first billing day that falls on or after the start date of the term.  See the &#x60;billCycleType&#x60; field for information about how Zuora determines the billing day.  |  [optional] |
|**billingTiming** | [**BillingTimingEnum**](#BillingTimingEnum) | Specifies whether to invoice for a billing period on the first day of the billing period (billing in advance) or the first day of the next billing period (billing in arrears).  |  [optional] |
|**specificBillingPeriod** | **Integer** | Duration of each billing period in months or weeks, depending on the value of the &#x60;billingPeriod&#x60; field. Only applicable if the value of the &#x60;billingPeriod&#x60; field is &#x60;Specific_Months&#x60; or &#x60;Specific_Weeks&#x60;.  |  [optional] |
|**weeklyBillCycleDay** | [**WeeklyBillCycleDayEnum**](#WeeklyBillCycleDayEnum) | Day of the week that each billing period begins on. Only applicable if the value of the &#x60;billCycleType&#x60; field is &#x60;SpecificDayofWeek&#x60;.  |  [optional] |



## Enum: BillCycleTypeEnum

| Name | Value |
|---- | -----|
| DEFAULTFROMCUSTOMER | &quot;DefaultFromCustomer&quot; |
| SPECIFICDAYOFMONTH | &quot;SpecificDayofMonth&quot; |
| SUBSCRIPTIONSTARTDAY | &quot;SubscriptionStartDay&quot; |
| CHARGETRIGGERDAY | &quot;ChargeTriggerDay&quot; |
| SPECIFICDAYOFWEEK | &quot;SpecificDayofWeek&quot; |



## Enum: BillingPeriodEnum

| Name | Value |
|---- | -----|
| MONTH | &quot;Month&quot; |
| QUARTER | &quot;Quarter&quot; |
| SEMI_ANNUAL | &quot;Semi_Annual&quot; |
| ANNUAL | &quot;Annual&quot; |
| EIGHTEEN_MONTHS | &quot;Eighteen_Months&quot; |
| TWO_YEARS | &quot;Two_Years&quot; |
| THREE_YEARS | &quot;Three_Years&quot; |
| FIVE_YEARS | &quot;Five_Years&quot; |
| SPECIFIC_MONTHS | &quot;Specific_Months&quot; |
| SUBSCRIPTION_TERM | &quot;Subscription_Term&quot; |
| WEEK | &quot;Week&quot; |
| SPECIFIC_WEEKS | &quot;Specific_Weeks&quot; |



## Enum: BillingPeriodAlignmentEnum

| Name | Value |
|---- | -----|
| ALIGNTOCHARGE | &quot;AlignToCharge&quot; |
| ALIGNTOSUBSCRIPTIONSTART | &quot;AlignToSubscriptionStart&quot; |
| ALIGNTOTERMSTART | &quot;AlignToTermStart&quot; |



## Enum: BillingTimingEnum

| Name | Value |
|---- | -----|
| ADVANCE | &quot;IN_ADVANCE&quot; |
| ARREARS | &quot;IN_ARREARS&quot; |



## Enum: WeeklyBillCycleDayEnum

| Name | Value |
|---- | -----|
| SUNDAY | &quot;Sunday&quot; |
| MONDAY | &quot;Monday&quot; |
| TUESDAY | &quot;Tuesday&quot; |
| WEDNESDAY | &quot;Wednesday&quot; |
| THURSDAY | &quot;Thursday&quot; |
| FRIDAY | &quot;Friday&quot; |
| SATURDAY | &quot;Saturday&quot; |



