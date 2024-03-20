

# PUTRefundTypeAllOfFinanceInformation

Container for the finance information related to the refund. 

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**bankAccountAccountingCode** | **String** | The accounting code that maps to a bank account in your accounting system.  |  [optional] |
|**transferredToAccounting** | [**TransferredToAccountingEnum**](#TransferredToAccountingEnum) | Whether the payment was transferred to an external accounting system. Use this field for integration with accounting systems, such as NetSuite.   |  [optional] |
|**unappliedPaymentAccountingCode** | **String** | The accounting code for the unapplied payment.  |  [optional] |



## Enum: TransferredToAccountingEnum

| Name | Value |
|---- | -----|
| PROCESSING | &quot;Processing&quot; |
| TRUE | &quot;true&quot; |
| FALSE | &quot;false&quot; |
| ERROR | &quot;Error&quot; |
| IGNORE | &quot;Ignore&quot; |



