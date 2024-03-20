

# PreviewExistingSubscriptionResultInvoices


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**invoiceNumber** | **String** | The invoice number.  |  [optional] |
|**amount** | **Double** | Invoice amount.  |  [optional] |
|**amountWithoutTax** | **Double** | Invoice amount minus tax.  |  [optional] |
|**taxAmount** | **Double** | The tax amount of the invoice.  |  [optional] |
|**targetDate** | **LocalDate** | Date through which to calculate charges if an invoice is generated, as yyyy-mm-dd.  |  [optional] |
|**invoiceItems** | [**List&lt;PreviewExistingSubscriptionInvoiceItemResult&gt;**](PreviewExistingSubscriptionInvoiceItemResult.md) | The container for invoice items.  |  [optional] |
|**status** | [**StatusEnum**](#StatusEnum) | The status of the invoice.  |  [optional] |
|**isFromExistingInvoice** | **Boolean** | Indicates whether the invoice information is from an existing invoice.  |  [optional] |



## Enum: StatusEnum

| Name | Value |
|---- | -----|
| DRAFT | &quot;Draft&quot; |
| POSTED | &quot;Posted&quot; |



