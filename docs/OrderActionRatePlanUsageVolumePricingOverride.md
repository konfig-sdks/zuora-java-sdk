

# OrderActionRatePlanUsageVolumePricingOverride

Pricing information about a usage charge that uses the \"volume pricing\" charge model. In this charge model, the charge has a variable price per unit, depending on how many units are consumed. 

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**priceChangeOption** | [**PriceChangeOptionEnum**](#PriceChangeOptionEnum) | Specifies how Zuora changes the price of the charge each time the subscription renews.  If the value of this field is &#x60;SpecificPercentageValue&#x60;, use the &#x60;priceIncreasePercentage&#x60; field to specify how much the price of the charge should change.  |  [optional] |
|**priceIncreasePercentage** | **Double** | Specifies the percentage by which the price of the charge should change each time the subscription renews. Only applicable if the value of the &#x60;priceChangeOption&#x60; field is &#x60;SpecificPercentageValue&#x60;.  |  [optional] |
|**ratingGroup** | [**RatingGroupEnum**](#RatingGroupEnum) | Specifies how Zuora groups usage records when rating usage. See [Usage Rating by Group](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/J_Billing_Operations/Usage/Usage_Rating_by_Group) for more information.   * ByBillingPeriod (default): The rating is based on all the usages in a billing period.   * ByUsageStartDate: The rating is based on all the usages on the same usage start date.   * ByUsageRecord: The rating is based on each usage record.   * ByUsageUpload: The rating is based on all the usages in a uploaded usage file (.xls or .csv). If you import a mass usage in a single upload, which contains multiple usage files in .xls or .csv format, usage records are grouped for each usage file.  |  [optional] |
|**tiers** | [**List&lt;OrderActionRatePlanChargeTier&gt;**](OrderActionRatePlanChargeTier.md) | List of variable pricing tiers in the charge.  |  [optional] |



## Enum: PriceChangeOptionEnum

| Name | Value |
|---- | -----|
| NOCHANGE | &quot;NoChange&quot; |
| SPECIFICPERCENTAGEVALUE | &quot;SpecificPercentageValue&quot; |
| USELATESTPRODUCTCATALOGPRICING | &quot;UseLatestProductCatalogPricing&quot; |



## Enum: RatingGroupEnum

| Name | Value |
|---- | -----|
| BYBILLINGPERIOD | &quot;ByBillingPeriod&quot; |
| BYUSAGESTARTDATE | &quot;ByUsageStartDate&quot; |
| BYUSAGERECORD | &quot;ByUsageRecord&quot; |
| BYUSAGEUPLOAD | &quot;ByUsageUpload&quot; |



