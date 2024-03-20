

# POSTBulkPdfGenerationJobResponseType


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**processId** | **String** | The ID of the process that handles the operation.  |  [optional] |
|**reasons** | [**List&lt;CommonResponseReasonsInner&gt;**](CommonResponseReasonsInner.md) |  |  [optional] |
|**requestId** | **UUID** | Unique identifier of the request.  |  [optional] |
|**success** | **Boolean** | Indicates whether the call succeeded.  |  [optional] |
|**jobId** | **String** | Unique Id for the Job Triggered.  |  [optional] |
|**invalidIds** | **List&lt;String&gt;** | Collection of Ids that are not valid.    Id is considered to be invalid if,      * Billing Document Id doesn&#39;t exist in the database for the corresponding Billing Document Type   * generateMissingPDF property is false in the Job Request and Valid PDF doesn&#39;t exist for the Billing Document Id  |  [optional] |



