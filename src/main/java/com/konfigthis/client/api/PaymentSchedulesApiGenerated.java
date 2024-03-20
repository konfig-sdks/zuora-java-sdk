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


import com.konfigthis.client.model.GETPaymentScheduleItemResponse;
import com.konfigthis.client.model.GETPaymentScheduleResponse;
import com.konfigthis.client.model.GETPaymentScheduleStatisticResponse;
import java.time.LocalDate;
import com.konfigthis.client.model.POSTAddItemsToPaymentScheduleRequest;
import com.konfigthis.client.model.POSTPaymentScheduleRequest;
import com.konfigthis.client.model.POSTPaymentScheduleRequestAllOfBillingDocument;
import com.konfigthis.client.model.POSTPaymentScheduleResponse;
import com.konfigthis.client.model.POSTPaymentSchedulesRequest;
import com.konfigthis.client.model.POSTPaymentSchedulesResponse;
import com.konfigthis.client.model.POSTRetryPaymentScheduleItemInfo;
import com.konfigthis.client.model.POSTRetryPaymentScheduleItemRequest;
import com.konfigthis.client.model.POSTRetryPaymentScheduleItemResponse;
import com.konfigthis.client.model.PUTCancelPaymentScheduleRequest;
import com.konfigthis.client.model.PUTPaymentScheduleItemRequest;
import com.konfigthis.client.model.PUTPaymentScheduleItemResponse;
import com.konfigthis.client.model.PUTPaymentScheduleRequest;
import com.konfigthis.client.model.PUTPreviewPaymentScheduleRequest;
import com.konfigthis.client.model.PUTSkipPaymentScheduleItemResponse;
import com.konfigthis.client.model.PaymentScheduleCommonResponse;
import com.konfigthis.client.model.PaymentScheduleItemCommon;
import com.konfigthis.client.model.PaymentSchedulePaymentOptionFields;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ws.rs.core.GenericType;

public class PaymentSchedulesApiGenerated {
    private ApiClient localVarApiClient;
    private int localHostIndex;
    private String localCustomBaseUrl;

    public PaymentSchedulesApiGenerated() throws IllegalArgumentException {
        this(Configuration.getDefaultApiClient());
    }

