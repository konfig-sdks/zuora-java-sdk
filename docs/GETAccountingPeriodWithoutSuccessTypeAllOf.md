

# GETAccountingPeriodWithoutSuccessTypeAllOf


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**createdBy** | **String** | ID of the user who created the accounting period.  |  [optional] |
|**createdOn** | **OffsetDateTime** | Date and time when the accounting period was created.  |  [optional] |
|**endDate** | **LocalDate** | The end date of the accounting period.  |  [optional] |
|**fileIds** | [**GETAccountingPeriodWithoutSuccessTypeAllOfFileIds**](GETAccountingPeriodWithoutSuccessTypeAllOfFileIds.md) |  |  [optional] |
|**fiscalYear** | **String** | Fiscal year of the accounting period.  |  [optional] |
|**fiscalQuarter** | **Long** |  |  [optional] |
|**id** | **String** | ID of the accounting period.  |  [optional] |
|**name** | **String** | Name of the accounting period.  |  [optional] |
|**notes** | **String** | Any optional notes about the accounting period.  |  [optional] |
|**organizationLabels** | [**List&lt;GETProductTypeAllOfOrganizationLabels&gt;**](GETProductTypeAllOfOrganizationLabels.md) | The organization(s) that the object belongs to.   Note: This field is available only when the Multi-Org feature is enabled.              |  [optional] |
|**runTrialBalanceEnd** | **OffsetDateTime** | Date and time that the trial balance was completed. If the trial balance status is &#x60;Pending&#x60;, &#x60;Processing&#x60;, or &#x60;Error&#x60;, this field is &#x60;null&#x60;.  |  [optional] |
|**runTrialBalanceErrorMessage** | **String** | If trial balance status is Error, an error message is returned in this field.  |  [optional] |
|**runTrialBalanceStart** | **OffsetDateTime** | Date and time that the trial balance was run. If the trial balance status is &#x60;Pending&#x60;, this field is &#x60;null&#x60;.  |  [optional] |
|**runTrialBalanceStatus** | **String** | Status of the trial balance for the accounting period. Possible values:  * &#x60;Pending&#x60; * &#x60;Processing&#x60; * &#x60;Completed&#x60; * &#x60;Error&#x60;  |  [optional] |
|**startDate** | **LocalDate** | The start date of the accounting period.  |  [optional] |
|**status** | **String** | Status of the accounting period. Possible values:  * &#x60;Open&#x60; * &#x60;PendingClose&#x60; * &#x60;Closed&#x60;  |  [optional] |
|**updatedBy** | **String** | D of the user who last updated the accounting period.  |  [optional] |
|**updatedOn** | **OffsetDateTime** | Date and time when the accounting period was last updated.  |  [optional] |



