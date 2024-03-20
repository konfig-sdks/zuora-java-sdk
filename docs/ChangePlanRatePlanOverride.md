

# ChangePlanRatePlanOverride

Information about the new product rate plan to add.  

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**chargeOverrides** | [**List&lt;ChangePlanChargeOverride&gt;**](ChangePlanChargeOverride.md) | List of charges associated with the rate plan.  |  [optional] |
|**clearingExistingFeatures** | **Boolean** | Specifies whether all features in the rate plan will be cleared.  |  [optional] |
|**customFields** | **Map&lt;String, Object&gt;** | Container for custom fields of the Rate Plan or Subscription Offer object. The custom fields of the Rate Plan object are used when rate plans are subscribed, and the custom fields of the Subscription Offer object are used when product offers are subscribed.  |  [optional] |
|**externallyManagedPlanId** | **String** | Indicates the unique identifier for the rate plan purchased on a third-party store. This field is used to represent a subscription rate plan created through third-party stores.  |  [optional] |
|**productRatePlanId** | **String** | Internal identifier of the product rate plan that the rate plan is based on.  |  [optional] |
|**productRatePlanNumber** | **String** | Number of a product rate plan for this subscription.  |  [optional] |
|**subscriptionProductFeatures** | [**List&lt;RatePlanFeatureOverride&gt;**](RatePlanFeatureOverride.md) | List of features associated with the rate plan. The system compares the &#x60;subscriptionProductFeatures&#x60; and &#x60;featureId&#x60; fields in the request with the counterpart fields in a rate plan. The comparison results are as follows: * If there is no &#x60;subscriptionProductFeatures&#x60; field or the field is empty, features in the rate plan remain unchanged. But if the &#x60;clearingExistingFeatures&#x60; field is additionally set to true, all features in the rate plan are cleared. * If the &#x60;subscriptionProductFeatures&#x60; field contains the &#x60;featureId&#x60; nested fields, as well as the optional &#x60;description&#x60; and &#x60;customFields&#x60; nested fields, the features indicated by the featureId nested fields in the request overwrite all features in the rate plan.  |  [optional] |
|**uniqueToken** | **String** | Unique identifier for the rate plan. This identifier enables you to refer to the rate plan before the rate plan has an internal identifier in Zuora.  For instance, suppose that you want to use a single order to add a product to a subscription and later update the same product. When you add the product, you can set a unique identifier for the rate plan. Then when you update the product, you can use the same unique identifier to specify which rate plan to modify.  |  [optional] |



