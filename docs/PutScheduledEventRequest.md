

# PutScheduledEventRequest


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**description** | **String** | The description of the scheduled event. |  [optional] |
|**parameters** | [**Map&lt;String, PostScheduledEventRequestParametersValue&gt;**](PostScheduledEventRequestParametersValue.md) | The parameters of the filter rule. The names of the parameters must match with the filter rule and can&#39;t be duplicated. |  [optional] |
|**active** | **Boolean** | Indicate whether the scheduled event is active or inactive |  [optional] |
|**condition** | **String** | The filter rule conditions, written in [JEXL](http://commons.apache.org/proper/commons-jexl/). The scheduled event is triggered only if the condition is evaluated as true. The rule might contain event context merge fields and data source merge fields. Data source merge fields must be from [the base object of the event or from the joined objects of the base object](https://knowledgecenter.zuora.com/DC_Developers/M_Export_ZOQL#Data_Sources_and_Objects). Scheduled events with invalid merge fields will fail to evaluate, thus will not be triggered. For example, to trigger an invoice due date scheduled event to only invoices with an amount over 1000, you would define the following condition:  &#x60;&#x60;&#x60;Invoice.Amount &gt; 1000&#x60;&#x60;&#x60;  &#x60;Invoice.Amount&#x60; refers to the &#x60;Amount&#x60; field of the Zuora object &#x60;Invoice&#x60;.  |  [optional] |
|**displayName** | **String** | The display name of the scheduled event. |  [optional] |
|**hours** | **Integer** | The scheduled time (hour) that the scheduled event notifications are sent. This time is based on the localized timezone of your tenant. |  [optional] |
|**minutes** | **Integer** | The scheduled time (minute) that the scheduled event notifications are sent. This time is based on the localized timezone of your tenant. |  [optional] |



