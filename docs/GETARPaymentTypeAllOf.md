

# GETARPaymentTypeAllOf


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**accountId** | **String** | The ID of the customer account that the payment is for.  |  [optional] |
|**accountNumber** | **String** | The number of the customer account that the payment is for.  |  [optional] |
|**amount** | **Double** | The total amount of the payment.  |  [optional] |
|**appliedAmount** | **Double** | The applied amount of the payment.  |  [optional] |
|**authTransactionId** | **String** | The authorization transaction ID from the payment gateway.  |  [optional] |
|**bankIdentificationNumber** | **String** | The first six or eight digits of the credit card or debit card used for the payment, when applicable.  |  [optional] |
|**cancelledOn** | **OffsetDateTime** | The date and time when the payment was cancelled, in &#x60;yyyy-mm-dd hh:mm:ss&#x60; format.  |  [optional] |
|**comment** | **String** | Comments about the payment.  |  [optional] |
|**createdById** | **String** | The ID of the Zuora user who created the payment.  |  [optional] |
|**createdDate** | **OffsetDateTime** | The date and time when the payment was created, in &#x60;yyyy-mm-dd hh:mm:ss&#x60; format. For example, 2017-03-01 15:31:10.  |  [optional] |
|**creditBalanceAmount** | **Double** | The amount that the payment transfers to the credit balance. The value is not &#x60;0&#x60; only for those payments that come from legacy payment operations performed without the Invoice Settlement feature.  |  [optional] |
|**currency** | **String** | When Standalone Payment is not enabled, the &#x60;currency&#x60; of the payment must be the same as the payment currency defined in the customer account settings through Zuora UI.  When Standalone Payment is enabled and &#x60;standalone&#x60; is &#x60;true&#x60;, the &#x60;currency&#x60; of the standalone payment can be different from the payment currency defined in the customer account settings. The amount will not be summed up to the account balance or key metrics regardless of currency.  |  [optional] |
|**effectiveDate** | **OffsetDateTime** | The date and time when the payment takes effect, in &#x60;yyyy-mm-dd hh:mm:ss&#x60; format.  |  [optional] |
|**financeInformation** | [**GETARPaymentTypewithSuccessAllOfFinanceInformation**](GETARPaymentTypewithSuccessAllOfFinanceInformation.md) |  |  [optional] |
|**gatewayId** | **String** | The ID of the gateway instance that processes the payment.  |  [optional] |
|**gatewayOrderId** | **String** | A merchant-specified natural key value that can be passed to the electronic payment gateway when a payment is created.  If not specified, the payment number will be passed in instead.  |  [optional] |
|**gatewayReconciliationReason** | **String** | The reason of gateway reconciliation.  |  [optional] |
|**gatewayReconciliationStatus** | **String** | The status of gateway reconciliation.  |  [optional] |
|**gatewayResponse** | **String** | The message returned from the payment gateway for the payment. This message is gateway-dependent.  |  [optional] |
|**gatewayResponseCode** | **String** | The code returned from the payment gateway for the payment. This code is gateway-dependent.  |  [optional] |
|**gatewayState** | [**GatewayStateEnum**](#GatewayStateEnum) | The status of the payment in the gateway; use for reconciliation.  |  [optional] |
|**id** | **String** | The unique ID of the created payment. For example, 4028905f5a87c0ff015a87eb6b75007f.  |  [optional] |
|**markedForSubmissionOn** | **OffsetDateTime** | The date and time when a payment was marked and waiting for batch submission to the payment process, in &#x60;yyyy-mm-dd hh:mm:ss&#x60; format.  |  [optional] |
|**number** | **String** | The unique identification number of the payment. For example, P-00000001.  |  [optional] |
|**organizationLabel** | **String** | The organization that this object belongs to.  Note: This field is available only when the Multi-Org feature is enabled.  |  [optional] |
|**paymentGatewayNumber** | **String** | The natural key for the payment gateway.  |  [optional] |
|**paymentMethodId** | **String** | The unique ID of the payment method that the customer used to make the payment.  |  [optional] |
|**paymentMethodSnapshotId** | **String** | The unique ID of the payment method snapshot which is a copy of the particular Payment Method used in a transaction.  |  [optional] |
|**paymentScheduleKey** | **String** | The unique ID or the number of the payment schedule that is linked to the payment. See [Link payments to payment schedules](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/Payment_Schedules/Link_payments_with_payment_schedules) for more information. |  [optional] |
|**payoutId** | **String** | The payout ID of the payment from the gateway side.  |  [optional] |
|**prepayment** | **Boolean** | Indicates whether the payment is used as a reserved payment. See [Prepaid Cash with Drawdown](https://knowledgecenter.zuora.com/Zuora_Billing/Billing_and_Invoicing/JA_Advanced_Consumption_Billing/Prepaid_Cash_with_Drawdown) for more information.  |  [optional] |
|**referenceId** | **String** | The transaction ID returned by the payment gateway. Use this field to reconcile payments between your gateway and Zuora Payments.  |  [optional] |
|**refundAmount** | **Double** | The amount of the payment that is refunded.  |  [optional] |
|**secondPaymentReferenceId** | **String** | The transaction ID returned by the payment gateway if there is an additional transaction for the payment. Use this field to reconcile payments between your gateway and Zuora Payments.  |  [optional] |
|**settledOn** | **OffsetDateTime** | The date and time when the payment was settled in the payment processor, in &#x60;yyyy-mm-dd hh:mm:ss&#x60; format. This field is used by the Spectrum gateway only and not applicable to other gateways.  |  [optional] |
|**softDescriptor** | **String** | A payment gateway-specific field that maps to Zuora for the gateways, Orbital, Vantiv and Verifi.  |  [optional] |
|**softDescriptorPhone** | **String** | A payment gateway-specific field that maps to Zuora for the gateways, Orbital, Vantiv and Verifi.  |  [optional] |
|**standalone** | **Boolean** | This field is only available if the support for standalone payment is enabled. This field is not available for transferring, applying, or unapplying a payment.  The value &#x60;true&#x60; indicates this is a standalone payment that is created and processed in Zuora through Zuora gateway integration but will be settled outside of Zuora. No settlement data will be created. The standalone payment cannot be applied, unapplied, or transferred.  The value &#x60;false&#x60; indicates this is an ordinary payment that is created, processed, and settled in Zuora.  |  [optional] |
|**status** | [**StatusEnum**](#StatusEnum) | The status of the payment.  |  [optional] |
|**submittedOn** | **OffsetDateTime** | The date and time when the payment was submitted, in &#x60;yyyy-mm-dd hh:mm:ss&#x60; format.  |  [optional] |
|**success** | **Boolean** | Returns &#x60;true&#x60; if the request was processed successfully. |  [optional] |
|**type** | [**TypeEnum**](#TypeEnum) | The type of the payment.  |  [optional] |
|**unappliedAmount** | **Double** | The unapplied amount of the payment.  |  [optional] |
|**updatedById** | **String** | The ID of the Zuora user who last updated the payment.  |  [optional] |
|**updatedDate** | **OffsetDateTime** | The date and time when the payment was last updated, in &#x60;yyyy-mm-dd hh:mm:ss&#x60; format. For example, 2017-03-02 15:36:10.  |  [optional] |



## Enum: GatewayStateEnum

| Name | Value |
|---- | -----|
| MARKEDFORSUBMISSION | &quot;MarkedForSubmission&quot; |
| SUBMITTED | &quot;Submitted&quot; |
| SETTLED | &quot;Settled&quot; |
| NOTSUBMITTED | &quot;NotSubmitted&quot; |
| FAILEDTOSETTLE | &quot;FailedToSettle&quot; |



## Enum: StatusEnum

| Name | Value |
|---- | -----|
| DRAFT | &quot;Draft&quot; |
| PROCESSING | &quot;Processing&quot; |
| PROCESSED | &quot;Processed&quot; |
| ERROR | &quot;Error&quot; |
| CANCELED | &quot;Canceled&quot; |
| POSTED | &quot;Posted&quot; |



## Enum: TypeEnum

| Name | Value |
|---- | -----|
| EXTERNAL | &quot;External&quot; |
| ELECTRONIC | &quot;Electronic&quot; |



