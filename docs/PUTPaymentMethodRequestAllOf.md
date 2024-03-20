

# PUTPaymentMethodRequestAllOf


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**accountHolderInfo** | [**PUTPMAccountHolderInfo**](PUTPMAccountHolderInfo.md) |  |  [optional] |
|**accountKey** | **String** | The ID of the customer account associated with this payment method, such as &#x60;2x92c0f859b0480f0159d3a4a6ee5bb6&#x60;.  **Note:** You can use this field to associate an orphan payment method with a customer account. If a payment method is already associated with a customer account, you cannot change the associated payment method through this operation. You cannot remove the previous account ID and leave this field empty, either.  |  [optional] |
|**authGateway** | **String** | Specifies the ID of the payment gateway that Zuora will use to authorize the payments that are made with the payment method.   This field is not supported in updating Credit Card Reference Transaction payment methods.  |  [optional] |
|**currencyCode** | **String** | The currency used for payment method authorization.  |  [optional] |
|**gatewayOptions** | [**PUTPaymentMethodRequestAllOfGatewayOptions**](PUTPaymentMethodRequestAllOfGatewayOptions.md) |  |  [optional] |
|**ipAddress** | **String** | The IPv4 or IPv6 information of the user when the payment method is created or updated. Some gateways use this field for fraud prevention. If this field is passed to Zuora, Zuora directly passes it to gateways.   If the IP address length is beyond 45 characters, a validation error occurs.  For validating SEPA payment methods on Stripe v2, this field is required.  |  [optional] |
|**mandateInfo** | [**PUTPaymentMethodRequestAllOfMandateInfo**](PUTPaymentMethodRequestAllOfMandateInfo.md) |  |  [optional] |
|**processingOptions** | [**PUTPaymentMethodRequestAllOfProcessingOptions**](PUTPaymentMethodRequestAllOfProcessingOptions.md) |  |  [optional] |



