

# POSTAccountingPeriodType


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**endDate** | **LocalDate** | The end date of the accounting period in yyyy-mm-dd format, for example, \&quot;2016-02-19\&quot;.  |  |
|**fiscalYear** | **String** | Fiscal year of the accounting period in yyyy format, for example, \&quot;2016\&quot;.  |  |
|**fiscalQuarter** | **Long** |  |  [optional] |
|**name** | **String** | Name of the accounting period.  Accounting period name must be unique. Maximum of 100 characters.  |  |
|**notes** | **String** | Notes about the accounting period.  Maximum of 255 characters.  |  [optional] |
|**organizationLabels** | [**List&lt;GETProductTypeAllOfOrganizationLabels&gt;**](GETProductTypeAllOfOrganizationLabels.md) | The organization that the accounting period belongs to.   For each item in the array, either the &#x60;organizationId&#x60; or the &#x60;organizationName&#x60; field is required.  This field is only required when you have already turned on Multi-Org feature.  |  [optional] |
|**startDate** | **LocalDate** | The start date of the accounting period in yyyy-mm-dd format, for example, \&quot;2016-02-19\&quot;.  |  |



