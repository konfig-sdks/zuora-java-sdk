

# POSTScheduleItemType


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**amount** | **BigDecimal** | The amount of the invoice to be generated during the processing of the invoice schedule item.   You can only specify either the &#x60;amount&#x60; field or &#x60;percentage&#x60; field in one request.    - If you choose to specify the &#x60;amount&#x60; field in the request, &#x60;null&#x60; is returned as the value of the &#x60;percentage&#x60; field in the corresponding response.    - If you choose to specify the &#x60;percentage&#x60; field in the request, the value of the &#x60;amount&#x60; field returned in the corresponding response is calculated based on the percentage of the total amount.              |  [optional] |
|**name** | **String** | The name of the invoice schedule item.  |  [optional] |
|**percentage** | **BigDecimal** | The percentage of the total amount to be billed during the processing of the invoice schedule item.   You can only specify either the &#x60;amount&#x60; field or &#x60;percentage&#x60; field in one request.    - If you choose to specify the &#x60;amount&#x60; field in the request, &#x60;null&#x60; is returned as the value of the &#x60;percentage&#x60; field in the corresponding response.    - If you choose to specify the &#x60;percentage&#x60; field in the request, the value of the &#x60;amount&#x60; field returned in the corresponding response is calculated based on the percentage of the total amount.  |  [optional] |
|**runDate** | **LocalDate** | The date in the tenant’s time zone when the invoice schedule item is planned to be processed to generate an invoice.   When specifying run dates for invoice schedule items, consider that: - An invoice schedule item with a blank run date will not be executed. - You can only update the run date for an invoice schedule item in Pending status. - If the run date of an invoice schedule item is left empty, the dates of all subsequent invoice schedule items must also be blank. - You must specify run dates in chronological order for invoice schedule items.                    |  [optional] |
|**targetDateForAdditionalSubscriptions** | **LocalDate** | The date in the tenant&#39;s time zone used by the invoice schedule to determine which fixed-period regular charges to be billed together with the invoice schedule item.   The regular charges must come from the subscriptions specified in the &#x60;additionalSubscriptionsToBill&#x60; field.  |  [optional] |



