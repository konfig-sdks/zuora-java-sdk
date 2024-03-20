

# SubmitDataQueryRequest


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**columnSeparator** | **String** | The column separator. Only applicable if the &#x60;outputFormat&#x60; is &#x60;DSV&#x60;.  |  [optional] |
|**compression** | [**CompressionEnum**](#CompressionEnum) | Specifies whether Zuora compresses the query results.  |  |
|**encryptionKey** | **byte[]** | Base-64 encoded public key of an RSA key-pair.   Note that Data Query only supports 1024-bit RSA keys.  If you set this field, Zuora encrypts the query results using the provided public key. You must use the corresponding private key to decrypt the query results.  |  [optional] |
|**output** | [**SubmitDataQueryRequestOutput**](SubmitDataQueryRequestOutput.md) |  |  |
|**outputFormat** | [**OutputFormatEnum**](#OutputFormatEnum) | Specifies the format of the query results.  * &#x60;JSON&#x60; - Each row in the query results will be a JSON object. The format of the query result file is [JSON Lines](http://jsonlines.org/). * &#x60;CSV&#x60; - Each row in the query results will be a comma-separated list of values. * &#x60;TSV&#x60; - Each row in the query results will be a tab-separated list of values. * &#x60;DSV&#x60; - Pass any character as your custom delimiter into the &#x60;columnSeparator&#x60; field.  |  |
|**query** | **String** | The query to perform. See [SQL Queries in Data Query](https://knowledgecenter.zuora.com/DC_Developers/BA_Data_Query/BA_SQL_Queries_in_Data_Query) for more information.  |  |
|**readDeleted** | **Boolean** | Indicates whether the query will retrieve only the deleted record. If &#x60;readDeleted&#x60; is set to &#x60;false&#x60; or it is not included in the request body, the query will retrieve only the non-deleted records. If it is set to &#x60;true&#x60;, only the deleted records will be retrieved.  If you select the &#x60;deleted&#x60; column in the &#x60;query&#x60; field, both non-deleted and deleted records will be retrieved regardless of the value in the &#x60;readDeleted&#x60; field.  Note that Data Query is subject to Zuora Data Retention Policy. The retention period of deleted data is 30 days. You can only retrieve deleted data for 30 days through Data Query.  |  [optional] |
|**sourceData** | [**SourceDataEnum**](#SourceDataEnum) | Specify the source that data queries run against:  * &#x60;LIVE&#x60; represents the live transactional databases at Zuora (Data Query Live).  * &#x60;WAREHOUSE&#x60; represents Zuora Warehouse, which has better performance and fewer limitations than the live transactional database. This option is available only if you have the Zuora Warehouse feature enabled in your tenant. For more information, see &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Central_Platform/Zuora_Warehouse/A_Zuora_Warehouse_overview\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Zuora Warehouse&lt;/a&gt;. &lt;br&gt;If this option is selected, you can specify warehouse size in &#x60;warehouseSize&#x60;.  If this field is not specified, the default value &#x60;LIVE&#x60; will be used.  |  [optional] |
|**useIndexJoin** | **Boolean** | Indicates whether to use Index Join. Index join is useful when you have a specific reference value in your WHERE clause to index another large table by. See [Use Index Join](https://knowledgecenter.zuora.com/DC_Developers/BA_Data_Query/Best_practices_of_Data_Query#Use_Index_Join) for more information. |  [optional] |
|**warehouseSize** | [**WarehouseSizeEnum**](#WarehouseSizeEnum) | Specify the size of Zuora Warehouse. This field is available only if the &#x60;sourceData&#x60; is &#x60;WAREHOUSE&#x60;.  If this field is not specified or set to &#x60;NULL&#x60;, the default value &#x60;xsmall&#x60; will be used.  |  [optional] |



## Enum: CompressionEnum

| Name | Value |
|---- | -----|
| NONE | &quot;NONE&quot; |
| GZIP | &quot;GZIP&quot; |
| ZIP | &quot;ZIP&quot; |



## Enum: OutputFormatEnum

| Name | Value |
|---- | -----|
| JSON | &quot;JSON&quot; |
| CSV | &quot;CSV&quot; |
| TSV | &quot;TSV&quot; |
| DSV | &quot;DSV&quot; |



## Enum: SourceDataEnum

| Name | Value |
|---- | -----|
| LIVE | &quot;LIVE&quot; |
| WAREHOUSE | &quot;WAREHOUSE&quot; |



## Enum: WarehouseSizeEnum

| Name | Value |
|---- | -----|
| XSMALL | &quot;xsmall&quot; |
| NULL | &quot;NULL&quot; |



