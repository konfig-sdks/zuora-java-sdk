

# PUTDebitMemoItemTypeAllOf


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**amount** | **Double** | The amount of the debit memo item. For tax-inclusive debit memo items, the amount indicates the debit memo item amount including tax. For tax-exclusive debit memo items, the amount indicates the debit memo item amount excluding tax.  |  [optional] |
|**comment** | **String** | Comments about the debit memo item.  |  [optional] |
|**excludeItemBillingFromRevenueAccounting** | **Boolean** | The flag to exclude the debit memo item from revenue accounting.  **Note**: This field is only available if you have the Billing - Revenue Integration feature enabled.              |  [optional] |
|**financeInformation** | [**PUTDebitMemoItemTypeAllOfFinanceInformation**](PUTDebitMemoItemTypeAllOfFinanceInformation.md) |  |  [optional] |
|**id** | **String** | The ID of the debit memo item.  |  |
|**quantity** | **Double** | The number of units for the debit memo item.  |  [optional] |
|**serviceEndDate** | **LocalDate** | The service end date of the debit memo item.  |  [optional] |
|**serviceStartDate** | **LocalDate** | The service start date of the debit memo item.   |  [optional] |
|**skuName** | **String** | The name of the SKU.  |  [optional] |
|**taxItems** | [**List&lt;PutDebitMemoTaxItemType&gt;**](PutDebitMemoTaxItemType.md) | Container for debit memo taxation items.  |  [optional] |
|**unitOfMeasure** | **String** | The definable unit that you measure when determining charges.  |  [optional] |



