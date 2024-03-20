

# CreateEInvoicingServiceProviderRequest


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**companyIdentifier** | **String** | The identifier of the company used to create a sender system ID, which serves to identify the system where the transactions are sent.  |  [optional] |
|**name** | **String** | The name of the e-invoicing service provider.  |  |
|**provider** | [**ProviderEnum**](#ProviderEnum) | The name of the e-invoicing service provider that can help you generate e-invoice files for billing documents.  |  |
|**test** | **Boolean** | Whether the e-invoicing service provider&#39;s configuration is intended for testing.   - If you set this field to &#x60;true&#x60;, requests are directed to the testing integration endpoints. If you set this field to &#x60;false&#x60;, requests are directed to the production integration endpoints.  |  [optional] |



## Enum: ProviderEnum

| Name | Value |
|---- | -----|
| SOVOS | &quot;Sovos&quot; |
| PEPPOL | &quot;PEPPOL&quot; |



