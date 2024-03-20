

# PaymentInvoiceApplicationCreateRequestType


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**amount** | **Double** | The amount of the payment associated with the invoice. This amount must be equal to or lesser than the balance of the invoice.  |  |
|**invoiceId** | **String** | The unique ID of the invoice that the payment is created on. The balance of the invoice specified must not be &#x60;0&#x60;.  |  [optional] |
|**items** | [**List&lt;PaymentInvoiceApplicationItemCreateRequestType&gt;**](PaymentInvoiceApplicationItemCreateRequestType.md) | Container for invoice items. The maximum number of items is 1,000.  **Note:** This field is only available if you have the [Invoice Item Settlement](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/Invoice_Settlement/C_Invoice_Item_Settlement) feature enabled. Invoice Item Settlement must be used together with other Invoice Settlement features (Unapplied Payments, and Credit and Debit memos).  If you wish to enable Invoice Settlement, see [Invoice Settlement Enablement and Checklist Guide](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/Invoice_Settlement/Invoice_Settlement_Migration_Checklist_and_Guide) for more information.  |  [optional] |



