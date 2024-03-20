

# PostAccountEInvoiceProfileAllOf


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**businessCategory** | [**BusinessCategoryEnum**](#BusinessCategoryEnum) | The high-level category of the business.  |  [optional] |
|**businessName** | **String** | The full official name that the Buyer is registered with the relevant legal authority.  |  [optional] |
|**businessNumber** | **String** | The unique identifier number of the legal entity or person that you do business with.  For example, you must use a GSTIN for India.  |  [optional] |
|**businessNumberSchemeId** | **String** | The identification scheme identifier that an official registrar issues to identify the Buyer as a legal entity or person.  |  [optional] |
|**enabled** | **Boolean** | Whether to enable the e-invoicing profile for the customer account.  If the following conditions are met, all billing documents for one account can be submitted to an e-invoicing service provider to be generated in electronic format: - The account must be configured to generate e-invoice files for billing documents. - The billing document must be in Posted status. - A business region must be created for the billing country contact, and be linked to an e-invoicing service provider.  |  [optional] |
|**endpointId** | **String** | The Buyer&#39;s electronic address, to which the application-level response to the billing document might be delivered.  |  [optional] |
|**endpointSchemeId** | **String** | The identification scheme identifier of the Buyer’s electronic address.  |  [optional] |
|**taxRegisterNumber** | **String** | The Buyer&#39;s VAT identifier (also known as the Buyer&#39;s VAT identification number) or the local identification (defined by the Buyer’s address) of the Buyer for tax purposes, or a reference that enables the Buyer to state the registered tax status.  |  [optional] |



## Enum: BusinessCategoryEnum

| Name | Value |
|---- | -----|
| B2B | &quot;B2B&quot; |
| B2C | &quot;B2C&quot; |
| B2G | &quot;B2G&quot; |



