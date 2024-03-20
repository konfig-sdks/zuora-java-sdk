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
import com.konfigthis.client.model.GETPMAccountHolderInfo;
import com.konfigthis.client.model.POSTPMMandateInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
import java.time.OffsetDateTime;

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
 * GETPaymentMethodResponse
 */@javax.annotation.Generated(value = "Generated by https://konfigthis.com")
public class GETPaymentMethodResponse {
  public static final String SERIALIZED_NAME_ACCOUNT_HOLDER_INFO = "accountHolderInfo";
  @SerializedName(SERIALIZED_NAME_ACCOUNT_HOLDER_INFO)
  private GETPMAccountHolderInfo accountHolderInfo;

  public static final String SERIALIZED_NAME_BANK_IDENTIFICATION_NUMBER = "bankIdentificationNumber";
  @SerializedName(SERIALIZED_NAME_BANK_IDENTIFICATION_NUMBER)
  private String bankIdentificationNumber;

  public static final String SERIALIZED_NAME_CREATED_BY = "createdBy";
  @SerializedName(SERIALIZED_NAME_CREATED_BY)
  private String createdBy;

  public static final String SERIALIZED_NAME_CREATED_ON = "createdOn";
  @SerializedName(SERIALIZED_NAME_CREATED_ON)
  private OffsetDateTime createdOn;

  public static final String SERIALIZED_NAME_CREDIT_CARD_MASK_NUMBER = "creditCardMaskNumber";
  @SerializedName(SERIALIZED_NAME_CREDIT_CARD_MASK_NUMBER)
  private String creditCardMaskNumber;

  public static final String SERIALIZED_NAME_CREDIT_CARD_TYPE = "creditCardType";
  @SerializedName(SERIALIZED_NAME_CREDIT_CARD_TYPE)
  private String creditCardType;

  public static final String SERIALIZED_NAME_DEVICE_SESSION_ID = "deviceSessionId";
  @SerializedName(SERIALIZED_NAME_DEVICE_SESSION_ID)
  private String deviceSessionId;

  /**
   * Indicates whether the mandate is an existing mandate. 
   */
  @JsonAdapter(ExistingMandateEnum.Adapter.class)
 public enum ExistingMandateEnum {
    TRUE("true"),
    
    FALSE("false");

    private String value;

    ExistingMandateEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static ExistingMandateEnum fromValue(String value) {
      for (ExistingMandateEnum b : ExistingMandateEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<ExistingMandateEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final ExistingMandateEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public ExistingMandateEnum read(final JsonReader jsonReader) throws IOException {
        String value =  jsonReader.nextString();
        return ExistingMandateEnum.fromValue(value);
      }
    }
  }

  public static final String SERIALIZED_NAME_EXISTING_MANDATE = "existingMandate";
  @SerializedName(SERIALIZED_NAME_EXISTING_MANDATE)
  private ExistingMandateEnum existingMandate;

  public static final String SERIALIZED_NAME_ID = "id";
  @SerializedName(SERIALIZED_NAME_ID)
  private String id;

  public static final String SERIALIZED_NAME_IP_ADDRESS = "ipAddress";
  @SerializedName(SERIALIZED_NAME_IP_ADDRESS)
  private String ipAddress;

  public static final String SERIALIZED_NAME_IS_DEFAULT = "isDefault";
  @SerializedName(SERIALIZED_NAME_IS_DEFAULT)
  private Boolean isDefault;

  public static final String SERIALIZED_NAME_LAST_FAILED_SALE_TRANSACTION_DATE = "lastFailedSaleTransactionDate";
  @SerializedName(SERIALIZED_NAME_LAST_FAILED_SALE_TRANSACTION_DATE)
  private OffsetDateTime lastFailedSaleTransactionDate;

  public static final String SERIALIZED_NAME_LAST_TRANSACTION = "lastTransaction";
  @SerializedName(SERIALIZED_NAME_LAST_TRANSACTION)
  private String lastTransaction;

  public static final String SERIALIZED_NAME_LAST_TRANSACTION_TIME = "lastTransactionTime";
  @SerializedName(SERIALIZED_NAME_LAST_TRANSACTION_TIME)
  private OffsetDateTime lastTransactionTime;

  public static final String SERIALIZED_NAME_MANDATE_INFO = "mandateInfo";
  @SerializedName(SERIALIZED_NAME_MANDATE_INFO)
  private POSTPMMandateInfo mandateInfo;

  public static final String SERIALIZED_NAME_MAX_CONSECUTIVE_PAYMENT_FAILURES = "maxConsecutivePaymentFailures";
  @SerializedName(SERIALIZED_NAME_MAX_CONSECUTIVE_PAYMENT_FAILURES)
  private Integer maxConsecutivePaymentFailures;

  public static final String SERIALIZED_NAME_NUM_CONSECUTIVE_FAILURES = "numConsecutiveFailures";
  @SerializedName(SERIALIZED_NAME_NUM_CONSECUTIVE_FAILURES)
  private Integer numConsecutiveFailures;

  public static final String SERIALIZED_NAME_PAYMENT_RETRY_WINDOW = "paymentRetryWindow";
  @SerializedName(SERIALIZED_NAME_PAYMENT_RETRY_WINDOW)
  private Integer paymentRetryWindow;

  public static final String SERIALIZED_NAME_SECOND_TOKEN_ID = "secondTokenId";
  @SerializedName(SERIALIZED_NAME_SECOND_TOKEN_ID)
  private String secondTokenId;

  /**
   * The status of the payment method. 
   */
  @JsonAdapter(StatusEnum.Adapter.class)
 public enum StatusEnum {
    ACTIVE("Active"),
    
    CLOSED("Closed"),
    
    SCRUBBED("Scrubbed");

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

  public static final String SERIALIZED_NAME_TOKEN_ID = "tokenId";
  @SerializedName(SERIALIZED_NAME_TOKEN_ID)
  private String tokenId;

  public static final String SERIALIZED_NAME_TOTAL_NUMBER_OF_ERROR_PAYMENTS = "totalNumberOfErrorPayments";
  @SerializedName(SERIALIZED_NAME_TOTAL_NUMBER_OF_ERROR_PAYMENTS)
  private Integer totalNumberOfErrorPayments;

  public static final String SERIALIZED_NAME_TOTAL_NUMBER_OF_PROCESSED_PAYMENTS = "totalNumberOfProcessedPayments";
  @SerializedName(SERIALIZED_NAME_TOTAL_NUMBER_OF_PROCESSED_PAYMENTS)
  private Integer totalNumberOfProcessedPayments;

  public static final String SERIALIZED_NAME_TYPE = "type";
  @SerializedName(SERIALIZED_NAME_TYPE)
  private String type;

  public static final String SERIALIZED_NAME_UPDATED_BY = "updatedBy";
  @SerializedName(SERIALIZED_NAME_UPDATED_BY)
  private String updatedBy;

  public static final String SERIALIZED_NAME_UPDATED_ON = "updatedOn";
  @SerializedName(SERIALIZED_NAME_UPDATED_ON)
  private OffsetDateTime updatedOn;

  public static final String SERIALIZED_NAME_USE_DEFAULT_RETRY_RULE = "useDefaultRetryRule";
  @SerializedName(SERIALIZED_NAME_USE_DEFAULT_RETRY_RULE)
  private Boolean useDefaultRetryRule;

  public static final String SERIALIZED_NAME_I_B_A_N = "IBAN";
  @SerializedName(SERIALIZED_NAME_I_B_A_N)
  private String IBAN;

  public static final String SERIALIZED_NAME_ACCOUNT_NUMBER = "accountNumber";
  @SerializedName(SERIALIZED_NAME_ACCOUNT_NUMBER)
  private String accountNumber;

  public static final String SERIALIZED_NAME_BANK_CODE = "bankCode";
  @SerializedName(SERIALIZED_NAME_BANK_CODE)
  private String bankCode;

  public static final String SERIALIZED_NAME_BANK_TRANSFER_TYPE = "bankTransferType";
  @SerializedName(SERIALIZED_NAME_BANK_TRANSFER_TYPE)
  private String bankTransferType;

  public static final String SERIALIZED_NAME_BRANCH_CODE = "branchCode";
  @SerializedName(SERIALIZED_NAME_BRANCH_CODE)
  private String branchCode;

  public static final String SERIALIZED_NAME_BUSINESS_IDENTIFICATION_CODE = "businessIdentificationCode";
  @SerializedName(SERIALIZED_NAME_BUSINESS_IDENTIFICATION_CODE)
  private String businessIdentificationCode;

  public static final String SERIALIZED_NAME_IDENTITY_NUMBER = "identityNumber";
  @SerializedName(SERIALIZED_NAME_IDENTITY_NUMBER)
  private String identityNumber;

  public static final String SERIALIZED_NAME_BANK_A_B_A_CODE = "bankABACode";
  @SerializedName(SERIALIZED_NAME_BANK_A_B_A_CODE)
  private String bankABACode;

  public static final String SERIALIZED_NAME_BANK_ACCOUNT_NAME = "bankAccountName";
  @SerializedName(SERIALIZED_NAME_BANK_ACCOUNT_NAME)
  private String bankAccountName;

  public static final String SERIALIZED_NAME_BANK_ACCOUNT_NUMBER = "bankAccountNumber";
  @SerializedName(SERIALIZED_NAME_BANK_ACCOUNT_NUMBER)
  private String bankAccountNumber;

