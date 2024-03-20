

# SettingItemHttpOperation


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**parameters** | [**List&lt;SettingItemHttpRequestParameter&gt;**](SettingItemHttpRequestParameter.md) | An array of paramters required by this operation. |  [optional] |
|**method** | [**MethodEnum**](#MethodEnum) | One of the HTTP methods supported by the setting endpoint, for example, GET,PUT,POST or DELETE. |  [optional] |
|**requestType** | **Object** | JSON Schema for the request body of this operation. |  [optional] |
|**responseType** | **Object** | JSON Schema for the response body of this operation. |  [optional] |
|**url** | **String** | The endpoint url of the operation method. For example, &#x60;/settings/billing-rules&#x60;. |  [optional] |



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



