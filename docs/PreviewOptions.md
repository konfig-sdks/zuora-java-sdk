

# PreviewOptions


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**previewNumberOfPeriods** | **Integer** | The number of periods to preview when the value of the &#x60;previewThroughType&#x60; field is set to &#x60;NumberOfPeriods&#x60;.  |  [optional] |
|**previewThruType** | [**PreviewThruTypeEnum**](#PreviewThruTypeEnum) | The options on how the preview through date is calculated. Available for preview only.  - If you set this field to &#x60;SpecificDate&#x60;, you must specify a specific date in the &#x60;specificPreviewThruDate&#x60; field. If you also set &#x60;billTargetDate&#x60; in the &#x60;orderLineItems&#x60; field, order line items whose &#x60;billTargetDate&#x60; is no later than &#x60;specificPreviewThruDate&#x60; are returned.  - If you set this field to &#x60;NumberOfPeriods&#x60;, you must use the &#x60;previewNumberOfPeriods&#x60; field to specify how many periods you want to preview. In case the order only contains an order line item but not contains a subscription, if you also set &#x60;billTargetDate&#x60; in the &#x60;orderLineItems&#x60; field, order line items whose &#x60;billTargetDate&#x60; is no later than today are returned.  - The &#x60;TermEnd&#x60; option is invalid when any subscription included in this order is evergreen. In case the order only contains an order line item but not contains a subscription, if you set this field to &#x60;TermEnd&#x60; and set &#x60;billTargetDate&#x60; in the &#x60;orderLineItems&#x60; field, order line items whose &#x60;billTargetDate&#x60; is no later than today are returned.  |  [optional] |
|**previewTypes** | [**List&lt;PreviewTypesEnum&gt;**](#List&lt;PreviewTypesEnum&gt;) | One or more types of the preview. It can include:  * ChargeMetrics: charge level metrics will be returned in the response, including: &#x60;cmrr&#x60;, &#x60;tcv&#x60;, &#x60;tcb&#x60;, and &#x60;tax&#x60;. * BillingDocs: &#x60;invoices&#x60; and &#x60;creditMemos&#x60; will be returned in the response. Note &#x60;creditMemos&#x60; is only available if the Invoice Settlement feature is enabled. * OrderDeltaMetrics: order delta metrics will be returned in the response, including: &#x60;orderDeltaMrr&#x60;, &#x60;orderDeltaTcb&#x60; and  &#x60;orderDeltaTcv&#x60;. * OrderMetrics: order metrics will be returned in the response, including: &#x60;quantity&#x60;, &#x60;mrr&#x60;, &#x60;tcb&#x60;, &#x60;tcv&#x60;, and &#x60;elp&#x60;. **Note:** As of Zuora Billing Release 306, Zuora has upgraded the methodologies for calculating metrics in [Orders](https://knowledgecenter.zuora.com/Billing/Subscriptions/Orders). The new methodologies are reflected in the OrderDeltaMetrics. It is recommended that all customers use the [Order Delta Metrics](https://knowledgecenter.zuora.com/Billing/Subscriptions/Orders/Order_Delta_Metrics/AA_Overview_of_Order_Delta_Metrics). If you are an existing [Order Metrics](https://knowledgecenter.zuora.com/Billing/Subscriptions/Orders/AA_Overview_of_Orders/Key_Metrics_for_Orders) customer and want to migrate to Order Delta Metrics, submit a request at [Zuora Global Support](https://support.zuora.com/). Whereas new customers, and existing customers not currently on [Order Metrics](https://knowledgecenter.zuora.com/Billing/Subscriptions/Orders/AA_Overview_of_Orders/Key_Metrics_for_Orders), will no longer have access to Order Metrics, existing customers currently using Order Metrics will continue to be supported. * RampMetrics: ramp metrics will be returned in the response, including: &#x60;quantity&#x60;, &#x60;mrr&#x60;, &#x60;tcb&#x60;, &#x60;tcv&#x60; metrics for each charge and each ramp interval. * RampDeltaMetrics: ramp metrics changes will be returned in the response, including: &#x60;deltaQuantity&#x60;, &#x60;deltaMrr&#x60;, &#x60;deltaTcb&#x60;, &#x60;deltaTcv&#x60; metrics for each charge and each ramp interval.  |  [optional] |
|**specificPreviewThruDate** | **LocalDate** | The end date of the order preview. You can preview the invoice charges through the preview through date. (Invoice preview only)   **Note:** This field is only applicable if the &#39;previewThruType&#39; field is set to &#39;SpecificDate&#39;.  |  [optional] |



## Enum: PreviewThruTypeEnum

| Name | Value |
|---- | -----|
| SPECIFICDATE | &quot;SpecificDate&quot; |
| TERMEND | &quot;TermEnd&quot; |
| NUMBEROFPERIODS | &quot;NumberOfPeriods&quot; |



## Enum: List&lt;PreviewTypesEnum&gt;

| Name | Value |
|---- | -----|
| CHARGEMETRICS | &quot;ChargeMetrics&quot; |
| BILLINGDOCS | &quot;BillingDocs&quot; |
| ORDERDELTAMETRICS | &quot;OrderDeltaMetrics&quot; |
| ORDERMETRICS | &quot;OrderMetrics&quot; |
| RAMPMETRICS | &quot;RampMetrics&quot; |
| RAMPDELTAMETRICS | &quot;RampDeltaMetrics&quot; |



