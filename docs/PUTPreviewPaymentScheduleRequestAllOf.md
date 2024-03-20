

# PUTPreviewPaymentScheduleRequestAllOf


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**amount** | **Double** | Indicates the updated amount of the pending payment schedule items.  |  [optional] |
|**currency** | **String** | Indicates the updated currency of the pending payment schedule items.        |  [optional] |
|**occurrences** | **Integer** | Indicates the updated number of payment schedule items that are created by the payment schedule.  |  [optional] |
|**paymentGatewayId** | **String** | Indicates the updated payment gateway ID of the pending payment schedule items.  |  [optional] |
|**paymentMethodId** | **String** | Indicates the updated payment method ID of the pending payment schedule items.   |  [optional] |
|**paymentOption** | [**List&lt;PaymentSchedulePaymentOptionFields&gt;**](PaymentSchedulePaymentOptionFields.md) | Container for the paymentOption items, which describe the transactional level rules for processing payments. Currently, only the Gateway Options type is supported.  Here is an example: &#x60;&#x60;&#x60; \&quot;paymentOption\&quot;: [   {     \&quot;type\&quot;: \&quot;GatewayOptions\&quot;,     \&quot;detail\&quot;: {       \&quot;SecCode\&quot;:\&quot;WEB\&quot;     }   } ] &#x60;&#x60;&#x60;  &#x60;paymentOption&#x60; of the payment schedule takes precedence over &#x60;paymentOption&#x60; of the payment schedule item.  |  [optional] |
|**period** | [**PeriodEnum**](#PeriodEnum) | Indicates the updated period of the pending payment schedule items.  |  [optional] |
|**periodStartDate** | **LocalDate** | Indicates the updated collection date for the next pending payment schedule item.  |  [optional] |
|**runHour** | **Integer** | Specifies at which hour of the day in the tenant’s time zone this payment will be collected. Available values: &#x60;[0,1,2,~,22,23]&#x60;.    If the time difference between your tenant’s timezone and the timezone where Zuora servers are is not in full hours, for example, 2.5 hours, the payment schedule items will be triggered half hour later than your scheduled time. If the payment &#x60;runHour&#x60; and &#x60;scheduledDate&#x60; are backdated, the system will collect the payment when the next runHour occurs.  |  [optional] |



## Enum: PeriodEnum

| Name | Value |
|---- | -----|
| MONTHLY | &quot;Monthly&quot; |
| WEEKLY | &quot;Weekly&quot; |
| BIWEEKLY | &quot;BiWeekly&quot; |



