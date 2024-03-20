

# PostFulfillmentsResponseType


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**processId** | **String** | The ID of the process that handles the operation.  |  [optional] |
|**reasons** | [**List&lt;CommonResponseReasonsInner&gt;**](CommonResponseReasonsInner.md) |  |  [optional] |
|**requestId** | **UUID** | Unique identifier of the request.  |  [optional] |
|**success** | **Boolean** | Indicates whether the call succeeded.  |  [optional] |
|**creditMemoNumbers** | **List&lt;String&gt;** | An array of the credit memo numbers generated in this request. The credit memo is only available if you have the Invoice Settlement feature enabled.  |  [optional] |
|**fulfillments** | [**List&lt;PostFulfillmentsResponseTypeAllOfFulfillments&gt;**](PostFulfillmentsResponseTypeAllOfFulfillments.md) |  |  [optional] |
|**invoiceNumbers** | **List&lt;String&gt;** | An array of the invoice numbers generated in this request. Normally it includes one invoice number only.  |  [optional] |
|**paidAmount** | **Double** | The total amount collected in this request.  |  [optional] |
|**paymentNumber** | **String** | The payment number collected in this request.  |  [optional] |



