

# GETProductType


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**tags** | **String** |  |  [optional] |
|**description** | **String** | Optional product description.  |  [optional] |
|**category** | **String** | Category of the product. Used by Zuora Quotes Guided Product Selector.  Possible values are:   - Base Products   - Add On Services   - Miscellaneous Products  |  [optional] |
|**effectiveEndDate** | **LocalDate** | The date when the product expires and cannot be subscribed to anymore, as &#x60;yyyy-mm-dd&#x60;.  |  [optional] |
|**effectiveStartDate** | **LocalDate** | The date when the product becomes available and can be subscribed to, as &#x60;yyyy-mm-dd&#x60;.  |  [optional] |
|**id** | **String** | Product ID.  |  [optional] |
|**name** | **String** | Product name, up to 100 characters.  |  [optional] |
|**organizationLabels** | [**List&lt;GETProductTypeAllOfOrganizationLabels&gt;**](GETProductTypeAllOfOrganizationLabels.md) | The organization(s) that the object belongs to.   Note: This field is available only when the Multi-Org feature is enabled.              |  [optional] |
|**productFeatures** | [**List&lt;GetProductFeatureType&gt;**](GetProductFeatureType.md) | Container for one or more product features. Only available when the following settings are enabled: - The Entitlements feature in your tenant - The Enable Feature Specification in Product and Subscriptions setting in Settings &gt; Billing  |  [optional] |
|**productNumber** | **String** | The natural key of the product.  |  [optional] |
|**productRatePlans** | **String** | URL to retrieve information about all product rate plans of a specific product. For example, &#x60;/v1/rateplan/40289f466463d683016463ef8b7301a0/productRatePlan&#x60;. If you want to view the product rate plan details, call [List all product rate plans of a product](https://developer.zuora.com/api-references/api/operation/GET_ProductRatePlans) with the returned URL.  This field is in Zuora REST API version control. If you set the &#x60;zuora-version&#x60; request header to &#x60;230.0&#x60; or later [available versions](https://developer.zuora.com/api-references/api/overview/#section/API-Versions/Minor-Version), the value of this field is a URL. Zuora recommends that you use the latest behavior to retrieve product information.  If you do not set the &#x60;zuora-version&#x60; request header or you set this header to &#x60;229.0&#x60; or earlier [available versions](https://developer.zuora.com/api-references/api/overview/#section/API-Versions/Minor-Version), the value of this field is an array of product rate plan details.  For more information about the array, see the response body of [List all product rate plans of a product](https://developer.zuora.com/api-references/api/operation/GET_ProductRatePlans). **Note**: The array contains a maximum of 300 product rate plans. Additionally, across all product rate plans, at most 300 product rate plan charges are returned.  |  [optional] |
|**sku** | **String** | Unique product SKU, up to 50 characters.  |  [optional] |
|**integrationIdNS** | **String** | ID of the corresponding object in NetSuite. Only available if you have installed the [Zuora Connector for NetSuite](https://www.zuora.com/connect/app/?appId&#x3D;265).  |  [optional] |
|**integrationStatusNS** | **String** | Status of the product&#39;s synchronization with NetSuite. Only available if you have installed the [Zuora Connector for NetSuite](https://www.zuora.com/connect/app/?appId&#x3D;265).  |  [optional] |
|**itemTypeNS** | [**ItemTypeNSEnum**](#ItemTypeNSEnum) | Type of item that is created in NetSuite for the product. Only available if you have installed the [Zuora Connector for NetSuite](https://www.zuora.com/connect/app/?appId&#x3D;265).  |  [optional] |
|**syncDateNS** | **String** | Date when the product was synchronized with NetSuite. Only available if you have installed the [Zuora Connector for NetSuite](https://www.zuora.com/connect/app/?appId&#x3D;265).  |  [optional] |



## Enum: ItemTypeNSEnum

| Name | Value |
|---- | -----|
| INVENTORY | &quot;Inventory&quot; |
| NON_INVENTORY | &quot;Non Inventory&quot; |
| SERVICE | &quot;Service&quot; |



