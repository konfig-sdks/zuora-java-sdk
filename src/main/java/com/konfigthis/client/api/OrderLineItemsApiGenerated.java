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


import com.konfigthis.client.model.CommonResponse;
import com.konfigthis.client.model.GetOrderLineItemResponseType;
import java.time.LocalDate;
import com.konfigthis.client.model.OrderLineItemCommon;
import com.konfigthis.client.model.PostOrderLineItemUpdateType;
import com.konfigthis.client.model.PostOrderLineItemsRequestType;
import com.konfigthis.client.model.ProcessingOptions;
import java.util.UUID;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ws.rs.core.GenericType;

public class OrderLineItemsApiGenerated {
    private ApiClient localVarApiClient;
    private int localHostIndex;
    private String localCustomBaseUrl;

    public OrderLineItemsApiGenerated() throws IllegalArgumentException {
        this(Configuration.getDefaultApiClient());
    }

    public OrderLineItemsApiGenerated(ApiClient apiClient) throws IllegalArgumentException {
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

    private okhttp3.Call orderLineItemCall(UUID itemId, String acceptEncoding, String contentEncoding, String authorization, String zuoraTrackId, String zuoraEntityIds, String zuoraOrgIds, Boolean fulfillment, final ApiCallback _callback) throws ApiException {
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
        String localVarPath = "/v1/order-line-items/{itemId}"
            .replace("{" + "itemId" + "}", localVarApiClient.escapeString(itemId.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        if (fulfillment != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("fulfillment", fulfillment));
        }

        if (acceptEncoding != null) {
            localVarHeaderParams.put("Accept-Encoding", localVarApiClient.parameterToString(acceptEncoding));
        }

        if (contentEncoding != null) {
            localVarHeaderParams.put("Content-Encoding", localVarApiClient.parameterToString(contentEncoding));
        }

        if (authorization != null) {
            localVarHeaderParams.put("Authorization", localVarApiClient.parameterToString(authorization));
        }

        if (zuoraTrackId != null) {
            localVarHeaderParams.put("Zuora-Track-Id", localVarApiClient.parameterToString(zuoraTrackId));
        }

        if (zuoraEntityIds != null) {
            localVarHeaderParams.put("Zuora-Entity-Ids", localVarApiClient.parameterToString(zuoraEntityIds));
        }

        if (zuoraOrgIds != null) {
            localVarHeaderParams.put("Zuora-Org-Ids", localVarApiClient.parameterToString(zuoraOrgIds));
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
    private okhttp3.Call orderLineItemValidateBeforeCall(UUID itemId, String acceptEncoding, String contentEncoding, String authorization, String zuoraTrackId, String zuoraEntityIds, String zuoraOrgIds, Boolean fulfillment, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'itemId' is set
        if (itemId == null) {
            throw new ApiException("Missing the required parameter 'itemId' when calling orderLineItem(Async)");
        }

        return orderLineItemCall(itemId, acceptEncoding, contentEncoding, authorization, zuoraTrackId, zuoraEntityIds, zuoraOrgIds, fulfillment, _callback);

    }


    private ApiResponse<GetOrderLineItemResponseType> orderLineItemWithHttpInfo(UUID itemId, String acceptEncoding, String contentEncoding, String authorization, String zuoraTrackId, String zuoraEntityIds, String zuoraOrgIds, Boolean fulfillment) throws ApiException {
        okhttp3.Call localVarCall = orderLineItemValidateBeforeCall(itemId, acceptEncoding, contentEncoding, authorization, zuoraTrackId, zuoraEntityIds, zuoraOrgIds, fulfillment, null);
        Type localVarReturnType = new TypeToken<GetOrderLineItemResponseType>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    private okhttp3.Call orderLineItemAsync(UUID itemId, String acceptEncoding, String contentEncoding, String authorization, String zuoraTrackId, String zuoraEntityIds, String zuoraOrgIds, Boolean fulfillment, final ApiCallback<GetOrderLineItemResponseType> _callback) throws ApiException {

        okhttp3.Call localVarCall = orderLineItemValidateBeforeCall(itemId, acceptEncoding, contentEncoding, authorization, zuoraTrackId, zuoraEntityIds, zuoraOrgIds, fulfillment, _callback);
        Type localVarReturnType = new TypeToken<GetOrderLineItemResponseType>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    public class OrderLineItemRequestBuilder {
        private final UUID itemId;
        private String acceptEncoding;
        private String contentEncoding;
        private String authorization;
        private String zuoraTrackId;
        private String zuoraEntityIds;
        private String zuoraOrgIds;
        private Boolean fulfillment;

        private OrderLineItemRequestBuilder(UUID itemId) {
            this.itemId = itemId;
        }

        /**
         * Set acceptEncoding
         * @param acceptEncoding Include the &#x60;Accept-Encoding: gzip&#x60; header to compress responses as a gzipped file. It can significantly reduce the bandwidth required for a response.   If specified, Zuora automatically compresses responses that contain over 1000 bytes of data, and the response contains a &#x60;Content-Encoding&#x60; header with the compression algorithm so that your client can decompress it.  (optional)
         * @return OrderLineItemRequestBuilder
         */
        public OrderLineItemRequestBuilder acceptEncoding(String acceptEncoding) {
            this.acceptEncoding = acceptEncoding;
            return this;
        }
        
        /**
         * Set contentEncoding
         * @param contentEncoding Include the &#x60;Content-Encoding: gzip&#x60; header to compress a request. With this header specified, you should upload a gzipped file for the request payload instead of sending the JSON payload.  (optional)
         * @return OrderLineItemRequestBuilder
         */
        public OrderLineItemRequestBuilder contentEncoding(String contentEncoding) {
            this.contentEncoding = contentEncoding;
            return this;
        }
        
        /**
         * Set authorization
         * @param authorization The value is in the &#x60;Bearer {token}&#x60; format where {token} is a valid OAuth token generated by calling [Create an OAuth token](https://developer.zuora.com/api-references/api/operation/createToken).  (optional)
         * @return OrderLineItemRequestBuilder
         */
        public OrderLineItemRequestBuilder authorization(String authorization) {
            this.authorization = authorization;
            return this;
        }
        
        /**
         * Set zuoraTrackId
         * @param zuoraTrackId A custom identifier for tracing the API call. If you set a value for this header, Zuora returns the same value in the response headers. This header enables you to associate your system process identifiers with Zuora API calls, to assist with troubleshooting in the event of an issue.  The value of this field must use the US-ASCII character set and must not include any of the following characters: colon (&#x60;:&#x60;), semicolon (&#x60;;&#x60;), double quote (&#x60;\&quot;&#x60;), and quote (&#x60;&#39;&#x60;).  (optional)
         * @return OrderLineItemRequestBuilder
         */
        public OrderLineItemRequestBuilder zuoraTrackId(String zuoraTrackId) {
            this.zuoraTrackId = zuoraTrackId;
            return this;
        }
        
        /**
         * Set zuoraEntityIds
         * @param zuoraEntityIds An entity ID. If you have [Zuora Multi-entity](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Multi-entity) enabled and the OAuth token is valid for more than one entity, you must use this header to specify which entity to perform the operation in. If the OAuth token is only valid for a single entity, or you do not have Zuora Multi-entity enabled, you do not need to set this header.  (optional)
         * @return OrderLineItemRequestBuilder
         */
        public OrderLineItemRequestBuilder zuoraEntityIds(String zuoraEntityIds) {
            this.zuoraEntityIds = zuoraEntityIds;
            return this;
        }
        
        /**
         * Set zuoraOrgIds
         * @param zuoraOrgIds Comma separated IDs. If you have &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Central_Platform/Multi-Org\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Zuora Multi-Org&lt;/a&gt; enabled,  you can use this header to specify which orgs to perform the operation in. If you do not have Zuora Multi-Org enabled, you should not set this header.  The IDs must be a sub-set of the user&#39;s accessible orgs. If you specify an org that the user does not have access to, the operation fails.  If the header is not set, the operation is performed in scope of the user&#39;s accessible orgs.  (optional)
         * @return OrderLineItemRequestBuilder
         */
        public OrderLineItemRequestBuilder zuoraOrgIds(String zuoraOrgIds) {
            this.zuoraOrgIds = zuoraOrgIds;
            return this;
        }
        
        /**
         * Set fulfillment
         * @param fulfillment Return the related fulfillments or not.  (optional, default to false)
         * @return OrderLineItemRequestBuilder
         */
        public OrderLineItemRequestBuilder fulfillment(Boolean fulfillment) {
            this.fulfillment = fulfillment;
            return this;
        }
        
        /**
         * Build call for orderLineItem
         * @param _callback ApiCallback API callback
         * @return Call to execute
         * @throws ApiException If fail to serialize the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td>  </td><td>  * Content-Encoding - This header is returned if you specify the &#x60;Accept-Encoding: gzip&#x60; request header and the response contains over 1000 bytes of data. Note that only the following MIME types support gzipped responses:   - &#x60;application/json&#x60;   - &#x60;application/xml&#x60;   - &#x60;text/html&#x60;   - &#x60;text/csv&#x60;   - &#x60;text/plain&#x60;  <br>  * RateLimit-Limit - The request limit quota for the time window closest to exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Remaining - The number of requests remaining in the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Reset - The number of seconds until the quota resets for the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Zuora-Request-Id - The Zuora internal identifier of the API call. You cannot control the value of this header.  <br>  * Zuora-Track-Id - A custom identifier for tracing the API call. If you specified a tracing identifier in the request headers, Zuora returns the same tracing identifier. Otherwise, Zuora does not set this header.  <br>  </td></tr>
         </table>
         */
        public okhttp3.Call buildCall(final ApiCallback _callback) throws ApiException {
            return orderLineItemCall(itemId, acceptEncoding, contentEncoding, authorization, zuoraTrackId, zuoraEntityIds, zuoraOrgIds, fulfillment, _callback);
        }


        /**
         * Execute orderLineItem request
         * @return GetOrderLineItemResponseType
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td>  </td><td>  * Content-Encoding - This header is returned if you specify the &#x60;Accept-Encoding: gzip&#x60; request header and the response contains over 1000 bytes of data. Note that only the following MIME types support gzipped responses:   - &#x60;application/json&#x60;   - &#x60;application/xml&#x60;   - &#x60;text/html&#x60;   - &#x60;text/csv&#x60;   - &#x60;text/plain&#x60;  <br>  * RateLimit-Limit - The request limit quota for the time window closest to exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Remaining - The number of requests remaining in the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Reset - The number of seconds until the quota resets for the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Zuora-Request-Id - The Zuora internal identifier of the API call. You cannot control the value of this header.  <br>  * Zuora-Track-Id - A custom identifier for tracing the API call. If you specified a tracing identifier in the request headers, Zuora returns the same tracing identifier. Otherwise, Zuora does not set this header.  <br>  </td></tr>
         </table>
         */
        public GetOrderLineItemResponseType execute() throws ApiException {
            ApiResponse<GetOrderLineItemResponseType> localVarResp = orderLineItemWithHttpInfo(itemId, acceptEncoding, contentEncoding, authorization, zuoraTrackId, zuoraEntityIds, zuoraOrgIds, fulfillment);
            return localVarResp.getResponseBody();
        }

        /**
         * Execute orderLineItem request with HTTP info returned
         * @return ApiResponse&lt;GetOrderLineItemResponseType&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td>  </td><td>  * Content-Encoding - This header is returned if you specify the &#x60;Accept-Encoding: gzip&#x60; request header and the response contains over 1000 bytes of data. Note that only the following MIME types support gzipped responses:   - &#x60;application/json&#x60;   - &#x60;application/xml&#x60;   - &#x60;text/html&#x60;   - &#x60;text/csv&#x60;   - &#x60;text/plain&#x60;  <br>  * RateLimit-Limit - The request limit quota for the time window closest to exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Remaining - The number of requests remaining in the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Reset - The number of seconds until the quota resets for the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Zuora-Request-Id - The Zuora internal identifier of the API call. You cannot control the value of this header.  <br>  * Zuora-Track-Id - A custom identifier for tracing the API call. If you specified a tracing identifier in the request headers, Zuora returns the same tracing identifier. Otherwise, Zuora does not set this header.  <br>  </td></tr>
         </table>
         */
        public ApiResponse<GetOrderLineItemResponseType> executeWithHttpInfo() throws ApiException {
            return orderLineItemWithHttpInfo(itemId, acceptEncoding, contentEncoding, authorization, zuoraTrackId, zuoraEntityIds, zuoraOrgIds, fulfillment);
        }

        /**
         * Execute orderLineItem request (asynchronously)
         * @param _callback The callback to be executed when the API call finishes
         * @return The request call
         * @throws ApiException If fail to process the API call, e.g. serializing the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td>  </td><td>  * Content-Encoding - This header is returned if you specify the &#x60;Accept-Encoding: gzip&#x60; request header and the response contains over 1000 bytes of data. Note that only the following MIME types support gzipped responses:   - &#x60;application/json&#x60;   - &#x60;application/xml&#x60;   - &#x60;text/html&#x60;   - &#x60;text/csv&#x60;   - &#x60;text/plain&#x60;  <br>  * RateLimit-Limit - The request limit quota for the time window closest to exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Remaining - The number of requests remaining in the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Reset - The number of seconds until the quota resets for the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Zuora-Request-Id - The Zuora internal identifier of the API call. You cannot control the value of this header.  <br>  * Zuora-Track-Id - A custom identifier for tracing the API call. If you specified a tracing identifier in the request headers, Zuora returns the same tracing identifier. Otherwise, Zuora does not set this header.  <br>  </td></tr>
         </table>
         */
        public okhttp3.Call executeAsync(final ApiCallback<GetOrderLineItemResponseType> _callback) throws ApiException {
            return orderLineItemAsync(itemId, acceptEncoding, contentEncoding, authorization, zuoraTrackId, zuoraEntityIds, zuoraOrgIds, fulfillment, _callback);
        }
    }

    /**
     * Retrieve an order line item
     * **Note:** The [Order Line Items](https://knowledgecenter.zuora.com/Billing/Subscriptions/Orders/Order_Line_Items/AA_Overview_of_Order_Line_Items) feature is now generally available to all Zuora customers. You need to enable the [Orders](https://knowledgecenter.zuora.com/BC_Subscription_Management/Orders/AA_Overview_of_Orders#Orders) feature to access the [Order Line Items](https://knowledgecenter.zuora.com/Billing/Subscriptions/Orders/Order_Line_Items/AA_Overview_of_Order_Line_Items) feature. As of Zuora Billing Release 313 (November 2021), new customers who onboard on [Orders](https://knowledgecenter.zuora.com/Billing/Subscriptions/Orders/AA_Overview_of_Orders) will have the [Order Line Items](https://knowledgecenter.zuora.com/Billing/Subscriptions/Orders/Order_Line_Items) feature enabled by default. If you are a new customer who onboard on [Orders Harmonization](https://knowledgecenter.zuora.com/Billing/Subscriptions/Orders/Orders_Harmonization/Orders_Harmonization) and want to enable the [Order Line Items](https://knowledgecenter.zuora.com/Billing/Subscriptions/Orders/Order_Line_Items) feature, submit a request at [Zuora Global Support](https://support.zuora.com/). If you are an existing [Orders](https://knowledgecenter.zuora.com/Billing/Subscriptions/Orders/AA_Overview_of_Orders) or [Orders Harmonization](https://knowledgecenter.zuora.com/Billing/Subscriptions/Orders/Orders_Harmonization/Orders_Harmonization) customer and want to enable the [Order Line Items](https://knowledgecenter.zuora.com/Billing/Subscriptions/Orders/Order_Line_Items) feature, submit a request at [Zuora Global Support](https://support.zuora.com/).  Retrieves the detailed information about a specified order line item. The following tutorial demonstrates how to use this operation: * [View details of an order line item](https://knowledgecenter.zuora.com/Billing/Subscriptions/Orders/Order_Line_Items/GJ_View_details_of_an_order_line_item) 
     * @param itemId The id of the Order Line Item to retrieve. (required)
     * @return OrderLineItemRequestBuilder
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td>  </td><td>  * Content-Encoding - This header is returned if you specify the &#x60;Accept-Encoding: gzip&#x60; request header and the response contains over 1000 bytes of data. Note that only the following MIME types support gzipped responses:   - &#x60;application/json&#x60;   - &#x60;application/xml&#x60;   - &#x60;text/html&#x60;   - &#x60;text/csv&#x60;   - &#x60;text/plain&#x60;  <br>  * RateLimit-Limit - The request limit quota for the time window closest to exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Remaining - The number of requests remaining in the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Reset - The number of seconds until the quota resets for the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Zuora-Request-Id - The Zuora internal identifier of the API call. You cannot control the value of this header.  <br>  * Zuora-Track-Id - A custom identifier for tracing the API call. If you specified a tracing identifier in the request headers, Zuora returns the same tracing identifier. Otherwise, Zuora does not set this header.  <br>  </td></tr>
     </table>
     */
    public OrderLineItemRequestBuilder orderLineItem(UUID itemId) throws IllegalArgumentException {
        if (itemId == null) throw new IllegalArgumentException("\"itemId\" is required but got null");
            

        return new OrderLineItemRequestBuilder(itemId);
    }
    private okhttp3.Call orderLineItem_0Call(UUID itemId, OrderLineItemCommon orderLineItemCommon, String acceptEncoding, String contentEncoding, String authorization, String zuoraTrackId, String zuoraEntityIds, String zuoraOrgIds, final ApiCallback _callback) throws ApiException {
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

        Object localVarPostBody = orderLineItemCommon;

        // create path and map variables
        String localVarPath = "/v1/order-line-items/{itemId}"
            .replace("{" + "itemId" + "}", localVarApiClient.escapeString(itemId.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        if (acceptEncoding != null) {
            localVarHeaderParams.put("Accept-Encoding", localVarApiClient.parameterToString(acceptEncoding));
        }

        if (contentEncoding != null) {
            localVarHeaderParams.put("Content-Encoding", localVarApiClient.parameterToString(contentEncoding));
        }

        if (authorization != null) {
            localVarHeaderParams.put("Authorization", localVarApiClient.parameterToString(authorization));
        }

        if (zuoraTrackId != null) {
            localVarHeaderParams.put("Zuora-Track-Id", localVarApiClient.parameterToString(zuoraTrackId));
        }

        if (zuoraEntityIds != null) {
            localVarHeaderParams.put("Zuora-Entity-Ids", localVarApiClient.parameterToString(zuoraEntityIds));
        }

        if (zuoraOrgIds != null) {
            localVarHeaderParams.put("Zuora-Org-Ids", localVarApiClient.parameterToString(zuoraOrgIds));
        }

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        if (localVarContentType != null) {
            localVarHeaderParams.put("Content-Type", localVarContentType);
        }

        String[] localVarAuthNames = new String[] {  };
        return localVarApiClient.buildCall(basePath, localVarPath, "PUT", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call orderLineItem_0ValidateBeforeCall(UUID itemId, OrderLineItemCommon orderLineItemCommon, String acceptEncoding, String contentEncoding, String authorization, String zuoraTrackId, String zuoraEntityIds, String zuoraOrgIds, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'itemId' is set
        if (itemId == null) {
            throw new ApiException("Missing the required parameter 'itemId' when calling orderLineItem_0(Async)");
        }

        // verify the required parameter 'orderLineItemCommon' is set
        if (orderLineItemCommon == null) {
            throw new ApiException("Missing the required parameter 'orderLineItemCommon' when calling orderLineItem_0(Async)");
        }

        return orderLineItem_0Call(itemId, orderLineItemCommon, acceptEncoding, contentEncoding, authorization, zuoraTrackId, zuoraEntityIds, zuoraOrgIds, _callback);

    }


    private ApiResponse<CommonResponse> orderLineItem_0WithHttpInfo(UUID itemId, OrderLineItemCommon orderLineItemCommon, String acceptEncoding, String contentEncoding, String authorization, String zuoraTrackId, String zuoraEntityIds, String zuoraOrgIds) throws ApiException {
        okhttp3.Call localVarCall = orderLineItem_0ValidateBeforeCall(itemId, orderLineItemCommon, acceptEncoding, contentEncoding, authorization, zuoraTrackId, zuoraEntityIds, zuoraOrgIds, null);
        Type localVarReturnType = new TypeToken<CommonResponse>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    private okhttp3.Call orderLineItem_0Async(UUID itemId, OrderLineItemCommon orderLineItemCommon, String acceptEncoding, String contentEncoding, String authorization, String zuoraTrackId, String zuoraEntityIds, String zuoraOrgIds, final ApiCallback<CommonResponse> _callback) throws ApiException {

        okhttp3.Call localVarCall = orderLineItem_0ValidateBeforeCall(itemId, orderLineItemCommon, acceptEncoding, contentEncoding, authorization, zuoraTrackId, zuoraEntityIds, zuoraOrgIds, _callback);
        Type localVarReturnType = new TypeToken<CommonResponse>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    public class OrderLineItem0RequestBuilder {
        private final UUID itemId;
        private String description;
        private String UOM;
        private String accountingCode;
        private String adjustmentLiabilityAccountingCode;
        private String adjustmentRevenueAccountingCode;
        private Double amountPerUnit;
        private LocalDate billTargetDate;
        private String billTo;
        private String billingRule;
        private String contractAssetAccountingCode;
        private String contractLiabilityAccountingCode;
        private String contractRecognizedRevenueAccountingCode;
        private Map<String, Object> customFields;
        private String deferredRevenueAccountingCode;
        private Boolean excludeItemBillingFromRevenueAccounting;
        private Boolean excludeItemBookingFromRevenueAccounting;
        private String invoiceGroupNumber;
        private Double inlineDiscountPerUnit;
        private String inlineDiscountType;
        private Boolean isAllocationEligible;
        private Boolean isUnbilled;
        private String itemName;
        private String itemNumber;
        private String itemState;
        private String itemType;
        private Double listPricePerUnit;
        private String ownerAccountNumber;
        private String productCode;
        private String purchaseOrderNumber;
        private Double quantity;
        private String recognizedRevenueAccountingCode;
        private String relatedSubscriptionNumber;
        private String revenueRecognitionRule;
        private String revenueRecognitionTiming;
        private String revenueAmortizationMethod;
        private String sequenceSetId;
        private String soldTo;
        private String taxCode;
        private String taxMode;
        private LocalDate transactionEndDate;
        private LocalDate transactionStartDate;
        private String unbilledReceivablesAccountingCode;
        private String acceptEncoding;
        private String contentEncoding;
        private String authorization;
        private String zuoraTrackId;
        private String zuoraEntityIds;
        private String zuoraOrgIds;

        private OrderLineItem0RequestBuilder(UUID itemId) {
            this.itemId = itemId;
        }

        /**
         * Set description
         * @param description The description of the Order Line Item (OLI).  You can update this field for a sales or return OLI only when the OLI is in the &#x60;Executing&#x60; state (when the &#x60;itemState&#x60; field is set as &#x60;Executing&#x60;).  (optional)
         * @return OrderLineItem0RequestBuilder
         */
        public OrderLineItem0RequestBuilder description(String description) {
            this.description = description;
            return this;
        }
        
        /**
         * Set UOM
         * @param UOM Specifies the units to measure usage.  You can update this field only for a sales OLI and only when the sales OLI is in the &#x60;Executing&#x60; state (when the &#x60;itemState&#x60; field is set as &#x60;Executing&#x60;).  (optional)
         * @return OrderLineItem0RequestBuilder
         */
        public OrderLineItem0RequestBuilder UOM(String UOM) {
            this.UOM = UOM;
            return this;
        }
        
        /**
         * Set accountingCode
         * @param accountingCode The accountingCode for the Order Line Item (OLI).  You can update this field only for a sales OLI and only when the sales OLI is in the &#x60;Executing&#x60; state (when the &#x60;itemState&#x60; field is set as &#x60;Executing&#x60;).  (optional)
         * @return OrderLineItem0RequestBuilder
         */
        public OrderLineItem0RequestBuilder accountingCode(String accountingCode) {
            this.accountingCode = accountingCode;
            return this;
        }
        
        /**
         * Set adjustmentLiabilityAccountingCode
         * @param adjustmentLiabilityAccountingCode The accounting code on the Order Line Item object for customers using [Zuora Billing - Revenue Integration](https://knowledgecenter.zuora.com/Zuora_Revenue/Zuora_Billing_-_Revenue_Integration).  You can update this field only for a sales OLI and only when the sales OLI is in the &#x60;Executing&#x60; state (when the &#x60;itemState&#x60; field is set as &#x60;Executing&#x60;).  (optional)
         * @return OrderLineItem0RequestBuilder
         */
        public OrderLineItem0RequestBuilder adjustmentLiabilityAccountingCode(String adjustmentLiabilityAccountingCode) {
            this.adjustmentLiabilityAccountingCode = adjustmentLiabilityAccountingCode;
            return this;
        }
        
        /**
         * Set adjustmentRevenueAccountingCode
         * @param adjustmentRevenueAccountingCode The accounting code on the Order Line Item object for customers using [Zuora Billing - Revenue Integration](https://knowledgecenter.zuora.com/Zuora_Revenue/Zuora_Billing_-_Revenue_Integration).  You can update this field only for a sales OLI and only when the sales OLI is in the &#x60;Executing&#x60; state (when the &#x60;itemState&#x60; field is set as &#x60;Executing&#x60;).  (optional)
         * @return OrderLineItem0RequestBuilder
         */
        public OrderLineItem0RequestBuilder adjustmentRevenueAccountingCode(String adjustmentRevenueAccountingCode) {
            this.adjustmentRevenueAccountingCode = adjustmentRevenueAccountingCode;
            return this;
        }
        
        /**
         * Set amountPerUnit
         * @param amountPerUnit The actual charged amount per unit for the Order Line Item (OLI).  You can update this field only for a sales OLI and only when the sales OLI is in the &#x60;Executing&#x60; state (when the &#x60;itemState&#x60; field is set as &#x60;Executing&#x60;).  (optional)
         * @return OrderLineItem0RequestBuilder
         */
        public OrderLineItem0RequestBuilder amountPerUnit(Double amountPerUnit) {
            this.amountPerUnit = amountPerUnit;
            return this;
        }
        
        /**
         * Set billTargetDate
         * @param billTargetDate The target date for the Order Line Item (OLI) to be picked up by bill run for generating billing documents.  To generate billing documents for an OLI, you must set this field and set the &#x60;itemState&#x60; field to &#x60;SentToBilling&#x60;.  You can update this field for a sales or return OLI only when the OLI is in the &#x60;Executing&#x60; state (when the &#x60;itemState&#x60; field is set as &#x60;Executing&#x60;).  (optional)
         * @return OrderLineItem0RequestBuilder
         */
        public OrderLineItem0RequestBuilder billTargetDate(LocalDate billTargetDate) {
            this.billTargetDate = billTargetDate;
            return this;
        }
        
        /**
         * Set billTo
         * @param billTo The ID of a contact that belongs to the billing account of the order line item. Use this field to assign an existing account as the bill-to contact of an order line item.  You can update this field only for a sales OLI and only when the sales OLI is in the &#x60;Executing&#x60; state (when the &#x60;itemState&#x60; field is set as &#x60;Executing&#x60;).  (optional)
         * @return OrderLineItem0RequestBuilder
         */
        public OrderLineItem0RequestBuilder billTo(String billTo) {
            this.billTo = billTo;
            return this;
        }
        
        /**
         * Set billingRule
         * @param billingRule The rule for billing of the Order Line Item (OLI).  You can update this field for a sales or return OLI only when it is in the &#x60;Executing&#x60; state (when the &#x60;itemState&#x60; field is set as &#x60;Executing&#x60;).  (optional, default to TriggerWithoutFulfillment)
         * @return OrderLineItem0RequestBuilder
         */
        public OrderLineItem0RequestBuilder billingRule(String billingRule) {
            this.billingRule = billingRule;
            return this;
        }
        
        /**
         * Set contractAssetAccountingCode
         * @param contractAssetAccountingCode The accounting code on the Order Line Item object for customers using [Zuora Billing - Revenue Integration](https://knowledgecenter.zuora.com/Zuora_Revenue/Zuora_Billing_-_Revenue_Integration).  You can update this field only for a sales OLI and only when the sales OLI is in the &#x60;Executing&#x60; state (when the &#x60;itemState&#x60; field is set as &#x60;Executing&#x60;).  (optional)
         * @return OrderLineItem0RequestBuilder
         */
        public OrderLineItem0RequestBuilder contractAssetAccountingCode(String contractAssetAccountingCode) {
            this.contractAssetAccountingCode = contractAssetAccountingCode;
            return this;
        }
        
        /**
         * Set contractLiabilityAccountingCode
         * @param contractLiabilityAccountingCode The accounting code on the Order Line Item object for customers using [Zuora Billing - Revenue Integration](https://knowledgecenter.zuora.com/Zuora_Revenue/Zuora_Billing_-_Revenue_Integration).  You can update this field only for a sales OLI and only when the sales OLI is in the &#x60;Executing&#x60; state (when the &#x60;itemState&#x60; field is set as &#x60;Executing&#x60;).  (optional)
         * @return OrderLineItem0RequestBuilder
         */
        public OrderLineItem0RequestBuilder contractLiabilityAccountingCode(String contractLiabilityAccountingCode) {
            this.contractLiabilityAccountingCode = contractLiabilityAccountingCode;
            return this;
        }
        
        /**
         * Set contractRecognizedRevenueAccountingCode
         * @param contractRecognizedRevenueAccountingCode The accounting code on the Order Line Item object for customers using [Zuora Billing - Revenue Integration](https://knowledgecenter.zuora.com/Zuora_Revenue/Zuora_Billing_-_Revenue_Integration).  You can update this field only for a sales OLI and only when the sales OLI is in the &#x60;Executing&#x60; state (when the &#x60;itemState&#x60; field is set as &#x60;Executing&#x60;).  (optional)
         * @return OrderLineItem0RequestBuilder
         */
        public OrderLineItem0RequestBuilder contractRecognizedRevenueAccountingCode(String contractRecognizedRevenueAccountingCode) {
            this.contractRecognizedRevenueAccountingCode = contractRecognizedRevenueAccountingCode;
            return this;
        }
        
        /**
         * Set customFields
         * @param customFields Container for custom fields of an Order Line Item object.  (optional)
         * @return OrderLineItem0RequestBuilder
         */
        public OrderLineItem0RequestBuilder customFields(Map<String, Object> customFields) {
            this.customFields = customFields;
            return this;
        }
        
        /**
         * Set deferredRevenueAccountingCode
         * @param deferredRevenueAccountingCode The deferred revenue accounting code for the Order Line Item (OLI).  You can update this field only for a sales OLI and only when the sales OLI is in the &#x60;Executing&#x60; state (when the &#x60;itemState&#x60; field is set as &#x60;Executing&#x60;).  (optional)
         * @return OrderLineItem0RequestBuilder
         */
        public OrderLineItem0RequestBuilder deferredRevenueAccountingCode(String deferredRevenueAccountingCode) {
            this.deferredRevenueAccountingCode = deferredRevenueAccountingCode;
            return this;
        }
        
        /**
         * Set excludeItemBillingFromRevenueAccounting
         * @param excludeItemBillingFromRevenueAccounting Indicates whether to exclude the related invoice items, invoice item adjustments, credit memo items, and debit memo items from revenue accounting.  **Note**: This field is only available if you have the Order to Revenue or Billing - Revenue Integration feature enabled.   (optional)
         * @return OrderLineItem0RequestBuilder
         */
        public OrderLineItem0RequestBuilder excludeItemBillingFromRevenueAccounting(Boolean excludeItemBillingFromRevenueAccounting) {
            this.excludeItemBillingFromRevenueAccounting = excludeItemBillingFromRevenueAccounting;
            return this;
        }
        
        /**
         * Set excludeItemBookingFromRevenueAccounting
         * @param excludeItemBookingFromRevenueAccounting Indicates whether to exclude the related rate plan charges and order line items from revenue accounting.  **Note**: This field is only available if you have the Order to Revenue or Billing - Revenue Integration feature enabled.  (optional)
         * @return OrderLineItem0RequestBuilder
         */
        public OrderLineItem0RequestBuilder excludeItemBookingFromRevenueAccounting(Boolean excludeItemBookingFromRevenueAccounting) {
            this.excludeItemBookingFromRevenueAccounting = excludeItemBookingFromRevenueAccounting;
            return this;
        }
        
        /**
         * Set invoiceGroupNumber
         * @param invoiceGroupNumber The number of the invoice group associated with the order line item.  After enabling the Invoice Grouping feature, you can specify invoice group numbers to bill subscriptions and order line items based on specific criteria. For the same account, Zuora generates separate invoices for subscriptions and order line items, each identified by unique invoice group numbers. For more information, see [Invoice Grouping](https://knowledgecenter.zuora.com/Billing/Subscriptions/Invoice_Grouping).  **Note**:    - If you have the &lt;a href&#x3D;\\\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Bill_your_customers/Bill_customers_at_subscription_level/Flexible_Billing_Attributes\\\&quot; target&#x3D;\\\&quot;_blank\\\&quot;&gt;Flexible Billing Attributes&lt;/a&gt; feature disabled, this field is unavailable in the request body and the value of this field is &#x60;null&#x60; in the response body.    - If you have the Flexible Billing Attributes feature enabled, and you do not specify this field in the request during subscription creation, the value of this field is automatically set to &#x60;null&#x60; in the response body.  (optional)
         * @return OrderLineItem0RequestBuilder
         */
        public OrderLineItem0RequestBuilder invoiceGroupNumber(String invoiceGroupNumber) {
            this.invoiceGroupNumber = invoiceGroupNumber;
            return this;
        }
        
        /**
         * Set inlineDiscountPerUnit
         * @param inlineDiscountPerUnit You can update this field only for a sales OLI and only when the sales OLI is in the &#x60;Executing&#x60; state (when the &#x60;itemState&#x60; field is set as &#x60;Executing&#x60;).  Use this field in accordance with the &#x60;inlineDiscountType&#x60; field, in the following manner: * If the &#x60;inlineDiscountType&#x60; field is set as &#x60;Percentage&#x60;, this field specifies the discount percentage for each unit of the order line item. For exmaple, if you specify &#x60;5&#x60; in this field, the discount percentage is 5%. * If the &#x60;inlineDiscountType&#x60; field is set as &#x60;FixedAmount&#x60;, this field specifies the discount amount on each unit of the order line item. For exmaple, if you specify &#x60;10&#x60; in this field, the discount amount on each unit of the order line item is 10.  Once you set the &#x60;inlineDiscountType&#x60;, &#x60;inlineDiscountPerUnit&#x60;, and &#x60;listPricePerUnit&#x60; fields, the system will automatically generate the &#x60;amountPerUnit&#x60; field. You shall not set the &#x60;amountPerUnit&#x60; field by yourself.  (optional)
         * @return OrderLineItem0RequestBuilder
         */
        public OrderLineItem0RequestBuilder inlineDiscountPerUnit(Double inlineDiscountPerUnit) {
            this.inlineDiscountPerUnit = inlineDiscountPerUnit;
            return this;
        }
        
        /**
         * Set inlineDiscountType
         * @param inlineDiscountType You can update this field only for a sales OLI and only when the sales OLI is in the &#x60;Executing&#x60; state (when the &#x60;itemState&#x60; field is set as &#x60;Executing&#x60;).  Use this field to specify the inline discount type, which can be &#x60;Percentage&#x60;, &#x60;FixedAmount&#x60;, or &#x60;None&#x60;. The default value is &#x60;Percentage&#x60;.  Use this field together with the &#x60;inlineDiscountPerUnit&#x60; field to specify inline discounts for order line items. The inline discount is applied to the list price of an order line item.   Once you set the &#x60;inlineDiscountType&#x60;, &#x60;inlineDiscountPerUnit&#x60;, and &#x60;listPricePerUnit&#x60; fields, the system will automatically generate the &#x60;amountPerUnit&#x60; field. You shall not set the &#x60;amountPerUnit&#x60; field by yourself.  (optional)
         * @return OrderLineItem0RequestBuilder
         */
        public OrderLineItem0RequestBuilder inlineDiscountType(String inlineDiscountType) {
            this.inlineDiscountType = inlineDiscountType;
            return this;
        }
        
        /**
         * Set isAllocationEligible
         * @param isAllocationEligible This field is used to identify if the charge segment is allocation eligible in revenue recognition.  **Note**: This feature is in the **Early Adopter** phase. If you want to use the feature, submit a request at &lt;a href&#x3D;\\\&quot;https://support.zuora.com/\\\&quot; target&#x3D;\\\&quot;_blank\\\&quot;&gt;Zuora Global Support&lt;/a&gt;, and we will evaluate whether the feature is suitable for your use cases.  (optional)
         * @return OrderLineItem0RequestBuilder
         */
        public OrderLineItem0RequestBuilder isAllocationEligible(Boolean isAllocationEligible) {
            this.isAllocationEligible = isAllocationEligible;
            return this;
        }
        
        /**
         * Set isUnbilled
         * @param isUnbilled This field is used to dictate how to perform the accounting during revenue recognition.  **Note**: This feature is in the **Early Adopter** phase. If you want to use the feature, submit a request at &lt;a href&#x3D;\\\&quot;https://support.zuora.com/\\\&quot; target&#x3D;\\\&quot;_blank\\\&quot;&gt;Zuora Global Support&lt;/a&gt;, and we will evaluate whether the feature is suitable for your use cases.  (optional)
         * @return OrderLineItem0RequestBuilder
         */
        public OrderLineItem0RequestBuilder isUnbilled(Boolean isUnbilled) {
            this.isUnbilled = isUnbilled;
            return this;
        }
        
        /**
         * Set itemName
         * @param itemName The name of the Order Line Item (OLI).  You can update this field for a sales or return OLI only when the OLI is in the &#x60;Executing&#x60; state (when the &#x60;itemState&#x60; field is set as &#x60;Executing&#x60;).  (optional)
         * @return OrderLineItem0RequestBuilder
         */
        public OrderLineItem0RequestBuilder itemName(String itemName) {
            this.itemName = itemName;
            return this;
        }
        
        /**
         * Set itemNumber
         * @param itemNumber The number for the Order Line Item (OLI).  You can update this field for a sales or return OLI only when the OLI is in the &#x60;Executing&#x60; state (when the &#x60;itemState&#x60; field is set as &#x60;Executing&#x60;).  (optional)
         * @return OrderLineItem0RequestBuilder
         */
        public OrderLineItem0RequestBuilder itemNumber(String itemNumber) {
            this.itemNumber = itemNumber;
            return this;
        }
        
        /**
         * Set itemState
         * @param itemState The state of the Order Line Item (OLI). See [State transitions for an order, order line item, and fulfillment](https://knowledgecenter.zuora.com/Billing/Subscriptions/Orders/Order_Line_Items/AB_Order_Line_Item_States_and_Order_States) for more information.  To generate invoice for an OLI, you must set this field to &#x60;SentToBilling&#x60; and set the &#x60;billTargetDate&#x60; field .  You can update this field for a sales or return OLI only when the OLI is in the &#x60;Executing&#x60; or &#39;Booked&#39; or &#x60;SentToBilling&#x60;state (when the &#x60;itemState&#x60; field is set as &#x60;Executing&#x60; or &#x60;SentToBilling&#x60;).  (optional)
         * @return OrderLineItem0RequestBuilder
         */
        public OrderLineItem0RequestBuilder itemState(String itemState) {
            this.itemState = itemState;
            return this;
        }
        
        /**
         * Set itemType
         * @param itemType The type of the Order Line Item (OLI).   You can update this field only for a sales OLI and only when the sales OLI is in the &#x60;Executing&#x60; state (when the &#x60;itemState&#x60; field is set as &#x60;Executing&#x60;).  (optional)
         * @return OrderLineItem0RequestBuilder
         */
        public OrderLineItem0RequestBuilder itemType(String itemType) {
            this.itemType = itemType;
            return this;
        }
        
        /**
         * Set listPricePerUnit
         * @param listPricePerUnit The list price per unit for the Order Line Item (OLI).  You can update this field only for a sales OLI and only when the sales OLI is in the &#x60;Executing&#x60; state (when the &#x60;itemState&#x60; field is set as &#x60;Executing&#x60;).  (optional)
         * @return OrderLineItem0RequestBuilder
         */
        public OrderLineItem0RequestBuilder listPricePerUnit(Double listPricePerUnit) {
            this.listPricePerUnit = listPricePerUnit;
            return this;
        }
        
        /**
         * Set ownerAccountNumber
         * @param ownerAccountNumber Use this field to assign an existing account as the owner of an order line item.  You can update this field only for a sales OLI and only when the sales OLI is in the &#x60;Executing&#x60; state (when the &#x60;itemState&#x60; field is set as &#x60;Executing&#x60;).  (optional)
         * @return OrderLineItem0RequestBuilder
         */
        public OrderLineItem0RequestBuilder ownerAccountNumber(String ownerAccountNumber) {
            this.ownerAccountNumber = ownerAccountNumber;
            return this;
        }
        
        /**
         * Set productCode
         * @param productCode The product code for the Order Line Item (OLI).  You can update this field only for a sales OLI and only when the sales OLI is in the &#x60;Executing&#x60; state (when the &#x60;itemState&#x60; field is set as &#x60;Executing&#x60;).  (optional)
         * @return OrderLineItem0RequestBuilder
         */
        public OrderLineItem0RequestBuilder productCode(String productCode) {
            this.productCode = productCode;
            return this;
        }
        
        /**
         * Set purchaseOrderNumber
         * @param purchaseOrderNumber Used by customers to specify the Purchase Order Number provided by the buyer.  You can update this field only for a sales OLI and only when the sales OLI is in the &#x60;Executing&#x60; state (when the &#x60;itemState&#x60; field is set as &#x60;Executing&#x60;).  (optional)
         * @return OrderLineItem0RequestBuilder
         */
        public OrderLineItem0RequestBuilder purchaseOrderNumber(String purchaseOrderNumber) {
            this.purchaseOrderNumber = purchaseOrderNumber;
            return this;
        }
        
        /**
         * Set quantity
         * @param quantity The quantity of units, such as the number of authors in a hosted wiki service.  You can update this field for a sales or return OLI only when the OLI in the &#x60;Executing&#x60; state (when the &#x60;itemState&#x60; field is set as &#x60;Executing&#x60;).  (optional)
         * @return OrderLineItem0RequestBuilder
         */
        public OrderLineItem0RequestBuilder quantity(Double quantity) {
            this.quantity = quantity;
            return this;
        }
        
        /**
         * Set recognizedRevenueAccountingCode
         * @param recognizedRevenueAccountingCode The recognized revenue accounting code for the Order Line Item (OLI).  You can update this field only for a sales OLI and only when the sales OLI is in the &#x60;Executing&#x60; state (when the &#x60;itemState&#x60; field is set as &#x60;Executing&#x60;).  (optional)
         * @return OrderLineItem0RequestBuilder
         */
        public OrderLineItem0RequestBuilder recognizedRevenueAccountingCode(String recognizedRevenueAccountingCode) {
            this.recognizedRevenueAccountingCode = recognizedRevenueAccountingCode;
            return this;
        }
        
        /**
         * Set relatedSubscriptionNumber
         * @param relatedSubscriptionNumber Use this field to relate an order line item to an subscription. Specify this field to the subscription number of the subscription to relate.  You can update this field only for a sales OLI and only when the sales OLI is in the &#x60;Executing&#x60; state (when the &#x60;itemState&#x60; field is set as &#x60;Executing&#x60;).  (optional)
         * @return OrderLineItem0RequestBuilder
         */
        public OrderLineItem0RequestBuilder relatedSubscriptionNumber(String relatedSubscriptionNumber) {
            this.relatedSubscriptionNumber = relatedSubscriptionNumber;
            return this;
        }
        
        /**
         * Set revenueRecognitionRule
         * @param revenueRecognitionRule The Revenue Recognition rule for the Order Line Item (OLI).  You can update this field only for a sales OLI and only when the sales OLI is in the &#x60;Executing&#x60; state (when the &#x60;itemState&#x60; field is set as &#x60;Executing&#x60;).  (optional)
         * @return OrderLineItem0RequestBuilder
         */
        public OrderLineItem0RequestBuilder revenueRecognitionRule(String revenueRecognitionRule) {
            this.revenueRecognitionRule = revenueRecognitionRule;
            return this;
        }
        
        /**
         * Set revenueRecognitionTiming
         * @param revenueRecognitionTiming Specifies the type of revenue recognition timing.  Predefined options are listed as enum values in this API Reference. Other options might also be avaliable depending on the &lt;a href&#x3D;\\\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Enable_Order_to_Revenue/Configure_revenue_settings/Configure_revenue_recognition_policy\\\&quot; target&#x3D;\\\&quot;_blank\\\&quot;&gt;revenue recognition policy configuration&lt;/a&gt; in the Zuora Billing UI.  You can update this field only for a sales OLI and only when the sales OLI is in the &#x60;Executing&#x60; state (when the &#x60;itemState&#x60; field is set as &#x60;Executing&#x60;).  **Note**: This field is only available if you have the Order to Revenue feature enabled.   (optional)
         * @return OrderLineItem0RequestBuilder
         */
        public OrderLineItem0RequestBuilder revenueRecognitionTiming(String revenueRecognitionTiming) {
            this.revenueRecognitionTiming = revenueRecognitionTiming;
            return this;
        }
        
        /**
         * Set revenueAmortizationMethod
         * @param revenueAmortizationMethod Specifies the type of revenue amortization method.  Predefined options are listed as enum values in this API Reference. Other options might also be avaliable depending on the &lt;a href&#x3D;\\\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Enable_Order_to_Revenue/Configure_revenue_settings/Configure_revenue_recognition_policy\\\&quot; target&#x3D;\\\&quot;_blank\\\&quot;&gt;revenue recognition policy configuration&lt;/a&gt; in the Zuora Billing UI.  You can update this field only for a sales OLI and only when the sales OLI is in the &#x60;Executing&#x60; state (when the &#x60;itemState&#x60; field is set as &#x60;Executing&#x60;).  **Note**: This field is only available if you have the Order to Revenue feature enabled.   (optional)
         * @return OrderLineItem0RequestBuilder
         */
        public OrderLineItem0RequestBuilder revenueAmortizationMethod(String revenueAmortizationMethod) {
            this.revenueAmortizationMethod = revenueAmortizationMethod;
            return this;
        }
        
        /**
         * Set sequenceSetId
         * @param sequenceSetId The ID of the sequence set associated with the orderLineItem.  (optional)
         * @return OrderLineItem0RequestBuilder
         */
        public OrderLineItem0RequestBuilder sequenceSetId(String sequenceSetId) {
            this.sequenceSetId = sequenceSetId;
            return this;
        }
        
        /**
         * Set soldTo
         * @param soldTo Use this field to assign an existing account as the sold-to contact of an order line item, by the following rules:  * If the &#x60;ownerAccountNumber&#x60; field is set, then this field must be the ID of a contact that belongs to the owner account of the order line item.  * If the &#x60;ownerAccountNumber&#x60; field is not set, then this field must be the ID of a contact that belongs to the billing account of the order line item.  You can update this field only for a sales OLI and only when the sales OLI is in the &#x60;Executing&#x60; state (when the &#x60;itemState&#x60; field is set as &#x60;Executing&#x60;).  (optional)
         * @return OrderLineItem0RequestBuilder
         */
        public OrderLineItem0RequestBuilder soldTo(String soldTo) {
            this.soldTo = soldTo;
            return this;
        }
        
        /**
         * Set taxCode
         * @param taxCode The tax code for the Order Line Item (OLI).  You can update this field only for a sales OLI and only when the sales OLI is in the &#x60;Executing&#x60; state (when the &#x60;itemState&#x60; field is set as &#x60;Executing&#x60;).  (optional)
         * @return OrderLineItem0RequestBuilder
         */
        public OrderLineItem0RequestBuilder taxCode(String taxCode) {
            this.taxCode = taxCode;
            return this;
        }
        
        /**
         * Set taxMode
         * @param taxMode The tax mode for the Order Line Item (OLI).  You can update this field only for a sales OLI and only when the sales OLI is in the &#x60;Executing&#x60; state (when the &#x60;itemState&#x60; field is set as &#x60;Executing&#x60;).  (optional)
         * @return OrderLineItem0RequestBuilder
         */
        public OrderLineItem0RequestBuilder taxMode(String taxMode) {
            this.taxMode = taxMode;
            return this;
        }
        
        /**
         * Set transactionEndDate
         * @param transactionEndDate The date a transaction is completed. The default value of this field is the transaction start date. Also, the value of this field should always equal or be later than the value of the &#x60;transactionStartDate&#x60; field.  You can update this field for a sales or return OLI only when the OLI is in the &#x60;Executing&#x60; state (when the &#x60;itemState&#x60; field is set as &#x60;Executing&#x60;).  (optional)
         * @return OrderLineItem0RequestBuilder
         */
        public OrderLineItem0RequestBuilder transactionEndDate(LocalDate transactionEndDate) {
            this.transactionEndDate = transactionEndDate;
            return this;
        }
        
        /**
         * Set transactionStartDate
         * @param transactionStartDate The date a transaction starts. The default value of this field is the order date.  You can update this field for a sales or return OLI only when the OLI is in the &#x60;Executing&#x60; state (when the &#x60;itemState&#x60; field is set as &#x60;Executing&#x60;).  (optional)
         * @return OrderLineItem0RequestBuilder
         */
        public OrderLineItem0RequestBuilder transactionStartDate(LocalDate transactionStartDate) {
            this.transactionStartDate = transactionStartDate;
            return this;
        }
        
        /**
         * Set unbilledReceivablesAccountingCode
         * @param unbilledReceivablesAccountingCode The accounting code on the Order Line Item object for customers using [Zuora Billing - Revenue Integration](https://knowledgecenter.zuora.com/Zuora_Revenue/Zuora_Billing_-_Revenue_Integration).  You can update this field only for a sales OLI and only when the sales OLI is in the &#x60;Executing&#x60; state (when the &#x60;itemState&#x60; field is set as &#x60;Executing&#x60;).  (optional)
         * @return OrderLineItem0RequestBuilder
         */
        public OrderLineItem0RequestBuilder unbilledReceivablesAccountingCode(String unbilledReceivablesAccountingCode) {
            this.unbilledReceivablesAccountingCode = unbilledReceivablesAccountingCode;
            return this;
        }
        
        /**
         * Set acceptEncoding
         * @param acceptEncoding Include the &#x60;Accept-Encoding: gzip&#x60; header to compress responses as a gzipped file. It can significantly reduce the bandwidth required for a response.   If specified, Zuora automatically compresses responses that contain over 1000 bytes of data, and the response contains a &#x60;Content-Encoding&#x60; header with the compression algorithm so that your client can decompress it.  (optional)
         * @return OrderLineItem0RequestBuilder
         */
        public OrderLineItem0RequestBuilder acceptEncoding(String acceptEncoding) {
            this.acceptEncoding = acceptEncoding;
            return this;
        }
        
        /**
         * Set contentEncoding
         * @param contentEncoding Include the &#x60;Content-Encoding: gzip&#x60; header to compress a request. With this header specified, you should upload a gzipped file for the request payload instead of sending the JSON payload.  (optional)
         * @return OrderLineItem0RequestBuilder
         */
        public OrderLineItem0RequestBuilder contentEncoding(String contentEncoding) {
            this.contentEncoding = contentEncoding;
            return this;
        }
        
        /**
         * Set authorization
         * @param authorization The value is in the &#x60;Bearer {token}&#x60; format where {token} is a valid OAuth token generated by calling [Create an OAuth token](https://developer.zuora.com/api-references/api/operation/createToken).  (optional)
         * @return OrderLineItem0RequestBuilder
         */
        public OrderLineItem0RequestBuilder authorization(String authorization) {
            this.authorization = authorization;
            return this;
        }
        
        /**
         * Set zuoraTrackId
         * @param zuoraTrackId A custom identifier for tracing the API call. If you set a value for this header, Zuora returns the same value in the response headers. This header enables you to associate your system process identifiers with Zuora API calls, to assist with troubleshooting in the event of an issue.  The value of this field must use the US-ASCII character set and must not include any of the following characters: colon (&#x60;:&#x60;), semicolon (&#x60;;&#x60;), double quote (&#x60;\&quot;&#x60;), and quote (&#x60;&#39;&#x60;).  (optional)
         * @return OrderLineItem0RequestBuilder
         */
        public OrderLineItem0RequestBuilder zuoraTrackId(String zuoraTrackId) {
            this.zuoraTrackId = zuoraTrackId;
            return this;
        }
        
        /**
         * Set zuoraEntityIds
         * @param zuoraEntityIds An entity ID. If you have [Zuora Multi-entity](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Multi-entity) enabled and the OAuth token is valid for more than one entity, you must use this header to specify which entity to perform the operation in. If the OAuth token is only valid for a single entity, or you do not have Zuora Multi-entity enabled, you do not need to set this header.  (optional)
         * @return OrderLineItem0RequestBuilder
         */
        public OrderLineItem0RequestBuilder zuoraEntityIds(String zuoraEntityIds) {
            this.zuoraEntityIds = zuoraEntityIds;
            return this;
        }
        
        /**
         * Set zuoraOrgIds
         * @param zuoraOrgIds Comma separated IDs. If you have &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Central_Platform/Multi-Org\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Zuora Multi-Org&lt;/a&gt; enabled,  you can use this header to specify which orgs to perform the operation in. If you do not have Zuora Multi-Org enabled, you should not set this header.  The IDs must be a sub-set of the user&#39;s accessible orgs. If you specify an org that the user does not have access to, the operation fails.  If the header is not set, the operation is performed in scope of the user&#39;s accessible orgs.  (optional)
         * @return OrderLineItem0RequestBuilder
         */
        public OrderLineItem0RequestBuilder zuoraOrgIds(String zuoraOrgIds) {
            this.zuoraOrgIds = zuoraOrgIds;
            return this;
        }
        
        /**
         * Build call for orderLineItem_0
         * @param _callback ApiCallback API callback
         * @return Call to execute
         * @throws ApiException If fail to serialize the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td>  </td><td>  * Content-Encoding - This header is returned if you specify the &#x60;Accept-Encoding: gzip&#x60; request header and the response contains over 1000 bytes of data. Note that only the following MIME types support gzipped responses:   - &#x60;application/json&#x60;   - &#x60;application/xml&#x60;   - &#x60;text/html&#x60;   - &#x60;text/csv&#x60;   - &#x60;text/plain&#x60;  <br>  * RateLimit-Limit - The request limit quota for the time window closest to exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Remaining - The number of requests remaining in the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Reset - The number of seconds until the quota resets for the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Zuora-Request-Id - The Zuora internal identifier of the API call. You cannot control the value of this header.  <br>  * Zuora-Track-Id - A custom identifier for tracing the API call. If you specified a tracing identifier in the request headers, Zuora returns the same tracing identifier. Otherwise, Zuora does not set this header.  <br>  </td></tr>
         </table>
         */
        public okhttp3.Call buildCall(final ApiCallback _callback) throws ApiException {
            OrderLineItemCommon orderLineItemCommon = buildBodyParams();
            return orderLineItem_0Call(itemId, orderLineItemCommon, acceptEncoding, contentEncoding, authorization, zuoraTrackId, zuoraEntityIds, zuoraOrgIds, _callback);
        }

        private OrderLineItemCommon buildBodyParams() {
            OrderLineItemCommon orderLineItemCommon = new OrderLineItemCommon();
            orderLineItemCommon.description(this.description);
            orderLineItemCommon.UOM(this.UOM);
            orderLineItemCommon.accountingCode(this.accountingCode);
            orderLineItemCommon.adjustmentLiabilityAccountingCode(this.adjustmentLiabilityAccountingCode);
            orderLineItemCommon.adjustmentRevenueAccountingCode(this.adjustmentRevenueAccountingCode);
            orderLineItemCommon.amountPerUnit(this.amountPerUnit);
            orderLineItemCommon.billTargetDate(this.billTargetDate);
            orderLineItemCommon.billTo(this.billTo);
            if (this.billingRule != null)
            orderLineItemCommon.billingRule(OrderLineItemCommon.BillingRuleEnum.fromValue(this.billingRule));
            orderLineItemCommon.contractAssetAccountingCode(this.contractAssetAccountingCode);
            orderLineItemCommon.contractLiabilityAccountingCode(this.contractLiabilityAccountingCode);
            orderLineItemCommon.contractRecognizedRevenueAccountingCode(this.contractRecognizedRevenueAccountingCode);
            orderLineItemCommon.customFields(this.customFields);
            orderLineItemCommon.deferredRevenueAccountingCode(this.deferredRevenueAccountingCode);
            orderLineItemCommon.excludeItemBillingFromRevenueAccounting(this.excludeItemBillingFromRevenueAccounting);
            orderLineItemCommon.excludeItemBookingFromRevenueAccounting(this.excludeItemBookingFromRevenueAccounting);
            orderLineItemCommon.invoiceGroupNumber(this.invoiceGroupNumber);
            orderLineItemCommon.inlineDiscountPerUnit(this.inlineDiscountPerUnit);
            if (this.inlineDiscountType != null)
            orderLineItemCommon.inlineDiscountType(OrderLineItemCommon.InlineDiscountTypeEnum.fromValue(this.inlineDiscountType));
            orderLineItemCommon.isAllocationEligible(this.isAllocationEligible);
            orderLineItemCommon.isUnbilled(this.isUnbilled);
            orderLineItemCommon.itemName(this.itemName);
            orderLineItemCommon.itemNumber(this.itemNumber);
            if (this.itemState != null)
            orderLineItemCommon.itemState(OrderLineItemCommon.ItemStateEnum.fromValue(this.itemState));
            if (this.itemType != null)
            orderLineItemCommon.itemType(OrderLineItemCommon.ItemTypeEnum.fromValue(this.itemType));
            orderLineItemCommon.listPricePerUnit(this.listPricePerUnit);
            orderLineItemCommon.ownerAccountNumber(this.ownerAccountNumber);
            orderLineItemCommon.productCode(this.productCode);
            orderLineItemCommon.purchaseOrderNumber(this.purchaseOrderNumber);
            orderLineItemCommon.quantity(this.quantity);
            orderLineItemCommon.recognizedRevenueAccountingCode(this.recognizedRevenueAccountingCode);
            orderLineItemCommon.relatedSubscriptionNumber(this.relatedSubscriptionNumber);
            orderLineItemCommon.revenueRecognitionRule(this.revenueRecognitionRule);
            if (this.revenueRecognitionTiming != null)
            orderLineItemCommon.revenueRecognitionTiming(OrderLineItemCommon.RevenueRecognitionTimingEnum.fromValue(this.revenueRecognitionTiming));
            if (this.revenueAmortizationMethod != null)
            orderLineItemCommon.revenueAmortizationMethod(OrderLineItemCommon.RevenueAmortizationMethodEnum.fromValue(this.revenueAmortizationMethod));
            orderLineItemCommon.sequenceSetId(this.sequenceSetId);
            orderLineItemCommon.soldTo(this.soldTo);
            orderLineItemCommon.taxCode(this.taxCode);
            if (this.taxMode != null)
            orderLineItemCommon.taxMode(OrderLineItemCommon.TaxModeEnum.fromValue(this.taxMode));
            orderLineItemCommon.transactionEndDate(this.transactionEndDate);
            orderLineItemCommon.transactionStartDate(this.transactionStartDate);
            orderLineItemCommon.unbilledReceivablesAccountingCode(this.unbilledReceivablesAccountingCode);
            return orderLineItemCommon;
        }

        /**
         * Execute orderLineItem_0 request
         * @return CommonResponse
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td>  </td><td>  * Content-Encoding - This header is returned if you specify the &#x60;Accept-Encoding: gzip&#x60; request header and the response contains over 1000 bytes of data. Note that only the following MIME types support gzipped responses:   - &#x60;application/json&#x60;   - &#x60;application/xml&#x60;   - &#x60;text/html&#x60;   - &#x60;text/csv&#x60;   - &#x60;text/plain&#x60;  <br>  * RateLimit-Limit - The request limit quota for the time window closest to exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Remaining - The number of requests remaining in the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Reset - The number of seconds until the quota resets for the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Zuora-Request-Id - The Zuora internal identifier of the API call. You cannot control the value of this header.  <br>  * Zuora-Track-Id - A custom identifier for tracing the API call. If you specified a tracing identifier in the request headers, Zuora returns the same tracing identifier. Otherwise, Zuora does not set this header.  <br>  </td></tr>
         </table>
         */
        public CommonResponse execute() throws ApiException {
            OrderLineItemCommon orderLineItemCommon = buildBodyParams();
            ApiResponse<CommonResponse> localVarResp = orderLineItem_0WithHttpInfo(itemId, orderLineItemCommon, acceptEncoding, contentEncoding, authorization, zuoraTrackId, zuoraEntityIds, zuoraOrgIds);
            return localVarResp.getResponseBody();
        }

        /**
         * Execute orderLineItem_0 request with HTTP info returned
         * @return ApiResponse&lt;CommonResponse&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td>  </td><td>  * Content-Encoding - This header is returned if you specify the &#x60;Accept-Encoding: gzip&#x60; request header and the response contains over 1000 bytes of data. Note that only the following MIME types support gzipped responses:   - &#x60;application/json&#x60;   - &#x60;application/xml&#x60;   - &#x60;text/html&#x60;   - &#x60;text/csv&#x60;   - &#x60;text/plain&#x60;  <br>  * RateLimit-Limit - The request limit quota for the time window closest to exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Remaining - The number of requests remaining in the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Reset - The number of seconds until the quota resets for the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Zuora-Request-Id - The Zuora internal identifier of the API call. You cannot control the value of this header.  <br>  * Zuora-Track-Id - A custom identifier for tracing the API call. If you specified a tracing identifier in the request headers, Zuora returns the same tracing identifier. Otherwise, Zuora does not set this header.  <br>  </td></tr>
         </table>
         */
        public ApiResponse<CommonResponse> executeWithHttpInfo() throws ApiException {
            OrderLineItemCommon orderLineItemCommon = buildBodyParams();
            return orderLineItem_0WithHttpInfo(itemId, orderLineItemCommon, acceptEncoding, contentEncoding, authorization, zuoraTrackId, zuoraEntityIds, zuoraOrgIds);
        }

        /**
         * Execute orderLineItem_0 request (asynchronously)
         * @param _callback The callback to be executed when the API call finishes
         * @return The request call
         * @throws ApiException If fail to process the API call, e.g. serializing the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td>  </td><td>  * Content-Encoding - This header is returned if you specify the &#x60;Accept-Encoding: gzip&#x60; request header and the response contains over 1000 bytes of data. Note that only the following MIME types support gzipped responses:   - &#x60;application/json&#x60;   - &#x60;application/xml&#x60;   - &#x60;text/html&#x60;   - &#x60;text/csv&#x60;   - &#x60;text/plain&#x60;  <br>  * RateLimit-Limit - The request limit quota for the time window closest to exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Remaining - The number of requests remaining in the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Reset - The number of seconds until the quota resets for the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Zuora-Request-Id - The Zuora internal identifier of the API call. You cannot control the value of this header.  <br>  * Zuora-Track-Id - A custom identifier for tracing the API call. If you specified a tracing identifier in the request headers, Zuora returns the same tracing identifier. Otherwise, Zuora does not set this header.  <br>  </td></tr>
         </table>
         */
        public okhttp3.Call executeAsync(final ApiCallback<CommonResponse> _callback) throws ApiException {
            OrderLineItemCommon orderLineItemCommon = buildBodyParams();
            return orderLineItem_0Async(itemId, orderLineItemCommon, acceptEncoding, contentEncoding, authorization, zuoraTrackId, zuoraEntityIds, zuoraOrgIds, _callback);
        }
    }

    /**
     * Update an order line item
     * **Note:** The [Order Line Items](https://knowledgecenter.zuora.com/Billing/Subscriptions/Orders/Order_Line_Items/AA_Overview_of_Order_Line_Items) feature is now generally available to all Zuora customers. You need to enable the [Orders](https://knowledgecenter.zuora.com/BC_Subscription_Management/Orders/AA_Overview_of_Orders#Orders) feature to access the [Order Line Items](https://knowledgecenter.zuora.com/Billing/Subscriptions/Orders/Order_Line_Items/AA_Overview_of_Order_Line_Items) feature. As of Zuora Billing Release 313 (November 2021), new customers who onboard on [Orders](https://knowledgecenter.zuora.com/Billing/Subscriptions/Orders/AA_Overview_of_Orders) will have the [Order Line Items](https://knowledgecenter.zuora.com/Billing/Subscriptions/Orders/Order_Line_Items) feature enabled by default. If you are a new customer who onboard on [Orders Harmonization](https://knowledgecenter.zuora.com/Billing/Subscriptions/Orders/Orders_Harmonization/Orders_Harmonization) and want to enable the [Order Line Items](https://knowledgecenter.zuora.com/Billing/Subscriptions/Orders/Order_Line_Items) feature, submit a request at [Zuora Global Support](https://support.zuora.com/). If you are an existing [Orders](https://knowledgecenter.zuora.com/Billing/Subscriptions/Orders/AA_Overview_of_Orders) or [Orders Harmonization](https://knowledgecenter.zuora.com/Billing/Subscriptions/Orders/Orders_Harmonization/Orders_Harmonization) customer and want to enable the [Order Line Items](https://knowledgecenter.zuora.com/Billing/Subscriptions/Orders/Order_Line_Items) feature, submit a request at [Zuora Global Support](https://support.zuora.com/).  Updates a specified order line item. The following tutorials demonstrate how to use this operation: * [Update an order line item](https://knowledgecenter.zuora.com/Billing/Subscriptions/Orders/Order_Line_Items/GH_Update_an_order_line_item) * [Cancel an order line item](https://knowledgecenter.zuora.com/Billing/Subscriptions/Orders/Order_Line_Items/GZ_Cancel_an_order_line_item) 
     * @param itemId The id of the Order Line Item to update. (required)
     * @param orderLineItemCommon  (required)
     * @return OrderLineItem0RequestBuilder
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td>  </td><td>  * Content-Encoding - This header is returned if you specify the &#x60;Accept-Encoding: gzip&#x60; request header and the response contains over 1000 bytes of data. Note that only the following MIME types support gzipped responses:   - &#x60;application/json&#x60;   - &#x60;application/xml&#x60;   - &#x60;text/html&#x60;   - &#x60;text/csv&#x60;   - &#x60;text/plain&#x60;  <br>  * RateLimit-Limit - The request limit quota for the time window closest to exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Remaining - The number of requests remaining in the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Reset - The number of seconds until the quota resets for the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Zuora-Request-Id - The Zuora internal identifier of the API call. You cannot control the value of this header.  <br>  * Zuora-Track-Id - A custom identifier for tracing the API call. If you specified a tracing identifier in the request headers, Zuora returns the same tracing identifier. Otherwise, Zuora does not set this header.  <br>  </td></tr>
     </table>
     */
    public OrderLineItem0RequestBuilder orderLineItem_0(UUID itemId) throws IllegalArgumentException {
        if (itemId == null) throw new IllegalArgumentException("\"itemId\" is required but got null");
            

        return new OrderLineItem0RequestBuilder(itemId);
    }
    private okhttp3.Call orderLineItemsCall(PostOrderLineItemsRequestType postOrderLineItemsRequestType, String idempotencyKey, String acceptEncoding, String contentEncoding, String authorization, String zuoraTrackId, String zuoraEntityIds, String zuoraOrgIds, final ApiCallback _callback) throws ApiException {
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

        Object localVarPostBody = postOrderLineItemsRequestType;

        // create path and map variables
        String localVarPath = "/v1/order-line-items/bulk";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        if (idempotencyKey != null) {
            localVarHeaderParams.put("Idempotency-Key", localVarApiClient.parameterToString(idempotencyKey));
        }

        if (acceptEncoding != null) {
            localVarHeaderParams.put("Accept-Encoding", localVarApiClient.parameterToString(acceptEncoding));
        }

        if (contentEncoding != null) {
            localVarHeaderParams.put("Content-Encoding", localVarApiClient.parameterToString(contentEncoding));
        }

        if (authorization != null) {
            localVarHeaderParams.put("Authorization", localVarApiClient.parameterToString(authorization));
        }

        if (zuoraTrackId != null) {
            localVarHeaderParams.put("Zuora-Track-Id", localVarApiClient.parameterToString(zuoraTrackId));
        }

        if (zuoraEntityIds != null) {
            localVarHeaderParams.put("Zuora-Entity-Ids", localVarApiClient.parameterToString(zuoraEntityIds));
        }

        if (zuoraOrgIds != null) {
            localVarHeaderParams.put("Zuora-Org-Ids", localVarApiClient.parameterToString(zuoraOrgIds));
        }

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        if (localVarContentType != null) {
            localVarHeaderParams.put("Content-Type", localVarContentType);
        }

        String[] localVarAuthNames = new String[] {  };
        return localVarApiClient.buildCall(basePath, localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call orderLineItemsValidateBeforeCall(PostOrderLineItemsRequestType postOrderLineItemsRequestType, String idempotencyKey, String acceptEncoding, String contentEncoding, String authorization, String zuoraTrackId, String zuoraEntityIds, String zuoraOrgIds, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'postOrderLineItemsRequestType' is set
        if (postOrderLineItemsRequestType == null) {
            throw new ApiException("Missing the required parameter 'postOrderLineItemsRequestType' when calling orderLineItems(Async)");
        }

        return orderLineItemsCall(postOrderLineItemsRequestType, idempotencyKey, acceptEncoding, contentEncoding, authorization, zuoraTrackId, zuoraEntityIds, zuoraOrgIds, _callback);

    }


    private ApiResponse<GetOrderLineItemResponseType> orderLineItemsWithHttpInfo(PostOrderLineItemsRequestType postOrderLineItemsRequestType, String idempotencyKey, String acceptEncoding, String contentEncoding, String authorization, String zuoraTrackId, String zuoraEntityIds, String zuoraOrgIds) throws ApiException {
        okhttp3.Call localVarCall = orderLineItemsValidateBeforeCall(postOrderLineItemsRequestType, idempotencyKey, acceptEncoding, contentEncoding, authorization, zuoraTrackId, zuoraEntityIds, zuoraOrgIds, null);
        Type localVarReturnType = new TypeToken<GetOrderLineItemResponseType>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    private okhttp3.Call orderLineItemsAsync(PostOrderLineItemsRequestType postOrderLineItemsRequestType, String idempotencyKey, String acceptEncoding, String contentEncoding, String authorization, String zuoraTrackId, String zuoraEntityIds, String zuoraOrgIds, final ApiCallback<GetOrderLineItemResponseType> _callback) throws ApiException {

        okhttp3.Call localVarCall = orderLineItemsValidateBeforeCall(postOrderLineItemsRequestType, idempotencyKey, acceptEncoding, contentEncoding, authorization, zuoraTrackId, zuoraEntityIds, zuoraOrgIds, _callback);
        Type localVarReturnType = new TypeToken<GetOrderLineItemResponseType>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    public class OrderLineItemsRequestBuilder {
        private List<PostOrderLineItemUpdateType> orderLineItems;
        private ProcessingOptions processingOptions;
        private String idempotencyKey;
        private String acceptEncoding;
        private String contentEncoding;
        private String authorization;
        private String zuoraTrackId;
        private String zuoraEntityIds;
        private String zuoraOrgIds;

        private OrderLineItemsRequestBuilder() {
        }

        /**
         * Set orderLineItems
         * @param orderLineItems  (optional)
         * @return OrderLineItemsRequestBuilder
         */
        public OrderLineItemsRequestBuilder orderLineItems(List<PostOrderLineItemUpdateType> orderLineItems) {
            this.orderLineItems = orderLineItems;
            return this;
        }
        
        /**
         * Set processingOptions
         * @param processingOptions  (optional)
         * @return OrderLineItemsRequestBuilder
         */
        public OrderLineItemsRequestBuilder processingOptions(ProcessingOptions processingOptions) {
            this.processingOptions = processingOptions;
            return this;
        }
        
        /**
         * Set idempotencyKey
         * @param idempotencyKey Specify a unique idempotency key if you want to perform an idempotent POST or PATCH request. Do not use this header in other request types.   With this header specified, the Zuora server can identify subsequent retries of the same request using this value, which prevents the same operation from being performed multiple times by accident.   (optional)
         * @return OrderLineItemsRequestBuilder
         */
        public OrderLineItemsRequestBuilder idempotencyKey(String idempotencyKey) {
            this.idempotencyKey = idempotencyKey;
            return this;
        }
        
        /**
         * Set acceptEncoding
         * @param acceptEncoding Include the &#x60;Accept-Encoding: gzip&#x60; header to compress responses as a gzipped file. It can significantly reduce the bandwidth required for a response.   If specified, Zuora automatically compresses responses that contain over 1000 bytes of data, and the response contains a &#x60;Content-Encoding&#x60; header with the compression algorithm so that your client can decompress it.  (optional)
         * @return OrderLineItemsRequestBuilder
         */
        public OrderLineItemsRequestBuilder acceptEncoding(String acceptEncoding) {
            this.acceptEncoding = acceptEncoding;
            return this;
        }
        
        /**
         * Set contentEncoding
         * @param contentEncoding Include the &#x60;Content-Encoding: gzip&#x60; header to compress a request. With this header specified, you should upload a gzipped file for the request payload instead of sending the JSON payload.  (optional)
         * @return OrderLineItemsRequestBuilder
         */
        public OrderLineItemsRequestBuilder contentEncoding(String contentEncoding) {
            this.contentEncoding = contentEncoding;
            return this;
        }
        
        /**
         * Set authorization
         * @param authorization The value is in the &#x60;Bearer {token}&#x60; format where {token} is a valid OAuth token generated by calling [Create an OAuth token](https://developer.zuora.com/api-references/api/operation/createToken).  (optional)
         * @return OrderLineItemsRequestBuilder
         */
        public OrderLineItemsRequestBuilder authorization(String authorization) {
            this.authorization = authorization;
            return this;
        }
        
        /**
         * Set zuoraTrackId
         * @param zuoraTrackId A custom identifier for tracing the API call. If you set a value for this header, Zuora returns the same value in the response headers. This header enables you to associate your system process identifiers with Zuora API calls, to assist with troubleshooting in the event of an issue.  The value of this field must use the US-ASCII character set and must not include any of the following characters: colon (&#x60;:&#x60;), semicolon (&#x60;;&#x60;), double quote (&#x60;\&quot;&#x60;), and quote (&#x60;&#39;&#x60;).  (optional)
         * @return OrderLineItemsRequestBuilder
         */
        public OrderLineItemsRequestBuilder zuoraTrackId(String zuoraTrackId) {
            this.zuoraTrackId = zuoraTrackId;
            return this;
        }
        
        /**
         * Set zuoraEntityIds
         * @param zuoraEntityIds An entity ID. If you have [Zuora Multi-entity](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Multi-entity) enabled and the OAuth token is valid for more than one entity, you must use this header to specify which entity to perform the operation in. If the OAuth token is only valid for a single entity, or you do not have Zuora Multi-entity enabled, you do not need to set this header.  (optional)
         * @return OrderLineItemsRequestBuilder
         */
        public OrderLineItemsRequestBuilder zuoraEntityIds(String zuoraEntityIds) {
            this.zuoraEntityIds = zuoraEntityIds;
            return this;
        }
        
        /**
         * Set zuoraOrgIds
         * @param zuoraOrgIds Comma separated IDs. If you have &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Central_Platform/Multi-Org\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Zuora Multi-Org&lt;/a&gt; enabled,  you can use this header to specify which orgs to perform the operation in. If you do not have Zuora Multi-Org enabled, you should not set this header.  The IDs must be a sub-set of the user&#39;s accessible orgs. If you specify an org that the user does not have access to, the operation fails.  If the header is not set, the operation is performed in scope of the user&#39;s accessible orgs.  (optional)
         * @return OrderLineItemsRequestBuilder
         */
        public OrderLineItemsRequestBuilder zuoraOrgIds(String zuoraOrgIds) {
            this.zuoraOrgIds = zuoraOrgIds;
            return this;
        }
        
        /**
         * Build call for orderLineItems
         * @param _callback ApiCallback API callback
         * @return Call to execute
         * @throws ApiException If fail to serialize the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td>  </td><td>  * Content-Encoding - This header is returned if you specify the &#x60;Accept-Encoding: gzip&#x60; request header and the response contains over 1000 bytes of data. Note that only the following MIME types support gzipped responses:   - &#x60;application/json&#x60;   - &#x60;application/xml&#x60;   - &#x60;text/html&#x60;   - &#x60;text/csv&#x60;   - &#x60;text/plain&#x60;  <br>  * RateLimit-Limit - The request limit quota for the time window closest to exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Remaining - The number of requests remaining in the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Reset - The number of seconds until the quota resets for the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Zuora-Request-Id - The Zuora internal identifier of the API call. You cannot control the value of this header.  <br>  * Zuora-Track-Id - A custom identifier for tracing the API call. If you specified a tracing identifier in the request headers, Zuora returns the same tracing identifier. Otherwise, Zuora does not set this header.  <br>  </td></tr>
         </table>
         */
        public okhttp3.Call buildCall(final ApiCallback _callback) throws ApiException {
            PostOrderLineItemsRequestType postOrderLineItemsRequestType = buildBodyParams();
            return orderLineItemsCall(postOrderLineItemsRequestType, idempotencyKey, acceptEncoding, contentEncoding, authorization, zuoraTrackId, zuoraEntityIds, zuoraOrgIds, _callback);
        }

        private PostOrderLineItemsRequestType buildBodyParams() {
            PostOrderLineItemsRequestType postOrderLineItemsRequestType = new PostOrderLineItemsRequestType();
            postOrderLineItemsRequestType.orderLineItems(this.orderLineItems);
            postOrderLineItemsRequestType.processingOptions(this.processingOptions);
            return postOrderLineItemsRequestType;
        }

        /**
         * Execute orderLineItems request
         * @return GetOrderLineItemResponseType
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td>  </td><td>  * Content-Encoding - This header is returned if you specify the &#x60;Accept-Encoding: gzip&#x60; request header and the response contains over 1000 bytes of data. Note that only the following MIME types support gzipped responses:   - &#x60;application/json&#x60;   - &#x60;application/xml&#x60;   - &#x60;text/html&#x60;   - &#x60;text/csv&#x60;   - &#x60;text/plain&#x60;  <br>  * RateLimit-Limit - The request limit quota for the time window closest to exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Remaining - The number of requests remaining in the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Reset - The number of seconds until the quota resets for the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Zuora-Request-Id - The Zuora internal identifier of the API call. You cannot control the value of this header.  <br>  * Zuora-Track-Id - A custom identifier for tracing the API call. If you specified a tracing identifier in the request headers, Zuora returns the same tracing identifier. Otherwise, Zuora does not set this header.  <br>  </td></tr>
         </table>
         */
        public GetOrderLineItemResponseType execute() throws ApiException {
            PostOrderLineItemsRequestType postOrderLineItemsRequestType = buildBodyParams();
            ApiResponse<GetOrderLineItemResponseType> localVarResp = orderLineItemsWithHttpInfo(postOrderLineItemsRequestType, idempotencyKey, acceptEncoding, contentEncoding, authorization, zuoraTrackId, zuoraEntityIds, zuoraOrgIds);
            return localVarResp.getResponseBody();
        }

        /**
         * Execute orderLineItems request with HTTP info returned
         * @return ApiResponse&lt;GetOrderLineItemResponseType&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td>  </td><td>  * Content-Encoding - This header is returned if you specify the &#x60;Accept-Encoding: gzip&#x60; request header and the response contains over 1000 bytes of data. Note that only the following MIME types support gzipped responses:   - &#x60;application/json&#x60;   - &#x60;application/xml&#x60;   - &#x60;text/html&#x60;   - &#x60;text/csv&#x60;   - &#x60;text/plain&#x60;  <br>  * RateLimit-Limit - The request limit quota for the time window closest to exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Remaining - The number of requests remaining in the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Reset - The number of seconds until the quota resets for the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Zuora-Request-Id - The Zuora internal identifier of the API call. You cannot control the value of this header.  <br>  * Zuora-Track-Id - A custom identifier for tracing the API call. If you specified a tracing identifier in the request headers, Zuora returns the same tracing identifier. Otherwise, Zuora does not set this header.  <br>  </td></tr>
         </table>
         */
        public ApiResponse<GetOrderLineItemResponseType> executeWithHttpInfo() throws ApiException {
            PostOrderLineItemsRequestType postOrderLineItemsRequestType = buildBodyParams();
            return orderLineItemsWithHttpInfo(postOrderLineItemsRequestType, idempotencyKey, acceptEncoding, contentEncoding, authorization, zuoraTrackId, zuoraEntityIds, zuoraOrgIds);
        }

        /**
         * Execute orderLineItems request (asynchronously)
         * @param _callback The callback to be executed when the API call finishes
         * @return The request call
         * @throws ApiException If fail to process the API call, e.g. serializing the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td>  </td><td>  * Content-Encoding - This header is returned if you specify the &#x60;Accept-Encoding: gzip&#x60; request header and the response contains over 1000 bytes of data. Note that only the following MIME types support gzipped responses:   - &#x60;application/json&#x60;   - &#x60;application/xml&#x60;   - &#x60;text/html&#x60;   - &#x60;text/csv&#x60;   - &#x60;text/plain&#x60;  <br>  * RateLimit-Limit - The request limit quota for the time window closest to exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Remaining - The number of requests remaining in the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Reset - The number of seconds until the quota resets for the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Zuora-Request-Id - The Zuora internal identifier of the API call. You cannot control the value of this header.  <br>  * Zuora-Track-Id - A custom identifier for tracing the API call. If you specified a tracing identifier in the request headers, Zuora returns the same tracing identifier. Otherwise, Zuora does not set this header.  <br>  </td></tr>
         </table>
         */
        public okhttp3.Call executeAsync(final ApiCallback<GetOrderLineItemResponseType> _callback) throws ApiException {
            PostOrderLineItemsRequestType postOrderLineItemsRequestType = buildBodyParams();
            return orderLineItemsAsync(postOrderLineItemsRequestType, idempotencyKey, acceptEncoding, contentEncoding, authorization, zuoraTrackId, zuoraEntityIds, zuoraOrgIds, _callback);
        }
    }

    /**
     * Update order line items
     * **Note:** The [Order Line Items](https://knowledgecenter.zuora.com/Billing/Subscriptions/Orders/Order_Line_Items/AA_Overview_of_Order_Line_Items) feature is now generally available to all Zuora customers. You need to enable the [Orders](https://knowledgecenter.zuora.com/BC_Subscription_Management/Orders/AA_Overview_of_Orders#Orders) feature to access the [Order Line Items](https://knowledgecenter.zuora.com/Billing/Subscriptions/Orders/Order_Line_Items/AA_Overview_of_Order_Line_Items) feature. As of Zuora Billing Release 313 (November 2021), new customers who onboard on [Orders](https://knowledgecenter.zuora.com/Billing/Subscriptions/Orders/AA_Overview_of_Orders) will have the [Order Line Items](https://knowledgecenter.zuora.com/Billing/Subscriptions/Orders/Order_Line_Items) feature enabled by default. If you are a new customer who onboard on [Orders Harmonization](https://knowledgecenter.zuora.com/Billing/Subscriptions/Orders/Orders_Harmonization/Orders_Harmonization) and want to enable the [Order Line Items](https://knowledgecenter.zuora.com/Billing/Subscriptions/Orders/Order_Line_Items) feature, submit a request at [Zuora Global Support](https://support.zuora.com/). If you are an existing [Orders](https://knowledgecenter.zuora.com/Billing/Subscriptions/Orders/AA_Overview_of_Orders) or [Orders Harmonization](https://knowledgecenter.zuora.com/Billing/Subscriptions/Orders/Orders_Harmonization/Orders_Harmonization) customer and want to enable the [Order Line Items](https://knowledgecenter.zuora.com/Billing/Subscriptions/Orders/Order_Line_Items) feature, submit a request at [Zuora Global Support](https://support.zuora.com/).  Bulk-updates multiple order line items. You can also choose to generate an invoice for these updated order line items.  The maximum number of order line items allowable to update in a call is 100.  
     * @param postOrderLineItemsRequestType  (required)
     * @return OrderLineItemsRequestBuilder
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td>  </td><td>  * Content-Encoding - This header is returned if you specify the &#x60;Accept-Encoding: gzip&#x60; request header and the response contains over 1000 bytes of data. Note that only the following MIME types support gzipped responses:   - &#x60;application/json&#x60;   - &#x60;application/xml&#x60;   - &#x60;text/html&#x60;   - &#x60;text/csv&#x60;   - &#x60;text/plain&#x60;  <br>  * RateLimit-Limit - The request limit quota for the time window closest to exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Remaining - The number of requests remaining in the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Reset - The number of seconds until the quota resets for the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Zuora-Request-Id - The Zuora internal identifier of the API call. You cannot control the value of this header.  <br>  * Zuora-Track-Id - A custom identifier for tracing the API call. If you specified a tracing identifier in the request headers, Zuora returns the same tracing identifier. Otherwise, Zuora does not set this header.  <br>  </td></tr>
     </table>
     */
    public OrderLineItemsRequestBuilder orderLineItems() throws IllegalArgumentException {
        return new OrderLineItemsRequestBuilder();
    }
}
