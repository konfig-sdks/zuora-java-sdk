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
import com.konfigthis.client.model.POSTPublicNotificationDefinitionRequestFilterRule;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
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
 * POSTPublicNotificationDefinitionRequest
 */@javax.annotation.Generated(value = "Generated by https://konfigthis.com")
public class POSTPublicNotificationDefinitionRequest {
  public static final String SERIALIZED_NAME_DESCRIPTION = "description";
  @SerializedName(SERIALIZED_NAME_DESCRIPTION)
  private String description;

  public static final String SERIALIZED_NAME_ACTIVE = "active";
  @SerializedName(SERIALIZED_NAME_ACTIVE)
  private Boolean active = true;

  public static final String SERIALIZED_NAME_ASSOCIATED_ACCOUNT = "associatedAccount";
  @SerializedName(SERIALIZED_NAME_ASSOCIATED_ACCOUNT)
  private String associatedAccount;

  public static final String SERIALIZED_NAME_CALLOUT = "callout";
  @SerializedName(SERIALIZED_NAME_CALLOUT)
  private Object callout = null;

  public static final String SERIALIZED_NAME_CALLOUT_ACTIVE = "calloutActive";
  @SerializedName(SERIALIZED_NAME_CALLOUT_ACTIVE)
  private Boolean calloutActive = false;

  public static final String SERIALIZED_NAME_COMMUNICATION_PROFILE_ID = "communicationProfileId";
  @SerializedName(SERIALIZED_NAME_COMMUNICATION_PROFILE_ID)
  private String communicationProfileId;

  public static final String SERIALIZED_NAME_EMAIL_ACTIVE = "emailActive";
  @SerializedName(SERIALIZED_NAME_EMAIL_ACTIVE)
  private Boolean emailActive = false;

  public static final String SERIALIZED_NAME_EMAIL_TEMPLATE_ID = "emailTemplateId";
  @SerializedName(SERIALIZED_NAME_EMAIL_TEMPLATE_ID)
  private UUID emailTemplateId;

  public static final String SERIALIZED_NAME_EVENT_CATEGORY = "eventCategory";
  @SerializedName(SERIALIZED_NAME_EVENT_CATEGORY)
  private Double eventCategory;

  public static final String SERIALIZED_NAME_EVENT_TYPE_NAME = "eventTypeName";
  @SerializedName(SERIALIZED_NAME_EVENT_TYPE_NAME)
  private String eventTypeName;

  /**
   * The namespace of the &#x60;eventTypeName&#x60; field. It indicates who created the event and which namespace the event is assigned to.  Supported values are as follows:  - &#x60;com.zuora.notification&#x60;: events that are created by Zuora. This value applies to Zuora custom events. - &#x60;user.notification&#x60;: events that are created by tenant users. This value applies to custom events and custom scheduled events. This is the default value.             For example, if you want to create a notification definition on the &#x60;OrderActionProcessed&#x60; event, which is a Zuora custom event, you must specify &#x60;com.zuora.notification&#x60; for this field. 
   */
  @JsonAdapter(EventTypeNamespaceEnum.Adapter.class)
 public enum EventTypeNamespaceEnum {
    USER_NOTIFICATION("user.notification"),
    
    COM_ZUORA_NOTIFICATION("com.zuora.notification");

    private String value;

    EventTypeNamespaceEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static EventTypeNamespaceEnum fromValue(String value) {
      for (EventTypeNamespaceEnum b : EventTypeNamespaceEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<EventTypeNamespaceEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final EventTypeNamespaceEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public EventTypeNamespaceEnum read(final JsonReader jsonReader) throws IOException {
        String value =  jsonReader.nextString();
        return EventTypeNamespaceEnum.fromValue(value);
      }
    }
  }

  public static final String SERIALIZED_NAME_EVENT_TYPE_NAMESPACE = "eventTypeNamespace";
  @SerializedName(SERIALIZED_NAME_EVENT_TYPE_NAMESPACE)
  private EventTypeNamespaceEnum eventTypeNamespace = EventTypeNamespaceEnum.USER_NOTIFICATION;

  public static final String SERIALIZED_NAME_FILTER_RULE = "filterRule";
  @SerializedName(SERIALIZED_NAME_FILTER_RULE)
  private POSTPublicNotificationDefinitionRequestFilterRule filterRule;

