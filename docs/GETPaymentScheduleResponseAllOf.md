

# GETPaymentScheduleResponseAllOf


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**description** | **String** | The description of the payment schedule.  |  [optional] |
|**accountId** | **String** | ID of the account that owns the payment schedule.  |  [optional] |
|**accountNumber** | **String** | Number of the account that owns the payment schedule.  |  [optional] |
|**billingDocument** | [**GETPaymentScheduleItemResponseAllOfBillingDocument**](GETPaymentScheduleItemResponseAllOfBillingDocument.md) |  |  [optional] |
|**createdById** | **String** | The ID of the user who created this payment schedule.  |  [optional] |
|**createdDate** | **LocalDate** | The date and time the payment schedule is created.  |  [optional] |
|**id** | **String** | ID of the payment schedule.  |  [optional] |
|**isCustom** | **Boolean** | Indicates if the payment schedule is a custom payment schedule.  |  [optional] |
|**items** | [**List&lt;PaymentScheduleItemCommonResponse&gt;**](PaymentScheduleItemCommonResponse.md) | Container for payment schedule items.  |  [optional] |
|**nextPaymentDate** | **LocalDate** | The date the next payment will be processed.  |  [optional] |
|**occurrences** | **Integer** | The number of payment schedule items that are created by this payment schedule.  |  [optional] |
|**paymentOption** | [**List&lt;PaymentSchedulePaymentOptionFields&gt;**](PaymentSchedulePaymentOptionFields.md) | Container for the paymentOption items, which describe the transactional level rules for processing payments. Currently, only the Gateway Options type is supported.  &#x60;paymentOption&#x60; of the payment schedule takes precedence over &#x60;paymentOption&#x60; of the payment schedule item.  |  [optional] |
|**paymentScheduleNumber** | **String** | Number of the payment schedule.  |  [optional] |
|**period** | **String** | For recurring payment schedule only. The period of payment generation. Available values include: &#x60;Monthly&#x60;, &#x60;Weekly&#x60;, &#x60;BiWeekly&#x60;.  Return &#x60;null&#x60; for custom payment schedules.  |  [optional] |
|**prepayment** | **Boolean** | Indicates whether the payments created by the payment schedule are used as a reserved payment. This field is available only if the prepaid cash drawdown permission is enabled. See [Prepaid Cash with Drawdown](https://knowledgecenter.zuora.com/Zuora_Billing/Billing_and_Invoicing/JA_Advanced_Consumption_Billing/Prepaid_Cash_with_Drawdown) for more information.  |  [optional] |
|**recentPaymentDate** | **LocalDate** | The date the last payment was processed.  |  [optional] |
|**runHour** | **Integer** | [0,1,2,~,22,23]  At which hour in the day in the tenant’s timezone this payment will be collected.  Return &#x60;0&#x60; for custom payment schedules.  |  [optional] |
|**standalone** | **Boolean** | Indicates if the payments that the payment schedule created are standalone payments.  |  [optional] |
|**startDate** | **LocalDate** | The date when the first payment of this payment schedule is proccessed.  |  [optional] |
|**status** | [**StatusEnum**](#StatusEnum) | The status of the payment schedule.  - Active: There is still payment schedule item to process. - Canceled: After a payment schedule is canceled by the user, the schedule is marked as &#x60;Canceled&#x60;. - Completed: After all payment schedule items are processed, the schedule is marked as &#x60;Completed&#x60;.  |  [optional] |
|**success** | **Boolean** | Returns &#x60;true&#x60; if the request was processed successfully.          |  [optional] |
|**totalAmount** | **Double** | The total amount that will be collected by the payment schedule.  |  [optional] |
|**totalPaymentsErrored** | **Integer** | The number of errored payments.  |  [optional] |
|**totalPaymentsProcessed** | **Integer** | The number of processed payments.  |  [optional] |
|**updatedById** | **String** | The ID of the user who last updated this payment schedule.  |  [optional] |
|**updatedDate** | **LocalDate** | The date and time the payment schedule is last updated.  |  [optional] |



## Enum: StatusEnum

| Name | Value |
|---- | -----|
| ACTIVE | &quot;Active&quot; |
| CANCELED | &quot;Canceled&quot; |
| COMPLETED | &quot;Completed&quot; |



