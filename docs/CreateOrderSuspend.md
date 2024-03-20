

# CreateOrderSuspend

Information about an order action of type `Suspend`. 

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**suspendPeriods** | **Integer** | This field is applicable only when the &#x60;suspendPolicy&#x60; field is set to &#x60;FixedPeriodsFromToday&#x60;. It must be used together with the &#x60;suspendPeriodsType&#x60; field.   The total number of the periods used to specify when a subscription suspension takes effect. The subscription suspension will take place after the specified time frame (&#x60;suspendPeriods&#x60; multiplied by &#x60;suspendPeriodsType&#x60;) from today&#39;s date.   |  [optional] |
|**suspendPeriodsType** | [**SuspendPeriodsTypeEnum**](#SuspendPeriodsTypeEnum) | This field is applicable only when the &#x60;suspendPolicy&#x60; field is set to &#x60;FixedPeriodsFromToday&#x60;. It must be used together with the &#x60;suspendPeriods&#x60; field.  The period type used to specify when a subscription suspension takes effect. The subscription suspension will take place after the specified time frame (&#x60;suspendPeriods&#x60; multiplied by &#x60;suspendPeriodsType&#x60;) from today&#39;s date.   |  [optional] |
|**suspendPolicy** | [**SuspendPolicyEnum**](#SuspendPolicyEnum) | Suspend methods. Specify a way to suspend a subscription. See [Suspend Date](https://knowledgecenter.zuora.com/BC_Subscription_Management/Subscriptions/Suspend_a_Subscription#Suspend_Date) for more information.  |  |
|**suspendSpecificDate** | **LocalDate** | This field is applicable only when the &#x60;suspendPolicy&#x60; field is set to &#x60;SpecificDate&#x60;.  A specific date when the subscription suspension takes effect, in YYYY-MM-DD format. The value should not be earlier than the subscription&#39;s contract effective date or later [available versions](https://developer.zuora.com/api-references/api/overview/#section/API-Versions/Minor-Version) than the subscription&#39;s term end date.  |  [optional] |



## Enum: SuspendPeriodsTypeEnum

| Name | Value |
|---- | -----|
| DAY | &quot;Day&quot; |
| WEEK | &quot;Week&quot; |
| MONTH | &quot;Month&quot; |
| YEAR | &quot;Year&quot; |



## Enum: SuspendPolicyEnum

| Name | Value |
|---- | -----|
| TODAY | &quot;Today&quot; |
| ENDOFLASTINVOICEPERIOD | &quot;EndOfLastInvoicePeriod&quot; |
| FIXEDPERIODSFROMTODAY | &quot;FixedPeriodsFromToday&quot; |
| SPECIFICDATE | &quot;SpecificDate&quot; |



