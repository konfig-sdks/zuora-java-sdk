

# POSTSubscriptionPreviewCreditMemoItemsType


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**amountWithoutTax** | **Double** | The credit memo item amount excluding tax.  |  [optional] |
|**chargeAmount** | **Double** | The amount of the credit memo item. For tax-inclusive credit memo items, the amount indicates the credit memo item amount including tax. For tax-exclusive credit memo items, the amount indicates the credit memo item amount excluding tax  |  [optional] |
|**chargeDescription** | **String** | Description of this credit memo item.  |  [optional] |
|**chargeName** | **String** | Name of this credit memo item.  |  [optional] |
|**productName** | **String** | Name of the product associated with this credit memo item.  |  [optional] |
|**productRatePlanChargeId** | **String** | ID of the product rate plan charge associated with this credit memo item.  |  [optional] |
|**quantity** | **Integer** | Quantity of the charge associated with this credit memo item.  |  [optional] |
|**serviceEndDate** | **LocalDate** | End date of the service period for this credit memo item, as yyyy-mm-dd.  |  [optional] |
|**serviceStartDate** | **LocalDate** | Service start date of this credit memo item, as yyyy-mm-dd.  |  [optional] |
|**taxAmount** | **Double** | The tax amount of the credit memo item.  |  [optional] |
|**taxationItems** | [**List&lt;POSTSubscriptionPreviewTaxationItemsType&gt;**](POSTSubscriptionPreviewTaxationItemsType.md) | List of taxation items. **Note**: This field is only available if you set the &#x60;zuora-version&#x60; request header to &#x60;315.0&#x60; or later [available versions](https://developer.zuora.com/api-references/api/overview/#section/API-Versions/Minor-Version).  |  [optional] |
|**unitOfMeasure** | **String** | Unit used to measure consumption. |  [optional] |



