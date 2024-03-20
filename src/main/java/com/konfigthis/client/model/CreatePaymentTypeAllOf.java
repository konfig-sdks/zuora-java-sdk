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
import com.konfigthis.client.model.CreatePaymentTypeAllOfFinanceInformation;
import com.konfigthis.client.model.CreatePaymentTypeAllOfGatewayOptions;
import com.konfigthis.client.model.PaymentDebitMemoApplicationCreateRequestType;
import com.konfigthis.client.model.PaymentInvoiceApplicationCreateRequestType;
import com.konfigthis.client.model.PaymentSchedulePaymentOptionFields;
import com.konfigthis.client.model.PaymentWithCustomRatesType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
 * CreatePaymentTypeAllOf
 */@javax.annotation.Generated(value = "Generated by https://konfigthis.com")
public class CreatePaymentTypeAllOf {
  public static final String SERIALIZED_NAME_ACCOUNT_ID = "accountId";
  @SerializedName(SERIALIZED_NAME_ACCOUNT_ID)
  private String accountId;

  public static final String SERIALIZED_NAME_ACCOUNT_NUMBER = "accountNumber";
  @SerializedName(SERIALIZED_NAME_ACCOUNT_NUMBER)
  private String accountNumber;

  public static final String SERIALIZED_NAME_AMOUNT = "amount";
  @SerializedName(SERIALIZED_NAME_AMOUNT)
  private Double amount;

  public static final String SERIALIZED_NAME_AUTH_TRANSACTION_ID = "authTransactionId";
  @SerializedName(SERIALIZED_NAME_AUTH_TRANSACTION_ID)
  private String authTransactionId;

  public static final String SERIALIZED_NAME_COMMENT = "comment";
  @SerializedName(SERIALIZED_NAME_COMMENT)
  private String comment;

  public static final String SERIALIZED_NAME_CURRENCY = "currency";
  @SerializedName(SERIALIZED_NAME_CURRENCY)
  private String currency;

  public static final String SERIALIZED_NAME_CUSTOM_RATES = "customRates";
  @SerializedName(SERIALIZED_NAME_CUSTOM_RATES)
  private List<PaymentWithCustomRatesType> customRates = null;

  public static final String SERIALIZED_NAME_DEBIT_MEMOS = "debitMemos";
  @SerializedName(SERIALIZED_NAME_DEBIT_MEMOS)
  private List<PaymentDebitMemoApplicationCreateRequestType> debitMemos = null;

  public static final String SERIALIZED_NAME_EFFECTIVE_DATE = "effectiveDate";
  @SerializedName(SERIALIZED_NAME_EFFECTIVE_DATE)
  private LocalDate effectiveDate;

  public static final String SERIALIZED_NAME_FINANCE_INFORMATION = "financeInformation";
  @SerializedName(SERIALIZED_NAME_FINANCE_INFORMATION)
  private CreatePaymentTypeAllOfFinanceInformation financeInformation;

  public static final String SERIALIZED_NAME_GATEWAY_ID = "gatewayId";
  @SerializedName(SERIALIZED_NAME_GATEWAY_ID)
  private String gatewayId;

  public static final String SERIALIZED_NAME_GATEWAY_OPTIONS = "gatewayOptions";
  @SerializedName(SERIALIZED_NAME_GATEWAY_OPTIONS)
  private CreatePaymentTypeAllOfGatewayOptions gatewayOptions;

  public static final String SERIALIZED_NAME_GATEWAY_ORDER_ID = "gatewayOrderId";
  @SerializedName(SERIALIZED_NAME_GATEWAY_ORDER_ID)
  private String gatewayOrderId;

  public static final String SERIALIZED_NAME_INVOICES = "invoices";
  @SerializedName(SERIALIZED_NAME_INVOICES)
  private List<PaymentInvoiceApplicationCreateRequestType> invoices = null;

  /**
   * Payment transaction source used to differentiate the transaction source in Stored Credential Transaction framework.   - &#x60;C_Unscheduled&#x60;: Cardholder-initiated transaction (CIT) that does not occur on scheduled or regularly occurring dates.   - &#x60;M_Recurring&#x60;: Merchant-initiated transaction (MIT) that occurs at regular intervals.   - &#x60;M_Unscheduled&#x60;: Merchant-initiated transaction (MIT) that does not occur on scheduled or regularly occurring dates.   - &#x60;M_MOTO&#x60;: Mail Order Telephone Order (MOTO) payment transaction. This option is only available for credit card payments on Stripe v2. See [Overview of Stripe payment gateway integration](https://knowledgecenter.zuora.com/Zuora_Collect/Payment_gateway_integrations/Supported_payment_gateways/Stripe_Payment_Gateway/A_Overview_of_Stripe_payment_gateway_integration) for more information. 
   */
  @JsonAdapter(MitTransactionSourceEnum.Adapter.class)
 public enum MitTransactionSourceEnum {
    C_UNSCHEDULED("C_Unscheduled"),
    
    M_RECURRING("M_Recurring"),
    
    M_UNSCHEDULED("M_Unscheduled"),
    
    M_MOTO("M_MOTO");

    private String value;

    MitTransactionSourceEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static MitTransactionSourceEnum fromValue(String value) {
      for (MitTransactionSourceEnum b : MitTransactionSourceEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<MitTransactionSourceEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final MitTransactionSourceEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public MitTransactionSourceEnum read(final JsonReader jsonReader) throws IOException {
        String value =  jsonReader.nextString();
        return MitTransactionSourceEnum.fromValue(value);
      }
    }
  }

  public static final String SERIALIZED_NAME_MIT_TRANSACTION_SOURCE = "mitTransactionSource";
  @SerializedName(SERIALIZED_NAME_MIT_TRANSACTION_SOURCE)
  private MitTransactionSourceEnum mitTransactionSource;

  public static final String SERIALIZED_NAME_PAYMENT_GATEWAY_NUMBER = "paymentGatewayNumber";
  @SerializedName(SERIALIZED_NAME_PAYMENT_GATEWAY_NUMBER)
  private String paymentGatewayNumber;

  public static final String SERIALIZED_NAME_PAYMENT_METHOD_ID = "paymentMethodId";
  @SerializedName(SERIALIZED_NAME_PAYMENT_METHOD_ID)
  private String paymentMethodId;

  public static final String SERIALIZED_NAME_PAYMENT_METHOD_TYPE = "paymentMethodType";
  @SerializedName(SERIALIZED_NAME_PAYMENT_METHOD_TYPE)
  private String paymentMethodType;

  public static final String SERIALIZED_NAME_PAYMENT_OPTION = "paymentOption";
  @SerializedName(SERIALIZED_NAME_PAYMENT_OPTION)
  private List<PaymentSchedulePaymentOptionFields> paymentOption = null;

