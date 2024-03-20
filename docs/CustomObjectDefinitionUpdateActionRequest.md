

# CustomObjectDefinitionUpdateActionRequest


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**description** | **String** | Optional property for &#x60;updateObject&#x60; action |  [optional] |
|**enableCreateRecordAuditing** | **Boolean** | Optional property for &#x60;updateObject&#x60; action.  Indicates whether to audit the creation of custom object records of this custom object definition.  Note that you must enable the **Custom Object Definition** audit trail setting in your Zuora tenant before auditing custom object record creation. For more information, see &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Central_Platform/Tenant_Management/A_Administrator_Settings/Manage_Audit_Trail_Settings\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Manage audit trail settings&lt;/a&gt;.  |  [optional] |
|**enableDeleteRecordAuditing** | **Boolean** | Optional property for &#x60;updateObject&#x60; action.  Indicates whether to audit the deletion of custom object records of this custom object definition.  Note that you must enable the **Custom Object Definition** audit trail setting in your Zuora tenant before auditing custom object record deletion. For more information, see &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Central_Platform/Tenant_Management/A_Administrator_Settings/Manage_Audit_Trail_Settings\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Manage audit trail settings&lt;/a&gt;.  |  [optional] |
|**field** | [**UpdateCustomObjectCusotmField**](UpdateCustomObjectCusotmField.md) |  |  [optional] |
|**label** | **String** | Optional property for &#x60;updateObject&#x60; action |  [optional] |
|**namespace** | **String** | The namespace of the custom object definition to be updated |  |
|**_object** | **String** | The API name of the custom object definition to be updated |  |
|**relationship** | [**CustomObjectDefinitionUpdateActionRequestRelationship**](CustomObjectDefinitionUpdateActionRequestRelationship.md) |  |  [optional] |
|**type** | [**TypeEnum**](#TypeEnum) | The type of the updating action on a custom object definition |  |



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



