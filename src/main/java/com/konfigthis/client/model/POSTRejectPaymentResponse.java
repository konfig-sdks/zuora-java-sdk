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
import com.konfigthis.client.model.POSTReversePaymentResponseFinanceInformation;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
import java.time.LocalDate;
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
 * POSTRejectPaymentResponse
 */@javax.annotation.Generated(value = "Generated by https://konfigthis.com")
public class POSTRejectPaymentResponse {
  public static final String SERIALIZED_NAME_ACCOUNT_ID = "accountId";
  @SerializedName(SERIALIZED_NAME_ACCOUNT_ID)
  private String accountId;

  public static final String SERIALIZED_NAME_AMOUNT = "amount";
  @SerializedName(SERIALIZED_NAME_AMOUNT)
  private Double amount;

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

  public static final String SERIALIZED_NAME_CREDIT_MEMO_ID = "creditMemoId";
  @SerializedName(SERIALIZED_NAME_CREDIT_MEMO_ID)
  private String creditMemoId;

  public static final String SERIALIZED_NAME_FINANCE_INFORMATION = "financeInformation";
  @SerializedName(SERIALIZED_NAME_FINANCE_INFORMATION)
  private POSTReversePaymentResponseFinanceInformation financeInformation;

  public static final String SERIALIZED_NAME_GATEWAY_ID = "gatewayId";
  @SerializedName(SERIALIZED_NAME_GATEWAY_ID)
  private String gatewayId;

  public static final String SERIALIZED_NAME_GATEWAY_RECONCILIATION_REASON = "gatewayReconciliationReason";
  @SerializedName(SERIALIZED_NAME_GATEWAY_RECONCILIATION_REASON)
  private String gatewayReconciliationReason;

  public static final String SERIALIZED_NAME_GATEWAY_RECONCILIATION_STATUS = "gatewayReconciliationStatus";
  @SerializedName(SERIALIZED_NAME_GATEWAY_RECONCILIATION_STATUS)
  private String gatewayReconciliationStatus;

  public static final String SERIALIZED_NAME_GATEWAY_RESPONSE = "gatewayResponse";
  @SerializedName(SERIALIZED_NAME_GATEWAY_RESPONSE)
  private String gatewayResponse;

  public static final String SERIALIZED_NAME_GATEWAY_RESPONSE_CODE = "gatewayResponseCode";
  @SerializedName(SERIALIZED_NAME_GATEWAY_RESPONSE_CODE)
  private String gatewayResponseCode;

  /**
   * The status of the payment in the gateway; specifically used for reconciliation. 
   */
  @JsonAdapter(GatewayStateEnum.Adapter.class)
 public enum GatewayStateEnum {
    SUBMITTED("Submitted"),
    
    NOTSUBMITTED("NotSubmitted"),
    
    SETTLED("Settled"),
    
    FAILEDTOSETTLE("FailedToSettle");

    private String value;

    GatewayStateEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static GatewayStateEnum fromValue(String value) {
      for (GatewayStateEnum b : GatewayStateEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<GatewayStateEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final GatewayStateEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public GatewayStateEnum read(final JsonReader jsonReader) throws IOException {
        String value =  jsonReader.nextString();
        return GatewayStateEnum.fromValue(value);
      }
    }
  }

  public static final String SERIALIZED_NAME_GATEWAY_STATE = "gatewayState";
  @SerializedName(SERIALIZED_NAME_GATEWAY_STATE)
  private GatewayStateEnum gatewayState;

  public static final String SERIALIZED_NAME_ID = "id";
  @SerializedName(SERIALIZED_NAME_ID)
  private String id;

  public static final String SERIALIZED_NAME_MARKED_FOR_SUBMISSION_ON = "markedForSubmissionOn";
  @SerializedName(SERIALIZED_NAME_MARKED_FOR_SUBMISSION_ON)
  private OffsetDateTime markedForSubmissionOn;

  /**
   * How an external refund was issued to a customer.  
   */
  @JsonAdapter(MethodTypeEnum.Adapter.class)
 public enum MethodTypeEnum {
    ACH("ACH"),
    
    CASH("Cash"),
    
    CHECK("Check"),
    
    CREDITCARD("CreditCard"),
    
    PAYPAL("PayPal"),
    
    WIRETRANSFER("WireTransfer"),
    
    DEBITCARD("DebitCard"),
    
    CREDITCARDREFERENCETRANSACTION("CreditCardReferenceTransaction"),
    
    BANKTRANSFER("BankTransfer"),
    
    OTHER("Other");

    private String value;

    MethodTypeEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static MethodTypeEnum fromValue(String value) {
      for (MethodTypeEnum b : MethodTypeEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<MethodTypeEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final MethodTypeEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public MethodTypeEnum read(final JsonReader jsonReader) throws IOException {
        String value =  jsonReader.nextString();
        return MethodTypeEnum.fromValue(value);
      }
    }
  }

  public static final String SERIALIZED_NAME_METHOD_TYPE = "methodType";
  @SerializedName(SERIALIZED_NAME_METHOD_TYPE)
  private MethodTypeEnum methodType;

  public static final String SERIALIZED_NAME_NUMBER = "number";
  @SerializedName(SERIALIZED_NAME_NUMBER)
  private String number;

  public static final String SERIALIZED_NAME_ORGANIZATION_LABEL = "organizationLabel";
  @SerializedName(SERIALIZED_NAME_ORGANIZATION_LABEL)
  private String organizationLabel;

  public static final String SERIALIZED_NAME_PAYMENT_ID = "paymentId";
  @SerializedName(SERIALIZED_NAME_PAYMENT_ID)
  private String paymentId;

  public static final String SERIALIZED_NAME_PAYMENT_METHOD_ID = "paymentMethodId";
  @SerializedName(SERIALIZED_NAME_PAYMENT_METHOD_ID)
  private String paymentMethodId;

