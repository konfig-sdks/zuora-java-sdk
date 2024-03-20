

# GETProductRatePlanChargeResponse


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**description** | **String** | The description for this charge.  |  [optional] |
|**applyDiscountTo** | [**ApplyDiscountToEnum**](#ApplyDiscountToEnum) | Indicates which type of charge the discount charge applies to.  |  [optional] |
|**billingDay** | **String** | The bill cycle type for this charge.  |  [optional] |
|**billingPeriod** | **String** | The billing period for this charge.  |  [optional] |
|**billingPeriodAlignment** | [**BillingPeriodAlignmentEnum**](#BillingPeriodAlignmentEnum) | The billing period alignment setting for this charge.  |  [optional] |
|**billingTiming** | [**BillingTimingEnum**](#BillingTimingEnum) | The billing timing for this charge.  |  [optional] |
|**chargeFunction** | [**ChargeFunctionEnum**](#ChargeFunctionEnum) | **Note**: This field is only available if you have the &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Bill_your_customers/Bill_for_usage_or_prepaid_products/Advanced_Consumption_Billing/Unbilled_Usage\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Unbilled Usage&lt;/a&gt; feature enabled.  To use this field, you must set the &#x60;X-Zuora-WSDL-Version&#x60; request header to &#x60;141&#x60; or higher. Otherwise, an error occurs.  This field defines what type of charge it is in Advanced Consumption Billing: * Standard: Normal charge with no Prepayment or Commitment or Drawdown. * Prepayment: For recurring charges. Unit or currency based prepaid charge. * CommitmentTrueUp: For recurring charges. Currency based minimum commitment charge. * Drawdown: For usage charges. Drawdown from prepaid funds. * DrawdownAndCreditCommitment: For usage charges. Drawdown from prepaid funds and then credit to minimum commitment funds. * CreditCommitment: For usage charges. Credit to minimum commitment funds.  |  [optional] |
|**commitmentType** | [**CommitmentTypeEnum**](#CommitmentTypeEnum) | **Note**: This field is only available if you have the &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Bill_your_customers/Bill_for_usage_or_prepaid_products/Advanced_Consumption_Billing/Unbilled_Usage\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Unbilled Usage&lt;/a&gt; feature enabled.  To use this field, you must set the &#x60;X-Zuora-WSDL-Version&#x60; request header to &#x60;133&#x60; or higher. Otherwise, an error occurs.   This field defines the type of commitment. A prepaid charge can be &#x60;UNIT&#x60; or &#x60;CURRENCY&#x60;. A minimum commitment(in-arrears) charge can only be &#x60;CURRENCY&#x60; type. For topup(recurring or one-time) charges, this field indicates what type of funds are created.  * If UNIT, it will create a fund with given prepaidUom. * If CURRENCY, it will create a fund with the currency amount calculated in list price.    For drawdown(usage) charges, this field indicates what type of funds are drawdown from that created from topup charges.  |  [optional] |
|**customFields** | **Map&lt;String, Object&gt;** | Container for custom fields of a Product Rate Plan Charge object.  |  [optional] |
|**defaultQuantity** | **Double** | The default quantity.   This field is applicable only for one-time and recurring charges.  |  [optional] |
|**deliverySchedule** | [**GETDeliverySchedule**](GETDeliverySchedule.md) |  |  [optional] |
|**discountClass** | **String** | The class that the discount belongs to. The discount class defines the order in which discount product rate plan charges are applied.  For more information, see [Manage Discount Classes](https://knowledgecenter.zuora.com/BC_Subscription_Management/Product_Catalog/B_Charge_Models/Manage_Discount_Classes).  |  [optional] |
|**discountLevel** | [**DiscountLevelEnum**](#DiscountLevelEnum) | The application scope of the discount charge. For example, if the value of this field is &#x60;subscription&#x60; and the value of the &#x60;applyDiscountTo&#x60; field is &#x60;RECURRING&#x60;, the discount charge applies to all recurring charges in the same subscription as the discount charge.  |  [optional] |
|**endDateCondition** | [**EndDateConditionEnum**](#EndDateConditionEnum) | The end date condition for this charge.  |  [optional] |
|**excludeItemBillingFromRevenueAccounting** | **Boolean** | Indicates whether to exclude the related invoice items, invoice item adjustments, credit memo items, and debit memo items from revenue accounting.  **Note**: This field is only available if you have the Order to Revenue or Billing - Revenue Integration feature enabled.   |  [optional] |
|**excludeItemBookingFromRevenueAccounting** | **Boolean** | Indicates whether to exclude the related rate plan charges and order line items from revenue accounting.  **Note**: This field is only available if you have the Order to Revenue or Billing - Revenue Integration feature enabled.  |  [optional] |
|**isAllocationEligible** | **Boolean** | Indicates whether the charge segment is allocation eligible in revenue recognition. The default value is &#x60;false&#x60;.  **Values**: &#x60;true&#x60;, &#x60;false&#x60;  **Note**: This field is available only if you have the Additional Revenue Fields property enabled.  |  [optional] |
|**isUnbilled** | **Boolean** | Specifies how to perform the accounting during revenue recognition. The default value is &#x60;false&#x60;.  **Values**: &#x60;true&#x60;, &#x60;false&#x60;  **Note**: This field is available only if you have the Additional Revenue Fields property enabled.       |  [optional] |
|**productCategory** | **String** | This field is used to maintain the product category for integration with Zuora Revenue.   **Note**: This field is available only if you have the Additional Revenue Fields property enabled.      |  [optional] |
|**productClass** | **String** | This field is used to maintain the product class for integration with Zuora Revenue.   **Note**: This field is available only if you have the Additional Revenue Fields property enabled.      |  [optional] |
|**productFamily** | **String** | This field is used to maintain the product family for integration with Zuora Revenue.   **Note**: This field is available only if you have the Additional Revenue Fields property enabled.  |  [optional] |
|**productLine** | **String** | This field is used to maintain the product line for integration with Zuora Revenue.   **Note**: This field is available only if you have the Additional Revenue Fields property enabled.  |  [optional] |
|**revenueRecognitionTiming** | [**RevenueRecognitionTimingEnum**](#RevenueRecognitionTimingEnum) | Specifies the type of revenue recognition timing.  Predefined options are listed as enum values in this API Reference.  Other options might also be avaliable depending on  the &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Enable_Order_to_Revenue/Configure_revenue_settings/Configure_revenue_recognition_policy\&quot; target&#x3D;\&quot;_blank\&quot;&gt;revenue recognition policy configuration&lt;/a&gt; in the Zuora Billing UI.  **Note**: This field is only available if you have the Order to Revenue feature enabled.   |  [optional] |
|**revenueAmortizationMethod** | [**RevenueAmortizationMethodEnum**](#RevenueAmortizationMethodEnum) | Specifies the type of revenue amortization method.  Predefined options are listed as enum values in this API Reference.  Other options might also be avaliable depending on  the &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Enable_Order_to_Revenue/Configure_revenue_settings/Configure_revenue_recognition_policy\&quot; target&#x3D;\&quot;_blank\&quot;&gt;revenue recognition policy configuration&lt;/a&gt; in the Zuora Billing UI.  **Note**: This field is only available if you have the Order to Revenue feature enabled.   |  [optional] |
|**numberOfPeriods** | **Long** | Specifies the number of periods to use when calculating charges in an overage smoothing charge model. This field is ued when overage smoothing model is &#x60;RollingWindow&#x60; or &#x60;Rollover&#x60;.  |  [optional] |
|**financeInformation** | [**FinanceInformationProperty**](FinanceInformationProperty.md) |  |  [optional] |
|**id** | **String** | The unique ID of the product rate plan charge.  |  [optional] |
|**isStackedDiscount** | **Boolean** | **Note**: This field is only applicable to the Discount - Percentage charge model.  To use this field, you must set the &#x60;X-Zuora-WSDL-Version&#x60; request header to 130 or higher. Otherwise, an error occurs.  This field indicates whether the discount is to be calculated as stacked discount. Possible values are as follows:   - &#x60;true&#x60;: This is a stacked discount, which should be calculated by stacking with other discounts.   - &#x60;false&#x60;: This is not a stacked discount, which should be calculated in sequence with other discounts.  For more information, see [Stacked discounts](https://knowledgecenter.zuora.com/Zuora_Billing/Products/Product_Catalog/B_Charge_Models/B_Discount_Charge_Models).  |  [optional] |
|**listPriceBase** | [**ListPriceBaseEnum**](#ListPriceBaseEnum) | The base of list price.   This field is applicable only for recurring charges.  **Note**: The &#x60;Per_Year&#x60; enum value is available only if you have the &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Billing/Subscriptions/Product_Catalog/I_Annual_List_Price\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Annual List Price&lt;/a&gt; feature enabled.  |  [optional] |
|**model** | [**ModelEnum**](#ModelEnum) | Determines how to calculate charges. Charge models must be individually activated in Zuora Billing administration.  |  [optional] |
|**name** | **String** | The name of the product rate plan charge.  |  [optional] |
|**numberOfPeriod** | **Long** | Indicates the number of periods to use when calculating charges in an overage smoothing charge model. The valid value is a positive whole number.  |  [optional] |
|**overageCalculationOption** | [**OverageCalculationOptionEnum**](#OverageCalculationOptionEnum) | Determines when to calculate overage charges. If the value of the &#x60;smoothingMode&#x60; field is not specified, the value of this field is ignored.  **Values**:    - &#x60;EndOfSmoothingPeriod&#x60;: This option is used by default. The overage is charged at the end of the smoothing period.   - &#x60;PerBillingPeriod&#x60;: The overage is charged on-demand rather than waiting until the end of the smoothing period.  |  [optional] |
|**overageUnusedUnitsCreditOption** | [**OverageUnusedUnitsCreditOptionEnum**](#OverageUnusedUnitsCreditOptionEnum) | Determines whether to credit the customer with unused units of usage.  |  [optional] |
|**priceChangeOption** | [**PriceChangeOptionEnum**](#PriceChangeOptionEnum) | Applies an automatic price change when a termed subscription is renewed.  |  [optional] |
|**priceIncreaseOption** | [**PriceIncreaseOptionEnum**](#PriceIncreaseOptionEnum) | Applies an automatic price change when a termed subscription is renewed.  |  [optional] |
|**priceIncreasePercentage** | **Double** | Specifies the percentage to increase or decrease the price of a termed subscription&#39;s renewal. Use this field if you set the &#x60;priceIncreaseOption&#x60; field to &#x60;SpecificPercentageValue&#x60;.  **Character limit**: 16  **Values**: a decimal value between -100 and 100  |  [optional] |
|**pricing** | [**List&lt;GETRatePlanChargePricing&gt;**](GETRatePlanChargePricing.md) | Container for the prices of the product rate plan charge.  |  [optional] |
|**pricingSummary** | **List&lt;String&gt;** | A concise description of the charge model and pricing that is suitable to show to your customers.   When the rate plan charge model is &#x60;Tiered&#x60; and multi-currency is enabled, this field includes an array of string of each currency, and each string of currency includes tier price description separated by comma.  For the following charge models, the value of this field is an empty string: - Multi-Attribute Pricing - High Water Mark Tiered Pricing - High Water Mark Volume Pricing - Pre-Rated Per Unit Pricing - Pre-Rated Pricing  The charge models are available for customers with Enterprise and Nine editions by default. If you are a Growth customer, see [Zuora Editions](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/C_Zuora_Editions) for pricing information.  |  [optional] |
|**productChargeDefinitions** | **String** | A link to retrieve product charge definitions of this charge.  |  [optional] |
|**productDiscountApplyDetails** | [**List&lt;GETProductDiscountApplyDetailsType&gt;**](GETProductDiscountApplyDetailsType.md) | Container for the application details about a discount product rate plan charge.   Only discount product rate plan charges have values in this field.  |  [optional] |
|**productRatePlanChargeNumber** | **String** | The number of this product rate plan charge.  |  [optional] |
|**ratingGroup** | [**RatingGroupEnum**](#RatingGroupEnum) | Specifies a rating group based on which usage records are rated.  Possible values:                   - &#x60;ByBillingPeriod&#x60;: The rating is based on all the usages in a billing period.    - &#x60;ByUsageStartDate&#x60;: The rating is based on all the usages on the same usage start date.    - &#x60;ByUsageRecord&#x60;: The rating is based on each usage record.   - &#x60;ByUsageUpload&#x60;: The rating is based on all the  usages in a uploaded usage file (&#x60;.xls&#x60; or &#x60;.csv&#x60;).   - &#x60;ByGroupId&#x60;: The rating is based on all the usages in a custom group.  **Notes:**    - The &#x60;ByBillingPeriod&#x60; value can be applied for all charge models.    - The &#x60;ByUsageStartDate&#x60;, &#x60;ByUsageRecord&#x60;, and &#x60;ByUsageUpload&#x60; values can only be applied for per unit, volume pricing, and tiered pricing charge models.    - The &#x60;ByGroupId&#x60; value is only available if you have the Active Rating feature enabled.   - Use this field only for Usage charges. One-Time Charges and Recurring Charges return &#x60;NULL&#x60;.  |  [optional] |
|**recognizedRevenueAccount** | **String** | The name of the recognized revenue account for this charge.   - Required when the Allow Blank Accounting Code setting is No.   - Optional when the Allow Blank Accounting Code setting is Yes.    This feature is in **Limited Availability**. If you wish to have access to the feature, submit a request at [Zuora Global Support](http://support.zuora.com/).  |  [optional] |
|**revRecCode** | **String** | Associates this product rate plan charge with a specific revenue recognition code.  |  [optional] |
|**revRecTriggerCondition** | [**RevRecTriggerConditionEnum**](#RevRecTriggerConditionEnum) | Specifies when revenue recognition begins.  |  [optional] |
|**revenueRecognitionRuleName** | [**RevenueRecognitionRuleNameEnum**](#RevenueRecognitionRuleNameEnum) | Determines when to recognize the revenue for this charge.  |  [optional] |
|**smoothingModel** | [**SmoothingModelEnum**](#SmoothingModelEnum) | Specifies the smoothing model for an overage smoothing charge model.  |  [optional] |
|**specificBillingPeriod** | **Double** | The specific number of billing periods for this charge.  |  [optional] |
|**specificListPriceBase** | **Integer** | The number of months for the list price base of the charge. The value of this field is &#x60;null&#x60; if you do not set the value of the &#x60;listPriceBase&#x60; field to &#x60;Per_Specific_Months&#x60;.  |  [optional] |
|**success** | **Boolean** | Indicates whether the request succeeded.  |  [optional] |
|**taxCode** | **String** | Specifies the tax code for taxation rules. This field is required when the &#x60;taxable&#x60; field is set to &#x60;true&#x60;.  **Note**: This value affects the tax calculation of the rate plan charge.  |  [optional] |
|**taxMode** | [**TaxModeEnum**](#TaxModeEnum) | Determines how to define taxation for the charge. This field is required when the &#x60;taxable&#x60; field is set to &#x60;true&#x60;.  **Note**: This value affects the tax calculation of the rate plan charge.  |  [optional] |
|**taxable** | **Boolean** | Determines whether the charge is taxable. When set to &#x60;true&#x60;, the &#x60;taxMode&#x60; and &#x60;taxCode&#x60; fields are required when creating or updating th Product Rate Plan Charge object.  **Character limit**: 5  **Values**: &#x60;true&#x60;, &#x60;false&#x60;  **Note**: This value affects the tax calculation of rate plan charges that come from the &#x60;ProductRatePlanCharge&#x60;.  |  [optional] |
|**triggerEvent** | [**TriggerEventEnum**](#TriggerEventEnum) | Specifies when to start billing the customer for the charge.  **Values**:   - &#x60;ContractEffective&#x60; is the date when the subscription&#39;s contract goes into effect and the charge is ready to be billed.   - &#x60;ServiceActivation&#x60; is the date when the services or products for a subscription have been activated and the customers have access.   - &#x60;CustomerAcceptance&#x60; is when the customer accepts the services or products for a subscription.  |  [optional] |
|**type** | [**TypeEnum**](#TypeEnum) | Specifies the type of charge.  |  [optional] |
|**uom** | **String** | Indicates the units of measure (UOM) that is configured in **Settings &gt; Billing** for the product rate plan charge.  |  [optional] |
|**upToPeriods** | **Double** | The number of up-to-periods value for this charge.  |  [optional] |
|**upToPeriodsType** | [**UpToPeriodsTypeEnum**](#UpToPeriodsTypeEnum) | The up-to-periods type setting for this charge.  |  [optional] |
|**usageRecordRatingOption** | [**UsageRecordRatingOptionEnum**](#UsageRecordRatingOptionEnum) | Determines how Zuora processes usage records for per-unit usage charges.  |  [optional] |
|**useDiscountSpecificAccountingCode** | **Boolean** | Determines whether to define a new accounting code for the new discount charge.  **Character limit**: 5  **Values**: &#x60;true&#x60;, &#x60;false&#x60;  |  [optional] |
|**useTenantDefaultForPriceChange** | **Boolean** | Applies the tenant-level percentage uplift value for an automatic price change to a termed subscription&#39;s renewal.   **Character limit**: 5  **Values**: &#x60;true&#x60;, &#x60;false&#x60;  |  [optional] |
|**applyToBillingPeriodPartially** | **Boolean** | Allow the discount duration to be aligned with the billing period partially.  **Note**: You must enable the [Enhanced Discount](https://knowledgecenter.zuora.com/Zuora_Billing/Build_products_and_prices/Basic_concepts_and_terms/B_Charge_Models/D_Manage_Enhanced_Discount) feature to access this field.  |  [optional] |
|**isPrepaid** | **Boolean** | Indicates whether this charge is a prepayment (topup) charge or a drawdown charge.  **Note**: This field is only available if you have the [Prepaid with Drawdown](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/J_Billing_Operations/Prepaid_with_Drawdown) feature enabled.  **Values**: &#x60;true&#x60; or &#x60;false&#x60;.  |  [optional] |
|**prepaidOperationType** | [**PrepaidOperationTypeEnum**](#PrepaidOperationTypeEnum) | **Note**: This field is only available if you have the [Prepaid with Drawdown](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/J_Billing_Operations/Prepaid_with_Drawdown) feature enabled.  The type of this charge. It is either a prepayment (topup) charge or a drawdown charge.   |  [optional] |
|**prepaidQuantity** | **Double** | **Note**: This field is only available if you have the [Prepaid with Drawdown](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/J_Billing_Operations/Prepaid_with_Drawdown) feature enabled.  The number of units included in a [prepayment charge](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/J_Billing_Operations/Prepaid_with_Drawdown/Create_prepayment_charge). Must be a positive number (&gt;0).  |  [optional] |
|**prepaidTotalQuantity** | **Double** | **Note**: This field is only available if you have the [Prepaid with Drawdown](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/J_Billing_Operations/Prepaid_with_Drawdown) feature enabled.  The total amount of units that end customers can use during a validity period when they subscribe to a [prepayment charge](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/J_Billing_Operations/Prepaid_with_Drawdown/Create_prepayment_charge).  |  [optional] |
|**prepaidUom** | **String** | **Note**: This field is only available if you have the [Prepaid with Drawdown](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/J_Billing_Operations/Prepaid_with_Drawdown) feature enabled.  Unit of measurement for a [prepayment charge](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/J_Billing_Operations/Prepaid_with_Drawdown/Create_prepayment_charge).  |  [optional] |
|**validityPeriodType** | [**ValidityPeriodTypeEnum**](#ValidityPeriodTypeEnum) | **Note**: This field is only available if you have the [Prepaid with Drawdown](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/J_Billing_Operations/Prepaid_with_Drawdown) feature enabled.  The period in which the prepayment units are valid to use as defined in a [prepayment charge](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/J_Billing_Operations/Prepaid_with_Drawdown/Create_prepayment_charge).  |  [optional] |
|**drawdownRate** | **Double** | **Note**: This field is only available if you have the [Prepaid with Drawdown](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/J_Billing_Operations/Prepaid_with_Drawdown) feature enabled.  The [conversion rate](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/J_Billing_Operations/Prepaid_with_Drawdown/Create_drawdown_charge#UOM_Conversion) between Usage UOM and Drawdown UOM for a [drawdown charge](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/J_Billing_Operations/Prepaid_with_Drawdown/Create_drawdown_charge). Must be a positive number (&gt;0).  |  [optional] |
|**drawdownUom** | **String** | **Note**: This field is only available if you have the [Prepaid with Drawdown](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/J_Billing_Operations/Prepaid_with_Drawdown) feature enabled.  Unit of measurement for a [drawdown charge](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/J_Billing_Operations/Prepaid_with_Drawdown/Create_drawdown_charge).  |  [optional] |
|**creditOption** | [**CreditOptionEnum**](#CreditOptionEnum) | **Note**: This field is only available if you have the [Prepaid with Drawdown](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/J_Billing_Operations/Prepaid_with_Drawdown) feature enabled.  The way to calculate credit. See [Credit Option](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/J_Billing_Operations/Prepaid_with_Drawdown/Create_prepayment_charge#Credit_Option) for more information.   |  [optional] |
|**isRollover** | **Boolean** | **Note**: This field is only available if you have the [Prepaid with Drawdown](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/J_Billing_Operations/Prepaid_with_Drawdown) feature enabled.  The value is either \&quot;true\&quot; or \&quot;false\&quot;. It determines whether the rollover fields are needed.  |  [optional] |
|**rolloverApply** | [**RolloverApplyEnum**](#RolloverApplyEnum) | **Note**: This field is only available if you have the [Prepaid with Drawdown](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/J_Billing_Operations/Prepaid_with_Drawdown) feature enabled.  This field defines the priority of rollover, which is either first or last.  |  [optional] |
|**rolloverPeriodLength** | **Integer** | **Note**: This field is only available if you have the [Prepaid with Drawdown](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/J_Billing_Operations/Prepaid_with_Drawdown) feature enabled.  The period length of the rollover fund.  |  [optional] |
|**rolloverPeriods** | **Double** | **Note**: This field is only available if you have the [Prepaid with Drawdown](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/J_Billing_Operations/Prepaid_with_Drawdown) feature enabled.  This field defines the number of rollover periods, it is restricted to 3.  |  [optional] |
|**formula** | **String** | The price lookup formula defined for the product rate plan charge, which is used to identify the correct and relevant charge definition based on the context.  For more information, see &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Build_products_and_prices/Attribute-based_pricing/Price_lookup_in_Attribute-based_Pricing\&quot;  target&#x3D;\&quot;_blank\&quot;&gt;Price lookup in Attribute-based Pricing&lt;/a&gt;.   **Note**: This field is available only if the &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Build_products_and_prices/Attribute-based_pricing\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Attribute-based Pricing&lt;/a&gt; feature is enabled.  |  [optional] |



## Enum: ApplyDiscountToEnum

| Name | Value |
|---- | -----|
| ONETIME | &quot;ONETIME&quot; |
| RECURRING | &quot;RECURRING&quot; |
| USAGE | &quot;USAGE&quot; |
| ONETIMERECURRING | &quot;ONETIMERECURRING&quot; |
| ONETIMEUSAGE | &quot;ONETIMEUSAGE&quot; |
| RECURRINGUSAGE | &quot;RECURRINGUSAGE&quot; |
| ONETIMERECURRINGUSAGE | &quot;ONETIMERECURRINGUSAGE&quot; |
| NULL | &quot;null&quot; |



## Enum: BillingPeriodAlignmentEnum

| Name | Value |
|---- | -----|
| ALIGNTOCHARGE | &quot;AlignToCharge&quot; |
| ALIGNTOSUBSCRIPTIONSTART | &quot;AlignToSubscriptionStart&quot; |
| ALIGNTOTERMSTART | &quot;AlignToTermStart&quot; |
| ALIGNTOTERMEND | &quot;AlignToTermEnd&quot; |



## Enum: BillingTimingEnum

| Name | Value |
|---- | -----|
| ADVANCE | &quot;IN_ADVANCE&quot; |
| ARREARS | &quot;IN_ARREARS&quot; |



## Enum: ChargeFunctionEnum

| Name | Value |
|---- | -----|
| STANDARD | &quot;Standard&quot; |
| PREPAYMENT | &quot;Prepayment&quot; |
| COMMITMENTTRUEUP | &quot;CommitmentTrueUp&quot; |
| DRAWDOWN | &quot;Drawdown&quot; |
| CREDITCOMMITMENT | &quot;CreditCommitment&quot; |
| DRAWDOWNANDCREDITCOMMITMENT | &quot;DrawdownAndCreditCommitment&quot; |



## Enum: CommitmentTypeEnum

| Name | Value |
|---- | -----|
| UNIT | &quot;UNIT&quot; |
| CURRENCY | &quot;CURRENCY&quot; |



## Enum: DiscountLevelEnum

| Name | Value |
|---- | -----|
| RATEPLAN | &quot;rateplan&quot; |
| SUBSCRIPTION | &quot;subscription&quot; |
| ACCOUNT | &quot;account&quot; |
| NULL | &quot;null&quot; |



## Enum: EndDateConditionEnum

| Name | Value |
|---- | -----|
| SUBSCRIPTION_END | &quot;Subscription_End&quot; |
| ONE_TIME | &quot;One_Time&quot; |
| FIXED_PERIOD | &quot;Fixed_Period&quot; |
| SPECIFIC_END_DATE | &quot;Specific_End_Date&quot; |



## Enum: RevenueRecognitionTimingEnum

| Name | Value |
|---- | -----|
| BILLING_DOCUMENT_POSTING_DATE | &quot;Upon Billing Document Posting Date&quot; |
| ORDER_ACTIVATION_DATE | &quot;Upon Order Activation Date&quot; |



## Enum: RevenueAmortizationMethodEnum

| Name | Value |
|---- | -----|
| IMMEDIATE | &quot;Immediate&quot; |
| RATABLE_USING_START_AND_END_DATES | &quot;Ratable Using Start And End Dates&quot; |



## Enum: ListPriceBaseEnum

| Name | Value |
|---- | -----|
| BILLING_PERIOD | &quot;Per_Billing_Period&quot; |
| MONTH | &quot;Per_Month&quot; |
| WEEK | &quot;Per_Week&quot; |
| YEAR | &quot;Per_Year&quot; |



## Enum: ModelEnum

| Name | Value |
|---- | -----|
| DISCOUNTFIXEDAMOUNT | &quot;DiscountFixedAmount&quot; |
| DISCOUNTPERCENTAGE | &quot;DiscountPercentage&quot; |
| FLATFEE | &quot;FlatFee&quot; |
| PERUNIT | &quot;PerUnit&quot; |
| OVERAGE | &quot;Overage&quot; |
| TIERED | &quot;Tiered&quot; |
| TIEREDWITHOVERAGE | &quot;TieredwithOverage&quot; |
| VOLUME | &quot;Volume&quot; |
| DELIVERY | &quot;Delivery&quot; |
| MULTIATTRIBUTEPRICING | &quot;MultiAttributePricing&quot; |
| PRERATEDPERUNIT | &quot;PreratedPerUnit&quot; |
| PRERATEDPRICING | &quot;PreratedPricing&quot; |
| HIGHWATERMARKVOLUMEPRICING | &quot;HighWatermarkVolumePricing&quot; |
| HIGHWATERMARKTIEREDPRICING | &quot;HighWatermarkTieredPricing&quot; |



## Enum: OverageCalculationOptionEnum

| Name | Value |
|---- | -----|
| ENDOFSMOOTHINGPERIOD | &quot;EndOfSmoothingPeriod&quot; |
| PERBILLINGPERIOD | &quot;PerBillingPeriod&quot; |
| NULL | &quot;null&quot; |



## Enum: OverageUnusedUnitsCreditOptionEnum

| Name | Value |
|---- | -----|
| NOCREDIT | &quot;NoCredit&quot; |
| CREDITBYSPECIFICRATE | &quot;CreditBySpecificRate&quot; |
| NULL | &quot;null&quot; |



## Enum: PriceChangeOptionEnum

| Name | Value |
|---- | -----|
| NOCHANGE | &quot;NoChange&quot; |
| SPECIFICPERCENTAGEVALUE | &quot;SpecificPercentageValue&quot; |
| USELATESTPRODUCTCATALOGPRICING | &quot;UseLatestProductCatalogPricing&quot; |
| NULL | &quot;null&quot; |



## Enum: PriceIncreaseOptionEnum

| Name | Value |
|---- | -----|
| FROMTENANTPERCENTAGEVALUE | &quot;FromTenantPercentageValue&quot; |
| SPECIFICPERCENTAGEVALUE | &quot;SpecificPercentageValue&quot; |



## Enum: RatingGroupEnum

| Name | Value |
|---- | -----|
| BYBILLINGPERIOD | &quot;ByBillingPeriod&quot; |
| BYUSAGESTARTDATE | &quot;ByUsageStartDate&quot; |
| BYUSAGERECORD | &quot;ByUsageRecord&quot; |
| BYUSAGEUPLOAD | &quot;ByUsageUpload&quot; |
| BYGROUPID | &quot;ByGroupId&quot; |
| NULL | &quot;null&quot; |



## Enum: RevRecTriggerConditionEnum

| Name | Value |
|---- | -----|
| CONTRACTEFFECTIVEDATE | &quot;ContractEffectiveDate&quot; |
| SERVICEACTIVATIONDATE | &quot;ServiceActivationDate&quot; |
| CUSTOMERACCEPTANCEDATE | &quot;CustomerAcceptanceDate&quot; |
| NULL | &quot;null&quot; |



## Enum: RevenueRecognitionRuleNameEnum

| Name | Value |
|---- | -----|
| UPON_INVOICING | &quot;Recognize upon invoicing&quot; |
| DAILY_OVER_TIME | &quot;Recognize daily over time&quot; |



## Enum: SmoothingModelEnum

| Name | Value |
|---- | -----|
| ROLLINGWINDOW | &quot;RollingWindow&quot; |
| ROLLOVER | &quot;Rollover&quot; |
| NULL | &quot;null&quot; |



## Enum: TaxModeEnum

| Name | Value |
|---- | -----|
| TAXEXCLUSIVE | &quot;TaxExclusive&quot; |
| TAXINCLUSIVE | &quot;TaxInclusive&quot; |
| NULL | &quot;null&quot; |



## Enum: TriggerEventEnum

| Name | Value |
|---- | -----|
| CONTRACTEFFECTIVE | &quot;ContractEffective&quot; |
| SERVICEACTIVATION | &quot;ServiceActivation&quot; |
| CUSTOMERACCEPTANCE | &quot;CustomerAcceptance&quot; |



## Enum: TypeEnum

| Name | Value |
|---- | -----|
| ONETIME | &quot;OneTime&quot; |
| RECURRING | &quot;Recurring&quot; |
| USAGE | &quot;Usage&quot; |



## Enum: UpToPeriodsTypeEnum

| Name | Value |
|---- | -----|
| BILLING_PERIODS | &quot;Billing_Periods&quot; |
| DAYS | &quot;Days&quot; |
| WEEKS | &quot;Weeks&quot; |
| MONTHS | &quot;Months&quot; |
| YEARS | &quot;Years&quot; |
| NULL | &quot;null&quot; |



## Enum: UsageRecordRatingOptionEnum

| Name | Value |
|---- | -----|
| ENDOFBILLINGPERIOD | &quot;EndOfBillingPeriod&quot; |
| ONDEMAND | &quot;OnDemand&quot; |
| NULL | &quot;null&quot; |



## Enum: PrepaidOperationTypeEnum

| Name | Value |
|---- | -----|
| TOPUP | &quot;topup&quot; |
| DRAWDOWN | &quot;drawdown&quot; |
| NULL | &quot;null&quot; |



## Enum: ValidityPeriodTypeEnum

| Name | Value |
|---- | -----|
| SUBSCRIPTION_TERM | &quot;SUBSCRIPTION_TERM&quot; |
| ANNUAL | &quot;ANNUAL&quot; |
| SEMI_ANNUAL | &quot;SEMI_ANNUAL&quot; |
| QUARTER | &quot;QUARTER&quot; |
| MONTH | &quot;MONTH&quot; |



## Enum: CreditOptionEnum

| Name | Value |
|---- | -----|
| TIMEBASED | &quot;TimeBased&quot; |
| CONSUMPTIONBASED | &quot;ConsumptionBased&quot; |
| FULLCREDITBACK | &quot;FullCreditBack&quot; |



## Enum: RolloverApplyEnum

| Name | Value |
|---- | -----|
| APPLYFIRST | &quot;ApplyFirst&quot; |
| APPLYLAST | &quot;ApplyLast&quot; |



