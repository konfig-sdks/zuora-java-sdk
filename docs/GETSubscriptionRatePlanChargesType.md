

# GETSubscriptionRatePlanChargesType


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**description** | **String** | Description of the rate plan charge.  |  [optional] |
|**version** | **Long** | Rate plan charge revision number.  |  [optional] |
|**amendedByOrderOn** | **String** | The date when the rate plan charge is amended through an order or amendment. This field is to standardize the booking date information to increase audit ability and traceability of data between Zuora Billing and Zuora Revenue. It is mapped as the booking date for a sale order line in Zuora Revenue.  |  [optional] |
|**applyDiscountTo** | **String** | Specifies the type of charges a specific discount applies to.   This field is only used when applied to a discount charge model. If you are not using a discount charge model, the value is null.  Possible values:  * &#x60;RECURRING&#x60; * &#x60;USAGE&#x60; * &#x60;ONETIMERECURRING&#x60; * &#x60;ONETIMEUSAGE&#x60; * &#x60;RECURRINGUSAGE&#x60; * &#x60;ONETIMERECURRINGUSAGE&#x60;  |  [optional] |
|**applyToBillingPeriodPartially** | **Boolean** | Allow the discount duration to be aligned with the billing period partially.  **Note**: This field is only available if you have the [Enhanced Discounts](https://knowledgecenter.zuora.com/Zuora_Billing/Build_products_and_prices/Basic_concepts_and_terms/B_Charge_Models/D_Manage_Enhanced_Discount) feature enabled.  |  [optional] |
|**billingDay** | **String** | Billing cycle day (BCD), which is when bill runs generate invoices for charges associated with the product rate plan charge or the account.    Values:  * &#x60;DefaultFromCustomer&#x60; * &#x60;SpecificDayofMonth(# of the month)&#x60; * &#x60;SubscriptionStartDay&#x60; * &#x60;ChargeTriggerDay&#x60; * &#x60;SpecificDayofWeek/dayofweek&#x60;: in which dayofweek is the day in the week you define your billing periods to start.  In the response data, a day-of-the-month ordinal value (&#x60;first&#x60;-&#x60;31st&#x60;) appears in place of the hash sign above (\&quot;#\&quot;). If this value exceeds the number of days in a particular month, the last day of the month is used as the BCD.  |  [optional] |
|**billingPeriod** | **String** | Allows billing period to be overridden on the rate plan charge.  |  [optional] |
|**billingPeriodAlignment** | **String** | Possible values:  * &#x60;AlignToCharge&#x60; * &#x60;AlignToSubscriptionStart&#x60; * &#x60;AlignToTermStart&#x60;  |  [optional] |
|**billingTiming** | **String** | The billing timing for the charge. This field is only used if the &#x60;ratePlanChargeType&#x60; value is &#x60;Recurring&#x60;.  Possible values are:  * &#x60;In Advance&#x60; * &#x60;In Arrears&#x60;  **Note:** This feature is in **Limited Availability**. If you wish to have access to the feature, submit a request at [Zuora Global Support](http://support.zuora.com/).  |  [optional] |
|**chargeFunction** | [**ChargeFunctionEnum**](#ChargeFunctionEnum) | **Note**: This field is only available if you have the &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Bill_your_customers/Bill_for_usage_or_prepaid_products/Advanced_Consumption_Billing/Unbilled_Usage\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Unbilled Usage&lt;/a&gt; feature enabled.  To use this field, you must set the &#x60;X-Zuora-WSDL-Version&#x60; request header to &#x60;141&#x60; or higher. Otherwise, an error occurs.  This field defines what type of charge it is in Advanced Consumption Billing: * Standard: Normal charge with no Prepayment or Commitment or Drawdown. * Prepayment: For recurring charges. Unit or currency based prepaid charge. * CommitmentTrueUp: For recurring charges. Currency based minimum commitment charge. * Drawdown: For usage charges. Drawdown from prepaid funds. * DrawdownAndCreditCommitment: For usage charges. Drawdown from prepaid funds and then credit to minimum commitment funds. * CreditCommitment: For usage charges. Credit to minimum commitment funds.  |  [optional] |
|**commitmentType** | [**CommitmentTypeEnum**](#CommitmentTypeEnum) | **Note**: This field is only available if you have the &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Bill_your_customers/Bill_for_usage_or_prepaid_products/Advanced_Consumption_Billing/Unbilled_Usage\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Unbilled Usage&lt;/a&gt; feature enabled.  To use this field, you must set the &#x60;X-Zuora-WSDL-Version&#x60; request header to &#x60;133&#x60; or higher. Otherwise, an error occurs.   This field defines the type of commitment. A prepaid charge can be &#x60;UNIT&#x60; or &#x60;CURRENCY&#x60;. A minimum commitment(in-arrears) charge can only be &#x60;CURRENCY&#x60; type. For topup(recurring or one-time) charges, this field indicates what type of funds are created.  * If UNIT, it will create a fund with given prepaidUom. * If CURRENCY, it will create a fund with the currency amount calculated in list price.    For drawdown(usage) charges, this field indicates what type of funds are drawdown from that created from topup charges.  |  [optional] |
|**chargeModelConfiguration** | [**ChargeModelConfigurationType**](ChargeModelConfigurationType.md) |  |  [optional] |
|**chargedThroughDate** | **LocalDate** | The date through which a customer has been billed for the charge.  |  [optional] |
|**creditOption** | [**CreditOptionEnum**](#CreditOptionEnum) | **Note**: This field is only available if you have the [Prepaid with Drawdown](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/J_Billing_Operations/Prepaid_with_Drawdown) feature enabled.  To use this field, you must set the &#x60;X-Zuora-WSDL-Version&#x60; request header to 114 or higher. Otherwise, an error occurs.  The way to calculate credit. See [Credit Option](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/J_Billing_Operations/Prepaid_with_Drawdown/Create_prepayment_charge#Credit_Option) for more information.  |  [optional] |
|**currency** | **String** | Currency used by the account. For example, &#x60;USD&#x60; or &#x60;EUR&#x60;.  |  [optional] |
|**discountAmount** | **Double** | The amount of the discount.  |  [optional] |
|**discountApplyDetails** | [**List&lt;GETDiscountApplyDetailsType&gt;**](GETDiscountApplyDetailsType.md) | Container for the application details about a discount rate plan charge.   Only discount rate plan charges have values in this field.  |  [optional] |
|**discountClass** | **String** | The class that the discount belongs to. The discount class defines the order in which discount rate plan charges are applied.  For more information, see [Manage Discount Classes](https://knowledgecenter.zuora.com/BC_Subscription_Management/Product_Catalog/B_Charge_Models/Manage_Discount_Classes).  |  [optional] |
|**discountLevel** | **String** | The level of the discount. Values: &#x60;RatePlan&#x60;, &#x60;Subscription&#x60;, &#x60;Account&#x60;.  |  [optional] |
|**discountPercentage** | **Double** | The amount of the discount as a percentage.  |  [optional] |
|**dmrc** | **Double** | The change (delta) of monthly recurring charge exists when the change in monthly recurring revenue caused by an amendment or a new subscription.  |  [optional] |
|**done** | **Boolean** | A value of &#x60;true&#x60; indicates that an invoice for a charge segment has been completed. A value of &#x60;false&#x60; indicates that an invoice has not been completed for the charge segment.  |  [optional] |
|**drawdownRate** | **Double** | **Note**: This field is only available if you have the [Prepaid with Drawdown](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/J_Billing_Operations/Prepaid_with_Drawdown) feature enabled.  The [conversion rate](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/J_Billing_Operations/Prepaid_with_Drawdown/Create_drawdown_charge#UOM_Conversion) between Usage UOM and Drawdown UOM for a [drawdown charge](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/J_Billing_Operations/Prepaid_with_Drawdown/Create_drawdown_charge). Must be a positive number (&gt;0).  |  [optional] |
|**drawdownUom** | **String** | **Note**: This field is only available if you have the [Prepaid with Drawdown](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/J_Billing_Operations/Prepaid_with_Drawdown) feature enabled.  Unit of measurement for a [drawdown charge](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/J_Billing_Operations/Prepaid_with_Drawdown/Create_drawdown_charge).  |  [optional] |
|**dtcv** | **Double** | After an amendment or an AutomatedPriceChange event, &#x60;dtcv&#x60; displays the change (delta) for the total contract value (TCV) amount for this charge, compared with its previous value with recurring charge types.  |  [optional] |
|**effectiveEndDate** | **LocalDate** | The effective end date of the rate plan charge.  |  [optional] |
|**effectiveStartDate** | **LocalDate** | The effective start date of the rate plan charge.  |  [optional] |
|**endDateCondition** | **String** | Defines when the charge ends after the charge trigger date.  If the subscription ends before the charge end date, the charge ends when the subscription ends. But if the subscription end date is subsequently changed through a Renewal, or Terms and Conditions amendment, the charge will end on the charge end date.  Values:  * &#x60;Subscription_End&#x60; * &#x60;Fixed_Period&#x60; * &#x60;Specific_End_Date&#x60; * &#x60;One_Time&#x60;  |  [optional] |
|**excludeItemBillingFromRevenueAccounting** | **Boolean** | The flag to exclude rate plan charge related invoice items, invoice item adjustments, credit memo items, and debit memo items from revenue accounting.  **Note**: This field is only available if you have the Order to Revenue or Billing - Revenue Integration feature enabled.   |  [optional] |
|**excludeItemBookingFromRevenueAccounting** | **Boolean** | The flag to exclude rate plan charges from revenue accounting.  **Note**: This field is only available if you have the Order to Revenue or Billing - Revenue Integration feature enabled.   |  [optional] |
|**id** | **String** | Rate plan charge ID.  |  [optional] |
|**includedUnits** | **Double** | Specifies the number of units in the base set of units.  |  [optional] |
|**invoiceScheduleId** | **String** | The ID of the invoice schedule associated with the rate plan charge on the subscription.  **Note**: This field is available only if you have the &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Bill_your_customers/Flexible_Billing/Billing_Schedule\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Billing Schedule&lt;/a&gt; feature enabled.  |  [optional] |
|**isAllocationEligible** | **Boolean** | This field is used to identify if the charge segment is allocation eligible in revenue recognition.  **Note**: This feature is in the **Early Adopter** phase. If you want to use the feature, submit a request at &lt;a href&#x3D;\&quot;https://support.zuora.com/\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Zuora Global Support&lt;/a&gt;, and we will evaluate whether the feature is suitable for your use cases.  |  [optional] |
|**isPrepaid** | **Boolean** | **Note**: This field is only available if you have the [Prepaid with Drawdown](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/J_Billing_Operations/Prepaid_with_Drawdown) feature enabled.  Indicates whether this charge is a prepayment (topup) charge or a drawdown charge. Values: &#x60;true&#x60; or &#x60;false&#x60;.  |  [optional] |
|**isRollover** | **Boolean** | **Note**: This field is only available if you have the [Prepaid with Drawdown](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/J_Billing_Operations/Prepaid_with_Drawdown) feature enabled.  The value is either \&quot;True\&quot; or \&quot;False\&quot;. It determines whether the rollover fields are needed.  |  [optional] |
|**isStackedDiscount** | **Boolean** | **Note**: This field is only applicable to the Discount - Percentage charge model.  To use this field, you must set the &#x60;X-Zuora-WSDL-Version&#x60; request header to 130 or higher. Otherwise, an error occurs.  This field indicates whether the discount is to be calculated as stacked discount. Possible values are as follows:   - &#x60;True&#x60;: This is a stacked discount, which should be calculated by stacking with other discounts.   - &#x60;False&#x60;: This is not a stacked discount, which should be calculated in sequence with other discounts.  For more information, see [Stacked discounts](https://knowledgecenter.zuora.com/Zuora_Billing/Products/Product_Catalog/B_Charge_Models/B_Discount_Charge_Models).  |  [optional] |
|**isUnbilled** | **Boolean** | This field is used to dictate how to perform the accounting during revenue recognition.  **Note**: This feature is in the **Early Adopter** phase. If you want to use the feature, submit a request at &lt;a href&#x3D;\&quot;https://support.zuora.com/\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Zuora Global Support&lt;/a&gt;, and we will evaluate whether the feature is suitable for your use cases.  |  [optional] |
|**listPriceBase** | **String** | List price base; possible values are:  * &#x60;Per_Billing_Period&#x60; * &#x60;Per_Month&#x60; * &#x60;Per_Week&#x60; * &#x60;Per_Year&#x60; * &#x60;Per_Specific_Months&#x60;  |  [optional] |
|**model** | **String** | Charge model; possible values are:  * &#x60;FlatFee&#x60; * &#x60;PerUnit&#x60; * &#x60;Overage&#x60; * &#x60;Volume&#x60; * &#x60;Tiered&#x60; * &#x60;TieredWithOverage&#x60; * &#x60;DiscountFixedAmount&#x60; * &#x60;DiscountPercentage&#x60; * &#x60;MultiAttributePricing&#x60; * &#x60;PreratedPerUnit&#x60; * &#x60;PreratedPricing&#x60; * &#x60;HighWatermarkVolumePricing&#x60; * &#x60;HighWatermarkTieredPricing&#x60; * &#x60;Delivery&#x60;  |  [optional] |
|**mrr** | **Double** | Monthly recurring revenue of the rate plan charge.  |  [optional] |
|**name** | **String** | Charge name.  |  [optional] |
|**number** | **String** | Charge number.  |  [optional] |
|**numberOfDeliveries** | **Double** | Number of deliveries in the billing period for the charge segment.  The &#x60;numberOfDeliveries&#x60; is used for the Delivery Pricing charge model only.   **Note**: The Delivery Pricing charge model is in the **Early Adopter** phase. We are actively soliciting feedback from a small set of early adopters before releasing it as generally available. To manage and access this feature through the self-service interface, see [Enable billing features by yourself](https://knowledgecenter.zuora.com/Zuora_Billing/Bill_your_customers/Billing_Settings/Manage_Features) in the Knowledge Center. You can check **Delivery Pricing** in **Billing Settings** &gt; **Enable Charge Types / Models**.  |  [optional] |
|**numberOfPeriods** | **Long** | Specifies the number of periods to use when calculating charges in an overage smoothing charge model.  |  [optional] |
|**originalChargeId** | **String** | The original ID of the rate plan charge.  |  [optional] |
|**originalOrderDate** | **LocalDate** | The date when the rate plan charge is created through an order or amendment.  This field is to standardize the booking date information to increase audit ability and traceability of data between Zuora Billing and Zuora Revenue. It is mapped as the booking date for a sale order line in Zuora Revenue.  |  [optional] |
|**overageCalculationOption** | **String** | Determines when to calculate overage charges.  |  [optional] |
|**overagePrice** | **Double** | The price for units over the allowed amount.  |  [optional] |
|**overageUnusedUnitsCreditOption** | **String** | Determines whether to credit the customer with unused units of usage.  |  [optional] |
|**prepaidOperationType** | [**PrepaidOperationTypeEnum**](#PrepaidOperationTypeEnum) | **Note**: This field is only available if you have the [Prepaid with Drawdown](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/J_Billing_Operations/Prepaid_with_Drawdown) feature enabled.  The type of this charge. It is either a prepayment (topup) charge or a drawdown charge.   |  [optional] |
|**prepaidQuantity** | **Double** | **Note**: This field is only available if you have the [Prepaid with Drawdown](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/J_Billing_Operations/Prepaid_with_Drawdown) feature enabled.  The number of units included in a [prepayment charge](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/J_Billing_Operations/Prepaid_with_Drawdown/Create_prepayment_charge). Must be a positive number (&gt;0).  |  [optional] |
|**prepaidTotalQuantity** | **Double** | **Note**: This field is only available if you have the [Prepaid with Drawdown](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/J_Billing_Operations/Prepaid_with_Drawdown) feature enabled.  The total amount of units that end customers can use during a validity period when they subscribe to a [prepayment charge](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/J_Billing_Operations/Prepaid_with_Drawdown/Create_prepayment_charge).  |  [optional] |
|**prepaidUom** | **String** | **Note**: This field is only available if you have the [Prepaid with Drawdown](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/J_Billing_Operations/Prepaid_with_Drawdown) feature enabled.  Unit of measurement for a [prepayment charge](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/J_Billing_Operations/Prepaid_with_Drawdown/Create_prepayment_charge).  |  [optional] |
|**price** | **Double** | The price associated with the rate plan charge expressed as a decimal.  |  [optional] |
|**priceChangeOption** | **String** | When the following is true:  1. AutomatedPriceChange setting is on  2. Charge type is not one-time  3. Charge model is not discount percentage  Then an automatic price change can have a value for when a termed subscription is renewed.   Values (one of the following):  * &#x60;NoChange&#x60; (default) * &#x60;SpecificPercentageValue&#x60; * &#x60;UseLatestProductCatalogPricing&#x60;  |  [optional] |
|**priceIncreasePercentage** | **Double** | A planned future price increase amount as a percentage.  |  [optional] |
|**pricingSummary** | **String** | Concise description of rate plan charge model.  |  [optional] |
|**processedThroughDate** | **LocalDate** | The date until when charges have been processed. When billing in arrears, such as usage, this field value is the the same as the &#x60;ChargedThroughDate&#x60; value. This date is the earliest date when a charge can be amended.  |  [optional] |
|**productCategory** | **String** | This is used to maintain the product category.   **Note**: This field is only available if you have the Additional Revenue Fields property enabled.  |  [optional] |
|**productClass** | **String** | This is used to maintain the product class.   **Note**: This field is only available if you have the Additional Revenue Fields property enabled.      |  [optional] |
|**productFamily** | **String** | This is used to maintain the product family.   **Note**: This field is only available if you have the Additional Revenue Fields property enabled.  |  [optional] |
|**productLine** | **String** | This is used to maintain the product line.   **Note**: This field is only available if you have the Additional Revenue Fields property enabled.  |  [optional] |
|**productRatePlanChargeId** | **String** |  |  [optional] |
|**quantity** | **Double** | The quantity of units, such as the number of authors in a hosted wiki service. Valid for all charge models except for Flat Fee pricing.  |  [optional] |
|**ratingGroup** | **String** | Specifies a rating group based on which usage records are rated.  Possible values:  - &#x60;ByBillingPeriod&#x60; (default): The rating is based on all the usages in a billing period. - &#x60;ByUsageStartDate&#x60;: The rating is based on all the usages on the same usage start date.  - &#x60;ByUsageRecord&#x60;: The rating is based on each usage record. - &#x60;ByUsageUpload&#x60;: The rating is based on all the  usages in a uploaded usage file (&#x60;.xls&#x60; or &#x60;.csv&#x60;). - &#x60;ByGroupId&#x60;: The rating is based on all the usages in a custom group.  **Note:**  - The &#x60;ByBillingPeriod&#x60; value can be applied for all charge models.  - The &#x60;ByUsageStartDate&#x60;, &#x60;ByUsageRecord&#x60;, and &#x60;ByUsageUpload&#x60; values can only be applied for per unit, volume pricing, and tiered pricing charge models.  - The &#x60;ByGroupId&#x60; value is only available if you have the Active Rating feature enabled. - Use this field only for Usage charges. One-Time Charges and Recurring Charges return &#x60;NULL&#x60;.  |  [optional] |
|**revenueRecognitionTiming** | [**RevenueRecognitionTimingEnum**](#RevenueRecognitionTimingEnum) | Specifies the type of revenue recognition timing.  Predefined options are listed as enum values in this API Reference. Other options might also be avaliable depending on the &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Enable_Order_to_Revenue/Configure_revenue_settings/Configure_revenue_recognition_policy\&quot; target&#x3D;\&quot;_blank\&quot;&gt;revenue recognition policy configuration&lt;/a&gt; in the Zuora Billing UI.  **Note**: This field is only available if you have the Order to Revenue feature enabled.      |  [optional] |
|**revenueAmortizationMethod** | [**RevenueAmortizationMethodEnum**](#RevenueAmortizationMethodEnum) | Specifies the type of revenue amortization method.  Predefined options are listed as enum values in this API Reference. Other options might also be avaliable depending on the &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Enable_Order_to_Revenue/Configure_revenue_settings/Configure_revenue_recognition_policy\&quot; target&#x3D;\&quot;_blank\&quot;&gt;revenue recognition policy configuration&lt;/a&gt; in the Zuora Billing UI.  **Note**: This field is only available if you have the Order to Revenue feature enabled.   |  [optional] |
|**rolloverApply** | [**RolloverApplyEnum**](#RolloverApplyEnum) | **Note**: This field is only available if you have the [Prepaid with Drawdown](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/J_Billing_Operations/Prepaid_with_Drawdown) feature enabled.  This field defines the priority of rollover, which is either first or last.  |  [optional] |
|**rolloverPeriodLength** | **Integer** | **Note**: This field is only available if you have the [Prepaid with Drawdown](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/J_Billing_Operations/Prepaid_with_Drawdown) feature enabled.  The period length of the rollover fund.  |  [optional] |
|**rolloverPeriods** | **Double** | **Note**: This field is only available if you have the [Prepaid with Drawdown](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/J_Billing_Operations/Prepaid_with_Drawdown) feature enabled.  This field defines the number of rollover periods, it is restricted to 3.  |  [optional] |
|**segment** | **Long** | The identifying number of the subscription rate plan segment. Segments are numbered sequentially, starting with 1.  |  [optional] |
|**smoothingModel** | **String** | Specifies when revenue recognition begins. When charge model is &#x60;Overage&#x60; or &#x60;TieredWithOverage&#x60;, &#x60;smoothingModel&#x60; will be one of the following values:  * &#x60;ContractEffectiveDate&#x60; * &#x60;ServiceActivationDate&#x60; * &#x60;CustomerAcceptanceDate&#x60;  |  [optional] |
|**specificBillingPeriod** | **Long** | Customizes the number of month or week for the charges billing period. This field is required if you set the value of the &#x60;BillingPeriod&#x60; field to &#x60;Specific_Months&#x60; or &#x60;Specific_Weeks&#x60;.  |  [optional] |
|**specificEndDate** | **LocalDate** | The specific date on which the charge ends. If the subscription ends before the specific end date, the charge ends when the subscription ends. But if the subscription end date is subsequently changed through a Renewal, or Terms and Conditions amendment, the charge will end on the specific end date.  |  [optional] |
|**specificListPriceBase** | **Object** | The number of months for the list price base of the charge.   **Note**:    - This field is available only if you have the &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Billing/Subscriptions/Product_Catalog/I_Annual_List_Price\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Annual List Price&lt;/a&gt; feature enabled.   - The value of this field is &#x60;null&#x60; if you do not set the value of the &#x60;listPriceBase&#x60; field to &#x60;Per_Specific_Months&#x60;.  |  [optional] |
|**subscriptionChargeDeliverySchedule** | [**GETDeliveryScheduleType**](GETDeliveryScheduleType.md) |  |  [optional] |
|**subscriptionChargeIntervalPricing** | [**List&lt;GETIntervalPriceType&gt;**](GETIntervalPriceType.md) | Interval Pricing information. This field is available if the Offers feature is enabled.  |  [optional] |
|**tcv** | **Double** | The total contract value.  |  [optional] |
|**tiers** | [**List&lt;GETTierType&gt;**](GETTierType.md) | One or many defined ranges with distinct pricing.  |  [optional] |
|**triggerDate** | **LocalDate** | The date that the rate plan charge will be triggered.  |  [optional] |
|**triggerEvent** | **String** | The event that will cause the rate plan charge to be triggered.  Possible values:   * &#x60;ContractEffective&#x60; * &#x60;ServiceActivation&#x60; * &#x60;CustomerAcceptance&#x60; * &#x60;SpecificDate&#x60;  |  [optional] |
|**type** | **String** | Charge type. Possible values are: &#x60;OneTime&#x60;, &#x60;Recurring&#x60;, &#x60;Usage&#x60;.  |  [optional] |
|**unusedUnitsCreditRates** | **Double** | Specifies the rate to credit a customer for unused units of usage. This field is applicable only for overage charge models when the  &#x60;OverageUnusedUnitsCreditOption&#x60; field value is &#x60;CreditBySpecificRate&#x60;.  |  [optional] |
|**upsellOriginChargeNumber** | **String** | The identifier of the original upselling charge associated with the current charge.  For a termed subscription, you can now use the \&quot;Create an order\&quot; API operation to perform an Add Product order action to make a product quantity upsell for per unit recurring charges. The benefit is that the charge added by this approach will be automatically combined with the original existing charge for which you want to upsell when the subscription is renewed. The approach is as follows: * Use an Add Product order action to add a charge that is of the same charge type, charge model, and charge end date as the existing per unit recurring charge for which you want to make a quantity upsell.  * In the preceding charge to add, use the &#x60;upsellOriginChargeNumber&#x60; field to specify the existing rate plan charge for which you want to make the quantity upsell.  Note that a termed subscription with such upsell charges can not be changed to an evergreen subscription.     **Note**: The Quantity Upsell feature is in the **Early Adopter** phase. We are actively soliciting feedback from a small set of early adopters before releasing it as generally available. If you want to join this early adopter program, submit a request at [Zuora Global Support](https://support.zuora.com).    |  [optional] |
|**uom** | **String** | Specifies the units to measure usage.   |  [optional] |
|**upToPeriods** | **String** | Specifies the length of the period during which the charge is active. If this period ends before the subscription ends, the charge ends when this period ends.  If the subscription end date is subsequently changed through a Renewal, or Terms and Conditions amendment, the charge end date will change accordingly up to the original period end.  |  [optional] |
|**upToPeriodsType** | **String** | The period type used to define when the charge ends.   Values:  * &#x60;Billing_Periods&#x60; * &#x60;Days&#x60; * &#x60;Weeks&#x60; * &#x60;Months&#x60; * &#x60;Years&#x60;  |  [optional] |
|**usageRecordRatingOption** | **String** | Determines how Zuora processes usage records for per-unit usage charges.   |  [optional] |
|**validityPeriodType** | [**ValidityPeriodTypeEnum**](#ValidityPeriodTypeEnum) | **Note**: This field is only available if you have the [Prepaid with Drawdown](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/J_Billing_Operations/Prepaid_with_Drawdown) feature enabled.  The period in which the prepayment units are valid to use as defined in a [prepayment charge](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/J_Billing_Operations/Prepaid_with_Drawdown/Create_prepayment_charge).  |  [optional] |



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



## Enum: CreditOptionEnum

| Name | Value |
|---- | -----|
| TIMEBASED | &quot;TimeBased&quot; |
| CONSUMPTIONBASED | &quot;ConsumptionBased&quot; |
| FULLCREDITBACK | &quot;FullCreditBack&quot; |



## Enum: PrepaidOperationTypeEnum

| Name | Value |
|---- | -----|
| TOPUP | &quot;topup&quot; |
| DRAWDOWN | &quot;drawdown&quot; |



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



## Enum: RolloverApplyEnum

| Name | Value |
|---- | -----|
| APPLYFIRST | &quot;ApplyFirst&quot; |
| APPLYLAST | &quot;ApplyLast&quot; |



## Enum: ValidityPeriodTypeEnum

| Name | Value |
|---- | -----|
| SUBSCRIPTION_TERM | &quot;SUBSCRIPTION_TERM&quot; |
| ANNUAL | &quot;ANNUAL&quot; |
| SEMI_ANNUAL | &quot;SEMI_ANNUAL&quot; |
| QUARTER | &quot;QUARTER&quot; |
| MONTH | &quot;MONTH&quot; |



