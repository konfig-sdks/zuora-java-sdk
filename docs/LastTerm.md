

# LastTerm

The length of the period for the current subscription term.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**period** | **Integer** | Specify only when the termType is &#39;TERMED&#39;. |  [optional] |
|**periodType** | [**PeriodTypeEnum**](#PeriodTypeEnum) | Specify only when the termType is &#39;TERMED&#39;. |  [optional] |
|**startDate** | **LocalDate** | The start date of the current term. You can change the term start date of a renewed subscription through a T&amp;Cs order action. However, when changing it to an earlier date, this date must not be earlier than the term start date of the current term before this T&amp;Cs.  |  [optional] |
|**termType** | [**TermTypeEnum**](#TermTypeEnum) |  |  |



## Enum: PeriodTypeEnum

| Name | Value |
|---- | -----|
| MONTH | &quot;Month&quot; |
| YEAR | &quot;Year&quot; |
| DAY | &quot;Day&quot; |
| WEEK | &quot;Week&quot; |



## Enum: TermTypeEnum

| Name | Value |
|---- | -----|
| TERMED | &quot;TERMED&quot; |
| EVERGREEN | &quot;EVERGREEN&quot; |



