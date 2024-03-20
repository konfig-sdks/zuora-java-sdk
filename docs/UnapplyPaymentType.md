

# UnapplyPaymentType


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**debitMemos** | [**List&lt;PaymentDebitMemoApplicationUnapplyRequestType&gt;**](PaymentDebitMemoApplicationUnapplyRequestType.md) | Container for debit memos. The maximum number of debit memos is 1,000.  |  [optional] |
|**effectiveDate** | **LocalDate** | The date when the payment is unapplied, in &#x60;yyyy-mm-dd&#x60; format. The effective date must be later than or equal to the maximum effective date of the payment.  |  [optional] |
|**invoices** | [**List&lt;PaymentInvoiceApplicationUnapplyRequestType&gt;**](PaymentInvoiceApplicationUnapplyRequestType.md) | Container for invoices. The maximum number of invoice is 1,000.  |  [optional] |



