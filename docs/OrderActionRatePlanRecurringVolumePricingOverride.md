

# OrderActionRatePlanRecurringVolumePricingOverride

Pricing information about a recurring charge that uses the \"volume pricing\" charge model. In this charge model, the charge has a variable price per unit, depending on how many units are purchased. 

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**priceChangeOption** | [**PriceChangeOptionEnum**](#PriceChangeOptionEnum) | Specifies how Zuora changes the price of the charge each time the subscription renews.  If the value of this field is &#x60;SpecificPercentageValue&#x60;, use the &#x60;priceIncreasePercentage&#x60; field to specify how much the price of the charge should change.  |  [optional] |
|**priceIncreasePercentage** | **Double** | Specifies the percentage by which the price of the charge should change each time the subscription renews. Only applicable if the value of the &#x60;priceChangeOption&#x60; field is &#x60;SpecificPercentageValue&#x60;.  |  [optional] |
|**listPriceBase** | [**ListPriceBaseEnum**](#ListPriceBaseEnum) | Specifies the duration of each recurring period.  **Note**: The &#x60;Per_Year&#x60; and &#x60;Per_Specific_Months&#x60; enum values are available only if you have the &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Billing/Subscriptions/Product_Catalog/I_Annual_List_Price\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Annual List Price&lt;/a&gt; feature enabled.  |  [optional] |
|**quantity** | **Double** | Number of units purchased.  |  [optional] |
|**specificListPriceBase** | **Integer** | The number of months for the list price base of the charge. This field is required if you set the value of the &#x60;listPriceBase&#x60; field to &#x60;Per_Specific_Months&#x60;.  |  [optional] |
|**tiers** | [**List&lt;OrderActionRatePlanChargeTier&gt;**](OrderActionRatePlanChargeTier.md) | List of variable pricing tiers in the charge.  |  [optional] |



## Enum: PriceChangeOptionEnum

| Name | Value |
|---- | -----|
| NOCHANGE | &quot;NoChange&quot; |
| SPECIFICPERCENTAGEVALUE | &quot;SpecificPercentageValue&quot; |
| USELATESTPRODUCTCATALOGPRICING | &quot;UseLatestProductCatalogPricing&quot; |



## Enum: ListPriceBaseEnum

| Name | Value |
|---- | -----|
| BILLING_PERIOD | &quot;Per_Billing_Period&quot; |
| MONTH | &quot;Per_Month&quot; |
| WEEK | &quot;Per_Week&quot; |
| YEAR | &quot;Per_Year&quot; |
| SPECIFIC_MONTHS | &quot;Per_Specific_Months&quot; |



