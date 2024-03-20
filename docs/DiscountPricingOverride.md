

# DiscountPricingOverride

Pricing information about a discount charge. 

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**applyDiscountTo** | [**ApplyDiscountToEnum**](#ApplyDiscountToEnum) | Specifies which type of charge the discount charge applies to.  |  [optional] |
|**applyToBillingPeriodPartially** | **Boolean** | Allow the discount duration to be aligned with the billing period partially.  **Note**: You must enable the [Enhanced Discounts](https://knowledgecenter.zuora.com/Zuora_Billing/Build_products_and_prices/Basic_concepts_and_terms/B_Charge_Models/D_Manage_Enhanced_Discount) feature to access this field.  |  [optional] |
|**discountAmount** | **Double** | Only applicable if the discount charge is a fixed-amount discount.  |  [optional] |
|**discountApplyDetails** | [**List&lt;DiscountApplyDetail&gt;**](DiscountApplyDetail.md) | Charge list of discount be applied to.  **Note**: You must enable the [Enhanced Discounts](https://knowledgecenter.zuora.com/Zuora_Billing/Build_products_and_prices/Basic_concepts_and_terms/B_Charge_Models/D_Manage_Enhanced_Discount) feature to access this field.  |  [optional] |
|**discountClass** | **String** | The discount class defines the sequence in which discount product rate plan charges are applied.  **Note**: You must enable the [Enhanced Discounts](https://knowledgecenter.zuora.com/Zuora_Billing/Build_products_and_prices/Basic_concepts_and_terms/B_Charge_Models/D_Manage_Enhanced_Discount) feature to access this field.  |  [optional] |
|**discountLevel** | [**DiscountLevelEnum**](#DiscountLevelEnum) | Application scope of the discount charge. For example, if the value of this field is &#x60;subscription&#x60; and the value of the &#x60;applyDiscountTo&#x60; field is &#x60;RECURRING&#x60;, the discount charge applies to all recurring charges in the same subscription as the discount charge.  |  [optional] |
|**discountPercentage** | **Double** | Only applicable if the discount charge is a percentage discount.  |  [optional] |
|**originalDiscountAmount** | **Double** | The manufacturer&#39;s suggested retail discount price for standalone charge.  Only applicable if the standalone discount charge is a fixed-amount discount.  **Note:** This field is available when the &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Manage_subscription_transactions/Orders/Standalone_Orders/AA_Overview_of_Standalone_Orders\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Standalone Orders&lt;/a&gt; feature is enabled.  |  [optional] |
|**originalDiscountPercentage** | **Double** | The manufacturer&#39;s suggested retail discount percentage for standalone charge.  Only applicable if the standalone discount charge is a percentage discount.  **Note:** This field is available when the &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Manage_subscription_transactions/Orders/Standalone_Orders/AA_Overview_of_Standalone_Orders\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Standalone Orders&lt;/a&gt; feature is enabled.  |  [optional] |
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



