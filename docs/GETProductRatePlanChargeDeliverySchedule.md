

# GETProductRatePlanChargeDeliverySchedule

The delivery schedule information of this charge. Only when this charge is using Delivery Pricing charge model 

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**frequency** | [**FrequencyEnum**](#FrequencyEnum) | The frequency of the delivery. Only supports weekly now  |  [optional] |
|**friday** | **Boolean** | The flag to indicate should the delivery happen on Friday  |  [optional] |
|**monday** | **Boolean** | The flag to indicate should the delivery happen on Monday  |  [optional] |
|**saturday** | **Boolean** | The flag to indicate should the delivery happen on Saturday  |  [optional] |
|**sunday** | **Boolean** | The flag to indicate should the delivery happen on Sunday  |  [optional] |
|**thursday** | **Boolean** | The flag to indicate should the delivery happen on Thursday  |  [optional] |
|**tuesday** | **Boolean** | The flag to indicate should the delivery happen on Tuesday  |  [optional] |
|**wendesday** | **Boolean** | The flag to indicate should the delivery happen on Wendesday  |  [optional] |



## Enum: FrequencyEnum

| Name | Value |
|---- | -----|
| WEEKLY | &quot;Weekly&quot; |



