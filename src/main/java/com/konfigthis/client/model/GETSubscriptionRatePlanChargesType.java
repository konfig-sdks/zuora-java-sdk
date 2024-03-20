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
import com.konfigthis.client.model.ChargeModelConfigurationType;
import com.konfigthis.client.model.GETDeliveryScheduleType;
import com.konfigthis.client.model.GETDiscountApplyDetailsType;
import com.konfigthis.client.model.GETIntervalPriceType;
import com.konfigthis.client.model.GETTierType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
import java.time.LocalDate;
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
 * GETSubscriptionRatePlanChargesType
 */@javax.annotation.Generated(value = "Generated by https://konfigthis.com")
public class GETSubscriptionRatePlanChargesType {
  public static final String SERIALIZED_NAME_DESCRIPTION = "description";
  @SerializedName(SERIALIZED_NAME_DESCRIPTION)
  private String description;

  public static final String SERIALIZED_NAME_VERSION = "version";
  @SerializedName(SERIALIZED_NAME_VERSION)
  private Long version;

  public static final String SERIALIZED_NAME_AMENDED_BY_ORDER_ON = "amendedByOrderOn";
  @SerializedName(SERIALIZED_NAME_AMENDED_BY_ORDER_ON)
  private String amendedByOrderOn;

  public static final String SERIALIZED_NAME_APPLY_DISCOUNT_TO = "applyDiscountTo";
  @SerializedName(SERIALIZED_NAME_APPLY_DISCOUNT_TO)
  private String applyDiscountTo;

  public static final String SERIALIZED_NAME_APPLY_TO_BILLING_PERIOD_PARTIALLY = "applyToBillingPeriodPartially";
  @SerializedName(SERIALIZED_NAME_APPLY_TO_BILLING_PERIOD_PARTIALLY)
  private Boolean applyToBillingPeriodPartially;

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

  /**
   * **Note**: This field is only available if you have the &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Bill_your_customers/Bill_for_usage_or_prepaid_products/Advanced_Consumption_Billing/Unbilled_Usage\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Unbilled Usage&lt;/a&gt; feature enabled.  To use this field, you must set the &#x60;X-Zuora-WSDL-Version&#x60; request header to &#x60;141&#x60; or higher. Otherwise, an error occurs.  This field defines what type of charge it is in Advanced Consumption Billing: * Standard: Normal charge with no Prepayment or Commitment or Drawdown. * Prepayment: For recurring charges. Unit or currency based prepaid charge. * CommitmentTrueUp: For recurring charges. Currency based minimum commitment charge. * Drawdown: For usage charges. Drawdown from prepaid funds. * DrawdownAndCreditCommitment: For usage charges. Drawdown from prepaid funds and then credit to minimum commitment funds. * CreditCommitment: For usage charges. Credit to minimum commitment funds. 
   */
  @JsonAdapter(ChargeFunctionEnum.Adapter.class)
 public enum ChargeFunctionEnum {
    STANDARD("Standard"),
    
    PREPAYMENT("Prepayment"),
    
    COMMITMENTTRUEUP("CommitmentTrueUp"),
    
    DRAWDOWN("Drawdown"),
    
    CREDITCOMMITMENT("CreditCommitment"),
    
    DRAWDOWNANDCREDITCOMMITMENT("DrawdownAndCreditCommitment");

    private String value;

    ChargeFunctionEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static ChargeFunctionEnum fromValue(String value) {
      for (ChargeFunctionEnum b : ChargeFunctionEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<ChargeFunctionEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final ChargeFunctionEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public ChargeFunctionEnum read(final JsonReader jsonReader) throws IOException {
        String value =  jsonReader.nextString();
        return ChargeFunctionEnum.fromValue(value);
      }
    }
  }

  public static final String SERIALIZED_NAME_CHARGE_FUNCTION = "chargeFunction";
  @SerializedName(SERIALIZED_NAME_CHARGE_FUNCTION)
  private ChargeFunctionEnum chargeFunction;

  /**
   * **Note**: This field is only available if you have the &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Bill_your_customers/Bill_for_usage_or_prepaid_products/Advanced_Consumption_Billing/Unbilled_Usage\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Unbilled Usage&lt;/a&gt; feature enabled.  To use this field, you must set the &#x60;X-Zuora-WSDL-Version&#x60; request header to &#x60;133&#x60; or higher. Otherwise, an error occurs.   This field defines the type of commitment. A prepaid charge can be &#x60;UNIT&#x60; or &#x60;CURRENCY&#x60;. A minimum commitment(in-arrears) charge can only be &#x60;CURRENCY&#x60; type. For topup(recurring or one-time) charges, this field indicates what type of funds are created.  * If UNIT, it will create a fund with given prepaidUom. * If CURRENCY, it will create a fund with the currency amount calculated in list price.    For drawdown(usage) charges, this field indicates what type of funds are drawdown from that created from topup charges. 
   */
  @JsonAdapter(CommitmentTypeEnum.Adapter.class)
 public enum CommitmentTypeEnum {
    UNIT("UNIT"),
    
    CURRENCY("CURRENCY");

    private String value;

    CommitmentTypeEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static CommitmentTypeEnum fromValue(String value) {
      for (CommitmentTypeEnum b : CommitmentTypeEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<CommitmentTypeEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final CommitmentTypeEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public CommitmentTypeEnum read(final JsonReader jsonReader) throws IOException {
        String value =  jsonReader.nextString();
        return CommitmentTypeEnum.fromValue(value);
      }
    }
  }

  public static final String SERIALIZED_NAME_COMMITMENT_TYPE = "commitmentType";
  @SerializedName(SERIALIZED_NAME_COMMITMENT_TYPE)
  private CommitmentTypeEnum commitmentType;

  public static final String SERIALIZED_NAME_CHARGE_MODEL_CONFIGURATION = "chargeModelConfiguration";
  @SerializedName(SERIALIZED_NAME_CHARGE_MODEL_CONFIGURATION)
  private ChargeModelConfigurationType chargeModelConfiguration;

  public static final String SERIALIZED_NAME_CHARGED_THROUGH_DATE = "chargedThroughDate";
  @SerializedName(SERIALIZED_NAME_CHARGED_THROUGH_DATE)
  private LocalDate chargedThroughDate;

  /**
   * **Note**: This field is only available if you have the [Prepaid with Drawdown](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/J_Billing_Operations/Prepaid_with_Drawdown) feature enabled.  To use this field, you must set the &#x60;X-Zuora-WSDL-Version&#x60; request header to 114 or higher. Otherwise, an error occurs.  The way to calculate credit. See [Credit Option](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/J_Billing_Operations/Prepaid_with_Drawdown/Create_prepayment_charge#Credit_Option) for more information. 
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

  public static final String SERIALIZED_NAME_CURRENCY = "currency";
  @SerializedName(SERIALIZED_NAME_CURRENCY)
  private String currency;

  public static final String SERIALIZED_NAME_DISCOUNT_AMOUNT = "discountAmount";
  @SerializedName(SERIALIZED_NAME_DISCOUNT_AMOUNT)
  private Double discountAmount;

  public static final String SERIALIZED_NAME_DISCOUNT_APPLY_DETAILS = "discountApplyDetails";
  @SerializedName(SERIALIZED_NAME_DISCOUNT_APPLY_DETAILS)
  private List<GETDiscountApplyDetailsType> discountApplyDetails = null;

  public static final String SERIALIZED_NAME_DISCOUNT_CLASS = "discountClass";
  @SerializedName(SERIALIZED_NAME_DISCOUNT_CLASS)
  private String discountClass;

  public static final String SERIALIZED_NAME_DISCOUNT_LEVEL = "discountLevel";
  @SerializedName(SERIALIZED_NAME_DISCOUNT_LEVEL)
  private String discountLevel;

  public static final String SERIALIZED_NAME_DISCOUNT_PERCENTAGE = "discountPercentage";
  @SerializedName(SERIALIZED_NAME_DISCOUNT_PERCENTAGE)
  private Double discountPercentage;

  public static final String SERIALIZED_NAME_DMRC = "dmrc";
  @SerializedName(SERIALIZED_NAME_DMRC)
  private Double dmrc;

  public static final String SERIALIZED_NAME_DONE = "done";
  @SerializedName(SERIALIZED_NAME_DONE)
  private Boolean done;

  public static final String SERIALIZED_NAME_DRAWDOWN_RATE = "drawdownRate";
  @SerializedName(SERIALIZED_NAME_DRAWDOWN_RATE)
  private Double drawdownRate;

  public static final String SERIALIZED_NAME_DRAWDOWN_UOM = "drawdownUom";
  @SerializedName(SERIALIZED_NAME_DRAWDOWN_UOM)
  private String drawdownUom;

  public static final String SERIALIZED_NAME_DTCV = "dtcv";
  @SerializedName(SERIALIZED_NAME_DTCV)
  private Double dtcv;

  public static final String SERIALIZED_NAME_EFFECTIVE_END_DATE = "effectiveEndDate";
  @SerializedName(SERIALIZED_NAME_EFFECTIVE_END_DATE)
  private LocalDate effectiveEndDate;

  public static final String SERIALIZED_NAME_EFFECTIVE_START_DATE = "effectiveStartDate";
  @SerializedName(SERIALIZED_NAME_EFFECTIVE_START_DATE)
  private LocalDate effectiveStartDate;

  public static final String SERIALIZED_NAME_END_DATE_CONDITION = "endDateCondition";
  @SerializedName(SERIALIZED_NAME_END_DATE_CONDITION)
  private String endDateCondition;

  public static final String SERIALIZED_NAME_EXCLUDE_ITEM_BILLING_FROM_REVENUE_ACCOUNTING = "excludeItemBillingFromRevenueAccounting";
  @SerializedName(SERIALIZED_NAME_EXCLUDE_ITEM_BILLING_FROM_REVENUE_ACCOUNTING)
  private Boolean excludeItemBillingFromRevenueAccounting;

  public static final String SERIALIZED_NAME_EXCLUDE_ITEM_BOOKING_FROM_REVENUE_ACCOUNTING = "excludeItemBookingFromRevenueAccounting";
  @SerializedName(SERIALIZED_NAME_EXCLUDE_ITEM_BOOKING_FROM_REVENUE_ACCOUNTING)
  private Boolean excludeItemBookingFromRevenueAccounting;

  public static final String SERIALIZED_NAME_ID = "id";
  @SerializedName(SERIALIZED_NAME_ID)
  private String id;

  public static final String SERIALIZED_NAME_INCLUDED_UNITS = "includedUnits";
  @SerializedName(SERIALIZED_NAME_INCLUDED_UNITS)
  private Double includedUnits;

  public static final String SERIALIZED_NAME_INVOICE_SCHEDULE_ID = "invoiceScheduleId";
  @SerializedName(SERIALIZED_NAME_INVOICE_SCHEDULE_ID)
  private String invoiceScheduleId;

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

  public static final String SERIALIZED_NAME_LIST_PRICE_BASE = "listPriceBase";
  @SerializedName(SERIALIZED_NAME_LIST_PRICE_BASE)
  private String listPriceBase;

  public static final String SERIALIZED_NAME_MODEL = "model";
  @SerializedName(SERIALIZED_NAME_MODEL)
  private String model;

  public static final String SERIALIZED_NAME_MRR = "mrr";
  @SerializedName(SERIALIZED_NAME_MRR)
  private Double mrr;

  public static final String SERIALIZED_NAME_NAME = "name";
  @SerializedName(SERIALIZED_NAME_NAME)
  private String name;

  public static final String SERIALIZED_NAME_NUMBER = "number";
  @SerializedName(SERIALIZED_NAME_NUMBER)
  private String number;

  public static final String SERIALIZED_NAME_NUMBER_OF_DELIVERIES = "numberOfDeliveries";
  @SerializedName(SERIALIZED_NAME_NUMBER_OF_DELIVERIES)
  private Double numberOfDeliveries;

  public static final String SERIALIZED_NAME_NUMBER_OF_PERIODS = "numberOfPeriods";
  @SerializedName(SERIALIZED_NAME_NUMBER_OF_PERIODS)
  private Long numberOfPeriods;

  public static final String SERIALIZED_NAME_ORIGINAL_CHARGE_ID = "originalChargeId";
  @SerializedName(SERIALIZED_NAME_ORIGINAL_CHARGE_ID)
  private String originalChargeId;

  public static final String SERIALIZED_NAME_ORIGINAL_ORDER_DATE = "originalOrderDate";
  @SerializedName(SERIALIZED_NAME_ORIGINAL_ORDER_DATE)
  private LocalDate originalOrderDate;

  public static final String SERIALIZED_NAME_OVERAGE_CALCULATION_OPTION = "overageCalculationOption";
  @SerializedName(SERIALIZED_NAME_OVERAGE_CALCULATION_OPTION)
  private String overageCalculationOption;

  public static final String SERIALIZED_NAME_OVERAGE_PRICE = "overagePrice";
  @SerializedName(SERIALIZED_NAME_OVERAGE_PRICE)
  private Double overagePrice;

  public static final String SERIALIZED_NAME_OVERAGE_UNUSED_UNITS_CREDIT_OPTION = "overageUnusedUnitsCreditOption";
  @SerializedName(SERIALIZED_NAME_OVERAGE_UNUSED_UNITS_CREDIT_OPTION)
  private String overageUnusedUnitsCreditOption;

  /**
   * **Note**: This field is only available if you have the [Prepaid with Drawdown](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/J_Billing_Operations/Prepaid_with_Drawdown) feature enabled.  The type of this charge. It is either a prepayment (topup) charge or a drawdown charge.  
   */
  @JsonAdapter(PrepaidOperationTypeEnum.Adapter.class)
 public enum PrepaidOperationTypeEnum {
    TOPUP("topup"),
    
    DRAWDOWN("drawdown");

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
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
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

  public static final String SERIALIZED_NAME_PRICE = "price";
  @SerializedName(SERIALIZED_NAME_PRICE)
  private Double price;

  public static final String SERIALIZED_NAME_PRICE_CHANGE_OPTION = "priceChangeOption";
  @SerializedName(SERIALIZED_NAME_PRICE_CHANGE_OPTION)
  private String priceChangeOption;

  public static final String SERIALIZED_NAME_PRICE_INCREASE_PERCENTAGE = "priceIncreasePercentage";
  @SerializedName(SERIALIZED_NAME_PRICE_INCREASE_PERCENTAGE)
  private Double priceIncreasePercentage;

  public static final String SERIALIZED_NAME_PRICING_SUMMARY = "pricingSummary";
  @SerializedName(SERIALIZED_NAME_PRICING_SUMMARY)
  private String pricingSummary;

  public static final String SERIALIZED_NAME_PROCESSED_THROUGH_DATE = "processedThroughDate";
  @SerializedName(SERIALIZED_NAME_PROCESSED_THROUGH_DATE)
  private LocalDate processedThroughDate;

  public static final String SERIALIZED_NAME_PRODUCT_CATEGORY = "productCategory";
  @SerializedName(SERIALIZED_NAME_PRODUCT_CATEGORY)
  private String productCategory;

  public static final String SERIALIZED_NAME_PRODUCT_CLASS = "productClass";
  @SerializedName(SERIALIZED_NAME_PRODUCT_CLASS)
  private String productClass;

  public static final String SERIALIZED_NAME_PRODUCT_FAMILY = "productFamily";
  @SerializedName(SERIALIZED_NAME_PRODUCT_FAMILY)
  private String productFamily;

  public static final String SERIALIZED_NAME_PRODUCT_LINE = "productLine";
  @SerializedName(SERIALIZED_NAME_PRODUCT_LINE)
  private String productLine;

  public static final String SERIALIZED_NAME_PRODUCT_RATE_PLAN_CHARGE_ID = "productRatePlanChargeId";
  @SerializedName(SERIALIZED_NAME_PRODUCT_RATE_PLAN_CHARGE_ID)
  private String productRatePlanChargeId;

  public static final String SERIALIZED_NAME_QUANTITY = "quantity";
  @SerializedName(SERIALIZED_NAME_QUANTITY)
  private Double quantity;

  public static final String SERIALIZED_NAME_RATING_GROUP = "ratingGroup";
  @SerializedName(SERIALIZED_NAME_RATING_GROUP)
  private String ratingGroup;

  /**
   * Specifies the type of revenue recognition timing.  Predefined options are listed as enum values in this API Reference. Other options might also be avaliable depending on the &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Enable_Order_to_Revenue/Configure_revenue_settings/Configure_revenue_recognition_policy\&quot; target&#x3D;\&quot;_blank\&quot;&gt;revenue recognition policy configuration&lt;/a&gt; in the Zuora Billing UI.  **Note**: This field is only available if you have the Order to Revenue feature enabled.     
   */
  @JsonAdapter(RevenueRecognitionTimingEnum.Adapter.class)
 public enum RevenueRecognitionTimingEnum {
    BILLING_DOCUMENT_POSTING_DATE("Upon Billing Document Posting Date"),
    
