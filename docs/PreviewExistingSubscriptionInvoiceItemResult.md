

# PreviewExistingSubscriptionInvoiceItemResult


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**serviceStartDate** | **LocalDate** | Service start date as yyyy-mm-dd. If the charge is a one-time fee, this is the date of that charge. |  [optional] |
|**serviceEndDate** | **LocalDate** | End date of the service period for this item, i.e., the last day of the period, as yyyy-mm-dd. |  [optional] |
|**amountWithoutTax** | **Double** | Invoice amount minus tax. |  [optional] |
|**taxAmount** | **Double** | The tax amount of the invoice item. |  [optional] |
|**chargeDescription** | **String** | Description of the charge. |  [optional] |
|**chargeName** | **String** | Name of the charge. |  [optional] |
|**chargeNumber** | **String** | Available when the &#x60;chargeNumber&#x60; field was specified in the request or when the order is amending an existing subscription. |  [optional] |
|**productName** | **String** | Name of the product. |  [optional] |
|**productRatePlanChargeId** | **String** | The ID of the product rate plan charge. |  [optional] |
|**processingType** | [**ProcessingTypeEnum**](#ProcessingTypeEnum) | The processing type of the invoice item. |  [optional] |
|**unitPrice** | **Double** | The unit price of the charge. |  [optional] |
|**quantity** | **Double** | The quantity of the charge. |  [optional] |
|**unitOfMeasure** | **String** | The unit of measure of the charge. |  [optional] |
|**discountDetails** | [**List&lt;PreviewExistingSubscriptionDiscountDetails&gt;**](PreviewExistingSubscriptionDiscountDetails.md) | Container for discount details. |  [optional] |



## Enum: ProcessingTypeEnum

| Name | Value |
|---- | -----|
| CHARGE | &quot;Charge&quot; |
| DISCOUNT | &quot;Discount&quot; |
| TAX | &quot;Tax&quot; |



