

# OrderActionRatePlanRecurringPerUnitPricingOverrideAllOf


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**listPrice** | **Double** | Per-unit price of the charge in each recurring period.  |  [optional] |
|**listPriceBase** | [**ListPriceBaseEnum**](#ListPriceBaseEnum) | Specifies the duration of each recurring period.  **Note**: The &#x60;Per_Year&#x60; and &#x60;Per_Specific_Months&#x60; enum values are available only if you have the &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Billing/Subscriptions/Product_Catalog/I_Annual_List_Price\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Annual List Price&lt;/a&gt; feature enabled.                |  [optional] |
|**quantity** | **Double** | Number of units purchased.  |  [optional] |
|**specificListPriceBase** | **Integer** | The number of months for the list price base of the charge. This field is required if you set the value of the &#x60;listPriceBase&#x60; field to &#x60;Per_Specific_Months&#x60;.  |  [optional] |



## Enum: ListPriceBaseEnum

| Name | Value |
|---- | -----|
| BILLING_PERIOD | &quot;Per_Billing_Period&quot; |
| MONTH | &quot;Per_Month&quot; |
| WEEK | &quot;Per_Week&quot; |
| YEAR | &quot;Per_Year&quot; |
| SPECIFIC_MONTHS | &quot;Per_Specific_Months&quot; |



