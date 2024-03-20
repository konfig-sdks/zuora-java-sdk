

# DataQueryJobAllOf


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
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



