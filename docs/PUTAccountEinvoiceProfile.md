

# PUTAccountEinvoiceProfile

Container for profile information for this account.  **Note**: This field is available only if you have the <a href=\"https://knowledgecenter.zuora.com/Zuora_Billing/Bill_your_customers/E-Invoicing\" target=\"_blank\">E-Invoicing</a> feature in **Early Adopter** phase enabled. 

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**businessCategory** | [**BusinessCategoryEnum**](#BusinessCategoryEnum) | The high-level category of the business.  |  [optional] |
|**businessName** | **String** | Legal Business Name. The full formal name by which the Buyer is registered with the relevant legal authority.  |  [optional] |
|**businessNumber** | **String** | Buyer legal registration identifier. An identifier issued by an official registrar that identifies the Buyer as a legal entity or person. GSTIN of buyer for India.  |  [optional] |
|**businessNumberSchemeId** | **String** | Business Number Schema Id. The identification scheme identifier of the Buyer legal registration identifier.  |  [optional] |
|**enabled** | **Boolean** | Enable e-invoice for the account. All invoices generated from this account can be submitted to generate e-invoices when invoices meet the conditions: A business region must be created for the billing country contact, and it must be linked to a service provider. The account must be enabled to generate e-invoices. The invoice must be in the \&quot;Posted\&quot; status.  |  [optional] |
|**endpointId** | **String** | Buyer electronic address.Identifies the Buyer&#39;s electronic address to which the invoice is delivered.  |  [optional] |
|**endpointSchemeId** | **String** | Buyer electronic address identification scheme identifier.  |  [optional] |
|**taxRegisterNumber** | **String** | Buyer VAT identifier. The Buyer&#39;s VAT identifier (also known as Buyer VAT identification number).  |  [optional] |



## Enum: BusinessCategoryEnum

| Name | Value |
|---- | -----|
| B2B | &quot;B2B&quot; |
| B2C | &quot;B2C&quot; |
| B2G | &quot;B2G&quot; |



