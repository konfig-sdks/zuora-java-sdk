

# PaymentWithCustomRatesType


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**currency** | **String** | The currency code for either Reporting or Home currency.  **Note**: This field is only available if you set the &#x60;zuora-version&#x60; request header to &#x60;224.0&#x60; or later [available versions](https://www.zuora.com/developer/api-references/api/overview/#section/API-Versions/Minor-Version).  |  |
|**customFxRate** | **Double** | The Custom FX conversion rate between Home/Reporting and Transactional currency items.  **Note**: This field is only available if you set the &#x60;zuora-version&#x60; request header to &#x60;224.0&#x60; or later [available versions](https://www.zuora.com/developer/api-references/api/overview/#section/API-Versions/Minor-Version).  |  |
|**rateDate** | **LocalDate** | The date on which a particular currency rate is fixed or obtained on.  **Note**: This field is only available if you set the &#x60;zuora-version&#x60; request header to &#x60;224.0&#x60; or later [available versions](https://www.zuora.com/developer/api-references/api/overview/#section/API-Versions/Minor-Version).  |  [optional] |



