

# PUTAccountTypeAllOf


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**additionalEmailAddresses** | **List&lt;String&gt;** | A list of additional email addresses to receive email notifications. Use commas to separate email addresses.  |  [optional] |
|**autoPay** | **Boolean** | Whether future payments are to be automatically billed when they are due.   |  [optional] |
|**batch** | **String** | The alias name given to a batch. A string of 50 characters or less.  **Note**: By default, you have 50 configurable account batches. To increase the limit to 200 batches, you must have the &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Central_Platform/Performance_Booster_Elite\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Performance Booster Elite&lt;/a&gt; package.  |  [optional] |
|**billCycleDay** | **Integer** | Sets the bill cycle day (BCD) for the charge. The BCD determines which day of the month the customer is billed. Values: Any activated system-defined bill cycle day （&#x60;1&#x60;-&#x60;31&#x60;）  |  [optional] |
|**billToContact** | [**PUTAccountTypeBillToContact**](PUTAccountTypeBillToContact.md) |  |  [optional] |
|**communicationProfileId** | **String** | The ID of the communication profile that this account is linked to.  You can provide either or both of the &#x60;communicationProfileId&#x60; and &#x60;profileNumber&#x60; fields.  If both are provided, the request will fail if they do not refer to the same communication profile.  |  [optional] |
|**creditMemoTemplateId** | **String** | **Note:** This field is only available if you have [Invoice Settlement](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/Invoice_Settlement) enabled. The Invoice Settlement feature is generally available as of Zuora Billing Release 296 (March 2021). This feature includes Unapplied Payments, Credit and Debit Memo, and Invoice Item Settlement. If you want to enable Invoice Settlement, see [Invoice Settlement Enablement and Checklist Guide](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/Invoice_Settlement/Invoice_Settlement_Migration_Checklist_and_Guide) for more information.  The unique ID of the credit memo template, configured in **Billing Settings** &gt; **Manage Billing Document Configuration** through the Zuora UI. For example, 2c92c08a6246fdf101626b1b3fe0144b.  |  [optional] |
|**crmId** | **String** | CRM account ID for the account, up to 100 characters.  |  [optional] |
|**customerServiceRepName** | **String** | Name of the account’s customer service representative, if applicable.  |  [optional] |
|**debitMemoTemplateId** | **String** | **Note:** This field is only available if you have [Invoice Settlement](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/Invoice_Settlement) enabled. The Invoice Settlement feature is generally available as of Zuora Billing Release 296 (March 2021). This feature includes Unapplied Payments, Credit and Debit Memo, and Invoice Item Settlement. If you want to enable Invoice Settlement, see [Invoice Settlement Enablement and Checklist Guide](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/Invoice_Settlement/Invoice_Settlement_Migration_Checklist_and_Guide) for more information.  The unique ID of the debit memo template, configured in **Billing Settings** &gt; **Manage Billing Document Configuration** through the Zuora UI. For example, 2c92c08d62470a8501626b19d24f19e2.  |  [optional] |
|**defaultPaymentMethodId** | **String** | ID of the default payment method for the account.  Values: a valid ID for an existing payment method.  |  [optional] |
|**einvoiceProfile** | [**PUTAccountEinvoiceProfile**](PUTAccountEinvoiceProfile.md) |  |  [optional] |
|**invoiceDeliveryPrefsEmail** | **Boolean** | Whether the customer wants to receive invoices through email.   The default value is &#x60;false&#x60;.  |  [optional] |
|**invoiceDeliveryPrefsPrint** | **Boolean** | Whether the customer wants to receive printed invoices, such as through postal mail.  The default value is &#x60;false&#x60;.  |  [optional] |
|**invoiceTemplateId** | **String** | Invoice template ID, configured in Billing Settings in the Zuora UI.  |  [optional] |
|**name** | **String** | Account name, up to 255 characters.  |  [optional] |
|**notes** | **String** | A string of up to 65,535 characters.  |  [optional] |
|**parentId** | **String** | Identifier of the parent customer account for this Account object. The length is 32 characters. Use this field if you have &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Billing/Subscriptions/Customer_Accounts/A_Customer_Account_Introduction#Customer_Hierarchy\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Customer Hierarchy&lt;/a&gt; enabled. |  [optional] |
|**partnerAccount** | **Boolean** | Whether the customer account is a partner, distributor, or reseller.    You can set this field to &#x60;true&#x60; if you have business with distributors or resellers, or operating in B2B model to manage numerous subscriptions through concurrent API requests. After this field is set to &#x60;true&#x60;, the calculation of account metrics is performed asynchronously during operations such as subscription creation, order changes, invoice generation, and payments.   **Note**: This field is available only if you have the &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Manage_customer_accounts/AAA_Overview_of_customer_accounts/Reseller_Account\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Reseller Account&lt;/a&gt; feature enabled.  |  [optional] |
|**paymentGateway** | **String** | The name of the payment gateway instance. If null or left unassigned, the Account will use the Default Gateway.  |  [optional] |
|**paymentTerm** | **String** | Payment terms for this account. Possible values are &#x60;Due Upon Receipt&#x60;, &#x60;Net 30&#x60;, &#x60;Net 60&#x60;, &#x60;Net 90&#x60;. |  [optional] |
|**profileNumber** | **String** | The number of the communication profile that this account is linked to.  You can provide either or both of the &#x60;communicationProfileId&#x60; and &#x60;profileNumber&#x60; fields.  If both are provided, the request will fail if they do not refer to the same communication profile.  |  [optional] |
|**purchaseOrderNumber** | **String** | The purchase order number provided by your customer for services, products, or both purchased. |  [optional] |
|**salesRep** | **String** | The name of the sales representative associated with this account, if applicable. Maximum of 50 characters. |  [optional] |
|**sequenceSetId** | **String** | The ID of the billing document sequence set to assign to the customer account.   The billing documents to generate for this account will adopt the prefix and starting document number configured in the sequence set.  If a customer account has no assigned billing document sequence set, billing documents generated for this account adopt the prefix and starting document number from the default sequence set.  |  [optional] |
|**soldToContact** | [**PUTAccountTypeSoldToContact**](PUTAccountTypeSoldToContact.md) |  |  [optional] |
|**tagging** | **String** |  |  [optional] |
|**taxInfo** | [**POSTAccountTypeAllOfTaxInfo**](POSTAccountTypeAllOfTaxInfo.md) |  |  [optional] |



