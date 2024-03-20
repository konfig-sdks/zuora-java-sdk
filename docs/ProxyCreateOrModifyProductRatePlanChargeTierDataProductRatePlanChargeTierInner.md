

# ProxyCreateOrModifyProductRatePlanChargeTierDataProductRatePlanChargeTierInner


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**currency** | **String** | The code corresponding to the currency for the tier&#39;s price.  |  [optional] |
|**discountAmount** | **Double** | The specific amount for a fixed discount. Required if the charge model of the product rate plan charge is &#x60;Discount-Fixed Amount&#x60;.  |  [optional] |
|**discountPercentage** | **Double** | The percentage of discount for a percentage discount. Required if the charge model of the product rate plan charge is &#x60;Discount-Percentage&#x60;.  |  [optional] |
|**endingUnit** | **Double** | The end number of a range of units for the tier. Required if the charge model of the product rate plan charge is &#x60;Tiered Pricing&#x60; or &#x60;Tiered with Overage Pricing&#x60;.  |  [optional] |
|**isOveragePrice** | **Boolean** | Indicates if the price is an overage price, which is the price when usage surpasses the last defined tier.  |  [optional] |
|**price** | **Double** | The price of the tier if the charge is a flat fee, or the price of each unit in the tier if the charge model is tiered pricing.  |  [optional] |
|**priceFormat** | [**PriceFormatEnum**](#PriceFormatEnum) | Indicates if pricing is a flat fee or is per unit. This field is for tiered and volume pricing models only.  |  [optional] |
|**startingUnit** | **Double** | The starting number of a range of units for the tier. Required if the charge model of the product rate plan charge is &#x60;Tiered Pricing&#x60; or &#x60;Tiered with Overage Pricing&#x60;.  |  [optional] |



## Enum: PriceFormatEnum

| Name | Value |
|---- | -----|
| FLAT_FEE | &quot;Flat Fee&quot; |
| PER_UNIT | &quot;Per Unit&quot; |



