

# PUTRefundTypeAllOf


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**comment** | **String** | Comments about the refund.  |  [optional] |
|**financeInformation** | [**PUTRefundTypeAllOfFinanceInformation**](PUTRefundTypeAllOfFinanceInformation.md) |  |  [optional] |
|**reasonCode** | **String** | A code identifying the reason for the transaction. The value must be an existing reason code or empty. If you do not specify a value, Zuora uses the default reason code.  |  [optional] |
|**referenceId** | **String** | The transaction ID returned by the payment gateway. Use this field to reconcile refunds between your gateway and Zuora Payments.  You can only update the reference ID for external refunds.  |  [optional] |



