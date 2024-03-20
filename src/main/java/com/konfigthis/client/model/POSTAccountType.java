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
import com.konfigthis.client.model.POSTAccountTypeAllOfTaxInfo;
import com.konfigthis.client.model.POSTAccountTypeBillToContact;
import com.konfigthis.client.model.POSTAccountTypeCreditCard;
import com.konfigthis.client.model.POSTAccountTypeSoldToContact;
import com.konfigthis.client.model.POSTAccountTypeSubscription;
import com.konfigthis.client.model.PostAccountEInvoiceProfile;
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
 * POSTAccountType
 */@javax.annotation.Generated(value = "Generated by https://konfigthis.com")
public class POSTAccountType {
  public static final String SERIALIZED_NAME_ACCOUNT_NUMBER = "accountNumber";
  @SerializedName(SERIALIZED_NAME_ACCOUNT_NUMBER)
  private String accountNumber;

  public static final String SERIALIZED_NAME_ADDITIONAL_EMAIL_ADDRESSES = "additionalEmailAddresses";
  @SerializedName(SERIALIZED_NAME_ADDITIONAL_EMAIL_ADDRESSES)
  private List<String> additionalEmailAddresses = null;

  public static final String SERIALIZED_NAME_APPLICATION_ORDER = "applicationOrder";
  @SerializedName(SERIALIZED_NAME_APPLICATION_ORDER)
  private List<String> applicationOrder = null;

  public static final String SERIALIZED_NAME_APPLY_CREDIT = "applyCredit";
  @SerializedName(SERIALIZED_NAME_APPLY_CREDIT)
  private Boolean applyCredit;

  public static final String SERIALIZED_NAME_APPLY_CREDIT_BALANCE = "applyCreditBalance";
  @SerializedName(SERIALIZED_NAME_APPLY_CREDIT_BALANCE)
  private Boolean applyCreditBalance;

  public static final String SERIALIZED_NAME_AUTO_PAY = "autoPay";
  @SerializedName(SERIALIZED_NAME_AUTO_PAY)
  private Boolean autoPay;

  public static final String SERIALIZED_NAME_BATCH = "batch";
  @SerializedName(SERIALIZED_NAME_BATCH)
  private String batch;

  public static final String SERIALIZED_NAME_BILL_CYCLE_DAY = "billCycleDay";
  @SerializedName(SERIALIZED_NAME_BILL_CYCLE_DAY)
  private Long billCycleDay;

  public static final String SERIALIZED_NAME_BILL_TO_CONTACT = "billToContact";
  @SerializedName(SERIALIZED_NAME_BILL_TO_CONTACT)
  private POSTAccountTypeBillToContact billToContact;

  public static final String SERIALIZED_NAME_COLLECT = "collect";
  @SerializedName(SERIALIZED_NAME_COLLECT)
  private Boolean collect = true;

  public static final String SERIALIZED_NAME_COMMUNICATION_PROFILE_ID = "communicationProfileId";
  @SerializedName(SERIALIZED_NAME_COMMUNICATION_PROFILE_ID)
  private String communicationProfileId;

  public static final String SERIALIZED_NAME_CREDIT_CARD = "creditCard";
  @SerializedName(SERIALIZED_NAME_CREDIT_CARD)
  private POSTAccountTypeCreditCard creditCard;

  public static final String SERIALIZED_NAME_CREDIT_MEMO_REASON_CODE = "creditMemoReasonCode";
  @SerializedName(SERIALIZED_NAME_CREDIT_MEMO_REASON_CODE)
  private String creditMemoReasonCode;

  public static final String SERIALIZED_NAME_CREDIT_MEMO_TEMPLATE_ID = "creditMemoTemplateId";
  @SerializedName(SERIALIZED_NAME_CREDIT_MEMO_TEMPLATE_ID)
  private String creditMemoTemplateId;

  public static final String SERIALIZED_NAME_CRM_ID = "crmId";
  @SerializedName(SERIALIZED_NAME_CRM_ID)
  private String crmId;

  public static final String SERIALIZED_NAME_CURRENCY = "currency";
  @SerializedName(SERIALIZED_NAME_CURRENCY)
  private String currency;

  public static final String SERIALIZED_NAME_DEBIT_MEMO_TEMPLATE_ID = "debitMemoTemplateId";
  @SerializedName(SERIALIZED_NAME_DEBIT_MEMO_TEMPLATE_ID)
  private String debitMemoTemplateId;

  public static final String SERIALIZED_NAME_DOCUMENT_DATE = "documentDate";
  @SerializedName(SERIALIZED_NAME_DOCUMENT_DATE)
  private LocalDate documentDate;

  public static final String SERIALIZED_NAME_EINVOICE_PROFILE = "einvoiceProfile";
  @SerializedName(SERIALIZED_NAME_EINVOICE_PROFILE)
  private PostAccountEInvoiceProfile einvoiceProfile;

  public static final String SERIALIZED_NAME_HPM_CREDIT_CARD_PAYMENT_METHOD_ID = "hpmCreditCardPaymentMethodId";
  @SerializedName(SERIALIZED_NAME_HPM_CREDIT_CARD_PAYMENT_METHOD_ID)
  private String hpmCreditCardPaymentMethodId;

  public static final String SERIALIZED_NAME_INVOICE = "invoice";
  @SerializedName(SERIALIZED_NAME_INVOICE)
  private Boolean invoice = true;

  public static final String SERIALIZED_NAME_INVOICE_COLLECT = "invoiceCollect";
  @SerializedName(SERIALIZED_NAME_INVOICE_COLLECT)
  private Boolean invoiceCollect;

  public static final String SERIALIZED_NAME_INVOICE_DELIVERY_PREFS_EMAIL = "invoiceDeliveryPrefsEmail";
  @SerializedName(SERIALIZED_NAME_INVOICE_DELIVERY_PREFS_EMAIL)
  private Boolean invoiceDeliveryPrefsEmail = false;

  public static final String SERIALIZED_NAME_INVOICE_DELIVERY_PREFS_PRINT = "invoiceDeliveryPrefsPrint";
  @SerializedName(SERIALIZED_NAME_INVOICE_DELIVERY_PREFS_PRINT)
  private Boolean invoiceDeliveryPrefsPrint = false;

  public static final String SERIALIZED_NAME_INVOICE_TARGET_DATE = "invoiceTargetDate";
  @SerializedName(SERIALIZED_NAME_INVOICE_TARGET_DATE)
  private LocalDate invoiceTargetDate;

  public static final String SERIALIZED_NAME_INVOICE_TEMPLATE_ID = "invoiceTemplateId";
  @SerializedName(SERIALIZED_NAME_INVOICE_TEMPLATE_ID)
  private String invoiceTemplateId;

  public static final String SERIALIZED_NAME_NAME = "name";
  @SerializedName(SERIALIZED_NAME_NAME)
  private String name;

  public static final String SERIALIZED_NAME_NOTES = "notes";
  @SerializedName(SERIALIZED_NAME_NOTES)
  private String notes;

  public static final String SERIALIZED_NAME_ORGANIZATION_LABEL = "organizationLabel";
  @SerializedName(SERIALIZED_NAME_ORGANIZATION_LABEL)
  private String organizationLabel;

  public static final String SERIALIZED_NAME_PARENT_ID = "parentId";
  @SerializedName(SERIALIZED_NAME_PARENT_ID)
  private String parentId;

  public static final String SERIALIZED_NAME_PARTNER_ACCOUNT = "partnerAccount";
  @SerializedName(SERIALIZED_NAME_PARTNER_ACCOUNT)
  private Boolean partnerAccount = false;

  public static final String SERIALIZED_NAME_PAYMENT_GATEWAY = "paymentGateway";
  @SerializedName(SERIALIZED_NAME_PAYMENT_GATEWAY)
  private String paymentGateway;

  public static final String SERIALIZED_NAME_PAYMENT_METHOD = "paymentMethod";
  @SerializedName(SERIALIZED_NAME_PAYMENT_METHOD)
  private Object paymentMethod = null;

  public static final String SERIALIZED_NAME_PAYMENT_TERM = "paymentTerm";
  @SerializedName(SERIALIZED_NAME_PAYMENT_TERM)
  private String paymentTerm;

  public static final String SERIALIZED_NAME_PROFILE_NUMBER = "profileNumber";
  @SerializedName(SERIALIZED_NAME_PROFILE_NUMBER)
  private String profileNumber;

  /**
   * Creates an invoice for a subscription. If you have the Invoice Settlement feature enabled, a credit memo might also be created based on the [invoice and credit memo generation rule](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/Invoice_Settlement/B_Credit_and_Debit_Memos/Rules_for_generating_invoices_and_credit_memos).    The billing documents generated in this operation is only for this subscription, not for the entire customer account.   Possible values:  - &#x60;true&#x60;: An invoice is created. If you have the Invoice Settlement feature enabled, a credit memo might also be created.   - &#x60;false&#x60;: No invoice is created.   **Note:** This field is in Zuora REST API version control. Supported minor versions are &#x60;211.0&#x60; and later [available versions](https://developer.zuora.com/api-references/api/overview/#section/API-Versions/Minor-Version). To use this field in the method, you must set the &#x60;zuora-version&#x60; parameter to the minor version number in the request header. 
   */
  @JsonAdapter(RunBillingEnum.Adapter.class)
 public enum RunBillingEnum {
    TRUE("true"),
    
    FALSE("false");

    private Boolean value;

    RunBillingEnum(Boolean value) {
      this.value = value;
    }

