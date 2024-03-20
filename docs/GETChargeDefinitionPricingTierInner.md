

# GETChargeDefinitionPricingTierInner


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**currency** | **String** | The code corresponding to the currency for the tier&#39;s price.  |  [optional] |
|**discountAmount** | **Double** | The specific amount for a fixed discount. The field is applicable only for charges based on the Discount-Fixed Amount charge model.  |  [optional] |
|**discountPercentage** | **Double** | The percentage of discount for a percentage discount. The field is applicable only for charges based on the Discount-Percentage charge model.  |  [optional] |
|**endingUnit** | **Double** | The end number of a range of units for the tier. The field is applicable only for charges based on the Tiered Pricing or Tiered with Overage Pricing charge model.  |  [optional] |
|**overagePrice** | **Double** | Indicates whether the price is an overage price, which is the price when usage surpasses the last defined tier.  |  [optional] |
|**price** | **Double** | The price of the tier if the price format is flat fee, or the price of each unit in the tier if the price format is per unit.  |  [optional] |
|**startingUnit** | **Double** | The starting number of a range of units for the tier. The field is applicable only for charges based on the Tiered Pricing or Tiered with Overage Pricing charge model.  |  [optional] |



