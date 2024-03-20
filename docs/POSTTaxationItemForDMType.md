

# POSTTaxationItemForDMType


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**exemptAmount** | **Double** | The calculated tax amount excluded due to the exemption.  |  [optional] |
|**financeInformation** | [**POSTTaxationItemForDMTypeAllOfFinanceInformation**](POSTTaxationItemForDMTypeAllOfFinanceInformation.md) |  |  [optional] |
|**jurisdiction** | **String** | The jurisdiction that applies the tax or VAT. This value is typically a state, province, county, or city.  |  |
|**locationCode** | **String** | The identifier for the location based on the value of the &#x60;taxCode&#x60; field.  |  [optional] |
|**memoItemId** | **String** | The ID of the debit memo that the taxation item is created for.  |  [optional] |
|**name** | **String** | The name of the taxation item.  |  |
|**sourceTaxItemId** | **String** | The ID of the taxation item of the invoice, which the debit memo is created from.   If you want to use this REST API to create taxation items for a debit memo created from an invoice, the taxation items of the invoice must be created or imported through the SOAP API call.  **Note:**    - This field is only used if the debit memo is created from an invoice.    - If you do not contain this field in the request body, Zuora will automatically set a value for the &#x60;sourceTaxItemId&#x60; field based on the tax location code, tax jurisdiction, and tax rate.  |  [optional] |
|**taxAmount** | **Double** | The amount of the tax applied to the debit memo.  |  |
|**taxCode** | **String** | The tax code identifies which tax rules and tax rates to apply to a specific debit memo.  |  [optional] |
|**taxCodeDescription** | **String** | The description of the tax code.  |  [optional] |
|**taxDate** | **LocalDate** | The date when the tax is applied to the debit memo.  |  [optional] |
|**taxRate** | **Double** | The tax rate applied to the debit memo.  |  |
|**taxRateDescription** | **String** | The description of the tax rate.  |  [optional] |
|**taxRateType** | [**TaxRateTypeEnum**](#TaxRateTypeEnum) | The type of the tax rate applied to the debit memo.  |  |



## Enum: TaxRateTypeEnum

| Name | Value |
|---- | -----|
| PERCENTAGE | &quot;Percentage&quot; |
| FLATFEE | &quot;FlatFee&quot; |



