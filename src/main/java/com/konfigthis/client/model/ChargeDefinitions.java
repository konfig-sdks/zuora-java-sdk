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


package com.konfigthis.client.model;

import java.util.Objects;
import java.util.Arrays;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.konfigthis.client.model.FinanceInformationProperty1;
import com.konfigthis.client.model.GETDeliverySchedule;
import com.konfigthis.client.model.GETProductChargeDefinitionPricing;
import com.konfigthis.client.model.GETProductDiscountApplyDetailsType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.openapitools.jackson.nullable.JsonNullable;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.konfigthis.client.JSON;

/**
 * ChargeDefinitions
 */@javax.annotation.Generated(value = "Generated by https://konfigthis.com")
public class ChargeDefinitions {
  public static final String SERIALIZED_NAME_DESCRIPTION = "description";
  @SerializedName(SERIALIZED_NAME_DESCRIPTION)
  private String description;

  /**
   * Indicates which type of charge the discount charge applies to. 
   */
  @JsonAdapter(ApplyDiscountToEnum.Adapter.class)
 public enum ApplyDiscountToEnum {
    ONETIME("ONETIME"),
    
    RECURRING("RECURRING"),
    
    USAGE("USAGE"),
    
    ONETIMERECURRING("ONETIMERECURRING"),
    
    ONETIMEUSAGE("ONETIMEUSAGE"),
    
    RECURRINGUSAGE("RECURRINGUSAGE"),
    
    ONETIMERECURRINGUSAGE("ONETIMERECURRINGUSAGE"),
    
    NULL("null");

    private String value;

    ApplyDiscountToEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static ApplyDiscountToEnum fromValue(String value) {
      for (ApplyDiscountToEnum b : ApplyDiscountToEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      return null;
    }

    public static class Adapter extends TypeAdapter<ApplyDiscountToEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final ApplyDiscountToEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public ApplyDiscountToEnum read(final JsonReader jsonReader) throws IOException {
        String value =  jsonReader.nextString();
        return ApplyDiscountToEnum.fromValue(value);
      }
    }
  }

  public static final String SERIALIZED_NAME_APPLY_DISCOUNT_TO = "applyDiscountTo";
  @SerializedName(SERIALIZED_NAME_APPLY_DISCOUNT_TO)
  private ApplyDiscountToEnum applyDiscountTo;

  public static final String SERIALIZED_NAME_BILLING_DAY = "billingDay";
  @SerializedName(SERIALIZED_NAME_BILLING_DAY)
  private String billingDay;

  public static final String SERIALIZED_NAME_BILLING_PERIOD = "billingPeriod";
  @SerializedName(SERIALIZED_NAME_BILLING_PERIOD)
  private String billingPeriod;

  /**
   * The billing period alignment setting for the charge. 
   */
  @JsonAdapter(BillingPeriodAlignmentEnum.Adapter.class)
 public enum BillingPeriodAlignmentEnum {
    ALIGNTOCHARGE("AlignToCharge"),
    
    ALIGNTOSUBSCRIPTIONSTART("AlignToSubscriptionStart"),
    
    ALIGNTOTERMSTART("AlignToTermStart"),
    
    ALIGNTOTERMEND("AlignToTermEnd");

    private String value;

    BillingPeriodAlignmentEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static BillingPeriodAlignmentEnum fromValue(String value) {
      for (BillingPeriodAlignmentEnum b : BillingPeriodAlignmentEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<BillingPeriodAlignmentEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final BillingPeriodAlignmentEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public BillingPeriodAlignmentEnum read(final JsonReader jsonReader) throws IOException {
        String value =  jsonReader.nextString();
        return BillingPeriodAlignmentEnum.fromValue(value);
      }
    }
  }

  public static final String SERIALIZED_NAME_BILLING_PERIOD_ALIGNMENT = "billingPeriodAlignment";
  @SerializedName(SERIALIZED_NAME_BILLING_PERIOD_ALIGNMENT)
  private BillingPeriodAlignmentEnum billingPeriodAlignment;

  /**
   * The billing timing setting for the product charge definition. 
   */
  @JsonAdapter(BillingTimingEnum.Adapter.class)
 public enum BillingTimingEnum {
    ADVANCE("IN_ADVANCE"),
    
    ARREARS("IN_ARREARS");

    private String value;

    BillingTimingEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static BillingTimingEnum fromValue(String value) {
      for (BillingTimingEnum b : BillingTimingEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<BillingTimingEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final BillingTimingEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public BillingTimingEnum read(final JsonReader jsonReader) throws IOException {
        String value =  jsonReader.nextString();
        return BillingTimingEnum.fromValue(value);
      }
    }
  }

  public static final String SERIALIZED_NAME_BILLING_TIMING = "billingTiming";
  @SerializedName(SERIALIZED_NAME_BILLING_TIMING)
  private BillingTimingEnum billingTiming;

  /**
   * Determines how to calculate charges. Charge models must be individually activated in Zuora Billing administration. 
   */
  @JsonAdapter(ChargeModelEnum.Adapter.class)
 public enum ChargeModelEnum {
    DISCOUNTFIXEDAMOUNT("DiscountFixedAmount"),
    
    DISCOUNTPERCENTAGE("DiscountPercentage"),
    
    FLATFEE("FlatFee"),
    
    PERUNIT("PerUnit"),
    
    OVERAGE("Overage"),
    
    TIERED("Tiered"),
    
    TIEREDWITHOVERAGE("TieredWithOverage"),
    
    VOLUME("Volume"),
    
    DELIVERY("Delivery"),
    
    MULTIATTRIBUTEPRICING("MultiAttributePricing"),
    
    PRERATEDPERUNIT("PreratedPerUnit"),
    
    PRERATEDPRICING("PreratedPricing"),
    
    HIGHWATERMARKVOLUMEPRICING("HighWatermarkVolumePricing"),
    
    HIGHWATERMARKTIEREDPRICING("HighWatermarkTieredPricing");

    private String value;

    ChargeModelEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static ChargeModelEnum fromValue(String value) {
      for (ChargeModelEnum b : ChargeModelEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<ChargeModelEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final ChargeModelEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public ChargeModelEnum read(final JsonReader jsonReader) throws IOException {
        String value =  jsonReader.nextString();
        return ChargeModelEnum.fromValue(value);
      }
    }
  }

  public static final String SERIALIZED_NAME_CHARGE_MODEL = "chargeModel";
  @SerializedName(SERIALIZED_NAME_CHARGE_MODEL)
  private ChargeModelEnum chargeModel;

  /**
   * Indicates the type of charge. 
   */
  @JsonAdapter(ChargeTypeEnum.Adapter.class)
 public enum ChargeTypeEnum {
    ONETIME("OneTime"),
    
    RECURRING("Recurring"),
    
    USAGE("Usage");

    private String value;

    ChargeTypeEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static ChargeTypeEnum fromValue(String value) {
      for (ChargeTypeEnum b : ChargeTypeEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<ChargeTypeEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final ChargeTypeEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public ChargeTypeEnum read(final JsonReader jsonReader) throws IOException {
        String value =  jsonReader.nextString();
        return ChargeTypeEnum.fromValue(value);
      }
    }
  }

  public static final String SERIALIZED_NAME_CHARGE_TYPE = "chargeType";
  @SerializedName(SERIALIZED_NAME_CHARGE_TYPE)
  private ChargeTypeEnum chargeType;

  public static final String SERIALIZED_NAME_CUSTOM_FIELDS = "customFields";
  @SerializedName(SERIALIZED_NAME_CUSTOM_FIELDS)
  private Map<String, Object> customFields = null;

  public static final String SERIALIZED_NAME_DEFAULT_QUANTITY = "defaultQuantity";
  @SerializedName(SERIALIZED_NAME_DEFAULT_QUANTITY)
  private Double defaultQuantity;

  public static final String SERIALIZED_NAME_DELIVERY_SCHEDULE = "deliverySchedule";
  @SerializedName(SERIALIZED_NAME_DELIVERY_SCHEDULE)
  private GETDeliverySchedule deliverySchedule;

  public static final String SERIALIZED_NAME_DISCOUNT_CLASS = "discountClass";
  @SerializedName(SERIALIZED_NAME_DISCOUNT_CLASS)
  private String discountClass;

  /**
   * The application scope of the discount charge. For example, if the value of this field is &#x60;subscription&#x60; and the value of the &#x60;applyDiscountTo&#x60; field is &#x60;RECURRING&#x60;, the discount charge applies to all recurring charges in the same subscription as the discount charge. 
   */
  @JsonAdapter(DiscountLevelEnum.Adapter.class)
 public enum DiscountLevelEnum {
    RATEPLAN("rateplan"),
    
    SUBSCRIPTION("subscription"),
    
    ACCOUNT("account"),
    
    NULL("null");

    private String value;

    DiscountLevelEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static DiscountLevelEnum fromValue(String value) {
      for (DiscountLevelEnum b : DiscountLevelEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      return null;
    }

    public static class Adapter extends TypeAdapter<DiscountLevelEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final DiscountLevelEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public DiscountLevelEnum read(final JsonReader jsonReader) throws IOException {
        String value =  jsonReader.nextString();
        return DiscountLevelEnum.fromValue(value);
      }
    }
  }

  public static final String SERIALIZED_NAME_DISCOUNT_LEVEL = "discountLevel";
  @SerializedName(SERIALIZED_NAME_DISCOUNT_LEVEL)
  private DiscountLevelEnum discountLevel;

  public static final String SERIALIZED_NAME_EFFECTIVE_END_DATE = "effectiveEndDate";
  @SerializedName(SERIALIZED_NAME_EFFECTIVE_END_DATE)
  private OffsetDateTime effectiveEndDate;

  public static final String SERIALIZED_NAME_EFFECTIVE_START_DATE = "effectiveStartDate";
  @SerializedName(SERIALIZED_NAME_EFFECTIVE_START_DATE)
  private OffsetDateTime effectiveStartDate;

  /**
   * The end date condition for this charge. 
   */
  @JsonAdapter(EndDateConditionEnum.Adapter.class)
 public enum EndDateConditionEnum {
    SUBSCRIPTION_END("Subscription_End"),
    
    ONE_TIME("One_Time"),
    
    FIXED_PERIOD("Fixed_Period"),
    
    SPECIFIC_END_DATE("Specific_End_Date");

    private String value;

    EndDateConditionEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static EndDateConditionEnum fromValue(String value) {
      for (EndDateConditionEnum b : EndDateConditionEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<EndDateConditionEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final EndDateConditionEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public EndDateConditionEnum read(final JsonReader jsonReader) throws IOException {
        String value =  jsonReader.nextString();
        return EndDateConditionEnum.fromValue(value);
      }
    }
  }

  public static final String SERIALIZED_NAME_END_DATE_CONDITION = "endDateCondition";
  @SerializedName(SERIALIZED_NAME_END_DATE_CONDITION)
  private EndDateConditionEnum endDateCondition;

  public static final String SERIALIZED_NAME_EXCLUDE_ITEM_BILLING_FROM_REVENUE_ACCOUNTING = "excludeItemBillingFromRevenueAccounting";
  @SerializedName(SERIALIZED_NAME_EXCLUDE_ITEM_BILLING_FROM_REVENUE_ACCOUNTING)
  private Boolean excludeItemBillingFromRevenueAccounting;

  public static final String SERIALIZED_NAME_EXCLUDE_ITEM_BOOKING_FROM_REVENUE_ACCOUNTING = "excludeItemBookingFromRevenueAccounting";
  @SerializedName(SERIALIZED_NAME_EXCLUDE_ITEM_BOOKING_FROM_REVENUE_ACCOUNTING)
  private Boolean excludeItemBookingFromRevenueAccounting;

  public static final String SERIALIZED_NAME_IS_ALLOCATION_ELIGIBLE = "isAllocationEligible";
  @SerializedName(SERIALIZED_NAME_IS_ALLOCATION_ELIGIBLE)
  private Boolean isAllocationEligible;

  public static final String SERIALIZED_NAME_IS_UNBILLED = "isUnbilled";
  @SerializedName(SERIALIZED_NAME_IS_UNBILLED)
  private Boolean isUnbilled;

  public static final String SERIALIZED_NAME_PRODUCT_CATEGORY = "productCategory";
  @SerializedName(SERIALIZED_NAME_PRODUCT_CATEGORY)
  private String productCategory;

  public static final String SERIALIZED_NAME_PRODUCT_CLASS = "productClass";
  @SerializedName(SERIALIZED_NAME_PRODUCT_CLASS)
  private String productClass;

  public static final String SERIALIZED_NAME_PRODUCT_FAMILY = "productFamily";
  @SerializedName(SERIALIZED_NAME_PRODUCT_FAMILY)
  private String productFamily;

  public static final String SERIALIZED_NAME_PRODUCT_LINE = "productLine";
  @SerializedName(SERIALIZED_NAME_PRODUCT_LINE)
  private String productLine;

  /**
   * Specifies the type of revenue recognition timing.  Predefined options are listed as enum values in this API Reference.  Other options might also be avaliable depending on  the &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Enable_Order_to_Revenue/Configure_revenue_settings/Configure_revenue_recognition_policy\&quot; target&#x3D;\&quot;_blank\&quot;&gt;revenue recognition policy configuration&lt;/a&gt; in the Zuora Billing UI.  **Note**: This field is only available if you have the Order to Revenue feature enabled.  
   */
  @JsonAdapter(RevenueRecognitionTimingEnum.Adapter.class)
 public enum RevenueRecognitionTimingEnum {
    BILLING_DOCUMENT_POSTING_DATE("Upon Billing Document Posting Date"),
    
    ORDER_ACTIVATION_DATE("Upon Order Activation Date");

    private String value;

    RevenueRecognitionTimingEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static RevenueRecognitionTimingEnum fromValue(String value) {
      for (RevenueRecognitionTimingEnum b : RevenueRecognitionTimingEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<RevenueRecognitionTimingEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final RevenueRecognitionTimingEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public RevenueRecognitionTimingEnum read(final JsonReader jsonReader) throws IOException {
        String value =  jsonReader.nextString();
        return RevenueRecognitionTimingEnum.fromValue(value);
      }
    }
  }

  public static final String SERIALIZED_NAME_REVENUE_RECOGNITION_TIMING = "revenueRecognitionTiming";
  @SerializedName(SERIALIZED_NAME_REVENUE_RECOGNITION_TIMING)
  private RevenueRecognitionTimingEnum revenueRecognitionTiming;

  /**
   * Specifies the type of revenue amortization method.  Predefined options are listed as enum values in this API Reference.  Other options might also be avaliable depending on  the &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Enable_Order_to_Revenue/Configure_revenue_settings/Configure_revenue_recognition_policy\&quot; target&#x3D;\&quot;_blank\&quot;&gt;revenue recognition policy configuration&lt;/a&gt; in the Zuora Billing UI.  **Note**: This field is only available if you have the Order to Revenue feature enabled.  
   */
  @JsonAdapter(RevenueAmortizationMethodEnum.Adapter.class)
 public enum RevenueAmortizationMethodEnum {
    IMMEDIATE("Immediate"),
    
    RATABLE_USING_START_AND_END_DATES("Ratable Using Start And End Dates");

    private String value;

    RevenueAmortizationMethodEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static RevenueAmortizationMethodEnum fromValue(String value) {
      for (RevenueAmortizationMethodEnum b : RevenueAmortizationMethodEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<RevenueAmortizationMethodEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final RevenueAmortizationMethodEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public RevenueAmortizationMethodEnum read(final JsonReader jsonReader) throws IOException {
        String value =  jsonReader.nextString();
        return RevenueAmortizationMethodEnum.fromValue(value);
      }
    }
  }

  public static final String SERIALIZED_NAME_REVENUE_AMORTIZATION_METHOD = "revenueAmortizationMethod";
  @SerializedName(SERIALIZED_NAME_REVENUE_AMORTIZATION_METHOD)
  private RevenueAmortizationMethodEnum revenueAmortizationMethod;

  public static final String SERIALIZED_NAME_NUMBER_OF_PERIODS = "numberOfPeriods";
  @SerializedName(SERIALIZED_NAME_NUMBER_OF_PERIODS)
  private Long numberOfPeriods;

  public static final String SERIALIZED_NAME_FINANCE_INFORMATION = "financeInformation";
  @SerializedName(SERIALIZED_NAME_FINANCE_INFORMATION)
  private FinanceInformationProperty1 financeInformation;

  public static final String SERIALIZED_NAME_IS_DEFAULT = "isDefault";
  @SerializedName(SERIALIZED_NAME_IS_DEFAULT)
  private Boolean isDefault;

