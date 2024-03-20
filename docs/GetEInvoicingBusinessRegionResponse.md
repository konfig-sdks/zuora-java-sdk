

# GetEInvoicingBusinessRegionResponse


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**addressLine1** | **String** | The first line of the Seller’s address, which is often a street address or business name.  |  [optional] |
|**addressLine2** | **String** | The second line of the Seller’s address, which is often the name of a building.  |  [optional] |
|**businessName** | **String** | The full official name that the Seller is registered with the relevant legal authority.  |  [optional] |
|**businessNumber** | **String** | The specify the unique identifier number of the legal entity or person that you do business with.  For example, you must use a GSTIN for India and Tax Identification Number (TIN) for Saudi Arabia.  |  [optional] |
|**businessNumberSchemaId** | **String** | The identification scheme identifier that an official registrar issues to identify the Seller as a legal entity or person.  |  [optional] |
|**businessRegionNumber** | **String** | The unique number of the e-invoicing business region.  |  [optional] |
|**city** | **String** | The the name of the city where the business is located.  |  [optional] |
|**contactName** | **String** | The name of the Seller contact to receive e-invoicing data.  |  [optional] |
|**country** | **String** | The short name of a country or region where you must comply with e-invoicing requirements. For example, &#x60;IN&#x60; for India. For the full list of country names and codes, see &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Quick_References/Country%2C_State%2C_and_Province_Codes/A_Country_Names_and_Their_ISO_Codes\&quot; target&#x3D;\&quot;_blank\&quot;&gt;ISO Standard Country Codes&lt;/a&gt;.  |  [optional] |
|**digitalSignatureEnable** | **Boolean** | Whether the e-invoicing service provider signs PDF files for billing documents.  |  [optional] |
|**digitalSignatureBoxEnable** | **Boolean** | Whether the digital signature box is displayed on PDF files for billing documents.  |  [optional] |
|**digitalSignatureBoxPosX** | **Double** | The X-coordinate to determine where the digital signature box is displayed on PDF files for billing documents.  |  [optional] |
|**digitalSignatureBoxPosY** | **Double** | The Y-coordinate to determine where the digital signature box is displayed on PDF files for billing documents.   |  [optional] |
|**email** | **String** | The email address of the Seller contact to receive e-invoicing data.  |  [optional] |
|**endpointId** | **String** | The Seller&#39;s electronic address, to which the application-level response to the e-invoice file might be delivered.  |  [optional] |
|**endpointSchemeId** | **String** | The identification scheme identifier of the Seller’s electronic address.  |  [optional] |
|**id** | **String** | The unique ID of the e-invoicing business region.  |  [optional] |
|**success** | **Boolean** | Indicats if the request succeeds.  |  [optional] |
|**phoneNumber** | **String** | The business phone number of the Seller contact to receive e-invoicing data.  |  [optional] |
|**postalCode** | **String** | The short code that can identify the business address.  |  [optional] |
|**serviceProviderId** | **String** | The unique ID of the e-invoicing service provider that is associated to the business region.  |  [optional] |
|**state** | **String** | The name of the state or province where the business is located.  |  [optional] |
|**taxRegisterNumber** | **String** | The Seller&#39;s VAT identifier (also known as Seller VAT identification number) or the local identification (defined by the Seller’s address) of the Seller for tax purposes, or a reference that enables the Seller to state the registered tax status.  |  [optional] |
|**tradeName** | **String** | The name that the Seller is known as, other than the legal business name.  |  [optional] |



