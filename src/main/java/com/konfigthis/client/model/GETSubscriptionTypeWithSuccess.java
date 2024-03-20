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
import com.konfigthis.client.model.GETAccountSummaryTypeBillToContact;
import com.konfigthis.client.model.GETAccountSummaryTypeSoldToContact;
import com.konfigthis.client.model.GETSubscriptionRatePlanType;
import com.konfigthis.client.model.GETSubscriptionStatusHistoryType;
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
 * GETSubscriptionTypeWithSuccess
 */@javax.annotation.Generated(value = "Generated by https://konfigthis.com")
public class GETSubscriptionTypeWithSuccess {
  public static final String SERIALIZED_NAME_VERSION = "version";
  @SerializedName(SERIALIZED_NAME_VERSION)
  private Long version;

  public static final String SERIALIZED_NAME_ACCOUNT_ID = "accountId";
  @SerializedName(SERIALIZED_NAME_ACCOUNT_ID)
  private String accountId;

  public static final String SERIALIZED_NAME_ACCOUNT_NAME = "accountName";
  @SerializedName(SERIALIZED_NAME_ACCOUNT_NAME)
  private String accountName;

  public static final String SERIALIZED_NAME_ACCOUNT_NUMBER = "accountNumber";
  @SerializedName(SERIALIZED_NAME_ACCOUNT_NUMBER)
  private String accountNumber;

  public static final String SERIALIZED_NAME_AUTO_RENEW = "autoRenew";
  @SerializedName(SERIALIZED_NAME_AUTO_RENEW)
  private Boolean autoRenew;

  public static final String SERIALIZED_NAME_BILL_TO_CONTACT = "billToContact";
  @SerializedName(SERIALIZED_NAME_BILL_TO_CONTACT)
  private GETAccountSummaryTypeBillToContact billToContact;

  public static final String SERIALIZED_NAME_CANCEL_REASON = "cancelReason";
  @SerializedName(SERIALIZED_NAME_CANCEL_REASON)
  private String cancelReason;

  public static final String SERIALIZED_NAME_CONTRACT_EFFECTIVE_DATE = "contractEffectiveDate";
  @SerializedName(SERIALIZED_NAME_CONTRACT_EFFECTIVE_DATE)
  private LocalDate contractEffectiveDate;

  public static final String SERIALIZED_NAME_CONTRACTED_MRR = "contractedMrr";
  @SerializedName(SERIALIZED_NAME_CONTRACTED_MRR)
  private Double contractedMrr;

  public static final String SERIALIZED_NAME_CURRENCY = "currency";
  @SerializedName(SERIALIZED_NAME_CURRENCY)
  private String currency;

  public static final String SERIALIZED_NAME_CURRENT_TERM = "currentTerm";
  @SerializedName(SERIALIZED_NAME_CURRENT_TERM)
  private Long currentTerm;

  public static final String SERIALIZED_NAME_CURRENT_TERM_PERIOD_TYPE = "currentTermPeriodType";
  @SerializedName(SERIALIZED_NAME_CURRENT_TERM_PERIOD_TYPE)
  private String currentTermPeriodType;

  public static final String SERIALIZED_NAME_CUSTOMER_ACCEPTANCE_DATE = "customerAcceptanceDate";
  @SerializedName(SERIALIZED_NAME_CUSTOMER_ACCEPTANCE_DATE)
  private LocalDate customerAcceptanceDate;

  /**
   * An enum field on the Subscription object to indicate the name of a third-party store. This field is used to represent subscriptions created through third-party stores. 
   */
  @JsonAdapter(ExternallyManagedByEnum.Adapter.class)
 public enum ExternallyManagedByEnum {
    AMAZON("Amazon"),
    
    APPLE("Apple"),
    
    GOOGLE("Google"),
    
    ROKU("Roku");

    private String value;

    ExternallyManagedByEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static ExternallyManagedByEnum fromValue(String value) {
      for (ExternallyManagedByEnum b : ExternallyManagedByEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<ExternallyManagedByEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final ExternallyManagedByEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public ExternallyManagedByEnum read(final JsonReader jsonReader) throws IOException {
        String value =  jsonReader.nextString();
        return ExternallyManagedByEnum.fromValue(value);
      }
    }
  }

  public static final String SERIALIZED_NAME_EXTERNALLY_MANAGED_BY = "externallyManagedBy";
  @SerializedName(SERIALIZED_NAME_EXTERNALLY_MANAGED_BY)
  private ExternallyManagedByEnum externallyManagedBy;

  public static final String SERIALIZED_NAME_ID = "id";
  @SerializedName(SERIALIZED_NAME_ID)
  private String id;

  public static final String SERIALIZED_NAME_INITIAL_TERM = "initialTerm";
  @SerializedName(SERIALIZED_NAME_INITIAL_TERM)
  private Long initialTerm;

  public static final String SERIALIZED_NAME_INITIAL_TERM_PERIOD_TYPE = "initialTermPeriodType";
  @SerializedName(SERIALIZED_NAME_INITIAL_TERM_PERIOD_TYPE)
  private String initialTermPeriodType;

  public static final String SERIALIZED_NAME_INVOICE_GROUP_NUMBER = "invoiceGroupNumber";
  @SerializedName(SERIALIZED_NAME_INVOICE_GROUP_NUMBER)
  private String invoiceGroupNumber;

  public static final String SERIALIZED_NAME_INVOICE_OWNER_ACCOUNT_ID = "invoiceOwnerAccountId";
  @SerializedName(SERIALIZED_NAME_INVOICE_OWNER_ACCOUNT_ID)
  private String invoiceOwnerAccountId;

  public static final String SERIALIZED_NAME_INVOICE_OWNER_ACCOUNT_NAME = "invoiceOwnerAccountName";
  @SerializedName(SERIALIZED_NAME_INVOICE_OWNER_ACCOUNT_NAME)
  private String invoiceOwnerAccountName;

  public static final String SERIALIZED_NAME_INVOICE_OWNER_ACCOUNT_NUMBER = "invoiceOwnerAccountNumber";
  @SerializedName(SERIALIZED_NAME_INVOICE_OWNER_ACCOUNT_NUMBER)
  private String invoiceOwnerAccountNumber;

  public static final String SERIALIZED_NAME_INVOICE_SCHEDULE_ID = "invoiceScheduleId";
  @SerializedName(SERIALIZED_NAME_INVOICE_SCHEDULE_ID)
  private Integer invoiceScheduleId;

  public static final String SERIALIZED_NAME_INVOICE_SEPARATELY = "invoiceSeparately";
  @SerializedName(SERIALIZED_NAME_INVOICE_SEPARATELY)
  private String invoiceSeparately;

  public static final String SERIALIZED_NAME_INVOICE_TEMPLATE_ID = "invoiceTemplateId";
  @SerializedName(SERIALIZED_NAME_INVOICE_TEMPLATE_ID)
  private String invoiceTemplateId;

  public static final String SERIALIZED_NAME_INVOICE_TEMPLATE_NAME = "invoiceTemplateName";
  @SerializedName(SERIALIZED_NAME_INVOICE_TEMPLATE_NAME)
  private String invoiceTemplateName;

  public static final String SERIALIZED_NAME_IS_LATEST_VERSION = "isLatestVersion";
  @SerializedName(SERIALIZED_NAME_IS_LATEST_VERSION)
  private Boolean isLatestVersion;

  public static final String SERIALIZED_NAME_LAST_BOOKING_DATE = "lastBookingDate";
  @SerializedName(SERIALIZED_NAME_LAST_BOOKING_DATE)
  private LocalDate lastBookingDate;

  public static final String SERIALIZED_NAME_NOTES = "notes";
  @SerializedName(SERIALIZED_NAME_NOTES)
  private String notes;

  public static final String SERIALIZED_NAME_ORDER_NUMBER = "orderNumber";
  @SerializedName(SERIALIZED_NAME_ORDER_NUMBER)
  private String orderNumber;

  public static final String SERIALIZED_NAME_ORGANIZATION_LABEL = "organizationLabel";
  @SerializedName(SERIALIZED_NAME_ORGANIZATION_LABEL)
  private String organizationLabel;

  public static final String SERIALIZED_NAME_PAYMENT_TERM = "paymentTerm";
  @SerializedName(SERIALIZED_NAME_PAYMENT_TERM)
  private String paymentTerm;

  public static final String SERIALIZED_NAME_RATE_PLANS = "ratePlans";
  @SerializedName(SERIALIZED_NAME_RATE_PLANS)
  private List<GETSubscriptionRatePlanType> ratePlans = null;

  public static final String SERIALIZED_NAME_RENEWAL_SETTING = "renewalSetting";
  @SerializedName(SERIALIZED_NAME_RENEWAL_SETTING)
  private String renewalSetting;

  public static final String SERIALIZED_NAME_RENEWAL_TERM = "renewalTerm";
  @SerializedName(SERIALIZED_NAME_RENEWAL_TERM)
  private Long renewalTerm;

  public static final String SERIALIZED_NAME_RENEWAL_TERM_PERIOD_TYPE = "renewalTermPeriodType";
  @SerializedName(SERIALIZED_NAME_RENEWAL_TERM_PERIOD_TYPE)
  private String renewalTermPeriodType;

  public static final String SERIALIZED_NAME_REVISION = "revision";
  @SerializedName(SERIALIZED_NAME_REVISION)
  private String revision;

  public static final String SERIALIZED_NAME_SEQUENCE_SET_ID = "sequenceSetId";
  @SerializedName(SERIALIZED_NAME_SEQUENCE_SET_ID)
  private String sequenceSetId;

  public static final String SERIALIZED_NAME_SEQUENCE_SET_NAME = "sequenceSetName";
  @SerializedName(SERIALIZED_NAME_SEQUENCE_SET_NAME)
  private String sequenceSetName;

  public static final String SERIALIZED_NAME_SERVICE_ACTIVATION_DATE = "serviceActivationDate";
  @SerializedName(SERIALIZED_NAME_SERVICE_ACTIVATION_DATE)
  private LocalDate serviceActivationDate;

  public static final String SERIALIZED_NAME_SOLD_TO_CONTACT = "soldToContact";
  @SerializedName(SERIALIZED_NAME_SOLD_TO_CONTACT)
  private GETAccountSummaryTypeSoldToContact soldToContact;

  public static final String SERIALIZED_NAME_STATUS = "status";
  @SerializedName(SERIALIZED_NAME_STATUS)
  private String status;

  public static final String SERIALIZED_NAME_STATUS_HISTORY = "statusHistory";
  @SerializedName(SERIALIZED_NAME_STATUS_HISTORY)
  private List<GETSubscriptionStatusHistoryType> statusHistory = null;

  public static final String SERIALIZED_NAME_SUBSCRIPTION_END_DATE = "subscriptionEndDate";
  @SerializedName(SERIALIZED_NAME_SUBSCRIPTION_END_DATE)
  private LocalDate subscriptionEndDate;

  public static final String SERIALIZED_NAME_SUBSCRIPTION_NUMBER = "subscriptionNumber";
  @SerializedName(SERIALIZED_NAME_SUBSCRIPTION_NUMBER)
  private String subscriptionNumber;

  public static final String SERIALIZED_NAME_SUBSCRIPTION_START_DATE = "subscriptionStartDate";
  @SerializedName(SERIALIZED_NAME_SUBSCRIPTION_START_DATE)
  private LocalDate subscriptionStartDate;

  public static final String SERIALIZED_NAME_SUCCESS = "success";
  @SerializedName(SERIALIZED_NAME_SUCCESS)
  private Boolean success;

  public static final String SERIALIZED_NAME_TERM_END_DATE = "termEndDate";
  @SerializedName(SERIALIZED_NAME_TERM_END_DATE)
  private LocalDate termEndDate;

  public static final String SERIALIZED_NAME_TERM_START_DATE = "termStartDate";
  @SerializedName(SERIALIZED_NAME_TERM_START_DATE)
  private LocalDate termStartDate;

