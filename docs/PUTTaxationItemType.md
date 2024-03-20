

# PUTTaxationItemType


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**exemptAmount** | **Double** | The calculated tax amount excluded due to the exemption.  |  [optional] |
|**financeInformation** | [**POSTTaxationItemForCMTypeAllOfFinanceInformation**](POSTTaxationItemForCMTypeAllOfFinanceInformation.md) |  |  [optional] |
|**jurisdiction** | **String** | The jurisdiction that applies the tax or VAT. This value is typically a state, province, county, or city.  |  [optional] |
|**locationCode** | **String** | The identifier for the location based on the value of the &#x60;taxCode&#x60; field.   |  [optional] |
|**name** | **String** | The name of the taxation item to be updated.  |  [optional] |
|**taxAmount** | **Double** | The amount of the tax applied to the credit or debit memo.  |  [optional] |
|**taxCode** | **String** | The tax code identifies which tax rules and tax rates to apply to a specific credit or debit memo.  |  [optional] |
|**taxCodeDescription** | **String** | The description of the tax code.  |  [optional] |
|**taxDate** | **LocalDate** | The date when the tax is applied to the credit or debit memo.  |  [optional] |
|**taxRate** | **Double** | The tax rate applied to the credit or debit memo.  |  [optional] |
|**taxRateDescription** | **String** | The description of the tax rate.   |  [optional] |
|**taxRateType** | [**TaxRateTypeEnum**](#TaxRateTypeEnum) | The type of the tax rate applied to the credit or debit memo.  |  [optional] |



## Enum: TaxRateTypeEnum

| Name | Value |
|---- | -----|
| PERCENTAGE | &quot;Percentage&quot; |
| FLATFEE | &quot;FlatFee&quot; |



