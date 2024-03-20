

# FulfillmentGet


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**fulfillmentNumber** | **String** | The sytem generated number for the Fulfillment.  |  [optional] |
|**id** | **UUID** | The sytem generated Id.  |  [optional] |
|**description** | **String** | The description of the Fulfillment.  |  [optional] |
|**billTargetDate** | **LocalDate** | The target date for the Fulfillment to be picked up by bill run for billing.  |  [optional] |
|**carrier** | **String** | The carrier of the Fulfillment. The available values can be configured in **Billing Settings** &gt; **Fulfillment Settings** through Zuora UI.  |  [optional] |
|**customFields** | **Map&lt;String, Object&gt;** | Container for custom fields of a Fulfillment object.  |  [optional] |
|**excludeItemBillingFromRevenueAccounting** | **Boolean** | The flag to exclude Fulfillment related invoice items, invoice item adjustments, credit memo items, and debit memo items from revenue accounting.  **Note**: This field is only available if you have the [Zuora Billing - Revenue Integration](https://knowledgecenter.zuora.com/Zuora_Revenue/Zuora_Billing_-_Revenue_Integration) feature enabled.   |  [optional] |
|**excludeItemBookingFromRevenueAccounting** | **Boolean** | The flag to exclude Fulfillment from revenue accounting.  **Note**: This field is only available if you have the [Zuora Billing - Revenue Integration](https://knowledgecenter.zuora.com/Zuora_Revenue/Zuora_Billing_-_Revenue_Integration) feature enabled.   |  [optional] |
|**externalId** | **String** | The external id of the Fulfillment.  |  [optional] |
|**fulfillmentDate** | **LocalDate** | The date of the Fulfillment.  |  [optional] |
|**fulfillmentLocation** | **String** | The fulfillment location of the Fulfillment. The available values can be configured in **Billing Settings** &gt; **Fulfillment Settings** through Zuora UI.  |  [optional] |
|**fulfillmentSystem** | **String** | The fulfillment system of the Fulfillment. The available values can be configured in **Billing Settings** &gt; **Fulfillment Settings** through Zuora UI.  |  [optional] |
|**fulfillmentType** | [**FulfillmentTypeEnum**](#FulfillmentTypeEnum) | The type of the Fulfillment.   |  [optional] |
|**orderLineItemId** | **UUID** | The reference id of the related Order Line Item.  |  [optional] |
|**quantity** | **Double** | The quantity of the Fulfillment.  |  [optional] |
|**state** | [**StateEnum**](#StateEnum) | The state of the Fulfillment. See [State transitions for an order, order line item, and fulfillment](https://knowledgecenter.zuora.com/Billing/Subscriptions/Orders/Order_Line_Items/AB_Order_Line_Item_States_and_Order_States) for more information.  |  [optional] |
|**trackingNumber** | **String** | The tracking number of the Fulfillment.  |  [optional] |



## Enum: FulfillmentTypeEnum

| Name | Value |
|---- | -----|
| DELIVERY | &quot;Delivery&quot; |
| RETURN | &quot;Return&quot; |



## Enum: StateEnum

| Name | Value |
|---- | -----|
| EXECUTING | &quot;Executing&quot; |
| BOOKED | &quot;Booked&quot; |
| SENTTOBILLING | &quot;SentToBilling&quot; |
| COMPLETE | &quot;Complete&quot; |
| CANCELLED | &quot;Cancelled&quot; |



