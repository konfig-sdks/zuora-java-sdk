

# CreatePaymentMethodBetalingsserviceAllOfAccountHolderInfo

The container for the account holder information. The nested `accountHolderName` field is required. 

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**accountHolderName** | **String** | Required.  The full name of the bank account holder.  |  [optional] |
|**addressLine1** | **String** | The first line of the address for the account holder.  |  [optional] |
|**addressLine2** | **String** | The second line of the address for the account holder.   |  [optional] |
|**city** | **String** | The city where the account holder stays.  It is recommended to provide the city and country information when creating a payment method. The information will be used to process payments. If the information is not provided during payment method creation, the city and country data will be missing during payment processing.  |  [optional] |
|**country** | **String** | The country where the account holder stays.  |  [optional] |
|**email** | **String** | The email address of the account holder.  |  [optional] |
|**firstName** | **String** | The first name of the account holder.  |  [optional] |
|**lastName** | **String** | The last name of the account holder.  |  [optional] |
|**phone** | **String** | The phone number of the account holder.  |  [optional] |
|**state** | **String** | The state where the account holder stays.  |  [optional] |
|**zipCode** | **String** | The zip code for the address of the account holder.  |  [optional] |



