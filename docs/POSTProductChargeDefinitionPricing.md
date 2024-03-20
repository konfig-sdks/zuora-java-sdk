

# POSTProductChargeDefinitionPricing


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**currency** | **String** | The currency for the price.  |  [optional] |
|**discountAmount** | **Double** | The specific amount for a fixed discount. The field is applicable only for charges based on the Discount-Fixed Amount charge model.  |  [optional] |
|**discountPercentage** | **Double** | The percentage of discount for a percentage discount. The field is applicable only for charges based on the Discount-Percentage charge model.  |  [optional] |
|**price** | **Double** | The price of this item.   This field is only applicable for charges based on the following charge models:   - Flat Fee   - Per Unit   - Delivery Pricing  |  [optional] |
|**tiers** | **List&lt;List&lt;POSTChargeDefinitionPricingTierInner&gt;&gt;** | Container for the tiers of the price item.   This field is only applicable for charges based on the following charge models:   - Tiered Pricing   - Volume Pricing  You must specify all relevant fields of all tiers, including pricing information for each currency. For each currency, ensure that the tiers appear in ascending order of &#x60;StartingUnit&#x60;.  For example:  &#x60;&#x60;&#x60; [   {     \&quot;startingUnit\&quot;: \&quot;1\&quot;,     \&quot;endingUnit\&quot;: \&quot;150\&quot;,     \&quot;currency\&quot;: \&quot;USD\&quot;,     \&quot;price\&quot;: 1.95,     \&quot;priceFormat\&quot;: \&quot;Per Unit\&quot;   },   {     \&quot;startingUnit\&quot;: \&quot;151\&quot;,     \&quot;endingUnit\&quot;: \&quot;300\&quot;,     \&quot;currency\&quot;: \&quot;USD\&quot;,     \&quot;price\&quot;: 1.45,     \&quot;priceFormat\&quot;: \&quot;Per Unit\&quot;   },   {     \&quot;startingUnit\&quot;: \&quot;1\&quot;,     \&quot;endingUnit\&quot;: \&quot;150\&quot;,     \&quot;currency\&quot;: \&quot;EUR\&quot;,     \&quot;price\&quot;: 1.75,     \&quot;priceFormat\&quot;: \&quot;Per Unit\&quot;   },   {     \&quot;startingUnit\&quot;: \&quot;151\&quot;,     \&quot;endingUnit\&quot;: \&quot;300\&quot;,     \&quot;currency\&quot;: \&quot;EUR\&quot;,     \&quot;price\&quot;: 1.30,     \&quot;priceFormat\&quot;: \&quot;Per Unit\&quot;   } ] &#x60;&#x60;&#x60;      |  [optional] |



