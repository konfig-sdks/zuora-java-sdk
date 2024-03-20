

# SettingItemWithOperationsInformation


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**description** | **String** | The description of the setting item as you see from Zuora UI. |  [optional] |
|**context** | [**ContextEnum**](#ContextEnum) | The context where this setting item is effective. |  [optional] |
|**httpOperations** | [**List&lt;SettingItemHttpOperation&gt;**](SettingItemHttpOperation.md) | An array of HTTP operation methods that are supported on this setting endpoint. |  [optional] |
|**key** | **String** | The unique key to distinguish the setting item. |  [optional] |
|**pathPattern** | **String** | The path pattern of the setting endpoint, relative to &#x60;/settings&#x60;. For example, &#x60;/billing-rules&#x60;. |  [optional] |



## Enum: ContextEnum

| Name | Value |
|---- | -----|
| TENANT | &quot;Tenant&quot; |
| ENTITY | &quot;Entity&quot; |
| USER | &quot;User&quot; |
| NONE | &quot;None&quot; |



