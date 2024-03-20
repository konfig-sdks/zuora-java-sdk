

# GETRefundTypewithSuccess


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**accountId** | **String** | The ID of the account associated with this refund. Zuora associates the refund automatically with the account from the associated payment or credit memo.  |  [optional] |
|**amount** | **Double** | The total amount of the refund.  |  [optional] |
|**cancelledOn** | **OffsetDateTime** | The date and time when the refund was cancelled, in &#x60;yyyy-mm-dd hh:mm:ss&#x60; format.  |  [optional] |
|**comment** | **String** | Comments about the refund.  |  [optional] |
|**createdById** | **String** | The ID of the Zuora user who created the refund.  |  [optional] |
|**createdDate** | **OffsetDateTime** | The date and time when the refund was created, in &#x60;yyyy-mm-dd hh:mm:ss&#x60; format. For example, 2017-03-01 15:31:10.  |  [optional] |
|**creditMemoId** | **String** | The ID of the credit memo that is refunded.  |  [optional] |
|**financeInformation** | [**GETRefundCreditMemoTypeAllOfFinanceInformation**](GETRefundCreditMemoTypeAllOfFinanceInformation.md) |  |  [optional] |
|**gatewayId** | **String** | The ID of the gateway instance that processes the refund.  |  [optional] |
|**gatewayReconciliationReason** | **String** | The reason of gateway reconciliation.  |  [optional] |
|**gatewayReconciliationStatus** | **String** | The status of gateway reconciliation.  |  [optional] |
|**gatewayResponse** | **String** | The message returned from the payment gateway for the refund. This message is gateway-dependent.  |  [optional] |
|**gatewayResponseCode** | **String** | The code returned from the payment gateway for the refund. This code is gateway-dependent.  |  [optional] |
|**gatewayState** | [**GatewayStateEnum**](#GatewayStateEnum) | The status of the refund in the gateway.   |  [optional] |
|**id** | **String** | The ID of the refund.  |  [optional] |
|**markedForSubmissionOn** | **OffsetDateTime** | The date and time when a refund was marked and waiting for batch submission to the payment process, in &#x60;yyyy-mm-dd hh:mm:ss&#x60; format.  |  [optional] |
|**methodType** | [**MethodTypeEnum**](#MethodTypeEnum) | How an external refund was issued to a customer.   |  [optional] |
|**number** | **String** | The unique identification number of the refund.  |  [optional] |
|**organizationLabel** | **String** | The organization that this object belongs to.  Note: This field is available only when the Multi-Org feature is enabled.  |  [optional] |
|**paymentId** | **String** | The ID of the payment that is refunded.  |  [optional] |
|**paymentMethodId** | **String** | The unique ID of the payment method that the customer used to make the refund.  |  [optional] |
|**paymentMethodSnapshotId** | **String** | The unique ID of the payment method snapshot, which is a copy of the particular payment method used in a transaction.  |  [optional] |
|**payoutId** | **String** | The payout ID of the refund from the gateway side.  |  [optional] |
|**reasonCode** | **String** | A code identifying the reason for the transaction.  |  [optional] |
|**referenceId** | **String** | The transaction ID returned by the payment gateway for an electronic refund. Use this field to reconcile refunds between your gateway and Zuora Payments.  |  [optional] |
|**refundDate** | **LocalDate** | The date when the refund takes effect, in &#x60;yyyy-mm-dd&#x60; format. For example, 2017-03-01.  |  [optional] |
|**refundTransactionTime** | **OffsetDateTime** | The date and time when the refund was issued, in &#x60;yyyy-mm-dd hh:mm:ss&#x60; format.  |  [optional] |
|**secondRefundReferenceId** | **String** | The transaction ID returned by the payment gateway if there is an additional transaction for the refund. Use this field to reconcile payments between your gateway and Zuora Payments.  |  [optional] |
|**settledOn** | **OffsetDateTime** | The date and time when the refund was settled in the payment processor, in &#x60;yyyy-mm-dd hh:mm:ss&#x60; format. This field is used by the Spectrum gateway only and not applicable to other gateways.  |  [optional] |
|**softDescriptor** | **String** | A payment gateway-specific field that maps Zuora to other gateways.  |  [optional] |
|**softDescriptorPhone** | **String** | A payment gateway-specific field that maps Zuora to other gateways.  |  [optional] |
|**status** | [**StatusEnum**](#StatusEnum) | The status of the refund.   |  [optional] |
|**submittedOn** | **OffsetDateTime** | The date and time when the refund was submitted, in &#x60;yyyy-mm-dd hh:mm:ss&#x60; format.  |  [optional] |
|**type** | [**TypeEnum**](#TypeEnum) | The type of the refund.   |  [optional] |
|**updatedById** | **String** | The ID of the Zuora user who last updated the refund.  |  [optional] |
|**updatedDate** | **OffsetDateTime** | The date and time when the refund was last updated, in &#x60;yyyy-mm-dd hh:mm:ss&#x60; format. For example, 2017-03-02 15:36:10.  |  [optional] |
|**integrationIdNS** | **String** | ID of the corresponding object in NetSuite. Only available if you have installed the [Zuora Connector for NetSuite](https://www.zuora.com/connect/app/?appId&#x3D;265).  |  [optional] |
|**integrationStatusNS** | **String** | Status of the refund&#39;s synchronization with NetSuite. Only available if you have installed the [Zuora Connector for NetSuite](https://www.zuora.com/connect/app/?appId&#x3D;265).  |  [optional] |
|**originNS** | **String** | Origin of the corresponding object in NetSuite. Only available if you have installed the [Zuora Connector for NetSuite](https://www.zuora.com/connect/app/?appId&#x3D;265).  |  [optional] |
|**syncDateNS** | **String** | Date when the refund was synchronized with NetSuite. Only available if you have installed the [Zuora Connector for NetSuite](https://www.zuora.com/connect/app/?appId&#x3D;265).  |  [optional] |
|**synctoNetSuiteNS** | **String** | Specifies whether the refund should be synchronized with NetSuite. Only available if you have installed the [Zuora Connector for NetSuite](https://www.zuora.com/connect/app/?appId&#x3D;265).  |  [optional] |



## Enum: GatewayStateEnum

| Name | Value |
|---- | -----|
| MARKEDFORSUBMISSION | &quot;MarkedForSubmission&quot; |
| SUBMITTED | &quot;Submitted&quot; |
| SETTLED | &quot;Settled&quot; |
| NOTSUBMITTED | &quot;NotSubmitted&quot; |
| FAILEDTOSETTLE | &quot;FailedToSettle&quot; |



## Enum: MethodTypeEnum

| Name | Value |
|---- | -----|
| ACH | &quot;ACH&quot; |
| CASH | &quot;Cash&quot; |
| CHECK | &quot;Check&quot; |
| CREDITCARD | &quot;CreditCard&quot; |
| PAYPAL | &quot;PayPal&quot; |
| WIRETRANSFER | &quot;WireTransfer&quot; |
| DEBITCARD | &quot;DebitCard&quot; |
| CREDITCARDREFERENCETRANSACTION | &quot;CreditCardReferenceTransaction&quot; |
| BANKTRANSFER | &quot;BankTransfer&quot; |
| OTHER | &quot;Other&quot; |



## Enum: StatusEnum

| Name | Value |
|---- | -----|
| PROCESSED | &quot;Processed&quot; |
| CANCELED | &quot;Canceled&quot; |
| ERROR | &quot;Error&quot; |
| PROCESSING | &quot;Processing&quot; |



## Enum: TypeEnum

| Name | Value |
|---- | -----|
| EXTERNAL | &quot;External&quot; |
| ELECTRONIC | &quot;Electronic&quot; |



