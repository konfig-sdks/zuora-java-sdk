

# QuoteObjectFields

The fields populated for a quote when a quote is sent to Zuora Billing from Zuora Quote. 

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**opportunityCloseDateQT** | **String** | The closing date of the Opportunity.  This field is used in Zuora Reporting Data Sources to report on Subscription metrics.  If the subscription was originated from Zuora Quotes, the value is populated with the value from Zuora Quotes.  |  [optional] |
|**opportunityNameQT** | **String** | The unique identifier of the Opportunity.   This field is used in the Zuora Reporting Data Sources to report on Subscription metrics.  If the subscription was originated from Zuora Quotes, the value is populated with the value from Zuora Quotes.  **Character limit**: 100  |  [optional] |
|**quoteBusinessTypeQT** | **String** | The specific identifier for the type of business transaction the Quote represents such as New, Upsell, Downsell, Renewal or Churn.  This field is used in the Zuora Reporting Data Sources to report on Subscription metrics.  If the subscription was originated from Zuora Quotes, the value is populated with the value from Zuora Quotes.  **Character limit**: 32  |  [optional] |
|**quoteNumberQT** | **String** | The unique identifier of the Quote.  This field is used in the Zuora Reporting Data Sources to report on Subscription metrics.  If the subscription was originated from Zuora Quotes, the value is populated with the value from Zuora Quotes.  **Character limit**: 32  |  [optional] |
|**quoteTypeQT** | **String** | The Quote type that represents the subscription lifecycle stage such as New, Amendment, Renew or Cancel.  This field is used in the Zuora Reporting Data Sources to report on Subscription metrics.  If the subscription was originated from Zuora Quotes, the value is populated with the value from Zuora Quotes.  **Character limit**: 32  |  [optional] |