  public static final String SERIALIZED_NAME_IS_STACKED_DISCOUNT = "isStackedDiscount";
  @SerializedName(SERIALIZED_NAME_IS_STACKED_DISCOUNT)
  private Boolean isStackedDiscount;

  /**
   * The list price base.   This field is applicable only for recurring charges.  **Note**: The &#x60;Per_Year&#x60; enum value is available only if you have the &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Billing/Subscriptions/Product_Catalog/I_Annual_List_Price\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Annual List Price&lt;/a&gt; feature enabled. 
   */
  @JsonAdapter(ListPriceBaseEnum.Adapter.class)
 public enum ListPriceBaseEnum {
    BILLING_PERIOD("Per_Billing_Period"),
    
    MONTH("Per_Month"),
    
    WEEK("Per_Week"),
    
    YEAR("Per_Year");

    private String value;

    ListPriceBaseEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static ListPriceBaseEnum fromValue(String value) {
      for (ListPriceBaseEnum b : ListPriceBaseEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<ListPriceBaseEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final ListPriceBaseEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public ListPriceBaseEnum read(final JsonReader jsonReader) throws IOException {
        String value =  jsonReader.nextString();
        return ListPriceBaseEnum.fromValue(value);
      }
    }
  }

  public static final String SERIALIZED_NAME_LIST_PRICE_BASE = "listPriceBase";
  @SerializedName(SERIALIZED_NAME_LIST_PRICE_BASE)
  private ListPriceBaseEnum listPriceBase;

  public static final String SERIALIZED_NAME_NUMBER_OF_PERIOD = "numberOfPeriod";
  @SerializedName(SERIALIZED_NAME_NUMBER_OF_PERIOD)
  private Long numberOfPeriod;

  /**
   * Determines when to calculate overage charges. If the value of the &#x60;SmoothingMode&#x60; field is not specified, the value of this field is ignored.  **Values**:    - &#x60;EndOfSmoothingPeriod&#x60;: This option is used by default. The overage is charged at the end of the smoothing period.   - &#x60;PerBillingPeriod&#x60;: The overage is charged on-demand rather than waiting until the end of the smoothing period. 
   */
  @JsonAdapter(OverageCalculationOptionEnum.Adapter.class)
 public enum OverageCalculationOptionEnum {
    ENDOFSMOOTHINGPERIOD("EndOfSmoothingPeriod"),
    
    PERBILLINGPERIOD("PerBillingPeriod"),
    
    NULL("null");

    private String value;

    OverageCalculationOptionEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static OverageCalculationOptionEnum fromValue(String value) {
      for (OverageCalculationOptionEnum b : OverageCalculationOptionEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      return null;
    }

    public static class Adapter extends TypeAdapter<OverageCalculationOptionEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final OverageCalculationOptionEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public OverageCalculationOptionEnum read(final JsonReader jsonReader) throws IOException {
        String value =  jsonReader.nextString();
        return OverageCalculationOptionEnum.fromValue(value);
      }
    }
  }

  public static final String SERIALIZED_NAME_OVERAGE_CALCULATION_OPTION = "overageCalculationOption";
  @SerializedName(SERIALIZED_NAME_OVERAGE_CALCULATION_OPTION)
  private OverageCalculationOptionEnum overageCalculationOption;

  /**
   * Determines whether to credit the customer with unused units of usage. 
   */
  @JsonAdapter(OverageUnusedUnitsCreditOptionEnum.Adapter.class)
 public enum OverageUnusedUnitsCreditOptionEnum {
    NOCREDIT("NoCredit"),
    
    CREDITBYSPECIFICRATE("CreditBySpecificRate"),
    
    NULL("null");

    private String value;

    OverageUnusedUnitsCreditOptionEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static OverageUnusedUnitsCreditOptionEnum fromValue(String value) {
      for (OverageUnusedUnitsCreditOptionEnum b : OverageUnusedUnitsCreditOptionEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      return null;
    }

    public static class Adapter extends TypeAdapter<OverageUnusedUnitsCreditOptionEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final OverageUnusedUnitsCreditOptionEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public OverageUnusedUnitsCreditOptionEnum read(final JsonReader jsonReader) throws IOException {
        String value =  jsonReader.nextString();
        return OverageUnusedUnitsCreditOptionEnum.fromValue(value);
      }
    }
  }

  public static final String SERIALIZED_NAME_OVERAGE_UNUSED_UNITS_CREDIT_OPTION = "overageUnusedUnitsCreditOption";
  @SerializedName(SERIALIZED_NAME_OVERAGE_UNUSED_UNITS_CREDIT_OPTION)
  private OverageUnusedUnitsCreditOptionEnum overageUnusedUnitsCreditOption;

  /**
   * Applies an automatic price change when a termed subscription is renewed. 
   */
  @JsonAdapter(PriceChangeOptionEnum.Adapter.class)
 public enum PriceChangeOptionEnum {
    NOCHANGE("NoChange"),
    
    SPECIFICPERCENTAGEVALUE("SpecificPercentageValue"),
    
    USELATESTPRODUCTCATALOGPRICING("UseLatestProductCatalogPricing"),
    
    NULL("null");

    private String value;

    PriceChangeOptionEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static PriceChangeOptionEnum fromValue(String value) {
      for (PriceChangeOptionEnum b : PriceChangeOptionEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      return null;
    }

    public static class Adapter extends TypeAdapter<PriceChangeOptionEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final PriceChangeOptionEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public PriceChangeOptionEnum read(final JsonReader jsonReader) throws IOException {
        String value =  jsonReader.nextString();
        return PriceChangeOptionEnum.fromValue(value);
      }
    }
  }

  public static final String SERIALIZED_NAME_PRICE_CHANGE_OPTION = "priceChangeOption";
  @SerializedName(SERIALIZED_NAME_PRICE_CHANGE_OPTION)
  private PriceChangeOptionEnum priceChangeOption = PriceChangeOptionEnum.NOCHANGE;

  /**
   * Applies an automatic price change when a termed subscription is renewed. 
   */
  @JsonAdapter(PriceIncreaseOptionEnum.Adapter.class)
 public enum PriceIncreaseOptionEnum {
    FROMTENANTPERCENTAGEVALUE("FromTenantPercentageValue"),
    
    SPECIFICPERCENTAGEVALUE("SpecificPercentageValue");

    private String value;

    PriceIncreaseOptionEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static PriceIncreaseOptionEnum fromValue(String value) {
      for (PriceIncreaseOptionEnum b : PriceIncreaseOptionEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<PriceIncreaseOptionEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final PriceIncreaseOptionEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public PriceIncreaseOptionEnum read(final JsonReader jsonReader) throws IOException {
        String value =  jsonReader.nextString();
        return PriceIncreaseOptionEnum.fromValue(value);
      }
    }
  }

  public static final String SERIALIZED_NAME_PRICE_INCREASE_OPTION = "priceIncreaseOption";
  @SerializedName(SERIALIZED_NAME_PRICE_INCREASE_OPTION)
  private PriceIncreaseOptionEnum priceIncreaseOption;

  public static final String SERIALIZED_NAME_PRICE_INCREASE_PERCENTAGE = "priceIncreasePercentage";
  @SerializedName(SERIALIZED_NAME_PRICE_INCREASE_PERCENTAGE)
  private Double priceIncreasePercentage;

  public static final String SERIALIZED_NAME_PRICES = "prices";
  @SerializedName(SERIALIZED_NAME_PRICES)
  private List<GETProductChargeDefinitionPricing> prices = null;

  public static final String SERIALIZED_NAME_PRODUCT_CHARGE_DEFINITION_ID = "productChargeDefinitionId";
  @SerializedName(SERIALIZED_NAME_PRODUCT_CHARGE_DEFINITION_ID)
  private String productChargeDefinitionId;

  public static final String SERIALIZED_NAME_PRODUCT_CHARGE_DEFINITION_NUMBER = "productChargeDefinitionNumber";
  @SerializedName(SERIALIZED_NAME_PRODUCT_CHARGE_DEFINITION_NUMBER)
  private String productChargeDefinitionNumber;

  public static final String SERIALIZED_NAME_PRODUCT_DISCOUNT_APPLY_DETAILS = "productDiscountApplyDetails";
  @SerializedName(SERIALIZED_NAME_PRODUCT_DISCOUNT_APPLY_DETAILS)
  private List<GETProductDiscountApplyDetailsType> productDiscountApplyDetails = null;

  public static final String SERIALIZED_NAME_PRODUCT_RATE_PLAN_CHARGE_ID = "productRatePlanChargeId";
  @SerializedName(SERIALIZED_NAME_PRODUCT_RATE_PLAN_CHARGE_ID)
  private String productRatePlanChargeId;

  public static final String SERIALIZED_NAME_PRODUCT_RATE_PLAN_CHARGE_NUMBER = "productRatePlanChargeNumber";
  @SerializedName(SERIALIZED_NAME_PRODUCT_RATE_PLAN_CHARGE_NUMBER)
  private String productRatePlanChargeNumber;

  public static final String SERIALIZED_NAME_PRODUCT_RATE_PLAN_ID = "productRatePlanId";
  @SerializedName(SERIALIZED_NAME_PRODUCT_RATE_PLAN_ID)
  private String productRatePlanId;

  public static final String SERIALIZED_NAME_PRODUCT_RATE_PLAN_NAME = "productRatePlanName";
  @SerializedName(SERIALIZED_NAME_PRODUCT_RATE_PLAN_NAME)
  private String productRatePlanName;

  public static final String SERIALIZED_NAME_PRODUCT_RATE_PLAN_NUMBER = "productRatePlanNumber";
  @SerializedName(SERIALIZED_NAME_PRODUCT_RATE_PLAN_NUMBER)
  private String productRatePlanNumber;

  /**
   * The rating group based on which usage records are rated.  Possible values:                   - &#x60;ByBillingPeriod&#x60;: The rating is based on all the usages in a billing period.    - &#x60;ByUsageStartDate&#x60;: The rating is based on all the usages on the same usage start date.    - &#x60;ByUsageRecord&#x60;: The rating is based on each usage record.   - &#x60;ByUsageUpload&#x60;: The rating is based on all the  usages in a uploaded usage file (&#x60;.xls&#x60; or &#x60;.csv&#x60;).   - &#x60;ByGroupId&#x60;: The rating is based on all the usages in a custom group.  **Notes:**    - The &#x60;ByBillingPeriod&#x60; value can be applied for all charge models.    - The &#x60;ByUsageStartDate&#x60;, &#x60;ByUsageRecord&#x60;, and &#x60;ByUsageUpload&#x60; values can only be applied for Per Unit, Volume Pricing, and Tiered Pricing charge models.    - The &#x60;ByGroupId&#x60; value is only available if you have the Active Rating feature enabled.   - Use this field only for Usage charges. One-time charges and recurring charges return &#x60;NULL&#x60;. 
   */
  @JsonAdapter(RatingGroupEnum.Adapter.class)
 public enum RatingGroupEnum {
    BYBILLINGPERIOD("ByBillingPeriod"),
    
    BYUSAGESTARTDATE("ByUsageStartDate"),
    
    BYUSAGERECORD("ByUsageRecord"),
    
    BYUSAGEUPLOAD("ByUsageUpload"),
    
    BYGROUPID("ByGroupId"),
    
    NULL("null");

    private String value;

    RatingGroupEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static RatingGroupEnum fromValue(String value) {
      for (RatingGroupEnum b : RatingGroupEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      return null;
    }

    public static class Adapter extends TypeAdapter<RatingGroupEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final RatingGroupEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public RatingGroupEnum read(final JsonReader jsonReader) throws IOException {
        String value =  jsonReader.nextString();
        return RatingGroupEnum.fromValue(value);
      }
    }
  }

  public static final String SERIALIZED_NAME_RATING_GROUP = "ratingGroup";
  @SerializedName(SERIALIZED_NAME_RATING_GROUP)
  private RatingGroupEnum ratingGroup = RatingGroupEnum.BYBILLINGPERIOD;

  public static final String SERIALIZED_NAME_RECOGNIZED_REVENUE_ACCOUNT = "recognizedRevenueAccount";
  @SerializedName(SERIALIZED_NAME_RECOGNIZED_REVENUE_ACCOUNT)
  private String recognizedRevenueAccount;

  public static final String SERIALIZED_NAME_REV_REC_CODE = "revRecCode";
  @SerializedName(SERIALIZED_NAME_REV_REC_CODE)
  private String revRecCode;

  /**
   * Indicates when revenue recognition begins. 
   */
  @JsonAdapter(RevRecTriggerConditionEnum.Adapter.class)
 public enum RevRecTriggerConditionEnum {
    CONTRACTEFFECTIVEDATE("ContractEffectiveDate"),
    
    SERVICEACTIVATIONDATE("ServiceActivationDate"),
    
    CUSTOMERACCEPTANCEDATE("CustomerAcceptanceDate"),
    
    NULL("null");

    private String value;

    RevRecTriggerConditionEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static RevRecTriggerConditionEnum fromValue(String value) {
      for (RevRecTriggerConditionEnum b : RevRecTriggerConditionEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      return null;
    }

    public static class Adapter extends TypeAdapter<RevRecTriggerConditionEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final RevRecTriggerConditionEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public RevRecTriggerConditionEnum read(final JsonReader jsonReader) throws IOException {
        String value =  jsonReader.nextString();
        return RevRecTriggerConditionEnum.fromValue(value);
      }
    }
  }

  public static final String SERIALIZED_NAME_REV_REC_TRIGGER_CONDITION = "revRecTriggerCondition";
  @SerializedName(SERIALIZED_NAME_REV_REC_TRIGGER_CONDITION)
  private RevRecTriggerConditionEnum revRecTriggerCondition;

  /**
   * Determines when to recognize the revenue for this charge. 
   */
  @JsonAdapter(RevenueRecognitionRuleNameEnum.Adapter.class)
 public enum RevenueRecognitionRuleNameEnum {
    UPON_INVOICING("Recognize upon invoicing"),
    
    DAILY_OVER_TIME("Recognize daily over time");

    private String value;

    RevenueRecognitionRuleNameEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static RevenueRecognitionRuleNameEnum fromValue(String value) {
      for (RevenueRecognitionRuleNameEnum b : RevenueRecognitionRuleNameEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<RevenueRecognitionRuleNameEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final RevenueRecognitionRuleNameEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public RevenueRecognitionRuleNameEnum read(final JsonReader jsonReader) throws IOException {
        String value =  jsonReader.nextString();
        return RevenueRecognitionRuleNameEnum.fromValue(value);
      }
    }
  }

  public static final String SERIALIZED_NAME_REVENUE_RECOGNITION_RULE_NAME = "revenueRecognitionRuleName";
  @SerializedName(SERIALIZED_NAME_REVENUE_RECOGNITION_RULE_NAME)
  private RevenueRecognitionRuleNameEnum revenueRecognitionRuleName;

  /**
   * Indicates the smoothing model for an overage smoothing charge model. 
   */
  @JsonAdapter(SmoothingModelEnum.Adapter.class)
 public enum SmoothingModelEnum {
    ROLLINGWINDOW("RollingWindow"),
    
    ROLLOVER("Rollover"),
    
    NULL("null");

    private String value;

    SmoothingModelEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static SmoothingModelEnum fromValue(String value) {
      for (SmoothingModelEnum b : SmoothingModelEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      return null;
    }

    public static class Adapter extends TypeAdapter<SmoothingModelEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final SmoothingModelEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public SmoothingModelEnum read(final JsonReader jsonReader) throws IOException {
        String value =  jsonReader.nextString();
        return SmoothingModelEnum.fromValue(value);
      }
    }
  }

  public static final String SERIALIZED_NAME_SMOOTHING_MODEL = "smoothingModel";
  @SerializedName(SERIALIZED_NAME_SMOOTHING_MODEL)
  private SmoothingModelEnum smoothingModel;

  public static final String SERIALIZED_NAME_SPECIFIC_BILLING_PERIOD = "specificBillingPeriod";
  @SerializedName(SERIALIZED_NAME_SPECIFIC_BILLING_PERIOD)
  private Double specificBillingPeriod;

  public static final String SERIALIZED_NAME_SPECIFIC_LIST_PRICE_BASE = "specificListPriceBase";
  @SerializedName(SERIALIZED_NAME_SPECIFIC_LIST_PRICE_BASE)
  private Integer specificListPriceBase;

  public static final String SERIALIZED_NAME_TAX_CODE = "taxCode";
  @SerializedName(SERIALIZED_NAME_TAX_CODE)
  private String taxCode;

