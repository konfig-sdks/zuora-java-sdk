

# ContactInfo


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**address1** | **String** | First line of the contact&#39;s address. This is often a street address or a business name.  |  [optional] |
|**address2** | **String** | Second line of the contact&#39;s address.  |  [optional] |
|**city** | **String** | City of the contact&#39;s address.  |  [optional] |
|**contactDescription** | **String** | A description for the contact.  |  [optional] |
|**country** | **String** | Country; must be a valid country name or abbreviation. If using [Zuora Tax](https://knowledgecenter.zuora.com/Zuora_Billing/Taxes/A_Zuora_Tax), you must specify a country in the bill-to contact to calculate tax.  |  [optional] |
|**county** | **String** | County of the contact&#39;s address.  |  [optional] |
|**customFields** | **Map&lt;String, Object&gt;** | Container for custom fields.  |  [optional] |
|**fax** | **String** | Fax number of the contact.  |  [optional] |
|**firstName** | **String** | First name of the contact.  |  |
|**homePhone** | **String** | Home phone number of the contact.  |  [optional] |
|**lastName** | **String** |  |  |
|**mobilePhone** | **String** | Mobile phone number of the contact.  |  [optional] |
|**nickname** | **String** | Nickname of the contact.  |  [optional] |
|**otherPhone** | **String** | Additional phone number of the contact. Use the &#x60;otherPhoneType&#x60; field to specify the type of phone number.  |  [optional] |
|**otherPhoneType** | [**OtherPhoneTypeEnum**](#OtherPhoneTypeEnum) | Specifies the type of phone number in the &#x60;otherPhone&#x60; field.  |  [optional] |
|**personalEmail** | **String** | Personal email address of the contact.  |  [optional] |
|**postalCode** | **String** | ZIP code or other postal code of the contact&#39;s address.  |  [optional] |
|**state** | **String** | State or province of the contact&#39;s address.  |  [optional] |
|**taxRegion** | **String** | Region defined in your taxation rules. Only applicable if you use Zuora Tax.  |  [optional] |
|**workEmail** | **String** | Business email address of the contact.  |  [optional] |
|**workPhone** | **String** | Business phone number of the contact.  |  [optional] |



## Enum: OtherPhoneTypeEnum

| Name | Value |
|---- | -----|
| WORK | &quot;Work&quot; |
| MOBILE | &quot;Mobile&quot; |
| HOME | &quot;Home&quot; |
| OTHER | &quot;Other&quot; |



