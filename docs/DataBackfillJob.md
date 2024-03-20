

# DataBackfillJob


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**id** | **String** | Job ID |  [optional] |
|**importType** | **DataBackfillJobType** |  |  [optional] |
|**uploadedFileId** | **String** | ID of the uploaded file |  [optional] |
|**uploadedFileName** | **String** | Name of the uploaded file |  [optional] |
|**uploadedFileUrl** | **String** | URL of the uploaded file. You can download the uploaded file via this url. |  [optional] |
|**uploadedFileSize** | **String** | Size of the uploaded file |  [optional] |
|**inputFileSize** | **Long** | Size of the uploaded file, in the &#x60;int64&#x60; format |  [optional] |
|**outputSize** | **String** | Size of the output file.   |  [optional] |
|**outputType** | **String** | Type of the output file. |  [optional] |
|**outputFileSize** | **Long** | Size of the output file, in the &#x60;int64&#x60; format.   |  [optional] |
|**resultFileId** | **String** | ID of the output result file that you can download when a data backfill job is completed.   |  [optional] |
|**resultFileName** | **String** | Name of the result file that you can download when a data backfill job is completed  |  [optional] |
|**resultFileUrl** | **String** | URL of the result file that you can download when a data backfill job is completed. You can download the result file via this URL. In the result file, you can see the data that you uploaded and the result for each record in the &#x60;Success&#x60; column of the file. For the record that fails to be updated, you can see the reason for failure in the &#x60;Error Message&#x60; column of the file.  |  [optional] |
|**uploadedBy** | **String** | The user who uploads the file  |  [optional] |
|**uploadedOn** | **OffsetDateTime** | The date and time when the file is uploaded  |  [optional] |
|**completedOn** | **OffsetDateTime** | The date and time when the data backfill action is completed  |  [optional] |
|**startedProcessingOn** | **OffsetDateTime** | The date and time when the data backfill action is started  |  [optional] |
|**totalCount** | **Integer** | The total count of the data records to backfill  |  [optional] |
|**failedCount** | **Integer** | The count of the data records that failed to be backfilled  |  [optional] |
|**status** | **DataBackfillJobStatus** |  |  [optional] |
|**failureMessage** | **String** | Message for the failure  |  [optional] |
|**processedCount** | **Long** | The count of the data records that are being processed  |  [optional] |
|**successCount** | **Long** | The count of the data records that are successfully backfilled  |  [optional] |
|**remainingTime** | **Long** | The remaining time for the data backfill job, in the &#x60;int64&#x60; format  |  [optional] |
|**remainingTimeText** | **String** | The remaining time for the data backfill job, in the text format  |  [optional] |
|**completedPercentage** | **Integer** | The percentage of the completed data records  |  [optional] |



