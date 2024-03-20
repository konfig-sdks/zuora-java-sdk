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
import java.time.LocalDate;
import java.time.OffsetDateTime;
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
 * GETDebitMemoTypewithSuccessAllOf
 */@javax.annotation.Generated(value = "Generated by https://konfigthis.com")
public class GETDebitMemoTypewithSuccessAllOf {
  public static final String SERIALIZED_NAME_ACCOUNT_ID = "accountId";
  @SerializedName(SERIALIZED_NAME_ACCOUNT_ID)
  private String accountId;

  public static final String SERIALIZED_NAME_ACCOUNT_NUMBER = "accountNumber";
  @SerializedName(SERIALIZED_NAME_ACCOUNT_NUMBER)
  private String accountNumber;

  public static final String SERIALIZED_NAME_AMOUNT = "amount";
  @SerializedName(SERIALIZED_NAME_AMOUNT)
  private Double amount;

  public static final String SERIALIZED_NAME_AUTO_PAY = "autoPay";
  @SerializedName(SERIALIZED_NAME_AUTO_PAY)
  private Boolean autoPay;

  public static final String SERIALIZED_NAME_BALANCE = "balance";
  @SerializedName(SERIALIZED_NAME_BALANCE)
  private Double balance;

  public static final String SERIALIZED_NAME_BE_APPLIED_AMOUNT = "beAppliedAmount";
  @SerializedName(SERIALIZED_NAME_BE_APPLIED_AMOUNT)
  private Double beAppliedAmount;

  public static final String SERIALIZED_NAME_BILL_TO_CONTACT_ID = "billToContactId";
  @SerializedName(SERIALIZED_NAME_BILL_TO_CONTACT_ID)
  private String billToContactId;

  public static final String SERIALIZED_NAME_CANCELLED_BY_ID = "cancelledById";
  @SerializedName(SERIALIZED_NAME_CANCELLED_BY_ID)
  private String cancelledById;

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

  public static final String SERIALIZED_NAME_CURRENCY = "currency";
  @SerializedName(SERIALIZED_NAME_CURRENCY)
  private String currency;

  public static final String SERIALIZED_NAME_DEBIT_MEMO_DATE = "debitMemoDate";
  @SerializedName(SERIALIZED_NAME_DEBIT_MEMO_DATE)
  private LocalDate debitMemoDate;

  public static final String SERIALIZED_NAME_DUE_DATE = "dueDate";
  @SerializedName(SERIALIZED_NAME_DUE_DATE)
  private LocalDate dueDate;

  public static final String SERIALIZED_NAME_EINVOICE_ERROR_CODE = "einvoiceErrorCode";
  @SerializedName(SERIALIZED_NAME_EINVOICE_ERROR_CODE)
  private String einvoiceErrorCode;

  public static final String SERIALIZED_NAME_EINVOICE_ERROR_MESSAGE = "einvoiceErrorMessage";
  @SerializedName(SERIALIZED_NAME_EINVOICE_ERROR_MESSAGE)
  private String einvoiceErrorMessage;

  public static final String SERIALIZED_NAME_EINVOICE_FILE_ID = "einvoiceFileId";
  @SerializedName(SERIALIZED_NAME_EINVOICE_FILE_ID)
  private String einvoiceFileId;

  /**
   * The status of the e-invoice file generation for the debit memo.   - If e-invoice file generation succeeds, this field is either &#x60;Generated&#x60; or &#x60;Success&#x60;, and both the error code and message are empty, and the &#x60;eInvoiceFileId&#x60; field stores the ID of the generated e-invoice file. - If a failure occurs during e-invoice file generation, this field is &#x60;Failed&#x60; and an error code and an error message are returned respectively in the &#x60;einvoiceErrorCode&#x60; and &#x60;einvoiceErrorMessage&#x60; fields.   **Note**: This field is available only if you have the &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Bill_your_customers/E-Invoicing\&quot; target&#x3D;\&quot;_blank\&quot;&gt;E-Invoicing&lt;/a&gt; feature in **Early Adopter** phase enabled. 
   */
  @JsonAdapter(EinvoiceStatusEnum.Adapter.class)
 public enum EinvoiceStatusEnum {
    PROCESSING("Processing"),
    
    GENERATED("Generated"),
    
    SUCCESS("Success"),
    
    FAILED("Failed");

    private String value;

    EinvoiceStatusEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static EinvoiceStatusEnum fromValue(String value) {
      for (EinvoiceStatusEnum b : EinvoiceStatusEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<EinvoiceStatusEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final EinvoiceStatusEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public EinvoiceStatusEnum read(final JsonReader jsonReader) throws IOException {
        String value =  jsonReader.nextString();
        return EinvoiceStatusEnum.fromValue(value);
      }
    }
  }

  public static final String SERIALIZED_NAME_EINVOICE_STATUS = "einvoiceStatus";
  @SerializedName(SERIALIZED_NAME_EINVOICE_STATUS)
  private EinvoiceStatusEnum einvoiceStatus;

  public static final String SERIALIZED_NAME_ID = "id";
  @SerializedName(SERIALIZED_NAME_ID)
  private String id;

  public static final String SERIALIZED_NAME_INVOICE_GROUP_NUMBER = "invoiceGroupNumber";
  @SerializedName(SERIALIZED_NAME_INVOICE_GROUP_NUMBER)
  private String invoiceGroupNumber;

  public static final String SERIALIZED_NAME_LATEST_P_D_F_FILE_ID = "latestPDFFileId";
  @SerializedName(SERIALIZED_NAME_LATEST_P_D_F_FILE_ID)
  private String latestPDFFileId;

  public static final String SERIALIZED_NAME_NUMBER = "number";
  @SerializedName(SERIALIZED_NAME_NUMBER)
  private String number;

  public static final String SERIALIZED_NAME_PAYMENT_TERM = "paymentTerm";
  @SerializedName(SERIALIZED_NAME_PAYMENT_TERM)
  private String paymentTerm;

  public static final String SERIALIZED_NAME_POSTED_BY_ID = "postedById";
  @SerializedName(SERIALIZED_NAME_POSTED_BY_ID)
  private String postedById;

  public static final String SERIALIZED_NAME_POSTED_ON = "postedOn";
  @SerializedName(SERIALIZED_NAME_POSTED_ON)
  private OffsetDateTime postedOn;

  public static final String SERIALIZED_NAME_REASON_CODE = "reasonCode";
  @SerializedName(SERIALIZED_NAME_REASON_CODE)
  private String reasonCode;

  public static final String SERIALIZED_NAME_REFERRED_CREDIT_MEMO_ID = "referredCreditMemoId";
  @SerializedName(SERIALIZED_NAME_REFERRED_CREDIT_MEMO_ID)
  private String referredCreditMemoId;

  public static final String SERIALIZED_NAME_REFERRED_INVOICE_ID = "referredInvoiceId";
  @SerializedName(SERIALIZED_NAME_REFERRED_INVOICE_ID)
  private String referredInvoiceId;

  public static final String SERIALIZED_NAME_SEQUENCE_SET_ID = "sequenceSetId";
  @SerializedName(SERIALIZED_NAME_SEQUENCE_SET_ID)
  private String sequenceSetId;

  /**
   * The type of the debit memo source. 
   */
  @JsonAdapter(SourceTypeEnum.Adapter.class)
 public enum SourceTypeEnum {
    SUBSCRIPTION("Subscription"),
    
    STANDALONE("Standalone"),
    
    ORDER("Order"),
    
