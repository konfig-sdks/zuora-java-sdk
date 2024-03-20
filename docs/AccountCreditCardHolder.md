

# AccountCreditCardHolder

Information about the cardholder of a credit card payment method associated with an account. If you do not provide information about the cardholder, Zuora uses the account's bill-to contact. 

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**addressLine1** | **String** | First line of the cardholder&#39;s address.  |  [optional] |
|**addressLine2** | **String** | Second line of the cardholder&#39;s address.  |  [optional] |
|**cardHolderName** | **String** | Full name of the cardholder as it appears on the card. For example, \&quot;John J Smith\&quot;.  |  [optional] |
|**city** | **String** | City of the cardholder&#39;s address.  It is recommended to provide the city and country information when creating a payment method. The information will be used to process payments. If the information is not provided during payment method creation, the city and country data will be missing during payment processing.  |  [optional] |
|**country** | **String** | Country of the cardholder&#39;s address. The value of this field must be a valid country name or abbreviation.  It is recommended to provide the city and country information when creating a payment method. The information will be used to process payments. If the information is not provided during payment method creation, the city and country data will be missing during payment processing.  |  [optional] |
|**email** | **String** | Email address of the cardholder.  |  [optional] |
|**phone** | **String** | Phone number of the cardholder.  |  [optional] |
|**state** | **String** | State or province of the cardholder&#39;s address.  |  [optional] |
|**zipCode** | **String** | ZIP code or other postal code of the cardholder&#39;s address.  |  [optional] |



