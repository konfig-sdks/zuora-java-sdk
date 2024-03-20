

# SubscriptionObjectQTFields

Container for Subscription fields provided by Zuora Quotes. 

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**cpqBundleJsonIdQT** | **String** | The Bundle product structures from Zuora Quotes if you utilize Bundling in Salesforce. Do not change the value in this field.  |  [optional] |
|**opportunityCloseDateQT** | **LocalDate** | The closing date of the Opportunity. This field is used in Zuora data sources to report on Subscription metrics. If the subscription originated from Zuora Quotes, the value is populated with the value from Zuora Quotes.  |  [optional] |
|**opportunityNameQT** | **String** | The unique identifier of the Opportunity. This field is used in Zuora data sources to report on Subscription metrics. If the subscription originated from Zuora Quotes, the value is populated with the value from Zuora Quotes.  |  [optional] |
|**quoteBusinessTypeQT** | **String** | The specific identifier for the type of business transaction the Quote represents such as New, Upsell, Downsell, Renewal or Churn. This field is used in Zuora data sources to report on Subscription metrics. If the subscription originated from Zuora Quotes, the value is populated with the value from Zuora Quotes.  |  [optional] |
|**quoteNumberQT** | **String** | The unique identifier of the Quote. This field is used in Zuora data sources to report on Subscription metrics. If the subscription originated from Zuora Quotes, the value is populated with the value from Zuora Quotes.  |  [optional] |
|**quoteTypeQT** | **String** | The Quote type that represents the subscription lifecycle stage such as New, Amendment, Renew or Cancel. This field is used in Zuora data sources to report on Subscription metrics. If the subscription originated from Zuora Quotes, the value is populated with the value from Zuora Quotes.  |  [optional] |



