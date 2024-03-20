

# GETRatePlanChargePricingTierInner


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**currency** | **String** | The code corresponding to the currency for the price tier.  |  [optional] |
|**discountAmount** | **Double** | The specific amount for a fixed discount. This field is applicable for charges based on the Discount-Fixed Amount charge model.  |  [optional] |
|**discountPercentage** | **Double** | The percentage of discount for a percentage discount. This field is applicable for charges based on the Discount-Percentage charge model.  |  [optional] |
|**endingUnit** | **Double** | The end number of a range of units for the tier. This field is applicable for charges based on the Tiered Pricing or Tiered with Overage Pricing charge model.  |  [optional] |
|**overagePrice** | **Double** | Indicates whether the price is an overage price, which is the price when usage surpasses the last defined tier.  |  [optional] |
|**price** | **Double** | The price of the tier if the charge is a flat fee, or the price of each unit in the tier if the charge model is tiered pricing.  |  [optional] |
|**startingUnit** | **Double** | The starting number of a range of units for the tier. This field is applicable for charges based on the Tiered Pricing or Tiered with Overage Pricing charge model.  |  [optional] |



