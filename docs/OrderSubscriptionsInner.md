

# OrderSubscriptionsInner


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**baseVersion** | **Integer** | The base version of the subscription. |  [optional] |
|**customFields** | **Map&lt;String, Object&gt;** | Container for custom fields of a Subscription object.  |  [optional] |
|**externallyManagedBy** | [**ExternallyManagedByEnum**](#ExternallyManagedByEnum) | An enum field on the Subscription object to indicate the name of a third-party store. This field is used to represent subscriptions created through third-party stores.  |  [optional] |
|**newVersion** | **Integer** | The latest version of the subscription. |  [optional] |
|**orderActions** | [**List&lt;OrderAction&gt;**](OrderAction.md) |  |  [optional] |
|**quote** | [**QuoteObjectFields**](QuoteObjectFields.md) |  |  [optional] |
|**ramp** | [**List&lt;RampResponse&gt;**](RampResponse.md) | **Note**: This field is only available if you have the Ramps feature enabled. The [Orders](https://knowledgecenter.zuora.com/Billing/Subscriptions/Orders/AA_Overview_of_Orders) feature must be enabled before you can access the [Ramps](https://knowledgecenter.zuora.com/Billing/Subscriptions/Orders/Ramps_and_Ramp_Metrics/A_Overview_of_Ramps_and_Ramp_Metrics) feature. The Ramps feature is available for customers with Enterprise and Nine editions by default. If you are a Growth customer, see [Zuora Editions](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/C_Zuora_Editions) for pricing information coming October 2020.  The ramp definition.  |  [optional] |
|**sequence** | **Integer** | The sequence number of a certain subscription processed by the order. |  [optional] |
|**subscriptionNumber** | **String** | The new subscription number for a new subscription created, or the existing subscription number. Unlike the order request, the subscription number here always has a value. |  [optional] |
|**subscriptionOwnerAccountNumber** | **String** | The number of the account that owns the subscription. |  [optional] |



## Enum: ExternallyManagedByEnum

| Name | Value |
|---- | -----|
| AMAZON | &quot;Amazon&quot; |
| APPLE | &quot;Apple&quot; |
| GOOGLE | &quot;Google&quot; |
| ROKU | &quot;Roku&quot; |



