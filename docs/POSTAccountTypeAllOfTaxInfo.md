

# POSTAccountTypeAllOfTaxInfo

Container for tax exempt information, used to establish the tax exempt status of a customer account. 

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**vaTId** | **String** | EU Value Added Tax ID.   **Note:** This feature is in Limited Availability. If you wish to have access to the feature, submit a request at [Zuora Global Support](https://support.zuora.com).  |  [optional] |
|**companyCode** | **String** | Unique code that identifies a company account in Avalara. Use this field to calculate taxes based on origin and sold-to addresses in Avalara.  **Note:** This feature is in Limited Availability. If you wish to have access to the feature, submit a request at [Zuora Global Support](https://support.zuora.com).   |  [optional] |
|**exemptCertificateId** | **String** | ID of the customer tax exemption certificate. Requires Zuora Tax.  |  [optional] |
|**exemptCertificateType** | **String** | Type of tax exemption certificate that the customer holds. Requires Zuora Tax.  |  [optional] |
|**exemptDescription** | **String** | Description of the tax exemption certificate that the customer holds. Requires Zuora Tax.  |  [optional] |
|**exemptEffectiveDate** | **LocalDate** | Date when the customer tax exemption starts. Requires Zuora Tax.  Format: &#x60;yyyy-mm-dd&#x60;. Defaults to the current date.  |  [optional] |
|**exemptEntityUseCode** | **String** | A unique entity use code to apply exemptions in Avalara AvaTax.  This account-level field is required only when you choose Avalara as your tax engine. See [Exempt Transactions](https://developer.avalara.com/avatax/handling-tax-exempt-customers/)for more details.  |  [optional] |
|**exemptExpirationDate** | **LocalDate** | Date when the customer tax exemption expires. Requires Zuora Tax.  Format: &#x60;yyyy-mm-dd&#x60;. Defaults to the current date.  |  [optional] |
|**exemptIssuingJurisdiction** | **String** | Jurisdiction in which the customer tax exemption certificate was issued.  |  [optional] |
|**exemptStatus** | **String** | Status of the account tax exemption. Requires Zuora Tax.  Required if you use Zuora Tax. This field is unavailable if Zuora Tax is not used.  Values: &#x60;Yes&#x60;, &#x60;No&#x60;(default), &#x60;pendingVerification&#x60;. Note that the value will be set to &#x60;No&#x60; if no input.  |  [optional] |



