

# GetInvoicePdfStatusResponseAllOf


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**invoiceId** | **String** | The ID of the invoice whose pdf status is requested.  |  [optional] |
|**invoiceNumber** | **String** | The invoice number of the invoice whose pdf status is requested.  |  [optional] |
|**pdfGenerationStatus** | [**PdfGenerationStatusEnum**](#PdfGenerationStatusEnum) | The generation status of the invoice PDF.  |  [optional] |
|**createdOn** | **String** | The time at which the request to generate the PDF was created.  |  [optional] |
|**updatedOn** | **String** | The time at which the request to generate the PDF was updated.  |  [optional] |



## Enum: PdfGenerationStatusEnum

| Name | Value |
|---- | -----|
| NONE | &quot;None&quot; |
| PENDING | &quot;Pending&quot; |
| PROCESSING | &quot;Processing&quot; |
| GENERATED | &quot;Generated&quot; |
| ERROR | &quot;Error&quot; |
| OBSOLETE | &quot;Obsolete&quot; |
| ARCHIVED | &quot;Archived&quot; |



