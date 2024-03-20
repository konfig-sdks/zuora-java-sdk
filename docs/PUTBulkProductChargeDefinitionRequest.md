

# PUTBulkProductChargeDefinitionRequest


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**billingPeriod** | **String** | The override value of the billingPeriod for the product charge definition.  |  [optional] |
|**billingTiming** | [**BillingTimingEnum**](#BillingTimingEnum) | The override value of the billingTiming for the product charge definition.  |  [optional] |
|**chargeModel** | [**ChargeModelEnum**](#ChargeModelEnum) | Determines how to calculate charges. Charge models must be individually activated in Zuora Billing administration.  |  [optional] |
|**defaultQuantity** | **Double** | The default quantity.   This field is applicable only for one-time and recurring charges.  |  [optional] |
|**listPriceBase** | [**ListPriceBaseEnum**](#ListPriceBaseEnum) | The list price base.   This field is applicable only for recurring charges.  **Note**: The &#x60;Per_Year&#x60; enum value is available only if you have the &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Billing/Subscriptions/Product_Catalog/I_Annual_List_Price\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Annual List Price&lt;/a&gt; feature enabled.  |  [optional] |
|**prices** | [**List&lt;POSTProductChargeDefinitionPricing&gt;**](POSTProductChargeDefinitionPricing.md) | Container for the new prices to override the existing prices of the product charge definition.  |  [optional] |
|**productChargeDefinitionKey** | **String** | The unique number or ID of the product charge definition to be updated.  |  [optional] |
|**specificBillingPeriod** | **Double** | The override value of the specificBillingPeriod for the product charge definition.  |  [optional] |
|**specificListPriceBase** | **Integer** | The number of months for the list price base of the charge definition.  The field is &#x60;null&#x60; if the &#x60;listPriceBase&#x60; field is not set to &#x60;Per_Specific_Months&#x60;.  |  [optional] |
|**taxCode** | **String** | Specifies the tax code for taxation rules. This field is equired when the &#x60;Taxable&#x60; field is set to &#x60;True&#x60;.  **Note**: This value affects the tax calculation of the charge.  |  [optional] |
|**taxMode** | [**TaxModeEnum**](#TaxModeEnum) | Determines how to define taxation for the charge. This field is equired when the &#x60;taxable&#x60; field is set to &#x60;true&#x60;.  **Note**: This value affects the tax calculation of the charge.  |  [optional] |
|**taxable** | **Boolean** | Determines whether the charge definition is taxable. When this field is set to &#x60;true&#x60;, the &#x60;taxMode&#x60; and &#x60;taxCode&#x60; fields are required.  **Character limit**: 5  **Values**: &#x60;true&#x60;, &#x60;false&#x60;  **Note**: This value affects the tax calculation of the charge.  |  [optional] |
|**term** | **Double** | The number of periods of a termed subscription that is eligible for this charge definition. This field is applicable when the &#x60;termType&#x60; field is set to &#x60;TERMED&#x60;,  and is to be used together with the &#x60;termPeriodType&#x60; field.  |  [optional] |
|**termPeriodType** | [**TermPeriodTypeEnum**](#TermPeriodTypeEnum) | Specifies the period type for the subscription term that is eligible for this charge definition.  |  [optional] |
|**termType** | [**TermTypeEnum**](#TermTypeEnum) | The type of the subscription that is eligible for this charge definition.  |  [optional] |
|**uom** | **String** | Describes the unit of measure (UOM) configured in **Settings &gt; Billing**.  **Values**: &#x60;Each&#x60;, &#x60;License&#x60;, &#x60;Seat&#x60;, or &#x60;null&#x60;  |  [optional] |



## Enum: BillingTimingEnum

| Name | Value |
|---- | -----|
| ADVANCE | &quot;IN_ADVANCE&quot; |
| ARREARS | &quot;IN_ARREARS&quot; |



## Enum: ChargeModelEnum

| Name | Value |
|---- | -----|
| DISCOUNTFIXEDAMOUNT | &quot;DiscountFixedAmount&quot; |
| DISCOUNTPERCENTAGE | &quot;DiscountPercentage&quot; |
| FLATFEE | &quot;FlatFee&quot; |
| PERUNIT | &quot;PerUnit&quot; |
| TIERED | &quot;Tiered&quot; |
| VOLUME | &quot;Volume&quot; |
| DELIVERY | &quot;Delivery&quot; |



## Enum: ListPriceBaseEnum

| Name | Value |
|---- | -----|
| BILLING_PERIOD | &quot;Per_Billing_Period&quot; |
| MONTH | &quot;Per_Month&quot; |
| WEEK | &quot;Per_Week&quot; |
| YEAR | &quot;Per_Year&quot; |



## Enum: TaxModeEnum

| Name | Value |
|---- | -----|
| TAXEXCLUSIVE | &quot;TaxExclusive&quot; |
| TAXINCLUSIVE | &quot;TaxInclusive&quot; |
| NULL | &quot;null&quot; |



## Enum: TermPeriodTypeEnum

| Name | Value |
|---- | -----|
| MONTH | &quot;Month&quot; |
| YEAR | &quot;Year&quot; |
| DAY | &quot;Day&quot; |
| WEEK | &quot;Week&quot; |
| NULL | &quot;null&quot; |



## Enum: TermTypeEnum

| Name | Value |
|---- | -----|
| TERMED | &quot;TERMED&quot; |
| EVERGREEN | &quot;EVERGREEN&quot; |
| NULL | &quot;null&quot; |



