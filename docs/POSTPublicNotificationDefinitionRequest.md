

# POSTPublicNotificationDefinitionRequest


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**description** | **String** | The description of the notification definition. |  [optional] |
|**active** | **Boolean** | The status of the notification definition. The default value is &#x60;true&#x60;. |  [optional] |
|**associatedAccount** | **String** | The account on which the histories of this notification will be displayed. The associated account does not enforce where the merge fields come from. Available values are as follows: * &#x60;Account.Id&#x60;: ID of the primary customer account related to the notification. It is also the default value. * &#x60;ParentAccount.Id&#x60;: this option is available only if you have &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Billing/Subscriptions/Customer_Accounts/A_Customer_Account_Introduction#Customer_Hierarchy\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Customer Hierarchy&lt;/a&gt; enabled for your tenant. * &#x60;SubscriptionOwnerAccount.Id&#x60;: this option is available if the base object of the notification is Order Action.  **Note:** before specifying this field, we recommend that you use [Data Source](https://knowledgecenter.zuora.com/Billing/Reporting/D_Data_Sources_and_Exports/C_Data_Source_Reference) to check the available types of accounts for the current notification.    |  [optional] |
|**callout** | **Object** |  |  [optional] |
|**calloutActive** | **Boolean** | The status of the callout action. The default value is &#x60;false&#x60;. |  [optional] |
|**communicationProfileId** | **String** | The profile that notification definition belongs to.   You can use the [Query Action](https://developer.zuora.com/api-references/api/operation/Action_POSTquery) to get the communication profile Id. See the following request sample:  &#x60;{     \&quot;queryString\&quot;: \&quot;select Id, ProfileName from CommunicationProfile\&quot;  }&#x60;  If you do not pass the communicationProfileId, notification service will be automatically added to the &#39;Default Profile&#39;.  |  [optional] |
|**emailActive** | **Boolean** | The status of the email action. The default value is &#x60;false&#x60;. |  [optional] |
|**emailTemplateId** | **UUID** | The ID of the email template. If &#x60;emailActive&#x60; is &#x60;true&#x60;, an email template is required. And EventType of the email template MUST be the same as the eventType. |  [optional] |
|**eventCategory** | **Double** | The event category code for a standard event, on which the notification definition is created.  This field is required when creating notification definitions for standard events.  For the list of supported standard event category codes, see &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Central_Platform/Events_and_Notifications/A_Standard_Events/Standard_Event_Category_Code_for_Events_and_Notifications\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Standard event category code for events and notifications&lt;/a&gt;.  |  [optional] |
|**eventTypeName** | **String** | The name of the event that the notification definition is based on.  This field is required when creating notification definitions for Zuora custom events, custom events, or custom scheduled events.  If this field is provided, you can specify the event namespace in the &#x60;eventTypeNamespace&#x60; field.   |  [optional] |
|**eventTypeNamespace** | [**EventTypeNamespaceEnum**](#EventTypeNamespaceEnum) | The namespace of the &#x60;eventTypeName&#x60; field. It indicates who created the event and which namespace the event is assigned to.  Supported values are as follows:  - &#x60;com.zuora.notification&#x60;: events that are created by Zuora. This value applies to Zuora custom events. - &#x60;user.notification&#x60;: events that are created by tenant users. This value applies to custom events and custom scheduled events. This is the default value.             For example, if you want to create a notification definition on the &#x60;OrderActionProcessed&#x60; event, which is a Zuora custom event, you must specify &#x60;com.zuora.notification&#x60; for this field.  |  [optional] |
|**filterRule** | [**POSTPublicNotificationDefinitionRequestFilterRule**](POSTPublicNotificationDefinitionRequestFilterRule.md) |  |  [optional] |
|**filterRuleParams** | **Map&lt;String, String&gt;** | The parameter values used to configure the filter rule.  |  [optional] |
|**name** | **String** | The name of the notification definition, unique per communication profile. |  |



## Enum: EventTypeNamespaceEnum

| Name | Value |
|---- | -----|
| USER_NOTIFICATION | &quot;user.notification&quot; |
| COM_ZUORA_NOTIFICATION | &quot;com.zuora.notification&quot; |



