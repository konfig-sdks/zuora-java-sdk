

# GETTaxationItemType


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**createdById** | **String** | The ID of the Zuora user who created the taxation item.   |  [optional] |
|**createdDate** | **OffsetDateTime** | The date and time when the taxation item was created in the Zuora system, in &#x60;yyyy-mm-dd hh:mm:ss&#x60; format.  |  [optional] |
|**exemptAmount** | **Double** | The calculated tax amount excluded due to the exemption.  |  [optional] |
|**financeInformation** | [**GETCMTaxItemTypeNewAllOfFinanceInformation**](GETCMTaxItemTypeNewAllOfFinanceInformation.md) |  |  [optional] |
|**id** | **String** | The ID of the taxation item.  |  [optional] |
|**jurisdiction** | **String** | The jurisdiction that applies the tax or VAT. This value is typically a state, province, county, or city.  |  [optional] |
|**locationCode** | **String** | The identifier for the location based on the value of the &#x60;taxCode&#x60; field.   |  [optional] |
|**memoItemId** | **String** | The ID of the credit or debit memo associated with the taxation item.  |  [optional] |
|**name** | **String** | The name of the taxation item.  |  [optional] |
|**sourceTaxItemId** | **String** | The ID of the taxation item of the invoice, which the credit or debit memo is created from.  |  [optional] |
|**success** | **Boolean** | Returns &#x60;true&#x60; if the request was processed successfully. |  [optional] |
|**taxAmount** | **Double** | The amount of the tax applied to the credit or debit memo.  |  [optional] |
|**taxCode** | **String** | The tax code identifies which tax rules and tax rates to apply to a specific credit or debit memo.  |  [optional] |
|**taxCodeDescription** | **String** | The description of the tax code.  |  [optional] |
|**taxDate** | **LocalDate** | The date when the tax is applied to the credit or debit memo.  |  [optional] |
|**taxRate** | **Double** | The tax rate applied to the credit or debit memo.  |  [optional] |
|**taxRateDescription** | **String** | The description of the tax rate.  |  [optional] |
|**taxRateType** | [**TaxRateTypeEnum**](#TaxRateTypeEnum) | The type of the tax rate applied to the credit or debit memo.  |  [optional] |
|**updatedById** | **String** | The ID of the Zuora user who last updated the taxation item.  |  [optional] |
|**updatedDate** | **OffsetDateTime** | The date and time when the taxation item was last updated, in &#x60;yyyy-mm-dd hh:mm:ss&#x60; format.   |  [optional] |



## Enum: TaxRateTypeEnum

| Name | Value |
|---- | -----|
| PERCENTAGE | &quot;Percentage&quot; |
| FLATFEE | &quot;FlatFee&quot; |



