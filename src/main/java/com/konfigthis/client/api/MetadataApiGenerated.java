/*
 * API Reference
 *   # Introduction  Welcome to the REST API reference for the Zuora Billing, Payments, and Central Platform!  To learn about the common use cases of Zuora REST APIs, check out the [REST API Tutorials](https://developer.zuora.com/rest-api/api-guides/overview/).  In addition to Zuora API Reference, we also provide API references for other Zuora products:    * [Revenue API Reference](https://developer.zuora.com/api-references/revenue/overview/)   * [Collections API Reference](https://developer.zuora.com/api-references/collections/overview/)        The Zuora REST API provides a broad set of operations and resources that:    * Enable Web Storefront integration from your website.   * Support self-service subscriber sign-ups and account management.   * Process revenue schedules through custom revenue rule models.   * Enable manipulation of most objects in the Zuora Billing Object Model.  Want to share your opinion on how our API works for you? <a href=\"https://community.zuora.com/t5/Developers/API-Feedback-Form/gpm-p/21399\" target=\"_blank\">Tell us how you feel </a>about using our API and what we can do to make it better.  Some of our older APIs are no longer recommended but still available, not affecting any existing integration. To find related API documentation, see [Older API Reference](https://developer.zuora.com/api-references/older-api/overview/).   ## Access to the API  If you have a Zuora tenant, you can access the Zuora REST API via one of the following endpoints:  | Tenant              | Base URL for REST Endpoints | |-------------------------|-------------------------| |US Cloud 1 Production | https://rest.na.zuora.com  | |US Cloud 1 API Sandbox |  https://rest.sandbox.na.zuora.com | |US Cloud 2 Production | https://rest.zuora.com | |US Cloud 2 API Sandbox | https://rest.apisandbox.zuora.com| |US Central Sandbox | https://rest.test.zuora.com |   |US Performance Test | https://rest.pt1.zuora.com | |US Production Copy | Submit a request at <a href=\"http://support.zuora.com/\" target=\"_blank\">Zuora Global Support</a> to enable the Zuora REST API in your tenant and obtain the base URL for REST endpoints. See [REST endpoint base URL of Production Copy (Service) Environment for existing and new customers](https://community.zuora.com/t5/API/REST-endpoint-base-URL-of-Production-Copy-Service-Environment/td-p/29611) for more information. | |EU Production | https://rest.eu.zuora.com | |EU API Sandbox | https://rest.sandbox.eu.zuora.com | |EU Central Sandbox | https://rest.test.eu.zuora.com |  The Production endpoint provides access to your live user data. Sandbox tenants are a good place to test code without affecting real-world data. If you would like Zuora to provision a Sandbox tenant for you, contact your Zuora representative for assistance.   If you do not have a Zuora tenant, go to <a href=\"https://www.zuora.com/resource/zuora-test-drive\" target=\"_blank\">https://www.zuora.com/resource/zuora-test-drive</a> and sign up for a Production Test Drive tenant. The tenant comes with seed data, including a sample product catalog.   # Error Handling  If a request to Zuora Billing REST API with an endpoint starting with `/v1` (except [Actions](https://developer.zuora.com/api-references/api/tag/Actions) and CRUD operations) fails, the response will contain an eight-digit error code with a corresponding error message to indicate the details of the error.  The following code snippet is a sample error response that contains an error code and message pair:  ```  {    \"success\": false,    \"processId\": \"CBCFED6580B4E076\",    \"reasons\":  [      {       \"code\": 53100320,       \"message\": \"'termType' value should be one of: TERMED, EVERGREEN\"      }     ]  } ``` The `success` field indicates whether the API request has succeeded. The `processId` field is a Zuora internal ID that you can provide to Zuora Global Support for troubleshooting purposes.  The `reasons` field contains the actual error code and message pair. The error code begins with `5` or `6` means that you encountered a certain issue that is specific to a REST API resource in Zuora Billing, Payments, and Central Platform. For example, `53100320` indicates that an invalid value is specified for the `termType` field of the `subscription` object.  The error code beginning with `9` usually indicates that an authentication-related issue occurred, and it can also indicate other unexpected errors depending on different cases. For example, `90000011` indicates that an invalid credential is provided in the request header.   When troubleshooting the error, you can divide the error code into two components: REST API resource code and error category code. See the following Zuora error code sample:  <a href=\"https://developer.zuora.com/images/ZuoraErrorCode.jpeg\" target=\"_blank\"><img src=\"https://developer.zuora.com/images/ZuoraErrorCode.jpeg\" alt=\"Zuora Error Code Sample\"></a>   **Note:** Zuora determines resource codes based on the request payload. Therefore, if GET and DELETE requests that do not contain payloads fail, you will get `500000` as the resource code, which indicates an unknown object and an unknown field.  The error category code of these requests is valid and follows the rules described in the [Error Category Codes](https://developer.zuora.com/api-references/api/overview/#section/Error-Handling/Error-Category-Codes) section.  In such case, you can refer to the returned error message to troubleshoot.   ## REST API Resource Codes  The 6-digit resource code indicates the REST API resource, typically a field of a Zuora object, on which the issue occurs. In the preceding example, `531003` refers to the `termType` field of the `subscription` object.   The value range for all REST API resource codes is from `500000` to `679999`. See <a href=\"https://knowledgecenter.zuora.com/Central_Platform/API/AA_REST_API/Resource_Codes\" target=\"_blank\">Resource Codes</a> in the Knowledge Center for a full list of resource codes.  ## Error Category Codes  The 2-digit error category code identifies the type of error, for example, resource not found or missing required field.   The following table describes all error categories and the corresponding resolution:  | Code    | Error category              | Description    | Resolution    | |:--------|:--------|:--------|:--------| | 10      | Permission or access denied | The request cannot be processed because a certain tenant or user permission is missing. | Check the missing tenant or user permission in the response message and contact <a href=\"https://support.zuora.com\" target=\"_blank\">Zuora Global Support</a> for enablement. | | 11      | Authentication failed       | Authentication fails due to invalid API authentication credentials. | Ensure that a valid API credential is specified. | | 20      | Invalid format or value     | The request cannot be processed due to an invalid field format or value. | Check the invalid field in the error message, and ensure that the format and value of all fields you passed in are valid. | | 21      | Unknown field in request    | The request cannot be processed because an unknown field exists in the request body. | Check the unknown field name in the response message, and ensure that you do not include any unknown field in the request body. | | 22      | Missing required field      | The request cannot be processed because a required field in the request body is missing. | Check the missing field name in the response message, and ensure that you include all required fields in the request body. | | 23      | Missing required parameter  | The request cannot be processed because a required query parameter is missing. | Check the missing parameter name in the response message, and ensure that you include the parameter in the query. | | 30      | Rule restriction            | The request cannot be processed due to the violation of a Zuora business rule. | Check the response message and ensure that the API request meets the specified business rules. | | 40      | Not found                   | The specified resource cannot be found. | Check the response message and ensure that the specified resource exists in your Zuora tenant. | | 45      | Unsupported request         | The requested endpoint does not support the specified HTTP method. | Check your request and ensure that the endpoint and method matches. | | 50      | Locking contention          | This request cannot be processed because the objects this request is trying to modify are being modified by another API request, UI operation, or batch job process. | <p>Resubmit the request first to have another try.</p> <p>If this error still occurs, contact <a href=\"https://support.zuora.com\" target=\"_blank\">Zuora Global Support</a> with the returned `Zuora-Request-Id` value in the response header for assistance.</p> | | 60      | Internal error              | The server encounters an internal error. | Contact <a href=\"https://support.zuora.com\" target=\"_blank\">Zuora Global Support</a> with the returned `Zuora-Request-Id` value in the response header for assistance. | | 61      | Temporary error             | A temporary error occurs during request processing, for example, a database communication error. | <p>Resubmit the request first to have another try.</p> <p>If this error still occurs, contact <a href=\"https://support.zuora.com\" target=\"_blank\">Zuora Global Support</a> with the returned `Zuora-Request-Id` value in the response header for assistance. </p>| | 70      | Request exceeded limit      | The total number of concurrent requests exceeds the limit allowed by the system. | <p>Resubmit the request after the number of seconds specified by the `Retry-After` value in the response header.</p> <p>Check [Concurrent request limits](https://developer.zuora.com/rest-api/general-concepts/rate-concurrency-limits/) for details about Zuora’s concurrent request limit policy.</p> | | 90      | Malformed request           | The request cannot be processed due to JSON syntax errors. | Check the syntax error in the JSON request body and ensure that the request is in the correct JSON format. | | 99      | Integration error           | The server encounters an error when communicating with an external system, for example, payment gateway, tax engine provider. | Check the response message and take action accordingly. |   # API Versions  The Zuora REST API are version controlled. Versioning ensures that Zuora REST API changes are backward compatible. Zuora uses a major and minor version nomenclature to manage changes. By specifying a version in a REST request, you can get expected responses regardless of future changes to the API.   ## Major Version   The major version number of the REST API appears in the REST URL. In this API reference, only the **v1** major version is available. For example, `POST https://rest.zuora.com/v1/subscriptions`.       Zuora also offers the [Quickstart API](https://developer.zuora.com/quickstart-api/quickstart-api-introduction/) that uses the **v2** major version. For more information about which version to use, see [Which API Should I Use](https://developer.zuora.com/api-reference-guide/).   ## Minor Version   Zuora uses minor versions for the REST API to control small changes. For example, a field in a REST method is deprecated and a new field is used to replace it.    Some fields in the REST methods are supported as of minor versions. If a field is not noted with a minor version, this field is available for all minor versions. If a field is noted with a minor version, this field is in version control. You must specify the supported minor version in the request header to process without an error.   If a field is in version control, it is either with a minimum minor version or a maximum minor version, or both of them. You can only use this field with the minor version between the minimum and the maximum minor versions. For example, the `invoiceCollect` field in the POST Subscription method is in version control and its maximum minor version is 189.0. You can only use this field with the minor version 189.0 or earlier.  If you specify a version number in the request header that is not supported, Zuora will use the minimum minor version of the REST API. In our REST API documentation, if a field or feature requires a minor version number, we note that in the field description.  You only need to specify the version number when you use the fields require a minor version. To specify the minor version, set the `zuora-version` parameter to the minor version number in the request header for the request call. For example, the `collect` field is in 196.0 minor version. If you want to use this field for the POST Subscription method, set the  `zuora-version` parameter to `196.0` in the request header. The `zuora-version` parameter is case sensitive.  For all the REST API fields, by default, if the minor version is not specified in the request header, Zuora will use the minimum minor version of the REST API to avoid breaking your integration.   ### Minor Version History  The supported minor versions are not consecutive.  You can use the following versions to override the default version (`186.0`):   - 187.0   - 188.0   - 189.0   - 196.0   - 206.0   - 207.0   - 211.0   - 214.0   - 215.0   - 216.0   - 223.0   - 224.0   - 230.0   - 239.0   - 256.0   - 257.0   - 309.0   - 314.0   - 315.0   - 329.0   - 330.0   - 336.0   - 337.0   - 338.0   - 341.0  If you set the `zuora-version` header to a version excluded from the preceding list, the corresponding API request is processed as you use the default version, `186.0`.  The following table lists the supported versions and the fields that have a Zuora REST API minor version.  | Fields         | Minor Version      | REST Methods    | Description | |:--------|:--------|:--------|:--------| | invoiceCollect | 189.0 and earlier  | [Create Subscription](https://developer.zuora.com/api-references/api/operation/POST_Subscription \"Create Subscription\"); [Update Subscription](https://developer.zuora.com/api-references/api/operation/PUT_Subscription \"Update Subscription\"); [Renew Subscription](https://developer.zuora.com/api-references/api/operation/PUT_RenewSubscription \"Renew Subscription\"); [Cancel Subscription](https://developer.zuora.com/api-references/api/operation/PUT_CancelSubscription \"Cancel Subscription\"); [Suspend Subscription](https://developer.zuora.com/api-references/api/operation/PUT_SuspendSubscription \"Suspend Subscription\"); [Resume Subscription](https://developer.zuora.com/api-references/api/operation/PUT_ResumeSubscription \"Resume Subscription\"); [Create Account](https://developer.zuora.com/api-references/api/operation/POST_Account \"Create Account\")|Generates an invoice and collects a payment for a subscription. | | collect        | 196.0 and later    | [Create Subscription](https://developer.zuora.com/api-references/api/operation/POST_Subscription \"Create Subscription\"); [Update Subscription](https://developer.zuora.com/api-references/api/operation/PUT_Subscription \"Update Subscription\"); [Renew Subscription](https://developer.zuora.com/api-references/api/operation/PUT_RenewSubscription \"Renew Subscription\"); [Cancel Subscription](https://developer.zuora.com/api-references/api/operation/PUT_CancelSubscription \"Cancel Subscription\"); [Suspend Subscription](https://developer.zuora.com/api-references/api/operation/PUT_SuspendSubscription \"Suspend Subscription\"); [Resume Subscription](https://developer.zuora.com/api-references/api/operation/PUT_ResumeSubscription \"Resume Subscription\"); [Create Account](https://developer.zuora.com/api-references/api/operation/POST_Account \"Create Account\")|Collects an automatic payment for a subscription. | | invoice | 196.0 and 207.0| [Create Subscription](https://developer.zuora.com/api-references/api/operation/POST_Subscription \"Create Subscription\"); [Update Subscription](https://developer.zuora.com/api-references/api/operation/PUT_Subscription \"Update Subscription\"); [Renew Subscription](https://developer.zuora.com/api-references/api/operation/PUT_RenewSubscription \"Renew Subscription\"); [Cancel Subscription](https://developer.zuora.com/api-references/api/operation/PUT_CancelSubscription \"Cancel Subscription\"); [Suspend Subscription](https://developer.zuora.com/api-references/api/operation/PUT_SuspendSubscription \"Suspend Subscription\"); [Resume Subscription](https://developer.zuora.com/api-references/api/operation/PUT_ResumeSubscription \"Resume Subscription\"); [Create Account](https://developer.zuora.com/api-references/api/operation/POST_Account \"Create Account\")|Generates an invoice for a subscription. | | invoiceTargetDate | 206.0 and earlier  | [Preview Subscription](https://developer.zuora.com/api-references/api/operation/POST_PreviewSubscription \"Preview Subscription\") |Date through which charges are calculated on the invoice, as `yyyy-mm-dd`. | | invoiceTargetDate | 207.0 and earlier  | [Create Subscription](https://developer.zuora.com/api-references/api/operation/POST_Subscription \"Create Subscription\"); [Update Subscription](https://developer.zuora.com/api-references/api/operation/PUT_Subscription \"Update Subscription\"); [Renew Subscription](https://developer.zuora.com/api-references/api/operation/PUT_RenewSubscription \"Renew Subscription\"); [Cancel Subscription](https://developer.zuora.com/api-references/api/operation/PUT_CancelSubscription \"Cancel Subscription\"); [Suspend Subscription](https://developer.zuora.com/api-references/api/operation/PUT_SuspendSubscription \"Suspend Subscription\"); [Resume Subscription](https://developer.zuora.com/api-references/api/operation/PUT_ResumeSubscription \"Resume Subscription\"); [Create Account](https://developer.zuora.com/api-references/api/operation/POST_Account \"Create Account\")|Date through which charges are calculated on the invoice, as `yyyy-mm-dd`. | | targetDate | 207.0 and later | [Preview Subscription](https://developer.zuora.com/api-references/api/operation/POST_PreviewSubscription \"Preview Subscription\") |Date through which charges are calculated on the invoice, as `yyyy-mm-dd`. | | targetDate | 211.0 and later | [Create Subscription](https://developer.zuora.com/api-references/api/operation/POST_Subscription \"Create Subscription\"); [Update Subscription](https://developer.zuora.com/api-references/api/operation/PUT_Subscription \"Update Subscription\"); [Renew Subscription](https://developer.zuora.com/api-references/api/operation/PUT_RenewSubscription \"Renew Subscription\"); [Cancel Subscription](https://developer.zuora.com/api-references/api/operation/PUT_CancelSubscription \"Cancel Subscription\"); [Suspend Subscription](https://developer.zuora.com/api-references/api/operation/PUT_SuspendSubscription \"Suspend Subscription\"); [Resume Subscription](https://developer.zuora.com/api-references/api/operation/PUT_ResumeSubscription \"Resume Subscription\"); [Create Account](https://developer.zuora.com/api-references/api/operation/POST_Account \"Create Account\")|Date through which charges are calculated on the invoice, as `yyyy-mm-dd`. | | includeExisting DraftInvoiceItems | 206.0 and earlier| [Preview Subscription](https://developer.zuora.com/api-references/api/operation/POST_PreviewSubscription \"Preview Subscription\"); [Update Subscription](https://developer.zuora.com/api-references/api/operation/PUT_Subscription \"Update Subscription\") | Specifies whether to include draft invoice items in subscription previews. Specify it to be `true` (default) to include draft invoice items in the preview result. Specify it to be `false` to excludes draft invoice items in the preview result. | | includeExisting DraftDocItems | 207.0 and later  | [Preview Subscription](https://developer.zuora.com/api-references/api/operation/POST_PreviewSubscription \"Preview Subscription\"); [Update Subscription](https://developer.zuora.com/api-references/api/operation/PUT_Subscription \"Update Subscription\") | Specifies whether to include draft invoice items in subscription previews. Specify it to be `true` (default) to include draft invoice items in the preview result. Specify it to be `false` to excludes draft invoice items in the preview result. | | previewType | 206.0 and earlier| [Preview Subscription](https://developer.zuora.com/api-references/api/operation/POST_PreviewSubscription \"Preview Subscription\"); [Update Subscription](https://developer.zuora.com/api-references/api/operation/PUT_Subscription \"Update Subscription\") | The type of preview you will receive. The possible values are `InvoiceItem`(default), `ChargeMetrics`, and `InvoiceItemChargeMetrics`. | | previewType | 207.0 and later  | [Preview Subscription](https://developer.zuora.com/api-references/api/operation/POST_PreviewSubscription \"Preview Subscription\"); [Update Subscription](https://developer.zuora.com/api-references/api/operation/PUT_Subscription \"Update Subscription\") | The type of preview you will receive. The possible values are `LegalDoc`(default), `ChargeMetrics`, and `LegalDocChargeMetrics`. | | runBilling  | 211.0 and later  | [Create Subscription](https://developer.zuora.com/api-references/api/operation/POST_Subscription \"Create Subscription\"); [Update Subscription](https://developer.zuora.com/api-references/api/operation/PUT_Subscription \"Update Subscription\"); [Renew Subscription](https://developer.zuora.com/api-references/api/operation/PUT_RenewSubscription \"Renew Subscription\"); [Cancel Subscription](https://developer.zuora.com/api-references/api/operation/PUT_CancelSubscription \"Cancel Subscription\"); [Suspend Subscription](https://developer.zuora.com/api-references/api/operation/PUT_SuspendSubscription \"Suspend Subscription\"); [Resume Subscription](https://developer.zuora.com/api-references/api/operation/PUT_ResumeSubscription \"Resume Subscription\"); [Create Account](https://developer.zuora.com/api-references/api/operation/POST_Account \"Create Account\")|Generates an invoice or credit memo for a subscription. **Note:** Credit memos are only available if you have the Invoice Settlement feature enabled. | | invoiceDate | 214.0 and earlier  | [Invoice and Collect](https://developer.zuora.com/api-references/api/operation/POST_TransactionInvoicePayment \"Invoice and Collect\") |Date that should appear on the invoice being generated, as `yyyy-mm-dd`. | | invoiceTargetDate | 214.0 and earlier  | [Invoice and Collect](https://developer.zuora.com/api-references/api/operation/POST_TransactionInvoicePayment \"Invoice and Collect\") |Date through which to calculate charges on this account if an invoice is generated, as `yyyy-mm-dd`. | | documentDate | 215.0 and later | [Invoice and Collect](https://developer.zuora.com/api-references/api/operation/POST_TransactionInvoicePayment \"Invoice and Collect\") |Date that should appear on the invoice and credit memo being generated, as `yyyy-mm-dd`. | | targetDate | 215.0 and later | [Invoice and Collect](https://developer.zuora.com/api-references/api/operation/POST_TransactionInvoicePayment \"Invoice and Collect\") |Date through which to calculate charges on this account if an invoice or a credit memo is generated, as `yyyy-mm-dd`. | | memoItemAmount | 223.0 and earlier | [Create credit memo from charge](https://developer.zuora.com/api-references/api/operation/POST_CreditMemoFromPrpc \"Create credit memo from charge\"); [Create debit memo from charge](https://developer.zuora.com/api-references/api/operation/POST_DebitMemoFromPrpc \"Create debit memo from charge\") | Amount of the memo item. | | amount | 224.0 and later | [Create credit memo from charge](https://developer.zuora.com/api-references/api/operation/POST_CreditMemoFromPrpc \"Create credit memo from charge\"); [Create debit memo from charge](https://developer.zuora.com/api-references/api/operation/POST_DebitMemoFromPrpc \"Create debit memo from charge\") | Amount of the memo item. | | subscriptionNumbers | 222.4 and earlier | [Create order](https://developer.zuora.com/api-references/api/operation/POST_Order \"Create order\") | Container for the subscription numbers of the subscriptions in an order. | | subscriptions | 223.0 and later | [Create order](https://developer.zuora.com/api-references/api/operation/POST_Order \"Create order\") | Container for the subscription numbers and statuses in an order. | | creditTaxItems | 238.0 and earlier | [Get credit memo items](https://developer.zuora.com/api-references/api/operation/GET_CreditMemoItems \"Get credit memo items\"); [Get credit memo item](https://developer.zuora.com/api-references/api/operation/GET_CreditMemoItem \"Get credit memo item\") | Container for the taxation items of the credit memo item. | | taxItems | 238.0 and earlier | [Get debit memo items](https://developer.zuora.com/api-references/api/operation/GET_DebitMemoItems \"Get debit memo items\"); [Get debit memo item](https://developer.zuora.com/api-references/api/operation/GET_DebitMemoItem \"Get debit memo item\") | Container for the taxation items of the debit memo item. | | taxationItems | 239.0 and later | [Get credit memo items](https://developer.zuora.com/api-references/api/operation/GET_CreditMemoItems \"Get credit memo items\"); [Get credit memo item](https://developer.zuora.com/api-references/api/operation/GET_CreditMemoItem \"Get credit memo item\"); [Get debit memo items](https://developer.zuora.com/api-references/api/operation/GET_DebitMemoItems \"Get debit memo items\"); [Get debit memo item](https://developer.zuora.com/api-references/api/operation/GET_DebitMemoItem \"Get debit memo item\") | Container for the taxation items of the memo item. | | chargeId | 256.0 and earlier | [Create credit memo from charge](https://developer.zuora.com/api-references/api/operation/POST_CreditMemoFromPrpc \"Create credit memo from charge\"); [Create debit memo from charge](https://developer.zuora.com/api-references/api/operation/POST_DebitMemoFromPrpc \"Create debit memo from charge\") | ID of the product rate plan charge that the memo is created from. | | productRatePlanChargeId | 257.0 and later | [Create credit memo from charge](https://developer.zuora.com/api-references/api/operation/POST_CreditMemoFromPrpc \"Create credit memo from charge\"); [Create debit memo from charge](https://developer.zuora.com/api-references/api/operation/POST_DebitMemoFromPrpc \"Create debit memo from charge\") | ID of the product rate plan charge that the memo is created from. | | comment | 256.0 and earlier | [Create credit memo from charge](https://developer.zuora.com/api-references/api/operation/POST_CreditMemoFromPrpc \"Create credit memo from charge\"); [Create debit memo from charge](https://developer.zuora.com/api-references/api/operation/POST_DebitMemoFromPrpc \"Create debit memo from charge\"); [Create credit memo from invoice](https://developer.zuora.com/api-references/api/operation/POST_CreditMemoFromInvoice \"Create credit memo from invoice\"); [Create debit memo from invoice](https://developer.zuora.com/api-references/api/operation/POST_DebitMemoFromInvoice \"Create debit memo from invoice\"); [Get credit memo items](https://developer.zuora.com/api-references/api/operation/GET_CreditMemoItems \"Get credit memo items\"); [Get credit memo item](https://developer.zuora.com/api-references/api/operation/GET_CreditMemoItem \"Get credit memo item\"); [Get debit memo items](https://developer.zuora.com/api-references/api/operation/GET_DebitMemoItems \"Get debit memo items\"); [Get debit memo item](https://developer.zuora.com/api-references/api/operation/GET_DebitMemoItem \"Get debit memo item\") | Comments about the product rate plan charge, invoice item, or memo item. | | description | 257.0 and later | [Create credit memo from charge](https://developer.zuora.com/api-references/api/operation/POST_CreditMemoFromPrpc \"Create credit memo from charge\"); [Create debit memo from charge](https://developer.zuora.com/api-references/api/operation/POST_DebitMemoFromPrpc \"Create debit memo from charge\"); [Create credit memo from invoice](https://developer.zuora.com/api-references/api/operation/POST_CreditMemoFromInvoice \"Create credit memo from invoice\"); [Create debit memo from invoice](https://developer.zuora.com/api-references/api/operation/POST_DebitMemoFromInvoice \"Create debit memo from invoice\"); [Get credit memo items](https://developer.zuora.com/api-references/api/operation/GET_CreditMemoItems \"Get credit memo items\"); [Get credit memo item](https://developer.zuora.com/api-references/api/operation/GET_CreditMemoItem \"Get credit memo item\"); [Get debit memo items](https://developer.zuora.com/api-references/api/operation/GET_DebitMemoItems \"Get debit memo items\"); [Get debit memo item](https://developer.zuora.com/api-references/api/operation/GET_DebitMemoItem \"Get debit memo item\") | Description of the the product rate plan charge, invoice item, or memo item. | | taxationItems | 309.0 and later | [Preview an order](https://developer.zuora.com/api-references/api/operation/POST_PreviewOrder \"Preview an order\") | List of taxation items for an invoice item or a credit memo item. | | batch | 309.0 and earlier | [Create a billing preview run](https://developer.zuora.com/api-references/api/operation/POST_BillingPreviewRun \"Create a billing preview run\") | The customer batches to include in the billing preview run. |       | batches | 314.0 and later | [Create a billing preview run](https://developer.zuora.com/api-references/api/operation/POST_BillingPreviewRun \"Create a billing preview run\") | The customer batches to include in the billing preview run. | | taxationItems | 315.0 and later | [Preview a subscription](https://developer.zuora.com/api-references/api/operation/POST_PreviewSubscription \"Preview a subscription\"); [Update a subscription](https://developer.zuora.com/api-references/api/operation/PUT_Subscription \"Update a subscription\")| List of taxation items for an invoice item or a credit memo item. | | billingDocument | 330.0 and later | [Create a payment schedule](https://developer.zuora.com/api-references/api/operation/POST_PaymentSchedule \"Create a payment schedule\"); [Create multiple payment schedules at once](https://developer.zuora.com/api-references/api/operation/POST_PaymentSchedules \"Create multiple payment schedules at once\")| The billing document with which the payment schedule item is associated. | | paymentId | 336.0 and earlier | [Add payment schedule items to a custom payment schedule](https://developer.zuora.com/api-references/api/operation/POST_AddItemsToCustomPaymentSchedule/ \"Add payment schedule items to a custom payment schedule\"); [Update a payment schedule](https://developer.zuora.com/api-references/api/operation/PUT_PaymentSchedule/ \"Update a payment schedule\"); [Update a payment schedule item](https://developer.zuora.com/api-references/api/operation/PUT_PaymentScheduleItem/ \"Update a payment schedule item\"); [Preview the result of payment schedule update](https://developer.zuora.com/api-references/api/operation/PUT_PaymentScheduleUpdatePreview/ \"Preview the result of payment schedule update\"); [Retrieve a payment schedule](https://developer.zuora.com/api-references/api/operation/GET_PaymentSchedule/ \"Retrieve a payment schedule\"); [Retrieve a payment schedule item](https://developer.zuora.com/api-references/api/operation/GET_PaymentScheduleItem/ \"Retrieve a payment schedule item\"); [List payment schedules by customer account](https://developer.zuora.com/api-references/api/operation/GET_PaymentSchedules/ \"List payment schedules by customer account\"); [Cancel a payment schedule](https://developer.zuora.com/api-references/api/operation/PUT_CancelPaymentSchedule/ \"Cancel a payment schedule\"); [Cancel a payment schedule item](https://developer.zuora.com/api-references/api/operation/PUT_CancelPaymentScheduleItem/ \"Cancel a payment schedule item\");[Skip a payment schedule item](https://developer.zuora.com/api-references/api/operation/PUT_SkipPaymentScheduleItem/ \"Skip a payment schedule item\");[Retry failed payment schedule items](https://developer.zuora.com/api-references/api/operation/POST_RetryPaymentScheduleItem/ \"Retry failed payment schedule items\") | ID of the payment to be linked to the payment schedule item.   #### Version 207.0 and Later  The response structure of the [Preview Subscription](https://developer.zuora.com/api-references/api/operation/POST_PreviewSubscription) and [Update Subscription](https://developer.zuora.com/api-references/api/operation/PUT_Subscription \"Update Subscription\") methods are changed. The following invoice related response fields are moved to the invoice container:    * amount   * amountWithoutTax   * taxAmount   * invoiceItems   * targetDate   * chargeMetrics   # API Names for Zuora Objects  For information about the Zuora business object model, see [Zuora Business Object Model](https://developer.zuora.com/rest-api/general-concepts/object-model/).  You can use the [Describe](https://developer.zuora.com/api-references/api/operation/GET_Describe) operation to list the fields of each Zuora object that is available in your tenant. When you call the operation, you must specify the API name of the Zuora object.  The following table provides the API name of each Zuora object:  | Object                                        | API Name                                   | |-----------------------------------------------|--------------------------------------------| | Account                                       | `Account`                                  | | Accounting Code                               | `AccountingCode`                           | | Accounting Period                             | `AccountingPeriod`                         | | Amendment                                     | `Amendment`                                | | Application Group                             | `ApplicationGroup`                         | | Billing Run                                   | <p>`BillingRun` - API name used  in the [Describe](https://developer.zuora.com/api-references/api/operation/GET_Describe) operation, Export ZOQL queries, and Data Query.</p> <p>`BillRun` - API name used in the [Actions](https://developer.zuora.com/api-references/api/tag/Actions). See the CRUD oprations of [Bill Run](https://developer.zuora.com/api-references/api/tag/Bill-Run) for more information about the `BillRun` object. `BillingRun` and `BillRun` have different fields. |                      | Billing Preview Run                           | `BillingPreviewRun`                        |                      | Configuration Templates                       | `ConfigurationTemplates`                   | | Contact                                       | `Contact`                                  | | Contact Snapshot                              | `ContactSnapshot`                          | | Credit Balance Adjustment                     | `CreditBalanceAdjustment`                  | | Credit Memo                                   | `CreditMemo`                               | | Credit Memo Application                       | `CreditMemoApplication`                    | | Credit Memo Application Item                  | `CreditMemoApplicationItem`                | | Credit Memo Item                              | `CreditMemoItem`                           | | Credit Memo Part                              | `CreditMemoPart`                           | | Credit Memo Part Item                         | `CreditMemoPartItem`                       | | Credit Taxation Item                          | `CreditTaxationItem`                       | | Custom Exchange Rate                          | `FXCustomRate`                             | | Debit Memo                                    | `DebitMemo`                                | | Debit Memo Item                               | `DebitMemoItem`                            | | Debit Taxation Item                           | `DebitTaxationItem`                        | | Discount Applied Metrics                      | `DiscountAppliedMetrics`                   | | Entity                                        | `Tenant`                                   | | Fulfillment                                   | `Fulfillment`                              | | Feature                                       | `Feature`                                  | | Gateway Reconciliation Event                  | `PaymentGatewayReconciliationEventLog`     | | Gateway Reconciliation Job                    | `PaymentReconciliationJob`                 | | Gateway Reconciliation Log                    | `PaymentReconciliationLog`                 | | Invoice                                       | `Invoice`                                  | | Invoice Adjustment                            | `InvoiceAdjustment`                        | | Invoice Item                                  | `InvoiceItem`                              | | Invoice Item Adjustment                       | `InvoiceItemAdjustment`                    | | Invoice Payment                               | `InvoicePayment`                           | | Invoice Schedule                              | `InvoiceSchedule`                          | | Invoice Schedule Item                         | `InvoiceScheduleItem`                      | | Journal Entry                                 | `JournalEntry`                             | | Journal Entry Item                            | `JournalEntryItem`                         | | Journal Run                                   | `JournalRun`                               | | Notification History - Callout                | `CalloutHistory`                           | | Notification History - Email                  | `EmailHistory`                             | | Order                                         | `Order`                                    | | Order Action                                  | `OrderAction`                              | | Order ELP                                     | `OrderElp`                                 | | Order Line Items                              | `OrderLineItems`                           |     | Order Item                                    | `OrderItem`                                | | Order MRR                                     | `OrderMrr`                                 | | Order Quantity                                | `OrderQuantity`                            | | Order TCB                                     | `OrderTcb`                                 | | Order TCV                                     | `OrderTcv`                                 | | Payment                                       | `Payment`                                  | | Payment Application                           | `PaymentApplication`                       | | Payment Application Item                      | `PaymentApplicationItem`                   | | Payment Method                                | `PaymentMethod`                            | | Payment Method Snapshot                       | `PaymentMethodSnapshot`                    | | Payment Method Transaction Log                | `PaymentMethodTransactionLog`              | | Payment Method Update                        | `UpdaterDetail`                             | | Payment Part                                  | `PaymentPart`                              | | Payment Part Item                             | `PaymentPartItem`                          | | Payment Run                                   | `PaymentRun`                               | | Payment Transaction Log                       | `PaymentTransactionLog`                    | | Processed Usage                               | `ProcessedUsage`                           | | Product                                       | `Product`                                  | | Product Charge Definition                     | `ProductChargeDefinition`                  |     | Product Feature                               | `ProductFeature`                           | | Product Rate Plan                             | `ProductRatePlan`                          | | Product Rate Plan Definition                  | `ProductRatePlanDefinition`                |     | Product Rate Plan Charge                      | `ProductRatePlanCharge`                    | | Product Rate Plan Charge Tier                 | `ProductRatePlanChargeTier`                | | Rate Plan                                     | `RatePlan`                                 | | Rate Plan Charge                              | `RatePlanCharge`                           | | Rate Plan Charge Tier                         | `RatePlanChargeTier`                       | | Refund                                        | `Refund`                                   | | Refund Application                            | `RefundApplication`                        | | Refund Application Item                       | `RefundApplicationItem`                    | | Refund Invoice Payment                        | `RefundInvoicePayment`                     | | Refund Part                                   | `RefundPart`                               | | Refund Part Item                              | `RefundPartItem`                           | | Refund Transaction Log                        | `RefundTransactionLog`                     | | Revenue Charge Summary                        | `RevenueChargeSummary`                     | | Revenue Charge Summary Item                   | `RevenueChargeSummaryItem`                 | | Revenue Event                                 | `RevenueEvent`                             | | Revenue Event Credit Memo Item                | `RevenueEventCreditMemoItem`               | | Revenue Event Debit Memo Item                 | `RevenueEventDebitMemoItem`                | | Revenue Event Invoice Item                    | `RevenueEventInvoiceItem`                  | | Revenue Event Invoice Item Adjustment         | `RevenueEventInvoiceItemAdjustment`        | | Revenue Event Item                            | `RevenueEventItem`                         | | Revenue Event Item Credit Memo Item           | `RevenueEventItemCreditMemoItem`           | | Revenue Event Item Debit Memo Item            | `RevenueEventItemDebitMemoItem`            | | Revenue Event Item Invoice Item               | `RevenueEventItemInvoiceItem`              | | Revenue Event Item Invoice Item Adjustment    | `RevenueEventItemInvoiceItemAdjustment`    | | Revenue Event Type                            | `RevenueEventType`                         | | Revenue Schedule                              | `RevenueSchedule`                          | | Revenue Schedule Credit Memo Item             | `RevenueScheduleCreditMemoItem`            | | Revenue Schedule Debit Memo Item              | `RevenueScheduleDebitMemoItem`             | | Revenue Schedule Invoice Item                 | `RevenueScheduleInvoiceItem`               | | Revenue Schedule Invoice Item Adjustment      | `RevenueScheduleInvoiceItemAdjustment`     | | Revenue Schedule Item                         | `RevenueScheduleItem`                      | | Revenue Schedule Item Credit Memo Item        | `RevenueScheduleItemCreditMemoItem`        | | Revenue Schedule Item Debit Memo Item         | `RevenueScheduleItemDebitMemoItem`         | | Revenue Schedule Item Invoice Item            | `RevenueScheduleItemInvoiceItem`           | | Revenue Schedule Item Invoice Item Adjustment | `RevenueScheduleItemInvoiceItemAdjustment` | | Subscription                                  | `Subscription`                             | | Subscription Product Feature                  | `SubscriptionProductFeature`               | | Taxable Item Snapshot                         | `TaxableItemSnapshot`                      | | Taxation Item                                 | `TaxationItem`                             | | Updater Batch                                 | `UpdaterBatch`                             | | Usage                                         | `Usage`                                    | 
 *
 * The version of the OpenAPI document: 2024-03-15
 * Contact: docs@zuora.com
 *
 * NOTE: This class is auto generated by Konfig (https://konfigthis.com).
 * Do not edit the class manually.
 */


