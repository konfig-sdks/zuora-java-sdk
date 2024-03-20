

# GETPaymentMethodResponseCreditCardForAccount


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**cardNumber** | **String** | The masked credit card number.  When &#x60;cardNumber&#x60; is &#x60;null&#x60;, the following fields will not be returned:   - &#x60;expirationMonth&#x60;   - &#x60;expirationYear&#x60;   - &#x60;accountHolderInfo&#x60;  |  [optional] |
|**expirationMonth** | **Integer** | One or two digits expiration month (1-12).  |  [optional] |
|**expirationYear** | **Integer** | Four-digit expiration year.  |  [optional] |
|**securityCode** | **String** | The CVV or CVV2 security code for the credit card or debit card.             Only required if changing expirationMonth, expirationYear, or cardHolderName.             To ensure PCI compliance, this value isn&#39;&#39;t stored and can&#39;&#39;t be queried.   |  [optional] |