  /**
   * Determines how to define taxation for the charge.  **Note**: This value affects the tax calculation of the rate plan charge. 
   */
  @JsonAdapter(TaxModeEnum.Adapter.class)
 public enum TaxModeEnum {
    TAXEXCLUSIVE("TaxExclusive"),
    
    TAXINCLUSIVE("TaxInclusive"),
    
    NULL("null");

    private String value;

    TaxModeEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static TaxModeEnum fromValue(String value) {
      for (TaxModeEnum b : TaxModeEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      return null;
    }

    public static class Adapter extends TypeAdapter<TaxModeEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final TaxModeEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public TaxModeEnum read(final JsonReader jsonReader) throws IOException {
        String value =  jsonReader.nextString();
        return TaxModeEnum.fromValue(value);
      }
    }
  }

  public static final String SERIALIZED_NAME_TAX_MODE = "taxMode";
  @SerializedName(SERIALIZED_NAME_TAX_MODE)
  private TaxModeEnum taxMode;

  public static final String SERIALIZED_NAME_TAXABLE = "taxable";
  @SerializedName(SERIALIZED_NAME_TAXABLE)
  private Boolean taxable;

  public static final String SERIALIZED_NAME_TERM = "term";
  @SerializedName(SERIALIZED_NAME_TERM)
  private Double term;

  /**
   * The period type for the subscription term that is eligible for this charge definition. 
   */
  @JsonAdapter(TermPeriodTypeEnum.Adapter.class)
 public enum TermPeriodTypeEnum {
    MONTH("Month"),
    
    YEAR("Year"),
    
    DAY("Day"),
    
    WEEK("Week"),
    
    NULL("null");

    private String value;

    TermPeriodTypeEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static TermPeriodTypeEnum fromValue(String value) {
      for (TermPeriodTypeEnum b : TermPeriodTypeEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      return null;
    }

    public static class Adapter extends TypeAdapter<TermPeriodTypeEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final TermPeriodTypeEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public TermPeriodTypeEnum read(final JsonReader jsonReader) throws IOException {
        String value =  jsonReader.nextString();
        return TermPeriodTypeEnum.fromValue(value);
      }
    }
  }

  public static final String SERIALIZED_NAME_TERM_PERIOD_TYPE = "termPeriodType";
  @SerializedName(SERIALIZED_NAME_TERM_PERIOD_TYPE)
  private TermPeriodTypeEnum termPeriodType;

  /**
   * The type of the subscription that is eligible for this charge definition. 
   */
  @JsonAdapter(TermTypeEnum.Adapter.class)
 public enum TermTypeEnum {
    TERMED("TERMED"),
    
    EVERGREEN("EVERGREEN"),
    
    NULL("null");

    private String value;

    TermTypeEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static TermTypeEnum fromValue(String value) {
      for (TermTypeEnum b : TermTypeEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      return null;
    }

    public static class Adapter extends TypeAdapter<TermTypeEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final TermTypeEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public TermTypeEnum read(final JsonReader jsonReader) throws IOException {
        String value =  jsonReader.nextString();
        return TermTypeEnum.fromValue(value);
      }
    }
  }

  public static final String SERIALIZED_NAME_TERM_TYPE = "termType";
  @SerializedName(SERIALIZED_NAME_TERM_TYPE)
  private TermTypeEnum termType;

  /**
   * Specifies when to start billing the customer for the charge definition.  **Values**:   - &#x60;ContractEffective&#x60; is the date when the subscription&#39;s contract goes into effect and the charge is ready to be billed.   - &#x60;ServiceActivation&#x60; is the date when the services or products for a subscription have been activated and the customers have access.   - &#x60;CustomerAcceptance&#x60; is when the customer accepts the services or products for a subscription. 
   */
  @JsonAdapter(TriggerEventEnum.Adapter.class)
 public enum TriggerEventEnum {
    CONTRACTEFFECTIVE("ContractEffective"),
    
    SERVICEACTIVATION("ServiceActivation"),
    
    CUSTOMERACCEPTANCE("CustomerAcceptance");

    private String value;

    TriggerEventEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static TriggerEventEnum fromValue(String value) {
      for (TriggerEventEnum b : TriggerEventEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<TriggerEventEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final TriggerEventEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public TriggerEventEnum read(final JsonReader jsonReader) throws IOException {
        String value =  jsonReader.nextString();
        return TriggerEventEnum.fromValue(value);
      }
    }
  }

  public static final String SERIALIZED_NAME_TRIGGER_EVENT = "triggerEvent";
  @SerializedName(SERIALIZED_NAME_TRIGGER_EVENT)
  private TriggerEventEnum triggerEvent;

  public static final String SERIALIZED_NAME_UOM = "uom";
  @SerializedName(SERIALIZED_NAME_UOM)
  private String uom;

  public static final String SERIALIZED_NAME_UP_TO_PERIODS = "upToPeriods";
  @SerializedName(SERIALIZED_NAME_UP_TO_PERIODS)
  private Double upToPeriods;

  /**
   * The up-to-periods type for this charge. 
   */
  @JsonAdapter(UpToPeriodsTypeEnum.Adapter.class)
 public enum UpToPeriodsTypeEnum {
    BILLING_PERIODS("Billing_Periods"),
    
    DAYS("Days"),
    
    WEEKS("Weeks"),
    
    MONTHS("Months"),
    
    YEARS("Years"),
    
    NULL("null");

    private String value;

    UpToPeriodsTypeEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static UpToPeriodsTypeEnum fromValue(String value) {
      for (UpToPeriodsTypeEnum b : UpToPeriodsTypeEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      return null;
    }

    public static class Adapter extends TypeAdapter<UpToPeriodsTypeEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final UpToPeriodsTypeEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public UpToPeriodsTypeEnum read(final JsonReader jsonReader) throws IOException {
        String value =  jsonReader.nextString();
        return UpToPeriodsTypeEnum.fromValue(value);
      }
    }
  }

  public static final String SERIALIZED_NAME_UP_TO_PERIODS_TYPE = "upToPeriodsType";
  @SerializedName(SERIALIZED_NAME_UP_TO_PERIODS_TYPE)
  private UpToPeriodsTypeEnum upToPeriodsType;

  /**
   * Determines how Zuora processes usage records for per-unit usage charges. 
   */
  @JsonAdapter(UsageRecordRatingOptionEnum.Adapter.class)
 public enum UsageRecordRatingOptionEnum {
    ENDOFBILLINGPERIOD("EndOfBillingPeriod"),
    
    ONDEMAND("OnDemand"),
    
    NULL("null");

    private String value;

    UsageRecordRatingOptionEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static UsageRecordRatingOptionEnum fromValue(String value) {
      for (UsageRecordRatingOptionEnum b : UsageRecordRatingOptionEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      return null;
    }

    public static class Adapter extends TypeAdapter<UsageRecordRatingOptionEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final UsageRecordRatingOptionEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public UsageRecordRatingOptionEnum read(final JsonReader jsonReader) throws IOException {
        String value =  jsonReader.nextString();
        return UsageRecordRatingOptionEnum.fromValue(value);
      }
    }
  }

  public static final String SERIALIZED_NAME_USAGE_RECORD_RATING_OPTION = "usageRecordRatingOption";
  @SerializedName(SERIALIZED_NAME_USAGE_RECORD_RATING_OPTION)
  private UsageRecordRatingOptionEnum usageRecordRatingOption = UsageRecordRatingOptionEnum.ENDOFBILLINGPERIOD;

  public static final String SERIALIZED_NAME_USE_DISCOUNT_SPECIFIC_ACCOUNTING_CODE = "useDiscountSpecificAccountingCode";
  @SerializedName(SERIALIZED_NAME_USE_DISCOUNT_SPECIFIC_ACCOUNTING_CODE)
  private Boolean useDiscountSpecificAccountingCode;

  public static final String SERIALIZED_NAME_USE_TENANT_DEFAULT_FOR_PRICE_CHANGE = "useTenantDefaultForPriceChange";
  @SerializedName(SERIALIZED_NAME_USE_TENANT_DEFAULT_FOR_PRICE_CHANGE)
  private Boolean useTenantDefaultForPriceChange;

  public ChargeDefinitions() {
  }

  public ChargeDefinitions description(String description) {
    
    
    
    
    this.description = description;
    return this;
  }

