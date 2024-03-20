

# OrderActionRatePlanRecurringTieredPricingOverrideAllOf


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**listPriceBase** | [**ListPriceBaseEnum**](#ListPriceBaseEnum) | Specifies the duration of each recurring period.  |  [optional] |
|**quantity** | **Double** | Number of units purchased.  |  [optional] |
|**specificListPriceBase** | **Integer** | The number of months for the list price base of the charge. This field is required if you set the value of the &#x60;listPriceBase&#x60; field to &#x60;Per_Specific_Months&#x60;.  |  [optional] |
|**tiers** | [**List&lt;OrderActionRatePlanChargeTier&gt;**](OrderActionRatePlanChargeTier.md) | List of cumulative pricing tiers in the charge.  |  [optional] |



## Enum: ListPriceBaseEnum

| Name | Value |
|---- | -----|
| BILLING_PERIOD | &quot;Per_Billing_Period&quot; |
| MONTH | &quot;Per_Month&quot; |
| WEEK | &quot;Per_Week&quot; |
| YEAR | &quot;Per_Year&quot; |
| SPECIFIC_MONTHS | &quot;Per_Specific_Months&quot; |



