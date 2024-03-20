

# AchPaymentMethod


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**type** | **String** |  |  [optional] |
|**addressLine1** | **String** | First address line, 255 characters or less.  |  [optional] |
|**addressLine2** | **String** | Second address line, 255 characters or less.  |  [optional] |
|**bankABACode** | **String** | The nine-digit routing number or ABA number used by banks. This field is only required if the &#x60;type&#x60; field is set to &#x60;ACH&#x60;.  |  [optional] |
|**bankAccountName** | **String** | The name of the account holder, which can be either a person or a company. For ACH payment methods on the BlueSnap integration, see [Overview of BlueSnap gateway integration](https://knowledgecenter.zuora.com/Zuora_Billing/Billing_and_Payments/M_Payment_Gateways/Supported_Payment_Gateways/BlueSnap_Gateway/Overview_of_BlueSnap_gateway_integration#Payer_Name_Extraction) for more information about how Zuora splits the string in this field into two parts and passes them to BlueSnap&#39;s &#x60;firstName&#x60; and &#x60;lastName&#x60; fields.  |  [optional] |
|**bankAccountNumber** | **String** | The bank account number associated with the ACH payment.  |  [optional] |
|**bankAccountType** | [**BankAccountTypeEnum**](#BankAccountTypeEnum) | The type of bank account associated with the ACH payment.  When creating an ACH payment method on Adyen, this field is required by Zuora but it is not required by Adyen. To create the ACH payment method successfully, specify a real value for this field if you can. If it is not possible to get the real value for it, specify any of the allowed values as a dummy value, &#x60;Checking&#x60; preferably.  |  [optional] |
|**bankName** | **String** | The name of the bank where the ACH payment account is held.  When creating an ACH payment method on Adyen, this field is required by Zuora but it is not required by Adyen. To create the ACH payment method successfully, specify a real value for this field if you can. If it is not possible to get the real value for it, specify a dummy value.  |  [optional] |
|**city** | **String** | City, 40 characters or less.  It is recommended to provide the city and country information when creating a payment method. The information will be used to process payments. If the information is not provided during payment method creation, the city and country data will be missing during payment processing.       |  [optional] |
|**country** | **String** | Country, must be a valid country name or abbreviation.  See [Country Names and Their ISO Standard 2- and 3-Digit Codes](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/D_Country%2C_State%2C_and_Province_Codes/A_Country_Names_and_Their_ISO_Codes) for the list of supported country names and abbreviations.  It is recommended to provide the city and country information when creating a payment method. The information will be used to process payments. If the information is not provided during payment method creation, the city and country data will be missing during payment processing.  |  [optional] |
|**phone** | **String** | Phone number, 40 characters or less.  |  [optional] |
|**state** | **String** | State, must be a valid state name or 2-character abbreviation.  See [United States Standard State Codes](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/D_Country%2C_State%2C_and_Province_Codes/B_State_Names_and_2-Digit_Codes) and [Canadian Standard Province Codes](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/D_Country%2C_State%2C_and_Province_Codes/C_Canadian_Province_Names_and_2-Digit_Codes) for the list of supported names and abbreviations.  |  [optional] |
|**zipCode** | **String** | Zip code, 20 characters or less.  |  [optional] |
|**mandateInfo** | [**CreatePaymentMethodCreditCardAllOfMandateInfo**](CreatePaymentMethodCreditCardAllOfMandateInfo.md) |  |  [optional] |
|**processingOptions** | [**CreatePaymentMethodCreditCardAllOfProcessingOptions**](CreatePaymentMethodCreditCardAllOfProcessingOptions.md) |  |  [optional] |



## Enum: BankAccountTypeEnum

| Name | Value |
|---- | -----|
| BUSINESSCHECKING | &quot;BusinessChecking&quot; |
| CHECKING | &quot;Checking&quot; |
| SAVING | &quot;Saving&quot; |



