

# BulkCreateDebitMemosFromInvoiceRequest


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**sourceType** | [**SourceTypeEnum**](#SourceTypeEnum) | The type of the source where debit memos are created.       This enum field has the following values:   - &#x60;Invoice&#x60;: By setting this field to &#x60;Invoice&#x60;, you can create multiple debit memos from invoices.   - &#x60;Standalone&#x60;: By setting this field to &#x60;Standalone&#x60;, you can create multiple debit memos from product rate plan charges.     The specific schema of the &#x60;memos&#x60; object field in the request body depends on the value of the &#x60;sourceType&#x60; field.   - To view the &#x60;memos&#x60; schema applicable to debit memo creation from invoices, select &#x60;Invoice&#x60; from the following drop-down list.   - To view the &#x60;memos&#x60; schema applicable to debit memo creation from product rate plan charges, select &#x60;Standalone&#x60; from the following drop-down list.  |  |
|**memos** | [**List&lt;DebitMemoFromInvoiceRequest&gt;**](DebitMemoFromInvoiceRequest.md) | The container for a list of debit memos. The maximum number of debit memos is 50.  |  [optional] |



## Enum: SourceTypeEnum

| Name | Value |
|---- | -----|
| INVOICE | &quot;Invoice&quot; |



