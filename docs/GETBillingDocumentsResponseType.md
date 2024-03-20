

# GETBillingDocumentsResponseType


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**accountId** | **UUID** | The ID of the customer account associated with the billing document. |  [optional] |
|**amount** | **Double** | The total amount of the billing document.  |  [optional] |
|**balance** | **Double** | The balance of the billing document.  |  [optional] |
|**documentDate** | **LocalDate** | The date of the billing document. The date can be the invoice date for invoices, credit memo date for credit memos, or debit memo date for debit memos.  |  [optional] |
|**documentNumber** | **String** | The number of the billing document.  |  [optional] |
|**documentType** | [**DocumentTypeEnum**](#DocumentTypeEnum) | The type of the billing document.  |  [optional] |
|**id** | **String** | The ID of the billing document.  |  [optional] |
|**status** | [**StatusEnum**](#StatusEnum) | The current status of the billing document.  |  [optional] |
|**currency** | **String** | The currency of the billing document.  **Note:** By default, the currency on a billing document matches the default currency set on the associated account.  However, Zuora now offers a Multiple Currencies feature to support different currencies for billing documents, allowing flexibility beyond the account-level currency.  For more information, see &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Bill_your_customers/Flexible_Billing/Multiple_Currencies\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Multiple Currency&lt;/a&gt;.  |  [optional] |



## Enum: DocumentTypeEnum

| Name | Value |
|---- | -----|
| INVOICE | &quot;Invoice&quot; |
| CREDITMEMO | &quot;CreditMemo&quot; |
| DEBITMEMO | &quot;DebitMemo&quot; |



## Enum: StatusEnum

| Name | Value |
|---- | -----|
| DRAFT | &quot;Draft&quot; |
| POSTED | &quot;Posted&quot; |
| CANCELED | &quot;Canceled&quot; |
| ERROR | &quot;Error&quot; |



