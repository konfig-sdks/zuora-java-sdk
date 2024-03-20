

# ProcessingOptionsOrdersWithDelayedCapturePaymentElectronicPaymentOptions

Container for the electronic payment options. 

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**authTransactionId** | **String** | The authorization transaction ID from the payment gateway.  When you create a payment to capture the funds that have been authorized through [Create authorization](https://developer.zuora.com/api-references/api/operation/POST_CreateAuthorization/), pass in the &#x60;authTransactionId&#x60; field. It is highly recommended to also pass in &#x60;gatewayOrderId&#x60; that you used when authorizing the funds. &#x60;authTransactionId&#x60; is required, while &#x60;gatewayOrderId&#x60; is optional.  |  [optional] |
|**gatewayOrderId** | **String** | A merchant-specified natural key value that can be passed to the electronic payment gateway when a payment is created. If not specified, the payment number will be passed in instead.  Gateways check duplicates on the gateway order ID to ensure that the same transaction is not entered twice accidentally.   This ID can also be used to do reconciliation and tie the payment to a natural key in external systems. The source of this ID varies by merchant. Some merchants use shopping cart order IDs, and others use something different. Merchants use this ID to track transactions in their eCommerce systems.  When you create a payment to capture the funds that have been authorized through [Create authorization](https://developer.zuora.com/api-references/api/operation/POST_CreateAuthorization/), pass in the &#x60;authTransactionId&#x60; field. It is highly recommended to also pass in &#x60;gatewayOrderId&#x60; that you used when authorizing the funds. &#x60;authTransactionId&#x60; is required, while &#x60;gatewayOrderId&#x60; is optional.  |  [optional] |
|**paymentGatewayId** | **String** | Specifies the ID of a payment gateway to override the default gateway.  If &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Payments/Payment_gateway_integrations/Payment_Gateway_Routing\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Payment Gateway Routing&lt;/a&gt; is enabled:    - If this field is not specified, gateway routing rules will be invoked.   - If this field is specified, the specified gateway will be used to process the payment.  If Payment Gateway Routing is disabled:   - If this field is not specified, the default payment gateway will be used to process the payment. The default gateway of the customer account takes precedence over the default gateway of the tenant.   - If this field is specified, the specified gateway will be used to process the payment.  |  [optional] |
|**paymentMethodId** | **String** | Specifies an electronic payment method. It can be one that has already been associated with an invoice owner, or an orphan payment method, which is not associated with any invoice owner. For an orphan payment method, this operation will then associate it with the account that this order will be created under.  |  [optional] |



