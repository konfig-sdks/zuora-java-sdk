

# CustomObjectDefinitionSchemaRelationshipsInner


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**cardinality** | [**CardinalityEnum**](#CardinalityEnum) | The cardinality of the relationship from this object to another object.  A &#x60;manyToOne&#x60; relationship means this object is the child object (the \&quot;many\&quot; side), and the referenced object (the \&quot;one\&quot; side) is the parent.  A &#x60;oneToMany&#x60; relationship means this object is the parent object (the \&quot;one\&quot; side), and the referenced object (the \&quot;many\&quot; side) is the child.  |  [optional] |
|**fields** | **Map&lt;String, String&gt;** | Field mappings in the form of &#x60;&lt;this-object-field-name&gt;&#x60;: &#x60;&lt;other-object-field-name&gt;&#x60;.  |  [optional] |
|**namespace** | **String** | The namespace where the related object is located |  [optional] |
|**_object** | **String** | The API name of the related object |  [optional] |
|**recordConstraints** | [**CustomObjectDefinitionSchemaRelationshipsInnerRecordConstraints**](CustomObjectDefinitionSchemaRelationshipsInnerRecordConstraints.md) |  |  [optional] |



## Enum: CardinalityEnum

| Name | Value |
|---- | -----|
| MANYTOONE | &quot;manyToOne&quot; |
| ONETOMANY | &quot;oneToMany&quot; |



