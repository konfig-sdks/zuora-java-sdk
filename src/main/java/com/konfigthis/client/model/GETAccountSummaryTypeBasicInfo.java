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
import com.konfigthis.client.model.GETAccountSummaryTypeBasicInfoAllOfDefaultPaymentMethod;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
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
 * Container for basic information about the account. 
 */
@ApiModel(description = "Container for basic information about the account. ")@javax.annotation.Generated(value = "Generated by https://konfigthis.com")
public class GETAccountSummaryTypeBasicInfo {
  public static final String SERIALIZED_NAME_TAGS = "tags";
  @SerializedName(SERIALIZED_NAME_TAGS)
  private String tags;

  public static final String SERIALIZED_NAME_ACCOUNT_NUMBER = "accountNumber";
  @SerializedName(SERIALIZED_NAME_ACCOUNT_NUMBER)
  private String accountNumber;

  public static final String SERIALIZED_NAME_ADDITIONAL_EMAIL_ADDRESSES = "additionalEmailAddresses";
  @SerializedName(SERIALIZED_NAME_ADDITIONAL_EMAIL_ADDRESSES)
  private List<String> additionalEmailAddresses = null;

  public static final String SERIALIZED_NAME_AUTO_PAY = "autoPay";
  @SerializedName(SERIALIZED_NAME_AUTO_PAY)
  private Boolean autoPay;

  public static final String SERIALIZED_NAME_BALANCE = "balance";
  @SerializedName(SERIALIZED_NAME_BALANCE)
  private BigDecimal balance;

  public static final String SERIALIZED_NAME_BATCH = "batch";
  @SerializedName(SERIALIZED_NAME_BATCH)
  private String batch;

  public static final String SERIALIZED_NAME_BILL_CYCLE_DAY = "billCycleDay";
  @SerializedName(SERIALIZED_NAME_BILL_CYCLE_DAY)
  private String billCycleDay;

  public static final String SERIALIZED_NAME_CURRENCY = "currency";
  @SerializedName(SERIALIZED_NAME_CURRENCY)
  private String currency;

  public static final String SERIALIZED_NAME_DEFAULT_PAYMENT_METHOD = "defaultPaymentMethod";
  @SerializedName(SERIALIZED_NAME_DEFAULT_PAYMENT_METHOD)
  private GETAccountSummaryTypeBasicInfoAllOfDefaultPaymentMethod defaultPaymentMethod;

  public static final String SERIALIZED_NAME_ID = "id";
  @SerializedName(SERIALIZED_NAME_ID)
  private String id;

  public static final String SERIALIZED_NAME_INVOICE_DELIVERY_PREFS_EMAIL = "invoiceDeliveryPrefsEmail";
  @SerializedName(SERIALIZED_NAME_INVOICE_DELIVERY_PREFS_EMAIL)
  private Boolean invoiceDeliveryPrefsEmail;

  public static final String SERIALIZED_NAME_INVOICE_DELIVERY_PREFS_PRINT = "invoiceDeliveryPrefsPrint";
  @SerializedName(SERIALIZED_NAME_INVOICE_DELIVERY_PREFS_PRINT)
  private Boolean invoiceDeliveryPrefsPrint;

  public static final String SERIALIZED_NAME_LAST_INVOICE_DATE = "lastInvoiceDate";
  @SerializedName(SERIALIZED_NAME_LAST_INVOICE_DATE)
  private LocalDate lastInvoiceDate;

  public static final String SERIALIZED_NAME_LAST_METRICS_UPDATE = "lastMetricsUpdate";
  @SerializedName(SERIALIZED_NAME_LAST_METRICS_UPDATE)
  private OffsetDateTime lastMetricsUpdate;

  public static final String SERIALIZED_NAME_LAST_PAYMENT_AMOUNT = "lastPaymentAmount";
  @SerializedName(SERIALIZED_NAME_LAST_PAYMENT_AMOUNT)
  private BigDecimal lastPaymentAmount;

  public static final String SERIALIZED_NAME_LAST_PAYMENT_DATE = "lastPaymentDate";
  @SerializedName(SERIALIZED_NAME_LAST_PAYMENT_DATE)
  private LocalDate lastPaymentDate;

  public static final String SERIALIZED_NAME_NAME = "name";
  @SerializedName(SERIALIZED_NAME_NAME)
  private String name;

  public static final String SERIALIZED_NAME_ORGANIZATION_LABEL = "organizationLabel";
  @SerializedName(SERIALIZED_NAME_ORGANIZATION_LABEL)
  private String organizationLabel;

  public static final String SERIALIZED_NAME_PARTNER_ACCOUNT = "partnerAccount";
  @SerializedName(SERIALIZED_NAME_PARTNER_ACCOUNT)
  private Boolean partnerAccount;

  public static final String SERIALIZED_NAME_PURCHASE_ORDER_NUMBER = "purchaseOrderNumber";
  @SerializedName(SERIALIZED_NAME_PURCHASE_ORDER_NUMBER)
  private String purchaseOrderNumber;

  public static final String SERIALIZED_NAME_STATUS = "status";
  @SerializedName(SERIALIZED_NAME_STATUS)
  private String status;

  public static final String SERIALIZED_NAME_CLASS_N_S = "Class__NS";
  @SerializedName(SERIALIZED_NAME_CLASS_N_S)
  private String classNS;

  /**
   * Value of the Customer Type field for the corresponding customer account in NetSuite. The Customer Type field is used when the customer account is created in NetSuite. Only available if you have installed the [Zuora Connector for NetSuite](https://www.zuora.com/connect/app/?appId&#x3D;265). 
   */
  @JsonAdapter(CustomerTypeNSEnum.Adapter.class)
 public enum CustomerTypeNSEnum {
    COMPANY("Company"),
    
    INDIVIDUAL("Individual");

    private String value;

    CustomerTypeNSEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static CustomerTypeNSEnum fromValue(String value) {
      for (CustomerTypeNSEnum b : CustomerTypeNSEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<CustomerTypeNSEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final CustomerTypeNSEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public CustomerTypeNSEnum read(final JsonReader jsonReader) throws IOException {
        String value =  jsonReader.nextString();
        return CustomerTypeNSEnum.fromValue(value);
      }
    }
  }

  public static final String SERIALIZED_NAME_CUSTOMER_TYPE_N_S = "CustomerType__NS";
  @SerializedName(SERIALIZED_NAME_CUSTOMER_TYPE_N_S)
  private CustomerTypeNSEnum customerTypeNS;

  public static final String SERIALIZED_NAME_DEPARTMENT_N_S = "Department__NS";
  @SerializedName(SERIALIZED_NAME_DEPARTMENT_N_S)
  private String departmentNS;

  public static final String SERIALIZED_NAME_INTEGRATION_ID_N_S = "IntegrationId__NS";
  @SerializedName(SERIALIZED_NAME_INTEGRATION_ID_N_S)
  private String integrationIdNS;

  public static final String SERIALIZED_NAME_INTEGRATION_STATUS_N_S = "IntegrationStatus__NS";
  @SerializedName(SERIALIZED_NAME_INTEGRATION_STATUS_N_S)
  private String integrationStatusNS;

  public static final String SERIALIZED_NAME_LOCATION_N_S = "Location__NS";
  @SerializedName(SERIALIZED_NAME_LOCATION_N_S)
  private String locationNS;

  public static final String SERIALIZED_NAME_SUBSIDIARY_N_S = "Subsidiary__NS";
  @SerializedName(SERIALIZED_NAME_SUBSIDIARY_N_S)
  private String subsidiaryNS;

  public static final String SERIALIZED_NAME_SYNC_DATE_N_S = "SyncDate__NS";
  @SerializedName(SERIALIZED_NAME_SYNC_DATE_N_S)
  private String syncDateNS;

  /**
   * Specifies whether the account should be synchronized with NetSuite. Only available if you have installed the [Zuora Connector for NetSuite](https://www.zuora.com/connect/app/?appId&#x3D;265). 
   */
  @JsonAdapter(SynctoNetSuiteNSEnum.Adapter.class)
 public enum SynctoNetSuiteNSEnum {
    TRUE("true"),
    
    FALSE("false");

    private String value;

    SynctoNetSuiteNSEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static SynctoNetSuiteNSEnum fromValue(String value) {
      for (SynctoNetSuiteNSEnum b : SynctoNetSuiteNSEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<SynctoNetSuiteNSEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final SynctoNetSuiteNSEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public SynctoNetSuiteNSEnum read(final JsonReader jsonReader) throws IOException {
        String value =  jsonReader.nextString();
        return SynctoNetSuiteNSEnum.fromValue(value);
      }
    }
  }

  public static final String SERIALIZED_NAME_SYNCTO_NET_SUITE_N_S = "SynctoNetSuite__NS";
  @SerializedName(SERIALIZED_NAME_SYNCTO_NET_SUITE_N_S)
  private SynctoNetSuiteNSEnum synctoNetSuiteNS;

  public GETAccountSummaryTypeBasicInfo() {
  }

  public GETAccountSummaryTypeBasicInfo tags(String tags) {
    
    
    
    
    this.tags = tags;
    return this;
  }