    CONSOLIDATION("Consolidation"),
    
    INVOICE("Invoice"),
    
    CREDITMEMO("CreditMemo");

    private String value;

    SourceTypeEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static SourceTypeEnum fromValue(String value) {
      for (SourceTypeEnum b : SourceTypeEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<SourceTypeEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final SourceTypeEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public SourceTypeEnum read(final JsonReader jsonReader) throws IOException {
        String value =  jsonReader.nextString();
        return SourceTypeEnum.fromValue(value);
      }
    }
  }

  public static final String SERIALIZED_NAME_SOURCE_TYPE = "sourceType";
  @SerializedName(SERIALIZED_NAME_SOURCE_TYPE)
  private SourceTypeEnum sourceType;

  /**
   * The status of the debit memo.  
   */
  @JsonAdapter(StatusEnum.Adapter.class)
 public enum StatusEnum {
    DRAFT("Draft"),
    
    POSTED("Posted"),
    
    CANCELED("Canceled"),
    
    ERROR("Error"),
    
    PENDINGFORTAX("PendingForTax"),
    
    GENERATING("Generating"),
    
    CANCELINPROGRESS("CancelInProgress");

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

  public static final String SERIALIZED_NAME_TARGET_DATE = "targetDate";
  @SerializedName(SERIALIZED_NAME_TARGET_DATE)
  private LocalDate targetDate;

  public static final String SERIALIZED_NAME_TAX_AMOUNT = "taxAmount";
  @SerializedName(SERIALIZED_NAME_TAX_AMOUNT)
  private Double taxAmount;

  public static final String SERIALIZED_NAME_TAX_MESSAGE = "taxMessage";
  @SerializedName(SERIALIZED_NAME_TAX_MESSAGE)
  private String taxMessage;

  /**
   * The status of tax calculation related to the debit memo.  **Note**: This field is only applicable to tax calculation by third-party tax engines. 
   */
  @JsonAdapter(TaxStatusEnum.Adapter.class)
 public enum TaxStatusEnum {
    COMPLETE("Complete"),
    
    ERROR("Error");

    private String value;

    TaxStatusEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static TaxStatusEnum fromValue(String value) {
      for (TaxStatusEnum b : TaxStatusEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<TaxStatusEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final TaxStatusEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public TaxStatusEnum read(final JsonReader jsonReader) throws IOException {
        String value =  jsonReader.nextString();
        return TaxStatusEnum.fromValue(value);
      }
    }
  }

  public static final String SERIALIZED_NAME_TAX_STATUS = "taxStatus";
  @SerializedName(SERIALIZED_NAME_TAX_STATUS)
  private TaxStatusEnum taxStatus;

  public static final String SERIALIZED_NAME_TOTAL_TAX_EXEMPT_AMOUNT = "totalTaxExemptAmount";
  @SerializedName(SERIALIZED_NAME_TOTAL_TAX_EXEMPT_AMOUNT)
  private Double totalTaxExemptAmount;

  /**
   * Whether the debit memo was transferred to an external accounting system. Use this field for integration with accounting systems, such as NetSuite.  
   */
  @JsonAdapter(TransferredToAccountingEnum.Adapter.class)
 public enum TransferredToAccountingEnum {
    PROCESSING("Processing"),
    
    TRUE("true"),
    
    FALSE("false"),
    
    ERROR("Error"),
    
    IGNORE("Ignore");

    private String value;

    TransferredToAccountingEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static TransferredToAccountingEnum fromValue(String value) {
      for (TransferredToAccountingEnum b : TransferredToAccountingEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<TransferredToAccountingEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final TransferredToAccountingEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public TransferredToAccountingEnum read(final JsonReader jsonReader) throws IOException {
        String value =  jsonReader.nextString();
        return TransferredToAccountingEnum.fromValue(value);
      }
    }
  }

  public static final String SERIALIZED_NAME_TRANSFERRED_TO_ACCOUNTING = "transferredToAccounting";
  @SerializedName(SERIALIZED_NAME_TRANSFERRED_TO_ACCOUNTING)
  private TransferredToAccountingEnum transferredToAccounting;

  public static final String SERIALIZED_NAME_UPDATED_BY_ID = "updatedById";
  @SerializedName(SERIALIZED_NAME_UPDATED_BY_ID)
  private String updatedById;

  public static final String SERIALIZED_NAME_UPDATED_DATE = "updatedDate";
  @SerializedName(SERIALIZED_NAME_UPDATED_DATE)
  private OffsetDateTime updatedDate;

  public GETDebitMemoTypewithSuccessAllOf() {
  }

  public GETDebitMemoTypewithSuccessAllOf accountId(String accountId) {
    
    
    
    
    this.accountId = accountId;
    return this;
  }

