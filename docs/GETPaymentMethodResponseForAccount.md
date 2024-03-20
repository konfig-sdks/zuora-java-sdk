

# GETPaymentMethodResponseForAccount


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**accountHolderInfo** | [**GETAccountPMAccountHolderInfo**](GETAccountPMAccountHolderInfo.md) |  |  [optional] |
|**bankIdentificationNumber** | **String** | The first six or eight digits of the payment method&#39;s number, such as the credit card number or account number. Banks use this number to identify a payment method.  |  [optional] |
|**createdBy** | **String** | ID of the user who created this payment method. |  [optional] |
|**createdOn** | **OffsetDateTime** | The date and time when the payment method was created, in &#x60;yyyy-mm-dd hh:mm:ss&#x60; format.  |  [optional] |
|**creditCardMaskNumber** | **String** | The masked credit card number, such as: &#x60;&#x60;&#x60; *********1112 &#x60;&#x60;&#x60; **Note:** This field is only returned for Credit Card Reference Transaction payment type.  |  [optional] |
|**creditCardType** | **String** | The type of the credit card or debit card.  Possible values include &#x60;Visa&#x60;, &#x60;MasterCard&#x60;, &#x60;AmericanExpress&#x60;, &#x60;Discover&#x60;, &#x60;JCB&#x60;, and &#x60;Diners&#x60;. For more information about credit card types supported by different payment gateways, see [Supported Payment Gateways](https://knowledgecenter.zuora.com/CB_Billing/M_Payment_Gateways/Supported_Payment_Gateways).  **Note:** This field is only returned for the Credit Card and Debit Card payment types.  |  [optional] |
|**deviceSessionId** | **String** | The session ID of the user when the &#x60;PaymentMethod&#x60; was created or updated.  |  [optional] |
|**existingMandate** | [**ExistingMandateEnum**](#ExistingMandateEnum) | Indicates whether the mandate is an existing mandate.  |  [optional] |
|**id** | **String** | The payment method ID.  |  [optional] |
|**ipAddress** | **String** | The IP address of the user when the payment method was created or updated.  |  [optional] |
|**isDefault** | **Boolean** | Indicates whether this payment method is the default payment method for the account.  |  [optional] |
|**lastFailedSaleTransactionDate** | **OffsetDateTime** | The date of the last failed attempt to collect payment with this payment method.  |  [optional] |
|**lastTransaction** | **String** | ID of the last transaction of this payment method. |  [optional] |
|**lastTransactionTime** | **OffsetDateTime** | The time when the last transaction of this payment method happened. |  [optional] |
|**mandateInfo** | [**POSTAccountPMMandateInfo**](POSTAccountPMMandateInfo.md) |  |  [optional] |
|**maxConsecutivePaymentFailures** | **Integer** | The number of allowable consecutive failures Zuora attempts with the payment method before stopping.  |  [optional] |
|**numConsecutiveFailures** | **Integer** | The number of consecutive failed payments for this payment method. It is reset to &#x60;0&#x60; upon successful payment.   |  [optional] |
|**paymentRetryWindow** | **Integer** | The retry interval setting, which prevents making a payment attempt if the last failed attempt was within the last specified number of hours.  |  [optional] |
|**secondTokenId** | **String** | A gateway unique identifier that replaces sensitive payment method data.  **Note:** This field is only returned for the Credit Card Reference Transaction payment type.  |  [optional] |
|**status** | [**StatusEnum**](#StatusEnum) | The status of the payment method.  |  [optional] |
|**tokenId** | **String** | A gateway unique identifier that replaces sensitive payment method data or represents a gateway&#39;s unique customer profile.  **Note:** This field is only returned for the Credit Card Reference Transaction payment type.  |  [optional] |
|**totalNumberOfErrorPayments** | **Integer** | The number of error payments that used this payment method.  |  [optional] |
|**totalNumberOfProcessedPayments** | **Integer** | The number of successful payments that used this payment method.  |  [optional] |
|**type** | **String** | The type of the payment method. For example, &#x60;CreditCard&#x60;.  |  [optional] |
|**updatedBy** | **String** | ID of the user who made the last update to this payment method. |  [optional] |
|**updatedOn** | **OffsetDateTime** | The last date and time when the payment method was updated, in &#x60;yyyy-mm-dd hh:mm:ss&#x60; format.  |  [optional] |
|**useDefaultRetryRule** | **Boolean** | Indicates whether this payment method uses the default retry rules configured in the Zuora Payments settings.  |  [optional] |
|**IBAN** | **String** | The International Bank Account Number used to create the SEPA payment method. The value is masked.  |  [optional] |
|**accountNumber** | **String** | The number of the customer&#39;s bank account and it is masked.  |  [optional] |
|**bankCode** | **String** | The sort code or number that identifies the bank. This is also known as the sort code.           |  [optional] |
|**bankTransferType** | **String** | The type of the Bank Transfer payment method. For example, &#x60;SEPA&#x60;.  |  [optional] |
|**branchCode** | **String** | The branch code of the bank used for Direct Debit.  |  [optional] |
|**businessIdentificationCode** | **String** | The BIC code used for SEPA. The value is masked.         |  [optional] |
|**identityNumber** | **String** | The identity number of the account holder or the cardholder.  |  [optional] |
|**bankABACode** | **String** | The nine-digit routing number or ABA number used by banks. This field is only required if the &#x60;type&#x60; field is set to &#x60;ACH&#x60;.  |  [optional] |
|**bankAccountName** | **String** | The name of the account holder, which can be either a person or a company. This field is only required if the &#x60;type&#x60; field is set to &#x60;ACH&#x60;.  |  [optional] |
|**cardNumber** | **String** | The masked credit card number.  When &#x60;cardNumber&#x60; is &#x60;null&#x60;, the following fields will not be returned:   - &#x60;expirationMonth&#x60;   - &#x60;expirationYear&#x60;   - &#x60;accountHolderInfo&#x60;  |  [optional] |
|**expirationMonth** | **Integer** | One or two digits expiration month (1-12).  |  [optional] |
|**expirationYear** | **Integer** | Four-digit expiration year.  |  [optional] |
|**securityCode** | **String** | The CVV or CVV2 security code for the credit card or debit card.             Only required if changing expirationMonth, expirationYear, or cardHolderName.             To ensure PCI compliance, this value isn&#39;&#39;t stored and can&#39;&#39;t be queried.   |  [optional] |
|**BAID** | **String** | ID of a PayPal billing agreement. For example, I-1TJ3GAGG82Y9.  |  [optional] |
|**email** | **String** | Email address associated with the PayPal payment method.   |  [optional] |
|**preapprovalKey** | **String** | The PayPal preapproval key.                  |  [optional] |
|**googleBIN** | **String** | This field is only available for Google Pay payment methods.  |  [optional] |
|**googleCardNumber** | **String** | This field is only available for Google Pay payment methods.  |  [optional] |
|**googleCardType** | **String** | This field is only available for Google Pay payment methods.  For Google Pay payment methods on Adyen, the first 100 characters of [paymentMethodVariant](https://docs.adyen.com/development-resources/paymentmethodvariant) returned from Adyen are stored in this field.  |  [optional] |
|**googleExpiryDate** | **String** | This field is only available for Google Pay payment methods.  |  [optional] |
|**googleGatewayToken** | **String** | This field is only available for Google Pay payment methods.  |  [optional] |
|**appleBIN** | **String** | This field is only available for Apple Pay payment methods.  |  [optional] |
|**appleCardNumber** | **String** | This field is only available for Apple Pay payment methods.  |  [optional] |
|**appleCardType** | **String** | This field is only available for Apple Pay payment methods.  For Apple Pay payment methods on Adyen, the first 100 characters of [paymentMethodVariant](https://docs.adyen.com/development-resources/paymentmethodvariant) returned from Adyen are stored in this field.  |  [optional] |
|**appleExpiryDate** | **String** | This field is only available for Apple Pay payment methods.  |  [optional] |
|**appleGatewayToken** | **String** | This field is only available for Apple Pay payment methods.  |  [optional] |



## Enum: ExistingMandateEnum

| Name | Value |
|---- | -----|
| TRUE | &quot;true&quot; |
| FALSE | &quot;false&quot; |



## Enum: StatusEnum

| Name | Value |
|---- | -----|
| ACTIVE | &quot;Active&quot; |
| CLOSED | &quot;Closed&quot; |
| SCRUBBED | &quot;Scrubbed&quot; |



