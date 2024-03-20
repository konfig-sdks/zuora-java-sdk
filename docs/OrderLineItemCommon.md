

# OrderLineItemCommon


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**description** | **String** | The description of the Order Line Item (OLI).  You can update this field for a sales or return OLI only when the OLI is in the &#x60;Executing&#x60; state (when the &#x60;itemState&#x60; field is set as &#x60;Executing&#x60;).  |  [optional] |
|**UOM** | **String** | Specifies the units to measure usage.  You can update this field only for a sales OLI and only when the sales OLI is in the &#x60;Executing&#x60; state (when the &#x60;itemState&#x60; field is set as &#x60;Executing&#x60;).  |  [optional] |
|**accountingCode** | **String** | The accountingCode for the Order Line Item (OLI).  You can update this field only for a sales OLI and only when the sales OLI is in the &#x60;Executing&#x60; state (when the &#x60;itemState&#x60; field is set as &#x60;Executing&#x60;).  |  [optional] |
|**adjustmentLiabilityAccountingCode** | **String** | The accounting code on the Order Line Item object for customers using [Zuora Billing - Revenue Integration](https://knowledgecenter.zuora.com/Zuora_Revenue/Zuora_Billing_-_Revenue_Integration).  You can update this field only for a sales OLI and only when the sales OLI is in the &#x60;Executing&#x60; state (when the &#x60;itemState&#x60; field is set as &#x60;Executing&#x60;).  |  [optional] |
|**adjustmentRevenueAccountingCode** | **String** | The accounting code on the Order Line Item object for customers using [Zuora Billing - Revenue Integration](https://knowledgecenter.zuora.com/Zuora_Revenue/Zuora_Billing_-_Revenue_Integration).  You can update this field only for a sales OLI and only when the sales OLI is in the &#x60;Executing&#x60; state (when the &#x60;itemState&#x60; field is set as &#x60;Executing&#x60;).  |  [optional] |
|**amountPerUnit** | **Double** | The actual charged amount per unit for the Order Line Item (OLI).  You can update this field only for a sales OLI and only when the sales OLI is in the &#x60;Executing&#x60; state (when the &#x60;itemState&#x60; field is set as &#x60;Executing&#x60;).  |  [optional] |
|**billTargetDate** | **LocalDate** | The target date for the Order Line Item (OLI) to be picked up by bill run for generating billing documents.  To generate billing documents for an OLI, you must set this field and set the &#x60;itemState&#x60; field to &#x60;SentToBilling&#x60;.  You can update this field for a sales or return OLI only when the OLI is in the &#x60;Executing&#x60; state (when the &#x60;itemState&#x60; field is set as &#x60;Executing&#x60;).  |  [optional] |
|**billTo** | **String** | The ID of a contact that belongs to the billing account of the order line item. Use this field to assign an existing account as the bill-to contact of an order line item.  You can update this field only for a sales OLI and only when the sales OLI is in the &#x60;Executing&#x60; state (when the &#x60;itemState&#x60; field is set as &#x60;Executing&#x60;).  |  [optional] |
|**billingRule** | [**BillingRuleEnum**](#BillingRuleEnum) | The rule for billing of the Order Line Item (OLI).  You can update this field for a sales or return OLI only when it is in the &#x60;Executing&#x60; state (when the &#x60;itemState&#x60; field is set as &#x60;Executing&#x60;).  |  [optional] |
|**contractAssetAccountingCode** | **String** | The accounting code on the Order Line Item object for customers using [Zuora Billing - Revenue Integration](https://knowledgecenter.zuora.com/Zuora_Revenue/Zuora_Billing_-_Revenue_Integration).  You can update this field only for a sales OLI and only when the sales OLI is in the &#x60;Executing&#x60; state (when the &#x60;itemState&#x60; field is set as &#x60;Executing&#x60;).  |  [optional] |
|**contractLiabilityAccountingCode** | **String** | The accounting code on the Order Line Item object for customers using [Zuora Billing - Revenue Integration](https://knowledgecenter.zuora.com/Zuora_Revenue/Zuora_Billing_-_Revenue_Integration).  You can update this field only for a sales OLI and only when the sales OLI is in the &#x60;Executing&#x60; state (when the &#x60;itemState&#x60; field is set as &#x60;Executing&#x60;).  |  [optional] |
|**contractRecognizedRevenueAccountingCode** | **String** | The accounting code on the Order Line Item object for customers using [Zuora Billing - Revenue Integration](https://knowledgecenter.zuora.com/Zuora_Revenue/Zuora_Billing_-_Revenue_Integration).  You can update this field only for a sales OLI and only when the sales OLI is in the &#x60;Executing&#x60; state (when the &#x60;itemState&#x60; field is set as &#x60;Executing&#x60;).  |  [optional] |
|**customFields** | **Map&lt;String, Object&gt;** | Container for custom fields of an Order Line Item object.  |  [optional] |
|**deferredRevenueAccountingCode** | **String** | The deferred revenue accounting code for the Order Line Item (OLI).  You can update this field only for a sales OLI and only when the sales OLI is in the &#x60;Executing&#x60; state (when the &#x60;itemState&#x60; field is set as &#x60;Executing&#x60;).  |  [optional] |
|**excludeItemBillingFromRevenueAccounting** | **Boolean** | Indicates whether to exclude the related invoice items, invoice item adjustments, credit memo items, and debit memo items from revenue accounting.  **Note**: This field is only available if you have the Order to Revenue or Billing - Revenue Integration feature enabled.   |  [optional] |
|**excludeItemBookingFromRevenueAccounting** | **Boolean** | Indicates whether to exclude the related rate plan charges and order line items from revenue accounting.  **Note**: This field is only available if you have the Order to Revenue or Billing - Revenue Integration feature enabled.  |  [optional] |
|**invoiceGroupNumber** | **String** | The number of the invoice group associated with the order line item.  After enabling the Invoice Grouping feature, you can specify invoice group numbers to bill subscriptions and order line items based on specific criteria. For the same account, Zuora generates separate invoices for subscriptions and order line items, each identified by unique invoice group numbers. For more information, see [Invoice Grouping](https://knowledgecenter.zuora.com/Billing/Subscriptions/Invoice_Grouping).  **Note**:    - If you have the &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Bill_your_customers/Bill_customers_at_subscription_level/Flexible_Billing_Attributes\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Flexible Billing Attributes&lt;/a&gt; feature disabled, this field is unavailable in the request body and the value of this field is &#x60;null&#x60; in the response body.    - If you have the Flexible Billing Attributes feature enabled, and you do not specify this field in the request during subscription creation, the value of this field is automatically set to &#x60;null&#x60; in the response body.  |  [optional] |
|**inlineDiscountPerUnit** | **Double** | You can update this field only for a sales OLI and only when the sales OLI is in the &#x60;Executing&#x60; state (when the &#x60;itemState&#x60; field is set as &#x60;Executing&#x60;).  Use this field in accordance with the &#x60;inlineDiscountType&#x60; field, in the following manner: * If the &#x60;inlineDiscountType&#x60; field is set as &#x60;Percentage&#x60;, this field specifies the discount percentage for each unit of the order line item. For exmaple, if you specify &#x60;5&#x60; in this field, the discount percentage is 5%. * If the &#x60;inlineDiscountType&#x60; field is set as &#x60;FixedAmount&#x60;, this field specifies the discount amount on each unit of the order line item. For exmaple, if you specify &#x60;10&#x60; in this field, the discount amount on each unit of the order line item is 10.  Once you set the &#x60;inlineDiscountType&#x60;, &#x60;inlineDiscountPerUnit&#x60;, and &#x60;listPricePerUnit&#x60; fields, the system will automatically generate the &#x60;amountPerUnit&#x60; field. You shall not set the &#x60;amountPerUnit&#x60; field by yourself.  |  [optional] |
|**inlineDiscountType** | [**InlineDiscountTypeEnum**](#InlineDiscountTypeEnum) | You can update this field only for a sales OLI and only when the sales OLI is in the &#x60;Executing&#x60; state (when the &#x60;itemState&#x60; field is set as &#x60;Executing&#x60;).  Use this field to specify the inline discount type, which can be &#x60;Percentage&#x60;, &#x60;FixedAmount&#x60;, or &#x60;None&#x60;. The default value is &#x60;Percentage&#x60;.  Use this field together with the &#x60;inlineDiscountPerUnit&#x60; field to specify inline discounts for order line items. The inline discount is applied to the list price of an order line item.   Once you set the &#x60;inlineDiscountType&#x60;, &#x60;inlineDiscountPerUnit&#x60;, and &#x60;listPricePerUnit&#x60; fields, the system will automatically generate the &#x60;amountPerUnit&#x60; field. You shall not set the &#x60;amountPerUnit&#x60; field by yourself.  |  [optional] |
|**isAllocationEligible** | **Boolean** | This field is used to identify if the charge segment is allocation eligible in revenue recognition.  **Note**: This feature is in the **Early Adopter** phase. If you want to use the feature, submit a request at &lt;a href&#x3D;\&quot;https://support.zuora.com/\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Zuora Global Support&lt;/a&gt;, and we will evaluate whether the feature is suitable for your use cases.  |  [optional] |
|**isUnbilled** | **Boolean** | This field is used to dictate how to perform the accounting during revenue recognition.  **Note**: This feature is in the **Early Adopter** phase. If you want to use the feature, submit a request at &lt;a href&#x3D;\&quot;https://support.zuora.com/\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Zuora Global Support&lt;/a&gt;, and we will evaluate whether the feature is suitable for your use cases.  |  [optional] |
|**itemName** | **String** | The name of the Order Line Item (OLI).  You can update this field for a sales or return OLI only when the OLI is in the &#x60;Executing&#x60; state (when the &#x60;itemState&#x60; field is set as &#x60;Executing&#x60;).  |  [optional] |
|**itemNumber** | **String** | The number for the Order Line Item (OLI).  You can update this field for a sales or return OLI only when the OLI is in the &#x60;Executing&#x60; state (when the &#x60;itemState&#x60; field is set as &#x60;Executing&#x60;).  |  [optional] |
|**itemState** | [**ItemStateEnum**](#ItemStateEnum) | The state of the Order Line Item (OLI). See [State transitions for an order, order line item, and fulfillment](https://knowledgecenter.zuora.com/Billing/Subscriptions/Orders/Order_Line_Items/AB_Order_Line_Item_States_and_Order_States) for more information.  To generate invoice for an OLI, you must set this field to &#x60;SentToBilling&#x60; and set the &#x60;billTargetDate&#x60; field .  You can update this field for a sales or return OLI only when the OLI is in the &#x60;Executing&#x60; or &#39;Booked&#39; or &#x60;SentToBilling&#x60;state (when the &#x60;itemState&#x60; field is set as &#x60;Executing&#x60; or &#x60;SentToBilling&#x60;).  |  [optional] |
|**itemType** | [**ItemTypeEnum**](#ItemTypeEnum) | The type of the Order Line Item (OLI).   You can update this field only for a sales OLI and only when the sales OLI is in the &#x60;Executing&#x60; state (when the &#x60;itemState&#x60; field is set as &#x60;Executing&#x60;).  |  [optional] |
|**listPricePerUnit** | **Double** | The list price per unit for the Order Line Item (OLI).  You can update this field only for a sales OLI and only when the sales OLI is in the &#x60;Executing&#x60; state (when the &#x60;itemState&#x60; field is set as &#x60;Executing&#x60;).  |  [optional] |
|**ownerAccountNumber** | **String** | Use this field to assign an existing account as the owner of an order line item.  You can update this field only for a sales OLI and only when the sales OLI is in the &#x60;Executing&#x60; state (when the &#x60;itemState&#x60; field is set as &#x60;Executing&#x60;).  |  [optional] |
|**productCode** | **String** | The product code for the Order Line Item (OLI).  You can update this field only for a sales OLI and only when the sales OLI is in the &#x60;Executing&#x60; state (when the &#x60;itemState&#x60; field is set as &#x60;Executing&#x60;).  |  [optional] |
|**purchaseOrderNumber** | **String** | Used by customers to specify the Purchase Order Number provided by the buyer.  You can update this field only for a sales OLI and only when the sales OLI is in the &#x60;Executing&#x60; state (when the &#x60;itemState&#x60; field is set as &#x60;Executing&#x60;).  |  [optional] |
|**quantity** | **Double** | The quantity of units, such as the number of authors in a hosted wiki service.  You can update this field for a sales or return OLI only when the OLI in the &#x60;Executing&#x60; state (when the &#x60;itemState&#x60; field is set as &#x60;Executing&#x60;).  |  [optional] |
|**recognizedRevenueAccountingCode** | **String** | The recognized revenue accounting code for the Order Line Item (OLI).  You can update this field only for a sales OLI and only when the sales OLI is in the &#x60;Executing&#x60; state (when the &#x60;itemState&#x60; field is set as &#x60;Executing&#x60;).  |  [optional] |
|**relatedSubscriptionNumber** | **String** | Use this field to relate an order line item to an subscription. Specify this field to the subscription number of the subscription to relate.  You can update this field only for a sales OLI and only when the sales OLI is in the &#x60;Executing&#x60; state (when the &#x60;itemState&#x60; field is set as &#x60;Executing&#x60;).  |  [optional] |
|**revenueRecognitionRule** | **String** | The Revenue Recognition rule for the Order Line Item (OLI).  You can update this field only for a sales OLI and only when the sales OLI is in the &#x60;Executing&#x60; state (when the &#x60;itemState&#x60; field is set as &#x60;Executing&#x60;).  |  [optional] |
|**revenueRecognitionTiming** | [**RevenueRecognitionTimingEnum**](#RevenueRecognitionTimingEnum) | Specifies the type of revenue recognition timing.  Predefined options are listed as enum values in this API Reference. Other options might also be avaliable depending on the &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Enable_Order_to_Revenue/Configure_revenue_settings/Configure_revenue_recognition_policy\&quot; target&#x3D;\&quot;_blank\&quot;&gt;revenue recognition policy configuration&lt;/a&gt; in the Zuora Billing UI.  You can update this field only for a sales OLI and only when the sales OLI is in the &#x60;Executing&#x60; state (when the &#x60;itemState&#x60; field is set as &#x60;Executing&#x60;).  **Note**: This field is only available if you have the Order to Revenue feature enabled.   |  [optional] |
|**revenueAmortizationMethod** | [**RevenueAmortizationMethodEnum**](#RevenueAmortizationMethodEnum) | Specifies the type of revenue amortization method.  Predefined options are listed as enum values in this API Reference. Other options might also be avaliable depending on the &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Enable_Order_to_Revenue/Configure_revenue_settings/Configure_revenue_recognition_policy\&quot; target&#x3D;\&quot;_blank\&quot;&gt;revenue recognition policy configuration&lt;/a&gt; in the Zuora Billing UI.  You can update this field only for a sales OLI and only when the sales OLI is in the &#x60;Executing&#x60; state (when the &#x60;itemState&#x60; field is set as &#x60;Executing&#x60;).  **Note**: This field is only available if you have the Order to Revenue feature enabled.   |  [optional] |
|**sequenceSetId** | **String** | The ID of the sequence set associated with the orderLineItem.  |  [optional] |
|**soldTo** | **String** | Use this field to assign an existing account as the sold-to contact of an order line item, by the following rules:  * If the &#x60;ownerAccountNumber&#x60; field is set, then this field must be the ID of a contact that belongs to the owner account of the order line item.  * If the &#x60;ownerAccountNumber&#x60; field is not set, then this field must be the ID of a contact that belongs to the billing account of the order line item.  You can update this field only for a sales OLI and only when the sales OLI is in the &#x60;Executing&#x60; state (when the &#x60;itemState&#x60; field is set as &#x60;Executing&#x60;).  |  [optional] |
|**taxCode** | **String** | The tax code for the Order Line Item (OLI).  You can update this field only for a sales OLI and only when the sales OLI is in the &#x60;Executing&#x60; state (when the &#x60;itemState&#x60; field is set as &#x60;Executing&#x60;).  |  [optional] |
|**taxMode** | [**TaxModeEnum**](#TaxModeEnum) | The tax mode for the Order Line Item (OLI).  You can update this field only for a sales OLI and only when the sales OLI is in the &#x60;Executing&#x60; state (when the &#x60;itemState&#x60; field is set as &#x60;Executing&#x60;).  |  [optional] |
|**transactionEndDate** | **LocalDate** | The date a transaction is completed. The default value of this field is the transaction start date. Also, the value of this field should always equal or be later than the value of the &#x60;transactionStartDate&#x60; field.  You can update this field for a sales or return OLI only when the OLI is in the &#x60;Executing&#x60; state (when the &#x60;itemState&#x60; field is set as &#x60;Executing&#x60;).  |  [optional] |
|**transactionStartDate** | **LocalDate** | The date a transaction starts. The default value of this field is the order date.  You can update this field for a sales or return OLI only when the OLI is in the &#x60;Executing&#x60; state (when the &#x60;itemState&#x60; field is set as &#x60;Executing&#x60;).  |  [optional] |
|**unbilledReceivablesAccountingCode** | **String** | The accounting code on the Order Line Item object for customers using [Zuora Billing - Revenue Integration](https://knowledgecenter.zuora.com/Zuora_Revenue/Zuora_Billing_-_Revenue_Integration).  You can update this field only for a sales OLI and only when the sales OLI is in the &#x60;Executing&#x60; state (when the &#x60;itemState&#x60; field is set as &#x60;Executing&#x60;).  |  [optional] |



## Enum: BillingRuleEnum

| Name | Value |
|---- | -----|
| TRIGGERWITHOUTFULFILLMENT | &quot;TriggerWithoutFulfillment&quot; |
| TRIGGERASFULFILLMENTOCCURS | &quot;TriggerAsFulfillmentOccurs&quot; |



## Enum: InlineDiscountTypeEnum

| Name | Value |
|---- | -----|
| PERCENTAGE | &quot;Percentage&quot; |
| FIXEDAMOUNT | &quot;FixedAmount&quot; |
| NONE | &quot;None&quot; |



## Enum: ItemStateEnum

| Name | Value |
|---- | -----|
| EXECUTING | &quot;Executing&quot; |
| BOOKED | &quot;Booked&quot; |
| SENTTOBILLING | &quot;SentToBilling&quot; |
| COMPLETE | &quot;Complete&quot; |
| CANCELLED | &quot;Cancelled&quot; |



## Enum: ItemTypeEnum

| Name | Value |
|---- | -----|
| PRODUCT | &quot;Product&quot; |
| FEE | &quot;Fee&quot; |
| SERVICES | &quot;Services&quot; |



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



## Enum: TaxModeEnum

| Name | Value |
|---- | -----|
| TAXINCLUSIVE | &quot;TaxInclusive&quot; |
| TAXEXCLUSIVE | &quot;TaxExclusive&quot; |



