

# RampRequest

Container of the ramp definitions. It is used to create, update, or remove the ramp definition for the new subscription. 

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**description** | **String** | The short description of the ramp. |  [optional] |
|**charges** | [**List&lt;RampChargeRequest&gt;**](RampChargeRequest.md) | Container for the rate plan charges that are considered as part of the ramp deal.  * If this field is not specified, all the one-time and recurring regular charges of the new subscription are automatically considered as part of the ramp deal. * If this field is specified, either &#39;chargeNumber&#39; or &#39;uniqueToken&#39; must be specified.  |  [optional] |
|**delete** | **Boolean** | Whether to remove the ramp definition from the new subscription. If you want to remove the ramp definition, this field is the only required field for the &#x60;ramp&#x60; object.    |  [optional] |
|**intervals** | [**List&lt;RampIntervalRequest&gt;**](RampIntervalRequest.md) | Container for the intervals that the ramp is split into in its timeline.   It is required when you want to create or update the ramp definition. The ramp intervals cannot have any overlap or gap between each other.  |  [optional] |
|**name** | **String** | The name of the ramp. |  [optional] |



