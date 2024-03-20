

# GetBillRunResponseType


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**autoEmail** | **Boolean** | Whether to automatically send emails after Auto-Post is complete.  |  [optional] |
|**autoPost** | **Boolean** | Whether to automatically post the bill run after the bill run is created.  |  [optional] |
|**autoRenewal** | **Boolean** | Whether to automatically renew auto-renew subscriptions that are up for renewal.  |  [optional] |
|**batches** | **List&lt;String&gt;** | The batch of accounts for this bill run, this field can not exist with &#x60;billRunFilters&#x60; together.  **Values:** &#x60;AllBatches&#x60; or an array of &#x60;Batch&#x60;*n* where *n* is a number between 1 and 50, for example, &#x60;Batch7&#x60;.  |  [optional] |
|**billCycleDay** | **String** | The day of the bill cycle, this field is only valid when &#x60;batches&#x60; is specified.  **Values:**  - &#x60;AllBillCycleDays&#x60; or one of numbers 1 - 31 for an ad-hoc bill run - &#x60;AllBillCycleDays&#x60;, one of numbers 1 - 31, or &#x60;AsRunDay&#x60; for a scheduled bill run  |  [optional] |
|**billRunFilters** | [**List&lt;BillRunFilterResponseType&gt;**](BillRunFilterResponseType.md) | The target account or subscriptions for this bill run.  |  [optional] |
|**billRunNumber** | **String** | The number of the bill run.  |  [optional] |
|**chargeTypeToExclude** | [**List&lt;ChargeTypeToExcludeEnum&gt;**](#List&lt;ChargeTypeToExcludeEnum&gt;) | The types of the charges to be excluded from the generation of billing documents.  |  [optional] |
|**createdById** | **String** | The ID of the user who created the bill run.  |  [optional] |
|**createdDate** | **OffsetDateTime** | The date and time when the bill run was created.  |  [optional] |
|**id** | **String** | The unqie ID of the bill run.  |  [optional] |
|**invoiceDate** | **LocalDate** | The invoice date for this bill run, only valid for ad-hoc bill runs.  |  [optional] |
|**invoiceDateOffset** | **Integer** | The offset compared to bill run execution date, only valid for scheduled bill runs.  |  [optional] |
|**name** | **String** | The name of the bill run.  |  [optional] |
|**noEmailForZeroAmountInvoice** | **Boolean** | Whether to suppress emails for invoices with zero total amount generated in this bill run after the bill run is complete.   |  [optional] |
|**organizationLabels** | [**List&lt;GETProductTypeAllOfOrganizationLabels&gt;**](GETProductTypeAllOfOrganizationLabels.md) | The organization(s) that the run is created for.   Note: This field is available only when the Multi-Org feature is enabled.  |  [optional] |
|**schedule** | [**BillRunScheduleResponseType**](BillRunScheduleResponseType.md) |  |  [optional] |
|**scheduledExecutionTime** | **OffsetDateTime** | The scheduled execution time for a bill run.  |  [optional] |
|**status** | [**StatusEnum**](#StatusEnum) | The status of the bill run.  |  [optional] |
|**targetDate** | **LocalDate** | The target date for this bill run, only valid for ad-hoc bill runs.  |  [optional] |
|**targetDateOffset** | **Integer** | The offset compared to bill run execution date, only valid for scheduled bill runs.  |  [optional] |
|**updatedById** | **String** | The ID of the user who last updated the bill run.  |  [optional] |
|**updatedDate** | **OffsetDateTime** | The date and time when the bill run was last updated.  |  [optional] |



## Enum: List&lt;ChargeTypeToExcludeEnum&gt;

| Name | Value |
|---- | -----|
| ONETIME | &quot;OneTime&quot; |
| RECURRING | &quot;Recurring&quot; |
| USAGE | &quot;Usage&quot; |



## Enum: StatusEnum

| Name | Value |
|---- | -----|
| PENDING | &quot;Pending&quot; |
| PROCESSING | &quot;Processing&quot; |
| COMPLETED | &quot;Completed&quot; |
| ERROR | &quot;Error&quot; |
| CANCELED | &quot;Canceled&quot; |
| POSTED | &quot;Posted&quot; |
| POSTINPROGRESS | &quot;PostInProgress&quot; |
| CANCELINPROGRESS | &quot;CancelInProgress&quot; |
| REMOVEINPROGRESS | &quot;RemoveInProgress&quot; |
| PAUSED | &quot;Paused&quot; |



