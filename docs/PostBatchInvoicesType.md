

# PostBatchInvoicesType


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**invoices** | [**List&lt;PostInvoiceType&gt;**](PostInvoiceType.md) | Container for standalone invoices.  |  [optional] |
|**useSingleTransaction** | **Boolean** | Whether a batch request is handled with a single transaction.  - &#x60;true&#x60; indicates that a batch request will be handled with a single transaction. - &#x60;false&#x60;  indicates that the standalone invoices to be created in a batch request will be handled with separated transactions.  If the field is set to &#x60;false&#x60;, a failure in the batch request will not cause the whole request to fail, so you have to retry the whole batch request.  |  [optional] |



