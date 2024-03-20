

# ChildrenSettingValueRequest


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**body** | **Map&lt;String, Object&gt;** | Request payload if any |  [optional] |
|**id** | **String** | The id of the request. You can set it to any string. It must be unique within the whole batch.  |  [optional] |
|**method** | [**MethodEnum**](#MethodEnum) | One of the HTTP methods supported by the setting endpoint, for example, GET,PUT,POST or DELETE.  |  [optional] |
|**url** | **String** | The relative URL of the setting. It is the same as in the &#x60;pathPattern&#x60; field in the response body of [Listing all settings](https://developer.zuora.com/api-references/api/operation/GET_ListAllSettings). For example, &#x60;/billing-rules&#x60;.  |  [optional] |



## Enum: MethodEnum

| Name | Value |
|---- | -----|
| GET | &quot;GET&quot; |
| HEAD | &quot;HEAD&quot; |
| POST | &quot;POST&quot; |
| PUT | &quot;PUT&quot; |
| PATCH | &quot;PATCH&quot; |
| DELETE | &quot;DELETE&quot; |
| OPTIONS | &quot;OPTIONS&quot; |
| TRACE | &quot;TRACE&quot; |



