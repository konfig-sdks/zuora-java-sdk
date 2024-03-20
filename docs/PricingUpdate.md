

# PricingUpdate


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**chargeModelData** | [**ChargeModelDataOverride**](ChargeModelDataOverride.md) | Container for charge model configuration data.  **Note**: This field is only available if you have the High Water Mark, Pre-Rated Pricing, or Multi-Attribute Pricing charge models enabled. The High Water Mark and Pre-Rated Pricing charge models are available for customers with Enterprise and Nine editions by default. If you are a Growth customer, see [Zuora Editions](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/C_Zuora_Editions) for pricing information.  |  [optional] |
|**discount** | [**DiscountPricingUpdate**](DiscountPricingUpdate.md) | Pricing information about a discount charge.  |  [optional] |
|**recurringDelivery** | [**RecurringDeliveryPricingUpdate**](RecurringDeliveryPricingUpdate.md) | Pricing information about a recurring charge that uses the \&quot;delivery\&quot; charge model. This field is only available if you have the Delivery Pricing charge model enabled.  **Note**: The Delivery Pricing charge model is in the **Early Adopter** phase. We are actively soliciting feedback from a small set of early adopters before releasing it as generally available. To manage and access this feature through the self-service interface, see [Enable billing features by yourself](https://knowledgecenter.zuora.com/Zuora_Billing/Bill_your_customers/Billing_Settings/Manage_Features) in the Knowledge Center. You can check **Delivery Pricing** in **Billing Settings** &gt; **Enable Charge Types / Models**.  |  [optional] |
|**recurringFlatFee** | [**RecurringFlatFeePricingUpdate**](RecurringFlatFeePricingUpdate.md) | Pricing information about a recurring charge that uses the \&quot;flat fee\&quot; charge model. In this charge model, the charge has a fixed price.  |  [optional] |
|**recurringPerUnit** | [**RecurringPerUnitPricingUpdate**](RecurringPerUnitPricingUpdate.md) | Pricing information about a recurring charge that uses the \&quot;per unit\&quot; charge model. In this charge model, the charge has a fixed price per unit purchased.  |  [optional] |
|**recurringTiered** | [**RecurringTieredPricingUpdate**](RecurringTieredPricingUpdate.md) | Pricing information about a recurring charge that uses the \&quot;tiered pricing\&quot; charge model. In this charge model, the charge has cumulative pricing tiers that become effective as units are purchased.  |  [optional] |
|**recurringVolume** | [**RecurringVolumePricingUpdate**](RecurringVolumePricingUpdate.md) | Pricing information about a recurring charge that uses the \&quot;volume pricing\&quot; charge model. In this charge model, the charge has a variable price per unit, depending on how many units are purchased.  |  [optional] |
|**usageFlatFee** | [**UsageFlatFeePricingUpdate**](UsageFlatFeePricingUpdate.md) | Pricing information about a usage charge that uses the \&quot;flat fee\&quot; charge model. In this charge model, the charge has a fixed price.  |  [optional] |
|**usageOverage** | [**UsageOveragePricingUpdate**](UsageOveragePricingUpdate.md) | Pricing information about a usage charge that uses the \&quot;overage\&quot; charge model. In this charge model, the charge has an allowance of free units and a fixed price per additional unit consumed.  |  [optional] |
|**usagePerUnit** | [**UsagePerUnitPricingUpdate**](UsagePerUnitPricingUpdate.md) | Pricing information about a usage charge that uses the \&quot;per unit\&quot; charge model. In this charge model, the charge has a fixed price per unit consumed.  |  [optional] |
|**usageTiered** | [**UsageTieredPricingUpdate**](UsageTieredPricingUpdate.md) | Pricing information about a usage charge that uses the \&quot;tiered pricing\&quot; charge model. In this charge model, the charge has cumulative pricing tiers that become effective as units are consumed.  |  [optional] |
|**usageTieredWithOverage** | [**UsageTieredWithOveragePricingUpdate**](UsageTieredWithOveragePricingUpdate.md) | Pricing information about a usage charge that uses the \&quot;tiered with overage\&quot; charge model. In this charge model, the charge has cumulative pricing tiers that become effective as units are consumed. The charge also has a fixed price per unit consumed beyond the limit of the final tier.  |  [optional] |
|**usageVolume** | [**UsageVolumePricingUpdate**](UsageVolumePricingUpdate.md) | Pricing information about a usage charge that uses the \&quot;volume pricing\&quot; charge model. In this charge model, the charge has a variable price per unit, depending on how many units are consumed.  |  [optional] |



