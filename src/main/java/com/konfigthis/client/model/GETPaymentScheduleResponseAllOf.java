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
import com.konfigthis.client.model.GETPaymentScheduleItemResponseAllOfBillingDocument;
import com.konfigthis.client.model.PaymentScheduleItemCommonResponse;
import com.konfigthis.client.model.PaymentSchedulePaymentOptionFields;
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
 * GETPaymentScheduleResponseAllOf
 */@javax.annotation.Generated(value = "Generated by https://konfigthis.com")
public class GETPaymentScheduleResponseAllOf {
  public static final String SERIALIZED_NAME_DESCRIPTION = "description";
  @SerializedName(SERIALIZED_NAME_DESCRIPTION)
  private String description;

  public static final String SERIALIZED_NAME_ACCOUNT_ID = "accountId";
  @SerializedName(SERIALIZED_NAME_ACCOUNT_ID)
  private String accountId;

  public static final String SERIALIZED_NAME_ACCOUNT_NUMBER = "accountNumber";
  @SerializedName(SERIALIZED_NAME_ACCOUNT_NUMBER)
  private String accountNumber;

  public static final String SERIALIZED_NAME_BILLING_DOCUMENT = "billingDocument";
  @SerializedName(SERIALIZED_NAME_BILLING_DOCUMENT)
  private GETPaymentScheduleItemResponseAllOfBillingDocument billingDocument;

  public static final String SERIALIZED_NAME_CREATED_BY_ID = "createdById";
  @SerializedName(SERIALIZED_NAME_CREATED_BY_ID)
  private String createdById;

  public static final String SERIALIZED_NAME_CREATED_DATE = "createdDate";
  @SerializedName(SERIALIZED_NAME_CREATED_DATE)
  private LocalDate createdDate;

  public static final String SERIALIZED_NAME_ID = "id";
  @SerializedName(SERIALIZED_NAME_ID)
  private String id;

  public static final String SERIALIZED_NAME_IS_CUSTOM = "isCustom";
  @SerializedName(SERIALIZED_NAME_IS_CUSTOM)
  private Boolean isCustom;

  public static final String SERIALIZED_NAME_ITEMS = "items";
  @SerializedName(SERIALIZED_NAME_ITEMS)
  private List<PaymentScheduleItemCommonResponse> items = null;

  public static final String SERIALIZED_NAME_NEXT_PAYMENT_DATE = "nextPaymentDate";
  @SerializedName(SERIALIZED_NAME_NEXT_PAYMENT_DATE)
  private LocalDate nextPaymentDate;

  public static final String SERIALIZED_NAME_OCCURRENCES = "occurrences";
  @SerializedName(SERIALIZED_NAME_OCCURRENCES)
  private Integer occurrences;

  public static final String SERIALIZED_NAME_PAYMENT_OPTION = "paymentOption";
  @SerializedName(SERIALIZED_NAME_PAYMENT_OPTION)
  private List<PaymentSchedulePaymentOptionFields> paymentOption = null;

  public static final String SERIALIZED_NAME_PAYMENT_SCHEDULE_NUMBER = "paymentScheduleNumber";
  @SerializedName(SERIALIZED_NAME_PAYMENT_SCHEDULE_NUMBER)
  private String paymentScheduleNumber;

  public static final String SERIALIZED_NAME_PERIOD = "period";
  @SerializedName(SERIALIZED_NAME_PERIOD)
  private String period;

  public static final String SERIALIZED_NAME_PREPAYMENT = "prepayment";
  @SerializedName(SERIALIZED_NAME_PREPAYMENT)
  private Boolean prepayment;

  public static final String SERIALIZED_NAME_RECENT_PAYMENT_DATE = "recentPaymentDate";
  @SerializedName(SERIALIZED_NAME_RECENT_PAYMENT_DATE)
  private LocalDate recentPaymentDate;

  public static final String SERIALIZED_NAME_RUN_HOUR = "runHour";
  @SerializedName(SERIALIZED_NAME_RUN_HOUR)
  private Integer runHour;

