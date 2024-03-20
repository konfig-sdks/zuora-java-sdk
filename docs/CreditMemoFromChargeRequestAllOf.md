

# CreditMemoFromChargeRequestAllOf


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**accountId** | **String** | The ID of the account associated with the credit memo.  **Note**: When creating credit memos from product rate plan charges, you must specify &#x60;accountNumber&#x60;, &#x60;accountId&#x60;, or both in the request body. If both fields are specified, they must correspond to the same account.  |  [optional] |
|**accountNumber** | **String** | The number of the customer account associated with the credit memo.  **Note**: When creating credit memos from product rate plan charges, you must specify &#x60;accountNumber&#x60;, &#x60;accountId&#x60;, or both in the request body. If both fields are specified, they must correspond to the same account.  |  [optional] |
|**autoPost** | **Boolean** | Whether to automatically post the credit memo after it is created.   Setting this field to &#x60;true&#x60;, you do not need to separately call the [Post a credit memo](https://developer.zuora.com/api-references/api/operation/PUT_PostCreditMemo) operation to post the credit memo.  |  [optional] |
|**charges** | [**List&lt;CreditMemoFromChargeDetailType&gt;**](CreditMemoFromChargeDetailType.md) | Container for product rate plan charges. The maximum number of items is 1,000.  |  [optional] |
|**comment** | **String** | Comments about the credit memo.  |  [optional] |
|**currency** | **String** | The code of a currency as defined in Billing Settings through the Zuora UI.  If you do not specify a currency during credit memo creation, the default account currency is applied. The currency that you specify in the request must be configured and activated in Billing Settings. **Note**: This field is available only if you have the &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Bill_your_customers/Flexible_Billing/Multiple_Currencies\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Multiple Currencies&lt;/a&gt; feature enabled.  |  [optional] |
|**customRates** | [**List&lt;CreditMemoFromChargeCustomRatesType&gt;**](CreditMemoFromChargeCustomRatesType.md) | It contains Home currency and Reporting currency custom rates currencies. The maximum number of items is 2 (you can pass the Home currency item or Reporting currency item or both).  **Note**: The API custom rate feature is permission controlled.  |  [optional] |
|**effectiveDate** | **LocalDate** | The date when the credit memo takes effect.  |  [optional] |
|**excludeFromAutoApplyRules** | **Boolean** | Whether the credit memo is excluded from the rule of automatically applying unapplied credit memos to invoices and debit memos during payment runs. If you set this field to &#x60;true&#x60;, a payment run does not pick up this credit memo or apply it to other invoices or debit memos.  |  [optional] |
|**reasonCode** | **String** | A code identifying the reason for the transaction. The value must be an existing reason code or empty. If you do not specify a value, Zuora uses the default reason code.  |  [optional] |



