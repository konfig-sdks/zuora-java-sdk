

# POSTAccountTypeBillToContact

Container for bill-to contact information for this account. If you do not provide a sold-to contact, the bill-to contact is copied to sold-to contact. Once the sold-to contact is created, changes to billToContact will not affect soldToContact and vice versa. 

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**address1** | **String** | First address line, 255 characters or less.  |  [optional] |
|**address2** | **String** | Second address line, 255 characters or less.  |  [optional] |
|**city** | **String** | City, 40 characters or less.  |  [optional] |
|**country** | **String** | Country; must be a valid country name or abbreviation. If using Zuora Tax, you must specify a country in the sold-to contact to calculate tax. A bill-to contact may be used if no sold-to contact is provided.  |  [optional] |
|**county** | **String** | County; 32 characters or less. May optionally be used by Zuora Tax to calculate county tax.  |  [optional] |
|**fax** | **String** | Fax phone number, 40 characters or less.  |  [optional] |
|**firstName** | **String** | First name, 100 characters or less.  |  |
|**homePhone** | **String** | Home phone number, 40 characters or less.  |  [optional] |
|**lastName** | **String** | Last name, 100 characters or less.  |  |
|**mobilePhone** | **String** | Mobile phone number, 40 characters or less.  |  [optional] |
|**nickname** | **String** | Nickname for this contact  |  [optional] |
|**otherPhone** | **String** | Other phone number, 40 characters or less.  |  [optional] |
|**otherPhoneType** | **String** | Possible values are: &#x60;Work&#x60;, &#x60;Mobile&#x60;, &#x60;Home&#x60;, &#x60;Other&#x60;.  |  [optional] |
|**personalEmail** | **String** | Personal email address, 80 characters or less.  |  [optional] |
|**state** | **String** | State; must be a valid state or province name or 2-character abbreviation. If using Zuora Tax, be aware that Zuora tax requires a state (in the US) or province (in Canada) in this field for the sold-to contact to calculate tax, and that a bill-to contact may be used if no sold-to contact is provided.  |  [optional] |
|**taxRegion** | **String** | If using Zuora Tax, a region string as optionally defined in your tax rules. Not required.  |  [optional] |
|**workEmail** | **String** | Work email address, 80 characters or less.  |  [optional] |
|**workPhone** | **String** | Work phone number, 40 characters or less.  |  [optional] |
|**zipCode** | **String** | Zip code, 20 characters or less.  |  [optional] |



