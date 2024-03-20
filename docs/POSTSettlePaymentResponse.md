

# POSTSettlePaymentResponse


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**accountId** | **String** | The ID of the customer account that the payment is for.  |  [optional] |
|**amount** | **Double** | The total amount of the payment.  |  [optional] |
|**appliedAmount** | **Double** | The applied amount of the payment.  |  [optional] |
|**authTransactionId** | **String** | The authorization transaction ID from the payment gateway.  |  [optional] |
|**bankIdentificationNumber** | **String** | The first six or eight digits of the credit card or debit card used for the payment, when applicable.  |  [optional] |
|**cancelledOn** | **OffsetDateTime** | The date and time when the payment was cancelled, in &#x60;yyyy-mm-dd hh:mm:ss&#x60; format.  |  [optional] |
|**comment** | **String** | Comments about the payment.  |  [optional] |
|**createdById** | **String** | The ID of the Zuora user who created the refund.  |  [optional] |
|**createdDate** | **OffsetDateTime** | The date and time when the chargeback is created, in &#x60;yyyy-mm-dd hh:mm:ss&#x60; format. For example, 2019-03-01 15:31:10.  |  [optional] |
|**creditBalanceAmount** | **Double** | The amount that the payment transfers to the credit balance. The value is not &#x60;0&#x60; only for those payments that come from legacy payment operations performed without the Invoice Settlement feature.  |  [optional] |
|**currency** | **String** | A currency defined in the web-based UI administrative settings.  |  [optional] |
|**effectiveDate** | **OffsetDateTime** | The date and time when the payment takes effect, in &#x60;yyyy-mm-dd hh:mm:ss&#x60; format.  |  [optional] |
|**financeInformation** | [**POSTReversePaymentResponseFinanceInformation**](POSTReversePaymentResponseFinanceInformation.md) |  |  [optional] |
|**gatewayId** | **String** | The ID of the gateway instance that processes the payment.  |  [optional] |
|**gatewayOrderId** | **String** | A merchant-specified natural key value that can be passed to the electronic payment gateway when a payment is created. If not specified, the payment number will be passed in instead.  |  [optional] |
|**gatewayReconciliationReason** | **String** | The reason of gateway reconciliation.  |  [optional] |
|**gatewayReconciliationStatus** | **String** | The status of gateway reconciliation.  |  [optional] |
|**gatewayResponse** | **String** | The message returned from the payment gateway for the payment. This message is gateway-dependent.  |  [optional] |
|**gatewayResponseCode** | **String** | The code returned from the payment gateway for the payment. This code is gateway-dependent.  |  [optional] |
|**gatewayState** | [**GatewayStateEnum**](#GatewayStateEnum) | The status of the payment in the gateway; specifically used for reconciliation.  |  [optional] |
|**id** | **String** | The ID of the payment chargeback.  |  [optional] |
|**markedForSubmissionOn** | **OffsetDateTime** | The date and time when a charge was marked and waiting for batch submission to the payment process, in &#x60;yyyy-mm-dd hh:mm:ss&#x60; format.  |  [optional] |
|**number** | **String** | The unique identification number of the payment. For example, P-00000001.  |  [optional] |
|**organizationLabel** | **String** | The organization that this object belongs to.  Note: This field is available only when the Multi-Org feature is enabled.  |  [optional] |
|**paymentMethodId** | **String** | The unique ID of the payment method that the customer used to make the payment.  |  [optional] |
|**paymentMethodSnapshotId** | **String** | The unique ID of the payment method snapshot which is a copy of the particular Payment Method used in a transaction.  |  [optional] |
|**payoutId** | **String** | The payout ID from the gateway side.  |  [optional] |
|**referenceId** | **String** | The transaction ID returned by the payment gateway for an electronic refund. Use this field to reconcile refunds between your gateway and Zuora Payments.  |  [optional] |
|**refundAmount** | **Double** | The amount of the payment that is refunded.  |  [optional] |
|**secondPaymentReferenceId** | **String** | The transaction ID returned by the payment gateway if there is an additional transaction for the payment.   |  [optional] |
|**settledOn** | **OffsetDateTime** | The date and time when the transaction is settled, in &#x60;yyyy-mm-dd hh:mm:ss&#x60; format.  |  [optional] |
|**softDescriptor** | **String** | A payment gateway-specific field that maps Zuora to other gateways.  |  [optional] |
|**softDescriptorPhone** | **String** | A payment gateway-specific field that maps Zuora to other gateways.  |  [optional] |
|**status** | **String** | The status of the payment.  |  [optional] |
|**submittedOn** | **OffsetDateTime** | The date and time when the payment was submitted, in &#x60;yyyy-mm-dd hh:mm:ss&#x60; format.  |  [optional] |
|**success** | **Boolean** | Indicates if the request is processed successfully.  |  [optional] |
|**type** | [**TypeEnum**](#TypeEnum) | The type of the payment.  |  [optional] |
|**unappliedAmount** | **Double** | The unapplied amount of the payment.  |  [optional] |
|**updatedById** | **String** | The ID of the Zuora user who last updated the payment.  |  [optional] |
|**updatedDate** | **OffsetDateTime** | The date and time when the payment was last updated, in &#x60;yyyy-mm-dd hh:mm:ss&#x60; format. For example, 2019-03-02 15:36:10.  |  [optional] |



## Enum: GatewayStateEnum

| Name | Value |
|---- | -----|
| SUBMITTED | &quot;Submitted&quot; |
| NOTSUBMITTED | &quot;NotSubmitted&quot; |
| SETTLED | &quot;Settled&quot; |
| FAILEDTOSETTLE | &quot;FailedToSettle&quot; |



## Enum: TypeEnum

| Name | Value |
|---- | -----|
| EXTERNAL | &quot;External&quot; |
| ELECTRONIC | &quot;Electronic&quot; |



