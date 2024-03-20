

# DebitMemoCollectResponse


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**appliedCreditMemos** | [**List&lt;DebitMemoCollectResponseAppliedCreditMemos&gt;**](DebitMemoCollectResponseAppliedCreditMemos.md) | The information about which credit memo applied to the specific debit memo.  |  [optional] |
|**appliedPayments** | [**List&lt;DebitMemoCollectResponseAppliedPayments&gt;**](DebitMemoCollectResponseAppliedPayments.md) | The information about which payment applied to the specific debit memo.  |  [optional] |
|**debitMemo** | [**DebitMemoCollectResponseAllOfDebitMemo**](DebitMemoCollectResponseAllOfDebitMemo.md) |  |  [optional] |
|**organizationLabel** | **String** | The organization that this object belongs to.  Note: This field is available only when the Multi-Org feature is enabled.  |  [optional] |
|**processedPayment** | [**DebitMemoCollectResponseAllOfProcessedPayment**](DebitMemoCollectResponseAllOfProcessedPayment.md) |  |  [optional] |
|**success** | **Boolean** | Returns &#x60;true&#x60; if the request was processed successfully. |  [optional] |



