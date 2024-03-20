

# CustomObjectBulkJobRequest


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**filter** | [**CustomObjectBulkDeleteFilter**](CustomObjectBulkDeleteFilter.md) |  |  [optional] |
|**namespace** | [**NamespaceEnum**](#NamespaceEnum) | The namespace of the object. Custom objects belong to the &#x60;default&#x60; namespace. Zuora standard objects belong to the &#x60;com_zuora&#x60; namespace. Bulk job operations on the following Zuora standard objects are supported: * SavedQuery  |  |
|**_object** | **String** | The object that the bulk operation performs on. |  |
|**operation** | [**OperationEnum**](#OperationEnum) | The operation that the bulk job performs. Only the users that have the \&quot;Delete Custom Objects\&quot; permission can submit a &#x60;delete&#x60; bulk job request. Only the users that have the \&quot;Edit Custom Objects\&quot; permission can submit a &#x60;create&#x60; or &#x60;update&#x60; bulk job request. See [Platform Permissions](https://knowledgecenter.zuora.com/Billing/Tenant_Management/A_Administrator_Settings/User_Roles/h_Platform_Roles#Platform_Permissions) for more information. |  |



## Enum: NamespaceEnum

| Name | Value |
|---- | -----|
| DEFAULT | &quot;default&quot; |
| COM_ZUORA | &quot;com_zuora&quot; |



## Enum: OperationEnum

| Name | Value |
|---- | -----|
| DELETE | &quot;delete&quot; |
| CREATE | &quot;create&quot; |
| UPDATE | &quot;update&quot; |



