

# CreateOrderNewAccountAllOf

The information of the new account to be created with the order. Note that this actually specifies the invoice owner account of the subscriptions included in this order. To create the new account, either a **creditCard** structure or the **hpmCreditCardPaymentMethodId** field (but not both) should be provided. The one provided becomes the default payment method for this account. If the credit card information is declined or can't be verified, then the account is not created. 

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**accountNumber** | **String** |  |  [optional] |
|**additionalEmailAddresses** | **String** | List of additional email addresses to receive emailed invoices. Values should be a comma-separated list of email addresses.  |  [optional] |
|**allowInvoiceEdit** | **Boolean** | Indicates if associated invoices can be edited. Values are:   * &#x60;true&#x60; * &#x60;false&#x60; (default)  |  [optional] |
|**autoPay** | **Boolean** | Specifies whether future payments are to be automatically billed when they are due. Possible values are &#x60;true&#x60;, &#x60;false&#x60;. |  [optional] |
|**batch** | **String** | **Note**: By default, you have 50 configurable account batches. To increase the limit to 200 batches, you must have the &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Central_Platform/Performance_Booster_Elite\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Performance Booster Elite&lt;/a&gt; package.  |  [optional] |
|**billCycleDay** | **Integer** | Day of the month that the account prefers billing periods to begin on. If set to 0, the bill cycle day will be set as \&quot;AutoSet\&quot;. |  |
|**billToContact** | [**BillToContactPostOrder**](BillToContactPostOrder.md) |  |  |
|**communicationProfileId** | **String** |  |  [optional] |
|**creditCard** | [**CreditCard**](CreditCard.md) |  |  [optional] |
|**creditMemoTemplateId** | **String** | **Note:** This field is only available if you have [Invoice Settlement](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/Invoice_Settlement) enabled. The Invoice Settlement feature is generally available as of Zuora Billing Release 296 (March 2021). This feature includes Unapplied Payments, Credit and Debit Memo, and Invoice Item Settlement. If you want to enable Invoice Settlement, see [Invoice Settlement Enablement and Checklist Guide](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/Invoice_Settlement/Invoice_Settlement_Migration_Checklist_and_Guide) for more information.  The unique ID of the credit memo template, configured in **Billing Settings** &gt; **Manage Billing Document Configuration** through the Zuora UI. For example, 2c92c08a6246fdf101626b1b3fe0144b.  |  [optional] |
|**crmId** | **String** |  |  [optional] |
|**currency** | **String** | 3 uppercase character currency code.  For payment method authorization, if the &#x60;paymentMethod&#x60; &gt; &#x60;currencyCode&#x60; field is specified, &#x60;currencyCode&#x60; is used. Otherwise, this &#x60;currency&#x60; field is used for payment method authorization. If no currency is specified for the account, the default currency of the account is then used.  |  |
|**customFields** | **Map&lt;String, Object&gt;** | Container for custom fields of an Account object.  |  [optional] |
|**customerServiceRepName** | **String** | Name of the account&#39;s customer service representative, if applicable.  |  [optional] |
|**debitMemoTemplateId** | **String** | **Note:** This field is only available if you have [Invoice Settlement](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/Invoice_Settlement) enabled. The Invoice Settlement feature is generally available as of Zuora Billing Release 296 (March 2021). This feature includes Unapplied Payments, Credit and Debit Memo, and Invoice Item Settlement. If you want to enable Invoice Settlement, see [Invoice Settlement Enablement and Checklist Guide](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/Invoice_Settlement/Invoice_Settlement_Migration_Checklist_and_Guide) for more information.  The unique ID of the debit memo template, configured in **Billing Settings** &gt; **Manage Billing Document Configuration** through the Zuora UI. For example, 2c92c08d62470a8501626b19d24f19e2.  |  [optional] |
|**hpmCreditCardPaymentMethodId** | **String** | The ID of the payment method associated with this account. The payment method specified for this field will be set as the default payment method of the account.  If the &#x60;autoPay&#x60; field is set to &#x60;true&#x60;, you must provide the credit card payment method ID for either this field or the &#x60;creditCard&#x60; field, but not both.  For the Credit Card Reference Transaction payment method, you can specify the payment method ID in this field or use the &#x60;paymentMethod&#x60; field to create a CC Reference Transaction payment method for an account.  |  [optional] |
|**invoiceDeliveryPrefsEmail** | **Boolean** | Specifies whether to turn on the invoice delivery method &#39;Email&#39; for the new account.  Values are:   * &#x60;true&#x60; (default). Turn on the invoice delivery method &#39;Email&#39; for the new account. * &#x60;false&#x60;. Turn off the invoice delivery method &#39;Email&#39; for the new account.  |  [optional] |
|**invoiceDeliveryPrefsPrint** | **Boolean** | Specifies whether to turn on the invoice delivery method &#39;Print&#39; for the new account. Values are:   * &#x60;true&#x60;. Turn on the invoice delivery method &#39;Print&#39; for the new account. * &#x60;false&#x60; (default). Turn off the invoice delivery method &#39;Print&#39; for the new account.  |  [optional] |
|**invoiceTemplateId** | **String** |  |  [optional] |
|**name** | **String** |  |  |
|**notes** | **String** |  |  [optional] |
|**organizationLabel** | **String** | Name of the organization that the account belongs to.    This field is only required when you have already turned on Multi-Org feature.      |  [optional] |
|**parentId** | **String** | Identifier of the parent customer account for this Account object. Use this field if you have &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Billing/Subscriptions/Customer_Accounts/A_Customer_Account_Introduction#Customer_Hierarchy\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Customer Hierarchy&lt;/a&gt; enabled. |  [optional] |
|**partnerAccount** | **Boolean** | Whether the customer account is a partner, distributor, or reseller.    You can set this field to &#x60;true&#x60; if you have business with distributors or resellers, or operating in B2B model to manage numerous subscriptions through concurrent API requests. After this field is set to &#x60;true&#x60;, the calculation of account metrics is performed asynchronously during operations such as subscription creation, order changes, invoice generation, and payments.   **Note**: This field is available only if you have the &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Manage_customer_accounts/AAA_Overview_of_customer_accounts/Reseller_Account\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Reseller Account&lt;/a&gt; feature enabled.  |  [optional] |
|**paymentGateway** | **String** |  |  [optional] |
|**paymentMethod** | **Object** |  |  [optional] |
|**paymentTerm** | **String** | **Note**: If you want to specify a payment term when creating a new account, you must set a value in this field. If you do not set a value in this field, Zuora will use &#x60;Due Upon Receipt&#x60; as the value instead of the default value set in **Billing Settings** &gt; **Payment Terms** from Zuora UI.  |  [optional] |
|**purchaseOrderNumber** | **String** | The number of the purchase order associated with this account. Purchase order information generally comes from customers.  |  [optional] |
|**salesRep** | **String** | The name of the sales representative associated with this account, if applicable.  |  [optional] |
|**sequenceSetId** | **String** | The ID of the sequence set to assign to the customer account.   The billing documents to generate for this account will adopt the prefix and starting document number configured in the sequence set.  |  [optional] |
|**soldToContact** | [**SoldToContactPostOrder**](SoldToContactPostOrder.md) |  |  [optional] |
|**soldToSameAsBillTo** | **Boolean** | Whether the sold-to contact and bill-to contact are the same entity.   The created account has the same bill-to contact and sold-to contact entity only when all the following conditions are met in the request body:  - This field is set to &#x60;true&#x60;.  - A bill-to contact is specified. - No sold-to contact is specified.  |  [optional] |
|**taxInfo** | [**TaxInfo**](TaxInfo.md) |  |  [optional] |



