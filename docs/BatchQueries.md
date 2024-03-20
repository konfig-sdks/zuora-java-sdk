

# BatchQueries


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**batchId** | **String** | A 32-character ID of the query batch.  |  [optional] |
|**batchType** | [**BatchTypeEnum**](#BatchTypeEnum) | The kind of batch job being submitted.                |  [optional] |
|**fileId** | **String** | The ID of the query results file.  Use Get Results Files to download the query results file. The query results file is formatted as requested in the batch job. Supported formats are CSV, GZIP, and ZIP.  |  [optional] |
|**message** | **String** | The error message.  |  [optional] |
|**name** | **String** | Name of the query supplied in the request.  |  [optional] |
|**query** | **String** | The requested query string.  |  [optional] |
|**recordCount** | **String** | The number of records included in the query output file.  |  [optional] |
|**segments** | **List&lt;Object&gt;** | Array of IDs of query results files. Replaces fileId for full data loads in stateful mode if &lt;a href &#x3D; \&quot;https://knowledgecenter.zuora.com/Zuora_Central_Platform/API/AB_Aggregate_Query_API/G_File_Segmentation\&quot; target&#x3D;\&quot;_blank\&quot;&gt;File Segmentation&lt;/a&gt; is enabled.  Use Get Results Files to download each query results file. Each query results file contains at most 500,000 records and is formatted as requested in the batch job. Supported formats are CSV, GZIP, and ZIP.  |  [optional] |
|**status** | [**StatusEnum**](#StatusEnum) | The status of the query task: - submitted: The query was submitted to the query executor for processing. - pending: The query was waiting for being processed. - executing: The query is being processed. - completed: The query was successfully executed. - aborted: The query execution failed. - deleted_notallowed: The query execution failed because objects included in the query do not support the querying of deleted records.  |  [optional] |



## Enum: BatchTypeEnum

| Name | Value |
|---- | -----|
| ZOQL | &quot;zoql&quot; |
| ZOQLEXPORT | &quot;zoqlexport&quot; |



## Enum: StatusEnum

| Name | Value |
|---- | -----|
| SUBMITTED | &quot;submitted&quot; |
| PENDING | &quot;pending&quot; |
| EXECUTING | &quot;executing&quot; |
| COMPLETED | &quot;completed&quot; |
| ABORTED | &quot;aborted&quot; |
| DELETED_NOTALLOWED | &quot;deleted_notallowed&quot; |



