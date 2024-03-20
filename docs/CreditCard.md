

# CreditCard

Default payment method associated with an account. Only credit card payment methods are supported. 

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**cardHolderInfo** | [**AccountCreditCardHolder**](AccountCreditCardHolder.md) |  |  [optional] |
|**cardNumber** | **String** | Card number. Once set, you cannot update or query the value of this field. The value of this field is only available in masked format. For example, XXXX-XXXX-XXXX-1234 (hyphens must not be used when you set the credit card number).  |  [optional] |
|**cardType** | [**CardTypeEnum**](#CardTypeEnum) | Type of card.  |  [optional] |
|**expirationMonth** | **Integer** | Expiration date of the card.  |  [optional] |
|**expirationYear** | **Integer** | Expiration year of the card.  |  [optional] |
|**securityCode** | **String** | CVV or CVV2 security code of the card. To ensure PCI compliance, Zuora does not store the value of this field.  |  [optional] |



## Enum: CardTypeEnum

| Name | Value |
|---- | -----|
| VISA | &quot;Visa&quot; |
| MASTERCARD | &quot;MasterCard&quot; |
| AMERICANEXPRESS | &quot;AmericanExpress&quot; |
| DISCOVER | &quot;Discover&quot; |
| JCB | &quot;JCB&quot; |
| DINERS | &quot;Diners&quot; |
| CUP | &quot;CUP&quot; |
| MAESTRO | &quot;Maestro&quot; |
| ELECTRON | &quot;Electron&quot; |
| APPLEVISA | &quot;AppleVisa&quot; |
| APPLEMASTERCARD | &quot;AppleMasterCard&quot; |
| APPLEAMERICANEXPRESS | &quot;AppleAmericanExpress&quot; |
| APPLEDISCOVER | &quot;AppleDiscover&quot; |
| APPLEJCB | &quot;AppleJCB&quot; |
| ELO | &quot;Elo&quot; |
| HIPERCARD | &quot;Hipercard&quot; |
| NARANJA | &quot;Naranja&quot; |
| NATIVA | &quot;Nativa&quot; |
| TARJETASHOPPING | &quot;TarjetaShopping&quot; |
| CENCOSUD | &quot;Cencosud&quot; |
| ARGENCARD | &quot;Argencard&quot; |
| CABAL | &quot;Cabal&quot; |