  public static final String SERIALIZED_NAME_TERM_TYPE = "termType";
  @SerializedName(SERIALIZED_NAME_TERM_TYPE)
  private String termType;

  public static final String SERIALIZED_NAME_TOTAL_CONTRACTED_VALUE = "totalContractedValue";
  @SerializedName(SERIALIZED_NAME_TOTAL_CONTRACTED_VALUE)
  private Double totalContractedValue;

  public static final String SERIALIZED_NAME_CPQ_BUNDLE_JSON_ID_Q_T = "CpqBundleJsonId__QT";
  @SerializedName(SERIALIZED_NAME_CPQ_BUNDLE_JSON_ID_Q_T)
  private String cpqBundleJsonIdQT;

  public static final String SERIALIZED_NAME_OPPORTUNITY_CLOSE_DATE_Q_T = "OpportunityCloseDate__QT";
  @SerializedName(SERIALIZED_NAME_OPPORTUNITY_CLOSE_DATE_Q_T)
  private LocalDate opportunityCloseDateQT;

  public static final String SERIALIZED_NAME_OPPORTUNITY_NAME_Q_T = "OpportunityName__QT";
  @SerializedName(SERIALIZED_NAME_OPPORTUNITY_NAME_Q_T)
  private String opportunityNameQT;

  public static final String SERIALIZED_NAME_QUOTE_BUSINESS_TYPE_Q_T = "QuoteBusinessType__QT";
  @SerializedName(SERIALIZED_NAME_QUOTE_BUSINESS_TYPE_Q_T)
  private String quoteBusinessTypeQT;

  public static final String SERIALIZED_NAME_QUOTE_NUMBER_Q_T = "QuoteNumber__QT";
  @SerializedName(SERIALIZED_NAME_QUOTE_NUMBER_Q_T)
  private String quoteNumberQT;

  public static final String SERIALIZED_NAME_QUOTE_TYPE_Q_T = "QuoteType__QT";
  @SerializedName(SERIALIZED_NAME_QUOTE_TYPE_Q_T)
  private String quoteTypeQT;

  public static final String SERIALIZED_NAME_INTEGRATION_ID_N_S = "IntegrationId__NS";
  @SerializedName(SERIALIZED_NAME_INTEGRATION_ID_N_S)
  private String integrationIdNS;

  public static final String SERIALIZED_NAME_INTEGRATION_STATUS_N_S = "IntegrationStatus__NS";
  @SerializedName(SERIALIZED_NAME_INTEGRATION_STATUS_N_S)
  private String integrationStatusNS;

  public static final String SERIALIZED_NAME_PROJECT_N_S = "Project__NS";
  @SerializedName(SERIALIZED_NAME_PROJECT_N_S)
  private String projectNS;

  public static final String SERIALIZED_NAME_SALES_ORDER_N_S = "SalesOrder__NS";
  @SerializedName(SERIALIZED_NAME_SALES_ORDER_N_S)
  private String salesOrderNS;

  public static final String SERIALIZED_NAME_SYNC_DATE_N_S = "SyncDate__NS";
  @SerializedName(SERIALIZED_NAME_SYNC_DATE_N_S)
  private String syncDateNS;

  public GETSubscriptionTypeWithSuccess() {
  }

  public GETSubscriptionTypeWithSuccess version(Long version) {
    
    
    
    
    this.version = version;
    return this;
  }

