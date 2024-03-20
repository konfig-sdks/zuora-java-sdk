

# ProxyCreateUsage


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**accountId** | **String** |  The ID of the account associated with the usage data. This field is only required if no value is specified for the &#x60;AccountNumber&#x60; field. **Character limit**: 32 **Values**: a valid account ID.  |  [optional] |
|**accountNumber** | **String** |  The number of the account associated with the usage data. This field is only required if no value is specified for the &#x60;AccountId&#x60; field. **Character limit**: 50 **Values**: a valid account number.  |  [optional] |
|**chargeId** | **String** |  The OrginalId of the rate plan charge related to the usage record, e.g., &#x60;2c9081a03c63c94c013c6873357a0117&#x60; **Character limit**: 32 **Values**: a valid rate plan charge OriginalID.  |  [optional] |
|**chargeNumber** | **String** | A unique number for the rate plan charge related to the usage record. For example, C-00000007.  |  [optional] |
|**description** | **String** | A description of the usage record.  |  [optional] |
|**endDateTime** | **OffsetDateTime** |  The end date and time of a range of time when usage is tracked. Use this field for reporting; this field doesn&#39;t affect usage calculation. **Character limit**: 29 **Values**: a valid date and time value.  |  [optional] |
|**quantity** | **Double** |  Indicates the number of units used. **Character limit**: 16 **Values**: a valid decimal amount equal to or greater than 0  |  |
|**startDateTime** | **OffsetDateTime** |  The start date and time of a range of time when usage is tracked. Zuora uses this field value to determine the usage date. Unlike the &#x60;EndDateTime&#x60;, the &#x60;StartDateTime&#x60; field does affect usage calculation. **Character limit**: 29 **Values**: a valid date and time value  |  |
|**subscriptionId** | **String** | The original ID of the subscription that contains the fees related to the usage data.   The ID of a subscription might change when you create amendments to the subscription. It is good practice to use the unique subscription number that you can specify in the &#x60;SubscriptionNumber&#x60; field.  |  [optional] |
|**subscriptionNumber** | **String** | The unique identifier number of the subscription that contains the fees related to the usage data.  It is good practice to use this field when creating usage records.  |  [optional] |
|**UOM** | **String** | Specifies the units to measure usage. Units of measure are configured in the web-based UI. Your values depend on your configuration in **Billing Settings**. **Character limit**: **Values**: a valid unit of measure   |  |
|**uniqueKey** | **String** | The unique external reference of the usage record. See [Upload usage record with unique key](https://knowledgecenter.zuora.com/Zuora_Billing/Bill_your_customers/Bill_for_usage_or_prepaid_products/Advanced_Consumption_Billing/Unbilled_Usage#Upload_usage_record_with_unique_key) for information on how to use this field. **Note**: This field is only available if you set the &#x60;X-Zuora-WSDL-Version&#x60; request header to &#x60;114&#x60; or later.  |  [optional] |



