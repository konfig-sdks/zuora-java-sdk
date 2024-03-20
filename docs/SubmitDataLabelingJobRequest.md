

# SubmitDataLabelingJobRequest


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**ids** | **List&lt;String&gt;** | The IDs of the objects to be labeled, only required if the &#x60;queryType&#x60; is &#x60;ById&#x60;.  There is a 4MB limit of the JSON payload, so in case of a large number of IDs, please make sure the payload is less than 4MB.  |  [optional] |
|**objectType** | **String** | The object type of the data labeling job.  Currently, the following objects are supported:   * &#x60;User&#x60;   * &#x60;Account&#x60;       All the associated transaction objects of the account being labeled will automatically inherit the org label of the account.   * &#x60;Product&#x60;      You have to label the Account object first, make sure all accounts have been labeled, then you can proceed with the Product object.       You can get all the unlabeled accounts by running a Data Source export job, with the following query:     &#x60;&#x60;&#x60; sql     SELECT Id, Name FROM Account WHERE Organization.Id IS NULL     &#x60;&#x60;&#x60;                        All the ProductRatePlanS of the product will be automatically labeled with the same &#x60;orgs&#x60;.          When labeling products, you can omit the &#x60;orgs&#x60; parameter, i.e, leave it empty, the system will find all the subscriptions that include the product and get the org list of those subscriptions, then label the product with those &#x60;orgs&#x60;, aka, the &#x60;derived orgs&#x60;.          You can also explicitly specify the orgs parameter, in that case, you will need to provide a super set of the &#x60;derived orgs&#x60;.     * &#x60;BillRun&#x60;      You don&#39;t need to specify the &#x60;orgs&#x60; parameter, we will label the &#x60;BillRun&#x60; with all the orgs because existing runs could pick up all accounts. You can definitely create new bill run with certain &#x60;orgs&#x60; to operate separately by &#x60;orgs&#x60;.   * &#x60;PaymentRun&#x60;      Same as BillRun.   * &#x60;ForecastRun&#x60;  |  |
|**orgIds** | **List&lt;UUID&gt;** | The IDs of the organizations that the data labeling job will associate with the data to be labeled. Either the &#x60;orgIds&#x60; or &#x60;orgs&#x60; field is required.  |  [optional] |
|**orgs** | **List&lt;String&gt;** | The names of the organizations that the data labeling job will associate with the data to be labeled. Either the &#x60;orgIds&#x60; or &#x60;orgs&#x60; field is required.  |  [optional] |
|**query** | **String** | The query that the data labeling job will run to fetch the data to be labeled, only required if the &#x60;queryType&#x60; is &#x60;ByZoql&#x60;.  |  [optional] |
|**queryType** | [**QueryTypeEnum**](#QueryTypeEnum) | Specifies the type of query that the data labeling job will run to fetch the data to be labeled.  * &#x60;ByZoql&#x60; - The data labeling job will run a ZOQL query which is specified in the &#x60;query&#x60; field to fetch the data to be labeled. * &#x60;ById&#x60; - The data labeling job will fetch the data to be labeled by the IDs specified in the &#x60;ids&#x60; field.  |  |



## Enum: QueryTypeEnum

| Name | Value |
|---- | -----|
| BYZOQL | &quot;ByZoql&quot; |
| BYID | &quot;ById&quot; |



