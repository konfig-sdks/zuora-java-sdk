

# GETAccountTypeBasicInfoAllOf


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**tags** | **String** |  |  [optional] |
|**accountNumber** | **String** | Account number.  |  [optional] |
|**batch** | **String** | The alias name given to a batch. A string of 50 characters or less.  |  [optional] |
|**communicationProfileId** | **String** | The ID of the communication profile that this account is linked to. |  [optional] |
|**creditMemoTemplateId** | **String** | **Note:** This field is only available if you have [Invoice Settlement](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/Invoice_Settlement) enabled. The Invoice Settlement feature is generally available as of Zuora Billing Release 296 (March 2021). This feature includes Unapplied Payments, Credit and Debit Memo, and Invoice Item Settlement. If you want to enable Invoice Settlement, see [Invoice Settlement Enablement and Checklist Guide](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/Invoice_Settlement/Invoice_Settlement_Migration_Checklist_and_Guide) for more information.  The unique ID of the credit memo template, configured in **Billing Settings** &gt; **Manage Billing Document Configuration** through the Zuora UI. For example, 2c92c08a6246fdf101626b1b3fe0144b.  |  [optional] |
|**crmId** | **String** | CRM account ID for the account, up to 100 characters.  |  [optional] |
|**debitMemoTemplateId** | **String** | **Note:** This field is only available if you have [Invoice Settlement](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/Invoice_Settlement) enabled. The Invoice Settlement feature is generally available as of Zuora Billing Release 296 (March 2021). This feature includes Unapplied Payments, Credit and Debit Memo, and Invoice Item Settlement. If you want to enable Invoice Settlement, see [Invoice Settlement Enablement and Checklist Guide](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/Invoice_Settlement/Invoice_Settlement_Migration_Checklist_and_Guide) for more information.  The unique ID of the debit memo template, configured in **Billing Settings** &gt; **Manage Billing Document Configuration** through the Zuora UI. For example, 2c92c08d62470a8501626b19d24f19e2.  |  [optional] |
|**id** | **String** | Account ID.  |  [optional] |
|**invoiceTemplateId** | **String** | Invoice template ID, configured in Billing Settings in the Zuora UI.  |  [optional] |
|**lastMetricsUpdate** | **OffsetDateTime** | The date and time when account metrics are last updated, if the account is a partner account.  **Note**:    - This field is available only if you have the &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Manage_customer_accounts/AAA_Overview_of_customer_accounts/Reseller_Account\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Reseller Account&lt;/a&gt; feature enabled.   - If you have the Reseller Account feature enabled, and set the &#x60;partnerAccount&#x60; field to &#x60;false&#x60; for an account, the value of the &#x60;lastMetricsUpdate&#x60; field is automatically set to &#x60;null&#x60; in the response.    - If you ever set the &#x60;partnerAccount&#x60; field to &#x60;true&#x60; for an account, the value of &#x60;lastMetricsUpdate&#x60; field is the time when the account metrics are last updated.          |  [optional] |
|**name** | **String** | Account name.  |  [optional] |
|**notes** | **String** | Notes associated with the account, up to 65,535 characters.  |  [optional] |
|**organizationLabel** | **String** | The organization that this object belongs to.  Note: This field is available only when the Multi-Org feature is enabled.  |  [optional] |
|**parentId** | **String** | Identifier of the parent customer account for this Account object. The length is 32 characters. Use this field if you have &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Billing/Subscriptions/Customer_Accounts/A_Customer_Account_Introduction#Customer_Hierarchy\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Customer Hierarchy&lt;/a&gt; enabled. |  [optional] |
|**partnerAccount** | **Boolean** | Whether the customer account is a partner, distributor, or reseller.    **Note**: This field is available only if you have the &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Manage_customer_accounts/AAA_Overview_of_customer_accounts/Reseller_Account\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Reseller Account&lt;/a&gt; feature enabled.  |  [optional] |
|**profileNumber** | **String** | The number of the communication profile that this account is linked to. |  [optional] |
|**purchaseOrderNumber** | **String** | The purchase order number provided by your customer for services, products, or both purchased. |  [optional] |
|**salesRep** | **String** | The name of the sales representative associated with this account, if applicable. Maximum of 50 characters. |  [optional] |
|**sequenceSetId** | **String** | The ID of the billing document sequence set that is assigned to the customer account.   |  [optional] |
|**status** | **String** | Account status; possible values are: &#x60;Active&#x60;, &#x60;Draft&#x60;, &#x60;Canceled&#x60;.  |  [optional] |



