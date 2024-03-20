

# POSTOrderRequestTypeSchedulingOptions

Information of scheduled order.   **Note**: To manage and access the <a href=\"https://knowledgecenter.zuora.com/Zuora_Billing/Manage_subscription_transactions/Orders/AA_Overview_of_Orders/P_Scheduled_Orders\" target=\"_blank\">Scheduled Orders</a> feature from the self-service interface, see <a href=\"https://knowledgecenter.zuora.com/Zuora_Billing/Configure_billing_settings/System_settings/Enable_billing_features_by_yourself\" target=\"_blank\">Enable billing features by yourself</a>. 

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**scheduledDate** | **LocalDate** | The date for the order scheduled.  |  [optional] |
|**scheduledDatePolicy** | [**ScheduledDatePolicyEnum**](#ScheduledDatePolicyEnum) | Date policy of the scheduled order. |  [optional] |



## Enum: ScheduledDatePolicyEnum

| Name | Value |
|---- | -----|
| SPECIFICDATE | &quot;SpecificDate&quot; |



