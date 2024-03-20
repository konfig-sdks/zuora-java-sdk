

# POSTPaymentMethodDecryption


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**accountID** | **String** | The ID of the customer account associated with this payment method. To create an orphan payment method that is not associated with any customer account, you do not need to specify this field during creation. However, you must associate the orphan payment method with a customer account within 10 days. Otherwise, this orphan payment method will be deleted. |  [optional] |
|**cardHolderInfo** | [**CreatePaymentMethodCardholderInfo**](CreatePaymentMethodCardholderInfo.md) |  |  [optional] |
|**integrationType** | **String** | Field to identify the token decryption type.  **Note:** The only value at this time is &#x60;ApplePay&#x60;.   |  |
|**invoiceId** | **String** | The id of invoice this payment will apply to.  **Note:** When &#x60;processPayment&#x60; is &#x60;true&#x60;, this field is required. Only one invoice can be paid; for scenarios where you want to pay for multiple invoices, set &#x60;processPayment&#x60; to &#x60;false&#x60; and call payment API separately.  |  [optional] |
|**merchantID** | **String** | The Merchant ID that was configured for use with Apple Pay in the Apple iOS Developer Center.  |  |
|**mitConsentAgreementSrc** | [**MitConsentAgreementSrcEnum**](#MitConsentAgreementSrcEnum) | This field is only available for the following gateway integrations to create stored credential profiles within payment methods:   - Chase Paymentech Orbital Gateway   - CyberSource Payment API v2.0   - Stripe v2   - Vantiv (Now Worldpay)  Specify how the consent agreement has been established with the customer. The allowed value is &#x60;External&#x60;. It is required if the &#x60;mitProfileAction&#x60; field is specified. If you do not specify the &#x60;mitProfileAction&#x60; field, Zuora will automatically create a stored credential profile for the payment method, with the default value &#x60;External&#x60; set to this field.  |  [optional] |
|**mitProfileAction** | [**MitProfileActionEnum**](#MitProfileActionEnum) | This field is only available for the following gateway integrations to create stored credential profiles within payment methods:   - Chase Paymentech Orbital Gateway   - CyberSource Payment API v2.0   - Stripe v2   - Vantiv (Now Worldpay)  Specify either of the following values in this field:        - &#x60;Activate&#x60; - Use this value if you are creating the stored credential profile after receiving the customer&#39;s consent.          Zuora will create the stored credential profile then send a cardholder-initiated transaction (CIT) to the payment gateway to validate the stored credential profile. If the CIT succeeds, the status of the stored credential profile will be &#x60;Active&#x60;. If the CIT does not succeed, Zuora will not create a stored credential profile.            If the payment gateway does not support the stored credential transaction framework, the status of the stored credential profile will be &#x60;Agreed&#x60;.        - &#x60;Persist&#x60; - Use this value if the stored credential profile represents a stored credential profile in an external system. The status of the payment method&#39;s stored credential profile will be &#x60;Active&#x60;.    If you do not specify this field, Zuora will automatically create a stored credential profile for the payment method, with the default value &#x60;Activate&#x60; set to this field.       |  [optional] |
|**mitProfileType** | [**MitProfileTypeEnum**](#MitProfileTypeEnum) | This field is only available for the following gateway integrations to create stored credential profiles within payment methods:   - Chase Paymentech Orbital Gateway   - CyberSource Payment API v2.0   - Stripe v2   - Vantiv (Now Worldpay)  This field indicates the type of the stored credential profile to process recurring or unsecheduled transactions. It is required if the &#x60;mitProfileAction&#x60; field is specified. If you do not specify the &#x60;mitProfileAction&#x60; field, Zuora will automatically create a stored credential profile for the payment method, with the default value &#x60;Recurring&#x60; set to this field.       |  [optional] |
|**paymentGateway** | **String** | The label name of the gateway instance configured in Zuora that should process the payment. When creating a Payment, this must be a valid gateway instance ID and this gateway must support the specific payment method. If not specified, the default gateway of your Zuora customer account will be used.  **Note:** When &#x60;processPayment&#x60; is &#x60;true&#x60;, this field is required. When &#x60;processPayment&#x60; is &#x60;false&#x60;, the default payment gateway of your Zuora customer account will be used no matter whether a payment gateway instance is specified in the &#x60;paymentGateway&#x60; field.  |  [optional] |
|**paymentToken** | **Object** | The complete JSON Object representing the encrypted payment token payload returned in the response from the Apple Pay session.   |  |
|**processPayment** | **Boolean** | A boolean flag to control whether a payment should be processed after creating payment method. The payment amount will be equivalent to the amount the merchant supplied in the ApplePay session. Default is false.  If this field is set to &#x60;true&#x60;, you must specify the &#x60;paymentGateway&#x60; field with the payment gateway instance name.  If this field is set to &#x60;false&#x60;:   - The default payment gateway of your Zuora customer account will be used no matter whether a payment gateway instance is specified in the &#x60;paymentGateway&#x60; field.    - You must select the **Verify new credit card** check box on the gateway instance settings page. Otherwise, the cryptogram will not be sent to the gateway.   - A separate subscribe or payment API call is required after this payment method creation call.  |  [optional] |



## Enum: MitConsentAgreementSrcEnum

| Name | Value |
|---- | -----|
| EXTERNAL | &quot;External&quot; |



## Enum: MitProfileActionEnum

| Name | Value |
|---- | -----|
| ACTIVATE | &quot;Activate&quot; |
| PERSIST | &quot;Persist&quot; |



## Enum: MitProfileTypeEnum

| Name | Value |
|---- | -----|
| RECURRING | &quot;Recurring&quot; |
| UNSCHEDULED | &quot;Unscheduled&quot; |



