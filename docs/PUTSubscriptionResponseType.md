

# PUTSubscriptionResponseType


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**amount** | **Double** | Invoice amount. Preview mode only.  |  [optional] |
|**amountWithoutTax** | **Double** | Invoice amount minus tax. Preview mode only.  |  [optional] |
|**chargeMetrics** | [**PUTSubscriptionResponseTypeChargeMetrics**](PUTSubscriptionResponseTypeChargeMetrics.md) |  |  [optional] |
|**creditMemo** | [**PUTSubscriptionResponseTypeCreditMemo**](PUTSubscriptionResponseTypeCreditMemo.md) |  |  [optional] |
|**creditMemoId** | **String** | The credit memo ID, if a credit memo is generated during the subscription process.  **Note:** This container is only available if you set the Zuora REST API minor version to 207.0 or later [available versions](https://developer.zuora.com/api-references/api/overview/#section/API-Versions/Minor-Version) in the request header, and you have  [Invoice Settlement](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/Invoice_Settlement) enabled. The Invoice Settlement feature is generally available as of Zuora Billing Release 296 (March 2021). This feature includes Unapplied Payments, Credit and Debit Memo, and Invoice Item Settlement. If you want to enable Invoice Settlement, see [Invoice Settlement Enablement and Checklist Guide](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/Invoice_Settlement/Invoice_Settlement_Migration_Checklist_and_Guide) for more information.  |  [optional] |
|**invoice** | [**PUTSubscriptionResponseTypeInvoice**](PUTSubscriptionResponseTypeInvoice.md) |  |  [optional] |
|**invoiceId** | **String** | Invoice ID, if an invoice is generated during the update.  |  [optional] |
|**invoiceItems** | [**List&lt;PUTSubscriptionPreviewInvoiceItemsType&gt;**](PUTSubscriptionPreviewInvoiceItemsType.md) | Container for invoice items.  |  [optional] |
|**invoiceTargetDate** | **LocalDate** | Date through which charges are calculated on the invoice, as yyyy-mm-dd. Preview mode only.  **Note:** This field is only available if you do not specify the Zuora REST API minor version or specify the minor version to 186.0, 187.0, 188.0, 189.0, and 196.0. .  |  [optional] |
|**paidAmount** | **Double** | Payment amount, if a payment is collected  |  [optional] |
|**paymentId** | **String** | Payment ID, if a payment is collected.  |  [optional] |
|**subscriptionId** | **String** | The ID of the resulting new subscription.  |  [optional] |
|**success** | **Boolean** | Returns &#x60;true&#x60; if the request was processed successfully.  |  [optional] |
|**targetDate** | **LocalDate** | Date through which to calculate charges if an invoice is generated, as yyyy-mm-dd. Default is current date.  **Note:** This field is only available if you set the Zuora REST API minor version to 207.0 or later [available versions](https://developer.zuora.com/api-references/api/overview/#section/API-Versions/Minor-Version) in the request header.  |  [optional] |
|**taxAmount** | **Double** | Tax amount on the invoice.  |  [optional] |
|**totalDeltaMrr** | **Double** | Change in the subscription monthly recurring revenue as a result of the update.  |  [optional] |
|**totalDeltaTcv** | **Double** | Change in the total contracted value of the subscription as a result of the update.  |  [optional] |



