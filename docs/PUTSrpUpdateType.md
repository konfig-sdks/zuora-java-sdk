

# PUTSrpUpdateType


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**bookingDate** | **LocalDate** | The booking date that you want to set for the amendment contract. The booking date of an amendment is the equivalent of the order date of an order. This field must be in the &#x60;yyyy-mm-dd&#x60; format. The default value is the current date when you make the API call.   |  [optional] |
|**chargeUpdateDetails** | [**List&lt;PUTScUpdateType&gt;**](PUTScUpdateType.md) | Container for one or more product rate plan charges.   |  [optional] |
|**contractEffectiveDate** | **LocalDate** | The date when the amendment changes take effect. The format of the date is yyyy-mm-dd.  If there is already a future-dated Update Product amendment on the subscription, the &#x60;specificUpdateDate&#x60; field will be used instead of this field to specify when the Update Product amendment takes effect.  |  |
|**customerAcceptanceDate** | **LocalDate** | The date when the customer accepts the contract in yyyy-mm-dd format.  If this field is not set:  * If the &#x60;serviceActivationDate&#x60; field is not set, the value of this field is set to be the contract effective date. * If the &#x60;serviceActivationDate&#x60; field is set, the value of this field is set to be the service activation date.  The billing trigger dates must follow this rule:  contractEffectiveDate &lt;&#x3D; serviceActivationDate &lt;&#x3D; contractAcceptanceDate  |  [optional] |
|**externalCatalogPlanId** | **String** | An external ID of the rate plan to be updated. You can use this field to specify an existing rate plan in your subscription. The value of the &#x60;externalCatalogPlanId&#x60; field must match one of the values that are predefined in the &#x60;externallyManagedPlanIds&#x60; field on a product rate plan. However, if there are multiple rate plans with the same &#x60;productRatePlanId&#x60; value existing in the subscription, you must use the &#x60;ratePlanId&#x60; field to update the rate plan. The &#x60;externalCatalogPlanId&#x60; field cannot be used to distinguish multiple rate plans in this case.  **Note:** If both &#x60;externalCatalogPlanId&#x60; and &#x60;ratePlanId&#x60; are provided. They must point to the same product rate plan. Otherwise, the request would fail.  |  [optional] |
|**externalIdSourceSystem** | **String** | The ID of the external source system. You can use this field and &#x60;externalCatalogPlanId&#x60; to specify a product rate plan that is imported from an external system.  **Note:** If both &#x60;externalCatalogPlanId&#x60;, &#x60;externalIdSourceSystem&#x60; and &#x60;productRatePlanId&#x60; are provided. They must point to the same product rate plan. Otherwise, the request would fail.  |  [optional] |
|**externallyManagedPlanId** | **String** | Indicates the unique identifier for the rate plan purchased on a third-party store. This field is used to represent a subscription rate plan created through third-party stores.  |  [optional] |
|**productRatePlanNumber** | **String** | Number of a product rate plan for this subscription.  |  [optional] |
|**ratePlanId** | **String** | ID of a rate plan for this subscription. This can be the latest version or any history version of ID.  |  [optional] |
|**serviceActivationDate** | **LocalDate** | The date when the update amendment is activated in yyyy-mm-dd format.  You must specify a Service Activation date if the Customer Acceptance date is set. If the Customer Acceptance date is not set, the value of the &#x60;serviceActivationDate&#x60; field defaults to be the Contract Effective Date.  The billing trigger dates must follow this rule:  contractEffectiveDate &lt;&#x3D; serviceActivationDate &lt;&#x3D; contractAcceptanceDate  |  [optional] |
|**specificUpdateDate** | **LocalDate** | The date when the Update Product amendment takes effect. This field is only applicable if there is already a future-dated Update Product amendment on the subscription. The format of the date is yyyy-mm-dd.  Required only for Update Product amendments if there is already a future-dated Update Product amendment on the subscription.  |  [optional] |
|**subscriptionRatePlanNumber** | **String** | Number of a rate plan for this subscription.  |  [optional] |



