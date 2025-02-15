

# PUTUpdateOpenPaymentMethodTypeRequest


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**entityId** | **String** | If this custom payment method type is specific to one entity only, specify the entity ID in UUID format when creating the draft payment method type, such as &#x60;123e4567-e89b-12d3-a456-426614174000&#x60;.  You can only update this field to be empty, indicating that this custom payment method type is available to the global entity and all the sub entities in the tenant.  |  [optional] |
|**fields** | [**List&lt;OpenPaymentMethodTypeRequestFields&gt;**](OpenPaymentMethodTypeRequestFields.md) | An array containing field metadata of the custom payment method type.  Notes:   - All the following nested metadata fields must be provided in the request to define a field.    - At least one field must be defined in the fields array for a custom payment method type.    - Up to 20 fields can be defined in the fields array for a custom method type.  |  |
|**internalName** | **String** | A string to identify the custom payment method type in the API name of the payment method type.  The value of this field must be the same as the value specified when creating the draft revision of this custom payment method type.  This field cannot be updated after the creation of the custom payment method type.  This field is used along with the &#x60;tenantId&#x60; field by the system to construct and generate the API name of the custom payment method type in the following way:  &#x60;&lt;internalName&gt;__c_&lt;tenantId&gt;&#x60;  For example, if &#x60;internalName&#x60; is &#x60;AmazonPay&#x60;, and &#x60;tenantId&#x60; is &#x60;12368&#x60;, the API name of the custom payment method type will be &#x60;AmazonPay__c_12368&#x60;.  |  |
|**label** | **String** | The label that is used to refer to this type in the Zuora UI.  This value must be alphanumeric, excluding JSON preserved characters such as  * \\ ’ ”   |  |
|**methodReferenceIdField** | **String** | The identification reference of the custom payment method.  This field should be mapped to a field name defined in the &#x60;fields&#x60; array for the purpose of being used as a filter in reporting tools such as Payment Method Data Source Exports and Data Query.  The value of this field must be the same as the value specified when creating the draft revision of this custom payment method type.  This field cannot be updated after the creation of the custom payment method type.  |  |
|**subTypeField** | **String** | The identification reference indicating the subtype of the custom payment method.  This field should be mapped to a field name defined in the &#x60;fields&#x60; array for the purpose of being used as a filter in reporting tools such as Data Source Exports and Data Query.  This field cannot be updated after the creation of the custom payment method type.  |  [optional] |
|**tenantId** | **String** | Zuora tenant ID. If multi-entity is enabled in your tenant, this is the ID of the parent tenant of all the sub entities.  This field cannot be updated after the creation of the custom payment method type.  |  |
|**userReferenceIdField** | **String** | The identification reference of the user or customer account.  This field should be mapped to a field name defined in the &#x60;fields&#x60; array for the purpose of being used as a filter in reporting tools such as Data Source Exports and Data Query.  This field cannot be updated after the creation of the custom payment method type.  |  [optional] |



