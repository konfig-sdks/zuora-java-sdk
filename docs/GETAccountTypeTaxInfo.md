

# GETAccountTypeTaxInfo

Container for tax exempt information, used to establish the tax exempt status of a customer account. 

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**vaTId** | **String** | EU Value Added Tax ID.  |  [optional] |
|**companyCode** | **String** | Unique code that identifies a company account in Avalara.  |  [optional] |
|**exemptCertificateId** | **String** | ID of the customer tax exemption certificate.  |  [optional] |
|**exemptCertificateType** | **String** | Type of tax exemption certificate that the customer holds.  |  [optional] |
|**exemptDescription** | **String** | Description of the tax exemption certificate that the customer holds.  |  [optional] |
|**exemptEffectiveDate** | **LocalDate** | Date when the customer tax exemption starts.  |  [optional] |
|**exemptEntityUseCode** | **String** | A unique entity use code to apply exemptions in Avalara AvaTax.  This account-level field is required only when you choose Avalara as your tax engine. See [Exempt Transactions](https://developer.avalara.com/avatax/handling-tax-exempt-customers/)for more details.  |  [optional] |
|**exemptExpirationDate** | **LocalDate** | Date when the customer tax exemption expires.  |  [optional] |
|**exemptIssuingJurisdiction** | **String** | Jurisdiction in which the customer tax exemption certificate was issued.  |  [optional] |
|**exemptStatus** | **String** | Status of the account tax exemption.  |  [optional] |