  public static final String SERIALIZED_NAME_PAYMENT_METHOD_SNAPSHOT_ID = "paymentMethodSnapshotId";
  @SerializedName(SERIALIZED_NAME_PAYMENT_METHOD_SNAPSHOT_ID)
  private String paymentMethodSnapshotId;

  public static final String SERIALIZED_NAME_PAYOUT_ID = "payoutId";
  @SerializedName(SERIALIZED_NAME_PAYOUT_ID)
  private String payoutId;

  public static final String SERIALIZED_NAME_REASON_CODE = "reasonCode";
  @SerializedName(SERIALIZED_NAME_REASON_CODE)
  private String reasonCode;

  public static final String SERIALIZED_NAME_REFERENCE_ID = "referenceId";
  @SerializedName(SERIALIZED_NAME_REFERENCE_ID)
  private String referenceId;

  public static final String SERIALIZED_NAME_REFUND_DATE = "refundDate";
  @SerializedName(SERIALIZED_NAME_REFUND_DATE)
  private LocalDate refundDate;

  public static final String SERIALIZED_NAME_REFUND_TRANSACTION_TIME = "refundTransactionTime";
  @SerializedName(SERIALIZED_NAME_REFUND_TRANSACTION_TIME)
  private OffsetDateTime refundTransactionTime;

  public static final String SERIALIZED_NAME_SECOND_REFUND_REFERENCE_ID = "secondRefundReferenceId";
  @SerializedName(SERIALIZED_NAME_SECOND_REFUND_REFERENCE_ID)
  private String secondRefundReferenceId;

  public static final String SERIALIZED_NAME_SETTLED_ON = "settledOn";
  @SerializedName(SERIALIZED_NAME_SETTLED_ON)
  private OffsetDateTime settledOn;

  public static final String SERIALIZED_NAME_SOFT_DESCRIPTOR = "softDescriptor";
  @SerializedName(SERIALIZED_NAME_SOFT_DESCRIPTOR)
  private String softDescriptor;

  public static final String SERIALIZED_NAME_SOFT_DESCRIPTOR_PHONE = "softDescriptorPhone";
  @SerializedName(SERIALIZED_NAME_SOFT_DESCRIPTOR_PHONE)
  private String softDescriptorPhone;

  public static final String SERIALIZED_NAME_STATUS = "status";
  @SerializedName(SERIALIZED_NAME_STATUS)
  private String status;

  public static final String SERIALIZED_NAME_SUBMITTED_ON = "submittedOn";
  @SerializedName(SERIALIZED_NAME_SUBMITTED_ON)
  private OffsetDateTime submittedOn;

  public static final String SERIALIZED_NAME_SUCCESS = "success";
  @SerializedName(SERIALIZED_NAME_SUCCESS)
  private Boolean success;

  /**
   * The type of the payment. 
   */
  @JsonAdapter(TypeEnum.Adapter.class)
 public enum TypeEnum {
    EXTERNAL("External"),
    
    ELECTRONIC("Electronic");

    private String value;

    TypeEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static TypeEnum fromValue(String value) {
      for (TypeEnum b : TypeEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<TypeEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final TypeEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public TypeEnum read(final JsonReader jsonReader) throws IOException {
        String value =  jsonReader.nextString();
        return TypeEnum.fromValue(value);
      }
    }
  }

  public static final String SERIALIZED_NAME_TYPE = "type";
  @SerializedName(SERIALIZED_NAME_TYPE)
  private TypeEnum type;

  public static final String SERIALIZED_NAME_UPDATED_BY_ID = "updatedById";
  @SerializedName(SERIALIZED_NAME_UPDATED_BY_ID)
  private String updatedById;

  public static final String SERIALIZED_NAME_UPDATED_DATE = "updatedDate";
  @SerializedName(SERIALIZED_NAME_UPDATED_DATE)
  private OffsetDateTime updatedDate;

  public POSTRejectPaymentResponse() {
  }

  public POSTRejectPaymentResponse accountId(String accountId) {
    
    
    
    
    this.accountId = accountId;
    return this;
  }

