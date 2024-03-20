

# POSTPaymentMethodUpdaterResponse


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**processId** | **String** | The ID of the running process when the exception occurs. This field is available only if the &#x60;success&#x60; field is &#x60;false&#x60;.  |  [optional] |
|**reasons** | [**List&lt;POSTPaymentMethodUpdaterResponseReasonsInner&gt;**](POSTPaymentMethodUpdaterResponseReasonsInner.md) | The container of the error code and message. This field is available only if the &#x60;success&#x60; field is &#x60;false&#x60;.  |  [optional] |
|**requestId** | **String** | The ID of the request. This field is available only if the &#x60;success&#x60; field is &#x60;false&#x60;  |  [optional] |
|**success** | **Boolean** | Indicates whether the request to create a PMU batch is sent successfully.  |  [optional] |



