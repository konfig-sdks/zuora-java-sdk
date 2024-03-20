

# GetCreditMemoPdfStatusResponse


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**creditMemoId** | **String** | The ID of the credit memo whose pdf status is requested.  |  [optional] |
|**creditMemoNumber** | **String** | The credit memo number of the credit memo whose pdf status is requested.  |  [optional] |
|**pdfGenerationStatus** | [**PdfGenerationStatusEnum**](#PdfGenerationStatusEnum) | The generation status of the credit memo PDF.  |  [optional] |
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