  /**
   * The type of bank account associated with the ACH payment. This field is only required if the &#x60;type&#x60; field is set to &#x60;ACH&#x60;.  When creating an ACH payment method on Adyen, this field is required by Zuora but it is not required by Adyen. To create the ACH payment method successfully, specify a real value for this field if you can. If it is not possible to get the real value for it, specify any of the allowed values as a dummy value, &#x60;Checking&#x60; preferably. 
   */
  @JsonAdapter(BankAccountTypeEnum.Adapter.class)
 public enum BankAccountTypeEnum {
    BUSINESSCHECKING("BusinessChecking"),
    
    CHECKING("Checking"),
    
    SAVING("Saving");

    private String value;

    BankAccountTypeEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static BankAccountTypeEnum fromValue(String value) {
      for (BankAccountTypeEnum b : BankAccountTypeEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<BankAccountTypeEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final BankAccountTypeEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public BankAccountTypeEnum read(final JsonReader jsonReader) throws IOException {
        String value =  jsonReader.nextString();
        return BankAccountTypeEnum.fromValue(value);
      }
    }
  }

  public static final String SERIALIZED_NAME_BANK_ACCOUNT_TYPE = "bankAccountType";
  @SerializedName(SERIALIZED_NAME_BANK_ACCOUNT_TYPE)
  private BankAccountTypeEnum bankAccountType;

  public static final String SERIALIZED_NAME_BANK_NAME = "bankName";
  @SerializedName(SERIALIZED_NAME_BANK_NAME)
  private String bankName;

  public static final String SERIALIZED_NAME_CARD_NUMBER = "cardNumber";
  @SerializedName(SERIALIZED_NAME_CARD_NUMBER)
  private String cardNumber;

  public static final String SERIALIZED_NAME_EXPIRATION_MONTH = "expirationMonth";
  @SerializedName(SERIALIZED_NAME_EXPIRATION_MONTH)
  private Integer expirationMonth;

  public static final String SERIALIZED_NAME_EXPIRATION_YEAR = "expirationYear";
  @SerializedName(SERIALIZED_NAME_EXPIRATION_YEAR)
  private Integer expirationYear;

  public static final String SERIALIZED_NAME_SECURITY_CODE = "securityCode";
  @SerializedName(SERIALIZED_NAME_SECURITY_CODE)
  private String securityCode;

  public static final String SERIALIZED_NAME_B_A_I_D = "BAID";
  @SerializedName(SERIALIZED_NAME_B_A_I_D)
  private String BAID;

  public static final String SERIALIZED_NAME_EMAIL = "email";
  @SerializedName(SERIALIZED_NAME_EMAIL)
  private String email;

  public static final String SERIALIZED_NAME_PREAPPROVAL_KEY = "preapprovalKey";
  @SerializedName(SERIALIZED_NAME_PREAPPROVAL_KEY)
  private String preapprovalKey;

  public static final String SERIALIZED_NAME_GOOGLE_B_I_N = "googleBIN";
  @SerializedName(SERIALIZED_NAME_GOOGLE_B_I_N)
  private String googleBIN;

  public static final String SERIALIZED_NAME_GOOGLE_CARD_NUMBER = "googleCardNumber";
  @SerializedName(SERIALIZED_NAME_GOOGLE_CARD_NUMBER)
  private String googleCardNumber;

  public static final String SERIALIZED_NAME_GOOGLE_CARD_TYPE = "googleCardType";
  @SerializedName(SERIALIZED_NAME_GOOGLE_CARD_TYPE)
  private String googleCardType;

  public static final String SERIALIZED_NAME_GOOGLE_EXPIRY_DATE = "googleExpiryDate";
  @SerializedName(SERIALIZED_NAME_GOOGLE_EXPIRY_DATE)
  private String googleExpiryDate;

  public static final String SERIALIZED_NAME_GOOGLE_GATEWAY_TOKEN = "googleGatewayToken";
  @SerializedName(SERIALIZED_NAME_GOOGLE_GATEWAY_TOKEN)
  private String googleGatewayToken;

  public static final String SERIALIZED_NAME_APPLE_B_I_N = "appleBIN";
  @SerializedName(SERIALIZED_NAME_APPLE_B_I_N)
  private String appleBIN;

  public static final String SERIALIZED_NAME_APPLE_CARD_NUMBER = "appleCardNumber";
  @SerializedName(SERIALIZED_NAME_APPLE_CARD_NUMBER)
  private String appleCardNumber;

  public static final String SERIALIZED_NAME_APPLE_CARD_TYPE = "appleCardType";
  @SerializedName(SERIALIZED_NAME_APPLE_CARD_TYPE)
  private String appleCardType;

  public static final String SERIALIZED_NAME_APPLE_EXPIRY_DATE = "appleExpiryDate";
  @SerializedName(SERIALIZED_NAME_APPLE_EXPIRY_DATE)
  private String appleExpiryDate;

  public static final String SERIALIZED_NAME_APPLE_GATEWAY_TOKEN = "appleGatewayToken";
  @SerializedName(SERIALIZED_NAME_APPLE_GATEWAY_TOKEN)
  private String appleGatewayToken;

  public GETPaymentMethodResponse() {
  }

  public GETPaymentMethodResponse accountHolderInfo(GETPMAccountHolderInfo accountHolderInfo) {
    
    
    
    
    this.accountHolderInfo = accountHolderInfo;
    return this;
  }

