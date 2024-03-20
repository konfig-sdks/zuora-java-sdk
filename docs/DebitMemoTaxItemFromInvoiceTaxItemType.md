

# DebitMemoTaxItemFromInvoiceTaxItemType


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**amount** | **Double** | The amount of the debit memo taxation item.  |  [optional] |
|**financeInformation** | [**DebitMemoTaxItemFromInvoiceTaxItemTypeFinanceInformation**](DebitMemoTaxItemFromInvoiceTaxItemTypeFinanceInformation.md) |  |  [optional] |
|**jurisdiction** | **String** | The jurisdiction that applies the tax or VAT. This value is typically a state, province, county, or city.  |  [optional] |
|**locationCode** | **String** | The identifier for the location based on the value of the &#x60;taxCode&#x60; field.  |  [optional] |
|**sourceTaxItemId** | **String** | The ID of the source taxation item.  |  [optional] |
|**taxCode** | **String** | The tax code identifies which tax rules and tax rates to apply to a specific debit memo.  |  [optional] |
|**taxCodeDescription** | **String** | The description of the tax code.  |  [optional] |
|**taxDate** | **LocalDate** | The date that the tax is applied to the debit memo, in &#x60;yyyy-mm-dd&#x60; format.  |  [optional] |
|**taxExemptAmount** | **Double** | The calculated tax amount excluded due to the exemption.  |  [optional] |
|**taxName** | **String** | The name of taxation.  |  [optional] |
|**taxRate** | **Double** | The tax rate applied to the debit memo.  |  [optional] |
|**taxRateDescription** | **String** | The description of the tax rate.  |  [optional] |
|**taxRateType** | [**TaxRateTypeEnum**](#TaxRateTypeEnum) | The type of the tax rate applied to the debit memo.  |  [optional] |



## Enum: TaxRateTypeEnum

| Name | Value |
|---- | -----|
| PERCENTAGE | &quot;Percentage&quot; |
| FLATFEE | &quot;FlatFee&quot; |



