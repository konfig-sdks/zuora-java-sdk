

# PostCustomObjectDefinitionsRequestDefinition


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**auditable** | **List&lt;String&gt;** | The set of fields which Audit Trail tracks and records changes of. You can change auditable fields to non-auditable, and vice versa. One custom object can have a maximum of five auditable fields. |  [optional] |
|**enableCreateRecordAuditing** | **Boolean** | Indicates whether to audit the creation of custom object records of this custom object definition.  Note that you must enable the **Custom Object Definition** audit trail setting in your Zuora tenant before auditing custom object record creation. For more information, see &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Central_Platform/Tenant_Management/A_Administrator_Settings/Manage_Audit_Trail_Settings\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Manage audit trail settings&lt;/a&gt;.  |  [optional] |
|**enableDeleteRecordAuditing** | **Boolean** | Indicates whether to audit the deletion of custom object records of this custom object definition.  Note that you must enable the **Custom Object Definition** audit trail setting in your Zuora tenant before auditing custom object record deletion. For more information, see &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Central_Platform/Tenant_Management/A_Administrator_Settings/Manage_Audit_Trail_Settings\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Manage audit trail settings&lt;/a&gt;.  |  [optional] |
|**filterable** | **List&lt;String&gt;** | The set of fields that are allowed to be queried on. Queries on non-filterable fields will be rejected. You can not change a non-filterable field to filterable. |  [optional] |
|**label** | **String** | A UI label for the custom object |  |
|**_object** | **String** | The API name of the custom object |  |
|**properties** | [**Map&lt;String, PostCustomObjectDefinitionFieldDefinitionRequest&gt;**](PostCustomObjectDefinitionFieldDefinitionRequest.md) |  |  [optional] |
|**relationships** | [**List&lt;PostCustomObjectDefinitionsRequestDefinitionRelationshipsInner&gt;**](PostCustomObjectDefinitionsRequestDefinitionRelationshipsInner.md) | An array of relationships with Zuora objects or other custom objects. You can add at most 2 &#x60;manyToOne&#x60; relationships when creating a custom field definition. |  [optional] |
|**required** | **List&lt;String&gt;** | The required fields of the custom object. You can change required fields to optional. However, you can only change optional fields to required on the custom objects with no records. |  [optional] |
|**unique** | **List&lt;String&gt;** | The fields with unique constraints. You can remove the unique constraint on a field. However, you can only add a unique constraint to a filterable field if the custom object contains no record. One custom object can have a maximum of five fields with unique constraints. |  [optional] |



