

# GETIntervalPriceType


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**duration** | **Integer** | Duration period of this interval.  |  [optional] |
|**price** | **Double** | Price of this interval.  |  [optional] |
|**sequence** | **Integer** | A system-generated number that indicates the sequence in which each interval price is billed.  |  [optional] |
|**subscriptionChargeIntervalPriceTiers** | [**List&lt;GETIntervalPriceTierType&gt;**](GETIntervalPriceTierType.md) |  |  [optional] |
|**type** | [**TypeEnum**](#TypeEnum) | Interval type of this pricing.  |  [optional] |



## Enum: TypeEnum

| Name | Value |
|---- | -----|
| DAY | &quot;Day&quot; |
| MONTH | &quot;Month&quot; |
| INFINITY | &quot;Infinity&quot; |



