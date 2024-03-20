

# InvoiceScheduleResponses


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**accountId** | **String** | The ID of the customer account that the invoice schedule belongs to.  |  [optional] |
|**actualAmount** | **BigDecimal** | The actual amount that needs to be billed during the processing of the invoice schedule.  By default, the actual amount is the same as the total amount. Even if order changes occur like Remove Product or Cancel Subscription, the value of the &#x60;totalAmount&#x60; field keeps unchanged. The value of the &#x60;actualAmount&#x60; field reflects the actual amount to be billed.  |  [optional] |
|**additionalSubscriptionsToBill** | **List&lt;String&gt;** | A list of the numbers of the subscriptions that need to be billed together with the invoice schedule.   One invoice schedule can have at most 600 additional subscriptions.  |  [optional] |
|**billedAmount** | **BigDecimal** | The amount that has been billed during the processing of the invoice schedule.  |  [optional] |
|**currency** | **String** | The currency of the billing documents generated during the processing of the invoice schedule. **Note**:  - This field is available only if you have the &lt;a   href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Bill_your_customers/Flexible_Billing/Multiple_Currencies\&quot;   target&#x3D;\&quot;_blank\&quot;&gt;Multiple Currencies&lt;/a&gt; feature enabled.  - If you have the Multiple Currencies feature disabled, the corresponding account&#39;s default currency is always used.  |  [optional] |
|**id** | **String** | The unique ID of the invoice schedule.  |  [optional] |
|**invoiceSeparately** | **Boolean** | Whether the invoice items created from the invoice schedule appears on a separate invoice when Zuora generates invoices.  |  [optional] |
|**nextRunDate** | **LocalDate** | The run date of the next execution of invoice schedule. By default, the next run date is the same as run date of next pending invoice schedule item. It can be overwritten with a different date other than the default value. When the invoice schedule has completed the execution, the next run date is null.  |  [optional] |
|**notes** | **String** | Comments on the invoice schedule.  |  [optional] |
|**number** | **String** | The sequence number of the invoice schedule.  |  [optional] |
|**orders** | **List&lt;String&gt;** | A list of the IDs or numbers of the orders associated with the invoice schedule. One invoice schedule can be associated with at most 10 orders.  |  [optional] |
|**scheduleItems** | [**List&lt;ScheduleItemsResponse&gt;**](ScheduleItemsResponse.md) | Container for schedule items. One invoice schedule can have at most 50 invoice schedule items.  |  [optional] |
|**specificSubscriptions** | [**List&lt;InvoiceScheduleSpecificSubscriptions&gt;**](InvoiceScheduleSpecificSubscriptions.md) | A list of the numbers of specific subscriptions associated with the invoice schedule.  |  [optional] |
|**status** | [**StatusEnum**](#StatusEnum) | The status of the invoice schedule.  |  [optional] |
|**totalAmount** | **BigDecimal** | The total amount that needs to be billed during the processing of the invoice schedule.   The value of this field keeps unchanged once invoice schedule items are created.  |  [optional] |
|**unbilledAmount** | **BigDecimal** | The amount that is waiting to be billed during the processing of the invoice schedule.  |  [optional] |



## Enum: StatusEnum

| Name | Value |
|---- | -----|
| PENDING | &quot;Pending&quot; |
| PARTIALLYPROCESSED | &quot;PartiallyProcessed&quot; |
| PAUSED | &quot;Paused&quot; |
| FULLYPROCESSED | &quot;FullyProcessed&quot; |



