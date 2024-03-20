

# GETCreditMemoTypeAllOf


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**accountId** | **String** | The ID of the customer account associated with the credit memo.  |  [optional] |
|**accountNumber** | **String** | The number of the customer account associated with the credit memo.  |  [optional] |
|**amount** | **Double** | The total amount of the credit memo.  |  [optional] |
|**appliedAmount** | **Double** | The applied amount of the credit memo.  |  [optional] |
|**autoApplyUponPosting** | **Boolean** | Whether the credit memo automatically applies to the invoice upon posting.  |  [optional] |
|**billToContactId** | **String** | The ID of the bill-to contact associated with the credit memo.  The value of this field is &#x60;null&#x60; if you have the [Flexible Billing Attributes](https://knowledgecenter.zuora.com/Billing/Subscriptions/Flexible_Billing_Attributes) feature disabled.  |  [optional] |
|**billToContactSnapshotId** | **String** | The ID of the bill-to contact snapshot associated with the credit memo.  The value of this field is &#x60;null&#x60; if the bill rule [Preserve snapshot of bill-to and sold-to contacts when billing documents are posted](https://knowledgecenter.zuora.com/Zuora_Billing/Billing_and_Invoicing/Billing_Settings/Define_Billing_Rules#Preserve_snapshot_of_bill-to_and_sold-to_contacts_when_billing_documents_are_posted) is disabled.  |  [optional] |
|**cancelledById** | **String** | The ID of the Zuora user who cancelled the credit memo.  |  [optional] |
|**cancelledOn** | **OffsetDateTime** | The date and time when the credit memo was cancelled, in &#x60;yyyy-mm-dd hh:mm:ss&#x60; format.  |  [optional] |
|**comment** | **String** | Comments about the credit memo.  |  [optional] |
|**createdById** | **String** | The ID of the Zuora user who created the credit memo.  |  [optional] |
|**createdDate** | **OffsetDateTime** | The date and time when the credit memo was created, in &#x60;yyyy-mm-dd hh:mm:ss&#x60; format. For example, 2017-03-01 15:31:10.  |  [optional] |
|**creditMemoDate** | **LocalDate** | The date when the credit memo takes effect, in &#x60;yyyy-mm-dd&#x60; format. For example, 2017-05-20.  |  [optional] |
|**currency** | **String** | The currency of the credit memo.  **Note:** By default, the currency on a billing document matches the default currency set on the associated account.  However, Zuora now offers a Multiple Currencies feature to support different currencies for billing documents, allowing flexibility beyond the account-level currency.  For more information, see &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Bill_your_customers/Flexible_Billing/Multiple_Currencies\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Multiple Currency&lt;/a&gt;.  |  [optional] |
|**einvoiceErrorCode** | **String** | The error code returned when the e-invoice file status is &#x60;Failed&#x60;. This code can either be a Zuora-generated error code or one returned by a third-party e-invoicing service provider.  **Note**: This field is available only if you have the &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Bill_your_customers/E-Invoicing\&quot; target&#x3D;\&quot;_blank\&quot;&gt;E-Invoicing&lt;/a&gt; feature in **Early Adopter** phase enabled.  |  [optional] |
|**einvoiceErrorMessage** | **String** | The error message returned when the e-invoice file status is &#x60;Failed&#x60;. This message can either be a Zuora-generated error message or one returned by a third-party e-invoicing service provider.  **Note**: This field is available only if you have the &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Bill_your_customers/E-Invoicing\&quot; target&#x3D;\&quot;_blank\&quot;&gt;E-Invoicing&lt;/a&gt; feature in **Early Adopter** phase enabled.  |  [optional] |
|**einvoiceFileId** | **String** | The ID of the e-invoice file generated for the credit memo.  **Note**: This field is available only if you have the &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Bill_your_customers/E-Invoicing\&quot; target&#x3D;\&quot;_blank\&quot;&gt;E-Invoicing&lt;/a&gt; feature in **Early Adopter** phase enabled.  |  [optional] |
|**einvoiceStatus** | [**EinvoiceStatusEnum**](#EinvoiceStatusEnum) | The status of the e-invoice file generation for the credit memo.   - If e-invoice file generation succeeds, this field is either &#x60;Generated&#x60; or &#x60;Success&#x60;, and both the error code and message are empty, and the &#x60;eInvoiceFileId&#x60; field stores the ID of the generated e-invoice file. - If a failure occurs during e-invoice file generation, this field is &#x60;Failed&#x60; and an error code and an error message are returned respectively in the &#x60;einvoiceErrorCode&#x60; and &#x60;einvoiceErrorMessage&#x60; fields.   **Note**: This field is available only if you have the &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Bill_your_customers/E-Invoicing\&quot; target&#x3D;\&quot;_blank\&quot;&gt;E-Invoicing&lt;/a&gt; feature in **Early Adopter** phase enabled.  |  [optional] |
|**excludeFromAutoApplyRules** | **Boolean** | Whether the credit memo is excluded from the rule of automatically applying credit memos to invoices.  |  [optional] |
|**excludeItemBillingFromRevenueAccounting** | **Boolean** | The flag to exclude the credit memo item from revenue accounting.   **Note**: This field is only available if you have the Billing - Revenue Integration feature enabled.   |  [optional] |
|**id** | **String** | The unique ID of the credit memo.  |  [optional] |
|**invoiceGroupNumber** | **String** | The number of the invoice group associated with the credit memo.   The value of this field is &#x60;null&#x60; if you have the [Flexible Billing Attributes](https://knowledgecenter.zuora.com/Billing/Subscriptions/Flexible_Billing_Attributes) feature disabled.  |  [optional] |
|**latestPDFFileId** | **String** | The ID of the latest PDF file generated for the credit memo.  |  [optional] |
|**number** | **String** | The unique identification number of the credit memo.  |  [optional] |
|**organizationLabel** | **String** | The organization that this object belongs to.  Note: This field is available only when the Multi-Org feature is enabled.  |  [optional] |
|**postedById** | **String** | The ID of the Zuora user who posted the credit memo.  |  [optional] |
|**postedOn** | **OffsetDateTime** | The date and time when the credit memo was posted, in &#x60;yyyy-mm-dd hh:mm:ss&#x60; format.  |  [optional] |
|**reasonCode** | **String** | A code identifying the reason for the transaction. The value must be an existing reason code or empty.  |  [optional] |
|**referredInvoiceId** | **String** | The ID of a referred invoice.  |  [optional] |
|**refundAmount** | **Double** | The amount of the refund on the credit memo.  |  [optional] |
|**reversed** | **Boolean** | Whether the credit memo is reversed.  |  [optional] |
|**sequenceSetId** | **String** | The ID of the sequence set associated with the credit memo.  The value of this field is &#x60;null&#x60; if you have the [Flexible Billing Attributes](https://knowledgecenter.zuora.com/Billing/Subscriptions/Flexible_Billing_Attributes) feature disabled.  |  [optional] |
|**source** | **String** | The source of the credit memo.  Possible values: - &#x60;BillRun&#x60;: The credit memo is generated by a bill run. - &#x60;API&#x60;: The credit memo is created by calling the [Invoice and collect](https://developer.zuora.com/api-references/api/operation/POST_TransactionInvoicePayment) operation, or by calling the Orders, Order Line Items, or Fulfillments API operations. - &#x60;ApiSubscribe&#x60;: The credit memo is created by calling the [Create subscription](https://developer.zuora.com/api-references/api/operation/POST_Subscription) and [Create account](https://developer.zuora.com/api-references/api/operation/POST_Account) operation. - &#x60;ApiAmend&#x60;: The credit memo is created by calling the [Update subscription](https://developer.zuora.com/api-references/api/operation/PUT_Subscription) operation. - &#x60;AdhocFromPrpc&#x60;: The credit memo is created from a product rate plan charge through the Zuora UI or by calling the [Create a credit memo from a charge](https://developer.zuora.com/api-references/api/operation/POST_CreditMemoFromPrpc) operation. - &#x60;AdhocFromInvoice&#x60;: The credit memo is created from an invoice or created by reversing an invoice. You can create a credit memo from an invoice through the Zuora UI or by calling the [Create credit memo from invoice](https://developer.zuora.com/api-references/api/operation/POST_CreditMemoFromInvoice) operation. You can create a credit memo by reversing an invoice through the Zuora UI or by calling the [Reverse invoice](https://developer.zuora.com/api-references/api/operation/PUT_ReverseInvoice) operation.  |  [optional] |
|**sourceId** | **String** | The ID of the credit memo source.  If a credit memo is generated from a bill run, the value is the number of the corresponding bill run. Otherwise, the value is &#x60;null&#x60;.  |  [optional] |
|**sourceType** | [**SourceTypeEnum**](#SourceTypeEnum) | The type of the credit memo source.  |  [optional] |
|**status** | [**StatusEnum**](#StatusEnum) | The status of the credit memo.  |  [optional] |
|**success** | **Boolean** | Returns &#x60;true&#x60; if the request was processed successfully. |  [optional] |
|**targetDate** | **LocalDate** | The target date for the credit memo, in &#x60;yyyy-mm-dd&#x60; format. For example, 2017-07-20.  |  [optional] |
|**taxAmount** | **Double** | The amount of taxation.  |  [optional] |
|**taxMessage** | **String** | The message about the status of tax calculation related to the credit memo. If tax calculation fails in one credit memo, this field displays the reason for the failure.  |  [optional] |
|**taxStatus** | [**TaxStatusEnum**](#TaxStatusEnum) | The status of tax calculation related to the credit memo.  **Note**: This field is only applicable to tax calculation by third-party tax engines.  |  [optional] |
|**totalTaxExemptAmount** | **Double** | The calculated tax amount excluded due to the exemption.  |  [optional] |
|**transferredToAccounting** | [**TransferredToAccountingEnum**](#TransferredToAccountingEnum) | Whether the credit memo was transferred to an external accounting system. Use this field for integration with accounting systems, such as NetSuite.  |  [optional] |
|**unappliedAmount** | **Double** | The unapplied amount of the credit memo.  |  [optional] |
|**updatedById** | **String** | The ID of the Zuora user who last updated the credit memo.  |  [optional] |
|**updatedDate** | **OffsetDateTime** | The date and time when the credit memo was last updated, in &#x60;yyyy-mm-dd hh:mm:ss&#x60; format. For example, 2017-03-01 15:36:10.  |  [optional] |



## Enum: EinvoiceStatusEnum

| Name | Value |
|---- | -----|
| PROCESSING | &quot;Processing&quot; |
| GENERATED | &quot;Generated&quot; |
| SUCCESS | &quot;Success&quot; |
| FAILED | &quot;Failed&quot; |



## Enum: SourceTypeEnum

| Name | Value |
|---- | -----|
| SUBSCRIPTION | &quot;Subscription&quot; |
| STANDALONE | &quot;Standalone&quot; |
| INVOICE | &quot;Invoice&quot; |
| ORDER | &quot;Order&quot; |
| CREDITMEMO | &quot;CreditMemo&quot; |
| CONSOLIDATION | &quot;Consolidation&quot; |



## Enum: StatusEnum

| Name | Value |
|---- | -----|
| DRAFT | &quot;Draft&quot; |
| POSTED | &quot;Posted&quot; |
| CANCELED | &quot;Canceled&quot; |
| ERROR | &quot;Error&quot; |
| PENDINGFORTAX | &quot;PendingForTax&quot; |
| GENERATING | &quot;Generating&quot; |
| CANCELINPROGRESS | &quot;CancelInProgress&quot; |



## Enum: TaxStatusEnum

| Name | Value |
|---- | -----|
| COMPLETE | &quot;Complete&quot; |
| ERROR | &quot;Error&quot; |



## Enum: TransferredToAccountingEnum

| Name | Value |
|---- | -----|
| PROCESSING | &quot;Processing&quot; |
| TRUE | &quot;true&quot; |
| FALSE | &quot;false&quot; |
| ERROR | &quot;Error&quot; |
| IGNORE | &quot;Ignore&quot; |



