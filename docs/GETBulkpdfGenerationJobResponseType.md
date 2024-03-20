

# GETBulkpdfGenerationJobResponseType


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**jobId** | **String** | Unique Id for the Triggered Job |  [optional] |
|**jobName** | **String** | Name of the Job provided during the POST request of the Job |  [optional] |
|**status** | [**StatusEnum**](#StatusEnum) | Status of the job |  [optional] |
|**stepStatus** | [**StepStatusEnum**](#StepStatusEnum) | Status of the Current Step that the Job is undergoing |  [optional] |
|**fileUrls** | **List&lt;String&gt;** | Collection of S3 Pre-Signed URL(s) that can be downloaded |  [optional] |
|**createdOn** | **String** | Job Created Time |  [optional] |
|**createdBy** | **String** | Id of the user who created the job |  [optional] |
|**success** | **Boolean** | Returns &#x60;true&#x60; if the request was processed successfully. |  [optional] |



## Enum: StatusEnum

| Name | Value |
|---- | -----|
| SUBMITTED | &quot;Submitted&quot; |
| EXECUTING | &quot;Executing&quot; |
| COMPLETED | &quot;Completed&quot; |
| ERROR | &quot;Error&quot; |
| ABORTED | &quot;Aborted&quot; |
| CANCELLED | &quot;Cancelled&quot; |



## Enum: StepStatusEnum

| Name | Value |
|---- | -----|
| JOBCREATED | &quot;JobCreated&quot; |
| TASKSCREATED | &quot;TasksCreated&quot; |
| GENERATEMISSPDF | &quot;GenerateMissPDF&quot; |
| PDFTOZIP | &quot;PdfToZip&quot; |
| POSTPROCESSING | &quot;PostProcessing&quot; |



