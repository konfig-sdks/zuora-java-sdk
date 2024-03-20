

# GETSubscriptionRatePlanTypeAllOf


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**externallyManagedPlanId** | **String** | Indicates the unique identifier for the rate plan purchased on a third-party store. This field is used to represent a subscription rate plan created through third-party stores.  |  [optional] |
|**id** | **String** | Rate plan ID.  |  [optional] |
|**lastChangeType** | **String** | The last amendment on the rate plan.    **Note:** If a subscription is created through an order, this field is only available if multiple orders are created on the subscription.   Possible Values:   * &#x60;Add&#x60;   * &#x60;Update&#x60;   * &#x60;Remove&#x60;  |  [optional] |
|**productId** | **String** |  |  [optional] |
|**productName** | **String** |  |  [optional] |
|**productRatePlanId** | **String** |  |  [optional] |
|**productSku** | **String** | The unique SKU for the product.  |  [optional] |
|**ratePlanCharges** | [**List&lt;GETSubscriptionRatePlanChargesType&gt;**](GETSubscriptionRatePlanChargesType.md) | Container for one or more charges.  |  [optional] |
|**ratePlanName** | **String** | Name of the rate plan.  |  [optional] |
|**subscriptionProductFeatures** | [**List&lt;GETSubscriptionProductFeatureType&gt;**](GETSubscriptionProductFeatureType.md) | Container for one or more features.   Only available when the following settings are enabled:  * The Entitlements feature in your tenant.  * The Enable Feature Specification in Product and Subscriptions setting in Zuora Billing Settings |  [optional] |



