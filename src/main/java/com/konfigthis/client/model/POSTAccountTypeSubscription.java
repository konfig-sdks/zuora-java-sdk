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
import com.konfigthis.client.model.POSTSrpCreateType;
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
 * Container for subscription information, used if creating a subscription for the new account at the time of account creation. 
 */
@ApiModel(description = "Container for subscription information, used if creating a subscription for the new account at the time of account creation. ")@javax.annotation.Generated(value = "Generated by https://konfigthis.com")
public class POSTAccountTypeSubscription {
  public static final String SERIALIZED_NAME_AUTO_RENEW = "autoRenew";
  @SerializedName(SERIALIZED_NAME_AUTO_RENEW)
  private Boolean autoRenew;

  public static final String SERIALIZED_NAME_CONTRACT_EFFECTIVE_DATE = "contractEffectiveDate";
  @SerializedName(SERIALIZED_NAME_CONTRACT_EFFECTIVE_DATE)
  private LocalDate contractEffectiveDate;

  public static final String SERIALIZED_NAME_CUSTOMER_ACCEPTANCE_DATE = "customerAcceptanceDate";
  @SerializedName(SERIALIZED_NAME_CUSTOMER_ACCEPTANCE_DATE)
  private LocalDate customerAcceptanceDate;

  public static final String SERIALIZED_NAME_INITIAL_TERM = "initialTerm";
  @SerializedName(SERIALIZED_NAME_INITIAL_TERM)
  private Long initialTerm;

  public static final String SERIALIZED_NAME_INVOICE_OWNER_ACCOUNT_KEY = "invoiceOwnerAccountKey";
  @SerializedName(SERIALIZED_NAME_INVOICE_OWNER_ACCOUNT_KEY)
  private String invoiceOwnerAccountKey;

  public static final String SERIALIZED_NAME_INVOICE_SEPARATELY = "invoiceSeparately";
  @SerializedName(SERIALIZED_NAME_INVOICE_SEPARATELY)
  private Boolean invoiceSeparately;

  public static final String SERIALIZED_NAME_NOTES = "notes";
  @SerializedName(SERIALIZED_NAME_NOTES)
  private String notes;

  public static final String SERIALIZED_NAME_RENEWAL_TERM = "renewalTerm";
  @SerializedName(SERIALIZED_NAME_RENEWAL_TERM)
  private Long renewalTerm;

  public static final String SERIALIZED_NAME_SERVICE_ACTIVATION_DATE = "serviceActivationDate";
  @SerializedName(SERIALIZED_NAME_SERVICE_ACTIVATION_DATE)
  private LocalDate serviceActivationDate;

  public static final String SERIALIZED_NAME_SUBSCRIBE_TO_RATE_PLANS = "subscribeToRatePlans";
  @SerializedName(SERIALIZED_NAME_SUBSCRIBE_TO_RATE_PLANS)
  private List<POSTSrpCreateType> subscribeToRatePlans = null;

  public static final String SERIALIZED_NAME_SUBSCRIPTION_NUMBER = "subscriptionNumber";
  @SerializedName(SERIALIZED_NAME_SUBSCRIPTION_NUMBER)
  private String subscriptionNumber;

  public static final String SERIALIZED_NAME_TERM_START_DATE = "termStartDate";
  @SerializedName(SERIALIZED_NAME_TERM_START_DATE)
  private LocalDate termStartDate;

  public static final String SERIALIZED_NAME_TERM_TYPE = "termType";
  @SerializedName(SERIALIZED_NAME_TERM_TYPE)
  private String termType;

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

  public POSTAccountTypeSubscription() {
  }

  public POSTAccountTypeSubscription autoRenew(Boolean autoRenew) {
    
    
    
    
    this.autoRenew = autoRenew;
    return this;
  }