  public static final String SERIALIZED_NAME_FILTER_RULE_PARAMS = "filterRuleParams";
  @SerializedName(SERIALIZED_NAME_FILTER_RULE_PARAMS)
  private Map<String, String> filterRuleParams = null;

  public static final String SERIALIZED_NAME_NAME = "name";
  @SerializedName(SERIALIZED_NAME_NAME)
  private String name;

  public POSTPublicNotificationDefinitionRequest() {
  }

  public POSTPublicNotificationDefinitionRequest description(String description) {
    
    
    
    
    this.description = description;
    return this;
  }

   /**
   * The description of the notification definition.
   * @return description
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "Notification sent out when an account is edited", value = "The description of the notification definition.")

  public String getDescription() {
    return description;
  }


  public void setDescription(String description) {
    
    
    
    this.description = description;
  }


  public POSTPublicNotificationDefinitionRequest active(Boolean active) {
    
    
    
    
    this.active = active;
    return this;
  }

   /**
   * The status of the notification definition. The default value is &#x60;true&#x60;.
   * @return active
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "true", value = "The status of the notification definition. The default value is `true`.")

  public Boolean getActive() {
    return active;
  }


  public void setActive(Boolean active) {
    
    
    
    this.active = active;
  }


  public POSTPublicNotificationDefinitionRequest associatedAccount(String associatedAccount) {
    
    
    
    
    this.associatedAccount = associatedAccount;
    return this;
  }

   /**
   * The account on which the histories of this notification will be displayed. The associated account does not enforce where the merge fields come from. Available values are as follows: * &#x60;Account.Id&#x60;: ID of the primary customer account related to the notification. It is also the default value. * &#x60;ParentAccount.Id&#x60;: this option is available only if you have &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Billing/Subscriptions/Customer_Accounts/A_Customer_Account_Introduction#Customer_Hierarchy\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Customer Hierarchy&lt;/a&gt; enabled for your tenant. * &#x60;SubscriptionOwnerAccount.Id&#x60;: this option is available if the base object of the notification is Order Action.  **Note:** before specifying this field, we recommend that you use [Data Source](https://knowledgecenter.zuora.com/Billing/Reporting/D_Data_Sources_and_Exports/C_Data_Source_Reference) to check the available types of accounts for the current notification.   
   * @return associatedAccount
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "ParentAccount.Id", value = "The account on which the histories of this notification will be displayed. The associated account does not enforce where the merge fields come from. Available values are as follows: * `Account.Id`: ID of the primary customer account related to the notification. It is also the default value. * `ParentAccount.Id`: this option is available only if you have <a href=\"https://knowledgecenter.zuora.com/Billing/Subscriptions/Customer_Accounts/A_Customer_Account_Introduction#Customer_Hierarchy\" target=\"_blank\">Customer Hierarchy</a> enabled for your tenant. * `SubscriptionOwnerAccount.Id`: this option is available if the base object of the notification is Order Action.  **Note:** before specifying this field, we recommend that you use [Data Source](https://knowledgecenter.zuora.com/Billing/Reporting/D_Data_Sources_and_Exports/C_Data_Source_Reference) to check the available types of accounts for the current notification.   ")

  public String getAssociatedAccount() {
    return associatedAccount;
  }


  public void setAssociatedAccount(String associatedAccount) {
    
    
    
    this.associatedAccount = associatedAccount;
  }


  public POSTPublicNotificationDefinitionRequest callout(Object callout) {
    
    
    
    
    this.callout = callout;
    return this;
  }

   /**
   * Get callout
   * @return callout
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public Object getCallout() {
    return callout;
  }


  public void setCallout(Object callout) {
    
    
    
    this.callout = callout;
  }


  public POSTPublicNotificationDefinitionRequest calloutActive(Boolean calloutActive) {
    
    
    
    
    this.calloutActive = calloutActive;
    return this;
  }

   /**
   * The status of the callout action. The default value is &#x60;false&#x60;.
   * @return calloutActive
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "false", value = "The status of the callout action. The default value is `false`.")

  public Boolean getCalloutActive() {
    return calloutActive;
  }


  public void setCalloutActive(Boolean calloutActive) {
    
    
    
    this.calloutActive = calloutActive;
  }


  public POSTPublicNotificationDefinitionRequest communicationProfileId(String communicationProfileId) {
    
    
    
    
    this.communicationProfileId = communicationProfileId;
    return this;
  }

   /**
   * The profile that notification definition belongs to.   You can use the [Query Action](https://developer.zuora.com/api-references/api/operation/Action_POSTquery) to get the communication profile Id. See the following request sample:  &#x60;{     \&quot;queryString\&quot;: \&quot;select Id, ProfileName from CommunicationProfile\&quot;  }&#x60;  If you do not pass the communicationProfileId, notification service will be automatically added to the &#39;Default Profile&#39;. 
   * @return communicationProfileId
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "6e569e1e05f040eda51a927b140c0ac5", value = "The profile that notification definition belongs to.   You can use the [Query Action](https://developer.zuora.com/api-references/api/operation/Action_POSTquery) to get the communication profile Id. See the following request sample:  `{     \"queryString\": \"select Id, ProfileName from CommunicationProfile\"  }`  If you do not pass the communicationProfileId, notification service will be automatically added to the 'Default Profile'. ")

  public String getCommunicationProfileId() {
    return communicationProfileId;
  }


  public void setCommunicationProfileId(String communicationProfileId) {
    
    
    
    this.communicationProfileId = communicationProfileId;
  }


  public POSTPublicNotificationDefinitionRequest emailActive(Boolean emailActive) {
    
    
    
    
    this.emailActive = emailActive;
    return this;
  }

   /**
   * The status of the email action. The default value is &#x60;false&#x60;.
   * @return emailActive
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "false", value = "The status of the email action. The default value is `false`.")

  public Boolean getEmailActive() {
    return emailActive;
  }


  public void setEmailActive(Boolean emailActive) {
    
    
    
    this.emailActive = emailActive;
  }


  public POSTPublicNotificationDefinitionRequest emailTemplateId(UUID emailTemplateId) {
    
    
    
    
    this.emailTemplateId = emailTemplateId;
    return this;
  }

   /**
   * The ID of the email template. If &#x60;emailActive&#x60; is &#x60;true&#x60;, an email template is required. And EventType of the email template MUST be the same as the eventType.
   * @return emailTemplateId
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The ID of the email template. If `emailActive` is `true`, an email template is required. And EventType of the email template MUST be the same as the eventType.")

  public UUID getEmailTemplateId() {
    return emailTemplateId;
  }


  public void setEmailTemplateId(UUID emailTemplateId) {
    
    
    
    this.emailTemplateId = emailTemplateId;
  }


  public POSTPublicNotificationDefinitionRequest eventCategory(Double eventCategory) {
    
    
    
    
    this.eventCategory = eventCategory;
    return this;
  }

  public POSTPublicNotificationDefinitionRequest eventCategory(Integer eventCategory) {
    
    
    
    
    this.eventCategory = eventCategory.doubleValue();
    return this;
  }

   /**
   * The event category code for a standard event, on which the notification definition is created.  This field is required when creating notification definitions for standard events.  For the list of supported standard event category codes, see &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Central_Platform/Events_and_Notifications/A_Standard_Events/Standard_Event_Category_Code_for_Events_and_Notifications\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Standard event category code for events and notifications&lt;/a&gt;. 
   * @return eventCategory
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The event category code for a standard event, on which the notification definition is created.  This field is required when creating notification definitions for standard events.  For the list of supported standard event category codes, see <a href=\"https://knowledgecenter.zuora.com/Zuora_Central_Platform/Events_and_Notifications/A_Standard_Events/Standard_Event_Category_Code_for_Events_and_Notifications\" target=\"_blank\">Standard event category code for events and notifications</a>. ")

  public Double getEventCategory() {
    return eventCategory;
  }


  public void setEventCategory(Double eventCategory) {
    
    
    
    this.eventCategory = eventCategory;
  }


  public POSTPublicNotificationDefinitionRequest eventTypeName(String eventTypeName) {
    
    
    if (eventTypeName != null && eventTypeName.length() < 1) {
      throw new IllegalArgumentException("Invalid value for eventTypeName. Length must be greater than or equal to 1.");
    }
    
    this.eventTypeName = eventTypeName;
    return this;
  }

   /**
   * The name of the event that the notification definition is based on.  This field is required when creating notification definitions for Zuora custom events, custom events, or custom scheduled events.  If this field is provided, you can specify the event namespace in the &#x60;eventTypeNamespace&#x60; field.  
   * @return eventTypeName
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "AccountEdit", value = "The name of the event that the notification definition is based on.  This field is required when creating notification definitions for Zuora custom events, custom events, or custom scheduled events.  If this field is provided, you can specify the event namespace in the `eventTypeNamespace` field.  ")

  public String getEventTypeName() {
    return eventTypeName;
  }


  public void setEventTypeName(String eventTypeName) {
    
    
    if (eventTypeName != null && eventTypeName.length() < 1) {
      throw new IllegalArgumentException("Invalid value for eventTypeName. Length must be greater than or equal to 1.");
    }
    this.eventTypeName = eventTypeName;
  }


  public POSTPublicNotificationDefinitionRequest eventTypeNamespace(EventTypeNamespaceEnum eventTypeNamespace) {
    
    
    
    
    this.eventTypeNamespace = eventTypeNamespace;
    return this;
  }

   /**
   * The namespace of the &#x60;eventTypeName&#x60; field. It indicates who created the event and which namespace the event is assigned to.  Supported values are as follows:  - &#x60;com.zuora.notification&#x60;: events that are created by Zuora. This value applies to Zuora custom events. - &#x60;user.notification&#x60;: events that are created by tenant users. This value applies to custom events and custom scheduled events. This is the default value.             For example, if you want to create a notification definition on the &#x60;OrderActionProcessed&#x60; event, which is a Zuora custom event, you must specify &#x60;com.zuora.notification&#x60; for this field. 
   * @return eventTypeNamespace
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "USER_NOTIFICATION", value = "The namespace of the `eventTypeName` field. It indicates who created the event and which namespace the event is assigned to.  Supported values are as follows:  - `com.zuora.notification`: events that are created by Zuora. This value applies to Zuora custom events. - `user.notification`: events that are created by tenant users. This value applies to custom events and custom scheduled events. This is the default value.             For example, if you want to create a notification definition on the `OrderActionProcessed` event, which is a Zuora custom event, you must specify `com.zuora.notification` for this field. ")

  public EventTypeNamespaceEnum getEventTypeNamespace() {
    return eventTypeNamespace;
  }


  public void setEventTypeNamespace(EventTypeNamespaceEnum eventTypeNamespace) {
    
    
    
    this.eventTypeNamespace = eventTypeNamespace;
  }


  public POSTPublicNotificationDefinitionRequest filterRule(POSTPublicNotificationDefinitionRequestFilterRule filterRule) {
    
    
    
    
    this.filterRule = filterRule;
    return this;
  }

   /**
   * Get filterRule
   * @return filterRule
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public POSTPublicNotificationDefinitionRequestFilterRule getFilterRule() {
    return filterRule;
  }


  public void setFilterRule(POSTPublicNotificationDefinitionRequestFilterRule filterRule) {
    
    
    
    this.filterRule = filterRule;
  }


  public POSTPublicNotificationDefinitionRequest filterRuleParams(Map<String, String> filterRuleParams) {
    
    
    
    
    this.filterRuleParams = filterRuleParams;
    return this;
  }

  public POSTPublicNotificationDefinitionRequest putFilterRuleParamsItem(String key, String filterRuleParamsItem) {
    if (this.filterRuleParams == null) {
      this.filterRuleParams = new HashMap<>();
    }
    this.filterRuleParams.put(key, filterRuleParamsItem);
    return this;
  }

   /**
   * The parameter values used to configure the filter rule. 
   * @return filterRuleParams
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The parameter values used to configure the filter rule. ")

  public Map<String, String> getFilterRuleParams() {
    return filterRuleParams;
  }


  public void setFilterRuleParams(Map<String, String> filterRuleParams) {
    
    
    
    this.filterRuleParams = filterRuleParams;
  }


  public POSTPublicNotificationDefinitionRequest name(String name) {
    
    
    
    
    this.name = name;
    return this;
  }

   /**
   * The name of the notification definition, unique per communication profile.
   * @return name
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(example = "Account Edit Notification", required = true, value = "The name of the notification definition, unique per communication profile.")

  public String getName() {
    return name;
  }


  public void setName(String name) {
    
    
    
    this.name = name;
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
   * @return the POSTPublicNotificationDefinitionRequest instance itself
   */
  public POSTPublicNotificationDefinitionRequest putAdditionalProperty(String key, Object value) {
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
    POSTPublicNotificationDefinitionRequest poSTPublicNotificationDefinitionRequest = (POSTPublicNotificationDefinitionRequest) o;
    return Objects.equals(this.description, poSTPublicNotificationDefinitionRequest.description) &&
        Objects.equals(this.active, poSTPublicNotificationDefinitionRequest.active) &&
        Objects.equals(this.associatedAccount, poSTPublicNotificationDefinitionRequest.associatedAccount) &&
        Objects.equals(this.callout, poSTPublicNotificationDefinitionRequest.callout) &&
        Objects.equals(this.calloutActive, poSTPublicNotificationDefinitionRequest.calloutActive) &&
        Objects.equals(this.communicationProfileId, poSTPublicNotificationDefinitionRequest.communicationProfileId) &&
        Objects.equals(this.emailActive, poSTPublicNotificationDefinitionRequest.emailActive) &&
        Objects.equals(this.emailTemplateId, poSTPublicNotificationDefinitionRequest.emailTemplateId) &&
        Objects.equals(this.eventCategory, poSTPublicNotificationDefinitionRequest.eventCategory) &&
        Objects.equals(this.eventTypeName, poSTPublicNotificationDefinitionRequest.eventTypeName) &&
        Objects.equals(this.eventTypeNamespace, poSTPublicNotificationDefinitionRequest.eventTypeNamespace) &&
        Objects.equals(this.filterRule, poSTPublicNotificationDefinitionRequest.filterRule) &&
        Objects.equals(this.filterRuleParams, poSTPublicNotificationDefinitionRequest.filterRuleParams) &&
        Objects.equals(this.name, poSTPublicNotificationDefinitionRequest.name)&&
        Objects.equals(this.additionalProperties, poSTPublicNotificationDefinitionRequest.additionalProperties);
  }

