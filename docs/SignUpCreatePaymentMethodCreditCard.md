

# SignUpCreatePaymentMethodCreditCard


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
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



