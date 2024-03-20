

# POSTJournalEntryType


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**accountingPeriodName** | **String** | Name of the accounting period. The open-ended accounting period is named &#x60;Open-Ended&#x60;.  |  |
|**currency** | **String** | The type of currency used. Currency must be active.  |  |
|**journalEntryDate** | **LocalDate** | Date of the journal entry.  |  |
|**journalEntryItems** | [**List&lt;POSTJournalEntryItemType&gt;**](POSTJournalEntryItemType.md) | Key name that represents the list of journal entry items.  |  |
|**notes** | **String** | The number associated with the revenue event.  Character limit: 2,000  |  [optional] |
|**organizationLabel** | **String** | Name of the organization that the journal entry belongs to.    This field is only required when you have already turned on Multi-Org feature.      |  [optional] |
|**segments** | [**List&lt;POSTJournalEntrySegmentType&gt;**](POSTJournalEntrySegmentType.md) | List of segments that apply to the summary journal entry.  |  [optional] |
|**transferredToAccounting** | [**TransferredToAccountingEnum**](#TransferredToAccountingEnum) | Status shows whether the journal entry has been transferred to an accounting system.  |  [optional] |



## Enum: TransferredToAccountingEnum

| Name | Value |
|---- | -----|
| FALSE | &quot;false&quot; |
| PROCESSING | &quot;Processing&quot; |
| TRUE | &quot;true&quot; |
| ERROR | &quot;Error&quot; |
| IGNORE | &quot;Ignore&quot; |



