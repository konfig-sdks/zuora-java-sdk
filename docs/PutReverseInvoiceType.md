

# PutReverseInvoiceType


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**applyEffectiveDate** | **LocalDate** | The date when the credit memo is applied to the invoice that will be reversed, in &#x60;yyyy-mm-dd&#x60; format. The effective date must be later than or equal to the memo date.  The default value is the date when you reverse the invoice and create the credit memo.  |  [optional] |
|**memoDate** | **LocalDate** | The date when the credit memo was created, in &#x60;yyyy-mm-dd&#x60; format. The memo date must be later than or equal to the invoice date.  The default value is the date when you reverse the invoice and create the credit memo.  |  [optional] |



