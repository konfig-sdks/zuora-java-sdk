

# DataQueryJob

A data query job. 

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**createdBy** | **UUID** | The query job creator&#39;s Id.  |  [optional] |
|**id** | **UUID** | Internal identifier of the query job.  |  [optional] |
|**query** | **String** | The query that was submitted.  |  [optional] |
|**remainingRetries** | **Integer** | The number of times that Zuora will retry the query if Zuora is unable to perform the query.  |  [optional] |
|**sourceData** | **String** | Indicates the source that data queries run against:  * &#x60;LIVE&#x60; represents the live transactional databases at Zuora (Data Query Live).  * &#x60;WAREHOUSE&#x60; represents Zuora Warehouse, which has better performance and fewer limitations than the live transactional database. For more information, see &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Central_Platform/Zuora_Warehouse/A_Zuora_Warehouse_overview\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Zuora Warehouse&lt;/a&gt;.  |  [optional] |
|**updatedOn** | **OffsetDateTime** | Date and time when the query job was last updated, in ISO 8601 format.  |  [optional] |
|**useIndexJoin** | **Boolean** | Indicates whether to use Index Join. See &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Central_Platform/Query/Data_Query/Best_practices_when_writing_data_queries/General_best_practices#Index_JOIN\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Index Join&lt;/a&gt; for more information.  |  [optional] |
|**dataFile** | **String** | The URL of the query results. Only applicable if the value of the &#x60;queryStatus&#x60; field is &#x60;completed&#x60;.  |  [optional] |
|**outputRows** | **Integer** | The number of rows the query results. Only applicable if the value of the &#x60;queryStatus&#x60; field is &#x60;completed&#x60;.  |  [optional] |
|**processingTime** | **Integer** | Processing time of the query job, in milliseconds. Only applicable if the value of the &#x60;queryStatus&#x60; field is &#x60;completed&#x60;.  |  [optional] |
|**queryStatus** | [**QueryStatusEnum**](#QueryStatusEnum) | Status of the query job.  * &#x60;submitted&#x60; - query submitted to query service for processing * &#x60;accepted&#x60; - query accepted by the query service * &#x60;in_progress&#x60; - query executed by the query service * &#x60;completed&#x60; - query execution completed by the query service * &#x60;failed&#x60; - query unable to be processed by the query service * &#x60;cancelled&#x60; - query cancelled by the user  If the value of this field is &#x60;completed&#x60;, the &#x60;dataFile&#x60; field contains the location of the query results.  If the value of this field is &#x60;accepted&#x60; or &#x60;in_progress&#x60;, you can use [Cancel a data query job](https://developer.zuora.com) to prevent Zuora from performing the query. Zuora then sets the status of the query job to &#x60;cancelled&#x60;.  |  [optional] |



## Enum: QueryStatusEnum

| Name | Value |
|---- | -----|
| SUBMITTED | &quot;submitted&quot; |
| ACCEPTED | &quot;accepted&quot; |
| IN_PROGRESS | &quot;in_progress&quot; |
| COMPLETED | &quot;completed&quot; |
| FAILED | &quot;failed&quot; |
| CANCELLED | &quot;cancelled&quot; |



