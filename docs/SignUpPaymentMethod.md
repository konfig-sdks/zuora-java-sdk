

# SignUpPaymentMethod


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**type** | [**TypeEnum**](#TypeEnum) | Type of payment method. The following types of the payment method are supported:  |  |
|**secondTokenId** | **String** | The second token id of CreditCardReferenceTransaction.  |  [optional] |
|**tokenId** | **String** | The token id of payment method, required field of CreditCardReferenceTransaction type.  |  [optional] |
|**BAID** | **String** | ID of a PayPal billing agreement, for example, I-1TJ3GAGG82Y9.  |  [optional] |
|**email** | **String** | Email address associated with the payment method. This field is only supported for PayPal payment methods and is required if you want to create any of the following PayPal payment methods:   - PayPal Express Checkout payment method    - PayPal Adaptive payment method   - PayPal Commerce Platform payment method  |  [optional] |
|**preapprovalKey** | **String** | The PayPal preapproval key.  |  [optional] |
|**cardHolderInfo** | [**SignUpCreatePaymentMethodCardholderInfo**](SignUpCreatePaymentMethodCardholderInfo.md) |  |  [optional] |
|**cardNumber** | **String** | Credit card number.  |  [optional] |
|**cardType** | **String** | The type of the credit card.  Possible values include &#x60;Visa&#x60;, &#x60;MasterCard&#x60;, &#x60;AmericanExpress&#x60;, &#x60;Discover&#x60;, &#x60;JCB&#x60;, and &#x60;Diners&#x60;. For more information about credit card types supported by different payment gateways, see [Supported Payment Gateways](https://knowledgecenter.zuora.com/CB_Billing/M_Payment_Gateways/Supported_Payment_Gateways).  |  [optional] |
|**checkDuplicated** | **Boolean** |  |  [optional] |
|**expirationMonth** | **String** | One or two digit expiration month (1-12) of the credit card.  |  [optional] |
|**expirationYear** | **String** | Four-digit expiration year of the credit card.  |  [optional] |
|**mitConsentAgreementRef** | **String** | Specifies your reference for the stored credential consent agreement that you have established with the customer. Only applicable if you set the &#x60;mitProfileAction&#x60; field.  |  [optional] |
|**mitConsentAgreementSrc** | [**MitConsentAgreementSrcEnum**](#MitConsentAgreementSrcEnum) | Required if you set the &#x60;mitProfileAction&#x60; field. Specifies how the consent agreement has been established with the customer. The allowed value is &#x60;External&#x60;. If you do not specify the &#x60;mitProfileAction&#x60; field, Zuora will automatically create a stored credential profile for the payment method, with the default value &#x60;External&#x60; set to this field.  |  [optional] |
|**mitNetworkTransactionId** | **String** | Specifies the ID of a network transaction. Only applicable if you set the &#x60;mitProfileAction&#x60; field to &#x60;Persist&#x60;.  |  [optional] |
|**mitProfileAction** | [**MitProfileActionEnum**](#MitProfileActionEnum) | Specifies how Zuora creates and activates the stored credential profile. If you do not specify this field, Zuora will automatically create a stored credential profile for the payment method, with the default value &#x60;Activate&#x60; set to this field.  |  [optional] |
|**mitProfileAgreedOn** | **LocalDate** | The date on which the profile is agreed. The date format is &#x60;yyyy-mm-dd&#x60;.  |  [optional] |
|**mitProfileType** | [**MitProfileTypeEnum**](#MitProfileTypeEnum) | Required if you set the &#x60;mitProfileAction&#x60; field. If you do not specify the &#x60;mitProfileAction&#x60; field, Zuora will automatically create a stored credential profile for the payment method, with the default value &#x60;Recurring&#x60; set to this field.  |  [optional] |
|**securityCode** | **String** | CVV or CVV2 security code of the credit card.  To ensure PCI compliance, this value is not stored and cannot be queried.  |  [optional] |
|**accountKey** | **String** | Internal ID of the customer account that will own the payment method.  |  [optional] |
|**authGateway** | **String** | Internal ID of the payment gateway that Zuora will use to authorize the payments that are made with the payment method.  If you do not set this field, Zuora will use one of the following payment gateways instead:  * The default payment gateway of the customer account that owns the payment method, if the &#x60;accountKey&#x60; field is set. * The default payment gateway of your Zuora tenant, if the &#x60;accountKey&#x60; field is not set.  |  [optional] |
|**ipAddress** | **String** | The IPv4 or IPv6 information of the user when the payment method is created or updated. Some gateways use this field for fraud prevention. If this field is passed to Zuora, Zuora directly passes it to gateways.   If the IP address length is beyond 45 characters, a validation error occurs.  |  [optional] |
|**makeDefault** | **Boolean** | Specifies whether the payment method will be the default payment method of the customer account that owns the payment method. Only applicable if the &#x60;accountKey&#x60; field is set.  |  [optional] |



## Enum: TypeEnum

| Name | Value |
|---- | -----|
| PAYPALEC | &quot;PayPalEC&quot; |
| PAYPALNATIVEEC | &quot;PayPalNativeEC&quot; |
| PAYPALADAPTIVE | &quot;PayPalAdaptive&quot; |
| CREDITCARD | &quot;CreditCard&quot; |
| CREDITCARDREFERENCETRANSACTION | &quot;CreditCardReferenceTransaction&quot; |



## Enum: MitConsentAgreementSrcEnum

| Name | Value |
|---- | -----|
| EXTERNAL | &quot;External&quot; |



## Enum: MitProfileActionEnum

| Name | Value |
|---- | -----|
| ACTIVATE | &quot;Activate&quot; |
| PERSIST | &quot;Persist&quot; |



## Enum: MitProfileTypeEnum

| Name | Value |
|---- | -----|
| RECURRING | &quot;Recurring&quot; |



