

# BillRunFilterRequestTypeAllOf


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**accountId** | **String** | The target account of the bill run.   If multiple subscriptions are specified, the account ID must be the same.  |  |
|**filterType** | [**FilterTypeEnum**](#FilterTypeEnum) | To create bill runs at account level or subscription level.  |  |
|**subscriptionId** | **String** | The target subscripiton ID of the account.   If you set the &#x60;filterType&#x60; field to &#x60;Subscription&#x60;, you must specify the &#x60;subscriptionId&#x60; field.  |  [optional] |



## Enum: FilterTypeEnum

| Name | Value |
|---- | -----|
| ACCOUNT | &quot;Account&quot; |
| SUBSCRIPTION | &quot;Subscription&quot; |



