

# CustomObjectDefinitionUpdateActionRequestRelationship


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**cardinality** | [**CardinalityEnum**](#CardinalityEnum) | The cardinality of the relationship from this object to another object.  Only the &#x60;manyToOne&#x60; cardinality can be used when creating relationships.  A relationship with &#x60;oneToMany&#x60; cardinality is created implicitly when a &#x60;manyToOne&#x60; relationship is created.  A custom object definition can have a maximum of 2 &#x60;manyToOne&#x60; relationships.  |  [optional] |
|**fields** | **Map&lt;String, String&gt;** | Field mappings in the form of &#x60;&lt;this-object-field-name&gt;&#x60;: &#x60;&lt;other-object-field-name&gt;&#x60;.  |  |
|**namespace** | **String** | The namespace where the related object is located |  |
|**_object** | **String** | The API name of the related object |  |
|**recordConstraints** | [**CustomObjectDefinitionUpdateActionRequestRelationshipRecordConstraints**](CustomObjectDefinitionUpdateActionRequestRelationshipRecordConstraints.md) |  |  [optional] |



## Enum: CardinalityEnum

| Name | Value |
|---- | -----|
| MANYTOONE | &quot;manyToOne&quot; |



