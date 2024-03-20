

# PutInvoiceResponseType


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**accountId** | **String** | The ID of the customer account associated with the invoice.  |  [optional] |
|**amount** | **Double** | The total amount of the invoice.  |  [optional] |
|**autoPay** | **Boolean** | Whether invoices are automatically picked up for processing in the corresponding payment run.   |  [optional] |
|**balance** | **Double** | The balance of the invoice.  |  [optional] |
|**cancelledById** | **String** | The ID of the Zuora user who cancelled the invoice.  |  [optional] |
|**cancelledOn** | **OffsetDateTime** | The date and time when the invoice was cancelled, in &#x60;yyyy-mm-dd hh:mm:ss&#x60; format.  |  [optional] |
|**comment** | **String** | Comments about the invoice.   |  [optional] |
|**createdById** | **String** | The ID of the Zuora user who created the invoice.  |  [optional] |
|**createdDate** | **OffsetDateTime** | The date and time when the invoice was created, in &#x60;yyyy-mm-dd hh:mm:ss&#x60; format. For example, 2017-03-01 15:31:10.  |  [optional] |
|**creditBalanceAdjustmentAmount** | **Double** | **Note:** This filed is only available if you have the Credit Balance feature enabled and the Invoice Settlement feature disabled. The currency amount of the adjustment applied to the customer&#39;s credit balance.  |  [optional] |
|**currency** | **String** | A currency defined in the web-based UI administrative settings.  |  [optional] |
|**discount** | **Double** | The discount of the invoice.  |  [optional] |
|**dueDate** | **LocalDate** | The date by which the payment for this invoice is due.   |  [optional] |
|**id** | **String** | The unique ID of the invoice.  |  [optional] |
|**invoiceDate** | **LocalDate** | The date on which to generate the invoice.  |  [optional] |
|**number** | **String** | The unique identification number of the invoice.  |  [optional] |
|**postedById** | **String** | The ID of the Zuora user who posted the invoice.  |  [optional] |
|**postedOn** | **OffsetDateTime** | The date and time when the invoice was posted, in &#x60;yyyy-mm-dd hh:mm:ss&#x60; format.   |  [optional] |
|**status** | [**StatusEnum**](#StatusEnum) | The status of the invoice.  |  [optional] |
|**success** | **Boolean** | Returns &#x60;true&#x60; if the request was processed successfully.  |  [optional] |
|**targetDate** | **LocalDate** | The target date for the invoice, in &#x60;yyyy-mm-dd&#x60; format. For example, 2017-07-20.   |  [optional] |
|**taxAmount** | **Double** | The amount of taxation.  |  [optional] |
|**totalTaxExemptAmount** | **Double** | The calculated tax amount excluded due to the exemption.  |  [optional] |
|**transferredToAccounting** | [**TransferredToAccountingEnum**](#TransferredToAccountingEnum) | Whether the invoice was transferred to an external accounting system.  |  [optional] |
|**updatedById** | **String** | The ID of the Zuora user who last updated the invoice.  |  [optional] |
|**updatedDate** | **OffsetDateTime** | The date and time when the invoice was last updated, in &#x60;yyyy-mm-dd hh:mm:ss&#x60; format. For example, 2017-03-02 15:36:10.  |  [optional] |
|**integrationIdNS** | **String** | ID of the corresponding object in NetSuite. Only available if you have installed the [Zuora Connector for NetSuite](https://www.zuora.com/connect/app/?appId&#x3D;265).  |  [optional] |
|**integrationStatusNS** | **String** | Status of the invoice&#39;s synchronization with NetSuite. Only available if you have installed the [Zuora Connector for NetSuite](https://www.zuora.com/connect/app/?appId&#x3D;265).  |  [optional] |
|**syncDateNS** | **String** | Date when the invoice was synchronized with NetSuite. Only available if you have installed the [Zuora Connector for NetSuite](https://www.zuora.com/connect/app/?appId&#x3D;265).  |  [optional] |



## Enum: StatusEnum

| Name | Value |
|---- | -----|
| DRAFT | &quot;Draft&quot; |
| POSTED | &quot;Posted&quot; |
| CANCELED | &quot;Canceled&quot; |
| ERROR | &quot;Error&quot; |



## Enum: TransferredToAccountingEnum

| Name | Value |
|---- | -----|
| PROCESSING | &quot;Processing&quot; |
| TRUE | &quot;true&quot; |
| ERROR | &quot;Error&quot; |
| IGNORE | &quot;Ignore&quot; |



