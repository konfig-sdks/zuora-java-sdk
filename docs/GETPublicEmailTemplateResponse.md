

# GETPublicEmailTemplateResponse


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**description** | **String** | The description of the email template. |  [optional] |
|**active** | **Boolean** | The status of the email template. |  [optional] |
|**bccEmailAddress** | **String** | Email BCC address. |  [optional] |
|**ccEmailAddress** | **String** | Email CC address. |  [optional] |
|**ccEmailType** | [**CcEmailTypeEnum**](#CcEmailTypeEnum) | Email cc type. |  [optional] |
|**createdBy** | **UUID** | The ID of the user who created the email template. |  [optional] |
|**createdOn** | **OffsetDateTime** | The time when the email template was created. Specified in the UTC timezone in the ISO860 format (YYYY-MM-DDThh:mm:ss.sTZD). E.g. 1997-07-16T19:20:30.45+00:00 |  [optional] |
|**emailBody** | **String** | The email body. You can add merge fields in the email body using angle brackets or double curly brackets. For more information, see &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Central_Platform/Events_and_Notifications/Create_Email_Templates/A_Merge_field_syntax_for_email_templates\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Merge field syntax for email templates&lt;/a&gt;.   User can also embed html tags if &#x60;isHtml&#x60; is &#x60;true&#x60;.  |  [optional] |
|**emailSubject** | **String** | The email subject. You can add merge fields in the email subject using angle brackets or double curly brackets. For more information, see &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Central_Platform/Events_and_Notifications/Create_Email_Templates/A_Merge_field_syntax_for_email_templates\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Merge field syntax for email templates&lt;/a&gt;.  |  [optional] |
|**encodingType** | [**EncodingTypeEnum**](#EncodingTypeEnum) | The endcode type of the email body. |  [optional] |
|**eventCategory** | **Double** | The event category code for a standard event. See [Standard Event Categories](https://knowledgecenter.zuora.com/Central_Platform/Notifications/A_Standard_Events/Standard_Event_Category_Code_for_Notification_Histories_API) for all event category codes. |  [optional] |
|**eventTypeName** | **String** | The name of the custom event or custom scheduled event. |  [optional] |
|**eventTypeNamespace** | **String** | The namespace of the &#x60;eventTypeName&#x60; field for custom events and custom scheduled events.   |  [optional] |
|**fromEmailAddress** | **String** | If formEmailType is SpecificEmail, this field is required. |  [optional] |
|**fromEmailType** | [**FromEmailTypeEnum**](#FromEmailTypeEnum) | The from email type. |  [optional] |
|**fromName** | **String** | The name of email sender. |  [optional] |
|**id** | **UUID** | The email template ID. |  [optional] |
|**isHtml** | **Boolean** | Indicates whether the style of email body is HTML. |  [optional] |
|**name** | **String** | The name of the email template. |  [optional] |
|**replyToEmailAddress** | **String** | If replyToEmailType is SpecificEmail, this field is required |  [optional] |
|**replyToEmailType** | [**ReplyToEmailTypeEnum**](#ReplyToEmailTypeEnum) | The reply email type. |  [optional] |
|**toEmailAddress** | **String** | If &#x60;toEmailType&#x60; is &#x60;SpecificEmail&#x60;, this field is required. |  [optional] |
|**toEmailType** | [**ToEmailTypeEnum**](#ToEmailTypeEnum) | Email receive type. |  [optional] |
|**updatedBy** | **UUID** | The ID of the user who updated the email template. |  [optional] |
|**updatedOn** | **OffsetDateTime** | The time when the email template was updated. Specified in the UTC timezone in the ISO860 format (YYYY-MM-DDThh:mm:ss.sTZD). E.g. 1997-07-16T19:20:30.45+00:00 |  [optional] |



## Enum: CcEmailTypeEnum

| Name | Value |
|---- | -----|
| BILLTOCONTACT | &quot;BillToContact&quot; |
| SOLDTOCONTACT | &quot;SoldToContact&quot; |
| SPECIFICEMAILS | &quot;SpecificEmails&quot; |
| TENANTADMIN | &quot;TenantAdmin&quot; |
| BILLTOANDSOLDTOCONTACTS | &quot;BillToAndSoldToContacts&quot; |
| RUNOWNER | &quot;RunOwner&quot; |
| ALLCONTACTS | &quot;AllContacts&quot; |
| INVOICEOWNERBILLTOCONTACT | &quot;InvoiceOwnerBillToContact&quot; |
| INVOICEOWNERSOLDTOCONTACT | &quot;InvoiceOwnerSoldToContact&quot; |
| INVOICEOWNERBILLTOANDSOLDTOCONTACTS | &quot;InvoiceOwnerBillToAndSoldToContacts&quot; |
| INVOICEOWNERALLCONTACTS | &quot;InvoiceOwnerAllContacts&quot; |



## Enum: EncodingTypeEnum

| Name | Value |
|---- | -----|
| UTF8 | &quot;UTF8&quot; |
| SHIFT_JIS | &quot;Shift_JIS&quot; |
| ISO_2022_JP | &quot;ISO_2022_JP&quot; |
| EUC_JP | &quot;EUC_JP&quot; |
| X_SJIS_0213 | &quot;X_SJIS_0213&quot; |



## Enum: FromEmailTypeEnum

| Name | Value |
|---- | -----|
| TENANTEMAIL | &quot;TenantEmail&quot; |
| RUNOWNER | &quot;RunOwner&quot; |
| SPECIFICEMAIL | &quot;SpecificEmail&quot; |



## Enum: ReplyToEmailTypeEnum

| Name | Value |
|---- | -----|
| TENANTEMAIL | &quot;TenantEmail&quot; |
| RUNOWNER | &quot;RunOwner&quot; |
| SPECIFICEMAIL | &quot;SpecificEmail&quot; |



## Enum: ToEmailTypeEnum

| Name | Value |
|---- | -----|
| BILLTOCONTACT | &quot;BillToContact&quot; |
| SOLDTOCONTACT | &quot;SoldToContact&quot; |
| SPECIFICEMAILS | &quot;SpecificEmails&quot; |
| TENANTADMIN | &quot;TenantAdmin&quot; |
| BILLTOANDSOLDTOCONTACTS | &quot;BillToAndSoldToContacts&quot; |
| RUNOWNER | &quot;RunOwner&quot; |
| ALLCONTACTS | &quot;AllContacts&quot; |
| INVOICEOWNERBILLTOCONTACT | &quot;InvoiceOwnerBillToContact&quot; |
| INVOICEOWNERSOLDTOCONTACT | &quot;InvoiceOwnerSoldToContact&quot; |
| INVOICEOWNERBILLTOANDSOLDTOCONTACTS | &quot;InvoiceOwnerBillToAndSoldToContacts&quot; |
| INVOICEOWNERALLCONTACTS | &quot;InvoiceOwnerAllContacts&quot; |



