

# PUTPaymentMethodRequestAllOfProcessingOptions

The container for payment method processing options. 

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**checkDuplicated** | **Boolean** | Indicates whether to perform a duplication check when you create a payment method of the following types:   - Credit Card   - ACH   - Bank Transfer  The default value is &#x60;false&#x60;.  With this field set to &#x60;true&#x60;, Zuora will check the active and closed payment methods associated with the same billing account to ensure that no duplicate payment methods are created.   For more information, see &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Payments/Payment_Methods/D1_Duplication_check_on_payment_methods\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Duplication check on payment methods&lt;/a&gt;.  |  [optional] |



