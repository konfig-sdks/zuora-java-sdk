

# InvoiceItemPreviewResult


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**additionalInfo** | [**InvoiceItemPreviewResultAdditionalInfo**](InvoiceItemPreviewResultAdditionalInfo.md) |  |  [optional] |
|**amountWithoutTax** | **Double** |  |  [optional] |
|**appliedToChargeNumber** | **String** | Available when the chargeNumber of the charge that discount applies to was specified in the request or when the order is amending an existing subscription. |  [optional] |
|**chargeDescription** | **String** |  |  [optional] |
|**chargeName** | **String** |  |  [optional] |
|**chargeNumber** | **String** | Available when the &#x60;chargeNumber&#x60; field was specified in the request or when the order is amending an existing subscription. |  [optional] |
|**orderLineItemNumber** | **String** | A sequential number auto-assigned for each of order line items in a order, used as an index, for example, \&quot;1\&quot;. |  [optional] |
|**processingType** | [**ProcessingTypeEnum**](#ProcessingTypeEnum) |  |  [optional] |
|**productName** | **String** |  |  [optional] |
|**productRatePlanChargeId** | **String** |  |  [optional] |
|**serviceEndDate** | **LocalDate** |  |  [optional] |
|**serviceStartDate** | **LocalDate** |  |  [optional] |
|**subscriptionNumber** | **String** |  |  [optional] |
|**taxAmount** | **Double** |  |  [optional] |
|**taxationItems** | [**List&lt;InvoiceItemPreviewResultTaxationItemsInner&gt;**](InvoiceItemPreviewResultTaxationItemsInner.md) | List of taxation items.  **Note**: This field is only available if you set the &#x60;zuora-version&#x60; request header to &#x60;309.0&#x60; or later [available versions](https://developer.zuora.com/api-references/api/overview/#section/API-Versions/Minor-Version).  |  [optional] |
|**unitPrice** | **Double** | The per-unit price of the invoice item.  |  [optional] |



## Enum: ProcessingTypeEnum

| Name | Value |
|---- | -----|
| CHARGE | &quot;Charge&quot; |
| DISCOUNT | &quot;Discount&quot; |
| TAX | &quot;Tax&quot; |



