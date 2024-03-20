

# Options

Invoice or Payment.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**billingTargetDate** | **LocalDate** | Date through which to calculate charges if an invoice is generated. See [What is a Target Date?](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/J_Billing_Operations/G_Bill_Runs/Creating_Bill_Runs#What_is_a_Target_Date.3F). |  [optional] |
|**collectPayment** | **Boolean** | Indicates if the current request needs to collect payments. This value can not be &#39;true&#39; when &#39;runBilling&#39; flag is &#39;false&#39;. |  [optional] |
|**maxSubscriptionsPerAccount** | **Double** |  |  [optional] |
|**runBilling** | **Boolean** | Indicates if the current request needs to generate an invoice. The invoice will be generated against all subscriptions included in this order. |  [optional] |



