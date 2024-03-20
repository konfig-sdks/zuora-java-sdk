

# GETJournalEntryItemTypeAllOf


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**accountingCodeName** | **String** | Name of the accounting code.  |  [optional] |
|**accountingCodeType** | [**AccountingCodeTypeEnum**](#AccountingCodeTypeEnum) | Accounting code type.  Note that &#x60;On-Account Receivable&#x60; is only available if you enable the Invoice Settlement feature.   |  [optional] |
|**amount** | **BigDecimal** | Journal entry item amount in transaction currency.  |  [optional] |
|**glAccountName** | **String** | The account number in the general ledger (GL) that corresponds to the accounting code.  |  [optional] |
|**glAccountNumber** | **String** | The account name in the general ledger (GL) that corresponds to the accounting code.  |  [optional] |
|**homeCurrencyAmount** | **BigDecimal** | Journal entry item amount in home currency.  |  [optional] |
|**type** | [**TypeEnum**](#TypeEnum) | Type of journal entry item.  |  [optional] |



## Enum: AccountingCodeTypeEnum

| Name | Value |
|---- | -----|
| ACCOUNTSRECEIVABLE | &quot;AccountsReceivable&quot; |
| ON_ACCOUNT_RECEIVABLE | &quot;On-Account Receivable&quot; |
| CASH | &quot;Cash&quot; |
| OTHERASSETS | &quot;OtherAssets&quot; |
| CUSTOMERCASHONACCOUNT | &quot;CustomerCashOnAccount&quot; |
| DEFERREDREVENUE | &quot;DeferredRevenue&quot; |
| SALESTAXPAYABLE | &quot;SalesTaxPayable&quot; |
| OTHERLIABILITIES | &quot;OtherLiabilities&quot; |
| SALESREVENUE | &quot;SalesRevenue&quot; |
| SALESDISCOUNTS | &quot;SalesDiscounts&quot; |
| OTHERREVENUE | &quot;OtherRevenue&quot; |
| OTHEREQUITY | &quot;OtherEquity&quot; |
| BADDEBT | &quot;BadDebt&quot; |
| OTHEREXPENSES | &quot;OtherExpenses&quot; |



## Enum: TypeEnum

| Name | Value |
|---- | -----|
| CREDIT | &quot;Credit&quot; |
| DEBIT | &quot;Debit&quot; |



