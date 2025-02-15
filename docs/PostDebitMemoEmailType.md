

# PostDebitMemoEmailType


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**emailAddresses** | **String** | The valid email addresses you want to email a debit memo to. Use commas to separate email addresses.  **Note:** This field is only applicable if you set the &#x60;useEmailTemplateSetting&#x60; field to &#x60;false&#x60;.  |  [optional] |
|**includeAdditionalEmailAddresses** | [**IncludeAdditionalEmailAddressesEnum**](#IncludeAdditionalEmailAddressesEnum) | Indicates whether to send a debit memo to the additional email addresses of the memo account.    You can set the additional email addresses in the **Additional Email Addresses** field on the account detail page from the Zuora UI. See [Create a Customer Account](https://knowledgecenter.zuora.com/BC_Subscription_Management/Customer_Accounts/B_Create_a_Customer_Account#section_2) for more information.  |  [optional] |
|**pdfFileId** | **String** | The ID of the PDF file that you want to send in the email.   If you do not specify any PDF file ID, the latest PDF file generated for the debit memo is sent in the email.  |  [optional] |
|**useEmailTemplateSetting** | [**UseEmailTemplateSettingEnum**](#UseEmailTemplateSettingEnum) | Indicates whether to email a debit memo based on the email template setting.   If you set this field to &#x60;true&#x60;, the debit memo is sent to the email addresses specified in the **To Email** field of the email template. The email template is the one you set in the **Delivery Options** panel of the **Edit notification** dialog from the Zuora UI. See [Edit Email Templates](https://knowledgecenter.zuora.com/CF_Users_and_Administrators/Notifications/Create_Email_Templates) for more information about how to edit the **To Email** field in the email template.  |  [optional] |



## Enum: IncludeAdditionalEmailAddressesEnum

| Name | Value |
|---- | -----|
| TRUE | &quot;true&quot; |
| FALSE | &quot;false&quot; |



## Enum: UseEmailTemplateSettingEnum

| Name | Value |
|---- | -----|
| TRUE | &quot;true&quot; |
| FALSE | &quot;false&quot; |



