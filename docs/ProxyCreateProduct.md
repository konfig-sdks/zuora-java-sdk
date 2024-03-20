

# ProxyCreateProduct


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**allowFeatureChanges** | **Boolean** | Controls whether to allow your users to add or remove features while creating or amending a subscription.  **Values**: true, false (default)  |  [optional] |
|**category** | **String** | Category of the product. Used by Zuora Quotes Guided Product Selector.  **Values**:    - Base Products   - Add On Services   - Miscellaneous Products  |  [optional] |
|**description** | **String** | A description of the product.   |  [optional] |
|**effectiveEndDate** | **LocalDate** | The date when the product expires and can&#39;t be subscribed to anymore, in &#x60;yyyy-mm-dd&#x60; format.  |  |
|**effectiveStartDate** | **LocalDate** | The date when the product becomes available and can be subscribed to, in &#x60;yyyy-mm-dd&#x60; format.  |  |
|**name** | **String** | The name of the product. This information is displayed in the product catalog pages in the web-based UI.  |  |
|**productNumber** | **String** | The natural key of the product.  **Values**:    - leave null for automatically generated string   - an alphanumeric string of 100 characters or fewer  **Note**: This field is only available if you set the &#x60;X-Zuora-WSDL-Version&#x60; request header to &#x60;133&#x60; or later.  |  [optional] |
|**SKU** | **String** | The unique SKU for the product.  **Values**:    - leave null for automatically generated string   - an alphanumeric string of 50 characters or fewer  |  [optional] |
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