   /**
   * The ID of the customer account associated with the debit memo. 
   * @return accountId
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The ID of the customer account associated with the debit memo. ")

  public String getAccountId() {
    return accountId;
  }


  public void setAccountId(String accountId) {
    
    
    
    this.accountId = accountId;
  }


  public GETDebitMemoTypewithSuccessAllOf accountNumber(String accountNumber) {
    
    
    
    
    this.accountNumber = accountNumber;
    return this;
  }

   /**
   * The number of the customer account associated with the debit memo. 
   * @return accountNumber
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The number of the customer account associated with the debit memo. ")

  public String getAccountNumber() {
    return accountNumber;
  }


  public void setAccountNumber(String accountNumber) {
    
    
    
    this.accountNumber = accountNumber;
  }


  public GETDebitMemoTypewithSuccessAllOf amount(Double amount) {
    
    
    
    
    this.amount = amount;
    return this;
  }

   /**
   * The total amount of the debit memo. 
   * @return amount
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The total amount of the debit memo. ")

  public Double getAmount() {
    return amount;
  }


  public void setAmount(Double amount) {
    
    
    
    this.amount = amount;
  }


  public GETDebitMemoTypewithSuccessAllOf autoPay(Boolean autoPay) {
    
    
    
    
    this.autoPay = autoPay;
    return this;
  }

   /**
   * Whether debit memos are automatically picked up for processing in the corresponding payment run.   By default, debit memos are automatically picked up for processing in the corresponding payment run.       
   * @return autoPay
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Whether debit memos are automatically picked up for processing in the corresponding payment run.   By default, debit memos are automatically picked up for processing in the corresponding payment run.       ")

  public Boolean getAutoPay() {
    return autoPay;
  }


  public void setAutoPay(Boolean autoPay) {
    
    
    
    this.autoPay = autoPay;
  }


  public GETDebitMemoTypewithSuccessAllOf balance(Double balance) {
    
    
    
    
    this.balance = balance;
    return this;
  }

   /**
   * The balance of the debit memo. 
   * @return balance
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The balance of the debit memo. ")

  public Double getBalance() {
    return balance;
  }


  public void setBalance(Double balance) {
    
    
    
    this.balance = balance;
  }


  public GETDebitMemoTypewithSuccessAllOf beAppliedAmount(Double beAppliedAmount) {
    
    
    
    
    this.beAppliedAmount = beAppliedAmount;
    return this;
  }

   /**
   * The applied amount of the debit memo. 
   * @return beAppliedAmount
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The applied amount of the debit memo. ")

  public Double getBeAppliedAmount() {
    return beAppliedAmount;
  }


  public void setBeAppliedAmount(Double beAppliedAmount) {
    
    
    
    this.beAppliedAmount = beAppliedAmount;
  }


  public GETDebitMemoTypewithSuccessAllOf billToContactId(String billToContactId) {
    
    
    
    
    this.billToContactId = billToContactId;
    return this;
  }

   /**
   * The ID of the bill-to contact associated with the debit memo.  The value of this field is &#x60;null&#x60; if you have the [Flexible Billing Attributes](https://knowledgecenter.zuora.com/Billing/Subscriptions/Flexible_Billing_Attributes) feature disabled. 
   * @return billToContactId
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The ID of the bill-to contact associated with the debit memo.  The value of this field is `null` if you have the [Flexible Billing Attributes](https://knowledgecenter.zuora.com/Billing/Subscriptions/Flexible_Billing_Attributes) feature disabled. ")

  public String getBillToContactId() {
    return billToContactId;
  }


  public void setBillToContactId(String billToContactId) {
    
    
    
    this.billToContactId = billToContactId;
  }


  public GETDebitMemoTypewithSuccessAllOf cancelledById(String cancelledById) {
    
    
    
    
    this.cancelledById = cancelledById;
    return this;
  }

   /**
   * The ID of the Zuora user who cancelled the debit memo. 
   * @return cancelledById
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The ID of the Zuora user who cancelled the debit memo. ")

  public String getCancelledById() {
    return cancelledById;
  }


  public void setCancelledById(String cancelledById) {
    
    
    
    this.cancelledById = cancelledById;
  }


  public GETDebitMemoTypewithSuccessAllOf cancelledOn(OffsetDateTime cancelledOn) {
    
    
    
    
    this.cancelledOn = cancelledOn;
    return this;
  }

   /**
   * The date and time when the debit memo was cancelled, in &#x60;yyyy-mm-dd hh:mm:ss&#x60; format. 
   * @return cancelledOn
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The date and time when the debit memo was cancelled, in `yyyy-mm-dd hh:mm:ss` format. ")

  public OffsetDateTime getCancelledOn() {
    return cancelledOn;
  }


  public void setCancelledOn(OffsetDateTime cancelledOn) {
    
    
    
    this.cancelledOn = cancelledOn;
  }


  public GETDebitMemoTypewithSuccessAllOf comment(String comment) {
    
    
    
    
    this.comment = comment;
    return this;
  }

   /**
   * Comments about the debit memo. 
   * @return comment
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Comments about the debit memo. ")

  public String getComment() {
    return comment;
  }


  public void setComment(String comment) {
    
    
    
    this.comment = comment;
  }


  public GETDebitMemoTypewithSuccessAllOf createdById(String createdById) {
    
    
    
    
    this.createdById = createdById;
    return this;
  }

   /**
   * The ID of the Zuora user who created the debit memo. 
   * @return createdById
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The ID of the Zuora user who created the debit memo. ")

  public String getCreatedById() {
    return createdById;
  }


  public void setCreatedById(String createdById) {
    
    
    
    this.createdById = createdById;
  }


  public GETDebitMemoTypewithSuccessAllOf createdDate(OffsetDateTime createdDate) {
    
    
    
    
    this.createdDate = createdDate;
    return this;
  }

   /**
   * The date and time when the debit memo was created, in &#x60;yyyy-mm-dd hh:mm:ss&#x60; format. For example, 2017-03-01 15:31:10. 
   * @return createdDate
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The date and time when the debit memo was created, in `yyyy-mm-dd hh:mm:ss` format. For example, 2017-03-01 15:31:10. ")

  public OffsetDateTime getCreatedDate() {
    return createdDate;
  }


  public void setCreatedDate(OffsetDateTime createdDate) {
    
    
    
    this.createdDate = createdDate;
  }


  public GETDebitMemoTypewithSuccessAllOf currency(String currency) {
    
    
    
    
    this.currency = currency;
    return this;
  }

   /**
   * The currency of the debit memo.  **Note:** By default, the currency on a billing document matches the default currency set on the associated account.  However, Zuora now offers a Multiple Currencies feature to support different currencies for billing documents, allowing flexibility beyond the account-level currency.  For more information, see &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Bill_your_customers/Flexible_Billing/Multiple_Currencies\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Multiple Currency&lt;/a&gt;. 
   * @return currency
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The currency of the debit memo.  **Note:** By default, the currency on a billing document matches the default currency set on the associated account.  However, Zuora now offers a Multiple Currencies feature to support different currencies for billing documents, allowing flexibility beyond the account-level currency.  For more information, see <a href=\"https://knowledgecenter.zuora.com/Zuora_Billing/Bill_your_customers/Flexible_Billing/Multiple_Currencies\" target=\"_blank\">Multiple Currency</a>. ")

  public String getCurrency() {
    return currency;
  }


  public void setCurrency(String currency) {
    
    
    
    this.currency = currency;
  }


  public GETDebitMemoTypewithSuccessAllOf debitMemoDate(LocalDate debitMemoDate) {
    
    
    
    
    this.debitMemoDate = debitMemoDate;
    return this;
  }

   /**
   * The date when the debit memo takes effect, in &#x60;yyyy-mm-dd&#x60; format. For example, 2017-05-20. 
   * @return debitMemoDate
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The date when the debit memo takes effect, in `yyyy-mm-dd` format. For example, 2017-05-20. ")

  public LocalDate getDebitMemoDate() {
    return debitMemoDate;
  }


  public void setDebitMemoDate(LocalDate debitMemoDate) {
    
    
    
    this.debitMemoDate = debitMemoDate;
  }


  public GETDebitMemoTypewithSuccessAllOf dueDate(LocalDate dueDate) {
    
    
    
    
    this.dueDate = dueDate;
    return this;
  }

   /**
   * The date by which the payment for the debit memo is due, in &#x60;yyyy-mm-dd&#x60; format. 
   * @return dueDate
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The date by which the payment for the debit memo is due, in `yyyy-mm-dd` format. ")

  public LocalDate getDueDate() {
    return dueDate;
  }


  public void setDueDate(LocalDate dueDate) {
    
    
    
    this.dueDate = dueDate;
  }


  public GETDebitMemoTypewithSuccessAllOf einvoiceErrorCode(String einvoiceErrorCode) {
    
    
    
    
    this.einvoiceErrorCode = einvoiceErrorCode;
    return this;
  }

   /**
   * The error code returned when the e-invoice file status is &#x60;Failed&#x60;. This code can either be a Zuora-generated error code or one returned by a third-party e-invoicing service provider.  **Note**: This field is available only if you have the &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Bill_your_customers/E-Invoicing\&quot; target&#x3D;\&quot;_blank\&quot;&gt;E-Invoicing&lt;/a&gt; feature in **Early Adopter** phase enabled. 
   * @return einvoiceErrorCode
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The error code returned when the e-invoice file status is `Failed`. This code can either be a Zuora-generated error code or one returned by a third-party e-invoicing service provider.  **Note**: This field is available only if you have the <a href=\"https://knowledgecenter.zuora.com/Zuora_Billing/Bill_your_customers/E-Invoicing\" target=\"_blank\">E-Invoicing</a> feature in **Early Adopter** phase enabled. ")

  public String getEinvoiceErrorCode() {
    return einvoiceErrorCode;
  }


  public void setEinvoiceErrorCode(String einvoiceErrorCode) {
    
    
    
    this.einvoiceErrorCode = einvoiceErrorCode;
  }


  public GETDebitMemoTypewithSuccessAllOf einvoiceErrorMessage(String einvoiceErrorMessage) {
    
    
    
    
    this.einvoiceErrorMessage = einvoiceErrorMessage;
    return this;
  }

   /**
   * The error message returned when the e-invoice file status is &#x60;Failed&#x60;. This message can either be a Zuora-generated error message or one returned by a third-party e-invoicing service provider.  **Note**: This field is available only if you have the &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Bill_your_customers/E-Invoicing\&quot; target&#x3D;\&quot;_blank\&quot;&gt;E-Invoicing&lt;/a&gt; feature in **Early Adopter** phase enabled. 
   * @return einvoiceErrorMessage
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The error message returned when the e-invoice file status is `Failed`. This message can either be a Zuora-generated error message or one returned by a third-party e-invoicing service provider.  **Note**: This field is available only if you have the <a href=\"https://knowledgecenter.zuora.com/Zuora_Billing/Bill_your_customers/E-Invoicing\" target=\"_blank\">E-Invoicing</a> feature in **Early Adopter** phase enabled. ")

  public String getEinvoiceErrorMessage() {
    return einvoiceErrorMessage;
  }


  public void setEinvoiceErrorMessage(String einvoiceErrorMessage) {
    
    
    
    this.einvoiceErrorMessage = einvoiceErrorMessage;
  }


  public GETDebitMemoTypewithSuccessAllOf einvoiceFileId(String einvoiceFileId) {
    
    
    
    
    this.einvoiceFileId = einvoiceFileId;
    return this;
  }

   /**
   * The ID of the e-invoice file generated for the debit memo.  **Note**: This field is available only if you have the &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Bill_your_customers/E-Invoicing\&quot; target&#x3D;\&quot;_blank\&quot;&gt;E-Invoicing&lt;/a&gt; feature in **Early Adopter** phase enabled. 
   * @return einvoiceFileId
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The ID of the e-invoice file generated for the debit memo.  **Note**: This field is available only if you have the <a href=\"https://knowledgecenter.zuora.com/Zuora_Billing/Bill_your_customers/E-Invoicing\" target=\"_blank\">E-Invoicing</a> feature in **Early Adopter** phase enabled. ")

  public String getEinvoiceFileId() {
    return einvoiceFileId;
  }


  public void setEinvoiceFileId(String einvoiceFileId) {
    
    
    
    this.einvoiceFileId = einvoiceFileId;
  }


  public GETDebitMemoTypewithSuccessAllOf einvoiceStatus(EinvoiceStatusEnum einvoiceStatus) {
    
    
    
    
    this.einvoiceStatus = einvoiceStatus;
    return this;
  }

   /**
   * The status of the e-invoice file generation for the debit memo.   - If e-invoice file generation succeeds, this field is either &#x60;Generated&#x60; or &#x60;Success&#x60;, and both the error code and message are empty, and the &#x60;eInvoiceFileId&#x60; field stores the ID of the generated e-invoice file. - If a failure occurs during e-invoice file generation, this field is &#x60;Failed&#x60; and an error code and an error message are returned respectively in the &#x60;einvoiceErrorCode&#x60; and &#x60;einvoiceErrorMessage&#x60; fields.   **Note**: This field is available only if you have the &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Bill_your_customers/E-Invoicing\&quot; target&#x3D;\&quot;_blank\&quot;&gt;E-Invoicing&lt;/a&gt; feature in **Early Adopter** phase enabled. 
   * @return einvoiceStatus
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The status of the e-invoice file generation for the debit memo.   - If e-invoice file generation succeeds, this field is either `Generated` or `Success`, and both the error code and message are empty, and the `eInvoiceFileId` field stores the ID of the generated e-invoice file. - If a failure occurs during e-invoice file generation, this field is `Failed` and an error code and an error message are returned respectively in the `einvoiceErrorCode` and `einvoiceErrorMessage` fields.   **Note**: This field is available only if you have the <a href=\"https://knowledgecenter.zuora.com/Zuora_Billing/Bill_your_customers/E-Invoicing\" target=\"_blank\">E-Invoicing</a> feature in **Early Adopter** phase enabled. ")

  public EinvoiceStatusEnum getEinvoiceStatus() {
    return einvoiceStatus;
  }


  public void setEinvoiceStatus(EinvoiceStatusEnum einvoiceStatus) {
    
    
    
    this.einvoiceStatus = einvoiceStatus;
  }


  public GETDebitMemoTypewithSuccessAllOf id(String id) {
    
    
    
    
    this.id = id;
    return this;
  }

   /**
   * The unique ID of the debit memo. 
   * @return id
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The unique ID of the debit memo. ")

  public String getId() {
    return id;
  }


  public void setId(String id) {
    
    
    
    this.id = id;
  }


  public GETDebitMemoTypewithSuccessAllOf invoiceGroupNumber(String invoiceGroupNumber) {
    
    
    
    
    this.invoiceGroupNumber = invoiceGroupNumber;
    return this;
  }

   /**
   * The number of the invoice group associated with the debit memo.  The value of this field is &#x60;null&#x60; if you have the [Flexible Billing Attributes](https://knowledgecenter.zuora.com/Billing/Subscriptions/Flexible_Billing_Attributes) feature disabled. 
   * @return invoiceGroupNumber
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The number of the invoice group associated with the debit memo.  The value of this field is `null` if you have the [Flexible Billing Attributes](https://knowledgecenter.zuora.com/Billing/Subscriptions/Flexible_Billing_Attributes) feature disabled. ")

  public String getInvoiceGroupNumber() {
    return invoiceGroupNumber;
  }


  public void setInvoiceGroupNumber(String invoiceGroupNumber) {
    
    
    
    this.invoiceGroupNumber = invoiceGroupNumber;
  }


  public GETDebitMemoTypewithSuccessAllOf latestPDFFileId(String latestPDFFileId) {
    
    
    
    
    this.latestPDFFileId = latestPDFFileId;
    return this;
  }

   /**
   * The ID of the latest PDF file generated for the debit memo. 
   * @return latestPDFFileId
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The ID of the latest PDF file generated for the debit memo. ")

  public String getLatestPDFFileId() {
    return latestPDFFileId;
  }


  public void setLatestPDFFileId(String latestPDFFileId) {
    
    
    
    this.latestPDFFileId = latestPDFFileId;
  }


  public GETDebitMemoTypewithSuccessAllOf number(String number) {
    
    
    
    
    this.number = number;
    return this;
  }

   /**
   * The unique identification number of the debit memo. 
   * @return number
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The unique identification number of the debit memo. ")

  public String getNumber() {
    return number;
  }


  public void setNumber(String number) {
    
    
    
    this.number = number;
  }


  public GETDebitMemoTypewithSuccessAllOf paymentTerm(String paymentTerm) {
    
    
    
    
    this.paymentTerm = paymentTerm;
    return this;
  }

   /**
   * The name of the payment term associated with the debit memo.  The value of this field is &#x60;null&#x60; if you have the [Flexible Billing Attributes](https://knowledgecenter.zuora.com/Billing/Subscriptions/Flexible_Billing_Attributes) feature disabled. 
   * @return paymentTerm
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The name of the payment term associated with the debit memo.  The value of this field is `null` if you have the [Flexible Billing Attributes](https://knowledgecenter.zuora.com/Billing/Subscriptions/Flexible_Billing_Attributes) feature disabled. ")

  public String getPaymentTerm() {
    return paymentTerm;
  }


  public void setPaymentTerm(String paymentTerm) {
    
    
    
    this.paymentTerm = paymentTerm;
  }


  public GETDebitMemoTypewithSuccessAllOf postedById(String postedById) {
    
    
    
    
    this.postedById = postedById;
    return this;
  }

   /**
   * The ID of the Zuora user who posted the debit memo. 
   * @return postedById
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The ID of the Zuora user who posted the debit memo. ")

  public String getPostedById() {
    return postedById;
  }


  public void setPostedById(String postedById) {
    
    
    
    this.postedById = postedById;
  }


  public GETDebitMemoTypewithSuccessAllOf postedOn(OffsetDateTime postedOn) {
    
    
    
    
    this.postedOn = postedOn;
    return this;
  }

   /**
   * The date and time when the debit memo was posted, in &#x60;yyyy-mm-dd hh:mm:ss&#x60; format. 
   * @return postedOn
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The date and time when the debit memo was posted, in `yyyy-mm-dd hh:mm:ss` format. ")

  public OffsetDateTime getPostedOn() {
    return postedOn;
  }


  public void setPostedOn(OffsetDateTime postedOn) {
    
    
    
    this.postedOn = postedOn;
  }


  public GETDebitMemoTypewithSuccessAllOf reasonCode(String reasonCode) {
    
    
    
    
    this.reasonCode = reasonCode;
    return this;
  }

   /**
   * A code identifying the reason for the transaction. The value must be an existing reason code or empty. 
   * @return reasonCode
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "A code identifying the reason for the transaction. The value must be an existing reason code or empty. ")

  public String getReasonCode() {
    return reasonCode;
  }


  public void setReasonCode(String reasonCode) {
    
    
    
    this.reasonCode = reasonCode;
  }


  public GETDebitMemoTypewithSuccessAllOf referredCreditMemoId(String referredCreditMemoId) {
    
    
    
    
    this.referredCreditMemoId = referredCreditMemoId;
    return this;
  }

   /**
   * The ID of the credit memo from which the debit memo was created. 
   * @return referredCreditMemoId
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The ID of the credit memo from which the debit memo was created. ")

  public String getReferredCreditMemoId() {
    return referredCreditMemoId;
  }


  public void setReferredCreditMemoId(String referredCreditMemoId) {
    
    
    
    this.referredCreditMemoId = referredCreditMemoId;
  }


  public GETDebitMemoTypewithSuccessAllOf referredInvoiceId(String referredInvoiceId) {
    
    
    
    
    this.referredInvoiceId = referredInvoiceId;
    return this;
  }

   /**
   * The ID of a referred invoice. 
   * @return referredInvoiceId
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The ID of a referred invoice. ")

  public String getReferredInvoiceId() {
    return referredInvoiceId;
  }


  public void setReferredInvoiceId(String referredInvoiceId) {
    
    
    
    this.referredInvoiceId = referredInvoiceId;
  }


  public GETDebitMemoTypewithSuccessAllOf sequenceSetId(String sequenceSetId) {
    
    
    
    
    this.sequenceSetId = sequenceSetId;
    return this;
  }

   /**
   * The ID of the sequence set associated with the debit memo.  The value of this field is &#x60;null&#x60; if you have the [Flexible Billing Attributes](https://knowledgecenter.zuora.com/Billing/Subscriptions/Flexible_Billing_Attributes) feature disabled. 
   * @return sequenceSetId
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The ID of the sequence set associated with the debit memo.  The value of this field is `null` if you have the [Flexible Billing Attributes](https://knowledgecenter.zuora.com/Billing/Subscriptions/Flexible_Billing_Attributes) feature disabled. ")

  public String getSequenceSetId() {
    return sequenceSetId;
  }


  public void setSequenceSetId(String sequenceSetId) {
    
    
    
    this.sequenceSetId = sequenceSetId;
  }


  public GETDebitMemoTypewithSuccessAllOf sourceType(SourceTypeEnum sourceType) {
    
    
    
    
    this.sourceType = sourceType;
    return this;
  }

   /**
   * The type of the debit memo source. 
   * @return sourceType
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The type of the debit memo source. ")

  public SourceTypeEnum getSourceType() {
    return sourceType;
  }


  public void setSourceType(SourceTypeEnum sourceType) {
    
    
    
    this.sourceType = sourceType;
  }


  public GETDebitMemoTypewithSuccessAllOf status(StatusEnum status) {
    
    
    
    
    this.status = status;
    return this;
  }

   /**
   * The status of the debit memo.  
   * @return status
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The status of the debit memo.  ")

  public StatusEnum getStatus() {
    return status;
  }


  public void setStatus(StatusEnum status) {
    
    
    
    this.status = status;
  }


  public GETDebitMemoTypewithSuccessAllOf targetDate(LocalDate targetDate) {
    
    
    
    
    this.targetDate = targetDate;
    return this;
  }

   /**
   * The target date for the debit memo, in &#x60;yyyy-mm-dd&#x60; format. For example, 2017-07-20. 
   * @return targetDate
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The target date for the debit memo, in `yyyy-mm-dd` format. For example, 2017-07-20. ")

  public LocalDate getTargetDate() {
    return targetDate;
  }


  public void setTargetDate(LocalDate targetDate) {
    
    
    
    this.targetDate = targetDate;
  }


  public GETDebitMemoTypewithSuccessAllOf taxAmount(Double taxAmount) {
    
    
    
    
    this.taxAmount = taxAmount;
    return this;
  }

   /**
   * The amount of taxation. 
   * @return taxAmount
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The amount of taxation. ")

  public Double getTaxAmount() {
    return taxAmount;
  }


  public void setTaxAmount(Double taxAmount) {
    
    
    
    this.taxAmount = taxAmount;
  }


  public GETDebitMemoTypewithSuccessAllOf taxMessage(String taxMessage) {
    
    
    
    
    this.taxMessage = taxMessage;
    return this;
  }

   /**
   * The message about the status of tax calculation related to the debit memo. If tax calculation fails in one debit memo, this field displays the reason for the failure. 
   * @return taxMessage
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The message about the status of tax calculation related to the debit memo. If tax calculation fails in one debit memo, this field displays the reason for the failure. ")

  public String getTaxMessage() {
    return taxMessage;
  }


  public void setTaxMessage(String taxMessage) {
    
    
    
    this.taxMessage = taxMessage;
  }


  public GETDebitMemoTypewithSuccessAllOf taxStatus(TaxStatusEnum taxStatus) {
    
    
    
    
    this.taxStatus = taxStatus;
    return this;
  }

   /**
   * The status of tax calculation related to the debit memo.  **Note**: This field is only applicable to tax calculation by third-party tax engines. 
   * @return taxStatus
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The status of tax calculation related to the debit memo.  **Note**: This field is only applicable to tax calculation by third-party tax engines. ")

  public TaxStatusEnum getTaxStatus() {
    return taxStatus;
  }


  public void setTaxStatus(TaxStatusEnum taxStatus) {
    
    
    
    this.taxStatus = taxStatus;
  }


  public GETDebitMemoTypewithSuccessAllOf totalTaxExemptAmount(Double totalTaxExemptAmount) {
    
    
    
    
    this.totalTaxExemptAmount = totalTaxExemptAmount;
    return this;
  }

   /**
   * The calculated tax amount excluded due to the exemption. 
   * @return totalTaxExemptAmount
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The calculated tax amount excluded due to the exemption. ")

  public Double getTotalTaxExemptAmount() {
    return totalTaxExemptAmount;
  }


  public void setTotalTaxExemptAmount(Double totalTaxExemptAmount) {
    
    
    
    this.totalTaxExemptAmount = totalTaxExemptAmount;
  }


  public GETDebitMemoTypewithSuccessAllOf transferredToAccounting(TransferredToAccountingEnum transferredToAccounting) {
    
    
    
    
    this.transferredToAccounting = transferredToAccounting;
    return this;
  }

   /**
   * Whether the debit memo was transferred to an external accounting system. Use this field for integration with accounting systems, such as NetSuite.  
   * @return transferredToAccounting
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Whether the debit memo was transferred to an external accounting system. Use this field for integration with accounting systems, such as NetSuite.  ")

  public TransferredToAccountingEnum getTransferredToAccounting() {
    return transferredToAccounting;
  }


  public void setTransferredToAccounting(TransferredToAccountingEnum transferredToAccounting) {
    
    
    
    this.transferredToAccounting = transferredToAccounting;
  }


  public GETDebitMemoTypewithSuccessAllOf updatedById(String updatedById) {
    
    
    
    
    this.updatedById = updatedById;
    return this;
  }

   /**
   * The ID of the Zuora user who last updated the debit memo. 
   * @return updatedById
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The ID of the Zuora user who last updated the debit memo. ")

  public String getUpdatedById() {
    return updatedById;
  }


  public void setUpdatedById(String updatedById) {
    
    
    
    this.updatedById = updatedById;
  }


  public GETDebitMemoTypewithSuccessAllOf updatedDate(OffsetDateTime updatedDate) {
    
    
    
    
    this.updatedDate = updatedDate;
    return this;
  }

   /**
   * The date and time when the debit memo was last updated, in &#x60;yyyy-mm-dd hh:mm:ss&#x60; format. For example, 2017-03-02 15:31:10. 
   * @return updatedDate
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The date and time when the debit memo was last updated, in `yyyy-mm-dd hh:mm:ss` format. For example, 2017-03-02 15:31:10. ")

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
   * @return the GETDebitMemoTypewithSuccessAllOf instance itself
   */
  public GETDebitMemoTypewithSuccessAllOf putAdditionalProperty(String key, Object value) {
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
    GETDebitMemoTypewithSuccessAllOf geTDebitMemoTypewithSuccessAllOf = (GETDebitMemoTypewithSuccessAllOf) o;
    return Objects.equals(this.accountId, geTDebitMemoTypewithSuccessAllOf.accountId) &&
        Objects.equals(this.accountNumber, geTDebitMemoTypewithSuccessAllOf.accountNumber) &&
        Objects.equals(this.amount, geTDebitMemoTypewithSuccessAllOf.amount) &&
        Objects.equals(this.autoPay, geTDebitMemoTypewithSuccessAllOf.autoPay) &&
        Objects.equals(this.balance, geTDebitMemoTypewithSuccessAllOf.balance) &&
        Objects.equals(this.beAppliedAmount, geTDebitMemoTypewithSuccessAllOf.beAppliedAmount) &&
        Objects.equals(this.billToContactId, geTDebitMemoTypewithSuccessAllOf.billToContactId) &&
        Objects.equals(this.cancelledById, geTDebitMemoTypewithSuccessAllOf.cancelledById) &&
        Objects.equals(this.cancelledOn, geTDebitMemoTypewithSuccessAllOf.cancelledOn) &&
        Objects.equals(this.comment, geTDebitMemoTypewithSuccessAllOf.comment) &&
        Objects.equals(this.createdById, geTDebitMemoTypewithSuccessAllOf.createdById) &&
        Objects.equals(this.createdDate, geTDebitMemoTypewithSuccessAllOf.createdDate) &&
        Objects.equals(this.currency, geTDebitMemoTypewithSuccessAllOf.currency) &&
        Objects.equals(this.debitMemoDate, geTDebitMemoTypewithSuccessAllOf.debitMemoDate) &&
        Objects.equals(this.dueDate, geTDebitMemoTypewithSuccessAllOf.dueDate) &&
        Objects.equals(this.einvoiceErrorCode, geTDebitMemoTypewithSuccessAllOf.einvoiceErrorCode) &&
        Objects.equals(this.einvoiceErrorMessage, geTDebitMemoTypewithSuccessAllOf.einvoiceErrorMessage) &&
        Objects.equals(this.einvoiceFileId, geTDebitMemoTypewithSuccessAllOf.einvoiceFileId) &&
        Objects.equals(this.einvoiceStatus, geTDebitMemoTypewithSuccessAllOf.einvoiceStatus) &&
        Objects.equals(this.id, geTDebitMemoTypewithSuccessAllOf.id) &&
        Objects.equals(this.invoiceGroupNumber, geTDebitMemoTypewithSuccessAllOf.invoiceGroupNumber) &&
        Objects.equals(this.latestPDFFileId, geTDebitMemoTypewithSuccessAllOf.latestPDFFileId) &&
        Objects.equals(this.number, geTDebitMemoTypewithSuccessAllOf.number) &&
        Objects.equals(this.paymentTerm, geTDebitMemoTypewithSuccessAllOf.paymentTerm) &&
        Objects.equals(this.postedById, geTDebitMemoTypewithSuccessAllOf.postedById) &&
        Objects.equals(this.postedOn, geTDebitMemoTypewithSuccessAllOf.postedOn) &&
        Objects.equals(this.reasonCode, geTDebitMemoTypewithSuccessAllOf.reasonCode) &&
        Objects.equals(this.referredCreditMemoId, geTDebitMemoTypewithSuccessAllOf.referredCreditMemoId) &&
        Objects.equals(this.referredInvoiceId, geTDebitMemoTypewithSuccessAllOf.referredInvoiceId) &&
        Objects.equals(this.sequenceSetId, geTDebitMemoTypewithSuccessAllOf.sequenceSetId) &&
        Objects.equals(this.sourceType, geTDebitMemoTypewithSuccessAllOf.sourceType) &&
        Objects.equals(this.status, geTDebitMemoTypewithSuccessAllOf.status) &&
        Objects.equals(this.targetDate, geTDebitMemoTypewithSuccessAllOf.targetDate) &&
        Objects.equals(this.taxAmount, geTDebitMemoTypewithSuccessAllOf.taxAmount) &&
        Objects.equals(this.taxMessage, geTDebitMemoTypewithSuccessAllOf.taxMessage) &&
        Objects.equals(this.taxStatus, geTDebitMemoTypewithSuccessAllOf.taxStatus) &&
        Objects.equals(this.totalTaxExemptAmount, geTDebitMemoTypewithSuccessAllOf.totalTaxExemptAmount) &&
        Objects.equals(this.transferredToAccounting, geTDebitMemoTypewithSuccessAllOf.transferredToAccounting) &&
        Objects.equals(this.updatedById, geTDebitMemoTypewithSuccessAllOf.updatedById) &&
        Objects.equals(this.updatedDate, geTDebitMemoTypewithSuccessAllOf.updatedDate)&&
        Objects.equals(this.additionalProperties, geTDebitMemoTypewithSuccessAllOf.additionalProperties);
  }

