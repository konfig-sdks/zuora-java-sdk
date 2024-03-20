

# POSTBulkPdfGenerationJobResponseTypeAllOf


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**jobId** | **String** | Unique Id for the Job Triggered.  |  [optional] |
|**invalidIds** | **List&lt;String&gt;** | Collection of Ids that are not valid.    Id is considered to be invalid if,      * Billing Document Id doesn&#39;t exist in the database for the corresponding Billing Document Type   * generateMissingPDF property is false in the Job Request and Valid PDF doesn&#39;t exist for the Billing Document Id  |  [optional] |



