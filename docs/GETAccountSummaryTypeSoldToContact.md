

# GETAccountSummaryTypeSoldToContact

Container for sold-to contact information.  **Note**:    - If you have the <a href=\"https://knowledgecenter.zuora.com/Zuora_Billing/Bill_your_customers/Bill_customers_at_subscription_level/Flexible_Billing_Attributes\" target=\"_blank\">Flexible Billing Attributes</a> feature disabled, this field is unavailable in the request body and the value of this field is `null` in the response body.    - If you have the Flexible Billing Attributes feature enabled, and you do not specify the `soldToContactId` field in the request or you select **Default Contact from Account** for the `soldToContactId` field during subscription creation, the value of the `soldToContact` field is automatically set to `null` in the response body. 

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**address1** | **String** | First address line, 255 characters or less.  |  [optional] |
|**address2** | **String** | Second address line, 255 characters or less.  |  [optional] |
|**city** | **String** | City, 40 characters or less.  |  [optional] |
|**country** | **String** | Full country name. This field does not contain the ISO-standard abbreviation of the country name.  |  [optional] |
|**county** | **String** | County; 32 characters or less. Zuora Tax uses this information to calculate county taxation.           |  [optional] |
|**fax** | **String** | Fax phone number, 40 characters or less.  |  [optional] |
|**firstName** | **String** | First name, 100 characters or less.  |  [optional] |
|**id** | **String** | Contact ID.  |  [optional] |
|**lastName** | **String** | Last name, 100 characters or less.  |  [optional] |
|**state** | **String** | Full state name. This field does not contain the ISO-standard abbreviation of the state name.  |  [optional] |
|**taxRegion** | **String** | A region string, defined in your Zuora tax rules.  |  [optional] |
|**workEmail** | **String** | Work email address, 80 characters or less.  |  [optional] |
|**workPhone** | **String** | Work phone number, 40 characters or less.  |  [optional] |
|**zipCode** | **String** | Zip code, 20 characters or less.  |  [optional] |