   /**
   * The description for the charge. 
   * @return description
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The description for the charge. ")

  public String getDescription() {
    return description;
  }


  public void setDescription(String description) {
    
    
    
    this.description = description;
  }


  public ChargeDefinitions applyDiscountTo(ApplyDiscountToEnum applyDiscountTo) {
    
    
    
    
    this.applyDiscountTo = applyDiscountTo;
    return this;
  }

   /**
   * Indicates which type of charge the discount charge applies to. 
   * @return applyDiscountTo
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Indicates which type of charge the discount charge applies to. ")

  public ApplyDiscountToEnum getApplyDiscountTo() {
    return applyDiscountTo;
  }


  public void setApplyDiscountTo(ApplyDiscountToEnum applyDiscountTo) {
    
    
    
    this.applyDiscountTo = applyDiscountTo;
  }


  public ChargeDefinitions billingDay(String billingDay) {
    
    
    
    
    this.billingDay = billingDay;
    return this;
  }

   /**
   * The bill cycle type for the charge. 
   * @return billingDay
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The bill cycle type for the charge. ")

  public String getBillingDay() {
    return billingDay;
  }


  public void setBillingDay(String billingDay) {
    
    
    
    this.billingDay = billingDay;
  }


  public ChargeDefinitions billingPeriod(String billingPeriod) {
    
    
    
    
    this.billingPeriod = billingPeriod;
    return this;
  }

   /**
   * The billing period for the product charge definition. 
   * @return billingPeriod
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The billing period for the product charge definition. ")

  public String getBillingPeriod() {
    return billingPeriod;
  }


  public void setBillingPeriod(String billingPeriod) {
    
    
    
    this.billingPeriod = billingPeriod;
  }


  public ChargeDefinitions billingPeriodAlignment(BillingPeriodAlignmentEnum billingPeriodAlignment) {
    
    
    
    
    this.billingPeriodAlignment = billingPeriodAlignment;
    return this;
  }

   /**
   * The billing period alignment setting for the charge. 
   * @return billingPeriodAlignment
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The billing period alignment setting for the charge. ")

  public BillingPeriodAlignmentEnum getBillingPeriodAlignment() {
    return billingPeriodAlignment;
  }


  public void setBillingPeriodAlignment(BillingPeriodAlignmentEnum billingPeriodAlignment) {
    
    
    
    this.billingPeriodAlignment = billingPeriodAlignment;
  }


  public ChargeDefinitions billingTiming(BillingTimingEnum billingTiming) {
    
    
    
    
    this.billingTiming = billingTiming;
    return this;
  }

   /**
   * The billing timing setting for the product charge definition. 
   * @return billingTiming
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The billing timing setting for the product charge definition. ")

  public BillingTimingEnum getBillingTiming() {
    return billingTiming;
  }


  public void setBillingTiming(BillingTimingEnum billingTiming) {
    
    
    
    this.billingTiming = billingTiming;
  }


  public ChargeDefinitions chargeModel(ChargeModelEnum chargeModel) {
    
    
    
    
    this.chargeModel = chargeModel;
    return this;
  }

   /**
   * Determines how to calculate charges. Charge models must be individually activated in Zuora Billing administration. 
   * @return chargeModel
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Determines how to calculate charges. Charge models must be individually activated in Zuora Billing administration. ")

  public ChargeModelEnum getChargeModel() {
    return chargeModel;
  }


  public void setChargeModel(ChargeModelEnum chargeModel) {
    
    
    
    this.chargeModel = chargeModel;
  }


  public ChargeDefinitions chargeType(ChargeTypeEnum chargeType) {
    
    
    
    
    this.chargeType = chargeType;
    return this;
  }

   /**
   * Indicates the type of charge. 
   * @return chargeType
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Indicates the type of charge. ")

  public ChargeTypeEnum getChargeType() {
    return chargeType;
  }


  public void setChargeType(ChargeTypeEnum chargeType) {
    
    
    
    this.chargeType = chargeType;
  }


  public ChargeDefinitions customFields(Map<String, Object> customFields) {
    
    
    
    
    this.customFields = customFields;
    return this;
  }

  public ChargeDefinitions putCustomFieldsItem(String key, Object customFieldsItem) {
    if (this.customFields == null) {
      this.customFields = new HashMap<>();
    }
    this.customFields.put(key, customFieldsItem);
    return this;
  }

   /**
   * Container for custom fields of a Product Charge Definition object. 
   * @return customFields
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Container for custom fields of a Product Charge Definition object. ")

  public Map<String, Object> getCustomFields() {
    return customFields;
  }


  public void setCustomFields(Map<String, Object> customFields) {
    
    
    
    this.customFields = customFields;
  }


  public ChargeDefinitions defaultQuantity(Double defaultQuantity) {
    
    
    
    
    this.defaultQuantity = defaultQuantity;
    return this;
  }

  public ChargeDefinitions defaultQuantity(Integer defaultQuantity) {
    
    
    
    
    this.defaultQuantity = defaultQuantity.doubleValue();
    return this;
  }

   /**
   * The default quantity.   This field is applicable only for one-time and recurring charges. 
   * @return defaultQuantity
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The default quantity.   This field is applicable only for one-time and recurring charges. ")

  public Double getDefaultQuantity() {
    return defaultQuantity;
  }


  public void setDefaultQuantity(Double defaultQuantity) {
    
    
    
    this.defaultQuantity = defaultQuantity;
  }


  public ChargeDefinitions deliverySchedule(GETDeliverySchedule deliverySchedule) {
    
    
    
    
    this.deliverySchedule = deliverySchedule;
    return this;
  }

   /**
   * Get deliverySchedule
   * @return deliverySchedule
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public GETDeliverySchedule getDeliverySchedule() {
    return deliverySchedule;
  }


  public void setDeliverySchedule(GETDeliverySchedule deliverySchedule) {
    
    
    
    this.deliverySchedule = deliverySchedule;
  }


  public ChargeDefinitions discountClass(String discountClass) {
    
    
    
    
    this.discountClass = discountClass;
    return this;
  }

   /**
   * The class that the discount belongs to. The discount class defines the order in which discount product rate plan charges are applied.  For more information, see [Manage Discount Classes](https://knowledgecenter.zuora.com/BC_Subscription_Management/Product_Catalog/B_Charge_Models/Manage_Discount_Classes). 
   * @return discountClass
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The class that the discount belongs to. The discount class defines the order in which discount product rate plan charges are applied.  For more information, see [Manage Discount Classes](https://knowledgecenter.zuora.com/BC_Subscription_Management/Product_Catalog/B_Charge_Models/Manage_Discount_Classes). ")

  public String getDiscountClass() {
    return discountClass;
  }


  public void setDiscountClass(String discountClass) {
    
    
    
    this.discountClass = discountClass;
  }


  public ChargeDefinitions discountLevel(DiscountLevelEnum discountLevel) {
    
    
    
    
    this.discountLevel = discountLevel;
    return this;
  }

   /**
   * The application scope of the discount charge. For example, if the value of this field is &#x60;subscription&#x60; and the value of the &#x60;applyDiscountTo&#x60; field is &#x60;RECURRING&#x60;, the discount charge applies to all recurring charges in the same subscription as the discount charge. 
   * @return discountLevel
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The application scope of the discount charge. For example, if the value of this field is `subscription` and the value of the `applyDiscountTo` field is `RECURRING`, the discount charge applies to all recurring charges in the same subscription as the discount charge. ")

  public DiscountLevelEnum getDiscountLevel() {
    return discountLevel;
  }


  public void setDiscountLevel(DiscountLevelEnum discountLevel) {
    
    
    
    this.discountLevel = discountLevel;
  }


  public ChargeDefinitions effectiveEndDate(OffsetDateTime effectiveEndDate) {
    
    
    
    
    this.effectiveEndDate = effectiveEndDate;
    return this;
  }

   /**
   * The effective end date of the product charge definition. 
   * @return effectiveEndDate
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The effective end date of the product charge definition. ")

  public OffsetDateTime getEffectiveEndDate() {
    return effectiveEndDate;
  }


  public void setEffectiveEndDate(OffsetDateTime effectiveEndDate) {
    
    
    
    this.effectiveEndDate = effectiveEndDate;
  }


  public ChargeDefinitions effectiveStartDate(OffsetDateTime effectiveStartDate) {
    
    
    
    
    this.effectiveStartDate = effectiveStartDate;
    return this;
  }

   /**
   * The effective start date of the product charge definition. 
   * @return effectiveStartDate
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The effective start date of the product charge definition. ")

  public OffsetDateTime getEffectiveStartDate() {
    return effectiveStartDate;
  }


  public void setEffectiveStartDate(OffsetDateTime effectiveStartDate) {
    
    
    
    this.effectiveStartDate = effectiveStartDate;
  }


  public ChargeDefinitions endDateCondition(EndDateConditionEnum endDateCondition) {
    
    
    
    
    this.endDateCondition = endDateCondition;
    return this;
  }

   /**
   * The end date condition for this charge. 
   * @return endDateCondition
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The end date condition for this charge. ")

  public EndDateConditionEnum getEndDateCondition() {
    return endDateCondition;
  }


  public void setEndDateCondition(EndDateConditionEnum endDateCondition) {
    
    
    
    this.endDateCondition = endDateCondition;
  }


  public ChargeDefinitions excludeItemBillingFromRevenueAccounting(Boolean excludeItemBillingFromRevenueAccounting) {
    
    
    
    
    this.excludeItemBillingFromRevenueAccounting = excludeItemBillingFromRevenueAccounting;
    return this;
  }

   /**
   * Indicates whether to exclude the related invoice items, invoice item adjustments, credit memo items, and debit memo items from revenue accounting.  **Note**: This field is only available if you have the Order to Revenue or Billing - Revenue Integration feature enabled.  
   * @return excludeItemBillingFromRevenueAccounting
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Indicates whether to exclude the related invoice items, invoice item adjustments, credit memo items, and debit memo items from revenue accounting.  **Note**: This field is only available if you have the Order to Revenue or Billing - Revenue Integration feature enabled.  ")

  public Boolean getExcludeItemBillingFromRevenueAccounting() {
    return excludeItemBillingFromRevenueAccounting;
  }


  public void setExcludeItemBillingFromRevenueAccounting(Boolean excludeItemBillingFromRevenueAccounting) {
    
    
    
    this.excludeItemBillingFromRevenueAccounting = excludeItemBillingFromRevenueAccounting;
  }


  public ChargeDefinitions excludeItemBookingFromRevenueAccounting(Boolean excludeItemBookingFromRevenueAccounting) {
    
    
    
    
    this.excludeItemBookingFromRevenueAccounting = excludeItemBookingFromRevenueAccounting;
    return this;
  }

   /**
   * Indicates whether to exclude the related rate plan charges and order line items from revenue accounting.  **Note**: This field is only available if you have the Order to Revenue or Billing - Revenue Integration feature enabled. 
   * @return excludeItemBookingFromRevenueAccounting
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Indicates whether to exclude the related rate plan charges and order line items from revenue accounting.  **Note**: This field is only available if you have the Order to Revenue or Billing - Revenue Integration feature enabled. ")

  public Boolean getExcludeItemBookingFromRevenueAccounting() {
    return excludeItemBookingFromRevenueAccounting;
  }


  public void setExcludeItemBookingFromRevenueAccounting(Boolean excludeItemBookingFromRevenueAccounting) {
    
    
    
    this.excludeItemBookingFromRevenueAccounting = excludeItemBookingFromRevenueAccounting;
  }


  public ChargeDefinitions isAllocationEligible(Boolean isAllocationEligible) {
    
    
    
    
    this.isAllocationEligible = isAllocationEligible;
    return this;
  }

   /**
   * Indicates whether the charge segment is allocation eligible in revenue recognition. The default value is &#x60;false&#x60;.  **Values**: &#x60;true&#x60;, &#x60;false&#x60;  **Note**: This field is available only if you have the Additional Revenue Fields property enabled. 
   * @return isAllocationEligible
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Indicates whether the charge segment is allocation eligible in revenue recognition. The default value is `false`.  **Values**: `true`, `false`  **Note**: This field is available only if you have the Additional Revenue Fields property enabled. ")

  public Boolean getIsAllocationEligible() {
    return isAllocationEligible;
  }


  public void setIsAllocationEligible(Boolean isAllocationEligible) {
    
    
    
    this.isAllocationEligible = isAllocationEligible;
  }


  public ChargeDefinitions isUnbilled(Boolean isUnbilled) {
    
    
    
    
    this.isUnbilled = isUnbilled;
    return this;
  }

   /**
   * Specifies how to perform the accounting during revenue recognition. The default value is &#x60;false&#x60;.  **Values**: &#x60;true&#x60;, &#x60;false&#x60;  **Note**: This field is available only if you have the Additional Revenue Fields property enabled.      
   * @return isUnbilled
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Specifies how to perform the accounting during revenue recognition. The default value is `false`.  **Values**: `true`, `false`  **Note**: This field is available only if you have the Additional Revenue Fields property enabled.      ")

  public Boolean getIsUnbilled() {
    return isUnbilled;
  }


  public void setIsUnbilled(Boolean isUnbilled) {
    
    
    
    this.isUnbilled = isUnbilled;
  }


  public ChargeDefinitions productCategory(String productCategory) {
    
    
    
    
    this.productCategory = productCategory;
    return this;
  }

   /**
   * This field is used to maintain the product category for integration with Zuora Revenue.   **Note**: This field is available only if you have the Additional Revenue Fields property enabled.     
   * @return productCategory
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "This field is used to maintain the product category for integration with Zuora Revenue.   **Note**: This field is available only if you have the Additional Revenue Fields property enabled.     ")

  public String getProductCategory() {
    return productCategory;
  }


  public void setProductCategory(String productCategory) {
    
    
    
    this.productCategory = productCategory;
  }


  public ChargeDefinitions productClass(String productClass) {
    
    
    
    
    this.productClass = productClass;
    return this;
  }

   /**
   * This field is used to maintain the product class for integration with Zuora Revenue.   **Note**: This field is available only if you have the Additional Revenue Fields property enabled.     
   * @return productClass
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "This field is used to maintain the product class for integration with Zuora Revenue.   **Note**: This field is available only if you have the Additional Revenue Fields property enabled.     ")

  public String getProductClass() {
    return productClass;
  }


  public void setProductClass(String productClass) {
    
    
    
    this.productClass = productClass;
  }


  public ChargeDefinitions productFamily(String productFamily) {
    
    
    
    
    this.productFamily = productFamily;
    return this;
  }

   /**
   * This field is used to maintain the product family for integration with Zuora Revenue.   **Note**: This field is available only if you have the Additional Revenue Fields property enabled. 
   * @return productFamily
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "This field is used to maintain the product family for integration with Zuora Revenue.   **Note**: This field is available only if you have the Additional Revenue Fields property enabled. ")

  public String getProductFamily() {
    return productFamily;
  }


  public void setProductFamily(String productFamily) {
    
    
    
    this.productFamily = productFamily;
  }


  public ChargeDefinitions productLine(String productLine) {
    
    
    
    
    this.productLine = productLine;
    return this;
  }

   /**
   * This field is used to maintain the product line for integration with Zuora Revenue.   **Note**: This field is available only if you have the Additional Revenue Fields property enabled. 
   * @return productLine
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "This field is used to maintain the product line for integration with Zuora Revenue.   **Note**: This field is available only if you have the Additional Revenue Fields property enabled. ")

  public String getProductLine() {
    return productLine;
  }


  public void setProductLine(String productLine) {
    
    
    
    this.productLine = productLine;
  }


  public ChargeDefinitions revenueRecognitionTiming(RevenueRecognitionTimingEnum revenueRecognitionTiming) {
    
    
    
    
    this.revenueRecognitionTiming = revenueRecognitionTiming;
    return this;
  }

   /**
   * Specifies the type of revenue recognition timing.  Predefined options are listed as enum values in this API Reference.  Other options might also be avaliable depending on  the &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Enable_Order_to_Revenue/Configure_revenue_settings/Configure_revenue_recognition_policy\&quot; target&#x3D;\&quot;_blank\&quot;&gt;revenue recognition policy configuration&lt;/a&gt; in the Zuora Billing UI.  **Note**: This field is only available if you have the Order to Revenue feature enabled.  
   * @return revenueRecognitionTiming
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Specifies the type of revenue recognition timing.  Predefined options are listed as enum values in this API Reference.  Other options might also be avaliable depending on  the <a href=\"https://knowledgecenter.zuora.com/Zuora_Billing/Enable_Order_to_Revenue/Configure_revenue_settings/Configure_revenue_recognition_policy\" target=\"_blank\">revenue recognition policy configuration</a> in the Zuora Billing UI.  **Note**: This field is only available if you have the Order to Revenue feature enabled.  ")

  public RevenueRecognitionTimingEnum getRevenueRecognitionTiming() {
    return revenueRecognitionTiming;
  }


  public void setRevenueRecognitionTiming(RevenueRecognitionTimingEnum revenueRecognitionTiming) {
    
    
    
    this.revenueRecognitionTiming = revenueRecognitionTiming;
  }


  public ChargeDefinitions revenueAmortizationMethod(RevenueAmortizationMethodEnum revenueAmortizationMethod) {
    
    
    
    
    this.revenueAmortizationMethod = revenueAmortizationMethod;
    return this;
  }

   /**
   * Specifies the type of revenue amortization method.  Predefined options are listed as enum values in this API Reference.  Other options might also be avaliable depending on  the &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Enable_Order_to_Revenue/Configure_revenue_settings/Configure_revenue_recognition_policy\&quot; target&#x3D;\&quot;_blank\&quot;&gt;revenue recognition policy configuration&lt;/a&gt; in the Zuora Billing UI.  **Note**: This field is only available if you have the Order to Revenue feature enabled.  
   * @return revenueAmortizationMethod
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Specifies the type of revenue amortization method.  Predefined options are listed as enum values in this API Reference.  Other options might also be avaliable depending on  the <a href=\"https://knowledgecenter.zuora.com/Zuora_Billing/Enable_Order_to_Revenue/Configure_revenue_settings/Configure_revenue_recognition_policy\" target=\"_blank\">revenue recognition policy configuration</a> in the Zuora Billing UI.  **Note**: This field is only available if you have the Order to Revenue feature enabled.  ")

  public RevenueAmortizationMethodEnum getRevenueAmortizationMethod() {
    return revenueAmortizationMethod;
  }


  public void setRevenueAmortizationMethod(RevenueAmortizationMethodEnum revenueAmortizationMethod) {
    
    
    
    this.revenueAmortizationMethod = revenueAmortizationMethod;
  }


  public ChargeDefinitions numberOfPeriods(Long numberOfPeriods) {
    
    
    
    
    this.numberOfPeriods = numberOfPeriods;
    return this;
  }

   /**
   * Specifies the number of periods to use when calculating charges in an overage smoothing charge model. This field is ued when overage smoothing model is &#x60;RollingWindow&#x60; or &#x60;Rollover&#x60;. 
   * @return numberOfPeriods
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Specifies the number of periods to use when calculating charges in an overage smoothing charge model. This field is ued when overage smoothing model is `RollingWindow` or `Rollover`. ")

  public Long getNumberOfPeriods() {
    return numberOfPeriods;
  }


  public void setNumberOfPeriods(Long numberOfPeriods) {
    
    
    
    this.numberOfPeriods = numberOfPeriods;
  }


  public ChargeDefinitions financeInformation(FinanceInformationProperty1 financeInformation) {
    
    
    
    
    this.financeInformation = financeInformation;
    return this;
  }

   /**
   * Get financeInformation
   * @return financeInformation
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public FinanceInformationProperty1 getFinanceInformation() {
    return financeInformation;
  }


  public void setFinanceInformation(FinanceInformationProperty1 financeInformation) {
    
    
    
    this.financeInformation = financeInformation;
  }


  public ChargeDefinitions isDefault(Boolean isDefault) {
    
    
    
    
    this.isDefault = isDefault;
    return this;
  }

   /**
   * Indicates whether this charge definition is the default one for the charge. 
   * @return isDefault
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Indicates whether this charge definition is the default one for the charge. ")

  public Boolean getIsDefault() {
    return isDefault;
  }


  public void setIsDefault(Boolean isDefault) {
    
    
    
    this.isDefault = isDefault;
  }


  public ChargeDefinitions isStackedDiscount(Boolean isStackedDiscount) {
    
    
    
    
    this.isStackedDiscount = isStackedDiscount;
    return this;
  }

   /**
   * **Note**: This field is only applicable to the Discount - Percentage charge model.  To use this field, you must set the &#x60;X-Zuora-WSDL-Version&#x60; request header to 130 or higher. Otherwise, an error occurs.  This field indicates whether the discount is to be calculated as stacked discount. Possible values are as follows:   - &#x60;True&#x60;: This is a stacked discount, which should be calculated by stacking with other discounts.   - &#x60;False&#x60;: This is not a stacked discount, which should be calculated in sequence with other discounts.  For more information, see [Stacked discounts](https://knowledgecenter.zuora.com/Zuora_Billing/Products/Product_Catalog/B_Charge_Models/B_Discount_Charge_Models). 
   * @return isStackedDiscount
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "**Note**: This field is only applicable to the Discount - Percentage charge model.  To use this field, you must set the `X-Zuora-WSDL-Version` request header to 130 or higher. Otherwise, an error occurs.  This field indicates whether the discount is to be calculated as stacked discount. Possible values are as follows:   - `True`: This is a stacked discount, which should be calculated by stacking with other discounts.   - `False`: This is not a stacked discount, which should be calculated in sequence with other discounts.  For more information, see [Stacked discounts](https://knowledgecenter.zuora.com/Zuora_Billing/Products/Product_Catalog/B_Charge_Models/B_Discount_Charge_Models). ")

  public Boolean getIsStackedDiscount() {
    return isStackedDiscount;
  }


  public void setIsStackedDiscount(Boolean isStackedDiscount) {
    
    
    
    this.isStackedDiscount = isStackedDiscount;
  }


  public ChargeDefinitions listPriceBase(ListPriceBaseEnum listPriceBase) {
    
    
    
    
    this.listPriceBase = listPriceBase;
    return this;
  }

   /**
   * The list price base.   This field is applicable only for recurring charges.  **Note**: The &#x60;Per_Year&#x60; enum value is available only if you have the &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Billing/Subscriptions/Product_Catalog/I_Annual_List_Price\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Annual List Price&lt;/a&gt; feature enabled. 
   * @return listPriceBase
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The list price base.   This field is applicable only for recurring charges.  **Note**: The `Per_Year` enum value is available only if you have the <a href=\"https://knowledgecenter.zuora.com/Billing/Subscriptions/Product_Catalog/I_Annual_List_Price\" target=\"_blank\">Annual List Price</a> feature enabled. ")

  public ListPriceBaseEnum getListPriceBase() {
    return listPriceBase;
  }


  public void setListPriceBase(ListPriceBaseEnum listPriceBase) {
    
    
    
    this.listPriceBase = listPriceBase;
  }


  public ChargeDefinitions numberOfPeriod(Long numberOfPeriod) {
    
    
    
    
    this.numberOfPeriod = numberOfPeriod;
    return this;
  }

   /**
   * Indicates the number of periods to use when calculating charges in an overage smoothing charge model. The valid value is a positive whole number. 
   * @return numberOfPeriod
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Indicates the number of periods to use when calculating charges in an overage smoothing charge model. The valid value is a positive whole number. ")

  public Long getNumberOfPeriod() {
    return numberOfPeriod;
  }


  public void setNumberOfPeriod(Long numberOfPeriod) {
    
    
    
    this.numberOfPeriod = numberOfPeriod;
  }


  public ChargeDefinitions overageCalculationOption(OverageCalculationOptionEnum overageCalculationOption) {
    
    
    
    
    this.overageCalculationOption = overageCalculationOption;
    return this;
  }

   /**
   * Determines when to calculate overage charges. If the value of the &#x60;SmoothingMode&#x60; field is not specified, the value of this field is ignored.  **Values**:    - &#x60;EndOfSmoothingPeriod&#x60;: This option is used by default. The overage is charged at the end of the smoothing period.   - &#x60;PerBillingPeriod&#x60;: The overage is charged on-demand rather than waiting until the end of the smoothing period. 
   * @return overageCalculationOption
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Determines when to calculate overage charges. If the value of the `SmoothingMode` field is not specified, the value of this field is ignored.  **Values**:    - `EndOfSmoothingPeriod`: This option is used by default. The overage is charged at the end of the smoothing period.   - `PerBillingPeriod`: The overage is charged on-demand rather than waiting until the end of the smoothing period. ")

  public OverageCalculationOptionEnum getOverageCalculationOption() {
    return overageCalculationOption;
  }


  public void setOverageCalculationOption(OverageCalculationOptionEnum overageCalculationOption) {
    
    
    
    this.overageCalculationOption = overageCalculationOption;
  }


  public ChargeDefinitions overageUnusedUnitsCreditOption(OverageUnusedUnitsCreditOptionEnum overageUnusedUnitsCreditOption) {
    
    
    
    
    this.overageUnusedUnitsCreditOption = overageUnusedUnitsCreditOption;
    return this;
  }

   /**
   * Determines whether to credit the customer with unused units of usage. 
   * @return overageUnusedUnitsCreditOption
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Determines whether to credit the customer with unused units of usage. ")

  public OverageUnusedUnitsCreditOptionEnum getOverageUnusedUnitsCreditOption() {
    return overageUnusedUnitsCreditOption;
  }


  public void setOverageUnusedUnitsCreditOption(OverageUnusedUnitsCreditOptionEnum overageUnusedUnitsCreditOption) {
    
    
    
    this.overageUnusedUnitsCreditOption = overageUnusedUnitsCreditOption;
  }


  public ChargeDefinitions priceChangeOption(PriceChangeOptionEnum priceChangeOption) {
    
    
    
    
    this.priceChangeOption = priceChangeOption;
    return this;
  }

   /**
   * Applies an automatic price change when a termed subscription is renewed. 
   * @return priceChangeOption
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "NOCHANGE", value = "Applies an automatic price change when a termed subscription is renewed. ")

  public PriceChangeOptionEnum getPriceChangeOption() {
    return priceChangeOption;
  }


  public void setPriceChangeOption(PriceChangeOptionEnum priceChangeOption) {
    
    
    
    this.priceChangeOption = priceChangeOption;
  }


  public ChargeDefinitions priceIncreaseOption(PriceIncreaseOptionEnum priceIncreaseOption) {
    
    
    
    
    this.priceIncreaseOption = priceIncreaseOption;
    return this;
  }

   /**
   * Applies an automatic price change when a termed subscription is renewed. 
   * @return priceIncreaseOption
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Applies an automatic price change when a termed subscription is renewed. ")

  public PriceIncreaseOptionEnum getPriceIncreaseOption() {
    return priceIncreaseOption;
  }


  public void setPriceIncreaseOption(PriceIncreaseOptionEnum priceIncreaseOption) {
    
    
    
    this.priceIncreaseOption = priceIncreaseOption;
  }


  public ChargeDefinitions priceIncreasePercentage(Double priceIncreasePercentage) {
    
    
    
    
    this.priceIncreasePercentage = priceIncreasePercentage;
    return this;
  }

   /**
   * Specifies the percentage to increase or decrease the price of a termed subscription&#39;s renewal. Use this field if you set the &#x60;priceIncreaseOption&#x60; value to &#x60;SpecificPercentageValue&#x60;.  **Character limit**: 16  **Values**: a decimal value between -100 and 100 
   * @return priceIncreasePercentage
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Specifies the percentage to increase or decrease the price of a termed subscription's renewal. Use this field if you set the `priceIncreaseOption` value to `SpecificPercentageValue`.  **Character limit**: 16  **Values**: a decimal value between -100 and 100 ")

  public Double getPriceIncreasePercentage() {
    return priceIncreasePercentage;
  }


  public void setPriceIncreasePercentage(Double priceIncreasePercentage) {
    
    
    
    this.priceIncreasePercentage = priceIncreasePercentage;
  }


  public ChargeDefinitions prices(List<GETProductChargeDefinitionPricing> prices) {
    
    
    
    
    this.prices = prices;
    return this;
  }

  public ChargeDefinitions addPricesItem(GETProductChargeDefinitionPricing pricesItem) {
    if (this.prices == null) {
      this.prices = new ArrayList<>();
    }
    this.prices.add(pricesItem);
    return this;
  }

   /**
   * Container for the prices of the product charge definition. 
   * @return prices
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Container for the prices of the product charge definition. ")

  public List<GETProductChargeDefinitionPricing> getPrices() {
    return prices;
  }


  public void setPrices(List<GETProductChargeDefinitionPricing> prices) {
    
    
    
    this.prices = prices;
  }


  public ChargeDefinitions productChargeDefinitionId(String productChargeDefinitionId) {
    
    
    
    
    this.productChargeDefinitionId = productChargeDefinitionId;
    return this;
  }

   /**
   * The unique ID of the product charge definition. 
   * @return productChargeDefinitionId
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The unique ID of the product charge definition. ")

  public String getProductChargeDefinitionId() {
    return productChargeDefinitionId;
  }


  public void setProductChargeDefinitionId(String productChargeDefinitionId) {
    
    
    
    this.productChargeDefinitionId = productChargeDefinitionId;
  }


  public ChargeDefinitions productChargeDefinitionNumber(String productChargeDefinitionNumber) {
    
    
    
    
    this.productChargeDefinitionNumber = productChargeDefinitionNumber;
    return this;
  }

   /**
   * The unique number (natural key) of the product charge definition. 
   * @return productChargeDefinitionNumber
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The unique number (natural key) of the product charge definition. ")

  public String getProductChargeDefinitionNumber() {
    return productChargeDefinitionNumber;
  }


  public void setProductChargeDefinitionNumber(String productChargeDefinitionNumber) {
    
    
    
    this.productChargeDefinitionNumber = productChargeDefinitionNumber;
  }


  public ChargeDefinitions productDiscountApplyDetails(List<GETProductDiscountApplyDetailsType> productDiscountApplyDetails) {
    
    
    
    
    this.productDiscountApplyDetails = productDiscountApplyDetails;
    return this;
  }

  public ChargeDefinitions addProductDiscountApplyDetailsItem(GETProductDiscountApplyDetailsType productDiscountApplyDetailsItem) {
    if (this.productDiscountApplyDetails == null) {
      this.productDiscountApplyDetails = new ArrayList<>();
    }
    this.productDiscountApplyDetails.add(productDiscountApplyDetailsItem);
    return this;
  }

   /**
   * Container for the application details about a discount product rate plan charge.   Only discount product rate plan charges have values for this field. 
   * @return productDiscountApplyDetails
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Container for the application details about a discount product rate plan charge.   Only discount product rate plan charges have values for this field. ")

  public List<GETProductDiscountApplyDetailsType> getProductDiscountApplyDetails() {
    return productDiscountApplyDetails;
  }


  public void setProductDiscountApplyDetails(List<GETProductDiscountApplyDetailsType> productDiscountApplyDetails) {
    
    
    
    this.productDiscountApplyDetails = productDiscountApplyDetails;
  }


  public ChargeDefinitions productRatePlanChargeId(String productRatePlanChargeId) {
    
    
    
    
    this.productRatePlanChargeId = productRatePlanChargeId;
    return this;
  }

   /**
   * The unique ID of the product charge of the charge definition. 
   * @return productRatePlanChargeId
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The unique ID of the product charge of the charge definition. ")

  public String getProductRatePlanChargeId() {
    return productRatePlanChargeId;
  }


  public void setProductRatePlanChargeId(String productRatePlanChargeId) {
    
    
    
    this.productRatePlanChargeId = productRatePlanChargeId;
  }


  public ChargeDefinitions productRatePlanChargeNumber(String productRatePlanChargeNumber) {
    
    
    
    
    this.productRatePlanChargeNumber = productRatePlanChargeNumber;
    return this;
  }

   /**
   * The unique number (natural key) of the product charge of the charge definition. 
   * @return productRatePlanChargeNumber
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The unique number (natural key) of the product charge of the charge definition. ")

  public String getProductRatePlanChargeNumber() {
    return productRatePlanChargeNumber;
  }


  public void setProductRatePlanChargeNumber(String productRatePlanChargeNumber) {
    
    
    
    this.productRatePlanChargeNumber = productRatePlanChargeNumber;
  }


  public ChargeDefinitions productRatePlanId(String productRatePlanId) {
    
    
    
    
    this.productRatePlanId = productRatePlanId;
    return this;
  }

   /**
   * The unique ID of the product rate plan that uses this charge definition. 
   * @return productRatePlanId
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The unique ID of the product rate plan that uses this charge definition. ")

  public String getProductRatePlanId() {
    return productRatePlanId;
  }


  public void setProductRatePlanId(String productRatePlanId) {
    
    
    
    this.productRatePlanId = productRatePlanId;
  }


  public ChargeDefinitions productRatePlanName(String productRatePlanName) {
    
    
    
    
    this.productRatePlanName = productRatePlanName;
    return this;
  }

   /**
   * Th name of the product rate plan that uses this charge definition. 
   * @return productRatePlanName
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Th name of the product rate plan that uses this charge definition. ")

  public String getProductRatePlanName() {
    return productRatePlanName;
  }


  public void setProductRatePlanName(String productRatePlanName) {
    
    
    
    this.productRatePlanName = productRatePlanName;
  }


  public ChargeDefinitions productRatePlanNumber(String productRatePlanNumber) {
    
    
    
    
    this.productRatePlanNumber = productRatePlanNumber;
    return this;
  }

   /**
   * The unique number (natural key) of the product rate plan that uses this charge definition. 
   * @return productRatePlanNumber
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The unique number (natural key) of the product rate plan that uses this charge definition. ")

  public String getProductRatePlanNumber() {
    return productRatePlanNumber;
  }


  public void setProductRatePlanNumber(String productRatePlanNumber) {
    
    
    
    this.productRatePlanNumber = productRatePlanNumber;
  }


  public ChargeDefinitions ratingGroup(RatingGroupEnum ratingGroup) {
    
    
    
    
    this.ratingGroup = ratingGroup;
    return this;
  }

   /**
   * The rating group based on which usage records are rated.  Possible values:                   - &#x60;ByBillingPeriod&#x60;: The rating is based on all the usages in a billing period.    - &#x60;ByUsageStartDate&#x60;: The rating is based on all the usages on the same usage start date.    - &#x60;ByUsageRecord&#x60;: The rating is based on each usage record.   - &#x60;ByUsageUpload&#x60;: The rating is based on all the  usages in a uploaded usage file (&#x60;.xls&#x60; or &#x60;.csv&#x60;).   - &#x60;ByGroupId&#x60;: The rating is based on all the usages in a custom group.  **Notes:**    - The &#x60;ByBillingPeriod&#x60; value can be applied for all charge models.    - The &#x60;ByUsageStartDate&#x60;, &#x60;ByUsageRecord&#x60;, and &#x60;ByUsageUpload&#x60; values can only be applied for Per Unit, Volume Pricing, and Tiered Pricing charge models.    - The &#x60;ByGroupId&#x60; value is only available if you have the Active Rating feature enabled.   - Use this field only for Usage charges. One-time charges and recurring charges return &#x60;NULL&#x60;. 
   * @return ratingGroup
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "BYBILLINGPERIOD", value = "The rating group based on which usage records are rated.  Possible values:                   - `ByBillingPeriod`: The rating is based on all the usages in a billing period.    - `ByUsageStartDate`: The rating is based on all the usages on the same usage start date.    - `ByUsageRecord`: The rating is based on each usage record.   - `ByUsageUpload`: The rating is based on all the  usages in a uploaded usage file (`.xls` or `.csv`).   - `ByGroupId`: The rating is based on all the usages in a custom group.  **Notes:**    - The `ByBillingPeriod` value can be applied for all charge models.    - The `ByUsageStartDate`, `ByUsageRecord`, and `ByUsageUpload` values can only be applied for Per Unit, Volume Pricing, and Tiered Pricing charge models.    - The `ByGroupId` value is only available if you have the Active Rating feature enabled.   - Use this field only for Usage charges. One-time charges and recurring charges return `NULL`. ")

  public RatingGroupEnum getRatingGroup() {
    return ratingGroup;
  }


  public void setRatingGroup(RatingGroupEnum ratingGroup) {
    
    
    
    this.ratingGroup = ratingGroup;
  }


  public ChargeDefinitions recognizedRevenueAccount(String recognizedRevenueAccount) {
    
    
    
    
    this.recognizedRevenueAccount = recognizedRevenueAccount;
    return this;
  }

   /**
   * The name of the recognized revenue account for this charge.   - Required when the Allow Blank Accounting Code setting is No.   - Optional when the Allow Blank Accounting Code setting is Yes.    This feature is in **Limited Availability**. If you wish to have access to the feature, submit a request at [Zuora Global Support](http://support.zuora.com/). 
   * @return recognizedRevenueAccount
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The name of the recognized revenue account for this charge.   - Required when the Allow Blank Accounting Code setting is No.   - Optional when the Allow Blank Accounting Code setting is Yes.    This feature is in **Limited Availability**. If you wish to have access to the feature, submit a request at [Zuora Global Support](http://support.zuora.com/). ")

  public String getRecognizedRevenueAccount() {
    return recognizedRevenueAccount;
  }


  public void setRecognizedRevenueAccount(String recognizedRevenueAccount) {
    
    
    
    this.recognizedRevenueAccount = recognizedRevenueAccount;
  }


  public ChargeDefinitions revRecCode(String revRecCode) {
    
    
    
    
    this.revRecCode = revRecCode;
    return this;
  }

   /**
   * Associates this product rate plan charge with a specific revenue recognition code. 
   * @return revRecCode
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Associates this product rate plan charge with a specific revenue recognition code. ")

  public String getRevRecCode() {
    return revRecCode;
  }


  public void setRevRecCode(String revRecCode) {
    
    
    
    this.revRecCode = revRecCode;
  }


  public ChargeDefinitions revRecTriggerCondition(RevRecTriggerConditionEnum revRecTriggerCondition) {
    
    
    
    
    this.revRecTriggerCondition = revRecTriggerCondition;
    return this;
  }

   /**
   * Indicates when revenue recognition begins. 
   * @return revRecTriggerCondition
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Indicates when revenue recognition begins. ")

  public RevRecTriggerConditionEnum getRevRecTriggerCondition() {
    return revRecTriggerCondition;
  }


  public void setRevRecTriggerCondition(RevRecTriggerConditionEnum revRecTriggerCondition) {
    
    
    
    this.revRecTriggerCondition = revRecTriggerCondition;
  }


  public ChargeDefinitions revenueRecognitionRuleName(RevenueRecognitionRuleNameEnum revenueRecognitionRuleName) {
    
    
    
    
    this.revenueRecognitionRuleName = revenueRecognitionRuleName;
    return this;
  }

   /**
   * Determines when to recognize the revenue for this charge. 
   * @return revenueRecognitionRuleName
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Determines when to recognize the revenue for this charge. ")

  public RevenueRecognitionRuleNameEnum getRevenueRecognitionRuleName() {
    return revenueRecognitionRuleName;
  }


  public void setRevenueRecognitionRuleName(RevenueRecognitionRuleNameEnum revenueRecognitionRuleName) {
    
    
    
    this.revenueRecognitionRuleName = revenueRecognitionRuleName;
  }


  public ChargeDefinitions smoothingModel(SmoothingModelEnum smoothingModel) {
    
    
    
    
    this.smoothingModel = smoothingModel;
    return this;
  }

   /**
   * Indicates the smoothing model for an overage smoothing charge model. 
   * @return smoothingModel
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Indicates the smoothing model for an overage smoothing charge model. ")

  public SmoothingModelEnum getSmoothingModel() {
    return smoothingModel;
  }


  public void setSmoothingModel(SmoothingModelEnum smoothingModel) {
    
    
    
    this.smoothingModel = smoothingModel;
  }


  public ChargeDefinitions specificBillingPeriod(Double specificBillingPeriod) {
    
    
    
    
    this.specificBillingPeriod = specificBillingPeriod;
    return this;
  }

  public ChargeDefinitions specificBillingPeriod(Integer specificBillingPeriod) {
    
    
    
    
    this.specificBillingPeriod = specificBillingPeriod.doubleValue();
    return this;
  }

   /**
   * The specific number of billing period for the product charge definition. 
   * @return specificBillingPeriod
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The specific number of billing period for the product charge definition. ")

  public Double getSpecificBillingPeriod() {
    return specificBillingPeriod;
  }


  public void setSpecificBillingPeriod(Double specificBillingPeriod) {
    
    
    
    this.specificBillingPeriod = specificBillingPeriod;
  }


  public ChargeDefinitions specificListPriceBase(Integer specificListPriceBase) {
    if (specificListPriceBase != null && specificListPriceBase < 1) {
      throw new IllegalArgumentException("Invalid value for specificListPriceBase. Must be greater than or equal to 1.");
    }
    if (specificListPriceBase != null && specificListPriceBase > 200) {
      throw new IllegalArgumentException("Invalid value for specificListPriceBase. Must be less than or equal to 200.");
    }
    
    
    this.specificListPriceBase = specificListPriceBase;
    return this;
  }

   /**
   * The number of months for the list price base of the charge definition.   This field is &#x60;null&#x60; if the &#x60;listPriceBase&#x60; field is not set to &#x60;Per_Specific_Months&#x60;. 
   * minimum: 1
   * maximum: 200
   * @return specificListPriceBase
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The number of months for the list price base of the charge definition.   This field is `null` if the `listPriceBase` field is not set to `Per_Specific_Months`. ")

  public Integer getSpecificListPriceBase() {
    return specificListPriceBase;
  }


  public void setSpecificListPriceBase(Integer specificListPriceBase) {
    if (specificListPriceBase != null && specificListPriceBase < 1) {
      throw new IllegalArgumentException("Invalid value for specificListPriceBase. Must be greater than or equal to 1.");
    }
    if (specificListPriceBase != null && specificListPriceBase > 200) {
      throw new IllegalArgumentException("Invalid value for specificListPriceBase. Must be less than or equal to 200.");
    }
    
    this.specificListPriceBase = specificListPriceBase;
  }


  public ChargeDefinitions taxCode(String taxCode) {
    
    
    
    
    this.taxCode = taxCode;
    return this;
  }

   /**
   * Specifies the tax code for taxation rules.  **Note**: This value affects the tax calculation of the rate plan charge. 
   * @return taxCode
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Specifies the tax code for taxation rules.  **Note**: This value affects the tax calculation of the rate plan charge. ")

  public String getTaxCode() {
    return taxCode;
  }


  public void setTaxCode(String taxCode) {
    
    
    
    this.taxCode = taxCode;
  }


  public ChargeDefinitions taxMode(TaxModeEnum taxMode) {
    
    
    
    
    this.taxMode = taxMode;
    return this;
  }

   /**
   * Determines how to define taxation for the charge.  **Note**: This value affects the tax calculation of the rate plan charge. 
   * @return taxMode
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Determines how to define taxation for the charge.  **Note**: This value affects the tax calculation of the rate plan charge. ")

  public TaxModeEnum getTaxMode() {
    return taxMode;
  }


  public void setTaxMode(TaxModeEnum taxMode) {
    
    
    
    this.taxMode = taxMode;
  }


  public ChargeDefinitions taxable(Boolean taxable) {
    
    
    
    
    this.taxable = taxable;
    return this;
  }

   /**
   * Determines whether the charge definition is taxable.  **Character limit**: 5  **Values**: &#x60;true&#x60;, &#x60;false&#x60;  **Note**: This value affects the tax calculation of the rate plan charge. 
   * @return taxable
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Determines whether the charge definition is taxable.  **Character limit**: 5  **Values**: `true`, `false`  **Note**: This value affects the tax calculation of the rate plan charge. ")

  public Boolean getTaxable() {
    return taxable;
  }


  public void setTaxable(Boolean taxable) {
    
    
    
    this.taxable = taxable;
  }


  public ChargeDefinitions term(Double term) {
    
    
    
    
    this.term = term;
    return this;
  }

  public ChargeDefinitions term(Integer term) {
    
    
    
    
    this.term = term.doubleValue();
    return this;
  }

   /**
   * The number of periods of a termed subscription that is eligible for this charge definition. This field is applicable when the &#x60;termType&#x60; field is set to &#x60;TERMED&#x60;,  and is to be used together with the &#x60;termPeriodType&#x60; field. 
   * @return term
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The number of periods of a termed subscription that is eligible for this charge definition. This field is applicable when the `termType` field is set to `TERMED`,  and is to be used together with the `termPeriodType` field. ")

  public Double getTerm() {
    return term;
  }


  public void setTerm(Double term) {
    
    
    
    this.term = term;
  }


  public ChargeDefinitions termPeriodType(TermPeriodTypeEnum termPeriodType) {
    
    
    
    
    this.termPeriodType = termPeriodType;
    return this;
  }

   /**
   * The period type for the subscription term that is eligible for this charge definition. 
   * @return termPeriodType
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The period type for the subscription term that is eligible for this charge definition. ")

  public TermPeriodTypeEnum getTermPeriodType() {
    return termPeriodType;
  }


  public void setTermPeriodType(TermPeriodTypeEnum termPeriodType) {
    
    
    
    this.termPeriodType = termPeriodType;
  }


  public ChargeDefinitions termType(TermTypeEnum termType) {
    
    
    
    
    this.termType = termType;
    return this;
  }

   /**
   * The type of the subscription that is eligible for this charge definition. 
   * @return termType
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The type of the subscription that is eligible for this charge definition. ")

  public TermTypeEnum getTermType() {
    return termType;
  }


  public void setTermType(TermTypeEnum termType) {
    
    
    
    this.termType = termType;
  }


  public ChargeDefinitions triggerEvent(TriggerEventEnum triggerEvent) {
    
    
    
    
    this.triggerEvent = triggerEvent;
    return this;
  }

   /**
   * Specifies when to start billing the customer for the charge definition.  **Values**:   - &#x60;ContractEffective&#x60; is the date when the subscription&#39;s contract goes into effect and the charge is ready to be billed.   - &#x60;ServiceActivation&#x60; is the date when the services or products for a subscription have been activated and the customers have access.   - &#x60;CustomerAcceptance&#x60; is when the customer accepts the services or products for a subscription. 
   * @return triggerEvent
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Specifies when to start billing the customer for the charge definition.  **Values**:   - `ContractEffective` is the date when the subscription's contract goes into effect and the charge is ready to be billed.   - `ServiceActivation` is the date when the services or products for a subscription have been activated and the customers have access.   - `CustomerAcceptance` is when the customer accepts the services or products for a subscription. ")

  public TriggerEventEnum getTriggerEvent() {
    return triggerEvent;
  }


  public void setTriggerEvent(TriggerEventEnum triggerEvent) {
    
    
    
    this.triggerEvent = triggerEvent;
  }


  public ChargeDefinitions uom(String uom) {
    
    
    
    
    this.uom = uom;
    return this;
  }

   /**
   * Indicates the unit of measure (UOM) that is configured in **Settings &gt; Billing** for the product rate plan charge. 
   * @return uom
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Indicates the unit of measure (UOM) that is configured in **Settings > Billing** for the product rate plan charge. ")

  public String getUom() {
    return uom;
  }


  public void setUom(String uom) {
    
    
    
    this.uom = uom;
  }


  public ChargeDefinitions upToPeriods(Double upToPeriods) {
    
    
    
    
    this.upToPeriods = upToPeriods;
    return this;
  }

  public ChargeDefinitions upToPeriods(Integer upToPeriods) {
    
    
    
    
    this.upToPeriods = upToPeriods.doubleValue();
    return this;
  }

   /**
   * The number of up-to periods for this charge. 
   * @return upToPeriods
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The number of up-to periods for this charge. ")

  public Double getUpToPeriods() {
    return upToPeriods;
  }


  public void setUpToPeriods(Double upToPeriods) {
    
    
    
    this.upToPeriods = upToPeriods;
  }


  public ChargeDefinitions upToPeriodsType(UpToPeriodsTypeEnum upToPeriodsType) {
    
    
    
    
    this.upToPeriodsType = upToPeriodsType;
    return this;
  }

   /**
   * The up-to-periods type for this charge. 
   * @return upToPeriodsType
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The up-to-periods type for this charge. ")

  public UpToPeriodsTypeEnum getUpToPeriodsType() {
    return upToPeriodsType;
  }


  public void setUpToPeriodsType(UpToPeriodsTypeEnum upToPeriodsType) {
    
    
    
    this.upToPeriodsType = upToPeriodsType;
  }


  public ChargeDefinitions usageRecordRatingOption(UsageRecordRatingOptionEnum usageRecordRatingOption) {
    
    
    
    
    this.usageRecordRatingOption = usageRecordRatingOption;
    return this;
  }

   /**
   * Determines how Zuora processes usage records for per-unit usage charges. 
   * @return usageRecordRatingOption
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "ENDOFBILLINGPERIOD", value = "Determines how Zuora processes usage records for per-unit usage charges. ")

  public UsageRecordRatingOptionEnum getUsageRecordRatingOption() {
    return usageRecordRatingOption;
  }


  public void setUsageRecordRatingOption(UsageRecordRatingOptionEnum usageRecordRatingOption) {
    
    
    
    this.usageRecordRatingOption = usageRecordRatingOption;
  }


  public ChargeDefinitions useDiscountSpecificAccountingCode(Boolean useDiscountSpecificAccountingCode) {
    
    
    
    
    this.useDiscountSpecificAccountingCode = useDiscountSpecificAccountingCode;
    return this;
  }

   /**
   * Determines whether to define a new accounting code for the new discount charge.  **Character limit**: 5  **Values**: &#x60;true&#x60;, &#x60;false&#x60; 
   * @return useDiscountSpecificAccountingCode
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Determines whether to define a new accounting code for the new discount charge.  **Character limit**: 5  **Values**: `true`, `false` ")

  public Boolean getUseDiscountSpecificAccountingCode() {
    return useDiscountSpecificAccountingCode;
  }


  public void setUseDiscountSpecificAccountingCode(Boolean useDiscountSpecificAccountingCode) {
    
    
    
    this.useDiscountSpecificAccountingCode = useDiscountSpecificAccountingCode;
  }


  public ChargeDefinitions useTenantDefaultForPriceChange(Boolean useTenantDefaultForPriceChange) {
    
    
    
    
    this.useTenantDefaultForPriceChange = useTenantDefaultForPriceChange;
    return this;
  }

   /**
   * Applies the tenant-level percentage uplift value for an automatic price change to a termed subscription&#39;s renewal.   **Character limit**: 5  **Values**: &#x60;true&#x60;, &#x60;false&#x60; 
   * @return useTenantDefaultForPriceChange
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Applies the tenant-level percentage uplift value for an automatic price change to a termed subscription's renewal.   **Character limit**: 5  **Values**: `true`, `false` ")

  public Boolean getUseTenantDefaultForPriceChange() {
    return useTenantDefaultForPriceChange;
  }


  public void setUseTenantDefaultForPriceChange(Boolean useTenantDefaultForPriceChange) {
    
    
    
    this.useTenantDefaultForPriceChange = useTenantDefaultForPriceChange;
  }

  /**
   * A container for additional, undeclared properties.
   * This is a holder for any undeclared properties as specified with
   * the 'additionalProperties' keyword in the OAS document.
   */
  private Map<String, Object> additionalProperties;

