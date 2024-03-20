

# OrderActionRatePlanPricingUpdate


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**chargeModelData** | [**OrderActionRatePlanChargeModelDataOverride**](OrderActionRatePlanChargeModelDataOverride.md) | Container for charge model configuration data.  |  [optional] |
|**discount** | [**OrderActionRatePlanDiscountPricingUpdate**](OrderActionRatePlanDiscountPricingUpdate.md) | Pricing information about a discount charge.  |  [optional] |
|**recurringDelivery** | [**OrderActionRatePlanRecurringDeliveryPricingUpdate**](OrderActionRatePlanRecurringDeliveryPricingUpdate.md) | Pricing information about a recurring charge that uses the Delivery Pricing charge model. In this charge model, the charge has a fixed price. This field is only available if you have the Delivery Pricing charge model enabled.  **Note**: The Delivery Pricing charge model is in the **Early Adopter** phase. We are actively soliciting feedback from a small set of early adopters before releasing it as generally available. If you want to join this early adopter program, submit a request at &lt;a href&#x3D;\&quot;http://support.zuora.com/\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Zuora Global Support&lt;/a&gt;.  |  [optional] |
|**recurringFlatFee** | [**OrderActionRatePlanRecurringFlatFeePricingUpdate**](OrderActionRatePlanRecurringFlatFeePricingUpdate.md) | Pricing information about a recurring charge that uses the \&quot;flat fee\&quot; charge model. In this charge model, the charge has a fixed price.  |  [optional] |
|**recurringPerUnit** | [**OrderActionRatePlanRecurringPerUnitPricingUpdate**](OrderActionRatePlanRecurringPerUnitPricingUpdate.md) | Pricing information about a recurring charge that uses the \&quot;per unit\&quot; charge model. In this charge model, the charge has a fixed price per unit purchased.  |  [optional] |
|**recurringTiered** | [**OrderActionRatePlanRecurringTieredPricingUpdate**](OrderActionRatePlanRecurringTieredPricingUpdate.md) | Pricing information about a recurring charge that uses the \&quot;tiered pricing\&quot; charge model. In this charge model, the charge has cumulative pricing tiers that become effective as units are purchased.  |  [optional] |
|**recurringVolume** | [**OrderActionRatePlanRecurringVolumePricingUpdate**](OrderActionRatePlanRecurringVolumePricingUpdate.md) | Pricing information about a recurring charge that uses the \&quot;volume pricing\&quot; charge model. In this charge model, the charge has a variable price per unit, depending on how many units are purchased.  |  [optional] |
|**usageFlatFee** | [**OrderActionRatePlanUsageFlatFeePricingUpdate**](OrderActionRatePlanUsageFlatFeePricingUpdate.md) | Pricing information about a usage charge that uses the \&quot;flat fee\&quot; charge model. In this charge model, the charge has a fixed price.  |  [optional] |
|**usageOverage** | [**OrderActionRatePlanUsageOveragePricingUpdate**](OrderActionRatePlanUsageOveragePricingUpdate.md) | Pricing information about a usage charge that uses the \&quot;overage\&quot; charge model. In this charge model, the charge has an allowance of free units and a fixed price per additional unit consumed.  |  [optional] |
|**usagePerUnit** | [**OrderActionRatePlanUsagePerUnitPricingUpdate**](OrderActionRatePlanUsagePerUnitPricingUpdate.md) | Pricing information about a usage charge that uses the \&quot;per unit\&quot; charge model. In this charge model, the charge has a fixed price per unit consumed.  |  [optional] |
|**usageTiered** | [**OrderActionRatePlanUsageTieredPricingUpdate**](OrderActionRatePlanUsageTieredPricingUpdate.md) | Pricing information about a usage charge that uses the \&quot;tiered pricing\&quot; charge model. In this charge model, the charge has cumulative pricing tiers that become effective as units are consumed.  |  [optional] |
|**usageTieredWithOverage** | [**OrderActionRatePlanUsageTieredWithOveragePricingUpdate**](OrderActionRatePlanUsageTieredWithOveragePricingUpdate.md) | Pricing information about a usage charge that uses the \&quot;tiered with overage\&quot; charge model. In this charge model, the charge has cumulative pricing tiers that become effective as units are consumed. The charge also has a fixed price per unit consumed beyond the limit of the final tier.  |  [optional] |
|**usageVolume** | [**OrderActionRatePlanUsageVolumePricingUpdate**](OrderActionRatePlanUsageVolumePricingUpdate.md) | Pricing information about a usage charge that uses the \&quot;volume pricing\&quot; charge model. In this charge model, the charge has a variable price per unit, depending on how many units are consumed.  |  [optional] |



