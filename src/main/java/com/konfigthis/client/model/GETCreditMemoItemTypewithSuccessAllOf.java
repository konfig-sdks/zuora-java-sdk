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
import com.konfigthis.client.model.GETCMTaxItemType;
import com.konfigthis.client.model.GETCreditMemoItemTypewithSuccessAllOfFinanceInformation;
import com.konfigthis.client.model.GETCreditMemoItemTypewithSuccessAllOfTaxationItems;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
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
 * GETCreditMemoItemTypewithSuccessAllOf
 */@javax.annotation.Generated(value = "Generated by https://konfigthis.com")
public class GETCreditMemoItemTypewithSuccessAllOf {
  public static final String SERIALIZED_NAME_DESCRIPTION = "description";
  @SerializedName(SERIALIZED_NAME_DESCRIPTION)
  private String description;

  public static final String SERIALIZED_NAME_AMOUNT = "amount";
  @SerializedName(SERIALIZED_NAME_AMOUNT)
  private Double amount;

  public static final String SERIALIZED_NAME_AMOUNT_WITHOUT_TAX = "amountWithoutTax";
  @SerializedName(SERIALIZED_NAME_AMOUNT_WITHOUT_TAX)
  private Double amountWithoutTax;

  public static final String SERIALIZED_NAME_APPLIED_AMOUNT = "appliedAmount";
  @SerializedName(SERIALIZED_NAME_APPLIED_AMOUNT)
  private Double appliedAmount;

  public static final String SERIALIZED_NAME_APPLIED_TO_ITEM_ID = "appliedToItemId";
  @SerializedName(SERIALIZED_NAME_APPLIED_TO_ITEM_ID)
  private String appliedToItemId;

  public static final String SERIALIZED_NAME_COMMENT = "comment";
  @SerializedName(SERIALIZED_NAME_COMMENT)
  private String comment;

  public static final String SERIALIZED_NAME_CREATED_BY_ID = "createdById";
  @SerializedName(SERIALIZED_NAME_CREATED_BY_ID)
  private String createdById;

  public static final String SERIALIZED_NAME_CREATED_DATE = "createdDate";
  @SerializedName(SERIALIZED_NAME_CREATED_DATE)
  private OffsetDateTime createdDate;

  public static final String SERIALIZED_NAME_CREDIT_FROM_ITEM_ID = "creditFromItemId";
  @SerializedName(SERIALIZED_NAME_CREDIT_FROM_ITEM_ID)
  private String creditFromItemId;

  /**
   * The type of the credit from item. 
   */
  @JsonAdapter(CreditFromItemSourceEnum.Adapter.class)
 public enum CreditFromItemSourceEnum {
    INVOICEITEM("InvoiceItem"),
    
    CREDITMEMOITEM("CreditMemoItem");

    private String value;

    CreditFromItemSourceEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static CreditFromItemSourceEnum fromValue(String value) {
      for (CreditFromItemSourceEnum b : CreditFromItemSourceEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<CreditFromItemSourceEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final CreditFromItemSourceEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public CreditFromItemSourceEnum read(final JsonReader jsonReader) throws IOException {
        String value =  jsonReader.nextString();
        return CreditFromItemSourceEnum.fromValue(value);
      }
    }
  }

  public static final String SERIALIZED_NAME_CREDIT_FROM_ITEM_SOURCE = "creditFromItemSource";
  @SerializedName(SERIALIZED_NAME_CREDIT_FROM_ITEM_SOURCE)
  private CreditFromItemSourceEnum creditFromItemSource;

  public static final String SERIALIZED_NAME_CREDIT_TAX_ITEMS = "creditTaxItems";
  @SerializedName(SERIALIZED_NAME_CREDIT_TAX_ITEMS)
  private List<GETCMTaxItemType> creditTaxItems = null;

  public static final String SERIALIZED_NAME_EXCLUDE_ITEM_BILLING_FROM_REVENUE_ACCOUNTING = "excludeItemBillingFromRevenueAccounting";
  @SerializedName(SERIALIZED_NAME_EXCLUDE_ITEM_BILLING_FROM_REVENUE_ACCOUNTING)
  private Boolean excludeItemBillingFromRevenueAccounting;

  public static final String SERIALIZED_NAME_FINANCE_INFORMATION = "financeInformation";
  @SerializedName(SERIALIZED_NAME_FINANCE_INFORMATION)
  private GETCreditMemoItemTypewithSuccessAllOfFinanceInformation financeInformation;

  public static final String SERIALIZED_NAME_ID = "id";
  @SerializedName(SERIALIZED_NAME_ID)
  private String id;

  public static final String SERIALIZED_NAME_INVOICE_SCHEDULE_ID = "invoiceScheduleId";
  @SerializedName(SERIALIZED_NAME_INVOICE_SCHEDULE_ID)
  private String invoiceScheduleId;

  public static final String SERIALIZED_NAME_INVOICE_SCHEDULE_ITEM_ID = "invoiceScheduleItemId";
  @SerializedName(SERIALIZED_NAME_INVOICE_SCHEDULE_ITEM_ID)
  private String invoiceScheduleItemId;

  public static final String SERIALIZED_NAME_NUMBER_OF_DELIVERIES = "numberOfDeliveries";
  @SerializedName(SERIALIZED_NAME_NUMBER_OF_DELIVERIES)
  private Double numberOfDeliveries;

  public static final String SERIALIZED_NAME_PROCESSING_TYPE = "processingType";
  @SerializedName(SERIALIZED_NAME_PROCESSING_TYPE)
  private String processingType;

  public static final String SERIALIZED_NAME_QUANTITY = "quantity";
  @SerializedName(SERIALIZED_NAME_QUANTITY)
  private Double quantity;

  public static final String SERIALIZED_NAME_REFUND_AMOUNT = "refundAmount";
  @SerializedName(SERIALIZED_NAME_REFUND_AMOUNT)
  private Double refundAmount;

  public static final String SERIALIZED_NAME_SERVICE_END_DATE = "serviceEndDate";
  @SerializedName(SERIALIZED_NAME_SERVICE_END_DATE)
  private LocalDate serviceEndDate;

  public static final String SERIALIZED_NAME_SERVICE_START_DATE = "serviceStartDate";
  @SerializedName(SERIALIZED_NAME_SERVICE_START_DATE)
  private LocalDate serviceStartDate;

  public static final String SERIALIZED_NAME_SKU = "sku";
  @SerializedName(SERIALIZED_NAME_SKU)
  private String sku;

  public static final String SERIALIZED_NAME_SKU_NAME = "skuName";
  @SerializedName(SERIALIZED_NAME_SKU_NAME)
  private String skuName;

  public static final String SERIALIZED_NAME_SOLD_TO_CONTACT_ID = "soldToContactId";
  @SerializedName(SERIALIZED_NAME_SOLD_TO_CONTACT_ID)
  private String soldToContactId;

