

# BulkCreateCreditMemosFromInvoiceRequest


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**sourceType** | [**SourceTypeEnum**](#SourceTypeEnum) | The type of the source where credit memos are created.       This enum field has the following values:   - &#x60;Invoice&#x60;: By setting this field to &#x60;Invoice&#x60;, you can create multiple credit memos from invoices.   - &#x60;Standalone&#x60;: By setting this field to &#x60;Standalone&#x60;, you can create multiple credit memos from product rate plan charges.     The specific schema of the &#x60;memos&#x60; object field in the request body depends on the value of the &#x60;sourceType&#x60; field.   - To view the &#x60;memos&#x60; schema applicable to credit memo creation from invoices, select &#x60;Invoice&#x60; from the following drop-down list.   - To view the &#x60;memos&#x60; schema applicable to credit memo creation from product rate plan charges, select &#x60;Standalone&#x60; from the following drop-down list.     |  |
|**memos** | [**List&lt;CreditMemoFromInvoiceRequest&gt;**](CreditMemoFromInvoiceRequest.md) | The container for a list of credit memos. The maximum number of credit memos is 50.  |  [optional] |



## Enum: SourceTypeEnum

| Name | Value |
|---- | -----|
| INVOICE | &quot;Invoice&quot; |



