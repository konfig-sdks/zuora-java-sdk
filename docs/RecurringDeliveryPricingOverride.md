

# RecurringDeliveryPricingOverride

Pricing information about a recurring charge that uses the Delivery Pricing charge model. In this charge model, the charge has a fixed price. This field is only available if you have the Delivery Pricing charge model enabled.  **Note**: The Delivery Pricing charge model is in the **Early Adopter** phase. We are actively soliciting feedback from a small set of early adopters before releasing it as generally available. To manage and access this feature through the self-service interface, see [Enable billing features by yourself](https://knowledgecenter.zuora.com/Zuora_Billing/Bill_your_customers/Billing_Settings/Manage_Features) in the Knowledge Center. You can check **Delivery Pricing** in **Billing Settings** > **Enable Charge Types / Models**. 

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**priceChangeOption** | [**PriceChangeOptionEnum**](#PriceChangeOptionEnum) | Specifies how Zuora changes the price of the charge each time the subscription renews.  If the value of this field is &#x60;SpecificPercentageValue&#x60;, use the &#x60;priceIncreasePercentage&#x60; field to specify how much the price of the charge should change.  |  [optional] |
|**priceIncreasePercentage** | **Double** | Specifies the percentage by which the price of the charge should change each time the subscription renews. Only applicable if the value of the &#x60;priceChangeOption&#x60; field is &#x60;SpecificPercentageValue&#x60;.  |  [optional] |
|**deliverySchedule** | [**DeliveryScheduleParams**](DeliveryScheduleParams.md) |  |  [optional] |
|**listPrice** | **Double** | Price of the charge in each recurring period.  |  [optional] |
|**priceIntervals** | [**List&lt;PriceIntervalWithPrice&gt;**](PriceIntervalWithPrice.md) | List of interval pricing in the charge.  The &#x60;priceIntervals&#x60; field is not supported for a charge subscribed via a RatePlan, you can only override the &#x60;priceIntervals&#x60; field for a charge subscribed via an offer.  **Note**: You must enable the Offers feature to access this field. The Offers feature is in the Early Adopter phase. We are actively soliciting feedback from a small set of early adopters before releasing it as generally available. If you want to join this early adopter program, submit a request at &lt;a href&#x3D;\&quot;https://support.zuora.com/hc/en-us\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Zuora Global Support&lt;/a&gt;.  |  [optional] |



## Enum: PriceChangeOptionEnum

| Name | Value |
|---- | -----|
| NOCHANGE | &quot;NoChange&quot; |
| SPECIFICPERCENTAGEVALUE | &quot;SpecificPercentageValue&quot; |
| USELATESTPRODUCTCATALOGPRICING | &quot;UseLatestProductCatalogPricing&quot; |



