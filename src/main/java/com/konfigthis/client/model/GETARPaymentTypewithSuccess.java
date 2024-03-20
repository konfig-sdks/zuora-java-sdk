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
import com.konfigthis.client.model.GETARPaymentTypewithSuccessAllOfFinanceInformation;
import com.konfigthis.client.model.PaymentSchedulePaymentOptionFields;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
import java.time.OffsetDateTime;
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
 * GETARPaymentTypewithSuccess
 */@javax.annotation.Generated(value = "Generated by https://konfigthis.com")
public class GETARPaymentTypewithSuccess {
  public static final String SERIALIZED_NAME_ACCOUNT_ID = "accountId";
  @SerializedName(SERIALIZED_NAME_ACCOUNT_ID)
  private String accountId;

  public static final String SERIALIZED_NAME_ACCOUNT_NUMBER = "accountNumber";
  @SerializedName(SERIALIZED_NAME_ACCOUNT_NUMBER)
  private String accountNumber;

  public static final String SERIALIZED_NAME_AMOUNT = "amount";
  @SerializedName(SERIALIZED_NAME_AMOUNT)
  private Double amount;

  public static final String SERIALIZED_NAME_APPLIED_AMOUNT = "appliedAmount";
  @SerializedName(SERIALIZED_NAME_APPLIED_AMOUNT)
  private Double appliedAmount;

  public static final String SERIALIZED_NAME_AUTH_TRANSACTION_ID = "authTransactionId";
  @SerializedName(SERIALIZED_NAME_AUTH_TRANSACTION_ID)
  private String authTransactionId;

  public static final String SERIALIZED_NAME_BANK_IDENTIFICATION_NUMBER = "bankIdentificationNumber";
  @SerializedName(SERIALIZED_NAME_BANK_IDENTIFICATION_NUMBER)
  private String bankIdentificationNumber;

  public static final String SERIALIZED_NAME_CANCELLED_ON = "cancelledOn";
  @SerializedName(SERIALIZED_NAME_CANCELLED_ON)
  private OffsetDateTime cancelledOn;

  public static final String SERIALIZED_NAME_COMMENT = "comment";
  @SerializedName(SERIALIZED_NAME_COMMENT)
  private String comment;

  public static final String SERIALIZED_NAME_CREATED_BY_ID = "createdById";
  @SerializedName(SERIALIZED_NAME_CREATED_BY_ID)
  private String createdById;

  public static final String SERIALIZED_NAME_CREATED_DATE = "createdDate";
  @SerializedName(SERIALIZED_NAME_CREATED_DATE)
  private OffsetDateTime createdDate;

  public static final String SERIALIZED_NAME_CREDIT_BALANCE_AMOUNT = "creditBalanceAmount";
  @SerializedName(SERIALIZED_NAME_CREDIT_BALANCE_AMOUNT)
  private Double creditBalanceAmount;

  public static final String SERIALIZED_NAME_CURRENCY = "currency";
  @SerializedName(SERIALIZED_NAME_CURRENCY)
  private String currency;

  public static final String SERIALIZED_NAME_EFFECTIVE_DATE = "effectiveDate";
  @SerializedName(SERIALIZED_NAME_EFFECTIVE_DATE)
  private OffsetDateTime effectiveDate;

  public static final String SERIALIZED_NAME_FINANCE_INFORMATION = "financeInformation";
  @SerializedName(SERIALIZED_NAME_FINANCE_INFORMATION)
  private GETARPaymentTypewithSuccessAllOfFinanceInformation financeInformation;

  public static final String SERIALIZED_NAME_GATEWAY_ID = "gatewayId";
  @SerializedName(SERIALIZED_NAME_GATEWAY_ID)
  private String gatewayId;

  public static final String SERIALIZED_NAME_GATEWAY_ORDER_ID = "gatewayOrderId";
  @SerializedName(SERIALIZED_NAME_GATEWAY_ORDER_ID)
  private String gatewayOrderId;

  public static final String SERIALIZED_NAME_GATEWAY_RECONCILIATION_REASON = "gatewayReconciliationReason";
  @SerializedName(SERIALIZED_NAME_GATEWAY_RECONCILIATION_REASON)
  private String gatewayReconciliationReason;

  public static final String SERIALIZED_NAME_GATEWAY_RECONCILIATION_STATUS = "gatewayReconciliationStatus";
  @SerializedName(SERIALIZED_NAME_GATEWAY_RECONCILIATION_STATUS)
  private String gatewayReconciliationStatus;

  public static final String SERIALIZED_NAME_GATEWAY_RESPONSE = "gatewayResponse";
  @SerializedName(SERIALIZED_NAME_GATEWAY_RESPONSE)
  private String gatewayResponse;

  public static final String SERIALIZED_NAME_GATEWAY_RESPONSE_CODE = "gatewayResponseCode";
  @SerializedName(SERIALIZED_NAME_GATEWAY_RESPONSE_CODE)
  private String gatewayResponseCode;

  /**
   * The status of the payment in the gateway; use for reconciliation.  
   */
  @JsonAdapter(GatewayStateEnum.Adapter.class)
 public enum GatewayStateEnum {
    MARKEDFORSUBMISSION("MarkedForSubmission"),
    
    SUBMITTED("Submitted"),
    
    SETTLED("Settled"),
    
    NOTSUBMITTED("NotSubmitted"),
    
    FAILEDTOSETTLE("FailedToSettle");

    private String value;

    GatewayStateEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static GatewayStateEnum fromValue(String value) {
      for (GatewayStateEnum b : GatewayStateEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<GatewayStateEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final GatewayStateEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public GatewayStateEnum read(final JsonReader jsonReader) throws IOException {
        String value =  jsonReader.nextString();
        return GatewayStateEnum.fromValue(value);
      }
    }
  }

  public static final String SERIALIZED_NAME_GATEWAY_STATE = "gatewayState";
  @SerializedName(SERIALIZED_NAME_GATEWAY_STATE)
  private GatewayStateEnum gatewayState;

  public static final String SERIALIZED_NAME_ID = "id";
  @SerializedName(SERIALIZED_NAME_ID)
  private String id;

  public static final String SERIALIZED_NAME_MARKED_FOR_SUBMISSION_ON = "markedForSubmissionOn";
  @SerializedName(SERIALIZED_NAME_MARKED_FOR_SUBMISSION_ON)
  private OffsetDateTime markedForSubmissionOn;

  public static final String SERIALIZED_NAME_NUMBER = "number";
  @SerializedName(SERIALIZED_NAME_NUMBER)
  private String number;

  public static final String SERIALIZED_NAME_ORGANIZATION_LABEL = "organizationLabel";
  @SerializedName(SERIALIZED_NAME_ORGANIZATION_LABEL)
  private String organizationLabel;

  public static final String SERIALIZED_NAME_PAYMENT_GATEWAY_NUMBER = "paymentGatewayNumber";
  @SerializedName(SERIALIZED_NAME_PAYMENT_GATEWAY_NUMBER)
  private String paymentGatewayNumber;

  public static final String SERIALIZED_NAME_PAYMENT_METHOD_ID = "paymentMethodId";
  @SerializedName(SERIALIZED_NAME_PAYMENT_METHOD_ID)
  private String paymentMethodId;

  public static final String SERIALIZED_NAME_PAYMENT_METHOD_SNAPSHOT_ID = "paymentMethodSnapshotId";
  @SerializedName(SERIALIZED_NAME_PAYMENT_METHOD_SNAPSHOT_ID)
  private String paymentMethodSnapshotId;

  public static final String SERIALIZED_NAME_PAYMENT_OPTION = "paymentOption";
  @SerializedName(SERIALIZED_NAME_PAYMENT_OPTION)
  private List<PaymentSchedulePaymentOptionFields> paymentOption = null;

  public static final String SERIALIZED_NAME_PAYMENT_SCHEDULE_KEY = "paymentScheduleKey";
  @SerializedName(SERIALIZED_NAME_PAYMENT_SCHEDULE_KEY)
  private String paymentScheduleKey;

  public static final String SERIALIZED_NAME_PAYOUT_ID = "payoutId";
  @SerializedName(SERIALIZED_NAME_PAYOUT_ID)
  private String payoutId;

  public static final String SERIALIZED_NAME_PREPAYMENT = "prepayment";
  @SerializedName(SERIALIZED_NAME_PREPAYMENT)
  private Boolean prepayment;