   /**
   * This is the subscription version automatically generated by Zuora Billing. Each order or amendment creates a new version of the subscription, which incorporates the changes made in the order or amendment.
   * @return version
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "This is the subscription version automatically generated by Zuora Billing. Each order or amendment creates a new version of the subscription, which incorporates the changes made in the order or amendment.")

  public Long getVersion() {
    return version;
  }


  public void setVersion(Long version) {
    
    
    
    this.version = version;
  }


  public GETSubscriptionTypeWithSuccess accountId(String accountId) {
    
    
    
    
    this.accountId = accountId;
    return this;
  }

   /**
   * The ID of the account associated with this subscription.
   * @return accountId
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The ID of the account associated with this subscription.")

  public String getAccountId() {
    return accountId;
  }


  public void setAccountId(String accountId) {
    
    
    
    this.accountId = accountId;
  }


  public GETSubscriptionTypeWithSuccess accountName(String accountName) {
    
    
    
    
    this.accountName = accountName;
    return this;
  }

   /**
   * The name of the account associated with this subscription.
   * @return accountName
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The name of the account associated with this subscription.")

  public String getAccountName() {
    return accountName;
  }


  public void setAccountName(String accountName) {
    
    
    
    this.accountName = accountName;
  }


  public GETSubscriptionTypeWithSuccess accountNumber(String accountNumber) {
    
    
    
    
    this.accountNumber = accountNumber;
    return this;
  }

   /**
   * The number of the account associated with this subscription.
   * @return accountNumber
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The number of the account associated with this subscription.")

  public String getAccountNumber() {
    return accountNumber;
  }


  public void setAccountNumber(String accountNumber) {
    
    
    
    this.accountNumber = accountNumber;
  }


  public GETSubscriptionTypeWithSuccess autoRenew(Boolean autoRenew) {
    
    
    
    
    this.autoRenew = autoRenew;
    return this;
  }

   /**
   * If &#x60;true&#x60;, the subscription automatically renews at the end of the term. Default is &#x60;false&#x60;. 
   * @return autoRenew
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "If `true`, the subscription automatically renews at the end of the term. Default is `false`. ")

  public Boolean getAutoRenew() {
    return autoRenew;
  }


  public void setAutoRenew(Boolean autoRenew) {
    
    
    
    this.autoRenew = autoRenew;
  }


  public GETSubscriptionTypeWithSuccess billToContact(GETAccountSummaryTypeBillToContact billToContact) {
    
    
    
    
    this.billToContact = billToContact;
    return this;
  }

   /**
   * Get billToContact
   * @return billToContact
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public GETAccountSummaryTypeBillToContact getBillToContact() {
    return billToContact;
  }


  public void setBillToContact(GETAccountSummaryTypeBillToContact billToContact) {
    
    
    
    this.billToContact = billToContact;
  }


  public GETSubscriptionTypeWithSuccess cancelReason(String cancelReason) {
    
    
    
    
    this.cancelReason = cancelReason;
    return this;
  }

   /**
   * The reason for a subscription cancellation copied from the &#x60;changeReason&#x60; field of a Cancel Subscription order action.   This field contains valid value only if a subscription is cancelled through the Orders UI or API. Otherwise, the value for this field will always be &#x60;null&#x60;. 
   * @return cancelReason
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The reason for a subscription cancellation copied from the `changeReason` field of a Cancel Subscription order action.   This field contains valid value only if a subscription is cancelled through the Orders UI or API. Otherwise, the value for this field will always be `null`. ")

  public String getCancelReason() {
    return cancelReason;
  }


  public void setCancelReason(String cancelReason) {
    
    
    
    this.cancelReason = cancelReason;
  }


  public GETSubscriptionTypeWithSuccess contractEffectiveDate(LocalDate contractEffectiveDate) {
    
    
    
    
    this.contractEffectiveDate = contractEffectiveDate;
    return this;
  }

   /**
   * Effective contract date for this subscription, as yyyy-mm-dd. 
   * @return contractEffectiveDate
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Effective contract date for this subscription, as yyyy-mm-dd. ")

  public LocalDate getContractEffectiveDate() {
    return contractEffectiveDate;
  }


  public void setContractEffectiveDate(LocalDate contractEffectiveDate) {
    
    
    
    this.contractEffectiveDate = contractEffectiveDate;
  }


  public GETSubscriptionTypeWithSuccess contractedMrr(Double contractedMrr) {
    
    
    
    
    this.contractedMrr = contractedMrr;
    return this;
  }

  public GETSubscriptionTypeWithSuccess contractedMrr(Integer contractedMrr) {
    
    
    
    
    this.contractedMrr = contractedMrr.doubleValue();
    return this;
  }

   /**
   * Monthly recurring revenue of the subscription. 
   * @return contractedMrr
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Monthly recurring revenue of the subscription. ")

  public Double getContractedMrr() {
    return contractedMrr;
  }


  public void setContractedMrr(Double contractedMrr) {
    
    
    
    this.contractedMrr = contractedMrr;
  }


  public GETSubscriptionTypeWithSuccess currency(String currency) {
    
    
    
    
    this.currency = currency;
    return this;
  }

   /**
   * The currency of the subscription. **Note**: This field is available only if you have the &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Bill_your_customers/Flexible_Billing/Multiple_Currencies\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Multiple Currencies&lt;/a&gt; feature enabled. 
   * @return currency
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The currency of the subscription. **Note**: This field is available only if you have the <a href=\"https://knowledgecenter.zuora.com/Zuora_Billing/Bill_your_customers/Flexible_Billing/Multiple_Currencies\" target=\"_blank\">Multiple Currencies</a> feature enabled. ")

  public String getCurrency() {
    return currency;
  }


  public void setCurrency(String currency) {
    
    
    
    this.currency = currency;
  }


  public GETSubscriptionTypeWithSuccess currentTerm(Long currentTerm) {
    
    
    
    
    this.currentTerm = currentTerm;
    return this;
  }

   /**
   * The length of the period for the current subscription term. 
   * @return currentTerm
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The length of the period for the current subscription term. ")

  public Long getCurrentTerm() {
    return currentTerm;
  }


  public void setCurrentTerm(Long currentTerm) {
    
    
    
    this.currentTerm = currentTerm;
  }


  public GETSubscriptionTypeWithSuccess currentTermPeriodType(String currentTermPeriodType) {
    
    
    
    
    this.currentTermPeriodType = currentTermPeriodType;
    return this;
  }

   /**
   * The period type for the current subscription term.  Values are:  * &#x60;Month&#x60; (default) * &#x60;Year&#x60; * &#x60;Day&#x60; * &#x60;Week&#x60; 
   * @return currentTermPeriodType
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The period type for the current subscription term.  Values are:  * `Month` (default) * `Year` * `Day` * `Week` ")

  public String getCurrentTermPeriodType() {
    return currentTermPeriodType;
  }


  public void setCurrentTermPeriodType(String currentTermPeriodType) {
    
    
    
    this.currentTermPeriodType = currentTermPeriodType;
  }


  public GETSubscriptionTypeWithSuccess customerAcceptanceDate(LocalDate customerAcceptanceDate) {
    
    
    
    
    this.customerAcceptanceDate = customerAcceptanceDate;
    return this;
  }

   /**
   * The date on which the services or products within a subscription have been accepted by the customer, as yyyy-mm-dd. 
   * @return customerAcceptanceDate
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The date on which the services or products within a subscription have been accepted by the customer, as yyyy-mm-dd. ")

  public LocalDate getCustomerAcceptanceDate() {
    return customerAcceptanceDate;
  }


  public void setCustomerAcceptanceDate(LocalDate customerAcceptanceDate) {
    
    
    
    this.customerAcceptanceDate = customerAcceptanceDate;
  }


  public GETSubscriptionTypeWithSuccess externallyManagedBy(ExternallyManagedByEnum externallyManagedBy) {
    
    
    
    
    this.externallyManagedBy = externallyManagedBy;
    return this;
  }

   /**
   * An enum field on the Subscription object to indicate the name of a third-party store. This field is used to represent subscriptions created through third-party stores. 
   * @return externallyManagedBy
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "An enum field on the Subscription object to indicate the name of a third-party store. This field is used to represent subscriptions created through third-party stores. ")

  public ExternallyManagedByEnum getExternallyManagedBy() {
    return externallyManagedBy;
  }


  public void setExternallyManagedBy(ExternallyManagedByEnum externallyManagedBy) {
    
    
    
    this.externallyManagedBy = externallyManagedBy;
  }


  public GETSubscriptionTypeWithSuccess id(String id) {
    
    
    
    
    this.id = id;
    return this;
  }

   /**
   * Subscription ID. 
   * @return id
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Subscription ID. ")

  public String getId() {
    return id;
  }


  public void setId(String id) {
    
    
    
    this.id = id;
  }


  public GETSubscriptionTypeWithSuccess initialTerm(Long initialTerm) {
    
    
    
    
    this.initialTerm = initialTerm;
    return this;
  }

   /**
   * The length of the period for the first subscription term. 
   * @return initialTerm
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The length of the period for the first subscription term. ")

  public Long getInitialTerm() {
    return initialTerm;
  }


  public void setInitialTerm(Long initialTerm) {
    
    
    
    this.initialTerm = initialTerm;
  }


  public GETSubscriptionTypeWithSuccess initialTermPeriodType(String initialTermPeriodType) {
    
    
    
    
    this.initialTermPeriodType = initialTermPeriodType;
    return this;
  }

   /**
   * The period type for the first subscription term.  Values are:  * &#x60;Month&#x60; (default) * &#x60;Year&#x60; * &#x60;Day&#x60; * &#x60;Week&#x60; 
   * @return initialTermPeriodType
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The period type for the first subscription term.  Values are:  * `Month` (default) * `Year` * `Day` * `Week` ")

  public String getInitialTermPeriodType() {
    return initialTermPeriodType;
  }


  public void setInitialTermPeriodType(String initialTermPeriodType) {
    
    
    
    this.initialTermPeriodType = initialTermPeriodType;
  }


  public GETSubscriptionTypeWithSuccess invoiceGroupNumber(String invoiceGroupNumber) {
    
    
    
    
    this.invoiceGroupNumber = invoiceGroupNumber;
    return this;
  }

   /**
   * The number of the invoice group associated with the subscription.  The value of this field is &#x60;null&#x60; if you have the [Flexible Billing Attributes](https://knowledgecenter.zuora.com/Billing/Subscriptions/Flexible_Billing_Attributes) feature disabled. 
   * @return invoiceGroupNumber
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The number of the invoice group associated with the subscription.  The value of this field is `null` if you have the [Flexible Billing Attributes](https://knowledgecenter.zuora.com/Billing/Subscriptions/Flexible_Billing_Attributes) feature disabled. ")

  public String getInvoiceGroupNumber() {
    return invoiceGroupNumber;
  }


  public void setInvoiceGroupNumber(String invoiceGroupNumber) {
    
    
    
    this.invoiceGroupNumber = invoiceGroupNumber;
  }


  public GETSubscriptionTypeWithSuccess invoiceOwnerAccountId(String invoiceOwnerAccountId) {
    
    
    
    
    this.invoiceOwnerAccountId = invoiceOwnerAccountId;
    return this;
  }

   /**
   * 
   * @return invoiceOwnerAccountId
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public String getInvoiceOwnerAccountId() {
    return invoiceOwnerAccountId;
  }


  public void setInvoiceOwnerAccountId(String invoiceOwnerAccountId) {
    
    
    
    this.invoiceOwnerAccountId = invoiceOwnerAccountId;
  }


  public GETSubscriptionTypeWithSuccess invoiceOwnerAccountName(String invoiceOwnerAccountName) {
    
    
    
    
    this.invoiceOwnerAccountName = invoiceOwnerAccountName;
    return this;
  }

   /**
   * 
   * @return invoiceOwnerAccountName
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public String getInvoiceOwnerAccountName() {
    return invoiceOwnerAccountName;
  }


  public void setInvoiceOwnerAccountName(String invoiceOwnerAccountName) {
    
    
    
    this.invoiceOwnerAccountName = invoiceOwnerAccountName;
  }


  public GETSubscriptionTypeWithSuccess invoiceOwnerAccountNumber(String invoiceOwnerAccountNumber) {
    
    
    
    
    this.invoiceOwnerAccountNumber = invoiceOwnerAccountNumber;
    return this;
  }

   /**
   * 
   * @return invoiceOwnerAccountNumber
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public String getInvoiceOwnerAccountNumber() {
    return invoiceOwnerAccountNumber;
  }


  public void setInvoiceOwnerAccountNumber(String invoiceOwnerAccountNumber) {
    
    
    
    this.invoiceOwnerAccountNumber = invoiceOwnerAccountNumber;
  }


  public GETSubscriptionTypeWithSuccess invoiceScheduleId(Integer invoiceScheduleId) {
    
    
    
    
    this.invoiceScheduleId = invoiceScheduleId;
    return this;
  }

   /**
   * The ID of the invoice schedule associated with the subscription.  If multiple invoice schedules are created for different terms of a subscription, this field stores the latest invoice schedule.  **Note**: This field is available only if you have the &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Bill_your_customers/Flexible_Billing/Billing_Schedule\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Billing Schedule&lt;/a&gt; feature enabled. 
   * @return invoiceScheduleId
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The ID of the invoice schedule associated with the subscription.  If multiple invoice schedules are created for different terms of a subscription, this field stores the latest invoice schedule.  **Note**: This field is available only if you have the <a href=\"https://knowledgecenter.zuora.com/Zuora_Billing/Bill_your_customers/Flexible_Billing/Billing_Schedule\" target=\"_blank\">Billing Schedule</a> feature enabled. ")

  public Integer getInvoiceScheduleId() {
    return invoiceScheduleId;
  }


  public void setInvoiceScheduleId(Integer invoiceScheduleId) {
    
    
    
    this.invoiceScheduleId = invoiceScheduleId;
  }


  public GETSubscriptionTypeWithSuccess invoiceSeparately(String invoiceSeparately) {
    
    
    
    
    this.invoiceSeparately = invoiceSeparately;
    return this;
  }

   /**
   * Separates a single subscription from other subscriptions and creates an invoice for the subscription.   If the value is &#x60;true&#x60;, the subscription is billed separately from other subscriptions. If the value is &#x60;false&#x60;, the subscription is included with other subscriptions in the account invoice. 
   * @return invoiceSeparately
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Separates a single subscription from other subscriptions and creates an invoice for the subscription.   If the value is `true`, the subscription is billed separately from other subscriptions. If the value is `false`, the subscription is included with other subscriptions in the account invoice. ")

  public String getInvoiceSeparately() {
    return invoiceSeparately;
  }


  public void setInvoiceSeparately(String invoiceSeparately) {
    
    
    
    this.invoiceSeparately = invoiceSeparately;
  }


  public GETSubscriptionTypeWithSuccess invoiceTemplateId(String invoiceTemplateId) {
    
    
    
    
    this.invoiceTemplateId = invoiceTemplateId;
    return this;
  }

   /**
   * The ID of the invoice template associated with the subscription.  **Note**:    - If you have the &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Bill_your_customers/Bill_customers_at_subscription_level/Flexible_Billing_Attributes\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Flexible Billing Attributes&lt;/a&gt; feature disabled, this field is unavailable in the request body and the value of this field is &#x60;null&#x60; in the response body.    - If you have the Flexible Billing Attributes feature enabled, and you do not specify this field in the request or you select **Default Template from Account** for this field during subscription creation, the value of this field is automatically set to &#x60;null&#x60; in the response body. 
   * @return invoiceTemplateId
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The ID of the invoice template associated with the subscription.  **Note**:    - If you have the <a href=\"https://knowledgecenter.zuora.com/Zuora_Billing/Bill_your_customers/Bill_customers_at_subscription_level/Flexible_Billing_Attributes\" target=\"_blank\">Flexible Billing Attributes</a> feature disabled, this field is unavailable in the request body and the value of this field is `null` in the response body.    - If you have the Flexible Billing Attributes feature enabled, and you do not specify this field in the request or you select **Default Template from Account** for this field during subscription creation, the value of this field is automatically set to `null` in the response body. ")

  public String getInvoiceTemplateId() {
    return invoiceTemplateId;
  }


  public void setInvoiceTemplateId(String invoiceTemplateId) {
    
    
    
    this.invoiceTemplateId = invoiceTemplateId;
  }


  public GETSubscriptionTypeWithSuccess invoiceTemplateName(String invoiceTemplateName) {
    
    
    
    
    this.invoiceTemplateName = invoiceTemplateName;
    return this;
  }

   /**
   * The name of the invoice template associated with the subscription.  **Note**:    - If you have the &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Bill_your_customers/Bill_customers_at_subscription_level/Flexible_Billing_Attributes\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Flexible Billing Attributes&lt;/a&gt; feature disabled, the value of this field is &#x60;null&#x60; in the response body.    - If you have the Flexible Billing Attributes feature enabled, and you do not specify the &#x60;invoiceTemplateId&#x60; field in the request or you select **Default Template from Account** for the &#x60;invoiceTemplateId&#x60; field during subscription creation, the value of the &#x60;invoiceTemplateName&#x60; field is automatically set to &#x60;null&#x60; in the response body.    
   * @return invoiceTemplateName
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The name of the invoice template associated with the subscription.  **Note**:    - If you have the <a href=\"https://knowledgecenter.zuora.com/Zuora_Billing/Bill_your_customers/Bill_customers_at_subscription_level/Flexible_Billing_Attributes\" target=\"_blank\">Flexible Billing Attributes</a> feature disabled, the value of this field is `null` in the response body.    - If you have the Flexible Billing Attributes feature enabled, and you do not specify the `invoiceTemplateId` field in the request or you select **Default Template from Account** for the `invoiceTemplateId` field during subscription creation, the value of the `invoiceTemplateName` field is automatically set to `null` in the response body.    ")

  public String getInvoiceTemplateName() {
    return invoiceTemplateName;
  }


  public void setInvoiceTemplateName(String invoiceTemplateName) {
    
    
    
    this.invoiceTemplateName = invoiceTemplateName;
  }


  public GETSubscriptionTypeWithSuccess isLatestVersion(Boolean isLatestVersion) {
    
    
    
    
    this.isLatestVersion = isLatestVersion;
    return this;
  }

   /**
   * If &#x60;true&#x60;, the current subscription object is the latest version.
   * @return isLatestVersion
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "If `true`, the current subscription object is the latest version.")

  public Boolean getIsLatestVersion() {
    return isLatestVersion;
  }


  public void setIsLatestVersion(Boolean isLatestVersion) {
    
    
    
    this.isLatestVersion = isLatestVersion;
  }


  public GETSubscriptionTypeWithSuccess lastBookingDate(LocalDate lastBookingDate) {
    
    
    
    
    this.lastBookingDate = lastBookingDate;
    return this;
  }

   /**
   * The last booking date of the subscription object. This field is writable only when the subscription is newly created as a first version subscription. You can override the date value when creating a subscription through the Subscribe and Amend API or the subscription creation UI (non-Orders). Otherwise, the default value &#x60;today&#x60; is set per the user&#39;s timezone. The value of this field is as follows: * For a new subscription created by the [Subscribe and Amend APIs](https://knowledgecenter.zuora.com/Billing/Subscriptions/Orders/Orders_Harmonization/Orders_Migration_Guidance#Subscribe_and_Amend_APIs_to_Migrate), this field has the value of the subscription creation date. * For a subscription changed by an amendment, this field has the value of the amendment booking date. * For a subscription created or changed by an order, this field has the value of the order date. 
   * @return lastBookingDate
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The last booking date of the subscription object. This field is writable only when the subscription is newly created as a first version subscription. You can override the date value when creating a subscription through the Subscribe and Amend API or the subscription creation UI (non-Orders). Otherwise, the default value `today` is set per the user's timezone. The value of this field is as follows: * For a new subscription created by the [Subscribe and Amend APIs](https://knowledgecenter.zuora.com/Billing/Subscriptions/Orders/Orders_Harmonization/Orders_Migration_Guidance#Subscribe_and_Amend_APIs_to_Migrate), this field has the value of the subscription creation date. * For a subscription changed by an amendment, this field has the value of the amendment booking date. * For a subscription created or changed by an order, this field has the value of the order date. ")

  public LocalDate getLastBookingDate() {
    return lastBookingDate;
  }


  public void setLastBookingDate(LocalDate lastBookingDate) {
    
    
    
    this.lastBookingDate = lastBookingDate;
  }


  public GETSubscriptionTypeWithSuccess notes(String notes) {
    
    
    
    
    this.notes = notes;
    return this;
  }

   /**
   * A string of up to 65,535 characters. 
   * @return notes
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "A string of up to 65,535 characters. ")

  public String getNotes() {
    return notes;
  }


  public void setNotes(String notes) {
    
    
    
    this.notes = notes;
  }


  public GETSubscriptionTypeWithSuccess orderNumber(String orderNumber) {
    
    
    
    
    this.orderNumber = orderNumber;
    return this;
  }

   /**
   * The order number of the order in which the changes on the subscription are made.   **Note:** This field is only available if you have the [Order Metrics](https://knowledgecenter.zuora.com/BC_Subscription_Management/Orders/AA_Overview_of_Orders#Order_Metrics) feature enabled. If you wish to have access to the feature, submit a request at [Zuora Global Support](http://support.zuora.com/). We will investigate your use cases and data before enabling this feature for you. 
   * @return orderNumber
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The order number of the order in which the changes on the subscription are made.   **Note:** This field is only available if you have the [Order Metrics](https://knowledgecenter.zuora.com/BC_Subscription_Management/Orders/AA_Overview_of_Orders#Order_Metrics) feature enabled. If you wish to have access to the feature, submit a request at [Zuora Global Support](http://support.zuora.com/). We will investigate your use cases and data before enabling this feature for you. ")

  public String getOrderNumber() {
    return orderNumber;
  }


  public void setOrderNumber(String orderNumber) {
    
    
    
    this.orderNumber = orderNumber;
  }


  public GETSubscriptionTypeWithSuccess organizationLabel(String organizationLabel) {
    
    
    
    
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


  public GETSubscriptionTypeWithSuccess paymentTerm(String paymentTerm) {
    
    
    
    
    this.paymentTerm = paymentTerm;
    return this;
  }

   /**
   * The name of the payment term associated with the subscription. For example, &#x60;Net 30&#x60;. The payment term determines the due dates of invoices.  **Note**:    - If you have the &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Bill_your_customers/Bill_customers_at_subscription_level/Flexible_Billing_Attributes\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Flexible Billing Attributes&lt;/a&gt; feature disabled, this field is unavailable in the request body and the value of this field is &#x60;null&#x60; in the response body.    - If you have the Flexible Billing Attributes feature enabled, and you do not specify this field in the request or you select **Default Term from Account** for this field during subscription creation, the value of this field is automatically set to &#x60;null&#x60; in the response body. 
   * @return paymentTerm
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The name of the payment term associated with the subscription. For example, `Net 30`. The payment term determines the due dates of invoices.  **Note**:    - If you have the <a href=\"https://knowledgecenter.zuora.com/Zuora_Billing/Bill_your_customers/Bill_customers_at_subscription_level/Flexible_Billing_Attributes\" target=\"_blank\">Flexible Billing Attributes</a> feature disabled, this field is unavailable in the request body and the value of this field is `null` in the response body.    - If you have the Flexible Billing Attributes feature enabled, and you do not specify this field in the request or you select **Default Term from Account** for this field during subscription creation, the value of this field is automatically set to `null` in the response body. ")

  public String getPaymentTerm() {
    return paymentTerm;
  }


  public void setPaymentTerm(String paymentTerm) {
    
    
    
    this.paymentTerm = paymentTerm;
  }


  public GETSubscriptionTypeWithSuccess ratePlans(List<GETSubscriptionRatePlanType> ratePlans) {
    
    
    
    
    this.ratePlans = ratePlans;
    return this;
  }

  public GETSubscriptionTypeWithSuccess addRatePlansItem(GETSubscriptionRatePlanType ratePlansItem) {
    if (this.ratePlans == null) {
      this.ratePlans = new ArrayList<>();
    }
    this.ratePlans.add(ratePlansItem);
    return this;
  }

   /**
   * Container for rate plans. 
   * @return ratePlans
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Container for rate plans. ")

  public List<GETSubscriptionRatePlanType> getRatePlans() {
    return ratePlans;
  }


  public void setRatePlans(List<GETSubscriptionRatePlanType> ratePlans) {
    
    
    
    this.ratePlans = ratePlans;
  }


  public GETSubscriptionTypeWithSuccess renewalSetting(String renewalSetting) {
    
    
    
    
    this.renewalSetting = renewalSetting;
    return this;
  }

   /**
   * Specifies whether a termed subscription will remain &#x60;TERMED&#x60; or change to &#x60;EVERGREEN&#x60; when it is renewed.   Values are:  * &#x60;RENEW_WITH_SPECIFIC_TERM&#x60; (default) * &#x60;RENEW_TO_EVERGREEN&#x60; 
   * @return renewalSetting
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Specifies whether a termed subscription will remain `TERMED` or change to `EVERGREEN` when it is renewed.   Values are:  * `RENEW_WITH_SPECIFIC_TERM` (default) * `RENEW_TO_EVERGREEN` ")

  public String getRenewalSetting() {
    return renewalSetting;
  }


  public void setRenewalSetting(String renewalSetting) {
    
    
    
    this.renewalSetting = renewalSetting;
  }


  public GETSubscriptionTypeWithSuccess renewalTerm(Long renewalTerm) {
    
    
    
    
    this.renewalTerm = renewalTerm;
    return this;
  }

   /**
   * The length of the period for the subscription renewal term. 
   * @return renewalTerm
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The length of the period for the subscription renewal term. ")

  public Long getRenewalTerm() {
    return renewalTerm;
  }


  public void setRenewalTerm(Long renewalTerm) {
    
    
    
    this.renewalTerm = renewalTerm;
  }


  public GETSubscriptionTypeWithSuccess renewalTermPeriodType(String renewalTermPeriodType) {
    
    
    
    
    this.renewalTermPeriodType = renewalTermPeriodType;
    return this;
  }

   /**
   * The period type for the subscription renewal term.  Values are:  * &#x60;Month&#x60; (default) * &#x60;Year&#x60; * &#x60;Day&#x60; * &#x60;Week&#x60; 
   * @return renewalTermPeriodType
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The period type for the subscription renewal term.  Values are:  * `Month` (default) * `Year` * `Day` * `Week` ")

  public String getRenewalTermPeriodType() {
    return renewalTermPeriodType;
  }


  public void setRenewalTermPeriodType(String renewalTermPeriodType) {
    
    
    
    this.renewalTermPeriodType = renewalTermPeriodType;
  }


  public GETSubscriptionTypeWithSuccess revision(String revision) {
    
    
    
    
    this.revision = revision;
    return this;
  }

   /**
   * An auto-generated decimal value uniquely tagged with a subscription. The value always contains one decimal place, for example, the revision of a new subscription is 1.0. If a further version of the subscription is created, the revision value will be increased by 1. Also, the revision value is always incremental regardless of deletion of subscription versions. 
   * @return revision
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "An auto-generated decimal value uniquely tagged with a subscription. The value always contains one decimal place, for example, the revision of a new subscription is 1.0. If a further version of the subscription is created, the revision value will be increased by 1. Also, the revision value is always incremental regardless of deletion of subscription versions. ")

  public String getRevision() {
    return revision;
  }


  public void setRevision(String revision) {
    
    
    
    this.revision = revision;
  }


  public GETSubscriptionTypeWithSuccess sequenceSetId(String sequenceSetId) {
    
    
    
    
    this.sequenceSetId = sequenceSetId;
    return this;
  }

   /**
   * The ID of the sequence set associated with the subscription.  **Note**:    - If you have the &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Bill_your_customers/Bill_customers_at_subscription_level/Flexible_Billing_Attributes\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Flexible Billing Attributes&lt;/a&gt; feature disabled, this field is unavailable in the request body and the value of this field is &#x60;null&#x60; in the response body.    - If you have the Flexible Billing Attributes feature enabled, and you do not specify this field in the request or you select **Default Set from Account** for this field during subscription creation, the value of this field is automatically set to &#x60;null&#x60; in the response body. 
   * @return sequenceSetId
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The ID of the sequence set associated with the subscription.  **Note**:    - If you have the <a href=\"https://knowledgecenter.zuora.com/Zuora_Billing/Bill_your_customers/Bill_customers_at_subscription_level/Flexible_Billing_Attributes\" target=\"_blank\">Flexible Billing Attributes</a> feature disabled, this field is unavailable in the request body and the value of this field is `null` in the response body.    - If you have the Flexible Billing Attributes feature enabled, and you do not specify this field in the request or you select **Default Set from Account** for this field during subscription creation, the value of this field is automatically set to `null` in the response body. ")

  public String getSequenceSetId() {
    return sequenceSetId;
  }


  public void setSequenceSetId(String sequenceSetId) {
    
    
    
    this.sequenceSetId = sequenceSetId;
  }


  public GETSubscriptionTypeWithSuccess sequenceSetName(String sequenceSetName) {
    
    
    
    
    this.sequenceSetName = sequenceSetName;
    return this;
  }

   /**
   * The name of the sequence set associated with the subscription.  **Note**:    - If you have the &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Bill_your_customers/Bill_customers_at_subscription_level/Flexible_Billing_Attributes\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Flexible Billing Attributes&lt;/a&gt; feature disabled, the value of this field is &#x60;null&#x60; in the response body.    - If you have the Flexible Billing Attributes feature enabled, and you do not specify the &#x60;sequenceSetId&#x60; field in the request or you select **Default Template from Account** for the &#x60;sequenceSetId&#x60; field during subscription creation, the value of the &#x60;sequenceSetName&#x60; field is automatically set to &#x60;null&#x60; in the response body. 
   * @return sequenceSetName
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The name of the sequence set associated with the subscription.  **Note**:    - If you have the <a href=\"https://knowledgecenter.zuora.com/Zuora_Billing/Bill_your_customers/Bill_customers_at_subscription_level/Flexible_Billing_Attributes\" target=\"_blank\">Flexible Billing Attributes</a> feature disabled, the value of this field is `null` in the response body.    - If you have the Flexible Billing Attributes feature enabled, and you do not specify the `sequenceSetId` field in the request or you select **Default Template from Account** for the `sequenceSetId` field during subscription creation, the value of the `sequenceSetName` field is automatically set to `null` in the response body. ")

  public String getSequenceSetName() {
    return sequenceSetName;
  }


  public void setSequenceSetName(String sequenceSetName) {
    
    
    
    this.sequenceSetName = sequenceSetName;
  }


  public GETSubscriptionTypeWithSuccess serviceActivationDate(LocalDate serviceActivationDate) {
    
    
    
    
    this.serviceActivationDate = serviceActivationDate;
    return this;
  }

   /**
   * The date on which the services or products within a subscription have been activated and access has been provided to the customer, as yyyy-mm-dd 
   * @return serviceActivationDate
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The date on which the services or products within a subscription have been activated and access has been provided to the customer, as yyyy-mm-dd ")

  public LocalDate getServiceActivationDate() {
    return serviceActivationDate;
  }


  public void setServiceActivationDate(LocalDate serviceActivationDate) {
    
    
    
    this.serviceActivationDate = serviceActivationDate;
  }


  public GETSubscriptionTypeWithSuccess soldToContact(GETAccountSummaryTypeSoldToContact soldToContact) {
    
    
    
    
    this.soldToContact = soldToContact;
    return this;
  }

   /**
   * Get soldToContact
   * @return soldToContact
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public GETAccountSummaryTypeSoldToContact getSoldToContact() {
    return soldToContact;
  }


  public void setSoldToContact(GETAccountSummaryTypeSoldToContact soldToContact) {
    
    
    
    this.soldToContact = soldToContact;
  }


  public GETSubscriptionTypeWithSuccess status(String status) {
    
    
    
    
    this.status = status;
    return this;
  }

   /**
   * Subscription status; possible values are:  * &#x60;Draft&#x60; * &#x60;Pending Activation&#x60; * &#x60;Pending Acceptance&#x60; * &#x60;Active&#x60; * &#x60;Cancelled&#x60; * &#x60;Suspended&#x60; 
   * @return status
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Subscription status; possible values are:  * `Draft` * `Pending Activation` * `Pending Acceptance` * `Active` * `Cancelled` * `Suspended` ")

  public String getStatus() {
    return status;
  }


  public void setStatus(String status) {
    
    
    
    this.status = status;
  }


  public GETSubscriptionTypeWithSuccess statusHistory(List<GETSubscriptionStatusHistoryType> statusHistory) {
    
    
    
    
    this.statusHistory = statusHistory;
    return this;
  }

  public GETSubscriptionTypeWithSuccess addStatusHistoryItem(GETSubscriptionStatusHistoryType statusHistoryItem) {
    if (this.statusHistory == null) {
      this.statusHistory = new ArrayList<>();
    }
    this.statusHistory.add(statusHistoryItem);
    return this;
  }

   /**
   * Container for status history. 
   * @return statusHistory
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Container for status history. ")

  public List<GETSubscriptionStatusHistoryType> getStatusHistory() {
    return statusHistory;
  }


  public void setStatusHistory(List<GETSubscriptionStatusHistoryType> statusHistory) {
    
    
    
    this.statusHistory = statusHistory;
  }


  public GETSubscriptionTypeWithSuccess subscriptionEndDate(LocalDate subscriptionEndDate) {
    
    
    
    
    this.subscriptionEndDate = subscriptionEndDate;
    return this;
  }

   /**
   * The date when the subscription term ends, where the subscription ends at midnight the day before. For example, if the &#x60;subscriptionEndDate&#x60; is 12/31/2016, the subscriptions ends at midnight (00:00:00 hours) on 12/30/2016. This date is the same as the term end date or the cancelation date, as appropriate. 
   * @return subscriptionEndDate
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The date when the subscription term ends, where the subscription ends at midnight the day before. For example, if the `subscriptionEndDate` is 12/31/2016, the subscriptions ends at midnight (00:00:00 hours) on 12/30/2016. This date is the same as the term end date or the cancelation date, as appropriate. ")

  public LocalDate getSubscriptionEndDate() {
    return subscriptionEndDate;
  }


  public void setSubscriptionEndDate(LocalDate subscriptionEndDate) {
    
    
    
    this.subscriptionEndDate = subscriptionEndDate;
  }


  public GETSubscriptionTypeWithSuccess subscriptionNumber(String subscriptionNumber) {
    
    
    
    
    this.subscriptionNumber = subscriptionNumber;
    return this;
  }

   /**
   * Subscription number.
   * @return subscriptionNumber
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Subscription number.")

  public String getSubscriptionNumber() {
    return subscriptionNumber;
  }


  public void setSubscriptionNumber(String subscriptionNumber) {
    
    
    
    this.subscriptionNumber = subscriptionNumber;
  }


  public GETSubscriptionTypeWithSuccess subscriptionStartDate(LocalDate subscriptionStartDate) {
    
    
    
    
    this.subscriptionStartDate = subscriptionStartDate;
    return this;
  }

   /**
   * Date the subscription becomes effective. 
   * @return subscriptionStartDate
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Date the subscription becomes effective. ")

  public LocalDate getSubscriptionStartDate() {
    return subscriptionStartDate;
  }


  public void setSubscriptionStartDate(LocalDate subscriptionStartDate) {
    
    
    
    this.subscriptionStartDate = subscriptionStartDate;
  }


  public GETSubscriptionTypeWithSuccess success(Boolean success) {
    
    
    
    
    this.success = success;
    return this;
  }

   /**
   * Returns &#x60;true&#x60; if the request was processed successfully. 
   * @return success
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Returns `true` if the request was processed successfully. ")

  public Boolean getSuccess() {
    return success;
  }


  public void setSuccess(Boolean success) {
    
    
    
    this.success = success;
  }


  public GETSubscriptionTypeWithSuccess termEndDate(LocalDate termEndDate) {
    
    
    
    
    this.termEndDate = termEndDate;
    return this;
  }

   /**
   * Date the subscription term ends. If the subscription is evergreen, this is null or is the cancellation date (if one has been set). 
   * @return termEndDate
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Date the subscription term ends. If the subscription is evergreen, this is null or is the cancellation date (if one has been set). ")

  public LocalDate getTermEndDate() {
    return termEndDate;
  }


  public void setTermEndDate(LocalDate termEndDate) {
    
    
    
    this.termEndDate = termEndDate;
  }


  public GETSubscriptionTypeWithSuccess termStartDate(LocalDate termStartDate) {
    
    
    
    
    this.termStartDate = termStartDate;
    return this;
  }

   /**
   * Date the subscription term begins. If this is a renewal subscription, this date is different from the subscription start date. 
   * @return termStartDate
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Date the subscription term begins. If this is a renewal subscription, this date is different from the subscription start date. ")

  public LocalDate getTermStartDate() {
    return termStartDate;
  }


  public void setTermStartDate(LocalDate termStartDate) {
    
    
    
    this.termStartDate = termStartDate;
  }


  public GETSubscriptionTypeWithSuccess termType(String termType) {
    
    
    
    
    this.termType = termType;
    return this;
  }

   /**
   * Possible values are: &#x60;TERMED&#x60;, &#x60;EVERGREEN&#x60;. 
   * @return termType
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Possible values are: `TERMED`, `EVERGREEN`. ")

  public String getTermType() {
    return termType;
  }


  public void setTermType(String termType) {
    
    
    
    this.termType = termType;
  }


  public GETSubscriptionTypeWithSuccess totalContractedValue(Double totalContractedValue) {
    
    
    
    
    this.totalContractedValue = totalContractedValue;
    return this;
  }

  public GETSubscriptionTypeWithSuccess totalContractedValue(Integer totalContractedValue) {
    
    
    
    
    this.totalContractedValue = totalContractedValue.doubleValue();
    return this;
  }

   /**
   * Total contracted value of the subscription. 
   * @return totalContractedValue
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Total contracted value of the subscription. ")

  public Double getTotalContractedValue() {
    return totalContractedValue;
  }


  public void setTotalContractedValue(Double totalContractedValue) {
    
    
    
    this.totalContractedValue = totalContractedValue;
  }


  public GETSubscriptionTypeWithSuccess cpqBundleJsonIdQT(String cpqBundleJsonIdQT) {
    
    
    
    
    this.cpqBundleJsonIdQT = cpqBundleJsonIdQT;
    return this;
  }

   /**
   * The Bundle product structures from Zuora Quotes if you utilize Bundling in Salesforce. Do not change the value in this field. 
   * @return cpqBundleJsonIdQT
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The Bundle product structures from Zuora Quotes if you utilize Bundling in Salesforce. Do not change the value in this field. ")

  public String getCpqBundleJsonIdQT() {
    return cpqBundleJsonIdQT;
  }


  public void setCpqBundleJsonIdQT(String cpqBundleJsonIdQT) {
    
    
    
    this.cpqBundleJsonIdQT = cpqBundleJsonIdQT;
  }


  public GETSubscriptionTypeWithSuccess opportunityCloseDateQT(LocalDate opportunityCloseDateQT) {
    
    
    
    
    this.opportunityCloseDateQT = opportunityCloseDateQT;
    return this;
  }

   /**
   * The closing date of the Opportunity. This field is used in Zuora data sources to report on Subscription metrics. If the subscription originated from Zuora Quotes, the value is populated with the value from Zuora Quotes. 
   * @return opportunityCloseDateQT
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The closing date of the Opportunity. This field is used in Zuora data sources to report on Subscription metrics. If the subscription originated from Zuora Quotes, the value is populated with the value from Zuora Quotes. ")

  public LocalDate getOpportunityCloseDateQT() {
    return opportunityCloseDateQT;
  }


  public void setOpportunityCloseDateQT(LocalDate opportunityCloseDateQT) {
    
    
    
    this.opportunityCloseDateQT = opportunityCloseDateQT;
  }


  public GETSubscriptionTypeWithSuccess opportunityNameQT(String opportunityNameQT) {
    
    
    
    
    this.opportunityNameQT = opportunityNameQT;
    return this;
  }

   /**
   * The unique identifier of the Opportunity. This field is used in Zuora data sources to report on Subscription metrics. If the subscription originated from Zuora Quotes, the value is populated with the value from Zuora Quotes. 
   * @return opportunityNameQT
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The unique identifier of the Opportunity. This field is used in Zuora data sources to report on Subscription metrics. If the subscription originated from Zuora Quotes, the value is populated with the value from Zuora Quotes. ")

  public String getOpportunityNameQT() {
    return opportunityNameQT;
  }


  public void setOpportunityNameQT(String opportunityNameQT) {
    
    
    
    this.opportunityNameQT = opportunityNameQT;
  }


  public GETSubscriptionTypeWithSuccess quoteBusinessTypeQT(String quoteBusinessTypeQT) {
    
    
    
    
    this.quoteBusinessTypeQT = quoteBusinessTypeQT;
    return this;
  }

   /**
   * The specific identifier for the type of business transaction the Quote represents such as New, Upsell, Downsell, Renewal or Churn. This field is used in Zuora data sources to report on Subscription metrics. If the subscription originated from Zuora Quotes, the value is populated with the value from Zuora Quotes. 
   * @return quoteBusinessTypeQT
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The specific identifier for the type of business transaction the Quote represents such as New, Upsell, Downsell, Renewal or Churn. This field is used in Zuora data sources to report on Subscription metrics. If the subscription originated from Zuora Quotes, the value is populated with the value from Zuora Quotes. ")

  public String getQuoteBusinessTypeQT() {
    return quoteBusinessTypeQT;
  }


  public void setQuoteBusinessTypeQT(String quoteBusinessTypeQT) {
    
    
    
    this.quoteBusinessTypeQT = quoteBusinessTypeQT;
  }


  public GETSubscriptionTypeWithSuccess quoteNumberQT(String quoteNumberQT) {
    
    
    
    
    this.quoteNumberQT = quoteNumberQT;
    return this;
  }

   /**
   * The unique identifier of the Quote. This field is used in Zuora data sources to report on Subscription metrics. If the subscription originated from Zuora Quotes, the value is populated with the value from Zuora Quotes. 
   * @return quoteNumberQT
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The unique identifier of the Quote. This field is used in Zuora data sources to report on Subscription metrics. If the subscription originated from Zuora Quotes, the value is populated with the value from Zuora Quotes. ")

  public String getQuoteNumberQT() {
    return quoteNumberQT;
  }


  public void setQuoteNumberQT(String quoteNumberQT) {
    
    
    
    this.quoteNumberQT = quoteNumberQT;
  }


  public GETSubscriptionTypeWithSuccess quoteTypeQT(String quoteTypeQT) {
    
    
    
    
    this.quoteTypeQT = quoteTypeQT;
    return this;
  }

   /**
   * The Quote type that represents the subscription lifecycle stage such as New, Amendment, Renew or Cancel. This field is used in Zuora data sources to report on Subscription metrics. If the subscription originated from Zuora Quotes, the value is populated with the value from Zuora Quotes. 
   * @return quoteTypeQT
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The Quote type that represents the subscription lifecycle stage such as New, Amendment, Renew or Cancel. This field is used in Zuora data sources to report on Subscription metrics. If the subscription originated from Zuora Quotes, the value is populated with the value from Zuora Quotes. ")

  public String getQuoteTypeQT() {
    return quoteTypeQT;
  }


  public void setQuoteTypeQT(String quoteTypeQT) {
    
    
    
    this.quoteTypeQT = quoteTypeQT;
  }


  public GETSubscriptionTypeWithSuccess integrationIdNS(String integrationIdNS) {
    
    
    
    
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


  public GETSubscriptionTypeWithSuccess integrationStatusNS(String integrationStatusNS) {
    
    
    
    
    this.integrationStatusNS = integrationStatusNS;
    return this;
  }

   /**
   * Status of the subscription&#39;s synchronization with NetSuite. Only available if you have installed the [Zuora Connector for NetSuite](https://www.zuora.com/connect/app/?appId&#x3D;265). 
   * @return integrationStatusNS
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Status of the subscription's synchronization with NetSuite. Only available if you have installed the [Zuora Connector for NetSuite](https://www.zuora.com/connect/app/?appId=265). ")

  public String getIntegrationStatusNS() {
    return integrationStatusNS;
  }


  public void setIntegrationStatusNS(String integrationStatusNS) {
    
    
    
    this.integrationStatusNS = integrationStatusNS;
  }


  public GETSubscriptionTypeWithSuccess projectNS(String projectNS) {
    
    
    
    
    this.projectNS = projectNS;
    return this;
  }

   /**
   * The NetSuite project that the subscription was created from. Only available if you have installed the [Zuora Connector for NetSuite](https://www.zuora.com/connect/app/?appId&#x3D;265). 
   * @return projectNS
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The NetSuite project that the subscription was created from. Only available if you have installed the [Zuora Connector for NetSuite](https://www.zuora.com/connect/app/?appId=265). ")

  public String getProjectNS() {
    return projectNS;
  }


  public void setProjectNS(String projectNS) {
    
    
    
    this.projectNS = projectNS;
  }


  public GETSubscriptionTypeWithSuccess salesOrderNS(String salesOrderNS) {
    
    
    
    
    this.salesOrderNS = salesOrderNS;
    return this;
  }

   /**
   * The NetSuite sales order than the subscription was created from. Only available if you have installed the [Zuora Connector for NetSuite](https://www.zuora.com/connect/app/?appId&#x3D;265). 
   * @return salesOrderNS
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The NetSuite sales order than the subscription was created from. Only available if you have installed the [Zuora Connector for NetSuite](https://www.zuora.com/connect/app/?appId=265). ")

  public String getSalesOrderNS() {
    return salesOrderNS;
  }


  public void setSalesOrderNS(String salesOrderNS) {
    
    
    
    this.salesOrderNS = salesOrderNS;
  }


  public GETSubscriptionTypeWithSuccess syncDateNS(String syncDateNS) {
    
    
    
    
    this.syncDateNS = syncDateNS;
    return this;
  }

   /**
   * Date when the subscription was synchronized with NetSuite. Only available if you have installed the [Zuora Connector for NetSuite](https://www.zuora.com/connect/app/?appId&#x3D;265). 
   * @return syncDateNS
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Date when the subscription was synchronized with NetSuite. Only available if you have installed the [Zuora Connector for NetSuite](https://www.zuora.com/connect/app/?appId=265). ")

  public String getSyncDateNS() {
    return syncDateNS;
  }


  public void setSyncDateNS(String syncDateNS) {
    
    
    
    this.syncDateNS = syncDateNS;
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
   * @return the GETSubscriptionTypeWithSuccess instance itself
   */
  public GETSubscriptionTypeWithSuccess putAdditionalProperty(String key, Object value) {
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
    GETSubscriptionTypeWithSuccess geTSubscriptionTypeWithSuccess = (GETSubscriptionTypeWithSuccess) o;
    return Objects.equals(this.version, geTSubscriptionTypeWithSuccess.version) &&
        Objects.equals(this.accountId, geTSubscriptionTypeWithSuccess.accountId) &&
        Objects.equals(this.accountName, geTSubscriptionTypeWithSuccess.accountName) &&
        Objects.equals(this.accountNumber, geTSubscriptionTypeWithSuccess.accountNumber) &&
        Objects.equals(this.autoRenew, geTSubscriptionTypeWithSuccess.autoRenew) &&
        Objects.equals(this.billToContact, geTSubscriptionTypeWithSuccess.billToContact) &&
        Objects.equals(this.cancelReason, geTSubscriptionTypeWithSuccess.cancelReason) &&
        Objects.equals(this.contractEffectiveDate, geTSubscriptionTypeWithSuccess.contractEffectiveDate) &&
        Objects.equals(this.contractedMrr, geTSubscriptionTypeWithSuccess.contractedMrr) &&
        Objects.equals(this.currency, geTSubscriptionTypeWithSuccess.currency) &&
        Objects.equals(this.currentTerm, geTSubscriptionTypeWithSuccess.currentTerm) &&
        Objects.equals(this.currentTermPeriodType, geTSubscriptionTypeWithSuccess.currentTermPeriodType) &&
        Objects.equals(this.customerAcceptanceDate, geTSubscriptionTypeWithSuccess.customerAcceptanceDate) &&
        Objects.equals(this.externallyManagedBy, geTSubscriptionTypeWithSuccess.externallyManagedBy) &&
        Objects.equals(this.id, geTSubscriptionTypeWithSuccess.id) &&
        Objects.equals(this.initialTerm, geTSubscriptionTypeWithSuccess.initialTerm) &&
        Objects.equals(this.initialTermPeriodType, geTSubscriptionTypeWithSuccess.initialTermPeriodType) &&
        Objects.equals(this.invoiceGroupNumber, geTSubscriptionTypeWithSuccess.invoiceGroupNumber) &&
        Objects.equals(this.invoiceOwnerAccountId, geTSubscriptionTypeWithSuccess.invoiceOwnerAccountId) &&
        Objects.equals(this.invoiceOwnerAccountName, geTSubscriptionTypeWithSuccess.invoiceOwnerAccountName) &&
        Objects.equals(this.invoiceOwnerAccountNumber, geTSubscriptionTypeWithSuccess.invoiceOwnerAccountNumber) &&
        Objects.equals(this.invoiceScheduleId, geTSubscriptionTypeWithSuccess.invoiceScheduleId) &&
        Objects.equals(this.invoiceSeparately, geTSubscriptionTypeWithSuccess.invoiceSeparately) &&
        Objects.equals(this.invoiceTemplateId, geTSubscriptionTypeWithSuccess.invoiceTemplateId) &&
        Objects.equals(this.invoiceTemplateName, geTSubscriptionTypeWithSuccess.invoiceTemplateName) &&
        Objects.equals(this.isLatestVersion, geTSubscriptionTypeWithSuccess.isLatestVersion) &&
        Objects.equals(this.lastBookingDate, geTSubscriptionTypeWithSuccess.lastBookingDate) &&
        Objects.equals(this.notes, geTSubscriptionTypeWithSuccess.notes) &&
        Objects.equals(this.orderNumber, geTSubscriptionTypeWithSuccess.orderNumber) &&
        Objects.equals(this.organizationLabel, geTSubscriptionTypeWithSuccess.organizationLabel) &&
        Objects.equals(this.paymentTerm, geTSubscriptionTypeWithSuccess.paymentTerm) &&
        Objects.equals(this.ratePlans, geTSubscriptionTypeWithSuccess.ratePlans) &&
        Objects.equals(this.renewalSetting, geTSubscriptionTypeWithSuccess.renewalSetting) &&
        Objects.equals(this.renewalTerm, geTSubscriptionTypeWithSuccess.renewalTerm) &&
        Objects.equals(this.renewalTermPeriodType, geTSubscriptionTypeWithSuccess.renewalTermPeriodType) &&
        Objects.equals(this.revision, geTSubscriptionTypeWithSuccess.revision) &&
        Objects.equals(this.sequenceSetId, geTSubscriptionTypeWithSuccess.sequenceSetId) &&
        Objects.equals(this.sequenceSetName, geTSubscriptionTypeWithSuccess.sequenceSetName) &&
        Objects.equals(this.serviceActivationDate, geTSubscriptionTypeWithSuccess.serviceActivationDate) &&
        Objects.equals(this.soldToContact, geTSubscriptionTypeWithSuccess.soldToContact) &&
        Objects.equals(this.status, geTSubscriptionTypeWithSuccess.status) &&
        Objects.equals(this.statusHistory, geTSubscriptionTypeWithSuccess.statusHistory) &&
        Objects.equals(this.subscriptionEndDate, geTSubscriptionTypeWithSuccess.subscriptionEndDate) &&
        Objects.equals(this.subscriptionNumber, geTSubscriptionTypeWithSuccess.subscriptionNumber) &&
        Objects.equals(this.subscriptionStartDate, geTSubscriptionTypeWithSuccess.subscriptionStartDate) &&
        Objects.equals(this.success, geTSubscriptionTypeWithSuccess.success) &&
        Objects.equals(this.termEndDate, geTSubscriptionTypeWithSuccess.termEndDate) &&
        Objects.equals(this.termStartDate, geTSubscriptionTypeWithSuccess.termStartDate) &&
        Objects.equals(this.termType, geTSubscriptionTypeWithSuccess.termType) &&
        Objects.equals(this.totalContractedValue, geTSubscriptionTypeWithSuccess.totalContractedValue) &&
        Objects.equals(this.cpqBundleJsonIdQT, geTSubscriptionTypeWithSuccess.cpqBundleJsonIdQT) &&
        Objects.equals(this.opportunityCloseDateQT, geTSubscriptionTypeWithSuccess.opportunityCloseDateQT) &&
        Objects.equals(this.opportunityNameQT, geTSubscriptionTypeWithSuccess.opportunityNameQT) &&
        Objects.equals(this.quoteBusinessTypeQT, geTSubscriptionTypeWithSuccess.quoteBusinessTypeQT) &&
        Objects.equals(this.quoteNumberQT, geTSubscriptionTypeWithSuccess.quoteNumberQT) &&
        Objects.equals(this.quoteTypeQT, geTSubscriptionTypeWithSuccess.quoteTypeQT) &&
        Objects.equals(this.integrationIdNS, geTSubscriptionTypeWithSuccess.integrationIdNS) &&
        Objects.equals(this.integrationStatusNS, geTSubscriptionTypeWithSuccess.integrationStatusNS) &&
        Objects.equals(this.projectNS, geTSubscriptionTypeWithSuccess.projectNS) &&
        Objects.equals(this.salesOrderNS, geTSubscriptionTypeWithSuccess.salesOrderNS) &&
        Objects.equals(this.syncDateNS, geTSubscriptionTypeWithSuccess.syncDateNS)&&
        Objects.equals(this.additionalProperties, geTSubscriptionTypeWithSuccess.additionalProperties);
  }

