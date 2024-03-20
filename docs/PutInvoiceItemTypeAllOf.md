

# PutInvoiceItemTypeAllOf


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**description** | **String** | The description of the invoice item.  |  [optional] |
|**accountingCode** | **String** | The accounting code associated with the invoice item.  |  [optional] |
|**adjustmentLiabilityAccountingCode** | **String** | The accounting code for adjustment liability.         **Note**: This field is only available if you have the Billing - Revenue Integration feature enabled.   |  [optional] |
|**adjustmentRevenueAccountingCode** | **String** | The accounting code for adjustment revenue.         **Note**: This field is only available if you have the Billing - Revenue Integration feature enabled.   |  [optional] |
|**amount** | **BigDecimal** | The amount of the invoice item.   - For tax-inclusive invoice items, the amount indicates the invoice item amount including tax.  - For tax-exclusive invoice items, the amount indicates the invoice item amount excluding tax.  |  [optional] |
|**chargeDate** | **OffsetDateTime** | The date when the invoice item is charged, in &#x60;yyyy-mm-dd hh:mm:ss&#x60; format.  |  [optional] |
|**chargeName** | **String** | The name of the charge associated with the invoice item.   This field is required if the &#x60;productRatePlanChargeId&#x60; field is not specified in the request.  |  [optional] |
|**contractAssetAccountingCode** | **String** | The accounting code for contract asset.         **Note**: This field is only available if you have the Billing - Revenue Integration feature enabled.   |  [optional] |
|**contractLiabilityAccountingCode** | **String** | The accounting code for contract liability.         **Note**: This field is only available if you have the Billing - Revenue Integration feature enabled.   |  [optional] |
|**contractRecognizedRevenueAccountingCode** | **String** | The accounting code for contract recognized revenue.         **Note**: This field is only available if you have the Billing - Revenue Integration feature enabled.   |  [optional] |
|**deferredRevenueAccountingCode** | **String** | The accounting code for the deferred revenue, such as Monthly Recurring Liability.  **Note:** This field is only available if you have Zuora Finance enabled.  |  [optional] |
|**discountItems** | [**List&lt;PutDiscountItemType&gt;**](PutDiscountItemType.md) | Container for discount items. The maximum number of discount items is 10.  |  [optional] |
|**excludeItemBillingFromRevenueAccounting** | **Boolean** | The flag to exclude the invoice item from revenue accounting.  **Note**: This field is only available if you have the Billing - Revenue Integration feature enabled.   |  [optional] |
|**id** | **String** | The unique ID of the invoice item.  |  [optional] |
|**itemType** | **String** | The type of the invoice item.  |  [optional] |
|**purchaseOrderNumber** | **String** | The purchase order number associated the invoice item.  |  [optional] |
|**quantity** | **BigDecimal** | The number of units for the invoice item.  |  [optional] |
|**recognizedRevenueAccountingCode** | **String** | The accounting code for the recognized revenue, such as Monthly Recurring Charges or Overage Charges.  **Note:** This field is only available if you have Zuora Finance enabled.  |  [optional] |
|**revRecCode** | **String** | The revenue recognition code.  |  [optional] |
|**revRecTriggerCondition** | [**RevRecTriggerConditionEnum**](#RevRecTriggerConditionEnum) | The date when revenue recognition is triggered.  |  [optional] |
|**revenueRecognitionRuleName** | **String** | The name of the revenue recognition rule governing the revenue schedule.  **Note:** This field is only available if you have Zuora Finance enabled.  |  [optional] |
|**serviceEndDate** | **LocalDate** | The service end date of the invoice item.  |  [optional] |
|**serviceStartDate** | **LocalDate** | The service start date of the invoice item.  |  [optional] |
|**sku** | **String** | The SKU of the invoice item. The SKU of the invoice item must be different from the SKU of any existing product.  |  [optional] |
|**taxCode** | **String** | The tax code identifies which tax rules and tax rates to apply to the invoice item.  **Note:**  - This field is only available if you have Taxation enabled. - If the values of both &#x60;taxCode&#x60; and &#x60;taxMode&#x60; fields are changed to &#x60;null&#x60; when updating a standalone invoice, the corresponding &#x60;invoiceItems&#x60; &gt; &#x60;taxItems&#x60; field and its nested fields specified in the creation request will be removed.  |  [optional] |
|**taxMode** | [**TaxModeEnum**](#TaxModeEnum) | The tax mode of the invoice item, indicating whether the amount of the invoice item includes tax.  **Note:**  - This field is only available if you have Taxation enabled. - If the values of both &#x60;taxCode&#x60; and &#x60;taxMode&#x60; fields are changed to &#x60;null&#x60; when updating a standalone invoice, the corresponding &#x60;invoiceItems&#x60; &gt; &#x60;taxItems&#x60; field and its nested fields specified in the creation request will be removed.  |  [optional] |
|**unbilledReceivablesAccountingCode** | **String** | The accounting code for unbilled receivables.         **Note**: This field is only available if you have the Billing - Revenue Integration feature enabled.   |  [optional] |
|**unitPrice** | **BigDecimal** | The per-unit price of the invoice item.  |  [optional] |
|**uom** | **String** | The unit of measure.  |  [optional] |



## Enum: RevRecTriggerConditionEnum

| Name | Value |
|---- | -----|
| CONTRACTEFFECTIVEDATE | &quot;ContractEffectiveDate&quot; |
| SERVICEACTIVATIONDATE | &quot;ServiceActivationDate&quot; |
| CUSTOMERACCEPTANCEDATE | &quot;CustomerAcceptanceDate&quot; |



## Enum: TaxModeEnum

| Name | Value |
|---- | -----|
| TAXINCLUSIVE | &quot;TaxInclusive&quot; |
| TAXEXCLUSIVE | &quot;TaxExclusive&quot; |



