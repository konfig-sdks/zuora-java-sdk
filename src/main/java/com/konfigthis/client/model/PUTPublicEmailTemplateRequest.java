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
 * PUTPublicEmailTemplateRequest
 */@javax.annotation.Generated(value = "Generated by https://konfigthis.com")
public class PUTPublicEmailTemplateRequest {
  public static final String SERIALIZED_NAME_DESCRIPTION = "description";
  @SerializedName(SERIALIZED_NAME_DESCRIPTION)
  private String description;

  public static final String SERIALIZED_NAME_ACTIVE = "active";
  @SerializedName(SERIALIZED_NAME_ACTIVE)
  private Boolean active;

  public static final String SERIALIZED_NAME_BCC_EMAIL_ADDRESS = "bccEmailAddress";
  @SerializedName(SERIALIZED_NAME_BCC_EMAIL_ADDRESS)
  private String bccEmailAddress;

  public static final String SERIALIZED_NAME_CC_EMAIL_ADDRESS = "ccEmailAddress";
  @SerializedName(SERIALIZED_NAME_CC_EMAIL_ADDRESS)
  private String ccEmailAddress;

  /**
   * Email CC type. * When the base object for the event is associated with &#x60;Account&#x60;, &#x60;ccEmailType&#x60; can be any values in the enum list.  * When the base object for the event is not associated with &#x60;Account&#x60;, &#x60;ccEmailType&#x60; must be &#x60;TenantAdmin&#x60;, &#x60;RunOwner&#x60;, or &#x60;SpecificEmail&#x60;. 
   */
  @JsonAdapter(CcEmailTypeEnum.Adapter.class)
 public enum CcEmailTypeEnum {
    BILLTOCONTACT("BillToContact"),
    
    SOLDTOCONTACT("SoldToContact"),
    
    SPECIFICEMAILS("SpecificEmails"),
    
    TENANTADMIN("TenantAdmin"),
    
    BILLTOANDSOLDTOCONTACTS("BillToAndSoldToContacts"),
    
    RUNOWNER("RunOwner"),
    
    ALLCONTACTS("AllContacts"),
    
    INVOICEOWNERBILLTOCONTACT("InvoiceOwnerBillToContact"),
    
    INVOICEOWNERSOLDTOCONTACT("InvoiceOwnerSoldToContact"),
    
    INVOICEOWNERBILLTOANDSOLDTOCONTACTS("InvoiceOwnerBillToAndSoldToContacts"),
    
    INVOICEOWNERALLCONTACTS("InvoiceOwnerAllContacts");

    private String value;

    CcEmailTypeEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static CcEmailTypeEnum fromValue(String value) {
      for (CcEmailTypeEnum b : CcEmailTypeEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<CcEmailTypeEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final CcEmailTypeEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public CcEmailTypeEnum read(final JsonReader jsonReader) throws IOException {
        String value =  jsonReader.nextString();
        return CcEmailTypeEnum.fromValue(value);
      }
    }
  }

  public static final String SERIALIZED_NAME_CC_EMAIL_TYPE = "ccEmailType";
  @SerializedName(SERIALIZED_NAME_CC_EMAIL_TYPE)
  private CcEmailTypeEnum ccEmailType = CcEmailTypeEnum.SPECIFICEMAILS;

  public static final String SERIALIZED_NAME_EMAIL_BODY = "emailBody";
  @SerializedName(SERIALIZED_NAME_EMAIL_BODY)
  private String emailBody;

  public static final String SERIALIZED_NAME_EMAIL_SUBJECT = "emailSubject";
  @SerializedName(SERIALIZED_NAME_EMAIL_SUBJECT)
  private String emailSubject;

  /**
   * The endcode type of the email body.
   */
  @JsonAdapter(EncodingTypeEnum.Adapter.class)
 public enum EncodingTypeEnum {
    UTF8("UTF8"),
    
    SHIFT_JIS("Shift_JIS"),
    
    ISO_2022_JP("ISO_2022_JP"),
    