   /**
   * The ID of the customer account that the payment is for. 
   * @return accountId
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The ID of the customer account that the payment is for. ")

  public String getAccountId() {
    return accountId;
  }


  public void setAccountId(String accountId) {
    
    
    
    this.accountId = accountId;
  }


  public POSTRejectPaymentResponse amount(Double amount) {
    
    
    
    
    this.amount = amount;
    return this;
  }

   /**
   * The total amount of the payment. 
   * @return amount
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The total amount of the payment. ")

  public Double getAmount() {
    return amount;
  }


  public void setAmount(Double amount) {
    
    
    
    this.amount = amount;
  }


  public POSTRejectPaymentResponse cancelledOn(OffsetDateTime cancelledOn) {
    
    
    
    
    this.cancelledOn = cancelledOn;
    return this;
  }

   /**
   * The date and time when the payment was cancelled, in &#x60;yyyy-mm-dd hh:mm:ss&#x60; format. 
   * @return cancelledOn
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The date and time when the payment was cancelled, in `yyyy-mm-dd hh:mm:ss` format. ")

  public OffsetDateTime getCancelledOn() {
    return cancelledOn;
  }


  public void setCancelledOn(OffsetDateTime cancelledOn) {
    
    
    
    this.cancelledOn = cancelledOn;
  }


  public POSTRejectPaymentResponse comment(String comment) {
    
    
    
    
    this.comment = comment;
    return this;
  }

   /**
   * Comments about the payment. 
   * @return comment
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Comments about the payment. ")

  public String getComment() {
    return comment;
  }


  public void setComment(String comment) {
    
    
    
    this.comment = comment;
  }


  public POSTRejectPaymentResponse createdById(String createdById) {
    
    
    
    
    this.createdById = createdById;
    return this;
  }

   /**
   * The ID of the Zuora user who created the refund. 
   * @return createdById
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The ID of the Zuora user who created the refund. ")

  public String getCreatedById() {
    return createdById;
  }


  public void setCreatedById(String createdById) {
    
    
    
    this.createdById = createdById;
  }


  public POSTRejectPaymentResponse createdDate(OffsetDateTime createdDate) {
    
    
    
    
    this.createdDate = createdDate;
    return this;
  }

   /**
   * The date and time when the chargeback is created, in &#x60;yyyy-mm-dd hh:mm:ss&#x60; format. For example, 2019-03-01 15:31:10. 
   * @return createdDate
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The date and time when the chargeback is created, in `yyyy-mm-dd hh:mm:ss` format. For example, 2019-03-01 15:31:10. ")

  public OffsetDateTime getCreatedDate() {
    return createdDate;
  }


  public void setCreatedDate(OffsetDateTime createdDate) {
    
    
    
    this.createdDate = createdDate;
  }


  public POSTRejectPaymentResponse creditMemoId(String creditMemoId) {
    
    
    
    
    this.creditMemoId = creditMemoId;
    return this;
  }

   /**
   * The ID of the credit memo that is refunded. 
   * @return creditMemoId
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The ID of the credit memo that is refunded. ")

  public String getCreditMemoId() {
    return creditMemoId;
  }


  public void setCreditMemoId(String creditMemoId) {
    
    
    
    this.creditMemoId = creditMemoId;
  }


  public POSTRejectPaymentResponse financeInformation(POSTReversePaymentResponseFinanceInformation financeInformation) {
    
    
    
    
    this.financeInformation = financeInformation;
    return this;
  }

   /**
   * Get financeInformation
   * @return financeInformation
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public POSTReversePaymentResponseFinanceInformation getFinanceInformation() {
    return financeInformation;
  }


  public void setFinanceInformation(POSTReversePaymentResponseFinanceInformation financeInformation) {
    
    
    
    this.financeInformation = financeInformation;
  }


  public POSTRejectPaymentResponse gatewayId(String gatewayId) {
    
    
    
    
    this.gatewayId = gatewayId;
    return this;
  }

   /**
   * The ID of the gateway instance that processes the payment. 
   * @return gatewayId
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The ID of the gateway instance that processes the payment. ")

  public String getGatewayId() {
    return gatewayId;
  }


  public void setGatewayId(String gatewayId) {
    
    
    
    this.gatewayId = gatewayId;
  }


  public POSTRejectPaymentResponse gatewayReconciliationReason(String gatewayReconciliationReason) {
    
    
    
    
    this.gatewayReconciliationReason = gatewayReconciliationReason;
    return this;
  }

   /**
   * The reason of gateway reconciliation. 
   * @return gatewayReconciliationReason
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The reason of gateway reconciliation. ")

  public String getGatewayReconciliationReason() {
    return gatewayReconciliationReason;
  }


  public void setGatewayReconciliationReason(String gatewayReconciliationReason) {
    
    
    
    this.gatewayReconciliationReason = gatewayReconciliationReason;
  }


  public POSTRejectPaymentResponse gatewayReconciliationStatus(String gatewayReconciliationStatus) {
    
    
    
    
    this.gatewayReconciliationStatus = gatewayReconciliationStatus;
    return this;
  }

   /**
   * The status of gateway reconciliation. 
   * @return gatewayReconciliationStatus
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The status of gateway reconciliation. ")

  public String getGatewayReconciliationStatus() {
    return gatewayReconciliationStatus;
  }


  public void setGatewayReconciliationStatus(String gatewayReconciliationStatus) {
    
    
    
    this.gatewayReconciliationStatus = gatewayReconciliationStatus;
  }


  public POSTRejectPaymentResponse gatewayResponse(String gatewayResponse) {
    
    
    
    
    this.gatewayResponse = gatewayResponse;
    return this;
  }

   /**
   * The message returned from the payment gateway for the payment. This message is gateway-dependent. 
   * @return gatewayResponse
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The message returned from the payment gateway for the payment. This message is gateway-dependent. ")

  public String getGatewayResponse() {
    return gatewayResponse;
  }


  public void setGatewayResponse(String gatewayResponse) {
    
    
    
    this.gatewayResponse = gatewayResponse;
  }


  public POSTRejectPaymentResponse gatewayResponseCode(String gatewayResponseCode) {
    
    
    
    
    this.gatewayResponseCode = gatewayResponseCode;
    return this;
  }

   /**
   * The code returned from the payment gateway for the payment. This code is gateway-dependent. 
   * @return gatewayResponseCode
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The code returned from the payment gateway for the payment. This code is gateway-dependent. ")

  public String getGatewayResponseCode() {
    return gatewayResponseCode;
  }


  public void setGatewayResponseCode(String gatewayResponseCode) {
    
    
    
    this.gatewayResponseCode = gatewayResponseCode;
  }


  public POSTRejectPaymentResponse gatewayState(GatewayStateEnum gatewayState) {
    
    
    
    
    this.gatewayState = gatewayState;
    return this;
  }

   /**
   * The status of the payment in the gateway; specifically used for reconciliation. 
   * @return gatewayState
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The status of the payment in the gateway; specifically used for reconciliation. ")

  public GatewayStateEnum getGatewayState() {
    return gatewayState;
  }


  public void setGatewayState(GatewayStateEnum gatewayState) {
    
    
    
    this.gatewayState = gatewayState;
  }


  public POSTRejectPaymentResponse id(String id) {
    
    
    
    
    this.id = id;
    return this;
  }

   /**
   * The ID of the payment chargeback. 
   * @return id
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The ID of the payment chargeback. ")

  public String getId() {
    return id;
  }


  public void setId(String id) {
    
    
    
    this.id = id;
  }


  public POSTRejectPaymentResponse markedForSubmissionOn(OffsetDateTime markedForSubmissionOn) {
    
    
    
    
    this.markedForSubmissionOn = markedForSubmissionOn;
    return this;
  }

   /**
   * The date and time when a charge was marked and waiting for batch submission to the payment process, in &#x60;yyyy-mm-dd hh:mm:ss&#x60; format. 
   * @return markedForSubmissionOn
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The date and time when a charge was marked and waiting for batch submission to the payment process, in `yyyy-mm-dd hh:mm:ss` format. ")

  public OffsetDateTime getMarkedForSubmissionOn() {
    return markedForSubmissionOn;
  }


  public void setMarkedForSubmissionOn(OffsetDateTime markedForSubmissionOn) {
    
    
    
    this.markedForSubmissionOn = markedForSubmissionOn;
  }


  public POSTRejectPaymentResponse methodType(MethodTypeEnum methodType) {
    
    
    
    
    this.methodType = methodType;
    return this;
  }

   /**
   * How an external refund was issued to a customer.  
   * @return methodType
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "How an external refund was issued to a customer.  ")

  public MethodTypeEnum getMethodType() {
    return methodType;
  }


  public void setMethodType(MethodTypeEnum methodType) {
    
    
    
    this.methodType = methodType;
  }


  public POSTRejectPaymentResponse number(String number) {
    
    
    
    
    this.number = number;
    return this;
  }

   /**
   * The unique identification number of the payment. For example, P-00000001. 
   * @return number
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The unique identification number of the payment. For example, P-00000001. ")

  public String getNumber() {
    return number;
  }


  public void setNumber(String number) {
    
    
    
    this.number = number;
  }


  public POSTRejectPaymentResponse organizationLabel(String organizationLabel) {
    
    
    
    
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


  public POSTRejectPaymentResponse paymentId(String paymentId) {
    
    
    
    
    this.paymentId = paymentId;
    return this;
  }

   /**
   * The ID of the payment that is refunded. 
   * @return paymentId
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The ID of the payment that is refunded. ")

  public String getPaymentId() {
    return paymentId;
  }


  public void setPaymentId(String paymentId) {
    
    
    
    this.paymentId = paymentId;
  }


  public POSTRejectPaymentResponse paymentMethodId(String paymentMethodId) {
    
    
    
    
    this.paymentMethodId = paymentMethodId;
    return this;
  }

   /**
   * The unique ID of the payment method that the customer used to make the payment. 
   * @return paymentMethodId
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The unique ID of the payment method that the customer used to make the payment. ")

  public String getPaymentMethodId() {
    return paymentMethodId;
  }


  public void setPaymentMethodId(String paymentMethodId) {
    
    
    
    this.paymentMethodId = paymentMethodId;
  }


  public POSTRejectPaymentResponse paymentMethodSnapshotId(String paymentMethodSnapshotId) {
    
    
    
    
    this.paymentMethodSnapshotId = paymentMethodSnapshotId;
    return this;
  }

   /**
   * The unique ID of the payment method snapshot which is a copy of the particular Payment Method used in a transaction. 
   * @return paymentMethodSnapshotId
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The unique ID of the payment method snapshot which is a copy of the particular Payment Method used in a transaction. ")

  public String getPaymentMethodSnapshotId() {
    return paymentMethodSnapshotId;
  }


  public void setPaymentMethodSnapshotId(String paymentMethodSnapshotId) {
    
    
    
    this.paymentMethodSnapshotId = paymentMethodSnapshotId;
  }


  public POSTRejectPaymentResponse payoutId(String payoutId) {
    
    
    
    
    this.payoutId = payoutId;
    return this;
  }

   /**
   * The payout ID from the gateway side. 
   * @return payoutId
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The payout ID from the gateway side. ")

  public String getPayoutId() {
    return payoutId;
  }


  public void setPayoutId(String payoutId) {
    
    
    
    this.payoutId = payoutId;
  }


  public POSTRejectPaymentResponse reasonCode(String reasonCode) {
    
    
    
    
    this.reasonCode = reasonCode;
    return this;
  }

   /**
   * A code identifying the reason for the transaction.       
   * @return reasonCode
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "A code identifying the reason for the transaction.       ")

  public String getReasonCode() {
    return reasonCode;
  }


  public void setReasonCode(String reasonCode) {
    
    
    
    this.reasonCode = reasonCode;
  }


  public POSTRejectPaymentResponse referenceId(String referenceId) {
    
    
    
    
    this.referenceId = referenceId;
    return this;
  }

   /**
   * The transaction ID returned by the payment gateway for an electronic refund. Use this field to reconcile refunds between your gateway and Zuora Payments. 
   * @return referenceId
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The transaction ID returned by the payment gateway for an electronic refund. Use this field to reconcile refunds between your gateway and Zuora Payments. ")

  public String getReferenceId() {
    return referenceId;
  }


  public void setReferenceId(String referenceId) {
    
    
    
    this.referenceId = referenceId;
  }


  public POSTRejectPaymentResponse refundDate(LocalDate refundDate) {
    
    
    
    
    this.refundDate = refundDate;
    return this;
  }

   /**
   * The date when the refund takes effect, in &#x60;yyyy-mm-dd&#x60; format. For example, 2017-03-01.        
   * @return refundDate
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The date when the refund takes effect, in `yyyy-mm-dd` format. For example, 2017-03-01.        ")

  public LocalDate getRefundDate() {
    return refundDate;
  }


  public void setRefundDate(LocalDate refundDate) {
    
    
    
    this.refundDate = refundDate;
  }


  public POSTRejectPaymentResponse refundTransactionTime(OffsetDateTime refundTransactionTime) {
    
    
    
    
    this.refundTransactionTime = refundTransactionTime;
    return this;
  }

   /**
   * The date and time when the refund was issued, in &#x60;yyyy-mm-dd hh:mm:ss&#x60; format. 
   * @return refundTransactionTime
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The date and time when the refund was issued, in `yyyy-mm-dd hh:mm:ss` format. ")

  public OffsetDateTime getRefundTransactionTime() {
    return refundTransactionTime;
  }


  public void setRefundTransactionTime(OffsetDateTime refundTransactionTime) {
    
    
    
    this.refundTransactionTime = refundTransactionTime;
  }


  public POSTRejectPaymentResponse secondRefundReferenceId(String secondRefundReferenceId) {
    
    
    
    
    this.secondRefundReferenceId = secondRefundReferenceId;
    return this;
  }

   /**
   * The transaction ID returned by the payment gateway if there is an additional refund.  
   * @return secondRefundReferenceId
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The transaction ID returned by the payment gateway if there is an additional refund.  ")

  public String getSecondRefundReferenceId() {
    return secondRefundReferenceId;
  }


  public void setSecondRefundReferenceId(String secondRefundReferenceId) {
    
    
    
    this.secondRefundReferenceId = secondRefundReferenceId;
  }


  public POSTRejectPaymentResponse settledOn(OffsetDateTime settledOn) {
    
    
    
    
    this.settledOn = settledOn;
    return this;
  }

   /**
   * The date and time when the transaction is settled, in &#x60;yyyy-mm-dd hh:mm:ss&#x60; format. 
   * @return settledOn
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The date and time when the transaction is settled, in `yyyy-mm-dd hh:mm:ss` format. ")

  public OffsetDateTime getSettledOn() {
    return settledOn;
  }


  public void setSettledOn(OffsetDateTime settledOn) {
    
    
    
    this.settledOn = settledOn;
  }


  public POSTRejectPaymentResponse softDescriptor(String softDescriptor) {
    
    
    
    
    this.softDescriptor = softDescriptor;
    return this;
  }

   /**
   * A payment gateway-specific field that maps Zuora to other gateways. 
   * @return softDescriptor
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "A payment gateway-specific field that maps Zuora to other gateways. ")

  public String getSoftDescriptor() {
    return softDescriptor;
  }


  public void setSoftDescriptor(String softDescriptor) {
    
    
    
    this.softDescriptor = softDescriptor;
  }


  public POSTRejectPaymentResponse softDescriptorPhone(String softDescriptorPhone) {
    
    
    
    
    this.softDescriptorPhone = softDescriptorPhone;
    return this;
  }

   /**
   * A payment gateway-specific field that maps Zuora to other gateways.           
   * @return softDescriptorPhone
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "A payment gateway-specific field that maps Zuora to other gateways.           ")

  public String getSoftDescriptorPhone() {
    return softDescriptorPhone;
  }


  public void setSoftDescriptorPhone(String softDescriptorPhone) {
    
    
    
    this.softDescriptorPhone = softDescriptorPhone;
  }


  public POSTRejectPaymentResponse status(String status) {
    
    
    
    
    this.status = status;
    return this;
  }

   /**
   * The status of the payment. 
   * @return status
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The status of the payment. ")

  public String getStatus() {
    return status;
  }


  public void setStatus(String status) {
    
    
    
    this.status = status;
  }


  public POSTRejectPaymentResponse submittedOn(OffsetDateTime submittedOn) {
    
    
    
    
    this.submittedOn = submittedOn;
    return this;
  }

   /**
   * The date and time when the payment was submitted, in yyyy-mm-dd hh:mm:ss format. 
   * @return submittedOn
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The date and time when the payment was submitted, in yyyy-mm-dd hh:mm:ss format. ")

  public OffsetDateTime getSubmittedOn() {
    return submittedOn;
  }


  public void setSubmittedOn(OffsetDateTime submittedOn) {
    
    
    
    this.submittedOn = submittedOn;
  }


  public POSTRejectPaymentResponse success(Boolean success) {
    
    
    
    
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


  public POSTRejectPaymentResponse type(TypeEnum type) {
    
    
    
    
    this.type = type;
    return this;
  }

   /**
   * The type of the payment. 
   * @return type
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The type of the payment. ")

  public TypeEnum getType() {
    return type;
  }


  public void setType(TypeEnum type) {
    
    
    
    this.type = type;
  }


  public POSTRejectPaymentResponse updatedById(String updatedById) {
    
    
    
    
    this.updatedById = updatedById;
    return this;
  }

   /**
   * The ID of the Zuora user who last updated the payment. 
   * @return updatedById
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The ID of the Zuora user who last updated the payment. ")

  public String getUpdatedById() {
    return updatedById;
  }


  public void setUpdatedById(String updatedById) {
    
    
    
    this.updatedById = updatedById;
  }


  public POSTRejectPaymentResponse updatedDate(OffsetDateTime updatedDate) {
    
    
    
    
    this.updatedDate = updatedDate;
    return this;
  }

   /**
   * The date and time when the payment was last updated, in &#x60;yyyy-mm-dd hh:mm:ss&#x60; format. For example, 2019-03-02 15:36:10. 
   * @return updatedDate
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The date and time when the payment was last updated, in `yyyy-mm-dd hh:mm:ss` format. For example, 2019-03-02 15:36:10. ")

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
   * @return the POSTRejectPaymentResponse instance itself
   */
  public POSTRejectPaymentResponse putAdditionalProperty(String key, Object value) {
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
    POSTRejectPaymentResponse poSTRejectPaymentResponse = (POSTRejectPaymentResponse) o;
    return Objects.equals(this.accountId, poSTRejectPaymentResponse.accountId) &&
        Objects.equals(this.amount, poSTRejectPaymentResponse.amount) &&
        Objects.equals(this.cancelledOn, poSTRejectPaymentResponse.cancelledOn) &&
        Objects.equals(this.comment, poSTRejectPaymentResponse.comment) &&
        Objects.equals(this.createdById, poSTRejectPaymentResponse.createdById) &&
        Objects.equals(this.createdDate, poSTRejectPaymentResponse.createdDate) &&
        Objects.equals(this.creditMemoId, poSTRejectPaymentResponse.creditMemoId) &&
        Objects.equals(this.financeInformation, poSTRejectPaymentResponse.financeInformation) &&
        Objects.equals(this.gatewayId, poSTRejectPaymentResponse.gatewayId) &&
        Objects.equals(this.gatewayReconciliationReason, poSTRejectPaymentResponse.gatewayReconciliationReason) &&
        Objects.equals(this.gatewayReconciliationStatus, poSTRejectPaymentResponse.gatewayReconciliationStatus) &&
        Objects.equals(this.gatewayResponse, poSTRejectPaymentResponse.gatewayResponse) &&
        Objects.equals(this.gatewayResponseCode, poSTRejectPaymentResponse.gatewayResponseCode) &&
        Objects.equals(this.gatewayState, poSTRejectPaymentResponse.gatewayState) &&
        Objects.equals(this.id, poSTRejectPaymentResponse.id) &&
        Objects.equals(this.markedForSubmissionOn, poSTRejectPaymentResponse.markedForSubmissionOn) &&
        Objects.equals(this.methodType, poSTRejectPaymentResponse.methodType) &&
        Objects.equals(this.number, poSTRejectPaymentResponse.number) &&
        Objects.equals(this.organizationLabel, poSTRejectPaymentResponse.organizationLabel) &&
        Objects.equals(this.paymentId, poSTRejectPaymentResponse.paymentId) &&
        Objects.equals(this.paymentMethodId, poSTRejectPaymentResponse.paymentMethodId) &&
        Objects.equals(this.paymentMethodSnapshotId, poSTRejectPaymentResponse.paymentMethodSnapshotId) &&
        Objects.equals(this.payoutId, poSTRejectPaymentResponse.payoutId) &&
        Objects.equals(this.reasonCode, poSTRejectPaymentResponse.reasonCode) &&
        Objects.equals(this.referenceId, poSTRejectPaymentResponse.referenceId) &&
        Objects.equals(this.refundDate, poSTRejectPaymentResponse.refundDate) &&
        Objects.equals(this.refundTransactionTime, poSTRejectPaymentResponse.refundTransactionTime) &&
        Objects.equals(this.secondRefundReferenceId, poSTRejectPaymentResponse.secondRefundReferenceId) &&
        Objects.equals(this.settledOn, poSTRejectPaymentResponse.settledOn) &&
        Objects.equals(this.softDescriptor, poSTRejectPaymentResponse.softDescriptor) &&
        Objects.equals(this.softDescriptorPhone, poSTRejectPaymentResponse.softDescriptorPhone) &&
        Objects.equals(this.status, poSTRejectPaymentResponse.status) &&
        Objects.equals(this.submittedOn, poSTRejectPaymentResponse.submittedOn) &&
        Objects.equals(this.success, poSTRejectPaymentResponse.success) &&
        Objects.equals(this.type, poSTRejectPaymentResponse.type) &&
        Objects.equals(this.updatedById, poSTRejectPaymentResponse.updatedById) &&
        Objects.equals(this.updatedDate, poSTRejectPaymentResponse.updatedDate)&&
        Objects.equals(this.additionalProperties, poSTRejectPaymentResponse.additionalProperties);
  }

