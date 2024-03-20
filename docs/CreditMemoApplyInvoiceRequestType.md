

# CreditMemoApplyInvoiceRequestType


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**amount** | **Double** | The credit memo amount to be applied to the invoice.  |  |
|**invoiceId** | **String** | The unique ID of the invoice that the credit memo is applied to.  |  |
|**items** | [**List&lt;CreditMemoApplyInvoiceItemRequestType&gt;**](CreditMemoApplyInvoiceItemRequestType.md) | Container for items. The maximum number of items is 1,000.  If &#x60;creditMemoItemId&#x60; is the source, then it should be accompanied by a target &#x60;invoiceItemId&#x60;.  If &#x60;creditTaxItemId&#x60; is the source, then it should be accompanied by a target &#x60;taxItemId&#x60;.  |  [optional] |



