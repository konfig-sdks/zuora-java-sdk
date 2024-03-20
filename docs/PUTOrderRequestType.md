

# PUTOrderRequestType


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**description** | **String** | A description of the order. |  [optional] |
|**category** | [**CategoryEnum**](#CategoryEnum) | Category of the order to indicate a product sale or return. Default value is &#x60;NewSales&#x60;.  |  [optional] |
|**customFields** | **Map&lt;String, Object&gt;** | Container for custom fields of an Order object.  |  [optional] |
|**existingAccountNumber** | **String** | The account number that this order will be created under. Note that this actually specifies the invoice owner account of the subscriptions included in this order.  |  [optional] |
|**externallyManagedBy** | [**ExternallyManagedByEnum**](#ExternallyManagedByEnum) | An enum field on the Subscription object to indicate the name of a third-party store. This field is used to represent subscriptions created through third-party stores.  |  [optional] |
|**orderDate** | **LocalDate** | The date when the order is signed. All the order actions under this order will use this order date as the contract effective date if the contract effective date field is skipped or its value is left as null. |  |
|**orderLineItems** | [**List&lt;OrderLineItemCommonPostOrder&gt;**](OrderLineItemCommonPostOrder.md) | [Order Line Items](https://knowledgecenter.zuora.com/Billing/Subscriptions/Orders/Order_Line_Items/AA_Overview_of_Order_Line_Items) are non subscription based items created by an Order, representing transactional charges such as one-time fees, physical goods, or professional service charges that are not sold as subscription services.   With the Order Line Items feature enabled, you can now launch non-subscription and unified monetization business models in Zuora, in addition to subscription business models.  **Note:** The [Order Line Items](https://knowledgecenter.zuora.com/Billing/Subscriptions/Orders/Order_Line_Items/AA_Overview_of_Order_Line_Items) feature is now generally available to all Zuora customers. You need to enable the [Orders](https://knowledgecenter.zuora.com/BC_Subscription_Management/Orders/AA_Overview_of_Orders#Orders) feature to access the [Order Line Items](https://knowledgecenter.zuora.com/Billing/Subscriptions/Orders/Order_Line_Items/AA_Overview_of_Order_Line_Items) feature. As of Zuora Billing Release 313 (November 2021), new customers who onboard on [Orders](https://knowledgecenter.zuora.com/Billing/Subscriptions/Orders/AA_Overview_of_Orders) will have the [Order Line Items](https://knowledgecenter.zuora.com/Billing/Subscriptions/Orders/Order_Line_Items) feature enabled by default.          |  [optional] |
|**orderNumber** | **String** | The order number of the new order. If not provided, system will auto-generate a number for this order.    **Note:** Make sure the order number does not contain a slash.   |  [optional] |
|**processingOptions** | [**ProcessingOptionsOrders**](ProcessingOptionsOrders.md) |  |  [optional] |
|**reasonCode** | **String** | Values of reason code configured in **Billing Settings** &gt; **Configure Reason Codes** through Zuora UI. Indicates the reason when a return order line item occurs.  |  [optional] |
|**schedulingOptions** | [**POSTOrderRequestTypeSchedulingOptions**](POSTOrderRequestTypeSchedulingOptions.md) |  |  [optional] |
|**status** | [**StatusEnum**](#StatusEnum) | The status of the order. The default value is &#x60;Completed&#x60;. The following values are supported: - &#x60;Draft&#x60;: The order is in draft status. - &#x60;Pending&#x60;: The order is in pending status. - &#x60;Completed&#x60;: The order is in completed status. - &#x60;Scheduled&#x60;: The order is in scheduled status and it is only valid if the Scheduled Orders feature is enabled. - &#x60;Executing&#x60;: The scheduled order is executed by a scheduler and it is only valid if the Scheduled Orders feature is enabled. - &#x60;Failed&#x60;: The scheduled order has failed.  **Note**: To manage and access the &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Manage_subscription_transactions/Orders/AA_Overview_of_Orders/P_Scheduled_Orders\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Scheduled Orders&lt;/a&gt; feature from the self-service interface, see &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Configure_billing_settings/System_settings/Enable_billing_features_by_yourself\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Enable billing features by yourself&lt;/a&gt;.  |  [optional] |
|**subscriptions** | [**List&lt;POSTOrderRequestTypeSubscriptionsInner&gt;**](POSTOrderRequestTypeSubscriptionsInner.md) | Each item includes a set of order actions, which will be applied to the same base subscription. |  [optional] |



## Enum: CategoryEnum

| Name | Value |
|---- | -----|
| NEWSALES | &quot;NewSales&quot; |
| RETURN | &quot;Return&quot; |



## Enum: ExternallyManagedByEnum

| Name | Value |
|---- | -----|
| AMAZON | &quot;Amazon&quot; |
| APPLE | &quot;Apple&quot; |
| GOOGLE | &quot;Google&quot; |
| ROKU | &quot;Roku&quot; |



## Enum: StatusEnum

| Name | Value |
|---- | -----|
| DRAFT | &quot;Draft&quot; |
| PENDING | &quot;Pending&quot; |
| COMPLETED | &quot;Completed&quot; |
| SCHEDULED | &quot;Scheduled&quot; |



