

# POSTRSASignatureResponseType


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**key** | **String** | Public key generated for this Payment Page.  |  [optional] |
|**signature** | **String** | Digital signature generated for this Payment Page.  If &#x60;signature&#x60; returns &#x60;null&#x60; but &#x60;token&#x60; is successfully returned, please limit the number of the fields in your request to make sure that the maximum length supported by the RSA signature algorithm is not exceeded.  |  [optional] |
|**success** | **Boolean** | Returns &#x60;true&#x60; if the request was processed successfully.  |  [optional] |
|**tenantId** | **String** | ID of the Zuora tenant.  |  [optional] |
|**token** | **String** | Token generated for this Payment Page.  |  [optional] |



