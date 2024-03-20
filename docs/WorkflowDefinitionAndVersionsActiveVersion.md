

# WorkflowDefinitionAndVersionsActiveVersion

Information of the active version.  

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**description** | **String** | The description of the active version.  |  [optional] |
|**version** | **String** | The version number of the active version.  |  [optional] |
|**id** | **Integer** | The unique ID of the active version.  |  [optional] |
|**status** | **String** | The status of the active version.  |  [optional] |
|**type** | [**TypeEnum**](#TypeEnum) | The type of the active version. Currently the only valid value is &#39;Workflow::Setup&#39;.  |  [optional] |



## Enum: TypeEnum

| Name | Value |
|---- | -----|
| SETUP | &quot;Workflow::Setup&quot; |
| INSTANCE | &quot;Workflow::Instance&quot; |



