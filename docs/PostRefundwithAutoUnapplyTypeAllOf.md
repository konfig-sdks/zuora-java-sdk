

# PostRefundwithAutoUnapplyTypeAllOf


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**comment** | **String** | Comments about the refund.  |  [optional] |
|**debitMemos** | [**List&lt;PaymentDebitMemoApplicationApplyRequestType&gt;**](PaymentDebitMemoApplicationApplyRequestType.md) | Container for debit memos. The maximum number of debit memos is 1,000.  |  [optional] |
|**financeInformation** | [**PostRefundTypeAllOfFinanceInformation**](PostRefundTypeAllOfFinanceInformation.md) |  |  [optional] |
|**gatewayOptions** | [**PostRefundTypeAllOfGatewayOptions**](PostRefundTypeAllOfGatewayOptions.md) |  |  [optional] |
|**invoices** | [**List&lt;PaymentInvoiceApplicationApplyRequestType&gt;**](PaymentInvoiceApplicationApplyRequestType.md) | Container for invoices. The maximum number of invoices is 1,000.  |  [optional] |
|**methodType** | [**MethodTypeEnum**](#MethodTypeEnum) | How an external refund was issued to a customer. This field is required for an external refund and must be left empty for an electronic refund. You can issue an external refund on an electronic payment.  |  [optional] |
|**reasonCode** | **String** | A code identifying the reason for the transaction. The value must be an existing reason code or empty. If you do not specify a value, Zuora uses the default reason code.  |  [optional] |
|**referenceId** | **String** | The transaction ID returned by the payment gateway for an electronic refund. Use this field to reconcile refunds between your gateway and Zuora Payments.  |  [optional] |
|**refundDate** | **LocalDate** | The date when the refund takes effect, in &#x60;yyyy-mm-dd&#x60; format. The date of the refund cannot be before the payment date. Specify this field only for external refunds. Zuora automatically generates this field for electronic refunds.  |  [optional] |
|**secondRefundReferenceId** | **String** | The transaction ID returned by the payment gateway if there is an additional transaction for the refund. Use this field to reconcile payments between your gateway and Zuora Payments.  |  [optional] |
|**softDescriptor** | **String** | A payment gateway-specific field that maps to Zuora for the gateways, Orbital, Vantiv and Verifi. |  [optional] |
|**softDescriptorPhone** | **String** | A payment gateway-specific field that maps to Zuora for the gateways, Orbital, Vantiv and Verifi. |  [optional] |
|**totalAmount** | **Double** | The total amount of the refund. If you do not specify a value, Zuora initiates a full refund of the payment amount, which is the sum of the applied and unapplied payment amounts.    - &#x60;Full Refund&#x60;: If the refund amount and debit memo/ invoice are not specified, then the payment will be unapplied completely, followed by processing a full refund.   - &#x60;Partial Refund&#x60;:        - If the total amount is specified, and the debit memo/invoice is not specified, you can unapply the refund amount from the available debit memo/invoice and refund the unapplied payment to the customer.        - If the total amount is specified, along with the debit memo and the invoice, you can unapply the applied payments from the mentioned invoices and debit memos, and refund the unapplied payments to customers.    |  [optional] |
|**type** | [**TypeEnum**](#TypeEnum) | The type of the refund.  |  |
|**refundTransactionType** | [**RefundTransactionTypeEnum**](#RefundTransactionTypeEnum) | The transaction type of the refund.  |  [optional] |
|**writeOff** | **Boolean** | Indicates whether to write off a document.  |  [optional] |
|**writeOffOptions** | [**PostRefundwithAutoUnapplyTypeAllOfWriteOffOptions**](PostRefundwithAutoUnapplyTypeAllOfWriteOffOptions.md) |  |  [optional] |



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



## Enum: RefundTransactionTypeEnum

| Name | Value |
|---- | -----|
| CHARGEBACK | &quot;Chargeback&quot; |
| PAYMENTREVERSAL | &quot;PaymentReversal&quot; |



