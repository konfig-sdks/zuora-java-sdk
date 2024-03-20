

# PUTPaymentScheduleRequestAllOf


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**amount** | **Double** | Indicates the updated amount of the pending payment schedule items.  |  [optional] |
|**currency** | **String** | Indicates the updated currency of the pending payment schedule items.        |  [optional] |
|**occurrences** | **Integer** | Indicates the updated number of payment schedule items that are created by the payment schedule.  **Note:**   - If \&quot;updated &#x60;occurrences&#x60; &gt; existing &#x60;occurrences&#x60;\&quot;, the following number of pending payment schedule item will be added to the payment schedule: “updated &#x60;occurrences&#x60; - existing &#x60;occurrences&#x60;”.   - If \&quot;existing &#x60;occurrences&#x60; &gt; updated &#x60;occurrences&#x60; &gt;&#x3D; the number of &#x60;processed&#x60;/&#x60;errored&#x60;/&#x60;canceled&#x60; payment schedule items\&quot;, the following number of pending items will be removed by descending order of the schedule dates: \&quot;existing &#x60;occurrences&#x60; - updated &#x60;occurrences&#x60;\&quot;.   - If \&quot;updated &#x60;occurrences&#x60; &lt; the number of &#x60;processed&#x60;/&#x60;erroed&#x60;/&#x60;canceled&#x60; payment schedule items\&quot;, a validation error will be returned.  |  [optional] |
|**paymentGatewayId** | **String** | Indicates the updated payment gateway ID of the pending payment schedule items.  |  [optional] |
|**paymentMethodId** | **String** | Indicates the updated payment method ID of the pending payment schedule items.   |  [optional] |
|**paymentOption** | [**List&lt;PaymentSchedulePaymentOptionFields&gt;**](PaymentSchedulePaymentOptionFields.md) | Container for the paymentOption items, which describe the transactional level rules for processing payments. Currently, only the Gateway Options type is supported.  Here is an example: &#x60;&#x60;&#x60; \&quot;paymentOption\&quot;: [   {     \&quot;type\&quot;: \&quot;GatewayOptions\&quot;,     \&quot;detail\&quot;: {       \&quot;SecCode\&quot;:\&quot;WEB\&quot;     }   } ] &#x60;&#x60;&#x60;  &#x60;paymentOption&#x60; of the payment schedule takes precedence over &#x60;paymentOption&#x60; of the payment schedule item.   **Note:** To enable this field, submit a request at [Zuora Global Support](https://support.zuora.com/).  |  [optional] |
|**period** | [**PeriodEnum**](#PeriodEnum) | Indicates the updated period of the pending payment schedule items.  |  [optional] |
|**periodStartDate** | **LocalDate** | Indicates the updated collection date for the next pending payment schedule item.  |  [optional] |
|**runHour** | **Integer** | Specifies at which hour of the day in the tenant’s time zone this payment will be collected. Available values: &#x60;[0,1,2,~,22,23]&#x60;.    If the time difference between your tenant’s timezone and the timezone where Zuora servers are is not in full hours, for example, 2.5 hours, the payment schedule items will be triggered half hour later than your scheduled time. If the payment &#x60;runHour&#x60; and &#x60;scheduledDate&#x60; are backdated, the system will collect the payment when the next runHour occurs.  |  [optional] |



## Enum: PeriodEnum

| Name | Value |
|---- | -----|
| MONTHLY | &quot;Monthly&quot; |
| WEEKLY | &quot;Weekly&quot; |
| BIWEEKLY | &quot;BiWeekly&quot; |



