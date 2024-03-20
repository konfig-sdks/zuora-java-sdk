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
import com.konfigthis.client.model.FinanceInformation;
import com.konfigthis.client.model.GETProductDiscountApplyDetailsType;
import com.konfigthis.client.model.GETProductRatePlanChargeDeliverySchedule;
import com.konfigthis.client.model.GETProductRatePlanChargePricingType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
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
 * GETProductRatePlanChargeTypeAllOf
 */@javax.annotation.Generated(value = "Generated by https://konfigthis.com")
public class GETProductRatePlanChargeTypeAllOf {
  public static final String SERIALIZED_NAME_DESCRIPTION = "description";
  @SerializedName(SERIALIZED_NAME_DESCRIPTION)
  private String description;

  public static final String SERIALIZED_NAME_APPLY_DISCOUNT_TO = "applyDiscountTo";
  @SerializedName(SERIALIZED_NAME_APPLY_DISCOUNT_TO)
  private String applyDiscountTo;

  public static final String SERIALIZED_NAME_BILLING_DAY = "billingDay";
  @SerializedName(SERIALIZED_NAME_BILLING_DAY)
  private String billingDay;

  public static final String SERIALIZED_NAME_BILLING_PERIOD = "billingPeriod";
  @SerializedName(SERIALIZED_NAME_BILLING_PERIOD)
  private String billingPeriod;

  public static final String SERIALIZED_NAME_BILLING_PERIOD_ALIGNMENT = "billingPeriodAlignment";
  @SerializedName(SERIALIZED_NAME_BILLING_PERIOD_ALIGNMENT)
  private String billingPeriodAlignment;

  public static final String SERIALIZED_NAME_BILLING_TIMING = "billingTiming";
  @SerializedName(SERIALIZED_NAME_BILLING_TIMING)
  private String billingTiming;

  public static final String SERIALIZED_NAME_CHARGE_MODEL_CONFIGURATIONS = "chargeModelConfigurations";
  @SerializedName(SERIALIZED_NAME_CHARGE_MODEL_CONFIGURATIONS)
  private Object chargeModelConfigurations;

  /**
   * **Note**: This field is only available if you have the [Prepaid with Drawdown](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/J_Billing_Operations/Prepaid_with_Drawdown) feature enabled.  The way to calculate credit. See [Credit Option](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/J_Billing_Operations/Prepaid_with_Drawdown/Create_prepayment_charge#Credit_Option) for more information.  
   */
  @JsonAdapter(CreditOptionEnum.Adapter.class)
 public enum CreditOptionEnum {
    TIMEBASED("TimeBased"),
    
    CONSUMPTIONBASED("ConsumptionBased"),
    
    FULLCREDITBACK("FullCreditBack");

    private String value;

    CreditOptionEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static CreditOptionEnum fromValue(String value) {
      for (CreditOptionEnum b : CreditOptionEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<CreditOptionEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final CreditOptionEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public CreditOptionEnum read(final JsonReader jsonReader) throws IOException {
        String value =  jsonReader.nextString();
        return CreditOptionEnum.fromValue(value);
      }
    }
  }

  public static final String SERIALIZED_NAME_CREDIT_OPTION = "creditOption";
  @SerializedName(SERIALIZED_NAME_CREDIT_OPTION)
  private CreditOptionEnum creditOption;

  public static final String SERIALIZED_NAME_DEFAULT_QUANTITY = "defaultQuantity";
  @SerializedName(SERIALIZED_NAME_DEFAULT_QUANTITY)
  private BigDecimal defaultQuantity;

  public static final String SERIALIZED_NAME_DELIVERY_SCHEDULE = "deliverySchedule";
  @SerializedName(SERIALIZED_NAME_DELIVERY_SCHEDULE)
  private GETProductRatePlanChargeDeliverySchedule deliverySchedule;

  public static final String SERIALIZED_NAME_DISCOUNT_CLASS = "discountClass";
  @SerializedName(SERIALIZED_NAME_DISCOUNT_CLASS)
  private String discountClass;

  public static final String SERIALIZED_NAME_DISCOUNT_LEVEL = "discountLevel";
  @SerializedName(SERIALIZED_NAME_DISCOUNT_LEVEL)
  private String discountLevel;

  public static final String SERIALIZED_NAME_DRAWDOWN_RATE = "drawdownRate";
  @SerializedName(SERIALIZED_NAME_DRAWDOWN_RATE)
  private Double drawdownRate;

  public static final String SERIALIZED_NAME_DRAWDOWN_UOM = "drawdownUom";
  @SerializedName(SERIALIZED_NAME_DRAWDOWN_UOM)
  private String drawdownUom;

  public static final String SERIALIZED_NAME_END_DATE_CONDITION = "endDateCondition";
  @SerializedName(SERIALIZED_NAME_END_DATE_CONDITION)
  private String endDateCondition;

  public static final String SERIALIZED_NAME_EXCLUDE_ITEM_BILLING_FROM_REVENUE_ACCOUNTING = "excludeItemBillingFromRevenueAccounting";
  @SerializedName(SERIALIZED_NAME_EXCLUDE_ITEM_BILLING_FROM_REVENUE_ACCOUNTING)
  private Boolean excludeItemBillingFromRevenueAccounting;

  public static final String SERIALIZED_NAME_EXCLUDE_ITEM_BOOKING_FROM_REVENUE_ACCOUNTING = "excludeItemBookingFromRevenueAccounting";
  @SerializedName(SERIALIZED_NAME_EXCLUDE_ITEM_BOOKING_FROM_REVENUE_ACCOUNTING)
  private Boolean excludeItemBookingFromRevenueAccounting;

  public static final String SERIALIZED_NAME_FINANCE_INFORMATION = "financeInformation";
  @SerializedName(SERIALIZED_NAME_FINANCE_INFORMATION)
  private FinanceInformation financeInformation;

  public static final String SERIALIZED_NAME_FORMULA = "formula";
  @SerializedName(SERIALIZED_NAME_FORMULA)
  private String formula;

  public static final String SERIALIZED_NAME_ID = "id";
  @SerializedName(SERIALIZED_NAME_ID)
  private String id;

  public static final String SERIALIZED_NAME_INCLUDED_UNITS = "includedUnits";
  @SerializedName(SERIALIZED_NAME_INCLUDED_UNITS)
  private BigDecimal includedUnits;

  public static final String SERIALIZED_NAME_IS_ALLOCATION_ELIGIBLE = "isAllocationEligible";
  @SerializedName(SERIALIZED_NAME_IS_ALLOCATION_ELIGIBLE)
  private Boolean isAllocationEligible;

  public static final String SERIALIZED_NAME_IS_PREPAID = "isPrepaid";
  @SerializedName(SERIALIZED_NAME_IS_PREPAID)
  private Boolean isPrepaid;

  public static final String SERIALIZED_NAME_IS_ROLLOVER = "isRollover";
  @SerializedName(SERIALIZED_NAME_IS_ROLLOVER)
  private Boolean isRollover;

  public static final String SERIALIZED_NAME_IS_STACKED_DISCOUNT = "isStackedDiscount";
  @SerializedName(SERIALIZED_NAME_IS_STACKED_DISCOUNT)
  private Boolean isStackedDiscount;

  public static final String SERIALIZED_NAME_IS_UNBILLED = "isUnbilled";
  @SerializedName(SERIALIZED_NAME_IS_UNBILLED)
  private Boolean isUnbilled;

  /**
   * The list price base for the product rate plan charge.  This field is only applicable for recurring charges. 
   */
  @JsonAdapter(ListPriceBaseEnum.Adapter.class)
 public enum ListPriceBaseEnum {
    BILLING_PERIOD("Per_Billing_Period"),
    
    MONTH("Per_Month"),
    
    WEEK("Per_Week"),
    
    YEAR("Per_Year"),
    
    SPECIFIC_MONTHS("Per_Specific_Months");

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

  public static final String SERIALIZED_NAME_MAX_QUANTITY = "maxQuantity";
  @SerializedName(SERIALIZED_NAME_MAX_QUANTITY)
  private BigDecimal maxQuantity;

  public static final String SERIALIZED_NAME_MIN_QUANTITY = "minQuantity";
  @SerializedName(SERIALIZED_NAME_MIN_QUANTITY)
  private BigDecimal minQuantity;

  public static final String SERIALIZED_NAME_MODEL = "model";
  @SerializedName(SERIALIZED_NAME_MODEL)
  private String model;

  public static final String SERIALIZED_NAME_NAME = "name";
  @SerializedName(SERIALIZED_NAME_NAME)
  private String name;

  public static final String SERIALIZED_NAME_NUMBER_OF_PERIODS = "numberOfPeriods";
  @SerializedName(SERIALIZED_NAME_NUMBER_OF_PERIODS)
  private Long numberOfPeriods;

  public static final String SERIALIZED_NAME_OVERAGE_CALCULATION_OPTION = "overageCalculationOption";
  @SerializedName(SERIALIZED_NAME_OVERAGE_CALCULATION_OPTION)
  private String overageCalculationOption;

  public static final String SERIALIZED_NAME_OVERAGE_UNUSED_UNITS_CREDIT_OPTION = "overageUnusedUnitsCreditOption";
  @SerializedName(SERIALIZED_NAME_OVERAGE_UNUSED_UNITS_CREDIT_OPTION)
  private String overageUnusedUnitsCreditOption;

  /**
   * **Note**: This field is only available if you have the [Prepaid with Drawdown](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/J_Billing_Operations/Prepaid_with_Drawdown) feature enabled.  The type of this charge. It is either a prepayment (topup) charge or a drawdown charge.  
   */
  @JsonAdapter(PrepaidOperationTypeEnum.Adapter.class)
 public enum PrepaidOperationTypeEnum {
    TOPUP("topup"),
    
    DRAWDOWN("drawdown"),
    
    NULL("null");

    private String value;

    PrepaidOperationTypeEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static PrepaidOperationTypeEnum fromValue(String value) {
      for (PrepaidOperationTypeEnum b : PrepaidOperationTypeEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      return null;
    }

    public static class Adapter extends TypeAdapter<PrepaidOperationTypeEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final PrepaidOperationTypeEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public PrepaidOperationTypeEnum read(final JsonReader jsonReader) throws IOException {
        String value =  jsonReader.nextString();
        return PrepaidOperationTypeEnum.fromValue(value);
      }
    }
  }

  public static final String SERIALIZED_NAME_PREPAID_OPERATION_TYPE = "prepaidOperationType";
  @SerializedName(SERIALIZED_NAME_PREPAID_OPERATION_TYPE)
  private PrepaidOperationTypeEnum prepaidOperationType;

  public static final String SERIALIZED_NAME_PREPAID_QUANTITY = "prepaidQuantity";
  @SerializedName(SERIALIZED_NAME_PREPAID_QUANTITY)
  private Double prepaidQuantity;

  public static final String SERIALIZED_NAME_PREPAID_TOTAL_QUANTITY = "prepaidTotalQuantity";
  @SerializedName(SERIALIZED_NAME_PREPAID_TOTAL_QUANTITY)
  private Double prepaidTotalQuantity;

  public static final String SERIALIZED_NAME_PREPAID_UOM = "prepaidUom";
  @SerializedName(SERIALIZED_NAME_PREPAID_UOM)
  private String prepaidUom;

  public static final String SERIALIZED_NAME_PREPAY_PERIODS = "prepayPeriods";
  @SerializedName(SERIALIZED_NAME_PREPAY_PERIODS)
  private Long prepayPeriods;

  public static final String SERIALIZED_NAME_PRICE_CHANGE_OPTION = "priceChangeOption";
  @SerializedName(SERIALIZED_NAME_PRICE_CHANGE_OPTION)
  private String priceChangeOption;

  public static final String SERIALIZED_NAME_PRICE_INCREASE_PERCENTAGE = "priceIncreasePercentage";
  @SerializedName(SERIALIZED_NAME_PRICE_INCREASE_PERCENTAGE)
  private BigDecimal priceIncreasePercentage;

  public static final String SERIALIZED_NAME_PRICING = "pricing";
  @SerializedName(SERIALIZED_NAME_PRICING)
  private List<GETProductRatePlanChargePricingType> pricing = null;

  public static final String SERIALIZED_NAME_PRICING_SUMMARY = "pricingSummary";
  @SerializedName(SERIALIZED_NAME_PRICING_SUMMARY)
  private List<String> pricingSummary = null;

  public static final String SERIALIZED_NAME_PRODUCT_CHARGE_DEFINITIONS = "productChargeDefinitions";
  @SerializedName(SERIALIZED_NAME_PRODUCT_CHARGE_DEFINITIONS)
  private String productChargeDefinitions;

  public static final String SERIALIZED_NAME_PRODUCT_DISCOUNT_APPLY_DETAILS = "productDiscountApplyDetails";
  @SerializedName(SERIALIZED_NAME_PRODUCT_DISCOUNT_APPLY_DETAILS)
  private List<GETProductDiscountApplyDetailsType> productDiscountApplyDetails = null;

  public static final String SERIALIZED_NAME_PRODUCT_RATE_PLAN_CHARGE_NUMBER = "productRatePlanChargeNumber";
  @SerializedName(SERIALIZED_NAME_PRODUCT_RATE_PLAN_CHARGE_NUMBER)
  private String productRatePlanChargeNumber;

  public static final String SERIALIZED_NAME_RATING_GROUP = "ratingGroup";
  @SerializedName(SERIALIZED_NAME_RATING_GROUP)
  private String ratingGroup;

  public static final String SERIALIZED_NAME_REV_REC_CODE = "revRecCode";
  @SerializedName(SERIALIZED_NAME_REV_REC_CODE)
  private String revRecCode;

  /**
   * Specifies when revenue recognition begins. 
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

  public static final String SERIALIZED_NAME_REVENUE_RECOGNITION_RULE_NAME = "revenueRecognitionRuleName";
  @SerializedName(SERIALIZED_NAME_REVENUE_RECOGNITION_RULE_NAME)
  private String revenueRecognitionRuleName;

  /**
   * **Note**: This field is only available if you have the [Prepaid with Drawdown](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/J_Billing_Operations/Prepaid_with_Drawdown) feature enabled.  This field defines the priority of rollover, which is either first or last. 
   */
  @JsonAdapter(RolloverApplyEnum.Adapter.class)
 public enum RolloverApplyEnum {
    APPLYFIRST("ApplyFirst"),
    