  public static final String SERIALIZED_NAME_STANDALONE = "standalone";
  @SerializedName(SERIALIZED_NAME_STANDALONE)
  private Boolean standalone;

  public static final String SERIALIZED_NAME_START_DATE = "startDate";
  @SerializedName(SERIALIZED_NAME_START_DATE)
  private LocalDate startDate;

  /**
   * The status of the payment schedule.  - Active: There is still payment schedule item to process. - Canceled: After a payment schedule is canceled by the user, the schedule is marked as &#x60;Canceled&#x60;. - Completed: After all payment schedule items are processed, the schedule is marked as &#x60;Completed&#x60;. 
   */
  @JsonAdapter(StatusEnum.Adapter.class)
 public enum StatusEnum {
    ACTIVE("Active"),
    
    CANCELED("Canceled"),
    
    COMPLETED("Completed");

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

  public static final String SERIALIZED_NAME_SUCCESS = "success";
  @SerializedName(SERIALIZED_NAME_SUCCESS)
  private Boolean success;

  public static final String SERIALIZED_NAME_TOTAL_AMOUNT = "totalAmount";
  @SerializedName(SERIALIZED_NAME_TOTAL_AMOUNT)
  private Double totalAmount;

  public static final String SERIALIZED_NAME_TOTAL_PAYMENTS_ERRORED = "totalPaymentsErrored";
  @SerializedName(SERIALIZED_NAME_TOTAL_PAYMENTS_ERRORED)
  private Integer totalPaymentsErrored;

  public static final String SERIALIZED_NAME_TOTAL_PAYMENTS_PROCESSED = "totalPaymentsProcessed";
  @SerializedName(SERIALIZED_NAME_TOTAL_PAYMENTS_PROCESSED)
  private Integer totalPaymentsProcessed;

  public static final String SERIALIZED_NAME_UPDATED_BY_ID = "updatedById";
  @SerializedName(SERIALIZED_NAME_UPDATED_BY_ID)
  private String updatedById;

  public static final String SERIALIZED_NAME_UPDATED_DATE = "updatedDate";
  @SerializedName(SERIALIZED_NAME_UPDATED_DATE)
  private LocalDate updatedDate;

  public GETPaymentScheduleResponseAllOf() {
  }

  public GETPaymentScheduleResponseAllOf description(String description) {
    
    
    
    
    this.description = description;
    return this;
  }

