

# PutReverseCreditMemoType


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**applyEffectiveDate** | **LocalDate** | The date when the to-be-reversed credit memo is applied to the newly generated debit memo, in &#x60;yyyy-mm-dd&#x60; format. The effective date must be later than or equal to the memo date.  The default value is the date when you reverse the credit memo and create the debit memo.  |  [optional] |
|**memoDate** | **LocalDate** | The date when the debit memo is created, in &#x60;yyyy-mm-dd&#x60; format. The memo date must be later than or equal to the credit memo&#39;s memo date.  The default value is the date when you reverse the credit memo and create the debit memo.  |  [optional] |



