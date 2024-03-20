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
 * POSTRSASignatureType
 */@javax.annotation.Generated(value = "Generated by https://konfigthis.com")
public class POSTRSASignatureType {
  public static final String SERIALIZED_NAME_I_B_A_N = "IBAN";
  @SerializedName(SERIALIZED_NAME_I_B_A_N)
  private String IBAN;

  public static final String SERIALIZED_NAME_ACCOUNT_ID = "accountId";
  @SerializedName(SERIALIZED_NAME_ACCOUNT_ID)
  private String accountId;

  public static final String SERIALIZED_NAME_AUTHORIZATION_AMOUNT = "authorizationAmount";
  @SerializedName(SERIALIZED_NAME_AUTHORIZATION_AMOUNT)
  private Double authorizationAmount;

  public static final String SERIALIZED_NAME_BANK_BRANCH_CODE = "bankBranchCode";
  @SerializedName(SERIALIZED_NAME_BANK_BRANCH_CODE)
  private String bankBranchCode;

  public static final String SERIALIZED_NAME_BANK_CHECK_DIGIT = "bankCheckDigit";
  @SerializedName(SERIALIZED_NAME_BANK_CHECK_DIGIT)
  private String bankCheckDigit;

  public static final String SERIALIZED_NAME_BANK_CITY = "bankCity";
  @SerializedName(SERIALIZED_NAME_BANK_CITY)
  private String bankCity;

  public static final String SERIALIZED_NAME_BANK_POSTAL_CODE = "bankPostalCode";
  @SerializedName(SERIALIZED_NAME_BANK_POSTAL_CODE)
  private String bankPostalCode;

  public static final String SERIALIZED_NAME_BANK_STREET_NAME = "bankStreetName";
  @SerializedName(SERIALIZED_NAME_BANK_STREET_NAME)
  private String bankStreetName;

  public static final String SERIALIZED_NAME_BANK_STREET_NUMBER = "bankStreetNumber";
  @SerializedName(SERIALIZED_NAME_BANK_STREET_NUMBER)
  private String bankStreetNumber;

  public static final String SERIALIZED_NAME_BUSINESS_IDENTIFICATION_CODE = "businessIdentificationCode";
  @SerializedName(SERIALIZED_NAME_BUSINESS_IDENTIFICATION_CODE)
  private String businessIdentificationCode;

  public static final String SERIALIZED_NAME_CITY_BLACK_LIST = "cityBlackList";
  @SerializedName(SERIALIZED_NAME_CITY_BLACK_LIST)
  private String cityBlackList;

  public static final String SERIALIZED_NAME_CITY_WHITE_LIST = "cityWhiteList";
  @SerializedName(SERIALIZED_NAME_CITY_WHITE_LIST)
  private String cityWhiteList;

  public static final String SERIALIZED_NAME_CURRENCY = "currency";
  @SerializedName(SERIALIZED_NAME_CURRENCY)
  private String currency;

  public static final String SERIALIZED_NAME_DEVICE_SESSION_ID = "deviceSessionId";
  @SerializedName(SERIALIZED_NAME_DEVICE_SESSION_ID)
  private String deviceSessionId;

  public static final String SERIALIZED_NAME_GATEWAY_NAME = "gatewayName";
  @SerializedName(SERIALIZED_NAME_GATEWAY_NAME)
  private String gatewayName;

  public static final String SERIALIZED_NAME_ID = "id";
  @SerializedName(SERIALIZED_NAME_ID)
  private String id;

  public static final String SERIALIZED_NAME_KEY = "key";
  @SerializedName(SERIALIZED_NAME_KEY)
  private String key;

  public static final String SERIALIZED_NAME_LOCALE = "locale";
  @SerializedName(SERIALIZED_NAME_LOCALE)
  private String locale;

  public static final String SERIALIZED_NAME_MAX_CONSECUTIVE_PAYMENT_FAILURES = "maxConsecutivePaymentFailures";
  @SerializedName(SERIALIZED_NAME_MAX_CONSECUTIVE_PAYMENT_FAILURES)
  private Integer maxConsecutivePaymentFailures;

  public static final String SERIALIZED_NAME_METHOD = "method";
  @SerializedName(SERIALIZED_NAME_METHOD)
  private String method;

  public static final String SERIALIZED_NAME_PAGE_ID = "pageId";
  @SerializedName(SERIALIZED_NAME_PAGE_ID)
  private String pageId;

  public static final String SERIALIZED_NAME_PARAM_GW_OPTIONS_STAR_OPTION_STAR = "param_gwOptions_[*option*]";
  @SerializedName(SERIALIZED_NAME_PARAM_GW_OPTIONS_STAR_OPTION_STAR)
  private String paramGwOptionsStarOptionStar;

  public static final String SERIALIZED_NAME_PARAM_SUPPORTED_TYPES = "param_supportedTypes";
  @SerializedName(SERIALIZED_NAME_PARAM_SUPPORTED_TYPES)
  private String paramSupportedTypes;

  public static final String SERIALIZED_NAME_PASSTHROUGH1_COMMA2_COMMA3_COMMA4_COMMA5 = "passthrough[1,2,3,4,5]";
  @SerializedName(SERIALIZED_NAME_PASSTHROUGH1_COMMA2_COMMA3_COMMA4_COMMA5)
  private String passthrough1Comma2Comma3Comma4Comma5;

  public static final String SERIALIZED_NAME_PAYMENT_GATEWAY = "paymentGateway";
  @SerializedName(SERIALIZED_NAME_PAYMENT_GATEWAY)
  private String paymentGateway;

  public static final String SERIALIZED_NAME_PAYMENT_RETRY_WINDOW = "paymentRetryWindow";
  @SerializedName(SERIALIZED_NAME_PAYMENT_RETRY_WINDOW)
  private Integer paymentRetryWindow;

  public static final String SERIALIZED_NAME_PM_ID = "pmId";
  @SerializedName(SERIALIZED_NAME_PM_ID)
  private String pmId;

  public static final String SERIALIZED_NAME_SIGNATURE = "signature";
  @SerializedName(SERIALIZED_NAME_SIGNATURE)
  private String signature;

  public static final String SERIALIZED_NAME_SIGNATURE_TYPE = "signatureType";
  @SerializedName(SERIALIZED_NAME_SIGNATURE_TYPE)
  private String signatureType;

  public static final String SERIALIZED_NAME_STYLE = "style";
  @SerializedName(SERIALIZED_NAME_STYLE)
  private String style;

  public static final String SERIALIZED_NAME_SUBMIT_ENABLED = "submitEnabled";
  @SerializedName(SERIALIZED_NAME_SUBMIT_ENABLED)
  private Boolean submitEnabled;

  public static final String SERIALIZED_NAME_TENANT_ID = "tenantId";
  @SerializedName(SERIALIZED_NAME_TENANT_ID)
  private String tenantId;

  public static final String SERIALIZED_NAME_TOKEN = "token";
  @SerializedName(SERIALIZED_NAME_TOKEN)
  private String token;

  public static final String SERIALIZED_NAME_URI = "uri";
  @SerializedName(SERIALIZED_NAME_URI)
  private String uri;

  public static final String SERIALIZED_NAME_USE_DEFAULT_RETRY_RULE = "useDefaultRetryRule";
  @SerializedName(SERIALIZED_NAME_USE_DEFAULT_RETRY_RULE)
  private Boolean useDefaultRetryRule;

  public POSTRSASignatureType() {
  }

  public POSTRSASignatureType IBAN(String IBAN) {
    
    
    
    
    this.IBAN = IBAN;
    return this;
  }

