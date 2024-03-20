

# CreateEInvoiceFileTemplateRequestAllOf


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**content** | **String** | The content of the e-invoice file template, which must be encoded in Base64 format.  |  |
|**country** | **String** | The short name of of a country or region where you must comply with e-invoicing requirements. For example, &#x60;IN&#x60; for India. For the full list of country names and codes, see &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Quick_References/Country%2C_State%2C_and_Province_Codes/A_Country_Names_and_Their_ISO_Codes\&quot; target&#x3D;\&quot;_blank\&quot;&gt;ISO Standard Country Codes&lt;/a&gt;.  |  |
|**documentType** | [**DocumentTypeEnum**](#DocumentTypeEnum) | The type of billing documents, which the e-invoice file template is intended for.  |  |
|**name** | **String** | The name of the e-invoice file template.  |  |
|**provider** | [**ProviderEnum**](#ProviderEnum) | The name of an e-invoicing service provider that assists in generating e-invoice files.  |  |



## Enum: DocumentTypeEnum

| Name | Value |
|---- | -----|
| INVOICE | &quot;Invoice&quot; |
| CREDITMEMO | &quot;CreditMemo&quot; |
| DEBITMEMO | &quot;DebitMemo&quot; |



## Enum: ProviderEnum

| Name | Value |
|---- | -----|
| SOVOS | &quot;Sovos&quot; |



