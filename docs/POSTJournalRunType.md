

# POSTJournalRunType


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**accountingPeriodName** | **String** | Name of the accounting period.  This field determines the target start and end dates of the journal run.  Required if you do not include &#x60;targetStartDate&#x60; and &#x60;targetEndDate&#x60;.  |  [optional] |
|**journalEntryDate** | **LocalDate** | Date of the journal entry.  |  |
|**organizationLabels** | [**List&lt;GETCatalogGroupProductRatePlanResponseOrganizationLabelsInner&gt;**](GETCatalogGroupProductRatePlanResponseOrganizationLabelsInner.md) | The organizations that this run is created for.   For each item in the array, either the &#x60;organizationId&#x60; or the &#x60;organizationName&#x60; field is required.  This field is only required when you have already turned on Multi-Org feature.  |  [optional] |
|**targetEndDate** | **LocalDate** | The target end date of the journal run.  If you include &#x60;accountingPeriodName&#x60;, the &#x60;targetEndDate&#x60; must be empty or the same as the end date of the accounting period specified in &#x60;accountingPeriodName&#x60;.  |  [optional] |
|**targetStartDate** | **LocalDate** | The target start date of the journal run.  Required if you include targetEndDate.  If you include &#x60;accountingPeriodName&#x60;, the &#x60;targetStartDate&#x60; must be empty or the same as the start date of the accounting period specified in &#x60;accountingPeriodName&#x60;.  |  [optional] |
|**transactionTypes** | [**List&lt;POSTJournalRunTransactionType&gt;**](POSTJournalRunTransactionType.md) | Transaction types included in the journal run.  You can include one or more transaction types.  |  |



