

# Templates


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**content** | **String** | The content of the e-invoice file template, which must be encoded in Base64 format.  |  [optional] |
|**country** | **Boolean** | The short name of a country or region where you must comply with e-invoicing requirements. For example, &#x60;IN&#x60; for India. For the full list of country names and codes, see &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Quick_References/Country%2C_State%2C_and_Province_Codes/A_Country_Names_and_Their_ISO_Codes\&quot; target&#x3D;\&quot;_blank\&quot;&gt;ISO Standard Country Codes&lt;/a&gt;.  |  [optional] |
|**documentType** | [**DocumentTypeEnum**](#DocumentTypeEnum) | The type of billing document for which the e-invoice file template is intended.  |  [optional] |
|**id** | **String** | The unique ID of the e-invoice file template.  |  [optional] |
|**name** | **String** | The name of the e-invoice file template.  |  [optional] |
|**provider** | [**ProviderEnum**](#ProviderEnum) | The name of the e-invoicing service provider that assists in generating e-invoice files for billing documents.   |  [optional] |
|**templateNumber** | **String** | The unique number of the e-invoice file template.  |  [optional] |



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



