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
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;

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
 * CreateEInvoicingBusinessRegionRequest
 */@javax.annotation.Generated(value = "Generated by https://konfigthis.com")
public class CreateEInvoicingBusinessRegionRequest {
  public static final String SERIALIZED_NAME_ADDRESS_LINE1 = "addressLine1";
  @SerializedName(SERIALIZED_NAME_ADDRESS_LINE1)
  private String addressLine1;

  public static final String SERIALIZED_NAME_ADDRESS_LINE2 = "addressLine2";
  @SerializedName(SERIALIZED_NAME_ADDRESS_LINE2)
  private String addressLine2;

  public static final String SERIALIZED_NAME_BUSINESS_NAME = "businessName";
  @SerializedName(SERIALIZED_NAME_BUSINESS_NAME)
  private String businessName;

  public static final String SERIALIZED_NAME_BUSINESS_NUMBER = "businessNumber";
  @SerializedName(SERIALIZED_NAME_BUSINESS_NUMBER)
  private String businessNumber;

  public static final String SERIALIZED_NAME_BUSINESS_NUMBER_SCHEMA_ID = "businessNumberSchemaId";
  @SerializedName(SERIALIZED_NAME_BUSINESS_NUMBER_SCHEMA_ID)
  private String businessNumberSchemaId;

  public static final String SERIALIZED_NAME_CITY = "city";
  @SerializedName(SERIALIZED_NAME_CITY)
  private String city;

  public static final String SERIALIZED_NAME_CONTACT_NAME = "contactName";
  @SerializedName(SERIALIZED_NAME_CONTACT_NAME)
  private String contactName;

  public static final String SERIALIZED_NAME_COUNTRY = "country";
  @SerializedName(SERIALIZED_NAME_COUNTRY)
  private String country;

  public static final String SERIALIZED_NAME_DIGITAL_SIGNATURE_ENABLE = "digitalSignatureEnable";
  @SerializedName(SERIALIZED_NAME_DIGITAL_SIGNATURE_ENABLE)
  private Boolean digitalSignatureEnable = false;

  public static final String SERIALIZED_NAME_DIGITAL_SIGNATURE_BOX_ENABLE = "digitalSignatureBoxEnable";
  @SerializedName(SERIALIZED_NAME_DIGITAL_SIGNATURE_BOX_ENABLE)
  private Boolean digitalSignatureBoxEnable = false;

  public static final String SERIALIZED_NAME_DIGITAL_SIGNATURE_BOX_POS_X = "digitalSignatureBoxPosX";
  @SerializedName(SERIALIZED_NAME_DIGITAL_SIGNATURE_BOX_POS_X)
  private Double digitalSignatureBoxPosX;

  public static final String SERIALIZED_NAME_DIGITAL_SIGNATURE_BOX_POS_Y = "digitalSignatureBoxPosY";
  @SerializedName(SERIALIZED_NAME_DIGITAL_SIGNATURE_BOX_POS_Y)
  private Double digitalSignatureBoxPosY;

  public static final String SERIALIZED_NAME_EMAIL = "email";
  @SerializedName(SERIALIZED_NAME_EMAIL)
  private String email;

  public static final String SERIALIZED_NAME_ENDPOINT_ID = "endpointId";
  @SerializedName(SERIALIZED_NAME_ENDPOINT_ID)
  private String endpointId;

  public static final String SERIALIZED_NAME_ENDPOINT_SCHEME_ID = "endpointSchemeId";
  @SerializedName(SERIALIZED_NAME_ENDPOINT_SCHEME_ID)
  private String endpointSchemeId;

  public static final String SERIALIZED_NAME_PHONE_NUMBER = "phoneNumber";
  @SerializedName(SERIALIZED_NAME_PHONE_NUMBER)
  private String phoneNumber;

  public static final String SERIALIZED_NAME_POSTAL_CODE = "postalCode";
  @SerializedName(SERIALIZED_NAME_POSTAL_CODE)
  private String postalCode;

