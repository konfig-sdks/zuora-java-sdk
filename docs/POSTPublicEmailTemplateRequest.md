

# POSTPublicEmailTemplateRequest


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**description** | **String** | The description of the email template. |  [optional] |
|**active** | **Boolean** | The status of the email template. The default value is &#x60;true&#x60;. |  [optional] |
|**bccEmailAddress** | **String** | The email bcc address. |  [optional] |
|**ccEmailAddress** | **String** | The email CC address. |  [optional] |
|**ccEmailType** | [**CcEmailTypeEnum**](#CcEmailTypeEnum) | Email CC type. * When the base object for the event is associated with &#x60;Account&#x60;, &#x60;ccEmailType&#x60; can be any values in the enum list.  * When the base object for the event is not associated with &#x60;Account&#x60;, &#x60;ccEmailType&#x60; must be &#x60;TenantAdmin&#x60;, &#x60;RunOwner&#x60;, or &#x60;SpecificEmail&#x60;.  |  [optional] |
|**emailBody** | **String** | The email body. You can add merge fields in the email body using angle brackets or double curly brackets. For more information, see &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Central_Platform/Events_and_Notifications/Create_Email_Templates/A_Merge_field_syntax_for_email_templates\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Merge field syntax for email templates&lt;/a&gt;.  You can also embed HTML tags if &#x60;isHtml&#x60; is &#x60;true&#x60;.  |  |
|**emailSubject** | **String** | The email subject. You can add merge fields in the email subject using angle brackets or double curly brackets. For more information, see &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Central_Platform/Events_and_Notifications/Create_Email_Templates/A_Merge_field_syntax_for_email_templates\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Merge field syntax for email templates&lt;/a&gt;.  |  |
|**encodingType** | [**EncodingTypeEnum**](#EncodingTypeEnum) | The endcode type of the email body. |  [optional] |
|**eventCategory** | **Double** | If you specify this field, the email template is created based on a standard event. See [Standard Event Categories](https://knowledgecenter.zuora.com/Central_Platform/Notifications/A_Standard_Events/Standard_Event_Category_Code_for_Notification_Histories_API) for all standard event category codes.   |  [optional] |
|**eventTypeName** | **String** | The name of the custom event or custom scheduled event. If you specify this field, the email template is created based on the corresponding custom event or custom scheduled event.  |  [optional] |
|**eventTypeNamespace** | **String** | The namespace of the &#x60;eventTypeName&#x60; field. The &#x60;eventTypeName&#x60; has the &#x60;user.notification&#x60; namespace by default.   Note that if the &#x60;eventTypeName&#x60; is a standard event type, you must specify the &#x60;com.zuora.notification&#x60; namespace; otherwise, you will get an error.  For example, if you want to create an email template on the &#x60;OrderActionProcessed&#x60; event, you must specify &#x60;com.zuora.notification&#x60; for this field.           |  [optional] |
|**fromEmailAddress** | **String** | If fromEmailType is SpecificEmail, this field is required. |  [optional] |
|**fromEmailType** | [**FromEmailTypeEnum**](#FromEmailTypeEnum) | The type of the email. |  |
|**fromName** | **String** | The name of the email sender. |  [optional] |
|**isHtml** | **Boolean** | Indicates whether the style of email body is HTML. The default value is &#x60;false&#x60;. |  [optional] |
|**name** | **String** | The name of the email template, a unique name in a tenant. |  |
|**replyToEmailAddress** | **String** | If replyToEmailType is SpecificEmail, this field is required. |  [optional] |
|**replyToEmailType** | [**ReplyToEmailTypeEnum**](#ReplyToEmailTypeEnum) | Type of the replyTo email. |  [optional] |
|**toEmailAddress** | **String** | If toEmailType is SpecificEmail, this field is required. |  [optional] |
|**toEmailType** | [**ToEmailTypeEnum**](#ToEmailTypeEnum) | Email receive type. * When the base object for the event is associated with &#x60;Account&#x60;, &#x60;toEmailType&#x60; can be any values in the enum list.  * When the base object for the event is not associated with &#x60;Account&#x60;, &#x60;toEmailType&#x60; must be &#x60;TenantAdmin&#x60;, &#x60;RunOwner&#x60;, or &#x60;SpecificEmail&#x60;.  |  |



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



