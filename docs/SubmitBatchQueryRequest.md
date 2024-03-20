

# SubmitBatchQueryRequest


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**version** | **Float** | The API version you want to use.   The supported versions are as follows:   - &#x60;1.1&#x60;. It supports both modes   - &#x60;1.0&#x60;. Default. It supports stateless modes only.  See &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Central_Platform/API/AB_Aggregate_Query_API/BA_Stateless_and_Stateful_Modes\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Stateless and stateful modes&lt;/a&gt; for more information.  |  [optional] |
|**dateTimeUtc** | **Boolean** | When using WSDL 69 and later you can ensure that the exported output of dateTime records are rendered according to ISO-8601 generic UTC form by setting &#x60;dateTimeUtc&#x60; to &#x60;true&#x60;.  When &#x60;dateTimeUtc&#x60; is set to &#x60;true&#x60;, exports of dateTime data types will be rendered in the following generic format: &#x60;YYYY-MM-DDThh:mm:ss-hhmm&#x60; or &#x60;YYYY-MM-DDThh:mm:ss+hhmm&#x60;.  **Note**: Regardless of what batchType query is used (&#x60;zoql&#x60; or &#x60;zoqlexport&#x60;), the query response output for datetime data types can be standardized by setting dateTimeUtc to &#x60;true&#x60;. When &#x60;true&#x60;, the results will display datetime types with the format: YYYY-MM-DDThh:mm:ss+/-hhmm.  |  [optional] |
|**format** | [**FormatEnum**](#FormatEnum) | The format of the query. The default value is &#x60;csv&#x60;.  |  [optional] |
|**incrementalTime** | **String** | Allows you to override the time from which a Stateful AQuA job incrementally retrieves records that have been created or modified, using the &#x60;incrementalTime&#x60; parameter. For example, if you set &#x60;incrementalTime&#x60; &#x3D; &#x60;2015-01-21 10:30:01&#x60;, AQuA will retrieve records that have created or modified beginning at 10:30:01. If this parameter is not set, AQuA continues to use the Start Time of the last AQuA session to retrieve records incrementally.  The time zone of &#x60;incrementalTime&#x60; depends on which Zuora data center you use. For US Data Center customers, the time zone of &#x60;incrementalTime&#x60; is Pacific Time. For EU Data Center customers, the time zone of &#x60;incrementalTime&#x60; is UTC. If the time zone of your system is different from the time zone of &#x60;incrementalTime&#x60;, you will need to convert to the appropriate time zone before setting &#x60;incrementalTime&#x60;.  **Note**: This field can only be used in Stateful AQuA mode.  |  [optional] |
|**name** | **String** | The name of the job. 32 character limit.  |  [optional] |
|**notifyUrl** | **String** | If URL is provided, the AQuA job will call this &#x60;notifyUrl&#x60; once the job has completed. The value of &#x60;notifyUrl&#x60; needs to have &#x60;${JOBID}&#x60; and &#x60;${STATUS}&#x60; placeholders. These placeholders will be replaced by the actual job ID and status when returned in the response. Status will be &#x60;Completed&#x60; after the AQuA job is done.  If you submit an AQuA query with &#x60;notifyUrl&#x60; specified, the value of &#x60;notifyUrl&#x60; will be ignored if your organization has already &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Central_Platform/API/AB_Aggregate_Query_API/Callout_Notification_for_Completed_AQuA_Jobs\&quot; target&#x3D;\&quot;_blank\&quot;&gt;configured a callout notification through the Zuora user interface&lt;/a&gt;.   |  [optional] |
|**nullReplacement** | **String** | The string used to represent null values in the query results. If you do not set this parameter, null values are represented by the empty string in the query results.  |  [optional] |
|**offset** | **Double** | This field specifies the time offset for AQuA queries in stateful mode. It is an integer in the range 0 to 3,600 seconds.  For example, if you set this field to 600 seconds and you post a query in stateful mode at 2:00 AM, it will query against data created or updated between the completion time of the previous query and 1:50 AM.  The value of this field will override the value you configured in **Settings** &gt; **Administration** &gt; **AQuA API Stateful Mode Time Offset**.          |  [optional] |
|**partner** | **String** | The partner field indicates the unique ID of a data integration partner. The dropdown list of this field displays partner IDs for the past thirty days. It must be used together with \&quot;project\&quot; field to uniquely identify a data integration target.  For example, if a continuous AQuA session is to retrieve data incrementally for a Salesforce.com Org 00170000011K3Ub, you can use partner as \&quot;Salesforce\&quot;, and \&quot;project\&quot; as \&quot;00170000011K3Ub.\&quot;  This field is required only if you are using AQuA in stateful mode. Otherwise, if you are using AQuA in stateless mode, partner field can be null.  **Note**: Zuora highly recommends you use the stateless mode instead of the stateful mode to extract bulk data. See &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Central_Platform/API/AB_Aggregate_Query_API/Bulk_data__extraction_from_Zuora_using_AQuA\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Bulk data extraction from Zuora using AQuA&lt;/a&gt; for best practices. **Note**: Submit a request at &lt;a href&#x3D;\&quot;http://support.zuora.com\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Zuora Global Support&lt;/a&gt; to obtain a partner ID.  |  [optional] |
|**project** | **String** | The project field contains the unique ID of a data integration project for a particular partner. The dropdown list of this field displays project IDs for the past thirty days.  This field must be used together with partner field to uniquely identify a data integration target.   This field is required only if you are using AQuA in stateful mode. Otherwise, if you are using AQuA in stateless mode, partner field can be null.  |  [optional] |
|**queries** | [**List&lt;BatchQuery&gt;**](BatchQuery.md) | A JSON array object that contains a list of batch objects.  |  [optional] |
|**sourceData** | [**SourceDataEnum**](#SourceDataEnum) | Specify the source this aggregate query runs against:  * &#x60;LIVE&#x60; represents the live transactional databases at Zuora (Data Query Live).  * &#x60;WAREHOUSE&#x60; represents Zuora Warehouse, which has better performance and fewer limitations than the live transactional database. This option is available only if you have the Zuora Warehouse feature enabled in your tenant. For more information, see &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Central_Platform/Zuora_Warehouse/A_Zuora_Warehouse_overview\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Zuora Warehouse&lt;/a&gt;. &lt;br&gt;If this option is selected, you can specify warehouse size in &#x60;warehouseSize&#x60;.  If this field is not specified, the default value &#x60;LIVE&#x60; will be used.  |  [optional] |
|**useQueryLabels** | **Boolean** | When this optional flag is set to &#x60;true&#x60; the request will use object and field API names for the CSV header output instead of the field labels. Data integration projects should set &#x60;useQueryLabels&#x60; to &#x60;true&#x60; so that API names remain the same.  By default &#x60;useQueryLabels&#x60; is &#x60;false&#x60;, so that output CSV headers display the more user-friendly object and field labels.   |  [optional] |
|**warehouseSize** | [**WarehouseSizeEnum**](#WarehouseSizeEnum) | Specify the size of Zuora Warehouse. This field is available only if the &#x60;sourceData&#x60; is &#x60;WAREHOUSE&#x60;.  If this field is not specified or set to &#x60;NULL&#x60;, the default value &#x60;xsmall&#x60; will be used.  |  [optional] |



## Enum: FormatEnum

| Name | Value |
|---- | -----|
| CSV | &quot;csv&quot; |
| ZIP | &quot;zip&quot; |
| GZIP | &quot;gzip&quot; |



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



