

# GETPaymentMethodResponseACH


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**bankABACode** | **String** | The nine-digit routing number or ABA number used by banks. This field is only required if the &#x60;type&#x60; field is set to &#x60;ACH&#x60;.  |  [optional] |
|**bankAccountName** | **String** | The name of the account holder, which can be either a person or a company. This field is only required if the &#x60;type&#x60; field is set to &#x60;ACH&#x60;.  |  [optional] |
|**bankAccountNumber** | **String** | The bank account number associated with the ACH payment. This field is only required if the &#x60;type&#x60; field is set to &#x60;ACH&#x60;.  |  [optional] |
|**bankAccountType** | [**BankAccountTypeEnum**](#BankAccountTypeEnum) | The type of bank account associated with the ACH payment. This field is only required if the &#x60;type&#x60; field is set to &#x60;ACH&#x60;.  When creating an ACH payment method on Adyen, this field is required by Zuora but it is not required by Adyen. To create the ACH payment method successfully, specify a real value for this field if you can. If it is not possible to get the real value for it, specify any of the allowed values as a dummy value, &#x60;Checking&#x60; preferably.  |  [optional] |
|**bankName** | **String** | The name of the bank where the ACH payment account is held. This field is only required if the &#x60;type&#x60; field is set to &#x60;ACH&#x60;.  When creating an ACH payment method on Adyen, this field is required by Zuora but it is not required by Adyen. To create the ACH payment method successfully, specify a real value for this field if you can. If it is not possible to get the real value for it, specify a dummy value.  |  [optional] |



## Enum: BankAccountTypeEnum

| Name | Value |
|---- | -----|
| BUSINESSCHECKING | &quot;BusinessChecking&quot; |
| CHECKING | &quot;Checking&quot; |
| SAVING | &quot;Saving&quot; |



