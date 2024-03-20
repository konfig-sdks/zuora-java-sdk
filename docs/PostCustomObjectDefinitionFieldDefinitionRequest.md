

# PostCustomObjectDefinitionFieldDefinitionRequest


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**displayName** | **Boolean** | Indicates whether to use this field as the display name of the custom object when being linked to another custom object.  This field applies only to the Text custom field type:  - The &#x60;type&#x60; field is &#x60;string&#x60;. - The &#x60;enum&#x60; field is not specified.  |  [optional] |
|**format** | **String** | The data format of the custom field |  [optional] |
|**label** | **String** | The UI label of the custom field |  |
|**maxLength** | **Integer** | The maximum length of string that can be stored in the custom field.  This field applies only to the following custom field types:  - Text:   - The &#x60;type&#x60; field is &#x60;string&#x60;.   - The &#x60;format&#x60; field is not specified or is &#x60;url&#x60;.   - The &#x60;enum&#x60; field is not specified. - Picklist:   - The &#x60;type&#x60; field is &#x60;string&#x60;.   - The &#x60;enum&#x60; field is specified.   - The &#x60;multiselect&#x60; field is not specified or is &#x60;false&#x60;. - Multiselect:   - The &#x60;type&#x60; field is &#x60;string&#x60;.   - The &#x60;enum&#x60; field is specified.   - The &#x60;multiselect&#x60; field is &#x60;true&#x60;.  If the custom field is filterable, the value of &#x60;maxLength&#x60; must be 512 or less.  |  [optional] |
|**multiselect** | **Boolean** | Indicates whether this is a multiselect custom field.  This field applies only to the Picklist or Multiselect custom field types:  - The &#x60;type&#x60; field is &#x60;string&#x60;. - The &#x60;maxLength&#x60; field is specified. - The &#x60;enum&#x60; field is specified.  |  [optional] |
|**type** | **String** | The data type of the custom field |  |