   /**
   * Get accountHolderInfo
   * @return accountHolderInfo
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public GETPMAccountHolderInfo getAccountHolderInfo() {
    return accountHolderInfo;
  }


  public void setAccountHolderInfo(GETPMAccountHolderInfo accountHolderInfo) {
    
    
    
    this.accountHolderInfo = accountHolderInfo;
  }


  public GETPaymentMethodResponse bankIdentificationNumber(String bankIdentificationNumber) {
    
    
    
    
    this.bankIdentificationNumber = bankIdentificationNumber;
    return this;
  }

   /**
   * The first six or eight digits of the payment method&#39;s number, such as the credit card number or account number. Banks use this number to identify a payment method. 
   * @return bankIdentificationNumber
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The first six or eight digits of the payment method's number, such as the credit card number or account number. Banks use this number to identify a payment method. ")

  public String getBankIdentificationNumber() {
    return bankIdentificationNumber;
  }


  public void setBankIdentificationNumber(String bankIdentificationNumber) {
    
    
    
    this.bankIdentificationNumber = bankIdentificationNumber;
  }


  public GETPaymentMethodResponse createdBy(String createdBy) {
    
    
    
    
    this.createdBy = createdBy;
    return this;
  }

   /**
   * ID of the user who created this payment method.
   * @return createdBy
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "ID of the user who created this payment method.")

  public String getCreatedBy() {
    return createdBy;
  }


  public void setCreatedBy(String createdBy) {
    
    
    
    this.createdBy = createdBy;
  }


  public GETPaymentMethodResponse createdOn(OffsetDateTime createdOn) {
    
    
    
    
    this.createdOn = createdOn;
    return this;
  }

   /**
   * The date and time when the payment method was created, in &#x60;yyyy-mm-dd hh:mm:ss&#x60; format. 
   * @return createdOn
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The date and time when the payment method was created, in `yyyy-mm-dd hh:mm:ss` format. ")

  public OffsetDateTime getCreatedOn() {
    return createdOn;
  }


  public void setCreatedOn(OffsetDateTime createdOn) {
    
    
    
    this.createdOn = createdOn;
  }


  public GETPaymentMethodResponse creditCardMaskNumber(String creditCardMaskNumber) {
    
    
    
    
    this.creditCardMaskNumber = creditCardMaskNumber;
    return this;
  }

   /**
   * The masked credit card number, such as: &#x60;&#x60;&#x60; *********1112 &#x60;&#x60;&#x60; 
   * @return creditCardMaskNumber
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The masked credit card number, such as: ``` *********1112 ``` ")

  public String getCreditCardMaskNumber() {
    return creditCardMaskNumber;
  }


  public void setCreditCardMaskNumber(String creditCardMaskNumber) {
    
    
    
    this.creditCardMaskNumber = creditCardMaskNumber;
  }


  public GETPaymentMethodResponse creditCardType(String creditCardType) {
    
    
    
    
    this.creditCardType = creditCardType;
    return this;
  }

   /**
   * The type of the credit card or debit card.  Possible values include &#x60;Visa&#x60;, &#x60;MasterCard&#x60;, &#x60;AmericanExpress&#x60;, &#x60;Discover&#x60;, &#x60;JCB&#x60;, and &#x60;Diners&#x60;. For more information about credit card types supported by different payment gateways, see [Supported Payment Gateways](https://knowledgecenter.zuora.com/CB_Billing/M_Payment_Gateways/Supported_Payment_Gateways).  **Note:** This field is only returned for the Credit Card and Debit Card payment types. 
   * @return creditCardType
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The type of the credit card or debit card.  Possible values include `Visa`, `MasterCard`, `AmericanExpress`, `Discover`, `JCB`, and `Diners`. For more information about credit card types supported by different payment gateways, see [Supported Payment Gateways](https://knowledgecenter.zuora.com/CB_Billing/M_Payment_Gateways/Supported_Payment_Gateways).  **Note:** This field is only returned for the Credit Card and Debit Card payment types. ")

  public String getCreditCardType() {
    return creditCardType;
  }


  public void setCreditCardType(String creditCardType) {
    
    
    
    this.creditCardType = creditCardType;
  }


  public GETPaymentMethodResponse deviceSessionId(String deviceSessionId) {
    
    
    
    
    this.deviceSessionId = deviceSessionId;
    return this;
  }

   /**
   * The session ID of the user when the &#x60;PaymentMethod&#x60; was created or updated. 
   * @return deviceSessionId
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The session ID of the user when the `PaymentMethod` was created or updated. ")

  public String getDeviceSessionId() {
    return deviceSessionId;
  }


  public void setDeviceSessionId(String deviceSessionId) {
    
    
    
    this.deviceSessionId = deviceSessionId;
  }


  public GETPaymentMethodResponse existingMandate(ExistingMandateEnum existingMandate) {
    
    
    
    
    this.existingMandate = existingMandate;
    return this;
  }

   /**
   * Indicates whether the mandate is an existing mandate. 
   * @return existingMandate
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Indicates whether the mandate is an existing mandate. ")

  public ExistingMandateEnum getExistingMandate() {
    return existingMandate;
  }


  public void setExistingMandate(ExistingMandateEnum existingMandate) {
    
    
    
    this.existingMandate = existingMandate;
  }


  public GETPaymentMethodResponse id(String id) {
    
    
    
    
    this.id = id;
    return this;
  }

   /**
   * The payment method ID. 
   * @return id
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The payment method ID. ")

  public String getId() {
    return id;
  }


  public void setId(String id) {
    
    
    
    this.id = id;
  }


  public GETPaymentMethodResponse ipAddress(String ipAddress) {
    
    
    
    
    this.ipAddress = ipAddress;
    return this;
  }

   /**
   * The IP address of the user when the payment method was created or updated. 
   * @return ipAddress
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The IP address of the user when the payment method was created or updated. ")

  public String getIpAddress() {
    return ipAddress;
  }


  public void setIpAddress(String ipAddress) {
    
    
    
    this.ipAddress = ipAddress;
  }


  public GETPaymentMethodResponse isDefault(Boolean isDefault) {
    
    
    
    
    this.isDefault = isDefault;
    return this;
  }

   /**
   * Indicates whether this payment method is the default payment method for the account. 
   * @return isDefault
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Indicates whether this payment method is the default payment method for the account. ")

  public Boolean getIsDefault() {
    return isDefault;
  }


  public void setIsDefault(Boolean isDefault) {
    
    
    
    this.isDefault = isDefault;
  }


  public GETPaymentMethodResponse lastFailedSaleTransactionDate(OffsetDateTime lastFailedSaleTransactionDate) {
    
    
    
    
    this.lastFailedSaleTransactionDate = lastFailedSaleTransactionDate;
    return this;
  }

   /**
   * The date of the last failed attempt to collect payment with this payment method. 
   * @return lastFailedSaleTransactionDate
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The date of the last failed attempt to collect payment with this payment method. ")

  public OffsetDateTime getLastFailedSaleTransactionDate() {
    return lastFailedSaleTransactionDate;
  }


  public void setLastFailedSaleTransactionDate(OffsetDateTime lastFailedSaleTransactionDate) {
    
    
    
    this.lastFailedSaleTransactionDate = lastFailedSaleTransactionDate;
  }


  public GETPaymentMethodResponse lastTransaction(String lastTransaction) {
    
    
    
    
    this.lastTransaction = lastTransaction;
    return this;
  }

   /**
   * ID of the last transaction of this payment method.
   * @return lastTransaction
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "ID of the last transaction of this payment method.")

  public String getLastTransaction() {
    return lastTransaction;
  }


  public void setLastTransaction(String lastTransaction) {
    
    
    
    this.lastTransaction = lastTransaction;
  }


  public GETPaymentMethodResponse lastTransactionTime(OffsetDateTime lastTransactionTime) {
    
    
    
    
    this.lastTransactionTime = lastTransactionTime;
    return this;
  }

   /**
   * The time when the last transaction of this payment method happened.
   * @return lastTransactionTime
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The time when the last transaction of this payment method happened.")

  public OffsetDateTime getLastTransactionTime() {
    return lastTransactionTime;
  }


  public void setLastTransactionTime(OffsetDateTime lastTransactionTime) {
    
    
    
    this.lastTransactionTime = lastTransactionTime;
  }


  public GETPaymentMethodResponse mandateInfo(POSTPMMandateInfo mandateInfo) {
    
    
    
    
    this.mandateInfo = mandateInfo;
    return this;
  }

   /**
   * Get mandateInfo
   * @return mandateInfo
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public POSTPMMandateInfo getMandateInfo() {
    return mandateInfo;
  }


  public void setMandateInfo(POSTPMMandateInfo mandateInfo) {
    
    
    
    this.mandateInfo = mandateInfo;
  }


  public GETPaymentMethodResponse maxConsecutivePaymentFailures(Integer maxConsecutivePaymentFailures) {
    
    
    
    
    this.maxConsecutivePaymentFailures = maxConsecutivePaymentFailures;
    return this;
  }

   /**
   * The number of allowable consecutive failures Zuora attempts with the payment method before stopping. 
   * @return maxConsecutivePaymentFailures
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The number of allowable consecutive failures Zuora attempts with the payment method before stopping. ")

  public Integer getMaxConsecutivePaymentFailures() {
    return maxConsecutivePaymentFailures;
  }


  public void setMaxConsecutivePaymentFailures(Integer maxConsecutivePaymentFailures) {
    
    
    
    this.maxConsecutivePaymentFailures = maxConsecutivePaymentFailures;
  }


  public GETPaymentMethodResponse numConsecutiveFailures(Integer numConsecutiveFailures) {
    
    
    
    
    this.numConsecutiveFailures = numConsecutiveFailures;
    return this;
  }

   /**
   * The number of consecutive failed payments for this payment method. It is reset to &#x60;0&#x60; upon successful payment.  
   * @return numConsecutiveFailures
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The number of consecutive failed payments for this payment method. It is reset to `0` upon successful payment.  ")

  public Integer getNumConsecutiveFailures() {
    return numConsecutiveFailures;
  }


  public void setNumConsecutiveFailures(Integer numConsecutiveFailures) {
    
    
    
    this.numConsecutiveFailures = numConsecutiveFailures;
  }


  public GETPaymentMethodResponse paymentRetryWindow(Integer paymentRetryWindow) {
    
    
    
    
    this.paymentRetryWindow = paymentRetryWindow;
    return this;
  }

   /**
   * The retry interval setting, which prevents making a payment attempt if the last failed attempt was within the last specified number of hours. 
   * @return paymentRetryWindow
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The retry interval setting, which prevents making a payment attempt if the last failed attempt was within the last specified number of hours. ")

  public Integer getPaymentRetryWindow() {
    return paymentRetryWindow;
  }


  public void setPaymentRetryWindow(Integer paymentRetryWindow) {
    
    
    
    this.paymentRetryWindow = paymentRetryWindow;
  }


  public GETPaymentMethodResponse secondTokenId(String secondTokenId) {
    
    
    
    
    this.secondTokenId = secondTokenId;
    return this;
  }

   /**
   * A gateway unique identifier that replaces sensitive payment method data.  **Note:** This field is only returned for the Credit Card Reference Transaction payment type. 
   * @return secondTokenId
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "A gateway unique identifier that replaces sensitive payment method data.  **Note:** This field is only returned for the Credit Card Reference Transaction payment type. ")

  public String getSecondTokenId() {
    return secondTokenId;
  }


  public void setSecondTokenId(String secondTokenId) {
    
    
    
    this.secondTokenId = secondTokenId;
  }


  public GETPaymentMethodResponse status(StatusEnum status) {
    
    
    
    
    this.status = status;
    return this;
  }

   /**
   * The status of the payment method. 
   * @return status
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The status of the payment method. ")

  public StatusEnum getStatus() {
    return status;
  }


  public void setStatus(StatusEnum status) {
    
    
    
    this.status = status;
  }


  public GETPaymentMethodResponse tokenId(String tokenId) {
    
    
    
    
    this.tokenId = tokenId;
    return this;
  }

   /**
   * A gateway unique identifier that replaces sensitive payment method data or represents a gateway&#39;s unique customer profile.  **Note:** This field is only returned for the Credit Card Reference Transaction payment type. 
   * @return tokenId
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "A gateway unique identifier that replaces sensitive payment method data or represents a gateway's unique customer profile.  **Note:** This field is only returned for the Credit Card Reference Transaction payment type. ")

  public String getTokenId() {
    return tokenId;
  }


  public void setTokenId(String tokenId) {
    
    
    
    this.tokenId = tokenId;
  }


  public GETPaymentMethodResponse totalNumberOfErrorPayments(Integer totalNumberOfErrorPayments) {
    
    
    
    
    this.totalNumberOfErrorPayments = totalNumberOfErrorPayments;
    return this;
  }

   /**
   * The number of error payments that used this payment method. 
   * @return totalNumberOfErrorPayments
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The number of error payments that used this payment method. ")

  public Integer getTotalNumberOfErrorPayments() {
    return totalNumberOfErrorPayments;
  }


  public void setTotalNumberOfErrorPayments(Integer totalNumberOfErrorPayments) {
    
    
    
    this.totalNumberOfErrorPayments = totalNumberOfErrorPayments;
  }


  public GETPaymentMethodResponse totalNumberOfProcessedPayments(Integer totalNumberOfProcessedPayments) {
    
    
    
    
    this.totalNumberOfProcessedPayments = totalNumberOfProcessedPayments;
    return this;
  }

   /**
   * The number of successful payments that used this payment method. 
   * @return totalNumberOfProcessedPayments
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The number of successful payments that used this payment method. ")

  public Integer getTotalNumberOfProcessedPayments() {
    return totalNumberOfProcessedPayments;
  }


  public void setTotalNumberOfProcessedPayments(Integer totalNumberOfProcessedPayments) {
    
    
    
    this.totalNumberOfProcessedPayments = totalNumberOfProcessedPayments;
  }


  public GETPaymentMethodResponse type(String type) {
    
    
    
    
    this.type = type;
    return this;
  }

   /**
   * The type of the payment method. For example, &#x60;CreditCard&#x60;. 
   * @return type
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The type of the payment method. For example, `CreditCard`. ")

  public String getType() {
    return type;
  }


  public void setType(String type) {
    
    
    
    this.type = type;
  }


  public GETPaymentMethodResponse updatedBy(String updatedBy) {
    
    
    
    
    this.updatedBy = updatedBy;
    return this;
  }

   /**
   * ID of the user who made the last update to this payment method.
   * @return updatedBy
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "ID of the user who made the last update to this payment method.")

  public String getUpdatedBy() {
    return updatedBy;
  }


  public void setUpdatedBy(String updatedBy) {
    
    
    
    this.updatedBy = updatedBy;
  }


  public GETPaymentMethodResponse updatedOn(OffsetDateTime updatedOn) {
    
    
    
    
    this.updatedOn = updatedOn;
    return this;
  }

   /**
   * The last date and time when the payment method was updated, in &#x60;yyyy-mm-dd hh:mm:ss&#x60; format. 
   * @return updatedOn
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The last date and time when the payment method was updated, in `yyyy-mm-dd hh:mm:ss` format. ")

  public OffsetDateTime getUpdatedOn() {
    return updatedOn;
  }


  public void setUpdatedOn(OffsetDateTime updatedOn) {
    
    
    
    this.updatedOn = updatedOn;
  }


  public GETPaymentMethodResponse useDefaultRetryRule(Boolean useDefaultRetryRule) {
    
    
    
    
    this.useDefaultRetryRule = useDefaultRetryRule;
    return this;
  }

   /**
   * Indicates whether this payment method uses the default retry rules configured in the Zuora Payments settings. 
   * @return useDefaultRetryRule
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Indicates whether this payment method uses the default retry rules configured in the Zuora Payments settings. ")

  public Boolean getUseDefaultRetryRule() {
    return useDefaultRetryRule;
  }


  public void setUseDefaultRetryRule(Boolean useDefaultRetryRule) {
    
    
    
    this.useDefaultRetryRule = useDefaultRetryRule;
  }


  public GETPaymentMethodResponse IBAN(String IBAN) {
    
    
    
    
    this.IBAN = IBAN;
    return this;
  }

   /**
   * The International Bank Account Number used to create the SEPA payment method. The value is masked. 
   * @return IBAN
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The International Bank Account Number used to create the SEPA payment method. The value is masked. ")

  public String getIBAN() {
    return IBAN;
  }


  public void setIBAN(String IBAN) {
    
    
    
    this.IBAN = IBAN;
  }


  public GETPaymentMethodResponse accountNumber(String accountNumber) {
    
    
    
    
    this.accountNumber = accountNumber;
    return this;
  }

   /**
   * The number of the customer&#39;s bank account and it is masked. 
   * @return accountNumber
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The number of the customer's bank account and it is masked. ")

  public String getAccountNumber() {
    return accountNumber;
  }


  public void setAccountNumber(String accountNumber) {
    
    
    
    this.accountNumber = accountNumber;
  }


  public GETPaymentMethodResponse bankCode(String bankCode) {
    
    
    
    
    this.bankCode = bankCode;
    return this;
  }

   /**
   * The sort code or number that identifies the bank. This is also known as the sort code.          
   * @return bankCode
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The sort code or number that identifies the bank. This is also known as the sort code.          ")

  public String getBankCode() {
    return bankCode;
  }


  public void setBankCode(String bankCode) {
    
    
    
    this.bankCode = bankCode;
  }


  public GETPaymentMethodResponse bankTransferType(String bankTransferType) {
    
    
    
    
    this.bankTransferType = bankTransferType;
    return this;
  }

   /**
   * The type of the Bank Transfer payment method. For example, &#x60;SEPA&#x60;. 
   * @return bankTransferType
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The type of the Bank Transfer payment method. For example, `SEPA`. ")

  public String getBankTransferType() {
    return bankTransferType;
  }


  public void setBankTransferType(String bankTransferType) {
    
    
    
    this.bankTransferType = bankTransferType;
  }


  public GETPaymentMethodResponse branchCode(String branchCode) {
    
    
    
    
    this.branchCode = branchCode;
    return this;
  }

   /**
   * The branch code of the bank used for Direct Debit.           
   * @return branchCode
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The branch code of the bank used for Direct Debit.           ")

  public String getBranchCode() {
    return branchCode;
  }


  public void setBranchCode(String branchCode) {
    
    
    
    this.branchCode = branchCode;
  }


  public GETPaymentMethodResponse businessIdentificationCode(String businessIdentificationCode) {
    
    
    
    
    this.businessIdentificationCode = businessIdentificationCode;
    return this;
  }

   /**
   * The BIC code used for SEPA. The value is masked.        
   * @return businessIdentificationCode
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The BIC code used for SEPA. The value is masked.        ")

  public String getBusinessIdentificationCode() {
    return businessIdentificationCode;
  }


  public void setBusinessIdentificationCode(String businessIdentificationCode) {
    
    
    
    this.businessIdentificationCode = businessIdentificationCode;
  }


  public GETPaymentMethodResponse identityNumber(String identityNumber) {
    
    
    
    
    this.identityNumber = identityNumber;
    return this;
  }

   /**
   * The identity number of the account holder or the cardholder. 
   * @return identityNumber
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The identity number of the account holder or the cardholder. ")

  public String getIdentityNumber() {
    return identityNumber;
  }


  public void setIdentityNumber(String identityNumber) {
    
    
    
    this.identityNumber = identityNumber;
  }


  public GETPaymentMethodResponse bankABACode(String bankABACode) {
    
    
    
    
    this.bankABACode = bankABACode;
    return this;
  }

   /**
   * The nine-digit routing number or ABA number used by banks. This field is only required if the &#x60;type&#x60; field is set to &#x60;ACH&#x60;. 
   * @return bankABACode
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The nine-digit routing number or ABA number used by banks. This field is only required if the `type` field is set to `ACH`. ")

  public String getBankABACode() {
    return bankABACode;
  }


  public void setBankABACode(String bankABACode) {
    
    
    
    this.bankABACode = bankABACode;
  }


  public GETPaymentMethodResponse bankAccountName(String bankAccountName) {
    
    
    
    
    this.bankAccountName = bankAccountName;
    return this;
  }

   /**
   * The name of the account holder, which can be either a person or a company. This field is only required if the &#x60;type&#x60; field is set to &#x60;ACH&#x60;. 
   * @return bankAccountName
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The name of the account holder, which can be either a person or a company. This field is only required if the `type` field is set to `ACH`. ")

  public String getBankAccountName() {
    return bankAccountName;
  }


  public void setBankAccountName(String bankAccountName) {
    
    
    
    this.bankAccountName = bankAccountName;
  }


  public GETPaymentMethodResponse bankAccountNumber(String bankAccountNumber) {
    
    
    
    
    this.bankAccountNumber = bankAccountNumber;
    return this;
  }

   /**
   * The bank account number associated with the ACH payment. This field is only required if the &#x60;type&#x60; field is set to &#x60;ACH&#x60;. 
   * @return bankAccountNumber
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The bank account number associated with the ACH payment. This field is only required if the `type` field is set to `ACH`. ")

  public String getBankAccountNumber() {
    return bankAccountNumber;
  }


  public void setBankAccountNumber(String bankAccountNumber) {
    
    
    
    this.bankAccountNumber = bankAccountNumber;
  }


  public GETPaymentMethodResponse bankAccountType(BankAccountTypeEnum bankAccountType) {
    
    
    
    
    this.bankAccountType = bankAccountType;
    return this;
  }

   /**
   * The type of bank account associated with the ACH payment. This field is only required if the &#x60;type&#x60; field is set to &#x60;ACH&#x60;.  When creating an ACH payment method on Adyen, this field is required by Zuora but it is not required by Adyen. To create the ACH payment method successfully, specify a real value for this field if you can. If it is not possible to get the real value for it, specify any of the allowed values as a dummy value, &#x60;Checking&#x60; preferably. 
   * @return bankAccountType
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The type of bank account associated with the ACH payment. This field is only required if the `type` field is set to `ACH`.  When creating an ACH payment method on Adyen, this field is required by Zuora but it is not required by Adyen. To create the ACH payment method successfully, specify a real value for this field if you can. If it is not possible to get the real value for it, specify any of the allowed values as a dummy value, `Checking` preferably. ")

  public BankAccountTypeEnum getBankAccountType() {
    return bankAccountType;
  }


  public void setBankAccountType(BankAccountTypeEnum bankAccountType) {
    
    
    
    this.bankAccountType = bankAccountType;
  }


  public GETPaymentMethodResponse bankName(String bankName) {
    
    
    
    
    this.bankName = bankName;
    return this;
  }

   /**
   * The name of the bank where the ACH payment account is held. This field is only required if the &#x60;type&#x60; field is set to &#x60;ACH&#x60;.  When creating an ACH payment method on Adyen, this field is required by Zuora but it is not required by Adyen. To create the ACH payment method successfully, specify a real value for this field if you can. If it is not possible to get the real value for it, specify a dummy value. 
   * @return bankName
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The name of the bank where the ACH payment account is held. This field is only required if the `type` field is set to `ACH`.  When creating an ACH payment method on Adyen, this field is required by Zuora but it is not required by Adyen. To create the ACH payment method successfully, specify a real value for this field if you can. If it is not possible to get the real value for it, specify a dummy value. ")

  public String getBankName() {
    return bankName;
  }


  public void setBankName(String bankName) {
    
    
    
    this.bankName = bankName;
  }


  public GETPaymentMethodResponse cardNumber(String cardNumber) {
    
    
    
    
    this.cardNumber = cardNumber;
    return this;
  }

   /**
   * The masked credit card number.  When &#x60;cardNumber&#x60; is &#x60;null&#x60;, the following fields will not be returned:   - &#x60;expirationMonth&#x60;   - &#x60;expirationYear&#x60;   - &#x60;accountHolderInfo&#x60; 
   * @return cardNumber
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The masked credit card number.  When `cardNumber` is `null`, the following fields will not be returned:   - `expirationMonth`   - `expirationYear`   - `accountHolderInfo` ")

  public String getCardNumber() {
    return cardNumber;
  }


  public void setCardNumber(String cardNumber) {
    
    
    
    this.cardNumber = cardNumber;
  }


  public GETPaymentMethodResponse expirationMonth(Integer expirationMonth) {
    
    
    
    
    this.expirationMonth = expirationMonth;
    return this;
  }

   /**
   * One or two digits expiration month (1-12).          
   * @return expirationMonth
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "One or two digits expiration month (1-12).          ")

  public Integer getExpirationMonth() {
    return expirationMonth;
  }


  public void setExpirationMonth(Integer expirationMonth) {
    
    
    
    this.expirationMonth = expirationMonth;
  }


  public GETPaymentMethodResponse expirationYear(Integer expirationYear) {
    
    
    
    
    this.expirationYear = expirationYear;
    return this;
  }

   /**
   * Four-digit expiration year. 
   * @return expirationYear
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Four-digit expiration year. ")

  public Integer getExpirationYear() {
    return expirationYear;
  }


  public void setExpirationYear(Integer expirationYear) {
    
    
    
    this.expirationYear = expirationYear;
  }


  public GETPaymentMethodResponse securityCode(String securityCode) {
    
    
    
    
    this.securityCode = securityCode;
    return this;
  }

   /**
   * The CVV or CVV2 security code for the credit card or debit card.             Only required if changing expirationMonth, expirationYear, or cardHolderName.             To ensure PCI compliance, this value isn&#39;&#39;t stored and can&#39;&#39;t be queried.                   
   * @return securityCode
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The CVV or CVV2 security code for the credit card or debit card.             Only required if changing expirationMonth, expirationYear, or cardHolderName.             To ensure PCI compliance, this value isn''t stored and can''t be queried.                   ")

  public String getSecurityCode() {
    return securityCode;
  }


  public void setSecurityCode(String securityCode) {
    
    
    
    this.securityCode = securityCode;
  }


  public GETPaymentMethodResponse BAID(String BAID) {
    
    
    
    
    this.BAID = BAID;
    return this;
  }

   /**
   * ID of a PayPal billing agreement. For example, I-1TJ3GAGG82Y9. 
   * @return BAID
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "ID of a PayPal billing agreement. For example, I-1TJ3GAGG82Y9. ")

  public String getBAID() {
    return BAID;
  }


  public void setBAID(String BAID) {
    
    
    
    this.BAID = BAID;
  }


  public GETPaymentMethodResponse email(String email) {
    
    
    
    
    this.email = email;
    return this;
  }

   /**
   * Email address associated with the PayPal payment method.  
   * @return email
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Email address associated with the PayPal payment method.  ")

  public String getEmail() {
    return email;
  }


  public void setEmail(String email) {
    
    
    
    this.email = email;
  }


  public GETPaymentMethodResponse preapprovalKey(String preapprovalKey) {
    
    
    
    
    this.preapprovalKey = preapprovalKey;
    return this;
  }

   /**
   * The PayPal preapproval key. 
   * @return preapprovalKey
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The PayPal preapproval key. ")

  public String getPreapprovalKey() {
    return preapprovalKey;
  }


  public void setPreapprovalKey(String preapprovalKey) {
    
    
    
    this.preapprovalKey = preapprovalKey;
  }


  public GETPaymentMethodResponse googleBIN(String googleBIN) {
    
    
    
    
    this.googleBIN = googleBIN;
    return this;
  }

   /**
   * This field is only available for Google Pay payment methods. 
   * @return googleBIN
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "This field is only available for Google Pay payment methods. ")

  public String getGoogleBIN() {
    return googleBIN;
  }


  public void setGoogleBIN(String googleBIN) {
    
    
    
    this.googleBIN = googleBIN;
  }


  public GETPaymentMethodResponse googleCardNumber(String googleCardNumber) {
    
    
    
    
    this.googleCardNumber = googleCardNumber;
    return this;
  }

   /**
   * This field is only available for Google Pay payment methods. 
   * @return googleCardNumber
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "This field is only available for Google Pay payment methods. ")

  public String getGoogleCardNumber() {
    return googleCardNumber;
  }


  public void setGoogleCardNumber(String googleCardNumber) {
    
    
    
    this.googleCardNumber = googleCardNumber;
  }


  public GETPaymentMethodResponse googleCardType(String googleCardType) {
    
    
    
    
    this.googleCardType = googleCardType;
    return this;
  }

   /**
   * This field is only available for Google Pay payment methods.  For Google Pay payment methods on Adyen, the first 100 characters of [paymentMethodVariant](https://docs.adyen.com/development-resources/paymentmethodvariant) returned from Adyen are stored in this field. 
   * @return googleCardType
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "This field is only available for Google Pay payment methods.  For Google Pay payment methods on Adyen, the first 100 characters of [paymentMethodVariant](https://docs.adyen.com/development-resources/paymentmethodvariant) returned from Adyen are stored in this field. ")

  public String getGoogleCardType() {
    return googleCardType;
  }


  public void setGoogleCardType(String googleCardType) {
    
    
    
    this.googleCardType = googleCardType;
  }


  public GETPaymentMethodResponse googleExpiryDate(String googleExpiryDate) {
    
    
    
    
    this.googleExpiryDate = googleExpiryDate;
    return this;
  }

   /**
   * This field is only available for Google Pay payment methods. 
   * @return googleExpiryDate
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "This field is only available for Google Pay payment methods. ")

  public String getGoogleExpiryDate() {
    return googleExpiryDate;
  }


  public void setGoogleExpiryDate(String googleExpiryDate) {
    
    
    
    this.googleExpiryDate = googleExpiryDate;
  }


  public GETPaymentMethodResponse googleGatewayToken(String googleGatewayToken) {
    
    
    
    
    this.googleGatewayToken = googleGatewayToken;
    return this;
  }

   /**
   * This field is only available for Google Pay payment methods. 
   * @return googleGatewayToken
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "This field is only available for Google Pay payment methods. ")

  public String getGoogleGatewayToken() {
    return googleGatewayToken;
  }


  public void setGoogleGatewayToken(String googleGatewayToken) {
    
    
    
    this.googleGatewayToken = googleGatewayToken;
  }


  public GETPaymentMethodResponse appleBIN(String appleBIN) {
    
    
    
    
    this.appleBIN = appleBIN;
    return this;
  }

   /**
   * This field is only available for Apple Pay payment methods. 
   * @return appleBIN
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "This field is only available for Apple Pay payment methods. ")

  public String getAppleBIN() {
    return appleBIN;
  }


  public void setAppleBIN(String appleBIN) {
    
    
    
    this.appleBIN = appleBIN;
  }


  public GETPaymentMethodResponse appleCardNumber(String appleCardNumber) {
    
    
    
    
    this.appleCardNumber = appleCardNumber;
    return this;
  }

   /**
   * This field is only available for Apple Pay payment methods. 
   * @return appleCardNumber
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "This field is only available for Apple Pay payment methods. ")

  public String getAppleCardNumber() {
    return appleCardNumber;
  }


  public void setAppleCardNumber(String appleCardNumber) {
    
    
    
    this.appleCardNumber = appleCardNumber;
  }


  public GETPaymentMethodResponse appleCardType(String appleCardType) {
    
    
    
    
    this.appleCardType = appleCardType;
    return this;
  }

   /**
   * This field is only available for Apple Pay payment methods.  For Apple Pay payment methods on Adyen, the first 100 characters of [paymentMethodVariant](https://docs.adyen.com/development-resources/paymentmethodvariant) returned from Adyen are stored in this field. 
   * @return appleCardType
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "This field is only available for Apple Pay payment methods.  For Apple Pay payment methods on Adyen, the first 100 characters of [paymentMethodVariant](https://docs.adyen.com/development-resources/paymentmethodvariant) returned from Adyen are stored in this field. ")

  public String getAppleCardType() {
    return appleCardType;
  }


  public void setAppleCardType(String appleCardType) {
    
    
    
    this.appleCardType = appleCardType;
  }


  public GETPaymentMethodResponse appleExpiryDate(String appleExpiryDate) {
    
    
    
    
    this.appleExpiryDate = appleExpiryDate;
    return this;
  }

   /**
   * This field is only available for Apple Pay payment methods. 
   * @return appleExpiryDate
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "This field is only available for Apple Pay payment methods. ")

  public String getAppleExpiryDate() {
    return appleExpiryDate;
  }


  public void setAppleExpiryDate(String appleExpiryDate) {
    
    
    
    this.appleExpiryDate = appleExpiryDate;
  }


  public GETPaymentMethodResponse appleGatewayToken(String appleGatewayToken) {
    
    
    
    
    this.appleGatewayToken = appleGatewayToken;
    return this;
  }

   /**
   * This field is only available for Apple Pay payment methods. 
   * @return appleGatewayToken
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "This field is only available for Apple Pay payment methods. ")

  public String getAppleGatewayToken() {
    return appleGatewayToken;
  }


  public void setAppleGatewayToken(String appleGatewayToken) {
    
    
    
    this.appleGatewayToken = appleGatewayToken;
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
   * @return the GETPaymentMethodResponse instance itself
   */
  public GETPaymentMethodResponse putAdditionalProperty(String key, Object value) {
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
    GETPaymentMethodResponse geTPaymentMethodResponse = (GETPaymentMethodResponse) o;
    return Objects.equals(this.accountHolderInfo, geTPaymentMethodResponse.accountHolderInfo) &&
        Objects.equals(this.bankIdentificationNumber, geTPaymentMethodResponse.bankIdentificationNumber) &&
        Objects.equals(this.createdBy, geTPaymentMethodResponse.createdBy) &&
        Objects.equals(this.createdOn, geTPaymentMethodResponse.createdOn) &&
        Objects.equals(this.creditCardMaskNumber, geTPaymentMethodResponse.creditCardMaskNumber) &&
        Objects.equals(this.creditCardType, geTPaymentMethodResponse.creditCardType) &&
        Objects.equals(this.deviceSessionId, geTPaymentMethodResponse.deviceSessionId) &&
        Objects.equals(this.existingMandate, geTPaymentMethodResponse.existingMandate) &&
        Objects.equals(this.id, geTPaymentMethodResponse.id) &&
        Objects.equals(this.ipAddress, geTPaymentMethodResponse.ipAddress) &&
        Objects.equals(this.isDefault, geTPaymentMethodResponse.isDefault) &&
        Objects.equals(this.lastFailedSaleTransactionDate, geTPaymentMethodResponse.lastFailedSaleTransactionDate) &&
        Objects.equals(this.lastTransaction, geTPaymentMethodResponse.lastTransaction) &&
        Objects.equals(this.lastTransactionTime, geTPaymentMethodResponse.lastTransactionTime) &&
        Objects.equals(this.mandateInfo, geTPaymentMethodResponse.mandateInfo) &&
        Objects.equals(this.maxConsecutivePaymentFailures, geTPaymentMethodResponse.maxConsecutivePaymentFailures) &&
        Objects.equals(this.numConsecutiveFailures, geTPaymentMethodResponse.numConsecutiveFailures) &&
        Objects.equals(this.paymentRetryWindow, geTPaymentMethodResponse.paymentRetryWindow) &&
        Objects.equals(this.secondTokenId, geTPaymentMethodResponse.secondTokenId) &&
        Objects.equals(this.status, geTPaymentMethodResponse.status) &&
        Objects.equals(this.tokenId, geTPaymentMethodResponse.tokenId) &&
        Objects.equals(this.totalNumberOfErrorPayments, geTPaymentMethodResponse.totalNumberOfErrorPayments) &&
        Objects.equals(this.totalNumberOfProcessedPayments, geTPaymentMethodResponse.totalNumberOfProcessedPayments) &&
        Objects.equals(this.type, geTPaymentMethodResponse.type) &&
        Objects.equals(this.updatedBy, geTPaymentMethodResponse.updatedBy) &&
        Objects.equals(this.updatedOn, geTPaymentMethodResponse.updatedOn) &&
        Objects.equals(this.useDefaultRetryRule, geTPaymentMethodResponse.useDefaultRetryRule) &&
        Objects.equals(this.IBAN, geTPaymentMethodResponse.IBAN) &&
        Objects.equals(this.accountNumber, geTPaymentMethodResponse.accountNumber) &&
        Objects.equals(this.bankCode, geTPaymentMethodResponse.bankCode) &&
        Objects.equals(this.bankTransferType, geTPaymentMethodResponse.bankTransferType) &&
        Objects.equals(this.branchCode, geTPaymentMethodResponse.branchCode) &&
        Objects.equals(this.businessIdentificationCode, geTPaymentMethodResponse.businessIdentificationCode) &&
        Objects.equals(this.identityNumber, geTPaymentMethodResponse.identityNumber) &&
        Objects.equals(this.bankABACode, geTPaymentMethodResponse.bankABACode) &&
        Objects.equals(this.bankAccountName, geTPaymentMethodResponse.bankAccountName) &&
        Objects.equals(this.bankAccountNumber, geTPaymentMethodResponse.bankAccountNumber) &&
        Objects.equals(this.bankAccountType, geTPaymentMethodResponse.bankAccountType) &&
        Objects.equals(this.bankName, geTPaymentMethodResponse.bankName) &&
        Objects.equals(this.cardNumber, geTPaymentMethodResponse.cardNumber) &&
        Objects.equals(this.expirationMonth, geTPaymentMethodResponse.expirationMonth) &&
        Objects.equals(this.expirationYear, geTPaymentMethodResponse.expirationYear) &&
        Objects.equals(this.securityCode, geTPaymentMethodResponse.securityCode) &&
        Objects.equals(this.BAID, geTPaymentMethodResponse.BAID) &&
        Objects.equals(this.email, geTPaymentMethodResponse.email) &&
        Objects.equals(this.preapprovalKey, geTPaymentMethodResponse.preapprovalKey) &&
        Objects.equals(this.googleBIN, geTPaymentMethodResponse.googleBIN) &&
        Objects.equals(this.googleCardNumber, geTPaymentMethodResponse.googleCardNumber) &&
        Objects.equals(this.googleCardType, geTPaymentMethodResponse.googleCardType) &&
        Objects.equals(this.googleExpiryDate, geTPaymentMethodResponse.googleExpiryDate) &&
        Objects.equals(this.googleGatewayToken, geTPaymentMethodResponse.googleGatewayToken) &&
        Objects.equals(this.appleBIN, geTPaymentMethodResponse.appleBIN) &&
        Objects.equals(this.appleCardNumber, geTPaymentMethodResponse.appleCardNumber) &&
        Objects.equals(this.appleCardType, geTPaymentMethodResponse.appleCardType) &&
        Objects.equals(this.appleExpiryDate, geTPaymentMethodResponse.appleExpiryDate) &&
        Objects.equals(this.appleGatewayToken, geTPaymentMethodResponse.appleGatewayToken)&&
        Objects.equals(this.additionalProperties, geTPaymentMethodResponse.additionalProperties);
  }

