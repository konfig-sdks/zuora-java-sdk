

# ProductObjectNSFields

Container for Product fields provided by the [Zuora Connector for NetSuite](https://www.zuora.com/connect/app/?appId=265). 

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
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



