

# Transactions

The credit memo apply information. 

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**appliedAmount** | **Double** | The credit memo applied amopunt.  |  [optional] |
|**creditMemoAmount** | **String** | The credit memo amount.  |  [optional] |
|**creditMemoNumber** | **String** | The unique identification number of the credit memo.  |  [optional] |
|**creditMemoStatus** | [**CreditMemoStatusEnum**](#CreditMemoStatusEnum) | The status of the credit memo.   |  [optional] |
|**invoiceNumber** | **String** | The unique identification number of the invoice.  |  [optional] |



## Enum: CreditMemoStatusEnum

| Name | Value |
|---- | -----|
| DRAFT | &quot;Draft&quot; |
| POSTED | &quot;Posted&quot; |
| CANCELED | &quot;Canceled&quot; |
| ERROR | &quot;Error&quot; |
| PENDINGFORTAX | &quot;PendingForTax&quot; |
| GENERATING | &quot;Generating&quot; |
| CANCELINPROGRESS | &quot;CancelInProgress&quot; |



