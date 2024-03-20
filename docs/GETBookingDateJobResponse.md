

# GETBookingDateJobResponse


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**id** | **String** | Job ID |  [optional] |
|**createdOn** | **Long** | The created-on date in the &#x60;int64&#x60; format  |  [optional] |
|**createdOnReadable** | **String** | The created-on date in the &#x60;datetime&#x60; format  |  [optional] |
|**updatedOn** | **Long** | The updated-on date in the &#x60;int64&#x60; format  |  [optional] |
|**updatedOnReadable** | **String** | The updated-on date in the &#x60;datetime&#x60; format  |  [optional] |
|**updatedByUsername** | **String** | The user who performs the booking date backfill job  |  [optional] |
|**status** | [**StatusEnum**](#StatusEnum) | The status of the booking date backfill job  |  [optional] |
|**batchSentCount** | **Integer** | The batch count sent for execution  |  [optional] |
|**batchFinishedCount** | **Integer** | The finished batch count  |  [optional] |
|**errorCount** | **Integer** | The failed record count  |  [optional] |
|**progress** | **String** | The progress of the booking date backfill job  |  [optional] |



## Enum: StatusEnum

| Name | Value |
|---- | -----|
| ACCEPTED | &quot;ACCEPTED&quot; |
| PROCESSING | &quot;PROCESSING&quot; |
| COMPLETED | &quot;COMPLETED&quot; |
| FAILED | &quot;FAILED&quot; |
| STOPPED | &quot;STOPPED&quot; |