  public static final String SERIALIZED_NAME_REFERENCE_ID = "referenceId";
  @SerializedName(SERIALIZED_NAME_REFERENCE_ID)
  private String referenceId;

  public static final String SERIALIZED_NAME_REFUND_AMOUNT = "refundAmount";
  @SerializedName(SERIALIZED_NAME_REFUND_AMOUNT)
  private Double refundAmount;

  public static final String SERIALIZED_NAME_SECOND_PAYMENT_REFERENCE_ID = "secondPaymentReferenceId";
  @SerializedName(SERIALIZED_NAME_SECOND_PAYMENT_REFERENCE_ID)
  private String secondPaymentReferenceId;

  public static final String SERIALIZED_NAME_SETTLED_ON = "settledOn";
  @SerializedName(SERIALIZED_NAME_SETTLED_ON)
  private OffsetDateTime settledOn;

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
   * The status of the payment. 
   */
  @JsonAdapter(StatusEnum.Adapter.class)
 public enum StatusEnum {
    DRAFT("Draft"),
    
    PROCESSING("Processing"),
    
    PROCESSED("Processed"),
    
    ERROR("Error"),
    
    CANCELED("Canceled"),
    
    POSTED("Posted");

    private String value;

    StatusEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static StatusEnum fromValue(String value) {
      for (StatusEnum b : StatusEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<StatusEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final StatusEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public StatusEnum read(final JsonReader jsonReader) throws IOException {
        String value =  jsonReader.nextString();
        return StatusEnum.fromValue(value);
      }
    }
  }

  public static final String SERIALIZED_NAME_STATUS = "status";
  @SerializedName(SERIALIZED_NAME_STATUS)
  private StatusEnum status;

  public static final String SERIALIZED_NAME_SUBMITTED_ON = "submittedOn";
  @SerializedName(SERIALIZED_NAME_SUBMITTED_ON)
  private OffsetDateTime submittedOn;

