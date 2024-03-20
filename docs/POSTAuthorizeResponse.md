

# POSTAuthorizeResponse


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**gatewayOrderId** | **String** | The order ID for the specific gateway.  The specified order ID will be used in transaction authorization. If you specify an empty value for this field, Zuora will generate an ID and you will have to associate this ID with your order ID by yourself if needed. It is recommended to specify an ID for this field.  |  [optional] |
|**paymentGatewayResponse** | [**POSTAuthorizeResponsePaymentGatewayResponse**](POSTAuthorizeResponsePaymentGatewayResponse.md) |  |  [optional] |
|**processId** | **String** | The ID of the running process when the exception occurs. This field is available only if the &#x60;success&#x60; field is &#x60;false&#x60;.  |  [optional] |
|**reasons** | [**List&lt;POSTAuthorizeResponseReasonsInner&gt;**](POSTAuthorizeResponseReasonsInner.md) | The container of the error code and message. This field is available only if the &#x60;success&#x60; field is &#x60;false&#x60;.  |  [optional] |
|**requestId** | **String** | The ID of the request. This field is available only if the &#x60;success&#x60; field is &#x60;false&#x60;  |  [optional] |
|**resultCode** | **String** | The result code of the request.   0 indicates that the request succeeded, and the following values indicate that the request failed:   - 1: The request is declined.   - 7: The field format is not correct.   - 10: Client connection has timed out.   - 11: Host connection has timed out.   - 12: Processor connection has timed out.   - 13: Gateway server is busy.   - 20: The card type is not supported.   - 21: The merchant account information is invalid.   - 22: A generic error occurred on the processor.   - 40: The card type has not been set up yet.   - 41: The limit for a single transaction is exceeded.   - 42: Address checking failed.   - 43: Card security code checking failed.   - 44: Failed due to the gateway security setting.   - 45: Fraud protection is declined.   - 46: Address checking or card security code checking failed (for Authorize.net gateway only).   - 47: The maximum amount is exceeded (for Authorize.net gateway only).   - 48: The IP address is blocked by the gateway (for Authorize.net gateway only).   - 49: Card security code checking failed (for Authorize.net gateway only).   - 60: User authentication failed.   - 61: The currency code is invalid.   - 62: The transaction ID is invalid.   - 63: The credit card number is invalid.   - 64: The card expiration date is invalid.   - 65: The transaction is duplicated.   - 66: Credit transaction error.   - 67: Void transaction error.   - 90: A valid amount is required.   - 91: The BA code is invalid.   - 92: The account number is invalid.   - 93: The ACH transaction is not accepted by the merchant.   - 94: An error occurred for the ACH transaction.   - 95: The version parameter is invalid.   - 96: The transaction type is invalid.   - 97: The transaction method is invalid.   - 98: The bank account type is invalid.   - 99: The authorization code is invalid.   - 200: General transaction error.   - 500: The transaction is queued for submission.   - 999: Unknown error.   - -1: An error occurred in gateway communication.   - -2: Idempotency is not supported.   - -3: Inquiry call is not supported.  |  [optional] |
|**resultMessage** | **String** | The corresponding request ID. |  [optional] |
|**success** | **Boolean** | Indicates whether the call succeeded. |  [optional] |
|**transactionId** | **String** | The ID of the transaction. |  [optional] |



