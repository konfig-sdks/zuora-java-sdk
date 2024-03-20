

# GETAccountingPeriodWithoutSuccessTypeAllOfFileIds

File IDs of the reports available for the accounting period. You can retrieve the reports by specifying the file ID in a [Get Files](https://developer.zuora.com/api-references/api/operation/GET_Files) REST API call. 

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**accountsReceivableAccountAgingDetailExportFileId** | **String** | File ID of the Accounts Receivable Aging Account Detail report.  |  [optional] |
|**accountsReceivableInvoiceAgingDetailExportFileId** | **String** | File ID of the Accounts Receivable Aging Invoice Detail report.  |  [optional] |
|**arRollForwardDetailExportFileId** | **String** | File ID of the Accounts Receivable Detail report.  |  [optional] |
|**fxRealizedGainAndLossDetailExportFileId** | **String** | File ID of the Realized Gain and Loss Detail report.  Returned only if you have Foreign Currency Conversion enabled.  |  [optional] |
|**fxUnrealizedGainAndLossDetailExportFileId** | **String** | File ID of the Unrealized Gain and Loss Detail report.  Returned only if you have Foreign Currency Conversion enabled  |  [optional] |
|**revenueDetailCsvFileId** | **String** | File ID of the Revenue Detail report in CSV format.  |  [optional] |
|**revenueDetailExcelFileId** | **String** | File ID of the Revenue Detail report in XLSX format.  |  [optional] |
|**unprocessedChargesFileId** | **String** | File ID of a report containing all unprocessed charges for the accounting period.  |  [optional] |