    APPLYLAST("ApplyLast");

    private String value;

    RolloverApplyEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static RolloverApplyEnum fromValue(String value) {
      for (RolloverApplyEnum b : RolloverApplyEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<RolloverApplyEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final RolloverApplyEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public RolloverApplyEnum read(final JsonReader jsonReader) throws IOException {
        String value =  jsonReader.nextString();
        return RolloverApplyEnum.fromValue(value);
      }
    }
  }

  public static final String SERIALIZED_NAME_ROLLOVER_APPLY = "rolloverApply";
  @SerializedName(SERIALIZED_NAME_ROLLOVER_APPLY)
  private RolloverApplyEnum rolloverApply;

  public static final String SERIALIZED_NAME_ROLLOVER_PERIOD_LENGTH = "rolloverPeriodLength";
  @SerializedName(SERIALIZED_NAME_ROLLOVER_PERIOD_LENGTH)
  private Integer rolloverPeriodLength;

  public static final String SERIALIZED_NAME_ROLLOVER_PERIODS = "rolloverPeriods";
  @SerializedName(SERIALIZED_NAME_ROLLOVER_PERIODS)
  private Double rolloverPeriods;

  public static final String SERIALIZED_NAME_SMOOTHING_MODEL = "smoothingModel";
  @SerializedName(SERIALIZED_NAME_SMOOTHING_MODEL)
  private String smoothingModel;

  public static final String SERIALIZED_NAME_SPECIFIC_BILLING_PERIOD = "specificBillingPeriod";
  @SerializedName(SERIALIZED_NAME_SPECIFIC_BILLING_PERIOD)
  private Long specificBillingPeriod;

  public static final String SERIALIZED_NAME_SPECIFIC_LIST_PRICE_BASE = "specificListPriceBase";
  @SerializedName(SERIALIZED_NAME_SPECIFIC_LIST_PRICE_BASE)
  private Integer specificListPriceBase;

  public static final String SERIALIZED_NAME_TAX_CODE = "taxCode";
  @SerializedName(SERIALIZED_NAME_TAX_CODE)
  private String taxCode;

  /**
   * Specifies how to define taxation for the charge; used by Zuora Tax. 
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

  public static final String SERIALIZED_NAME_TRIGGER_EVENT = "triggerEvent";
  @SerializedName(SERIALIZED_NAME_TRIGGER_EVENT)
  private String triggerEvent;

  public static final String SERIALIZED_NAME_TYPE = "type";
  @SerializedName(SERIALIZED_NAME_TYPE)
  private String type;

  public static final String SERIALIZED_NAME_UOM = "uom";
  @SerializedName(SERIALIZED_NAME_UOM)
  private String uom;

  public static final String SERIALIZED_NAME_UP_TO_PERIODS = "upToPeriods";
  @SerializedName(SERIALIZED_NAME_UP_TO_PERIODS)
  private Long upToPeriods;

  /**
   * The period type used to define when the charge ends. 
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

  public static final String SERIALIZED_NAME_USAGE_RECORD_RATING_OPTION = "usageRecordRatingOption";
  @SerializedName(SERIALIZED_NAME_USAGE_RECORD_RATING_OPTION)
  private String usageRecordRatingOption;

  public static final String SERIALIZED_NAME_USE_DISCOUNT_SPECIFIC_ACCOUNTING_CODE = "useDiscountSpecificAccountingCode";
  @SerializedName(SERIALIZED_NAME_USE_DISCOUNT_SPECIFIC_ACCOUNTING_CODE)
  private Boolean useDiscountSpecificAccountingCode;

  public static final String SERIALIZED_NAME_USE_TENANT_DEFAULT_FOR_PRICE_CHANGE = "useTenantDefaultForPriceChange";
  @SerializedName(SERIALIZED_NAME_USE_TENANT_DEFAULT_FOR_PRICE_CHANGE)
  private Boolean useTenantDefaultForPriceChange;

  /**
   * **Note**: This field is only available if you have the [Prepaid with Drawdown](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/J_Billing_Operations/Prepaid_with_Drawdown) feature enabled.  The period in which the prepayment units are valid to use as defined in a [prepayment charge](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/J_Billing_Operations/Prepaid_with_Drawdown/Create_prepayment_charge). 
   */
  @JsonAdapter(ValidityPeriodTypeEnum.Adapter.class)
 public enum ValidityPeriodTypeEnum {
    SUBSCRIPTION_TERM("SUBSCRIPTION_TERM"),
    
    ANNUAL("ANNUAL"),
    
    SEMI_ANNUAL("SEMI_ANNUAL"),
    
    QUARTER("QUARTER"),
    
    MONTH("MONTH");

    private String value;

    ValidityPeriodTypeEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static ValidityPeriodTypeEnum fromValue(String value) {
      for (ValidityPeriodTypeEnum b : ValidityPeriodTypeEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<ValidityPeriodTypeEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final ValidityPeriodTypeEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public ValidityPeriodTypeEnum read(final JsonReader jsonReader) throws IOException {
        String value =  jsonReader.nextString();
        return ValidityPeriodTypeEnum.fromValue(value);
      }
    }
  }

  public static final String SERIALIZED_NAME_VALIDITY_PERIOD_TYPE = "validityPeriodType";
  @SerializedName(SERIALIZED_NAME_VALIDITY_PERIOD_TYPE)
  private ValidityPeriodTypeEnum validityPeriodType;

  public GETProductRatePlanChargeTypeAllOf() {
  }

  public GETProductRatePlanChargeTypeAllOf description(String description) {
    
    
    
    
    this.description = description;
    return this;
  }

