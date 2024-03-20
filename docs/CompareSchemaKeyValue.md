

# CompareSchemaKeyValue

When a comparison is made between a source and target tenant, it sends a response to the user interface.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**difference** | **Map&lt;String, List&lt;String&gt;&gt;** | Returns the different components list. |  [optional] |
|**response** | [**List&lt;MigrationComponentContent&gt;**](MigrationComponentContent.md) | Provides the total reponse of the components. |  [optional] |
|**segregationKeys** | **List&lt;String&gt;** | Provides separation of components. |  [optional] |



