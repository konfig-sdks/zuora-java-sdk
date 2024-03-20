

# ScheduleItemsResponse


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**actualAmount** | **BigDecimal** | The actual amount that needs to be billed during the processing of the invoice schedule item.  By default, the actual amount is the same as the total amount. Even if order changes occur like Remove Product or Cancel Subscription, the value of the &#x60;amount&#x60; field keeps unchanged. The value of the &#x60;actualAmount&#x60; field reflects the actual amount to be billed.  |  [optional] |
|**amount** | **BigDecimal** | The amount of the invoice generated during the processing of the invoice schedule item.  You can only specify either the &#x60;amount&#x60; field or &#x60;percentage&#x60; field in one request.  - If you choose to specify the &#x60;amount&#x60; field in the request, &#x60;null&#x60; is returned as the value of the &#x60;percentage&#x60; field in the corresponding response.  - If you choose to specify the &#x60;percentage&#x60; field in the request, the value of the &#x60;amount&#x60; field returned in the corresponding response is calculated based on the percentage of the total amount.  The value of this field keeps unchanged once invoice schedule items are created.   |  [optional] |
|**creditMemoId** | **String** | The ID of the credit memo that is generated during the processing of the invoice schedule item.  |  [optional] |
|**id** | **String** | The unique ID of the invoice schedule item.  |  [optional] |
|**invoiceId** | **String** | The ID of the invoice that is generated during the processing of the invoice schedule item.  |  [optional] |
|**name** | **String** | The name of the invoice schedule item.  |  [optional] |
|**percentage** | **Object** | The percentage of the total amount to be billed during the processing of the invoice schedule item.   You can only specify either the &#x60;amount&#x60; field or &#x60;percentage&#x60; field in one request.  - If you choose to specify the &#x60;amount&#x60; field in the request, &#x60;null&#x60; is returned as the value of the &#x60;percentage&#x60; field in the corresponding response.  - If you choose to specify the &#x60;percentage&#x60; field in the request, the value of the &#x60;amount&#x60; field returned in the corresponding response is calculated based on the percentage of the total amount.  |  [optional] |
|**runDate** | **LocalDate** | The date in the tenant’s time zone when the invoice schedule item is processed to generate an invoice.  |  [optional] |
|**status** | [**StatusEnum**](#StatusEnum) | The status of the invoice schedule item.  |  [optional] |
|**targetDateForAdditionalSubscriptions** | **LocalDate** | The date in the tenant&#39;s time zone used by the invoice schedule to determine which fixed-period regular charges to be billed together with the invoice schedule item.   The regular charges must come from the subscriptions specified in the &#x60;additionalSubscriptionsToBill&#x60; field.  |  [optional] |



## Enum: StatusEnum

| Name | Value |
|---- | -----|
| PENDING | &quot;Pending&quot; |
| EXECUTING | &quot;Executing&quot; |
| PROCESSED | &quot;Processed&quot; |



