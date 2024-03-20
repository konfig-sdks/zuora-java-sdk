

# CreatePaymentMethodACH


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**type** | [**TypeEnum**](#TypeEnum) | Type of the payment method. The following types of the payment methods are supported:    * &#x60;CreditCard&#x60;    * &#x60;CreditCardReferenceTransaction&#x60;    * &#x60;ACH&#x60;    * &#x60;SEPA&#x60;    * &#x60;Betalingsservice&#x60;    * &#x60;Autogiro&#x60;    * &#x60;Bacs&#x60;    * &#x60;Becs&#x60;    * &#x60;Becsnz&#x60;    * &#x60;PAD&#x60;    * &#x60;PayPalCP&#x60;    * &#x60;PayPalEC&#x60;    * &#x60;PayPalNativeEC&#x60;    * &#x60;PayPalAdaptive&#x60;    * &#x60;AdyenApplePay&#x60;    * &#x60;AdyenGooglePay&#x60;    * &#x60;GooglePay&#x60;   To view the schema and example applicable to a specific payment method type, select the corresponding option from the following list.  |  |
|**addressLine1** | **String** | First address line, 255 characters or less.  |  [optional] |
|**addressLine2** | **String** | Second address line, 255 characters or less.  |  [optional] |
|**bankABACode** | **String** | The nine-digit routing number or ABA number used by banks. This field is only required if the &#x60;type&#x60; field is set to &#x60;ACH&#x60;.  |  |
|**bankAccountName** | **String** | The name of the account holder, which can be either a person or a company. For ACH payment methods on the BlueSnap integration, see [Overview of BlueSnap gateway integration](https://knowledgecenter.zuora.com/Zuora_Billing/Billing_and_Payments/M_Payment_Gateways/Supported_Payment_Gateways/BlueSnap_Gateway/Overview_of_BlueSnap_gateway_integration#Payer_Name_Extraction) for more information about how Zuora splits the string in this field into two parts and passes them to BlueSnap&#39;s &#x60;firstName&#x60; and &#x60;lastName&#x60; fields.  |  |
|**bankAccountNumber** | **String** | The bank account number associated with the ACH payment.  |  |
|**bankAccountType** | [**BankAccountTypeEnum**](#BankAccountTypeEnum) | The type of bank account associated with the ACH payment.  When creating an ACH payment method on Adyen, this field is required by Zuora but it is not required by Adyen. To create the ACH payment method successfully, specify a real value for this field if you can. If it is not possible to get the real value for it, specify any of the allowed values as a dummy value, &#x60;Checking&#x60; preferably.  |  |
|**bankName** | **String** | The name of the bank where the ACH payment account is held.  When creating an ACH payment method on Adyen, this field is required by Zuora but it is not required by Adyen. To create the ACH payment method successfully, specify a real value for this field if you can. If it is not possible to get the real value for it, specify a dummy value.  |  |
|**city** | **String** | City, 40 characters or less.  It is recommended to provide the city and country information when creating a payment method. The information will be used to process payments. If the information is not provided during payment method creation, the city and country data will be missing during payment processing.       |  [optional] |
|**country** | **String** | Country, must be a valid country name or abbreviation.  See [Country Names and Their ISO Standard 2- and 3-Digit Codes](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/D_Country%2C_State%2C_and_Province_Codes/A_Country_Names_and_Their_ISO_Codes) for the list of supported country names and abbreviations.  It is recommended to provide the city and country information when creating a payment method. The information will be used to process payments. If the information is not provided during payment method creation, the city and country data will be missing during payment processing.  |  [optional] |
|**phone** | **String** | Phone number, 40 characters or less.  |  [optional] |
|**state** | **String** | State, must be a valid state name or 2-character abbreviation.  See [United States Standard State Codes](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/D_Country%2C_State%2C_and_Province_Codes/B_State_Names_and_2-Digit_Codes) and [Canadian Standard Province Codes](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/D_Country%2C_State%2C_and_Province_Codes/C_Canadian_Province_Names_and_2-Digit_Codes) for the list of supported names and abbreviations.  |  [optional] |
|**zipCode** | **String** | Zip code, 20 characters or less.  |  [optional] |
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



## Enum: BankAccountTypeEnum

| Name | Value |
|---- | -----|
| BUSINESSCHECKING | &quot;BusinessChecking&quot; |
| CHECKING | &quot;Checking&quot; |
| SAVING | &quot;Saving&quot; |



