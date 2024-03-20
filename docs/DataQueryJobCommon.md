

# DataQueryJobCommon


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