   /**
   * Usually a brief line item summary of the Rate Plan Charge. 
   * @return description
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Usually a brief line item summary of the Rate Plan Charge. ")

  public String getDescription() {
    return description;
  }


  public void setDescription(String description) {
    
    
    
    this.description = description;
  }


  public GETProductRatePlanChargeTypeAllOf applyDiscountTo(String applyDiscountTo) {
    
    
    
    
    this.applyDiscountTo = applyDiscountTo;
    return this;
  }

   /**
   * Specifies where (to what charge type) the discount will be applied. These field values are case-sensitive.  Permissible values: - RECURRING - USAGE - ONETIMERECURRING - ONETIMEUSAGE - RECURRINGUSAGE - ONETIMERECURRINGUSAGE 
   * @return applyDiscountTo
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Specifies where (to what charge type) the discount will be applied. These field values are case-sensitive.  Permissible values: - RECURRING - USAGE - ONETIMERECURRING - ONETIMEUSAGE - RECURRINGUSAGE - ONETIMERECURRINGUSAGE ")

  public String getApplyDiscountTo() {
    return applyDiscountTo;
  }


  public void setApplyDiscountTo(String applyDiscountTo) {
    
    
    
    this.applyDiscountTo = applyDiscountTo;
  }


  public GETProductRatePlanChargeTypeAllOf billingDay(String billingDay) {
    
    
    
    
    this.billingDay = billingDay;
    return this;
  }

   /**
   * The bill cycle day (BCD) for the charge. The BCD determines which day of the month or week the customer is billed. The BCD value in the account can override the BCD in this object. 
   * @return billingDay
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The bill cycle day (BCD) for the charge. The BCD determines which day of the month or week the customer is billed. The BCD value in the account can override the BCD in this object. ")

  public String getBillingDay() {
    return billingDay;
  }


  public void setBillingDay(String billingDay) {
    
    
    
    this.billingDay = billingDay;
  }


  public GETProductRatePlanChargeTypeAllOf billingPeriod(String billingPeriod) {
    
    
    
    
    this.billingPeriod = billingPeriod;
    return this;
  }

   /**
   * The billing period for the charge. The start day of the billing period is also called the bill cycle day (BCD).  Values: - Month - Quarter - Annual - Semi_Annual - Specific Months - Week - Specific_Weeks 
   * @return billingPeriod
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The billing period for the charge. The start day of the billing period is also called the bill cycle day (BCD).  Values: - Month - Quarter - Annual - Semi_Annual - Specific Months - Week - Specific_Weeks ")

  public String getBillingPeriod() {
    return billingPeriod;
  }


  public void setBillingPeriod(String billingPeriod) {
    
    
    
    this.billingPeriod = billingPeriod;
  }


  public GETProductRatePlanChargeTypeAllOf billingPeriodAlignment(String billingPeriodAlignment) {
    
    
    
    
    this.billingPeriodAlignment = billingPeriodAlignment;
    return this;
  }

   /**
   * Aligns charges within the same subscription if multiple charges begin on different dates.  Possible values: - AlignToCharge - AlignToSubscriptionStart - AlignToTermStart 
   * @return billingPeriodAlignment
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Aligns charges within the same subscription if multiple charges begin on different dates.  Possible values: - AlignToCharge - AlignToSubscriptionStart - AlignToTermStart ")

  public String getBillingPeriodAlignment() {
    return billingPeriodAlignment;
  }


  public void setBillingPeriodAlignment(String billingPeriodAlignment) {
    
    
    
    this.billingPeriodAlignment = billingPeriodAlignment;
  }


  public GETProductRatePlanChargeTypeAllOf billingTiming(String billingTiming) {
    
    
    
    
    this.billingTiming = billingTiming;
    return this;
  }

   /**
   * The billing timing for the charge. You can choose to bill for charges in advance or in arrears.  Values: - In Advance - In Arrears  **Note:** This feature is in Limited Availability. If you wish to have access to the feature, submit a request at [Zuora Global Support](https://support.zuora.com).  
   * @return billingTiming
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The billing timing for the charge. You can choose to bill for charges in advance or in arrears.  Values: - In Advance - In Arrears  **Note:** This feature is in Limited Availability. If you wish to have access to the feature, submit a request at [Zuora Global Support](https://support.zuora.com).  ")

  public String getBillingTiming() {
    return billingTiming;
  }


  public void setBillingTiming(String billingTiming) {
    
    
    
    this.billingTiming = billingTiming;
  }


  public GETProductRatePlanChargeTypeAllOf chargeModelConfigurations(Object chargeModelConfigurations) {
    
    
    
    
    this.chargeModelConfigurations = chargeModelConfigurations;
    return this;
  }

   /**
   * This field is for Zuora Internal Use only. See the **pricing** field for the same information as this field.
   * @return chargeModelConfigurations
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "This field is for Zuora Internal Use only. See the **pricing** field for the same information as this field.")

  public Object getChargeModelConfigurations() {
    return chargeModelConfigurations;
  }


  public void setChargeModelConfigurations(Object chargeModelConfigurations) {
    
    
    
    this.chargeModelConfigurations = chargeModelConfigurations;
  }


  public GETProductRatePlanChargeTypeAllOf creditOption(CreditOptionEnum creditOption) {
    
    
    
    
    this.creditOption = creditOption;
    return this;
  }

   /**
   * **Note**: This field is only available if you have the [Prepaid with Drawdown](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/J_Billing_Operations/Prepaid_with_Drawdown) feature enabled.  The way to calculate credit. See [Credit Option](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/J_Billing_Operations/Prepaid_with_Drawdown/Create_prepayment_charge#Credit_Option) for more information.  
   * @return creditOption
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "**Note**: This field is only available if you have the [Prepaid with Drawdown](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/J_Billing_Operations/Prepaid_with_Drawdown) feature enabled.  The way to calculate credit. See [Credit Option](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/J_Billing_Operations/Prepaid_with_Drawdown/Create_prepayment_charge#Credit_Option) for more information.  ")

  public CreditOptionEnum getCreditOption() {
    return creditOption;
  }


  public void setCreditOption(CreditOptionEnum creditOption) {
    
    
    
    this.creditOption = creditOption;
  }


  public GETProductRatePlanChargeTypeAllOf defaultQuantity(BigDecimal defaultQuantity) {
    
    
    
    
    this.defaultQuantity = defaultQuantity;
    return this;
  }

   /**
   * The default quantity of units.  This field is required if you use a per-unit charge model. 
   * @return defaultQuantity
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The default quantity of units.  This field is required if you use a per-unit charge model. ")

  public BigDecimal getDefaultQuantity() {
    return defaultQuantity;
  }


  public void setDefaultQuantity(BigDecimal defaultQuantity) {
    
    
    
    this.defaultQuantity = defaultQuantity;
  }


  public GETProductRatePlanChargeTypeAllOf deliverySchedule(GETProductRatePlanChargeDeliverySchedule deliverySchedule) {
    
    
    
    
    this.deliverySchedule = deliverySchedule;
    return this;
  }

   /**
   * Get deliverySchedule
   * @return deliverySchedule
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public GETProductRatePlanChargeDeliverySchedule getDeliverySchedule() {
    return deliverySchedule;
  }


  public void setDeliverySchedule(GETProductRatePlanChargeDeliverySchedule deliverySchedule) {
    
    
    
    this.deliverySchedule = deliverySchedule;
  }


  public GETProductRatePlanChargeTypeAllOf discountClass(String discountClass) {
    
    
    
    
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


  public GETProductRatePlanChargeTypeAllOf discountLevel(String discountLevel) {
    
    
    
    
    this.discountLevel = discountLevel;
    return this;
  }

   /**
   * The level of the discount.   Values: - RatePlan - Subscription - Account 
   * @return discountLevel
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The level of the discount.   Values: - RatePlan - Subscription - Account ")

  public String getDiscountLevel() {
    return discountLevel;
  }


  public void setDiscountLevel(String discountLevel) {
    
    
    
    this.discountLevel = discountLevel;
  }


  public GETProductRatePlanChargeTypeAllOf drawdownRate(Double drawdownRate) {
    
    
    
    
    this.drawdownRate = drawdownRate;
    return this;
  }

  public GETProductRatePlanChargeTypeAllOf drawdownRate(Integer drawdownRate) {
    
    
    
    
    this.drawdownRate = drawdownRate.doubleValue();
    return this;
  }

   /**
   * **Note**: This field is only available if you have the [Prepaid with Drawdown](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/J_Billing_Operations/Prepaid_with_Drawdown) feature enabled.  The [conversion rate](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/J_Billing_Operations/Prepaid_with_Drawdown/Create_drawdown_charge#UOM_Conversion) between Usage UOM and Drawdown UOM for a [drawdown charge](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/J_Billing_Operations/Prepaid_with_Drawdown/Create_drawdown_charge). Must be a positive number (&gt;0). 
   * @return drawdownRate
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "**Note**: This field is only available if you have the [Prepaid with Drawdown](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/J_Billing_Operations/Prepaid_with_Drawdown) feature enabled.  The [conversion rate](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/J_Billing_Operations/Prepaid_with_Drawdown/Create_drawdown_charge#UOM_Conversion) between Usage UOM and Drawdown UOM for a [drawdown charge](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/J_Billing_Operations/Prepaid_with_Drawdown/Create_drawdown_charge). Must be a positive number (>0). ")

  public Double getDrawdownRate() {
    return drawdownRate;
  }


  public void setDrawdownRate(Double drawdownRate) {
    
    
    
    this.drawdownRate = drawdownRate;
  }


  public GETProductRatePlanChargeTypeAllOf drawdownUom(String drawdownUom) {
    
    
    
    
    this.drawdownUom = drawdownUom;
    return this;
  }

   /**
   * **Note**: This field is only available if you have the [Prepaid with Drawdown](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/J_Billing_Operations/Prepaid_with_Drawdown) feature enabled.  Unit of measurement for a [drawdown charge](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/J_Billing_Operations/Prepaid_with_Drawdown/Create_drawdown_charge). 
   * @return drawdownUom
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "**Note**: This field is only available if you have the [Prepaid with Drawdown](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/J_Billing_Operations/Prepaid_with_Drawdown) feature enabled.  Unit of measurement for a [drawdown charge](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/J_Billing_Operations/Prepaid_with_Drawdown/Create_drawdown_charge). ")

  public String getDrawdownUom() {
    return drawdownUom;
  }


  public void setDrawdownUom(String drawdownUom) {
    
    
    
    this.drawdownUom = drawdownUom;
  }


  public GETProductRatePlanChargeTypeAllOf endDateCondition(String endDateCondition) {
    
    
    
    
    this.endDateCondition = endDateCondition;
    return this;
  }

   /**
   * Defines when the charge ends after the charge trigger date. If the subscription ends before the charge end date, the charge ends when the subscription ends. But if the subscription end date is subsequently changed through a Renewal, or Terms and Conditions amendment, the charge will end on the charge end date.  Values: - Subscription_End - Fixed_Period 
   * @return endDateCondition
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Defines when the charge ends after the charge trigger date. If the subscription ends before the charge end date, the charge ends when the subscription ends. But if the subscription end date is subsequently changed through a Renewal, or Terms and Conditions amendment, the charge will end on the charge end date.  Values: - Subscription_End - Fixed_Period ")

  public String getEndDateCondition() {
    return endDateCondition;
  }


  public void setEndDateCondition(String endDateCondition) {
    
    
    
    this.endDateCondition = endDateCondition;
  }


  public GETProductRatePlanChargeTypeAllOf excludeItemBillingFromRevenueAccounting(Boolean excludeItemBillingFromRevenueAccounting) {
    
    
    
    
    this.excludeItemBillingFromRevenueAccounting = excludeItemBillingFromRevenueAccounting;
    return this;
  }

   /**
   * The flag to exclude the related invoice items, invoice item adjustments, credit memo items, and debit memo items from revenue accounting.  **Note**: This field is only available if you have the Billing - Revenue Integration feature enabled.  
   * @return excludeItemBillingFromRevenueAccounting
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The flag to exclude the related invoice items, invoice item adjustments, credit memo items, and debit memo items from revenue accounting.  **Note**: This field is only available if you have the Billing - Revenue Integration feature enabled.  ")

  public Boolean getExcludeItemBillingFromRevenueAccounting() {
    return excludeItemBillingFromRevenueAccounting;
  }


  public void setExcludeItemBillingFromRevenueAccounting(Boolean excludeItemBillingFromRevenueAccounting) {
    
    
    
    this.excludeItemBillingFromRevenueAccounting = excludeItemBillingFromRevenueAccounting;
  }


  public GETProductRatePlanChargeTypeAllOf excludeItemBookingFromRevenueAccounting(Boolean excludeItemBookingFromRevenueAccounting) {
    
    
    
    
    this.excludeItemBookingFromRevenueAccounting = excludeItemBookingFromRevenueAccounting;
    return this;
  }

   /**
   * The flag to exclude the related rate plan charges and order line items from revenue accounting.  **Note**: This field is only available if you have the Billing - Revenue Integration feature enabled.  
   * @return excludeItemBookingFromRevenueAccounting
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The flag to exclude the related rate plan charges and order line items from revenue accounting.  **Note**: This field is only available if you have the Billing - Revenue Integration feature enabled.  ")

  public Boolean getExcludeItemBookingFromRevenueAccounting() {
    return excludeItemBookingFromRevenueAccounting;
  }


  public void setExcludeItemBookingFromRevenueAccounting(Boolean excludeItemBookingFromRevenueAccounting) {
    
    
    
    this.excludeItemBookingFromRevenueAccounting = excludeItemBookingFromRevenueAccounting;
  }


  public GETProductRatePlanChargeTypeAllOf financeInformation(FinanceInformation financeInformation) {
    
    
    
    
    this.financeInformation = financeInformation;
    return this;
  }

   /**
   * Get financeInformation
   * @return financeInformation
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public FinanceInformation getFinanceInformation() {
    return financeInformation;
  }


  public void setFinanceInformation(FinanceInformation financeInformation) {
    
    
    
    this.financeInformation = financeInformation;
  }


  public GETProductRatePlanChargeTypeAllOf formula(String formula) {
    
    
    
    
    this.formula = formula;
    return this;
  }

   /**
   * The pricing formula to calculate the actual rating amount for each usage record.  This field is only available for the usage-based charges that use the Multi-Attribute Pricing charge model. The charge model is available for customers with Enterprise and Nine editions by default. If you are a Growth customer, see [Zuora Editions](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/C_Zuora_Editions) for pricing information. 
   * @return formula
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The pricing formula to calculate the actual rating amount for each usage record.  This field is only available for the usage-based charges that use the Multi-Attribute Pricing charge model. The charge model is available for customers with Enterprise and Nine editions by default. If you are a Growth customer, see [Zuora Editions](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/C_Zuora_Editions) for pricing information. ")

  public String getFormula() {
    return formula;
  }


  public void setFormula(String formula) {
    
    
    
    this.formula = formula;
  }


  public GETProductRatePlanChargeTypeAllOf id(String id) {
    
    
    
    
    this.id = id;
    return this;
  }

   /**
   * Unique product rate-plan charge ID. 
   * @return id
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Unique product rate-plan charge ID. ")

  public String getId() {
    return id;
  }


  public void setId(String id) {
    
    
    
    this.id = id;
  }


  public GETProductRatePlanChargeTypeAllOf includedUnits(BigDecimal includedUnits) {
    
    
    
    
    this.includedUnits = includedUnits;
    return this;
  }

   /**
   * Specifies the number of units in the base set of units when the charge model is Overage. 
   * @return includedUnits
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Specifies the number of units in the base set of units when the charge model is Overage. ")

  public BigDecimal getIncludedUnits() {
    return includedUnits;
  }


  public void setIncludedUnits(BigDecimal includedUnits) {
    
    
    
    this.includedUnits = includedUnits;
  }


  public GETProductRatePlanChargeTypeAllOf isAllocationEligible(Boolean isAllocationEligible) {
    
    
    
    
    this.isAllocationEligible = isAllocationEligible;
    return this;
  }

   /**
   * This field is used to identify if the charge segment is allocation eligible in revenue recognition.  **Note**: This feature is in the **Early Adopter** phase. If you want to use the feature, submit a request at &lt;a href&#x3D;\&quot;https://support.zuora.com/\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Zuora Global Support&lt;/a&gt;, and we will evaluate whether the feature is suitable for your use cases. 
   * @return isAllocationEligible
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "This field is used to identify if the charge segment is allocation eligible in revenue recognition.  **Note**: This feature is in the **Early Adopter** phase. If you want to use the feature, submit a request at <a href=\"https://support.zuora.com/\" target=\"_blank\">Zuora Global Support</a>, and we will evaluate whether the feature is suitable for your use cases. ")

  public Boolean getIsAllocationEligible() {
    return isAllocationEligible;
  }


  public void setIsAllocationEligible(Boolean isAllocationEligible) {
    
    
    
    this.isAllocationEligible = isAllocationEligible;
  }


  public GETProductRatePlanChargeTypeAllOf isPrepaid(Boolean isPrepaid) {
    
    
    
    
    this.isPrepaid = isPrepaid;
    return this;
  }

   /**
   * **Note**: This field is only available if you have the [Prepaid with Drawdown](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/J_Billing_Operations/Prepaid_with_Drawdown) feature enabled.  Indicates whether this charge is a prepayment (topup) charge or a drawdown charge. Values: &#x60;true&#x60; or &#x60;false&#x60;. 
   * @return isPrepaid
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "**Note**: This field is only available if you have the [Prepaid with Drawdown](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/J_Billing_Operations/Prepaid_with_Drawdown) feature enabled.  Indicates whether this charge is a prepayment (topup) charge or a drawdown charge. Values: `true` or `false`. ")

  public Boolean getIsPrepaid() {
    return isPrepaid;
  }


  public void setIsPrepaid(Boolean isPrepaid) {
    
    
    
    this.isPrepaid = isPrepaid;
  }


  public GETProductRatePlanChargeTypeAllOf isRollover(Boolean isRollover) {
    
    
    
    
    this.isRollover = isRollover;
    return this;
  }

   /**
   * **Note**: This field is only available if you have the [Prepaid with Drawdown](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/J_Billing_Operations/Prepaid_with_Drawdown) feature enabled.  The value is either \&quot;true\&quot; or \&quot;false\&quot;. It determines whether the rollover fields are needed. 
   * @return isRollover
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "**Note**: This field is only available if you have the [Prepaid with Drawdown](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/J_Billing_Operations/Prepaid_with_Drawdown) feature enabled.  The value is either \"true\" or \"false\". It determines whether the rollover fields are needed. ")

  public Boolean getIsRollover() {
    return isRollover;
  }


  public void setIsRollover(Boolean isRollover) {
    
    
    
    this.isRollover = isRollover;
  }


  public GETProductRatePlanChargeTypeAllOf isStackedDiscount(Boolean isStackedDiscount) {
    
    
    
    
    this.isStackedDiscount = isStackedDiscount;
    return this;
  }

   /**
   * **Note**: This field is only applicable to the Discount - Percentage charge model.  To use this field, you must set the &#x60;X-Zuora-WSDL-Version&#x60; request header to 130 or higher. Otherwise, an error occurs.  This field indicates whether the discount is to be calculated as stacked discount. Possible values are as follows:  - &#x60;true&#x60;: This is a stacked discount, which should be calculated by stacking with other discounts.  - &#x60;false&#x60;: This is not a stacked discount, which should be calculated in sequence with other discounts.  For more information, see [Stacked discounts](https://knowledgecenter.zuora.com/Zuora_Billing/Products/Product_Catalog/B_Charge_Models/B_Discount_Charge_Models). 
   * @return isStackedDiscount
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "**Note**: This field is only applicable to the Discount - Percentage charge model.  To use this field, you must set the `X-Zuora-WSDL-Version` request header to 130 or higher. Otherwise, an error occurs.  This field indicates whether the discount is to be calculated as stacked discount. Possible values are as follows:  - `true`: This is a stacked discount, which should be calculated by stacking with other discounts.  - `false`: This is not a stacked discount, which should be calculated in sequence with other discounts.  For more information, see [Stacked discounts](https://knowledgecenter.zuora.com/Zuora_Billing/Products/Product_Catalog/B_Charge_Models/B_Discount_Charge_Models). ")

  public Boolean getIsStackedDiscount() {
    return isStackedDiscount;
  }


  public void setIsStackedDiscount(Boolean isStackedDiscount) {
    
    
    
    this.isStackedDiscount = isStackedDiscount;
  }


  public GETProductRatePlanChargeTypeAllOf isUnbilled(Boolean isUnbilled) {
    
    
    
    
    this.isUnbilled = isUnbilled;
    return this;
  }

   /**
   * This field is used to dictate how to perform the accounting during revenue recognition.  **Note**: This feature is in the **Early Adopter** phase. If you want to use the feature, submit a request at &lt;a href&#x3D;\&quot;https://support.zuora.com/\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Zuora Global Support&lt;/a&gt;, and we will evaluate whether the feature is suitable for your use cases. 
   * @return isUnbilled
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "This field is used to dictate how to perform the accounting during revenue recognition.  **Note**: This feature is in the **Early Adopter** phase. If you want to use the feature, submit a request at <a href=\"https://support.zuora.com/\" target=\"_blank\">Zuora Global Support</a>, and we will evaluate whether the feature is suitable for your use cases. ")

  public Boolean getIsUnbilled() {
    return isUnbilled;
  }


  public void setIsUnbilled(Boolean isUnbilled) {
    
    
    
    this.isUnbilled = isUnbilled;
  }


  public GETProductRatePlanChargeTypeAllOf listPriceBase(ListPriceBaseEnum listPriceBase) {
    
    
    
    
    this.listPriceBase = listPriceBase;
    return this;
  }

   /**
   * The list price base for the product rate plan charge.  This field is only applicable for recurring charges. 
   * @return listPriceBase
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The list price base for the product rate plan charge.  This field is only applicable for recurring charges. ")

  public ListPriceBaseEnum getListPriceBase() {
    return listPriceBase;
  }


  public void setListPriceBase(ListPriceBaseEnum listPriceBase) {
    
    
    
    this.listPriceBase = listPriceBase;
  }


  public GETProductRatePlanChargeTypeAllOf maxQuantity(BigDecimal maxQuantity) {
    
    
    
    
    this.maxQuantity = maxQuantity;
    return this;
  }

   /**
   * Specifies the maximum number of units for this charge. Use this field and the &#x60;minQuantity&#x60; field to create a range of units allowed in a product rate plan charge. 
   * @return maxQuantity
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Specifies the maximum number of units for this charge. Use this field and the `minQuantity` field to create a range of units allowed in a product rate plan charge. ")

  public BigDecimal getMaxQuantity() {
    return maxQuantity;
  }


  public void setMaxQuantity(BigDecimal maxQuantity) {
    
    
    
    this.maxQuantity = maxQuantity;
  }


  public GETProductRatePlanChargeTypeAllOf minQuantity(BigDecimal minQuantity) {
    
    
    
    
    this.minQuantity = minQuantity;
    return this;
  }

   /**
   * Specifies the minimum number of units for this charge. Use this field and the &#x60;maxQuantity&#x60; field to create a range of units allowed in a product rate plan charge. 
   * @return minQuantity
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Specifies the minimum number of units for this charge. Use this field and the `maxQuantity` field to create a range of units allowed in a product rate plan charge. ")

  public BigDecimal getMinQuantity() {
    return minQuantity;
  }


  public void setMinQuantity(BigDecimal minQuantity) {
    
    
    
    this.minQuantity = minQuantity;
  }


  public GETProductRatePlanChargeTypeAllOf model(String model) {
    
    
    
    
    this.model = model;
    return this;
  }

   /**
   * Charge model which determines how charges are calculated. Charge models must be individually activated in Zuora Billing administration.   Possible values are: - &#x60;FlatFee&#x60; - &#x60;PerUnit&#x60; - &#x60;Overage&#x60; - &#x60;Volume&#x60; - &#x60;Tiered&#x60; - &#x60;TieredWithOverage&#x60; - &#x60;DiscountFixedAmount&#x60; - &#x60;DiscountPercentage&#x60; - &#x60;Delivery&#x60; (available only if you have the Delivery Pricing charge model enabled) - &#x60;MultiAttributePricing&#x60; (available only if you have the Multi-Attribute Pricing charge model enabled. The charge model is available for customers with Enterprise and Nine editions by default. If you are a Growth customer, see [Zuora Editions](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/C_Zuora_Editions) for pricing information.) - &#x60;PreratedPerUnit&#x60; (available only if you have the Pre-rated Per Unit Pricing charge model enabled. The charge model is available for customers with Enterprise and Nine editions by default. If you are a Growth customer, see [Zuora Editions](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/C_Zuora_Editions) for pricing information.) - &#x60;PreratedPricing&#x60; (available only if you have the Pre-rated Pricing charge model enabled. The charge model is available for customers with Enterprise and Nine editions by default. If you are a Growth customer, see [Zuora Editions](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/C_Zuora_Editions) for pricing information.) - &#x60;HighWatermarkVolumePricing&#x60; (available only if you have the High Water Mark Volume Pricing charge model enabled. The charge model is available for customers with Enterprise and Nine editions by default. If you are a Growth customer, see [Zuora Editions](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/C_Zuora_Editions) for pricing information.) - &#x60;HighWatermarkTieredPricing&#x60; (available only if you have the High Water Mark Tiered Pricing charge model enabled. The charge model is available for customers with Enterprise and Nine editions by default. If you are a Growth customer, see [Zuora Editions](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/C_Zuora_Editions) for pricing information.)  The value of the &#x60;pricing&#x60; field contains details about these charge models and the value of &#x60;pricingSummary&#x60; field contains their associated pricing summary values. 
   * @return model
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Charge model which determines how charges are calculated. Charge models must be individually activated in Zuora Billing administration.   Possible values are: - `FlatFee` - `PerUnit` - `Overage` - `Volume` - `Tiered` - `TieredWithOverage` - `DiscountFixedAmount` - `DiscountPercentage` - `Delivery` (available only if you have the Delivery Pricing charge model enabled) - `MultiAttributePricing` (available only if you have the Multi-Attribute Pricing charge model enabled. The charge model is available for customers with Enterprise and Nine editions by default. If you are a Growth customer, see [Zuora Editions](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/C_Zuora_Editions) for pricing information.) - `PreratedPerUnit` (available only if you have the Pre-rated Per Unit Pricing charge model enabled. The charge model is available for customers with Enterprise and Nine editions by default. If you are a Growth customer, see [Zuora Editions](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/C_Zuora_Editions) for pricing information.) - `PreratedPricing` (available only if you have the Pre-rated Pricing charge model enabled. The charge model is available for customers with Enterprise and Nine editions by default. If you are a Growth customer, see [Zuora Editions](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/C_Zuora_Editions) for pricing information.) - `HighWatermarkVolumePricing` (available only if you have the High Water Mark Volume Pricing charge model enabled. The charge model is available for customers with Enterprise and Nine editions by default. If you are a Growth customer, see [Zuora Editions](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/C_Zuora_Editions) for pricing information.) - `HighWatermarkTieredPricing` (available only if you have the High Water Mark Tiered Pricing charge model enabled. The charge model is available for customers with Enterprise and Nine editions by default. If you are a Growth customer, see [Zuora Editions](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/C_Zuora_Editions) for pricing information.)  The value of the `pricing` field contains details about these charge models and the value of `pricingSummary` field contains their associated pricing summary values. ")

  public String getModel() {
    return model;
  }


  public void setModel(String model) {
    
    
    
    this.model = model;
  }


  public GETProductRatePlanChargeTypeAllOf name(String name) {
    
    
    
    
    this.name = name;
    return this;
  }

   /**
   * Name of the product rate-plan charge. (Not required to be unique.) 
   * @return name
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Name of the product rate-plan charge. (Not required to be unique.) ")

  public String getName() {
    return name;
  }


  public void setName(String name) {
    
    
    
    this.name = name;
  }


  public GETProductRatePlanChargeTypeAllOf numberOfPeriods(Long numberOfPeriods) {
    
    
    
    
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


  public GETProductRatePlanChargeTypeAllOf overageCalculationOption(String overageCalculationOption) {
    
    
    
    
    this.overageCalculationOption = overageCalculationOption;
    return this;
  }

   /**
   * Value specifies when to calculate overage charges.  Values: - EndOfSmoothingPeriod - PerBillingPeriod - null 
   * @return overageCalculationOption
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Value specifies when to calculate overage charges.  Values: - EndOfSmoothingPeriod - PerBillingPeriod - null ")

  public String getOverageCalculationOption() {
    return overageCalculationOption;
  }


  public void setOverageCalculationOption(String overageCalculationOption) {
    
    
    
    this.overageCalculationOption = overageCalculationOption;
  }


  public GETProductRatePlanChargeTypeAllOf overageUnusedUnitsCreditOption(String overageUnusedUnitsCreditOption) {
    
    
    
    
    this.overageUnusedUnitsCreditOption = overageUnusedUnitsCreditOption;
    return this;
  }

   /**
   * Determines whether to credit the customer with unused units of usage.  Values: - NoCredit - CreditBySpecificRate 
   * @return overageUnusedUnitsCreditOption
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Determines whether to credit the customer with unused units of usage.  Values: - NoCredit - CreditBySpecificRate ")

  public String getOverageUnusedUnitsCreditOption() {
    return overageUnusedUnitsCreditOption;
  }


  public void setOverageUnusedUnitsCreditOption(String overageUnusedUnitsCreditOption) {
    
    
    
    this.overageUnusedUnitsCreditOption = overageUnusedUnitsCreditOption;
  }


  public GETProductRatePlanChargeTypeAllOf prepaidOperationType(PrepaidOperationTypeEnum prepaidOperationType) {
    
    
    
    
    this.prepaidOperationType = prepaidOperationType;
    return this;
  }

   /**
   * **Note**: This field is only available if you have the [Prepaid with Drawdown](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/J_Billing_Operations/Prepaid_with_Drawdown) feature enabled.  The type of this charge. It is either a prepayment (topup) charge or a drawdown charge.  
   * @return prepaidOperationType
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "**Note**: This field is only available if you have the [Prepaid with Drawdown](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/J_Billing_Operations/Prepaid_with_Drawdown) feature enabled.  The type of this charge. It is either a prepayment (topup) charge or a drawdown charge.  ")

  public PrepaidOperationTypeEnum getPrepaidOperationType() {
    return prepaidOperationType;
  }


  public void setPrepaidOperationType(PrepaidOperationTypeEnum prepaidOperationType) {
    
    
    
    this.prepaidOperationType = prepaidOperationType;
  }


  public GETProductRatePlanChargeTypeAllOf prepaidQuantity(Double prepaidQuantity) {
    
    
    
    
    this.prepaidQuantity = prepaidQuantity;
    return this;
  }

  public GETProductRatePlanChargeTypeAllOf prepaidQuantity(Integer prepaidQuantity) {
    
    
    
    
    this.prepaidQuantity = prepaidQuantity.doubleValue();
    return this;
  }

   /**
   * **Note**: This field is only available if you have the [Prepaid with Drawdown](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/J_Billing_Operations/Prepaid_with_Drawdown) feature enabled.  The number of units included in a [prepayment charge](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/J_Billing_Operations/Prepaid_with_Drawdown/Create_prepayment_charge). Must be a positive number (&gt;0). 
   * @return prepaidQuantity
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "**Note**: This field is only available if you have the [Prepaid with Drawdown](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/J_Billing_Operations/Prepaid_with_Drawdown) feature enabled.  The number of units included in a [prepayment charge](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/J_Billing_Operations/Prepaid_with_Drawdown/Create_prepayment_charge). Must be a positive number (>0). ")

  public Double getPrepaidQuantity() {
    return prepaidQuantity;
  }


  public void setPrepaidQuantity(Double prepaidQuantity) {
    
    
    
    this.prepaidQuantity = prepaidQuantity;
  }


  public GETProductRatePlanChargeTypeAllOf prepaidTotalQuantity(Double prepaidTotalQuantity) {
    
    
    
    
    this.prepaidTotalQuantity = prepaidTotalQuantity;
    return this;
  }

  public GETProductRatePlanChargeTypeAllOf prepaidTotalQuantity(Integer prepaidTotalQuantity) {
    
    
    
    
    this.prepaidTotalQuantity = prepaidTotalQuantity.doubleValue();
    return this;
  }

   /**
   * **Note**: This field is only available if you have the [Prepaid with Drawdown](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/J_Billing_Operations/Prepaid_with_Drawdown) feature enabled.  The total amount of units that end customers can use during a validity period when they subscribe to a [prepayment charge](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/J_Billing_Operations/Prepaid_with_Drawdown/Create_prepayment_charge). 
   * @return prepaidTotalQuantity
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "**Note**: This field is only available if you have the [Prepaid with Drawdown](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/J_Billing_Operations/Prepaid_with_Drawdown) feature enabled.  The total amount of units that end customers can use during a validity period when they subscribe to a [prepayment charge](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/J_Billing_Operations/Prepaid_with_Drawdown/Create_prepayment_charge). ")

  public Double getPrepaidTotalQuantity() {
    return prepaidTotalQuantity;
  }


  public void setPrepaidTotalQuantity(Double prepaidTotalQuantity) {
    
    
    
    this.prepaidTotalQuantity = prepaidTotalQuantity;
  }


  public GETProductRatePlanChargeTypeAllOf prepaidUom(String prepaidUom) {
    
    
    
    
    this.prepaidUom = prepaidUom;
    return this;
  }

   /**
   * **Note**: This field is only available if you have the [Prepaid with Drawdown](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/J_Billing_Operations/Prepaid_with_Drawdown) feature enabled.  Unit of measurement for a [prepayment charge](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/J_Billing_Operations/Prepaid_with_Drawdown/Create_prepayment_charge). 
   * @return prepaidUom
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "**Note**: This field is only available if you have the [Prepaid with Drawdown](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/J_Billing_Operations/Prepaid_with_Drawdown) feature enabled.  Unit of measurement for a [prepayment charge](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/J_Billing_Operations/Prepaid_with_Drawdown/Create_prepayment_charge). ")

  public String getPrepaidUom() {
    return prepaidUom;
  }


  public void setPrepaidUom(String prepaidUom) {
    
    
    
    this.prepaidUom = prepaidUom;
  }


  public GETProductRatePlanChargeTypeAllOf prepayPeriods(Long prepayPeriods) {
    
    
    
    
    this.prepayPeriods = prepayPeriods;
    return this;
  }

   /**
   * The number of periods to which prepayment is set.   **Note:** This field is only available if you already have the prepayment feature enabled. The prepayment feature is deprecated and available only for backward compatibility. Zuora does not support enabling this feature anymore. 
   * @return prepayPeriods
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The number of periods to which prepayment is set.   **Note:** This field is only available if you already have the prepayment feature enabled. The prepayment feature is deprecated and available only for backward compatibility. Zuora does not support enabling this feature anymore. ")

  public Long getPrepayPeriods() {
    return prepayPeriods;
  }


  public void setPrepayPeriods(Long prepayPeriods) {
    
    
    
    this.prepayPeriods = prepayPeriods;
  }


  public GETProductRatePlanChargeTypeAllOf priceChangeOption(String priceChangeOption) {
    
    
    
    
    this.priceChangeOption = priceChangeOption;
    return this;
  }

   /**
   * Applies an automatic price change when a termed subscription is renewed and the following applies:  1. AutomatedPriceChange setting is on 2. Charge type is not one-time 3. Charge model is not discount fixed amount  Values: - NoChange (default) - SpecificPercentageValue - UseLatestProductCatalogPricing 
   * @return priceChangeOption
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Applies an automatic price change when a termed subscription is renewed and the following applies:  1. AutomatedPriceChange setting is on 2. Charge type is not one-time 3. Charge model is not discount fixed amount  Values: - NoChange (default) - SpecificPercentageValue - UseLatestProductCatalogPricing ")

  public String getPriceChangeOption() {
    return priceChangeOption;
  }


  public void setPriceChangeOption(String priceChangeOption) {
    
    
    
    this.priceChangeOption = priceChangeOption;
  }


  public GETProductRatePlanChargeTypeAllOf priceIncreasePercentage(BigDecimal priceIncreasePercentage) {
    
    
    
    
    this.priceIncreasePercentage = priceIncreasePercentage;
    return this;
  }

   /**
   * Specifies the percentage to increase or decrease the price of a termed subscription&#39;s renewal. Use this field if you set the &#x60;PriceChangeOption&#x60; value to &#x60;SpecificPercentageValue&#x60;.  1. AutomatedPriceChange setting is on 2. Charge type is not one-time 3. Charge model is not discount fixed amount  Values: a decimal between -100 and 100 
   * @return priceIncreasePercentage
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Specifies the percentage to increase or decrease the price of a termed subscription's renewal. Use this field if you set the `PriceChangeOption` value to `SpecificPercentageValue`.  1. AutomatedPriceChange setting is on 2. Charge type is not one-time 3. Charge model is not discount fixed amount  Values: a decimal between -100 and 100 ")

  public BigDecimal getPriceIncreasePercentage() {
    return priceIncreasePercentage;
  }


  public void setPriceIncreasePercentage(BigDecimal priceIncreasePercentage) {
    
    
    
    this.priceIncreasePercentage = priceIncreasePercentage;
  }


  public GETProductRatePlanChargeTypeAllOf pricing(List<GETProductRatePlanChargePricingType> pricing) {
    
    
    
    
    this.pricing = pricing;
    return this;
  }

  public GETProductRatePlanChargeTypeAllOf addPricingItem(GETProductRatePlanChargePricingType pricingItem) {
    if (this.pricing == null) {
      this.pricing = new ArrayList<>();
    }
    this.pricing.add(pricingItem);
    return this;
  }

   /**
   * One or more price charge models with attributes that further describe the model.  Some attributes show as null values when not applicable. 
   * @return pricing
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "One or more price charge models with attributes that further describe the model.  Some attributes show as null values when not applicable. ")

  public List<GETProductRatePlanChargePricingType> getPricing() {
    return pricing;
  }


  public void setPricing(List<GETProductRatePlanChargePricingType> pricing) {
    
    
    
    this.pricing = pricing;
  }


  public GETProductRatePlanChargeTypeAllOf pricingSummary(List<String> pricingSummary) {
    
    
    
    
    this.pricingSummary = pricingSummary;
    return this;
  }

  public GETProductRatePlanChargeTypeAllOf addPricingSummaryItem(String pricingSummaryItem) {
    if (this.pricingSummary == null) {
      this.pricingSummary = new ArrayList<>();
    }
    this.pricingSummary.add(pricingSummaryItem);
    return this;
  }

   /**
   * A concise description of the charge model and pricing that is suitable to show to your customers. When the rate plan charge model is &#x60;Tiered&#x60; and multi-currency is enabled, this field includes an array of string of each currency, and each string of currency includes tier price description separated by comma.  For the following charge models, the value of this field is an empty string: - Multi-Attribute Pricing - High Water Mark Tiered Pricing - High Water Mark Volume Pricing - Pre-Rated Per Unit Pricing - Pre-Rated Pricing  The charge models are available for customers with Enterprise and Nine editions by default. If you are a Growth customer, see [Zuora Editions](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/C_Zuora_Editions) for pricing information. 
   * @return pricingSummary
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "A concise description of the charge model and pricing that is suitable to show to your customers. When the rate plan charge model is `Tiered` and multi-currency is enabled, this field includes an array of string of each currency, and each string of currency includes tier price description separated by comma.  For the following charge models, the value of this field is an empty string: - Multi-Attribute Pricing - High Water Mark Tiered Pricing - High Water Mark Volume Pricing - Pre-Rated Per Unit Pricing - Pre-Rated Pricing  The charge models are available for customers with Enterprise and Nine editions by default. If you are a Growth customer, see [Zuora Editions](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/C_Zuora_Editions) for pricing information. ")

  public List<String> getPricingSummary() {
    return pricingSummary;
  }


  public void setPricingSummary(List<String> pricingSummary) {
    
    
    
    this.pricingSummary = pricingSummary;
  }


  public GETProductRatePlanChargeTypeAllOf productChargeDefinitions(String productChargeDefinitions) {
    
    
    
    
    this.productChargeDefinitions = productChargeDefinitions;
    return this;
  }

   /**
   * A link to retrieve product charge definitions of this charge. 
   * @return productChargeDefinitions
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "A link to retrieve product charge definitions of this charge. ")

  public String getProductChargeDefinitions() {
    return productChargeDefinitions;
  }


  public void setProductChargeDefinitions(String productChargeDefinitions) {
    
    
    
    this.productChargeDefinitions = productChargeDefinitions;
  }


  public GETProductRatePlanChargeTypeAllOf productDiscountApplyDetails(List<GETProductDiscountApplyDetailsType> productDiscountApplyDetails) {
    
    
    
    
    this.productDiscountApplyDetails = productDiscountApplyDetails;
    return this;
  }

  public GETProductRatePlanChargeTypeAllOf addProductDiscountApplyDetailsItem(GETProductDiscountApplyDetailsType productDiscountApplyDetailsItem) {
    if (this.productDiscountApplyDetails == null) {
      this.productDiscountApplyDetails = new ArrayList<>();
    }
    this.productDiscountApplyDetails.add(productDiscountApplyDetailsItem);
    return this;
  }

   /**
   * Container for the application details about a discount product rate plan charge.   Only discount product rate plan charges have values in this field. 
   * @return productDiscountApplyDetails
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Container for the application details about a discount product rate plan charge.   Only discount product rate plan charges have values in this field. ")

  public List<GETProductDiscountApplyDetailsType> getProductDiscountApplyDetails() {
    return productDiscountApplyDetails;
  }


  public void setProductDiscountApplyDetails(List<GETProductDiscountApplyDetailsType> productDiscountApplyDetails) {
    
    
    
    this.productDiscountApplyDetails = productDiscountApplyDetails;
  }


  public GETProductRatePlanChargeTypeAllOf productRatePlanChargeNumber(String productRatePlanChargeNumber) {
    
    
    
    
    this.productRatePlanChargeNumber = productRatePlanChargeNumber;
    return this;
  }

   /**
   * The natural key of the product rate plan charge. 
   * @return productRatePlanChargeNumber
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The natural key of the product rate plan charge. ")

  public String getProductRatePlanChargeNumber() {
    return productRatePlanChargeNumber;
  }


  public void setProductRatePlanChargeNumber(String productRatePlanChargeNumber) {
    
    
    
    this.productRatePlanChargeNumber = productRatePlanChargeNumber;
  }


  public GETProductRatePlanChargeTypeAllOf ratingGroup(String ratingGroup) {
    
    
    
    
    this.ratingGroup = ratingGroup;
    return this;
  }

   /**
   * Specifies a rating group based on which usage records are rated.  Possible values:  - &#x60;ByBillingPeriod&#x60; (default): The rating is based on all the usages in a billing period. - &#x60;ByUsageStartDate&#x60;: The rating is based on all the usages on the same usage start date.  - &#x60;ByUsageRecord&#x60;: The rating is based on each usage record. - &#x60;ByUsageUpload&#x60;: The rating is based on all the  usages in a uploaded usage file (&#x60;.xls&#x60; or &#x60;.csv&#x60;). - &#x60;ByGroupId&#x60;: The rating is based on all the usages in a custom group.  **Note:**  - The &#x60;ByBillingPeriod&#x60; value can be applied for all charge models.  - The &#x60;ByUsageStartDate&#x60;, &#x60;ByUsageRecord&#x60;, and &#x60;ByUsageUpload&#x60; values can only be applied for per unit, volume pricing, and tiered pricing charge models.  - The &#x60;ByGroupId&#x60; value is only available if you have the Active Rating feature enabled. - Use this field only for Usage charges. One-Time Charges and Recurring Charges return &#x60;NULL&#x60;. 
   * @return ratingGroup
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Specifies a rating group based on which usage records are rated.  Possible values:  - `ByBillingPeriod` (default): The rating is based on all the usages in a billing period. - `ByUsageStartDate`: The rating is based on all the usages on the same usage start date.  - `ByUsageRecord`: The rating is based on each usage record. - `ByUsageUpload`: The rating is based on all the  usages in a uploaded usage file (`.xls` or `.csv`). - `ByGroupId`: The rating is based on all the usages in a custom group.  **Note:**  - The `ByBillingPeriod` value can be applied for all charge models.  - The `ByUsageStartDate`, `ByUsageRecord`, and `ByUsageUpload` values can only be applied for per unit, volume pricing, and tiered pricing charge models.  - The `ByGroupId` value is only available if you have the Active Rating feature enabled. - Use this field only for Usage charges. One-Time Charges and Recurring Charges return `NULL`. ")

  public String getRatingGroup() {
    return ratingGroup;
  }


  public void setRatingGroup(String ratingGroup) {
    
    
    
    this.ratingGroup = ratingGroup;
  }


  public GETProductRatePlanChargeTypeAllOf revRecCode(String revRecCode) {
    
    
    
    
    this.revRecCode = revRecCode;
    return this;
  }

   /**
   * Associates this product rate plan charge with a specific revenue recognition code. The value is a valid revenue recognition code. 
   * @return revRecCode
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Associates this product rate plan charge with a specific revenue recognition code. The value is a valid revenue recognition code. ")

  public String getRevRecCode() {
    return revRecCode;
  }


  public void setRevRecCode(String revRecCode) {
    
    
    
    this.revRecCode = revRecCode;
  }


  public GETProductRatePlanChargeTypeAllOf revRecTriggerCondition(RevRecTriggerConditionEnum revRecTriggerCondition) {
    
    
    
    
    this.revRecTriggerCondition = revRecTriggerCondition;
    return this;
  }

   /**
   * Specifies when revenue recognition begins. 
   * @return revRecTriggerCondition
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Specifies when revenue recognition begins. ")

  public RevRecTriggerConditionEnum getRevRecTriggerCondition() {
    return revRecTriggerCondition;
  }


  public void setRevRecTriggerCondition(RevRecTriggerConditionEnum revRecTriggerCondition) {
    
    
    
    this.revRecTriggerCondition = revRecTriggerCondition;
  }


  public GETProductRatePlanChargeTypeAllOf revenueRecognitionRuleName(String revenueRecognitionRuleName) {
    
    
    
    
    this.revenueRecognitionRuleName = revenueRecognitionRuleName;
    return this;
  }

   /**
   * The name of the revenue recognition rule governing the revenue schedule. 
   * @return revenueRecognitionRuleName
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The name of the revenue recognition rule governing the revenue schedule. ")

  public String getRevenueRecognitionRuleName() {
    return revenueRecognitionRuleName;
  }


  public void setRevenueRecognitionRuleName(String revenueRecognitionRuleName) {
    
    
    
    this.revenueRecognitionRuleName = revenueRecognitionRuleName;
  }


  public GETProductRatePlanChargeTypeAllOf rolloverApply(RolloverApplyEnum rolloverApply) {
    
    
    
    
    this.rolloverApply = rolloverApply;
    return this;
  }

   /**
   * **Note**: This field is only available if you have the [Prepaid with Drawdown](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/J_Billing_Operations/Prepaid_with_Drawdown) feature enabled.  This field defines the priority of rollover, which is either first or last. 
   * @return rolloverApply
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "**Note**: This field is only available if you have the [Prepaid with Drawdown](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/J_Billing_Operations/Prepaid_with_Drawdown) feature enabled.  This field defines the priority of rollover, which is either first or last. ")

  public RolloverApplyEnum getRolloverApply() {
    return rolloverApply;
  }


  public void setRolloverApply(RolloverApplyEnum rolloverApply) {
    
    
    
    this.rolloverApply = rolloverApply;
  }


  public GETProductRatePlanChargeTypeAllOf rolloverPeriodLength(Integer rolloverPeriodLength) {
    
    
    
    
    this.rolloverPeriodLength = rolloverPeriodLength;
    return this;
  }

   /**
   * **Note**: This field is only available if you have the [Prepaid with Drawdown](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/J_Billing_Operations/Prepaid_with_Drawdown) feature enabled.  The period length of the rollover fund. 
   * @return rolloverPeriodLength
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "**Note**: This field is only available if you have the [Prepaid with Drawdown](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/J_Billing_Operations/Prepaid_with_Drawdown) feature enabled.  The period length of the rollover fund. ")

  public Integer getRolloverPeriodLength() {
    return rolloverPeriodLength;
  }


  public void setRolloverPeriodLength(Integer rolloverPeriodLength) {
    
    
    
    this.rolloverPeriodLength = rolloverPeriodLength;
  }


  public GETProductRatePlanChargeTypeAllOf rolloverPeriods(Double rolloverPeriods) {
    
    
    
    
    this.rolloverPeriods = rolloverPeriods;
    return this;
  }

  public GETProductRatePlanChargeTypeAllOf rolloverPeriods(Integer rolloverPeriods) {
    
    
    
    
    this.rolloverPeriods = rolloverPeriods.doubleValue();
    return this;
  }

   /**
   * **Note**: This field is only available if you have the [Prepaid with Drawdown](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/J_Billing_Operations/Prepaid_with_Drawdown) feature enabled.  This field defines the number of rollover periods, it is restricted to 3. 
   * @return rolloverPeriods
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "**Note**: This field is only available if you have the [Prepaid with Drawdown](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/J_Billing_Operations/Prepaid_with_Drawdown) feature enabled.  This field defines the number of rollover periods, it is restricted to 3. ")

  public Double getRolloverPeriods() {
    return rolloverPeriods;
  }


  public void setRolloverPeriods(Double rolloverPeriods) {
    
    
    
    this.rolloverPeriods = rolloverPeriods;
  }


  public GETProductRatePlanChargeTypeAllOf smoothingModel(String smoothingModel) {
    
    
    
    
    this.smoothingModel = smoothingModel;
    return this;
  }

   /**
   * Specifies the smoothing model for an overage smoothing charge model or an tiered with overage model, which is an advanced type of a usage model that avoids spikes in usage charges. If a customer&#39;s usage spikes in a single period, then an overage smoothing model eases overage charges by considering usage and multiple periods.  One of the following values shows which smoothing model will be applied to the charge when &#x60;Overage&#x60; or &#x60;Tiered with Overage&#x60; is used:  - &#x60;RollingWindow&#x60; considers a number of periods to smooth usage. The rolling window starts and increments forward based on billing frequency. When allowed usage is met, then period resets and a new window begins. - &#x60;Rollover&#x60; considers a fixed number of periods before calculating usage. The net balance at the end of a period is unused usage, which is carried over to the next period&#39;s balance. 
   * @return smoothingModel
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Specifies the smoothing model for an overage smoothing charge model or an tiered with overage model, which is an advanced type of a usage model that avoids spikes in usage charges. If a customer's usage spikes in a single period, then an overage smoothing model eases overage charges by considering usage and multiple periods.  One of the following values shows which smoothing model will be applied to the charge when `Overage` or `Tiered with Overage` is used:  - `RollingWindow` considers a number of periods to smooth usage. The rolling window starts and increments forward based on billing frequency. When allowed usage is met, then period resets and a new window begins. - `Rollover` considers a fixed number of periods before calculating usage. The net balance at the end of a period is unused usage, which is carried over to the next period's balance. ")

  public String getSmoothingModel() {
    return smoothingModel;
  }


  public void setSmoothingModel(String smoothingModel) {
    
    
    
    this.smoothingModel = smoothingModel;
  }


  public GETProductRatePlanChargeTypeAllOf specificBillingPeriod(Long specificBillingPeriod) {
    
    
    
    
    this.specificBillingPeriod = specificBillingPeriod;
    return this;
  }

   /**
   * When the billing period is set to &#x60;Specific&#x60; Months then this positive integer reflects the number of months for billing period charges. 
   * @return specificBillingPeriod
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "When the billing period is set to `Specific` Months then this positive integer reflects the number of months for billing period charges. ")

  public Long getSpecificBillingPeriod() {
    return specificBillingPeriod;
  }


  public void setSpecificBillingPeriod(Long specificBillingPeriod) {
    
    
    
    this.specificBillingPeriod = specificBillingPeriod;
  }


  public GETProductRatePlanChargeTypeAllOf specificListPriceBase(Integer specificListPriceBase) {
    
    
    
    
    this.specificListPriceBase = specificListPriceBase;
    return this;
  }

   /**
   * The number of months for the list price base of the charge. The value of this field is &#x60;null&#x60; if you do not set the value of the &#x60;listPriceBase&#x60; field to &#x60;Per_Specific_Months&#x60;. 
   * @return specificListPriceBase
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The number of months for the list price base of the charge. The value of this field is `null` if you do not set the value of the `listPriceBase` field to `Per_Specific_Months`. ")

  public Integer getSpecificListPriceBase() {
    return specificListPriceBase;
  }


  public void setSpecificListPriceBase(Integer specificListPriceBase) {
    
    
    
    this.specificListPriceBase = specificListPriceBase;
  }


  public GETProductRatePlanChargeTypeAllOf taxCode(String taxCode) {
    
    
    
    
    this.taxCode = taxCode;
    return this;
  }

   /**
   * Specifies the tax code for taxation rules; used by Zuora Tax. 
   * @return taxCode
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Specifies the tax code for taxation rules; used by Zuora Tax. ")

  public String getTaxCode() {
    return taxCode;
  }


  public void setTaxCode(String taxCode) {
    
    
    
    this.taxCode = taxCode;
  }


  public GETProductRatePlanChargeTypeAllOf taxMode(TaxModeEnum taxMode) {
    
    
    
    
    this.taxMode = taxMode;
    return this;
  }

   /**
   * Specifies how to define taxation for the charge; used by Zuora Tax. 
   * @return taxMode
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Specifies how to define taxation for the charge; used by Zuora Tax. ")

  public TaxModeEnum getTaxMode() {
    return taxMode;
  }


  public void setTaxMode(TaxModeEnum taxMode) {
    
    
    
    this.taxMode = taxMode;
  }


  public GETProductRatePlanChargeTypeAllOf taxable(Boolean taxable) {
    
    
    
    
    this.taxable = taxable;
    return this;
  }

   /**
   * Specifies whether the charge is taxable; used by Zuora Tax. Possible values are:&#x60;true&#x60;, &#x60;false&#x60;. 
   * @return taxable
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Specifies whether the charge is taxable; used by Zuora Tax. Possible values are:`true`, `false`. ")

  public Boolean getTaxable() {
    return taxable;
  }


  public void setTaxable(Boolean taxable) {
    
    
    
    this.taxable = taxable;
  }


  public GETProductRatePlanChargeTypeAllOf triggerEvent(String triggerEvent) {
    
    
    
    
    this.triggerEvent = triggerEvent;
    return this;
  }

   /**
   * Specifies when to start billing the customer for the charge.  Values: one of the following: - &#x60;ContractEffective&#x60; is the date when the subscription&#39;s contract goes into effect and the charge is ready to be billed. - &#x60;ServiceActivation&#x60; is the date when the services or products for a subscription have been activated and the customers have access. - &#x60;CustomerAcceptance&#x60; is when the customer accepts the services or products for a subscription.  - &#x60;SpecificDate&#x60; is the date specified. 
   * @return triggerEvent
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Specifies when to start billing the customer for the charge.  Values: one of the following: - `ContractEffective` is the date when the subscription's contract goes into effect and the charge is ready to be billed. - `ServiceActivation` is the date when the services or products for a subscription have been activated and the customers have access. - `CustomerAcceptance` is when the customer accepts the services or products for a subscription.  - `SpecificDate` is the date specified. ")

  public String getTriggerEvent() {
    return triggerEvent;
  }


  public void setTriggerEvent(String triggerEvent) {
    
    
    
    this.triggerEvent = triggerEvent;
  }


  public GETProductRatePlanChargeTypeAllOf type(String type) {
    
    
    
    
    this.type = type;
    return this;
  }

   /**
   * The type of charge. Possible values are: &#x60;OneTime&#x60;, &#x60;Recurring&#x60;, &#x60;Usage&#x60;. 
   * @return type
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The type of charge. Possible values are: `OneTime`, `Recurring`, `Usage`. ")

  public String getType() {
    return type;
  }


  public void setType(String type) {
    
    
    
    this.type = type;
  }


  public GETProductRatePlanChargeTypeAllOf uom(String uom) {
    
    
    
    
    this.uom = uom;
    return this;
  }

   /**
   * Describes the Units of Measure (uom) configured in **Settings &gt; Billing** for the productRatePlanCharges.  Values: &#x60;Each&#x60;, &#x60;License&#x60;, &#x60;Seat&#x60;, or &#x60;null&#x60; 
   * @return uom
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Describes the Units of Measure (uom) configured in **Settings > Billing** for the productRatePlanCharges.  Values: `Each`, `License`, `Seat`, or `null` ")

  public String getUom() {
    return uom;
  }


  public void setUom(String uom) {
    
    
    
    this.uom = uom;
  }


  public GETProductRatePlanChargeTypeAllOf upToPeriods(Long upToPeriods) {
    
    
    
    
    this.upToPeriods = upToPeriods;
    return this;
  }

   /**
   * Specifies the length of the period during which the charge is active. If this period ends before the subscription ends, the charge ends when this period ends. If the subscription end date is subsequently changed through a Renewal, or Terms and Conditions amendment, the charge end date will change accordingly up to the original period end. 
   * @return upToPeriods
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Specifies the length of the period during which the charge is active. If this period ends before the subscription ends, the charge ends when this period ends. If the subscription end date is subsequently changed through a Renewal, or Terms and Conditions amendment, the charge end date will change accordingly up to the original period end. ")

  public Long getUpToPeriods() {
    return upToPeriods;
  }


  public void setUpToPeriods(Long upToPeriods) {
    
    
    
    this.upToPeriods = upToPeriods;
  }


  public GETProductRatePlanChargeTypeAllOf upToPeriodsType(UpToPeriodsTypeEnum upToPeriodsType) {
    
    
    
    
    this.upToPeriodsType = upToPeriodsType;
    return this;
  }

   /**
   * The period type used to define when the charge ends. 
   * @return upToPeriodsType
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The period type used to define when the charge ends. ")

  public UpToPeriodsTypeEnum getUpToPeriodsType() {
    return upToPeriodsType;
  }


  public void setUpToPeriodsType(UpToPeriodsTypeEnum upToPeriodsType) {
    
    
    
    this.upToPeriodsType = upToPeriodsType;
  }


  public GETProductRatePlanChargeTypeAllOf usageRecordRatingOption(String usageRecordRatingOption) {
    
    
    
    
    this.usageRecordRatingOption = usageRecordRatingOption;
    return this;
  }

   /**
   * Determines how Zuora processes usage records for per-unit usage charges.  
   * @return usageRecordRatingOption
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Determines how Zuora processes usage records for per-unit usage charges.  ")

  public String getUsageRecordRatingOption() {
    return usageRecordRatingOption;
  }


  public void setUsageRecordRatingOption(String usageRecordRatingOption) {
    
    
    
    this.usageRecordRatingOption = usageRecordRatingOption;
  }


  public GETProductRatePlanChargeTypeAllOf useDiscountSpecificAccountingCode(Boolean useDiscountSpecificAccountingCode) {
    
    
    
    
    this.useDiscountSpecificAccountingCode = useDiscountSpecificAccountingCode;
    return this;
  }

   /**
   * Determines whether to define a new accounting code for the new discount charge. Values: &#x60;true&#x60;, &#x60;false&#x60; 
   * @return useDiscountSpecificAccountingCode
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Determines whether to define a new accounting code for the new discount charge. Values: `true`, `false` ")

  public Boolean getUseDiscountSpecificAccountingCode() {
    return useDiscountSpecificAccountingCode;
  }


  public void setUseDiscountSpecificAccountingCode(Boolean useDiscountSpecificAccountingCode) {
    
    
    
    this.useDiscountSpecificAccountingCode = useDiscountSpecificAccountingCode;
  }


  public GETProductRatePlanChargeTypeAllOf useTenantDefaultForPriceChange(Boolean useTenantDefaultForPriceChange) {
    
    
    
    
    this.useTenantDefaultForPriceChange = useTenantDefaultForPriceChange;
    return this;
  }

   /**
   * Shows the tenant-level percentage uplift value for an automatic price change to a termed subscription&#39;s renewal. You set the tenant uplift value in the web-based UI: **Settings &gt; Billing &gt; Define Default Subscription Settings**.  Values: &#x60;true&#x60;, &#x60;false&#x60; 
   * @return useTenantDefaultForPriceChange
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Shows the tenant-level percentage uplift value for an automatic price change to a termed subscription's renewal. You set the tenant uplift value in the web-based UI: **Settings > Billing > Define Default Subscription Settings**.  Values: `true`, `false` ")

  public Boolean getUseTenantDefaultForPriceChange() {
    return useTenantDefaultForPriceChange;
  }


  public void setUseTenantDefaultForPriceChange(Boolean useTenantDefaultForPriceChange) {
    
    
    
    this.useTenantDefaultForPriceChange = useTenantDefaultForPriceChange;
  }


  public GETProductRatePlanChargeTypeAllOf validityPeriodType(ValidityPeriodTypeEnum validityPeriodType) {
    
    
    
    
    this.validityPeriodType = validityPeriodType;
    return this;
  }

   /**
   * **Note**: This field is only available if you have the [Prepaid with Drawdown](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/J_Billing_Operations/Prepaid_with_Drawdown) feature enabled.  The period in which the prepayment units are valid to use as defined in a [prepayment charge](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/J_Billing_Operations/Prepaid_with_Drawdown/Create_prepayment_charge). 
   * @return validityPeriodType
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "**Note**: This field is only available if you have the [Prepaid with Drawdown](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/J_Billing_Operations/Prepaid_with_Drawdown) feature enabled.  The period in which the prepayment units are valid to use as defined in a [prepayment charge](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/J_Billing_Operations/Prepaid_with_Drawdown/Create_prepayment_charge). ")

  public ValidityPeriodTypeEnum getValidityPeriodType() {
    return validityPeriodType;
  }


  public void setValidityPeriodType(ValidityPeriodTypeEnum validityPeriodType) {
    
    
    
    this.validityPeriodType = validityPeriodType;
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
   * @return the GETProductRatePlanChargeTypeAllOf instance itself
   */
  public GETProductRatePlanChargeTypeAllOf putAdditionalProperty(String key, Object value) {
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
    GETProductRatePlanChargeTypeAllOf geTProductRatePlanChargeTypeAllOf = (GETProductRatePlanChargeTypeAllOf) o;
    return Objects.equals(this.description, geTProductRatePlanChargeTypeAllOf.description) &&
        Objects.equals(this.applyDiscountTo, geTProductRatePlanChargeTypeAllOf.applyDiscountTo) &&
        Objects.equals(this.billingDay, geTProductRatePlanChargeTypeAllOf.billingDay) &&
        Objects.equals(this.billingPeriod, geTProductRatePlanChargeTypeAllOf.billingPeriod) &&
        Objects.equals(this.billingPeriodAlignment, geTProductRatePlanChargeTypeAllOf.billingPeriodAlignment) &&
        Objects.equals(this.billingTiming, geTProductRatePlanChargeTypeAllOf.billingTiming) &&
        Objects.equals(this.chargeModelConfigurations, geTProductRatePlanChargeTypeAllOf.chargeModelConfigurations) &&
        Objects.equals(this.creditOption, geTProductRatePlanChargeTypeAllOf.creditOption) &&
        Objects.equals(this.defaultQuantity, geTProductRatePlanChargeTypeAllOf.defaultQuantity) &&
        Objects.equals(this.deliverySchedule, geTProductRatePlanChargeTypeAllOf.deliverySchedule) &&
        Objects.equals(this.discountClass, geTProductRatePlanChargeTypeAllOf.discountClass) &&
        Objects.equals(this.discountLevel, geTProductRatePlanChargeTypeAllOf.discountLevel) &&
        Objects.equals(this.drawdownRate, geTProductRatePlanChargeTypeAllOf.drawdownRate) &&
        Objects.equals(this.drawdownUom, geTProductRatePlanChargeTypeAllOf.drawdownUom) &&
        Objects.equals(this.endDateCondition, geTProductRatePlanChargeTypeAllOf.endDateCondition) &&
        Objects.equals(this.excludeItemBillingFromRevenueAccounting, geTProductRatePlanChargeTypeAllOf.excludeItemBillingFromRevenueAccounting) &&
        Objects.equals(this.excludeItemBookingFromRevenueAccounting, geTProductRatePlanChargeTypeAllOf.excludeItemBookingFromRevenueAccounting) &&
        Objects.equals(this.financeInformation, geTProductRatePlanChargeTypeAllOf.financeInformation) &&
        Objects.equals(this.formula, geTProductRatePlanChargeTypeAllOf.formula) &&
        Objects.equals(this.id, geTProductRatePlanChargeTypeAllOf.id) &&
        Objects.equals(this.includedUnits, geTProductRatePlanChargeTypeAllOf.includedUnits) &&
        Objects.equals(this.isAllocationEligible, geTProductRatePlanChargeTypeAllOf.isAllocationEligible) &&
        Objects.equals(this.isPrepaid, geTProductRatePlanChargeTypeAllOf.isPrepaid) &&
        Objects.equals(this.isRollover, geTProductRatePlanChargeTypeAllOf.isRollover) &&
        Objects.equals(this.isStackedDiscount, geTProductRatePlanChargeTypeAllOf.isStackedDiscount) &&
        Objects.equals(this.isUnbilled, geTProductRatePlanChargeTypeAllOf.isUnbilled) &&
        Objects.equals(this.listPriceBase, geTProductRatePlanChargeTypeAllOf.listPriceBase) &&
        Objects.equals(this.maxQuantity, geTProductRatePlanChargeTypeAllOf.maxQuantity) &&
        Objects.equals(this.minQuantity, geTProductRatePlanChargeTypeAllOf.minQuantity) &&
        Objects.equals(this.model, geTProductRatePlanChargeTypeAllOf.model) &&
        Objects.equals(this.name, geTProductRatePlanChargeTypeAllOf.name) &&
        Objects.equals(this.numberOfPeriods, geTProductRatePlanChargeTypeAllOf.numberOfPeriods) &&
        Objects.equals(this.overageCalculationOption, geTProductRatePlanChargeTypeAllOf.overageCalculationOption) &&
        Objects.equals(this.overageUnusedUnitsCreditOption, geTProductRatePlanChargeTypeAllOf.overageUnusedUnitsCreditOption) &&
        Objects.equals(this.prepaidOperationType, geTProductRatePlanChargeTypeAllOf.prepaidOperationType) &&
        Objects.equals(this.prepaidQuantity, geTProductRatePlanChargeTypeAllOf.prepaidQuantity) &&
        Objects.equals(this.prepaidTotalQuantity, geTProductRatePlanChargeTypeAllOf.prepaidTotalQuantity) &&
        Objects.equals(this.prepaidUom, geTProductRatePlanChargeTypeAllOf.prepaidUom) &&
        Objects.equals(this.prepayPeriods, geTProductRatePlanChargeTypeAllOf.prepayPeriods) &&
        Objects.equals(this.priceChangeOption, geTProductRatePlanChargeTypeAllOf.priceChangeOption) &&
        Objects.equals(this.priceIncreasePercentage, geTProductRatePlanChargeTypeAllOf.priceIncreasePercentage) &&
        Objects.equals(this.pricing, geTProductRatePlanChargeTypeAllOf.pricing) &&
        Objects.equals(this.pricingSummary, geTProductRatePlanChargeTypeAllOf.pricingSummary) &&
        Objects.equals(this.productChargeDefinitions, geTProductRatePlanChargeTypeAllOf.productChargeDefinitions) &&
        Objects.equals(this.productDiscountApplyDetails, geTProductRatePlanChargeTypeAllOf.productDiscountApplyDetails) &&
        Objects.equals(this.productRatePlanChargeNumber, geTProductRatePlanChargeTypeAllOf.productRatePlanChargeNumber) &&
        Objects.equals(this.ratingGroup, geTProductRatePlanChargeTypeAllOf.ratingGroup) &&
        Objects.equals(this.revRecCode, geTProductRatePlanChargeTypeAllOf.revRecCode) &&
        Objects.equals(this.revRecTriggerCondition, geTProductRatePlanChargeTypeAllOf.revRecTriggerCondition) &&
        Objects.equals(this.revenueRecognitionRuleName, geTProductRatePlanChargeTypeAllOf.revenueRecognitionRuleName) &&
        Objects.equals(this.rolloverApply, geTProductRatePlanChargeTypeAllOf.rolloverApply) &&
        Objects.equals(this.rolloverPeriodLength, geTProductRatePlanChargeTypeAllOf.rolloverPeriodLength) &&
        Objects.equals(this.rolloverPeriods, geTProductRatePlanChargeTypeAllOf.rolloverPeriods) &&
        Objects.equals(this.smoothingModel, geTProductRatePlanChargeTypeAllOf.smoothingModel) &&
        Objects.equals(this.specificBillingPeriod, geTProductRatePlanChargeTypeAllOf.specificBillingPeriod) &&
        Objects.equals(this.specificListPriceBase, geTProductRatePlanChargeTypeAllOf.specificListPriceBase) &&
        Objects.equals(this.taxCode, geTProductRatePlanChargeTypeAllOf.taxCode) &&
        Objects.equals(this.taxMode, geTProductRatePlanChargeTypeAllOf.taxMode) &&
        Objects.equals(this.taxable, geTProductRatePlanChargeTypeAllOf.taxable) &&
        Objects.equals(this.triggerEvent, geTProductRatePlanChargeTypeAllOf.triggerEvent) &&
        Objects.equals(this.type, geTProductRatePlanChargeTypeAllOf.type) &&
        Objects.equals(this.uom, geTProductRatePlanChargeTypeAllOf.uom) &&
        Objects.equals(this.upToPeriods, geTProductRatePlanChargeTypeAllOf.upToPeriods) &&
        Objects.equals(this.upToPeriodsType, geTProductRatePlanChargeTypeAllOf.upToPeriodsType) &&
        Objects.equals(this.usageRecordRatingOption, geTProductRatePlanChargeTypeAllOf.usageRecordRatingOption) &&
        Objects.equals(this.useDiscountSpecificAccountingCode, geTProductRatePlanChargeTypeAllOf.useDiscountSpecificAccountingCode) &&
        Objects.equals(this.useTenantDefaultForPriceChange, geTProductRatePlanChargeTypeAllOf.useTenantDefaultForPriceChange) &&
        Objects.equals(this.validityPeriodType, geTProductRatePlanChargeTypeAllOf.validityPeriodType)&&
        Objects.equals(this.additionalProperties, geTProductRatePlanChargeTypeAllOf.additionalProperties);
  }

