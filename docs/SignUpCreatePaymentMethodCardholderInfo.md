

# SignUpCreatePaymentMethodCardholderInfo

Container for cardholder information. If provided, Zuora will only use this information for this card. Otherwise, Zuora will use the account''s existing bill-to contact information for this card. 

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**addressLine1** | **String** | First address line, 255 characters or less.  |  [optional] |
|**addressLine2** | **String** | Second address line, 255 characters or less.  |  [optional] |
|**cardHolderName** | **String** | The card holder&#39;s full name as it appears on the card, e.g., \&quot;John J Smith\&quot;, 50 characters or less.  |  |
|**city** | **String** | City, 40 characters or less.  |  [optional] |
|**country** | **String** | Country, must be a valid country name or abbreviation.  |  [optional] |
|**email** | **String** | Card holder&#39;s email address, 80 characters or less.  |  [optional] |
|**phone** | **String** | Phone number, 40 characters or less.  |  [optional] |
|**state** | **String** | State; must be a valid state name or 2-character abbreviation.  |  [optional] |
|**zipCode** | **String** | Zip code, 20 characters or less.  |  [optional] |



