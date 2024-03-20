

# GetOrdersResponse


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**processId** | **String** | The ID of the process that handles the operation.  |  [optional] |
|**reasons** | [**List&lt;CommonResponseReasonsInner&gt;**](CommonResponseReasonsInner.md) |  |  [optional] |
|**requestId** | **UUID** | Unique identifier of the request.  |  [optional] |
|**success** | **Boolean** | Indicates whether the call succeeded.  |  [optional] |
|**nextPage** | **String** | URL to retrieve the next page of the response if it exists; otherwise absent.  |  [optional] |
|**orders** | [**List&lt;Order&gt;**](Order.md) |  |  [optional] |



