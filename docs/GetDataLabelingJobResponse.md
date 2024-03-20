

# GetDataLabelingJobResponse


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**jobId** | **UUID** | Identifier of the data labeling job.  |  [optional] |
|**jobStatus** | [**JobStatusEnum**](#JobStatusEnum) | Status of the data labeling job.  * &#x60;Accepted&#x60; - The data labeling job has been accepted by the system. * &#x60;Dispatched&#x60; - The data labeling job is dispatched to the data labeling service. * &#x60;Completed&#x60; - The data labeling job has completed. Please note that &#x60;Completed&#x60; simply means the data labeling job has completed, but it does not mean the data labeling job has labeled all the data. You can check the &#x60;progress&#x60; field to see how many data have been &#x60;labeled&#x60;, &#x60;failed&#x60; or &#x60;timeout&#x60;.  |  [optional] |
|**objectType** | **String** | The object type of the data labeling job.  |  [optional] |
|**progress** | [**GetDataLabelingJobResponseProgress**](GetDataLabelingJobResponseProgress.md) |  |  [optional] |
|**success** | **Boolean** | Indicates whether the job was submitted successfully.  |  [optional] |
|**totalObject** | **Integer** | The total number of objects to be labeled.  |  [optional] |



## Enum: JobStatusEnum

| Name | Value |
|---- | -----|
| ACCEPTED | &quot;Accepted&quot; |
| DISPATCHED | &quot;Dispatched&quot; |
| COMPLETED | &quot;Completed&quot; |



