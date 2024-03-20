

# CustomObjectBulkDeleteFilterCondition

Condition evaluated on a single object field

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**field** | **String** | The object field that is evaluated. Only filterable fields can be evaluated in the filter. |  |
|**operator** | [**OperatorEnum**](#OperatorEnum) |  |  |
|**value** | **Object** | The value that the filterable &#x60;field&#x60; is evaluated against in the filter. The data type of &#x60;value&#x60; is consistent with that of the &#x60;field&#x60;. |  |



## Enum: OperatorEnum

| Name | Value |
|---- | -----|
| EQ | &quot;EQ&quot; |
| GT | &quot;GT&quot; |
| LT | &quot;LT&quot; |
| GE | &quot;GE&quot; |
| LE | &quot;LE&quot; |