  public static final String SERIALIZED_NAME_PAYMENT_SCHEDULE_KEY = "paymentScheduleKey";
  @SerializedName(SERIALIZED_NAME_PAYMENT_SCHEDULE_KEY)
  private String paymentScheduleKey;

  public static final String SERIALIZED_NAME_PREPAYMENT = "prepayment";
  @SerializedName(SERIALIZED_NAME_PREPAYMENT)
  private Boolean prepayment;

  public static final String SERIALIZED_NAME_REFERENCE_ID = "referenceId";
  @SerializedName(SERIALIZED_NAME_REFERENCE_ID)
  private String referenceId;

  public static final String SERIALIZED_NAME_SOFT_DESCRIPTOR = "softDescriptor";
  @SerializedName(SERIALIZED_NAME_SOFT_DESCRIPTOR)
  private String softDescriptor;

  public static final String SERIALIZED_NAME_SOFT_DESCRIPTOR_PHONE = "softDescriptorPhone";
  @SerializedName(SERIALIZED_NAME_SOFT_DESCRIPTOR_PHONE)
  private String softDescriptorPhone;

  public static final String SERIALIZED_NAME_STANDALONE = "standalone";
  @SerializedName(SERIALIZED_NAME_STANDALONE)
  private Boolean standalone = false;

  /**
   * The type of the payment.  **Note**:  If you specify the type as &#x60;Electronic&#x60;, you must specify the value for &#x60;accountId&#x60; or &#x60;accountNumber&#x60;. 
   */
  @JsonAdapter(TypeEnum.Adapter.class)
 public enum TypeEnum {
    EXTERNAL("External"),
    
    ELECTRONIC("Electronic");

    private String value;

    TypeEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static TypeEnum fromValue(String value) {
      for (TypeEnum b : TypeEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<TypeEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final TypeEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public TypeEnum read(final JsonReader jsonReader) throws IOException {
        String value =  jsonReader.nextString();
        return TypeEnum.fromValue(value);
      }
    }
  }

  public static final String SERIALIZED_NAME_TYPE = "type";
  @SerializedName(SERIALIZED_NAME_TYPE)
  private TypeEnum type;

  public CreatePaymentTypeAllOf() {
  }

  public CreatePaymentTypeAllOf accountId(String accountId) {
    
    
    
    
    this.accountId = accountId;
    return this;
  }