  /**
   * The type of the payment. 
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

  public static final String SERIALIZED_NAME_UNAPPLIED_AMOUNT = "unappliedAmount";
  @SerializedName(SERIALIZED_NAME_UNAPPLIED_AMOUNT)
  private Double unappliedAmount;

  public static final String SERIALIZED_NAME_UPDATED_BY_ID = "updatedById";
  @SerializedName(SERIALIZED_NAME_UPDATED_BY_ID)
  private String updatedById;

  public static final String SERIALIZED_NAME_UPDATED_DATE = "updatedDate";
  @SerializedName(SERIALIZED_NAME_UPDATED_DATE)
  private OffsetDateTime updatedDate;

  public static final String SERIALIZED_NAME_INTEGRATION_ID_N_S = "IntegrationId__NS";
  @SerializedName(SERIALIZED_NAME_INTEGRATION_ID_N_S)
  private String integrationIdNS;

  public static final String SERIALIZED_NAME_INTEGRATION_STATUS_N_S = "IntegrationStatus__NS";
  @SerializedName(SERIALIZED_NAME_INTEGRATION_STATUS_N_S)
  private String integrationStatusNS;

  public static final String SERIALIZED_NAME_ORIGIN_N_S = "Origin__NS";
  @SerializedName(SERIALIZED_NAME_ORIGIN_N_S)
  private String originNS;

  public static final String SERIALIZED_NAME_SYNC_DATE_N_S = "SyncDate__NS";
  @SerializedName(SERIALIZED_NAME_SYNC_DATE_N_S)
  private String syncDateNS;

  public static final String SERIALIZED_NAME_TRANSACTION_N_S = "Transaction__NS";
  @SerializedName(SERIALIZED_NAME_TRANSACTION_N_S)
  private String transactionNS;

  public GETARPaymentTypewithSuccess() {
  }

  public GETARPaymentTypewithSuccess accountId(String accountId) {
    
    
    
    
    this.accountId = accountId;
    return this;
  }

   /**
   * The ID of the customer account that the payment is for. 
   * @return accountId
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The ID of the customer account that the payment is for. ")

  public String getAccountId() {
    return accountId;
  }


  public void setAccountId(String accountId) {
    
    
    
    this.accountId = accountId;
  }


  public GETARPaymentTypewithSuccess accountNumber(String accountNumber) {
    
    
    
    
    this.accountNumber = accountNumber;
    return this;
  }

   /**
   * The number of the customer account that the payment is for. 
   * @return accountNumber
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The number of the customer account that the payment is for. ")

  public String getAccountNumber() {
    return accountNumber;
  }


  public void setAccountNumber(String accountNumber) {
    
    
    
    this.accountNumber = accountNumber;
  }


  public GETARPaymentTypewithSuccess amount(Double amount) {
    
    
    
    
    this.amount = amount;
    return this;
  }

   /**
   * The total amount of the payment. 
   * @return amount
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The total amount of the payment. ")

  public Double getAmount() {
    return amount;
  }


  public void setAmount(Double amount) {
    
    
    
    this.amount = amount;
  }


  public GETARPaymentTypewithSuccess appliedAmount(Double appliedAmount) {
    
    
    
    
    this.appliedAmount = appliedAmount;
    return this;
  }

   /**
   * The applied amount of the payment. 
   * @return appliedAmount
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The applied amount of the payment. ")

  public Double getAppliedAmount() {
    return appliedAmount;
  }


  public void setAppliedAmount(Double appliedAmount) {
    
    
    
    this.appliedAmount = appliedAmount;
  }


  public GETARPaymentTypewithSuccess authTransactionId(String authTransactionId) {
    
    
    
    
    this.authTransactionId = authTransactionId;
    return this;
  }

   /**
   * The authorization transaction ID from the payment gateway. 
   * @return authTransactionId
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The authorization transaction ID from the payment gateway. ")

  public String getAuthTransactionId() {
    return authTransactionId;
  }


  public void setAuthTransactionId(String authTransactionId) {
    
    
    
    this.authTransactionId = authTransactionId;
  }


  public GETARPaymentTypewithSuccess bankIdentificationNumber(String bankIdentificationNumber) {
    
    
    
    
    this.bankIdentificationNumber = bankIdentificationNumber;
    return this;
  }

   /**
   * The first six or eight digits of the credit card or debit card used for the payment, when applicable. 
   * @return bankIdentificationNumber
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The first six or eight digits of the credit card or debit card used for the payment, when applicable. ")

  public String getBankIdentificationNumber() {
    return bankIdentificationNumber;
  }


  public void setBankIdentificationNumber(String bankIdentificationNumber) {
    
    
    
    this.bankIdentificationNumber = bankIdentificationNumber;
  }


  public GETARPaymentTypewithSuccess cancelledOn(OffsetDateTime cancelledOn) {
    
    
    
    
    this.cancelledOn = cancelledOn;
    return this;
  }

   /**
   * The date and time when the payment was cancelled, in &#x60;yyyy-mm-dd hh:mm:ss&#x60; format. 
   * @return cancelledOn
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The date and time when the payment was cancelled, in `yyyy-mm-dd hh:mm:ss` format. ")

  public OffsetDateTime getCancelledOn() {
    return cancelledOn;
  }


  public void setCancelledOn(OffsetDateTime cancelledOn) {
    
    
    
    this.cancelledOn = cancelledOn;
  }


  public GETARPaymentTypewithSuccess comment(String comment) {
    
    
    
    
    this.comment = comment;
    return this;
  }

   /**
   * Comments about the payment. 
   * @return comment
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Comments about the payment. ")

  public String getComment() {
    return comment;
  }


  public void setComment(String comment) {
    
    
    
    this.comment = comment;
  }


  public GETARPaymentTypewithSuccess createdById(String createdById) {
    
    
    
    
    this.createdById = createdById;
    return this;
  }

   /**
   * The ID of the Zuora user who created the payment part. 
   * @return createdById
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The ID of the Zuora user who created the payment part. ")

  public String getCreatedById() {
    return createdById;
  }


  public void setCreatedById(String createdById) {
    
    
    
    this.createdById = createdById;
  }


  public GETARPaymentTypewithSuccess createdDate(OffsetDateTime createdDate) {
    
    
    
    
    this.createdDate = createdDate;
    return this;
  }

   /**
   * The date and time when the payment was created, in &#x60;yyyy-mm-dd hh:mm:ss&#x60; format. For example, 2017-03-01 15:31:10. 
   * @return createdDate
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The date and time when the payment was created, in `yyyy-mm-dd hh:mm:ss` format. For example, 2017-03-01 15:31:10. ")

  public OffsetDateTime getCreatedDate() {
    return createdDate;
  }


  public void setCreatedDate(OffsetDateTime createdDate) {
    
    
    
    this.createdDate = createdDate;
  }


  public GETARPaymentTypewithSuccess creditBalanceAmount(Double creditBalanceAmount) {
    
    
    
    
    this.creditBalanceAmount = creditBalanceAmount;
    return this;
  }

   /**
   * The amount that the payment transfers to the credit balance. The value is not &#x60;0&#x60; only for those payments that come from legacy payment operations performed without the Invoice Settlement feature. 
   * @return creditBalanceAmount
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The amount that the payment transfers to the credit balance. The value is not `0` only for those payments that come from legacy payment operations performed without the Invoice Settlement feature. ")

  public Double getCreditBalanceAmount() {
    return creditBalanceAmount;
  }


  public void setCreditBalanceAmount(Double creditBalanceAmount) {
    
    
    
    this.creditBalanceAmount = creditBalanceAmount;
  }


  public GETARPaymentTypewithSuccess currency(String currency) {
    
    
    
    
    this.currency = currency;
    return this;
  }

   /**
   * When Standalone Payment is not enabled, the &#x60;currency&#x60; of the payment must be the same as the payment currency defined in the customer account settings through Zuora UI.  When Standalone Payment is enabled and &#x60;standalone&#x60; is &#x60;true&#x60;, the &#x60;currency&#x60; of the standalone payment can be different from the payment currency defined in the customer account settings. The amount will not be summed up to the account balance or key metrics regardless of currency. 
   * @return currency
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "When Standalone Payment is not enabled, the `currency` of the payment must be the same as the payment currency defined in the customer account settings through Zuora UI.  When Standalone Payment is enabled and `standalone` is `true`, the `currency` of the standalone payment can be different from the payment currency defined in the customer account settings. The amount will not be summed up to the account balance or key metrics regardless of currency. ")

  public String getCurrency() {
    return currency;
  }


  public void setCurrency(String currency) {
    
    
    
    this.currency = currency;
  }


  public GETARPaymentTypewithSuccess effectiveDate(OffsetDateTime effectiveDate) {
    
    
    
    
    this.effectiveDate = effectiveDate;
    return this;
  }

   /**
   * The date and time when the payment takes effect, in &#x60;yyyy-mm-dd hh:mm:ss&#x60; format. 
   * @return effectiveDate
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The date and time when the payment takes effect, in `yyyy-mm-dd hh:mm:ss` format. ")

  public OffsetDateTime getEffectiveDate() {
    return effectiveDate;
  }


  public void setEffectiveDate(OffsetDateTime effectiveDate) {
    
    
    
    this.effectiveDate = effectiveDate;
  }


  public GETARPaymentTypewithSuccess financeInformation(GETARPaymentTypewithSuccessAllOfFinanceInformation financeInformation) {
    
    
    
    
    this.financeInformation = financeInformation;
    return this;
  }

   /**
   * Get financeInformation
   * @return financeInformation
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public GETARPaymentTypewithSuccessAllOfFinanceInformation getFinanceInformation() {
    return financeInformation;
  }


  public void setFinanceInformation(GETARPaymentTypewithSuccessAllOfFinanceInformation financeInformation) {
    
    
    
    this.financeInformation = financeInformation;
  }


  public GETARPaymentTypewithSuccess gatewayId(String gatewayId) {
    
    
    
    
    this.gatewayId = gatewayId;
    return this;
  }

   /**
   * The ID of the gateway instance that processes the payment. 
   * @return gatewayId
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The ID of the gateway instance that processes the payment. ")

  public String getGatewayId() {
    return gatewayId;
  }


  public void setGatewayId(String gatewayId) {
    
    
    
    this.gatewayId = gatewayId;
  }


  public GETARPaymentTypewithSuccess gatewayOrderId(String gatewayOrderId) {
    
    
    
    
    this.gatewayOrderId = gatewayOrderId;
    return this;
  }

   /**
   * A merchant-specified natural key value that can be passed to the electronic payment gateway when a payment is created. 
   * @return gatewayOrderId
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "A merchant-specified natural key value that can be passed to the electronic payment gateway when a payment is created. ")

  public String getGatewayOrderId() {
    return gatewayOrderId;
  }


  public void setGatewayOrderId(String gatewayOrderId) {
    
    
    
    this.gatewayOrderId = gatewayOrderId;
  }


  public GETARPaymentTypewithSuccess gatewayReconciliationReason(String gatewayReconciliationReason) {
    
    
    
    
    this.gatewayReconciliationReason = gatewayReconciliationReason;
    return this;
  }

   /**
   * The reason of gateway reconciliation. 
   * @return gatewayReconciliationReason
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The reason of gateway reconciliation. ")

  public String getGatewayReconciliationReason() {
    return gatewayReconciliationReason;
  }


  public void setGatewayReconciliationReason(String gatewayReconciliationReason) {
    
    
    
    this.gatewayReconciliationReason = gatewayReconciliationReason;
  }


  public GETARPaymentTypewithSuccess gatewayReconciliationStatus(String gatewayReconciliationStatus) {
    
    
    
    
    this.gatewayReconciliationStatus = gatewayReconciliationStatus;
    return this;
  }

   /**
   * The status of gateway reconciliation. 
   * @return gatewayReconciliationStatus
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The status of gateway reconciliation. ")

  public String getGatewayReconciliationStatus() {
    return gatewayReconciliationStatus;
  }


  public void setGatewayReconciliationStatus(String gatewayReconciliationStatus) {
    
    
    
    this.gatewayReconciliationStatus = gatewayReconciliationStatus;
  }


  public GETARPaymentTypewithSuccess gatewayResponse(String gatewayResponse) {
    
    
    
    
    this.gatewayResponse = gatewayResponse;
    return this;
  }

   /**
   * The message returned from the payment gateway for the payment. This message is gateway-dependent. 
   * @return gatewayResponse
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The message returned from the payment gateway for the payment. This message is gateway-dependent. ")

  public String getGatewayResponse() {
    return gatewayResponse;
  }


  public void setGatewayResponse(String gatewayResponse) {
    
    
    
    this.gatewayResponse = gatewayResponse;
  }


  public GETARPaymentTypewithSuccess gatewayResponseCode(String gatewayResponseCode) {
    
    
    
    
    this.gatewayResponseCode = gatewayResponseCode;
    return this;
  }

   /**
   * The code returned from the payment gateway for the payment. This code is gateway-dependent. 
   * @return gatewayResponseCode
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The code returned from the payment gateway for the payment. This code is gateway-dependent. ")

  public String getGatewayResponseCode() {
    return gatewayResponseCode;
  }


  public void setGatewayResponseCode(String gatewayResponseCode) {
    
    
    
    this.gatewayResponseCode = gatewayResponseCode;
  }


  public GETARPaymentTypewithSuccess gatewayState(GatewayStateEnum gatewayState) {
    
    
    
    
    this.gatewayState = gatewayState;
    return this;
  }

   /**
   * The status of the payment in the gateway; use for reconciliation.  
   * @return gatewayState
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The status of the payment in the gateway; use for reconciliation.  ")

  public GatewayStateEnum getGatewayState() {
    return gatewayState;
  }


  public void setGatewayState(GatewayStateEnum gatewayState) {
    
    
    
    this.gatewayState = gatewayState;
  }


  public GETARPaymentTypewithSuccess id(String id) {
    
    
    
    
    this.id = id;
    return this;
  }

   /**
   * The unique ID of the payment. For example, 4028905f5a87c0ff015a87eb6b75007f. 
   * @return id
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The unique ID of the payment. For example, 4028905f5a87c0ff015a87eb6b75007f. ")

  public String getId() {
    return id;
  }


  public void setId(String id) {
    
    
    
    this.id = id;
  }


  public GETARPaymentTypewithSuccess markedForSubmissionOn(OffsetDateTime markedForSubmissionOn) {
    
    
    
    
    this.markedForSubmissionOn = markedForSubmissionOn;
    return this;
  }

   /**
   * The date and time when a payment was marked and waiting for batch submission to the payment process, in &#x60;yyyy-mm-dd hh:mm:ss&#x60; format. 
   * @return markedForSubmissionOn
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The date and time when a payment was marked and waiting for batch submission to the payment process, in `yyyy-mm-dd hh:mm:ss` format. ")

  public OffsetDateTime getMarkedForSubmissionOn() {
    return markedForSubmissionOn;
  }


  public void setMarkedForSubmissionOn(OffsetDateTime markedForSubmissionOn) {
    
    
    
    this.markedForSubmissionOn = markedForSubmissionOn;
  }


  public GETARPaymentTypewithSuccess number(String number) {
    
    
    
    
    this.number = number;
    return this;
  }

   /**
   * The unique identification number of the payment. For example, P-00000001. 
   * @return number
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The unique identification number of the payment. For example, P-00000001. ")

  public String getNumber() {
    return number;
  }


  public void setNumber(String number) {
    
    
    
    this.number = number;
  }


  public GETARPaymentTypewithSuccess organizationLabel(String organizationLabel) {
    
    
    
    
    this.organizationLabel = organizationLabel;
    return this;
  }

   /**
   * The organization that this object belongs to.  Note: This field is available only when the Multi-Org feature is enabled. 
   * @return organizationLabel
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The organization that this object belongs to.  Note: This field is available only when the Multi-Org feature is enabled. ")

  public String getOrganizationLabel() {
    return organizationLabel;
  }


  public void setOrganizationLabel(String organizationLabel) {
    
    
    
    this.organizationLabel = organizationLabel;
  }


  public GETARPaymentTypewithSuccess paymentGatewayNumber(String paymentGatewayNumber) {
    
    
    
    
    this.paymentGatewayNumber = paymentGatewayNumber;
    return this;
  }

   /**
   * The natural key for the payment gateway. 
   * @return paymentGatewayNumber
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The natural key for the payment gateway. ")

  public String getPaymentGatewayNumber() {
    return paymentGatewayNumber;
  }


  public void setPaymentGatewayNumber(String paymentGatewayNumber) {
    
    
    
    this.paymentGatewayNumber = paymentGatewayNumber;
  }


  public GETARPaymentTypewithSuccess paymentMethodId(String paymentMethodId) {
    
    
    
    
    this.paymentMethodId = paymentMethodId;
    return this;
  }

   /**
   * The unique ID of the payment method that the customer used to make the payment. 
   * @return paymentMethodId
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The unique ID of the payment method that the customer used to make the payment. ")

  public String getPaymentMethodId() {
    return paymentMethodId;
  }


  public void setPaymentMethodId(String paymentMethodId) {
    
    
    
    this.paymentMethodId = paymentMethodId;
  }


  public GETARPaymentTypewithSuccess paymentMethodSnapshotId(String paymentMethodSnapshotId) {
    
    
    
    
    this.paymentMethodSnapshotId = paymentMethodSnapshotId;
    return this;
  }

   /**
   * The unique ID of the payment method snapshot which is a copy of the particular Payment Method used in a transaction. 
   * @return paymentMethodSnapshotId
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The unique ID of the payment method snapshot which is a copy of the particular Payment Method used in a transaction. ")

  public String getPaymentMethodSnapshotId() {
    return paymentMethodSnapshotId;
  }


  public void setPaymentMethodSnapshotId(String paymentMethodSnapshotId) {
    
    
    
    this.paymentMethodSnapshotId = paymentMethodSnapshotId;
  }


  public GETARPaymentTypewithSuccess paymentOption(List<PaymentSchedulePaymentOptionFields> paymentOption) {
    
    
    
    
    this.paymentOption = paymentOption;
    return this;
  }

  public GETARPaymentTypewithSuccess addPaymentOptionItem(PaymentSchedulePaymentOptionFields paymentOptionItem) {
    if (this.paymentOption == null) {
      this.paymentOption = new ArrayList<>();
    }
    this.paymentOption.add(paymentOptionItem);
    return this;
  }

   /**
   * Container for the paymentOption items, which describe the transactional level rules for processing payments. Currently, only the Gateway Options type is supported.  &#x60;paymentOption&#x60; of the payment schedule takes precedence over &#x60;paymentOption&#x60; of the payment schedule item. 
   * @return paymentOption
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Container for the paymentOption items, which describe the transactional level rules for processing payments. Currently, only the Gateway Options type is supported.  `paymentOption` of the payment schedule takes precedence over `paymentOption` of the payment schedule item. ")

  public List<PaymentSchedulePaymentOptionFields> getPaymentOption() {
    return paymentOption;
  }


  public void setPaymentOption(List<PaymentSchedulePaymentOptionFields> paymentOption) {
    
    
    
    this.paymentOption = paymentOption;
  }


  public GETARPaymentTypewithSuccess paymentScheduleKey(String paymentScheduleKey) {
    
    
    
    
    this.paymentScheduleKey = paymentScheduleKey;
    return this;
  }

   /**
   * The unique ID or the number of the payment schedule that is linked to the payment. See [Link payments to payment schedules](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/Payment_Schedules/Link_payments_with_payment_schedules) for more information.
   * @return paymentScheduleKey
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The unique ID or the number of the payment schedule that is linked to the payment. See [Link payments to payment schedules](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/Payment_Schedules/Link_payments_with_payment_schedules) for more information.")

  public String getPaymentScheduleKey() {
    return paymentScheduleKey;
  }


  public void setPaymentScheduleKey(String paymentScheduleKey) {
    
    
    
    this.paymentScheduleKey = paymentScheduleKey;
  }


  public GETARPaymentTypewithSuccess payoutId(String payoutId) {
    
    
    
    
    this.payoutId = payoutId;
    return this;
  }

   /**
   * The payout ID of the payment from the gateway side. 
   * @return payoutId
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The payout ID of the payment from the gateway side. ")

  public String getPayoutId() {
    return payoutId;
  }


  public void setPayoutId(String payoutId) {
    
    
    
    this.payoutId = payoutId;
  }


  public GETARPaymentTypewithSuccess prepayment(Boolean prepayment) {
    
    
    
    
    this.prepayment = prepayment;
    return this;
  }

   /**
   * Indicates whether the payment is used as a reserved payment. See [Prepaid Cash with Drawdown](https://knowledgecenter.zuora.com/Zuora_Billing/Billing_and_Invoicing/JA_Advanced_Consumption_Billing/Prepaid_Cash_with_Drawdown) for more information. 
   * @return prepayment
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Indicates whether the payment is used as a reserved payment. See [Prepaid Cash with Drawdown](https://knowledgecenter.zuora.com/Zuora_Billing/Billing_and_Invoicing/JA_Advanced_Consumption_Billing/Prepaid_Cash_with_Drawdown) for more information. ")

  public Boolean getPrepayment() {
    return prepayment;
  }


  public void setPrepayment(Boolean prepayment) {
    
    
    
    this.prepayment = prepayment;
  }


  public GETARPaymentTypewithSuccess referenceId(String referenceId) {
    
    
    
    
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
    
    
    
    this.referenceId = referenceId;
  }


  public GETARPaymentTypewithSuccess refundAmount(Double refundAmount) {
    
    
    
    
    this.refundAmount = refundAmount;
    return this;
  }

   /**
   * The amount of the payment that is refunded. 
   * @return refundAmount
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The amount of the payment that is refunded. ")

  public Double getRefundAmount() {
    return refundAmount;
  }


  public void setRefundAmount(Double refundAmount) {
    
    
    
    this.refundAmount = refundAmount;
  }


  public GETARPaymentTypewithSuccess secondPaymentReferenceId(String secondPaymentReferenceId) {
    
    
    
    
    this.secondPaymentReferenceId = secondPaymentReferenceId;
    return this;
  }

   /**
   * The transaction ID returned by the payment gateway if there is an additional transaction for the payment. Use this field to reconcile payments between your gateway and Zuora Payments. 
   * @return secondPaymentReferenceId
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The transaction ID returned by the payment gateway if there is an additional transaction for the payment. Use this field to reconcile payments between your gateway and Zuora Payments. ")

  public String getSecondPaymentReferenceId() {
    return secondPaymentReferenceId;
  }


  public void setSecondPaymentReferenceId(String secondPaymentReferenceId) {
    
    
    
    this.secondPaymentReferenceId = secondPaymentReferenceId;
  }


  public GETARPaymentTypewithSuccess settledOn(OffsetDateTime settledOn) {
    
    
    
    
    this.settledOn = settledOn;
    return this;
  }

   /**
   * The date and time when the payment was settled in the payment processor, in &#x60;yyyy-mm-dd hh:mm:ss&#x60; format. This field is used by the Spectrum gateway only and not applicable to other gateways. 
   * @return settledOn
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The date and time when the payment was settled in the payment processor, in `yyyy-mm-dd hh:mm:ss` format. This field is used by the Spectrum gateway only and not applicable to other gateways. ")

  public OffsetDateTime getSettledOn() {
    return settledOn;
  }


  public void setSettledOn(OffsetDateTime settledOn) {
    
    
    
    this.settledOn = settledOn;
  }


  public GETARPaymentTypewithSuccess softDescriptor(String softDescriptor) {
    
    
    
    
    this.softDescriptor = softDescriptor;
    return this;
  }

   /**
   * A payment gateway-specific field that maps to Zuora for the gateways, Orbital, Vantiv and Verifi. 
   * @return softDescriptor
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "A payment gateway-specific field that maps to Zuora for the gateways, Orbital, Vantiv and Verifi. ")

  public String getSoftDescriptor() {
    return softDescriptor;
  }


  public void setSoftDescriptor(String softDescriptor) {
    
    
    
    this.softDescriptor = softDescriptor;
  }


  public GETARPaymentTypewithSuccess softDescriptorPhone(String softDescriptorPhone) {
    
    
    
    
    this.softDescriptorPhone = softDescriptorPhone;
    return this;
  }

   /**
   * A payment gateway-specific field that maps to Zuora for the gateways, Orbital, Vantiv and Verifi. 
   * @return softDescriptorPhone
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "A payment gateway-specific field that maps to Zuora for the gateways, Orbital, Vantiv and Verifi. ")

  public String getSoftDescriptorPhone() {
    return softDescriptorPhone;
  }


  public void setSoftDescriptorPhone(String softDescriptorPhone) {
    
    
    
    this.softDescriptorPhone = softDescriptorPhone;
  }


  public GETARPaymentTypewithSuccess standalone(Boolean standalone) {
    
    
    
    
    this.standalone = standalone;
    return this;
  }

   /**
   * This field is only available if the support for standalone payment is enabled.  The value &#x60;true&#x60; indicates this is a standalone payment that is created and processed in Zuora through Zuora gateway integration but will be settled outside of Zuora. No settlement data will be created. The standalone payment cannot be applied, unapplied, or transferred.  The value &#x60;false&#x60; indicates this is an ordinary payment that is created, processed, and settled in Zuora. 
   * @return standalone
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "false", value = "This field is only available if the support for standalone payment is enabled.  The value `true` indicates this is a standalone payment that is created and processed in Zuora through Zuora gateway integration but will be settled outside of Zuora. No settlement data will be created. The standalone payment cannot be applied, unapplied, or transferred.  The value `false` indicates this is an ordinary payment that is created, processed, and settled in Zuora. ")

  public Boolean getStandalone() {
    return standalone;
  }


  public void setStandalone(Boolean standalone) {
    
    
    
    this.standalone = standalone;
  }


  public GETARPaymentTypewithSuccess status(StatusEnum status) {
    
    
    
    
    this.status = status;
    return this;
  }

   /**
   * The status of the payment. 
   * @return status
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The status of the payment. ")

  public StatusEnum getStatus() {
    return status;
  }


  public void setStatus(StatusEnum status) {
    
    
    
    this.status = status;
  }


  public GETARPaymentTypewithSuccess submittedOn(OffsetDateTime submittedOn) {
    
    
    
    
    this.submittedOn = submittedOn;
    return this;
  }

   /**
   * The date and time when the payment was submitted, in &#x60;yyyy-mm-dd hh:mm:ss&#x60; format. 
   * @return submittedOn
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The date and time when the payment was submitted, in `yyyy-mm-dd hh:mm:ss` format. ")

  public OffsetDateTime getSubmittedOn() {
    return submittedOn;
  }


  public void setSubmittedOn(OffsetDateTime submittedOn) {
    
    
    
    this.submittedOn = submittedOn;
  }


  public GETARPaymentTypewithSuccess type(TypeEnum type) {
    
    
    
    
    this.type = type;
    return this;
  }

   /**
   * The type of the payment. 
   * @return type
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The type of the payment. ")

  public TypeEnum getType() {
    return type;
  }


  public void setType(TypeEnum type) {
    
    
    
    this.type = type;
  }


  public GETARPaymentTypewithSuccess unappliedAmount(Double unappliedAmount) {
    
    
    
    
    this.unappliedAmount = unappliedAmount;
    return this;
  }

   /**
   * The unapplied amount of the payment. 
   * @return unappliedAmount
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The unapplied amount of the payment. ")

  public Double getUnappliedAmount() {
    return unappliedAmount;
  }


  public void setUnappliedAmount(Double unappliedAmount) {
    
    
    
    this.unappliedAmount = unappliedAmount;
  }


  public GETARPaymentTypewithSuccess updatedById(String updatedById) {
    
    
    
    
    this.updatedById = updatedById;
    return this;
  }

   /**
   * The ID of the Zuora user who last updated the payment. 
   * @return updatedById
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The ID of the Zuora user who last updated the payment. ")

  public String getUpdatedById() {
    return updatedById;
  }


  public void setUpdatedById(String updatedById) {
    
    
    
    this.updatedById = updatedById;
  }


  public GETARPaymentTypewithSuccess updatedDate(OffsetDateTime updatedDate) {
    
    
    
    
    this.updatedDate = updatedDate;
    return this;
  }

   /**
   * The date and time when the payment was last updated, in &#x60;yyyy-mm-dd hh:mm:ss&#x60; format. For example, 2017-03-02 15:36:10. 
   * @return updatedDate
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The date and time when the payment was last updated, in `yyyy-mm-dd hh:mm:ss` format. For example, 2017-03-02 15:36:10. ")

  public OffsetDateTime getUpdatedDate() {
    return updatedDate;
  }


  public void setUpdatedDate(OffsetDateTime updatedDate) {
    
    
    
    this.updatedDate = updatedDate;
  }


  public GETARPaymentTypewithSuccess integrationIdNS(String integrationIdNS) {
    
    
    
    
    this.integrationIdNS = integrationIdNS;
    return this;
  }

   /**
   * ID of the corresponding object in NetSuite. Only available if you have installed the [Zuora Connector for NetSuite](https://www.zuora.com/connect/app/?appId&#x3D;265). 
   * @return integrationIdNS
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "ID of the corresponding object in NetSuite. Only available if you have installed the [Zuora Connector for NetSuite](https://www.zuora.com/connect/app/?appId=265). ")

  public String getIntegrationIdNS() {
    return integrationIdNS;
  }


  public void setIntegrationIdNS(String integrationIdNS) {
    
    
    
    this.integrationIdNS = integrationIdNS;
  }


  public GETARPaymentTypewithSuccess integrationStatusNS(String integrationStatusNS) {
    
    
    
    
    this.integrationStatusNS = integrationStatusNS;
    return this;
  }

   /**
   * Status of the payment&#39;s synchronization with NetSuite. Only available if you have installed the [Zuora Connector for NetSuite](https://www.zuora.com/connect/app/?appId&#x3D;265). 
   * @return integrationStatusNS
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Status of the payment's synchronization with NetSuite. Only available if you have installed the [Zuora Connector for NetSuite](https://www.zuora.com/connect/app/?appId=265). ")

  public String getIntegrationStatusNS() {
    return integrationStatusNS;
  }


  public void setIntegrationStatusNS(String integrationStatusNS) {
    
    
    
    this.integrationStatusNS = integrationStatusNS;
  }


  public GETARPaymentTypewithSuccess originNS(String originNS) {
    
    
    
    
    this.originNS = originNS;
    return this;
  }

   /**
   * Origin of the corresponding object in NetSuite. Only available if you have installed the [Zuora Connector for NetSuite](https://www.zuora.com/connect/app/?appId&#x3D;265). 
   * @return originNS
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Origin of the corresponding object in NetSuite. Only available if you have installed the [Zuora Connector for NetSuite](https://www.zuora.com/connect/app/?appId=265). ")

  public String getOriginNS() {
    return originNS;
  }


  public void setOriginNS(String originNS) {
    
    
    
    this.originNS = originNS;
  }


  public GETARPaymentTypewithSuccess syncDateNS(String syncDateNS) {
    
    
    
    
    this.syncDateNS = syncDateNS;
    return this;
  }

   /**
   * Date when the payment was synchronized with NetSuite. Only available if you have installed the [Zuora Connector for NetSuite](https://www.zuora.com/connect/app/?appId&#x3D;265). 
   * @return syncDateNS
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Date when the payment was synchronized with NetSuite. Only available if you have installed the [Zuora Connector for NetSuite](https://www.zuora.com/connect/app/?appId=265). ")

  public String getSyncDateNS() {
    return syncDateNS;
  }


  public void setSyncDateNS(String syncDateNS) {
    
    
    
    this.syncDateNS = syncDateNS;
  }


  public GETARPaymentTypewithSuccess transactionNS(String transactionNS) {
    
    
    
    
    this.transactionNS = transactionNS;
    return this;
  }

   /**
   * Related transaction in NetSuite. Only available if you have installed the [Zuora Connector for NetSuite](https://www.zuora.com/connect/app/?appId&#x3D;265). 
   * @return transactionNS
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Related transaction in NetSuite. Only available if you have installed the [Zuora Connector for NetSuite](https://www.zuora.com/connect/app/?appId=265). ")

  public String getTransactionNS() {
    return transactionNS;
  }


  public void setTransactionNS(String transactionNS) {
    
    
    
    this.transactionNS = transactionNS;
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
   * @return the GETARPaymentTypewithSuccess instance itself
   */
  public GETARPaymentTypewithSuccess putAdditionalProperty(String key, Object value) {
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
    GETARPaymentTypewithSuccess geTARPaymentTypewithSuccess = (GETARPaymentTypewithSuccess) o;
    return Objects.equals(this.accountId, geTARPaymentTypewithSuccess.accountId) &&
        Objects.equals(this.accountNumber, geTARPaymentTypewithSuccess.accountNumber) &&
        Objects.equals(this.amount, geTARPaymentTypewithSuccess.amount) &&
        Objects.equals(this.appliedAmount, geTARPaymentTypewithSuccess.appliedAmount) &&
        Objects.equals(this.authTransactionId, geTARPaymentTypewithSuccess.authTransactionId) &&
        Objects.equals(this.bankIdentificationNumber, geTARPaymentTypewithSuccess.bankIdentificationNumber) &&
        Objects.equals(this.cancelledOn, geTARPaymentTypewithSuccess.cancelledOn) &&
        Objects.equals(this.comment, geTARPaymentTypewithSuccess.comment) &&
        Objects.equals(this.createdById, geTARPaymentTypewithSuccess.createdById) &&
        Objects.equals(this.createdDate, geTARPaymentTypewithSuccess.createdDate) &&
        Objects.equals(this.creditBalanceAmount, geTARPaymentTypewithSuccess.creditBalanceAmount) &&
        Objects.equals(this.currency, geTARPaymentTypewithSuccess.currency) &&
        Objects.equals(this.effectiveDate, geTARPaymentTypewithSuccess.effectiveDate) &&
        Objects.equals(this.financeInformation, geTARPaymentTypewithSuccess.financeInformation) &&
        Objects.equals(this.gatewayId, geTARPaymentTypewithSuccess.gatewayId) &&
        Objects.equals(this.gatewayOrderId, geTARPaymentTypewithSuccess.gatewayOrderId) &&
        Objects.equals(this.gatewayReconciliationReason, geTARPaymentTypewithSuccess.gatewayReconciliationReason) &&
        Objects.equals(this.gatewayReconciliationStatus, geTARPaymentTypewithSuccess.gatewayReconciliationStatus) &&
        Objects.equals(this.gatewayResponse, geTARPaymentTypewithSuccess.gatewayResponse) &&
        Objects.equals(this.gatewayResponseCode, geTARPaymentTypewithSuccess.gatewayResponseCode) &&
        Objects.equals(this.gatewayState, geTARPaymentTypewithSuccess.gatewayState) &&
        Objects.equals(this.id, geTARPaymentTypewithSuccess.id) &&
        Objects.equals(this.markedForSubmissionOn, geTARPaymentTypewithSuccess.markedForSubmissionOn) &&
        Objects.equals(this.number, geTARPaymentTypewithSuccess.number) &&
        Objects.equals(this.organizationLabel, geTARPaymentTypewithSuccess.organizationLabel) &&
        Objects.equals(this.paymentGatewayNumber, geTARPaymentTypewithSuccess.paymentGatewayNumber) &&
        Objects.equals(this.paymentMethodId, geTARPaymentTypewithSuccess.paymentMethodId) &&
        Objects.equals(this.paymentMethodSnapshotId, geTARPaymentTypewithSuccess.paymentMethodSnapshotId) &&
        Objects.equals(this.paymentOption, geTARPaymentTypewithSuccess.paymentOption) &&
        Objects.equals(this.paymentScheduleKey, geTARPaymentTypewithSuccess.paymentScheduleKey) &&
        Objects.equals(this.payoutId, geTARPaymentTypewithSuccess.payoutId) &&
        Objects.equals(this.prepayment, geTARPaymentTypewithSuccess.prepayment) &&
        Objects.equals(this.referenceId, geTARPaymentTypewithSuccess.referenceId) &&
        Objects.equals(this.refundAmount, geTARPaymentTypewithSuccess.refundAmount) &&
        Objects.equals(this.secondPaymentReferenceId, geTARPaymentTypewithSuccess.secondPaymentReferenceId) &&
        Objects.equals(this.settledOn, geTARPaymentTypewithSuccess.settledOn) &&
        Objects.equals(this.softDescriptor, geTARPaymentTypewithSuccess.softDescriptor) &&
        Objects.equals(this.softDescriptorPhone, geTARPaymentTypewithSuccess.softDescriptorPhone) &&
        Objects.equals(this.standalone, geTARPaymentTypewithSuccess.standalone) &&
        Objects.equals(this.status, geTARPaymentTypewithSuccess.status) &&
        Objects.equals(this.submittedOn, geTARPaymentTypewithSuccess.submittedOn) &&
        Objects.equals(this.type, geTARPaymentTypewithSuccess.type) &&
        Objects.equals(this.unappliedAmount, geTARPaymentTypewithSuccess.unappliedAmount) &&
        Objects.equals(this.updatedById, geTARPaymentTypewithSuccess.updatedById) &&
        Objects.equals(this.updatedDate, geTARPaymentTypewithSuccess.updatedDate) &&
        Objects.equals(this.integrationIdNS, geTARPaymentTypewithSuccess.integrationIdNS) &&
        Objects.equals(this.integrationStatusNS, geTARPaymentTypewithSuccess.integrationStatusNS) &&
        Objects.equals(this.originNS, geTARPaymentTypewithSuccess.originNS) &&
        Objects.equals(this.syncDateNS, geTARPaymentTypewithSuccess.syncDateNS) &&
        Objects.equals(this.transactionNS, geTARPaymentTypewithSuccess.transactionNS)&&
        Objects.equals(this.additionalProperties, geTARPaymentTypewithSuccess.additionalProperties);
  }

