

# BacsPaymentMethod


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**type** | **String** |  |  [optional] |
|**accountHolderInfo** | [**CreatePaymentMethodBetalingsserviceAllOfAccountHolderInfo**](CreatePaymentMethodBetalingsserviceAllOfAccountHolderInfo.md) |  |  [optional] |
|**accountNumber** | **String** | The number of the customer&#39;s bank account.  |  [optional] |
|**accountMaskNumber** | **String** | The masked account number such as ****1234. When creating BACS payment methods on Stripe, if the &#x60;tokens&#x60; field is provided, this &#x60;accountMaskNumber&#x60; field is required. For more information, see  &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Payments/Payment_gateway_integrations/Supported_payment_gateways/Stripe_Payment_Gateway/A_Overview_of_Stripe_payment_gateway_integration\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Overview of Stripe payment gateway integration&lt;/a&gt;.  |  [optional] |
|**bankCode** | **String** | The sort code or number that identifies the bank. This is also known as the sort code.  |  [optional] |
|**mandateInfo** | [**CreatePaymentMethodCreditCardAllOfMandateInfo**](CreatePaymentMethodCreditCardAllOfMandateInfo.md) |  |  [optional] |
|**tokenize** | **Boolean** | When creating a BACS payment method on Adyen v2.0, set this field to &#x60;true&#x60; to support processing BACS recurring payments. For more information about other requirements for processing BACS recurring payments, see &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Payments/Payment_gateway_integrations/Supported_payment_gateways/Adyen_Integration_v2.0/A_Overview_of_Adyen_Integration_v2.0#Direct_Debit_UK_(BACS)\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Overview of Adyen Integration v2.0&lt;/a&gt;.  |  [optional] |
|**tokens** | [**BacsPaymentMethodTokens**](BacsPaymentMethodTokens.md) |  |  [optional] |
|**processingOptions** | [**CreatePaymentMethodCreditCardAllOfProcessingOptions**](CreatePaymentMethodCreditCardAllOfProcessingOptions.md) |  |  [optional] |



