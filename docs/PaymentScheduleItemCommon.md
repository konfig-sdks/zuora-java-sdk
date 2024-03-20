

# PaymentScheduleItemCommon


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**description** | **String** | Description of the payment schedule item.  |  [optional] |
|**amount** | **Double** | The amount that needs to be collected by this payment schedule item.  |  |
|**currency** | **String** | The currency of the payment.  **Note**: - This field is optional. If not specified, the default value is the currency set for the account.  |  [optional] |
|**paymentGatewayId** | **String** | The ID of the payment gateway.  **Note**: - This field is optional. If not specified, the default value is the payment gateway id set for the account.  |  [optional] |
|**paymentMethodId** | **String** | The ID of the payment method.  **Note**: - This field is optional. If not specified, the default value is the payment method id set for the account.  |  [optional] |
|**paymentOption** | [**List&lt;PaymentSchedulePaymentOptionFields&gt;**](PaymentSchedulePaymentOptionFields.md) | Container for the paymentOption items, which describe the transactional level rules for processing payments. Currently, only the Gateway Options type is supported.  Here is an example: &#x60;&#x60;&#x60; \&quot;paymentOption\&quot;: [   {     \&quot;type\&quot;: \&quot;GatewayOptions\&quot;,     \&quot;detail\&quot;: {       \&quot;SecCode\&quot;:\&quot;WEB\&quot;     }   } ] &#x60;&#x60;&#x60;  &#x60;paymentOption&#x60; of the payment schedule takes precedence over &#x60;paymentOption&#x60; of the payment schedule item.  |  [optional] |
|**runHour** | **String** | At which hour of the day in the tenant’s timezone this payment will be collected. Available values:&#x60;[0,1,2,~,22,23]&#x60;. If the payment &#x60;runHour&#x60; and &#x60;scheduledDate&#x60; are backdated, the system will collect the payment when the next runHour occurs. The default value is &#x60;0&#x60;.  |  [optional] |
|**scheduledDate** | **LocalDate** | The date to collect the payment.  |  |



