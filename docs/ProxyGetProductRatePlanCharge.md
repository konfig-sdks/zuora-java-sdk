

# ProxyGetProductRatePlanCharge


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**accountingCode** | **String** | The accounting code for the charge. Accounting codes group transactions that contain similar accounting attributes.  |  [optional] |
|**applyDiscountTo** | [**ApplyDiscountToEnum**](#ApplyDiscountToEnum) | Specifies the type of charges that you want a specific discount to apply to. All field values are case sensitive and in all-caps.  |  [optional] |
|**billCycleDay** | **Integer** | Sets the bill cycle day (BCD) for the charge. The BCD determines which day of the month customer is billed. The BCD value in the account can override the BCD in this object.  **Character limit**: 2  **Values**: a valid BCD integer, 1 - 31  |  [optional] |
|**billCycleType** | [**BillCycleTypeEnum**](#BillCycleTypeEnum) | Specifies how to determine the billing day for the charge.                 |  [optional] |
|**billingPeriod** | [**BillingPeriodEnum**](#BillingPeriodEnum) | The billing period for the charge. The start day of the billing period is also called the bill cycle day (BCD).  |  [optional] |
|**billingPeriodAlignment** | [**BillingPeriodAlignmentEnum**](#BillingPeriodAlignmentEnum) | Aligns charges within the same subscription if multiple charges begin on different dates.  |  [optional] |
|**billingTiming** | [**BillingTimingEnum**](#BillingTimingEnum) | The billing timing for the charge. You can choose to bill in advance or in arrears for recurring charge types. This field is not used in one-time or usage based charge types.  This feature is in **Limited Availability**. If you wish to have access to the feature, submit a request at [Zuora Global Support](http://support.zuora.com/).   |  [optional] |
|**chargeFunction** | [**ChargeFunctionEnum**](#ChargeFunctionEnum) | **Note**: This field is only available if you have the &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Bill_your_customers/Bill_for_usage_or_prepaid_products/Advanced_Consumption_Billing/Unbilled_Usage\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Unbilled Usage&lt;/a&gt; feature enabled.  To use this field, you must set the &#x60;X-Zuora-WSDL-Version&#x60; request header to &#x60;141&#x60; or higher. Otherwise, an error occurs.  This field defines what type of charge it is in Advanced Consumption Billing: * Standard: Normal charge with no Prepayment or Commitment or Drawdown. * Prepayment: For recurring charges. Unit or currency based prepaid charge. * CommitmentTrueUp: For recurring charges. Currency based minimum commitment charge. * Drawdown: For usage charges. Drawdown from prepaid funds. * DrawdownAndCreditCommitment: For usage charges. Drawdown from prepaid funds and then credit to minimum commitment funds. * CreditCommitment: For usage charges. Credit to minimum commitment funds.  |  [optional] |
|**commitmentType** | [**CommitmentTypeEnum**](#CommitmentTypeEnum) | **Note**: This field is only available if you have the &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Bill_your_customers/Bill_for_usage_or_prepaid_products/Advanced_Consumption_Billing/Unbilled_Usage\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Unbilled Usage&lt;/a&gt; feature enabled.  To use this field, you must set the &#x60;X-Zuora-WSDL-Version&#x60; request header to &#x60;133&#x60; or higher. Otherwise, an error occurs.   This field defines the type of commitment. A prepaid charge can be &#x60;UNIT&#x60; or &#x60;CURRENCY&#x60;. A minimum commitment(in-arrears) charge can only be &#x60;CURRENCY&#x60; type. For topup(recurring or one-time) charges, this field indicates what type of funds are created.  * If UNIT, it will create a fund with given prepaidUom. * If CURRENCY, it will create a fund with the currency amount calculated in list price.    For drawdown(usage) charges, this field indicates what type of funds are drawdown from that created from topup charges.  |  [optional] |
|**chargeModel** | [**ChargeModelEnum**](#ChargeModelEnum) | Determines how to calculate charges. Charge models must be individually activated in Zuora Billing administration.  |  [optional] |
|**chargeType** | [**ChargeTypeEnum**](#ChargeTypeEnum) | Specifies the type of charge.  |  [optional] |
|**createdById** | **String** | The automatically generated ID of the Zuora user who created the &#x60;ProductRatePlanCharge&#x60; object.  |  [optional] |
|**createdDate** | **OffsetDateTime** | The date when the &#x60;ProductRatePlanCharge&#x60; object was created.  |  [optional] |
|**defaultQuantity** | **Double** | The default quantity of units, such as the number of authors in a hosted wiki service. This field is required if you use a per-unit pricing model.  **Character limit**: 16  **Values**: a valid quantity value.  **Note**: When &#x60;ChargeModel&#x60; is &#x60;Tiered Pricing&#x60; or &#x60;Volume Pricing&#x60;, if this field is not specified, the value will default to &#x60;0&#x60;.  |  [optional] |
|**deferredRevenueAccount** | **String** | The name of the deferred revenue account for this charge.  This feature is in **Limited Availability**. If you wish to have access to the feature, submit a request at [Zuora Global Support](http://support.zuora.com/).   |  [optional] |
|**description** | **String** | A description of the charge.  |  [optional] |
|**discountLevel** | [**DiscountLevelEnum**](#DiscountLevelEnum) | Specifies if the discount applies to just the product rate plan, the entire subscription, or to any activity in the account.  |  [optional] |
|**endDateCondition** | [**EndDateConditionEnum**](#EndDateConditionEnum) | Defines when the charge ends after the charge trigger date.  **Values**:    - &#x60;SubscriptionEnd&#x60;: The charge ends on the subscription end date after a specified period based on the trigger date of the charge.    - &#x60;FixedPeriod&#x60;: The charge ends after a specified period based on the trigger date of the charge. If you set this field to &#x60;FixedPeriod&#x60;, you must specify the length of the period and a period type by defining the &#x60;UpToPeriods&#x60; and &#x60;UpToPeriodsType&#x60; fields.     **Note**: If the subscription ends before the charge end date, the charge ends when the subscription ends. But if the subscription end date is subsequently changed through a Renewal, or Terms and Conditions amendment, the charge will end on the charge end date.  |  [optional] |
|**excludeItemBillingFromRevenueAccounting** | **Boolean** | The flag to exclude the related invoice items, invoice item adjustments, credit memo items, and debit memo items from revenue accounting.  **Notes**:    - To use this field, you must set the &#x60;X-Zuora-WSDL-Version&#x60; request header to &#x60;115&#x60; or later. Otherwise, an error occurs.   - This field is only available if you have the Order to Revenue or Billing - Revenue Integration feature enabled.   |  [optional] |
|**excludeItemBookingFromRevenueAccounting** | **Boolean** | The flag to exclude the related rate plan charges and order line items from revenue accounting.  **Notes**:    - To use this field, you must set the &#x60;X-Zuora-WSDL-Version&#x60; request header to &#x60;115&#x60; or later. Otherwise, an error occurs.   - This field is only available if you have the Order to Revenue or Billing - Revenue Integration feature enabled.   |  [optional] |
|**id** | **String** | Object identifier. |  [optional] |
|**includedUnits** | **Double** | Specifies the number of units in the base set of units.  **Character limit**: 16  **Values**: a positive decimal value  |  [optional] |
|**legacyRevenueReporting** | **Boolean** |  |  [optional] |
|**listPriceBase** | [**ListPriceBaseEnum**](#ListPriceBaseEnum) | The list price base for the product rate plan charge.  |  [optional] |
|**maxQuantity** | **Double** | Specifies the maximum number of units for this charge. Use this field and the &#x60;MinQuantity&#x60; field to create a range of units allowed in a product rate plan charge.  **Character limit**: 16  **Values**: a positive decimal value  |  [optional] |
|**minQuantity** | **Double** | Specifies the minimum number of units for this charge. Use this field and the &#x60;MaxQuantity&#x60; field to create a range of units allowed in a product rate plan charge.  **Character limit**: 16  **Values**: a positive decimal value  |  [optional] |
|**name** | **String** | The name of the product rate plan charge.  |  [optional] |
|**numberOfPeriod** | **Long** | Specifies the number of periods to use when calculating charges in an overage smoothing charge model. The valid value is a positive whole number.  |  [optional] |
|**overageCalculationOption** | [**OverageCalculationOptionEnum**](#OverageCalculationOptionEnum) | Determines when to calculate overage charges. If the value of the SmoothingMode field is not specified, the value of this field is ignored.  **Values**:    - &#x60;EndOfSmoothingPeriod&#x60;: This option is used by default. The overage is charged at the end of the smoothing period.   - &#x60;PerBillingPeriod&#x60;: The overage is charged on-demand rather than waiting until the end of the smoothing period.  |  [optional] |
|**overageUnusedUnitsCreditOption** | [**OverageUnusedUnitsCreditOptionEnum**](#OverageUnusedUnitsCreditOptionEnum) | Determines whether to credit the customer with unused units of usage.  |  [optional] |
|**priceChangeOption** | [**PriceChangeOptionEnum**](#PriceChangeOptionEnum) | Applies an automatic price change when a termed subscription is renewed.  |  [optional] |
|**priceIncreasePercentage** | **Double** | Specifies the percentage to increase or decrease the price of a termed subscription&#39;s renewal. Use this field if you set the value to &#x60;SpecificPercentageValue&#x60;.  **Character limit**: 16  **Values**: a decimal value between -100 and 100  |  [optional] |
|**productRatePlanId** | **String** | The ID of the product rate plan associated with this product rate plan charge.  |  [optional] |
|**ratingGroup** | [**RatingGroupEnum**](#RatingGroupEnum) | A rating group based on which usage records are rated. Only applicable to Usage charges.  Possible values:   - &#x60;ByBillingPeriod&#x60;: The rating is based on all the usages in a billing period.   - &#x60;ByUsageStartDate&#x60;: The rating is based on all the usages on the same usage start date.    - &#x60;ByUsageRecord&#x60;: The rating is based on each usage record.   - &#x60;ByUsageUpload&#x60;: The rating is based on all the  usages in a uploaded usage file (&#x60;.xls&#x60; or &#x60;.csv&#x60;).   - &#x60;ByGroupId&#x60;: The rating is based on all the usages in a custom group.  For more information, see [Usage rating by group](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/J_Billing_Operations/Usage/Usage_Rating_by_Group).  |  [optional] |
|**recognizedRevenueAccount** | **String** | The name of the recognized revenue account for this charge.   - Required when the Allow Blank Accounting Code setting is No.   - Optional when the Allow Blank Accounting Code setting is Yes.  This feature is in **Limited Availability**. If you wish to have access to the feature, submit a request at [Zuora Global Support](http://support.zuora.com/).   |  [optional] |
|**revRecCode** | **String** | Associates this product rate plan charge with a specific revenue recognition code.  |  [optional] |
|**revRecTriggerCondition** | [**RevRecTriggerConditionEnum**](#RevRecTriggerConditionEnum) | Specifies when revenue recognition begins.  |  [optional] |
|**revenueRecognitionRuleName** | [**RevenueRecognitionRuleNameEnum**](#RevenueRecognitionRuleNameEnum) | Determines when to recognize the revenue for this charge.  |  [optional] |
|**smoothingModel** | [**SmoothingModelEnum**](#SmoothingModelEnum) | Specifies the smoothing model for an overage smoothing charge model.  |  [optional] |
|**specificBillingPeriod** | **Long** | Customizes the number of months or weeks for the charges billing period. This field is required if you set the value of the BillingPeriod field to &#x60;Specific Months&#x60; or &#x60;Specific Weeks&#x60;. The valid value is a positive integer.  |  [optional] |
|**specificListPriceBase** | **Integer** | The number of months for the list price base of the charge. The value of this field is &#x60;null&#x60; if you do not set the value of the &#x60;ListPriceBase&#x60; field to &#x60;Per Specific Months&#x60;.  **Notes**:    - This field is available only if you have the &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Billing/Subscriptions/Product_Catalog/I_Annual_List_Price\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Annual List Price&lt;/a&gt; feature enabled.   - To use this field, you must set the &#x60;X-Zuora-WSDL-Version&#x60; request header to &#x60;129&#x60; or later. Otherwise, an error occurs.   - The value of this field is &#x60;null&#x60; if you do not set the value of the &#x60;ListPriceBase&#x60; field to &#x60;Per Specific Months&#x60;.  |  [optional] |
|**taxCode** | **String** | Specifies the tax code for taxation rules. Required when the Taxable field is set to &#x60;True&#x60;.  **Note**: This value affects the tax calculation of rate plan charges that come from the &#x60;ProductRatePlanCharge&#x60;.  |  [optional] |
|**taxMode** | [**TaxModeEnum**](#TaxModeEnum) | Determines how to define taxation for the charge. Required when the Taxable field is set to &#x60;True&#x60;.  **Note**: This value affects the tax calculation of rate plan charges that come from the &#x60;ProductRatePlanCharge&#x60;.  |  [optional] |
|**taxable** | **Boolean** | Determines whether the charge is taxable. When set to &#x60;True&#x60;, the TaxMode and TaxCode fields are required when creating or updating th ProductRatePlanCharge object.  **Character limit**: 5  **Values**: &#x60;True&#x60;, &#x60;False&#x60;  **Note**: This value affects the tax calculation of rate plan charges that come from the &#x60;ProductRatePlanCharge&#x60;.  |  [optional] |
|**triggerEvent** | [**TriggerEventEnum**](#TriggerEventEnum) | Specifies when to start billing the customer for the charge.  **Values**:   - &#x60;ContractEffective&#x60; is the date when the subscription&#39;s contract goes into effect and the charge is ready to be billed.   - &#x60;ServiceActivation&#x60; is the date when the services or products for a subscription have been activated and the customers have access.   - &#x60;CustomerAcceptance&#x60; is when the customer accepts the services or products for a subscription.  |  [optional] |
|**UOM** | **String** | Specifies the units to measure usage.   **Note**: You must specify this field when creating the following charge models:   - Per Unit Pricing   - Volume Pricin   - Overage Pricing   - Tiered Pricing   - Tiered with Overage Pricing  |  [optional] |
|**upToPeriods** | **Long** | Specifies the length of the period during which the charge is active. If this period ends before the subscription ends, the charge ends when this period ends.  **Character limit**: 5  **Values**: a whole number between 0 and 65535, exclusive  **Notes**:   - You must use this field together with the &#x60;UpToPeriodsType&#x60; field to specify the time period. This field is applicable only when the &#x60;EndDateCondition&#x60; field is set to &#x60;FixedPeriod&#x60;.    - If the subscription end date is subsequently changed through a Renewal, or Terms and Conditions amendment, the charge end date will change accordingly up to the original period end.  |  [optional] |
|**upToPeriodsType** | [**UpToPeriodsTypeEnum**](#UpToPeriodsTypeEnum) | The period type used to define when the charge ends.  **Notes**:   - You must use this field together with the &#x60;UpToPeriods&#x60; field to specify the time period.  - This field is applicable only when the &#x60;EndDateCondition&#x60; field is set to &#x60;FixedPeriod&#x60;.   |  [optional] |
|**updatedById** | **String** | The ID of the last user to update the object.  |  [optional] |
|**updatedDate** | **OffsetDateTime** | The date when the object was last updated.  |  [optional] |
|**useDiscountSpecificAccountingCode** | **Boolean** | Determines whether to define a new accounting code for the new discount charge.  **Character limit**: 5  **Values**: &#x60;True&#x60;, &#x60;False&#x60;  |  [optional] |
|**useTenantDefaultForPriceChange** | **Boolean** | Applies the tenant-level percentage uplift value for an automatic price change to a termed subscription&#39;s renewal.   **Character limit**: 5  **Values**: &#x60;true&#x60;, &#x60;false&#x60;  |  [optional] |
|**weeklyBillCycleDay** | [**WeeklyBillCycleDayEnum**](#WeeklyBillCycleDayEnum) | Specifies which day of the week as the bill cycle day (BCD) for the charge.  This feature is in **Limited Availability**. If you wish to have access to the feature, submit a request at [Zuora Global Support](http://support.zuora.com/).   |  [optional] |
|**isAllocationEligible** | **Boolean** | Indicates whether the charge segment is allocation eligible in revenue recognition. The default value is &#x60;False&#x60;.  **Values**: &#x60;True&#x60;, &#x60;False&#x60;  **Notes**:    - This field is available only if you have the Additional Revenue Fields property enabled.   - To use this field, you must set the &#x60;X-Zuora-WSDL-Version&#x60; request header to 132 or later.  |  [optional] |
|**isUnbilled** | **Boolean** | Specifies how to perform the accounting during revenue recognition. The default value is &#x60;False&#x60;.  **Values**: &#x60;True&#x60;, &#x60;False&#x60;  **Notes**:    - This field is available only if you have the Additional Revenue Fields property enabled.   - To use this field, you must set the &#x60;X-Zuora-WSDL-Version&#x60; request header to 132 or later.     |  [optional] |
|**productCategory** | **String** | This field is used to maintain the product category for integration with Zuora Revenue.   **Notes**:    - This field is available only if you have the Additional Revenue Fields property enabled.   - To use this field, you must set the &#x60;X-Zuora-WSDL-Version&#x60; request header to 132 or later.  |  [optional] |
|**productClass** | **String** | This field is used to maintain the product class for integration with Zuora Revenue.   **Notes**:    - This field is available only if you have the Additional Revenue Fields property enabled.    - To use this field, you must set the &#x60;X-Zuora-WSDL-Version&#x60; request header to 132 or later.     |  [optional] |
|**productFamily** | **String** | This field is used to maintain the product family for integration with Zuora Revenue.   **Notes**:    - This field is available only if you have the Additional Revenue Fields property enabled.   - To use this field, you must set the &#x60;X-Zuora-WSDL-Version&#x60; request header to 132 or later.  |  [optional] |
|**productLine** | **String** | This field is used to maintain the product line for integration with Zuora Revenue.   **Notes**:    - This field is available only if you have the Additional Revenue Fields property enabled.    - To use this field, you must set the &#x60;X-Zuora-WSDL-Version&#x60; request header to 132 or later.             |  [optional] |
|**revenueRecognitionTiming** | [**RevenueRecognitionTimingEnum**](#RevenueRecognitionTimingEnum) | Specifies the type of revenue recognition timing.  Predefined options are listed as enum values in this API Reference.  Other options might also be avaliable depending on  the &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Enable_Order_to_Revenue/Configure_revenue_settings/Configure_revenue_recognition_policy\&quot; target&#x3D;\&quot;_blank\&quot;&gt;revenue recognition policy configuration&lt;/a&gt; in the Zuora Billing UI.  **Note**: This field is only available if you have the Order to Revenue feature enabled.   |  [optional] |
|**revenueAmortizationMethod** | [**RevenueAmortizationMethodEnum**](#RevenueAmortizationMethodEnum) | Specifies the type of revenue amortization method.  Predefined options are listed as enum values in this API Reference.  Other options might also be avaliable depending on  the &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Enable_Order_to_Revenue/Configure_revenue_settings/Configure_revenue_recognition_policy\&quot; target&#x3D;\&quot;_blank\&quot;&gt;revenue recognition policy configuration&lt;/a&gt; in the Zuora Billing UI.  **Note**: This field is only available if you have the Order to Revenue feature enabled.   |  [optional] |
|**applyToBillingPeriodPartially** | **Boolean** | Allow the discount duration to be aligned with the billing period partially.  **Note**: You must enable the [Enhanced Discount](https://knowledgecenter.zuora.com/Zuora_Billing/Build_products_and_prices/Basic_concepts_and_terms/B_Charge_Models/D_Manage_Enhanced_Discount) feature to access this field.  |  [optional] |
|**formula** | **String** | The price lookup formula defined for the product rate plan charge, which is used to identify the correct and relevant charge definition based on the context.  For more information, see &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Build_products_and_prices/Attribute-based_pricing/Price_lookup_in_Attribute-based_Pricing\&quot;  target&#x3D;\&quot;_blank\&quot;&gt;Price lookup in Attribute-based Pricing&lt;/a&gt;.   **Notes**:    - This field is available only if the &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Build_products_and_prices/Attribute-based_pricing\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Attribute-based Pricing&lt;/a&gt; feature is enabled.   - To use this field, you must set the &#x60;X-Zuora-WSDL-Version&#x60; request header to 138 or higher.  |  [optional] |
|**classNS** | **String** | Class associated with the corresponding item in NetSuite. Only available if you have installed the [Zuora Connector for NetSuite](https://www.zuora.com/connect/app/?appId&#x3D;265).  |  [optional] |
|**deferredRevAccountNS** | **String** | Deferrred revenue account associated with the corresponding item in NetSuite. Only available if you have installed the [Zuora Connector for NetSuite](https://www.zuora.com/connect/app/?appId&#x3D;265).  |  [optional] |
|**departmentNS** | **String** | Department associated with the corresponding item in NetSuite. Only available if you have installed the [Zuora Connector for NetSuite](https://www.zuora.com/connect/app/?appId&#x3D;265).  |  [optional] |
|**includeChildrenNS** | [**IncludeChildrenNSEnum**](#IncludeChildrenNSEnum) | Specifies whether the corresponding item in NetSuite is visible under child subsidiaries. Only available if you have installed the [Zuora Connector for NetSuite](https://www.zuora.com/connect/app/?appId&#x3D;265).  |  [optional] |
|**integrationIdNS** | **String** | ID of the corresponding object in NetSuite. Only available if you have installed the [Zuora Connector for NetSuite](https://www.zuora.com/connect/app/?appId&#x3D;265).  |  [optional] |
|**integrationStatusNS** | **String** | Status of the product rate plan charge&#39;s synchronization with NetSuite. Only available if you have installed the [Zuora Connector for NetSuite](https://www.zuora.com/connect/app/?appId&#x3D;265).  |  [optional] |
|**itemTypeNS** | [**ItemTypeNSEnum**](#ItemTypeNSEnum) | Type of item that is created in NetSuite for the product rate plan charge. Only available if you have installed the [Zuora Connector for NetSuite](https://www.zuora.com/connect/app/?appId&#x3D;265).  |  [optional] |
|**locationNS** | **String** | Location associated with the corresponding item in NetSuite. Only available if you have installed the [Zuora Connector for NetSuite](https://www.zuora.com/connect/app/?appId&#x3D;265).  |  [optional] |
|**recognizedRevAccountNS** | **String** | Recognized revenue account associated with the corresponding item in NetSuite. Only available if you have installed the [Zuora Connector for NetSuite](https://www.zuora.com/connect/app/?appId&#x3D;265).  |  [optional] |
|**revRecEndNS** | [**RevRecEndNSEnum**](#RevRecEndNSEnum) | End date condition of the corresponding item in NetSuite. Only available if you have installed the [Zuora Connector for NetSuite](https://www.zuora.com/connect/app/?appId&#x3D;265).  |  [optional] |
|**revRecStartNS** | [**RevRecStartNSEnum**](#RevRecStartNSEnum) | Start date condition of the corresponding item in NetSuite. Only available if you have installed the [Zuora Connector for NetSuite](https://www.zuora.com/connect/app/?appId&#x3D;265).  |  [optional] |
|**revRecTemplateTypeNS** | **String** | Only available if you have installed the [Zuora Connector for NetSuite](https://www.zuora.com/connect/app/?appId&#x3D;265).  |  [optional] |
|**subsidiaryNS** | **String** | Subsidiary associated with the corresponding item in NetSuite. Only available if you have installed the [Zuora Connector for NetSuite](https://www.zuora.com/connect/app/?appId&#x3D;265).  |  [optional] |
|**syncDateNS** | **String** | Date when the product rate plan charge was synchronized with NetSuite. Only available if you have installed the [Zuora Connector for NetSuite](https://www.zuora.com/connect/app/?appId&#x3D;265).  |  [optional] |



## Enum: ApplyDiscountToEnum

| Name | Value |
|---- | -----|
| ONETIME_1_ | &quot;ONETIME (1)&quot; |
| RECURRING_2_ | &quot;RECURRING (2)&quot; |
| USAGE_4_ | &quot;USAGE (4)&quot; |
| ONETIMERECURRING_3_ | &quot;ONETIMERECURRING (3)&quot; |
| ONETIMEUSAGE_5_ | &quot;ONETIMEUSAGE (5)&quot; |
| RECURRINGUSAGE_6_ | &quot;RECURRINGUSAGE (6)&quot; |
| ONETIMERECURRINGUSAGE_7_ | &quot;ONETIMERECURRINGUSAGE (7)&quot; |



## Enum: BillCycleTypeEnum

| Name | Value |
|---- | -----|
| DEFAULTFROMCUSTOMER | &quot;DefaultFromCustomer&quot; |
| SPECIFICDAYOFMONTH | &quot;SpecificDayofMonth&quot; |
| SUBSCRIPTIONSTARTDAY | &quot;SubscriptionStartDay&quot; |
| CHARGETRIGGERDAY | &quot;ChargeTriggerDay&quot; |
| SPECIFICDAYOFWEEK | &quot;SpecificDayofWeek&quot; |
| TERMSTARTDAY | &quot;TermStartDay&quot; |
| TERMENDDAY | &quot;TermEndDay&quot; |



## Enum: BillingPeriodEnum

| Name | Value |
|---- | -----|
| MONTH | &quot;Month&quot; |
| QUARTER | &quot;Quarter&quot; |
| ANNUAL | &quot;Annual&quot; |
| SEMI_ANNUAL | &quot;Semi-Annual&quot; |
| SPECIFIC_MONTHS | &quot;Specific Months&quot; |
| SUBSCRIPTION_TERM | &quot;Subscription Term&quot; |
| WEEK | &quot;Week&quot; |
| SPECIFIC_WEEKS | &quot;Specific Weeks&quot; |
| SPECIFIC_DAYS | &quot;Specific Days&quot; |



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
| ADVANCE | &quot;In Advance&quot; |
| ARREARS | &quot;In Arrears&quot; |



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



## Enum: ChargeModelEnum

| Name | Value |
|---- | -----|
| DISCOUNT_FIXED_AMOUNT | &quot;Discount-Fixed Amount&quot; |
| DISCOUNT_PERCENTAGE | &quot;Discount-Percentage&quot; |
| FLAT_FEE_PRICING | &quot;Flat Fee Pricing&quot; |
| PER_UNIT_PRICING | &quot;Per Unit Pricing&quot; |
| OVERAGE_PRICING | &quot;Overage Pricing&quot; |
| TIERED_PRICING | &quot;Tiered Pricing&quot; |
| TIERED_WITH_OVERAGE_PRICING | &quot;Tiered with Overage Pricing&quot; |
| VOLUME_PRICING | &quot;Volume Pricing&quot; |
| DELIVERY_PRICING | &quot;Delivery Pricing&quot; |
| MULTIATTRIBUTEPRICING | &quot;MultiAttributePricing&quot; |
| PRERATEDPERUNIT | &quot;PreratedPerUnit&quot; |
| PRERATEDPRICING_ | &quot;PreratedPricing&#x60;&quot; |
| HIGHWATERMARKVOLUMEPRICING | &quot;HighWatermarkVolumePricing&quot; |
| HIGHWATERMARKTIEREDPRICING | &quot;HighWatermarkTieredPricing&quot; |



## Enum: ChargeTypeEnum

| Name | Value |
|---- | -----|
| ONETIME | &quot;OneTime&quot; |
| RECURRING | &quot;Recurring&quot; |
| USAGE | &quot;Usage&quot; |



## Enum: DiscountLevelEnum

| Name | Value |
|---- | -----|
| RATEPLAN | &quot;rateplan&quot; |
| SUBSCRIPTION | &quot;subscription&quot; |
| ACCOUNT | &quot;account&quot; |



## Enum: EndDateConditionEnum

| Name | Value |
|---- | -----|
| SUBSCRIPTIONEND | &quot;SubscriptionEnd&quot; |
| FIXEDPERIOD | &quot;FixedPeriod&quot; |



## Enum: ListPriceBaseEnum

| Name | Value |
|---- | -----|
| BILLING_PERIOD | &quot;Per Billing Period&quot; |
| MONTH | &quot;Per Month&quot; |
| WEEK | &quot;Per Week&quot; |
| YEAR | &quot;Per Year&quot; |
| SPECIFIC_MONTHS | &quot;Per Specific Months&quot; |



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



## Enum: UpToPeriodsTypeEnum

| Name | Value |
|---- | -----|
| BILLING_PERIODS | &quot;Billing Periods&quot; |
| DAYS | &quot;Days&quot; |
| WEEKS | &quot;Weeks&quot; |
| MONTHS | &quot;Months&quot; |
| YEARS | &quot;Years&quot; |
| NULL | &quot;null&quot; |



## Enum: WeeklyBillCycleDayEnum

| Name | Value |
|---- | -----|
| SUNDAY | &quot;Sunday&quot; |
| MONDAY | &quot;Monday&quot; |
| TUESDAY | &quot;Tuesday&quot; |
| WEDNESDAY | &quot;Wednesday&quot; |
| THURSDAY | &quot;Thursday&quot; |
| FRIDAY | &quot;Friday&quot; |
| SATURDAY | &quot;Saturday&quot; |



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



## Enum: IncludeChildrenNSEnum

| Name | Value |
|---- | -----|
| TRUE | &quot;true&quot; |
| FALSE | &quot;false&quot; |



## Enum: ItemTypeNSEnum

| Name | Value |
|---- | -----|
| INVENTORY | &quot;Inventory&quot; |
| NON_INVENTORY | &quot;Non Inventory&quot; |
| SERVICE | &quot;Service&quot; |



## Enum: RevRecEndNSEnum

| Name | Value |
|---- | -----|
| CHARGE_PERIOD_START | &quot;Charge Period Start&quot; |
| REV_REC_TRIGGER_DATE | &quot;Rev Rec Trigger Date&quot; |
| USE_NETSUITE_REV_REC_TEMPLATE | &quot;Use NetSuite Rev Rec Template&quot; |



## Enum: RevRecStartNSEnum

| Name | Value |
|---- | -----|
| CHARGE_PERIOD_START | &quot;Charge Period Start&quot; |
| REV_REC_TRIGGER_DATE | &quot;Rev Rec Trigger Date&quot; |
| USE_NETSUITE_REV_REC_TEMPLATE | &quot;Use NetSuite Rev Rec Template&quot; |



