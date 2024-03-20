

# GETPaymentRunSummaryResponse


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**numberOfCreditBalanceAdjustments** | **Integer** | **Note:** This field is only available if you have the Credit Balance feature enabled.  The number of credit balance adjustments that are successfully processed in the payment run.  |  [optional] |
|**numberOfCreditMemos** | **Integer** | **Note:** This field is only available if you have the Invoice Settlement feature enabled.  The total number of credit memos that are successfully processed in the payment run.  |  [optional] |
|**numberOfDebitMemos** | **Integer** | **Note:** This field is only available if you have the Invoice Settlement feature enabled.  The total number of debit memos that are picked up for processing in the payment run.  |  [optional] |
|**numberOfErrorInputData** | **Integer** | The number of input data that are processed with errors.  |  [optional] |
|**numberOfErrors** | **Integer** | The number of payments with the status of &#x60;Error&#x60; and &#x60;Processing&#x60;.  |  [optional] |
|**numberOfInputData** | **Integer** | The total number of input data.  |  [optional] |
|**numberOfInvoices** | **Integer** | **Note:** This field is only available if you have the Invoice Settlement feature enabled.  The total number of invoices that are picked up for processing in the payment run.  |  [optional] |
|**numberOfPayments** | **Integer** | The number of payments that are successfully processed in the payment run.  |  [optional] |
|**numberOfProcessedInputData** | **Integer** | The number of input data that are successfully processed.  |  [optional] |
|**numberOfReceivables** | **Integer** | The total number of receivables that are picked up for processing in the payment run.  The value of this field is the sum of the value of the &#x60;numberOfInvoices&#x60; field and that of the &#x60;numberOfDebitMemos&#x60; field.  |  [optional] |
|**numberOfUnappliedPayments** | **Integer** | **Note:** This field is only available if you have the Invoice Settlement feature enabled.  The number of unapplied payments that are successfully processed in the payment run.  |  [optional] |
|**numberOfUnprocessedDebitMemos** | **Integer** | **Note:** This field is only available if you have the Invoice Settlement feature enabled.  The number of debit memos with remaining positive balances after the payment run is completed.  |  [optional] |
|**numberOfUnprocessedInvoices** | **Integer** | **Note:** This field is only available if you have the Invoice Settlement feature enabled.  The number of invoices with remaining positive balances after the payment run is completed.  |  [optional] |
|**numberOfUnprocessedReceivables** | **Integer** | The number of receivables with remaining positive balances after the payment run is completed.  |  [optional] |
|**success** | **Boolean** | Returns &#x60;true&#x60; if the request was processed successfully.  |  [optional] |
|**totalValues** | [**List&lt;GETPaymentRunSummaryTotalValues&gt;**](GETPaymentRunSummaryTotalValues.md) | Container for total values.  |  [optional] |



