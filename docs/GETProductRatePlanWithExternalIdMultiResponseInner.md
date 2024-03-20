

# GETProductRatePlanWithExternalIdMultiResponseInner


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**description** | **String** | The short description of the product rate plan.  |  [optional] |
|**externalIdSourceSystem** | **String** | The combination of &#x60;externallyManagedPlanId&#x60; and &#x60;externalIdSourceSystem&#x60; is the unique identifier for the rate plan purchased on a third-party store. This field is used to represent a subscription rate plan created through third-party stores.  |  [optional] |
|**effectiveEndDate** | **LocalDate** | The end date of the product rate plan.  |  [optional] |
|**effectiveStartDate** | **LocalDate** | The start date of the product rate plan.  |  [optional] |
|**externallyManagedPlanIds** | **List&lt;String&gt;** | The unique identifier for the product rate plan in a third-party store. This field is used to represent a rate plan created through third-party stores.  |  [optional] |
|**grade** | **Double** | The grade of the product rate plan.  **Note**: This field is in the **Early Adopter** phase. We are actively soliciting feedback from a small set of early adopters before releasing it as generally available. If you want to join this early adopter program, submit a request at [Zuora Global Support](http://support.zuora.com/).  |  [optional] |
|**id** | **String** | The unique product rate plan ID.  |  [optional] |
|**name** | **String** | The name of the product rate plan.  |  [optional] |
|**organizationLabels** | [**List&lt;GETCatalogGroupProductRatePlanResponseOrganizationLabelsInner&gt;**](GETCatalogGroupProductRatePlanResponseOrganizationLabelsInner.md) | The organization(s) that the object belongs to.   Note: This field is available only when the Multi-Org feature is enabled.              |  [optional] |
|**status** | [**StatusEnum**](#StatusEnum) | The status of the product rate plan.   |  [optional] |
|**success** | **Boolean** | Returns &#x60;true&#x60; if the request was processed successfully.  |  [optional] |



## Enum: StatusEnum

| Name | Value |
|---- | -----|
| ACTIVE | &quot;Active&quot; |
| EXPIRED | &quot;Expired&quot; |
| NOTSTARTED | &quot;NotStarted&quot; |



