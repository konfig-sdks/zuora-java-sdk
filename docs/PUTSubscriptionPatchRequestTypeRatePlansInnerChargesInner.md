

# PUTSubscriptionPatchRequestTypeRatePlansInnerChargesInner


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**chargeId** | **String** | Use either this field or the &#x60;chargeNumber&#x60; field to specify the charge for which you will be updating the custom fields. By using this field you actually specify a specific charge segment of a charge. See &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Central_Platform/API/G_SOAP_API/E1_SOAP_API_Object_Reference/RatePlanCharge#Segmented_rate_plan_charges\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Segmented rate plan charges&lt;/a&gt; for more information about charge segments.  |  [optional] |
|**chargeNumber** | **String** | Use either this field or the &#x60;chargeId&#x60; field to specify the charge for which you will be updating the custom fields. By using this field you actually specify the last charge segment of a charge. See &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Central_Platform/API/G_SOAP_API/E1_SOAP_API_Object_Reference/RatePlanCharge#Segmented_rate_plan_charges\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Segmented rate plan charges&lt;/a&gt; for more information about charge segments.  |  [optional] |
|**customFields** | **Map&lt;String, Object&gt;** | Container for custom fields of a Rate Plan Charge object.  |  [optional] |



