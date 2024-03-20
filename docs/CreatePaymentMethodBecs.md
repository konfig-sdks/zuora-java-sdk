

# CreatePaymentMethodBecs


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**type** | [**TypeEnum**](#TypeEnum) | Type of the payment method. The following types of the payment methods are supported:    * &#x60;CreditCard&#x60;    * &#x60;CreditCardReferenceTransaction&#x60;    * &#x60;ACH&#x60;    * &#x60;SEPA&#x60;    * &#x60;Betalingsservice&#x60;    * &#x60;Autogiro&#x60;    * &#x60;Bacs&#x60;    * &#x60;Becs&#x60;    * &#x60;Becsnz&#x60;    * &#x60;PAD&#x60;    * &#x60;PayPalCP&#x60;    * &#x60;PayPalEC&#x60;    * &#x60;PayPalNativeEC&#x60;    * &#x60;PayPalAdaptive&#x60;    * &#x60;AdyenApplePay&#x60;    * &#x60;AdyenGooglePay&#x60;    * &#x60;GooglePay&#x60;   To view the schema and example applicable to a specific payment method type, select the corresponding option from the following list.  |  |
|**accountHolderInfo** | [**CreatePaymentMethodBetalingsserviceAllOfAccountHolderInfo**](CreatePaymentMethodBetalingsserviceAllOfAccountHolderInfo.md) |  |  [optional] |
|**accountNumber** | **String** | The number of the customer&#39;s bank account.  |  |
|**accountMaskNumber** | **String** | The masked account number such as ****1234.  |  [optional] |
|**branchCode** | **String** | The branch code of the bank used for direct debit.  |  |
|**mandateInfo** | [**CreatePaymentMethodCreditCardAllOfMandateInfo**](CreatePaymentMethodCreditCardAllOfMandateInfo.md) |  |  [optional] |
|**processingOptions** | [**CreatePaymentMethodCreditCardAllOfProcessingOptions**](CreatePaymentMethodCreditCardAllOfProcessingOptions.md) |  |  [optional] |
|**accountKey** | **String** | Internal ID of the customer account that will own the payment method.   To create an orphan payment method that is not associated with any customer account, you do not need to specify this field during creation. However, you must associate the orphan payment method with a customer account within 10 days. Otherwise, this orphan payment method will be deleted.  |  [optional] |
|**authGateway** | **String** | Internal ID of the payment gateway that Zuora will use to authorize the payments that are made with the payment method.  If you do not set this field, Zuora will use one of the following payment gateways instead:  * The default payment gateway of the customer account that owns the payment method, if the &#x60;accountKey&#x60; field is set. * The default payment gateway of your Zuora tenant, if the &#x60;accountKey&#x60; field is not set.  |  [optional] |
|**currencyCode** | **String** | The currency used for payment method authorization.  |  [optional] |
|**gatewayOptions** | [**PaymentMethodCommonFieldsGatewayOptions**](PaymentMethodCommonFieldsGatewayOptions.md) |  |  [optional] |
|**ipAddress** | **String** | The IPv4 or IPv6 information of the user when the payment method is created or updated. Some gateways use this field for fraud prevention. If this field is passed to Zuora, Zuora directly passes it to gateways.   If the IP address length is beyond 45 characters, a validation error occurs.  For validating SEPA payment methods on Stripe v2, this field is required.  |  [optional] |
|**makeDefault** | **Boolean** | Specifies whether the payment method will be the default payment method of the customer account that owns the payment method. Only applicable if the &#x60;accountKey&#x60; field is set.  When you set this field to &#x60;true&#x60;, make sure the payment method is supported by the default payment gateway.  |  [optional] |
|**skipValidation** | **Boolean** | Specify whether to skip the validation of the information through the payment gateway. For example, when migrating your payment methods, you can set this field to &#x60;true&#x60; to skip the validation.   |  [optional] |



## Enum: TypeEnum

| Name | Value |
|---- | -----|
| CREDITCARD | &quot;CreditCard&quot; |
| CREDITCARDREFERENCETRANSACTION | &quot;CreditCardReferenceTransaction&quot; |
| ACH | &quot;ACH&quot; |
| SEPA | &quot;SEPA&quot; |
| BETALINGSSERVICE | &quot;Betalingsservice&quot; |
| AUTOGIRO | &quot;Autogiro&quot; |
| BACS | &quot;Bacs&quot; |
| BECS | &quot;Becs&quot; |
| BECSNZ | &quot;Becsnz&quot; |
| PAD | &quot;PAD&quot; |
| PAYPALCP | &quot;PayPalCP&quot; |
| PAYPALEC | &quot;PayPalEC&quot; |
| PAYPALNATIVEEC | &quot;PayPalNativeEC&quot; |
| PAYPALADAPTIVE | &quot;PayPalAdaptive&quot; |
| ADYENAPPLEPAY | &quot;AdyenApplePay&quot; |
| ADYENGOOGLEPAY | &quot;AdyenGooglePay&quot; |
| GOOGLEPAY | &quot;GooglePay&quot; |



