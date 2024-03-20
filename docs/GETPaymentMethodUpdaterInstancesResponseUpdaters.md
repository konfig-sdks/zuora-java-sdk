

# GETPaymentMethodUpdaterInstancesResponseUpdaters

Container for PMU instances available on your tenant. 

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**daysToUpdateBeforeBcd** | **Integer** | The days prior to the Bill Cycle Day to start PMU service.  |  [optional] |
|**id** | **String** | The ID of the PMU instance.  |  [optional] |
|**isActive** | **Boolean** | &#x60;true&#x60; indicates that this PMU instance is active.  |  [optional] |
|**isDefault** | **Boolean** | &#x60;true&#x60; indicates that it is the default PMU instance.  |  [optional] |
|**isTest** | **String** | &#x60;true&#x60; indicates that this PMU instance is for testing.  |  [optional] |
|**processAssociatedGwOnly** | **Boolean** | &#x60;true&#x60; indicates that only the payment methods for customer accounts that meet either of the following conditions are included in the updates:   - The default payment gateway of the customer account is set to an instance of the same type as &#x60;updaterGatewayType&#x60;.   - The default payment gateway of the customer account is not configured, but the default payment gateway of the tenant is set to an instance of the same type as &#x60;updaterGatewayType&#x60;.  &#x60;false&#x60; indicates that information of all payment methods is submitted.  |  [optional] |
|**processAutopayDefaultPmOnly** | **Boolean** | &#x60;true&#x60; indicates that only the default payment methods for customer accounts with the AutoPay setting enabled are included in the updates.   &#x60;false&#x60; indicates that data of all payment methods for all customer accounts is submitted, regardless of whether AutoPay is enabled for the customer account or not.  |  [optional] |
|**processMastercard** | **Boolean** | &#x60;true&#x60; indicates that Mastercard data processing is supported.  |  [optional] |
|**processVisa** | **Boolean** | &#x60;true&#x60; indicates that Visa data processing is supported.  |  [optional] |
|**updaterGatewayType** | **String** | The payment gateway type of the PMU instance.  |  [optional] |
|**updaterName** | **String** | The name of the PMU instance.  |  [optional] |



