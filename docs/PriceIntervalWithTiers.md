

# PriceIntervalWithTiers


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**duration** | **Integer** | Duration period of this interval.  |  [optional] |
|**sequence** | **Integer** | Index of the interval in the interval pricing.  |  [optional] |
|**tiers** | [**List&lt;ChargeTier&gt;**](ChargeTier.md) | List of cumulative pricing tiers in the charge.  |  [optional] |
|**type** | [**TypeEnum**](#TypeEnum) | Interval type of this pricing.  |  [optional] |



## Enum: TypeEnum

| Name | Value |
|---- | -----|
| DAY | &quot;Day&quot; |
| MONTH | &quot;Month&quot; |
| INFINITY | &quot;Infinity&quot; |



