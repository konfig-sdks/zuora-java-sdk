

# CreditMemoFromInvoiceRequestAllOf


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**autoApplyToInvoiceUponPosting** | **Boolean** | Whether the credit memo automatically applies to the invoice upon posting.  |  [optional] |
|**autoPost** | **Boolean** | Whether to automatically post the credit memo after it is created.  Setting this field to &#x60;true&#x60;, you do not need to separately call the [Post credit memo](https://developer.zuora.com/api-references/api/operation/PUT_PostCreditMemo) operation to post the credit memo.  |  [optional] |
|**comment** | **String** | Comments about the credit memo.  |  [optional] |
|**effectiveDate** | **LocalDate** | The date when the credit memo takes effect.  |  [optional] |
|**excludeFromAutoApplyRules** | **Boolean** | Whether the credit memo is excluded from the rule of automatically applying credit memos to invoices.  |  [optional] |
|**invoiceId** | **String** | The ID of the invoice that the credit memo is created from. * If this field is specified, its value must be the same as the value of the &#x60;invoiceId&#x60; path parameter. Otherwise, its value overrides the value of the &#x60;invoiceId&#x60; path parameter.  * If this field is not specified, the value of the &#x60;invoiceId&#x60; path parameter is used.  |  [optional] |
|**items** | [**List&lt;CreditMemoItemFromInvoiceItemType&gt;**](CreditMemoItemFromInvoiceItemType.md) | Container for items. The maximum number of items is 1,000.  |  [optional] |
|**reasonCode** | **String** | A code identifying the reason for the transaction. The value must be an existing reason code or empty. If you do not specify a value, Zuora uses the default reason code.  |  [optional] |
|**taxAutoCalculation** | **Boolean** | Whether to automatically calculate taxes in the credit memo.  |  [optional] |



