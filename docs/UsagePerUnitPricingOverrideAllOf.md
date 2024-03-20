

# UsagePerUnitPricingOverrideAllOf


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**listPrice** | **Double** | Per-unit price of the charge.  |  [optional] |
|**originalListPrice** | **Double** | The original list price is the price of a product or service at which it is listed for sale by a manufacturer or retailer.  |  [optional] |
|**ratingGroup** | [**RatingGroupEnum**](#RatingGroupEnum) | Specifies how Zuora groups usage records when rating usage. See [Usage Rating by Group](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/J_Billing_Operations/Usage/Usage_Rating_by_Group) for more information.   * ByBillingPeriod (default): The rating is based on all the usages in a billing period.   * ByUsageStartDate: The rating is based on all the usages on the same usage start date.    * ByUsageRecord: The rating is based on each usage record.   * ByUsageUpload: The rating is based on all the usages in a uploaded usage file (.xls or .csv). If you import a mass usage in a single upload, which contains multiple usage files in .xls or .csv format, usage records are grouped for each usage file.  |  [optional] |
|**uom** | **Double** | Unit of measure of the standalone charge.  **Note:** This field is available when the &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Manage_subscription_transactions/Orders/Standalone_Orders/AA_Overview_of_Standalone_Orders\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Standalone Orders&lt;/a&gt; feature is enabled.  |  [optional] |



## Enum: RatingGroupEnum

| Name | Value |
|---- | -----|
| BYBILLINGPERIOD | &quot;ByBillingPeriod&quot; |
| BYUSAGESTARTDATE | &quot;ByUsageStartDate&quot; |
| BYUSAGERECORD | &quot;ByUsageRecord&quot; |
| BYUSAGEUPLOAD | &quot;ByUsageUpload&quot; |



