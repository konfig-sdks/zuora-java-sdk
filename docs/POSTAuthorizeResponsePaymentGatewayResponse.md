

# POSTAuthorizeResponsePaymentGatewayResponse

The response data returned from the gateway. This field is available only if the `success` field is `false` and the support for returning additional error information from the gateway is enabled. 

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**additionalInfo** | **Object** | The additional information returned from the gateway. The returned fields vary for gateways. Here is an example.  &#x60;&#x60;&#x60; \&quot;additionalInfo\&quot;: {   \&quot;ProcessorName\&quot;: \&quot;MasterCard Saferpay Test\&quot;,   \&quot;ProcessorResult\&quot;: \&quot;51\&quot;,   \&quot;ProcessorMessage\&quot;: \&quot;Insufficient funds\&quot;,   \&quot;ErrorName\&quot;: \&quot;TRANSACTION_DECLINED\&quot; } &#x60;&#x60;&#x60;  |  [optional] |
|**gatewayResponseCode** | **String** | The HTTP response code.  |  [optional] |
|**gatewayResponseMessage** | **String** | The error message returned from the gateway.  |  [optional] |
|**gatewayType** | **String** | The gateway type.  |  [optional] |
|**gatewayVersion** | **String** | The gateway version.  |  [optional] |