    public Boolean getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static RunBillingEnum fromValue(Boolean value) {
      for (RunBillingEnum b : RunBillingEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<RunBillingEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final RunBillingEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public RunBillingEnum read(final JsonReader jsonReader) throws IOException {
        Boolean value =  jsonReader.nextBoolean();
        return RunBillingEnum.fromValue(value);
      }
    }
  }

  public static final String SERIALIZED_NAME_RUN_BILLING = "runBilling";
  @SerializedName(SERIALIZED_NAME_RUN_BILLING)
  private RunBillingEnum runBilling = true;

  public static final String SERIALIZED_NAME_SALES_REP = "salesRep";
  @SerializedName(SERIALIZED_NAME_SALES_REP)
  private String salesRep;

  public static final String SERIALIZED_NAME_SEQUENCE_SET_ID = "sequenceSetId";
  @SerializedName(SERIALIZED_NAME_SEQUENCE_SET_ID)
  private String sequenceSetId;

  public static final String SERIALIZED_NAME_SOLD_TO_CONTACT = "soldToContact";
  @SerializedName(SERIALIZED_NAME_SOLD_TO_CONTACT)
  private POSTAccountTypeSoldToContact soldToContact;

  public static final String SERIALIZED_NAME_SOLD_TO_SAME_AS_BILL_TO = "soldToSameAsBillTo";
  @SerializedName(SERIALIZED_NAME_SOLD_TO_SAME_AS_BILL_TO)
  private Boolean soldToSameAsBillTo;

  public static final String SERIALIZED_NAME_SUBSCRIPTION = "subscription";
  @SerializedName(SERIALIZED_NAME_SUBSCRIPTION)
  private POSTAccountTypeSubscription subscription;

  public static final String SERIALIZED_NAME_TAGGING = "tagging";
  @SerializedName(SERIALIZED_NAME_TAGGING)
  private String tagging;

  public static final String SERIALIZED_NAME_TARGET_DATE = "targetDate";
  @SerializedName(SERIALIZED_NAME_TARGET_DATE)
  private LocalDate targetDate;

  public static final String SERIALIZED_NAME_TAX_INFO = "taxInfo";
  @SerializedName(SERIALIZED_NAME_TAX_INFO)
  private POSTAccountTypeAllOfTaxInfo taxInfo;

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

  public POSTAccountType() {
  }

  public POSTAccountType accountNumber(String accountNumber) {
    
    
    
    
    this.accountNumber = accountNumber;
    return this;
  }

