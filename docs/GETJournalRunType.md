

# GETJournalRunType


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**aggregateCurrency** | **Boolean** |  |  [optional] |
|**executedOn** | **OffsetDateTime** | Date and time the journal run was executed.  |  [optional] |
|**journalEntryDate** | **LocalDate** | Date of the journal entry.  |  [optional] |
|**number** | **String** | Journal run number.  |  [optional] |
|**organizationLabels** | [**List&lt;GETCatalogGroupProductRatePlanResponseOrganizationLabelsInner&gt;**](GETCatalogGroupProductRatePlanResponseOrganizationLabelsInner.md) | The organization(s) that the object belongs to.   Note: This field is available only when the Multi-Org feature is enabled.  |  [optional] |
|**segmentationRuleName** | **String** | Name of GL segmentation rule used in the journal run.  |  [optional] |
|**status** | [**StatusEnum**](#StatusEnum) | Status of the journal run.   |  [optional] |
|**success** | **Boolean** | Returns &#x60;true&#x60; if the request was processed successfully.  |  [optional] |
|**targetEndDate** | **LocalDate** | The target end date of the journal run.  |  [optional] |
|**targetStartDate** | **LocalDate** | The target start date of the journal run.  |  [optional] |
|**totalJournalEntryCount** | **Long** | Total number of journal entries in the journal run.  |  [optional] |
|**transactionTypes** | [**List&lt;GETJournalRunTransactionType&gt;**](GETJournalRunTransactionType.md) | Transaction types included in the journal run.  |  [optional] |



## Enum: StatusEnum

| Name | Value |
|---- | -----|
| PENDING | &quot;Pending&quot; |
| PROCESSING | &quot;Processing&quot; |
| COMPLETED | &quot;Completed&quot; |
| ERROR | &quot;Error&quot; |
| CANCELINPROGRESS | &quot;CancelInprogress&quot; |
| CANCELLED | &quot;Cancelled&quot; |
| DELETEINPROGRESS | &quot;DeleteInprogress&quot; |



