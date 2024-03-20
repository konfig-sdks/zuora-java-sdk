

# GETProductRatePlanTypeAllOf


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**description** | **String** | Rate plan description.  |  [optional] |
|**effectiveEndDate** | **LocalDate** | Final date the rate plan is active, as &#x60;yyyy-mm-dd&#x60;. After this date, the rate plan status is &#x60;Expired&#x60;.  |  [optional] |
|**effectiveStartDate** | **LocalDate** | First date the rate plan is active (i.e., available to be subscribed to), as &#x60;yyyy-mm-dd&#x60;.  Before this date, the status is &#x60;NotStarted&#x60;.  |  [optional] |
|**grade** | **Double** | The grade of the product rate plan.  **Note**: This field is in the **Early Adopter** phase. We are actively soliciting feedback from a small set of early adopters before releasing it as generally available. If you want to join this early adopter program, submit a request at [Zuora Global Support](http://support.zuora.com/).  |  [optional] |
|**id** | **String** | Unique product rate-plan ID.  |  [optional] |
|**name** | **String** | Name of the product rate-plan charge. (Not required to be unique.)  |  [optional] |
|**productRatePlanCharges** | [**List&lt;GETProductRatePlanChargeType&gt;**](GETProductRatePlanChargeType.md) | Field attributes describing the product rate plan charges:  |  [optional] |
|**productRatePlanNumber** | **String** | The natural key of the product rate plan.    |  [optional] |
|**status** | [**StatusEnum**](#StatusEnum) | The status of the product rate plan.  |  [optional] |



## Enum: StatusEnum

| Name | Value |
|---- | -----|
| ACTIVE | &quot;Active&quot; |
| EXPIRED | &quot;Expired&quot; |
| NOTSTARTED | &quot;NotStarted&quot; |