  public static final String SERIALIZED_NAME_SERVICE_PROVIDER_ID = "serviceProviderId";
  @SerializedName(SERIALIZED_NAME_SERVICE_PROVIDER_ID)
  private String serviceProviderId;

  public static final String SERIALIZED_NAME_STATE = "state";
  @SerializedName(SERIALIZED_NAME_STATE)
  private String state;

  public static final String SERIALIZED_NAME_TAX_REGISTER_NUMBER = "taxRegisterNumber";
  @SerializedName(SERIALIZED_NAME_TAX_REGISTER_NUMBER)
  private String taxRegisterNumber;

  public static final String SERIALIZED_NAME_TRADE_NAME = "tradeName";
  @SerializedName(SERIALIZED_NAME_TRADE_NAME)
  private String tradeName;

  public CreateEInvoicingBusinessRegionRequest() {
  }

  public CreateEInvoicingBusinessRegionRequest addressLine1(String addressLine1) {
    
    
    
    
    this.addressLine1 = addressLine1;
    return this;
  }

   /**
   * The first line of the Seller’s address, which is often a street address or business name. 
   * @return addressLine1
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The first line of the Seller’s address, which is often a street address or business name. ")

  public String getAddressLine1() {
    return addressLine1;
  }


  public void setAddressLine1(String addressLine1) {
    
    
    
    this.addressLine1 = addressLine1;
  }


  public CreateEInvoicingBusinessRegionRequest addressLine2(String addressLine2) {
    
    
    
    
    this.addressLine2 = addressLine2;
    return this;
  }

   /**
   * The second line of the Seller’s address, which is often the name of a building. 
   * @return addressLine2
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The second line of the Seller’s address, which is often the name of a building. ")

  public String getAddressLine2() {
    return addressLine2;
  }


  public void setAddressLine2(String addressLine2) {
    
    
    
    this.addressLine2 = addressLine2;
  }


  public CreateEInvoicingBusinessRegionRequest businessName(String businessName) {
    
    
    
    
    this.businessName = businessName;
    return this;
  }

   /**
   * The full official name that the Seller is registered with the relevant legal authority. 
   * @return businessName
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "The full official name that the Seller is registered with the relevant legal authority. ")

  public String getBusinessName() {
    return businessName;
  }


  public void setBusinessName(String businessName) {
    
    
    
    this.businessName = businessName;
  }


  public CreateEInvoicingBusinessRegionRequest businessNumber(String businessNumber) {
    
    
    
    
    this.businessNumber = businessNumber;
    return this;
  }

   /**
   * The specify the unique identifier number of the legal entity or person that you do business with.  For example, you must use a GSTIN for India and Tax Identification Number (TIN) for Saudi Arabia. 
   * @return businessNumber
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The specify the unique identifier number of the legal entity or person that you do business with.  For example, you must use a GSTIN for India and Tax Identification Number (TIN) for Saudi Arabia. ")

  public String getBusinessNumber() {
    return businessNumber;
  }


  public void setBusinessNumber(String businessNumber) {
    
    
    
    this.businessNumber = businessNumber;
  }


  public CreateEInvoicingBusinessRegionRequest businessNumberSchemaId(String businessNumberSchemaId) {
    
    
    
    
    this.businessNumberSchemaId = businessNumberSchemaId;
    return this;
  }

   /**
   * The identification scheme identifier that an official registrar issues to identify the Seller as a legal entity or person. 
   * @return businessNumberSchemaId
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The identification scheme identifier that an official registrar issues to identify the Seller as a legal entity or person. ")

  public String getBusinessNumberSchemaId() {
    return businessNumberSchemaId;
  }


  public void setBusinessNumberSchemaId(String businessNumberSchemaId) {
    
    
    
    this.businessNumberSchemaId = businessNumberSchemaId;
  }


  public CreateEInvoicingBusinessRegionRequest city(String city) {
    
    
    
    
    this.city = city;
    return this;
  }

   /**
   * The the name of the city where the business is located. 
   * @return city
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The the name of the city where the business is located. ")

  public String getCity() {
    return city;
  }


  public void setCity(String city) {
    
    
    
    this.city = city;
  }


  public CreateEInvoicingBusinessRegionRequest contactName(String contactName) {
    
    
    
    
    this.contactName = contactName;
    return this;
  }

   /**
   * The name of the Seller contact to receive e-invoicing data. 
   * @return contactName
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The name of the Seller contact to receive e-invoicing data. ")

  public String getContactName() {
    return contactName;
  }


  public void setContactName(String contactName) {
    
    
    
    this.contactName = contactName;
  }


  public CreateEInvoicingBusinessRegionRequest country(String country) {
    
    
    
    
    this.country = country;
    return this;
  }

   /**
   * The short name of a country or region where you must comply with e-invoicing requirements. For example, &#x60;IN&#x60; for India. For the full list of country names and codes, see &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Quick_References/Country%2C_State%2C_and_Province_Codes/A_Country_Names_and_Their_ISO_Codes\&quot; target&#x3D;\&quot;_blank\&quot;&gt;ISO Standard Country Codes&lt;/a&gt;. 
   * @return country
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "The short name of a country or region where you must comply with e-invoicing requirements. For example, `IN` for India. For the full list of country names and codes, see <a href=\"https://knowledgecenter.zuora.com/Quick_References/Country%2C_State%2C_and_Province_Codes/A_Country_Names_and_Their_ISO_Codes\" target=\"_blank\">ISO Standard Country Codes</a>. ")

  public String getCountry() {
    return country;
  }


  public void setCountry(String country) {
    
    
    
    this.country = country;
  }


  public CreateEInvoicingBusinessRegionRequest digitalSignatureEnable(Boolean digitalSignatureEnable) {
    
    
    
    
    this.digitalSignatureEnable = digitalSignatureEnable;
    return this;
  }

   /**
   * Whether the e-invoicing service provider signs PDF files for billing documents. 
   * @return digitalSignatureEnable
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "false", value = "Whether the e-invoicing service provider signs PDF files for billing documents. ")

  public Boolean getDigitalSignatureEnable() {
    return digitalSignatureEnable;
  }


  public void setDigitalSignatureEnable(Boolean digitalSignatureEnable) {
    
    
    
    this.digitalSignatureEnable = digitalSignatureEnable;
  }


  public CreateEInvoicingBusinessRegionRequest digitalSignatureBoxEnable(Boolean digitalSignatureBoxEnable) {
    
    
    
    
    this.digitalSignatureBoxEnable = digitalSignatureBoxEnable;
    return this;
  }

   /**
   * Whether the digital signature box is displayed on PDF files for billing documents. 
   * @return digitalSignatureBoxEnable
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "false", value = "Whether the digital signature box is displayed on PDF files for billing documents. ")

  public Boolean getDigitalSignatureBoxEnable() {
    return digitalSignatureBoxEnable;
  }


  public void setDigitalSignatureBoxEnable(Boolean digitalSignatureBoxEnable) {
    
    
    
    this.digitalSignatureBoxEnable = digitalSignatureBoxEnable;
  }


  public CreateEInvoicingBusinessRegionRequest digitalSignatureBoxPosX(Double digitalSignatureBoxPosX) {
    if (digitalSignatureBoxPosX != null && digitalSignatureBoxPosX < 0) {
      throw new IllegalArgumentException("Invalid value for digitalSignatureBoxPosX. Must be greater than or equal to 0.");
    }
    
    
    
    this.digitalSignatureBoxPosX = digitalSignatureBoxPosX;
    return this;
  }

  public CreateEInvoicingBusinessRegionRequest digitalSignatureBoxPosX(Integer digitalSignatureBoxPosX) {
    if (digitalSignatureBoxPosX != null && digitalSignatureBoxPosX < 0) {
      throw new IllegalArgumentException("Invalid value for digitalSignatureBoxPosX. Must be greater than or equal to 0.");
    }
    
    
    
    this.digitalSignatureBoxPosX = digitalSignatureBoxPosX.doubleValue();
    return this;
  }

   /**
   * The X-coordinate to determine where the digital signature box is displayed on PDF files for billing documents. 
   * minimum: 0
   * @return digitalSignatureBoxPosX
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The X-coordinate to determine where the digital signature box is displayed on PDF files for billing documents. ")

  public Double getDigitalSignatureBoxPosX() {
    return digitalSignatureBoxPosX;
  }


  public void setDigitalSignatureBoxPosX(Double digitalSignatureBoxPosX) {
    if (digitalSignatureBoxPosX != null && digitalSignatureBoxPosX < 0) {
      throw new IllegalArgumentException("Invalid value for digitalSignatureBoxPosX. Must be greater than or equal to 0.");
    }
    
    
    this.digitalSignatureBoxPosX = digitalSignatureBoxPosX;
  }


  public CreateEInvoicingBusinessRegionRequest digitalSignatureBoxPosY(Double digitalSignatureBoxPosY) {
    if (digitalSignatureBoxPosY != null && digitalSignatureBoxPosY < 0) {
      throw new IllegalArgumentException("Invalid value for digitalSignatureBoxPosY. Must be greater than or equal to 0.");
    }
    
    
    
    this.digitalSignatureBoxPosY = digitalSignatureBoxPosY;
    return this;
  }

  public CreateEInvoicingBusinessRegionRequest digitalSignatureBoxPosY(Integer digitalSignatureBoxPosY) {
    if (digitalSignatureBoxPosY != null && digitalSignatureBoxPosY < 0) {
      throw new IllegalArgumentException("Invalid value for digitalSignatureBoxPosY. Must be greater than or equal to 0.");
    }
    
    
    
    this.digitalSignatureBoxPosY = digitalSignatureBoxPosY.doubleValue();
    return this;
  }

   /**
   * The Y-coordinate to determine where the digital signature box is displayed on PDF files for billing documents.  
   * minimum: 0
   * @return digitalSignatureBoxPosY
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The Y-coordinate to determine where the digital signature box is displayed on PDF files for billing documents.  ")

  public Double getDigitalSignatureBoxPosY() {
    return digitalSignatureBoxPosY;
  }


  public void setDigitalSignatureBoxPosY(Double digitalSignatureBoxPosY) {
    if (digitalSignatureBoxPosY != null && digitalSignatureBoxPosY < 0) {
      throw new IllegalArgumentException("Invalid value for digitalSignatureBoxPosY. Must be greater than or equal to 0.");
    }
    
    
    this.digitalSignatureBoxPosY = digitalSignatureBoxPosY;
  }


  public CreateEInvoicingBusinessRegionRequest email(String email) {
    
    
    
    
    this.email = email;
    return this;
  }

   /**
   * The email address of the Seller contact to receive e-invoicing data. 
   * @return email
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The email address of the Seller contact to receive e-invoicing data. ")

  public String getEmail() {
    return email;
  }


  public void setEmail(String email) {
    
    
    
    this.email = email;
  }


  public CreateEInvoicingBusinessRegionRequest endpointId(String endpointId) {
    
    
    
    
    this.endpointId = endpointId;
    return this;
  }

   /**
   * The Seller&#39;s electronic address, to which the application-level response to the e-invoice file might be delivered. 
   * @return endpointId
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The Seller's electronic address, to which the application-level response to the e-invoice file might be delivered. ")

  public String getEndpointId() {
    return endpointId;
  }


  public void setEndpointId(String endpointId) {
    
    
    
    this.endpointId = endpointId;
  }


  public CreateEInvoicingBusinessRegionRequest endpointSchemeId(String endpointSchemeId) {
    
    
    
    
    this.endpointSchemeId = endpointSchemeId;
    return this;
  }

   /**
   * The identification scheme identifier of the Seller’s electronic address. 
   * @return endpointSchemeId
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The identification scheme identifier of the Seller’s electronic address. ")

  public String getEndpointSchemeId() {
    return endpointSchemeId;
  }


  public void setEndpointSchemeId(String endpointSchemeId) {
    
    
    
    this.endpointSchemeId = endpointSchemeId;
  }


  public CreateEInvoicingBusinessRegionRequest phoneNumber(String phoneNumber) {
    
    
    
    
    this.phoneNumber = phoneNumber;
    return this;
  }

   /**
   * The business phone number of the Seller contact to receive e-invoicing data. 
   * @return phoneNumber
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The business phone number of the Seller contact to receive e-invoicing data. ")

  public String getPhoneNumber() {
    return phoneNumber;
  }


  public void setPhoneNumber(String phoneNumber) {
    
    
    
    this.phoneNumber = phoneNumber;
  }


  public CreateEInvoicingBusinessRegionRequest postalCode(String postalCode) {
    
    
    
    
    this.postalCode = postalCode;
    return this;
  }

   /**
   * The short code that can identify the business address. 
   * @return postalCode
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The short code that can identify the business address. ")

  public String getPostalCode() {
    return postalCode;
  }


  public void setPostalCode(String postalCode) {
    
    
    
    this.postalCode = postalCode;
  }


  public CreateEInvoicingBusinessRegionRequest serviceProviderId(String serviceProviderId) {
    
    
    
    
    this.serviceProviderId = serviceProviderId;
    return this;
  }

   /**
   * The unique ID of the e-invoicing service provider that is associated to the business region. 
   * @return serviceProviderId
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The unique ID of the e-invoicing service provider that is associated to the business region. ")

  public String getServiceProviderId() {
    return serviceProviderId;
  }


  public void setServiceProviderId(String serviceProviderId) {
    
    
    
    this.serviceProviderId = serviceProviderId;
  }


  public CreateEInvoicingBusinessRegionRequest state(String state) {
    
    
    
    
    this.state = state;
    return this;
  }

   /**
   * The name of the state or province where the business is located. 
   * @return state
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The name of the state or province where the business is located. ")

  public String getState() {
    return state;
  }


  public void setState(String state) {
    
    
    
    this.state = state;
  }


  public CreateEInvoicingBusinessRegionRequest taxRegisterNumber(String taxRegisterNumber) {
    
    
    
    
    this.taxRegisterNumber = taxRegisterNumber;
    return this;
  }

   /**
   * The Seller&#39;s VAT identifier (also known as Seller VAT identification number) or the local identification (defined by the Seller’s address) of the Seller for tax purposes, or a reference that enables the Seller to state the registered tax status. 
   * @return taxRegisterNumber
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The Seller's VAT identifier (also known as Seller VAT identification number) or the local identification (defined by the Seller’s address) of the Seller for tax purposes, or a reference that enables the Seller to state the registered tax status. ")

  public String getTaxRegisterNumber() {
    return taxRegisterNumber;
  }


  public void setTaxRegisterNumber(String taxRegisterNumber) {
    
    
    
    this.taxRegisterNumber = taxRegisterNumber;
  }


  public CreateEInvoicingBusinessRegionRequest tradeName(String tradeName) {
    
    
    
    
    this.tradeName = tradeName;
    return this;
  }

   /**
   * The name that the Seller is known as, other than the legal business name. 
   * @return tradeName
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The name that the Seller is known as, other than the legal business name. ")

  public String getTradeName() {
    return tradeName;
  }


  public void setTradeName(String tradeName) {
    
    
    
    this.tradeName = tradeName;
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
   * @return the CreateEInvoicingBusinessRegionRequest instance itself
   */
  public CreateEInvoicingBusinessRegionRequest putAdditionalProperty(String key, Object value) {
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
    CreateEInvoicingBusinessRegionRequest createEInvoicingBusinessRegionRequest = (CreateEInvoicingBusinessRegionRequest) o;
    return Objects.equals(this.addressLine1, createEInvoicingBusinessRegionRequest.addressLine1) &&
        Objects.equals(this.addressLine2, createEInvoicingBusinessRegionRequest.addressLine2) &&
        Objects.equals(this.businessName, createEInvoicingBusinessRegionRequest.businessName) &&
        Objects.equals(this.businessNumber, createEInvoicingBusinessRegionRequest.businessNumber) &&
        Objects.equals(this.businessNumberSchemaId, createEInvoicingBusinessRegionRequest.businessNumberSchemaId) &&
        Objects.equals(this.city, createEInvoicingBusinessRegionRequest.city) &&
        Objects.equals(this.contactName, createEInvoicingBusinessRegionRequest.contactName) &&
        Objects.equals(this.country, createEInvoicingBusinessRegionRequest.country) &&
        Objects.equals(this.digitalSignatureEnable, createEInvoicingBusinessRegionRequest.digitalSignatureEnable) &&
        Objects.equals(this.digitalSignatureBoxEnable, createEInvoicingBusinessRegionRequest.digitalSignatureBoxEnable) &&
        Objects.equals(this.digitalSignatureBoxPosX, createEInvoicingBusinessRegionRequest.digitalSignatureBoxPosX) &&
        Objects.equals(this.digitalSignatureBoxPosY, createEInvoicingBusinessRegionRequest.digitalSignatureBoxPosY) &&
        Objects.equals(this.email, createEInvoicingBusinessRegionRequest.email) &&
        Objects.equals(this.endpointId, createEInvoicingBusinessRegionRequest.endpointId) &&
        Objects.equals(this.endpointSchemeId, createEInvoicingBusinessRegionRequest.endpointSchemeId) &&
        Objects.equals(this.phoneNumber, createEInvoicingBusinessRegionRequest.phoneNumber) &&
        Objects.equals(this.postalCode, createEInvoicingBusinessRegionRequest.postalCode) &&
        Objects.equals(this.serviceProviderId, createEInvoicingBusinessRegionRequest.serviceProviderId) &&
        Objects.equals(this.state, createEInvoicingBusinessRegionRequest.state) &&
        Objects.equals(this.taxRegisterNumber, createEInvoicingBusinessRegionRequest.taxRegisterNumber) &&
        Objects.equals(this.tradeName, createEInvoicingBusinessRegionRequest.tradeName)&&
        Objects.equals(this.additionalProperties, createEInvoicingBusinessRegionRequest.additionalProperties);
  }

