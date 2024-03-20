

# RecurringDeliveryPricingOverrideAllOf


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**deliverySchedule** | [**DeliveryScheduleParams**](DeliveryScheduleParams.md) |  |  [optional] |
|**listPrice** | **Double** | Price of the charge in each recurring period.  |  [optional] |
|**priceIntervals** | [**List&lt;PriceIntervalWithPrice&gt;**](PriceIntervalWithPrice.md) | List of interval pricing in the charge.  The &#x60;priceIntervals&#x60; field is not supported for a charge subscribed via a RatePlan, you can only override the &#x60;priceIntervals&#x60; field for a charge subscribed via an offer.  **Note**: You must enable the Offers feature to access this field. The Offers feature is in the Early Adopter phase. We are actively soliciting feedback from a small set of early adopters before releasing it as generally available. If you want to join this early adopter program, submit a request at &lt;a href&#x3D;\&quot;https://support.zuora.com/hc/en-us\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Zuora Global Support&lt;/a&gt;.  |  [optional] |



