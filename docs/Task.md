

# Task

A task. 

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**tags** | **List&lt;String&gt;** | The array of filter tags.  |  [optional] |
|**parameters** | **Object** | The configuration of the task.  |  [optional] |
|**actionType** | [**ActionTypeEnum**](#ActionTypeEnum) | The type of the task.  |  [optional] |
|**callType** | **String** | The type of API used.  |  [optional] |
|**concurrentLimit** | **Integer** | the number of concurrent tasks that are allowed to run simultaneously |  [optional] |
|**data** | **Object** | The data payload for the task.  |  [optional] |
|**endTime** | **String** | If **Instance** is **true**, the end time of the task instance.  |  [optional] |
|**error** | **String** | If **Instance** is **true** and **status** is **Error**, the error reason of the task instance failure.  |  [optional] |
|**errorClass** | **String** | If **Instance** is **true** and **status** is **Error**, the error class of the task instance failure.  |  [optional] |
|**errorDetails** | **String** | If **Instance** is **true** and **status** is **Error**, the error details of the task instance failure.  |  [optional] |
|**id** | **Integer** | The unique ID of the task.  |  [optional] |
|**instance** | **Boolean** | Indicates whether this task belongs to an instance of a workflow.  |  [optional] |
|**name** | **String** | The name of the task.  |  [optional] |
|**_object** | **String** | The selected object for the task.  |  [optional] |
|**objectId** | **String** | The id of the selected object of the task.  |  [optional] |
|**originalTaskId** | **Integer** | If **Instance** is **true**, the ID of the original task in the original workflow.  |  [optional] |
|**originalWorkflowId** | **Integer** | If **Instance** is **true**, the ID of the original workflow.  |  [optional] |
|**startTime** | **String** | If **Instance** is **true**, the start time of the task instance.  |  [optional] |
|**status** | [**StatusEnum**](#StatusEnum) | If **Instance** is **true**, the status of the task instance.  |  [optional] |
|**taskId** | **Integer** | the id of this task&#39;s parent task. Will be null if this is the first task of the workflow |  [optional] |
|**workflowId** | **Integer** | The ID of the workflow that the task belongs to.  |  [optional] |



## Enum: ActionTypeEnum

| Name | Value |
|---- | -----|
| APPROVAL | &quot;Approval&quot; |
| ATTACHMENT | &quot;Attachment&quot; |
| BILLING_BILLRUN | &quot;Billing::BillRun&quot; |
| BILLING_CURRENCYCONVERSION | &quot;Billing::CurrencyConversion&quot; |
| BILLING_CUSTOMINVOICE | &quot;Billing::CustomInvoice&quot; |
| CALLOUT | &quot;Callout&quot; |
| CANCEL | &quot;Cancel&quot; |
| CREATE | &quot;Create&quot; |
| CUSTOMOBJECT_CREATE | &quot;CustomObject::Create&quot; |
| CUSTOMOBJECT_DELETE | &quot;CustomObject::Delete&quot; |
| CUSTOMOBJECT_QUERY | &quot;CustomObject::Query&quot; |
| CUSTOMOBJECT_UPDATE | &quot;CustomObject::Update&quot; |
| DATA_BILLINGPREVIEWRUN | &quot;Data::BillingPreviewRun&quot; |
| DATA_LINK | &quot;Data::Link&quot; |
| DELAY | &quot;Delay&quot; |
| DELETE | &quot;Delete&quot; |
| DOWNLOAD_SFTP | &quot;Download::SFTP&quot; |
| EMAIL | &quot;Email&quot; |
| EXPORT | &quot;Export&quot; |
| FILE_CUSTOMPDF_CUSTOMDOCUMENT | &quot;File::CustomPDF::CustomDocument&quot; |
| IF | &quot;If&quot; |
| INVOICEGENERATE | &quot;InvoiceGenerate&quot; |
| ITERATE | &quot;Iterate&quot; |
| LOGIC_CSVTRANSLATOR | &quot;Logic::CSVTranslator&quot; |
| LOGIC_CASE | &quot;Logic::Case&quot; |
| LOGIC_CUSTOMCODE | &quot;Logic::CustomCode&quot; |
| LOGIC_JSONTRANSFORM | &quot;Logic::JSONTransform&quot; |
| LOGIC_LAMBDA | &quot;Logic::Lambda&quot; |
| LOGIC_RESPONSEFORMATTER | &quot;Logic::ResponseFormatter&quot; |
| LOGIC_XMLTRANSFORM | &quot;Logic::XMLTransform&quot; |
| NEWPRODUCT | &quot;NewProduct&quot; |
| NOTIFICATIONS_GOOGLECLOUDPRINT | &quot;Notifications::GoogleCloudPrint&quot; |
| NOTIFICATIONS_PHONECALL | &quot;Notifications::PhoneCall&quot; |
| NOTIFICATIONS_SMS | &quot;Notifications::SMS&quot; |
| PAYMENT_GATEWAYRECONCILIATION | &quot;Payment::GatewayReconciliation&quot; |
| PAYMENT_PAYMENTRUN | &quot;Payment::PaymentRun&quot; |
| QUERY | &quot;Query&quot; |
| REMOVEPRODUCT | &quot;RemoveProduct&quot; |
| REPORTING_REPORTDATA | &quot;Reporting::ReportData&quot; |
| REPORTING_RUNREPORT | &quot;Reporting::RunReport&quot; |
| RESUME | &quot;Resume&quot; |
| SUSPEND | &quot;Suspend&quot; |
| UI_PAGE | &quot;UI::Page&quot; |
| UI_STOP | &quot;UI::Stop&quot; |
| UPDATE | &quot;Update&quot; |
| UPLOAD_FTP | &quot;Upload::FTP&quot; |
| UPLOAD_SFTP | &quot;Upload::SFTP&quot; |
| WRITEOFF | &quot;WriteOff&quot; |



## Enum: StatusEnum

| Name | Value |
|---- | -----|
| QUEUED | &quot;Queued&quot; |
| PROCESSING | &quot;Processing&quot; |
| PENDING | &quot;Pending&quot; |
| SUCCESS | &quot;Success&quot; |
| STOPPED | &quot;Stopped&quot; |
| ERROR | &quot;Error&quot; |



