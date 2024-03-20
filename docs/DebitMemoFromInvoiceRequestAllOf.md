

# DebitMemoFromInvoiceRequestAllOf


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**autoPay** | **Boolean** | Whether debit memos are automatically picked up for processing in the corresponding payment run.  By default, debit memos are automatically picked up for processing in the corresponding payment run.  |  [optional] |
|**autoPost** | **Boolean** | Whether to automatically post the debit memo after it is created.  Setting this field to &#x60;true&#x60;, you do not need to separately call the [Post debit memo](https://developer.zuora.com/api-references/api/operation/PUT_PostDebitMemo) operation to post the debit memo.  |  [optional] |
|**comment** | **String** | Comments about the debit memo.   |  [optional] |
|**effectiveDate** | **LocalDate** | The date when the debit memo takes effect.  |  [optional] |
|**invoiceId** | **String** | The ID of the invoice that the debit memo is created from. * If this field is specified, its value must be the same as the value of the &#x60;invoiceId&#x60; path parameter. Otherwise, its value overrides the value of the &#x60;invoiceId&#x60; path parameter.  * If this field is not specified, the value of the &#x60;invoiceId&#x60; path parameter is used.   |  [optional] |
|**items** | [**List&lt;DebitMemoItemFromInvoiceItemType&gt;**](DebitMemoItemFromInvoiceItemType.md) | Container for items. The maximum number of items is 1,000.  |  [optional] |
|**reasonCode** | **String** | A code identifying the reason for the transaction. The value must be an existing reason code or empty. If you do not specify a value, Zuora uses the default reason code.  |  [optional] |
|**taxAutoCalculation** | **Boolean** | Whether to automatically calculate taxes in the debit memo.  |  [optional] |