  @Override
  public int hashCode() {
    return Objects.hash(accountId, accountNumber, amount, appliedAmount, authTransactionId, bankIdentificationNumber, cancelledOn, comment, createdById, createdDate, creditBalanceAmount, currency, effectiveDate, financeInformation, gatewayId, gatewayOrderId, gatewayReconciliationReason, gatewayReconciliationStatus, gatewayResponse, gatewayResponseCode, gatewayState, id, markedForSubmissionOn, number, organizationLabel, paymentGatewayNumber, paymentMethodId, paymentMethodSnapshotId, paymentOption, paymentScheduleKey, payoutId, prepayment, referenceId, refundAmount, secondPaymentReferenceId, settledOn, softDescriptor, softDescriptorPhone, standalone, status, submittedOn, type, unappliedAmount, updatedById, updatedDate, integrationIdNS, integrationStatusNS, originNS, syncDateNS, transactionNS, additionalProperties);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GETARPaymentTypewithSuccess {\n");
    sb.append("    accountId: ").append(toIndentedString(accountId)).append("\n");
    sb.append("    accountNumber: ").append(toIndentedString(accountNumber)).append("\n");
    sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
    sb.append("    appliedAmount: ").append(toIndentedString(appliedAmount)).append("\n");
    sb.append("    authTransactionId: ").append(toIndentedString(authTransactionId)).append("\n");
    sb.append("    bankIdentificationNumber: ").append(toIndentedString(bankIdentificationNumber)).append("\n");
    sb.append("    cancelledOn: ").append(toIndentedString(cancelledOn)).append("\n");
    sb.append("    comment: ").append(toIndentedString(comment)).append("\n");
    sb.append("    createdById: ").append(toIndentedString(createdById)).append("\n");
    sb.append("    createdDate: ").append(toIndentedString(createdDate)).append("\n");
    sb.append("    creditBalanceAmount: ").append(toIndentedString(creditBalanceAmount)).append("\n");
    sb.append("    currency: ").append(toIndentedString(currency)).append("\n");
    sb.append("    effectiveDate: ").append(toIndentedString(effectiveDate)).append("\n");
    sb.append("    financeInformation: ").append(toIndentedString(financeInformation)).append("\n");
    sb.append("    gatewayId: ").append(toIndentedString(gatewayId)).append("\n");
    sb.append("    gatewayOrderId: ").append(toIndentedString(gatewayOrderId)).append("\n");
    sb.append("    gatewayReconciliationReason: ").append(toIndentedString(gatewayReconciliationReason)).append("\n");
    sb.append("    gatewayReconciliationStatus: ").append(toIndentedString(gatewayReconciliationStatus)).append("\n");
    sb.append("    gatewayResponse: ").append(toIndentedString(gatewayResponse)).append("\n");
    sb.append("    gatewayResponseCode: ").append(toIndentedString(gatewayResponseCode)).append("\n");
    sb.append("    gatewayState: ").append(toIndentedString(gatewayState)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    markedForSubmissionOn: ").append(toIndentedString(markedForSubmissionOn)).append("\n");
    sb.append("    number: ").append(toIndentedString(number)).append("\n");
    sb.append("    organizationLabel: ").append(toIndentedString(organizationLabel)).append("\n");
    sb.append("    paymentGatewayNumber: ").append(toIndentedString(paymentGatewayNumber)).append("\n");
    sb.append("    paymentMethodId: ").append(toIndentedString(paymentMethodId)).append("\n");
    sb.append("    paymentMethodSnapshotId: ").append(toIndentedString(paymentMethodSnapshotId)).append("\n");
    sb.append("    paymentOption: ").append(toIndentedString(paymentOption)).append("\n");
    sb.append("    paymentScheduleKey: ").append(toIndentedString(paymentScheduleKey)).append("\n");
    sb.append("    payoutId: ").append(toIndentedString(payoutId)).append("\n");
    sb.append("    prepayment: ").append(toIndentedString(prepayment)).append("\n");
    sb.append("    referenceId: ").append(toIndentedString(referenceId)).append("\n");
    sb.append("    refundAmount: ").append(toIndentedString(refundAmount)).append("\n");
    sb.append("    secondPaymentReferenceId: ").append(toIndentedString(secondPaymentReferenceId)).append("\n");
    sb.append("    settledOn: ").append(toIndentedString(settledOn)).append("\n");
    sb.append("    softDescriptor: ").append(toIndentedString(softDescriptor)).append("\n");
    sb.append("    softDescriptorPhone: ").append(toIndentedString(softDescriptorPhone)).append("\n");
    sb.append("    standalone: ").append(toIndentedString(standalone)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    submittedOn: ").append(toIndentedString(submittedOn)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    unappliedAmount: ").append(toIndentedString(unappliedAmount)).append("\n");
    sb.append("    updatedById: ").append(toIndentedString(updatedById)).append("\n");
    sb.append("    updatedDate: ").append(toIndentedString(updatedDate)).append("\n");
    sb.append("    integrationIdNS: ").append(toIndentedString(integrationIdNS)).append("\n");
    sb.append("    integrationStatusNS: ").append(toIndentedString(integrationStatusNS)).append("\n");
    sb.append("    originNS: ").append(toIndentedString(originNS)).append("\n");
    sb.append("    syncDateNS: ").append(toIndentedString(syncDateNS)).append("\n");
    sb.append("    transactionNS: ").append(toIndentedString(transactionNS)).append("\n");
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
    openapiFields.add("appliedAmount");
    openapiFields.add("authTransactionId");
    openapiFields.add("bankIdentificationNumber");
    openapiFields.add("cancelledOn");
    openapiFields.add("comment");
    openapiFields.add("createdById");
    openapiFields.add("createdDate");
    openapiFields.add("creditBalanceAmount");
    openapiFields.add("currency");
    openapiFields.add("effectiveDate");
    openapiFields.add("financeInformation");
    openapiFields.add("gatewayId");
    openapiFields.add("gatewayOrderId");
    openapiFields.add("gatewayReconciliationReason");
    openapiFields.add("gatewayReconciliationStatus");
    openapiFields.add("gatewayResponse");
    openapiFields.add("gatewayResponseCode");
    openapiFields.add("gatewayState");
    openapiFields.add("id");
    openapiFields.add("markedForSubmissionOn");
    openapiFields.add("number");
    openapiFields.add("organizationLabel");
    openapiFields.add("paymentGatewayNumber");
    openapiFields.add("paymentMethodId");
    openapiFields.add("paymentMethodSnapshotId");
    openapiFields.add("paymentOption");
    openapiFields.add("paymentScheduleKey");
    openapiFields.add("payoutId");
    openapiFields.add("prepayment");
    openapiFields.add("referenceId");
    openapiFields.add("refundAmount");
    openapiFields.add("secondPaymentReferenceId");
    openapiFields.add("settledOn");
    openapiFields.add("softDescriptor");
    openapiFields.add("softDescriptorPhone");
    openapiFields.add("standalone");
    openapiFields.add("status");
    openapiFields.add("submittedOn");
    openapiFields.add("type");
    openapiFields.add("unappliedAmount");
    openapiFields.add("updatedById");
    openapiFields.add("updatedDate");
    openapiFields.add("IntegrationId__NS");
    openapiFields.add("IntegrationStatus__NS");
    openapiFields.add("Origin__NS");
    openapiFields.add("SyncDate__NS");
    openapiFields.add("Transaction__NS");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
  }

 /**
  * Validates the JSON Object and throws an exception if issues found
  *
  * @param jsonObj JSON Object
  * @throws IOException if the JSON Object is invalid with respect to GETARPaymentTypewithSuccess
  */
  public static void validateJsonObject(JsonObject jsonObj) throws IOException {
      if (jsonObj == null) {
        if (!GETARPaymentTypewithSuccess.openapiRequiredFields.isEmpty()) { // has required fields but JSON object is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in GETARPaymentTypewithSuccess is not found in the empty JSON string", GETARPaymentTypewithSuccess.openapiRequiredFields.toString()));
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
      if ((jsonObj.get("bankIdentificationNumber") != null && !jsonObj.get("bankIdentificationNumber").isJsonNull()) && !jsonObj.get("bankIdentificationNumber").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `bankIdentificationNumber` to be a primitive type in the JSON string but got `%s`", jsonObj.get("bankIdentificationNumber").toString()));
      }
      if ((jsonObj.get("comment") != null && !jsonObj.get("comment").isJsonNull()) && !jsonObj.get("comment").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `comment` to be a primitive type in the JSON string but got `%s`", jsonObj.get("comment").toString()));
      }
      if ((jsonObj.get("createdById") != null && !jsonObj.get("createdById").isJsonNull()) && !jsonObj.get("createdById").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `createdById` to be a primitive type in the JSON string but got `%s`", jsonObj.get("createdById").toString()));
      }
      if ((jsonObj.get("currency") != null && !jsonObj.get("currency").isJsonNull()) && !jsonObj.get("currency").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `currency` to be a primitive type in the JSON string but got `%s`", jsonObj.get("currency").toString()));
      }
      // validate the optional field `financeInformation`
      if (jsonObj.get("financeInformation") != null && !jsonObj.get("financeInformation").isJsonNull()) {
        GETARPaymentTypewithSuccessAllOfFinanceInformation.validateJsonObject(jsonObj.getAsJsonObject("financeInformation"));
      }
      if ((jsonObj.get("gatewayId") != null && !jsonObj.get("gatewayId").isJsonNull()) && !jsonObj.get("gatewayId").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `gatewayId` to be a primitive type in the JSON string but got `%s`", jsonObj.get("gatewayId").toString()));
      }
      if ((jsonObj.get("gatewayOrderId") != null && !jsonObj.get("gatewayOrderId").isJsonNull()) && !jsonObj.get("gatewayOrderId").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `gatewayOrderId` to be a primitive type in the JSON string but got `%s`", jsonObj.get("gatewayOrderId").toString()));
      }
      if ((jsonObj.get("gatewayReconciliationReason") != null && !jsonObj.get("gatewayReconciliationReason").isJsonNull()) && !jsonObj.get("gatewayReconciliationReason").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `gatewayReconciliationReason` to be a primitive type in the JSON string but got `%s`", jsonObj.get("gatewayReconciliationReason").toString()));
      }
      if ((jsonObj.get("gatewayReconciliationStatus") != null && !jsonObj.get("gatewayReconciliationStatus").isJsonNull()) && !jsonObj.get("gatewayReconciliationStatus").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `gatewayReconciliationStatus` to be a primitive type in the JSON string but got `%s`", jsonObj.get("gatewayReconciliationStatus").toString()));
      }
      if ((jsonObj.get("gatewayResponse") != null && !jsonObj.get("gatewayResponse").isJsonNull()) && !jsonObj.get("gatewayResponse").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `gatewayResponse` to be a primitive type in the JSON string but got `%s`", jsonObj.get("gatewayResponse").toString()));
      }
      if ((jsonObj.get("gatewayResponseCode") != null && !jsonObj.get("gatewayResponseCode").isJsonNull()) && !jsonObj.get("gatewayResponseCode").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `gatewayResponseCode` to be a primitive type in the JSON string but got `%s`", jsonObj.get("gatewayResponseCode").toString()));
      }
      if ((jsonObj.get("gatewayState") != null && !jsonObj.get("gatewayState").isJsonNull()) && !jsonObj.get("gatewayState").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `gatewayState` to be a primitive type in the JSON string but got `%s`", jsonObj.get("gatewayState").toString()));
      }
      if ((jsonObj.get("id") != null && !jsonObj.get("id").isJsonNull()) && !jsonObj.get("id").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `id` to be a primitive type in the JSON string but got `%s`", jsonObj.get("id").toString()));
      }
      if ((jsonObj.get("number") != null && !jsonObj.get("number").isJsonNull()) && !jsonObj.get("number").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `number` to be a primitive type in the JSON string but got `%s`", jsonObj.get("number").toString()));
      }
      if ((jsonObj.get("organizationLabel") != null && !jsonObj.get("organizationLabel").isJsonNull()) && !jsonObj.get("organizationLabel").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `organizationLabel` to be a primitive type in the JSON string but got `%s`", jsonObj.get("organizationLabel").toString()));
      }
      if ((jsonObj.get("paymentGatewayNumber") != null && !jsonObj.get("paymentGatewayNumber").isJsonNull()) && !jsonObj.get("paymentGatewayNumber").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `paymentGatewayNumber` to be a primitive type in the JSON string but got `%s`", jsonObj.get("paymentGatewayNumber").toString()));
      }
      if ((jsonObj.get("paymentMethodId") != null && !jsonObj.get("paymentMethodId").isJsonNull()) && !jsonObj.get("paymentMethodId").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `paymentMethodId` to be a primitive type in the JSON string but got `%s`", jsonObj.get("paymentMethodId").toString()));
      }
      if ((jsonObj.get("paymentMethodSnapshotId") != null && !jsonObj.get("paymentMethodSnapshotId").isJsonNull()) && !jsonObj.get("paymentMethodSnapshotId").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `paymentMethodSnapshotId` to be a primitive type in the JSON string but got `%s`", jsonObj.get("paymentMethodSnapshotId").toString()));
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
      if ((jsonObj.get("payoutId") != null && !jsonObj.get("payoutId").isJsonNull()) && !jsonObj.get("payoutId").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `payoutId` to be a primitive type in the JSON string but got `%s`", jsonObj.get("payoutId").toString()));
      }
      if ((jsonObj.get("referenceId") != null && !jsonObj.get("referenceId").isJsonNull()) && !jsonObj.get("referenceId").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `referenceId` to be a primitive type in the JSON string but got `%s`", jsonObj.get("referenceId").toString()));
      }
      if ((jsonObj.get("secondPaymentReferenceId") != null && !jsonObj.get("secondPaymentReferenceId").isJsonNull()) && !jsonObj.get("secondPaymentReferenceId").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `secondPaymentReferenceId` to be a primitive type in the JSON string but got `%s`", jsonObj.get("secondPaymentReferenceId").toString()));
      }
      if ((jsonObj.get("softDescriptor") != null && !jsonObj.get("softDescriptor").isJsonNull()) && !jsonObj.get("softDescriptor").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `softDescriptor` to be a primitive type in the JSON string but got `%s`", jsonObj.get("softDescriptor").toString()));
      }
      if ((jsonObj.get("softDescriptorPhone") != null && !jsonObj.get("softDescriptorPhone").isJsonNull()) && !jsonObj.get("softDescriptorPhone").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `softDescriptorPhone` to be a primitive type in the JSON string but got `%s`", jsonObj.get("softDescriptorPhone").toString()));
      }
      if ((jsonObj.get("status") != null && !jsonObj.get("status").isJsonNull()) && !jsonObj.get("status").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `status` to be a primitive type in the JSON string but got `%s`", jsonObj.get("status").toString()));
      }
      if ((jsonObj.get("type") != null && !jsonObj.get("type").isJsonNull()) && !jsonObj.get("type").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `type` to be a primitive type in the JSON string but got `%s`", jsonObj.get("type").toString()));
      }
      if ((jsonObj.get("updatedById") != null && !jsonObj.get("updatedById").isJsonNull()) && !jsonObj.get("updatedById").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `updatedById` to be a primitive type in the JSON string but got `%s`", jsonObj.get("updatedById").toString()));
      }
      if ((jsonObj.get("IntegrationId__NS") != null && !jsonObj.get("IntegrationId__NS").isJsonNull()) && !jsonObj.get("IntegrationId__NS").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `IntegrationId__NS` to be a primitive type in the JSON string but got `%s`", jsonObj.get("IntegrationId__NS").toString()));
      }
      if ((jsonObj.get("IntegrationStatus__NS") != null && !jsonObj.get("IntegrationStatus__NS").isJsonNull()) && !jsonObj.get("IntegrationStatus__NS").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `IntegrationStatus__NS` to be a primitive type in the JSON string but got `%s`", jsonObj.get("IntegrationStatus__NS").toString()));
      }
      if ((jsonObj.get("Origin__NS") != null && !jsonObj.get("Origin__NS").isJsonNull()) && !jsonObj.get("Origin__NS").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `Origin__NS` to be a primitive type in the JSON string but got `%s`", jsonObj.get("Origin__NS").toString()));
      }
      if ((jsonObj.get("SyncDate__NS") != null && !jsonObj.get("SyncDate__NS").isJsonNull()) && !jsonObj.get("SyncDate__NS").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `SyncDate__NS` to be a primitive type in the JSON string but got `%s`", jsonObj.get("SyncDate__NS").toString()));
      }
      if ((jsonObj.get("Transaction__NS") != null && !jsonObj.get("Transaction__NS").isJsonNull()) && !jsonObj.get("Transaction__NS").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `Transaction__NS` to be a primitive type in the JSON string but got `%s`", jsonObj.get("Transaction__NS").toString()));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!GETARPaymentTypewithSuccess.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'GETARPaymentTypewithSuccess' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<GETARPaymentTypewithSuccess> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(GETARPaymentTypewithSuccess.class));

       return (TypeAdapter<T>) new TypeAdapter<GETARPaymentTypewithSuccess>() {
           @Override
           public void write(JsonWriter out, GETARPaymentTypewithSuccess value) throws IOException {
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
           public GETARPaymentTypewithSuccess read(JsonReader in) throws IOException {
             JsonObject jsonObj = elementAdapter.read(in).getAsJsonObject();
             validateJsonObject(jsonObj);
             // store additional fields in the deserialized instance
             GETARPaymentTypewithSuccess instance = thisAdapter.fromJsonTree(jsonObj);
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
  * Create an instance of GETARPaymentTypewithSuccess given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of GETARPaymentTypewithSuccess
  * @throws IOException if the JSON string is invalid with respect to GETARPaymentTypewithSuccess
  */
  public static GETARPaymentTypewithSuccess fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, GETARPaymentTypewithSuccess.class);
  }

 /**
  * Convert an instance of GETARPaymentTypewithSuccess to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

