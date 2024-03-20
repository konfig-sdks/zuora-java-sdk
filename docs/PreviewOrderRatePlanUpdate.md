

# PreviewOrderRatePlanUpdate

Information about an order action of type `UpdateProduct`. 

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**chargeUpdates** | [**List&lt;PreviewOrderChargeUpdate&gt;**](PreviewOrderChargeUpdate.md) | Array of the JSON objects containing the information for a charge update in the &#x60;updateProduct&#x60; type of order action.  When previewing an &#x60;updateProduct&#x60; order action, either the &#x60;chargeNumber&#x60; or &#x60;uniqueToken&#x60; field is required to specify the charge to update.  |  [optional] |
|**clearingExistingFeatures** | **Boolean** | Specifies whether all features in the rate plan will be cleared.  |  [optional] |
|**customFields** | **Map&lt;String, Object&gt;** | Container for custom fields of the Rate Plan or Subscription Offer object. The custom fields of the Rate Plan object are used when rate plans are subscribed, and the custom fields of the Subscription Offer object are used when product offers are subscribed.  |  [optional] |
|**productRatePlanNumber** | **String** | Number of a product rate plan for this subscription.  |  [optional] |
|**ratePlanId** | **String** | The id of the rate plan to be updated. It can be the latest version or any history version id.  |  [optional] |
|**specificUpdateDate** | **LocalDate** |  The date when the Update Product order action takes effect. This field is only applicable if there is already a future-dated Update Product order action on the subscription. The format of the date is yyyy-mm-dd.  See [Update a Product on Subscription with Future-dated Updates](https://knowledgecenter.zuora.com/BC_Subscription_Management/Orders/AC_Orders_Tutorials/C_Update_a_Product_in_a_Subscription/Update_a_Product_on_Subscription_with_Future-dated_Updates) for more information about this feature.  |  [optional] |
|**subscriptionProductFeatures** | [**List&lt;CreateOrderRatePlanFeatureOverride&gt;**](CreateOrderRatePlanFeatureOverride.md) | List of features associated with the rate plan. The system compares the &#x60;subscriptionProductFeatures&#x60; and &#x60;featureId&#x60; fields in the request with the counterpart fields in a rate plan. The comparison results are as follows: * If there is no &#x60;subscriptionProductFeatures&#x60; field or the field is empty, features in the rate plan remain unchanged. But if the &#x60;clearingExistingFeatures&#x60; field is additionally set to true, all features in the rate plan are cleared. * If the &#x60;subscriptionProductFeatures&#x60; field contains the &#x60;featureId&#x60; nested fields, as well as the optional &#x60;description&#x60; and &#x60;customFields&#x60; nested fields, the features indicated by the featureId nested fields in the request overwrite all features in the rate plan.  |  [optional] |
|**subscriptionRatePlanNumber** | **String** | Number of a rate plan for this subscription.  |  [optional] |
|**uniqueToken** | **String** | A unique string to represent the rate plan in the order. The unique token is used to perform multiple actions against a newly added rate plan. For example, if you want to add and update a product in the same order, assign a unique token to the newly added rate plan and use that token in future order actions.  |  [optional] |



