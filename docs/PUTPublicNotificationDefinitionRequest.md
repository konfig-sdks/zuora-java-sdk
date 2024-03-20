

# PUTPublicNotificationDefinitionRequest


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**description** | **String** | The description of the notification definition. |  [optional] |
|**active** | **Boolean** | The status of the notification definition. The default value is &#x60;true&#x60;. |  [optional] |
|**associatedAccount** | **String** | The account on which the histories of this notification will be displayed. The associated account does not enforce where the merge fields come from. Available values are as follows: * &#x60;Account.Id&#x60;: ID of the primary customer account related to the notification. It is also the default value. * &#x60;ParentAccount.Id&#x60;: this option is available only if you have &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Billing/Subscriptions/Customer_Accounts/A_Customer_Account_Introduction#Customer_Hierarchy\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Customer Hierarchy&lt;/a&gt; enabled for your tenant. * &#x60;SubscriptionOwnerAccount.Id&#x60;: this option is available if the base object of the notification is Order Action.  **Note:** before specifying this field, we recommend that you use [Data Source](https://knowledgecenter.zuora.com/Billing/Reporting/D_Data_Sources_and_Exports/C_Data_Source_Reference) to check the available types of accounts for the current notification.    |  [optional] |
|**callout** | **Object** |  |  [optional] |
|**calloutActive** | **Boolean** | The status of the callout action. The default value is &#x60;false&#x60;. |  [optional] |
|**communicationProfileId** | **UUID** | The profile that notification definition belongs to. If you want to update the notification to a system notification, you should pass &#39;SystemNotification&#39;. &#39;  |  [optional] |
|**emailActive** | **Boolean** | The status of the email action. The default value is &#x60;false&#x60;. |  [optional] |
|**emailTemplateId** | **UUID** | The ID of the email template. If emailActive is updated from false to true, an email template is required, and the EventType of the email template MUST be the same as the EventType of the notification definition.  |  [optional] |
|**filterRule** | [**PUTPublicNotificationDefinitionRequestFilterRule**](PUTPublicNotificationDefinitionRequestFilterRule.md) |  |  [optional] |
|**filterRuleParams** | **Map&lt;String, String&gt;** | The parameter values used to configure the filter rule.  |  [optional] |
|**name** | **String** | The name of the notification definition, which is unique in the profile. |  [optional] |



