

# ProxyCreateProductAllOf


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



