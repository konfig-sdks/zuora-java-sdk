

# CreateSubscriptionNewSubscriptionOwnerAccount

Information about a new account that will own the subscription. Only available if you have enabled the Owner Transfer feature.  **Note:** The Owner Transfer feature is in **Limited Availability**. If you wish to have access to the feature, submit a request at [Zuora Global Support](http://support.zuora.com/).  If you do not set this field or the `subscriptionOwnerAccountNumber` field, the account that owns the order will also own the subscription. Zuora will return an error if you set this field and the `subscriptionOwnerAccountNumber` field. 

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**accountNumber** | **String** | Account number. For example, A00000001.  |  [optional] |
|**autoPay** | **Boolean** | Specifies whether future payments are automatically billed when they are due.  |  [optional] |
|**batch** | **String** | Name of the billing batch that the account belongs to. For example, Batch1.  |  [optional] |
|**billCycleDay** | **Integer** | Day of the month that the account prefers billing periods to begin on. If set to 0, the bill cycle day will be set as \&quot;AutoSet\&quot;.  |  |
|**billToContact** | [**BillToContact**](BillToContact.md) |  |  |
|**communicationProfileId** | **String** | Internal identifier of the communication profile that Zuora uses when sending notifications to the account&#39;s contacts.  |  [optional] |
|**creditCard** | [**CreditCard**](CreditCard.md) |  |  [optional] |
|**crmId** | **String** | External identifier of the account in a CRM system.  |  [optional] |
|**currency** | **String** | ISO 3-letter currency code (uppercase). For example, USD.  |  |
|**customFields** | **Map&lt;String, Object&gt;** | Container for custom fields of an Account object.  |  [optional] |
|**hpmCreditCardPaymentMethodId** | **String** | The ID of the payment method associated with this account. The payment method specified for this field will be set as the default payment method of the account.  If the &#x60;autoPay&#x60; field is set to &#x60;true&#x60;, you must provide the credit card payment method ID for either this field or the &#x60;creditCard&#x60; field, but not both.  For the Credit Card Reference Transaction payment method, you can specify the payment method ID in this field or use the &#x60;paymentMethod&#x60; field to create a CC Reference Transaction payment method for an account.  |  [optional] |
|**invoiceDeliveryPrefsEmail** | **Boolean** | Specifies whether to turn on the invoice delivery method &#39;Email&#39; for the new account.  Values are:   * &#x60;true&#x60; (default). Turn on the invoice delivery method &#39;Email&#39; for the new account. * &#x60;false&#x60;. Turn off the invoice delivery method &#39;Email&#39; for the new account.           |  [optional] |
|**invoiceDeliveryPrefsPrint** | **Boolean** | Specifies whether to turn on the invoice delivery method &#39;Print&#39; for the new account. Values are:   * &#x60;true&#x60;. Turn on the invoice delivery method &#39;Print&#39; for the new account. * &#x60;false&#x60; (default). Turn off the invoice delivery method &#39;Print&#39; for the new account.  |  [optional] |
|**invoiceTemplateId** | **String** | Internal identifier of the invoice template that Zuora uses when generating invoices for the account.  |  [optional] |
|**name** | **String** | Account name.  |  |
|**notes** | **String** | Notes about the account. These notes are only visible to Zuora users.  |  [optional] |
|**parentId** | **String** | Identifier of the parent customer account for this Account object. Use this field if you have &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Billing/Subscriptions/Customer_Accounts/A_Customer_Account_Introduction#Customer_Hierarchy\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Customer Hierarchy&lt;/a&gt; enabled. |  [optional] |
|**paymentGateway** | **String** | The payment gateway that Zuora uses when processing electronic payments and refunds for the account. If you do not specify this field or if the value of this field is null, Zuora uses your default payment gateway.  |  [optional] |
|**paymentMethod** | **Object** |  |  [optional] |
|**paymentTerm** | **String** | Name of the payment term associated with the account. For example, \&quot;Net 30\&quot;. The payment term determines the due dates of invoices.  |  [optional] |
|**soldToContact** | [**SoldToContact**](SoldToContact.md) |  |  [optional] |
|**taxInfo** | [**TaxInfo**](TaxInfo.md) |  |  [optional] |



