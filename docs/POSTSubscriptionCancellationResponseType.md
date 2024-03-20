

# POSTSubscriptionCancellationResponseType


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**cancelledDate** | **LocalDate** | The date that the subscription was canceled.   This field is available in the Orders Harmonization tenants and the Subscribe and Amend tenants. This field is not available in the Orders tenants. For more information, see &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Manage_subscription_transactions/Common_subscription_information/AA_Overview_of_Subscriptions\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Identify your tenant type for managing subscriptions&lt;/a&gt;.  |  [optional] |
|**creditMemoId** | **String** | The credit memo ID, if a credit memo is generated during the subscription process.  **Note:** This container is only available if you set the Zuora REST API minor version to 207.0 or later [available versions](https://developer.zuora.com/api-references/api/overview/#section/API-Versions/Minor-Version) in the request header, and you have  [Invoice Settlement](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/Invoice_Settlement) enabled. The Invoice Settlement feature is generally available as of Zuora Billing Release 296 (March 2021). This feature includes Unapplied Payments, Credit and Debit Memo, and Invoice Item Settlement. If you want to enable Invoice Settlement, see [Invoice Settlement Enablement and Checklist Guide](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/Invoice_Settlement/Invoice_Settlement_Migration_Checklist_and_Guide) for more information.  |  [optional] |
|**invoiceId** | **String** | ID of the invoice, if one is generated.  |  [optional] |
|**paidAmount** | **Double** | Amount paid.  |  [optional] |
|**paymentId** | **String** | ID of the payment, if a payment is collected.  |  [optional] |
|**subscriptionId** | **String** | The subscription ID.  |  [optional] |
|**success** | **Boolean** | Returns &#x60;true&#x60; if the request was processed successfully.  |  [optional] |
|**totalDeltaMrr** | **Double** | Change in the subscription monthly recurring revenue as a result of the update.  |  [optional] |
|**totalDeltaTcv** | **Double** | Change in the total contracted value of the subscription as a result of the update.  |  [optional] |



