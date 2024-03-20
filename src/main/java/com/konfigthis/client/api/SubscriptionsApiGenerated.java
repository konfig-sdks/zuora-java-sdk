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
import com.konfigthis.client.model.GETSubscriptionTypeWithSuccess;
import com.konfigthis.client.model.GETSubscriptionWrapper;
import java.time.LocalDate;
import com.konfigthis.client.model.POSTSrpCreateType;
import com.konfigthis.client.model.POSTSubscriptionCancellationResponseType;
import com.konfigthis.client.model.POSTSubscriptionCancellationType;
import com.konfigthis.client.model.POSTSubscriptionPreviewResponseType;
import com.konfigthis.client.model.POSTSubscriptionPreviewType;
import com.konfigthis.client.model.POSTSubscriptionPreviewTypePreviewAccountInfo;
import com.konfigthis.client.model.POSTSubscriptionResponseType;
import com.konfigthis.client.model.POSTSubscriptionType;
import com.konfigthis.client.model.PUTDeleteSubscriptionResponseType;
import com.konfigthis.client.model.PUTRenewSubscriptionResponseType;
import com.konfigthis.client.model.PUTRenewSubscriptionType;
import com.konfigthis.client.model.PUTSrpAddType;
import com.konfigthis.client.model.PUTSrpChangeType;
import com.konfigthis.client.model.PUTSrpRemoveType;
import com.konfigthis.client.model.PUTSrpUpdateType;
import com.konfigthis.client.model.PUTSubscriptionPatchSpecificVersionRequestType;
import com.konfigthis.client.model.PUTSubscriptionPatchSpecificVersionRequestTypeRatePlansInner;
import com.konfigthis.client.model.PUTSubscriptionResponseType;
import com.konfigthis.client.model.PUTSubscriptionResumeResponseType;
import com.konfigthis.client.model.PUTSubscriptionResumeType;
import com.konfigthis.client.model.PUTSubscriptionSuspendResponseType;
import com.konfigthis.client.model.PUTSubscriptionSuspendType;
import com.konfigthis.client.model.PUTSubscriptionType;
import com.konfigthis.client.model.PreviewExistingSubscriptionRequest;
import com.konfigthis.client.model.PreviewExistingSubscriptionResponse;
import com.konfigthis.client.model.PreviewStartDate;
import com.konfigthis.client.model.PreviewThroughDate;
import com.konfigthis.client.model.QuantityForUsageCharges;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ws.rs.core.GenericType;

public class SubscriptionsApiGenerated {
    private ApiClient localVarApiClient;
    private int localHostIndex;
    private String localCustomBaseUrl;

    public SubscriptionsApiGenerated() throws IllegalArgumentException {
        this(Configuration.getDefaultApiClient());
    }

    public SubscriptionsApiGenerated(ApiClient apiClient) throws IllegalArgumentException {
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

    private okhttp3.Call cancelSubscriptionCall(String subscriptionKey, POSTSubscriptionCancellationType poSTSubscriptionCancellationType, String acceptEncoding, String contentEncoding, String authorization, String zuoraTrackId, String zuoraEntityIds, String zuoraOrgIds, String zuoraVersion, final ApiCallback _callback) throws ApiException {
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

        Object localVarPostBody = poSTSubscriptionCancellationType;

        // create path and map variables
        String localVarPath = "/v1/subscriptions/{subscription-key}/cancel"
            .replace("{" + "subscription-key" + "}", localVarApiClient.escapeString(subscriptionKey.toString()));

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
    private okhttp3.Call cancelSubscriptionValidateBeforeCall(String subscriptionKey, POSTSubscriptionCancellationType poSTSubscriptionCancellationType, String acceptEncoding, String contentEncoding, String authorization, String zuoraTrackId, String zuoraEntityIds, String zuoraOrgIds, String zuoraVersion, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'subscriptionKey' is set
        if (subscriptionKey == null) {
            throw new ApiException("Missing the required parameter 'subscriptionKey' when calling cancelSubscription(Async)");
        }

        // verify the required parameter 'poSTSubscriptionCancellationType' is set
        if (poSTSubscriptionCancellationType == null) {
            throw new ApiException("Missing the required parameter 'poSTSubscriptionCancellationType' when calling cancelSubscription(Async)");
        }

        return cancelSubscriptionCall(subscriptionKey, poSTSubscriptionCancellationType, acceptEncoding, contentEncoding, authorization, zuoraTrackId, zuoraEntityIds, zuoraOrgIds, zuoraVersion, _callback);

    }


    private ApiResponse<POSTSubscriptionCancellationResponseType> cancelSubscriptionWithHttpInfo(String subscriptionKey, POSTSubscriptionCancellationType poSTSubscriptionCancellationType, String acceptEncoding, String contentEncoding, String authorization, String zuoraTrackId, String zuoraEntityIds, String zuoraOrgIds, String zuoraVersion) throws ApiException {
        okhttp3.Call localVarCall = cancelSubscriptionValidateBeforeCall(subscriptionKey, poSTSubscriptionCancellationType, acceptEncoding, contentEncoding, authorization, zuoraTrackId, zuoraEntityIds, zuoraOrgIds, zuoraVersion, null);
        Type localVarReturnType = new TypeToken<POSTSubscriptionCancellationResponseType>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    private okhttp3.Call cancelSubscriptionAsync(String subscriptionKey, POSTSubscriptionCancellationType poSTSubscriptionCancellationType, String acceptEncoding, String contentEncoding, String authorization, String zuoraTrackId, String zuoraEntityIds, String zuoraOrgIds, String zuoraVersion, final ApiCallback<POSTSubscriptionCancellationResponseType> _callback) throws ApiException {

        okhttp3.Call localVarCall = cancelSubscriptionValidateBeforeCall(subscriptionKey, poSTSubscriptionCancellationType, acceptEncoding, contentEncoding, authorization, zuoraTrackId, zuoraEntityIds, zuoraOrgIds, zuoraVersion, _callback);
        Type localVarReturnType = new TypeToken<POSTSubscriptionCancellationResponseType>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    public class CancelSubscriptionRequestBuilder {
        private final String cancellationPolicy;
        private final String subscriptionKey;
        private List<String> applicationOrder;
        private Boolean applyCredit;
        private Boolean applyCreditBalance;
        private LocalDate bookingDate;
        private LocalDate cancellationEffectiveDate;
        private Boolean collect;
        private LocalDate contractEffectiveDate;
        private String creditMemoReasonCode;
        private LocalDate documentDate;
        private Boolean invoice;
        private Boolean invoiceCollect;
        private LocalDate invoiceTargetDate;
        private LocalDate orderDate;
        private Boolean runBilling;
        private LocalDate targetDate;
        private String acceptEncoding;
        private String contentEncoding;
        private String authorization;
        private String zuoraTrackId;
        private String zuoraEntityIds;
        private String zuoraOrgIds;
        private String zuoraVersion;

        private CancelSubscriptionRequestBuilder(String cancellationPolicy, String subscriptionKey) {
            this.cancellationPolicy = cancellationPolicy;
            this.subscriptionKey = subscriptionKey;
        }

        /**
         * Set applicationOrder
         * @param applicationOrder The priority order to apply credit memos and/or unapplied payments to an invoice. Possible item values are: &#x60;CreditMemo&#x60;, &#x60;UnappliedPayment&#x60;.  **Note:**   - This field is valid only if the &#x60;applyCredit&#x60; field is set to &#x60;true&#x60;.   - If no value is specified for this field, the default priority order is used, [\\\&quot;CreditMemo\\\&quot;, \\\&quot;UnappliedPayment\\\&quot;], to apply credit memos first and then apply unapplied payments.   - If only one item is specified, only the items of the spedified type are applied to invoices. For example, if the value is &#x60;[\\\&quot;CreditMemo\\\&quot;]&#x60;, only credit memos are used to apply to invoices.  (optional)
         * @return CancelSubscriptionRequestBuilder
         */
        public CancelSubscriptionRequestBuilder applicationOrder(List<String> applicationOrder) {
            this.applicationOrder = applicationOrder;
            return this;
        }
        
        /**
         * Set applyCredit
         * @param applyCredit If the value is true, the credit memo or unapplied payment on the order account will be automatically applied to the invoices generated by this order. The credit memo generated by this order will not be automatically applied to any invoices.  **Note:** This field is only available if you have [Invoice Settlement](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/Invoice_Settlement) enabled. The Invoice Settlement feature is generally available as of Zuora Billing Release 296 (March 2021). This feature includes Unapplied Payments, Credit and Debit Memo, and Invoice Item Settlement. If you want to enable Invoice Settlement, see [Invoice Settlement Enablement and Checklist Guide](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/Invoice_Settlement/Invoice_Settlement_Migration_Checklist_and_Guide) for more information.  (optional)
         * @return CancelSubscriptionRequestBuilder
         */
        public CancelSubscriptionRequestBuilder applyCredit(Boolean applyCredit) {
            this.applyCredit = applyCredit;
            return this;
        }
        
        /**
         * Set applyCreditBalance
         * @param applyCreditBalance Whether to automatically apply a credit balance to an invoice.  If the value is &#x60;true&#x60;, the credit balance is applied to the invoice. If the value is &#x60;false&#x60;, no action is taken.   To view the credit balance adjustment, retrieve the details of the invoice using the Get Invoices method.  Prerequisite: &#x60;invoice&#x60; must be &#x60;true&#x60;.   **Note:**    - If you are using the field &#x60;invoiceCollect&#x60; rather than the field &#x60;invoice&#x60;, the &#x60;invoiceCollect&#x60; value must be &#x60;true&#x60;.   - This field is deprecated if you have the Invoice Settlement feature enabled.  (optional)
         * @return CancelSubscriptionRequestBuilder
         */
        public CancelSubscriptionRequestBuilder applyCreditBalance(Boolean applyCreditBalance) {
            this.applyCreditBalance = applyCreditBalance;
            return this;
        }
        
        /**
         * Set bookingDate
         * @param bookingDate The booking date that you want to set for the amendment contract when you cancel the subscription. The default value is the current date when you make the API call.  (optional)
         * @return CancelSubscriptionRequestBuilder
         */
        public CancelSubscriptionRequestBuilder bookingDate(LocalDate bookingDate) {
            this.bookingDate = bookingDate;
            return this;
        }
        
        /**
         * Set cancellationEffectiveDate
         * @param cancellationEffectiveDate Date the cancellation takes effect, in the format yyyy-mm-dd.  Use only if &#x60;cancellationPolicy&#x60; is &#x60;SpecificDate&#x60;. Should not be earlier than the subscription contract-effective date, later than the subscription term-end date, or within a period for which the customer has been invoiced.  (optional)
         * @return CancelSubscriptionRequestBuilder
         */
        public CancelSubscriptionRequestBuilder cancellationEffectiveDate(LocalDate cancellationEffectiveDate) {
            this.cancellationEffectiveDate = cancellationEffectiveDate;
            return this;
        }
        
        /**
         * Set collect
         * @param collect Collects an automatic payment for a subscription. The collection generated in this operation is only for this subscription, not for the entire customer account.  If the value is &#x60;true&#x60;, the automatic payment is collected. If the value is &#x60;false&#x60;, no action is taken.  Prerequisite: The &#x60;invoice&#x60; or &#x60;runBilling&#x60; field must be &#x60;true&#x60;.   **Note**: This field is only available if you set the &#x60;zuora-version&#x60; request header to &#x60;196.0&#x60; or later [available versions](https://developer.zuora.com/api-references/api/overview/#section/API-Versions/Minor-Version).  (optional, default to false)
         * @return CancelSubscriptionRequestBuilder
         */
        public CancelSubscriptionRequestBuilder collect(Boolean collect) {
            this.collect = collect;
            return this;
        }
        
        /**
         * Set contractEffectiveDate
         * @param contractEffectiveDate The date when the customer notifies you that they want to cancel their subscription.  (optional)
         * @return CancelSubscriptionRequestBuilder
         */
        public CancelSubscriptionRequestBuilder contractEffectiveDate(LocalDate contractEffectiveDate) {
            this.contractEffectiveDate = contractEffectiveDate;
            return this;
        }
        
        /**
         * Set creditMemoReasonCode
         * @param creditMemoReasonCode A code identifying the reason for the credit memo transaction that is generated by the request. The value must be an existing reason code. If you do not pass the field or pass the field with empty value, Zuora uses the default reason code. (optional)
         * @return CancelSubscriptionRequestBuilder
         */
        public CancelSubscriptionRequestBuilder creditMemoReasonCode(String creditMemoReasonCode) {
            this.creditMemoReasonCode = creditMemoReasonCode;
            return this;
        }
        
        /**
         * Set documentDate
         * @param documentDate The date of the billing document, in &#x60;yyyy-mm-dd&#x60; format. It represents the invoice date for invoices, credit memo date for credit memos, and debit memo date for debit memos.  - If this field is specified, the specified date is used as the billing document date.  - If this field is not specified, the date specified in the &#x60;targetDate&#x60; is used as the billing document date.  (optional)
         * @return CancelSubscriptionRequestBuilder
         */
        public CancelSubscriptionRequestBuilder documentDate(LocalDate documentDate) {
            this.documentDate = documentDate;
            return this;
        }
        
        /**
         * Set invoice
         * @param invoice **Note:** This field has been replaced by the &#x60;runBilling&#x60; field. The &#x60;invoice&#x60; field is only available for backward compatibility.   Creates an invoice for a subscription. The invoice generated in this operation is only for this subscription, not for the entire customer account.   If the value is &#x60;true&#x60;, an invoice is created. If the value is &#x60;false&#x60;, no action is taken. The default value is &#x60;false&#x60;.    This field is in Zuora REST API version control. Supported minor versions are &#x60;196.0&#x60; and &#x60;207.0&#x60;. To use this field in the method, you must set the zuora-version parameter to the minor version number in the request header.  (optional)
         * @return CancelSubscriptionRequestBuilder
         */
        public CancelSubscriptionRequestBuilder invoice(Boolean invoice) {
            this.invoice = invoice;
            return this;
        }
        
        /**
         * Set invoiceCollect
         * @param invoiceCollect This field has been replaced by the &#x60;invoice&#x60; field and the &#x60;collect&#x60; field. &#x60;invoiceCollect&#x60; is available only for backward compatibility.  If this field is set to &#x60;true&#x60;, an invoice is generated and payment automatically collected.  **Note**: This field is only available if you set the &#x60;zuora-version&#x60; request header to &#x60;186.0&#x60;, &#x60;187.0&#x60;, &#x60;188.0&#x60;, or &#x60;189.0&#x60;.  (optional, default to false)
         * @return CancelSubscriptionRequestBuilder
         */
        public CancelSubscriptionRequestBuilder invoiceCollect(Boolean invoiceCollect) {
            this.invoiceCollect = invoiceCollect;
            return this;
        }
        
        /**
         * Set invoiceTargetDate
         * @param invoiceTargetDate **Note:** This field has been replaced by the &#x60;targetDate&#x60; field. The &#x60;invoiceTargetDate&#x60; field is only available for backward compatibility.   Date through which to calculate charges if an invoice is generated, as yyyy-mm-dd. Default is current date.   This field is in Zuora REST API version control. Supported minor versions are &#x60;207.0&#x60; and earlier [available versions](https://developer.zuora.com/api-references/api/overview/#section/API-Versions/Minor-Version).  (optional)
         * @return CancelSubscriptionRequestBuilder
         */
        public CancelSubscriptionRequestBuilder invoiceTargetDate(LocalDate invoiceTargetDate) {
            this.invoiceTargetDate = invoiceTargetDate;
            return this;
        }
        
        /**
         * Set orderDate
         * @param orderDate The date when the order is signed. If no additinal contractEffectiveDate is provided, this order will use this order date as the contract effective date. This field must be in the &#x60;yyyy-mm-dd&#x60; format. This field is required for Orders customers only, not applicable to Orders Harmonization customers.   (optional)
         * @return CancelSubscriptionRequestBuilder
         */
        public CancelSubscriptionRequestBuilder orderDate(LocalDate orderDate) {
            this.orderDate = orderDate;
            return this;
        }
        
        /**
         * Set runBilling
         * @param runBilling Creates an invoice for a subscription. If you have the Invoice Settlement feature enabled, a credit memo might also be created based on the [invoice and credit memo generation rule](https://knowledgecenter.zuora.com/CB_Billing/Invoice_Settlement/Credit_and_Debit_Memos/Rules_for_Generating_Invoices_and_Credit_Memos).     The billing documents generated in this operation is only for this subscription, not for the entire customer account.   Possible values:  - &#x60;true&#x60;: An invoice is created. If you have the Invoice Settlement feature enabled, a credit memo might also be created.   - &#x60;false&#x60;: No invoice is created.   **Note:** This field is in Zuora REST API version control. Supported minor versions are &#x60;211.0&#x60; or later [available versions](https://developer.zuora.com/api-references/api/overview/#section/API-Versions/Minor-Version). To use this field in the method, you must set the &#x60;zuora-version&#x60; parameter to the minor version number in the request header.  (optional, default to false)
         * @return CancelSubscriptionRequestBuilder
         */
        public CancelSubscriptionRequestBuilder runBilling(Boolean runBilling) {
            this.runBilling = runBilling;
            return this;
        }
        
        /**
         * Set targetDate
         * @param targetDate Date through which to calculate charges if an invoice or a credit memo is generated, as yyyy-mm-dd. Default is current date.   **Note:** The credit memo is only available if you have the Invoice Settlement feature enabled.   This field is in Zuora REST API version control. Supported minor versions are &#x60;211.0&#x60; and later. To use this field in the method, you must set the  &#x60;zuora-version&#x60; parameter to the minor version number in the request header.  (optional)
         * @return CancelSubscriptionRequestBuilder
         */
        public CancelSubscriptionRequestBuilder targetDate(LocalDate targetDate) {
            this.targetDate = targetDate;
            return this;
        }
        
        /**
         * Set acceptEncoding
         * @param acceptEncoding Include the &#x60;Accept-Encoding: gzip&#x60; header to compress responses as a gzipped file. It can significantly reduce the bandwidth required for a response.   If specified, Zuora automatically compresses responses that contain over 1000 bytes of data, and the response contains a &#x60;Content-Encoding&#x60; header with the compression algorithm so that your client can decompress it.  (optional)
         * @return CancelSubscriptionRequestBuilder
         */
        public CancelSubscriptionRequestBuilder acceptEncoding(String acceptEncoding) {
            this.acceptEncoding = acceptEncoding;
            return this;
        }
        
        /**
         * Set contentEncoding
         * @param contentEncoding Include the &#x60;Content-Encoding: gzip&#x60; header to compress a request. With this header specified, you should upload a gzipped file for the request payload instead of sending the JSON payload.  (optional)
         * @return CancelSubscriptionRequestBuilder
         */
        public CancelSubscriptionRequestBuilder contentEncoding(String contentEncoding) {
            this.contentEncoding = contentEncoding;
            return this;
        }
        
        /**
         * Set authorization
         * @param authorization The value is in the &#x60;Bearer {token}&#x60; format where {token} is a valid OAuth token generated by calling [Create an OAuth token](https://developer.zuora.com/api-references/api/operation/createToken).  (optional)
         * @return CancelSubscriptionRequestBuilder
         */
        public CancelSubscriptionRequestBuilder authorization(String authorization) {
            this.authorization = authorization;
            return this;
        }
        
        /**
         * Set zuoraTrackId
         * @param zuoraTrackId A custom identifier for tracing the API call. If you set a value for this header, Zuora returns the same value in the response headers. This header enables you to associate your system process identifiers with Zuora API calls, to assist with troubleshooting in the event of an issue.  The value of this field must use the US-ASCII character set and must not include any of the following characters: colon (&#x60;:&#x60;), semicolon (&#x60;;&#x60;), double quote (&#x60;\&quot;&#x60;), and quote (&#x60;&#39;&#x60;).  (optional)
         * @return CancelSubscriptionRequestBuilder
         */
        public CancelSubscriptionRequestBuilder zuoraTrackId(String zuoraTrackId) {
            this.zuoraTrackId = zuoraTrackId;
            return this;
        }
        
        /**
         * Set zuoraEntityIds
         * @param zuoraEntityIds An entity ID. If you have [Zuora Multi-entity](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Multi-entity) enabled and the OAuth token is valid for more than one entity, you must use this header to specify which entity to perform the operation in. If the OAuth token is only valid for a single entity, or you do not have Zuora Multi-entity enabled, you do not need to set this header.  (optional)
         * @return CancelSubscriptionRequestBuilder
         */
        public CancelSubscriptionRequestBuilder zuoraEntityIds(String zuoraEntityIds) {
            this.zuoraEntityIds = zuoraEntityIds;
            return this;
        }
        
        /**
         * Set zuoraOrgIds
         * @param zuoraOrgIds Comma separated IDs. If you have &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Central_Platform/Multi-Org\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Zuora Multi-Org&lt;/a&gt; enabled,  you can use this header to specify which orgs to perform the operation in. If you do not have Zuora Multi-Org enabled, you should not set this header.  The IDs must be a sub-set of the user&#39;s accessible orgs. If you specify an org that the user does not have access to, the operation fails.  If the header is not set, the operation is performed in scope of the user&#39;s accessible orgs.  (optional)
         * @return CancelSubscriptionRequestBuilder
         */
        public CancelSubscriptionRequestBuilder zuoraOrgIds(String zuoraOrgIds) {
            this.zuoraOrgIds = zuoraOrgIds;
            return this;
        }
        
        /**
         * Set zuoraVersion
         * @param zuoraVersion The minor version of the Zuora REST API.   You only need to set this parameter if you use the following fields: * invoice * collect * runBilling * targetDate   (optional)
         * @return CancelSubscriptionRequestBuilder
         */
        public CancelSubscriptionRequestBuilder zuoraVersion(String zuoraVersion) {
            this.zuoraVersion = zuoraVersion;
            return this;
        }
        
        /**
         * Build call for cancelSubscription
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
            POSTSubscriptionCancellationType poSTSubscriptionCancellationType = buildBodyParams();
            return cancelSubscriptionCall(subscriptionKey, poSTSubscriptionCancellationType, acceptEncoding, contentEncoding, authorization, zuoraTrackId, zuoraEntityIds, zuoraOrgIds, zuoraVersion, _callback);
        }

        private POSTSubscriptionCancellationType buildBodyParams() {
            POSTSubscriptionCancellationType poSTSubscriptionCancellationType = new POSTSubscriptionCancellationType();
            poSTSubscriptionCancellationType.applicationOrder(this.applicationOrder);
            poSTSubscriptionCancellationType.applyCredit(this.applyCredit);
            poSTSubscriptionCancellationType.applyCreditBalance(this.applyCreditBalance);
            poSTSubscriptionCancellationType.bookingDate(this.bookingDate);
            poSTSubscriptionCancellationType.cancellationEffectiveDate(this.cancellationEffectiveDate);
            poSTSubscriptionCancellationType.cancellationPolicy(this.cancellationPolicy);
            poSTSubscriptionCancellationType.collect(this.collect);
            poSTSubscriptionCancellationType.contractEffectiveDate(this.contractEffectiveDate);
            poSTSubscriptionCancellationType.creditMemoReasonCode(this.creditMemoReasonCode);
            poSTSubscriptionCancellationType.documentDate(this.documentDate);
            poSTSubscriptionCancellationType.invoice(this.invoice);
            poSTSubscriptionCancellationType.invoiceCollect(this.invoiceCollect);
            poSTSubscriptionCancellationType.invoiceTargetDate(this.invoiceTargetDate);
            poSTSubscriptionCancellationType.orderDate(this.orderDate);
            if (this.runBilling != null)
            poSTSubscriptionCancellationType.runBilling(POSTSubscriptionCancellationType.RunBillingEnum.fromValue(this.runBilling));
            poSTSubscriptionCancellationType.targetDate(this.targetDate);
            return poSTSubscriptionCancellationType;
        }

        /**
         * Execute cancelSubscription request
         * @return POSTSubscriptionCancellationResponseType
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td>  </td><td>  * Content-Encoding - This header is returned if you specify the &#x60;Accept-Encoding: gzip&#x60; request header and the response contains over 1000 bytes of data. Note that only the following MIME types support gzipped responses:   - &#x60;application/json&#x60;   - &#x60;application/xml&#x60;   - &#x60;text/html&#x60;   - &#x60;text/csv&#x60;   - &#x60;text/plain&#x60;  <br>  * RateLimit-Limit - The request limit quota for the time window closest to exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Remaining - The number of requests remaining in the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Reset - The number of seconds until the quota resets for the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Zuora-Request-Id - The Zuora internal identifier of the API call. You cannot control the value of this header.  <br>  * Zuora-Track-Id - A custom identifier for tracing the API call. If you specified a tracing identifier in the request headers, Zuora returns the same tracing identifier. Otherwise, Zuora does not set this header.  <br>  </td></tr>
         </table>
         */
        public POSTSubscriptionCancellationResponseType execute() throws ApiException {
            POSTSubscriptionCancellationType poSTSubscriptionCancellationType = buildBodyParams();
            ApiResponse<POSTSubscriptionCancellationResponseType> localVarResp = cancelSubscriptionWithHttpInfo(subscriptionKey, poSTSubscriptionCancellationType, acceptEncoding, contentEncoding, authorization, zuoraTrackId, zuoraEntityIds, zuoraOrgIds, zuoraVersion);
            return localVarResp.getResponseBody();
        }

        /**
         * Execute cancelSubscription request with HTTP info returned
         * @return ApiResponse&lt;POSTSubscriptionCancellationResponseType&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td>  </td><td>  * Content-Encoding - This header is returned if you specify the &#x60;Accept-Encoding: gzip&#x60; request header and the response contains over 1000 bytes of data. Note that only the following MIME types support gzipped responses:   - &#x60;application/json&#x60;   - &#x60;application/xml&#x60;   - &#x60;text/html&#x60;   - &#x60;text/csv&#x60;   - &#x60;text/plain&#x60;  <br>  * RateLimit-Limit - The request limit quota for the time window closest to exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Remaining - The number of requests remaining in the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Reset - The number of seconds until the quota resets for the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Zuora-Request-Id - The Zuora internal identifier of the API call. You cannot control the value of this header.  <br>  * Zuora-Track-Id - A custom identifier for tracing the API call. If you specified a tracing identifier in the request headers, Zuora returns the same tracing identifier. Otherwise, Zuora does not set this header.  <br>  </td></tr>
         </table>
         */
        public ApiResponse<POSTSubscriptionCancellationResponseType> executeWithHttpInfo() throws ApiException {
            POSTSubscriptionCancellationType poSTSubscriptionCancellationType = buildBodyParams();
            return cancelSubscriptionWithHttpInfo(subscriptionKey, poSTSubscriptionCancellationType, acceptEncoding, contentEncoding, authorization, zuoraTrackId, zuoraEntityIds, zuoraOrgIds, zuoraVersion);
        }

        /**
         * Execute cancelSubscription request (asynchronously)
         * @param _callback The callback to be executed when the API call finishes
         * @return The request call
         * @throws ApiException If fail to process the API call, e.g. serializing the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td>  </td><td>  * Content-Encoding - This header is returned if you specify the &#x60;Accept-Encoding: gzip&#x60; request header and the response contains over 1000 bytes of data. Note that only the following MIME types support gzipped responses:   - &#x60;application/json&#x60;   - &#x60;application/xml&#x60;   - &#x60;text/html&#x60;   - &#x60;text/csv&#x60;   - &#x60;text/plain&#x60;  <br>  * RateLimit-Limit - The request limit quota for the time window closest to exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Remaining - The number of requests remaining in the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Reset - The number of seconds until the quota resets for the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Zuora-Request-Id - The Zuora internal identifier of the API call. You cannot control the value of this header.  <br>  * Zuora-Track-Id - A custom identifier for tracing the API call. If you specified a tracing identifier in the request headers, Zuora returns the same tracing identifier. Otherwise, Zuora does not set this header.  <br>  </td></tr>
         </table>
         */
        public okhttp3.Call executeAsync(final ApiCallback<POSTSubscriptionCancellationResponseType> _callback) throws ApiException {
            POSTSubscriptionCancellationType poSTSubscriptionCancellationType = buildBodyParams();
            return cancelSubscriptionAsync(subscriptionKey, poSTSubscriptionCancellationType, acceptEncoding, contentEncoding, authorization, zuoraTrackId, zuoraEntityIds, zuoraOrgIds, zuoraVersion, _callback);
        }
    }

    /**
     * Cancel a subscription
     * This REST API reference describes how to cancel an active subscription.  **Note**: If you have the Invoice Settlement feature enabled, it is best practice to set the &#x60;zuora-version&#x60; parameter to &#x60;211.0&#x60; or later [available versions](https://developer.zuora.com/api-references/api/overview/#section/API-Versions/Minor-Version). Otherwise, an error occurs. 
     * @param subscriptionKey Subscription number or ID. Subscription status must be &#x60;Active&#x60;. (required)
     * @param poSTSubscriptionCancellationType  (required)
     * @return CancelSubscriptionRequestBuilder
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td>  </td><td>  * Content-Encoding - This header is returned if you specify the &#x60;Accept-Encoding: gzip&#x60; request header and the response contains over 1000 bytes of data. Note that only the following MIME types support gzipped responses:   - &#x60;application/json&#x60;   - &#x60;application/xml&#x60;   - &#x60;text/html&#x60;   - &#x60;text/csv&#x60;   - &#x60;text/plain&#x60;  <br>  * RateLimit-Limit - The request limit quota for the time window closest to exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Remaining - The number of requests remaining in the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Reset - The number of seconds until the quota resets for the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Zuora-Request-Id - The Zuora internal identifier of the API call. You cannot control the value of this header.  <br>  * Zuora-Track-Id - A custom identifier for tracing the API call. If you specified a tracing identifier in the request headers, Zuora returns the same tracing identifier. Otherwise, Zuora does not set this header.  <br>  </td></tr>
     </table>
     */
    public CancelSubscriptionRequestBuilder cancelSubscription(String cancellationPolicy, String subscriptionKey) throws IllegalArgumentException {
        if (cancellationPolicy == null) throw new IllegalArgumentException("\"cancellationPolicy\" is required but got null");
            

        if (subscriptionKey == null) throw new IllegalArgumentException("\"subscriptionKey\" is required but got null");
            

        return new CancelSubscriptionRequestBuilder(cancellationPolicy, subscriptionKey);
    }
    private okhttp3.Call deleteSubscriptionCall(String subscriptionKey, String acceptEncoding, String contentEncoding, String authorization, String zuoraTrackId, String zuoraEntityIds, String zuoraOrgIds, final ApiCallback _callback) throws ApiException {
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
        String localVarPath = "/v1/subscriptions/{subscription-key}/delete"
            .replace("{" + "subscription-key" + "}", localVarApiClient.escapeString(subscriptionKey.toString()));

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
        return localVarApiClient.buildCall(basePath, localVarPath, "PUT", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call deleteSubscriptionValidateBeforeCall(String subscriptionKey, String acceptEncoding, String contentEncoding, String authorization, String zuoraTrackId, String zuoraEntityIds, String zuoraOrgIds, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'subscriptionKey' is set
        if (subscriptionKey == null) {
            throw new ApiException("Missing the required parameter 'subscriptionKey' when calling deleteSubscription(Async)");
        }

        return deleteSubscriptionCall(subscriptionKey, acceptEncoding, contentEncoding, authorization, zuoraTrackId, zuoraEntityIds, zuoraOrgIds, _callback);

    }


    private ApiResponse<PUTDeleteSubscriptionResponseType> deleteSubscriptionWithHttpInfo(String subscriptionKey, String acceptEncoding, String contentEncoding, String authorization, String zuoraTrackId, String zuoraEntityIds, String zuoraOrgIds) throws ApiException {
        okhttp3.Call localVarCall = deleteSubscriptionValidateBeforeCall(subscriptionKey, acceptEncoding, contentEncoding, authorization, zuoraTrackId, zuoraEntityIds, zuoraOrgIds, null);
        Type localVarReturnType = new TypeToken<PUTDeleteSubscriptionResponseType>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    private okhttp3.Call deleteSubscriptionAsync(String subscriptionKey, String acceptEncoding, String contentEncoding, String authorization, String zuoraTrackId, String zuoraEntityIds, String zuoraOrgIds, final ApiCallback<PUTDeleteSubscriptionResponseType> _callback) throws ApiException {

        okhttp3.Call localVarCall = deleteSubscriptionValidateBeforeCall(subscriptionKey, acceptEncoding, contentEncoding, authorization, zuoraTrackId, zuoraEntityIds, zuoraOrgIds, _callback);
        Type localVarReturnType = new TypeToken<PUTDeleteSubscriptionResponseType>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    public class DeleteSubscriptionRequestBuilder {
        private final String subscriptionKey;
        private String acceptEncoding;
        private String contentEncoding;
        private String authorization;
        private String zuoraTrackId;
        private String zuoraEntityIds;
        private String zuoraOrgIds;

        private DeleteSubscriptionRequestBuilder(String subscriptionKey) {
            this.subscriptionKey = subscriptionKey;
        }

        /**
         * Set acceptEncoding
         * @param acceptEncoding Include the &#x60;Accept-Encoding: gzip&#x60; header to compress responses as a gzipped file. It can significantly reduce the bandwidth required for a response.   If specified, Zuora automatically compresses responses that contain over 1000 bytes of data, and the response contains a &#x60;Content-Encoding&#x60; header with the compression algorithm so that your client can decompress it.  (optional)
         * @return DeleteSubscriptionRequestBuilder
         */
        public DeleteSubscriptionRequestBuilder acceptEncoding(String acceptEncoding) {
            this.acceptEncoding = acceptEncoding;
            return this;
        }
        
        /**
         * Set contentEncoding
         * @param contentEncoding Include the &#x60;Content-Encoding: gzip&#x60; header to compress a request. With this header specified, you should upload a gzipped file for the request payload instead of sending the JSON payload.  (optional)
         * @return DeleteSubscriptionRequestBuilder
         */
        public DeleteSubscriptionRequestBuilder contentEncoding(String contentEncoding) {
            this.contentEncoding = contentEncoding;
            return this;
        }
        
        /**
         * Set authorization
         * @param authorization The value is in the &#x60;Bearer {token}&#x60; format where {token} is a valid OAuth token generated by calling [Create an OAuth token](https://developer.zuora.com/api-references/api/operation/createToken).  (optional)
         * @return DeleteSubscriptionRequestBuilder
         */
        public DeleteSubscriptionRequestBuilder authorization(String authorization) {
            this.authorization = authorization;
            return this;
        }
        
        /**
         * Set zuoraTrackId
         * @param zuoraTrackId A custom identifier for tracing the API call. If you set a value for this header, Zuora returns the same value in the response headers. This header enables you to associate your system process identifiers with Zuora API calls, to assist with troubleshooting in the event of an issue.  The value of this field must use the US-ASCII character set and must not include any of the following characters: colon (&#x60;:&#x60;), semicolon (&#x60;;&#x60;), double quote (&#x60;\&quot;&#x60;), and quote (&#x60;&#39;&#x60;).  (optional)
         * @return DeleteSubscriptionRequestBuilder
         */
        public DeleteSubscriptionRequestBuilder zuoraTrackId(String zuoraTrackId) {
            this.zuoraTrackId = zuoraTrackId;
            return this;
        }
        
        /**
         * Set zuoraEntityIds
         * @param zuoraEntityIds An entity ID. If you have [Zuora Multi-entity](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Multi-entity) enabled and the OAuth token is valid for more than one entity, you must use this header to specify which entity to perform the operation in. If the OAuth token is only valid for a single entity, or you do not have Zuora Multi-entity enabled, you do not need to set this header.  (optional)
         * @return DeleteSubscriptionRequestBuilder
         */
        public DeleteSubscriptionRequestBuilder zuoraEntityIds(String zuoraEntityIds) {
            this.zuoraEntityIds = zuoraEntityIds;
            return this;
        }
        
        /**
         * Set zuoraOrgIds
         * @param zuoraOrgIds Comma separated IDs. If you have &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Central_Platform/Multi-Org\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Zuora Multi-Org&lt;/a&gt; enabled,  you can use this header to specify which orgs to perform the operation in. If you do not have Zuora Multi-Org enabled, you should not set this header.  The IDs must be a sub-set of the user&#39;s accessible orgs. If you specify an org that the user does not have access to, the operation fails.  If the header is not set, the operation is performed in scope of the user&#39;s accessible orgs.  (optional)
         * @return DeleteSubscriptionRequestBuilder
         */
        public DeleteSubscriptionRequestBuilder zuoraOrgIds(String zuoraOrgIds) {
            this.zuoraOrgIds = zuoraOrgIds;
            return this;
        }
        
        /**
         * Build call for deleteSubscription
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
            return deleteSubscriptionCall(subscriptionKey, acceptEncoding, contentEncoding, authorization, zuoraTrackId, zuoraEntityIds, zuoraOrgIds, _callback);
        }


        /**
         * Execute deleteSubscription request
         * @return PUTDeleteSubscriptionResponseType
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td>  </td><td>  * Content-Encoding - This header is returned if you specify the &#x60;Accept-Encoding: gzip&#x60; request header and the response contains over 1000 bytes of data. Note that only the following MIME types support gzipped responses:   - &#x60;application/json&#x60;   - &#x60;application/xml&#x60;   - &#x60;text/html&#x60;   - &#x60;text/csv&#x60;   - &#x60;text/plain&#x60;  <br>  * RateLimit-Limit - The request limit quota for the time window closest to exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Remaining - The number of requests remaining in the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Reset - The number of seconds until the quota resets for the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Zuora-Request-Id - The Zuora internal identifier of the API call. You cannot control the value of this header.  <br>  * Zuora-Track-Id - A custom identifier for tracing the API call. If you specified a tracing identifier in the request headers, Zuora returns the same tracing identifier. Otherwise, Zuora does not set this header.  <br>  </td></tr>
         </table>
         */
        public PUTDeleteSubscriptionResponseType execute() throws ApiException {
            ApiResponse<PUTDeleteSubscriptionResponseType> localVarResp = deleteSubscriptionWithHttpInfo(subscriptionKey, acceptEncoding, contentEncoding, authorization, zuoraTrackId, zuoraEntityIds, zuoraOrgIds);
            return localVarResp.getResponseBody();
        }

        /**
         * Execute deleteSubscription request with HTTP info returned
         * @return ApiResponse&lt;PUTDeleteSubscriptionResponseType&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td>  </td><td>  * Content-Encoding - This header is returned if you specify the &#x60;Accept-Encoding: gzip&#x60; request header and the response contains over 1000 bytes of data. Note that only the following MIME types support gzipped responses:   - &#x60;application/json&#x60;   - &#x60;application/xml&#x60;   - &#x60;text/html&#x60;   - &#x60;text/csv&#x60;   - &#x60;text/plain&#x60;  <br>  * RateLimit-Limit - The request limit quota for the time window closest to exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Remaining - The number of requests remaining in the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Reset - The number of seconds until the quota resets for the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Zuora-Request-Id - The Zuora internal identifier of the API call. You cannot control the value of this header.  <br>  * Zuora-Track-Id - A custom identifier for tracing the API call. If you specified a tracing identifier in the request headers, Zuora returns the same tracing identifier. Otherwise, Zuora does not set this header.  <br>  </td></tr>
         </table>
         */
        public ApiResponse<PUTDeleteSubscriptionResponseType> executeWithHttpInfo() throws ApiException {
            return deleteSubscriptionWithHttpInfo(subscriptionKey, acceptEncoding, contentEncoding, authorization, zuoraTrackId, zuoraEntityIds, zuoraOrgIds);
        }

        /**
         * Execute deleteSubscription request (asynchronously)
         * @param _callback The callback to be executed when the API call finishes
         * @return The request call
         * @throws ApiException If fail to process the API call, e.g. serializing the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td>  </td><td>  * Content-Encoding - This header is returned if you specify the &#x60;Accept-Encoding: gzip&#x60; request header and the response contains over 1000 bytes of data. Note that only the following MIME types support gzipped responses:   - &#x60;application/json&#x60;   - &#x60;application/xml&#x60;   - &#x60;text/html&#x60;   - &#x60;text/csv&#x60;   - &#x60;text/plain&#x60;  <br>  * RateLimit-Limit - The request limit quota for the time window closest to exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Remaining - The number of requests remaining in the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Reset - The number of seconds until the quota resets for the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Zuora-Request-Id - The Zuora internal identifier of the API call. You cannot control the value of this header.  <br>  * Zuora-Track-Id - A custom identifier for tracing the API call. If you specified a tracing identifier in the request headers, Zuora returns the same tracing identifier. Otherwise, Zuora does not set this header.  <br>  </td></tr>
         </table>
         */
        public okhttp3.Call executeAsync(final ApiCallback<PUTDeleteSubscriptionResponseType> _callback) throws ApiException {
            return deleteSubscriptionAsync(subscriptionKey, acceptEncoding, contentEncoding, authorization, zuoraTrackId, zuoraEntityIds, zuoraOrgIds, _callback);
        }
    }

    /**
     * Delete a subscription by number
     * This REST API reference describes how to delete a subscription of the specified subscription number. 
     * @param subscriptionKey Subscription number (required)
     * @return DeleteSubscriptionRequestBuilder
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td>  </td><td>  * Content-Encoding - This header is returned if you specify the &#x60;Accept-Encoding: gzip&#x60; request header and the response contains over 1000 bytes of data. Note that only the following MIME types support gzipped responses:   - &#x60;application/json&#x60;   - &#x60;application/xml&#x60;   - &#x60;text/html&#x60;   - &#x60;text/csv&#x60;   - &#x60;text/plain&#x60;  <br>  * RateLimit-Limit - The request limit quota for the time window closest to exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Remaining - The number of requests remaining in the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Reset - The number of seconds until the quota resets for the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Zuora-Request-Id - The Zuora internal identifier of the API call. You cannot control the value of this header.  <br>  * Zuora-Track-Id - A custom identifier for tracing the API call. If you specified a tracing identifier in the request headers, Zuora returns the same tracing identifier. Otherwise, Zuora does not set this header.  <br>  </td></tr>
     </table>
     */
    public DeleteSubscriptionRequestBuilder deleteSubscription(String subscriptionKey) throws IllegalArgumentException {
        if (subscriptionKey == null) throw new IllegalArgumentException("\"subscriptionKey\" is required but got null");
            

        return new DeleteSubscriptionRequestBuilder(subscriptionKey);
    }
    private okhttp3.Call previewSubscriptionCall(POSTSubscriptionPreviewType poSTSubscriptionPreviewType, String idempotencyKey, String acceptEncoding, String contentEncoding, String authorization, String zuoraTrackId, String zuoraEntityIds, String zuoraOrgIds, String zuoraVersion, final ApiCallback _callback) throws ApiException {
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

        Object localVarPostBody = poSTSubscriptionPreviewType;

        // create path and map variables
        String localVarPath = "/v1/subscriptions/preview";

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
    private okhttp3.Call previewSubscriptionValidateBeforeCall(POSTSubscriptionPreviewType poSTSubscriptionPreviewType, String idempotencyKey, String acceptEncoding, String contentEncoding, String authorization, String zuoraTrackId, String zuoraEntityIds, String zuoraOrgIds, String zuoraVersion, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'poSTSubscriptionPreviewType' is set
        if (poSTSubscriptionPreviewType == null) {
            throw new ApiException("Missing the required parameter 'poSTSubscriptionPreviewType' when calling previewSubscription(Async)");
        }

        return previewSubscriptionCall(poSTSubscriptionPreviewType, idempotencyKey, acceptEncoding, contentEncoding, authorization, zuoraTrackId, zuoraEntityIds, zuoraOrgIds, zuoraVersion, _callback);

    }


    private ApiResponse<POSTSubscriptionPreviewResponseType> previewSubscriptionWithHttpInfo(POSTSubscriptionPreviewType poSTSubscriptionPreviewType, String idempotencyKey, String acceptEncoding, String contentEncoding, String authorization, String zuoraTrackId, String zuoraEntityIds, String zuoraOrgIds, String zuoraVersion) throws ApiException {
        okhttp3.Call localVarCall = previewSubscriptionValidateBeforeCall(poSTSubscriptionPreviewType, idempotencyKey, acceptEncoding, contentEncoding, authorization, zuoraTrackId, zuoraEntityIds, zuoraOrgIds, zuoraVersion, null);
        Type localVarReturnType = new TypeToken<POSTSubscriptionPreviewResponseType>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    private okhttp3.Call previewSubscriptionAsync(POSTSubscriptionPreviewType poSTSubscriptionPreviewType, String idempotencyKey, String acceptEncoding, String contentEncoding, String authorization, String zuoraTrackId, String zuoraEntityIds, String zuoraOrgIds, String zuoraVersion, final ApiCallback<POSTSubscriptionPreviewResponseType> _callback) throws ApiException {

        okhttp3.Call localVarCall = previewSubscriptionValidateBeforeCall(poSTSubscriptionPreviewType, idempotencyKey, acceptEncoding, contentEncoding, authorization, zuoraTrackId, zuoraEntityIds, zuoraOrgIds, zuoraVersion, _callback);
        Type localVarReturnType = new TypeToken<POSTSubscriptionPreviewResponseType>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    public class PreviewSubscriptionRequestBuilder {
        private String accountKey;
        private LocalDate contractEffectiveDate;
        private LocalDate customerAcceptanceDate;
        private LocalDate documentDate;
        private Boolean includeExistingDraftDocItems;
        private Boolean includeExistingDraftInvoiceItems;
        private Long initialTerm;
        private String initialTermPeriodType;
        private String invoiceOwnerAccountKey;
        private LocalDate invoiceTargetDate;
        private String notes;
        private POSTSubscriptionPreviewTypePreviewAccountInfo previewAccountInfo;
        private String previewType;
        private LocalDate serviceActivationDate;
        private List<POSTSrpCreateType> subscribeToRatePlans;
        private LocalDate targetDate;
        private LocalDate termStartDate;
        private String termType;
        private String idempotencyKey;
        private String acceptEncoding;
        private String contentEncoding;
        private String authorization;
        private String zuoraTrackId;
        private String zuoraEntityIds;
        private String zuoraOrgIds;
        private String zuoraVersion;
        private POSTSubscriptionPreviewType poSTSubscriptionPreviewType;

        private PreviewSubscriptionRequestBuilder() {
        }

        /**
         * Set poSTSubscriptionPreviewType
         * @param poSTSubscriptionPreviewType  (optional)
         * @return PreviewSubscriptionRequestBuilder
         */
        public PreviewSubscriptionRequestBuilder poSTSubscriptionPreviewType(POSTSubscriptionPreviewType poSTSubscriptionPreviewType) {
            this.poSTSubscriptionPreviewType = poSTSubscriptionPreviewType;
            return this;
        }

        /**
         * Set accountKey
         * @param accountKey  Customer account number or ID.  You must specify the account information either in this field or in the &#x60;previewAccountInfo&#x60; field with the following conditions:           * If you already have a customer account, specify the account number or ID in this field. * If you do not have a customer account, provide account information in the &#x60;previewAccountInfo&#x60; field.  (optional)
         * @return PreviewSubscriptionRequestBuilder
         */
        public PreviewSubscriptionRequestBuilder accountKey(String accountKey) {
            this.accountKey = accountKey;
            return this;
        }
        
        /**
         * Set contractEffectiveDate
         * @param contractEffectiveDate Effective contract date for this subscription, as yyyy-mm-dd.  (optional)
         * @return PreviewSubscriptionRequestBuilder
         */
        public PreviewSubscriptionRequestBuilder contractEffectiveDate(LocalDate contractEffectiveDate) {
            this.contractEffectiveDate = contractEffectiveDate;
            return this;
        }
        
        /**
         * Set customerAcceptanceDate
         * @param customerAcceptanceDate The date on which the services or products within a subscription have been accepted by the customer, as yyyy-mm-dd.  Default value is dependent on the value of other fields. See **Notes** section for more details.  (optional)
         * @return PreviewSubscriptionRequestBuilder
         */
        public PreviewSubscriptionRequestBuilder customerAcceptanceDate(LocalDate customerAcceptanceDate) {
            this.customerAcceptanceDate = customerAcceptanceDate;
            return this;
        }
        
        /**
         * Set documentDate
         * @param documentDate The date of the billing document, in &#x60;yyyy-mm-dd&#x60; format. It represents the invoice date for invoices, credit memo date for credit memos, and debit memo date for debit memos.  - If this field is specified, the specified date is used as the billing document date.  - If this field is not specified, the date specified in the &#x60;targetDate&#x60; is used as the billing document date.  (optional)
         * @return PreviewSubscriptionRequestBuilder
         */
        public PreviewSubscriptionRequestBuilder documentDate(LocalDate documentDate) {
            this.documentDate = documentDate;
            return this;
        }
        
        /**
         * Set includeExistingDraftDocItems
         * @param includeExistingDraftDocItems Specifies whether to include draft invoice items in subscription previews. Values are:  * &#x60;true&#x60; (default). Includes draft invoice items in the preview result. * &#x60;false&#x60;. Excludes draft invoice items in the preview result.  **Note:** This field is in Zuora REST API version control. Supported minor versions are 207.0 or later [available versions](https://developer.zuora.com/api-references/api/overview/#section/API-Versions/Minor-Version).  (optional)
         * @return PreviewSubscriptionRequestBuilder
         */
        public PreviewSubscriptionRequestBuilder includeExistingDraftDocItems(Boolean includeExistingDraftDocItems) {
            this.includeExistingDraftDocItems = includeExistingDraftDocItems;
            return this;
        }
        
        /**
         * Set includeExistingDraftInvoiceItems
         * @param includeExistingDraftInvoiceItems Specifies whether to include draft invoice items in previews. Values are:  * &#x60;true&#x60; (default). Includes draft invoice items in the preview result. * &#x60;false&#x60;. Excludes draft invoice items in the preview result.  **Note:** This field is in Zuora REST API version control. Supported minor versions are 186.0, 187.0, 188.0, 189.0, 196.0, and 206.0.  (optional)
         * @return PreviewSubscriptionRequestBuilder
         */
        public PreviewSubscriptionRequestBuilder includeExistingDraftInvoiceItems(Boolean includeExistingDraftInvoiceItems) {
            this.includeExistingDraftInvoiceItems = includeExistingDraftInvoiceItems;
            return this;
        }
        
        /**
         * Set initialTerm
         * @param initialTerm Duration of the first term of the subscription, in whole months. If &#x60;termType&#x60; is &#x60;TERMED&#x60;, then this field is required, and the value must be greater than &#x60;0&#x60;. If &#x60;termType&#x60; is &#x60;EVERGREEN&#x60;, this field is ignored.      (optional)
         * @return PreviewSubscriptionRequestBuilder
         */
        public PreviewSubscriptionRequestBuilder initialTerm(Long initialTerm) {
            this.initialTerm = initialTerm;
            return this;
        }
        
        /**
         * Set initialTermPeriodType
         * @param initialTermPeriodType The period type of the initial term.   Supported values are:  * &#x60;Month&#x60; * &#x60;Year&#x60; * &#x60;Day&#x60; * &#x60;Week&#x60;   The default period type is &#x60;Month&#x60;.   (optional)
         * @return PreviewSubscriptionRequestBuilder
         */
        public PreviewSubscriptionRequestBuilder initialTermPeriodType(String initialTermPeriodType) {
            this.initialTermPeriodType = initialTermPeriodType;
            return this;
        }
        
        /**
         * Set invoiceOwnerAccountKey
         * @param invoiceOwnerAccountKey Invoice owner account number or ID.  **Note:** This feature is in **Limited Availability**. If you wish to have access to the feature, submit a request at [Zuora Global Support](http://support.zuora.com/).  (optional)
         * @return PreviewSubscriptionRequestBuilder
         */
        public PreviewSubscriptionRequestBuilder invoiceOwnerAccountKey(String invoiceOwnerAccountKey) {
            this.invoiceOwnerAccountKey = invoiceOwnerAccountKey;
            return this;
        }
        
        /**
         * Set invoiceTargetDate
         * @param invoiceTargetDate Date through which to calculate charges if an invoice is generated, as yyyy-mm-dd. Default is current date.  **Note:** This field is in Zuora REST API version control. Supported minor versions are 186.0, 187.0, 188.0, 189.0, 196.0, and 206.0. .  (optional)
         * @return PreviewSubscriptionRequestBuilder
         */
        public PreviewSubscriptionRequestBuilder invoiceTargetDate(LocalDate invoiceTargetDate) {
            this.invoiceTargetDate = invoiceTargetDate;
            return this;
        }
        
        /**
         * Set notes
         * @param notes String of up to 500 characters. (optional)
         * @return PreviewSubscriptionRequestBuilder
         */
        public PreviewSubscriptionRequestBuilder notes(String notes) {
            this.notes = notes;
            return this;
        }
        
        /**
         * Set previewAccountInfo
         * @param previewAccountInfo  (optional)
         * @return PreviewSubscriptionRequestBuilder
         */
        public PreviewSubscriptionRequestBuilder previewAccountInfo(POSTSubscriptionPreviewTypePreviewAccountInfo previewAccountInfo) {
            this.previewAccountInfo = previewAccountInfo;
            return this;
        }
        
        /**
         * Set previewType
         * @param previewType The type of preview you will receive.   This field is in Zuora REST API version control. The supported values of this field depend on the REST API minor version you specified in the request header.   * If you do not specify the REST API minor version or specify the minor version number to one of following values in the request header:     * 186.0   * 187.0   * 188.0   * 189.0   * 196.0   * 206.0      The following values are supported in the **previewType** field:    * InvoiceItem   * ChargeMetrics   * InvoiceItemChargeMetrics      The default value is InvoiceItem.  * If you specify the REST API minor version to 207.0 or later [available versions](https://developer.zuora.com/api-references/api/overview/#section/API-Versions/Minor-Version) in the request header, the following values are supported in the **previewType** field:    - LegalDoc   - ChargeMetrics   - LegalDocChargeMetrics    The default value is LegalDoc.  .  (optional)
         * @return PreviewSubscriptionRequestBuilder
         */
        public PreviewSubscriptionRequestBuilder previewType(String previewType) {
            this.previewType = previewType;
            return this;
        }
        
        /**
         * Set serviceActivationDate
         * @param serviceActivationDate The date on which the services or products within a subscription have been activated and access has been provided to the customer, as yyyy-mm-dd.  Default value is dependent on the value of other fields. See **Notes** section for more details.  (optional)
         * @return PreviewSubscriptionRequestBuilder
         */
        public PreviewSubscriptionRequestBuilder serviceActivationDate(LocalDate serviceActivationDate) {
            this.serviceActivationDate = serviceActivationDate;
            return this;
        }
        
        /**
         * Set subscribeToRatePlans
         * @param subscribeToRatePlans Container for one or more rate plans for this subscription.  (optional)
         * @return PreviewSubscriptionRequestBuilder
         */
        public PreviewSubscriptionRequestBuilder subscribeToRatePlans(List<POSTSrpCreateType> subscribeToRatePlans) {
            this.subscribeToRatePlans = subscribeToRatePlans;
            return this;
        }
        
        /**
         * Set targetDate
         * @param targetDate Date through which to calculate charges if an invoice is generated, as yyyy-mm-dd. Default is current date.  **Note:** This field is in Zuora REST API version control. Supported minor versions are 207.0 or later [available versions](https://developer.zuora.com/api-references/api/overview/#section/API-Versions/Minor-Version). To use this field in the method, you must set the &#x60;zuora-version&#x60; parameter to the minor version number in the request header.  (optional)
         * @return PreviewSubscriptionRequestBuilder
         */
        public PreviewSubscriptionRequestBuilder targetDate(LocalDate targetDate) {
            this.targetDate = targetDate;
            return this;
        }
        
        /**
         * Set termStartDate
         * @param termStartDate The date on which the subscription term begins, as yyyy-mm-dd. If this is a renewal subscription, this date is different from the subscription start date.  (optional)
         * @return PreviewSubscriptionRequestBuilder
         */
        public PreviewSubscriptionRequestBuilder termStartDate(LocalDate termStartDate) {
            this.termStartDate = termStartDate;
            return this;
        }
        
        /**
         * Set termType
         * @param termType Possible values are: &#x60;TERMED&#x60;, &#x60;EVERGREEN&#x60;.  (optional)
         * @return PreviewSubscriptionRequestBuilder
         */
        public PreviewSubscriptionRequestBuilder termType(String termType) {
            this.termType = termType;
            return this;
        }
        
        /**
         * Set idempotencyKey
         * @param idempotencyKey Specify a unique idempotency key if you want to perform an idempotent POST or PATCH request. Do not use this header in other request types.   With this header specified, the Zuora server can identify subsequent retries of the same request using this value, which prevents the same operation from being performed multiple times by accident.   (optional)
         * @return PreviewSubscriptionRequestBuilder
         */
        public PreviewSubscriptionRequestBuilder idempotencyKey(String idempotencyKey) {
            this.idempotencyKey = idempotencyKey;
            return this;
        }
        
        /**
         * Set acceptEncoding
         * @param acceptEncoding Include the &#x60;Accept-Encoding: gzip&#x60; header to compress responses as a gzipped file. It can significantly reduce the bandwidth required for a response.   If specified, Zuora automatically compresses responses that contain over 1000 bytes of data, and the response contains a &#x60;Content-Encoding&#x60; header with the compression algorithm so that your client can decompress it.  (optional)
         * @return PreviewSubscriptionRequestBuilder
         */
        public PreviewSubscriptionRequestBuilder acceptEncoding(String acceptEncoding) {
            this.acceptEncoding = acceptEncoding;
            return this;
        }
        
        /**
         * Set contentEncoding
         * @param contentEncoding Include the &#x60;Content-Encoding: gzip&#x60; header to compress a request. With this header specified, you should upload a gzipped file for the request payload instead of sending the JSON payload.  (optional)
         * @return PreviewSubscriptionRequestBuilder
         */
        public PreviewSubscriptionRequestBuilder contentEncoding(String contentEncoding) {
            this.contentEncoding = contentEncoding;
            return this;
        }
        
        /**
         * Set authorization
         * @param authorization The value is in the &#x60;Bearer {token}&#x60; format where {token} is a valid OAuth token generated by calling [Create an OAuth token](https://developer.zuora.com/api-references/api/operation/createToken).  (optional)
         * @return PreviewSubscriptionRequestBuilder
         */
        public PreviewSubscriptionRequestBuilder authorization(String authorization) {
            this.authorization = authorization;
            return this;
        }
        
        /**
         * Set zuoraTrackId
         * @param zuoraTrackId A custom identifier for tracing the API call. If you set a value for this header, Zuora returns the same value in the response headers. This header enables you to associate your system process identifiers with Zuora API calls, to assist with troubleshooting in the event of an issue.  The value of this field must use the US-ASCII character set and must not include any of the following characters: colon (&#x60;:&#x60;), semicolon (&#x60;;&#x60;), double quote (&#x60;\&quot;&#x60;), and quote (&#x60;&#39;&#x60;).  (optional)
         * @return PreviewSubscriptionRequestBuilder
         */
        public PreviewSubscriptionRequestBuilder zuoraTrackId(String zuoraTrackId) {
            this.zuoraTrackId = zuoraTrackId;
            return this;
        }
        
        /**
         * Set zuoraEntityIds
         * @param zuoraEntityIds An entity ID. If you have [Zuora Multi-entity](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Multi-entity) enabled and the OAuth token is valid for more than one entity, you must use this header to specify which entity to perform the operation in. If the OAuth token is only valid for a single entity, or you do not have Zuora Multi-entity enabled, you do not need to set this header.  (optional)
         * @return PreviewSubscriptionRequestBuilder
         */
        public PreviewSubscriptionRequestBuilder zuoraEntityIds(String zuoraEntityIds) {
            this.zuoraEntityIds = zuoraEntityIds;
            return this;
        }
        
        /**
         * Set zuoraOrgIds
         * @param zuoraOrgIds Comma separated IDs. If you have &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Central_Platform/Multi-Org\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Zuora Multi-Org&lt;/a&gt; enabled,  you can use this header to specify which orgs to perform the operation in. If you do not have Zuora Multi-Org enabled, you should not set this header.  The IDs must be a sub-set of the user&#39;s accessible orgs. If you specify an org that the user does not have access to, the operation fails.  If the header is not set, the operation is performed in scope of the user&#39;s accessible orgs.  (optional)
         * @return PreviewSubscriptionRequestBuilder
         */
        public PreviewSubscriptionRequestBuilder zuoraOrgIds(String zuoraOrgIds) {
            this.zuoraOrgIds = zuoraOrgIds;
            return this;
        }
        
        /**
         * Set zuoraVersion
         * @param zuoraVersion  The minor version of the Zuora REST API.   You need to set this parameter if you use the following fields: * targetDate * includeExistingDraftDocItems * previewType * taxationItems   If you have the Invoice Settlement feature enabled, you need to specify this parameter. Otherwise, an error is returned.   .   (optional)
         * @return PreviewSubscriptionRequestBuilder
         */
        public PreviewSubscriptionRequestBuilder zuoraVersion(String zuoraVersion) {
            this.zuoraVersion = zuoraVersion;
            return this;
        }
        
        /**
         * Build call for previewSubscription
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
            POSTSubscriptionPreviewType poSTSubscriptionPreviewType = buildBodyParams();
            return previewSubscriptionCall(poSTSubscriptionPreviewType, idempotencyKey, acceptEncoding, contentEncoding, authorization, zuoraTrackId, zuoraEntityIds, zuoraOrgIds, zuoraVersion, _callback);
        }

        private POSTSubscriptionPreviewType buildBodyParams() {
            return this.poSTSubscriptionPreviewType;
        }

        /**
         * Execute previewSubscription request
         * @return POSTSubscriptionPreviewResponseType
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td>  </td><td>  * Content-Encoding - This header is returned if you specify the &#x60;Accept-Encoding: gzip&#x60; request header and the response contains over 1000 bytes of data. Note that only the following MIME types support gzipped responses:   - &#x60;application/json&#x60;   - &#x60;application/xml&#x60;   - &#x60;text/html&#x60;   - &#x60;text/csv&#x60;   - &#x60;text/plain&#x60;  <br>  * RateLimit-Limit - The request limit quota for the time window closest to exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Remaining - The number of requests remaining in the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Reset - The number of seconds until the quota resets for the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Zuora-Request-Id - The Zuora internal identifier of the API call. You cannot control the value of this header.  <br>  * Zuora-Track-Id - A custom identifier for tracing the API call. If you specified a tracing identifier in the request headers, Zuora returns the same tracing identifier. Otherwise, Zuora does not set this header.  <br>  </td></tr>
         </table>
         */
        public POSTSubscriptionPreviewResponseType execute() throws ApiException {
            POSTSubscriptionPreviewType poSTSubscriptionPreviewType = buildBodyParams();
            ApiResponse<POSTSubscriptionPreviewResponseType> localVarResp = previewSubscriptionWithHttpInfo(poSTSubscriptionPreviewType, idempotencyKey, acceptEncoding, contentEncoding, authorization, zuoraTrackId, zuoraEntityIds, zuoraOrgIds, zuoraVersion);
            return localVarResp.getResponseBody();
        }

        /**
         * Execute previewSubscription request with HTTP info returned
         * @return ApiResponse&lt;POSTSubscriptionPreviewResponseType&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td>  </td><td>  * Content-Encoding - This header is returned if you specify the &#x60;Accept-Encoding: gzip&#x60; request header and the response contains over 1000 bytes of data. Note that only the following MIME types support gzipped responses:   - &#x60;application/json&#x60;   - &#x60;application/xml&#x60;   - &#x60;text/html&#x60;   - &#x60;text/csv&#x60;   - &#x60;text/plain&#x60;  <br>  * RateLimit-Limit - The request limit quota for the time window closest to exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Remaining - The number of requests remaining in the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Reset - The number of seconds until the quota resets for the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Zuora-Request-Id - The Zuora internal identifier of the API call. You cannot control the value of this header.  <br>  * Zuora-Track-Id - A custom identifier for tracing the API call. If you specified a tracing identifier in the request headers, Zuora returns the same tracing identifier. Otherwise, Zuora does not set this header.  <br>  </td></tr>
         </table>
         */
        public ApiResponse<POSTSubscriptionPreviewResponseType> executeWithHttpInfo() throws ApiException {
            POSTSubscriptionPreviewType poSTSubscriptionPreviewType = buildBodyParams();
            return previewSubscriptionWithHttpInfo(poSTSubscriptionPreviewType, idempotencyKey, acceptEncoding, contentEncoding, authorization, zuoraTrackId, zuoraEntityIds, zuoraOrgIds, zuoraVersion);
        }

        /**
         * Execute previewSubscription request (asynchronously)
         * @param _callback The callback to be executed when the API call finishes
         * @return The request call
         * @throws ApiException If fail to process the API call, e.g. serializing the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td>  </td><td>  * Content-Encoding - This header is returned if you specify the &#x60;Accept-Encoding: gzip&#x60; request header and the response contains over 1000 bytes of data. Note that only the following MIME types support gzipped responses:   - &#x60;application/json&#x60;   - &#x60;application/xml&#x60;   - &#x60;text/html&#x60;   - &#x60;text/csv&#x60;   - &#x60;text/plain&#x60;  <br>  * RateLimit-Limit - The request limit quota for the time window closest to exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Remaining - The number of requests remaining in the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Reset - The number of seconds until the quota resets for the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Zuora-Request-Id - The Zuora internal identifier of the API call. You cannot control the value of this header.  <br>  * Zuora-Track-Id - A custom identifier for tracing the API call. If you specified a tracing identifier in the request headers, Zuora returns the same tracing identifier. Otherwise, Zuora does not set this header.  <br>  </td></tr>
         </table>
         */
        public okhttp3.Call executeAsync(final ApiCallback<POSTSubscriptionPreviewResponseType> _callback) throws ApiException {
            POSTSubscriptionPreviewType poSTSubscriptionPreviewType = buildBodyParams();
            return previewSubscriptionAsync(poSTSubscriptionPreviewType, idempotencyKey, acceptEncoding, contentEncoding, authorization, zuoraTrackId, zuoraEntityIds, zuoraOrgIds, zuoraVersion, _callback);
        }
    }

    /**
     * Preview a subscription
     * The REST API reference describes how to create a new subscription in preview mode. This call does not require a valid customer account. It can be used to show potential new customers a preview of a subscription with complete details and charges before creating an account, or to let existing customers preview a subscription with all charges before committing.  ### Notes - The response of the Preview Subscription call is based on the REST API minor version you set in the request header. The response structure might be different if you use different minor version numbers.   - If you have the Invoice Settlement feature enabled, we recommend that you set the &#x60;zuora-version&#x60; parameter to &#x60;207.0&#x60; or later [available versions](https://developer.zuora.com/api-references/api/overview/#section/API-Versions/Minor-Version). Otherwise, an error is returned.   - Default values for **customerAcceptanceDate** and **serviceActivationDate** are set as follows.  |        | serviceActivationDate (SA) specified          | serviceActivationDate (SA) NOT specified  | | ------------- |:-------------:| -----:| | customerAcceptanceDate (CA) specified      | SA uses value in the request call; CA uses value in the request call| CA uses value in the request call;SA uses CE as default | | customerAcceptanceDate (CA) NOT specified      | SA uses value in the request call; CA uses SA as default |   SA and CA use CE as default | 
     * @param poSTSubscriptionPreviewType  (required)
     * @return PreviewSubscriptionRequestBuilder
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td>  </td><td>  * Content-Encoding - This header is returned if you specify the &#x60;Accept-Encoding: gzip&#x60; request header and the response contains over 1000 bytes of data. Note that only the following MIME types support gzipped responses:   - &#x60;application/json&#x60;   - &#x60;application/xml&#x60;   - &#x60;text/html&#x60;   - &#x60;text/csv&#x60;   - &#x60;text/plain&#x60;  <br>  * RateLimit-Limit - The request limit quota for the time window closest to exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Remaining - The number of requests remaining in the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Reset - The number of seconds until the quota resets for the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Zuora-Request-Id - The Zuora internal identifier of the API call. You cannot control the value of this header.  <br>  * Zuora-Track-Id - A custom identifier for tracing the API call. If you specified a tracing identifier in the request headers, Zuora returns the same tracing identifier. Otherwise, Zuora does not set this header.  <br>  </td></tr>
     </table>
     */
    public PreviewSubscriptionRequestBuilder previewSubscription() throws IllegalArgumentException {
        return new PreviewSubscriptionRequestBuilder();
    }
    private okhttp3.Call previewSubscriptionBySubscriptionKeyCall(String subscriptionKey, PreviewExistingSubscriptionRequest request, String acceptEncoding, String contentEncoding, String authorization, String zuoraTrackId, String zuoraEntityIds, String zuoraVersion, final ApiCallback _callback) throws ApiException {
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

        Object localVarPostBody = request;

        // create path and map variables
        String localVarPath = "/v1/subscriptions/{subscription-key}/preview"
            .replace("{" + "subscription-key" + "}", localVarApiClient.escapeString(subscriptionKey.toString()));

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
    private okhttp3.Call previewSubscriptionBySubscriptionKeyValidateBeforeCall(String subscriptionKey, PreviewExistingSubscriptionRequest request, String acceptEncoding, String contentEncoding, String authorization, String zuoraTrackId, String zuoraEntityIds, String zuoraVersion, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'subscriptionKey' is set
        if (subscriptionKey == null) {
            throw new ApiException("Missing the required parameter 'subscriptionKey' when calling previewSubscriptionBySubscriptionKey(Async)");
        }

        // verify the required parameter 'request' is set
        if (request == null) {
            throw new ApiException("Missing the required parameter 'request' when calling previewSubscriptionBySubscriptionKey(Async)");
        }

        return previewSubscriptionBySubscriptionKeyCall(subscriptionKey, request, acceptEncoding, contentEncoding, authorization, zuoraTrackId, zuoraEntityIds, zuoraVersion, _callback);

    }


    private ApiResponse<PreviewExistingSubscriptionResponse> previewSubscriptionBySubscriptionKeyWithHttpInfo(String subscriptionKey, PreviewExistingSubscriptionRequest request, String acceptEncoding, String contentEncoding, String authorization, String zuoraTrackId, String zuoraEntityIds, String zuoraVersion) throws ApiException {
        okhttp3.Call localVarCall = previewSubscriptionBySubscriptionKeyValidateBeforeCall(subscriptionKey, request, acceptEncoding, contentEncoding, authorization, zuoraTrackId, zuoraEntityIds, zuoraVersion, null);
        Type localVarReturnType = new TypeToken<PreviewExistingSubscriptionResponse>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    private okhttp3.Call previewSubscriptionBySubscriptionKeyAsync(String subscriptionKey, PreviewExistingSubscriptionRequest request, String acceptEncoding, String contentEncoding, String authorization, String zuoraTrackId, String zuoraEntityIds, String zuoraVersion, final ApiCallback<PreviewExistingSubscriptionResponse> _callback) throws ApiException {

        okhttp3.Call localVarCall = previewSubscriptionBySubscriptionKeyValidateBeforeCall(subscriptionKey, request, acceptEncoding, contentEncoding, authorization, zuoraTrackId, zuoraEntityIds, zuoraVersion, _callback);
        Type localVarReturnType = new TypeToken<PreviewExistingSubscriptionResponse>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    public class PreviewSubscriptionBySubscriptionKeyRequestBuilder {
        private final String subscriptionKey;
        private PreviewStartDate previewStartDate;
        private PreviewThroughDate previewThroughDate;
        private List<QuantityForUsageCharges> quantityForUsageCharges;
        private String acceptEncoding;
        private String contentEncoding;
        private String authorization;
        private String zuoraTrackId;
        private String zuoraEntityIds;
        private String zuoraVersion;

        private PreviewSubscriptionBySubscriptionKeyRequestBuilder(String subscriptionKey) {
            this.subscriptionKey = subscriptionKey;
        }

        /**
         * Set previewStartDate
         * @param previewStartDate  (optional)
         * @return PreviewSubscriptionBySubscriptionKeyRequestBuilder
         */
        public PreviewSubscriptionBySubscriptionKeyRequestBuilder previewStartDate(PreviewStartDate previewStartDate) {
            this.previewStartDate = previewStartDate;
            return this;
        }
        
        /**
         * Set previewThroughDate
         * @param previewThroughDate  (optional)
         * @return PreviewSubscriptionBySubscriptionKeyRequestBuilder
         */
        public PreviewSubscriptionBySubscriptionKeyRequestBuilder previewThroughDate(PreviewThroughDate previewThroughDate) {
            this.previewThroughDate = previewThroughDate;
            return this;
        }
        
        /**
         * Set quantityForUsageCharges
         * @param quantityForUsageCharges Container for usage charges.  (optional)
         * @return PreviewSubscriptionBySubscriptionKeyRequestBuilder
         */
        public PreviewSubscriptionBySubscriptionKeyRequestBuilder quantityForUsageCharges(List<QuantityForUsageCharges> quantityForUsageCharges) {
            this.quantityForUsageCharges = quantityForUsageCharges;
            return this;
        }
        
        /**
         * Set acceptEncoding
         * @param acceptEncoding Include the &#x60;Accept-Encoding: gzip&#x60; header to compress responses as a gzipped file. It can significantly reduce the bandwidth required for a response.   If specified, Zuora automatically compresses responses that contain over 1000 bytes of data, and the response contains a &#x60;Content-Encoding&#x60; header with the compression algorithm so that your client can decompress it.  (optional)
         * @return PreviewSubscriptionBySubscriptionKeyRequestBuilder
         */
        public PreviewSubscriptionBySubscriptionKeyRequestBuilder acceptEncoding(String acceptEncoding) {
            this.acceptEncoding = acceptEncoding;
            return this;
        }
        
        /**
         * Set contentEncoding
         * @param contentEncoding Include the &#x60;Content-Encoding: gzip&#x60; header to compress a request. With this header specified, you should upload a gzipped file for the request payload instead of sending the JSON payload.  (optional)
         * @return PreviewSubscriptionBySubscriptionKeyRequestBuilder
         */
        public PreviewSubscriptionBySubscriptionKeyRequestBuilder contentEncoding(String contentEncoding) {
            this.contentEncoding = contentEncoding;
            return this;
        }
        
        /**
         * Set authorization
         * @param authorization The value is in the &#x60;Bearer {token}&#x60; format where {token} is a valid OAuth token generated by calling [Create an OAuth token](https://developer.zuora.com/api-references/api/operation/createToken).  (optional)
         * @return PreviewSubscriptionBySubscriptionKeyRequestBuilder
         */
        public PreviewSubscriptionBySubscriptionKeyRequestBuilder authorization(String authorization) {
            this.authorization = authorization;
            return this;
        }
        
        /**
         * Set zuoraTrackId
         * @param zuoraTrackId A custom identifier for tracing the API call. If you set a value for this header, Zuora returns the same value in the response headers. This header enables you to associate your system process identifiers with Zuora API calls, to assist with troubleshooting in the event of an issue.  The value of this field must use the US-ASCII character set and must not include any of the following characters: colon (&#x60;:&#x60;), semicolon (&#x60;;&#x60;), double quote (&#x60;\&quot;&#x60;), and quote (&#x60;&#39;&#x60;).  (optional)
         * @return PreviewSubscriptionBySubscriptionKeyRequestBuilder
         */
        public PreviewSubscriptionBySubscriptionKeyRequestBuilder zuoraTrackId(String zuoraTrackId) {
            this.zuoraTrackId = zuoraTrackId;
            return this;
        }
        
        /**
         * Set zuoraEntityIds
         * @param zuoraEntityIds An entity ID. If you have [Zuora Multi-entity](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Multi-entity) enabled and the OAuth token is valid for more than one entity, you must use this header to specify which entity to perform the operation in. If the OAuth token is only valid for a single entity, or you do not have Zuora Multi-entity enabled, you do not need to set this header.  (optional)
         * @return PreviewSubscriptionBySubscriptionKeyRequestBuilder
         */
        public PreviewSubscriptionBySubscriptionKeyRequestBuilder zuoraEntityIds(String zuoraEntityIds) {
            this.zuoraEntityIds = zuoraEntityIds;
            return this;
        }
        
        /**
         * Set zuoraVersion
         * @param zuoraVersion  The minor version of the Zuora REST API.   You need to set this parameter if you use the following fields: * targetDate * includeExistingDraftDocItems * previewType * taxationItems   If you have the Invoice Settlement feature enabled, you need to specify this parameter. Otherwise, an error is returned.  (optional)
         * @return PreviewSubscriptionBySubscriptionKeyRequestBuilder
         */
        public PreviewSubscriptionBySubscriptionKeyRequestBuilder zuoraVersion(String zuoraVersion) {
            this.zuoraVersion = zuoraVersion;
            return this;
        }
        
        /**
         * Build call for previewSubscriptionBySubscriptionKey
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
            PreviewExistingSubscriptionRequest request = buildBodyParams();
            return previewSubscriptionBySubscriptionKeyCall(subscriptionKey, request, acceptEncoding, contentEncoding, authorization, zuoraTrackId, zuoraEntityIds, zuoraVersion, _callback);
        }

        private PreviewExistingSubscriptionRequest buildBodyParams() {
            PreviewExistingSubscriptionRequest request = new PreviewExistingSubscriptionRequest();
            request.previewStartDate(this.previewStartDate);
            request.previewThroughDate(this.previewThroughDate);
            request.quantityForUsageCharges(this.quantityForUsageCharges);
            return request;
        }

        /**
         * Execute previewSubscriptionBySubscriptionKey request
         * @return PreviewExistingSubscriptionResponse
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td>  </td><td>  * Content-Encoding - This header is returned if you specify the &#x60;Accept-Encoding: gzip&#x60; request header and the response contains over 1000 bytes of data. Note that only the following MIME types support gzipped responses:   - &#x60;application/json&#x60;   - &#x60;application/xml&#x60;   - &#x60;text/html&#x60;   - &#x60;text/csv&#x60;   - &#x60;text/plain&#x60;  <br>  * RateLimit-Limit - The request limit quota for the time window closest to exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Remaining - The number of requests remaining in the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Reset - The number of seconds until the quota resets for the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Zuora-Request-Id - The Zuora internal identifier of the API call. You cannot control the value of this header.  <br>  * Zuora-Track-Id - A custom identifier for tracing the API call. If you specified a tracing identifier in the request headers, Zuora returns the same tracing identifier. Otherwise, Zuora does not set this header.  <br>  </td></tr>
         </table>
         */
        public PreviewExistingSubscriptionResponse execute() throws ApiException {
            PreviewExistingSubscriptionRequest request = buildBodyParams();
            ApiResponse<PreviewExistingSubscriptionResponse> localVarResp = previewSubscriptionBySubscriptionKeyWithHttpInfo(subscriptionKey, request, acceptEncoding, contentEncoding, authorization, zuoraTrackId, zuoraEntityIds, zuoraVersion);
            return localVarResp.getResponseBody();
        }

        /**
         * Execute previewSubscriptionBySubscriptionKey request with HTTP info returned
         * @return ApiResponse&lt;PreviewExistingSubscriptionResponse&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td>  </td><td>  * Content-Encoding - This header is returned if you specify the &#x60;Accept-Encoding: gzip&#x60; request header and the response contains over 1000 bytes of data. Note that only the following MIME types support gzipped responses:   - &#x60;application/json&#x60;   - &#x60;application/xml&#x60;   - &#x60;text/html&#x60;   - &#x60;text/csv&#x60;   - &#x60;text/plain&#x60;  <br>  * RateLimit-Limit - The request limit quota for the time window closest to exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Remaining - The number of requests remaining in the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Reset - The number of seconds until the quota resets for the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Zuora-Request-Id - The Zuora internal identifier of the API call. You cannot control the value of this header.  <br>  * Zuora-Track-Id - A custom identifier for tracing the API call. If you specified a tracing identifier in the request headers, Zuora returns the same tracing identifier. Otherwise, Zuora does not set this header.  <br>  </td></tr>
         </table>
         */
        public ApiResponse<PreviewExistingSubscriptionResponse> executeWithHttpInfo() throws ApiException {
            PreviewExistingSubscriptionRequest request = buildBodyParams();
            return previewSubscriptionBySubscriptionKeyWithHttpInfo(subscriptionKey, request, acceptEncoding, contentEncoding, authorization, zuoraTrackId, zuoraEntityIds, zuoraVersion);
        }

        /**
         * Execute previewSubscriptionBySubscriptionKey request (asynchronously)
         * @param _callback The callback to be executed when the API call finishes
         * @return The request call
         * @throws ApiException If fail to process the API call, e.g. serializing the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td>  </td><td>  * Content-Encoding - This header is returned if you specify the &#x60;Accept-Encoding: gzip&#x60; request header and the response contains over 1000 bytes of data. Note that only the following MIME types support gzipped responses:   - &#x60;application/json&#x60;   - &#x60;application/xml&#x60;   - &#x60;text/html&#x60;   - &#x60;text/csv&#x60;   - &#x60;text/plain&#x60;  <br>  * RateLimit-Limit - The request limit quota for the time window closest to exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Remaining - The number of requests remaining in the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Reset - The number of seconds until the quota resets for the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Zuora-Request-Id - The Zuora internal identifier of the API call. You cannot control the value of this header.  <br>  * Zuora-Track-Id - A custom identifier for tracing the API call. If you specified a tracing identifier in the request headers, Zuora returns the same tracing identifier. Otherwise, Zuora does not set this header.  <br>  </td></tr>
         </table>
         */
        public okhttp3.Call executeAsync(final ApiCallback<PreviewExistingSubscriptionResponse> _callback) throws ApiException {
            PreviewExistingSubscriptionRequest request = buildBodyParams();
            return previewSubscriptionBySubscriptionKeyAsync(subscriptionKey, request, acceptEncoding, contentEncoding, authorization, zuoraTrackId, zuoraEntityIds, zuoraVersion, _callback);
        }
    }

    /**
     * Preview a subscription by subscription key
     * Describes how to preview an existing subscription to view information about existing and future invoices or credit memos.    **Note**: The &#x60;zuora-version&#x60; parameter must be &#x60;207.0&#x60; or later.  
     * @param subscriptionKey Subscription number or ID (required)
     * @param request  (required)
     * @return PreviewSubscriptionBySubscriptionKeyRequestBuilder
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td>  </td><td>  * Content-Encoding - This header is returned if you specify the &#x60;Accept-Encoding: gzip&#x60; request header and the response contains over 1000 bytes of data. Note that only the following MIME types support gzipped responses:   - &#x60;application/json&#x60;   - &#x60;application/xml&#x60;   - &#x60;text/html&#x60;   - &#x60;text/csv&#x60;   - &#x60;text/plain&#x60;  <br>  * RateLimit-Limit - The request limit quota for the time window closest to exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Remaining - The number of requests remaining in the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Reset - The number of seconds until the quota resets for the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Zuora-Request-Id - The Zuora internal identifier of the API call. You cannot control the value of this header.  <br>  * Zuora-Track-Id - A custom identifier for tracing the API call. If you specified a tracing identifier in the request headers, Zuora returns the same tracing identifier. Otherwise, Zuora does not set this header.  <br>  </td></tr>
     </table>
     */
    public PreviewSubscriptionBySubscriptionKeyRequestBuilder previewSubscriptionBySubscriptionKey(String subscriptionKey) throws IllegalArgumentException {
        if (subscriptionKey == null) throw new IllegalArgumentException("\"subscriptionKey\" is required but got null");
            

        return new PreviewSubscriptionBySubscriptionKeyRequestBuilder(subscriptionKey);
    }
    private okhttp3.Call renewSubscriptionCall(String subscriptionKey, PUTRenewSubscriptionType puTRenewSubscriptionType, String acceptEncoding, String contentEncoding, String authorization, String zuoraTrackId, String zuoraEntityIds, String zuoraOrgIds, String zuoraVersion, final ApiCallback _callback) throws ApiException {
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

        Object localVarPostBody = puTRenewSubscriptionType;

        // create path and map variables
        String localVarPath = "/v1/subscriptions/{subscription-key}/renew"
            .replace("{" + "subscription-key" + "}", localVarApiClient.escapeString(subscriptionKey.toString()));

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
    private okhttp3.Call renewSubscriptionValidateBeforeCall(String subscriptionKey, PUTRenewSubscriptionType puTRenewSubscriptionType, String acceptEncoding, String contentEncoding, String authorization, String zuoraTrackId, String zuoraEntityIds, String zuoraOrgIds, String zuoraVersion, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'subscriptionKey' is set
        if (subscriptionKey == null) {
            throw new ApiException("Missing the required parameter 'subscriptionKey' when calling renewSubscription(Async)");
        }

        // verify the required parameter 'puTRenewSubscriptionType' is set
        if (puTRenewSubscriptionType == null) {
            throw new ApiException("Missing the required parameter 'puTRenewSubscriptionType' when calling renewSubscription(Async)");
        }

        return renewSubscriptionCall(subscriptionKey, puTRenewSubscriptionType, acceptEncoding, contentEncoding, authorization, zuoraTrackId, zuoraEntityIds, zuoraOrgIds, zuoraVersion, _callback);

    }


    private ApiResponse<PUTRenewSubscriptionResponseType> renewSubscriptionWithHttpInfo(String subscriptionKey, PUTRenewSubscriptionType puTRenewSubscriptionType, String acceptEncoding, String contentEncoding, String authorization, String zuoraTrackId, String zuoraEntityIds, String zuoraOrgIds, String zuoraVersion) throws ApiException {
        okhttp3.Call localVarCall = renewSubscriptionValidateBeforeCall(subscriptionKey, puTRenewSubscriptionType, acceptEncoding, contentEncoding, authorization, zuoraTrackId, zuoraEntityIds, zuoraOrgIds, zuoraVersion, null);
        Type localVarReturnType = new TypeToken<PUTRenewSubscriptionResponseType>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    private okhttp3.Call renewSubscriptionAsync(String subscriptionKey, PUTRenewSubscriptionType puTRenewSubscriptionType, String acceptEncoding, String contentEncoding, String authorization, String zuoraTrackId, String zuoraEntityIds, String zuoraOrgIds, String zuoraVersion, final ApiCallback<PUTRenewSubscriptionResponseType> _callback) throws ApiException {

        okhttp3.Call localVarCall = renewSubscriptionValidateBeforeCall(subscriptionKey, puTRenewSubscriptionType, acceptEncoding, contentEncoding, authorization, zuoraTrackId, zuoraEntityIds, zuoraOrgIds, zuoraVersion, _callback);
        Type localVarReturnType = new TypeToken<PUTRenewSubscriptionResponseType>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    public class RenewSubscriptionRequestBuilder {
        private final String subscriptionKey;
        private List<String> applicationOrder;
        private Boolean applyCredit;
        private Boolean applyCreditBalance;
        private Boolean collect;
        private String creditMemoReasonCode;
        private LocalDate documentDate;
        private Boolean invoice;
        private Boolean invoiceCollect;
        private LocalDate invoiceTargetDate;
        private LocalDate orderDate;
        private Boolean runBilling;
        private LocalDate targetDate;
        private String acceptEncoding;
        private String contentEncoding;
        private String authorization;
        private String zuoraTrackId;
        private String zuoraEntityIds;
        private String zuoraOrgIds;
        private String zuoraVersion;

        private RenewSubscriptionRequestBuilder(String subscriptionKey) {
            this.subscriptionKey = subscriptionKey;
        }

        /**
         * Set applicationOrder
         * @param applicationOrder The priority order to apply credit memos and/or unapplied payments to an invoice. Possible item values are: &#x60;CreditMemo&#x60;, &#x60;UnappliedPayment&#x60;.  **Note:**   - This field is valid only if the &#x60;applyCredit&#x60; field is set to &#x60;true&#x60;.   - If no value is specified for this field, the default priority order is used, [\\\&quot;CreditMemo\\\&quot;, \\\&quot;UnappliedPayment\\\&quot;], to apply credit memos first and then apply unapplied payments.   - If only one item is specified, only the items of the spedified type are applied to invoices. For example, if the value is &#x60;[\\\&quot;CreditMemo\\\&quot;]&#x60;, only credit memos are used to apply to invoices.  (optional)
         * @return RenewSubscriptionRequestBuilder
         */
        public RenewSubscriptionRequestBuilder applicationOrder(List<String> applicationOrder) {
            this.applicationOrder = applicationOrder;
            return this;
        }
        
        /**
         * Set applyCredit
         * @param applyCredit If the value is true, the credit memo or unapplied payment on the order account will be automatically applied to the invoices generated by this order. The credit memo generated by this order will not be automatically applied to any invoices.  **Note:** This field is only available if you have [Invoice Settlement](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/Invoice_Settlement) enabled. The Invoice Settlement feature is generally available as of Zuora Billing Release 296 (March 2021). This feature includes Unapplied Payments, Credit and Debit Memo, and Invoice Item Settlement. If you want to enable Invoice Settlement, see [Invoice Settlement Enablement and Checklist Guide](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/Invoice_Settlement/Invoice_Settlement_Migration_Checklist_and_Guide) for more information.  (optional)
         * @return RenewSubscriptionRequestBuilder
         */
        public RenewSubscriptionRequestBuilder applyCredit(Boolean applyCredit) {
            this.applyCredit = applyCredit;
            return this;
        }
        
        /**
         * Set applyCreditBalance
         * @param applyCreditBalance Whether to automatically apply a credit balance to an invoice.  If the value is &#x60;true&#x60;, the credit balance is applied to the invoice. If the value is &#x60;false&#x60;, no action is taken.   To view the credit balance adjustment, retrieve the details of the invoice using the Get Invoices method.  Prerequisite: &#x60;invoice&#x60; must be &#x60;true&#x60;.   **Note:**    - If you are using the field &#x60;invoiceCollect&#x60; rather than the field &#x60;invoice&#x60;, the &#x60;invoiceCollect&#x60; value must be &#x60;true&#x60;.   - This field is deprecated if you have the Invoice Settlement feature enabled.  (optional)
         * @return RenewSubscriptionRequestBuilder
         */
        public RenewSubscriptionRequestBuilder applyCreditBalance(Boolean applyCreditBalance) {
            this.applyCreditBalance = applyCreditBalance;
            return this;
        }
        
        /**
         * Set collect
         * @param collect Collects an automatic payment for a subscription. The collection generated in this operation is only for this subscription, not for the entire customer account.  If the value is &#x60;true&#x60;, the automatic payment is collected. If the value is &#x60;false&#x60;, no action is taken.  Prerequisite: The &#x60;invoice&#x60; or &#x60;runBilling&#x60; field must be &#x60;true&#x60;.   **Note**: This field is only available if you set the &#x60;zuora-version&#x60; request header to &#x60;196.0&#x60; or later [available versions](https://developer.zuora.com/api-references/api/overview/#section/API-Versions/Minor-Version).  (optional, default to false)
         * @return RenewSubscriptionRequestBuilder
         */
        public RenewSubscriptionRequestBuilder collect(Boolean collect) {
            this.collect = collect;
            return this;
        }
        
        /**
         * Set creditMemoReasonCode
         * @param creditMemoReasonCode A code identifying the reason for the credit memo transaction that is generated by the request. The value must be an existing reason code. If you do not pass the field or pass the field with empty value, Zuora uses the default reason code. (optional)
         * @return RenewSubscriptionRequestBuilder
         */
        public RenewSubscriptionRequestBuilder creditMemoReasonCode(String creditMemoReasonCode) {
            this.creditMemoReasonCode = creditMemoReasonCode;
            return this;
        }
        
        /**
         * Set documentDate
         * @param documentDate The date of the billing document, in &#x60;yyyy-mm-dd&#x60; format. It represents the invoice date for invoices, credit memo date for credit memos, and debit memo date for debit memos.  - If this field is specified, the specified date is used as the billing document date.  - If this field is not specified, the date specified in the &#x60;targetDate&#x60; is used as the billing document date.  (optional)
         * @return RenewSubscriptionRequestBuilder
         */
        public RenewSubscriptionRequestBuilder documentDate(LocalDate documentDate) {
            this.documentDate = documentDate;
            return this;
        }
        
        /**
         * Set invoice
         * @param invoice **Note:** This field has been replaced by the &#x60;runBilling&#x60; field. The &#x60;invoice&#x60; field is only available for backward compatibility.   Creates an invoice for a subscription. The invoice generated in this operation is only for this subscription, not for the entire customer account.   If the value is &#x60;true&#x60;, an invoice is created. If the value is &#x60;false&#x60;, no action is taken. The default value is &#x60;false&#x60;.    This field is in Zuora REST API version control. Supported minor versions are &#x60;196.0&#x60; and &#x60;207.0&#x60;. To use this field in the method, you must set the zuora-version parameter to the minor version number in the request header.  (optional)
         * @return RenewSubscriptionRequestBuilder
         */
        public RenewSubscriptionRequestBuilder invoice(Boolean invoice) {
            this.invoice = invoice;
            return this;
        }
        
        /**
         * Set invoiceCollect
         * @param invoiceCollect **Note:** This field has been replaced by the &#x60;invoice&#x60; field and the &#x60;collect&#x60; field. &#x60;invoiceCollect&#x60; is available only for backward compatibility.   If this field is set to &#x60;true&#x60;, an invoice is generated and payment collected automatically during the subscription process. If &#x60;false&#x60;, no invoicing or payment takes place. The invoice generated in this operation is only for this subscription, not for the entire customer account.   **Note**: This field is only available if you set the &#x60;zuora-version&#x60; request header to &#x60;186.0&#x60;, &#x60;187.0&#x60;, &#x60;188.0&#x60;, or &#x60;189.0&#x60;.  (optional, default to true)
         * @return RenewSubscriptionRequestBuilder
         */
        public RenewSubscriptionRequestBuilder invoiceCollect(Boolean invoiceCollect) {
            this.invoiceCollect = invoiceCollect;
            return this;
        }
        
        /**
         * Set invoiceTargetDate
         * @param invoiceTargetDate **Note:** This field has been replaced by the &#x60;targetDate&#x60; field. The &#x60;invoiceTargetDate&#x60; field is only available for backward compatibility.   Date through which to calculate charges if an invoice is generated, as yyyy-mm-dd. Default is current date.   This field is in Zuora REST API version control. Supported minor versions are &#x60;207.0&#x60; and earlier [available versions](https://developer.zuora.com/api-references/api/overview/#section/API-Versions/Minor-Version).  (optional)
         * @return RenewSubscriptionRequestBuilder
         */
        public RenewSubscriptionRequestBuilder invoiceTargetDate(LocalDate invoiceTargetDate) {
            this.invoiceTargetDate = invoiceTargetDate;
            return this;
        }
        
        /**
         * Set orderDate
         * @param orderDate The date when the order is signed. If no additinal contractEffectiveDate is provided, this order will use this order date as the contract effective date. This field must be in the &#x60;yyyy-mm-dd&#x60; format. This field is required for Orders customers only, not applicable to Orders Harmonization customers.  (optional)
         * @return RenewSubscriptionRequestBuilder
         */
        public RenewSubscriptionRequestBuilder orderDate(LocalDate orderDate) {
            this.orderDate = orderDate;
            return this;
        }
        
        /**
         * Set runBilling
         * @param runBilling Creates an invoice for a subscription. If you have the Invoice Settlement feature enabled, a credit memo might also be created based on the [invoice and credit memo generation rule](https://knowledgecenter.zuora.com/CB_Billing/Invoice_Settlement/Credit_and_Debit_Memos/Rules_for_Generating_Invoices_and_Credit_Memos).     The billing documents generated in this operation is only for this subscription, not for the entire customer account.   Possible values:  - &#x60;true&#x60;: An invoice is created. If you have the Invoice Settlement feature enabled, a credit memo might also be created.   - &#x60;false&#x60;: No invoice is created.   **Note:** This field is in Zuora REST API version control. Supported minor versions are &#x60;211.0&#x60; or later [available versions](https://developer.zuora.com/api-references/api/overview/#section/API-Versions/Minor-Version). To use this field in the method, you must set the &#x60;zuora-version&#x60; parameter to the minor version number in the request header.  (optional, default to false)
         * @return RenewSubscriptionRequestBuilder
         */
        public RenewSubscriptionRequestBuilder runBilling(Boolean runBilling) {
            this.runBilling = runBilling;
            return this;
        }
        
        /**
         * Set targetDate
         * @param targetDate Date through which to calculate charges if an invoice or a credit memo is generated, as yyyy-mm-dd. Default is current date.   **Note:** The credit memo is only available if you have the Invoice Settlement feature enabled.   This field is in Zuora REST API version control. Supported minor versions are &#x60;211.0&#x60; and later. To use this field in the method, you must set the  &#x60;zuora-version&#x60; parameter to the minor version number in the request header.  (optional)
         * @return RenewSubscriptionRequestBuilder
         */
        public RenewSubscriptionRequestBuilder targetDate(LocalDate targetDate) {
            this.targetDate = targetDate;
            return this;
        }
        
        /**
         * Set acceptEncoding
         * @param acceptEncoding Include the &#x60;Accept-Encoding: gzip&#x60; header to compress responses as a gzipped file. It can significantly reduce the bandwidth required for a response.   If specified, Zuora automatically compresses responses that contain over 1000 bytes of data, and the response contains a &#x60;Content-Encoding&#x60; header with the compression algorithm so that your client can decompress it.  (optional)
         * @return RenewSubscriptionRequestBuilder
         */
        public RenewSubscriptionRequestBuilder acceptEncoding(String acceptEncoding) {
            this.acceptEncoding = acceptEncoding;
            return this;
        }
        
        /**
         * Set contentEncoding
         * @param contentEncoding Include the &#x60;Content-Encoding: gzip&#x60; header to compress a request. With this header specified, you should upload a gzipped file for the request payload instead of sending the JSON payload.  (optional)
         * @return RenewSubscriptionRequestBuilder
         */
        public RenewSubscriptionRequestBuilder contentEncoding(String contentEncoding) {
            this.contentEncoding = contentEncoding;
            return this;
        }
        
        /**
         * Set authorization
         * @param authorization The value is in the &#x60;Bearer {token}&#x60; format where {token} is a valid OAuth token generated by calling [Create an OAuth token](https://developer.zuora.com/api-references/api/operation/createToken).  (optional)
         * @return RenewSubscriptionRequestBuilder
         */
        public RenewSubscriptionRequestBuilder authorization(String authorization) {
            this.authorization = authorization;
            return this;
        }
        
        /**
         * Set zuoraTrackId
         * @param zuoraTrackId A custom identifier for tracing the API call. If you set a value for this header, Zuora returns the same value in the response headers. This header enables you to associate your system process identifiers with Zuora API calls, to assist with troubleshooting in the event of an issue.  The value of this field must use the US-ASCII character set and must not include any of the following characters: colon (&#x60;:&#x60;), semicolon (&#x60;;&#x60;), double quote (&#x60;\&quot;&#x60;), and quote (&#x60;&#39;&#x60;).  (optional)
         * @return RenewSubscriptionRequestBuilder
         */
        public RenewSubscriptionRequestBuilder zuoraTrackId(String zuoraTrackId) {
            this.zuoraTrackId = zuoraTrackId;
            return this;
        }
        
        /**
         * Set zuoraEntityIds
         * @param zuoraEntityIds An entity ID. If you have [Zuora Multi-entity](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Multi-entity) enabled and the OAuth token is valid for more than one entity, you must use this header to specify which entity to perform the operation in. If the OAuth token is only valid for a single entity, or you do not have Zuora Multi-entity enabled, you do not need to set this header.  (optional)
         * @return RenewSubscriptionRequestBuilder
         */
        public RenewSubscriptionRequestBuilder zuoraEntityIds(String zuoraEntityIds) {
            this.zuoraEntityIds = zuoraEntityIds;
            return this;
        }
        
        /**
         * Set zuoraOrgIds
         * @param zuoraOrgIds Comma separated IDs. If you have &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Central_Platform/Multi-Org\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Zuora Multi-Org&lt;/a&gt; enabled,  you can use this header to specify which orgs to perform the operation in. If you do not have Zuora Multi-Org enabled, you should not set this header.  The IDs must be a sub-set of the user&#39;s accessible orgs. If you specify an org that the user does not have access to, the operation fails.  If the header is not set, the operation is performed in scope of the user&#39;s accessible orgs.  (optional)
         * @return RenewSubscriptionRequestBuilder
         */
        public RenewSubscriptionRequestBuilder zuoraOrgIds(String zuoraOrgIds) {
            this.zuoraOrgIds = zuoraOrgIds;
            return this;
        }
        
        /**
         * Set zuoraVersion
         * @param zuoraVersion The minor version of the Zuora REST API.   You only need to set this parameter if you use the following fields: * invoice * collect * runBilling * targetDate   (optional)
         * @return RenewSubscriptionRequestBuilder
         */
        public RenewSubscriptionRequestBuilder zuoraVersion(String zuoraVersion) {
            this.zuoraVersion = zuoraVersion;
            return this;
        }
        
        /**
         * Build call for renewSubscription
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
            PUTRenewSubscriptionType puTRenewSubscriptionType = buildBodyParams();
            return renewSubscriptionCall(subscriptionKey, puTRenewSubscriptionType, acceptEncoding, contentEncoding, authorization, zuoraTrackId, zuoraEntityIds, zuoraOrgIds, zuoraVersion, _callback);
        }

        private PUTRenewSubscriptionType buildBodyParams() {
            PUTRenewSubscriptionType puTRenewSubscriptionType = new PUTRenewSubscriptionType();
            puTRenewSubscriptionType.applicationOrder(this.applicationOrder);
            puTRenewSubscriptionType.applyCredit(this.applyCredit);
            puTRenewSubscriptionType.applyCreditBalance(this.applyCreditBalance);
            puTRenewSubscriptionType.collect(this.collect);
            puTRenewSubscriptionType.creditMemoReasonCode(this.creditMemoReasonCode);
            puTRenewSubscriptionType.documentDate(this.documentDate);
            puTRenewSubscriptionType.invoice(this.invoice);
            puTRenewSubscriptionType.invoiceCollect(this.invoiceCollect);
            puTRenewSubscriptionType.invoiceTargetDate(this.invoiceTargetDate);
            puTRenewSubscriptionType.orderDate(this.orderDate);
            if (this.runBilling != null)
            puTRenewSubscriptionType.runBilling(PUTRenewSubscriptionType.RunBillingEnum.fromValue(this.runBilling));
            puTRenewSubscriptionType.targetDate(this.targetDate);
            return puTRenewSubscriptionType;
        }

        /**
         * Execute renewSubscription request
         * @return PUTRenewSubscriptionResponseType
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td>  </td><td>  * Content-Encoding - This header is returned if you specify the &#x60;Accept-Encoding: gzip&#x60; request header and the response contains over 1000 bytes of data. Note that only the following MIME types support gzipped responses:   - &#x60;application/json&#x60;   - &#x60;application/xml&#x60;   - &#x60;text/html&#x60;   - &#x60;text/csv&#x60;   - &#x60;text/plain&#x60;  <br>  * RateLimit-Limit - The request limit quota for the time window closest to exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Remaining - The number of requests remaining in the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Reset - The number of seconds until the quota resets for the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Zuora-Request-Id - The Zuora internal identifier of the API call. You cannot control the value of this header.  <br>  * Zuora-Track-Id - A custom identifier for tracing the API call. If you specified a tracing identifier in the request headers, Zuora returns the same tracing identifier. Otherwise, Zuora does not set this header.  <br>  </td></tr>
         </table>
         */
        public PUTRenewSubscriptionResponseType execute() throws ApiException {
            PUTRenewSubscriptionType puTRenewSubscriptionType = buildBodyParams();
            ApiResponse<PUTRenewSubscriptionResponseType> localVarResp = renewSubscriptionWithHttpInfo(subscriptionKey, puTRenewSubscriptionType, acceptEncoding, contentEncoding, authorization, zuoraTrackId, zuoraEntityIds, zuoraOrgIds, zuoraVersion);
            return localVarResp.getResponseBody();
        }

        /**
         * Execute renewSubscription request with HTTP info returned
         * @return ApiResponse&lt;PUTRenewSubscriptionResponseType&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td>  </td><td>  * Content-Encoding - This header is returned if you specify the &#x60;Accept-Encoding: gzip&#x60; request header and the response contains over 1000 bytes of data. Note that only the following MIME types support gzipped responses:   - &#x60;application/json&#x60;   - &#x60;application/xml&#x60;   - &#x60;text/html&#x60;   - &#x60;text/csv&#x60;   - &#x60;text/plain&#x60;  <br>  * RateLimit-Limit - The request limit quota for the time window closest to exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Remaining - The number of requests remaining in the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Reset - The number of seconds until the quota resets for the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Zuora-Request-Id - The Zuora internal identifier of the API call. You cannot control the value of this header.  <br>  * Zuora-Track-Id - A custom identifier for tracing the API call. If you specified a tracing identifier in the request headers, Zuora returns the same tracing identifier. Otherwise, Zuora does not set this header.  <br>  </td></tr>
         </table>
         */
        public ApiResponse<PUTRenewSubscriptionResponseType> executeWithHttpInfo() throws ApiException {
            PUTRenewSubscriptionType puTRenewSubscriptionType = buildBodyParams();
            return renewSubscriptionWithHttpInfo(subscriptionKey, puTRenewSubscriptionType, acceptEncoding, contentEncoding, authorization, zuoraTrackId, zuoraEntityIds, zuoraOrgIds, zuoraVersion);
        }

        /**
         * Execute renewSubscription request (asynchronously)
         * @param _callback The callback to be executed when the API call finishes
         * @return The request call
         * @throws ApiException If fail to process the API call, e.g. serializing the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td>  </td><td>  * Content-Encoding - This header is returned if you specify the &#x60;Accept-Encoding: gzip&#x60; request header and the response contains over 1000 bytes of data. Note that only the following MIME types support gzipped responses:   - &#x60;application/json&#x60;   - &#x60;application/xml&#x60;   - &#x60;text/html&#x60;   - &#x60;text/csv&#x60;   - &#x60;text/plain&#x60;  <br>  * RateLimit-Limit - The request limit quota for the time window closest to exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Remaining - The number of requests remaining in the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Reset - The number of seconds until the quota resets for the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Zuora-Request-Id - The Zuora internal identifier of the API call. You cannot control the value of this header.  <br>  * Zuora-Track-Id - A custom identifier for tracing the API call. If you specified a tracing identifier in the request headers, Zuora returns the same tracing identifier. Otherwise, Zuora does not set this header.  <br>  </td></tr>
         </table>
         */
        public okhttp3.Call executeAsync(final ApiCallback<PUTRenewSubscriptionResponseType> _callback) throws ApiException {
            PUTRenewSubscriptionType puTRenewSubscriptionType = buildBodyParams();
            return renewSubscriptionAsync(subscriptionKey, puTRenewSubscriptionType, acceptEncoding, contentEncoding, authorization, zuoraTrackId, zuoraEntityIds, zuoraOrgIds, zuoraVersion, _callback);
        }
    }

    /**
     * Renew a subscription
     * Renews a termed subscription using existing renewal terms.  When you renew a subscription, the current subscription term is extended by creating a new term.   If any charge in your subscription has the billing period set as &#x60;SubscriptionTerm&#x60;， a new charge segment is generated for the new term.   **Note**: If you have the Invoice Settlement feature enabled, it is best practice to set the &#x60;zuora-version&#x60; parameter to &#x60;211.0&#x60; or later [available versions](https://developer.zuora.com/api-references/api/overview/#section/API-Versions/Minor-Version). Otherwise, an error occurs. 
     * @param subscriptionKey Subscription number or ID (required)
     * @param puTRenewSubscriptionType  (required)
     * @return RenewSubscriptionRequestBuilder
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td>  </td><td>  * Content-Encoding - This header is returned if you specify the &#x60;Accept-Encoding: gzip&#x60; request header and the response contains over 1000 bytes of data. Note that only the following MIME types support gzipped responses:   - &#x60;application/json&#x60;   - &#x60;application/xml&#x60;   - &#x60;text/html&#x60;   - &#x60;text/csv&#x60;   - &#x60;text/plain&#x60;  <br>  * RateLimit-Limit - The request limit quota for the time window closest to exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Remaining - The number of requests remaining in the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Reset - The number of seconds until the quota resets for the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Zuora-Request-Id - The Zuora internal identifier of the API call. You cannot control the value of this header.  <br>  * Zuora-Track-Id - A custom identifier for tracing the API call. If you specified a tracing identifier in the request headers, Zuora returns the same tracing identifier. Otherwise, Zuora does not set this header.  <br>  </td></tr>
     </table>
     */
    public RenewSubscriptionRequestBuilder renewSubscription(String subscriptionKey) throws IllegalArgumentException {
        if (subscriptionKey == null) throw new IllegalArgumentException("\"subscriptionKey\" is required but got null");
            

        return new RenewSubscriptionRequestBuilder(subscriptionKey);
    }
    private okhttp3.Call resumeSubscriptionCall(String subscriptionKey, PUTSubscriptionResumeType puTSubscriptionResumeType, String acceptEncoding, String contentEncoding, String authorization, String zuoraTrackId, String zuoraEntityIds, String zuoraOrgIds, String zuoraVersion, final ApiCallback _callback) throws ApiException {
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

        Object localVarPostBody = puTSubscriptionResumeType;

        // create path and map variables
        String localVarPath = "/v1/subscriptions/{subscription-key}/resume"
            .replace("{" + "subscription-key" + "}", localVarApiClient.escapeString(subscriptionKey.toString()));

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
    private okhttp3.Call resumeSubscriptionValidateBeforeCall(String subscriptionKey, PUTSubscriptionResumeType puTSubscriptionResumeType, String acceptEncoding, String contentEncoding, String authorization, String zuoraTrackId, String zuoraEntityIds, String zuoraOrgIds, String zuoraVersion, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'subscriptionKey' is set
        if (subscriptionKey == null) {
            throw new ApiException("Missing the required parameter 'subscriptionKey' when calling resumeSubscription(Async)");
        }

        // verify the required parameter 'puTSubscriptionResumeType' is set
        if (puTSubscriptionResumeType == null) {
            throw new ApiException("Missing the required parameter 'puTSubscriptionResumeType' when calling resumeSubscription(Async)");
        }

        return resumeSubscriptionCall(subscriptionKey, puTSubscriptionResumeType, acceptEncoding, contentEncoding, authorization, zuoraTrackId, zuoraEntityIds, zuoraOrgIds, zuoraVersion, _callback);

    }


    private ApiResponse<PUTSubscriptionResumeResponseType> resumeSubscriptionWithHttpInfo(String subscriptionKey, PUTSubscriptionResumeType puTSubscriptionResumeType, String acceptEncoding, String contentEncoding, String authorization, String zuoraTrackId, String zuoraEntityIds, String zuoraOrgIds, String zuoraVersion) throws ApiException {
        okhttp3.Call localVarCall = resumeSubscriptionValidateBeforeCall(subscriptionKey, puTSubscriptionResumeType, acceptEncoding, contentEncoding, authorization, zuoraTrackId, zuoraEntityIds, zuoraOrgIds, zuoraVersion, null);
        Type localVarReturnType = new TypeToken<PUTSubscriptionResumeResponseType>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    private okhttp3.Call resumeSubscriptionAsync(String subscriptionKey, PUTSubscriptionResumeType puTSubscriptionResumeType, String acceptEncoding, String contentEncoding, String authorization, String zuoraTrackId, String zuoraEntityIds, String zuoraOrgIds, String zuoraVersion, final ApiCallback<PUTSubscriptionResumeResponseType> _callback) throws ApiException {

        okhttp3.Call localVarCall = resumeSubscriptionValidateBeforeCall(subscriptionKey, puTSubscriptionResumeType, acceptEncoding, contentEncoding, authorization, zuoraTrackId, zuoraEntityIds, zuoraOrgIds, zuoraVersion, _callback);
        Type localVarReturnType = new TypeToken<PUTSubscriptionResumeResponseType>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    public class ResumeSubscriptionRequestBuilder {
        private final String resumePolicy;
        private final String subscriptionKey;
        private List<String> applicationOrder;
        private Boolean applyCredit;
        private Boolean applyCreditBalance;
        private LocalDate bookingDate;
        private Boolean collect;
        private LocalDate contractEffectiveDate;
        private String creditMemoReasonCode;
        private LocalDate documentDate;
        private Boolean extendsTerm;
        private Boolean invoice;
        private Boolean invoiceCollect;
        private LocalDate invoiceTargetDate;
        private LocalDate orderDate;
        private String resumePeriods;
        private String resumePeriodsType;
        private LocalDate resumeSpecificDate;
        private Boolean runBilling;
        private LocalDate targetDate;
        private String acceptEncoding;
        private String contentEncoding;
        private String authorization;
        private String zuoraTrackId;
        private String zuoraEntityIds;
        private String zuoraOrgIds;
        private String zuoraVersion;

        private ResumeSubscriptionRequestBuilder(String resumePolicy, String subscriptionKey) {
            this.resumePolicy = resumePolicy;
            this.subscriptionKey = subscriptionKey;
        }

        /**
         * Set applicationOrder
         * @param applicationOrder The priority order to apply credit memos and/or unapplied payments to an invoice. Possible item values are: &#x60;CreditMemo&#x60;, &#x60;UnappliedPayment&#x60;.  **Note:**   - This field is valid only if the &#x60;applyCredit&#x60; field is set to &#x60;true&#x60;.   - If no value is specified for this field, the default priority order is used, [\\\&quot;CreditMemo\\\&quot;, \\\&quot;UnappliedPayment\\\&quot;], to apply credit memos first and then apply unapplied payments.   - If only one item is specified, only the items of the spedified type are applied to invoices. For example, if the value is &#x60;[\\\&quot;CreditMemo\\\&quot;]&#x60;, only credit memos are used to apply to invoices.  (optional)
         * @return ResumeSubscriptionRequestBuilder
         */
        public ResumeSubscriptionRequestBuilder applicationOrder(List<String> applicationOrder) {
            this.applicationOrder = applicationOrder;
            return this;
        }
        
        /**
         * Set applyCredit
         * @param applyCredit If the value is true, the credit memo or unapplied payment on the order account will be automatically applied to the invoices generated by this order. The credit memo generated by this order will not be automatically applied to any invoices.  **Note:** This field is only available if you have [Invoice Settlement](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/Invoice_Settlement) enabled. The Invoice Settlement feature is generally available as of Zuora Billing Release 296 (March 2021). This feature includes Unapplied Payments, Credit and Debit Memo, and Invoice Item Settlement. If you want to enable Invoice Settlement, see [Invoice Settlement Enablement and Checklist Guide](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/Invoice_Settlement/Invoice_Settlement_Migration_Checklist_and_Guide) for more information.  (optional)
         * @return ResumeSubscriptionRequestBuilder
         */
        public ResumeSubscriptionRequestBuilder applyCredit(Boolean applyCredit) {
            this.applyCredit = applyCredit;
            return this;
        }
        
        /**
         * Set applyCreditBalance
         * @param applyCreditBalance Whether to automatically apply a credit balance to an invoice.  If the value is &#x60;true&#x60;, the credit balance is applied to the invoice. If the value is &#x60;false&#x60;, no action is taken.   To view the credit balance adjustment, retrieve the details of the invoice using the Get Invoices method.  Prerequisite: &#x60;invoice&#x60; must be &#x60;true&#x60;.   **Note:**    - If you are using the field &#x60;invoiceCollect&#x60; rather than the field &#x60;invoice&#x60;, the &#x60;invoiceCollect&#x60; value must be &#x60;true&#x60;.   - This field is deprecated if you have the Invoice Settlement feature enabled.  (optional)
         * @return ResumeSubscriptionRequestBuilder
         */
        public ResumeSubscriptionRequestBuilder applyCreditBalance(Boolean applyCreditBalance) {
            this.applyCreditBalance = applyCreditBalance;
            return this;
        }
        
        /**
         * Set bookingDate
         * @param bookingDate The booking date that you want to set for the amendment contract when you resume the subscription. If &#x60;extendsTerm&#x60; is &#x60;true&#x60;, which means you also extend the term, then this field is also the booking date for the Terms and Conditions amendment contract.  This field must be in the &#x60;yyyy-mm-dd&#x60; format. The default value of this field is the current date when you make the API call.   (optional)
         * @return ResumeSubscriptionRequestBuilder
         */
        public ResumeSubscriptionRequestBuilder bookingDate(LocalDate bookingDate) {
            this.bookingDate = bookingDate;
            return this;
        }
        
        /**
         * Set collect
         * @param collect Collects an automatic payment for a subscription. The collection generated in this operation is only for this subscription, not for the entire customer account.  If the value is &#x60;true&#x60;, the automatic payment is collected. If the value is &#x60;false&#x60;, no action is taken.  Prerequisite: The &#x60;invoice&#x60; or &#x60;runBilling&#x60; field must be &#x60;true&#x60;.   **Note**: This field is only available if you set the &#x60;zuora-version&#x60; request header to &#x60;196.0&#x60; or later [available versions](https://developer.zuora.com/api-references/api/overview/#section/API-Versions/Minor-Version).  (optional, default to false)
         * @return ResumeSubscriptionRequestBuilder
         */
        public ResumeSubscriptionRequestBuilder collect(Boolean collect) {
            this.collect = collect;
            return this;
        }
        
        /**
         * Set contractEffectiveDate
         * @param contractEffectiveDate The date when the customer notifies you that they want to resume their subscription.  (optional)
         * @return ResumeSubscriptionRequestBuilder
         */
        public ResumeSubscriptionRequestBuilder contractEffectiveDate(LocalDate contractEffectiveDate) {
            this.contractEffectiveDate = contractEffectiveDate;
            return this;
        }
        
        /**
         * Set creditMemoReasonCode
         * @param creditMemoReasonCode A code identifying the reason for the credit memo transaction that is generated by the request. The value must be an existing reason code. If you do not pass the field or pass the field with empty value, Zuora uses the default reason code. (optional)
         * @return ResumeSubscriptionRequestBuilder
         */
        public ResumeSubscriptionRequestBuilder creditMemoReasonCode(String creditMemoReasonCode) {
            this.creditMemoReasonCode = creditMemoReasonCode;
            return this;
        }
        
        /**
         * Set documentDate
         * @param documentDate The date of the billing document, in &#x60;yyyy-mm-dd&#x60; format. It represents the invoice date for invoices, credit memo date for credit memos, and debit memo date for debit memos.  - If this field is specified, the specified date is used as the billing document date.  - If this field is not specified, the date specified in the &#x60;targetDate&#x60; is used as the billing document date.  (optional)
         * @return ResumeSubscriptionRequestBuilder
         */
        public ResumeSubscriptionRequestBuilder documentDate(LocalDate documentDate) {
            this.documentDate = documentDate;
            return this;
        }
        
        /**
         * Set extendsTerm
         * @param extendsTerm Whether to extend the subscription term by the length of time the suspension is in effect.  Values: &#x60;true&#x60;, &#x60;false&#x60;.  (optional)
         * @return ResumeSubscriptionRequestBuilder
         */
        public ResumeSubscriptionRequestBuilder extendsTerm(Boolean extendsTerm) {
            this.extendsTerm = extendsTerm;
            return this;
        }
        
        /**
         * Set invoice
         * @param invoice **Note:** This field has been replaced by the &#x60;runBilling&#x60; field. The &#x60;invoice&#x60; field is only available for backward compatibility.   Creates an invoice for a subscription. The invoice generated in this operation is only for this subscription, not for the entire customer account.   If the value is &#x60;true&#x60;, an invoice is created. If the value is &#x60;false&#x60;, no action is taken. The default value is &#x60;false&#x60;.   This field is in Zuora REST API version control. Supported minor versions are &#x60;196.0&#x60; and &#x60;207.0&#x60;. To use this field in the method, you must set the &#x60;zuora-version&#x60; parameter to the minor version number in the request header.  (optional)
         * @return ResumeSubscriptionRequestBuilder
         */
        public ResumeSubscriptionRequestBuilder invoice(Boolean invoice) {
            this.invoice = invoice;
            return this;
        }
        
        /**
         * Set invoiceCollect
         * @param invoiceCollect **Note:** This field has been replaced by the &#x60;invoice&#x60; field and the &#x60;collect&#x60; field. &#x60;invoiceCollect&#x60; is available only for backward compatibility.   If &#x60;true&#x60;, an invoice is generated and payment collected automatically during the subscription process. If &#x60;false&#x60;, no invoicing or payment takes place.  The invoice generated in this operation is only for this subscription, not for the entire customer account.   **Note**: This field is only available if you set the &#x60;zuora-version&#x60; request header to &#x60;186.0&#x60;, &#x60;187.0&#x60;, &#x60;188.0&#x60;, or &#x60;189.0&#x60;.  (optional, default to false)
         * @return ResumeSubscriptionRequestBuilder
         */
        public ResumeSubscriptionRequestBuilder invoiceCollect(Boolean invoiceCollect) {
            this.invoiceCollect = invoiceCollect;
            return this;
        }
        
        /**
         * Set invoiceTargetDate
         * @param invoiceTargetDate **Note:** This field has been replaced by the &#x60;targetDate&#x60; field. The &#x60;invoiceTargetDate&#x60; field is only available for backward compatibility.   Date through which to calculate charges if an invoice is generated, as yyyy-mm-dd. Default is current date.   This field is in Zuora REST API version control. Supported minor versions are &#x60;207.0&#x60; and earlier [available versions](https://developer.zuora.com/api-references/api/overview/#section/API-Versions/Minor-Version).  (optional)
         * @return ResumeSubscriptionRequestBuilder
         */
        public ResumeSubscriptionRequestBuilder invoiceTargetDate(LocalDate invoiceTargetDate) {
            this.invoiceTargetDate = invoiceTargetDate;
            return this;
        }
        
        /**
         * Set orderDate
         * @param orderDate The date when the order is signed. If no additinal contractEffectiveDate is provided, this order will use this order date as the contract effective date. This field must be in the &#x60;yyyy-mm-dd&#x60; format. This field is required for Orders customers only, not applicable to Orders Harmonization customers.  (optional)
         * @return ResumeSubscriptionRequestBuilder
         */
        public ResumeSubscriptionRequestBuilder orderDate(LocalDate orderDate) {
            this.orderDate = orderDate;
            return this;
        }
        
        /**
         * Set resumePeriods
         * @param resumePeriods The length of the period used to specify when the subscription is resumed. The subscription resumption takes effect after a specified period based on the suspend date or today&#39;s date. You must use this field together with the &#x60;resumePeriodsType&#x60; field to specify the period.  **Note:** This field is only applicable when the &#x60;suspendPolicy&#x60; field is set to &#x60;FixedPeriodsFromToday&#x60; or &#x60;FixedPeriodsFromSuspendDate&#x60;.  (optional)
         * @return ResumeSubscriptionRequestBuilder
         */
        public ResumeSubscriptionRequestBuilder resumePeriods(String resumePeriods) {
            this.resumePeriods = resumePeriods;
            return this;
        }
        
        /**
         * Set resumePeriodsType
         * @param resumePeriodsType The period type used to define when the subscription resumption takes effect. The subscription resumption takes effect after a specified period based on the suspend date or today&#39;s date. You must use this field together with the &#x60;resumePeriods&#x60; field to specify the period.  Values: &#x60;Day&#x60;, &#x60;Week&#x60;, &#x60;Month&#x60;, &#x60;Year&#x60;  **Note:** This field is only applicable when the &#x60;suspendPolicy&#x60; field is set to &#x60;FixedPeriodsFromToday&#x60; or &#x60;FixedPeriodsFromSuspendDate&#x60;.  (optional)
         * @return ResumeSubscriptionRequestBuilder
         */
        public ResumeSubscriptionRequestBuilder resumePeriodsType(String resumePeriodsType) {
            this.resumePeriodsType = resumePeriodsType;
            return this;
        }
        
        /**
         * Set resumeSpecificDate
         * @param resumeSpecificDate A specific date when the subscription resumption takes effect, in the format yyyy-mm-dd.  **Note:** This field is only applicable only when the &#x60;resumePolicy&#x60; field is set to &#x60;SpecificDate&#x60;.  The value should not be earlier than the subscription suspension date.  (optional)
         * @return ResumeSubscriptionRequestBuilder
         */
        public ResumeSubscriptionRequestBuilder resumeSpecificDate(LocalDate resumeSpecificDate) {
            this.resumeSpecificDate = resumeSpecificDate;
            return this;
        }
        
        /**
         * Set runBilling
         * @param runBilling Creates an invoice for a subscription. If you have the Invoice Settlement feature enabled, a credit memo might also be created based on the [invoice and credit memo generation rule](https://knowledgecenter.zuora.com/CB_Billing/Invoice_Settlement/Credit_and_Debit_Memos/Rules_for_Generating_Invoices_and_Credit_Memos).     The billing documents generated in this operation is only for this subscription, not for the entire customer account.   Possible values:  - &#x60;true&#x60;: An invoice is created. If you have the Invoice Settlement feature enabled, a credit memo might also be created.   - &#x60;false&#x60;: No invoice is created.   **Note:** This field is in Zuora REST API version control. Supported minor versions are &#x60;211.0&#x60; or later [available versions](https://developer.zuora.com/api-references/api/overview/#section/API-Versions/Minor-Version). To use this field in the method, you must set the &#x60;zuora-version&#x60; parameter to the minor version number in the request header.  (optional, default to false)
         * @return ResumeSubscriptionRequestBuilder
         */
        public ResumeSubscriptionRequestBuilder runBilling(Boolean runBilling) {
            this.runBilling = runBilling;
            return this;
        }
        
        /**
         * Set targetDate
         * @param targetDate Date through which to calculate charges if an invoice or a credit memo is generated, as yyyy-mm-dd. Default is current date.   **Note:** The credit memo is only available if you have the Invoice Settlement feature enabled.   This field is in Zuora REST API version control. Supported minor versions are &#x60;211.0&#x60; and later. To use this field in the method, you must set the  &#x60;zuora-version&#x60; parameter to the minor version number in the request header.  (optional)
         * @return ResumeSubscriptionRequestBuilder
         */
        public ResumeSubscriptionRequestBuilder targetDate(LocalDate targetDate) {
            this.targetDate = targetDate;
            return this;
        }
        
        /**
         * Set acceptEncoding
         * @param acceptEncoding Include the &#x60;Accept-Encoding: gzip&#x60; header to compress responses as a gzipped file. It can significantly reduce the bandwidth required for a response.   If specified, Zuora automatically compresses responses that contain over 1000 bytes of data, and the response contains a &#x60;Content-Encoding&#x60; header with the compression algorithm so that your client can decompress it.  (optional)
         * @return ResumeSubscriptionRequestBuilder
         */
        public ResumeSubscriptionRequestBuilder acceptEncoding(String acceptEncoding) {
            this.acceptEncoding = acceptEncoding;
            return this;
        }
        
        /**
         * Set contentEncoding
         * @param contentEncoding Include the &#x60;Content-Encoding: gzip&#x60; header to compress a request. With this header specified, you should upload a gzipped file for the request payload instead of sending the JSON payload.  (optional)
         * @return ResumeSubscriptionRequestBuilder
         */
        public ResumeSubscriptionRequestBuilder contentEncoding(String contentEncoding) {
            this.contentEncoding = contentEncoding;
            return this;
        }
        
        /**
         * Set authorization
         * @param authorization The value is in the &#x60;Bearer {token}&#x60; format where {token} is a valid OAuth token generated by calling [Create an OAuth token](https://developer.zuora.com/api-references/api/operation/createToken).  (optional)
         * @return ResumeSubscriptionRequestBuilder
         */
        public ResumeSubscriptionRequestBuilder authorization(String authorization) {
            this.authorization = authorization;
            return this;
        }
        
        /**
         * Set zuoraTrackId
         * @param zuoraTrackId A custom identifier for tracing the API call. If you set a value for this header, Zuora returns the same value in the response headers. This header enables you to associate your system process identifiers with Zuora API calls, to assist with troubleshooting in the event of an issue.  The value of this field must use the US-ASCII character set and must not include any of the following characters: colon (&#x60;:&#x60;), semicolon (&#x60;;&#x60;), double quote (&#x60;\&quot;&#x60;), and quote (&#x60;&#39;&#x60;).  (optional)
         * @return ResumeSubscriptionRequestBuilder
         */
        public ResumeSubscriptionRequestBuilder zuoraTrackId(String zuoraTrackId) {
            this.zuoraTrackId = zuoraTrackId;
            return this;
        }
        
        /**
         * Set zuoraEntityIds
         * @param zuoraEntityIds An entity ID. If you have [Zuora Multi-entity](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Multi-entity) enabled and the OAuth token is valid for more than one entity, you must use this header to specify which entity to perform the operation in. If the OAuth token is only valid for a single entity, or you do not have Zuora Multi-entity enabled, you do not need to set this header.  (optional)
         * @return ResumeSubscriptionRequestBuilder
         */
        public ResumeSubscriptionRequestBuilder zuoraEntityIds(String zuoraEntityIds) {
            this.zuoraEntityIds = zuoraEntityIds;
            return this;
        }
        
        /**
         * Set zuoraOrgIds
         * @param zuoraOrgIds Comma separated IDs. If you have &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Central_Platform/Multi-Org\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Zuora Multi-Org&lt;/a&gt; enabled,  you can use this header to specify which orgs to perform the operation in. If you do not have Zuora Multi-Org enabled, you should not set this header.  The IDs must be a sub-set of the user&#39;s accessible orgs. If you specify an org that the user does not have access to, the operation fails.  If the header is not set, the operation is performed in scope of the user&#39;s accessible orgs.  (optional)
         * @return ResumeSubscriptionRequestBuilder
         */
        public ResumeSubscriptionRequestBuilder zuoraOrgIds(String zuoraOrgIds) {
            this.zuoraOrgIds = zuoraOrgIds;
            return this;
        }
        
        /**
         * Set zuoraVersion
         * @param zuoraVersion The minor version of the Zuora REST API.   You only need to set this parameter if you use the following fields: * invoice * collect * runBilling * targetDate  (optional)
         * @return ResumeSubscriptionRequestBuilder
         */
        public ResumeSubscriptionRequestBuilder zuoraVersion(String zuoraVersion) {
            this.zuoraVersion = zuoraVersion;
            return this;
        }
        
        /**
         * Build call for resumeSubscription
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
            PUTSubscriptionResumeType puTSubscriptionResumeType = buildBodyParams();
            return resumeSubscriptionCall(subscriptionKey, puTSubscriptionResumeType, acceptEncoding, contentEncoding, authorization, zuoraTrackId, zuoraEntityIds, zuoraOrgIds, zuoraVersion, _callback);
        }

        private PUTSubscriptionResumeType buildBodyParams() {
            PUTSubscriptionResumeType puTSubscriptionResumeType = new PUTSubscriptionResumeType();
            puTSubscriptionResumeType.applicationOrder(this.applicationOrder);
            puTSubscriptionResumeType.applyCredit(this.applyCredit);
            puTSubscriptionResumeType.applyCreditBalance(this.applyCreditBalance);
            puTSubscriptionResumeType.bookingDate(this.bookingDate);
            puTSubscriptionResumeType.collect(this.collect);
            puTSubscriptionResumeType.contractEffectiveDate(this.contractEffectiveDate);
            puTSubscriptionResumeType.creditMemoReasonCode(this.creditMemoReasonCode);
            puTSubscriptionResumeType.documentDate(this.documentDate);
            puTSubscriptionResumeType.extendsTerm(this.extendsTerm);
            puTSubscriptionResumeType.invoice(this.invoice);
            puTSubscriptionResumeType.invoiceCollect(this.invoiceCollect);
            puTSubscriptionResumeType.invoiceTargetDate(this.invoiceTargetDate);
            puTSubscriptionResumeType.orderDate(this.orderDate);
            puTSubscriptionResumeType.resumePeriods(this.resumePeriods);
            puTSubscriptionResumeType.resumePeriodsType(this.resumePeriodsType);
            puTSubscriptionResumeType.resumePolicy(this.resumePolicy);
            puTSubscriptionResumeType.resumeSpecificDate(this.resumeSpecificDate);
            if (this.runBilling != null)
            puTSubscriptionResumeType.runBilling(PUTSubscriptionResumeType.RunBillingEnum.fromValue(this.runBilling));
            puTSubscriptionResumeType.targetDate(this.targetDate);
            return puTSubscriptionResumeType;
        }

        /**
         * Execute resumeSubscription request
         * @return PUTSubscriptionResumeResponseType
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td>  </td><td>  * Content-Encoding - This header is returned if you specify the &#x60;Accept-Encoding: gzip&#x60; request header and the response contains over 1000 bytes of data. Note that only the following MIME types support gzipped responses:   - &#x60;application/json&#x60;   - &#x60;application/xml&#x60;   - &#x60;text/html&#x60;   - &#x60;text/csv&#x60;   - &#x60;text/plain&#x60;  <br>  * RateLimit-Limit - The request limit quota for the time window closest to exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Remaining - The number of requests remaining in the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Reset - The number of seconds until the quota resets for the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Zuora-Request-Id - The Zuora internal identifier of the API call. You cannot control the value of this header.  <br>  * Zuora-Track-Id - A custom identifier for tracing the API call. If you specified a tracing identifier in the request headers, Zuora returns the same tracing identifier. Otherwise, Zuora does not set this header.  <br>  </td></tr>
         </table>
         */
        public PUTSubscriptionResumeResponseType execute() throws ApiException {
            PUTSubscriptionResumeType puTSubscriptionResumeType = buildBodyParams();
            ApiResponse<PUTSubscriptionResumeResponseType> localVarResp = resumeSubscriptionWithHttpInfo(subscriptionKey, puTSubscriptionResumeType, acceptEncoding, contentEncoding, authorization, zuoraTrackId, zuoraEntityIds, zuoraOrgIds, zuoraVersion);
            return localVarResp.getResponseBody();
        }

        /**
         * Execute resumeSubscription request with HTTP info returned
         * @return ApiResponse&lt;PUTSubscriptionResumeResponseType&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td>  </td><td>  * Content-Encoding - This header is returned if you specify the &#x60;Accept-Encoding: gzip&#x60; request header and the response contains over 1000 bytes of data. Note that only the following MIME types support gzipped responses:   - &#x60;application/json&#x60;   - &#x60;application/xml&#x60;   - &#x60;text/html&#x60;   - &#x60;text/csv&#x60;   - &#x60;text/plain&#x60;  <br>  * RateLimit-Limit - The request limit quota for the time window closest to exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Remaining - The number of requests remaining in the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Reset - The number of seconds until the quota resets for the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Zuora-Request-Id - The Zuora internal identifier of the API call. You cannot control the value of this header.  <br>  * Zuora-Track-Id - A custom identifier for tracing the API call. If you specified a tracing identifier in the request headers, Zuora returns the same tracing identifier. Otherwise, Zuora does not set this header.  <br>  </td></tr>
         </table>
         */
        public ApiResponse<PUTSubscriptionResumeResponseType> executeWithHttpInfo() throws ApiException {
            PUTSubscriptionResumeType puTSubscriptionResumeType = buildBodyParams();
            return resumeSubscriptionWithHttpInfo(subscriptionKey, puTSubscriptionResumeType, acceptEncoding, contentEncoding, authorization, zuoraTrackId, zuoraEntityIds, zuoraOrgIds, zuoraVersion);
        }

        /**
         * Execute resumeSubscription request (asynchronously)
         * @param _callback The callback to be executed when the API call finishes
         * @return The request call
         * @throws ApiException If fail to process the API call, e.g. serializing the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td>  </td><td>  * Content-Encoding - This header is returned if you specify the &#x60;Accept-Encoding: gzip&#x60; request header and the response contains over 1000 bytes of data. Note that only the following MIME types support gzipped responses:   - &#x60;application/json&#x60;   - &#x60;application/xml&#x60;   - &#x60;text/html&#x60;   - &#x60;text/csv&#x60;   - &#x60;text/plain&#x60;  <br>  * RateLimit-Limit - The request limit quota for the time window closest to exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Remaining - The number of requests remaining in the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Reset - The number of seconds until the quota resets for the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Zuora-Request-Id - The Zuora internal identifier of the API call. You cannot control the value of this header.  <br>  * Zuora-Track-Id - A custom identifier for tracing the API call. If you specified a tracing identifier in the request headers, Zuora returns the same tracing identifier. Otherwise, Zuora does not set this header.  <br>  </td></tr>
         </table>
         */
        public okhttp3.Call executeAsync(final ApiCallback<PUTSubscriptionResumeResponseType> _callback) throws ApiException {
            PUTSubscriptionResumeType puTSubscriptionResumeType = buildBodyParams();
            return resumeSubscriptionAsync(subscriptionKey, puTSubscriptionResumeType, acceptEncoding, contentEncoding, authorization, zuoraTrackId, zuoraEntityIds, zuoraOrgIds, zuoraVersion, _callback);
        }
    }

    /**
     * Resume a subscription
     * This REST API reference describes how to resume a suspended subscription.    **Note**: If you have the Invoice Settlement feature enabled, it is best practice to set the &#x60;zuora-version&#x60; parameter to &#x60;211.0&#x60; or later [available versions](https://developer.zuora.com/api-references/api/overview/#section/API-Versions/Minor-Version). Otherwise, an error occurs. 
     * @param subscriptionKey Subscription number or ID. Subscription status must be Suspended. (required)
     * @param puTSubscriptionResumeType  (required)
     * @return ResumeSubscriptionRequestBuilder
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td>  </td><td>  * Content-Encoding - This header is returned if you specify the &#x60;Accept-Encoding: gzip&#x60; request header and the response contains over 1000 bytes of data. Note that only the following MIME types support gzipped responses:   - &#x60;application/json&#x60;   - &#x60;application/xml&#x60;   - &#x60;text/html&#x60;   - &#x60;text/csv&#x60;   - &#x60;text/plain&#x60;  <br>  * RateLimit-Limit - The request limit quota for the time window closest to exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Remaining - The number of requests remaining in the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Reset - The number of seconds until the quota resets for the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Zuora-Request-Id - The Zuora internal identifier of the API call. You cannot control the value of this header.  <br>  * Zuora-Track-Id - A custom identifier for tracing the API call. If you specified a tracing identifier in the request headers, Zuora returns the same tracing identifier. Otherwise, Zuora does not set this header.  <br>  </td></tr>
     </table>
     */
    public ResumeSubscriptionRequestBuilder resumeSubscription(String resumePolicy, String subscriptionKey) throws IllegalArgumentException {
        if (resumePolicy == null) throw new IllegalArgumentException("\"resumePolicy\" is required but got null");
            

        if (subscriptionKey == null) throw new IllegalArgumentException("\"subscriptionKey\" is required but got null");
            

        return new ResumeSubscriptionRequestBuilder(resumePolicy, subscriptionKey);
    }
    private okhttp3.Call subscriptionCall(POSTSubscriptionType poSTSubscriptionType, String idempotencyKey, String acceptEncoding, String contentEncoding, String authorization, String zuoraTrackId, String zuoraEntityIds, String zuoraOrgIds, String zuoraVersion, final ApiCallback _callback) throws ApiException {
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

        Object localVarPostBody = poSTSubscriptionType;

        // create path and map variables
        String localVarPath = "/v1/subscriptions";

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
    private okhttp3.Call subscriptionValidateBeforeCall(POSTSubscriptionType poSTSubscriptionType, String idempotencyKey, String acceptEncoding, String contentEncoding, String authorization, String zuoraTrackId, String zuoraEntityIds, String zuoraOrgIds, String zuoraVersion, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'poSTSubscriptionType' is set
        if (poSTSubscriptionType == null) {
            throw new ApiException("Missing the required parameter 'poSTSubscriptionType' when calling subscription(Async)");
        }

        return subscriptionCall(poSTSubscriptionType, idempotencyKey, acceptEncoding, contentEncoding, authorization, zuoraTrackId, zuoraEntityIds, zuoraOrgIds, zuoraVersion, _callback);

    }


    private ApiResponse<POSTSubscriptionResponseType> subscriptionWithHttpInfo(POSTSubscriptionType poSTSubscriptionType, String idempotencyKey, String acceptEncoding, String contentEncoding, String authorization, String zuoraTrackId, String zuoraEntityIds, String zuoraOrgIds, String zuoraVersion) throws ApiException {
        okhttp3.Call localVarCall = subscriptionValidateBeforeCall(poSTSubscriptionType, idempotencyKey, acceptEncoding, contentEncoding, authorization, zuoraTrackId, zuoraEntityIds, zuoraOrgIds, zuoraVersion, null);
        Type localVarReturnType = new TypeToken<POSTSubscriptionResponseType>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    private okhttp3.Call subscriptionAsync(POSTSubscriptionType poSTSubscriptionType, String idempotencyKey, String acceptEncoding, String contentEncoding, String authorization, String zuoraTrackId, String zuoraEntityIds, String zuoraOrgIds, String zuoraVersion, final ApiCallback<POSTSubscriptionResponseType> _callback) throws ApiException {

        okhttp3.Call localVarCall = subscriptionValidateBeforeCall(poSTSubscriptionType, idempotencyKey, acceptEncoding, contentEncoding, authorization, zuoraTrackId, zuoraEntityIds, zuoraOrgIds, zuoraVersion, _callback);
        Type localVarReturnType = new TypeToken<POSTSubscriptionResponseType>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    public class SubscriptionRequestBuilder {
        private String accountKey;
        private List<String> applicationOrder;
        private Boolean applyCredit;
        private Boolean applyCreditBalance;
        private Boolean autoRenew;
        private Boolean collect;
        private LocalDate contractEffectiveDate;
        private String creditMemoReasonCode;
        private LocalDate customerAcceptanceDate;
        private LocalDate documentDate;
        private String externallyManagedBy;
        private String gatewayId;
        private Long initialTerm;
        private String initialTermPeriodType;
        private Boolean invoice;
        private Boolean invoiceCollect;
        private String invoiceOwnerAccountKey;
        private Boolean invoiceSeparately;
        private LocalDate invoiceTargetDate;
        private LocalDate lastBookingDate;
        private String notes;
        private String paymentMethodId;
        private Boolean prepayment;
        private String renewalSetting;
        private Long renewalTerm;
        private String renewalTermPeriodType;
        private Boolean runBilling;
        private LocalDate serviceActivationDate;
        private List<POSTSrpCreateType> subscribeToRatePlans;
        private String subscriptionNumber;
        private LocalDate targetDate;
        private LocalDate termStartDate;
        private String termType;
        private String cpqBundleJsonIdQT;
        private LocalDate opportunityCloseDateQT;
        private String opportunityNameQT;
        private String quoteBusinessTypeQT;
        private String quoteNumberQT;
        private String quoteTypeQT;
        private String integrationIdNS;
        private String integrationStatusNS;
        private String projectNS;
        private String salesOrderNS;
        private String syncDateNS;
        private String idempotencyKey;
        private String acceptEncoding;
        private String contentEncoding;
        private String authorization;
        private String zuoraTrackId;
        private String zuoraEntityIds;
        private String zuoraOrgIds;
        private String zuoraVersion;
        private POSTSubscriptionType poSTSubscriptionType;

        private SubscriptionRequestBuilder() {
        }

        /**
         * Set poSTSubscriptionType
         * @param poSTSubscriptionType  (optional)
         * @return SubscriptionRequestBuilder
         */
        public SubscriptionRequestBuilder poSTSubscriptionType(POSTSubscriptionType poSTSubscriptionType) {
            this.poSTSubscriptionType = poSTSubscriptionType;
            return this;
        }

        /**
         * Set accountKey
         * @param accountKey Customer account number or ID  (optional)
         * @return SubscriptionRequestBuilder
         */
        public SubscriptionRequestBuilder accountKey(String accountKey) {
            this.accountKey = accountKey;
            return this;
        }
        
        /**
         * Set applicationOrder
         * @param applicationOrder The priority order to apply credit memos and/or unapplied payments to an invoice. Possible item values are: &#x60;CreditMemo&#x60;, &#x60;UnappliedPayment&#x60;.  **Note:**   - This field is valid only if the &#x60;applyCredit&#x60; field is set to &#x60;true&#x60;.   - If no value is specified for this field, the default priority order is used, [\\\&quot;CreditMemo\\\&quot;, \\\&quot;UnappliedPayment\\\&quot;], to apply credit memos first and then apply unapplied payments.   - If only one item is specified, only the items of the spedified type are applied to invoices. For example, if the value is &#x60;[\\\&quot;CreditMemo\\\&quot;]&#x60;, only credit memos are used to apply to invoices.  (optional)
         * @return SubscriptionRequestBuilder
         */
        public SubscriptionRequestBuilder applicationOrder(List<String> applicationOrder) {
            this.applicationOrder = applicationOrder;
            return this;
        }
        
        /**
         * Set applyCredit
         * @param applyCredit If the value is true, the credit memo or unapplied payment on the order account will be automatically applied to the invoices generated by this order. The credit memo generated by this order will not be automatically applied to any invoices.   **Note:** This field is only available if you have [Invoice Settlement](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/Invoice_Settlement) enabled. The Invoice Settlement feature is generally available as of Zuora Billing Release 296 (March 2021). This feature includes Unapplied Payments, Credit and Debit Memo, and Invoice Item Settlement. If you want to enable Invoice Settlement, see [Invoice Settlement Enablement and Checklist Guide](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/Invoice_Settlement/Invoice_Settlement_Migration_Checklist_and_Guide) for more information.  (optional)
         * @return SubscriptionRequestBuilder
         */
        public SubscriptionRequestBuilder applyCredit(Boolean applyCredit) {
            this.applyCredit = applyCredit;
            return this;
        }
        
        /**
         * Set applyCreditBalance
         * @param applyCreditBalance Whether to automatically apply a credit balance to an invoice.  If the value is &#x60;true&#x60;, the credit balance is applied to the invoice. If the value is &#x60;false&#x60;, no action is taken.   To view the credit balance adjustment, retrieve the details of the invoice using the Get Invoices method.  Prerequisite: &#x60;invoice&#x60; must be &#x60;true&#x60;.   **Note:**    - If you are using the field &#x60;invoiceCollect&#x60; rather than the field &#x60;invoice&#x60;, the &#x60;invoiceCollect&#x60; value must be &#x60;true&#x60;.   - This field is deprecated if you have the Invoice Settlement feature enabled.  (optional)
         * @return SubscriptionRequestBuilder
         */
        public SubscriptionRequestBuilder applyCreditBalance(Boolean applyCreditBalance) {
            this.applyCreditBalance = applyCreditBalance;
            return this;
        }
        
        /**
         * Set autoRenew
         * @param autoRenew If true, this subscription automatically renews at the end of the subscription term.  This field is only required if the &#x60;termType&#x60; field is set to &#x60;TERMED&#x60;.  (optional, default to false)
         * @return SubscriptionRequestBuilder
         */
        public SubscriptionRequestBuilder autoRenew(Boolean autoRenew) {
            this.autoRenew = autoRenew;
            return this;
        }
        
        /**
         * Set collect
         * @param collect Collects an automatic payment for a subscription. The collection generated in this operation is only for this subscription, not for the entire customer account.  If the value is &#x60;true&#x60;, the automatic payment is collected. If the value is &#x60;false&#x60;, no action is taken.  Prerequisite: The &#x60;invoice&#x60; or &#x60;runBilling&#x60; field must be &#x60;true&#x60;.   **Note**: This field is only available if you set the &#x60;zuora-version&#x60; request header to &#x60;196.0&#x60; or later [available versions](https://developer.zuora.com/api-references/api/overview/#section/API-Versions/Minor-Version).  (optional, default to true)
         * @return SubscriptionRequestBuilder
         */
        public SubscriptionRequestBuilder collect(Boolean collect) {
            this.collect = collect;
            return this;
        }
        
        /**
         * Set contractEffectiveDate
         * @param contractEffectiveDate Effective contract date for this subscription, as yyyy-mm-dd  (optional)
         * @return SubscriptionRequestBuilder
         */
        public SubscriptionRequestBuilder contractEffectiveDate(LocalDate contractEffectiveDate) {
            this.contractEffectiveDate = contractEffectiveDate;
            return this;
        }
        
        /**
         * Set creditMemoReasonCode
         * @param creditMemoReasonCode A code identifying the reason for the credit memo transaction that is generated by the request. The value must be an existing reason code. If you do not pass the field or pass the field with empty value, Zuora uses the default reason code. (optional)
         * @return SubscriptionRequestBuilder
         */
        public SubscriptionRequestBuilder creditMemoReasonCode(String creditMemoReasonCode) {
            this.creditMemoReasonCode = creditMemoReasonCode;
            return this;
        }
        
        /**
         * Set customerAcceptanceDate
         * @param customerAcceptanceDate The date on which the services or products within a subscription have been accepted by the customer, as yyyy-mm-dd.  Default value is dependent on the value of other fields. See **Notes** section for more details.  (optional)
         * @return SubscriptionRequestBuilder
         */
        public SubscriptionRequestBuilder customerAcceptanceDate(LocalDate customerAcceptanceDate) {
            this.customerAcceptanceDate = customerAcceptanceDate;
            return this;
        }
        
        /**
         * Set documentDate
         * @param documentDate The date of the billing document, in &#x60;yyyy-mm-dd&#x60; format. It represents the invoice date for invoices, credit memo date for credit memos, and debit memo date for debit memos.  - If this field is specified, the specified date is used as the billing document date.  - If this field is not specified, the date specified in the &#x60;targetDate&#x60; is used as the billing document date.  (optional)
         * @return SubscriptionRequestBuilder
         */
        public SubscriptionRequestBuilder documentDate(LocalDate documentDate) {
            this.documentDate = documentDate;
            return this;
        }
        
        /**
         * Set externallyManagedBy
         * @param externallyManagedBy An enum field on the Subscription object to indicate the name of a third-party store. This field is used to represent subscriptions created through third-party stores.  (optional)
         * @return SubscriptionRequestBuilder
         */
        public SubscriptionRequestBuilder externallyManagedBy(String externallyManagedBy) {
            this.externallyManagedBy = externallyManagedBy;
            return this;
        }
        
        /**
         * Set gatewayId
         * @param gatewayId The ID of the payment gateway instance. For example, &#x60;2c92c0f86078c4d5016091674bcc3e92&#x60;.  If &lt;a href&#x3D;\\\&quot;https://knowledgecenter.zuora.com/Zuora_Payments/Payment_gateway_integrations/Payment_Gateway_Routing\\\&quot; target&#x3D;\\\&quot;_blank\\\&quot;&gt;Payment Gateway Routing&lt;/a&gt; is enabled:    - If this field is not specified, gateway routing rules will be invoked.   - If this field is specified, the specified gateway will be used to process the payment.  If Payment Gateway Routing is disabled:   - If this field is not specified, the default payment gateway will be used to process the payment. The default gateway of the customer account takes precedence over the default gateway of the tenant.    - If this field is specified, the specified gateway will be used to process the payment.  (optional)
         * @return SubscriptionRequestBuilder
         */
        public SubscriptionRequestBuilder gatewayId(String gatewayId) {
            this.gatewayId = gatewayId;
            return this;
        }
        
        /**
         * Set initialTerm
         * @param initialTerm The length of the period for the first subscription term. If &#x60;termType&#x60; is &#x60;TERMED&#x60;, then this field is required, and the value must be greater than &#x60;0&#x60;. If &#x60;termType&#x60; is &#x60;EVERGREEN&#x60;, this field is ignored.  (optional)
         * @return SubscriptionRequestBuilder
         */
        public SubscriptionRequestBuilder initialTerm(Long initialTerm) {
            this.initialTerm = initialTerm;
            return this;
        }
        
        /**
         * Set initialTermPeriodType
         * @param initialTermPeriodType The period type for the first subscription term.  This field is used with the &#x60;InitialTerm&#x60; field to specify the initial subscription term.  Values are:  * &#x60;Month&#x60; (default) * &#x60;Year&#x60; * &#x60;Day&#x60; * &#x60;Week&#x60;  (optional)
         * @return SubscriptionRequestBuilder
         */
        public SubscriptionRequestBuilder initialTermPeriodType(String initialTermPeriodType) {
            this.initialTermPeriodType = initialTermPeriodType;
            return this;
        }
        
        /**
         * Set invoice
         * @param invoice **Note:** This field has been replaced by the &#x60;runBilling&#x60; field. The &#x60;invoice&#x60; field is only available for backward compatibility.   Creates an invoice for a subscription. The invoice generated in this operation is only for this subscription, not for the entire customer account.   If the value is &#x60;true&#x60;, an invoice is created. If the value is &#x60;false&#x60;, no action is taken. The default value is &#x60;true&#x60;.    This field is in Zuora REST API version control. Supported minor versions are &#x60;196.0&#x60; and &#x60;207.0&#x60;. To use this field in the method, you must set the zuora-version parameter to the minor version number in the request header.  (optional)
         * @return SubscriptionRequestBuilder
         */
        public SubscriptionRequestBuilder invoice(Boolean invoice) {
            this.invoice = invoice;
            return this;
        }
        
        /**
         * Set invoiceCollect
         * @param invoiceCollect **Note:** This field has been replaced by the &#x60;invoice&#x60; field and the &#x60;collect&#x60; field. &#x60;invoiceCollect&#x60; is available only for backward compatibility.   If this field is set to &#x60;true&#x60;, an invoice is generated and payment collected automatically during the subscription process. If &#x60;false&#x60;, no invoicing or payment takes place. The invoice generated in this operation is only for this subscription, not for the entire customer account.   **Note**: This field is only available if you set the &#x60;zuora-version&#x60; request header to &#x60;186.0&#x60;, &#x60;187.0&#x60;, &#x60;188.0&#x60;, or &#x60;189.0&#x60;.  (optional, default to true)
         * @return SubscriptionRequestBuilder
         */
        public SubscriptionRequestBuilder invoiceCollect(Boolean invoiceCollect) {
            this.invoiceCollect = invoiceCollect;
            return this;
        }
        
        /**
         * Set invoiceOwnerAccountKey
         * @param invoiceOwnerAccountKey Invoice owner account number or ID.  **Note:** This feature is in **Limited Availability**. If you wish to have access to the feature, submit a request at [Zuora Global Support](http://support.zuora.com/).  (optional)
         * @return SubscriptionRequestBuilder
         */
        public SubscriptionRequestBuilder invoiceOwnerAccountKey(String invoiceOwnerAccountKey) {
            this.invoiceOwnerAccountKey = invoiceOwnerAccountKey;
            return this;
        }
        
        /**
         * Set invoiceSeparately
         * @param invoiceSeparately Separates a single subscription from other subscriptions and invoices the charge independently.   If the value is &#x60;true&#x60;, the subscription is billed separately from other subscriptions. If the value is &#x60;false&#x60;, the subscription is included with other subscriptions in the account invoice.  The default value is &#x60;false&#x60;.  Prerequisite: The default subscription setting Enable Subscriptions to be Invoiced Separately must be set to Yes.  (optional)
         * @return SubscriptionRequestBuilder
         */
        public SubscriptionRequestBuilder invoiceSeparately(Boolean invoiceSeparately) {
            this.invoiceSeparately = invoiceSeparately;
            return this;
        }
        
        /**
         * Set invoiceTargetDate
         * @param invoiceTargetDate **Note:** This field has been replaced by the &#x60;targetDate&#x60; field. The &#x60;invoiceTargetDate&#x60; field is only available for backward compatibility.   Date through which to calculate charges if an invoice is generated, as yyyy-mm-dd. Default is current date.   This field is in Zuora REST API version control. Supported minor versions are &#x60;207.0&#x60; and earlier [available versions](https://developer.zuora.com/api-references/api/overview/#section/API-Versions/Minor-Version).  (optional)
         * @return SubscriptionRequestBuilder
         */
        public SubscriptionRequestBuilder invoiceTargetDate(LocalDate invoiceTargetDate) {
            this.invoiceTargetDate = invoiceTargetDate;
            return this;
        }
        
        /**
         * Set lastBookingDate
         * @param lastBookingDate The last booking date of the subscription object. This field is writable only when the subscription is newly created as a first version subscription. You can override the date value when creating a subscription through the Subscribe and Amend API or the subscription creation UI (non-Orders). Otherwise, the default value &#x60;today&#x60; is set per the user&#39;s timezone. The value of this field is as follows: * For a new subscription created by the [Subscribe and Amend APIs](https://knowledgecenter.zuora.com/Billing/Subscriptions/Orders/Orders_Harmonization/Orders_Migration_Guidance#Subscribe_and_Amend_APIs_to_Migrate), this field has the value of the subscription creation date. * For a subscription changed by an amendment, this field has the value of the amendment booking date. * For a subscription created or changed by an order, this field has the value of the order date.  (optional)
         * @return SubscriptionRequestBuilder
         */
        public SubscriptionRequestBuilder lastBookingDate(LocalDate lastBookingDate) {
            this.lastBookingDate = lastBookingDate;
            return this;
        }
        
        /**
         * Set notes
         * @param notes String of up to 500 characters.  (optional)
         * @return SubscriptionRequestBuilder
         */
        public SubscriptionRequestBuilder notes(String notes) {
            this.notes = notes;
            return this;
        }
        
        /**
         * Set paymentMethodId
         * @param paymentMethodId The ID of the payment method used for the payment.  (optional)
         * @return SubscriptionRequestBuilder
         */
        public SubscriptionRequestBuilder paymentMethodId(String paymentMethodId) {
            this.paymentMethodId = paymentMethodId;
            return this;
        }
        
        /**
         * Set prepayment
         * @param prepayment Indicates whether the subscription will consume the reserved payment amount of the customer account. See [Prepaid Cash with Drawdown](https://knowledgecenter.zuora.com/Zuora_Billing/Billing_and_Invoicing/JA_Advanced_Consumption_Billing/Prepaid_Cash_with_Drawdown) for more information.   (optional)
         * @return SubscriptionRequestBuilder
         */
        public SubscriptionRequestBuilder prepayment(Boolean prepayment) {
            this.prepayment = prepayment;
            return this;
        }
        
        /**
         * Set renewalSetting
         * @param renewalSetting Specifies whether a termed subscription will remain termed or change to evergreen when it is renewed.  Values:  * &#x60;RENEW_WITH_SPECIFIC_TERM&#x60; (default) * &#x60;RENEW_TO_EVERGREEN&#x60;  (optional)
         * @return SubscriptionRequestBuilder
         */
        public SubscriptionRequestBuilder renewalSetting(String renewalSetting) {
            this.renewalSetting = renewalSetting;
            return this;
        }
        
        /**
         * Set renewalTerm
         * @param renewalTerm The length of the period for the subscription renewal term. Default is &#x60;0&#x60;.  (optional)
         * @return SubscriptionRequestBuilder
         */
        public SubscriptionRequestBuilder renewalTerm(Long renewalTerm) {
            this.renewalTerm = renewalTerm;
            return this;
        }
        
        /**
         * Set renewalTermPeriodType
         * @param renewalTermPeriodType The period type for the subscription renewal term.  This field is used with the &#x60;renewalTerm&#x60; field to specify the subscription renewal term.  Values are:  * &#x60;Month&#x60; (default) * &#x60;Year&#x60; * &#x60;Day&#x60; * &#x60;Week&#x60;  (optional)
         * @return SubscriptionRequestBuilder
         */
        public SubscriptionRequestBuilder renewalTermPeriodType(String renewalTermPeriodType) {
            this.renewalTermPeriodType = renewalTermPeriodType;
            return this;
        }
        
        /**
         * Set runBilling
         * @param runBilling Creates an invoice for a subscription. If you have the Invoice Settlement feature enabled, a credit memo might also be created based on the [invoice and credit memo generation rule](https://knowledgecenter.zuora.com/CB_Billing/Invoice_Settlement/Credit_and_Debit_Memos/Rules_for_Generating_Invoices_and_Credit_Memos).     The billing documents generated in this operation is only for this subscription, not for the entire customer account.   Possible values:  - &#x60;true&#x60;: An invoice is created. If you have the Invoice Settlement feature enabled, a credit memo might also be created.   - &#x60;false&#x60;: No invoice is created.   **Note:** This field is in Zuora REST API version control. Supported minor versions are &#x60;211.0&#x60; or later [available versions](https://developer.zuora.com/api-references/api/overview/#section/API-Versions/Minor-Version). To use this field in the method, you must set the &#x60;zuora-version&#x60; parameter to the minor version number in the request header.  (optional, default to true)
         * @return SubscriptionRequestBuilder
         */
        public SubscriptionRequestBuilder runBilling(Boolean runBilling) {
            this.runBilling = runBilling;
            return this;
        }
        
        /**
         * Set serviceActivationDate
         * @param serviceActivationDate The date on which the services or products within a subscription have been activated and access has been provided to the customer, as yyyy-mm-dd.  Default value is dependent on the value of other fields. See **Notes** section for more details.  (optional)
         * @return SubscriptionRequestBuilder
         */
        public SubscriptionRequestBuilder serviceActivationDate(LocalDate serviceActivationDate) {
            this.serviceActivationDate = serviceActivationDate;
            return this;
        }
        
        /**
         * Set subscribeToRatePlans
         * @param subscribeToRatePlans Container for one or more rate plans for this subscription.  (optional)
         * @return SubscriptionRequestBuilder
         */
        public SubscriptionRequestBuilder subscribeToRatePlans(List<POSTSrpCreateType> subscribeToRatePlans) {
            this.subscribeToRatePlans = subscribeToRatePlans;
            return this;
        }
        
        /**
         * Set subscriptionNumber
         * @param subscriptionNumber Subscription Number. The value can be up to 1000 characters.  If you do not specify a subscription number when creating a subscription, Zuora will generate a subscription number automatically.  If the account is created successfully, the subscription number is returned in the &#x60;subscriptionNumber&#x60; response field.  (optional)
         * @return SubscriptionRequestBuilder
         */
        public SubscriptionRequestBuilder subscriptionNumber(String subscriptionNumber) {
            this.subscriptionNumber = subscriptionNumber;
            return this;
        }
        
        /**
         * Set targetDate
         * @param targetDate Date through which to calculate charges if an invoice or a credit memo is generated, as yyyy-mm-dd. Default is current date.   **Note:** The credit memo is only available if you have the Invoice Settlement feature enabled.   This field is in Zuora REST API version control. Supported minor versions are &#x60;211.0&#x60; and later. To use this field in the method, you must set the  &#x60;zuora-version&#x60; parameter to the minor version number in the request header.  (optional)
         * @return SubscriptionRequestBuilder
         */
        public SubscriptionRequestBuilder targetDate(LocalDate targetDate) {
            this.targetDate = targetDate;
            return this;
        }
        
        /**
         * Set termStartDate
         * @param termStartDate The date on which the subscription term begins, as yyyy-mm-dd. If this is a renewal subscription, this date is different from the subscription start date.  (optional)
         * @return SubscriptionRequestBuilder
         */
        public SubscriptionRequestBuilder termStartDate(LocalDate termStartDate) {
            this.termStartDate = termStartDate;
            return this;
        }
        
        /**
         * Set termType
         * @param termType Possible values are: &#x60;TERMED&#x60;, &#x60;EVERGREEN&#x60;.  (optional)
         * @return SubscriptionRequestBuilder
         */
        public SubscriptionRequestBuilder termType(String termType) {
            this.termType = termType;
            return this;
        }
        
        /**
         * Set cpqBundleJsonIdQT
         * @param cpqBundleJsonIdQT The Bundle product structures from Zuora Quotes if you utilize Bundling in Salesforce. Do not change the value in this field.  (optional)
         * @return SubscriptionRequestBuilder
         */
        public SubscriptionRequestBuilder cpqBundleJsonIdQT(String cpqBundleJsonIdQT) {
            this.cpqBundleJsonIdQT = cpqBundleJsonIdQT;
            return this;
        }
        
        /**
         * Set opportunityCloseDateQT
         * @param opportunityCloseDateQT The closing date of the Opportunity. This field is used in Zuora data sources to report on Subscription metrics. If the subscription originated from Zuora Quotes, the value is populated with the value from Zuora Quotes.  (optional)
         * @return SubscriptionRequestBuilder
         */
        public SubscriptionRequestBuilder opportunityCloseDateQT(LocalDate opportunityCloseDateQT) {
            this.opportunityCloseDateQT = opportunityCloseDateQT;
            return this;
        }
        
        /**
         * Set opportunityNameQT
         * @param opportunityNameQT The unique identifier of the Opportunity. This field is used in Zuora data sources to report on Subscription metrics. If the subscription originated from Zuora Quotes, the value is populated with the value from Zuora Quotes.  (optional)
         * @return SubscriptionRequestBuilder
         */
        public SubscriptionRequestBuilder opportunityNameQT(String opportunityNameQT) {
            this.opportunityNameQT = opportunityNameQT;
            return this;
        }
        
        /**
         * Set quoteBusinessTypeQT
         * @param quoteBusinessTypeQT The specific identifier for the type of business transaction the Quote represents such as New, Upsell, Downsell, Renewal or Churn. This field is used in Zuora data sources to report on Subscription metrics. If the subscription originated from Zuora Quotes, the value is populated with the value from Zuora Quotes.  (optional)
         * @return SubscriptionRequestBuilder
         */
        public SubscriptionRequestBuilder quoteBusinessTypeQT(String quoteBusinessTypeQT) {
            this.quoteBusinessTypeQT = quoteBusinessTypeQT;
            return this;
        }
        
        /**
         * Set quoteNumberQT
         * @param quoteNumberQT The unique identifier of the Quote. This field is used in Zuora data sources to report on Subscription metrics. If the subscription originated from Zuora Quotes, the value is populated with the value from Zuora Quotes.  (optional)
         * @return SubscriptionRequestBuilder
         */
        public SubscriptionRequestBuilder quoteNumberQT(String quoteNumberQT) {
            this.quoteNumberQT = quoteNumberQT;
            return this;
        }
        
        /**
         * Set quoteTypeQT
         * @param quoteTypeQT The Quote type that represents the subscription lifecycle stage such as New, Amendment, Renew or Cancel. This field is used in Zuora data sources to report on Subscription metrics. If the subscription originated from Zuora Quotes, the value is populated with the value from Zuora Quotes.  (optional)
         * @return SubscriptionRequestBuilder
         */
        public SubscriptionRequestBuilder quoteTypeQT(String quoteTypeQT) {
            this.quoteTypeQT = quoteTypeQT;
            return this;
        }
        
        /**
         * Set integrationIdNS
         * @param integrationIdNS ID of the corresponding object in NetSuite. Only available if you have installed the [Zuora Connector for NetSuite](https://www.zuora.com/connect/app/?appId&#x3D;265).  (optional)
         * @return SubscriptionRequestBuilder
         */
        public SubscriptionRequestBuilder integrationIdNS(String integrationIdNS) {
            this.integrationIdNS = integrationIdNS;
            return this;
        }
        
        /**
         * Set integrationStatusNS
         * @param integrationStatusNS Status of the subscription&#39;s synchronization with NetSuite. Only available if you have installed the [Zuora Connector for NetSuite](https://www.zuora.com/connect/app/?appId&#x3D;265).  (optional)
         * @return SubscriptionRequestBuilder
         */
        public SubscriptionRequestBuilder integrationStatusNS(String integrationStatusNS) {
            this.integrationStatusNS = integrationStatusNS;
            return this;
        }
        
        /**
         * Set projectNS
         * @param projectNS The NetSuite project that the subscription was created from. Only available if you have installed the [Zuora Connector for NetSuite](https://www.zuora.com/connect/app/?appId&#x3D;265).  (optional)
         * @return SubscriptionRequestBuilder
         */
        public SubscriptionRequestBuilder projectNS(String projectNS) {
            this.projectNS = projectNS;
            return this;
        }
        
        /**
         * Set salesOrderNS
         * @param salesOrderNS The NetSuite sales order than the subscription was created from. Only available if you have installed the [Zuora Connector for NetSuite](https://www.zuora.com/connect/app/?appId&#x3D;265).  (optional)
         * @return SubscriptionRequestBuilder
         */
        public SubscriptionRequestBuilder salesOrderNS(String salesOrderNS) {
            this.salesOrderNS = salesOrderNS;
            return this;
        }
        
        /**
         * Set syncDateNS
         * @param syncDateNS Date when the subscription was synchronized with NetSuite. Only available if you have installed the [Zuora Connector for NetSuite](https://www.zuora.com/connect/app/?appId&#x3D;265).  (optional)
         * @return SubscriptionRequestBuilder
         */
        public SubscriptionRequestBuilder syncDateNS(String syncDateNS) {
            this.syncDateNS = syncDateNS;
            return this;
        }
        
        /**
         * Set idempotencyKey
         * @param idempotencyKey Specify a unique idempotency key if you want to perform an idempotent POST or PATCH request. Do not use this header in other request types.   With this header specified, the Zuora server can identify subsequent retries of the same request using this value, which prevents the same operation from being performed multiple times by accident.   (optional)
         * @return SubscriptionRequestBuilder
         */
        public SubscriptionRequestBuilder idempotencyKey(String idempotencyKey) {
            this.idempotencyKey = idempotencyKey;
            return this;
        }
        
        /**
         * Set acceptEncoding
         * @param acceptEncoding Include the &#x60;Accept-Encoding: gzip&#x60; header to compress responses as a gzipped file. It can significantly reduce the bandwidth required for a response.   If specified, Zuora automatically compresses responses that contain over 1000 bytes of data, and the response contains a &#x60;Content-Encoding&#x60; header with the compression algorithm so that your client can decompress it.  (optional)
         * @return SubscriptionRequestBuilder
         */
        public SubscriptionRequestBuilder acceptEncoding(String acceptEncoding) {
            this.acceptEncoding = acceptEncoding;
            return this;
        }
        
        /**
         * Set contentEncoding
         * @param contentEncoding Include the &#x60;Content-Encoding: gzip&#x60; header to compress a request. With this header specified, you should upload a gzipped file for the request payload instead of sending the JSON payload.  (optional)
         * @return SubscriptionRequestBuilder
         */
        public SubscriptionRequestBuilder contentEncoding(String contentEncoding) {
            this.contentEncoding = contentEncoding;
            return this;
        }
        
        /**
         * Set authorization
         * @param authorization The value is in the &#x60;Bearer {token}&#x60; format where {token} is a valid OAuth token generated by calling [Create an OAuth token](https://developer.zuora.com/api-references/api/operation/createToken).  (optional)
         * @return SubscriptionRequestBuilder
         */
        public SubscriptionRequestBuilder authorization(String authorization) {
            this.authorization = authorization;
            return this;
        }
        
        /**
         * Set zuoraTrackId
         * @param zuoraTrackId A custom identifier for tracing the API call. If you set a value for this header, Zuora returns the same value in the response headers. This header enables you to associate your system process identifiers with Zuora API calls, to assist with troubleshooting in the event of an issue.  The value of this field must use the US-ASCII character set and must not include any of the following characters: colon (&#x60;:&#x60;), semicolon (&#x60;;&#x60;), double quote (&#x60;\&quot;&#x60;), and quote (&#x60;&#39;&#x60;).  (optional)
         * @return SubscriptionRequestBuilder
         */
        public SubscriptionRequestBuilder zuoraTrackId(String zuoraTrackId) {
            this.zuoraTrackId = zuoraTrackId;
            return this;
        }
        
        /**
         * Set zuoraEntityIds
         * @param zuoraEntityIds An entity ID. If you have [Zuora Multi-entity](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Multi-entity) enabled and the OAuth token is valid for more than one entity, you must use this header to specify which entity to perform the operation in. If the OAuth token is only valid for a single entity, or you do not have Zuora Multi-entity enabled, you do not need to set this header.  (optional)
         * @return SubscriptionRequestBuilder
         */
        public SubscriptionRequestBuilder zuoraEntityIds(String zuoraEntityIds) {
            this.zuoraEntityIds = zuoraEntityIds;
            return this;
        }
        
        /**
         * Set zuoraOrgIds
         * @param zuoraOrgIds Comma separated IDs. If you have &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Central_Platform/Multi-Org\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Zuora Multi-Org&lt;/a&gt; enabled,  you can use this header to specify which orgs to perform the operation in. If you do not have Zuora Multi-Org enabled, you should not set this header.  The IDs must be a sub-set of the user&#39;s accessible orgs. If you specify an org that the user does not have access to, the operation fails.  If the header is not set, the operation is performed in scope of the user&#39;s accessible orgs.  (optional)
         * @return SubscriptionRequestBuilder
         */
        public SubscriptionRequestBuilder zuoraOrgIds(String zuoraOrgIds) {
            this.zuoraOrgIds = zuoraOrgIds;
            return this;
        }
        
        /**
         * Set zuoraVersion
         * @param zuoraVersion The minor version of the Zuora REST API.   You only need to set this parameter if you use the following fields: * invoice * collect * runBilling * targetDate  (optional)
         * @return SubscriptionRequestBuilder
         */
        public SubscriptionRequestBuilder zuoraVersion(String zuoraVersion) {
            this.zuoraVersion = zuoraVersion;
            return this;
        }
        
        /**
         * Build call for subscription
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
            POSTSubscriptionType poSTSubscriptionType = buildBodyParams();
            return subscriptionCall(poSTSubscriptionType, idempotencyKey, acceptEncoding, contentEncoding, authorization, zuoraTrackId, zuoraEntityIds, zuoraOrgIds, zuoraVersion, _callback);
        }

        private POSTSubscriptionType buildBodyParams() {
            return this.poSTSubscriptionType;
        }

        /**
         * Execute subscription request
         * @return POSTSubscriptionResponseType
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td>  </td><td>  * Content-Encoding - This header is returned if you specify the &#x60;Accept-Encoding: gzip&#x60; request header and the response contains over 1000 bytes of data. Note that only the following MIME types support gzipped responses:   - &#x60;application/json&#x60;   - &#x60;application/xml&#x60;   - &#x60;text/html&#x60;   - &#x60;text/csv&#x60;   - &#x60;text/plain&#x60;  <br>  * RateLimit-Limit - The request limit quota for the time window closest to exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Remaining - The number of requests remaining in the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Reset - The number of seconds until the quota resets for the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Zuora-Request-Id - The Zuora internal identifier of the API call. You cannot control the value of this header.  <br>  * Zuora-Track-Id - A custom identifier for tracing the API call. If you specified a tracing identifier in the request headers, Zuora returns the same tracing identifier. Otherwise, Zuora does not set this header.  <br>  </td></tr>
         </table>
         */
        public POSTSubscriptionResponseType execute() throws ApiException {
            POSTSubscriptionType poSTSubscriptionType = buildBodyParams();
            ApiResponse<POSTSubscriptionResponseType> localVarResp = subscriptionWithHttpInfo(poSTSubscriptionType, idempotencyKey, acceptEncoding, contentEncoding, authorization, zuoraTrackId, zuoraEntityIds, zuoraOrgIds, zuoraVersion);
            return localVarResp.getResponseBody();
        }

        /**
         * Execute subscription request with HTTP info returned
         * @return ApiResponse&lt;POSTSubscriptionResponseType&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td>  </td><td>  * Content-Encoding - This header is returned if you specify the &#x60;Accept-Encoding: gzip&#x60; request header and the response contains over 1000 bytes of data. Note that only the following MIME types support gzipped responses:   - &#x60;application/json&#x60;   - &#x60;application/xml&#x60;   - &#x60;text/html&#x60;   - &#x60;text/csv&#x60;   - &#x60;text/plain&#x60;  <br>  * RateLimit-Limit - The request limit quota for the time window closest to exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Remaining - The number of requests remaining in the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Reset - The number of seconds until the quota resets for the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Zuora-Request-Id - The Zuora internal identifier of the API call. You cannot control the value of this header.  <br>  * Zuora-Track-Id - A custom identifier for tracing the API call. If you specified a tracing identifier in the request headers, Zuora returns the same tracing identifier. Otherwise, Zuora does not set this header.  <br>  </td></tr>
         </table>
         */
        public ApiResponse<POSTSubscriptionResponseType> executeWithHttpInfo() throws ApiException {
            POSTSubscriptionType poSTSubscriptionType = buildBodyParams();
            return subscriptionWithHttpInfo(poSTSubscriptionType, idempotencyKey, acceptEncoding, contentEncoding, authorization, zuoraTrackId, zuoraEntityIds, zuoraOrgIds, zuoraVersion);
        }

        /**
         * Execute subscription request (asynchronously)
         * @param _callback The callback to be executed when the API call finishes
         * @return The request call
         * @throws ApiException If fail to process the API call, e.g. serializing the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td>  </td><td>  * Content-Encoding - This header is returned if you specify the &#x60;Accept-Encoding: gzip&#x60; request header and the response contains over 1000 bytes of data. Note that only the following MIME types support gzipped responses:   - &#x60;application/json&#x60;   - &#x60;application/xml&#x60;   - &#x60;text/html&#x60;   - &#x60;text/csv&#x60;   - &#x60;text/plain&#x60;  <br>  * RateLimit-Limit - The request limit quota for the time window closest to exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Remaining - The number of requests remaining in the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Reset - The number of seconds until the quota resets for the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Zuora-Request-Id - The Zuora internal identifier of the API call. You cannot control the value of this header.  <br>  * Zuora-Track-Id - A custom identifier for tracing the API call. If you specified a tracing identifier in the request headers, Zuora returns the same tracing identifier. Otherwise, Zuora does not set this header.  <br>  </td></tr>
         </table>
         */
        public okhttp3.Call executeAsync(final ApiCallback<POSTSubscriptionResponseType> _callback) throws ApiException {
            POSTSubscriptionType poSTSubscriptionType = buildBodyParams();
            return subscriptionAsync(poSTSubscriptionType, idempotencyKey, acceptEncoding, contentEncoding, authorization, zuoraTrackId, zuoraEntityIds, zuoraOrgIds, zuoraVersion, _callback);
        }
    }

    /**
     * Create a subscription
     * This REST API reference describes how to create a new subscription for an existing customer account.  ### Notes  If you have the Invoice Settlement feature enabled, it is best practice to set the &#x60;zuora-version&#x60; parameter to &#x60;211.0&#x60; or later [available versions](https://developer.zuora.com/api-references/api/overview/#section/API-Versions/Minor-Version). Otherwise, an error occurs.  If &#x60;invoiceCollect&#x60; is &#x60;true&#x60;, the call will not return &#x60;success&#x60; &#x3D; &#x60;true&#x60; unless the subscription, invoice, and payment are all successful.  Default values for **customerAcceptanceDate** and **serviceActivationDate** are set as follows. This API operation does not support creating a pending subscription.  |        | serviceActivationDate(SA) specified          | serviceActivationDate (SA) NOT specified  | | ------------- |:-------------:| -----:| | customerAcceptanceDate (CA) specified| SA uses value in the request call; CA uses value in the request call| CA uses value in the request call;SA uses CE as default | | customerAcceptanceDate (CA) NOT specified      | SA uses value in the request call; CA uses SA as default |   SA and CA use CE as default | 
     * @param poSTSubscriptionType  (required)
     * @return SubscriptionRequestBuilder
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td>  </td><td>  * Content-Encoding - This header is returned if you specify the &#x60;Accept-Encoding: gzip&#x60; request header and the response contains over 1000 bytes of data. Note that only the following MIME types support gzipped responses:   - &#x60;application/json&#x60;   - &#x60;application/xml&#x60;   - &#x60;text/html&#x60;   - &#x60;text/csv&#x60;   - &#x60;text/plain&#x60;  <br>  * RateLimit-Limit - The request limit quota for the time window closest to exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Remaining - The number of requests remaining in the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Reset - The number of seconds until the quota resets for the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Zuora-Request-Id - The Zuora internal identifier of the API call. You cannot control the value of this header.  <br>  * Zuora-Track-Id - A custom identifier for tracing the API call. If you specified a tracing identifier in the request headers, Zuora returns the same tracing identifier. Otherwise, Zuora does not set this header.  <br>  </td></tr>
     </table>
     */
    public SubscriptionRequestBuilder subscription() throws IllegalArgumentException {
        return new SubscriptionRequestBuilder();
    }
    private okhttp3.Call subscription_0Call(String subscriptionKey, PUTSubscriptionType puTSubscriptionType, String acceptEncoding, String contentEncoding, String authorization, String zuoraTrackId, String zuoraEntityIds, String zuoraOrgIds, String zuoraVersion, final ApiCallback _callback) throws ApiException {
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

        Object localVarPostBody = puTSubscriptionType;

        // create path and map variables
        String localVarPath = "/v1/subscriptions/{subscription-key}"
            .replace("{" + "subscription-key" + "}", localVarApiClient.escapeString(subscriptionKey.toString()));

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
    private okhttp3.Call subscription_0ValidateBeforeCall(String subscriptionKey, PUTSubscriptionType puTSubscriptionType, String acceptEncoding, String contentEncoding, String authorization, String zuoraTrackId, String zuoraEntityIds, String zuoraOrgIds, String zuoraVersion, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'subscriptionKey' is set
        if (subscriptionKey == null) {
            throw new ApiException("Missing the required parameter 'subscriptionKey' when calling subscription_0(Async)");
        }

        // verify the required parameter 'puTSubscriptionType' is set
        if (puTSubscriptionType == null) {
            throw new ApiException("Missing the required parameter 'puTSubscriptionType' when calling subscription_0(Async)");
        }

        return subscription_0Call(subscriptionKey, puTSubscriptionType, acceptEncoding, contentEncoding, authorization, zuoraTrackId, zuoraEntityIds, zuoraOrgIds, zuoraVersion, _callback);

    }


    private ApiResponse<PUTSubscriptionResponseType> subscription_0WithHttpInfo(String subscriptionKey, PUTSubscriptionType puTSubscriptionType, String acceptEncoding, String contentEncoding, String authorization, String zuoraTrackId, String zuoraEntityIds, String zuoraOrgIds, String zuoraVersion) throws ApiException {
        okhttp3.Call localVarCall = subscription_0ValidateBeforeCall(subscriptionKey, puTSubscriptionType, acceptEncoding, contentEncoding, authorization, zuoraTrackId, zuoraEntityIds, zuoraOrgIds, zuoraVersion, null);
        Type localVarReturnType = new TypeToken<PUTSubscriptionResponseType>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    private okhttp3.Call subscription_0Async(String subscriptionKey, PUTSubscriptionType puTSubscriptionType, String acceptEncoding, String contentEncoding, String authorization, String zuoraTrackId, String zuoraEntityIds, String zuoraOrgIds, String zuoraVersion, final ApiCallback<PUTSubscriptionResponseType> _callback) throws ApiException {

        okhttp3.Call localVarCall = subscription_0ValidateBeforeCall(subscriptionKey, puTSubscriptionType, acceptEncoding, contentEncoding, authorization, zuoraTrackId, zuoraEntityIds, zuoraOrgIds, zuoraVersion, _callback);
        Type localVarReturnType = new TypeToken<PUTSubscriptionResponseType>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    public class Subscription0RequestBuilder {
        private final String subscriptionKey;
        private List<PUTSrpAddType> add;
        private List<String> applicationOrder;
        private Boolean applyCredit;
        private Boolean applyCreditBalance;
        private Boolean autoRenew;
        private LocalDate bookingDate;
        private List<PUTSrpChangeType> change;
        private Boolean collect;
        private String creditMemoReasonCode;
        private Long currentTerm;
        private String currentTermPeriodType;
        private LocalDate documentDate;
        private String externallyManagedBy;
        private Boolean includeExistingDraftDocItems;
        private Boolean includeExistingDraftInvoiceItems;
        private Boolean invoice;
        private Boolean invoiceCollect;
        private Boolean invoiceSeparately;
        private LocalDate invoiceTargetDate;
        private String notes;
        private Boolean preview;
        private String previewType;
        private List<PUTSrpRemoveType> remove;
        private String renewalSetting;
        private Long renewalTerm;
        private String renewalTermPeriodType;
        private Boolean runBilling;
        private LocalDate targetDate;
        private LocalDate termStartDate;
        private String termType;
        private List<PUTSrpUpdateType> update;
        private String cpqBundleJsonIdQT;
        private LocalDate opportunityCloseDateQT;
        private String opportunityNameQT;
        private String quoteBusinessTypeQT;
        private String quoteNumberQT;
        private String quoteTypeQT;
        private String integrationIdNS;
        private String integrationStatusNS;
        private String projectNS;
        private String salesOrderNS;
        private String syncDateNS;
        private String acceptEncoding;
        private String contentEncoding;
        private String authorization;
        private String zuoraTrackId;
        private String zuoraEntityIds;
        private String zuoraOrgIds;
        private String zuoraVersion;
        private PUTSubscriptionType puTSubscriptionType;

        private Subscription0RequestBuilder(String subscriptionKey) {
            this.subscriptionKey = subscriptionKey;
        }

        /**
         * Set puTSubscriptionType
         * @param puTSubscriptionType  (optional)
         * @return Subscription0RequestBuilder
         */
        public Subscription0RequestBuilder puTSubscriptionType(PUTSubscriptionType puTSubscriptionType) {
            this.puTSubscriptionType = puTSubscriptionType;
            return this;
        }

        /**
         * Set add
         * @param add Container for adding one or more rate plans.  (optional)
         * @return Subscription0RequestBuilder
         */
        public Subscription0RequestBuilder add(List<PUTSrpAddType> add) {
            this.add = add;
            return this;
        }
        
        /**
         * Set applicationOrder
         * @param applicationOrder The priority order to apply credit memos and/or unapplied payments to an invoice. Possible item values are: &#x60;CreditMemo&#x60;, &#x60;UnappliedPayment&#x60;.  **Note:**   - This field is valid only if the &#x60;applyCredit&#x60; field is set to &#x60;true&#x60;.   - If no value is specified for this field, the default priority order is used, [\\\&quot;CreditMemo\\\&quot;, \\\&quot;UnappliedPayment\\\&quot;], to apply credit memos first and then apply unapplied payments.   - If only one item is specified, only the items of the spedified type are applied to invoices. For example, if the value is &#x60;[\\\&quot;CreditMemo\\\&quot;]&#x60;, only credit memos are used to apply to invoices.  (optional)
         * @return Subscription0RequestBuilder
         */
        public Subscription0RequestBuilder applicationOrder(List<String> applicationOrder) {
            this.applicationOrder = applicationOrder;
            return this;
        }
        
        /**
         * Set applyCredit
         * @param applyCredit Whether to automatically apply credit memos or unapplied payments, or both to an invoice.  If the value is &#x60;true&#x60;, the credit memo or unapplied payment, or both will be automatically applied to the invoice. If no value is specified or the value is &#x60;false&#x60;, no action is taken.  **Note:** This field is only available if you have [Invoice Settlement](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/Invoice_Settlement) enabled. The Invoice Settlement feature is generally available as of Zuora Billing Release 296 (March 2021). This feature includes Unapplied Payments, Credit and Debit Memo, and Invoice Item Settlement. If you want to enable Invoice Settlement, see [Invoice Settlement Enablement and Checklist Guide](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/Invoice_Settlement/Invoice_Settlement_Migration_Checklist_and_Guide) for more information.  (optional)
         * @return Subscription0RequestBuilder
         */
        public Subscription0RequestBuilder applyCredit(Boolean applyCredit) {
            this.applyCredit = applyCredit;
            return this;
        }
        
        /**
         * Set applyCreditBalance
         * @param applyCreditBalance Whether to automatically apply a credit balance to an invoice.  If the value is &#x60;true&#x60;, the credit balance is applied to the invoice. If the value is &#x60;false&#x60;, no action is taken.   To view the credit balance adjustment, retrieve the details of the invoice using the Get Invoices method.  Prerequisite: &#x60;invoice&#x60; must be &#x60;true&#x60;.   **Note:**    - If you are using the field &#x60;invoiceCollect&#x60; rather than the field &#x60;invoice&#x60;, the &#x60;invoiceCollect&#x60; value must be &#x60;true&#x60;.   - This field is deprecated if you have the Invoice Settlement feature enabled.  (optional)
         * @return Subscription0RequestBuilder
         */
        public Subscription0RequestBuilder applyCreditBalance(Boolean applyCreditBalance) {
            this.applyCreditBalance = applyCreditBalance;
            return this;
        }
        
        /**
         * Set autoRenew
         * @param autoRenew If &#x60;true&#x60;, this subscription automatically renews at the end of the subscription term. Default is &#x60;false&#x60;.  (optional)
         * @return Subscription0RequestBuilder
         */
        public Subscription0RequestBuilder autoRenew(Boolean autoRenew) {
            this.autoRenew = autoRenew;
            return this;
        }
        
        /**
         * Set bookingDate
         * @param bookingDate The booking date that you want to set for the contract when you change the &#x60;termType&#x60; field of the subscription and as a result get a new version of subscription created. The booking date of an amendment is the equivalent of the order date of an order. This field must be in the &#x60;yyyy-mm-dd&#x60; format. The default value is the current date when you make the API call.   (optional)
         * @return Subscription0RequestBuilder
         */
        public Subscription0RequestBuilder bookingDate(LocalDate bookingDate) {
            this.bookingDate = bookingDate;
            return this;
        }
        
        /**
         * Set change
         * @param change Use this field to change one or more rate plans - to replace the existing rate plans in a subscription with other rate plans.  **Note**: Changing rate plans is currently not supported for Billing - Revenue Integration. When Billing - Revenue Integration is enabled, changing rate plans will no longer be applicable in Zuora Billing.  (optional)
         * @return Subscription0RequestBuilder
         */
        public Subscription0RequestBuilder change(List<PUTSrpChangeType> change) {
            this.change = change;
            return this;
        }
        
        /**
         * Set collect
         * @param collect Collects an automatic payment for a subscription. The collection generated in this operation is only for this subscription, not for the entire customer account.  If the value is &#x60;true&#x60;, the automatic payment is collected. If the value is &#x60;false&#x60;, no action is taken.  Prerequisite: The &#x60;invoice&#x60; or &#x60;runBilling&#x60; field must be &#x60;true&#x60;.   **Note**: This field is only available if you set the &#x60;zuora-version&#x60; request header to &#x60;196.0&#x60; or later [available versions](https://developer.zuora.com/api-references/api/overview/#section/API-Versions/Minor-Version).  (optional, default to false)
         * @return Subscription0RequestBuilder
         */
        public Subscription0RequestBuilder collect(Boolean collect) {
            this.collect = collect;
            return this;
        }
        
        /**
         * Set creditMemoReasonCode
         * @param creditMemoReasonCode A code identifying the reason for the credit memo transaction that is generated by the request. The value must be an existing reason code. If you do not pass the field or pass the field with empty value, Zuora uses the default reason code. (optional)
         * @return Subscription0RequestBuilder
         */
        public Subscription0RequestBuilder creditMemoReasonCode(String creditMemoReasonCode) {
            this.creditMemoReasonCode = creditMemoReasonCode;
            return this;
        }
        
        /**
         * Set currentTerm
         * @param currentTerm The length of the period for the current subscription term. If &#x60;termType&#x60; is &#x60;TERMED&#x60;, this field is required and must be greater than &#x60;0&#x60;. If &#x60;termType&#x60; is &#x60;EVERGREEN&#x60;, this value is ignored.  (optional)
         * @return Subscription0RequestBuilder
         */
        public Subscription0RequestBuilder currentTerm(Long currentTerm) {
            this.currentTerm = currentTerm;
            return this;
        }
        
        /**
         * Set currentTermPeriodType
         * @param currentTermPeriodType The period type for the current subscription term.  This field is used with the &#x60;CurrentTerm&#x60; field to specify the current subscription term.  Values are:  * &#x60;Month&#x60; (default) * &#x60;Year&#x60; * &#x60;Day&#x60; * &#x60;Week&#x60;  (optional)
         * @return Subscription0RequestBuilder
         */
        public Subscription0RequestBuilder currentTermPeriodType(String currentTermPeriodType) {
            this.currentTermPeriodType = currentTermPeriodType;
            return this;
        }
        
        /**
         * Set documentDate
         * @param documentDate The date of the billing document, in &#x60;yyyy-mm-dd&#x60; format. It represents the invoice date for invoices, credit memo date for credit memos, and debit memo date for debit memos.  - If this field is specified, the specified date is used as the billing document date.  - If this field is not specified, the date specified in the &#x60;targetDate&#x60; is used as the billing document date.  (optional)
         * @return Subscription0RequestBuilder
         */
        public Subscription0RequestBuilder documentDate(LocalDate documentDate) {
            this.documentDate = documentDate;
            return this;
        }
        
        /**
         * Set externallyManagedBy
         * @param externallyManagedBy An enum field on the Subscription object to indicate the name of a third-party store. This field is used to represent subscriptions created through third-party stores.  (optional)
         * @return Subscription0RequestBuilder
         */
        public Subscription0RequestBuilder externallyManagedBy(String externallyManagedBy) {
            this.externallyManagedBy = externallyManagedBy;
            return this;
        }
        
        /**
         * Set includeExistingDraftDocItems
         * @param includeExistingDraftDocItems Specifies whether to include draft invoice items in subscription previews. Values are:  * &#x60;true&#x60; (default). Includes draft invoice items in the preview result. * &#x60;false&#x60;. Excludes draft invoice items in the preview result.  **Note:** This field is in Zuora REST API version control. Supported minor versions are 207.0 or later [available versions](https://developer.zuora.com/api-references/api/overview/#section/API-Versions/Minor-Version). To use this field in the method, you must set the **zuora-version** parameter to the minor version number in the request header.  (optional)
         * @return Subscription0RequestBuilder
         */
        public Subscription0RequestBuilder includeExistingDraftDocItems(Boolean includeExistingDraftDocItems) {
            this.includeExistingDraftDocItems = includeExistingDraftDocItems;
            return this;
        }
        
        /**
         * Set includeExistingDraftInvoiceItems
         * @param includeExistingDraftInvoiceItems Specifies whether to include draft invoice items in subscription previews. Values are:  * &#x60;true&#x60; (default). Includes draft invoice items in the preview result. * &#x60;false&#x60;. Excludes draft invoice items in the preview result.  **Note:** This field is in Zuora REST API version control. Supported minor versions are 186.0, 187.0, 188.0, 189.0, 196.0, and 206.0. .  (optional)
         * @return Subscription0RequestBuilder
         */
        public Subscription0RequestBuilder includeExistingDraftInvoiceItems(Boolean includeExistingDraftInvoiceItems) {
            this.includeExistingDraftInvoiceItems = includeExistingDraftInvoiceItems;
            return this;
        }
        
        /**
         * Set invoice
         * @param invoice **Note:** This field has been replaced by the &#x60;runBilling&#x60; field. The &#x60;invoice&#x60; field is only available for backward compatibility.   Creates an invoice for a subscription. The invoice generated in this operation is only for this subscription, not for the entire customer account.   If the value is &#x60;true&#x60;, an invoice is created. If the value is &#x60;false&#x60;, no action is taken. The default value is &#x60;false&#x60;.    This field is in Zuora REST API version control. Supported minor versions are &#x60;196.0&#x60; and &#x60;207.0&#x60;. To use this field in the method, you must set the zuora-version parameter to the minor version number in the request header.  (optional)
         * @return Subscription0RequestBuilder
         */
        public Subscription0RequestBuilder invoice(Boolean invoice) {
            this.invoice = invoice;
            return this;
        }
        
        /**
         * Set invoiceCollect
         * @param invoiceCollect **Note:** This field has been replaced by the &#x60;invoice&#x60; field and the &#x60;collect&#x60; field. &#x60;invoiceCollect&#x60; is available only for backward compatibility.   If &#x60;true&#x60;, an invoice is generated and payment collected automatically during the subscription process. If &#x60;false&#x60;, no invoicing or payment takes place.  The invoice generated in this operation is only for this subscription, not for the entire customer account.  **Note**: This field is only available if you set the &#x60;zuora-version&#x60; request header to &#x60;186.0&#x60;, &#x60;187.0&#x60;, &#x60;188.0&#x60;, or &#x60;189.0&#x60;.  (optional, default to false)
         * @return Subscription0RequestBuilder
         */
        public Subscription0RequestBuilder invoiceCollect(Boolean invoiceCollect) {
            this.invoiceCollect = invoiceCollect;
            return this;
        }
        
        /**
         * Set invoiceSeparately
         * @param invoiceSeparately Separates a single subscription from other subscriptions and invoices the charge independently.   If the value is &#x60;true&#x60;, the subscription is billed separately from other subscriptions. If the value is &#x60;false&#x60;, the subscription is included with other subscriptions in the account invoice.  The default value is &#x60;false&#x60;. Prerequisite: The default subscription setting Enable Subscriptions to be Invoiced Separately must be set to Yes.  (optional)
         * @return Subscription0RequestBuilder
         */
        public Subscription0RequestBuilder invoiceSeparately(Boolean invoiceSeparately) {
            this.invoiceSeparately = invoiceSeparately;
            return this;
        }
        
        /**
         * Set invoiceTargetDate
         * @param invoiceTargetDate **Note:** This field has been replaced by the &#x60;targetDate&#x60; field. The &#x60;invoiceTargetDate&#x60; field is only available for backward compatibility.   Date through which to calculate charges if an invoice is generated, as yyyy-mm-dd. Default is current date.   This field is in Zuora REST API version control. Supported minor versions are &#x60;207.0&#x60; and earlier [available versions](https://developer.zuora.com/api-references/api/overview/#section/API-Versions/Minor-Version).  (optional)
         * @return Subscription0RequestBuilder
         */
        public Subscription0RequestBuilder invoiceTargetDate(LocalDate invoiceTargetDate) {
            this.invoiceTargetDate = invoiceTargetDate;
            return this;
        }
        
        /**
         * Set notes
         * @param notes String of up to 500 characters.  (optional)
         * @return Subscription0RequestBuilder
         */
        public Subscription0RequestBuilder notes(String notes) {
            this.notes = notes;
            return this;
        }
        
        /**
         * Set preview
         * @param preview If &#x60;true&#x60; the update is made in preview mode. The default setting is &#x60;false&#x60;.  (optional)
         * @return Subscription0RequestBuilder
         */
        public Subscription0RequestBuilder preview(Boolean preview) {
            this.preview = preview;
            return this;
        }
        
        /**
         * Set previewType
         * @param previewType The type of preview you will receive.   This field is in Zuora REST API version control. The supported values of this field depend on the REST API minor version you specified in the request header.   * If you do not specify the REST API minor version or specify the minor version number to one of following values in the request header:    * 186.0   * 187.0   * 188.0   * 189.0   * 196.0   * 206.0    The following values are supported in the **previewType** field:    * InvoiceItem   * ChargeMetrics   * InvoiceItemChargeMetrics    The default value is InvoiceItem.  * If you specify the REST API minor version to 207.0 or later [available versions](https://developer.zuora.com/api-references/api/overview/#section/API-Versions/Minor-Version) in the request header, the following values are supported in the **previewType** field:    - LegalDoc   - ChargeMetrics   - LegalDocChargeMetrics    The default value is LegalDoc.  .  (optional)
         * @return Subscription0RequestBuilder
         */
        public Subscription0RequestBuilder previewType(String previewType) {
            this.previewType = previewType;
            return this;
        }
        
        /**
         * Set remove
         * @param remove Container for removing one or more rate plans.  (optional)
         * @return Subscription0RequestBuilder
         */
        public Subscription0RequestBuilder remove(List<PUTSrpRemoveType> remove) {
            this.remove = remove;
            return this;
        }
        
        /**
         * Set renewalSetting
         * @param renewalSetting Specifies whether a termed subscription will remain &#x60;TERMED&#x60; or change to &#x60;EVERGREEN&#x60; when it is renewed.   Values are:  * &#x60;RENEW_WITH_SPECIFIC_TERM&#x60; (default) * &#x60;RENEW_TO_EVERGREEN&#x60;  (optional)
         * @return Subscription0RequestBuilder
         */
        public Subscription0RequestBuilder renewalSetting(String renewalSetting) {
            this.renewalSetting = renewalSetting;
            return this;
        }
        
        /**
         * Set renewalTerm
         * @param renewalTerm The length of the period for the subscription renewal term. Default is &#x60;0&#x60;.  (optional)
         * @return Subscription0RequestBuilder
         */
        public Subscription0RequestBuilder renewalTerm(Long renewalTerm) {
            this.renewalTerm = renewalTerm;
            return this;
        }
        
        /**
         * Set renewalTermPeriodType
         * @param renewalTermPeriodType  The period type for the subscription renewal term.  This field is used with the &#x60;renewalTerm&#x60; field to specify the subscription renewal term.  Values are:  * &#x60;Month&#x60; (default) * &#x60;Year&#x60; * &#x60;Day&#x60; * &#x60;Week&#x60;  (optional)
         * @return Subscription0RequestBuilder
         */
        public Subscription0RequestBuilder renewalTermPeriodType(String renewalTermPeriodType) {
            this.renewalTermPeriodType = renewalTermPeriodType;
            return this;
        }
        
        /**
         * Set runBilling
         * @param runBilling Creates an invoice for a subscription. If you have the Invoice Settlement feature enabled, a credit memo might also be created based on the [invoice and credit memo generation rule](https://knowledgecenter.zuora.com/CB_Billing/Invoice_Settlement/Credit_and_Debit_Memos/Rules_for_Generating_Invoices_and_Credit_Memos).     The billing documents generated in this operation is only for this subscription, not for the entire customer account.   Possible values:  - &#x60;true&#x60;: An invoice is created. If you have the Invoice Settlement feature enabled, a credit memo might also be created.   - &#x60;false&#x60;: No invoice is created.   **Note:** This field is in Zuora REST API version control. Supported minor versions are &#x60;211.0&#x60; or later [available versions](https://developer.zuora.com/api-references/api/overview/#section/API-Versions/Minor-Version). To use this field in the method, you must set the &#x60;zuora-version&#x60; parameter to the minor version number in the request header.  (optional, default to false)
         * @return Subscription0RequestBuilder
         */
        public Subscription0RequestBuilder runBilling(Boolean runBilling) {
            this.runBilling = runBilling;
            return this;
        }
        
        /**
         * Set targetDate
         * @param targetDate Date through which to calculate charges if an invoice or a credit memo is generated, as yyyy-mm-dd. Default is current date.   **Note:** The credit memo is only available if you have the Invoice Settlement feature enabled.   This field is in Zuora REST API version control. Supported minor versions are &#x60;211.0&#x60; and later. To use this field in the method, you must set the  &#x60;zuora-version&#x60; parameter to the minor version number in the request header.  (optional)
         * @return Subscription0RequestBuilder
         */
        public Subscription0RequestBuilder targetDate(LocalDate targetDate) {
            this.targetDate = targetDate;
            return this;
        }
        
        /**
         * Set termStartDate
         * @param termStartDate Date the subscription term begins, as yyyy-mm-dd. If this is a renewal subscription, this date is different from the subscription start date.   (optional)
         * @return Subscription0RequestBuilder
         */
        public Subscription0RequestBuilder termStartDate(LocalDate termStartDate) {
            this.termStartDate = termStartDate;
            return this;
        }
        
        /**
         * Set termType
         * @param termType Possible values are: &#x60;TERMED&#x60;, &#x60;EVERGREEN&#x60;.  (optional)
         * @return Subscription0RequestBuilder
         */
        public Subscription0RequestBuilder termType(String termType) {
            this.termType = termType;
            return this;
        }
        
        /**
         * Set update
         * @param update Container for updating one or more rate plans.  (optional)
         * @return Subscription0RequestBuilder
         */
        public Subscription0RequestBuilder update(List<PUTSrpUpdateType> update) {
            this.update = update;
            return this;
        }
        
        /**
         * Set cpqBundleJsonIdQT
         * @param cpqBundleJsonIdQT The Bundle product structures from Zuora Quotes if you utilize Bundling in Salesforce. Do not change the value in this field.  (optional)
         * @return Subscription0RequestBuilder
         */
        public Subscription0RequestBuilder cpqBundleJsonIdQT(String cpqBundleJsonIdQT) {
            this.cpqBundleJsonIdQT = cpqBundleJsonIdQT;
            return this;
        }
        
        /**
         * Set opportunityCloseDateQT
         * @param opportunityCloseDateQT The closing date of the Opportunity. This field is used in Zuora data sources to report on Subscription metrics. If the subscription originated from Zuora Quotes, the value is populated with the value from Zuora Quotes.  (optional)
         * @return Subscription0RequestBuilder
         */
        public Subscription0RequestBuilder opportunityCloseDateQT(LocalDate opportunityCloseDateQT) {
            this.opportunityCloseDateQT = opportunityCloseDateQT;
            return this;
        }
        
        /**
         * Set opportunityNameQT
         * @param opportunityNameQT The unique identifier of the Opportunity. This field is used in Zuora data sources to report on Subscription metrics. If the subscription originated from Zuora Quotes, the value is populated with the value from Zuora Quotes.  (optional)
         * @return Subscription0RequestBuilder
         */
        public Subscription0RequestBuilder opportunityNameQT(String opportunityNameQT) {
            this.opportunityNameQT = opportunityNameQT;
            return this;
        }
        
        /**
         * Set quoteBusinessTypeQT
         * @param quoteBusinessTypeQT The specific identifier for the type of business transaction the Quote represents such as New, Upsell, Downsell, Renewal or Churn. This field is used in Zuora data sources to report on Subscription metrics. If the subscription originated from Zuora Quotes, the value is populated with the value from Zuora Quotes.  (optional)
         * @return Subscription0RequestBuilder
         */
        public Subscription0RequestBuilder quoteBusinessTypeQT(String quoteBusinessTypeQT) {
            this.quoteBusinessTypeQT = quoteBusinessTypeQT;
            return this;
        }
        
        /**
         * Set quoteNumberQT
         * @param quoteNumberQT The unique identifier of the Quote. This field is used in Zuora data sources to report on Subscription metrics. If the subscription originated from Zuora Quotes, the value is populated with the value from Zuora Quotes.  (optional)
         * @return Subscription0RequestBuilder
         */
        public Subscription0RequestBuilder quoteNumberQT(String quoteNumberQT) {
            this.quoteNumberQT = quoteNumberQT;
            return this;
        }
        
        /**
         * Set quoteTypeQT
         * @param quoteTypeQT The Quote type that represents the subscription lifecycle stage such as New, Amendment, Renew or Cancel. This field is used in Zuora data sources to report on Subscription metrics. If the subscription originated from Zuora Quotes, the value is populated with the value from Zuora Quotes.  (optional)
         * @return Subscription0RequestBuilder
         */
        public Subscription0RequestBuilder quoteTypeQT(String quoteTypeQT) {
            this.quoteTypeQT = quoteTypeQT;
            return this;
        }
        
        /**
         * Set integrationIdNS
         * @param integrationIdNS ID of the corresponding object in NetSuite. Only available if you have installed the [Zuora Connector for NetSuite](https://www.zuora.com/connect/app/?appId&#x3D;265).  (optional)
         * @return Subscription0RequestBuilder
         */
        public Subscription0RequestBuilder integrationIdNS(String integrationIdNS) {
            this.integrationIdNS = integrationIdNS;
            return this;
        }
        
        /**
         * Set integrationStatusNS
         * @param integrationStatusNS Status of the subscription&#39;s synchronization with NetSuite. Only available if you have installed the [Zuora Connector for NetSuite](https://www.zuora.com/connect/app/?appId&#x3D;265).  (optional)
         * @return Subscription0RequestBuilder
         */
        public Subscription0RequestBuilder integrationStatusNS(String integrationStatusNS) {
            this.integrationStatusNS = integrationStatusNS;
            return this;
        }
        
        /**
         * Set projectNS
         * @param projectNS The NetSuite project that the subscription was created from. Only available if you have installed the [Zuora Connector for NetSuite](https://www.zuora.com/connect/app/?appId&#x3D;265).  (optional)
         * @return Subscription0RequestBuilder
         */
        public Subscription0RequestBuilder projectNS(String projectNS) {
            this.projectNS = projectNS;
            return this;
        }
        
        /**
         * Set salesOrderNS
         * @param salesOrderNS The NetSuite sales order than the subscription was created from. Only available if you have installed the [Zuora Connector for NetSuite](https://www.zuora.com/connect/app/?appId&#x3D;265).  (optional)
         * @return Subscription0RequestBuilder
         */
        public Subscription0RequestBuilder salesOrderNS(String salesOrderNS) {
            this.salesOrderNS = salesOrderNS;
            return this;
        }
        
        /**
         * Set syncDateNS
         * @param syncDateNS Date when the subscription was synchronized with NetSuite. Only available if you have installed the [Zuora Connector for NetSuite](https://www.zuora.com/connect/app/?appId&#x3D;265).  (optional)
         * @return Subscription0RequestBuilder
         */
        public Subscription0RequestBuilder syncDateNS(String syncDateNS) {
            this.syncDateNS = syncDateNS;
            return this;
        }
        
        /**
         * Set acceptEncoding
         * @param acceptEncoding Include the &#x60;Accept-Encoding: gzip&#x60; header to compress responses as a gzipped file. It can significantly reduce the bandwidth required for a response.   If specified, Zuora automatically compresses responses that contain over 1000 bytes of data, and the response contains a &#x60;Content-Encoding&#x60; header with the compression algorithm so that your client can decompress it.  (optional)
         * @return Subscription0RequestBuilder
         */
        public Subscription0RequestBuilder acceptEncoding(String acceptEncoding) {
            this.acceptEncoding = acceptEncoding;
            return this;
        }
        
        /**
         * Set contentEncoding
         * @param contentEncoding Include the &#x60;Content-Encoding: gzip&#x60; header to compress a request. With this header specified, you should upload a gzipped file for the request payload instead of sending the JSON payload.  (optional)
         * @return Subscription0RequestBuilder
         */
        public Subscription0RequestBuilder contentEncoding(String contentEncoding) {
            this.contentEncoding = contentEncoding;
            return this;
        }
        
        /**
         * Set authorization
         * @param authorization The value is in the &#x60;Bearer {token}&#x60; format where {token} is a valid OAuth token generated by calling [Create an OAuth token](https://developer.zuora.com/api-references/api/operation/createToken).  (optional)
         * @return Subscription0RequestBuilder
         */
        public Subscription0RequestBuilder authorization(String authorization) {
            this.authorization = authorization;
            return this;
        }
        
        /**
         * Set zuoraTrackId
         * @param zuoraTrackId A custom identifier for tracing the API call. If you set a value for this header, Zuora returns the same value in the response headers. This header enables you to associate your system process identifiers with Zuora API calls, to assist with troubleshooting in the event of an issue.  The value of this field must use the US-ASCII character set and must not include any of the following characters: colon (&#x60;:&#x60;), semicolon (&#x60;;&#x60;), double quote (&#x60;\&quot;&#x60;), and quote (&#x60;&#39;&#x60;).  (optional)
         * @return Subscription0RequestBuilder
         */
        public Subscription0RequestBuilder zuoraTrackId(String zuoraTrackId) {
            this.zuoraTrackId = zuoraTrackId;
            return this;
        }
        
        /**
         * Set zuoraEntityIds
         * @param zuoraEntityIds An entity ID. If you have [Zuora Multi-entity](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Multi-entity) enabled and the OAuth token is valid for more than one entity, you must use this header to specify which entity to perform the operation in. If the OAuth token is only valid for a single entity, or you do not have Zuora Multi-entity enabled, you do not need to set this header.  (optional)
         * @return Subscription0RequestBuilder
         */
        public Subscription0RequestBuilder zuoraEntityIds(String zuoraEntityIds) {
            this.zuoraEntityIds = zuoraEntityIds;
            return this;
        }
        
        /**
         * Set zuoraOrgIds
         * @param zuoraOrgIds Comma separated IDs. If you have &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Central_Platform/Multi-Org\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Zuora Multi-Org&lt;/a&gt; enabled,  you can use this header to specify which orgs to perform the operation in. If you do not have Zuora Multi-Org enabled, you should not set this header.  The IDs must be a sub-set of the user&#39;s accessible orgs. If you specify an org that the user does not have access to, the operation fails.  If the header is not set, the operation is performed in scope of the user&#39;s accessible orgs.  (optional)
         * @return Subscription0RequestBuilder
         */
        public Subscription0RequestBuilder zuoraOrgIds(String zuoraOrgIds) {
            this.zuoraOrgIds = zuoraOrgIds;
            return this;
        }
        
        /**
         * Set zuoraVersion
         * @param zuoraVersion  The minor version of the Zuora REST API.   You need to set this parameter if you use the following fields: * collect * invoice * includeExistingDraftDocItems * previewType * runBilling * targetDate * taxationItems   If you have the Invoice Settlement feature enabled, you need to specify this parameter. Otherwise, an error is returned.   See [Zuora REST API Versions](https://developer.zuora.com/api-references/api/overview/#section/API-Versions) for more information.  (optional)
         * @return Subscription0RequestBuilder
         */
        public Subscription0RequestBuilder zuoraVersion(String zuoraVersion) {
            this.zuoraVersion = zuoraVersion;
            return this;
        }
        
        /**
         * Build call for subscription_0
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
            PUTSubscriptionType puTSubscriptionType = buildBodyParams();
            return subscription_0Call(subscriptionKey, puTSubscriptionType, acceptEncoding, contentEncoding, authorization, zuoraTrackId, zuoraEntityIds, zuoraOrgIds, zuoraVersion, _callback);
        }

        private PUTSubscriptionType buildBodyParams() {
            return this.puTSubscriptionType;
        }

        /**
         * Execute subscription_0 request
         * @return PUTSubscriptionResponseType
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td>  </td><td>  * Content-Encoding - This header is returned if you specify the &#x60;Accept-Encoding: gzip&#x60; request header and the response contains over 1000 bytes of data. Note that only the following MIME types support gzipped responses:   - &#x60;application/json&#x60;   - &#x60;application/xml&#x60;   - &#x60;text/html&#x60;   - &#x60;text/csv&#x60;   - &#x60;text/plain&#x60;  <br>  * RateLimit-Limit - The request limit quota for the time window closest to exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Remaining - The number of requests remaining in the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Reset - The number of seconds until the quota resets for the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Zuora-Request-Id - The Zuora internal identifier of the API call. You cannot control the value of this header.  <br>  * Zuora-Track-Id - A custom identifier for tracing the API call. If you specified a tracing identifier in the request headers, Zuora returns the same tracing identifier. Otherwise, Zuora does not set this header.  <br>  </td></tr>
         </table>
         */
        public PUTSubscriptionResponseType execute() throws ApiException {
            PUTSubscriptionType puTSubscriptionType = buildBodyParams();
            ApiResponse<PUTSubscriptionResponseType> localVarResp = subscription_0WithHttpInfo(subscriptionKey, puTSubscriptionType, acceptEncoding, contentEncoding, authorization, zuoraTrackId, zuoraEntityIds, zuoraOrgIds, zuoraVersion);
            return localVarResp.getResponseBody();
        }

        /**
         * Execute subscription_0 request with HTTP info returned
         * @return ApiResponse&lt;PUTSubscriptionResponseType&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td>  </td><td>  * Content-Encoding - This header is returned if you specify the &#x60;Accept-Encoding: gzip&#x60; request header and the response contains over 1000 bytes of data. Note that only the following MIME types support gzipped responses:   - &#x60;application/json&#x60;   - &#x60;application/xml&#x60;   - &#x60;text/html&#x60;   - &#x60;text/csv&#x60;   - &#x60;text/plain&#x60;  <br>  * RateLimit-Limit - The request limit quota for the time window closest to exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Remaining - The number of requests remaining in the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Reset - The number of seconds until the quota resets for the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Zuora-Request-Id - The Zuora internal identifier of the API call. You cannot control the value of this header.  <br>  * Zuora-Track-Id - A custom identifier for tracing the API call. If you specified a tracing identifier in the request headers, Zuora returns the same tracing identifier. Otherwise, Zuora does not set this header.  <br>  </td></tr>
         </table>
         */
        public ApiResponse<PUTSubscriptionResponseType> executeWithHttpInfo() throws ApiException {
            PUTSubscriptionType puTSubscriptionType = buildBodyParams();
            return subscription_0WithHttpInfo(subscriptionKey, puTSubscriptionType, acceptEncoding, contentEncoding, authorization, zuoraTrackId, zuoraEntityIds, zuoraOrgIds, zuoraVersion);
        }

        /**
         * Execute subscription_0 request (asynchronously)
         * @param _callback The callback to be executed when the API call finishes
         * @return The request call
         * @throws ApiException If fail to process the API call, e.g. serializing the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td>  </td><td>  * Content-Encoding - This header is returned if you specify the &#x60;Accept-Encoding: gzip&#x60; request header and the response contains over 1000 bytes of data. Note that only the following MIME types support gzipped responses:   - &#x60;application/json&#x60;   - &#x60;application/xml&#x60;   - &#x60;text/html&#x60;   - &#x60;text/csv&#x60;   - &#x60;text/plain&#x60;  <br>  * RateLimit-Limit - The request limit quota for the time window closest to exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Remaining - The number of requests remaining in the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Reset - The number of seconds until the quota resets for the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Zuora-Request-Id - The Zuora internal identifier of the API call. You cannot control the value of this header.  <br>  * Zuora-Track-Id - A custom identifier for tracing the API call. If you specified a tracing identifier in the request headers, Zuora returns the same tracing identifier. Otherwise, Zuora does not set this header.  <br>  </td></tr>
         </table>
         */
        public okhttp3.Call executeAsync(final ApiCallback<PUTSubscriptionResponseType> _callback) throws ApiException {
            PUTSubscriptionType puTSubscriptionType = buildBodyParams();
            return subscription_0Async(subscriptionKey, puTSubscriptionType, acceptEncoding, contentEncoding, authorization, zuoraTrackId, zuoraEntityIds, zuoraOrgIds, zuoraVersion, _callback);
        }
    }

    /**
     * Update a subscription
     * Use this call to make the following kinds of changes to a subscription:   * Add a note   * Change the renewal term or auto-renewal flag   * Change the term length or change between evergreen and termed   * Add a new product rate plan   * Remove an existing subscription rate plan   * Change the quantity or price of an existing subscription rate plan   * Change rate plans - to replace the existing rate plans in a subscription with other rate plans. Changing rate plans is currently not supported for Billing - Revenue Integration. When Billing - Revenue Integration is enabled, changing rate plans will no longer be applicable in Zuora Billing.  ### Notes * The \&quot;Update a subscription\&quot; call creates a new subscription object that has a new version number and to which the subscription changes are applied. The new subscription object has the same subscription name but a new, different, subscription ID. The &#x60;Status&#x60; field of the new subscription object will be set to &#x60;Active&#x60; unless the change applied was a cancelation or suspension in which case the status reflects that. The &#x60;Status&#x60; field of the originating subscription object changes from &#x60;Active&#x60; to &#x60;Expired&#x60;. A status of &#x60;Expired&#x60; does not imply that the subscription itself has expired or ended, merely that this subscription object is no longer the most recent. * In one request, this call can make:   * Up to 9 combined add, update, and remove changes   * No more than 1 change to terms &amp; conditions * Updates are performed in the following sequence:   1. First change the notes on the existing subscription, if requested.   2. Then change the terms and conditions, if requested.   3. Then perform the remaining amendments based upon the effective dates specified. If multiple amendments have the same contract-effective dates, then execute adds before updates, and updates before removes. * The update operation is atomic. If any of the updates fails, the entire operation is rolled back. * The response of the Update Subscription call is based on the REST API minor version you set in the request header. The response structure might be different if you use different minor version numbers.  * If you have the Invoice Settlement feature enabled, it is best practice to set the &#x60;zuora-version&#x60; parameter to &#x60;211.0&#x60; or later [available versions](https://developer.zuora.com/api-references/api/overview/#section/API-Versions/Minor-Version). Otherwise, an error occurs.  ### Override a Tiered Price There are two ways you override a tiered price:  * Override a specific tier number For example: &#x60;tiers[{tier:1,price:8},{tier:2,price:6}]&#x60;  * Override the entire tier structure For example:  &#x60;tiers[{tier:1,price:8,startingUnit:1,endingUnit:100,priceFormat:\&quot;FlatFee\&quot;}, {tier:2,price:6,startingUnit:101,priceFormat:\&quot;FlatFee\&quot;}]&#x60;  If you just override a specific tier, do not include the &#x60;startingUnit&#x60; field in the request. 
     * @param subscriptionKey  Subscription number or ID.  ID can be the latest version or any history version of ID.  * To make sure you update the last version of the subscription, use one of the following operations to retrieve the last version of ID:   * [List subscriptions by account key](https://developer.zuora.com/api-references/api/operation/GET_SubscriptionsByAccount)   * [Retrieve a subscription by key](https://developer.zuora.com/api-references/api/operation/GET_SubscriptionsByKey) by using the subscription number as the subscription-key * If you want to use any history version of ID, the &#x60;STABLE_ID_PUBLIC_API&#x60; permission must be enabled. Submit a request at [Zuora Global Support](http://support.zuora.com/) to enable the permission. To retrieve a history version of ID, use the [Retrieve a subscription by key and version](https://developer.zuora.com/api-references/api/operation/GET_SubscriptionsByKeyAndVersion) operation.  (required)
     * @param puTSubscriptionType  (required)
     * @return Subscription0RequestBuilder
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td>  </td><td>  * Content-Encoding - This header is returned if you specify the &#x60;Accept-Encoding: gzip&#x60; request header and the response contains over 1000 bytes of data. Note that only the following MIME types support gzipped responses:   - &#x60;application/json&#x60;   - &#x60;application/xml&#x60;   - &#x60;text/html&#x60;   - &#x60;text/csv&#x60;   - &#x60;text/plain&#x60;  <br>  * RateLimit-Limit - The request limit quota for the time window closest to exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Remaining - The number of requests remaining in the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Reset - The number of seconds until the quota resets for the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Zuora-Request-Id - The Zuora internal identifier of the API call. You cannot control the value of this header.  <br>  * Zuora-Track-Id - A custom identifier for tracing the API call. If you specified a tracing identifier in the request headers, Zuora returns the same tracing identifier. Otherwise, Zuora does not set this header.  <br>  </td></tr>
     </table>
     */
    public Subscription0RequestBuilder subscription_0(String subscriptionKey) throws IllegalArgumentException {
        if (subscriptionKey == null) throw new IllegalArgumentException("\"subscriptionKey\" is required but got null");
            

        return new Subscription0RequestBuilder(subscriptionKey);
    }
    private okhttp3.Call subscriptionsByAccountCall(String accountKey, String acceptEncoding, String contentEncoding, String authorization, String zuoraTrackId, String zuoraEntityIds, String zuoraOrgIds, Integer page, Integer pageSize, String chargeDetail, Boolean excludeRatePlansWithNoCharges, final ApiCallback _callback) throws ApiException {
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
        String localVarPath = "/v1/subscriptions/accounts/{account-key}"
            .replace("{" + "account-key" + "}", localVarApiClient.escapeString(accountKey.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        if (page != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("page", page));
        }

        if (pageSize != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("pageSize", pageSize));
        }

        if (chargeDetail != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("charge-detail", chargeDetail));
        }

        if (excludeRatePlansWithNoCharges != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("exclude-rate-plans-with-no-charges", excludeRatePlansWithNoCharges));
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
    private okhttp3.Call subscriptionsByAccountValidateBeforeCall(String accountKey, String acceptEncoding, String contentEncoding, String authorization, String zuoraTrackId, String zuoraEntityIds, String zuoraOrgIds, Integer page, Integer pageSize, String chargeDetail, Boolean excludeRatePlansWithNoCharges, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'accountKey' is set
        if (accountKey == null) {
            throw new ApiException("Missing the required parameter 'accountKey' when calling subscriptionsByAccount(Async)");
        }

        return subscriptionsByAccountCall(accountKey, acceptEncoding, contentEncoding, authorization, zuoraTrackId, zuoraEntityIds, zuoraOrgIds, page, pageSize, chargeDetail, excludeRatePlansWithNoCharges, _callback);

    }


    private ApiResponse<GETSubscriptionWrapper> subscriptionsByAccountWithHttpInfo(String accountKey, String acceptEncoding, String contentEncoding, String authorization, String zuoraTrackId, String zuoraEntityIds, String zuoraOrgIds, Integer page, Integer pageSize, String chargeDetail, Boolean excludeRatePlansWithNoCharges) throws ApiException {
        okhttp3.Call localVarCall = subscriptionsByAccountValidateBeforeCall(accountKey, acceptEncoding, contentEncoding, authorization, zuoraTrackId, zuoraEntityIds, zuoraOrgIds, page, pageSize, chargeDetail, excludeRatePlansWithNoCharges, null);
        Type localVarReturnType = new TypeToken<GETSubscriptionWrapper>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    private okhttp3.Call subscriptionsByAccountAsync(String accountKey, String acceptEncoding, String contentEncoding, String authorization, String zuoraTrackId, String zuoraEntityIds, String zuoraOrgIds, Integer page, Integer pageSize, String chargeDetail, Boolean excludeRatePlansWithNoCharges, final ApiCallback<GETSubscriptionWrapper> _callback) throws ApiException {

        okhttp3.Call localVarCall = subscriptionsByAccountValidateBeforeCall(accountKey, acceptEncoding, contentEncoding, authorization, zuoraTrackId, zuoraEntityIds, zuoraOrgIds, page, pageSize, chargeDetail, excludeRatePlansWithNoCharges, _callback);
        Type localVarReturnType = new TypeToken<GETSubscriptionWrapper>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    public class SubscriptionsByAccountRequestBuilder {
        private final String accountKey;
        private String acceptEncoding;
        private String contentEncoding;
        private String authorization;
        private String zuoraTrackId;
        private String zuoraEntityIds;
        private String zuoraOrgIds;
        private Integer page;
        private Integer pageSize;
        private String chargeDetail;
        private Boolean excludeRatePlansWithNoCharges;

        private SubscriptionsByAccountRequestBuilder(String accountKey) {
            this.accountKey = accountKey;
        }

        /**
         * Set acceptEncoding
         * @param acceptEncoding Include the &#x60;Accept-Encoding: gzip&#x60; header to compress responses as a gzipped file. It can significantly reduce the bandwidth required for a response.   If specified, Zuora automatically compresses responses that contain over 1000 bytes of data, and the response contains a &#x60;Content-Encoding&#x60; header with the compression algorithm so that your client can decompress it.  (optional)
         * @return SubscriptionsByAccountRequestBuilder
         */
        public SubscriptionsByAccountRequestBuilder acceptEncoding(String acceptEncoding) {
            this.acceptEncoding = acceptEncoding;
            return this;
        }
        
        /**
         * Set contentEncoding
         * @param contentEncoding Include the &#x60;Content-Encoding: gzip&#x60; header to compress a request. With this header specified, you should upload a gzipped file for the request payload instead of sending the JSON payload.  (optional)
         * @return SubscriptionsByAccountRequestBuilder
         */
        public SubscriptionsByAccountRequestBuilder contentEncoding(String contentEncoding) {
            this.contentEncoding = contentEncoding;
            return this;
        }
        
        /**
         * Set authorization
         * @param authorization The value is in the &#x60;Bearer {token}&#x60; format where {token} is a valid OAuth token generated by calling [Create an OAuth token](https://developer.zuora.com/api-references/api/operation/createToken).  (optional)
         * @return SubscriptionsByAccountRequestBuilder
         */
        public SubscriptionsByAccountRequestBuilder authorization(String authorization) {
            this.authorization = authorization;
            return this;
        }
        
        /**
         * Set zuoraTrackId
         * @param zuoraTrackId A custom identifier for tracing the API call. If you set a value for this header, Zuora returns the same value in the response headers. This header enables you to associate your system process identifiers with Zuora API calls, to assist with troubleshooting in the event of an issue.  The value of this field must use the US-ASCII character set and must not include any of the following characters: colon (&#x60;:&#x60;), semicolon (&#x60;;&#x60;), double quote (&#x60;\&quot;&#x60;), and quote (&#x60;&#39;&#x60;).  (optional)
         * @return SubscriptionsByAccountRequestBuilder
         */
        public SubscriptionsByAccountRequestBuilder zuoraTrackId(String zuoraTrackId) {
            this.zuoraTrackId = zuoraTrackId;
            return this;
        }
        
        /**
         * Set zuoraEntityIds
         * @param zuoraEntityIds An entity ID. If you have [Zuora Multi-entity](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Multi-entity) enabled and the OAuth token is valid for more than one entity, you must use this header to specify which entity to perform the operation in. If the OAuth token is only valid for a single entity, or you do not have Zuora Multi-entity enabled, you do not need to set this header.  (optional)
         * @return SubscriptionsByAccountRequestBuilder
         */
        public SubscriptionsByAccountRequestBuilder zuoraEntityIds(String zuoraEntityIds) {
            this.zuoraEntityIds = zuoraEntityIds;
            return this;
        }
        
        /**
         * Set zuoraOrgIds
         * @param zuoraOrgIds Comma separated IDs. If you have &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Central_Platform/Multi-Org\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Zuora Multi-Org&lt;/a&gt; enabled,  you can use this header to specify which orgs to perform the operation in. If you do not have Zuora Multi-Org enabled, you should not set this header.  The IDs must be a sub-set of the user&#39;s accessible orgs. If you specify an org that the user does not have access to, the operation fails.  If the header is not set, the operation is performed in scope of the user&#39;s accessible orgs.  (optional)
         * @return SubscriptionsByAccountRequestBuilder
         */
        public SubscriptionsByAccountRequestBuilder zuoraOrgIds(String zuoraOrgIds) {
            this.zuoraOrgIds = zuoraOrgIds;
            return this;
        }
        
        /**
         * Set page
         * @param page The index number of the page that you want to retrieve. This parameter is dependent on &#x60;pageSize&#x60;. You must set &#x60;pageSize&#x60; before specifying &#x60;page&#x60;. For example, if you set &#x60;pageSize&#x60; to &#x60;20&#x60; and &#x60;page&#x60; to &#x60;2&#x60;, the 21st to 40th records are returned in the response.  (optional, default to 1)
         * @return SubscriptionsByAccountRequestBuilder
         */
        public SubscriptionsByAccountRequestBuilder page(Integer page) {
            this.page = page;
            return this;
        }
        
        /**
         * Set pageSize
         * @param pageSize The number of records returned per page in the response.  (optional, default to 20)
         * @return SubscriptionsByAccountRequestBuilder
         */
        public SubscriptionsByAccountRequestBuilder pageSize(Integer pageSize) {
            this.pageSize = pageSize;
            return this;
        }
        
        /**
         * Set chargeDetail
         * @param chargeDetail The segmented rate plan charges.  When an amendment results in a change to a charge, Zuora creates a segmented rate plan charge. Use this field to track segment charges.  Possible values are:  * __last-segment__: (Default) The last rate plan charge on the subscription. The last rate plan charge is the last one in the order of time on the subscription rather than the most recent changed charge on the subscription.  * __current-segment__: The segmented charge that is active on today’s date (effectiveStartDate &lt;&#x3D; today’s date &lt; effectiveEndDate).    * __all-segments__: All the segmented charges. The &#x60;chargeSegments&#x60; field is returned in the response. The &#x60;chargeSegments&#x60; field contains an array of the charge information for all the charge segments.   * __specific-segment&amp;as-of-date&#x3D;date__: The segmented charge that is active on a date you specified (effectiveStartDate &lt;&#x3D; specific date &lt; effectiveEndDate). The format of the date is yyyy-mm-dd.  (optional)
         * @return SubscriptionsByAccountRequestBuilder
         */
        public SubscriptionsByAccountRequestBuilder chargeDetail(String chargeDetail) {
            this.chargeDetail = chargeDetail;
            return this;
        }
        
        /**
         * Set excludeRatePlansWithNoCharges
         * @param excludeRatePlansWithNoCharges If the &#x60;exclude-rate-plans-with-no-charges&#x60; is &#x60;true&#x60;, only the active charges and rate plans will be in the response. The default value is &#x60;false&#x60;.  (optional)
         * @return SubscriptionsByAccountRequestBuilder
         */
        public SubscriptionsByAccountRequestBuilder excludeRatePlansWithNoCharges(Boolean excludeRatePlansWithNoCharges) {
            this.excludeRatePlansWithNoCharges = excludeRatePlansWithNoCharges;
            return this;
        }
        
        /**
         * Build call for subscriptionsByAccount
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
            return subscriptionsByAccountCall(accountKey, acceptEncoding, contentEncoding, authorization, zuoraTrackId, zuoraEntityIds, zuoraOrgIds, page, pageSize, chargeDetail, excludeRatePlansWithNoCharges, _callback);
        }


        /**
         * Execute subscriptionsByAccount request
         * @return GETSubscriptionWrapper
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td>  </td><td>  * Content-Encoding - This header is returned if you specify the &#x60;Accept-Encoding: gzip&#x60; request header and the response contains over 1000 bytes of data. Note that only the following MIME types support gzipped responses:   - &#x60;application/json&#x60;   - &#x60;application/xml&#x60;   - &#x60;text/html&#x60;   - &#x60;text/csv&#x60;   - &#x60;text/plain&#x60;  <br>  * RateLimit-Limit - The request limit quota for the time window closest to exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Remaining - The number of requests remaining in the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Reset - The number of seconds until the quota resets for the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Zuora-Request-Id - The Zuora internal identifier of the API call. You cannot control the value of this header.  <br>  * Zuora-Track-Id - A custom identifier for tracing the API call. If you specified a tracing identifier in the request headers, Zuora returns the same tracing identifier. Otherwise, Zuora does not set this header.  <br>  </td></tr>
         </table>
         */
        public GETSubscriptionWrapper execute() throws ApiException {
            ApiResponse<GETSubscriptionWrapper> localVarResp = subscriptionsByAccountWithHttpInfo(accountKey, acceptEncoding, contentEncoding, authorization, zuoraTrackId, zuoraEntityIds, zuoraOrgIds, page, pageSize, chargeDetail, excludeRatePlansWithNoCharges);
            return localVarResp.getResponseBody();
        }

        /**
         * Execute subscriptionsByAccount request with HTTP info returned
         * @return ApiResponse&lt;GETSubscriptionWrapper&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td>  </td><td>  * Content-Encoding - This header is returned if you specify the &#x60;Accept-Encoding: gzip&#x60; request header and the response contains over 1000 bytes of data. Note that only the following MIME types support gzipped responses:   - &#x60;application/json&#x60;   - &#x60;application/xml&#x60;   - &#x60;text/html&#x60;   - &#x60;text/csv&#x60;   - &#x60;text/plain&#x60;  <br>  * RateLimit-Limit - The request limit quota for the time window closest to exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Remaining - The number of requests remaining in the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Reset - The number of seconds until the quota resets for the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Zuora-Request-Id - The Zuora internal identifier of the API call. You cannot control the value of this header.  <br>  * Zuora-Track-Id - A custom identifier for tracing the API call. If you specified a tracing identifier in the request headers, Zuora returns the same tracing identifier. Otherwise, Zuora does not set this header.  <br>  </td></tr>
         </table>
         */
        public ApiResponse<GETSubscriptionWrapper> executeWithHttpInfo() throws ApiException {
            return subscriptionsByAccountWithHttpInfo(accountKey, acceptEncoding, contentEncoding, authorization, zuoraTrackId, zuoraEntityIds, zuoraOrgIds, page, pageSize, chargeDetail, excludeRatePlansWithNoCharges);
        }

        /**
         * Execute subscriptionsByAccount request (asynchronously)
         * @param _callback The callback to be executed when the API call finishes
         * @return The request call
         * @throws ApiException If fail to process the API call, e.g. serializing the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td>  </td><td>  * Content-Encoding - This header is returned if you specify the &#x60;Accept-Encoding: gzip&#x60; request header and the response contains over 1000 bytes of data. Note that only the following MIME types support gzipped responses:   - &#x60;application/json&#x60;   - &#x60;application/xml&#x60;   - &#x60;text/html&#x60;   - &#x60;text/csv&#x60;   - &#x60;text/plain&#x60;  <br>  * RateLimit-Limit - The request limit quota for the time window closest to exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Remaining - The number of requests remaining in the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Reset - The number of seconds until the quota resets for the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Zuora-Request-Id - The Zuora internal identifier of the API call. You cannot control the value of this header.  <br>  * Zuora-Track-Id - A custom identifier for tracing the API call. If you specified a tracing identifier in the request headers, Zuora returns the same tracing identifier. Otherwise, Zuora does not set this header.  <br>  </td></tr>
         </table>
         */
        public okhttp3.Call executeAsync(final ApiCallback<GETSubscriptionWrapper> _callback) throws ApiException {
            return subscriptionsByAccountAsync(accountKey, acceptEncoding, contentEncoding, authorization, zuoraTrackId, zuoraEntityIds, zuoraOrgIds, page, pageSize, chargeDetail, excludeRatePlansWithNoCharges, _callback);
        }
    }

    /**
     * List subscriptions by account key
     * Retrieves all subscriptions associated with the specified account. Zuora only returns the latest version of the subscriptions.  Subscription data is returned in reverse chronological order based on &#x60;updatedDate&#x60;. Note that the rate plans inside the subscriptions are not sorted specifically and are returned in a random order. 
     * @param accountKey  Possible values are: * an account number * an account ID  (required)
     * @return SubscriptionsByAccountRequestBuilder
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td>  </td><td>  * Content-Encoding - This header is returned if you specify the &#x60;Accept-Encoding: gzip&#x60; request header and the response contains over 1000 bytes of data. Note that only the following MIME types support gzipped responses:   - &#x60;application/json&#x60;   - &#x60;application/xml&#x60;   - &#x60;text/html&#x60;   - &#x60;text/csv&#x60;   - &#x60;text/plain&#x60;  <br>  * RateLimit-Limit - The request limit quota for the time window closest to exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Remaining - The number of requests remaining in the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Reset - The number of seconds until the quota resets for the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Zuora-Request-Id - The Zuora internal identifier of the API call. You cannot control the value of this header.  <br>  * Zuora-Track-Id - A custom identifier for tracing the API call. If you specified a tracing identifier in the request headers, Zuora returns the same tracing identifier. Otherwise, Zuora does not set this header.  <br>  </td></tr>
     </table>
     */
    public SubscriptionsByAccountRequestBuilder subscriptionsByAccount(String accountKey) throws IllegalArgumentException {
        if (accountKey == null) throw new IllegalArgumentException("\"accountKey\" is required but got null");
            

        return new SubscriptionsByAccountRequestBuilder(accountKey);
    }
    private okhttp3.Call subscriptionsByKeyCall(String subscriptionKey, String acceptEncoding, String contentEncoding, String authorization, String zuoraTrackId, String zuoraEntityIds, String zuoraOrgIds, String chargeDetail, Boolean excludeRatePlansWithNoCharges, final ApiCallback _callback) throws ApiException {
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
        String localVarPath = "/v1/subscriptions/{subscription-key}"
            .replace("{" + "subscription-key" + "}", localVarApiClient.escapeString(subscriptionKey.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        if (chargeDetail != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("charge-detail", chargeDetail));
        }

        if (excludeRatePlansWithNoCharges != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("exclude-rate-plans-with-no-charges", excludeRatePlansWithNoCharges));
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
    private okhttp3.Call subscriptionsByKeyValidateBeforeCall(String subscriptionKey, String acceptEncoding, String contentEncoding, String authorization, String zuoraTrackId, String zuoraEntityIds, String zuoraOrgIds, String chargeDetail, Boolean excludeRatePlansWithNoCharges, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'subscriptionKey' is set
        if (subscriptionKey == null) {
            throw new ApiException("Missing the required parameter 'subscriptionKey' when calling subscriptionsByKey(Async)");
        }

        return subscriptionsByKeyCall(subscriptionKey, acceptEncoding, contentEncoding, authorization, zuoraTrackId, zuoraEntityIds, zuoraOrgIds, chargeDetail, excludeRatePlansWithNoCharges, _callback);

    }


    private ApiResponse<GETSubscriptionTypeWithSuccess> subscriptionsByKeyWithHttpInfo(String subscriptionKey, String acceptEncoding, String contentEncoding, String authorization, String zuoraTrackId, String zuoraEntityIds, String zuoraOrgIds, String chargeDetail, Boolean excludeRatePlansWithNoCharges) throws ApiException {
        okhttp3.Call localVarCall = subscriptionsByKeyValidateBeforeCall(subscriptionKey, acceptEncoding, contentEncoding, authorization, zuoraTrackId, zuoraEntityIds, zuoraOrgIds, chargeDetail, excludeRatePlansWithNoCharges, null);
        Type localVarReturnType = new TypeToken<GETSubscriptionTypeWithSuccess>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    private okhttp3.Call subscriptionsByKeyAsync(String subscriptionKey, String acceptEncoding, String contentEncoding, String authorization, String zuoraTrackId, String zuoraEntityIds, String zuoraOrgIds, String chargeDetail, Boolean excludeRatePlansWithNoCharges, final ApiCallback<GETSubscriptionTypeWithSuccess> _callback) throws ApiException {

        okhttp3.Call localVarCall = subscriptionsByKeyValidateBeforeCall(subscriptionKey, acceptEncoding, contentEncoding, authorization, zuoraTrackId, zuoraEntityIds, zuoraOrgIds, chargeDetail, excludeRatePlansWithNoCharges, _callback);
        Type localVarReturnType = new TypeToken<GETSubscriptionTypeWithSuccess>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    public class SubscriptionsByKeyRequestBuilder {
        private final String subscriptionKey;
        private String acceptEncoding;
        private String contentEncoding;
        private String authorization;
        private String zuoraTrackId;
        private String zuoraEntityIds;
        private String zuoraOrgIds;
        private String chargeDetail;
        private Boolean excludeRatePlansWithNoCharges;

        private SubscriptionsByKeyRequestBuilder(String subscriptionKey) {
            this.subscriptionKey = subscriptionKey;
        }

        /**
         * Set acceptEncoding
         * @param acceptEncoding Include the &#x60;Accept-Encoding: gzip&#x60; header to compress responses as a gzipped file. It can significantly reduce the bandwidth required for a response.   If specified, Zuora automatically compresses responses that contain over 1000 bytes of data, and the response contains a &#x60;Content-Encoding&#x60; header with the compression algorithm so that your client can decompress it.  (optional)
         * @return SubscriptionsByKeyRequestBuilder
         */
        public SubscriptionsByKeyRequestBuilder acceptEncoding(String acceptEncoding) {
            this.acceptEncoding = acceptEncoding;
            return this;
        }
        
        /**
         * Set contentEncoding
         * @param contentEncoding Include the &#x60;Content-Encoding: gzip&#x60; header to compress a request. With this header specified, you should upload a gzipped file for the request payload instead of sending the JSON payload.  (optional)
         * @return SubscriptionsByKeyRequestBuilder
         */
        public SubscriptionsByKeyRequestBuilder contentEncoding(String contentEncoding) {
            this.contentEncoding = contentEncoding;
            return this;
        }
        
        /**
         * Set authorization
         * @param authorization The value is in the &#x60;Bearer {token}&#x60; format where {token} is a valid OAuth token generated by calling [Create an OAuth token](https://developer.zuora.com/api-references/api/operation/createToken).  (optional)
         * @return SubscriptionsByKeyRequestBuilder
         */
        public SubscriptionsByKeyRequestBuilder authorization(String authorization) {
            this.authorization = authorization;
            return this;
        }
        
        /**
         * Set zuoraTrackId
         * @param zuoraTrackId A custom identifier for tracing the API call. If you set a value for this header, Zuora returns the same value in the response headers. This header enables you to associate your system process identifiers with Zuora API calls, to assist with troubleshooting in the event of an issue.  The value of this field must use the US-ASCII character set and must not include any of the following characters: colon (&#x60;:&#x60;), semicolon (&#x60;;&#x60;), double quote (&#x60;\&quot;&#x60;), and quote (&#x60;&#39;&#x60;).  (optional)
         * @return SubscriptionsByKeyRequestBuilder
         */
        public SubscriptionsByKeyRequestBuilder zuoraTrackId(String zuoraTrackId) {
            this.zuoraTrackId = zuoraTrackId;
            return this;
        }
        
        /**
         * Set zuoraEntityIds
         * @param zuoraEntityIds An entity ID. If you have [Zuora Multi-entity](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Multi-entity) enabled and the OAuth token is valid for more than one entity, you must use this header to specify which entity to perform the operation in. If the OAuth token is only valid for a single entity, or you do not have Zuora Multi-entity enabled, you do not need to set this header.  (optional)
         * @return SubscriptionsByKeyRequestBuilder
         */
        public SubscriptionsByKeyRequestBuilder zuoraEntityIds(String zuoraEntityIds) {
            this.zuoraEntityIds = zuoraEntityIds;
            return this;
        }
        
        /**
         * Set zuoraOrgIds
         * @param zuoraOrgIds Comma separated IDs. If you have &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Central_Platform/Multi-Org\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Zuora Multi-Org&lt;/a&gt; enabled,  you can use this header to specify which orgs to perform the operation in. If you do not have Zuora Multi-Org enabled, you should not set this header.  The IDs must be a sub-set of the user&#39;s accessible orgs. If you specify an org that the user does not have access to, the operation fails.  If the header is not set, the operation is performed in scope of the user&#39;s accessible orgs.  (optional)
         * @return SubscriptionsByKeyRequestBuilder
         */
        public SubscriptionsByKeyRequestBuilder zuoraOrgIds(String zuoraOrgIds) {
            this.zuoraOrgIds = zuoraOrgIds;
            return this;
        }
        
        /**
         * Set chargeDetail
         * @param chargeDetail  The segmented rate plan charges. When an amendment results in a change to a charge, Zuora creates a segmented rate plan charge. Use this field to track segment charges.  Possible values are:   * __last-segment__: (Default) The last rate plan charge on the subscription. The last rate plan charge is the last one in the order of time on the subscription rather than the most recent changed charge on the subscription.  * __current-segment__: The segmented charge that is active on today’s date (effectiveStartDate &lt;&#x3D; today’s date &lt; effectiveEndDate).    * __all-segments__: All the segmented charges. The &#x60;chargeSegments&#x60; field is returned in the response. The &#x60;chargeSegments&#x60; field contains an array of the charge information for all the charge segments.   * __specific-segment&amp;as-of-date&#x3D;date__: The segmented charge that is active on a date you specified ((specific date &#x3D; effectiveStartDate) OR (effectiveStartDate &lt; specific date &lt; effectiveEndDate)). The format of the date is yyyy-mm-dd.  (optional)
         * @return SubscriptionsByKeyRequestBuilder
         */
        public SubscriptionsByKeyRequestBuilder chargeDetail(String chargeDetail) {
            this.chargeDetail = chargeDetail;
            return this;
        }
        
        /**
         * Set excludeRatePlansWithNoCharges
         * @param excludeRatePlansWithNoCharges If the &#x60;exclude-rate-plans-with-no-charges&#x60; is &#x60;true&#x60;, only the active charges and rate plans will be in the response. The default value is &#x60;false&#x60;.  (optional)
         * @return SubscriptionsByKeyRequestBuilder
         */
        public SubscriptionsByKeyRequestBuilder excludeRatePlansWithNoCharges(Boolean excludeRatePlansWithNoCharges) {
            this.excludeRatePlansWithNoCharges = excludeRatePlansWithNoCharges;
            return this;
        }
        
        /**
         * Build call for subscriptionsByKey
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
            return subscriptionsByKeyCall(subscriptionKey, acceptEncoding, contentEncoding, authorization, zuoraTrackId, zuoraEntityIds, zuoraOrgIds, chargeDetail, excludeRatePlansWithNoCharges, _callback);
        }


        /**
         * Execute subscriptionsByKey request
         * @return GETSubscriptionTypeWithSuccess
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td>  </td><td>  * Content-Encoding - This header is returned if you specify the &#x60;Accept-Encoding: gzip&#x60; request header and the response contains over 1000 bytes of data. Note that only the following MIME types support gzipped responses:   - &#x60;application/json&#x60;   - &#x60;application/xml&#x60;   - &#x60;text/html&#x60;   - &#x60;text/csv&#x60;   - &#x60;text/plain&#x60;  <br>  * RateLimit-Limit - The request limit quota for the time window closest to exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Remaining - The number of requests remaining in the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Reset - The number of seconds until the quota resets for the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Zuora-Request-Id - The Zuora internal identifier of the API call. You cannot control the value of this header.  <br>  * Zuora-Track-Id - A custom identifier for tracing the API call. If you specified a tracing identifier in the request headers, Zuora returns the same tracing identifier. Otherwise, Zuora does not set this header.  <br>  </td></tr>
         </table>
         */
        public GETSubscriptionTypeWithSuccess execute() throws ApiException {
            ApiResponse<GETSubscriptionTypeWithSuccess> localVarResp = subscriptionsByKeyWithHttpInfo(subscriptionKey, acceptEncoding, contentEncoding, authorization, zuoraTrackId, zuoraEntityIds, zuoraOrgIds, chargeDetail, excludeRatePlansWithNoCharges);
            return localVarResp.getResponseBody();
        }

        /**
         * Execute subscriptionsByKey request with HTTP info returned
         * @return ApiResponse&lt;GETSubscriptionTypeWithSuccess&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td>  </td><td>  * Content-Encoding - This header is returned if you specify the &#x60;Accept-Encoding: gzip&#x60; request header and the response contains over 1000 bytes of data. Note that only the following MIME types support gzipped responses:   - &#x60;application/json&#x60;   - &#x60;application/xml&#x60;   - &#x60;text/html&#x60;   - &#x60;text/csv&#x60;   - &#x60;text/plain&#x60;  <br>  * RateLimit-Limit - The request limit quota for the time window closest to exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Remaining - The number of requests remaining in the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Reset - The number of seconds until the quota resets for the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Zuora-Request-Id - The Zuora internal identifier of the API call. You cannot control the value of this header.  <br>  * Zuora-Track-Id - A custom identifier for tracing the API call. If you specified a tracing identifier in the request headers, Zuora returns the same tracing identifier. Otherwise, Zuora does not set this header.  <br>  </td></tr>
         </table>
         */
        public ApiResponse<GETSubscriptionTypeWithSuccess> executeWithHttpInfo() throws ApiException {
            return subscriptionsByKeyWithHttpInfo(subscriptionKey, acceptEncoding, contentEncoding, authorization, zuoraTrackId, zuoraEntityIds, zuoraOrgIds, chargeDetail, excludeRatePlansWithNoCharges);
        }

        /**
         * Execute subscriptionsByKey request (asynchronously)
         * @param _callback The callback to be executed when the API call finishes
         * @return The request call
         * @throws ApiException If fail to process the API call, e.g. serializing the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td>  </td><td>  * Content-Encoding - This header is returned if you specify the &#x60;Accept-Encoding: gzip&#x60; request header and the response contains over 1000 bytes of data. Note that only the following MIME types support gzipped responses:   - &#x60;application/json&#x60;   - &#x60;application/xml&#x60;   - &#x60;text/html&#x60;   - &#x60;text/csv&#x60;   - &#x60;text/plain&#x60;  <br>  * RateLimit-Limit - The request limit quota for the time window closest to exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Remaining - The number of requests remaining in the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Reset - The number of seconds until the quota resets for the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Zuora-Request-Id - The Zuora internal identifier of the API call. You cannot control the value of this header.  <br>  * Zuora-Track-Id - A custom identifier for tracing the API call. If you specified a tracing identifier in the request headers, Zuora returns the same tracing identifier. Otherwise, Zuora does not set this header.  <br>  </td></tr>
         </table>
         */
        public okhttp3.Call executeAsync(final ApiCallback<GETSubscriptionTypeWithSuccess> _callback) throws ApiException {
            return subscriptionsByKeyAsync(subscriptionKey, acceptEncoding, contentEncoding, authorization, zuoraTrackId, zuoraEntityIds, zuoraOrgIds, chargeDetail, excludeRatePlansWithNoCharges, _callback);
        }
    }

    /**
     * Retrieve a subscription by key
     * This REST API reference describes how to retrieve detailed information about a specified subscription in the latest version. 
     * @param subscriptionKey Possible values are:   * a subscription number   * a subscription ID  (required)
     * @return SubscriptionsByKeyRequestBuilder
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td>  </td><td>  * Content-Encoding - This header is returned if you specify the &#x60;Accept-Encoding: gzip&#x60; request header and the response contains over 1000 bytes of data. Note that only the following MIME types support gzipped responses:   - &#x60;application/json&#x60;   - &#x60;application/xml&#x60;   - &#x60;text/html&#x60;   - &#x60;text/csv&#x60;   - &#x60;text/plain&#x60;  <br>  * RateLimit-Limit - The request limit quota for the time window closest to exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Remaining - The number of requests remaining in the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Reset - The number of seconds until the quota resets for the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Zuora-Request-Id - The Zuora internal identifier of the API call. You cannot control the value of this header.  <br>  * Zuora-Track-Id - A custom identifier for tracing the API call. If you specified a tracing identifier in the request headers, Zuora returns the same tracing identifier. Otherwise, Zuora does not set this header.  <br>  </td></tr>
     </table>
     */
    public SubscriptionsByKeyRequestBuilder subscriptionsByKey(String subscriptionKey) throws IllegalArgumentException {
        if (subscriptionKey == null) throw new IllegalArgumentException("\"subscriptionKey\" is required but got null");
            

        return new SubscriptionsByKeyRequestBuilder(subscriptionKey);
    }
    private okhttp3.Call subscriptionsByKeyAndVersionCall(String subscriptionKey, String version, String acceptEncoding, String contentEncoding, String authorization, String zuoraTrackId, String zuoraEntityIds, String zuoraOrgIds, String chargeDetail, Boolean excludeRatePlansWithNoCharges, Boolean getDetailedMetrics, String asOfDay, final ApiCallback _callback) throws ApiException {
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
        String localVarPath = "/v1/subscriptions/{subscription-key}/versions/{version}"
            .replace("{" + "subscription-key" + "}", localVarApiClient.escapeString(subscriptionKey.toString()))
            .replace("{" + "version" + "}", localVarApiClient.escapeString(version.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        if (chargeDetail != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("charge-detail", chargeDetail));
        }

        if (excludeRatePlansWithNoCharges != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("exclude-rate-plans-with-no-charges", excludeRatePlansWithNoCharges));
        }

        if (getDetailedMetrics != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("getDetailedMetrics", getDetailedMetrics));
        }

        if (asOfDay != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("asOfDay", asOfDay));
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
    private okhttp3.Call subscriptionsByKeyAndVersionValidateBeforeCall(String subscriptionKey, String version, String acceptEncoding, String contentEncoding, String authorization, String zuoraTrackId, String zuoraEntityIds, String zuoraOrgIds, String chargeDetail, Boolean excludeRatePlansWithNoCharges, Boolean getDetailedMetrics, String asOfDay, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'subscriptionKey' is set
        if (subscriptionKey == null) {
            throw new ApiException("Missing the required parameter 'subscriptionKey' when calling subscriptionsByKeyAndVersion(Async)");
        }

        // verify the required parameter 'version' is set
        if (version == null) {
            throw new ApiException("Missing the required parameter 'version' when calling subscriptionsByKeyAndVersion(Async)");
        }

        return subscriptionsByKeyAndVersionCall(subscriptionKey, version, acceptEncoding, contentEncoding, authorization, zuoraTrackId, zuoraEntityIds, zuoraOrgIds, chargeDetail, excludeRatePlansWithNoCharges, getDetailedMetrics, asOfDay, _callback);

    }


    private ApiResponse<GETSubscriptionTypeWithSuccess> subscriptionsByKeyAndVersionWithHttpInfo(String subscriptionKey, String version, String acceptEncoding, String contentEncoding, String authorization, String zuoraTrackId, String zuoraEntityIds, String zuoraOrgIds, String chargeDetail, Boolean excludeRatePlansWithNoCharges, Boolean getDetailedMetrics, String asOfDay) throws ApiException {
        okhttp3.Call localVarCall = subscriptionsByKeyAndVersionValidateBeforeCall(subscriptionKey, version, acceptEncoding, contentEncoding, authorization, zuoraTrackId, zuoraEntityIds, zuoraOrgIds, chargeDetail, excludeRatePlansWithNoCharges, getDetailedMetrics, asOfDay, null);
        Type localVarReturnType = new TypeToken<GETSubscriptionTypeWithSuccess>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    private okhttp3.Call subscriptionsByKeyAndVersionAsync(String subscriptionKey, String version, String acceptEncoding, String contentEncoding, String authorization, String zuoraTrackId, String zuoraEntityIds, String zuoraOrgIds, String chargeDetail, Boolean excludeRatePlansWithNoCharges, Boolean getDetailedMetrics, String asOfDay, final ApiCallback<GETSubscriptionTypeWithSuccess> _callback) throws ApiException {

        okhttp3.Call localVarCall = subscriptionsByKeyAndVersionValidateBeforeCall(subscriptionKey, version, acceptEncoding, contentEncoding, authorization, zuoraTrackId, zuoraEntityIds, zuoraOrgIds, chargeDetail, excludeRatePlansWithNoCharges, getDetailedMetrics, asOfDay, _callback);
        Type localVarReturnType = new TypeToken<GETSubscriptionTypeWithSuccess>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    public class SubscriptionsByKeyAndVersionRequestBuilder {
        private final String subscriptionKey;
        private final String version;
        private String acceptEncoding;
        private String contentEncoding;
        private String authorization;
        private String zuoraTrackId;
        private String zuoraEntityIds;
        private String zuoraOrgIds;
        private String chargeDetail;
        private Boolean excludeRatePlansWithNoCharges;
        private Boolean getDetailedMetrics;
        private String asOfDay;

        private SubscriptionsByKeyAndVersionRequestBuilder(String subscriptionKey, String version) {
            this.subscriptionKey = subscriptionKey;
            this.version = version;
        }

        /**
         * Set acceptEncoding
         * @param acceptEncoding Include the &#x60;Accept-Encoding: gzip&#x60; header to compress responses as a gzipped file. It can significantly reduce the bandwidth required for a response.   If specified, Zuora automatically compresses responses that contain over 1000 bytes of data, and the response contains a &#x60;Content-Encoding&#x60; header with the compression algorithm so that your client can decompress it.  (optional)
         * @return SubscriptionsByKeyAndVersionRequestBuilder
         */
        public SubscriptionsByKeyAndVersionRequestBuilder acceptEncoding(String acceptEncoding) {
            this.acceptEncoding = acceptEncoding;
            return this;
        }
        
        /**
         * Set contentEncoding
         * @param contentEncoding Include the &#x60;Content-Encoding: gzip&#x60; header to compress a request. With this header specified, you should upload a gzipped file for the request payload instead of sending the JSON payload.  (optional)
         * @return SubscriptionsByKeyAndVersionRequestBuilder
         */
        public SubscriptionsByKeyAndVersionRequestBuilder contentEncoding(String contentEncoding) {
            this.contentEncoding = contentEncoding;
            return this;
        }
        
        /**
         * Set authorization
         * @param authorization The value is in the &#x60;Bearer {token}&#x60; format where {token} is a valid OAuth token generated by calling [Create an OAuth token](https://developer.zuora.com/api-references/api/operation/createToken).  (optional)
         * @return SubscriptionsByKeyAndVersionRequestBuilder
         */
        public SubscriptionsByKeyAndVersionRequestBuilder authorization(String authorization) {
            this.authorization = authorization;
            return this;
        }
        
        /**
         * Set zuoraTrackId
         * @param zuoraTrackId A custom identifier for tracing the API call. If you set a value for this header, Zuora returns the same value in the response headers. This header enables you to associate your system process identifiers with Zuora API calls, to assist with troubleshooting in the event of an issue.  The value of this field must use the US-ASCII character set and must not include any of the following characters: colon (&#x60;:&#x60;), semicolon (&#x60;;&#x60;), double quote (&#x60;\&quot;&#x60;), and quote (&#x60;&#39;&#x60;).  (optional)
         * @return SubscriptionsByKeyAndVersionRequestBuilder
         */
        public SubscriptionsByKeyAndVersionRequestBuilder zuoraTrackId(String zuoraTrackId) {
            this.zuoraTrackId = zuoraTrackId;
            return this;
        }
        
        /**
         * Set zuoraEntityIds
         * @param zuoraEntityIds An entity ID. If you have [Zuora Multi-entity](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Multi-entity) enabled and the OAuth token is valid for more than one entity, you must use this header to specify which entity to perform the operation in. If the OAuth token is only valid for a single entity, or you do not have Zuora Multi-entity enabled, you do not need to set this header.  (optional)
         * @return SubscriptionsByKeyAndVersionRequestBuilder
         */
        public SubscriptionsByKeyAndVersionRequestBuilder zuoraEntityIds(String zuoraEntityIds) {
            this.zuoraEntityIds = zuoraEntityIds;
            return this;
        }
        
        /**
         * Set zuoraOrgIds
         * @param zuoraOrgIds Comma separated IDs. If you have &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Central_Platform/Multi-Org\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Zuora Multi-Org&lt;/a&gt; enabled,  you can use this header to specify which orgs to perform the operation in. If you do not have Zuora Multi-Org enabled, you should not set this header.  The IDs must be a sub-set of the user&#39;s accessible orgs. If you specify an org that the user does not have access to, the operation fails.  If the header is not set, the operation is performed in scope of the user&#39;s accessible orgs.  (optional)
         * @return SubscriptionsByKeyAndVersionRequestBuilder
         */
        public SubscriptionsByKeyAndVersionRequestBuilder zuoraOrgIds(String zuoraOrgIds) {
            this.zuoraOrgIds = zuoraOrgIds;
            return this;
        }
        
        /**
         * Set chargeDetail
         * @param chargeDetail  The segmented rate plan charges. When an amendment results in a change to a charge, Zuora creates a segmented rate plan charge. Use this field to track segment charges.  Possible values are:   * __last-segment__: (Default) The last rate plan charge on the subscription. The last rate plan charge is the last one in the order of time on the subscription rather than the most recent changed charge on the subscription.  * __current-segment__: The segmented charge that is active on today’s date (effectiveStartDate &lt;&#x3D; today’s date &lt; effectiveEndDate).    * __all-segments__: All the segmented charges. The &#x60;chargeSegments&#x60; field is returned in the response. The &#x60;chargeSegments&#x60; field contains an array of the charge information for all the charge segments.   * __specific-segment&amp;as-of-date&#x3D;date__: The segmented charge that is active on a date you specified (effectiveStartDate &lt;&#x3D; specific date &lt; effectiveEndDate). The format of the date is yyyy-mm-dd.  (optional)
         * @return SubscriptionsByKeyAndVersionRequestBuilder
         */
        public SubscriptionsByKeyAndVersionRequestBuilder chargeDetail(String chargeDetail) {
            this.chargeDetail = chargeDetail;
            return this;
        }
        
        /**
         * Set excludeRatePlansWithNoCharges
         * @param excludeRatePlansWithNoCharges If the &#x60;exclude-rate-plans-with-no-charges&#x60; is &#x60;true&#x60;, only the active charges and rate plans will be in the response. The default value is &#x60;false&#x60;.  (optional)
         * @return SubscriptionsByKeyAndVersionRequestBuilder
         */
        public SubscriptionsByKeyAndVersionRequestBuilder excludeRatePlansWithNoCharges(Boolean excludeRatePlansWithNoCharges) {
            this.excludeRatePlansWithNoCharges = excludeRatePlansWithNoCharges;
            return this;
        }
        
        /**
         * Set getDetailedMetrics
         * @param getDetailedMetrics  If the &#x60;getDetailedMetrics&#x60; is &#x60;true&#x60;, &#x60;contractedNetMrr&#x60;, &#x60;asOfDayGrossMrr&#x60;, &#x60;asOfDayNetMrr&#x60; will be in the response. The default value is &#x60;false&#x60;.  (optional, default to false)
         * @return SubscriptionsByKeyAndVersionRequestBuilder
         */
        public SubscriptionsByKeyAndVersionRequestBuilder getDetailedMetrics(Boolean getDetailedMetrics) {
            this.getDetailedMetrics = getDetailedMetrics;
            return this;
        }
        
        /**
         * Set asOfDay
         * @param asOfDay  The date for detailed metrics. Only available when &#x60;getDetailedMetrics&#x60; is &#x60;true&#x60;. The date should be in the format &#x60;YYYY-MM-DD&#x60;.  The default value is the current date.   (optional)
         * @return SubscriptionsByKeyAndVersionRequestBuilder
         */
        public SubscriptionsByKeyAndVersionRequestBuilder asOfDay(String asOfDay) {
            this.asOfDay = asOfDay;
            return this;
        }
        
        /**
         * Build call for subscriptionsByKeyAndVersion
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
            return subscriptionsByKeyAndVersionCall(subscriptionKey, version, acceptEncoding, contentEncoding, authorization, zuoraTrackId, zuoraEntityIds, zuoraOrgIds, chargeDetail, excludeRatePlansWithNoCharges, getDetailedMetrics, asOfDay, _callback);
        }


        /**
         * Execute subscriptionsByKeyAndVersion request
         * @return GETSubscriptionTypeWithSuccess
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td>  </td><td>  * Content-Encoding - This header is returned if you specify the &#x60;Accept-Encoding: gzip&#x60; request header and the response contains over 1000 bytes of data. Note that only the following MIME types support gzipped responses:   - &#x60;application/json&#x60;   - &#x60;application/xml&#x60;   - &#x60;text/html&#x60;   - &#x60;text/csv&#x60;   - &#x60;text/plain&#x60;  <br>  * RateLimit-Limit - The request limit quota for the time window closest to exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Remaining - The number of requests remaining in the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Reset - The number of seconds until the quota resets for the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Zuora-Request-Id - The Zuora internal identifier of the API call. You cannot control the value of this header.  <br>  * Zuora-Track-Id - A custom identifier for tracing the API call. If you specified a tracing identifier in the request headers, Zuora returns the same tracing identifier. Otherwise, Zuora does not set this header.  <br>  </td></tr>
         </table>
         */
        public GETSubscriptionTypeWithSuccess execute() throws ApiException {
            ApiResponse<GETSubscriptionTypeWithSuccess> localVarResp = subscriptionsByKeyAndVersionWithHttpInfo(subscriptionKey, version, acceptEncoding, contentEncoding, authorization, zuoraTrackId, zuoraEntityIds, zuoraOrgIds, chargeDetail, excludeRatePlansWithNoCharges, getDetailedMetrics, asOfDay);
            return localVarResp.getResponseBody();
        }

        /**
         * Execute subscriptionsByKeyAndVersion request with HTTP info returned
         * @return ApiResponse&lt;GETSubscriptionTypeWithSuccess&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td>  </td><td>  * Content-Encoding - This header is returned if you specify the &#x60;Accept-Encoding: gzip&#x60; request header and the response contains over 1000 bytes of data. Note that only the following MIME types support gzipped responses:   - &#x60;application/json&#x60;   - &#x60;application/xml&#x60;   - &#x60;text/html&#x60;   - &#x60;text/csv&#x60;   - &#x60;text/plain&#x60;  <br>  * RateLimit-Limit - The request limit quota for the time window closest to exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Remaining - The number of requests remaining in the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Reset - The number of seconds until the quota resets for the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Zuora-Request-Id - The Zuora internal identifier of the API call. You cannot control the value of this header.  <br>  * Zuora-Track-Id - A custom identifier for tracing the API call. If you specified a tracing identifier in the request headers, Zuora returns the same tracing identifier. Otherwise, Zuora does not set this header.  <br>  </td></tr>
         </table>
         */
        public ApiResponse<GETSubscriptionTypeWithSuccess> executeWithHttpInfo() throws ApiException {
            return subscriptionsByKeyAndVersionWithHttpInfo(subscriptionKey, version, acceptEncoding, contentEncoding, authorization, zuoraTrackId, zuoraEntityIds, zuoraOrgIds, chargeDetail, excludeRatePlansWithNoCharges, getDetailedMetrics, asOfDay);
        }

        /**
         * Execute subscriptionsByKeyAndVersion request (asynchronously)
         * @param _callback The callback to be executed when the API call finishes
         * @return The request call
         * @throws ApiException If fail to process the API call, e.g. serializing the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td>  </td><td>  * Content-Encoding - This header is returned if you specify the &#x60;Accept-Encoding: gzip&#x60; request header and the response contains over 1000 bytes of data. Note that only the following MIME types support gzipped responses:   - &#x60;application/json&#x60;   - &#x60;application/xml&#x60;   - &#x60;text/html&#x60;   - &#x60;text/csv&#x60;   - &#x60;text/plain&#x60;  <br>  * RateLimit-Limit - The request limit quota for the time window closest to exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Remaining - The number of requests remaining in the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Reset - The number of seconds until the quota resets for the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Zuora-Request-Id - The Zuora internal identifier of the API call. You cannot control the value of this header.  <br>  * Zuora-Track-Id - A custom identifier for tracing the API call. If you specified a tracing identifier in the request headers, Zuora returns the same tracing identifier. Otherwise, Zuora does not set this header.  <br>  </td></tr>
         </table>
         */
        public okhttp3.Call executeAsync(final ApiCallback<GETSubscriptionTypeWithSuccess> _callback) throws ApiException {
            return subscriptionsByKeyAndVersionAsync(subscriptionKey, version, acceptEncoding, contentEncoding, authorization, zuoraTrackId, zuoraEntityIds, zuoraOrgIds, chargeDetail, excludeRatePlansWithNoCharges, getDetailedMetrics, asOfDay, _callback);
        }
    }

    /**
     * Retrieve a subscription by key and version
     * This REST API reference describes how to retrieve detailed information about a specified subscription in a specified version. When you create a subscription amendment, you create a new version of the subscription. You can use this method to retrieve information about a subscription in any version. 
     * @param subscriptionKey Subscription number. For example, A-S00000135.  (required)
     * @param version Subscription version. For example, 1.  (required)
     * @return SubscriptionsByKeyAndVersionRequestBuilder
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td>  </td><td>  * Content-Encoding - This header is returned if you specify the &#x60;Accept-Encoding: gzip&#x60; request header and the response contains over 1000 bytes of data. Note that only the following MIME types support gzipped responses:   - &#x60;application/json&#x60;   - &#x60;application/xml&#x60;   - &#x60;text/html&#x60;   - &#x60;text/csv&#x60;   - &#x60;text/plain&#x60;  <br>  * RateLimit-Limit - The request limit quota for the time window closest to exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Remaining - The number of requests remaining in the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Reset - The number of seconds until the quota resets for the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Zuora-Request-Id - The Zuora internal identifier of the API call. You cannot control the value of this header.  <br>  * Zuora-Track-Id - A custom identifier for tracing the API call. If you specified a tracing identifier in the request headers, Zuora returns the same tracing identifier. Otherwise, Zuora does not set this header.  <br>  </td></tr>
     </table>
     */
    public SubscriptionsByKeyAndVersionRequestBuilder subscriptionsByKeyAndVersion(String subscriptionKey, String version) throws IllegalArgumentException {
        if (subscriptionKey == null) throw new IllegalArgumentException("\"subscriptionKey\" is required but got null");
            

        if (version == null) throw new IllegalArgumentException("\"version\" is required but got null");
            

        return new SubscriptionsByKeyAndVersionRequestBuilder(subscriptionKey, version);
    }
    private okhttp3.Call suspendSubscriptionCall(String subscriptionKey, PUTSubscriptionSuspendType puTSubscriptionSuspendType, String acceptEncoding, String contentEncoding, String authorization, String zuoraTrackId, String zuoraEntityIds, String zuoraOrgIds, String zuoraVersion, final ApiCallback _callback) throws ApiException {
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

        Object localVarPostBody = puTSubscriptionSuspendType;

        // create path and map variables
        String localVarPath = "/v1/subscriptions/{subscription-key}/suspend"
            .replace("{" + "subscription-key" + "}", localVarApiClient.escapeString(subscriptionKey.toString()));

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
    private okhttp3.Call suspendSubscriptionValidateBeforeCall(String subscriptionKey, PUTSubscriptionSuspendType puTSubscriptionSuspendType, String acceptEncoding, String contentEncoding, String authorization, String zuoraTrackId, String zuoraEntityIds, String zuoraOrgIds, String zuoraVersion, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'subscriptionKey' is set
        if (subscriptionKey == null) {
            throw new ApiException("Missing the required parameter 'subscriptionKey' when calling suspendSubscription(Async)");
        }

        // verify the required parameter 'puTSubscriptionSuspendType' is set
        if (puTSubscriptionSuspendType == null) {
            throw new ApiException("Missing the required parameter 'puTSubscriptionSuspendType' when calling suspendSubscription(Async)");
        }

        return suspendSubscriptionCall(subscriptionKey, puTSubscriptionSuspendType, acceptEncoding, contentEncoding, authorization, zuoraTrackId, zuoraEntityIds, zuoraOrgIds, zuoraVersion, _callback);

    }


    private ApiResponse<PUTSubscriptionSuspendResponseType> suspendSubscriptionWithHttpInfo(String subscriptionKey, PUTSubscriptionSuspendType puTSubscriptionSuspendType, String acceptEncoding, String contentEncoding, String authorization, String zuoraTrackId, String zuoraEntityIds, String zuoraOrgIds, String zuoraVersion) throws ApiException {
        okhttp3.Call localVarCall = suspendSubscriptionValidateBeforeCall(subscriptionKey, puTSubscriptionSuspendType, acceptEncoding, contentEncoding, authorization, zuoraTrackId, zuoraEntityIds, zuoraOrgIds, zuoraVersion, null);
        Type localVarReturnType = new TypeToken<PUTSubscriptionSuspendResponseType>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    private okhttp3.Call suspendSubscriptionAsync(String subscriptionKey, PUTSubscriptionSuspendType puTSubscriptionSuspendType, String acceptEncoding, String contentEncoding, String authorization, String zuoraTrackId, String zuoraEntityIds, String zuoraOrgIds, String zuoraVersion, final ApiCallback<PUTSubscriptionSuspendResponseType> _callback) throws ApiException {

        okhttp3.Call localVarCall = suspendSubscriptionValidateBeforeCall(subscriptionKey, puTSubscriptionSuspendType, acceptEncoding, contentEncoding, authorization, zuoraTrackId, zuoraEntityIds, zuoraOrgIds, zuoraVersion, _callback);
        Type localVarReturnType = new TypeToken<PUTSubscriptionSuspendResponseType>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    public class SuspendSubscriptionRequestBuilder {
        private final String suspendPolicy;
        private final String subscriptionKey;
        private List<String> applicationOrder;
        private Boolean applyCredit;
        private Boolean applyCreditBalance;
        private LocalDate bookingDate;
        private Boolean collect;
        private LocalDate contractEffectiveDate;
        private String creditMemoReasonCode;
        private LocalDate documentDate;
        private Boolean extendsTerm;
        private Boolean invoice;
        private Boolean invoiceCollect;
        private LocalDate invoiceTargetDate;
        private LocalDate orderDate;
        private Boolean resume;
        private String resumePeriods;
        private String resumePeriodsType;
        private String resumePolicy;
        private LocalDate resumeSpecificDate;
        private Boolean runBilling;
        private String suspendPeriods;
        private String suspendPeriodsType;
        private LocalDate suspendSpecificDate;
        private LocalDate targetDate;
        private String acceptEncoding;
        private String contentEncoding;
        private String authorization;
        private String zuoraTrackId;
        private String zuoraEntityIds;
        private String zuoraOrgIds;
        private String zuoraVersion;

        private SuspendSubscriptionRequestBuilder(String suspendPolicy, String subscriptionKey) {
            this.suspendPolicy = suspendPolicy;
            this.subscriptionKey = subscriptionKey;
        }

        /**
         * Set applicationOrder
         * @param applicationOrder The priority order to apply credit memos and/or unapplied payments to an invoice. Possible item values are: &#x60;CreditMemo&#x60;, &#x60;UnappliedPayment&#x60;.  **Note:**   - This field is valid only if the &#x60;applyCredit&#x60; field is set to &#x60;true&#x60;.   - If no value is specified for this field, the default priority order is used, [\\\&quot;CreditMemo\\\&quot;, \\\&quot;UnappliedPayment\\\&quot;], to apply credit memos first and then apply unapplied payments.   - If only one item is specified, only the items of the spedified type are applied to invoices. For example, if the value is &#x60;[\\\&quot;CreditMemo\\\&quot;]&#x60;, only credit memos are used to apply to invoices.  (optional)
         * @return SuspendSubscriptionRequestBuilder
         */
        public SuspendSubscriptionRequestBuilder applicationOrder(List<String> applicationOrder) {
            this.applicationOrder = applicationOrder;
            return this;
        }
        
        /**
         * Set applyCredit
         * @param applyCredit If the value is true, the credit memo or unapplied payment on the order account will be automatically applied to the invoices generated by this order. The credit memo generated by this order will not be automatically applied to any invoices.   **Note:** This field is only available if you have [Invoice Settlement](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/Invoice_Settlement) enabled. The Invoice Settlement feature is generally available as of Zuora Billing Release 296 (March 2021). This feature includes Unapplied Payments, Credit and Debit Memo, and Invoice Item Settlement. If you want to enable Invoice Settlement, see [Invoice Settlement Enablement and Checklist Guide](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/Invoice_Settlement/Invoice_Settlement_Migration_Checklist_and_Guide) for more information.  (optional)
         * @return SuspendSubscriptionRequestBuilder
         */
        public SuspendSubscriptionRequestBuilder applyCredit(Boolean applyCredit) {
            this.applyCredit = applyCredit;
            return this;
        }
        
        /**
         * Set applyCreditBalance
         * @param applyCreditBalance Whether to automatically apply a credit balance to an invoice.  If the value is &#x60;true&#x60;, the credit balance is applied to the invoice. If the value is &#x60;false&#x60;, no action is taken.   To view the credit balance adjustment, retrieve the details of the invoice using the Get Invoices method.  Prerequisite: &#x60;invoice&#x60; must be &#x60;true&#x60;.   **Note:**    - If you are using the field &#x60;invoiceCollect&#x60; rather than the field &#x60;invoice&#x60;, the &#x60;invoiceCollect&#x60; value must be &#x60;true&#x60;.   - This field is deprecated if you have the Invoice Settlement feature enabled.  (optional)
         * @return SuspendSubscriptionRequestBuilder
         */
        public SuspendSubscriptionRequestBuilder applyCreditBalance(Boolean applyCreditBalance) {
            this.applyCreditBalance = applyCreditBalance;
            return this;
        }
        
        /**
         * Set bookingDate
         * @param bookingDate The booking date that you want to set for the amendment contract when you suspend the subscription. If &#x60;resume&#x60; is &#x60;true&#x60;, which means you also choose to resume the subscription at some point, then this field is also the booking date for the Resume amendment contract.  This field must be in the &#x60;yyyy-mm-dd&#x60; format. The default value of this field is the current date when you make the API call.   (optional)
         * @return SuspendSubscriptionRequestBuilder
         */
        public SuspendSubscriptionRequestBuilder bookingDate(LocalDate bookingDate) {
            this.bookingDate = bookingDate;
            return this;
        }
        
        /**
         * Set collect
         * @param collect Collects an automatic payment for a subscription. The collection generated in this operation is only for this subscription, not for the entire customer account.  If the value is &#x60;true&#x60;, the automatic payment is collected. If the value is &#x60;false&#x60;, no action is taken.  Prerequisite: The &#x60;invoice&#x60; or &#x60;runBilling&#x60; field must be &#x60;true&#x60;.   **Note**: This field is only available if you set the &#x60;zuora-version&#x60; request header to &#x60;196.0&#x60; or later [available versions](https://developer.zuora.com/api-references/api/overview/#section/API-Versions/Minor-Version).  (optional, default to false)
         * @return SuspendSubscriptionRequestBuilder
         */
        public SuspendSubscriptionRequestBuilder collect(Boolean collect) {
            this.collect = collect;
            return this;
        }
        
        /**
         * Set contractEffectiveDate
         * @param contractEffectiveDate The date when the customer notifies you that they want to amend their subscription.  (optional)
         * @return SuspendSubscriptionRequestBuilder
         */
        public SuspendSubscriptionRequestBuilder contractEffectiveDate(LocalDate contractEffectiveDate) {
            this.contractEffectiveDate = contractEffectiveDate;
            return this;
        }
        
        /**
         * Set creditMemoReasonCode
         * @param creditMemoReasonCode A code identifying the reason for the credit memo transaction that is generated by the request. The value must be an existing reason code. If you do not pass the field or pass the field with empty value, Zuora uses the default reason code. (optional)
         * @return SuspendSubscriptionRequestBuilder
         */
        public SuspendSubscriptionRequestBuilder creditMemoReasonCode(String creditMemoReasonCode) {
            this.creditMemoReasonCode = creditMemoReasonCode;
            return this;
        }
        
        /**
         * Set documentDate
         * @param documentDate The date of the billing document, in &#x60;yyyy-mm-dd&#x60; format. It represents the invoice date for invoices, credit memo date for credit memos, and debit memo date for debit memos.  - If this field is specified, the specified date is used as the billing document date.  - If this field is not specified, the date specified in the &#x60;targetDate&#x60; is used as the billing document date.  (optional)
         * @return SuspendSubscriptionRequestBuilder
         */
        public SuspendSubscriptionRequestBuilder documentDate(LocalDate documentDate) {
            this.documentDate = documentDate;
            return this;
        }
        
        /**
         * Set extendsTerm
         * @param extendsTerm Whether to extend the subscription term by the length of time the suspension is in effect. Values: &#x60;true&#x60;, &#x60;false&#x60;.  (optional)
         * @return SuspendSubscriptionRequestBuilder
         */
        public SuspendSubscriptionRequestBuilder extendsTerm(Boolean extendsTerm) {
            this.extendsTerm = extendsTerm;
            return this;
        }
        
        /**
         * Set invoice
         * @param invoice **Note:** This field has been replaced by the &#x60;runBilling&#x60; field. The &#x60;invoice&#x60; field is only available for backward compatibility.   Creates an invoice for a subscription. The invoice generated in this operation is only for this subscription, not for the entire customer account.   If the value is &#x60;true&#x60;, an invoice is created. If the value is &#x60;false&#x60;, no action is taken. The default value is &#x60;false&#x60;.    This field is in Zuora REST API version control. Supported minor versions are &#x60;196.0&#x60; and &#x60;207.0&#x60;. To use this field in the method, you must set the zuora-version parameter to the minor version number in the request header.  (optional)
         * @return SuspendSubscriptionRequestBuilder
         */
        public SuspendSubscriptionRequestBuilder invoice(Boolean invoice) {
            this.invoice = invoice;
            return this;
        }
        
        /**
         * Set invoiceCollect
         * @param invoiceCollect **Note:** This field has been replaced by the &#x60;invoice&#x60; field and the &#x60;collect&#x60; field. &#x60;invoiceCollect&#x60; is available only for backward compatibility.   **Note**: This field is only available if you set the &#x60;zuora-version&#x60; request header to &#x60;186.0&#x60;, &#x60;187.0&#x60;, &#x60;188.0&#x60;, or &#x60;189.0&#x60;.  (optional)
         * @return SuspendSubscriptionRequestBuilder
         */
        public SuspendSubscriptionRequestBuilder invoiceCollect(Boolean invoiceCollect) {
            this.invoiceCollect = invoiceCollect;
            return this;
        }
        
        /**
         * Set invoiceTargetDate
         * @param invoiceTargetDate **Note:** This field has been replaced by the &#x60;targetDate&#x60; field. The &#x60;invoiceTargetDate&#x60; field is only available for backward compatibility.   Date through which to calculate charges if an invoice is generated, as yyyy-mm-dd. Default is current date.   This field is in Zuora REST API version control. Supported minor versions are &#x60;207.0&#x60; and earlier [available versions](https://developer.zuora.com/api-references/api/overview/#section/API-Versions/Minor-Version).  (optional)
         * @return SuspendSubscriptionRequestBuilder
         */
        public SuspendSubscriptionRequestBuilder invoiceTargetDate(LocalDate invoiceTargetDate) {
            this.invoiceTargetDate = invoiceTargetDate;
            return this;
        }
        
        /**
         * Set orderDate
         * @param orderDate The date when the order is signed. If no additinal contractEffectiveDate is provided, this order will use this order date as the contract effective date. This field must be in the &#x60;yyyy-mm-dd&#x60; format. This field is required for Orders customers only, not applicable to Orders Harmonization customers.  (optional)
         * @return SuspendSubscriptionRequestBuilder
         */
        public SuspendSubscriptionRequestBuilder orderDate(LocalDate orderDate) {
            this.orderDate = orderDate;
            return this;
        }
        
        /**
         * Set resume
         * @param resume Whether to set when to resume a subscription when creating a suspend amendment. Values: &#x60;true&#x60;, &#x60;false&#x60;.  (optional)
         * @return SuspendSubscriptionRequestBuilder
         */
        public SuspendSubscriptionRequestBuilder resume(Boolean resume) {
            this.resume = resume;
            return this;
        }
        
        /**
         * Set resumePeriods
         * @param resumePeriods The length of the period used to specify when the subscription is resumed. The subscription resumption takes effect after a specified period based on the suspend date or today&#39;s date. You must use this field together with the &#x60;resumePeriodsType&#x60; field to specify the period.  **Note:** This field is only applicable when the &#x60;suspendPolicy&#x60; field is set to &#x60;FixedPeriodsFromToday&#x60; or &#x60;FixedPeriodsFromSuspendDate&#x60;.  (optional)
         * @return SuspendSubscriptionRequestBuilder
         */
        public SuspendSubscriptionRequestBuilder resumePeriods(String resumePeriods) {
            this.resumePeriods = resumePeriods;
            return this;
        }
        
        /**
         * Set resumePeriodsType
         * @param resumePeriodsType The period type used to define when the subscription resumption takes effect. The subscription resumption takes effect after a specified period based on the suspend date or today&#39;s date. You must use this field together with the resumePeriods field to specify the period.  Values: &#x60;Day&#x60;, &#x60;Week&#x60;, &#x60;Month&#x60;, &#x60;Year&#x60;  **Note:** This field is only applicable when the &#x60;suspendPolicy&#x60; field is set to &#x60;FixedPeriodsFromToday&#x60; or &#x60;FixedPeriodsFromSuspendDate&#x60;.  (optional)
         * @return SuspendSubscriptionRequestBuilder
         */
        public SuspendSubscriptionRequestBuilder resumePeriodsType(String resumePeriodsType) {
            this.resumePeriodsType = resumePeriodsType;
            return this;
        }
        
        /**
         * Set resumePolicy
         * @param resumePolicy Resume methods. Specify a way to resume a subscription. Values:  * &#x60;Today&#x60;: The subscription resumption takes effect on today&#39;s date.  * &#x60;FixedPeriodsFromSuspendDate&#x60;: The subscription resumption takes effect after a specified period based on the suspend date. You must specify the &#x60;resumePeriods&#x60; and &#x60;resumePeriodsType&#x60; fields to define the period.  * &#x60;SpecificDate&#x60;: The subscription resumption takes effect on a specific date. You must define the specific date in the &#x60;resumeSpecificDate&#x60; field.  * &#x60;FixedPeriodsFromToday&#x60;: The subscription resumption takes effect after a specified period based on the today&#39;s date. You must specify the &#x60;resumePeriods&#x60; and &#x60;resumePeriodsType&#x60; fields to define the period. * &#x60;suspendDate&#x60;: The subscription resumption takes effect on the date of suspension of the subscription.  (optional)
         * @return SuspendSubscriptionRequestBuilder
         */
        public SuspendSubscriptionRequestBuilder resumePolicy(String resumePolicy) {
            this.resumePolicy = resumePolicy;
            return this;
        }
        
        /**
         * Set resumeSpecificDate
         * @param resumeSpecificDate A specific date when the subscription resumption takes effect, in the format yyyy-mm-dd.  **Note:** This field is only applicable only when the &#x60;resumePolicy&#x60; field is set to &#x60;SpecificDate&#x60;.  The value should not be earlier than the subscription suspension date.  (optional)
         * @return SuspendSubscriptionRequestBuilder
         */
        public SuspendSubscriptionRequestBuilder resumeSpecificDate(LocalDate resumeSpecificDate) {
            this.resumeSpecificDate = resumeSpecificDate;
            return this;
        }
        
        /**
         * Set runBilling
         * @param runBilling Creates an invoice for a subscription. If you have the Invoice Settlement feature enabled, a credit memo might also be created based on the [invoice and credit memo generation rule](https://knowledgecenter.zuora.com/CB_Billing/Invoice_Settlement/Credit_and_Debit_Memos/Rules_for_Generating_Invoices_and_Credit_Memos).     The billing documents generated in this operation is only for this subscription, not for the entire customer account.   Possible values:  - &#x60;true&#x60;: An invoice is created. If you have the Invoice Settlement feature enabled, a credit memo might also be created.   - &#x60;false&#x60;: No invoice is created.   **Note:** This field is in Zuora REST API version control. Supported minor versions are &#x60;211.0&#x60; or later [available versions](https://developer.zuora.com/api-references/api/overview/#section/API-Versions/Minor-Version). To use this field in the method, you must set the &#x60;zuora-version&#x60; parameter to the minor version number in the request header.  (optional, default to false)
         * @return SuspendSubscriptionRequestBuilder
         */
        public SuspendSubscriptionRequestBuilder runBilling(Boolean runBilling) {
            this.runBilling = runBilling;
            return this;
        }
        
        /**
         * Set suspendPeriods
         * @param suspendPeriods The length of the period used to specify when the subscription suspension takes effect. The subscription suspension takes effect after a specified period based on today&#39;s date. You must use this field together with the &#x60;suspendPeriodsType&#x60; field to specify the period.  **Note:** This field is only applicable only when the suspendPolicy field is set to FixedPeriodsFromToday.  (optional)
         * @return SuspendSubscriptionRequestBuilder
         */
        public SuspendSubscriptionRequestBuilder suspendPeriods(String suspendPeriods) {
            this.suspendPeriods = suspendPeriods;
            return this;
        }
        
        /**
         * Set suspendPeriodsType
         * @param suspendPeriodsType The period type used to define when the subscription suspension takes effect. The subscription suspension takes effect after a specified period based on today&#39;s date. You must use this field together with the suspendPeriods field to specify the period.  Type: string (enum)  Values: &#x60;Day&#x60;, &#x60;Week&#x60;, &#x60;Month&#x60;, &#x60;Year&#x60;  **Note:** This field is only applicable only when the suspendPolicy field is set to FixedPeriodsFromToday.  (optional)
         * @return SuspendSubscriptionRequestBuilder
         */
        public SuspendSubscriptionRequestBuilder suspendPeriodsType(String suspendPeriodsType) {
            this.suspendPeriodsType = suspendPeriodsType;
            return this;
        }
        
        /**
         * Set suspendSpecificDate
         * @param suspendSpecificDate A specific date when the subscription suspension takes effect, in the format yyyy-mm-dd.  **Note:** This field is only applicable only when the suspendPolicy field is set to SpecificDate.  The value should not be earlier than the subscription contract effective date, later than the subscription term end date, or within a period for which the customer has been invoiced.  (optional)
         * @return SuspendSubscriptionRequestBuilder
         */
        public SuspendSubscriptionRequestBuilder suspendSpecificDate(LocalDate suspendSpecificDate) {
            this.suspendSpecificDate = suspendSpecificDate;
            return this;
        }
        
        /**
         * Set targetDate
         * @param targetDate Date through which to calculate charges if an invoice or a credit memo is generated, as yyyy-mm-dd. Default is current date.   **Note:** The credit memo is only available if you have the Invoice Settlement feature enabled.   This field is in Zuora REST API version control. Supported minor versions are &#x60;211.0&#x60; and later. To use this field in the method, you must set the  &#x60;zuora-version&#x60; parameter to the minor version number in the request header.  (optional)
         * @return SuspendSubscriptionRequestBuilder
         */
        public SuspendSubscriptionRequestBuilder targetDate(LocalDate targetDate) {
            this.targetDate = targetDate;
            return this;
        }
        
        /**
         * Set acceptEncoding
         * @param acceptEncoding Include the &#x60;Accept-Encoding: gzip&#x60; header to compress responses as a gzipped file. It can significantly reduce the bandwidth required for a response.   If specified, Zuora automatically compresses responses that contain over 1000 bytes of data, and the response contains a &#x60;Content-Encoding&#x60; header with the compression algorithm so that your client can decompress it.  (optional)
         * @return SuspendSubscriptionRequestBuilder
         */
        public SuspendSubscriptionRequestBuilder acceptEncoding(String acceptEncoding) {
            this.acceptEncoding = acceptEncoding;
            return this;
        }
        
        /**
         * Set contentEncoding
         * @param contentEncoding Include the &#x60;Content-Encoding: gzip&#x60; header to compress a request. With this header specified, you should upload a gzipped file for the request payload instead of sending the JSON payload.  (optional)
         * @return SuspendSubscriptionRequestBuilder
         */
        public SuspendSubscriptionRequestBuilder contentEncoding(String contentEncoding) {
            this.contentEncoding = contentEncoding;
            return this;
        }
        
        /**
         * Set authorization
         * @param authorization The value is in the &#x60;Bearer {token}&#x60; format where {token} is a valid OAuth token generated by calling [Create an OAuth token](https://developer.zuora.com/api-references/api/operation/createToken).  (optional)
         * @return SuspendSubscriptionRequestBuilder
         */
        public SuspendSubscriptionRequestBuilder authorization(String authorization) {
            this.authorization = authorization;
            return this;
        }
        
        /**
         * Set zuoraTrackId
         * @param zuoraTrackId A custom identifier for tracing the API call. If you set a value for this header, Zuora returns the same value in the response headers. This header enables you to associate your system process identifiers with Zuora API calls, to assist with troubleshooting in the event of an issue.  The value of this field must use the US-ASCII character set and must not include any of the following characters: colon (&#x60;:&#x60;), semicolon (&#x60;;&#x60;), double quote (&#x60;\&quot;&#x60;), and quote (&#x60;&#39;&#x60;).  (optional)
         * @return SuspendSubscriptionRequestBuilder
         */
        public SuspendSubscriptionRequestBuilder zuoraTrackId(String zuoraTrackId) {
            this.zuoraTrackId = zuoraTrackId;
            return this;
        }
        
        /**
         * Set zuoraEntityIds
         * @param zuoraEntityIds An entity ID. If you have [Zuora Multi-entity](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Multi-entity) enabled and the OAuth token is valid for more than one entity, you must use this header to specify which entity to perform the operation in. If the OAuth token is only valid for a single entity, or you do not have Zuora Multi-entity enabled, you do not need to set this header.  (optional)
         * @return SuspendSubscriptionRequestBuilder
         */
        public SuspendSubscriptionRequestBuilder zuoraEntityIds(String zuoraEntityIds) {
            this.zuoraEntityIds = zuoraEntityIds;
            return this;
        }
        
        /**
         * Set zuoraOrgIds
         * @param zuoraOrgIds Comma separated IDs. If you have &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Central_Platform/Multi-Org\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Zuora Multi-Org&lt;/a&gt; enabled,  you can use this header to specify which orgs to perform the operation in. If you do not have Zuora Multi-Org enabled, you should not set this header.  The IDs must be a sub-set of the user&#39;s accessible orgs. If you specify an org that the user does not have access to, the operation fails.  If the header is not set, the operation is performed in scope of the user&#39;s accessible orgs.  (optional)
         * @return SuspendSubscriptionRequestBuilder
         */
        public SuspendSubscriptionRequestBuilder zuoraOrgIds(String zuoraOrgIds) {
            this.zuoraOrgIds = zuoraOrgIds;
            return this;
        }
        
        /**
         * Set zuoraVersion
         * @param zuoraVersion The minor version of the Zuora REST API.   You only need to set this parameter if you use the following fields: * invoice * collect * runBilling * targetDate  (optional)
         * @return SuspendSubscriptionRequestBuilder
         */
        public SuspendSubscriptionRequestBuilder zuoraVersion(String zuoraVersion) {
            this.zuoraVersion = zuoraVersion;
            return this;
        }
        
        /**
         * Build call for suspendSubscription
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
            PUTSubscriptionSuspendType puTSubscriptionSuspendType = buildBodyParams();
            return suspendSubscriptionCall(subscriptionKey, puTSubscriptionSuspendType, acceptEncoding, contentEncoding, authorization, zuoraTrackId, zuoraEntityIds, zuoraOrgIds, zuoraVersion, _callback);
        }

        private PUTSubscriptionSuspendType buildBodyParams() {
            PUTSubscriptionSuspendType puTSubscriptionSuspendType = new PUTSubscriptionSuspendType();
            puTSubscriptionSuspendType.applicationOrder(this.applicationOrder);
            puTSubscriptionSuspendType.applyCredit(this.applyCredit);
            puTSubscriptionSuspendType.applyCreditBalance(this.applyCreditBalance);
            puTSubscriptionSuspendType.bookingDate(this.bookingDate);
            puTSubscriptionSuspendType.collect(this.collect);
            puTSubscriptionSuspendType.contractEffectiveDate(this.contractEffectiveDate);
            puTSubscriptionSuspendType.creditMemoReasonCode(this.creditMemoReasonCode);
            puTSubscriptionSuspendType.documentDate(this.documentDate);
            puTSubscriptionSuspendType.extendsTerm(this.extendsTerm);
            puTSubscriptionSuspendType.invoice(this.invoice);
            puTSubscriptionSuspendType.invoiceCollect(this.invoiceCollect);
            puTSubscriptionSuspendType.invoiceTargetDate(this.invoiceTargetDate);
            puTSubscriptionSuspendType.orderDate(this.orderDate);
            puTSubscriptionSuspendType.resume(this.resume);
            puTSubscriptionSuspendType.resumePeriods(this.resumePeriods);
            puTSubscriptionSuspendType.resumePeriodsType(this.resumePeriodsType);
            puTSubscriptionSuspendType.resumePolicy(this.resumePolicy);
            puTSubscriptionSuspendType.resumeSpecificDate(this.resumeSpecificDate);
            if (this.runBilling != null)
            puTSubscriptionSuspendType.runBilling(PUTSubscriptionSuspendType.RunBillingEnum.fromValue(this.runBilling));
            puTSubscriptionSuspendType.suspendPeriods(this.suspendPeriods);
            puTSubscriptionSuspendType.suspendPeriodsType(this.suspendPeriodsType);
            puTSubscriptionSuspendType.suspendPolicy(this.suspendPolicy);
            puTSubscriptionSuspendType.suspendSpecificDate(this.suspendSpecificDate);
            puTSubscriptionSuspendType.targetDate(this.targetDate);
            return puTSubscriptionSuspendType;
        }

        /**
         * Execute suspendSubscription request
         * @return PUTSubscriptionSuspendResponseType
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td>  </td><td>  * Content-Encoding - This header is returned if you specify the &#x60;Accept-Encoding: gzip&#x60; request header and the response contains over 1000 bytes of data. Note that only the following MIME types support gzipped responses:   - &#x60;application/json&#x60;   - &#x60;application/xml&#x60;   - &#x60;text/html&#x60;   - &#x60;text/csv&#x60;   - &#x60;text/plain&#x60;  <br>  * RateLimit-Limit - The request limit quota for the time window closest to exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Remaining - The number of requests remaining in the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Reset - The number of seconds until the quota resets for the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Zuora-Request-Id - The Zuora internal identifier of the API call. You cannot control the value of this header.  <br>  * Zuora-Track-Id - A custom identifier for tracing the API call. If you specified a tracing identifier in the request headers, Zuora returns the same tracing identifier. Otherwise, Zuora does not set this header.  <br>  </td></tr>
         </table>
         */
        public PUTSubscriptionSuspendResponseType execute() throws ApiException {
            PUTSubscriptionSuspendType puTSubscriptionSuspendType = buildBodyParams();
            ApiResponse<PUTSubscriptionSuspendResponseType> localVarResp = suspendSubscriptionWithHttpInfo(subscriptionKey, puTSubscriptionSuspendType, acceptEncoding, contentEncoding, authorization, zuoraTrackId, zuoraEntityIds, zuoraOrgIds, zuoraVersion);
            return localVarResp.getResponseBody();
        }

        /**
         * Execute suspendSubscription request with HTTP info returned
         * @return ApiResponse&lt;PUTSubscriptionSuspendResponseType&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td>  </td><td>  * Content-Encoding - This header is returned if you specify the &#x60;Accept-Encoding: gzip&#x60; request header and the response contains over 1000 bytes of data. Note that only the following MIME types support gzipped responses:   - &#x60;application/json&#x60;   - &#x60;application/xml&#x60;   - &#x60;text/html&#x60;   - &#x60;text/csv&#x60;   - &#x60;text/plain&#x60;  <br>  * RateLimit-Limit - The request limit quota for the time window closest to exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Remaining - The number of requests remaining in the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Reset - The number of seconds until the quota resets for the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Zuora-Request-Id - The Zuora internal identifier of the API call. You cannot control the value of this header.  <br>  * Zuora-Track-Id - A custom identifier for tracing the API call. If you specified a tracing identifier in the request headers, Zuora returns the same tracing identifier. Otherwise, Zuora does not set this header.  <br>  </td></tr>
         </table>
         */
        public ApiResponse<PUTSubscriptionSuspendResponseType> executeWithHttpInfo() throws ApiException {
            PUTSubscriptionSuspendType puTSubscriptionSuspendType = buildBodyParams();
            return suspendSubscriptionWithHttpInfo(subscriptionKey, puTSubscriptionSuspendType, acceptEncoding, contentEncoding, authorization, zuoraTrackId, zuoraEntityIds, zuoraOrgIds, zuoraVersion);
        }

        /**
         * Execute suspendSubscription request (asynchronously)
         * @param _callback The callback to be executed when the API call finishes
         * @return The request call
         * @throws ApiException If fail to process the API call, e.g. serializing the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td>  </td><td>  * Content-Encoding - This header is returned if you specify the &#x60;Accept-Encoding: gzip&#x60; request header and the response contains over 1000 bytes of data. Note that only the following MIME types support gzipped responses:   - &#x60;application/json&#x60;   - &#x60;application/xml&#x60;   - &#x60;text/html&#x60;   - &#x60;text/csv&#x60;   - &#x60;text/plain&#x60;  <br>  * RateLimit-Limit - The request limit quota for the time window closest to exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Remaining - The number of requests remaining in the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Reset - The number of seconds until the quota resets for the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Zuora-Request-Id - The Zuora internal identifier of the API call. You cannot control the value of this header.  <br>  * Zuora-Track-Id - A custom identifier for tracing the API call. If you specified a tracing identifier in the request headers, Zuora returns the same tracing identifier. Otherwise, Zuora does not set this header.  <br>  </td></tr>
         </table>
         */
        public okhttp3.Call executeAsync(final ApiCallback<PUTSubscriptionSuspendResponseType> _callback) throws ApiException {
            PUTSubscriptionSuspendType puTSubscriptionSuspendType = buildBodyParams();
            return suspendSubscriptionAsync(subscriptionKey, puTSubscriptionSuspendType, acceptEncoding, contentEncoding, authorization, zuoraTrackId, zuoraEntityIds, zuoraOrgIds, zuoraVersion, _callback);
        }
    }

    /**
     * Suspend a subscription
     * This REST API reference describes how to suspend an active subscription.   **Note**: If you have the Invoice Settlement feature enabled, it is best practice to set the &#x60;zuora-version&#x60; parameter to &#x60;211.0&#x60; or later [available versions](https://developer.zuora.com/api-references/api/overview/#section/API-Versions/Minor-Version). Otherwise, an error occurs. 
     * @param subscriptionKey Subscription number or ID. Subscription status must be Active. (required)
     * @param puTSubscriptionSuspendType  (required)
     * @return SuspendSubscriptionRequestBuilder
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td>  </td><td>  * Content-Encoding - This header is returned if you specify the &#x60;Accept-Encoding: gzip&#x60; request header and the response contains over 1000 bytes of data. Note that only the following MIME types support gzipped responses:   - &#x60;application/json&#x60;   - &#x60;application/xml&#x60;   - &#x60;text/html&#x60;   - &#x60;text/csv&#x60;   - &#x60;text/plain&#x60;  <br>  * RateLimit-Limit - The request limit quota for the time window closest to exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Remaining - The number of requests remaining in the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Reset - The number of seconds until the quota resets for the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Zuora-Request-Id - The Zuora internal identifier of the API call. You cannot control the value of this header.  <br>  * Zuora-Track-Id - A custom identifier for tracing the API call. If you specified a tracing identifier in the request headers, Zuora returns the same tracing identifier. Otherwise, Zuora does not set this header.  <br>  </td></tr>
     </table>
     */
    public SuspendSubscriptionRequestBuilder suspendSubscription(String suspendPolicy, String subscriptionKey) throws IllegalArgumentException {
        if (suspendPolicy == null) throw new IllegalArgumentException("\"suspendPolicy\" is required but got null");
            

        if (subscriptionKey == null) throw new IllegalArgumentException("\"subscriptionKey\" is required but got null");
            

        return new SuspendSubscriptionRequestBuilder(suspendPolicy, subscriptionKey);
    }
    private okhttp3.Call updateSubscriptionCustomFieldsOfASpecifiedVersionCall(String subscriptionNumber, String version, PUTSubscriptionPatchSpecificVersionRequestType puTSubscriptionPatchSpecificVersionRequestType, String acceptEncoding, String contentEncoding, String authorization, String zuoraTrackId, String zuoraEntityIds, String zuoraOrgIds, final ApiCallback _callback) throws ApiException {
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

        Object localVarPostBody = puTSubscriptionPatchSpecificVersionRequestType;

        // create path and map variables
        String localVarPath = "/v1/subscriptions/{subscriptionNumber}/versions/{version}/customFields"
            .replace("{" + "subscriptionNumber" + "}", localVarApiClient.escapeString(subscriptionNumber.toString()))
            .replace("{" + "version" + "}", localVarApiClient.escapeString(version.toString()));

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
    private okhttp3.Call updateSubscriptionCustomFieldsOfASpecifiedVersionValidateBeforeCall(String subscriptionNumber, String version, PUTSubscriptionPatchSpecificVersionRequestType puTSubscriptionPatchSpecificVersionRequestType, String acceptEncoding, String contentEncoding, String authorization, String zuoraTrackId, String zuoraEntityIds, String zuoraOrgIds, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'subscriptionNumber' is set
        if (subscriptionNumber == null) {
            throw new ApiException("Missing the required parameter 'subscriptionNumber' when calling updateSubscriptionCustomFieldsOfASpecifiedVersion(Async)");
        }

        // verify the required parameter 'version' is set
        if (version == null) {
            throw new ApiException("Missing the required parameter 'version' when calling updateSubscriptionCustomFieldsOfASpecifiedVersion(Async)");
        }

        // verify the required parameter 'puTSubscriptionPatchSpecificVersionRequestType' is set
        if (puTSubscriptionPatchSpecificVersionRequestType == null) {
            throw new ApiException("Missing the required parameter 'puTSubscriptionPatchSpecificVersionRequestType' when calling updateSubscriptionCustomFieldsOfASpecifiedVersion(Async)");
        }

        return updateSubscriptionCustomFieldsOfASpecifiedVersionCall(subscriptionNumber, version, puTSubscriptionPatchSpecificVersionRequestType, acceptEncoding, contentEncoding, authorization, zuoraTrackId, zuoraEntityIds, zuoraOrgIds, _callback);

    }


    private ApiResponse<CommonResponse> updateSubscriptionCustomFieldsOfASpecifiedVersionWithHttpInfo(String subscriptionNumber, String version, PUTSubscriptionPatchSpecificVersionRequestType puTSubscriptionPatchSpecificVersionRequestType, String acceptEncoding, String contentEncoding, String authorization, String zuoraTrackId, String zuoraEntityIds, String zuoraOrgIds) throws ApiException {
        okhttp3.Call localVarCall = updateSubscriptionCustomFieldsOfASpecifiedVersionValidateBeforeCall(subscriptionNumber, version, puTSubscriptionPatchSpecificVersionRequestType, acceptEncoding, contentEncoding, authorization, zuoraTrackId, zuoraEntityIds, zuoraOrgIds, null);
        Type localVarReturnType = new TypeToken<CommonResponse>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    private okhttp3.Call updateSubscriptionCustomFieldsOfASpecifiedVersionAsync(String subscriptionNumber, String version, PUTSubscriptionPatchSpecificVersionRequestType puTSubscriptionPatchSpecificVersionRequestType, String acceptEncoding, String contentEncoding, String authorization, String zuoraTrackId, String zuoraEntityIds, String zuoraOrgIds, final ApiCallback<CommonResponse> _callback) throws ApiException {

        okhttp3.Call localVarCall = updateSubscriptionCustomFieldsOfASpecifiedVersionValidateBeforeCall(subscriptionNumber, version, puTSubscriptionPatchSpecificVersionRequestType, acceptEncoding, contentEncoding, authorization, zuoraTrackId, zuoraEntityIds, zuoraOrgIds, _callback);
        Type localVarReturnType = new TypeToken<CommonResponse>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    public class UpdateSubscriptionCustomFieldsOfASpecifiedVersionRequestBuilder {
        private final String subscriptionNumber;
        private final String version;
        private Map<String, Object> customFields;
        private List<PUTSubscriptionPatchSpecificVersionRequestTypeRatePlansInner> ratePlans;
        private String acceptEncoding;
        private String contentEncoding;
        private String authorization;
        private String zuoraTrackId;
        private String zuoraEntityIds;
        private String zuoraOrgIds;

        private UpdateSubscriptionCustomFieldsOfASpecifiedVersionRequestBuilder(String subscriptionNumber, String version) {
            this.subscriptionNumber = subscriptionNumber;
            this.version = version;
        }

        /**
         * Set customFields
         * @param customFields Container for custom fields of a Subscription object.  (optional)
         * @return UpdateSubscriptionCustomFieldsOfASpecifiedVersionRequestBuilder
         */
        public UpdateSubscriptionCustomFieldsOfASpecifiedVersionRequestBuilder customFields(Map<String, Object> customFields) {
            this.customFields = customFields;
            return this;
        }
        
        /**
         * Set ratePlans
         * @param ratePlans  (optional)
         * @return UpdateSubscriptionCustomFieldsOfASpecifiedVersionRequestBuilder
         */
        public UpdateSubscriptionCustomFieldsOfASpecifiedVersionRequestBuilder ratePlans(List<PUTSubscriptionPatchSpecificVersionRequestTypeRatePlansInner> ratePlans) {
            this.ratePlans = ratePlans;
            return this;
        }
        
        /**
         * Set acceptEncoding
         * @param acceptEncoding Include the &#x60;Accept-Encoding: gzip&#x60; header to compress responses as a gzipped file. It can significantly reduce the bandwidth required for a response.   If specified, Zuora automatically compresses responses that contain over 1000 bytes of data, and the response contains a &#x60;Content-Encoding&#x60; header with the compression algorithm so that your client can decompress it.  (optional)
         * @return UpdateSubscriptionCustomFieldsOfASpecifiedVersionRequestBuilder
         */
        public UpdateSubscriptionCustomFieldsOfASpecifiedVersionRequestBuilder acceptEncoding(String acceptEncoding) {
            this.acceptEncoding = acceptEncoding;
            return this;
        }
        
        /**
         * Set contentEncoding
         * @param contentEncoding Include the &#x60;Content-Encoding: gzip&#x60; header to compress a request. With this header specified, you should upload a gzipped file for the request payload instead of sending the JSON payload.  (optional)
         * @return UpdateSubscriptionCustomFieldsOfASpecifiedVersionRequestBuilder
         */
        public UpdateSubscriptionCustomFieldsOfASpecifiedVersionRequestBuilder contentEncoding(String contentEncoding) {
            this.contentEncoding = contentEncoding;
            return this;
        }
        
        /**
         * Set authorization
         * @param authorization The value is in the &#x60;Bearer {token}&#x60; format where {token} is a valid OAuth token generated by calling [Create an OAuth token](https://developer.zuora.com/api-references/api/operation/createToken).  (optional)
         * @return UpdateSubscriptionCustomFieldsOfASpecifiedVersionRequestBuilder
         */
        public UpdateSubscriptionCustomFieldsOfASpecifiedVersionRequestBuilder authorization(String authorization) {
            this.authorization = authorization;
            return this;
        }
        
        /**
         * Set zuoraTrackId
         * @param zuoraTrackId A custom identifier for tracing the API call. If you set a value for this header, Zuora returns the same value in the response headers. This header enables you to associate your system process identifiers with Zuora API calls, to assist with troubleshooting in the event of an issue.  The value of this field must use the US-ASCII character set and must not include any of the following characters: colon (&#x60;:&#x60;), semicolon (&#x60;;&#x60;), double quote (&#x60;\&quot;&#x60;), and quote (&#x60;&#39;&#x60;).  (optional)
         * @return UpdateSubscriptionCustomFieldsOfASpecifiedVersionRequestBuilder
         */
        public UpdateSubscriptionCustomFieldsOfASpecifiedVersionRequestBuilder zuoraTrackId(String zuoraTrackId) {
            this.zuoraTrackId = zuoraTrackId;
            return this;
        }
        
        /**
         * Set zuoraEntityIds
         * @param zuoraEntityIds An entity ID. If you have [Zuora Multi-entity](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Multi-entity) enabled and the OAuth token is valid for more than one entity, you must use this header to specify which entity to perform the operation in. If the OAuth token is only valid for a single entity, or you do not have Zuora Multi-entity enabled, you do not need to set this header.  (optional)
         * @return UpdateSubscriptionCustomFieldsOfASpecifiedVersionRequestBuilder
         */
        public UpdateSubscriptionCustomFieldsOfASpecifiedVersionRequestBuilder zuoraEntityIds(String zuoraEntityIds) {
            this.zuoraEntityIds = zuoraEntityIds;
            return this;
        }
        
        /**
         * Set zuoraOrgIds
         * @param zuoraOrgIds Comma separated IDs. If you have &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Central_Platform/Multi-Org\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Zuora Multi-Org&lt;/a&gt; enabled,  you can use this header to specify which orgs to perform the operation in. If you do not have Zuora Multi-Org enabled, you should not set this header.  The IDs must be a sub-set of the user&#39;s accessible orgs. If you specify an org that the user does not have access to, the operation fails.  If the header is not set, the operation is performed in scope of the user&#39;s accessible orgs.  (optional)
         * @return UpdateSubscriptionCustomFieldsOfASpecifiedVersionRequestBuilder
         */
        public UpdateSubscriptionCustomFieldsOfASpecifiedVersionRequestBuilder zuoraOrgIds(String zuoraOrgIds) {
            this.zuoraOrgIds = zuoraOrgIds;
            return this;
        }
        
        /**
         * Build call for updateSubscriptionCustomFieldsOfASpecifiedVersion
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
            PUTSubscriptionPatchSpecificVersionRequestType puTSubscriptionPatchSpecificVersionRequestType = buildBodyParams();
            return updateSubscriptionCustomFieldsOfASpecifiedVersionCall(subscriptionNumber, version, puTSubscriptionPatchSpecificVersionRequestType, acceptEncoding, contentEncoding, authorization, zuoraTrackId, zuoraEntityIds, zuoraOrgIds, _callback);
        }

        private PUTSubscriptionPatchSpecificVersionRequestType buildBodyParams() {
            PUTSubscriptionPatchSpecificVersionRequestType puTSubscriptionPatchSpecificVersionRequestType = new PUTSubscriptionPatchSpecificVersionRequestType();
            puTSubscriptionPatchSpecificVersionRequestType.customFields(this.customFields);
            puTSubscriptionPatchSpecificVersionRequestType.ratePlans(this.ratePlans);
            return puTSubscriptionPatchSpecificVersionRequestType;
        }

        /**
         * Execute updateSubscriptionCustomFieldsOfASpecifiedVersion request
         * @return CommonResponse
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td>  </td><td>  * Content-Encoding - This header is returned if you specify the &#x60;Accept-Encoding: gzip&#x60; request header and the response contains over 1000 bytes of data. Note that only the following MIME types support gzipped responses:   - &#x60;application/json&#x60;   - &#x60;application/xml&#x60;   - &#x60;text/html&#x60;   - &#x60;text/csv&#x60;   - &#x60;text/plain&#x60;  <br>  * RateLimit-Limit - The request limit quota for the time window closest to exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Remaining - The number of requests remaining in the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Reset - The number of seconds until the quota resets for the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Zuora-Request-Id - The Zuora internal identifier of the API call. You cannot control the value of this header.  <br>  * Zuora-Track-Id - A custom identifier for tracing the API call. If you specified a tracing identifier in the request headers, Zuora returns the same tracing identifier. Otherwise, Zuora does not set this header.  <br>  </td></tr>
         </table>
         */
        public CommonResponse execute() throws ApiException {
            PUTSubscriptionPatchSpecificVersionRequestType puTSubscriptionPatchSpecificVersionRequestType = buildBodyParams();
            ApiResponse<CommonResponse> localVarResp = updateSubscriptionCustomFieldsOfASpecifiedVersionWithHttpInfo(subscriptionNumber, version, puTSubscriptionPatchSpecificVersionRequestType, acceptEncoding, contentEncoding, authorization, zuoraTrackId, zuoraEntityIds, zuoraOrgIds);
            return localVarResp.getResponseBody();
        }

        /**
         * Execute updateSubscriptionCustomFieldsOfASpecifiedVersion request with HTTP info returned
         * @return ApiResponse&lt;CommonResponse&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td>  </td><td>  * Content-Encoding - This header is returned if you specify the &#x60;Accept-Encoding: gzip&#x60; request header and the response contains over 1000 bytes of data. Note that only the following MIME types support gzipped responses:   - &#x60;application/json&#x60;   - &#x60;application/xml&#x60;   - &#x60;text/html&#x60;   - &#x60;text/csv&#x60;   - &#x60;text/plain&#x60;  <br>  * RateLimit-Limit - The request limit quota for the time window closest to exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Remaining - The number of requests remaining in the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Reset - The number of seconds until the quota resets for the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Zuora-Request-Id - The Zuora internal identifier of the API call. You cannot control the value of this header.  <br>  * Zuora-Track-Id - A custom identifier for tracing the API call. If you specified a tracing identifier in the request headers, Zuora returns the same tracing identifier. Otherwise, Zuora does not set this header.  <br>  </td></tr>
         </table>
         */
        public ApiResponse<CommonResponse> executeWithHttpInfo() throws ApiException {
            PUTSubscriptionPatchSpecificVersionRequestType puTSubscriptionPatchSpecificVersionRequestType = buildBodyParams();
            return updateSubscriptionCustomFieldsOfASpecifiedVersionWithHttpInfo(subscriptionNumber, version, puTSubscriptionPatchSpecificVersionRequestType, acceptEncoding, contentEncoding, authorization, zuoraTrackId, zuoraEntityIds, zuoraOrgIds);
        }

        /**
         * Execute updateSubscriptionCustomFieldsOfASpecifiedVersion request (asynchronously)
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
            PUTSubscriptionPatchSpecificVersionRequestType puTSubscriptionPatchSpecificVersionRequestType = buildBodyParams();
            return updateSubscriptionCustomFieldsOfASpecifiedVersionAsync(subscriptionNumber, version, puTSubscriptionPatchSpecificVersionRequestType, acceptEncoding, contentEncoding, authorization, zuoraTrackId, zuoraEntityIds, zuoraOrgIds, _callback);
        }
    }

    /**
     * Update subscription custom fields of a subscription version
     * Updates the custom fields of a specified subscription version. 
     * @param subscriptionNumber The subscription number to be updated. (required)
     * @param version The subscription version to be updated. (required)
     * @param puTSubscriptionPatchSpecificVersionRequestType  (required)
     * @return UpdateSubscriptionCustomFieldsOfASpecifiedVersionRequestBuilder
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td>  </td><td>  * Content-Encoding - This header is returned if you specify the &#x60;Accept-Encoding: gzip&#x60; request header and the response contains over 1000 bytes of data. Note that only the following MIME types support gzipped responses:   - &#x60;application/json&#x60;   - &#x60;application/xml&#x60;   - &#x60;text/html&#x60;   - &#x60;text/csv&#x60;   - &#x60;text/plain&#x60;  <br>  * RateLimit-Limit - The request limit quota for the time window closest to exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Remaining - The number of requests remaining in the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Reset - The number of seconds until the quota resets for the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Zuora-Request-Id - The Zuora internal identifier of the API call. You cannot control the value of this header.  <br>  * Zuora-Track-Id - A custom identifier for tracing the API call. If you specified a tracing identifier in the request headers, Zuora returns the same tracing identifier. Otherwise, Zuora does not set this header.  <br>  </td></tr>
     </table>
     */
    public UpdateSubscriptionCustomFieldsOfASpecifiedVersionRequestBuilder updateSubscriptionCustomFieldsOfASpecifiedVersion(String subscriptionNumber, String version) throws IllegalArgumentException {
        if (subscriptionNumber == null) throw new IllegalArgumentException("\"subscriptionNumber\" is required but got null");
            

        if (version == null) throw new IllegalArgumentException("\"version\" is required but got null");
            

        return new UpdateSubscriptionCustomFieldsOfASpecifiedVersionRequestBuilder(subscriptionNumber, version);
    }
}
