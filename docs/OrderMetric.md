

# OrderMetric

The set of order metrics for an order action.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**chargeNumber** | **String** |  |  [optional] |
|**elp** | [**List&lt;TimeSlicedElpNetMetrics&gt;**](TimeSlicedElpNetMetrics.md) | The extended list price which is calculated by the original product catalog list price multiplied by the delta quantity.  The &#x60;elp&#x60; nested field is only available to existing Orders customers who already have access to the field.  **Note:** The following Order Metrics have been deprecated. Any new customers who onboard on [Orders](https://knowledgecenter.zuora.com/Billing/Subscriptions/Orders/AA_Overview_of_Orders) or [Orders Harmonization](https://knowledgecenter.zuora.com/Billing/Subscriptions/Orders/Orders_Harmonization/Orders_Harmonization) will not get these metrics. * The Order ELP and Order Item objects  * The \&quot;Generated Reason\&quot; and \&quot;Order Item ID\&quot; fields in the Order MRR, Order TCB, Order TCV, and Order Quantity objects  Existing Orders customers who have these metrics will continue to be supported.  |  [optional] |
|**mrr** | [**List&lt;TimeSlicedNetMetrics&gt;**](TimeSlicedNetMetrics.md) |  |  [optional] |
|**originRatePlanId** | **String** |  |  [optional] |
|**productRatePlanChargeId** | **String** |  |  [optional] |
|**productRatePlanId** | **String** |  |  [optional] |
|**subscriptionRatePlanNumber** | **String** | Number of a subscription rate plan for this subscription.  |  [optional] |
|**quantity** | [**List&lt;TimeSlicedMetrics&gt;**](TimeSlicedMetrics.md) |  |  [optional] |
|**tcb** | [**List&lt;TimeSlicedTcbNetMetrics&gt;**](TimeSlicedTcbNetMetrics.md) | Total contracted billing which is the forecast value for the total invoice amount. |  [optional] |
|**tcv** | [**List&lt;TimeSlicedNetMetrics&gt;**](TimeSlicedNetMetrics.md) | Total contracted value. |  [optional] |



