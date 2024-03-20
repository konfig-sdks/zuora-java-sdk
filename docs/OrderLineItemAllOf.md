

# OrderLineItemAllOf


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**amount** | **Double** | The calculated gross amount for the Order Line Item.  |  [optional] |
|**amountWithoutTax** | **Double** | The calculated gross amount for an order line item excluding tax. If the tax mode is tax exclusive, the value of this field equals that of the &#x60;amount&#x60; field.  If the tax mode of an order line item is not set, the system treats it as tax exclusive by default. The value of the &#x60;amountWithoutTax&#x60; field equals that of the &#x60;amount&#x60; field.  If you create an order line item from the product catalog, the tax mode and tax code of the product rate plan charge are used for the order line item by default. You can still overwrite this default set-up by setting the tax mode and tax code of the order line item.  |  [optional] |
|**id** | **UUID** | The sytem generated Id for the Order Line Item.  |  [optional] |
|**invoiceGroupNumber** | **String** | The number of the invoice group associated with the order line item.  After enabling the Invoice Grouping feature, you can specify invoice group numbers to bill subscriptions and order line items based on specific criteria. For the same account, Zuora generates separate invoices for subscriptions and order line items, each identified by unique invoice group numbers. For more information, see [Invoice Grouping](https://knowledgecenter.zuora.com/Billing/Subscriptions/Invoice_Grouping).  **Note**:    - If you have the &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Bill_your_customers/Bill_customers_at_subscription_level/Flexible_Billing_Attributes\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Flexible Billing Attributes&lt;/a&gt; feature disabled, this field is unavailable in the request body and the value of this field is &#x60;null&#x60; in the response body.    - If you have the Flexible Billing Attributes feature enabled, and you do not specify this field in the request during subscription creation, the value of this field is automatically set to &#x60;null&#x60; in the response body.  |  [optional] |
|**quantityFulfilled** | **Double** | The quantity that has been fulfilled by fulfillments for the order line item. This field will be updated automatically when related fulfillments become &#39;SentToBilling&#39; or &#39;Complete&#39; state.  |  [optional] |
|**quantityPendingFulfillment** | **Double** | The quantity that needs to be fulfilled by fulfillments for the order line item. This field will be updated automatically when related fulfillments become &#39;SentToBilling&#39; or &#39;Complete&#39; state.  |  [optional] |



