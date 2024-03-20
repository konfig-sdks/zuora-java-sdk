

# GETCMTaxItemTypeNewAllOf


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**appliedAmount** | **Double** | The applied amount of the taxation item.  |  [optional] |
|**exemptAmount** | **Double** | The calculated tax amount excluded due to the exemption.  |  [optional] |
|**financeInformation** | [**GETCMTaxItemTypeNewAllOfFinanceInformation**](GETCMTaxItemTypeNewAllOfFinanceInformation.md) |  |  [optional] |
|**id** | **String** | The ID of the taxation item.  |  [optional] |
|**jurisdiction** | **String** | The jurisdiction that applies the tax or VAT. This value is typically a state, province, county, or city.  |  [optional] |
|**locationCode** | **String** | The identifier for the location based on the value of the &#x60;taxCode&#x60; field.  |  [optional] |
|**name** | **String** | The name of the taxation item.  |  [optional] |
|**refundAmount** | **Double** | The amount of the refund on the taxation item.  |  [optional] |
|**sourceTaxItemId** | **String** | The ID of the source taxation item.  |  [optional] |
|**taxAmount** | **Double** | The amount of taxation.  |  [optional] |
|**taxCode** | **String** | The tax code identifies which tax rules and tax rates to apply to a specific credit memo.  |  [optional] |
|**taxCodeDescription** | **String** | The description of the tax code.  |  [optional] |
|**taxDate** | **LocalDate** | The date that the tax is applied to the credit memo, in &#x60;yyyy-mm-dd&#x60; format.  |  [optional] |
|**taxRate** | **Double** | The tax rate applied to the credit memo.  |  [optional] |
|**taxRateDescription** | **String** | The description of the tax rate.  |  [optional] |
|**taxRateType** | [**TaxRateTypeEnum**](#TaxRateTypeEnum) | The type of the tax rate.  |  [optional] |
|**unappliedAmount** | **Double** | The unapplied amount of the taxation item.  |  [optional] |



## Enum: TaxRateTypeEnum

| Name | Value |
|---- | -----|
| PERCENTAGE | &quot;Percentage&quot; |
| FLATFEE | &quot;FlatFee&quot; |



