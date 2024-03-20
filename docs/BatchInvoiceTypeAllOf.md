

# BatchInvoiceTypeAllOf


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**autoPay** | **Boolean** | Whether invoices are automatically picked up for processing in the corresponding payment run.  By default, invoices are automatically picked up for processing in the corresponding payment run.  |  [optional] |
|**comments** | **String** | Additional information related to the invoice that a Zuora user added to the invoice.  |  [optional] |
|**dueDate** | **LocalDate** | The date by which the payment for this invoice is due.  |  [optional] |
|**id** | **String** | The ID of the invoice to be updated.  |  [optional] |
|**invoiceDate** | **LocalDate** | The new invoice date of the invoice. The new invoice date cannot fall in a closed accounting period.  You can only specify &#x60;invoiceDate&#x60; or &#x60;dueDate&#x60; in one request. Otherwise, an error occurs.  |  [optional] |
|**invoiceItems** | [**List&lt;PutInvoiceItemType&gt;**](PutInvoiceItemType.md) | Container for invoice items. The maximum number of items is 1,000.  |  [optional] |
|**transferredToAccounting** | [**TransferredToAccountingEnum**](#TransferredToAccountingEnum) | Whether the invoice was transferred to an external accounting system.  |  [optional] |



## Enum: TransferredToAccountingEnum

| Name | Value |
|---- | -----|
| PROCESSING | &quot;Processing&quot; |
| TRUE | &quot;true&quot; |
| ERROR | &quot;Error&quot; |
| IGNORE | &quot;Ignore&quot; |



