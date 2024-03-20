

# CatalogGroupResponse


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**description** | **String** | The description of the catalog group.  |  [optional] |
|**catalogGroupNumber** | **String** | The automatically generated number of the catalog group with the CG- perfix. For example, CG-00000001.  |  [optional] |
|**id** | **String** | The ID of the catalog group.  |  [optional] |
|**name** | **String** | The name of the catalog group.  |  [optional] |
|**productRatePlans** | [**List&lt;GETCatalogGroupProductRatePlanResponse&gt;**](GETCatalogGroupProductRatePlanResponse.md) | The list of product rate plans in the catalog group.  |  [optional] |
|**type** | [**TypeEnum**](#TypeEnum) | The type of the catalog group.  |  [optional] |



## Enum: TypeEnum

| Name | Value |
|---- | -----|
| GRADING | &quot;Grading&quot; |
| DISPLAY | &quot;Display&quot; |



