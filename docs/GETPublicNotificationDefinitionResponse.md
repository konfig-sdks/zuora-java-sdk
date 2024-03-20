

# GETPublicNotificationDefinitionResponse


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**description** | **String** | Description of the notification definition |  [optional] |
|**active** | **Boolean** | The status of the notification definition. The default value is &#x60;true&#x60;. |  [optional] |
|**associatedAccount** | **String** | The account on which the histories of this notification will be displayed. The associated account does not enforce where the merge fields come from.  |  [optional] |
|**callout** | [**GETPublicNotificationDefinitionResponseCallout**](GETPublicNotificationDefinitionResponseCallout.md) |  |  [optional] |
|**calloutActive** | **Boolean** | The status of the callout action. The default value is &#x60;false&#x60;. |  [optional] |
|**communicationProfileId** | **UUID** | The profile that the notification definition belongs to. |  [optional] |
|**createdBy** | **UUID** | The ID of the user who created the notification definition. |  [optional] |
|**createdOn** | **OffsetDateTime** | The time when the notification definition was created. Specified in the UTC timezone in the ISO860 format (YYYY-MM-DDThh:mm:ss.sTZD). E.g. 1997-07-16T19:20:30.45+00:00 |  [optional] |
|**emailActive** | **Boolean** | The status of the email action. The default value is &#x60;false&#x60;. |  [optional] |
|**emailTemplateId** | **UUID** | The ID of the email template. In the request, there should be at least one email template or callout. |  [optional] |
|**eventCategory** | **Double** | The event category code for a standard event, on which the notification definition is created.  This field is available only if the notification definition is based on a standard event.  For the list of supported standard event category codes, see &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Central_Platform/Events_and_Notifications/A_Standard_Events/Standard_Event_Category_Code_for_Events_and_Notifications\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Standard event category code for events and notifications&lt;/a&gt;.  |  [optional] |
|**eventId** | **UUID** | The ID of the event that the notification definition is based on.  This field is available only if the notification definition is based on a standard event.      |  [optional] |
|**eventTypeName** | **String** | The name of the event that the notification definition is based on.  This field is available only if the notification definition is based on a Zuora custom event, custom event, or custom scheduled event.  |  [optional] |
|**eventTypeNamespace** | [**EventTypeNamespaceEnum**](#EventTypeNamespaceEnum) | The namespace of the &#x60;eventTypeName&#x60; field. It indicates who created the event and which namespace the event is assigned to.  Supported values are as follows:  - &#x60;com.zuora.notification&#x60;: events that are created by Zuora. This value applies to Zuora custom events. - &#x60;user.notification&#x60;: events that are created by tenant users. This value applies to custom events and custom scheduled events.  This field is available only if the notification definition is based on a Zuora custom event, custom event, or custom scheduled event.        |  [optional] |
|**filterRule** | [**GETPublicNotificationDefinitionResponseFilterRule**](GETPublicNotificationDefinitionResponseFilterRule.md) |  |  [optional] |
|**filterRuleParams** | **Map&lt;String, String&gt;** | The parameter values used to configure the filter rule.  |  [optional] |
|**id** | **UUID** | The ID associated with this notification definition. |  [optional] |
|**name** | **String** | The name of the notification definition. |  [optional] |
|**updatedBy** | **UUID** | The ID of the user who updated the notification definition. |  [optional] |
|**updatedOn** | **OffsetDateTime** | The time when the notification was updated. Specified in the UTC timezone in the ISO860 format (YYYY-MM-DDThh:mm:ss.sTZD). E.g. 1997-07-16T19:20:30.45+00:00 |  [optional] |



## Enum: EventTypeNamespaceEnum

| Name | Value |
|---- | -----|
| USER_NOTIFICATION | &quot;user.notification&quot; |
| COM_ZUORA_NOTIFICATION | &quot;com.zuora.notification&quot; |