   /**
   * A unique account number, up to 50 characters that do not begin with the default account number prefix.  If no account number is specified, one is generated. 
   * @return accountNumber
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "A unique account number, up to 50 characters that do not begin with the default account number prefix.  If no account number is specified, one is generated. ")

  public String getAccountNumber() {
    return accountNumber;
  }


  public void setAccountNumber(String accountNumber) {
    
    
    
    this.accountNumber = accountNumber;
  }


  public POSTAccountType additionalEmailAddresses(List<String> additionalEmailAddresses) {
    
    
    
    
    this.additionalEmailAddresses = additionalEmailAddresses;
    return this;
  }

  public POSTAccountType addAdditionalEmailAddressesItem(String additionalEmailAddressesItem) {
    if (this.additionalEmailAddresses == null) {
      this.additionalEmailAddresses = new ArrayList<>();
    }
    this.additionalEmailAddresses.add(additionalEmailAddressesItem);
    return this;
  }

   /**
   * A list of additional email addresses to receive email notifications. Use commas to separate email addresses. 
   * @return additionalEmailAddresses
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "A list of additional email addresses to receive email notifications. Use commas to separate email addresses. ")

  public List<String> getAdditionalEmailAddresses() {
    return additionalEmailAddresses;
  }


  public void setAdditionalEmailAddresses(List<String> additionalEmailAddresses) {
    
    
    
    this.additionalEmailAddresses = additionalEmailAddresses;
  }


  public POSTAccountType applicationOrder(List<String> applicationOrder) {
    
    
    
    
    this.applicationOrder = applicationOrder;
    return this;
  }

  public POSTAccountType addApplicationOrderItem(String applicationOrderItem) {
    if (this.applicationOrder == null) {
      this.applicationOrder = new ArrayList<>();
    }
    this.applicationOrder.add(applicationOrderItem);
    return this;
  }

   /**
   * The priority order to apply credit memos and/or unapplied payments to an invoice. Possible item values are: &#x60;CreditMemo&#x60;, &#x60;UnappliedPayment&#x60;.  **Note:**   - This field is valid only if the &#x60;applyCredit&#x60; field is set to &#x60;true&#x60;.   - If no value is specified for this field, the default priority order is used, [\&quot;CreditMemo\&quot;, \&quot;UnappliedPayment\&quot;], to apply credit memos first and then apply unapplied payments.   - If only one item is specified, only the items of the spedified type are applied to invoices. For example, if the value is &#x60;[\&quot;CreditMemo\&quot;]&#x60;, only credit memos are used to apply to invoices. 
   * @return applicationOrder
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The priority order to apply credit memos and/or unapplied payments to an invoice. Possible item values are: `CreditMemo`, `UnappliedPayment`.  **Note:**   - This field is valid only if the `applyCredit` field is set to `true`.   - If no value is specified for this field, the default priority order is used, [\"CreditMemo\", \"UnappliedPayment\"], to apply credit memos first and then apply unapplied payments.   - If only one item is specified, only the items of the spedified type are applied to invoices. For example, if the value is `[\"CreditMemo\"]`, only credit memos are used to apply to invoices. ")

  public List<String> getApplicationOrder() {
    return applicationOrder;
  }


  public void setApplicationOrder(List<String> applicationOrder) {
    
    
    
    this.applicationOrder = applicationOrder;
  }


  public POSTAccountType applyCredit(Boolean applyCredit) {
    
    
    
    
    this.applyCredit = applyCredit;
    return this;
  }

   /**
   * Whether to automatically apply credit memos or unapplied payments, or both to an invoice.  If the value is &#x60;true&#x60;, the credit memo or unapplied payment, or both will be automatically applied to the invoice. If no value is specified or the value is &#x60;false&#x60;, no action is taken.  **Note:** This field is only available if you have [Invoice Settlement](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/Invoice_Settlement) enabled. The Invoice Settlement feature is generally available as of Zuora Billing Release 296 (March 2021). This feature includes Unapplied Payments, Credit and Debit Memo, and Invoice Item Settlement. If you want to enable Invoice Settlement, see [Invoice Settlement Enablement and Checklist Guide](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/Invoice_Settlement/Invoice_Settlement_Migration_Checklist_and_Guide) for more information. 
   * @return applyCredit
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Whether to automatically apply credit memos or unapplied payments, or both to an invoice.  If the value is `true`, the credit memo or unapplied payment, or both will be automatically applied to the invoice. If no value is specified or the value is `false`, no action is taken.  **Note:** This field is only available if you have [Invoice Settlement](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/Invoice_Settlement) enabled. The Invoice Settlement feature is generally available as of Zuora Billing Release 296 (March 2021). This feature includes Unapplied Payments, Credit and Debit Memo, and Invoice Item Settlement. If you want to enable Invoice Settlement, see [Invoice Settlement Enablement and Checklist Guide](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/Invoice_Settlement/Invoice_Settlement_Migration_Checklist_and_Guide) for more information. ")

  public Boolean getApplyCredit() {
    return applyCredit;
  }


  public void setApplyCredit(Boolean applyCredit) {
    
    
    
    this.applyCredit = applyCredit;
  }


  public POSTAccountType applyCreditBalance(Boolean applyCreditBalance) {
    
    
    
    
    this.applyCreditBalance = applyCreditBalance;
    return this;
  }

   /**
   * Applies a credit balance to an invoice.  If the value is &#x60;true&#x60;, the credit balance is applied to the invoice. If the value is &#x60;false&#x60;, no action is taken.  Prerequisite: &#x60;invoice&#x60; must be &#x60;true&#x60;.  To view the credit balance adjustment, retrieve the details of the invoice using the Get Invoices method.   **Note:**    - If you are using the field &#x60;invoiceCollect&#x60; rather than the field &#x60;invoice&#x60;, the &#x60;invoiceCollect&#x60; value must be &#x60;true&#x60;.   - This field is deprecated if you have the Invoice Settlement feature enabled.  
   * @return applyCreditBalance
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Applies a credit balance to an invoice.  If the value is `true`, the credit balance is applied to the invoice. If the value is `false`, no action is taken.  Prerequisite: `invoice` must be `true`.  To view the credit balance adjustment, retrieve the details of the invoice using the Get Invoices method.   **Note:**    - If you are using the field `invoiceCollect` rather than the field `invoice`, the `invoiceCollect` value must be `true`.   - This field is deprecated if you have the Invoice Settlement feature enabled.  ")

  public Boolean getApplyCreditBalance() {
    return applyCreditBalance;
  }


  public void setApplyCreditBalance(Boolean applyCreditBalance) {
    
    
    
    this.applyCreditBalance = applyCreditBalance;
  }


  public POSTAccountType autoPay(Boolean autoPay) {
    
    
    
    
    this.autoPay = autoPay;
    return this;
  }

   /**
   * Whether future payments are to be automatically billed when they are due.   - If this field is set to &#x60;true&#x60;, you must specify either the &#x60;creditCard&#x60; field or the &#x60;hpmCreditCardPaymentMethodId&#x60; field, but not both. - If this field is set to &#x60;false&#x60;, you can specify neither the &#x60;creditCard&#x60; field nor the &#x60;hpmCreditCardPaymentMethodId&#x60; field. 
   * @return autoPay
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Whether future payments are to be automatically billed when they are due.   - If this field is set to `true`, you must specify either the `creditCard` field or the `hpmCreditCardPaymentMethodId` field, but not both. - If this field is set to `false`, you can specify neither the `creditCard` field nor the `hpmCreditCardPaymentMethodId` field. ")

  public Boolean getAutoPay() {
    return autoPay;
  }


  public void setAutoPay(Boolean autoPay) {
    
    
    
    this.autoPay = autoPay;
  }


  public POSTAccountType batch(String batch) {
    
    
    
    
    this.batch = batch;
    return this;
  }

   /**
   * The alias name given to a batch. A string of 50 characters or less.  **Note**: By default, you have 50 configurable account batches. To increase the limit to 200 batches, you must have the &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Central_Platform/Performance_Booster_Elite\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Performance Booster Elite&lt;/a&gt; package. 
   * @return batch
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The alias name given to a batch. A string of 50 characters or less.  **Note**: By default, you have 50 configurable account batches. To increase the limit to 200 batches, you must have the <a href=\"https://knowledgecenter.zuora.com/Zuora_Central_Platform/Performance_Booster_Elite\" target=\"_blank\">Performance Booster Elite</a> package. ")

  public String getBatch() {
    return batch;
  }


  public void setBatch(String batch) {
    
    
    
    this.batch = batch;
  }


  public POSTAccountType billCycleDay(Long billCycleDay) {
    
    
    
    
    this.billCycleDay = billCycleDay;
    return this;
  }

   /**
   * The account&#39;s bill cycle day (BCD), when bill runs generate invoices for the account.  Specify any day of the month (1-31, where 31 &#x3D; end-of-month), or 0 for auto-set.  Required if no subscription will be created.   Optional if a subscription is created and defaults to the day-of-the-month of the subscription&#39;s &#x60;contractEffectiveDate&#x60;. 
   * @return billCycleDay
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The account's bill cycle day (BCD), when bill runs generate invoices for the account.  Specify any day of the month (1-31, where 31 = end-of-month), or 0 for auto-set.  Required if no subscription will be created.   Optional if a subscription is created and defaults to the day-of-the-month of the subscription's `contractEffectiveDate`. ")

  public Long getBillCycleDay() {
    return billCycleDay;
  }


  public void setBillCycleDay(Long billCycleDay) {
    
    
    
    this.billCycleDay = billCycleDay;
  }


  public POSTAccountType billToContact(POSTAccountTypeBillToContact billToContact) {
    
    
    
    
    this.billToContact = billToContact;
    return this;
  }

   /**
   * Get billToContact
   * @return billToContact
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")

  public POSTAccountTypeBillToContact getBillToContact() {
    return billToContact;
  }


  public void setBillToContact(POSTAccountTypeBillToContact billToContact) {
    
    
    
    this.billToContact = billToContact;
  }


  public POSTAccountType collect(Boolean collect) {
    
    
    
    
    this.collect = collect;
    return this;
  }

   /**
   * Collects an automatic payment for a subscription. The collection generated in this operation is only for this subscription, not for the entire customer account.  If the value is &#x60;true&#x60;, the automatic payment is collected. If the value is &#x60;false&#x60;, no action is taken.  Prerequisite: The &#x60;invoice&#x60; or &#x60;runBilling&#x60; field must be &#x60;true&#x60;.   **Note**: This field is only available if you set the &#x60;zuora-version&#x60; request header to &#x60;196.0&#x60; or later [available versions](https://developer.zuora.com/api-references/api/overview/#section/API-Versions/Minor-Version). 
   * @return collect
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "true", value = "Collects an automatic payment for a subscription. The collection generated in this operation is only for this subscription, not for the entire customer account.  If the value is `true`, the automatic payment is collected. If the value is `false`, no action is taken.  Prerequisite: The `invoice` or `runBilling` field must be `true`.   **Note**: This field is only available if you set the `zuora-version` request header to `196.0` or later [available versions](https://developer.zuora.com/api-references/api/overview/#section/API-Versions/Minor-Version). ")

  public Boolean getCollect() {
    return collect;
  }


  public void setCollect(Boolean collect) {
    
    
    
    this.collect = collect;
  }


  public POSTAccountType communicationProfileId(String communicationProfileId) {
    
    
    
    
    this.communicationProfileId = communicationProfileId;
    return this;
  }

   /**
   * The ID of the communication profile that this account is linked to.  You can provide either or both of the &#x60;communicationProfileId&#x60; and &#x60;profileNumber&#x60; fields.  If both are provided, the request will fail if they do not refer to the same communication profile. 
   * @return communicationProfileId
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The ID of the communication profile that this account is linked to.  You can provide either or both of the `communicationProfileId` and `profileNumber` fields.  If both are provided, the request will fail if they do not refer to the same communication profile. ")

  public String getCommunicationProfileId() {
    return communicationProfileId;
  }


  public void setCommunicationProfileId(String communicationProfileId) {
    
    
    
    this.communicationProfileId = communicationProfileId;
  }


  public POSTAccountType creditCard(POSTAccountTypeCreditCard creditCard) {
    
    
    
    
    this.creditCard = creditCard;
    return this;
  }

   /**
   * Get creditCard
   * @return creditCard
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public POSTAccountTypeCreditCard getCreditCard() {
    return creditCard;
  }


  public void setCreditCard(POSTAccountTypeCreditCard creditCard) {
    
    
    
    this.creditCard = creditCard;
  }


  public POSTAccountType creditMemoReasonCode(String creditMemoReasonCode) {
    
    
    
    
    this.creditMemoReasonCode = creditMemoReasonCode;
    return this;
  }

   /**
   * A code identifying the reason for the credit memo transaction that is generated by the request. The value must be an existing reason code. If you do not pass the field or pass the field with empty value, Zuora uses the default reason code.
   * @return creditMemoReasonCode
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "A code identifying the reason for the credit memo transaction that is generated by the request. The value must be an existing reason code. If you do not pass the field or pass the field with empty value, Zuora uses the default reason code.")

  public String getCreditMemoReasonCode() {
    return creditMemoReasonCode;
  }


  public void setCreditMemoReasonCode(String creditMemoReasonCode) {
    
    
    
    this.creditMemoReasonCode = creditMemoReasonCode;
  }


  public POSTAccountType creditMemoTemplateId(String creditMemoTemplateId) {
    
    
    
    
    this.creditMemoTemplateId = creditMemoTemplateId;
    return this;
  }

   /**
   * **Note:** This field is only available if you have [Invoice Settlement](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/Invoice_Settlement) enabled. The Invoice Settlement feature is generally available as of Zuora Billing Release 296 (March 2021). This feature includes Unapplied Payments, Credit and Debit Memo, and Invoice Item Settlement. If you want to enable Invoice Settlement, see [Invoice Settlement Enablement and Checklist Guide](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/Invoice_Settlement/Invoice_Settlement_Migration_Checklist_and_Guide) for more information.  The unique ID of the credit memo template, configured in **Billing Settings** &gt; **Manage Billing Document Configuration** through the Zuora UI. For example, 2c92c08a6246fdf101626b1b3fe0144b. 
   * @return creditMemoTemplateId
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "**Note:** This field is only available if you have [Invoice Settlement](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/Invoice_Settlement) enabled. The Invoice Settlement feature is generally available as of Zuora Billing Release 296 (March 2021). This feature includes Unapplied Payments, Credit and Debit Memo, and Invoice Item Settlement. If you want to enable Invoice Settlement, see [Invoice Settlement Enablement and Checklist Guide](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/Invoice_Settlement/Invoice_Settlement_Migration_Checklist_and_Guide) for more information.  The unique ID of the credit memo template, configured in **Billing Settings** > **Manage Billing Document Configuration** through the Zuora UI. For example, 2c92c08a6246fdf101626b1b3fe0144b. ")

  public String getCreditMemoTemplateId() {
    return creditMemoTemplateId;
  }


  public void setCreditMemoTemplateId(String creditMemoTemplateId) {
    
    
    
    this.creditMemoTemplateId = creditMemoTemplateId;
  }


  public POSTAccountType crmId(String crmId) {
    
    
    
    
    this.crmId = crmId;
    return this;
  }

   /**
   * CRM account ID for the account, up to 100 characters. 
   * @return crmId
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "CRM account ID for the account, up to 100 characters. ")

  public String getCrmId() {
    return crmId;
  }


  public void setCrmId(String crmId) {
    
    
    
    this.crmId = crmId;
  }


  public POSTAccountType currency(String currency) {
    
    
    
    
    this.currency = currency;
    return this;
  }

   /**
   * A currency as defined in Billing Settings in the Zuora UI.  For payment method authorization, if the &#x60;paymentMethod&#x60; &gt; &#x60;currencyCode&#x60; field is specified, &#x60;currencyCode&#x60; is used. Otherwise, this &#x60;currency&#x60; field is used for payment method authorization. If no currency is specified for the account, the default currency of the account is then used. 
   * @return currency
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "A currency as defined in Billing Settings in the Zuora UI.  For payment method authorization, if the `paymentMethod` > `currencyCode` field is specified, `currencyCode` is used. Otherwise, this `currency` field is used for payment method authorization. If no currency is specified for the account, the default currency of the account is then used. ")

  public String getCurrency() {
    return currency;
  }


  public void setCurrency(String currency) {
    
    
    
    this.currency = currency;
  }


  public POSTAccountType debitMemoTemplateId(String debitMemoTemplateId) {
    
    
    
    
    this.debitMemoTemplateId = debitMemoTemplateId;
    return this;
  }

   /**
   * **Note:** This field is only available if you have [Invoice Settlement](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/Invoice_Settlement) enabled. The Invoice Settlement feature is generally available as of Zuora Billing Release 296 (March 2021). This feature includes Unapplied Payments, Credit and Debit Memo, and Invoice Item Settlement. If you want to enable Invoice Settlement, see [Invoice Settlement Enablement and Checklist Guide](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/Invoice_Settlement/Invoice_Settlement_Migration_Checklist_and_Guide) for more information.  The unique ID of the debit memo template, configured in **Billing Settings** &gt; **Manage Billing Document Configuration** through the Zuora UI. For example, 2c92c08d62470a8501626b19d24f19e2. 
   * @return debitMemoTemplateId
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "**Note:** This field is only available if you have [Invoice Settlement](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/Invoice_Settlement) enabled. The Invoice Settlement feature is generally available as of Zuora Billing Release 296 (March 2021). This feature includes Unapplied Payments, Credit and Debit Memo, and Invoice Item Settlement. If you want to enable Invoice Settlement, see [Invoice Settlement Enablement and Checklist Guide](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/Invoice_Settlement/Invoice_Settlement_Migration_Checklist_and_Guide) for more information.  The unique ID of the debit memo template, configured in **Billing Settings** > **Manage Billing Document Configuration** through the Zuora UI. For example, 2c92c08d62470a8501626b19d24f19e2. ")

  public String getDebitMemoTemplateId() {
    return debitMemoTemplateId;
  }


  public void setDebitMemoTemplateId(String debitMemoTemplateId) {
    
    
    
    this.debitMemoTemplateId = debitMemoTemplateId;
  }


  public POSTAccountType documentDate(LocalDate documentDate) {
    
    
    
    
    this.documentDate = documentDate;
    return this;
  }

   /**
   * The date of the billing document, in &#x60;yyyy-mm-dd&#x60; format. It represents the invoice date for invoices, credit memo date for credit memos, and debit memo date for debit memos.  - If this field is specified, the specified date is used as the billing document date.  - If this field is not specified, the date specified in the &#x60;targetDate&#x60; is used as the billing document date. 
   * @return documentDate
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The date of the billing document, in `yyyy-mm-dd` format. It represents the invoice date for invoices, credit memo date for credit memos, and debit memo date for debit memos.  - If this field is specified, the specified date is used as the billing document date.  - If this field is not specified, the date specified in the `targetDate` is used as the billing document date. ")

  public LocalDate getDocumentDate() {
    return documentDate;
  }


  public void setDocumentDate(LocalDate documentDate) {
    
    
    
    this.documentDate = documentDate;
  }


  public POSTAccountType einvoiceProfile(PostAccountEInvoiceProfile einvoiceProfile) {
    
    
    
    
    this.einvoiceProfile = einvoiceProfile;
    return this;
  }

   /**
   * Get einvoiceProfile
   * @return einvoiceProfile
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public PostAccountEInvoiceProfile getEinvoiceProfile() {
    return einvoiceProfile;
  }


  public void setEinvoiceProfile(PostAccountEInvoiceProfile einvoiceProfile) {
    
    
    
    this.einvoiceProfile = einvoiceProfile;
  }


  public POSTAccountType hpmCreditCardPaymentMethodId(String hpmCreditCardPaymentMethodId) {
    
    
    
    
    this.hpmCreditCardPaymentMethodId = hpmCreditCardPaymentMethodId;
    return this;
  }

   /**
   * The ID of the payment method associated with this account. The payment method specified for this field will be set as the default payment method of the account.  If the &#x60;autoPay&#x60; field is set to &#x60;true&#x60;, you must provide the credit card payment method ID for either this field or the &#x60;creditCard&#x60; field, but not both.  For the Credit Card Reference Transaction payment method, you can specify the payment method ID in this field or use the &#x60;paymentMethod&#x60; field to create a CC Reference Transaction payment method for an account. 
   * @return hpmCreditCardPaymentMethodId
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The ID of the payment method associated with this account. The payment method specified for this field will be set as the default payment method of the account.  If the `autoPay` field is set to `true`, you must provide the credit card payment method ID for either this field or the `creditCard` field, but not both.  For the Credit Card Reference Transaction payment method, you can specify the payment method ID in this field or use the `paymentMethod` field to create a CC Reference Transaction payment method for an account. ")

  public String getHpmCreditCardPaymentMethodId() {
    return hpmCreditCardPaymentMethodId;
  }


  public void setHpmCreditCardPaymentMethodId(String hpmCreditCardPaymentMethodId) {
    
    
    
    this.hpmCreditCardPaymentMethodId = hpmCreditCardPaymentMethodId;
  }


  public POSTAccountType invoice(Boolean invoice) {
    
    
    
    
    this.invoice = invoice;
    return this;
  }

   /**
   * **Note:** This field has been replaced by the &#x60;runBilling&#x60; field. The &#x60;invoice&#x60; field is only available for backward compatibility.   Creates an invoice for a subscription. The invoice generated in this operation is only for this subscription, not for the entire customer account.  If the value is &#x60;true&#x60;, an invoice is created. If the value is &#x60;false&#x60;, no action is taken.  **Note**: This field is only available if you set the &#x60;zuora-version&#x60; request header to &#x60;196.0&#x60; or &#x60;207.0&#x60;. 
   * @return invoice
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "true", value = "**Note:** This field has been replaced by the `runBilling` field. The `invoice` field is only available for backward compatibility.   Creates an invoice for a subscription. The invoice generated in this operation is only for this subscription, not for the entire customer account.  If the value is `true`, an invoice is created. If the value is `false`, no action is taken.  **Note**: This field is only available if you set the `zuora-version` request header to `196.0` or `207.0`. ")

  public Boolean getInvoice() {
    return invoice;
  }


  public void setInvoice(Boolean invoice) {
    
    
    
    this.invoice = invoice;
  }


  public POSTAccountType invoiceCollect(Boolean invoiceCollect) {
    
    
    
    
    this.invoiceCollect = invoiceCollect;
    return this;
  }

   /**
   * **Note:** This field has been replaced by the &#x60;invoice&#x60; field and the &#x60;collect&#x60; field. &#x60;invoiceCollect&#x60; is available only for backward compatibility.   If this field is set to &#x60;true&#x60;, and a subscription is created, an invoice is generated at account creation time and payment is immediately collected using the account&#39;s default payment method.   **Note**: This field is only available if you set the &#x60;zuora-version&#x60; request header to &#x60;186.0&#x60;, &#x60;187.0&#x60;, &#x60;188.0&#x60;, or &#x60;189.0&#x60;. The default field value is &#x60;true&#x60;. 
   * @return invoiceCollect
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "**Note:** This field has been replaced by the `invoice` field and the `collect` field. `invoiceCollect` is available only for backward compatibility.   If this field is set to `true`, and a subscription is created, an invoice is generated at account creation time and payment is immediately collected using the account's default payment method.   **Note**: This field is only available if you set the `zuora-version` request header to `186.0`, `187.0`, `188.0`, or `189.0`. The default field value is `true`. ")

  public Boolean getInvoiceCollect() {
    return invoiceCollect;
  }


  public void setInvoiceCollect(Boolean invoiceCollect) {
    
    
    
    this.invoiceCollect = invoiceCollect;
  }


  public POSTAccountType invoiceDeliveryPrefsEmail(Boolean invoiceDeliveryPrefsEmail) {
    
    
    
    
    this.invoiceDeliveryPrefsEmail = invoiceDeliveryPrefsEmail;
    return this;
  }

   /**
   * Whether the customer wants to receive invoices through email.  
   * @return invoiceDeliveryPrefsEmail
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "false", value = "Whether the customer wants to receive invoices through email.  ")

  public Boolean getInvoiceDeliveryPrefsEmail() {
    return invoiceDeliveryPrefsEmail;
  }


  public void setInvoiceDeliveryPrefsEmail(Boolean invoiceDeliveryPrefsEmail) {
    
    
    
    this.invoiceDeliveryPrefsEmail = invoiceDeliveryPrefsEmail;
  }


  public POSTAccountType invoiceDeliveryPrefsPrint(Boolean invoiceDeliveryPrefsPrint) {
    
    
    
    
    this.invoiceDeliveryPrefsPrint = invoiceDeliveryPrefsPrint;
    return this;
  }

   /**
   * Whether the customer wants to receive printed invoices, such as through postal mail. 
   * @return invoiceDeliveryPrefsPrint
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "false", value = "Whether the customer wants to receive printed invoices, such as through postal mail. ")

  public Boolean getInvoiceDeliveryPrefsPrint() {
    return invoiceDeliveryPrefsPrint;
  }


  public void setInvoiceDeliveryPrefsPrint(Boolean invoiceDeliveryPrefsPrint) {
    
    
    
    this.invoiceDeliveryPrefsPrint = invoiceDeliveryPrefsPrint;
  }


  public POSTAccountType invoiceTargetDate(LocalDate invoiceTargetDate) {
    
    
    
    
    this.invoiceTargetDate = invoiceTargetDate;
    return this;
  }

   /**
   * **Note:** This field has been replaced by the &#x60;targetDate&#x60; field. The &#x60;invoiceTargetDate&#x60; field is only available for backward compatibility.     Date through which to calculate charges if an invoice is generated, as yyyy-mm-dd. Default is current date.   This field is in REST API minor version control. To use this field in the method, you can set the &#x60;zuora-version&#x60; parameter to the minor version number in the request header. Supported minor versions are &#x60;207.0&#x60; and earlier [available versions](https://developer.zuora.com/api-references/api/overview/#section/API-Versions/Minor-Version).  
   * @return invoiceTargetDate
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "**Note:** This field has been replaced by the `targetDate` field. The `invoiceTargetDate` field is only available for backward compatibility.     Date through which to calculate charges if an invoice is generated, as yyyy-mm-dd. Default is current date.   This field is in REST API minor version control. To use this field in the method, you can set the `zuora-version` parameter to the minor version number in the request header. Supported minor versions are `207.0` and earlier [available versions](https://developer.zuora.com/api-references/api/overview/#section/API-Versions/Minor-Version).  ")

  public LocalDate getInvoiceTargetDate() {
    return invoiceTargetDate;
  }


  public void setInvoiceTargetDate(LocalDate invoiceTargetDate) {
    
    
    
    this.invoiceTargetDate = invoiceTargetDate;
  }


  public POSTAccountType invoiceTemplateId(String invoiceTemplateId) {
    
    
    
    
    this.invoiceTemplateId = invoiceTemplateId;
    return this;
  }

   /**
   * Invoice template ID, configured in Billing Settings in the Zuora UI. 
   * @return invoiceTemplateId
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Invoice template ID, configured in Billing Settings in the Zuora UI. ")

  public String getInvoiceTemplateId() {
    return invoiceTemplateId;
  }


  public void setInvoiceTemplateId(String invoiceTemplateId) {
    
    
    
    this.invoiceTemplateId = invoiceTemplateId;
  }


  public POSTAccountType name(String name) {
    
    
    
    
    this.name = name;
    return this;
  }

   /**
   * Account name, up to 255 characters. 
   * @return name
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "Account name, up to 255 characters. ")

  public String getName() {
    return name;
  }


  public void setName(String name) {
    
    
    
    this.name = name;
  }


  public POSTAccountType notes(String notes) {
    
    
    
    
    this.notes = notes;
    return this;
  }

   /**
   * A string of up to 65,535 characters.
   * @return notes
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "A string of up to 65,535 characters.")

  public String getNotes() {
    return notes;
  }


  public void setNotes(String notes) {
    
    
    
    this.notes = notes;
  }


  public POSTAccountType organizationLabel(String organizationLabel) {
    
    
    
    
    this.organizationLabel = organizationLabel;
    return this;
  }

   /**
   * Name of the organization that the account belongs to.    This field is only required when you have already turned on Multi-Org feature.     
   * @return organizationLabel
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Name of the organization that the account belongs to.    This field is only required when you have already turned on Multi-Org feature.     ")

  public String getOrganizationLabel() {
    return organizationLabel;
  }


  public void setOrganizationLabel(String organizationLabel) {
    
    
    
    this.organizationLabel = organizationLabel;
  }


  public POSTAccountType parentId(String parentId) {
    
    
    
    
    this.parentId = parentId;
    return this;
  }

   /**
   * Identifier of the parent customer account for this Account object. The length is 32 characters. Use this field if you have &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Billing/Subscriptions/Customer_Accounts/A_Customer_Account_Introduction#Customer_Hierarchy\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Customer Hierarchy&lt;/a&gt; enabled.
   * @return parentId
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Identifier of the parent customer account for this Account object. The length is 32 characters. Use this field if you have <a href=\"https://knowledgecenter.zuora.com/Billing/Subscriptions/Customer_Accounts/A_Customer_Account_Introduction#Customer_Hierarchy\" target=\"_blank\">Customer Hierarchy</a> enabled.")

  public String getParentId() {
    return parentId;
  }


  public void setParentId(String parentId) {
    
    
    
    this.parentId = parentId;
  }


  public POSTAccountType partnerAccount(Boolean partnerAccount) {
    
    
    
    
    this.partnerAccount = partnerAccount;
    return this;
  }

   /**
   * Whether the customer account is a partner, distributor, or reseller.    You can set this field to &#x60;true&#x60; if you have business with distributors or resellers, or operating in B2B model to manage numerous subscriptions through concurrent API requests. After this field is set to &#x60;true&#x60;, the calculation of account metrics is performed asynchronously during operations such as subscription creation, order changes, invoice generation, and payments.    **Note**: This field is available only if you have the &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Manage_customer_accounts/AAA_Overview_of_customer_accounts/Reseller_Account\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Reseller Account&lt;/a&gt; feature enabled. 
   * @return partnerAccount
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "false", value = "Whether the customer account is a partner, distributor, or reseller.    You can set this field to `true` if you have business with distributors or resellers, or operating in B2B model to manage numerous subscriptions through concurrent API requests. After this field is set to `true`, the calculation of account metrics is performed asynchronously during operations such as subscription creation, order changes, invoice generation, and payments.    **Note**: This field is available only if you have the <a href=\"https://knowledgecenter.zuora.com/Zuora_Billing/Manage_customer_accounts/AAA_Overview_of_customer_accounts/Reseller_Account\" target=\"_blank\">Reseller Account</a> feature enabled. ")

  public Boolean getPartnerAccount() {
    return partnerAccount;
  }


  public void setPartnerAccount(Boolean partnerAccount) {
    
    
    
    this.partnerAccount = partnerAccount;
  }


  public POSTAccountType paymentGateway(String paymentGateway) {
    
    
    
    
    this.paymentGateway = paymentGateway;
    return this;
  }

   /**
   * The name of the payment gateway instance. If null or left unassigned, the Account will use the Default Gateway. 
   * @return paymentGateway
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The name of the payment gateway instance. If null or left unassigned, the Account will use the Default Gateway. ")

  public String getPaymentGateway() {
    return paymentGateway;
  }


  public void setPaymentGateway(String paymentGateway) {
    
    
    
    this.paymentGateway = paymentGateway;
  }


  public POSTAccountType paymentMethod(Object paymentMethod) {
    
    
    
    
    this.paymentMethod = paymentMethod;
    return this;
  }

   /**
   * Get paymentMethod
   * @return paymentMethod
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public Object getPaymentMethod() {
    return paymentMethod;
  }


  public void setPaymentMethod(Object paymentMethod) {
    
    
    
    this.paymentMethod = paymentMethod;
  }


  public POSTAccountType paymentTerm(String paymentTerm) {
    
    
    
    
    this.paymentTerm = paymentTerm;
    return this;
  }

   /**
   * Payment terms for this account. Possible values are: &#x60;Due Upon Receipt&#x60;, &#x60;Net 30&#x60;, &#x60;Net 60&#x60;, &#x60;Net 90&#x60;.  **Note**: If you want to specify a payment term when creating a new account, you must set a value in this field. If you do not set a value in this field, Zuora will use &#x60;Due Upon Receipt&#x60; as the value instead of the default value set in **Billing Settings** &gt; **Payment Terms** from Zuora UI. 
   * @return paymentTerm
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Payment terms for this account. Possible values are: `Due Upon Receipt`, `Net 30`, `Net 60`, `Net 90`.  **Note**: If you want to specify a payment term when creating a new account, you must set a value in this field. If you do not set a value in this field, Zuora will use `Due Upon Receipt` as the value instead of the default value set in **Billing Settings** > **Payment Terms** from Zuora UI. ")

  public String getPaymentTerm() {
    return paymentTerm;
  }


  public void setPaymentTerm(String paymentTerm) {
    
    
    
    this.paymentTerm = paymentTerm;
  }


  public POSTAccountType profileNumber(String profileNumber) {
    
    
    
    
    this.profileNumber = profileNumber;
    return this;
  }

   /**
   * The number of the communication profile that this account is linked to.  You can provide either or both of the &#x60;communicationProfileId&#x60; and &#x60;profileNumber&#x60; fields.  If both are provided, the request will fail if they do not refer to the same communication profile. 
   * @return profileNumber
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The number of the communication profile that this account is linked to.  You can provide either or both of the `communicationProfileId` and `profileNumber` fields.  If both are provided, the request will fail if they do not refer to the same communication profile. ")

  public String getProfileNumber() {
    return profileNumber;
  }


  public void setProfileNumber(String profileNumber) {
    
    
    
    this.profileNumber = profileNumber;
  }


  public POSTAccountType runBilling(RunBillingEnum runBilling) {
    
    
    
    
    this.runBilling = runBilling;
    return this;
  }

   /**
   * Creates an invoice for a subscription. If you have the Invoice Settlement feature enabled, a credit memo might also be created based on the [invoice and credit memo generation rule](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/Invoice_Settlement/B_Credit_and_Debit_Memos/Rules_for_generating_invoices_and_credit_memos).    The billing documents generated in this operation is only for this subscription, not for the entire customer account.   Possible values:  - &#x60;true&#x60;: An invoice is created. If you have the Invoice Settlement feature enabled, a credit memo might also be created.   - &#x60;false&#x60;: No invoice is created.   **Note:** This field is in Zuora REST API version control. Supported minor versions are &#x60;211.0&#x60; and later [available versions](https://developer.zuora.com/api-references/api/overview/#section/API-Versions/Minor-Version). To use this field in the method, you must set the &#x60;zuora-version&#x60; parameter to the minor version number in the request header. 
   * @return runBilling
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "TRUE", value = "Creates an invoice for a subscription. If you have the Invoice Settlement feature enabled, a credit memo might also be created based on the [invoice and credit memo generation rule](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/Invoice_Settlement/B_Credit_and_Debit_Memos/Rules_for_generating_invoices_and_credit_memos).    The billing documents generated in this operation is only for this subscription, not for the entire customer account.   Possible values:  - `true`: An invoice is created. If you have the Invoice Settlement feature enabled, a credit memo might also be created.   - `false`: No invoice is created.   **Note:** This field is in Zuora REST API version control. Supported minor versions are `211.0` and later [available versions](https://developer.zuora.com/api-references/api/overview/#section/API-Versions/Minor-Version). To use this field in the method, you must set the `zuora-version` parameter to the minor version number in the request header. ")

  public RunBillingEnum getRunBilling() {
    return runBilling;
  }


  public void setRunBilling(RunBillingEnum runBilling) {
    
    
    
    this.runBilling = runBilling;
  }


  public POSTAccountType salesRep(String salesRep) {
    
    
    
    
    this.salesRep = salesRep;
    return this;
  }

   /**
   * The name of the sales representative associated with this account, if applicable. Maximum of 50 characters.
   * @return salesRep
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The name of the sales representative associated with this account, if applicable. Maximum of 50 characters.")

  public String getSalesRep() {
    return salesRep;
  }


  public void setSalesRep(String salesRep) {
    
    
    
    this.salesRep = salesRep;
  }


  public POSTAccountType sequenceSetId(String sequenceSetId) {
    
    
    
    
    this.sequenceSetId = sequenceSetId;
    return this;
  }

   /**
   * The ID of the billing document sequence set to assign to the customer account.   The billing documents to generate for this account will adopt the prefix and starting document number configured in the sequence set.  If a customer account has no assigned billing document sequence set, billing documents generated for this account adopt the prefix and starting document number from the default sequence set. 
   * @return sequenceSetId
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The ID of the billing document sequence set to assign to the customer account.   The billing documents to generate for this account will adopt the prefix and starting document number configured in the sequence set.  If a customer account has no assigned billing document sequence set, billing documents generated for this account adopt the prefix and starting document number from the default sequence set. ")

  public String getSequenceSetId() {
    return sequenceSetId;
  }


  public void setSequenceSetId(String sequenceSetId) {
    
    
    
    this.sequenceSetId = sequenceSetId;
  }


  public POSTAccountType soldToContact(POSTAccountTypeSoldToContact soldToContact) {
    
    
    
    
    this.soldToContact = soldToContact;
    return this;
  }

   /**
   * Get soldToContact
   * @return soldToContact
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public POSTAccountTypeSoldToContact getSoldToContact() {
    return soldToContact;
  }


  public void setSoldToContact(POSTAccountTypeSoldToContact soldToContact) {
    
    
    
    this.soldToContact = soldToContact;
  }


  public POSTAccountType soldToSameAsBillTo(Boolean soldToSameAsBillTo) {
    
    
    
    
    this.soldToSameAsBillTo = soldToSameAsBillTo;
    return this;
  }

   /**
   * Whether the sold-to contact and bill-to contact are the same entity.   The created account has the same bill-to contact and sold-to contact entity only when all the following conditions are met in the request body:  - This field is set to &#x60;true&#x60;.  - A bill-to contact is specified. - No sold-to contact is specified. 
   * @return soldToSameAsBillTo
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Whether the sold-to contact and bill-to contact are the same entity.   The created account has the same bill-to contact and sold-to contact entity only when all the following conditions are met in the request body:  - This field is set to `true`.  - A bill-to contact is specified. - No sold-to contact is specified. ")

  public Boolean getSoldToSameAsBillTo() {
    return soldToSameAsBillTo;
  }


  public void setSoldToSameAsBillTo(Boolean soldToSameAsBillTo) {
    
    
    
    this.soldToSameAsBillTo = soldToSameAsBillTo;
  }


  public POSTAccountType subscription(POSTAccountTypeSubscription subscription) {
    
    
    
    
    this.subscription = subscription;
    return this;
  }

   /**
   * Get subscription
   * @return subscription
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public POSTAccountTypeSubscription getSubscription() {
    return subscription;
  }


  public void setSubscription(POSTAccountTypeSubscription subscription) {
    
    
    
    this.subscription = subscription;
  }


  public POSTAccountType tagging(String tagging) {
    
    
    
    
    this.tagging = tagging;
    return this;
  }

   /**
   * 
   * @return tagging
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public String getTagging() {
    return tagging;
  }


  public void setTagging(String tagging) {
    
    
    
    this.tagging = tagging;
  }


  public POSTAccountType targetDate(LocalDate targetDate) {
    
    
    
    
    this.targetDate = targetDate;
    return this;
  }

   /**
   * Date through which to calculate charges if an invoice or a credit memo is generated, as yyyy-mm-dd. Default is current date.  **Note:** The credit memo is only available only if you have the Invoice Settlement feature enabled.  This field is in Zuora REST API version control. Supported minor versions are &#x60;211.0&#x60; and later [available versions](https://developer.zuora.com/api-references/api/overview/#section/API-Versions/Minor-Version). To use this field in the method, you must set the  &#x60;zuora-version&#x60; parameter to the minor version number in the request header. 
   * @return targetDate
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Date through which to calculate charges if an invoice or a credit memo is generated, as yyyy-mm-dd. Default is current date.  **Note:** The credit memo is only available only if you have the Invoice Settlement feature enabled.  This field is in Zuora REST API version control. Supported minor versions are `211.0` and later [available versions](https://developer.zuora.com/api-references/api/overview/#section/API-Versions/Minor-Version). To use this field in the method, you must set the  `zuora-version` parameter to the minor version number in the request header. ")

  public LocalDate getTargetDate() {
    return targetDate;
  }


  public void setTargetDate(LocalDate targetDate) {
    
    
    
    this.targetDate = targetDate;
  }


  public POSTAccountType taxInfo(POSTAccountTypeAllOfTaxInfo taxInfo) {
    
    
    
    
    this.taxInfo = taxInfo;
    return this;
  }

   /**
   * Get taxInfo
   * @return taxInfo
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public POSTAccountTypeAllOfTaxInfo getTaxInfo() {
    return taxInfo;
  }


  public void setTaxInfo(POSTAccountTypeAllOfTaxInfo taxInfo) {
    
    
    
    this.taxInfo = taxInfo;
  }


  public POSTAccountType classNS(String classNS) {
    
    
    
    
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


  public POSTAccountType customerTypeNS(CustomerTypeNSEnum customerTypeNS) {
    
    
    
    
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


  public POSTAccountType departmentNS(String departmentNS) {
    
    
    
    
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


  public POSTAccountType integrationIdNS(String integrationIdNS) {
    
    
    
    
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


  public POSTAccountType integrationStatusNS(String integrationStatusNS) {
    
    
    
    
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


  public POSTAccountType locationNS(String locationNS) {
    
    
    
    
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


  public POSTAccountType subsidiaryNS(String subsidiaryNS) {
    
    
    
    
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


  public POSTAccountType syncDateNS(String syncDateNS) {
    
    
    
    
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


  public POSTAccountType synctoNetSuiteNS(SynctoNetSuiteNSEnum synctoNetSuiteNS) {
    
    
    
    
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
   * @return the POSTAccountType instance itself
   */
  public POSTAccountType putAdditionalProperty(String key, Object value) {
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
    POSTAccountType poSTAccountType = (POSTAccountType) o;
    return Objects.equals(this.accountNumber, poSTAccountType.accountNumber) &&
        Objects.equals(this.additionalEmailAddresses, poSTAccountType.additionalEmailAddresses) &&
        Objects.equals(this.applicationOrder, poSTAccountType.applicationOrder) &&
        Objects.equals(this.applyCredit, poSTAccountType.applyCredit) &&
        Objects.equals(this.applyCreditBalance, poSTAccountType.applyCreditBalance) &&
        Objects.equals(this.autoPay, poSTAccountType.autoPay) &&
        Objects.equals(this.batch, poSTAccountType.batch) &&
        Objects.equals(this.billCycleDay, poSTAccountType.billCycleDay) &&
        Objects.equals(this.billToContact, poSTAccountType.billToContact) &&
        Objects.equals(this.collect, poSTAccountType.collect) &&
        Objects.equals(this.communicationProfileId, poSTAccountType.communicationProfileId) &&
        Objects.equals(this.creditCard, poSTAccountType.creditCard) &&
        Objects.equals(this.creditMemoReasonCode, poSTAccountType.creditMemoReasonCode) &&
        Objects.equals(this.creditMemoTemplateId, poSTAccountType.creditMemoTemplateId) &&
        Objects.equals(this.crmId, poSTAccountType.crmId) &&
        Objects.equals(this.currency, poSTAccountType.currency) &&
        Objects.equals(this.debitMemoTemplateId, poSTAccountType.debitMemoTemplateId) &&
        Objects.equals(this.documentDate, poSTAccountType.documentDate) &&
        Objects.equals(this.einvoiceProfile, poSTAccountType.einvoiceProfile) &&
        Objects.equals(this.hpmCreditCardPaymentMethodId, poSTAccountType.hpmCreditCardPaymentMethodId) &&
        Objects.equals(this.invoice, poSTAccountType.invoice) &&
        Objects.equals(this.invoiceCollect, poSTAccountType.invoiceCollect) &&
        Objects.equals(this.invoiceDeliveryPrefsEmail, poSTAccountType.invoiceDeliveryPrefsEmail) &&
        Objects.equals(this.invoiceDeliveryPrefsPrint, poSTAccountType.invoiceDeliveryPrefsPrint) &&
        Objects.equals(this.invoiceTargetDate, poSTAccountType.invoiceTargetDate) &&
        Objects.equals(this.invoiceTemplateId, poSTAccountType.invoiceTemplateId) &&
        Objects.equals(this.name, poSTAccountType.name) &&
        Objects.equals(this.notes, poSTAccountType.notes) &&
        Objects.equals(this.organizationLabel, poSTAccountType.organizationLabel) &&
        Objects.equals(this.parentId, poSTAccountType.parentId) &&
        Objects.equals(this.partnerAccount, poSTAccountType.partnerAccount) &&
        Objects.equals(this.paymentGateway, poSTAccountType.paymentGateway) &&
        Objects.equals(this.paymentMethod, poSTAccountType.paymentMethod) &&
        Objects.equals(this.paymentTerm, poSTAccountType.paymentTerm) &&
        Objects.equals(this.profileNumber, poSTAccountType.profileNumber) &&
        Objects.equals(this.runBilling, poSTAccountType.runBilling) &&
        Objects.equals(this.salesRep, poSTAccountType.salesRep) &&
        Objects.equals(this.sequenceSetId, poSTAccountType.sequenceSetId) &&
        Objects.equals(this.soldToContact, poSTAccountType.soldToContact) &&
        Objects.equals(this.soldToSameAsBillTo, poSTAccountType.soldToSameAsBillTo) &&
        Objects.equals(this.subscription, poSTAccountType.subscription) &&
        Objects.equals(this.tagging, poSTAccountType.tagging) &&
        Objects.equals(this.targetDate, poSTAccountType.targetDate) &&
        Objects.equals(this.taxInfo, poSTAccountType.taxInfo) &&
        Objects.equals(this.classNS, poSTAccountType.classNS) &&
        Objects.equals(this.customerTypeNS, poSTAccountType.customerTypeNS) &&
        Objects.equals(this.departmentNS, poSTAccountType.departmentNS) &&
        Objects.equals(this.integrationIdNS, poSTAccountType.integrationIdNS) &&
        Objects.equals(this.integrationStatusNS, poSTAccountType.integrationStatusNS) &&
        Objects.equals(this.locationNS, poSTAccountType.locationNS) &&
        Objects.equals(this.subsidiaryNS, poSTAccountType.subsidiaryNS) &&
        Objects.equals(this.syncDateNS, poSTAccountType.syncDateNS) &&
        Objects.equals(this.synctoNetSuiteNS, poSTAccountType.synctoNetSuiteNS)&&
        Objects.equals(this.additionalProperties, poSTAccountType.additionalProperties);
  }

