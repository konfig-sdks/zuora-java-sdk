

# PUTCreditMemoItemType


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**amount** | **Double** | The amount of the credit memo item. For tax-inclusive credit memo items, the amount indicates the credit memo item amount including tax. For tax-exclusive credit memo items, the amount indicates the credit memo item amount excluding tax  |  [optional] |
|**comment** | **String** | Comments about the credit memo item.  |  [optional] |
|**excludeItemBillingFromRevenueAccounting** | **Boolean** | The flag to exclude the credit memo item from revenue accounting.  **Note**: This field is only available if you have the Billing - Revenue Integration feature enabled.   |  [optional] |
|**financeInformation** | [**CreditMemoItemFromWriteOffInvoiceAllOfFinanceInformation**](CreditMemoItemFromWriteOffInvoiceAllOfFinanceInformation.md) |  |  [optional] |
|**id** | **String** | The ID of the credit memo item.  |  |
|**quantity** | **Double** | The number of units for the credit memo item.  |  [optional] |
|**serviceEndDate** | **LocalDate** | The service end date of the credit memo item.  |  [optional] |
|**serviceStartDate** | **LocalDate** | The service start date of the credit memo item.  |  [optional] |
|**skuName** | **String** | The name of the SKU.  |  [optional] |
|**taxItems** | [**List&lt;PutCreditMemoTaxItemType&gt;**](PutCreditMemoTaxItemType.md) | Container for credit memo taxation items.  |  [optional] |
|**unitOfMeasure** | **String** | The definable unit that you measure when determining charges.  |  [optional] |



