

# GETUsageRateDetailWrapperData

Contains usage rate details for the invoice item as specified in the request. 

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**amountWithoutTax** | **Double** | The amount of the invoice item without tax.  |  [optional] |
|**chargeNumber** | **String** | The unique number of the product rate plan charge associated with the invoice item.  |  [optional] |
|**invoiceId** | **String** | The unique ID of the invoice.  |  [optional] |
|**invoiceItemId** | **String** | The unique ID of the invoice item.  |  [optional] |
|**invoiceNumber** | **String** | The unique number of the invoice.  |  [optional] |
|**listPrice** | **String** | The list price of the product rate plan charge associated with the invoice item. For example, if the product rate plan charge uses the tiered charge model, its list price could be:   Tier / From / To / List Price / Price Format\\n1 / 0 / 9 / 0.00 / Per Unit\\n2 / 10 / 20 / 1.00 / Per Unit\\n3 / 21 / 30 / 2.00 / Flat Fee\\n4 / 31 /   / 3.00 / Per Unit\\n  |  [optional] |
|**quantity** | **String** | The quantity of the invoice item.  |  [optional] |
|**rateDetail** | **String** | The rate detail of the invoice item. It shows how the total amount is calculated. For example, if the product rate plan charge uses the tiered charge model, the rate detail for the associated invoice item could be:   Tier 1: 0-9, 9 Each(s) x $0.00/Each &#x3D; $0.00\\nTier 2: 10-20, 11 Each(s) x $1.00/Each &#x3D; $11.00\\nTier 3: 21-30, $2.00 Flat Fee\\nTier 4: &gt;&#x3D;31, 15 Each(s) x $3.00/Each &#x3D; $45.00\\nTotal &#x3D; $58.00.   The rate detail retrieved from this REST API operation is the same as the [Rate Detail presented on PDF invoices](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/IA_Invoices/Create_a_custom_invoice_template/DD_Display_Usage_Charge_Breakdown#How_UsageSummary.RateDetail_is_displayed_on_invoices).   |  [optional] |
|**servicePeriod** | **String** | The service period of the invoice item.  |  [optional] |
|**uom** | **String** | The unit of measurement of the invoice item.  |  [optional] |



