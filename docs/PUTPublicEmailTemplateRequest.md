

# PUTPublicEmailTemplateRequest


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**description** | **String** | The description of the email template. |  [optional] |
|**active** | **Boolean** | The status of the email template. |  [optional] |
|**bccEmailAddress** | **String** | Email bcc address. |  [optional] |
|**ccEmailAddress** | **String** | Email cc address. |  [optional] |
|**ccEmailType** | [**CcEmailTypeEnum**](#CcEmailTypeEnum) | Email CC type. * When the base object for the event is associated with &#x60;Account&#x60;, &#x60;ccEmailType&#x60; can be any values in the enum list.  * When the base object for the event is not associated with &#x60;Account&#x60;, &#x60;ccEmailType&#x60; must be &#x60;TenantAdmin&#x60;, &#x60;RunOwner&#x60;, or &#x60;SpecificEmail&#x60;.  |  [optional] |
|**emailBody** | **String** | The email body. You can add merge fields in the email body using angle brackets or double curly brackets. For more information, see &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Central_Platform/Events_and_Notifications/Create_Email_Templates/A_Merge_field_syntax_for_email_templates\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Merge field syntax for email templates&lt;/a&gt;.   User can also embed html tags if &#x60;isHtml&#x60; is &#x60;true&#x60;.  |  [optional] |
|**emailSubject** | **String** | The email subject. You can add merge fields in the email subject using angle brackets or double curly brackets. For more information, see &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Central_Platform/Events_and_Notifications/Create_Email_Templates/A_Merge_field_syntax_for_email_templates\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Merge field syntax for email templates&lt;/a&gt;.  |  [optional] |
|**encodingType** | [**EncodingTypeEnum**](#EncodingTypeEnum) | The endcode type of the email body. |  [optional] |
|**fromEmailAddress** | **String** | If fromEmailType is SpecificEmail, this field is required |  [optional] |
|**fromEmailType** | [**FromEmailTypeEnum**](#FromEmailTypeEnum) | The type of fromEmail. |  [optional] |
|**fromName** | **String** | The name of email sender. |  [optional] |
|**isHtml** | **Boolean** | Indicates whether the style of email body is HTML. |  [optional] |
|**name** | **String** | The name of the email template. |  [optional] |
|**replyToEmailAddress** | **String** | If replyToEmailType is SpecificEmail, this field is required. |  [optional] |
|**replyToEmailType** | [**ReplyToEmailTypeEnum**](#ReplyToEmailTypeEnum) | The type of the reply email. |  [optional] |
|**toEmailAddress** | **String** | If toEmailType is SpecificEmail, this field is required. |  [optional] |
|**toEmailType** | [**ToEmailTypeEnum**](#ToEmailTypeEnum) | Email receive type. * When the base object for the event is associated with &#x60;Account&#x60;, &#x60;toEmailType&#x60; can be any values in the enum list.  * When the base object for the event is not associated with &#x60;Account&#x60;, &#x60;toEmailType&#x60; must be &#x60;TenantAdmin&#x60;, &#x60;RunOwner&#x60;, or &#x60;SpecificEmail&#x60;.  |  [optional] |



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



