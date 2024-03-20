

# JobResultAllOf


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**accountId** | **String** | The account ID for the order. This field is returned only when the &#x60;returnIds&#x60; query parameter in the \&quot;Create an order asynchronously\&quot; operation is set to &#x60;true&#x60;. |  [optional] |
|**accountNumber** | **String** | The account number for the order. |  [optional] |
|**creditMemoIds** | **List&lt;String&gt;** | An array of the credit memo IDs that are generated in the \&quot;Create an order asynchronously\&quot; operation. This field is returned only when the &#x60;returnIds&#x60; query parameter in the \&quot;Create an order asynchronously\&quot; operation is set to &#x60;true&#x60;. |  [optional] |
|**creditMemoNumbers** | **List&lt;String&gt;** | An array of the credit memo numbers generated in this order request. The credit memo is only available if you have the Invoice Settlement feature enabled. |  [optional] |
|**invoiceId** | **List&lt;String&gt;** | An array of the invoice IDs that are generated in the \&quot;Create an order asynchronously\&quot; operation. This field is returned only when the &#x60;returnIds&#x60; query parameter in the \&quot;Create an order asynchronously\&quot; operation is set to &#x60;true&#x60;. |  [optional] |
|**invoiceNumbers** | **List&lt;String&gt;** | An array of the invoice numbers generated in this order request. Normally it includes one invoice number only, but can include multiple items when a subscription was tagged as invoice separately. |  [optional] |
|**orderId** | **String** | The ID of the order created. This field is returned only when the &#x60;returnIds&#x60; query parameter in the \&quot;Create an order asynchronously\&quot; operation is set to &#x60;true&#x60;. |  [optional] |
|**orderLineItems** | [**List&lt;JobResultAllOfOrderLineItems&gt;**](JobResultAllOfOrderLineItems.md) |  |  [optional] |
|**orderNumber** | **String** | The order number of the order created. |  [optional] |
|**paidAmount** | **String** | The total amount collected in this order request. |  [optional] |
|**paymentId** | **String** | The ID of the payment that is collected in the \&quot;Create an order asynchronously\&quot; operation. This field is returned only when the &#x60;returnIds&#x60; query parameter in the \&quot;Create an order asynchronously\&quot; operation is set to &#x60;true&#x60;. |  [optional] |
|**paymentNumber** | **String** | The payment number that collected in this order request. |  [optional] |
|**ramps** | [**List&lt;JobResultAllOfRamps&gt;**](JobResultAllOfRamps.md) | **Note**: This field is only available if you have the Ramps feature enabled. The [Orders](https://knowledgecenter.zuora.com/Billing/Subscriptions/Orders/AA_Overview_of_Orders) feature must be enabled before you can access the [Ramps](https://knowledgecenter.zuora.com/Billing/Subscriptions/Orders/Ramps_and_Ramp_Metrics/A_Overview_of_Ramps_and_Ramp_Metrics) feature. The Ramps feature is available for customers with Enterprise and Nine editions by default. If you are a Growth customer, see [Zuora Editions](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/C_Zuora_Editions) for pricing information coming October 2020.  The ramp definitions created by this order request.  |  [optional] |
|**status** | [**StatusEnum**](#StatusEnum) | Status of the order. &#x60;Pending&#x60; is only applicable for an order that contains a &#x60;CreateSubscription&#x60; order action. |  [optional] |
|**subscriptionIds** | **List&lt;String&gt;** | Container for the IDs of the subscriptions in the order. This field is returned only when the &#x60;returnIds&#x60; query parameter in the \&quot;Create an order asynchronously\&quot; operation is set to &#x60;true&#x60;. |  [optional] |
|**subscriptionNumbers** | **List&lt;String&gt;** | **Note:** This field is in Zuora REST API version control. Supported minor versions are 222.0 or earlier [available versions](https://developer.zuora.com/api-references/api/overview/#section/API-Versions/Minor-Version). To use this field in the method, you must set the &#x60;zuora-version&#x60; parameter to the minor version number in the request header.  Container for the subscription numbers of the subscriptions in an order.  |  [optional] |
|**subscriptions** | [**List&lt;JobResultAllOfSubscriptions&gt;**](JobResultAllOfSubscriptions.md) | **Note:** This field is in Zuora REST API version control. Supported minor versions are 223.0 or later [available versions](https://developer.zuora.com/api-references/api/overview/#section/API-Versions/Minor-Version). To use this field in the method, you must set the &#x60;zuora-version&#x60; parameter to the minor version number in the request header.  Container for the subscription numbers and statuses in an order.  |  [optional] |



## Enum: StatusEnum

| Name | Value |
|---- | -----|
| DRAFT | &quot;Draft&quot; |
| PENDING | &quot;Pending&quot; |
| COMPLETED | &quot;Completed&quot; |



