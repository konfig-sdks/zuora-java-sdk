

# ProxyCreateProductRatePlan


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**activeCurrencies** | **List&lt;String&gt;** | A list of 3-letter currency codes representing active currencies for the product rate plan. Use a comma to separate each currency code.  When creating a product rate plan, you can use this field to specify default currency and at most four other active currencies.  |  [optional] |
|**description** | **String** | A description of the product rate plan.  |  [optional] |
|**effectiveEndDate** | **LocalDate** | The date when the product rate plan expires and can&#39;t be subscribed to, in &#x60;yyyy-mm-dd&#x60; format.  |  [optional] |
|**effectiveStartDate** | **LocalDate** | The date when the product rate plan becomes available and can be subscribed to, in &#x60;yyyy-mm-dd&#x60; format.  |  [optional] |
|**grade** | **Double** | The grade that is assigned for the product rate plan. The value of this field must be a positive integer. The greater the value, the higher the grade.  A product rate plan to be added to a Grading catalog group must have one grade. You can specify a grade for a product rate plan in this request or update the product rate plan individually.  **Notes**:    - To use this field, you must set the &#x60;X-Zuora-WSDL-Version&#x60; request header to &#x60;116&#x60; or later. Otherwise, an error occurs.   - This field is in the **Early Adopter** phase. We are actively soliciting feedback from a small set of early adopters before releasing it as generally available. If you want to join this early adopter program, submit a request at [Zuora Global Support](http://support.zuora.com/).  |  [optional] |
|**name** | **String** | The name of the product rate plan. The name doesn&#39;t have to be unique in a Product Catalog, but the name has to be unique within a product.  |  |
|**productId** | **String** | The ID of the product that contains the product rate plan.  |  |
|**productRatePlanNumber** | **String** | The natural key of the product rate plan.  **Possible values**:    - leave null for automatically generated string   - an alphanumeric string of 100 characters or fewer  **Note**: This field is only available if you set the &#x60;X-Zuora-WSDL-Version&#x60; request header to &#x60;133&#x60; or later.  |  [optional] |
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



