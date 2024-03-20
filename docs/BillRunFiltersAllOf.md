

# BillRunFiltersAllOf


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**accountId** | **String** | The target account of the bill run.  |  [optional] |
|**filterType** | [**FilterTypeEnum**](#FilterTypeEnum) | The type of the filter to determine whether to create a bill run at the account level or subscription level.  |  [optional] |
|**subscriptionId** | **String** | The unique ID of the target subscription belonged to the target account.   This field is required if you set the &#x60;filterType&#x60; field to &#x60;Subscription&#x60;.  |  [optional] |



## Enum: FilterTypeEnum

| Name | Value |
|---- | -----|
| ACCOUNT | &quot;Account&quot; |
| SUBSCRIPTION | &quot;Subscription&quot; |
| INVOICESCHEDULE | &quot;InvoiceSchedule&quot; |



