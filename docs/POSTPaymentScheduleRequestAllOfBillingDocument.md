

# POSTPaymentScheduleRequestAllOfBillingDocument

Object of the billing document with which the payment schedule is associated.  **Note:** - This field is optional. If you have the Standalone Payment feature enabled, you can leave this field blank and set `standalone` to `true` to create standalone payments. You can also choose to create unapplied payments by leaving this object blank and setting `standalone` to `false`. - If Standalone Payment is not enabled, leaving this object unspecified will create unapplied payments. 

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**id** | **String** | ID of the billing document.  **Note:**  If a billing document is specified, either &#x60;id&#x60; or &#x60;number&#x60; of the billing document must be specified. You cannot specify both of them or skip both.  |  [optional] |
|**number** | **String** | ID of the billing document.  **Note:**  If a billing document is specified, either &#x60;id&#x60; or &#x60;number&#x60; of the billing document must be specified. You cannot specify both of them or skip both.  |  [optional] |
|**type** | [**TypeEnum**](#TypeEnum) | The type of the billing document. The default value is &#x60;Invoice&#x60;.  |  |



## Enum: TypeEnum

| Name | Value |
|---- | -----|
| INVOICE | &quot;Invoice&quot; |
| DEBITMEMO | &quot;DebitMemo&quot; |



