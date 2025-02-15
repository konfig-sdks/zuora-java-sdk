

# BillingPreviewResult


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**accountId** | **String** | ID of the customer account to which the billing preview applies.  |  [optional] |
|**creditMemoItems** | [**List&lt;POSTBillingPreviewCreditMemoItem&gt;**](POSTBillingPreviewCreditMemoItem.md) | An array of credit memo items returned as the result of the billing preivew request.  **Note:** The credit memo items are only available if you have Invoice Settlement feature enabled. The Invoice Settlement feature is generally available as of Zuora Billing Release 296 (March 2021). This feature includes Unapplied Payments, Credit and Debit Memo, and Invoice Item Settlement. If you want to enable Invoice Settlement, see [Invoice Settlement Enablement and Checklist Guide](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/Invoice_Settlement/Invoice_Settlement_Migration_Checklist_and_Guide) for more information.  |  [optional] |
|**invoiceItems** | [**List&lt;POSTBillingPreviewInvoiceItem&gt;**](POSTBillingPreviewInvoiceItem.md) | An array of invoice items returned as the result of the billing preview request.  |  [optional] |
|**success** | **Boolean** | Returns &#x60;true&#x60; if the request was processed successfully.  |  [optional] |



