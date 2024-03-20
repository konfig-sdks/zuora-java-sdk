

# GETRatePlanChargePricing


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**currency** | **String** | The currency for the price.  |  [optional] |
|**discountAmount** | **Double** | The specific amount for a fixed discount. This field is applicable for charges based on the Discount-Fixed Amount charge model.  |  [optional] |
|**discountPercentage** | **Double** | The percentage of discount for a percentage discount. This field is applicable for charges based on the Discount-Percentage charge model.  |  [optional] |
|**includedUnits** | **Double** | The number of units included in this price item.   This field is only applicable for charges based on the Overage Pricing charge model.  |  [optional] |
|**overagePrice** | **Double** | The overage price of the price item.   This field is only applicable for charges based on the Overage Pricing or Tiered with Overage Pricing charge model.  |  [optional] |
|**price** | **Double** | The price.   This field is only applicable for charges based on the following charge models:   - Flat Fee   - Per Unit   - Delivery Pricing  |  [optional] |
|**tiers** | **List&lt;List&lt;GETRatePlanChargePricingTierInner&gt;&gt;** | Container for the tiers of the price item.   This field is only applicable for charges based on the following charge models:   - Tiered Pricing   - Volume Pricing   - Tiered with Overage Pricing  |  [optional] |



