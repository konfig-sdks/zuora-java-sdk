

# CreditMemoFromChargeDetailTypeAllOf


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**description** | **String** | The description of the product rate plan charge.  **Note**: This field is only available if you set the &#x60;zuora-version&#x60; request header to &#x60;257.0&#x60; or later [available versions](https://developer.zuora.com/api-references/api/overview/#section/API-Versions/Minor-Version).  |  [optional] |
|**amount** | **Double** | The amount of the credit memo item.  **Note**: This field is only available if you set the &#x60;zuora-version&#x60; request header to &#x60;224.0&#x60; or later [available versions](https://developer.zuora.com/api-references/api/overview/#section/API-Versions/Minor-Version).  |  [optional] |
|**chargeId** | **String** | The ID of the product rate plan charge that the credit memo is created from.  **Note**: This field is not available if you set the &#x60;zuora-version&#x60; request header to &#x60;257.0&#x60; or later [available versions](https://developer.zuora.com/api-references/api/overview/#section/API-Versions/Minor-Version).  |  |
|**comment** | **String** | Comments about the product rate plan charge.  **Note**: This field is not available if you set the &#x60;zuora-version&#x60; request header to &#x60;257.0&#x60; or later [available versions](https://developer.zuora.com/api-references/api/overview/#section/API-Versions/Minor-Version).  |  [optional] |
|**financeInformation** | [**CreditMemoFromChargeDetailTypeAllOfFinanceInformation**](CreditMemoFromChargeDetailTypeAllOfFinanceInformation.md) |  |  [optional] |
|**memoItemAmount** | **Double** | The amount of the credit memo item.  **Note**: This field is not available if you set the &#x60;zuora-version&#x60; request header to &#x60;224.0&#x60; or later [available versions](https://developer.zuora.com/api-references/api/overview/#section/API-Versions/Minor-Version).  |  [optional] |
|**productRatePlanChargeId** | **String** | The ID of the product rate plan charge that the credit memo is created from.  **Note**: This field is only available if you set the &#x60;zuora-version&#x60; request header to &#x60;257.0&#x60; or later [available versions](https://developer.zuora.com/api-references/api/overview/#section/API-Versions/Minor-Version).  |  |
|**quantity** | **Double** | The number of units for the credit memo item.  |  [optional] |
|**serviceEndDate** | **LocalDate** | The service end date of the credit memo item. If not specified, the effective end date of the corresponding product rate plan will be used.  |  [optional] |
|**serviceStartDate** | **LocalDate** | The service start date of the credit memo item. If not specified, the effective start date of the corresponding product rate plan will be used.  |  [optional] |



