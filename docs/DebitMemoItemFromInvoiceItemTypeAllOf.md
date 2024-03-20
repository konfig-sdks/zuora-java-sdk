

# DebitMemoItemFromInvoiceItemTypeAllOf


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**description** | **String** | The description of the debit memo item. **Note**: This field is only available if you set the &#x60;zuora-version&#x60; request header to &#x60;257.0&#x60; or later [available versions](https://developer.zuora.com/api-references/api/overview/#section/API-Versions/Minor-Version).  |  [optional] |
|**amount** | **Double** | The amount of the debit memo item.  |  |
|**comment** | **String** | Comments about the debit memo item. **Note**: This field is not available if you set the &#x60;zuora-version&#x60; request header to &#x60;257.0&#x60; or later [available versions](https://developer.zuora.com/api-references/api/overview/#section/API-Versions/Minor-Version).  |  [optional] |
|**financeInformation** | [**PUTDebitMemoItemTypeAllOfFinanceInformation**](PUTDebitMemoItemTypeAllOfFinanceInformation.md) |  |  [optional] |
|**invoiceItemId** | **String** | The ID of the invoice item.  |  [optional] |
|**quantity** | **Double** | The number of units for the debit memo item.  |  [optional] |
|**serviceEndDate** | **LocalDate** | The service end date of the debit memo item.  |  [optional] |
|**serviceStartDate** | **LocalDate** | The service start date of the debit memo item.   |  [optional] |
|**skuName** | **String** | The name of the charge associated with the invoice.  |  |
|**taxItems** | [**List&lt;DebitMemoTaxItemFromInvoiceTaxItemType&gt;**](DebitMemoTaxItemFromInvoiceTaxItemType.md) | Container for taxation items.  |  [optional] |
|**taxMode** | [**TaxModeEnum**](#TaxModeEnum) | The tax mode of the debit memo item, indicating whether the amount of the debit memo item includes tax.  **Note**: You can set this field to &#x60;TaxInclusive&#x60; only if the &#x60;taxAutoCalculation&#x60; field is set to &#x60;true&#x60;.  If you set &#x60;taxMode&#x60; to &#x60;TaxInclusive&#x60;, you cannot input tax amounts for debit memo items. The corresponding invoice item must use the same tax engine as the debit memo item to calculate tax amounts.  |  [optional] |
|**unitOfMeasure** | **String** | The definable unit that you measure when determining charges.  |  [optional] |



## Enum: TaxModeEnum

| Name | Value |
|---- | -----|
| TAXEXCLUSIVE | &quot;TaxExclusive&quot; |
| TAXINCLUSIVE | &quot;TaxInclusive&quot; |



