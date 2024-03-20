

# PutDiscountItemType


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**description** | **String** | The description of the discount item.  |  [optional] |
|**accountingCode** | **String** | The accounting code associated with the discount item.  |  [optional] |
|**adjustmentLiabilityAccountingCode** | **String** | The accounting code for adjustment liability. **Note**: This field is only available if you have the Billing - Revenue Integration feature enabled.  |  [optional] |
|**adjustmentRevenueAccountingCode** | **String** | The accounting code for adjustment revenue. **Note**: This field is only available if you have the Billing - Revenue Integration feature enabled.  |  [optional] |
|**amount** | **BigDecimal** | The amount of the discount item. - Should be a negative number. For example, &#x60;-10&#x60;. - Always a fixed amount no matter whether the discount charge associated with the discount item uses the [fixed-amount model or percentage model](https://knowledgecenter.zuora.com/Billing/Subscriptions/Product_Catalog/B_Charge_Models/B_Discount_Charge_Models#Fixed_amount_model_and_percentage_model). - For tax-exclusive discount items, this amount indicates the discount item amount excluding tax. - For tax-inclusive discount items, this amount indicates the discount item amount including tax.  |  |
|**bookingReference** | **String** | The booking reference of the discount item.  |  [optional] |
|**chargeDate** | **OffsetDateTime** | The date when the discount item is charged, in &#x60;yyyy-mm-dd hh:mm:ss&#x60; format.  |  [optional] |
|**chargeName** | **String** | The name of the charge associated with the discount item. This field is required if the &#x60;productRatePlanChargeId&#x60; field is not specified in the request.  |  [optional] |
|**contractAssetAccountingCode** | **String** | The accounting code for contract asset. **Note**: This field is only available if you have the Billing - Revenue Integration feature enabled.  |  [optional] |
|**contractLiabilityAccountingCode** | **String** | The accounting code for contract liability. **Note**: This field is only available if you have the Billing - Revenue Integration feature enabled.  |  [optional] |
|**contractRecognizedRevenueAccountingCode** | **String** | The accounting code for contract recognized revenue. **Note**: This field is only available if you have the Billing - Revenue Integration feature enabled.  |  [optional] |
|**deferredRevenueAccountingCode** | **String** | The accounting code for the deferred revenue, such as Monthly Recurring Liability. **Note:** This field is only available if you have Zuora Finance enabled.  |  [optional] |
|**id** | **String** | The unique ID of the discount item.  |  [optional] |
|**itemType** | **String** | The type of the discount item.  |  [optional] |
|**purchaseOrderNumber** | **String** | The purchase order number associated with the discount item.  |  [optional] |
|**recognizedRevenueAccountingCode** | **String** | The accounting code for the recognized revenue, such as Monthly Recurring Charges or Overage Charges. **Note:** This field is only available if you have Zuora Finance enabled.  |  [optional] |
|**revRecCode** | **String** | The revenue recognition code.  |  [optional] |
|**revRecTriggerCondition** | [**RevRecTriggerConditionEnum**](#RevRecTriggerConditionEnum) | The date when revenue recognition is triggered.  |  [optional] |
|**revenueRecognitionRuleName** | **String** | The name of the revenue recognition rule governing the revenue schedule. **Note:** This field is only available if you have Zuora Finance enabled.  |  [optional] |
|**sku** | **String** | The SKU of the invoice item. The SKU of the discount item must be different from the SKU of any existing product.  |  [optional] |
|**unbilledReceivablesAccountingCode** | **String** | The accounting code for unbilled receivables. **Note**: This field is only available if you have the Billing - Revenue Integration feature enabled.  |  [optional] |
|**unitPrice** | **BigDecimal** | The per-unit price of the discount item. If the discount charge associated with the discount item uses the percentage model, the unit price will display as a percentage amount in PDF. For example: if unit price is 5.00, it will display as 5.00% in PDF.  |  [optional] |
|**integrationIdNS** | **String** | ID of the corresponding object in NetSuite. Only available if you have installed the [Zuora Connector for NetSuite](https://www.zuora.com/connect/app/?appId&#x3D;265).  |  [optional] |
|**integrationStatusNS** | **String** | Status of the invoice item&#39;s synchronization with NetSuite. Only available if you have installed the [Zuora Connector for NetSuite](https://www.zuora.com/connect/app/?appId&#x3D;265).  |  [optional] |
|**syncDateNS** | **String** | Date when the invoice item was synchronized with NetSuite. Only available if you have installed the [Zuora Connector for NetSuite](https://www.zuora.com/connect/app/?appId&#x3D;265).  |  [optional] |



## Enum: RevRecTriggerConditionEnum

| Name | Value |
|---- | -----|
| CONTRACTEFFECTIVEDATE | &quot;ContractEffectiveDate&quot; |
| SERVICEACTIVATIONDATE | &quot;ServiceActivationDate&quot; |
| CUSTOMERACCEPTANCEDATE | &quot;CustomerAcceptanceDate&quot; |



