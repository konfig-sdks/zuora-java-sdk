

# ProxyModifyProductAllOf


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**allowFeatureChanges** | **Boolean** | Controls whether to allow your users to add or remove features while creating or amending a subscription.  **Values**: true, false (default)  |  [optional] |
|**category** | **String** | Category of the product. Used by Zuora Quotes Guided Product Selector.  **Values**:   - Base Products   - Add On Services   - Miscellaneous Products  |  [optional] |
|**description** | **String** | A description of the product.   |  [optional] |
|**effectiveEndDate** | **LocalDate** | The date when the product expires and can&#39;t be subscribed to anymore, in &#x60;yyyy-mm-dd&#x60; format.  |  [optional] |
|**effectiveStartDate** | **LocalDate** | The date when the product becomes available and can be subscribed to, in &#x60;yyyy-mm-dd&#x60; format.  |  [optional] |
|**name** | **String** | The name of the product. This information is displayed in the product catalog pages in the web-based UI.  |  [optional] |
|**productNumber** | **String** | The natural key of the product.   For existing Product objects that are created before this field is introduced, this field will be null. Use this field to specify a value for only these objects. Zuora also provides a tool to help you automatically backfill this field with tenant ID for your existing product catalog. If you want to use this backfill tool, contact [Zuora Global Support](https://support.zuora.com/).  **Note**: This field is only available if you set the &#x60;X-Zuora-WSDL-Version&#x60; request header to &#x60;133&#x60; or later.  |  [optional] |
|**SKU** | **String** | The unique SKU for the product.  |  [optional] |



