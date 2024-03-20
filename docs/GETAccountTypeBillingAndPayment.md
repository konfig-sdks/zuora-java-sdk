

# GETAccountTypeBillingAndPayment

Container for billing and payment information for the account.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**additionalEmailAddresses** | **List&lt;String&gt;** | A list of additional email addresses to receive email notifications.  |  [optional] |
|**autoPay** | **Boolean** | Whether future payments are automatically collected when they are due during a payment run.   |  [optional] |
|**billCycleDay** | **String** | Billing cycle day (BCD), the day of the month when a bill run generates invoices for the account.  |  [optional] |
|**currency** | **String** | A currency defined in the web-based UI administrative settings.  |  [optional] |
|**defaultPaymentMethodId** | **String** | ID of the default payment method for the account.  |  [optional] |
|**invoiceDeliveryPrefsEmail** | **Boolean** | Whether the customer wants to receive invoices through email.   |  [optional] |
|**invoiceDeliveryPrefsPrint** | **Boolean** | Whether the customer wants to receive printed invoices, such as through postal mail.  |  [optional] |
|**paymentGateway** | **String** | The name of the payment gateway instance. If null or left unassigned, the Account will use the Default Gateway.  |  [optional] |
|**paymentTerm** | **String** | A payment-terms indicator defined in the web-based UI administrative settings, e.g., \&quot;Net 30\&quot;.  |  [optional] |



