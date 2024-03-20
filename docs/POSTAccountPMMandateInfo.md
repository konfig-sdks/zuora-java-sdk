

# POSTAccountPMMandateInfo

The mandate information for the Credit Card, Apple Pay, Google Pay, Credit Card Reference Transaction, ACH, or Bank Transfer payment method.  The following mandate fields are common to all supported payment methods: * `mandateId` * `mandateReason` * `mandateStatus`  The following mandate fields are specific to the ACH and Bank Transfer payment methods: * `mandateReceivedStatus` * `existingMandateStatus` * `mandateCreationDate` * `mandateUpdateDate`  The following mandate fields are specific to the Credit Card, Apple Pay, and Google Pay payment methods: * `mitTransactionId` * `mitProfileAgreedOn` * `mitConsentAgreementRef` * `mitConsentAgreementSrc` * `mitProfileType` * `mitProfileAction` 

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**existingMandateStatus** | [**ExistingMandateStatusEnum**](#ExistingMandateStatusEnum) | Indicates whether the mandate is an existing mandate.  |  [optional] |
|**mandateCreationDate** | **LocalDate** | The date on which the mandate was created.  |  [optional] |
|**mandateId** | **String** | The mandate ID.  |  [optional] |
|**mandateReason** | **String** | The reason of the mandate from the gateway side.  |  [optional] |
|**mandateReceivedStatus** | [**MandateReceivedStatusEnum**](#MandateReceivedStatusEnum) | Indicates whether the mandate is received from the gateway  |  [optional] |
|**mandateStatus** | **String** | The status of the mandate from the gateway side.  |  [optional] |
|**mandateUpdateDate** | **LocalDate** | The date on which the mandate was updated.  |  [optional] |
|**mitConsentAgreementRef** | **String** | Reference for the consent agreement that you have established with the customer.    |  [optional] |
|**mitConsentAgreementSrc** | [**MitConsentAgreementSrcEnum**](#MitConsentAgreementSrcEnum) | Required if you set the &#x60;mitProfileAction&#x60; field. Specify how the consent agreement has been established with the customer. The allowed value is &#x60;External&#x60;. If you do not specify the &#x60;mitProfileAction&#x60; field, Zuora will automatically create a stored credential profile for the payment method, with the default value &#x60;External&#x60; set to this field.  |  [optional] |
|**mitProfileAction** | [**MitProfileActionEnum**](#MitProfileActionEnum) | Specifies how Zuora creates and activates the stored credential profile. Only applicable if you set the &#x60;status&#x60; field to &#x60;Active&#x60;.  * &#x60;Activate&#x60; (default) - Use this value if you are creating the stored credential profile after receiving the customer&#39;s consent.    Zuora will create the stored credential profile then send a cardholder-initiated transaction (CIT) to the payment gateway to validate the stored credential profile. If the CIT succeeds, the status of the stored credential profile will be &#x60;Active&#x60;. If the CIT does not succeed, Zuora will not create a stored credential profile.      If the payment gateway does not support the stored credential transaction framework, the status of the stored credential profile will be &#x60;Agreed&#x60;.   * &#x60;Persist&#x60; - Use this value if the stored credential profile represents a stored credential profile in an external system. The status of the payment method&#39;s stored credential profile will be &#x60;Active&#x60;.  If you do not specify this field, Zuora will automatically create a stored credential profile for the payment method, with the default value &#x60;Activate&#x60; set to this field.  |  [optional] |
|**mitProfileAgreedOn** | **LocalDate** | The date on which the stored credential profile is agreed. The date format is &#x60;yyyy-mm-dd&#x60;.  |  [optional] |
|**mitProfileType** | **String** | Indicates the type of the stored credential profile. If you do not specify the &#x60;mitProfileAction&#x60; field, Zuora will automatically create a stored credential profile for the payment method, with the default value &#x60;Recurring&#x60; set to this field.  |  [optional] |
|**mitTransactionId** | **String** | Specifies the ID of the transaction. Only applicable if you set the &#x60;mitProfileAction&#x60; field to &#x60;Persist&#x60;.  |  [optional] |



## Enum: ExistingMandateStatusEnum

| Name | Value |
|---- | -----|
| TRUE | &quot;true&quot; |
| FALSE | &quot;false&quot; |



## Enum: MandateReceivedStatusEnum

| Name | Value |
|---- | -----|
| TRUE | &quot;true&quot; |
| FALSE | &quot;false&quot; |



## Enum: MitConsentAgreementSrcEnum

| Name | Value |
|---- | -----|
| EXTERNAL | &quot;External&quot; |



## Enum: MitProfileActionEnum

| Name | Value |
|---- | -----|
| ACTIVATE | &quot;Activate&quot; |
| PERSIST | &quot;Persist&quot; |



