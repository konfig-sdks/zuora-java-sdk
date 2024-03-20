

# ProxyGetPaymentTransactionLog


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**avSResponseCode** | **String** | The response code returned by the payment gateway referring to the AVS international response of the payment transaction.  |  [optional] |
|**batchId** | **String** | The ID of the batch used to send the transaction if the request was sent in a batch.  |  [optional] |
|**cvVResponseCode** | **String** | The response code returned by the payment gateway referring to the CVV international response of the payment transaction.  |  [optional] |
|**gateway** | **String** | The name of the payment gateway used to transact the current payment transaction log.  |  [optional] |
|**gatewayReasonCode** | **String** | The code returned by the payment gateway for the payment. This code is gateway-dependent.  |  [optional] |
|**gatewayReasonCodeDescription** | **String** | The message returned by the payment gateway for the payment. This message is gateway-dependent.   |  [optional] |
|**gatewayState** | [**GatewayStateEnum**](#GatewayStateEnum) | The state of the transaction at the payment gateway.  |  [optional] |
|**gatewayTransactionType** | [**GatewayTransactionTypeEnum**](#GatewayTransactionTypeEnum) | The type of the transaction, either making a payment, or canceling a payment.   |  [optional] |
|**id** | **String** | The ID of the payment transaction log.  |  [optional] |
|**paymentId** | **String** | The ID of the payment wherein the payment transaction log was recorded.   |  [optional] |
|**requestString** | **String** | The payment transaction request string sent to the payment gateway.   |  [optional] |
|**responseString** | **String** | The payment transaction response string returned by the payment gateway.   |  [optional] |
|**transactionDate** | **OffsetDateTime** | The transaction date when the payment was performed.   |  [optional] |
|**transactionId** | **String** | The transaction ID returned by the payment gateway. This field is used to reconcile payment transactions between the payment gateway and records in Zuora.  |  [optional] |



## Enum: GatewayStateEnum

| Name | Value |
|---- | -----|
| MARKEDFORSUBMISSION | &quot;MarkedForSubmission&quot; |
| SUBMITTED | &quot;Submitted&quot; |
| SETTLED | &quot;Settled&quot; |
| NOTSUBMITTED | &quot;NotSubmitted&quot; |
| FAILEDTOSETTLE | &quot;FailedToSettle&quot; |



## Enum: GatewayTransactionTypeEnum

| Name | Value |
|---- | -----|
| AUTHORIZATION | &quot;Authorization&quot; |
| SALE | &quot;Sale&quot; |
| VOID | &quot;Void&quot; |
| INQUIRY | &quot;Inquiry&quot; |
| VOIDAUTH | &quot;VoidAuth&quot; |



