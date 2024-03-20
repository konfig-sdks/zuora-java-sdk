

# POSTAccountTypeSubscription

Container for subscription information, used if creating a subscription for the new account at the time of account creation. 

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**autoRenew** | **Boolean** | If &#x60;true&#x60;, auto-renew is enabled. Default is &#x60;false&#x60;.  |  [optional] |
|**contractEffectiveDate** | **LocalDate** | Effective contract date for this subscription, as &#x60;yyyy-mm-dd&#x60;.  |  |
|**customerAcceptanceDate** | **LocalDate** | The date on which the services or products within a subscription have been accepted by the customer, as &#x60;yyyy-mm-dd&#x60;.  Default value is dependent on the value of other fields. See Notes section for more details.  |  [optional] |
|**initialTerm** | **Long** | Duration of the initial subscription term in whole months.  Default is 0.   |  [optional] |
|**invoiceOwnerAccountKey** | **String** | Invoice owner account number or ID.  **Note:** This feature is in Limited Availability. If you wish to have access to the feature, submit a request at [Zuora Global Support](https://support.zuora.com).   |  [optional] |
|**invoiceSeparately** | **Boolean** | Separates a single subscription from other subscriptions and invoices the charge independently.   If the value is &#x60;true&#x60;, the subscription is billed separately from other subscriptions. If the value is &#x60;false&#x60;, the subscription is included with other subscriptions in the account invoice. The default value is &#x60;false&#x60;.  Prerequisite: The default subscription setting &#x60;Enable Subscriptions to be Invoiced Separately&#x60; must be set to &#x60;Yes&#x60;.  |  [optional] |
|**notes** | **String** |  |  [optional] |
|**renewalTerm** | **Long** | Duration of the renewal term in whole months. Default is 0.  |  [optional] |
|**serviceActivationDate** | **LocalDate** | The date on which the services or products within a subscription have been activated and access has been provided to the customer, as &#x60;yyyy-mm-dd&#x60;.  Default value is dependent on the value of other fields. See Notes section for more details.  |  [optional] |
|**subscribeToRatePlans** | [**List&lt;POSTSrpCreateType&gt;**](POSTSrpCreateType.md) | Container for one or more rate plans for this subscription.  |  [optional] |
|**subscriptionNumber** | **String** | Subscription Number. The value can be up to 1000 characters.  If you do not specify a subscription number when creating a subscription for the new account, Zuora will generate a subscription number automatically.  If the account is created successfully, the subscription number is returned in the &#x60;subscriptionNumber&#x60; response field.  |  [optional] |
|**termStartDate** | **LocalDate** | The date on which the subscription term begins, as &#x60;yyyy-mm-dd&#x60;. If this is a renewal subscription, this date is different from the subscription start date.  |  [optional] |
|**termType** | **String** | Possible values are: &#x60;TERMED&#x60;, &#x60;EVERGREEN&#x60;.  |  |
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



