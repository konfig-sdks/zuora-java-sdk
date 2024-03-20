

# PostOrderResponseType

Response information of orders.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**processId** | **String** | The ID of the process that handles the operation.  |  [optional] |
|**reasons** | [**List&lt;CommonResponseReasonsInner&gt;**](CommonResponseReasonsInner.md) |  |  [optional] |
|**requestId** | **UUID** | Unique identifier of the request.  |  [optional] |
|**success** | **Boolean** | Indicates whether the call succeeded.  |  [optional] |
|**accountId** | **String** | The account ID for the order. This field is returned instead of the &#x60;accountNumber&#x60; field if the &#x60;returnIds&#x60; query parameter is set to &#x60;true&#x60;. |  [optional] |
|**accountNumber** | **String** | The account number for the order. |  [optional] |
|**creditMemoIds** | **List&lt;String&gt;** | An array of the credit memo IDs generated in this order request. The credit memo is only available if you have the Invoice Settlement feature enabled. This field is returned instead of the &#x60;creditMemoNumbers&#x60; field if the &#x60;returnIds&#x60; query parameter is set to &#x60;true&#x60;. |  [optional] |
|**creditMemoNumbers** | **List&lt;String&gt;** | An array of the credit memo numbers generated in this order request. The credit memo is only available if you have the Invoice Settlement feature enabled. |  [optional] |
|**invoiceIds** | **List&lt;String&gt;** | An array of the invoice IDs generated in this order request. Normally it includes one invoice ID only, but can include multiple items when a subscription was tagged as invoice separately. This field is returned instead of the &#x60;invoiceNumbers&#x60; field if the &#x60;returnIds&#x60; query parameter is set to &#x60;true&#x60;. |  [optional] |
|**invoiceNumbers** | **List&lt;String&gt;** | An array of the invoice numbers generated in this order request. Normally it includes one invoice number only, but can include multiple items when a subscription was tagged as invoice separately. |  [optional] |
|**orderId** | **String** | The ID of the order created. This field is returned instead of the &#x60;orderNumber&#x60; field if the &#x60;returnIds&#x60; query parameter is set to &#x60;true&#x60;. |  [optional] |
|**orderLineItems** | [**List&lt;PostOrderResponseTypeAllOfOrderLineItems&gt;**](PostOrderResponseTypeAllOfOrderLineItems.md) |  |  [optional] |
|**orderNumber** | **String** | The order number of the order created. |  [optional] |
|**paidAmount** | **String** | The total amount collected in this order request. |  [optional] |
|**paymentId** | **String** | The payment Id that is collected in this order request. This field is returned instead of the &#x60;paymentNumber&#x60; field if the &#x60;returnIds&#x60; query parameter is set to &#x60;true&#x60;. |  [optional] |
|**paymentNumber** | **String** | The payment number that is collected in this order request. |  [optional] |
|**ramps** | [**List&lt;PostOrderResponseTypeAllOfRamps&gt;**](PostOrderResponseTypeAllOfRamps.md) | **Note**: This field is only available if you have the Ramps feature enabled. The [Orders](https://knowledgecenter.zuora.com/Billing/Subscriptions/Orders/AA_Overview_of_Orders) feature must be enabled before you can access the [Ramps](https://knowledgecenter.zuora.com/Billing/Subscriptions/Orders/Ramps_and_Ramp_Metrics/A_Overview_of_Ramps_and_Ramp_Metrics) feature. The Ramps feature is available for customers with Enterprise and Nine editions by default. If you are a Growth customer, see [Zuora Editions](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/C_Zuora_Editions) for pricing information coming October 2020.  The ramp definitions created by this order request.  |  [optional] |
|**refunds** | [**List&lt;PostOrderResponseTypeAllOfRefunds&gt;**](PostOrderResponseTypeAllOfRefunds.md) |  |  [optional] |
|**status** | [**StatusEnum**](#StatusEnum) | Status of the order. &#x60;Pending&#x60; is only applicable for an order that contains a &#x60;CreateSubscription&#x60; order action. |  [optional] |
|**subscriptionIds** | **List&lt;String&gt;** | Container for the subscription IDs of the subscriptions in an order. This field is returned if the &#x60;returnIds&#x60; query parameter is set to &#x60;true&#x60;. |  [optional] |
|**subscriptionNumbers** | **List&lt;String&gt;** | Container for the subscription numbers of the subscriptions in an order. Subscriptions in the response are displayed in the same sequence as the subscriptions defined in the request. |  [optional] |
|**subscriptions** | [**List&lt;PostOrderResponseTypeAllOfSubscriptions&gt;**](PostOrderResponseTypeAllOfSubscriptions.md) | **Note:** This field is in Zuora REST API version control. Supported minor versions are 223.0 or later [available versions](https://developer.zuora.com/api-references/api/overview/#section/API-Versions/Minor-Version). To use this field in the method, you must set the &#x60;zuora-version&#x60; parameter to the minor version number in the request header.  Container for the subscription numbers and statuses in an order.  |  [optional] |
|**writeOff** | [**List&lt;PostOrderResponseTypeAllOfWriteOff&gt;**](PostOrderResponseTypeAllOfWriteOff.md) |  |  [optional] |



## Enum: StatusEnum

| Name | Value |
|---- | -----|
| DRAFT | &quot;Draft&quot; |
| PENDING | &quot;Pending&quot; |
| COMPLETED | &quot;Completed&quot; |



