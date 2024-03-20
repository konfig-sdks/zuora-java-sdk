

# GETTaxationItemTypewithSuccessAllOf


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**createdById** | **String** | The ID of the Zuora user who created the taxation item.  |  [optional] |
|**createdDate** | **OffsetDateTime** | The date and time when the taxation item was created in the Zuora system, in &#x60;yyyy-mm-dd hh:mm:ss&#x60; format.  |  [optional] |
|**exemptAmount** | **Double** | The calculated tax amount excluded due to the exemption.  |  [optional] |
|**financeInformation** | [**GETTaxationItemTypewithSuccessAllOfFinanceInformation**](GETTaxationItemTypewithSuccessAllOfFinanceInformation.md) |  |  [optional] |
|**id** | **String** | The ID of the taxation item.  |  [optional] |
|**invoiceItemId** | **String** | The ID of the invoice associated with the taxation item.  |  [optional] |
|**jurisdiction** | **String** | The jurisdiction that applies the tax or VAT. This value is typically a state, province, county, or city.  |  [optional] |
|**locationCode** | **String** | The identifier for the location based on the value of the &#x60;taxCode&#x60; field.  |  [optional] |
|**name** | **String** | The name of the taxation item.  |  [optional] |
|**taxAmount** | **Double** | The amount of the tax applied to the invoice.  |  [optional] |
|**taxCode** | **String** | The tax code identifies which tax rules and tax rates to apply to a specific invoice.  |  [optional] |
|**taxCodeDescription** | **String** | The description of the tax code.  |  [optional] |
|**taxDate** | **LocalDate** | The date when the tax is applied to the invoice.  |  [optional] |
|**taxMode** | [**TaxModeEnum**](#TaxModeEnum) | The tax mode of the invoice item, indicating whether the amount of the invoice item includes tax.  |  [optional] |
|**taxRate** | **Double** | The tax rate applied to the invoice.  |  [optional] |
|**taxRateDescription** | **String** | The description of the tax rate.  |  [optional] |
|**taxRateType** | [**TaxRateTypeEnum**](#TaxRateTypeEnum) | The type of the tax rate applied to the invoice.  |  [optional] |
|**updatedById** | **String** | The ID of the Zuora user who last updated the taxation item.  |  [optional] |
|**updatedDate** | **OffsetDateTime** | The date and time when the taxation item was last updated, in &#x60;yyyy-mm-dd hh:mm:ss&#x60; format.  |  [optional] |



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



