

# GETAccountSummaryTypeBasicInfo

Container for basic information about the account. 

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**tags** | **String** |  |  [optional] |
|**accountNumber** | **String** | Account number.  |  [optional] |
|**additionalEmailAddresses** | **List&lt;String&gt;** | A list of additional email addresses to receive email notifications.  |  [optional] |
|**autoPay** | **Boolean** | Whether future payments are automatically collected when they are due during a payment run.  |  [optional] |
|**balance** | **BigDecimal** | Current outstanding balance.  |  [optional] |
|**batch** | **String** | The alias name given to a batch. A string of 50 characters or less.  |  [optional] |
|**billCycleDay** | **String** | Billing cycle day (BCD), the day of the month when a bill run generates invoices for the account.  |  [optional] |
|**currency** | **String** | A currency as defined in Billing Settings in the Zuora UI.  |  [optional] |
|**defaultPaymentMethod** | [**GETAccountSummaryTypeBasicInfoAllOfDefaultPaymentMethod**](GETAccountSummaryTypeBasicInfoAllOfDefaultPaymentMethod.md) |  |  [optional] |
|**id** | **String** | Account ID.  |  [optional] |
|**invoiceDeliveryPrefsEmail** | **Boolean** | Whether the customer wants to receive invoices through email.   |  [optional] |
|**invoiceDeliveryPrefsPrint** | **Boolean** | Whether the customer wants to receive printed invoices, such as through postal mail.  |  [optional] |
|**lastInvoiceDate** | **LocalDate** | Date of the most recent invoice for the account; null if no invoice has ever been generated.  |  [optional] |
|**lastMetricsUpdate** | **OffsetDateTime** | The date and time when account metrics are last updated, if the account is a partner account.  **Note**:    - This field is available only if you have the &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Manage_customer_accounts/AAA_Overview_of_customer_accounts/Reseller_Account\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Reseller Account&lt;/a&gt; feature enabled.   - If you have the Reseller Account feature enabled, and set the &#x60;partnerAccount&#x60; field to &#x60;false&#x60; for an account, the value of the &#x60;lastMetricsUpdate&#x60; field is automatically set to &#x60;null&#x60; in the response.    - If you ever set the &#x60;partnerAccount&#x60; field to &#x60;true&#x60; for an account, the value of &#x60;lastMetricsUpdate&#x60; field is the time when the account metrics are last updated.     |  [optional] |
|**lastPaymentAmount** | **BigDecimal** | Amount of the most recent payment collected for the account; null if no payment has ever been collected.  |  [optional] |
|**lastPaymentDate** | **LocalDate** | Date of the most recent payment collected for the account. Null if no payment has ever been collected.  |  [optional] |
|**name** | **String** | Account name.  |  [optional] |
|**organizationLabel** | **String** | The organization that this object belongs to.  Note: This field is available only when the Multi-Org feature is enabled.  |  [optional] |
|**partnerAccount** | **Boolean** | Whether the customer account is a partner, distributor, or reseller.    **Note**: This field is available only if you have the &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Manage_customer_accounts/AAA_Overview_of_customer_accounts/Reseller_Account\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Reseller Account&lt;/a&gt; feature enabled.  |  [optional] |
|**purchaseOrderNumber** | **String** | The purchase order number provided by your customer for services, products, or both purchased. |  [optional] |
|**status** | **String** | Account status; possible values are: &#x60;Active&#x60;, &#x60;Draft&#x60;, &#x60;Canceled&#x60;.  |  [optional] |
|**classNS** | **String** | Value of the Class field for the corresponding customer account in NetSuite. Only available if you have installed the [Zuora Connector for NetSuite](https://www.zuora.com/connect/app/?appId&#x3D;265).  |  [optional] |
|**customerTypeNS** | [**CustomerTypeNSEnum**](#CustomerTypeNSEnum) | Value of the Customer Type field for the corresponding customer account in NetSuite. The Customer Type field is used when the customer account is created in NetSuite. Only available if you have installed the [Zuora Connector for NetSuite](https://www.zuora.com/connect/app/?appId&#x3D;265).  |  [optional] |
|**departmentNS** | **String** | Value of the Department field for the corresponding customer account in NetSuite. Only available if you have installed the [Zuora Connector for NetSuite](https://www.zuora.com/connect/app/?appId&#x3D;265).  |  [optional] |
|**integrationIdNS** | **String** | ID of the corresponding object in NetSuite. Only available if you have installed the [Zuora Connector for NetSuite](https://www.zuora.com/connect/app/?appId&#x3D;265).  |  [optional] |
|**integrationStatusNS** | **String** | Status of the account&#39;s synchronization with NetSuite. Only available if you have installed the [Zuora Connector for NetSuite](https://www.zuora.com/connect/app/?appId&#x3D;265).  |  [optional] |
|**locationNS** | **String** | Value of the Location field for the corresponding customer account in NetSuite. Only available if you have installed the [Zuora Connector for NetSuite](https://www.zuora.com/connect/app/?appId&#x3D;265).  |  [optional] |
|**subsidiaryNS** | **String** | Value of the Subsidiary field for the corresponding customer account in NetSuite. The Subsidiary field is required if you use NetSuite OneWorld. Only available if you have installed the [Zuora Connector for NetSuite](https://www.zuora.com/connect/app/?appId&#x3D;265).  |  [optional] |
|**syncDateNS** | **String** | Date when the account was sychronized with NetSuite. Only available if you have installed the [Zuora Connector for NetSuite](https://www.zuora.com/connect/app/?appId&#x3D;265).  |  [optional] |
|**synctoNetSuiteNS** | [**SynctoNetSuiteNSEnum**](#SynctoNetSuiteNSEnum) | Specifies whether the account should be synchronized with NetSuite. Only available if you have installed the [Zuora Connector for NetSuite](https://www.zuora.com/connect/app/?appId&#x3D;265).  |  [optional] |



## Enum: CustomerTypeNSEnum

| Name | Value |
|---- | -----|
| COMPANY | &quot;Company&quot; |
| INDIVIDUAL | &quot;Individual&quot; |



## Enum: SynctoNetSuiteNSEnum

| Name | Value |
|---- | -----|
| TRUE | &quot;true&quot; |
| FALSE | &quot;false&quot; |