  private static <T> boolean equalsNullable(JsonNullable<T> a, JsonNullable<T> b) {
    return a == b || (a != null && b != null && a.isPresent() && b.isPresent() && Objects.deepEquals(a.get(), b.get()));
  }

  @Override
  public int hashCode() {
    return Objects.hash(version, accountId, accountName, accountNumber, autoRenew, billToContact, cancelReason, contractEffectiveDate, contractedMrr, currency, currentTerm, currentTermPeriodType, customerAcceptanceDate, externallyManagedBy, id, initialTerm, initialTermPeriodType, invoiceGroupNumber, invoiceOwnerAccountId, invoiceOwnerAccountName, invoiceOwnerAccountNumber, invoiceScheduleId, invoiceSeparately, invoiceTemplateId, invoiceTemplateName, isLatestVersion, lastBookingDate, notes, orderNumber, organizationLabel, paymentTerm, ratePlans, renewalSetting, renewalTerm, renewalTermPeriodType, revision, sequenceSetId, sequenceSetName, serviceActivationDate, soldToContact, status, statusHistory, subscriptionEndDate, subscriptionNumber, subscriptionStartDate, success, termEndDate, termStartDate, termType, totalContractedValue, cpqBundleJsonIdQT, opportunityCloseDateQT, opportunityNameQT, quoteBusinessTypeQT, quoteNumberQT, quoteTypeQT, integrationIdNS, integrationStatusNS, projectNS, salesOrderNS, syncDateNS, additionalProperties);
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
    sb.append("class GETSubscriptionTypeWithSuccess {\n");
    sb.append("    version: ").append(toIndentedString(version)).append("\n");
    sb.append("    accountId: ").append(toIndentedString(accountId)).append("\n");
    sb.append("    accountName: ").append(toIndentedString(accountName)).append("\n");
    sb.append("    accountNumber: ").append(toIndentedString(accountNumber)).append("\n");
    sb.append("    autoRenew: ").append(toIndentedString(autoRenew)).append("\n");
    sb.append("    billToContact: ").append(toIndentedString(billToContact)).append("\n");
    sb.append("    cancelReason: ").append(toIndentedString(cancelReason)).append("\n");
    sb.append("    contractEffectiveDate: ").append(toIndentedString(contractEffectiveDate)).append("\n");
    sb.append("    contractedMrr: ").append(toIndentedString(contractedMrr)).append("\n");
    sb.append("    currency: ").append(toIndentedString(currency)).append("\n");
    sb.append("    currentTerm: ").append(toIndentedString(currentTerm)).append("\n");
    sb.append("    currentTermPeriodType: ").append(toIndentedString(currentTermPeriodType)).append("\n");
    sb.append("    customerAcceptanceDate: ").append(toIndentedString(customerAcceptanceDate)).append("\n");
    sb.append("    externallyManagedBy: ").append(toIndentedString(externallyManagedBy)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    initialTerm: ").append(toIndentedString(initialTerm)).append("\n");
    sb.append("    initialTermPeriodType: ").append(toIndentedString(initialTermPeriodType)).append("\n");
    sb.append("    invoiceGroupNumber: ").append(toIndentedString(invoiceGroupNumber)).append("\n");
    sb.append("    invoiceOwnerAccountId: ").append(toIndentedString(invoiceOwnerAccountId)).append("\n");
    sb.append("    invoiceOwnerAccountName: ").append(toIndentedString(invoiceOwnerAccountName)).append("\n");
    sb.append("    invoiceOwnerAccountNumber: ").append(toIndentedString(invoiceOwnerAccountNumber)).append("\n");
    sb.append("    invoiceScheduleId: ").append(toIndentedString(invoiceScheduleId)).append("\n");
    sb.append("    invoiceSeparately: ").append(toIndentedString(invoiceSeparately)).append("\n");
    sb.append("    invoiceTemplateId: ").append(toIndentedString(invoiceTemplateId)).append("\n");
    sb.append("    invoiceTemplateName: ").append(toIndentedString(invoiceTemplateName)).append("\n");
    sb.append("    isLatestVersion: ").append(toIndentedString(isLatestVersion)).append("\n");
    sb.append("    lastBookingDate: ").append(toIndentedString(lastBookingDate)).append("\n");
    sb.append("    notes: ").append(toIndentedString(notes)).append("\n");
    sb.append("    orderNumber: ").append(toIndentedString(orderNumber)).append("\n");
    sb.append("    organizationLabel: ").append(toIndentedString(organizationLabel)).append("\n");
    sb.append("    paymentTerm: ").append(toIndentedString(paymentTerm)).append("\n");
    sb.append("    ratePlans: ").append(toIndentedString(ratePlans)).append("\n");
    sb.append("    renewalSetting: ").append(toIndentedString(renewalSetting)).append("\n");
    sb.append("    renewalTerm: ").append(toIndentedString(renewalTerm)).append("\n");
    sb.append("    renewalTermPeriodType: ").append(toIndentedString(renewalTermPeriodType)).append("\n");
    sb.append("    revision: ").append(toIndentedString(revision)).append("\n");
    sb.append("    sequenceSetId: ").append(toIndentedString(sequenceSetId)).append("\n");
    sb.append("    sequenceSetName: ").append(toIndentedString(sequenceSetName)).append("\n");
    sb.append("    serviceActivationDate: ").append(toIndentedString(serviceActivationDate)).append("\n");
    sb.append("    soldToContact: ").append(toIndentedString(soldToContact)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    statusHistory: ").append(toIndentedString(statusHistory)).append("\n");
    sb.append("    subscriptionEndDate: ").append(toIndentedString(subscriptionEndDate)).append("\n");
    sb.append("    subscriptionNumber: ").append(toIndentedString(subscriptionNumber)).append("\n");
    sb.append("    subscriptionStartDate: ").append(toIndentedString(subscriptionStartDate)).append("\n");
    sb.append("    success: ").append(toIndentedString(success)).append("\n");
    sb.append("    termEndDate: ").append(toIndentedString(termEndDate)).append("\n");
    sb.append("    termStartDate: ").append(toIndentedString(termStartDate)).append("\n");
    sb.append("    termType: ").append(toIndentedString(termType)).append("\n");
    sb.append("    totalContractedValue: ").append(toIndentedString(totalContractedValue)).append("\n");
    sb.append("    cpqBundleJsonIdQT: ").append(toIndentedString(cpqBundleJsonIdQT)).append("\n");
    sb.append("    opportunityCloseDateQT: ").append(toIndentedString(opportunityCloseDateQT)).append("\n");
    sb.append("    opportunityNameQT: ").append(toIndentedString(opportunityNameQT)).append("\n");
    sb.append("    quoteBusinessTypeQT: ").append(toIndentedString(quoteBusinessTypeQT)).append("\n");
    sb.append("    quoteNumberQT: ").append(toIndentedString(quoteNumberQT)).append("\n");
    sb.append("    quoteTypeQT: ").append(toIndentedString(quoteTypeQT)).append("\n");
    sb.append("    integrationIdNS: ").append(toIndentedString(integrationIdNS)).append("\n");
    sb.append("    integrationStatusNS: ").append(toIndentedString(integrationStatusNS)).append("\n");
    sb.append("    projectNS: ").append(toIndentedString(projectNS)).append("\n");
    sb.append("    salesOrderNS: ").append(toIndentedString(salesOrderNS)).append("\n");
    sb.append("    syncDateNS: ").append(toIndentedString(syncDateNS)).append("\n");
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
    openapiFields.add("version");
    openapiFields.add("accountId");
    openapiFields.add("accountName");
    openapiFields.add("accountNumber");
    openapiFields.add("autoRenew");
    openapiFields.add("billToContact");
    openapiFields.add("cancelReason");
    openapiFields.add("contractEffectiveDate");
    openapiFields.add("contractedMrr");
    openapiFields.add("currency");
    openapiFields.add("currentTerm");
    openapiFields.add("currentTermPeriodType");
    openapiFields.add("customerAcceptanceDate");
    openapiFields.add("externallyManagedBy");
    openapiFields.add("id");
    openapiFields.add("initialTerm");
    openapiFields.add("initialTermPeriodType");
    openapiFields.add("invoiceGroupNumber");
    openapiFields.add("invoiceOwnerAccountId");
    openapiFields.add("invoiceOwnerAccountName");
    openapiFields.add("invoiceOwnerAccountNumber");
    openapiFields.add("invoiceScheduleId");
    openapiFields.add("invoiceSeparately");
    openapiFields.add("invoiceTemplateId");
    openapiFields.add("invoiceTemplateName");
    openapiFields.add("isLatestVersion");
    openapiFields.add("lastBookingDate");
    openapiFields.add("notes");
    openapiFields.add("orderNumber");
    openapiFields.add("organizationLabel");
    openapiFields.add("paymentTerm");
    openapiFields.add("ratePlans");
    openapiFields.add("renewalSetting");
    openapiFields.add("renewalTerm");
    openapiFields.add("renewalTermPeriodType");
    openapiFields.add("revision");
    openapiFields.add("sequenceSetId");
    openapiFields.add("sequenceSetName");
    openapiFields.add("serviceActivationDate");
    openapiFields.add("soldToContact");
    openapiFields.add("status");
    openapiFields.add("statusHistory");
    openapiFields.add("subscriptionEndDate");
    openapiFields.add("subscriptionNumber");
    openapiFields.add("subscriptionStartDate");
    openapiFields.add("success");
    openapiFields.add("termEndDate");
    openapiFields.add("termStartDate");
    openapiFields.add("termType");
    openapiFields.add("totalContractedValue");
    openapiFields.add("CpqBundleJsonId__QT");
    openapiFields.add("OpportunityCloseDate__QT");
    openapiFields.add("OpportunityName__QT");
    openapiFields.add("QuoteBusinessType__QT");
    openapiFields.add("QuoteNumber__QT");
    openapiFields.add("QuoteType__QT");
    openapiFields.add("IntegrationId__NS");
    openapiFields.add("IntegrationStatus__NS");
    openapiFields.add("Project__NS");
    openapiFields.add("SalesOrder__NS");
    openapiFields.add("SyncDate__NS");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
  }

 /**
  * Validates the JSON Object and throws an exception if issues found
  *
  * @param jsonObj JSON Object
  * @throws IOException if the JSON Object is invalid with respect to GETSubscriptionTypeWithSuccess
  */
  public static void validateJsonObject(JsonObject jsonObj) throws IOException {
      if (jsonObj == null) {
        if (!GETSubscriptionTypeWithSuccess.openapiRequiredFields.isEmpty()) { // has required fields but JSON object is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in GETSubscriptionTypeWithSuccess is not found in the empty JSON string", GETSubscriptionTypeWithSuccess.openapiRequiredFields.toString()));
        }
      }
      if ((jsonObj.get("accountId") != null && !jsonObj.get("accountId").isJsonNull()) && !jsonObj.get("accountId").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `accountId` to be a primitive type in the JSON string but got `%s`", jsonObj.get("accountId").toString()));
      }
      if ((jsonObj.get("accountName") != null && !jsonObj.get("accountName").isJsonNull()) && !jsonObj.get("accountName").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `accountName` to be a primitive type in the JSON string but got `%s`", jsonObj.get("accountName").toString()));
      }
      if ((jsonObj.get("accountNumber") != null && !jsonObj.get("accountNumber").isJsonNull()) && !jsonObj.get("accountNumber").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `accountNumber` to be a primitive type in the JSON string but got `%s`", jsonObj.get("accountNumber").toString()));
      }
      // validate the optional field `billToContact`
      if (jsonObj.get("billToContact") != null && !jsonObj.get("billToContact").isJsonNull()) {
        GETAccountSummaryTypeBillToContact.validateJsonObject(jsonObj.getAsJsonObject("billToContact"));
      }
      if ((jsonObj.get("cancelReason") != null && !jsonObj.get("cancelReason").isJsonNull()) && !jsonObj.get("cancelReason").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `cancelReason` to be a primitive type in the JSON string but got `%s`", jsonObj.get("cancelReason").toString()));
      }
      if ((jsonObj.get("currency") != null && !jsonObj.get("currency").isJsonNull()) && !jsonObj.get("currency").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `currency` to be a primitive type in the JSON string but got `%s`", jsonObj.get("currency").toString()));
      }
      if ((jsonObj.get("currentTermPeriodType") != null && !jsonObj.get("currentTermPeriodType").isJsonNull()) && !jsonObj.get("currentTermPeriodType").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `currentTermPeriodType` to be a primitive type in the JSON string but got `%s`", jsonObj.get("currentTermPeriodType").toString()));
      }
      if ((jsonObj.get("externallyManagedBy") != null && !jsonObj.get("externallyManagedBy").isJsonNull()) && !jsonObj.get("externallyManagedBy").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `externallyManagedBy` to be a primitive type in the JSON string but got `%s`", jsonObj.get("externallyManagedBy").toString()));
      }
      if ((jsonObj.get("id") != null && !jsonObj.get("id").isJsonNull()) && !jsonObj.get("id").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `id` to be a primitive type in the JSON string but got `%s`", jsonObj.get("id").toString()));
      }
      if ((jsonObj.get("initialTermPeriodType") != null && !jsonObj.get("initialTermPeriodType").isJsonNull()) && !jsonObj.get("initialTermPeriodType").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `initialTermPeriodType` to be a primitive type in the JSON string but got `%s`", jsonObj.get("initialTermPeriodType").toString()));
      }
      if (!jsonObj.get("invoiceGroupNumber").isJsonNull() && (jsonObj.get("invoiceGroupNumber") != null && !jsonObj.get("invoiceGroupNumber").isJsonNull()) && !jsonObj.get("invoiceGroupNumber").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `invoiceGroupNumber` to be a primitive type in the JSON string but got `%s`", jsonObj.get("invoiceGroupNumber").toString()));
      }
      if ((jsonObj.get("invoiceOwnerAccountId") != null && !jsonObj.get("invoiceOwnerAccountId").isJsonNull()) && !jsonObj.get("invoiceOwnerAccountId").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `invoiceOwnerAccountId` to be a primitive type in the JSON string but got `%s`", jsonObj.get("invoiceOwnerAccountId").toString()));
      }
      if ((jsonObj.get("invoiceOwnerAccountName") != null && !jsonObj.get("invoiceOwnerAccountName").isJsonNull()) && !jsonObj.get("invoiceOwnerAccountName").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `invoiceOwnerAccountName` to be a primitive type in the JSON string but got `%s`", jsonObj.get("invoiceOwnerAccountName").toString()));
      }
      if ((jsonObj.get("invoiceOwnerAccountNumber") != null && !jsonObj.get("invoiceOwnerAccountNumber").isJsonNull()) && !jsonObj.get("invoiceOwnerAccountNumber").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `invoiceOwnerAccountNumber` to be a primitive type in the JSON string but got `%s`", jsonObj.get("invoiceOwnerAccountNumber").toString()));
      }
      if ((jsonObj.get("invoiceSeparately") != null && !jsonObj.get("invoiceSeparately").isJsonNull()) && !jsonObj.get("invoiceSeparately").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `invoiceSeparately` to be a primitive type in the JSON string but got `%s`", jsonObj.get("invoiceSeparately").toString()));
      }
      if ((jsonObj.get("invoiceTemplateId") != null && !jsonObj.get("invoiceTemplateId").isJsonNull()) && !jsonObj.get("invoiceTemplateId").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `invoiceTemplateId` to be a primitive type in the JSON string but got `%s`", jsonObj.get("invoiceTemplateId").toString()));
      }
      if ((jsonObj.get("invoiceTemplateName") != null && !jsonObj.get("invoiceTemplateName").isJsonNull()) && !jsonObj.get("invoiceTemplateName").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `invoiceTemplateName` to be a primitive type in the JSON string but got `%s`", jsonObj.get("invoiceTemplateName").toString()));
      }
      if ((jsonObj.get("notes") != null && !jsonObj.get("notes").isJsonNull()) && !jsonObj.get("notes").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `notes` to be a primitive type in the JSON string but got `%s`", jsonObj.get("notes").toString()));
      }
      if ((jsonObj.get("orderNumber") != null && !jsonObj.get("orderNumber").isJsonNull()) && !jsonObj.get("orderNumber").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `orderNumber` to be a primitive type in the JSON string but got `%s`", jsonObj.get("orderNumber").toString()));
      }
      if ((jsonObj.get("organizationLabel") != null && !jsonObj.get("organizationLabel").isJsonNull()) && !jsonObj.get("organizationLabel").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `organizationLabel` to be a primitive type in the JSON string but got `%s`", jsonObj.get("organizationLabel").toString()));
      }
      if ((jsonObj.get("paymentTerm") != null && !jsonObj.get("paymentTerm").isJsonNull()) && !jsonObj.get("paymentTerm").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `paymentTerm` to be a primitive type in the JSON string but got `%s`", jsonObj.get("paymentTerm").toString()));
      }
      if (jsonObj.get("ratePlans") != null && !jsonObj.get("ratePlans").isJsonNull()) {
        JsonArray jsonArrayratePlans = jsonObj.getAsJsonArray("ratePlans");
        if (jsonArrayratePlans != null) {
          // ensure the json data is an array
          if (!jsonObj.get("ratePlans").isJsonArray()) {
            throw new IllegalArgumentException(String.format("Expected the field `ratePlans` to be an array in the JSON string but got `%s`", jsonObj.get("ratePlans").toString()));
          }

          // validate the optional field `ratePlans` (array)
          for (int i = 0; i < jsonArrayratePlans.size(); i++) {
            GETSubscriptionRatePlanType.validateJsonObject(jsonArrayratePlans.get(i).getAsJsonObject());
          };
        }
      }
      if ((jsonObj.get("renewalSetting") != null && !jsonObj.get("renewalSetting").isJsonNull()) && !jsonObj.get("renewalSetting").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `renewalSetting` to be a primitive type in the JSON string but got `%s`", jsonObj.get("renewalSetting").toString()));
      }
      if ((jsonObj.get("renewalTermPeriodType") != null && !jsonObj.get("renewalTermPeriodType").isJsonNull()) && !jsonObj.get("renewalTermPeriodType").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `renewalTermPeriodType` to be a primitive type in the JSON string but got `%s`", jsonObj.get("renewalTermPeriodType").toString()));
      }
      if ((jsonObj.get("revision") != null && !jsonObj.get("revision").isJsonNull()) && !jsonObj.get("revision").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `revision` to be a primitive type in the JSON string but got `%s`", jsonObj.get("revision").toString()));
      }
      if ((jsonObj.get("sequenceSetId") != null && !jsonObj.get("sequenceSetId").isJsonNull()) && !jsonObj.get("sequenceSetId").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `sequenceSetId` to be a primitive type in the JSON string but got `%s`", jsonObj.get("sequenceSetId").toString()));
      }
      if ((jsonObj.get("sequenceSetName") != null && !jsonObj.get("sequenceSetName").isJsonNull()) && !jsonObj.get("sequenceSetName").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `sequenceSetName` to be a primitive type in the JSON string but got `%s`", jsonObj.get("sequenceSetName").toString()));
      }
      // validate the optional field `soldToContact`
      if (jsonObj.get("soldToContact") != null && !jsonObj.get("soldToContact").isJsonNull()) {
        GETAccountSummaryTypeSoldToContact.validateJsonObject(jsonObj.getAsJsonObject("soldToContact"));
      }
      if ((jsonObj.get("status") != null && !jsonObj.get("status").isJsonNull()) && !jsonObj.get("status").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `status` to be a primitive type in the JSON string but got `%s`", jsonObj.get("status").toString()));
      }
      if (jsonObj.get("statusHistory") != null && !jsonObj.get("statusHistory").isJsonNull()) {
        JsonArray jsonArraystatusHistory = jsonObj.getAsJsonArray("statusHistory");
        if (jsonArraystatusHistory != null) {
          // ensure the json data is an array
          if (!jsonObj.get("statusHistory").isJsonArray()) {
            throw new IllegalArgumentException(String.format("Expected the field `statusHistory` to be an array in the JSON string but got `%s`", jsonObj.get("statusHistory").toString()));
          }

          // validate the optional field `statusHistory` (array)
          for (int i = 0; i < jsonArraystatusHistory.size(); i++) {
            GETSubscriptionStatusHistoryType.validateJsonObject(jsonArraystatusHistory.get(i).getAsJsonObject());
          };
        }
      }
      if ((jsonObj.get("subscriptionNumber") != null && !jsonObj.get("subscriptionNumber").isJsonNull()) && !jsonObj.get("subscriptionNumber").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `subscriptionNumber` to be a primitive type in the JSON string but got `%s`", jsonObj.get("subscriptionNumber").toString()));
      }
      if ((jsonObj.get("termType") != null && !jsonObj.get("termType").isJsonNull()) && !jsonObj.get("termType").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `termType` to be a primitive type in the JSON string but got `%s`", jsonObj.get("termType").toString()));
      }
      if ((jsonObj.get("CpqBundleJsonId__QT") != null && !jsonObj.get("CpqBundleJsonId__QT").isJsonNull()) && !jsonObj.get("CpqBundleJsonId__QT").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `CpqBundleJsonId__QT` to be a primitive type in the JSON string but got `%s`", jsonObj.get("CpqBundleJsonId__QT").toString()));
      }
      if ((jsonObj.get("OpportunityName__QT") != null && !jsonObj.get("OpportunityName__QT").isJsonNull()) && !jsonObj.get("OpportunityName__QT").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `OpportunityName__QT` to be a primitive type in the JSON string but got `%s`", jsonObj.get("OpportunityName__QT").toString()));
      }
      if ((jsonObj.get("QuoteBusinessType__QT") != null && !jsonObj.get("QuoteBusinessType__QT").isJsonNull()) && !jsonObj.get("QuoteBusinessType__QT").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `QuoteBusinessType__QT` to be a primitive type in the JSON string but got `%s`", jsonObj.get("QuoteBusinessType__QT").toString()));
      }
      if ((jsonObj.get("QuoteNumber__QT") != null && !jsonObj.get("QuoteNumber__QT").isJsonNull()) && !jsonObj.get("QuoteNumber__QT").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `QuoteNumber__QT` to be a primitive type in the JSON string but got `%s`", jsonObj.get("QuoteNumber__QT").toString()));
      }
      if ((jsonObj.get("QuoteType__QT") != null && !jsonObj.get("QuoteType__QT").isJsonNull()) && !jsonObj.get("QuoteType__QT").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `QuoteType__QT` to be a primitive type in the JSON string but got `%s`", jsonObj.get("QuoteType__QT").toString()));
      }
      if ((jsonObj.get("IntegrationId__NS") != null && !jsonObj.get("IntegrationId__NS").isJsonNull()) && !jsonObj.get("IntegrationId__NS").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `IntegrationId__NS` to be a primitive type in the JSON string but got `%s`", jsonObj.get("IntegrationId__NS").toString()));
      }
      if ((jsonObj.get("IntegrationStatus__NS") != null && !jsonObj.get("IntegrationStatus__NS").isJsonNull()) && !jsonObj.get("IntegrationStatus__NS").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `IntegrationStatus__NS` to be a primitive type in the JSON string but got `%s`", jsonObj.get("IntegrationStatus__NS").toString()));
      }
      if ((jsonObj.get("Project__NS") != null && !jsonObj.get("Project__NS").isJsonNull()) && !jsonObj.get("Project__NS").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `Project__NS` to be a primitive type in the JSON string but got `%s`", jsonObj.get("Project__NS").toString()));
      }
      if ((jsonObj.get("SalesOrder__NS") != null && !jsonObj.get("SalesOrder__NS").isJsonNull()) && !jsonObj.get("SalesOrder__NS").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `SalesOrder__NS` to be a primitive type in the JSON string but got `%s`", jsonObj.get("SalesOrder__NS").toString()));
      }
      if ((jsonObj.get("SyncDate__NS") != null && !jsonObj.get("SyncDate__NS").isJsonNull()) && !jsonObj.get("SyncDate__NS").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `SyncDate__NS` to be a primitive type in the JSON string but got `%s`", jsonObj.get("SyncDate__NS").toString()));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!GETSubscriptionTypeWithSuccess.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'GETSubscriptionTypeWithSuccess' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<GETSubscriptionTypeWithSuccess> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(GETSubscriptionTypeWithSuccess.class));

       return (TypeAdapter<T>) new TypeAdapter<GETSubscriptionTypeWithSuccess>() {
           @Override
           public void write(JsonWriter out, GETSubscriptionTypeWithSuccess value) throws IOException {
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
           public GETSubscriptionTypeWithSuccess read(JsonReader in) throws IOException {
             JsonObject jsonObj = elementAdapter.read(in).getAsJsonObject();
             validateJsonObject(jsonObj);
             // store additional fields in the deserialized instance
             GETSubscriptionTypeWithSuccess instance = thisAdapter.fromJsonTree(jsonObj);
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
  * Create an instance of GETSubscriptionTypeWithSuccess given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of GETSubscriptionTypeWithSuccess
  * @throws IOException if the JSON string is invalid with respect to GETSubscriptionTypeWithSuccess
  */
  public static GETSubscriptionTypeWithSuccess fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, GETSubscriptionTypeWithSuccess.class);
  }

 /**
  * Convert an instance of GETSubscriptionTypeWithSuccess to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

