

# POSTSubscriptionPreviewResponseType


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**amount** | **Double** | Invoice amount.  |  [optional] |
|**amountWithoutTax** | **Double** | Invoice amount minus tax.  |  [optional] |
|**chargeMetrics** | [**POSTSubscriptionPreviewResponseTypeChargeMetrics**](POSTSubscriptionPreviewResponseTypeChargeMetrics.md) |  |  [optional] |
|**contractedMrr** | **Double** | Monthly recurring revenue of the subscription.  |  [optional] |
|**creditMemo** | [**POSTSubscriptionPreviewResponseTypeCreditMemo**](POSTSubscriptionPreviewResponseTypeCreditMemo.md) |  |  [optional] |
|**documentDate** | **LocalDate** | The date of the billing document, in &#x60;yyyy-mm-dd&#x60; format. It represents the invoice date for invoices, credit memo date for credit memos, and debit memo date for debit memos.  - If this field is specified, the specified date is used as the billing document date.  - If this field is not specified, the date specified in the &#x60;targetDate&#x60; is used as the billing document date.  |  [optional] |
|**invoice** | [**POSTSubscriptionPreviewResponseTypeInvoice**](POSTSubscriptionPreviewResponseTypeInvoice.md) |  |  [optional] |
|**invoiceItems** | [**List&lt;POSTSubscriptionPreviewInvoiceItemsType&gt;**](POSTSubscriptionPreviewInvoiceItemsType.md) | Container for invoice items.  |  [optional] |
|**invoiceTargetDate** | **LocalDate** | Date through which charges are calculated on the invoice, as yyyy-mm-dd.  **Note:** This field is only available if you do not specify the Zuora REST API minor version or specify the minor version to 186.0, 187.0, 188.0, 189.0, 196.0, and 206.0.  |  [optional] |
|**success** | **Boolean** | Returns &#x60;true&#x60; if the request was processed successfully.  |  [optional] |
|**targetDate** | **LocalDate** | Date through which to calculate charges if an invoice is generated, as yyyy-mm-dd. Default is current date.  **Note:** This field is only available if you set the Zuora REST API minor version to 207.0 or later [available versions](https://developer.zuora.com/api-references/api/overview/#section/API-Versions/Minor-Version) in the request header.  |  [optional] |
|**taxAmount** | **Double** | Tax amount on the invoice.  |  [optional] |
|**totalContractedValue** | **Double** | Total contracted value of the subscription.  |  [optional] |



