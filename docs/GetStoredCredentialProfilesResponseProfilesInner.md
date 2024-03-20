

# GetStoredCredentialProfilesResponseProfilesInner


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**activatedOn** | **OffsetDateTime** | The date when the stored credential profile was activated (if applicable).  |  [optional] |
|**agreedOn** | **OffsetDateTime** | The date when the stored credential profile was created.  |  [optional] |
|**brand** | **String** | The stored credential transaction framework. For example, Visa.  |  [optional] |
|**cancelledOn** | **OffsetDateTime** | The date when the stored credential profile was cancelled (if applicable).  |  [optional] |
|**consentAgreementRef** | **String** | Your reference for the consent agreement that you have established with the customer.  |  [optional] |
|**consentAgreementSrc** | [**ConsentAgreementSrcEnum**](#ConsentAgreementSrcEnum) |  |  [optional] |
|**expiredOn** | **OffsetDateTime** | The date when the stored credential profile was expired (if applicable).  |  [optional] |
|**number** | **Integer** | The number that identifies the stored credential profile within the payment method.  |  [optional] |
|**paymentMethodId** | **String** | ID of the payment method.  |  [optional] |
|**status** | [**StatusEnum**](#StatusEnum) | The status of the stored credential profile.  * &#x60;Agreed&#x60; - The stored credential profile has not been validated via an authorization transaction with the payment gateway. * &#x60;Active&#x60; - The stored credential profile has been validated via an authorization transaction with the payment gateway. * &#x60;Cancelled&#x60; - The stored credentials are no longer valid, per a customer request. Zuora cannot use the stored credentials in transactions. * &#x60;Expired&#x60; - The stored credentials are no longer valid, per an expiration policy in the stored credential transaction framework. Zuora cannot use the stored credentials in transactions.  |  [optional] |
|**type** | [**TypeEnum**](#TypeEnum) |  |  [optional] |



## Enum: ConsentAgreementSrcEnum

| Name | Value |
|---- | -----|
| EXTERNAL | &quot;External&quot; |



## Enum: StatusEnum

| Name | Value |
|---- | -----|
| AGREED | &quot;Agreed&quot; |
| ACTIVE | &quot;Active&quot; |
| CANCELLED | &quot;Cancelled&quot; |
| EXPIRED | &quot;Expired&quot; |



## Enum: TypeEnum

| Name | Value |
|---- | -----|
| RECURRING | &quot;Recurring&quot; |
| UNSCHEDULED | &quot;Unscheduled&quot; |



