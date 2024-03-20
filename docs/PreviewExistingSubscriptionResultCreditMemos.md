

# PreviewExistingSubscriptionResultCreditMemos


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**creditMemoNumber** | **String** | The credit memo number. |  [optional] |
|**amount** | **Double** | Credit memo amount. |  [optional] |
|**amountWithoutTax** | **Double** | Credit memo amount minus tax. |  [optional] |
|**taxAmount** | **Double** | The tax amount of the credit memo. |  [optional] |
|**targetDate** | **LocalDate** | Date through which to calculate charges if a credit memo is generated, as yyyy-mm-dd. |  [optional] |
|**creditMemoItems** | [**List&lt;PreviewExistingSubscriptionCreditMemoItemResult&gt;**](PreviewExistingSubscriptionCreditMemoItemResult.md) | Container for credit memo items. |  [optional] |
|**status** | **String** | The status of the credit memo. |  [optional] |
|**isFromExistingCreditMemo** | **Boolean** | Indicates whether the credit memo information is from an existing credit memo. |  [optional] |



