

# ApplyPaymentType


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**debitMemos** | [**List&lt;PaymentDebitMemoApplicationApplyRequestType&gt;**](PaymentDebitMemoApplicationApplyRequestType.md) | Container for debit memos. The maximum number of debit memos is 1,000.  |  [optional] |
|**effectiveDate** | **LocalDate** | The date when the payment application takes effect, in &#x60;yyyy-mm-dd&#x60; format. The effective date must be later than or equal to the maximum effective date of the payment.  |  [optional] |
|**invoices** | [**List&lt;PaymentInvoiceApplicationApplyRequestType&gt;**](PaymentInvoiceApplicationApplyRequestType.md) | Container for invoices. The maximum number of invoices is 1,000.  |  [optional] |



