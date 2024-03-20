

# GETContactSnapshotResponse


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**description** | **String** | A description of the contact.  |  [optional] |
|**address1** | **String** | The first line for the address of the contact, which is often a street address or business name.  |  [optional] |
|**address2** | **String** | The second line for the address of the contact, which is mostly the locality.  |  [optional] |
|**city** | **String** | The city for the address of the contact.  |  [optional] |
|**contactId** | **String** | The Zuora ID of the contact who the snapshot belongs to.  |  [optional] |
|**country** | **String** | The country for the address of the contact.  |  [optional] |
|**county** | **String** | The county for the address of the contact. The field value might optionally be used by Zuora Tax to calculate county tax.  |  [optional] |
|**fax** | **BigDecimal** | The fax number of the contact.  |  [optional] |
|**firstName** | **String** | The first name of the contact.  |  [optional] |
|**homePhone** | **BigDecimal** | The home phone number of the contact.  |  [optional] |
|**id** | **String** | The unique ID of the contact snapshot.  |  [optional] |
|**lastName** | **String** | The last name of the contact.  |  [optional] |
|**mobilePhone** | **BigDecimal** | The mobile phone number of the contact.  |  [optional] |
|**nickname** | **String** | A nickname for the contact.  |  [optional] |
|**otherPhone** | **String** | An additional phone number for the contact.  |  [optional] |
|**otherPhoneType** | [**OtherPhoneTypeEnum**](#OtherPhoneTypeEnum) | The type of the additional phone number.  |  [optional] |
|**personalEmail** | **String** | The personal email address of the contact.  |  [optional] |
|**postalCode** | **BigDecimal** | The postal code for the address of the contact.  |  [optional] |
|**state** | **String** | The state or province for the address of the contact.  |  [optional] |
|**taxRegion** | **String** | If using Zuora Tax rules.  |  [optional] |
|**workEmail** | **String** | The business email address of the contact.  |  [optional] |
|**workPhone** | **BigDecimal** | The business email address of the contact.  |  [optional] |



## Enum: OtherPhoneTypeEnum

| Name | Value |
|---- | -----|
| WORK | &quot;Work&quot; |
| MOBILE | &quot;Mobile&quot; |
| HOME | &quot;Home&quot; |
| OTHER | &quot;Other&quot; |



