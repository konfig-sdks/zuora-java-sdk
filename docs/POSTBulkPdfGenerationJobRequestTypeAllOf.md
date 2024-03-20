

# POSTBulkPdfGenerationJobRequestTypeAllOf


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**documents** | [**List&lt;DocumentList&gt;**](DocumentList.md) | An array that contains the collection of Objects where each object contains billing document type and their IDs.  |  |
|**fileName** | **String** | The prefix part of output file name(s).  Eg:    if fileName is \&quot;all-invoices-posted-jan-2024\&quot; then fileURL(s) contains this name as a prefix followed by suffix _{number}.  |  |
|**name** | **String** | The name of the job.  |  [optional] |
|**indexFileFormat** | [**IndexFileFormatEnum**](#IndexFileFormatEnum) | Format of the Index file. It contains the metadata about the files and their contents.  |  |
|**generateMissingPDF** | **Boolean** | This flag controls the behavior of whether to generate PDF(s) for billing documents that do not already have one.    - setting it to true indicates service would go through the provided document ID list, find the billing documents that do not have a generated PDF,   generate them all at once, and then proceed to the zipping process.    - setting it to false indicates service would go through the provided document ID list, find the billing documents that do not have a generated PDF,   mark them as Invalid, and skip them from the zipping process. IDs marked as invalid will be included in the response.  The default value is false.  |  [optional] |



## Enum: IndexFileFormatEnum

| Name | Value |
|---- | -----|
| JSON | &quot;JSON&quot; |
| CSV | &quot;CSV&quot; |



