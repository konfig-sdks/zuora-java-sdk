

# CreatePaymentMethodSEPAAllOf


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**type** | **String** |  |  [optional] |
|**IBAN** | **String** | The International Bank Account Number.   This field is required if the &#x60;type&#x60; field is set to &#x60;SEPA&#x60;. However, for creating tokenized SEPA payment methods on Adyen Integration v2.0, this field is optional.    - If the &#x60;tokenize&#x60; field is &#x60;true&#x60;, &#x60;IBAN&#x60; is required.    - If the &#x60;tokens&#x60; field is specified,  &#x60;IBAN&#x60; is not required but &#x60;accountMaskNumber&#x60; is required.  |  [optional] |
|**accountHolderInfo** | [**CreatePaymentMethodSEPAAllOfAccountHolderInfo**](CreatePaymentMethodSEPAAllOfAccountHolderInfo.md) |  |  [optional] |
|**accountMaskNumber** | **String** | The masked account number such as ****1234. When creating SEPA payment methods on Adyen, if the &#x60;tokens&#x60; field is provided, this &#x60;accountMaskNumber&#x60; field is required. For more information, see  &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Payments/Payment_gateway_integrations/Supported_payment_gateways/Adyen_Integration_v2.0/D_Tokenize_SEPA_payment_methods_on_Adyen_Integration_v2.0\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Tokenize SEPA payment methods on Adyen Integration v2.0&lt;/a&gt;  |  [optional] |
|**businessIdentificationCode** | **String** | The BIC code used for SEPA.  |  [optional] |
|**mandateInfo** | [**CreatePaymentMethodCreditCardAllOfMandateInfo**](CreatePaymentMethodCreditCardAllOfMandateInfo.md) |  |  [optional] |
|**tokenize** | **Boolean** | When creating a SEPA payment method on Adyen Integration v2.0, use this field to specify whether to tokenize the payment method with IBAN. If &#x60;tokenize&#x60; is &#x60;true&#x60;, &#x60;IBAN&#x60; is required. If the &#x60;tokens&#x60; field is provided, this &#x60;tokenize&#x60; field is not required. For more information about how to create tokenized SEPA payment methods on Adyen, see &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Payments/Payment_gateway_integrations/Supported_payment_gateways/Adyen_Integration_v2.0/D_Tokenize_SEPA_payment_methods_on_Adyen_Integration_v2.0\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Tokenize SEPA payment methods on Adyen Integration v2.0&lt;/a&gt;.  |  [optional] |
|**tokens** | [**CreatePaymentMethodSEPAAllOfTokens**](CreatePaymentMethodSEPAAllOfTokens.md) |  |  [optional] |
|**processingOptions** | [**CreatePaymentMethodCreditCardAllOfProcessingOptions**](CreatePaymentMethodCreditCardAllOfProcessingOptions.md) |  |  [optional] |



