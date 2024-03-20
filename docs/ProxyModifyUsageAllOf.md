

# ProxyModifyUsageAllOf


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**endDateTime** | **OffsetDateTime** |  The end date and time of a range of time when usage is tracked. Use this field for reporting; this field doesn&#39;t affect usage calculation. **Character limit**: 29 **Values**: a valid date and time value  |  [optional] |
|**quantity** | **Double** |  Indicates the number of units used. **Character limit**: 16 **Values**: a valid decimal amount equal to or greater than 0  |  [optional] |
|**rbeStatus** | **String** |  Indicates if the rating and billing engine (RBE) processed usage data for an invoice. **Character limit**: 9 **Values**: automatically generated to be one of the following values: &#x60;Importing&#x60;, &#x60;Pending&#x60;, &#x60;Processed&#x60;  |  [optional] |
|**startDateTime** | **OffsetDateTime** |  The start date and time of a range of time when usage is tracked. Zuora uses this field value to determine the usage date. Unlike the &#x60;EndDateTime&#x60;, the &#x60;StartDateTime&#x60; field does affect usage calculation. **Character limit**: 29 **Values**: a valid date and time value  |  [optional] |
|**UOM** | **String** |  Specifies the units to measure usage. Units of measure are configured in the web-based UI. Your values depend on your configuration in **Billing Settings**. **Character limit**: **Values**: a valid unit of measure  |  [optional] |



