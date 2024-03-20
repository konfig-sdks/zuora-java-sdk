

# GETPaymentRunDataTransactionElementResponse


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**amount** | **Double** | The total amount of the newly generated payment.  **Note:** This field is only available if &#x60;type&#x60; is &#x60;Payment&#x60;.  |  [optional] |
|**appliedAmount** | **Double** | The amount allocated to this data record.  |  [optional] |
|**errorCode** | **String** | The error code of the response.  **Note:** This field is only available if &#x60;type&#x60; is &#x60;Payment&#x60;.  |  [optional] |
|**errorMessage** | **String** | The detailed information of the error response.  **Note:** This field is only available if &#x60;type&#x60; is &#x60;Payment&#x60;.  |  [optional] |
|**id** | **String** | The ID of the current transaction.  |  [optional] |
|**status** | [**StatusEnum**](#StatusEnum) | The status of the newly generated payment.  **Note:** This field is only available if &#x60;type&#x60; is &#x60;Payment&#x60;.  |  [optional] |
|**type** | [**TypeEnum**](#TypeEnum) | The type of the current transaction.  |  [optional] |



## Enum: StatusEnum

| Name | Value |
|---- | -----|
| PROCESSED | &quot;Processed&quot; |
| PROCESSING | &quot;Processing&quot; |
| ERROR | &quot;Error&quot; |



## Enum: TypeEnum

| Name | Value |
|---- | -----|
| PAYMENT | &quot;Payment&quot; |
| CREDITMEMO | &quot;CreditMemo&quot; |
| UNAPPLIEDPAYMENT | &quot;UnappliedPayment&quot; |
| CREDITBALANCEADJUSTMENT | &quot;CreditBalanceAdjustment&quot; |