package com.konfigthis.client.api;

import com.konfigthis.client.ApiCallback;
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.Pair;
import com.konfigthis.client.ProgressRequestBody;
import com.konfigthis.client.ProgressResponseBody;

import com.google.gson.reflect.TypeToken;

import java.io.IOException;


import com.konfigthis.client.model.DeploymentManagerResponse;
import java.io.File;
import com.konfigthis.client.model.MetadataCompareDeployProductCatalogRequest;
import com.konfigthis.client.model.MetadataCompareDeployTenantTemplateRequest;
import com.konfigthis.client.model.MetadataCompareDeployTenantToTargetRequest;
import com.konfigthis.client.model.MetadataDeployTenantTemplateRequest;
import com.konfigthis.client.model.MetadataGetDeploymentLogResponse;
import com.konfigthis.client.model.MetadataRevertDeploymentResponse;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ws.rs.core.GenericType;

public class MetadataApiGenerated {
    private ApiClient localVarApiClient;
    private int localHostIndex;
    private String localCustomBaseUrl;

    public MetadataApiGenerated() throws IllegalArgumentException {
        this(Configuration.getDefaultApiClient());
    }

    public MetadataApiGenerated(ApiClient apiClient) throws IllegalArgumentException {
        this.localVarApiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return localVarApiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.localVarApiClient = apiClient;
    }