   /**
   * The description of the payment schedule. 
   * @return description
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The description of the payment schedule. ")

  public String getDescription() {
    return description;
  }


  public void setDescription(String description) {
    
    
    
    this.description = description;
  }


  public GETPaymentScheduleResponseAllOf accountId(String accountId) {
    
    
    
    
    this.accountId = accountId;
    return this;
  }

   /**
   * ID of the account that owns the payment schedule. 
   * @return accountId
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "ID of the account that owns the payment schedule. ")

  public String getAccountId() {
    return accountId;
  }


  public void setAccountId(String accountId) {
    
    
    
    this.accountId = accountId;
  }


  public GETPaymentScheduleResponseAllOf accountNumber(String accountNumber) {
    
    
    
    
    this.accountNumber = accountNumber;
    return this;
  }

   /**
   * Number of the account that owns the payment schedule. 
   * @return accountNumber
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Number of the account that owns the payment schedule. ")

  public String getAccountNumber() {
    return accountNumber;
  }


  public void setAccountNumber(String accountNumber) {
    
    
    
    this.accountNumber = accountNumber;
  }


  public GETPaymentScheduleResponseAllOf billingDocument(GETPaymentScheduleItemResponseAllOfBillingDocument billingDocument) {
    
    
    
    
    this.billingDocument = billingDocument;
    return this;
  }

   /**
   * Get billingDocument
   * @return billingDocument
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public GETPaymentScheduleItemResponseAllOfBillingDocument getBillingDocument() {
    return billingDocument;
  }


  public void setBillingDocument(GETPaymentScheduleItemResponseAllOfBillingDocument billingDocument) {
    
    
    
    this.billingDocument = billingDocument;
  }


  public GETPaymentScheduleResponseAllOf createdById(String createdById) {
    
    
    
    
    this.createdById = createdById;
    return this;
  }

   /**
   * The ID of the user who created this payment schedule. 
   * @return createdById
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The ID of the user who created this payment schedule. ")

  public String getCreatedById() {
    return createdById;
  }


  public void setCreatedById(String createdById) {
    
    
    
    this.createdById = createdById;
  }


  public GETPaymentScheduleResponseAllOf createdDate(LocalDate createdDate) {
    
    
    
    
    this.createdDate = createdDate;
    return this;
  }

   /**
   * The date and time the payment schedule is created. 
   * @return createdDate
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The date and time the payment schedule is created. ")

  public LocalDate getCreatedDate() {
    return createdDate;
  }


  public void setCreatedDate(LocalDate createdDate) {
    
    
    
    this.createdDate = createdDate;
  }


  public GETPaymentScheduleResponseAllOf id(String id) {
    
    
    
    
    this.id = id;
    return this;
  }

   /**
   * ID of the payment schedule. 
   * @return id
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "ID of the payment schedule. ")

  public String getId() {
    return id;
  }


  public void setId(String id) {
    
    
    
    this.id = id;
  }


  public GETPaymentScheduleResponseAllOf isCustom(Boolean isCustom) {
    
    
    
    
    this.isCustom = isCustom;
    return this;
  }

   /**
   * Indicates if the payment schedule is a custom payment schedule. 
   * @return isCustom
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Indicates if the payment schedule is a custom payment schedule. ")

  public Boolean getIsCustom() {
    return isCustom;
  }


  public void setIsCustom(Boolean isCustom) {
    
    
    
    this.isCustom = isCustom;
  }


  public GETPaymentScheduleResponseAllOf items(List<PaymentScheduleItemCommonResponse> items) {
    
    
    
    
    this.items = items;
    return this;
  }

  public GETPaymentScheduleResponseAllOf addItemsItem(PaymentScheduleItemCommonResponse itemsItem) {
    if (this.items == null) {
      this.items = new ArrayList<>();
    }
    this.items.add(itemsItem);
    return this;
  }

   /**
   * Container for payment schedule items. 
   * @return items
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Container for payment schedule items. ")

  public List<PaymentScheduleItemCommonResponse> getItems() {
    return items;
  }


  public void setItems(List<PaymentScheduleItemCommonResponse> items) {
    
    
    
    this.items = items;
  }


  public GETPaymentScheduleResponseAllOf nextPaymentDate(LocalDate nextPaymentDate) {
    
    
    
    
    this.nextPaymentDate = nextPaymentDate;
    return this;
  }

   /**
   * The date the next payment will be processed. 
   * @return nextPaymentDate
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The date the next payment will be processed. ")

  public LocalDate getNextPaymentDate() {
    return nextPaymentDate;
  }


  public void setNextPaymentDate(LocalDate nextPaymentDate) {
    
    
    
    this.nextPaymentDate = nextPaymentDate;
  }


  public GETPaymentScheduleResponseAllOf occurrences(Integer occurrences) {
    
    
    
    
    this.occurrences = occurrences;
    return this;
  }

   /**
   * The number of payment schedule items that are created by this payment schedule. 
   * @return occurrences
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The number of payment schedule items that are created by this payment schedule. ")

  public Integer getOccurrences() {
    return occurrences;
  }


  public void setOccurrences(Integer occurrences) {
    
    
    
    this.occurrences = occurrences;
  }


  public GETPaymentScheduleResponseAllOf paymentOption(List<PaymentSchedulePaymentOptionFields> paymentOption) {
    
    
    
    
    this.paymentOption = paymentOption;
    return this;
  }

  public GETPaymentScheduleResponseAllOf addPaymentOptionItem(PaymentSchedulePaymentOptionFields paymentOptionItem) {
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


  public GETPaymentScheduleResponseAllOf paymentScheduleNumber(String paymentScheduleNumber) {
    
    
    
    
    this.paymentScheduleNumber = paymentScheduleNumber;
    return this;
  }

   /**
   * Number of the payment schedule. 
   * @return paymentScheduleNumber
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Number of the payment schedule. ")

  public String getPaymentScheduleNumber() {
    return paymentScheduleNumber;
  }


  public void setPaymentScheduleNumber(String paymentScheduleNumber) {
    
    
    
    this.paymentScheduleNumber = paymentScheduleNumber;
  }


  public GETPaymentScheduleResponseAllOf period(String period) {
    
    
    
    
    this.period = period;
    return this;
  }

   /**
   * For recurring payment schedule only. The period of payment generation. Available values include: &#x60;Monthly&#x60;, &#x60;Weekly&#x60;, &#x60;BiWeekly&#x60;.  Return &#x60;null&#x60; for custom payment schedules. 
   * @return period
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "For recurring payment schedule only. The period of payment generation. Available values include: `Monthly`, `Weekly`, `BiWeekly`.  Return `null` for custom payment schedules. ")

  public String getPeriod() {
    return period;
  }


  public void setPeriod(String period) {
    
    
    
    this.period = period;
  }


  public GETPaymentScheduleResponseAllOf prepayment(Boolean prepayment) {
    
    
    
    
    this.prepayment = prepayment;
    return this;
  }

   /**
   * Indicates whether the payments created by the payment schedule are used as a reserved payment. This field is available only if the prepaid cash drawdown permission is enabled. See [Prepaid Cash with Drawdown](https://knowledgecenter.zuora.com/Zuora_Billing/Billing_and_Invoicing/JA_Advanced_Consumption_Billing/Prepaid_Cash_with_Drawdown) for more information. 
   * @return prepayment
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Indicates whether the payments created by the payment schedule are used as a reserved payment. This field is available only if the prepaid cash drawdown permission is enabled. See [Prepaid Cash with Drawdown](https://knowledgecenter.zuora.com/Zuora_Billing/Billing_and_Invoicing/JA_Advanced_Consumption_Billing/Prepaid_Cash_with_Drawdown) for more information. ")

  public Boolean getPrepayment() {
    return prepayment;
  }


  public void setPrepayment(Boolean prepayment) {
    
    
    
    this.prepayment = prepayment;
  }


  public GETPaymentScheduleResponseAllOf recentPaymentDate(LocalDate recentPaymentDate) {
    
    
    
    
    this.recentPaymentDate = recentPaymentDate;
    return this;
  }

   /**
   * The date the last payment was processed. 
   * @return recentPaymentDate
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The date the last payment was processed. ")

  public LocalDate getRecentPaymentDate() {
    return recentPaymentDate;
  }


  public void setRecentPaymentDate(LocalDate recentPaymentDate) {
    
    
    
    this.recentPaymentDate = recentPaymentDate;
  }


  public GETPaymentScheduleResponseAllOf runHour(Integer runHour) {
    
    
    
    
    this.runHour = runHour;
    return this;
  }

   /**
   * [0,1,2,~,22,23]  At which hour in the day in the tenant’s timezone this payment will be collected.  Return &#x60;0&#x60; for custom payment schedules. 
   * @return runHour
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "[0,1,2,~,22,23]  At which hour in the day in the tenant’s timezone this payment will be collected.  Return `0` for custom payment schedules. ")

  public Integer getRunHour() {
    return runHour;
  }


  public void setRunHour(Integer runHour) {
    
    
    
    this.runHour = runHour;
  }


  public GETPaymentScheduleResponseAllOf standalone(Boolean standalone) {
    
    
    
    
    this.standalone = standalone;
    return this;
  }

   /**
   * Indicates if the payments that the payment schedule created are standalone payments. 
   * @return standalone
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Indicates if the payments that the payment schedule created are standalone payments. ")

  public Boolean getStandalone() {
    return standalone;
  }


  public void setStandalone(Boolean standalone) {
    
    
    
    this.standalone = standalone;
  }


  public GETPaymentScheduleResponseAllOf startDate(LocalDate startDate) {
    
    
    
    
    this.startDate = startDate;
    return this;
  }

   /**
   * The date when the first payment of this payment schedule is proccessed. 
   * @return startDate
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The date when the first payment of this payment schedule is proccessed. ")

  public LocalDate getStartDate() {
    return startDate;
  }


  public void setStartDate(LocalDate startDate) {
    
    
    
    this.startDate = startDate;
  }


  public GETPaymentScheduleResponseAllOf status(StatusEnum status) {
    
    
    
    
    this.status = status;
    return this;
  }

   /**
   * The status of the payment schedule.  - Active: There is still payment schedule item to process. - Canceled: After a payment schedule is canceled by the user, the schedule is marked as &#x60;Canceled&#x60;. - Completed: After all payment schedule items are processed, the schedule is marked as &#x60;Completed&#x60;. 
   * @return status
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The status of the payment schedule.  - Active: There is still payment schedule item to process. - Canceled: After a payment schedule is canceled by the user, the schedule is marked as `Canceled`. - Completed: After all payment schedule items are processed, the schedule is marked as `Completed`. ")

  public StatusEnum getStatus() {
    return status;
  }


  public void setStatus(StatusEnum status) {
    
    
    
    this.status = status;
  }


  public GETPaymentScheduleResponseAllOf success(Boolean success) {
    
    
    
    
    this.success = success;
    return this;
  }

   /**
   * Returns &#x60;true&#x60; if the request was processed successfully.         
   * @return success
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Returns `true` if the request was processed successfully.         ")

  public Boolean getSuccess() {
    return success;
  }


  public void setSuccess(Boolean success) {
    
    
    
    this.success = success;
  }


  public GETPaymentScheduleResponseAllOf totalAmount(Double totalAmount) {
    
    
    
    
    this.totalAmount = totalAmount;
    return this;
  }

  public GETPaymentScheduleResponseAllOf totalAmount(Integer totalAmount) {
    
    
    
    
    this.totalAmount = totalAmount.doubleValue();
    return this;
  }

   /**
   * The total amount that will be collected by the payment schedule. 
   * @return totalAmount
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The total amount that will be collected by the payment schedule. ")

  public Double getTotalAmount() {
    return totalAmount;
  }


  public void setTotalAmount(Double totalAmount) {
    
    
    
    this.totalAmount = totalAmount;
  }


  public GETPaymentScheduleResponseAllOf totalPaymentsErrored(Integer totalPaymentsErrored) {
    
    
    
    
    this.totalPaymentsErrored = totalPaymentsErrored;
    return this;
  }

   /**
   * The number of errored payments. 
   * @return totalPaymentsErrored
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The number of errored payments. ")

  public Integer getTotalPaymentsErrored() {
    return totalPaymentsErrored;
  }


  public void setTotalPaymentsErrored(Integer totalPaymentsErrored) {
    
    
    
    this.totalPaymentsErrored = totalPaymentsErrored;
  }


  public GETPaymentScheduleResponseAllOf totalPaymentsProcessed(Integer totalPaymentsProcessed) {
    
    
    
    
    this.totalPaymentsProcessed = totalPaymentsProcessed;
    return this;
  }

   /**
   * The number of processed payments. 
   * @return totalPaymentsProcessed
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The number of processed payments. ")

  public Integer getTotalPaymentsProcessed() {
    return totalPaymentsProcessed;
  }


  public void setTotalPaymentsProcessed(Integer totalPaymentsProcessed) {
    
    
    
    this.totalPaymentsProcessed = totalPaymentsProcessed;
  }


  public GETPaymentScheduleResponseAllOf updatedById(String updatedById) {
    
    
    
    
    this.updatedById = updatedById;
    return this;
  }

   /**
   * The ID of the user who last updated this payment schedule. 
   * @return updatedById
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The ID of the user who last updated this payment schedule. ")

  public String getUpdatedById() {
    return updatedById;
  }


  public void setUpdatedById(String updatedById) {
    
    
    
    this.updatedById = updatedById;
  }


  public GETPaymentScheduleResponseAllOf updatedDate(LocalDate updatedDate) {
    
    
    
    
    this.updatedDate = updatedDate;
    return this;
  }

   /**
   * The date and time the payment schedule is last updated. 
   * @return updatedDate
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The date and time the payment schedule is last updated. ")

  public LocalDate getUpdatedDate() {
    return updatedDate;
  }


  public void setUpdatedDate(LocalDate updatedDate) {
    
    
    
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
   * @return the GETPaymentScheduleResponseAllOf instance itself
   */
  public GETPaymentScheduleResponseAllOf putAdditionalProperty(String key, Object value) {
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
    GETPaymentScheduleResponseAllOf geTPaymentScheduleResponseAllOf = (GETPaymentScheduleResponseAllOf) o;
    return Objects.equals(this.description, geTPaymentScheduleResponseAllOf.description) &&
        Objects.equals(this.accountId, geTPaymentScheduleResponseAllOf.accountId) &&
        Objects.equals(this.accountNumber, geTPaymentScheduleResponseAllOf.accountNumber) &&
        Objects.equals(this.billingDocument, geTPaymentScheduleResponseAllOf.billingDocument) &&
        Objects.equals(this.createdById, geTPaymentScheduleResponseAllOf.createdById) &&
        Objects.equals(this.createdDate, geTPaymentScheduleResponseAllOf.createdDate) &&
        Objects.equals(this.id, geTPaymentScheduleResponseAllOf.id) &&
        Objects.equals(this.isCustom, geTPaymentScheduleResponseAllOf.isCustom) &&
        Objects.equals(this.items, geTPaymentScheduleResponseAllOf.items) &&
        Objects.equals(this.nextPaymentDate, geTPaymentScheduleResponseAllOf.nextPaymentDate) &&
        Objects.equals(this.occurrences, geTPaymentScheduleResponseAllOf.occurrences) &&
        Objects.equals(this.paymentOption, geTPaymentScheduleResponseAllOf.paymentOption) &&
        Objects.equals(this.paymentScheduleNumber, geTPaymentScheduleResponseAllOf.paymentScheduleNumber) &&
        Objects.equals(this.period, geTPaymentScheduleResponseAllOf.period) &&
        Objects.equals(this.prepayment, geTPaymentScheduleResponseAllOf.prepayment) &&
        Objects.equals(this.recentPaymentDate, geTPaymentScheduleResponseAllOf.recentPaymentDate) &&
        Objects.equals(this.runHour, geTPaymentScheduleResponseAllOf.runHour) &&
        Objects.equals(this.standalone, geTPaymentScheduleResponseAllOf.standalone) &&
        Objects.equals(this.startDate, geTPaymentScheduleResponseAllOf.startDate) &&
        Objects.equals(this.status, geTPaymentScheduleResponseAllOf.status) &&
        Objects.equals(this.success, geTPaymentScheduleResponseAllOf.success) &&
        Objects.equals(this.totalAmount, geTPaymentScheduleResponseAllOf.totalAmount) &&
        Objects.equals(this.totalPaymentsErrored, geTPaymentScheduleResponseAllOf.totalPaymentsErrored) &&
        Objects.equals(this.totalPaymentsProcessed, geTPaymentScheduleResponseAllOf.totalPaymentsProcessed) &&
        Objects.equals(this.updatedById, geTPaymentScheduleResponseAllOf.updatedById) &&
        Objects.equals(this.updatedDate, geTPaymentScheduleResponseAllOf.updatedDate)&&
        Objects.equals(this.additionalProperties, geTPaymentScheduleResponseAllOf.additionalProperties);
  }

