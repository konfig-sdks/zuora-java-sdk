

# PaymentScheduleItemCommonResponse


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**description** | **String** | The description of the payment schedule item.  |  [optional] |
|**accountId** | **String** | ID of the customer account that owns the payment schedule item, for example &#x60;402880e741112b310149b7343ef81234&#x60;.  |  [optional] |
|**amount** | **Double** | The total amount of the payment schedule.  |  [optional] |
|**balance** | **Double** | The remaining balance of payment schedule item.  |  [optional] |
|**billingDocument** | [**PaymentScheduleItemCommonResponseAllOfBillingDocument**](PaymentScheduleItemCommonResponseAllOfBillingDocument.md) |  |  [optional] |
|**createdById** | **String** | The ID of the user who created the payment schedule item.  |  [optional] |
|**createdDate** | **LocalDate** | The date and time when the payment schedule item was created.  |  [optional] |
|**currency** | **String** | The currency of the payment.  |  [optional] |
|**errorMessage** | **String** | The error message indicating if the error is related to configuration or payment collection.  |  [optional] |
|**id** | **String** | ID of the payment schedule item. For example, &#x60;412880e749b72b310149b7343ef81346&#x60;.  |  [optional] |
|**number** | **String** | Number of the payment schedule item.  |  [optional] |
|**paymentGatewayId** | **String** | ID of the payment gateway of the payment schedule item.  |  [optional] |
|**paymentId** | **String** | ID of the payment that is created by the payment schedule item， or ID of the first payment linked to the payment schedule item. This field is only available if the request doesn’t specify &#x60;zuora-version&#x60;, or &#x60;zuora-version&#x60; is set to a value equal to or smaller than &#x60;336.0&#x60;.   |  [optional] |
|**paymentMethodId** | **String** | ID of the payment method of the payment schedule item.  |  [optional] |
|**paymentOption** | [**List&lt;PaymentSchedulePaymentOptionFields&gt;**](PaymentSchedulePaymentOptionFields.md) | Container for the paymentOption items, which describe the transactional level rules for processing payments. Currently, only the Gateway Options type is supported.  &#x60;paymentOption&#x60; of the payment schedule takes precedence over &#x60;paymentOption&#x60; of the payment schedule item.  |  [optional] |
|**paymentScheduleId** | **String** | ID of the payment schedule that contains the payment schedule item, for example, &#x60;ID402880e749b72b310149b7343ef80005&#x60;.  |  [optional] |
|**paymentScheduleNumber** | **String** | Number of the payment schedule that contains the payment schedule item, for example, &#x60;ID402880e749b72b310149b7343ef80005&#x60;.  |  [optional] |
|**psiPayments** | [**List&lt;LinkedPaymentID&gt;**](LinkedPaymentID.md) | Container for payments linked to the payment schedule item.   |  [optional] |
|**runHour** | **Integer** | At which hour in the day in the tenant’s timezone this payment will be collected.  |  [optional] |
|**scheduledDate** | **LocalDate** | The scheduled date when the payment is processed.  |  [optional] |
|**standalone** | **Boolean** | Indicates if the payment created by the payment schedule item is a standalone payment or not.  |  [optional] |
|**status** | [**StatusEnum**](#StatusEnum) | ID of the payment method of the payment schedule item.  - &#x60;Pending&#x60;: Payment schedule item is waiting for processing. - &#x60;Processed&#x60;: The payment has been collected. - &#x60;Error&#x60;: Failed to collect the payment. - &#x60;Canceled&#x60;: After a pending payment schedule item is canceled by the user, the item is marked as &#x60;Canceled&#x60;.  |  [optional] |
|**updatedById** | **String** | The ID of the user who updated the payment schedule item.  |  [optional] |
|**updatedDate** | **LocalDate** | The date and time when the payment schedule item was last updated.  |  [optional] |



## Enum: StatusEnum

| Name | Value |
|---- | -----|
| PENDING | &quot;Pending&quot; |
| PROCESSED | &quot;Processed&quot; |
| ERROR | &quot;Error&quot; |
| CANCELED | &quot;Canceled&quot; |