  /**
   * Set the additional (undeclared) property with the specified name and value.
   * If the property does not already exist, create it otherwise replace it.
   *
   * @param key name of the property
   * @param value value of the property
   * @return the ChargeDefinitions instance itself
   */
  public ChargeDefinitions putAdditionalProperty(String key, Object value) {
    if (this.additionalProperties == null) {
        this.additionalProperties = new HashMap<String, Object>();
    }
    this.additionalProperties.put(key, value);
    return this;
  }

  /**
   * Return the additional (undeclared) property.
   *
   * @return a map of objects
   */
  public Map<String, Object> getAdditionalProperties() {
    return additionalProperties;
  }

  /**
   * Return the additional (undeclared) property with the specified name.
   *
   * @param key name of the property
   * @return an object
   */
  public Object getAdditionalProperty(String key) {
    if (this.additionalProperties == null) {
        return null;
    }
    return this.additionalProperties.get(key);
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ChargeDefinitions chargeDefinitions = (ChargeDefinitions) o;
    return Objects.equals(this.description, chargeDefinitions.description) &&
        Objects.equals(this.applyDiscountTo, chargeDefinitions.applyDiscountTo) &&
        Objects.equals(this.billingDay, chargeDefinitions.billingDay) &&
        Objects.equals(this.billingPeriod, chargeDefinitions.billingPeriod) &&
        Objects.equals(this.billingPeriodAlignment, chargeDefinitions.billingPeriodAlignment) &&
        Objects.equals(this.billingTiming, chargeDefinitions.billingTiming) &&
        Objects.equals(this.chargeModel, chargeDefinitions.chargeModel) &&
        Objects.equals(this.chargeType, chargeDefinitions.chargeType) &&
        Objects.equals(this.customFields, chargeDefinitions.customFields) &&
        Objects.equals(this.defaultQuantity, chargeDefinitions.defaultQuantity) &&
        Objects.equals(this.deliverySchedule, chargeDefinitions.deliverySchedule) &&
        Objects.equals(this.discountClass, chargeDefinitions.discountClass) &&
        Objects.equals(this.discountLevel, chargeDefinitions.discountLevel) &&
        Objects.equals(this.effectiveEndDate, chargeDefinitions.effectiveEndDate) &&
        Objects.equals(this.effectiveStartDate, chargeDefinitions.effectiveStartDate) &&
        Objects.equals(this.endDateCondition, chargeDefinitions.endDateCondition) &&
        Objects.equals(this.excludeItemBillingFromRevenueAccounting, chargeDefinitions.excludeItemBillingFromRevenueAccounting) &&
        Objects.equals(this.excludeItemBookingFromRevenueAccounting, chargeDefinitions.excludeItemBookingFromRevenueAccounting) &&
        Objects.equals(this.isAllocationEligible, chargeDefinitions.isAllocationEligible) &&
        Objects.equals(this.isUnbilled, chargeDefinitions.isUnbilled) &&
        Objects.equals(this.productCategory, chargeDefinitions.productCategory) &&
        Objects.equals(this.productClass, chargeDefinitions.productClass) &&
        Objects.equals(this.productFamily, chargeDefinitions.productFamily) &&
        Objects.equals(this.productLine, chargeDefinitions.productLine) &&
        Objects.equals(this.revenueRecognitionTiming, chargeDefinitions.revenueRecognitionTiming) &&
        Objects.equals(this.revenueAmortizationMethod, chargeDefinitions.revenueAmortizationMethod) &&
        Objects.equals(this.numberOfPeriods, chargeDefinitions.numberOfPeriods) &&
        Objects.equals(this.financeInformation, chargeDefinitions.financeInformation) &&
        Objects.equals(this.isDefault, chargeDefinitions.isDefault) &&
        Objects.equals(this.isStackedDiscount, chargeDefinitions.isStackedDiscount) &&
        Objects.equals(this.listPriceBase, chargeDefinitions.listPriceBase) &&
        Objects.equals(this.numberOfPeriod, chargeDefinitions.numberOfPeriod) &&
        Objects.equals(this.overageCalculationOption, chargeDefinitions.overageCalculationOption) &&
        Objects.equals(this.overageUnusedUnitsCreditOption, chargeDefinitions.overageUnusedUnitsCreditOption) &&
        Objects.equals(this.priceChangeOption, chargeDefinitions.priceChangeOption) &&
        Objects.equals(this.priceIncreaseOption, chargeDefinitions.priceIncreaseOption) &&
        Objects.equals(this.priceIncreasePercentage, chargeDefinitions.priceIncreasePercentage) &&
        Objects.equals(this.prices, chargeDefinitions.prices) &&
        Objects.equals(this.productChargeDefinitionId, chargeDefinitions.productChargeDefinitionId) &&
        Objects.equals(this.productChargeDefinitionNumber, chargeDefinitions.productChargeDefinitionNumber) &&
        Objects.equals(this.productDiscountApplyDetails, chargeDefinitions.productDiscountApplyDetails) &&
        Objects.equals(this.productRatePlanChargeId, chargeDefinitions.productRatePlanChargeId) &&
        Objects.equals(this.productRatePlanChargeNumber, chargeDefinitions.productRatePlanChargeNumber) &&
        Objects.equals(this.productRatePlanId, chargeDefinitions.productRatePlanId) &&
        Objects.equals(this.productRatePlanName, chargeDefinitions.productRatePlanName) &&
        Objects.equals(this.productRatePlanNumber, chargeDefinitions.productRatePlanNumber) &&
        Objects.equals(this.ratingGroup, chargeDefinitions.ratingGroup) &&
        Objects.equals(this.recognizedRevenueAccount, chargeDefinitions.recognizedRevenueAccount) &&
        Objects.equals(this.revRecCode, chargeDefinitions.revRecCode) &&
        Objects.equals(this.revRecTriggerCondition, chargeDefinitions.revRecTriggerCondition) &&
        Objects.equals(this.revenueRecognitionRuleName, chargeDefinitions.revenueRecognitionRuleName) &&
        Objects.equals(this.smoothingModel, chargeDefinitions.smoothingModel) &&
        Objects.equals(this.specificBillingPeriod, chargeDefinitions.specificBillingPeriod) &&
        Objects.equals(this.specificListPriceBase, chargeDefinitions.specificListPriceBase) &&
        Objects.equals(this.taxCode, chargeDefinitions.taxCode) &&
        Objects.equals(this.taxMode, chargeDefinitions.taxMode) &&
        Objects.equals(this.taxable, chargeDefinitions.taxable) &&
        Objects.equals(this.term, chargeDefinitions.term) &&
        Objects.equals(this.termPeriodType, chargeDefinitions.termPeriodType) &&
        Objects.equals(this.termType, chargeDefinitions.termType) &&
        Objects.equals(this.triggerEvent, chargeDefinitions.triggerEvent) &&
        Objects.equals(this.uom, chargeDefinitions.uom) &&
        Objects.equals(this.upToPeriods, chargeDefinitions.upToPeriods) &&
        Objects.equals(this.upToPeriodsType, chargeDefinitions.upToPeriodsType) &&
        Objects.equals(this.usageRecordRatingOption, chargeDefinitions.usageRecordRatingOption) &&
        Objects.equals(this.useDiscountSpecificAccountingCode, chargeDefinitions.useDiscountSpecificAccountingCode) &&
        Objects.equals(this.useTenantDefaultForPriceChange, chargeDefinitions.useTenantDefaultForPriceChange)&&
        Objects.equals(this.additionalProperties, chargeDefinitions.additionalProperties);
  }

