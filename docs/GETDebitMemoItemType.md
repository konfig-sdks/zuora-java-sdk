

# GETDebitMemoItemType


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**description** | **String** | Description about the debit memo item.  **Note**: This field is only available if you set the &#x60;zuora-version&#x60; request header to &#x60;257.0&#x60; or later [available versions](https://developer.zuora.com/api-references/api/overview/#section/API-Versions/Minor-Version).  |  [optional] |
|**amount** | **Double** | The amount of the debit memo item. For tax-inclusive debit memo items, the amount indicates the debit memo item amount including tax. For tax-exclusive debit memo items, the amount indicates the debit memo item amount excluding tax.  |  [optional] |
|**amountWithoutTax** | **Double** | The debit memo item amount excluding tax.  |  [optional] |
|**appliedToItemId** | **String** | The parent debit memo item that this debit memo items is applied to if this item is discount.  |  [optional] |
|**balance** | **Double** | The balance of the debit memo item.  |  [optional] |
|**beAppliedAmount** | **Double** | The applied amount of the debit memo item.  |  [optional] |
|**comment** | **String** | Comments about the debit memo item.  **Note**: This field is not available if you set the &#x60;zuora-version&#x60; request header to &#x60;257.0&#x60; or later [available versions](https://developer.zuora.com/api-references/api/overview/#section/API-Versions/Minor-Version).  |  [optional] |
|**createdById** | **String** | The ID of the Zuora user who created the debit memo item.  |  [optional] |
|**createdDate** | **OffsetDateTime** | The date and time when the debit memo item was created, in &#x60;yyyy-mm-dd hh:mm:ss&#x60; format. For example, 2017-03-01 15:31:10.  |  [optional] |
|**excludeItemBillingFromRevenueAccounting** | **Boolean** | The flag to exclude the debit memo item from revenue accounting.  **Note**: This field is only available if you have the Billing - Revenue Integration feature enabled.   |  [optional] |
|**financeInformation** | [**GETDebitMemoItemTypewithSuccessAllOfFinanceInformation**](GETDebitMemoItemTypewithSuccessAllOfFinanceInformation.md) |  |  [optional] |
|**id** | **String** | The ID of the debit memo item.  |  [optional] |
|**processingType** | **String** | The kind of the charge for the debit memo item. Its possible values are &#x60;Charge&#x60; and &#x60;Discount&#x60;.   |  [optional] |
|**quantity** | **Double** | The number of units for the debit memo item.  |  [optional] |
|**serviceEndDate** | **LocalDate** | The end date of the service period associated with this debit memo item. Service ends one second before the date specified in this field.  |  [optional] |
|**serviceStartDate** | **LocalDate** | The start date of the service period associated with this debit memo item. If the associated charge is a one-time fee, this date is the date of that charge.  |  [optional] |
|**sku** | **String** | The SKU for the product associated with the debit memo item.  |  [optional] |
|**skuName** | **String** | The name of the SKU.  |  [optional] |
|**soldToContactId** | **String** | The ID of the sold-to contact associated with the invoice item.  The value of this field is &#x60;null&#x60; if you have the [Flexible Billing Attributes](https://knowledgecenter.zuora.com/Billing/Subscriptions/Flexible_Billing_Attributes) feature disabled.  |  [optional] |
|**soldToContactSnapshotId** | **String** | The ID of the sold-to contact snapshot associated with the invoice item.  The value of this field is &#x60;null&#x60; if you have the [Flexible Billing Attributes](https://knowledgecenter.zuora.com/Billing/Subscriptions/Flexible_Billing_Attributes) feature disabled.               |  [optional] |
|**sourceItemId** | **String** | The ID of the source item.  |  [optional] |
|**sourceItemType** | [**SourceItemTypeEnum**](#SourceItemTypeEnum) | The type of the source item.  |  [optional] |
|**subscriptionId** | **String** | The ID of the subscription associated with the debit memo item.  |  [optional] |
|**success** | **Boolean** | Returns &#x60;true&#x60; if the request was processed successfully. |  [optional] |
|**taxItems** | [**List&lt;GETDMTaxItemType&gt;**](GETDMTaxItemType.md) | Container for the taxation items of the debit memo item..   **Note**: This field is not available if you set the &#x60;zuora-version&#x60; request header to &#x60;239.0&#x60; or later [available versions](https://developer.zuora.com/api-references/api/overview/#section/API-Versions/Minor-Version).  |  [optional] |
|**taxMode** | [**TaxModeEnum**](#TaxModeEnum) | The tax mode of the debit memo item, indicating whether the amount of the debit memo item includes tax.  |  [optional] |
|**taxationItems** | [**GETDebitMemoItemTypeAllOfTaxationItems**](GETDebitMemoItemTypeAllOfTaxationItems.md) |  |  [optional] |
|**unitOfMeasure** | **String** | The units to measure usage.  |  [optional] |
|**unitPrice** | **Double** | The per-unit price of the debit memo item.  |  [optional] |
|**updatedById** | **String** | The ID of the Zuora user who last updated the debit memo item.  |  [optional] |
|**updatedDate** | **OffsetDateTime** | The date and time when the debit memo item was last updated, in &#x60;yyyy-mm-dd hh:mm:ss&#x60; format. For example, 2017-03-02 15:36:10.  |  [optional] |



## Enum: SourceItemTypeEnum

| Name | Value |
|---- | -----|
| CREDITMEMOITEM | &quot;CreditMemoItem&quot; |
| SUBSCRIPTIONCOMPONENT | &quot;SubscriptionComponent&quot; |
| INVOICEDETAIL | &quot;InvoiceDetail&quot; |
| PRODUCTRATEPLANCHARGE | &quot;ProductRatePlanCharge&quot; |



## Enum: TaxModeEnum

| Name | Value |
|---- | -----|
| TAXEXCLUSIVE | &quot;TaxExclusive&quot; |
| TAXINCLUSIVE | &quot;TaxInclusive&quot; |



