

# BatchesQueries


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**apiVersion** | **String** | The API version for the query. If an API version is not specified, the latest version is used by default. Using the latest WSDL version is most useful for reporting use cases. For integration purposes, specify the WSDL version to ensure consistent query behavior, that is, what is supported and included in the response returned by the API.  **Note**: As of API version 69 and later, Zuora changed the format of certain fields. See &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Central_Platform/API/G_SOAP_API/AB_Getting_started_with_the__SOAP_API/C_Date_Field_Changes_in_the_SOAP_API\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Date Field Changes in the SOAP API&lt;/a&gt; for more information and a list of affected fields.  |  [optional] |
|**batchId** | **String** | A 32-character ID of the query batch.  |  [optional] |
|**batchType** | [**BatchTypeEnum**](#BatchTypeEnum) | The kind of batch job being submitted.  |  [optional] |
|**deleted** | [**List&lt;DeletedRecord1&gt;**](DeletedRecord1.md) | This field indicates that the AQuA incremental load will retrieve deleted records.  **Note**: AQuA API is subject to Zuora Data Retention Policy. The retention period of deleted data is 30 days. You can only retrieve deleted data for 30 days through AQuA.  |  [optional] |
|**full** | **Boolean** | This field indicates a full or incremental load. &#x60;True&#x60; &#x3D; Full and &#x60;False&#x60; &#x3D; Incremental.            |  [optional] |
|**name** | **String** | Name of the query supplied in the request.  |  [optional] |
|**query** | **String** | The requested query string.  |  [optional] |
|**recordCount** | **String** | The number of records included in the query output file.  |  [optional] |
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