    ORDER_ACTIVATION_DATE("Upon Order Activation Date");

    private String value;

    RevenueRecognitionTimingEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static RevenueRecognitionTimingEnum fromValue(String value) {
      for (RevenueRecognitionTimingEnum b : RevenueRecognitionTimingEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<RevenueRecognitionTimingEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final RevenueRecognitionTimingEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public RevenueRecognitionTimingEnum read(final JsonReader jsonReader) throws IOException {
        String value =  jsonReader.nextString();
        return RevenueRecognitionTimingEnum.fromValue(value);
      }
    }
  }

  public static final String SERIALIZED_NAME_REVENUE_RECOGNITION_TIMING = "revenueRecognitionTiming";
  @SerializedName(SERIALIZED_NAME_REVENUE_RECOGNITION_TIMING)
  private RevenueRecognitionTimingEnum revenueRecognitionTiming;

  /**
   * Specifies the type of revenue amortization method.  Predefined options are listed as enum values in this API Reference. Other options might also be avaliable depending on the &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Enable_Order_to_Revenue/Configure_revenue_settings/Configure_revenue_recognition_policy\&quot; target&#x3D;\&quot;_blank\&quot;&gt;revenue recognition policy configuration&lt;/a&gt; in the Zuora Billing UI.  **Note**: This field is only available if you have the Order to Revenue feature enabled.  
   */
  @JsonAdapter(RevenueAmortizationMethodEnum.Adapter.class)
 public enum RevenueAmortizationMethodEnum {
    IMMEDIATE("Immediate"),
    
    RATABLE_USING_START_AND_END_DATES("Ratable Using Start And End Dates");

    private String value;

    RevenueAmortizationMethodEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static RevenueAmortizationMethodEnum fromValue(String value) {
      for (RevenueAmortizationMethodEnum b : RevenueAmortizationMethodEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<RevenueAmortizationMethodEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final RevenueAmortizationMethodEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public RevenueAmortizationMethodEnum read(final JsonReader jsonReader) throws IOException {
        String value =  jsonReader.nextString();
        return RevenueAmortizationMethodEnum.fromValue(value);
      }
    }
  }

  public static final String SERIALIZED_NAME_REVENUE_AMORTIZATION_METHOD = "revenueAmortizationMethod";
  @SerializedName(SERIALIZED_NAME_REVENUE_AMORTIZATION_METHOD)
  private RevenueAmortizationMethodEnum revenueAmortizationMethod;

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

  public static final String SERIALIZED_NAME_SEGMENT = "segment";
  @SerializedName(SERIALIZED_NAME_SEGMENT)
  private Long segment;

  public static final String SERIALIZED_NAME_SMOOTHING_MODEL = "smoothingModel";
  @SerializedName(SERIALIZED_NAME_SMOOTHING_MODEL)
  private String smoothingModel;

  public static final String SERIALIZED_NAME_SPECIFIC_BILLING_PERIOD = "specificBillingPeriod";
  @SerializedName(SERIALIZED_NAME_SPECIFIC_BILLING_PERIOD)
  private Long specificBillingPeriod;

  public static final String SERIALIZED_NAME_SPECIFIC_END_DATE = "specificEndDate";
  @SerializedName(SERIALIZED_NAME_SPECIFIC_END_DATE)
  private LocalDate specificEndDate;

  public static final String SERIALIZED_NAME_SPECIFIC_LIST_PRICE_BASE = "specificListPriceBase";
  @SerializedName(SERIALIZED_NAME_SPECIFIC_LIST_PRICE_BASE)
  private Object specificListPriceBase = null;

  public static final String SERIALIZED_NAME_SUBSCRIPTION_CHARGE_DELIVERY_SCHEDULE = "subscriptionChargeDeliverySchedule";
  @SerializedName(SERIALIZED_NAME_SUBSCRIPTION_CHARGE_DELIVERY_SCHEDULE)
  private GETDeliveryScheduleType subscriptionChargeDeliverySchedule;

  public static final String SERIALIZED_NAME_SUBSCRIPTION_CHARGE_INTERVAL_PRICING = "subscriptionChargeIntervalPricing";
  @SerializedName(SERIALIZED_NAME_SUBSCRIPTION_CHARGE_INTERVAL_PRICING)
  private List<GETIntervalPriceType> subscriptionChargeIntervalPricing = null;

  public static final String SERIALIZED_NAME_TCV = "tcv";
  @SerializedName(SERIALIZED_NAME_TCV)
  private Double tcv;

  public static final String SERIALIZED_NAME_TIERS = "tiers";
  @SerializedName(SERIALIZED_NAME_TIERS)
  private List<GETTierType> tiers = null;

  public static final String SERIALIZED_NAME_TRIGGER_DATE = "triggerDate";
  @SerializedName(SERIALIZED_NAME_TRIGGER_DATE)
  private LocalDate triggerDate;

  public static final String SERIALIZED_NAME_TRIGGER_EVENT = "triggerEvent";
  @SerializedName(SERIALIZED_NAME_TRIGGER_EVENT)
  private String triggerEvent;

  public static final String SERIALIZED_NAME_TYPE = "type";
  @SerializedName(SERIALIZED_NAME_TYPE)
  private String type;

  public static final String SERIALIZED_NAME_UNUSED_UNITS_CREDIT_RATES = "unusedUnitsCreditRates";
  @SerializedName(SERIALIZED_NAME_UNUSED_UNITS_CREDIT_RATES)
  private Double unusedUnitsCreditRates;

  public static final String SERIALIZED_NAME_UPSELL_ORIGIN_CHARGE_NUMBER = "upsellOriginChargeNumber";
  @SerializedName(SERIALIZED_NAME_UPSELL_ORIGIN_CHARGE_NUMBER)
  private String upsellOriginChargeNumber;

  public static final String SERIALIZED_NAME_UOM = "uom";
  @SerializedName(SERIALIZED_NAME_UOM)
  private String uom;

  public static final String SERIALIZED_NAME_UP_TO_PERIODS = "upToPeriods";
  @SerializedName(SERIALIZED_NAME_UP_TO_PERIODS)
  private String upToPeriods;

  public static final String SERIALIZED_NAME_UP_TO_PERIODS_TYPE = "upToPeriodsType";
  @SerializedName(SERIALIZED_NAME_UP_TO_PERIODS_TYPE)
  private String upToPeriodsType;

  public static final String SERIALIZED_NAME_USAGE_RECORD_RATING_OPTION = "usageRecordRatingOption";
  @SerializedName(SERIALIZED_NAME_USAGE_RECORD_RATING_OPTION)
  private String usageRecordRatingOption;

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

  public GETSubscriptionRatePlanChargesType() {
  }

  public GETSubscriptionRatePlanChargesType description(String description) {
    
    
    
    
    this.description = description;
    return this;
  }

