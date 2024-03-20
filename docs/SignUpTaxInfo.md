

# SignUpTaxInfo

Information about the tax exempt status of a customer account. 

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**vaTId** | **String** | EU Value Added Tax ID.  **Note:** This feature is in Limited Availability. If you wish to have access to the feature, submit a request at [Zuora Global Support](https://support.zuora.com).  |  [optional] |
|**companyCode** | **String** | Unique code that identifies a company account in Avalara. Use this field to calculate taxes based on origin and sold-to addresses in Avalara.  **Note:** This feature is in Limited Availability. If you wish to have access to the feature, submit a request at [Zuora Global Support](https://support.zuora.com).  |  [optional] |
|**exemptCertificateId** | **String** | ID of the customer tax exemption certificate. Applicable if you use Zuora Tax or Connect tax engines.  |  [optional] |
|**exemptCertificateType** | **String** | Type of tax exemption certificate that the customer holds. Applicable if you use Zuora Tax or Connect tax engines.  |  [optional] |
|**exemptDescription** | **String** | Description of the tax exemption certificate that the customer holds. Applicable if you use Zuora Tax or Connect tax engines.  |  [optional] |
|**exemptEffectiveDate** | **LocalDate** | Date when the customer tax exemption starts, in YYYY-MM-DD format. Applicable if you use Zuora Tax or Connect tax engines.  |  [optional] |
|**exemptExpirationDate** | **LocalDate** | Date when the customer tax exemption expires, in YYYY-MM-DD format. Applicable if you use Zuora Tax or Connect tax engines.  |  [optional] |
|**exemptIssuingJurisdiction** | **String** | Jurisdiction in which the customer tax exemption certificate was issued.  |  [optional] |
|**exemptStatus** | [**ExemptStatusEnum**](#ExemptStatusEnum) | Status of the account tax exemption. Applicable if you use Zuora Tax or Connect tax engines. Required if you use Zuora Tax.   |  [optional] |



## Enum: ExemptStatusEnum

| Name | Value |
|---- | -----|
| FALSE | &quot;false&quot; |
| TRUE | &quot;true&quot; |
| PENDINGVERIFICATION | &quot;PendingVerification&quot; |



