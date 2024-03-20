

# CreatePaymentMethodSEPAAllOfTokens

To create tokenized SEPA payment methods on Adyen Integration v2.0, pass in the existing token information through the fields in this container. For more information, see <a href=\"https://knowledgecenter.zuora.com/Zuora_Payments/Payment_gateway_integrations/Supported_payment_gateways/Adyen_Integration_v2.0/D_Tokenize_SEPA_payment_methods_on_Adyen_Integration_v2.0\" target=\"_blank\">Tokenize SEPA payment methods on Adyen Integration v2.0</a>. 

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**gatewayType** | [**GatewayTypeEnum**](#GatewayTypeEnum) | Required.   The type of the payment gateway to generate the tokens. This field is case-sensitive.  |  [optional] |
|**secondTokenId** | **String** | Pass in the second token of the payment method. For more information, see &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Payments/Payment_gateway_integrations/Supported_payment_gateways/Adyen_Integration_v2.0/D_Tokenize_SEPA_payment_methods_on_Adyen_Integration_v2.0\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Tokenize SEPA payment methods on Adyen Integration v2.0&lt;/a&gt;.  |  [optional] |
|**thirdTokenId** | **String** | Pass in the third token of the payment method.  |  [optional] |
|**tokenId** | **String** | Required.   Pass in the first token of the payment method. For more information, see &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Payments/Payment_gateway_integrations/Supported_payment_gateways/Adyen_Integration_v2.0/D_Tokenize_SEPA_payment_methods_on_Adyen_Integration_v2.0\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Tokenize SEPA payment methods on Adyen Integration v2.0&lt;/a&gt;.  |  [optional] |



## Enum: GatewayTypeEnum

| Name | Value |
|---- | -----|
| ADYEN | &quot;Adyen&quot; |



