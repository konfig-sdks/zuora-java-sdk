

# POSTReconcileRefundResponse


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**accountId** | **String** | The ID of the customer account that the refund is for.  |  [optional] |
|**amount** | **Double** | The total amount of the refund.  |  [optional] |
|**cancelledOn** | **OffsetDateTime** | The date and time when the transaction was cancelled, in &#x60;yyyy-mm-dd hh:mm:ss&#x60; format.  |  [optional] |
|**comment** | **String** | Comments about the refund.  |  [optional] |
|**createdById** | **String** | The ID of the Zuora user who created the refund.  |  [optional] |
|**createdDate** | **OffsetDateTime** | The date and time when the refund is created, in &#x60;yyyy-mm-dd hh:mm:ss&#x60; format.  |  [optional] |
|**creditMemoId** | **String** | The ID of the credit memo that is refunded.  |  [optional] |
|**financeInformation** | [**POSTReconcileRefundResponseFinanceInformation**](POSTReconcileRefundResponseFinanceInformation.md) |  |  [optional] |
|**gatewayId** | **String** | The ID of the gateway instance that processes the refund.  |  [optional] |
|**gatewayReconciliationReason** | **String** | The reason of gateway reconciliation.  |  [optional] |
|**gatewayReconciliationStatus** | **String** | The status of gateway reconciliation.  |  [optional] |
|**gatewayResponse** | **String** | The message returned from the payment gateway for the refund. This message is gateway-dependent.  |  [optional] |
|**gatewayResponseCode** | **String** | The code returned from the payment gateway for the refund. This code is gateway-dependent.  |  [optional] |
|**gatewayState** | [**GatewayStateEnum**](#GatewayStateEnum) | The status of the refund in the gateway; specifically used for reconciliation.  |  [optional] |
|**id** | **String** | The ID of the refund.  |  [optional] |
|**markedForSubmissionOn** | **OffsetDateTime** | The date and time when a refund was marked and waiting for batch submission to the payment process, in &#x60;yyyy-mm-dd hh:mm:ss&#x60; format.  |  [optional] |
|**methodType** | [**MethodTypeEnum**](#MethodTypeEnum) | How an external refund was issued to a customer.   |  [optional] |
|**number** | **String** | The unique identification number of the refund. For example, R-00000001.  |  [optional] |
|**organizationLabel** | **String** | The organization that this object belongs to.  Note: This field is available only when the Multi-Org feature is enabled.  |  [optional] |
|**paymentId** | **String** | The ID of the payment that is refunded.  |  [optional] |
|**paymentMethodId** | **String** | The unique ID of the payment method that the customer used to make the refund.  |  [optional] |
|**paymentMethodSnapshotId** | **String** | The unique ID of the payment method snapshot which is a copy of the particular Payment Method used in a transaction.  |  [optional] |
|**payoutId** | **String** | The payout ID of the refund from the gateway side.  |  [optional] |
|**reasonCode** | **String** | A code identifying the reason for the transaction.        |  [optional] |
|**referenceId** | **String** | The transaction ID returned by the payment gateway for an electronic refund. Use this field to reconcile refunds between your gateway and Zuora Payments.  |  [optional] |
|**refundDate** | **LocalDate** | The date when the refund takes effect, in &#x60;yyyy-mm-dd&#x60; format. For example, 2020-03-01.         |  [optional] |
|**refundTransactionTime** | **OffsetDateTime** | The date and time when the refund was issued, in &#x60;yyyy-mm-dd hh:mm:ss&#x60; format.  |  [optional] |
|**secondRefundReferenceId** | **String** | The transaction ID returned by the payment gateway if there is an additional refund.   |  [optional] |
|**settledOn** | **OffsetDateTime** | The date and time when the transaction is settled, in &#x60;yyyy-mm-dd hh:mm:ss&#x60; format.  |  [optional] |
|**softDescriptor** | **String** | A payment gateway-specific field that maps Zuora to other gateways.  |  [optional] |
|**softDescriptorPhone** | **String** | A payment gateway-specific field that maps Zuora to other gateways.            |  [optional] |
|**status** | **String** | The status of the refund.  |  [optional] |
|**submittedOn** | **OffsetDateTime** | The date and time when the refund was submitted, in yyyy-mm-dd hh:mm:ss format.  |  [optional] |
|**success** | **Boolean** | Indicates if the request is processed successfully.  |  [optional] |
|**type** | [**TypeEnum**](#TypeEnum) | The type of the refund.  |  [optional] |
|**updatedById** | **String** | The ID of the Zuora user who last updated the refund.  |  [optional] |
|**updatedDate** | **OffsetDateTime** | The date and time when the refund was last updated, in &#x60;yyyy-mm-dd hh:mm:ss&#x60; format.  |  [optional] |



## Enum: GatewayStateEnum

| Name | Value |
|---- | -----|
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



