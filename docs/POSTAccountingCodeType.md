

# POSTAccountingCodeType


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**glAccountName** | **String** | Name of the account in your general ledger.  Field only available if you have Zuora Finance enabled. Maximum of 255 characters.  |  [optional] |
|**glAccountNumber** | **String** | Account number in your general ledger.  Field only available if you have Zuora Finance enabled. Maximum of 255 characters.  |  [optional] |
|**name** | **String** | Name of the accounting code.  Accounting code name must be unique. Maximum of 100 characters.  |  |
|**notes** | **String** | Maximum of 2,000 characters.  |  [optional] |
|**type** | [**TypeEnum**](#TypeEnum) | If you want to create multiple accounting codes of the type &#x60;AccountsReceivable&#x60;, you need to have [Invoice Item Settlement](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/Invoice_Settlement/C_Invoice_Item_Settlement) enabled and contact [Zuora Global Support](http://support.zuora.com) to access the Multiple AR Accounting Codes feature.   Note that &#x60;On-Account Receivable&#x60; is only available if you enable the Invoice Settlement feature.   |  |



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



