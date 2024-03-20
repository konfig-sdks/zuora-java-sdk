

# GETUsageType


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**accountId** | **String** | Customer account ID.  |  [optional] |
|**accountName** | **String** | Customer account name.  |  [optional] |
|**accountNumber** | **String** | Customer account number.  |  [optional] |
|**chargeNumber** | **String** | Number of the rate-plan charge that pays for this usage.  |  [optional] |
|**fileName** | **String** | The name of the import file when the usage record is imported from the file.  |  [optional] |
|**id** | **String** | Unique ID for the usage item.  |  [optional] |
|**organizationLabel** | **String** | The organization that this object belongs to.  Note: This field is available only when the Multi-Org feature is enabled.  |  [optional] |
|**quantity** | **BigDecimal** | Number of units used.  |  [optional] |
|**sourceName** | **String** | Source of the usage data. Possible values are: &#x60;Import&#x60;, &#x60;API&#x60;.  |  [optional] |
|**startDateTime** | **OffsetDateTime** | Start date of the time period in which usage is tracked. Zuora uses this field value to determine the usage date.  |  [optional] |
|**status** | **String** | Possible values are: &#x60;Importing&#x60;, &#x60;Pending&#x60;, &#x60;Processed&#x60;.  |  [optional] |
|**submissionDateTime** | **OffsetDateTime** | Date when usage was submitted.  |  [optional] |
|**subscriptionNumber** | **String** | Number of the subscription covering this usage.  |  [optional] |
|**uniqueKey** | **String** | a customer-defined specific identifier of a usage record.  **Note**: This field is only available if you have the [Prepaid with Drawdown](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/J_Billing_Operations/Prepaid_with_Drawdown) feature enabled. See [Upload usage record with unique key](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/J_Billing_Operations/Prepaid_with_Drawdown/Prepaid_balance_transactions#Upload_usage_record_with_unique_key) for more information.  |  [optional] |
|**unitOfMeasure** | **String** | Unit used to measure consumption.  |  [optional] |



