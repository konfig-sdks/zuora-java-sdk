

# GETCatalogGroupProductRatePlanResponse


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**description** | **String** | The description of the product rate plan.  |  [optional] |
|**effectiveEndDate** | **String** | The effective end Date of the product rate plan.  |  [optional] |
|**effectiveStartDate** | **String** | The effective start date of the product rate plan.  |  [optional] |
|**grade** | **Double** | The grade of the product rate plan.  |  [optional] |
|**id** | **String** | The ID of the product rate plan.  |  [optional] |
|**name** | **String** | The name of the product rate plan.  |  [optional] |
|**organizationLabels** | [**List&lt;GETCatalogGroupProductRatePlanResponseOrganizationLabelsInner&gt;**](GETCatalogGroupProductRatePlanResponseOrganizationLabelsInner.md) | The organization(s) that the object belongs to.   Note: This field is available only when the Multi-Org feature is enabled.              |  [optional] |
|**status** | [**StatusEnum**](#StatusEnum) | The status of the product rate plan.  |  [optional] |



## Enum: StatusEnum

| Name | Value |
|---- | -----|
| ACTIVE | &quot;Active&quot; |
| EXPIRED | &quot;Expired&quot; |
| NOTSTARTED | &quot;NotStarted&quot; |



