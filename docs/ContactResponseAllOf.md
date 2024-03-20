

# ContactResponseAllOf


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**accountId** | **String** | The ID of the account associated with the contact.  |  [optional] |
|**accountNumber** | **String** | The number of the customer account associated with the contact.  |  [optional] |
|**address1** | **String** | The first line of the contact&#39;s address, which is often a street address or business name.  |  [optional] |
|**address2** | **String** | The second line of the contact&#39;s address.  |  [optional] |
|**city** | **String** | The city of the contact&#39;s address.  |  [optional] |
|**contactDescription** | **String** | A description for the contact.  |  [optional] |
|**country** | **String** | The country of the contact&#39;s address.  |  [optional] |
|**county** | **String** | The county. May optionally be used by Zuora Tax to calculate county tax.  |  [optional] |
|**fax** | **String** | The contact&#39;s fax number.   |  [optional] |
|**firstName** | **String** | The contact&#39;s first name.  |  [optional] |
|**homePhone** | **String** | The contact&#39;s home phone number.  |  [optional] |
|**lastName** | **String** | The contact&#39;s last name.  |  [optional] |
|**mobilePhone** | **String** | The mobile phone number of the contact.  |  [optional] |
|**nickname** | **String** | A nickname for the contact.  |  [optional] |
|**otherPhone** | **String** | An additional phone number for the contact.  |  [optional] |
|**otherPhoneType** | [**OtherPhoneTypeEnum**](#OtherPhoneTypeEnum) | The type of the additional phone number.  |  [optional] |
|**personalEmail** | **String** | The contact&#39;s personal email address.  |  [optional] |
|**state** | **String** | The state or province of the contact&#39;s address.  |  [optional] |
|**success** | **Boolean** | Returns &#x60;true&#x60; if the request was processed successfully.  |  [optional] |
|**taxRegion** | **String** | If using Zuora Tax, a region string as optionally defined in your tax rules. Not required.  |  [optional] |
|**workEmail** | **String** | The contact&#39;s business email address.  |  [optional] |
|**workPhone** | **String** | The contact&#39;s business phone number.  |  [optional] |
|**zipCode** | **String** | The zip code for the contact&#39;s address.  |  [optional] |



## Enum: OtherPhoneTypeEnum

| Name | Value |
|---- | -----|
| WORK | &quot;Work&quot; |
| MOBILE | &quot;Mobile&quot; |
| HOME | &quot;Home&quot; |
| OTHER | &quot;Other&quot; |



