

# PostFulfillmentsResponseTypeAllOf


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**creditMemoNumbers** | **List&lt;String&gt;** | An array of the credit memo numbers generated in this request. The credit memo is only available if you have the Invoice Settlement feature enabled.  |  [optional] |
|**fulfillments** | [**List&lt;PostFulfillmentsResponseTypeAllOfFulfillments&gt;**](PostFulfillmentsResponseTypeAllOfFulfillments.md) |  |  [optional] |
|**invoiceNumbers** | **List&lt;String&gt;** | An array of the invoice numbers generated in this request. Normally it includes one invoice number only.  |  [optional] |
|**paidAmount** | **Double** | The total amount collected in this request.  |  [optional] |
|**paymentNumber** | **String** | The payment number collected in this request.  |  [optional] |



