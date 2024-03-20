

# POSTSubscriptionPreviewInvoiceItemsType


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**chargeAmount** | **Double** | The amount of the charge. This amount doesn&#39;t include taxes unless the charge&#39;s tax mode is inclusive.  |  [optional] |
|**chargeDescription** | **String** | Description of the charge.  |  [optional] |
|**chargeName** | **String** | Name of the charge.  |  [optional] |
|**productName** | **String** | Name of the product associated with this item.  |  [optional] |
|**productRatePlanChargeId** | **String** | ID of the product rate plan charge.  |  [optional] |
|**quantity** | **Double** | Quantity of this item.  |  [optional] |
|**serviceEndDate** | **LocalDate** | End date of the service period for this item, i.e., the last day of the period, as yyyy-mm-dd.  |  [optional] |
|**serviceStartDate** | **LocalDate** | Service start date as yyyy-mm-dd. If the charge is a one-time fee, this is the date of that charge.  |  [optional] |
|**taxAmount** | **Double** | The tax amount of the invoice item.  |  [optional] |
|**taxationItems** | [**List&lt;POSTSubscriptionPreviewTaxationItemsType&gt;**](POSTSubscriptionPreviewTaxationItemsType.md) | List of taxation items. **Note**: This field is only available if you set the &#x60;zuora-version&#x60; request header to &#x60;315.0&#x60; or later [available versions](https://developer.zuora.com/api-references/api/overview/#section/API-Versions/Minor-Version).  |  [optional] |
|**unitOfMeasure** | **String** |  |  [optional] |



