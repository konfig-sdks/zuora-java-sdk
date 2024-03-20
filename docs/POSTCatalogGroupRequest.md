

# POSTCatalogGroupRequest


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**description** | **String** | The description of the catalog group.  |  [optional] |
|**name** | **String** | The unique name of the catalog group.  |  [optional] |
|**productRatePlans** | [**List&lt;POSTorPUTCatalogGroupAddProductRatePlan&gt;**](POSTorPUTCatalogGroupAddProductRatePlan.md) | The list of product rate plans to be added to the catalog group.  |  [optional] |
|**type** | [**TypeEnum**](#TypeEnum) | The type of the catalog group.   |  [optional] |



## Enum: TypeEnum

| Name | Value |
|---- | -----|
| GRADING | &quot;Grading&quot; |
| DISPLAY | &quot;Display&quot; |



