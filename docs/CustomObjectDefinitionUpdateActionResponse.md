

# CustomObjectDefinitionUpdateActionResponse


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**description** | **String** | Optional property for &#x60;updateObject&#x60; action |  [optional] |
|**enableCreateRecordAuditing** | **Boolean** | Indicates whether to audit the creation of custom object records of this custom object definition. |  [optional] |
|**enableDeleteRecordAuditing** | **Boolean** | Indicates whether to audit the deletion of custom object records of this custom object definition. |  [optional] |
|**field** | [**UpdateCustomObjectCusotmField**](UpdateCustomObjectCusotmField.md) |  |  [optional] |
|**label** | **String** | Optional property for &#x60;updateObject&#x60; action |  [optional] |
|**namespace** | **String** | The namespace of the custom object definition to be updated |  [optional] |
|**_object** | **String** | The API name of the custom object definition to be updated |  [optional] |
|**relationship** | [**CustomObjectDefinitionUpdateActionResponseRelationship**](CustomObjectDefinitionUpdateActionResponseRelationship.md) |  |  [optional] |
|**type** | [**TypeEnum**](#TypeEnum) | The type of the updating action on a custom object definition |  [optional] |



## Enum: TypeEnum

| Name | Value |
|---- | -----|
| ADDFIELD | &quot;addField&quot; |
| DELETEFIELD | &quot;deleteField&quot; |
| UPDATEFIELD | &quot;updateField&quot; |
| UPDATEOBJECT | &quot;updateObject&quot; |
| RENAMEFIELD | &quot;renameField&quot; |
| ADDRELATIONSHIP | &quot;addRelationship&quot; |
| DELETERELATIONSHIP | &quot;deleteRelationship&quot; |



