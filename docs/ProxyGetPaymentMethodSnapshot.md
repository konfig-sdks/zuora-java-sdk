

# ProxyGetPaymentMethodSnapshot


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**accountId** | **String** | The ID of the customer account associated with this payment method. |  [optional] |
|**achAbaCode** | **String** | The nine-digit routing number or ABA number used by banks. Applicable to ACH payment methods. |  [optional] |
|**achAccountName** | **String** | The name of the account holder, which can be either a person or a company. Applicable to ACH payment methods. |  [optional] |
|**achAccountNumberMask** | **String** | This is a masked displayable version of the ACH account number, used for security purposes. For example: &#x60;XXXXXXXXX54321&#x60;. |  [optional] |
|**achAccountType** | [**AchAccountTypeEnum**](#AchAccountTypeEnum) | The type of bank account associated with the ACH payment. |  [optional] |
|**achBankName** | **String** | The name of the bank where the ACH payment account is held. |  [optional] |
|**bankBranchCode** | **String** | The branch code of the bank used for direct debit. |  [optional] |
|**bankCheckDigit** | **String** | The check digit in the international bank account number, which confirms the validity of the account. Applicable to direct debit payment methods. |  [optional] |
|**bankCity** | **String** | The city of the direct debit bank. |  [optional] |
|**bankCode** | **String** | The sort code or number that identifies the bank. This is also known as the sort code. |  [optional] |
|**bankIdentificationNumber** | **String** | The first six or eight digits of the payment method&#39;s number, such as the credit card number or account number. Banks use this number to identify a payment method. |  [optional] |
|**bankName** | **String** | The name of the direct debit bank. |  [optional] |
|**bankPostalCode** | **String** | The zip code or postal code of the direct debit bank. |  [optional] |
|**bankStreetName** | **String** | The name of the street of the direct debit bank. |  [optional] |
|**bankStreetNumber** | **String** | The number of the direct debit bank. |  [optional] |
|**bankTransferAccountName** | **String** | The name on the direct debit bank account. |  [optional] |
|**bankTransferAccountNumberMask** | **String** | This is a masked displayable version of the bank account number, used for security purposes. For example: &#x60;XXXXXXXXX54321&#x60;. |  [optional] |
|**bankTransferAccountType** | **String** | The type of the customer&#39;s bank account. Applicable to direct debit payment methods. |  [optional] |
|**bankTransferType** | [**BankTransferTypeEnum**](#BankTransferTypeEnum) | Specifies the type of direct debit transfer. The value of this field is dependent on the country of the user.  Possible Values:    * &#x60;AutomatischIncasso&#x60; (NL)  * &#x60;LastschriftDE&#x60; (Germany)  * &#x60;LastschriftAT&#x60; (Austria)  * &#x60;DemandeDePrelevement&#x60; (FR)  * &#x60;DirectDebitUK&#x60; (UK)  * &#x60;Domicil&#x60; (Belgium)  * &#x60;LastschriftCH&#x60; (CH)  * &#x60;RID&#x60; (Italy)  * &#x60;OrdenDeDomiciliacion&#x60; (Spain) * &#x60;Autogiro&#x60; (Sweden) * &#x60;Betalingsservice&#x60; (Denmark)  |  [optional] |
|**businessIdentificationCode** | **String** | The business identification code for Swiss direct payment methods that use the Global Collect payment gateway. Only applicable to direct debit payments in Switzerland with Global Collect. |  [optional] |
|**city** | **String** | The city of the customer&#39;s address. Applicable to debit payment methods. |  [optional] |
|**companyName** | **String** | The name of the company.  |  [optional] |
|**country** | **String** | The two-letter country code of the customer&#39;s address. Applicable to direct debit payment methods. |  [optional] |
|**creditCardAddress1** | **String** | The first line of the card holder&#39;s address, which is often a street address or business name. Applicable to credit card and direct debit payment methods. |  [optional] |
|**creditCardAddress2** | **String** | The second line of the card holder&#39;s address. Applicable to credit card and direct debit payment methods. |  [optional] |
|**creditCardCity** | **String** | The city of the card holder&#39;s address. Applicable to credit card and direct debit payment methods. |  [optional] |
|**creditCardCountry** | **String** | The country of the card holder&#39;s address. |  [optional] |
|**creditCardExpirationMonth** | **Integer** | The expiration month of the credit card or debit card. Applicable to credit card and direct debit payment methods. |  [optional] |
|**creditCardExpirationYear** | **Integer** | The expiration month of the credit card or debit card. Applicable to credit card and direct debit payment methods. |  [optional] |
|**creditCardHolderName** | **String** | The full name of the card holder. Applicable to credit card and direct debit payment methods. |  [optional] |
|**creditCardMaskNumber** | **String** | A masked version of the credit or debit card number. |  [optional] |
|**creditCardPostalCode** | **String** | The billing address&#39;s zip code. |  [optional] |
|**creditCardState** | **String** | The billing address&#39;s state. Applicable if &#x60;CreditCardCountry&#x60; is either Canada or the US. |  [optional] |
|**creditCardType** | [**CreditCardTypeEnum**](#CreditCardTypeEnum) | The type of credit card or debit card. |  [optional] |
|**deviceSessionId** | **String** | The session ID of the user when the &#x60;PaymentMethod&#x60; was created or updated. |  [optional] |
|**email** | **String** | An email address for the payment method in addition to the bill to contact email address. |  [optional] |
|**existingMandate** | [**ExistingMandateEnum**](#ExistingMandateEnum) | Indicates if the customer has an existing mandate or a new mandate. Only applicable to direct debit payment methods. |  [optional] |
|**firstName** | **String** | The customer&#39;s first name. Only applicable to direct debit payment methods. |  [optional] |
|**IBAN** | **String** | The International Bank Account Number. Only applicable to direct debit payment methods. |  [optional] |
|**ipAddress** | **String** | The IP address of the user when the payment method was created or updated. |  [optional] |
|**id** | **String** | Object identifier. |  [optional] |
|**identityNumber** | **String** | The unique identity number of the customer account.   |  [optional] |
|**isCompany** | **Boolean** | Whether the customer account is a company.  |  [optional] |
|**lastFailedSaleTransactionDate** | **OffsetDateTime** | The date of the last failed attempt to collect payment with this payment method. |  [optional] |
|**lastName** | **String** | The customer&#39;s last name. Only applicable to direct debit payment methods. |  [optional] |
|**lastTransactionDateTime** | **OffsetDateTime** | The date of the most recent transaction. |  [optional] |
|**lastTransactionStatus** | **String** | The status of the most recent transaction. |  [optional] |
|**mandateCreationDate** | **LocalDate** | The date when the mandate was created, in &#x60;yyyy-mm-dd&#x60; format. A mandate is a signed authorization for UK and NL customers. Only applicable to direct debit payment methods. |  [optional] |
|**mandateID** | **String** | The ID of the mandate. A mandate is a signed authorization for UK and NL customers. Only applicable to direct debit payment methods. |  [optional] |
|**mandateReceived** | **String** | Indicates if  the mandate was received. A mandate is a signed authorization for UK and NL customers. Only applicable to direct debit payment methods. |  [optional] |
|**mandateUpdateDate** | **LocalDate** | The date when the mandate was last updated, in &#x60;yyyy-mm-dd&#x60; format. A mandate is a signed authorization for UK and NL customers. Only applicable to direct debit payment methods. |  [optional] |
|**maxConsecutivePaymentFailures** | **Integer** | The number of allowable consecutive failures Zuora attempts with the payment method before stopping. |  [optional] |
|**name** | **String** | The name of the payment method. |  [optional] |
|**numConsecutiveFailures** | **Integer** | The number of consecutive failed payment for the payment method. |  [optional] |
|**paymentMethodId** | **String** | Object identifier of the payment method. |  [optional] |
|**paymentMethodStatus** | [**PaymentMethodStatusEnum**](#PaymentMethodStatusEnum) | Specifies the status of the payment method. |  [optional] |
|**paymentRetryWindow** | **Integer** | The retry interval setting, which prevents making a payment attempt if the last failed attempt was within the last specified number of hours. |  [optional] |
|**paypalBaid** | **String** | The PayPal billing agreement ID, which is a contract between two PayPal accounts. |  [optional] |
|**paypalEmail** | **String** | The email address associated with the account holder&#39;s PayPal account or of the PayPal account of the person paying for the service. |  [optional] |
|**paypalPreapprovalKey** | **String** | PayPal&#39;s Adaptive Payments API key. |  [optional] |
|**paypalType** | [**PaypalTypeEnum**](#PaypalTypeEnum) | Specifies the PayPal gateway: PayFlow Pro (Express Checkout) or Adaptive Payments. |  [optional] |
|**phone** | **String** | The phone number that the account holder registered with the bank. This field is used for credit card validation when passing to a gateway. |  [optional] |
|**postalCode** | **String** | The zip code of the customer&#39;s address. Only applicable to direct debit payment methods. |  [optional] |
|**secondTokenId** | **String** | A gateway unique identifier that replaces sensitive payment method data. Applicable to CC Reference Transaction payment methods. |  [optional] |
|**state** | **String** | The state of the customer&#39;s address. Only applicable to direct debit payment methods. |  [optional] |
|**streetName** | **String** | The street name of the customer&#39;s address. Only applicable to direct debit payment methods. |  [optional] |
|**streetNumber** | **String** | The street number of the customer&#39;s address. Only applicable to direct debit payment methods. |  [optional] |
|**tokenId** | **String** | A gateway unique identifier that replaces sensitive payment method data or represents a gateway&#39;s unique customer profile. Applicable to CC Reference Transaction payment methods. |  [optional] |
|**totalNumberOfErrorPayments** | **Integer** | The number of error payments that used this payment method. |  [optional] |
|**totalNumberOfProcessedPayments** | **Integer** | The number of successful payments that used this payment method. |  [optional] |
|**type** | [**TypeEnum**](#TypeEnum) | The type of payment method. |  [optional] |
|**useDefaultRetryRule** | **Boolean** | Determines whether to use the default retry rules configured in the Zuora Payments settings. |  [optional] |



## Enum: AchAccountTypeEnum

| Name | Value |
|---- | -----|
| BUSINESSCHECKING | &quot;BusinessChecking&quot; |
| CHECKING | &quot;Checking&quot; |
| SAVING | &quot;Saving&quot; |



## Enum: BankTransferTypeEnum

| Name | Value |
|---- | -----|
| AUTOMATISCHINCASSO | &quot;AutomatischIncasso&quot; |
| LASTSCHRIFTDE | &quot;LastschriftDE&quot; |
| LASTSCHRIFTAT | &quot;LastschriftAT&quot; |
| DEMANDEDEPRELEVEMENT | &quot;DemandeDePrelevement&quot; |
| DIRECTDEBITUK | &quot;DirectDebitUK&quot; |
| DOMICIL | &quot;Domicil&quot; |
| LASTSCHRIFTCH | &quot;LastschriftCH&quot; |
| RID | &quot;RID&quot; |
| ORDENDEDOMICILIACION | &quot;OrdenDeDomiciliacion&quot; |
| AUTOGIRO | &quot;Autogiro&quot; |
| BETALINGSSERVICE | &quot;Betalingsservice&quot; |



## Enum: CreditCardTypeEnum

| Name | Value |
|---- | -----|
| AMERICANEXPRESS | &quot;AmericanExpress&quot; |
| DISCOVER | &quot;Discover&quot; |
| MASTERCARD | &quot;MasterCard&quot; |
| VISA | &quot;Visa&quot; |



## Enum: ExistingMandateEnum

| Name | Value |
|---- | -----|
| TRUE | &quot;true&quot; |
| FALSE | &quot;false&quot; |



## Enum: PaymentMethodStatusEnum

| Name | Value |
|---- | -----|
| ACTIVE | &quot;Active&quot; |
| CLOSED | &quot;Closed&quot; |



## Enum: PaypalTypeEnum

| Name | Value |
|---- | -----|
| EXPRESSCHECKOUT | &quot;ExpressCheckout&quot; |
| ADAPTIVEPAYMENTS | &quot;AdaptivePayments&quot; |



## Enum: TypeEnum

| Name | Value |
|---- | -----|
| ACH | &quot;ACH&quot; |
| APPLEPAY | &quot;ApplePay&quot; |
| BANKTRANSFER | &quot;BankTransfer&quot; |
| CASH | &quot;Cash&quot; |
| CHECK | &quot;Check&quot; |
| CREDITCARD | &quot;CreditCard&quot; |
| CREDITCARDREFERENCETRANSACTION | &quot;CreditCardReferenceTransaction&quot; |
| DEBITCARD | &quot;DebitCard&quot; |
| OTHER | &quot;Other&quot; |
| PAYPAL | &quot;PayPal&quot; |
| WIRETRANSFER | &quot;WireTransfer&quot; |



