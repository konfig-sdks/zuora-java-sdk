

# PaymentInvoiceApplicationUnapplyRequestType


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**amount** | **Double** | The amount of the payment that is unapplied from the invoice.  |  |
|**invoiceId** | **String** | The unique ID of the invoice that the payment is unapplied from.  |  [optional] |
|**invoiceNumber** | **String** | The number of the invoice that the payment is unapplied from. For example, &#x60;INV00000001&#x60;.   **Note:** When both the &#x60;invoiceNumber&#x60; and &#x60;invoiceId&#x60; fields are specified, the two fields must match with each other.  |  [optional] |
|**items** | [**List&lt;PaymentInvoiceApplicationItemUnapplyRequestType&gt;**](PaymentInvoiceApplicationItemUnapplyRequestType.md) | Container for invoice items. The maximum number of items is 1,000.  **Note:** This field is only available if you have the [Invoice Item Settlement](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/Invoice_Settlement/C_Invoice_Item_Settlement) feature enabled. Invoice Item Settlement must be used together with other Invoice Settlement features (Unapplied Payments, and Credit and Debit memos).  If you wish to enable Invoice Settlement, see [Invoice Settlement Enablement and Checklist Guide](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/Invoice_Settlement/Invoice_Settlement_Migration_Checklist_and_Guide) for more information.  |  [optional] |



