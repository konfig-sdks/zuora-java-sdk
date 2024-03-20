

# POSTCreateBillRunRequestTypeAllOf


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**autoEmail** | **Boolean** | Whether to automatically send emails after Auto-Post is complete.  **Note:** To use this field, you must first set the &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/CB_Billing/Billing_Settings/Define_Billing_Rules\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Support Bill Run Auto-Post?&lt;/a&gt; billing rule to **Yes** through the Zuora UI.  |  [optional] |
|**autoPost** | **Boolean** | Whether to automatically post the bill run after the bill run is created.  **Note:** To use this field, you must first set the &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/CB_Billing/Billing_Settings/Define_Billing_Rules\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Support Bill Run Auto-Post?&lt;/a&gt; billing rule to **Yes** through the Zuora UI.  |  [optional] |
|**autoRenewal** | **Boolean** | Whether to automatically renew auto-renew subscriptions that are up for renewal.  |  [optional] |
|**batches** | **List&lt;String&gt;** | The batch of accounts for this bill run.   You can only specify either this field or the &#x60;billRunFilters&#x60; field.  **Values:** &#x60;AllBatches&#x60; or an array of &#x60;Batch*n*&#x60; where *n* is one of numbers 1 - 50, for example, &#x60;Batch7&#x60;.  **Note**: By default, you have 50 configurable account batches. To increase the limit to 200 batches, you must have the &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Central_Platform/Performance_Booster_Elite\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Performance Booster Elite&lt;/a&gt; package.  |  [optional] |
|**billCycleDay** | **String** | The day of the bill cycle. This field is only valid if the &#x60;batches&#x60; field is specified.  **Values:**  - &#x60;AllBillCycleDays&#x60; or one of numbers 1 - 31 for an ad-hoc bill run - &#x60;AllBillCycleDays&#x60;, one of numbers 1 - 31, or &#x60;AsRunDay&#x60; for a scheduled bill run  |  [optional] |
|**billRunFilters** | [**List&lt;BillRunFilterRequestType&gt;**](BillRunFilterRequestType.md) | The target account or subscriptions for this bill run. You can only specify either this field or the &#x60;batches&#x60; field.  |  [optional] |
|**billRunType** | **String** | The type of the bill run. If you do not specify any value for this field, the default value is &#x60;Regular&#x60;.  - You can use this field only if the \&quot;Catch-Up Bill Run\&quot; feature is enabled.  - You must specify this field to create a catch up bill run.  **Values:**  - &#x60;Regular&#x60; - &#x60;CatchUp&#x60;  |  [optional] |
|**chargeTypeToExclude** | [**List&lt;ChargeTypeToExcludeEnum&gt;**](#List&lt;ChargeTypeToExcludeEnum&gt;) | The types of the charges to be excluded from the generation of billing documents. You can specify at most two charge types in the array.  |  [optional] |
|**invoiceDate** | **LocalDate** | The invoice date for the bill run.  - When creating an ad-hoc bill run, if you do not specify any value for this field, the default value is the current date. - When creating a scheduled bill run, if you do not specify any value for this field, the invoice date is the value of the &#x60;repeatFrom&#x60; field.   |  [optional] |
|**name** | **String** | The name of the bill run.  |  [optional] |
|**noEmailForZeroAmountInvoice** | **Boolean** | Whether to suppress emails for invoices with zero total amount generated in this bill run after the bill run is complete.   It is best practice to not send emails for invoices with zero amount.  |  [optional] |
|**organizationLabels** | [**List&lt;GETProductTypeAllOfOrganizationLabels&gt;**](GETProductTypeAllOfOrganizationLabels.md) | The organization(s) that the bill run is created for.   For each item in the array, either the &#x60;organizationId&#x60; or the &#x60;organizationName&#x60; field is required.  This field is only required when you have already turned on Multi-Org feature.  |  [optional] |
|**schedule** | [**BillRunScheduleRequestType**](BillRunScheduleRequestType.md) |  |  [optional] |
|**targetDate** | **LocalDate** | The target date for this bill run.   - You must specify this field when creating an ad-hoc bill run. - For scheduled bill runs, if you do not specify any value for this field, the target date is the value of the &#x60;repeatFrom&#x60; field.  |  [optional] |



## Enum: List&lt;ChargeTypeToExcludeEnum&gt;

| Name | Value |
|---- | -----|
| ONETIME | &quot;OneTime&quot; |
| RECURRING | &quot;Recurring&quot; |
| USAGE | &quot;Usage&quot; |



