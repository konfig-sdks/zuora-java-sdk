

# GETAccountCurrencyMetricsType


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**balance** | **String** | The total balance in this currency.  |  [optional] |
|**contractedMrr** | **BigDecimal** | The future expected Monthly Recurring Revenue (MRR) in this currency, accounting for future upgrades, downgrades, upsells, and cancellations.  |  [optional] |
|**currency** | **String** | The currency that metrics are aggregated based on.  |  [optional] |
|**reservedPaymentAmount** | **BigDecimal** | The reserved payment amount of the customer account in this currency. For more information, see &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Bill_your_customers/Bill_for_usage_or_prepaid_products/Advanced_Consumption_Billing/Prepaid_Cash_with_Drawdown\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Prepaid Cash with Drawdown&lt;/a&gt;.  |  [optional] |
|**totalDebitMemoBalance** | **BigDecimal** | The total balance of all posted debit memos in this currency.  **Note:** This field is only available if you have &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Bill_your_customers/Adjust_invoice_amounts/Invoice_Settlement\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Invoice Settlement&lt;/a&gt; enabled. The Invoice Settlement feature is generally available as of Zuora Billing Release 296 (March 2021). This feature includes Unapplied Payments, Credit and Debit Memo, and Invoice Item Settlement. If you want to enable Invoice Settlement, see &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Bill_your_customers/Adjust_invoice_amount[…]ment/AC_Invoice_Settlement_migration_checklist_and_guide\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Invoice Settlement Enablement and Checklist Guide&lt;/a&gt; for more information.  |  [optional] |
|**totalInvoiceBalance** | **BigDecimal** | The total balance of all posted invoices in this currency.  |  [optional] |
|**unappliedCreditMemoAmount** | **BigDecimal** | The total unapplied amount of all posted credit memos in this currency.  |  [optional] |
|**unappliedPaymentAmount** | **BigDecimal** | The total unapplied amount of all posted payments in this currency.  **Note:** This field is only available if you have [Invoice Settlement](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/Invoice_Settlement) enabled. The Invoice Settlement feature is generally available as of Zuora Billing Release 296 (March 2021). This feature includes Unapplied Payments, Credit and Debit Memo, and Invoice Item Settlement. If you want to enable Invoice Settlement, see [Invoice Settlement Enablement and Checklist Guide](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/Invoice_Settlement/Invoice_Settlement_Migration_Checklist_and_Guide) for more information.  |  [optional] |



