

# ProxyCreateTaxationItem


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**accountingCode** | **String** |  The Chart of Accounts  |  [optional] |
|**exemptAmount** | **Double** |  The calculated tax amount excluded due to the exemption. **Character limit**: 16 **Values**: a decimal value  |  [optional] |
|**invoiceItemId** | **String** |  The ID of the specific invoice item that the taxation information applies to. **Character limit**: 32 **Values**: a valid invoice item ID  |  |
|**jurisdiction** | **String** |  The jurisdiction that applies the tax or VAT. This value is typically a state, province, county, or city. **Character limit**: 32 **Values**: a string of 32 characterrs or fewer  |  |
|**locationCode** | **String** |  The identifier for the location based on the value of the &#x60;TaxCode&#x60; field. **Character limit**: 32 **Values**: automatically generated  |  [optional] |
|**name** | **String** |  The name of the tax rate, such as sales tax or GST. This name is displayed on invoices. **Character limit**: 128 **Values**: a string of 128 characters or fewer  |  |
|**taxAmount** | **Double** |  The amount of the tax applied to the charge. **Character limit**: 16 **Values**: a decimal value  |  |
|**taxCode** | **String** |  The tax code identifies which tax rules and tax rates to apply to a specific charge. **Character limit**: 32 **Values**: a string of 32 characters or fewer  |  [optional] |
|**taxCodeDescription** | **String** |  The description for the tax code. **Character limit**: 255 **Values**: a string of 255 characters or fewer  |  [optional] |
|**taxDate** | **LocalDate** |  The date that the tax is applied to the charge, in &#x60;yyyy-mm-dd&#x60; format. **Character limit**: 29  |  |
|**taxRate** | **Double** |  The tax rate applied to the charge. **Character limit**: 16 **Values**: a valid decimal value  |  |
|**taxRateDescription** | **String** |  The description of the tax rate. **Character limit**: 255 **Values**: a string of 255 characters or fewer  |  [optional] |
|**taxRateType** | **String** |  The type of the tax rate applied to the charge. **Character limit**: 10 **Values**: &#x60;Percentage&#x60;, &#x60;FlatFee&#x60;  |  |