  private static <T> boolean equalsNullable(JsonNullable<T> a, JsonNullable<T> b) {
    return a == b || (a != null && b != null && a.isPresent() && b.isPresent() && Objects.deepEquals(a.get(), b.get()));
  }

  @Override
  public int hashCode() {
    return Objects.hash(description, applyDiscountTo, billingDay, billingPeriod, billingPeriodAlignment, billingTiming, chargeModel, chargeType, customFields, defaultQuantity, deliverySchedule, discountClass, discountLevel, effectiveEndDate, effectiveStartDate, endDateCondition, excludeItemBillingFromRevenueAccounting, excludeItemBookingFromRevenueAccounting, isAllocationEligible, isUnbilled, productCategory, productClass, productFamily, productLine, revenueRecognitionTiming, revenueAmortizationMethod, numberOfPeriods, financeInformation, isDefault, isStackedDiscount, listPriceBase, numberOfPeriod, overageCalculationOption, overageUnusedUnitsCreditOption, priceChangeOption, priceIncreaseOption, priceIncreasePercentage, prices, productChargeDefinitionId, productChargeDefinitionNumber, productDiscountApplyDetails, productRatePlanChargeId, productRatePlanChargeNumber, productRatePlanId, productRatePlanName, productRatePlanNumber, ratingGroup, recognizedRevenueAccount, revRecCode, revRecTriggerCondition, revenueRecognitionRuleName, smoothingModel, specificBillingPeriod, specificListPriceBase, taxCode, taxMode, taxable, term, termPeriodType, termType, triggerEvent, uom, upToPeriods, upToPeriodsType, usageRecordRatingOption, useDiscountSpecificAccountingCode, useTenantDefaultForPriceChange, additionalProperties);
  }

