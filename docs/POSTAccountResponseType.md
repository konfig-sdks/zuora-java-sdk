

# POSTAccountResponseType


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**accountId** | **String** | Auto-generated account ID.  |  [optional] |
|**accountNumber** | **String** | Account number.  |  [optional] |
|**billToContactId** | **String** | The ID of the bill-to contact.  |  [optional] |
|**contractedMrr** | **BigDecimal** | Contracted monthly recurring revenue of the subscription.  |  [optional] |
|**creditMemoId** | **String** | The credit memo ID, if a credit memo is generated during the subscription process.  **Note:** This field is only available if you have [Invoice Settlement](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/Invoice_Settlement) enabled. The Invoice Settlement feature is generally available as of Zuora Billing Release 296 (March 2021). This feature includes Unapplied Payments, Credit and Debit Memo, and Invoice Item Settlement. If you want to enable Invoice Settlement, see [Invoice Settlement Enablement and Checklist Guide](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/Invoice_Settlement/Invoice_Settlement_Migration_Checklist_and_Guide) for more information.  |  [optional] |
|**invoiceId** | **String** | ID of the invoice generated at account creation, if applicable.  |  [optional] |
|**paidAmount** | **BigDecimal** | Amount collected on the invoice generated at account creation, if applicable.  |  [optional] |
|**paymentId** | **String** | ID of the payment collected on the invoice generated at account creation, if applicable.  |  [optional] |
|**paymentMethodId** | **String** | ID of the payment method that was set up at account creation, which automatically becomes the default payment method for this account.  |  [optional] |
|**soldToContactId** | **String** | The ID of the sold-to contact.  |  [optional] |
|**subscriptionId** | **String** | ID of the subscription that was set up at account creation, if applicable.  |  [optional] |
|**subscriptionNumber** | **String** | Number of the subscription that was set up at account creation, if applicable.  |  [optional] |
|**success** | **Boolean** | Returns &#x60;true&#x60; if the request was processed successfully.  |  [optional] |
|**totalContractedValue** | **BigDecimal** | Total contracted value of the subscription.  |  [optional] |



