

# POSTOrderPreviewAsyncRequestType


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**description** | **String** | A description of the order. |  [optional] |
|**category** | [**CategoryEnum**](#CategoryEnum) | Category of the order to indicate a product sale or return. Default value is &#x60;NewSales&#x60;.  |  [optional] |
|**customFields** | **Map&lt;String, Object&gt;** | Container for custom fields of an Order object.  |  [optional] |
|**existingAccountNumber** | **String** | The account number that this order will be created under.  Note that invoice owner account of the subscriptions included in this order should be the same with the account of the order.  |  [optional] |
|**orderDate** | **LocalDate** | The date when the order is signed. All of the order actions under this order will use this order date as the contract effective date. |  |
|**orderLineItems** | [**List&lt;OrderLineItemCommonPostOrder&gt;**](OrderLineItemCommonPostOrder.md) | [Order Line Items](https://knowledgecenter.zuora.com/Billing/Subscriptions/Orders/Order_Line_Items/AA_Overview_of_Order_Line_Items) are non subscription based items created by an Order, representing transactional charges such as one-time fees, physical goods, or professional service charges that are not sold as subscription services.   With the Order Line Items feature enabled, you can now launch non-subscription and unified monetization business models in Zuora, in addition to subscription business models.   **Note:** The [Order Line Items](https://knowledgecenter.zuora.com/Billing/Subscriptions/Orders/Order_Line_Items/AA_Overview_of_Order_Line_Items) feature is now generally available to all Zuora customers. You need to enable the [Orders](https://knowledgecenter.zuora.com/BC_Subscription_Management/Orders/AA_Overview_of_Orders#Orders) feature to access the [Order Line Items](https://knowledgecenter.zuora.com/Billing/Subscriptions/Orders/Order_Line_Items/AA_Overview_of_Order_Line_Items) feature. As of Zuora Billing Release 313 (November 2021), new customers who onboard on [Orders](https://knowledgecenter.zuora.com/Billing/Subscriptions/Orders/AA_Overview_of_Orders) will have the [Order Line Items](https://knowledgecenter.zuora.com/Billing/Subscriptions/Orders/Order_Line_Items) feature enabled by default.         |  [optional] |
|**orderNumber** | **String** | The order number of this order.    **Note:** Make sure the order number does not contain a slash.  |  [optional] |
|**previewAccountInfo** | [**PreviewAccountInfo**](PreviewAccountInfo.md) |  |  [optional] |
|**previewOptions** | [**PreviewOptions**](PreviewOptions.md) |  |  |
|**reasonCode** | **String** | Values of reason code configured in **Billing Settings** &gt; **Configure Reason Codes** through Zuora UI. Indicates the reason when a return order line item occurs.  |  [optional] |
|**subscriptions** | [**List&lt;POSTOrderPreviewRequestTypeSubscriptionsInner&gt;**](POSTOrderPreviewRequestTypeSubscriptionsInner.md) | Each item includes a set of order actions, which will be applied to the same base subscription. |  [optional] |



## Enum: CategoryEnum

| Name | Value |
|---- | -----|
| NEWSALES | &quot;NewSales&quot; |
| RETURN | &quot;Return&quot; |