  public static final String SERIALIZED_NAME_SOLD_TO_CONTACT_SNAPSHOT_ID = "soldToContactSnapshotId";
  @SerializedName(SERIALIZED_NAME_SOLD_TO_CONTACT_SNAPSHOT_ID)
  private String soldToContactSnapshotId;

  public static final String SERIALIZED_NAME_SOURCE_ITEM_ID = "sourceItemId";
  @SerializedName(SERIALIZED_NAME_SOURCE_ITEM_ID)
  private String sourceItemId;

  /**
   * The type of the source item.  - If a credit memo is not created from an invoice or a product rate plan charge or a return order line item, the value of this field is &#x60;SubscriptionComponent&#x60;.  - If a credit memo is created from an invoice, the value of this field is &#x60;InvoiceDetail&#x60;. - If a credit memo is created from a product rate plan charge, the value of this field is &#x60;ProductRatePlanCharge&#x60;. - If a credit memo is created from a return order line item, the value of this field is &#x60;OrderLineItem&#x60;.               
   */
  @JsonAdapter(SourceItemTypeEnum.Adapter.class)
 public enum SourceItemTypeEnum {
    SUBSCRIPTIONCOMPONENT("SubscriptionComponent"),
    
    INVOICEDETAIL("InvoiceDetail"),
    
    PRODUCTRATEPLANCHARGE("ProductRatePlanCharge"),
    
    ORDERLINEITEM("OrderLineItem");

    private String value;

    SourceItemTypeEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static SourceItemTypeEnum fromValue(String value) {
      for (SourceItemTypeEnum b : SourceItemTypeEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<SourceItemTypeEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final SourceItemTypeEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public SourceItemTypeEnum read(final JsonReader jsonReader) throws IOException {
        String value =  jsonReader.nextString();
        return SourceItemTypeEnum.fromValue(value);
      }
    }
  }

  public static final String SERIALIZED_NAME_SOURCE_ITEM_TYPE = "sourceItemType";
  @SerializedName(SERIALIZED_NAME_SOURCE_ITEM_TYPE)
  private SourceItemTypeEnum sourceItemType;

  public static final String SERIALIZED_NAME_SUBSCRIPTION_ID = "subscriptionId";
  @SerializedName(SERIALIZED_NAME_SUBSCRIPTION_ID)
  private String subscriptionId;

  /**
   * The tax mode of the credit memo item, indicating whether the amount of the credit memo item includes tax. 
   */
  @JsonAdapter(TaxModeEnum.Adapter.class)
 public enum TaxModeEnum {
    TAXEXCLUSIVE("TaxExclusive"),
    
    TAXINCLUSIVE("TaxInclusive");

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
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
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

  public static final String SERIALIZED_NAME_TAXATION_ITEMS = "taxationItems";
  @SerializedName(SERIALIZED_NAME_TAXATION_ITEMS)
  private GETCreditMemoItemTypewithSuccessAllOfTaxationItems taxationItems;

  public static final String SERIALIZED_NAME_UNAPPLIED_AMOUNT = "unappliedAmount";
  @SerializedName(SERIALIZED_NAME_UNAPPLIED_AMOUNT)
  private Double unappliedAmount;

  public static final String SERIALIZED_NAME_UNIT_OF_MEASURE = "unitOfMeasure";
  @SerializedName(SERIALIZED_NAME_UNIT_OF_MEASURE)
  private String unitOfMeasure;

  public static final String SERIALIZED_NAME_UNIT_PRICE = "unitPrice";
  @SerializedName(SERIALIZED_NAME_UNIT_PRICE)
  private Double unitPrice;

  public static final String SERIALIZED_NAME_UPDATED_BY_ID = "updatedById";
  @SerializedName(SERIALIZED_NAME_UPDATED_BY_ID)
  private String updatedById;

  public static final String SERIALIZED_NAME_UPDATED_DATE = "updatedDate";
  @SerializedName(SERIALIZED_NAME_UPDATED_DATE)
  private OffsetDateTime updatedDate;

  public GETCreditMemoItemTypewithSuccessAllOf() {
  }

  public GETCreditMemoItemTypewithSuccessAllOf description(String description) {
    
    
    
    
    this.description = description;
    return this;
  }

