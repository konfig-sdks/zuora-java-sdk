

# PreviewExistingSubscriptionResponse


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**processId** | **String** | The ID of the process that handles the operation.  |  [optional] |
|**reasons** | [**List&lt;CommonResponseReasonsInner&gt;**](CommonResponseReasonsInner.md) |  |  [optional] |
|**requestId** | **UUID** | Unique identifier of the request.  |  [optional] |
|**success** | **Boolean** | Indicates whether the call succeeded.  |  [optional] |
|**invoices** | [**List&lt;PreviewExistingSubscriptionResultInvoices&gt;**](PreviewExistingSubscriptionResultInvoices.md) | Container for invoices. |  [optional] |
|**creditMemos** | [**List&lt;PreviewExistingSubscriptionResultCreditMemos&gt;**](PreviewExistingSubscriptionResultCreditMemos.md) | Container for credit memos.  **Note**: This field is only available if you have the Invoice Settlement feature enabled.  |  [optional] |



