

# DebitMemoFromChargeRequest


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**accountId** | **String** | The ID of the account associated with the debit memo.  **Note**: When creating debit memos from product rate plan charges, you must specify &#x60;accountNumber&#x60;, &#x60;accountId&#x60;, or both in the request body. If both fields are specified, they must correspond to the same account.  |  [optional] |
|**accountNumber** | **String** | The number of the account associated with the debit memo.  **Note**: When creating debit memos from product rate plan charges, you must specify &#x60;accountNumber&#x60;, &#x60;accountId&#x60;, or both in the request body. If both fields are specified, they must correspond to the same account.  |  [optional] |
|**autoPay** | **Boolean** | Whether debit memos are automatically picked up for processing in the corresponding payment run.   By default, debit memos are automatically picked up for processing in the corresponding payment run.  |  [optional] |
|**autoPost** | **Boolean** | Whether to automatically post the debit memo after it is created.   Setting this field to &#x60;true&#x60;, you do not need to separately call the [Post a debit memo](https://developer.zuora.com/api-references/api/operation/PUT_PostDebitMemo) operation to post the debit memo.  |  [optional] |
|**charges** | [**List&lt;DebitMemoFromChargeDetailType&gt;**](DebitMemoFromChargeDetailType.md) | Container for product rate plan charges. The maximum number of items is 1,000.  |  [optional] |
|**comment** | **String** | Comments about the debit memo.  |  [optional] |
|**currency** | **String** | The code of a currency as defined in Billing Settings through the Zuora UI.  If you do not specify a currency during debit memo creation, the default account currency is applied. The currency that you specify in the request must be configured and activated in Billing Settings. **Note**: This field is available only if you have the &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Bill_your_customers/Flexible_Billing/Multiple_Currencies\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Multiple Currencies&lt;/a&gt; feature enabled.  |  [optional] |
|**customRates** | [**List&lt;DebitMemoFromChargeCustomRatesType&gt;**](DebitMemoFromChargeCustomRatesType.md) | It contains Home currency and Reporting currency custom rates currencies. The maximum number of items is 2 (you can pass the Home currency item or Reporting currency item or both).  **Note**: The API custom rate feature is permission controlled.  |  [optional] |
|**dueDate** | **LocalDate** | The date by which the payment for the debit memo is due, in &#x60;yyyy-mm-dd&#x60; format.  |  [optional] |
|**effectiveDate** | **LocalDate** | The date when the debit memo takes effect.  |  [optional] |
|**reasonCode** | **String** | A code identifying the reason for the transaction. The value must be an existing reason code or empty. If you do not specify a value, Zuora uses the default reason code.  |  [optional] |
|**integrationIdNS** | **String** | ID of the corresponding object in NetSuite. Only available if you have installed the [Zuora Connector for NetSuite](https://www.zuora.com/connect/app/?appId&#x3D;265).  |  [optional] |
|**integrationStatusNS** | **String** | Status of the debit memo&#39;s synchronization with NetSuite. Only available if you have installed the [Zuora Connector for NetSuite](https://www.zuora.com/connect/app/?appId&#x3D;265).  |  [optional] |
|**syncDateNS** | **String** | Date when the debit memo was synchronized with NetSuite. Only available if you have installed the [Zuora Connector for NetSuite](https://www.zuora.com/connect/app/?appId&#x3D;265).  |  [optional] |