  private static <T> boolean equalsNullable(JsonNullable<T> a, JsonNullable<T> b) {
    return a == b || (a != null && b != null && a.isPresent() && b.isPresent() && Objects.deepEquals(a.get(), b.get()));
  }

  @Override
  public int hashCode() {
    return Objects.hash(description, active, associatedAccount, callout, calloutActive, communicationProfileId, emailActive, emailTemplateId, eventCategory, eventTypeName, eventTypeNamespace, filterRule, filterRuleParams, name, additionalProperties);
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
    sb.append("class POSTPublicNotificationDefinitionRequest {\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    active: ").append(toIndentedString(active)).append("\n");
    sb.append("    associatedAccount: ").append(toIndentedString(associatedAccount)).append("\n");
    sb.append("    callout: ").append(toIndentedString(callout)).append("\n");
    sb.append("    calloutActive: ").append(toIndentedString(calloutActive)).append("\n");
    sb.append("    communicationProfileId: ").append(toIndentedString(communicationProfileId)).append("\n");
    sb.append("    emailActive: ").append(toIndentedString(emailActive)).append("\n");
    sb.append("    emailTemplateId: ").append(toIndentedString(emailTemplateId)).append("\n");
    sb.append("    eventCategory: ").append(toIndentedString(eventCategory)).append("\n");
    sb.append("    eventTypeName: ").append(toIndentedString(eventTypeName)).append("\n");
    sb.append("    eventTypeNamespace: ").append(toIndentedString(eventTypeNamespace)).append("\n");
    sb.append("    filterRule: ").append(toIndentedString(filterRule)).append("\n");
    sb.append("    filterRuleParams: ").append(toIndentedString(filterRuleParams)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
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
    openapiFields.add("active");
    openapiFields.add("associatedAccount");
    openapiFields.add("callout");
    openapiFields.add("calloutActive");
    openapiFields.add("communicationProfileId");
    openapiFields.add("emailActive");
    openapiFields.add("emailTemplateId");
    openapiFields.add("eventCategory");
    openapiFields.add("eventTypeName");
    openapiFields.add("eventTypeNamespace");
    openapiFields.add("filterRule");
    openapiFields.add("filterRuleParams");
    openapiFields.add("name");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
    openapiRequiredFields.add("name");
  }

 /**
  * Validates the JSON Object and throws an exception if issues found
  *
  * @param jsonObj JSON Object
  * @throws IOException if the JSON Object is invalid with respect to POSTPublicNotificationDefinitionRequest
  */
  public static void validateJsonObject(JsonObject jsonObj) throws IOException {
      if (jsonObj == null) {
        if (!POSTPublicNotificationDefinitionRequest.openapiRequiredFields.isEmpty()) { // has required fields but JSON object is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in POSTPublicNotificationDefinitionRequest is not found in the empty JSON string", POSTPublicNotificationDefinitionRequest.openapiRequiredFields.toString()));
        }
      }

      // check to make sure all required properties/fields are present in the JSON string
      for (String requiredField : POSTPublicNotificationDefinitionRequest.openapiRequiredFields) {
        if (jsonObj.get(requiredField) == null) {
          throw new IllegalArgumentException(String.format("The required field `%s` is not found in the JSON string: %s", requiredField, jsonObj.toString()));
        }
      }
      if ((jsonObj.get("description") != null && !jsonObj.get("description").isJsonNull()) && !jsonObj.get("description").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `description` to be a primitive type in the JSON string but got `%s`", jsonObj.get("description").toString()));
      }
      if ((jsonObj.get("associatedAccount") != null && !jsonObj.get("associatedAccount").isJsonNull()) && !jsonObj.get("associatedAccount").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `associatedAccount` to be a primitive type in the JSON string but got `%s`", jsonObj.get("associatedAccount").toString()));
      }
      if ((jsonObj.get("communicationProfileId") != null && !jsonObj.get("communicationProfileId").isJsonNull()) && !jsonObj.get("communicationProfileId").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `communicationProfileId` to be a primitive type in the JSON string but got `%s`", jsonObj.get("communicationProfileId").toString()));
      }
      if ((jsonObj.get("emailTemplateId") != null && !jsonObj.get("emailTemplateId").isJsonNull()) && !jsonObj.get("emailTemplateId").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `emailTemplateId` to be a primitive type in the JSON string but got `%s`", jsonObj.get("emailTemplateId").toString()));
      }
      if ((jsonObj.get("eventTypeName") != null && !jsonObj.get("eventTypeName").isJsonNull()) && !jsonObj.get("eventTypeName").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `eventTypeName` to be a primitive type in the JSON string but got `%s`", jsonObj.get("eventTypeName").toString()));
      }
      if ((jsonObj.get("eventTypeNamespace") != null && !jsonObj.get("eventTypeNamespace").isJsonNull()) && !jsonObj.get("eventTypeNamespace").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `eventTypeNamespace` to be a primitive type in the JSON string but got `%s`", jsonObj.get("eventTypeNamespace").toString()));
      }
      // validate the optional field `filterRule`
      if (jsonObj.get("filterRule") != null && !jsonObj.get("filterRule").isJsonNull()) {
        POSTPublicNotificationDefinitionRequestFilterRule.validateJsonObject(jsonObj.getAsJsonObject("filterRule"));
      }
      if (!jsonObj.get("name").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `name` to be a primitive type in the JSON string but got `%s`", jsonObj.get("name").toString()));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!POSTPublicNotificationDefinitionRequest.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'POSTPublicNotificationDefinitionRequest' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<POSTPublicNotificationDefinitionRequest> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(POSTPublicNotificationDefinitionRequest.class));

       return (TypeAdapter<T>) new TypeAdapter<POSTPublicNotificationDefinitionRequest>() {
           @Override
           public void write(JsonWriter out, POSTPublicNotificationDefinitionRequest value) throws IOException {
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
           public POSTPublicNotificationDefinitionRequest read(JsonReader in) throws IOException {
             JsonObject jsonObj = elementAdapter.read(in).getAsJsonObject();
             validateJsonObject(jsonObj);
             // store additional fields in the deserialized instance
             POSTPublicNotificationDefinitionRequest instance = thisAdapter.fromJsonTree(jsonObj);
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
  * Create an instance of POSTPublicNotificationDefinitionRequest given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of POSTPublicNotificationDefinitionRequest
  * @throws IOException if the JSON string is invalid with respect to POSTPublicNotificationDefinitionRequest
  */
  public static POSTPublicNotificationDefinitionRequest fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, POSTPublicNotificationDefinitionRequest.class);
  }

 /**
  * Convert an instance of POSTPublicNotificationDefinitionRequest to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

