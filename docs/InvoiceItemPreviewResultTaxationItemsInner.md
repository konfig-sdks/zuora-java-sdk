

# InvoiceItemPreviewResultTaxationItemsInner


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**exemptAmount** | **Double** | The calculated tax amount excluded due to the exemption.  |  [optional] |
|**id** | **String** | The ID of the taxation item.  |  [optional] |
|**jurisdiction** | **String** | The jurisdiction that applies the tax or VAT. This value is typically a state, province, county, or city.  |  [optional] |
|**locationCode** | **String** | The identifier for the location based on the value of the taxCode field.  |  [optional] |
|**name** | **String** | The name of the taxation item.  |  [optional] |
|**taxAmount** | **Double** | The amount of the tax applied to the invoice.  |  [optional] |
|**taxCode** | **String** | The tax code identifies which tax rules and tax rates to apply to a specific invoice.  |  [optional] |
|**taxCodeDescription** | **String** | The description of the tax code.  |  [optional] |
|**taxDate** | **String** | The date when the tax is applied to the invoice.  |  [optional] |
|**taxRate** | **Double** | The tax rate applied to the invoice.  |  [optional] |
|**taxRateDescription** | **String** | The description of the tax rate.  |  [optional] |
|**taxRateType** | [**TaxRateTypeEnum**](#TaxRateTypeEnum) | Enum:\&quot;Percentage\&quot; \&quot;FlatFee\&quot;. The type of the tax rate applied to the invoice.  |  [optional] |



## Enum: TaxRateTypeEnum

| Name | Value |
|---- | -----|
| PERCENTAGE | &quot;Percentage&quot; |
| FLATFEE | &quot;FlatFee&quot; |