   /**
   * The description of the credit memo item.  **Note**: This field is only available if you set the &#x60;zuora-version&#x60; request header to &#x60;257.0&#x60; or later [available versions](https://developer.zuora.com/api-references/api/overview/#section/API-Versions/Minor-Version). 
   * @return description
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The description of the credit memo item.  **Note**: This field is only available if you set the `zuora-version` request header to `257.0` or later [available versions](https://developer.zuora.com/api-references/api/overview/#section/API-Versions/Minor-Version). ")

  public String getDescription() {
    return description;
  }


  public void setDescription(String description) {
    
    
    
    this.description = description;
  }


  public GETCreditMemoItemTypewithSuccessAllOf amount(Double amount) {
    
    
    
    
    this.amount = amount;
    return this;
  }

   /**
   * The amount of the credit memo item. For tax-inclusive credit memo items, the amount indicates the credit memo item amount including tax. For tax-exclusive credit memo items, the amount indicates the credit memo item amount excluding tax. 
   * @return amount
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The amount of the credit memo item. For tax-inclusive credit memo items, the amount indicates the credit memo item amount including tax. For tax-exclusive credit memo items, the amount indicates the credit memo item amount excluding tax. ")

  public Double getAmount() {
    return amount;
  }


  public void setAmount(Double amount) {
    
    
    
    this.amount = amount;
  }


  public GETCreditMemoItemTypewithSuccessAllOf amountWithoutTax(Double amountWithoutTax) {
    
    
    
    
    this.amountWithoutTax = amountWithoutTax;
    return this;
  }

   /**
   * The credit memo item amount excluding tax. 
   * @return amountWithoutTax
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The credit memo item amount excluding tax. ")

  public Double getAmountWithoutTax() {
    return amountWithoutTax;
  }


  public void setAmountWithoutTax(Double amountWithoutTax) {
    
    
    
    this.amountWithoutTax = amountWithoutTax;
  }


  public GETCreditMemoItemTypewithSuccessAllOf appliedAmount(Double appliedAmount) {
    
    
    
    
    this.appliedAmount = appliedAmount;
    return this;
  }

   /**
   * The applied amount of the credit memo item. 
   * @return appliedAmount
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The applied amount of the credit memo item. ")

  public Double getAppliedAmount() {
    return appliedAmount;
  }


  public void setAppliedAmount(Double appliedAmount) {
    
    
    
    this.appliedAmount = appliedAmount;
  }


  public GETCreditMemoItemTypewithSuccessAllOf appliedToItemId(String appliedToItemId) {
    
    
    
    
    this.appliedToItemId = appliedToItemId;
    return this;
  }

   /**
   * The unique ID of the credit memo item that the discount charge is applied to. 
   * @return appliedToItemId
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The unique ID of the credit memo item that the discount charge is applied to. ")

  public String getAppliedToItemId() {
    return appliedToItemId;
  }


  public void setAppliedToItemId(String appliedToItemId) {
    
    
    
    this.appliedToItemId = appliedToItemId;
  }


  public GETCreditMemoItemTypewithSuccessAllOf comment(String comment) {
    
    
    
    
    this.comment = comment;
    return this;
  }

   /**
   * Comments about the credit memo item.  **Note**: This field is not available if you set the &#x60;zuora-version&#x60; request header to &#x60;257.0&#x60; or later [available versions](https://developer.zuora.com/api-references/api/overview/#section/API-Versions/Minor-Version). 
   * @return comment
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Comments about the credit memo item.  **Note**: This field is not available if you set the `zuora-version` request header to `257.0` or later [available versions](https://developer.zuora.com/api-references/api/overview/#section/API-Versions/Minor-Version). ")

  public String getComment() {
    return comment;
  }


  public void setComment(String comment) {
    
    
    
    this.comment = comment;
  }


  public GETCreditMemoItemTypewithSuccessAllOf createdById(String createdById) {
    
    
    
    
    this.createdById = createdById;
    return this;
  }

   /**
   * The ID of the Zuora user who created the credit memo item. 
   * @return createdById
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The ID of the Zuora user who created the credit memo item. ")

  public String getCreatedById() {
    return createdById;
  }


  public void setCreatedById(String createdById) {
    
    
    
    this.createdById = createdById;
  }


  public GETCreditMemoItemTypewithSuccessAllOf createdDate(OffsetDateTime createdDate) {
    
    
    
    
    this.createdDate = createdDate;
    return this;
  }

   /**
   * The date and time when the credit memo item was created, in &#x60;yyyy-mm-dd hh:mm:ss&#x60; format. For example, 2017-03-01 15:31:10. 
   * @return createdDate
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The date and time when the credit memo item was created, in `yyyy-mm-dd hh:mm:ss` format. For example, 2017-03-01 15:31:10. ")

  public OffsetDateTime getCreatedDate() {
    return createdDate;
  }


  public void setCreatedDate(OffsetDateTime createdDate) {
    
    
    
    this.createdDate = createdDate;
  }


  public GETCreditMemoItemTypewithSuccessAllOf creditFromItemId(String creditFromItemId) {
    
    
    
    
    this.creditFromItemId = creditFromItemId;
    return this;
  }

   /**
   * The ID of the credit from item. 
   * @return creditFromItemId
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The ID of the credit from item. ")

  public String getCreditFromItemId() {
    return creditFromItemId;
  }


  public void setCreditFromItemId(String creditFromItemId) {
    
    
    
    this.creditFromItemId = creditFromItemId;
  }


  public GETCreditMemoItemTypewithSuccessAllOf creditFromItemSource(CreditFromItemSourceEnum creditFromItemSource) {
    
    
    
    
    this.creditFromItemSource = creditFromItemSource;
    return this;
  }

   /**
   * The type of the credit from item. 
   * @return creditFromItemSource
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The type of the credit from item. ")

  public CreditFromItemSourceEnum getCreditFromItemSource() {
    return creditFromItemSource;
  }


  public void setCreditFromItemSource(CreditFromItemSourceEnum creditFromItemSource) {
    
    
    
    this.creditFromItemSource = creditFromItemSource;
  }


  public GETCreditMemoItemTypewithSuccessAllOf creditTaxItems(List<GETCMTaxItemType> creditTaxItems) {
    
    
    
    
    this.creditTaxItems = creditTaxItems;
    return this;
  }

  public GETCreditMemoItemTypewithSuccessAllOf addCreditTaxItemsItem(GETCMTaxItemType creditTaxItemsItem) {
    if (this.creditTaxItems == null) {
      this.creditTaxItems = new ArrayList<>();
    }
    this.creditTaxItems.add(creditTaxItemsItem);
    return this;
  }

   /**
   * Container for the taxation items of the credit memo item.   **Note**: This field is not available if you set the &#x60;zuora-version&#x60; request header to &#x60;239.0&#x60; or later [available versions](https://developer.zuora.com/api-references/api/overview/#section/API-Versions/Minor-Version). 
   * @return creditTaxItems
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Container for the taxation items of the credit memo item.   **Note**: This field is not available if you set the `zuora-version` request header to `239.0` or later [available versions](https://developer.zuora.com/api-references/api/overview/#section/API-Versions/Minor-Version). ")

  public List<GETCMTaxItemType> getCreditTaxItems() {
    return creditTaxItems;
  }


  public void setCreditTaxItems(List<GETCMTaxItemType> creditTaxItems) {
    
    
    
    this.creditTaxItems = creditTaxItems;
  }


  public GETCreditMemoItemTypewithSuccessAllOf excludeItemBillingFromRevenueAccounting(Boolean excludeItemBillingFromRevenueAccounting) {
    
    
    
    
    this.excludeItemBillingFromRevenueAccounting = excludeItemBillingFromRevenueAccounting;
    return this;
  }

   /**
   * The flag to exclude the credit memo item from revenue accounting.  **Note**: This field is only available if you have the Billing - Revenue Integration feature enabled.  
   * @return excludeItemBillingFromRevenueAccounting
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The flag to exclude the credit memo item from revenue accounting.  **Note**: This field is only available if you have the Billing - Revenue Integration feature enabled.  ")

  public Boolean getExcludeItemBillingFromRevenueAccounting() {
    return excludeItemBillingFromRevenueAccounting;
  }


  public void setExcludeItemBillingFromRevenueAccounting(Boolean excludeItemBillingFromRevenueAccounting) {
    
    
    
    this.excludeItemBillingFromRevenueAccounting = excludeItemBillingFromRevenueAccounting;
  }


  public GETCreditMemoItemTypewithSuccessAllOf financeInformation(GETCreditMemoItemTypewithSuccessAllOfFinanceInformation financeInformation) {
    
    
    
    
    this.financeInformation = financeInformation;
    return this;
  }

   /**
   * Get financeInformation
   * @return financeInformation
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public GETCreditMemoItemTypewithSuccessAllOfFinanceInformation getFinanceInformation() {
    return financeInformation;
  }


  public void setFinanceInformation(GETCreditMemoItemTypewithSuccessAllOfFinanceInformation financeInformation) {
    
    
    
    this.financeInformation = financeInformation;
  }


  public GETCreditMemoItemTypewithSuccessAllOf id(String id) {
    
    
    
    
    this.id = id;
    return this;
  }

   /**
   * The ID of the credit memo item. 
   * @return id
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The ID of the credit memo item. ")

  public String getId() {
    return id;
  }


  public void setId(String id) {
    
    
    
    this.id = id;
  }


  public GETCreditMemoItemTypewithSuccessAllOf invoiceScheduleId(String invoiceScheduleId) {
    
    
    
    
    this.invoiceScheduleId = invoiceScheduleId;
    return this;
  }

   /**
   * The ID of the invoice schedule associated with the credit memo item.   **Note**: This field is available only if you have the &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Bill_your_customers/Flexible_Billing/Billing_Schedule\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Billing Schedule&lt;/a&gt; feature enabled. 
   * @return invoiceScheduleId
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The ID of the invoice schedule associated with the credit memo item.   **Note**: This field is available only if you have the <a href=\"https://knowledgecenter.zuora.com/Zuora_Billing/Bill_your_customers/Flexible_Billing/Billing_Schedule\" target=\"_blank\">Billing Schedule</a> feature enabled. ")

  public String getInvoiceScheduleId() {
    return invoiceScheduleId;
  }


  public void setInvoiceScheduleId(String invoiceScheduleId) {
    
    
    
    this.invoiceScheduleId = invoiceScheduleId;
  }


  public GETCreditMemoItemTypewithSuccessAllOf invoiceScheduleItemId(String invoiceScheduleItemId) {
    
    
    
    
    this.invoiceScheduleItemId = invoiceScheduleItemId;
    return this;
  }

   /**
   * The ID of the invoice schedule item associated with the credit memo item. The credit memo item is generated during the processing of the invoice schedule item.  **Note**: This field is available only if you have the &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Bill_your_customers/Flexible_Billing/Billing_Schedule\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Billing Schedule&lt;/a&gt; feature enabled. 
   * @return invoiceScheduleItemId
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The ID of the invoice schedule item associated with the credit memo item. The credit memo item is generated during the processing of the invoice schedule item.  **Note**: This field is available only if you have the <a href=\"https://knowledgecenter.zuora.com/Zuora_Billing/Bill_your_customers/Flexible_Billing/Billing_Schedule\" target=\"_blank\">Billing Schedule</a> feature enabled. ")

  public String getInvoiceScheduleItemId() {
    return invoiceScheduleItemId;
  }


  public void setInvoiceScheduleItemId(String invoiceScheduleItemId) {
    
    
    
    this.invoiceScheduleItemId = invoiceScheduleItemId;
  }


  public GETCreditMemoItemTypewithSuccessAllOf numberOfDeliveries(Double numberOfDeliveries) {
    
    
    
    
    this.numberOfDeliveries = numberOfDeliveries;
    return this;
  }

  public GETCreditMemoItemTypewithSuccessAllOf numberOfDeliveries(Integer numberOfDeliveries) {
    
    
    
    
    this.numberOfDeliveries = numberOfDeliveries.doubleValue();
    return this;
  }

   /**
   * The number of deliveries dedicated to the Delivery Pricing charges. The value might be different, as follows: - For the credit memo generated by a bill run, this field has a value.  - For the credit memo generated from an invoice, this field is blank. **Note**: This field is available only if you have the Delivery Pricing feature enabled. 
   * @return numberOfDeliveries
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The number of deliveries dedicated to the Delivery Pricing charges. The value might be different, as follows: - For the credit memo generated by a bill run, this field has a value.  - For the credit memo generated from an invoice, this field is blank. **Note**: This field is available only if you have the Delivery Pricing feature enabled. ")

  public Double getNumberOfDeliveries() {
    return numberOfDeliveries;
  }


  public void setNumberOfDeliveries(Double numberOfDeliveries) {
    
    
    
    this.numberOfDeliveries = numberOfDeliveries;
  }


  public GETCreditMemoItemTypewithSuccessAllOf processingType(String processingType) {
    
    
    
    
    this.processingType = processingType;
    return this;
  }

   /**
   * The kind of the charge for the credit memo item. Its possible values are &#x60;Charge&#x60; and &#x60;Discount&#x60;.  
   * @return processingType
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The kind of the charge for the credit memo item. Its possible values are `Charge` and `Discount`.  ")

  public String getProcessingType() {
    return processingType;
  }


  public void setProcessingType(String processingType) {
    
    
    
    this.processingType = processingType;
  }


  public GETCreditMemoItemTypewithSuccessAllOf quantity(Double quantity) {
    
    
    
    
    this.quantity = quantity;
    return this;
  }

   /**
   * The number of units for the credit memo item. 
   * @return quantity
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The number of units for the credit memo item. ")

  public Double getQuantity() {
    return quantity;
  }


  public void setQuantity(Double quantity) {
    
    
    
    this.quantity = quantity;
  }


  public GETCreditMemoItemTypewithSuccessAllOf refundAmount(Double refundAmount) {
    
    
    
    
    this.refundAmount = refundAmount;
    return this;
  }

   /**
   * The amount of the refund on the credit memo item. 
   * @return refundAmount
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The amount of the refund on the credit memo item. ")

  public Double getRefundAmount() {
    return refundAmount;
  }


  public void setRefundAmount(Double refundAmount) {
    
    
    
    this.refundAmount = refundAmount;
  }


  public GETCreditMemoItemTypewithSuccessAllOf serviceEndDate(LocalDate serviceEndDate) {
    
    
    
    
    this.serviceEndDate = serviceEndDate;
    return this;
  }

   /**
   * The service end date of the credit memo item.  
   * @return serviceEndDate
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The service end date of the credit memo item.  ")

  public LocalDate getServiceEndDate() {
    return serviceEndDate;
  }


  public void setServiceEndDate(LocalDate serviceEndDate) {
    
    
    
    this.serviceEndDate = serviceEndDate;
  }


  public GETCreditMemoItemTypewithSuccessAllOf serviceStartDate(LocalDate serviceStartDate) {
    
    
    
    
    this.serviceStartDate = serviceStartDate;
    return this;
  }

   /**
   * The service start date of the credit memo item. 
   * @return serviceStartDate
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The service start date of the credit memo item. ")

  public LocalDate getServiceStartDate() {
    return serviceStartDate;
  }


  public void setServiceStartDate(LocalDate serviceStartDate) {
    
    
    
    this.serviceStartDate = serviceStartDate;
  }


  public GETCreditMemoItemTypewithSuccessAllOf sku(String sku) {
    
    
    
    
    this.sku = sku;
    return this;
  }

   /**
   * The SKU for the product associated with the credit memo item. 
   * @return sku
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The SKU for the product associated with the credit memo item. ")

  public String getSku() {
    return sku;
  }


  public void setSku(String sku) {
    
    
    
    this.sku = sku;
  }


  public GETCreditMemoItemTypewithSuccessAllOf skuName(String skuName) {
    
    
    
    
    this.skuName = skuName;
    return this;
  }

   /**
   * The name of the SKU. 
   * @return skuName
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The name of the SKU. ")

  public String getSkuName() {
    return skuName;
  }


  public void setSkuName(String skuName) {
    
    
    
    this.skuName = skuName;
  }


  public GETCreditMemoItemTypewithSuccessAllOf soldToContactId(String soldToContactId) {
    
    
    
    
    this.soldToContactId = soldToContactId;
    return this;
  }

   /**
   * The ID of the sold-to contact associated with the credit memo item.  **Note**: If you have the Flexible Billing Attributes feature disabled, the value of this field is &#x60;null&#x60;. 
   * @return soldToContactId
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The ID of the sold-to contact associated with the credit memo item.  **Note**: If you have the Flexible Billing Attributes feature disabled, the value of this field is `null`. ")

  public String getSoldToContactId() {
    return soldToContactId;
  }


  public void setSoldToContactId(String soldToContactId) {
    
    
    
    this.soldToContactId = soldToContactId;
  }


  public GETCreditMemoItemTypewithSuccessAllOf soldToContactSnapshotId(String soldToContactSnapshotId) {
    
    
    
    
    this.soldToContactSnapshotId = soldToContactSnapshotId;
    return this;
  }

   /**
   * The ID of the sold-to contact snapshot associated with the credit memo item.  **Note**: If you have the Flexible Billing Attributes feature disabled, the value of this field is &#x60;null&#x60;. 
   * @return soldToContactSnapshotId
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The ID of the sold-to contact snapshot associated with the credit memo item.  **Note**: If you have the Flexible Billing Attributes feature disabled, the value of this field is `null`. ")

  public String getSoldToContactSnapshotId() {
    return soldToContactSnapshotId;
  }


  public void setSoldToContactSnapshotId(String soldToContactSnapshotId) {
    
    
    
    this.soldToContactSnapshotId = soldToContactSnapshotId;
  }


  public GETCreditMemoItemTypewithSuccessAllOf sourceItemId(String sourceItemId) {
    
    
    
    
    this.sourceItemId = sourceItemId;
    return this;
  }

   /**
   * The ID of the source item.  - If the value of the &#x60;sourceItemType&#x60; field is &#x60;SubscriptionComponent&#x60; , the value of this field is the ID of the corresponding rate plan charge. - If the value of the &#x60;sourceItemType&#x60; field is &#x60;InvoiceDetail&#x60;, the value of this field is the ID of the corresponding invoice item. - If the value of the &#x60;sourceItemType&#x60; field is &#x60;ProductRatePlanCharge&#x60; , the value of this field is the ID of the corresponding product rate plan charge. - If the value of the &#x60;sourceItemType&#x60; field is &#x60;OrderLineItem&#x60; , the value of this field is the ID of the corresponding return order line item. 
   * @return sourceItemId
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The ID of the source item.  - If the value of the `sourceItemType` field is `SubscriptionComponent` , the value of this field is the ID of the corresponding rate plan charge. - If the value of the `sourceItemType` field is `InvoiceDetail`, the value of this field is the ID of the corresponding invoice item. - If the value of the `sourceItemType` field is `ProductRatePlanCharge` , the value of this field is the ID of the corresponding product rate plan charge. - If the value of the `sourceItemType` field is `OrderLineItem` , the value of this field is the ID of the corresponding return order line item. ")

  public String getSourceItemId() {
    return sourceItemId;
  }


  public void setSourceItemId(String sourceItemId) {
    
    
    
    this.sourceItemId = sourceItemId;
  }


  public GETCreditMemoItemTypewithSuccessAllOf sourceItemType(SourceItemTypeEnum sourceItemType) {
    
    
    
    
    this.sourceItemType = sourceItemType;
    return this;
  }

   /**
   * The type of the source item.  - If a credit memo is not created from an invoice or a product rate plan charge or a return order line item, the value of this field is &#x60;SubscriptionComponent&#x60;.  - If a credit memo is created from an invoice, the value of this field is &#x60;InvoiceDetail&#x60;. - If a credit memo is created from a product rate plan charge, the value of this field is &#x60;ProductRatePlanCharge&#x60;. - If a credit memo is created from a return order line item, the value of this field is &#x60;OrderLineItem&#x60;.               
   * @return sourceItemType
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The type of the source item.  - If a credit memo is not created from an invoice or a product rate plan charge or a return order line item, the value of this field is `SubscriptionComponent`.  - If a credit memo is created from an invoice, the value of this field is `InvoiceDetail`. - If a credit memo is created from a product rate plan charge, the value of this field is `ProductRatePlanCharge`. - If a credit memo is created from a return order line item, the value of this field is `OrderLineItem`.               ")

  public SourceItemTypeEnum getSourceItemType() {
    return sourceItemType;
  }


  public void setSourceItemType(SourceItemTypeEnum sourceItemType) {
    
    
    
    this.sourceItemType = sourceItemType;
  }


  public GETCreditMemoItemTypewithSuccessAllOf subscriptionId(String subscriptionId) {
    
    
    
    
    this.subscriptionId = subscriptionId;
    return this;
  }

   /**
   * The ID of the subscription associated with the credit memo item. 
   * @return subscriptionId
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The ID of the subscription associated with the credit memo item. ")

  public String getSubscriptionId() {
    return subscriptionId;
  }


  public void setSubscriptionId(String subscriptionId) {
    
    
    
    this.subscriptionId = subscriptionId;
  }


  public GETCreditMemoItemTypewithSuccessAllOf taxMode(TaxModeEnum taxMode) {
    
    
    
    
    this.taxMode = taxMode;
    return this;
  }

   /**
   * The tax mode of the credit memo item, indicating whether the amount of the credit memo item includes tax. 
   * @return taxMode
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The tax mode of the credit memo item, indicating whether the amount of the credit memo item includes tax. ")

  public TaxModeEnum getTaxMode() {
    return taxMode;
  }


  public void setTaxMode(TaxModeEnum taxMode) {
    
    
    
    this.taxMode = taxMode;
  }


  public GETCreditMemoItemTypewithSuccessAllOf taxationItems(GETCreditMemoItemTypewithSuccessAllOfTaxationItems taxationItems) {
    
    
    
    
    this.taxationItems = taxationItems;
    return this;
  }

   /**
   * Get taxationItems
   * @return taxationItems
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public GETCreditMemoItemTypewithSuccessAllOfTaxationItems getTaxationItems() {
    return taxationItems;
  }


  public void setTaxationItems(GETCreditMemoItemTypewithSuccessAllOfTaxationItems taxationItems) {
    
    
    
    this.taxationItems = taxationItems;
  }


  public GETCreditMemoItemTypewithSuccessAllOf unappliedAmount(Double unappliedAmount) {
    
    
    
    
    this.unappliedAmount = unappliedAmount;
    return this;
  }

   /**
   * The unapplied amount of the credit memo item. 
   * @return unappliedAmount
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The unapplied amount of the credit memo item. ")

  public Double getUnappliedAmount() {
    return unappliedAmount;
  }


  public void setUnappliedAmount(Double unappliedAmount) {
    
    
    
    this.unappliedAmount = unappliedAmount;
  }


  public GETCreditMemoItemTypewithSuccessAllOf unitOfMeasure(String unitOfMeasure) {
    
    
    
    
    this.unitOfMeasure = unitOfMeasure;
    return this;
  }

   /**
   * The units to measure usage. 
   * @return unitOfMeasure
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The units to measure usage. ")

  public String getUnitOfMeasure() {
    return unitOfMeasure;
  }


  public void setUnitOfMeasure(String unitOfMeasure) {
    
    
    
    this.unitOfMeasure = unitOfMeasure;
  }


  public GETCreditMemoItemTypewithSuccessAllOf unitPrice(Double unitPrice) {
    
    
    
    
    this.unitPrice = unitPrice;
    return this;
  }

   /**
   * The per-unit price of the credit memo item. 
   * @return unitPrice
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The per-unit price of the credit memo item. ")

  public Double getUnitPrice() {
    return unitPrice;
  }


  public void setUnitPrice(Double unitPrice) {
    
    
    
    this.unitPrice = unitPrice;
  }


  public GETCreditMemoItemTypewithSuccessAllOf updatedById(String updatedById) {
    
    
    
    
    this.updatedById = updatedById;
    return this;
  }

   /**
   * The ID of the Zuora user who last updated the credit memo item. 
   * @return updatedById
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The ID of the Zuora user who last updated the credit memo item. ")

  public String getUpdatedById() {
    return updatedById;
  }


  public void setUpdatedById(String updatedById) {
    
    
    
    this.updatedById = updatedById;
  }


  public GETCreditMemoItemTypewithSuccessAllOf updatedDate(OffsetDateTime updatedDate) {
    
    
    
    
    this.updatedDate = updatedDate;
    return this;
  }

   /**
   * The date and time when the credit memo item was last updated, in &#x60;yyyy-mm-dd hh:mm:ss&#x60; format. For example, 2017-03-02 15:36:10. 
   * @return updatedDate
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The date and time when the credit memo item was last updated, in `yyyy-mm-dd hh:mm:ss` format. For example, 2017-03-02 15:36:10. ")

  public OffsetDateTime getUpdatedDate() {
    return updatedDate;
  }


  public void setUpdatedDate(OffsetDateTime updatedDate) {
    
    
    
    this.updatedDate = updatedDate;
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
   * @return the GETCreditMemoItemTypewithSuccessAllOf instance itself
   */
  public GETCreditMemoItemTypewithSuccessAllOf putAdditionalProperty(String key, Object value) {
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
    GETCreditMemoItemTypewithSuccessAllOf geTCreditMemoItemTypewithSuccessAllOf = (GETCreditMemoItemTypewithSuccessAllOf) o;
    return Objects.equals(this.description, geTCreditMemoItemTypewithSuccessAllOf.description) &&
        Objects.equals(this.amount, geTCreditMemoItemTypewithSuccessAllOf.amount) &&
        Objects.equals(this.amountWithoutTax, geTCreditMemoItemTypewithSuccessAllOf.amountWithoutTax) &&
        Objects.equals(this.appliedAmount, geTCreditMemoItemTypewithSuccessAllOf.appliedAmount) &&
        Objects.equals(this.appliedToItemId, geTCreditMemoItemTypewithSuccessAllOf.appliedToItemId) &&
        Objects.equals(this.comment, geTCreditMemoItemTypewithSuccessAllOf.comment) &&
        Objects.equals(this.createdById, geTCreditMemoItemTypewithSuccessAllOf.createdById) &&
        Objects.equals(this.createdDate, geTCreditMemoItemTypewithSuccessAllOf.createdDate) &&
        Objects.equals(this.creditFromItemId, geTCreditMemoItemTypewithSuccessAllOf.creditFromItemId) &&
        Objects.equals(this.creditFromItemSource, geTCreditMemoItemTypewithSuccessAllOf.creditFromItemSource) &&
        Objects.equals(this.creditTaxItems, geTCreditMemoItemTypewithSuccessAllOf.creditTaxItems) &&
        Objects.equals(this.excludeItemBillingFromRevenueAccounting, geTCreditMemoItemTypewithSuccessAllOf.excludeItemBillingFromRevenueAccounting) &&
        Objects.equals(this.financeInformation, geTCreditMemoItemTypewithSuccessAllOf.financeInformation) &&
        Objects.equals(this.id, geTCreditMemoItemTypewithSuccessAllOf.id) &&
        Objects.equals(this.invoiceScheduleId, geTCreditMemoItemTypewithSuccessAllOf.invoiceScheduleId) &&
        Objects.equals(this.invoiceScheduleItemId, geTCreditMemoItemTypewithSuccessAllOf.invoiceScheduleItemId) &&
        Objects.equals(this.numberOfDeliveries, geTCreditMemoItemTypewithSuccessAllOf.numberOfDeliveries) &&
        Objects.equals(this.processingType, geTCreditMemoItemTypewithSuccessAllOf.processingType) &&
        Objects.equals(this.quantity, geTCreditMemoItemTypewithSuccessAllOf.quantity) &&
        Objects.equals(this.refundAmount, geTCreditMemoItemTypewithSuccessAllOf.refundAmount) &&
        Objects.equals(this.serviceEndDate, geTCreditMemoItemTypewithSuccessAllOf.serviceEndDate) &&
        Objects.equals(this.serviceStartDate, geTCreditMemoItemTypewithSuccessAllOf.serviceStartDate) &&
        Objects.equals(this.sku, geTCreditMemoItemTypewithSuccessAllOf.sku) &&
        Objects.equals(this.skuName, geTCreditMemoItemTypewithSuccessAllOf.skuName) &&
        Objects.equals(this.soldToContactId, geTCreditMemoItemTypewithSuccessAllOf.soldToContactId) &&
        Objects.equals(this.soldToContactSnapshotId, geTCreditMemoItemTypewithSuccessAllOf.soldToContactSnapshotId) &&
        Objects.equals(this.sourceItemId, geTCreditMemoItemTypewithSuccessAllOf.sourceItemId) &&
        Objects.equals(this.sourceItemType, geTCreditMemoItemTypewithSuccessAllOf.sourceItemType) &&
        Objects.equals(this.subscriptionId, geTCreditMemoItemTypewithSuccessAllOf.subscriptionId) &&
        Objects.equals(this.taxMode, geTCreditMemoItemTypewithSuccessAllOf.taxMode) &&
        Objects.equals(this.taxationItems, geTCreditMemoItemTypewithSuccessAllOf.taxationItems) &&
        Objects.equals(this.unappliedAmount, geTCreditMemoItemTypewithSuccessAllOf.unappliedAmount) &&
        Objects.equals(this.unitOfMeasure, geTCreditMemoItemTypewithSuccessAllOf.unitOfMeasure) &&
        Objects.equals(this.unitPrice, geTCreditMemoItemTypewithSuccessAllOf.unitPrice) &&
        Objects.equals(this.updatedById, geTCreditMemoItemTypewithSuccessAllOf.updatedById) &&
        Objects.equals(this.updatedDate, geTCreditMemoItemTypewithSuccessAllOf.updatedDate)&&
        Objects.equals(this.additionalProperties, geTCreditMemoItemTypewithSuccessAllOf.additionalProperties);
  }

