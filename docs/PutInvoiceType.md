

# PutInvoiceType


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**autoPay** | **Boolean** | Whether invoices are automatically picked up for processing in the corresponding payment run. By default, invoices are automatically picked up for processing in the corresponding payment run.  |  [optional] |
|**comments** | **String** | Additional information related to the invoice that a Zuora user added to the invoice.  |  [optional] |
|**dueDate** | **LocalDate** | The date by which the payment for this invoice is due.  |  [optional] |
|**invoiceDate** | **LocalDate** | The new invoice date of the invoice. The new invoice date cannot fall in a closed accounting period. You can only specify &#x60;invoiceDate&#x60; or &#x60;dueDate&#x60; in one request. Otherwise, an error occurs.  |  [optional] |
|**invoiceItems** | [**List&lt;PutInvoiceItemType&gt;**](PutInvoiceItemType.md) | Container for invoice items, The maximum number of items is 1,000.  |  [optional] |
|**transferredToAccounting** | [**TransferredToAccountingEnum**](#TransferredToAccountingEnum) | Whether the invoice was transferred to an external accounting system.  |  [optional] |
|**integrationIdNS** | **String** | ID of the corresponding object in NetSuite. Only available if you have installed the [Zuora Connector for NetSuite](https://www.zuora.com/connect/app/?appId&#x3D;265).  |  [optional] |
|**integrationStatusNS** | **String** | Status of the invoice&#39;s synchronization with NetSuite. Only available if you have installed the [Zuora Connector for NetSuite](https://www.zuora.com/connect/app/?appId&#x3D;265).  |  [optional] |
|**syncDateNS** | **String** | Date when the invoice was synchronized with NetSuite. Only available if you have installed the [Zuora Connector for NetSuite](https://www.zuora.com/connect/app/?appId&#x3D;265).  |  [optional] |



## Enum: TransferredToAccountingEnum

| Name | Value |
|---- | -----|
| PROCESSING | &quot;Processing&quot; |
| TRUE | &quot;true&quot; |
| ERROR | &quot;Error&quot; |
| IGNORE | &quot;Ignore&quot; |



