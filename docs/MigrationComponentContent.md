

# MigrationComponentContent

When a comparison is made between a source and target tenant, it sends a response to the user interface.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**description** | **String** |  |  [optional] |
|**attribute** | **String** |  |  [optional] |
|**componentType** | **String** | Type of selected components to be migrated. |  [optional] |
|**currentTargetResponse** | **Object** | Json node object contains metadata. |  [optional] |
|**disabled** | **String** |  |  [optional] |
|**errorMessage** | **String** | Error information. |  [optional] |
|**httpMethods** | **String** |  |  [optional] |
|**id** | **String** |  |  [optional] |
|**key** | **String** |  |  [optional] |
|**migratedOn** | **OffsetDateTime** | It is the time when migration is triggered. |  [optional] |
|**migrationId** | **String** | Migration ID. It is generated at the time of triggering deployment. |  [optional] |
|**pathPattern** | **String** | PathPattern of component. |  [optional] |
|**previousTargetResponse** | **Object** | Json node object contains metadata. |  [optional] |
|**result** | **String** | Returns the result details of Components. |  [optional] |
|**segregationKey** | **String** | Displays the differences between components. |  [optional] |
|**sourceResponse** | **Object** | Json node object contains metadata. |  [optional] |
|**status** | **String** | Returns the status of each component. |  [optional] |
|**updateStatus** | **String** | Updated Status. |  [optional] |