  @Override
  public int hashCode() {
    return Objects.hash(addressLine1, addressLine2, businessName, businessNumber, businessNumberSchemaId, city, contactName, country, digitalSignatureEnable, digitalSignatureBoxEnable, digitalSignatureBoxPosX, digitalSignatureBoxPosY, email, endpointId, endpointSchemeId, phoneNumber, postalCode, serviceProviderId, state, taxRegisterNumber, tradeName, additionalProperties);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreateEInvoicingBusinessRegionRequest {\n");
    sb.append("    addressLine1: ").append(toIndentedString(addressLine1)).append("\n");
    sb.append("    addressLine2: ").append(toIndentedString(addressLine2)).append("\n");
    sb.append("    businessName: ").append(toIndentedString(businessName)).append("\n");
    sb.append("    businessNumber: ").append(toIndentedString(businessNumber)).append("\n");
    sb.append("    businessNumberSchemaId: ").append(toIndentedString(businessNumberSchemaId)).append("\n");
    sb.append("    city: ").append(toIndentedString(city)).append("\n");
    sb.append("    contactName: ").append(toIndentedString(contactName)).append("\n");
    sb.append("    country: ").append(toIndentedString(country)).append("\n");
    sb.append("    digitalSignatureEnable: ").append(toIndentedString(digitalSignatureEnable)).append("\n");
    sb.append("    digitalSignatureBoxEnable: ").append(toIndentedString(digitalSignatureBoxEnable)).append("\n");
    sb.append("    digitalSignatureBoxPosX: ").append(toIndentedString(digitalSignatureBoxPosX)).append("\n");
    sb.append("    digitalSignatureBoxPosY: ").append(toIndentedString(digitalSignatureBoxPosY)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    endpointId: ").append(toIndentedString(endpointId)).append("\n");
    sb.append("    endpointSchemeId: ").append(toIndentedString(endpointSchemeId)).append("\n");
    sb.append("    phoneNumber: ").append(toIndentedString(phoneNumber)).append("\n");
    sb.append("    postalCode: ").append(toIndentedString(postalCode)).append("\n");
    sb.append("    serviceProviderId: ").append(toIndentedString(serviceProviderId)).append("\n");
    sb.append("    state: ").append(toIndentedString(state)).append("\n");
    sb.append("    taxRegisterNumber: ").append(toIndentedString(taxRegisterNumber)).append("\n");
    sb.append("    tradeName: ").append(toIndentedString(tradeName)).append("\n");
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
    openapiFields.add("addressLine1");
    openapiFields.add("addressLine2");
    openapiFields.add("businessName");
    openapiFields.add("businessNumber");
    openapiFields.add("businessNumberSchemaId");
    openapiFields.add("city");
    openapiFields.add("contactName");
    openapiFields.add("country");
    openapiFields.add("digitalSignatureEnable");
    openapiFields.add("digitalSignatureBoxEnable");
    openapiFields.add("digitalSignatureBoxPosX");
    openapiFields.add("digitalSignatureBoxPosY");
    openapiFields.add("email");
    openapiFields.add("endpointId");
    openapiFields.add("endpointSchemeId");
    openapiFields.add("phoneNumber");
    openapiFields.add("postalCode");
    openapiFields.add("serviceProviderId");
    openapiFields.add("state");
    openapiFields.add("taxRegisterNumber");
    openapiFields.add("tradeName");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
    openapiRequiredFields.add("businessName");
    openapiRequiredFields.add("country");
  }

 /**
  * Validates the JSON Object and throws an exception if issues found
  *
  * @param jsonObj JSON Object
  * @throws IOException if the JSON Object is invalid with respect to CreateEInvoicingBusinessRegionRequest
  */
  public static void validateJsonObject(JsonObject jsonObj) throws IOException {
      if (jsonObj == null) {
        if (!CreateEInvoicingBusinessRegionRequest.openapiRequiredFields.isEmpty()) { // has required fields but JSON object is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in CreateEInvoicingBusinessRegionRequest is not found in the empty JSON string", CreateEInvoicingBusinessRegionRequest.openapiRequiredFields.toString()));
        }
      }

      // check to make sure all required properties/fields are present in the JSON string
      for (String requiredField : CreateEInvoicingBusinessRegionRequest.openapiRequiredFields) {
        if (jsonObj.get(requiredField) == null) {
          throw new IllegalArgumentException(String.format("The required field `%s` is not found in the JSON string: %s", requiredField, jsonObj.toString()));
        }
      }
      if ((jsonObj.get("addressLine1") != null && !jsonObj.get("addressLine1").isJsonNull()) && !jsonObj.get("addressLine1").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `addressLine1` to be a primitive type in the JSON string but got `%s`", jsonObj.get("addressLine1").toString()));
      }
      if ((jsonObj.get("addressLine2") != null && !jsonObj.get("addressLine2").isJsonNull()) && !jsonObj.get("addressLine2").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `addressLine2` to be a primitive type in the JSON string but got `%s`", jsonObj.get("addressLine2").toString()));
      }
      if (!jsonObj.get("businessName").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `businessName` to be a primitive type in the JSON string but got `%s`", jsonObj.get("businessName").toString()));
      }
      if ((jsonObj.get("businessNumber") != null && !jsonObj.get("businessNumber").isJsonNull()) && !jsonObj.get("businessNumber").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `businessNumber` to be a primitive type in the JSON string but got `%s`", jsonObj.get("businessNumber").toString()));
      }
      if ((jsonObj.get("businessNumberSchemaId") != null && !jsonObj.get("businessNumberSchemaId").isJsonNull()) && !jsonObj.get("businessNumberSchemaId").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `businessNumberSchemaId` to be a primitive type in the JSON string but got `%s`", jsonObj.get("businessNumberSchemaId").toString()));
      }
      if ((jsonObj.get("city") != null && !jsonObj.get("city").isJsonNull()) && !jsonObj.get("city").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `city` to be a primitive type in the JSON string but got `%s`", jsonObj.get("city").toString()));
      }
      if ((jsonObj.get("contactName") != null && !jsonObj.get("contactName").isJsonNull()) && !jsonObj.get("contactName").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `contactName` to be a primitive type in the JSON string but got `%s`", jsonObj.get("contactName").toString()));
      }
      if (!jsonObj.get("country").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `country` to be a primitive type in the JSON string but got `%s`", jsonObj.get("country").toString()));
      }
      if ((jsonObj.get("email") != null && !jsonObj.get("email").isJsonNull()) && !jsonObj.get("email").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `email` to be a primitive type in the JSON string but got `%s`", jsonObj.get("email").toString()));
      }
      if ((jsonObj.get("endpointId") != null && !jsonObj.get("endpointId").isJsonNull()) && !jsonObj.get("endpointId").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `endpointId` to be a primitive type in the JSON string but got `%s`", jsonObj.get("endpointId").toString()));
      }
      if ((jsonObj.get("endpointSchemeId") != null && !jsonObj.get("endpointSchemeId").isJsonNull()) && !jsonObj.get("endpointSchemeId").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `endpointSchemeId` to be a primitive type in the JSON string but got `%s`", jsonObj.get("endpointSchemeId").toString()));
      }
      if ((jsonObj.get("phoneNumber") != null && !jsonObj.get("phoneNumber").isJsonNull()) && !jsonObj.get("phoneNumber").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `phoneNumber` to be a primitive type in the JSON string but got `%s`", jsonObj.get("phoneNumber").toString()));
      }
      if ((jsonObj.get("postalCode") != null && !jsonObj.get("postalCode").isJsonNull()) && !jsonObj.get("postalCode").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `postalCode` to be a primitive type in the JSON string but got `%s`", jsonObj.get("postalCode").toString()));
      }
      if ((jsonObj.get("serviceProviderId") != null && !jsonObj.get("serviceProviderId").isJsonNull()) && !jsonObj.get("serviceProviderId").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `serviceProviderId` to be a primitive type in the JSON string but got `%s`", jsonObj.get("serviceProviderId").toString()));
      }
      if ((jsonObj.get("state") != null && !jsonObj.get("state").isJsonNull()) && !jsonObj.get("state").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `state` to be a primitive type in the JSON string but got `%s`", jsonObj.get("state").toString()));
      }
      if ((jsonObj.get("taxRegisterNumber") != null && !jsonObj.get("taxRegisterNumber").isJsonNull()) && !jsonObj.get("taxRegisterNumber").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `taxRegisterNumber` to be a primitive type in the JSON string but got `%s`", jsonObj.get("taxRegisterNumber").toString()));
      }
      if ((jsonObj.get("tradeName") != null && !jsonObj.get("tradeName").isJsonNull()) && !jsonObj.get("tradeName").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `tradeName` to be a primitive type in the JSON string but got `%s`", jsonObj.get("tradeName").toString()));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!CreateEInvoicingBusinessRegionRequest.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'CreateEInvoicingBusinessRegionRequest' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<CreateEInvoicingBusinessRegionRequest> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(CreateEInvoicingBusinessRegionRequest.class));

       return (TypeAdapter<T>) new TypeAdapter<CreateEInvoicingBusinessRegionRequest>() {
           @Override
           public void write(JsonWriter out, CreateEInvoicingBusinessRegionRequest value) throws IOException {
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
           public CreateEInvoicingBusinessRegionRequest read(JsonReader in) throws IOException {
             JsonObject jsonObj = elementAdapter.read(in).getAsJsonObject();
             validateJsonObject(jsonObj);
             // store additional fields in the deserialized instance
             CreateEInvoicingBusinessRegionRequest instance = thisAdapter.fromJsonTree(jsonObj);
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
  * Create an instance of CreateEInvoicingBusinessRegionRequest given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of CreateEInvoicingBusinessRegionRequest
  * @throws IOException if the JSON string is invalid with respect to CreateEInvoicingBusinessRegionRequest
  */
  public static CreateEInvoicingBusinessRegionRequest fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, CreateEInvoicingBusinessRegionRequest.class);
  }

 /**
  * Convert an instance of CreateEInvoicingBusinessRegionRequest to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

