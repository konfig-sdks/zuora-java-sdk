

# PUTPaymentScheduleItemRequest


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**description** | **String** | The description of the payment schedule item.  |  [optional] |
|**amount** | **Double** | The amount of the payment.  |  [optional] |
|**currency** | **String** | The currency of the payment.  |  [optional] |
|**linkPayments** | **List&lt;String&gt;** | Container for payments linked to the payment schedule item.  |  [optional] |
|**paymentGatewayId** | **String** | ID of the payment gateway of the payment schedule item.  |  [optional] |
|**paymentId** | **String** | ID of the payment to be linked to the payment schedule item.  **Note**: This feild is version controlled. To enable this field, you must set &#x60;zuora-version&#x60; to equal or smaller than &#x60;336.0&#x60;.  |  [optional] |
|**paymentMethodId** | **String** | ID of the payment method of the payment schedule item.  |  [optional] |
|**paymentOption** | [**List&lt;PaymentSchedulePaymentOptionFields&gt;**](PaymentSchedulePaymentOptionFields.md) | Container for the paymentOption items, which describe the transactional level rules for processing payments. Currently, only the Gateway Options type is supported.  Here is an example: &#x60;&#x60;&#x60; \&quot;paymentOption\&quot;: [   {     \&quot;type\&quot;: \&quot;GatewayOptions\&quot;,     \&quot;detail\&quot;: {       \&quot;SecCode\&quot;:\&quot;WEB\&quot;     }   } ] &#x60;&#x60;&#x60;  &#x60;paymentOption&#x60; of the payment schedule takes precedence over &#x60;paymentOption&#x60; of the payment schedule item.  |  [optional] |
|**runHour** | **Integer** | At which hour of the day in the tenant’s timezone this payment will be collected. If the payment &#x60;runHour&#x60; and &#x60;scheduledDate&#x60; are backdated, the system will collect the payment when the next runHour occurs.  |  [optional] |
|**scheduledDate** | **LocalDate** | The scheduled date when the payment is processed.  |  [optional] |
|**unlinkPayments** | **List&lt;String&gt;** | Container for payments to be unlinked from the payment schedule item.  |  [optional] |



