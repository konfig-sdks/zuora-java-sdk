

# JobResultAllOfSubscriptions


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**status** | [**StatusEnum**](#StatusEnum) | Status of the subscription. &#x60;Pending Activation&#x60; and &#x60;Pending Acceptance&#x60; are only applicable for an order that contains a &#x60;CreateSubscription&#x60; order action. |  [optional] |
|**subscriptionNumber** | **String** | Subscription number of the subscription included in this order. |  [optional] |



## Enum: StatusEnum

| Name | Value |
|---- | -----|
| ACTIVE | &quot;Active&quot; |
| PENDING_ACTIVATION | &quot;Pending Activation&quot; |
| PENDING_ACCEPTANCE | &quot;Pending Acceptance&quot; |
| CANCELLED | &quot;Cancelled&quot; |



