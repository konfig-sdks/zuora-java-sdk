

# ProxyGetProductRatePlanChargeTier


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**createdById** | **String** | The ID of the Zuora user who created the ProductRatePlanChargeTier object.  |  [optional] |
|**createdDate** | **OffsetDateTime** | The date when the ProductRatePlanChargeTier object was created.  |  [optional] |
|**currency** | **String** | The valid code corresponding to the currency for the tier&#39;s price.  |  [optional] |
|**endingUnit** | **Double** | The end number of a range of units for the tier.  **Character limit**: 16  **Values**: any positive decimal value  |  [optional] |
|**id** | **String** | Object identifier. |  [optional] |
|**price** | **Double** | The price of the tier if the charge is a flat fee, or the price of each unit in the tier if the charge model is tiered pricing.  **Character limit**: 16  **Values**: a valid currency value  |  [optional] |
|**priceFormat** | **String** | Indicates if pricing is a flat fee or is per unit. This field is for tiered and volume pricing models only.  **Values**: &#x60;FlatFee&#x60;, &#x60;PerUnit&#x60;  **Note:** The values &#x60;Flat Fee&#x60; and &#x60;Per Unit&#x60; (with spaces) is valid for create or update calls.  |  [optional] |
|**startingUnit** | **Double** | The starting number of a range of units for the tier.  **Character limit**: 16  **Values**: any positive decimal value  |  [optional] |
|**tier** | **Integer** | A unique number that identifies the tier that the price applies to.  **Character limit**: 20  **Values**: automatically generated  |  [optional] |
|**updatedById** | **String** | The ID of the user who last updated the product rate plan charge tier.  |  [optional] |
|**updatedDate** | **OffsetDateTime** | The date when the product rate plan charge tier was last updated.  |  [optional] |



