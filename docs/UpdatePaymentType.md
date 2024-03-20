

# UpdatePaymentType


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**comment** | **String** | Comments about the payment.  |  [optional] |
|**financeInformation** | [**UpdatePaymentTypeAllOfFinanceInformation**](UpdatePaymentTypeAllOfFinanceInformation.md) |  |  [optional] |
|**gatewayState** | [**GatewayStateEnum**](#GatewayStateEnum) | This field is mainly used for gateway reconciliation. See &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Payments/Payment_Operations/DA_Electronic_Payment_Processing#Gateway_Reconciliation_Consideration\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Electronic payment processing&lt;/a&gt; for details.  You must have the **Edit Payment Gateway Status** &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Central_Platform/Tenant_Management/A_Administrator_Settings/User_Roles/e_Payments_Roles\&quot; target&#x3D;\&quot;_blank\&quot;&gt;user permission&lt;/a&gt; to update this field.  |  [optional] |
|**paymentScheduleKey** | **String** | The unique ID or the number of the payment schedule to be linked with the payment. See [Link payments to payment schedules](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/Payment_Schedules/Link_payments_with_payment_schedules) for more information. |  [optional] |
|**referenceId** | **String** | The transaction ID returned by the payment gateway. Use this field to reconcile payments between your gateway and Zuora Payments.  You can only update the reference ID for external payments.  |  [optional] |
|**integrationIdNS** | **String** | ID of the corresponding object in NetSuite. Only available if you have installed the [Zuora Connector for NetSuite](https://www.zuora.com/connect/app/?appId&#x3D;265).  |  [optional] |
|**integrationStatusNS** | **String** | Status of the payment&#39;s synchronization with NetSuite. Only available if you have installed the [Zuora Connector for NetSuite](https://www.zuora.com/connect/app/?appId&#x3D;265).  |  [optional] |
|**originNS** | **String** | Origin of the corresponding object in NetSuite. Only available if you have installed the [Zuora Connector for NetSuite](https://www.zuora.com/connect/app/?appId&#x3D;265).  |  [optional] |
|**syncDateNS** | **String** | Date when the payment was synchronized with NetSuite. Only available if you have installed the [Zuora Connector for NetSuite](https://www.zuora.com/connect/app/?appId&#x3D;265).  |  [optional] |
|**transactionNS** | **String** | Related transaction in NetSuite. Only available if you have installed the [Zuora Connector for NetSuite](https://www.zuora.com/connect/app/?appId&#x3D;265).  |  [optional] |



## Enum: GatewayStateEnum

| Name | Value |
|---- | -----|
| NOTSUBMITTED | &quot;NotSubmitted&quot; |
| SUBMITTED | &quot;Submitted&quot; |
| SETTLED | &quot;Settled&quot; |
| FAILEDTOSETTLE | &quot;FailedToSettle&quot; |



