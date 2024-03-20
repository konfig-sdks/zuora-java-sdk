

# POSTVoidAuthorize


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**accountId** | **String** | The ID of the customer account. This field is generally required, but is optional if you are using the Ingenico ePayments gateway. |  [optional] |
|**accountNumber** | **String** | The number of the customer account. This field is generally required, but is optional if you are using the Ingenico ePayments gateway. |  [optional] |
|**gatewayOptions** | [**PUTVerifyPaymentMethodTypeGatewayOptions**](PUTVerifyPaymentMethodTypeGatewayOptions.md) |  |  [optional] |
|**gatewayOrderId** | **String** | The order ID for the specific gateway.  The specified order ID will be used in transaction authorization. If you specify an empty value for this field, Zuora will generate an ID and you will have to associate this ID with your order ID by yourself if needed. It is recommended to specify an ID for this field.  |  |
|**paymentGatewayId** | **String** | The ID of the payment gateway instance. This field is required if you do not specify the &#x60;accountId&#x60; and &#x60;accountNumber&#x60; fields. |  [optional] |
|**transactionId** | **String** | The ID of the transaction. |  |



