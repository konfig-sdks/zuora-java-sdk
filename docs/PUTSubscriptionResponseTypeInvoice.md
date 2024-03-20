

# PUTSubscriptionResponseTypeInvoice

Container for invoices.    **Note:** This field is only available if you set the Zuora REST API minor version to 207.0 or later [available versions](https://developer.zuora.com/api-references/api/overview/#section/API-Versions/Minor-Version) in the request header. Also, the response structure is changed and the following invoice related response fields are moved to this **invoice** container:       * amount    * amountWithoutTax    * taxAmount    * invoiceItems    * targetDate 

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**amount** | **Double** | Invoice amount. |  [optional] |
|**amountWithoutTax** | **Double** | Invoice amount minus tax.  |  [optional] |
|**invoiceItems** | [**List&lt;PUTSubscriptionPreviewInvoiceItemsType&gt;**](PUTSubscriptionPreviewInvoiceItemsType.md) | Container for invoice items.  |  [optional] |
|**targetDate** | **LocalDate** | Date through which to calculate charges if an invoice is generated, as yyyy-mm-dd. Default is current date.  **Note:** This field is only available if you set the Zuora REST API minor version to 207.0 or later [available versions](https://developer.zuora.com/api-references/api/overview/#section/API-Versions/Minor-Version) in the request header.  |  [optional] |
|**taxAmount** | **Double** | The tax amount of the invoice.  |  [optional] |



