

# POSTBillingPreviewInvoiceItem


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**appliedToItemId** | **String** | The unique ID of the invoice item that the discount charge is applied to.  |  [optional] |
|**chargeAmount** | **BigDecimal** | The amount of the charge. This amount doesn&#39;t include taxes regardless if the charge&#39;s tax mode is inclusive or exclusive.  |  [optional] |
|**chargeDate** | **OffsetDateTime** | The date when the invoice item was created.  |  [optional] |
|**chargeDescription** | **String** | Description of the charge.  |  [optional] |
|**chargeId** | **String** | Id of the charge.  |  [optional] |
|**chargeName** | **String** | Name of the charge.  |  [optional] |
|**chargeNumber** | **String** | Number of the charge.  |  [optional] |
|**chargeType** | **String** | The type of charge.   Possible values are &#x60;OneTime&#x60;, &#x60;Recurring&#x60;, and &#x60;Usage&#x60;.  |  [optional] |
|**id** | **String** | Invoice item ID.  |  [optional] |
|**numberOfDeliveries** | **Double** | The number of deliveries dedicated to the Delivery Pricing charges.  **Note**: This field is available only if you have the Delivery Pricing feature enabled.   |  [optional] |
|**processingType** | **String** | Identifies the kind of charge.   Possible values: * charge * discount * prepayment * tax  |  [optional] |
|**productName** | **String** | Name of the product associated with this item.  |  [optional] |
|**quantity** | **BigDecimal** | Quantity of this item, in the configured unit of measure for the charge.  |  [optional] |
|**serviceEndDate** | **LocalDate** | End date of the service period for this item, i.e., the last day of the service period, in &#x60;yyyy-mm-dd&#x60; format.  |  [optional] |
|**serviceStartDate** | **LocalDate** | Start date of the service period for this item, in &#x60;yyyy-mm-dd&#x60; format. If the charge is a one-time fee, this is the date of that charge.  |  [optional] |
|**subscriptionId** | **String** | ID of the subscription associated with this item.  |  [optional] |
|**subscriptionName** | **String** | Name of the subscription associated with this item.  |  [optional] |
|**subscriptionNumber** | **String** | Number of the subscription associated with this item.  |  [optional] |
|**taxAmount** | **BigDecimal** | If you use [Zuora Tax](https://knowledgecenter.zuora.com/Billing/Taxes/A_Zuora_Tax) and the product rate plan charge associated with the invoice item is of [tax inclusive mode](https://knowledgecenter.zuora.com/Billing/Taxes/A_Zuora_Tax/D_Associate_tax_codes_with_product_charges_and_set_the_tax_mode), the value of this field is the amount of tax applied to the charge. Otherwise, the value of this field is &#x60;0&#x60;.   |  [optional] |
|**unitOfMeasure** | **String** | Unit used to measure consumption.  |  [optional] |