  private static <T> boolean equalsNullable(JsonNullable<T> a, JsonNullable<T> b) {
    return a == b || (a != null && b != null && a.isPresent() && b.isPresent() && Objects.deepEquals(a.get(), b.get()));
  }

  @Override
  public int hashCode() {
    return Objects.hash(description, applyDiscountTo, billingDay, billingPeriod, billingPeriodAlignment, billingTiming, chargeModelConfigurations, creditOption, defaultQuantity, deliverySchedule, discountClass, discountLevel, drawdownRate, drawdownUom, endDateCondition, excludeItemBillingFromRevenueAccounting, excludeItemBookingFromRevenueAccounting, financeInformation, formula, id, includedUnits, isAllocationEligible, isPrepaid, isRollover, isStackedDiscount, isUnbilled, listPriceBase, maxQuantity, minQuantity, model, name, numberOfPeriods, overageCalculationOption, overageUnusedUnitsCreditOption, prepaidOperationType, prepaidQuantity, prepaidTotalQuantity, prepaidUom, prepayPeriods, priceChangeOption, priceIncreasePercentage, pricing, pricingSummary, productChargeDefinitions, productDiscountApplyDetails, productRatePlanChargeNumber, ratingGroup, revRecCode, revRecTriggerCondition, revenueRecognitionRuleName, rolloverApply, rolloverPeriodLength, rolloverPeriods, smoothingModel, specificBillingPeriod, specificListPriceBase, taxCode, taxMode, taxable, triggerEvent, type, uom, upToPeriods, upToPeriodsType, usageRecordRatingOption, useDiscountSpecificAccountingCode, useTenantDefaultForPriceChange, validityPeriodType, additionalProperties);
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
    sb.append("class GETProductRatePlanChargeTypeAllOf {\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    applyDiscountTo: ").append(toIndentedString(applyDiscountTo)).append("\n");
    sb.append("    billingDay: ").append(toIndentedString(billingDay)).append("\n");
    sb.append("    billingPeriod: ").append(toIndentedString(billingPeriod)).append("\n");
    sb.append("    billingPeriodAlignment: ").append(toIndentedString(billingPeriodAlignment)).append("\n");
    sb.append("    billingTiming: ").append(toIndentedString(billingTiming)).append("\n");
    sb.append("    chargeModelConfigurations: ").append(toIndentedString(chargeModelConfigurations)).append("\n");
    sb.append("    creditOption: ").append(toIndentedString(creditOption)).append("\n");
    sb.append("    defaultQuantity: ").append(toIndentedString(defaultQuantity)).append("\n");
    sb.append("    deliverySchedule: ").append(toIndentedString(deliverySchedule)).append("\n");
    sb.append("    discountClass: ").append(toIndentedString(discountClass)).append("\n");
    sb.append("    discountLevel: ").append(toIndentedString(discountLevel)).append("\n");
    sb.append("    drawdownRate: ").append(toIndentedString(drawdownRate)).append("\n");
    sb.append("    drawdownUom: ").append(toIndentedString(drawdownUom)).append("\n");
    sb.append("    endDateCondition: ").append(toIndentedString(endDateCondition)).append("\n");
    sb.append("    excludeItemBillingFromRevenueAccounting: ").append(toIndentedString(excludeItemBillingFromRevenueAccounting)).append("\n");
    sb.append("    excludeItemBookingFromRevenueAccounting: ").append(toIndentedString(excludeItemBookingFromRevenueAccounting)).append("\n");
    sb.append("    financeInformation: ").append(toIndentedString(financeInformation)).append("\n");
    sb.append("    formula: ").append(toIndentedString(formula)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    includedUnits: ").append(toIndentedString(includedUnits)).append("\n");
    sb.append("    isAllocationEligible: ").append(toIndentedString(isAllocationEligible)).append("\n");
    sb.append("    isPrepaid: ").append(toIndentedString(isPrepaid)).append("\n");
    sb.append("    isRollover: ").append(toIndentedString(isRollover)).append("\n");
    sb.append("    isStackedDiscount: ").append(toIndentedString(isStackedDiscount)).append("\n");
    sb.append("    isUnbilled: ").append(toIndentedString(isUnbilled)).append("\n");
    sb.append("    listPriceBase: ").append(toIndentedString(listPriceBase)).append("\n");
    sb.append("    maxQuantity: ").append(toIndentedString(maxQuantity)).append("\n");
    sb.append("    minQuantity: ").append(toIndentedString(minQuantity)).append("\n");
    sb.append("    model: ").append(toIndentedString(model)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    numberOfPeriods: ").append(toIndentedString(numberOfPeriods)).append("\n");
    sb.append("    overageCalculationOption: ").append(toIndentedString(overageCalculationOption)).append("\n");
    sb.append("    overageUnusedUnitsCreditOption: ").append(toIndentedString(overageUnusedUnitsCreditOption)).append("\n");
    sb.append("    prepaidOperationType: ").append(toIndentedString(prepaidOperationType)).append("\n");
    sb.append("    prepaidQuantity: ").append(toIndentedString(prepaidQuantity)).append("\n");
    sb.append("    prepaidTotalQuantity: ").append(toIndentedString(prepaidTotalQuantity)).append("\n");
    sb.append("    prepaidUom: ").append(toIndentedString(prepaidUom)).append("\n");
    sb.append("    prepayPeriods: ").append(toIndentedString(prepayPeriods)).append("\n");
    sb.append("    priceChangeOption: ").append(toIndentedString(priceChangeOption)).append("\n");
    sb.append("    priceIncreasePercentage: ").append(toIndentedString(priceIncreasePercentage)).append("\n");
    sb.append("    pricing: ").append(toIndentedString(pricing)).append("\n");
    sb.append("    pricingSummary: ").append(toIndentedString(pricingSummary)).append("\n");
    sb.append("    productChargeDefinitions: ").append(toIndentedString(productChargeDefinitions)).append("\n");
    sb.append("    productDiscountApplyDetails: ").append(toIndentedString(productDiscountApplyDetails)).append("\n");
    sb.append("    productRatePlanChargeNumber: ").append(toIndentedString(productRatePlanChargeNumber)).append("\n");
    sb.append("    ratingGroup: ").append(toIndentedString(ratingGroup)).append("\n");
    sb.append("    revRecCode: ").append(toIndentedString(revRecCode)).append("\n");
    sb.append("    revRecTriggerCondition: ").append(toIndentedString(revRecTriggerCondition)).append("\n");
    sb.append("    revenueRecognitionRuleName: ").append(toIndentedString(revenueRecognitionRuleName)).append("\n");
    sb.append("    rolloverApply: ").append(toIndentedString(rolloverApply)).append("\n");
    sb.append("    rolloverPeriodLength: ").append(toIndentedString(rolloverPeriodLength)).append("\n");
    sb.append("    rolloverPeriods: ").append(toIndentedString(rolloverPeriods)).append("\n");
    sb.append("    smoothingModel: ").append(toIndentedString(smoothingModel)).append("\n");
    sb.append("    specificBillingPeriod: ").append(toIndentedString(specificBillingPeriod)).append("\n");
    sb.append("    specificListPriceBase: ").append(toIndentedString(specificListPriceBase)).append("\n");
    sb.append("    taxCode: ").append(toIndentedString(taxCode)).append("\n");
    sb.append("    taxMode: ").append(toIndentedString(taxMode)).append("\n");
    sb.append("    taxable: ").append(toIndentedString(taxable)).append("\n");
    sb.append("    triggerEvent: ").append(toIndentedString(triggerEvent)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    uom: ").append(toIndentedString(uom)).append("\n");
    sb.append("    upToPeriods: ").append(toIndentedString(upToPeriods)).append("\n");
    sb.append("    upToPeriodsType: ").append(toIndentedString(upToPeriodsType)).append("\n");
    sb.append("    usageRecordRatingOption: ").append(toIndentedString(usageRecordRatingOption)).append("\n");
    sb.append("    useDiscountSpecificAccountingCode: ").append(toIndentedString(useDiscountSpecificAccountingCode)).append("\n");
    sb.append("    useTenantDefaultForPriceChange: ").append(toIndentedString(useTenantDefaultForPriceChange)).append("\n");
    sb.append("    validityPeriodType: ").append(toIndentedString(validityPeriodType)).append("\n");
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
    openapiFields.add("chargeModelConfigurations");
    openapiFields.add("creditOption");
    openapiFields.add("defaultQuantity");
    openapiFields.add("deliverySchedule");
    openapiFields.add("discountClass");
    openapiFields.add("discountLevel");
    openapiFields.add("drawdownRate");
    openapiFields.add("drawdownUom");
    openapiFields.add("endDateCondition");
    openapiFields.add("excludeItemBillingFromRevenueAccounting");
    openapiFields.add("excludeItemBookingFromRevenueAccounting");
    openapiFields.add("financeInformation");
    openapiFields.add("formula");
    openapiFields.add("id");
    openapiFields.add("includedUnits");
    openapiFields.add("isAllocationEligible");
    openapiFields.add("isPrepaid");
    openapiFields.add("isRollover");
    openapiFields.add("isStackedDiscount");
    openapiFields.add("isUnbilled");
    openapiFields.add("listPriceBase");
    openapiFields.add("maxQuantity");
    openapiFields.add("minQuantity");
    openapiFields.add("model");
    openapiFields.add("name");
    openapiFields.add("numberOfPeriods");
    openapiFields.add("overageCalculationOption");
    openapiFields.add("overageUnusedUnitsCreditOption");
    openapiFields.add("prepaidOperationType");
    openapiFields.add("prepaidQuantity");
    openapiFields.add("prepaidTotalQuantity");
    openapiFields.add("prepaidUom");
    openapiFields.add("prepayPeriods");
    openapiFields.add("priceChangeOption");
    openapiFields.add("priceIncreasePercentage");
    openapiFields.add("pricing");
    openapiFields.add("pricingSummary");
    openapiFields.add("productChargeDefinitions");
    openapiFields.add("productDiscountApplyDetails");
    openapiFields.add("productRatePlanChargeNumber");
    openapiFields.add("ratingGroup");
    openapiFields.add("revRecCode");
    openapiFields.add("revRecTriggerCondition");
    openapiFields.add("revenueRecognitionRuleName");
    openapiFields.add("rolloverApply");
    openapiFields.add("rolloverPeriodLength");
    openapiFields.add("rolloverPeriods");
    openapiFields.add("smoothingModel");
    openapiFields.add("specificBillingPeriod");
    openapiFields.add("specificListPriceBase");
    openapiFields.add("taxCode");
    openapiFields.add("taxMode");
    openapiFields.add("taxable");
    openapiFields.add("triggerEvent");
    openapiFields.add("type");
    openapiFields.add("uom");
    openapiFields.add("upToPeriods");
    openapiFields.add("upToPeriodsType");
    openapiFields.add("usageRecordRatingOption");
    openapiFields.add("useDiscountSpecificAccountingCode");
    openapiFields.add("useTenantDefaultForPriceChange");
    openapiFields.add("validityPeriodType");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
  }

 /**
  * Validates the JSON Object and throws an exception if issues found
  *
  * @param jsonObj JSON Object
  * @throws IOException if the JSON Object is invalid with respect to GETProductRatePlanChargeTypeAllOf
  */
  public static void validateJsonObject(JsonObject jsonObj) throws IOException {
      if (jsonObj == null) {
        if (!GETProductRatePlanChargeTypeAllOf.openapiRequiredFields.isEmpty()) { // has required fields but JSON object is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in GETProductRatePlanChargeTypeAllOf is not found in the empty JSON string", GETProductRatePlanChargeTypeAllOf.openapiRequiredFields.toString()));
        }
      }
      if ((jsonObj.get("description") != null && !jsonObj.get("description").isJsonNull()) && !jsonObj.get("description").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `description` to be a primitive type in the JSON string but got `%s`", jsonObj.get("description").toString()));
      }
      if ((jsonObj.get("applyDiscountTo") != null && !jsonObj.get("applyDiscountTo").isJsonNull()) && !jsonObj.get("applyDiscountTo").isJsonPrimitive()) {
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
      if ((jsonObj.get("creditOption") != null && !jsonObj.get("creditOption").isJsonNull()) && !jsonObj.get("creditOption").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `creditOption` to be a primitive type in the JSON string but got `%s`", jsonObj.get("creditOption").toString()));
      }
      if (!jsonObj.get("defaultQuantity").isJsonNull() && (jsonObj.get("defaultQuantity") != null && !jsonObj.get("defaultQuantity").isJsonNull()) && !jsonObj.get("defaultQuantity").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `defaultQuantity` to be a primitive type in the JSON string but got `%s`", jsonObj.get("defaultQuantity").toString()));
      }
      // validate the optional field `deliverySchedule`
      if (jsonObj.get("deliverySchedule") != null && !jsonObj.get("deliverySchedule").isJsonNull()) {
        GETProductRatePlanChargeDeliverySchedule.validateJsonObject(jsonObj.getAsJsonObject("deliverySchedule"));
      }
      if (!jsonObj.get("discountClass").isJsonNull() && (jsonObj.get("discountClass") != null && !jsonObj.get("discountClass").isJsonNull()) && !jsonObj.get("discountClass").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `discountClass` to be a primitive type in the JSON string but got `%s`", jsonObj.get("discountClass").toString()));
      }
      if (!jsonObj.get("discountLevel").isJsonNull() && (jsonObj.get("discountLevel") != null && !jsonObj.get("discountLevel").isJsonNull()) && !jsonObj.get("discountLevel").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `discountLevel` to be a primitive type in the JSON string but got `%s`", jsonObj.get("discountLevel").toString()));
      }
      if ((jsonObj.get("drawdownUom") != null && !jsonObj.get("drawdownUom").isJsonNull()) && !jsonObj.get("drawdownUom").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `drawdownUom` to be a primitive type in the JSON string but got `%s`", jsonObj.get("drawdownUom").toString()));
      }
      if ((jsonObj.get("endDateCondition") != null && !jsonObj.get("endDateCondition").isJsonNull()) && !jsonObj.get("endDateCondition").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `endDateCondition` to be a primitive type in the JSON string but got `%s`", jsonObj.get("endDateCondition").toString()));
      }
      // validate the optional field `financeInformation`
      if (jsonObj.get("financeInformation") != null && !jsonObj.get("financeInformation").isJsonNull()) {
        FinanceInformation.validateJsonObject(jsonObj.getAsJsonObject("financeInformation"));
      }
      if ((jsonObj.get("formula") != null && !jsonObj.get("formula").isJsonNull()) && !jsonObj.get("formula").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `formula` to be a primitive type in the JSON string but got `%s`", jsonObj.get("formula").toString()));
      }
      if ((jsonObj.get("id") != null && !jsonObj.get("id").isJsonNull()) && !jsonObj.get("id").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `id` to be a primitive type in the JSON string but got `%s`", jsonObj.get("id").toString()));
      }
      if ((jsonObj.get("includedUnits") != null && !jsonObj.get("includedUnits").isJsonNull()) && !jsonObj.get("includedUnits").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `includedUnits` to be a primitive type in the JSON string but got `%s`", jsonObj.get("includedUnits").toString()));
      }
      if ((jsonObj.get("listPriceBase") != null && !jsonObj.get("listPriceBase").isJsonNull()) && !jsonObj.get("listPriceBase").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `listPriceBase` to be a primitive type in the JSON string but got `%s`", jsonObj.get("listPriceBase").toString()));
      }
      if ((jsonObj.get("maxQuantity") != null && !jsonObj.get("maxQuantity").isJsonNull()) && !jsonObj.get("maxQuantity").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `maxQuantity` to be a primitive type in the JSON string but got `%s`", jsonObj.get("maxQuantity").toString()));
      }
      if ((jsonObj.get("minQuantity") != null && !jsonObj.get("minQuantity").isJsonNull()) && !jsonObj.get("minQuantity").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `minQuantity` to be a primitive type in the JSON string but got `%s`", jsonObj.get("minQuantity").toString()));
      }
      if ((jsonObj.get("model") != null && !jsonObj.get("model").isJsonNull()) && !jsonObj.get("model").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `model` to be a primitive type in the JSON string but got `%s`", jsonObj.get("model").toString()));
      }
      if ((jsonObj.get("name") != null && !jsonObj.get("name").isJsonNull()) && !jsonObj.get("name").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `name` to be a primitive type in the JSON string but got `%s`", jsonObj.get("name").toString()));
      }
      if (!jsonObj.get("overageCalculationOption").isJsonNull() && (jsonObj.get("overageCalculationOption") != null && !jsonObj.get("overageCalculationOption").isJsonNull()) && !jsonObj.get("overageCalculationOption").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `overageCalculationOption` to be a primitive type in the JSON string but got `%s`", jsonObj.get("overageCalculationOption").toString()));
      }
      if (!jsonObj.get("overageUnusedUnitsCreditOption").isJsonNull() && (jsonObj.get("overageUnusedUnitsCreditOption") != null && !jsonObj.get("overageUnusedUnitsCreditOption").isJsonNull()) && !jsonObj.get("overageUnusedUnitsCreditOption").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `overageUnusedUnitsCreditOption` to be a primitive type in the JSON string but got `%s`", jsonObj.get("overageUnusedUnitsCreditOption").toString()));
      }
      if (!jsonObj.get("prepaidOperationType").isJsonNull() && (jsonObj.get("prepaidOperationType") != null && !jsonObj.get("prepaidOperationType").isJsonNull()) && !jsonObj.get("prepaidOperationType").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `prepaidOperationType` to be a primitive type in the JSON string but got `%s`", jsonObj.get("prepaidOperationType").toString()));
      }
      if (!jsonObj.get("prepaidUom").isJsonNull() && (jsonObj.get("prepaidUom") != null && !jsonObj.get("prepaidUom").isJsonNull()) && !jsonObj.get("prepaidUom").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `prepaidUom` to be a primitive type in the JSON string but got `%s`", jsonObj.get("prepaidUom").toString()));
      }
      if (!jsonObj.get("priceChangeOption").isJsonNull() && (jsonObj.get("priceChangeOption") != null && !jsonObj.get("priceChangeOption").isJsonNull()) && !jsonObj.get("priceChangeOption").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `priceChangeOption` to be a primitive type in the JSON string but got `%s`", jsonObj.get("priceChangeOption").toString()));
      }
      if (!jsonObj.get("priceIncreasePercentage").isJsonNull() && (jsonObj.get("priceIncreasePercentage") != null && !jsonObj.get("priceIncreasePercentage").isJsonNull()) && !jsonObj.get("priceIncreasePercentage").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `priceIncreasePercentage` to be a primitive type in the JSON string but got `%s`", jsonObj.get("priceIncreasePercentage").toString()));
      }
      if (jsonObj.get("pricing") != null && !jsonObj.get("pricing").isJsonNull()) {
        JsonArray jsonArraypricing = jsonObj.getAsJsonArray("pricing");
        if (jsonArraypricing != null) {
          // ensure the json data is an array
          if (!jsonObj.get("pricing").isJsonArray()) {
            throw new IllegalArgumentException(String.format("Expected the field `pricing` to be an array in the JSON string but got `%s`", jsonObj.get("pricing").toString()));
          }

          // validate the optional field `pricing` (array)
          for (int i = 0; i < jsonArraypricing.size(); i++) {
            GETProductRatePlanChargePricingType.validateJsonObject(jsonArraypricing.get(i).getAsJsonObject());
          };
        }
      }
      // ensure the optional json data is an array if present
      if (jsonObj.get("pricingSummary") != null && !jsonObj.get("pricingSummary").isJsonArray()) {
        throw new IllegalArgumentException(String.format("Expected the field `pricingSummary` to be an array in the JSON string but got `%s`", jsonObj.get("pricingSummary").toString()));
      }
      if ((jsonObj.get("productChargeDefinitions") != null && !jsonObj.get("productChargeDefinitions").isJsonNull()) && !jsonObj.get("productChargeDefinitions").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `productChargeDefinitions` to be a primitive type in the JSON string but got `%s`", jsonObj.get("productChargeDefinitions").toString()));
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
      if ((jsonObj.get("productRatePlanChargeNumber") != null && !jsonObj.get("productRatePlanChargeNumber").isJsonNull()) && !jsonObj.get("productRatePlanChargeNumber").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `productRatePlanChargeNumber` to be a primitive type in the JSON string but got `%s`", jsonObj.get("productRatePlanChargeNumber").toString()));
      }
      if (!jsonObj.get("ratingGroup").isJsonNull() && (jsonObj.get("ratingGroup") != null && !jsonObj.get("ratingGroup").isJsonNull()) && !jsonObj.get("ratingGroup").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `ratingGroup` to be a primitive type in the JSON string but got `%s`", jsonObj.get("ratingGroup").toString()));
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
      if ((jsonObj.get("rolloverApply") != null && !jsonObj.get("rolloverApply").isJsonNull()) && !jsonObj.get("rolloverApply").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `rolloverApply` to be a primitive type in the JSON string but got `%s`", jsonObj.get("rolloverApply").toString()));
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
      if ((jsonObj.get("triggerEvent") != null && !jsonObj.get("triggerEvent").isJsonNull()) && !jsonObj.get("triggerEvent").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `triggerEvent` to be a primitive type in the JSON string but got `%s`", jsonObj.get("triggerEvent").toString()));
      }
      if ((jsonObj.get("type") != null && !jsonObj.get("type").isJsonNull()) && !jsonObj.get("type").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `type` to be a primitive type in the JSON string but got `%s`", jsonObj.get("type").toString()));
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
      if ((jsonObj.get("validityPeriodType") != null && !jsonObj.get("validityPeriodType").isJsonNull()) && !jsonObj.get("validityPeriodType").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `validityPeriodType` to be a primitive type in the JSON string but got `%s`", jsonObj.get("validityPeriodType").toString()));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!GETProductRatePlanChargeTypeAllOf.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'GETProductRatePlanChargeTypeAllOf' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<GETProductRatePlanChargeTypeAllOf> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(GETProductRatePlanChargeTypeAllOf.class));

       return (TypeAdapter<T>) new TypeAdapter<GETProductRatePlanChargeTypeAllOf>() {
           @Override
           public void write(JsonWriter out, GETProductRatePlanChargeTypeAllOf value) throws IOException {
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
           public GETProductRatePlanChargeTypeAllOf read(JsonReader in) throws IOException {
             JsonObject jsonObj = elementAdapter.read(in).getAsJsonObject();
             validateJsonObject(jsonObj);
             // store additional fields in the deserialized instance
             GETProductRatePlanChargeTypeAllOf instance = thisAdapter.fromJsonTree(jsonObj);
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
  * Create an instance of GETProductRatePlanChargeTypeAllOf given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of GETProductRatePlanChargeTypeAllOf
  * @throws IOException if the JSON string is invalid with respect to GETProductRatePlanChargeTypeAllOf
  */
  public static GETProductRatePlanChargeTypeAllOf fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, GETProductRatePlanChargeTypeAllOf.class);
  }

 /**
  * Convert an instance of GETProductRatePlanChargeTypeAllOf to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