  @Override
  public int hashCode() {
    return Objects.hash(description, amount, amountWithoutTax, appliedAmount, appliedToItemId, comment, createdById, createdDate, creditFromItemId, creditFromItemSource, creditTaxItems, excludeItemBillingFromRevenueAccounting, financeInformation, id, invoiceScheduleId, invoiceScheduleItemId, numberOfDeliveries, processingType, quantity, refundAmount, serviceEndDate, serviceStartDate, sku, skuName, soldToContactId, soldToContactSnapshotId, sourceItemId, sourceItemType, subscriptionId, taxMode, taxationItems, unappliedAmount, unitOfMeasure, unitPrice, updatedById, updatedDate, additionalProperties);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GETCreditMemoItemTypewithSuccessAllOf {\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
    sb.append("    amountWithoutTax: ").append(toIndentedString(amountWithoutTax)).append("\n");
    sb.append("    appliedAmount: ").append(toIndentedString(appliedAmount)).append("\n");
    sb.append("    appliedToItemId: ").append(toIndentedString(appliedToItemId)).append("\n");
    sb.append("    comment: ").append(toIndentedString(comment)).append("\n");
    sb.append("    createdById: ").append(toIndentedString(createdById)).append("\n");
    sb.append("    createdDate: ").append(toIndentedString(createdDate)).append("\n");
    sb.append("    creditFromItemId: ").append(toIndentedString(creditFromItemId)).append("\n");
    sb.append("    creditFromItemSource: ").append(toIndentedString(creditFromItemSource)).append("\n");
    sb.append("    creditTaxItems: ").append(toIndentedString(creditTaxItems)).append("\n");
    sb.append("    excludeItemBillingFromRevenueAccounting: ").append(toIndentedString(excludeItemBillingFromRevenueAccounting)).append("\n");
    sb.append("    financeInformation: ").append(toIndentedString(financeInformation)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    invoiceScheduleId: ").append(toIndentedString(invoiceScheduleId)).append("\n");
    sb.append("    invoiceScheduleItemId: ").append(toIndentedString(invoiceScheduleItemId)).append("\n");
    sb.append("    numberOfDeliveries: ").append(toIndentedString(numberOfDeliveries)).append("\n");
    sb.append("    processingType: ").append(toIndentedString(processingType)).append("\n");
    sb.append("    quantity: ").append(toIndentedString(quantity)).append("\n");
    sb.append("    refundAmount: ").append(toIndentedString(refundAmount)).append("\n");
    sb.append("    serviceEndDate: ").append(toIndentedString(serviceEndDate)).append("\n");
    sb.append("    serviceStartDate: ").append(toIndentedString(serviceStartDate)).append("\n");
    sb.append("    sku: ").append(toIndentedString(sku)).append("\n");
    sb.append("    skuName: ").append(toIndentedString(skuName)).append("\n");
    sb.append("    soldToContactId: ").append(toIndentedString(soldToContactId)).append("\n");
    sb.append("    soldToContactSnapshotId: ").append(toIndentedString(soldToContactSnapshotId)).append("\n");
    sb.append("    sourceItemId: ").append(toIndentedString(sourceItemId)).append("\n");
    sb.append("    sourceItemType: ").append(toIndentedString(sourceItemType)).append("\n");
    sb.append("    subscriptionId: ").append(toIndentedString(subscriptionId)).append("\n");
    sb.append("    taxMode: ").append(toIndentedString(taxMode)).append("\n");
    sb.append("    taxationItems: ").append(toIndentedString(taxationItems)).append("\n");
    sb.append("    unappliedAmount: ").append(toIndentedString(unappliedAmount)).append("\n");
    sb.append("    unitOfMeasure: ").append(toIndentedString(unitOfMeasure)).append("\n");
    sb.append("    unitPrice: ").append(toIndentedString(unitPrice)).append("\n");
    sb.append("    updatedById: ").append(toIndentedString(updatedById)).append("\n");
    sb.append("    updatedDate: ").append(toIndentedString(updatedDate)).append("\n");
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
    openapiFields.add("amount");
    openapiFields.add("amountWithoutTax");
    openapiFields.add("appliedAmount");
    openapiFields.add("appliedToItemId");
    openapiFields.add("comment");
    openapiFields.add("createdById");
    openapiFields.add("createdDate");
    openapiFields.add("creditFromItemId");
    openapiFields.add("creditFromItemSource");
    openapiFields.add("creditTaxItems");
    openapiFields.add("excludeItemBillingFromRevenueAccounting");
    openapiFields.add("financeInformation");
    openapiFields.add("id");
    openapiFields.add("invoiceScheduleId");
    openapiFields.add("invoiceScheduleItemId");
    openapiFields.add("numberOfDeliveries");
    openapiFields.add("processingType");
    openapiFields.add("quantity");
    openapiFields.add("refundAmount");
    openapiFields.add("serviceEndDate");
    openapiFields.add("serviceStartDate");
    openapiFields.add("sku");
    openapiFields.add("skuName");
    openapiFields.add("soldToContactId");
    openapiFields.add("soldToContactSnapshotId");
    openapiFields.add("sourceItemId");
    openapiFields.add("sourceItemType");
    openapiFields.add("subscriptionId");
    openapiFields.add("taxMode");
    openapiFields.add("taxationItems");
    openapiFields.add("unappliedAmount");
    openapiFields.add("unitOfMeasure");
    openapiFields.add("unitPrice");
    openapiFields.add("updatedById");
    openapiFields.add("updatedDate");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
  }

 /**
  * Validates the JSON Object and throws an exception if issues found
  *
  * @param jsonObj JSON Object
  * @throws IOException if the JSON Object is invalid with respect to GETCreditMemoItemTypewithSuccessAllOf
  */
  public static void validateJsonObject(JsonObject jsonObj) throws IOException {
      if (jsonObj == null) {
        if (!GETCreditMemoItemTypewithSuccessAllOf.openapiRequiredFields.isEmpty()) { // has required fields but JSON object is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in GETCreditMemoItemTypewithSuccessAllOf is not found in the empty JSON string", GETCreditMemoItemTypewithSuccessAllOf.openapiRequiredFields.toString()));
        }
      }
      if ((jsonObj.get("description") != null && !jsonObj.get("description").isJsonNull()) && !jsonObj.get("description").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `description` to be a primitive type in the JSON string but got `%s`", jsonObj.get("description").toString()));
      }
      if ((jsonObj.get("appliedToItemId") != null && !jsonObj.get("appliedToItemId").isJsonNull()) && !jsonObj.get("appliedToItemId").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `appliedToItemId` to be a primitive type in the JSON string but got `%s`", jsonObj.get("appliedToItemId").toString()));
      }
      if ((jsonObj.get("comment") != null && !jsonObj.get("comment").isJsonNull()) && !jsonObj.get("comment").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `comment` to be a primitive type in the JSON string but got `%s`", jsonObj.get("comment").toString()));
      }
      if ((jsonObj.get("createdById") != null && !jsonObj.get("createdById").isJsonNull()) && !jsonObj.get("createdById").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `createdById` to be a primitive type in the JSON string but got `%s`", jsonObj.get("createdById").toString()));
      }
      if ((jsonObj.get("creditFromItemId") != null && !jsonObj.get("creditFromItemId").isJsonNull()) && !jsonObj.get("creditFromItemId").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `creditFromItemId` to be a primitive type in the JSON string but got `%s`", jsonObj.get("creditFromItemId").toString()));
      }
      if ((jsonObj.get("creditFromItemSource") != null && !jsonObj.get("creditFromItemSource").isJsonNull()) && !jsonObj.get("creditFromItemSource").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `creditFromItemSource` to be a primitive type in the JSON string but got `%s`", jsonObj.get("creditFromItemSource").toString()));
      }
      if (jsonObj.get("creditTaxItems") != null && !jsonObj.get("creditTaxItems").isJsonNull()) {
        JsonArray jsonArraycreditTaxItems = jsonObj.getAsJsonArray("creditTaxItems");
        if (jsonArraycreditTaxItems != null) {
          // ensure the json data is an array
          if (!jsonObj.get("creditTaxItems").isJsonArray()) {
            throw new IllegalArgumentException(String.format("Expected the field `creditTaxItems` to be an array in the JSON string but got `%s`", jsonObj.get("creditTaxItems").toString()));
          }

          // validate the optional field `creditTaxItems` (array)
          for (int i = 0; i < jsonArraycreditTaxItems.size(); i++) {
            GETCMTaxItemType.validateJsonObject(jsonArraycreditTaxItems.get(i).getAsJsonObject());
          };
        }
      }
      // validate the optional field `financeInformation`
      if (jsonObj.get("financeInformation") != null && !jsonObj.get("financeInformation").isJsonNull()) {
        GETCreditMemoItemTypewithSuccessAllOfFinanceInformation.validateJsonObject(jsonObj.getAsJsonObject("financeInformation"));
      }
      if ((jsonObj.get("id") != null && !jsonObj.get("id").isJsonNull()) && !jsonObj.get("id").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `id` to be a primitive type in the JSON string but got `%s`", jsonObj.get("id").toString()));
      }
      if ((jsonObj.get("invoiceScheduleId") != null && !jsonObj.get("invoiceScheduleId").isJsonNull()) && !jsonObj.get("invoiceScheduleId").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `invoiceScheduleId` to be a primitive type in the JSON string but got `%s`", jsonObj.get("invoiceScheduleId").toString()));
      }
      if ((jsonObj.get("invoiceScheduleItemId") != null && !jsonObj.get("invoiceScheduleItemId").isJsonNull()) && !jsonObj.get("invoiceScheduleItemId").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `invoiceScheduleItemId` to be a primitive type in the JSON string but got `%s`", jsonObj.get("invoiceScheduleItemId").toString()));
      }
      if ((jsonObj.get("processingType") != null && !jsonObj.get("processingType").isJsonNull()) && !jsonObj.get("processingType").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `processingType` to be a primitive type in the JSON string but got `%s`", jsonObj.get("processingType").toString()));
      }
      if ((jsonObj.get("sku") != null && !jsonObj.get("sku").isJsonNull()) && !jsonObj.get("sku").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `sku` to be a primitive type in the JSON string but got `%s`", jsonObj.get("sku").toString()));
      }
      if ((jsonObj.get("skuName") != null && !jsonObj.get("skuName").isJsonNull()) && !jsonObj.get("skuName").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `skuName` to be a primitive type in the JSON string but got `%s`", jsonObj.get("skuName").toString()));
      }
      if ((jsonObj.get("soldToContactId") != null && !jsonObj.get("soldToContactId").isJsonNull()) && !jsonObj.get("soldToContactId").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `soldToContactId` to be a primitive type in the JSON string but got `%s`", jsonObj.get("soldToContactId").toString()));
      }
      if ((jsonObj.get("soldToContactSnapshotId") != null && !jsonObj.get("soldToContactSnapshotId").isJsonNull()) && !jsonObj.get("soldToContactSnapshotId").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `soldToContactSnapshotId` to be a primitive type in the JSON string but got `%s`", jsonObj.get("soldToContactSnapshotId").toString()));
      }
      if ((jsonObj.get("sourceItemId") != null && !jsonObj.get("sourceItemId").isJsonNull()) && !jsonObj.get("sourceItemId").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `sourceItemId` to be a primitive type in the JSON string but got `%s`", jsonObj.get("sourceItemId").toString()));
      }
      if ((jsonObj.get("sourceItemType") != null && !jsonObj.get("sourceItemType").isJsonNull()) && !jsonObj.get("sourceItemType").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `sourceItemType` to be a primitive type in the JSON string but got `%s`", jsonObj.get("sourceItemType").toString()));
      }
      if ((jsonObj.get("subscriptionId") != null && !jsonObj.get("subscriptionId").isJsonNull()) && !jsonObj.get("subscriptionId").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `subscriptionId` to be a primitive type in the JSON string but got `%s`", jsonObj.get("subscriptionId").toString()));
      }
      if ((jsonObj.get("taxMode") != null && !jsonObj.get("taxMode").isJsonNull()) && !jsonObj.get("taxMode").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `taxMode` to be a primitive type in the JSON string but got `%s`", jsonObj.get("taxMode").toString()));
      }
      // validate the optional field `taxationItems`
      if (jsonObj.get("taxationItems") != null && !jsonObj.get("taxationItems").isJsonNull()) {
        GETCreditMemoItemTypewithSuccessAllOfTaxationItems.validateJsonObject(jsonObj.getAsJsonObject("taxationItems"));
      }
      if ((jsonObj.get("unitOfMeasure") != null && !jsonObj.get("unitOfMeasure").isJsonNull()) && !jsonObj.get("unitOfMeasure").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `unitOfMeasure` to be a primitive type in the JSON string but got `%s`", jsonObj.get("unitOfMeasure").toString()));
      }
      if ((jsonObj.get("updatedById") != null && !jsonObj.get("updatedById").isJsonNull()) && !jsonObj.get("updatedById").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `updatedById` to be a primitive type in the JSON string but got `%s`", jsonObj.get("updatedById").toString()));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!GETCreditMemoItemTypewithSuccessAllOf.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'GETCreditMemoItemTypewithSuccessAllOf' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<GETCreditMemoItemTypewithSuccessAllOf> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(GETCreditMemoItemTypewithSuccessAllOf.class));

       return (TypeAdapter<T>) new TypeAdapter<GETCreditMemoItemTypewithSuccessAllOf>() {
           @Override
           public void write(JsonWriter out, GETCreditMemoItemTypewithSuccessAllOf value) throws IOException {
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
           public GETCreditMemoItemTypewithSuccessAllOf read(JsonReader in) throws IOException {
             JsonObject jsonObj = elementAdapter.read(in).getAsJsonObject();
             validateJsonObject(jsonObj);
             // store additional fields in the deserialized instance
             GETCreditMemoItemTypewithSuccessAllOf instance = thisAdapter.fromJsonTree(jsonObj);
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
  * Create an instance of GETCreditMemoItemTypewithSuccessAllOf given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of GETCreditMemoItemTypewithSuccessAllOf
  * @throws IOException if the JSON string is invalid with respect to GETCreditMemoItemTypewithSuccessAllOf
  */
  public static GETCreditMemoItemTypewithSuccessAllOf fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, GETCreditMemoItemTypewithSuccessAllOf.class);
  }

 /**
  * Convert an instance of GETCreditMemoItemTypewithSuccessAllOf to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

