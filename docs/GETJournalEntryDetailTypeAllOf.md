

# GETJournalEntryDetailTypeAllOf


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**accountingPeriodName** | **String** | Name of the accounting period that the journal entry belongs to.  |  [optional] |
|**aggregateCurrency** | **Boolean** | Returns true if the journal entry is aggregating currencies. That is, if the journal entry was created when the &#x60;Aggregate transactions with different currencies during a Journal Run&#x60; setting was configured to &#x60;Yes&#x60;. Otherwise, returns &#x60;false&#x60;.  |  [optional] |
|**currency** | **String** | Currency used.  |  [optional] |
|**homeCurrency** | **String** | Home currency used.  |  [optional] |
|**journalEntryDate** | **LocalDate** | Date of the journal entry.  |  [optional] |
|**journalEntryItems** | [**List&lt;GETJournalEntryItemType&gt;**](GETJournalEntryItemType.md) | Key name that represents the list of journal entry items.  |  [optional] |
|**notes** | **String** |  Additional information about this record. Character limit: 2,000  |  [optional] |
|**number** | **String** | Journal entry number in the format JE-00000001.  |  [optional] |
|**organizationLabel** | **String** | The organization that this object belongs to.  Note: This field is available only when the Multi-Org feature is enabled.  |  [optional] |
|**segments** | [**List&lt;GETJournalEntrySegmentType&gt;**](GETJournalEntrySegmentType.md) | List of segments that apply to the summary journal entry.  |  [optional] |
|**status** | [**StatusEnum**](#StatusEnum) | Status of journal entry.  |  [optional] |
|**success** | **Boolean** | Returns &#x60;true&#x60; if the request was processed successfully.  |  [optional] |
|**timePeriodEnd** | **LocalDate** | End date of time period included in the journal entry.  |  [optional] |
|**timePeriodStart** | **LocalDate** | Start date of time period included in the journal entry.  |  [optional] |
|**transactionType** | **String** | Transaction type of the transactions included in the summary journal entry.  |  [optional] |
|**transferDateTime** | **OffsetDateTime** | Date and time that transferredToAccounting was changed to &#x60;Yes&#x60;. This field is returned only when transferredToAccounting is &#x60;Yes&#x60;. Otherwise, this field is &#x60;null&#x60;.  |  [optional] |
|**transferredBy** | **String** | User ID of the person who changed transferredToAccounting to &#x60;Yes&#x60;. This field is returned only when transferredToAccounting is &#x60;Yes&#x60;. Otherwise, this field is &#x60;null&#x60;.  |  [optional] |
|**transferredToAccounting** | [**TransferredToAccountingEnum**](#TransferredToAccountingEnum) | Status shows whether the journal entry has been transferred to an accounting system.  |  [optional] |



## Enum: StatusEnum

| Name | Value |
|---- | -----|
| CREATED | &quot;Created&quot; |
| CANCELLED | &quot;Cancelled&quot; |



## Enum: TransferredToAccountingEnum

| Name | Value |
|---- | -----|
| FALSE | &quot;false&quot; |
| PROCESSING | &quot;Processing&quot; |
| TRUE | &quot;true&quot; |
| ERROR | &quot;Error&quot; |
| IGNORE | &quot;Ignore&quot; |