  private static <T> int hashCodeNullable(JsonNullable<T> a) {
    if (a == null) {
      return 1;
    }
    return a.isPresent() ? Arrays.deepHashCode(new Object[]{a.get()}) : 31;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ChargeDefinitions {\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    applyDiscountTo: ").append(toIndentedString(applyDiscountTo)).append("\n");
    sb.append("    billingDay: ").append(toIndentedString(billingDay)).append("\n");
    sb.append("    billingPeriod: ").append(toIndentedString(billingPeriod)).append("\n");
    sb.append("    billingPeriodAlignment: ").append(toIndentedString(billingPeriodAlignment)).append("\n");
    sb.append("    billingTiming: ").append(toIndentedString(billingTiming)).append("\n");
    sb.append("    chargeModel: ").append(toIndentedString(chargeModel)).append("\n");
    sb.append("    chargeType: ").append(toIndentedString(chargeType)).append("\n");
    sb.append("    customFields: ").append(toIndentedString(customFields)).append("\n");
    sb.append("    defaultQuantity: ").append(toIndentedString(defaultQuantity)).append("\n");
    sb.append("    deliverySchedule: ").append(toIndentedString(deliverySchedule)).append("\n");
    sb.append("    discountClass: ").append(toIndentedString(discountClass)).append("\n");
    sb.append("    discountLevel: ").append(toIndentedString(discountLevel)).append("\n");
    sb.append("    effectiveEndDate: ").append(toIndentedString(effectiveEndDate)).append("\n");
    sb.append("    effectiveStartDate: ").append(toIndentedString(effectiveStartDate)).append("\n");
    sb.append("    endDateCondition: ").append(toIndentedString(endDateCondition)).append("\n");
    sb.append("    excludeItemBillingFromRevenueAccounting: ").append(toIndentedString(excludeItemBillingFromRevenueAccounting)).append("\n");
    sb.append("    excludeItemBookingFromRevenueAccounting: ").append(toIndentedString(excludeItemBookingFromRevenueAccounting)).append("\n");
    sb.append("    isAllocationEligible: ").append(toIndentedString(isAllocationEligible)).append("\n");
    sb.append("    isUnbilled: ").append(toIndentedString(isUnbilled)).append("\n");
    sb.append("    productCategory: ").append(toIndentedString(productCategory)).append("\n");
    sb.append("    productClass: ").append(toIndentedString(productClass)).append("\n");
    sb.append("    productFamily: ").append(toIndentedString(productFamily)).append("\n");
    sb.append("    productLine: ").append(toIndentedString(productLine)).append("\n");
    sb.append("    revenueRecognitionTiming: ").append(toIndentedString(revenueRecognitionTiming)).append("\n");
    sb.append("    revenueAmortizationMethod: ").append(toIndentedString(revenueAmortizationMethod)).append("\n");
    sb.append("    numberOfPeriods: ").append(toIndentedString(numberOfPeriods)).append("\n");
    sb.append("    financeInformation: ").append(toIndentedString(financeInformation)).append("\n");
    sb.append("    isDefault: ").append(toIndentedString(isDefault)).append("\n");
    sb.append("    isStackedDiscount: ").append(toIndentedString(isStackedDiscount)).append("\n");
    sb.append("    listPriceBase: ").append(toIndentedString(listPriceBase)).append("\n");
    sb.append("    numberOfPeriod: ").append(toIndentedString(numberOfPeriod)).append("\n");
    sb.append("    overageCalculationOption: ").append(toIndentedString(overageCalculationOption)).append("\n");
    sb.append("    overageUnusedUnitsCreditOption: ").append(toIndentedString(overageUnusedUnitsCreditOption)).append("\n");
    sb.append("    priceChangeOption: ").append(toIndentedString(priceChangeOption)).append("\n");
    sb.append("    priceIncreaseOption: ").append(toIndentedString(priceIncreaseOption)).append("\n");
    sb.append("    priceIncreasePercentage: ").append(toIndentedString(priceIncreasePercentage)).append("\n");
    sb.append("    prices: ").append(toIndentedString(prices)).append("\n");
    sb.append("    productChargeDefinitionId: ").append(toIndentedString(productChargeDefinitionId)).append("\n");
    sb.append("    productChargeDefinitionNumber: ").append(toIndentedString(productChargeDefinitionNumber)).append("\n");
    sb.append("    productDiscountApplyDetails: ").append(toIndentedString(productDiscountApplyDetails)).append("\n");
    sb.append("    productRatePlanChargeId: ").append(toIndentedString(productRatePlanChargeId)).append("\n");
    sb.append("    productRatePlanChargeNumber: ").append(toIndentedString(productRatePlanChargeNumber)).append("\n");
    sb.append("    productRatePlanId: ").append(toIndentedString(productRatePlanId)).append("\n");
    sb.append("    productRatePlanName: ").append(toIndentedString(productRatePlanName)).append("\n");
    sb.append("    productRatePlanNumber: ").append(toIndentedString(productRatePlanNumber)).append("\n");
    sb.append("    ratingGroup: ").append(toIndentedString(ratingGroup)).append("\n");
    sb.append("    recognizedRevenueAccount: ").append(toIndentedString(recognizedRevenueAccount)).append("\n");
    sb.append("    revRecCode: ").append(toIndentedString(revRecCode)).append("\n");
    sb.append("    revRecTriggerCondition: ").append(toIndentedString(revRecTriggerCondition)).append("\n");
    sb.append("    revenueRecognitionRuleName: ").append(toIndentedString(revenueRecognitionRuleName)).append("\n");
    sb.append("    smoothingModel: ").append(toIndentedString(smoothingModel)).append("\n");
    sb.append("    specificBillingPeriod: ").append(toIndentedString(specificBillingPeriod)).append("\n");
    sb.append("    specificListPriceBase: ").append(toIndentedString(specificListPriceBase)).append("\n");
    sb.append("    taxCode: ").append(toIndentedString(taxCode)).append("\n");
    sb.append("    taxMode: ").append(toIndentedString(taxMode)).append("\n");
    sb.append("    taxable: ").append(toIndentedString(taxable)).append("\n");
    sb.append("    term: ").append(toIndentedString(term)).append("\n");
    sb.append("    termPeriodType: ").append(toIndentedString(termPeriodType)).append("\n");
    sb.append("    termType: ").append(toIndentedString(termType)).append("\n");
    sb.append("    triggerEvent: ").append(toIndentedString(triggerEvent)).append("\n");
    sb.append("    uom: ").append(toIndentedString(uom)).append("\n");
    sb.append("    upToPeriods: ").append(toIndentedString(upToPeriods)).append("\n");
    sb.append("    upToPeriodsType: ").append(toIndentedString(upToPeriodsType)).append("\n");
    sb.append("    usageRecordRatingOption: ").append(toIndentedString(usageRecordRatingOption)).append("\n");
    sb.append("    useDiscountSpecificAccountingCode: ").append(toIndentedString(useDiscountSpecificAccountingCode)).append("\n");
    sb.append("    useTenantDefaultForPriceChange: ").append(toIndentedString(useTenantDefaultForPriceChange)).append("\n");
    sb.append("    additionalProperties: ").append(toIndentedString(additionalProperties)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }


  public static HashSet<String> openapiFields;
  public static HashSet<String> openapiRequiredFields;

  static {
    // a set of all properties/fields (JSON key names)
    openapiFields = new HashSet<String>();
    openapiFields.add("description");
    openapiFields.add("applyDiscountTo");
    openapiFields.add("billingDay");
    openapiFields.add("billingPeriod");
    openapiFields.add("billingPeriodAlignment");
    openapiFields.add("billingTiming");
    openapiFields.add("chargeModel");
    openapiFields.add("chargeType");
    openapiFields.add("customFields");
    openapiFields.add("defaultQuantity");
    openapiFields.add("deliverySchedule");
    openapiFields.add("discountClass");
    openapiFields.add("discountLevel");
    openapiFields.add("effectiveEndDate");
    openapiFields.add("effectiveStartDate");
    openapiFields.add("endDateCondition");
    openapiFields.add("excludeItemBillingFromRevenueAccounting");
    openapiFields.add("excludeItemBookingFromRevenueAccounting");
    openapiFields.add("isAllocationEligible");
    openapiFields.add("isUnbilled");
    openapiFields.add("productCategory");
    openapiFields.add("productClass");
    openapiFields.add("productFamily");
    openapiFields.add("productLine");
    openapiFields.add("revenueRecognitionTiming");
    openapiFields.add("revenueAmortizationMethod");
    openapiFields.add("numberOfPeriods");
    openapiFields.add("financeInformation");
    openapiFields.add("isDefault");
    openapiFields.add("isStackedDiscount");
    openapiFields.add("listPriceBase");
    openapiFields.add("numberOfPeriod");
    openapiFields.add("overageCalculationOption");
    openapiFields.add("overageUnusedUnitsCreditOption");
    openapiFields.add("priceChangeOption");
    openapiFields.add("priceIncreaseOption");
    openapiFields.add("priceIncreasePercentage");
    openapiFields.add("prices");
    openapiFields.add("productChargeDefinitionId");
    openapiFields.add("productChargeDefinitionNumber");
    openapiFields.add("productDiscountApplyDetails");
    openapiFields.add("productRatePlanChargeId");
    openapiFields.add("productRatePlanChargeNumber");
    openapiFields.add("productRatePlanId");
    openapiFields.add("productRatePlanName");
    openapiFields.add("productRatePlanNumber");
    openapiFields.add("ratingGroup");
    openapiFields.add("recognizedRevenueAccount");
    openapiFields.add("revRecCode");
    openapiFields.add("revRecTriggerCondition");
    openapiFields.add("revenueRecognitionRuleName");
    openapiFields.add("smoothingModel");
    openapiFields.add("specificBillingPeriod");
    openapiFields.add("specificListPriceBase");
    openapiFields.add("taxCode");
    openapiFields.add("taxMode");
    openapiFields.add("taxable");
    openapiFields.add("term");
    openapiFields.add("termPeriodType");
    openapiFields.add("termType");
    openapiFields.add("triggerEvent");
    openapiFields.add("uom");
    openapiFields.add("upToPeriods");
    openapiFields.add("upToPeriodsType");
    openapiFields.add("usageRecordRatingOption");
    openapiFields.add("useDiscountSpecificAccountingCode");
    openapiFields.add("useTenantDefaultForPriceChange");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
  }

 /**
  * Validates the JSON Object and throws an exception if issues found
  *
  * @param jsonObj JSON Object
  * @throws IOException if the JSON Object is invalid with respect to ChargeDefinitions
  */
  public static void validateJsonObject(JsonObject jsonObj) throws IOException {
      if (jsonObj == null) {
        if (!ChargeDefinitions.openapiRequiredFields.isEmpty()) { // has required fields but JSON object is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in ChargeDefinitions is not found in the empty JSON string", ChargeDefinitions.openapiRequiredFields.toString()));
        }
      }
      if ((jsonObj.get("description") != null && !jsonObj.get("description").isJsonNull()) && !jsonObj.get("description").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `description` to be a primitive type in the JSON string but got `%s`", jsonObj.get("description").toString()));
      }
      if (!jsonObj.get("applyDiscountTo").isJsonNull() && (jsonObj.get("applyDiscountTo") != null && !jsonObj.get("applyDiscountTo").isJsonNull()) && !jsonObj.get("applyDiscountTo").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `applyDiscountTo` to be a primitive type in the JSON string but got `%s`", jsonObj.get("applyDiscountTo").toString()));
      }
      if ((jsonObj.get("billingDay") != null && !jsonObj.get("billingDay").isJsonNull()) && !jsonObj.get("billingDay").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `billingDay` to be a primitive type in the JSON string but got `%s`", jsonObj.get("billingDay").toString()));
      }
      if ((jsonObj.get("billingPeriod") != null && !jsonObj.get("billingPeriod").isJsonNull()) && !jsonObj.get("billingPeriod").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `billingPeriod` to be a primitive type in the JSON string but got `%s`", jsonObj.get("billingPeriod").toString()));
      }
      if ((jsonObj.get("billingPeriodAlignment") != null && !jsonObj.get("billingPeriodAlignment").isJsonNull()) && !jsonObj.get("billingPeriodAlignment").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `billingPeriodAlignment` to be a primitive type in the JSON string but got `%s`", jsonObj.get("billingPeriodAlignment").toString()));
      }
      if ((jsonObj.get("billingTiming") != null && !jsonObj.get("billingTiming").isJsonNull()) && !jsonObj.get("billingTiming").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `billingTiming` to be a primitive type in the JSON string but got `%s`", jsonObj.get("billingTiming").toString()));
      }
      if ((jsonObj.get("chargeModel") != null && !jsonObj.get("chargeModel").isJsonNull()) && !jsonObj.get("chargeModel").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `chargeModel` to be a primitive type in the JSON string but got `%s`", jsonObj.get("chargeModel").toString()));
      }
      if ((jsonObj.get("chargeType") != null && !jsonObj.get("chargeType").isJsonNull()) && !jsonObj.get("chargeType").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `chargeType` to be a primitive type in the JSON string but got `%s`", jsonObj.get("chargeType").toString()));
      }
      // validate the optional field `deliverySchedule`
      if (jsonObj.get("deliverySchedule") != null && !jsonObj.get("deliverySchedule").isJsonNull()) {
        GETDeliverySchedule.validateJsonObject(jsonObj.getAsJsonObject("deliverySchedule"));
      }
      if (!jsonObj.get("discountClass").isJsonNull() && (jsonObj.get("discountClass") != null && !jsonObj.get("discountClass").isJsonNull()) && !jsonObj.get("discountClass").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `discountClass` to be a primitive type in the JSON string but got `%s`", jsonObj.get("discountClass").toString()));
      }
      if (!jsonObj.get("discountLevel").isJsonNull() && (jsonObj.get("discountLevel") != null && !jsonObj.get("discountLevel").isJsonNull()) && !jsonObj.get("discountLevel").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `discountLevel` to be a primitive type in the JSON string but got `%s`", jsonObj.get("discountLevel").toString()));
      }
      if ((jsonObj.get("endDateCondition") != null && !jsonObj.get("endDateCondition").isJsonNull()) && !jsonObj.get("endDateCondition").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `endDateCondition` to be a primitive type in the JSON string but got `%s`", jsonObj.get("endDateCondition").toString()));
      }
      if ((jsonObj.get("productCategory") != null && !jsonObj.get("productCategory").isJsonNull()) && !jsonObj.get("productCategory").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `productCategory` to be a primitive type in the JSON string but got `%s`", jsonObj.get("productCategory").toString()));
      }
      if ((jsonObj.get("productClass") != null && !jsonObj.get("productClass").isJsonNull()) && !jsonObj.get("productClass").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `productClass` to be a primitive type in the JSON string but got `%s`", jsonObj.get("productClass").toString()));
      }
      if ((jsonObj.get("productFamily") != null && !jsonObj.get("productFamily").isJsonNull()) && !jsonObj.get("productFamily").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `productFamily` to be a primitive type in the JSON string but got `%s`", jsonObj.get("productFamily").toString()));
      }
      if ((jsonObj.get("productLine") != null && !jsonObj.get("productLine").isJsonNull()) && !jsonObj.get("productLine").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `productLine` to be a primitive type in the JSON string but got `%s`", jsonObj.get("productLine").toString()));
      }
      if ((jsonObj.get("revenueRecognitionTiming") != null && !jsonObj.get("revenueRecognitionTiming").isJsonNull()) && !jsonObj.get("revenueRecognitionTiming").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `revenueRecognitionTiming` to be a primitive type in the JSON string but got `%s`", jsonObj.get("revenueRecognitionTiming").toString()));
      }
      if ((jsonObj.get("revenueAmortizationMethod") != null && !jsonObj.get("revenueAmortizationMethod").isJsonNull()) && !jsonObj.get("revenueAmortizationMethod").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `revenueAmortizationMethod` to be a primitive type in the JSON string but got `%s`", jsonObj.get("revenueAmortizationMethod").toString()));
      }
      // validate the optional field `financeInformation`
      if (jsonObj.get("financeInformation") != null && !jsonObj.get("financeInformation").isJsonNull()) {
        FinanceInformationProperty1.validateJsonObject(jsonObj.getAsJsonObject("financeInformation"));
      }
      if ((jsonObj.get("listPriceBase") != null && !jsonObj.get("listPriceBase").isJsonNull()) && !jsonObj.get("listPriceBase").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `listPriceBase` to be a primitive type in the JSON string but got `%s`", jsonObj.get("listPriceBase").toString()));
      }
      if (!jsonObj.get("overageCalculationOption").isJsonNull() && (jsonObj.get("overageCalculationOption") != null && !jsonObj.get("overageCalculationOption").isJsonNull()) && !jsonObj.get("overageCalculationOption").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `overageCalculationOption` to be a primitive type in the JSON string but got `%s`", jsonObj.get("overageCalculationOption").toString()));
      }
      if (!jsonObj.get("overageUnusedUnitsCreditOption").isJsonNull() && (jsonObj.get("overageUnusedUnitsCreditOption") != null && !jsonObj.get("overageUnusedUnitsCreditOption").isJsonNull()) && !jsonObj.get("overageUnusedUnitsCreditOption").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `overageUnusedUnitsCreditOption` to be a primitive type in the JSON string but got `%s`", jsonObj.get("overageUnusedUnitsCreditOption").toString()));
      }
      if (!jsonObj.get("priceChangeOption").isJsonNull() && (jsonObj.get("priceChangeOption") != null && !jsonObj.get("priceChangeOption").isJsonNull()) && !jsonObj.get("priceChangeOption").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `priceChangeOption` to be a primitive type in the JSON string but got `%s`", jsonObj.get("priceChangeOption").toString()));
      }
      if ((jsonObj.get("priceIncreaseOption") != null && !jsonObj.get("priceIncreaseOption").isJsonNull()) && !jsonObj.get("priceIncreaseOption").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `priceIncreaseOption` to be a primitive type in the JSON string but got `%s`", jsonObj.get("priceIncreaseOption").toString()));
      }
      if (jsonObj.get("prices") != null && !jsonObj.get("prices").isJsonNull()) {
        JsonArray jsonArrayprices = jsonObj.getAsJsonArray("prices");
        if (jsonArrayprices != null) {
          // ensure the json data is an array
          if (!jsonObj.get("prices").isJsonArray()) {
            throw new IllegalArgumentException(String.format("Expected the field `prices` to be an array in the JSON string but got `%s`", jsonObj.get("prices").toString()));
          }

          // validate the optional field `prices` (array)
          for (int i = 0; i < jsonArrayprices.size(); i++) {
            GETProductChargeDefinitionPricing.validateJsonObject(jsonArrayprices.get(i).getAsJsonObject());
          };
        }
      }
      if ((jsonObj.get("productChargeDefinitionId") != null && !jsonObj.get("productChargeDefinitionId").isJsonNull()) && !jsonObj.get("productChargeDefinitionId").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `productChargeDefinitionId` to be a primitive type in the JSON string but got `%s`", jsonObj.get("productChargeDefinitionId").toString()));
      }
      if ((jsonObj.get("productChargeDefinitionNumber") != null && !jsonObj.get("productChargeDefinitionNumber").isJsonNull()) && !jsonObj.get("productChargeDefinitionNumber").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `productChargeDefinitionNumber` to be a primitive type in the JSON string but got `%s`", jsonObj.get("productChargeDefinitionNumber").toString()));
      }
      if (jsonObj.get("productDiscountApplyDetails") != null && !jsonObj.get("productDiscountApplyDetails").isJsonNull()) {
        JsonArray jsonArrayproductDiscountApplyDetails = jsonObj.getAsJsonArray("productDiscountApplyDetails");
        if (jsonArrayproductDiscountApplyDetails != null) {
          // ensure the json data is an array
          if (!jsonObj.get("productDiscountApplyDetails").isJsonArray()) {
            throw new IllegalArgumentException(String.format("Expected the field `productDiscountApplyDetails` to be an array in the JSON string but got `%s`", jsonObj.get("productDiscountApplyDetails").toString()));
          }

          // validate the optional field `productDiscountApplyDetails` (array)
          for (int i = 0; i < jsonArrayproductDiscountApplyDetails.size(); i++) {
            GETProductDiscountApplyDetailsType.validateJsonObject(jsonArrayproductDiscountApplyDetails.get(i).getAsJsonObject());
          };
        }
      }
      if ((jsonObj.get("productRatePlanChargeId") != null && !jsonObj.get("productRatePlanChargeId").isJsonNull()) && !jsonObj.get("productRatePlanChargeId").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `productRatePlanChargeId` to be a primitive type in the JSON string but got `%s`", jsonObj.get("productRatePlanChargeId").toString()));
      }
      if (!jsonObj.get("productRatePlanChargeNumber").isJsonNull() && (jsonObj.get("productRatePlanChargeNumber") != null && !jsonObj.get("productRatePlanChargeNumber").isJsonNull()) && !jsonObj.get("productRatePlanChargeNumber").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `productRatePlanChargeNumber` to be a primitive type in the JSON string but got `%s`", jsonObj.get("productRatePlanChargeNumber").toString()));
      }
      if (!jsonObj.get("productRatePlanId").isJsonNull() && (jsonObj.get("productRatePlanId") != null && !jsonObj.get("productRatePlanId").isJsonNull()) && !jsonObj.get("productRatePlanId").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `productRatePlanId` to be a primitive type in the JSON string but got `%s`", jsonObj.get("productRatePlanId").toString()));
      }
      if (!jsonObj.get("productRatePlanName").isJsonNull() && (jsonObj.get("productRatePlanName") != null && !jsonObj.get("productRatePlanName").isJsonNull()) && !jsonObj.get("productRatePlanName").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `productRatePlanName` to be a primitive type in the JSON string but got `%s`", jsonObj.get("productRatePlanName").toString()));
      }
      if (!jsonObj.get("productRatePlanNumber").isJsonNull() && (jsonObj.get("productRatePlanNumber") != null && !jsonObj.get("productRatePlanNumber").isJsonNull()) && !jsonObj.get("productRatePlanNumber").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `productRatePlanNumber` to be a primitive type in the JSON string but got `%s`", jsonObj.get("productRatePlanNumber").toString()));
      }
      if (!jsonObj.get("ratingGroup").isJsonNull() && (jsonObj.get("ratingGroup") != null && !jsonObj.get("ratingGroup").isJsonNull()) && !jsonObj.get("ratingGroup").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `ratingGroup` to be a primitive type in the JSON string but got `%s`", jsonObj.get("ratingGroup").toString()));
      }
      if ((jsonObj.get("recognizedRevenueAccount") != null && !jsonObj.get("recognizedRevenueAccount").isJsonNull()) && !jsonObj.get("recognizedRevenueAccount").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `recognizedRevenueAccount` to be a primitive type in the JSON string but got `%s`", jsonObj.get("recognizedRevenueAccount").toString()));
      }
      if (!jsonObj.get("revRecCode").isJsonNull() && (jsonObj.get("revRecCode") != null && !jsonObj.get("revRecCode").isJsonNull()) && !jsonObj.get("revRecCode").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `revRecCode` to be a primitive type in the JSON string but got `%s`", jsonObj.get("revRecCode").toString()));
      }
      if (!jsonObj.get("revRecTriggerCondition").isJsonNull() && (jsonObj.get("revRecTriggerCondition") != null && !jsonObj.get("revRecTriggerCondition").isJsonNull()) && !jsonObj.get("revRecTriggerCondition").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `revRecTriggerCondition` to be a primitive type in the JSON string but got `%s`", jsonObj.get("revRecTriggerCondition").toString()));
      }
      if ((jsonObj.get("revenueRecognitionRuleName") != null && !jsonObj.get("revenueRecognitionRuleName").isJsonNull()) && !jsonObj.get("revenueRecognitionRuleName").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `revenueRecognitionRuleName` to be a primitive type in the JSON string but got `%s`", jsonObj.get("revenueRecognitionRuleName").toString()));
      }
      if (!jsonObj.get("smoothingModel").isJsonNull() && (jsonObj.get("smoothingModel") != null && !jsonObj.get("smoothingModel").isJsonNull()) && !jsonObj.get("smoothingModel").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `smoothingModel` to be a primitive type in the JSON string but got `%s`", jsonObj.get("smoothingModel").toString()));
      }
      if ((jsonObj.get("taxCode") != null && !jsonObj.get("taxCode").isJsonNull()) && !jsonObj.get("taxCode").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `taxCode` to be a primitive type in the JSON string but got `%s`", jsonObj.get("taxCode").toString()));
      }
      if (!jsonObj.get("taxMode").isJsonNull() && (jsonObj.get("taxMode") != null && !jsonObj.get("taxMode").isJsonNull()) && !jsonObj.get("taxMode").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `taxMode` to be a primitive type in the JSON string but got `%s`", jsonObj.get("taxMode").toString()));
      }
      if (!jsonObj.get("termPeriodType").isJsonNull() && (jsonObj.get("termPeriodType") != null && !jsonObj.get("termPeriodType").isJsonNull()) && !jsonObj.get("termPeriodType").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `termPeriodType` to be a primitive type in the JSON string but got `%s`", jsonObj.get("termPeriodType").toString()));
      }
      if (!jsonObj.get("termType").isJsonNull() && (jsonObj.get("termType") != null && !jsonObj.get("termType").isJsonNull()) && !jsonObj.get("termType").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `termType` to be a primitive type in the JSON string but got `%s`", jsonObj.get("termType").toString()));
      }
      if ((jsonObj.get("triggerEvent") != null && !jsonObj.get("triggerEvent").isJsonNull()) && !jsonObj.get("triggerEvent").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `triggerEvent` to be a primitive type in the JSON string but got `%s`", jsonObj.get("triggerEvent").toString()));
      }
      if (!jsonObj.get("uom").isJsonNull() && (jsonObj.get("uom") != null && !jsonObj.get("uom").isJsonNull()) && !jsonObj.get("uom").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `uom` to be a primitive type in the JSON string but got `%s`", jsonObj.get("uom").toString()));
      }
      if (!jsonObj.get("upToPeriodsType").isJsonNull() && (jsonObj.get("upToPeriodsType") != null && !jsonObj.get("upToPeriodsType").isJsonNull()) && !jsonObj.get("upToPeriodsType").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `upToPeriodsType` to be a primitive type in the JSON string but got `%s`", jsonObj.get("upToPeriodsType").toString()));
      }
      if (!jsonObj.get("usageRecordRatingOption").isJsonNull() && (jsonObj.get("usageRecordRatingOption") != null && !jsonObj.get("usageRecordRatingOption").isJsonNull()) && !jsonObj.get("usageRecordRatingOption").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `usageRecordRatingOption` to be a primitive type in the JSON string but got `%s`", jsonObj.get("usageRecordRatingOption").toString()));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!ChargeDefinitions.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'ChargeDefinitions' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<ChargeDefinitions> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(ChargeDefinitions.class));

       return (TypeAdapter<T>) new TypeAdapter<ChargeDefinitions>() {
           @Override
           public void write(JsonWriter out, ChargeDefinitions value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             obj.remove("additionalProperties");
             // serialize additonal properties
             if (value.getAdditionalProperties() != null) {
               for (Map.Entry<String, Object> entry : value.getAdditionalProperties().entrySet()) {
                 if (entry.getValue() instanceof String)
                   obj.addProperty(entry.getKey(), (String) entry.getValue());
                 else if (entry.getValue() instanceof Number)
                   obj.addProperty(entry.getKey(), (Number) entry.getValue());
                 else if (entry.getValue() instanceof Boolean)
                   obj.addProperty(entry.getKey(), (Boolean) entry.getValue());
                 else if (entry.getValue() instanceof Character)
                   obj.addProperty(entry.getKey(), (Character) entry.getValue());
                 else {
                   obj.add(entry.getKey(), gson.toJsonTree(entry.getValue()).getAsJsonObject());
                 }
               }
             }
             elementAdapter.write(out, obj);
           }

           @Override
           public ChargeDefinitions read(JsonReader in) throws IOException {
             JsonObject jsonObj = elementAdapter.read(in).getAsJsonObject();
             validateJsonObject(jsonObj);
             // store additional fields in the deserialized instance
             ChargeDefinitions instance = thisAdapter.fromJsonTree(jsonObj);
             for (Map.Entry<String, JsonElement> entry : jsonObj.entrySet()) {
               if (!openapiFields.contains(entry.getKey())) {
                 if (entry.getValue().isJsonPrimitive()) { // primitive type
                   if (entry.getValue().getAsJsonPrimitive().isString())
                     instance.putAdditionalProperty(entry.getKey(), entry.getValue().getAsString());
                   else if (entry.getValue().getAsJsonPrimitive().isNumber())
                     instance.putAdditionalProperty(entry.getKey(), entry.getValue().getAsNumber());
                   else if (entry.getValue().getAsJsonPrimitive().isBoolean())
                     instance.putAdditionalProperty(entry.getKey(), entry.getValue().getAsBoolean());
                   else
                     throw new IllegalArgumentException(String.format("The field `%s` has unknown primitive type. Value: %s", entry.getKey(), entry.getValue().toString()));
                 } else if (entry.getValue().isJsonArray()) {
                     instance.putAdditionalProperty(entry.getKey(), gson.fromJson(entry.getValue(), List.class));
                 } else { // JSON object
                     instance.putAdditionalProperty(entry.getKey(), gson.fromJson(entry.getValue(), HashMap.class));
                 }
               }
             }
             return instance;
           }

       }.nullSafe();
    }
  }

 /**
  * Create an instance of ChargeDefinitions given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of ChargeDefinitions
  * @throws IOException if the JSON string is invalid with respect to ChargeDefinitions
  */
  public static ChargeDefinitions fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, ChargeDefinitions.class);
  }

 /**
  * Convert an instance of ChargeDefinitions to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

