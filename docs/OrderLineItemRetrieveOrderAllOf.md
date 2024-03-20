

# OrderLineItemRetrieveOrderAllOf


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**amendedByOrderOn** | **String** | The date when the rate plan charge is amended through an order or amendment. This field is to standardize the booking date information to increase audit ability and traceability of data between Zuora Billing and Zuora Revenue. It is mapped as the booking date for a sale order line in Zuora Revenue.  |  [optional] |
|**amount** | **Double** | The calculated gross amount for the Order Line Item.  |  [optional] |
|**amountWithoutTax** | **Double** | The calculated gross amount for an order line item excluding tax. If the tax mode is tax exclusive, the value of this field equals that of the &#x60;amount&#x60; field.  If the tax mode of an order line item is not set, the system treats it as tax exclusive by default. The value of the &#x60;amountWithoutTax&#x60; field equals that of the &#x60;amount&#x60; field.  If you create an order line item from the product catalog, the tax mode and tax code of the product rate plan charge are used for the order line item by default. You can still overwrite this default set-up by setting the tax mode and tax code of the order line item.  |  [optional] |
|**id** | **UUID** | The sytem generated Id for the Order Line Item.  |  [optional] |
|**invoiceGroupNumber** | **String** | The number of the invoice group associated with the order line item.   The value of this field is &#x60;null&#x60; if you have the [Flexible Billing Attributes](https://knowledgecenter.zuora.com/Billing/Subscriptions/Flexible_Billing_Attributes) feature disabled.  |  [optional] |
|**itemNumber** | **String** | The number for the Order Line Item.  |  [optional] |
|**originalOrderDate** | **LocalDate** | The date when the rate plan charge is created through an order or amendment. This field is to standardize the booking date information to increase audit ability and traceability of data between Zuora Billing and Zuora Revenue. It is mapped as the booking date for a sale order line in Zuora Revenue.  |  [optional] |
|**quantityFulfilled** | **Double** | The quantity that has been fulfilled by fulfillments for the order line item. This field will be updated automatically when related fulfillments become &#39;SentToBilling&#39; or &#39;Complete&#39; state.  |  [optional] |
|**quantityPendingFulfillment** | **Double** | The quantity that&#39;s need to be fulfilled by fulfillments for the order line item. This field will be updated automatically when related fulfillments become &#39;SentToBilling&#39; or &#39;Complete&#39; state.  |  [optional] |



