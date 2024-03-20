

# POSTChargeDefinitionPricingTierInner


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**currency** | **String** | The code corresponding to the currency for the tier&#39;s price.  |  [optional] |
|**endingUnit** | **Double** | The end number of a range of units for the tier. This field is required for charges based on the Tiered Pricing or Tiered with Overage Pricing charge model.  |  [optional] |
|**price** | **Double** | The price of the tier if the price format is flat fee, or the price of each unit in the tier if the price format is per unit.  |  [optional] |
|**priceFormat** | [**PriceFormatEnum**](#PriceFormatEnum) | The price format of the tier.  |  [optional] |
|**startingUnit** | **Double** | The starting number of a range of units for the tier. This field is required for charges based on the Tiered Pricing or Tiered with Overage Pricing charge model.  |  [optional] |



## Enum: PriceFormatEnum

| Name | Value |
|---- | -----|
| FLAT_FEE | &quot;Flat Fee&quot; |
| PER_UNIT | &quot;Per Unit&quot; |



