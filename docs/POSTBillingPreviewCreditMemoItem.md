

# POSTBillingPreviewCreditMemoItem


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**amount** | **Double** | The amount of the credit memo item. For tax-inclusive credit memo items, the amount indicates the credit memo item amount including tax. For tax-exclusive credit memo items, the amount indicates the credit memo item amount excluding tax  |  [optional] |
|**amountWithoutTax** | **Double** | The credit memo item amount excluding tax.  |  [optional] |
|**appliedToItemId** | **String** | The unique ID of the credit memo item that the discount charge is applied to.  |  [optional] |
|**chargeDate** | **OffsetDateTime** | The date when the credit memo item is created.  |  [optional] |
|**chargeNumber** | **String** | Number of the charge.  |  [optional] |
|**chargeType** | **String** | The type of charge.   Possible values are &#x60;OneTime&#x60;, &#x60;Recurring&#x60;, and &#x60;Usage&#x60;.  |  [optional] |
|**comment** | **String** | Comment of the credit memo item.  |  [optional] |
|**id** | **String** | Credit memo item id.  |  [optional] |
|**numberOfDeliveries** | **Double** | The number of deliveries dedicated to the Delivery Pricing charges.  **Note**: This field is available only if you have the Delivery Pricing feature enabled.    |  [optional] |
|**processingType** | **String** | Identifies the kind of charge.   Possible values: * charge * discount * prepayment * tax  |  [optional] |
|**quantity** | **BigDecimal** | Quantity of this item, in the configured unit of measure for the charge.  |  [optional] |
|**ratePlanChargeId** | **String** | Id of the rate plan charge associated with this item.  |  [optional] |
|**serviceEndDate** | **LocalDate** | End date of the service period for this item, i.e., the last day of the service period, in yyyy-mm-dd format.  |  [optional] |
|**serviceStartDate** | **LocalDate** | Start date of the service period for this item, in yyyy-mm-dd format. If the charge is a one-time fee, this is the date of that charge.  |  [optional] |
|**sku** | **String** | Unique SKU for the product associated with this item.  |  [optional] |
|**skuName** | **String** | Name of the unique SKU for the product associated with this item.  |  [optional] |
|**subscriptionId** | **String** | ID of the subscription associated with this item.  |  [optional] |
|**subscriptionNumber** | **String** | Name of the subscription associated with this item.  |  [optional] |
|**unitOfMeasure** | **String** | Unit used to measure consumption.  |  [optional] |



