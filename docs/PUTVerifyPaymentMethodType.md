

# PUTVerifyPaymentMethodType


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**currencyCode** | **String** | The currency used for payment method authorization.   |  [optional] |
|**gatewayOptions** | [**PUTVerifyPaymentMethodTypeGatewayOptions**](PUTVerifyPaymentMethodTypeGatewayOptions.md) |  |  [optional] |
|**paymentGatewayName** | **String** | The name of the payment gateway instance. If no value is specified for this field, the default payment gateway of the customer account will be used.  |  [optional] |
|**securityCode** | **String** | The CVV or CVV2 security code for the credit card or debit card. To ensure PCI compliance, the value of this field is not stored and cannot be queried.  |  [optional] |



