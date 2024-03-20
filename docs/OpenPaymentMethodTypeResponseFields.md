

# OpenPaymentMethodTypeResponseFields


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**description** | **String** | An explanation of this field.  |  [optional] |
|**checksum** | **Boolean** | The checksum value of a payment method is used to identify if this payment method is the same as another one, or if this payment method is altered to another new payment method.  For example, if you select the credit card number and expiration date as the checksum fields for the CreditCard payment method type, when you modified the expiration date, Zuora considers this payment method as a different payment method compared to the original one.  |  [optional] |
|**defaultValue** | **String** | The default value of the field.  |  [optional] |
|**editable** | **Boolean** | Specify &#x60;true&#x60; if this field can be updated through PUT API or UI.  Note: If &#x60;editable&#x60; is set to &#x60;false&#x60;, you can specify the value of this field in the UI and POST API when creating a payment method. However, after you created the payment method, you cannot edit this field through PUT API or UI.  |  [optional] |
|**index** | **Integer** | The order of the field in this type, starting from 1.  |  [optional] |
|**label** | **String** | The label that is used to refer to this field in the Zuora UI.  |  [optional] |
|**maxLength** | **Integer** | A maximum length limitation of the field value.  |  [optional] |
|**minLength** | **Integer** | A minimal length limitation of the field value.  |  [optional] |
|**name** | **String** | The API name of this field. It must be uinique.  |  [optional] |
|**representer** | **Boolean** | This flag determines whether this field will be used for identifying this payment method in the Zuora UI. The field will be shown in the Payment Method field in the UI.  |  [optional] |
|**required** | **Boolean** | Specify whether this field is required.  |  [optional] |
|**type** | [**TypeEnum**](#TypeEnum) | The type of this field.  |  [optional] |
|**visible** | **Boolean** | Specify &#x60;true&#x60; if this field can be retrieved through GET API or UI for displaying payment method details.  Notes:    - If &#x60;visible&#x60; is set to &#x60;false&#x60;, you can still specify the value of this field in the UI and POST API when creating the payment method.   - If &#x60;visible&#x60; is set to &#x60;false&#x60; and &#x60;editable&#x60; is set to &#x60;true&#x60;, this field is not accessible through GET API or UI for displaying details, but you can still see it and edit the value in the UI and PUT API when updating this payment method.  |  [optional] |



## Enum: TypeEnum

| Name | Value |
|---- | -----|
| STRING | &quot;string&quot; |
| DATE | &quot;date&quot; |
| DATETIME | &quot;datetime&quot; |
| NUMBER | &quot;number&quot; |
| BOOLEAN | &quot;boolean&quot; |



