

# GETProductRatePlanType


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**description** | **String** | Rate plan description.  |  [optional] |
|**effectiveEndDate** | **LocalDate** | Final date the rate plan is active, as &#x60;yyyy-mm-dd&#x60;. After this date, the rate plan status is &#x60;Expired&#x60;.  |  [optional] |
|**effectiveStartDate** | **LocalDate** | First date the rate plan is active (i.e., available to be subscribed to), as &#x60;yyyy-mm-dd&#x60;.  Before this date, the status is &#x60;NotStarted&#x60;.  |  [optional] |
|**grade** | **Double** | The grade of the product rate plan.  **Note**: This field is in the **Early Adopter** phase. We are actively soliciting feedback from a small set of early adopters before releasing it as generally available. If you want to join this early adopter program, submit a request at [Zuora Global Support](http://support.zuora.com/).  |  [optional] |
|**id** | **String** | Unique product rate-plan ID.  |  [optional] |
|**name** | **String** | Name of the product rate-plan charge. (Not required to be unique.)  |  [optional] |
|**productRatePlanCharges** | [**List&lt;GETProductRatePlanChargeType&gt;**](GETProductRatePlanChargeType.md) | Field attributes describing the product rate plan charges:  |  [optional] |
|**productRatePlanNumber** | **String** | The natural key of the product rate plan.    |  [optional] |
|**status** | [**StatusEnum**](#StatusEnum) | The status of the product rate plan.  |  [optional] |
|**billingPeriodNS** | [**BillingPeriodNSEnum**](#BillingPeriodNSEnum) | Billing period associated with the corresponding item in NetSuite. Only available if you have installed the [Zuora Connector for NetSuite](https://www.zuora.com/connect/app/?appId&#x3D;265).  |  [optional] |
|**classNS** | **String** | Class associated with the corresponding item in NetSuite. Only available if you have installed the [Zuora Connector for NetSuite](https://www.zuora.com/connect/app/?appId&#x3D;265).  |  [optional] |
|**departmentNS** | **String** | Department associated with the corresponding item in NetSuite. Only available if you have installed the [Zuora Connector for NetSuite](https://www.zuora.com/connect/app/?appId&#x3D;265).  |  [optional] |
|**includeChildrenNS** | [**IncludeChildrenNSEnum**](#IncludeChildrenNSEnum) | Specifies whether the corresponding item in NetSuite is visible under child subsidiaries. Only available if you have installed the [Zuora Connector for NetSuite](https://www.zuora.com/connect/app/?appId&#x3D;265).  |  [optional] |
|**integrationIdNS** | **String** | ID of the corresponding object in NetSuite. Only available if you have installed the [Zuora Connector for NetSuite](https://www.zuora.com/connect/app/?appId&#x3D;265).  |  [optional] |
|**integrationStatusNS** | **String** | Status of the product rate plan&#39;s synchronization with NetSuite. Only available if you have installed the [Zuora Connector for NetSuite](https://www.zuora.com/connect/app/?appId&#x3D;265).  |  [optional] |
|**itemTypeNS** | [**ItemTypeNSEnum**](#ItemTypeNSEnum) | Type of item that is created in NetSuite for the product rate plan. Only available if you have installed the [Zuora Connector for NetSuite](https://www.zuora.com/connect/app/?appId&#x3D;265).  |  [optional] |
|**locationNS** | **String** | Location associated with the corresponding item in NetSuite. Only available if you have installed the [Zuora Connector for NetSuite](https://www.zuora.com/connect/app/?appId&#x3D;265).  |  [optional] |
|**multiCurrencyPriceNS** | **String** | Multi-currency price associated with the corresponding item in NetSuite. Only available if you have installed the [Zuora Connector for NetSuite](https://www.zuora.com/connect/app/?appId&#x3D;265).  |  [optional] |
|**priceNS** | **String** | Price associated with the corresponding item in NetSuite. Only available if you have installed the [Zuora Connector for NetSuite](https://www.zuora.com/connect/app/?appId&#x3D;265).  |  [optional] |
|**subsidiaryNS** | **String** | Subsidiary associated with the corresponding item in NetSuite. Only available if you have installed the [Zuora Connector for NetSuite](https://www.zuora.com/connect/app/?appId&#x3D;265).  |  [optional] |
|**syncDateNS** | **String** | Date when the product rate plan was synchronized with NetSuite. Only available if you have installed the [Zuora Connector for NetSuite](https://www.zuora.com/connect/app/?appId&#x3D;265).  |  [optional] |



## Enum: StatusEnum

| Name | Value |
|---- | -----|
| ACTIVE | &quot;Active&quot; |
| EXPIRED | &quot;Expired&quot; |
| NOTSTARTED | &quot;NotStarted&quot; |



## Enum: BillingPeriodNSEnum

| Name | Value |
|---- | -----|
| MONTHLY | &quot;Monthly&quot; |
| QUARTERLY | &quot;Quarterly&quot; |
| ANNUAL | &quot;Annual&quot; |
| SEMI_ANNUAL | &quot;Semi-Annual&quot; |



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



