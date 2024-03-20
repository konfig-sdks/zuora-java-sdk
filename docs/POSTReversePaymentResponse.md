

# POSTReversePaymentResponse


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**accountId** | **String** | The ID of the customer account that the payment is for.  |  [optional] |
|**amount** | **Double** | The total amount of the payment.  |  [optional] |
|**cancelledOn** | **OffsetDateTime** | The date and time when the payment was cancelled, in &#x60;yyyy-mm-dd hh:mm:ss&#x60; format.  |  [optional] |
|**comment** | **String** | Comments about the payment.  |  [optional] |
|**createdById** | **String** | The ID of the Zuora user who created the refund.  |  [optional] |
|**createdDate** | **OffsetDateTime** | The date and time when the chargeback is created, in &#x60;yyyy-mm-dd hh:mm:ss&#x60; format. For example, 2019-03-01 15:31:10.  |  [optional] |
|**creditMemoId** | **String** | The ID of the credit memo that is refunded.  |  [optional] |
|**financeInformation** | [**POSTReversePaymentResponseFinanceInformation**](POSTReversePaymentResponseFinanceInformation.md) |  |  [optional] |
|**gatewayId** | **String** | The ID of the gateway instance that processes the payment.  |  [optional] |
|**gatewayReconciliationReason** | **String** | The reason of gateway reconciliation.  |  [optional] |
|**gatewayReconciliationStatus** | **String** | The status of gateway reconciliation.  |  [optional] |
|**gatewayResponse** | **String** | The message returned from the payment gateway for the payment. This message is gateway-dependent.  |  [optional] |
|**gatewayResponseCode** | **String** | The code returned from the payment gateway for the payment. This code is gateway-dependent.  |  [optional] |
|**gatewayState** | [**GatewayStateEnum**](#GatewayStateEnum) | The status of the payment in the gateway; specifically used for reconciliation.  |  [optional] |
|**id** | **String** | The ID of the payment chargeback.  |  [optional] |
|**markedForSubmissionOn** | **OffsetDateTime** | The date and time when a charge was marked and waiting for batch submission to the payment process, in &#x60;yyyy-mm-dd hh:mm:ss&#x60; format.  |  [optional] |
|**methodType** | [**MethodTypeEnum**](#MethodTypeEnum) | How an external refund was issued to a customer.   |  [optional] |
|**number** | **String** | The unique identification number of the payment. For example, P-00000001.  |  [optional] |
|**organizationLabel** | **String** | The organization that this object belongs to.  Note: This field is available only when the Multi-Org feature is enabled.  |  [optional] |
|**paymentId** | **String** | The ID of the payment that is refunded.  |  [optional] |
|**paymentMethodId** | **String** | The unique ID of the payment method that the customer used to make the payment.  |  [optional] |
|**paymentMethodSnapshotId** | **String** | The unique ID of the payment method snapshot which is a copy of the particular Payment Method used in a transaction.  |  [optional] |
|**payoutId** | **String** | The payout ID from the gateway side.  |  [optional] |
|**reasonCode** | **String** | A code identifying the reason for the transaction.     |  [optional] |
|**referenceId** | **String** | The transaction ID returned by the payment gateway for an electronic refund. Use this field to reconcile refunds between your gateway and Zuora Payments.  |  [optional] |
|**refundDate** | **LocalDate** | The date when the refund takes effect, in &#x60;yyyy-mm-dd&#x60; format. For example, 2017-03-01.  |  [optional] |
|**refundTransactionTime** | **OffsetDateTime** | The date and time when the refund was issued, in &#x60;yyyy-mm-dd hh:mm:ss&#x60; format.  |  [optional] |
|**secondRefundReferenceId** | **String** | The transaction ID returned by the payment gateway if there is an additional refund.   |  [optional] |
|**settledOn** | **OffsetDateTime** | The date and time when the transaction is settled, in &#x60;yyyy-mm-dd hh:mm:ss&#x60; format.  |  [optional] |
|**softDescriptor** | **String** | A payment gateway-specific field that maps Zuora to other gateways.  |  [optional] |
|**softDescriptorPhone** | **String** | A payment gateway-specific field that maps Zuora to other gateways.            |  [optional] |
|**status** | **String** | The status of the payment.  |  [optional] |
|**submittedOn** | **OffsetDateTime** | The date and time when the payment was submitted, in yyyy-mm-dd hh:mm:ss format.  |  [optional] |
|**success** | **Boolean** | Returns &#x60;true&#x60; if the request was processed successfully.  |  [optional] |
|**type** | [**TypeEnum**](#TypeEnum) | The type of the payment.  |  [optional] |
|**updatedById** | **String** | The ID of the Zuora user who last updated the payment.  |  [optional] |
|**updatedDate** | **OffsetDateTime** | The date and time when the payment was last updated, in &#x60;yyyy-mm-dd hh:mm:ss&#x60; format. For example, 2019-03-02 15:36:10.  |  [optional] |



## Enum: GatewayStateEnum

| Name | Value |
|---- | -----|
| SUBMITTED | &quot;Submitted&quot; |
| NOTSUBMITTED | &quot;NotSubmitted&quot; |
| SETTLED | &quot;Settled&quot; |
| FAILEDTOSETTLE | &quot;FailedToSettle&quot; |



## Enum: MethodTypeEnum

| Name | Value |
|---- | -----|
| ACH | &quot;ACH&quot; |
| CASH | &quot;Cash&quot; |
| CHECK | &quot;Check&quot; |
| CREDITCARD | &quot;CreditCard&quot; |
| PAYPAL | &quot;PayPal&quot; |
| WIRETRANSFER | &quot;WireTransfer&quot; |
| DEBITCARD | &quot;DebitCard&quot; |
| CREDITCARDREFERENCETRANSACTION | &quot;CreditCardReferenceTransaction&quot; |
| BANKTRANSFER | &quot;BankTransfer&quot; |
| OTHER | &quot;Other&quot; |



## Enum: TypeEnum

| Name | Value |
|---- | -----|
| EXTERNAL | &quot;External&quot; |
| ELECTRONIC | &quot;Electronic&quot; |