    public PaymentSchedulesApiGenerated(ApiClient apiClient) throws IllegalArgumentException {
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

    private okhttp3.Call addItemsToCustomPaymentScheduleCall(String paymentScheduleKey, POSTAddItemsToPaymentScheduleRequest poSTAddItemsToPaymentScheduleRequest, String idempotencyKey, String acceptEncoding, String contentEncoding, String authorization, String zuoraTrackId, String zuoraEntityIds, String zuoraOrgIds, String zuoraVersion, final ApiCallback _callback) throws ApiException {
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

        Object localVarPostBody = poSTAddItemsToPaymentScheduleRequest;

        // create path and map variables
        String localVarPath = "/v1/payment-schedules/{paymentScheduleKey}/items"
            .replace("{" + "paymentScheduleKey" + "}", localVarApiClient.escapeString(paymentScheduleKey.toString()));

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

        if (zuoraVersion != null) {
            localVarHeaderParams.put("zuora-version", localVarApiClient.parameterToString(zuoraVersion));
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
    private okhttp3.Call addItemsToCustomPaymentScheduleValidateBeforeCall(String paymentScheduleKey, POSTAddItemsToPaymentScheduleRequest poSTAddItemsToPaymentScheduleRequest, String idempotencyKey, String acceptEncoding, String contentEncoding, String authorization, String zuoraTrackId, String zuoraEntityIds, String zuoraOrgIds, String zuoraVersion, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'paymentScheduleKey' is set
        if (paymentScheduleKey == null) {
            throw new ApiException("Missing the required parameter 'paymentScheduleKey' when calling addItemsToCustomPaymentSchedule(Async)");
        }

        // verify the required parameter 'poSTAddItemsToPaymentScheduleRequest' is set
        if (poSTAddItemsToPaymentScheduleRequest == null) {
            throw new ApiException("Missing the required parameter 'poSTAddItemsToPaymentScheduleRequest' when calling addItemsToCustomPaymentSchedule(Async)");
        }

        return addItemsToCustomPaymentScheduleCall(paymentScheduleKey, poSTAddItemsToPaymentScheduleRequest, idempotencyKey, acceptEncoding, contentEncoding, authorization, zuoraTrackId, zuoraEntityIds, zuoraOrgIds, zuoraVersion, _callback);

    }


    private ApiResponse<GETPaymentScheduleResponse> addItemsToCustomPaymentScheduleWithHttpInfo(String paymentScheduleKey, POSTAddItemsToPaymentScheduleRequest poSTAddItemsToPaymentScheduleRequest, String idempotencyKey, String acceptEncoding, String contentEncoding, String authorization, String zuoraTrackId, String zuoraEntityIds, String zuoraOrgIds, String zuoraVersion) throws ApiException {
        okhttp3.Call localVarCall = addItemsToCustomPaymentScheduleValidateBeforeCall(paymentScheduleKey, poSTAddItemsToPaymentScheduleRequest, idempotencyKey, acceptEncoding, contentEncoding, authorization, zuoraTrackId, zuoraEntityIds, zuoraOrgIds, zuoraVersion, null);
        Type localVarReturnType = new TypeToken<GETPaymentScheduleResponse>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    private okhttp3.Call addItemsToCustomPaymentScheduleAsync(String paymentScheduleKey, POSTAddItemsToPaymentScheduleRequest poSTAddItemsToPaymentScheduleRequest, String idempotencyKey, String acceptEncoding, String contentEncoding, String authorization, String zuoraTrackId, String zuoraEntityIds, String zuoraOrgIds, String zuoraVersion, final ApiCallback<GETPaymentScheduleResponse> _callback) throws ApiException {

        okhttp3.Call localVarCall = addItemsToCustomPaymentScheduleValidateBeforeCall(paymentScheduleKey, poSTAddItemsToPaymentScheduleRequest, idempotencyKey, acceptEncoding, contentEncoding, authorization, zuoraTrackId, zuoraEntityIds, zuoraOrgIds, zuoraVersion, _callback);
        Type localVarReturnType = new TypeToken<GETPaymentScheduleResponse>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    public class AddItemsToCustomPaymentScheduleRequestBuilder {
        private final String paymentScheduleKey;
        private List<PaymentScheduleItemCommon> items;
        private String idempotencyKey;
        private String acceptEncoding;
        private String contentEncoding;
        private String authorization;
        private String zuoraTrackId;
        private String zuoraEntityIds;
        private String zuoraOrgIds;
        private String zuoraVersion;

        private AddItemsToCustomPaymentScheduleRequestBuilder(String paymentScheduleKey) {
            this.paymentScheduleKey = paymentScheduleKey;
        }

        /**
         * Set items
         * @param items  (optional)
         * @return AddItemsToCustomPaymentScheduleRequestBuilder
         */
        public AddItemsToCustomPaymentScheduleRequestBuilder items(List<PaymentScheduleItemCommon> items) {
            this.items = items;
            return this;
        }
        
        /**
         * Set idempotencyKey
         * @param idempotencyKey Specify a unique idempotency key if you want to perform an idempotent POST or PATCH request. Do not use this header in other request types.   With this header specified, the Zuora server can identify subsequent retries of the same request using this value, which prevents the same operation from being performed multiple times by accident.   (optional)
         * @return AddItemsToCustomPaymentScheduleRequestBuilder
         */
        public AddItemsToCustomPaymentScheduleRequestBuilder idempotencyKey(String idempotencyKey) {
            this.idempotencyKey = idempotencyKey;
            return this;
        }
        
        /**
         * Set acceptEncoding
         * @param acceptEncoding Include the &#x60;Accept-Encoding: gzip&#x60; header to compress responses as a gzipped file. It can significantly reduce the bandwidth required for a response.   If specified, Zuora automatically compresses responses that contain over 1000 bytes of data, and the response contains a &#x60;Content-Encoding&#x60; header with the compression algorithm so that your client can decompress it.  (optional)
         * @return AddItemsToCustomPaymentScheduleRequestBuilder
         */
        public AddItemsToCustomPaymentScheduleRequestBuilder acceptEncoding(String acceptEncoding) {
            this.acceptEncoding = acceptEncoding;
            return this;
        }
        
        /**
         * Set contentEncoding
         * @param contentEncoding Include the &#x60;Content-Encoding: gzip&#x60; header to compress a request. With this header specified, you should upload a gzipped file for the request payload instead of sending the JSON payload.  (optional)
         * @return AddItemsToCustomPaymentScheduleRequestBuilder
         */
        public AddItemsToCustomPaymentScheduleRequestBuilder contentEncoding(String contentEncoding) {
            this.contentEncoding = contentEncoding;
            return this;
        }
        
        /**
         * Set authorization
         * @param authorization The value is in the &#x60;Bearer {token}&#x60; format where {token} is a valid OAuth token generated by calling [Create an OAuth token](https://developer.zuora.com/api-references/api/operation/createToken).  (optional)
         * @return AddItemsToCustomPaymentScheduleRequestBuilder
         */
        public AddItemsToCustomPaymentScheduleRequestBuilder authorization(String authorization) {
            this.authorization = authorization;
            return this;
        }
        
        /**
         * Set zuoraTrackId
         * @param zuoraTrackId A custom identifier for tracing the API call. If you set a value for this header, Zuora returns the same value in the response headers. This header enables you to associate your system process identifiers with Zuora API calls, to assist with troubleshooting in the event of an issue.  The value of this field must use the US-ASCII character set and must not include any of the following characters: colon (&#x60;:&#x60;), semicolon (&#x60;;&#x60;), double quote (&#x60;\&quot;&#x60;), and quote (&#x60;&#39;&#x60;).  (optional)
         * @return AddItemsToCustomPaymentScheduleRequestBuilder
         */
        public AddItemsToCustomPaymentScheduleRequestBuilder zuoraTrackId(String zuoraTrackId) {
            this.zuoraTrackId = zuoraTrackId;
            return this;
        }
        
        /**
         * Set zuoraEntityIds
         * @param zuoraEntityIds An entity ID. If you have [Zuora Multi-entity](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Multi-entity) enabled and the OAuth token is valid for more than one entity, you must use this header to specify which entity to perform the operation in. If the OAuth token is only valid for a single entity, or you do not have Zuora Multi-entity enabled, you do not need to set this header.  (optional)
         * @return AddItemsToCustomPaymentScheduleRequestBuilder
         */
        public AddItemsToCustomPaymentScheduleRequestBuilder zuoraEntityIds(String zuoraEntityIds) {
            this.zuoraEntityIds = zuoraEntityIds;
            return this;
        }
        
        /**
         * Set zuoraOrgIds
         * @param zuoraOrgIds Comma separated IDs. If you have &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Central_Platform/Multi-Org\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Zuora Multi-Org&lt;/a&gt; enabled,  you can use this header to specify which orgs to perform the operation in. If you do not have Zuora Multi-Org enabled, you should not set this header.  The IDs must be a sub-set of the user&#39;s accessible orgs. If you specify an org that the user does not have access to, the operation fails.  If the header is not set, the operation is performed in scope of the user&#39;s accessible orgs.  (optional)
         * @return AddItemsToCustomPaymentScheduleRequestBuilder
         */
        public AddItemsToCustomPaymentScheduleRequestBuilder zuoraOrgIds(String zuoraOrgIds) {
            this.zuoraOrgIds = zuoraOrgIds;
            return this;
        }
        
        /**
         * Set zuoraVersion
         * @param zuoraVersion The minor version of the Zuora REST API. See [Minor Version](https://developer.zuora.com/api-references/api/overview/#section/API-Versions/Minor-Version) for information about REST API version control.   This header affects the availability of the following fields: - &#x60;items&#x60; &gt; &#x60;paymentId&#x60;  (optional)
         * @return AddItemsToCustomPaymentScheduleRequestBuilder
         */
        public AddItemsToCustomPaymentScheduleRequestBuilder zuoraVersion(String zuoraVersion) {
            this.zuoraVersion = zuoraVersion;
            return this;
        }
        
        /**
         * Build call for addItemsToCustomPaymentSchedule
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
            POSTAddItemsToPaymentScheduleRequest poSTAddItemsToPaymentScheduleRequest = buildBodyParams();
            return addItemsToCustomPaymentScheduleCall(paymentScheduleKey, poSTAddItemsToPaymentScheduleRequest, idempotencyKey, acceptEncoding, contentEncoding, authorization, zuoraTrackId, zuoraEntityIds, zuoraOrgIds, zuoraVersion, _callback);
        }

        private POSTAddItemsToPaymentScheduleRequest buildBodyParams() {
            POSTAddItemsToPaymentScheduleRequest poSTAddItemsToPaymentScheduleRequest = new POSTAddItemsToPaymentScheduleRequest();
            poSTAddItemsToPaymentScheduleRequest.items(this.items);
            return poSTAddItemsToPaymentScheduleRequest;
        }

        /**
         * Execute addItemsToCustomPaymentSchedule request
         * @return GETPaymentScheduleResponse
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td>  </td><td>  * Content-Encoding - This header is returned if you specify the &#x60;Accept-Encoding: gzip&#x60; request header and the response contains over 1000 bytes of data. Note that only the following MIME types support gzipped responses:   - &#x60;application/json&#x60;   - &#x60;application/xml&#x60;   - &#x60;text/html&#x60;   - &#x60;text/csv&#x60;   - &#x60;text/plain&#x60;  <br>  * RateLimit-Limit - The request limit quota for the time window closest to exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Remaining - The number of requests remaining in the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Reset - The number of seconds until the quota resets for the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Zuora-Request-Id - The Zuora internal identifier of the API call. You cannot control the value of this header.  <br>  * Zuora-Track-Id - A custom identifier for tracing the API call. If you specified a tracing identifier in the request headers, Zuora returns the same tracing identifier. Otherwise, Zuora does not set this header.  <br>  </td></tr>
         </table>
         */
        public GETPaymentScheduleResponse execute() throws ApiException {
            POSTAddItemsToPaymentScheduleRequest poSTAddItemsToPaymentScheduleRequest = buildBodyParams();
            ApiResponse<GETPaymentScheduleResponse> localVarResp = addItemsToCustomPaymentScheduleWithHttpInfo(paymentScheduleKey, poSTAddItemsToPaymentScheduleRequest, idempotencyKey, acceptEncoding, contentEncoding, authorization, zuoraTrackId, zuoraEntityIds, zuoraOrgIds, zuoraVersion);
            return localVarResp.getResponseBody();
        }

        /**
         * Execute addItemsToCustomPaymentSchedule request with HTTP info returned
         * @return ApiResponse&lt;GETPaymentScheduleResponse&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td>  </td><td>  * Content-Encoding - This header is returned if you specify the &#x60;Accept-Encoding: gzip&#x60; request header and the response contains over 1000 bytes of data. Note that only the following MIME types support gzipped responses:   - &#x60;application/json&#x60;   - &#x60;application/xml&#x60;   - &#x60;text/html&#x60;   - &#x60;text/csv&#x60;   - &#x60;text/plain&#x60;  <br>  * RateLimit-Limit - The request limit quota for the time window closest to exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Remaining - The number of requests remaining in the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Reset - The number of seconds until the quota resets for the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Zuora-Request-Id - The Zuora internal identifier of the API call. You cannot control the value of this header.  <br>  * Zuora-Track-Id - A custom identifier for tracing the API call. If you specified a tracing identifier in the request headers, Zuora returns the same tracing identifier. Otherwise, Zuora does not set this header.  <br>  </td></tr>
         </table>
         */
        public ApiResponse<GETPaymentScheduleResponse> executeWithHttpInfo() throws ApiException {
            POSTAddItemsToPaymentScheduleRequest poSTAddItemsToPaymentScheduleRequest = buildBodyParams();
            return addItemsToCustomPaymentScheduleWithHttpInfo(paymentScheduleKey, poSTAddItemsToPaymentScheduleRequest, idempotencyKey, acceptEncoding, contentEncoding, authorization, zuoraTrackId, zuoraEntityIds, zuoraOrgIds, zuoraVersion);
        }

        /**
         * Execute addItemsToCustomPaymentSchedule request (asynchronously)
         * @param _callback The callback to be executed when the API call finishes
         * @return The request call
         * @throws ApiException If fail to process the API call, e.g. serializing the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td>  </td><td>  * Content-Encoding - This header is returned if you specify the &#x60;Accept-Encoding: gzip&#x60; request header and the response contains over 1000 bytes of data. Note that only the following MIME types support gzipped responses:   - &#x60;application/json&#x60;   - &#x60;application/xml&#x60;   - &#x60;text/html&#x60;   - &#x60;text/csv&#x60;   - &#x60;text/plain&#x60;  <br>  * RateLimit-Limit - The request limit quota for the time window closest to exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Remaining - The number of requests remaining in the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Reset - The number of seconds until the quota resets for the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Zuora-Request-Id - The Zuora internal identifier of the API call. You cannot control the value of this header.  <br>  * Zuora-Track-Id - A custom identifier for tracing the API call. If you specified a tracing identifier in the request headers, Zuora returns the same tracing identifier. Otherwise, Zuora does not set this header.  <br>  </td></tr>
         </table>
         */
        public okhttp3.Call executeAsync(final ApiCallback<GETPaymentScheduleResponse> _callback) throws ApiException {
            POSTAddItemsToPaymentScheduleRequest poSTAddItemsToPaymentScheduleRequest = buildBodyParams();
            return addItemsToCustomPaymentScheduleAsync(paymentScheduleKey, poSTAddItemsToPaymentScheduleRequest, idempotencyKey, acceptEncoding, contentEncoding, authorization, zuoraTrackId, zuoraEntityIds, zuoraOrgIds, zuoraVersion, _callback);
        }
    }

    /**
     * Add payment schedule items to a custom payment schedule
     * Adds payment schedule items to a custom payment schedule. You cannot use this operation to add payment schedule items to recurring payment schedules.  **Note:** - The Payment Schedules feature is in the **Early Adopter** phase. We are actively soliciting feedback from a small set of early adopters before releasing it as generally available. To manage and access this feature through the self-service interface, see [Manage Features](https://knowledgecenter.zuora.com/Zuora_Payments/Payments_Settings/Manage_Features) in the Knowledge Center. - This operation is only available if you have [Invoice Settlement](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/Invoice_Settlement) enabled. 
     * @param paymentScheduleKey The unique ID or number of a payment schedule. For example, &#x60;8a90857b822459cd018224dcb9eb13be&#x60;, or &#x60;PS-00000007&#x60;.  (required)
     * @param poSTAddItemsToPaymentScheduleRequest  (required)
     * @return AddItemsToCustomPaymentScheduleRequestBuilder
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td>  </td><td>  * Content-Encoding - This header is returned if you specify the &#x60;Accept-Encoding: gzip&#x60; request header and the response contains over 1000 bytes of data. Note that only the following MIME types support gzipped responses:   - &#x60;application/json&#x60;   - &#x60;application/xml&#x60;   - &#x60;text/html&#x60;   - &#x60;text/csv&#x60;   - &#x60;text/plain&#x60;  <br>  * RateLimit-Limit - The request limit quota for the time window closest to exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Remaining - The number of requests remaining in the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Reset - The number of seconds until the quota resets for the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Zuora-Request-Id - The Zuora internal identifier of the API call. You cannot control the value of this header.  <br>  * Zuora-Track-Id - A custom identifier for tracing the API call. If you specified a tracing identifier in the request headers, Zuora returns the same tracing identifier. Otherwise, Zuora does not set this header.  <br>  </td></tr>
     </table>
     */
    public AddItemsToCustomPaymentScheduleRequestBuilder addItemsToCustomPaymentSchedule(String paymentScheduleKey) throws IllegalArgumentException {
        if (paymentScheduleKey == null) throw new IllegalArgumentException("\"paymentScheduleKey\" is required but got null");
            

        return new AddItemsToCustomPaymentScheduleRequestBuilder(paymentScheduleKey);
    }
    private okhttp3.Call cancelPaymentScheduleCall(String paymentScheduleKey, PUTCancelPaymentScheduleRequest puTCancelPaymentScheduleRequest, String acceptEncoding, String contentEncoding, String authorization, String zuoraTrackId, String zuoraEntityIds, String zuoraOrgIds, String zuoraVersion, final ApiCallback _callback) throws ApiException {
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

        Object localVarPostBody = puTCancelPaymentScheduleRequest;

        // create path and map variables
        String localVarPath = "/v1/payment-schedules/{paymentScheduleKey}/cancel"
            .replace("{" + "paymentScheduleKey" + "}", localVarApiClient.escapeString(paymentScheduleKey.toString()));

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

        if (zuoraVersion != null) {
            localVarHeaderParams.put("zuora-version", localVarApiClient.parameterToString(zuoraVersion));
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
    private okhttp3.Call cancelPaymentScheduleValidateBeforeCall(String paymentScheduleKey, PUTCancelPaymentScheduleRequest puTCancelPaymentScheduleRequest, String acceptEncoding, String contentEncoding, String authorization, String zuoraTrackId, String zuoraEntityIds, String zuoraOrgIds, String zuoraVersion, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'paymentScheduleKey' is set
        if (paymentScheduleKey == null) {
            throw new ApiException("Missing the required parameter 'paymentScheduleKey' when calling cancelPaymentSchedule(Async)");
        }

        // verify the required parameter 'puTCancelPaymentScheduleRequest' is set
        if (puTCancelPaymentScheduleRequest == null) {
            throw new ApiException("Missing the required parameter 'puTCancelPaymentScheduleRequest' when calling cancelPaymentSchedule(Async)");
        }

        return cancelPaymentScheduleCall(paymentScheduleKey, puTCancelPaymentScheduleRequest, acceptEncoding, contentEncoding, authorization, zuoraTrackId, zuoraEntityIds, zuoraOrgIds, zuoraVersion, _callback);

    }


    private ApiResponse<GETPaymentScheduleResponse> cancelPaymentScheduleWithHttpInfo(String paymentScheduleKey, PUTCancelPaymentScheduleRequest puTCancelPaymentScheduleRequest, String acceptEncoding, String contentEncoding, String authorization, String zuoraTrackId, String zuoraEntityIds, String zuoraOrgIds, String zuoraVersion) throws ApiException {
        okhttp3.Call localVarCall = cancelPaymentScheduleValidateBeforeCall(paymentScheduleKey, puTCancelPaymentScheduleRequest, acceptEncoding, contentEncoding, authorization, zuoraTrackId, zuoraEntityIds, zuoraOrgIds, zuoraVersion, null);
        Type localVarReturnType = new TypeToken<GETPaymentScheduleResponse>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    private okhttp3.Call cancelPaymentScheduleAsync(String paymentScheduleKey, PUTCancelPaymentScheduleRequest puTCancelPaymentScheduleRequest, String acceptEncoding, String contentEncoding, String authorization, String zuoraTrackId, String zuoraEntityIds, String zuoraOrgIds, String zuoraVersion, final ApiCallback<GETPaymentScheduleResponse> _callback) throws ApiException {

        okhttp3.Call localVarCall = cancelPaymentScheduleValidateBeforeCall(paymentScheduleKey, puTCancelPaymentScheduleRequest, acceptEncoding, contentEncoding, authorization, zuoraTrackId, zuoraEntityIds, zuoraOrgIds, zuoraVersion, _callback);
        Type localVarReturnType = new TypeToken<GETPaymentScheduleResponse>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    public class CancelPaymentScheduleRequestBuilder {
        private final LocalDate cancelDate;
        private final String paymentScheduleKey;
        private String acceptEncoding;
        private String contentEncoding;
        private String authorization;
        private String zuoraTrackId;
        private String zuoraEntityIds;
        private String zuoraOrgIds;
        private String zuoraVersion;

        private CancelPaymentScheduleRequestBuilder(LocalDate cancelDate, String paymentScheduleKey) {
            this.cancelDate = cancelDate;
            this.paymentScheduleKey = paymentScheduleKey;
        }

        /**
         * Set acceptEncoding
         * @param acceptEncoding Include the &#x60;Accept-Encoding: gzip&#x60; header to compress responses as a gzipped file. It can significantly reduce the bandwidth required for a response.   If specified, Zuora automatically compresses responses that contain over 1000 bytes of data, and the response contains a &#x60;Content-Encoding&#x60; header with the compression algorithm so that your client can decompress it.  (optional)
         * @return CancelPaymentScheduleRequestBuilder
         */
        public CancelPaymentScheduleRequestBuilder acceptEncoding(String acceptEncoding) {
            this.acceptEncoding = acceptEncoding;
            return this;
        }
        
        /**
         * Set contentEncoding
         * @param contentEncoding Include the &#x60;Content-Encoding: gzip&#x60; header to compress a request. With this header specified, you should upload a gzipped file for the request payload instead of sending the JSON payload.  (optional)
         * @return CancelPaymentScheduleRequestBuilder
         */
        public CancelPaymentScheduleRequestBuilder contentEncoding(String contentEncoding) {
            this.contentEncoding = contentEncoding;
            return this;
        }
        
        /**
         * Set authorization
         * @param authorization The value is in the &#x60;Bearer {token}&#x60; format where {token} is a valid OAuth token generated by calling [Create an OAuth token](https://developer.zuora.com/api-references/api/operation/createToken).  (optional)
         * @return CancelPaymentScheduleRequestBuilder
         */
        public CancelPaymentScheduleRequestBuilder authorization(String authorization) {
            this.authorization = authorization;
            return this;
        }
        
        /**
         * Set zuoraTrackId
         * @param zuoraTrackId A custom identifier for tracing the API call. If you set a value for this header, Zuora returns the same value in the response headers. This header enables you to associate your system process identifiers with Zuora API calls, to assist with troubleshooting in the event of an issue.  The value of this field must use the US-ASCII character set and must not include any of the following characters: colon (&#x60;:&#x60;), semicolon (&#x60;;&#x60;), double quote (&#x60;\&quot;&#x60;), and quote (&#x60;&#39;&#x60;).  (optional)
         * @return CancelPaymentScheduleRequestBuilder
         */
        public CancelPaymentScheduleRequestBuilder zuoraTrackId(String zuoraTrackId) {
            this.zuoraTrackId = zuoraTrackId;
            return this;
        }
        
        /**
         * Set zuoraEntityIds
         * @param zuoraEntityIds An entity ID. If you have [Zuora Multi-entity](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Multi-entity) enabled and the OAuth token is valid for more than one entity, you must use this header to specify which entity to perform the operation in. If the OAuth token is only valid for a single entity, or you do not have Zuora Multi-entity enabled, you do not need to set this header.  (optional)
         * @return CancelPaymentScheduleRequestBuilder
         */
        public CancelPaymentScheduleRequestBuilder zuoraEntityIds(String zuoraEntityIds) {
            this.zuoraEntityIds = zuoraEntityIds;
            return this;
        }
        
        /**
         * Set zuoraOrgIds
         * @param zuoraOrgIds Comma separated IDs. If you have &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Central_Platform/Multi-Org\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Zuora Multi-Org&lt;/a&gt; enabled,  you can use this header to specify which orgs to perform the operation in. If you do not have Zuora Multi-Org enabled, you should not set this header.  The IDs must be a sub-set of the user&#39;s accessible orgs. If you specify an org that the user does not have access to, the operation fails.  If the header is not set, the operation is performed in scope of the user&#39;s accessible orgs.  (optional)
         * @return CancelPaymentScheduleRequestBuilder
         */
        public CancelPaymentScheduleRequestBuilder zuoraOrgIds(String zuoraOrgIds) {
            this.zuoraOrgIds = zuoraOrgIds;
            return this;
        }
        
        /**
         * Set zuoraVersion
         * @param zuoraVersion The minor version of the Zuora REST API. See [Minor Version](https://developer.zuora.com/api-references/api/overview/#section/API-Versions/Minor-Version) for information about REST API version control.   This header affects the availability of the followiing response fields:   - &#x60;items&#x60; &gt; &#x60;paymentId&#x60;  (optional)
         * @return CancelPaymentScheduleRequestBuilder
         */
        public CancelPaymentScheduleRequestBuilder zuoraVersion(String zuoraVersion) {
            this.zuoraVersion = zuoraVersion;
            return this;
        }
        
        /**
         * Build call for cancelPaymentSchedule
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
            PUTCancelPaymentScheduleRequest puTCancelPaymentScheduleRequest = buildBodyParams();
            return cancelPaymentScheduleCall(paymentScheduleKey, puTCancelPaymentScheduleRequest, acceptEncoding, contentEncoding, authorization, zuoraTrackId, zuoraEntityIds, zuoraOrgIds, zuoraVersion, _callback);
        }

        private PUTCancelPaymentScheduleRequest buildBodyParams() {
            PUTCancelPaymentScheduleRequest puTCancelPaymentScheduleRequest = new PUTCancelPaymentScheduleRequest();
            puTCancelPaymentScheduleRequest.cancelDate(this.cancelDate);
            return puTCancelPaymentScheduleRequest;
        }

        /**
         * Execute cancelPaymentSchedule request
         * @return GETPaymentScheduleResponse
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td>  </td><td>  * Content-Encoding - This header is returned if you specify the &#x60;Accept-Encoding: gzip&#x60; request header and the response contains over 1000 bytes of data. Note that only the following MIME types support gzipped responses:   - &#x60;application/json&#x60;   - &#x60;application/xml&#x60;   - &#x60;text/html&#x60;   - &#x60;text/csv&#x60;   - &#x60;text/plain&#x60;  <br>  * RateLimit-Limit - The request limit quota for the time window closest to exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Remaining - The number of requests remaining in the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Reset - The number of seconds until the quota resets for the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Zuora-Request-Id - The Zuora internal identifier of the API call. You cannot control the value of this header.  <br>  * Zuora-Track-Id - A custom identifier for tracing the API call. If you specified a tracing identifier in the request headers, Zuora returns the same tracing identifier. Otherwise, Zuora does not set this header.  <br>  </td></tr>
         </table>
         */
        public GETPaymentScheduleResponse execute() throws ApiException {
            PUTCancelPaymentScheduleRequest puTCancelPaymentScheduleRequest = buildBodyParams();
            ApiResponse<GETPaymentScheduleResponse> localVarResp = cancelPaymentScheduleWithHttpInfo(paymentScheduleKey, puTCancelPaymentScheduleRequest, acceptEncoding, contentEncoding, authorization, zuoraTrackId, zuoraEntityIds, zuoraOrgIds, zuoraVersion);
            return localVarResp.getResponseBody();
        }

        /**
         * Execute cancelPaymentSchedule request with HTTP info returned
         * @return ApiResponse&lt;GETPaymentScheduleResponse&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td>  </td><td>  * Content-Encoding - This header is returned if you specify the &#x60;Accept-Encoding: gzip&#x60; request header and the response contains over 1000 bytes of data. Note that only the following MIME types support gzipped responses:   - &#x60;application/json&#x60;   - &#x60;application/xml&#x60;   - &#x60;text/html&#x60;   - &#x60;text/csv&#x60;   - &#x60;text/plain&#x60;  <br>  * RateLimit-Limit - The request limit quota for the time window closest to exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Remaining - The number of requests remaining in the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Reset - The number of seconds until the quota resets for the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Zuora-Request-Id - The Zuora internal identifier of the API call. You cannot control the value of this header.  <br>  * Zuora-Track-Id - A custom identifier for tracing the API call. If you specified a tracing identifier in the request headers, Zuora returns the same tracing identifier. Otherwise, Zuora does not set this header.  <br>  </td></tr>
         </table>
         */
        public ApiResponse<GETPaymentScheduleResponse> executeWithHttpInfo() throws ApiException {
            PUTCancelPaymentScheduleRequest puTCancelPaymentScheduleRequest = buildBodyParams();
            return cancelPaymentScheduleWithHttpInfo(paymentScheduleKey, puTCancelPaymentScheduleRequest, acceptEncoding, contentEncoding, authorization, zuoraTrackId, zuoraEntityIds, zuoraOrgIds, zuoraVersion);
        }

        /**
         * Execute cancelPaymentSchedule request (asynchronously)
         * @param _callback The callback to be executed when the API call finishes
         * @return The request call
         * @throws ApiException If fail to process the API call, e.g. serializing the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td>  </td><td>  * Content-Encoding - This header is returned if you specify the &#x60;Accept-Encoding: gzip&#x60; request header and the response contains over 1000 bytes of data. Note that only the following MIME types support gzipped responses:   - &#x60;application/json&#x60;   - &#x60;application/xml&#x60;   - &#x60;text/html&#x60;   - &#x60;text/csv&#x60;   - &#x60;text/plain&#x60;  <br>  * RateLimit-Limit - The request limit quota for the time window closest to exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Remaining - The number of requests remaining in the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Reset - The number of seconds until the quota resets for the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Zuora-Request-Id - The Zuora internal identifier of the API call. You cannot control the value of this header.  <br>  * Zuora-Track-Id - A custom identifier for tracing the API call. If you specified a tracing identifier in the request headers, Zuora returns the same tracing identifier. Otherwise, Zuora does not set this header.  <br>  </td></tr>
         </table>
         */
        public okhttp3.Call executeAsync(final ApiCallback<GETPaymentScheduleResponse> _callback) throws ApiException {
            PUTCancelPaymentScheduleRequest puTCancelPaymentScheduleRequest = buildBodyParams();
            return cancelPaymentScheduleAsync(paymentScheduleKey, puTCancelPaymentScheduleRequest, acceptEncoding, contentEncoding, authorization, zuoraTrackId, zuoraEntityIds, zuoraOrgIds, zuoraVersion, _callback);
        }
    }

    /**
     * Cancel a payment schedule
     * Cancels a payment schedule.  **Note:** - All pending payment schedule items will be canceled, effective from &#x60;cancelDate&#x60;.  - The Payment Schedules feature is in the **Early Adopter** phase. We are actively soliciting feedback from a small set of early adopters before releasing it as generally available. To manage and access this feature through the self-service interface, see [Manage Features](https://knowledgecenter.zuora.com/Zuora_Payments/Payments_Settings/Manage_Features) in the Knowledge Center. - This operation is only available if you have [Invoice Settlement](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/Invoice_Settlement) enabled. 
     * @param paymentScheduleKey The unique ID or number of a payment schedule. For example, &#x60;8a90857b822459cd018224dcb9eb13be&#x60;, or &#x60;PS-00000007&#x60;.  (required)
     * @param puTCancelPaymentScheduleRequest  (required)
     * @return CancelPaymentScheduleRequestBuilder
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td>  </td><td>  * Content-Encoding - This header is returned if you specify the &#x60;Accept-Encoding: gzip&#x60; request header and the response contains over 1000 bytes of data. Note that only the following MIME types support gzipped responses:   - &#x60;application/json&#x60;   - &#x60;application/xml&#x60;   - &#x60;text/html&#x60;   - &#x60;text/csv&#x60;   - &#x60;text/plain&#x60;  <br>  * RateLimit-Limit - The request limit quota for the time window closest to exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Remaining - The number of requests remaining in the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Reset - The number of seconds until the quota resets for the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Zuora-Request-Id - The Zuora internal identifier of the API call. You cannot control the value of this header.  <br>  * Zuora-Track-Id - A custom identifier for tracing the API call. If you specified a tracing identifier in the request headers, Zuora returns the same tracing identifier. Otherwise, Zuora does not set this header.  <br>  </td></tr>
     </table>
     */
    public CancelPaymentScheduleRequestBuilder cancelPaymentSchedule(LocalDate cancelDate, String paymentScheduleKey) throws IllegalArgumentException {
        if (cancelDate == null) throw new IllegalArgumentException("\"cancelDate\" is required but got null");
        if (paymentScheduleKey == null) throw new IllegalArgumentException("\"paymentScheduleKey\" is required but got null");
            

        return new CancelPaymentScheduleRequestBuilder(cancelDate, paymentScheduleKey);
    }
    private okhttp3.Call cancelPaymentScheduleItemCall(String itemId, String acceptEncoding, String contentEncoding, String authorization, String zuoraTrackId, String zuoraEntityIds, String zuoraOrgIds, String zuoraVersion, final ApiCallback _callback) throws ApiException {
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
        String localVarPath = "/v1/payment-schedule-items/{item-id}/cancel"
            .replace("{" + "item-id" + "}", localVarApiClient.escapeString(itemId.toString()));

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

        if (zuoraVersion != null) {
            localVarHeaderParams.put("zuora-version", localVarApiClient.parameterToString(zuoraVersion));
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
        return localVarApiClient.buildCall(basePath, localVarPath, "PUT", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call cancelPaymentScheduleItemValidateBeforeCall(String itemId, String acceptEncoding, String contentEncoding, String authorization, String zuoraTrackId, String zuoraEntityIds, String zuoraOrgIds, String zuoraVersion, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'itemId' is set
        if (itemId == null) {
            throw new ApiException("Missing the required parameter 'itemId' when calling cancelPaymentScheduleItem(Async)");
        }

        return cancelPaymentScheduleItemCall(itemId, acceptEncoding, contentEncoding, authorization, zuoraTrackId, zuoraEntityIds, zuoraOrgIds, zuoraVersion, _callback);

    }


    private ApiResponse<PUTPaymentScheduleItemResponse> cancelPaymentScheduleItemWithHttpInfo(String itemId, String acceptEncoding, String contentEncoding, String authorization, String zuoraTrackId, String zuoraEntityIds, String zuoraOrgIds, String zuoraVersion) throws ApiException {
        okhttp3.Call localVarCall = cancelPaymentScheduleItemValidateBeforeCall(itemId, acceptEncoding, contentEncoding, authorization, zuoraTrackId, zuoraEntityIds, zuoraOrgIds, zuoraVersion, null);
        Type localVarReturnType = new TypeToken<PUTPaymentScheduleItemResponse>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    private okhttp3.Call cancelPaymentScheduleItemAsync(String itemId, String acceptEncoding, String contentEncoding, String authorization, String zuoraTrackId, String zuoraEntityIds, String zuoraOrgIds, String zuoraVersion, final ApiCallback<PUTPaymentScheduleItemResponse> _callback) throws ApiException {

        okhttp3.Call localVarCall = cancelPaymentScheduleItemValidateBeforeCall(itemId, acceptEncoding, contentEncoding, authorization, zuoraTrackId, zuoraEntityIds, zuoraOrgIds, zuoraVersion, _callback);
        Type localVarReturnType = new TypeToken<PUTPaymentScheduleItemResponse>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    public class CancelPaymentScheduleItemRequestBuilder {
        private final String itemId;
        private String acceptEncoding;
        private String contentEncoding;
        private String authorization;
        private String zuoraTrackId;
        private String zuoraEntityIds;
        private String zuoraOrgIds;
        private String zuoraVersion;

        private CancelPaymentScheduleItemRequestBuilder(String itemId) {
            this.itemId = itemId;
        }

        /**
         * Set acceptEncoding
         * @param acceptEncoding Include the &#x60;Accept-Encoding: gzip&#x60; header to compress responses as a gzipped file. It can significantly reduce the bandwidth required for a response.   If specified, Zuora automatically compresses responses that contain over 1000 bytes of data, and the response contains a &#x60;Content-Encoding&#x60; header with the compression algorithm so that your client can decompress it.  (optional)
         * @return CancelPaymentScheduleItemRequestBuilder
         */
        public CancelPaymentScheduleItemRequestBuilder acceptEncoding(String acceptEncoding) {
            this.acceptEncoding = acceptEncoding;
            return this;
        }
        
        /**
         * Set contentEncoding
         * @param contentEncoding Include the &#x60;Content-Encoding: gzip&#x60; header to compress a request. With this header specified, you should upload a gzipped file for the request payload instead of sending the JSON payload.  (optional)
         * @return CancelPaymentScheduleItemRequestBuilder
         */
        public CancelPaymentScheduleItemRequestBuilder contentEncoding(String contentEncoding) {
            this.contentEncoding = contentEncoding;
            return this;
        }
        
        /**
         * Set authorization
         * @param authorization The value is in the &#x60;Bearer {token}&#x60; format where {token} is a valid OAuth token generated by calling [Create an OAuth token](https://developer.zuora.com/api-references/api/operation/createToken).  (optional)
         * @return CancelPaymentScheduleItemRequestBuilder
         */
        public CancelPaymentScheduleItemRequestBuilder authorization(String authorization) {
            this.authorization = authorization;
            return this;
        }
        
        /**
         * Set zuoraTrackId
         * @param zuoraTrackId A custom identifier for tracing the API call. If you set a value for this header, Zuora returns the same value in the response headers. This header enables you to associate your system process identifiers with Zuora API calls, to assist with troubleshooting in the event of an issue.  The value of this field must use the US-ASCII character set and must not include any of the following characters: colon (&#x60;:&#x60;), semicolon (&#x60;;&#x60;), double quote (&#x60;\&quot;&#x60;), and quote (&#x60;&#39;&#x60;).  (optional)
         * @return CancelPaymentScheduleItemRequestBuilder
         */
        public CancelPaymentScheduleItemRequestBuilder zuoraTrackId(String zuoraTrackId) {
            this.zuoraTrackId = zuoraTrackId;
            return this;
        }
        
        /**
         * Set zuoraEntityIds
         * @param zuoraEntityIds An entity ID. If you have [Zuora Multi-entity](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Multi-entity) enabled and the OAuth token is valid for more than one entity, you must use this header to specify which entity to perform the operation in. If the OAuth token is only valid for a single entity, or you do not have Zuora Multi-entity enabled, you do not need to set this header.  (optional)
         * @return CancelPaymentScheduleItemRequestBuilder
         */
        public CancelPaymentScheduleItemRequestBuilder zuoraEntityIds(String zuoraEntityIds) {
            this.zuoraEntityIds = zuoraEntityIds;
            return this;
        }
        
        /**
         * Set zuoraOrgIds
         * @param zuoraOrgIds Comma separated IDs. If you have &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Central_Platform/Multi-Org\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Zuora Multi-Org&lt;/a&gt; enabled,  you can use this header to specify which orgs to perform the operation in. If you do not have Zuora Multi-Org enabled, you should not set this header.  The IDs must be a sub-set of the user&#39;s accessible orgs. If you specify an org that the user does not have access to, the operation fails.  If the header is not set, the operation is performed in scope of the user&#39;s accessible orgs.  (optional)
         * @return CancelPaymentScheduleItemRequestBuilder
         */
        public CancelPaymentScheduleItemRequestBuilder zuoraOrgIds(String zuoraOrgIds) {
            this.zuoraOrgIds = zuoraOrgIds;
            return this;
        }
        
        /**
         * Set zuoraVersion
         * @param zuoraVersion The minor version of the Zuora REST API. See [Minor Version](https://developer.zuora.com/api-references/api/overview/#section/API-Versions/Minor-Version) for information about REST API version control.   This header affects the availability of the following response fields: - &#x60;paymentId&#x60;  (optional)
         * @return CancelPaymentScheduleItemRequestBuilder
         */
        public CancelPaymentScheduleItemRequestBuilder zuoraVersion(String zuoraVersion) {
            this.zuoraVersion = zuoraVersion;
            return this;
        }
        
        /**
         * Build call for cancelPaymentScheduleItem
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
            return cancelPaymentScheduleItemCall(itemId, acceptEncoding, contentEncoding, authorization, zuoraTrackId, zuoraEntityIds, zuoraOrgIds, zuoraVersion, _callback);
        }


        /**
         * Execute cancelPaymentScheduleItem request
         * @return PUTPaymentScheduleItemResponse
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td>  </td><td>  * Content-Encoding - This header is returned if you specify the &#x60;Accept-Encoding: gzip&#x60; request header and the response contains over 1000 bytes of data. Note that only the following MIME types support gzipped responses:   - &#x60;application/json&#x60;   - &#x60;application/xml&#x60;   - &#x60;text/html&#x60;   - &#x60;text/csv&#x60;   - &#x60;text/plain&#x60;  <br>  * RateLimit-Limit - The request limit quota for the time window closest to exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Remaining - The number of requests remaining in the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Reset - The number of seconds until the quota resets for the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Zuora-Request-Id - The Zuora internal identifier of the API call. You cannot control the value of this header.  <br>  * Zuora-Track-Id - A custom identifier for tracing the API call. If you specified a tracing identifier in the request headers, Zuora returns the same tracing identifier. Otherwise, Zuora does not set this header.  <br>  </td></tr>
         </table>
         */
        public PUTPaymentScheduleItemResponse execute() throws ApiException {
            ApiResponse<PUTPaymentScheduleItemResponse> localVarResp = cancelPaymentScheduleItemWithHttpInfo(itemId, acceptEncoding, contentEncoding, authorization, zuoraTrackId, zuoraEntityIds, zuoraOrgIds, zuoraVersion);
            return localVarResp.getResponseBody();
        }

        /**
         * Execute cancelPaymentScheduleItem request with HTTP info returned
         * @return ApiResponse&lt;PUTPaymentScheduleItemResponse&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td>  </td><td>  * Content-Encoding - This header is returned if you specify the &#x60;Accept-Encoding: gzip&#x60; request header and the response contains over 1000 bytes of data. Note that only the following MIME types support gzipped responses:   - &#x60;application/json&#x60;   - &#x60;application/xml&#x60;   - &#x60;text/html&#x60;   - &#x60;text/csv&#x60;   - &#x60;text/plain&#x60;  <br>  * RateLimit-Limit - The request limit quota for the time window closest to exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Remaining - The number of requests remaining in the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Reset - The number of seconds until the quota resets for the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Zuora-Request-Id - The Zuora internal identifier of the API call. You cannot control the value of this header.  <br>  * Zuora-Track-Id - A custom identifier for tracing the API call. If you specified a tracing identifier in the request headers, Zuora returns the same tracing identifier. Otherwise, Zuora does not set this header.  <br>  </td></tr>
         </table>
         */
        public ApiResponse<PUTPaymentScheduleItemResponse> executeWithHttpInfo() throws ApiException {
            return cancelPaymentScheduleItemWithHttpInfo(itemId, acceptEncoding, contentEncoding, authorization, zuoraTrackId, zuoraEntityIds, zuoraOrgIds, zuoraVersion);
        }

        /**
         * Execute cancelPaymentScheduleItem request (asynchronously)
         * @param _callback The callback to be executed when the API call finishes
         * @return The request call
         * @throws ApiException If fail to process the API call, e.g. serializing the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td>  </td><td>  * Content-Encoding - This header is returned if you specify the &#x60;Accept-Encoding: gzip&#x60; request header and the response contains over 1000 bytes of data. Note that only the following MIME types support gzipped responses:   - &#x60;application/json&#x60;   - &#x60;application/xml&#x60;   - &#x60;text/html&#x60;   - &#x60;text/csv&#x60;   - &#x60;text/plain&#x60;  <br>  * RateLimit-Limit - The request limit quota for the time window closest to exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Remaining - The number of requests remaining in the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Reset - The number of seconds until the quota resets for the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Zuora-Request-Id - The Zuora internal identifier of the API call. You cannot control the value of this header.  <br>  * Zuora-Track-Id - A custom identifier for tracing the API call. If you specified a tracing identifier in the request headers, Zuora returns the same tracing identifier. Otherwise, Zuora does not set this header.  <br>  </td></tr>
         </table>
         */
        public okhttp3.Call executeAsync(final ApiCallback<PUTPaymentScheduleItemResponse> _callback) throws ApiException {
            return cancelPaymentScheduleItemAsync(itemId, acceptEncoding, contentEncoding, authorization, zuoraTrackId, zuoraEntityIds, zuoraOrgIds, zuoraVersion, _callback);
        }
    }

    /**
     * Cancel a payment schedule item
     * Cancels a payment schedule item by ID.  **Note:** - The Payment Schedules feature is in the **Early Adopter** phase. We are actively soliciting feedback from a small set of early adopters before releasing it as generally available. To manage and access this feature through the self-service interface, see [Manage Features](https://knowledgecenter.zuora.com/Zuora_Payments/Payments_Settings/Manage_Features) in the Knowledge Center. - This operation is only available if you have [Invoice Settlement](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/Invoice_Settlement) enabled. 
     * @param itemId The unique ID of a payment schedule item.       (required)
     * @return CancelPaymentScheduleItemRequestBuilder
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td>  </td><td>  * Content-Encoding - This header is returned if you specify the &#x60;Accept-Encoding: gzip&#x60; request header and the response contains over 1000 bytes of data. Note that only the following MIME types support gzipped responses:   - &#x60;application/json&#x60;   - &#x60;application/xml&#x60;   - &#x60;text/html&#x60;   - &#x60;text/csv&#x60;   - &#x60;text/plain&#x60;  <br>  * RateLimit-Limit - The request limit quota for the time window closest to exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Remaining - The number of requests remaining in the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Reset - The number of seconds until the quota resets for the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Zuora-Request-Id - The Zuora internal identifier of the API call. You cannot control the value of this header.  <br>  * Zuora-Track-Id - A custom identifier for tracing the API call. If you specified a tracing identifier in the request headers, Zuora returns the same tracing identifier. Otherwise, Zuora does not set this header.  <br>  </td></tr>
     </table>
     */
    public CancelPaymentScheduleItemRequestBuilder cancelPaymentScheduleItem(String itemId) throws IllegalArgumentException {
        if (itemId == null) throw new IllegalArgumentException("\"itemId\" is required but got null");
            

        return new CancelPaymentScheduleItemRequestBuilder(itemId);
    }
    private okhttp3.Call paymentScheduleCall(POSTPaymentScheduleRequest poSTPaymentScheduleRequest, String idempotencyKey, String acceptEncoding, String contentEncoding, String authorization, String zuoraTrackId, String zuoraEntityIds, String zuoraOrgIds, String zuoraVersion, final ApiCallback _callback) throws ApiException {
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

        Object localVarPostBody = poSTPaymentScheduleRequest;

        // create path and map variables
        String localVarPath = "/v1/payment-schedules";

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

        if (zuoraVersion != null) {
            localVarHeaderParams.put("zuora-version", localVarApiClient.parameterToString(zuoraVersion));
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
    private okhttp3.Call paymentScheduleValidateBeforeCall(POSTPaymentScheduleRequest poSTPaymentScheduleRequest, String idempotencyKey, String acceptEncoding, String contentEncoding, String authorization, String zuoraTrackId, String zuoraEntityIds, String zuoraOrgIds, String zuoraVersion, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'poSTPaymentScheduleRequest' is set
        if (poSTPaymentScheduleRequest == null) {
            throw new ApiException("Missing the required parameter 'poSTPaymentScheduleRequest' when calling paymentSchedule(Async)");
        }

        return paymentScheduleCall(poSTPaymentScheduleRequest, idempotencyKey, acceptEncoding, contentEncoding, authorization, zuoraTrackId, zuoraEntityIds, zuoraOrgIds, zuoraVersion, _callback);

    }


    private ApiResponse<POSTPaymentScheduleResponse> paymentScheduleWithHttpInfo(POSTPaymentScheduleRequest poSTPaymentScheduleRequest, String idempotencyKey, String acceptEncoding, String contentEncoding, String authorization, String zuoraTrackId, String zuoraEntityIds, String zuoraOrgIds, String zuoraVersion) throws ApiException {
        okhttp3.Call localVarCall = paymentScheduleValidateBeforeCall(poSTPaymentScheduleRequest, idempotencyKey, acceptEncoding, contentEncoding, authorization, zuoraTrackId, zuoraEntityIds, zuoraOrgIds, zuoraVersion, null);
        Type localVarReturnType = new TypeToken<POSTPaymentScheduleResponse>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    private okhttp3.Call paymentScheduleAsync(POSTPaymentScheduleRequest poSTPaymentScheduleRequest, String idempotencyKey, String acceptEncoding, String contentEncoding, String authorization, String zuoraTrackId, String zuoraEntityIds, String zuoraOrgIds, String zuoraVersion, final ApiCallback<POSTPaymentScheduleResponse> _callback) throws ApiException {

        okhttp3.Call localVarCall = paymentScheduleValidateBeforeCall(poSTPaymentScheduleRequest, idempotencyKey, acceptEncoding, contentEncoding, authorization, zuoraTrackId, zuoraEntityIds, zuoraOrgIds, zuoraVersion, _callback);
        Type localVarReturnType = new TypeToken<POSTPaymentScheduleResponse>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    public class PaymentScheduleRequestBuilder {
        private String description;
        private String accountId;
        private String accountNumber;
        private Double amount;
        private POSTPaymentScheduleRequestAllOfBillingDocument billingDocument;
        private String currency;
        private List<Object> items;
        private Integer occurrences;
        private String paymentGatewayId;
        private String paymentMethodId;
        private List<PaymentSchedulePaymentOptionFields> paymentOption;
        private String paymentScheduleNumber;
        private String period;
        private Boolean prepayment;
        private Integer runHour;
        private Boolean standalone;
        private LocalDate startDate;
        private Double totalAmount;
        private String idempotencyKey;
        private String acceptEncoding;
        private String contentEncoding;
        private String authorization;
        private String zuoraTrackId;
        private String zuoraEntityIds;
        private String zuoraOrgIds;
        private String zuoraVersion;
        private POSTPaymentScheduleRequest poSTPaymentScheduleRequest;

        private PaymentScheduleRequestBuilder() {
        }

        /**
         * Set poSTPaymentScheduleRequest
         * @param poSTPaymentScheduleRequest  (optional)
         * @return PaymentScheduleRequestBuilder
         */
        public PaymentScheduleRequestBuilder poSTPaymentScheduleRequest(POSTPaymentScheduleRequest poSTPaymentScheduleRequest) {
            this.poSTPaymentScheduleRequest = poSTPaymentScheduleRequest;
            return this;
        }

        /**
         * Set description
         * @param description Description of the payment schedule. Max length is 255.  (optional)
         * @return PaymentScheduleRequestBuilder
         */
        public PaymentScheduleRequestBuilder description(String description) {
            this.description = description;
            return this;
        }
        
        /**
         * Set accountId
         * @param accountId ID of the customer account the payment schedule belongs to.  **Note:** &#x60;accountId&#x60; and &#x60;accountNumber&#x60; cannot both be &#x60;null&#x60;. When both fields are specified, the two values must match each other.            (optional)
         * @return PaymentScheduleRequestBuilder
         */
        public PaymentScheduleRequestBuilder accountId(String accountId) {
            this.accountId = accountId;
            return this;
        }
        
        /**
         * Set accountNumber
         * @param accountNumber Account number of the customer account the payment schedule belongs to.  **Note:** &#x60;accountId&#x60; and &#x60;accountNumber&#x60; cannot both be &#x60;null&#x60;. When both fields are specified, the two values must match each other.            (optional)
         * @return PaymentScheduleRequestBuilder
         */
        public PaymentScheduleRequestBuilder accountNumber(String accountNumber) {
            this.accountNumber = accountNumber;
            return this;
        }
        
        /**
         * Set amount
         * @param amount The amount of each payment schedule item in the payment schedule.  **Note:** - This field is required when &#x60;items&#x60; is not specified. - This field will be ignored when &#x60;items&#x60; is specified. - When creating recurring payment schedules, there are 2 options to specify amounts:     - Specify &#x60;totalAmount&#x60; and &#x60;occurrences&#x60;, &#x60;amount&#x60; will be calculated.   - Specify &#x60;amount&#x60; and &#x60;occurrences&#x60;, &#x60;totalAmount&#x60; will be calculated.   You must specify either &#x60;totalAmount&#x60; or &#x60;amount&#x60;. Specifying both fields at the same time is not allowed.  (optional)
         * @return PaymentScheduleRequestBuilder
         */
        public PaymentScheduleRequestBuilder amount(Double amount) {
            this.amount = amount;
            return this;
        }
        
        /**
         * Set billingDocument
         * @param billingDocument  (optional)
         * @return PaymentScheduleRequestBuilder
         */
        public PaymentScheduleRequestBuilder billingDocument(POSTPaymentScheduleRequestAllOfBillingDocument billingDocument) {
            this.billingDocument = billingDocument;
            return this;
        }
        
        /**
         * Set currency
         * @param currency Currency of the payment schedule.  **Note:** - This field is optional. The default value is the account&#39;s default currency. - This field will be ignored when &#x60;items&#x60; is specified.  (optional)
         * @return PaymentScheduleRequestBuilder
         */
        public PaymentScheduleRequestBuilder currency(String currency) {
            this.currency = currency;
            return this;
        }
        
        /**
         * Set items
         * @param items Container array for payment schedule items.  (optional)
         * @return PaymentScheduleRequestBuilder
         */
        public PaymentScheduleRequestBuilder items(List<Object> items) {
            this.items = items;
            return this;
        }
        
        /**
         * Set occurrences
         * @param occurrences The number of payment schedule item to be created. Maximum value is 1000.  **Note:** - This field is required when &#x60;items&#x60; is not specified. - This field will be ignored when &#x60;items&#x60; is specified.   (optional)
         * @return PaymentScheduleRequestBuilder
         */
        public PaymentScheduleRequestBuilder occurrences(Integer occurrences) {
            this.occurrences = occurrences;
            return this;
        }
        
        /**
         * Set paymentGatewayId
         * @param paymentGatewayId ID of the payment gateway.  **Note:** - This field is optional. The default value is the account&#39;s default payment gateway ID. If no payment gateway ID is found on the cusotmer account level, the default value will be the tenant&#39;s default payment gateway ID. - This field will be ignored when &#x60;items&#x60; is specified.  (optional)
         * @return PaymentScheduleRequestBuilder
         */
        public PaymentScheduleRequestBuilder paymentGatewayId(String paymentGatewayId) {
            this.paymentGatewayId = paymentGatewayId;
            return this;
        }
        
        /**
         * Set paymentMethodId
         * @param paymentMethodId ID of the payment method.  **Note:** - This field is optional. The default value is the account&#39;s default payment method ID. - This field will be ignored when &#x60;items&#x60; is specified.    (optional)
         * @return PaymentScheduleRequestBuilder
         */
        public PaymentScheduleRequestBuilder paymentMethodId(String paymentMethodId) {
            this.paymentMethodId = paymentMethodId;
            return this;
        }
        
        /**
         * Set paymentOption
         * @param paymentOption Container for the paymentOption items, which describe the transactional level rules for processing payments. Currently, only the Gateway Options type is supported.   Here is an example: &#x60;&#x60;&#x60; \\\&quot;paymentOption\\\&quot;: [   {     \\\&quot;type\\\&quot;: \\\&quot;GatewayOptions\\\&quot;,     \\\&quot;detail\\\&quot;: {       \\\&quot;SecCode\\\&quot;:\\\&quot;WEB\\\&quot;     }   } ] &#x60;&#x60;&#x60;  &#x60;paymentOption&#x60; of the payment schedule takes precedence over &#x60;paymentOption&#x60; of the payment schedule item.  (optional)
         * @return PaymentScheduleRequestBuilder
         */
        public PaymentScheduleRequestBuilder paymentOption(List<PaymentSchedulePaymentOptionFields> paymentOption) {
            this.paymentOption = paymentOption;
            return this;
        }
        
        /**
         * Set paymentScheduleNumber
         * @param paymentScheduleNumber You can use this field to specify the number of the payment schedule. Only characters from the following sets are allowed: A-Z, a-z, 0-9, and &#x60;-&#x60;.  Payment numbers must start with a letter. In addition,&#x60;-&#x60; can only be used at most once and cannot be placed at the beginning or the end of the payment numbers.           (optional)
         * @return PaymentScheduleRequestBuilder
         */
        public PaymentScheduleRequestBuilder paymentScheduleNumber(String paymentScheduleNumber) {
            this.paymentScheduleNumber = paymentScheduleNumber;
            return this;
        }
        
        /**
         * Set period
         * @param period The frequency for the payment collection since the &#x60;startDate&#x60;.  **Note:** - Thie field is required when &#x60;items&#x60; is not specified. - This field will be ignored when &#x60;items&#x60; is specified. - If &#x60;startDate&#x60; is &#x60;30&#x60; or &#x60;31&#x60; and &#x60;period&#x60; is &#x60;Monthly&#x60;, when in February, payment schedule will use the last day of February for payment collection.   (optional)
         * @return PaymentScheduleRequestBuilder
         */
        public PaymentScheduleRequestBuilder period(String period) {
            this.period = period;
            return this;
        }
        
        /**
         * Set prepayment
         * @param prepayment Indicates whether the payments created by the payment schedule will be used as reserved payments. This field will only be available if the prepaid cash drawdown permission is enabled. See [Prepaid Cash with Drawdown](https://knowledgecenter.zuora.com/Zuora_Billing/Billing_and_Invoicing/JA_Advanced_Consumption_Billing/Prepaid_Cash_with_Drawdown) for more information.  (optional)
         * @return PaymentScheduleRequestBuilder
         */
        public PaymentScheduleRequestBuilder prepayment(Boolean prepayment) {
            this.prepayment = prepayment;
            return this;
        }
        
        /**
         * Set runHour
         * @param runHour Specifies at which hour in the day in the tenant’s time zone when this payment will be collected. Available values: &#x60;[0,1,2,~,22,23]&#x60;.  **Note:** - If the time difference between your tenant’s timezone and the timezone where Zuora servers are is not in full hours, for example, 2.5 hours, the payment schedule items will be triggered half hour later than your scheduled time. - If the payment &#x60;runHour&#x60; and &#x60;scheduledDate&#x60; are backdated, the system will collect the payment when the next runHour occurs. - This field is optional. The default value is &#x60;0&#x60;. - This field will be ignored when &#x60;items&#x60; is specified.               (optional)
         * @return PaymentScheduleRequestBuilder
         */
        public PaymentScheduleRequestBuilder runHour(Integer runHour) {
            this.runHour = runHour;
            return this;
        }
        
        /**
         * Set standalone
         * @param standalone Indicate whether the payments created by the payment schedule are standalone payments or not. When setting to &#x60;true&#x60;, standalone payments will be created. When setting to &#x60;false&#x60;, you can either specify a billing document, or not specifying any billing documents. In the later case, unapplied payments will be created. If set to &#x60;null&#x60;, standalone payment will be created.  **Note**:  - This field is only available if the Standalone Payment is enabled. Do not include this field if Standalone Payment is not enabled. - If Standalone Payment is enabled, default value is &#x60;true&#x60;.  (optional)
         * @return PaymentScheduleRequestBuilder
         */
        public PaymentScheduleRequestBuilder standalone(Boolean standalone) {
            this.standalone = standalone;
            return this;
        }
        
        /**
         * Set startDate
         * @param startDate The date for the first payment collection.  **Note:** - This field is required when &#x60;items&#x60; is not specified. - This field will be ignored when &#x60;items&#x60; is specified.                (optional)
         * @return PaymentScheduleRequestBuilder
         */
        public PaymentScheduleRequestBuilder startDate(LocalDate startDate) {
            this.startDate = startDate;
            return this;
        }
        
        /**
         * Set totalAmount
         * @param totalAmount The total amount of that the payment schedule will collect. This field is only available for recurring payment schedules.   **Note**: - When creating recurring payment schedules, there are 2 options to specify amounts:      - Specify &#x60;totalAmount&#x60; and &#x60;occurrences&#x60;, &#x60;amount&#x60; will be calculated.   - Specify &#x60;amount&#x60; and &#x60;occurrences&#x60;, &#x60;totalAmount&#x60; will be calculated.      You must specify either &#x60;totalAmount&#x60; or &#x60;amount&#x60;. Specifying both fields at the same time is not allowed. - If the Standalone Payments feature is enabled and &#x60;standalone&#x60; is set to &#x60;true&#x60; for the payment schedule, &#x60;totalAmount&#x60; will be ignored.  (optional)
         * @return PaymentScheduleRequestBuilder
         */
        public PaymentScheduleRequestBuilder totalAmount(Double totalAmount) {
            this.totalAmount = totalAmount;
            return this;
        }
        
        /**
         * Set idempotencyKey
         * @param idempotencyKey Specify a unique idempotency key if you want to perform an idempotent POST or PATCH request. Do not use this header in other request types.   With this header specified, the Zuora server can identify subsequent retries of the same request using this value, which prevents the same operation from being performed multiple times by accident.   (optional)
         * @return PaymentScheduleRequestBuilder
         */
        public PaymentScheduleRequestBuilder idempotencyKey(String idempotencyKey) {
            this.idempotencyKey = idempotencyKey;
            return this;
        }
        
        /**
         * Set acceptEncoding
         * @param acceptEncoding Include the &#x60;Accept-Encoding: gzip&#x60; header to compress responses as a gzipped file. It can significantly reduce the bandwidth required for a response.   If specified, Zuora automatically compresses responses that contain over 1000 bytes of data, and the response contains a &#x60;Content-Encoding&#x60; header with the compression algorithm so that your client can decompress it.  (optional)
         * @return PaymentScheduleRequestBuilder
         */
        public PaymentScheduleRequestBuilder acceptEncoding(String acceptEncoding) {
            this.acceptEncoding = acceptEncoding;
            return this;
        }
        
        /**
         * Set contentEncoding
         * @param contentEncoding Include the &#x60;Content-Encoding: gzip&#x60; header to compress a request. With this header specified, you should upload a gzipped file for the request payload instead of sending the JSON payload.  (optional)
         * @return PaymentScheduleRequestBuilder
         */
        public PaymentScheduleRequestBuilder contentEncoding(String contentEncoding) {
            this.contentEncoding = contentEncoding;
            return this;
        }
        
        /**
         * Set authorization
         * @param authorization The value is in the &#x60;Bearer {token}&#x60; format where {token} is a valid OAuth token generated by calling [Create an OAuth token](https://developer.zuora.com/api-references/api/operation/createToken).  (optional)
         * @return PaymentScheduleRequestBuilder
         */
        public PaymentScheduleRequestBuilder authorization(String authorization) {
            this.authorization = authorization;
            return this;
        }
        
        /**
         * Set zuoraTrackId
         * @param zuoraTrackId A custom identifier for tracing the API call. If you set a value for this header, Zuora returns the same value in the response headers. This header enables you to associate your system process identifiers with Zuora API calls, to assist with troubleshooting in the event of an issue.  The value of this field must use the US-ASCII character set and must not include any of the following characters: colon (&#x60;:&#x60;), semicolon (&#x60;;&#x60;), double quote (&#x60;\&quot;&#x60;), and quote (&#x60;&#39;&#x60;).  (optional)
         * @return PaymentScheduleRequestBuilder
         */
        public PaymentScheduleRequestBuilder zuoraTrackId(String zuoraTrackId) {
            this.zuoraTrackId = zuoraTrackId;
            return this;
        }
        
        /**
         * Set zuoraEntityIds
         * @param zuoraEntityIds An entity ID. If you have [Zuora Multi-entity](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Multi-entity) enabled and the OAuth token is valid for more than one entity, you must use this header to specify which entity to perform the operation in. If the OAuth token is only valid for a single entity, or you do not have Zuora Multi-entity enabled, you do not need to set this header.  (optional)
         * @return PaymentScheduleRequestBuilder
         */
        public PaymentScheduleRequestBuilder zuoraEntityIds(String zuoraEntityIds) {
            this.zuoraEntityIds = zuoraEntityIds;
            return this;
        }
        
        /**
         * Set zuoraOrgIds
         * @param zuoraOrgIds Comma separated IDs. If you have &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Central_Platform/Multi-Org\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Zuora Multi-Org&lt;/a&gt; enabled,  you can use this header to specify which orgs to perform the operation in. If you do not have Zuora Multi-Org enabled, you should not set this header.  The IDs must be a sub-set of the user&#39;s accessible orgs. If you specify an org that the user does not have access to, the operation fails.  If the header is not set, the operation is performed in scope of the user&#39;s accessible orgs.  (optional)
         * @return PaymentScheduleRequestBuilder
         */
        public PaymentScheduleRequestBuilder zuoraOrgIds(String zuoraOrgIds) {
            this.zuoraOrgIds = zuoraOrgIds;
            return this;
        }
        
        /**
         * Set zuoraVersion
         * @param zuoraVersion The minor version of the Zuora REST API. See [Minor Version](https://developer.zuora.com/api-references/api/overview/#section/API-Versions/Minor-Version) for information about REST API version control.   This header affects the availability of the following request fields: * &#x60;billingDocument&#x60; * &#x60;items&#x60; &gt; &#x60;billingDocument&#x60;  (optional)
         * @return PaymentScheduleRequestBuilder
         */
        public PaymentScheduleRequestBuilder zuoraVersion(String zuoraVersion) {
            this.zuoraVersion = zuoraVersion;
            return this;
        }
        
        /**
         * Build call for paymentSchedule
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
            POSTPaymentScheduleRequest poSTPaymentScheduleRequest = buildBodyParams();
            return paymentScheduleCall(poSTPaymentScheduleRequest, idempotencyKey, acceptEncoding, contentEncoding, authorization, zuoraTrackId, zuoraEntityIds, zuoraOrgIds, zuoraVersion, _callback);
        }

        private POSTPaymentScheduleRequest buildBodyParams() {
            return this.poSTPaymentScheduleRequest;
        }

        /**
         * Execute paymentSchedule request
         * @return POSTPaymentScheduleResponse
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td>  </td><td>  * Content-Encoding - This header is returned if you specify the &#x60;Accept-Encoding: gzip&#x60; request header and the response contains over 1000 bytes of data. Note that only the following MIME types support gzipped responses:   - &#x60;application/json&#x60;   - &#x60;application/xml&#x60;   - &#x60;text/html&#x60;   - &#x60;text/csv&#x60;   - &#x60;text/plain&#x60;  <br>  * RateLimit-Limit - The request limit quota for the time window closest to exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Remaining - The number of requests remaining in the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Reset - The number of seconds until the quota resets for the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Zuora-Request-Id - The Zuora internal identifier of the API call. You cannot control the value of this header.  <br>  * Zuora-Track-Id - A custom identifier for tracing the API call. If you specified a tracing identifier in the request headers, Zuora returns the same tracing identifier. Otherwise, Zuora does not set this header.  <br>  </td></tr>
         </table>
         */
        public POSTPaymentScheduleResponse execute() throws ApiException {
            POSTPaymentScheduleRequest poSTPaymentScheduleRequest = buildBodyParams();
            ApiResponse<POSTPaymentScheduleResponse> localVarResp = paymentScheduleWithHttpInfo(poSTPaymentScheduleRequest, idempotencyKey, acceptEncoding, contentEncoding, authorization, zuoraTrackId, zuoraEntityIds, zuoraOrgIds, zuoraVersion);
            return localVarResp.getResponseBody();
        }

        /**
         * Execute paymentSchedule request with HTTP info returned
         * @return ApiResponse&lt;POSTPaymentScheduleResponse&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td>  </td><td>  * Content-Encoding - This header is returned if you specify the &#x60;Accept-Encoding: gzip&#x60; request header and the response contains over 1000 bytes of data. Note that only the following MIME types support gzipped responses:   - &#x60;application/json&#x60;   - &#x60;application/xml&#x60;   - &#x60;text/html&#x60;   - &#x60;text/csv&#x60;   - &#x60;text/plain&#x60;  <br>  * RateLimit-Limit - The request limit quota for the time window closest to exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Remaining - The number of requests remaining in the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Reset - The number of seconds until the quota resets for the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Zuora-Request-Id - The Zuora internal identifier of the API call. You cannot control the value of this header.  <br>  * Zuora-Track-Id - A custom identifier for tracing the API call. If you specified a tracing identifier in the request headers, Zuora returns the same tracing identifier. Otherwise, Zuora does not set this header.  <br>  </td></tr>
         </table>
         */
        public ApiResponse<POSTPaymentScheduleResponse> executeWithHttpInfo() throws ApiException {
            POSTPaymentScheduleRequest poSTPaymentScheduleRequest = buildBodyParams();
            return paymentScheduleWithHttpInfo(poSTPaymentScheduleRequest, idempotencyKey, acceptEncoding, contentEncoding, authorization, zuoraTrackId, zuoraEntityIds, zuoraOrgIds, zuoraVersion);
        }

        /**
         * Execute paymentSchedule request (asynchronously)
         * @param _callback The callback to be executed when the API call finishes
         * @return The request call
         * @throws ApiException If fail to process the API call, e.g. serializing the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td>  </td><td>  * Content-Encoding - This header is returned if you specify the &#x60;Accept-Encoding: gzip&#x60; request header and the response contains over 1000 bytes of data. Note that only the following MIME types support gzipped responses:   - &#x60;application/json&#x60;   - &#x60;application/xml&#x60;   - &#x60;text/html&#x60;   - &#x60;text/csv&#x60;   - &#x60;text/plain&#x60;  <br>  * RateLimit-Limit - The request limit quota for the time window closest to exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Remaining - The number of requests remaining in the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Reset - The number of seconds until the quota resets for the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Zuora-Request-Id - The Zuora internal identifier of the API call. You cannot control the value of this header.  <br>  * Zuora-Track-Id - A custom identifier for tracing the API call. If you specified a tracing identifier in the request headers, Zuora returns the same tracing identifier. Otherwise, Zuora does not set this header.  <br>  </td></tr>
         </table>
         */
        public okhttp3.Call executeAsync(final ApiCallback<POSTPaymentScheduleResponse> _callback) throws ApiException {
            POSTPaymentScheduleRequest poSTPaymentScheduleRequest = buildBodyParams();
            return paymentScheduleAsync(poSTPaymentScheduleRequest, idempotencyKey, acceptEncoding, contentEncoding, authorization, zuoraTrackId, zuoraEntityIds, zuoraOrgIds, zuoraVersion, _callback);
        }
    }

    /**
     * Create a payment schedule
     * Creates a payment schedule. You can create either recurring payment schedules or custom payment schedules.  **Note:** - This operation is only available if you have [Invoice Settlement](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/Invoice_Settlement) enabled. - You can choose to use payment schedules to process payments associated with billing documents or unapplied payments. If Standalone Payment is enabled, you can also use payment schedules to process standalone payments. - This operation is version controlled. If you set &#x60;zuora-version&#x60; to &#x60;329.0&#x60;, when creating custom payment schedules associated with billing documents, you need to specify the billing document for each payment schedule item; If &#x60;zuora-version&#x60; is set to &#x60;330.0&#x60;, when creating custom payment schedules associated with billing documents, you only need to specify the billing documents at the payment schedule level. The default version number is &#x60;329.0&#x60;. However, we recommend that you specify the version to &#x60;330.0&#x60;. &#x60;329.0&#x60; will be deprecated soon. 
     * @param poSTPaymentScheduleRequest  (required)
     * @return PaymentScheduleRequestBuilder
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td>  </td><td>  * Content-Encoding - This header is returned if you specify the &#x60;Accept-Encoding: gzip&#x60; request header and the response contains over 1000 bytes of data. Note that only the following MIME types support gzipped responses:   - &#x60;application/json&#x60;   - &#x60;application/xml&#x60;   - &#x60;text/html&#x60;   - &#x60;text/csv&#x60;   - &#x60;text/plain&#x60;  <br>  * RateLimit-Limit - The request limit quota for the time window closest to exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Remaining - The number of requests remaining in the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Reset - The number of seconds until the quota resets for the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Zuora-Request-Id - The Zuora internal identifier of the API call. You cannot control the value of this header.  <br>  * Zuora-Track-Id - A custom identifier for tracing the API call. If you specified a tracing identifier in the request headers, Zuora returns the same tracing identifier. Otherwise, Zuora does not set this header.  <br>  </td></tr>
     </table>
     */
    public PaymentScheduleRequestBuilder paymentSchedule() throws IllegalArgumentException {
        return new PaymentScheduleRequestBuilder();
    }
    private okhttp3.Call paymentScheduleItemCall(String itemId, String acceptEncoding, String contentEncoding, String authorization, String zuoraTrackId, String zuoraEntityIds, String zuoraOrgIds, String zuoraVersion, final ApiCallback _callback) throws ApiException {
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
        String localVarPath = "/v1/payment-schedule-items/{item-id}"
            .replace("{" + "item-id" + "}", localVarApiClient.escapeString(itemId.toString()));

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

        if (zuoraVersion != null) {
            localVarHeaderParams.put("zuora-version", localVarApiClient.parameterToString(zuoraVersion));
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
    private okhttp3.Call paymentScheduleItemValidateBeforeCall(String itemId, String acceptEncoding, String contentEncoding, String authorization, String zuoraTrackId, String zuoraEntityIds, String zuoraOrgIds, String zuoraVersion, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'itemId' is set
        if (itemId == null) {
            throw new ApiException("Missing the required parameter 'itemId' when calling paymentScheduleItem(Async)");
        }

        return paymentScheduleItemCall(itemId, acceptEncoding, contentEncoding, authorization, zuoraTrackId, zuoraEntityIds, zuoraOrgIds, zuoraVersion, _callback);

    }


    private ApiResponse<GETPaymentScheduleItemResponse> paymentScheduleItemWithHttpInfo(String itemId, String acceptEncoding, String contentEncoding, String authorization, String zuoraTrackId, String zuoraEntityIds, String zuoraOrgIds, String zuoraVersion) throws ApiException {
        okhttp3.Call localVarCall = paymentScheduleItemValidateBeforeCall(itemId, acceptEncoding, contentEncoding, authorization, zuoraTrackId, zuoraEntityIds, zuoraOrgIds, zuoraVersion, null);
        Type localVarReturnType = new TypeToken<GETPaymentScheduleItemResponse>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    private okhttp3.Call paymentScheduleItemAsync(String itemId, String acceptEncoding, String contentEncoding, String authorization, String zuoraTrackId, String zuoraEntityIds, String zuoraOrgIds, String zuoraVersion, final ApiCallback<GETPaymentScheduleItemResponse> _callback) throws ApiException {

        okhttp3.Call localVarCall = paymentScheduleItemValidateBeforeCall(itemId, acceptEncoding, contentEncoding, authorization, zuoraTrackId, zuoraEntityIds, zuoraOrgIds, zuoraVersion, _callback);
        Type localVarReturnType = new TypeToken<GETPaymentScheduleItemResponse>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    public class PaymentScheduleItemRequestBuilder {
        private final String itemId;
        private String acceptEncoding;
        private String contentEncoding;
        private String authorization;
        private String zuoraTrackId;
        private String zuoraEntityIds;
        private String zuoraOrgIds;
        private String zuoraVersion;

        private PaymentScheduleItemRequestBuilder(String itemId) {
            this.itemId = itemId;
        }

        /**
         * Set acceptEncoding
         * @param acceptEncoding Include the &#x60;Accept-Encoding: gzip&#x60; header to compress responses as a gzipped file. It can significantly reduce the bandwidth required for a response.   If specified, Zuora automatically compresses responses that contain over 1000 bytes of data, and the response contains a &#x60;Content-Encoding&#x60; header with the compression algorithm so that your client can decompress it.  (optional)
         * @return PaymentScheduleItemRequestBuilder
         */
        public PaymentScheduleItemRequestBuilder acceptEncoding(String acceptEncoding) {
            this.acceptEncoding = acceptEncoding;
            return this;
        }
        
        /**
         * Set contentEncoding
         * @param contentEncoding Include the &#x60;Content-Encoding: gzip&#x60; header to compress a request. With this header specified, you should upload a gzipped file for the request payload instead of sending the JSON payload.  (optional)
         * @return PaymentScheduleItemRequestBuilder
         */
        public PaymentScheduleItemRequestBuilder contentEncoding(String contentEncoding) {
            this.contentEncoding = contentEncoding;
            return this;
        }
        
        /**
         * Set authorization
         * @param authorization The value is in the &#x60;Bearer {token}&#x60; format where {token} is a valid OAuth token generated by calling [Create an OAuth token](https://developer.zuora.com/api-references/api/operation/createToken).  (optional)
         * @return PaymentScheduleItemRequestBuilder
         */
        public PaymentScheduleItemRequestBuilder authorization(String authorization) {
            this.authorization = authorization;
            return this;
        }
        
        /**
         * Set zuoraTrackId
         * @param zuoraTrackId A custom identifier for tracing the API call. If you set a value for this header, Zuora returns the same value in the response headers. This header enables you to associate your system process identifiers with Zuora API calls, to assist with troubleshooting in the event of an issue.  The value of this field must use the US-ASCII character set and must not include any of the following characters: colon (&#x60;:&#x60;), semicolon (&#x60;;&#x60;), double quote (&#x60;\&quot;&#x60;), and quote (&#x60;&#39;&#x60;).  (optional)
         * @return PaymentScheduleItemRequestBuilder
         */
        public PaymentScheduleItemRequestBuilder zuoraTrackId(String zuoraTrackId) {
            this.zuoraTrackId = zuoraTrackId;
            return this;
        }
        
        /**
         * Set zuoraEntityIds
         * @param zuoraEntityIds An entity ID. If you have [Zuora Multi-entity](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Multi-entity) enabled and the OAuth token is valid for more than one entity, you must use this header to specify which entity to perform the operation in. If the OAuth token is only valid for a single entity, or you do not have Zuora Multi-entity enabled, you do not need to set this header.  (optional)
         * @return PaymentScheduleItemRequestBuilder
         */
        public PaymentScheduleItemRequestBuilder zuoraEntityIds(String zuoraEntityIds) {
            this.zuoraEntityIds = zuoraEntityIds;
            return this;
        }
        
        /**
         * Set zuoraOrgIds
         * @param zuoraOrgIds Comma separated IDs. If you have &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Central_Platform/Multi-Org\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Zuora Multi-Org&lt;/a&gt; enabled,  you can use this header to specify which orgs to perform the operation in. If you do not have Zuora Multi-Org enabled, you should not set this header.  The IDs must be a sub-set of the user&#39;s accessible orgs. If you specify an org that the user does not have access to, the operation fails.  If the header is not set, the operation is performed in scope of the user&#39;s accessible orgs.  (optional)
         * @return PaymentScheduleItemRequestBuilder
         */
        public PaymentScheduleItemRequestBuilder zuoraOrgIds(String zuoraOrgIds) {
            this.zuoraOrgIds = zuoraOrgIds;
            return this;
        }
        
        /**
         * Set zuoraVersion
         * @param zuoraVersion The minor version of the Zuora REST API. See [Minor Version](https://developer.zuora.com/api-references/api/overview/#section/API-Versions/Minor-Version) for information about REST API version control.   This header affects the availability of the following response fields: - &#x60;paymentId&#x60;  (optional)
         * @return PaymentScheduleItemRequestBuilder
         */
        public PaymentScheduleItemRequestBuilder zuoraVersion(String zuoraVersion) {
            this.zuoraVersion = zuoraVersion;
            return this;
        }
        
        /**
         * Build call for paymentScheduleItem
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
            return paymentScheduleItemCall(itemId, acceptEncoding, contentEncoding, authorization, zuoraTrackId, zuoraEntityIds, zuoraOrgIds, zuoraVersion, _callback);
        }


        /**
         * Execute paymentScheduleItem request
         * @return GETPaymentScheduleItemResponse
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td>  </td><td>  * Content-Encoding - This header is returned if you specify the &#x60;Accept-Encoding: gzip&#x60; request header and the response contains over 1000 bytes of data. Note that only the following MIME types support gzipped responses:   - &#x60;application/json&#x60;   - &#x60;application/xml&#x60;   - &#x60;text/html&#x60;   - &#x60;text/csv&#x60;   - &#x60;text/plain&#x60;  <br>  * RateLimit-Limit - The request limit quota for the time window closest to exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Remaining - The number of requests remaining in the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Reset - The number of seconds until the quota resets for the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Zuora-Request-Id - The Zuora internal identifier of the API call. You cannot control the value of this header.  <br>  * Zuora-Track-Id - A custom identifier for tracing the API call. If you specified a tracing identifier in the request headers, Zuora returns the same tracing identifier. Otherwise, Zuora does not set this header.  <br>  </td></tr>
         </table>
         */
        public GETPaymentScheduleItemResponse execute() throws ApiException {
            ApiResponse<GETPaymentScheduleItemResponse> localVarResp = paymentScheduleItemWithHttpInfo(itemId, acceptEncoding, contentEncoding, authorization, zuoraTrackId, zuoraEntityIds, zuoraOrgIds, zuoraVersion);
            return localVarResp.getResponseBody();
        }

        /**
         * Execute paymentScheduleItem request with HTTP info returned
         * @return ApiResponse&lt;GETPaymentScheduleItemResponse&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td>  </td><td>  * Content-Encoding - This header is returned if you specify the &#x60;Accept-Encoding: gzip&#x60; request header and the response contains over 1000 bytes of data. Note that only the following MIME types support gzipped responses:   - &#x60;application/json&#x60;   - &#x60;application/xml&#x60;   - &#x60;text/html&#x60;   - &#x60;text/csv&#x60;   - &#x60;text/plain&#x60;  <br>  * RateLimit-Limit - The request limit quota for the time window closest to exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Remaining - The number of requests remaining in the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Reset - The number of seconds until the quota resets for the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Zuora-Request-Id - The Zuora internal identifier of the API call. You cannot control the value of this header.  <br>  * Zuora-Track-Id - A custom identifier for tracing the API call. If you specified a tracing identifier in the request headers, Zuora returns the same tracing identifier. Otherwise, Zuora does not set this header.  <br>  </td></tr>
         </table>
         */
        public ApiResponse<GETPaymentScheduleItemResponse> executeWithHttpInfo() throws ApiException {
            return paymentScheduleItemWithHttpInfo(itemId, acceptEncoding, contentEncoding, authorization, zuoraTrackId, zuoraEntityIds, zuoraOrgIds, zuoraVersion);
        }

        /**
         * Execute paymentScheduleItem request (asynchronously)
         * @param _callback The callback to be executed when the API call finishes
         * @return The request call
         * @throws ApiException If fail to process the API call, e.g. serializing the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td>  </td><td>  * Content-Encoding - This header is returned if you specify the &#x60;Accept-Encoding: gzip&#x60; request header and the response contains over 1000 bytes of data. Note that only the following MIME types support gzipped responses:   - &#x60;application/json&#x60;   - &#x60;application/xml&#x60;   - &#x60;text/html&#x60;   - &#x60;text/csv&#x60;   - &#x60;text/plain&#x60;  <br>  * RateLimit-Limit - The request limit quota for the time window closest to exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Remaining - The number of requests remaining in the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Reset - The number of seconds until the quota resets for the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Zuora-Request-Id - The Zuora internal identifier of the API call. You cannot control the value of this header.  <br>  * Zuora-Track-Id - A custom identifier for tracing the API call. If you specified a tracing identifier in the request headers, Zuora returns the same tracing identifier. Otherwise, Zuora does not set this header.  <br>  </td></tr>
         </table>
         */
        public okhttp3.Call executeAsync(final ApiCallback<GETPaymentScheduleItemResponse> _callback) throws ApiException {
            return paymentScheduleItemAsync(itemId, acceptEncoding, contentEncoding, authorization, zuoraTrackId, zuoraEntityIds, zuoraOrgIds, zuoraVersion, _callback);
        }
    }

    /**
     * Retrieve a payment schedule item
     * Retrieves a payment schedule item by ID.  **Note:** - The Payment Schedules feature is in the **Early Adopter** phase. We are actively soliciting feedback from a small set of early adopters before releasing it as generally available. To manage and access this feature through the self-service interface, see [Manage Features](https://knowledgecenter.zuora.com/Zuora_Payments/Payments_Settings/Manage_Features) in the Knowledge Center. - This operation is only available if you have [Invoice Settlement](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/Invoice_Settlement) enabled. 
     * @param itemId The unique ID of a payment schedule item.  (required)
     * @return PaymentScheduleItemRequestBuilder
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td>  </td><td>  * Content-Encoding - This header is returned if you specify the &#x60;Accept-Encoding: gzip&#x60; request header and the response contains over 1000 bytes of data. Note that only the following MIME types support gzipped responses:   - &#x60;application/json&#x60;   - &#x60;application/xml&#x60;   - &#x60;text/html&#x60;   - &#x60;text/csv&#x60;   - &#x60;text/plain&#x60;  <br>  * RateLimit-Limit - The request limit quota for the time window closest to exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Remaining - The number of requests remaining in the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Reset - The number of seconds until the quota resets for the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Zuora-Request-Id - The Zuora internal identifier of the API call. You cannot control the value of this header.  <br>  * Zuora-Track-Id - A custom identifier for tracing the API call. If you specified a tracing identifier in the request headers, Zuora returns the same tracing identifier. Otherwise, Zuora does not set this header.  <br>  </td></tr>
     </table>
     */
    public PaymentScheduleItemRequestBuilder paymentScheduleItem(String itemId) throws IllegalArgumentException {
        if (itemId == null) throw new IllegalArgumentException("\"itemId\" is required but got null");
            

        return new PaymentScheduleItemRequestBuilder(itemId);
    }
    private okhttp3.Call paymentScheduleItem_0Call(String itemId, PUTPaymentScheduleItemRequest puTPaymentScheduleItemRequest, String acceptEncoding, String contentEncoding, String authorization, String zuoraTrackId, String zuoraEntityIds, String zuoraOrgIds, String zuoraVersion, final ApiCallback _callback) throws ApiException {
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

        Object localVarPostBody = puTPaymentScheduleItemRequest;

        // create path and map variables
        String localVarPath = "/v1/payment-schedule-items/{item-id}"
            .replace("{" + "item-id" + "}", localVarApiClient.escapeString(itemId.toString()));

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

        if (zuoraVersion != null) {
            localVarHeaderParams.put("zuora-version", localVarApiClient.parameterToString(zuoraVersion));
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
    private okhttp3.Call paymentScheduleItem_0ValidateBeforeCall(String itemId, PUTPaymentScheduleItemRequest puTPaymentScheduleItemRequest, String acceptEncoding, String contentEncoding, String authorization, String zuoraTrackId, String zuoraEntityIds, String zuoraOrgIds, String zuoraVersion, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'itemId' is set
        if (itemId == null) {
            throw new ApiException("Missing the required parameter 'itemId' when calling paymentScheduleItem_0(Async)");
        }

        // verify the required parameter 'puTPaymentScheduleItemRequest' is set
        if (puTPaymentScheduleItemRequest == null) {
            throw new ApiException("Missing the required parameter 'puTPaymentScheduleItemRequest' when calling paymentScheduleItem_0(Async)");
        }

        return paymentScheduleItem_0Call(itemId, puTPaymentScheduleItemRequest, acceptEncoding, contentEncoding, authorization, zuoraTrackId, zuoraEntityIds, zuoraOrgIds, zuoraVersion, _callback);

    }


    private ApiResponse<PUTPaymentScheduleItemResponse> paymentScheduleItem_0WithHttpInfo(String itemId, PUTPaymentScheduleItemRequest puTPaymentScheduleItemRequest, String acceptEncoding, String contentEncoding, String authorization, String zuoraTrackId, String zuoraEntityIds, String zuoraOrgIds, String zuoraVersion) throws ApiException {
        okhttp3.Call localVarCall = paymentScheduleItem_0ValidateBeforeCall(itemId, puTPaymentScheduleItemRequest, acceptEncoding, contentEncoding, authorization, zuoraTrackId, zuoraEntityIds, zuoraOrgIds, zuoraVersion, null);
        Type localVarReturnType = new TypeToken<PUTPaymentScheduleItemResponse>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    private okhttp3.Call paymentScheduleItem_0Async(String itemId, PUTPaymentScheduleItemRequest puTPaymentScheduleItemRequest, String acceptEncoding, String contentEncoding, String authorization, String zuoraTrackId, String zuoraEntityIds, String zuoraOrgIds, String zuoraVersion, final ApiCallback<PUTPaymentScheduleItemResponse> _callback) throws ApiException {

        okhttp3.Call localVarCall = paymentScheduleItem_0ValidateBeforeCall(itemId, puTPaymentScheduleItemRequest, acceptEncoding, contentEncoding, authorization, zuoraTrackId, zuoraEntityIds, zuoraOrgIds, zuoraVersion, _callback);
        Type localVarReturnType = new TypeToken<PUTPaymentScheduleItemResponse>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    public class PaymentScheduleItem0RequestBuilder {
        private final String itemId;
        private String description;
        private Double amount;
        private String currency;
        private List<String> linkPayments;
        private String paymentGatewayId;
        private String paymentId;
        private String paymentMethodId;
        private List<PaymentSchedulePaymentOptionFields> paymentOption;
        private Integer runHour;
        private LocalDate scheduledDate;
        private List<String> unlinkPayments;
        private String acceptEncoding;
        private String contentEncoding;
        private String authorization;
        private String zuoraTrackId;
        private String zuoraEntityIds;
        private String zuoraOrgIds;
        private String zuoraVersion;
        private PUTPaymentScheduleItemRequest puTPaymentScheduleItemRequest;

        private PaymentScheduleItem0RequestBuilder(String itemId) {
            this.itemId = itemId;
        }

        /**
         * Set puTPaymentScheduleItemRequest
         * @param puTPaymentScheduleItemRequest  (optional)
         * @return PaymentScheduleItem0RequestBuilder
         */
        public PaymentScheduleItem0RequestBuilder puTPaymentScheduleItemRequest(PUTPaymentScheduleItemRequest puTPaymentScheduleItemRequest) {
            this.puTPaymentScheduleItemRequest = puTPaymentScheduleItemRequest;
            return this;
        }

        /**
         * Set description
         * @param description The description of the payment schedule item.  (optional)
         * @return PaymentScheduleItem0RequestBuilder
         */
        public PaymentScheduleItem0RequestBuilder description(String description) {
            this.description = description;
            return this;
        }
        
        /**
         * Set amount
         * @param amount The amount of the payment.  (optional)
         * @return PaymentScheduleItem0RequestBuilder
         */
        public PaymentScheduleItem0RequestBuilder amount(Double amount) {
            this.amount = amount;
            return this;
        }
        
        /**
         * Set currency
         * @param currency The currency of the payment.  (optional)
         * @return PaymentScheduleItem0RequestBuilder
         */
        public PaymentScheduleItem0RequestBuilder currency(String currency) {
            this.currency = currency;
            return this;
        }
        
        /**
         * Set linkPayments
         * @param linkPayments Container for payments linked to the payment schedule item.  (optional)
         * @return PaymentScheduleItem0RequestBuilder
         */
        public PaymentScheduleItem0RequestBuilder linkPayments(List<String> linkPayments) {
            this.linkPayments = linkPayments;
            return this;
        }
        
        /**
         * Set paymentGatewayId
         * @param paymentGatewayId ID of the payment gateway of the payment schedule item.  (optional)
         * @return PaymentScheduleItem0RequestBuilder
         */
        public PaymentScheduleItem0RequestBuilder paymentGatewayId(String paymentGatewayId) {
            this.paymentGatewayId = paymentGatewayId;
            return this;
        }
        
        /**
         * Set paymentId
         * @param paymentId ID of the payment to be linked to the payment schedule item.  **Note**: This feild is version controlled. To enable this field, you must set &#x60;zuora-version&#x60; to equal or smaller than &#x60;336.0&#x60;.  (optional)
         * @return PaymentScheduleItem0RequestBuilder
         */
        public PaymentScheduleItem0RequestBuilder paymentId(String paymentId) {
            this.paymentId = paymentId;
            return this;
        }
        
        /**
         * Set paymentMethodId
         * @param paymentMethodId ID of the payment method of the payment schedule item.  (optional)
         * @return PaymentScheduleItem0RequestBuilder
         */
        public PaymentScheduleItem0RequestBuilder paymentMethodId(String paymentMethodId) {
            this.paymentMethodId = paymentMethodId;
            return this;
        }
        
        /**
         * Set paymentOption
         * @param paymentOption Container for the paymentOption items, which describe the transactional level rules for processing payments. Currently, only the Gateway Options type is supported.  Here is an example: &#x60;&#x60;&#x60; \\\&quot;paymentOption\\\&quot;: [   {     \\\&quot;type\\\&quot;: \\\&quot;GatewayOptions\\\&quot;,     \\\&quot;detail\\\&quot;: {       \\\&quot;SecCode\\\&quot;:\\\&quot;WEB\\\&quot;     }   } ] &#x60;&#x60;&#x60;  &#x60;paymentOption&#x60; of the payment schedule takes precedence over &#x60;paymentOption&#x60; of the payment schedule item.  (optional)
         * @return PaymentScheduleItem0RequestBuilder
         */
        public PaymentScheduleItem0RequestBuilder paymentOption(List<PaymentSchedulePaymentOptionFields> paymentOption) {
            this.paymentOption = paymentOption;
            return this;
        }
        
        /**
         * Set runHour
         * @param runHour At which hour of the day in the tenant’s timezone this payment will be collected. If the payment &#x60;runHour&#x60; and &#x60;scheduledDate&#x60; are backdated, the system will collect the payment when the next runHour occurs.  (optional)
         * @return PaymentScheduleItem0RequestBuilder
         */
        public PaymentScheduleItem0RequestBuilder runHour(Integer runHour) {
            this.runHour = runHour;
            return this;
        }
        
        /**
         * Set scheduledDate
         * @param scheduledDate The scheduled date when the payment is processed.  (optional)
         * @return PaymentScheduleItem0RequestBuilder
         */
        public PaymentScheduleItem0RequestBuilder scheduledDate(LocalDate scheduledDate) {
            this.scheduledDate = scheduledDate;
            return this;
        }
        
        /**
         * Set unlinkPayments
         * @param unlinkPayments Container for payments to be unlinked from the payment schedule item.  (optional)
         * @return PaymentScheduleItem0RequestBuilder
         */
        public PaymentScheduleItem0RequestBuilder unlinkPayments(List<String> unlinkPayments) {
            this.unlinkPayments = unlinkPayments;
            return this;
        }
        
        /**
         * Set acceptEncoding
         * @param acceptEncoding Include the &#x60;Accept-Encoding: gzip&#x60; header to compress responses as a gzipped file. It can significantly reduce the bandwidth required for a response.   If specified, Zuora automatically compresses responses that contain over 1000 bytes of data, and the response contains a &#x60;Content-Encoding&#x60; header with the compression algorithm so that your client can decompress it.  (optional)
         * @return PaymentScheduleItem0RequestBuilder
         */
        public PaymentScheduleItem0RequestBuilder acceptEncoding(String acceptEncoding) {
            this.acceptEncoding = acceptEncoding;
            return this;
        }
        
        /**
         * Set contentEncoding
         * @param contentEncoding Include the &#x60;Content-Encoding: gzip&#x60; header to compress a request. With this header specified, you should upload a gzipped file for the request payload instead of sending the JSON payload.  (optional)
         * @return PaymentScheduleItem0RequestBuilder
         */
        public PaymentScheduleItem0RequestBuilder contentEncoding(String contentEncoding) {
            this.contentEncoding = contentEncoding;
            return this;
        }
        
        /**
         * Set authorization
         * @param authorization The value is in the &#x60;Bearer {token}&#x60; format where {token} is a valid OAuth token generated by calling [Create an OAuth token](https://developer.zuora.com/api-references/api/operation/createToken).  (optional)
         * @return PaymentScheduleItem0RequestBuilder
         */
        public PaymentScheduleItem0RequestBuilder authorization(String authorization) {
            this.authorization = authorization;
            return this;
        }
        
        /**
         * Set zuoraTrackId
         * @param zuoraTrackId A custom identifier for tracing the API call. If you set a value for this header, Zuora returns the same value in the response headers. This header enables you to associate your system process identifiers with Zuora API calls, to assist with troubleshooting in the event of an issue.  The value of this field must use the US-ASCII character set and must not include any of the following characters: colon (&#x60;:&#x60;), semicolon (&#x60;;&#x60;), double quote (&#x60;\&quot;&#x60;), and quote (&#x60;&#39;&#x60;).  (optional)
         * @return PaymentScheduleItem0RequestBuilder
         */
        public PaymentScheduleItem0RequestBuilder zuoraTrackId(String zuoraTrackId) {
            this.zuoraTrackId = zuoraTrackId;
            return this;
        }
        
        /**
         * Set zuoraEntityIds
         * @param zuoraEntityIds An entity ID. If you have [Zuora Multi-entity](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Multi-entity) enabled and the OAuth token is valid for more than one entity, you must use this header to specify which entity to perform the operation in. If the OAuth token is only valid for a single entity, or you do not have Zuora Multi-entity enabled, you do not need to set this header.  (optional)
         * @return PaymentScheduleItem0RequestBuilder
         */
        public PaymentScheduleItem0RequestBuilder zuoraEntityIds(String zuoraEntityIds) {
            this.zuoraEntityIds = zuoraEntityIds;
            return this;
        }
        
        /**
         * Set zuoraOrgIds
         * @param zuoraOrgIds Comma separated IDs. If you have &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Central_Platform/Multi-Org\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Zuora Multi-Org&lt;/a&gt; enabled,  you can use this header to specify which orgs to perform the operation in. If you do not have Zuora Multi-Org enabled, you should not set this header.  The IDs must be a sub-set of the user&#39;s accessible orgs. If you specify an org that the user does not have access to, the operation fails.  If the header is not set, the operation is performed in scope of the user&#39;s accessible orgs.  (optional)
         * @return PaymentScheduleItem0RequestBuilder
         */
        public PaymentScheduleItem0RequestBuilder zuoraOrgIds(String zuoraOrgIds) {
            this.zuoraOrgIds = zuoraOrgIds;
            return this;
        }
        
        /**
         * Set zuoraVersion
         * @param zuoraVersion The minor version of the Zuora REST API. See [Minor Version](https://developer.zuora.com/api-references/api/overview/#section/API-Versions/Minor-Version) for information about REST API version control.   This header affects the availability of the following request fields: * &#x60;paymentId&#x60; * &#x60;linkPayments&#x60; * &#x60;unlinkPayments&#x60;  This header affects the availability of the following response fields: * &#x60;paymentId&#x60;              (optional)
         * @return PaymentScheduleItem0RequestBuilder
         */
        public PaymentScheduleItem0RequestBuilder zuoraVersion(String zuoraVersion) {
            this.zuoraVersion = zuoraVersion;
            return this;
        }
        
        /**
         * Build call for paymentScheduleItem_0
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
            PUTPaymentScheduleItemRequest puTPaymentScheduleItemRequest = buildBodyParams();
            return paymentScheduleItem_0Call(itemId, puTPaymentScheduleItemRequest, acceptEncoding, contentEncoding, authorization, zuoraTrackId, zuoraEntityIds, zuoraOrgIds, zuoraVersion, _callback);
        }

        private PUTPaymentScheduleItemRequest buildBodyParams() {
            return this.puTPaymentScheduleItemRequest;
        }

        /**
         * Execute paymentScheduleItem_0 request
         * @return PUTPaymentScheduleItemResponse
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td>  </td><td>  * Content-Encoding - This header is returned if you specify the &#x60;Accept-Encoding: gzip&#x60; request header and the response contains over 1000 bytes of data. Note that only the following MIME types support gzipped responses:   - &#x60;application/json&#x60;   - &#x60;application/xml&#x60;   - &#x60;text/html&#x60;   - &#x60;text/csv&#x60;   - &#x60;text/plain&#x60;  <br>  * RateLimit-Limit - The request limit quota for the time window closest to exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Remaining - The number of requests remaining in the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Reset - The number of seconds until the quota resets for the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Zuora-Request-Id - The Zuora internal identifier of the API call. You cannot control the value of this header.  <br>  * Zuora-Track-Id - A custom identifier for tracing the API call. If you specified a tracing identifier in the request headers, Zuora returns the same tracing identifier. Otherwise, Zuora does not set this header.  <br>  </td></tr>
         </table>
         */
        public PUTPaymentScheduleItemResponse execute() throws ApiException {
            PUTPaymentScheduleItemRequest puTPaymentScheduleItemRequest = buildBodyParams();
            ApiResponse<PUTPaymentScheduleItemResponse> localVarResp = paymentScheduleItem_0WithHttpInfo(itemId, puTPaymentScheduleItemRequest, acceptEncoding, contentEncoding, authorization, zuoraTrackId, zuoraEntityIds, zuoraOrgIds, zuoraVersion);
            return localVarResp.getResponseBody();
        }

        /**
         * Execute paymentScheduleItem_0 request with HTTP info returned
         * @return ApiResponse&lt;PUTPaymentScheduleItemResponse&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td>  </td><td>  * Content-Encoding - This header is returned if you specify the &#x60;Accept-Encoding: gzip&#x60; request header and the response contains over 1000 bytes of data. Note that only the following MIME types support gzipped responses:   - &#x60;application/json&#x60;   - &#x60;application/xml&#x60;   - &#x60;text/html&#x60;   - &#x60;text/csv&#x60;   - &#x60;text/plain&#x60;  <br>  * RateLimit-Limit - The request limit quota for the time window closest to exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Remaining - The number of requests remaining in the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Reset - The number of seconds until the quota resets for the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Zuora-Request-Id - The Zuora internal identifier of the API call. You cannot control the value of this header.  <br>  * Zuora-Track-Id - A custom identifier for tracing the API call. If you specified a tracing identifier in the request headers, Zuora returns the same tracing identifier. Otherwise, Zuora does not set this header.  <br>  </td></tr>
         </table>
         */
        public ApiResponse<PUTPaymentScheduleItemResponse> executeWithHttpInfo() throws ApiException {
            PUTPaymentScheduleItemRequest puTPaymentScheduleItemRequest = buildBodyParams();
            return paymentScheduleItem_0WithHttpInfo(itemId, puTPaymentScheduleItemRequest, acceptEncoding, contentEncoding, authorization, zuoraTrackId, zuoraEntityIds, zuoraOrgIds, zuoraVersion);
        }

        /**
         * Execute paymentScheduleItem_0 request (asynchronously)
         * @param _callback The callback to be executed when the API call finishes
         * @return The request call
         * @throws ApiException If fail to process the API call, e.g. serializing the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td>  </td><td>  * Content-Encoding - This header is returned if you specify the &#x60;Accept-Encoding: gzip&#x60; request header and the response contains over 1000 bytes of data. Note that only the following MIME types support gzipped responses:   - &#x60;application/json&#x60;   - &#x60;application/xml&#x60;   - &#x60;text/html&#x60;   - &#x60;text/csv&#x60;   - &#x60;text/plain&#x60;  <br>  * RateLimit-Limit - The request limit quota for the time window closest to exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Remaining - The number of requests remaining in the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Reset - The number of seconds until the quota resets for the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Zuora-Request-Id - The Zuora internal identifier of the API call. You cannot control the value of this header.  <br>  * Zuora-Track-Id - A custom identifier for tracing the API call. If you specified a tracing identifier in the request headers, Zuora returns the same tracing identifier. Otherwise, Zuora does not set this header.  <br>  </td></tr>
         </table>
         */
        public okhttp3.Call executeAsync(final ApiCallback<PUTPaymentScheduleItemResponse> _callback) throws ApiException {
            PUTPaymentScheduleItemRequest puTPaymentScheduleItemRequest = buildBodyParams();
            return paymentScheduleItem_0Async(itemId, puTPaymentScheduleItemRequest, acceptEncoding, contentEncoding, authorization, zuoraTrackId, zuoraEntityIds, zuoraOrgIds, zuoraVersion, _callback);
        }
    }

    /**
     * Update a payment schedule item
     * Updates a payment schedule item by ID.  **Note:** - The Payment Schedules feature is in the **Early Adopter** phase. We are actively soliciting feedback from a small set of early adopters before releasing it as generally available. To manag](https://knowledgecenter.zuora.com/Zuora_Payments/Payments_Settings/Manage_Features). - This operation is only available if you have [Invoice Settlement](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/Invoice_Settlement) enabled. - To link a single payment to the payment schedule item, specify the &#x60;paymentID&#x60; field in the request body and set &#x60;zuora-version&#x60; to equal to or smaller than &#x60;336.0&#x60;; To link or unlink multiple payments with the item, specify the &#x60;linkPayments&#x60; and &#x60;unlinkPayments&#x60; field in the request body.  - The maximum number of payments that are allowed to be linked to a payment schedule item is &#x60;10&#x60;. - When unlinking and linking payments with the payment schedule item in one request, Zuora will first unlink the linked payments, and then link new payments to the item. 
     * @param itemId The unique ID of a payment schedule item.  (required)
     * @param puTPaymentScheduleItemRequest  (required)
     * @return PaymentScheduleItem0RequestBuilder
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td>  </td><td>  * Content-Encoding - This header is returned if you specify the &#x60;Accept-Encoding: gzip&#x60; request header and the response contains over 1000 bytes of data. Note that only the following MIME types support gzipped responses:   - &#x60;application/json&#x60;   - &#x60;application/xml&#x60;   - &#x60;text/html&#x60;   - &#x60;text/csv&#x60;   - &#x60;text/plain&#x60;  <br>  * RateLimit-Limit - The request limit quota for the time window closest to exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Remaining - The number of requests remaining in the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Reset - The number of seconds until the quota resets for the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Zuora-Request-Id - The Zuora internal identifier of the API call. You cannot control the value of this header.  <br>  * Zuora-Track-Id - A custom identifier for tracing the API call. If you specified a tracing identifier in the request headers, Zuora returns the same tracing identifier. Otherwise, Zuora does not set this header.  <br>  </td></tr>
     </table>
     */
    public PaymentScheduleItem0RequestBuilder paymentScheduleItem_0(String itemId) throws IllegalArgumentException {
        if (itemId == null) throw new IllegalArgumentException("\"itemId\" is required but got null");
            

        return new PaymentScheduleItem0RequestBuilder(itemId);
    }
    private okhttp3.Call paymentScheduleStatisticCall(LocalDate yyyyMmDd, String acceptEncoding, String contentEncoding, String authorization, String zuoraTrackId, String zuoraEntityIds, String zuoraOrgIds, final ApiCallback _callback) throws ApiException {
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
        String localVarPath = "/v1/payment-schedules/statistics/{yyyy-mm-dd}"
            .replace("{" + "yyyy-mm-dd" + "}", localVarApiClient.escapeString(yyyyMmDd.toString()));

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
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        if (localVarContentType != null) {
            localVarHeaderParams.put("Content-Type", localVarContentType);
        }

        String[] localVarAuthNames = new String[] {  };
        return localVarApiClient.buildCall(basePath, localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call paymentScheduleStatisticValidateBeforeCall(LocalDate yyyyMmDd, String acceptEncoding, String contentEncoding, String authorization, String zuoraTrackId, String zuoraEntityIds, String zuoraOrgIds, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'yyyyMmDd' is set
        if (yyyyMmDd == null) {
            throw new ApiException("Missing the required parameter 'yyyyMmDd' when calling paymentScheduleStatistic(Async)");
        }

        return paymentScheduleStatisticCall(yyyyMmDd, acceptEncoding, contentEncoding, authorization, zuoraTrackId, zuoraEntityIds, zuoraOrgIds, _callback);

    }


    private ApiResponse<GETPaymentScheduleStatisticResponse> paymentScheduleStatisticWithHttpInfo(LocalDate yyyyMmDd, String acceptEncoding, String contentEncoding, String authorization, String zuoraTrackId, String zuoraEntityIds, String zuoraOrgIds) throws ApiException {
        okhttp3.Call localVarCall = paymentScheduleStatisticValidateBeforeCall(yyyyMmDd, acceptEncoding, contentEncoding, authorization, zuoraTrackId, zuoraEntityIds, zuoraOrgIds, null);
        Type localVarReturnType = new TypeToken<GETPaymentScheduleStatisticResponse>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    private okhttp3.Call paymentScheduleStatisticAsync(LocalDate yyyyMmDd, String acceptEncoding, String contentEncoding, String authorization, String zuoraTrackId, String zuoraEntityIds, String zuoraOrgIds, final ApiCallback<GETPaymentScheduleStatisticResponse> _callback) throws ApiException {

        okhttp3.Call localVarCall = paymentScheduleStatisticValidateBeforeCall(yyyyMmDd, acceptEncoding, contentEncoding, authorization, zuoraTrackId, zuoraEntityIds, zuoraOrgIds, _callback);
        Type localVarReturnType = new TypeToken<GETPaymentScheduleStatisticResponse>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    public class PaymentScheduleStatisticRequestBuilder {
        private final LocalDate yyyyMmDd;
        private String acceptEncoding;
        private String contentEncoding;
        private String authorization;
        private String zuoraTrackId;
        private String zuoraEntityIds;
        private String zuoraOrgIds;

        private PaymentScheduleStatisticRequestBuilder(LocalDate yyyyMmDd) {
            this.yyyyMmDd = yyyyMmDd;
        }

        /**
         * Set acceptEncoding
         * @param acceptEncoding Include the &#x60;Accept-Encoding: gzip&#x60; header to compress responses as a gzipped file. It can significantly reduce the bandwidth required for a response.   If specified, Zuora automatically compresses responses that contain over 1000 bytes of data, and the response contains a &#x60;Content-Encoding&#x60; header with the compression algorithm so that your client can decompress it.  (optional)
         * @return PaymentScheduleStatisticRequestBuilder
         */
        public PaymentScheduleStatisticRequestBuilder acceptEncoding(String acceptEncoding) {
            this.acceptEncoding = acceptEncoding;
            return this;
        }
        
        /**
         * Set contentEncoding
         * @param contentEncoding Include the &#x60;Content-Encoding: gzip&#x60; header to compress a request. With this header specified, you should upload a gzipped file for the request payload instead of sending the JSON payload.  (optional)
         * @return PaymentScheduleStatisticRequestBuilder
         */
        public PaymentScheduleStatisticRequestBuilder contentEncoding(String contentEncoding) {
            this.contentEncoding = contentEncoding;
            return this;
        }
        
        /**
         * Set authorization
         * @param authorization The value is in the &#x60;Bearer {token}&#x60; format where {token} is a valid OAuth token generated by calling [Create an OAuth token](https://developer.zuora.com/api-references/api/operation/createToken).  (optional)
         * @return PaymentScheduleStatisticRequestBuilder
         */
        public PaymentScheduleStatisticRequestBuilder authorization(String authorization) {
            this.authorization = authorization;
            return this;
        }
        
        /**
         * Set zuoraTrackId
         * @param zuoraTrackId A custom identifier for tracing the API call. If you set a value for this header, Zuora returns the same value in the response headers. This header enables you to associate your system process identifiers with Zuora API calls, to assist with troubleshooting in the event of an issue.  The value of this field must use the US-ASCII character set and must not include any of the following characters: colon (&#x60;:&#x60;), semicolon (&#x60;;&#x60;), double quote (&#x60;\&quot;&#x60;), and quote (&#x60;&#39;&#x60;).  (optional)
         * @return PaymentScheduleStatisticRequestBuilder
         */
        public PaymentScheduleStatisticRequestBuilder zuoraTrackId(String zuoraTrackId) {
            this.zuoraTrackId = zuoraTrackId;
            return this;
        }
        
        /**
         * Set zuoraEntityIds
         * @param zuoraEntityIds An entity ID. If you have [Zuora Multi-entity](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Multi-entity) enabled and the OAuth token is valid for more than one entity, you must use this header to specify which entity to perform the operation in. If the OAuth token is only valid for a single entity, or you do not have Zuora Multi-entity enabled, you do not need to set this header.  (optional)
         * @return PaymentScheduleStatisticRequestBuilder
         */
        public PaymentScheduleStatisticRequestBuilder zuoraEntityIds(String zuoraEntityIds) {
            this.zuoraEntityIds = zuoraEntityIds;
            return this;
        }
        
        /**
         * Set zuoraOrgIds
         * @param zuoraOrgIds Comma separated IDs. If you have &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Central_Platform/Multi-Org\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Zuora Multi-Org&lt;/a&gt; enabled,  you can use this header to specify which orgs to perform the operation in. If you do not have Zuora Multi-Org enabled, you should not set this header.  The IDs must be a sub-set of the user&#39;s accessible orgs. If you specify an org that the user does not have access to, the operation fails.  If the header is not set, the operation is performed in scope of the user&#39;s accessible orgs.  (optional)
         * @return PaymentScheduleStatisticRequestBuilder
         */
        public PaymentScheduleStatisticRequestBuilder zuoraOrgIds(String zuoraOrgIds) {
            this.zuoraOrgIds = zuoraOrgIds;
            return this;
        }
        
        /**
         * Build call for paymentScheduleStatistic
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
            return paymentScheduleStatisticCall(yyyyMmDd, acceptEncoding, contentEncoding, authorization, zuoraTrackId, zuoraEntityIds, zuoraOrgIds, _callback);
        }


        /**
         * Execute paymentScheduleStatistic request
         * @return GETPaymentScheduleStatisticResponse
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td>  </td><td>  * Content-Encoding - This header is returned if you specify the &#x60;Accept-Encoding: gzip&#x60; request header and the response contains over 1000 bytes of data. Note that only the following MIME types support gzipped responses:   - &#x60;application/json&#x60;   - &#x60;application/xml&#x60;   - &#x60;text/html&#x60;   - &#x60;text/csv&#x60;   - &#x60;text/plain&#x60;  <br>  * RateLimit-Limit - The request limit quota for the time window closest to exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Remaining - The number of requests remaining in the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Reset - The number of seconds until the quota resets for the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Zuora-Request-Id - The Zuora internal identifier of the API call. You cannot control the value of this header.  <br>  * Zuora-Track-Id - A custom identifier for tracing the API call. If you specified a tracing identifier in the request headers, Zuora returns the same tracing identifier. Otherwise, Zuora does not set this header.  <br>  </td></tr>
         </table>
         */
        public GETPaymentScheduleStatisticResponse execute() throws ApiException {
            ApiResponse<GETPaymentScheduleStatisticResponse> localVarResp = paymentScheduleStatisticWithHttpInfo(yyyyMmDd, acceptEncoding, contentEncoding, authorization, zuoraTrackId, zuoraEntityIds, zuoraOrgIds);
            return localVarResp.getResponseBody();
        }

        /**
         * Execute paymentScheduleStatistic request with HTTP info returned
         * @return ApiResponse&lt;GETPaymentScheduleStatisticResponse&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td>  </td><td>  * Content-Encoding - This header is returned if you specify the &#x60;Accept-Encoding: gzip&#x60; request header and the response contains over 1000 bytes of data. Note that only the following MIME types support gzipped responses:   - &#x60;application/json&#x60;   - &#x60;application/xml&#x60;   - &#x60;text/html&#x60;   - &#x60;text/csv&#x60;   - &#x60;text/plain&#x60;  <br>  * RateLimit-Limit - The request limit quota for the time window closest to exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Remaining - The number of requests remaining in the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Reset - The number of seconds until the quota resets for the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Zuora-Request-Id - The Zuora internal identifier of the API call. You cannot control the value of this header.  <br>  * Zuora-Track-Id - A custom identifier for tracing the API call. If you specified a tracing identifier in the request headers, Zuora returns the same tracing identifier. Otherwise, Zuora does not set this header.  <br>  </td></tr>
         </table>
         */
        public ApiResponse<GETPaymentScheduleStatisticResponse> executeWithHttpInfo() throws ApiException {
            return paymentScheduleStatisticWithHttpInfo(yyyyMmDd, acceptEncoding, contentEncoding, authorization, zuoraTrackId, zuoraEntityIds, zuoraOrgIds);
        }

        /**
         * Execute paymentScheduleStatistic request (asynchronously)
         * @param _callback The callback to be executed when the API call finishes
         * @return The request call
         * @throws ApiException If fail to process the API call, e.g. serializing the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td>  </td><td>  * Content-Encoding - This header is returned if you specify the &#x60;Accept-Encoding: gzip&#x60; request header and the response contains over 1000 bytes of data. Note that only the following MIME types support gzipped responses:   - &#x60;application/json&#x60;   - &#x60;application/xml&#x60;   - &#x60;text/html&#x60;   - &#x60;text/csv&#x60;   - &#x60;text/plain&#x60;  <br>  * RateLimit-Limit - The request limit quota for the time window closest to exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Remaining - The number of requests remaining in the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Reset - The number of seconds until the quota resets for the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Zuora-Request-Id - The Zuora internal identifier of the API call. You cannot control the value of this header.  <br>  * Zuora-Track-Id - A custom identifier for tracing the API call. If you specified a tracing identifier in the request headers, Zuora returns the same tracing identifier. Otherwise, Zuora does not set this header.  <br>  </td></tr>
         </table>
         */
        public okhttp3.Call executeAsync(final ApiCallback<GETPaymentScheduleStatisticResponse> _callback) throws ApiException {
            return paymentScheduleStatisticAsync(yyyyMmDd, acceptEncoding, contentEncoding, authorization, zuoraTrackId, zuoraEntityIds, zuoraOrgIds, _callback);
        }
    }

    /**
     * Retrieve payment schedule statistic of a date
     * Retrieves the payment schedule statistic of a specific date.  **Note:** - The Payment Schedules feature is in the **Early Adopter** phase. We are actively soliciting feedback from a small set of early adopters before releasing it as generally available. To manage and access this feature through the self-service interface, see [Manage Features](https://knowledgecenter.zuora.com/Zuora_Payments/Payments_Settings/Manage_Features) in the Knowledge Center. 
     * @param yyyyMmDd Specifies the date of the payment schedule statistic you want to view.   (required)
     * @return PaymentScheduleStatisticRequestBuilder
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td>  </td><td>  * Content-Encoding - This header is returned if you specify the &#x60;Accept-Encoding: gzip&#x60; request header and the response contains over 1000 bytes of data. Note that only the following MIME types support gzipped responses:   - &#x60;application/json&#x60;   - &#x60;application/xml&#x60;   - &#x60;text/html&#x60;   - &#x60;text/csv&#x60;   - &#x60;text/plain&#x60;  <br>  * RateLimit-Limit - The request limit quota for the time window closest to exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Remaining - The number of requests remaining in the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Reset - The number of seconds until the quota resets for the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Zuora-Request-Id - The Zuora internal identifier of the API call. You cannot control the value of this header.  <br>  * Zuora-Track-Id - A custom identifier for tracing the API call. If you specified a tracing identifier in the request headers, Zuora returns the same tracing identifier. Otherwise, Zuora does not set this header.  <br>  </td></tr>
     </table>
     */
    public PaymentScheduleStatisticRequestBuilder paymentScheduleStatistic(LocalDate yyyyMmDd) throws IllegalArgumentException {
        if (yyyyMmDd == null) throw new IllegalArgumentException("\"yyyyMmDd\" is required but got null");
        return new PaymentScheduleStatisticRequestBuilder(yyyyMmDd);
    }
    private okhttp3.Call paymentScheduleUpdatePreviewCall(String paymentScheduleKey, PUTPreviewPaymentScheduleRequest puTPreviewPaymentScheduleRequest, String acceptEncoding, String contentEncoding, String authorization, String zuoraTrackId, String zuoraEntityIds, String zuoraOrgIds, String zuoraVersion, final ApiCallback _callback) throws ApiException {
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

        Object localVarPostBody = puTPreviewPaymentScheduleRequest;

        // create path and map variables
        String localVarPath = "/v1/payment-schedules/{paymentScheduleKey}/preview"
            .replace("{" + "paymentScheduleKey" + "}", localVarApiClient.escapeString(paymentScheduleKey.toString()));

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

        if (zuoraVersion != null) {
            localVarHeaderParams.put("zuora-version", localVarApiClient.parameterToString(zuoraVersion));
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
    private okhttp3.Call paymentScheduleUpdatePreviewValidateBeforeCall(String paymentScheduleKey, PUTPreviewPaymentScheduleRequest puTPreviewPaymentScheduleRequest, String acceptEncoding, String contentEncoding, String authorization, String zuoraTrackId, String zuoraEntityIds, String zuoraOrgIds, String zuoraVersion, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'paymentScheduleKey' is set
        if (paymentScheduleKey == null) {
            throw new ApiException("Missing the required parameter 'paymentScheduleKey' when calling paymentScheduleUpdatePreview(Async)");
        }

        // verify the required parameter 'puTPreviewPaymentScheduleRequest' is set
        if (puTPreviewPaymentScheduleRequest == null) {
            throw new ApiException("Missing the required parameter 'puTPreviewPaymentScheduleRequest' when calling paymentScheduleUpdatePreview(Async)");
        }

        return paymentScheduleUpdatePreviewCall(paymentScheduleKey, puTPreviewPaymentScheduleRequest, acceptEncoding, contentEncoding, authorization, zuoraTrackId, zuoraEntityIds, zuoraOrgIds, zuoraVersion, _callback);

    }


    private ApiResponse<GETPaymentScheduleResponse> paymentScheduleUpdatePreviewWithHttpInfo(String paymentScheduleKey, PUTPreviewPaymentScheduleRequest puTPreviewPaymentScheduleRequest, String acceptEncoding, String contentEncoding, String authorization, String zuoraTrackId, String zuoraEntityIds, String zuoraOrgIds, String zuoraVersion) throws ApiException {
        okhttp3.Call localVarCall = paymentScheduleUpdatePreviewValidateBeforeCall(paymentScheduleKey, puTPreviewPaymentScheduleRequest, acceptEncoding, contentEncoding, authorization, zuoraTrackId, zuoraEntityIds, zuoraOrgIds, zuoraVersion, null);
        Type localVarReturnType = new TypeToken<GETPaymentScheduleResponse>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    private okhttp3.Call paymentScheduleUpdatePreviewAsync(String paymentScheduleKey, PUTPreviewPaymentScheduleRequest puTPreviewPaymentScheduleRequest, String acceptEncoding, String contentEncoding, String authorization, String zuoraTrackId, String zuoraEntityIds, String zuoraOrgIds, String zuoraVersion, final ApiCallback<GETPaymentScheduleResponse> _callback) throws ApiException {

        okhttp3.Call localVarCall = paymentScheduleUpdatePreviewValidateBeforeCall(paymentScheduleKey, puTPreviewPaymentScheduleRequest, acceptEncoding, contentEncoding, authorization, zuoraTrackId, zuoraEntityIds, zuoraOrgIds, zuoraVersion, _callback);
        Type localVarReturnType = new TypeToken<GETPaymentScheduleResponse>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    public class PaymentScheduleUpdatePreviewRequestBuilder {
        private final String paymentScheduleKey;
        private Double amount;
        private String currency;
        private Integer occurrences;
        private String paymentGatewayId;
        private String paymentMethodId;
        private List<PaymentSchedulePaymentOptionFields> paymentOption;
        private String period;
        private LocalDate periodStartDate;
        private Integer runHour;
        private String acceptEncoding;
        private String contentEncoding;
        private String authorization;
        private String zuoraTrackId;
        private String zuoraEntityIds;
        private String zuoraOrgIds;
        private String zuoraVersion;
        private PUTPreviewPaymentScheduleRequest puTPreviewPaymentScheduleRequest;

        private PaymentScheduleUpdatePreviewRequestBuilder(String paymentScheduleKey) {
            this.paymentScheduleKey = paymentScheduleKey;
        }

        /**
         * Set puTPreviewPaymentScheduleRequest
         * @param puTPreviewPaymentScheduleRequest  (optional)
         * @return PaymentScheduleUpdatePreviewRequestBuilder
         */
        public PaymentScheduleUpdatePreviewRequestBuilder puTPreviewPaymentScheduleRequest(PUTPreviewPaymentScheduleRequest puTPreviewPaymentScheduleRequest) {
            this.puTPreviewPaymentScheduleRequest = puTPreviewPaymentScheduleRequest;
            return this;
        }

        /**
         * Set amount
         * @param amount Indicates the updated amount of the pending payment schedule items.  (optional)
         * @return PaymentScheduleUpdatePreviewRequestBuilder
         */
        public PaymentScheduleUpdatePreviewRequestBuilder amount(Double amount) {
            this.amount = amount;
            return this;
        }
        
        /**
         * Set currency
         * @param currency Indicates the updated currency of the pending payment schedule items.        (optional)
         * @return PaymentScheduleUpdatePreviewRequestBuilder
         */
        public PaymentScheduleUpdatePreviewRequestBuilder currency(String currency) {
            this.currency = currency;
            return this;
        }
        
        /**
         * Set occurrences
         * @param occurrences Indicates the updated number of payment schedule items that are created by the payment schedule.  (optional)
         * @return PaymentScheduleUpdatePreviewRequestBuilder
         */
        public PaymentScheduleUpdatePreviewRequestBuilder occurrences(Integer occurrences) {
            this.occurrences = occurrences;
            return this;
        }
        
        /**
         * Set paymentGatewayId
         * @param paymentGatewayId Indicates the updated payment gateway ID of the pending payment schedule items.  (optional)
         * @return PaymentScheduleUpdatePreviewRequestBuilder
         */
        public PaymentScheduleUpdatePreviewRequestBuilder paymentGatewayId(String paymentGatewayId) {
            this.paymentGatewayId = paymentGatewayId;
            return this;
        }
        
        /**
         * Set paymentMethodId
         * @param paymentMethodId Indicates the updated payment method ID of the pending payment schedule items.   (optional)
         * @return PaymentScheduleUpdatePreviewRequestBuilder
         */
        public PaymentScheduleUpdatePreviewRequestBuilder paymentMethodId(String paymentMethodId) {
            this.paymentMethodId = paymentMethodId;
            return this;
        }
        
        /**
         * Set paymentOption
         * @param paymentOption Container for the paymentOption items, which describe the transactional level rules for processing payments. Currently, only the Gateway Options type is supported.  Here is an example: &#x60;&#x60;&#x60; \\\&quot;paymentOption\\\&quot;: [   {     \\\&quot;type\\\&quot;: \\\&quot;GatewayOptions\\\&quot;,     \\\&quot;detail\\\&quot;: {       \\\&quot;SecCode\\\&quot;:\\\&quot;WEB\\\&quot;     }   } ] &#x60;&#x60;&#x60;  &#x60;paymentOption&#x60; of the payment schedule takes precedence over &#x60;paymentOption&#x60; of the payment schedule item.  (optional)
         * @return PaymentScheduleUpdatePreviewRequestBuilder
         */
        public PaymentScheduleUpdatePreviewRequestBuilder paymentOption(List<PaymentSchedulePaymentOptionFields> paymentOption) {
            this.paymentOption = paymentOption;
            return this;
        }
        
        /**
         * Set period
         * @param period Indicates the updated period of the pending payment schedule items.  (optional)
         * @return PaymentScheduleUpdatePreviewRequestBuilder
         */
        public PaymentScheduleUpdatePreviewRequestBuilder period(String period) {
            this.period = period;
            return this;
        }
        
        /**
         * Set periodStartDate
         * @param periodStartDate Indicates the updated collection date for the next pending payment schedule item.  (optional)
         * @return PaymentScheduleUpdatePreviewRequestBuilder
         */
        public PaymentScheduleUpdatePreviewRequestBuilder periodStartDate(LocalDate periodStartDate) {
            this.periodStartDate = periodStartDate;
            return this;
        }
        
        /**
         * Set runHour
         * @param runHour Specifies at which hour of the day in the tenant’s time zone this payment will be collected. Available values: &#x60;[0,1,2,~,22,23]&#x60;.    If the time difference between your tenant’s timezone and the timezone where Zuora servers are is not in full hours, for example, 2.5 hours, the payment schedule items will be triggered half hour later than your scheduled time. If the payment &#x60;runHour&#x60; and &#x60;scheduledDate&#x60; are backdated, the system will collect the payment when the next runHour occurs.  (optional)
         * @return PaymentScheduleUpdatePreviewRequestBuilder
         */
        public PaymentScheduleUpdatePreviewRequestBuilder runHour(Integer runHour) {
            this.runHour = runHour;
            return this;
        }
        
        /**
         * Set acceptEncoding
         * @param acceptEncoding Include the &#x60;Accept-Encoding: gzip&#x60; header to compress responses as a gzipped file. It can significantly reduce the bandwidth required for a response.   If specified, Zuora automatically compresses responses that contain over 1000 bytes of data, and the response contains a &#x60;Content-Encoding&#x60; header with the compression algorithm so that your client can decompress it.  (optional)
         * @return PaymentScheduleUpdatePreviewRequestBuilder
         */
        public PaymentScheduleUpdatePreviewRequestBuilder acceptEncoding(String acceptEncoding) {
            this.acceptEncoding = acceptEncoding;
            return this;
        }
        
        /**
         * Set contentEncoding
         * @param contentEncoding Include the &#x60;Content-Encoding: gzip&#x60; header to compress a request. With this header specified, you should upload a gzipped file for the request payload instead of sending the JSON payload.  (optional)
         * @return PaymentScheduleUpdatePreviewRequestBuilder
         */
        public PaymentScheduleUpdatePreviewRequestBuilder contentEncoding(String contentEncoding) {
            this.contentEncoding = contentEncoding;
            return this;
        }
        
        /**
         * Set authorization
         * @param authorization The value is in the &#x60;Bearer {token}&#x60; format where {token} is a valid OAuth token generated by calling [Create an OAuth token](https://developer.zuora.com/api-references/api/operation/createToken).  (optional)
         * @return PaymentScheduleUpdatePreviewRequestBuilder
         */
        public PaymentScheduleUpdatePreviewRequestBuilder authorization(String authorization) {
            this.authorization = authorization;
            return this;
        }
        
        /**
         * Set zuoraTrackId
         * @param zuoraTrackId A custom identifier for tracing the API call. If you set a value for this header, Zuora returns the same value in the response headers. This header enables you to associate your system process identifiers with Zuora API calls, to assist with troubleshooting in the event of an issue.  The value of this field must use the US-ASCII character set and must not include any of the following characters: colon (&#x60;:&#x60;), semicolon (&#x60;;&#x60;), double quote (&#x60;\&quot;&#x60;), and quote (&#x60;&#39;&#x60;).  (optional)
         * @return PaymentScheduleUpdatePreviewRequestBuilder
         */
        public PaymentScheduleUpdatePreviewRequestBuilder zuoraTrackId(String zuoraTrackId) {
            this.zuoraTrackId = zuoraTrackId;
            return this;
        }
        
        /**
         * Set zuoraEntityIds
         * @param zuoraEntityIds An entity ID. If you have [Zuora Multi-entity](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Multi-entity) enabled and the OAuth token is valid for more than one entity, you must use this header to specify which entity to perform the operation in. If the OAuth token is only valid for a single entity, or you do not have Zuora Multi-entity enabled, you do not need to set this header.  (optional)
         * @return PaymentScheduleUpdatePreviewRequestBuilder
         */
        public PaymentScheduleUpdatePreviewRequestBuilder zuoraEntityIds(String zuoraEntityIds) {
            this.zuoraEntityIds = zuoraEntityIds;
            return this;
        }
        
        /**
         * Set zuoraOrgIds
         * @param zuoraOrgIds Comma separated IDs. If you have &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Central_Platform/Multi-Org\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Zuora Multi-Org&lt;/a&gt; enabled,  you can use this header to specify which orgs to perform the operation in. If you do not have Zuora Multi-Org enabled, you should not set this header.  The IDs must be a sub-set of the user&#39;s accessible orgs. If you specify an org that the user does not have access to, the operation fails.  If the header is not set, the operation is performed in scope of the user&#39;s accessible orgs.  (optional)
         * @return PaymentScheduleUpdatePreviewRequestBuilder
         */
        public PaymentScheduleUpdatePreviewRequestBuilder zuoraOrgIds(String zuoraOrgIds) {
            this.zuoraOrgIds = zuoraOrgIds;
            return this;
        }
        
        /**
         * Set zuoraVersion
         * @param zuoraVersion The minor version of the Zuora REST API. See [Minor Version](https://developer.zuora.com/api-references/api/overview/#section/API-Versions/Minor-Version) for information about REST API version control.   This header affects the availability of the following fields: - &#x60;items&#x60; &gt; &#x60;paymentId&#x60;  (optional)
         * @return PaymentScheduleUpdatePreviewRequestBuilder
         */
        public PaymentScheduleUpdatePreviewRequestBuilder zuoraVersion(String zuoraVersion) {
            this.zuoraVersion = zuoraVersion;
            return this;
        }
        
        /**
         * Build call for paymentScheduleUpdatePreview
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
            PUTPreviewPaymentScheduleRequest puTPreviewPaymentScheduleRequest = buildBodyParams();
            return paymentScheduleUpdatePreviewCall(paymentScheduleKey, puTPreviewPaymentScheduleRequest, acceptEncoding, contentEncoding, authorization, zuoraTrackId, zuoraEntityIds, zuoraOrgIds, zuoraVersion, _callback);
        }

        private PUTPreviewPaymentScheduleRequest buildBodyParams() {
            return this.puTPreviewPaymentScheduleRequest;
        }

        /**
         * Execute paymentScheduleUpdatePreview request
         * @return GETPaymentScheduleResponse
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td>  </td><td>  * Content-Encoding - This header is returned if you specify the &#x60;Accept-Encoding: gzip&#x60; request header and the response contains over 1000 bytes of data. Note that only the following MIME types support gzipped responses:   - &#x60;application/json&#x60;   - &#x60;application/xml&#x60;   - &#x60;text/html&#x60;   - &#x60;text/csv&#x60;   - &#x60;text/plain&#x60;  <br>  * RateLimit-Limit - The request limit quota for the time window closest to exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Remaining - The number of requests remaining in the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Reset - The number of seconds until the quota resets for the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Zuora-Request-Id - The Zuora internal identifier of the API call. You cannot control the value of this header.  <br>  * Zuora-Track-Id - A custom identifier for tracing the API call. If you specified a tracing identifier in the request headers, Zuora returns the same tracing identifier. Otherwise, Zuora does not set this header.  <br>  </td></tr>
         </table>
         */
        public GETPaymentScheduleResponse execute() throws ApiException {
            PUTPreviewPaymentScheduleRequest puTPreviewPaymentScheduleRequest = buildBodyParams();
            ApiResponse<GETPaymentScheduleResponse> localVarResp = paymentScheduleUpdatePreviewWithHttpInfo(paymentScheduleKey, puTPreviewPaymentScheduleRequest, acceptEncoding, contentEncoding, authorization, zuoraTrackId, zuoraEntityIds, zuoraOrgIds, zuoraVersion);
            return localVarResp.getResponseBody();
        }

        /**
         * Execute paymentScheduleUpdatePreview request with HTTP info returned
         * @return ApiResponse&lt;GETPaymentScheduleResponse&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td>  </td><td>  * Content-Encoding - This header is returned if you specify the &#x60;Accept-Encoding: gzip&#x60; request header and the response contains over 1000 bytes of data. Note that only the following MIME types support gzipped responses:   - &#x60;application/json&#x60;   - &#x60;application/xml&#x60;   - &#x60;text/html&#x60;   - &#x60;text/csv&#x60;   - &#x60;text/plain&#x60;  <br>  * RateLimit-Limit - The request limit quota for the time window closest to exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Remaining - The number of requests remaining in the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Reset - The number of seconds until the quota resets for the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Zuora-Request-Id - The Zuora internal identifier of the API call. You cannot control the value of this header.  <br>  * Zuora-Track-Id - A custom identifier for tracing the API call. If you specified a tracing identifier in the request headers, Zuora returns the same tracing identifier. Otherwise, Zuora does not set this header.  <br>  </td></tr>
         </table>
         */
        public ApiResponse<GETPaymentScheduleResponse> executeWithHttpInfo() throws ApiException {
            PUTPreviewPaymentScheduleRequest puTPreviewPaymentScheduleRequest = buildBodyParams();
            return paymentScheduleUpdatePreviewWithHttpInfo(paymentScheduleKey, puTPreviewPaymentScheduleRequest, acceptEncoding, contentEncoding, authorization, zuoraTrackId, zuoraEntityIds, zuoraOrgIds, zuoraVersion);
        }

        /**
         * Execute paymentScheduleUpdatePreview request (asynchronously)
         * @param _callback The callback to be executed when the API call finishes
         * @return The request call
         * @throws ApiException If fail to process the API call, e.g. serializing the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td>  </td><td>  * Content-Encoding - This header is returned if you specify the &#x60;Accept-Encoding: gzip&#x60; request header and the response contains over 1000 bytes of data. Note that only the following MIME types support gzipped responses:   - &#x60;application/json&#x60;   - &#x60;application/xml&#x60;   - &#x60;text/html&#x60;   - &#x60;text/csv&#x60;   - &#x60;text/plain&#x60;  <br>  * RateLimit-Limit - The request limit quota for the time window closest to exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Remaining - The number of requests remaining in the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Reset - The number of seconds until the quota resets for the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Zuora-Request-Id - The Zuora internal identifier of the API call. You cannot control the value of this header.  <br>  * Zuora-Track-Id - A custom identifier for tracing the API call. If you specified a tracing identifier in the request headers, Zuora returns the same tracing identifier. Otherwise, Zuora does not set this header.  <br>  </td></tr>
         </table>
         */
        public okhttp3.Call executeAsync(final ApiCallback<GETPaymentScheduleResponse> _callback) throws ApiException {
            PUTPreviewPaymentScheduleRequest puTPreviewPaymentScheduleRequest = buildBodyParams();
            return paymentScheduleUpdatePreviewAsync(paymentScheduleKey, puTPreviewPaymentScheduleRequest, acceptEncoding, contentEncoding, authorization, zuoraTrackId, zuoraEntityIds, zuoraOrgIds, zuoraVersion, _callback);
        }
    }

    /**
     * Preview the result of payment schedule updates
     * Preview the result of a payment schedule update. This operation only provides a preview. No changes will be made to the database. For custom payment schedules, only the custom fields on the payment schedules can be udpated. Use the [Update a payment schedule item](https://developer.zuora.com/api-references/api/tag/PUT_PaymentScheduleItem) operation to update payment schedule items of custom payment schedule.  Note the following rules for the &#x60;periodStartDate&#x60;, &#x60;period&#x60;, and &#x60;occurrences&#x60;:  - If &#x60;periodStartDate&#x60; is specified, all pending payment schedule items will be rescheduled using this new &#x60;periodStartDate&#x60;. If &#x60;period&#x60; is changed, we recommend passing in &#x60;periodStartDate&#x60;. Otherwise, the system would use the original start date if there is no processed or canceled items, or the last processed or canceled &#39;&#x60;scheduleDate&#x60; + 1 &#x60;period&#x60;&#39; as the new &#x60;periodStartDate&#x60;. - If only &#x60;occurrences&#x60; is updated, the new item will start with the last processed or canceled &#39;&#x60;scheduleDate&#x60; + 1 &#x60;period&#x60;&#39;.  **Note:** - The Payment Schedules feature is in the **Early Adopter** phase. We are actively soliciting feedback from a small set of early adopters before releasing it as generally available. To manage and access this feature through the self-service interface, see [Manage Features](https://knowledgecenter.zuora.com/Zuora_Payments/Payments_Settings/Manage_Features) in the Knowledge Center. 
     * @param paymentScheduleKey The unique ID or number of a payment schedule. For example, &#x60;8a90857b822459cd018224dcb9eb13be&#x60;, or &#x60;PS-00000007&#x60;.  (required)
     * @param puTPreviewPaymentScheduleRequest  (required)
     * @return PaymentScheduleUpdatePreviewRequestBuilder
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td>  </td><td>  * Content-Encoding - This header is returned if you specify the &#x60;Accept-Encoding: gzip&#x60; request header and the response contains over 1000 bytes of data. Note that only the following MIME types support gzipped responses:   - &#x60;application/json&#x60;   - &#x60;application/xml&#x60;   - &#x60;text/html&#x60;   - &#x60;text/csv&#x60;   - &#x60;text/plain&#x60;  <br>  * RateLimit-Limit - The request limit quota for the time window closest to exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Remaining - The number of requests remaining in the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Reset - The number of seconds until the quota resets for the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Zuora-Request-Id - The Zuora internal identifier of the API call. You cannot control the value of this header.  <br>  * Zuora-Track-Id - A custom identifier for tracing the API call. If you specified a tracing identifier in the request headers, Zuora returns the same tracing identifier. Otherwise, Zuora does not set this header.  <br>  </td></tr>
     </table>
     */
    public PaymentScheduleUpdatePreviewRequestBuilder paymentScheduleUpdatePreview(String paymentScheduleKey) throws IllegalArgumentException {
        if (paymentScheduleKey == null) throw new IllegalArgumentException("\"paymentScheduleKey\" is required but got null");
            

        return new PaymentScheduleUpdatePreviewRequestBuilder(paymentScheduleKey);
    }
    private okhttp3.Call paymentSchedule_0Call(String paymentScheduleKey, String acceptEncoding, String contentEncoding, String authorization, String zuoraTrackId, String zuoraEntityIds, String zuoraOrgIds, Integer nextPendingItems, Integer lastProcessedItems, String zuoraVersion, final ApiCallback _callback) throws ApiException {
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
        String localVarPath = "/v1/payment-schedules/{paymentScheduleKey}"
            .replace("{" + "paymentScheduleKey" + "}", localVarApiClient.escapeString(paymentScheduleKey.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        if (nextPendingItems != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("nextPendingItems", nextPendingItems));
        }

        if (lastProcessedItems != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("lastProcessedItems", lastProcessedItems));
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

        if (zuoraVersion != null) {
            localVarHeaderParams.put("zuora-version", localVarApiClient.parameterToString(zuoraVersion));
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
    private okhttp3.Call paymentSchedule_0ValidateBeforeCall(String paymentScheduleKey, String acceptEncoding, String contentEncoding, String authorization, String zuoraTrackId, String zuoraEntityIds, String zuoraOrgIds, Integer nextPendingItems, Integer lastProcessedItems, String zuoraVersion, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'paymentScheduleKey' is set
        if (paymentScheduleKey == null) {
            throw new ApiException("Missing the required parameter 'paymentScheduleKey' when calling paymentSchedule_0(Async)");
        }

        return paymentSchedule_0Call(paymentScheduleKey, acceptEncoding, contentEncoding, authorization, zuoraTrackId, zuoraEntityIds, zuoraOrgIds, nextPendingItems, lastProcessedItems, zuoraVersion, _callback);

    }


    private ApiResponse<GETPaymentScheduleResponse> paymentSchedule_0WithHttpInfo(String paymentScheduleKey, String acceptEncoding, String contentEncoding, String authorization, String zuoraTrackId, String zuoraEntityIds, String zuoraOrgIds, Integer nextPendingItems, Integer lastProcessedItems, String zuoraVersion) throws ApiException {
        okhttp3.Call localVarCall = paymentSchedule_0ValidateBeforeCall(paymentScheduleKey, acceptEncoding, contentEncoding, authorization, zuoraTrackId, zuoraEntityIds, zuoraOrgIds, nextPendingItems, lastProcessedItems, zuoraVersion, null);
        Type localVarReturnType = new TypeToken<GETPaymentScheduleResponse>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    private okhttp3.Call paymentSchedule_0Async(String paymentScheduleKey, String acceptEncoding, String contentEncoding, String authorization, String zuoraTrackId, String zuoraEntityIds, String zuoraOrgIds, Integer nextPendingItems, Integer lastProcessedItems, String zuoraVersion, final ApiCallback<GETPaymentScheduleResponse> _callback) throws ApiException {

        okhttp3.Call localVarCall = paymentSchedule_0ValidateBeforeCall(paymentScheduleKey, acceptEncoding, contentEncoding, authorization, zuoraTrackId, zuoraEntityIds, zuoraOrgIds, nextPendingItems, lastProcessedItems, zuoraVersion, _callback);
        Type localVarReturnType = new TypeToken<GETPaymentScheduleResponse>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    public class PaymentSchedule0RequestBuilder {
        private final String paymentScheduleKey;
        private String acceptEncoding;
        private String contentEncoding;
        private String authorization;
        private String zuoraTrackId;
        private String zuoraEntityIds;
        private String zuoraOrgIds;
        private Integer nextPendingItems;
        private Integer lastProcessedItems;
        private String zuoraVersion;

        private PaymentSchedule0RequestBuilder(String paymentScheduleKey) {
            this.paymentScheduleKey = paymentScheduleKey;
        }

        /**
         * Set acceptEncoding
         * @param acceptEncoding Include the &#x60;Accept-Encoding: gzip&#x60; header to compress responses as a gzipped file. It can significantly reduce the bandwidth required for a response.   If specified, Zuora automatically compresses responses that contain over 1000 bytes of data, and the response contains a &#x60;Content-Encoding&#x60; header with the compression algorithm so that your client can decompress it.  (optional)
         * @return PaymentSchedule0RequestBuilder
         */
        public PaymentSchedule0RequestBuilder acceptEncoding(String acceptEncoding) {
            this.acceptEncoding = acceptEncoding;
            return this;
        }
        
        /**
         * Set contentEncoding
         * @param contentEncoding Include the &#x60;Content-Encoding: gzip&#x60; header to compress a request. With this header specified, you should upload a gzipped file for the request payload instead of sending the JSON payload.  (optional)
         * @return PaymentSchedule0RequestBuilder
         */
        public PaymentSchedule0RequestBuilder contentEncoding(String contentEncoding) {
            this.contentEncoding = contentEncoding;
            return this;
        }
        
        /**
         * Set authorization
         * @param authorization The value is in the &#x60;Bearer {token}&#x60; format where {token} is a valid OAuth token generated by calling [Create an OAuth token](https://developer.zuora.com/api-references/api/operation/createToken).  (optional)
         * @return PaymentSchedule0RequestBuilder
         */
        public PaymentSchedule0RequestBuilder authorization(String authorization) {
            this.authorization = authorization;
            return this;
        }
        
        /**
         * Set zuoraTrackId
         * @param zuoraTrackId A custom identifier for tracing the API call. If you set a value for this header, Zuora returns the same value in the response headers. This header enables you to associate your system process identifiers with Zuora API calls, to assist with troubleshooting in the event of an issue.  The value of this field must use the US-ASCII character set and must not include any of the following characters: colon (&#x60;:&#x60;), semicolon (&#x60;;&#x60;), double quote (&#x60;\&quot;&#x60;), and quote (&#x60;&#39;&#x60;).  (optional)
         * @return PaymentSchedule0RequestBuilder
         */
        public PaymentSchedule0RequestBuilder zuoraTrackId(String zuoraTrackId) {
            this.zuoraTrackId = zuoraTrackId;
            return this;
        }
        
        /**
         * Set zuoraEntityIds
         * @param zuoraEntityIds An entity ID. If you have [Zuora Multi-entity](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Multi-entity) enabled and the OAuth token is valid for more than one entity, you must use this header to specify which entity to perform the operation in. If the OAuth token is only valid for a single entity, or you do not have Zuora Multi-entity enabled, you do not need to set this header.  (optional)
         * @return PaymentSchedule0RequestBuilder
         */
        public PaymentSchedule0RequestBuilder zuoraEntityIds(String zuoraEntityIds) {
            this.zuoraEntityIds = zuoraEntityIds;
            return this;
        }
        
        /**
         * Set zuoraOrgIds
         * @param zuoraOrgIds Comma separated IDs. If you have &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Central_Platform/Multi-Org\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Zuora Multi-Org&lt;/a&gt; enabled,  you can use this header to specify which orgs to perform the operation in. If you do not have Zuora Multi-Org enabled, you should not set this header.  The IDs must be a sub-set of the user&#39;s accessible orgs. If you specify an org that the user does not have access to, the operation fails.  If the header is not set, the operation is performed in scope of the user&#39;s accessible orgs.  (optional)
         * @return PaymentSchedule0RequestBuilder
         */
        public PaymentSchedule0RequestBuilder zuoraOrgIds(String zuoraOrgIds) {
            this.zuoraOrgIds = zuoraOrgIds;
            return this;
        }
        
        /**
         * Set nextPendingItems
         * @param nextPendingItems Number of next pending payment schedule items displayed in the response body.  (optional)
         * @return PaymentSchedule0RequestBuilder
         */
        public PaymentSchedule0RequestBuilder nextPendingItems(Integer nextPendingItems) {
            this.nextPendingItems = nextPendingItems;
            return this;
        }
        
        /**
         * Set lastProcessedItems
         * @param lastProcessedItems Number of the most recent processed payment schedule items dispalyed in the response body.  (optional)
         * @return PaymentSchedule0RequestBuilder
         */
        public PaymentSchedule0RequestBuilder lastProcessedItems(Integer lastProcessedItems) {
            this.lastProcessedItems = lastProcessedItems;
            return this;
        }
        
        /**
         * Set zuoraVersion
         * @param zuoraVersion The minor version of the Zuora REST API. See [Minor Version](https://developer.zuora.com/api-references/api/overview/#section/API-Versions/Minor-Version) for information about REST API version control.   This header affects the availability of the following response fields:   - &#x60;items&#x60; &gt; &#x60;paymentId&#x60;  (optional)
         * @return PaymentSchedule0RequestBuilder
         */
        public PaymentSchedule0RequestBuilder zuoraVersion(String zuoraVersion) {
            this.zuoraVersion = zuoraVersion;
            return this;
        }
        
        /**
         * Build call for paymentSchedule_0
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
            return paymentSchedule_0Call(paymentScheduleKey, acceptEncoding, contentEncoding, authorization, zuoraTrackId, zuoraEntityIds, zuoraOrgIds, nextPendingItems, lastProcessedItems, zuoraVersion, _callback);
        }


        /**
         * Execute paymentSchedule_0 request
         * @return GETPaymentScheduleResponse
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td>  </td><td>  * Content-Encoding - This header is returned if you specify the &#x60;Accept-Encoding: gzip&#x60; request header and the response contains over 1000 bytes of data. Note that only the following MIME types support gzipped responses:   - &#x60;application/json&#x60;   - &#x60;application/xml&#x60;   - &#x60;text/html&#x60;   - &#x60;text/csv&#x60;   - &#x60;text/plain&#x60;  <br>  * RateLimit-Limit - The request limit quota for the time window closest to exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Remaining - The number of requests remaining in the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Reset - The number of seconds until the quota resets for the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Zuora-Request-Id - The Zuora internal identifier of the API call. You cannot control the value of this header.  <br>  * Zuora-Track-Id - A custom identifier for tracing the API call. If you specified a tracing identifier in the request headers, Zuora returns the same tracing identifier. Otherwise, Zuora does not set this header.  <br>  </td></tr>
         </table>
         */
        public GETPaymentScheduleResponse execute() throws ApiException {
            ApiResponse<GETPaymentScheduleResponse> localVarResp = paymentSchedule_0WithHttpInfo(paymentScheduleKey, acceptEncoding, contentEncoding, authorization, zuoraTrackId, zuoraEntityIds, zuoraOrgIds, nextPendingItems, lastProcessedItems, zuoraVersion);
            return localVarResp.getResponseBody();
        }

        /**
         * Execute paymentSchedule_0 request with HTTP info returned
         * @return ApiResponse&lt;GETPaymentScheduleResponse&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td>  </td><td>  * Content-Encoding - This header is returned if you specify the &#x60;Accept-Encoding: gzip&#x60; request header and the response contains over 1000 bytes of data. Note that only the following MIME types support gzipped responses:   - &#x60;application/json&#x60;   - &#x60;application/xml&#x60;   - &#x60;text/html&#x60;   - &#x60;text/csv&#x60;   - &#x60;text/plain&#x60;  <br>  * RateLimit-Limit - The request limit quota for the time window closest to exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Remaining - The number of requests remaining in the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Reset - The number of seconds until the quota resets for the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Zuora-Request-Id - The Zuora internal identifier of the API call. You cannot control the value of this header.  <br>  * Zuora-Track-Id - A custom identifier for tracing the API call. If you specified a tracing identifier in the request headers, Zuora returns the same tracing identifier. Otherwise, Zuora does not set this header.  <br>  </td></tr>
         </table>
         */
        public ApiResponse<GETPaymentScheduleResponse> executeWithHttpInfo() throws ApiException {
            return paymentSchedule_0WithHttpInfo(paymentScheduleKey, acceptEncoding, contentEncoding, authorization, zuoraTrackId, zuoraEntityIds, zuoraOrgIds, nextPendingItems, lastProcessedItems, zuoraVersion);
        }

        /**
         * Execute paymentSchedule_0 request (asynchronously)
         * @param _callback The callback to be executed when the API call finishes
         * @return The request call
         * @throws ApiException If fail to process the API call, e.g. serializing the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td>  </td><td>  * Content-Encoding - This header is returned if you specify the &#x60;Accept-Encoding: gzip&#x60; request header and the response contains over 1000 bytes of data. Note that only the following MIME types support gzipped responses:   - &#x60;application/json&#x60;   - &#x60;application/xml&#x60;   - &#x60;text/html&#x60;   - &#x60;text/csv&#x60;   - &#x60;text/plain&#x60;  <br>  * RateLimit-Limit - The request limit quota for the time window closest to exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Remaining - The number of requests remaining in the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Reset - The number of seconds until the quota resets for the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Zuora-Request-Id - The Zuora internal identifier of the API call. You cannot control the value of this header.  <br>  * Zuora-Track-Id - A custom identifier for tracing the API call. If you specified a tracing identifier in the request headers, Zuora returns the same tracing identifier. Otherwise, Zuora does not set this header.  <br>  </td></tr>
         </table>
         */
        public okhttp3.Call executeAsync(final ApiCallback<GETPaymentScheduleResponse> _callback) throws ApiException {
            return paymentSchedule_0Async(paymentScheduleKey, acceptEncoding, contentEncoding, authorization, zuoraTrackId, zuoraEntityIds, zuoraOrgIds, nextPendingItems, lastProcessedItems, zuoraVersion, _callback);
        }
    }

    /**
     * Retrieve a payment schedule
     * Retrieves a payment schedule by payment schedule key.  **Note:** - The Payment Schedules feature is in the **Early Adopter** phase. We are actively soliciting feedback from a small set of early adopters before releasing it as generally available. To manage and access this feature through the self-service interface, see [Manage Features](https://knowledgecenter.zuora.com/Zuora_Payments/Payments_Settings/Manage_Features) in the Knowledge Center. - This operation is only available if you have [Invoice Settlement](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/Invoice_Settlement) enabled. 
     * @param paymentScheduleKey The unique ID or number of a payment schedule. For example, &#x60;8a90857b822459cd018224dcb9eb13be&#x60;, or &#x60;PS-00000007&#x60;.  (required)
     * @return PaymentSchedule0RequestBuilder
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td>  </td><td>  * Content-Encoding - This header is returned if you specify the &#x60;Accept-Encoding: gzip&#x60; request header and the response contains over 1000 bytes of data. Note that only the following MIME types support gzipped responses:   - &#x60;application/json&#x60;   - &#x60;application/xml&#x60;   - &#x60;text/html&#x60;   - &#x60;text/csv&#x60;   - &#x60;text/plain&#x60;  <br>  * RateLimit-Limit - The request limit quota for the time window closest to exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Remaining - The number of requests remaining in the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Reset - The number of seconds until the quota resets for the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Zuora-Request-Id - The Zuora internal identifier of the API call. You cannot control the value of this header.  <br>  * Zuora-Track-Id - A custom identifier for tracing the API call. If you specified a tracing identifier in the request headers, Zuora returns the same tracing identifier. Otherwise, Zuora does not set this header.  <br>  </td></tr>
     </table>
     */
    public PaymentSchedule0RequestBuilder paymentSchedule_0(String paymentScheduleKey) throws IllegalArgumentException {
        if (paymentScheduleKey == null) throw new IllegalArgumentException("\"paymentScheduleKey\" is required but got null");
            

        return new PaymentSchedule0RequestBuilder(paymentScheduleKey);
    }
    private okhttp3.Call paymentSchedule_1Call(String paymentScheduleKey, PUTPaymentScheduleRequest puTPaymentScheduleRequest, String acceptEncoding, String contentEncoding, String authorization, String zuoraTrackId, String zuoraEntityIds, String zuoraOrgIds, String zuoraVersion, final ApiCallback _callback) throws ApiException {
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

        Object localVarPostBody = puTPaymentScheduleRequest;

        // create path and map variables
        String localVarPath = "/v1/payment-schedules/{paymentScheduleKey}"
            .replace("{" + "paymentScheduleKey" + "}", localVarApiClient.escapeString(paymentScheduleKey.toString()));

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

        if (zuoraVersion != null) {
            localVarHeaderParams.put("zuora-version", localVarApiClient.parameterToString(zuoraVersion));
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
    private okhttp3.Call paymentSchedule_1ValidateBeforeCall(String paymentScheduleKey, PUTPaymentScheduleRequest puTPaymentScheduleRequest, String acceptEncoding, String contentEncoding, String authorization, String zuoraTrackId, String zuoraEntityIds, String zuoraOrgIds, String zuoraVersion, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'paymentScheduleKey' is set
        if (paymentScheduleKey == null) {
            throw new ApiException("Missing the required parameter 'paymentScheduleKey' when calling paymentSchedule_1(Async)");
        }

        // verify the required parameter 'puTPaymentScheduleRequest' is set
        if (puTPaymentScheduleRequest == null) {
            throw new ApiException("Missing the required parameter 'puTPaymentScheduleRequest' when calling paymentSchedule_1(Async)");
        }

        return paymentSchedule_1Call(paymentScheduleKey, puTPaymentScheduleRequest, acceptEncoding, contentEncoding, authorization, zuoraTrackId, zuoraEntityIds, zuoraOrgIds, zuoraVersion, _callback);

    }


    private ApiResponse<GETPaymentScheduleResponse> paymentSchedule_1WithHttpInfo(String paymentScheduleKey, PUTPaymentScheduleRequest puTPaymentScheduleRequest, String acceptEncoding, String contentEncoding, String authorization, String zuoraTrackId, String zuoraEntityIds, String zuoraOrgIds, String zuoraVersion) throws ApiException {
        okhttp3.Call localVarCall = paymentSchedule_1ValidateBeforeCall(paymentScheduleKey, puTPaymentScheduleRequest, acceptEncoding, contentEncoding, authorization, zuoraTrackId, zuoraEntityIds, zuoraOrgIds, zuoraVersion, null);
        Type localVarReturnType = new TypeToken<GETPaymentScheduleResponse>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    private okhttp3.Call paymentSchedule_1Async(String paymentScheduleKey, PUTPaymentScheduleRequest puTPaymentScheduleRequest, String acceptEncoding, String contentEncoding, String authorization, String zuoraTrackId, String zuoraEntityIds, String zuoraOrgIds, String zuoraVersion, final ApiCallback<GETPaymentScheduleResponse> _callback) throws ApiException {

        okhttp3.Call localVarCall = paymentSchedule_1ValidateBeforeCall(paymentScheduleKey, puTPaymentScheduleRequest, acceptEncoding, contentEncoding, authorization, zuoraTrackId, zuoraEntityIds, zuoraOrgIds, zuoraVersion, _callback);
        Type localVarReturnType = new TypeToken<GETPaymentScheduleResponse>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    public class PaymentSchedule1RequestBuilder {
        private final String paymentScheduleKey;
        private Double amount;
        private String currency;
        private Integer occurrences;
        private String paymentGatewayId;
        private String paymentMethodId;
        private List<PaymentSchedulePaymentOptionFields> paymentOption;
        private String period;
        private LocalDate periodStartDate;
        private Integer runHour;
        private String acceptEncoding;
        private String contentEncoding;
        private String authorization;
        private String zuoraTrackId;
        private String zuoraEntityIds;
        private String zuoraOrgIds;
        private String zuoraVersion;
        private PUTPaymentScheduleRequest puTPaymentScheduleRequest;

        private PaymentSchedule1RequestBuilder(String paymentScheduleKey) {
            this.paymentScheduleKey = paymentScheduleKey;
        }

        /**
         * Set puTPaymentScheduleRequest
         * @param puTPaymentScheduleRequest  (optional)
         * @return PaymentSchedule1RequestBuilder
         */
        public PaymentSchedule1RequestBuilder puTPaymentScheduleRequest(PUTPaymentScheduleRequest puTPaymentScheduleRequest) {
            this.puTPaymentScheduleRequest = puTPaymentScheduleRequest;
            return this;
        }

        /**
         * Set amount
         * @param amount Indicates the updated amount of the pending payment schedule items.  (optional)
         * @return PaymentSchedule1RequestBuilder
         */
        public PaymentSchedule1RequestBuilder amount(Double amount) {
            this.amount = amount;
            return this;
        }
        
        /**
         * Set currency
         * @param currency Indicates the updated currency of the pending payment schedule items.        (optional)
         * @return PaymentSchedule1RequestBuilder
         */
        public PaymentSchedule1RequestBuilder currency(String currency) {
            this.currency = currency;
            return this;
        }
        
        /**
         * Set occurrences
         * @param occurrences Indicates the updated number of payment schedule items that are created by the payment schedule.  **Note:**   - If \\\&quot;updated &#x60;occurrences&#x60; &gt; existing &#x60;occurrences&#x60;\\\&quot;, the following number of pending payment schedule item will be added to the payment schedule: “updated &#x60;occurrences&#x60; - existing &#x60;occurrences&#x60;”.   - If \\\&quot;existing &#x60;occurrences&#x60; &gt; updated &#x60;occurrences&#x60; &gt;&#x3D; the number of &#x60;processed&#x60;/&#x60;errored&#x60;/&#x60;canceled&#x60; payment schedule items\\\&quot;, the following number of pending items will be removed by descending order of the schedule dates: \\\&quot;existing &#x60;occurrences&#x60; - updated &#x60;occurrences&#x60;\\\&quot;.   - If \\\&quot;updated &#x60;occurrences&#x60; &lt; the number of &#x60;processed&#x60;/&#x60;erroed&#x60;/&#x60;canceled&#x60; payment schedule items\\\&quot;, a validation error will be returned.  (optional)
         * @return PaymentSchedule1RequestBuilder
         */
        public PaymentSchedule1RequestBuilder occurrences(Integer occurrences) {
            this.occurrences = occurrences;
            return this;
        }
        
        /**
         * Set paymentGatewayId
         * @param paymentGatewayId Indicates the updated payment gateway ID of the pending payment schedule items.  (optional)
         * @return PaymentSchedule1RequestBuilder
         */
        public PaymentSchedule1RequestBuilder paymentGatewayId(String paymentGatewayId) {
            this.paymentGatewayId = paymentGatewayId;
            return this;
        }
        
        /**
         * Set paymentMethodId
         * @param paymentMethodId Indicates the updated payment method ID of the pending payment schedule items.   (optional)
         * @return PaymentSchedule1RequestBuilder
         */
        public PaymentSchedule1RequestBuilder paymentMethodId(String paymentMethodId) {
            this.paymentMethodId = paymentMethodId;
            return this;
        }
        
        /**
         * Set paymentOption
         * @param paymentOption Container for the paymentOption items, which describe the transactional level rules for processing payments. Currently, only the Gateway Options type is supported.  Here is an example: &#x60;&#x60;&#x60; \\\&quot;paymentOption\\\&quot;: [   {     \\\&quot;type\\\&quot;: \\\&quot;GatewayOptions\\\&quot;,     \\\&quot;detail\\\&quot;: {       \\\&quot;SecCode\\\&quot;:\\\&quot;WEB\\\&quot;     }   } ] &#x60;&#x60;&#x60;  &#x60;paymentOption&#x60; of the payment schedule takes precedence over &#x60;paymentOption&#x60; of the payment schedule item.   **Note:** To enable this field, submit a request at [Zuora Global Support](https://support.zuora.com/).  (optional)
         * @return PaymentSchedule1RequestBuilder
         */
        public PaymentSchedule1RequestBuilder paymentOption(List<PaymentSchedulePaymentOptionFields> paymentOption) {
            this.paymentOption = paymentOption;
            return this;
        }
        
        /**
         * Set period
         * @param period Indicates the updated period of the pending payment schedule items.  (optional)
         * @return PaymentSchedule1RequestBuilder
         */
        public PaymentSchedule1RequestBuilder period(String period) {
            this.period = period;
            return this;
        }
        
        /**
         * Set periodStartDate
         * @param periodStartDate Indicates the updated collection date for the next pending payment schedule item.  (optional)
         * @return PaymentSchedule1RequestBuilder
         */
        public PaymentSchedule1RequestBuilder periodStartDate(LocalDate periodStartDate) {
            this.periodStartDate = periodStartDate;
            return this;
        }
        
        /**
         * Set runHour
         * @param runHour Specifies at which hour of the day in the tenant’s time zone this payment will be collected. Available values: &#x60;[0,1,2,~,22,23]&#x60;.    If the time difference between your tenant’s timezone and the timezone where Zuora servers are is not in full hours, for example, 2.5 hours, the payment schedule items will be triggered half hour later than your scheduled time. If the payment &#x60;runHour&#x60; and &#x60;scheduledDate&#x60; are backdated, the system will collect the payment when the next runHour occurs.  (optional)
         * @return PaymentSchedule1RequestBuilder
         */
        public PaymentSchedule1RequestBuilder runHour(Integer runHour) {
            this.runHour = runHour;
            return this;
        }
        
        /**
         * Set acceptEncoding
         * @param acceptEncoding Include the &#x60;Accept-Encoding: gzip&#x60; header to compress responses as a gzipped file. It can significantly reduce the bandwidth required for a response.   If specified, Zuora automatically compresses responses that contain over 1000 bytes of data, and the response contains a &#x60;Content-Encoding&#x60; header with the compression algorithm so that your client can decompress it.  (optional)
         * @return PaymentSchedule1RequestBuilder
         */
        public PaymentSchedule1RequestBuilder acceptEncoding(String acceptEncoding) {
            this.acceptEncoding = acceptEncoding;
            return this;
        }
        
        /**
         * Set contentEncoding
         * @param contentEncoding Include the &#x60;Content-Encoding: gzip&#x60; header to compress a request. With this header specified, you should upload a gzipped file for the request payload instead of sending the JSON payload.  (optional)
         * @return PaymentSchedule1RequestBuilder
         */
        public PaymentSchedule1RequestBuilder contentEncoding(String contentEncoding) {
            this.contentEncoding = contentEncoding;
            return this;
        }
        
        /**
         * Set authorization
         * @param authorization The value is in the &#x60;Bearer {token}&#x60; format where {token} is a valid OAuth token generated by calling [Create an OAuth token](https://developer.zuora.com/api-references/api/operation/createToken).  (optional)
         * @return PaymentSchedule1RequestBuilder
         */
        public PaymentSchedule1RequestBuilder authorization(String authorization) {
            this.authorization = authorization;
            return this;
        }
        
        /**
         * Set zuoraTrackId
         * @param zuoraTrackId A custom identifier for tracing the API call. If you set a value for this header, Zuora returns the same value in the response headers. This header enables you to associate your system process identifiers with Zuora API calls, to assist with troubleshooting in the event of an issue.  The value of this field must use the US-ASCII character set and must not include any of the following characters: colon (&#x60;:&#x60;), semicolon (&#x60;;&#x60;), double quote (&#x60;\&quot;&#x60;), and quote (&#x60;&#39;&#x60;).  (optional)
         * @return PaymentSchedule1RequestBuilder
         */
        public PaymentSchedule1RequestBuilder zuoraTrackId(String zuoraTrackId) {
            this.zuoraTrackId = zuoraTrackId;
            return this;
        }
        
        /**
         * Set zuoraEntityIds
         * @param zuoraEntityIds An entity ID. If you have [Zuora Multi-entity](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Multi-entity) enabled and the OAuth token is valid for more than one entity, you must use this header to specify which entity to perform the operation in. If the OAuth token is only valid for a single entity, or you do not have Zuora Multi-entity enabled, you do not need to set this header.  (optional)
         * @return PaymentSchedule1RequestBuilder
         */
        public PaymentSchedule1RequestBuilder zuoraEntityIds(String zuoraEntityIds) {
            this.zuoraEntityIds = zuoraEntityIds;
            return this;
        }
        
        /**
         * Set zuoraOrgIds
         * @param zuoraOrgIds Comma separated IDs. If you have &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Central_Platform/Multi-Org\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Zuora Multi-Org&lt;/a&gt; enabled,  you can use this header to specify which orgs to perform the operation in. If you do not have Zuora Multi-Org enabled, you should not set this header.  The IDs must be a sub-set of the user&#39;s accessible orgs. If you specify an org that the user does not have access to, the operation fails.  If the header is not set, the operation is performed in scope of the user&#39;s accessible orgs.  (optional)
         * @return PaymentSchedule1RequestBuilder
         */
        public PaymentSchedule1RequestBuilder zuoraOrgIds(String zuoraOrgIds) {
            this.zuoraOrgIds = zuoraOrgIds;
            return this;
        }
        
        /**
         * Set zuoraVersion
         * @param zuoraVersion The minor version of the Zuora REST API. See [Minor Version](https://developer.zuora.com/api-references/api/overview/#section/API-Versions/Minor-Version) for information about REST API version control.   This header affects the availability of the following fields: - &#x60;items&#x60; &gt; &#x60;paymentId&#x60;  (optional)
         * @return PaymentSchedule1RequestBuilder
         */
        public PaymentSchedule1RequestBuilder zuoraVersion(String zuoraVersion) {
            this.zuoraVersion = zuoraVersion;
            return this;
        }
        
        /**
         * Build call for paymentSchedule_1
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
            PUTPaymentScheduleRequest puTPaymentScheduleRequest = buildBodyParams();
            return paymentSchedule_1Call(paymentScheduleKey, puTPaymentScheduleRequest, acceptEncoding, contentEncoding, authorization, zuoraTrackId, zuoraEntityIds, zuoraOrgIds, zuoraVersion, _callback);
        }

        private PUTPaymentScheduleRequest buildBodyParams() {
            return this.puTPaymentScheduleRequest;
        }

        /**
         * Execute paymentSchedule_1 request
         * @return GETPaymentScheduleResponse
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td>  </td><td>  * Content-Encoding - This header is returned if you specify the &#x60;Accept-Encoding: gzip&#x60; request header and the response contains over 1000 bytes of data. Note that only the following MIME types support gzipped responses:   - &#x60;application/json&#x60;   - &#x60;application/xml&#x60;   - &#x60;text/html&#x60;   - &#x60;text/csv&#x60;   - &#x60;text/plain&#x60;  <br>  * RateLimit-Limit - The request limit quota for the time window closest to exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Remaining - The number of requests remaining in the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Reset - The number of seconds until the quota resets for the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Zuora-Request-Id - The Zuora internal identifier of the API call. You cannot control the value of this header.  <br>  * Zuora-Track-Id - A custom identifier for tracing the API call. If you specified a tracing identifier in the request headers, Zuora returns the same tracing identifier. Otherwise, Zuora does not set this header.  <br>  </td></tr>
         </table>
         */
        public GETPaymentScheduleResponse execute() throws ApiException {
            PUTPaymentScheduleRequest puTPaymentScheduleRequest = buildBodyParams();
            ApiResponse<GETPaymentScheduleResponse> localVarResp = paymentSchedule_1WithHttpInfo(paymentScheduleKey, puTPaymentScheduleRequest, acceptEncoding, contentEncoding, authorization, zuoraTrackId, zuoraEntityIds, zuoraOrgIds, zuoraVersion);
            return localVarResp.getResponseBody();
        }

        /**
         * Execute paymentSchedule_1 request with HTTP info returned
         * @return ApiResponse&lt;GETPaymentScheduleResponse&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td>  </td><td>  * Content-Encoding - This header is returned if you specify the &#x60;Accept-Encoding: gzip&#x60; request header and the response contains over 1000 bytes of data. Note that only the following MIME types support gzipped responses:   - &#x60;application/json&#x60;   - &#x60;application/xml&#x60;   - &#x60;text/html&#x60;   - &#x60;text/csv&#x60;   - &#x60;text/plain&#x60;  <br>  * RateLimit-Limit - The request limit quota for the time window closest to exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Remaining - The number of requests remaining in the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Reset - The number of seconds until the quota resets for the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Zuora-Request-Id - The Zuora internal identifier of the API call. You cannot control the value of this header.  <br>  * Zuora-Track-Id - A custom identifier for tracing the API call. If you specified a tracing identifier in the request headers, Zuora returns the same tracing identifier. Otherwise, Zuora does not set this header.  <br>  </td></tr>
         </table>
         */
        public ApiResponse<GETPaymentScheduleResponse> executeWithHttpInfo() throws ApiException {
            PUTPaymentScheduleRequest puTPaymentScheduleRequest = buildBodyParams();
            return paymentSchedule_1WithHttpInfo(paymentScheduleKey, puTPaymentScheduleRequest, acceptEncoding, contentEncoding, authorization, zuoraTrackId, zuoraEntityIds, zuoraOrgIds, zuoraVersion);
        }

        /**
         * Execute paymentSchedule_1 request (asynchronously)
         * @param _callback The callback to be executed when the API call finishes
         * @return The request call
         * @throws ApiException If fail to process the API call, e.g. serializing the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td>  </td><td>  * Content-Encoding - This header is returned if you specify the &#x60;Accept-Encoding: gzip&#x60; request header and the response contains over 1000 bytes of data. Note that only the following MIME types support gzipped responses:   - &#x60;application/json&#x60;   - &#x60;application/xml&#x60;   - &#x60;text/html&#x60;   - &#x60;text/csv&#x60;   - &#x60;text/plain&#x60;  <br>  * RateLimit-Limit - The request limit quota for the time window closest to exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Remaining - The number of requests remaining in the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Reset - The number of seconds until the quota resets for the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Zuora-Request-Id - The Zuora internal identifier of the API call. You cannot control the value of this header.  <br>  * Zuora-Track-Id - A custom identifier for tracing the API call. If you specified a tracing identifier in the request headers, Zuora returns the same tracing identifier. Otherwise, Zuora does not set this header.  <br>  </td></tr>
         </table>
         */
        public okhttp3.Call executeAsync(final ApiCallback<GETPaymentScheduleResponse> _callback) throws ApiException {
            PUTPaymentScheduleRequest puTPaymentScheduleRequest = buildBodyParams();
            return paymentSchedule_1Async(paymentScheduleKey, puTPaymentScheduleRequest, acceptEncoding, contentEncoding, authorization, zuoraTrackId, zuoraEntityIds, zuoraOrgIds, zuoraVersion, _callback);
        }
    }

    /**
     * Update a payment schedule
     * Updates a payment schedule. For custom payment schedules, only the custom fields on the payment schedules can be udpated. Use the [Update a payment schedule item](https://developer.zuora.com/api-references/api/operation/PUT_PaymentScheduleItem/) operation to update payment schedule items of custom payment schedule.  Note the following rules for the &#x60;periodStartDate&#x60;, &#x60;period&#x60;, and &#x60;occurrences&#x60;:  - If &#x60;periodStartDate&#x60; is specified, all pending payment schedule items will be rescheduled using this new &#x60;periodStartDate&#x60;. If &#x60;period&#x60; is changed, we recommend passing in &#x60;periodStartDate&#x60;. Otherwise, the system would use the original start date if there is no processed or canceled items, or the last processed or canceled &#39;&#x60;scheduleDate&#x60; + 1 &#x60;period&#x60;&#39; as the new &#x60;periodStartDate&#x60;. - If only &#x60;occurrences&#x60; is updated, the new item will start with the last processed or canceled &#39;&#x60;scheduleDate&#x60; + 1 &#x60;period&#x60;&#39;.  **Note:** - The Payment Schedules feature is in the **Early Adopter** phase. We are actively soliciting feedback from a small set of early adopters before releasing it as generally available. To manage and access this feature through the self-service interface, see [Manage Features](https://knowledgecenter.zuora.com/Zuora_Payments/Payments_Settings/Manage_Features) in the Knowledge Center. - This operation is only available if you have [Invoice Settlement](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/Invoice_Settlement) enabled. 
     * @param paymentScheduleKey The unique ID or number of a payment schedule. For example, &#x60;8a90857b822459cd018224dcb9eb13be&#x60;, or &#x60;PS-00000007&#x60;.  (required)
     * @param puTPaymentScheduleRequest  (required)
     * @return PaymentSchedule1RequestBuilder
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td>  </td><td>  * Content-Encoding - This header is returned if you specify the &#x60;Accept-Encoding: gzip&#x60; request header and the response contains over 1000 bytes of data. Note that only the following MIME types support gzipped responses:   - &#x60;application/json&#x60;   - &#x60;application/xml&#x60;   - &#x60;text/html&#x60;   - &#x60;text/csv&#x60;   - &#x60;text/plain&#x60;  <br>  * RateLimit-Limit - The request limit quota for the time window closest to exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Remaining - The number of requests remaining in the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Reset - The number of seconds until the quota resets for the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Zuora-Request-Id - The Zuora internal identifier of the API call. You cannot control the value of this header.  <br>  * Zuora-Track-Id - A custom identifier for tracing the API call. If you specified a tracing identifier in the request headers, Zuora returns the same tracing identifier. Otherwise, Zuora does not set this header.  <br>  </td></tr>
     </table>
     */
    public PaymentSchedule1RequestBuilder paymentSchedule_1(String paymentScheduleKey) throws IllegalArgumentException {
        if (paymentScheduleKey == null) throw new IllegalArgumentException("\"paymentScheduleKey\" is required but got null");
            

        return new PaymentSchedule1RequestBuilder(paymentScheduleKey);
    }
    private okhttp3.Call paymentSchedulesCall(String acceptEncoding, String contentEncoding, String authorization, String zuoraTrackId, String zuoraEntityIds, String zuoraOrgIds, Integer lastProcessedItems, Integer nextPendingItems, String accountId, Integer accountNumber, String zuoraVersion, final ApiCallback _callback) throws ApiException {
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
        String localVarPath = "/v1/payment-schedules";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        if (lastProcessedItems != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("lastProcessedItems", lastProcessedItems));
        }

        if (nextPendingItems != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("nextPendingItems", nextPendingItems));
        }

        if (accountId != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("accountId", accountId));
        }

        if (accountNumber != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("accountNumber", accountNumber));
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

        if (zuoraVersion != null) {
            localVarHeaderParams.put("zuora-version", localVarApiClient.parameterToString(zuoraVersion));
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
    private okhttp3.Call paymentSchedulesValidateBeforeCall(String acceptEncoding, String contentEncoding, String authorization, String zuoraTrackId, String zuoraEntityIds, String zuoraOrgIds, Integer lastProcessedItems, Integer nextPendingItems, String accountId, Integer accountNumber, String zuoraVersion, final ApiCallback _callback) throws ApiException {
        return paymentSchedulesCall(acceptEncoding, contentEncoding, authorization, zuoraTrackId, zuoraEntityIds, zuoraOrgIds, lastProcessedItems, nextPendingItems, accountId, accountNumber, zuoraVersion, _callback);

    }


    private ApiResponse<List<PaymentScheduleCommonResponse>> paymentSchedulesWithHttpInfo(String acceptEncoding, String contentEncoding, String authorization, String zuoraTrackId, String zuoraEntityIds, String zuoraOrgIds, Integer lastProcessedItems, Integer nextPendingItems, String accountId, Integer accountNumber, String zuoraVersion) throws ApiException {
        okhttp3.Call localVarCall = paymentSchedulesValidateBeforeCall(acceptEncoding, contentEncoding, authorization, zuoraTrackId, zuoraEntityIds, zuoraOrgIds, lastProcessedItems, nextPendingItems, accountId, accountNumber, zuoraVersion, null);
        Type localVarReturnType = new TypeToken<List<PaymentScheduleCommonResponse>>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    private okhttp3.Call paymentSchedulesAsync(String acceptEncoding, String contentEncoding, String authorization, String zuoraTrackId, String zuoraEntityIds, String zuoraOrgIds, Integer lastProcessedItems, Integer nextPendingItems, String accountId, Integer accountNumber, String zuoraVersion, final ApiCallback<List<PaymentScheduleCommonResponse>> _callback) throws ApiException {

        okhttp3.Call localVarCall = paymentSchedulesValidateBeforeCall(acceptEncoding, contentEncoding, authorization, zuoraTrackId, zuoraEntityIds, zuoraOrgIds, lastProcessedItems, nextPendingItems, accountId, accountNumber, zuoraVersion, _callback);
        Type localVarReturnType = new TypeToken<List<PaymentScheduleCommonResponse>>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    public class PaymentSchedulesRequestBuilder {
        private String acceptEncoding;
        private String contentEncoding;
        private String authorization;
        private String zuoraTrackId;
        private String zuoraEntityIds;
        private String zuoraOrgIds;
        private Integer lastProcessedItems;
        private Integer nextPendingItems;
        private String accountId;
        private Integer accountNumber;
        private String zuoraVersion;

        private PaymentSchedulesRequestBuilder() {
        }

        /**
         * Set acceptEncoding
         * @param acceptEncoding Include the &#x60;Accept-Encoding: gzip&#x60; header to compress responses as a gzipped file. It can significantly reduce the bandwidth required for a response.   If specified, Zuora automatically compresses responses that contain over 1000 bytes of data, and the response contains a &#x60;Content-Encoding&#x60; header with the compression algorithm so that your client can decompress it.  (optional)
         * @return PaymentSchedulesRequestBuilder
         */
        public PaymentSchedulesRequestBuilder acceptEncoding(String acceptEncoding) {
            this.acceptEncoding = acceptEncoding;
            return this;
        }
        
        /**
         * Set contentEncoding
         * @param contentEncoding Include the &#x60;Content-Encoding: gzip&#x60; header to compress a request. With this header specified, you should upload a gzipped file for the request payload instead of sending the JSON payload.  (optional)
         * @return PaymentSchedulesRequestBuilder
         */
        public PaymentSchedulesRequestBuilder contentEncoding(String contentEncoding) {
            this.contentEncoding = contentEncoding;
            return this;
        }
        
        /**
         * Set authorization
         * @param authorization The value is in the &#x60;Bearer {token}&#x60; format where {token} is a valid OAuth token generated by calling [Create an OAuth token](https://developer.zuora.com/api-references/api/operation/createToken).  (optional)
         * @return PaymentSchedulesRequestBuilder
         */
        public PaymentSchedulesRequestBuilder authorization(String authorization) {
            this.authorization = authorization;
            return this;
        }
        
        /**
         * Set zuoraTrackId
         * @param zuoraTrackId A custom identifier for tracing the API call. If you set a value for this header, Zuora returns the same value in the response headers. This header enables you to associate your system process identifiers with Zuora API calls, to assist with troubleshooting in the event of an issue.  The value of this field must use the US-ASCII character set and must not include any of the following characters: colon (&#x60;:&#x60;), semicolon (&#x60;;&#x60;), double quote (&#x60;\&quot;&#x60;), and quote (&#x60;&#39;&#x60;).  (optional)
         * @return PaymentSchedulesRequestBuilder
         */
        public PaymentSchedulesRequestBuilder zuoraTrackId(String zuoraTrackId) {
            this.zuoraTrackId = zuoraTrackId;
            return this;
        }
        
        /**
         * Set zuoraEntityIds
         * @param zuoraEntityIds An entity ID. If you have [Zuora Multi-entity](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Multi-entity) enabled and the OAuth token is valid for more than one entity, you must use this header to specify which entity to perform the operation in. If the OAuth token is only valid for a single entity, or you do not have Zuora Multi-entity enabled, you do not need to set this header.  (optional)
         * @return PaymentSchedulesRequestBuilder
         */
        public PaymentSchedulesRequestBuilder zuoraEntityIds(String zuoraEntityIds) {
            this.zuoraEntityIds = zuoraEntityIds;
            return this;
        }
        
        /**
         * Set zuoraOrgIds
         * @param zuoraOrgIds Comma separated IDs. If you have &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Central_Platform/Multi-Org\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Zuora Multi-Org&lt;/a&gt; enabled,  you can use this header to specify which orgs to perform the operation in. If you do not have Zuora Multi-Org enabled, you should not set this header.  The IDs must be a sub-set of the user&#39;s accessible orgs. If you specify an org that the user does not have access to, the operation fails.  If the header is not set, the operation is performed in scope of the user&#39;s accessible orgs.  (optional)
         * @return PaymentSchedulesRequestBuilder
         */
        public PaymentSchedulesRequestBuilder zuoraOrgIds(String zuoraOrgIds) {
            this.zuoraOrgIds = zuoraOrgIds;
            return this;
        }
        
        /**
         * Set lastProcessedItems
         * @param lastProcessedItems Number of the most recent processed payment schedules dispalyed in the response body.  (optional)
         * @return PaymentSchedulesRequestBuilder
         */
        public PaymentSchedulesRequestBuilder lastProcessedItems(Integer lastProcessedItems) {
            this.lastProcessedItems = lastProcessedItems;
            return this;
        }
        
        /**
         * Set nextPendingItems
         * @param nextPendingItems Number of next pending payment schedule items displayed in the response body.  (optional)
         * @return PaymentSchedulesRequestBuilder
         */
        public PaymentSchedulesRequestBuilder nextPendingItems(Integer nextPendingItems) {
            this.nextPendingItems = nextPendingItems;
            return this;
        }
        
        /**
         * Set accountId
         * @param accountId The ID of the customer account. If neither &#x60;accountId&#x60; nor &#x60;accountNumber&#x60; is specified, all payment schedules will be returned.   (optional)
         * @return PaymentSchedulesRequestBuilder
         */
        public PaymentSchedulesRequestBuilder accountId(String accountId) {
            this.accountId = accountId;
            return this;
        }
        
        /**
         * Set accountNumber
         * @param accountNumber The number of the customer account. If neither &#x60;accountId&#x60; nor &#x60;accountNumber&#x60; is specified, all payment schedules will be returned.   (optional)
         * @return PaymentSchedulesRequestBuilder
         */
        public PaymentSchedulesRequestBuilder accountNumber(Integer accountNumber) {
            this.accountNumber = accountNumber;
            return this;
        }
        
        /**
         * Set zuoraVersion
         * @param zuoraVersion The minor version of the Zuora REST API. See [Minor Version](https://developer.zuora.com/api-references/api/overview/#section/API-Versions/Minor-Version) for information about REST API version control.   This header affects the availability of the following fields: * &#x60;items&#x60; &gt; &#x60;paymentId&#x60;            (optional)
         * @return PaymentSchedulesRequestBuilder
         */
        public PaymentSchedulesRequestBuilder zuoraVersion(String zuoraVersion) {
            this.zuoraVersion = zuoraVersion;
            return this;
        }
        
        /**
         * Build call for paymentSchedules
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
            return paymentSchedulesCall(acceptEncoding, contentEncoding, authorization, zuoraTrackId, zuoraEntityIds, zuoraOrgIds, lastProcessedItems, nextPendingItems, accountId, accountNumber, zuoraVersion, _callback);
        }


        /**
         * Execute paymentSchedules request
         * @return List&lt;PaymentScheduleCommonResponse&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td>  </td><td>  * Content-Encoding - This header is returned if you specify the &#x60;Accept-Encoding: gzip&#x60; request header and the response contains over 1000 bytes of data. Note that only the following MIME types support gzipped responses:   - &#x60;application/json&#x60;   - &#x60;application/xml&#x60;   - &#x60;text/html&#x60;   - &#x60;text/csv&#x60;   - &#x60;text/plain&#x60;  <br>  * RateLimit-Limit - The request limit quota for the time window closest to exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Remaining - The number of requests remaining in the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Reset - The number of seconds until the quota resets for the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Zuora-Request-Id - The Zuora internal identifier of the API call. You cannot control the value of this header.  <br>  * Zuora-Track-Id - A custom identifier for tracing the API call. If you specified a tracing identifier in the request headers, Zuora returns the same tracing identifier. Otherwise, Zuora does not set this header.  <br>  </td></tr>
         </table>
         */
        public List<PaymentScheduleCommonResponse> execute() throws ApiException {
            ApiResponse<List<PaymentScheduleCommonResponse>> localVarResp = paymentSchedulesWithHttpInfo(acceptEncoding, contentEncoding, authorization, zuoraTrackId, zuoraEntityIds, zuoraOrgIds, lastProcessedItems, nextPendingItems, accountId, accountNumber, zuoraVersion);
            return localVarResp.getResponseBody();
        }

        /**
         * Execute paymentSchedules request with HTTP info returned
         * @return ApiResponse&lt;List&lt;PaymentScheduleCommonResponse&gt;&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td>  </td><td>  * Content-Encoding - This header is returned if you specify the &#x60;Accept-Encoding: gzip&#x60; request header and the response contains over 1000 bytes of data. Note that only the following MIME types support gzipped responses:   - &#x60;application/json&#x60;   - &#x60;application/xml&#x60;   - &#x60;text/html&#x60;   - &#x60;text/csv&#x60;   - &#x60;text/plain&#x60;  <br>  * RateLimit-Limit - The request limit quota for the time window closest to exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Remaining - The number of requests remaining in the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Reset - The number of seconds until the quota resets for the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Zuora-Request-Id - The Zuora internal identifier of the API call. You cannot control the value of this header.  <br>  * Zuora-Track-Id - A custom identifier for tracing the API call. If you specified a tracing identifier in the request headers, Zuora returns the same tracing identifier. Otherwise, Zuora does not set this header.  <br>  </td></tr>
         </table>
         */
        public ApiResponse<List<PaymentScheduleCommonResponse>> executeWithHttpInfo() throws ApiException {
            return paymentSchedulesWithHttpInfo(acceptEncoding, contentEncoding, authorization, zuoraTrackId, zuoraEntityIds, zuoraOrgIds, lastProcessedItems, nextPendingItems, accountId, accountNumber, zuoraVersion);
        }

        /**
         * Execute paymentSchedules request (asynchronously)
         * @param _callback The callback to be executed when the API call finishes
         * @return The request call
         * @throws ApiException If fail to process the API call, e.g. serializing the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td>  </td><td>  * Content-Encoding - This header is returned if you specify the &#x60;Accept-Encoding: gzip&#x60; request header and the response contains over 1000 bytes of data. Note that only the following MIME types support gzipped responses:   - &#x60;application/json&#x60;   - &#x60;application/xml&#x60;   - &#x60;text/html&#x60;   - &#x60;text/csv&#x60;   - &#x60;text/plain&#x60;  <br>  * RateLimit-Limit - The request limit quota for the time window closest to exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Remaining - The number of requests remaining in the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Reset - The number of seconds until the quota resets for the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Zuora-Request-Id - The Zuora internal identifier of the API call. You cannot control the value of this header.  <br>  * Zuora-Track-Id - A custom identifier for tracing the API call. If you specified a tracing identifier in the request headers, Zuora returns the same tracing identifier. Otherwise, Zuora does not set this header.  <br>  </td></tr>
         </table>
         */
        public okhttp3.Call executeAsync(final ApiCallback<List<PaymentScheduleCommonResponse>> _callback) throws ApiException {
            return paymentSchedulesAsync(acceptEncoding, contentEncoding, authorization, zuoraTrackId, zuoraEntityIds, zuoraOrgIds, lastProcessedItems, nextPendingItems, accountId, accountNumber, zuoraVersion, _callback);
        }
    }

    /**
     * List payment schedules by customer account
     * Retrieves payment schedules of a customer account.  **Note:** - The Payment Schedules feature is in the **Early Adopter** phase. We are actively soliciting feedback from a small set of early adopters before releasing it as generally available. To manage and access this feature through the self-service interface, see [Manage Features](https://knowledgecenter.zuora.com/Zuora_Payments/Payments_Settings/Manage_Features) in the Knowledge Center. - This operation is only available if you have [Invoice Settlement](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/Invoice_Settlement) enabled. 
     * @return PaymentSchedulesRequestBuilder
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td>  </td><td>  * Content-Encoding - This header is returned if you specify the &#x60;Accept-Encoding: gzip&#x60; request header and the response contains over 1000 bytes of data. Note that only the following MIME types support gzipped responses:   - &#x60;application/json&#x60;   - &#x60;application/xml&#x60;   - &#x60;text/html&#x60;   - &#x60;text/csv&#x60;   - &#x60;text/plain&#x60;  <br>  * RateLimit-Limit - The request limit quota for the time window closest to exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Remaining - The number of requests remaining in the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Reset - The number of seconds until the quota resets for the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Zuora-Request-Id - The Zuora internal identifier of the API call. You cannot control the value of this header.  <br>  * Zuora-Track-Id - A custom identifier for tracing the API call. If you specified a tracing identifier in the request headers, Zuora returns the same tracing identifier. Otherwise, Zuora does not set this header.  <br>  </td></tr>
     </table>
     */
    public PaymentSchedulesRequestBuilder paymentSchedules() throws IllegalArgumentException {
        return new PaymentSchedulesRequestBuilder();
    }
    private okhttp3.Call paymentSchedules_0Call(POSTPaymentSchedulesRequest poSTPaymentSchedulesRequest, String idempotencyKey, String acceptEncoding, String contentEncoding, String authorization, String zuoraTrackId, String zuoraEntityIds, String zuoraOrgIds, String zuoraVersion, final ApiCallback _callback) throws ApiException {
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

        Object localVarPostBody = poSTPaymentSchedulesRequest;

        // create path and map variables
        String localVarPath = "/v1/payment-schedules/batch";

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

        if (zuoraVersion != null) {
            localVarHeaderParams.put("zuora-version", localVarApiClient.parameterToString(zuoraVersion));
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
    private okhttp3.Call paymentSchedules_0ValidateBeforeCall(POSTPaymentSchedulesRequest poSTPaymentSchedulesRequest, String idempotencyKey, String acceptEncoding, String contentEncoding, String authorization, String zuoraTrackId, String zuoraEntityIds, String zuoraOrgIds, String zuoraVersion, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'poSTPaymentSchedulesRequest' is set
        if (poSTPaymentSchedulesRequest == null) {
            throw new ApiException("Missing the required parameter 'poSTPaymentSchedulesRequest' when calling paymentSchedules_0(Async)");
        }

        return paymentSchedules_0Call(poSTPaymentSchedulesRequest, idempotencyKey, acceptEncoding, contentEncoding, authorization, zuoraTrackId, zuoraEntityIds, zuoraOrgIds, zuoraVersion, _callback);

    }


    private ApiResponse<POSTPaymentSchedulesResponse> paymentSchedules_0WithHttpInfo(POSTPaymentSchedulesRequest poSTPaymentSchedulesRequest, String idempotencyKey, String acceptEncoding, String contentEncoding, String authorization, String zuoraTrackId, String zuoraEntityIds, String zuoraOrgIds, String zuoraVersion) throws ApiException {
        okhttp3.Call localVarCall = paymentSchedules_0ValidateBeforeCall(poSTPaymentSchedulesRequest, idempotencyKey, acceptEncoding, contentEncoding, authorization, zuoraTrackId, zuoraEntityIds, zuoraOrgIds, zuoraVersion, null);
        Type localVarReturnType = new TypeToken<POSTPaymentSchedulesResponse>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    private okhttp3.Call paymentSchedules_0Async(POSTPaymentSchedulesRequest poSTPaymentSchedulesRequest, String idempotencyKey, String acceptEncoding, String contentEncoding, String authorization, String zuoraTrackId, String zuoraEntityIds, String zuoraOrgIds, String zuoraVersion, final ApiCallback<POSTPaymentSchedulesResponse> _callback) throws ApiException {

        okhttp3.Call localVarCall = paymentSchedules_0ValidateBeforeCall(poSTPaymentSchedulesRequest, idempotencyKey, acceptEncoding, contentEncoding, authorization, zuoraTrackId, zuoraEntityIds, zuoraOrgIds, zuoraVersion, _callback);
        Type localVarReturnType = new TypeToken<POSTPaymentSchedulesResponse>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    public class PaymentSchedules0RequestBuilder {
        private List<POSTPaymentScheduleRequest> paymentSchedules;
        private String idempotencyKey;
        private String acceptEncoding;
        private String contentEncoding;
        private String authorization;
        private String zuoraTrackId;
        private String zuoraEntityIds;
        private String zuoraOrgIds;
        private String zuoraVersion;

        private PaymentSchedules0RequestBuilder() {
        }

        /**
         * Set paymentSchedules
         * @param paymentSchedules Container of the payment schedules to be created.  (optional)
         * @return PaymentSchedules0RequestBuilder
         */
        public PaymentSchedules0RequestBuilder paymentSchedules(List<POSTPaymentScheduleRequest> paymentSchedules) {
            this.paymentSchedules = paymentSchedules;
            return this;
        }
        
        /**
         * Set idempotencyKey
         * @param idempotencyKey Specify a unique idempotency key if you want to perform an idempotent POST or PATCH request. Do not use this header in other request types.   With this header specified, the Zuora server can identify subsequent retries of the same request using this value, which prevents the same operation from being performed multiple times by accident.   (optional)
         * @return PaymentSchedules0RequestBuilder
         */
        public PaymentSchedules0RequestBuilder idempotencyKey(String idempotencyKey) {
            this.idempotencyKey = idempotencyKey;
            return this;
        }
        
        /**
         * Set acceptEncoding
         * @param acceptEncoding Include the &#x60;Accept-Encoding: gzip&#x60; header to compress responses as a gzipped file. It can significantly reduce the bandwidth required for a response.   If specified, Zuora automatically compresses responses that contain over 1000 bytes of data, and the response contains a &#x60;Content-Encoding&#x60; header with the compression algorithm so that your client can decompress it.  (optional)
         * @return PaymentSchedules0RequestBuilder
         */
        public PaymentSchedules0RequestBuilder acceptEncoding(String acceptEncoding) {
            this.acceptEncoding = acceptEncoding;
            return this;
        }
        
        /**
         * Set contentEncoding
         * @param contentEncoding Include the &#x60;Content-Encoding: gzip&#x60; header to compress a request. With this header specified, you should upload a gzipped file for the request payload instead of sending the JSON payload.  (optional)
         * @return PaymentSchedules0RequestBuilder
         */
        public PaymentSchedules0RequestBuilder contentEncoding(String contentEncoding) {
            this.contentEncoding = contentEncoding;
            return this;
        }
        
        /**
         * Set authorization
         * @param authorization The value is in the &#x60;Bearer {token}&#x60; format where {token} is a valid OAuth token generated by calling [Create an OAuth token](https://developer.zuora.com/api-references/api/operation/createToken).  (optional)
         * @return PaymentSchedules0RequestBuilder
         */
        public PaymentSchedules0RequestBuilder authorization(String authorization) {
            this.authorization = authorization;
            return this;
        }
        
        /**
         * Set zuoraTrackId
         * @param zuoraTrackId A custom identifier for tracing the API call. If you set a value for this header, Zuora returns the same value in the response headers. This header enables you to associate your system process identifiers with Zuora API calls, to assist with troubleshooting in the event of an issue.  The value of this field must use the US-ASCII character set and must not include any of the following characters: colon (&#x60;:&#x60;), semicolon (&#x60;;&#x60;), double quote (&#x60;\&quot;&#x60;), and quote (&#x60;&#39;&#x60;).  (optional)
         * @return PaymentSchedules0RequestBuilder
         */
        public PaymentSchedules0RequestBuilder zuoraTrackId(String zuoraTrackId) {
            this.zuoraTrackId = zuoraTrackId;
            return this;
        }
        
        /**
         * Set zuoraEntityIds
         * @param zuoraEntityIds An entity ID. If you have [Zuora Multi-entity](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Multi-entity) enabled and the OAuth token is valid for more than one entity, you must use this header to specify which entity to perform the operation in. If the OAuth token is only valid for a single entity, or you do not have Zuora Multi-entity enabled, you do not need to set this header.  (optional)
         * @return PaymentSchedules0RequestBuilder
         */
        public PaymentSchedules0RequestBuilder zuoraEntityIds(String zuoraEntityIds) {
            this.zuoraEntityIds = zuoraEntityIds;
            return this;
        }
        
        /**
         * Set zuoraOrgIds
         * @param zuoraOrgIds Comma separated IDs. If you have &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Central_Platform/Multi-Org\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Zuora Multi-Org&lt;/a&gt; enabled,  you can use this header to specify which orgs to perform the operation in. If you do not have Zuora Multi-Org enabled, you should not set this header.  The IDs must be a sub-set of the user&#39;s accessible orgs. If you specify an org that the user does not have access to, the operation fails.  If the header is not set, the operation is performed in scope of the user&#39;s accessible orgs.  (optional)
         * @return PaymentSchedules0RequestBuilder
         */
        public PaymentSchedules0RequestBuilder zuoraOrgIds(String zuoraOrgIds) {
            this.zuoraOrgIds = zuoraOrgIds;
            return this;
        }
        
        /**
         * Set zuoraVersion
         * @param zuoraVersion The minor version of the Zuora REST API. See [Minor Version](https://developer.zuora.com/api-references/api/overview/#section/API-Versions/Minor-Version) for information about REST API version control.   This header affects the availability of the following request fields: * &#x60;paymentSchedules&#x60; &gt; &#x60;billingDocument&#x60; * &#x60;paymentSchedules&#x60; &gt; &#x60;items&#x60; &gt; &#x60;billingDocument&#x60;  (optional)
         * @return PaymentSchedules0RequestBuilder
         */
        public PaymentSchedules0RequestBuilder zuoraVersion(String zuoraVersion) {
            this.zuoraVersion = zuoraVersion;
            return this;
        }
        
        /**
         * Build call for paymentSchedules_0
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
            POSTPaymentSchedulesRequest poSTPaymentSchedulesRequest = buildBodyParams();
            return paymentSchedules_0Call(poSTPaymentSchedulesRequest, idempotencyKey, acceptEncoding, contentEncoding, authorization, zuoraTrackId, zuoraEntityIds, zuoraOrgIds, zuoraVersion, _callback);
        }

        private POSTPaymentSchedulesRequest buildBodyParams() {
            POSTPaymentSchedulesRequest poSTPaymentSchedulesRequest = new POSTPaymentSchedulesRequest();
            poSTPaymentSchedulesRequest.paymentSchedules(this.paymentSchedules);
            return poSTPaymentSchedulesRequest;
        }

        /**
         * Execute paymentSchedules_0 request
         * @return POSTPaymentSchedulesResponse
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td>  </td><td>  * Content-Encoding - This header is returned if you specify the &#x60;Accept-Encoding: gzip&#x60; request header and the response contains over 1000 bytes of data. Note that only the following MIME types support gzipped responses:   - &#x60;application/json&#x60;   - &#x60;application/xml&#x60;   - &#x60;text/html&#x60;   - &#x60;text/csv&#x60;   - &#x60;text/plain&#x60;  <br>  * RateLimit-Limit - The request limit quota for the time window closest to exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Remaining - The number of requests remaining in the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Reset - The number of seconds until the quota resets for the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Zuora-Request-Id - The Zuora internal identifier of the API call. You cannot control the value of this header.  <br>  * Zuora-Track-Id - A custom identifier for tracing the API call. If you specified a tracing identifier in the request headers, Zuora returns the same tracing identifier. Otherwise, Zuora does not set this header.  <br>  </td></tr>
         </table>
         */
        public POSTPaymentSchedulesResponse execute() throws ApiException {
            POSTPaymentSchedulesRequest poSTPaymentSchedulesRequest = buildBodyParams();
            ApiResponse<POSTPaymentSchedulesResponse> localVarResp = paymentSchedules_0WithHttpInfo(poSTPaymentSchedulesRequest, idempotencyKey, acceptEncoding, contentEncoding, authorization, zuoraTrackId, zuoraEntityIds, zuoraOrgIds, zuoraVersion);
            return localVarResp.getResponseBody();
        }

        /**
         * Execute paymentSchedules_0 request with HTTP info returned
         * @return ApiResponse&lt;POSTPaymentSchedulesResponse&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td>  </td><td>  * Content-Encoding - This header is returned if you specify the &#x60;Accept-Encoding: gzip&#x60; request header and the response contains over 1000 bytes of data. Note that only the following MIME types support gzipped responses:   - &#x60;application/json&#x60;   - &#x60;application/xml&#x60;   - &#x60;text/html&#x60;   - &#x60;text/csv&#x60;   - &#x60;text/plain&#x60;  <br>  * RateLimit-Limit - The request limit quota for the time window closest to exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Remaining - The number of requests remaining in the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Reset - The number of seconds until the quota resets for the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Zuora-Request-Id - The Zuora internal identifier of the API call. You cannot control the value of this header.  <br>  * Zuora-Track-Id - A custom identifier for tracing the API call. If you specified a tracing identifier in the request headers, Zuora returns the same tracing identifier. Otherwise, Zuora does not set this header.  <br>  </td></tr>
         </table>
         */
        public ApiResponse<POSTPaymentSchedulesResponse> executeWithHttpInfo() throws ApiException {
            POSTPaymentSchedulesRequest poSTPaymentSchedulesRequest = buildBodyParams();
            return paymentSchedules_0WithHttpInfo(poSTPaymentSchedulesRequest, idempotencyKey, acceptEncoding, contentEncoding, authorization, zuoraTrackId, zuoraEntityIds, zuoraOrgIds, zuoraVersion);
        }

        /**
         * Execute paymentSchedules_0 request (asynchronously)
         * @param _callback The callback to be executed when the API call finishes
         * @return The request call
         * @throws ApiException If fail to process the API call, e.g. serializing the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td>  </td><td>  * Content-Encoding - This header is returned if you specify the &#x60;Accept-Encoding: gzip&#x60; request header and the response contains over 1000 bytes of data. Note that only the following MIME types support gzipped responses:   - &#x60;application/json&#x60;   - &#x60;application/xml&#x60;   - &#x60;text/html&#x60;   - &#x60;text/csv&#x60;   - &#x60;text/plain&#x60;  <br>  * RateLimit-Limit - The request limit quota for the time window closest to exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Remaining - The number of requests remaining in the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Reset - The number of seconds until the quota resets for the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Zuora-Request-Id - The Zuora internal identifier of the API call. You cannot control the value of this header.  <br>  * Zuora-Track-Id - A custom identifier for tracing the API call. If you specified a tracing identifier in the request headers, Zuora returns the same tracing identifier. Otherwise, Zuora does not set this header.  <br>  </td></tr>
         </table>
         */
        public okhttp3.Call executeAsync(final ApiCallback<POSTPaymentSchedulesResponse> _callback) throws ApiException {
            POSTPaymentSchedulesRequest poSTPaymentSchedulesRequest = buildBodyParams();
            return paymentSchedules_0Async(poSTPaymentSchedulesRequest, idempotencyKey, acceptEncoding, contentEncoding, authorization, zuoraTrackId, zuoraEntityIds, zuoraOrgIds, zuoraVersion, _callback);
        }
    }

    /**
     * Create multiple payment schedules at once
     * Creates multiple payment schedules at once. You can create both recurring payment schedules and custom payment schedules in one request. The maximum number of payment schedules that can be created by a single request is 50. The maximum number of payment schedule items that each payment schedule can contain is 1000, i.e., you must specify less than 1000 items for a custom payment schedule, and the &#x60;occurrences&#x60; field must be less than 1000 for a recurring payment schedule.  **Note:** - The Payment Schedules feature is in the **Early Adopter** phase. We are actively soliciting feedback from a small set of early adopters before releasing it as generally available. To manage and access this feature through the self-service interface, see [Manage Features](https://knowledgecenter.zuora.com/Zuora_Payments/Payments_Settings/Manage_Features) in the Knowledge Center. - This operation is only available if you have [Invoice Settlement](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/Invoice_Settlement) enabled. - If Standalone Payment is enabled, you can choose to use payment schedules to process payments associated with billing documents, standalone payments, or unapplied payments. If Standalone Payment is not enabled, you can only use payment schedules to process unapplied payments or payments associated with billing documents. - This operation is version controlled. If you set &#x60;zuora-version&#x60; to &#x60;329.0&#x60;, when creating custom payment schedules associated with billing documents, you need to specify the billing document for each payment schedule item; If &#x60;zuora-version&#x60; is set to &#x60;330.0&#x60;, when creating custom payment schedules associated with billing documents, you only need to specify the billing documents at the payment schedule level. The default version number is &#x60;329.0&#x60;. However, we recommend that you specify the version to &#x60;330.0&#x60;. &#x60;329.0&#x60; will be deprecated soon. 
     * @param poSTPaymentSchedulesRequest  (required)
     * @return PaymentSchedules0RequestBuilder
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td>  </td><td>  * Content-Encoding - This header is returned if you specify the &#x60;Accept-Encoding: gzip&#x60; request header and the response contains over 1000 bytes of data. Note that only the following MIME types support gzipped responses:   - &#x60;application/json&#x60;   - &#x60;application/xml&#x60;   - &#x60;text/html&#x60;   - &#x60;text/csv&#x60;   - &#x60;text/plain&#x60;  <br>  * RateLimit-Limit - The request limit quota for the time window closest to exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Remaining - The number of requests remaining in the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Reset - The number of seconds until the quota resets for the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Zuora-Request-Id - The Zuora internal identifier of the API call. You cannot control the value of this header.  <br>  * Zuora-Track-Id - A custom identifier for tracing the API call. If you specified a tracing identifier in the request headers, Zuora returns the same tracing identifier. Otherwise, Zuora does not set this header.  <br>  </td></tr>
     </table>
     */
    public PaymentSchedules0RequestBuilder paymentSchedules_0() throws IllegalArgumentException {
        return new PaymentSchedules0RequestBuilder();
    }
    private okhttp3.Call retryPaymentScheduleItemCall(POSTRetryPaymentScheduleItemRequest poSTRetryPaymentScheduleItemRequest, String idempotencyKey, String acceptEncoding, String contentEncoding, String authorization, String zuoraTrackId, String zuoraEntityIds, String zuoraOrgIds, String zuoraVersion, final ApiCallback _callback) throws ApiException {
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

        Object localVarPostBody = poSTRetryPaymentScheduleItemRequest;

        // create path and map variables
        String localVarPath = "/v1/payment-schedule-items/retry-payment";

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

        if (zuoraVersion != null) {
            localVarHeaderParams.put("zuora-version", localVarApiClient.parameterToString(zuoraVersion));
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
    private okhttp3.Call retryPaymentScheduleItemValidateBeforeCall(POSTRetryPaymentScheduleItemRequest poSTRetryPaymentScheduleItemRequest, String idempotencyKey, String acceptEncoding, String contentEncoding, String authorization, String zuoraTrackId, String zuoraEntityIds, String zuoraOrgIds, String zuoraVersion, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'poSTRetryPaymentScheduleItemRequest' is set
        if (poSTRetryPaymentScheduleItemRequest == null) {
            throw new ApiException("Missing the required parameter 'poSTRetryPaymentScheduleItemRequest' when calling retryPaymentScheduleItem(Async)");
        }

        return retryPaymentScheduleItemCall(poSTRetryPaymentScheduleItemRequest, idempotencyKey, acceptEncoding, contentEncoding, authorization, zuoraTrackId, zuoraEntityIds, zuoraOrgIds, zuoraVersion, _callback);

    }


    private ApiResponse<POSTRetryPaymentScheduleItemResponse> retryPaymentScheduleItemWithHttpInfo(POSTRetryPaymentScheduleItemRequest poSTRetryPaymentScheduleItemRequest, String idempotencyKey, String acceptEncoding, String contentEncoding, String authorization, String zuoraTrackId, String zuoraEntityIds, String zuoraOrgIds, String zuoraVersion) throws ApiException {
        okhttp3.Call localVarCall = retryPaymentScheduleItemValidateBeforeCall(poSTRetryPaymentScheduleItemRequest, idempotencyKey, acceptEncoding, contentEncoding, authorization, zuoraTrackId, zuoraEntityIds, zuoraOrgIds, zuoraVersion, null);
        Type localVarReturnType = new TypeToken<POSTRetryPaymentScheduleItemResponse>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    private okhttp3.Call retryPaymentScheduleItemAsync(POSTRetryPaymentScheduleItemRequest poSTRetryPaymentScheduleItemRequest, String idempotencyKey, String acceptEncoding, String contentEncoding, String authorization, String zuoraTrackId, String zuoraEntityIds, String zuoraOrgIds, String zuoraVersion, final ApiCallback<POSTRetryPaymentScheduleItemResponse> _callback) throws ApiException {

        okhttp3.Call localVarCall = retryPaymentScheduleItemValidateBeforeCall(poSTRetryPaymentScheduleItemRequest, idempotencyKey, acceptEncoding, contentEncoding, authorization, zuoraTrackId, zuoraEntityIds, zuoraOrgIds, zuoraVersion, _callback);
        Type localVarReturnType = new TypeToken<POSTRetryPaymentScheduleItemResponse>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    public class RetryPaymentScheduleItemRequestBuilder {
        private List<POSTRetryPaymentScheduleItemInfo> items;
        private String idempotencyKey;
        private String acceptEncoding;
        private String contentEncoding;
        private String authorization;
        private String zuoraTrackId;
        private String zuoraEntityIds;
        private String zuoraOrgIds;
        private String zuoraVersion;

        private RetryPaymentScheduleItemRequestBuilder() {
        }

        /**
         * Set items
         * @param items The maximum number of items allowable to pass is 10.  (optional)
         * @return RetryPaymentScheduleItemRequestBuilder
         */
        public RetryPaymentScheduleItemRequestBuilder items(List<POSTRetryPaymentScheduleItemInfo> items) {
            this.items = items;
            return this;
        }
        
        /**
         * Set idempotencyKey
         * @param idempotencyKey Specify a unique idempotency key if you want to perform an idempotent POST or PATCH request. Do not use this header in other request types.   With this header specified, the Zuora server can identify subsequent retries of the same request using this value, which prevents the same operation from being performed multiple times by accident.   (optional)
         * @return RetryPaymentScheduleItemRequestBuilder
         */
        public RetryPaymentScheduleItemRequestBuilder idempotencyKey(String idempotencyKey) {
            this.idempotencyKey = idempotencyKey;
            return this;
        }
        
        /**
         * Set acceptEncoding
         * @param acceptEncoding Include the &#x60;Accept-Encoding: gzip&#x60; header to compress responses as a gzipped file. It can significantly reduce the bandwidth required for a response.   If specified, Zuora automatically compresses responses that contain over 1000 bytes of data, and the response contains a &#x60;Content-Encoding&#x60; header with the compression algorithm so that your client can decompress it.  (optional)
         * @return RetryPaymentScheduleItemRequestBuilder
         */
        public RetryPaymentScheduleItemRequestBuilder acceptEncoding(String acceptEncoding) {
            this.acceptEncoding = acceptEncoding;
            return this;
        }
        
        /**
         * Set contentEncoding
         * @param contentEncoding Include the &#x60;Content-Encoding: gzip&#x60; header to compress a request. With this header specified, you should upload a gzipped file for the request payload instead of sending the JSON payload.  (optional)
         * @return RetryPaymentScheduleItemRequestBuilder
         */
        public RetryPaymentScheduleItemRequestBuilder contentEncoding(String contentEncoding) {
            this.contentEncoding = contentEncoding;
            return this;
        }
        
        /**
         * Set authorization
         * @param authorization The value is in the &#x60;Bearer {token}&#x60; format where {token} is a valid OAuth token generated by calling [Create an OAuth token](https://developer.zuora.com/api-references/api/operation/createToken).  (optional)
         * @return RetryPaymentScheduleItemRequestBuilder
         */
        public RetryPaymentScheduleItemRequestBuilder authorization(String authorization) {
            this.authorization = authorization;
            return this;
        }
        
        /**
         * Set zuoraTrackId
         * @param zuoraTrackId A custom identifier for tracing the API call. If you set a value for this header, Zuora returns the same value in the response headers. This header enables you to associate your system process identifiers with Zuora API calls, to assist with troubleshooting in the event of an issue.  The value of this field must use the US-ASCII character set and must not include any of the following characters: colon (&#x60;:&#x60;), semicolon (&#x60;;&#x60;), double quote (&#x60;\&quot;&#x60;), and quote (&#x60;&#39;&#x60;).  (optional)
         * @return RetryPaymentScheduleItemRequestBuilder
         */
        public RetryPaymentScheduleItemRequestBuilder zuoraTrackId(String zuoraTrackId) {
            this.zuoraTrackId = zuoraTrackId;
            return this;
        }
        
        /**
         * Set zuoraEntityIds
         * @param zuoraEntityIds An entity ID. If you have [Zuora Multi-entity](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Multi-entity) enabled and the OAuth token is valid for more than one entity, you must use this header to specify which entity to perform the operation in. If the OAuth token is only valid for a single entity, or you do not have Zuora Multi-entity enabled, you do not need to set this header.  (optional)
         * @return RetryPaymentScheduleItemRequestBuilder
         */
        public RetryPaymentScheduleItemRequestBuilder zuoraEntityIds(String zuoraEntityIds) {
            this.zuoraEntityIds = zuoraEntityIds;
            return this;
        }
        
        /**
         * Set zuoraOrgIds
         * @param zuoraOrgIds Comma separated IDs. If you have &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Central_Platform/Multi-Org\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Zuora Multi-Org&lt;/a&gt; enabled,  you can use this header to specify which orgs to perform the operation in. If you do not have Zuora Multi-Org enabled, you should not set this header.  The IDs must be a sub-set of the user&#39;s accessible orgs. If you specify an org that the user does not have access to, the operation fails.  If the header is not set, the operation is performed in scope of the user&#39;s accessible orgs.  (optional)
         * @return RetryPaymentScheduleItemRequestBuilder
         */
        public RetryPaymentScheduleItemRequestBuilder zuoraOrgIds(String zuoraOrgIds) {
            this.zuoraOrgIds = zuoraOrgIds;
            return this;
        }
        
        /**
         * Set zuoraVersion
         * @param zuoraVersion The minor version of the Zuora REST API. See [Minor Version](https://developer.zuora.com/api-references/api/overview/#section/API-Versions/Minor-Version) for information about REST API version control.   This header affects the availability of the following response fields: - &#x60;items&#x60; &gt; &#x60;paymentId&#x60;  (optional)
         * @return RetryPaymentScheduleItemRequestBuilder
         */
        public RetryPaymentScheduleItemRequestBuilder zuoraVersion(String zuoraVersion) {
            this.zuoraVersion = zuoraVersion;
            return this;
        }
        
        /**
         * Build call for retryPaymentScheduleItem
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
            POSTRetryPaymentScheduleItemRequest poSTRetryPaymentScheduleItemRequest = buildBodyParams();
            return retryPaymentScheduleItemCall(poSTRetryPaymentScheduleItemRequest, idempotencyKey, acceptEncoding, contentEncoding, authorization, zuoraTrackId, zuoraEntityIds, zuoraOrgIds, zuoraVersion, _callback);
        }

        private POSTRetryPaymentScheduleItemRequest buildBodyParams() {
            POSTRetryPaymentScheduleItemRequest poSTRetryPaymentScheduleItemRequest = new POSTRetryPaymentScheduleItemRequest();
            poSTRetryPaymentScheduleItemRequest.items(this.items);
            return poSTRetryPaymentScheduleItemRequest;
        }

        /**
         * Execute retryPaymentScheduleItem request
         * @return POSTRetryPaymentScheduleItemResponse
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td>  </td><td>  * Content-Encoding - This header is returned if you specify the &#x60;Accept-Encoding: gzip&#x60; request header and the response contains over 1000 bytes of data. Note that only the following MIME types support gzipped responses:   - &#x60;application/json&#x60;   - &#x60;application/xml&#x60;   - &#x60;text/html&#x60;   - &#x60;text/csv&#x60;   - &#x60;text/plain&#x60;  <br>  * RateLimit-Limit - The request limit quota for the time window closest to exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Remaining - The number of requests remaining in the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Reset - The number of seconds until the quota resets for the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Zuora-Request-Id - The Zuora internal identifier of the API call. You cannot control the value of this header.  <br>  * Zuora-Track-Id - A custom identifier for tracing the API call. If you specified a tracing identifier in the request headers, Zuora returns the same tracing identifier. Otherwise, Zuora does not set this header.  <br>  </td></tr>
         </table>
         */
        public POSTRetryPaymentScheduleItemResponse execute() throws ApiException {
            POSTRetryPaymentScheduleItemRequest poSTRetryPaymentScheduleItemRequest = buildBodyParams();
            ApiResponse<POSTRetryPaymentScheduleItemResponse> localVarResp = retryPaymentScheduleItemWithHttpInfo(poSTRetryPaymentScheduleItemRequest, idempotencyKey, acceptEncoding, contentEncoding, authorization, zuoraTrackId, zuoraEntityIds, zuoraOrgIds, zuoraVersion);
            return localVarResp.getResponseBody();
        }

        /**
         * Execute retryPaymentScheduleItem request with HTTP info returned
         * @return ApiResponse&lt;POSTRetryPaymentScheduleItemResponse&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td>  </td><td>  * Content-Encoding - This header is returned if you specify the &#x60;Accept-Encoding: gzip&#x60; request header and the response contains over 1000 bytes of data. Note that only the following MIME types support gzipped responses:   - &#x60;application/json&#x60;   - &#x60;application/xml&#x60;   - &#x60;text/html&#x60;   - &#x60;text/csv&#x60;   - &#x60;text/plain&#x60;  <br>  * RateLimit-Limit - The request limit quota for the time window closest to exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Remaining - The number of requests remaining in the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Reset - The number of seconds until the quota resets for the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Zuora-Request-Id - The Zuora internal identifier of the API call. You cannot control the value of this header.  <br>  * Zuora-Track-Id - A custom identifier for tracing the API call. If you specified a tracing identifier in the request headers, Zuora returns the same tracing identifier. Otherwise, Zuora does not set this header.  <br>  </td></tr>
         </table>
         */
        public ApiResponse<POSTRetryPaymentScheduleItemResponse> executeWithHttpInfo() throws ApiException {
            POSTRetryPaymentScheduleItemRequest poSTRetryPaymentScheduleItemRequest = buildBodyParams();
            return retryPaymentScheduleItemWithHttpInfo(poSTRetryPaymentScheduleItemRequest, idempotencyKey, acceptEncoding, contentEncoding, authorization, zuoraTrackId, zuoraEntityIds, zuoraOrgIds, zuoraVersion);
        }

        /**
         * Execute retryPaymentScheduleItem request (asynchronously)
         * @param _callback The callback to be executed when the API call finishes
         * @return The request call
         * @throws ApiException If fail to process the API call, e.g. serializing the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td>  </td><td>  * Content-Encoding - This header is returned if you specify the &#x60;Accept-Encoding: gzip&#x60; request header and the response contains over 1000 bytes of data. Note that only the following MIME types support gzipped responses:   - &#x60;application/json&#x60;   - &#x60;application/xml&#x60;   - &#x60;text/html&#x60;   - &#x60;text/csv&#x60;   - &#x60;text/plain&#x60;  <br>  * RateLimit-Limit - The request limit quota for the time window closest to exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Remaining - The number of requests remaining in the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Reset - The number of seconds until the quota resets for the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Zuora-Request-Id - The Zuora internal identifier of the API call. You cannot control the value of this header.  <br>  * Zuora-Track-Id - A custom identifier for tracing the API call. If you specified a tracing identifier in the request headers, Zuora returns the same tracing identifier. Otherwise, Zuora does not set this header.  <br>  </td></tr>
         </table>
         */
        public okhttp3.Call executeAsync(final ApiCallback<POSTRetryPaymentScheduleItemResponse> _callback) throws ApiException {
            POSTRetryPaymentScheduleItemRequest poSTRetryPaymentScheduleItemRequest = buildBodyParams();
            return retryPaymentScheduleItemAsync(poSTRetryPaymentScheduleItemRequest, idempotencyKey, acceptEncoding, contentEncoding, authorization, zuoraTrackId, zuoraEntityIds, zuoraOrgIds, zuoraVersion, _callback);
        }
    }

    /**
     * Retry failed payment schedule items
     * Retries failed payment schedule items. The payment method and payment gateway of the failed payment can be updated to new values before the retry.  Note that you can retry a payment schedule item only when the payment schedule item is either in the &#x60;Error&#x60; or &#x60;Pending&#x60; status.  **Note:** - The Payment Schedules feature is in the **Early Adopter** phase. We are actively soliciting feedback from a small set of early adopters before releasing it as generally available. To manage and access this feature through the self-service interface, see [Manage Features](https://knowledgecenter.zuora.com/Zuora_Payments/Payments_Settings/Manage_Features) in the Knowledge Center. - This operation is only available if you have [Invoice Settlement](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/Invoice_Settlement) enabled. 
     * @param poSTRetryPaymentScheduleItemRequest  (required)
     * @return RetryPaymentScheduleItemRequestBuilder
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td>  </td><td>  * Content-Encoding - This header is returned if you specify the &#x60;Accept-Encoding: gzip&#x60; request header and the response contains over 1000 bytes of data. Note that only the following MIME types support gzipped responses:   - &#x60;application/json&#x60;   - &#x60;application/xml&#x60;   - &#x60;text/html&#x60;   - &#x60;text/csv&#x60;   - &#x60;text/plain&#x60;  <br>  * RateLimit-Limit - The request limit quota for the time window closest to exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Remaining - The number of requests remaining in the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Reset - The number of seconds until the quota resets for the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Zuora-Request-Id - The Zuora internal identifier of the API call. You cannot control the value of this header.  <br>  * Zuora-Track-Id - A custom identifier for tracing the API call. If you specified a tracing identifier in the request headers, Zuora returns the same tracing identifier. Otherwise, Zuora does not set this header.  <br>  </td></tr>
     </table>
     */
    public RetryPaymentScheduleItemRequestBuilder retryPaymentScheduleItem() throws IllegalArgumentException {
        return new RetryPaymentScheduleItemRequestBuilder();
    }
    private okhttp3.Call skipPaymentScheduleItemCall(String itemId, String acceptEncoding, String contentEncoding, String authorization, String zuoraTrackId, String zuoraEntityIds, String zuoraOrgIds, String zuoraVersion, final ApiCallback _callback) throws ApiException {
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
        String localVarPath = "/v1/payment-schedule-items/{item-id}/skip"
            .replace("{" + "item-id" + "}", localVarApiClient.escapeString(itemId.toString()));

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

        if (zuoraVersion != null) {
            localVarHeaderParams.put("zuora-version", localVarApiClient.parameterToString(zuoraVersion));
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
        return localVarApiClient.buildCall(basePath, localVarPath, "PUT", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call skipPaymentScheduleItemValidateBeforeCall(String itemId, String acceptEncoding, String contentEncoding, String authorization, String zuoraTrackId, String zuoraEntityIds, String zuoraOrgIds, String zuoraVersion, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'itemId' is set
        if (itemId == null) {
            throw new ApiException("Missing the required parameter 'itemId' when calling skipPaymentScheduleItem(Async)");
        }

        return skipPaymentScheduleItemCall(itemId, acceptEncoding, contentEncoding, authorization, zuoraTrackId, zuoraEntityIds, zuoraOrgIds, zuoraVersion, _callback);

    }


    private ApiResponse<PUTSkipPaymentScheduleItemResponse> skipPaymentScheduleItemWithHttpInfo(String itemId, String acceptEncoding, String contentEncoding, String authorization, String zuoraTrackId, String zuoraEntityIds, String zuoraOrgIds, String zuoraVersion) throws ApiException {
        okhttp3.Call localVarCall = skipPaymentScheduleItemValidateBeforeCall(itemId, acceptEncoding, contentEncoding, authorization, zuoraTrackId, zuoraEntityIds, zuoraOrgIds, zuoraVersion, null);
        Type localVarReturnType = new TypeToken<PUTSkipPaymentScheduleItemResponse>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    private okhttp3.Call skipPaymentScheduleItemAsync(String itemId, String acceptEncoding, String contentEncoding, String authorization, String zuoraTrackId, String zuoraEntityIds, String zuoraOrgIds, String zuoraVersion, final ApiCallback<PUTSkipPaymentScheduleItemResponse> _callback) throws ApiException {

        okhttp3.Call localVarCall = skipPaymentScheduleItemValidateBeforeCall(itemId, acceptEncoding, contentEncoding, authorization, zuoraTrackId, zuoraEntityIds, zuoraOrgIds, zuoraVersion, _callback);
        Type localVarReturnType = new TypeToken<PUTSkipPaymentScheduleItemResponse>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    public class SkipPaymentScheduleItemRequestBuilder {
        private final String itemId;
        private String acceptEncoding;
        private String contentEncoding;
        private String authorization;
        private String zuoraTrackId;
        private String zuoraEntityIds;
        private String zuoraOrgIds;
        private String zuoraVersion;

        private SkipPaymentScheduleItemRequestBuilder(String itemId) {
            this.itemId = itemId;
        }

        /**
         * Set acceptEncoding
         * @param acceptEncoding Include the &#x60;Accept-Encoding: gzip&#x60; header to compress responses as a gzipped file. It can significantly reduce the bandwidth required for a response.   If specified, Zuora automatically compresses responses that contain over 1000 bytes of data, and the response contains a &#x60;Content-Encoding&#x60; header with the compression algorithm so that your client can decompress it.  (optional)
         * @return SkipPaymentScheduleItemRequestBuilder
         */
        public SkipPaymentScheduleItemRequestBuilder acceptEncoding(String acceptEncoding) {
            this.acceptEncoding = acceptEncoding;
            return this;
        }
        
        /**
         * Set contentEncoding
         * @param contentEncoding Include the &#x60;Content-Encoding: gzip&#x60; header to compress a request. With this header specified, you should upload a gzipped file for the request payload instead of sending the JSON payload.  (optional)
         * @return SkipPaymentScheduleItemRequestBuilder
         */
        public SkipPaymentScheduleItemRequestBuilder contentEncoding(String contentEncoding) {
            this.contentEncoding = contentEncoding;
            return this;
        }
        
        /**
         * Set authorization
         * @param authorization The value is in the &#x60;Bearer {token}&#x60; format where {token} is a valid OAuth token generated by calling [Create an OAuth token](https://developer.zuora.com/api-references/api/operation/createToken).  (optional)
         * @return SkipPaymentScheduleItemRequestBuilder
         */
        public SkipPaymentScheduleItemRequestBuilder authorization(String authorization) {
            this.authorization = authorization;
            return this;
        }
        
        /**
         * Set zuoraTrackId
         * @param zuoraTrackId A custom identifier for tracing the API call. If you set a value for this header, Zuora returns the same value in the response headers. This header enables you to associate your system process identifiers with Zuora API calls, to assist with troubleshooting in the event of an issue.  The value of this field must use the US-ASCII character set and must not include any of the following characters: colon (&#x60;:&#x60;), semicolon (&#x60;;&#x60;), double quote (&#x60;\&quot;&#x60;), and quote (&#x60;&#39;&#x60;).  (optional)
         * @return SkipPaymentScheduleItemRequestBuilder
         */
        public SkipPaymentScheduleItemRequestBuilder zuoraTrackId(String zuoraTrackId) {
            this.zuoraTrackId = zuoraTrackId;
            return this;
        }
        
        /**
         * Set zuoraEntityIds
         * @param zuoraEntityIds An entity ID. If you have [Zuora Multi-entity](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Multi-entity) enabled and the OAuth token is valid for more than one entity, you must use this header to specify which entity to perform the operation in. If the OAuth token is only valid for a single entity, or you do not have Zuora Multi-entity enabled, you do not need to set this header.  (optional)
         * @return SkipPaymentScheduleItemRequestBuilder
         */
        public SkipPaymentScheduleItemRequestBuilder zuoraEntityIds(String zuoraEntityIds) {
            this.zuoraEntityIds = zuoraEntityIds;
            return this;
        }
        
        /**
         * Set zuoraOrgIds
         * @param zuoraOrgIds Comma separated IDs. If you have &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Central_Platform/Multi-Org\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Zuora Multi-Org&lt;/a&gt; enabled,  you can use this header to specify which orgs to perform the operation in. If you do not have Zuora Multi-Org enabled, you should not set this header.  The IDs must be a sub-set of the user&#39;s accessible orgs. If you specify an org that the user does not have access to, the operation fails.  If the header is not set, the operation is performed in scope of the user&#39;s accessible orgs.  (optional)
         * @return SkipPaymentScheduleItemRequestBuilder
         */
        public SkipPaymentScheduleItemRequestBuilder zuoraOrgIds(String zuoraOrgIds) {
            this.zuoraOrgIds = zuoraOrgIds;
            return this;
        }
        
        /**
         * Set zuoraVersion
         * @param zuoraVersion The minor version of the Zuora REST API. See [Minor Version](https://developer.zuora.com/api-references/api/overview/#section/API-Versions/Minor-Version) for information about REST API version control.   This header affects the availability of the following response fields: - &#x60;paymentId&#x60;  (optional)
         * @return SkipPaymentScheduleItemRequestBuilder
         */
        public SkipPaymentScheduleItemRequestBuilder zuoraVersion(String zuoraVersion) {
            this.zuoraVersion = zuoraVersion;
            return this;
        }
        
        /**
         * Build call for skipPaymentScheduleItem
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
            return skipPaymentScheduleItemCall(itemId, acceptEncoding, contentEncoding, authorization, zuoraTrackId, zuoraEntityIds, zuoraOrgIds, zuoraVersion, _callback);
        }


        /**
         * Execute skipPaymentScheduleItem request
         * @return PUTSkipPaymentScheduleItemResponse
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td>  </td><td>  * Content-Encoding - This header is returned if you specify the &#x60;Accept-Encoding: gzip&#x60; request header and the response contains over 1000 bytes of data. Note that only the following MIME types support gzipped responses:   - &#x60;application/json&#x60;   - &#x60;application/xml&#x60;   - &#x60;text/html&#x60;   - &#x60;text/csv&#x60;   - &#x60;text/plain&#x60;  <br>  * RateLimit-Limit - The request limit quota for the time window closest to exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Remaining - The number of requests remaining in the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Reset - The number of seconds until the quota resets for the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Zuora-Request-Id - The Zuora internal identifier of the API call. You cannot control the value of this header.  <br>  * Zuora-Track-Id - A custom identifier for tracing the API call. If you specified a tracing identifier in the request headers, Zuora returns the same tracing identifier. Otherwise, Zuora does not set this header.  <br>  </td></tr>
         </table>
         */
        public PUTSkipPaymentScheduleItemResponse execute() throws ApiException {
            ApiResponse<PUTSkipPaymentScheduleItemResponse> localVarResp = skipPaymentScheduleItemWithHttpInfo(itemId, acceptEncoding, contentEncoding, authorization, zuoraTrackId, zuoraEntityIds, zuoraOrgIds, zuoraVersion);
            return localVarResp.getResponseBody();
        }

        /**
         * Execute skipPaymentScheduleItem request with HTTP info returned
         * @return ApiResponse&lt;PUTSkipPaymentScheduleItemResponse&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td>  </td><td>  * Content-Encoding - This header is returned if you specify the &#x60;Accept-Encoding: gzip&#x60; request header and the response contains over 1000 bytes of data. Note that only the following MIME types support gzipped responses:   - &#x60;application/json&#x60;   - &#x60;application/xml&#x60;   - &#x60;text/html&#x60;   - &#x60;text/csv&#x60;   - &#x60;text/plain&#x60;  <br>  * RateLimit-Limit - The request limit quota for the time window closest to exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Remaining - The number of requests remaining in the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Reset - The number of seconds until the quota resets for the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Zuora-Request-Id - The Zuora internal identifier of the API call. You cannot control the value of this header.  <br>  * Zuora-Track-Id - A custom identifier for tracing the API call. If you specified a tracing identifier in the request headers, Zuora returns the same tracing identifier. Otherwise, Zuora does not set this header.  <br>  </td></tr>
         </table>
         */
        public ApiResponse<PUTSkipPaymentScheduleItemResponse> executeWithHttpInfo() throws ApiException {
            return skipPaymentScheduleItemWithHttpInfo(itemId, acceptEncoding, contentEncoding, authorization, zuoraTrackId, zuoraEntityIds, zuoraOrgIds, zuoraVersion);
        }

        /**
         * Execute skipPaymentScheduleItem request (asynchronously)
         * @param _callback The callback to be executed when the API call finishes
         * @return The request call
         * @throws ApiException If fail to process the API call, e.g. serializing the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td>  </td><td>  * Content-Encoding - This header is returned if you specify the &#x60;Accept-Encoding: gzip&#x60; request header and the response contains over 1000 bytes of data. Note that only the following MIME types support gzipped responses:   - &#x60;application/json&#x60;   - &#x60;application/xml&#x60;   - &#x60;text/html&#x60;   - &#x60;text/csv&#x60;   - &#x60;text/plain&#x60;  <br>  * RateLimit-Limit - The request limit quota for the time window closest to exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Remaining - The number of requests remaining in the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Reset - The number of seconds until the quota resets for the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Zuora-Request-Id - The Zuora internal identifier of the API call. You cannot control the value of this header.  <br>  * Zuora-Track-Id - A custom identifier for tracing the API call. If you specified a tracing identifier in the request headers, Zuora returns the same tracing identifier. Otherwise, Zuora does not set this header.  <br>  </td></tr>
         </table>
         */
        public okhttp3.Call executeAsync(final ApiCallback<PUTSkipPaymentScheduleItemResponse> _callback) throws ApiException {
            return skipPaymentScheduleItemAsync(itemId, acceptEncoding, contentEncoding, authorization, zuoraTrackId, zuoraEntityIds, zuoraOrgIds, zuoraVersion, _callback);
        }
    }

    /**
     * Skip a payment schedule item
     * Skips a payment schedule item by ID. The skipped payment schedule item will turn to the &#x60;canceled&#x60; status, and a new item will be scheduled on the next recurring date after the last existing scheduled date.  **Note:** - Only payment schedule items in recurring payment schedules can be skipped, and the item must be in the &#x60;pending&#x60; status. - The Payment Schedules feature is in the **Early Adopter** phase. We are actively soliciting feedback from a small set of early adopters before releasing it as generally available. To manage and access this feature through the self-service interface, see [Manage Features](https://knowledgecenter.zuora.com/Zuora_Payments/Payments_Settings/Manage_Features) in the Knowledge Center. - This operation is only available if you have [Invoice Settlement](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/Invoice_Settlement) enabled. 
     * @param itemId The unique ID of a payment schedule item.     (required)
     * @return SkipPaymentScheduleItemRequestBuilder
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td>  </td><td>  * Content-Encoding - This header is returned if you specify the &#x60;Accept-Encoding: gzip&#x60; request header and the response contains over 1000 bytes of data. Note that only the following MIME types support gzipped responses:   - &#x60;application/json&#x60;   - &#x60;application/xml&#x60;   - &#x60;text/html&#x60;   - &#x60;text/csv&#x60;   - &#x60;text/plain&#x60;  <br>  * RateLimit-Limit - The request limit quota for the time window closest to exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Remaining - The number of requests remaining in the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Reset - The number of seconds until the quota resets for the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Zuora-Request-Id - The Zuora internal identifier of the API call. You cannot control the value of this header.  <br>  * Zuora-Track-Id - A custom identifier for tracing the API call. If you specified a tracing identifier in the request headers, Zuora returns the same tracing identifier. Otherwise, Zuora does not set this header.  <br>  </td></tr>
     </table>
     */
    public SkipPaymentScheduleItemRequestBuilder skipPaymentScheduleItem(String itemId) throws IllegalArgumentException {
        if (itemId == null) throw new IllegalArgumentException("\"itemId\" is required but got null");
            

        return new SkipPaymentScheduleItemRequestBuilder(itemId);
    }
}
