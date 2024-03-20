

# UsageOveragePricingOverrideAllOf


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**includedUnits** | **Double** | Number of free units that may be consumed.  |  [optional] |
|**numberOfPeriods** | **Integer** | Number of periods that Zuora considers when calculating overage charges with overage smoothing.  |  [optional] |
|**overagePrice** | **Double** | Price per overage unit consumed.  |  [optional] |
|**overageUnusedUnitsCreditOption** | [**OverageUnusedUnitsCreditOptionEnum**](#OverageUnusedUnitsCreditOptionEnum) | Specifies whether to credit the customer for unused units.  If the value of this field is &#x60;CreditBySpecificRate&#x60;, use the &#x60;unusedUnitsCreditRates&#x60; field to specify the rate at which to credit the customer for unused units.  |  [optional] |
|**unusedUnitsCreditRates** | **Double** | Per-unit rate at which to credit the customer for unused units. Only applicable if the value of the &#x60;overageUnusedUnitsCreditOption&#x60; field is &#x60;CreditBySpecificRate&#x60;.  |  [optional] |



## Enum: OverageUnusedUnitsCreditOptionEnum

| Name | Value |
|---- | -----|
| NOCREDIT | &quot;NoCredit&quot; |
| CREDITBYSPECIFICRATE | &quot;CreditBySpecificRate&quot; |



