

# Invoices


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**accountId** | **String** | The ID of the account associated with the invoice.   You must specify either &#x60;accountNumber&#x60; or &#x60;accountId&#x60; for a customer account. If both of them are specified, they must refer to the same customer account.  |  [optional] |
|**accountNumber** | **String** | The Number of the account associated with the invoice. You must specify either &#x60;accountNumber&#x60; or &#x60;accountId&#x60; for a customer account. If both of them are specified, they must refer to the same customer account.  |  [optional] |
|**autoPay** | **Boolean** | Whether invoices are automatically picked up for processing in the corresponding payment run.  |  [optional] |
|**billToContact** | [**PostCreateInvoiceContactType**](PostCreateInvoiceContactType.md) |  |  [optional] |
|**billToContactId** | **String** | The ID of the bill-to contact associated with the invoice. This field is mutually exclusive with the &#x60;billToContact&#x60; field.  **Note**: If you have the &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Bill_your_customers/Bill_customers_at_subscription_level/Flexible_Billing_Attributes\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Flexible Billing Attributes&lt;/a&gt; feature disabled, this field is unavailable in the request body.  |  [optional] |
|**comments** | **String** | Comments about the invoice.  |  [optional] |
|**currency** | **String** | The code of a currency as defined in Billing Settings through the Zuora UI.  If you do not specify a currency during standalone invoice creation, the default account currency is applied. The currency that you specify in the request must be configured and activated in Billing Settings. **Note**: This field is available only if you have the &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Bill_your_customers/Flexible_Billing/Multiple_Currencies\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Multiple Currencies&lt;/a&gt; feature enabled.  |  [optional] |
|**customRates** | [**List&lt;InvoiceWithCustomRatesType&gt;**](InvoiceWithCustomRatesType.md) | It contains Home currency and Reporting currency custom rates currencies. The maximum number of items is 2 (you can pass the Home currency item or Reporting currency item or both).        **Note**: The API custom rate feature is permission controlled.  |  [optional] |
|**dueDate** | **LocalDate** | The date by which the payment for this invoice is due, in &#x60;yyyy-mm-dd&#x60; format.  |  [optional] |
|**invoiceDate** | **LocalDate** | The date that appears on the invoice being created, in &#x60;yyyy-mm-dd&#x60; format. The value cannot fall in a closed accounting period.  |  |
|**invoiceItems** | [**List&lt;PostInvoiceItemType&gt;**](PostInvoiceItemType.md) | Container for invoice items. The maximum number of invoice items is 1,000.  |  [optional] |
|**invoiceNumber** | **String** | A customized invoice number with the following format requirements: - Max length: 32 characters - Acceptable characters: a-z,A-Z,0-9,-,_,  Purely numerical prefixes or prefixes ending with a number are supported for standalone invoices. For example, you can use &#x60;202310000300&#x60;, &#x60;2003&#x60;, &#x60;INV202310000300&#x60;, or &#x60;2023-09-100009785&#x60; as invoice numbers.  The value must be unique in the system, otherwise it may cause issues with bill runs and subscribe/amend. Check out [things to note and troubleshooting steps](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/IA_Invoices/Unified_Invoicing/Import_external_invoices_as_standalone_invoices?#Customizing_invoice_number).   |  [optional] |
|**paymentTerm** | **String** | The ID or name of the payment term associated with the invoice. For example, &#x60;Net 30&#x60;. The payment term determines the due dates of invoices.  **Note**: If you have the &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Bill_your_customers/Bill_customers_at_subscription_level/Flexible_Billing_Attributes\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Flexible Billing Attributes&lt;/a&gt; feature disabled, this field is unavailable in the request body.  |  [optional] |
|**sequenceSet** | **String** | The ID or name of the sequence set associated with the invoice.  **Note**: If you have the &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Bill_your_customers/Bill_customers_at_subscription_level/Flexible_Billing_Attributes\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Flexible Billing Attributes&lt;/a&gt; feature disabled, this field is unavailable in the request body.  |  [optional] |
|**soldToContact** | [**PostCreateInvoiceContactType**](PostCreateInvoiceContactType.md) |  |  [optional] |
|**soldToContactId** | **String** | The ID of the sold-to contact associated with the invoice. This field is mutually exclusive with the &#x60;soldToContact&#x60; field.  **Note**: If you have the &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Bill_your_customers/Bill_customers_at_subscription_level/Flexible_Billing_Attributes\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Flexible Billing Attributes&lt;/a&gt; feature disabled, this field is unavailable in the request body.  |  [optional] |
|**soldToSameAsBillTo** | **Boolean** | Whether the sold-to contact and bill-to contact are the same entity. This field is mutually exclusive with the &#x60;soldToContact&#x60; and &#x60;soldToContactId&#x60; fields.  The created invoice has the same bill-to contact and sold-to contact entity only when all the following conditions are met in the request body:  - This field is set to &#x60;true&#x60;.  - A bill-to contact or bill-to contact ID is specified. - Neither sold-to contact nor sold-to contact ID is specified.  **Note**: If you have the &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Bill_your_customers/Bill_customers_at_subscription_level/Flexible_Billing_Attributes\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Flexible Billing Attributes&lt;/a&gt; feature disabled, this field is unavailable in the request body.  |  [optional] |
|**status** | [**StatusEnum**](#StatusEnum) | The status of invoice. By default, the invoice status is Draft.  When creating an invoice, if you set this field to &#x60;Posted&#x60;, the invoice is created and posted directly.  |  [optional] |
|**templateId** | **String** | The ID of the invoice template associated with the invoice.  **Note**: If you have the &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Bill_your_customers/Bill_customers_at_subscription_level/Flexible_Billing_Attributes\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Flexible Billing Attributes&lt;/a&gt; feature disabled, this field is unavailable in the request body.  |  [optional] |
|**transferredToAccounting** | [**TransferredToAccountingEnum**](#TransferredToAccountingEnum) |  |  [optional] |



## Enum: StatusEnum

| Name | Value |
|---- | -----|
| DRAFT | &quot;Draft&quot; |
| POSTED | &quot;Posted&quot; |



## Enum: TransferredToAccountingEnum

| Name | Value |
|---- | -----|
| PROCESSING | &quot;Processing&quot; |
| ERROR | &quot;Error&quot; |
| IGNORE | &quot;Ignore&quot; |
| TRUE | &quot;true&quot; |
| FALSE | &quot;false&quot; |



