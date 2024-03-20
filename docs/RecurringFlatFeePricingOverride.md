

# RecurringFlatFeePricingOverride

Pricing information about a recurring charge that uses the \"flat fee\" charge model. In this charge model, the charge has a fixed price. 

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**priceChangeOption** | [**PriceChangeOptionEnum**](#PriceChangeOptionEnum) | Specifies how Zuora changes the price of the charge each time the subscription renews.  If the value of this field is &#x60;SpecificPercentageValue&#x60;, use the &#x60;priceIncreasePercentage&#x60; field to specify how much the price of the charge should change.  |  [optional] |
|**priceIncreasePercentage** | **Double** | Specifies the percentage by which the price of the charge should change each time the subscription renews. Only applicable if the value of the &#x60;priceChangeOption&#x60; field is &#x60;SpecificPercentageValue&#x60;.  |  [optional] |
|**listPrice** | **Double** | Price of the charge in each recurring period.  |  [optional] |
|**listPriceBase** | [**ListPriceBaseEnum**](#ListPriceBaseEnum) | Specifies the duration of each recurring period.  |  [optional] |
|**originalListPrice** | **Double** | The original list price is the price of a product or service at which it is listed for sale by a manufacturer or retailer.  |  [optional] |
|**priceIntervals** | [**List&lt;PriceIntervalWithPrice&gt;**](PriceIntervalWithPrice.md) | List of interval pricing in the charge.  The &#x60;priceIntervals&#x60; field is not supported for a charge subscribed via a RatePlan, you can only override the &#x60;priceIntervals&#x60; field for a charge subscribed via an offer.   **Note**: You must enable the Offers feature to access this field. The Offers feature is in the Early Adopter phase. We are actively soliciting feedback from a small set of early adopters before releasing it as generally available. If you want to join this early adopter program, submit a request at &lt;a href&#x3D;\&quot;https://support.zuora.com/hc/en-us\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Zuora Global Support&lt;/a&gt;.  |  [optional] |
|**specificListPriceBase** | **Integer** | The number of months for the list price base of the charge. This field is required if you set the value of the &#x60;listPriceBase&#x60; field to &#x60;Per_Specific_Months&#x60;.  **Note**:    - This field is available only if you have the &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Billing/Subscriptions/Product_Catalog/I_Annual_List_Price\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Annual List Price&lt;/a&gt; feature enabled.   - The value of this field is &#x60;null&#x60; if you do not set the value of the &#x60;listPriceBase&#x60; field to &#x60;Per_Specific_Months&#x60;.                |  [optional] |



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



