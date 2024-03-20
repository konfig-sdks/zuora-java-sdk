

# Order

Represents the order information that will be returned in the GET call.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**description** | **String** | A description of the order. |  [optional] |
|**category** | [**CategoryEnum**](#CategoryEnum) | Category of the order to indicate a product sale or return. Default value is &#x60;NewSales&#x60;.  |  [optional] |
|**createdBy** | **String** | The ID of the user who created this order. |  [optional] |
|**createdDate** | **String** | The time that the order gets created in the system, in the &#x60;YYYY-MM-DD HH:MM:SS&#x60; format. |  [optional] |
|**currency** | **String** | Currency code. |  [optional] |
|**customFields** | **Map&lt;String, Object&gt;** | Container for custom fields of an Order object.  |  [optional] |
|**existingAccountNumber** | **String** | The account number that this order has been created under. This is also the invoice owner of the subscriptions included in this order. |  [optional] |
|**invoiceScheduleId** | **Integer** | The ID of the invoice schedule associated with the order.  **Note**: This field is available only if you have the &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/Billing_Schedule\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Billing Schedule&lt;/a&gt; feature enabled.  |  [optional] |
|**orderDate** | **LocalDate** | The date when the order is signed. All the order actions under this order will use this order date as the contract effective date if no additinal contractEffectiveDate is provided. |  [optional] |
|**orderLineItems** | [**List&lt;OrderLineItemRetrieveOrder&gt;**](OrderLineItemRetrieveOrder.md) | [Order Line Items](https://knowledgecenter.zuora.com/Billing/Subscriptions/Orders/Order_Line_Items/AA_Overview_of_Order_Line_Items) are non subscription based items created by an Order, representing transactional charges such as one-time fees, physical goods, or professional service charges that are not sold as subscription services.   With the Order Line Items feature enabled, you can now launch non-subscription and unified monetization business models in Zuora, in addition to subscription business models.   **Note:** The [Order Line Items](https://knowledgecenter.zuora.com/Billing/Subscriptions/Orders/Order_Line_Items/AA_Overview_of_Order_Line_Items) feature is now generally available to all Zuora customers. You need to enable the [Orders](https://knowledgecenter.zuora.com/BC_Subscription_Management/Orders/AA_Overview_of_Orders#Orders) feature to access the [Order Line Items](https://knowledgecenter.zuora.com/Billing/Subscriptions/Orders/Order_Line_Items/AA_Overview_of_Order_Line_Items) feature. As of Zuora Billing Release 313 (November 2021), new customers who onboard on [Orders](https://knowledgecenter.zuora.com/Billing/Subscriptions/Orders/AA_Overview_of_Orders) will have the [Order Line Items](https://knowledgecenter.zuora.com/Billing/Subscriptions/Orders/Order_Line_Items) feature enabled by default.         |  [optional] |
|**orderNumber** | **String** | The order number of the order. |  [optional] |
|**organizationLabel** | **String** | The organization that this object belongs to.  Note: This field is available only when the Multi-Org feature is enabled.  |  [optional] |
|**reasonCode** | **String** | Values of reason code configured in **Billing Settings** &gt; **Configure Reason Codes** through Zuora UI. Indicates the reason when a return order line item occurs.  |  [optional] |
|**schedulingOptions** | [**OrderSchedulingOptions**](OrderSchedulingOptions.md) |  |  [optional] |
|**scheduledOrderActivationResponse** | [**PostOrderResponseType**](PostOrderResponseType.md) |  |  [optional] |
|**status** | [**StatusEnum**](#StatusEnum) | The status of the order. If the order contains any &#x60;Pending Activation&#x60; or &#x60;Pending Acceptance&#x60; subscription, the order status will be &#x60;Pending&#x60;; If the order is in draft status, the order status will be &#x60;Draft&#x60;; otherwise the order status is &#x60;Completed&#x60;.  The available order statuses are as follow: - &#x60;Draft&#x60;: The order is in draft status. - &#x60;Pending&#x60;: The order is in pending status. - &#x60;Completed&#x60;: The order is in completed status. - &#x60;Cancelled&#x60;: The draft or scheduled order is cancelled. - &#x60;Scheduled&#x60;: The order is in scheduled status and it is only valid if the Scheduled Orders feature is enabled. - &#x60;Executing&#x60;: The scheduled order is executed by a scheduler and it is only valid if the Scheduled Orders feature is enabled. - &#x60;Failed&#x60;: The scheduled order has failed.  **Note**: To manage and access the &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Manage_subscription_transactions/Orders/AA_Overview_of_Orders/P_Scheduled_Orders\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Scheduled Orders&lt;/a&gt; feature from the self-service interface, see &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Configure_billing_settings/System_settings/Enable_billing_features_by_yourself\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Enable billing features by yourself&lt;/a&gt;.  |  [optional] |
|**subscriptions** | [**List&lt;OrderSubscriptionsInner&gt;**](OrderSubscriptionsInner.md) | Represents a processed subscription, including the origin request (order actions) that create this version of subscription and the processing result (order metrics). The reference part in the request will be overridden with the info in the new subscription version. |  [optional] |
|**updatedBy** | **String** | The ID of the user who updated this order. |  [optional] |
|**updatedDate** | **String** | The time that the order gets updated in the system(for example, an order description update), in the &#x60;YYYY-MM-DD HH:MM:SS&#x60; format. |  [optional] |



## Enum: CategoryEnum

| Name | Value |
|---- | -----|
| NEWSALES | &quot;NewSales&quot; |
| RETURN | &quot;Return&quot; |



## Enum: StatusEnum

| Name | Value |
|---- | -----|
| DRAFT | &quot;Draft&quot; |
| PENDING | &quot;Pending&quot; |
| COMPLETED | &quot;Completed&quot; |
| CANCELLED | &quot;Cancelled&quot; |
| SCHEDULED | &quot;Scheduled&quot; |
| EXECUTING | &quot;Executing&quot; |
| FAILED | &quot;Failed&quot; |