   /**
   * If &#x60;true&#x60;, auto-renew is enabled. Default is &#x60;false&#x60;. 
   * @return autoRenew
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "If `true`, auto-renew is enabled. Default is `false`. ")

  public Boolean getAutoRenew() {
    return autoRenew;
  }


  public void setAutoRenew(Boolean autoRenew) {
    
    
    
    this.autoRenew = autoRenew;
  }


  public POSTAccountTypeSubscription contractEffectiveDate(LocalDate contractEffectiveDate) {
    
    
    
    
    this.contractEffectiveDate = contractEffectiveDate;
    return this;
  }

   /**
   * Effective contract date for this subscription, as &#x60;yyyy-mm-dd&#x60;. 
   * @return contractEffectiveDate
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "Effective contract date for this subscription, as `yyyy-mm-dd`. ")

  public LocalDate getContractEffectiveDate() {
    return contractEffectiveDate;
  }


  public void setContractEffectiveDate(LocalDate contractEffectiveDate) {
    
    
    
    this.contractEffectiveDate = contractEffectiveDate;
  }


  public POSTAccountTypeSubscription customerAcceptanceDate(LocalDate customerAcceptanceDate) {
    
    
    
    
    this.customerAcceptanceDate = customerAcceptanceDate;
    return this;
  }

   /**
   * The date on which the services or products within a subscription have been accepted by the customer, as &#x60;yyyy-mm-dd&#x60;.  Default value is dependent on the value of other fields. See Notes section for more details. 
   * @return customerAcceptanceDate
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The date on which the services or products within a subscription have been accepted by the customer, as `yyyy-mm-dd`.  Default value is dependent on the value of other fields. See Notes section for more details. ")

  public LocalDate getCustomerAcceptanceDate() {
    return customerAcceptanceDate;
  }


  public void setCustomerAcceptanceDate(LocalDate customerAcceptanceDate) {
    
    
    
    this.customerAcceptanceDate = customerAcceptanceDate;
  }


  public POSTAccountTypeSubscription initialTerm(Long initialTerm) {
    
    
    
    
    this.initialTerm = initialTerm;
    return this;
  }

   /**
   * Duration of the initial subscription term in whole months.  Default is 0.  
   * @return initialTerm
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Duration of the initial subscription term in whole months.  Default is 0.  ")

  public Long getInitialTerm() {
    return initialTerm;
  }


  public void setInitialTerm(Long initialTerm) {
    
    
    
    this.initialTerm = initialTerm;
  }


  public POSTAccountTypeSubscription invoiceOwnerAccountKey(String invoiceOwnerAccountKey) {
    
    
    
    
    this.invoiceOwnerAccountKey = invoiceOwnerAccountKey;
    return this;
  }

   /**
   * Invoice owner account number or ID.  **Note:** This feature is in Limited Availability. If you wish to have access to the feature, submit a request at [Zuora Global Support](https://support.zuora.com).  
   * @return invoiceOwnerAccountKey
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Invoice owner account number or ID.  **Note:** This feature is in Limited Availability. If you wish to have access to the feature, submit a request at [Zuora Global Support](https://support.zuora.com).  ")

  public String getInvoiceOwnerAccountKey() {
    return invoiceOwnerAccountKey;
  }


  public void setInvoiceOwnerAccountKey(String invoiceOwnerAccountKey) {
    
    
    
    this.invoiceOwnerAccountKey = invoiceOwnerAccountKey;
  }


  public POSTAccountTypeSubscription invoiceSeparately(Boolean invoiceSeparately) {
    
    
    
    
    this.invoiceSeparately = invoiceSeparately;
    return this;
  }

   /**
   * Separates a single subscription from other subscriptions and invoices the charge independently.   If the value is &#x60;true&#x60;, the subscription is billed separately from other subscriptions. If the value is &#x60;false&#x60;, the subscription is included with other subscriptions in the account invoice. The default value is &#x60;false&#x60;.  Prerequisite: The default subscription setting &#x60;Enable Subscriptions to be Invoiced Separately&#x60; must be set to &#x60;Yes&#x60;. 
   * @return invoiceSeparately
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Separates a single subscription from other subscriptions and invoices the charge independently.   If the value is `true`, the subscription is billed separately from other subscriptions. If the value is `false`, the subscription is included with other subscriptions in the account invoice. The default value is `false`.  Prerequisite: The default subscription setting `Enable Subscriptions to be Invoiced Separately` must be set to `Yes`. ")

  public Boolean getInvoiceSeparately() {
    return invoiceSeparately;
  }


  public void setInvoiceSeparately(Boolean invoiceSeparately) {
    
    
    
    this.invoiceSeparately = invoiceSeparately;
  }


  public POSTAccountTypeSubscription notes(String notes) {
    
    
    
    
    this.notes = notes;
    return this;
  }

   /**
   * 
   * @return notes
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public String getNotes() {
    return notes;
  }


  public void setNotes(String notes) {
    
    
    
    this.notes = notes;
  }


  public POSTAccountTypeSubscription renewalTerm(Long renewalTerm) {
    
    
    
    
    this.renewalTerm = renewalTerm;
    return this;
  }

   /**
   * Duration of the renewal term in whole months. Default is 0. 
   * @return renewalTerm
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Duration of the renewal term in whole months. Default is 0. ")

  public Long getRenewalTerm() {
    return renewalTerm;
  }


  public void setRenewalTerm(Long renewalTerm) {
    
    
    
    this.renewalTerm = renewalTerm;
  }


  public POSTAccountTypeSubscription serviceActivationDate(LocalDate serviceActivationDate) {
    
    
    
    
    this.serviceActivationDate = serviceActivationDate;
    return this;
  }

   /**
   * The date on which the services or products within a subscription have been activated and access has been provided to the customer, as &#x60;yyyy-mm-dd&#x60;.  Default value is dependent on the value of other fields. See Notes section for more details. 
   * @return serviceActivationDate
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The date on which the services or products within a subscription have been activated and access has been provided to the customer, as `yyyy-mm-dd`.  Default value is dependent on the value of other fields. See Notes section for more details. ")

  public LocalDate getServiceActivationDate() {
    return serviceActivationDate;
  }


  public void setServiceActivationDate(LocalDate serviceActivationDate) {
    
    
    
    this.serviceActivationDate = serviceActivationDate;
  }


  public POSTAccountTypeSubscription subscribeToRatePlans(List<POSTSrpCreateType> subscribeToRatePlans) {
    
    
    
    
    this.subscribeToRatePlans = subscribeToRatePlans;
    return this;
  }

  public POSTAccountTypeSubscription addSubscribeToRatePlansItem(POSTSrpCreateType subscribeToRatePlansItem) {
    if (this.subscribeToRatePlans == null) {
      this.subscribeToRatePlans = new ArrayList<>();
    }
    this.subscribeToRatePlans.add(subscribeToRatePlansItem);
    return this;
  }

   /**
   * Container for one or more rate plans for this subscription. 
   * @return subscribeToRatePlans
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Container for one or more rate plans for this subscription. ")

  public List<POSTSrpCreateType> getSubscribeToRatePlans() {
    return subscribeToRatePlans;
  }


  public void setSubscribeToRatePlans(List<POSTSrpCreateType> subscribeToRatePlans) {
    
    
    
    this.subscribeToRatePlans = subscribeToRatePlans;
  }


  public POSTAccountTypeSubscription subscriptionNumber(String subscriptionNumber) {
    
    
    
    
    this.subscriptionNumber = subscriptionNumber;
    return this;
  }

   /**
   * Subscription Number. The value can be up to 1000 characters.  If you do not specify a subscription number when creating a subscription for the new account, Zuora will generate a subscription number automatically.  If the account is created successfully, the subscription number is returned in the &#x60;subscriptionNumber&#x60; response field. 
   * @return subscriptionNumber
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Subscription Number. The value can be up to 1000 characters.  If you do not specify a subscription number when creating a subscription for the new account, Zuora will generate a subscription number automatically.  If the account is created successfully, the subscription number is returned in the `subscriptionNumber` response field. ")

  public String getSubscriptionNumber() {
    return subscriptionNumber;
  }


  public void setSubscriptionNumber(String subscriptionNumber) {
    
    
    
    this.subscriptionNumber = subscriptionNumber;
  }


  public POSTAccountTypeSubscription termStartDate(LocalDate termStartDate) {
    
    
    
    
    this.termStartDate = termStartDate;
    return this;
  }

   /**
   * The date on which the subscription term begins, as &#x60;yyyy-mm-dd&#x60;. If this is a renewal subscription, this date is different from the subscription start date. 
   * @return termStartDate
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The date on which the subscription term begins, as `yyyy-mm-dd`. If this is a renewal subscription, this date is different from the subscription start date. ")

  public LocalDate getTermStartDate() {
    return termStartDate;
  }


  public void setTermStartDate(LocalDate termStartDate) {
    
    
    
    this.termStartDate = termStartDate;
  }


  public POSTAccountTypeSubscription termType(String termType) {
    
    
    
    
    this.termType = termType;
    return this;
  }

   /**
   * Possible values are: &#x60;TERMED&#x60;, &#x60;EVERGREEN&#x60;. 
   * @return termType
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "Possible values are: `TERMED`, `EVERGREEN`. ")

  public String getTermType() {
    return termType;
  }


  public void setTermType(String termType) {
    
    
    
    this.termType = termType;
  }


  public POSTAccountTypeSubscription cpqBundleJsonIdQT(String cpqBundleJsonIdQT) {
    
    
    
    
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


  public POSTAccountTypeSubscription opportunityCloseDateQT(LocalDate opportunityCloseDateQT) {
    
    
    
    
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


  public POSTAccountTypeSubscription opportunityNameQT(String opportunityNameQT) {
    
    
    
    
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


  public POSTAccountTypeSubscription quoteBusinessTypeQT(String quoteBusinessTypeQT) {
    
    
    
    
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


  public POSTAccountTypeSubscription quoteNumberQT(String quoteNumberQT) {
    
    
    
    
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


  public POSTAccountTypeSubscription quoteTypeQT(String quoteTypeQT) {
    
    
    
    
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


  public POSTAccountTypeSubscription integrationIdNS(String integrationIdNS) {
    
    
    
    
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


  public POSTAccountTypeSubscription integrationStatusNS(String integrationStatusNS) {
    
    
    
    
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


  public POSTAccountTypeSubscription projectNS(String projectNS) {
    
    
    
    
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


  public POSTAccountTypeSubscription salesOrderNS(String salesOrderNS) {
    
    
    
    
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


  public POSTAccountTypeSubscription syncDateNS(String syncDateNS) {
    
    
    
    
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
   * @return the POSTAccountTypeSubscription instance itself
   */
  public POSTAccountTypeSubscription putAdditionalProperty(String key, Object value) {
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
    POSTAccountTypeSubscription poSTAccountTypeSubscription = (POSTAccountTypeSubscription) o;
    return Objects.equals(this.autoRenew, poSTAccountTypeSubscription.autoRenew) &&
        Objects.equals(this.contractEffectiveDate, poSTAccountTypeSubscription.contractEffectiveDate) &&
        Objects.equals(this.customerAcceptanceDate, poSTAccountTypeSubscription.customerAcceptanceDate) &&
        Objects.equals(this.initialTerm, poSTAccountTypeSubscription.initialTerm) &&
        Objects.equals(this.invoiceOwnerAccountKey, poSTAccountTypeSubscription.invoiceOwnerAccountKey) &&
        Objects.equals(this.invoiceSeparately, poSTAccountTypeSubscription.invoiceSeparately) &&
        Objects.equals(this.notes, poSTAccountTypeSubscription.notes) &&
        Objects.equals(this.renewalTerm, poSTAccountTypeSubscription.renewalTerm) &&
        Objects.equals(this.serviceActivationDate, poSTAccountTypeSubscription.serviceActivationDate) &&
        Objects.equals(this.subscribeToRatePlans, poSTAccountTypeSubscription.subscribeToRatePlans) &&
        Objects.equals(this.subscriptionNumber, poSTAccountTypeSubscription.subscriptionNumber) &&
        Objects.equals(this.termStartDate, poSTAccountTypeSubscription.termStartDate) &&
        Objects.equals(this.termType, poSTAccountTypeSubscription.termType) &&
        Objects.equals(this.cpqBundleJsonIdQT, poSTAccountTypeSubscription.cpqBundleJsonIdQT) &&
        Objects.equals(this.opportunityCloseDateQT, poSTAccountTypeSubscription.opportunityCloseDateQT) &&
        Objects.equals(this.opportunityNameQT, poSTAccountTypeSubscription.opportunityNameQT) &&
        Objects.equals(this.quoteBusinessTypeQT, poSTAccountTypeSubscription.quoteBusinessTypeQT) &&
        Objects.equals(this.quoteNumberQT, poSTAccountTypeSubscription.quoteNumberQT) &&
        Objects.equals(this.quoteTypeQT, poSTAccountTypeSubscription.quoteTypeQT) &&
        Objects.equals(this.integrationIdNS, poSTAccountTypeSubscription.integrationIdNS) &&
        Objects.equals(this.integrationStatusNS, poSTAccountTypeSubscription.integrationStatusNS) &&
        Objects.equals(this.projectNS, poSTAccountTypeSubscription.projectNS) &&
        Objects.equals(this.salesOrderNS, poSTAccountTypeSubscription.salesOrderNS) &&
        Objects.equals(this.syncDateNS, poSTAccountTypeSubscription.syncDateNS)&&
        Objects.equals(this.additionalProperties, poSTAccountTypeSubscription.additionalProperties);
  }

