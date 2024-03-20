

# SubscriptionData


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**customFields** | **Map&lt;String, Object&gt;** | Container for custom fields.  |  [optional] |
|**invoiceSeparately** | **Boolean** | Specifies whether the subscription appears on a separate invoice when Zuora generates invoices.  |  [optional] |
|**notes** | **String** | Notes about the subscription. These notes are only visible to Zuora users.  |  [optional] |
|**ratePlans** | [**List&lt;RatePlan&gt;**](RatePlan.md) |  |  [optional] |
|**startDate** | **LocalDate** |  |  [optional] |
|**subscriptionNumber** | **String** | Subscription number of the subscription to create, for example, A-S00000001.  If you do not set this field, Zuora will generate a subscription number.  |  [optional] |
|**terms** | [**TermInfo**](TermInfo.md) |  |  [optional] |



