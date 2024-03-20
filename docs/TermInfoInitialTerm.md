

# TermInfoInitialTerm

Information about the first term of the subscription. 

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**period** | **Integer** | Duration of the first term in months, years, days, or weeks, depending on the value of the &#x60;periodType&#x60; field. Only applicable if the value of the &#x60;termType&#x60; field is &#x60;TERMED&#x60;.  |  [optional] |
|**periodType** | [**PeriodTypeEnum**](#PeriodTypeEnum) | Unit of time that the first term is measured in. Only applicable if the value of the &#x60;termType&#x60; field is &#x60;TERMED&#x60;.  |  [optional] |
|**startDate** | **LocalDate** | Start date of the first term, in YYYY-MM-DD format.  |  [optional] |
|**termType** | [**TermTypeEnum**](#TermTypeEnum) | Type of the first term. If the value of this field is &#x60;TERMED&#x60;, the first term has a predefined duration based on the value of the &#x60;period&#x60; field. If the value of this field is &#x60;EVERGREEN&#x60;, the first term does not have a predefined duration.  |  |



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