  @Override
  public int hashCode() {
    return Objects.hash(autoRenew, contractEffectiveDate, customerAcceptanceDate, initialTerm, invoiceOwnerAccountKey, invoiceSeparately, notes, renewalTerm, serviceActivationDate, subscribeToRatePlans, subscriptionNumber, termStartDate, termType, cpqBundleJsonIdQT, opportunityCloseDateQT, opportunityNameQT, quoteBusinessTypeQT, quoteNumberQT, quoteTypeQT, integrationIdNS, integrationStatusNS, projectNS, salesOrderNS, syncDateNS, additionalProperties);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class POSTAccountTypeSubscription {\n");
    sb.append("    autoRenew: ").append(toIndentedString(autoRenew)).append("\n");
    sb.append("    contractEffectiveDate: ").append(toIndentedString(contractEffectiveDate)).append("\n");
    sb.append("    customerAcceptanceDate: ").append(toIndentedString(customerAcceptanceDate)).append("\n");
    sb.append("    initialTerm: ").append(toIndentedString(initialTerm)).append("\n");
    sb.append("    invoiceOwnerAccountKey: ").append(toIndentedString(invoiceOwnerAccountKey)).append("\n");
    sb.append("    invoiceSeparately: ").append(toIndentedString(invoiceSeparately)).append("\n");
    sb.append("    notes: ").append(toIndentedString(notes)).append("\n");
    sb.append("    renewalTerm: ").append(toIndentedString(renewalTerm)).append("\n");
    sb.append("    serviceActivationDate: ").append(toIndentedString(serviceActivationDate)).append("\n");
    sb.append("    subscribeToRatePlans: ").append(toIndentedString(subscribeToRatePlans)).append("\n");
    sb.append("    subscriptionNumber: ").append(toIndentedString(subscriptionNumber)).append("\n");
    sb.append("    termStartDate: ").append(toIndentedString(termStartDate)).append("\n");
    sb.append("    termType: ").append(toIndentedString(termType)).append("\n");
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
    openapiFields.add("autoRenew");
    openapiFields.add("contractEffectiveDate");
    openapiFields.add("customerAcceptanceDate");
    openapiFields.add("initialTerm");
    openapiFields.add("invoiceOwnerAccountKey");
    openapiFields.add("invoiceSeparately");
    openapiFields.add("notes");
    openapiFields.add("renewalTerm");
    openapiFields.add("serviceActivationDate");
    openapiFields.add("subscribeToRatePlans");
    openapiFields.add("subscriptionNumber");
    openapiFields.add("termStartDate");
    openapiFields.add("termType");
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
    openapiRequiredFields.add("contractEffectiveDate");
    openapiRequiredFields.add("termType");
  }

 /**
  * Validates the JSON Object and throws an exception if issues found
  *
  * @param jsonObj JSON Object
  * @throws IOException if the JSON Object is invalid with respect to POSTAccountTypeSubscription
  */
  public static void validateJsonObject(JsonObject jsonObj) throws IOException {
      if (jsonObj == null) {
        if (!POSTAccountTypeSubscription.openapiRequiredFields.isEmpty()) { // has required fields but JSON object is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in POSTAccountTypeSubscription is not found in the empty JSON string", POSTAccountTypeSubscription.openapiRequiredFields.toString()));
        }
      }

      // check to make sure all required properties/fields are present in the JSON string
      for (String requiredField : POSTAccountTypeSubscription.openapiRequiredFields) {
        if (jsonObj.get(requiredField) == null) {
          throw new IllegalArgumentException(String.format("The required field `%s` is not found in the JSON string: %s", requiredField, jsonObj.toString()));
        }
      }
      if ((jsonObj.get("invoiceOwnerAccountKey") != null && !jsonObj.get("invoiceOwnerAccountKey").isJsonNull()) && !jsonObj.get("invoiceOwnerAccountKey").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `invoiceOwnerAccountKey` to be a primitive type in the JSON string but got `%s`", jsonObj.get("invoiceOwnerAccountKey").toString()));
      }
      if ((jsonObj.get("notes") != null && !jsonObj.get("notes").isJsonNull()) && !jsonObj.get("notes").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `notes` to be a primitive type in the JSON string but got `%s`", jsonObj.get("notes").toString()));
      }
      if (jsonObj.get("subscribeToRatePlans") != null && !jsonObj.get("subscribeToRatePlans").isJsonNull()) {
        JsonArray jsonArraysubscribeToRatePlans = jsonObj.getAsJsonArray("subscribeToRatePlans");
        if (jsonArraysubscribeToRatePlans != null) {
          // ensure the json data is an array
          if (!jsonObj.get("subscribeToRatePlans").isJsonArray()) {
            throw new IllegalArgumentException(String.format("Expected the field `subscribeToRatePlans` to be an array in the JSON string but got `%s`", jsonObj.get("subscribeToRatePlans").toString()));
          }

          // validate the optional field `subscribeToRatePlans` (array)
          for (int i = 0; i < jsonArraysubscribeToRatePlans.size(); i++) {
            POSTSrpCreateType.validateJsonObject(jsonArraysubscribeToRatePlans.get(i).getAsJsonObject());
          };
        }
      }
      if ((jsonObj.get("subscriptionNumber") != null && !jsonObj.get("subscriptionNumber").isJsonNull()) && !jsonObj.get("subscriptionNumber").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `subscriptionNumber` to be a primitive type in the JSON string but got `%s`", jsonObj.get("subscriptionNumber").toString()));
      }
      if (!jsonObj.get("termType").isJsonPrimitive()) {
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
       if (!POSTAccountTypeSubscription.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'POSTAccountTypeSubscription' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<POSTAccountTypeSubscription> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(POSTAccountTypeSubscription.class));

       return (TypeAdapter<T>) new TypeAdapter<POSTAccountTypeSubscription>() {
           @Override
           public void write(JsonWriter out, POSTAccountTypeSubscription value) throws IOException {
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
           public POSTAccountTypeSubscription read(JsonReader in) throws IOException {
             JsonObject jsonObj = elementAdapter.read(in).getAsJsonObject();
             validateJsonObject(jsonObj);
             // store additional fields in the deserialized instance
             POSTAccountTypeSubscription instance = thisAdapter.fromJsonTree(jsonObj);
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
  * Create an instance of POSTAccountTypeSubscription given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of POSTAccountTypeSubscription
  * @throws IOException if the JSON string is invalid with respect to POSTAccountTypeSubscription
  */
  public static POSTAccountTypeSubscription fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, POSTAccountTypeSubscription.class);
  }

 /**
  * Convert an instance of POSTAccountTypeSubscription to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