   /**
   * The ID of the customer account that the payment is created for. 
   * @return accountId
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The ID of the customer account that the payment is created for. ")

  public String getAccountId() {
    return accountId;
  }


  public void setAccountId(String accountId) {
    
    
    
    this.accountId = accountId;
  }


  public CreatePaymentTypeAllOf accountNumber(String accountNumber) {
    
    
    
    
    this.accountNumber = accountNumber;
    return this;
  }

   /**
   * The number of the customer account that the payment is created for, such as &#x60;A00000001&#x60;.  You can specify either &#x60;accountNumber&#x60; or &#x60;accountId&#x60; for a customer account. If both of them are specified, they must refer to the same customer account. 
   * @return accountNumber
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The number of the customer account that the payment is created for, such as `A00000001`.  You can specify either `accountNumber` or `accountId` for a customer account. If both of them are specified, they must refer to the same customer account. ")

  public String getAccountNumber() {
    return accountNumber;
  }


  public void setAccountNumber(String accountNumber) {
    
    
    
    this.accountNumber = accountNumber;
  }


  public CreatePaymentTypeAllOf amount(Double amount) {
    
    
    
    
    this.amount = amount;
    return this;
  }

   /**
   * The total amount of the payment. 
   * @return amount
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "The total amount of the payment. ")

  public Double getAmount() {
    return amount;
  }


  public void setAmount(Double amount) {
    
    
    
    this.amount = amount;
  }


  public CreatePaymentTypeAllOf authTransactionId(String authTransactionId) {
    
    
    
    
    this.authTransactionId = authTransactionId;
    return this;
  }

   /**
   * The authorization transaction ID from the payment gateway. Use this field for electronic payments, such as credit cards.  When you create a payment for capturing the authorized funds, it is highly recommended to pass in the gatewayOrderId that you used when authorizing the funds by using the [Create authorization](https://www.zuora.com/developer/api-references/api/operation/POST_CreateAuthorization) operation, together with the &#x60;authTransactionId&#x60; field.  The following payment gateways support this field:   - Adyen Integration v2.0   - CyberSource 1.28   - CyberSource 1.97   - CyberSource 2.0   - Chase Paymentech Orbital   - Ingenico ePayments   - SlimPay   - Stripe v2   - Verifi Global Payment Gateway   - WePay Payment Gateway Integration 
   * @return authTransactionId
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The authorization transaction ID from the payment gateway. Use this field for electronic payments, such as credit cards.  When you create a payment for capturing the authorized funds, it is highly recommended to pass in the gatewayOrderId that you used when authorizing the funds by using the [Create authorization](https://www.zuora.com/developer/api-references/api/operation/POST_CreateAuthorization) operation, together with the `authTransactionId` field.  The following payment gateways support this field:   - Adyen Integration v2.0   - CyberSource 1.28   - CyberSource 1.97   - CyberSource 2.0   - Chase Paymentech Orbital   - Ingenico ePayments   - SlimPay   - Stripe v2   - Verifi Global Payment Gateway   - WePay Payment Gateway Integration ")

  public String getAuthTransactionId() {
    return authTransactionId;
  }


  public void setAuthTransactionId(String authTransactionId) {
    
    
    
    this.authTransactionId = authTransactionId;
  }


  public CreatePaymentTypeAllOf comment(String comment) {
    
    
    if (comment != null && comment.length() < 0) {
      throw new IllegalArgumentException("Invalid value for comment. Length must be greater than or equal to 0.");
    }
    
    this.comment = comment;
    return this;
  }

   /**
   * Additional information related to the payment. 
   * @return comment
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Additional information related to the payment. ")

  public String getComment() {
    return comment;
  }


  public void setComment(String comment) {
    
    
    if (comment != null && comment.length() < 0) {
      throw new IllegalArgumentException("Invalid value for comment. Length must be greater than or equal to 0.");
    }
    this.comment = comment;
  }


  public CreatePaymentTypeAllOf currency(String currency) {
    
    
    
    
    this.currency = currency;
    return this;
  }

   /**
   * When Standalone Payment is not enabled, the &#x60;currency&#x60; of the payment must be the same as the payment currency defined in the customer account settings through Zuora UI. But if you have the [Multiple Currencies](https://knowledgecenter.zuora.com/Zuora_Billing/Bill_your_customers/Flexible_Billing/Multiple_Currencies) feature enabled, you can have a different payment currency.  When Standalone Payment is enabled and &#x60;standalone&#x60; is &#x60;true&#x60;, the &#x60;currency&#x60; of the standalone payment can be different from the payment currency defined in the customer account settings. The amount will not be summed up to the account balance or key metrics regardless of currency. 
   * @return currency
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "When Standalone Payment is not enabled, the `currency` of the payment must be the same as the payment currency defined in the customer account settings through Zuora UI. But if you have the [Multiple Currencies](https://knowledgecenter.zuora.com/Zuora_Billing/Bill_your_customers/Flexible_Billing/Multiple_Currencies) feature enabled, you can have a different payment currency.  When Standalone Payment is enabled and `standalone` is `true`, the `currency` of the standalone payment can be different from the payment currency defined in the customer account settings. The amount will not be summed up to the account balance or key metrics regardless of currency. ")

  public String getCurrency() {
    return currency;
  }


  public void setCurrency(String currency) {
    
    
    
    this.currency = currency;
  }


  public CreatePaymentTypeAllOf customRates(List<PaymentWithCustomRatesType> customRates) {
    
    
    
    
    this.customRates = customRates;
    return this;
  }

  public CreatePaymentTypeAllOf addCustomRatesItem(PaymentWithCustomRatesType customRatesItem) {
    if (this.customRates == null) {
      this.customRates = new ArrayList<>();
    }
    this.customRates.add(customRatesItem);
    return this;
  }

   /**
   * It contains Home currency and Reporting currency custom rates currencies. The maximum number of items is 2 (you can pass the Home currency item or Reporting currency item or both).  **Note**: The API custom rate feature is permission controlled. 
   * @return customRates
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "It contains Home currency and Reporting currency custom rates currencies. The maximum number of items is 2 (you can pass the Home currency item or Reporting currency item or both).  **Note**: The API custom rate feature is permission controlled. ")

  public List<PaymentWithCustomRatesType> getCustomRates() {
    return customRates;
  }


  public void setCustomRates(List<PaymentWithCustomRatesType> customRates) {
    
    
    
    this.customRates = customRates;
  }


  public CreatePaymentTypeAllOf debitMemos(List<PaymentDebitMemoApplicationCreateRequestType> debitMemos) {
    
    
    
    
    this.debitMemos = debitMemos;
    return this;
  }

  public CreatePaymentTypeAllOf addDebitMemosItem(PaymentDebitMemoApplicationCreateRequestType debitMemosItem) {
    if (this.debitMemos == null) {
      this.debitMemos = new ArrayList<>();
    }
    this.debitMemos.add(debitMemosItem);
    return this;
  }

   /**
   * Container for debit memos. The maximum number of debit memos is 1,000. 
   * @return debitMemos
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Container for debit memos. The maximum number of debit memos is 1,000. ")

  public List<PaymentDebitMemoApplicationCreateRequestType> getDebitMemos() {
    return debitMemos;
  }


  public void setDebitMemos(List<PaymentDebitMemoApplicationCreateRequestType> debitMemos) {
    
    
    
    this.debitMemos = debitMemos;
  }


  public CreatePaymentTypeAllOf effectiveDate(LocalDate effectiveDate) {
    
    
    
    
    this.effectiveDate = effectiveDate;
    return this;
  }

   /**
   * The date when the payment takes effect, in &#x60;yyyy-mm-dd&#x60; format.  **Note:**   - This field is required for only electronic payments. It&#39;s an optional field for external payments.   - When specified, this field must be set to the date of today.   - When applying or transferring payments, this field must be later than or equal to the maximum effective date of the payment. 
   * @return effectiveDate
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The date when the payment takes effect, in `yyyy-mm-dd` format.  **Note:**   - This field is required for only electronic payments. It's an optional field for external payments.   - When specified, this field must be set to the date of today.   - When applying or transferring payments, this field must be later than or equal to the maximum effective date of the payment. ")

  public LocalDate getEffectiveDate() {
    return effectiveDate;
  }


  public void setEffectiveDate(LocalDate effectiveDate) {
    
    
    
    this.effectiveDate = effectiveDate;
  }


  public CreatePaymentTypeAllOf financeInformation(CreatePaymentTypeAllOfFinanceInformation financeInformation) {
    
    
    
    
    this.financeInformation = financeInformation;
    return this;
  }

   /**
   * Get financeInformation
   * @return financeInformation
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public CreatePaymentTypeAllOfFinanceInformation getFinanceInformation() {
    return financeInformation;
  }


  public void setFinanceInformation(CreatePaymentTypeAllOfFinanceInformation financeInformation) {
    
    
    
    this.financeInformation = financeInformation;
  }


  public CreatePaymentTypeAllOf gatewayId(String gatewayId) {
    
    
    
    
    this.gatewayId = gatewayId;
    return this;
  }

   /**
   * The ID of the gateway instance that processes the payment. The ID must be a valid gateway instance ID and this gateway must support the specific payment method.  - If &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Payments/Payment_gateway_integrations/Payment_Gateway_Routing\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Payment Gateway Routing&lt;/a&gt; is enabled, when creating electronic payments, this field is optional.      - If this field is not specified, gateway routing rules will be invoked.     - If this field is specified, the specified gateway will be used to process the payment.  - If Payment Gateway Routing is disabled, when creating electronic payments, this field is required.  - When creating external payments, this field is optional.  Use the same gateway instance if both &#x60;paymentGatewayNumber&#x60; and &#x60;gatewayId&#x60; are sent in the request. 
   * @return gatewayId
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The ID of the gateway instance that processes the payment. The ID must be a valid gateway instance ID and this gateway must support the specific payment method.  - If <a href=\"https://knowledgecenter.zuora.com/Zuora_Payments/Payment_gateway_integrations/Payment_Gateway_Routing\" target=\"_blank\">Payment Gateway Routing</a> is enabled, when creating electronic payments, this field is optional.      - If this field is not specified, gateway routing rules will be invoked.     - If this field is specified, the specified gateway will be used to process the payment.  - If Payment Gateway Routing is disabled, when creating electronic payments, this field is required.  - When creating external payments, this field is optional.  Use the same gateway instance if both `paymentGatewayNumber` and `gatewayId` are sent in the request. ")

  public String getGatewayId() {
    return gatewayId;
  }


  public void setGatewayId(String gatewayId) {
    
    
    
    this.gatewayId = gatewayId;
  }


  public CreatePaymentTypeAllOf gatewayOptions(CreatePaymentTypeAllOfGatewayOptions gatewayOptions) {
    
    
    
    
    this.gatewayOptions = gatewayOptions;
    return this;
  }

   /**
   * Get gatewayOptions
   * @return gatewayOptions
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public CreatePaymentTypeAllOfGatewayOptions getGatewayOptions() {
    return gatewayOptions;
  }


  public void setGatewayOptions(CreatePaymentTypeAllOfGatewayOptions gatewayOptions) {
    
    
    
    this.gatewayOptions = gatewayOptions;
  }


  public CreatePaymentTypeAllOf gatewayOrderId(String gatewayOrderId) {
    
    
    
    
    this.gatewayOrderId = gatewayOrderId;
    return this;
  }

   /**
   * A merchant-specified natural key value that can be passed to the electronic payment gateway when a payment is created. If not specified, the payment number will be passed in instead.  Gateways check duplicates on the gateway order ID to ensure that the merchant do not accidentally enter the same transaction twice. This ID can also be used to do reconciliation and tie the payment to a natural key in external systems. The source of this ID varies by merchant. Some merchants use their shopping cart order IDs, and others use something different. Merchants use this ID to track transactions in their eCommerce systems.  When you create a payment for capturing the authorized funds, it is highly recommended to pass in the gatewayOrderId that you used when authorizing the funds by using the [Create authorization](https://www.zuora.com/developer/api-references/api/operation/POST_CreateAuthorization) operation, together with the &#x60;authTransactionId&#x60; field. 
   * @return gatewayOrderId
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "A merchant-specified natural key value that can be passed to the electronic payment gateway when a payment is created. If not specified, the payment number will be passed in instead.  Gateways check duplicates on the gateway order ID to ensure that the merchant do not accidentally enter the same transaction twice. This ID can also be used to do reconciliation and tie the payment to a natural key in external systems. The source of this ID varies by merchant. Some merchants use their shopping cart order IDs, and others use something different. Merchants use this ID to track transactions in their eCommerce systems.  When you create a payment for capturing the authorized funds, it is highly recommended to pass in the gatewayOrderId that you used when authorizing the funds by using the [Create authorization](https://www.zuora.com/developer/api-references/api/operation/POST_CreateAuthorization) operation, together with the `authTransactionId` field. ")

  public String getGatewayOrderId() {
    return gatewayOrderId;
  }


  public void setGatewayOrderId(String gatewayOrderId) {
    
    
    
    this.gatewayOrderId = gatewayOrderId;
  }


  public CreatePaymentTypeAllOf invoices(List<PaymentInvoiceApplicationCreateRequestType> invoices) {
    
    
    
    
    this.invoices = invoices;
    return this;
  }

  public CreatePaymentTypeAllOf addInvoicesItem(PaymentInvoiceApplicationCreateRequestType invoicesItem) {
    if (this.invoices == null) {
      this.invoices = new ArrayList<>();
    }
    this.invoices.add(invoicesItem);
    return this;
  }

   /**
   * Container for invoices. The maximum number of invoices is 1,000. 
   * @return invoices
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Container for invoices. The maximum number of invoices is 1,000. ")

  public List<PaymentInvoiceApplicationCreateRequestType> getInvoices() {
    return invoices;
  }


  public void setInvoices(List<PaymentInvoiceApplicationCreateRequestType> invoices) {
    
    
    
    this.invoices = invoices;
  }


  public CreatePaymentTypeAllOf mitTransactionSource(MitTransactionSourceEnum mitTransactionSource) {
    
    
    
    
    this.mitTransactionSource = mitTransactionSource;
    return this;
  }

   /**
   * Payment transaction source used to differentiate the transaction source in Stored Credential Transaction framework.   - &#x60;C_Unscheduled&#x60;: Cardholder-initiated transaction (CIT) that does not occur on scheduled or regularly occurring dates.   - &#x60;M_Recurring&#x60;: Merchant-initiated transaction (MIT) that occurs at regular intervals.   - &#x60;M_Unscheduled&#x60;: Merchant-initiated transaction (MIT) that does not occur on scheduled or regularly occurring dates.   - &#x60;M_MOTO&#x60;: Mail Order Telephone Order (MOTO) payment transaction. This option is only available for credit card payments on Stripe v2. See [Overview of Stripe payment gateway integration](https://knowledgecenter.zuora.com/Zuora_Collect/Payment_gateway_integrations/Supported_payment_gateways/Stripe_Payment_Gateway/A_Overview_of_Stripe_payment_gateway_integration) for more information. 
   * @return mitTransactionSource
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Payment transaction source used to differentiate the transaction source in Stored Credential Transaction framework.   - `C_Unscheduled`: Cardholder-initiated transaction (CIT) that does not occur on scheduled or regularly occurring dates.   - `M_Recurring`: Merchant-initiated transaction (MIT) that occurs at regular intervals.   - `M_Unscheduled`: Merchant-initiated transaction (MIT) that does not occur on scheduled or regularly occurring dates.   - `M_MOTO`: Mail Order Telephone Order (MOTO) payment transaction. This option is only available for credit card payments on Stripe v2. See [Overview of Stripe payment gateway integration](https://knowledgecenter.zuora.com/Zuora_Collect/Payment_gateway_integrations/Supported_payment_gateways/Stripe_Payment_Gateway/A_Overview_of_Stripe_payment_gateway_integration) for more information. ")

  public MitTransactionSourceEnum getMitTransactionSource() {
    return mitTransactionSource;
  }


  public void setMitTransactionSource(MitTransactionSourceEnum mitTransactionSource) {
    
    
    
    this.mitTransactionSource = mitTransactionSource;
  }


  public CreatePaymentTypeAllOf paymentGatewayNumber(String paymentGatewayNumber) {
    
    
    
    
    this.paymentGatewayNumber = paymentGatewayNumber;
    return this;
  }

   /**
   * The natural key for the payment gateway.   Use the same gateway instance if both &#x60;paymentGatewayNumber&#x60; and &#x60;gatewayId&#x60; are sent in the request. 
   * @return paymentGatewayNumber
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The natural key for the payment gateway.   Use the same gateway instance if both `paymentGatewayNumber` and `gatewayId` are sent in the request. ")

  public String getPaymentGatewayNumber() {
    return paymentGatewayNumber;
  }


  public void setPaymentGatewayNumber(String paymentGatewayNumber) {
    
    
    
    this.paymentGatewayNumber = paymentGatewayNumber;
  }


  public CreatePaymentTypeAllOf paymentMethodId(String paymentMethodId) {
    
    
    
    
    this.paymentMethodId = paymentMethodId;
    return this;
  }

   /**
   * The unique ID of the payment method that the customer used to make the payment.   If no payment method ID is specified in the request body, the default payment method for the customer account is used automatically. If the default payment method is different from the type of payments that you want to create, an error occurs. 
   * @return paymentMethodId
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The unique ID of the payment method that the customer used to make the payment.   If no payment method ID is specified in the request body, the default payment method for the customer account is used automatically. If the default payment method is different from the type of payments that you want to create, an error occurs. ")

  public String getPaymentMethodId() {
    return paymentMethodId;
  }


  public void setPaymentMethodId(String paymentMethodId) {
    
    
    
    this.paymentMethodId = paymentMethodId;
  }


  public CreatePaymentTypeAllOf paymentMethodType(String paymentMethodType) {
    
    
    
    
    this.paymentMethodType = paymentMethodType;
    return this;
  }

   /**
   * The type of the payment method that the customer used to make the payment.   Specify this value when you are creating an external payment method. If both &#x60;paymentMethodType&#x60; and &#x60;paymentMethodId&#x60; are specified, only the &#x60;paymentMethodId&#x60; value is used to create the payment. 
   * @return paymentMethodType
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The type of the payment method that the customer used to make the payment.   Specify this value when you are creating an external payment method. If both `paymentMethodType` and `paymentMethodId` are specified, only the `paymentMethodId` value is used to create the payment. ")

  public String getPaymentMethodType() {
    return paymentMethodType;
  }


  public void setPaymentMethodType(String paymentMethodType) {
    
    
    
    this.paymentMethodType = paymentMethodType;
  }


  public CreatePaymentTypeAllOf paymentOption(List<PaymentSchedulePaymentOptionFields> paymentOption) {
    
    
    
    
    this.paymentOption = paymentOption;
    return this;
  }

  public CreatePaymentTypeAllOf addPaymentOptionItem(PaymentSchedulePaymentOptionFields paymentOptionItem) {
    if (this.paymentOption == null) {
      this.paymentOption = new ArrayList<>();
    }
    this.paymentOption.add(paymentOptionItem);
    return this;
  }

   /**
   * Container for the paymentOption items, which describe the transactional level rules for processing payments. Currently, only the Gateway Options type is supported.  Here is an example: &#x60;&#x60;&#x60; \&quot;paymentOption\&quot;: [   {     \&quot;type\&quot;: \&quot;GatewayOptions\&quot;,     \&quot;detail\&quot;: {       \&quot;SecCode\&quot;:\&quot;WEB\&quot;     }   } ] &#x60;&#x60;&#x60;  &#x60;paymentOption&#x60; of the payment schedule takes precedence over &#x60;paymentOption&#x60; of the payment schedule item.  You can use this field or the &#x60;gatewayOptions&#x60; field to pass the Gateway Options fields supported by a payment gateway. However, the Gateway Options fields passed through the &#x60;paymentOption&#x60; field will be stored in the Payment Option object and can be easily retrieved. 
   * @return paymentOption
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Container for the paymentOption items, which describe the transactional level rules for processing payments. Currently, only the Gateway Options type is supported.  Here is an example: ``` \"paymentOption\": [   {     \"type\": \"GatewayOptions\",     \"detail\": {       \"SecCode\":\"WEB\"     }   } ] ```  `paymentOption` of the payment schedule takes precedence over `paymentOption` of the payment schedule item.  You can use this field or the `gatewayOptions` field to pass the Gateway Options fields supported by a payment gateway. However, the Gateway Options fields passed through the `paymentOption` field will be stored in the Payment Option object and can be easily retrieved. ")

  public List<PaymentSchedulePaymentOptionFields> getPaymentOption() {
    return paymentOption;
  }


  public void setPaymentOption(List<PaymentSchedulePaymentOptionFields> paymentOption) {
    
    
    
    this.paymentOption = paymentOption;
  }


  public CreatePaymentTypeAllOf paymentScheduleKey(String paymentScheduleKey) {
    
    
    
    
    this.paymentScheduleKey = paymentScheduleKey;
    return this;
  }

   /**
   * The unique ID or the number of the payment schedule to be linked with the payment. See [Link payments to payment schedules](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/Payment_Schedules/Link_payments_with_payment_schedules) for more information.
   * @return paymentScheduleKey
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The unique ID or the number of the payment schedule to be linked with the payment. See [Link payments to payment schedules](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/Payment_Schedules/Link_payments_with_payment_schedules) for more information.")

  public String getPaymentScheduleKey() {
    return paymentScheduleKey;
  }


  public void setPaymentScheduleKey(String paymentScheduleKey) {
    
    
    
    this.paymentScheduleKey = paymentScheduleKey;
  }


  public CreatePaymentTypeAllOf prepayment(Boolean prepayment) {
    
    
    
    
    this.prepayment = prepayment;
    return this;
  }

   /**
   * Indicates whether the payment will be used as a reserved payment. See [Prepaid Cash with Drawdown](https://knowledgecenter.zuora.com/Zuora_Billing/Billing_and_Invoicing/JA_Advanced_Consumption_Billing/Prepaid_Cash_with_Drawdown) for more information. 
   * @return prepayment
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Indicates whether the payment will be used as a reserved payment. See [Prepaid Cash with Drawdown](https://knowledgecenter.zuora.com/Zuora_Billing/Billing_and_Invoicing/JA_Advanced_Consumption_Billing/Prepaid_Cash_with_Drawdown) for more information. ")

  public Boolean getPrepayment() {
    return prepayment;
  }


  public void setPrepayment(Boolean prepayment) {
    
    
    
    this.prepayment = prepayment;
  }


  public CreatePaymentTypeAllOf referenceId(String referenceId) {
    
    
    if (referenceId != null && referenceId.length() < 0) {
      throw new IllegalArgumentException("Invalid value for referenceId. Length must be greater than or equal to 0.");
    }
    
    this.referenceId = referenceId;
    return this;
  }

   /**
   * The transaction ID returned by the payment gateway. Use this field to reconcile payments between your gateway and Zuora Payments. 
   * @return referenceId
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The transaction ID returned by the payment gateway. Use this field to reconcile payments between your gateway and Zuora Payments. ")

  public String getReferenceId() {
    return referenceId;
  }


  public void setReferenceId(String referenceId) {
    
    
    if (referenceId != null && referenceId.length() < 0) {
      throw new IllegalArgumentException("Invalid value for referenceId. Length must be greater than or equal to 0.");
    }
    this.referenceId = referenceId;
  }


  public CreatePaymentTypeAllOf softDescriptor(String softDescriptor) {
    
    
    
    
    this.softDescriptor = softDescriptor;
    return this;
  }

   /**
   * A payment gateway-specific field that maps to Zuora for the gateways, Orbital, Vantiv and Verifi.
   * @return softDescriptor
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "A payment gateway-specific field that maps to Zuora for the gateways, Orbital, Vantiv and Verifi.")

  public String getSoftDescriptor() {
    return softDescriptor;
  }


  public void setSoftDescriptor(String softDescriptor) {
    
    
    
    this.softDescriptor = softDescriptor;
  }


  public CreatePaymentTypeAllOf softDescriptorPhone(String softDescriptorPhone) {
    
    
    
    
    this.softDescriptorPhone = softDescriptorPhone;
    return this;
  }

   /**
   * A payment gateway-specific field that maps to Zuora for the gateways, Orbital, Vantiv and Verifi.
   * @return softDescriptorPhone
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "A payment gateway-specific field that maps to Zuora for the gateways, Orbital, Vantiv and Verifi.")

  public String getSoftDescriptorPhone() {
    return softDescriptorPhone;
  }


  public void setSoftDescriptorPhone(String softDescriptorPhone) {
    
    
    
    this.softDescriptorPhone = softDescriptorPhone;
  }


  public CreatePaymentTypeAllOf standalone(Boolean standalone) {
    
    
    
    
    this.standalone = standalone;
    return this;
  }

   /**
   * This field is only available if support for standalone payments is enabled.  Specify &#x60;true&#x60; to create a standalone payment that will be processed in Zuora through Zuora gateway integration but will be settled outside of Zuora.  When &#x60;standalone&#x60; is set to &#x60;true&#x60;:   - &#x60;accountId&#x60;, &#x60;amount&#x60;, &#x60;currency&#x60;, and &#x60;type&#x60; are required.    - &#x60;type&#x60; must be &#x60;Electronic&#x60;.   - &#x60;currency&#x60; of the payment can be different from the payment currency in the customer account settings.   - The amount will not be summed up into the account balance and key metrics regardless of the payment currency.   - No settlement data will be created.   - Either the applied amount or the unapplied amount of the payment is zero.   - The standalone payment cannot be applied, unapplied, or transferred.  Specify &#x60;false&#x60; to create an ordinary payment that will be created, processed, and settled in Zuora. The &#x60;currency&#x60; of an ordinary payment must be the same as the currency in the customer account settings. 
   * @return standalone
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "false", value = "This field is only available if support for standalone payments is enabled.  Specify `true` to create a standalone payment that will be processed in Zuora through Zuora gateway integration but will be settled outside of Zuora.  When `standalone` is set to `true`:   - `accountId`, `amount`, `currency`, and `type` are required.    - `type` must be `Electronic`.   - `currency` of the payment can be different from the payment currency in the customer account settings.   - The amount will not be summed up into the account balance and key metrics regardless of the payment currency.   - No settlement data will be created.   - Either the applied amount or the unapplied amount of the payment is zero.   - The standalone payment cannot be applied, unapplied, or transferred.  Specify `false` to create an ordinary payment that will be created, processed, and settled in Zuora. The `currency` of an ordinary payment must be the same as the currency in the customer account settings. ")

  public Boolean getStandalone() {
    return standalone;
  }


  public void setStandalone(Boolean standalone) {
    
    
    
    this.standalone = standalone;
  }


  public CreatePaymentTypeAllOf type(TypeEnum type) {
    
    
    
    
    this.type = type;
    return this;
  }

   /**
   * The type of the payment.  **Note**:  If you specify the type as &#x60;Electronic&#x60;, you must specify the value for &#x60;accountId&#x60; or &#x60;accountNumber&#x60;. 
   * @return type
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "The type of the payment.  **Note**:  If you specify the type as `Electronic`, you must specify the value for `accountId` or `accountNumber`. ")

  public TypeEnum getType() {
    return type;
  }


  public void setType(TypeEnum type) {
    
    
    
    this.type = type;
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
   * @return the CreatePaymentTypeAllOf instance itself
   */
  public CreatePaymentTypeAllOf putAdditionalProperty(String key, Object value) {
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
    CreatePaymentTypeAllOf createPaymentTypeAllOf = (CreatePaymentTypeAllOf) o;
    return Objects.equals(this.accountId, createPaymentTypeAllOf.accountId) &&
        Objects.equals(this.accountNumber, createPaymentTypeAllOf.accountNumber) &&
        Objects.equals(this.amount, createPaymentTypeAllOf.amount) &&
        Objects.equals(this.authTransactionId, createPaymentTypeAllOf.authTransactionId) &&
        Objects.equals(this.comment, createPaymentTypeAllOf.comment) &&
        Objects.equals(this.currency, createPaymentTypeAllOf.currency) &&
        Objects.equals(this.customRates, createPaymentTypeAllOf.customRates) &&
        Objects.equals(this.debitMemos, createPaymentTypeAllOf.debitMemos) &&
        Objects.equals(this.effectiveDate, createPaymentTypeAllOf.effectiveDate) &&
        Objects.equals(this.financeInformation, createPaymentTypeAllOf.financeInformation) &&
        Objects.equals(this.gatewayId, createPaymentTypeAllOf.gatewayId) &&
        Objects.equals(this.gatewayOptions, createPaymentTypeAllOf.gatewayOptions) &&
        Objects.equals(this.gatewayOrderId, createPaymentTypeAllOf.gatewayOrderId) &&
        Objects.equals(this.invoices, createPaymentTypeAllOf.invoices) &&
        Objects.equals(this.mitTransactionSource, createPaymentTypeAllOf.mitTransactionSource) &&
        Objects.equals(this.paymentGatewayNumber, createPaymentTypeAllOf.paymentGatewayNumber) &&
        Objects.equals(this.paymentMethodId, createPaymentTypeAllOf.paymentMethodId) &&
        Objects.equals(this.paymentMethodType, createPaymentTypeAllOf.paymentMethodType) &&
        Objects.equals(this.paymentOption, createPaymentTypeAllOf.paymentOption) &&
        Objects.equals(this.paymentScheduleKey, createPaymentTypeAllOf.paymentScheduleKey) &&
        Objects.equals(this.prepayment, createPaymentTypeAllOf.prepayment) &&
        Objects.equals(this.referenceId, createPaymentTypeAllOf.referenceId) &&
        Objects.equals(this.softDescriptor, createPaymentTypeAllOf.softDescriptor) &&
        Objects.equals(this.softDescriptorPhone, createPaymentTypeAllOf.softDescriptorPhone) &&
        Objects.equals(this.standalone, createPaymentTypeAllOf.standalone) &&
        Objects.equals(this.type, createPaymentTypeAllOf.type)&&
        Objects.equals(this.additionalProperties, createPaymentTypeAllOf.additionalProperties);
  }