  private static <T> boolean equalsNullable(JsonNullable<T> a, JsonNullable<T> b) {
    return a == b || (a != null && b != null && a.isPresent() && b.isPresent() && Objects.deepEquals(a.get(), b.get()));
  }

  @Override
  public int hashCode() {
    return Objects.hash(accountId, accountNumber, amount, autoPay, balance, beAppliedAmount, billToContactId, cancelledById, cancelledOn, comment, createdById, createdDate, currency, debitMemoDate, dueDate, einvoiceErrorCode, einvoiceErrorMessage, einvoiceFileId, einvoiceStatus, id, invoiceGroupNumber, latestPDFFileId, number, paymentTerm, postedById, postedOn, reasonCode, referredCreditMemoId, referredInvoiceId, sequenceSetId, sourceType, status, targetDate, taxAmount, taxMessage, taxStatus, totalTaxExemptAmount, transferredToAccounting, updatedById, updatedDate, additionalProperties);
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
    sb.append("class GETDebitMemoTypewithSuccessAllOf {\n");
    sb.append("    accountId: ").append(toIndentedString(accountId)).append("\n");
    sb.append("    accountNumber: ").append(toIndentedString(accountNumber)).append("\n");
    sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
    sb.append("    autoPay: ").append(toIndentedString(autoPay)).append("\n");
    sb.append("    balance: ").append(toIndentedString(balance)).append("\n");
    sb.append("    beAppliedAmount: ").append(toIndentedString(beAppliedAmount)).append("\n");
    sb.append("    billToContactId: ").append(toIndentedString(billToContactId)).append("\n");
    sb.append("    cancelledById: ").append(toIndentedString(cancelledById)).append("\n");
    sb.append("    cancelledOn: ").append(toIndentedString(cancelledOn)).append("\n");
    sb.append("    comment: ").append(toIndentedString(comment)).append("\n");
    sb.append("    createdById: ").append(toIndentedString(createdById)).append("\n");
    sb.append("    createdDate: ").append(toIndentedString(createdDate)).append("\n");
    sb.append("    currency: ").append(toIndentedString(currency)).append("\n");
    sb.append("    debitMemoDate: ").append(toIndentedString(debitMemoDate)).append("\n");
    sb.append("    dueDate: ").append(toIndentedString(dueDate)).append("\n");
    sb.append("    einvoiceErrorCode: ").append(toIndentedString(einvoiceErrorCode)).append("\n");
    sb.append("    einvoiceErrorMessage: ").append(toIndentedString(einvoiceErrorMessage)).append("\n");
    sb.append("    einvoiceFileId: ").append(toIndentedString(einvoiceFileId)).append("\n");
    sb.append("    einvoiceStatus: ").append(toIndentedString(einvoiceStatus)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    invoiceGroupNumber: ").append(toIndentedString(invoiceGroupNumber)).append("\n");
    sb.append("    latestPDFFileId: ").append(toIndentedString(latestPDFFileId)).append("\n");
    sb.append("    number: ").append(toIndentedString(number)).append("\n");
    sb.append("    paymentTerm: ").append(toIndentedString(paymentTerm)).append("\n");
    sb.append("    postedById: ").append(toIndentedString(postedById)).append("\n");
    sb.append("    postedOn: ").append(toIndentedString(postedOn)).append("\n");
    sb.append("    reasonCode: ").append(toIndentedString(reasonCode)).append("\n");
    sb.append("    referredCreditMemoId: ").append(toIndentedString(referredCreditMemoId)).append("\n");
    sb.append("    referredInvoiceId: ").append(toIndentedString(referredInvoiceId)).append("\n");
    sb.append("    sequenceSetId: ").append(toIndentedString(sequenceSetId)).append("\n");
    sb.append("    sourceType: ").append(toIndentedString(sourceType)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    targetDate: ").append(toIndentedString(targetDate)).append("\n");
    sb.append("    taxAmount: ").append(toIndentedString(taxAmount)).append("\n");
    sb.append("    taxMessage: ").append(toIndentedString(taxMessage)).append("\n");
    sb.append("    taxStatus: ").append(toIndentedString(taxStatus)).append("\n");
    sb.append("    totalTaxExemptAmount: ").append(toIndentedString(totalTaxExemptAmount)).append("\n");
    sb.append("    transferredToAccounting: ").append(toIndentedString(transferredToAccounting)).append("\n");
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
    openapiFields.add("accountId");
    openapiFields.add("accountNumber");
    openapiFields.add("amount");
    openapiFields.add("autoPay");
    openapiFields.add("balance");
    openapiFields.add("beAppliedAmount");
    openapiFields.add("billToContactId");
    openapiFields.add("cancelledById");
    openapiFields.add("cancelledOn");
    openapiFields.add("comment");
    openapiFields.add("createdById");
    openapiFields.add("createdDate");
    openapiFields.add("currency");
    openapiFields.add("debitMemoDate");
    openapiFields.add("dueDate");
    openapiFields.add("einvoiceErrorCode");
    openapiFields.add("einvoiceErrorMessage");
    openapiFields.add("einvoiceFileId");
    openapiFields.add("einvoiceStatus");
    openapiFields.add("id");
    openapiFields.add("invoiceGroupNumber");
    openapiFields.add("latestPDFFileId");
    openapiFields.add("number");
    openapiFields.add("paymentTerm");
    openapiFields.add("postedById");
    openapiFields.add("postedOn");
    openapiFields.add("reasonCode");
    openapiFields.add("referredCreditMemoId");
    openapiFields.add("referredInvoiceId");
    openapiFields.add("sequenceSetId");
    openapiFields.add("sourceType");
    openapiFields.add("status");
    openapiFields.add("targetDate");
    openapiFields.add("taxAmount");
    openapiFields.add("taxMessage");
    openapiFields.add("taxStatus");
    openapiFields.add("totalTaxExemptAmount");
    openapiFields.add("transferredToAccounting");
    openapiFields.add("updatedById");
    openapiFields.add("updatedDate");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
  }

 /**
  * Validates the JSON Object and throws an exception if issues found
  *
  * @param jsonObj JSON Object
  * @throws IOException if the JSON Object is invalid with respect to GETDebitMemoTypewithSuccessAllOf
  */
  public static void validateJsonObject(JsonObject jsonObj) throws IOException {
      if (jsonObj == null) {
        if (!GETDebitMemoTypewithSuccessAllOf.openapiRequiredFields.isEmpty()) { // has required fields but JSON object is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in GETDebitMemoTypewithSuccessAllOf is not found in the empty JSON string", GETDebitMemoTypewithSuccessAllOf.openapiRequiredFields.toString()));
        }
      }
      if ((jsonObj.get("accountId") != null && !jsonObj.get("accountId").isJsonNull()) && !jsonObj.get("accountId").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `accountId` to be a primitive type in the JSON string but got `%s`", jsonObj.get("accountId").toString()));
      }
      if ((jsonObj.get("accountNumber") != null && !jsonObj.get("accountNumber").isJsonNull()) && !jsonObj.get("accountNumber").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `accountNumber` to be a primitive type in the JSON string but got `%s`", jsonObj.get("accountNumber").toString()));
      }
      if ((jsonObj.get("billToContactId") != null && !jsonObj.get("billToContactId").isJsonNull()) && !jsonObj.get("billToContactId").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `billToContactId` to be a primitive type in the JSON string but got `%s`", jsonObj.get("billToContactId").toString()));
      }
      if ((jsonObj.get("cancelledById") != null && !jsonObj.get("cancelledById").isJsonNull()) && !jsonObj.get("cancelledById").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `cancelledById` to be a primitive type in the JSON string but got `%s`", jsonObj.get("cancelledById").toString()));
      }
      if ((jsonObj.get("comment") != null && !jsonObj.get("comment").isJsonNull()) && !jsonObj.get("comment").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `comment` to be a primitive type in the JSON string but got `%s`", jsonObj.get("comment").toString()));
      }
      if ((jsonObj.get("createdById") != null && !jsonObj.get("createdById").isJsonNull()) && !jsonObj.get("createdById").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `createdById` to be a primitive type in the JSON string but got `%s`", jsonObj.get("createdById").toString()));
      }
      if (!jsonObj.get("currency").isJsonNull() && (jsonObj.get("currency") != null && !jsonObj.get("currency").isJsonNull()) && !jsonObj.get("currency").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `currency` to be a primitive type in the JSON string but got `%s`", jsonObj.get("currency").toString()));
      }
      if ((jsonObj.get("einvoiceErrorCode") != null && !jsonObj.get("einvoiceErrorCode").isJsonNull()) && !jsonObj.get("einvoiceErrorCode").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `einvoiceErrorCode` to be a primitive type in the JSON string but got `%s`", jsonObj.get("einvoiceErrorCode").toString()));
      }
      if ((jsonObj.get("einvoiceErrorMessage") != null && !jsonObj.get("einvoiceErrorMessage").isJsonNull()) && !jsonObj.get("einvoiceErrorMessage").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `einvoiceErrorMessage` to be a primitive type in the JSON string but got `%s`", jsonObj.get("einvoiceErrorMessage").toString()));
      }
      if ((jsonObj.get("einvoiceFileId") != null && !jsonObj.get("einvoiceFileId").isJsonNull()) && !jsonObj.get("einvoiceFileId").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `einvoiceFileId` to be a primitive type in the JSON string but got `%s`", jsonObj.get("einvoiceFileId").toString()));
      }
      if ((jsonObj.get("einvoiceStatus") != null && !jsonObj.get("einvoiceStatus").isJsonNull()) && !jsonObj.get("einvoiceStatus").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `einvoiceStatus` to be a primitive type in the JSON string but got `%s`", jsonObj.get("einvoiceStatus").toString()));
      }
      if ((jsonObj.get("id") != null && !jsonObj.get("id").isJsonNull()) && !jsonObj.get("id").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `id` to be a primitive type in the JSON string but got `%s`", jsonObj.get("id").toString()));
      }
      if (!jsonObj.get("invoiceGroupNumber").isJsonNull() && (jsonObj.get("invoiceGroupNumber") != null && !jsonObj.get("invoiceGroupNumber").isJsonNull()) && !jsonObj.get("invoiceGroupNumber").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `invoiceGroupNumber` to be a primitive type in the JSON string but got `%s`", jsonObj.get("invoiceGroupNumber").toString()));
      }
      if ((jsonObj.get("latestPDFFileId") != null && !jsonObj.get("latestPDFFileId").isJsonNull()) && !jsonObj.get("latestPDFFileId").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `latestPDFFileId` to be a primitive type in the JSON string but got `%s`", jsonObj.get("latestPDFFileId").toString()));
      }
      if ((jsonObj.get("number") != null && !jsonObj.get("number").isJsonNull()) && !jsonObj.get("number").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `number` to be a primitive type in the JSON string but got `%s`", jsonObj.get("number").toString()));
      }
      if ((jsonObj.get("paymentTerm") != null && !jsonObj.get("paymentTerm").isJsonNull()) && !jsonObj.get("paymentTerm").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `paymentTerm` to be a primitive type in the JSON string but got `%s`", jsonObj.get("paymentTerm").toString()));
      }
      if ((jsonObj.get("postedById") != null && !jsonObj.get("postedById").isJsonNull()) && !jsonObj.get("postedById").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `postedById` to be a primitive type in the JSON string but got `%s`", jsonObj.get("postedById").toString()));
      }
      if ((jsonObj.get("reasonCode") != null && !jsonObj.get("reasonCode").isJsonNull()) && !jsonObj.get("reasonCode").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `reasonCode` to be a primitive type in the JSON string but got `%s`", jsonObj.get("reasonCode").toString()));
      }
      if ((jsonObj.get("referredCreditMemoId") != null && !jsonObj.get("referredCreditMemoId").isJsonNull()) && !jsonObj.get("referredCreditMemoId").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `referredCreditMemoId` to be a primitive type in the JSON string but got `%s`", jsonObj.get("referredCreditMemoId").toString()));
      }
      if ((jsonObj.get("referredInvoiceId") != null && !jsonObj.get("referredInvoiceId").isJsonNull()) && !jsonObj.get("referredInvoiceId").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `referredInvoiceId` to be a primitive type in the JSON string but got `%s`", jsonObj.get("referredInvoiceId").toString()));
      }
      if ((jsonObj.get("sequenceSetId") != null && !jsonObj.get("sequenceSetId").isJsonNull()) && !jsonObj.get("sequenceSetId").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `sequenceSetId` to be a primitive type in the JSON string but got `%s`", jsonObj.get("sequenceSetId").toString()));
      }
      if ((jsonObj.get("sourceType") != null && !jsonObj.get("sourceType").isJsonNull()) && !jsonObj.get("sourceType").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `sourceType` to be a primitive type in the JSON string but got `%s`", jsonObj.get("sourceType").toString()));
      }
      if ((jsonObj.get("status") != null && !jsonObj.get("status").isJsonNull()) && !jsonObj.get("status").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `status` to be a primitive type in the JSON string but got `%s`", jsonObj.get("status").toString()));
      }
      if ((jsonObj.get("taxMessage") != null && !jsonObj.get("taxMessage").isJsonNull()) && !jsonObj.get("taxMessage").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `taxMessage` to be a primitive type in the JSON string but got `%s`", jsonObj.get("taxMessage").toString()));
      }
      if ((jsonObj.get("taxStatus") != null && !jsonObj.get("taxStatus").isJsonNull()) && !jsonObj.get("taxStatus").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `taxStatus` to be a primitive type in the JSON string but got `%s`", jsonObj.get("taxStatus").toString()));
      }
      if ((jsonObj.get("transferredToAccounting") != null && !jsonObj.get("transferredToAccounting").isJsonNull()) && !jsonObj.get("transferredToAccounting").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `transferredToAccounting` to be a primitive type in the JSON string but got `%s`", jsonObj.get("transferredToAccounting").toString()));
      }
      if ((jsonObj.get("updatedById") != null && !jsonObj.get("updatedById").isJsonNull()) && !jsonObj.get("updatedById").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `updatedById` to be a primitive type in the JSON string but got `%s`", jsonObj.get("updatedById").toString()));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!GETDebitMemoTypewithSuccessAllOf.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'GETDebitMemoTypewithSuccessAllOf' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<GETDebitMemoTypewithSuccessAllOf> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(GETDebitMemoTypewithSuccessAllOf.class));

       return (TypeAdapter<T>) new TypeAdapter<GETDebitMemoTypewithSuccessAllOf>() {
           @Override
           public void write(JsonWriter out, GETDebitMemoTypewithSuccessAllOf value) throws IOException {
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
           public GETDebitMemoTypewithSuccessAllOf read(JsonReader in) throws IOException {
             JsonObject jsonObj = elementAdapter.read(in).getAsJsonObject();
             validateJsonObject(jsonObj);
             // store additional fields in the deserialized instance
             GETDebitMemoTypewithSuccessAllOf instance = thisAdapter.fromJsonTree(jsonObj);
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
  * Create an instance of GETDebitMemoTypewithSuccessAllOf given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of GETDebitMemoTypewithSuccessAllOf
  * @throws IOException if the JSON string is invalid with respect to GETDebitMemoTypewithSuccessAllOf
  */
  public static GETDebitMemoTypewithSuccessAllOf fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, GETDebitMemoTypewithSuccessAllOf.class);
  }

 /**
  * Convert an instance of GETDebitMemoTypewithSuccessAllOf to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