   /**
   * An optional client parameter that can be used for validating client-side HPM parameters specific for Bank Transfer - Direct Debit.  See [Client parameters for Payment Pages 2.0](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/LA_Hosted_Payment_Pages/B_Payment_Pages_2.0/J_Client_Parameters_for_Payment_Pages_2.0)  and [Validate client-side HPM parameters](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/LA_Hosted_Payment_Pages/B_Payment_Pages_2.0/F_Generate_the_Digital_Signature_for_Payment_Pages_2.0#Validate_Client-side_HPM_Parameters)  for details. 
   * @return IBAN
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "An optional client parameter that can be used for validating client-side HPM parameters specific for Bank Transfer - Direct Debit.  See [Client parameters for Payment Pages 2.0](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/LA_Hosted_Payment_Pages/B_Payment_Pages_2.0/J_Client_Parameters_for_Payment_Pages_2.0)  and [Validate client-side HPM parameters](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/LA_Hosted_Payment_Pages/B_Payment_Pages_2.0/F_Generate_the_Digital_Signature_for_Payment_Pages_2.0#Validate_Client-side_HPM_Parameters)  for details. ")

  public String getIBAN() {
    return IBAN;
  }


  public void setIBAN(String IBAN) {
    
    
    
    this.IBAN = IBAN;
  }


  public POSTRSASignatureType accountId(String accountId) {
    
    
    
    
    this.accountId = accountId;
    return this;
  }

   /**
   * An optional client parameter that can be used for validating client-side HPM parameters.  See [Client parameters for Payment Pages 2.0](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/LA_Hosted_Payment_Pages/B_Payment_Pages_2.0/J_Client_Parameters_for_Payment_Pages_2.0)  and [Validate client-side HPM parameters](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/LA_Hosted_Payment_Pages/B_Payment_Pages_2.0/F_Generate_the_Digital_Signature_for_Payment_Pages_2.0#Validate_Client-side_HPM_Parameters)  for details. 
   * @return accountId
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "An optional client parameter that can be used for validating client-side HPM parameters.  See [Client parameters for Payment Pages 2.0](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/LA_Hosted_Payment_Pages/B_Payment_Pages_2.0/J_Client_Parameters_for_Payment_Pages_2.0)  and [Validate client-side HPM parameters](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/LA_Hosted_Payment_Pages/B_Payment_Pages_2.0/F_Generate_the_Digital_Signature_for_Payment_Pages_2.0#Validate_Client-side_HPM_Parameters)  for details. ")

  public String getAccountId() {
    return accountId;
  }


  public void setAccountId(String accountId) {
    
    
    
    this.accountId = accountId;
  }


  public POSTRSASignatureType authorizationAmount(Double authorizationAmount) {
    
    
    
    
    this.authorizationAmount = authorizationAmount;
    return this;
  }

  public POSTRSASignatureType authorizationAmount(Integer authorizationAmount) {
    
    
    
    
    this.authorizationAmount = authorizationAmount.doubleValue();
    return this;
  }

   /**
   * An optional client parameter that can be used for validating client-side HPM parameters.  See [Client parameters for Payment Pages 2.0](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/LA_Hosted_Payment_Pages/B_Payment_Pages_2.0/J_Client_Parameters_for_Payment_Pages_2.0)  and [Validate client-side HPM parameters](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/LA_Hosted_Payment_Pages/B_Payment_Pages_2.0/F_Generate_the_Digital_Signature_for_Payment_Pages_2.0#Validate_Client-side_HPM_Parameters)  for details. 
   * @return authorizationAmount
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "An optional client parameter that can be used for validating client-side HPM parameters.  See [Client parameters for Payment Pages 2.0](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/LA_Hosted_Payment_Pages/B_Payment_Pages_2.0/J_Client_Parameters_for_Payment_Pages_2.0)  and [Validate client-side HPM parameters](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/LA_Hosted_Payment_Pages/B_Payment_Pages_2.0/F_Generate_the_Digital_Signature_for_Payment_Pages_2.0#Validate_Client-side_HPM_Parameters)  for details. ")

  public Double getAuthorizationAmount() {
    return authorizationAmount;
  }


  public void setAuthorizationAmount(Double authorizationAmount) {
    
    
    
    this.authorizationAmount = authorizationAmount;
  }


  public POSTRSASignatureType bankBranchCode(String bankBranchCode) {
    
    
    
    
    this.bankBranchCode = bankBranchCode;
    return this;
  }

   /**
   * An optional client parameter that can be used for validating client-side HPM parameters specific for Bank Transfer - Direct Debit.  See [Client parameters for Payment Pages 2.0](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/LA_Hosted_Payment_Pages/B_Payment_Pages_2.0/J_Client_Parameters_for_Payment_Pages_2.0)  and [Validate client-side HPM parameters](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/LA_Hosted_Payment_Pages/B_Payment_Pages_2.0/F_Generate_the_Digital_Signature_for_Payment_Pages_2.0#Validate_Client-side_HPM_Parameters)  for details. 
   * @return bankBranchCode
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "An optional client parameter that can be used for validating client-side HPM parameters specific for Bank Transfer - Direct Debit.  See [Client parameters for Payment Pages 2.0](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/LA_Hosted_Payment_Pages/B_Payment_Pages_2.0/J_Client_Parameters_for_Payment_Pages_2.0)  and [Validate client-side HPM parameters](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/LA_Hosted_Payment_Pages/B_Payment_Pages_2.0/F_Generate_the_Digital_Signature_for_Payment_Pages_2.0#Validate_Client-side_HPM_Parameters)  for details. ")

  public String getBankBranchCode() {
    return bankBranchCode;
  }


  public void setBankBranchCode(String bankBranchCode) {
    
    
    
    this.bankBranchCode = bankBranchCode;
  }


  public POSTRSASignatureType bankCheckDigit(String bankCheckDigit) {
    
    
    
    
    this.bankCheckDigit = bankCheckDigit;
    return this;
  }

   /**
   * An optional client parameter that can be used for validating client-side HPM parameters specific for Bank Transfer - Direct Debit.  See [Client parameters for Payment Pages 2.0](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/LA_Hosted_Payment_Pages/B_Payment_Pages_2.0/J_Client_Parameters_for_Payment_Pages_2.0)  and [Validate client-side HPM parameters](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/LA_Hosted_Payment_Pages/B_Payment_Pages_2.0/F_Generate_the_Digital_Signature_for_Payment_Pages_2.0#Validate_Client-side_HPM_Parameters)  for details. 
   * @return bankCheckDigit
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "An optional client parameter that can be used for validating client-side HPM parameters specific for Bank Transfer - Direct Debit.  See [Client parameters for Payment Pages 2.0](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/LA_Hosted_Payment_Pages/B_Payment_Pages_2.0/J_Client_Parameters_for_Payment_Pages_2.0)  and [Validate client-side HPM parameters](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/LA_Hosted_Payment_Pages/B_Payment_Pages_2.0/F_Generate_the_Digital_Signature_for_Payment_Pages_2.0#Validate_Client-side_HPM_Parameters)  for details. ")

  public String getBankCheckDigit() {
    return bankCheckDigit;
  }


  public void setBankCheckDigit(String bankCheckDigit) {
    
    
    
    this.bankCheckDigit = bankCheckDigit;
  }


  public POSTRSASignatureType bankCity(String bankCity) {
    
    
    
    
    this.bankCity = bankCity;
    return this;
  }

   /**
   * An optional client parameter that can be used for validating client-side HPM parameters specific for Bank Transfer - Direct Debit.  See [Client parameters for Payment Pages 2.0](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/LA_Hosted_Payment_Pages/B_Payment_Pages_2.0/J_Client_Parameters_for_Payment_Pages_2.0)  and [Validate client-side HPM parameters](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/LA_Hosted_Payment_Pages/B_Payment_Pages_2.0/F_Generate_the_Digital_Signature_for_Payment_Pages_2.0#Validate_Client-side_HPM_Parameters)  for details. 
   * @return bankCity
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "An optional client parameter that can be used for validating client-side HPM parameters specific for Bank Transfer - Direct Debit.  See [Client parameters for Payment Pages 2.0](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/LA_Hosted_Payment_Pages/B_Payment_Pages_2.0/J_Client_Parameters_for_Payment_Pages_2.0)  and [Validate client-side HPM parameters](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/LA_Hosted_Payment_Pages/B_Payment_Pages_2.0/F_Generate_the_Digital_Signature_for_Payment_Pages_2.0#Validate_Client-side_HPM_Parameters)  for details. ")

  public String getBankCity() {
    return bankCity;
  }


  public void setBankCity(String bankCity) {
    
    
    
    this.bankCity = bankCity;
  }


  public POSTRSASignatureType bankPostalCode(String bankPostalCode) {
    
    
    
    
    this.bankPostalCode = bankPostalCode;
    return this;
  }

   /**
   * An optional client parameter that can be used for validating client-side HPM parameters specific for Bank Transfer - Direct Debit.  See [Client parameters for Payment Pages 2.0](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/LA_Hosted_Payment_Pages/B_Payment_Pages_2.0/J_Client_Parameters_for_Payment_Pages_2.0)  and [Validate client-side HPM parameters](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/LA_Hosted_Payment_Pages/B_Payment_Pages_2.0/F_Generate_the_Digital_Signature_for_Payment_Pages_2.0#Validate_Client-side_HPM_Parameters)  for details. 
   * @return bankPostalCode
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "An optional client parameter that can be used for validating client-side HPM parameters specific for Bank Transfer - Direct Debit.  See [Client parameters for Payment Pages 2.0](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/LA_Hosted_Payment_Pages/B_Payment_Pages_2.0/J_Client_Parameters_for_Payment_Pages_2.0)  and [Validate client-side HPM parameters](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/LA_Hosted_Payment_Pages/B_Payment_Pages_2.0/F_Generate_the_Digital_Signature_for_Payment_Pages_2.0#Validate_Client-side_HPM_Parameters)  for details. ")

  public String getBankPostalCode() {
    return bankPostalCode;
  }


  public void setBankPostalCode(String bankPostalCode) {
    
    
    
    this.bankPostalCode = bankPostalCode;
  }


  public POSTRSASignatureType bankStreetName(String bankStreetName) {
    
    
    
    
    this.bankStreetName = bankStreetName;
    return this;
  }

   /**
   * An optional client parameter that can be used for validating client-side HPM parameters specific for Bank Transfer - Direct Debit.  See [Client parameters for Payment Pages 2.0](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/LA_Hosted_Payment_Pages/B_Payment_Pages_2.0/J_Client_Parameters_for_Payment_Pages_2.0)  and [Validate client-side HPM parameters](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/LA_Hosted_Payment_Pages/B_Payment_Pages_2.0/F_Generate_the_Digital_Signature_for_Payment_Pages_2.0#Validate_Client-side_HPM_Parameters)  for details. 
   * @return bankStreetName
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "An optional client parameter that can be used for validating client-side HPM parameters specific for Bank Transfer - Direct Debit.  See [Client parameters for Payment Pages 2.0](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/LA_Hosted_Payment_Pages/B_Payment_Pages_2.0/J_Client_Parameters_for_Payment_Pages_2.0)  and [Validate client-side HPM parameters](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/LA_Hosted_Payment_Pages/B_Payment_Pages_2.0/F_Generate_the_Digital_Signature_for_Payment_Pages_2.0#Validate_Client-side_HPM_Parameters)  for details. ")

  public String getBankStreetName() {
    return bankStreetName;
  }


  public void setBankStreetName(String bankStreetName) {
    
    
    
    this.bankStreetName = bankStreetName;
  }


  public POSTRSASignatureType bankStreetNumber(String bankStreetNumber) {
    
    
    
    
    this.bankStreetNumber = bankStreetNumber;
    return this;
  }

   /**
   * An optional client parameter that can be used for validating client-side HPM parameters specific for Bank Transfer - Direct Debit.  See [Client parameters for Payment Pages 2.0](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/LA_Hosted_Payment_Pages/B_Payment_Pages_2.0/J_Client_Parameters_for_Payment_Pages_2.0)  and [Validate client-side HPM parameters](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/LA_Hosted_Payment_Pages/B_Payment_Pages_2.0/F_Generate_the_Digital_Signature_for_Payment_Pages_2.0#Validate_Client-side_HPM_Parameters)  for details. 
   * @return bankStreetNumber
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "An optional client parameter that can be used for validating client-side HPM parameters specific for Bank Transfer - Direct Debit.  See [Client parameters for Payment Pages 2.0](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/LA_Hosted_Payment_Pages/B_Payment_Pages_2.0/J_Client_Parameters_for_Payment_Pages_2.0)  and [Validate client-side HPM parameters](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/LA_Hosted_Payment_Pages/B_Payment_Pages_2.0/F_Generate_the_Digital_Signature_for_Payment_Pages_2.0#Validate_Client-side_HPM_Parameters)  for details. ")

  public String getBankStreetNumber() {
    return bankStreetNumber;
  }


  public void setBankStreetNumber(String bankStreetNumber) {
    
    
    
    this.bankStreetNumber = bankStreetNumber;
  }


  public POSTRSASignatureType businessIdentificationCode(String businessIdentificationCode) {
    
    
    
    
    this.businessIdentificationCode = businessIdentificationCode;
    return this;
  }

   /**
   * An optional client parameter that can be used for validating client-side HPM parameters specific for Bank Transfer - Direct Debit.  See [Client parameters for Payment Pages 2.0](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/LA_Hosted_Payment_Pages/B_Payment_Pages_2.0/J_Client_Parameters_for_Payment_Pages_2.0)  and [Validate client-side HPM parameters](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/LA_Hosted_Payment_Pages/B_Payment_Pages_2.0/F_Generate_the_Digital_Signature_for_Payment_Pages_2.0#Validate_Client-side_HPM_Parameters)  for details. 
   * @return businessIdentificationCode
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "An optional client parameter that can be used for validating client-side HPM parameters specific for Bank Transfer - Direct Debit.  See [Client parameters for Payment Pages 2.0](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/LA_Hosted_Payment_Pages/B_Payment_Pages_2.0/J_Client_Parameters_for_Payment_Pages_2.0)  and [Validate client-side HPM parameters](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/LA_Hosted_Payment_Pages/B_Payment_Pages_2.0/F_Generate_the_Digital_Signature_for_Payment_Pages_2.0#Validate_Client-side_HPM_Parameters)  for details. ")

  public String getBusinessIdentificationCode() {
    return businessIdentificationCode;
  }


  public void setBusinessIdentificationCode(String businessIdentificationCode) {
    
    
    
    this.businessIdentificationCode = businessIdentificationCode;
  }


  public POSTRSASignatureType cityBlackList(String cityBlackList) {
    
    
    
    
    this.cityBlackList = cityBlackList;
    return this;
  }

   /**
   * An optional client parameter that can be used for validating client-side HPM parameters specific for credit cards.  See [Client parameters for Payment Pages 2.0](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/LA_Hosted_Payment_Pages/B_Payment_Pages_2.0/J_Client_Parameters_for_Payment_Pages_2.0)  and [Validate client-side HPM parameters](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/LA_Hosted_Payment_Pages/B_Payment_Pages_2.0/F_Generate_the_Digital_Signature_for_Payment_Pages_2.0#Validate_Client-side_HPM_Parameters)  for details. 
   * @return cityBlackList
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "An optional client parameter that can be used for validating client-side HPM parameters specific for credit cards.  See [Client parameters for Payment Pages 2.0](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/LA_Hosted_Payment_Pages/B_Payment_Pages_2.0/J_Client_Parameters_for_Payment_Pages_2.0)  and [Validate client-side HPM parameters](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/LA_Hosted_Payment_Pages/B_Payment_Pages_2.0/F_Generate_the_Digital_Signature_for_Payment_Pages_2.0#Validate_Client-side_HPM_Parameters)  for details. ")

  public String getCityBlackList() {
    return cityBlackList;
  }


  public void setCityBlackList(String cityBlackList) {
    
    
    
    this.cityBlackList = cityBlackList;
  }


  public POSTRSASignatureType cityWhiteList(String cityWhiteList) {
    
    
    
    
    this.cityWhiteList = cityWhiteList;
    return this;
  }

   /**
   * An optional client parameter that can be used for validating client-side HPM parameters specific for credit cards.  See [Client parameters for Payment Pages 2.0](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/LA_Hosted_Payment_Pages/B_Payment_Pages_2.0/J_Client_Parameters_for_Payment_Pages_2.0)  and [Validate client-side HPM parameters](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/LA_Hosted_Payment_Pages/B_Payment_Pages_2.0/F_Generate_the_Digital_Signature_for_Payment_Pages_2.0#Validate_Client-side_HPM_Parameters)  for details. 
   * @return cityWhiteList
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "An optional client parameter that can be used for validating client-side HPM parameters specific for credit cards.  See [Client parameters for Payment Pages 2.0](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/LA_Hosted_Payment_Pages/B_Payment_Pages_2.0/J_Client_Parameters_for_Payment_Pages_2.0)  and [Validate client-side HPM parameters](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/LA_Hosted_Payment_Pages/B_Payment_Pages_2.0/F_Generate_the_Digital_Signature_for_Payment_Pages_2.0#Validate_Client-side_HPM_Parameters)  for details. ")

  public String getCityWhiteList() {
    return cityWhiteList;
  }


  public void setCityWhiteList(String cityWhiteList) {
    
    
    
    this.cityWhiteList = cityWhiteList;
  }


  public POSTRSASignatureType currency(String currency) {
    
    
    
    
    this.currency = currency;
    return this;
  }

   /**
   * An optional client parameter that can be used for validating client-side HPM parameters.  See [Client parameters for Payment Pages 2.0](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/LA_Hosted_Payment_Pages/B_Payment_Pages_2.0/J_Client_Parameters_for_Payment_Pages_2.0)  and [Validate client-side HPM parameters](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/LA_Hosted_Payment_Pages/B_Payment_Pages_2.0/F_Generate_the_Digital_Signature_for_Payment_Pages_2.0#Validate_Client-side_HPM_Parameters)  for details. 
   * @return currency
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "USD", value = "An optional client parameter that can be used for validating client-side HPM parameters.  See [Client parameters for Payment Pages 2.0](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/LA_Hosted_Payment_Pages/B_Payment_Pages_2.0/J_Client_Parameters_for_Payment_Pages_2.0)  and [Validate client-side HPM parameters](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/LA_Hosted_Payment_Pages/B_Payment_Pages_2.0/F_Generate_the_Digital_Signature_for_Payment_Pages_2.0#Validate_Client-side_HPM_Parameters)  for details. ")

  public String getCurrency() {
    return currency;
  }


  public void setCurrency(String currency) {
    
    
    
    this.currency = currency;
  }


  public POSTRSASignatureType deviceSessionId(String deviceSessionId) {
    
    
    
    
    this.deviceSessionId = deviceSessionId;
    return this;
  }

   /**
   * An optional client parameter that can be used for validating client-side HPM parameters.  See [Client parameters for Payment Pages 2.0](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/LA_Hosted_Payment_Pages/B_Payment_Pages_2.0/J_Client_Parameters_for_Payment_Pages_2.0)  and [Validate client-side HPM parameters](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/LA_Hosted_Payment_Pages/B_Payment_Pages_2.0/F_Generate_the_Digital_Signature_for_Payment_Pages_2.0#Validate_Client-side_HPM_Parameters)  for details. 
   * @return deviceSessionId
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "An optional client parameter that can be used for validating client-side HPM parameters.  See [Client parameters for Payment Pages 2.0](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/LA_Hosted_Payment_Pages/B_Payment_Pages_2.0/J_Client_Parameters_for_Payment_Pages_2.0)  and [Validate client-side HPM parameters](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/LA_Hosted_Payment_Pages/B_Payment_Pages_2.0/F_Generate_the_Digital_Signature_for_Payment_Pages_2.0#Validate_Client-side_HPM_Parameters)  for details. ")

  public String getDeviceSessionId() {
    return deviceSessionId;
  }


  public void setDeviceSessionId(String deviceSessionId) {
    
    
    
    this.deviceSessionId = deviceSessionId;
  }


  public POSTRSASignatureType gatewayName(String gatewayName) {
    
    
    
    
    this.gatewayName = gatewayName;
    return this;
  }

   /**
   * An optional client parameter that can be used for validating client-side HPM parameters.  See [Client parameters for Payment Pages 2.0](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/LA_Hosted_Payment_Pages/B_Payment_Pages_2.0/J_Client_Parameters_for_Payment_Pages_2.0)  and [Validate client-side HPM parameters](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/LA_Hosted_Payment_Pages/B_Payment_Pages_2.0/F_Generate_the_Digital_Signature_for_Payment_Pages_2.0#Validate_Client-side_HPM_Parameters)  for details. 
   * @return gatewayName
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "An optional client parameter that can be used for validating client-side HPM parameters.  See [Client parameters for Payment Pages 2.0](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/LA_Hosted_Payment_Pages/B_Payment_Pages_2.0/J_Client_Parameters_for_Payment_Pages_2.0)  and [Validate client-side HPM parameters](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/LA_Hosted_Payment_Pages/B_Payment_Pages_2.0/F_Generate_the_Digital_Signature_for_Payment_Pages_2.0#Validate_Client-side_HPM_Parameters)  for details. ")

  public String getGatewayName() {
    return gatewayName;
  }


  public void setGatewayName(String gatewayName) {
    
    
    
    this.gatewayName = gatewayName;
  }


  public POSTRSASignatureType id(String id) {
    
    
    
    
    this.id = id;
    return this;
  }

   /**
   * An optional client parameter that can be used for validating client-side HPM parameters.  See [Client parameters for Payment Pages 2.0](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/LA_Hosted_Payment_Pages/B_Payment_Pages_2.0/J_Client_Parameters_for_Payment_Pages_2.0)  and [Validate client-side HPM parameters](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/LA_Hosted_Payment_Pages/B_Payment_Pages_2.0/F_Generate_the_Digital_Signature_for_Payment_Pages_2.0#Validate_Client-side_HPM_Parameters)  for details. 
   * @return id
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "An optional client parameter that can be used for validating client-side HPM parameters.  See [Client parameters for Payment Pages 2.0](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/LA_Hosted_Payment_Pages/B_Payment_Pages_2.0/J_Client_Parameters_for_Payment_Pages_2.0)  and [Validate client-side HPM parameters](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/LA_Hosted_Payment_Pages/B_Payment_Pages_2.0/F_Generate_the_Digital_Signature_for_Payment_Pages_2.0#Validate_Client-side_HPM_Parameters)  for details. ")

  public String getId() {
    return id;
  }


  public void setId(String id) {
    
    
    
    this.id = id;
  }


  public POSTRSASignatureType key(String key) {
    
    
    
    
    this.key = key;
    return this;
  }

   /**
   * An optional client parameter that can be used for validating client-side HPM parameters.  See [Client parameters for Payment Pages 2.0](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/LA_Hosted_Payment_Pages/B_Payment_Pages_2.0/J_Client_Parameters_for_Payment_Pages_2.0)  and [Validate client-side HPM parameters](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/LA_Hosted_Payment_Pages/B_Payment_Pages_2.0/F_Generate_the_Digital_Signature_for_Payment_Pages_2.0#Validate_Client-side_HPM_Parameters)  for details. 
   * @return key
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "An optional client parameter that can be used for validating client-side HPM parameters.  See [Client parameters for Payment Pages 2.0](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/LA_Hosted_Payment_Pages/B_Payment_Pages_2.0/J_Client_Parameters_for_Payment_Pages_2.0)  and [Validate client-side HPM parameters](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/LA_Hosted_Payment_Pages/B_Payment_Pages_2.0/F_Generate_the_Digital_Signature_for_Payment_Pages_2.0#Validate_Client-side_HPM_Parameters)  for details. ")

  public String getKey() {
    return key;
  }


  public void setKey(String key) {
    
    
    
    this.key = key;
  }


  public POSTRSASignatureType locale(String locale) {
    
    
    
    
    this.locale = locale;
    return this;
  }

   /**
   * An optional client parameter that can be used for validating client-side HPM parameters.  See [Client parameters for Payment Pages 2.0](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/LA_Hosted_Payment_Pages/B_Payment_Pages_2.0/J_Client_Parameters_for_Payment_Pages_2.0)  and [Validate client-side HPM parameters](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/LA_Hosted_Payment_Pages/B_Payment_Pages_2.0/F_Generate_the_Digital_Signature_for_Payment_Pages_2.0#Validate_Client-side_HPM_Parameters)  for details. 
   * @return locale
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "An optional client parameter that can be used for validating client-side HPM parameters.  See [Client parameters for Payment Pages 2.0](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/LA_Hosted_Payment_Pages/B_Payment_Pages_2.0/J_Client_Parameters_for_Payment_Pages_2.0)  and [Validate client-side HPM parameters](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/LA_Hosted_Payment_Pages/B_Payment_Pages_2.0/F_Generate_the_Digital_Signature_for_Payment_Pages_2.0#Validate_Client-side_HPM_Parameters)  for details. ")

  public String getLocale() {
    return locale;
  }


  public void setLocale(String locale) {
    
    
    
    this.locale = locale;
  }


  public POSTRSASignatureType maxConsecutivePaymentFailures(Integer maxConsecutivePaymentFailures) {
    
    
    
    
    this.maxConsecutivePaymentFailures = maxConsecutivePaymentFailures;
    return this;
  }

   /**
   * An optional client parameter that can be used for validating client-side HPM parameters.  See [Client parameters for Payment Pages 2.0](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/LA_Hosted_Payment_Pages/B_Payment_Pages_2.0/J_Client_Parameters_for_Payment_Pages_2.0)  and [Validate client-side HPM parameters](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/LA_Hosted_Payment_Pages/B_Payment_Pages_2.0/F_Generate_the_Digital_Signature_for_Payment_Pages_2.0#Validate_Client-side_HPM_Parameters)  for details. 
   * @return maxConsecutivePaymentFailures
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "An optional client parameter that can be used for validating client-side HPM parameters.  See [Client parameters for Payment Pages 2.0](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/LA_Hosted_Payment_Pages/B_Payment_Pages_2.0/J_Client_Parameters_for_Payment_Pages_2.0)  and [Validate client-side HPM parameters](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/LA_Hosted_Payment_Pages/B_Payment_Pages_2.0/F_Generate_the_Digital_Signature_for_Payment_Pages_2.0#Validate_Client-side_HPM_Parameters)  for details. ")

  public Integer getMaxConsecutivePaymentFailures() {
    return maxConsecutivePaymentFailures;
  }


  public void setMaxConsecutivePaymentFailures(Integer maxConsecutivePaymentFailures) {
    
    
    
    this.maxConsecutivePaymentFailures = maxConsecutivePaymentFailures;
  }


  public POSTRSASignatureType method(String method) {
    
    
    
    
    this.method = method;
    return this;
  }

   /**
   * The type of the request. Set it to POST. 
   * @return method
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(example = "POST", required = true, value = "The type of the request. Set it to POST. ")

  public String getMethod() {
    return method;
  }


  public void setMethod(String method) {
    
    
    
    this.method = method;
  }


  public POSTRSASignatureType pageId(String pageId) {
    
    
    
    
    this.pageId = pageId;
    return this;
  }

   /**
   * The page id of your Payment Pages 2.0 form. Click **Show Page Id** next to the Payment Page name in the Hosted Page List to retrieve the page id. 
   * @return pageId
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(example = "2c92c0f855e2b4630155ec9e6a1b6eec", required = true, value = "The page id of your Payment Pages 2.0 form. Click **Show Page Id** next to the Payment Page name in the Hosted Page List to retrieve the page id. ")

  public String getPageId() {
    return pageId;
  }


  public void setPageId(String pageId) {
    
    
    
    this.pageId = pageId;
  }


  public POSTRSASignatureType paramGwOptionsStarOptionStar(String paramGwOptionsStarOptionStar) {
    
    
    
    
    this.paramGwOptionsStarOptionStar = paramGwOptionsStarOptionStar;
    return this;
  }

   /**
   * An optional client parameter that can be used for validating client-side HPM parameters.  See [Client parameters for Payment Pages 2.0](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/LA_Hosted_Payment_Pages/B_Payment_Pages_2.0/J_Client_Parameters_for_Payment_Pages_2.0)  and [Validate client-side HPM parameters](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/LA_Hosted_Payment_Pages/B_Payment_Pages_2.0/F_Generate_the_Digital_Signature_for_Payment_Pages_2.0#Validate_Client-side_HPM_Parameters)  for details. 
   * @return paramGwOptionsStarOptionStar
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "An optional client parameter that can be used for validating client-side HPM parameters.  See [Client parameters for Payment Pages 2.0](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/LA_Hosted_Payment_Pages/B_Payment_Pages_2.0/J_Client_Parameters_for_Payment_Pages_2.0)  and [Validate client-side HPM parameters](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/LA_Hosted_Payment_Pages/B_Payment_Pages_2.0/F_Generate_the_Digital_Signature_for_Payment_Pages_2.0#Validate_Client-side_HPM_Parameters)  for details. ")

  public String getParamGwOptionsStarOptionStar() {
    return paramGwOptionsStarOptionStar;
  }


  public void setParamGwOptionsStarOptionStar(String paramGwOptionsStarOptionStar) {
    
    
    
    this.paramGwOptionsStarOptionStar = paramGwOptionsStarOptionStar;
  }


  public POSTRSASignatureType paramSupportedTypes(String paramSupportedTypes) {
    
    
    
    
    this.paramSupportedTypes = paramSupportedTypes;
    return this;
  }

   /**
   * An optional client parameter that can be used for validating client-side HPM parameters specific for credit cards.  See [Client parameters for Payment Pages 2.0](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/LA_Hosted_Payment_Pages/B_Payment_Pages_2.0/J_Client_Parameters_for_Payment_Pages_2.0)  and [Validate client-side HPM parameters](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/LA_Hosted_Payment_Pages/B_Payment_Pages_2.0/F_Generate_the_Digital_Signature_for_Payment_Pages_2.0#Validate_Client-side_HPM_Parameters)  for details. 
   * @return paramSupportedTypes
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "An optional client parameter that can be used for validating client-side HPM parameters specific for credit cards.  See [Client parameters for Payment Pages 2.0](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/LA_Hosted_Payment_Pages/B_Payment_Pages_2.0/J_Client_Parameters_for_Payment_Pages_2.0)  and [Validate client-side HPM parameters](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/LA_Hosted_Payment_Pages/B_Payment_Pages_2.0/F_Generate_the_Digital_Signature_for_Payment_Pages_2.0#Validate_Client-side_HPM_Parameters)  for details. ")

  public String getParamSupportedTypes() {
    return paramSupportedTypes;
  }


  public void setParamSupportedTypes(String paramSupportedTypes) {
    
    
    
    this.paramSupportedTypes = paramSupportedTypes;
  }


  public POSTRSASignatureType passthrough1Comma2Comma3Comma4Comma5(String passthrough1Comma2Comma3Comma4Comma5) {
    
    
    
    
    this.passthrough1Comma2Comma3Comma4Comma5 = passthrough1Comma2Comma3Comma4Comma5;
    return this;
  }

   /**
   * An optional client parameter that can be used for validating client-side HPM parameters.  See [Client parameters for Payment Pages 2.0](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/LA_Hosted_Payment_Pages/B_Payment_Pages_2.0/J_Client_Parameters_for_Payment_Pages_2.0)  and [Validate client-side HPM parameters](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/LA_Hosted_Payment_Pages/B_Payment_Pages_2.0/F_Generate_the_Digital_Signature_for_Payment_Pages_2.0#Validate_Client-side_HPM_Parameters)  for details.  Note: Although up to 15 passthrough parameters can be supported when passing in your client parameters, only the first 5 parameters are used for signature generation and validation. 
   * @return passthrough1Comma2Comma3Comma4Comma5
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "An optional client parameter that can be used for validating client-side HPM parameters.  See [Client parameters for Payment Pages 2.0](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/LA_Hosted_Payment_Pages/B_Payment_Pages_2.0/J_Client_Parameters_for_Payment_Pages_2.0)  and [Validate client-side HPM parameters](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/LA_Hosted_Payment_Pages/B_Payment_Pages_2.0/F_Generate_the_Digital_Signature_for_Payment_Pages_2.0#Validate_Client-side_HPM_Parameters)  for details.  Note: Although up to 15 passthrough parameters can be supported when passing in your client parameters, only the first 5 parameters are used for signature generation and validation. ")

  public String getPassthrough1Comma2Comma3Comma4Comma5() {
    return passthrough1Comma2Comma3Comma4Comma5;
  }


  public void setPassthrough1Comma2Comma3Comma4Comma5(String passthrough1Comma2Comma3Comma4Comma5) {
    
    
    
    this.passthrough1Comma2Comma3Comma4Comma5 = passthrough1Comma2Comma3Comma4Comma5;
  }


  public POSTRSASignatureType paymentGateway(String paymentGateway) {
    
    
    
    
    this.paymentGateway = paymentGateway;
    return this;
  }

   /**
   * An optional client parameter that can be used for validating client-side HPM parameters.  See [Client parameters for Payment Pages 2.0](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/LA_Hosted_Payment_Pages/B_Payment_Pages_2.0/J_Client_Parameters_for_Payment_Pages_2.0)  and [Validate client-side HPM parameters](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/LA_Hosted_Payment_Pages/B_Payment_Pages_2.0/F_Generate_the_Digital_Signature_for_Payment_Pages_2.0#Validate_Client-side_HPM_Parameters)  for details. 
   * @return paymentGateway
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "An optional client parameter that can be used for validating client-side HPM parameters.  See [Client parameters for Payment Pages 2.0](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/LA_Hosted_Payment_Pages/B_Payment_Pages_2.0/J_Client_Parameters_for_Payment_Pages_2.0)  and [Validate client-side HPM parameters](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/LA_Hosted_Payment_Pages/B_Payment_Pages_2.0/F_Generate_the_Digital_Signature_for_Payment_Pages_2.0#Validate_Client-side_HPM_Parameters)  for details. ")

  public String getPaymentGateway() {
    return paymentGateway;
  }


  public void setPaymentGateway(String paymentGateway) {
    
    
    
    this.paymentGateway = paymentGateway;
  }


  public POSTRSASignatureType paymentRetryWindow(Integer paymentRetryWindow) {
    
    
    
    
    this.paymentRetryWindow = paymentRetryWindow;
    return this;
  }

   /**
   * An optional client parameter that can be used for validating client-side HPM parameters.  See [Client parameters for Payment Pages 2.0](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/LA_Hosted_Payment_Pages/B_Payment_Pages_2.0/J_Client_Parameters_for_Payment_Pages_2.0)  and [Validate client-side HPM parameters](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/LA_Hosted_Payment_Pages/B_Payment_Pages_2.0/F_Generate_the_Digital_Signature_for_Payment_Pages_2.0#Validate_Client-side_HPM_Parameters)  for details. 
   * @return paymentRetryWindow
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "An optional client parameter that can be used for validating client-side HPM parameters.  See [Client parameters for Payment Pages 2.0](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/LA_Hosted_Payment_Pages/B_Payment_Pages_2.0/J_Client_Parameters_for_Payment_Pages_2.0)  and [Validate client-side HPM parameters](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/LA_Hosted_Payment_Pages/B_Payment_Pages_2.0/F_Generate_the_Digital_Signature_for_Payment_Pages_2.0#Validate_Client-side_HPM_Parameters)  for details. ")

  public Integer getPaymentRetryWindow() {
    return paymentRetryWindow;
  }


  public void setPaymentRetryWindow(Integer paymentRetryWindow) {
    
    
    
    this.paymentRetryWindow = paymentRetryWindow;
  }


  public POSTRSASignatureType pmId(String pmId) {
    
    
    
    
    this.pmId = pmId;
    return this;
  }

   /**
   * An optional client parameter that can be used for validating client-side HPM parameters specific for credit cards.  See [Client parameters for Payment Pages 2.0](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/LA_Hosted_Payment_Pages/B_Payment_Pages_2.0/J_Client_Parameters_for_Payment_Pages_2.0)  and [Validate client-side HPM parameters](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/LA_Hosted_Payment_Pages/B_Payment_Pages_2.0/F_Generate_the_Digital_Signature_for_Payment_Pages_2.0#Validate_Client-side_HPM_Parameters)  for details. 
   * @return pmId
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "An optional client parameter that can be used for validating client-side HPM parameters specific for credit cards.  See [Client parameters for Payment Pages 2.0](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/LA_Hosted_Payment_Pages/B_Payment_Pages_2.0/J_Client_Parameters_for_Payment_Pages_2.0)  and [Validate client-side HPM parameters](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/LA_Hosted_Payment_Pages/B_Payment_Pages_2.0/F_Generate_the_Digital_Signature_for_Payment_Pages_2.0#Validate_Client-side_HPM_Parameters)  for details. ")

  public String getPmId() {
    return pmId;
  }


  public void setPmId(String pmId) {
    
    
    
    this.pmId = pmId;
  }


  public POSTRSASignatureType signature(String signature) {
    
    
    
    
    this.signature = signature;
    return this;
  }

   /**
   * An optional client parameter that can be used for validating client-side HPM parameters.  See [Client parameters for Payment Pages 2.0](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/LA_Hosted_Payment_Pages/B_Payment_Pages_2.0/J_Client_Parameters_for_Payment_Pages_2.0)  and [Validate client-side HPM parameters](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/LA_Hosted_Payment_Pages/B_Payment_Pages_2.0/F_Generate_the_Digital_Signature_for_Payment_Pages_2.0#Validate_Client-side_HPM_Parameters)  for details. 
   * @return signature
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "An optional client parameter that can be used for validating client-side HPM parameters.  See [Client parameters for Payment Pages 2.0](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/LA_Hosted_Payment_Pages/B_Payment_Pages_2.0/J_Client_Parameters_for_Payment_Pages_2.0)  and [Validate client-side HPM parameters](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/LA_Hosted_Payment_Pages/B_Payment_Pages_2.0/F_Generate_the_Digital_Signature_for_Payment_Pages_2.0#Validate_Client-side_HPM_Parameters)  for details. ")

  public String getSignature() {
    return signature;
  }


  public void setSignature(String signature) {
    
    
    
    this.signature = signature;
  }


  public POSTRSASignatureType signatureType(String signatureType) {
    
    
    
    
    this.signatureType = signatureType;
    return this;
  }

   /**
   * An optional client parameter that can be used for validating client-side HPM parameters.  See [Client parameters for Payment Pages 2.0](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/LA_Hosted_Payment_Pages/B_Payment_Pages_2.0/J_Client_Parameters_for_Payment_Pages_2.0)  and [Validate client-side HPM parameters](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/LA_Hosted_Payment_Pages/B_Payment_Pages_2.0/F_Generate_the_Digital_Signature_for_Payment_Pages_2.0#Validate_Client-side_HPM_Parameters)  for details. 
   * @return signatureType
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "An optional client parameter that can be used for validating client-side HPM parameters.  See [Client parameters for Payment Pages 2.0](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/LA_Hosted_Payment_Pages/B_Payment_Pages_2.0/J_Client_Parameters_for_Payment_Pages_2.0)  and [Validate client-side HPM parameters](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/LA_Hosted_Payment_Pages/B_Payment_Pages_2.0/F_Generate_the_Digital_Signature_for_Payment_Pages_2.0#Validate_Client-side_HPM_Parameters)  for details. ")

  public String getSignatureType() {
    return signatureType;
  }


  public void setSignatureType(String signatureType) {
    
    
    
    this.signatureType = signatureType;
  }


  public POSTRSASignatureType style(String style) {
    
    
    
    
    this.style = style;
    return this;
  }

   /**
   * An optional client parameter that can be used for validating client-side HPM parameters.  See [Client parameters for Payment Pages 2.0](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/LA_Hosted_Payment_Pages/B_Payment_Pages_2.0/J_Client_Parameters_for_Payment_Pages_2.0)  and [Validate client-side HPM parameters](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/LA_Hosted_Payment_Pages/B_Payment_Pages_2.0/F_Generate_the_Digital_Signature_for_Payment_Pages_2.0#Validate_Client-side_HPM_Parameters)  for details. 
   * @return style
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "An optional client parameter that can be used for validating client-side HPM parameters.  See [Client parameters for Payment Pages 2.0](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/LA_Hosted_Payment_Pages/B_Payment_Pages_2.0/J_Client_Parameters_for_Payment_Pages_2.0)  and [Validate client-side HPM parameters](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/LA_Hosted_Payment_Pages/B_Payment_Pages_2.0/F_Generate_the_Digital_Signature_for_Payment_Pages_2.0#Validate_Client-side_HPM_Parameters)  for details. ")

  public String getStyle() {
    return style;
  }


  public void setStyle(String style) {
    
    
    
    this.style = style;
  }


  public POSTRSASignatureType submitEnabled(Boolean submitEnabled) {
    
    
    
    
    this.submitEnabled = submitEnabled;
    return this;
  }

   /**
   * An optional client parameter that can be used for validating client-side HPM parameters.  See [Client parameters for Payment Pages 2.0](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/LA_Hosted_Payment_Pages/B_Payment_Pages_2.0/J_Client_Parameters_for_Payment_Pages_2.0)  and [Validate client-side HPM parameters](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/LA_Hosted_Payment_Pages/B_Payment_Pages_2.0/F_Generate_the_Digital_Signature_for_Payment_Pages_2.0#Validate_Client-side_HPM_Parameters)  for details. 
   * @return submitEnabled
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "An optional client parameter that can be used for validating client-side HPM parameters.  See [Client parameters for Payment Pages 2.0](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/LA_Hosted_Payment_Pages/B_Payment_Pages_2.0/J_Client_Parameters_for_Payment_Pages_2.0)  and [Validate client-side HPM parameters](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/LA_Hosted_Payment_Pages/B_Payment_Pages_2.0/F_Generate_the_Digital_Signature_for_Payment_Pages_2.0#Validate_Client-side_HPM_Parameters)  for details. ")

  public Boolean getSubmitEnabled() {
    return submitEnabled;
  }


  public void setSubmitEnabled(Boolean submitEnabled) {
    
    
    
    this.submitEnabled = submitEnabled;
  }


  public POSTRSASignatureType tenantId(String tenantId) {
    
    
    
    
    this.tenantId = tenantId;
    return this;
  }

   /**
   * An optional client parameter that can be used for validating client-side HPM parameters.  See [Client parameters for Payment Pages 2.0](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/LA_Hosted_Payment_Pages/B_Payment_Pages_2.0/J_Client_Parameters_for_Payment_Pages_2.0)  and [Validate client-side HPM parameters](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/LA_Hosted_Payment_Pages/B_Payment_Pages_2.0/F_Generate_the_Digital_Signature_for_Payment_Pages_2.0#Validate_Client-side_HPM_Parameters)  for details. 
   * @return tenantId
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "An optional client parameter that can be used for validating client-side HPM parameters.  See [Client parameters for Payment Pages 2.0](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/LA_Hosted_Payment_Pages/B_Payment_Pages_2.0/J_Client_Parameters_for_Payment_Pages_2.0)  and [Validate client-side HPM parameters](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/LA_Hosted_Payment_Pages/B_Payment_Pages_2.0/F_Generate_the_Digital_Signature_for_Payment_Pages_2.0#Validate_Client-side_HPM_Parameters)  for details. ")

  public String getTenantId() {
    return tenantId;
  }


  public void setTenantId(String tenantId) {
    
    
    
    this.tenantId = tenantId;
  }


  public POSTRSASignatureType token(String token) {
    
    
    
    
    this.token = token;
    return this;
  }

   /**
   * An optional client parameter that can be used for validating client-side HPM parameters.  See [Client parameters for Payment Pages 2.0](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/LA_Hosted_Payment_Pages/B_Payment_Pages_2.0/J_Client_Parameters_for_Payment_Pages_2.0)  and [Validate client-side HPM parameters](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/LA_Hosted_Payment_Pages/B_Payment_Pages_2.0/F_Generate_the_Digital_Signature_for_Payment_Pages_2.0#Validate_Client-side_HPM_Parameters)  for details. 
   * @return token
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "An optional client parameter that can be used for validating client-side HPM parameters.  See [Client parameters for Payment Pages 2.0](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/LA_Hosted_Payment_Pages/B_Payment_Pages_2.0/J_Client_Parameters_for_Payment_Pages_2.0)  and [Validate client-side HPM parameters](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/LA_Hosted_Payment_Pages/B_Payment_Pages_2.0/F_Generate_the_Digital_Signature_for_Payment_Pages_2.0#Validate_Client-side_HPM_Parameters)  for details. ")

  public String getToken() {
    return token;
  }


  public void setToken(String token) {
    
    
    
    this.token = token;
  }


  public POSTRSASignatureType uri(String uri) {
    
    
    
    
    this.uri = uri;
    return this;
  }

   /**
   * The URL that the Payment Page will be served from. * For US Cloud 1 Production environment: Use https://na.zuora.com/apps/PublicHostedPageLite.do * For US Cloud 1 Sandbox environment: Use https://sandbox.na.zuora.com/apps/PublicHostedPageLite.do * For US Cloud 2 Production environment: Use https://www.zuora.com/apps/PublicHostedPageLite.do * For US Cloud 2 API Sandbox environment: Use https://apisandbox.zuora.com/apps/PublicHostedPageLite.do * For US Central Sandbox environment: Use https://test.zuora.com/apps/PublicHostedPageLite.do * For EU Cloud Production environment: Use https://eu.zuora.com/apps/PublicHostedPageLite.do * For EU Cloud Sandbox environment: Use https://sandbox.eu.zuora.com/apps/PublicHostedPageLite.do * For EU Central Sandbox environment: Use https://test.eu.zuora.com/apps/PublicHostedPageLite.do 
   * @return uri
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(example = "https://apisandbox.zuora.com/apps/PublicHostedPageLite.do", required = true, value = "The URL that the Payment Page will be served from. * For US Cloud 1 Production environment: Use https://na.zuora.com/apps/PublicHostedPageLite.do * For US Cloud 1 Sandbox environment: Use https://sandbox.na.zuora.com/apps/PublicHostedPageLite.do * For US Cloud 2 Production environment: Use https://www.zuora.com/apps/PublicHostedPageLite.do * For US Cloud 2 API Sandbox environment: Use https://apisandbox.zuora.com/apps/PublicHostedPageLite.do * For US Central Sandbox environment: Use https://test.zuora.com/apps/PublicHostedPageLite.do * For EU Cloud Production environment: Use https://eu.zuora.com/apps/PublicHostedPageLite.do * For EU Cloud Sandbox environment: Use https://sandbox.eu.zuora.com/apps/PublicHostedPageLite.do * For EU Central Sandbox environment: Use https://test.eu.zuora.com/apps/PublicHostedPageLite.do ")

  public String getUri() {
    return uri;
  }


  public void setUri(String uri) {
    
    
    
    this.uri = uri;
  }


  public POSTRSASignatureType useDefaultRetryRule(Boolean useDefaultRetryRule) {
    
    
    
    
    this.useDefaultRetryRule = useDefaultRetryRule;
    return this;
  }

   /**
   * An optional client parameter that can be used for validating client-side HPM parameters.  See [Client parameters for Payment Pages 2.0](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/LA_Hosted_Payment_Pages/B_Payment_Pages_2.0/J_Client_Parameters_for_Payment_Pages_2.0)  and [Validate client-side HPM parameters](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/LA_Hosted_Payment_Pages/B_Payment_Pages_2.0/F_Generate_the_Digital_Signature_for_Payment_Pages_2.0#Validate_Client-side_HPM_Parameters)  for details. 
   * @return useDefaultRetryRule
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "An optional client parameter that can be used for validating client-side HPM parameters.  See [Client parameters for Payment Pages 2.0](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/LA_Hosted_Payment_Pages/B_Payment_Pages_2.0/J_Client_Parameters_for_Payment_Pages_2.0)  and [Validate client-side HPM parameters](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/LA_Hosted_Payment_Pages/B_Payment_Pages_2.0/F_Generate_the_Digital_Signature_for_Payment_Pages_2.0#Validate_Client-side_HPM_Parameters)  for details. ")

  public Boolean getUseDefaultRetryRule() {
    return useDefaultRetryRule;
  }


  public void setUseDefaultRetryRule(Boolean useDefaultRetryRule) {
    
    
    
    this.useDefaultRetryRule = useDefaultRetryRule;
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
   * @return the POSTRSASignatureType instance itself
   */
  public POSTRSASignatureType putAdditionalProperty(String key, Object value) {
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
    POSTRSASignatureType poSTRSASignatureType = (POSTRSASignatureType) o;
    return Objects.equals(this.IBAN, poSTRSASignatureType.IBAN) &&
        Objects.equals(this.accountId, poSTRSASignatureType.accountId) &&
        Objects.equals(this.authorizationAmount, poSTRSASignatureType.authorizationAmount) &&
        Objects.equals(this.bankBranchCode, poSTRSASignatureType.bankBranchCode) &&
        Objects.equals(this.bankCheckDigit, poSTRSASignatureType.bankCheckDigit) &&
        Objects.equals(this.bankCity, poSTRSASignatureType.bankCity) &&
        Objects.equals(this.bankPostalCode, poSTRSASignatureType.bankPostalCode) &&
        Objects.equals(this.bankStreetName, poSTRSASignatureType.bankStreetName) &&
        Objects.equals(this.bankStreetNumber, poSTRSASignatureType.bankStreetNumber) &&
        Objects.equals(this.businessIdentificationCode, poSTRSASignatureType.businessIdentificationCode) &&
        Objects.equals(this.cityBlackList, poSTRSASignatureType.cityBlackList) &&
        Objects.equals(this.cityWhiteList, poSTRSASignatureType.cityWhiteList) &&
        Objects.equals(this.currency, poSTRSASignatureType.currency) &&
        Objects.equals(this.deviceSessionId, poSTRSASignatureType.deviceSessionId) &&
        Objects.equals(this.gatewayName, poSTRSASignatureType.gatewayName) &&
        Objects.equals(this.id, poSTRSASignatureType.id) &&
        Objects.equals(this.key, poSTRSASignatureType.key) &&
        Objects.equals(this.locale, poSTRSASignatureType.locale) &&
        Objects.equals(this.maxConsecutivePaymentFailures, poSTRSASignatureType.maxConsecutivePaymentFailures) &&
        Objects.equals(this.method, poSTRSASignatureType.method) &&
        Objects.equals(this.pageId, poSTRSASignatureType.pageId) &&
        Objects.equals(this.paramGwOptionsStarOptionStar, poSTRSASignatureType.paramGwOptionsStarOptionStar) &&
        Objects.equals(this.paramSupportedTypes, poSTRSASignatureType.paramSupportedTypes) &&
        Objects.equals(this.passthrough1Comma2Comma3Comma4Comma5, poSTRSASignatureType.passthrough1Comma2Comma3Comma4Comma5) &&
        Objects.equals(this.paymentGateway, poSTRSASignatureType.paymentGateway) &&
        Objects.equals(this.paymentRetryWindow, poSTRSASignatureType.paymentRetryWindow) &&
        Objects.equals(this.pmId, poSTRSASignatureType.pmId) &&
        Objects.equals(this.signature, poSTRSASignatureType.signature) &&
        Objects.equals(this.signatureType, poSTRSASignatureType.signatureType) &&
        Objects.equals(this.style, poSTRSASignatureType.style) &&
        Objects.equals(this.submitEnabled, poSTRSASignatureType.submitEnabled) &&
        Objects.equals(this.tenantId, poSTRSASignatureType.tenantId) &&
        Objects.equals(this.token, poSTRSASignatureType.token) &&
        Objects.equals(this.uri, poSTRSASignatureType.uri) &&
        Objects.equals(this.useDefaultRetryRule, poSTRSASignatureType.useDefaultRetryRule)&&
        Objects.equals(this.additionalProperties, poSTRSASignatureType.additionalProperties);
  }