  @Override
  public int hashCode() {
    return Objects.hash(accountId, amount, cancelledOn, comment, createdById, createdDate, creditMemoId, financeInformation, gatewayId, gatewayReconciliationReason, gatewayReconciliationStatus, gatewayResponse, gatewayResponseCode, gatewayState, id, markedForSubmissionOn, methodType, number, organizationLabel, paymentId, paymentMethodId, paymentMethodSnapshotId, payoutId, reasonCode, referenceId, refundDate, refundTransactionTime, secondRefundReferenceId, settledOn, softDescriptor, softDescriptorPhone, status, submittedOn, success, type, updatedById, updatedDate, additionalProperties);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class POSTRejectPaymentResponse {\n");
    sb.append("    accountId: ").append(toIndentedString(accountId)).append("\n");
    sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
    sb.append("    cancelledOn: ").append(toIndentedString(cancelledOn)).append("\n");
    sb.append("    comment: ").append(toIndentedString(comment)).append("\n");
    sb.append("    createdById: ").append(toIndentedString(createdById)).append("\n");
    sb.append("    createdDate: ").append(toIndentedString(createdDate)).append("\n");
    sb.append("    creditMemoId: ").append(toIndentedString(creditMemoId)).append("\n");
    sb.append("    financeInformation: ").append(toIndentedString(financeInformation)).append("\n");
    sb.append("    gatewayId: ").append(toIndentedString(gatewayId)).append("\n");
    sb.append("    gatewayReconciliationReason: ").append(toIndentedString(gatewayReconciliationReason)).append("\n");
    sb.append("    gatewayReconciliationStatus: ").append(toIndentedString(gatewayReconciliationStatus)).append("\n");
    sb.append("    gatewayResponse: ").append(toIndentedString(gatewayResponse)).append("\n");
    sb.append("    gatewayResponseCode: ").append(toIndentedString(gatewayResponseCode)).append("\n");
    sb.append("    gatewayState: ").append(toIndentedString(gatewayState)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    markedForSubmissionOn: ").append(toIndentedString(markedForSubmissionOn)).append("\n");
    sb.append("    methodType: ").append(toIndentedString(methodType)).append("\n");
    sb.append("    number: ").append(toIndentedString(number)).append("\n");
    sb.append("    organizationLabel: ").append(toIndentedString(organizationLabel)).append("\n");
    sb.append("    paymentId: ").append(toIndentedString(paymentId)).append("\n");
    sb.append("    paymentMethodId: ").append(toIndentedString(paymentMethodId)).append("\n");
    sb.append("    paymentMethodSnapshotId: ").append(toIndentedString(paymentMethodSnapshotId)).append("\n");
    sb.append("    payoutId: ").append(toIndentedString(payoutId)).append("\n");
    sb.append("    reasonCode: ").append(toIndentedString(reasonCode)).append("\n");
    sb.append("    referenceId: ").append(toIndentedString(referenceId)).append("\n");
    sb.append("    refundDate: ").append(toIndentedString(refundDate)).append("\n");
    sb.append("    refundTransactionTime: ").append(toIndentedString(refundTransactionTime)).append("\n");
    sb.append("    secondRefundReferenceId: ").append(toIndentedString(secondRefundReferenceId)).append("\n");
    sb.append("    settledOn: ").append(toIndentedString(settledOn)).append("\n");
    sb.append("    softDescriptor: ").append(toIndentedString(softDescriptor)).append("\n");
    sb.append("    softDescriptorPhone: ").append(toIndentedString(softDescriptorPhone)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    submittedOn: ").append(toIndentedString(submittedOn)).append("\n");
    sb.append("    success: ").append(toIndentedString(success)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
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
    openapiFields.add("amount");
    openapiFields.add("cancelledOn");
    openapiFields.add("comment");
    openapiFields.add("createdById");
    openapiFields.add("createdDate");
    openapiFields.add("creditMemoId");
    openapiFields.add("financeInformation");
    openapiFields.add("gatewayId");
    openapiFields.add("gatewayReconciliationReason");
    openapiFields.add("gatewayReconciliationStatus");
    openapiFields.add("gatewayResponse");
    openapiFields.add("gatewayResponseCode");
    openapiFields.add("gatewayState");
    openapiFields.add("id");
    openapiFields.add("markedForSubmissionOn");
    openapiFields.add("methodType");
    openapiFields.add("number");
    openapiFields.add("organizationLabel");
    openapiFields.add("paymentId");
    openapiFields.add("paymentMethodId");
    openapiFields.add("paymentMethodSnapshotId");
    openapiFields.add("payoutId");
    openapiFields.add("reasonCode");
    openapiFields.add("referenceId");
    openapiFields.add("refundDate");
    openapiFields.add("refundTransactionTime");
    openapiFields.add("secondRefundReferenceId");
    openapiFields.add("settledOn");
    openapiFields.add("softDescriptor");
    openapiFields.add("softDescriptorPhone");
    openapiFields.add("status");
    openapiFields.add("submittedOn");
    openapiFields.add("success");
    openapiFields.add("type");
    openapiFields.add("updatedById");
    openapiFields.add("updatedDate");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
  }

 /**
  * Validates the JSON Object and throws an exception if issues found
  *
  * @param jsonObj JSON Object
  * @throws IOException if the JSON Object is invalid with respect to POSTRejectPaymentResponse
  */
  public static void validateJsonObject(JsonObject jsonObj) throws IOException {
      if (jsonObj == null) {
        if (!POSTRejectPaymentResponse.openapiRequiredFields.isEmpty()) { // has required fields but JSON object is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in POSTRejectPaymentResponse is not found in the empty JSON string", POSTRejectPaymentResponse.openapiRequiredFields.toString()));
        }
      }
      if ((jsonObj.get("accountId") != null && !jsonObj.get("accountId").isJsonNull()) && !jsonObj.get("accountId").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `accountId` to be a primitive type in the JSON string but got `%s`", jsonObj.get("accountId").toString()));
      }
      if ((jsonObj.get("comment") != null && !jsonObj.get("comment").isJsonNull()) && !jsonObj.get("comment").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `comment` to be a primitive type in the JSON string but got `%s`", jsonObj.get("comment").toString()));
      }
      if ((jsonObj.get("createdById") != null && !jsonObj.get("createdById").isJsonNull()) && !jsonObj.get("createdById").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `createdById` to be a primitive type in the JSON string but got `%s`", jsonObj.get("createdById").toString()));
      }
      if ((jsonObj.get("creditMemoId") != null && !jsonObj.get("creditMemoId").isJsonNull()) && !jsonObj.get("creditMemoId").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `creditMemoId` to be a primitive type in the JSON string but got `%s`", jsonObj.get("creditMemoId").toString()));
      }
      // validate the optional field `financeInformation`
      if (jsonObj.get("financeInformation") != null && !jsonObj.get("financeInformation").isJsonNull()) {
        POSTReversePaymentResponseFinanceInformation.validateJsonObject(jsonObj.getAsJsonObject("financeInformation"));
      }
      if ((jsonObj.get("gatewayId") != null && !jsonObj.get("gatewayId").isJsonNull()) && !jsonObj.get("gatewayId").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `gatewayId` to be a primitive type in the JSON string but got `%s`", jsonObj.get("gatewayId").toString()));
      }
      if ((jsonObj.get("gatewayReconciliationReason") != null && !jsonObj.get("gatewayReconciliationReason").isJsonNull()) && !jsonObj.get("gatewayReconciliationReason").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `gatewayReconciliationReason` to be a primitive type in the JSON string but got `%s`", jsonObj.get("gatewayReconciliationReason").toString()));
      }
      if ((jsonObj.get("gatewayReconciliationStatus") != null && !jsonObj.get("gatewayReconciliationStatus").isJsonNull()) && !jsonObj.get("gatewayReconciliationStatus").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `gatewayReconciliationStatus` to be a primitive type in the JSON string but got `%s`", jsonObj.get("gatewayReconciliationStatus").toString()));
      }
      if ((jsonObj.get("gatewayResponse") != null && !jsonObj.get("gatewayResponse").isJsonNull()) && !jsonObj.get("gatewayResponse").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `gatewayResponse` to be a primitive type in the JSON string but got `%s`", jsonObj.get("gatewayResponse").toString()));
      }
      if ((jsonObj.get("gatewayResponseCode") != null && !jsonObj.get("gatewayResponseCode").isJsonNull()) && !jsonObj.get("gatewayResponseCode").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `gatewayResponseCode` to be a primitive type in the JSON string but got `%s`", jsonObj.get("gatewayResponseCode").toString()));
      }
      if ((jsonObj.get("gatewayState") != null && !jsonObj.get("gatewayState").isJsonNull()) && !jsonObj.get("gatewayState").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `gatewayState` to be a primitive type in the JSON string but got `%s`", jsonObj.get("gatewayState").toString()));
      }
      if ((jsonObj.get("id") != null && !jsonObj.get("id").isJsonNull()) && !jsonObj.get("id").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `id` to be a primitive type in the JSON string but got `%s`", jsonObj.get("id").toString()));
      }
      if ((jsonObj.get("methodType") != null && !jsonObj.get("methodType").isJsonNull()) && !jsonObj.get("methodType").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `methodType` to be a primitive type in the JSON string but got `%s`", jsonObj.get("methodType").toString()));
      }
      if ((jsonObj.get("number") != null && !jsonObj.get("number").isJsonNull()) && !jsonObj.get("number").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `number` to be a primitive type in the JSON string but got `%s`", jsonObj.get("number").toString()));
      }
      if ((jsonObj.get("organizationLabel") != null && !jsonObj.get("organizationLabel").isJsonNull()) && !jsonObj.get("organizationLabel").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `organizationLabel` to be a primitive type in the JSON string but got `%s`", jsonObj.get("organizationLabel").toString()));
      }
      if ((jsonObj.get("paymentId") != null && !jsonObj.get("paymentId").isJsonNull()) && !jsonObj.get("paymentId").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `paymentId` to be a primitive type in the JSON string but got `%s`", jsonObj.get("paymentId").toString()));
      }
      if ((jsonObj.get("paymentMethodId") != null && !jsonObj.get("paymentMethodId").isJsonNull()) && !jsonObj.get("paymentMethodId").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `paymentMethodId` to be a primitive type in the JSON string but got `%s`", jsonObj.get("paymentMethodId").toString()));
      }
      if ((jsonObj.get("paymentMethodSnapshotId") != null && !jsonObj.get("paymentMethodSnapshotId").isJsonNull()) && !jsonObj.get("paymentMethodSnapshotId").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `paymentMethodSnapshotId` to be a primitive type in the JSON string but got `%s`", jsonObj.get("paymentMethodSnapshotId").toString()));
      }
      if ((jsonObj.get("payoutId") != null && !jsonObj.get("payoutId").isJsonNull()) && !jsonObj.get("payoutId").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `payoutId` to be a primitive type in the JSON string but got `%s`", jsonObj.get("payoutId").toString()));
      }
      if ((jsonObj.get("reasonCode") != null && !jsonObj.get("reasonCode").isJsonNull()) && !jsonObj.get("reasonCode").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `reasonCode` to be a primitive type in the JSON string but got `%s`", jsonObj.get("reasonCode").toString()));
      }
      if ((jsonObj.get("referenceId") != null && !jsonObj.get("referenceId").isJsonNull()) && !jsonObj.get("referenceId").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `referenceId` to be a primitive type in the JSON string but got `%s`", jsonObj.get("referenceId").toString()));
      }
      if ((jsonObj.get("secondRefundReferenceId") != null && !jsonObj.get("secondRefundReferenceId").isJsonNull()) && !jsonObj.get("secondRefundReferenceId").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `secondRefundReferenceId` to be a primitive type in the JSON string but got `%s`", jsonObj.get("secondRefundReferenceId").toString()));
      }
      if ((jsonObj.get("softDescriptor") != null && !jsonObj.get("softDescriptor").isJsonNull()) && !jsonObj.get("softDescriptor").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `softDescriptor` to be a primitive type in the JSON string but got `%s`", jsonObj.get("softDescriptor").toString()));
      }
      if ((jsonObj.get("softDescriptorPhone") != null && !jsonObj.get("softDescriptorPhone").isJsonNull()) && !jsonObj.get("softDescriptorPhone").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `softDescriptorPhone` to be a primitive type in the JSON string but got `%s`", jsonObj.get("softDescriptorPhone").toString()));
      }
      if ((jsonObj.get("status") != null && !jsonObj.get("status").isJsonNull()) && !jsonObj.get("status").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `status` to be a primitive type in the JSON string but got `%s`", jsonObj.get("status").toString()));
      }
      if ((jsonObj.get("type") != null && !jsonObj.get("type").isJsonNull()) && !jsonObj.get("type").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `type` to be a primitive type in the JSON string but got `%s`", jsonObj.get("type").toString()));
      }
      if ((jsonObj.get("updatedById") != null && !jsonObj.get("updatedById").isJsonNull()) && !jsonObj.get("updatedById").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `updatedById` to be a primitive type in the JSON string but got `%s`", jsonObj.get("updatedById").toString()));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!POSTRejectPaymentResponse.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'POSTRejectPaymentResponse' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<POSTRejectPaymentResponse> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(POSTRejectPaymentResponse.class));

       return (TypeAdapter<T>) new TypeAdapter<POSTRejectPaymentResponse>() {
           @Override
           public void write(JsonWriter out, POSTRejectPaymentResponse value) throws IOException {
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
           public POSTRejectPaymentResponse read(JsonReader in) throws IOException {
             JsonObject jsonObj = elementAdapter.read(in).getAsJsonObject();
             validateJsonObject(jsonObj);
             // store additional fields in the deserialized instance
             POSTRejectPaymentResponse instance = thisAdapter.fromJsonTree(jsonObj);
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
  * Create an instance of POSTRejectPaymentResponse given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of POSTRejectPaymentResponse
  * @throws IOException if the JSON string is invalid with respect to POSTRejectPaymentResponse
  */
  public static POSTRejectPaymentResponse fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, POSTRejectPaymentResponse.class);
  }

 /**
  * Convert an instance of POSTRejectPaymentResponse to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

