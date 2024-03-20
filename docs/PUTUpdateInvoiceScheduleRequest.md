

# PUTUpdateInvoiceScheduleRequest


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**additionalSubscriptionsToBill** | **List&lt;String&gt;** | A list of the numbers of the subscriptions that need to be billed together with the invoice schedule.   One invoice schedule can have at most 600 additional subscriptions.  |  [optional] |
|**invoiceSeparately** | **Boolean** | Whether the invoice items created from the invoice schedule appears on a separate invoice when Zuora generates invoices.  |  [optional] |
|**nextRunDate** | **LocalDate** | The run date of the next execution of the invoice schedule.   By default, the next run date is the same as the run date of next pending invoice schedule item. The date can be overwritten by a different date other than the default value. If the invoice schedule has completed the execution, the next run date is &#x60;null&#x60;.  |  [optional] |
|**notes** | **String** | Comments on the invoice schedule.  |  [optional] |
|**orders** | **List&lt;String&gt;** | A list of the IDs or numbers of the orders associated with the invoice schedule. One invoice schedule can be associated with at most 10 orders.  The orders specified in this field override all the existing orders associated with the invoice schedule.  |  [optional] |
|**scheduleItems** | [**List&lt;UpdateScheduleItems&gt;**](UpdateScheduleItems.md) | Container for invoice schedule items. The maximum number of schedule items is 50.  The invoice schedule items specified in this field override all the existing invoice schedule items.  |  [optional] |
|**specificSubscriptions** | [**List&lt;InvoiceScheduleSpecificSubscriptions&gt;**](InvoiceScheduleSpecificSubscriptions.md) | A list of the numbers of specific subscriptions associated with the invoice schedule.  - If the subscriptions specified in this field belong to the orders specified in the &#x60;orders&#x60; field, only the specific subscriptions instead of the orders are associated with the invoice schedule.  - If only the &#x60;orders&#x60; field is specified, all the subscriptions from the order are associated with the invoice schedule.    The specific subscriptions specified in this field override all the existing specific subscriptions associated with the invoice schedule.  Example: &#x60;&#x60;&#x60; {   \&quot;orders\&quot;: [     \&quot;O-00000001\&quot;, \&quot;O-00000002\&quot;   ],   \&quot;specificSubscriptions\&quot;: [     {       \&quot;orderKey\&quot;: \&quot;O-00000001\&quot;,       \&quot;subscriptionKey\&quot;: \&quot;S-00000001\&quot;     }   ] } &#x60;&#x60;&#x60; - For the order with number O-00000001, only subscription S-00000001 contained in the order is associated with the invoice schedule. - For the order with number O-00000002, all subscriptions contained in the order are associated with the invoice schedule.  |  [optional] |



