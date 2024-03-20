

# ProxyActionqueryResponse


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**done** | **Boolean** | Indicates whether the returned records contain all the query results. * If the &#x60;queryLocator&#x60; field is returned, this field is set to &#x60;false&#x60;. * If no &#x60;queryLocator&#x60; field is returned, this field is set to &#x60;true&#x60;.  |  [optional] |
|**queryLocator** | **String** | A marker passed to QueryMore to get the next set of results. For more information, see [QueryMore](https://developer.zuora.com/api-references/api/operation/Action_POSTqueryMore/). |  [optional] |
|**records** | **List&lt;Map&lt;String, Object&gt;&gt;** | A list of queried results. |  [optional] |
|**size** | **Integer** | The number of the returned query results. |  [optional] |



