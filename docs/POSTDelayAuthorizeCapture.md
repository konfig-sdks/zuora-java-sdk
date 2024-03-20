

# POSTDelayAuthorizeCapture


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**accountId** | **String** | The ID of the customer account. Either &#x60;accountId&#x60; or &#x60;accountNumber&#x60; is required. |  [optional] |
|**accountNumber** | **String** | The number of the customer account. Either &#x60;accountNumber&#x60; or &#x60;accountId&#x60; is required. |  [optional] |
|**amount** | **Double** | The amount of the trasaction. |  |
|**gatewayOptions** | [**PUTVerifyPaymentMethodTypeGatewayOptions**](PUTVerifyPaymentMethodTypeGatewayOptions.md) |  |  [optional] |
|**gatewayOrderId** | **String** | The order ID for the specific gateway.  The specified order ID will be used in transaction authorization. If you specify an empty value for this field, Zuora will generate an ID and you will have to associate this ID with your order ID by yourself if needed. It is recommended to specify an ID for this field.  |  |
|**mitTransactionSource** | [**MitTransactionSourceEnum**](#MitTransactionSourceEnum) | Payment transaction source used to differentiate the transaction source in Stored Credential Transaction framework.   - &#x60;C_Unscheduled&#x60;: Cardholder-initiated transaction (CIT) that does not occur on scheduled or regularly occurring dates.   - &#x60;M_Recurring&#x60;: Merchant-initiated transaction (MIT) that occurs at regular intervals.   - &#x60;M_Unscheduled&#x60;: Merchant-initiated transaction (MIT) that does not occur on scheduled or regularly occurring dates.   - &#x60;M_MOTO&#x60;: Mail Order Telephone Order (MOTO) payment transaction. This option is only available for credit card payments on Stripe v2. See [Overview of Stripe payment gateway integration](https://knowledgecenter.zuora.com/Zuora_Collect/Payment_gateway_integrations/Supported_payment_gateways/Stripe_Payment_Gateway/A_Overview_of_Stripe_payment_gateway_integration) for more information.  |  [optional] |
|**paymentGatewayId** | **String** | The ID of the payment gateway instance. |  [optional] |
|**softDescriptor** | **String** | A text, rendered on a cardholder’s statement, describing a particular product or service purchased by the cardholder. |  [optional] |
|**softDescriptorPhone** | **String** | The phone number that relates to the soft descriptor, usually the phone number of customer service. |  [optional] |



## Enum: MitTransactionSourceEnum

| Name | Value |
|---- | -----|
| C_UNSCHEDULED | &quot;C_Unscheduled&quot; |
| M_RECURRING | &quot;M_Recurring&quot; |
| M_UNSCHEDULED | &quot;M_Unscheduled&quot; |
| M_MOTO | &quot;M_MOTO&quot; |



