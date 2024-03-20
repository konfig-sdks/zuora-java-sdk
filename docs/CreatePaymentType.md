

# CreatePaymentType


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**accountId** | **String** | The ID of the customer account that the payment is created for.  |  [optional] |
|**accountNumber** | **String** | The number of the customer account that the payment is created for, such as &#x60;A00000001&#x60;.  You can specify either &#x60;accountNumber&#x60; or &#x60;accountId&#x60; for a customer account. If both of them are specified, they must refer to the same customer account.  |  [optional] |
|**amount** | **Double** | The total amount of the payment.  |  |
|**authTransactionId** | **String** | The authorization transaction ID from the payment gateway. Use this field for electronic payments, such as credit cards.  When you create a payment for capturing the authorized funds, it is highly recommended to pass in the gatewayOrderId that you used when authorizing the funds by using the [Create authorization](https://www.zuora.com/developer/api-references/api/operation/POST_CreateAuthorization) operation, together with the &#x60;authTransactionId&#x60; field.  The following payment gateways support this field:   - Adyen Integration v2.0   - CyberSource 1.28   - CyberSource 1.97   - CyberSource 2.0   - Chase Paymentech Orbital   - Ingenico ePayments   - SlimPay   - Stripe v2   - Verifi Global Payment Gateway   - WePay Payment Gateway Integration  |  [optional] |
|**comment** | **String** | Additional information related to the payment.  |  [optional] |
|**currency** | **String** | When Standalone Payment is not enabled, the &#x60;currency&#x60; of the payment must be the same as the payment currency defined in the customer account settings through Zuora UI. But if you have the [Multiple Currencies](https://knowledgecenter.zuora.com/Zuora_Billing/Bill_your_customers/Flexible_Billing/Multiple_Currencies) feature enabled, you can have a different payment currency.  When Standalone Payment is enabled and &#x60;standalone&#x60; is &#x60;true&#x60;, the &#x60;currency&#x60; of the standalone payment can be different from the payment currency defined in the customer account settings. The amount will not be summed up to the account balance or key metrics regardless of currency.  |  |
|**customRates** | [**List&lt;PaymentWithCustomRatesType&gt;**](PaymentWithCustomRatesType.md) | It contains Home currency and Reporting currency custom rates currencies. The maximum number of items is 2 (you can pass the Home currency item or Reporting currency item or both).  **Note**: The API custom rate feature is permission controlled.  |  [optional] |
|**debitMemos** | [**List&lt;PaymentDebitMemoApplicationCreateRequestType&gt;**](PaymentDebitMemoApplicationCreateRequestType.md) | Container for debit memos. The maximum number of debit memos is 1,000.  |  [optional] |
|**effectiveDate** | **LocalDate** | The date when the payment takes effect, in &#x60;yyyy-mm-dd&#x60; format.  **Note:**   - This field is required for only electronic payments. It&#39;s an optional field for external payments.   - When specified, this field must be set to the date of today.   - When applying or transferring payments, this field must be later than or equal to the maximum effective date of the payment.  |  [optional] |
|**financeInformation** | [**CreatePaymentTypeAllOfFinanceInformation**](CreatePaymentTypeAllOfFinanceInformation.md) |  |  [optional] |
|**gatewayId** | **String** | The ID of the gateway instance that processes the payment. The ID must be a valid gateway instance ID and this gateway must support the specific payment method.  - If &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Payments/Payment_gateway_integrations/Payment_Gateway_Routing\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Payment Gateway Routing&lt;/a&gt; is enabled, when creating electronic payments, this field is optional.      - If this field is not specified, gateway routing rules will be invoked.     - If this field is specified, the specified gateway will be used to process the payment.  - If Payment Gateway Routing is disabled, when creating electronic payments, this field is required.  - When creating external payments, this field is optional.  Use the same gateway instance if both &#x60;paymentGatewayNumber&#x60; and &#x60;gatewayId&#x60; are sent in the request.  |  [optional] |
|**gatewayOptions** | [**CreatePaymentTypeAllOfGatewayOptions**](CreatePaymentTypeAllOfGatewayOptions.md) |  |  [optional] |
|**gatewayOrderId** | **String** | A merchant-specified natural key value that can be passed to the electronic payment gateway when a payment is created. If not specified, the payment number will be passed in instead.  Gateways check duplicates on the gateway order ID to ensure that the merchant do not accidentally enter the same transaction twice. This ID can also be used to do reconciliation and tie the payment to a natural key in external systems. The source of this ID varies by merchant. Some merchants use their shopping cart order IDs, and others use something different. Merchants use this ID to track transactions in their eCommerce systems.  When you create a payment for capturing the authorized funds, it is highly recommended to pass in the gatewayOrderId that you used when authorizing the funds by using the [Create authorization](https://www.zuora.com/developer/api-references/api/operation/POST_CreateAuthorization) operation, together with the &#x60;authTransactionId&#x60; field.  |  [optional] |
|**invoices** | [**List&lt;PaymentInvoiceApplicationCreateRequestType&gt;**](PaymentInvoiceApplicationCreateRequestType.md) | Container for invoices. The maximum number of invoices is 1,000.  |  [optional] |
|**mitTransactionSource** | [**MitTransactionSourceEnum**](#MitTransactionSourceEnum) | Payment transaction source used to differentiate the transaction source in Stored Credential Transaction framework.   - &#x60;C_Unscheduled&#x60;: Cardholder-initiated transaction (CIT) that does not occur on scheduled or regularly occurring dates.   - &#x60;M_Recurring&#x60;: Merchant-initiated transaction (MIT) that occurs at regular intervals.   - &#x60;M_Unscheduled&#x60;: Merchant-initiated transaction (MIT) that does not occur on scheduled or regularly occurring dates.   - &#x60;M_MOTO&#x60;: Mail Order Telephone Order (MOTO) payment transaction. This option is only available for credit card payments on Stripe v2. See [Overview of Stripe payment gateway integration](https://knowledgecenter.zuora.com/Zuora_Collect/Payment_gateway_integrations/Supported_payment_gateways/Stripe_Payment_Gateway/A_Overview_of_Stripe_payment_gateway_integration) for more information.  |  [optional] |
|**paymentGatewayNumber** | **String** | The natural key for the payment gateway.   Use the same gateway instance if both &#x60;paymentGatewayNumber&#x60; and &#x60;gatewayId&#x60; are sent in the request.  |  [optional] |
|**paymentMethodId** | **String** | The unique ID of the payment method that the customer used to make the payment.   If no payment method ID is specified in the request body, the default payment method for the customer account is used automatically. If the default payment method is different from the type of payments that you want to create, an error occurs.  |  [optional] |
|**paymentMethodType** | **String** | The type of the payment method that the customer used to make the payment.   Specify this value when you are creating an external payment method. If both &#x60;paymentMethodType&#x60; and &#x60;paymentMethodId&#x60; are specified, only the &#x60;paymentMethodId&#x60; value is used to create the payment.  |  [optional] |
|**paymentOption** | [**List&lt;PaymentSchedulePaymentOptionFields&gt;**](PaymentSchedulePaymentOptionFields.md) | Container for the paymentOption items, which describe the transactional level rules for processing payments. Currently, only the Gateway Options type is supported.  Here is an example: &#x60;&#x60;&#x60; \&quot;paymentOption\&quot;: [   {     \&quot;type\&quot;: \&quot;GatewayOptions\&quot;,     \&quot;detail\&quot;: {       \&quot;SecCode\&quot;:\&quot;WEB\&quot;     }   } ] &#x60;&#x60;&#x60;  &#x60;paymentOption&#x60; of the payment schedule takes precedence over &#x60;paymentOption&#x60; of the payment schedule item.  You can use this field or the &#x60;gatewayOptions&#x60; field to pass the Gateway Options fields supported by a payment gateway. However, the Gateway Options fields passed through the &#x60;paymentOption&#x60; field will be stored in the Payment Option object and can be easily retrieved.  |  [optional] |
|**paymentScheduleKey** | **String** | The unique ID or the number of the payment schedule to be linked with the payment. See [Link payments to payment schedules](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/Payment_Schedules/Link_payments_with_payment_schedules) for more information. |  [optional] |
|**prepayment** | **Boolean** | Indicates whether the payment will be used as a reserved payment. See [Prepaid Cash with Drawdown](https://knowledgecenter.zuora.com/Zuora_Billing/Billing_and_Invoicing/JA_Advanced_Consumption_Billing/Prepaid_Cash_with_Drawdown) for more information.  |  [optional] |
|**referenceId** | **String** | The transaction ID returned by the payment gateway. Use this field to reconcile payments between your gateway and Zuora Payments.  |  [optional] |
|**softDescriptor** | **String** | A payment gateway-specific field that maps to Zuora for the gateways, Orbital, Vantiv and Verifi. |  [optional] |
|**softDescriptorPhone** | **String** | A payment gateway-specific field that maps to Zuora for the gateways, Orbital, Vantiv and Verifi. |  [optional] |
|**standalone** | **Boolean** | This field is only available if support for standalone payments is enabled.  Specify &#x60;true&#x60; to create a standalone payment that will be processed in Zuora through Zuora gateway integration but will be settled outside of Zuora.  When &#x60;standalone&#x60; is set to &#x60;true&#x60;:   - &#x60;accountId&#x60;, &#x60;amount&#x60;, &#x60;currency&#x60;, and &#x60;type&#x60; are required.    - &#x60;type&#x60; must be &#x60;Electronic&#x60;.   - &#x60;currency&#x60; of the payment can be different from the payment currency in the customer account settings.   - The amount will not be summed up into the account balance and key metrics regardless of the payment currency.   - No settlement data will be created.   - Either the applied amount or the unapplied amount of the payment is zero.   - The standalone payment cannot be applied, unapplied, or transferred.  Specify &#x60;false&#x60; to create an ordinary payment that will be created, processed, and settled in Zuora. The &#x60;currency&#x60; of an ordinary payment must be the same as the currency in the customer account settings.  |  [optional] |
|**type** | [**TypeEnum**](#TypeEnum) | The type of the payment.  **Note**:  If you specify the type as &#x60;Electronic&#x60;, you must specify the value for &#x60;accountId&#x60; or &#x60;accountNumber&#x60;.  |  |
|**integrationIdNS** | **String** | ID of the corresponding object in NetSuite. Only available if you have installed the [Zuora Connector for NetSuite](https://www.zuora.com/connect/app/?appId&#x3D;265).  |  [optional] |
|**integrationStatusNS** | **String** | Status of the payment&#39;s synchronization with NetSuite. Only available if you have installed the [Zuora Connector for NetSuite](https://www.zuora.com/connect/app/?appId&#x3D;265).  |  [optional] |
|**originNS** | **String** | Origin of the corresponding object in NetSuite. Only available if you have installed the [Zuora Connector for NetSuite](https://www.zuora.com/connect/app/?appId&#x3D;265).  |  [optional] |
|**syncDateNS** | **String** | Date when the payment was synchronized with NetSuite. Only available if you have installed the [Zuora Connector for NetSuite](https://www.zuora.com/connect/app/?appId&#x3D;265).  |  [optional] |
|**transactionNS** | **String** | Related transaction in NetSuite. Only available if you have installed the [Zuora Connector for NetSuite](https://www.zuora.com/connect/app/?appId&#x3D;265).  |  [optional] |



## Enum: MitTransactionSourceEnum

| Name | Value |
|---- | -----|
| C_UNSCHEDULED | &quot;C_Unscheduled&quot; |
| M_RECURRING | &quot;M_Recurring&quot; |
| M_UNSCHEDULED | &quot;M_Unscheduled&quot; |
| M_MOTO | &quot;M_MOTO&quot; |



## Enum: TypeEnum

| Name | Value |
|---- | -----|
| EXTERNAL | &quot;External&quot; |
| ELECTRONIC | &quot;Electronic&quot; |