    public int getHostIndex() {
        return localHostIndex;
    }

    public void setHostIndex(int hostIndex) {
        this.localHostIndex = hostIndex;
    }

    public String getCustomBaseUrl() {
        return localCustomBaseUrl;
    }

    public void setCustomBaseUrl(String customBaseUrl) {
        this.localCustomBaseUrl = customBaseUrl;
    }

    private okhttp3.Call compareDeployProductCatalogCall(String description, String name, Boolean sendEmail, Boolean inActiveProducts, Boolean activeProducts, Boolean activeRatePlans, Boolean inActiveRatePlans, String compareField, String sourceTenantId, MetadataCompareDeployProductCatalogRequest metadataCompareDeployProductCatalogRequest, String zuoraEntityIds, String emails, String comments, final ApiCallback _callback) throws ApiException {
        String basePath = null;
        // Operation Servers
        String[] localBasePaths = new String[] {  };

        // Determine Base Path to Use
        if (localCustomBaseUrl != null){
            basePath = localCustomBaseUrl;
        } else if ( localBasePaths.length > 0 ) {
            basePath = localBasePaths[localHostIndex];
        } else {
            basePath = null;
        }

        Object localVarPostBody = metadataCompareDeployProductCatalogRequest;

        // create path and map variables
        String localVarPath = "/deployment-manager/deployments/tenant/product_catalog";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        if (description != null) {
            localVarFormParams.put("description", description);
        }

        if (name != null) {
            localVarFormParams.put("name", name);
        }

        if (sendEmail != null) {
            localVarFormParams.put("sendEmail", sendEmail);
        }

        if (emails != null) {
            localVarFormParams.put("emails", emails);
        }

        if (comments != null) {
            localVarFormParams.put("comments", comments);
        }

        if (inActiveProducts != null) {
            localVarFormParams.put("inActiveProducts", inActiveProducts);
        }

        if (activeProducts != null) {
            localVarFormParams.put("activeProducts", activeProducts);
        }

        if (activeRatePlans != null) {
            localVarFormParams.put("activeRatePlans", activeRatePlans);
        }

        if (inActiveRatePlans != null) {
            localVarFormParams.put("inActiveRatePlans", inActiveRatePlans);
        }

        if (compareField != null) {
            localVarFormParams.put("compareField", compareField);
        }

        if (sourceTenantId != null) {
            localVarFormParams.put("sourceTenantId", sourceTenantId);
        }

        if (zuoraEntityIds != null) {
            localVarHeaderParams.put("Zuora-Entity-Ids", localVarApiClient.parameterToString(zuoraEntityIds));
        }

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = {
            "multipart/form-data"
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        if (localVarContentType != null) {
            localVarHeaderParams.put("Content-Type", localVarContentType);
        }

        String[] localVarAuthNames = new String[] {  };
        return localVarApiClient.buildCall(basePath, localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call compareDeployProductCatalogValidateBeforeCall(String description, String name, Boolean sendEmail, Boolean inActiveProducts, Boolean activeProducts, Boolean activeRatePlans, Boolean inActiveRatePlans, String compareField, String sourceTenantId, MetadataCompareDeployProductCatalogRequest metadataCompareDeployProductCatalogRequest, String zuoraEntityIds, String emails, String comments, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'description' is set
        if (description == null) {
            throw new ApiException("Missing the required parameter 'description' when calling compareDeployProductCatalog(Async)");
        }

        // verify the required parameter 'name' is set
        if (name == null) {
            throw new ApiException("Missing the required parameter 'name' when calling compareDeployProductCatalog(Async)");
        }

        // verify the required parameter 'sendEmail' is set
        if (sendEmail == null) {
            throw new ApiException("Missing the required parameter 'sendEmail' when calling compareDeployProductCatalog(Async)");
        }

        // verify the required parameter 'inActiveProducts' is set
        if (inActiveProducts == null) {
            throw new ApiException("Missing the required parameter 'inActiveProducts' when calling compareDeployProductCatalog(Async)");
        }

        // verify the required parameter 'activeProducts' is set
        if (activeProducts == null) {
            throw new ApiException("Missing the required parameter 'activeProducts' when calling compareDeployProductCatalog(Async)");
        }

        // verify the required parameter 'activeRatePlans' is set
        if (activeRatePlans == null) {
            throw new ApiException("Missing the required parameter 'activeRatePlans' when calling compareDeployProductCatalog(Async)");
        }

        // verify the required parameter 'inActiveRatePlans' is set
        if (inActiveRatePlans == null) {
            throw new ApiException("Missing the required parameter 'inActiveRatePlans' when calling compareDeployProductCatalog(Async)");
        }

        // verify the required parameter 'compareField' is set
        if (compareField == null) {
            throw new ApiException("Missing the required parameter 'compareField' when calling compareDeployProductCatalog(Async)");
        }

        // verify the required parameter 'sourceTenantId' is set
        if (sourceTenantId == null) {
            throw new ApiException("Missing the required parameter 'sourceTenantId' when calling compareDeployProductCatalog(Async)");
        }

        // verify the required parameter 'metadataCompareDeployProductCatalogRequest' is set
        if (metadataCompareDeployProductCatalogRequest == null) {
            throw new ApiException("Missing the required parameter 'metadataCompareDeployProductCatalogRequest' when calling compareDeployProductCatalog(Async)");
        }

        return compareDeployProductCatalogCall(description, name, sendEmail, inActiveProducts, activeProducts, activeRatePlans, inActiveRatePlans, compareField, sourceTenantId, metadataCompareDeployProductCatalogRequest, zuoraEntityIds, emails, comments, _callback);

    }


    private ApiResponse<DeploymentManagerResponse> compareDeployProductCatalogWithHttpInfo(String description, String name, Boolean sendEmail, Boolean inActiveProducts, Boolean activeProducts, Boolean activeRatePlans, Boolean inActiveRatePlans, String compareField, String sourceTenantId, MetadataCompareDeployProductCatalogRequest metadataCompareDeployProductCatalogRequest, String zuoraEntityIds, String emails, String comments) throws ApiException {
        okhttp3.Call localVarCall = compareDeployProductCatalogValidateBeforeCall(description, name, sendEmail, inActiveProducts, activeProducts, activeRatePlans, inActiveRatePlans, compareField, sourceTenantId, metadataCompareDeployProductCatalogRequest, zuoraEntityIds, emails, comments, null);
        Type localVarReturnType = new TypeToken<DeploymentManagerResponse>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    private okhttp3.Call compareDeployProductCatalogAsync(String description, String name, Boolean sendEmail, Boolean inActiveProducts, Boolean activeProducts, Boolean activeRatePlans, Boolean inActiveRatePlans, String compareField, String sourceTenantId, MetadataCompareDeployProductCatalogRequest metadataCompareDeployProductCatalogRequest, String zuoraEntityIds, String emails, String comments, final ApiCallback<DeploymentManagerResponse> _callback) throws ApiException {

        okhttp3.Call localVarCall = compareDeployProductCatalogValidateBeforeCall(description, name, sendEmail, inActiveProducts, activeProducts, activeRatePlans, inActiveRatePlans, compareField, sourceTenantId, metadataCompareDeployProductCatalogRequest, zuoraEntityIds, emails, comments, _callback);
        Type localVarReturnType = new TypeToken<DeploymentManagerResponse>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    public class CompareDeployProductCatalogRequestBuilder {
        private final String description;
        private final String name;
        private final Boolean sendEmail;
        private final Boolean inActiveProducts;
        private final Boolean activeProducts;
        private final Boolean activeRatePlans;
        private final Boolean inActiveRatePlans;
        private final String compareField;
        private final String sourceTenantId;
        private String zuoraEntityIds;
        private String emails;
        private String comments;

        private CompareDeployProductCatalogRequestBuilder(String description, String name, Boolean sendEmail, Boolean inActiveProducts, Boolean activeProducts, Boolean activeRatePlans, Boolean inActiveRatePlans, String compareField, String sourceTenantId) {
            this.description = description;
            this.name = name;
            this.sendEmail = sendEmail;
            this.inActiveProducts = inActiveProducts;
            this.activeProducts = activeProducts;
            this.activeRatePlans = activeRatePlans;
            this.inActiveRatePlans = inActiveRatePlans;
            this.compareField = compareField;
            this.sourceTenantId = sourceTenantId;
        }

        /**
         * Set zuoraEntityIds
         * @param zuoraEntityIds An entity ID. If you have [Zuora Multi-entity](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Multi-entity) enabled and the OAuth token is valid for more than one entity, you must use this header to specify which entity to perform the operation in. If the OAuth token is only valid for a single entity, or you do not have Zuora Multi-entity enabled, you do not need to set this header.   (optional)
         * @return CompareDeployProductCatalogRequestBuilder
         */
        public CompareDeployProductCatalogRequestBuilder zuoraEntityIds(String zuoraEntityIds) {
            this.zuoraEntityIds = zuoraEntityIds;
            return this;
        }
        
        /**
         * Set emails
         * @param emails If sendEmail parameter is set to true, comma separated values of emails can be specified. Example  email1@test.com,email2@test.com. (optional)
         * @return CompareDeployProductCatalogRequestBuilder
         */
        public CompareDeployProductCatalogRequestBuilder emails(String emails) {
            this.emails = emails;
            return this;
        }
        
        /**
         * Set comments
         * @param comments Content of the email to be sent. (optional)
         * @return CompareDeployProductCatalogRequestBuilder
         */
        public CompareDeployProductCatalogRequestBuilder comments(String comments) {
            this.comments = comments;
            return this;
        }
        
        /**
         * Build call for compareDeployProductCatalog
         * @param _callback ApiCallback API callback
         * @return Call to execute
         * @throws ApiException If fail to serialize the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td>  </td><td>  * RateLimit-Remaining - The number of requests remaining in the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Reset - The number of seconds until the quota resets for the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Content-Encoding - This header is returned if you specify the &#x60;Accept-Encoding: gzip&#x60; request header and the response contains over 1000 bytes of data. Note that only the following MIME types support gzipped responses:   - &#x60;application/json&#x60;   - &#x60;application/xml&#x60;   - &#x60;text/html&#x60;   - &#x60;text/csv&#x60;   - &#x60;text/plain&#x60;  <br>  * RateLimit-Limit - The request limit quota for the time window closest to exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Zuora-Request-Id - The Zuora internal identifier of the API call. You cannot control the value of this header.  <br>  * Zuora-Track-Id - A custom identifier for tracing the API call. If you specified a tracing identifier in the request headers, Zuora returns the same tracing identifier. Otherwise, Zuora does not set this header.  <br>  </td></tr>
         </table>
         */
        public okhttp3.Call buildCall(final ApiCallback _callback) throws ApiException {
            MetadataCompareDeployProductCatalogRequest metadataCompareDeployProductCatalogRequest = buildBodyParams();
            return compareDeployProductCatalogCall(description, name, sendEmail, inActiveProducts, activeProducts, activeRatePlans, inActiveRatePlans, compareField, sourceTenantId, metadataCompareDeployProductCatalogRequest, zuoraEntityIds, emails, comments, _callback);
        }

        private MetadataCompareDeployProductCatalogRequest buildBodyParams() {
            MetadataCompareDeployProductCatalogRequest metadataCompareDeployProductCatalogRequest = new MetadataCompareDeployProductCatalogRequest();
            metadataCompareDeployProductCatalogRequest.description(this.description);
            metadataCompareDeployProductCatalogRequest.name(this.name);
            metadataCompareDeployProductCatalogRequest.sendEmail(this.sendEmail);
            metadataCompareDeployProductCatalogRequest.emails(this.emails);
            metadataCompareDeployProductCatalogRequest.comments(this.comments);
            metadataCompareDeployProductCatalogRequest.inActiveProducts(this.inActiveProducts);
            metadataCompareDeployProductCatalogRequest.activeProducts(this.activeProducts);
            metadataCompareDeployProductCatalogRequest.activeRatePlans(this.activeRatePlans);
            metadataCompareDeployProductCatalogRequest.inActiveRatePlans(this.inActiveRatePlans);
            if (this.compareField != null)
            metadataCompareDeployProductCatalogRequest.compareField(MetadataCompareDeployProductCatalogRequest.CompareFieldEnum.fromValue(this.compareField));
            metadataCompareDeployProductCatalogRequest.sourceTenantId(this.sourceTenantId);
            return metadataCompareDeployProductCatalogRequest;
        }

        /**
         * Execute compareDeployProductCatalog request
         * @return DeploymentManagerResponse
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td>  </td><td>  * RateLimit-Remaining - The number of requests remaining in the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Reset - The number of seconds until the quota resets for the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Content-Encoding - This header is returned if you specify the &#x60;Accept-Encoding: gzip&#x60; request header and the response contains over 1000 bytes of data. Note that only the following MIME types support gzipped responses:   - &#x60;application/json&#x60;   - &#x60;application/xml&#x60;   - &#x60;text/html&#x60;   - &#x60;text/csv&#x60;   - &#x60;text/plain&#x60;  <br>  * RateLimit-Limit - The request limit quota for the time window closest to exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Zuora-Request-Id - The Zuora internal identifier of the API call. You cannot control the value of this header.  <br>  * Zuora-Track-Id - A custom identifier for tracing the API call. If you specified a tracing identifier in the request headers, Zuora returns the same tracing identifier. Otherwise, Zuora does not set this header.  <br>  </td></tr>
         </table>
         */
        public DeploymentManagerResponse execute() throws ApiException {
            MetadataCompareDeployProductCatalogRequest metadataCompareDeployProductCatalogRequest = buildBodyParams();
            ApiResponse<DeploymentManagerResponse> localVarResp = compareDeployProductCatalogWithHttpInfo(description, name, sendEmail, inActiveProducts, activeProducts, activeRatePlans, inActiveRatePlans, compareField, sourceTenantId, metadataCompareDeployProductCatalogRequest, zuoraEntityIds, emails, comments);
            return localVarResp.getResponseBody();
        }

        /**
         * Execute compareDeployProductCatalog request with HTTP info returned
         * @return ApiResponse&lt;DeploymentManagerResponse&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td>  </td><td>  * RateLimit-Remaining - The number of requests remaining in the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Reset - The number of seconds until the quota resets for the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Content-Encoding - This header is returned if you specify the &#x60;Accept-Encoding: gzip&#x60; request header and the response contains over 1000 bytes of data. Note that only the following MIME types support gzipped responses:   - &#x60;application/json&#x60;   - &#x60;application/xml&#x60;   - &#x60;text/html&#x60;   - &#x60;text/csv&#x60;   - &#x60;text/plain&#x60;  <br>  * RateLimit-Limit - The request limit quota for the time window closest to exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Zuora-Request-Id - The Zuora internal identifier of the API call. You cannot control the value of this header.  <br>  * Zuora-Track-Id - A custom identifier for tracing the API call. If you specified a tracing identifier in the request headers, Zuora returns the same tracing identifier. Otherwise, Zuora does not set this header.  <br>  </td></tr>
         </table>
         */
        public ApiResponse<DeploymentManagerResponse> executeWithHttpInfo() throws ApiException {
            MetadataCompareDeployProductCatalogRequest metadataCompareDeployProductCatalogRequest = buildBodyParams();
            return compareDeployProductCatalogWithHttpInfo(description, name, sendEmail, inActiveProducts, activeProducts, activeRatePlans, inActiveRatePlans, compareField, sourceTenantId, metadataCompareDeployProductCatalogRequest, zuoraEntityIds, emails, comments);
        }

        /**
         * Execute compareDeployProductCatalog request (asynchronously)
         * @param _callback The callback to be executed when the API call finishes
         * @return The request call
         * @throws ApiException If fail to process the API call, e.g. serializing the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td>  </td><td>  * RateLimit-Remaining - The number of requests remaining in the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Reset - The number of seconds until the quota resets for the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Content-Encoding - This header is returned if you specify the &#x60;Accept-Encoding: gzip&#x60; request header and the response contains over 1000 bytes of data. Note that only the following MIME types support gzipped responses:   - &#x60;application/json&#x60;   - &#x60;application/xml&#x60;   - &#x60;text/html&#x60;   - &#x60;text/csv&#x60;   - &#x60;text/plain&#x60;  <br>  * RateLimit-Limit - The request limit quota for the time window closest to exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Zuora-Request-Id - The Zuora internal identifier of the API call. You cannot control the value of this header.  <br>  * Zuora-Track-Id - A custom identifier for tracing the API call. If you specified a tracing identifier in the request headers, Zuora returns the same tracing identifier. Otherwise, Zuora does not set this header.  <br>  </td></tr>
         </table>
         */
        public okhttp3.Call executeAsync(final ApiCallback<DeploymentManagerResponse> _callback) throws ApiException {
            MetadataCompareDeployProductCatalogRequest metadataCompareDeployProductCatalogRequest = buildBodyParams();
            return compareDeployProductCatalogAsync(description, name, sendEmail, inActiveProducts, activeProducts, activeRatePlans, inActiveRatePlans, compareField, sourceTenantId, metadataCompareDeployProductCatalogRequest, zuoraEntityIds, emails, comments, _callback);
        }
    }

    /**
     * Compare and deploy the product catalog of a tenant to a target tenant
     * Compare and deploy the product catalog of a tenant to a target tenant. 
     * @param description Deployment&#39;s description. (required)
     * @param name Deployment&#39;s name. (required)
     * @param sendEmail Specifies if an email should be sent. (required)
     * @param inActiveProducts Specifies if inactive products needs to be migrated. (required)
     * @param activeProducts Specifies if active products needs to be migrated. (required)
     * @param activeRatePlans Specifies if active rate plans needs to be migrated. (required)
     * @param inActiveRatePlans Specifies if inactive active rate plans needs to be migrated. (required)
     * @param compareField Specifies the compare field to be using during migration. (required)
     * @param sourceTenantId Specifies the source tenant id. (required)
     * @param metadataCompareDeployProductCatalogRequest  (required)
     * @return CompareDeployProductCatalogRequestBuilder
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td>  </td><td>  * RateLimit-Remaining - The number of requests remaining in the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Reset - The number of seconds until the quota resets for the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Content-Encoding - This header is returned if you specify the &#x60;Accept-Encoding: gzip&#x60; request header and the response contains over 1000 bytes of data. Note that only the following MIME types support gzipped responses:   - &#x60;application/json&#x60;   - &#x60;application/xml&#x60;   - &#x60;text/html&#x60;   - &#x60;text/csv&#x60;   - &#x60;text/plain&#x60;  <br>  * RateLimit-Limit - The request limit quota for the time window closest to exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Zuora-Request-Id - The Zuora internal identifier of the API call. You cannot control the value of this header.  <br>  * Zuora-Track-Id - A custom identifier for tracing the API call. If you specified a tracing identifier in the request headers, Zuora returns the same tracing identifier. Otherwise, Zuora does not set this header.  <br>  </td></tr>
     </table>
     */
    public CompareDeployProductCatalogRequestBuilder compareDeployProductCatalog(String description, String name, Boolean sendEmail, Boolean inActiveProducts, Boolean activeProducts, Boolean activeRatePlans, Boolean inActiveRatePlans, String compareField, String sourceTenantId) throws IllegalArgumentException {
        if (description == null) throw new IllegalArgumentException("\"description\" is required but got null");
            

        if (name == null) throw new IllegalArgumentException("\"name\" is required but got null");
            

        if (sendEmail == null) throw new IllegalArgumentException("\"sendEmail\" is required but got null");
        if (inActiveProducts == null) throw new IllegalArgumentException("\"inActiveProducts\" is required but got null");
        if (activeProducts == null) throw new IllegalArgumentException("\"activeProducts\" is required but got null");
        if (activeRatePlans == null) throw new IllegalArgumentException("\"activeRatePlans\" is required but got null");
        if (inActiveRatePlans == null) throw new IllegalArgumentException("\"inActiveRatePlans\" is required but got null");
        if (compareField == null) throw new IllegalArgumentException("\"compareField\" is required but got null");
            

        if (sourceTenantId == null) throw new IllegalArgumentException("\"sourceTenantId\" is required but got null");
            

        return new CompareDeployProductCatalogRequestBuilder(description, name, sendEmail, inActiveProducts, activeProducts, activeRatePlans, inActiveRatePlans, compareField, sourceTenantId);
    }
    private okhttp3.Call compareDeployTenantTemplateCall(String description, String name, Boolean sendEmail, File template, MetadataCompareDeployTenantTemplateRequest metadataCompareDeployTenantTemplateRequest, String zuoraEntityIds, String emails, String comments, final ApiCallback _callback) throws ApiException {
        String basePath = null;
        // Operation Servers
        String[] localBasePaths = new String[] {  };

        // Determine Base Path to Use
        if (localCustomBaseUrl != null){
            basePath = localCustomBaseUrl;
        } else if ( localBasePaths.length > 0 ) {
            basePath = localBasePaths[localHostIndex];
        } else {
            basePath = null;
        }

        Object localVarPostBody = metadataCompareDeployTenantTemplateRequest;

        // create path and map variables
        String localVarPath = "/deployment-manager/deployments/templates";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        if (description != null) {
            localVarFormParams.put("description", description);
        }

        if (name != null) {
            localVarFormParams.put("name", name);
        }

        if (sendEmail != null) {
            localVarFormParams.put("sendEmail", sendEmail);
        }

        if (emails != null) {
            localVarFormParams.put("emails", emails);
        }

        if (comments != null) {
            localVarFormParams.put("comments", comments);
        }

        if (template != null) {
            localVarFormParams.put("template", template);
        }

        if (zuoraEntityIds != null) {
            localVarHeaderParams.put("Zuora-Entity-Ids", localVarApiClient.parameterToString(zuoraEntityIds));
        }

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = {
            "multipart/form-data"
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        if (localVarContentType != null) {
            localVarHeaderParams.put("Content-Type", localVarContentType);
        }

        String[] localVarAuthNames = new String[] {  };
        return localVarApiClient.buildCall(basePath, localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call compareDeployTenantTemplateValidateBeforeCall(String description, String name, Boolean sendEmail, File template, MetadataCompareDeployTenantTemplateRequest metadataCompareDeployTenantTemplateRequest, String zuoraEntityIds, String emails, String comments, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'description' is set
        if (description == null) {
            throw new ApiException("Missing the required parameter 'description' when calling compareDeployTenantTemplate(Async)");
        }

        // verify the required parameter 'name' is set
        if (name == null) {
            throw new ApiException("Missing the required parameter 'name' when calling compareDeployTenantTemplate(Async)");
        }

        // verify the required parameter 'sendEmail' is set
        if (sendEmail == null) {
            throw new ApiException("Missing the required parameter 'sendEmail' when calling compareDeployTenantTemplate(Async)");
        }

        // verify the required parameter 'template' is set
        if (template == null) {
            throw new ApiException("Missing the required parameter 'template' when calling compareDeployTenantTemplate(Async)");
        }

        // verify the required parameter 'metadataCompareDeployTenantTemplateRequest' is set
        if (metadataCompareDeployTenantTemplateRequest == null) {
            throw new ApiException("Missing the required parameter 'metadataCompareDeployTenantTemplateRequest' when calling compareDeployTenantTemplate(Async)");
        }

        return compareDeployTenantTemplateCall(description, name, sendEmail, template, metadataCompareDeployTenantTemplateRequest, zuoraEntityIds, emails, comments, _callback);

    }


    private ApiResponse<DeploymentManagerResponse> compareDeployTenantTemplateWithHttpInfo(String description, String name, Boolean sendEmail, File template, MetadataCompareDeployTenantTemplateRequest metadataCompareDeployTenantTemplateRequest, String zuoraEntityIds, String emails, String comments) throws ApiException {
        okhttp3.Call localVarCall = compareDeployTenantTemplateValidateBeforeCall(description, name, sendEmail, template, metadataCompareDeployTenantTemplateRequest, zuoraEntityIds, emails, comments, null);
        Type localVarReturnType = new TypeToken<DeploymentManagerResponse>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    private okhttp3.Call compareDeployTenantTemplateAsync(String description, String name, Boolean sendEmail, File template, MetadataCompareDeployTenantTemplateRequest metadataCompareDeployTenantTemplateRequest, String zuoraEntityIds, String emails, String comments, final ApiCallback<DeploymentManagerResponse> _callback) throws ApiException {

        okhttp3.Call localVarCall = compareDeployTenantTemplateValidateBeforeCall(description, name, sendEmail, template, metadataCompareDeployTenantTemplateRequest, zuoraEntityIds, emails, comments, _callback);
        Type localVarReturnType = new TypeToken<DeploymentManagerResponse>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    public class CompareDeployTenantTemplateRequestBuilder {
        private final String description;
        private final String name;
        private final Boolean sendEmail;
        private final File template;
        private String zuoraEntityIds;
        private String emails;
        private String comments;

        private CompareDeployTenantTemplateRequestBuilder(String description, String name, Boolean sendEmail, File template) {
            this.description = description;
            this.name = name;
            this.sendEmail = sendEmail;
            this.template = template;
        }

        /**
         * Set zuoraEntityIds
         * @param zuoraEntityIds An entity ID. If you have [Zuora Multi-entity](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Multi-entity) enabled and the OAuth token is valid for more than one entity, you must use this header to specify which entity to perform the operation in. If the OAuth token is only valid for a single entity, or you do not have Zuora Multi-entity enabled, you do not need to set this header.   (optional)
         * @return CompareDeployTenantTemplateRequestBuilder
         */
        public CompareDeployTenantTemplateRequestBuilder zuoraEntityIds(String zuoraEntityIds) {
            this.zuoraEntityIds = zuoraEntityIds;
            return this;
        }
        
        /**
         * Set emails
         * @param emails If sendEmail parameter is set to true, comma separated values of emails can be specified. Example  email1@test.com,email2@test.com. (optional)
         * @return CompareDeployTenantTemplateRequestBuilder
         */
        public CompareDeployTenantTemplateRequestBuilder emails(String emails) {
            this.emails = emails;
            return this;
        }
        
        /**
         * Set comments
         * @param comments Content of the email to be sent. (optional)
         * @return CompareDeployTenantTemplateRequestBuilder
         */
        public CompareDeployTenantTemplateRequestBuilder comments(String comments) {
            this.comments = comments;
            return this;
        }
        
        /**
         * Build call for compareDeployTenantTemplate
         * @param _callback ApiCallback API callback
         * @return Call to execute
         * @throws ApiException If fail to serialize the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td>  </td><td>  * RateLimit-Remaining - The number of requests remaining in the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Reset - The number of seconds until the quota resets for the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Content-Encoding - This header is returned if you specify the &#x60;Accept-Encoding: gzip&#x60; request header and the response contains over 1000 bytes of data. Note that only the following MIME types support gzipped responses:   - &#x60;application/json&#x60;   - &#x60;application/xml&#x60;   - &#x60;text/html&#x60;   - &#x60;text/csv&#x60;   - &#x60;text/plain&#x60;  <br>  * RateLimit-Limit - The request limit quota for the time window closest to exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Zuora-Request-Id - The Zuora internal identifier of the API call. You cannot control the value of this header.  <br>  * Zuora-Track-Id - A custom identifier for tracing the API call. If you specified a tracing identifier in the request headers, Zuora returns the same tracing identifier. Otherwise, Zuora does not set this header.  <br>  </td></tr>
         </table>
         */
        public okhttp3.Call buildCall(final ApiCallback _callback) throws ApiException {
            MetadataCompareDeployTenantTemplateRequest metadataCompareDeployTenantTemplateRequest = buildBodyParams();
            return compareDeployTenantTemplateCall(description, name, sendEmail, template, metadataCompareDeployTenantTemplateRequest, zuoraEntityIds, emails, comments, _callback);
        }

        private MetadataCompareDeployTenantTemplateRequest buildBodyParams() {
            MetadataCompareDeployTenantTemplateRequest metadataCompareDeployTenantTemplateRequest = new MetadataCompareDeployTenantTemplateRequest();
            metadataCompareDeployTenantTemplateRequest.description(this.description);
            metadataCompareDeployTenantTemplateRequest.name(this.name);
            metadataCompareDeployTenantTemplateRequest.sendEmail(this.sendEmail);
            metadataCompareDeployTenantTemplateRequest.emails(this.emails);
            metadataCompareDeployTenantTemplateRequest.comments(this.comments);
            metadataCompareDeployTenantTemplateRequest.template(this.template);
            return metadataCompareDeployTenantTemplateRequest;
        }

        /**
         * Execute compareDeployTenantTemplate request
         * @return DeploymentManagerResponse
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td>  </td><td>  * RateLimit-Remaining - The number of requests remaining in the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Reset - The number of seconds until the quota resets for the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Content-Encoding - This header is returned if you specify the &#x60;Accept-Encoding: gzip&#x60; request header and the response contains over 1000 bytes of data. Note that only the following MIME types support gzipped responses:   - &#x60;application/json&#x60;   - &#x60;application/xml&#x60;   - &#x60;text/html&#x60;   - &#x60;text/csv&#x60;   - &#x60;text/plain&#x60;  <br>  * RateLimit-Limit - The request limit quota for the time window closest to exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Zuora-Request-Id - The Zuora internal identifier of the API call. You cannot control the value of this header.  <br>  * Zuora-Track-Id - A custom identifier for tracing the API call. If you specified a tracing identifier in the request headers, Zuora returns the same tracing identifier. Otherwise, Zuora does not set this header.  <br>  </td></tr>
         </table>
         */
        public DeploymentManagerResponse execute() throws ApiException {
            MetadataCompareDeployTenantTemplateRequest metadataCompareDeployTenantTemplateRequest = buildBodyParams();
            ApiResponse<DeploymentManagerResponse> localVarResp = compareDeployTenantTemplateWithHttpInfo(description, name, sendEmail, template, metadataCompareDeployTenantTemplateRequest, zuoraEntityIds, emails, comments);
            return localVarResp.getResponseBody();
        }

        /**
         * Execute compareDeployTenantTemplate request with HTTP info returned
         * @return ApiResponse&lt;DeploymentManagerResponse&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td>  </td><td>  * RateLimit-Remaining - The number of requests remaining in the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Reset - The number of seconds until the quota resets for the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Content-Encoding - This header is returned if you specify the &#x60;Accept-Encoding: gzip&#x60; request header and the response contains over 1000 bytes of data. Note that only the following MIME types support gzipped responses:   - &#x60;application/json&#x60;   - &#x60;application/xml&#x60;   - &#x60;text/html&#x60;   - &#x60;text/csv&#x60;   - &#x60;text/plain&#x60;  <br>  * RateLimit-Limit - The request limit quota for the time window closest to exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Zuora-Request-Id - The Zuora internal identifier of the API call. You cannot control the value of this header.  <br>  * Zuora-Track-Id - A custom identifier for tracing the API call. If you specified a tracing identifier in the request headers, Zuora returns the same tracing identifier. Otherwise, Zuora does not set this header.  <br>  </td></tr>
         </table>
         */
        public ApiResponse<DeploymentManagerResponse> executeWithHttpInfo() throws ApiException {
            MetadataCompareDeployTenantTemplateRequest metadataCompareDeployTenantTemplateRequest = buildBodyParams();
            return compareDeployTenantTemplateWithHttpInfo(description, name, sendEmail, template, metadataCompareDeployTenantTemplateRequest, zuoraEntityIds, emails, comments);
        }

        /**
         * Execute compareDeployTenantTemplate request (asynchronously)
         * @param _callback The callback to be executed when the API call finishes
         * @return The request call
         * @throws ApiException If fail to process the API call, e.g. serializing the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td>  </td><td>  * RateLimit-Remaining - The number of requests remaining in the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Reset - The number of seconds until the quota resets for the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Content-Encoding - This header is returned if you specify the &#x60;Accept-Encoding: gzip&#x60; request header and the response contains over 1000 bytes of data. Note that only the following MIME types support gzipped responses:   - &#x60;application/json&#x60;   - &#x60;application/xml&#x60;   - &#x60;text/html&#x60;   - &#x60;text/csv&#x60;   - &#x60;text/plain&#x60;  <br>  * RateLimit-Limit - The request limit quota for the time window closest to exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Zuora-Request-Id - The Zuora internal identifier of the API call. You cannot control the value of this header.  <br>  * Zuora-Track-Id - A custom identifier for tracing the API call. If you specified a tracing identifier in the request headers, Zuora returns the same tracing identifier. Otherwise, Zuora does not set this header.  <br>  </td></tr>
         </table>
         */
        public okhttp3.Call executeAsync(final ApiCallback<DeploymentManagerResponse> _callback) throws ApiException {
            MetadataCompareDeployTenantTemplateRequest metadataCompareDeployTenantTemplateRequest = buildBodyParams();
            return compareDeployTenantTemplateAsync(description, name, sendEmail, template, metadataCompareDeployTenantTemplateRequest, zuoraEntityIds, emails, comments, _callback);
        }
    }

    /**
     * Compare and deploy a template to a tenant
     * Compare and deploy a template to a tenant. 
     * @param description Deployment&#39;s description. (required)
     * @param name Deployment&#39;s name (required)
     * @param sendEmail Specifies if an email should be sent. (required)
     * @param template Template file. (required)
     * @param metadataCompareDeployTenantTemplateRequest  (required)
     * @return CompareDeployTenantTemplateRequestBuilder
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td>  </td><td>  * RateLimit-Remaining - The number of requests remaining in the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Reset - The number of seconds until the quota resets for the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Content-Encoding - This header is returned if you specify the &#x60;Accept-Encoding: gzip&#x60; request header and the response contains over 1000 bytes of data. Note that only the following MIME types support gzipped responses:   - &#x60;application/json&#x60;   - &#x60;application/xml&#x60;   - &#x60;text/html&#x60;   - &#x60;text/csv&#x60;   - &#x60;text/plain&#x60;  <br>  * RateLimit-Limit - The request limit quota for the time window closest to exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Zuora-Request-Id - The Zuora internal identifier of the API call. You cannot control the value of this header.  <br>  * Zuora-Track-Id - A custom identifier for tracing the API call. If you specified a tracing identifier in the request headers, Zuora returns the same tracing identifier. Otherwise, Zuora does not set this header.  <br>  </td></tr>
     </table>
     */
    public CompareDeployTenantTemplateRequestBuilder compareDeployTenantTemplate(String description, String name, Boolean sendEmail, File template) throws IllegalArgumentException {
        if (description == null) throw new IllegalArgumentException("\"description\" is required but got null");
            

        if (name == null) throw new IllegalArgumentException("\"name\" is required but got null");
            

        if (sendEmail == null) throw new IllegalArgumentException("\"sendEmail\" is required but got null");
        if (template == null) throw new IllegalArgumentException("\"template\" is required but got null");
        return new CompareDeployTenantTemplateRequestBuilder(description, name, sendEmail, template);
    }
    private okhttp3.Call compareDeployTenantToTargetCall(String description, String name, Boolean sendEmail, Boolean settings, Boolean notifications, Boolean workflows, Boolean customFields, Boolean productCatalog, Boolean userRoles, Boolean reporting, String sourceTenantId, MetadataCompareDeployTenantToTargetRequest metadataCompareDeployTenantToTargetRequest, String zuoraEntityIds, String emails, String comments, Boolean customObjects, Boolean taxation, final ApiCallback _callback) throws ApiException {
        String basePath = null;
        // Operation Servers
        String[] localBasePaths = new String[] {  };

        // Determine Base Path to Use
        if (localCustomBaseUrl != null){
            basePath = localCustomBaseUrl;
        } else if ( localBasePaths.length > 0 ) {
            basePath = localBasePaths[localHostIndex];
        } else {
            basePath = null;
        }

        Object localVarPostBody = metadataCompareDeployTenantToTargetRequest;

        // create path and map variables
        String localVarPath = "/deployment-manager/deployments/tenants";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        if (description != null) {
            localVarFormParams.put("description", description);
        }

        if (name != null) {
            localVarFormParams.put("name", name);
        }

        if (sendEmail != null) {
            localVarFormParams.put("sendEmail", sendEmail);
        }

        if (emails != null) {
            localVarFormParams.put("emails", emails);
        }

        if (comments != null) {
            localVarFormParams.put("comments", comments);
        }

        if (settings != null) {
            localVarFormParams.put("settings", settings);
        }

        if (notifications != null) {
            localVarFormParams.put("notifications", notifications);
        }

        if (workflows != null) {
            localVarFormParams.put("workflows", workflows);
        }

        if (customFields != null) {
            localVarFormParams.put("customFields", customFields);
        }

        if (customObjects != null) {
            localVarFormParams.put("customObjects", customObjects);
        }

        if (productCatalog != null) {
            localVarFormParams.put("productCatalog", productCatalog);
        }

        if (taxation != null) {
            localVarFormParams.put("taxation", taxation);
        }

        if (userRoles != null) {
            localVarFormParams.put("userRoles", userRoles);
        }

        if (reporting != null) {
            localVarFormParams.put("reporting", reporting);
        }

        if (sourceTenantId != null) {
            localVarFormParams.put("sourceTenantId", sourceTenantId);
        }

        if (zuoraEntityIds != null) {
            localVarHeaderParams.put("Zuora-Entity-Ids", localVarApiClient.parameterToString(zuoraEntityIds));
        }

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = {
            "multipart/form-data"
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        if (localVarContentType != null) {
            localVarHeaderParams.put("Content-Type", localVarContentType);
        }

        String[] localVarAuthNames = new String[] {  };
        return localVarApiClient.buildCall(basePath, localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call compareDeployTenantToTargetValidateBeforeCall(String description, String name, Boolean sendEmail, Boolean settings, Boolean notifications, Boolean workflows, Boolean customFields, Boolean productCatalog, Boolean userRoles, Boolean reporting, String sourceTenantId, MetadataCompareDeployTenantToTargetRequest metadataCompareDeployTenantToTargetRequest, String zuoraEntityIds, String emails, String comments, Boolean customObjects, Boolean taxation, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'description' is set
        if (description == null) {
            throw new ApiException("Missing the required parameter 'description' when calling compareDeployTenantToTarget(Async)");
        }

        // verify the required parameter 'name' is set
        if (name == null) {
            throw new ApiException("Missing the required parameter 'name' when calling compareDeployTenantToTarget(Async)");
        }

        // verify the required parameter 'sendEmail' is set
        if (sendEmail == null) {
            throw new ApiException("Missing the required parameter 'sendEmail' when calling compareDeployTenantToTarget(Async)");
        }

        // verify the required parameter 'settings' is set
        if (settings == null) {
            throw new ApiException("Missing the required parameter 'settings' when calling compareDeployTenantToTarget(Async)");
        }

        // verify the required parameter 'notifications' is set
        if (notifications == null) {
            throw new ApiException("Missing the required parameter 'notifications' when calling compareDeployTenantToTarget(Async)");
        }

        // verify the required parameter 'workflows' is set
        if (workflows == null) {
            throw new ApiException("Missing the required parameter 'workflows' when calling compareDeployTenantToTarget(Async)");
        }

        // verify the required parameter 'customFields' is set
        if (customFields == null) {
            throw new ApiException("Missing the required parameter 'customFields' when calling compareDeployTenantToTarget(Async)");
        }

        // verify the required parameter 'productCatalog' is set
        if (productCatalog == null) {
            throw new ApiException("Missing the required parameter 'productCatalog' when calling compareDeployTenantToTarget(Async)");
        }

        // verify the required parameter 'userRoles' is set
        if (userRoles == null) {
            throw new ApiException("Missing the required parameter 'userRoles' when calling compareDeployTenantToTarget(Async)");
        }

        // verify the required parameter 'reporting' is set
        if (reporting == null) {
            throw new ApiException("Missing the required parameter 'reporting' when calling compareDeployTenantToTarget(Async)");
        }

        // verify the required parameter 'sourceTenantId' is set
        if (sourceTenantId == null) {
            throw new ApiException("Missing the required parameter 'sourceTenantId' when calling compareDeployTenantToTarget(Async)");
        }

        // verify the required parameter 'metadataCompareDeployTenantToTargetRequest' is set
        if (metadataCompareDeployTenantToTargetRequest == null) {
            throw new ApiException("Missing the required parameter 'metadataCompareDeployTenantToTargetRequest' when calling compareDeployTenantToTarget(Async)");
        }

        return compareDeployTenantToTargetCall(description, name, sendEmail, settings, notifications, workflows, customFields, productCatalog, userRoles, reporting, sourceTenantId, metadataCompareDeployTenantToTargetRequest, zuoraEntityIds, emails, comments, customObjects, taxation, _callback);

    }


    private ApiResponse<DeploymentManagerResponse> compareDeployTenantToTargetWithHttpInfo(String description, String name, Boolean sendEmail, Boolean settings, Boolean notifications, Boolean workflows, Boolean customFields, Boolean productCatalog, Boolean userRoles, Boolean reporting, String sourceTenantId, MetadataCompareDeployTenantToTargetRequest metadataCompareDeployTenantToTargetRequest, String zuoraEntityIds, String emails, String comments, Boolean customObjects, Boolean taxation) throws ApiException {
        okhttp3.Call localVarCall = compareDeployTenantToTargetValidateBeforeCall(description, name, sendEmail, settings, notifications, workflows, customFields, productCatalog, userRoles, reporting, sourceTenantId, metadataCompareDeployTenantToTargetRequest, zuoraEntityIds, emails, comments, customObjects, taxation, null);
        Type localVarReturnType = new TypeToken<DeploymentManagerResponse>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    private okhttp3.Call compareDeployTenantToTargetAsync(String description, String name, Boolean sendEmail, Boolean settings, Boolean notifications, Boolean workflows, Boolean customFields, Boolean productCatalog, Boolean userRoles, Boolean reporting, String sourceTenantId, MetadataCompareDeployTenantToTargetRequest metadataCompareDeployTenantToTargetRequest, String zuoraEntityIds, String emails, String comments, Boolean customObjects, Boolean taxation, final ApiCallback<DeploymentManagerResponse> _callback) throws ApiException {

        okhttp3.Call localVarCall = compareDeployTenantToTargetValidateBeforeCall(description, name, sendEmail, settings, notifications, workflows, customFields, productCatalog, userRoles, reporting, sourceTenantId, metadataCompareDeployTenantToTargetRequest, zuoraEntityIds, emails, comments, customObjects, taxation, _callback);
        Type localVarReturnType = new TypeToken<DeploymentManagerResponse>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    public class CompareDeployTenantToTargetRequestBuilder {
        private final String description;
        private final String name;
        private final Boolean sendEmail;
        private final Boolean settings;
        private final Boolean notifications;
        private final Boolean workflows;
        private final Boolean customFields;
        private final Boolean productCatalog;
        private final Boolean userRoles;
        private final Boolean reporting;
        private final String sourceTenantId;
        private String zuoraEntityIds;
        private String emails;
        private String comments;
        private Boolean customObjects;
        private Boolean taxation;

        private CompareDeployTenantToTargetRequestBuilder(String description, String name, Boolean sendEmail, Boolean settings, Boolean notifications, Boolean workflows, Boolean customFields, Boolean productCatalog, Boolean userRoles, Boolean reporting, String sourceTenantId) {
            this.description = description;
            this.name = name;
            this.sendEmail = sendEmail;
            this.settings = settings;
            this.notifications = notifications;
            this.workflows = workflows;
            this.customFields = customFields;
            this.productCatalog = productCatalog;
            this.userRoles = userRoles;
            this.reporting = reporting;
            this.sourceTenantId = sourceTenantId;
        }

        /**
         * Set zuoraEntityIds
         * @param zuoraEntityIds An entity ID. If you have [Zuora Multi-entity](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Multi-entity) enabled and the OAuth token is valid for more than one entity, you must use this header to specify which entity to perform the operation in. If the OAuth token is only valid for a single entity, or you do not have Zuora Multi-entity enabled, you do not need to set this header.   (optional)
         * @return CompareDeployTenantToTargetRequestBuilder
         */
        public CompareDeployTenantToTargetRequestBuilder zuoraEntityIds(String zuoraEntityIds) {
            this.zuoraEntityIds = zuoraEntityIds;
            return this;
        }
        
        /**
         * Set emails
         * @param emails If sendEmail parameter is set to true, comma separated values of emails can be specified. Example  email1@test.com,email2@test.com. (optional)
         * @return CompareDeployTenantToTargetRequestBuilder
         */
        public CompareDeployTenantToTargetRequestBuilder emails(String emails) {
            this.emails = emails;
            return this;
        }
        
        /**
         * Set comments
         * @param comments Content of the email to be sent. (optional)
         * @return CompareDeployTenantToTargetRequestBuilder
         */
        public CompareDeployTenantToTargetRequestBuilder comments(String comments) {
            this.comments = comments;
            return this;
        }
        
        /**
         * Set customObjects
         * @param customObjects Specified if customObjects module should be considered in the deployment process. (optional)
         * @return CompareDeployTenantToTargetRequestBuilder
         */
        public CompareDeployTenantToTargetRequestBuilder customObjects(Boolean customObjects) {
            this.customObjects = customObjects;
            return this;
        }
        
        /**
         * Set taxation
         * @param taxation Specified if taxation module should be considered in the deployment process. (optional)
         * @return CompareDeployTenantToTargetRequestBuilder
         */
        public CompareDeployTenantToTargetRequestBuilder taxation(Boolean taxation) {
            this.taxation = taxation;
            return this;
        }
        
        /**
         * Build call for compareDeployTenantToTarget
         * @param _callback ApiCallback API callback
         * @return Call to execute
         * @throws ApiException If fail to serialize the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td>  </td><td>  * RateLimit-Remaining - The number of requests remaining in the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Reset - The number of seconds until the quota resets for the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Content-Encoding - This header is returned if you specify the &#x60;Accept-Encoding: gzip&#x60; request header and the response contains over 1000 bytes of data. Note that only the following MIME types support gzipped responses:   - &#x60;application/json&#x60;   - &#x60;application/xml&#x60;   - &#x60;text/html&#x60;   - &#x60;text/csv&#x60;   - &#x60;text/plain&#x60;  <br>  * RateLimit-Limit - The request limit quota for the time window closest to exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Zuora-Request-Id - The Zuora internal identifier of the API call. You cannot control the value of this header.  <br>  * Zuora-Track-Id - A custom identifier for tracing the API call. If you specified a tracing identifier in the request headers, Zuora returns the same tracing identifier. Otherwise, Zuora does not set this header.  <br>  </td></tr>
         </table>
         */
        public okhttp3.Call buildCall(final ApiCallback _callback) throws ApiException {
            MetadataCompareDeployTenantToTargetRequest metadataCompareDeployTenantToTargetRequest = buildBodyParams();
            return compareDeployTenantToTargetCall(description, name, sendEmail, settings, notifications, workflows, customFields, productCatalog, userRoles, reporting, sourceTenantId, metadataCompareDeployTenantToTargetRequest, zuoraEntityIds, emails, comments, customObjects, taxation, _callback);
        }

        private MetadataCompareDeployTenantToTargetRequest buildBodyParams() {
            MetadataCompareDeployTenantToTargetRequest metadataCompareDeployTenantToTargetRequest = new MetadataCompareDeployTenantToTargetRequest();
            metadataCompareDeployTenantToTargetRequest.description(this.description);
            metadataCompareDeployTenantToTargetRequest.name(this.name);
            metadataCompareDeployTenantToTargetRequest.sendEmail(this.sendEmail);
            metadataCompareDeployTenantToTargetRequest.emails(this.emails);
            metadataCompareDeployTenantToTargetRequest.comments(this.comments);
            metadataCompareDeployTenantToTargetRequest.settings(this.settings);
            metadataCompareDeployTenantToTargetRequest.notifications(this.notifications);
            metadataCompareDeployTenantToTargetRequest.workflows(this.workflows);
            metadataCompareDeployTenantToTargetRequest.customFields(this.customFields);
            metadataCompareDeployTenantToTargetRequest.customObjects(this.customObjects);
            metadataCompareDeployTenantToTargetRequest.productCatalog(this.productCatalog);
            metadataCompareDeployTenantToTargetRequest.taxation(this.taxation);
            metadataCompareDeployTenantToTargetRequest.userRoles(this.userRoles);
            metadataCompareDeployTenantToTargetRequest.reporting(this.reporting);
            metadataCompareDeployTenantToTargetRequest.sourceTenantId(this.sourceTenantId);
            return metadataCompareDeployTenantToTargetRequest;
        }

        /**
         * Execute compareDeployTenantToTarget request
         * @return DeploymentManagerResponse
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td>  </td><td>  * RateLimit-Remaining - The number of requests remaining in the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Reset - The number of seconds until the quota resets for the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Content-Encoding - This header is returned if you specify the &#x60;Accept-Encoding: gzip&#x60; request header and the response contains over 1000 bytes of data. Note that only the following MIME types support gzipped responses:   - &#x60;application/json&#x60;   - &#x60;application/xml&#x60;   - &#x60;text/html&#x60;   - &#x60;text/csv&#x60;   - &#x60;text/plain&#x60;  <br>  * RateLimit-Limit - The request limit quota for the time window closest to exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Zuora-Request-Id - The Zuora internal identifier of the API call. You cannot control the value of this header.  <br>  * Zuora-Track-Id - A custom identifier for tracing the API call. If you specified a tracing identifier in the request headers, Zuora returns the same tracing identifier. Otherwise, Zuora does not set this header.  <br>  </td></tr>
         </table>
         */
        public DeploymentManagerResponse execute() throws ApiException {
            MetadataCompareDeployTenantToTargetRequest metadataCompareDeployTenantToTargetRequest = buildBodyParams();
            ApiResponse<DeploymentManagerResponse> localVarResp = compareDeployTenantToTargetWithHttpInfo(description, name, sendEmail, settings, notifications, workflows, customFields, productCatalog, userRoles, reporting, sourceTenantId, metadataCompareDeployTenantToTargetRequest, zuoraEntityIds, emails, comments, customObjects, taxation);
            return localVarResp.getResponseBody();
        }

        /**
         * Execute compareDeployTenantToTarget request with HTTP info returned
         * @return ApiResponse&lt;DeploymentManagerResponse&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td>  </td><td>  * RateLimit-Remaining - The number of requests remaining in the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Reset - The number of seconds until the quota resets for the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Content-Encoding - This header is returned if you specify the &#x60;Accept-Encoding: gzip&#x60; request header and the response contains over 1000 bytes of data. Note that only the following MIME types support gzipped responses:   - &#x60;application/json&#x60;   - &#x60;application/xml&#x60;   - &#x60;text/html&#x60;   - &#x60;text/csv&#x60;   - &#x60;text/plain&#x60;  <br>  * RateLimit-Limit - The request limit quota for the time window closest to exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Zuora-Request-Id - The Zuora internal identifier of the API call. You cannot control the value of this header.  <br>  * Zuora-Track-Id - A custom identifier for tracing the API call. If you specified a tracing identifier in the request headers, Zuora returns the same tracing identifier. Otherwise, Zuora does not set this header.  <br>  </td></tr>
         </table>
         */
        public ApiResponse<DeploymentManagerResponse> executeWithHttpInfo() throws ApiException {
            MetadataCompareDeployTenantToTargetRequest metadataCompareDeployTenantToTargetRequest = buildBodyParams();
            return compareDeployTenantToTargetWithHttpInfo(description, name, sendEmail, settings, notifications, workflows, customFields, productCatalog, userRoles, reporting, sourceTenantId, metadataCompareDeployTenantToTargetRequest, zuoraEntityIds, emails, comments, customObjects, taxation);
        }

        /**
         * Execute compareDeployTenantToTarget request (asynchronously)
         * @param _callback The callback to be executed when the API call finishes
         * @return The request call
         * @throws ApiException If fail to process the API call, e.g. serializing the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td>  </td><td>  * RateLimit-Remaining - The number of requests remaining in the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Reset - The number of seconds until the quota resets for the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Content-Encoding - This header is returned if you specify the &#x60;Accept-Encoding: gzip&#x60; request header and the response contains over 1000 bytes of data. Note that only the following MIME types support gzipped responses:   - &#x60;application/json&#x60;   - &#x60;application/xml&#x60;   - &#x60;text/html&#x60;   - &#x60;text/csv&#x60;   - &#x60;text/plain&#x60;  <br>  * RateLimit-Limit - The request limit quota for the time window closest to exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Zuora-Request-Id - The Zuora internal identifier of the API call. You cannot control the value of this header.  <br>  * Zuora-Track-Id - A custom identifier for tracing the API call. If you specified a tracing identifier in the request headers, Zuora returns the same tracing identifier. Otherwise, Zuora does not set this header.  <br>  </td></tr>
         </table>
         */
        public okhttp3.Call executeAsync(final ApiCallback<DeploymentManagerResponse> _callback) throws ApiException {
            MetadataCompareDeployTenantToTargetRequest metadataCompareDeployTenantToTargetRequest = buildBodyParams();
            return compareDeployTenantToTargetAsync(description, name, sendEmail, settings, notifications, workflows, customFields, productCatalog, userRoles, reporting, sourceTenantId, metadataCompareDeployTenantToTargetRequest, zuoraEntityIds, emails, comments, customObjects, taxation, _callback);
        }
    }

    /**
     * Compare and deploy a source tenant to a target tenant
     * Compare and deploy a source tenant to a target tenant. 
     * @param description Deployment&#39;s description. (required)
     * @param name Deployment&#39;s name. (required)
     * @param sendEmail Specifies if an email should be sent. (required)
     * @param settings Specified if settings module should be considered in the deployment process. (required)
     * @param notifications Specified if notifications module should be considered in the deployment process. (required)
     * @param workflows Specified if workflows module should be considered in the deployment process. (required)
     * @param customFields Specified if customFields module should be considered in the deployment process. (required)
     * @param productCatalog Specified if productCatalog module should be considered in the deployment process. (required)
     * @param userRoles Specified if userRoles module should be considered in the deployment process. (required)
     * @param reporting Specified if reporting module should be considered in the deployment process. (required)
     * @param sourceTenantId Id of the source tenant. (required)
     * @param metadataCompareDeployTenantToTargetRequest  (required)
     * @return CompareDeployTenantToTargetRequestBuilder
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td>  </td><td>  * RateLimit-Remaining - The number of requests remaining in the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Reset - The number of seconds until the quota resets for the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Content-Encoding - This header is returned if you specify the &#x60;Accept-Encoding: gzip&#x60; request header and the response contains over 1000 bytes of data. Note that only the following MIME types support gzipped responses:   - &#x60;application/json&#x60;   - &#x60;application/xml&#x60;   - &#x60;text/html&#x60;   - &#x60;text/csv&#x60;   - &#x60;text/plain&#x60;  <br>  * RateLimit-Limit - The request limit quota for the time window closest to exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Zuora-Request-Id - The Zuora internal identifier of the API call. You cannot control the value of this header.  <br>  * Zuora-Track-Id - A custom identifier for tracing the API call. If you specified a tracing identifier in the request headers, Zuora returns the same tracing identifier. Otherwise, Zuora does not set this header.  <br>  </td></tr>
     </table>
     */
    public CompareDeployTenantToTargetRequestBuilder compareDeployTenantToTarget(String description, String name, Boolean sendEmail, Boolean settings, Boolean notifications, Boolean workflows, Boolean customFields, Boolean productCatalog, Boolean userRoles, Boolean reporting, String sourceTenantId) throws IllegalArgumentException {
        if (description == null) throw new IllegalArgumentException("\"description\" is required but got null");
            

        if (name == null) throw new IllegalArgumentException("\"name\" is required but got null");
            

        if (sendEmail == null) throw new IllegalArgumentException("\"sendEmail\" is required but got null");
        if (settings == null) throw new IllegalArgumentException("\"settings\" is required but got null");
        if (notifications == null) throw new IllegalArgumentException("\"notifications\" is required but got null");
        if (workflows == null) throw new IllegalArgumentException("\"workflows\" is required but got null");
        if (customFields == null) throw new IllegalArgumentException("\"customFields\" is required but got null");
        if (productCatalog == null) throw new IllegalArgumentException("\"productCatalog\" is required but got null");
        if (userRoles == null) throw new IllegalArgumentException("\"userRoles\" is required but got null");
        if (reporting == null) throw new IllegalArgumentException("\"reporting\" is required but got null");
        if (sourceTenantId == null) throw new IllegalArgumentException("\"sourceTenantId\" is required but got null");
            

        return new CompareDeployTenantToTargetRequestBuilder(description, name, sendEmail, settings, notifications, workflows, customFields, productCatalog, userRoles, reporting, sourceTenantId);
    }
    private okhttp3.Call deployTenantTemplateCall(String description, String name, Boolean sendEmail, File template, Boolean inActiveProducts, Boolean activeProducts, Boolean activeRatePlans, Boolean inActiveRatePlans, String compareField, MetadataDeployTenantTemplateRequest metadataDeployTenantTemplateRequest, String zuoraEntityIds, String emails, String comments, final ApiCallback _callback) throws ApiException {
        String basePath = null;
        // Operation Servers
        String[] localBasePaths = new String[] {  };

        // Determine Base Path to Use
        if (localCustomBaseUrl != null){
            basePath = localCustomBaseUrl;
        } else if ( localBasePaths.length > 0 ) {
            basePath = localBasePaths[localHostIndex];
        } else {
            basePath = null;
        }

        Object localVarPostBody = metadataDeployTenantTemplateRequest;

        // create path and map variables
        String localVarPath = "/deployment-manager/deployments/template/product_catalog";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        if (description != null) {
            localVarFormParams.put("description", description);
        }

        if (name != null) {
            localVarFormParams.put("name", name);
        }

        if (sendEmail != null) {
            localVarFormParams.put("sendEmail", sendEmail);
        }

        if (emails != null) {
            localVarFormParams.put("emails", emails);
        }

        if (comments != null) {
            localVarFormParams.put("comments", comments);
        }

        if (template != null) {
            localVarFormParams.put("template", template);
        }

        if (inActiveProducts != null) {
            localVarFormParams.put("inActiveProducts", inActiveProducts);
        }

        if (activeProducts != null) {
            localVarFormParams.put("activeProducts", activeProducts);
        }

        if (activeRatePlans != null) {
            localVarFormParams.put("activeRatePlans", activeRatePlans);
        }

        if (inActiveRatePlans != null) {
            localVarFormParams.put("inActiveRatePlans", inActiveRatePlans);
        }

        if (compareField != null) {
            localVarFormParams.put("compareField", compareField);
        }

        if (zuoraEntityIds != null) {
            localVarHeaderParams.put("Zuora-Entity-Ids", localVarApiClient.parameterToString(zuoraEntityIds));
        }

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = {
            "multipart/form-data"
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        if (localVarContentType != null) {
            localVarHeaderParams.put("Content-Type", localVarContentType);
        }

        String[] localVarAuthNames = new String[] {  };
        return localVarApiClient.buildCall(basePath, localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call deployTenantTemplateValidateBeforeCall(String description, String name, Boolean sendEmail, File template, Boolean inActiveProducts, Boolean activeProducts, Boolean activeRatePlans, Boolean inActiveRatePlans, String compareField, MetadataDeployTenantTemplateRequest metadataDeployTenantTemplateRequest, String zuoraEntityIds, String emails, String comments, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'description' is set
        if (description == null) {
            throw new ApiException("Missing the required parameter 'description' when calling deployTenantTemplate(Async)");
        }

        // verify the required parameter 'name' is set
        if (name == null) {
            throw new ApiException("Missing the required parameter 'name' when calling deployTenantTemplate(Async)");
        }

        // verify the required parameter 'sendEmail' is set
        if (sendEmail == null) {
            throw new ApiException("Missing the required parameter 'sendEmail' when calling deployTenantTemplate(Async)");
        }

        // verify the required parameter 'template' is set
        if (template == null) {
            throw new ApiException("Missing the required parameter 'template' when calling deployTenantTemplate(Async)");
        }

        // verify the required parameter 'inActiveProducts' is set
        if (inActiveProducts == null) {
            throw new ApiException("Missing the required parameter 'inActiveProducts' when calling deployTenantTemplate(Async)");
        }

        // verify the required parameter 'activeProducts' is set
        if (activeProducts == null) {
            throw new ApiException("Missing the required parameter 'activeProducts' when calling deployTenantTemplate(Async)");
        }

        // verify the required parameter 'activeRatePlans' is set
        if (activeRatePlans == null) {
            throw new ApiException("Missing the required parameter 'activeRatePlans' when calling deployTenantTemplate(Async)");
        }

        // verify the required parameter 'inActiveRatePlans' is set
        if (inActiveRatePlans == null) {
            throw new ApiException("Missing the required parameter 'inActiveRatePlans' when calling deployTenantTemplate(Async)");
        }

        // verify the required parameter 'compareField' is set
        if (compareField == null) {
            throw new ApiException("Missing the required parameter 'compareField' when calling deployTenantTemplate(Async)");
        }

        // verify the required parameter 'metadataDeployTenantTemplateRequest' is set
        if (metadataDeployTenantTemplateRequest == null) {
            throw new ApiException("Missing the required parameter 'metadataDeployTenantTemplateRequest' when calling deployTenantTemplate(Async)");
        }

        return deployTenantTemplateCall(description, name, sendEmail, template, inActiveProducts, activeProducts, activeRatePlans, inActiveRatePlans, compareField, metadataDeployTenantTemplateRequest, zuoraEntityIds, emails, comments, _callback);

    }


    private ApiResponse<DeploymentManagerResponse> deployTenantTemplateWithHttpInfo(String description, String name, Boolean sendEmail, File template, Boolean inActiveProducts, Boolean activeProducts, Boolean activeRatePlans, Boolean inActiveRatePlans, String compareField, MetadataDeployTenantTemplateRequest metadataDeployTenantTemplateRequest, String zuoraEntityIds, String emails, String comments) throws ApiException {
        okhttp3.Call localVarCall = deployTenantTemplateValidateBeforeCall(description, name, sendEmail, template, inActiveProducts, activeProducts, activeRatePlans, inActiveRatePlans, compareField, metadataDeployTenantTemplateRequest, zuoraEntityIds, emails, comments, null);
        Type localVarReturnType = new TypeToken<DeploymentManagerResponse>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    private okhttp3.Call deployTenantTemplateAsync(String description, String name, Boolean sendEmail, File template, Boolean inActiveProducts, Boolean activeProducts, Boolean activeRatePlans, Boolean inActiveRatePlans, String compareField, MetadataDeployTenantTemplateRequest metadataDeployTenantTemplateRequest, String zuoraEntityIds, String emails, String comments, final ApiCallback<DeploymentManagerResponse> _callback) throws ApiException {

        okhttp3.Call localVarCall = deployTenantTemplateValidateBeforeCall(description, name, sendEmail, template, inActiveProducts, activeProducts, activeRatePlans, inActiveRatePlans, compareField, metadataDeployTenantTemplateRequest, zuoraEntityIds, emails, comments, _callback);
        Type localVarReturnType = new TypeToken<DeploymentManagerResponse>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    public class DeployTenantTemplateRequestBuilder {
        private final String description;
        private final String name;
        private final Boolean sendEmail;
        private final File template;
        private final Boolean inActiveProducts;
        private final Boolean activeProducts;
        private final Boolean activeRatePlans;
        private final Boolean inActiveRatePlans;
        private final String compareField;
        private String zuoraEntityIds;
        private String emails;
        private String comments;

        private DeployTenantTemplateRequestBuilder(String description, String name, Boolean sendEmail, File template, Boolean inActiveProducts, Boolean activeProducts, Boolean activeRatePlans, Boolean inActiveRatePlans, String compareField) {
            this.description = description;
            this.name = name;
            this.sendEmail = sendEmail;
            this.template = template;
            this.inActiveProducts = inActiveProducts;
            this.activeProducts = activeProducts;
            this.activeRatePlans = activeRatePlans;
            this.inActiveRatePlans = inActiveRatePlans;
            this.compareField = compareField;
        }

        /**
         * Set zuoraEntityIds
         * @param zuoraEntityIds An entity ID. If you have [Zuora Multi-entity](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Multi-entity) enabled and the OAuth token is valid for more than one entity, you must use this header to specify which entity to perform the operation in. If the OAuth token is only valid for a single entity, or you do not have Zuora Multi-entity enabled, you do not need to set this header.   (optional)
         * @return DeployTenantTemplateRequestBuilder
         */
        public DeployTenantTemplateRequestBuilder zuoraEntityIds(String zuoraEntityIds) {
            this.zuoraEntityIds = zuoraEntityIds;
            return this;
        }
        
        /**
         * Set emails
         * @param emails If sendEmail parameter is set to true, comma separated values of emails can be specified. (optional)
         * @return DeployTenantTemplateRequestBuilder
         */
        public DeployTenantTemplateRequestBuilder emails(String emails) {
            this.emails = emails;
            return this;
        }
        
        /**
         * Set comments
         * @param comments Content of the email to be sent. (optional)
         * @return DeployTenantTemplateRequestBuilder
         */
        public DeployTenantTemplateRequestBuilder comments(String comments) {
            this.comments = comments;
            return this;
        }
        
        /**
         * Build call for deployTenantTemplate
         * @param _callback ApiCallback API callback
         * @return Call to execute
         * @throws ApiException If fail to serialize the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td>  </td><td>  * RateLimit-Remaining - The number of requests remaining in the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Reset - The number of seconds until the quota resets for the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Content-Encoding - This header is returned if you specify the &#x60;Accept-Encoding: gzip&#x60; request header and the response contains over 1000 bytes of data. Note that only the following MIME types support gzipped responses:   - &#x60;application/json&#x60;   - &#x60;application/xml&#x60;   - &#x60;text/html&#x60;   - &#x60;text/csv&#x60;   - &#x60;text/plain&#x60;  <br>  * RateLimit-Limit - The request limit quota for the time window closest to exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Zuora-Request-Id - The Zuora internal identifier of the API call. You cannot control the value of this header.  <br>  * Zuora-Track-Id - A custom identifier for tracing the API call. If you specified a tracing identifier in the request headers, Zuora returns the same tracing identifier. Otherwise, Zuora does not set this header.  <br>  </td></tr>
         </table>
         */
        public okhttp3.Call buildCall(final ApiCallback _callback) throws ApiException {
            MetadataDeployTenantTemplateRequest metadataDeployTenantTemplateRequest = buildBodyParams();
            return deployTenantTemplateCall(description, name, sendEmail, template, inActiveProducts, activeProducts, activeRatePlans, inActiveRatePlans, compareField, metadataDeployTenantTemplateRequest, zuoraEntityIds, emails, comments, _callback);
        }

        private MetadataDeployTenantTemplateRequest buildBodyParams() {
            MetadataDeployTenantTemplateRequest metadataDeployTenantTemplateRequest = new MetadataDeployTenantTemplateRequest();
            metadataDeployTenantTemplateRequest.description(this.description);
            metadataDeployTenantTemplateRequest.name(this.name);
            metadataDeployTenantTemplateRequest.sendEmail(this.sendEmail);
            metadataDeployTenantTemplateRequest.emails(this.emails);
            metadataDeployTenantTemplateRequest.comments(this.comments);
            metadataDeployTenantTemplateRequest.template(this.template);
            metadataDeployTenantTemplateRequest.inActiveProducts(this.inActiveProducts);
            metadataDeployTenantTemplateRequest.activeProducts(this.activeProducts);
            metadataDeployTenantTemplateRequest.activeRatePlans(this.activeRatePlans);
            metadataDeployTenantTemplateRequest.inActiveRatePlans(this.inActiveRatePlans);
            if (this.compareField != null)
            metadataDeployTenantTemplateRequest.compareField(MetadataDeployTenantTemplateRequest.CompareFieldEnum.fromValue(this.compareField));
            return metadataDeployTenantTemplateRequest;
        }

        /**
         * Execute deployTenantTemplate request
         * @return DeploymentManagerResponse
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td>  </td><td>  * RateLimit-Remaining - The number of requests remaining in the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Reset - The number of seconds until the quota resets for the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Content-Encoding - This header is returned if you specify the &#x60;Accept-Encoding: gzip&#x60; request header and the response contains over 1000 bytes of data. Note that only the following MIME types support gzipped responses:   - &#x60;application/json&#x60;   - &#x60;application/xml&#x60;   - &#x60;text/html&#x60;   - &#x60;text/csv&#x60;   - &#x60;text/plain&#x60;  <br>  * RateLimit-Limit - The request limit quota for the time window closest to exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Zuora-Request-Id - The Zuora internal identifier of the API call. You cannot control the value of this header.  <br>  * Zuora-Track-Id - A custom identifier for tracing the API call. If you specified a tracing identifier in the request headers, Zuora returns the same tracing identifier. Otherwise, Zuora does not set this header.  <br>  </td></tr>
         </table>
         */
        public DeploymentManagerResponse execute() throws ApiException {
            MetadataDeployTenantTemplateRequest metadataDeployTenantTemplateRequest = buildBodyParams();
            ApiResponse<DeploymentManagerResponse> localVarResp = deployTenantTemplateWithHttpInfo(description, name, sendEmail, template, inActiveProducts, activeProducts, activeRatePlans, inActiveRatePlans, compareField, metadataDeployTenantTemplateRequest, zuoraEntityIds, emails, comments);
            return localVarResp.getResponseBody();
        }

        /**
         * Execute deployTenantTemplate request with HTTP info returned
         * @return ApiResponse&lt;DeploymentManagerResponse&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td>  </td><td>  * RateLimit-Remaining - The number of requests remaining in the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Reset - The number of seconds until the quota resets for the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Content-Encoding - This header is returned if you specify the &#x60;Accept-Encoding: gzip&#x60; request header and the response contains over 1000 bytes of data. Note that only the following MIME types support gzipped responses:   - &#x60;application/json&#x60;   - &#x60;application/xml&#x60;   - &#x60;text/html&#x60;   - &#x60;text/csv&#x60;   - &#x60;text/plain&#x60;  <br>  * RateLimit-Limit - The request limit quota for the time window closest to exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Zuora-Request-Id - The Zuora internal identifier of the API call. You cannot control the value of this header.  <br>  * Zuora-Track-Id - A custom identifier for tracing the API call. If you specified a tracing identifier in the request headers, Zuora returns the same tracing identifier. Otherwise, Zuora does not set this header.  <br>  </td></tr>
         </table>
         */
        public ApiResponse<DeploymentManagerResponse> executeWithHttpInfo() throws ApiException {
            MetadataDeployTenantTemplateRequest metadataDeployTenantTemplateRequest = buildBodyParams();
            return deployTenantTemplateWithHttpInfo(description, name, sendEmail, template, inActiveProducts, activeProducts, activeRatePlans, inActiveRatePlans, compareField, metadataDeployTenantTemplateRequest, zuoraEntityIds, emails, comments);
        }

        /**
         * Execute deployTenantTemplate request (asynchronously)
         * @param _callback The callback to be executed when the API call finishes
         * @return The request call
         * @throws ApiException If fail to process the API call, e.g. serializing the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td>  </td><td>  * RateLimit-Remaining - The number of requests remaining in the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Reset - The number of seconds until the quota resets for the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Content-Encoding - This header is returned if you specify the &#x60;Accept-Encoding: gzip&#x60; request header and the response contains over 1000 bytes of data. Note that only the following MIME types support gzipped responses:   - &#x60;application/json&#x60;   - &#x60;application/xml&#x60;   - &#x60;text/html&#x60;   - &#x60;text/csv&#x60;   - &#x60;text/plain&#x60;  <br>  * RateLimit-Limit - The request limit quota for the time window closest to exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Zuora-Request-Id - The Zuora internal identifier of the API call. You cannot control the value of this header.  <br>  * Zuora-Track-Id - A custom identifier for tracing the API call. If you specified a tracing identifier in the request headers, Zuora returns the same tracing identifier. Otherwise, Zuora does not set this header.  <br>  </td></tr>
         </table>
         */
        public okhttp3.Call executeAsync(final ApiCallback<DeploymentManagerResponse> _callback) throws ApiException {
            MetadataDeployTenantTemplateRequest metadataDeployTenantTemplateRequest = buildBodyParams();
            return deployTenantTemplateAsync(description, name, sendEmail, template, inActiveProducts, activeProducts, activeRatePlans, inActiveRatePlans, compareField, metadataDeployTenantTemplateRequest, zuoraEntityIds, emails, comments, _callback);
        }
    }

    /**
     * Compare and deploy a template for product catalog to a tenant
     * Compare and deploy a template for product catalog to a tenant. 
     * @param description Deployment&#39;s description. (required)
     * @param name Deployment&#39;s name. (required)
     * @param sendEmail Specifies if an email should be sent. (required)
     * @param template Template file. (required)
     * @param inActiveProducts Specifies if inactive products needs to be migrated. (required)
     * @param activeProducts Specifies if active products needs to be migrated. (required)
     * @param activeRatePlans Specifies if active rate plans needs to be migrated. (required)
     * @param inActiveRatePlans Specifies if inactive rate plans needs to be migrated. (required)
     * @param compareField Specifies the compare field to be using during migration. (required)
     * @param metadataDeployTenantTemplateRequest  (required)
     * @return DeployTenantTemplateRequestBuilder
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td>  </td><td>  * RateLimit-Remaining - The number of requests remaining in the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Reset - The number of seconds until the quota resets for the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Content-Encoding - This header is returned if you specify the &#x60;Accept-Encoding: gzip&#x60; request header and the response contains over 1000 bytes of data. Note that only the following MIME types support gzipped responses:   - &#x60;application/json&#x60;   - &#x60;application/xml&#x60;   - &#x60;text/html&#x60;   - &#x60;text/csv&#x60;   - &#x60;text/plain&#x60;  <br>  * RateLimit-Limit - The request limit quota for the time window closest to exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Zuora-Request-Id - The Zuora internal identifier of the API call. You cannot control the value of this header.  <br>  * Zuora-Track-Id - A custom identifier for tracing the API call. If you specified a tracing identifier in the request headers, Zuora returns the same tracing identifier. Otherwise, Zuora does not set this header.  <br>  </td></tr>
     </table>
     */
    public DeployTenantTemplateRequestBuilder deployTenantTemplate(String description, String name, Boolean sendEmail, File template, Boolean inActiveProducts, Boolean activeProducts, Boolean activeRatePlans, Boolean inActiveRatePlans, String compareField) throws IllegalArgumentException {
        if (description == null) throw new IllegalArgumentException("\"description\" is required but got null");
            

        if (name == null) throw new IllegalArgumentException("\"name\" is required but got null");
            

        if (sendEmail == null) throw new IllegalArgumentException("\"sendEmail\" is required but got null");
        if (template == null) throw new IllegalArgumentException("\"template\" is required but got null");
        if (inActiveProducts == null) throw new IllegalArgumentException("\"inActiveProducts\" is required but got null");
        if (activeProducts == null) throw new IllegalArgumentException("\"activeProducts\" is required but got null");
        if (activeRatePlans == null) throw new IllegalArgumentException("\"activeRatePlans\" is required but got null");
        if (inActiveRatePlans == null) throw new IllegalArgumentException("\"inActiveRatePlans\" is required but got null");
        if (compareField == null) throw new IllegalArgumentException("\"compareField\" is required but got null");
            

        return new DeployTenantTemplateRequestBuilder(description, name, sendEmail, template, inActiveProducts, activeProducts, activeRatePlans, inActiveRatePlans, compareField);
    }
    private okhttp3.Call getDeploymentLogCall(String migrationId, String zuoraEntityIds, final ApiCallback _callback) throws ApiException {
        String basePath = null;
        // Operation Servers
        String[] localBasePaths = new String[] {  };

        // Determine Base Path to Use
        if (localCustomBaseUrl != null){
            basePath = localCustomBaseUrl;
        } else if ( localBasePaths.length > 0 ) {
            basePath = localBasePaths[localHostIndex];
        } else {
            basePath = null;
        }

        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/deployment-manager/deployments/{migrationId}"
            .replace("{" + "migrationId" + "}", localVarApiClient.escapeString(migrationId.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        if (zuoraEntityIds != null) {
            localVarHeaderParams.put("Zuora-Entity-Ids", localVarApiClient.parameterToString(zuoraEntityIds));
        }

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = {
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        if (localVarContentType != null) {
            localVarHeaderParams.put("Content-Type", localVarContentType);
        }

        String[] localVarAuthNames = new String[] {  };
        return localVarApiClient.buildCall(basePath, localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call getDeploymentLogValidateBeforeCall(String migrationId, String zuoraEntityIds, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'migrationId' is set
        if (migrationId == null) {
            throw new ApiException("Missing the required parameter 'migrationId' when calling getDeploymentLog(Async)");
        }

        return getDeploymentLogCall(migrationId, zuoraEntityIds, _callback);

    }


    private ApiResponse<MetadataGetDeploymentLogResponse> getDeploymentLogWithHttpInfo(String migrationId, String zuoraEntityIds) throws ApiException {
        okhttp3.Call localVarCall = getDeploymentLogValidateBeforeCall(migrationId, zuoraEntityIds, null);
        Type localVarReturnType = new TypeToken<MetadataGetDeploymentLogResponse>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    private okhttp3.Call getDeploymentLogAsync(String migrationId, String zuoraEntityIds, final ApiCallback<MetadataGetDeploymentLogResponse> _callback) throws ApiException {

        okhttp3.Call localVarCall = getDeploymentLogValidateBeforeCall(migrationId, zuoraEntityIds, _callback);
        Type localVarReturnType = new TypeToken<MetadataGetDeploymentLogResponse>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    public class GetDeploymentLogRequestBuilder {
        private final String migrationId;
        private String zuoraEntityIds;

        private GetDeploymentLogRequestBuilder(String migrationId) {
            this.migrationId = migrationId;
        }

        /**
         * Set zuoraEntityIds
         * @param zuoraEntityIds An entity ID. If you have [Zuora Multi-entity](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Multi-entity) enabled and the OAuth token is valid for more than one entity, you must use this header to specify which entity to perform the operation in. If the OAuth token is only valid for a single entity, or you do not have Zuora Multi-entity enabled, you do not need to set this header.   (optional)
         * @return GetDeploymentLogRequestBuilder
         */
        public GetDeploymentLogRequestBuilder zuoraEntityIds(String zuoraEntityIds) {
            this.zuoraEntityIds = zuoraEntityIds;
            return this;
        }
        
        /**
         * Build call for getDeploymentLog
         * @param _callback ApiCallback API callback
         * @return Call to execute
         * @throws ApiException If fail to serialize the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td>  </td><td>  -  </td></tr>
         </table>
         */
        public okhttp3.Call buildCall(final ApiCallback _callback) throws ApiException {
            return getDeploymentLogCall(migrationId, zuoraEntityIds, _callback);
        }


        /**
         * Execute getDeploymentLog request
         * @return MetadataGetDeploymentLogResponse
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td>  </td><td>  -  </td></tr>
         </table>
         */
        public MetadataGetDeploymentLogResponse execute() throws ApiException {
            ApiResponse<MetadataGetDeploymentLogResponse> localVarResp = getDeploymentLogWithHttpInfo(migrationId, zuoraEntityIds);
            return localVarResp.getResponseBody();
        }

        /**
         * Execute getDeploymentLog request with HTTP info returned
         * @return ApiResponse&lt;MetadataGetDeploymentLogResponse&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td>  </td><td>  -  </td></tr>
         </table>
         */
        public ApiResponse<MetadataGetDeploymentLogResponse> executeWithHttpInfo() throws ApiException {
            return getDeploymentLogWithHttpInfo(migrationId, zuoraEntityIds);
        }

        /**
         * Execute getDeploymentLog request (asynchronously)
         * @param _callback The callback to be executed when the API call finishes
         * @return The request call
         * @throws ApiException If fail to process the API call, e.g. serializing the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td>  </td><td>  -  </td></tr>
         </table>
         */
        public okhttp3.Call executeAsync(final ApiCallback<MetadataGetDeploymentLogResponse> _callback) throws ApiException {
            return getDeploymentLogAsync(migrationId, zuoraEntityIds, _callback);
        }
    }

    /**
     * Retrieve a deployment log
     * Retrieve a deployment log. 
     * @param migrationId The unique ID of a migration.  (required)
     * @return GetDeploymentLogRequestBuilder
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td>  </td><td>  -  </td></tr>
     </table>
     */
    public GetDeploymentLogRequestBuilder getDeploymentLog(String migrationId) throws IllegalArgumentException {
        if (migrationId == null) throw new IllegalArgumentException("\"migrationId\" is required but got null");
            

        return new GetDeploymentLogRequestBuilder(migrationId);
    }
    private okhttp3.Call revertDeploymentCall(String migrationId, String zuoraEntityIds, final ApiCallback _callback) throws ApiException {
        String basePath = null;
        // Operation Servers
        String[] localBasePaths = new String[] {  };

        // Determine Base Path to Use
        if (localCustomBaseUrl != null){
            basePath = localCustomBaseUrl;
        } else if ( localBasePaths.length > 0 ) {
            basePath = localBasePaths[localHostIndex];
        } else {
            basePath = null;
        }

        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/deployment-manager/deployments/{migrationId}/revert"
            .replace("{" + "migrationId" + "}", localVarApiClient.escapeString(migrationId.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        if (zuoraEntityIds != null) {
            localVarHeaderParams.put("Zuora-Entity-Ids", localVarApiClient.parameterToString(zuoraEntityIds));
        }

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = {
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        if (localVarContentType != null) {
            localVarHeaderParams.put("Content-Type", localVarContentType);
        }

        String[] localVarAuthNames = new String[] {  };
        return localVarApiClient.buildCall(basePath, localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call revertDeploymentValidateBeforeCall(String migrationId, String zuoraEntityIds, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'migrationId' is set
        if (migrationId == null) {
            throw new ApiException("Missing the required parameter 'migrationId' when calling revertDeployment(Async)");
        }

        return revertDeploymentCall(migrationId, zuoraEntityIds, _callback);

    }


    private ApiResponse<MetadataRevertDeploymentResponse> revertDeploymentWithHttpInfo(String migrationId, String zuoraEntityIds) throws ApiException {
        okhttp3.Call localVarCall = revertDeploymentValidateBeforeCall(migrationId, zuoraEntityIds, null);
        Type localVarReturnType = new TypeToken<MetadataRevertDeploymentResponse>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    private okhttp3.Call revertDeploymentAsync(String migrationId, String zuoraEntityIds, final ApiCallback<MetadataRevertDeploymentResponse> _callback) throws ApiException {

        okhttp3.Call localVarCall = revertDeploymentValidateBeforeCall(migrationId, zuoraEntityIds, _callback);
        Type localVarReturnType = new TypeToken<MetadataRevertDeploymentResponse>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    public class RevertDeploymentRequestBuilder {
        private final String migrationId;
        private String zuoraEntityIds;

        private RevertDeploymentRequestBuilder(String migrationId) {
            this.migrationId = migrationId;
        }

        /**
         * Set zuoraEntityIds
         * @param zuoraEntityIds An entity ID. If you have [Zuora Multi-entity](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Multi-entity) enabled and the OAuth token is valid for more than one entity, you must use this header to specify which entity to perform the operation in. If the OAuth token is only valid for a single entity, or you do not have Zuora Multi-entity enabled, you do not need to set this header.   (optional)
         * @return RevertDeploymentRequestBuilder
         */
        public RevertDeploymentRequestBuilder zuoraEntityIds(String zuoraEntityIds) {
            this.zuoraEntityIds = zuoraEntityIds;
            return this;
        }
        
        /**
         * Build call for revertDeployment
         * @param _callback ApiCallback API callback
         * @return Call to execute
         * @throws ApiException If fail to serialize the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td>  </td><td>  * RateLimit-Remaining - The number of requests remaining in the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Reset - The number of seconds until the quota resets for the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Content-Encoding - This header is returned if you specify the &#x60;Accept-Encoding: gzip&#x60; request header and the response contains over 1000 bytes of data. Note that only the following MIME types support gzipped responses:   - &#x60;application/json&#x60;   - &#x60;application/xml&#x60;   - &#x60;text/html&#x60;   - &#x60;text/csv&#x60;   - &#x60;text/plain&#x60;  <br>  * RateLimit-Limit - The request limit quota for the time window closest to exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Zuora-Request-Id - The Zuora internal identifier of the API call. You cannot control the value of this header.  <br>  * Zuora-Track-Id - A custom identifier for tracing the API call. If you specified a tracing identifier in the request headers, Zuora returns the same tracing identifier. Otherwise, Zuora does not set this header.  <br>  </td></tr>
         </table>
         */
        public okhttp3.Call buildCall(final ApiCallback _callback) throws ApiException {
            return revertDeploymentCall(migrationId, zuoraEntityIds, _callback);
        }


        /**
         * Execute revertDeployment request
         * @return MetadataRevertDeploymentResponse
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td>  </td><td>  * RateLimit-Remaining - The number of requests remaining in the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Reset - The number of seconds until the quota resets for the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Content-Encoding - This header is returned if you specify the &#x60;Accept-Encoding: gzip&#x60; request header and the response contains over 1000 bytes of data. Note that only the following MIME types support gzipped responses:   - &#x60;application/json&#x60;   - &#x60;application/xml&#x60;   - &#x60;text/html&#x60;   - &#x60;text/csv&#x60;   - &#x60;text/plain&#x60;  <br>  * RateLimit-Limit - The request limit quota for the time window closest to exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Zuora-Request-Id - The Zuora internal identifier of the API call. You cannot control the value of this header.  <br>  * Zuora-Track-Id - A custom identifier for tracing the API call. If you specified a tracing identifier in the request headers, Zuora returns the same tracing identifier. Otherwise, Zuora does not set this header.  <br>  </td></tr>
         </table>
         */
        public MetadataRevertDeploymentResponse execute() throws ApiException {
            ApiResponse<MetadataRevertDeploymentResponse> localVarResp = revertDeploymentWithHttpInfo(migrationId, zuoraEntityIds);
            return localVarResp.getResponseBody();
        }

        /**
         * Execute revertDeployment request with HTTP info returned
         * @return ApiResponse&lt;MetadataRevertDeploymentResponse&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td>  </td><td>  * RateLimit-Remaining - The number of requests remaining in the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Reset - The number of seconds until the quota resets for the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Content-Encoding - This header is returned if you specify the &#x60;Accept-Encoding: gzip&#x60; request header and the response contains over 1000 bytes of data. Note that only the following MIME types support gzipped responses:   - &#x60;application/json&#x60;   - &#x60;application/xml&#x60;   - &#x60;text/html&#x60;   - &#x60;text/csv&#x60;   - &#x60;text/plain&#x60;  <br>  * RateLimit-Limit - The request limit quota for the time window closest to exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Zuora-Request-Id - The Zuora internal identifier of the API call. You cannot control the value of this header.  <br>  * Zuora-Track-Id - A custom identifier for tracing the API call. If you specified a tracing identifier in the request headers, Zuora returns the same tracing identifier. Otherwise, Zuora does not set this header.  <br>  </td></tr>
         </table>
         */
        public ApiResponse<MetadataRevertDeploymentResponse> executeWithHttpInfo() throws ApiException {
            return revertDeploymentWithHttpInfo(migrationId, zuoraEntityIds);
        }

        /**
         * Execute revertDeployment request (asynchronously)
         * @param _callback The callback to be executed when the API call finishes
         * @return The request call
         * @throws ApiException If fail to process the API call, e.g. serializing the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td>  </td><td>  * RateLimit-Remaining - The number of requests remaining in the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Reset - The number of seconds until the quota resets for the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Content-Encoding - This header is returned if you specify the &#x60;Accept-Encoding: gzip&#x60; request header and the response contains over 1000 bytes of data. Note that only the following MIME types support gzipped responses:   - &#x60;application/json&#x60;   - &#x60;application/xml&#x60;   - &#x60;text/html&#x60;   - &#x60;text/csv&#x60;   - &#x60;text/plain&#x60;  <br>  * RateLimit-Limit - The request limit quota for the time window closest to exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Zuora-Request-Id - The Zuora internal identifier of the API call. You cannot control the value of this header.  <br>  * Zuora-Track-Id - A custom identifier for tracing the API call. If you specified a tracing identifier in the request headers, Zuora returns the same tracing identifier. Otherwise, Zuora does not set this header.  <br>  </td></tr>
         </table>
         */
        public okhttp3.Call executeAsync(final ApiCallback<MetadataRevertDeploymentResponse> _callback) throws ApiException {
            return revertDeploymentAsync(migrationId, zuoraEntityIds, _callback);
        }
    }

    /**
     * Revert a deployment
     * Revert a deployment. 
     * @param migrationId The unique ID of a migration.  (required)
     * @return RevertDeploymentRequestBuilder
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td>  </td><td>  * RateLimit-Remaining - The number of requests remaining in the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Reset - The number of seconds until the quota resets for the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Content-Encoding - This header is returned if you specify the &#x60;Accept-Encoding: gzip&#x60; request header and the response contains over 1000 bytes of data. Note that only the following MIME types support gzipped responses:   - &#x60;application/json&#x60;   - &#x60;application/xml&#x60;   - &#x60;text/html&#x60;   - &#x60;text/csv&#x60;   - &#x60;text/plain&#x60;  <br>  * RateLimit-Limit - The request limit quota for the time window closest to exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Zuora-Request-Id - The Zuora internal identifier of the API call. You cannot control the value of this header.  <br>  * Zuora-Track-Id - A custom identifier for tracing the API call. If you specified a tracing identifier in the request headers, Zuora returns the same tracing identifier. Otherwise, Zuora does not set this header.  <br>  </td></tr>
     </table>
     */
    public RevertDeploymentRequestBuilder revertDeployment(String migrationId) throws IllegalArgumentException {
        if (migrationId == null) throw new IllegalArgumentException("\"migrationId\" is required but got null");
            

        return new RevertDeploymentRequestBuilder(migrationId);
    }
}
