

# TaxItems


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**exemptAmount** | **BigDecimal** | The calculated tax amount excluded due to the exemption.  |  [optional] |
|**jurisdiction** | **String** | The jurisdiction that applies the tax or VAT. This value is typically a state, province, county, or city.  |  [optional] |
|**locationCode** | **String** | The identifier for the location based on the value of the &#x60;taxCode&#x60; field.  |  [optional] |
|**name** | **String** | The name of taxation.  |  |
|**taxAmount** | **BigDecimal** | The amount of the taxation item in the invoice item.  |  |
|**taxCode** | **String** | The tax code identifies which tax rules and tax rates to apply to a specific invoice item.  |  |
|**taxCodeDescription** | **String** | The description of the tax code.  |  [optional] |
|**taxDate** | **LocalDate** | The date that the tax is applied to the invoice item, in &#x60;yyyy-mm-dd&#x60; format.  |  |
|**taxMode** | [**TaxModeEnum**](#TaxModeEnum) | The tax mode of the invoice item, indicating whether the amount of the invoice item includes tax.  |  |
|**taxRate** | **BigDecimal** | The tax rate applied to the invoice item.  |  |
|**taxRateDescription** | **String** | The description of the tax rate.  |  [optional] |
|**taxRateType** | [**TaxRateTypeEnum**](#TaxRateTypeEnum) | The type of the tax rate applied to the invoice item.  |  |



## Enum: TaxModeEnum

| Name | Value |
|---- | -----|
| TAXINCLUSIVE | &quot;TaxInclusive&quot; |
| TAXEXCLUSIVE | &quot;TaxExclusive&quot; |



## Enum: TaxRateTypeEnum

| Name | Value |
|---- | -----|
| PERCENTAGE | &quot;Percentage&quot; |
| FLATFEE | &quot;FlatFee&quot; |



