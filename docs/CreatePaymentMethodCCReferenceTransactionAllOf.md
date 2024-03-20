

# CreatePaymentMethodCCReferenceTransactionAllOf


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**type** | **String** |  |  [optional] |
|**creditCardMaskNumber** | **String** | The masked credit card number, such as &#x60;*********1112&#x60;. This field is specific for the CC Reference Transaction payment method. It is an optional field that you can use to distinguish different CC Reference Transaction payment methods. Though there are no special restrictions on the input string, it is highly recommended to specify a card number that is masked.  |  [optional] |
|**secondTokenId** | **String** | A gateway unique identifier that replaces sensitive payment method data.   &#x60;secondTokenId&#x60; is conditionally required only when &#x60;tokenId&#x60; is being used to represent a gateway customer profile. &#x60;secondTokenId&#x60; is used in the CC Reference Transaction payment method.  |  [optional] |
|**tokenId** | **String** | A gateway unique identifier that replaces sensitive payment method data or represents a gateway&#39;s unique customer profile.  When &#x60;tokenId&#x60; is used to represent a customer profile, &#x60;secondTokenId&#x60; is conditionally required for representing the underlying tokenized payment method.  The values for the &#x60;tokenId&#x60; and &#x60;secondTokenId&#x60; fields differ for gateways. For more information, see the Knowledge Center article specific to each gateway that supports the CC Reference Transaction payment method.  |  [optional] |
|**mandateInfo** | [**Object**](Object.md) | The container of the mandate information for the payment method.  |  [optional] |