  @Override
  public int hashCode() {
    return Objects.hash(accountHolderInfo, bankIdentificationNumber, createdBy, createdOn, creditCardMaskNumber, creditCardType, deviceSessionId, existingMandate, id, ipAddress, isDefault, lastFailedSaleTransactionDate, lastTransaction, lastTransactionTime, mandateInfo, maxConsecutivePaymentFailures, numConsecutiveFailures, paymentRetryWindow, secondTokenId, status, tokenId, totalNumberOfErrorPayments, totalNumberOfProcessedPayments, type, updatedBy, updatedOn, useDefaultRetryRule, IBAN, accountNumber, bankCode, bankTransferType, branchCode, businessIdentificationCode, identityNumber, bankABACode, bankAccountName, bankAccountNumber, bankAccountType, bankName, cardNumber, expirationMonth, expirationYear, securityCode, BAID, email, preapprovalKey, googleBIN, googleCardNumber, googleCardType, googleExpiryDate, googleGatewayToken, appleBIN, appleCardNumber, appleCardType, appleExpiryDate, appleGatewayToken, additionalProperties);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GETPaymentMethodResponse {\n");
    sb.append("    accountHolderInfo: ").append(toIndentedString(accountHolderInfo)).append("\n");
    sb.append("    bankIdentificationNumber: ").append(toIndentedString(bankIdentificationNumber)).append("\n");
    sb.append("    createdBy: ").append(toIndentedString(createdBy)).append("\n");
    sb.append("    createdOn: ").append(toIndentedString(createdOn)).append("\n");
    sb.append("    creditCardMaskNumber: ").append(toIndentedString(creditCardMaskNumber)).append("\n");
    sb.append("    creditCardType: ").append(toIndentedString(creditCardType)).append("\n");
    sb.append("    deviceSessionId: ").append(toIndentedString(deviceSessionId)).append("\n");
    sb.append("    existingMandate: ").append(toIndentedString(existingMandate)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    ipAddress: ").append(toIndentedString(ipAddress)).append("\n");
    sb.append("    isDefault: ").append(toIndentedString(isDefault)).append("\n");
    sb.append("    lastFailedSaleTransactionDate: ").append(toIndentedString(lastFailedSaleTransactionDate)).append("\n");
    sb.append("    lastTransaction: ").append(toIndentedString(lastTransaction)).append("\n");
    sb.append("    lastTransactionTime: ").append(toIndentedString(lastTransactionTime)).append("\n");
    sb.append("    mandateInfo: ").append(toIndentedString(mandateInfo)).append("\n");
    sb.append("    maxConsecutivePaymentFailures: ").append(toIndentedString(maxConsecutivePaymentFailures)).append("\n");
    sb.append("    numConsecutiveFailures: ").append(toIndentedString(numConsecutiveFailures)).append("\n");
    sb.append("    paymentRetryWindow: ").append(toIndentedString(paymentRetryWindow)).append("\n");
    sb.append("    secondTokenId: ").append(toIndentedString(secondTokenId)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    tokenId: ").append(toIndentedString(tokenId)).append("\n");
    sb.append("    totalNumberOfErrorPayments: ").append(toIndentedString(totalNumberOfErrorPayments)).append("\n");
    sb.append("    totalNumberOfProcessedPayments: ").append(toIndentedString(totalNumberOfProcessedPayments)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    updatedBy: ").append(toIndentedString(updatedBy)).append("\n");
    sb.append("    updatedOn: ").append(toIndentedString(updatedOn)).append("\n");
    sb.append("    useDefaultRetryRule: ").append(toIndentedString(useDefaultRetryRule)).append("\n");
    sb.append("    IBAN: ").append(toIndentedString(IBAN)).append("\n");
    sb.append("    accountNumber: ").append(toIndentedString(accountNumber)).append("\n");
    sb.append("    bankCode: ").append(toIndentedString(bankCode)).append("\n");
    sb.append("    bankTransferType: ").append(toIndentedString(bankTransferType)).append("\n");
    sb.append("    branchCode: ").append(toIndentedString(branchCode)).append("\n");
    sb.append("    businessIdentificationCode: ").append(toIndentedString(businessIdentificationCode)).append("\n");
    sb.append("    identityNumber: ").append(toIndentedString(identityNumber)).append("\n");
    sb.append("    bankABACode: ").append(toIndentedString(bankABACode)).append("\n");
    sb.append("    bankAccountName: ").append(toIndentedString(bankAccountName)).append("\n");
    sb.append("    bankAccountNumber: ").append(toIndentedString(bankAccountNumber)).append("\n");
    sb.append("    bankAccountType: ").append(toIndentedString(bankAccountType)).append("\n");
    sb.append("    bankName: ").append(toIndentedString(bankName)).append("\n");
    sb.append("    cardNumber: ").append(toIndentedString(cardNumber)).append("\n");
    sb.append("    expirationMonth: ").append(toIndentedString(expirationMonth)).append("\n");
    sb.append("    expirationYear: ").append(toIndentedString(expirationYear)).append("\n");
    sb.append("    securityCode: ").append(toIndentedString(securityCode)).append("\n");
    sb.append("    BAID: ").append(toIndentedString(BAID)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    preapprovalKey: ").append(toIndentedString(preapprovalKey)).append("\n");
    sb.append("    googleBIN: ").append(toIndentedString(googleBIN)).append("\n");
    sb.append("    googleCardNumber: ").append(toIndentedString(googleCardNumber)).append("\n");
    sb.append("    googleCardType: ").append(toIndentedString(googleCardType)).append("\n");
    sb.append("    googleExpiryDate: ").append(toIndentedString(googleExpiryDate)).append("\n");
    sb.append("    googleGatewayToken: ").append(toIndentedString(googleGatewayToken)).append("\n");
    sb.append("    appleBIN: ").append(toIndentedString(appleBIN)).append("\n");
    sb.append("    appleCardNumber: ").append(toIndentedString(appleCardNumber)).append("\n");
    sb.append("    appleCardType: ").append(toIndentedString(appleCardType)).append("\n");
    sb.append("    appleExpiryDate: ").append(toIndentedString(appleExpiryDate)).append("\n");
    sb.append("    appleGatewayToken: ").append(toIndentedString(appleGatewayToken)).append("\n");
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
    openapiFields.add("accountHolderInfo");
    openapiFields.add("bankIdentificationNumber");
    openapiFields.add("createdBy");
    openapiFields.add("createdOn");
    openapiFields.add("creditCardMaskNumber");
    openapiFields.add("creditCardType");
    openapiFields.add("deviceSessionId");
    openapiFields.add("existingMandate");
    openapiFields.add("id");
    openapiFields.add("ipAddress");
    openapiFields.add("isDefault");
    openapiFields.add("lastFailedSaleTransactionDate");
    openapiFields.add("lastTransaction");
    openapiFields.add("lastTransactionTime");
    openapiFields.add("mandateInfo");
    openapiFields.add("maxConsecutivePaymentFailures");
    openapiFields.add("numConsecutiveFailures");
    openapiFields.add("paymentRetryWindow");
    openapiFields.add("secondTokenId");
    openapiFields.add("status");
    openapiFields.add("tokenId");
    openapiFields.add("totalNumberOfErrorPayments");
    openapiFields.add("totalNumberOfProcessedPayments");
    openapiFields.add("type");
    openapiFields.add("updatedBy");
    openapiFields.add("updatedOn");
    openapiFields.add("useDefaultRetryRule");
    openapiFields.add("IBAN");
    openapiFields.add("accountNumber");
    openapiFields.add("bankCode");
    openapiFields.add("bankTransferType");
    openapiFields.add("branchCode");
    openapiFields.add("businessIdentificationCode");
    openapiFields.add("identityNumber");
    openapiFields.add("bankABACode");
    openapiFields.add("bankAccountName");
    openapiFields.add("bankAccountNumber");
    openapiFields.add("bankAccountType");
    openapiFields.add("bankName");
    openapiFields.add("cardNumber");
    openapiFields.add("expirationMonth");
    openapiFields.add("expirationYear");
    openapiFields.add("securityCode");
    openapiFields.add("BAID");
    openapiFields.add("email");
    openapiFields.add("preapprovalKey");
    openapiFields.add("googleBIN");
    openapiFields.add("googleCardNumber");
    openapiFields.add("googleCardType");
    openapiFields.add("googleExpiryDate");
    openapiFields.add("googleGatewayToken");
    openapiFields.add("appleBIN");
    openapiFields.add("appleCardNumber");
    openapiFields.add("appleCardType");
    openapiFields.add("appleExpiryDate");
    openapiFields.add("appleGatewayToken");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
  }

 /**
  * Validates the JSON Object and throws an exception if issues found
  *
  * @param jsonObj JSON Object
  * @throws IOException if the JSON Object is invalid with respect to GETPaymentMethodResponse
  */
  public static void validateJsonObject(JsonObject jsonObj) throws IOException {
      if (jsonObj == null) {
        if (!GETPaymentMethodResponse.openapiRequiredFields.isEmpty()) { // has required fields but JSON object is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in GETPaymentMethodResponse is not found in the empty JSON string", GETPaymentMethodResponse.openapiRequiredFields.toString()));
        }
      }
      // validate the optional field `accountHolderInfo`
      if (jsonObj.get("accountHolderInfo") != null && !jsonObj.get("accountHolderInfo").isJsonNull()) {
        GETPMAccountHolderInfo.validateJsonObject(jsonObj.getAsJsonObject("accountHolderInfo"));
      }
      if ((jsonObj.get("bankIdentificationNumber") != null && !jsonObj.get("bankIdentificationNumber").isJsonNull()) && !jsonObj.get("bankIdentificationNumber").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `bankIdentificationNumber` to be a primitive type in the JSON string but got `%s`", jsonObj.get("bankIdentificationNumber").toString()));
      }
      if ((jsonObj.get("createdBy") != null && !jsonObj.get("createdBy").isJsonNull()) && !jsonObj.get("createdBy").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `createdBy` to be a primitive type in the JSON string but got `%s`", jsonObj.get("createdBy").toString()));
      }
      if ((jsonObj.get("creditCardMaskNumber") != null && !jsonObj.get("creditCardMaskNumber").isJsonNull()) && !jsonObj.get("creditCardMaskNumber").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `creditCardMaskNumber` to be a primitive type in the JSON string but got `%s`", jsonObj.get("creditCardMaskNumber").toString()));
      }
      if ((jsonObj.get("creditCardType") != null && !jsonObj.get("creditCardType").isJsonNull()) && !jsonObj.get("creditCardType").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `creditCardType` to be a primitive type in the JSON string but got `%s`", jsonObj.get("creditCardType").toString()));
      }
      if ((jsonObj.get("deviceSessionId") != null && !jsonObj.get("deviceSessionId").isJsonNull()) && !jsonObj.get("deviceSessionId").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `deviceSessionId` to be a primitive type in the JSON string but got `%s`", jsonObj.get("deviceSessionId").toString()));
      }
      if ((jsonObj.get("existingMandate") != null && !jsonObj.get("existingMandate").isJsonNull()) && !jsonObj.get("existingMandate").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `existingMandate` to be a primitive type in the JSON string but got `%s`", jsonObj.get("existingMandate").toString()));
      }
      if ((jsonObj.get("id") != null && !jsonObj.get("id").isJsonNull()) && !jsonObj.get("id").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `id` to be a primitive type in the JSON string but got `%s`", jsonObj.get("id").toString()));
      }
      if ((jsonObj.get("ipAddress") != null && !jsonObj.get("ipAddress").isJsonNull()) && !jsonObj.get("ipAddress").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `ipAddress` to be a primitive type in the JSON string but got `%s`", jsonObj.get("ipAddress").toString()));
      }
      if ((jsonObj.get("lastTransaction") != null && !jsonObj.get("lastTransaction").isJsonNull()) && !jsonObj.get("lastTransaction").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `lastTransaction` to be a primitive type in the JSON string but got `%s`", jsonObj.get("lastTransaction").toString()));
      }
      // validate the optional field `mandateInfo`
      if (jsonObj.get("mandateInfo") != null && !jsonObj.get("mandateInfo").isJsonNull()) {
        POSTPMMandateInfo.validateJsonObject(jsonObj.getAsJsonObject("mandateInfo"));
      }
      if ((jsonObj.get("secondTokenId") != null && !jsonObj.get("secondTokenId").isJsonNull()) && !jsonObj.get("secondTokenId").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `secondTokenId` to be a primitive type in the JSON string but got `%s`", jsonObj.get("secondTokenId").toString()));
      }
      if ((jsonObj.get("status") != null && !jsonObj.get("status").isJsonNull()) && !jsonObj.get("status").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `status` to be a primitive type in the JSON string but got `%s`", jsonObj.get("status").toString()));
      }
      if ((jsonObj.get("tokenId") != null && !jsonObj.get("tokenId").isJsonNull()) && !jsonObj.get("tokenId").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `tokenId` to be a primitive type in the JSON string but got `%s`", jsonObj.get("tokenId").toString()));
      }
      if ((jsonObj.get("type") != null && !jsonObj.get("type").isJsonNull()) && !jsonObj.get("type").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `type` to be a primitive type in the JSON string but got `%s`", jsonObj.get("type").toString()));
      }
      if ((jsonObj.get("updatedBy") != null && !jsonObj.get("updatedBy").isJsonNull()) && !jsonObj.get("updatedBy").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `updatedBy` to be a primitive type in the JSON string but got `%s`", jsonObj.get("updatedBy").toString()));
      }
      if ((jsonObj.get("IBAN") != null && !jsonObj.get("IBAN").isJsonNull()) && !jsonObj.get("IBAN").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `IBAN` to be a primitive type in the JSON string but got `%s`", jsonObj.get("IBAN").toString()));
      }
      if ((jsonObj.get("accountNumber") != null && !jsonObj.get("accountNumber").isJsonNull()) && !jsonObj.get("accountNumber").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `accountNumber` to be a primitive type in the JSON string but got `%s`", jsonObj.get("accountNumber").toString()));
      }
      if ((jsonObj.get("bankCode") != null && !jsonObj.get("bankCode").isJsonNull()) && !jsonObj.get("bankCode").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `bankCode` to be a primitive type in the JSON string but got `%s`", jsonObj.get("bankCode").toString()));
      }
      if ((jsonObj.get("bankTransferType") != null && !jsonObj.get("bankTransferType").isJsonNull()) && !jsonObj.get("bankTransferType").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `bankTransferType` to be a primitive type in the JSON string but got `%s`", jsonObj.get("bankTransferType").toString()));
      }
      if ((jsonObj.get("branchCode") != null && !jsonObj.get("branchCode").isJsonNull()) && !jsonObj.get("branchCode").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `branchCode` to be a primitive type in the JSON string but got `%s`", jsonObj.get("branchCode").toString()));
      }
      if ((jsonObj.get("businessIdentificationCode") != null && !jsonObj.get("businessIdentificationCode").isJsonNull()) && !jsonObj.get("businessIdentificationCode").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `businessIdentificationCode` to be a primitive type in the JSON string but got `%s`", jsonObj.get("businessIdentificationCode").toString()));
      }
      if ((jsonObj.get("identityNumber") != null && !jsonObj.get("identityNumber").isJsonNull()) && !jsonObj.get("identityNumber").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `identityNumber` to be a primitive type in the JSON string but got `%s`", jsonObj.get("identityNumber").toString()));
      }
      if ((jsonObj.get("bankABACode") != null && !jsonObj.get("bankABACode").isJsonNull()) && !jsonObj.get("bankABACode").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `bankABACode` to be a primitive type in the JSON string but got `%s`", jsonObj.get("bankABACode").toString()));
      }
      if ((jsonObj.get("bankAccountName") != null && !jsonObj.get("bankAccountName").isJsonNull()) && !jsonObj.get("bankAccountName").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `bankAccountName` to be a primitive type in the JSON string but got `%s`", jsonObj.get("bankAccountName").toString()));
      }
      if ((jsonObj.get("bankAccountNumber") != null && !jsonObj.get("bankAccountNumber").isJsonNull()) && !jsonObj.get("bankAccountNumber").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `bankAccountNumber` to be a primitive type in the JSON string but got `%s`", jsonObj.get("bankAccountNumber").toString()));
      }
      if ((jsonObj.get("bankAccountType") != null && !jsonObj.get("bankAccountType").isJsonNull()) && !jsonObj.get("bankAccountType").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `bankAccountType` to be a primitive type in the JSON string but got `%s`", jsonObj.get("bankAccountType").toString()));
      }
      if ((jsonObj.get("bankName") != null && !jsonObj.get("bankName").isJsonNull()) && !jsonObj.get("bankName").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `bankName` to be a primitive type in the JSON string but got `%s`", jsonObj.get("bankName").toString()));
      }
      if ((jsonObj.get("cardNumber") != null && !jsonObj.get("cardNumber").isJsonNull()) && !jsonObj.get("cardNumber").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `cardNumber` to be a primitive type in the JSON string but got `%s`", jsonObj.get("cardNumber").toString()));
      }
      if ((jsonObj.get("securityCode") != null && !jsonObj.get("securityCode").isJsonNull()) && !jsonObj.get("securityCode").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `securityCode` to be a primitive type in the JSON string but got `%s`", jsonObj.get("securityCode").toString()));
      }
      if ((jsonObj.get("BAID") != null && !jsonObj.get("BAID").isJsonNull()) && !jsonObj.get("BAID").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `BAID` to be a primitive type in the JSON string but got `%s`", jsonObj.get("BAID").toString()));
      }
      if ((jsonObj.get("email") != null && !jsonObj.get("email").isJsonNull()) && !jsonObj.get("email").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `email` to be a primitive type in the JSON string but got `%s`", jsonObj.get("email").toString()));
      }
      if ((jsonObj.get("preapprovalKey") != null && !jsonObj.get("preapprovalKey").isJsonNull()) && !jsonObj.get("preapprovalKey").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `preapprovalKey` to be a primitive type in the JSON string but got `%s`", jsonObj.get("preapprovalKey").toString()));
      }
      if ((jsonObj.get("googleBIN") != null && !jsonObj.get("googleBIN").isJsonNull()) && !jsonObj.get("googleBIN").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `googleBIN` to be a primitive type in the JSON string but got `%s`", jsonObj.get("googleBIN").toString()));
      }
      if ((jsonObj.get("googleCardNumber") != null && !jsonObj.get("googleCardNumber").isJsonNull()) && !jsonObj.get("googleCardNumber").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `googleCardNumber` to be a primitive type in the JSON string but got `%s`", jsonObj.get("googleCardNumber").toString()));
      }
      if ((jsonObj.get("googleCardType") != null && !jsonObj.get("googleCardType").isJsonNull()) && !jsonObj.get("googleCardType").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `googleCardType` to be a primitive type in the JSON string but got `%s`", jsonObj.get("googleCardType").toString()));
      }
      if ((jsonObj.get("googleExpiryDate") != null && !jsonObj.get("googleExpiryDate").isJsonNull()) && !jsonObj.get("googleExpiryDate").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `googleExpiryDate` to be a primitive type in the JSON string but got `%s`", jsonObj.get("googleExpiryDate").toString()));
      }
      if ((jsonObj.get("googleGatewayToken") != null && !jsonObj.get("googleGatewayToken").isJsonNull()) && !jsonObj.get("googleGatewayToken").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `googleGatewayToken` to be a primitive type in the JSON string but got `%s`", jsonObj.get("googleGatewayToken").toString()));
      }
      if ((jsonObj.get("appleBIN") != null && !jsonObj.get("appleBIN").isJsonNull()) && !jsonObj.get("appleBIN").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `appleBIN` to be a primitive type in the JSON string but got `%s`", jsonObj.get("appleBIN").toString()));
      }
      if ((jsonObj.get("appleCardNumber") != null && !jsonObj.get("appleCardNumber").isJsonNull()) && !jsonObj.get("appleCardNumber").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `appleCardNumber` to be a primitive type in the JSON string but got `%s`", jsonObj.get("appleCardNumber").toString()));
      }
      if ((jsonObj.get("appleCardType") != null && !jsonObj.get("appleCardType").isJsonNull()) && !jsonObj.get("appleCardType").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `appleCardType` to be a primitive type in the JSON string but got `%s`", jsonObj.get("appleCardType").toString()));
      }
      if ((jsonObj.get("appleExpiryDate") != null && !jsonObj.get("appleExpiryDate").isJsonNull()) && !jsonObj.get("appleExpiryDate").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `appleExpiryDate` to be a primitive type in the JSON string but got `%s`", jsonObj.get("appleExpiryDate").toString()));
      }
      if ((jsonObj.get("appleGatewayToken") != null && !jsonObj.get("appleGatewayToken").isJsonNull()) && !jsonObj.get("appleGatewayToken").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `appleGatewayToken` to be a primitive type in the JSON string but got `%s`", jsonObj.get("appleGatewayToken").toString()));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!GETPaymentMethodResponse.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'GETPaymentMethodResponse' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<GETPaymentMethodResponse> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(GETPaymentMethodResponse.class));

       return (TypeAdapter<T>) new TypeAdapter<GETPaymentMethodResponse>() {
           @Override
           public void write(JsonWriter out, GETPaymentMethodResponse value) throws IOException {
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
           public GETPaymentMethodResponse read(JsonReader in) throws IOException {
             JsonObject jsonObj = elementAdapter.read(in).getAsJsonObject();
             validateJsonObject(jsonObj);
             // store additional fields in the deserialized instance
             GETPaymentMethodResponse instance = thisAdapter.fromJsonTree(jsonObj);
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
  * Create an instance of GETPaymentMethodResponse given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of GETPaymentMethodResponse
  * @throws IOException if the JSON string is invalid with respect to GETPaymentMethodResponse
  */
  public static GETPaymentMethodResponse fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, GETPaymentMethodResponse.class);
  }

 /**
  * Convert an instance of GETPaymentMethodResponse to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

