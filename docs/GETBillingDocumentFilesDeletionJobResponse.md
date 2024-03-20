

# GETBillingDocumentFilesDeletionJobResponse


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**id** | **String** | The unique ID of the billing document file deletion job.  |  [optional] |
|**status** | [**StatusEnum**](#StatusEnum) | The status of the billing document file deletion job.  |  [optional] |
|**success** | **Boolean** | Returns &#x60;true&#x60; if the request was processed successfully. |  [optional] |



## Enum: StatusEnum

| Name | Value |
|---- | -----|
| PENDING | &quot;Pending&quot; |
| PROCESSING | &quot;Processing&quot; |
| COMPLETED | &quot;Completed&quot; |
| ERROR | &quot;Error&quot; |



