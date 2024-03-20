

# GETPaymentRunSummaryTotalValues


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**totalValueOfCreditBalance** | **String** | **Note:** This field is only available if you have the Credit Balance feature enabled.  The total amount of credit balance after the payment run is completed.  |  [optional] |
|**totalValueOfCreditMemos** | **String** | **Note:** This field is only available if you have the Invoice Settlement feature enabled.  The total amount of credit memos that are successfully processed in the payment run.  |  [optional] |
|**totalValueOfDebitMemos** | **String** | **Note:** This field is only available if you have the Invoice Settlement feature enabled.  The total amount of debit memos that are picked up for processing in the payment run.  |  [optional] |
|**totalValueOfErrors** | **String** | The total amount of receivables associated with the payments with the status of &#x60;Error&#x60; and &#x60;Processing&#x60;.  |  [optional] |
|**totalValueOfInvoices** | **String** | **Note:** This field is only available if you have the Invoice Settlement feature enabled.  The total amount of invoices that are picked up for processing in the payment run.  |  [optional] |
|**totalValueOfPayments** | **String** | The total amount of payments that are successfully processed in the payment run.  |  [optional] |
|**totalValueOfReceivables** | **String** | The total amount of receivables associated with the payment run.  The value of this field is the sum of the value of the &#x60;totalValueOfInvoices&#x60; field and that of the &#x60;totalValueOfDebitMemos&#x60; field.  |  [optional] |
|**totalValueOfUnappliedPayments** | **Integer** | **Note:** This field is only available if you have the Invoice Settlement feature enabled.  The total amount of unapplied payments that are successfully processed in the payment run.  |  [optional] |
|**totalValueOfUnprocessedDebitMemos** | **String** | **Note:** This field is only available if you have the Invoice Settlement feature enabled.  The total amount of debit memos with remaining positive balances after the payment run is completed.  |  [optional] |
|**totalValueOfUnprocessedInvoices** | **String** | **Note:** This field is only available if you have the Invoice Settlement feature enabled.  The total amount of invoices with remaining positive balances after the payment run is completed.  |  [optional] |
|**totalValueOfUnprocessedReceivables** | **String** | The total amount of receivables with remaining positive balances after the payment run is completed.  |  [optional] |



