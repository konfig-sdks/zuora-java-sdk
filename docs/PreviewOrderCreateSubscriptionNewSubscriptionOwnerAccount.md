

# PreviewOrderCreateSubscriptionNewSubscriptionOwnerAccount

Information about a new account that will own the subscription. Only available if you have enabled the Owner Transfer feature.  **Note:** The Owner Transfer feature is in **Limited Availability**. If you wish to have access to the feature, submit a request at [Zuora Global Support](http://support.zuora.com/).  If you do not set this field or the `subscriptionOwnerAccountNumber` field, the account that owns the order will also own the subscription. Zuora will return an error if you set this field and the `subscriptionOwnerAccountNumber` field. 

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**accountNumber** | **String** | Account number. For example, A00000001.  |  [optional] |
|**additionalEmailAddresses** | **String** | List of additional email addresses to receive emailed invoices. Values should be a comma-separated list of email addresses.  |  [optional] |
|**allowInvoiceEdit** | **Boolean** | Indicates if associated invoices can be edited. Values are:   * &#x60;true&#x60; * &#x60;false&#x60; (default)  |  [optional] |
|**autoPay** | **Boolean** | Specifies whether future payments are automatically billed when they are due.  |  [optional] |
|**batch** | **String** | Name of the billing batch that the account belongs to. For example, Batch1.  |  [optional] |
|**billCycleDay** | **Integer** | Day of the month that the account prefers billing periods to begin on. If set to 0, the bill cycle day will be set as \&quot;AutoSet\&quot;.  |  |
|**billToContact** | [**BillToContactPostOrder**](BillToContactPostOrder.md) |  |  |
|**communicationProfileId** | **String** | Internal identifier of the communication profile that Zuora uses when sending notifications to the account&#39;s contacts.  |  [optional] |
|**creditCard** | [**CreditCard**](CreditCard.md) |  |  [optional] |
|**creditMemoTemplateId** | **String** | **Note:** This field is only available if you have [Invoice Settlement](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/Invoice_Settlement) enabled. The Invoice Settlement feature is generally available as of Zuora Billing Release 296 (March 2021). This feature includes Unapplied Payments, Credit and Debit Memo, and Invoice Item Settlement. If you want to enable Invoice Settlement, see [Invoice Settlement Enablement and Checklist Guide](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/Invoice_Settlement/Invoice_Settlement_Migration_Checklist_and_Guide) for more information.  The unique ID of the credit memo template, configured in **Billing Settings** &gt; **Manage Billing Document Configuration** through the Zuora UI. For example, 2c92c08a6246fdf101626b1b3fe0144b.  |  [optional] |
|**crmId** | **String** | External identifier of the account in a CRM system.  |  [optional] |
|**currency** | **String** | ISO 3-letter currency code (uppercase). For example, USD.  |  |
|**customFields** | **Map&lt;String, Object&gt;** | Container for custom fields of an Account object.  |  [optional] |
|**customerServiceRepName** | **String** | Name of the account&#39;s customer service representative, if applicable.  |  [optional] |
|**debitMemoTemplateId** | **String** | **Note:** This field is only available if you have [Invoice Settlement](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/Invoice_Settlement) enabled. The Invoice Settlement feature is generally available as of Zuora Billing Release 296 (March 2021). This feature includes Unapplied Payments, Credit and Debit Memo, and Invoice Item Settlement. If you want to enable Invoice Settlement, see [Invoice Settlement Enablement and Checklist Guide](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/Invoice_Settlement/Invoice_Settlement_Migration_Checklist_and_Guide) for more information.  The unique ID of the debit memo template, configured in **Billing Settings** &gt; **Manage Billing Document Configuration** through the Zuora UI. For example, 2c92c08d62470a8501626b19d24f19e2.  |  [optional] |
|**hpmCreditCardPaymentMethodId** | **String** | The ID of the payment method associated with this account. The payment method specified for this field will be set as the default payment method of the account.  If the &#x60;autoPay&#x60; field is set to &#x60;true&#x60;, you must provide the credit card payment method ID for either this field or the &#x60;creditCard&#x60; field, but not both.  For a specified credit card payment method, it is recommended that [the support for stored credential transactions](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/L_Payment_Methods/Stored_credential_transactions) for this payment method is already enabled.  |  [optional] |
|**invoiceDeliveryPrefsEmail** | **Boolean** | Specifies whether to turn on the invoice delivery method &#39;Email&#39; for the new account.  Values are:   * &#x60;true&#x60; (default). Turn on the invoice delivery method &#39;Email&#39; for the new account. * &#x60;false&#x60;. Turn off the invoice delivery method &#39;Email&#39; for the new account.           |  [optional] |
|**invoiceDeliveryPrefsPrint** | **Boolean** | Specifies whether to turn on the invoice delivery method &#39;Print&#39; for the new account. Values are:   * &#x60;true&#x60;. Turn on the invoice delivery method &#39;Print&#39; for the new account. * &#x60;false&#x60; (default). Turn off the invoice delivery method &#39;Print&#39; for the new account.  |  [optional] |
|**invoiceTemplateId** | **String** | Internal identifier of the invoice template that Zuora uses when generating invoices for the account.  |  [optional] |
|**name** | **String** | Account name.  |  |
|**notes** | **String** | Notes about the account. These notes are only visible to Zuora users.  |  [optional] |
|**parentId** | **String** | Identifier of the parent customer account for this Account object. Use this field if you have &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Billing/Subscriptions/Customer_Accounts/A_Customer_Account_Introduction#Customer_Hierarchy\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Customer Hierarchy&lt;/a&gt; enabled. |  [optional] |
|**paymentGateway** | **String** | The payment gateway that Zuora uses when processing electronic payments and refunds for the account. If you do not specify this field or if the value of this field is null, Zuora uses your default payment gateway.  |  [optional] |
|**paymentMethod** | **Object** |  |  [optional] |
|**paymentTerm** | **String** | Name of the payment term associated with the account. For example, \&quot;Net 30\&quot;. The payment term determines the due dates of invoices.  |  [optional] |
|**purchaseOrderNumber** | **String** | The number of the purchase order associated with this account. Purchase order information generally comes from customers.  |  [optional] |
|**salesRep** | **String** | The name of the sales representative associated with this account, if applicable.  |  [optional] |
|**soldToContact** | [**SoldToContactPostOrder**](SoldToContactPostOrder.md) |  |  [optional] |
|**taxInfo** | [**TaxInfo**](TaxInfo.md) |  |  [optional] |



