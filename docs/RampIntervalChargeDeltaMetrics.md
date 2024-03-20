

# RampIntervalChargeDeltaMetrics


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**chargeNumber** | **String** | The number of the rate plan charge. |  [optional] |
|**deltaDiscountTcb** | **Double** | The discount delta amount for the TCB. |  [optional] |
|**deltaDiscountTcv** | **Double** | The discount delta amount for the TCV. |  [optional] |
|**deltaGrossTcb** | **Double** | The TCB delta value before discount charges are applied. |  [optional] |
|**deltaGrossTcv** | **Double** | The TCV delta value before discount charges are applied. |  [optional] |
|**deltaMrr** | [**List&lt;RampIntervalChargeDeltaMetricsDeltaMrrInner&gt;**](RampIntervalChargeDeltaMetricsDeltaMrrInner.md) | The MRR changing history of the current rate plan charge in the current ramp interval. |  [optional] |
|**deltaNetTcb** | **Double** | The TCB delta value after discount charges are applied. |  [optional] |
|**deltaNetTcv** | **Double** | The TCV delta value after discount charges are applied. |  [optional] |
|**deltaQuantity** | [**List&lt;RampIntervalChargeDeltaMetricsDeltaQuantityInner&gt;**](RampIntervalChargeDeltaMetricsDeltaQuantityInner.md) | The charge quantity changing history of the current rate plan charge in the current ramp interval. |  [optional] |
|**productRatePlanChargeId** | **String** | The ID of the corresponding product rate plan charge. |  [optional] |
|**subscriptionNumber** | **String** | The number of the subscription that the current rate plan charge belongs to. |  [optional] |



