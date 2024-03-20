

# DebitMemoCollectResponseAllOfProcessedPayment

The information about the payment that newly processed to the debit memo. 

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**amount** | **Double** | The total amount of the payment.  |  [optional] |
|**gatewayId** | **String** | The ID of the gateway instance that processes the payment.  |  [optional] |
|**gatewayResponse** | **String** | The message returned from the payment gateway for the payment. This message is gateway-dependent.  |  [optional] |
|**gatewayResponseCode** | **String** | The code returned from the payment gateway for the payment. This code is gateway-dependent.  |  [optional] |
|**id** | **String** | The unique ID of the created payment. For example, 4028905f5a87c0ff015a87eb6b75007f.  |  [optional] |
|**number** | **String** | The unique identification number of the payment. For example, P-00000001.  |  [optional] |
|**paymentMethodId** | **String** | The unique ID of the payment method that the customer used to make the payment.  |  [optional] |
|**status** | [**StatusEnum**](#StatusEnum) | The status of the payment.  |  [optional] |



## Enum: StatusEnum

| Name | Value |
|---- | -----|
| PROCESSING | &quot;Processing&quot; |
| PROCESSED | &quot;Processed&quot; |
| ERROR | &quot;Error&quot; |
| CANCELED | &quot;Canceled&quot; |



