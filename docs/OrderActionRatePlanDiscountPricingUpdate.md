

# OrderActionRatePlanDiscountPricingUpdate


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**applyDiscountTo** | [**ApplyDiscountToEnum**](#ApplyDiscountToEnum) | Specifies which type of charge the discount charge applies to.  |  [optional] |
|**discountLevel** | [**DiscountLevelEnum**](#DiscountLevelEnum) | Application scope of the discount charge. For example, if the value of this field is &#x60;subscription&#x60; and the value of the &#x60;applyDiscountTo&#x60; field is &#x60;RECURRING&#x60;, the discount charge applies to all recurring charges in the same subscription as the discount charge.  |  [optional] |
|**discountPercentage** | **Double** | The amount of the discount as a percentage. This field is only used for percentage discounts.  |  [optional] |
|**priceChangeOption** | [**PriceChangeOptionEnum**](#PriceChangeOptionEnum) | Specifies how Zuora changes the price of the charge each time the subscription renews.  |  [optional] |



## Enum: ApplyDiscountToEnum

| Name | Value |
|---- | -----|
| ONETIME | &quot;ONETIME&quot; |
| RECURRING | &quot;RECURRING&quot; |
| USAGE | &quot;USAGE&quot; |
| ONETIMERECURRING | &quot;ONETIMERECURRING&quot; |
| ONETIMEUSAGE | &quot;ONETIMEUSAGE&quot; |
| RECURRINGUSAGE | &quot;RECURRINGUSAGE&quot; |
| ONETIMERECURRINGUSAGE | &quot;ONETIMERECURRINGUSAGE&quot; |



## Enum: DiscountLevelEnum

| Name | Value |
|---- | -----|
| RATEPLAN | &quot;rateplan&quot; |
| SUBSCRIPTION | &quot;subscription&quot; |
| ACCOUNT | &quot;account&quot; |



## Enum: PriceChangeOptionEnum

| Name | Value |
|---- | -----|
| NOCHANGE | &quot;NoChange&quot; |
| USELATESTPRODUCTCATALOGPRICING | &quot;UseLatestProductCatalogPricing&quot; |