  private static <T> boolean equalsNullable(JsonNullable<T> a, JsonNullable<T> b) {
    return a == b || (a != null && b != null && a.isPresent() && b.isPresent() && Objects.deepEquals(a.get(), b.get()));
  }

  @Override
  public int hashCode() {
    return Objects.hash(accountNumber, additionalEmailAddresses, applicationOrder, applyCredit, applyCreditBalance, autoPay, batch, billCycleDay, billToContact, collect, communicationProfileId, creditCard, creditMemoReasonCode, creditMemoTemplateId, crmId, currency, debitMemoTemplateId, documentDate, einvoiceProfile, hpmCreditCardPaymentMethodId, invoice, invoiceCollect, invoiceDeliveryPrefsEmail, invoiceDeliveryPrefsPrint, invoiceTargetDate, invoiceTemplateId, name, notes, organizationLabel, parentId, partnerAccount, paymentGateway, paymentMethod, paymentTerm, profileNumber, runBilling, salesRep, sequenceSetId, soldToContact, soldToSameAsBillTo, subscription, tagging, targetDate, taxInfo, classNS, customerTypeNS, departmentNS, integrationIdNS, integrationStatusNS, locationNS, subsidiaryNS, syncDateNS, synctoNetSuiteNS, additionalProperties);
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
    sb.append("class POSTAccountType {\n");
    sb.append("    accountNumber: ").append(toIndentedString(accountNumber)).append("\n");
    sb.append("    additionalEmailAddresses: ").append(toIndentedString(additionalEmailAddresses)).append("\n");
    sb.append("    applicationOrder: ").append(toIndentedString(applicationOrder)).append("\n");
    sb.append("    applyCredit: ").append(toIndentedString(applyCredit)).append("\n");
    sb.append("    applyCreditBalance: ").append(toIndentedString(applyCreditBalance)).append("\n");
    sb.append("    autoPay: ").append(toIndentedString(autoPay)).append("\n");
    sb.append("    batch: ").append(toIndentedString(batch)).append("\n");
    sb.append("    billCycleDay: ").append(toIndentedString(billCycleDay)).append("\n");
    sb.append("    billToContact: ").append(toIndentedString(billToContact)).append("\n");
    sb.append("    collect: ").append(toIndentedString(collect)).append("\n");
    sb.append("    communicationProfileId: ").append(toIndentedString(communicationProfileId)).append("\n");
    sb.append("    creditCard: ").append(toIndentedString(creditCard)).append("\n");
    sb.append("    creditMemoReasonCode: ").append(toIndentedString(creditMemoReasonCode)).append("\n");
    sb.append("    creditMemoTemplateId: ").append(toIndentedString(creditMemoTemplateId)).append("\n");
    sb.append("    crmId: ").append(toIndentedString(crmId)).append("\n");
    sb.append("    currency: ").append(toIndentedString(currency)).append("\n");
    sb.append("    debitMemoTemplateId: ").append(toIndentedString(debitMemoTemplateId)).append("\n");
    sb.append("    documentDate: ").append(toIndentedString(documentDate)).append("\n");
    sb.append("    einvoiceProfile: ").append(toIndentedString(einvoiceProfile)).append("\n");
    sb.append("    hpmCreditCardPaymentMethodId: ").append(toIndentedString(hpmCreditCardPaymentMethodId)).append("\n");
    sb.append("    invoice: ").append(toIndentedString(invoice)).append("\n");
    sb.append("    invoiceCollect: ").append(toIndentedString(invoiceCollect)).append("\n");
    sb.append("    invoiceDeliveryPrefsEmail: ").append(toIndentedString(invoiceDeliveryPrefsEmail)).append("\n");
    sb.append("    invoiceDeliveryPrefsPrint: ").append(toIndentedString(invoiceDeliveryPrefsPrint)).append("\n");
    sb.append("    invoiceTargetDate: ").append(toIndentedString(invoiceTargetDate)).append("\n");
    sb.append("    invoiceTemplateId: ").append(toIndentedString(invoiceTemplateId)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    notes: ").append(toIndentedString(notes)).append("\n");
    sb.append("    organizationLabel: ").append(toIndentedString(organizationLabel)).append("\n");
    sb.append("    parentId: ").append(toIndentedString(parentId)).append("\n");
    sb.append("    partnerAccount: ").append(toIndentedString(partnerAccount)).append("\n");
    sb.append("    paymentGateway: ").append(toIndentedString(paymentGateway)).append("\n");
    sb.append("    paymentMethod: ").append(toIndentedString(paymentMethod)).append("\n");
    sb.append("    paymentTerm: ").append(toIndentedString(paymentTerm)).append("\n");
    sb.append("    profileNumber: ").append(toIndentedString(profileNumber)).append("\n");
    sb.append("    runBilling: ").append(toIndentedString(runBilling)).append("\n");
    sb.append("    salesRep: ").append(toIndentedString(salesRep)).append("\n");
    sb.append("    sequenceSetId: ").append(toIndentedString(sequenceSetId)).append("\n");
    sb.append("    soldToContact: ").append(toIndentedString(soldToContact)).append("\n");
    sb.append("    soldToSameAsBillTo: ").append(toIndentedString(soldToSameAsBillTo)).append("\n");
    sb.append("    subscription: ").append(toIndentedString(subscription)).append("\n");
    sb.append("    tagging: ").append(toIndentedString(tagging)).append("\n");
    sb.append("    targetDate: ").append(toIndentedString(targetDate)).append("\n");
    sb.append("    taxInfo: ").append(toIndentedString(taxInfo)).append("\n");
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
    openapiFields.add("accountNumber");
    openapiFields.add("additionalEmailAddresses");
    openapiFields.add("applicationOrder");
    openapiFields.add("applyCredit");
    openapiFields.add("applyCreditBalance");
    openapiFields.add("autoPay");
    openapiFields.add("batch");
    openapiFields.add("billCycleDay");
    openapiFields.add("billToContact");
    openapiFields.add("collect");
    openapiFields.add("communicationProfileId");
    openapiFields.add("creditCard");
    openapiFields.add("creditMemoReasonCode");
    openapiFields.add("creditMemoTemplateId");
    openapiFields.add("crmId");
    openapiFields.add("currency");
    openapiFields.add("debitMemoTemplateId");
    openapiFields.add("documentDate");
    openapiFields.add("einvoiceProfile");
    openapiFields.add("hpmCreditCardPaymentMethodId");
    openapiFields.add("invoice");
    openapiFields.add("invoiceCollect");
    openapiFields.add("invoiceDeliveryPrefsEmail");
    openapiFields.add("invoiceDeliveryPrefsPrint");
    openapiFields.add("invoiceTargetDate");
    openapiFields.add("invoiceTemplateId");
    openapiFields.add("name");
    openapiFields.add("notes");
    openapiFields.add("organizationLabel");
    openapiFields.add("parentId");
    openapiFields.add("partnerAccount");
    openapiFields.add("paymentGateway");
    openapiFields.add("paymentMethod");
    openapiFields.add("paymentTerm");
    openapiFields.add("profileNumber");
    openapiFields.add("runBilling");
    openapiFields.add("salesRep");
    openapiFields.add("sequenceSetId");
    openapiFields.add("soldToContact");
    openapiFields.add("soldToSameAsBillTo");
    openapiFields.add("subscription");
    openapiFields.add("tagging");
    openapiFields.add("targetDate");
    openapiFields.add("taxInfo");
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
    openapiRequiredFields.add("billToContact");
    openapiRequiredFields.add("currency");
    openapiRequiredFields.add("name");
  }

 /**
  * Validates the JSON Object and throws an exception if issues found
  *
  * @param jsonObj JSON Object
  * @throws IOException if the JSON Object is invalid with respect to POSTAccountType
  */
  public static void validateJsonObject(JsonObject jsonObj) throws IOException {
      if (jsonObj == null) {
        if (!POSTAccountType.openapiRequiredFields.isEmpty()) { // has required fields but JSON object is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in POSTAccountType is not found in the empty JSON string", POSTAccountType.openapiRequiredFields.toString()));
        }
      }

      // check to make sure all required properties/fields are present in the JSON string
      for (String requiredField : POSTAccountType.openapiRequiredFields) {
        if (jsonObj.get(requiredField) == null) {
          throw new IllegalArgumentException(String.format("The required field `%s` is not found in the JSON string: %s", requiredField, jsonObj.toString()));
        }
      }
      if ((jsonObj.get("accountNumber") != null && !jsonObj.get("accountNumber").isJsonNull()) && !jsonObj.get("accountNumber").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `accountNumber` to be a primitive type in the JSON string but got `%s`", jsonObj.get("accountNumber").toString()));
      }
      // ensure the optional json data is an array if present
      if (jsonObj.get("additionalEmailAddresses") != null && !jsonObj.get("additionalEmailAddresses").isJsonArray()) {
        throw new IllegalArgumentException(String.format("Expected the field `additionalEmailAddresses` to be an array in the JSON string but got `%s`", jsonObj.get("additionalEmailAddresses").toString()));
      }
      // ensure the optional json data is an array if present
      if (jsonObj.get("applicationOrder") != null && !jsonObj.get("applicationOrder").isJsonArray()) {
        throw new IllegalArgumentException(String.format("Expected the field `applicationOrder` to be an array in the JSON string but got `%s`", jsonObj.get("applicationOrder").toString()));
      }
      if ((jsonObj.get("batch") != null && !jsonObj.get("batch").isJsonNull()) && !jsonObj.get("batch").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `batch` to be a primitive type in the JSON string but got `%s`", jsonObj.get("batch").toString()));
      }
      // validate the required field `billToContact`
      POSTAccountTypeBillToContact.validateJsonObject(jsonObj.getAsJsonObject("billToContact"));
      if ((jsonObj.get("communicationProfileId") != null && !jsonObj.get("communicationProfileId").isJsonNull()) && !jsonObj.get("communicationProfileId").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `communicationProfileId` to be a primitive type in the JSON string but got `%s`", jsonObj.get("communicationProfileId").toString()));
      }
      // validate the optional field `creditCard`
      if (jsonObj.get("creditCard") != null && !jsonObj.get("creditCard").isJsonNull()) {
        POSTAccountTypeCreditCard.validateJsonObject(jsonObj.getAsJsonObject("creditCard"));
      }
      if ((jsonObj.get("creditMemoReasonCode") != null && !jsonObj.get("creditMemoReasonCode").isJsonNull()) && !jsonObj.get("creditMemoReasonCode").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `creditMemoReasonCode` to be a primitive type in the JSON string but got `%s`", jsonObj.get("creditMemoReasonCode").toString()));
      }
      if ((jsonObj.get("creditMemoTemplateId") != null && !jsonObj.get("creditMemoTemplateId").isJsonNull()) && !jsonObj.get("creditMemoTemplateId").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `creditMemoTemplateId` to be a primitive type in the JSON string but got `%s`", jsonObj.get("creditMemoTemplateId").toString()));
      }
      if ((jsonObj.get("crmId") != null && !jsonObj.get("crmId").isJsonNull()) && !jsonObj.get("crmId").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `crmId` to be a primitive type in the JSON string but got `%s`", jsonObj.get("crmId").toString()));
      }
      if (!jsonObj.get("currency").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `currency` to be a primitive type in the JSON string but got `%s`", jsonObj.get("currency").toString()));
      }
      if ((jsonObj.get("debitMemoTemplateId") != null && !jsonObj.get("debitMemoTemplateId").isJsonNull()) && !jsonObj.get("debitMemoTemplateId").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `debitMemoTemplateId` to be a primitive type in the JSON string but got `%s`", jsonObj.get("debitMemoTemplateId").toString()));
      }
      // validate the optional field `einvoiceProfile`
      if (jsonObj.get("einvoiceProfile") != null && !jsonObj.get("einvoiceProfile").isJsonNull()) {
        PostAccountEInvoiceProfile.validateJsonObject(jsonObj.getAsJsonObject("einvoiceProfile"));
      }
      if ((jsonObj.get("hpmCreditCardPaymentMethodId") != null && !jsonObj.get("hpmCreditCardPaymentMethodId").isJsonNull()) && !jsonObj.get("hpmCreditCardPaymentMethodId").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `hpmCreditCardPaymentMethodId` to be a primitive type in the JSON string but got `%s`", jsonObj.get("hpmCreditCardPaymentMethodId").toString()));
      }
      if ((jsonObj.get("invoiceTemplateId") != null && !jsonObj.get("invoiceTemplateId").isJsonNull()) && !jsonObj.get("invoiceTemplateId").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `invoiceTemplateId` to be a primitive type in the JSON string but got `%s`", jsonObj.get("invoiceTemplateId").toString()));
      }
      if (!jsonObj.get("name").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `name` to be a primitive type in the JSON string but got `%s`", jsonObj.get("name").toString()));
      }
      if ((jsonObj.get("notes") != null && !jsonObj.get("notes").isJsonNull()) && !jsonObj.get("notes").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `notes` to be a primitive type in the JSON string but got `%s`", jsonObj.get("notes").toString()));
      }
      if ((jsonObj.get("organizationLabel") != null && !jsonObj.get("organizationLabel").isJsonNull()) && !jsonObj.get("organizationLabel").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `organizationLabel` to be a primitive type in the JSON string but got `%s`", jsonObj.get("organizationLabel").toString()));
      }
      if ((jsonObj.get("parentId") != null && !jsonObj.get("parentId").isJsonNull()) && !jsonObj.get("parentId").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `parentId` to be a primitive type in the JSON string but got `%s`", jsonObj.get("parentId").toString()));
      }
      if ((jsonObj.get("paymentGateway") != null && !jsonObj.get("paymentGateway").isJsonNull()) && !jsonObj.get("paymentGateway").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `paymentGateway` to be a primitive type in the JSON string but got `%s`", jsonObj.get("paymentGateway").toString()));
      }
      if ((jsonObj.get("paymentTerm") != null && !jsonObj.get("paymentTerm").isJsonNull()) && !jsonObj.get("paymentTerm").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `paymentTerm` to be a primitive type in the JSON string but got `%s`", jsonObj.get("paymentTerm").toString()));
      }
      if ((jsonObj.get("profileNumber") != null && !jsonObj.get("profileNumber").isJsonNull()) && !jsonObj.get("profileNumber").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `profileNumber` to be a primitive type in the JSON string but got `%s`", jsonObj.get("profileNumber").toString()));
      }
      if ((jsonObj.get("salesRep") != null && !jsonObj.get("salesRep").isJsonNull()) && !jsonObj.get("salesRep").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `salesRep` to be a primitive type in the JSON string but got `%s`", jsonObj.get("salesRep").toString()));
      }
      if ((jsonObj.get("sequenceSetId") != null && !jsonObj.get("sequenceSetId").isJsonNull()) && !jsonObj.get("sequenceSetId").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `sequenceSetId` to be a primitive type in the JSON string but got `%s`", jsonObj.get("sequenceSetId").toString()));
      }
      // validate the optional field `soldToContact`
      if (jsonObj.get("soldToContact") != null && !jsonObj.get("soldToContact").isJsonNull()) {
        POSTAccountTypeSoldToContact.validateJsonObject(jsonObj.getAsJsonObject("soldToContact"));
      }
      // validate the optional field `subscription`
      if (jsonObj.get("subscription") != null && !jsonObj.get("subscription").isJsonNull()) {
        POSTAccountTypeSubscription.validateJsonObject(jsonObj.getAsJsonObject("subscription"));
      }
      if ((jsonObj.get("tagging") != null && !jsonObj.get("tagging").isJsonNull()) && !jsonObj.get("tagging").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `tagging` to be a primitive type in the JSON string but got `%s`", jsonObj.get("tagging").toString()));
      }
      // validate the optional field `taxInfo`
      if (jsonObj.get("taxInfo") != null && !jsonObj.get("taxInfo").isJsonNull()) {
        POSTAccountTypeAllOfTaxInfo.validateJsonObject(jsonObj.getAsJsonObject("taxInfo"));
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
       if (!POSTAccountType.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'POSTAccountType' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<POSTAccountType> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(POSTAccountType.class));

       return (TypeAdapter<T>) new TypeAdapter<POSTAccountType>() {
           @Override
           public void write(JsonWriter out, POSTAccountType value) throws IOException {
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
           public POSTAccountType read(JsonReader in) throws IOException {
             JsonObject jsonObj = elementAdapter.read(in).getAsJsonObject();
             validateJsonObject(jsonObj);
             // store additional fields in the deserialized instance
             POSTAccountType instance = thisAdapter.fromJsonTree(jsonObj);
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
  * Create an instance of POSTAccountType given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of POSTAccountType
  * @throws IOException if the JSON string is invalid with respect to POSTAccountType
  */
  public static POSTAccountType fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, POSTAccountType.class);
  }

 /**
  * Convert an instance of POSTAccountType to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

