

# PUTDebitMemoTypeAllOf


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**autoPay** | **Boolean** | Whether debit memos are automatically picked up for processing in the corresponding payment run.   By default, debit memos are automatically picked up for processing in the corresponding payment run.  |  [optional] |
|**comment** | **String** | Comments about the debit memo.  |  [optional] |
|**dueDate** | **LocalDate** | The date by which the payment for the debit memo is due, in &#x60;yyyy-mm-dd&#x60; format.  |  [optional] |
|**effectiveDate** | **LocalDate** | The date when the debit memo takes effect.  |  [optional] |
|**items** | [**List&lt;PUTDebitMemoItemType&gt;**](PUTDebitMemoItemType.md) | Container for debit memo items.  |  [optional] |
|**reasonCode** | **String** | A code identifying the reason for the transaction. The value must be an existing reason code or empty. If you do not specify a value, Zuora uses the default reason code  |  [optional] |
|**transferredToAccounting** | [**TransferredToAccountingEnum**](#TransferredToAccountingEnum) | Whether the debit memo is transferred to an external accounting system. Use this field for integration with accounting systems, such as NetSuite.   |  [optional] |



## Enum: TransferredToAccountingEnum

| Name | Value |
|---- | -----|
| PROCESSING | &quot;Processing&quot; |
| TRUE | &quot;true&quot; |
| FALSE | &quot;false&quot; |
| ERROR | &quot;Error&quot; |
| IGNORE | &quot;Ignore&quot; |