   /**
   * 
   * @return tags
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public String getTags() {
    return tags;
  }


  public void setTags(String tags) {
    
    
    
    this.tags = tags;
  }


  public GETAccountSummaryTypeBasicInfo accountNumber(String accountNumber) {
    
    
    
    
    this.accountNumber = accountNumber;
    return this;
  }

   /**
   * Account number. 
   * @return accountNumber
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Account number. ")

  public String getAccountNumber() {
    return accountNumber;
  }


  public void setAccountNumber(String accountNumber) {
    
    
    
    this.accountNumber = accountNumber;
  }


  public GETAccountSummaryTypeBasicInfo additionalEmailAddresses(List<String> additionalEmailAddresses) {
    
    
    
    
    this.additionalEmailAddresses = additionalEmailAddresses;
    return this;
  }

  public GETAccountSummaryTypeBasicInfo addAdditionalEmailAddressesItem(String additionalEmailAddressesItem) {
    if (this.additionalEmailAddresses == null) {
      this.additionalEmailAddresses = new ArrayList<>();
    }
    this.additionalEmailAddresses.add(additionalEmailAddressesItem);
    return this;
  }

   /**
   * A list of additional email addresses to receive email notifications. 
   * @return additionalEmailAddresses
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "A list of additional email addresses to receive email notifications. ")

  public List<String> getAdditionalEmailAddresses() {
    return additionalEmailAddresses;
  }


  public void setAdditionalEmailAddresses(List<String> additionalEmailAddresses) {
    
    
    
    this.additionalEmailAddresses = additionalEmailAddresses;
  }


  public GETAccountSummaryTypeBasicInfo autoPay(Boolean autoPay) {
    
    
    
    
    this.autoPay = autoPay;
    return this;
  }

   /**
   * Whether future payments are automatically collected when they are due during a payment run. 
   * @return autoPay
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Whether future payments are automatically collected when they are due during a payment run. ")

  public Boolean getAutoPay() {
    return autoPay;
  }


  public void setAutoPay(Boolean autoPay) {
    
    
    
    this.autoPay = autoPay;
  }


  public GETAccountSummaryTypeBasicInfo balance(BigDecimal balance) {
    
    
    
    
    this.balance = balance;
    return this;
  }

   /**
   * Current outstanding balance. 
   * @return balance
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Current outstanding balance. ")

  public BigDecimal getBalance() {
    return balance;
  }


  public void setBalance(BigDecimal balance) {
    
    
    
    this.balance = balance;
  }


  public GETAccountSummaryTypeBasicInfo batch(String batch) {
    
    
    
    
    this.batch = batch;
    return this;
  }

   /**
   * The alias name given to a batch. A string of 50 characters or less. 
   * @return batch
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The alias name given to a batch. A string of 50 characters or less. ")

  public String getBatch() {
    return batch;
  }


  public void setBatch(String batch) {
    
    
    
    this.batch = batch;
  }


  public GETAccountSummaryTypeBasicInfo billCycleDay(String billCycleDay) {
    
    
    
    
    this.billCycleDay = billCycleDay;
    return this;
  }

   /**
   * Billing cycle day (BCD), the day of the month when a bill run generates invoices for the account. 
   * @return billCycleDay
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Billing cycle day (BCD), the day of the month when a bill run generates invoices for the account. ")

  public String getBillCycleDay() {
    return billCycleDay;
  }


  public void setBillCycleDay(String billCycleDay) {
    
    
    
    this.billCycleDay = billCycleDay;
  }


  public GETAccountSummaryTypeBasicInfo currency(String currency) {
    
    
    
    
    this.currency = currency;
    return this;
  }

   /**
   * A currency as defined in Billing Settings in the Zuora UI. 
   * @return currency
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "A currency as defined in Billing Settings in the Zuora UI. ")

  public String getCurrency() {
    return currency;
  }


  public void setCurrency(String currency) {
    
    
    
    this.currency = currency;
  }


  public GETAccountSummaryTypeBasicInfo defaultPaymentMethod(GETAccountSummaryTypeBasicInfoAllOfDefaultPaymentMethod defaultPaymentMethod) {
    
    
    
    
    this.defaultPaymentMethod = defaultPaymentMethod;
    return this;
  }

   /**
   * Get defaultPaymentMethod
   * @return defaultPaymentMethod
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public GETAccountSummaryTypeBasicInfoAllOfDefaultPaymentMethod getDefaultPaymentMethod() {
    return defaultPaymentMethod;
  }


  public void setDefaultPaymentMethod(GETAccountSummaryTypeBasicInfoAllOfDefaultPaymentMethod defaultPaymentMethod) {
    
    
    
    this.defaultPaymentMethod = defaultPaymentMethod;
  }


  public GETAccountSummaryTypeBasicInfo id(String id) {
    
    
    
    
    this.id = id;
    return this;
  }

   /**
   * Account ID. 
   * @return id
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Account ID. ")

  public String getId() {
    return id;
  }


  public void setId(String id) {
    
    
    
    this.id = id;
  }


  public GETAccountSummaryTypeBasicInfo invoiceDeliveryPrefsEmail(Boolean invoiceDeliveryPrefsEmail) {
    
    
    
    
    this.invoiceDeliveryPrefsEmail = invoiceDeliveryPrefsEmail;
    return this;
  }

   /**
   * Whether the customer wants to receive invoices through email.  
   * @return invoiceDeliveryPrefsEmail
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Whether the customer wants to receive invoices through email.  ")

  public Boolean getInvoiceDeliveryPrefsEmail() {
    return invoiceDeliveryPrefsEmail;
  }


  public void setInvoiceDeliveryPrefsEmail(Boolean invoiceDeliveryPrefsEmail) {
    
    
    
    this.invoiceDeliveryPrefsEmail = invoiceDeliveryPrefsEmail;
  }


  public GETAccountSummaryTypeBasicInfo invoiceDeliveryPrefsPrint(Boolean invoiceDeliveryPrefsPrint) {
    
    
    
    
    this.invoiceDeliveryPrefsPrint = invoiceDeliveryPrefsPrint;
    return this;
  }

   /**
   * Whether the customer wants to receive printed invoices, such as through postal mail. 
   * @return invoiceDeliveryPrefsPrint
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Whether the customer wants to receive printed invoices, such as through postal mail. ")

  public Boolean getInvoiceDeliveryPrefsPrint() {
    return invoiceDeliveryPrefsPrint;
  }


  public void setInvoiceDeliveryPrefsPrint(Boolean invoiceDeliveryPrefsPrint) {
    
    
    
    this.invoiceDeliveryPrefsPrint = invoiceDeliveryPrefsPrint;
  }


  public GETAccountSummaryTypeBasicInfo lastInvoiceDate(LocalDate lastInvoiceDate) {
    
    
    
    
    this.lastInvoiceDate = lastInvoiceDate;
    return this;
  }

   /**
   * Date of the most recent invoice for the account; null if no invoice has ever been generated. 
   * @return lastInvoiceDate
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Date of the most recent invoice for the account; null if no invoice has ever been generated. ")

  public LocalDate getLastInvoiceDate() {
    return lastInvoiceDate;
  }


  public void setLastInvoiceDate(LocalDate lastInvoiceDate) {
    
    
    
    this.lastInvoiceDate = lastInvoiceDate;
  }


  public GETAccountSummaryTypeBasicInfo lastMetricsUpdate(OffsetDateTime lastMetricsUpdate) {
    
    
    
    
    this.lastMetricsUpdate = lastMetricsUpdate;
    return this;
  }

   /**
   * The date and time when account metrics are last updated, if the account is a partner account.  **Note**:    - This field is available only if you have the &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Manage_customer_accounts/AAA_Overview_of_customer_accounts/Reseller_Account\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Reseller Account&lt;/a&gt; feature enabled.   - If you have the Reseller Account feature enabled, and set the &#x60;partnerAccount&#x60; field to &#x60;false&#x60; for an account, the value of the &#x60;lastMetricsUpdate&#x60; field is automatically set to &#x60;null&#x60; in the response.    - If you ever set the &#x60;partnerAccount&#x60; field to &#x60;true&#x60; for an account, the value of &#x60;lastMetricsUpdate&#x60; field is the time when the account metrics are last updated.    
   * @return lastMetricsUpdate
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The date and time when account metrics are last updated, if the account is a partner account.  **Note**:    - This field is available only if you have the <a href=\"https://knowledgecenter.zuora.com/Zuora_Billing/Manage_customer_accounts/AAA_Overview_of_customer_accounts/Reseller_Account\" target=\"_blank\">Reseller Account</a> feature enabled.   - If you have the Reseller Account feature enabled, and set the `partnerAccount` field to `false` for an account, the value of the `lastMetricsUpdate` field is automatically set to `null` in the response.    - If you ever set the `partnerAccount` field to `true` for an account, the value of `lastMetricsUpdate` field is the time when the account metrics are last updated.    ")

  public OffsetDateTime getLastMetricsUpdate() {
    return lastMetricsUpdate;
  }


  public void setLastMetricsUpdate(OffsetDateTime lastMetricsUpdate) {
    
    
    
    this.lastMetricsUpdate = lastMetricsUpdate;
  }


  public GETAccountSummaryTypeBasicInfo lastPaymentAmount(BigDecimal lastPaymentAmount) {
    
    
    
    
    this.lastPaymentAmount = lastPaymentAmount;
    return this;
  }

   /**
   * Amount of the most recent payment collected for the account; null if no payment has ever been collected. 
   * @return lastPaymentAmount
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Amount of the most recent payment collected for the account; null if no payment has ever been collected. ")

  public BigDecimal getLastPaymentAmount() {
    return lastPaymentAmount;
  }


  public void setLastPaymentAmount(BigDecimal lastPaymentAmount) {
    
    
    
    this.lastPaymentAmount = lastPaymentAmount;
  }


  public GETAccountSummaryTypeBasicInfo lastPaymentDate(LocalDate lastPaymentDate) {
    
    
    
    
    this.lastPaymentDate = lastPaymentDate;
    return this;
  }

   /**
   * Date of the most recent payment collected for the account. Null if no payment has ever been collected. 
   * @return lastPaymentDate
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Date of the most recent payment collected for the account. Null if no payment has ever been collected. ")

  public LocalDate getLastPaymentDate() {
    return lastPaymentDate;
  }


  public void setLastPaymentDate(LocalDate lastPaymentDate) {
    
    
    
    this.lastPaymentDate = lastPaymentDate;
  }


  public GETAccountSummaryTypeBasicInfo name(String name) {
    
    
    
    
    this.name = name;
    return this;
  }

   /**
   * Account name. 
   * @return name
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Account name. ")

  public String getName() {
    return name;
  }


  public void setName(String name) {
    
    
    
    this.name = name;
  }


  public GETAccountSummaryTypeBasicInfo organizationLabel(String organizationLabel) {
    
    
    
    
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


  public GETAccountSummaryTypeBasicInfo partnerAccount(Boolean partnerAccount) {
    
    
    
    
    this.partnerAccount = partnerAccount;
    return this;
  }

   /**
   * Whether the customer account is a partner, distributor, or reseller.    **Note**: This field is available only if you have the &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Manage_customer_accounts/AAA_Overview_of_customer_accounts/Reseller_Account\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Reseller Account&lt;/a&gt; feature enabled. 
   * @return partnerAccount
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Whether the customer account is a partner, distributor, or reseller.    **Note**: This field is available only if you have the <a href=\"https://knowledgecenter.zuora.com/Zuora_Billing/Manage_customer_accounts/AAA_Overview_of_customer_accounts/Reseller_Account\" target=\"_blank\">Reseller Account</a> feature enabled. ")

  public Boolean getPartnerAccount() {
    return partnerAccount;
  }


  public void setPartnerAccount(Boolean partnerAccount) {
    
    
    
    this.partnerAccount = partnerAccount;
  }


  public GETAccountSummaryTypeBasicInfo purchaseOrderNumber(String purchaseOrderNumber) {
    
    
    
    
    this.purchaseOrderNumber = purchaseOrderNumber;
    return this;
  }

   /**
   * The purchase order number provided by your customer for services, products, or both purchased.
   * @return purchaseOrderNumber
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The purchase order number provided by your customer for services, products, or both purchased.")

  public String getPurchaseOrderNumber() {
    return purchaseOrderNumber;
  }


  public void setPurchaseOrderNumber(String purchaseOrderNumber) {
    
    
    
    this.purchaseOrderNumber = purchaseOrderNumber;
  }


  public GETAccountSummaryTypeBasicInfo status(String status) {
    
    
    
    
    this.status = status;
    return this;
  }

   /**
   * Account status; possible values are: &#x60;Active&#x60;, &#x60;Draft&#x60;, &#x60;Canceled&#x60;. 
   * @return status
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Account status; possible values are: `Active`, `Draft`, `Canceled`. ")

  public String getStatus() {
    return status;
  }


  public void setStatus(String status) {
    
    
    
    this.status = status;
  }


  public GETAccountSummaryTypeBasicInfo classNS(String classNS) {
    
    
    
    
    this.classNS = classNS;
    return this;
  }

   /**
   * Value of the Class field for the corresponding customer account in NetSuite. Only available if you have installed the [Zuora Connector for NetSuite](https://www.zuora.com/connect/app/?appId&#x3D;265). 
   * @return classNS
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Value of the Class field for the corresponding customer account in NetSuite. Only available if you have installed the [Zuora Connector for NetSuite](https://www.zuora.com/connect/app/?appId=265). ")

  public String getClassNS() {
    return classNS;
  }


  public void setClassNS(String classNS) {
    
    
    
    this.classNS = classNS;
  }


  public GETAccountSummaryTypeBasicInfo customerTypeNS(CustomerTypeNSEnum customerTypeNS) {
    
    
    
    
    this.customerTypeNS = customerTypeNS;
    return this;
  }

   /**
   * Value of the Customer Type field for the corresponding customer account in NetSuite. The Customer Type field is used when the customer account is created in NetSuite. Only available if you have installed the [Zuora Connector for NetSuite](https://www.zuora.com/connect/app/?appId&#x3D;265). 
   * @return customerTypeNS
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Value of the Customer Type field for the corresponding customer account in NetSuite. The Customer Type field is used when the customer account is created in NetSuite. Only available if you have installed the [Zuora Connector for NetSuite](https://www.zuora.com/connect/app/?appId=265). ")

  public CustomerTypeNSEnum getCustomerTypeNS() {
    return customerTypeNS;
  }


  public void setCustomerTypeNS(CustomerTypeNSEnum customerTypeNS) {
    
    
    
    this.customerTypeNS = customerTypeNS;
  }


  public GETAccountSummaryTypeBasicInfo departmentNS(String departmentNS) {
    
    
    
    
    this.departmentNS = departmentNS;
    return this;
  }

   /**
   * Value of the Department field for the corresponding customer account in NetSuite. Only available if you have installed the [Zuora Connector for NetSuite](https://www.zuora.com/connect/app/?appId&#x3D;265). 
   * @return departmentNS
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Value of the Department field for the corresponding customer account in NetSuite. Only available if you have installed the [Zuora Connector for NetSuite](https://www.zuora.com/connect/app/?appId=265). ")

  public String getDepartmentNS() {
    return departmentNS;
  }


  public void setDepartmentNS(String departmentNS) {
    
    
    
    this.departmentNS = departmentNS;
  }


  public GETAccountSummaryTypeBasicInfo integrationIdNS(String integrationIdNS) {
    
    
    
    
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


  public GETAccountSummaryTypeBasicInfo integrationStatusNS(String integrationStatusNS) {
    
    
    
    
    this.integrationStatusNS = integrationStatusNS;
    return this;
  }

   /**
   * Status of the account&#39;s synchronization with NetSuite. Only available if you have installed the [Zuora Connector for NetSuite](https://www.zuora.com/connect/app/?appId&#x3D;265). 
   * @return integrationStatusNS
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Status of the account's synchronization with NetSuite. Only available if you have installed the [Zuora Connector for NetSuite](https://www.zuora.com/connect/app/?appId=265). ")

  public String getIntegrationStatusNS() {
    return integrationStatusNS;
  }


  public void setIntegrationStatusNS(String integrationStatusNS) {
    
    
    
    this.integrationStatusNS = integrationStatusNS;
  }


  public GETAccountSummaryTypeBasicInfo locationNS(String locationNS) {
    
    
    
    
    this.locationNS = locationNS;
    return this;
  }

   /**
   * Value of the Location field for the corresponding customer account in NetSuite. Only available if you have installed the [Zuora Connector for NetSuite](https://www.zuora.com/connect/app/?appId&#x3D;265). 
   * @return locationNS
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Value of the Location field for the corresponding customer account in NetSuite. Only available if you have installed the [Zuora Connector for NetSuite](https://www.zuora.com/connect/app/?appId=265). ")

  public String getLocationNS() {
    return locationNS;
  }


  public void setLocationNS(String locationNS) {
    
    
    
    this.locationNS = locationNS;
  }


  public GETAccountSummaryTypeBasicInfo subsidiaryNS(String subsidiaryNS) {
    
    
    
    
    this.subsidiaryNS = subsidiaryNS;
    return this;
  }

   /**
   * Value of the Subsidiary field for the corresponding customer account in NetSuite. The Subsidiary field is required if you use NetSuite OneWorld. Only available if you have installed the [Zuora Connector for NetSuite](https://www.zuora.com/connect/app/?appId&#x3D;265). 
   * @return subsidiaryNS
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Value of the Subsidiary field for the corresponding customer account in NetSuite. The Subsidiary field is required if you use NetSuite OneWorld. Only available if you have installed the [Zuora Connector for NetSuite](https://www.zuora.com/connect/app/?appId=265). ")

  public String getSubsidiaryNS() {
    return subsidiaryNS;
  }


  public void setSubsidiaryNS(String subsidiaryNS) {
    
    
    
    this.subsidiaryNS = subsidiaryNS;
  }


  public GETAccountSummaryTypeBasicInfo syncDateNS(String syncDateNS) {
    
    
    
    
    this.syncDateNS = syncDateNS;
    return this;
  }

   /**
   * Date when the account was sychronized with NetSuite. Only available if you have installed the [Zuora Connector for NetSuite](https://www.zuora.com/connect/app/?appId&#x3D;265). 
   * @return syncDateNS
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Date when the account was sychronized with NetSuite. Only available if you have installed the [Zuora Connector for NetSuite](https://www.zuora.com/connect/app/?appId=265). ")

  public String getSyncDateNS() {
    return syncDateNS;
  }


  public void setSyncDateNS(String syncDateNS) {
    
    
    
    this.syncDateNS = syncDateNS;
  }


  public GETAccountSummaryTypeBasicInfo synctoNetSuiteNS(SynctoNetSuiteNSEnum synctoNetSuiteNS) {
    
    
    
    
    this.synctoNetSuiteNS = synctoNetSuiteNS;
    return this;
  }

   /**
   * Specifies whether the account should be synchronized with NetSuite. Only available if you have installed the [Zuora Connector for NetSuite](https://www.zuora.com/connect/app/?appId&#x3D;265). 
   * @return synctoNetSuiteNS
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Specifies whether the account should be synchronized with NetSuite. Only available if you have installed the [Zuora Connector for NetSuite](https://www.zuora.com/connect/app/?appId=265). ")

  public SynctoNetSuiteNSEnum getSynctoNetSuiteNS() {
    return synctoNetSuiteNS;
  }


  public void setSynctoNetSuiteNS(SynctoNetSuiteNSEnum synctoNetSuiteNS) {
    
    
    
    this.synctoNetSuiteNS = synctoNetSuiteNS;
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
   * @return the GETAccountSummaryTypeBasicInfo instance itself
   */
  public GETAccountSummaryTypeBasicInfo putAdditionalProperty(String key, Object value) {
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
    GETAccountSummaryTypeBasicInfo geTAccountSummaryTypeBasicInfo = (GETAccountSummaryTypeBasicInfo) o;
    return Objects.equals(this.tags, geTAccountSummaryTypeBasicInfo.tags) &&
        Objects.equals(this.accountNumber, geTAccountSummaryTypeBasicInfo.accountNumber) &&
        Objects.equals(this.additionalEmailAddresses, geTAccountSummaryTypeBasicInfo.additionalEmailAddresses) &&
        Objects.equals(this.autoPay, geTAccountSummaryTypeBasicInfo.autoPay) &&
        Objects.equals(this.balance, geTAccountSummaryTypeBasicInfo.balance) &&
        Objects.equals(this.batch, geTAccountSummaryTypeBasicInfo.batch) &&
        Objects.equals(this.billCycleDay, geTAccountSummaryTypeBasicInfo.billCycleDay) &&
        Objects.equals(this.currency, geTAccountSummaryTypeBasicInfo.currency) &&
        Objects.equals(this.defaultPaymentMethod, geTAccountSummaryTypeBasicInfo.defaultPaymentMethod) &&
        Objects.equals(this.id, geTAccountSummaryTypeBasicInfo.id) &&
        Objects.equals(this.invoiceDeliveryPrefsEmail, geTAccountSummaryTypeBasicInfo.invoiceDeliveryPrefsEmail) &&
        Objects.equals(this.invoiceDeliveryPrefsPrint, geTAccountSummaryTypeBasicInfo.invoiceDeliveryPrefsPrint) &&
        Objects.equals(this.lastInvoiceDate, geTAccountSummaryTypeBasicInfo.lastInvoiceDate) &&
        Objects.equals(this.lastMetricsUpdate, geTAccountSummaryTypeBasicInfo.lastMetricsUpdate) &&
        Objects.equals(this.lastPaymentAmount, geTAccountSummaryTypeBasicInfo.lastPaymentAmount) &&
        Objects.equals(this.lastPaymentDate, geTAccountSummaryTypeBasicInfo.lastPaymentDate) &&
        Objects.equals(this.name, geTAccountSummaryTypeBasicInfo.name) &&
        Objects.equals(this.organizationLabel, geTAccountSummaryTypeBasicInfo.organizationLabel) &&
        Objects.equals(this.partnerAccount, geTAccountSummaryTypeBasicInfo.partnerAccount) &&
        Objects.equals(this.purchaseOrderNumber, geTAccountSummaryTypeBasicInfo.purchaseOrderNumber) &&
        Objects.equals(this.status, geTAccountSummaryTypeBasicInfo.status) &&
        Objects.equals(this.classNS, geTAccountSummaryTypeBasicInfo.classNS) &&
        Objects.equals(this.customerTypeNS, geTAccountSummaryTypeBasicInfo.customerTypeNS) &&
        Objects.equals(this.departmentNS, geTAccountSummaryTypeBasicInfo.departmentNS) &&
        Objects.equals(this.integrationIdNS, geTAccountSummaryTypeBasicInfo.integrationIdNS) &&
        Objects.equals(this.integrationStatusNS, geTAccountSummaryTypeBasicInfo.integrationStatusNS) &&
        Objects.equals(this.locationNS, geTAccountSummaryTypeBasicInfo.locationNS) &&
        Objects.equals(this.subsidiaryNS, geTAccountSummaryTypeBasicInfo.subsidiaryNS) &&
        Objects.equals(this.syncDateNS, geTAccountSummaryTypeBasicInfo.syncDateNS) &&
        Objects.equals(this.synctoNetSuiteNS, geTAccountSummaryTypeBasicInfo.synctoNetSuiteNS)&&
        Objects.equals(this.additionalProperties, geTAccountSummaryTypeBasicInfo.additionalProperties);
  }

