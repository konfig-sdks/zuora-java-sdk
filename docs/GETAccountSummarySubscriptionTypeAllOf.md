

# GETAccountSummarySubscriptionTypeAllOf


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**autoRenew** | **Boolean** | If &#x60;true&#x60;, auto-renew is enabled. If &#x60;false&#x60;, auto-renew is disabled.  |  [optional] |
|**id** | **String** | Subscription ID.  |  [optional] |
|**initialTerm** | **String** | Duration of the initial subscription term in whole months.   |  [optional] |
|**ratePlans** | [**List&lt;GETAccountSummarySubscriptionRatePlanType&gt;**](GETAccountSummarySubscriptionRatePlanType.md) | Container for rate plans for this subscription.  |  [optional] |
|**renewalTerm** | **String** | Duration of the renewal term in whole months.  |  [optional] |
|**status** | **String** | Subscription status; possible values are: &#x60;Draft&#x60;, &#x60;PendingActivation&#x60;, &#x60;PendingAcceptance&#x60;, &#x60;Active&#x60;, &#x60;Cancelled&#x60;, &#x60;Expired&#x60;.  |  [optional] |
|**subscriptionNumber** | **String** | Subscription Number.  |  [optional] |
|**subscriptionStartDate** | **LocalDate** | Subscription start date.  |  [optional] |
|**termEndDate** | **LocalDate** | End date of the subscription term. If the subscription is evergreen, this is either null or equal to the cancellation date, as appropriate.  |  [optional] |
|**termStartDate** | **LocalDate** | Start date of the subscription term. If this is a renewal subscription, this date is different than the subscription start date.  |  [optional] |
|**termType** | **String** | Possible values are: &#x60;TERMED&#x60;, &#x60;EVERGREEN&#x60;.  |  [optional] |