    EUC_JP("EUC_JP"),
    
    X_SJIS_0213("X_SJIS_0213");

    private String value;

    EncodingTypeEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static EncodingTypeEnum fromValue(String value) {
      for (EncodingTypeEnum b : EncodingTypeEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<EncodingTypeEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final EncodingTypeEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public EncodingTypeEnum read(final JsonReader jsonReader) throws IOException {
        String value =  jsonReader.nextString();
        return EncodingTypeEnum.fromValue(value);
      }
    }
  }

  public static final String SERIALIZED_NAME_ENCODING_TYPE = "encodingType";
  @SerializedName(SERIALIZED_NAME_ENCODING_TYPE)
  private EncodingTypeEnum encodingType;

  public static final String SERIALIZED_NAME_FROM_EMAIL_ADDRESS = "fromEmailAddress";
  @SerializedName(SERIALIZED_NAME_FROM_EMAIL_ADDRESS)
  private String fromEmailAddress;

  /**
   * The type of fromEmail.
   */
  @JsonAdapter(FromEmailTypeEnum.Adapter.class)
 public enum FromEmailTypeEnum {
    TENANTEMAIL("TenantEmail"),
    
    RUNOWNER("RunOwner"),
    
    SPECIFICEMAIL("SpecificEmail");

    private String value;

    FromEmailTypeEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static FromEmailTypeEnum fromValue(String value) {
      for (FromEmailTypeEnum b : FromEmailTypeEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<FromEmailTypeEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final FromEmailTypeEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public FromEmailTypeEnum read(final JsonReader jsonReader) throws IOException {
        String value =  jsonReader.nextString();
        return FromEmailTypeEnum.fromValue(value);
      }
    }
  }

  public static final String SERIALIZED_NAME_FROM_EMAIL_TYPE = "fromEmailType";
  @SerializedName(SERIALIZED_NAME_FROM_EMAIL_TYPE)
  private FromEmailTypeEnum fromEmailType;

  public static final String SERIALIZED_NAME_FROM_NAME = "fromName";
  @SerializedName(SERIALIZED_NAME_FROM_NAME)
  private String fromName;

  public static final String SERIALIZED_NAME_IS_HTML = "isHtml";
  @SerializedName(SERIALIZED_NAME_IS_HTML)
  private Boolean isHtml;

  public static final String SERIALIZED_NAME_NAME = "name";
  @SerializedName(SERIALIZED_NAME_NAME)
  private String name;

  public static final String SERIALIZED_NAME_REPLY_TO_EMAIL_ADDRESS = "replyToEmailAddress";
  @SerializedName(SERIALIZED_NAME_REPLY_TO_EMAIL_ADDRESS)
  private String replyToEmailAddress;

  /**
   * The type of the reply email.
   */
  @JsonAdapter(ReplyToEmailTypeEnum.Adapter.class)
 public enum ReplyToEmailTypeEnum {
    TENANTEMAIL("TenantEmail"),
    
    RUNOWNER("RunOwner"),
    
    SPECIFICEMAIL("SpecificEmail");

    private String value;

    ReplyToEmailTypeEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static ReplyToEmailTypeEnum fromValue(String value) {
      for (ReplyToEmailTypeEnum b : ReplyToEmailTypeEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<ReplyToEmailTypeEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final ReplyToEmailTypeEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public ReplyToEmailTypeEnum read(final JsonReader jsonReader) throws IOException {
        String value =  jsonReader.nextString();
        return ReplyToEmailTypeEnum.fromValue(value);
      }
    }
  }

  public static final String SERIALIZED_NAME_REPLY_TO_EMAIL_TYPE = "replyToEmailType";
  @SerializedName(SERIALIZED_NAME_REPLY_TO_EMAIL_TYPE)
  private ReplyToEmailTypeEnum replyToEmailType;

  public static final String SERIALIZED_NAME_TO_EMAIL_ADDRESS = "toEmailAddress";
  @SerializedName(SERIALIZED_NAME_TO_EMAIL_ADDRESS)
  private String toEmailAddress;