  @Override
  public int hashCode() {
    return Objects.hash(tags, accountNumber, additionalEmailAddresses, autoPay, balance, batch, billCycleDay, currency, defaultPaymentMethod, id, invoiceDeliveryPrefsEmail, invoiceDeliveryPrefsPrint, lastInvoiceDate, lastMetricsUpdate, lastPaymentAmount, lastPaymentDate, name, organizationLabel, partnerAccount, purchaseOrderNumber, status, classNS, customerTypeNS, departmentNS, integrationIdNS, integrationStatusNS, locationNS, subsidiaryNS, syncDateNS, synctoNetSuiteNS, additionalProperties);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GETAccountSummaryTypeBasicInfo {\n");
    sb.append("    tags: ").append(toIndentedString(tags)).append("\n");
    sb.append("    accountNumber: ").append(toIndentedString(accountNumber)).append("\n");
    sb.append("    additionalEmailAddresses: ").append(toIndentedString(additionalEmailAddresses)).append("\n");
    sb.append("    autoPay: ").append(toIndentedString(autoPay)).append("\n");
    sb.append("    balance: ").append(toIndentedString(balance)).append("\n");
    sb.append("    batch: ").append(toIndentedString(batch)).append("\n");
    sb.append("    billCycleDay: ").append(toIndentedString(billCycleDay)).append("\n");
    sb.append("    currency: ").append(toIndentedString(currency)).append("\n");
    sb.append("    defaultPaymentMethod: ").append(toIndentedString(defaultPaymentMethod)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    invoiceDeliveryPrefsEmail: ").append(toIndentedString(invoiceDeliveryPrefsEmail)).append("\n");
    sb.append("    invoiceDeliveryPrefsPrint: ").append(toIndentedString(invoiceDeliveryPrefsPrint)).append("\n");
    sb.append("    lastInvoiceDate: ").append(toIndentedString(lastInvoiceDate)).append("\n");
    sb.append("    lastMetricsUpdate: ").append(toIndentedString(lastMetricsUpdate)).append("\n");
    sb.append("    lastPaymentAmount: ").append(toIndentedString(lastPaymentAmount)).append("\n");
    sb.append("    lastPaymentDate: ").append(toIndentedString(lastPaymentDate)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    organizationLabel: ").append(toIndentedString(organizationLabel)).append("\n");
    sb.append("    partnerAccount: ").append(toIndentedString(partnerAccount)).append("\n");
    sb.append("    purchaseOrderNumber: ").append(toIndentedString(purchaseOrderNumber)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    classNS: ").append(toIndentedString(classNS)).append("\n");
    sb.append("    customerTypeNS: ").append(toIndentedString(customerTypeNS)).append("\n");
    sb.append("    departmentNS: ").append(toIndentedString(departmentNS)).append("\n");
    sb.append("    integrationIdNS: ").append(toIndentedString(integrationIdNS)).append("\n");
    sb.append("    integrationStatusNS: ").append(toIndentedString(integrationStatusNS)).append("\n");
    sb.append("    locationNS: ").append(toIndentedString(locationNS)).append("\n");
    sb.append("    subsidiaryNS: ").append(toIndentedString(subsidiaryNS)).append("\n");
    sb.append("    syncDateNS: ").append(toIndentedString(syncDateNS)).append("\n");
    sb.append("    synctoNetSuiteNS: ").append(toIndentedString(synctoNetSuiteNS)).append("\n");
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
    openapiFields.add("tags");
    openapiFields.add("accountNumber");
    openapiFields.add("additionalEmailAddresses");
    openapiFields.add("autoPay");
    openapiFields.add("balance");
    openapiFields.add("batch");
    openapiFields.add("billCycleDay");
    openapiFields.add("currency");
    openapiFields.add("defaultPaymentMethod");
    openapiFields.add("id");
    openapiFields.add("invoiceDeliveryPrefsEmail");
    openapiFields.add("invoiceDeliveryPrefsPrint");
    openapiFields.add("lastInvoiceDate");
    openapiFields.add("lastMetricsUpdate");
    openapiFields.add("lastPaymentAmount");
    openapiFields.add("lastPaymentDate");
    openapiFields.add("name");
    openapiFields.add("organizationLabel");
    openapiFields.add("partnerAccount");
    openapiFields.add("purchaseOrderNumber");
    openapiFields.add("status");
    openapiFields.add("Class__NS");
    openapiFields.add("CustomerType__NS");
    openapiFields.add("Department__NS");
    openapiFields.add("IntegrationId__NS");
    openapiFields.add("IntegrationStatus__NS");
    openapiFields.add("Location__NS");
    openapiFields.add("Subsidiary__NS");
    openapiFields.add("SyncDate__NS");
    openapiFields.add("SynctoNetSuite__NS");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
  }

 /**
  * Validates the JSON Object and throws an exception if issues found
  *
  * @param jsonObj JSON Object
  * @throws IOException if the JSON Object is invalid with respect to GETAccountSummaryTypeBasicInfo
  */
  public static void validateJsonObject(JsonObject jsonObj) throws IOException {
      if (jsonObj == null) {
        if (!GETAccountSummaryTypeBasicInfo.openapiRequiredFields.isEmpty()) { // has required fields but JSON object is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in GETAccountSummaryTypeBasicInfo is not found in the empty JSON string", GETAccountSummaryTypeBasicInfo.openapiRequiredFields.toString()));
        }
      }
      if ((jsonObj.get("tags") != null && !jsonObj.get("tags").isJsonNull()) && !jsonObj.get("tags").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `tags` to be a primitive type in the JSON string but got `%s`", jsonObj.get("tags").toString()));
      }
      if ((jsonObj.get("accountNumber") != null && !jsonObj.get("accountNumber").isJsonNull()) && !jsonObj.get("accountNumber").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `accountNumber` to be a primitive type in the JSON string but got `%s`", jsonObj.get("accountNumber").toString()));
      }
      // ensure the optional json data is an array if present
      if (jsonObj.get("additionalEmailAddresses") != null && !jsonObj.get("additionalEmailAddresses").isJsonArray()) {
        throw new IllegalArgumentException(String.format("Expected the field `additionalEmailAddresses` to be an array in the JSON string but got `%s`", jsonObj.get("additionalEmailAddresses").toString()));
      }
      if ((jsonObj.get("balance") != null && !jsonObj.get("balance").isJsonNull()) && !jsonObj.get("balance").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `balance` to be a primitive type in the JSON string but got `%s`", jsonObj.get("balance").toString()));
      }
      if ((jsonObj.get("batch") != null && !jsonObj.get("batch").isJsonNull()) && !jsonObj.get("batch").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `batch` to be a primitive type in the JSON string but got `%s`", jsonObj.get("batch").toString()));
      }
      if ((jsonObj.get("billCycleDay") != null && !jsonObj.get("billCycleDay").isJsonNull()) && !jsonObj.get("billCycleDay").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `billCycleDay` to be a primitive type in the JSON string but got `%s`", jsonObj.get("billCycleDay").toString()));
      }
      if ((jsonObj.get("currency") != null && !jsonObj.get("currency").isJsonNull()) && !jsonObj.get("currency").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `currency` to be a primitive type in the JSON string but got `%s`", jsonObj.get("currency").toString()));
      }
      // validate the optional field `defaultPaymentMethod`
      if (jsonObj.get("defaultPaymentMethod") != null && !jsonObj.get("defaultPaymentMethod").isJsonNull()) {
        GETAccountSummaryTypeBasicInfoAllOfDefaultPaymentMethod.validateJsonObject(jsonObj.getAsJsonObject("defaultPaymentMethod"));
      }
      if ((jsonObj.get("id") != null && !jsonObj.get("id").isJsonNull()) && !jsonObj.get("id").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `id` to be a primitive type in the JSON string but got `%s`", jsonObj.get("id").toString()));
      }
      if ((jsonObj.get("lastPaymentAmount") != null && !jsonObj.get("lastPaymentAmount").isJsonNull()) && !jsonObj.get("lastPaymentAmount").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `lastPaymentAmount` to be a primitive type in the JSON string but got `%s`", jsonObj.get("lastPaymentAmount").toString()));
      }
      if ((jsonObj.get("name") != null && !jsonObj.get("name").isJsonNull()) && !jsonObj.get("name").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `name` to be a primitive type in the JSON string but got `%s`", jsonObj.get("name").toString()));
      }
      if ((jsonObj.get("organizationLabel") != null && !jsonObj.get("organizationLabel").isJsonNull()) && !jsonObj.get("organizationLabel").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `organizationLabel` to be a primitive type in the JSON string but got `%s`", jsonObj.get("organizationLabel").toString()));
      }
      if ((jsonObj.get("purchaseOrderNumber") != null && !jsonObj.get("purchaseOrderNumber").isJsonNull()) && !jsonObj.get("purchaseOrderNumber").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `purchaseOrderNumber` to be a primitive type in the JSON string but got `%s`", jsonObj.get("purchaseOrderNumber").toString()));
      }
      if ((jsonObj.get("status") != null && !jsonObj.get("status").isJsonNull()) && !jsonObj.get("status").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `status` to be a primitive type in the JSON string but got `%s`", jsonObj.get("status").toString()));
      }
      if ((jsonObj.get("Class__NS") != null && !jsonObj.get("Class__NS").isJsonNull()) && !jsonObj.get("Class__NS").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `Class__NS` to be a primitive type in the JSON string but got `%s`", jsonObj.get("Class__NS").toString()));
      }
      if ((jsonObj.get("CustomerType__NS") != null && !jsonObj.get("CustomerType__NS").isJsonNull()) && !jsonObj.get("CustomerType__NS").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `CustomerType__NS` to be a primitive type in the JSON string but got `%s`", jsonObj.get("CustomerType__NS").toString()));
      }
      if ((jsonObj.get("Department__NS") != null && !jsonObj.get("Department__NS").isJsonNull()) && !jsonObj.get("Department__NS").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `Department__NS` to be a primitive type in the JSON string but got `%s`", jsonObj.get("Department__NS").toString()));
      }
      if ((jsonObj.get("IntegrationId__NS") != null && !jsonObj.get("IntegrationId__NS").isJsonNull()) && !jsonObj.get("IntegrationId__NS").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `IntegrationId__NS` to be a primitive type in the JSON string but got `%s`", jsonObj.get("IntegrationId__NS").toString()));
      }
      if ((jsonObj.get("IntegrationStatus__NS") != null && !jsonObj.get("IntegrationStatus__NS").isJsonNull()) && !jsonObj.get("IntegrationStatus__NS").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `IntegrationStatus__NS` to be a primitive type in the JSON string but got `%s`", jsonObj.get("IntegrationStatus__NS").toString()));
      }
      if ((jsonObj.get("Location__NS") != null && !jsonObj.get("Location__NS").isJsonNull()) && !jsonObj.get("Location__NS").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `Location__NS` to be a primitive type in the JSON string but got `%s`", jsonObj.get("Location__NS").toString()));
      }
      if ((jsonObj.get("Subsidiary__NS") != null && !jsonObj.get("Subsidiary__NS").isJsonNull()) && !jsonObj.get("Subsidiary__NS").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `Subsidiary__NS` to be a primitive type in the JSON string but got `%s`", jsonObj.get("Subsidiary__NS").toString()));
      }
      if ((jsonObj.get("SyncDate__NS") != null && !jsonObj.get("SyncDate__NS").isJsonNull()) && !jsonObj.get("SyncDate__NS").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `SyncDate__NS` to be a primitive type in the JSON string but got `%s`", jsonObj.get("SyncDate__NS").toString()));
      }
      if ((jsonObj.get("SynctoNetSuite__NS") != null && !jsonObj.get("SynctoNetSuite__NS").isJsonNull()) && !jsonObj.get("SynctoNetSuite__NS").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `SynctoNetSuite__NS` to be a primitive type in the JSON string but got `%s`", jsonObj.get("SynctoNetSuite__NS").toString()));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!GETAccountSummaryTypeBasicInfo.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'GETAccountSummaryTypeBasicInfo' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<GETAccountSummaryTypeBasicInfo> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(GETAccountSummaryTypeBasicInfo.class));

       return (TypeAdapter<T>) new TypeAdapter<GETAccountSummaryTypeBasicInfo>() {
           @Override
           public void write(JsonWriter out, GETAccountSummaryTypeBasicInfo value) throws IOException {
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
           public GETAccountSummaryTypeBasicInfo read(JsonReader in) throws IOException {
             JsonObject jsonObj = elementAdapter.read(in).getAsJsonObject();
             validateJsonObject(jsonObj);
             // store additional fields in the deserialized instance
             GETAccountSummaryTypeBasicInfo instance = thisAdapter.fromJsonTree(jsonObj);
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
  * Create an instance of GETAccountSummaryTypeBasicInfo given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of GETAccountSummaryTypeBasicInfo
  * @throws IOException if the JSON string is invalid with respect to GETAccountSummaryTypeBasicInfo
  */
  public static GETAccountSummaryTypeBasicInfo fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, GETAccountSummaryTypeBasicInfo.class);
  }

 /**
  * Convert an instance of GETAccountSummaryTypeBasicInfo to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

