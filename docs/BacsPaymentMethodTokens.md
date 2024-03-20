

# BacsPaymentMethodTokens

To create tokenized BACS payment methods on Stripe v2, pass in the existing token information through the fields in this container. For more information, see  <a href=\"https://knowledgecenter.zuora.com/Zuora_Payments/Payment_gateway_integrations/Supported_payment_gateways/Stripe_Payment_Gateway/A_Overview_of_Stripe_payment_gateway_integration\" target=\"_blank\">Overview of Stripe payment gateway integration</a>. 

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**gatewayType** | [**GatewayTypeEnum**](#GatewayTypeEnum) | Required.   The type of the payment gateway to generate the tokens. This field is case-sensitive.  |  [optional] |
|**secondTokenId** | **String** | Pass in the second token of the payment method. For more information, see  &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Payments/Payment_gateway_integrations/Supported_payment_gateways/Stripe_Payment_Gateway/A_Overview_of_Stripe_payment_gateway_integration\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Overview of Stripe payment gateway integration&lt;/a&gt;.  |  [optional] |
|**thirdTokenId** | **String** | Pass in the third token of the payment method.  |  [optional] |
|**tokenId** | **String** | Required.   Pass in the first token of the payment method. For more information, see  &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Payments/Payment_gateway_integrations/Supported_payment_gateways/Stripe_Payment_Gateway/A_Overview_of_Stripe_payment_gateway_integration\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Overview of Stripe payment gateway integration&lt;/a&gt;.  |  [optional] |



## Enum: GatewayTypeEnum

| Name | Value |
|---- | -----|
| STRIPE | &quot;Stripe&quot; |