  @Override
  public int hashCode() {
    return Objects.hash(accountId, accountNumber, amount, authTransactionId, comment, currency, customRates, debitMemos, effectiveDate, financeInformation, gatewayId, gatewayOptions, gatewayOrderId, invoices, mitTransactionSource, paymentGatewayNumber, paymentMethodId, paymentMethodType, paymentOption, paymentScheduleKey, prepayment, referenceId, softDescriptor, softDescriptorPhone, standalone, type, additionalProperties);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreatePaymentTypeAllOf {\n");
    sb.append("    accountId: ").append(toIndentedString(accountId)).append("\n");
    sb.append("    accountNumber: ").append(toIndentedString(accountNumber)).append("\n");
    sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
    sb.append("    authTransactionId: ").append(toIndentedString(authTransactionId)).append("\n");
    sb.append("    comment: ").append(toIndentedString(comment)).append("\n");
    sb.append("    currency: ").append(toIndentedString(currency)).append("\n");
    sb.append("    customRates: ").append(toIndentedString(customRates)).append("\n");
    sb.append("    debitMemos: ").append(toIndentedString(debitMemos)).append("\n");
    sb.append("    effectiveDate: ").append(toIndentedString(effectiveDate)).append("\n");
    sb.append("    financeInformation: ").append(toIndentedString(financeInformation)).append("\n");
    sb.append("    gatewayId: ").append(toIndentedString(gatewayId)).append("\n");
    sb.append("    gatewayOptions: ").append(toIndentedString(gatewayOptions)).append("\n");
    sb.append("    gatewayOrderId: ").append(toIndentedString(gatewayOrderId)).append("\n");
    sb.append("    invoices: ").append(toIndentedString(invoices)).append("\n");
    sb.append("    mitTransactionSource: ").append(toIndentedString(mitTransactionSource)).append("\n");
    sb.append("    paymentGatewayNumber: ").append(toIndentedString(paymentGatewayNumber)).append("\n");
    sb.append("    paymentMethodId: ").append(toIndentedString(paymentMethodId)).append("\n");
    sb.append("    paymentMethodType: ").append(toIndentedString(paymentMethodType)).append("\n");
    sb.append("    paymentOption: ").append(toIndentedString(paymentOption)).append("\n");
    sb.append("    paymentScheduleKey: ").append(toIndentedString(paymentScheduleKey)).append("\n");
    sb.append("    prepayment: ").append(toIndentedString(prepayment)).append("\n");
    sb.append("    referenceId: ").append(toIndentedString(referenceId)).append("\n");
    sb.append("    softDescriptor: ").append(toIndentedString(softDescriptor)).append("\n");
    sb.append("    softDescriptorPhone: ").append(toIndentedString(softDescriptorPhone)).append("\n");
    sb.append("    standalone: ").append(toIndentedString(standalone)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
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
    openapiFields.add("accountId");
    openapiFields.add("accountNumber");
    openapiFields.add("amount");
    openapiFields.add("authTransactionId");
    openapiFields.add("comment");
    openapiFields.add("currency");
    openapiFields.add("customRates");
    openapiFields.add("debitMemos");
    openapiFields.add("effectiveDate");
    openapiFields.add("financeInformation");
    openapiFields.add("gatewayId");
    openapiFields.add("gatewayOptions");
    openapiFields.add("gatewayOrderId");
    openapiFields.add("invoices");
    openapiFields.add("mitTransactionSource");
    openapiFields.add("paymentGatewayNumber");
    openapiFields.add("paymentMethodId");
    openapiFields.add("paymentMethodType");
    openapiFields.add("paymentOption");
    openapiFields.add("paymentScheduleKey");
    openapiFields.add("prepayment");
    openapiFields.add("referenceId");
    openapiFields.add("softDescriptor");
    openapiFields.add("softDescriptorPhone");
    openapiFields.add("standalone");
    openapiFields.add("type");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
    openapiRequiredFields.add("amount");
    openapiRequiredFields.add("currency");
    openapiRequiredFields.add("type");
  }

 /**
  * Validates the JSON Object and throws an exception if issues found
  *
  * @param jsonObj JSON Object
  * @throws IOException if the JSON Object is invalid with respect to CreatePaymentTypeAllOf
  */
  public static void validateJsonObject(JsonObject jsonObj) throws IOException {
      if (jsonObj == null) {
        if (!CreatePaymentTypeAllOf.openapiRequiredFields.isEmpty()) { // has required fields but JSON object is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in CreatePaymentTypeAllOf is not found in the empty JSON string", CreatePaymentTypeAllOf.openapiRequiredFields.toString()));
        }
      }

      // check to make sure all required properties/fields are present in the JSON string
      for (String requiredField : CreatePaymentTypeAllOf.openapiRequiredFields) {
        if (jsonObj.get(requiredField) == null) {
          throw new IllegalArgumentException(String.format("The required field `%s` is not found in the JSON string: %s", requiredField, jsonObj.toString()));
        }
      }
      if ((jsonObj.get("accountId") != null && !jsonObj.get("accountId").isJsonNull()) && !jsonObj.get("accountId").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `accountId` to be a primitive type in the JSON string but got `%s`", jsonObj.get("accountId").toString()));
      }
      if ((jsonObj.get("accountNumber") != null && !jsonObj.get("accountNumber").isJsonNull()) && !jsonObj.get("accountNumber").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `accountNumber` to be a primitive type in the JSON string but got `%s`", jsonObj.get("accountNumber").toString()));
      }
      if ((jsonObj.get("authTransactionId") != null && !jsonObj.get("authTransactionId").isJsonNull()) && !jsonObj.get("authTransactionId").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `authTransactionId` to be a primitive type in the JSON string but got `%s`", jsonObj.get("authTransactionId").toString()));
      }
      if ((jsonObj.get("comment") != null && !jsonObj.get("comment").isJsonNull()) && !jsonObj.get("comment").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `comment` to be a primitive type in the JSON string but got `%s`", jsonObj.get("comment").toString()));
      }
      if (!jsonObj.get("currency").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `currency` to be a primitive type in the JSON string but got `%s`", jsonObj.get("currency").toString()));
      }
      if (jsonObj.get("customRates") != null && !jsonObj.get("customRates").isJsonNull()) {
        JsonArray jsonArraycustomRates = jsonObj.getAsJsonArray("customRates");
        if (jsonArraycustomRates != null) {
          // ensure the json data is an array
          if (!jsonObj.get("customRates").isJsonArray()) {
            throw new IllegalArgumentException(String.format("Expected the field `customRates` to be an array in the JSON string but got `%s`", jsonObj.get("customRates").toString()));
          }

          // validate the optional field `customRates` (array)
          for (int i = 0; i < jsonArraycustomRates.size(); i++) {
            PaymentWithCustomRatesType.validateJsonObject(jsonArraycustomRates.get(i).getAsJsonObject());
          };
        }
      }
      if (jsonObj.get("debitMemos") != null && !jsonObj.get("debitMemos").isJsonNull()) {
        JsonArray jsonArraydebitMemos = jsonObj.getAsJsonArray("debitMemos");
        if (jsonArraydebitMemos != null) {
          // ensure the json data is an array
          if (!jsonObj.get("debitMemos").isJsonArray()) {
            throw new IllegalArgumentException(String.format("Expected the field `debitMemos` to be an array in the JSON string but got `%s`", jsonObj.get("debitMemos").toString()));
          }

          // validate the optional field `debitMemos` (array)
          for (int i = 0; i < jsonArraydebitMemos.size(); i++) {
            PaymentDebitMemoApplicationCreateRequestType.validateJsonObject(jsonArraydebitMemos.get(i).getAsJsonObject());
          };
        }
      }
      // validate the optional field `financeInformation`
      if (jsonObj.get("financeInformation") != null && !jsonObj.get("financeInformation").isJsonNull()) {
        CreatePaymentTypeAllOfFinanceInformation.validateJsonObject(jsonObj.getAsJsonObject("financeInformation"));
      }
      if ((jsonObj.get("gatewayId") != null && !jsonObj.get("gatewayId").isJsonNull()) && !jsonObj.get("gatewayId").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `gatewayId` to be a primitive type in the JSON string but got `%s`", jsonObj.get("gatewayId").toString()));
      }
      // validate the optional field `gatewayOptions`
      if (jsonObj.get("gatewayOptions") != null && !jsonObj.get("gatewayOptions").isJsonNull()) {
        CreatePaymentTypeAllOfGatewayOptions.validateJsonObject(jsonObj.getAsJsonObject("gatewayOptions"));
      }
      if ((jsonObj.get("gatewayOrderId") != null && !jsonObj.get("gatewayOrderId").isJsonNull()) && !jsonObj.get("gatewayOrderId").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `gatewayOrderId` to be a primitive type in the JSON string but got `%s`", jsonObj.get("gatewayOrderId").toString()));
      }
      if (jsonObj.get("invoices") != null && !jsonObj.get("invoices").isJsonNull()) {
        JsonArray jsonArrayinvoices = jsonObj.getAsJsonArray("invoices");
        if (jsonArrayinvoices != null) {
          // ensure the json data is an array
          if (!jsonObj.get("invoices").isJsonArray()) {
            throw new IllegalArgumentException(String.format("Expected the field `invoices` to be an array in the JSON string but got `%s`", jsonObj.get("invoices").toString()));
          }

          // validate the optional field `invoices` (array)
          for (int i = 0; i < jsonArrayinvoices.size(); i++) {
            PaymentInvoiceApplicationCreateRequestType.validateJsonObject(jsonArrayinvoices.get(i).getAsJsonObject());
          };
        }
      }
      if ((jsonObj.get("mitTransactionSource") != null && !jsonObj.get("mitTransactionSource").isJsonNull()) && !jsonObj.get("mitTransactionSource").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `mitTransactionSource` to be a primitive type in the JSON string but got `%s`", jsonObj.get("mitTransactionSource").toString()));
      }
      if ((jsonObj.get("paymentGatewayNumber") != null && !jsonObj.get("paymentGatewayNumber").isJsonNull()) && !jsonObj.get("paymentGatewayNumber").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `paymentGatewayNumber` to be a primitive type in the JSON string but got `%s`", jsonObj.get("paymentGatewayNumber").toString()));
      }
      if ((jsonObj.get("paymentMethodId") != null && !jsonObj.get("paymentMethodId").isJsonNull()) && !jsonObj.get("paymentMethodId").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `paymentMethodId` to be a primitive type in the JSON string but got `%s`", jsonObj.get("paymentMethodId").toString()));
      }
      if ((jsonObj.get("paymentMethodType") != null && !jsonObj.get("paymentMethodType").isJsonNull()) && !jsonObj.get("paymentMethodType").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `paymentMethodType` to be a primitive type in the JSON string but got `%s`", jsonObj.get("paymentMethodType").toString()));
      }
      if (jsonObj.get("paymentOption") != null && !jsonObj.get("paymentOption").isJsonNull()) {
        JsonArray jsonArraypaymentOption = jsonObj.getAsJsonArray("paymentOption");
        if (jsonArraypaymentOption != null) {
          // ensure the json data is an array
          if (!jsonObj.get("paymentOption").isJsonArray()) {
            throw new IllegalArgumentException(String.format("Expected the field `paymentOption` to be an array in the JSON string but got `%s`", jsonObj.get("paymentOption").toString()));
          }

          // validate the optional field `paymentOption` (array)
          for (int i = 0; i < jsonArraypaymentOption.size(); i++) {
            PaymentSchedulePaymentOptionFields.validateJsonObject(jsonArraypaymentOption.get(i).getAsJsonObject());
          };
        }
      }
      if ((jsonObj.get("paymentScheduleKey") != null && !jsonObj.get("paymentScheduleKey").isJsonNull()) && !jsonObj.get("paymentScheduleKey").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `paymentScheduleKey` to be a primitive type in the JSON string but got `%s`", jsonObj.get("paymentScheduleKey").toString()));
      }
      if ((jsonObj.get("referenceId") != null && !jsonObj.get("referenceId").isJsonNull()) && !jsonObj.get("referenceId").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `referenceId` to be a primitive type in the JSON string but got `%s`", jsonObj.get("referenceId").toString()));
      }
      if ((jsonObj.get("softDescriptor") != null && !jsonObj.get("softDescriptor").isJsonNull()) && !jsonObj.get("softDescriptor").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `softDescriptor` to be a primitive type in the JSON string but got `%s`", jsonObj.get("softDescriptor").toString()));
      }
      if ((jsonObj.get("softDescriptorPhone") != null && !jsonObj.get("softDescriptorPhone").isJsonNull()) && !jsonObj.get("softDescriptorPhone").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `softDescriptorPhone` to be a primitive type in the JSON string but got `%s`", jsonObj.get("softDescriptorPhone").toString()));
      }
      if (!jsonObj.get("type").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `type` to be a primitive type in the JSON string but got `%s`", jsonObj.get("type").toString()));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!CreatePaymentTypeAllOf.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'CreatePaymentTypeAllOf' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<CreatePaymentTypeAllOf> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(CreatePaymentTypeAllOf.class));

       return (TypeAdapter<T>) new TypeAdapter<CreatePaymentTypeAllOf>() {
           @Override
           public void write(JsonWriter out, CreatePaymentTypeAllOf value) throws IOException {
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
           public CreatePaymentTypeAllOf read(JsonReader in) throws IOException {
             JsonObject jsonObj = elementAdapter.read(in).getAsJsonObject();
             validateJsonObject(jsonObj);
             // store additional fields in the deserialized instance
             CreatePaymentTypeAllOf instance = thisAdapter.fromJsonTree(jsonObj);
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
  * Create an instance of CreatePaymentTypeAllOf given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of CreatePaymentTypeAllOf
  * @throws IOException if the JSON string is invalid with respect to CreatePaymentTypeAllOf
  */
  public static CreatePaymentTypeAllOf fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, CreatePaymentTypeAllOf.class);
  }

 /**
  * Convert an instance of CreatePaymentTypeAllOf to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

