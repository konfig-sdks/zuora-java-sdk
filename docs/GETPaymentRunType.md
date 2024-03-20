

# GETPaymentRunType


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**accountId** | **String** | The ID of the customer account associated with the payment run.  |  [optional] |
|**applyCreditBalance** | **Boolean** | **Note:** This field is only available if you have the Credit Balance feature enabled and the Invoice Settlement feature disabled.  Whether to apply credit balances in the payment run. This field is only available when you have Invoice Settlement feature disabled.  |  [optional] |
|**autoApplyCreditMemo** | **Boolean** | **Note:** This field is only available if you have [Invoice Settlement](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/Invoice_Settlement) enabled. The Invoice Settlement feature is generally available as of Zuora Billing Release 296 (March 2021). This feature includes Unapplied Payments, Credit and Debit Memo, and Invoice Item Settlement. If you want to enable Invoice Settlement, see [Invoice Settlement Enablement and Checklist Guide](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/Invoice_Settlement/Invoice_Settlement_Migration_Checklist_and_Guide) for more information.  Whether to automatically apply a posted credit memo to one or more receivables in the payment run.  |  [optional] |
|**autoApplyUnappliedPayment** | **Boolean** | **Note:** This field is only available if you have [Invoice Settlement](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/Invoice_Settlement) enabled. The Invoice Settlement feature is generally available as of Zuora Billing Release 296 (March 2021). This feature includes Unapplied Payments, Credit and Debit Memo, and Invoice Item Settlement. If you want to enable Invoice Settlement, see [Invoice Settlement Enablement and Checklist Guide](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/Invoice_Settlement/Invoice_Settlement_Migration_Checklist_and_Guide) for more information.  Whether to automatically apply unapplied payments to  one or more receivables in the payment run.  |  [optional] |
|**batch** | **String** | The alias name given to a batch.  |  [optional] |
|**billCycleDay** | **String** | The billing cycle day (BCD), the day of the month when a bill run generates invoices for the account.   |  [optional] |
|**billingRunId** | **UUID** | The ID of the bill run.  |  [optional] |
|**collectPayment** | **Boolean** | Whether to process electronic payments during the execution of payment runs.   |  [optional] |
|**completedOn** | **OffsetDateTime** | The date and time when the payment run is completed, in &#x60;yyyy-mm-dd hh:mm:ss&#x60; format. For example, 2017-03-01 11:39:58.  |  [optional] |
|**consolidatedPayment** | **Boolean** | **Note:** The **Process Electronic Payment** permission also needs to be allowed for a Manage Payment Runs role to work. See [Payments Roles](https://knowledgecenter.zuora.com/CF_Users_and_Administrators/A_Administrator_Settings/User_Roles/e_Payments_Roles) for more information.   Whether to process a single payment for all receivables that are due on an account.  |  [optional] |
|**createdById** | **String** | The ID of the Zuora user who created the payment run.  |  [optional] |
|**createdDate** | **OffsetDateTime** | The date and time when the payment run was created, in &#x60;yyyy-mm-dd hh:mm:ss&#x60; format. For example, 2017-03-01 15:31:10.  |  [optional] |
|**currency** | **String** | A currency defined in the web-based UI administrative settings.  |  [optional] |
|**executedOn** | **OffsetDateTime** | The date and time when the payment run is executed, in &#x60;yyyy-mm-dd hh:mm:ss&#x60; format. For example, 2017-03-01 11:30:37.  |  [optional] |
|**id** | **String** | The ID of the payment run.  |  [optional] |
|**number** | **String** | The identification number of the payment run.  |  [optional] |
|**organizationLabels** | [**List&lt;GETCatalogGroupProductRatePlanResponseOrganizationLabelsInner&gt;**](GETCatalogGroupProductRatePlanResponseOrganizationLabelsInner.md) | The organization(s) that the object belongs to.   Note: This field is available only when the Multi-Org feature is enabled.  |  [optional] |
|**paymentGatewayId** | **UUID** | The ID of the gateway instance that processes the payment.  |  [optional] |
|**processPaymentWithClosedPM** | **Boolean** | **Note:** The **Process Electronic Payment** permission also needs to be allowed for a Manage Payment Runs role to work. See [Payments Roles](https://knowledgecenter.zuora.com/CF_Users_and_Administrators/A_Administrator_Settings/User_Roles/e_Payments_Roles) for more information.   Whether to process payments even if the default payment method is closed.  |  [optional] |
|**runDate** | **OffsetDateTime** | The date and time when the scheduled payment run is to be executed for collecting payments.  |  [optional] |
|**status** | [**StatusEnum**](#StatusEnum) | The status of the created payment run.  |  [optional] |
|**success** | **Boolean** | Returns &#x60;true&#x60; if the request was processed successfully.  |  [optional] |
|**targetDate** | **LocalDate** | The target date used to determine which receivables to be collected in the payment run.   |  [optional] |
|**updatedById** | **String** | The ID of the Zuora user who last updated the payment run.  |  [optional] |
|**updatedDate** | **OffsetDateTime** | The date and time when the payment run was last updated, in &#x60;yyyy-mm-dd hh:mm:ss&#x60; format. For example, 2017-03-02 15:36:10.  |  [optional] |



## Enum: StatusEnum

| Name | Value |
|---- | -----|
| PENDING | &quot;Pending&quot; |
| PROCESSING | &quot;Processing&quot; |
| COMPLETED | &quot;Completed&quot; |
| ERROR | &quot;Error&quot; |
| CANCELED | &quot;Canceled&quot; |



