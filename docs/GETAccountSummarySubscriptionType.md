

# GETAccountSummarySubscriptionType


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
|**cpqBundleJsonIdQT** | **String** | The Bundle product structures from Zuora Quotes if you utilize Bundling in Salesforce. Do not change the value in this field.  |  [optional] |
|**opportunityCloseDateQT** | **LocalDate** | The closing date of the Opportunity. This field is used in Zuora data sources to report on Subscription metrics. If the subscription originated from Zuora Quotes, the value is populated with the value from Zuora Quotes.  |  [optional] |
|**opportunityNameQT** | **String** | The unique identifier of the Opportunity. This field is used in Zuora data sources to report on Subscription metrics. If the subscription originated from Zuora Quotes, the value is populated with the value from Zuora Quotes.  |  [optional] |
|**quoteBusinessTypeQT** | **String** | The specific identifier for the type of business transaction the Quote represents such as New, Upsell, Downsell, Renewal or Churn. This field is used in Zuora data sources to report on Subscription metrics. If the subscription originated from Zuora Quotes, the value is populated with the value from Zuora Quotes.  |  [optional] |
|**quoteNumberQT** | **String** | The unique identifier of the Quote. This field is used in Zuora data sources to report on Subscription metrics. If the subscription originated from Zuora Quotes, the value is populated with the value from Zuora Quotes.  |  [optional] |
|**quoteTypeQT** | **String** | The Quote type that represents the subscription lifecycle stage such as New, Amendment, Renew or Cancel. This field is used in Zuora data sources to report on Subscription metrics. If the subscription originated from Zuora Quotes, the value is populated with the value from Zuora Quotes.  |  [optional] |
|**integrationIdNS** | **String** | ID of the corresponding object in NetSuite. Only available if you have installed the [Zuora Connector for NetSuite](https://www.zuora.com/connect/app/?appId&#x3D;265).  |  [optional] |
|**integrationStatusNS** | **String** | Status of the subscription&#39;s synchronization with NetSuite. Only available if you have installed the [Zuora Connector for NetSuite](https://www.zuora.com/connect/app/?appId&#x3D;265).  |  [optional] |
|**projectNS** | **String** | The NetSuite project that the subscription was created from. Only available if you have installed the [Zuora Connector for NetSuite](https://www.zuora.com/connect/app/?appId&#x3D;265).  |  [optional] |
|**salesOrderNS** | **String** | The NetSuite sales order than the subscription was created from. Only available if you have installed the [Zuora Connector for NetSuite](https://www.zuora.com/connect/app/?appId&#x3D;265).  |  [optional] |
|**syncDateNS** | **String** | Date when the subscription was synchronized with NetSuite. Only available if you have installed the [Zuora Connector for NetSuite](https://www.zuora.com/connect/app/?appId&#x3D;265).  |  [optional] |