  @Override
  public int hashCode() {
    return Objects.hash(description, accountId, accountNumber, billingDocument, createdById, createdDate, id, isCustom, items, nextPaymentDate, occurrences, paymentOption, paymentScheduleNumber, period, prepayment, recentPaymentDate, runHour, standalone, startDate, status, success, totalAmount, totalPaymentsErrored, totalPaymentsProcessed, updatedById, updatedDate, additionalProperties);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GETPaymentScheduleResponseAllOf {\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    accountId: ").append(toIndentedString(accountId)).append("\n");
    sb.append("    accountNumber: ").append(toIndentedString(accountNumber)).append("\n");
    sb.append("    billingDocument: ").append(toIndentedString(billingDocument)).append("\n");
    sb.append("    createdById: ").append(toIndentedString(createdById)).append("\n");
    sb.append("    createdDate: ").append(toIndentedString(createdDate)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    isCustom: ").append(toIndentedString(isCustom)).append("\n");
    sb.append("    items: ").append(toIndentedString(items)).append("\n");
    sb.append("    nextPaymentDate: ").append(toIndentedString(nextPaymentDate)).append("\n");
    sb.append("    occurrences: ").append(toIndentedString(occurrences)).append("\n");
    sb.append("    paymentOption: ").append(toIndentedString(paymentOption)).append("\n");
    sb.append("    paymentScheduleNumber: ").append(toIndentedString(paymentScheduleNumber)).append("\n");
    sb.append("    period: ").append(toIndentedString(period)).append("\n");
    sb.append("    prepayment: ").append(toIndentedString(prepayment)).append("\n");
    sb.append("    recentPaymentDate: ").append(toIndentedString(recentPaymentDate)).append("\n");
    sb.append("    runHour: ").append(toIndentedString(runHour)).append("\n");
    sb.append("    standalone: ").append(toIndentedString(standalone)).append("\n");
    sb.append("    startDate: ").append(toIndentedString(startDate)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    success: ").append(toIndentedString(success)).append("\n");
    sb.append("    totalAmount: ").append(toIndentedString(totalAmount)).append("\n");
    sb.append("    totalPaymentsErrored: ").append(toIndentedString(totalPaymentsErrored)).append("\n");
    sb.append("    totalPaymentsProcessed: ").append(toIndentedString(totalPaymentsProcessed)).append("\n");
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
    openapiFields.add("accountId");
    openapiFields.add("accountNumber");
    openapiFields.add("billingDocument");
    openapiFields.add("createdById");
    openapiFields.add("createdDate");
    openapiFields.add("id");
    openapiFields.add("isCustom");
    openapiFields.add("items");
    openapiFields.add("nextPaymentDate");
    openapiFields.add("occurrences");
    openapiFields.add("paymentOption");
    openapiFields.add("paymentScheduleNumber");
    openapiFields.add("period");
    openapiFields.add("prepayment");
    openapiFields.add("recentPaymentDate");
    openapiFields.add("runHour");
    openapiFields.add("standalone");
    openapiFields.add("startDate");
    openapiFields.add("status");
    openapiFields.add("success");
    openapiFields.add("totalAmount");
    openapiFields.add("totalPaymentsErrored");
    openapiFields.add("totalPaymentsProcessed");
    openapiFields.add("updatedById");
    openapiFields.add("updatedDate");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
  }

 /**
  * Validates the JSON Object and throws an exception if issues found
  *
  * @param jsonObj JSON Object
  * @throws IOException if the JSON Object is invalid with respect to GETPaymentScheduleResponseAllOf
  */
  public static void validateJsonObject(JsonObject jsonObj) throws IOException {
      if (jsonObj == null) {
        if (!GETPaymentScheduleResponseAllOf.openapiRequiredFields.isEmpty()) { // has required fields but JSON object is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in GETPaymentScheduleResponseAllOf is not found in the empty JSON string", GETPaymentScheduleResponseAllOf.openapiRequiredFields.toString()));
        }
      }
      if ((jsonObj.get("description") != null && !jsonObj.get("description").isJsonNull()) && !jsonObj.get("description").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `description` to be a primitive type in the JSON string but got `%s`", jsonObj.get("description").toString()));
      }
      if ((jsonObj.get("accountId") != null && !jsonObj.get("accountId").isJsonNull()) && !jsonObj.get("accountId").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `accountId` to be a primitive type in the JSON string but got `%s`", jsonObj.get("accountId").toString()));
      }
      if ((jsonObj.get("accountNumber") != null && !jsonObj.get("accountNumber").isJsonNull()) && !jsonObj.get("accountNumber").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `accountNumber` to be a primitive type in the JSON string but got `%s`", jsonObj.get("accountNumber").toString()));
      }
      // validate the optional field `billingDocument`
      if (jsonObj.get("billingDocument") != null && !jsonObj.get("billingDocument").isJsonNull()) {
        GETPaymentScheduleItemResponseAllOfBillingDocument.validateJsonObject(jsonObj.getAsJsonObject("billingDocument"));
      }
      if ((jsonObj.get("createdById") != null && !jsonObj.get("createdById").isJsonNull()) && !jsonObj.get("createdById").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `createdById` to be a primitive type in the JSON string but got `%s`", jsonObj.get("createdById").toString()));
      }
      if ((jsonObj.get("id") != null && !jsonObj.get("id").isJsonNull()) && !jsonObj.get("id").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `id` to be a primitive type in the JSON string but got `%s`", jsonObj.get("id").toString()));
      }
      if (jsonObj.get("items") != null && !jsonObj.get("items").isJsonNull()) {
        JsonArray jsonArrayitems = jsonObj.getAsJsonArray("items");
        if (jsonArrayitems != null) {
          // ensure the json data is an array
          if (!jsonObj.get("items").isJsonArray()) {
            throw new IllegalArgumentException(String.format("Expected the field `items` to be an array in the JSON string but got `%s`", jsonObj.get("items").toString()));
          }

          // validate the optional field `items` (array)
          for (int i = 0; i < jsonArrayitems.size(); i++) {
            PaymentScheduleItemCommonResponse.validateJsonObject(jsonArrayitems.get(i).getAsJsonObject());
          };
        }
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
      if ((jsonObj.get("paymentScheduleNumber") != null && !jsonObj.get("paymentScheduleNumber").isJsonNull()) && !jsonObj.get("paymentScheduleNumber").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `paymentScheduleNumber` to be a primitive type in the JSON string but got `%s`", jsonObj.get("paymentScheduleNumber").toString()));
      }
      if ((jsonObj.get("period") != null && !jsonObj.get("period").isJsonNull()) && !jsonObj.get("period").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `period` to be a primitive type in the JSON string but got `%s`", jsonObj.get("period").toString()));
      }
      if ((jsonObj.get("status") != null && !jsonObj.get("status").isJsonNull()) && !jsonObj.get("status").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `status` to be a primitive type in the JSON string but got `%s`", jsonObj.get("status").toString()));
      }
      if ((jsonObj.get("updatedById") != null && !jsonObj.get("updatedById").isJsonNull()) && !jsonObj.get("updatedById").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `updatedById` to be a primitive type in the JSON string but got `%s`", jsonObj.get("updatedById").toString()));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!GETPaymentScheduleResponseAllOf.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'GETPaymentScheduleResponseAllOf' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<GETPaymentScheduleResponseAllOf> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(GETPaymentScheduleResponseAllOf.class));

       return (TypeAdapter<T>) new TypeAdapter<GETPaymentScheduleResponseAllOf>() {
           @Override
           public void write(JsonWriter out, GETPaymentScheduleResponseAllOf value) throws IOException {
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
           public GETPaymentScheduleResponseAllOf read(JsonReader in) throws IOException {
             JsonObject jsonObj = elementAdapter.read(in).getAsJsonObject();
             validateJsonObject(jsonObj);
             // store additional fields in the deserialized instance
             GETPaymentScheduleResponseAllOf instance = thisAdapter.fromJsonTree(jsonObj);
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
  * Create an instance of GETPaymentScheduleResponseAllOf given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of GETPaymentScheduleResponseAllOf
  * @throws IOException if the JSON string is invalid with respect to GETPaymentScheduleResponseAllOf
  */
  public static GETPaymentScheduleResponseAllOf fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, GETPaymentScheduleResponseAllOf.class);
  }

 /**
  * Convert an instance of GETPaymentScheduleResponseAllOf to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

