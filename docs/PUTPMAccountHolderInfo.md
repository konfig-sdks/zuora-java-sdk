

# PUTPMAccountHolderInfo

The account holder information. This field is not supported in updating Credit Card Reference Transaction payment methods. 

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**addressLine1** | **String** | The first line of the address for the account holder.  This field is required for SEPA Direct Debit payment methods on Stripe v2 for [certain countries](https://stripe.com/docs/payments/sepa-debit/set-up-payment?platform&#x3D;web#web-submit-payment-method).  |  [optional] |
|**addressLine2** | **String** | The second line of the address for the account holder.   |  [optional] |
|**city** | **String** | The city where the account holder stays.  |  [optional] |
|**country** | **String** | The country where the account holder stays.  This field is required for SEPA payment methods on Stripe v2 for [certain countries](https://stripe.com/docs/payments/sepa-debit/set-up-payment?platform&#x3D;web#web-submit-payment-method).  |  [optional] |
|**email** | **String** | The email address of the account holder.  |  [optional] |
|**phone** | **String** | The phone number of the account holder.  |  [optional] |
|**state** | **String** | The state where the account holder stays.  |  [optional] |
|**zipCode** | **String** | The zip code for the address of the account holder.  |  [optional] |