   /**
   * Description of the rate plan charge. 
   * @return description
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Description of the rate plan charge. ")

  public String getDescription() {
    return description;
  }


  public void setDescription(String description) {
    
    
    
    this.description = description;
  }


  public GETSubscriptionRatePlanChargesType version(Long version) {
    
    
    
    
    this.version = version;
    return this;
  }

   /**
   * Rate plan charge revision number. 
   * @return version
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Rate plan charge revision number. ")

  public Long getVersion() {
    return version;
  }


  public void setVersion(Long version) {
    
    
    
    this.version = version;
  }


  public GETSubscriptionRatePlanChargesType amendedByOrderOn(String amendedByOrderOn) {
    
    
    
    
    this.amendedByOrderOn = amendedByOrderOn;
    return this;
  }

   /**
   * The date when the rate plan charge is amended through an order or amendment. This field is to standardize the booking date information to increase audit ability and traceability of data between Zuora Billing and Zuora Revenue. It is mapped as the booking date for a sale order line in Zuora Revenue. 
   * @return amendedByOrderOn
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The date when the rate plan charge is amended through an order or amendment. This field is to standardize the booking date information to increase audit ability and traceability of data between Zuora Billing and Zuora Revenue. It is mapped as the booking date for a sale order line in Zuora Revenue. ")

  public String getAmendedByOrderOn() {
    return amendedByOrderOn;
  }


  public void setAmendedByOrderOn(String amendedByOrderOn) {
    
    
    
    this.amendedByOrderOn = amendedByOrderOn;
  }


  public GETSubscriptionRatePlanChargesType applyDiscountTo(String applyDiscountTo) {
    
    
    
    
    this.applyDiscountTo = applyDiscountTo;
    return this;
  }

   /**
   * Specifies the type of charges a specific discount applies to.   This field is only used when applied to a discount charge model. If you are not using a discount charge model, the value is null.  Possible values:  * &#x60;RECURRING&#x60; * &#x60;USAGE&#x60; * &#x60;ONETIMERECURRING&#x60; * &#x60;ONETIMEUSAGE&#x60; * &#x60;RECURRINGUSAGE&#x60; * &#x60;ONETIMERECURRINGUSAGE&#x60; 
   * @return applyDiscountTo
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Specifies the type of charges a specific discount applies to.   This field is only used when applied to a discount charge model. If you are not using a discount charge model, the value is null.  Possible values:  * `RECURRING` * `USAGE` * `ONETIMERECURRING` * `ONETIMEUSAGE` * `RECURRINGUSAGE` * `ONETIMERECURRINGUSAGE` ")

  public String getApplyDiscountTo() {
    return applyDiscountTo;
  }


  public void setApplyDiscountTo(String applyDiscountTo) {
    
    
    
    this.applyDiscountTo = applyDiscountTo;
  }


  public GETSubscriptionRatePlanChargesType applyToBillingPeriodPartially(Boolean applyToBillingPeriodPartially) {
    
    
    
    
    this.applyToBillingPeriodPartially = applyToBillingPeriodPartially;
    return this;
  }

   /**
   * Allow the discount duration to be aligned with the billing period partially.  **Note**: This field is only available if you have the [Enhanced Discounts](https://knowledgecenter.zuora.com/Zuora_Billing/Build_products_and_prices/Basic_concepts_and_terms/B_Charge_Models/D_Manage_Enhanced_Discount) feature enabled. 
   * @return applyToBillingPeriodPartially
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Allow the discount duration to be aligned with the billing period partially.  **Note**: This field is only available if you have the [Enhanced Discounts](https://knowledgecenter.zuora.com/Zuora_Billing/Build_products_and_prices/Basic_concepts_and_terms/B_Charge_Models/D_Manage_Enhanced_Discount) feature enabled. ")

  public Boolean getApplyToBillingPeriodPartially() {
    return applyToBillingPeriodPartially;
  }


  public void setApplyToBillingPeriodPartially(Boolean applyToBillingPeriodPartially) {
    
    
    
    this.applyToBillingPeriodPartially = applyToBillingPeriodPartially;
  }


  public GETSubscriptionRatePlanChargesType billingDay(String billingDay) {
    
    
    
    
    this.billingDay = billingDay;
    return this;
  }

   /**
   * Billing cycle day (BCD), which is when bill runs generate invoices for charges associated with the product rate plan charge or the account.    Values:  * &#x60;DefaultFromCustomer&#x60; * &#x60;SpecificDayofMonth(# of the month)&#x60; * &#x60;SubscriptionStartDay&#x60; * &#x60;ChargeTriggerDay&#x60; * &#x60;SpecificDayofWeek/dayofweek&#x60;: in which dayofweek is the day in the week you define your billing periods to start.  In the response data, a day-of-the-month ordinal value (&#x60;first&#x60;-&#x60;31st&#x60;) appears in place of the hash sign above (\&quot;#\&quot;). If this value exceeds the number of days in a particular month, the last day of the month is used as the BCD. 
   * @return billingDay
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Billing cycle day (BCD), which is when bill runs generate invoices for charges associated with the product rate plan charge or the account.    Values:  * `DefaultFromCustomer` * `SpecificDayofMonth(# of the month)` * `SubscriptionStartDay` * `ChargeTriggerDay` * `SpecificDayofWeek/dayofweek`: in which dayofweek is the day in the week you define your billing periods to start.  In the response data, a day-of-the-month ordinal value (`first`-`31st`) appears in place of the hash sign above (\"#\"). If this value exceeds the number of days in a particular month, the last day of the month is used as the BCD. ")

  public String getBillingDay() {
    return billingDay;
  }


  public void setBillingDay(String billingDay) {
    
    
    
    this.billingDay = billingDay;
  }


  public GETSubscriptionRatePlanChargesType billingPeriod(String billingPeriod) {
    
    
    
    
    this.billingPeriod = billingPeriod;
    return this;
  }

   /**
   * Allows billing period to be overridden on the rate plan charge. 
   * @return billingPeriod
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Allows billing period to be overridden on the rate plan charge. ")

  public String getBillingPeriod() {
    return billingPeriod;
  }


  public void setBillingPeriod(String billingPeriod) {
    
    
    
    this.billingPeriod = billingPeriod;
  }


  public GETSubscriptionRatePlanChargesType billingPeriodAlignment(String billingPeriodAlignment) {
    
    
    
    
    this.billingPeriodAlignment = billingPeriodAlignment;
    return this;
  }

   /**
   * Possible values:  * &#x60;AlignToCharge&#x60; * &#x60;AlignToSubscriptionStart&#x60; * &#x60;AlignToTermStart&#x60; 
   * @return billingPeriodAlignment
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Possible values:  * `AlignToCharge` * `AlignToSubscriptionStart` * `AlignToTermStart` ")

  public String getBillingPeriodAlignment() {
    return billingPeriodAlignment;
  }


  public void setBillingPeriodAlignment(String billingPeriodAlignment) {
    
    
    
    this.billingPeriodAlignment = billingPeriodAlignment;
  }


  public GETSubscriptionRatePlanChargesType billingTiming(String billingTiming) {
    
    
    
    
    this.billingTiming = billingTiming;
    return this;
  }

   /**
   * The billing timing for the charge. This field is only used if the &#x60;ratePlanChargeType&#x60; value is &#x60;Recurring&#x60;.  Possible values are:  * &#x60;In Advance&#x60; * &#x60;In Arrears&#x60;  **Note:** This feature is in **Limited Availability**. If you wish to have access to the feature, submit a request at [Zuora Global Support](http://support.zuora.com/). 
   * @return billingTiming
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The billing timing for the charge. This field is only used if the `ratePlanChargeType` value is `Recurring`.  Possible values are:  * `In Advance` * `In Arrears`  **Note:** This feature is in **Limited Availability**. If you wish to have access to the feature, submit a request at [Zuora Global Support](http://support.zuora.com/). ")

  public String getBillingTiming() {
    return billingTiming;
  }


  public void setBillingTiming(String billingTiming) {
    
    
    
    this.billingTiming = billingTiming;
  }


  public GETSubscriptionRatePlanChargesType chargeFunction(ChargeFunctionEnum chargeFunction) {
    
    
    
    
    this.chargeFunction = chargeFunction;
    return this;
  }

   /**
   * **Note**: This field is only available if you have the &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Bill_your_customers/Bill_for_usage_or_prepaid_products/Advanced_Consumption_Billing/Unbilled_Usage\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Unbilled Usage&lt;/a&gt; feature enabled.  To use this field, you must set the &#x60;X-Zuora-WSDL-Version&#x60; request header to &#x60;141&#x60; or higher. Otherwise, an error occurs.  This field defines what type of charge it is in Advanced Consumption Billing: * Standard: Normal charge with no Prepayment or Commitment or Drawdown. * Prepayment: For recurring charges. Unit or currency based prepaid charge. * CommitmentTrueUp: For recurring charges. Currency based minimum commitment charge. * Drawdown: For usage charges. Drawdown from prepaid funds. * DrawdownAndCreditCommitment: For usage charges. Drawdown from prepaid funds and then credit to minimum commitment funds. * CreditCommitment: For usage charges. Credit to minimum commitment funds. 
   * @return chargeFunction
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "**Note**: This field is only available if you have the <a href=\"https://knowledgecenter.zuora.com/Zuora_Billing/Bill_your_customers/Bill_for_usage_or_prepaid_products/Advanced_Consumption_Billing/Unbilled_Usage\" target=\"_blank\">Unbilled Usage</a> feature enabled.  To use this field, you must set the `X-Zuora-WSDL-Version` request header to `141` or higher. Otherwise, an error occurs.  This field defines what type of charge it is in Advanced Consumption Billing: * Standard: Normal charge with no Prepayment or Commitment or Drawdown. * Prepayment: For recurring charges. Unit or currency based prepaid charge. * CommitmentTrueUp: For recurring charges. Currency based minimum commitment charge. * Drawdown: For usage charges. Drawdown from prepaid funds. * DrawdownAndCreditCommitment: For usage charges. Drawdown from prepaid funds and then credit to minimum commitment funds. * CreditCommitment: For usage charges. Credit to minimum commitment funds. ")

  public ChargeFunctionEnum getChargeFunction() {
    return chargeFunction;
  }


  public void setChargeFunction(ChargeFunctionEnum chargeFunction) {
    
    
    
    this.chargeFunction = chargeFunction;
  }


  public GETSubscriptionRatePlanChargesType commitmentType(CommitmentTypeEnum commitmentType) {
    
    
    
    
    this.commitmentType = commitmentType;
    return this;
  }

   /**
   * **Note**: This field is only available if you have the &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Bill_your_customers/Bill_for_usage_or_prepaid_products/Advanced_Consumption_Billing/Unbilled_Usage\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Unbilled Usage&lt;/a&gt; feature enabled.  To use this field, you must set the &#x60;X-Zuora-WSDL-Version&#x60; request header to &#x60;133&#x60; or higher. Otherwise, an error occurs.   This field defines the type of commitment. A prepaid charge can be &#x60;UNIT&#x60; or &#x60;CURRENCY&#x60;. A minimum commitment(in-arrears) charge can only be &#x60;CURRENCY&#x60; type. For topup(recurring or one-time) charges, this field indicates what type of funds are created.  * If UNIT, it will create a fund with given prepaidUom. * If CURRENCY, it will create a fund with the currency amount calculated in list price.    For drawdown(usage) charges, this field indicates what type of funds are drawdown from that created from topup charges. 
   * @return commitmentType
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "**Note**: This field is only available if you have the <a href=\"https://knowledgecenter.zuora.com/Zuora_Billing/Bill_your_customers/Bill_for_usage_or_prepaid_products/Advanced_Consumption_Billing/Unbilled_Usage\" target=\"_blank\">Unbilled Usage</a> feature enabled.  To use this field, you must set the `X-Zuora-WSDL-Version` request header to `133` or higher. Otherwise, an error occurs.   This field defines the type of commitment. A prepaid charge can be `UNIT` or `CURRENCY`. A minimum commitment(in-arrears) charge can only be `CURRENCY` type. For topup(recurring or one-time) charges, this field indicates what type of funds are created.  * If UNIT, it will create a fund with given prepaidUom. * If CURRENCY, it will create a fund with the currency amount calculated in list price.    For drawdown(usage) charges, this field indicates what type of funds are drawdown from that created from topup charges. ")

  public CommitmentTypeEnum getCommitmentType() {
    return commitmentType;
  }


  public void setCommitmentType(CommitmentTypeEnum commitmentType) {
    
    
    
    this.commitmentType = commitmentType;
  }


  public GETSubscriptionRatePlanChargesType chargeModelConfiguration(ChargeModelConfigurationType chargeModelConfiguration) {
    
    
    
    
    this.chargeModelConfiguration = chargeModelConfiguration;
    return this;
  }

   /**
   * Get chargeModelConfiguration
   * @return chargeModelConfiguration
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public ChargeModelConfigurationType getChargeModelConfiguration() {
    return chargeModelConfiguration;
  }


  public void setChargeModelConfiguration(ChargeModelConfigurationType chargeModelConfiguration) {
    
    
    
    this.chargeModelConfiguration = chargeModelConfiguration;
  }


  public GETSubscriptionRatePlanChargesType chargedThroughDate(LocalDate chargedThroughDate) {
    
    
    
    
    this.chargedThroughDate = chargedThroughDate;
    return this;
  }

   /**
   * The date through which a customer has been billed for the charge. 
   * @return chargedThroughDate
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The date through which a customer has been billed for the charge. ")

  public LocalDate getChargedThroughDate() {
    return chargedThroughDate;
  }


  public void setChargedThroughDate(LocalDate chargedThroughDate) {
    
    
    
    this.chargedThroughDate = chargedThroughDate;
  }


  public GETSubscriptionRatePlanChargesType creditOption(CreditOptionEnum creditOption) {
    
    
    
    
    this.creditOption = creditOption;
    return this;
  }

   /**
   * **Note**: This field is only available if you have the [Prepaid with Drawdown](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/J_Billing_Operations/Prepaid_with_Drawdown) feature enabled.  To use this field, you must set the &#x60;X-Zuora-WSDL-Version&#x60; request header to 114 or higher. Otherwise, an error occurs.  The way to calculate credit. See [Credit Option](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/J_Billing_Operations/Prepaid_with_Drawdown/Create_prepayment_charge#Credit_Option) for more information. 
   * @return creditOption
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "**Note**: This field is only available if you have the [Prepaid with Drawdown](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/J_Billing_Operations/Prepaid_with_Drawdown) feature enabled.  To use this field, you must set the `X-Zuora-WSDL-Version` request header to 114 or higher. Otherwise, an error occurs.  The way to calculate credit. See [Credit Option](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/J_Billing_Operations/Prepaid_with_Drawdown/Create_prepayment_charge#Credit_Option) for more information. ")

  public CreditOptionEnum getCreditOption() {
    return creditOption;
  }


  public void setCreditOption(CreditOptionEnum creditOption) {
    
    
    
    this.creditOption = creditOption;
  }


  public GETSubscriptionRatePlanChargesType currency(String currency) {
    
    
    
    
    this.currency = currency;
    return this;
  }

   /**
   * Currency used by the account. For example, &#x60;USD&#x60; or &#x60;EUR&#x60;. 
   * @return currency
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Currency used by the account. For example, `USD` or `EUR`. ")

  public String getCurrency() {
    return currency;
  }


  public void setCurrency(String currency) {
    
    
    
    this.currency = currency;
  }


  public GETSubscriptionRatePlanChargesType discountAmount(Double discountAmount) {
    
    
    
    
    this.discountAmount = discountAmount;
    return this;
  }

  public GETSubscriptionRatePlanChargesType discountAmount(Integer discountAmount) {
    
    
    
    
    this.discountAmount = discountAmount.doubleValue();
    return this;
  }

   /**
   * The amount of the discount. 
   * @return discountAmount
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The amount of the discount. ")

  public Double getDiscountAmount() {
    return discountAmount;
  }


  public void setDiscountAmount(Double discountAmount) {
    
    
    
    this.discountAmount = discountAmount;
  }


  public GETSubscriptionRatePlanChargesType discountApplyDetails(List<GETDiscountApplyDetailsType> discountApplyDetails) {
    
    
    
    
    this.discountApplyDetails = discountApplyDetails;
    return this;
  }

  public GETSubscriptionRatePlanChargesType addDiscountApplyDetailsItem(GETDiscountApplyDetailsType discountApplyDetailsItem) {
    if (this.discountApplyDetails == null) {
      this.discountApplyDetails = new ArrayList<>();
    }
    this.discountApplyDetails.add(discountApplyDetailsItem);
    return this;
  }

   /**
   * Container for the application details about a discount rate plan charge.   Only discount rate plan charges have values in this field. 
   * @return discountApplyDetails
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Container for the application details about a discount rate plan charge.   Only discount rate plan charges have values in this field. ")

  public List<GETDiscountApplyDetailsType> getDiscountApplyDetails() {
    return discountApplyDetails;
  }


  public void setDiscountApplyDetails(List<GETDiscountApplyDetailsType> discountApplyDetails) {
    
    
    
    this.discountApplyDetails = discountApplyDetails;
  }


  public GETSubscriptionRatePlanChargesType discountClass(String discountClass) {
    
    
    
    
    this.discountClass = discountClass;
    return this;
  }

   /**
   * The class that the discount belongs to. The discount class defines the order in which discount rate plan charges are applied.  For more information, see [Manage Discount Classes](https://knowledgecenter.zuora.com/BC_Subscription_Management/Product_Catalog/B_Charge_Models/Manage_Discount_Classes). 
   * @return discountClass
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The class that the discount belongs to. The discount class defines the order in which discount rate plan charges are applied.  For more information, see [Manage Discount Classes](https://knowledgecenter.zuora.com/BC_Subscription_Management/Product_Catalog/B_Charge_Models/Manage_Discount_Classes). ")

  public String getDiscountClass() {
    return discountClass;
  }


  public void setDiscountClass(String discountClass) {
    
    
    
    this.discountClass = discountClass;
  }


  public GETSubscriptionRatePlanChargesType discountLevel(String discountLevel) {
    
    
    
    
    this.discountLevel = discountLevel;
    return this;
  }

   /**
   * The level of the discount. Values: &#x60;RatePlan&#x60;, &#x60;Subscription&#x60;, &#x60;Account&#x60;. 
   * @return discountLevel
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The level of the discount. Values: `RatePlan`, `Subscription`, `Account`. ")

  public String getDiscountLevel() {
    return discountLevel;
  }


  public void setDiscountLevel(String discountLevel) {
    
    
    
    this.discountLevel = discountLevel;
  }


  public GETSubscriptionRatePlanChargesType discountPercentage(Double discountPercentage) {
    
    
    
    
    this.discountPercentage = discountPercentage;
    return this;
  }

  public GETSubscriptionRatePlanChargesType discountPercentage(Integer discountPercentage) {
    
    
    
    
    this.discountPercentage = discountPercentage.doubleValue();
    return this;
  }

   /**
   * The amount of the discount as a percentage. 
   * @return discountPercentage
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The amount of the discount as a percentage. ")

  public Double getDiscountPercentage() {
    return discountPercentage;
  }


  public void setDiscountPercentage(Double discountPercentage) {
    
    
    
    this.discountPercentage = discountPercentage;
  }


  public GETSubscriptionRatePlanChargesType dmrc(Double dmrc) {
    
    
    
    
    this.dmrc = dmrc;
    return this;
  }

  public GETSubscriptionRatePlanChargesType dmrc(Integer dmrc) {
    
    
    
    
    this.dmrc = dmrc.doubleValue();
    return this;
  }

   /**
   * The change (delta) of monthly recurring charge exists when the change in monthly recurring revenue caused by an amendment or a new subscription. 
   * @return dmrc
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The change (delta) of monthly recurring charge exists when the change in monthly recurring revenue caused by an amendment or a new subscription. ")

  public Double getDmrc() {
    return dmrc;
  }


  public void setDmrc(Double dmrc) {
    
    
    
    this.dmrc = dmrc;
  }


  public GETSubscriptionRatePlanChargesType done(Boolean done) {
    
    
    
    
    this.done = done;
    return this;
  }

   /**
   * A value of &#x60;true&#x60; indicates that an invoice for a charge segment has been completed. A value of &#x60;false&#x60; indicates that an invoice has not been completed for the charge segment. 
   * @return done
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "A value of `true` indicates that an invoice for a charge segment has been completed. A value of `false` indicates that an invoice has not been completed for the charge segment. ")

  public Boolean getDone() {
    return done;
  }


  public void setDone(Boolean done) {
    
    
    
    this.done = done;
  }


  public GETSubscriptionRatePlanChargesType drawdownRate(Double drawdownRate) {
    
    
    
    
    this.drawdownRate = drawdownRate;
    return this;
  }

  public GETSubscriptionRatePlanChargesType drawdownRate(Integer drawdownRate) {
    
    
    
    
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


  public GETSubscriptionRatePlanChargesType drawdownUom(String drawdownUom) {
    
    
    
    
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


  public GETSubscriptionRatePlanChargesType dtcv(Double dtcv) {
    
    
    
    
    this.dtcv = dtcv;
    return this;
  }

  public GETSubscriptionRatePlanChargesType dtcv(Integer dtcv) {
    
    
    
    
    this.dtcv = dtcv.doubleValue();
    return this;
  }

   /**
   * After an amendment or an AutomatedPriceChange event, &#x60;dtcv&#x60; displays the change (delta) for the total contract value (TCV) amount for this charge, compared with its previous value with recurring charge types. 
   * @return dtcv
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "After an amendment or an AutomatedPriceChange event, `dtcv` displays the change (delta) for the total contract value (TCV) amount for this charge, compared with its previous value with recurring charge types. ")

  public Double getDtcv() {
    return dtcv;
  }


  public void setDtcv(Double dtcv) {
    
    
    
    this.dtcv = dtcv;
  }


  public GETSubscriptionRatePlanChargesType effectiveEndDate(LocalDate effectiveEndDate) {
    
    
    
    
    this.effectiveEndDate = effectiveEndDate;
    return this;
  }

   /**
   * The effective end date of the rate plan charge. 
   * @return effectiveEndDate
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The effective end date of the rate plan charge. ")

  public LocalDate getEffectiveEndDate() {
    return effectiveEndDate;
  }


  public void setEffectiveEndDate(LocalDate effectiveEndDate) {
    
    
    
    this.effectiveEndDate = effectiveEndDate;
  }


  public GETSubscriptionRatePlanChargesType effectiveStartDate(LocalDate effectiveStartDate) {
    
    
    
    
    this.effectiveStartDate = effectiveStartDate;
    return this;
  }

   /**
   * The effective start date of the rate plan charge. 
   * @return effectiveStartDate
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The effective start date of the rate plan charge. ")

  public LocalDate getEffectiveStartDate() {
    return effectiveStartDate;
  }


  public void setEffectiveStartDate(LocalDate effectiveStartDate) {
    
    
    
    this.effectiveStartDate = effectiveStartDate;
  }


  public GETSubscriptionRatePlanChargesType endDateCondition(String endDateCondition) {
    
    
    
    
    this.endDateCondition = endDateCondition;
    return this;
  }

   /**
   * Defines when the charge ends after the charge trigger date.  If the subscription ends before the charge end date, the charge ends when the subscription ends. But if the subscription end date is subsequently changed through a Renewal, or Terms and Conditions amendment, the charge will end on the charge end date.  Values:  * &#x60;Subscription_End&#x60; * &#x60;Fixed_Period&#x60; * &#x60;Specific_End_Date&#x60; * &#x60;One_Time&#x60; 
   * @return endDateCondition
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Defines when the charge ends after the charge trigger date.  If the subscription ends before the charge end date, the charge ends when the subscription ends. But if the subscription end date is subsequently changed through a Renewal, or Terms and Conditions amendment, the charge will end on the charge end date.  Values:  * `Subscription_End` * `Fixed_Period` * `Specific_End_Date` * `One_Time` ")

  public String getEndDateCondition() {
    return endDateCondition;
  }


  public void setEndDateCondition(String endDateCondition) {
    
    
    
    this.endDateCondition = endDateCondition;
  }


  public GETSubscriptionRatePlanChargesType excludeItemBillingFromRevenueAccounting(Boolean excludeItemBillingFromRevenueAccounting) {
    
    
    
    
    this.excludeItemBillingFromRevenueAccounting = excludeItemBillingFromRevenueAccounting;
    return this;
  }

   /**
   * The flag to exclude rate plan charge related invoice items, invoice item adjustments, credit memo items, and debit memo items from revenue accounting.  **Note**: This field is only available if you have the Order to Revenue or Billing - Revenue Integration feature enabled.  
   * @return excludeItemBillingFromRevenueAccounting
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The flag to exclude rate plan charge related invoice items, invoice item adjustments, credit memo items, and debit memo items from revenue accounting.  **Note**: This field is only available if you have the Order to Revenue or Billing - Revenue Integration feature enabled.  ")

  public Boolean getExcludeItemBillingFromRevenueAccounting() {
    return excludeItemBillingFromRevenueAccounting;
  }


  public void setExcludeItemBillingFromRevenueAccounting(Boolean excludeItemBillingFromRevenueAccounting) {
    
    
    
    this.excludeItemBillingFromRevenueAccounting = excludeItemBillingFromRevenueAccounting;
  }


  public GETSubscriptionRatePlanChargesType excludeItemBookingFromRevenueAccounting(Boolean excludeItemBookingFromRevenueAccounting) {
    
    
    
    
    this.excludeItemBookingFromRevenueAccounting = excludeItemBookingFromRevenueAccounting;
    return this;
  }

   /**
   * The flag to exclude rate plan charges from revenue accounting.  **Note**: This field is only available if you have the Order to Revenue or Billing - Revenue Integration feature enabled.  
   * @return excludeItemBookingFromRevenueAccounting
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The flag to exclude rate plan charges from revenue accounting.  **Note**: This field is only available if you have the Order to Revenue or Billing - Revenue Integration feature enabled.  ")

  public Boolean getExcludeItemBookingFromRevenueAccounting() {
    return excludeItemBookingFromRevenueAccounting;
  }


  public void setExcludeItemBookingFromRevenueAccounting(Boolean excludeItemBookingFromRevenueAccounting) {
    
    
    
    this.excludeItemBookingFromRevenueAccounting = excludeItemBookingFromRevenueAccounting;
  }


  public GETSubscriptionRatePlanChargesType id(String id) {
    
    
    
    
    this.id = id;
    return this;
  }

   /**
   * Rate plan charge ID. 
   * @return id
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Rate plan charge ID. ")

  public String getId() {
    return id;
  }


  public void setId(String id) {
    
    
    
    this.id = id;
  }


  public GETSubscriptionRatePlanChargesType includedUnits(Double includedUnits) {
    
    
    
    
    this.includedUnits = includedUnits;
    return this;
  }

  public GETSubscriptionRatePlanChargesType includedUnits(Integer includedUnits) {
    
    
    
    
    this.includedUnits = includedUnits.doubleValue();
    return this;
  }

   /**
   * Specifies the number of units in the base set of units. 
   * @return includedUnits
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Specifies the number of units in the base set of units. ")

  public Double getIncludedUnits() {
    return includedUnits;
  }


  public void setIncludedUnits(Double includedUnits) {
    
    
    
    this.includedUnits = includedUnits;
  }


  public GETSubscriptionRatePlanChargesType invoiceScheduleId(String invoiceScheduleId) {
    
    
    
    
    this.invoiceScheduleId = invoiceScheduleId;
    return this;
  }

   /**
   * The ID of the invoice schedule associated with the rate plan charge on the subscription.  **Note**: This field is available only if you have the &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Bill_your_customers/Flexible_Billing/Billing_Schedule\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Billing Schedule&lt;/a&gt; feature enabled. 
   * @return invoiceScheduleId
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The ID of the invoice schedule associated with the rate plan charge on the subscription.  **Note**: This field is available only if you have the <a href=\"https://knowledgecenter.zuora.com/Zuora_Billing/Bill_your_customers/Flexible_Billing/Billing_Schedule\" target=\"_blank\">Billing Schedule</a> feature enabled. ")

  public String getInvoiceScheduleId() {
    return invoiceScheduleId;
  }


  public void setInvoiceScheduleId(String invoiceScheduleId) {
    
    
    
    this.invoiceScheduleId = invoiceScheduleId;
  }


  public GETSubscriptionRatePlanChargesType isAllocationEligible(Boolean isAllocationEligible) {
    
    
    
    
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


  public GETSubscriptionRatePlanChargesType isPrepaid(Boolean isPrepaid) {
    
    
    
    
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


  public GETSubscriptionRatePlanChargesType isRollover(Boolean isRollover) {
    
    
    
    
    this.isRollover = isRollover;
    return this;
  }

   /**
   * **Note**: This field is only available if you have the [Prepaid with Drawdown](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/J_Billing_Operations/Prepaid_with_Drawdown) feature enabled.  The value is either \&quot;True\&quot; or \&quot;False\&quot;. It determines whether the rollover fields are needed. 
   * @return isRollover
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "**Note**: This field is only available if you have the [Prepaid with Drawdown](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/J_Billing_Operations/Prepaid_with_Drawdown) feature enabled.  The value is either \"True\" or \"False\". It determines whether the rollover fields are needed. ")

  public Boolean getIsRollover() {
    return isRollover;
  }


  public void setIsRollover(Boolean isRollover) {
    
    
    
    this.isRollover = isRollover;
  }


  public GETSubscriptionRatePlanChargesType isStackedDiscount(Boolean isStackedDiscount) {
    
    
    
    
    this.isStackedDiscount = isStackedDiscount;
    return this;
  }

   /**
   * **Note**: This field is only applicable to the Discount - Percentage charge model.  To use this field, you must set the &#x60;X-Zuora-WSDL-Version&#x60; request header to 130 or higher. Otherwise, an error occurs.  This field indicates whether the discount is to be calculated as stacked discount. Possible values are as follows:   - &#x60;True&#x60;: This is a stacked discount, which should be calculated by stacking with other discounts.   - &#x60;False&#x60;: This is not a stacked discount, which should be calculated in sequence with other discounts.  For more information, see [Stacked discounts](https://knowledgecenter.zuora.com/Zuora_Billing/Products/Product_Catalog/B_Charge_Models/B_Discount_Charge_Models). 
   * @return isStackedDiscount
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "**Note**: This field is only applicable to the Discount - Percentage charge model.  To use this field, you must set the `X-Zuora-WSDL-Version` request header to 130 or higher. Otherwise, an error occurs.  This field indicates whether the discount is to be calculated as stacked discount. Possible values are as follows:   - `True`: This is a stacked discount, which should be calculated by stacking with other discounts.   - `False`: This is not a stacked discount, which should be calculated in sequence with other discounts.  For more information, see [Stacked discounts](https://knowledgecenter.zuora.com/Zuora_Billing/Products/Product_Catalog/B_Charge_Models/B_Discount_Charge_Models). ")

  public Boolean getIsStackedDiscount() {
    return isStackedDiscount;
  }


  public void setIsStackedDiscount(Boolean isStackedDiscount) {
    
    
    
    this.isStackedDiscount = isStackedDiscount;
  }


  public GETSubscriptionRatePlanChargesType isUnbilled(Boolean isUnbilled) {
    
    
    
    
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


  public GETSubscriptionRatePlanChargesType listPriceBase(String listPriceBase) {
    
    
    
    
    this.listPriceBase = listPriceBase;
    return this;
  }

   /**
   * List price base; possible values are:  * &#x60;Per_Billing_Period&#x60; * &#x60;Per_Month&#x60; * &#x60;Per_Week&#x60; * &#x60;Per_Year&#x60; * &#x60;Per_Specific_Months&#x60; 
   * @return listPriceBase
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "List price base; possible values are:  * `Per_Billing_Period` * `Per_Month` * `Per_Week` * `Per_Year` * `Per_Specific_Months` ")

  public String getListPriceBase() {
    return listPriceBase;
  }


  public void setListPriceBase(String listPriceBase) {
    
    
    
    this.listPriceBase = listPriceBase;
  }


  public GETSubscriptionRatePlanChargesType model(String model) {
    
    
    
    
    this.model = model;
    return this;
  }

   /**
   * Charge model; possible values are:  * &#x60;FlatFee&#x60; * &#x60;PerUnit&#x60; * &#x60;Overage&#x60; * &#x60;Volume&#x60; * &#x60;Tiered&#x60; * &#x60;TieredWithOverage&#x60; * &#x60;DiscountFixedAmount&#x60; * &#x60;DiscountPercentage&#x60; * &#x60;MultiAttributePricing&#x60; * &#x60;PreratedPerUnit&#x60; * &#x60;PreratedPricing&#x60; * &#x60;HighWatermarkVolumePricing&#x60; * &#x60;HighWatermarkTieredPricing&#x60; * &#x60;Delivery&#x60; 
   * @return model
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Charge model; possible values are:  * `FlatFee` * `PerUnit` * `Overage` * `Volume` * `Tiered` * `TieredWithOverage` * `DiscountFixedAmount` * `DiscountPercentage` * `MultiAttributePricing` * `PreratedPerUnit` * `PreratedPricing` * `HighWatermarkVolumePricing` * `HighWatermarkTieredPricing` * `Delivery` ")

  public String getModel() {
    return model;
  }


  public void setModel(String model) {
    
    
    
    this.model = model;
  }


  public GETSubscriptionRatePlanChargesType mrr(Double mrr) {
    
    
    
    
    this.mrr = mrr;
    return this;
  }

  public GETSubscriptionRatePlanChargesType mrr(Integer mrr) {
    
    
    
    
    this.mrr = mrr.doubleValue();
    return this;
  }

   /**
   * Monthly recurring revenue of the rate plan charge. 
   * @return mrr
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Monthly recurring revenue of the rate plan charge. ")

  public Double getMrr() {
    return mrr;
  }


  public void setMrr(Double mrr) {
    
    
    
    this.mrr = mrr;
  }


  public GETSubscriptionRatePlanChargesType name(String name) {
    
    
    
    
    this.name = name;
    return this;
  }

   /**
   * Charge name. 
   * @return name
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Charge name. ")

  public String getName() {
    return name;
  }


  public void setName(String name) {
    
    
    
    this.name = name;
  }


  public GETSubscriptionRatePlanChargesType number(String number) {
    
    
    
    
    this.number = number;
    return this;
  }

   /**
   * Charge number. 
   * @return number
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Charge number. ")

  public String getNumber() {
    return number;
  }


  public void setNumber(String number) {
    
    
    
    this.number = number;
  }


  public GETSubscriptionRatePlanChargesType numberOfDeliveries(Double numberOfDeliveries) {
    
    
    
    
    this.numberOfDeliveries = numberOfDeliveries;
    return this;
  }

  public GETSubscriptionRatePlanChargesType numberOfDeliveries(Integer numberOfDeliveries) {
    
    
    
    
    this.numberOfDeliveries = numberOfDeliveries.doubleValue();
    return this;
  }

   /**
   * Number of deliveries in the billing period for the charge segment.  The &#x60;numberOfDeliveries&#x60; is used for the Delivery Pricing charge model only.   **Note**: The Delivery Pricing charge model is in the **Early Adopter** phase. We are actively soliciting feedback from a small set of early adopters before releasing it as generally available. To manage and access this feature through the self-service interface, see [Enable billing features by yourself](https://knowledgecenter.zuora.com/Zuora_Billing/Bill_your_customers/Billing_Settings/Manage_Features) in the Knowledge Center. You can check **Delivery Pricing** in **Billing Settings** &gt; **Enable Charge Types / Models**. 
   * @return numberOfDeliveries
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Number of deliveries in the billing period for the charge segment.  The `numberOfDeliveries` is used for the Delivery Pricing charge model only.   **Note**: The Delivery Pricing charge model is in the **Early Adopter** phase. We are actively soliciting feedback from a small set of early adopters before releasing it as generally available. To manage and access this feature through the self-service interface, see [Enable billing features by yourself](https://knowledgecenter.zuora.com/Zuora_Billing/Bill_your_customers/Billing_Settings/Manage_Features) in the Knowledge Center. You can check **Delivery Pricing** in **Billing Settings** > **Enable Charge Types / Models**. ")

  public Double getNumberOfDeliveries() {
    return numberOfDeliveries;
  }


  public void setNumberOfDeliveries(Double numberOfDeliveries) {
    
    
    
    this.numberOfDeliveries = numberOfDeliveries;
  }


  public GETSubscriptionRatePlanChargesType numberOfPeriods(Long numberOfPeriods) {
    
    
    
    
    this.numberOfPeriods = numberOfPeriods;
    return this;
  }

   /**
   * Specifies the number of periods to use when calculating charges in an overage smoothing charge model. 
   * @return numberOfPeriods
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Specifies the number of periods to use when calculating charges in an overage smoothing charge model. ")

  public Long getNumberOfPeriods() {
    return numberOfPeriods;
  }


  public void setNumberOfPeriods(Long numberOfPeriods) {
    
    
    
    this.numberOfPeriods = numberOfPeriods;
  }


  public GETSubscriptionRatePlanChargesType originalChargeId(String originalChargeId) {
    
    
    
    
    this.originalChargeId = originalChargeId;
    return this;
  }

   /**
   * The original ID of the rate plan charge. 
   * @return originalChargeId
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The original ID of the rate plan charge. ")

  public String getOriginalChargeId() {
    return originalChargeId;
  }


  public void setOriginalChargeId(String originalChargeId) {
    
    
    
    this.originalChargeId = originalChargeId;
  }


  public GETSubscriptionRatePlanChargesType originalOrderDate(LocalDate originalOrderDate) {
    
    
    
    
    this.originalOrderDate = originalOrderDate;
    return this;
  }

   /**
   * The date when the rate plan charge is created through an order or amendment.  This field is to standardize the booking date information to increase audit ability and traceability of data between Zuora Billing and Zuora Revenue. It is mapped as the booking date for a sale order line in Zuora Revenue. 
   * @return originalOrderDate
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The date when the rate plan charge is created through an order or amendment.  This field is to standardize the booking date information to increase audit ability and traceability of data between Zuora Billing and Zuora Revenue. It is mapped as the booking date for a sale order line in Zuora Revenue. ")

  public LocalDate getOriginalOrderDate() {
    return originalOrderDate;
  }


  public void setOriginalOrderDate(LocalDate originalOrderDate) {
    
    
    
    this.originalOrderDate = originalOrderDate;
  }


  public GETSubscriptionRatePlanChargesType overageCalculationOption(String overageCalculationOption) {
    
    
    
    
    this.overageCalculationOption = overageCalculationOption;
    return this;
  }

   /**
   * Determines when to calculate overage charges. 
   * @return overageCalculationOption
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Determines when to calculate overage charges. ")

  public String getOverageCalculationOption() {
    return overageCalculationOption;
  }


  public void setOverageCalculationOption(String overageCalculationOption) {
    
    
    
    this.overageCalculationOption = overageCalculationOption;
  }


  public GETSubscriptionRatePlanChargesType overagePrice(Double overagePrice) {
    
    
    
    
    this.overagePrice = overagePrice;
    return this;
  }

  public GETSubscriptionRatePlanChargesType overagePrice(Integer overagePrice) {
    
    
    
    
    this.overagePrice = overagePrice.doubleValue();
    return this;
  }

   /**
   * The price for units over the allowed amount. 
   * @return overagePrice
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The price for units over the allowed amount. ")

  public Double getOveragePrice() {
    return overagePrice;
  }


  public void setOveragePrice(Double overagePrice) {
    
    
    
    this.overagePrice = overagePrice;
  }


  public GETSubscriptionRatePlanChargesType overageUnusedUnitsCreditOption(String overageUnusedUnitsCreditOption) {
    
    
    
    
    this.overageUnusedUnitsCreditOption = overageUnusedUnitsCreditOption;
    return this;
  }

   /**
   * Determines whether to credit the customer with unused units of usage. 
   * @return overageUnusedUnitsCreditOption
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Determines whether to credit the customer with unused units of usage. ")

  public String getOverageUnusedUnitsCreditOption() {
    return overageUnusedUnitsCreditOption;
  }


  public void setOverageUnusedUnitsCreditOption(String overageUnusedUnitsCreditOption) {
    
    
    
    this.overageUnusedUnitsCreditOption = overageUnusedUnitsCreditOption;
  }


  public GETSubscriptionRatePlanChargesType prepaidOperationType(PrepaidOperationTypeEnum prepaidOperationType) {
    
    
    
    
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


  public GETSubscriptionRatePlanChargesType prepaidQuantity(Double prepaidQuantity) {
    
    
    
    
    this.prepaidQuantity = prepaidQuantity;
    return this;
  }

  public GETSubscriptionRatePlanChargesType prepaidQuantity(Integer prepaidQuantity) {
    
    
    
    
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


  public GETSubscriptionRatePlanChargesType prepaidTotalQuantity(Double prepaidTotalQuantity) {
    
    
    
    
    this.prepaidTotalQuantity = prepaidTotalQuantity;
    return this;
  }

  public GETSubscriptionRatePlanChargesType prepaidTotalQuantity(Integer prepaidTotalQuantity) {
    
    
    
    
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


  public GETSubscriptionRatePlanChargesType prepaidUom(String prepaidUom) {
    
    
    
    
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


  public GETSubscriptionRatePlanChargesType price(Double price) {
    
    
    
    
    this.price = price;
    return this;
  }

  public GETSubscriptionRatePlanChargesType price(Integer price) {
    
    
    
    
    this.price = price.doubleValue();
    return this;
  }

   /**
   * The price associated with the rate plan charge expressed as a decimal. 
   * @return price
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The price associated with the rate plan charge expressed as a decimal. ")

  public Double getPrice() {
    return price;
  }


  public void setPrice(Double price) {
    
    
    
    this.price = price;
  }


  public GETSubscriptionRatePlanChargesType priceChangeOption(String priceChangeOption) {
    
    
    
    
    this.priceChangeOption = priceChangeOption;
    return this;
  }

   /**
   * When the following is true:  1. AutomatedPriceChange setting is on  2. Charge type is not one-time  3. Charge model is not discount percentage  Then an automatic price change can have a value for when a termed subscription is renewed.   Values (one of the following):  * &#x60;NoChange&#x60; (default) * &#x60;SpecificPercentageValue&#x60; * &#x60;UseLatestProductCatalogPricing&#x60; 
   * @return priceChangeOption
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "When the following is true:  1. AutomatedPriceChange setting is on  2. Charge type is not one-time  3. Charge model is not discount percentage  Then an automatic price change can have a value for when a termed subscription is renewed.   Values (one of the following):  * `NoChange` (default) * `SpecificPercentageValue` * `UseLatestProductCatalogPricing` ")

  public String getPriceChangeOption() {
    return priceChangeOption;
  }


  public void setPriceChangeOption(String priceChangeOption) {
    
    
    
    this.priceChangeOption = priceChangeOption;
  }


  public GETSubscriptionRatePlanChargesType priceIncreasePercentage(Double priceIncreasePercentage) {
    
    
    
    
    this.priceIncreasePercentage = priceIncreasePercentage;
    return this;
  }

  public GETSubscriptionRatePlanChargesType priceIncreasePercentage(Integer priceIncreasePercentage) {
    
    
    
    
    this.priceIncreasePercentage = priceIncreasePercentage.doubleValue();
    return this;
  }

   /**
   * A planned future price increase amount as a percentage. 
   * @return priceIncreasePercentage
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "A planned future price increase amount as a percentage. ")

  public Double getPriceIncreasePercentage() {
    return priceIncreasePercentage;
  }


  public void setPriceIncreasePercentage(Double priceIncreasePercentage) {
    
    
    
    this.priceIncreasePercentage = priceIncreasePercentage;
  }


  public GETSubscriptionRatePlanChargesType pricingSummary(String pricingSummary) {
    
    
    
    
    this.pricingSummary = pricingSummary;
    return this;
  }

   /**
   * Concise description of rate plan charge model. 
   * @return pricingSummary
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Concise description of rate plan charge model. ")

  public String getPricingSummary() {
    return pricingSummary;
  }


  public void setPricingSummary(String pricingSummary) {
    
    
    
    this.pricingSummary = pricingSummary;
  }


  public GETSubscriptionRatePlanChargesType processedThroughDate(LocalDate processedThroughDate) {
    
    
    
    
    this.processedThroughDate = processedThroughDate;
    return this;
  }

   /**
   * The date until when charges have been processed. When billing in arrears, such as usage, this field value is the the same as the &#x60;ChargedThroughDate&#x60; value. This date is the earliest date when a charge can be amended. 
   * @return processedThroughDate
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The date until when charges have been processed. When billing in arrears, such as usage, this field value is the the same as the `ChargedThroughDate` value. This date is the earliest date when a charge can be amended. ")

  public LocalDate getProcessedThroughDate() {
    return processedThroughDate;
  }


  public void setProcessedThroughDate(LocalDate processedThroughDate) {
    
    
    
    this.processedThroughDate = processedThroughDate;
  }


  public GETSubscriptionRatePlanChargesType productCategory(String productCategory) {
    
    
    
    
    this.productCategory = productCategory;
    return this;
  }

   /**
   * This is used to maintain the product category.   **Note**: This field is only available if you have the Additional Revenue Fields property enabled. 
   * @return productCategory
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "This is used to maintain the product category.   **Note**: This field is only available if you have the Additional Revenue Fields property enabled. ")

  public String getProductCategory() {
    return productCategory;
  }


  public void setProductCategory(String productCategory) {
    
    
    
    this.productCategory = productCategory;
  }


  public GETSubscriptionRatePlanChargesType productClass(String productClass) {
    
    
    
    
    this.productClass = productClass;
    return this;
  }

   /**
   * This is used to maintain the product class.   **Note**: This field is only available if you have the Additional Revenue Fields property enabled.     
   * @return productClass
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "This is used to maintain the product class.   **Note**: This field is only available if you have the Additional Revenue Fields property enabled.     ")

  public String getProductClass() {
    return productClass;
  }


  public void setProductClass(String productClass) {
    
    
    
    this.productClass = productClass;
  }


  public GETSubscriptionRatePlanChargesType productFamily(String productFamily) {
    
    
    
    
    this.productFamily = productFamily;
    return this;
  }

   /**
   * This is used to maintain the product family.   **Note**: This field is only available if you have the Additional Revenue Fields property enabled. 
   * @return productFamily
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "This is used to maintain the product family.   **Note**: This field is only available if you have the Additional Revenue Fields property enabled. ")

  public String getProductFamily() {
    return productFamily;
  }


  public void setProductFamily(String productFamily) {
    
    
    
    this.productFamily = productFamily;
  }


  public GETSubscriptionRatePlanChargesType productLine(String productLine) {
    
    
    
    
    this.productLine = productLine;
    return this;
  }

   /**
   * This is used to maintain the product line.   **Note**: This field is only available if you have the Additional Revenue Fields property enabled. 
   * @return productLine
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "This is used to maintain the product line.   **Note**: This field is only available if you have the Additional Revenue Fields property enabled. ")

  public String getProductLine() {
    return productLine;
  }


  public void setProductLine(String productLine) {
    
    
    
    this.productLine = productLine;
  }


  public GETSubscriptionRatePlanChargesType productRatePlanChargeId(String productRatePlanChargeId) {
    
    
    
    
    this.productRatePlanChargeId = productRatePlanChargeId;
    return this;
  }

   /**
   * 
   * @return productRatePlanChargeId
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public String getProductRatePlanChargeId() {
    return productRatePlanChargeId;
  }


  public void setProductRatePlanChargeId(String productRatePlanChargeId) {
    
    
    
    this.productRatePlanChargeId = productRatePlanChargeId;
  }


  public GETSubscriptionRatePlanChargesType quantity(Double quantity) {
    
    
    
    
    this.quantity = quantity;
    return this;
  }

  public GETSubscriptionRatePlanChargesType quantity(Integer quantity) {
    
    
    
    
    this.quantity = quantity.doubleValue();
    return this;
  }

   /**
   * The quantity of units, such as the number of authors in a hosted wiki service. Valid for all charge models except for Flat Fee pricing. 
   * @return quantity
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The quantity of units, such as the number of authors in a hosted wiki service. Valid for all charge models except for Flat Fee pricing. ")

  public Double getQuantity() {
    return quantity;
  }


  public void setQuantity(Double quantity) {
    
    
    
    this.quantity = quantity;
  }


  public GETSubscriptionRatePlanChargesType ratingGroup(String ratingGroup) {
    
    
    
    
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


  public GETSubscriptionRatePlanChargesType revenueRecognitionTiming(RevenueRecognitionTimingEnum revenueRecognitionTiming) {
    
    
    
    
    this.revenueRecognitionTiming = revenueRecognitionTiming;
    return this;
  }

   /**
   * Specifies the type of revenue recognition timing.  Predefined options are listed as enum values in this API Reference. Other options might also be avaliable depending on the &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Enable_Order_to_Revenue/Configure_revenue_settings/Configure_revenue_recognition_policy\&quot; target&#x3D;\&quot;_blank\&quot;&gt;revenue recognition policy configuration&lt;/a&gt; in the Zuora Billing UI.  **Note**: This field is only available if you have the Order to Revenue feature enabled.     
   * @return revenueRecognitionTiming
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Specifies the type of revenue recognition timing.  Predefined options are listed as enum values in this API Reference. Other options might also be avaliable depending on the <a href=\"https://knowledgecenter.zuora.com/Zuora_Billing/Enable_Order_to_Revenue/Configure_revenue_settings/Configure_revenue_recognition_policy\" target=\"_blank\">revenue recognition policy configuration</a> in the Zuora Billing UI.  **Note**: This field is only available if you have the Order to Revenue feature enabled.     ")

  public RevenueRecognitionTimingEnum getRevenueRecognitionTiming() {
    return revenueRecognitionTiming;
  }


  public void setRevenueRecognitionTiming(RevenueRecognitionTimingEnum revenueRecognitionTiming) {
    
    
    
    this.revenueRecognitionTiming = revenueRecognitionTiming;
  }


  public GETSubscriptionRatePlanChargesType revenueAmortizationMethod(RevenueAmortizationMethodEnum revenueAmortizationMethod) {
    
    
    
    
    this.revenueAmortizationMethod = revenueAmortizationMethod;
    return this;
  }

   /**
   * Specifies the type of revenue amortization method.  Predefined options are listed as enum values in this API Reference. Other options might also be avaliable depending on the &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Enable_Order_to_Revenue/Configure_revenue_settings/Configure_revenue_recognition_policy\&quot; target&#x3D;\&quot;_blank\&quot;&gt;revenue recognition policy configuration&lt;/a&gt; in the Zuora Billing UI.  **Note**: This field is only available if you have the Order to Revenue feature enabled.  
   * @return revenueAmortizationMethod
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Specifies the type of revenue amortization method.  Predefined options are listed as enum values in this API Reference. Other options might also be avaliable depending on the <a href=\"https://knowledgecenter.zuora.com/Zuora_Billing/Enable_Order_to_Revenue/Configure_revenue_settings/Configure_revenue_recognition_policy\" target=\"_blank\">revenue recognition policy configuration</a> in the Zuora Billing UI.  **Note**: This field is only available if you have the Order to Revenue feature enabled.  ")

  public RevenueAmortizationMethodEnum getRevenueAmortizationMethod() {
    return revenueAmortizationMethod;
  }


  public void setRevenueAmortizationMethod(RevenueAmortizationMethodEnum revenueAmortizationMethod) {
    
    
    
    this.revenueAmortizationMethod = revenueAmortizationMethod;
  }


  public GETSubscriptionRatePlanChargesType rolloverApply(RolloverApplyEnum rolloverApply) {
    
    
    
    
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


  public GETSubscriptionRatePlanChargesType rolloverPeriodLength(Integer rolloverPeriodLength) {
    
    
    
    
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


  public GETSubscriptionRatePlanChargesType rolloverPeriods(Double rolloverPeriods) {
    
    
    
    
    this.rolloverPeriods = rolloverPeriods;
    return this;
  }

  public GETSubscriptionRatePlanChargesType rolloverPeriods(Integer rolloverPeriods) {
    
    
    
    
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


  public GETSubscriptionRatePlanChargesType segment(Long segment) {
    
    
    
    
    this.segment = segment;
    return this;
  }

   /**
   * The identifying number of the subscription rate plan segment. Segments are numbered sequentially, starting with 1. 
   * @return segment
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The identifying number of the subscription rate plan segment. Segments are numbered sequentially, starting with 1. ")

  public Long getSegment() {
    return segment;
  }


  public void setSegment(Long segment) {
    
    
    
    this.segment = segment;
  }


  public GETSubscriptionRatePlanChargesType smoothingModel(String smoothingModel) {
    
    
    
    
    this.smoothingModel = smoothingModel;
    return this;
  }

   /**
   * Specifies when revenue recognition begins. When charge model is &#x60;Overage&#x60; or &#x60;TieredWithOverage&#x60;, &#x60;smoothingModel&#x60; will be one of the following values:  * &#x60;ContractEffectiveDate&#x60; * &#x60;ServiceActivationDate&#x60; * &#x60;CustomerAcceptanceDate&#x60; 
   * @return smoothingModel
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Specifies when revenue recognition begins. When charge model is `Overage` or `TieredWithOverage`, `smoothingModel` will be one of the following values:  * `ContractEffectiveDate` * `ServiceActivationDate` * `CustomerAcceptanceDate` ")

  public String getSmoothingModel() {
    return smoothingModel;
  }


  public void setSmoothingModel(String smoothingModel) {
    
    
    
    this.smoothingModel = smoothingModel;
  }


  public GETSubscriptionRatePlanChargesType specificBillingPeriod(Long specificBillingPeriod) {
    
    
    
    
    this.specificBillingPeriod = specificBillingPeriod;
    return this;
  }

   /**
   * Customizes the number of month or week for the charges billing period. This field is required if you set the value of the &#x60;BillingPeriod&#x60; field to &#x60;Specific_Months&#x60; or &#x60;Specific_Weeks&#x60;. 
   * @return specificBillingPeriod
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Customizes the number of month or week for the charges billing period. This field is required if you set the value of the `BillingPeriod` field to `Specific_Months` or `Specific_Weeks`. ")

  public Long getSpecificBillingPeriod() {
    return specificBillingPeriod;
  }


  public void setSpecificBillingPeriod(Long specificBillingPeriod) {
    
    
    
    this.specificBillingPeriod = specificBillingPeriod;
  }


  public GETSubscriptionRatePlanChargesType specificEndDate(LocalDate specificEndDate) {
    
    
    
    
    this.specificEndDate = specificEndDate;
    return this;
  }

   /**
   * The specific date on which the charge ends. If the subscription ends before the specific end date, the charge ends when the subscription ends. But if the subscription end date is subsequently changed through a Renewal, or Terms and Conditions amendment, the charge will end on the specific end date. 
   * @return specificEndDate
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The specific date on which the charge ends. If the subscription ends before the specific end date, the charge ends when the subscription ends. But if the subscription end date is subsequently changed through a Renewal, or Terms and Conditions amendment, the charge will end on the specific end date. ")

  public LocalDate getSpecificEndDate() {
    return specificEndDate;
  }


  public void setSpecificEndDate(LocalDate specificEndDate) {
    
    
    
    this.specificEndDate = specificEndDate;
  }


  public GETSubscriptionRatePlanChargesType specificListPriceBase(Object specificListPriceBase) {
    
    
    
    
    this.specificListPriceBase = specificListPriceBase;
    return this;
  }

   /**
   * The number of months for the list price base of the charge.   **Note**:    - This field is available only if you have the &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Billing/Subscriptions/Product_Catalog/I_Annual_List_Price\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Annual List Price&lt;/a&gt; feature enabled.   - The value of this field is &#x60;null&#x60; if you do not set the value of the &#x60;listPriceBase&#x60; field to &#x60;Per_Specific_Months&#x60;. 
   * @return specificListPriceBase
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The number of months for the list price base of the charge.   **Note**:    - This field is available only if you have the <a href=\"https://knowledgecenter.zuora.com/Billing/Subscriptions/Product_Catalog/I_Annual_List_Price\" target=\"_blank\">Annual List Price</a> feature enabled.   - The value of this field is `null` if you do not set the value of the `listPriceBase` field to `Per_Specific_Months`. ")

  public Object getSpecificListPriceBase() {
    return specificListPriceBase;
  }


  public void setSpecificListPriceBase(Object specificListPriceBase) {
    
    
    
    this.specificListPriceBase = specificListPriceBase;
  }


  public GETSubscriptionRatePlanChargesType subscriptionChargeDeliverySchedule(GETDeliveryScheduleType subscriptionChargeDeliverySchedule) {
    
    
    
    
    this.subscriptionChargeDeliverySchedule = subscriptionChargeDeliverySchedule;
    return this;
  }

   /**
   * Get subscriptionChargeDeliverySchedule
   * @return subscriptionChargeDeliverySchedule
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public GETDeliveryScheduleType getSubscriptionChargeDeliverySchedule() {
    return subscriptionChargeDeliverySchedule;
  }


  public void setSubscriptionChargeDeliverySchedule(GETDeliveryScheduleType subscriptionChargeDeliverySchedule) {
    
    
    
    this.subscriptionChargeDeliverySchedule = subscriptionChargeDeliverySchedule;
  }


  public GETSubscriptionRatePlanChargesType subscriptionChargeIntervalPricing(List<GETIntervalPriceType> subscriptionChargeIntervalPricing) {
    
    
    
    
    this.subscriptionChargeIntervalPricing = subscriptionChargeIntervalPricing;
    return this;
  }

  public GETSubscriptionRatePlanChargesType addSubscriptionChargeIntervalPricingItem(GETIntervalPriceType subscriptionChargeIntervalPricingItem) {
    if (this.subscriptionChargeIntervalPricing == null) {
      this.subscriptionChargeIntervalPricing = new ArrayList<>();
    }
    this.subscriptionChargeIntervalPricing.add(subscriptionChargeIntervalPricingItem);
    return this;
  }

   /**
   * Interval Pricing information. This field is available if the Offers feature is enabled. 
   * @return subscriptionChargeIntervalPricing
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Interval Pricing information. This field is available if the Offers feature is enabled. ")

  public List<GETIntervalPriceType> getSubscriptionChargeIntervalPricing() {
    return subscriptionChargeIntervalPricing;
  }


  public void setSubscriptionChargeIntervalPricing(List<GETIntervalPriceType> subscriptionChargeIntervalPricing) {
    
    
    
    this.subscriptionChargeIntervalPricing = subscriptionChargeIntervalPricing;
  }


  public GETSubscriptionRatePlanChargesType tcv(Double tcv) {
    
    
    
    
    this.tcv = tcv;
    return this;
  }

  public GETSubscriptionRatePlanChargesType tcv(Integer tcv) {
    
    
    
    
    this.tcv = tcv.doubleValue();
    return this;
  }

   /**
   * The total contract value. 
   * @return tcv
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The total contract value. ")

  public Double getTcv() {
    return tcv;
  }


  public void setTcv(Double tcv) {
    
    
    
    this.tcv = tcv;
  }


  public GETSubscriptionRatePlanChargesType tiers(List<GETTierType> tiers) {
    
    
    
    
    this.tiers = tiers;
    return this;
  }

  public GETSubscriptionRatePlanChargesType addTiersItem(GETTierType tiersItem) {
    if (this.tiers == null) {
      this.tiers = new ArrayList<>();
    }
    this.tiers.add(tiersItem);
    return this;
  }

   /**
   * One or many defined ranges with distinct pricing. 
   * @return tiers
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "One or many defined ranges with distinct pricing. ")

  public List<GETTierType> getTiers() {
    return tiers;
  }


  public void setTiers(List<GETTierType> tiers) {
    
    
    
    this.tiers = tiers;
  }


  public GETSubscriptionRatePlanChargesType triggerDate(LocalDate triggerDate) {
    
    
    
    
    this.triggerDate = triggerDate;
    return this;
  }

   /**
   * The date that the rate plan charge will be triggered. 
   * @return triggerDate
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The date that the rate plan charge will be triggered. ")

  public LocalDate getTriggerDate() {
    return triggerDate;
  }


  public void setTriggerDate(LocalDate triggerDate) {
    
    
    
    this.triggerDate = triggerDate;
  }


  public GETSubscriptionRatePlanChargesType triggerEvent(String triggerEvent) {
    
    
    
    
    this.triggerEvent = triggerEvent;
    return this;
  }

   /**
   * The event that will cause the rate plan charge to be triggered.  Possible values:   * &#x60;ContractEffective&#x60; * &#x60;ServiceActivation&#x60; * &#x60;CustomerAcceptance&#x60; * &#x60;SpecificDate&#x60; 
   * @return triggerEvent
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The event that will cause the rate plan charge to be triggered.  Possible values:   * `ContractEffective` * `ServiceActivation` * `CustomerAcceptance` * `SpecificDate` ")

  public String getTriggerEvent() {
    return triggerEvent;
  }


  public void setTriggerEvent(String triggerEvent) {
    
    
    
    this.triggerEvent = triggerEvent;
  }


  public GETSubscriptionRatePlanChargesType type(String type) {
    
    
    
    
    this.type = type;
    return this;
  }

   /**
   * Charge type. Possible values are: &#x60;OneTime&#x60;, &#x60;Recurring&#x60;, &#x60;Usage&#x60;. 
   * @return type
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Charge type. Possible values are: `OneTime`, `Recurring`, `Usage`. ")

  public String getType() {
    return type;
  }


  public void setType(String type) {
    
    
    
    this.type = type;
  }


  public GETSubscriptionRatePlanChargesType unusedUnitsCreditRates(Double unusedUnitsCreditRates) {
    
    
    
    
    this.unusedUnitsCreditRates = unusedUnitsCreditRates;
    return this;
  }

  public GETSubscriptionRatePlanChargesType unusedUnitsCreditRates(Integer unusedUnitsCreditRates) {
    
    
    
    
    this.unusedUnitsCreditRates = unusedUnitsCreditRates.doubleValue();
    return this;
  }

   /**
   * Specifies the rate to credit a customer for unused units of usage. This field is applicable only for overage charge models when the  &#x60;OverageUnusedUnitsCreditOption&#x60; field value is &#x60;CreditBySpecificRate&#x60;. 
   * @return unusedUnitsCreditRates
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Specifies the rate to credit a customer for unused units of usage. This field is applicable only for overage charge models when the  `OverageUnusedUnitsCreditOption` field value is `CreditBySpecificRate`. ")

  public Double getUnusedUnitsCreditRates() {
    return unusedUnitsCreditRates;
  }


  public void setUnusedUnitsCreditRates(Double unusedUnitsCreditRates) {
    
    
    
    this.unusedUnitsCreditRates = unusedUnitsCreditRates;
  }


  public GETSubscriptionRatePlanChargesType upsellOriginChargeNumber(String upsellOriginChargeNumber) {
    
    
    
    
    this.upsellOriginChargeNumber = upsellOriginChargeNumber;
    return this;
  }

   /**
   * The identifier of the original upselling charge associated with the current charge.  For a termed subscription, you can now use the \&quot;Create an order\&quot; API operation to perform an Add Product order action to make a product quantity upsell for per unit recurring charges. The benefit is that the charge added by this approach will be automatically combined with the original existing charge for which you want to upsell when the subscription is renewed. The approach is as follows: * Use an Add Product order action to add a charge that is of the same charge type, charge model, and charge end date as the existing per unit recurring charge for which you want to make a quantity upsell.  * In the preceding charge to add, use the &#x60;upsellOriginChargeNumber&#x60; field to specify the existing rate plan charge for which you want to make the quantity upsell.  Note that a termed subscription with such upsell charges can not be changed to an evergreen subscription.     **Note**: The Quantity Upsell feature is in the **Early Adopter** phase. We are actively soliciting feedback from a small set of early adopters before releasing it as generally available. If you want to join this early adopter program, submit a request at [Zuora Global Support](https://support.zuora.com).   
   * @return upsellOriginChargeNumber
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The identifier of the original upselling charge associated with the current charge.  For a termed subscription, you can now use the \"Create an order\" API operation to perform an Add Product order action to make a product quantity upsell for per unit recurring charges. The benefit is that the charge added by this approach will be automatically combined with the original existing charge for which you want to upsell when the subscription is renewed. The approach is as follows: * Use an Add Product order action to add a charge that is of the same charge type, charge model, and charge end date as the existing per unit recurring charge for which you want to make a quantity upsell.  * In the preceding charge to add, use the `upsellOriginChargeNumber` field to specify the existing rate plan charge for which you want to make the quantity upsell.  Note that a termed subscription with such upsell charges can not be changed to an evergreen subscription.     **Note**: The Quantity Upsell feature is in the **Early Adopter** phase. We are actively soliciting feedback from a small set of early adopters before releasing it as generally available. If you want to join this early adopter program, submit a request at [Zuora Global Support](https://support.zuora.com).   ")

  public String getUpsellOriginChargeNumber() {
    return upsellOriginChargeNumber;
  }


  public void setUpsellOriginChargeNumber(String upsellOriginChargeNumber) {
    
    
    
    this.upsellOriginChargeNumber = upsellOriginChargeNumber;
  }


  public GETSubscriptionRatePlanChargesType uom(String uom) {
    
    
    
    
    this.uom = uom;
    return this;
  }

   /**
   * Specifies the units to measure usage.  
   * @return uom
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Specifies the units to measure usage.  ")

  public String getUom() {
    return uom;
  }


  public void setUom(String uom) {
    
    
    
    this.uom = uom;
  }


  public GETSubscriptionRatePlanChargesType upToPeriods(String upToPeriods) {
    
    
    
    
    this.upToPeriods = upToPeriods;
    return this;
  }

   /**
   * Specifies the length of the period during which the charge is active. If this period ends before the subscription ends, the charge ends when this period ends.  If the subscription end date is subsequently changed through a Renewal, or Terms and Conditions amendment, the charge end date will change accordingly up to the original period end. 
   * @return upToPeriods
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Specifies the length of the period during which the charge is active. If this period ends before the subscription ends, the charge ends when this period ends.  If the subscription end date is subsequently changed through a Renewal, or Terms and Conditions amendment, the charge end date will change accordingly up to the original period end. ")

  public String getUpToPeriods() {
    return upToPeriods;
  }


  public void setUpToPeriods(String upToPeriods) {
    
    
    
    this.upToPeriods = upToPeriods;
  }


  public GETSubscriptionRatePlanChargesType upToPeriodsType(String upToPeriodsType) {
    
    
    
    
    this.upToPeriodsType = upToPeriodsType;
    return this;
  }

   /**
   * The period type used to define when the charge ends.   Values:  * &#x60;Billing_Periods&#x60; * &#x60;Days&#x60; * &#x60;Weeks&#x60; * &#x60;Months&#x60; * &#x60;Years&#x60; 
   * @return upToPeriodsType
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The period type used to define when the charge ends.   Values:  * `Billing_Periods` * `Days` * `Weeks` * `Months` * `Years` ")

  public String getUpToPeriodsType() {
    return upToPeriodsType;
  }


  public void setUpToPeriodsType(String upToPeriodsType) {
    
    
    
    this.upToPeriodsType = upToPeriodsType;
  }


  public GETSubscriptionRatePlanChargesType usageRecordRatingOption(String usageRecordRatingOption) {
    
    
    
    
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


  public GETSubscriptionRatePlanChargesType validityPeriodType(ValidityPeriodTypeEnum validityPeriodType) {
    
    
    
    
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
   * @return the GETSubscriptionRatePlanChargesType instance itself
   */
  public GETSubscriptionRatePlanChargesType putAdditionalProperty(String key, Object value) {
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
    GETSubscriptionRatePlanChargesType geTSubscriptionRatePlanChargesType = (GETSubscriptionRatePlanChargesType) o;
    return Objects.equals(this.description, geTSubscriptionRatePlanChargesType.description) &&
        Objects.equals(this.version, geTSubscriptionRatePlanChargesType.version) &&
        Objects.equals(this.amendedByOrderOn, geTSubscriptionRatePlanChargesType.amendedByOrderOn) &&
        Objects.equals(this.applyDiscountTo, geTSubscriptionRatePlanChargesType.applyDiscountTo) &&
        Objects.equals(this.applyToBillingPeriodPartially, geTSubscriptionRatePlanChargesType.applyToBillingPeriodPartially) &&
        Objects.equals(this.billingDay, geTSubscriptionRatePlanChargesType.billingDay) &&
        Objects.equals(this.billingPeriod, geTSubscriptionRatePlanChargesType.billingPeriod) &&
        Objects.equals(this.billingPeriodAlignment, geTSubscriptionRatePlanChargesType.billingPeriodAlignment) &&
        Objects.equals(this.billingTiming, geTSubscriptionRatePlanChargesType.billingTiming) &&
        Objects.equals(this.chargeFunction, geTSubscriptionRatePlanChargesType.chargeFunction) &&
        Objects.equals(this.commitmentType, geTSubscriptionRatePlanChargesType.commitmentType) &&
        Objects.equals(this.chargeModelConfiguration, geTSubscriptionRatePlanChargesType.chargeModelConfiguration) &&
        Objects.equals(this.chargedThroughDate, geTSubscriptionRatePlanChargesType.chargedThroughDate) &&
        Objects.equals(this.creditOption, geTSubscriptionRatePlanChargesType.creditOption) &&
        Objects.equals(this.currency, geTSubscriptionRatePlanChargesType.currency) &&
        Objects.equals(this.discountAmount, geTSubscriptionRatePlanChargesType.discountAmount) &&
        Objects.equals(this.discountApplyDetails, geTSubscriptionRatePlanChargesType.discountApplyDetails) &&
        Objects.equals(this.discountClass, geTSubscriptionRatePlanChargesType.discountClass) &&
        Objects.equals(this.discountLevel, geTSubscriptionRatePlanChargesType.discountLevel) &&
        Objects.equals(this.discountPercentage, geTSubscriptionRatePlanChargesType.discountPercentage) &&
        Objects.equals(this.dmrc, geTSubscriptionRatePlanChargesType.dmrc) &&
        Objects.equals(this.done, geTSubscriptionRatePlanChargesType.done) &&
        Objects.equals(this.drawdownRate, geTSubscriptionRatePlanChargesType.drawdownRate) &&
        Objects.equals(this.drawdownUom, geTSubscriptionRatePlanChargesType.drawdownUom) &&
        Objects.equals(this.dtcv, geTSubscriptionRatePlanChargesType.dtcv) &&
        Objects.equals(this.effectiveEndDate, geTSubscriptionRatePlanChargesType.effectiveEndDate) &&
        Objects.equals(this.effectiveStartDate, geTSubscriptionRatePlanChargesType.effectiveStartDate) &&
        Objects.equals(this.endDateCondition, geTSubscriptionRatePlanChargesType.endDateCondition) &&
        Objects.equals(this.excludeItemBillingFromRevenueAccounting, geTSubscriptionRatePlanChargesType.excludeItemBillingFromRevenueAccounting) &&
        Objects.equals(this.excludeItemBookingFromRevenueAccounting, geTSubscriptionRatePlanChargesType.excludeItemBookingFromRevenueAccounting) &&
        Objects.equals(this.id, geTSubscriptionRatePlanChargesType.id) &&
        Objects.equals(this.includedUnits, geTSubscriptionRatePlanChargesType.includedUnits) &&
        Objects.equals(this.invoiceScheduleId, geTSubscriptionRatePlanChargesType.invoiceScheduleId) &&
        Objects.equals(this.isAllocationEligible, geTSubscriptionRatePlanChargesType.isAllocationEligible) &&
        Objects.equals(this.isPrepaid, geTSubscriptionRatePlanChargesType.isPrepaid) &&
        Objects.equals(this.isRollover, geTSubscriptionRatePlanChargesType.isRollover) &&
        Objects.equals(this.isStackedDiscount, geTSubscriptionRatePlanChargesType.isStackedDiscount) &&
        Objects.equals(this.isUnbilled, geTSubscriptionRatePlanChargesType.isUnbilled) &&
        Objects.equals(this.listPriceBase, geTSubscriptionRatePlanChargesType.listPriceBase) &&
        Objects.equals(this.model, geTSubscriptionRatePlanChargesType.model) &&
        Objects.equals(this.mrr, geTSubscriptionRatePlanChargesType.mrr) &&
        Objects.equals(this.name, geTSubscriptionRatePlanChargesType.name) &&
        Objects.equals(this.number, geTSubscriptionRatePlanChargesType.number) &&
        Objects.equals(this.numberOfDeliveries, geTSubscriptionRatePlanChargesType.numberOfDeliveries) &&
        Objects.equals(this.numberOfPeriods, geTSubscriptionRatePlanChargesType.numberOfPeriods) &&
        Objects.equals(this.originalChargeId, geTSubscriptionRatePlanChargesType.originalChargeId) &&
        Objects.equals(this.originalOrderDate, geTSubscriptionRatePlanChargesType.originalOrderDate) &&
        Objects.equals(this.overageCalculationOption, geTSubscriptionRatePlanChargesType.overageCalculationOption) &&
        Objects.equals(this.overagePrice, geTSubscriptionRatePlanChargesType.overagePrice) &&
        Objects.equals(this.overageUnusedUnitsCreditOption, geTSubscriptionRatePlanChargesType.overageUnusedUnitsCreditOption) &&
        Objects.equals(this.prepaidOperationType, geTSubscriptionRatePlanChargesType.prepaidOperationType) &&
        Objects.equals(this.prepaidQuantity, geTSubscriptionRatePlanChargesType.prepaidQuantity) &&
        Objects.equals(this.prepaidTotalQuantity, geTSubscriptionRatePlanChargesType.prepaidTotalQuantity) &&
        Objects.equals(this.prepaidUom, geTSubscriptionRatePlanChargesType.prepaidUom) &&
        Objects.equals(this.price, geTSubscriptionRatePlanChargesType.price) &&
        Objects.equals(this.priceChangeOption, geTSubscriptionRatePlanChargesType.priceChangeOption) &&
        Objects.equals(this.priceIncreasePercentage, geTSubscriptionRatePlanChargesType.priceIncreasePercentage) &&
        Objects.equals(this.pricingSummary, geTSubscriptionRatePlanChargesType.pricingSummary) &&
        Objects.equals(this.processedThroughDate, geTSubscriptionRatePlanChargesType.processedThroughDate) &&
        Objects.equals(this.productCategory, geTSubscriptionRatePlanChargesType.productCategory) &&
        Objects.equals(this.productClass, geTSubscriptionRatePlanChargesType.productClass) &&
        Objects.equals(this.productFamily, geTSubscriptionRatePlanChargesType.productFamily) &&
        Objects.equals(this.productLine, geTSubscriptionRatePlanChargesType.productLine) &&
        Objects.equals(this.productRatePlanChargeId, geTSubscriptionRatePlanChargesType.productRatePlanChargeId) &&
        Objects.equals(this.quantity, geTSubscriptionRatePlanChargesType.quantity) &&
        Objects.equals(this.ratingGroup, geTSubscriptionRatePlanChargesType.ratingGroup) &&
        Objects.equals(this.revenueRecognitionTiming, geTSubscriptionRatePlanChargesType.revenueRecognitionTiming) &&
        Objects.equals(this.revenueAmortizationMethod, geTSubscriptionRatePlanChargesType.revenueAmortizationMethod) &&
        Objects.equals(this.rolloverApply, geTSubscriptionRatePlanChargesType.rolloverApply) &&
        Objects.equals(this.rolloverPeriodLength, geTSubscriptionRatePlanChargesType.rolloverPeriodLength) &&
        Objects.equals(this.rolloverPeriods, geTSubscriptionRatePlanChargesType.rolloverPeriods) &&
        Objects.equals(this.segment, geTSubscriptionRatePlanChargesType.segment) &&
        Objects.equals(this.smoothingModel, geTSubscriptionRatePlanChargesType.smoothingModel) &&
        Objects.equals(this.specificBillingPeriod, geTSubscriptionRatePlanChargesType.specificBillingPeriod) &&
        Objects.equals(this.specificEndDate, geTSubscriptionRatePlanChargesType.specificEndDate) &&
        Objects.equals(this.specificListPriceBase, geTSubscriptionRatePlanChargesType.specificListPriceBase) &&
        Objects.equals(this.subscriptionChargeDeliverySchedule, geTSubscriptionRatePlanChargesType.subscriptionChargeDeliverySchedule) &&
        Objects.equals(this.subscriptionChargeIntervalPricing, geTSubscriptionRatePlanChargesType.subscriptionChargeIntervalPricing) &&
        Objects.equals(this.tcv, geTSubscriptionRatePlanChargesType.tcv) &&
        Objects.equals(this.tiers, geTSubscriptionRatePlanChargesType.tiers) &&
        Objects.equals(this.triggerDate, geTSubscriptionRatePlanChargesType.triggerDate) &&
        Objects.equals(this.triggerEvent, geTSubscriptionRatePlanChargesType.triggerEvent) &&
        Objects.equals(this.type, geTSubscriptionRatePlanChargesType.type) &&
        Objects.equals(this.unusedUnitsCreditRates, geTSubscriptionRatePlanChargesType.unusedUnitsCreditRates) &&
        Objects.equals(this.upsellOriginChargeNumber, geTSubscriptionRatePlanChargesType.upsellOriginChargeNumber) &&
        Objects.equals(this.uom, geTSubscriptionRatePlanChargesType.uom) &&
        Objects.equals(this.upToPeriods, geTSubscriptionRatePlanChargesType.upToPeriods) &&
        Objects.equals(this.upToPeriodsType, geTSubscriptionRatePlanChargesType.upToPeriodsType) &&
        Objects.equals(this.usageRecordRatingOption, geTSubscriptionRatePlanChargesType.usageRecordRatingOption) &&
        Objects.equals(this.validityPeriodType, geTSubscriptionRatePlanChargesType.validityPeriodType)&&
        Objects.equals(this.additionalProperties, geTSubscriptionRatePlanChargesType.additionalProperties);
  }

