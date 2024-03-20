

# CreatePaymentMethodCardholderInfo

Container for cardholder information. The nested `cardHolderName` field is required. 

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**addressLine1** | **String** | First address line, 255 characters or less.  |  [optional] |
|**addressLine2** | **String** | Second address line, 255 characters or less.  |  [optional] |
|**cardHolderName** | **String** | The card holder&#39;s full name as it appears on the card, e.g., \&quot;John J Smith\&quot;, 50 characters or less.  |  |
|**city** | **String** | City, 40 characters or less. It is recommended to provide the city and country information when creating a payment method. The information will be used to process payments. If the information is not provided during payment method creation, the city and country data will be missing during payment processing.  |  [optional] |
|**country** | **String** | Country, must be a valid country name or abbreviation. It is recommended to provide the city and country information when creating a payment method. The information will be used to process payments. If the information is not provided during payment method creation, the city and country data will be missing during payment processing.  |  [optional] |
|**email** | **String** | Card holder&#39;s email address, 80 characters or less.  |  [optional] |
|**phone** | **String** | Phone number, 40 characters or less.  |  [optional] |
|**state** | **String** | State; must be a valid state name or 2-character abbreviation.  |  [optional] |
|**zipCode** | **String** | Zip code, 20 characters or less.  |  [optional] |



