

# POSTJournalEntryItemType


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**accountingCodeName** | **String** | Name of the accounting code.  |  |
|**accountingCodeType** | [**AccountingCodeTypeEnum**](#AccountingCodeTypeEnum) | Accounting code type. This field is required if &#x60;accountingCodeName&#x60; is not unique.  Note that &#x60;On-Account Receivable&#x60; is only available if you enable the Invoice Settlement feature.   |  [optional] |
|**amount** | **BigDecimal** | Journal entry item amount in transaction currency.  |  |
|**homeCurrencyAmount** | **BigDecimal** | Journal entry item amount in home currency.  This field is required if you have set your home currency for foreign currency conversion. Otherwise, do not pass this field.  |  [optional] |
|**type** | [**TypeEnum**](#TypeEnum) | Type of journal entry item.  |  |



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



