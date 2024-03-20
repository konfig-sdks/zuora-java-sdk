

# ProxyModifyProductRatePlanAllOf


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**activeCurrencies** | **List&lt;String&gt;** | A list of 3-letter currency codes representing active currencies for the product rate plan. Use a comma to separate each currency code.  If the request body contains this field, the value of this field must contain the desired list of active currencies. The new list can never have more than four differences from the existing list.  This field cannot be used to modify the status of more than four currencies in a single request. For example, in a single request, you can only activate four currencies, or deactivate four currencies, or activate two and deactivate two. Making more than four changes to currencies always requires more than one call.  When specifying this field in the update request, you must provide the full list of active currencies you want, not just incremental changes. For each active currency update, provide the following currencies in the list:  Current active currencies + at most four changes (additions or deletions)  |  [optional] |
|**description** | **String** | A description of the product rate plan.  |  [optional] |
|**effectiveEndDate** | **LocalDate** | The date when the product rate plan expires and can&#39;t be subscribed to, in &#x60;yyyy-mm-dd&#x60; format.  |  [optional] |
|**effectiveStartDate** | **LocalDate** | The date when the product rate plan becomes available and can be subscribed to, in &#x60;yyyy-mm-dd&#x60; format.  |  [optional] |
|**grade** | **Double** | The grade that is assigned for the product rate plan. The value of this field must be a positive integer. The greater the value, the higher the grade.  A product rate plan to be added to a Grading catalog group must have one grade. You can specify a grade for a product rate plan in this request or update the product rate plan individually.  **Notes**:    - To use this field, you must set the &#x60;X-Zuora-WSDL-Version&#x60; request header to &#x60;116&#x60; or later. Otherwise, an error occurs.   - This field is in the **Early Adopter** phase. We are actively soliciting feedback from a small set of early adopters before releasing it as generally available. If you want to join this early adopter program, submit a request at [Zuora Global Support](http://support.zuora.com/).  |  [optional] |
|**name** | **String** | The name of the product rate plan. The name doesn&#39;t have to be unique in a Product Catalog, but the name has to be unique within a product.  |  [optional] |
|**productId** | **String** | The ID of the product that contains the product rate plan.  |  [optional] |
|**productRatePlanNumber** | **String** | The natural key of the product rate plan.   For existing Product Rate Plan objects that are created before this field is introduced, this field will be null. Use this field to specify a value for only these objects. Zuora also provides a tool to help you automatically backfill this field with tenant ID for your existing product catalog. If you want to use this backfill tool, contact [Zuora Global Support](https://support.zuora.com/).  **Note**: This field is only available if you set the &#x60;X-Zuora-WSDL-Version&#x60; request header to &#x60;133&#x60; or later.  |  [optional] |



