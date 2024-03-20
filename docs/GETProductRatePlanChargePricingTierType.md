

# GETProductRatePlanChargePricingTierType


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**endingUnit** | **BigDecimal** | Decimal defining end of tier range.  |  [optional] |
|**price** | **BigDecimal** | The decimal value of the tiered charge model. If the charge model is not a tiered type then this price field will be null and the price field directly under the productRatePlanCharges applies.  |  [optional] |
|**priceFormat** | **String** | Tier price format.  Allowed values: - flat fee  - per unit  |  [optional] |
|**startingUnit** | **BigDecimal** | Decimal defining start of tier range.  |  [optional] |
|**tier** | **Long** | Unique number of the tier.  |  [optional] |



