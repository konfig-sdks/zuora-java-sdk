

# PUTCreditMemoTypeAllOf


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**autoApplyUponPosting** | **Boolean** | Whether the credit memo automatically applies to the invoice upon posting.  |  [optional] |
|**comment** | **String** | Comments about the credit memo.  |  [optional] |
|**effectiveDate** | **LocalDate** | The date when the credit memo takes effect.  |  [optional] |
|**excludeFromAutoApplyRules** | **Boolean** | Whether the credit memo is excluded from the rule of automatically applying unapplied credit memos to invoices and debit memos during payment runs. If you set this field to &#x60;true&#x60;, a payment run does not pick up this credit memo or apply it to other invoices or debit memos.  |  [optional] |
|**items** | [**List&lt;PUTCreditMemoItemType&gt;**](PUTCreditMemoItemType.md) | Container for credit memo items.  |  [optional] |
|**reasonCode** | **String** | A code identifying the reason for the transaction. The value must be an existing reason code or empty. If you do not specify a value, Zuora uses the default reason code.  |  [optional] |
|**transferredToAccounting** | [**TransferredToAccountingEnum**](#TransferredToAccountingEnum) | Whether the credit memo is transferred to an external accounting system. Use this field for integration with accounting systems, such as NetSuite.   |  [optional] |



## Enum: TransferredToAccountingEnum

| Name | Value |
|---- | -----|
| PROCESSING | &quot;Processing&quot; |
| TRUE | &quot;true&quot; |
| FALSE | &quot;false&quot; |
| ERROR | &quot;Error&quot; |
| IGNORE | &quot;Ignore&quot; |



