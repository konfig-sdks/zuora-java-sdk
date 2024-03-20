

# RegenerateBillingRequest


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**documentId** | **String** | Id of Invoice, CreditMemo, DebitMemo, or InvoiceItemAdjustment  |  [optional] |
|**number** | **String** | Number of Invoice, CreditMemo, DebitMemo, or InvoiceItemAdjustment  |  [optional] |
|**type** | [**TypeEnum**](#TypeEnum) | The type of business object for which you want to generate the transactions.  |  [optional] |



## Enum: TypeEnum

| Name | Value |
|---- | -----|
| INVOICE | &quot;Invoice&quot; |
| CREDITMEMO | &quot;CreditMemo&quot; |
| DEBITMEMO | &quot;DebitMemo&quot; |
| INVOICEITEMADJUSTMENT | &quot;InvoiceItemAdjustment&quot; |



