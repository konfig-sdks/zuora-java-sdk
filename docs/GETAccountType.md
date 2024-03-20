

# GETAccountType


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**basicInfo** | [**GETAccountTypeBasicInfo**](GETAccountTypeBasicInfo.md) |  |  [optional] |
|**billToContact** | [**GETAccountTypeBillToContact**](GETAccountTypeBillToContact.md) |  |  [optional] |
|**billingAndPayment** | [**GETAccountTypeBillingAndPayment**](GETAccountTypeBillingAndPayment.md) |  |  [optional] |
|**einvoiceProfile** | [**GetAccountEInvoiceProfile**](GetAccountEInvoiceProfile.md) |  |  [optional] |
|**metrics** | [**GETAccountTypeMetrics**](GETAccountTypeMetrics.md) |  |  [optional] |
|**metricsData** | [**List&lt;GETAccountCurrencyMetricsType&gt;**](GETAccountCurrencyMetricsType.md) | Container for account metrics of different currencies. **Note**: This field is available only if you have the &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Bill_your_customers/Flexible_Billing/Multiple_Currencies\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Multiple Currencies&lt;/a&gt; feature enabled.  |  [optional] |
|**soldToContact** | [**GETAccountTypeSoldToContact**](GETAccountTypeSoldToContact.md) |  |  [optional] |
|**success** | **Boolean** | Returns &#x60;true&#x60; if the request was processed successfully.  |  [optional] |
|**taxInfo** | [**GETAccountTypeTaxInfo**](GETAccountTypeTaxInfo.md) |  |  [optional] |



