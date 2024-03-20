

# POSTBillingDocumentFilesDeletionJobRequest


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**accountIds** | **List&lt;String&gt;** | Container for the IDs of the accounts that you want to create the billing document files deletion job for.  **Note**: When creating jobs to delete billing document PDF files, you must specify either set of &#x60;accountIds&#x60; or &#x60;accountKeys&#x60; in the request body.  |  [optional] |
|**accountKeys** | **List&lt;String&gt;** | Container for the IDs and/or numbers of the accounts that you want to create the billing document files deletion job for.  **Note**: When creating jobs to delete billing document PDF files, you must specify either set of &#x60;accountIds&#x60; or &#x60;accountKeys&#x60; in the request body.  |  [optional] |



