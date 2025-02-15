

# PUTSubscriptionResponseTypeCreditMemo

Container for credit memos.  **Note:** This container is only available if you set the Zuora REST API minor version to 207.0 or later [available versions](https://developer.zuora.com/api-references/api/overview/#section/API-Versions/Minor-Version) in the request header, and you have  [Invoice Settlement](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/Invoice_Settlement) enabled. The Invoice Settlement feature is generally available as of Zuora Billing Release 296 (March 2021). This feature includes Unapplied Payments, Credit and Debit Memo, and Invoice Item Settlement. If you want to enable Invoice Settlement, see [Invoice Settlement Enablement and Checklist Guide](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/Invoice_Settlement/Invoice_Settlement_Migration_Checklist_and_Guide) for more information.  

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**amount** | **Double** | Credit memo amount. |  [optional] |
|**amountWithoutTax** | **Double** | Credit memo amount minus tax. |  [optional] |
|**creditMemoItems** | [**List&lt;POSTSubscriptionPreviewCreditMemoItemsType&gt;**](POSTSubscriptionPreviewCreditMemoItemsType.md) |  |  [optional] |
|**taxAmount** | **Double** | Tax amount on the credit memo. |  [optional] |



