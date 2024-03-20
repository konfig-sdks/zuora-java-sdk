

# GETDeliveryScheduleType

The `deliverySchedule` is used for the Delivery Pricing charge model only.   **Note**: The Delivery Pricing charge model is in the **Early Adopter** phase. We are actively soliciting feedback from a small set of early adopters before releasing it as generally available. To manage and access this feature through the self-service interface, see [Enable billing features by yourself](https://knowledgecenter.zuora.com/Zuora_Billing/Bill_your_customers/Billing_Settings/Manage_Features) in the Knowledge Center. You can check **Delivery Pricing** in **Billing Settings** > **Enable Charge Types / Models**. 

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**frequency** | [**FrequencyEnum**](#FrequencyEnum) | Specifies delivery frequency for the delivery schedule.  |  [optional] |
|**friday** | **Boolean** | Indicates whether delivery occurs on Friday.  |  [optional] |
|**monday** | **Boolean** | Indicates whether delivery occurs on Monday.  |  [optional] |
|**saturday** | **Boolean** | Indicates whether delivery occurs on Saturday.  |  [optional] |
|**sunday** | **Boolean** | Indicates whether delivery occurs on Sunday.  |  [optional] |
|**thursday** | **Boolean** | Indicates whether delivery occurs on Thursday.  |  [optional] |
|**tuesday** | **Boolean** | Indicates whether delivery occurs on Tuesday.  |  [optional] |
|**wednesday** | **Boolean** | Indicates whether delivery occurs on Wednesday.  |  [optional] |



## Enum: FrequencyEnum

| Name | Value |
|---- | -----|
| WEEKLY | &quot;Weekly&quot; |



