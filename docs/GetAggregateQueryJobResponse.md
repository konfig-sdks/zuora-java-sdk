

# GetAggregateQueryJobResponse


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**version** | **Float** | The API version you want to use.   The supported versions are as follows:   - &#x60;1.1&#x60;. It supports both modes   - &#x60;1.0&#x60;. Default. It supports stateless modes only.  See &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Central_Platform/API/AB_Aggregate_Query_API/BA_Stateless_and_Stateful_Modes\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Stateless and stateful modes&lt;/a&gt; for more information.  |  [optional] |
|**batches** | [**List&lt;BatchesQueriesById&gt;**](BatchesQueriesById.md) | A JSON array object that contains a list of batch objects.  |  [optional] |
|**encrypted** | [**EncryptedEnum**](#EncryptedEnum) | If enabled, you must supply the formatting (zip or unzip) first and decrypt it to get the actual contents.  |  [optional] |
|**format** | [**FormatEnum**](#FormatEnum) | The format of the query. The default value is &#x60;csv&#x60;.  |  [optional] |
|**id** | **String** | The job ID created for the AQuA API request. The job ID can be used for querying for the query status.   The ID exists only if the JSON request can be parsed and validated successfully. Otherwise, the job ID is null.  |  [optional] |
|**name** | **String** | The name of the job. 32 character limit.  |  [optional] |
|**partner** | **String** | The partner field indicates the unique ID of a data integration partner. The dropdown list of this field displays partner IDs for the past thirty days.  It must be used together with \&quot;project\&quot; field to uniquely identify a data integration target.  For example, if a continuous AQuA session is to retrieve data incrementally for a Salesforce.com Org 00170000011K3Ub, you can use partner as \&quot;Salesforce\&quot;, and \&quot;project\&quot; as \&quot;00170000011K3Ub.\&quot;   This field is required only if you are using AQuA in stateful mode. Otherwise, if you are using AQuA in stateless mode, partner field can be null.  **Note**: Zuora highly recommends you use the stateless mode instead of the stateful mode to extract bulk data. See &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Central_Platform/API/AB_Aggregate_Query_API/Bulk_data__extraction_from_Zuora_using_AQuA\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Bulk data extraction from Zuora using AQuA&lt;/a&gt; for best practices.  **Note**: Submit a request at &lt;a href&#x3D;\&quot;http://support.zuora.com\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Zuora Global Support&lt;/a&gt; to obtain a partner ID.  |  [optional] |
|**project** | **String** | The project field contains the unique ID of a data integration project for a particular partner. The dropdown list of this field displays project IDs for the past thirty days.  This field must be used together with partner field to uniquely identify a data integration target.   This field is required only if you are using AQuA in stateful mode. Otherwise, if you are using AQuA in stateless mode, partner field can be null.  |  [optional] |
|**sourceData** | **String** | Indicates the source this aggregate query runs against:  * &#x60;LIVE&#x60; represents the live transactional databases at Zuora (Data Query Live).  * &#x60;WAREHOUSE&#x60; represents Zuora Warehouse, which has better performance and fewer limitations than the live transactional database. For more information, see &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Central_Platform/Zuora_Warehouse/A_Zuora_Warehouse_overview\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Zuora Warehouse&lt;/a&gt;.  |  [optional] |
|**startTime** | **String** | The start time of the query.   |  [optional] |
|**status** | [**StatusEnum**](#StatusEnum) | The status of the AQuA job: - submitted: The AQuA job was submitted to the query executor for processing. - executing: The AQuA job is being processed. - completed: The AQuA job was successfully executed. - error: The AQuA job was not processed because of validation errors. - aborted: The AQuA job execution failed because one or more queries of this job failed. - cancelled: The AQuA job was cancelled.  |  [optional] |



## Enum: EncryptedEnum

| Name | Value |
|---- | -----|
| PGP | &quot;pgp&quot; |
| NONE | &quot;none&quot; |



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



