

# PreviewAccountInfo

Information about the account that will own the order. 

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**billCycleDay** | **Integer** | Day of the month that the account prefers billing periods to begin on. If set to 0, the bill cycle day will be set as \&quot;AutoSet\&quot;. |  |
|**currency** | **String** | ISO 3-letter currency code (uppercase). For example, USD.  |  |
|**customFields** | **Map&lt;String, Object&gt;** | Container for custom fields of an Account object.  |  [optional] |
|**soldToContact** | [**PreviewContactInfo**](PreviewContactInfo.md) |  |  [optional] |
|**taxInfo** | [**TaxInfo**](TaxInfo.md) |  |  [optional] |



