

# PostCreateDataBackfillJobRequest


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**type** | [**DataBackfillJob**](DataBackfillJob.md) |  |  |
|**_file** | **File** | A file containing the data about the fields that you want to backfill. This file must be a &#x60;.csv&#x60; file or a zipped &#x60;.csv&#x60; file. The maximum file size is 4 MB. The data in the file must be formatted according to the data backfill action type that you want to perform.  You can download a file template to view all fields supported for your data backfill. For more information, see &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Enable_Order_to_Revenue/Configure_revenue_settings/Perform_data_backfill#Perform_data_backfill\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Perform data backfill&lt;/a&gt;.  |  |
|**checksum** | **String** | An MD5 checksum that is used to validate the integrity of the uploaded file. |  [optional] |