  @Override
  public int hashCode() {
    return Objects.hash(IBAN, accountId, authorizationAmount, bankBranchCode, bankCheckDigit, bankCity, bankPostalCode, bankStreetName, bankStreetNumber, businessIdentificationCode, cityBlackList, cityWhiteList, currency, deviceSessionId, gatewayName, id, key, locale, maxConsecutivePaymentFailures, method, pageId, paramGwOptionsStarOptionStar, paramSupportedTypes, passthrough1Comma2Comma3Comma4Comma5, paymentGateway, paymentRetryWindow, pmId, signature, signatureType, style, submitEnabled, tenantId, token, uri, useDefaultRetryRule, additionalProperties);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class POSTRSASignatureType {\n");
    sb.append("    IBAN: ").append(toIndentedString(IBAN)).append("\n");
    sb.append("    accountId: ").append(toIndentedString(accountId)).append("\n");
    sb.append("    authorizationAmount: ").append(toIndentedString(authorizationAmount)).append("\n");
    sb.append("    bankBranchCode: ").append(toIndentedString(bankBranchCode)).append("\n");
    sb.append("    bankCheckDigit: ").append(toIndentedString(bankCheckDigit)).append("\n");
    sb.append("    bankCity: ").append(toIndentedString(bankCity)).append("\n");
    sb.append("    bankPostalCode: ").append(toIndentedString(bankPostalCode)).append("\n");
    sb.append("    bankStreetName: ").append(toIndentedString(bankStreetName)).append("\n");
    sb.append("    bankStreetNumber: ").append(toIndentedString(bankStreetNumber)).append("\n");
    sb.append("    businessIdentificationCode: ").append(toIndentedString(businessIdentificationCode)).append("\n");
    sb.append("    cityBlackList: ").append(toIndentedString(cityBlackList)).append("\n");
    sb.append("    cityWhiteList: ").append(toIndentedString(cityWhiteList)).append("\n");
    sb.append("    currency: ").append(toIndentedString(currency)).append("\n");
    sb.append("    deviceSessionId: ").append(toIndentedString(deviceSessionId)).append("\n");
    sb.append("    gatewayName: ").append(toIndentedString(gatewayName)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    key: ").append(toIndentedString(key)).append("\n");
    sb.append("    locale: ").append(toIndentedString(locale)).append("\n");
    sb.append("    maxConsecutivePaymentFailures: ").append(toIndentedString(maxConsecutivePaymentFailures)).append("\n");
    sb.append("    method: ").append(toIndentedString(method)).append("\n");
    sb.append("    pageId: ").append(toIndentedString(pageId)).append("\n");
    sb.append("    paramGwOptionsStarOptionStar: ").append(toIndentedString(paramGwOptionsStarOptionStar)).append("\n");
    sb.append("    paramSupportedTypes: ").append(toIndentedString(paramSupportedTypes)).append("\n");
    sb.append("    passthrough1Comma2Comma3Comma4Comma5: ").append(toIndentedString(passthrough1Comma2Comma3Comma4Comma5)).append("\n");
    sb.append("    paymentGateway: ").append(toIndentedString(paymentGateway)).append("\n");
    sb.append("    paymentRetryWindow: ").append(toIndentedString(paymentRetryWindow)).append("\n");
    sb.append("    pmId: ").append(toIndentedString(pmId)).append("\n");
    sb.append("    signature: ").append(toIndentedString(signature)).append("\n");
    sb.append("    signatureType: ").append(toIndentedString(signatureType)).append("\n");
    sb.append("    style: ").append(toIndentedString(style)).append("\n");
    sb.append("    submitEnabled: ").append(toIndentedString(submitEnabled)).append("\n");
    sb.append("    tenantId: ").append(toIndentedString(tenantId)).append("\n");
    sb.append("    token: ").append(toIndentedString(token)).append("\n");
    sb.append("    uri: ").append(toIndentedString(uri)).append("\n");
    sb.append("    useDefaultRetryRule: ").append(toIndentedString(useDefaultRetryRule)).append("\n");
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
    openapiFields.add("IBAN");
    openapiFields.add("accountId");
    openapiFields.add("authorizationAmount");
    openapiFields.add("bankBranchCode");
    openapiFields.add("bankCheckDigit");
    openapiFields.add("bankCity");
    openapiFields.add("bankPostalCode");
    openapiFields.add("bankStreetName");
    openapiFields.add("bankStreetNumber");
    openapiFields.add("businessIdentificationCode");
    openapiFields.add("cityBlackList");
    openapiFields.add("cityWhiteList");
    openapiFields.add("currency");
    openapiFields.add("deviceSessionId");
    openapiFields.add("gatewayName");
    openapiFields.add("id");
    openapiFields.add("key");
    openapiFields.add("locale");
    openapiFields.add("maxConsecutivePaymentFailures");
    openapiFields.add("method");
    openapiFields.add("pageId");
    openapiFields.add("param_gwOptions_[*option*]");
    openapiFields.add("param_supportedTypes");
    openapiFields.add("passthrough[1,2,3,4,5]");
    openapiFields.add("paymentGateway");
    openapiFields.add("paymentRetryWindow");
    openapiFields.add("pmId");
    openapiFields.add("signature");
    openapiFields.add("signatureType");
    openapiFields.add("style");
    openapiFields.add("submitEnabled");
    openapiFields.add("tenantId");
    openapiFields.add("token");
    openapiFields.add("uri");
    openapiFields.add("useDefaultRetryRule");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
    openapiRequiredFields.add("method");
    openapiRequiredFields.add("pageId");
    openapiRequiredFields.add("uri");
  }

 /**
  * Validates the JSON Object and throws an exception if issues found
  *
  * @param jsonObj JSON Object
  * @throws IOException if the JSON Object is invalid with respect to POSTRSASignatureType
  */
  public static void validateJsonObject(JsonObject jsonObj) throws IOException {
      if (jsonObj == null) {
        if (!POSTRSASignatureType.openapiRequiredFields.isEmpty()) { // has required fields but JSON object is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in POSTRSASignatureType is not found in the empty JSON string", POSTRSASignatureType.openapiRequiredFields.toString()));
        }
      }

      // check to make sure all required properties/fields are present in the JSON string
      for (String requiredField : POSTRSASignatureType.openapiRequiredFields) {
        if (jsonObj.get(requiredField) == null) {
          throw new IllegalArgumentException(String.format("The required field `%s` is not found in the JSON string: %s", requiredField, jsonObj.toString()));
        }
      }
      if ((jsonObj.get("IBAN") != null && !jsonObj.get("IBAN").isJsonNull()) && !jsonObj.get("IBAN").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `IBAN` to be a primitive type in the JSON string but got `%s`", jsonObj.get("IBAN").toString()));
      }
      if ((jsonObj.get("accountId") != null && !jsonObj.get("accountId").isJsonNull()) && !jsonObj.get("accountId").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `accountId` to be a primitive type in the JSON string but got `%s`", jsonObj.get("accountId").toString()));
      }
      if ((jsonObj.get("bankBranchCode") != null && !jsonObj.get("bankBranchCode").isJsonNull()) && !jsonObj.get("bankBranchCode").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `bankBranchCode` to be a primitive type in the JSON string but got `%s`", jsonObj.get("bankBranchCode").toString()));
      }
      if ((jsonObj.get("bankCheckDigit") != null && !jsonObj.get("bankCheckDigit").isJsonNull()) && !jsonObj.get("bankCheckDigit").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `bankCheckDigit` to be a primitive type in the JSON string but got `%s`", jsonObj.get("bankCheckDigit").toString()));
      }
      if ((jsonObj.get("bankCity") != null && !jsonObj.get("bankCity").isJsonNull()) && !jsonObj.get("bankCity").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `bankCity` to be a primitive type in the JSON string but got `%s`", jsonObj.get("bankCity").toString()));
      }
      if ((jsonObj.get("bankPostalCode") != null && !jsonObj.get("bankPostalCode").isJsonNull()) && !jsonObj.get("bankPostalCode").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `bankPostalCode` to be a primitive type in the JSON string but got `%s`", jsonObj.get("bankPostalCode").toString()));
      }
      if ((jsonObj.get("bankStreetName") != null && !jsonObj.get("bankStreetName").isJsonNull()) && !jsonObj.get("bankStreetName").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `bankStreetName` to be a primitive type in the JSON string but got `%s`", jsonObj.get("bankStreetName").toString()));
      }
      if ((jsonObj.get("bankStreetNumber") != null && !jsonObj.get("bankStreetNumber").isJsonNull()) && !jsonObj.get("bankStreetNumber").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `bankStreetNumber` to be a primitive type in the JSON string but got `%s`", jsonObj.get("bankStreetNumber").toString()));
      }
      if ((jsonObj.get("businessIdentificationCode") != null && !jsonObj.get("businessIdentificationCode").isJsonNull()) && !jsonObj.get("businessIdentificationCode").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `businessIdentificationCode` to be a primitive type in the JSON string but got `%s`", jsonObj.get("businessIdentificationCode").toString()));
      }
      if ((jsonObj.get("cityBlackList") != null && !jsonObj.get("cityBlackList").isJsonNull()) && !jsonObj.get("cityBlackList").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `cityBlackList` to be a primitive type in the JSON string but got `%s`", jsonObj.get("cityBlackList").toString()));
      }
      if ((jsonObj.get("cityWhiteList") != null && !jsonObj.get("cityWhiteList").isJsonNull()) && !jsonObj.get("cityWhiteList").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `cityWhiteList` to be a primitive type in the JSON string but got `%s`", jsonObj.get("cityWhiteList").toString()));
      }
      if ((jsonObj.get("currency") != null && !jsonObj.get("currency").isJsonNull()) && !jsonObj.get("currency").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `currency` to be a primitive type in the JSON string but got `%s`", jsonObj.get("currency").toString()));
      }
      if ((jsonObj.get("deviceSessionId") != null && !jsonObj.get("deviceSessionId").isJsonNull()) && !jsonObj.get("deviceSessionId").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `deviceSessionId` to be a primitive type in the JSON string but got `%s`", jsonObj.get("deviceSessionId").toString()));
      }
      if ((jsonObj.get("gatewayName") != null && !jsonObj.get("gatewayName").isJsonNull()) && !jsonObj.get("gatewayName").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `gatewayName` to be a primitive type in the JSON string but got `%s`", jsonObj.get("gatewayName").toString()));
      }
      if ((jsonObj.get("id") != null && !jsonObj.get("id").isJsonNull()) && !jsonObj.get("id").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `id` to be a primitive type in the JSON string but got `%s`", jsonObj.get("id").toString()));
      }
      if ((jsonObj.get("key") != null && !jsonObj.get("key").isJsonNull()) && !jsonObj.get("key").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `key` to be a primitive type in the JSON string but got `%s`", jsonObj.get("key").toString()));
      }
      if ((jsonObj.get("locale") != null && !jsonObj.get("locale").isJsonNull()) && !jsonObj.get("locale").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `locale` to be a primitive type in the JSON string but got `%s`", jsonObj.get("locale").toString()));
      }
      if (!jsonObj.get("method").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `method` to be a primitive type in the JSON string but got `%s`", jsonObj.get("method").toString()));
      }
      if (!jsonObj.get("pageId").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `pageId` to be a primitive type in the JSON string but got `%s`", jsonObj.get("pageId").toString()));
      }
      if ((jsonObj.get("param_gwOptions_[*option*]") != null && !jsonObj.get("param_gwOptions_[*option*]").isJsonNull()) && !jsonObj.get("param_gwOptions_[*option*]").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `param_gwOptions_[*option*]` to be a primitive type in the JSON string but got `%s`", jsonObj.get("param_gwOptions_[*option*]").toString()));
      }
      if ((jsonObj.get("param_supportedTypes") != null && !jsonObj.get("param_supportedTypes").isJsonNull()) && !jsonObj.get("param_supportedTypes").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `param_supportedTypes` to be a primitive type in the JSON string but got `%s`", jsonObj.get("param_supportedTypes").toString()));
      }
      if ((jsonObj.get("passthrough[1,2,3,4,5]") != null && !jsonObj.get("passthrough[1,2,3,4,5]").isJsonNull()) && !jsonObj.get("passthrough[1,2,3,4,5]").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `passthrough[1,2,3,4,5]` to be a primitive type in the JSON string but got `%s`", jsonObj.get("passthrough[1,2,3,4,5]").toString()));
      }
      if ((jsonObj.get("paymentGateway") != null && !jsonObj.get("paymentGateway").isJsonNull()) && !jsonObj.get("paymentGateway").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `paymentGateway` to be a primitive type in the JSON string but got `%s`", jsonObj.get("paymentGateway").toString()));
      }
      if ((jsonObj.get("pmId") != null && !jsonObj.get("pmId").isJsonNull()) && !jsonObj.get("pmId").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `pmId` to be a primitive type in the JSON string but got `%s`", jsonObj.get("pmId").toString()));
      }
      if ((jsonObj.get("signature") != null && !jsonObj.get("signature").isJsonNull()) && !jsonObj.get("signature").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `signature` to be a primitive type in the JSON string but got `%s`", jsonObj.get("signature").toString()));
      }
      if ((jsonObj.get("signatureType") != null && !jsonObj.get("signatureType").isJsonNull()) && !jsonObj.get("signatureType").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `signatureType` to be a primitive type in the JSON string but got `%s`", jsonObj.get("signatureType").toString()));
      }
      if ((jsonObj.get("style") != null && !jsonObj.get("style").isJsonNull()) && !jsonObj.get("style").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `style` to be a primitive type in the JSON string but got `%s`", jsonObj.get("style").toString()));
      }
      if ((jsonObj.get("tenantId") != null && !jsonObj.get("tenantId").isJsonNull()) && !jsonObj.get("tenantId").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `tenantId` to be a primitive type in the JSON string but got `%s`", jsonObj.get("tenantId").toString()));
      }
      if ((jsonObj.get("token") != null && !jsonObj.get("token").isJsonNull()) && !jsonObj.get("token").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `token` to be a primitive type in the JSON string but got `%s`", jsonObj.get("token").toString()));
      }
      if (!jsonObj.get("uri").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `uri` to be a primitive type in the JSON string but got `%s`", jsonObj.get("uri").toString()));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!POSTRSASignatureType.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'POSTRSASignatureType' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<POSTRSASignatureType> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(POSTRSASignatureType.class));

       return (TypeAdapter<T>) new TypeAdapter<POSTRSASignatureType>() {
           @Override
           public void write(JsonWriter out, POSTRSASignatureType value) throws IOException {
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
           public POSTRSASignatureType read(JsonReader in) throws IOException {
             JsonObject jsonObj = elementAdapter.read(in).getAsJsonObject();
             validateJsonObject(jsonObj);
             // store additional fields in the deserialized instance
             POSTRSASignatureType instance = thisAdapter.fromJsonTree(jsonObj);
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
  * Create an instance of POSTRSASignatureType given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of POSTRSASignatureType
  * @throws IOException if the JSON string is invalid with respect to POSTRSASignatureType
  */
  public static POSTRSASignatureType fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, POSTRSASignatureType.class);
  }

 /**
  * Convert an instance of POSTRSASignatureType to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

