

# GETProductRatePlanChargeTypeAllOf


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**description** | **String** | Usually a brief line item summary of the Rate Plan Charge.  |  [optional] |
|**applyDiscountTo** | **String** | Specifies where (to what charge type) the discount will be applied. These field values are case-sensitive.  Permissible values: - RECURRING - USAGE - ONETIMERECURRING - ONETIMEUSAGE - RECURRINGUSAGE - ONETIMERECURRINGUSAGE  |  [optional] |
|**billingDay** | **String** | The bill cycle day (BCD) for the charge. The BCD determines which day of the month or week the customer is billed. The BCD value in the account can override the BCD in this object.  |  [optional] |
|**billingPeriod** | **String** | The billing period for the charge. The start day of the billing period is also called the bill cycle day (BCD).  Values: - Month - Quarter - Annual - Semi_Annual - Specific Months - Week - Specific_Weeks  |  [optional] |
|**billingPeriodAlignment** | **String** | Aligns charges within the same subscription if multiple charges begin on different dates.  Possible values: - AlignToCharge - AlignToSubscriptionStart - AlignToTermStart  |  [optional] |
|**billingTiming** | **String** | The billing timing for the charge. You can choose to bill for charges in advance or in arrears.  Values: - In Advance - In Arrears  **Note:** This feature is in Limited Availability. If you wish to have access to the feature, submit a request at [Zuora Global Support](https://support.zuora.com).   |  [optional] |
|**chargeModelConfigurations** | **Object** | This field is for Zuora Internal Use only. See the **pricing** field for the same information as this field. |  [optional] |
|**creditOption** | [**CreditOptionEnum**](#CreditOptionEnum) | **Note**: This field is only available if you have the [Prepaid with Drawdown](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/J_Billing_Operations/Prepaid_with_Drawdown) feature enabled.  The way to calculate credit. See [Credit Option](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/J_Billing_Operations/Prepaid_with_Drawdown/Create_prepayment_charge#Credit_Option) for more information.   |  [optional] |
|**defaultQuantity** | **BigDecimal** | The default quantity of units.  This field is required if you use a per-unit charge model.  |  [optional] |
|**deliverySchedule** | [**GETProductRatePlanChargeDeliverySchedule**](GETProductRatePlanChargeDeliverySchedule.md) |  |  [optional] |
|**discountClass** | **String** | The class that the discount belongs to. The discount class defines the order in which discount product rate plan charges are applied.  For more information, see [Manage Discount Classes](https://knowledgecenter.zuora.com/BC_Subscription_Management/Product_Catalog/B_Charge_Models/Manage_Discount_Classes).  |  [optional] |
|**discountLevel** | **String** | The level of the discount.   Values: - RatePlan - Subscription - Account  |  [optional] |
|**drawdownRate** | **Double** | **Note**: This field is only available if you have the [Prepaid with Drawdown](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/J_Billing_Operations/Prepaid_with_Drawdown) feature enabled.  The [conversion rate](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/J_Billing_Operations/Prepaid_with_Drawdown/Create_drawdown_charge#UOM_Conversion) between Usage UOM and Drawdown UOM for a [drawdown charge](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/J_Billing_Operations/Prepaid_with_Drawdown/Create_drawdown_charge). Must be a positive number (&gt;0).  |  [optional] |
|**drawdownUom** | **String** | **Note**: This field is only available if you have the [Prepaid with Drawdown](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/J_Billing_Operations/Prepaid_with_Drawdown) feature enabled.  Unit of measurement for a [drawdown charge](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/J_Billing_Operations/Prepaid_with_Drawdown/Create_drawdown_charge).  |  [optional] |
|**endDateCondition** | **String** | Defines when the charge ends after the charge trigger date. If the subscription ends before the charge end date, the charge ends when the subscription ends. But if the subscription end date is subsequently changed through a Renewal, or Terms and Conditions amendment, the charge will end on the charge end date.  Values: - Subscription_End - Fixed_Period  |  [optional] |
|**excludeItemBillingFromRevenueAccounting** | **Boolean** | The flag to exclude the related invoice items, invoice item adjustments, credit memo items, and debit memo items from revenue accounting.  **Note**: This field is only available if you have the Billing - Revenue Integration feature enabled.   |  [optional] |
|**excludeItemBookingFromRevenueAccounting** | **Boolean** | The flag to exclude the related rate plan charges and order line items from revenue accounting.  **Note**: This field is only available if you have the Billing - Revenue Integration feature enabled.   |  [optional] |
|**financeInformation** | [**FinanceInformation**](FinanceInformation.md) |  |  [optional] |
|**formula** | **String** | The pricing formula to calculate the actual rating amount for each usage record.  This field is only available for the usage-based charges that use the Multi-Attribute Pricing charge model. The charge model is available for customers with Enterprise and Nine editions by default. If you are a Growth customer, see [Zuora Editions](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/C_Zuora_Editions) for pricing information.  |  [optional] |
|**id** | **String** | Unique product rate-plan charge ID.  |  [optional] |
|**includedUnits** | **BigDecimal** | Specifies the number of units in the base set of units when the charge model is Overage.  |  [optional] |
|**isAllocationEligible** | **Boolean** | This field is used to identify if the charge segment is allocation eligible in revenue recognition.  **Note**: This feature is in the **Early Adopter** phase. If you want to use the feature, submit a request at &lt;a href&#x3D;\&quot;https://support.zuora.com/\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Zuora Global Support&lt;/a&gt;, and we will evaluate whether the feature is suitable for your use cases.  |  [optional] |
|**isPrepaid** | **Boolean** | **Note**: This field is only available if you have the [Prepaid with Drawdown](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/J_Billing_Operations/Prepaid_with_Drawdown) feature enabled.  Indicates whether this charge is a prepayment (topup) charge or a drawdown charge. Values: &#x60;true&#x60; or &#x60;false&#x60;.  |  [optional] |
|**isRollover** | **Boolean** | **Note**: This field is only available if you have the [Prepaid with Drawdown](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/J_Billing_Operations/Prepaid_with_Drawdown) feature enabled.  The value is either \&quot;true\&quot; or \&quot;false\&quot;. It determines whether the rollover fields are needed.  |  [optional] |
|**isStackedDiscount** | **Boolean** | **Note**: This field is only applicable to the Discount - Percentage charge model.  To use this field, you must set the &#x60;X-Zuora-WSDL-Version&#x60; request header to 130 or higher. Otherwise, an error occurs.  This field indicates whether the discount is to be calculated as stacked discount. Possible values are as follows:  - &#x60;true&#x60;: This is a stacked discount, which should be calculated by stacking with other discounts.  - &#x60;false&#x60;: This is not a stacked discount, which should be calculated in sequence with other discounts.  For more information, see [Stacked discounts](https://knowledgecenter.zuora.com/Zuora_Billing/Products/Product_Catalog/B_Charge_Models/B_Discount_Charge_Models).  |  [optional] |
|**isUnbilled** | **Boolean** | This field is used to dictate how to perform the accounting during revenue recognition.  **Note**: This feature is in the **Early Adopter** phase. If you want to use the feature, submit a request at &lt;a href&#x3D;\&quot;https://support.zuora.com/\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Zuora Global Support&lt;/a&gt;, and we will evaluate whether the feature is suitable for your use cases.  |  [optional] |
|**listPriceBase** | [**ListPriceBaseEnum**](#ListPriceBaseEnum) | The list price base for the product rate plan charge.  This field is only applicable for recurring charges.  |  [optional] |
|**maxQuantity** | **BigDecimal** | Specifies the maximum number of units for this charge. Use this field and the &#x60;minQuantity&#x60; field to create a range of units allowed in a product rate plan charge.  |  [optional] |
|**minQuantity** | **BigDecimal** | Specifies the minimum number of units for this charge. Use this field and the &#x60;maxQuantity&#x60; field to create a range of units allowed in a product rate plan charge.  |  [optional] |
|**model** | **String** | Charge model which determines how charges are calculated. Charge models must be individually activated in Zuora Billing administration.   Possible values are: - &#x60;FlatFee&#x60; - &#x60;PerUnit&#x60; - &#x60;Overage&#x60; - &#x60;Volume&#x60; - &#x60;Tiered&#x60; - &#x60;TieredWithOverage&#x60; - &#x60;DiscountFixedAmount&#x60; - &#x60;DiscountPercentage&#x60; - &#x60;Delivery&#x60; (available only if you have the Delivery Pricing charge model enabled) - &#x60;MultiAttributePricing&#x60; (available only if you have the Multi-Attribute Pricing charge model enabled. The charge model is available for customers with Enterprise and Nine editions by default. If you are a Growth customer, see [Zuora Editions](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/C_Zuora_Editions) for pricing information.) - &#x60;PreratedPerUnit&#x60; (available only if you have the Pre-rated Per Unit Pricing charge model enabled. The charge model is available for customers with Enterprise and Nine editions by default. If you are a Growth customer, see [Zuora Editions](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/C_Zuora_Editions) for pricing information.) - &#x60;PreratedPricing&#x60; (available only if you have the Pre-rated Pricing charge model enabled. The charge model is available for customers with Enterprise and Nine editions by default. If you are a Growth customer, see [Zuora Editions](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/C_Zuora_Editions) for pricing information.) - &#x60;HighWatermarkVolumePricing&#x60; (available only if you have the High Water Mark Volume Pricing charge model enabled. The charge model is available for customers with Enterprise and Nine editions by default. If you are a Growth customer, see [Zuora Editions](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/C_Zuora_Editions) for pricing information.) - &#x60;HighWatermarkTieredPricing&#x60; (available only if you have the High Water Mark Tiered Pricing charge model enabled. The charge model is available for customers with Enterprise and Nine editions by default. If you are a Growth customer, see [Zuora Editions](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/C_Zuora_Editions) for pricing information.)  The value of the &#x60;pricing&#x60; field contains details about these charge models and the value of &#x60;pricingSummary&#x60; field contains their associated pricing summary values.  |  [optional] |
|**name** | **String** | Name of the product rate-plan charge. (Not required to be unique.)  |  [optional] |
|**numberOfPeriods** | **Long** | Specifies the number of periods to use when calculating charges in an overage smoothing charge model. This field is ued when overage smoothing model is &#x60;RollingWindow&#x60; or &#x60;Rollover&#x60;.  |  [optional] |
|**overageCalculationOption** | **String** | Value specifies when to calculate overage charges.  Values: - EndOfSmoothingPeriod - PerBillingPeriod - null  |  [optional] |
|**overageUnusedUnitsCreditOption** | **String** | Determines whether to credit the customer with unused units of usage.  Values: - NoCredit - CreditBySpecificRate  |  [optional] |
|**prepaidOperationType** | [**PrepaidOperationTypeEnum**](#PrepaidOperationTypeEnum) | **Note**: This field is only available if you have the [Prepaid with Drawdown](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/J_Billing_Operations/Prepaid_with_Drawdown) feature enabled.  The type of this charge. It is either a prepayment (topup) charge or a drawdown charge.   |  [optional] |
|**prepaidQuantity** | **Double** | **Note**: This field is only available if you have the [Prepaid with Drawdown](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/J_Billing_Operations/Prepaid_with_Drawdown) feature enabled.  The number of units included in a [prepayment charge](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/J_Billing_Operations/Prepaid_with_Drawdown/Create_prepayment_charge). Must be a positive number (&gt;0).  |  [optional] |
|**prepaidTotalQuantity** | **Double** | **Note**: This field is only available if you have the [Prepaid with Drawdown](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/J_Billing_Operations/Prepaid_with_Drawdown) feature enabled.  The total amount of units that end customers can use during a validity period when they subscribe to a [prepayment charge](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/J_Billing_Operations/Prepaid_with_Drawdown/Create_prepayment_charge).  |  [optional] |
|**prepaidUom** | **String** | **Note**: This field is only available if you have the [Prepaid with Drawdown](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/J_Billing_Operations/Prepaid_with_Drawdown) feature enabled.  Unit of measurement for a [prepayment charge](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/J_Billing_Operations/Prepaid_with_Drawdown/Create_prepayment_charge).  |  [optional] |
|**prepayPeriods** | **Long** | The number of periods to which prepayment is set.   **Note:** This field is only available if you already have the prepayment feature enabled. The prepayment feature is deprecated and available only for backward compatibility. Zuora does not support enabling this feature anymore.  |  [optional] |
|**priceChangeOption** | **String** | Applies an automatic price change when a termed subscription is renewed and the following applies:  1. AutomatedPriceChange setting is on 2. Charge type is not one-time 3. Charge model is not discount fixed amount  Values: - NoChange (default) - SpecificPercentageValue - UseLatestProductCatalogPricing  |  [optional] |
|**priceIncreasePercentage** | **BigDecimal** | Specifies the percentage to increase or decrease the price of a termed subscription&#39;s renewal. Use this field if you set the &#x60;PriceChangeOption&#x60; value to &#x60;SpecificPercentageValue&#x60;.  1. AutomatedPriceChange setting is on 2. Charge type is not one-time 3. Charge model is not discount fixed amount  Values: a decimal between -100 and 100  |  [optional] |
|**pricing** | [**List&lt;GETProductRatePlanChargePricingType&gt;**](GETProductRatePlanChargePricingType.md) | One or more price charge models with attributes that further describe the model.  Some attributes show as null values when not applicable.  |  [optional] |
|**pricingSummary** | **List&lt;String&gt;** | A concise description of the charge model and pricing that is suitable to show to your customers. When the rate plan charge model is &#x60;Tiered&#x60; and multi-currency is enabled, this field includes an array of string of each currency, and each string of currency includes tier price description separated by comma.  For the following charge models, the value of this field is an empty string: - Multi-Attribute Pricing - High Water Mark Tiered Pricing - High Water Mark Volume Pricing - Pre-Rated Per Unit Pricing - Pre-Rated Pricing  The charge models are available for customers with Enterprise and Nine editions by default. If you are a Growth customer, see [Zuora Editions](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/C_Zuora_Editions) for pricing information.  |  [optional] |
|**productChargeDefinitions** | **String** | A link to retrieve product charge definitions of this charge.  |  [optional] |
|**productDiscountApplyDetails** | [**List&lt;GETProductDiscountApplyDetailsType&gt;**](GETProductDiscountApplyDetailsType.md) | Container for the application details about a discount product rate plan charge.   Only discount product rate plan charges have values in this field.  |  [optional] |
|**productRatePlanChargeNumber** | **String** | The natural key of the product rate plan charge.  |  [optional] |
|**ratingGroup** | **String** | Specifies a rating group based on which usage records are rated.  Possible values:  - &#x60;ByBillingPeriod&#x60; (default): The rating is based on all the usages in a billing period. - &#x60;ByUsageStartDate&#x60;: The rating is based on all the usages on the same usage start date.  - &#x60;ByUsageRecord&#x60;: The rating is based on each usage record. - &#x60;ByUsageUpload&#x60;: The rating is based on all the  usages in a uploaded usage file (&#x60;.xls&#x60; or &#x60;.csv&#x60;). - &#x60;ByGroupId&#x60;: The rating is based on all the usages in a custom group.  **Note:**  - The &#x60;ByBillingPeriod&#x60; value can be applied for all charge models.  - The &#x60;ByUsageStartDate&#x60;, &#x60;ByUsageRecord&#x60;, and &#x60;ByUsageUpload&#x60; values can only be applied for per unit, volume pricing, and tiered pricing charge models.  - The &#x60;ByGroupId&#x60; value is only available if you have the Active Rating feature enabled. - Use this field only for Usage charges. One-Time Charges and Recurring Charges return &#x60;NULL&#x60;.  |  [optional] |
|**revRecCode** | **String** | Associates this product rate plan charge with a specific revenue recognition code. The value is a valid revenue recognition code.  |  [optional] |
|**revRecTriggerCondition** | [**RevRecTriggerConditionEnum**](#RevRecTriggerConditionEnum) | Specifies when revenue recognition begins.  |  [optional] |
|**revenueRecognitionRuleName** | **String** | The name of the revenue recognition rule governing the revenue schedule.  |  [optional] |
|**rolloverApply** | [**RolloverApplyEnum**](#RolloverApplyEnum) | **Note**: This field is only available if you have the [Prepaid with Drawdown](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/J_Billing_Operations/Prepaid_with_Drawdown) feature enabled.  This field defines the priority of rollover, which is either first or last.  |  [optional] |
|**rolloverPeriodLength** | **Integer** | **Note**: This field is only available if you have the [Prepaid with Drawdown](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/J_Billing_Operations/Prepaid_with_Drawdown) feature enabled.  The period length of the rollover fund.  |  [optional] |
|**rolloverPeriods** | **Double** | **Note**: This field is only available if you have the [Prepaid with Drawdown](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/J_Billing_Operations/Prepaid_with_Drawdown) feature enabled.  This field defines the number of rollover periods, it is restricted to 3.  |  [optional] |
|**smoothingModel** | **String** | Specifies the smoothing model for an overage smoothing charge model or an tiered with overage model, which is an advanced type of a usage model that avoids spikes in usage charges. If a customer&#39;s usage spikes in a single period, then an overage smoothing model eases overage charges by considering usage and multiple periods.  One of the following values shows which smoothing model will be applied to the charge when &#x60;Overage&#x60; or &#x60;Tiered with Overage&#x60; is used:  - &#x60;RollingWindow&#x60; considers a number of periods to smooth usage. The rolling window starts and increments forward based on billing frequency. When allowed usage is met, then period resets and a new window begins. - &#x60;Rollover&#x60; considers a fixed number of periods before calculating usage. The net balance at the end of a period is unused usage, which is carried over to the next period&#39;s balance.  |  [optional] |
|**specificBillingPeriod** | **Long** | When the billing period is set to &#x60;Specific&#x60; Months then this positive integer reflects the number of months for billing period charges.  |  [optional] |
|**specificListPriceBase** | **Integer** | The number of months for the list price base of the charge. The value of this field is &#x60;null&#x60; if you do not set the value of the &#x60;listPriceBase&#x60; field to &#x60;Per_Specific_Months&#x60;.  |  [optional] |
|**taxCode** | **String** | Specifies the tax code for taxation rules; used by Zuora Tax.  |  [optional] |
|**taxMode** | [**TaxModeEnum**](#TaxModeEnum) | Specifies how to define taxation for the charge; used by Zuora Tax.  |  [optional] |
|**taxable** | **Boolean** | Specifies whether the charge is taxable; used by Zuora Tax. Possible values are:&#x60;true&#x60;, &#x60;false&#x60;.  |  [optional] |
|**triggerEvent** | **String** | Specifies when to start billing the customer for the charge.  Values: one of the following: - &#x60;ContractEffective&#x60; is the date when the subscription&#39;s contract goes into effect and the charge is ready to be billed. - &#x60;ServiceActivation&#x60; is the date when the services or products for a subscription have been activated and the customers have access. - &#x60;CustomerAcceptance&#x60; is when the customer accepts the services or products for a subscription.  - &#x60;SpecificDate&#x60; is the date specified.  |  [optional] |
|**type** | **String** | The type of charge. Possible values are: &#x60;OneTime&#x60;, &#x60;Recurring&#x60;, &#x60;Usage&#x60;.  |  [optional] |
|**uom** | **String** | Describes the Units of Measure (uom) configured in **Settings &gt; Billing** for the productRatePlanCharges.  Values: &#x60;Each&#x60;, &#x60;License&#x60;, &#x60;Seat&#x60;, or &#x60;null&#x60;  |  [optional] |
|**upToPeriods** | **Long** | Specifies the length of the period during which the charge is active. If this period ends before the subscription ends, the charge ends when this period ends. If the subscription end date is subsequently changed through a Renewal, or Terms and Conditions amendment, the charge end date will change accordingly up to the original period end.  |  [optional] |
|**upToPeriodsType** | [**UpToPeriodsTypeEnum**](#UpToPeriodsTypeEnum) | The period type used to define when the charge ends.  |  [optional] |
|**usageRecordRatingOption** | **String** | Determines how Zuora processes usage records for per-unit usage charges.   |  [optional] |
|**useDiscountSpecificAccountingCode** | **Boolean** | Determines whether to define a new accounting code for the new discount charge. Values: &#x60;true&#x60;, &#x60;false&#x60;  |  [optional] |
|**useTenantDefaultForPriceChange** | **Boolean** | Shows the tenant-level percentage uplift value for an automatic price change to a termed subscription&#39;s renewal. You set the tenant uplift value in the web-based UI: **Settings &gt; Billing &gt; Define Default Subscription Settings**.  Values: &#x60;true&#x60;, &#x60;false&#x60;  |  [optional] |
|**validityPeriodType** | [**ValidityPeriodTypeEnum**](#ValidityPeriodTypeEnum) | **Note**: This field is only available if you have the [Prepaid with Drawdown](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/J_Billing_Operations/Prepaid_with_Drawdown) feature enabled.  The period in which the prepayment units are valid to use as defined in a [prepayment charge](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/J_Billing_Operations/Prepaid_with_Drawdown/Create_prepayment_charge).  |  [optional] |



## Enum: CreditOptionEnum

| Name | Value |
|---- | -----|
| TIMEBASED | &quot;TimeBased&quot; |
| CONSUMPTIONBASED | &quot;ConsumptionBased&quot; |
| FULLCREDITBACK | &quot;FullCreditBack&quot; |



## Enum: ListPriceBaseEnum

| Name | Value |
|---- | -----|
| BILLING_PERIOD | &quot;Per_Billing_Period&quot; |
| MONTH | &quot;Per_Month&quot; |
| WEEK | &quot;Per_Week&quot; |
| YEAR | &quot;Per_Year&quot; |
| SPECIFIC_MONTHS | &quot;Per_Specific_Months&quot; |



## Enum: PrepaidOperationTypeEnum

| Name | Value |
|---- | -----|
| TOPUP | &quot;topup&quot; |
| DRAWDOWN | &quot;drawdown&quot; |
| NULL | &quot;null&quot; |



## Enum: RevRecTriggerConditionEnum

| Name | Value |
|---- | -----|
| CONTRACTEFFECTIVEDATE | &quot;ContractEffectiveDate&quot; |
| SERVICEACTIVATIONDATE | &quot;ServiceActivationDate&quot; |
| CUSTOMERACCEPTANCEDATE | &quot;CustomerAcceptanceDate&quot; |
| NULL | &quot;null&quot; |



## Enum: RolloverApplyEnum

| Name | Value |
|---- | -----|
| APPLYFIRST | &quot;ApplyFirst&quot; |
| APPLYLAST | &quot;ApplyLast&quot; |



## Enum: TaxModeEnum

| Name | Value |
|---- | -----|
| TAXEXCLUSIVE | &quot;TaxExclusive&quot; |
| TAXINCLUSIVE | &quot;TaxInclusive&quot; |
| NULL | &quot;null&quot; |



## Enum: UpToPeriodsTypeEnum

| Name | Value |
|---- | -----|
| BILLING_PERIODS | &quot;Billing_Periods&quot; |
| DAYS | &quot;Days&quot; |
| WEEKS | &quot;Weeks&quot; |
| MONTHS | &quot;Months&quot; |
| YEARS | &quot;Years&quot; |
| NULL | &quot;null&quot; |



## Enum: ValidityPeriodTypeEnum

| Name | Value |
|---- | -----|
| SUBSCRIPTION_TERM | &quot;SUBSCRIPTION_TERM&quot; |
| ANNUAL | &quot;ANNUAL&quot; |
| SEMI_ANNUAL | &quot;SEMI_ANNUAL&quot; |
| QUARTER | &quot;QUARTER&quot; |
| MONTH | &quot;MONTH&quot; |



