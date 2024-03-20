

# AccountData

The information of the account that you are to create through the \"Sign up\" operation. 

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**accountNumber** | **String** |  |  [optional] |
|**autoPay** | **Boolean** | Specifies whether future payments are to be automatically billed when they are due. Possible values are &#x60;true&#x60;, &#x60;false&#x60;. |  [optional] |
|**batch** | **String** | **Note**: By default, you have 50 configurable account batches. To increase the limit to 200 batches, you must have the &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Central_Platform/Performance_Booster_Elite\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Performance Booster Elite&lt;/a&gt; package.  |  [optional] |
|**billCycleDay** | **Integer** | Day of the month that the account prefers billing periods to begin on. If set to 0, the bill cycle day will be set as \&quot;AutoSet\&quot;. |  |
|**billToContact** | [**ContactInfo**](ContactInfo.md) |  |  |
|**communicationProfileId** | **String** |  |  [optional] |
|**creditMemoTemplateId** | **String** | **Note:** This field is only available if you have [Invoice Settlement](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/Invoice_Settlement) enabled. The Invoice Settlement feature is generally available as of Zuora Billing Release 296 (March 2021). This feature includes Unapplied Payments, Credit and Debit Memo, and Invoice Item Settlement. If you want to enable Invoice Settlement, see [Invoice Settlement Enablement and Checklist Guide](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/Invoice_Settlement/Invoice_Settlement_Migration_Checklist_and_Guide) for more information.  The unique ID of the credit memo template, configured in **Billing Settings** &gt; **Manage Billing Document Configuration** through the Zuora UI. For example, 2c92c08a6246fdf101626b1b3fe0144b.  |  [optional] |
|**crmId** | **String** |  |  [optional] |
|**currency** | **String** | 3 uppercase character currency code.  For payment method authorization, if the &#x60;paymentMethod&#x60; &gt; &#x60;currencyCode&#x60; field is specified, &#x60;currencyCode&#x60; is used. Otherwise, this &#x60;currency&#x60; field is used for payment method authorization. If no currency is specified for the account, the default currency of the account is then used.  |  |
|**customFields** | **Map&lt;String, Object&gt;** | Container for custom fields.  |  [optional] |
|**debitMemoTemplateId** | **String** | **Note:** This field is only available if you have [Invoice Settlement](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/Invoice_Settlement) enabled. The Invoice Settlement feature is generally available as of Zuora Billing Release 296 (March 2021). This feature includes Unapplied Payments, Credit and Debit Memo, and Invoice Item Settlement. If you want to enable Invoice Settlement, see [Invoice Settlement Enablement and Checklist Guide](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/Invoice_Settlement/Invoice_Settlement_Migration_Checklist_and_Guide) for more information.  The unique ID of the debit memo template, configured in **Billing Settings** &gt; **Manage Billing Document Configuration** through the Zuora UI. For example, 2c92c08d62470a8501626b19d24f19e2.  |  [optional] |
|**invoiceTemplateId** | **String** |  |  [optional] |
|**name** | **String** |  |  |
|**notes** | **String** |  |  [optional] |
|**paymentMethod** | [**SignUpPaymentMethod**](SignUpPaymentMethod.md) |  |  [optional] |
|**paymentTerm** | **String** |  |  [optional] |
|**purchaseOrderNumber** | **String** | The number of the purchase order associated with this account. Purchase order information generally comes from customers.  |  [optional] |
|**sequenceSetId** | **String** | The ID of the billing document sequence set to assign to the customer account.   The billing documents to generate for this account will adopt the prefix and starting document number configured in the sequence set.  |  [optional] |
|**soldToContact** | [**ContactInfo**](ContactInfo.md) |  |  [optional] |
|**taxInfo** | [**SignUpTaxInfo**](SignUpTaxInfo.md) |  |  [optional] |