  /**
   * Email receive type. * When the base object for the event is associated with &#x60;Account&#x60;, &#x60;toEmailType&#x60; can be any values in the enum list.  * When the base object for the event is not associated with &#x60;Account&#x60;, &#x60;toEmailType&#x60; must be &#x60;TenantAdmin&#x60;, &#x60;RunOwner&#x60;, or &#x60;SpecificEmail&#x60;. 
   */
  @JsonAdapter(ToEmailTypeEnum.Adapter.class)
 public enum ToEmailTypeEnum {
    BILLTOCONTACT("BillToContact"),
    
    SOLDTOCONTACT("SoldToContact"),
    
    SPECIFICEMAILS("SpecificEmails"),
    
    TENANTADMIN("TenantAdmin"),
    
    BILLTOANDSOLDTOCONTACTS("BillToAndSoldToContacts"),
    
    RUNOWNER("RunOwner"),
    
    ALLCONTACTS("AllContacts"),
    
    INVOICEOWNERBILLTOCONTACT("InvoiceOwnerBillToContact"),
    
    INVOICEOWNERSOLDTOCONTACT("InvoiceOwnerSoldToContact"),
    
    INVOICEOWNERBILLTOANDSOLDTOCONTACTS("InvoiceOwnerBillToAndSoldToContacts"),
    
    INVOICEOWNERALLCONTACTS("InvoiceOwnerAllContacts");

    private String value;

    ToEmailTypeEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static ToEmailTypeEnum fromValue(String value) {
      for (ToEmailTypeEnum b : ToEmailTypeEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<ToEmailTypeEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final ToEmailTypeEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public ToEmailTypeEnum read(final JsonReader jsonReader) throws IOException {
        String value =  jsonReader.nextString();
        return ToEmailTypeEnum.fromValue(value);
      }
    }
  }

  public static final String SERIALIZED_NAME_TO_EMAIL_TYPE = "toEmailType";
  @SerializedName(SERIALIZED_NAME_TO_EMAIL_TYPE)
  private ToEmailTypeEnum toEmailType;

  public PUTPublicEmailTemplateRequest() {
  }

  public PUTPublicEmailTemplateRequest description(String description) {
    
    
    
    
    this.description = description;
    return this;
  }

