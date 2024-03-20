

# PostRefundTypeAllOf


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**comment** | **String** | Comments about the refund.  |  [optional] |
|**customRates** | [**List&lt;PaymentWithCustomRatesType&gt;**](PaymentWithCustomRatesType.md) | It contains Home currency and Reporting currency custom rates currencies. The maximum number of items is 2 (you can pass the Home currency item, Reporting currency item, or both).  **Note**: The API custom rate feature is permission controlled.  |  [optional] |
|**financeInformation** | [**PostRefundTypeAllOfFinanceInformation**](PostRefundTypeAllOfFinanceInformation.md) |  |  [optional] |
|**gatewayOptions** | [**PostRefundTypeAllOfGatewayOptions**](PostRefundTypeAllOfGatewayOptions.md) |  |  [optional] |
|**methodType** | [**MethodTypeEnum**](#MethodTypeEnum) | How an external refund was issued to a customer. This field is required for an external refund and must be left empty for an electronic refund. You can issue an external refund on an electronic payment.  |  [optional] |
|**reasonCode** | **String** | A code identifying the reason for the transaction. The value must be an existing reason code or empty. If you do not specify a value, Zuora uses the default reason code.  |  [optional] |
|**referenceId** | **String** | The transaction ID returned by the payment gateway for an electronic refund. Use this field to reconcile refunds between your gateway and Zuora Payments.  |  [optional] |
|**refundDate** | **LocalDate** | The date when the refund takes effect, in &#x60;yyyy-mm-dd&#x60; format. The date of the refund cannot be before the payment date. Specify this field only for external refunds. Zuora automatically generates this field for electronic refunds.  |  [optional] |
|**secondRefundReferenceId** | **String** | The transaction ID returned by the payment gateway if there is an additional transaction for the refund. Use this field to reconcile payments between your gateway and Zuora Payments.  |  [optional] |
|**softDescriptor** | **String** | A payment gateway-specific field that maps to Zuora for the gateways, Orbital, Vantiv and Verifi. |  [optional] |
|**softDescriptorPhone** | **String** | A payment gateway-specific field that maps to Zuora for the gateways, Orbital, Vantiv and Verifi. |  [optional] |
|**totalAmount** | **Double** | The total amount of the refund. The amount cannot exceed the unapplied amount of the associated payment. If the original payment was applied to one or more invoices or debit memos, you have to unapply a full or partial payment from the invoices or debit memos, and then refund the full or partial unapplied payment to your customers.   |  |
|**type** | [**TypeEnum**](#TypeEnum) | The type of the refund.  |  |
|**refundTransactionType** | [**RefundTransactionTypeEnum**](#RefundTransactionTypeEnum) | The transaction type of the refund.  |  [optional] |



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



