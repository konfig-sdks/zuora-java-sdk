

# POSTCreatePaymentSessionRequest


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**accountId** | **String** | The ID of the customer account in Zuora that is associated with this payment method.  |  |
|**amount** | **Double** | The amount of the payment.  This field is required if &#x60;processPayment&#x60; is &#x60;true&#x60;.  |  [optional] |
|**authAmount** | **Double** | The authorization amount for the payment method. Specify a value greater than 0.  This field is required if &#x60;processPayment&#x60; is false.  |  [optional] |
|**currency** | **String** | The currency of the payment in the format of the three-character ISO currency code.  |  |
|**paymentGateway** | **String** | The ID of the payment gateway instance configured in Zuora that will process the payment, such as &#x60;e884322ab8c711edab030242ac120004&#x60;.  |  |
|**processPayment** | **Boolean** | Indicate whether a payment should be processed after creating the payment method.  If this field is set to &#x60;true&#x60;, you must specify the &#x60;amount&#x60; field.  If this field is set to &#x60;false&#x60;, you must specify the &#x60;authAmount&#x60; field. The payment method will be verified through the payment gateway instance specified in the &#x60;paymentGateway&#x60; field.  |  |



