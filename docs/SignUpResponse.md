

# SignUpResponse


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**accountId** | **String** | The account id for the order. |  [optional] |
|**accountNumber** | **String** | The account number for the order. |  [optional] |
|**creditMemoId** | **String** | An array of the credit memo id generated in this order request. The credit memo is only available if you have the Invoice Settlement feature enabled. |  [optional] |
|**creditMemoNumber** | **String** | An array of the credit memo numbers generated in this order request. The credit memo is only available if you have the Invoice Settlement feature enabled. |  [optional] |
|**invoiceId** | **String** | The invoice id generated in this order request |  [optional] |
|**invoiceNumber** | **String** | The invoice number generated in this order request |  [optional] |
|**orderNumber** | **String** | The order number of the order created. |  [optional] |
|**paidAmount** | **String** | The total amount collected in this order request. |  [optional] |
|**paymentId** | **String** | The payment id that is collected in this order request. |  [optional] |
|**paymentNumber** | **String** | The payment number that is collected in this order request. |  [optional] |
|**processId** | **String** | The Id of the process that handles the operation.  |  [optional] |
|**reasons** | [**List&lt;SignUpResponseReasons&gt;**](SignUpResponseReasons.md) |  |  [optional] |
|**status** | [**StatusEnum**](#StatusEnum) | Status of the order. &#x60;Pending&#x60; is only applicable for an order that contains a &#x60;CreateSubscription&#x60; order action. |  [optional] |
|**subscriptionId** | **String** | The subscription id of the order. |  [optional] |
|**subscriptionNumber** | **String** | The subscription number of the order. |  [optional] |
|**success** | **Boolean** | Indicates whether the call succeeded.  |  [optional] |



## Enum: StatusEnum

| Name | Value |
|---- | -----|
| COMPLETED | &quot;Completed&quot; |
| PENDING | &quot;Pending&quot; |



