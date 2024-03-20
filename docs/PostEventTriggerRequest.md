

# PostEventTriggerRequest


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**description** | **String** | The description of the event trigger. |  [optional] |
|**active** | **Boolean** | The status of the event trigger. |  |
|**baseObject** | **String** | The base object that the trigger rule is defined upon. The format of the value in this field depends on the base object type: - Standard object: object name, which should follow the pattern ^[A-Z][\\w\\-]*$. For example, &#x60;Invoice&#x60;. - Custom object: &#x60;default__&lt;custom_object_api_name&gt;&#x60;. For example, &#x60;default__vehicle&#x60;.  |  |
|**condition** | **String** | The JEXL expression to be evaluated against object changes. See above for more information and an example. |  |
|**eventType** | [**EventType**](EventType.md) |  |  |



