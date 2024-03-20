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
import com.konfigthis.client.model.BillToContactPostOrder;
import com.konfigthis.client.model.CreditCard;
import com.konfigthis.client.model.SoldToContactPostOrder;
import com.konfigthis.client.model.TaxInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
import java.util.HashMap;
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
 * Information about a new account that will own the subscription. Only available if you have enabled the Owner Transfer feature.  **Note:** The Owner Transfer feature is in **Limited Availability**. If you wish to have access to the feature, submit a request at [Zuora Global Support](http://support.zuora.com/).  If you do not set this field or the &#x60;subscriptionOwnerAccountNumber&#x60; field, the account that owns the order will also own the subscription. Zuora will return an error if you set this field and the &#x60;subscriptionOwnerAccountNumber&#x60; field. 
 */
@ApiModel(description = "Information about a new account that will own the subscription. Only available if you have enabled the Owner Transfer feature.  **Note:** The Owner Transfer feature is in **Limited Availability**. If you wish to have access to the feature, submit a request at [Zuora Global Support](http://support.zuora.com/).  If you do not set this field or the `subscriptionOwnerAccountNumber` field, the account that owns the order will also own the subscription. Zuora will return an error if you set this field and the `subscriptionOwnerAccountNumber` field. ")@javax.annotation.Generated(value = "Generated by https://konfigthis.com")
public class CreateOrderCreateSubscriptionNewSubscriptionOwnerAccountAllOf {
  public static final String SERIALIZED_NAME_ACCOUNT_NUMBER = "accountNumber";
  @SerializedName(SERIALIZED_NAME_ACCOUNT_NUMBER)
  private String accountNumber;

  public static final String SERIALIZED_NAME_ADDITIONAL_EMAIL_ADDRESSES = "additionalEmailAddresses";
  @SerializedName(SERIALIZED_NAME_ADDITIONAL_EMAIL_ADDRESSES)
  private String additionalEmailAddresses;

  public static final String SERIALIZED_NAME_ALLOW_INVOICE_EDIT = "allowInvoiceEdit";
  @SerializedName(SERIALIZED_NAME_ALLOW_INVOICE_EDIT)
  private Boolean allowInvoiceEdit;

  public static final String SERIALIZED_NAME_AUTO_PAY = "autoPay";
  @SerializedName(SERIALIZED_NAME_AUTO_PAY)
  private Boolean autoPay;

  public static final String SERIALIZED_NAME_BATCH = "batch";
  @SerializedName(SERIALIZED_NAME_BATCH)
  private String batch;

  public static final String SERIALIZED_NAME_BILL_CYCLE_DAY = "billCycleDay";
  @SerializedName(SERIALIZED_NAME_BILL_CYCLE_DAY)
  private Integer billCycleDay;

  public static final String SERIALIZED_NAME_BILL_TO_CONTACT = "billToContact";
  @SerializedName(SERIALIZED_NAME_BILL_TO_CONTACT)
  private BillToContactPostOrder billToContact;

  public static final String SERIALIZED_NAME_COMMUNICATION_PROFILE_ID = "communicationProfileId";
  @SerializedName(SERIALIZED_NAME_COMMUNICATION_PROFILE_ID)
  private String communicationProfileId;

  public static final String SERIALIZED_NAME_CREDIT_CARD = "creditCard";
  @SerializedName(SERIALIZED_NAME_CREDIT_CARD)
  private CreditCard creditCard;

  public static final String SERIALIZED_NAME_CREDIT_MEMO_TEMPLATE_ID = "creditMemoTemplateId";
  @SerializedName(SERIALIZED_NAME_CREDIT_MEMO_TEMPLATE_ID)
  private String creditMemoTemplateId;

  public static final String SERIALIZED_NAME_CRM_ID = "crmId";
  @SerializedName(SERIALIZED_NAME_CRM_ID)
  private String crmId;

  public static final String SERIALIZED_NAME_CURRENCY = "currency";
  @SerializedName(SERIALIZED_NAME_CURRENCY)
  private String currency;

  public static final String SERIALIZED_NAME_CUSTOM_FIELDS = "customFields";
  @SerializedName(SERIALIZED_NAME_CUSTOM_FIELDS)
  private Map<String, Object> customFields = null;

  public static final String SERIALIZED_NAME_CUSTOMER_SERVICE_REP_NAME = "customerServiceRepName";
  @SerializedName(SERIALIZED_NAME_CUSTOMER_SERVICE_REP_NAME)
  private String customerServiceRepName;

  public static final String SERIALIZED_NAME_DEBIT_MEMO_TEMPLATE_ID = "debitMemoTemplateId";
  @SerializedName(SERIALIZED_NAME_DEBIT_MEMO_TEMPLATE_ID)
  private String debitMemoTemplateId;

  public static final String SERIALIZED_NAME_HPM_CREDIT_CARD_PAYMENT_METHOD_ID = "hpmCreditCardPaymentMethodId";
  @SerializedName(SERIALIZED_NAME_HPM_CREDIT_CARD_PAYMENT_METHOD_ID)
  private String hpmCreditCardPaymentMethodId;

  public static final String SERIALIZED_NAME_INVOICE_DELIVERY_PREFS_EMAIL = "invoiceDeliveryPrefsEmail";
  @SerializedName(SERIALIZED_NAME_INVOICE_DELIVERY_PREFS_EMAIL)
  private Boolean invoiceDeliveryPrefsEmail;

  public static final String SERIALIZED_NAME_INVOICE_DELIVERY_PREFS_PRINT = "invoiceDeliveryPrefsPrint";
  @SerializedName(SERIALIZED_NAME_INVOICE_DELIVERY_PREFS_PRINT)
  private Boolean invoiceDeliveryPrefsPrint;

  public static final String SERIALIZED_NAME_INVOICE_TEMPLATE_ID = "invoiceTemplateId";
  @SerializedName(SERIALIZED_NAME_INVOICE_TEMPLATE_ID)
  private String invoiceTemplateId;

  public static final String SERIALIZED_NAME_NAME = "name";
  @SerializedName(SERIALIZED_NAME_NAME)
  private String name;

  public static final String SERIALIZED_NAME_NOTES = "notes";
  @SerializedName(SERIALIZED_NAME_NOTES)
  private String notes;

  public static final String SERIALIZED_NAME_PARENT_ID = "parentId";
  @SerializedName(SERIALIZED_NAME_PARENT_ID)
  private String parentId;

  public static final String SERIALIZED_NAME_PAYMENT_GATEWAY = "paymentGateway";
  @SerializedName(SERIALIZED_NAME_PAYMENT_GATEWAY)
  private String paymentGateway;

  public static final String SERIALIZED_NAME_PAYMENT_METHOD = "paymentMethod";
  @SerializedName(SERIALIZED_NAME_PAYMENT_METHOD)
  private Object paymentMethod = null;

  public static final String SERIALIZED_NAME_PAYMENT_TERM = "paymentTerm";
  @SerializedName(SERIALIZED_NAME_PAYMENT_TERM)
  private String paymentTerm;

  public static final String SERIALIZED_NAME_PURCHASE_ORDER_NUMBER = "purchaseOrderNumber";
  @SerializedName(SERIALIZED_NAME_PURCHASE_ORDER_NUMBER)
  private String purchaseOrderNumber;

  public static final String SERIALIZED_NAME_SALES_REP = "salesRep";
  @SerializedName(SERIALIZED_NAME_SALES_REP)
  private String salesRep;

  public static final String SERIALIZED_NAME_SOLD_TO_CONTACT = "soldToContact";
  @SerializedName(SERIALIZED_NAME_SOLD_TO_CONTACT)
  private SoldToContactPostOrder soldToContact;

  public static final String SERIALIZED_NAME_TAX_INFO = "taxInfo";
  @SerializedName(SERIALIZED_NAME_TAX_INFO)
  private TaxInfo taxInfo;

  public CreateOrderCreateSubscriptionNewSubscriptionOwnerAccountAllOf() {
  }

  public CreateOrderCreateSubscriptionNewSubscriptionOwnerAccountAllOf accountNumber(String accountNumber) {
    
    
    
    
    this.accountNumber = accountNumber;
    return this;
  }

   /**
   * Account number. For example, A00000001. 
   * @return accountNumber
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Account number. For example, A00000001. ")

  public String getAccountNumber() {
    return accountNumber;
  }


  public void setAccountNumber(String accountNumber) {
    
    
    
    this.accountNumber = accountNumber;
  }


  public CreateOrderCreateSubscriptionNewSubscriptionOwnerAccountAllOf additionalEmailAddresses(String additionalEmailAddresses) {
    
    
    
    
    this.additionalEmailAddresses = additionalEmailAddresses;
    return this;
  }

   /**
   * List of additional email addresses to receive emailed invoices. Values should be a comma-separated list of email addresses. 
   * @return additionalEmailAddresses
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "List of additional email addresses to receive emailed invoices. Values should be a comma-separated list of email addresses. ")

  public String getAdditionalEmailAddresses() {
    return additionalEmailAddresses;
  }


  public void setAdditionalEmailAddresses(String additionalEmailAddresses) {
    
    
    
    this.additionalEmailAddresses = additionalEmailAddresses;
  }


  public CreateOrderCreateSubscriptionNewSubscriptionOwnerAccountAllOf allowInvoiceEdit(Boolean allowInvoiceEdit) {
    
    
    
    
    this.allowInvoiceEdit = allowInvoiceEdit;
    return this;
  }

   /**
   * Indicates if associated invoices can be edited. Values are:   * &#x60;true&#x60; * &#x60;false&#x60; (default) 
   * @return allowInvoiceEdit
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Indicates if associated invoices can be edited. Values are:   * `true` * `false` (default) ")

  public Boolean getAllowInvoiceEdit() {
    return allowInvoiceEdit;
  }


  public void setAllowInvoiceEdit(Boolean allowInvoiceEdit) {
    
    
    
    this.allowInvoiceEdit = allowInvoiceEdit;
  }


  public CreateOrderCreateSubscriptionNewSubscriptionOwnerAccountAllOf autoPay(Boolean autoPay) {
    
    
    
    
    this.autoPay = autoPay;
    return this;
  }

   /**
   * Specifies whether future payments are automatically billed when they are due. 
   * @return autoPay
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Specifies whether future payments are automatically billed when they are due. ")

  public Boolean getAutoPay() {
    return autoPay;
  }


  public void setAutoPay(Boolean autoPay) {
    
    
    
    this.autoPay = autoPay;
  }


  public CreateOrderCreateSubscriptionNewSubscriptionOwnerAccountAllOf batch(String batch) {
    
    
    
    
    this.batch = batch;
    return this;
  }

   /**
   * Name of the billing batch that the account belongs to. For example, Batch1. 
   * @return batch
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Name of the billing batch that the account belongs to. For example, Batch1. ")

  public String getBatch() {
    return batch;
  }


  public void setBatch(String batch) {
    
    
    
    this.batch = batch;
  }


  public CreateOrderCreateSubscriptionNewSubscriptionOwnerAccountAllOf billCycleDay(Integer billCycleDay) {
    if (billCycleDay != null && billCycleDay < 0) {
      throw new IllegalArgumentException("Invalid value for billCycleDay. Must be greater than or equal to 0.");
    }
    if (billCycleDay != null && billCycleDay > 31) {
      throw new IllegalArgumentException("Invalid value for billCycleDay. Must be less than or equal to 31.");
    }
    
    
    this.billCycleDay = billCycleDay;
    return this;
  }

   /**
   * Day of the month that the account prefers billing periods to begin on. If set to 0, the bill cycle day will be set as \&quot;AutoSet\&quot;. 
   * minimum: 0
   * maximum: 31
   * @return billCycleDay
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "Day of the month that the account prefers billing periods to begin on. If set to 0, the bill cycle day will be set as \"AutoSet\". ")

  public Integer getBillCycleDay() {
    return billCycleDay;
  }


  public void setBillCycleDay(Integer billCycleDay) {
    if (billCycleDay != null && billCycleDay < 0) {
      throw new IllegalArgumentException("Invalid value for billCycleDay. Must be greater than or equal to 0.");
    }
    if (billCycleDay != null && billCycleDay > 31) {
      throw new IllegalArgumentException("Invalid value for billCycleDay. Must be less than or equal to 31.");
    }
    
    this.billCycleDay = billCycleDay;
  }


  public CreateOrderCreateSubscriptionNewSubscriptionOwnerAccountAllOf billToContact(BillToContactPostOrder billToContact) {
    
    
    
    
    this.billToContact = billToContact;
    return this;
  }

   /**
   * Get billToContact
   * @return billToContact
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")

  public BillToContactPostOrder getBillToContact() {
    return billToContact;
  }


  public void setBillToContact(BillToContactPostOrder billToContact) {
    
    
    
    this.billToContact = billToContact;
  }


  public CreateOrderCreateSubscriptionNewSubscriptionOwnerAccountAllOf communicationProfileId(String communicationProfileId) {
    
    
    
    
    this.communicationProfileId = communicationProfileId;
    return this;
  }

   /**
   * Internal identifier of the communication profile that Zuora uses when sending notifications to the account&#39;s contacts. 
   * @return communicationProfileId
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Internal identifier of the communication profile that Zuora uses when sending notifications to the account's contacts. ")

  public String getCommunicationProfileId() {
    return communicationProfileId;
  }


  public void setCommunicationProfileId(String communicationProfileId) {
    
    
    
    this.communicationProfileId = communicationProfileId;
  }


  public CreateOrderCreateSubscriptionNewSubscriptionOwnerAccountAllOf creditCard(CreditCard creditCard) {
    
    
    
    
    this.creditCard = creditCard;
    return this;
  }

   /**
   * Get creditCard
   * @return creditCard
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public CreditCard getCreditCard() {
    return creditCard;
  }


  public void setCreditCard(CreditCard creditCard) {
    
    
    
    this.creditCard = creditCard;
  }


  public CreateOrderCreateSubscriptionNewSubscriptionOwnerAccountAllOf creditMemoTemplateId(String creditMemoTemplateId) {
    
    
    
    
    this.creditMemoTemplateId = creditMemoTemplateId;
    return this;
  }

   /**
   * **Note:** This field is only available if you have [Invoice Settlement](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/Invoice_Settlement) enabled. The Invoice Settlement feature is generally available as of Zuora Billing Release 296 (March 2021). This feature includes Unapplied Payments, Credit and Debit Memo, and Invoice Item Settlement. If you want to enable Invoice Settlement, see [Invoice Settlement Enablement and Checklist Guide](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/Invoice_Settlement/Invoice_Settlement_Migration_Checklist_and_Guide) for more information.  The unique ID of the credit memo template, configured in **Billing Settings** &gt; **Manage Billing Document Configuration** through the Zuora UI. For example, 2c92c08a6246fdf101626b1b3fe0144b. 
   * @return creditMemoTemplateId
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "**Note:** This field is only available if you have [Invoice Settlement](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/Invoice_Settlement) enabled. The Invoice Settlement feature is generally available as of Zuora Billing Release 296 (March 2021). This feature includes Unapplied Payments, Credit and Debit Memo, and Invoice Item Settlement. If you want to enable Invoice Settlement, see [Invoice Settlement Enablement and Checklist Guide](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/Invoice_Settlement/Invoice_Settlement_Migration_Checklist_and_Guide) for more information.  The unique ID of the credit memo template, configured in **Billing Settings** > **Manage Billing Document Configuration** through the Zuora UI. For example, 2c92c08a6246fdf101626b1b3fe0144b. ")

  public String getCreditMemoTemplateId() {
    return creditMemoTemplateId;
  }


  public void setCreditMemoTemplateId(String creditMemoTemplateId) {
    
    
    
    this.creditMemoTemplateId = creditMemoTemplateId;
  }


  public CreateOrderCreateSubscriptionNewSubscriptionOwnerAccountAllOf crmId(String crmId) {
    
    
    
    
    this.crmId = crmId;
    return this;
  }

   /**
   * External identifier of the account in a CRM system. 
   * @return crmId
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "External identifier of the account in a CRM system. ")

  public String getCrmId() {
    return crmId;
  }


  public void setCrmId(String crmId) {
    
    
    
    this.crmId = crmId;
  }


  public CreateOrderCreateSubscriptionNewSubscriptionOwnerAccountAllOf currency(String currency) {
    
    
    
    
    this.currency = currency;
    return this;
  }

   /**
   * ISO 3-letter currency code (uppercase). For example, USD. 
   * @return currency
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "ISO 3-letter currency code (uppercase). For example, USD. ")

  public String getCurrency() {
    return currency;
  }


  public void setCurrency(String currency) {
    
    
    
    this.currency = currency;
  }


  public CreateOrderCreateSubscriptionNewSubscriptionOwnerAccountAllOf customFields(Map<String, Object> customFields) {
    
    
    
    
    this.customFields = customFields;
    return this;
  }

  public CreateOrderCreateSubscriptionNewSubscriptionOwnerAccountAllOf putCustomFieldsItem(String key, Object customFieldsItem) {
    if (this.customFields == null) {
      this.customFields = new HashMap<>();
    }
    this.customFields.put(key, customFieldsItem);
    return this;
  }

   /**
   * Container for custom fields of an Account object. 
   * @return customFields
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Container for custom fields of an Account object. ")

  public Map<String, Object> getCustomFields() {
    return customFields;
  }


  public void setCustomFields(Map<String, Object> customFields) {
    
    
    
    this.customFields = customFields;
  }


  public CreateOrderCreateSubscriptionNewSubscriptionOwnerAccountAllOf customerServiceRepName(String customerServiceRepName) {
    
    
    
    
    this.customerServiceRepName = customerServiceRepName;
    return this;
  }

   /**
   * Name of the account&#39;s customer service representative, if applicable. 
   * @return customerServiceRepName
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Name of the account's customer service representative, if applicable. ")

  public String getCustomerServiceRepName() {
    return customerServiceRepName;
  }


  public void setCustomerServiceRepName(String customerServiceRepName) {
    
    
    
    this.customerServiceRepName = customerServiceRepName;
  }


  public CreateOrderCreateSubscriptionNewSubscriptionOwnerAccountAllOf debitMemoTemplateId(String debitMemoTemplateId) {
    
    
    
    
    this.debitMemoTemplateId = debitMemoTemplateId;
    return this;
  }

   /**
   * **Note:** This field is only available if you have [Invoice Settlement](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/Invoice_Settlement) enabled. The Invoice Settlement feature is generally available as of Zuora Billing Release 296 (March 2021). This feature includes Unapplied Payments, Credit and Debit Memo, and Invoice Item Settlement. If you want to enable Invoice Settlement, see [Invoice Settlement Enablement and Checklist Guide](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/Invoice_Settlement/Invoice_Settlement_Migration_Checklist_and_Guide) for more information.  The unique ID of the debit memo template, configured in **Billing Settings** &gt; **Manage Billing Document Configuration** through the Zuora UI. For example, 2c92c08d62470a8501626b19d24f19e2. 
   * @return debitMemoTemplateId
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "**Note:** This field is only available if you have [Invoice Settlement](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/Invoice_Settlement) enabled. The Invoice Settlement feature is generally available as of Zuora Billing Release 296 (March 2021). This feature includes Unapplied Payments, Credit and Debit Memo, and Invoice Item Settlement. If you want to enable Invoice Settlement, see [Invoice Settlement Enablement and Checklist Guide](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/Invoice_Settlement/Invoice_Settlement_Migration_Checklist_and_Guide) for more information.  The unique ID of the debit memo template, configured in **Billing Settings** > **Manage Billing Document Configuration** through the Zuora UI. For example, 2c92c08d62470a8501626b19d24f19e2. ")

  public String getDebitMemoTemplateId() {
    return debitMemoTemplateId;
  }


  public void setDebitMemoTemplateId(String debitMemoTemplateId) {
    
    
    
    this.debitMemoTemplateId = debitMemoTemplateId;
  }


  public CreateOrderCreateSubscriptionNewSubscriptionOwnerAccountAllOf hpmCreditCardPaymentMethodId(String hpmCreditCardPaymentMethodId) {
    
    
    
    
    this.hpmCreditCardPaymentMethodId = hpmCreditCardPaymentMethodId;
    return this;
  }

   /**
   * The ID of the payment method associated with this account. The payment method specified for this field will be set as the default payment method of the account.  If the &#x60;autoPay&#x60; field is set to &#x60;true&#x60;, you must provide the credit card payment method ID for either this field or the &#x60;creditCard&#x60; field, but not both.  For the Credit Card Reference Transaction payment method, you can specify the payment method ID in this field or use the &#x60;paymentMethod&#x60; field to create a CC Reference Transaction payment method for an account. 
   * @return hpmCreditCardPaymentMethodId
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The ID of the payment method associated with this account. The payment method specified for this field will be set as the default payment method of the account.  If the `autoPay` field is set to `true`, you must provide the credit card payment method ID for either this field or the `creditCard` field, but not both.  For the Credit Card Reference Transaction payment method, you can specify the payment method ID in this field or use the `paymentMethod` field to create a CC Reference Transaction payment method for an account. ")

  public String getHpmCreditCardPaymentMethodId() {
    return hpmCreditCardPaymentMethodId;
  }


  public void setHpmCreditCardPaymentMethodId(String hpmCreditCardPaymentMethodId) {
    
    
    
    this.hpmCreditCardPaymentMethodId = hpmCreditCardPaymentMethodId;
  }


  public CreateOrderCreateSubscriptionNewSubscriptionOwnerAccountAllOf invoiceDeliveryPrefsEmail(Boolean invoiceDeliveryPrefsEmail) {
    
    
    
    
    this.invoiceDeliveryPrefsEmail = invoiceDeliveryPrefsEmail;
    return this;
  }

   /**
   * Specifies whether to turn on the invoice delivery method &#39;Email&#39; for the new account.  Values are:   * &#x60;true&#x60; (default). Turn on the invoice delivery method &#39;Email&#39; for the new account. * &#x60;false&#x60;. Turn off the invoice delivery method &#39;Email&#39; for the new account.          
   * @return invoiceDeliveryPrefsEmail
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Specifies whether to turn on the invoice delivery method 'Email' for the new account.  Values are:   * `true` (default). Turn on the invoice delivery method 'Email' for the new account. * `false`. Turn off the invoice delivery method 'Email' for the new account.          ")

  public Boolean getInvoiceDeliveryPrefsEmail() {
    return invoiceDeliveryPrefsEmail;
  }


  public void setInvoiceDeliveryPrefsEmail(Boolean invoiceDeliveryPrefsEmail) {
    
    
    
    this.invoiceDeliveryPrefsEmail = invoiceDeliveryPrefsEmail;
  }


  public CreateOrderCreateSubscriptionNewSubscriptionOwnerAccountAllOf invoiceDeliveryPrefsPrint(Boolean invoiceDeliveryPrefsPrint) {
    
    
    
    
    this.invoiceDeliveryPrefsPrint = invoiceDeliveryPrefsPrint;
    return this;
  }

   /**
   * Specifies whether to turn on the invoice delivery method &#39;Print&#39; for the new account. Values are:   * &#x60;true&#x60;. Turn on the invoice delivery method &#39;Print&#39; for the new account. * &#x60;false&#x60; (default). Turn off the invoice delivery method &#39;Print&#39; for the new account. 
   * @return invoiceDeliveryPrefsPrint
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Specifies whether to turn on the invoice delivery method 'Print' for the new account. Values are:   * `true`. Turn on the invoice delivery method 'Print' for the new account. * `false` (default). Turn off the invoice delivery method 'Print' for the new account. ")

  public Boolean getInvoiceDeliveryPrefsPrint() {
    return invoiceDeliveryPrefsPrint;
  }


  public void setInvoiceDeliveryPrefsPrint(Boolean invoiceDeliveryPrefsPrint) {
    
    
    
    this.invoiceDeliveryPrefsPrint = invoiceDeliveryPrefsPrint;
  }


  public CreateOrderCreateSubscriptionNewSubscriptionOwnerAccountAllOf invoiceTemplateId(String invoiceTemplateId) {
    
    
    
    
    this.invoiceTemplateId = invoiceTemplateId;
    return this;
  }

   /**
   * Internal identifier of the invoice template that Zuora uses when generating invoices for the account. 
   * @return invoiceTemplateId
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Internal identifier of the invoice template that Zuora uses when generating invoices for the account. ")

  public String getInvoiceTemplateId() {
    return invoiceTemplateId;
  }


  public void setInvoiceTemplateId(String invoiceTemplateId) {
    
    
    
    this.invoiceTemplateId = invoiceTemplateId;
  }


  public CreateOrderCreateSubscriptionNewSubscriptionOwnerAccountAllOf name(String name) {
    
    
    
    
    this.name = name;
    return this;
  }

   /**
   * Account name. 
   * @return name
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "Account name. ")

  public String getName() {
    return name;
  }


  public void setName(String name) {
    
    
    
    this.name = name;
  }


  public CreateOrderCreateSubscriptionNewSubscriptionOwnerAccountAllOf notes(String notes) {
    
    
    
    
    this.notes = notes;
    return this;
  }

   /**
   * Notes about the account. These notes are only visible to Zuora users. 
   * @return notes
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Notes about the account. These notes are only visible to Zuora users. ")

  public String getNotes() {
    return notes;
  }


  public void setNotes(String notes) {
    
    
    
    this.notes = notes;
  }


  public CreateOrderCreateSubscriptionNewSubscriptionOwnerAccountAllOf parentId(String parentId) {
    
    
    
    
    this.parentId = parentId;
    return this;
  }

   /**
   * Identifier of the parent customer account for this Account object. Use this field if you have &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Billing/Subscriptions/Customer_Accounts/A_Customer_Account_Introduction#Customer_Hierarchy\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Customer Hierarchy&lt;/a&gt; enabled.
   * @return parentId
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Identifier of the parent customer account for this Account object. Use this field if you have <a href=\"https://knowledgecenter.zuora.com/Billing/Subscriptions/Customer_Accounts/A_Customer_Account_Introduction#Customer_Hierarchy\" target=\"_blank\">Customer Hierarchy</a> enabled.")

  public String getParentId() {
    return parentId;
  }


  public void setParentId(String parentId) {
    
    
    
    this.parentId = parentId;
  }


  public CreateOrderCreateSubscriptionNewSubscriptionOwnerAccountAllOf paymentGateway(String paymentGateway) {
    
    
    
    
    this.paymentGateway = paymentGateway;
    return this;
  }

   /**
   * The payment gateway that Zuora uses when processing electronic payments and refunds for the account. If you do not specify this field or if the value of this field is null, Zuora uses your default payment gateway. 
   * @return paymentGateway
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The payment gateway that Zuora uses when processing electronic payments and refunds for the account. If you do not specify this field or if the value of this field is null, Zuora uses your default payment gateway. ")

  public String getPaymentGateway() {
    return paymentGateway;
  }


  public void setPaymentGateway(String paymentGateway) {
    
    
    
    this.paymentGateway = paymentGateway;
  }


  public CreateOrderCreateSubscriptionNewSubscriptionOwnerAccountAllOf paymentMethod(Object paymentMethod) {
    
    
    
    
    this.paymentMethod = paymentMethod;
    return this;
  }

   /**
   * Get paymentMethod
   * @return paymentMethod
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public Object getPaymentMethod() {
    return paymentMethod;
  }


  public void setPaymentMethod(Object paymentMethod) {
    
    
    
    this.paymentMethod = paymentMethod;
  }


  public CreateOrderCreateSubscriptionNewSubscriptionOwnerAccountAllOf paymentTerm(String paymentTerm) {
    
    
    
    
    this.paymentTerm = paymentTerm;
    return this;
  }

   /**
   * Name of the payment term associated with the account. For example, \&quot;Net 30\&quot;. The payment term determines the due dates of invoices. 
   * @return paymentTerm
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Name of the payment term associated with the account. For example, \"Net 30\". The payment term determines the due dates of invoices. ")

  public String getPaymentTerm() {
    return paymentTerm;
  }


  public void setPaymentTerm(String paymentTerm) {
    
    
    
    this.paymentTerm = paymentTerm;
  }


  public CreateOrderCreateSubscriptionNewSubscriptionOwnerAccountAllOf purchaseOrderNumber(String purchaseOrderNumber) {
    
    
    
    
    this.purchaseOrderNumber = purchaseOrderNumber;
    return this;
  }

   /**
   * The number of the purchase order associated with this account. Purchase order information generally comes from customers. 
   * @return purchaseOrderNumber
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The number of the purchase order associated with this account. Purchase order information generally comes from customers. ")

  public String getPurchaseOrderNumber() {
    return purchaseOrderNumber;
  }


  public void setPurchaseOrderNumber(String purchaseOrderNumber) {
    
    
    
    this.purchaseOrderNumber = purchaseOrderNumber;
  }


  public CreateOrderCreateSubscriptionNewSubscriptionOwnerAccountAllOf salesRep(String salesRep) {
    
    
    
    
    this.salesRep = salesRep;
    return this;
  }

   /**
   * The name of the sales representative associated with this account, if applicable. 
   * @return salesRep
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The name of the sales representative associated with this account, if applicable. ")

  public String getSalesRep() {
    return salesRep;
  }


  public void setSalesRep(String salesRep) {
    
    
    
    this.salesRep = salesRep;
  }


  public CreateOrderCreateSubscriptionNewSubscriptionOwnerAccountAllOf soldToContact(SoldToContactPostOrder soldToContact) {
    
    
    
    
    this.soldToContact = soldToContact;
    return this;
  }

   /**
   * Get soldToContact
   * @return soldToContact
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public SoldToContactPostOrder getSoldToContact() {
    return soldToContact;
  }


  public void setSoldToContact(SoldToContactPostOrder soldToContact) {
    
    
    
    this.soldToContact = soldToContact;
  }


  public CreateOrderCreateSubscriptionNewSubscriptionOwnerAccountAllOf taxInfo(TaxInfo taxInfo) {
    
    
    
    
    this.taxInfo = taxInfo;
    return this;
  }

   /**
   * Get taxInfo
   * @return taxInfo
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public TaxInfo getTaxInfo() {
    return taxInfo;
  }


  public void setTaxInfo(TaxInfo taxInfo) {
    
    
    
    this.taxInfo = taxInfo;
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
   * @return the CreateOrderCreateSubscriptionNewSubscriptionOwnerAccountAllOf instance itself
   */
  public CreateOrderCreateSubscriptionNewSubscriptionOwnerAccountAllOf putAdditionalProperty(String key, Object value) {
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
    CreateOrderCreateSubscriptionNewSubscriptionOwnerAccountAllOf createOrderCreateSubscriptionNewSubscriptionOwnerAccountAllOf = (CreateOrderCreateSubscriptionNewSubscriptionOwnerAccountAllOf) o;
    return Objects.equals(this.accountNumber, createOrderCreateSubscriptionNewSubscriptionOwnerAccountAllOf.accountNumber) &&
        Objects.equals(this.additionalEmailAddresses, createOrderCreateSubscriptionNewSubscriptionOwnerAccountAllOf.additionalEmailAddresses) &&
        Objects.equals(this.allowInvoiceEdit, createOrderCreateSubscriptionNewSubscriptionOwnerAccountAllOf.allowInvoiceEdit) &&
        Objects.equals(this.autoPay, createOrderCreateSubscriptionNewSubscriptionOwnerAccountAllOf.autoPay) &&
        Objects.equals(this.batch, createOrderCreateSubscriptionNewSubscriptionOwnerAccountAllOf.batch) &&
        Objects.equals(this.billCycleDay, createOrderCreateSubscriptionNewSubscriptionOwnerAccountAllOf.billCycleDay) &&
        Objects.equals(this.billToContact, createOrderCreateSubscriptionNewSubscriptionOwnerAccountAllOf.billToContact) &&
        Objects.equals(this.communicationProfileId, createOrderCreateSubscriptionNewSubscriptionOwnerAccountAllOf.communicationProfileId) &&
        Objects.equals(this.creditCard, createOrderCreateSubscriptionNewSubscriptionOwnerAccountAllOf.creditCard) &&
        Objects.equals(this.creditMemoTemplateId, createOrderCreateSubscriptionNewSubscriptionOwnerAccountAllOf.creditMemoTemplateId) &&
        Objects.equals(this.crmId, createOrderCreateSubscriptionNewSubscriptionOwnerAccountAllOf.crmId) &&
        Objects.equals(this.currency, createOrderCreateSubscriptionNewSubscriptionOwnerAccountAllOf.currency) &&
        Objects.equals(this.customFields, createOrderCreateSubscriptionNewSubscriptionOwnerAccountAllOf.customFields) &&
        Objects.equals(this.customerServiceRepName, createOrderCreateSubscriptionNewSubscriptionOwnerAccountAllOf.customerServiceRepName) &&
        Objects.equals(this.debitMemoTemplateId, createOrderCreateSubscriptionNewSubscriptionOwnerAccountAllOf.debitMemoTemplateId) &&
        Objects.equals(this.hpmCreditCardPaymentMethodId, createOrderCreateSubscriptionNewSubscriptionOwnerAccountAllOf.hpmCreditCardPaymentMethodId) &&
        Objects.equals(this.invoiceDeliveryPrefsEmail, createOrderCreateSubscriptionNewSubscriptionOwnerAccountAllOf.invoiceDeliveryPrefsEmail) &&
        Objects.equals(this.invoiceDeliveryPrefsPrint, createOrderCreateSubscriptionNewSubscriptionOwnerAccountAllOf.invoiceDeliveryPrefsPrint) &&
        Objects.equals(this.invoiceTemplateId, createOrderCreateSubscriptionNewSubscriptionOwnerAccountAllOf.invoiceTemplateId) &&
        Objects.equals(this.name, createOrderCreateSubscriptionNewSubscriptionOwnerAccountAllOf.name) &&
        Objects.equals(this.notes, createOrderCreateSubscriptionNewSubscriptionOwnerAccountAllOf.notes) &&
        Objects.equals(this.parentId, createOrderCreateSubscriptionNewSubscriptionOwnerAccountAllOf.parentId) &&
        Objects.equals(this.paymentGateway, createOrderCreateSubscriptionNewSubscriptionOwnerAccountAllOf.paymentGateway) &&
        Objects.equals(this.paymentMethod, createOrderCreateSubscriptionNewSubscriptionOwnerAccountAllOf.paymentMethod) &&
        Objects.equals(this.paymentTerm, createOrderCreateSubscriptionNewSubscriptionOwnerAccountAllOf.paymentTerm) &&
        Objects.equals(this.purchaseOrderNumber, createOrderCreateSubscriptionNewSubscriptionOwnerAccountAllOf.purchaseOrderNumber) &&
        Objects.equals(this.salesRep, createOrderCreateSubscriptionNewSubscriptionOwnerAccountAllOf.salesRep) &&
        Objects.equals(this.soldToContact, createOrderCreateSubscriptionNewSubscriptionOwnerAccountAllOf.soldToContact) &&
        Objects.equals(this.taxInfo, createOrderCreateSubscriptionNewSubscriptionOwnerAccountAllOf.taxInfo)&&
        Objects.equals(this.additionalProperties, createOrderCreateSubscriptionNewSubscriptionOwnerAccountAllOf.additionalProperties);
  }

  private static <T> boolean equalsNullable(JsonNullable<T> a, JsonNullable<T> b) {
    return a == b || (a != null && b != null && a.isPresent() && b.isPresent() && Objects.deepEquals(a.get(), b.get()));
  }

  @Override
  public int hashCode() {
    return Objects.hash(accountNumber, additionalEmailAddresses, allowInvoiceEdit, autoPay, batch, billCycleDay, billToContact, communicationProfileId, creditCard, creditMemoTemplateId, crmId, currency, customFields, customerServiceRepName, debitMemoTemplateId, hpmCreditCardPaymentMethodId, invoiceDeliveryPrefsEmail, invoiceDeliveryPrefsPrint, invoiceTemplateId, name, notes, parentId, paymentGateway, paymentMethod, paymentTerm, purchaseOrderNumber, salesRep, soldToContact, taxInfo, additionalProperties);
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
    sb.append("class CreateOrderCreateSubscriptionNewSubscriptionOwnerAccountAllOf {\n");
    sb.append("    accountNumber: ").append(toIndentedString(accountNumber)).append("\n");
    sb.append("    additionalEmailAddresses: ").append(toIndentedString(additionalEmailAddresses)).append("\n");
    sb.append("    allowInvoiceEdit: ").append(toIndentedString(allowInvoiceEdit)).append("\n");
    sb.append("    autoPay: ").append(toIndentedString(autoPay)).append("\n");
    sb.append("    batch: ").append(toIndentedString(batch)).append("\n");
    sb.append("    billCycleDay: ").append(toIndentedString(billCycleDay)).append("\n");
    sb.append("    billToContact: ").append(toIndentedString(billToContact)).append("\n");
    sb.append("    communicationProfileId: ").append(toIndentedString(communicationProfileId)).append("\n");
    sb.append("    creditCard: ").append(toIndentedString(creditCard)).append("\n");
    sb.append("    creditMemoTemplateId: ").append(toIndentedString(creditMemoTemplateId)).append("\n");
    sb.append("    crmId: ").append(toIndentedString(crmId)).append("\n");
    sb.append("    currency: ").append(toIndentedString(currency)).append("\n");
    sb.append("    customFields: ").append(toIndentedString(customFields)).append("\n");
    sb.append("    customerServiceRepName: ").append(toIndentedString(customerServiceRepName)).append("\n");
    sb.append("    debitMemoTemplateId: ").append(toIndentedString(debitMemoTemplateId)).append("\n");
    sb.append("    hpmCreditCardPaymentMethodId: ").append(toIndentedString(hpmCreditCardPaymentMethodId)).append("\n");
    sb.append("    invoiceDeliveryPrefsEmail: ").append(toIndentedString(invoiceDeliveryPrefsEmail)).append("\n");
    sb.append("    invoiceDeliveryPrefsPrint: ").append(toIndentedString(invoiceDeliveryPrefsPrint)).append("\n");
    sb.append("    invoiceTemplateId: ").append(toIndentedString(invoiceTemplateId)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    notes: ").append(toIndentedString(notes)).append("\n");
    sb.append("    parentId: ").append(toIndentedString(parentId)).append("\n");
    sb.append("    paymentGateway: ").append(toIndentedString(paymentGateway)).append("\n");
    sb.append("    paymentMethod: ").append(toIndentedString(paymentMethod)).append("\n");
    sb.append("    paymentTerm: ").append(toIndentedString(paymentTerm)).append("\n");
    sb.append("    purchaseOrderNumber: ").append(toIndentedString(purchaseOrderNumber)).append("\n");
    sb.append("    salesRep: ").append(toIndentedString(salesRep)).append("\n");
    sb.append("    soldToContact: ").append(toIndentedString(soldToContact)).append("\n");
    sb.append("    taxInfo: ").append(toIndentedString(taxInfo)).append("\n");
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
    openapiFields.add("accountNumber");
    openapiFields.add("additionalEmailAddresses");
    openapiFields.add("allowInvoiceEdit");
    openapiFields.add("autoPay");
    openapiFields.add("batch");
    openapiFields.add("billCycleDay");
    openapiFields.add("billToContact");
    openapiFields.add("communicationProfileId");
    openapiFields.add("creditCard");
    openapiFields.add("creditMemoTemplateId");
    openapiFields.add("crmId");
    openapiFields.add("currency");
    openapiFields.add("customFields");
    openapiFields.add("customerServiceRepName");
    openapiFields.add("debitMemoTemplateId");
    openapiFields.add("hpmCreditCardPaymentMethodId");
    openapiFields.add("invoiceDeliveryPrefsEmail");
    openapiFields.add("invoiceDeliveryPrefsPrint");
    openapiFields.add("invoiceTemplateId");
    openapiFields.add("name");
    openapiFields.add("notes");
    openapiFields.add("parentId");
    openapiFields.add("paymentGateway");
    openapiFields.add("paymentMethod");
    openapiFields.add("paymentTerm");
    openapiFields.add("purchaseOrderNumber");
    openapiFields.add("salesRep");
    openapiFields.add("soldToContact");
    openapiFields.add("taxInfo");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
    openapiRequiredFields.add("billCycleDay");
    openapiRequiredFields.add("billToContact");
    openapiRequiredFields.add("currency");
    openapiRequiredFields.add("name");
  }

 /**
  * Validates the JSON Object and throws an exception if issues found
  *
  * @param jsonObj JSON Object
  * @throws IOException if the JSON Object is invalid with respect to CreateOrderCreateSubscriptionNewSubscriptionOwnerAccountAllOf
  */
  public static void validateJsonObject(JsonObject jsonObj) throws IOException {
      if (jsonObj == null) {
        if (!CreateOrderCreateSubscriptionNewSubscriptionOwnerAccountAllOf.openapiRequiredFields.isEmpty()) { // has required fields but JSON object is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in CreateOrderCreateSubscriptionNewSubscriptionOwnerAccountAllOf is not found in the empty JSON string", CreateOrderCreateSubscriptionNewSubscriptionOwnerAccountAllOf.openapiRequiredFields.toString()));
        }
      }

      // check to make sure all required properties/fields are present in the JSON string
      for (String requiredField : CreateOrderCreateSubscriptionNewSubscriptionOwnerAccountAllOf.openapiRequiredFields) {
        if (jsonObj.get(requiredField) == null) {
          throw new IllegalArgumentException(String.format("The required field `%s` is not found in the JSON string: %s", requiredField, jsonObj.toString()));
        }
      }
      if ((jsonObj.get("accountNumber") != null && !jsonObj.get("accountNumber").isJsonNull()) && !jsonObj.get("accountNumber").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `accountNumber` to be a primitive type in the JSON string but got `%s`", jsonObj.get("accountNumber").toString()));
      }
      if ((jsonObj.get("additionalEmailAddresses") != null && !jsonObj.get("additionalEmailAddresses").isJsonNull()) && !jsonObj.get("additionalEmailAddresses").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `additionalEmailAddresses` to be a primitive type in the JSON string but got `%s`", jsonObj.get("additionalEmailAddresses").toString()));
      }
      if ((jsonObj.get("batch") != null && !jsonObj.get("batch").isJsonNull()) && !jsonObj.get("batch").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `batch` to be a primitive type in the JSON string but got `%s`", jsonObj.get("batch").toString()));
      }
      // validate the required field `billToContact`
      BillToContactPostOrder.validateJsonObject(jsonObj.getAsJsonObject("billToContact"));
      if ((jsonObj.get("communicationProfileId") != null && !jsonObj.get("communicationProfileId").isJsonNull()) && !jsonObj.get("communicationProfileId").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `communicationProfileId` to be a primitive type in the JSON string but got `%s`", jsonObj.get("communicationProfileId").toString()));
      }
      // validate the optional field `creditCard`
      if (jsonObj.get("creditCard") != null && !jsonObj.get("creditCard").isJsonNull()) {
        CreditCard.validateJsonObject(jsonObj.getAsJsonObject("creditCard"));
      }
      if ((jsonObj.get("creditMemoTemplateId") != null && !jsonObj.get("creditMemoTemplateId").isJsonNull()) && !jsonObj.get("creditMemoTemplateId").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `creditMemoTemplateId` to be a primitive type in the JSON string but got `%s`", jsonObj.get("creditMemoTemplateId").toString()));
      }
      if ((jsonObj.get("crmId") != null && !jsonObj.get("crmId").isJsonNull()) && !jsonObj.get("crmId").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `crmId` to be a primitive type in the JSON string but got `%s`", jsonObj.get("crmId").toString()));
      }
      if (!jsonObj.get("currency").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `currency` to be a primitive type in the JSON string but got `%s`", jsonObj.get("currency").toString()));
      }
      if ((jsonObj.get("customerServiceRepName") != null && !jsonObj.get("customerServiceRepName").isJsonNull()) && !jsonObj.get("customerServiceRepName").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `customerServiceRepName` to be a primitive type in the JSON string but got `%s`", jsonObj.get("customerServiceRepName").toString()));
      }
      if ((jsonObj.get("debitMemoTemplateId") != null && !jsonObj.get("debitMemoTemplateId").isJsonNull()) && !jsonObj.get("debitMemoTemplateId").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `debitMemoTemplateId` to be a primitive type in the JSON string but got `%s`", jsonObj.get("debitMemoTemplateId").toString()));
      }
      if ((jsonObj.get("hpmCreditCardPaymentMethodId") != null && !jsonObj.get("hpmCreditCardPaymentMethodId").isJsonNull()) && !jsonObj.get("hpmCreditCardPaymentMethodId").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `hpmCreditCardPaymentMethodId` to be a primitive type in the JSON string but got `%s`", jsonObj.get("hpmCreditCardPaymentMethodId").toString()));
      }
      if ((jsonObj.get("invoiceTemplateId") != null && !jsonObj.get("invoiceTemplateId").isJsonNull()) && !jsonObj.get("invoiceTemplateId").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `invoiceTemplateId` to be a primitive type in the JSON string but got `%s`", jsonObj.get("invoiceTemplateId").toString()));
      }
      if (!jsonObj.get("name").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `name` to be a primitive type in the JSON string but got `%s`", jsonObj.get("name").toString()));
      }
      if ((jsonObj.get("notes") != null && !jsonObj.get("notes").isJsonNull()) && !jsonObj.get("notes").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `notes` to be a primitive type in the JSON string but got `%s`", jsonObj.get("notes").toString()));
      }
      if ((jsonObj.get("parentId") != null && !jsonObj.get("parentId").isJsonNull()) && !jsonObj.get("parentId").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `parentId` to be a primitive type in the JSON string but got `%s`", jsonObj.get("parentId").toString()));
      }
      if ((jsonObj.get("paymentGateway") != null && !jsonObj.get("paymentGateway").isJsonNull()) && !jsonObj.get("paymentGateway").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `paymentGateway` to be a primitive type in the JSON string but got `%s`", jsonObj.get("paymentGateway").toString()));
      }
      if ((jsonObj.get("paymentTerm") != null && !jsonObj.get("paymentTerm").isJsonNull()) && !jsonObj.get("paymentTerm").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `paymentTerm` to be a primitive type in the JSON string but got `%s`", jsonObj.get("paymentTerm").toString()));
      }
      if ((jsonObj.get("purchaseOrderNumber") != null && !jsonObj.get("purchaseOrderNumber").isJsonNull()) && !jsonObj.get("purchaseOrderNumber").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `purchaseOrderNumber` to be a primitive type in the JSON string but got `%s`", jsonObj.get("purchaseOrderNumber").toString()));
      }
      if ((jsonObj.get("salesRep") != null && !jsonObj.get("salesRep").isJsonNull()) && !jsonObj.get("salesRep").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `salesRep` to be a primitive type in the JSON string but got `%s`", jsonObj.get("salesRep").toString()));
      }
      // validate the optional field `soldToContact`
      if (jsonObj.get("soldToContact") != null && !jsonObj.get("soldToContact").isJsonNull()) {
        SoldToContactPostOrder.validateJsonObject(jsonObj.getAsJsonObject("soldToContact"));
      }
      // validate the optional field `taxInfo`
      if (jsonObj.get("taxInfo") != null && !jsonObj.get("taxInfo").isJsonNull()) {
        TaxInfo.validateJsonObject(jsonObj.getAsJsonObject("taxInfo"));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!CreateOrderCreateSubscriptionNewSubscriptionOwnerAccountAllOf.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'CreateOrderCreateSubscriptionNewSubscriptionOwnerAccountAllOf' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<CreateOrderCreateSubscriptionNewSubscriptionOwnerAccountAllOf> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(CreateOrderCreateSubscriptionNewSubscriptionOwnerAccountAllOf.class));

       return (TypeAdapter<T>) new TypeAdapter<CreateOrderCreateSubscriptionNewSubscriptionOwnerAccountAllOf>() {
           @Override
           public void write(JsonWriter out, CreateOrderCreateSubscriptionNewSubscriptionOwnerAccountAllOf value) throws IOException {
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
           public CreateOrderCreateSubscriptionNewSubscriptionOwnerAccountAllOf read(JsonReader in) throws IOException {
             JsonObject jsonObj = elementAdapter.read(in).getAsJsonObject();
             validateJsonObject(jsonObj);
             // store additional fields in the deserialized instance
             CreateOrderCreateSubscriptionNewSubscriptionOwnerAccountAllOf instance = thisAdapter.fromJsonTree(jsonObj);
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
  * Create an instance of CreateOrderCreateSubscriptionNewSubscriptionOwnerAccountAllOf given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of CreateOrderCreateSubscriptionNewSubscriptionOwnerAccountAllOf
  * @throws IOException if the JSON string is invalid with respect to CreateOrderCreateSubscriptionNewSubscriptionOwnerAccountAllOf
  */
  public static CreateOrderCreateSubscriptionNewSubscriptionOwnerAccountAllOf fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, CreateOrderCreateSubscriptionNewSubscriptionOwnerAccountAllOf.class);
  }

 /**
  * Convert an instance of CreateOrderCreateSubscriptionNewSubscriptionOwnerAccountAllOf to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