   /**
   * The description of the email template.
   * @return description
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "Email when an account is edited", value = "The description of the email template.")

  public String getDescription() {
    return description;
  }


  public void setDescription(String description) {
    
    
    
    this.description = description;
  }


  public PUTPublicEmailTemplateRequest active(Boolean active) {
    
    
    
    
    this.active = active;
    return this;
  }

   /**
   * The status of the email template.
   * @return active
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "true", value = "The status of the email template.")

  public Boolean getActive() {
    return active;
  }


  public void setActive(Boolean active) {
    
    
    
    this.active = active;
  }


  public PUTPublicEmailTemplateRequest bccEmailAddress(String bccEmailAddress) {
    
    
    
    
    this.bccEmailAddress = bccEmailAddress;
    return this;
  }

   /**
   * Email bcc address.
   * @return bccEmailAddress
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "user@example.com", value = "Email bcc address.")

  public String getBccEmailAddress() {
    return bccEmailAddress;
  }


  public void setBccEmailAddress(String bccEmailAddress) {
    
    
    
    this.bccEmailAddress = bccEmailAddress;
  }


  public PUTPublicEmailTemplateRequest ccEmailAddress(String ccEmailAddress) {
    
    
    
    
    this.ccEmailAddress = ccEmailAddress;
    return this;
  }

   /**
   * Email cc address.
   * @return ccEmailAddress
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "user@example.com", value = "Email cc address.")

  public String getCcEmailAddress() {
    return ccEmailAddress;
  }


  public void setCcEmailAddress(String ccEmailAddress) {
    
    
    
    this.ccEmailAddress = ccEmailAddress;
  }


  public PUTPublicEmailTemplateRequest ccEmailType(CcEmailTypeEnum ccEmailType) {
    
    
    
    
    this.ccEmailType = ccEmailType;
    return this;
  }

   /**
   * Email CC type. * When the base object for the event is associated with &#x60;Account&#x60;, &#x60;ccEmailType&#x60; can be any values in the enum list.  * When the base object for the event is not associated with &#x60;Account&#x60;, &#x60;ccEmailType&#x60; must be &#x60;TenantAdmin&#x60;, &#x60;RunOwner&#x60;, or &#x60;SpecificEmail&#x60;. 
   * @return ccEmailType
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "SPECIFICEMAILS", value = "Email CC type. * When the base object for the event is associated with `Account`, `ccEmailType` can be any values in the enum list.  * When the base object for the event is not associated with `Account`, `ccEmailType` must be `TenantAdmin`, `RunOwner`, or `SpecificEmail`. ")

  public CcEmailTypeEnum getCcEmailType() {
    return ccEmailType;
  }


  public void setCcEmailType(CcEmailTypeEnum ccEmailType) {
    
    
    
    this.ccEmailType = ccEmailType;
  }


  public PUTPublicEmailTemplateRequest emailBody(String emailBody) {
    
    
    
    
    this.emailBody = emailBody;
    return this;
  }

   /**
   * The email body. You can add merge fields in the email body using angle brackets or double curly brackets. For more information, see &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Central_Platform/Events_and_Notifications/Create_Email_Templates/A_Merge_field_syntax_for_email_templates\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Merge field syntax for email templates&lt;/a&gt;.   User can also embed html tags if &#x60;isHtml&#x60; is &#x60;true&#x60;. 
   * @return emailBody
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "Dear user,<p>the account <Account.Name> has been edited. <p>Example Co. Ltd.", value = "The email body. You can add merge fields in the email body using angle brackets or double curly brackets. For more information, see <a href=\"https://knowledgecenter.zuora.com/Zuora_Central_Platform/Events_and_Notifications/Create_Email_Templates/A_Merge_field_syntax_for_email_templates\" target=\"_blank\">Merge field syntax for email templates</a>.   User can also embed html tags if `isHtml` is `true`. ")

  public String getEmailBody() {
    return emailBody;
  }


  public void setEmailBody(String emailBody) {
    
    
    
    this.emailBody = emailBody;
  }


  public PUTPublicEmailTemplateRequest emailSubject(String emailSubject) {
    
    
    
    
    this.emailSubject = emailSubject;
    return this;
  }

   /**
   * The email subject. You can add merge fields in the email subject using angle brackets or double curly brackets. For more information, see &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Central_Platform/Events_and_Notifications/Create_Email_Templates/A_Merge_field_syntax_for_email_templates\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Merge field syntax for email templates&lt;/a&gt;. 
   * @return emailSubject
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "Account <Account.Number> has been edited", value = "The email subject. You can add merge fields in the email subject using angle brackets or double curly brackets. For more information, see <a href=\"https://knowledgecenter.zuora.com/Zuora_Central_Platform/Events_and_Notifications/Create_Email_Templates/A_Merge_field_syntax_for_email_templates\" target=\"_blank\">Merge field syntax for email templates</a>. ")

  public String getEmailSubject() {
    return emailSubject;
  }


  public void setEmailSubject(String emailSubject) {
    
    
    
    this.emailSubject = emailSubject;
  }


  public PUTPublicEmailTemplateRequest encodingType(EncodingTypeEnum encodingType) {
    
    
    
    
    this.encodingType = encodingType;
    return this;
  }

   /**
   * The endcode type of the email body.
   * @return encodingType
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "UTF8", value = "The endcode type of the email body.")

  public EncodingTypeEnum getEncodingType() {
    return encodingType;
  }


  public void setEncodingType(EncodingTypeEnum encodingType) {
    
    
    
    this.encodingType = encodingType;
  }


  public PUTPublicEmailTemplateRequest fromEmailAddress(String fromEmailAddress) {
    
    
    
    
    this.fromEmailAddress = fromEmailAddress;
    return this;
  }

   /**
   * If fromEmailType is SpecificEmail, this field is required
   * @return fromEmailAddress
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "If fromEmailType is SpecificEmail, this field is required")

  public String getFromEmailAddress() {
    return fromEmailAddress;
  }


  public void setFromEmailAddress(String fromEmailAddress) {
    
    
    
    this.fromEmailAddress = fromEmailAddress;
  }


  public PUTPublicEmailTemplateRequest fromEmailType(FromEmailTypeEnum fromEmailType) {
    
    
    
    
    this.fromEmailType = fromEmailType;
    return this;
  }

   /**
   * The type of fromEmail.
   * @return fromEmailType
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "TENANTEMAIL", value = "The type of fromEmail.")

  public FromEmailTypeEnum getFromEmailType() {
    return fromEmailType;
  }


  public void setFromEmailType(FromEmailTypeEnum fromEmailType) {
    
    
    
    this.fromEmailType = fromEmailType;
  }


  public PUTPublicEmailTemplateRequest fromName(String fromName) {
    
    
    
    
    this.fromName = fromName;
    return this;
  }

   /**
   * The name of email sender.
   * @return fromName
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "Example Co. Ltd.", value = "The name of email sender.")

  public String getFromName() {
    return fromName;
  }


  public void setFromName(String fromName) {
    
    
    
    this.fromName = fromName;
  }


  public PUTPublicEmailTemplateRequest isHtml(Boolean isHtml) {
    
    
    
    
    this.isHtml = isHtml;
    return this;
  }

   /**
   * Indicates whether the style of email body is HTML.
   * @return isHtml
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "true", value = "Indicates whether the style of email body is HTML.")

  public Boolean getIsHtml() {
    return isHtml;
  }


  public void setIsHtml(Boolean isHtml) {
    
    
    
    this.isHtml = isHtml;
  }


  public PUTPublicEmailTemplateRequest name(String name) {
    
    
    
    
    this.name = name;
    return this;
  }

   /**
   * The name of the email template.
   * @return name
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "Account Edit Email", value = "The name of the email template.")

  public String getName() {
    return name;
  }


  public void setName(String name) {
    
    
    
    this.name = name;
  }


  public PUTPublicEmailTemplateRequest replyToEmailAddress(String replyToEmailAddress) {
    
    
    
    
    this.replyToEmailAddress = replyToEmailAddress;
    return this;
  }

   /**
   * If replyToEmailType is SpecificEmail, this field is required.
   * @return replyToEmailAddress
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "If replyToEmailType is SpecificEmail, this field is required.")

  public String getReplyToEmailAddress() {
    return replyToEmailAddress;
  }


  public void setReplyToEmailAddress(String replyToEmailAddress) {
    
    
    
    this.replyToEmailAddress = replyToEmailAddress;
  }


  public PUTPublicEmailTemplateRequest replyToEmailType(ReplyToEmailTypeEnum replyToEmailType) {
    
    
    
    
    this.replyToEmailType = replyToEmailType;
    return this;
  }

   /**
   * The type of the reply email.
   * @return replyToEmailType
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "TENANTEMAIL", value = "The type of the reply email.")

  public ReplyToEmailTypeEnum getReplyToEmailType() {
    return replyToEmailType;
  }


  public void setReplyToEmailType(ReplyToEmailTypeEnum replyToEmailType) {
    
    
    
    this.replyToEmailType = replyToEmailType;
  }


  public PUTPublicEmailTemplateRequest toEmailAddress(String toEmailAddress) {
    
    
    
    
    this.toEmailAddress = toEmailAddress;
    return this;
  }

   /**
   * If toEmailType is SpecificEmail, this field is required.
   * @return toEmailAddress
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "If toEmailType is SpecificEmail, this field is required.")

  public String getToEmailAddress() {
    return toEmailAddress;
  }


  public void setToEmailAddress(String toEmailAddress) {
    
    
    
    this.toEmailAddress = toEmailAddress;
  }


  public PUTPublicEmailTemplateRequest toEmailType(ToEmailTypeEnum toEmailType) {
    
    
    
    
    this.toEmailType = toEmailType;
    return this;
  }

   /**
   * Email receive type. * When the base object for the event is associated with &#x60;Account&#x60;, &#x60;toEmailType&#x60; can be any values in the enum list.  * When the base object for the event is not associated with &#x60;Account&#x60;, &#x60;toEmailType&#x60; must be &#x60;TenantAdmin&#x60;, &#x60;RunOwner&#x60;, or &#x60;SpecificEmail&#x60;. 
   * @return toEmailType
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "BILLTOCONTACT", value = "Email receive type. * When the base object for the event is associated with `Account`, `toEmailType` can be any values in the enum list.  * When the base object for the event is not associated with `Account`, `toEmailType` must be `TenantAdmin`, `RunOwner`, or `SpecificEmail`. ")

  public ToEmailTypeEnum getToEmailType() {
    return toEmailType;
  }


  public void setToEmailType(ToEmailTypeEnum toEmailType) {
    
    
    
    this.toEmailType = toEmailType;
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
   * @return the PUTPublicEmailTemplateRequest instance itself
   */
  public PUTPublicEmailTemplateRequest putAdditionalProperty(String key, Object value) {
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
    PUTPublicEmailTemplateRequest puTPublicEmailTemplateRequest = (PUTPublicEmailTemplateRequest) o;
    return Objects.equals(this.description, puTPublicEmailTemplateRequest.description) &&
        Objects.equals(this.active, puTPublicEmailTemplateRequest.active) &&
        Objects.equals(this.bccEmailAddress, puTPublicEmailTemplateRequest.bccEmailAddress) &&
        Objects.equals(this.ccEmailAddress, puTPublicEmailTemplateRequest.ccEmailAddress) &&
        Objects.equals(this.ccEmailType, puTPublicEmailTemplateRequest.ccEmailType) &&
        Objects.equals(this.emailBody, puTPublicEmailTemplateRequest.emailBody) &&
        Objects.equals(this.emailSubject, puTPublicEmailTemplateRequest.emailSubject) &&
        Objects.equals(this.encodingType, puTPublicEmailTemplateRequest.encodingType) &&
        Objects.equals(this.fromEmailAddress, puTPublicEmailTemplateRequest.fromEmailAddress) &&
        Objects.equals(this.fromEmailType, puTPublicEmailTemplateRequest.fromEmailType) &&
        Objects.equals(this.fromName, puTPublicEmailTemplateRequest.fromName) &&
        Objects.equals(this.isHtml, puTPublicEmailTemplateRequest.isHtml) &&
        Objects.equals(this.name, puTPublicEmailTemplateRequest.name) &&
        Objects.equals(this.replyToEmailAddress, puTPublicEmailTemplateRequest.replyToEmailAddress) &&
        Objects.equals(this.replyToEmailType, puTPublicEmailTemplateRequest.replyToEmailType) &&
        Objects.equals(this.toEmailAddress, puTPublicEmailTemplateRequest.toEmailAddress) &&
        Objects.equals(this.toEmailType, puTPublicEmailTemplateRequest.toEmailType)&&
        Objects.equals(this.additionalProperties, puTPublicEmailTemplateRequest.additionalProperties);
  }

