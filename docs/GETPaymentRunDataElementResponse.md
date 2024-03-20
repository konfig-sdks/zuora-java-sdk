

# GETPaymentRunDataElementResponse


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**accountId** | **String** | The customer account ID specified in the &#x60;data&#x60; field when creating the payment run.  |  [optional] |
|**accountNumber** | **String** | The customer account number specified in the &#x60;data&#x60; field when creating the payment run.  |  [optional] |
|**amount** | **Double** | The amount specified in the &#x60;data&#x60; field when creating the payment run. &#x60;null&#x60; is returned if it was not specified.  |  [optional] |
|**amountCollected** | **Double** | The amount that is collected.  |  [optional] |
|**amountToCollect** | **Double** | The amount to be collected.  |  [optional] |
|**comment** | **String** | The comment specified in the &#x60;data&#x60; field when creating the payment run. &#x60;null&#x60; is returned if it was not specified.  |  [optional] |
|**currency** | **String** | This field is only available if support for standalone payments is enabled.  The currency of the standalone payment. The currency of the standalone payment can be different from the payment currency defined in the customer account settings.  |  [optional] |
|**documentId** | **String** | The billing document ID specified in the &#x60;data&#x60; field when creating the payment run. &#x60;null&#x60; is returned if it was not specified.  |  [optional] |
|**documentNumber** | **String** | The billing document number specified in the &#x60;data&#x60; field when creating the payment run. &#x60;null&#x60; is returned if it was not specified.  |  [optional] |
|**documentType** | [**DocumentTypeEnum**](#DocumentTypeEnum) | The billing document type specified in the &#x60;data&#x60; field when creating the payment run. &#x60;null&#x60; is returned if it was not specified.  |  [optional] |
|**errorCode** | **String** | The error code of the response.  |  [optional] |
|**errorMessage** | **String** | The detailed information of the error response.  |  [optional] |
|**paymentGatewayId** | **String** | The payment gateway ID specified in the &#x60;data&#x60; field when creating the payment run. &#x60;null&#x60; is returned if it was not specified.  |  [optional] |
|**paymentMethodId** | **String** | The payment method ID specified in the &#x60;data&#x60; field when creating the payment run. &#x60;null&#x60; is returned if it was not specified.  |  [optional] |
|**result** | [**ResultEnum**](#ResultEnum) | Indicates whether the data is processed successfully or not.  |  [optional] |
|**standalone** | **Boolean** | This field is only available if the support for standalone payment is enabled.  The value &#x60;true&#x60; indicates this is a standalone payment that is created and processed in Zuora through Zuora gateway integration but will be settled outside of Zuora. No settlement data will be created. The standalone payment cannot be applied, unapplied, or transferred.  |  [optional] |
|**transactions** | [**List&lt;GETPaymentRunDataTransactionElementResponse&gt;**](GETPaymentRunDataTransactionElementResponse.md) | Container for transactions that apply to the current request. Each element contains an array of the settlement/payment applied to the record.  |  [optional] |



## Enum: DocumentTypeEnum

| Name | Value |
|---- | -----|
| INVOICE | &quot;Invoice&quot; |
| DEBITMEMO | &quot;DebitMemo&quot; |



## Enum: ResultEnum

| Name | Value |
|---- | -----|
| PROCESSED | &quot;Processed&quot; |
| ERROR | &quot;Error&quot; |



