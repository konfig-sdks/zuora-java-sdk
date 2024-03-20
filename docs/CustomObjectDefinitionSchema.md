

# CustomObjectDefinitionSchema

The schema of the custom object definition

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**auditable** | **List&lt;String&gt;** | The set of fields which Audit Trail tracks and records changes of. |  [optional] |
|**enableCreateRecordAuditing** | **Boolean** | Indicates whether to audit the creation of custom object records of this custom object definition. |  [optional] |
|**enableDeleteRecordAuditing** | **Boolean** | Indicates whether to audit the deletion of custom object records of this custom object definition. |  [optional] |
|**filterable** | **List&lt;String&gt;** | The set of fields that are allowed to be queried on. Queries on non-filterable fields will be rejected. You can not change a non-filterable field to filterable. |  [optional] |
|**label** | **String** | A label for the custom object |  [optional] |
|**_object** | **String** | The API name of the custom object |  [optional] |
|**properties** | [**CustomObjectAllFieldsDefinition**](CustomObjectAllFieldsDefinition.md) |  |  [optional] |
|**relationships** | [**List&lt;CustomObjectDefinitionSchemaRelationshipsInner&gt;**](CustomObjectDefinitionSchemaRelationshipsInner.md) | An array of relationships with Zuora objects or other custom objects |  [optional] |
|**required** | **List&lt;String&gt;** | The required fields of the custom object definition. You can change required fields to optional. However, you can only change optional fields to required on the custom objects with no records. |  [optional] |
|**type** | [**TypeEnum**](#TypeEnum) | The custom object definition type. Can only be &#x60;object&#x60; currently. |  [optional] |
|**unique** | **List&lt;String&gt;** | The fields with unique constraints. |  [optional] |



## Enum: TypeEnum

| Name | Value |
|---- | -----|
| OBJECT | &quot;object&quot; |



