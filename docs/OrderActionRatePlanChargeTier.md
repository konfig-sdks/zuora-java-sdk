

# OrderActionRatePlanChargeTier


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**endingUnit** | **Double** | Limit on the number of units for which the tier is effective.  |  [optional] |
|**price** | **Double** | Price or per-unit price of the tier, depending on the value of the &#x60;priceFormat&#x60; field.  |  |
|**priceFormat** | [**PriceFormatEnum**](#PriceFormatEnum) | Specifies whether the tier has a fixed price or a per-unit price.  |  |
|**startingUnit** | **Double** | Number of units at which the tier becomes effective.  |  |
|**tier** | **Integer** | Index of the tier in the charge.  |  |



## Enum: PriceFormatEnum

| Name | Value |
|---- | -----|
| FLATFEE | &quot;FlatFee&quot; |
| PERUNIT | &quot;PerUnit&quot; |



