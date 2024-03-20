

# ProxyGetProductRatePlanAllOf


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**activeCurrencies** | **List&lt;String&gt;** | A list of 3-letter currency codes representing active currencies for the product rate plan.   This field cannot be queried in conjunction with any other fields except &#x60;id&#x60; at the same time.   |  [optional] |
|**createdById** | **String** | The automatically generated ID of the Zuora user who created the &#x60;ProductRatePlan&#x60; object.  |  [optional] |
|**createdDate** | **OffsetDateTime** | The date when the &#x60;ProductRatePlan&#x60; object was created.  |  [optional] |
|**description** | **String** | A description of the product rate plan.  |  [optional] |
|**effectiveEndDate** | **LocalDate** | The date when the product rate plan expires and can&#39;t be subscribed to, in &#x60;yyyy-mm-dd&#x60; format.  |  [optional] |
|**effectiveStartDate** | **LocalDate** | The date when the product rate plan becomes available and can be subscribed to, in &#x60;yyyy-mm-dd&#x60; format.  |  [optional] |
|**grade** | **Double** | The grade that is assigned for the product rate plan.  **Notes**:    - To use this field, you must set the &#x60;X-Zuora-WSDL-Version&#x60; request header to &#x60;116&#x60; or later. Otherwise, an error occurs.   - This field is in the **Early Adopter** phase. We are actively soliciting feedback from a small set of early adopters before releasing it as generally available. If you want to join this early adopter program, submit a request at [Zuora Global Support](http://support.zuora.com/).  |  [optional] |
|**id** | **String** | Object identifier. |  [optional] |
|**name** | **String** | The name of the product rate plan. The name doesn&#39;t have to be unique in a Product Catalog, but the name has to be unique within a product.  |  [optional] |
|**productId** | **String** | The ID of the product that contains the product rate plan.  |  [optional] |
|**updatedById** | **String** | The automatically generated ID of the last user to update the object.  |  [optional] |
|**updatedDate** | **OffsetDateTime** | The date when the object was last updated.  |  [optional] |