  @Override
  public int hashCode() {
    return Objects.hash(description, active, bccEmailAddress, ccEmailAddress, ccEmailType, emailBody, emailSubject, encodingType, fromEmailAddress, fromEmailType, fromName, isHtml, name, replyToEmailAddress, replyToEmailType, toEmailAddress, toEmailType, additionalProperties);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PUTPublicEmailTemplateRequest {\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    active: ").append(toIndentedString(active)).append("\n");
    sb.append("    bccEmailAddress: ").append(toIndentedString(bccEmailAddress)).append("\n");
    sb.append("    ccEmailAddress: ").append(toIndentedString(ccEmailAddress)).append("\n");
    sb.append("    ccEmailType: ").append(toIndentedString(ccEmailType)).append("\n");
    sb.append("    emailBody: ").append(toIndentedString(emailBody)).append("\n");
    sb.append("    emailSubject: ").append(toIndentedString(emailSubject)).append("\n");
    sb.append("    encodingType: ").append(toIndentedString(encodingType)).append("\n");
    sb.append("    fromEmailAddress: ").append(toIndentedString(fromEmailAddress)).append("\n");
    sb.append("    fromEmailType: ").append(toIndentedString(fromEmailType)).append("\n");
    sb.append("    fromName: ").append(toIndentedString(fromName)).append("\n");
    sb.append("    isHtml: ").append(toIndentedString(isHtml)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    replyToEmailAddress: ").append(toIndentedString(replyToEmailAddress)).append("\n");
    sb.append("    replyToEmailType: ").append(toIndentedString(replyToEmailType)).append("\n");
    sb.append("    toEmailAddress: ").append(toIndentedString(toEmailAddress)).append("\n");
    sb.append("    toEmailType: ").append(toIndentedString(toEmailType)).append("\n");
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
    openapiFields.add("bccEmailAddress");
    openapiFields.add("ccEmailAddress");
    openapiFields.add("ccEmailType");
    openapiFields.add("emailBody");
    openapiFields.add("emailSubject");
    openapiFields.add("encodingType");
    openapiFields.add("fromEmailAddress");
    openapiFields.add("fromEmailType");
    openapiFields.add("fromName");
    openapiFields.add("isHtml");
    openapiFields.add("name");
    openapiFields.add("replyToEmailAddress");
    openapiFields.add("replyToEmailType");
    openapiFields.add("toEmailAddress");
    openapiFields.add("toEmailType");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
  }

 /**
  * Validates the JSON Object and throws an exception if issues found
  *
  * @param jsonObj JSON Object
  * @throws IOException if the JSON Object is invalid with respect to PUTPublicEmailTemplateRequest
  */
  public static void validateJsonObject(JsonObject jsonObj) throws IOException {
      if (jsonObj == null) {
        if (!PUTPublicEmailTemplateRequest.openapiRequiredFields.isEmpty()) { // has required fields but JSON object is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in PUTPublicEmailTemplateRequest is not found in the empty JSON string", PUTPublicEmailTemplateRequest.openapiRequiredFields.toString()));
        }
      }
      if ((jsonObj.get("description") != null && !jsonObj.get("description").isJsonNull()) && !jsonObj.get("description").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `description` to be a primitive type in the JSON string but got `%s`", jsonObj.get("description").toString()));
      }
      if ((jsonObj.get("bccEmailAddress") != null && !jsonObj.get("bccEmailAddress").isJsonNull()) && !jsonObj.get("bccEmailAddress").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `bccEmailAddress` to be a primitive type in the JSON string but got `%s`", jsonObj.get("bccEmailAddress").toString()));
      }
      if ((jsonObj.get("ccEmailAddress") != null && !jsonObj.get("ccEmailAddress").isJsonNull()) && !jsonObj.get("ccEmailAddress").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `ccEmailAddress` to be a primitive type in the JSON string but got `%s`", jsonObj.get("ccEmailAddress").toString()));
      }
      if ((jsonObj.get("ccEmailType") != null && !jsonObj.get("ccEmailType").isJsonNull()) && !jsonObj.get("ccEmailType").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `ccEmailType` to be a primitive type in the JSON string but got `%s`", jsonObj.get("ccEmailType").toString()));
      }
      if ((jsonObj.get("emailBody") != null && !jsonObj.get("emailBody").isJsonNull()) && !jsonObj.get("emailBody").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `emailBody` to be a primitive type in the JSON string but got `%s`", jsonObj.get("emailBody").toString()));
      }
      if ((jsonObj.get("emailSubject") != null && !jsonObj.get("emailSubject").isJsonNull()) && !jsonObj.get("emailSubject").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `emailSubject` to be a primitive type in the JSON string but got `%s`", jsonObj.get("emailSubject").toString()));
      }
      if ((jsonObj.get("encodingType") != null && !jsonObj.get("encodingType").isJsonNull()) && !jsonObj.get("encodingType").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `encodingType` to be a primitive type in the JSON string but got `%s`", jsonObj.get("encodingType").toString()));
      }
      if ((jsonObj.get("fromEmailAddress") != null && !jsonObj.get("fromEmailAddress").isJsonNull()) && !jsonObj.get("fromEmailAddress").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `fromEmailAddress` to be a primitive type in the JSON string but got `%s`", jsonObj.get("fromEmailAddress").toString()));
      }
      if ((jsonObj.get("fromEmailType") != null && !jsonObj.get("fromEmailType").isJsonNull()) && !jsonObj.get("fromEmailType").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `fromEmailType` to be a primitive type in the JSON string but got `%s`", jsonObj.get("fromEmailType").toString()));
      }
      if ((jsonObj.get("fromName") != null && !jsonObj.get("fromName").isJsonNull()) && !jsonObj.get("fromName").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `fromName` to be a primitive type in the JSON string but got `%s`", jsonObj.get("fromName").toString()));
      }
      if ((jsonObj.get("name") != null && !jsonObj.get("name").isJsonNull()) && !jsonObj.get("name").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `name` to be a primitive type in the JSON string but got `%s`", jsonObj.get("name").toString()));
      }
      if ((jsonObj.get("replyToEmailAddress") != null && !jsonObj.get("replyToEmailAddress").isJsonNull()) && !jsonObj.get("replyToEmailAddress").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `replyToEmailAddress` to be a primitive type in the JSON string but got `%s`", jsonObj.get("replyToEmailAddress").toString()));
      }
      if ((jsonObj.get("replyToEmailType") != null && !jsonObj.get("replyToEmailType").isJsonNull()) && !jsonObj.get("replyToEmailType").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `replyToEmailType` to be a primitive type in the JSON string but got `%s`", jsonObj.get("replyToEmailType").toString()));
      }
      if ((jsonObj.get("toEmailAddress") != null && !jsonObj.get("toEmailAddress").isJsonNull()) && !jsonObj.get("toEmailAddress").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `toEmailAddress` to be a primitive type in the JSON string but got `%s`", jsonObj.get("toEmailAddress").toString()));
      }
      if ((jsonObj.get("toEmailType") != null && !jsonObj.get("toEmailType").isJsonNull()) && !jsonObj.get("toEmailType").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `toEmailType` to be a primitive type in the JSON string but got `%s`", jsonObj.get("toEmailType").toString()));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!PUTPublicEmailTemplateRequest.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'PUTPublicEmailTemplateRequest' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<PUTPublicEmailTemplateRequest> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(PUTPublicEmailTemplateRequest.class));

       return (TypeAdapter<T>) new TypeAdapter<PUTPublicEmailTemplateRequest>() {
           @Override
           public void write(JsonWriter out, PUTPublicEmailTemplateRequest value) throws IOException {
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
           public PUTPublicEmailTemplateRequest read(JsonReader in) throws IOException {
             JsonObject jsonObj = elementAdapter.read(in).getAsJsonObject();
             validateJsonObject(jsonObj);
             // store additional fields in the deserialized instance
             PUTPublicEmailTemplateRequest instance = thisAdapter.fromJsonTree(jsonObj);
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
  * Create an instance of PUTPublicEmailTemplateRequest given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of PUTPublicEmailTemplateRequest
  * @throws IOException if the JSON string is invalid with respect to PUTPublicEmailTemplateRequest
  */
  public static PUTPublicEmailTemplateRequest fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, PUTPublicEmailTemplateRequest.class);
  }

 /**
  * Convert an instance of PUTPublicEmailTemplateRequest to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

