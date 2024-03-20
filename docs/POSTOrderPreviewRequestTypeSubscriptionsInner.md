

# POSTOrderPreviewRequestTypeSubscriptionsInner


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**customFields** | **Map&lt;String, Object&gt;** | Container for custom fields of a Subscription object.  |  [optional] |
|**orderActions** | [**List&lt;PreviewOrderOrderAction&gt;**](PreviewOrderOrderAction.md) | The actions to be applied to the subscription. Order actions will be stored with the sequence when it was provided in the request. |  [optional] |
|**quote** | [**QuoteObjectFields**](QuoteObjectFields.md) |  |  [optional] |
|**ramp** | [**RampRequest**](RampRequest.md) |  |  [optional] |
|**subscriptionNumber** | **String** | Leave this field empty to represent new subscription creation, or specify a subscription number to update an existing subscription.  |  [optional] |



