

# BillRunScheduleRequestType


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**repeatFrom** | **LocalDate** | The start date of the scheduled bill run.  |  |
|**repeatTo** | **LocalDate** | The end date of of the scheduled bill run.  |  [optional] |
|**repeatType** | [**RepeatTypeEnum**](#RepeatTypeEnum) | The repeat type of the bill run.  |  |
|**runTime** | **Integer** | The scheduled run time (hour) of day.  **Values:** 0 - 23  |  |
|**weeklyOnDay** | [**List&lt;WeeklyOnDayEnum&gt;**](#List&lt;WeeklyOnDayEnum&gt;) | The repeat day in a week.   This field is required if you set &#x60;repeatType&#x60; field to &#x60;Weekly&#x60;.  |  [optional] |



## Enum: RepeatTypeEnum

| Name | Value |
|---- | -----|
| NONE | &quot;None&quot; |
| DAILY | &quot;Daily&quot; |
| WEEKLY | &quot;Weekly&quot; |
| MONTHLY | &quot;Monthly&quot; |



## Enum: List&lt;WeeklyOnDayEnum&gt;

| Name | Value |
|---- | -----|
| MON | &quot;Mon&quot; |
| TUE | &quot;Tue&quot; |
| WED | &quot;Wed&quot; |
| THU | &quot;Thu&quot; |
| FRI | &quot;Fri&quot; |
| SAT | &quot;Sat&quot; |
| SUN | &quot;Sun&quot; |



