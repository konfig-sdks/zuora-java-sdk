

# PostNonRefRefundTypeAllOf


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**comment** | **String** | Comments about the refund.  |  [optional] |
|**customRates** | [**List&lt;CreditMemoFromChargeCustomRatesType&gt;**](CreditMemoFromChargeCustomRatesType.md) | It contains Home currency and Reporting currency custom rates currencies. The maximum number of items is 2 (you can pass the Home currency item, Reporting currency item, or both).  **Note**: The API custom rate feature is permission controlled.  |  [optional] |
|**financeInformation** | [**PostNonRefRefundTypeAllOfFinanceInformation**](PostNonRefRefundTypeAllOfFinanceInformation.md) |  |  [optional] |
|**gatewayId** | **String** | The ID of the gateway instance that processes the refund. This field can be specified only for electronic refunds. The ID must be a valid gateway instance ID, and this gateway must support the specific payment method.   If no gateway ID is specified, the default gateway in the billing account configuration will be used. If no gateway is specified in the billing account, the default gateway of the corresponding tenant will be used.  |  [optional] |
|**gatewayOptions** | [**PostNonRefRefundTypeAllOfGatewayOptions**](PostNonRefRefundTypeAllOfGatewayOptions.md) |  |  [optional] |
|**items** | [**List&lt;RefundCreditMemoItemType&gt;**](RefundCreditMemoItemType.md) | Container for credit memo items. The maximum number of items is 1,000.  **Note:** This field is only available if you have the [Invoice Item Settlement](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/Invoice_Settlement/C_Invoice_Item_Settlement) feature enabled. Invoice Item Settlement must be used together with other Invoice Settlement features (Unapplied Payments, and Credit and Debit memos).  If you wish to enable Invoice Settlement, see [Invoice Settlement Enablement and Checklist Guide](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/Invoice_Settlement/Invoice_Settlement_Migration_Checklist_and_Guide) for more information.  |  [optional] |
|**methodType** | [**MethodTypeEnum**](#MethodTypeEnum) | How an external refund was issued to a customer. This field is required for an external refund and must be left empty for an electronic refund. You can issue an external refund on a credit memo.  |  [optional] |
|**paymentMethodId** | **String** | The ID of the payment method used for the refund. This field is required for an electronic refund, and the value must be an electronic payment method ID. This field must be left empty for an external refund.   |  [optional] |
|**reasonCode** | **String** | A code identifying the reason for the transaction. The value must be an existing reason code or empty. If you do not specify a value, Zuora uses the default reason code.  |  [optional] |
|**referenceId** | **String** | The transaction ID returned by the payment gateway for an electronic refund. Use this field to reconcile refunds between your gateway and Zuora Payments.  |  [optional] |
|**refundDate** | **LocalDate** | The date when the refund takes effect, in &#x60;yyyy-mm-dd&#x60; format. The date of the refund cannot be before the credit memo date. Specify this field only for external refunds. Zuora automatically generates this field for electronic refunds.  |  [optional] |
|**secondRefundReferenceId** | **String** | The transaction ID returned by the payment gateway if there is an additional transaction for the refund. Use this field to reconcile payments between your gateway and Zuora Payments.  |  [optional] |
|**softDescriptor** | **String** | A payment gateway-specific field that maps to Zuora for the gateways, Orbital, Vantiv and Verifi. |  [optional] |
|**softDescriptorPhone** | **String** | A payment gateway-specific field that maps to Zuora for the gateways, Orbital, Vantiv and Verifi. |  [optional] |
|**totalAmount** | **Double** | The total amount of the refund. The amount cannot exceed the unapplied amount of the associated credit memo. If the original credit memo was applied to one or more invoices or debit memos, you have to unapply a full or partial credit memo from the invoices or debit memos, and then refund the full or partial unapplied credit memo to your customers.  |  |
|**type** | [**TypeEnum**](#TypeEnum) | The type of the refund.  |  |



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



