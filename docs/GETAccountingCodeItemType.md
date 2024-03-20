

# GETAccountingCodeItemType


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**category** | [**CategoryEnum**](#CategoryEnum) | The category associated with the accounting code.  |  [optional] |
|**createdBy** | **String** | The ID of the user who created the accounting code.  |  [optional] |
|**createdOn** | **OffsetDateTime** | Date and time when the accounting code was created.  |  [optional] |
|**glAccountName** | **String** | Name of the account in your general ledger.  Field only available if you have Zuora Finance enabled.  |  [optional] |
|**glAccountNumber** | **String** | Account number in your general ledger.  Field only available if you have Zuora Finance enabled.  |  [optional] |
|**id** | **String** | ID of the accounting code.  |  [optional] |
|**name** | **String** | Name of the accounting code.  |  [optional] |
|**notes** | **String** | Any optional notes for the accounting code.  |  [optional] |
|**status** | [**StatusEnum**](#StatusEnum) | The accounting code status.  |  [optional] |
|**success** | **Boolean** | Returns &#x60;true&#x60; if the request was processed successfully.  |  [optional] |
|**type** | [**TypeEnum**](#TypeEnum) | Accounting code type.   Note that &#x60;On-Account Receivable&#x60; is only available if you enable the Invoice Settlement feature.   |  [optional] |
|**updatedBy** | **String** | The ID of the user who last updated the accounting code.  |  [optional] |
|**updatedOn** | **OffsetDateTime** | Date and time when the accounting code was last updated.  |  [optional] |



## Enum: CategoryEnum

| Name | Value |
|---- | -----|
| ASSETS | &quot;Assets&quot; |
| LIABILITIES | &quot;Liabilities&quot; |
| EQUITY | &quot;Equity&quot; |
| REVENUE | &quot;Revenue&quot; |
| EXPENSES | &quot;Expenses&quot; |



## Enum: StatusEnum

| Name | Value |
|---- | -----|
| ACTIVE | &quot;Active&quot; |
| INACTIVE | &quot;Inactive&quot; |



## Enum: TypeEnum

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