  private static <T> boolean equalsNullable(JsonNullable<T> a, JsonNullable<T> b) {
    return a == b || (a != null && b != null && a.isPresent() && b.isPresent() && Objects.deepEquals(a.get(), b.get()));
  }

  @Override
  public int hashCode() {
    return Objects.hash(description, version, amendedByOrderOn, applyDiscountTo, applyToBillingPeriodPartially, billingDay, billingPeriod, billingPeriodAlignment, billingTiming, chargeFunction, commitmentType, chargeModelConfiguration, chargedThroughDate, creditOption, currency, discountAmount, discountApplyDetails, discountClass, discountLevel, discountPercentage, dmrc, done, drawdownRate, drawdownUom, dtcv, effectiveEndDate, effectiveStartDate, endDateCondition, excludeItemBillingFromRevenueAccounting, excludeItemBookingFromRevenueAccounting, id, includedUnits, invoiceScheduleId, isAllocationEligible, isPrepaid, isRollover, isStackedDiscount, isUnbilled, listPriceBase, model, mrr, name, number, numberOfDeliveries, numberOfPeriods, originalChargeId, originalOrderDate, overageCalculationOption, overagePrice, overageUnusedUnitsCreditOption, prepaidOperationType, prepaidQuantity, prepaidTotalQuantity, prepaidUom, price, priceChangeOption, priceIncreasePercentage, pricingSummary, processedThroughDate, productCategory, productClass, productFamily, productLine, productRatePlanChargeId, quantity, ratingGroup, revenueRecognitionTiming, revenueAmortizationMethod, rolloverApply, rolloverPeriodLength, rolloverPeriods, segment, smoothingModel, specificBillingPeriod, specificEndDate, specificListPriceBase, subscriptionChargeDeliverySchedule, subscriptionChargeIntervalPricing, tcv, tiers, triggerDate, triggerEvent, type, unusedUnitsCreditRates, upsellOriginChargeNumber, uom, upToPeriods, upToPeriodsType, usageRecordRatingOption, validityPeriodType, additionalProperties);
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
    sb.append("class GETSubscriptionRatePlanChargesType {\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    version: ").append(toIndentedString(version)).append("\n");
    sb.append("    amendedByOrderOn: ").append(toIndentedString(amendedByOrderOn)).append("\n");
    sb.append("    applyDiscountTo: ").append(toIndentedString(applyDiscountTo)).append("\n");
    sb.append("    applyToBillingPeriodPartially: ").append(toIndentedString(applyToBillingPeriodPartially)).append("\n");
    sb.append("    billingDay: ").append(toIndentedString(billingDay)).append("\n");
    sb.append("    billingPeriod: ").append(toIndentedString(billingPeriod)).append("\n");
    sb.append("    billingPeriodAlignment: ").append(toIndentedString(billingPeriodAlignment)).append("\n");
    sb.append("    billingTiming: ").append(toIndentedString(billingTiming)).append("\n");
    sb.append("    chargeFunction: ").append(toIndentedString(chargeFunction)).append("\n");
    sb.append("    commitmentType: ").append(toIndentedString(commitmentType)).append("\n");
    sb.append("    chargeModelConfiguration: ").append(toIndentedString(chargeModelConfiguration)).append("\n");
    sb.append("    chargedThroughDate: ").append(toIndentedString(chargedThroughDate)).append("\n");
    sb.append("    creditOption: ").append(toIndentedString(creditOption)).append("\n");
    sb.append("    currency: ").append(toIndentedString(currency)).append("\n");
    sb.append("    discountAmount: ").append(toIndentedString(discountAmount)).append("\n");
    sb.append("    discountApplyDetails: ").append(toIndentedString(discountApplyDetails)).append("\n");
    sb.append("    discountClass: ").append(toIndentedString(discountClass)).append("\n");
    sb.append("    discountLevel: ").append(toIndentedString(discountLevel)).append("\n");
    sb.append("    discountPercentage: ").append(toIndentedString(discountPercentage)).append("\n");
    sb.append("    dmrc: ").append(toIndentedString(dmrc)).append("\n");
    sb.append("    done: ").append(toIndentedString(done)).append("\n");
    sb.append("    drawdownRate: ").append(toIndentedString(drawdownRate)).append("\n");
    sb.append("    drawdownUom: ").append(toIndentedString(drawdownUom)).append("\n");
    sb.append("    dtcv: ").append(toIndentedString(dtcv)).append("\n");
    sb.append("    effectiveEndDate: ").append(toIndentedString(effectiveEndDate)).append("\n");
    sb.append("    effectiveStartDate: ").append(toIndentedString(effectiveStartDate)).append("\n");
    sb.append("    endDateCondition: ").append(toIndentedString(endDateCondition)).append("\n");
    sb.append("    excludeItemBillingFromRevenueAccounting: ").append(toIndentedString(excludeItemBillingFromRevenueAccounting)).append("\n");
    sb.append("    excludeItemBookingFromRevenueAccounting: ").append(toIndentedString(excludeItemBookingFromRevenueAccounting)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    includedUnits: ").append(toIndentedString(includedUnits)).append("\n");
    sb.append("    invoiceScheduleId: ").append(toIndentedString(invoiceScheduleId)).append("\n");
    sb.append("    isAllocationEligible: ").append(toIndentedString(isAllocationEligible)).append("\n");
    sb.append("    isPrepaid: ").append(toIndentedString(isPrepaid)).append("\n");
    sb.append("    isRollover: ").append(toIndentedString(isRollover)).append("\n");
    sb.append("    isStackedDiscount: ").append(toIndentedString(isStackedDiscount)).append("\n");
    sb.append("    isUnbilled: ").append(toIndentedString(isUnbilled)).append("\n");
    sb.append("    listPriceBase: ").append(toIndentedString(listPriceBase)).append("\n");
    sb.append("    model: ").append(toIndentedString(model)).append("\n");
    sb.append("    mrr: ").append(toIndentedString(mrr)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    number: ").append(toIndentedString(number)).append("\n");
    sb.append("    numberOfDeliveries: ").append(toIndentedString(numberOfDeliveries)).append("\n");
    sb.append("    numberOfPeriods: ").append(toIndentedString(numberOfPeriods)).append("\n");
    sb.append("    originalChargeId: ").append(toIndentedString(originalChargeId)).append("\n");
    sb.append("    originalOrderDate: ").append(toIndentedString(originalOrderDate)).append("\n");
    sb.append("    overageCalculationOption: ").append(toIndentedString(overageCalculationOption)).append("\n");
    sb.append("    overagePrice: ").append(toIndentedString(overagePrice)).append("\n");
    sb.append("    overageUnusedUnitsCreditOption: ").append(toIndentedString(overageUnusedUnitsCreditOption)).append("\n");
    sb.append("    prepaidOperationType: ").append(toIndentedString(prepaidOperationType)).append("\n");
    sb.append("    prepaidQuantity: ").append(toIndentedString(prepaidQuantity)).append("\n");
    sb.append("    prepaidTotalQuantity: ").append(toIndentedString(prepaidTotalQuantity)).append("\n");
    sb.append("    prepaidUom: ").append(toIndentedString(prepaidUom)).append("\n");
    sb.append("    price: ").append(toIndentedString(price)).append("\n");
    sb.append("    priceChangeOption: ").append(toIndentedString(priceChangeOption)).append("\n");
    sb.append("    priceIncreasePercentage: ").append(toIndentedString(priceIncreasePercentage)).append("\n");
    sb.append("    pricingSummary: ").append(toIndentedString(pricingSummary)).append("\n");
    sb.append("    processedThroughDate: ").append(toIndentedString(processedThroughDate)).append("\n");
    sb.append("    productCategory: ").append(toIndentedString(productCategory)).append("\n");
    sb.append("    productClass: ").append(toIndentedString(productClass)).append("\n");
    sb.append("    productFamily: ").append(toIndentedString(productFamily)).append("\n");
    sb.append("    productLine: ").append(toIndentedString(productLine)).append("\n");
    sb.append("    productRatePlanChargeId: ").append(toIndentedString(productRatePlanChargeId)).append("\n");
    sb.append("    quantity: ").append(toIndentedString(quantity)).append("\n");
    sb.append("    ratingGroup: ").append(toIndentedString(ratingGroup)).append("\n");
    sb.append("    revenueRecognitionTiming: ").append(toIndentedString(revenueRecognitionTiming)).append("\n");
    sb.append("    revenueAmortizationMethod: ").append(toIndentedString(revenueAmortizationMethod)).append("\n");
    sb.append("    rolloverApply: ").append(toIndentedString(rolloverApply)).append("\n");
    sb.append("    rolloverPeriodLength: ").append(toIndentedString(rolloverPeriodLength)).append("\n");
    sb.append("    rolloverPeriods: ").append(toIndentedString(rolloverPeriods)).append("\n");
    sb.append("    segment: ").append(toIndentedString(segment)).append("\n");
    sb.append("    smoothingModel: ").append(toIndentedString(smoothingModel)).append("\n");
    sb.append("    specificBillingPeriod: ").append(toIndentedString(specificBillingPeriod)).append("\n");
    sb.append("    specificEndDate: ").append(toIndentedString(specificEndDate)).append("\n");
    sb.append("    specificListPriceBase: ").append(toIndentedString(specificListPriceBase)).append("\n");
    sb.append("    subscriptionChargeDeliverySchedule: ").append(toIndentedString(subscriptionChargeDeliverySchedule)).append("\n");
    sb.append("    subscriptionChargeIntervalPricing: ").append(toIndentedString(subscriptionChargeIntervalPricing)).append("\n");
    sb.append("    tcv: ").append(toIndentedString(tcv)).append("\n");
    sb.append("    tiers: ").append(toIndentedString(tiers)).append("\n");
    sb.append("    triggerDate: ").append(toIndentedString(triggerDate)).append("\n");
    sb.append("    triggerEvent: ").append(toIndentedString(triggerEvent)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    unusedUnitsCreditRates: ").append(toIndentedString(unusedUnitsCreditRates)).append("\n");
    sb.append("    upsellOriginChargeNumber: ").append(toIndentedString(upsellOriginChargeNumber)).append("\n");
    sb.append("    uom: ").append(toIndentedString(uom)).append("\n");
    sb.append("    upToPeriods: ").append(toIndentedString(upToPeriods)).append("\n");
    sb.append("    upToPeriodsType: ").append(toIndentedString(upToPeriodsType)).append("\n");
    sb.append("    usageRecordRatingOption: ").append(toIndentedString(usageRecordRatingOption)).append("\n");
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
    openapiFields.add("version");
    openapiFields.add("amendedByOrderOn");
    openapiFields.add("applyDiscountTo");
    openapiFields.add("applyToBillingPeriodPartially");
    openapiFields.add("billingDay");
    openapiFields.add("billingPeriod");
    openapiFields.add("billingPeriodAlignment");
    openapiFields.add("billingTiming");
    openapiFields.add("chargeFunction");
    openapiFields.add("commitmentType");
    openapiFields.add("chargeModelConfiguration");
    openapiFields.add("chargedThroughDate");
    openapiFields.add("creditOption");
    openapiFields.add("currency");
    openapiFields.add("discountAmount");
    openapiFields.add("discountApplyDetails");
    openapiFields.add("discountClass");
    openapiFields.add("discountLevel");
    openapiFields.add("discountPercentage");
    openapiFields.add("dmrc");
    openapiFields.add("done");
    openapiFields.add("drawdownRate");
    openapiFields.add("drawdownUom");
    openapiFields.add("dtcv");
    openapiFields.add("effectiveEndDate");
    openapiFields.add("effectiveStartDate");
    openapiFields.add("endDateCondition");
    openapiFields.add("excludeItemBillingFromRevenueAccounting");
    openapiFields.add("excludeItemBookingFromRevenueAccounting");
    openapiFields.add("id");
    openapiFields.add("includedUnits");
    openapiFields.add("invoiceScheduleId");
    openapiFields.add("isAllocationEligible");
    openapiFields.add("isPrepaid");
    openapiFields.add("isRollover");
    openapiFields.add("isStackedDiscount");
    openapiFields.add("isUnbilled");
    openapiFields.add("listPriceBase");
    openapiFields.add("model");
    openapiFields.add("mrr");
    openapiFields.add("name");
    openapiFields.add("number");
    openapiFields.add("numberOfDeliveries");
    openapiFields.add("numberOfPeriods");
    openapiFields.add("originalChargeId");
    openapiFields.add("originalOrderDate");
    openapiFields.add("overageCalculationOption");
    openapiFields.add("overagePrice");
    openapiFields.add("overageUnusedUnitsCreditOption");
    openapiFields.add("prepaidOperationType");
    openapiFields.add("prepaidQuantity");
    openapiFields.add("prepaidTotalQuantity");
    openapiFields.add("prepaidUom");
    openapiFields.add("price");
    openapiFields.add("priceChangeOption");
    openapiFields.add("priceIncreasePercentage");
    openapiFields.add("pricingSummary");
    openapiFields.add("processedThroughDate");
    openapiFields.add("productCategory");
    openapiFields.add("productClass");
    openapiFields.add("productFamily");
    openapiFields.add("productLine");
    openapiFields.add("productRatePlanChargeId");
    openapiFields.add("quantity");
    openapiFields.add("ratingGroup");
    openapiFields.add("revenueRecognitionTiming");
    openapiFields.add("revenueAmortizationMethod");
    openapiFields.add("rolloverApply");
    openapiFields.add("rolloverPeriodLength");
    openapiFields.add("rolloverPeriods");
    openapiFields.add("segment");
    openapiFields.add("smoothingModel");
    openapiFields.add("specificBillingPeriod");
    openapiFields.add("specificEndDate");
    openapiFields.add("specificListPriceBase");
    openapiFields.add("subscriptionChargeDeliverySchedule");
    openapiFields.add("subscriptionChargeIntervalPricing");
    openapiFields.add("tcv");
    openapiFields.add("tiers");
    openapiFields.add("triggerDate");
    openapiFields.add("triggerEvent");
    openapiFields.add("type");
    openapiFields.add("unusedUnitsCreditRates");
    openapiFields.add("upsellOriginChargeNumber");
    openapiFields.add("uom");
    openapiFields.add("upToPeriods");
    openapiFields.add("upToPeriodsType");
    openapiFields.add("usageRecordRatingOption");
    openapiFields.add("validityPeriodType");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
  }

 /**
  * Validates the JSON Object and throws an exception if issues found
  *
  * @param jsonObj JSON Object
  * @throws IOException if the JSON Object is invalid with respect to GETSubscriptionRatePlanChargesType
  */
  public static void validateJsonObject(JsonObject jsonObj) throws IOException {
      if (jsonObj == null) {
        if (!GETSubscriptionRatePlanChargesType.openapiRequiredFields.isEmpty()) { // has required fields but JSON object is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in GETSubscriptionRatePlanChargesType is not found in the empty JSON string", GETSubscriptionRatePlanChargesType.openapiRequiredFields.toString()));
        }
      }
      if ((jsonObj.get("description") != null && !jsonObj.get("description").isJsonNull()) && !jsonObj.get("description").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `description` to be a primitive type in the JSON string but got `%s`", jsonObj.get("description").toString()));
      }
      if ((jsonObj.get("amendedByOrderOn") != null && !jsonObj.get("amendedByOrderOn").isJsonNull()) && !jsonObj.get("amendedByOrderOn").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `amendedByOrderOn` to be a primitive type in the JSON string but got `%s`", jsonObj.get("amendedByOrderOn").toString()));
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
      if ((jsonObj.get("chargeFunction") != null && !jsonObj.get("chargeFunction").isJsonNull()) && !jsonObj.get("chargeFunction").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `chargeFunction` to be a primitive type in the JSON string but got `%s`", jsonObj.get("chargeFunction").toString()));
      }
      if ((jsonObj.get("commitmentType") != null && !jsonObj.get("commitmentType").isJsonNull()) && !jsonObj.get("commitmentType").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `commitmentType` to be a primitive type in the JSON string but got `%s`", jsonObj.get("commitmentType").toString()));
      }
      // validate the optional field `chargeModelConfiguration`
      if (jsonObj.get("chargeModelConfiguration") != null && !jsonObj.get("chargeModelConfiguration").isJsonNull()) {
        ChargeModelConfigurationType.validateJsonObject(jsonObj.getAsJsonObject("chargeModelConfiguration"));
      }
      if ((jsonObj.get("creditOption") != null && !jsonObj.get("creditOption").isJsonNull()) && !jsonObj.get("creditOption").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `creditOption` to be a primitive type in the JSON string but got `%s`", jsonObj.get("creditOption").toString()));
      }
      if ((jsonObj.get("currency") != null && !jsonObj.get("currency").isJsonNull()) && !jsonObj.get("currency").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `currency` to be a primitive type in the JSON string but got `%s`", jsonObj.get("currency").toString()));
      }
      if (jsonObj.get("discountApplyDetails") != null && !jsonObj.get("discountApplyDetails").isJsonNull()) {
        JsonArray jsonArraydiscountApplyDetails = jsonObj.getAsJsonArray("discountApplyDetails");
        if (jsonArraydiscountApplyDetails != null) {
          // ensure the json data is an array
          if (!jsonObj.get("discountApplyDetails").isJsonArray()) {
            throw new IllegalArgumentException(String.format("Expected the field `discountApplyDetails` to be an array in the JSON string but got `%s`", jsonObj.get("discountApplyDetails").toString()));
          }

          // validate the optional field `discountApplyDetails` (array)
          for (int i = 0; i < jsonArraydiscountApplyDetails.size(); i++) {
            GETDiscountApplyDetailsType.validateJsonObject(jsonArraydiscountApplyDetails.get(i).getAsJsonObject());
          };
        }
      }
      if ((jsonObj.get("discountClass") != null && !jsonObj.get("discountClass").isJsonNull()) && !jsonObj.get("discountClass").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `discountClass` to be a primitive type in the JSON string but got `%s`", jsonObj.get("discountClass").toString()));
      }
      if ((jsonObj.get("discountLevel") != null && !jsonObj.get("discountLevel").isJsonNull()) && !jsonObj.get("discountLevel").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `discountLevel` to be a primitive type in the JSON string but got `%s`", jsonObj.get("discountLevel").toString()));
      }
      if ((jsonObj.get("drawdownUom") != null && !jsonObj.get("drawdownUom").isJsonNull()) && !jsonObj.get("drawdownUom").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `drawdownUom` to be a primitive type in the JSON string but got `%s`", jsonObj.get("drawdownUom").toString()));
      }
      if ((jsonObj.get("endDateCondition") != null && !jsonObj.get("endDateCondition").isJsonNull()) && !jsonObj.get("endDateCondition").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `endDateCondition` to be a primitive type in the JSON string but got `%s`", jsonObj.get("endDateCondition").toString()));
      }
      if ((jsonObj.get("id") != null && !jsonObj.get("id").isJsonNull()) && !jsonObj.get("id").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `id` to be a primitive type in the JSON string but got `%s`", jsonObj.get("id").toString()));
      }
      if ((jsonObj.get("invoiceScheduleId") != null && !jsonObj.get("invoiceScheduleId").isJsonNull()) && !jsonObj.get("invoiceScheduleId").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `invoiceScheduleId` to be a primitive type in the JSON string but got `%s`", jsonObj.get("invoiceScheduleId").toString()));
      }
      if ((jsonObj.get("listPriceBase") != null && !jsonObj.get("listPriceBase").isJsonNull()) && !jsonObj.get("listPriceBase").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `listPriceBase` to be a primitive type in the JSON string but got `%s`", jsonObj.get("listPriceBase").toString()));
      }
      if ((jsonObj.get("model") != null && !jsonObj.get("model").isJsonNull()) && !jsonObj.get("model").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `model` to be a primitive type in the JSON string but got `%s`", jsonObj.get("model").toString()));
      }
      if ((jsonObj.get("name") != null && !jsonObj.get("name").isJsonNull()) && !jsonObj.get("name").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `name` to be a primitive type in the JSON string but got `%s`", jsonObj.get("name").toString()));
      }
      if ((jsonObj.get("number") != null && !jsonObj.get("number").isJsonNull()) && !jsonObj.get("number").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `number` to be a primitive type in the JSON string but got `%s`", jsonObj.get("number").toString()));
      }
      if ((jsonObj.get("originalChargeId") != null && !jsonObj.get("originalChargeId").isJsonNull()) && !jsonObj.get("originalChargeId").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `originalChargeId` to be a primitive type in the JSON string but got `%s`", jsonObj.get("originalChargeId").toString()));
      }
      if ((jsonObj.get("overageCalculationOption") != null && !jsonObj.get("overageCalculationOption").isJsonNull()) && !jsonObj.get("overageCalculationOption").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `overageCalculationOption` to be a primitive type in the JSON string but got `%s`", jsonObj.get("overageCalculationOption").toString()));
      }
      if ((jsonObj.get("overageUnusedUnitsCreditOption") != null && !jsonObj.get("overageUnusedUnitsCreditOption").isJsonNull()) && !jsonObj.get("overageUnusedUnitsCreditOption").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `overageUnusedUnitsCreditOption` to be a primitive type in the JSON string but got `%s`", jsonObj.get("overageUnusedUnitsCreditOption").toString()));
      }
      if ((jsonObj.get("prepaidOperationType") != null && !jsonObj.get("prepaidOperationType").isJsonNull()) && !jsonObj.get("prepaidOperationType").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `prepaidOperationType` to be a primitive type in the JSON string but got `%s`", jsonObj.get("prepaidOperationType").toString()));
      }
      if ((jsonObj.get("prepaidUom") != null && !jsonObj.get("prepaidUom").isJsonNull()) && !jsonObj.get("prepaidUom").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `prepaidUom` to be a primitive type in the JSON string but got `%s`", jsonObj.get("prepaidUom").toString()));
      }
      if ((jsonObj.get("priceChangeOption") != null && !jsonObj.get("priceChangeOption").isJsonNull()) && !jsonObj.get("priceChangeOption").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `priceChangeOption` to be a primitive type in the JSON string but got `%s`", jsonObj.get("priceChangeOption").toString()));
      }
      if ((jsonObj.get("pricingSummary") != null && !jsonObj.get("pricingSummary").isJsonNull()) && !jsonObj.get("pricingSummary").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `pricingSummary` to be a primitive type in the JSON string but got `%s`", jsonObj.get("pricingSummary").toString()));
      }
      if ((jsonObj.get("productCategory") != null && !jsonObj.get("productCategory").isJsonNull()) && !jsonObj.get("productCategory").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `productCategory` to be a primitive type in the JSON string but got `%s`", jsonObj.get("productCategory").toString()));
      }
      if ((jsonObj.get("productClass") != null && !jsonObj.get("productClass").isJsonNull()) && !jsonObj.get("productClass").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `productClass` to be a primitive type in the JSON string but got `%s`", jsonObj.get("productClass").toString()));
      }
      if ((jsonObj.get("productFamily") != null && !jsonObj.get("productFamily").isJsonNull()) && !jsonObj.get("productFamily").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `productFamily` to be a primitive type in the JSON string but got `%s`", jsonObj.get("productFamily").toString()));
      }
      if ((jsonObj.get("productLine") != null && !jsonObj.get("productLine").isJsonNull()) && !jsonObj.get("productLine").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `productLine` to be a primitive type in the JSON string but got `%s`", jsonObj.get("productLine").toString()));
      }
      if ((jsonObj.get("productRatePlanChargeId") != null && !jsonObj.get("productRatePlanChargeId").isJsonNull()) && !jsonObj.get("productRatePlanChargeId").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `productRatePlanChargeId` to be a primitive type in the JSON string but got `%s`", jsonObj.get("productRatePlanChargeId").toString()));
      }
      if ((jsonObj.get("ratingGroup") != null && !jsonObj.get("ratingGroup").isJsonNull()) && !jsonObj.get("ratingGroup").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `ratingGroup` to be a primitive type in the JSON string but got `%s`", jsonObj.get("ratingGroup").toString()));
      }
      if ((jsonObj.get("revenueRecognitionTiming") != null && !jsonObj.get("revenueRecognitionTiming").isJsonNull()) && !jsonObj.get("revenueRecognitionTiming").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `revenueRecognitionTiming` to be a primitive type in the JSON string but got `%s`", jsonObj.get("revenueRecognitionTiming").toString()));
      }
      if ((jsonObj.get("revenueAmortizationMethod") != null && !jsonObj.get("revenueAmortizationMethod").isJsonNull()) && !jsonObj.get("revenueAmortizationMethod").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `revenueAmortizationMethod` to be a primitive type in the JSON string but got `%s`", jsonObj.get("revenueAmortizationMethod").toString()));
      }
      if ((jsonObj.get("rolloverApply") != null && !jsonObj.get("rolloverApply").isJsonNull()) && !jsonObj.get("rolloverApply").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `rolloverApply` to be a primitive type in the JSON string but got `%s`", jsonObj.get("rolloverApply").toString()));
      }
      if ((jsonObj.get("smoothingModel") != null && !jsonObj.get("smoothingModel").isJsonNull()) && !jsonObj.get("smoothingModel").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `smoothingModel` to be a primitive type in the JSON string but got `%s`", jsonObj.get("smoothingModel").toString()));
      }
      // validate the optional field `subscriptionChargeDeliverySchedule`
      if (jsonObj.get("subscriptionChargeDeliverySchedule") != null && !jsonObj.get("subscriptionChargeDeliverySchedule").isJsonNull()) {
        GETDeliveryScheduleType.validateJsonObject(jsonObj.getAsJsonObject("subscriptionChargeDeliverySchedule"));
      }
      if (jsonObj.get("subscriptionChargeIntervalPricing") != null && !jsonObj.get("subscriptionChargeIntervalPricing").isJsonNull()) {
        JsonArray jsonArraysubscriptionChargeIntervalPricing = jsonObj.getAsJsonArray("subscriptionChargeIntervalPricing");
        if (jsonArraysubscriptionChargeIntervalPricing != null) {
          // ensure the json data is an array
          if (!jsonObj.get("subscriptionChargeIntervalPricing").isJsonArray()) {
            throw new IllegalArgumentException(String.format("Expected the field `subscriptionChargeIntervalPricing` to be an array in the JSON string but got `%s`", jsonObj.get("subscriptionChargeIntervalPricing").toString()));
          }

          // validate the optional field `subscriptionChargeIntervalPricing` (array)
          for (int i = 0; i < jsonArraysubscriptionChargeIntervalPricing.size(); i++) {
            GETIntervalPriceType.validateJsonObject(jsonArraysubscriptionChargeIntervalPricing.get(i).getAsJsonObject());
          };
        }
      }
      if (jsonObj.get("tiers") != null && !jsonObj.get("tiers").isJsonNull()) {
        JsonArray jsonArraytiers = jsonObj.getAsJsonArray("tiers");
        if (jsonArraytiers != null) {
          // ensure the json data is an array
          if (!jsonObj.get("tiers").isJsonArray()) {
            throw new IllegalArgumentException(String.format("Expected the field `tiers` to be an array in the JSON string but got `%s`", jsonObj.get("tiers").toString()));
          }

          // validate the optional field `tiers` (array)
          for (int i = 0; i < jsonArraytiers.size(); i++) {
            GETTierType.validateJsonObject(jsonArraytiers.get(i).getAsJsonObject());
          };
        }
      }
      if ((jsonObj.get("triggerEvent") != null && !jsonObj.get("triggerEvent").isJsonNull()) && !jsonObj.get("triggerEvent").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `triggerEvent` to be a primitive type in the JSON string but got `%s`", jsonObj.get("triggerEvent").toString()));
      }
      if ((jsonObj.get("type") != null && !jsonObj.get("type").isJsonNull()) && !jsonObj.get("type").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `type` to be a primitive type in the JSON string but got `%s`", jsonObj.get("type").toString()));
      }
      if ((jsonObj.get("upsellOriginChargeNumber") != null && !jsonObj.get("upsellOriginChargeNumber").isJsonNull()) && !jsonObj.get("upsellOriginChargeNumber").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `upsellOriginChargeNumber` to be a primitive type in the JSON string but got `%s`", jsonObj.get("upsellOriginChargeNumber").toString()));
      }
      if ((jsonObj.get("uom") != null && !jsonObj.get("uom").isJsonNull()) && !jsonObj.get("uom").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `uom` to be a primitive type in the JSON string but got `%s`", jsonObj.get("uom").toString()));
      }
      if ((jsonObj.get("upToPeriods") != null && !jsonObj.get("upToPeriods").isJsonNull()) && !jsonObj.get("upToPeriods").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `upToPeriods` to be a primitive type in the JSON string but got `%s`", jsonObj.get("upToPeriods").toString()));
      }
      if ((jsonObj.get("upToPeriodsType") != null && !jsonObj.get("upToPeriodsType").isJsonNull()) && !jsonObj.get("upToPeriodsType").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `upToPeriodsType` to be a primitive type in the JSON string but got `%s`", jsonObj.get("upToPeriodsType").toString()));
      }
      if ((jsonObj.get("usageRecordRatingOption") != null && !jsonObj.get("usageRecordRatingOption").isJsonNull()) && !jsonObj.get("usageRecordRatingOption").isJsonPrimitive()) {
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
       if (!GETSubscriptionRatePlanChargesType.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'GETSubscriptionRatePlanChargesType' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<GETSubscriptionRatePlanChargesType> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(GETSubscriptionRatePlanChargesType.class));

       return (TypeAdapter<T>) new TypeAdapter<GETSubscriptionRatePlanChargesType>() {
           @Override
           public void write(JsonWriter out, GETSubscriptionRatePlanChargesType value) throws IOException {
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
           public GETSubscriptionRatePlanChargesType read(JsonReader in) throws IOException {
             JsonObject jsonObj = elementAdapter.read(in).getAsJsonObject();
             validateJsonObject(jsonObj);
             // store additional fields in the deserialized instance
             GETSubscriptionRatePlanChargesType instance = thisAdapter.fromJsonTree(jsonObj);
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
  * Create an instance of GETSubscriptionRatePlanChargesType given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of GETSubscriptionRatePlanChargesType
  * @throws IOException if the JSON string is invalid with respect to GETSubscriptionRatePlanChargesType
  */
  public static GETSubscriptionRatePlanChargesType fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, GETSubscriptionRatePlanChargesType.class);
  }

 /**
  * Convert an instance of GETSubscriptionRatePlanChargesType to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

