

# PUTPMCreditCardInfo


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**expirationMonth** | **Integer** | One or two digits expiration month (1-12).           |  [optional] |
|**expirationYear** | **Integer** | Four-digit expiration year.  |  [optional] |
|**securityCode** | **String** | Optional. It is the CVV or CVV2 security code specific for the credit card or debit card. To ensure PCI compliance, this value is not stored and cannot be queried.   If securityCode code is not passed in the request payload, this operation only updates related fields in the payload. It does not validate the payment method through the gateway.  If securityCode is passed in the request payload, this operation retrieves the credit card information from payload and validates them through the gateway.  |  [optional] |



