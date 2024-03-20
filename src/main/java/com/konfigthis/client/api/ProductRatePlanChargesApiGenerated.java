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


import com.konfigthis.client.model.GETProductRatePlanChargeResponse;
import com.konfigthis.client.model.ProxyCreateOrModifyDeliverySchedule;
import com.konfigthis.client.model.ProxyCreateOrModifyProductRatePlanChargeChargeModelConfiguration;
import com.konfigthis.client.model.ProxyCreateOrModifyProductRatePlanChargeTierData;
import com.konfigthis.client.model.ProxyCreateOrModifyResponse;
import com.konfigthis.client.model.ProxyCreateProductRatePlanCharge;
import com.konfigthis.client.model.ProxyDeleteResponse;
import com.konfigthis.client.model.ProxyGetProductRatePlanCharge;
import com.konfigthis.client.model.ProxyModifyProductRatePlanCharge;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ws.rs.core.GenericType;

public class ProductRatePlanChargesApiGenerated {
    private ApiClient localVarApiClient;
    private int localHostIndex;
    private String localCustomBaseUrl;

    public ProductRatePlanChargesApiGenerated() throws IllegalArgumentException {
        this(Configuration.getDefaultApiClient());
    }

    public ProductRatePlanChargesApiGenerated(ApiClient apiClient) throws IllegalArgumentException {
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

    private okhttp3.Call dELETEProductRatePlanChargeCall(String id, String acceptEncoding, String contentEncoding, String authorization, String zuoraEntityIds, String zuoraOrgIds, String zuoraTrackId, final ApiCallback _callback) throws ApiException {
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
        String localVarPath = "/v1/object/product-rate-plan-charge/{id}"
            .replace("{" + "id" + "}", localVarApiClient.escapeString(id.toString()));

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

        if (zuoraEntityIds != null) {
            localVarHeaderParams.put("Zuora-Entity-Ids", localVarApiClient.parameterToString(zuoraEntityIds));
        }

        if (zuoraOrgIds != null) {
            localVarHeaderParams.put("Zuora-Org-Ids", localVarApiClient.parameterToString(zuoraOrgIds));
        }

        if (zuoraTrackId != null) {
            localVarHeaderParams.put("Zuora-Track-Id", localVarApiClient.parameterToString(zuoraTrackId));
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
        return localVarApiClient.buildCall(basePath, localVarPath, "DELETE", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call dELETEProductRatePlanChargeValidateBeforeCall(String id, String acceptEncoding, String contentEncoding, String authorization, String zuoraEntityIds, String zuoraOrgIds, String zuoraTrackId, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new ApiException("Missing the required parameter 'id' when calling dELETEProductRatePlanCharge(Async)");
        }

        return dELETEProductRatePlanChargeCall(id, acceptEncoding, contentEncoding, authorization, zuoraEntityIds, zuoraOrgIds, zuoraTrackId, _callback);

    }


    private ApiResponse<ProxyDeleteResponse> dELETEProductRatePlanChargeWithHttpInfo(String id, String acceptEncoding, String contentEncoding, String authorization, String zuoraEntityIds, String zuoraOrgIds, String zuoraTrackId) throws ApiException {
        okhttp3.Call localVarCall = dELETEProductRatePlanChargeValidateBeforeCall(id, acceptEncoding, contentEncoding, authorization, zuoraEntityIds, zuoraOrgIds, zuoraTrackId, null);
        Type localVarReturnType = new TypeToken<ProxyDeleteResponse>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    private okhttp3.Call dELETEProductRatePlanChargeAsync(String id, String acceptEncoding, String contentEncoding, String authorization, String zuoraEntityIds, String zuoraOrgIds, String zuoraTrackId, final ApiCallback<ProxyDeleteResponse> _callback) throws ApiException {

        okhttp3.Call localVarCall = dELETEProductRatePlanChargeValidateBeforeCall(id, acceptEncoding, contentEncoding, authorization, zuoraEntityIds, zuoraOrgIds, zuoraTrackId, _callback);
        Type localVarReturnType = new TypeToken<ProxyDeleteResponse>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    public class DELETEProductRatePlanChargeRequestBuilder {
        private final String id;
        private String acceptEncoding;
        private String contentEncoding;
        private String authorization;
        private String zuoraEntityIds;
        private String zuoraOrgIds;
        private String zuoraTrackId;

        private DELETEProductRatePlanChargeRequestBuilder(String id) {
            this.id = id;
        }

        /**
         * Set acceptEncoding
         * @param acceptEncoding Include the &#x60;Accept-Encoding: gzip&#x60; header to compress responses as a gzipped file. It can significantly reduce the bandwidth required for a response.   If specified, Zuora automatically compresses responses that contain over 1000 bytes of data, and the response contains a &#x60;Content-Encoding&#x60; header with the compression algorithm so that your client can decompress it.  (optional)
         * @return DELETEProductRatePlanChargeRequestBuilder
         */
        public DELETEProductRatePlanChargeRequestBuilder acceptEncoding(String acceptEncoding) {
            this.acceptEncoding = acceptEncoding;
            return this;
        }
        
        /**
         * Set contentEncoding
         * @param contentEncoding Include the &#x60;Content-Encoding: gzip&#x60; header to compress a request. With this header specified, you should upload a gzipped file for the request payload instead of sending the JSON payload.  (optional)
         * @return DELETEProductRatePlanChargeRequestBuilder
         */
        public DELETEProductRatePlanChargeRequestBuilder contentEncoding(String contentEncoding) {
            this.contentEncoding = contentEncoding;
            return this;
        }
        
        /**
         * Set authorization
         * @param authorization The value is in the &#x60;Bearer {token}&#x60; format where {token} is a valid OAuth token generated by calling [Create an OAuth token](https://developer.zuora.com/api-references/api/operation/createToken).  (optional)
         * @return DELETEProductRatePlanChargeRequestBuilder
         */
        public DELETEProductRatePlanChargeRequestBuilder authorization(String authorization) {
            this.authorization = authorization;
            return this;
        }
        
        /**
         * Set zuoraEntityIds
         * @param zuoraEntityIds An entity ID. If you have [Zuora Multi-entity](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Multi-entity) enabled and the OAuth token is valid for more than one entity, you must use this header to specify which entity to perform the operation in. If the OAuth token is only valid for a single entity, or you do not have Zuora Multi-entity enabled, you do not need to set this header.  (optional)
         * @return DELETEProductRatePlanChargeRequestBuilder
         */
        public DELETEProductRatePlanChargeRequestBuilder zuoraEntityIds(String zuoraEntityIds) {
            this.zuoraEntityIds = zuoraEntityIds;
            return this;
        }
        
        /**
         * Set zuoraOrgIds
         * @param zuoraOrgIds Comma separated IDs. If you have &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Central_Platform/Multi-Org\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Zuora Multi-Org&lt;/a&gt; enabled,  you can use this header to specify which orgs to perform the operation in. If you do not have Zuora Multi-Org enabled, you should not set this header.  The IDs must be a sub-set of the user&#39;s accessible orgs. If you specify an org that the user does not have access to, the operation fails.  If the header is not set, the operation is performed in scope of the user&#39;s accessible orgs.  (optional)
         * @return DELETEProductRatePlanChargeRequestBuilder
         */
        public DELETEProductRatePlanChargeRequestBuilder zuoraOrgIds(String zuoraOrgIds) {
            this.zuoraOrgIds = zuoraOrgIds;
            return this;
        }
        
        /**
         * Set zuoraTrackId
         * @param zuoraTrackId A custom identifier for tracing the API call. If you set a value for this header, Zuora returns the same value in the response headers. This header enables you to associate your system process identifiers with Zuora API calls, to assist with troubleshooting in the event of an issue.  The value of this field must use the US-ASCII character set and must not include any of the following characters: colon (&#x60;:&#x60;), semicolon (&#x60;;&#x60;), double quote (&#x60;\&quot;&#x60;), and quote (&#x60;&#39;&#x60;).  (optional)
         * @return DELETEProductRatePlanChargeRequestBuilder
         */
        public DELETEProductRatePlanChargeRequestBuilder zuoraTrackId(String zuoraTrackId) {
            this.zuoraTrackId = zuoraTrackId;
            return this;
        }
        
        /**
         * Build call for dELETEProductRatePlanCharge
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
            return dELETEProductRatePlanChargeCall(id, acceptEncoding, contentEncoding, authorization, zuoraEntityIds, zuoraOrgIds, zuoraTrackId, _callback);
        }


        /**
         * Execute dELETEProductRatePlanCharge request
         * @return ProxyDeleteResponse
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td>  </td><td>  * Content-Encoding - This header is returned if you specify the &#x60;Accept-Encoding: gzip&#x60; request header and the response contains over 1000 bytes of data. Note that only the following MIME types support gzipped responses:   - &#x60;application/json&#x60;   - &#x60;application/xml&#x60;   - &#x60;text/html&#x60;   - &#x60;text/csv&#x60;   - &#x60;text/plain&#x60;  <br>  * RateLimit-Limit - The request limit quota for the time window closest to exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Remaining - The number of requests remaining in the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Reset - The number of seconds until the quota resets for the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Zuora-Request-Id - The Zuora internal identifier of the API call. You cannot control the value of this header.  <br>  * Zuora-Track-Id - A custom identifier for tracing the API call. If you specified a tracing identifier in the request headers, Zuora returns the same tracing identifier. Otherwise, Zuora does not set this header.  <br>  </td></tr>
         </table>
         */
        public ProxyDeleteResponse execute() throws ApiException {
            ApiResponse<ProxyDeleteResponse> localVarResp = dELETEProductRatePlanChargeWithHttpInfo(id, acceptEncoding, contentEncoding, authorization, zuoraEntityIds, zuoraOrgIds, zuoraTrackId);
            return localVarResp.getResponseBody();
        }

        /**
         * Execute dELETEProductRatePlanCharge request with HTTP info returned
         * @return ApiResponse&lt;ProxyDeleteResponse&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td>  </td><td>  * Content-Encoding - This header is returned if you specify the &#x60;Accept-Encoding: gzip&#x60; request header and the response contains over 1000 bytes of data. Note that only the following MIME types support gzipped responses:   - &#x60;application/json&#x60;   - &#x60;application/xml&#x60;   - &#x60;text/html&#x60;   - &#x60;text/csv&#x60;   - &#x60;text/plain&#x60;  <br>  * RateLimit-Limit - The request limit quota for the time window closest to exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Remaining - The number of requests remaining in the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Reset - The number of seconds until the quota resets for the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Zuora-Request-Id - The Zuora internal identifier of the API call. You cannot control the value of this header.  <br>  * Zuora-Track-Id - A custom identifier for tracing the API call. If you specified a tracing identifier in the request headers, Zuora returns the same tracing identifier. Otherwise, Zuora does not set this header.  <br>  </td></tr>
         </table>
         */
        public ApiResponse<ProxyDeleteResponse> executeWithHttpInfo() throws ApiException {
            return dELETEProductRatePlanChargeWithHttpInfo(id, acceptEncoding, contentEncoding, authorization, zuoraEntityIds, zuoraOrgIds, zuoraTrackId);
        }

        /**
         * Execute dELETEProductRatePlanCharge request (asynchronously)
         * @param _callback The callback to be executed when the API call finishes
         * @return The request call
         * @throws ApiException If fail to process the API call, e.g. serializing the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td>  </td><td>  * Content-Encoding - This header is returned if you specify the &#x60;Accept-Encoding: gzip&#x60; request header and the response contains over 1000 bytes of data. Note that only the following MIME types support gzipped responses:   - &#x60;application/json&#x60;   - &#x60;application/xml&#x60;   - &#x60;text/html&#x60;   - &#x60;text/csv&#x60;   - &#x60;text/plain&#x60;  <br>  * RateLimit-Limit - The request limit quota for the time window closest to exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Remaining - The number of requests remaining in the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Reset - The number of seconds until the quota resets for the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Zuora-Request-Id - The Zuora internal identifier of the API call. You cannot control the value of this header.  <br>  * Zuora-Track-Id - A custom identifier for tracing the API call. If you specified a tracing identifier in the request headers, Zuora returns the same tracing identifier. Otherwise, Zuora does not set this header.  <br>  </td></tr>
         </table>
         */
        public okhttp3.Call executeAsync(final ApiCallback<ProxyDeleteResponse> _callback) throws ApiException {
            return dELETEProductRatePlanChargeAsync(id, acceptEncoding, contentEncoding, authorization, zuoraEntityIds, zuoraOrgIds, zuoraTrackId, _callback);
        }
    }

    /**
     * CRUD: Delete a product rate plan charge
     * Deletes a product rate plan charge. 
     * @param id The unique ID of the product rate plan charge to be deleted. For example, 2c93808457d787030157e031fcd34e19.  (required)
     * @return DELETEProductRatePlanChargeRequestBuilder
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td>  </td><td>  * Content-Encoding - This header is returned if you specify the &#x60;Accept-Encoding: gzip&#x60; request header and the response contains over 1000 bytes of data. Note that only the following MIME types support gzipped responses:   - &#x60;application/json&#x60;   - &#x60;application/xml&#x60;   - &#x60;text/html&#x60;   - &#x60;text/csv&#x60;   - &#x60;text/plain&#x60;  <br>  * RateLimit-Limit - The request limit quota for the time window closest to exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Remaining - The number of requests remaining in the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Reset - The number of seconds until the quota resets for the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Zuora-Request-Id - The Zuora internal identifier of the API call. You cannot control the value of this header.  <br>  * Zuora-Track-Id - A custom identifier for tracing the API call. If you specified a tracing identifier in the request headers, Zuora returns the same tracing identifier. Otherwise, Zuora does not set this header.  <br>  </td></tr>
     </table>
     */
    public DELETEProductRatePlanChargeRequestBuilder dELETEProductRatePlanCharge(String id) throws IllegalArgumentException {
        if (id == null) throw new IllegalArgumentException("\"id\" is required but got null");
            

        return new DELETEProductRatePlanChargeRequestBuilder(id);
    }
    private okhttp3.Call gETProductRatePlanChargeCall(String id, String acceptEncoding, String contentEncoding, String authorization, String zuoraEntityIds, String zuoraOrgIds, String zuoraTrackId, String xZuoraWSDLVersion, String fields, final ApiCallback _callback) throws ApiException {
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
        String localVarPath = "/v1/object/product-rate-plan-charge/{id}"
            .replace("{" + "id" + "}", localVarApiClient.escapeString(id.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        if (fields != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("fields", fields));
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

        if (zuoraEntityIds != null) {
            localVarHeaderParams.put("Zuora-Entity-Ids", localVarApiClient.parameterToString(zuoraEntityIds));
        }

        if (zuoraOrgIds != null) {
            localVarHeaderParams.put("Zuora-Org-Ids", localVarApiClient.parameterToString(zuoraOrgIds));
        }

        if (zuoraTrackId != null) {
            localVarHeaderParams.put("Zuora-Track-Id", localVarApiClient.parameterToString(zuoraTrackId));
        }

        if (xZuoraWSDLVersion != null) {
            localVarHeaderParams.put("X-Zuora-WSDL-Version", localVarApiClient.parameterToString(xZuoraWSDLVersion));
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
    private okhttp3.Call gETProductRatePlanChargeValidateBeforeCall(String id, String acceptEncoding, String contentEncoding, String authorization, String zuoraEntityIds, String zuoraOrgIds, String zuoraTrackId, String xZuoraWSDLVersion, String fields, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new ApiException("Missing the required parameter 'id' when calling gETProductRatePlanCharge(Async)");
        }

        return gETProductRatePlanChargeCall(id, acceptEncoding, contentEncoding, authorization, zuoraEntityIds, zuoraOrgIds, zuoraTrackId, xZuoraWSDLVersion, fields, _callback);

    }


    private ApiResponse<ProxyGetProductRatePlanCharge> gETProductRatePlanChargeWithHttpInfo(String id, String acceptEncoding, String contentEncoding, String authorization, String zuoraEntityIds, String zuoraOrgIds, String zuoraTrackId, String xZuoraWSDLVersion, String fields) throws ApiException {
        okhttp3.Call localVarCall = gETProductRatePlanChargeValidateBeforeCall(id, acceptEncoding, contentEncoding, authorization, zuoraEntityIds, zuoraOrgIds, zuoraTrackId, xZuoraWSDLVersion, fields, null);
        Type localVarReturnType = new TypeToken<ProxyGetProductRatePlanCharge>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    private okhttp3.Call gETProductRatePlanChargeAsync(String id, String acceptEncoding, String contentEncoding, String authorization, String zuoraEntityIds, String zuoraOrgIds, String zuoraTrackId, String xZuoraWSDLVersion, String fields, final ApiCallback<ProxyGetProductRatePlanCharge> _callback) throws ApiException {

        okhttp3.Call localVarCall = gETProductRatePlanChargeValidateBeforeCall(id, acceptEncoding, contentEncoding, authorization, zuoraEntityIds, zuoraOrgIds, zuoraTrackId, xZuoraWSDLVersion, fields, _callback);
        Type localVarReturnType = new TypeToken<ProxyGetProductRatePlanCharge>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    public class GETProductRatePlanChargeRequestBuilder {
        private final String id;
        private String acceptEncoding;
        private String contentEncoding;
        private String authorization;
        private String zuoraEntityIds;
        private String zuoraOrgIds;
        private String zuoraTrackId;
        private String xZuoraWSDLVersion;
        private String fields;

        private GETProductRatePlanChargeRequestBuilder(String id) {
            this.id = id;
        }

        /**
         * Set acceptEncoding
         * @param acceptEncoding Include the &#x60;Accept-Encoding: gzip&#x60; header to compress responses as a gzipped file. It can significantly reduce the bandwidth required for a response.   If specified, Zuora automatically compresses responses that contain over 1000 bytes of data, and the response contains a &#x60;Content-Encoding&#x60; header with the compression algorithm so that your client can decompress it.  (optional)
         * @return GETProductRatePlanChargeRequestBuilder
         */
        public GETProductRatePlanChargeRequestBuilder acceptEncoding(String acceptEncoding) {
            this.acceptEncoding = acceptEncoding;
            return this;
        }
        
        /**
         * Set contentEncoding
         * @param contentEncoding Include the &#x60;Content-Encoding: gzip&#x60; header to compress a request. With this header specified, you should upload a gzipped file for the request payload instead of sending the JSON payload.  (optional)
         * @return GETProductRatePlanChargeRequestBuilder
         */
        public GETProductRatePlanChargeRequestBuilder contentEncoding(String contentEncoding) {
            this.contentEncoding = contentEncoding;
            return this;
        }
        
        /**
         * Set authorization
         * @param authorization The value is in the &#x60;Bearer {token}&#x60; format where {token} is a valid OAuth token generated by calling [Create an OAuth token](https://developer.zuora.com/api-references/api/operation/createToken).  (optional)
         * @return GETProductRatePlanChargeRequestBuilder
         */
        public GETProductRatePlanChargeRequestBuilder authorization(String authorization) {
            this.authorization = authorization;
            return this;
        }
        
        /**
         * Set zuoraEntityIds
         * @param zuoraEntityIds An entity ID. If you have [Zuora Multi-entity](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Multi-entity) enabled and the OAuth token is valid for more than one entity, you must use this header to specify which entity to perform the operation in. If the OAuth token is only valid for a single entity, or you do not have Zuora Multi-entity enabled, you do not need to set this header.  (optional)
         * @return GETProductRatePlanChargeRequestBuilder
         */
        public GETProductRatePlanChargeRequestBuilder zuoraEntityIds(String zuoraEntityIds) {
            this.zuoraEntityIds = zuoraEntityIds;
            return this;
        }
        
        /**
         * Set zuoraOrgIds
         * @param zuoraOrgIds Comma separated IDs. If you have &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Central_Platform/Multi-Org\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Zuora Multi-Org&lt;/a&gt; enabled,  you can use this header to specify which orgs to perform the operation in. If you do not have Zuora Multi-Org enabled, you should not set this header.  The IDs must be a sub-set of the user&#39;s accessible orgs. If you specify an org that the user does not have access to, the operation fails.  If the header is not set, the operation is performed in scope of the user&#39;s accessible orgs.  (optional)
         * @return GETProductRatePlanChargeRequestBuilder
         */
        public GETProductRatePlanChargeRequestBuilder zuoraOrgIds(String zuoraOrgIds) {
            this.zuoraOrgIds = zuoraOrgIds;
            return this;
        }
        
        /**
         * Set zuoraTrackId
         * @param zuoraTrackId A custom identifier for tracing the API call. If you set a value for this header, Zuora returns the same value in the response headers. This header enables you to associate your system process identifiers with Zuora API calls, to assist with troubleshooting in the event of an issue.  The value of this field must use the US-ASCII character set and must not include any of the following characters: colon (&#x60;:&#x60;), semicolon (&#x60;;&#x60;), double quote (&#x60;\&quot;&#x60;), and quote (&#x60;&#39;&#x60;).  (optional)
         * @return GETProductRatePlanChargeRequestBuilder
         */
        public GETProductRatePlanChargeRequestBuilder zuoraTrackId(String zuoraTrackId) {
            this.zuoraTrackId = zuoraTrackId;
            return this;
        }
        
        /**
         * Set xZuoraWSDLVersion
         * @param xZuoraWSDLVersion Zuora WSDL version number.  (optional, default to 79)
         * @return GETProductRatePlanChargeRequestBuilder
         */
        public GETProductRatePlanChargeRequestBuilder xZuoraWSDLVersion(String xZuoraWSDLVersion) {
            this.xZuoraWSDLVersion = xZuoraWSDLVersion;
            return this;
        }
        
        /**
         * Set fields
         * @param fields Object fields to return (optional)
         * @return GETProductRatePlanChargeRequestBuilder
         */
        public GETProductRatePlanChargeRequestBuilder fields(String fields) {
            this.fields = fields;
            return this;
        }
        
        /**
         * Build call for gETProductRatePlanCharge
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
            return gETProductRatePlanChargeCall(id, acceptEncoding, contentEncoding, authorization, zuoraEntityIds, zuoraOrgIds, zuoraTrackId, xZuoraWSDLVersion, fields, _callback);
        }


        /**
         * Execute gETProductRatePlanCharge request
         * @return ProxyGetProductRatePlanCharge
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td>  </td><td>  * Content-Encoding - This header is returned if you specify the &#x60;Accept-Encoding: gzip&#x60; request header and the response contains over 1000 bytes of data. Note that only the following MIME types support gzipped responses:   - &#x60;application/json&#x60;   - &#x60;application/xml&#x60;   - &#x60;text/html&#x60;   - &#x60;text/csv&#x60;   - &#x60;text/plain&#x60;  <br>  * RateLimit-Limit - The request limit quota for the time window closest to exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Remaining - The number of requests remaining in the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Reset - The number of seconds until the quota resets for the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Zuora-Request-Id - The Zuora internal identifier of the API call. You cannot control the value of this header.  <br>  * Zuora-Track-Id - A custom identifier for tracing the API call. If you specified a tracing identifier in the request headers, Zuora returns the same tracing identifier. Otherwise, Zuora does not set this header.  <br>  </td></tr>
         </table>
         */
        public ProxyGetProductRatePlanCharge execute() throws ApiException {
            ApiResponse<ProxyGetProductRatePlanCharge> localVarResp = gETProductRatePlanChargeWithHttpInfo(id, acceptEncoding, contentEncoding, authorization, zuoraEntityIds, zuoraOrgIds, zuoraTrackId, xZuoraWSDLVersion, fields);
            return localVarResp.getResponseBody();
        }

        /**
         * Execute gETProductRatePlanCharge request with HTTP info returned
         * @return ApiResponse&lt;ProxyGetProductRatePlanCharge&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td>  </td><td>  * Content-Encoding - This header is returned if you specify the &#x60;Accept-Encoding: gzip&#x60; request header and the response contains over 1000 bytes of data. Note that only the following MIME types support gzipped responses:   - &#x60;application/json&#x60;   - &#x60;application/xml&#x60;   - &#x60;text/html&#x60;   - &#x60;text/csv&#x60;   - &#x60;text/plain&#x60;  <br>  * RateLimit-Limit - The request limit quota for the time window closest to exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Remaining - The number of requests remaining in the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Reset - The number of seconds until the quota resets for the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Zuora-Request-Id - The Zuora internal identifier of the API call. You cannot control the value of this header.  <br>  * Zuora-Track-Id - A custom identifier for tracing the API call. If you specified a tracing identifier in the request headers, Zuora returns the same tracing identifier. Otherwise, Zuora does not set this header.  <br>  </td></tr>
         </table>
         */
        public ApiResponse<ProxyGetProductRatePlanCharge> executeWithHttpInfo() throws ApiException {
            return gETProductRatePlanChargeWithHttpInfo(id, acceptEncoding, contentEncoding, authorization, zuoraEntityIds, zuoraOrgIds, zuoraTrackId, xZuoraWSDLVersion, fields);
        }

        /**
         * Execute gETProductRatePlanCharge request (asynchronously)
         * @param _callback The callback to be executed when the API call finishes
         * @return The request call
         * @throws ApiException If fail to process the API call, e.g. serializing the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td>  </td><td>  * Content-Encoding - This header is returned if you specify the &#x60;Accept-Encoding: gzip&#x60; request header and the response contains over 1000 bytes of data. Note that only the following MIME types support gzipped responses:   - &#x60;application/json&#x60;   - &#x60;application/xml&#x60;   - &#x60;text/html&#x60;   - &#x60;text/csv&#x60;   - &#x60;text/plain&#x60;  <br>  * RateLimit-Limit - The request limit quota for the time window closest to exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Remaining - The number of requests remaining in the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Reset - The number of seconds until the quota resets for the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Zuora-Request-Id - The Zuora internal identifier of the API call. You cannot control the value of this header.  <br>  * Zuora-Track-Id - A custom identifier for tracing the API call. If you specified a tracing identifier in the request headers, Zuora returns the same tracing identifier. Otherwise, Zuora does not set this header.  <br>  </td></tr>
         </table>
         */
        public okhttp3.Call executeAsync(final ApiCallback<ProxyGetProductRatePlanCharge> _callback) throws ApiException {
            return gETProductRatePlanChargeAsync(id, acceptEncoding, contentEncoding, authorization, zuoraEntityIds, zuoraOrgIds, zuoraTrackId, xZuoraWSDLVersion, fields, _callback);
        }
    }

    /**
     * CRUD: Retrieve a product rate plan charge
     * 
     * @param id The unique ID of a product rate plan charge to be retrieved. For example, 2c93808457d787030157e031fcd34e19.  (required)
     * @return GETProductRatePlanChargeRequestBuilder
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td>  </td><td>  * Content-Encoding - This header is returned if you specify the &#x60;Accept-Encoding: gzip&#x60; request header and the response contains over 1000 bytes of data. Note that only the following MIME types support gzipped responses:   - &#x60;application/json&#x60;   - &#x60;application/xml&#x60;   - &#x60;text/html&#x60;   - &#x60;text/csv&#x60;   - &#x60;text/plain&#x60;  <br>  * RateLimit-Limit - The request limit quota for the time window closest to exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Remaining - The number of requests remaining in the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Reset - The number of seconds until the quota resets for the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Zuora-Request-Id - The Zuora internal identifier of the API call. You cannot control the value of this header.  <br>  * Zuora-Track-Id - A custom identifier for tracing the API call. If you specified a tracing identifier in the request headers, Zuora returns the same tracing identifier. Otherwise, Zuora does not set this header.  <br>  </td></tr>
     </table>
     */
    public GETProductRatePlanChargeRequestBuilder gETProductRatePlanCharge(String id) throws IllegalArgumentException {
        if (id == null) throw new IllegalArgumentException("\"id\" is required but got null");
            

        return new GETProductRatePlanChargeRequestBuilder(id);
    }
    private okhttp3.Call pOSTProductRatePlanChargeCall(ProxyCreateProductRatePlanCharge proxyCreateProductRatePlanCharge, String idempotencyKey, String acceptEncoding, String contentEncoding, String authorization, Boolean rejectUnknownFields, String zuoraEntityIds, String zuoraOrgIds, String zuoraTrackId, String xZuoraWSDLVersion, final ApiCallback _callback) throws ApiException {
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

        Object localVarPostBody = proxyCreateProductRatePlanCharge;

        // create path and map variables
        String localVarPath = "/v1/object/product-rate-plan-charge";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        if (rejectUnknownFields != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("rejectUnknownFields", rejectUnknownFields));
        }

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

        if (zuoraEntityIds != null) {
            localVarHeaderParams.put("Zuora-Entity-Ids", localVarApiClient.parameterToString(zuoraEntityIds));
        }

        if (zuoraOrgIds != null) {
            localVarHeaderParams.put("Zuora-Org-Ids", localVarApiClient.parameterToString(zuoraOrgIds));
        }

        if (zuoraTrackId != null) {
            localVarHeaderParams.put("Zuora-Track-Id", localVarApiClient.parameterToString(zuoraTrackId));
        }

        if (xZuoraWSDLVersion != null) {
            localVarHeaderParams.put("X-Zuora-WSDL-Version", localVarApiClient.parameterToString(xZuoraWSDLVersion));
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
    private okhttp3.Call pOSTProductRatePlanChargeValidateBeforeCall(ProxyCreateProductRatePlanCharge proxyCreateProductRatePlanCharge, String idempotencyKey, String acceptEncoding, String contentEncoding, String authorization, Boolean rejectUnknownFields, String zuoraEntityIds, String zuoraOrgIds, String zuoraTrackId, String xZuoraWSDLVersion, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'proxyCreateProductRatePlanCharge' is set
        if (proxyCreateProductRatePlanCharge == null) {
            throw new ApiException("Missing the required parameter 'proxyCreateProductRatePlanCharge' when calling pOSTProductRatePlanCharge(Async)");
        }

        return pOSTProductRatePlanChargeCall(proxyCreateProductRatePlanCharge, idempotencyKey, acceptEncoding, contentEncoding, authorization, rejectUnknownFields, zuoraEntityIds, zuoraOrgIds, zuoraTrackId, xZuoraWSDLVersion, _callback);

    }


    private ApiResponse<ProxyCreateOrModifyResponse> pOSTProductRatePlanChargeWithHttpInfo(ProxyCreateProductRatePlanCharge proxyCreateProductRatePlanCharge, String idempotencyKey, String acceptEncoding, String contentEncoding, String authorization, Boolean rejectUnknownFields, String zuoraEntityIds, String zuoraOrgIds, String zuoraTrackId, String xZuoraWSDLVersion) throws ApiException {
        okhttp3.Call localVarCall = pOSTProductRatePlanChargeValidateBeforeCall(proxyCreateProductRatePlanCharge, idempotencyKey, acceptEncoding, contentEncoding, authorization, rejectUnknownFields, zuoraEntityIds, zuoraOrgIds, zuoraTrackId, xZuoraWSDLVersion, null);
        Type localVarReturnType = new TypeToken<ProxyCreateOrModifyResponse>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    private okhttp3.Call pOSTProductRatePlanChargeAsync(ProxyCreateProductRatePlanCharge proxyCreateProductRatePlanCharge, String idempotencyKey, String acceptEncoding, String contentEncoding, String authorization, Boolean rejectUnknownFields, String zuoraEntityIds, String zuoraOrgIds, String zuoraTrackId, String xZuoraWSDLVersion, final ApiCallback<ProxyCreateOrModifyResponse> _callback) throws ApiException {

        okhttp3.Call localVarCall = pOSTProductRatePlanChargeValidateBeforeCall(proxyCreateProductRatePlanCharge, idempotencyKey, acceptEncoding, contentEncoding, authorization, rejectUnknownFields, zuoraEntityIds, zuoraOrgIds, zuoraTrackId, xZuoraWSDLVersion, _callback);
        Type localVarReturnType = new TypeToken<ProxyCreateOrModifyResponse>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    public class POSTProductRatePlanChargeRequestBuilder {
        private String accountingCode;
        private String applyDiscountTo;
        private Integer billCycleDay;
        private String billCycleType;
        private String billingPeriod;
        private String billingPeriodAlignment;
        private String billingTiming;
        private String chargeFunction;
        private String commitmentType;
        private String chargeModel;
        private ProxyCreateOrModifyProductRatePlanChargeChargeModelConfiguration chargeModelConfiguration;
        private String chargeType;
        private String creditOption;
        private Double defaultQuantity;
        private String deferredRevenueAccount;
        private ProxyCreateOrModifyDeliverySchedule deliverySchedule;
        private String description;
        private String discountLevel;
        private Double drawdownRate;
        private String drawdownUom;
        private String endDateCondition;
        private Boolean excludeItemBillingFromRevenueAccounting;
        private Boolean excludeItemBookingFromRevenueAccounting;
        private Double includedUnits;
        private Boolean isAllocationEligible;
        private Boolean isPrepaid;
        private Boolean isRollover;
        private Boolean isStackedDiscount;
        private Boolean isUnbilled;
        private Boolean legacyRevenueReporting;
        private String listPriceBase;
        private Double maxQuantity;
        private Double minQuantity;
        private String name;
        private Long numberOfPeriod;
        private String overageCalculationOption;
        private String overageUnusedUnitsCreditOption;
        private String prepaidOperationType;
        private Double prepaidQuantity;
        private Double prepaidTotalQuantity;
        private String prepaidUom;
        private String priceChangeOption;
        private String priceIncreaseOption;
        private Double priceIncreasePercentage;
        private String productCategory;
        private String productClass;
        private String productFamily;
        private String productLine;
        private String revenueRecognitionTiming;
        private String revenueAmortizationMethod;
        private String productRatePlanChargeNumber;
        private ProxyCreateOrModifyProductRatePlanChargeTierData productRatePlanChargeTierData;
        private String productRatePlanId;
        private String ratingGroup;
        private String recognizedRevenueAccount;
        private String revRecCode;
        private String revRecTriggerCondition;
        private String revenueRecognitionRuleName;
        private String rolloverApply;
        private Double rolloverPeriods;
        private String smoothingModel;
        private Long specificBillingPeriod;
        private Integer specificListPriceBase;
        private String taxCode;
        private String taxMode;
        private Boolean taxable;
        private String triggerEvent;
        private String UOM;
        private Long upToPeriods;
        private String upToPeriodsType;
        private String usageRecordRatingOption;
        private Boolean useDiscountSpecificAccountingCode;
        private Boolean useTenantDefaultForPriceChange;
        private String validityPeriodType;
        private String weeklyBillCycleDay;
        private Boolean applyToBillingPeriodPartially;
        private Integer rolloverPeriodLength;
        private String formula;
        private String classNS;
        private String deferredRevAccountNS;
        private String departmentNS;
        private String includeChildrenNS;
        private String integrationIdNS;
        private String integrationStatusNS;
        private String itemTypeNS;
        private String locationNS;
        private String recognizedRevAccountNS;
        private String revRecEndNS;
        private String revRecStartNS;
        private String revRecTemplateTypeNS;
        private String subsidiaryNS;
        private String syncDateNS;
        private String idempotencyKey;
        private String acceptEncoding;
        private String contentEncoding;
        private String authorization;
        private Boolean rejectUnknownFields;
        private String zuoraEntityIds;
        private String zuoraOrgIds;
        private String zuoraTrackId;
        private String xZuoraWSDLVersion;
        private ProxyCreateProductRatePlanCharge proxyCreateProductRatePlanCharge;

        private POSTProductRatePlanChargeRequestBuilder() {
        }

        /**
         * Set proxyCreateProductRatePlanCharge
         * @param proxyCreateProductRatePlanCharge  (optional)
         * @return POSTProductRatePlanChargeRequestBuilder
         */
        public POSTProductRatePlanChargeRequestBuilder proxyCreateProductRatePlanCharge(ProxyCreateProductRatePlanCharge proxyCreateProductRatePlanCharge) {
            this.proxyCreateProductRatePlanCharge = proxyCreateProductRatePlanCharge;
            return this;
        }

        /**
         * Set accountingCode
         * @param accountingCode The accounting code for the charge. Accounting codes group transactions that contain similar accounting attributes.  (optional)
         * @return POSTProductRatePlanChargeRequestBuilder
         */
        public POSTProductRatePlanChargeRequestBuilder accountingCode(String accountingCode) {
            this.accountingCode = accountingCode;
            return this;
        }
        
        /**
         * Set applyDiscountTo
         * @param applyDiscountTo Specifies the type of charges that you want a specific discount to apply to. All field values are case sensitive and in all-caps.  (optional)
         * @return POSTProductRatePlanChargeRequestBuilder
         */
        public POSTProductRatePlanChargeRequestBuilder applyDiscountTo(String applyDiscountTo) {
            this.applyDiscountTo = applyDiscountTo;
            return this;
        }
        
        /**
         * Set billCycleDay
         * @param billCycleDay Sets the bill cycle day (BCD) for the charge. The BCD determines which day of the month customer is billed. The BCD value in the account can override the BCD in this object.  **Character limit**: 2  **Values**: a valid BCD integer, 1 - 31  (optional)
         * @return POSTProductRatePlanChargeRequestBuilder
         */
        public POSTProductRatePlanChargeRequestBuilder billCycleDay(Integer billCycleDay) {
            this.billCycleDay = billCycleDay;
            return this;
        }
        
        /**
         * Set billCycleType
         * @param billCycleType Specifies how to determine the billing day for the charge.   **Notes**:   - If you set this field to &#x60;SpecificDayofMonth&#x60;, you must specify which day of the month as the billing day for the charge in the BillCycleDay field.    - If you set this field to &#x60;SpecificDayofWeek&#x60;, you must specify which day of the week as the billing day for the charge in the WeeklyBillCycleDay field.    - By default, &#x60;TermStartDay&#x60; and &#x60;TermEndDay&#x60; are only available for prepayment charges. But you can reach out to Zuora Global Support to request enabling it for non-prepaid recurring charges. Meanwhile, note the following rules applies to these options:     - The Term End Day option of the Billing Day field must be coupled with the Align to Term End option of the Billing Period Alignment field.     - For prepaid charges, the Term Start Day option of the Billing Day field must be coupled with the existing Align to Term Start option of the Billing Period Alignment field.     - For non-prepaid recurring charges: If Billing Day is set to Term Start Day, Billing Period Alignment must be Align to Term Start; If Billing Day is set to Term End Day, Billing Period Alignment can be set to other values.  (optional)
         * @return POSTProductRatePlanChargeRequestBuilder
         */
        public POSTProductRatePlanChargeRequestBuilder billCycleType(String billCycleType) {
            this.billCycleType = billCycleType;
            return this;
        }
        
        /**
         * Set billingPeriod
         * @param billingPeriod The billing period for the charge. The start day of the billing period is also called the bill cycle day (BCD).  **Notes**:   - Specify the number of months or weeks in the SpecificBillingPeriod field if you set this field to &#x60;Specific Months&#x60; or &#x60;Specific Weeks&#x60;.   - The &#x60;Subscription Term&#x60; value is in **Limited Availability**.  (optional)
         * @return POSTProductRatePlanChargeRequestBuilder
         */
        public POSTProductRatePlanChargeRequestBuilder billingPeriod(String billingPeriod) {
            this.billingPeriod = billingPeriod;
            return this;
        }
        
        /**
         * Set billingPeriodAlignment
         * @param billingPeriodAlignment Aligns charges within the same subscription if multiple charges begin on different dates.  **Note:** The &#x60;AlignToTermEnd&#x60; value is only available for prepayment charges by default. Reach out to Zuora Global Support to enable it for non-prepaid recurring charges.  (optional)
         * @return POSTProductRatePlanChargeRequestBuilder
         */
        public POSTProductRatePlanChargeRequestBuilder billingPeriodAlignment(String billingPeriodAlignment) {
            this.billingPeriodAlignment = billingPeriodAlignment;
            return this;
        }
        
        /**
         * Set billingTiming
         * @param billingTiming The billing timing for the charge. You can choose to bill in advance or in arrears for recurring charge types. This field is not used in one-time or usage based charge types.  This feature is in **Limited Availability**. If you wish to have access to the feature, submit a request at [Zuora Global Support](http://support.zuora.com/).   (optional)
         * @return POSTProductRatePlanChargeRequestBuilder
         */
        public POSTProductRatePlanChargeRequestBuilder billingTiming(String billingTiming) {
            this.billingTiming = billingTiming;
            return this;
        }
        
        /**
         * Set chargeFunction
         * @param chargeFunction **Note**: This field is only available if you have the &lt;a href&#x3D;\\\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Bill_your_customers/Bill_for_usage_or_prepaid_products/Advanced_Consumption_Billing/Unbilled_Usage\\\&quot; target&#x3D;\\\&quot;_blank\\\&quot;&gt;Unbilled Usage&lt;/a&gt; feature enabled.  To use this field, you must set the &#x60;X-Zuora-WSDL-Version&#x60; request header to &#x60;141&#x60; or higher. Otherwise, an error occurs.  This field defines what type of charge it is in Advanced Consumption Billing: * Standard: Normal charge with no Prepayment or Commitment or Drawdown. * Prepayment: For recurring charges. Unit or currency based prepaid charge. * CommitmentTrueUp: For recurring charges. Currency based minimum commitment charge. * Drawdown: For usage charges. Drawdown from prepaid funds. * DrawdownAndCreditCommitment: For usage charges. Drawdown from prepaid funds and then credit to minimum commitment funds. * CreditCommitment: For usage charges. Credit to minimum commitment funds.  (optional)
         * @return POSTProductRatePlanChargeRequestBuilder
         */
        public POSTProductRatePlanChargeRequestBuilder chargeFunction(String chargeFunction) {
            this.chargeFunction = chargeFunction;
            return this;
        }
        
        /**
         * Set commitmentType
         * @param commitmentType **Note**: This field is only available if you have the &lt;a href&#x3D;\\\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Bill_your_customers/Bill_for_usage_or_prepaid_products/Advanced_Consumption_Billing/Unbilled_Usage\\\&quot; target&#x3D;\\\&quot;_blank\\\&quot;&gt;Unbilled Usage&lt;/a&gt; feature enabled.  To use this field, you must set the &#x60;X-Zuora-WSDL-Version&#x60; request header to &#x60;133&#x60; or higher. Otherwise, an error occurs.   This field defines the type of commitment. A prepaid charge can be &#x60;UNIT&#x60; or &#x60;CURRENCY&#x60;. A minimum commitment(in-arrears) charge can only be &#x60;CURRENCY&#x60; type. For topup(recurring or one-time) charges, this field indicates what type of funds are created.  * If UNIT, it will create a fund with given prepaidUom. * If CURRENCY, it will create a fund with the currency amount calculated in list price.  For drawdown(usage) charges, this field indicates what type of funds are drawdown from that created from topup charges.  (optional)
         * @return POSTProductRatePlanChargeRequestBuilder
         */
        public POSTProductRatePlanChargeRequestBuilder commitmentType(String commitmentType) {
            this.commitmentType = commitmentType;
            return this;
        }
        
        /**
         * Set chargeModel
         * @param chargeModel Determines how to calculate charges. Charge models must be individually activated in Zuora Billing administration.  **Notes:**   - The &#x60;Delivery Pricing&#x60; value is available only if you have the Delivery Pricing charge model enabled.   - The &#x60;MultiAttributePricing&#x60; value is available only if you have the Multi-Attribute Pricing charge model enabled. The charge model is available for customers with Enterprise and Nine editions by default. If you are a Growth customer, see [Zuora Editions](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/C_Zuora_Editions) for pricing information.          - The &#x60;PreratedPerUnit&#x60; and  value is available only if you have the Pre-rated Per Unit Pricing charge model enabled. The charge model is available for customers with Enterprise and Nine editions by default. If you are a Growth customer, see [Zuora Editions](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/C_Zuora_Editions) for pricing information.          - The &#x60;PreratedPricing&#x60; value is available only if you have the Pre-rated Pricing charge model enabled. The charge model is available for customers with Enterprise and Nine editions by default. If you are a Growth customer, see [Zuora Editions](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/C_Zuora_Editions) for pricing information.        - The &#x60;HighWatermarkVolumePricing&#x60;value is available only if you have the High Water Mark Volume Pricing charge model enabled. The charge model is available for customers with Enterprise and Nine editions by default. If you are a Growth customer, see [Zuora Editions](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/C_Zuora_Editions) for pricing information.          - The &#x60;HighWatermarkTieredPricing&#x60; value is available only if you have the High Water Mark Tiered Pricing charge model enabled. The charge model is available for customers with Enterprise and Nine editions by default. If you are a Growth customer, see [Zuora Editions](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/C_Zuora_Editions) for pricing information.  (optional)
         * @return POSTProductRatePlanChargeRequestBuilder
         */
        public POSTProductRatePlanChargeRequestBuilder chargeModel(String chargeModel) {
            this.chargeModel = chargeModel;
            return this;
        }
        
        /**
         * Set chargeModelConfiguration
         * @param chargeModelConfiguration  (optional)
         * @return POSTProductRatePlanChargeRequestBuilder
         */
        public POSTProductRatePlanChargeRequestBuilder chargeModelConfiguration(ProxyCreateOrModifyProductRatePlanChargeChargeModelConfiguration chargeModelConfiguration) {
            this.chargeModelConfiguration = chargeModelConfiguration;
            return this;
        }
        
        /**
         * Set chargeType
         * @param chargeType Specifies the type of charge.  (optional)
         * @return POSTProductRatePlanChargeRequestBuilder
         */
        public POSTProductRatePlanChargeRequestBuilder chargeType(String chargeType) {
            this.chargeType = chargeType;
            return this;
        }
        
        /**
         * Set creditOption
         * @param creditOption **Note**: This field is only available if you have the [Prepaid with Drawdown](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/J_Billing_Operations/Prepaid_with_Drawdown) feature enabled.  To use this field, you must set the &#x60;X-Zuora-WSDL-Version&#x60; request header to 114 or higher. Otherwise, an error occurs.   The way to calculate credit. See [Credit Option](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/J_Billing_Operations/Prepaid_with_Drawdown/Create_prepayment_charge#Credit_Option) for more information.   (optional)
         * @return POSTProductRatePlanChargeRequestBuilder
         */
        public POSTProductRatePlanChargeRequestBuilder creditOption(String creditOption) {
            this.creditOption = creditOption;
            return this;
        }
        
        /**
         * Set defaultQuantity
         * @param defaultQuantity The default quantity of units, such as the number of authors in a hosted wiki service. This field is required if you use a per-unit pricing model.   **Character limit**: 16  **Values**: a valid quantity value.   **Note:** When the &#x60;ChargeModel&#x60; field is set to &#x60;Tiered Pricing&#x60; or &#x60;Volume Pricing&#x60;, if this field is not specified, the value will default to &#x60;0&#x60;.  (optional)
         * @return POSTProductRatePlanChargeRequestBuilder
         */
        public POSTProductRatePlanChargeRequestBuilder defaultQuantity(Double defaultQuantity) {
            this.defaultQuantity = defaultQuantity;
            return this;
        }
        
        /**
         * Set deferredRevenueAccount
         * @param deferredRevenueAccount The name of the deferred revenue account for this charge.  This feature is in **Limited Availability**. If you wish to have access to the feature, submit a request at [Zuora Global Support](http://support.zuora.com/).   (optional)
         * @return POSTProductRatePlanChargeRequestBuilder
         */
        public POSTProductRatePlanChargeRequestBuilder deferredRevenueAccount(String deferredRevenueAccount) {
            this.deferredRevenueAccount = deferredRevenueAccount;
            return this;
        }
        
        /**
         * Set deliverySchedule
         * @param deliverySchedule  (optional)
         * @return POSTProductRatePlanChargeRequestBuilder
         */
        public POSTProductRatePlanChargeRequestBuilder deliverySchedule(ProxyCreateOrModifyDeliverySchedule deliverySchedule) {
            this.deliverySchedule = deliverySchedule;
            return this;
        }
        
        /**
         * Set description
         * @param description A description of the charge.  (optional)
         * @return POSTProductRatePlanChargeRequestBuilder
         */
        public POSTProductRatePlanChargeRequestBuilder description(String description) {
            this.description = description;
            return this;
        }
        
        /**
         * Set discountLevel
         * @param discountLevel Specifies if the discount applies to just the product rate plan, the entire subscription, or to any activity in the account.  (optional)
         * @return POSTProductRatePlanChargeRequestBuilder
         */
        public POSTProductRatePlanChargeRequestBuilder discountLevel(String discountLevel) {
            this.discountLevel = discountLevel;
            return this;
        }
        
        /**
         * Set drawdownRate
         * @param drawdownRate **Note**: This field is only available if you have the [Prepaid with Drawdown](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/J_Billing_Operations/Prepaid_with_Drawdown) feature enabled.  To use this field, you must set the &#x60;X-Zuora-WSDL-Version&#x60; request header to 114 or higher. Otherwise, an error occurs.  The [conversion rate](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/J_Billing_Operations/Prepaid_with_Drawdown/Create_drawdown_charge#UOM_Conversion) between Usage UOM and Drawdown UOM for a [drawdown charge](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/J_Billing_Operations/Prepaid_with_Drawdown/Create_drawdown_charge). See [Fields related to Prepaid with Drawdown](https://knowledgecenter.zuora.com/Central_Platform/API/G_SOAP_API/E1_SOAP_API_Object_Reference/ProductRatePlanCharge#Fields_related_to_Prepaid_with_Drawdown) for more information.  (optional)
         * @return POSTProductRatePlanChargeRequestBuilder
         */
        public POSTProductRatePlanChargeRequestBuilder drawdownRate(Double drawdownRate) {
            this.drawdownRate = drawdownRate;
            return this;
        }
        
        /**
         * Set drawdownUom
         * @param drawdownUom **Note**: This field is only available if you have the [Prepaid with Drawdown](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/J_Billing_Operations/Prepaid_with_Drawdown) feature enabled.  To use this field, you must set the &#x60;X-Zuora-WSDL-Version&#x60; request header to 114 or higher. Otherwise, an error occurs.   Unit of measurement for a [drawdown charge](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/J_Billing_Operations/Prepaid_with_Drawdown/Create_drawdown_charge).   (optional)
         * @return POSTProductRatePlanChargeRequestBuilder
         */
        public POSTProductRatePlanChargeRequestBuilder drawdownUom(String drawdownUom) {
            this.drawdownUom = drawdownUom;
            return this;
        }
        
        /**
         * Set endDateCondition
         * @param endDateCondition Defines when the charge ends after the charge trigger date.  **Values**:    - &#x60;SubscriptionEnd&#x60;: The charge ends on the subscription end date after a specified period based on the trigger date of the charge.     - &#x60;FixedPeriod&#x60;: The charge ends after a specified period based on the trigger date of the charge. If you set this field to &#x60;FixedPeriod&#x60;, you must specify the length of the period and a period type by defining the &#x60;UpToPeriods&#x60; and &#x60;UpToPeriodsType&#x60; fields.       **Note**: If the subscription ends before the charge end date, the charge ends when the subscription ends. But if the subscription end date is subsequently changed through a Renewal, or Terms and Conditions amendment, the charge will end on the charge end date.  (optional, default to SubscriptionEnd)
         * @return POSTProductRatePlanChargeRequestBuilder
         */
        public POSTProductRatePlanChargeRequestBuilder endDateCondition(String endDateCondition) {
            this.endDateCondition = endDateCondition;
            return this;
        }
        
        /**
         * Set excludeItemBillingFromRevenueAccounting
         * @param excludeItemBillingFromRevenueAccounting The flag to exclude the related invoice items, invoice item adjustments, credit memo items, and debit memo items from revenue accounting.  **Notes**:    - To use this field, you must set the &#x60;X-Zuora-WSDL-Version&#x60; request header to &#x60;115&#x60; or later. Otherwise, an error occurs.   - This field is only available if you have the Order to Revenue or Billing - Revenue Integration feature enabled.   (optional, default to false)
         * @return POSTProductRatePlanChargeRequestBuilder
         */
        public POSTProductRatePlanChargeRequestBuilder excludeItemBillingFromRevenueAccounting(Boolean excludeItemBillingFromRevenueAccounting) {
            this.excludeItemBillingFromRevenueAccounting = excludeItemBillingFromRevenueAccounting;
            return this;
        }
        
        /**
         * Set excludeItemBookingFromRevenueAccounting
         * @param excludeItemBookingFromRevenueAccounting The flag to exclude the related rate plan charges and order line items from revenue accounting.  **Notes**:    - To use this field, you must set the &#x60;X-Zuora-WSDL-Version&#x60; request header to &#x60;115&#x60; or later. Otherwise, an error occurs.   - This field is only available if you have the Order to Revenue or Billing - Revenue Integration feature enabled.   (optional, default to false)
         * @return POSTProductRatePlanChargeRequestBuilder
         */
        public POSTProductRatePlanChargeRequestBuilder excludeItemBookingFromRevenueAccounting(Boolean excludeItemBookingFromRevenueAccounting) {
            this.excludeItemBookingFromRevenueAccounting = excludeItemBookingFromRevenueAccounting;
            return this;
        }
        
        /**
         * Set includedUnits
         * @param includedUnits Specifies the number of units in the base set of units.  **Character limit**: 16  **Values**: a positive decimal value  (optional)
         * @return POSTProductRatePlanChargeRequestBuilder
         */
        public POSTProductRatePlanChargeRequestBuilder includedUnits(Double includedUnits) {
            this.includedUnits = includedUnits;
            return this;
        }
        
        /**
         * Set isAllocationEligible
         * @param isAllocationEligible Indicates whether the charge segment is allocation eligible in revenue recognition. The default value is &#x60;False&#x60;.  **Values**: &#x60;True&#x60;, &#x60;False&#x60;  **Notes**:    - This field is available only if you have the Additional Revenue Fields property enabled.   - To use this field, you must set the &#x60;X-Zuora-WSDL-Version&#x60; request header to 132 or later.   (optional)
         * @return POSTProductRatePlanChargeRequestBuilder
         */
        public POSTProductRatePlanChargeRequestBuilder isAllocationEligible(Boolean isAllocationEligible) {
            this.isAllocationEligible = isAllocationEligible;
            return this;
        }
        
        /**
         * Set isPrepaid
         * @param isPrepaid **Note**: This field is only available if you have the [Prepaid with Drawdown](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/J_Billing_Operations/Prepaid_with_Drawdown) feature enabled.  To use this field, you must set the &#x60;X-Zuora-WSDL-Version&#x60; request header to 114 or higher. Otherwise, an error occurs.   Indicates whether this charge is a prepayment (topup) charge or a drawdown charge.   **Values**: &#x60;true&#x60; or &#x60;false&#x60;.  (optional)
         * @return POSTProductRatePlanChargeRequestBuilder
         */
        public POSTProductRatePlanChargeRequestBuilder isPrepaid(Boolean isPrepaid) {
            this.isPrepaid = isPrepaid;
            return this;
        }
        
        /**
         * Set isRollover
         * @param isRollover **Note**: This field is only available if you have the [Prepaid with Drawdown](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/J_Billing_Operations/Prepaid_with_Drawdown) feature enabled.  To use this field, you must set the &#x60;X-Zuora-WSDL-Version&#x60; request header to 114 or higher. Otherwise, an error occurs.  The value is either \\\&quot;True\\\&quot; or \\\&quot;False\\\&quot;. It determines whether the rollover fields are needed.  (optional)
         * @return POSTProductRatePlanChargeRequestBuilder
         */
        public POSTProductRatePlanChargeRequestBuilder isRollover(Boolean isRollover) {
            this.isRollover = isRollover;
            return this;
        }
        
        /**
         * Set isStackedDiscount
         * @param isStackedDiscount **Note**: This field is only applicable to the Discount - Percentage charge model.  To use this field, you must set the &#x60;X-Zuora-WSDL-Version&#x60; request header to 130 or higher. Otherwise, an error occurs.  This field indicates whether the discount is to be calculated as stacked discount. Possible values are as follows:   - &#x60;True&#x60;: This is a stacked discount, which should be calculated by stacking with other discounts.   - &#x60;False&#x60;: This is not a stacked discount, which should be calculated in sequence with other discounts.  For more information, see [Stacked discounts](https://knowledgecenter.zuora.com/Zuora_Billing/Products/Product_Catalog/B_Charge_Models/B_Discount_Charge_Models).  (optional)
         * @return POSTProductRatePlanChargeRequestBuilder
         */
        public POSTProductRatePlanChargeRequestBuilder isStackedDiscount(Boolean isStackedDiscount) {
            this.isStackedDiscount = isStackedDiscount;
            return this;
        }
        
        /**
         * Set isUnbilled
         * @param isUnbilled Specifies how to perform the accounting during revenue recognition. The default value is &#x60;False&#x60;.  **Values**: &#x60;True&#x60;, &#x60;False&#x60;  **Notes**:    - This field is available only if you have the Additional Revenue Fields property enabled.   - To use this field, you must set the &#x60;X-Zuora-WSDL-Version&#x60; request header to 132 or later.      (optional)
         * @return POSTProductRatePlanChargeRequestBuilder
         */
        public POSTProductRatePlanChargeRequestBuilder isUnbilled(Boolean isUnbilled) {
            this.isUnbilled = isUnbilled;
            return this;
        }
        
        /**
         * Set legacyRevenueReporting
         * @param legacyRevenueReporting  (optional)
         * @return POSTProductRatePlanChargeRequestBuilder
         */
        public POSTProductRatePlanChargeRequestBuilder legacyRevenueReporting(Boolean legacyRevenueReporting) {
            this.legacyRevenueReporting = legacyRevenueReporting;
            return this;
        }
        
        /**
         * Set listPriceBase
         * @param listPriceBase The list price base for the product rate plan charge.  (optional)
         * @return POSTProductRatePlanChargeRequestBuilder
         */
        public POSTProductRatePlanChargeRequestBuilder listPriceBase(String listPriceBase) {
            this.listPriceBase = listPriceBase;
            return this;
        }
        
        /**
         * Set maxQuantity
         * @param maxQuantity Specifies the maximum number of units for this charge. Use this field and the &#x60;MinQuantity&#x60; field to create a range of units allowed in a product rate plan charge.  **Character limit**: 16  **Values**: a positive decimal value  (optional)
         * @return POSTProductRatePlanChargeRequestBuilder
         */
        public POSTProductRatePlanChargeRequestBuilder maxQuantity(Double maxQuantity) {
            this.maxQuantity = maxQuantity;
            return this;
        }
        
        /**
         * Set minQuantity
         * @param minQuantity Specifies the minimum number of units for this charge. Use this field and the &#x60;MaxQuantity&#x60; field to create a range of units allowed in a product rate plan charge.  **Character limit**: 16  **Values**: a positive decimal value  (optional)
         * @return POSTProductRatePlanChargeRequestBuilder
         */
        public POSTProductRatePlanChargeRequestBuilder minQuantity(Double minQuantity) {
            this.minQuantity = minQuantity;
            return this;
        }
        
        /**
         * Set name
         * @param name The name of the product rate plan charge.  (optional)
         * @return POSTProductRatePlanChargeRequestBuilder
         */
        public POSTProductRatePlanChargeRequestBuilder name(String name) {
            this.name = name;
            return this;
        }
        
        /**
         * Set numberOfPeriod
         * @param numberOfPeriod Specifies the number of periods to use when calculating charges in an overage smoothing charge model. The valid value is a positive whole number.  (optional)
         * @return POSTProductRatePlanChargeRequestBuilder
         */
        public POSTProductRatePlanChargeRequestBuilder numberOfPeriod(Long numberOfPeriod) {
            this.numberOfPeriod = numberOfPeriod;
            return this;
        }
        
        /**
         * Set overageCalculationOption
         * @param overageCalculationOption Determines when to calculate overage charges. If the value of the SmoothingMode field is not specified, the value of this field is ignored.  **Values**:    - &#x60;EndOfSmoothingPeriod&#x60;: This option is used by default. The overage is charged at the end of the smoothing period.   - &#x60;PerBillingPeriod&#x60;: The overage is charged on-demand rather than waiting until the end of the smoothing period.  (optional)
         * @return POSTProductRatePlanChargeRequestBuilder
         */
        public POSTProductRatePlanChargeRequestBuilder overageCalculationOption(String overageCalculationOption) {
            this.overageCalculationOption = overageCalculationOption;
            return this;
        }
        
        /**
         * Set overageUnusedUnitsCreditOption
         * @param overageUnusedUnitsCreditOption Determines whether to credit the customer with unused units of usage.  (optional)
         * @return POSTProductRatePlanChargeRequestBuilder
         */
        public POSTProductRatePlanChargeRequestBuilder overageUnusedUnitsCreditOption(String overageUnusedUnitsCreditOption) {
            this.overageUnusedUnitsCreditOption = overageUnusedUnitsCreditOption;
            return this;
        }
        
        /**
         * Set prepaidOperationType
         * @param prepaidOperationType **Note**: This field is only available if you have the [Prepaid with Drawdown](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/J_Billing_Operations/Prepaid_with_Drawdown) feature enabled.  To use this field, you must set the &#x60;X-Zuora-WSDL-Version&#x60; request header to 114 or higher. Otherwise, an error occurs.   The type of this charge. It is either a prepayment (topup) charge or a drawdown charge.   (optional)
         * @return POSTProductRatePlanChargeRequestBuilder
         */
        public POSTProductRatePlanChargeRequestBuilder prepaidOperationType(String prepaidOperationType) {
            this.prepaidOperationType = prepaidOperationType;
            return this;
        }
        
        /**
         * Set prepaidQuantity
         * @param prepaidQuantity **Note**: This field is only available if you have the [Prepaid with Drawdown](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/J_Billing_Operations/Prepaid_with_Drawdown) feature enabled.  To use this field, you must set the &#x60;X-Zuora-WSDL-Version&#x60; request header to 114 or higher. Otherwise, an error occurs.   The number of units included in a [prepayment charge](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/J_Billing_Operations/Prepaid_with_Drawdown/Create_prepayment_charge). Must be a positive number.  (optional)
         * @return POSTProductRatePlanChargeRequestBuilder
         */
        public POSTProductRatePlanChargeRequestBuilder prepaidQuantity(Double prepaidQuantity) {
            this.prepaidQuantity = prepaidQuantity;
            return this;
        }
        
        /**
         * Set prepaidTotalQuantity
         * @param prepaidTotalQuantity **Note**: This field is only available if you have the [Prepaid with Drawdown](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/J_Billing_Operations/Prepaid_with_Drawdown) feature enabled.  To use this field, you must set the &#x60;X-Zuora-WSDL-Version&#x60; request header to 114 or higher. Otherwise, an error occurs.   The total amount of units that end customers can use during a validity period when they subscribe to a [prepayment charge](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/J_Billing_Operations/Prepaid_with_Drawdown/Create_prepayment_charge).  (optional)
         * @return POSTProductRatePlanChargeRequestBuilder
         */
        public POSTProductRatePlanChargeRequestBuilder prepaidTotalQuantity(Double prepaidTotalQuantity) {
            this.prepaidTotalQuantity = prepaidTotalQuantity;
            return this;
        }
        
        /**
         * Set prepaidUom
         * @param prepaidUom **Note**: This field is only available if you have the [Prepaid with Drawdown](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/J_Billing_Operations/Prepaid_with_Drawdown) feature enabled.  To use this field, you must set the &#x60;X-Zuora-WSDL-Version&#x60; request header to 114 or higher. Otherwise, an error occurs.  Unit of measurement for a [prepayment charge](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/J_Billing_Operations/Prepaid_with_Drawdown/Create_prepayment_charge).  (optional)
         * @return POSTProductRatePlanChargeRequestBuilder
         */
        public POSTProductRatePlanChargeRequestBuilder prepaidUom(String prepaidUom) {
            this.prepaidUom = prepaidUom;
            return this;
        }
        
        /**
         * Set priceChangeOption
         * @param priceChangeOption Applies an automatic price change when a termed subscription is renewed.  (optional, default to NoChange)
         * @return POSTProductRatePlanChargeRequestBuilder
         */
        public POSTProductRatePlanChargeRequestBuilder priceChangeOption(String priceChangeOption) {
            this.priceChangeOption = priceChangeOption;
            return this;
        }
        
        /**
         * Set priceIncreaseOption
         * @param priceIncreaseOption Applies an automatic price change when a termed subscription is renewed.  (optional)
         * @return POSTProductRatePlanChargeRequestBuilder
         */
        public POSTProductRatePlanChargeRequestBuilder priceIncreaseOption(String priceIncreaseOption) {
            this.priceIncreaseOption = priceIncreaseOption;
            return this;
        }
        
        /**
         * Set priceIncreasePercentage
         * @param priceIncreasePercentage Specifies the percentage to increase or decrease the price of a termed subscription&#39;s renewal. Use this field if you set the value to &#x60;SpecificPercentageValue&#x60;.  **Character limit**: 16  **Values**: a decimal value between -100 and 100  (optional)
         * @return POSTProductRatePlanChargeRequestBuilder
         */
        public POSTProductRatePlanChargeRequestBuilder priceIncreasePercentage(Double priceIncreasePercentage) {
            this.priceIncreasePercentage = priceIncreasePercentage;
            return this;
        }
        
        /**
         * Set productCategory
         * @param productCategory This field is used to maintain the product category for integration with Zuora Revenue.   **Notes**:    - This field is available only if you have the Additional Revenue Fields property enabled.   - To use this field, you must set the &#x60;X-Zuora-WSDL-Version&#x60; request header to 132 or later.   (optional)
         * @return POSTProductRatePlanChargeRequestBuilder
         */
        public POSTProductRatePlanChargeRequestBuilder productCategory(String productCategory) {
            this.productCategory = productCategory;
            return this;
        }
        
        /**
         * Set productClass
         * @param productClass This field is used to maintain the product class for integration with Zuora Revenue.   **Notes**:    - This field is available only if you have the Additional Revenue Fields property enabled.   - To use this field, you must set the &#x60;X-Zuora-WSDL-Version&#x60; request header to 132 or later.   (optional)
         * @return POSTProductRatePlanChargeRequestBuilder
         */
        public POSTProductRatePlanChargeRequestBuilder productClass(String productClass) {
            this.productClass = productClass;
            return this;
        }
        
        /**
         * Set productFamily
         * @param productFamily This field is used to maintain the product family for integration with Zuora Revenue.   **Notes**:    - This field is available only if you have the Additional Revenue Fields property enabled.   - To use this field, you must set the &#x60;X-Zuora-WSDL-Version&#x60; request header to 132 or later.   (optional)
         * @return POSTProductRatePlanChargeRequestBuilder
         */
        public POSTProductRatePlanChargeRequestBuilder productFamily(String productFamily) {
            this.productFamily = productFamily;
            return this;
        }
        
        /**
         * Set productLine
         * @param productLine This field is used to maintain the product line for integration with Zuora Revenue.   **Notes**:    - This field is available only if you have the Additional Revenue Fields property enabled.   - To use this field, you must set the &#x60;X-Zuora-WSDL-Version&#x60; request header to 132 or later.           (optional)
         * @return POSTProductRatePlanChargeRequestBuilder
         */
        public POSTProductRatePlanChargeRequestBuilder productLine(String productLine) {
            this.productLine = productLine;
            return this;
        }
        
        /**
         * Set revenueRecognitionTiming
         * @param revenueRecognitionTiming Specifies the type of revenue recognition timing.  Predefined options are listed as enum values in this API Reference.  Other options might also be avaliable depending on  the &lt;a href&#x3D;\\\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Enable_Order_to_Revenue/Configure_revenue_settings/Configure_revenue_recognition_policy\\\&quot; target&#x3D;\\\&quot;_blank\\\&quot;&gt;revenue recognition policy configuration&lt;/a&gt; in the Zuora Billing UI.  **Note**: This field is only available if you have the Order to Revenue feature enabled.   (optional)
         * @return POSTProductRatePlanChargeRequestBuilder
         */
        public POSTProductRatePlanChargeRequestBuilder revenueRecognitionTiming(String revenueRecognitionTiming) {
            this.revenueRecognitionTiming = revenueRecognitionTiming;
            return this;
        }
        
        /**
         * Set revenueAmortizationMethod
         * @param revenueAmortizationMethod Specifies the type of revenue amortization method.  Predefined options are listed as enum values in this API Reference.  Other options might also be avaliable depending on  the &lt;a href&#x3D;\\\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Enable_Order_to_Revenue/Configure_revenue_settings/Configure_revenue_recognition_policy\\\&quot; target&#x3D;\\\&quot;_blank\\\&quot;&gt;revenue recognition policy configuration&lt;/a&gt; in the Zuora Billing UI.  **Note**: This field is only available if you have the Order to Revenue feature enabled.   (optional)
         * @return POSTProductRatePlanChargeRequestBuilder
         */
        public POSTProductRatePlanChargeRequestBuilder revenueAmortizationMethod(String revenueAmortizationMethod) {
            this.revenueAmortizationMethod = revenueAmortizationMethod;
            return this;
        }
        
        /**
         * Set productRatePlanChargeNumber
         * @param productRatePlanChargeNumber The natural key of the product rate plan charge.  **Values**:    - leave null for automatically generated string   - an alphanumeric string of 100 characters or fewer  **Note**: This field is only available if you set the &#x60;X-Zuora-WSDL-Version&#x60; request header to &#x60;133&#x60; or later.  (optional)
         * @return POSTProductRatePlanChargeRequestBuilder
         */
        public POSTProductRatePlanChargeRequestBuilder productRatePlanChargeNumber(String productRatePlanChargeNumber) {
            this.productRatePlanChargeNumber = productRatePlanChargeNumber;
            return this;
        }
        
        /**
         * Set productRatePlanChargeTierData
         * @param productRatePlanChargeTierData  (optional)
         * @return POSTProductRatePlanChargeRequestBuilder
         */
        public POSTProductRatePlanChargeRequestBuilder productRatePlanChargeTierData(ProxyCreateOrModifyProductRatePlanChargeTierData productRatePlanChargeTierData) {
            this.productRatePlanChargeTierData = productRatePlanChargeTierData;
            return this;
        }
        
        /**
         * Set productRatePlanId
         * @param productRatePlanId The ID of the product rate plan associated with this product rate plan charge.  (optional)
         * @return POSTProductRatePlanChargeRequestBuilder
         */
        public POSTProductRatePlanChargeRequestBuilder productRatePlanId(String productRatePlanId) {
            this.productRatePlanId = productRatePlanId;
            return this;
        }
        
        /**
         * Set ratingGroup
         * @param ratingGroup Specifies a rating group based on which usage records are rated.  Possible values:                   - &#x60;ByBillingPeriod&#x60;: The rating is based on all the usages in a billing period.    - &#x60;ByUsageStartDate&#x60;: The rating is based on all the usages on the same usage start date.    - &#x60;ByUsageRecord&#x60;: The rating is based on each usage record.   - &#x60;ByUsageUpload&#x60;: The rating is based on all the  usages in a uploaded usage file (&#x60;.xls&#x60; or &#x60;.csv&#x60;).   - &#x60;ByGroupId&#x60;: The rating is based on all the usages in a custom group.  **Notes:**    - The &#x60;ByBillingPeriod&#x60; value can be applied for all charge models.    - The &#x60;ByUsageStartDate&#x60;, &#x60;ByUsageRecord&#x60;, and &#x60;ByUsageUpload&#x60; values can only be applied for per unit, volume pricing, and tiered pricing charge models.    - The &#x60;ByGroupId&#x60; value is only available if you have the Active Rating feature enabled.   - Use this field only for Usage charges. One-Time Charges and Recurring Charges return &#x60;NULL&#x60;.  (optional, default to ByBillingPeriod)
         * @return POSTProductRatePlanChargeRequestBuilder
         */
        public POSTProductRatePlanChargeRequestBuilder ratingGroup(String ratingGroup) {
            this.ratingGroup = ratingGroup;
            return this;
        }
        
        /**
         * Set recognizedRevenueAccount
         * @param recognizedRevenueAccount The name of the recognized revenue account for this charge.   - Required when the Allow Blank Accounting Code setting is No.   - Optional when the Allow Blank Accounting Code setting is Yes.    This feature is in **Limited Availability**. If you wish to have access to the feature, submit a request at [Zuora Global Support](http://support.zuora.com/).   (optional)
         * @return POSTProductRatePlanChargeRequestBuilder
         */
        public POSTProductRatePlanChargeRequestBuilder recognizedRevenueAccount(String recognizedRevenueAccount) {
            this.recognizedRevenueAccount = recognizedRevenueAccount;
            return this;
        }
        
        /**
         * Set revRecCode
         * @param revRecCode Associates this product rate plan charge with a specific revenue recognition code.  (optional)
         * @return POSTProductRatePlanChargeRequestBuilder
         */
        public POSTProductRatePlanChargeRequestBuilder revRecCode(String revRecCode) {
            this.revRecCode = revRecCode;
            return this;
        }
        
        /**
         * Set revRecTriggerCondition
         * @param revRecTriggerCondition Specifies when revenue recognition begins.  (optional)
         * @return POSTProductRatePlanChargeRequestBuilder
         */
        public POSTProductRatePlanChargeRequestBuilder revRecTriggerCondition(String revRecTriggerCondition) {
            this.revRecTriggerCondition = revRecTriggerCondition;
            return this;
        }
        
        /**
         * Set revenueRecognitionRuleName
         * @param revenueRecognitionRuleName Determines when to recognize the revenue for this charge.  (optional)
         * @return POSTProductRatePlanChargeRequestBuilder
         */
        public POSTProductRatePlanChargeRequestBuilder revenueRecognitionRuleName(String revenueRecognitionRuleName) {
            this.revenueRecognitionRuleName = revenueRecognitionRuleName;
            return this;
        }
        
        /**
         * Set rolloverApply
         * @param rolloverApply **Note**: This field is only available if you have the [Prepaid with Drawdown](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/J_Billing_Operations/Prepaid_with_Drawdown) feature enabled.  To use this field, you must set the &#x60;X-Zuora-WSDL-Version&#x60; request header to 114 or higher. Otherwise, an error occurs.  This field defines the priority of rollover, which is either first or last.  (optional)
         * @return POSTProductRatePlanChargeRequestBuilder
         */
        public POSTProductRatePlanChargeRequestBuilder rolloverApply(String rolloverApply) {
            this.rolloverApply = rolloverApply;
            return this;
        }
        
        /**
         * Set rolloverPeriods
         * @param rolloverPeriods **Note**: This field is only available if you have the [Prepaid with Drawdown](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/J_Billing_Operations/Prepaid_with_Drawdown) feature enabled.  To use this field, you must set the &#x60;X-Zuora-WSDL-Version&#x60; request header to 114 or higher. Otherwise, an error occurs.  This field defines the number of rollover periods, it is restricted to 3.  (optional)
         * @return POSTProductRatePlanChargeRequestBuilder
         */
        public POSTProductRatePlanChargeRequestBuilder rolloverPeriods(Double rolloverPeriods) {
            this.rolloverPeriods = rolloverPeriods;
            return this;
        }
        
        /**
         * Set smoothingModel
         * @param smoothingModel Specifies the smoothing model for an overage smoothing charge model.  (optional)
         * @return POSTProductRatePlanChargeRequestBuilder
         */
        public POSTProductRatePlanChargeRequestBuilder smoothingModel(String smoothingModel) {
            this.smoothingModel = smoothingModel;
            return this;
        }
        
        /**
         * Set specificBillingPeriod
         * @param specificBillingPeriod Customizes the number of months or weeks for the charges billing period. This field is required if you set the value of the BillingPeriod field to &#x60;Specific Months&#x60; or &#x60;Specific Weeks&#x60;. The valid value is a positive integer.  (optional)
         * @return POSTProductRatePlanChargeRequestBuilder
         */
        public POSTProductRatePlanChargeRequestBuilder specificBillingPeriod(Long specificBillingPeriod) {
            this.specificBillingPeriod = specificBillingPeriod;
            return this;
        }
        
        /**
         * Set specificListPriceBase
         * @param specificListPriceBase The number of months for the list price base of the charge. This field is required if you set the value of the &#x60;ListPriceBase&#x60; field to &#x60;Per Specific Months&#x60;.  **Notes**:    - This field is available only if you have the &lt;a href&#x3D;\\\&quot;https://knowledgecenter.zuora.com/Billing/Subscriptions/Product_Catalog/I_Annual_List_Price\\\&quot; target&#x3D;\\\&quot;_blank\\\&quot;&gt;Annual List Price&lt;/a&gt; feature enabled.   - To use this field, you must set the &#x60;X-Zuora-WSDL-Version&#x60; request header to &#x60;129&#x60; or later. Otherwise, an error occurs.   - The value of this field is &#x60;null&#x60; if you do not set the value of the &#x60;ListPriceBase&#x60; field to &#x60;Per Specific Months&#x60;.  (optional)
         * @return POSTProductRatePlanChargeRequestBuilder
         */
        public POSTProductRatePlanChargeRequestBuilder specificListPriceBase(Integer specificListPriceBase) {
            this.specificListPriceBase = specificListPriceBase;
            return this;
        }
        
        /**
         * Set taxCode
         * @param taxCode Specifies the tax code for taxation rules. Required when the Taxable field is set to &#x60;True&#x60;.  **Note**: This value affects the tax calculation of rate plan charges that come from the &#x60;ProductRatePlanCharge&#x60;.  (optional)
         * @return POSTProductRatePlanChargeRequestBuilder
         */
        public POSTProductRatePlanChargeRequestBuilder taxCode(String taxCode) {
            this.taxCode = taxCode;
            return this;
        }
        
        /**
         * Set taxMode
         * @param taxMode Determines how to define taxation for the charge. Required when the Taxable field is set to &#x60;True&#x60;.  **Note**: This value affects the tax calculation of rate plan charges that come from the &#x60;ProductRatePlanCharge&#x60;.  (optional)
         * @return POSTProductRatePlanChargeRequestBuilder
         */
        public POSTProductRatePlanChargeRequestBuilder taxMode(String taxMode) {
            this.taxMode = taxMode;
            return this;
        }
        
        /**
         * Set taxable
         * @param taxable Determines whether the charge is taxable. When set to &#x60;True&#x60;, the TaxMode and TaxCode fields are required when creating or updating th ProductRatePlanCharge object.  **Character limit**: 5  **Values**: &#x60;True&#x60;, &#x60;False&#x60;  **Note**: This value affects the tax calculation of rate plan charges that come from the &#x60;ProductRatePlanCharge&#x60;.  (optional)
         * @return POSTProductRatePlanChargeRequestBuilder
         */
        public POSTProductRatePlanChargeRequestBuilder taxable(Boolean taxable) {
            this.taxable = taxable;
            return this;
        }
        
        /**
         * Set triggerEvent
         * @param triggerEvent Specifies when to start billing the customer for the charge.  **Values**:   - &#x60;ContractEffective&#x60; is the date when the subscription&#39;s contract goes into effect and the charge is ready to be billed.   - &#x60;ServiceActivation&#x60; is the date when the services or products for a subscription have been activated and the customers have access.   - &#x60;CustomerAcceptance&#x60; is when the customer accepts the services or products for a subscription.  (optional)
         * @return POSTProductRatePlanChargeRequestBuilder
         */
        public POSTProductRatePlanChargeRequestBuilder triggerEvent(String triggerEvent) {
            this.triggerEvent = triggerEvent;
            return this;
        }
        
        /**
         * Set UOM
         * @param UOM Specifies a configured unit to measure usage.   **Note**: You must specify this field when creating the following charge models:   - Per Unit Pricing   - Volume Pricing   - Overage Pricing   - Tiered Pricing   - Tiered with Overage Pricing  (optional)
         * @return POSTProductRatePlanChargeRequestBuilder
         */
        public POSTProductRatePlanChargeRequestBuilder UOM(String UOM) {
            this.UOM = UOM;
            return this;
        }
        
        /**
         * Set upToPeriods
         * @param upToPeriods Specifies the length of the period during which the charge is active. If this period ends before the subscription ends, the charge ends when this period ends.  **Character limit**: 5  **Values**: a whole number between 0 and 65535, exclusive  **Notes**:   - You must use this field together with the &#x60;UpToPeriodsType&#x60; field to specify the time period. This field is applicable only when the &#x60;EndDateCondition&#x60; field is set to &#x60;FixedPeriod&#x60;.    - If the subscription end date is subsequently changed through a Renewal, or Terms and Conditions amendment, the charge end date will change accordingly up to the original period end.  (optional)
         * @return POSTProductRatePlanChargeRequestBuilder
         */
        public POSTProductRatePlanChargeRequestBuilder upToPeriods(Long upToPeriods) {
            this.upToPeriods = upToPeriods;
            return this;
        }
        
        /**
         * Set upToPeriodsType
         * @param upToPeriodsType The period type used to define when the charge ends.  **Notes**:   - You must use this field together with the &#x60;UpToPeriods&#x60; field to specify the time period.  - This field is applicable only when the &#x60;EndDateCondition&#x60; field is set to &#x60;FixedPeriod&#x60;.   (optional, default to Billing Periods)
         * @return POSTProductRatePlanChargeRequestBuilder
         */
        public POSTProductRatePlanChargeRequestBuilder upToPeriodsType(String upToPeriodsType) {
            this.upToPeriodsType = upToPeriodsType;
            return this;
        }
        
        /**
         * Set usageRecordRatingOption
         * @param usageRecordRatingOption Determines how Zuora processes usage records for per-unit usage charges.   (optional, default to EndOfBillingPeriod)
         * @return POSTProductRatePlanChargeRequestBuilder
         */
        public POSTProductRatePlanChargeRequestBuilder usageRecordRatingOption(String usageRecordRatingOption) {
            this.usageRecordRatingOption = usageRecordRatingOption;
            return this;
        }
        
        /**
         * Set useDiscountSpecificAccountingCode
         * @param useDiscountSpecificAccountingCode Determines whether to define a new accounting code for the new discount charge.  **Character limit**: 5  **Values**: &#x60;True&#x60;, &#x60;False&#x60;  (optional)
         * @return POSTProductRatePlanChargeRequestBuilder
         */
        public POSTProductRatePlanChargeRequestBuilder useDiscountSpecificAccountingCode(Boolean useDiscountSpecificAccountingCode) {
            this.useDiscountSpecificAccountingCode = useDiscountSpecificAccountingCode;
            return this;
        }
        
        /**
         * Set useTenantDefaultForPriceChange
         * @param useTenantDefaultForPriceChange Applies the tenant-level percentage uplift value for an automatic price change to a termed subscription&#39;s renewal.   **Character limit**: 5  **Values**: &#x60;true&#x60;, &#x60;false&#x60;  (optional)
         * @return POSTProductRatePlanChargeRequestBuilder
         */
        public POSTProductRatePlanChargeRequestBuilder useTenantDefaultForPriceChange(Boolean useTenantDefaultForPriceChange) {
            this.useTenantDefaultForPriceChange = useTenantDefaultForPriceChange;
            return this;
        }
        
        /**
         * Set validityPeriodType
         * @param validityPeriodType **Note**: This field is only available if you have the [Prepaid with Drawdown](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/J_Billing_Operations/Prepaid_with_Drawdown) feature enabled.  To use this field, you must set the &#x60;X-Zuora-WSDL-Version&#x60; request header to 114 or higher. Otherwise, an error occurs.   The period in which the prepayment units are valid to use as defined in a [prepayment charge](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/J_Billing_Operations/Prepaid_with_Drawdown/Create_prepayment_charge).  (optional)
         * @return POSTProductRatePlanChargeRequestBuilder
         */
        public POSTProductRatePlanChargeRequestBuilder validityPeriodType(String validityPeriodType) {
            this.validityPeriodType = validityPeriodType;
            return this;
        }
        
        /**
         * Set weeklyBillCycleDay
         * @param weeklyBillCycleDay Specifies which day of the week as the bill cycle day (BCD) for the charge.  This feature is in **Limited Availability**. If you wish to have access to the feature, submit a request at [Zuora Global Support](http://support.zuora.com/).   (optional)
         * @return POSTProductRatePlanChargeRequestBuilder
         */
        public POSTProductRatePlanChargeRequestBuilder weeklyBillCycleDay(String weeklyBillCycleDay) {
            this.weeklyBillCycleDay = weeklyBillCycleDay;
            return this;
        }
        
        /**
         * Set applyToBillingPeriodPartially
         * @param applyToBillingPeriodPartially Allow the discount duration to be aligned with the billing period partially.  **Note**: You must enable the [Enhanced Discount](https://knowledgecenter.zuora.com/Zuora_Billing/Build_products_and_prices/Basic_concepts_and_terms/B_Charge_Models/D_Manage_Enhanced_Discount) feature to access this field.  (optional)
         * @return POSTProductRatePlanChargeRequestBuilder
         */
        public POSTProductRatePlanChargeRequestBuilder applyToBillingPeriodPartially(Boolean applyToBillingPeriodPartially) {
            this.applyToBillingPeriodPartially = applyToBillingPeriodPartially;
            return this;
        }
        
        /**
         * Set rolloverPeriodLength
         * @param rolloverPeriodLength **Note**: This field is only available if you have the [Prepaid with Drawdown](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/J_Billing_Operations/Prepaid_with_Drawdown) feature enabled.  To use this field, you must set the &#x60;X-Zuora-WSDL-Version&#x60; request header to 137 or higher. Otherwise, an error occurs.  The period length of the rollover fund. If this field is set as optional, then you can modify the value. The limit for the value should be 1 which should be lesser than equal to the specified period that is lesser than equal to the validity period&#39;s length.  (optional)
         * @return POSTProductRatePlanChargeRequestBuilder
         */
        public POSTProductRatePlanChargeRequestBuilder rolloverPeriodLength(Integer rolloverPeriodLength) {
            this.rolloverPeriodLength = rolloverPeriodLength;
            return this;
        }
        
        /**
         * Set formula
         * @param formula The price lookup formula defined for the product rate plan charge, which is used to identify the correct and relevant charge definition based on the context.  For more information, see &lt;a href&#x3D;\\\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Build_products_and_prices/Attribute-based_pricing/Price_lookup_in_Attribute-based_Pricing\\\&quot;  target&#x3D;\\\&quot;_blank\\\&quot;&gt;Price lookup in Attribute-based Pricing&lt;/a&gt;.  **Notes**:    - This field is available only if the &lt;a href&#x3D;\\\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Build_products_and_prices/Attribute-based_pricing\\\&quot; target&#x3D;\\\&quot;_blank\\\&quot;&gt;Attribute-based Pricing&lt;/a&gt; feature is enabled.   - To use this field, you must set the &#x60;X-Zuora-WSDL-Version&#x60; request header to 138 or higher.  (optional)
         * @return POSTProductRatePlanChargeRequestBuilder
         */
        public POSTProductRatePlanChargeRequestBuilder formula(String formula) {
            this.formula = formula;
            return this;
        }
        
        /**
         * Set classNS
         * @param classNS Class associated with the corresponding item in NetSuite. Only available if you have installed the [Zuora Connector for NetSuite](https://www.zuora.com/connect/app/?appId&#x3D;265).  (optional)
         * @return POSTProductRatePlanChargeRequestBuilder
         */
        public POSTProductRatePlanChargeRequestBuilder classNS(String classNS) {
            this.classNS = classNS;
            return this;
        }
        
        /**
         * Set deferredRevAccountNS
         * @param deferredRevAccountNS Deferrred revenue account associated with the corresponding item in NetSuite. Only available if you have installed the [Zuora Connector for NetSuite](https://www.zuora.com/connect/app/?appId&#x3D;265).  (optional)
         * @return POSTProductRatePlanChargeRequestBuilder
         */
        public POSTProductRatePlanChargeRequestBuilder deferredRevAccountNS(String deferredRevAccountNS) {
            this.deferredRevAccountNS = deferredRevAccountNS;
            return this;
        }
        
        /**
         * Set departmentNS
         * @param departmentNS Department associated with the corresponding item in NetSuite. Only available if you have installed the [Zuora Connector for NetSuite](https://www.zuora.com/connect/app/?appId&#x3D;265).  (optional)
         * @return POSTProductRatePlanChargeRequestBuilder
         */
        public POSTProductRatePlanChargeRequestBuilder departmentNS(String departmentNS) {
            this.departmentNS = departmentNS;
            return this;
        }
        
        /**
         * Set includeChildrenNS
         * @param includeChildrenNS Specifies whether the corresponding item in NetSuite is visible under child subsidiaries. Only available if you have installed the [Zuora Connector for NetSuite](https://www.zuora.com/connect/app/?appId&#x3D;265).  (optional)
         * @return POSTProductRatePlanChargeRequestBuilder
         */
        public POSTProductRatePlanChargeRequestBuilder includeChildrenNS(String includeChildrenNS) {
            this.includeChildrenNS = includeChildrenNS;
            return this;
        }
        
        /**
         * Set integrationIdNS
         * @param integrationIdNS ID of the corresponding object in NetSuite. Only available if you have installed the [Zuora Connector for NetSuite](https://www.zuora.com/connect/app/?appId&#x3D;265).  (optional)
         * @return POSTProductRatePlanChargeRequestBuilder
         */
        public POSTProductRatePlanChargeRequestBuilder integrationIdNS(String integrationIdNS) {
            this.integrationIdNS = integrationIdNS;
            return this;
        }
        
        /**
         * Set integrationStatusNS
         * @param integrationStatusNS Status of the product rate plan charge&#39;s synchronization with NetSuite. Only available if you have installed the [Zuora Connector for NetSuite](https://www.zuora.com/connect/app/?appId&#x3D;265).  (optional)
         * @return POSTProductRatePlanChargeRequestBuilder
         */
        public POSTProductRatePlanChargeRequestBuilder integrationStatusNS(String integrationStatusNS) {
            this.integrationStatusNS = integrationStatusNS;
            return this;
        }
        
        /**
         * Set itemTypeNS
         * @param itemTypeNS Type of item that is created in NetSuite for the product rate plan charge. Only available if you have installed the [Zuora Connector for NetSuite](https://www.zuora.com/connect/app/?appId&#x3D;265).  (optional)
         * @return POSTProductRatePlanChargeRequestBuilder
         */
        public POSTProductRatePlanChargeRequestBuilder itemTypeNS(String itemTypeNS) {
            this.itemTypeNS = itemTypeNS;
            return this;
        }
        
        /**
         * Set locationNS
         * @param locationNS Location associated with the corresponding item in NetSuite. Only available if you have installed the [Zuora Connector for NetSuite](https://www.zuora.com/connect/app/?appId&#x3D;265).  (optional)
         * @return POSTProductRatePlanChargeRequestBuilder
         */
        public POSTProductRatePlanChargeRequestBuilder locationNS(String locationNS) {
            this.locationNS = locationNS;
            return this;
        }
        
        /**
         * Set recognizedRevAccountNS
         * @param recognizedRevAccountNS Recognized revenue account associated with the corresponding item in NetSuite. Only available if you have installed the [Zuora Connector for NetSuite](https://www.zuora.com/connect/app/?appId&#x3D;265).  (optional)
         * @return POSTProductRatePlanChargeRequestBuilder
         */
        public POSTProductRatePlanChargeRequestBuilder recognizedRevAccountNS(String recognizedRevAccountNS) {
            this.recognizedRevAccountNS = recognizedRevAccountNS;
            return this;
        }
        
        /**
         * Set revRecEndNS
         * @param revRecEndNS End date condition of the corresponding item in NetSuite. Only available if you have installed the [Zuora Connector for NetSuite](https://www.zuora.com/connect/app/?appId&#x3D;265).  (optional)
         * @return POSTProductRatePlanChargeRequestBuilder
         */
        public POSTProductRatePlanChargeRequestBuilder revRecEndNS(String revRecEndNS) {
            this.revRecEndNS = revRecEndNS;
            return this;
        }
        
        /**
         * Set revRecStartNS
         * @param revRecStartNS Start date condition of the corresponding item in NetSuite. Only available if you have installed the [Zuora Connector for NetSuite](https://www.zuora.com/connect/app/?appId&#x3D;265).  (optional)
         * @return POSTProductRatePlanChargeRequestBuilder
         */
        public POSTProductRatePlanChargeRequestBuilder revRecStartNS(String revRecStartNS) {
            this.revRecStartNS = revRecStartNS;
            return this;
        }
        
        /**
         * Set revRecTemplateTypeNS
         * @param revRecTemplateTypeNS Only available if you have installed the [Zuora Connector for NetSuite](https://www.zuora.com/connect/app/?appId&#x3D;265).  (optional)
         * @return POSTProductRatePlanChargeRequestBuilder
         */
        public POSTProductRatePlanChargeRequestBuilder revRecTemplateTypeNS(String revRecTemplateTypeNS) {
            this.revRecTemplateTypeNS = revRecTemplateTypeNS;
            return this;
        }
        
        /**
         * Set subsidiaryNS
         * @param subsidiaryNS Subsidiary associated with the corresponding item in NetSuite. Only available if you have installed the [Zuora Connector for NetSuite](https://www.zuora.com/connect/app/?appId&#x3D;265).  (optional)
         * @return POSTProductRatePlanChargeRequestBuilder
         */
        public POSTProductRatePlanChargeRequestBuilder subsidiaryNS(String subsidiaryNS) {
            this.subsidiaryNS = subsidiaryNS;
            return this;
        }
        
        /**
         * Set syncDateNS
         * @param syncDateNS Date when the product rate plan charge was synchronized with NetSuite. Only available if you have installed the [Zuora Connector for NetSuite](https://www.zuora.com/connect/app/?appId&#x3D;265).  (optional)
         * @return POSTProductRatePlanChargeRequestBuilder
         */
        public POSTProductRatePlanChargeRequestBuilder syncDateNS(String syncDateNS) {
            this.syncDateNS = syncDateNS;
            return this;
        }
        
        /**
         * Set idempotencyKey
         * @param idempotencyKey Specify a unique idempotency key if you want to perform an idempotent POST or PATCH request. Do not use this header in other request types.   With this header specified, the Zuora server can identify subsequent retries of the same request using this value, which prevents the same operation from being performed multiple times by accident.   (optional)
         * @return POSTProductRatePlanChargeRequestBuilder
         */
        public POSTProductRatePlanChargeRequestBuilder idempotencyKey(String idempotencyKey) {
            this.idempotencyKey = idempotencyKey;
            return this;
        }
        
        /**
         * Set acceptEncoding
         * @param acceptEncoding Include the &#x60;Accept-Encoding: gzip&#x60; header to compress responses as a gzipped file. It can significantly reduce the bandwidth required for a response.   If specified, Zuora automatically compresses responses that contain over 1000 bytes of data, and the response contains a &#x60;Content-Encoding&#x60; header with the compression algorithm so that your client can decompress it.  (optional)
         * @return POSTProductRatePlanChargeRequestBuilder
         */
        public POSTProductRatePlanChargeRequestBuilder acceptEncoding(String acceptEncoding) {
            this.acceptEncoding = acceptEncoding;
            return this;
        }
        
        /**
         * Set contentEncoding
         * @param contentEncoding Include the &#x60;Content-Encoding: gzip&#x60; header to compress a request. With this header specified, you should upload a gzipped file for the request payload instead of sending the JSON payload.  (optional)
         * @return POSTProductRatePlanChargeRequestBuilder
         */
        public POSTProductRatePlanChargeRequestBuilder contentEncoding(String contentEncoding) {
            this.contentEncoding = contentEncoding;
            return this;
        }
        
        /**
         * Set authorization
         * @param authorization The value is in the &#x60;Bearer {token}&#x60; format where {token} is a valid OAuth token generated by calling [Create an OAuth token](https://developer.zuora.com/api-references/api/operation/createToken).  (optional)
         * @return POSTProductRatePlanChargeRequestBuilder
         */
        public POSTProductRatePlanChargeRequestBuilder authorization(String authorization) {
            this.authorization = authorization;
            return this;
        }
        
        /**
         * Set rejectUnknownFields
         * @param rejectUnknownFields Specifies whether the call fails if the request body contains unknown fields. With &#x60;rejectUnknownFields&#x60; set to &#x60;true&#x60;, Zuora returns a 400 response if the request body contains unknown fields. The body of the 400 response is:  &#x60;&#x60;&#x60;json {     \&quot;message\&quot;: \&quot;Error - unrecognised fields\&quot; } &#x60;&#x60;&#x60;  By default, Zuora ignores unknown fields in the request body.  (optional, default to false)
         * @return POSTProductRatePlanChargeRequestBuilder
         */
        public POSTProductRatePlanChargeRequestBuilder rejectUnknownFields(Boolean rejectUnknownFields) {
            this.rejectUnknownFields = rejectUnknownFields;
            return this;
        }
        
        /**
         * Set zuoraEntityIds
         * @param zuoraEntityIds An entity ID. If you have [Zuora Multi-entity](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Multi-entity) enabled and the OAuth token is valid for more than one entity, you must use this header to specify which entity to perform the operation in. If the OAuth token is only valid for a single entity, or you do not have Zuora Multi-entity enabled, you do not need to set this header.  (optional)
         * @return POSTProductRatePlanChargeRequestBuilder
         */
        public POSTProductRatePlanChargeRequestBuilder zuoraEntityIds(String zuoraEntityIds) {
            this.zuoraEntityIds = zuoraEntityIds;
            return this;
        }
        
        /**
         * Set zuoraOrgIds
         * @param zuoraOrgIds Comma separated IDs. If you have &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Central_Platform/Multi-Org\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Zuora Multi-Org&lt;/a&gt; enabled,  you can use this header to specify which orgs to perform the operation in. If you do not have Zuora Multi-Org enabled, you should not set this header.  The IDs must be a sub-set of the user&#39;s accessible orgs. If you specify an org that the user does not have access to, the operation fails.  If the header is not set, the operation is performed in scope of the user&#39;s accessible orgs.  (optional)
         * @return POSTProductRatePlanChargeRequestBuilder
         */
        public POSTProductRatePlanChargeRequestBuilder zuoraOrgIds(String zuoraOrgIds) {
            this.zuoraOrgIds = zuoraOrgIds;
            return this;
        }
        
        /**
         * Set zuoraTrackId
         * @param zuoraTrackId A custom identifier for tracing the API call. If you set a value for this header, Zuora returns the same value in the response headers. This header enables you to associate your system process identifiers with Zuora API calls, to assist with troubleshooting in the event of an issue.  The value of this field must use the US-ASCII character set and must not include any of the following characters: colon (&#x60;:&#x60;), semicolon (&#x60;;&#x60;), double quote (&#x60;\&quot;&#x60;), and quote (&#x60;&#39;&#x60;).  (optional)
         * @return POSTProductRatePlanChargeRequestBuilder
         */
        public POSTProductRatePlanChargeRequestBuilder zuoraTrackId(String zuoraTrackId) {
            this.zuoraTrackId = zuoraTrackId;
            return this;
        }
        
        /**
         * Set xZuoraWSDLVersion
         * @param xZuoraWSDLVersion Zuora WSDL version number.  (optional, default to 79)
         * @return POSTProductRatePlanChargeRequestBuilder
         */
        public POSTProductRatePlanChargeRequestBuilder xZuoraWSDLVersion(String xZuoraWSDLVersion) {
            this.xZuoraWSDLVersion = xZuoraWSDLVersion;
            return this;
        }
        
        /**
         * Build call for pOSTProductRatePlanCharge
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
            ProxyCreateProductRatePlanCharge proxyCreateProductRatePlanCharge = buildBodyParams();
            return pOSTProductRatePlanChargeCall(proxyCreateProductRatePlanCharge, idempotencyKey, acceptEncoding, contentEncoding, authorization, rejectUnknownFields, zuoraEntityIds, zuoraOrgIds, zuoraTrackId, xZuoraWSDLVersion, _callback);
        }

        private ProxyCreateProductRatePlanCharge buildBodyParams() {
            return this.proxyCreateProductRatePlanCharge;
        }

        /**
         * Execute pOSTProductRatePlanCharge request
         * @return ProxyCreateOrModifyResponse
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td>  </td><td>  * Content-Encoding - This header is returned if you specify the &#x60;Accept-Encoding: gzip&#x60; request header and the response contains over 1000 bytes of data. Note that only the following MIME types support gzipped responses:   - &#x60;application/json&#x60;   - &#x60;application/xml&#x60;   - &#x60;text/html&#x60;   - &#x60;text/csv&#x60;   - &#x60;text/plain&#x60;  <br>  * RateLimit-Limit - The request limit quota for the time window closest to exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Remaining - The number of requests remaining in the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Reset - The number of seconds until the quota resets for the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Zuora-Request-Id - The Zuora internal identifier of the API call. You cannot control the value of this header.  <br>  * Zuora-Track-Id - A custom identifier for tracing the API call. If you specified a tracing identifier in the request headers, Zuora returns the same tracing identifier. Otherwise, Zuora does not set this header.  <br>  </td></tr>
         </table>
         */
        public ProxyCreateOrModifyResponse execute() throws ApiException {
            ProxyCreateProductRatePlanCharge proxyCreateProductRatePlanCharge = buildBodyParams();
            ApiResponse<ProxyCreateOrModifyResponse> localVarResp = pOSTProductRatePlanChargeWithHttpInfo(proxyCreateProductRatePlanCharge, idempotencyKey, acceptEncoding, contentEncoding, authorization, rejectUnknownFields, zuoraEntityIds, zuoraOrgIds, zuoraTrackId, xZuoraWSDLVersion);
            return localVarResp.getResponseBody();
        }

        /**
         * Execute pOSTProductRatePlanCharge request with HTTP info returned
         * @return ApiResponse&lt;ProxyCreateOrModifyResponse&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td>  </td><td>  * Content-Encoding - This header is returned if you specify the &#x60;Accept-Encoding: gzip&#x60; request header and the response contains over 1000 bytes of data. Note that only the following MIME types support gzipped responses:   - &#x60;application/json&#x60;   - &#x60;application/xml&#x60;   - &#x60;text/html&#x60;   - &#x60;text/csv&#x60;   - &#x60;text/plain&#x60;  <br>  * RateLimit-Limit - The request limit quota for the time window closest to exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Remaining - The number of requests remaining in the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Reset - The number of seconds until the quota resets for the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Zuora-Request-Id - The Zuora internal identifier of the API call. You cannot control the value of this header.  <br>  * Zuora-Track-Id - A custom identifier for tracing the API call. If you specified a tracing identifier in the request headers, Zuora returns the same tracing identifier. Otherwise, Zuora does not set this header.  <br>  </td></tr>
         </table>
         */
        public ApiResponse<ProxyCreateOrModifyResponse> executeWithHttpInfo() throws ApiException {
            ProxyCreateProductRatePlanCharge proxyCreateProductRatePlanCharge = buildBodyParams();
            return pOSTProductRatePlanChargeWithHttpInfo(proxyCreateProductRatePlanCharge, idempotencyKey, acceptEncoding, contentEncoding, authorization, rejectUnknownFields, zuoraEntityIds, zuoraOrgIds, zuoraTrackId, xZuoraWSDLVersion);
        }

        /**
         * Execute pOSTProductRatePlanCharge request (asynchronously)
         * @param _callback The callback to be executed when the API call finishes
         * @return The request call
         * @throws ApiException If fail to process the API call, e.g. serializing the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td>  </td><td>  * Content-Encoding - This header is returned if you specify the &#x60;Accept-Encoding: gzip&#x60; request header and the response contains over 1000 bytes of data. Note that only the following MIME types support gzipped responses:   - &#x60;application/json&#x60;   - &#x60;application/xml&#x60;   - &#x60;text/html&#x60;   - &#x60;text/csv&#x60;   - &#x60;text/plain&#x60;  <br>  * RateLimit-Limit - The request limit quota for the time window closest to exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Remaining - The number of requests remaining in the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Reset - The number of seconds until the quota resets for the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Zuora-Request-Id - The Zuora internal identifier of the API call. You cannot control the value of this header.  <br>  * Zuora-Track-Id - A custom identifier for tracing the API call. If you specified a tracing identifier in the request headers, Zuora returns the same tracing identifier. Otherwise, Zuora does not set this header.  <br>  </td></tr>
         </table>
         */
        public okhttp3.Call executeAsync(final ApiCallback<ProxyCreateOrModifyResponse> _callback) throws ApiException {
            ProxyCreateProductRatePlanCharge proxyCreateProductRatePlanCharge = buildBodyParams();
            return pOSTProductRatePlanChargeAsync(proxyCreateProductRatePlanCharge, idempotencyKey, acceptEncoding, contentEncoding, authorization, rejectUnknownFields, zuoraEntityIds, zuoraOrgIds, zuoraTrackId, xZuoraWSDLVersion, _callback);
        }
    }

    /**
     * CRUD: Create a product rate plan charge
     * Creates a product rate plan charge for a specified rate plan charge.   Product rate plan charges can be of three types, one-time fees, recurring fees, and usage fees.  
     * @param proxyCreateProductRatePlanCharge  (required)
     * @return POSTProductRatePlanChargeRequestBuilder
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td>  </td><td>  * Content-Encoding - This header is returned if you specify the &#x60;Accept-Encoding: gzip&#x60; request header and the response contains over 1000 bytes of data. Note that only the following MIME types support gzipped responses:   - &#x60;application/json&#x60;   - &#x60;application/xml&#x60;   - &#x60;text/html&#x60;   - &#x60;text/csv&#x60;   - &#x60;text/plain&#x60;  <br>  * RateLimit-Limit - The request limit quota for the time window closest to exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Remaining - The number of requests remaining in the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Reset - The number of seconds until the quota resets for the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Zuora-Request-Id - The Zuora internal identifier of the API call. You cannot control the value of this header.  <br>  * Zuora-Track-Id - A custom identifier for tracing the API call. If you specified a tracing identifier in the request headers, Zuora returns the same tracing identifier. Otherwise, Zuora does not set this header.  <br>  </td></tr>
     </table>
     */
    public POSTProductRatePlanChargeRequestBuilder pOSTProductRatePlanCharge() throws IllegalArgumentException {
        return new POSTProductRatePlanChargeRequestBuilder();
    }
    private okhttp3.Call pUTProductRatePlanChargeCall(String id, ProxyModifyProductRatePlanCharge proxyModifyProductRatePlanCharge, String acceptEncoding, String contentEncoding, String authorization, Boolean rejectUnknownFields, String zuoraEntityIds, String zuoraOrgIds, String zuoraTrackId, String xZuoraWSDLVersion, final ApiCallback _callback) throws ApiException {
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

        Object localVarPostBody = proxyModifyProductRatePlanCharge;

        // create path and map variables
        String localVarPath = "/v1/object/product-rate-plan-charge/{id}"
            .replace("{" + "id" + "}", localVarApiClient.escapeString(id.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        if (rejectUnknownFields != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("rejectUnknownFields", rejectUnknownFields));
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

        if (zuoraEntityIds != null) {
            localVarHeaderParams.put("Zuora-Entity-Ids", localVarApiClient.parameterToString(zuoraEntityIds));
        }

        if (zuoraOrgIds != null) {
            localVarHeaderParams.put("Zuora-Org-Ids", localVarApiClient.parameterToString(zuoraOrgIds));
        }

        if (zuoraTrackId != null) {
            localVarHeaderParams.put("Zuora-Track-Id", localVarApiClient.parameterToString(zuoraTrackId));
        }

        if (xZuoraWSDLVersion != null) {
            localVarHeaderParams.put("X-Zuora-WSDL-Version", localVarApiClient.parameterToString(xZuoraWSDLVersion));
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
    private okhttp3.Call pUTProductRatePlanChargeValidateBeforeCall(String id, ProxyModifyProductRatePlanCharge proxyModifyProductRatePlanCharge, String acceptEncoding, String contentEncoding, String authorization, Boolean rejectUnknownFields, String zuoraEntityIds, String zuoraOrgIds, String zuoraTrackId, String xZuoraWSDLVersion, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new ApiException("Missing the required parameter 'id' when calling pUTProductRatePlanCharge(Async)");
        }

        // verify the required parameter 'proxyModifyProductRatePlanCharge' is set
        if (proxyModifyProductRatePlanCharge == null) {
            throw new ApiException("Missing the required parameter 'proxyModifyProductRatePlanCharge' when calling pUTProductRatePlanCharge(Async)");
        }

        return pUTProductRatePlanChargeCall(id, proxyModifyProductRatePlanCharge, acceptEncoding, contentEncoding, authorization, rejectUnknownFields, zuoraEntityIds, zuoraOrgIds, zuoraTrackId, xZuoraWSDLVersion, _callback);

    }


    private ApiResponse<ProxyCreateOrModifyResponse> pUTProductRatePlanChargeWithHttpInfo(String id, ProxyModifyProductRatePlanCharge proxyModifyProductRatePlanCharge, String acceptEncoding, String contentEncoding, String authorization, Boolean rejectUnknownFields, String zuoraEntityIds, String zuoraOrgIds, String zuoraTrackId, String xZuoraWSDLVersion) throws ApiException {
        okhttp3.Call localVarCall = pUTProductRatePlanChargeValidateBeforeCall(id, proxyModifyProductRatePlanCharge, acceptEncoding, contentEncoding, authorization, rejectUnknownFields, zuoraEntityIds, zuoraOrgIds, zuoraTrackId, xZuoraWSDLVersion, null);
        Type localVarReturnType = new TypeToken<ProxyCreateOrModifyResponse>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    private okhttp3.Call pUTProductRatePlanChargeAsync(String id, ProxyModifyProductRatePlanCharge proxyModifyProductRatePlanCharge, String acceptEncoding, String contentEncoding, String authorization, Boolean rejectUnknownFields, String zuoraEntityIds, String zuoraOrgIds, String zuoraTrackId, String xZuoraWSDLVersion, final ApiCallback<ProxyCreateOrModifyResponse> _callback) throws ApiException {

        okhttp3.Call localVarCall = pUTProductRatePlanChargeValidateBeforeCall(id, proxyModifyProductRatePlanCharge, acceptEncoding, contentEncoding, authorization, rejectUnknownFields, zuoraEntityIds, zuoraOrgIds, zuoraTrackId, xZuoraWSDLVersion, _callback);
        Type localVarReturnType = new TypeToken<ProxyCreateOrModifyResponse>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    public class PUTProductRatePlanChargeRequestBuilder {
        private final String id;
        private String accountingCode;
        private String applyDiscountTo;
        private Integer billCycleDay;
        private String billCycleType;
        private String billingPeriod;
        private String billingPeriodAlignment;
        private String billingTiming;
        private String chargeFunction;
        private String commitmentType;
        private String chargeModel;
        private ProxyCreateOrModifyProductRatePlanChargeChargeModelConfiguration chargeModelConfiguration;
        private String creditOption;
        private Double defaultQuantity;
        private String deferredRevenueAccount;
        private ProxyCreateOrModifyDeliverySchedule deliverySchedule;
        private String description;
        private String discountLevel;
        private Double drawdownRate;
        private String drawdownUom;
        private String endDateCondition;
        private Boolean excludeItemBillingFromRevenueAccounting;
        private Boolean excludeItemBookingFromRevenueAccounting;
        private Double includedUnits;
        private Boolean isAllocationEligible;
        private Boolean isPrepaid;
        private Boolean isRollover;
        private Boolean isStackedDiscount;
        private Boolean isUnbilled;
        private Boolean legacyRevenueReporting;
        private String listPriceBase;
        private Double maxQuantity;
        private Double minQuantity;
        private String name;
        private Long numberOfPeriod;
        private String overageCalculationOption;
        private String overageUnusedUnitsCreditOption;
        private Double prepaidQuantity;
        private String prepaidUom;
        private String priceChangeOption;
        private String priceIncreaseOption;
        private Double priceIncreasePercentage;
        private String productCategory;
        private String productClass;
        private String productFamily;
        private String productLine;
        private String revenueRecognitionTiming;
        private String revenueAmortizationMethod;
        private String productRatePlanChargeNumber;
        private ProxyCreateOrModifyProductRatePlanChargeTierData productRatePlanChargeTierData;
        private String productRatePlanId;
        private String ratingGroup;
        private String recognizedRevenueAccount;
        private String revRecCode;
        private String revRecTriggerCondition;
        private String revenueRecognitionRuleName;
        private String rolloverApply;
        private Double rolloverPeriods;
        private String smoothingModel;
        private Long specificBillingPeriod;
        private Integer specificListPriceBase;
        private String taxCode;
        private String taxMode;
        private Boolean taxable;
        private String triggerEvent;
        private String UOM;
        private Long upToPeriods;
        private String upToPeriodsType;
        private String usageRecordRatingOption;
        private Boolean useDiscountSpecificAccountingCode;
        private Boolean useTenantDefaultForPriceChange;
        private String validityPeriodType;
        private String weeklyBillCycleDay;
        private Boolean applyToBillingPeriodPartially;
        private Integer rolloverPeriodLength;
        private String formula;
        private String classNS;
        private String deferredRevAccountNS;
        private String departmentNS;
        private String includeChildrenNS;
        private String integrationIdNS;
        private String integrationStatusNS;
        private String itemTypeNS;
        private String locationNS;
        private String recognizedRevAccountNS;
        private String revRecEndNS;
        private String revRecStartNS;
        private String revRecTemplateTypeNS;
        private String subsidiaryNS;
        private String syncDateNS;
        private String acceptEncoding;
        private String contentEncoding;
        private String authorization;
        private Boolean rejectUnknownFields;
        private String zuoraEntityIds;
        private String zuoraOrgIds;
        private String zuoraTrackId;
        private String xZuoraWSDLVersion;
        private ProxyModifyProductRatePlanCharge proxyModifyProductRatePlanCharge;

        private PUTProductRatePlanChargeRequestBuilder(String id) {
            this.id = id;
        }

        /**
         * Set proxyModifyProductRatePlanCharge
         * @param proxyModifyProductRatePlanCharge  (optional)
         * @return PUTProductRatePlanChargeRequestBuilder
         */
        public PUTProductRatePlanChargeRequestBuilder proxyModifyProductRatePlanCharge(ProxyModifyProductRatePlanCharge proxyModifyProductRatePlanCharge) {
            this.proxyModifyProductRatePlanCharge = proxyModifyProductRatePlanCharge;
            return this;
        }

        /**
         * Set accountingCode
         * @param accountingCode The accounting code for the charge. Accounting codes group transactions that contain similar accounting attributes.  (optional)
         * @return PUTProductRatePlanChargeRequestBuilder
         */
        public PUTProductRatePlanChargeRequestBuilder accountingCode(String accountingCode) {
            this.accountingCode = accountingCode;
            return this;
        }
        
        /**
         * Set applyDiscountTo
         * @param applyDiscountTo Specifies the type of charges that you want a specific discount to apply to. All field values are case sensitive and in all-caps.  (optional)
         * @return PUTProductRatePlanChargeRequestBuilder
         */
        public PUTProductRatePlanChargeRequestBuilder applyDiscountTo(String applyDiscountTo) {
            this.applyDiscountTo = applyDiscountTo;
            return this;
        }
        
        /**
         * Set billCycleDay
         * @param billCycleDay Sets the bill cycle day (BCD) for the charge. The BCD determines which day of the month customer is billed. The BCD value in the account can override the BCD in this object.  **Character limit**: 2  **Values**: a valid BCD integer, 1 - 31  (optional)
         * @return PUTProductRatePlanChargeRequestBuilder
         */
        public PUTProductRatePlanChargeRequestBuilder billCycleDay(Integer billCycleDay) {
            this.billCycleDay = billCycleDay;
            return this;
        }
        
        /**
         * Set billCycleType
         * @param billCycleType Specifies how to determine the billing day for the charge.  **Notes**:   - If you set this field to &#x60;SpecificDayofMonth&#x60;, you must specify which day of the month as the billing day for the charge in the BillCycleDay field.    - If you set this field to &#x60;SpecificDayofWeek&#x60;, you must specify which day of the week as the billing day for the charge in the WeeklyBillCycleDay field.    - By default, &#x60;TermStartDay&#x60; and &#x60;TermEndDay&#x60; are only available for prepayment charges. But you can reach out to Zuora Global Support to request enabling it for non-prepaid recurring charges. Meanwhile, note the following rules applies to these options:     - The Term End Day option of the Billing Day field must be coupled with the Align to Term End option of the Billing Period Alignment field.     - For prepaid charges, the Term Start Day option of the Billing Day field must be coupled with the existing Align to Term Start option of the Billing Period Alignment field.     - For non-prepaid recurring charges: If Billing Day is set to Term Start Day, Billing Period Alignment must be Align to Term Start; If Billing Day is set to Term End Day, Billing Period Alignment can be set to other values.  (optional)
         * @return PUTProductRatePlanChargeRequestBuilder
         */
        public PUTProductRatePlanChargeRequestBuilder billCycleType(String billCycleType) {
            this.billCycleType = billCycleType;
            return this;
        }
        
        /**
         * Set billingPeriod
         * @param billingPeriod The billing period for the charge. The start day of the billing period is also called the bill cycle day (BCD).  **Notes**:   - Specify the number of months or weeks in the SpecificBillingPeriod field if you set this field to &#x60;Specific Months&#x60; or &#x60;Specific Weeks&#x60;.   - The &#x60;Subscription Term&#x60; value is in **Limited Availability**.  (optional)
         * @return PUTProductRatePlanChargeRequestBuilder
         */
        public PUTProductRatePlanChargeRequestBuilder billingPeriod(String billingPeriod) {
            this.billingPeriod = billingPeriod;
            return this;
        }
        
        /**
         * Set billingPeriodAlignment
         * @param billingPeriodAlignment Aligns charges within the same subscription if multiple charges begin on different dates.  **Note:** The &#x60;AlignToTermEnd&#x60; value is only available for prepayment charges by default. Reach out to Zuora Global Support to enable it for non-prepaid recurring charges.  (optional)
         * @return PUTProductRatePlanChargeRequestBuilder
         */
        public PUTProductRatePlanChargeRequestBuilder billingPeriodAlignment(String billingPeriodAlignment) {
            this.billingPeriodAlignment = billingPeriodAlignment;
            return this;
        }
        
        /**
         * Set billingTiming
         * @param billingTiming The billing timing for the charge. You can choose to bill in advance or in arrears for recurring charge types. This field is not used in one-time or usage based charge types.  This feature is in **Limited Availability**. If you wish to have access to the feature, submit a request at [Zuora Global Support](http://support.zuora.com/).   (optional)
         * @return PUTProductRatePlanChargeRequestBuilder
         */
        public PUTProductRatePlanChargeRequestBuilder billingTiming(String billingTiming) {
            this.billingTiming = billingTiming;
            return this;
        }
        
        /**
         * Set chargeFunction
         * @param chargeFunction **Note**: This field is only available if you have the &lt;a href&#x3D;\\\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Bill_your_customers/Bill_for_usage_or_prepaid_products/Advanced_Consumption_Billing/Unbilled_Usage\\\&quot; target&#x3D;\\\&quot;_blank\\\&quot;&gt;Unbilled Usage&lt;/a&gt; feature enabled.  To use this field, you must set the &#x60;X-Zuora-WSDL-Version&#x60; request header to &#x60;141&#x60; or higher. Otherwise, an error occurs.  This field defines what type of charge it is in Advanced Consumption Billing: * Standard: Normal charge with no Prepayment or Commitment or Drawdown. * Prepayment: For recurring charges. Unit or currency based prepaid charge. * CommitmentTrueUp: For recurring charges. Currency based minimum commitment charge. * Drawdown: For usage charges. Drawdown from prepaid funds. * DrawdownAndCreditCommitment: For usage charges. Drawdown from prepaid funds and then credit to minimum commitment funds. * CreditCommitment: For usage charges. Credit to minimum commitment funds.  (optional)
         * @return PUTProductRatePlanChargeRequestBuilder
         */
        public PUTProductRatePlanChargeRequestBuilder chargeFunction(String chargeFunction) {
            this.chargeFunction = chargeFunction;
            return this;
        }
        
        /**
         * Set commitmentType
         * @param commitmentType **Note**: This field is only available if you have the &lt;a href&#x3D;\\\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Bill_your_customers/Bill_for_usage_or_prepaid_products/Advanced_Consumption_Billing/Unbilled_Usage\\\&quot; target&#x3D;\\\&quot;_blank\\\&quot;&gt;Unbilled Usage&lt;/a&gt; feature enabled.  To use this field, you must set the &#x60;X-Zuora-WSDL-Version&#x60; request header to &#x60;133&#x60; or higher. Otherwise, an error occurs.   This field defines the type of commitment. A prepaid charge can be &#x60;UNIT&#x60; or &#x60;CURRENCY&#x60;. A minimum commitment(in-arrears) charge can only be &#x60;CURRENCY&#x60; type. For topup(recurring or one-time) charges, this field indicates what type of funds are created.  * If UNIT, it will create a fund with given prepaidUom. * If CURRENCY, it will create a fund with the currency amount calculated in list price.  For drawdown(usage) charges, this field indicates what type of funds are drawdown from that created from topup charges.  (optional)
         * @return PUTProductRatePlanChargeRequestBuilder
         */
        public PUTProductRatePlanChargeRequestBuilder commitmentType(String commitmentType) {
            this.commitmentType = commitmentType;
            return this;
        }
        
        /**
         * Set chargeModel
         * @param chargeModel Determines how to calculate charges. Charge models must be individually activated in Zuora Billing administration.  **Notes:**   - The &#x60;Delivery Pricing&#x60; value is available only if you have the Delivery Pricing charge model enabled.   - The &#x60;MultiAttributePricing&#x60; value is available only if you have the Multi-Attribute Pricing charge model enabled. The charge model is available for customers with Enterprise and Nine editions by default. If you are a Growth customer, see [Zuora Editions](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/C_Zuora_Editions) for pricing information.          - The &#x60;PreratedPerUnit&#x60; and  value is available only if you have the Pre-rated Per Unit Pricing charge model enabled. The charge model is available for customers with Enterprise and Nine editions by default. If you are a Growth customer, see [Zuora Editions](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/C_Zuora_Editions) for pricing information.          - The &#x60;PreratedPricing&#x60; value is available only if you have the Pre-rated Pricing charge model enabled. The charge model is available for customers with Enterprise and Nine editions by default. If you are a Growth customer, see [Zuora Editions](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/C_Zuora_Editions) for pricing information.        - The &#x60;HighWatermarkVolumePricing&#x60;value is available only if you have the High Water Mark Volume Pricing charge model enabled. The charge model is available for customers with Enterprise and Nine editions by default. If you are a Growth customer, see [Zuora Editions](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/C_Zuora_Editions) for pricing information.          - The &#x60;HighWatermarkTieredPricing&#x60; value is available only if you have the High Water Mark Tiered Pricing charge model enabled. The charge model is available for customers with Enterprise and Nine editions by default. If you are a Growth customer, see [Zuora Editions](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/C_Zuora_Editions) for pricing information.  (optional)
         * @return PUTProductRatePlanChargeRequestBuilder
         */
        public PUTProductRatePlanChargeRequestBuilder chargeModel(String chargeModel) {
            this.chargeModel = chargeModel;
            return this;
        }
        
        /**
         * Set chargeModelConfiguration
         * @param chargeModelConfiguration  (optional)
         * @return PUTProductRatePlanChargeRequestBuilder
         */
        public PUTProductRatePlanChargeRequestBuilder chargeModelConfiguration(ProxyCreateOrModifyProductRatePlanChargeChargeModelConfiguration chargeModelConfiguration) {
            this.chargeModelConfiguration = chargeModelConfiguration;
            return this;
        }
        
        /**
         * Set creditOption
         * @param creditOption **Note**: This field is only available if you have the [Prepaid with Drawdown](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/J_Billing_Operations/Prepaid_with_Drawdown) feature enabled.  To use this field, you must set the &#x60;X-Zuora-WSDL-Version&#x60; request header to 114 or higher. Otherwise, an error occurs.   The way to calculate credit. See [Credit Option](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/J_Billing_Operations/Prepaid_with_Drawdown/Create_prepayment_charge#Credit_Option) for more information.   (optional)
         * @return PUTProductRatePlanChargeRequestBuilder
         */
        public PUTProductRatePlanChargeRequestBuilder creditOption(String creditOption) {
            this.creditOption = creditOption;
            return this;
        }
        
        /**
         * Set defaultQuantity
         * @param defaultQuantity The default quantity of units, such as the number of authors in a hosted wiki service. This field is required if you use a per-unit pricing model.   **Character limit**: 16  **Values**: a valid quantity value.   **Note:** When the &#x60;ChargeModel&#x60; field is set to &#x60;Tiered Pricing&#x60; or &#x60;Volume Pricing&#x60;, if this field is not specified, the value will default to &#x60;0&#x60;.  (optional)
         * @return PUTProductRatePlanChargeRequestBuilder
         */
        public PUTProductRatePlanChargeRequestBuilder defaultQuantity(Double defaultQuantity) {
            this.defaultQuantity = defaultQuantity;
            return this;
        }
        
        /**
         * Set deferredRevenueAccount
         * @param deferredRevenueAccount The name of the deferred revenue account for this charge.  This feature is in **Limited Availability**. If you wish to have access to the feature, submit a request at [Zuora Global Support](http://support.zuora.com/).   (optional)
         * @return PUTProductRatePlanChargeRequestBuilder
         */
        public PUTProductRatePlanChargeRequestBuilder deferredRevenueAccount(String deferredRevenueAccount) {
            this.deferredRevenueAccount = deferredRevenueAccount;
            return this;
        }
        
        /**
         * Set deliverySchedule
         * @param deliverySchedule  (optional)
         * @return PUTProductRatePlanChargeRequestBuilder
         */
        public PUTProductRatePlanChargeRequestBuilder deliverySchedule(ProxyCreateOrModifyDeliverySchedule deliverySchedule) {
            this.deliverySchedule = deliverySchedule;
            return this;
        }
        
        /**
         * Set description
         * @param description A description of the charge.  (optional)
         * @return PUTProductRatePlanChargeRequestBuilder
         */
        public PUTProductRatePlanChargeRequestBuilder description(String description) {
            this.description = description;
            return this;
        }
        
        /**
         * Set discountLevel
         * @param discountLevel Specifies if the discount applies to just the product rate plan, the entire subscription, or to any activity in the account.  (optional)
         * @return PUTProductRatePlanChargeRequestBuilder
         */
        public PUTProductRatePlanChargeRequestBuilder discountLevel(String discountLevel) {
            this.discountLevel = discountLevel;
            return this;
        }
        
        /**
         * Set drawdownRate
         * @param drawdownRate **Note**: This field is only available if you have the [Prepaid with Drawdown](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/J_Billing_Operations/Prepaid_with_Drawdown) feature enabled.  To use this field, you must set the &#x60;X-Zuora-WSDL-Version&#x60; request header to 114 or higher. Otherwise, an error occurs.  The [conversion rate](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/J_Billing_Operations/Prepaid_with_Drawdown/Create_drawdown_charge#UOM_Conversion) between Usage UOM and Drawdown UOM for a [drawdown charge](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/J_Billing_Operations/Prepaid_with_Drawdown/Create_drawdown_charge). See [Fields related to Prepaid with Drawdown](https://knowledgecenter.zuora.com/Central_Platform/API/G_SOAP_API/E1_SOAP_API_Object_Reference/ProductRatePlanCharge#Fields_related_to_Prepaid_with_Drawdown) for more information.  (optional)
         * @return PUTProductRatePlanChargeRequestBuilder
         */
        public PUTProductRatePlanChargeRequestBuilder drawdownRate(Double drawdownRate) {
            this.drawdownRate = drawdownRate;
            return this;
        }
        
        /**
         * Set drawdownUom
         * @param drawdownUom **Note**: This field is only available if you have the [Prepaid with Drawdown](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/J_Billing_Operations/Prepaid_with_Drawdown) feature enabled.  To use this field, you must set the &#x60;X-Zuora-WSDL-Version&#x60; request header to 114 or higher. Otherwise, an error occurs.   Unit of measurement for a [drawdown charge](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/J_Billing_Operations/Prepaid_with_Drawdown/Create_drawdown_charge).   (optional)
         * @return PUTProductRatePlanChargeRequestBuilder
         */
        public PUTProductRatePlanChargeRequestBuilder drawdownUom(String drawdownUom) {
            this.drawdownUom = drawdownUom;
            return this;
        }
        
        /**
         * Set endDateCondition
         * @param endDateCondition Defines when the charge ends after the charge trigger date.  **Values**:   - &#x60;SubscriptionEnd&#x60;: The charge ends on the subscription end date after a specified period based on the trigger date of the charge.     - &#x60;FixedPeriod&#x60;: The charge ends after a specified period based on the trigger date of the charge. If you set this field to &#x60;FixedPeriod&#x60;, you must specify the length of the period and a period type by defining the &#x60;UpToPeriods&#x60; and &#x60;UpToPeriodsType&#x60; fields.     **Note**: If the subscription ends before the charge end date, the charge ends when the subscription ends. But if the subscription end date is subsequently changed through a Renewal, or Terms and Conditions amendment, the charge will end on the charge end date.  (optional, default to SubscriptionEnd)
         * @return PUTProductRatePlanChargeRequestBuilder
         */
        public PUTProductRatePlanChargeRequestBuilder endDateCondition(String endDateCondition) {
            this.endDateCondition = endDateCondition;
            return this;
        }
        
        /**
         * Set excludeItemBillingFromRevenueAccounting
         * @param excludeItemBillingFromRevenueAccounting The flag to exclude the related invoice items, invoice item adjustments, credit memo items, and debit memo items from revenue accounting.  **Notes**:    - To use this field, you must set the &#x60;X-Zuora-WSDL-Version&#x60; request header to &#x60;115&#x60; or later. Otherwise, an error occurs.   - This field is only available if you have the Order to Revenue or Billing - Revenue Integration feature enabled.   (optional, default to false)
         * @return PUTProductRatePlanChargeRequestBuilder
         */
        public PUTProductRatePlanChargeRequestBuilder excludeItemBillingFromRevenueAccounting(Boolean excludeItemBillingFromRevenueAccounting) {
            this.excludeItemBillingFromRevenueAccounting = excludeItemBillingFromRevenueAccounting;
            return this;
        }
        
        /**
         * Set excludeItemBookingFromRevenueAccounting
         * @param excludeItemBookingFromRevenueAccounting The flag to exclude the related rate plan charges and order line items from revenue accounting.  **Notes**:    - To use this field, you must set the &#x60;X-Zuora-WSDL-Version&#x60; request header to &#x60;115&#x60; or later. Otherwise, an error occurs.   - This field is only available if you have the Order to Revenue or Billing - Revenue Integration feature enabled.   (optional, default to false)
         * @return PUTProductRatePlanChargeRequestBuilder
         */
        public PUTProductRatePlanChargeRequestBuilder excludeItemBookingFromRevenueAccounting(Boolean excludeItemBookingFromRevenueAccounting) {
            this.excludeItemBookingFromRevenueAccounting = excludeItemBookingFromRevenueAccounting;
            return this;
        }
        
        /**
         * Set includedUnits
         * @param includedUnits Specifies the number of units in the base set of units.  **Character limit**: 16  **Values**: a positive decimal value  (optional)
         * @return PUTProductRatePlanChargeRequestBuilder
         */
        public PUTProductRatePlanChargeRequestBuilder includedUnits(Double includedUnits) {
            this.includedUnits = includedUnits;
            return this;
        }
        
        /**
         * Set isAllocationEligible
         * @param isAllocationEligible Indicates whether the charge segment is allocation eligible in revenue recognition. The default value is &#x60;False&#x60;.  **Values**: &#x60;True&#x60;, &#x60;False&#x60;  **Notes**:    - This field is available only if you have the Additional Revenue Fields property enabled.   - To use this field, you must set the &#x60;X-Zuora-WSDL-Version&#x60; request header to 132 or later.  (optional)
         * @return PUTProductRatePlanChargeRequestBuilder
         */
        public PUTProductRatePlanChargeRequestBuilder isAllocationEligible(Boolean isAllocationEligible) {
            this.isAllocationEligible = isAllocationEligible;
            return this;
        }
        
        /**
         * Set isPrepaid
         * @param isPrepaid **Note**: This field is only available if you have the [Prepaid with Drawdown](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/J_Billing_Operations/Prepaid_with_Drawdown) feature enabled.  To use this field, you must set the &#x60;X-Zuora-WSDL-Version&#x60; request header to 114 or higher. Otherwise, an error occurs.   Indicates whether this charge is a prepayment (topup) charge or a drawdown charge.   **Values**: &#x60;true&#x60; or &#x60;false&#x60;.  (optional)
         * @return PUTProductRatePlanChargeRequestBuilder
         */
        public PUTProductRatePlanChargeRequestBuilder isPrepaid(Boolean isPrepaid) {
            this.isPrepaid = isPrepaid;
            return this;
        }
        
        /**
         * Set isRollover
         * @param isRollover **Note**: This field is only available if you have the [Prepaid with Drawdown](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/J_Billing_Operations/Prepaid_with_Drawdown) feature enabled.  To use this field, you must set the &#x60;X-Zuora-WSDL-Version&#x60; request header to 114 or higher. Otherwise, an error occurs.  The value is either \\\&quot;True\\\&quot; or \\\&quot;False\\\&quot;. It determines whether the rollover fields are needed.  (optional)
         * @return PUTProductRatePlanChargeRequestBuilder
         */
        public PUTProductRatePlanChargeRequestBuilder isRollover(Boolean isRollover) {
            this.isRollover = isRollover;
            return this;
        }
        
        /**
         * Set isStackedDiscount
         * @param isStackedDiscount **Note**: This field is only applicable to the Discount - Percentage charge model.  To use this field, you must set the &#x60;X-Zuora-WSDL-Version&#x60; request header to 130 or higher. Otherwise, an error occurs.  This field indicates whether the discount is to be calculated as stacked discount. Possible values are as follows:   - &#x60;True&#x60;: This is a stacked discount, which should be calculated by stacking with other discounts.   - &#x60;False&#x60;: This is not a stacked discount, which should be calculated in sequence with other discounts.  For more information, see [Stacked discounts](https://knowledgecenter.zuora.com/Zuora_Billing/Products/Product_Catalog/B_Charge_Models/B_Discount_Charge_Models).        (optional)
         * @return PUTProductRatePlanChargeRequestBuilder
         */
        public PUTProductRatePlanChargeRequestBuilder isStackedDiscount(Boolean isStackedDiscount) {
            this.isStackedDiscount = isStackedDiscount;
            return this;
        }
        
        /**
         * Set isUnbilled
         * @param isUnbilled Specifies how to perform the accounting during revenue recognition. The default value is &#x60;False&#x60;.  **Values**: &#x60;True&#x60;, &#x60;False&#x60;  **Notes**:    - This field is available only if you have the Additional Revenue Fields property enabled.   - To use this field, you must set the &#x60;X-Zuora-WSDL-Version&#x60; request header to 132 or later.  (optional)
         * @return PUTProductRatePlanChargeRequestBuilder
         */
        public PUTProductRatePlanChargeRequestBuilder isUnbilled(Boolean isUnbilled) {
            this.isUnbilled = isUnbilled;
            return this;
        }
        
        /**
         * Set legacyRevenueReporting
         * @param legacyRevenueReporting  (optional)
         * @return PUTProductRatePlanChargeRequestBuilder
         */
        public PUTProductRatePlanChargeRequestBuilder legacyRevenueReporting(Boolean legacyRevenueReporting) {
            this.legacyRevenueReporting = legacyRevenueReporting;
            return this;
        }
        
        /**
         * Set listPriceBase
         * @param listPriceBase The list price base for the product rate plan charge.  (optional)
         * @return PUTProductRatePlanChargeRequestBuilder
         */
        public PUTProductRatePlanChargeRequestBuilder listPriceBase(String listPriceBase) {
            this.listPriceBase = listPriceBase;
            return this;
        }
        
        /**
         * Set maxQuantity
         * @param maxQuantity Specifies the maximum number of units for this charge. Use this field and the &#x60;MinQuantity&#x60; field to create a range of units allowed in a product rate plan charge.  **Character limit**: 16  **Values**: a positive decimal value  (optional)
         * @return PUTProductRatePlanChargeRequestBuilder
         */
        public PUTProductRatePlanChargeRequestBuilder maxQuantity(Double maxQuantity) {
            this.maxQuantity = maxQuantity;
            return this;
        }
        
        /**
         * Set minQuantity
         * @param minQuantity Specifies the minimum number of units for this charge. Use this field and the &#x60;MaxQuantity&#x60; field to create a range of units allowed in a product rate plan charge.  **Character limit**: 16  **Values**: a positive decimal value  (optional)
         * @return PUTProductRatePlanChargeRequestBuilder
         */
        public PUTProductRatePlanChargeRequestBuilder minQuantity(Double minQuantity) {
            this.minQuantity = minQuantity;
            return this;
        }
        
        /**
         * Set name
         * @param name The name of the product rate plan charge.  (optional)
         * @return PUTProductRatePlanChargeRequestBuilder
         */
        public PUTProductRatePlanChargeRequestBuilder name(String name) {
            this.name = name;
            return this;
        }
        
        /**
         * Set numberOfPeriod
         * @param numberOfPeriod Specifies the number of periods to use when calculating charges in an overage smoothing charge model. The valid value must be a positive whole number.  (optional)
         * @return PUTProductRatePlanChargeRequestBuilder
         */
        public PUTProductRatePlanChargeRequestBuilder numberOfPeriod(Long numberOfPeriod) {
            this.numberOfPeriod = numberOfPeriod;
            return this;
        }
        
        /**
         * Set overageCalculationOption
         * @param overageCalculationOption Determines when to calculate overage charges. If the value of the SmoothingMode field is not specified, the value of this field is ignored.  **Values**:    - &#x60;EndOfSmoothingPeriod&#x60;: This option is used by default. The overage is charged at the end of the smoothing period.   - &#x60;PerBillingPeriod&#x60;: The overage is charged on-demand rather than waiting until the end of the smoothing period.  (optional)
         * @return PUTProductRatePlanChargeRequestBuilder
         */
        public PUTProductRatePlanChargeRequestBuilder overageCalculationOption(String overageCalculationOption) {
            this.overageCalculationOption = overageCalculationOption;
            return this;
        }
        
        /**
         * Set overageUnusedUnitsCreditOption
         * @param overageUnusedUnitsCreditOption Determines whether to credit the customer with unused units of usage.  (optional)
         * @return PUTProductRatePlanChargeRequestBuilder
         */
        public PUTProductRatePlanChargeRequestBuilder overageUnusedUnitsCreditOption(String overageUnusedUnitsCreditOption) {
            this.overageUnusedUnitsCreditOption = overageUnusedUnitsCreditOption;
            return this;
        }
        
        /**
         * Set prepaidQuantity
         * @param prepaidQuantity **Note**: This field is only available if you have the [Prepaid with Drawdown](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/J_Billing_Operations/Prepaid_with_Drawdown) feature enabled.  To use this field, you must set the &#x60;X-Zuora-WSDL-Version&#x60; request header to 114 or higher. Otherwise, an error occurs.   The number of units included in a [prepayment charge](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/J_Billing_Operations/Prepaid_with_Drawdown/Create_prepayment_charge). Must be a positive number.  (optional)
         * @return PUTProductRatePlanChargeRequestBuilder
         */
        public PUTProductRatePlanChargeRequestBuilder prepaidQuantity(Double prepaidQuantity) {
            this.prepaidQuantity = prepaidQuantity;
            return this;
        }
        
        /**
         * Set prepaidUom
         * @param prepaidUom **Note**: This field is only available if you have the [Prepaid with Drawdown](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/J_Billing_Operations/Prepaid_with_Drawdown) feature enabled.  To use this field, you must set the &#x60;X-Zuora-WSDL-Version&#x60; request header to 114 or higher. Otherwise, an error occurs.  Unit of measurement for a [prepayment charge](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/J_Billing_Operations/Prepaid_with_Drawdown/Create_prepayment_charge).  (optional)
         * @return PUTProductRatePlanChargeRequestBuilder
         */
        public PUTProductRatePlanChargeRequestBuilder prepaidUom(String prepaidUom) {
            this.prepaidUom = prepaidUom;
            return this;
        }
        
        /**
         * Set priceChangeOption
         * @param priceChangeOption Applies an automatic price change when a termed subscription is renewed.  (optional, default to NoChange)
         * @return PUTProductRatePlanChargeRequestBuilder
         */
        public PUTProductRatePlanChargeRequestBuilder priceChangeOption(String priceChangeOption) {
            this.priceChangeOption = priceChangeOption;
            return this;
        }
        
        /**
         * Set priceIncreaseOption
         * @param priceIncreaseOption Applies an automatic price change when a termed subscription is renewed.  (optional)
         * @return PUTProductRatePlanChargeRequestBuilder
         */
        public PUTProductRatePlanChargeRequestBuilder priceIncreaseOption(String priceIncreaseOption) {
            this.priceIncreaseOption = priceIncreaseOption;
            return this;
        }
        
        /**
         * Set priceIncreasePercentage
         * @param priceIncreasePercentage Specifies the percentage to increase or decrease the price of a termed subscription&#39;s renewal. Use this field if you set the value to &#x60;SpecificPercentageValue&#x60;.  **Character limit**: 16  **Values**: a decimal value between -100 and 100  (optional)
         * @return PUTProductRatePlanChargeRequestBuilder
         */
        public PUTProductRatePlanChargeRequestBuilder priceIncreasePercentage(Double priceIncreasePercentage) {
            this.priceIncreasePercentage = priceIncreasePercentage;
            return this;
        }
        
        /**
         * Set productCategory
         * @param productCategory This field is used to maintain the product category for integration with Zuora Revenue.   **Notes**:    - This field is available only if you have the Additional Revenue Fields property enabled.   - To use this field, you must set the &#x60;X-Zuora-WSDL-Version&#x60; request header to 132 or later.   (optional)
         * @return PUTProductRatePlanChargeRequestBuilder
         */
        public PUTProductRatePlanChargeRequestBuilder productCategory(String productCategory) {
            this.productCategory = productCategory;
            return this;
        }
        
        /**
         * Set productClass
         * @param productClass This field is used to maintain the product class for integration with Zuora Revenue.   **Notes**:    - This field is available only if you have the Additional Revenue Fields property enabled.   - To use this field, you must set the &#x60;X-Zuora-WSDL-Version&#x60; request header to 132 or later.  (optional)
         * @return PUTProductRatePlanChargeRequestBuilder
         */
        public PUTProductRatePlanChargeRequestBuilder productClass(String productClass) {
            this.productClass = productClass;
            return this;
        }
        
        /**
         * Set productFamily
         * @param productFamily This field is used to maintain the product family for integration with Zuora Revenue.   **Notes**:    - This field is available only if you have the Additional Revenue Fields property enabled.   - To use this field, you must set the &#x60;X-Zuora-WSDL-Version&#x60; request header to 132 or later.  (optional)
         * @return PUTProductRatePlanChargeRequestBuilder
         */
        public PUTProductRatePlanChargeRequestBuilder productFamily(String productFamily) {
            this.productFamily = productFamily;
            return this;
        }
        
        /**
         * Set productLine
         * @param productLine This field is used to maintain the product line for integration with Zuora Revenue.   **Notes**:    - This field is available only if you have the Additional Revenue Fields property enabled.   - To use this field, you must set the &#x60;X-Zuora-WSDL-Version&#x60; request header to 132 or later.                (optional)
         * @return PUTProductRatePlanChargeRequestBuilder
         */
        public PUTProductRatePlanChargeRequestBuilder productLine(String productLine) {
            this.productLine = productLine;
            return this;
        }
        
        /**
         * Set revenueRecognitionTiming
         * @param revenueRecognitionTiming Specifies the type of revenue recognition timing.  Predefined options are listed as enum values in this API Reference.  Other options might also be avaliable depending on  the &lt;a href&#x3D;\\\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Enable_Order_to_Revenue/Configure_revenue_settings/Configure_revenue_recognition_policy\\\&quot; target&#x3D;\\\&quot;_blank\\\&quot;&gt;revenue recognition policy configuration&lt;/a&gt; in the Zuora Billing UI.  **Note**: This field is only available if you have the Order to Revenue feature enabled.   (optional)
         * @return PUTProductRatePlanChargeRequestBuilder
         */
        public PUTProductRatePlanChargeRequestBuilder revenueRecognitionTiming(String revenueRecognitionTiming) {
            this.revenueRecognitionTiming = revenueRecognitionTiming;
            return this;
        }
        
        /**
         * Set revenueAmortizationMethod
         * @param revenueAmortizationMethod Specifies the type of revenue amortization method.  Predefined options are listed as enum values in this API Reference.  Other options might also be avaliable depending on  the &lt;a href&#x3D;\\\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Enable_Order_to_Revenue/Configure_revenue_settings/Configure_revenue_recognition_policy\\\&quot; target&#x3D;\\\&quot;_blank\\\&quot;&gt;revenue recognition policy configuration&lt;/a&gt; in the Zuora Billing UI.  **Note**: This field is only available if you have the Order to Revenue feature enabled.   (optional)
         * @return PUTProductRatePlanChargeRequestBuilder
         */
        public PUTProductRatePlanChargeRequestBuilder revenueAmortizationMethod(String revenueAmortizationMethod) {
            this.revenueAmortizationMethod = revenueAmortizationMethod;
            return this;
        }
        
        /**
         * Set productRatePlanChargeNumber
         * @param productRatePlanChargeNumber The natural key of the product rate plan charge.   For existing Product Rate Plan Charge objects that are created before this field is introduced, this field will be null. Use this field to specify a value for only these objects. Zuora also provides a tool to help you automatically backfill this field with tenant ID for your existing product catalog. If you want to use this backfill tool, contact [Zuora Global Support](https://support.zuora.com/).  **Note**: This field is only available if you set the &#x60;X-Zuora-WSDL-Version&#x60; request header to &#x60;133&#x60; or later.  (optional)
         * @return PUTProductRatePlanChargeRequestBuilder
         */
        public PUTProductRatePlanChargeRequestBuilder productRatePlanChargeNumber(String productRatePlanChargeNumber) {
            this.productRatePlanChargeNumber = productRatePlanChargeNumber;
            return this;
        }
        
        /**
         * Set productRatePlanChargeTierData
         * @param productRatePlanChargeTierData  (optional)
         * @return PUTProductRatePlanChargeRequestBuilder
         */
        public PUTProductRatePlanChargeRequestBuilder productRatePlanChargeTierData(ProxyCreateOrModifyProductRatePlanChargeTierData productRatePlanChargeTierData) {
            this.productRatePlanChargeTierData = productRatePlanChargeTierData;
            return this;
        }
        
        /**
         * Set productRatePlanId
         * @param productRatePlanId The ID of the product rate plan associated with this product rate plan charge.  (optional)
         * @return PUTProductRatePlanChargeRequestBuilder
         */
        public PUTProductRatePlanChargeRequestBuilder productRatePlanId(String productRatePlanId) {
            this.productRatePlanId = productRatePlanId;
            return this;
        }
        
        /**
         * Set ratingGroup
         * @param ratingGroup Specifies a rating group based on which usage records are rated.  Possible values:   - &#x60;ByBillingPeriod&#x60;: The rating is based on all the usages in a billing period.    - &#x60;ByUsageStartDate&#x60;: The rating is based on all the usages on the same usage start date.    - &#x60;ByUsageRecord&#x60;: The rating is based on each usage record.   - &#x60;ByUsageUpload&#x60;: The rating is based on all the  usages in a uploaded usage file (&#x60;.xls&#x60; or &#x60;.csv&#x60;).   - &#x60;ByGroupId&#x60;: The rating is based on all the usages in a custom group.  **Note:**    - The &#x60;ByBillingPeriod&#x60; value can be applied for all charge models.    - The &#x60;ByUsageStartDate&#x60;, &#x60;ByUsageRecord&#x60;, and &#x60;ByUsageUpload&#x60; values can only be applied for per unit, volume pricing, and tiered pricing charge models.    - The &#x60;ByGroupId&#x60; value is only available if you have the Active Rating feature enabled.   - Use this field only for Usage charges. One-Time Charges and Recurring Charges return &#x60;NULL&#x60;.  (optional, default to ByBillingPeriod)
         * @return PUTProductRatePlanChargeRequestBuilder
         */
        public PUTProductRatePlanChargeRequestBuilder ratingGroup(String ratingGroup) {
            this.ratingGroup = ratingGroup;
            return this;
        }
        
        /**
         * Set recognizedRevenueAccount
         * @param recognizedRevenueAccount The name of the recognized revenue account for this charge.   - Required when the Allow Blank Accounting Code setting is No.   - Optional when the Allow Blank Accounting Code setting is Yes.    This feature is in **Limited Availability**. If you wish to have access to the feature, submit a request at [Zuora Global Support](http://support.zuora.com/).   (optional)
         * @return PUTProductRatePlanChargeRequestBuilder
         */
        public PUTProductRatePlanChargeRequestBuilder recognizedRevenueAccount(String recognizedRevenueAccount) {
            this.recognizedRevenueAccount = recognizedRevenueAccount;
            return this;
        }
        
        /**
         * Set revRecCode
         * @param revRecCode Associates this product rate plan charge with a specific revenue recognition code.  (optional)
         * @return PUTProductRatePlanChargeRequestBuilder
         */
        public PUTProductRatePlanChargeRequestBuilder revRecCode(String revRecCode) {
            this.revRecCode = revRecCode;
            return this;
        }
        
        /**
         * Set revRecTriggerCondition
         * @param revRecTriggerCondition Specifies when revenue recognition begins.  (optional)
         * @return PUTProductRatePlanChargeRequestBuilder
         */
        public PUTProductRatePlanChargeRequestBuilder revRecTriggerCondition(String revRecTriggerCondition) {
            this.revRecTriggerCondition = revRecTriggerCondition;
            return this;
        }
        
        /**
         * Set revenueRecognitionRuleName
         * @param revenueRecognitionRuleName Determines when to recognize the revenue for this charge.  (optional)
         * @return PUTProductRatePlanChargeRequestBuilder
         */
        public PUTProductRatePlanChargeRequestBuilder revenueRecognitionRuleName(String revenueRecognitionRuleName) {
            this.revenueRecognitionRuleName = revenueRecognitionRuleName;
            return this;
        }
        
        /**
         * Set rolloverApply
         * @param rolloverApply **Note**: This field is only available if you have the [Prepaid with Drawdown](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/J_Billing_Operations/Prepaid_with_Drawdown) feature enabled.  To use this field, you must set the &#x60;X-Zuora-WSDL-Version&#x60; request header to 114 or higher. Otherwise, an error occurs.  This field defines the priority of rollover, which is either first or last.  (optional)
         * @return PUTProductRatePlanChargeRequestBuilder
         */
        public PUTProductRatePlanChargeRequestBuilder rolloverApply(String rolloverApply) {
            this.rolloverApply = rolloverApply;
            return this;
        }
        
        /**
         * Set rolloverPeriods
         * @param rolloverPeriods **Note**: This field is only available if you have the [Prepaid with Drawdown](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/J_Billing_Operations/Prepaid_with_Drawdown) feature enabled.  To use this field, you must set the &#x60;X-Zuora-WSDL-Version&#x60; request header to 114 or higher. Otherwise, an error occurs.  This field defines the number of rollover periods, it is restricted to 3.  (optional)
         * @return PUTProductRatePlanChargeRequestBuilder
         */
        public PUTProductRatePlanChargeRequestBuilder rolloverPeriods(Double rolloverPeriods) {
            this.rolloverPeriods = rolloverPeriods;
            return this;
        }
        
        /**
         * Set smoothingModel
         * @param smoothingModel Specifies the smoothing model for an overage smoothing charge model.  (optional)
         * @return PUTProductRatePlanChargeRequestBuilder
         */
        public PUTProductRatePlanChargeRequestBuilder smoothingModel(String smoothingModel) {
            this.smoothingModel = smoothingModel;
            return this;
        }
        
        /**
         * Set specificBillingPeriod
         * @param specificBillingPeriod Customizes the number of months or weeks for the charges billing period. This field is required if you set the value of the BillingPeriod field to &#x60;Specific Months&#x60; or &#x60;Specific Weeks&#x60;. The valid value is a positive integer.  (optional)
         * @return PUTProductRatePlanChargeRequestBuilder
         */
        public PUTProductRatePlanChargeRequestBuilder specificBillingPeriod(Long specificBillingPeriod) {
            this.specificBillingPeriod = specificBillingPeriod;
            return this;
        }
        
        /**
         * Set specificListPriceBase
         * @param specificListPriceBase The number of months for the list price base of the charge. This field is required if you set the value of the &#x60;ListPriceBase&#x60; field to &#x60;Per Specific Months&#x60;.  **Notes**:    - This field is available only if you have the &lt;a href&#x3D;\\\&quot;https://knowledgecenter.zuora.com/Billing/Subscriptions/Product_Catalog/I_Annual_List_Price\\\&quot; target&#x3D;\\\&quot;_blank\\\&quot;&gt;Annual List Price&lt;/a&gt; feature enabled.   - To use this field, you must set the &#x60;X-Zuora-WSDL-Version&#x60; request header to &#x60;129&#x60; or later. Otherwise, an error occurs.   - The value of this field is &#x60;null&#x60; if you do not set the value of the &#x60;ListPriceBase&#x60; field to &#x60;Per Specific Months&#x60;.  (optional)
         * @return PUTProductRatePlanChargeRequestBuilder
         */
        public PUTProductRatePlanChargeRequestBuilder specificListPriceBase(Integer specificListPriceBase) {
            this.specificListPriceBase = specificListPriceBase;
            return this;
        }
        
        /**
         * Set taxCode
         * @param taxCode Specifies the tax code for taxation rules. Required when the Taxable field is set to &#x60;True&#x60;.  **Note**: This value affects the tax calculation of rate plan charges that come from the &#x60;ProductRatePlanCharge&#x60;.  (optional)
         * @return PUTProductRatePlanChargeRequestBuilder
         */
        public PUTProductRatePlanChargeRequestBuilder taxCode(String taxCode) {
            this.taxCode = taxCode;
            return this;
        }
        
        /**
         * Set taxMode
         * @param taxMode Determines how to define taxation for the charge. Required when the Taxable field is set to &#x60;True&#x60;.  **Note**: This value affects the tax calculation of rate plan charges that come from the &#x60;ProductRatePlanCharge&#x60;.  (optional)
         * @return PUTProductRatePlanChargeRequestBuilder
         */
        public PUTProductRatePlanChargeRequestBuilder taxMode(String taxMode) {
            this.taxMode = taxMode;
            return this;
        }
        
        /**
         * Set taxable
         * @param taxable Determines whether the charge is taxable. When set to &#x60;True&#x60;, the TaxMode and TaxCode fields are required when creating or updating th ProductRatePlanCharge object.  **Character limit**: 5  **Values**: &#x60;True&#x60;, &#x60;False&#x60;  **Note**: This value affects the tax calculation of rate plan charges that come from the &#x60;ProductRatePlanCharge&#x60;.  (optional)
         * @return PUTProductRatePlanChargeRequestBuilder
         */
        public PUTProductRatePlanChargeRequestBuilder taxable(Boolean taxable) {
            this.taxable = taxable;
            return this;
        }
        
        /**
         * Set triggerEvent
         * @param triggerEvent Specifies when to start billing the customer for the charge.  **Values**:   - &#x60;ContractEffective&#x60; is the date when the subscription&#39;s contract goes into effect and the charge is ready to be billed.   - &#x60;ServiceActivation&#x60; is the date when the services or products for a subscription have been activated and the customers have access.   - &#x60;CustomerAcceptance&#x60; is when the customer accepts the services or products for a subscription.  (optional)
         * @return PUTProductRatePlanChargeRequestBuilder
         */
        public PUTProductRatePlanChargeRequestBuilder triggerEvent(String triggerEvent) {
            this.triggerEvent = triggerEvent;
            return this;
        }
        
        /**
         * Set UOM
         * @param UOM Specifies the units to measure usage.   **Note**: You must specify this field when creating the following charge models:   - Per Unit Pricing   - Volume Pricing   - Overage Pricing   - Tiered Pricing   - Tiered with Overage Pricing  (optional)
         * @return PUTProductRatePlanChargeRequestBuilder
         */
        public PUTProductRatePlanChargeRequestBuilder UOM(String UOM) {
            this.UOM = UOM;
            return this;
        }
        
        /**
         * Set upToPeriods
         * @param upToPeriods Specifies the length of the period during which the charge is active. If this period ends before the subscription ends, the charge ends when this period ends.  **Character limit**: 5  **Values**: a whole number between 0 and 65535, exclusive  **Notes**:   - You must use this field together with the &#x60;UpToPeriodsType&#x60; field to specify the time period. This field is applicable only when the &#x60;EndDateCondition&#x60; field is set to &#x60;FixedPeriod&#x60;.    - If the subscription end date is subsequently changed through a Renewal, or Terms and Conditions amendment, the charge end date will change accordingly up to the original period end.  (optional)
         * @return PUTProductRatePlanChargeRequestBuilder
         */
        public PUTProductRatePlanChargeRequestBuilder upToPeriods(Long upToPeriods) {
            this.upToPeriods = upToPeriods;
            return this;
        }
        
        /**
         * Set upToPeriodsType
         * @param upToPeriodsType The period type used to define when the charge ends.  **Notes**:   - You must use this field together with the &#x60;UpToPeriods&#x60; field to specify the time period.  - This field is applicable only when the &#x60;EndDateCondition&#x60; field is set to &#x60;FixedPeriod&#x60;.   (optional, default to Billing Periods)
         * @return PUTProductRatePlanChargeRequestBuilder
         */
        public PUTProductRatePlanChargeRequestBuilder upToPeriodsType(String upToPeriodsType) {
            this.upToPeriodsType = upToPeriodsType;
            return this;
        }
        
        /**
         * Set usageRecordRatingOption
         * @param usageRecordRatingOption Determines how Zuora processes usage records for per-unit usage charges.   (optional, default to EndOfBillingPeriod)
         * @return PUTProductRatePlanChargeRequestBuilder
         */
        public PUTProductRatePlanChargeRequestBuilder usageRecordRatingOption(String usageRecordRatingOption) {
            this.usageRecordRatingOption = usageRecordRatingOption;
            return this;
        }
        
        /**
         * Set useDiscountSpecificAccountingCode
         * @param useDiscountSpecificAccountingCode Determines whether to define a new accounting code for the new discount charge.  **Character limit**: 5  **Values**: &#x60;True&#x60;, &#x60;False&#x60;  (optional)
         * @return PUTProductRatePlanChargeRequestBuilder
         */
        public PUTProductRatePlanChargeRequestBuilder useDiscountSpecificAccountingCode(Boolean useDiscountSpecificAccountingCode) {
            this.useDiscountSpecificAccountingCode = useDiscountSpecificAccountingCode;
            return this;
        }
        
        /**
         * Set useTenantDefaultForPriceChange
         * @param useTenantDefaultForPriceChange Applies the tenant-level percentage uplift value for an automatic price change to a termed subscription&#39;s renewal.   **Character limit**: 5  **Values**: &#x60;true&#x60;, &#x60;false&#x60;  (optional)
         * @return PUTProductRatePlanChargeRequestBuilder
         */
        public PUTProductRatePlanChargeRequestBuilder useTenantDefaultForPriceChange(Boolean useTenantDefaultForPriceChange) {
            this.useTenantDefaultForPriceChange = useTenantDefaultForPriceChange;
            return this;
        }
        
        /**
         * Set validityPeriodType
         * @param validityPeriodType **Note**: This field is only available if you have the [Prepaid with Drawdown](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/J_Billing_Operations/Prepaid_with_Drawdown) feature enabled.  To use this field, you must set the &#x60;X-Zuora-WSDL-Version&#x60; request header to 114 or higher. Otherwise, an error occurs.   The period in which the prepayment units are valid to use as defined in a [prepayment charge](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/J_Billing_Operations/Prepaid_with_Drawdown/Create_prepayment_charge).  (optional)
         * @return PUTProductRatePlanChargeRequestBuilder
         */
        public PUTProductRatePlanChargeRequestBuilder validityPeriodType(String validityPeriodType) {
            this.validityPeriodType = validityPeriodType;
            return this;
        }
        
        /**
         * Set weeklyBillCycleDay
         * @param weeklyBillCycleDay Specifies which day of the week as the bill cycle day (BCD) for the charge.  This feature is in **Limited Availability**. If you wish to have access to the feature, submit a request at [Zuora Global Support](http://support.zuora.com/).   (optional)
         * @return PUTProductRatePlanChargeRequestBuilder
         */
        public PUTProductRatePlanChargeRequestBuilder weeklyBillCycleDay(String weeklyBillCycleDay) {
            this.weeklyBillCycleDay = weeklyBillCycleDay;
            return this;
        }
        
        /**
         * Set applyToBillingPeriodPartially
         * @param applyToBillingPeriodPartially Allow the discount duration to be aligned with the billing period partially.  **Note**: You must enable the [Enhanced Discount](https://knowledgecenter.zuora.com/Zuora_Billing/Build_products_and_prices/Basic_concepts_and_terms/B_Charge_Models/D_Manage_Enhanced_Discount) feature to access this field.  (optional)
         * @return PUTProductRatePlanChargeRequestBuilder
         */
        public PUTProductRatePlanChargeRequestBuilder applyToBillingPeriodPartially(Boolean applyToBillingPeriodPartially) {
            this.applyToBillingPeriodPartially = applyToBillingPeriodPartially;
            return this;
        }
        
        /**
         * Set rolloverPeriodLength
         * @param rolloverPeriodLength **Note**: This field is only available if you have the [Prepaid with Drawdown](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/J_Billing_Operations/Prepaid_with_Drawdown) feature enabled.  To use this field, you must set the &#x60;X-Zuora-WSDL-Version&#x60; request header to 137 or higher. Otherwise, an error occurs.  The period length of the rollover fund.  (optional)
         * @return PUTProductRatePlanChargeRequestBuilder
         */
        public PUTProductRatePlanChargeRequestBuilder rolloverPeriodLength(Integer rolloverPeriodLength) {
            this.rolloverPeriodLength = rolloverPeriodLength;
            return this;
        }
        
        /**
         * Set formula
         * @param formula The price lookup formula defined for the product rate plan charge, which is used to identify the correct and relevant charge definition based on the context.  For more information, see &lt;a href&#x3D;\\\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Build_products_and_prices/Attribute-based_pricing/Price_lookup_in_Attribute-based_Pricing\\\&quot;  target&#x3D;\\\&quot;_blank\\\&quot;&gt;Price lookup in Attribute-based Pricing&lt;/a&gt;.   **Notes**:    - This field is available only if the &lt;a href&#x3D;\\\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Build_products_and_prices/Attribute-based_pricing\\\&quot; target&#x3D;\\\&quot;_blank\\\&quot;&gt;Attribute-based Pricing&lt;/a&gt; feature is enabled.   - To use this field, you must set the &#x60;X-Zuora-WSDL-Version&#x60; request header to 138 or higher.  (optional)
         * @return PUTProductRatePlanChargeRequestBuilder
         */
        public PUTProductRatePlanChargeRequestBuilder formula(String formula) {
            this.formula = formula;
            return this;
        }
        
        /**
         * Set classNS
         * @param classNS Class associated with the corresponding item in NetSuite. Only available if you have installed the [Zuora Connector for NetSuite](https://www.zuora.com/connect/app/?appId&#x3D;265).  (optional)
         * @return PUTProductRatePlanChargeRequestBuilder
         */
        public PUTProductRatePlanChargeRequestBuilder classNS(String classNS) {
            this.classNS = classNS;
            return this;
        }
        
        /**
         * Set deferredRevAccountNS
         * @param deferredRevAccountNS Deferrred revenue account associated with the corresponding item in NetSuite. Only available if you have installed the [Zuora Connector for NetSuite](https://www.zuora.com/connect/app/?appId&#x3D;265).  (optional)
         * @return PUTProductRatePlanChargeRequestBuilder
         */
        public PUTProductRatePlanChargeRequestBuilder deferredRevAccountNS(String deferredRevAccountNS) {
            this.deferredRevAccountNS = deferredRevAccountNS;
            return this;
        }
        
        /**
         * Set departmentNS
         * @param departmentNS Department associated with the corresponding item in NetSuite. Only available if you have installed the [Zuora Connector for NetSuite](https://www.zuora.com/connect/app/?appId&#x3D;265).  (optional)
         * @return PUTProductRatePlanChargeRequestBuilder
         */
        public PUTProductRatePlanChargeRequestBuilder departmentNS(String departmentNS) {
            this.departmentNS = departmentNS;
            return this;
        }
        
        /**
         * Set includeChildrenNS
         * @param includeChildrenNS Specifies whether the corresponding item in NetSuite is visible under child subsidiaries. Only available if you have installed the [Zuora Connector for NetSuite](https://www.zuora.com/connect/app/?appId&#x3D;265).  (optional)
         * @return PUTProductRatePlanChargeRequestBuilder
         */
        public PUTProductRatePlanChargeRequestBuilder includeChildrenNS(String includeChildrenNS) {
            this.includeChildrenNS = includeChildrenNS;
            return this;
        }
        
        /**
         * Set integrationIdNS
         * @param integrationIdNS ID of the corresponding object in NetSuite. Only available if you have installed the [Zuora Connector for NetSuite](https://www.zuora.com/connect/app/?appId&#x3D;265).  (optional)
         * @return PUTProductRatePlanChargeRequestBuilder
         */
        public PUTProductRatePlanChargeRequestBuilder integrationIdNS(String integrationIdNS) {
            this.integrationIdNS = integrationIdNS;
            return this;
        }
        
        /**
         * Set integrationStatusNS
         * @param integrationStatusNS Status of the product rate plan charge&#39;s synchronization with NetSuite. Only available if you have installed the [Zuora Connector for NetSuite](https://www.zuora.com/connect/app/?appId&#x3D;265).  (optional)
         * @return PUTProductRatePlanChargeRequestBuilder
         */
        public PUTProductRatePlanChargeRequestBuilder integrationStatusNS(String integrationStatusNS) {
            this.integrationStatusNS = integrationStatusNS;
            return this;
        }
        
        /**
         * Set itemTypeNS
         * @param itemTypeNS Type of item that is created in NetSuite for the product rate plan charge. Only available if you have installed the [Zuora Connector for NetSuite](https://www.zuora.com/connect/app/?appId&#x3D;265).  (optional)
         * @return PUTProductRatePlanChargeRequestBuilder
         */
        public PUTProductRatePlanChargeRequestBuilder itemTypeNS(String itemTypeNS) {
            this.itemTypeNS = itemTypeNS;
            return this;
        }
        
        /**
         * Set locationNS
         * @param locationNS Location associated with the corresponding item in NetSuite. Only available if you have installed the [Zuora Connector for NetSuite](https://www.zuora.com/connect/app/?appId&#x3D;265).  (optional)
         * @return PUTProductRatePlanChargeRequestBuilder
         */
        public PUTProductRatePlanChargeRequestBuilder locationNS(String locationNS) {
            this.locationNS = locationNS;
            return this;
        }
        
        /**
         * Set recognizedRevAccountNS
         * @param recognizedRevAccountNS Recognized revenue account associated with the corresponding item in NetSuite. Only available if you have installed the [Zuora Connector for NetSuite](https://www.zuora.com/connect/app/?appId&#x3D;265).  (optional)
         * @return PUTProductRatePlanChargeRequestBuilder
         */
        public PUTProductRatePlanChargeRequestBuilder recognizedRevAccountNS(String recognizedRevAccountNS) {
            this.recognizedRevAccountNS = recognizedRevAccountNS;
            return this;
        }
        
        /**
         * Set revRecEndNS
         * @param revRecEndNS End date condition of the corresponding item in NetSuite. Only available if you have installed the [Zuora Connector for NetSuite](https://www.zuora.com/connect/app/?appId&#x3D;265).  (optional)
         * @return PUTProductRatePlanChargeRequestBuilder
         */
        public PUTProductRatePlanChargeRequestBuilder revRecEndNS(String revRecEndNS) {
            this.revRecEndNS = revRecEndNS;
            return this;
        }
        
        /**
         * Set revRecStartNS
         * @param revRecStartNS Start date condition of the corresponding item in NetSuite. Only available if you have installed the [Zuora Connector for NetSuite](https://www.zuora.com/connect/app/?appId&#x3D;265).  (optional)
         * @return PUTProductRatePlanChargeRequestBuilder
         */
        public PUTProductRatePlanChargeRequestBuilder revRecStartNS(String revRecStartNS) {
            this.revRecStartNS = revRecStartNS;
            return this;
        }
        
        /**
         * Set revRecTemplateTypeNS
         * @param revRecTemplateTypeNS Only available if you have installed the [Zuora Connector for NetSuite](https://www.zuora.com/connect/app/?appId&#x3D;265).  (optional)
         * @return PUTProductRatePlanChargeRequestBuilder
         */
        public PUTProductRatePlanChargeRequestBuilder revRecTemplateTypeNS(String revRecTemplateTypeNS) {
            this.revRecTemplateTypeNS = revRecTemplateTypeNS;
            return this;
        }
        
        /**
         * Set subsidiaryNS
         * @param subsidiaryNS Subsidiary associated with the corresponding item in NetSuite. Only available if you have installed the [Zuora Connector for NetSuite](https://www.zuora.com/connect/app/?appId&#x3D;265).  (optional)
         * @return PUTProductRatePlanChargeRequestBuilder
         */
        public PUTProductRatePlanChargeRequestBuilder subsidiaryNS(String subsidiaryNS) {
            this.subsidiaryNS = subsidiaryNS;
            return this;
        }
        
        /**
         * Set syncDateNS
         * @param syncDateNS Date when the product rate plan charge was synchronized with NetSuite. Only available if you have installed the [Zuora Connector for NetSuite](https://www.zuora.com/connect/app/?appId&#x3D;265).  (optional)
         * @return PUTProductRatePlanChargeRequestBuilder
         */
        public PUTProductRatePlanChargeRequestBuilder syncDateNS(String syncDateNS) {
            this.syncDateNS = syncDateNS;
            return this;
        }
        
        /**
         * Set acceptEncoding
         * @param acceptEncoding Include the &#x60;Accept-Encoding: gzip&#x60; header to compress responses as a gzipped file. It can significantly reduce the bandwidth required for a response.   If specified, Zuora automatically compresses responses that contain over 1000 bytes of data, and the response contains a &#x60;Content-Encoding&#x60; header with the compression algorithm so that your client can decompress it.  (optional)
         * @return PUTProductRatePlanChargeRequestBuilder
         */
        public PUTProductRatePlanChargeRequestBuilder acceptEncoding(String acceptEncoding) {
            this.acceptEncoding = acceptEncoding;
            return this;
        }
        
        /**
         * Set contentEncoding
         * @param contentEncoding Include the &#x60;Content-Encoding: gzip&#x60; header to compress a request. With this header specified, you should upload a gzipped file for the request payload instead of sending the JSON payload.  (optional)
         * @return PUTProductRatePlanChargeRequestBuilder
         */
        public PUTProductRatePlanChargeRequestBuilder contentEncoding(String contentEncoding) {
            this.contentEncoding = contentEncoding;
            return this;
        }
        
        /**
         * Set authorization
         * @param authorization The value is in the &#x60;Bearer {token}&#x60; format where {token} is a valid OAuth token generated by calling [Create an OAuth token](https://developer.zuora.com/api-references/api/operation/createToken).  (optional)
         * @return PUTProductRatePlanChargeRequestBuilder
         */
        public PUTProductRatePlanChargeRequestBuilder authorization(String authorization) {
            this.authorization = authorization;
            return this;
        }
        
        /**
         * Set rejectUnknownFields
         * @param rejectUnknownFields Specifies whether the call fails if the request body contains unknown fields. With &#x60;rejectUnknownFields&#x60; set to &#x60;true&#x60;, Zuora returns a 400 response if the request body contains unknown fields. The body of the 400 response is:  &#x60;&#x60;&#x60;json {     \&quot;message\&quot;: \&quot;Error - unrecognised fields\&quot; } &#x60;&#x60;&#x60;  By default, Zuora ignores unknown fields in the request body.  (optional, default to false)
         * @return PUTProductRatePlanChargeRequestBuilder
         */
        public PUTProductRatePlanChargeRequestBuilder rejectUnknownFields(Boolean rejectUnknownFields) {
            this.rejectUnknownFields = rejectUnknownFields;
            return this;
        }
        
        /**
         * Set zuoraEntityIds
         * @param zuoraEntityIds An entity ID. If you have [Zuora Multi-entity](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Multi-entity) enabled and the OAuth token is valid for more than one entity, you must use this header to specify which entity to perform the operation in. If the OAuth token is only valid for a single entity, or you do not have Zuora Multi-entity enabled, you do not need to set this header.  (optional)
         * @return PUTProductRatePlanChargeRequestBuilder
         */
        public PUTProductRatePlanChargeRequestBuilder zuoraEntityIds(String zuoraEntityIds) {
            this.zuoraEntityIds = zuoraEntityIds;
            return this;
        }
        
        /**
         * Set zuoraOrgIds
         * @param zuoraOrgIds Comma separated IDs. If you have &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Central_Platform/Multi-Org\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Zuora Multi-Org&lt;/a&gt; enabled,  you can use this header to specify which orgs to perform the operation in. If you do not have Zuora Multi-Org enabled, you should not set this header.  The IDs must be a sub-set of the user&#39;s accessible orgs. If you specify an org that the user does not have access to, the operation fails.  If the header is not set, the operation is performed in scope of the user&#39;s accessible orgs.  (optional)
         * @return PUTProductRatePlanChargeRequestBuilder
         */
        public PUTProductRatePlanChargeRequestBuilder zuoraOrgIds(String zuoraOrgIds) {
            this.zuoraOrgIds = zuoraOrgIds;
            return this;
        }
        
        /**
         * Set zuoraTrackId
         * @param zuoraTrackId A custom identifier for tracing the API call. If you set a value for this header, Zuora returns the same value in the response headers. This header enables you to associate your system process identifiers with Zuora API calls, to assist with troubleshooting in the event of an issue.  The value of this field must use the US-ASCII character set and must not include any of the following characters: colon (&#x60;:&#x60;), semicolon (&#x60;;&#x60;), double quote (&#x60;\&quot;&#x60;), and quote (&#x60;&#39;&#x60;).  (optional)
         * @return PUTProductRatePlanChargeRequestBuilder
         */
        public PUTProductRatePlanChargeRequestBuilder zuoraTrackId(String zuoraTrackId) {
            this.zuoraTrackId = zuoraTrackId;
            return this;
        }
        
        /**
         * Set xZuoraWSDLVersion
         * @param xZuoraWSDLVersion Zuora WSDL version number.  (optional, default to 79)
         * @return PUTProductRatePlanChargeRequestBuilder
         */
        public PUTProductRatePlanChargeRequestBuilder xZuoraWSDLVersion(String xZuoraWSDLVersion) {
            this.xZuoraWSDLVersion = xZuoraWSDLVersion;
            return this;
        }
        
        /**
         * Build call for pUTProductRatePlanCharge
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
            ProxyModifyProductRatePlanCharge proxyModifyProductRatePlanCharge = buildBodyParams();
            return pUTProductRatePlanChargeCall(id, proxyModifyProductRatePlanCharge, acceptEncoding, contentEncoding, authorization, rejectUnknownFields, zuoraEntityIds, zuoraOrgIds, zuoraTrackId, xZuoraWSDLVersion, _callback);
        }

        private ProxyModifyProductRatePlanCharge buildBodyParams() {
            return this.proxyModifyProductRatePlanCharge;
        }

        /**
         * Execute pUTProductRatePlanCharge request
         * @return ProxyCreateOrModifyResponse
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td>  </td><td>  * Content-Encoding - This header is returned if you specify the &#x60;Accept-Encoding: gzip&#x60; request header and the response contains over 1000 bytes of data. Note that only the following MIME types support gzipped responses:   - &#x60;application/json&#x60;   - &#x60;application/xml&#x60;   - &#x60;text/html&#x60;   - &#x60;text/csv&#x60;   - &#x60;text/plain&#x60;  <br>  * RateLimit-Limit - The request limit quota for the time window closest to exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Remaining - The number of requests remaining in the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Reset - The number of seconds until the quota resets for the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Zuora-Request-Id - The Zuora internal identifier of the API call. You cannot control the value of this header.  <br>  * Zuora-Track-Id - A custom identifier for tracing the API call. If you specified a tracing identifier in the request headers, Zuora returns the same tracing identifier. Otherwise, Zuora does not set this header.  <br>  </td></tr>
         </table>
         */
        public ProxyCreateOrModifyResponse execute() throws ApiException {
            ProxyModifyProductRatePlanCharge proxyModifyProductRatePlanCharge = buildBodyParams();
            ApiResponse<ProxyCreateOrModifyResponse> localVarResp = pUTProductRatePlanChargeWithHttpInfo(id, proxyModifyProductRatePlanCharge, acceptEncoding, contentEncoding, authorization, rejectUnknownFields, zuoraEntityIds, zuoraOrgIds, zuoraTrackId, xZuoraWSDLVersion);
            return localVarResp.getResponseBody();
        }

        /**
         * Execute pUTProductRatePlanCharge request with HTTP info returned
         * @return ApiResponse&lt;ProxyCreateOrModifyResponse&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td>  </td><td>  * Content-Encoding - This header is returned if you specify the &#x60;Accept-Encoding: gzip&#x60; request header and the response contains over 1000 bytes of data. Note that only the following MIME types support gzipped responses:   - &#x60;application/json&#x60;   - &#x60;application/xml&#x60;   - &#x60;text/html&#x60;   - &#x60;text/csv&#x60;   - &#x60;text/plain&#x60;  <br>  * RateLimit-Limit - The request limit quota for the time window closest to exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Remaining - The number of requests remaining in the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Reset - The number of seconds until the quota resets for the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Zuora-Request-Id - The Zuora internal identifier of the API call. You cannot control the value of this header.  <br>  * Zuora-Track-Id - A custom identifier for tracing the API call. If you specified a tracing identifier in the request headers, Zuora returns the same tracing identifier. Otherwise, Zuora does not set this header.  <br>  </td></tr>
         </table>
         */
        public ApiResponse<ProxyCreateOrModifyResponse> executeWithHttpInfo() throws ApiException {
            ProxyModifyProductRatePlanCharge proxyModifyProductRatePlanCharge = buildBodyParams();
            return pUTProductRatePlanChargeWithHttpInfo(id, proxyModifyProductRatePlanCharge, acceptEncoding, contentEncoding, authorization, rejectUnknownFields, zuoraEntityIds, zuoraOrgIds, zuoraTrackId, xZuoraWSDLVersion);
        }

        /**
         * Execute pUTProductRatePlanCharge request (asynchronously)
         * @param _callback The callback to be executed when the API call finishes
         * @return The request call
         * @throws ApiException If fail to process the API call, e.g. serializing the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td>  </td><td>  * Content-Encoding - This header is returned if you specify the &#x60;Accept-Encoding: gzip&#x60; request header and the response contains over 1000 bytes of data. Note that only the following MIME types support gzipped responses:   - &#x60;application/json&#x60;   - &#x60;application/xml&#x60;   - &#x60;text/html&#x60;   - &#x60;text/csv&#x60;   - &#x60;text/plain&#x60;  <br>  * RateLimit-Limit - The request limit quota for the time window closest to exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Remaining - The number of requests remaining in the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Reset - The number of seconds until the quota resets for the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Zuora-Request-Id - The Zuora internal identifier of the API call. You cannot control the value of this header.  <br>  * Zuora-Track-Id - A custom identifier for tracing the API call. If you specified a tracing identifier in the request headers, Zuora returns the same tracing identifier. Otherwise, Zuora does not set this header.  <br>  </td></tr>
         </table>
         */
        public okhttp3.Call executeAsync(final ApiCallback<ProxyCreateOrModifyResponse> _callback) throws ApiException {
            ProxyModifyProductRatePlanCharge proxyModifyProductRatePlanCharge = buildBodyParams();
            return pUTProductRatePlanChargeAsync(id, proxyModifyProductRatePlanCharge, acceptEncoding, contentEncoding, authorization, rejectUnknownFields, zuoraEntityIds, zuoraOrgIds, zuoraTrackId, xZuoraWSDLVersion, _callback);
        }
    }

    /**
     * CRUD: Update a product rate plan charge
     * Updates the information about a product rate plan charge. 
     * @param id The unique ID of the product rate plan charge to be updated. For example, 2c93808457d787030157e031fcd34e19.  (required)
     * @param proxyModifyProductRatePlanCharge  (required)
     * @return PUTProductRatePlanChargeRequestBuilder
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td>  </td><td>  * Content-Encoding - This header is returned if you specify the &#x60;Accept-Encoding: gzip&#x60; request header and the response contains over 1000 bytes of data. Note that only the following MIME types support gzipped responses:   - &#x60;application/json&#x60;   - &#x60;application/xml&#x60;   - &#x60;text/html&#x60;   - &#x60;text/csv&#x60;   - &#x60;text/plain&#x60;  <br>  * RateLimit-Limit - The request limit quota for the time window closest to exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Remaining - The number of requests remaining in the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Reset - The number of seconds until the quota resets for the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Zuora-Request-Id - The Zuora internal identifier of the API call. You cannot control the value of this header.  <br>  * Zuora-Track-Id - A custom identifier for tracing the API call. If you specified a tracing identifier in the request headers, Zuora returns the same tracing identifier. Otherwise, Zuora does not set this header.  <br>  </td></tr>
     </table>
     */
    public PUTProductRatePlanChargeRequestBuilder pUTProductRatePlanCharge(String id) throws IllegalArgumentException {
        if (id == null) throw new IllegalArgumentException("\"id\" is required but got null");
            

        return new PUTProductRatePlanChargeRequestBuilder(id);
    }
    private okhttp3.Call retrieveProductRatePlanChargeCall(String productRatePlanChargeKey, String acceptEncoding, String contentEncoding, String authorization, String zuoraTrackId, String zuoraEntityIds, Boolean showChargeDefinitions, final ApiCallback _callback) throws ApiException {
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
        String localVarPath = "/v1/product-rate-plan-charges/{product-rate-plan-charge-key}"
            .replace("{" + "product-rate-plan-charge-key" + "}", localVarApiClient.escapeString(productRatePlanChargeKey.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        if (showChargeDefinitions != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("show-charge-definitions", showChargeDefinitions));
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
    private okhttp3.Call retrieveProductRatePlanChargeValidateBeforeCall(String productRatePlanChargeKey, String acceptEncoding, String contentEncoding, String authorization, String zuoraTrackId, String zuoraEntityIds, Boolean showChargeDefinitions, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'productRatePlanChargeKey' is set
        if (productRatePlanChargeKey == null) {
            throw new ApiException("Missing the required parameter 'productRatePlanChargeKey' when calling retrieveProductRatePlanCharge(Async)");
        }

        return retrieveProductRatePlanChargeCall(productRatePlanChargeKey, acceptEncoding, contentEncoding, authorization, zuoraTrackId, zuoraEntityIds, showChargeDefinitions, _callback);

    }


    private ApiResponse<GETProductRatePlanChargeResponse> retrieveProductRatePlanChargeWithHttpInfo(String productRatePlanChargeKey, String acceptEncoding, String contentEncoding, String authorization, String zuoraTrackId, String zuoraEntityIds, Boolean showChargeDefinitions) throws ApiException {
        okhttp3.Call localVarCall = retrieveProductRatePlanChargeValidateBeforeCall(productRatePlanChargeKey, acceptEncoding, contentEncoding, authorization, zuoraTrackId, zuoraEntityIds, showChargeDefinitions, null);
        Type localVarReturnType = new TypeToken<GETProductRatePlanChargeResponse>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    private okhttp3.Call retrieveProductRatePlanChargeAsync(String productRatePlanChargeKey, String acceptEncoding, String contentEncoding, String authorization, String zuoraTrackId, String zuoraEntityIds, Boolean showChargeDefinitions, final ApiCallback<GETProductRatePlanChargeResponse> _callback) throws ApiException {

        okhttp3.Call localVarCall = retrieveProductRatePlanChargeValidateBeforeCall(productRatePlanChargeKey, acceptEncoding, contentEncoding, authorization, zuoraTrackId, zuoraEntityIds, showChargeDefinitions, _callback);
        Type localVarReturnType = new TypeToken<GETProductRatePlanChargeResponse>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    public class RetrieveProductRatePlanChargeRequestBuilder {
        private final String productRatePlanChargeKey;
        private String acceptEncoding;
        private String contentEncoding;
        private String authorization;
        private String zuoraTrackId;
        private String zuoraEntityIds;
        private Boolean showChargeDefinitions;

        private RetrieveProductRatePlanChargeRequestBuilder(String productRatePlanChargeKey) {
            this.productRatePlanChargeKey = productRatePlanChargeKey;
        }

        /**
         * Set acceptEncoding
         * @param acceptEncoding Include the &#x60;Accept-Encoding: gzip&#x60; header to compress responses as a gzipped file. It can significantly reduce the bandwidth required for a response.   If specified, Zuora automatically compresses responses that contain over 1000 bytes of data, and the response contains a &#x60;Content-Encoding&#x60; header with the compression algorithm so that your client can decompress it.  (optional)
         * @return RetrieveProductRatePlanChargeRequestBuilder
         */
        public RetrieveProductRatePlanChargeRequestBuilder acceptEncoding(String acceptEncoding) {
            this.acceptEncoding = acceptEncoding;
            return this;
        }
        
        /**
         * Set contentEncoding
         * @param contentEncoding Include the &#x60;Content-Encoding: gzip&#x60; header to compress a request. With this header specified, you should upload a gzipped file for the request payload instead of sending the JSON payload.  (optional)
         * @return RetrieveProductRatePlanChargeRequestBuilder
         */
        public RetrieveProductRatePlanChargeRequestBuilder contentEncoding(String contentEncoding) {
            this.contentEncoding = contentEncoding;
            return this;
        }
        
        /**
         * Set authorization
         * @param authorization The value is in the &#x60;Bearer {token}&#x60; format where {token} is a valid OAuth token generated by calling [Create an OAuth token](https://developer.zuora.com/api-references/api/operation/createToken).  (optional)
         * @return RetrieveProductRatePlanChargeRequestBuilder
         */
        public RetrieveProductRatePlanChargeRequestBuilder authorization(String authorization) {
            this.authorization = authorization;
            return this;
        }
        
        /**
         * Set zuoraTrackId
         * @param zuoraTrackId A custom identifier for tracing the API call. If you set a value for this header, Zuora returns the same value in the response headers. This header enables you to associate your system process identifiers with Zuora API calls, to assist with troubleshooting in the event of an issue.  The value of this field must use the US-ASCII character set and must not include any of the following characters: colon (&#x60;:&#x60;), semicolon (&#x60;;&#x60;), double quote (&#x60;\&quot;&#x60;), and quote (&#x60;&#39;&#x60;).  (optional)
         * @return RetrieveProductRatePlanChargeRequestBuilder
         */
        public RetrieveProductRatePlanChargeRequestBuilder zuoraTrackId(String zuoraTrackId) {
            this.zuoraTrackId = zuoraTrackId;
            return this;
        }
        
        /**
         * Set zuoraEntityIds
         * @param zuoraEntityIds An entity ID. If you have [Zuora Multi-entity](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Multi-entity) enabled and the OAuth token is valid for more than one entity, you must use this header to specify which entity to perform the operation in. If the OAuth token is only valid for a single entity, or you do not have Zuora Multi-entity enabled, you do not need to set this header.  (optional)
         * @return RetrieveProductRatePlanChargeRequestBuilder
         */
        public RetrieveProductRatePlanChargeRequestBuilder zuoraEntityIds(String zuoraEntityIds) {
            this.zuoraEntityIds = zuoraEntityIds;
            return this;
        }
        
        /**
         * Set showChargeDefinitions
         * @param showChargeDefinitions Specifies whether to include the product charge definitions of this charge in the response.  **Note**: This parameter is applicable only if the Attribute-based Pricing feature is enabled. The Attribute-based Pricing feature in the **Early Adopter** phase.  We are actively soliciting feedback from a small set of early adopters. If you are interested, please reach out to your CSM.  (optional)
         * @return RetrieveProductRatePlanChargeRequestBuilder
         */
        public RetrieveProductRatePlanChargeRequestBuilder showChargeDefinitions(Boolean showChargeDefinitions) {
            this.showChargeDefinitions = showChargeDefinitions;
            return this;
        }
        
        /**
         * Build call for retrieveProductRatePlanCharge
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
            return retrieveProductRatePlanChargeCall(productRatePlanChargeKey, acceptEncoding, contentEncoding, authorization, zuoraTrackId, zuoraEntityIds, showChargeDefinitions, _callback);
        }


        /**
         * Execute retrieveProductRatePlanCharge request
         * @return GETProductRatePlanChargeResponse
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td>  </td><td>  * Content-Encoding - This header is returned if you specify the &#x60;Accept-Encoding: gzip&#x60; request header and the response contains over 1000 bytes of data. Note that only the following MIME types support gzipped responses:   - &#x60;application/json&#x60;   - &#x60;application/xml&#x60;   - &#x60;text/html&#x60;   - &#x60;text/csv&#x60;   - &#x60;text/plain&#x60;  <br>  * RateLimit-Limit - The request limit quota for the time window closest to exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Remaining - The number of requests remaining in the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Reset - The number of seconds until the quota resets for the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Zuora-Request-Id - The Zuora internal identifier of the API call. You cannot control the value of this header.  <br>  * Zuora-Track-Id - A custom identifier for tracing the API call. If you specified a tracing identifier in the request headers, Zuora returns the same tracing identifier. Otherwise, Zuora does not set this header.  <br>  </td></tr>
         </table>
         */
        public GETProductRatePlanChargeResponse execute() throws ApiException {
            ApiResponse<GETProductRatePlanChargeResponse> localVarResp = retrieveProductRatePlanChargeWithHttpInfo(productRatePlanChargeKey, acceptEncoding, contentEncoding, authorization, zuoraTrackId, zuoraEntityIds, showChargeDefinitions);
            return localVarResp.getResponseBody();
        }

        /**
         * Execute retrieveProductRatePlanCharge request with HTTP info returned
         * @return ApiResponse&lt;GETProductRatePlanChargeResponse&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td>  </td><td>  * Content-Encoding - This header is returned if you specify the &#x60;Accept-Encoding: gzip&#x60; request header and the response contains over 1000 bytes of data. Note that only the following MIME types support gzipped responses:   - &#x60;application/json&#x60;   - &#x60;application/xml&#x60;   - &#x60;text/html&#x60;   - &#x60;text/csv&#x60;   - &#x60;text/plain&#x60;  <br>  * RateLimit-Limit - The request limit quota for the time window closest to exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Remaining - The number of requests remaining in the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Reset - The number of seconds until the quota resets for the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Zuora-Request-Id - The Zuora internal identifier of the API call. You cannot control the value of this header.  <br>  * Zuora-Track-Id - A custom identifier for tracing the API call. If you specified a tracing identifier in the request headers, Zuora returns the same tracing identifier. Otherwise, Zuora does not set this header.  <br>  </td></tr>
         </table>
         */
        public ApiResponse<GETProductRatePlanChargeResponse> executeWithHttpInfo() throws ApiException {
            return retrieveProductRatePlanChargeWithHttpInfo(productRatePlanChargeKey, acceptEncoding, contentEncoding, authorization, zuoraTrackId, zuoraEntityIds, showChargeDefinitions);
        }

        /**
         * Execute retrieveProductRatePlanCharge request (asynchronously)
         * @param _callback The callback to be executed when the API call finishes
         * @return The request call
         * @throws ApiException If fail to process the API call, e.g. serializing the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td>  </td><td>  * Content-Encoding - This header is returned if you specify the &#x60;Accept-Encoding: gzip&#x60; request header and the response contains over 1000 bytes of data. Note that only the following MIME types support gzipped responses:   - &#x60;application/json&#x60;   - &#x60;application/xml&#x60;   - &#x60;text/html&#x60;   - &#x60;text/csv&#x60;   - &#x60;text/plain&#x60;  <br>  * RateLimit-Limit - The request limit quota for the time window closest to exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Remaining - The number of requests remaining in the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Reset - The number of seconds until the quota resets for the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Zuora-Request-Id - The Zuora internal identifier of the API call. You cannot control the value of this header.  <br>  * Zuora-Track-Id - A custom identifier for tracing the API call. If you specified a tracing identifier in the request headers, Zuora returns the same tracing identifier. Otherwise, Zuora does not set this header.  <br>  </td></tr>
         </table>
         */
        public okhttp3.Call executeAsync(final ApiCallback<GETProductRatePlanChargeResponse> _callback) throws ApiException {
            return retrieveProductRatePlanChargeAsync(productRatePlanChargeKey, acceptEncoding, contentEncoding, authorization, zuoraTrackId, zuoraEntityIds, showChargeDefinitions, _callback);
        }
    }

    /**
     * Retrieve a product rate plan charge
     * Retrieves basic information about a product rate plan charge. 
     * @param productRatePlanChargeKey The unique number or ID of the product rate plan charge to be retrieved.  (required)
     * @return RetrieveProductRatePlanChargeRequestBuilder
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td>  </td><td>  * Content-Encoding - This header is returned if you specify the &#x60;Accept-Encoding: gzip&#x60; request header and the response contains over 1000 bytes of data. Note that only the following MIME types support gzipped responses:   - &#x60;application/json&#x60;   - &#x60;application/xml&#x60;   - &#x60;text/html&#x60;   - &#x60;text/csv&#x60;   - &#x60;text/plain&#x60;  <br>  * RateLimit-Limit - The request limit quota for the time window closest to exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Remaining - The number of requests remaining in the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Reset - The number of seconds until the quota resets for the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Zuora-Request-Id - The Zuora internal identifier of the API call. You cannot control the value of this header.  <br>  * Zuora-Track-Id - A custom identifier for tracing the API call. If you specified a tracing identifier in the request headers, Zuora returns the same tracing identifier. Otherwise, Zuora does not set this header.  <br>  </td></tr>
     </table>
     */
    public RetrieveProductRatePlanChargeRequestBuilder retrieveProductRatePlanCharge(String productRatePlanChargeKey) throws IllegalArgumentException {
        if (productRatePlanChargeKey == null) throw new IllegalArgumentException("\"productRatePlanChargeKey\" is required but got null");
            

        return new RetrieveProductRatePlanChargeRequestBuilder(productRatePlanChargeKey);
    }
}
