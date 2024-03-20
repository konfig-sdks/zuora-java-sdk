

# CreateOrderResume

Information about an order action of type `Resume`. 

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**extendsTerm** | **Boolean** | Specifies whether to extend the subscription term by the length of time the suspension is in effect.  |  [optional] |
|**resumePeriods** | **Integer** | This field is applicable only when the &#x60;resumePolicy&#x60; field is set to &#x60;FixedPeriodsFromToday&#x60; or &#x60;FixedPeriodsFromSuspendDate&#x60;. It must be used together with the &#x60;resumePeriodsType&#x60; field.   The total number of the periods used to specify when a subscription resumption takes effect. The subscription resumption will take place after the specified time frame (&#x60;suspendPeriods&#x60; multiplied by &#x60;suspendPeriodsType&#x60;) from today&#39;s date.   |  [optional] |
|**resumePeriodsType** | [**ResumePeriodsTypeEnum**](#ResumePeriodsTypeEnum) | This field is applicable only when the &#x60;resumePolicy&#x60; field is set to &#x60;FixedPeriodsFromToday&#x60; or &#x60;FixedPeriodsFromSuspendDate&#x60;. It must be used together with the &#x60;resumePeriods&#x60; field.  The period type used to specify when a subscription resumption takes effect. The subscription suspension will take place after the specified time frame (&#x60;suspendPeriods&#x60; multiplied by &#x60;suspendPeriodsType&#x60;) from today&#39;s date.   |  [optional] |
|**resumePolicy** | [**ResumePolicyEnum**](#ResumePolicyEnum) | Resume methods. Specify a way to resume a subscription. See [Resume Date](https://knowledgecenter.zuora.com/BC_Subscription_Management/Subscriptions/Resume_a_Subscription#Resume_Date) for more information.  If &#x60;SuspendDate&#x60; is specfied, the resumption will take place on the same day as the suspension.   |  |
|**resumeSpecificDate** | **LocalDate** | This field is applicable only when the &#x60;resumePolicy&#x60; field is set to &#x60;SpecificDate&#x60;.  A specific date when the subscription resumption takes effect, in YYYY-MM-DD format. The value should not be earlier than the subscription suspension date.  |  [optional] |



## Enum: ResumePeriodsTypeEnum

| Name | Value |
|---- | -----|
| DAY | &quot;Day&quot; |
| WEEK | &quot;Week&quot; |
| MONTH | &quot;Month&quot; |
| YEAR | &quot;Year&quot; |



## Enum: ResumePolicyEnum

| Name | Value |
|---- | -----|
| TODAY | &quot;Today&quot; |
| FIXEDPERIODSFROMSUSPENDDATE | &quot;FixedPeriodsFromSuspendDate&quot; |
| FIXEDPERIODSFROMTODAY | &quot;FixedPeriodsFromToday&quot; |
| SPECIFICDATE | &quot;SpecificDate&quot; |
| SUSPENDDATE | &quot;SuspendDate&quot; |



