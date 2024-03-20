

# POSTAccountTypeCreditCardAllOf


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**cardHolderInfo** | [**Object**](Object.md) | Container for cardholder information.  |  |
|**cardNumber** | **String** | Card number, up to 16 characters. Once created, this field can&#39;t be updated or queried, and is only available in masked format (e.g., XXXX-XXXX-XXXX-1234).  |  |
|**cardType** | **String** | The type of the credit card.  Possible values  include &#x60;Visa&#x60;, &#x60;MasterCard&#x60;, &#x60;AmericanExpress&#x60;, &#x60;Discover&#x60;, &#x60;JCB&#x60;, and &#x60;Diners&#x60;. For more information about credit card types supported by different payment gateways, see [Supported Payment Gateways](https://knowledgecenter.zuora.com/CB_Billing/M_Payment_Gateways/Supported_Payment_Gateways).  |  |
|**expirationMonth** | **String** | Two-digit expiration month (01-12).  |  |
|**expirationYear** | **String** | Four-digit expiration year.  |  |
|**securityCode** | **String** | The CVV or CVV2 security code of the card. To ensure PCI compliance, this value is not stored and cannot be queried.  |  [optional] |



