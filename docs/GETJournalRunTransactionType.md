

# GETJournalRunTransactionType


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**type** | [**TypeEnum**](#TypeEnum) | Transaction type. Invoice Adjustment is deprecated on Production. Zuora recommends that you use the Invoice Item Adjustment instead.  If you enable the Invoice Settlement feature, Debit Memo Item, Credit Memo Item, and Credit Memo Application Item are available, Payment and Refund will be replaced by Payment Application and Refund Application.   If you enable both the Invoice Settlement feature and the Invoice Item Settlement feature, Payment and Refund will be replaced by Payment Application Item and Refund Application Item.   |  [optional] |



## Enum: TypeEnum

| Name | Value |
|---- | -----|
| INVOICE_ITEM | &quot;Invoice Item&quot; |
| TAXATION_ITEM | &quot;Taxation Item&quot; |
| INVOICE_ITEM_ADJUSTMENT_INVOICE_ | &quot;Invoice Item Adjustment (Invoice)&quot; |
| INVOICE_ITEM_ADJUSTMENT_TAX_ | &quot;Invoice Item Adjustment (Tax)&quot; |
| INVOICE_ADJUSTMENT | &quot;Invoice Adjustment&quot; |
| ELECTRONIC_PAYMENT | &quot;Electronic Payment&quot; |
| EXTERNAL_PAYMENT | &quot;External Payment&quot; |
| ELECTRONIC_REFUND | &quot;Electronic Refund&quot; |
| EXTERNAL_REFUND | &quot;External Refund&quot; |
| ELECTRONIC_CREDIT_BALANCE_PAYMENT | &quot;Electronic Credit Balance Payment&quot; |
| EXTERNAL_CREDIT_BALANCE_PAYMENT | &quot;External Credit Balance Payment&quot; |
| ELECTRONIC_CREDIT_BALANCE_REFUND | &quot;Electronic Credit Balance Refund&quot; |
| EXTERNAL_CREDIT_BALANCE_REFUND | &quot;External Credit Balance Refund&quot; |
| CREDIT_BALANCE_ADJUSTMENT_APPLIED_FROM_CREDIT_BALANCE_ | &quot;Credit Balance Adjustment (Applied from Credit Balance)&quot; |
| CREDIT_BALANCE_ADJUSTMENT_TRANSFERRED_TO_CREDIT_BALANCE_ | &quot;Credit Balance Adjustment (Transferred to Credit Balance)&quot; |
| REVENUE_EVENT_ITEM | &quot;Revenue Event Item&quot; |
| DEBIT_MEMO_ITEM_CHARGE_ | &quot;Debit Memo Item (Charge)&quot; |
| DEBIT_MEMO_ITEM_TAX_ | &quot;Debit Memo Item (Tax)&quot; |
| CREDIT_MEMO_ITEM_CHARGE_ | &quot;Credit Memo Item (Charge)&quot; |
| CREDIT_MEMO_ITEM_TAX_ | &quot;Credit Memo Item (Tax)&quot; |
| CREDIT_MEMO_APPLICATION_ITEM | &quot;Credit Memo Application Item&quot; |
| ELECTRONIC_PAYMENT_APPLICATION | &quot;Electronic Payment Application&quot; |
| EXTERNAL_PAYMENT_APPLICATION | &quot;External Payment Application&quot; |
| ELECTRONIC_REFUND_APPLICATION | &quot;Electronic Refund Application&quot; |
| EXTERNAL_REFUND_APPLICATION | &quot;External Refund Application&quot; |
| ELECTRONIC_PAYMENT_APPLICATION_ITEM | &quot;Electronic Payment Application Item&quot; |
| EXTERNAL_PAYMENT_APPLICATION_ITEM | &quot;External Payment Application Item&quot; |
| ELECTRONIC_REFUND_APPLICATION_ITEM | &quot;Electronic Refund Application Item&quot; |
| EXTERNAL_REFUND_APPLICATION_ITEM | &quot;External Refund Application Item&quot; |



