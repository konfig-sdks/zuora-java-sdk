

# ChargeModelDataOverride

Container for charge model configuration data.  **Note**: This field is only available if you have the High Water Mark, Pre-Rated Pricing, or Multi-Attribute Pricing charge models enabled. The High Water Mark and Pre-Rated Pricing charge models are available for customers with Enterprise and Nine editions by default. If you are a Growth customer, see [Zuora Editions](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/C_Zuora_Editions) for pricing information. 

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**chargeModelConfiguration** | [**ChargeModelDataOverrideChargeModelConfiguration**](ChargeModelDataOverrideChargeModelConfiguration.md) |  |  [optional] |
|**quantity** | **Double** | Number of units purchased. This field is used if the Multi-Attribute Pricing formula uses the &#x60;quantity()&#x60; function.  This field is only available for one-time and recurring charges that use the Multi-Attribute Pricing charge model.  |  [optional] |
|**tiers** | [**List&lt;ChargeTier&gt;**](ChargeTier.md) | List of cumulative pricing tiers in the charge.  **Note**: When you override the tiers of a usage-based charge using High Water Mark Pricing charge model, you have to provide all of the tiers, including the ones you do not want to change. The new tiers will completely override the previous ones. The High Water Mark Pricing charge models are available for customers with Enterprise and Nine editions by default. If you are a Growth customer, see [Zuora Editions](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/C_Zuora_Editions) for pricing information.  |  [optional] |



