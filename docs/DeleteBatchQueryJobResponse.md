

# DeleteBatchQueryJobResponse


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**version** | **Float** | The API version you want to use.   The supported versions are as follows:   - &#x60;1.1&#x60;. It supports both modes   - &#x60;1.0&#x60;. Default. It supports stateless modes only.  See &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Central_Platform/API/AB_Aggregate_Query_API/BA_Stateless_and_Stateful_Modes\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Stateless and stateful modes&lt;/a&gt; for more information.  |  [optional] |
|**batches** | [**List&lt;BatchQueries&gt;**](BatchQueries.md) | A JSON array object that contains a list of batch objects.  |  [optional] |
|**format** | [**FormatEnum**](#FormatEnum) | The format of the query. The default value is &#x60;csv&#x60;.  |  [optional] |
|**id** | **String** | The job ID created for the AQuA API request. The job ID can be used for querying for the query status.   The ID exists only if the JSON request can be parsed and validated successfully. Otherwise, the job ID is null.  |  [optional] |
|**name** | **String** | The name of the job. 32 character limit.  |  [optional] |
|**sourceData** | **String** | Indicates the source this aggregate query runs against:  * &#x60;LIVE&#x60; represents the live transactional databases at Zuora (Data Query Live).  * &#x60;WAREHOUSE&#x60; represents Zuora Warehouse, which has better performance and fewer limitations than the live transactional database. For more information, see &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Central_Platform/Zuora_Warehouse/A_Zuora_Warehouse_overview\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Zuora Warehouse&lt;/a&gt;.  |  [optional] |
|**status** | [**StatusEnum**](#StatusEnum) | The status of the AQuA job: - submitted: The AQuA job was submitted to the query executor for processing. - executing: The AQuA job is being processed. - completed: The AQuA job was successfully executed. - error: The AQuA job was not processed because of validation errors. - aborted: The AQuA job execution failed because one or more queries of this job failed. - cancelled: The AQuA job was cancelled.  |  [optional] |



## Enum: FormatEnum

| Name | Value |
|---- | -----|
| CSV | &quot;csv&quot; |
| ZIP | &quot;zip&quot; |
| GZIP | &quot;gzip&quot; |



## Enum: StatusEnum

| Name | Value |
|---- | -----|
| SUBMITTED | &quot;submitted&quot; |
| EXECUTING | &quot;executing&quot; |
| COMPLETED | &quot;completed&quot; |
| ERROR | &quot;error&quot; |
| ABORTED | &quot;aborted&quot; |
| CANCELLED | &quot;cancelled&quot; |



