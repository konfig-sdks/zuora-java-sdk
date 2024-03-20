

# RecurringFlatFeePricingUpdate


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**priceChangeOption** | [**PriceChangeOptionEnum**](#PriceChangeOptionEnum) | Specifies how Zuora changes the price of the charge each time the subscription renews.  If the value of this field is &#x60;SpecificPercentageValue&#x60;, use the &#x60;priceIncreasePercentage&#x60; field to specify how much the price of the charge should change.  |  [optional] |
|**priceIncreasePercentage** | **Double** | Specifies the percentage by which the price of the charge should change each time the subscription renews. Only applicable if the value of the &#x60;priceChangeOption&#x60; field is &#x60;SpecificPercentageValue&#x60;.  |  [optional] |
|**listPrice** | **Double** |  |  [optional] |
|**originalListPrice** | **Double** | The original list price is the price of a product or service at which it is listed for sale by a manufacturer or retailer.  |  [optional] |



## Enum: PriceChangeOptionEnum

| Name | Value |
|---- | -----|
| NOCHANGE | &quot;NoChange&quot; |
| SPECIFICPERCENTAGEVALUE | &quot;SpecificPercentageValue&quot; |
| USELATESTPRODUCTCATALOGPRICING | &quot;UseLatestProductCatalogPricing&quot; |



