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
import com.konfigthis.client.model.POSTTierType;
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
 * PUTScAddTypeAllOf
 */@javax.annotation.Generated(value = "Generated by https://konfigthis.com")
public class PUTScAddTypeAllOf {
  public static final String SERIALIZED_NAME_DESCRIPTION = "description";
  @SerializedName(SERIALIZED_NAME_DESCRIPTION)
  private String description;

  public static final String SERIALIZED_NAME_AMENDED_BY_ORDER_ON = "amendedByOrderOn";
  @SerializedName(SERIALIZED_NAME_AMENDED_BY_ORDER_ON)
  private String amendedByOrderOn;

  public static final String SERIALIZED_NAME_APPLY_DISCOUNT_TO = "applyDiscountTo";
  @SerializedName(SERIALIZED_NAME_APPLY_DISCOUNT_TO)
  private String applyDiscountTo;

  public static final String SERIALIZED_NAME_BILL_CYCLE_DAY = "billCycleDay";
  @SerializedName(SERIALIZED_NAME_BILL_CYCLE_DAY)
  private String billCycleDay;

  public static final String SERIALIZED_NAME_BILL_CYCLE_TYPE = "billCycleType";
  @SerializedName(SERIALIZED_NAME_BILL_CYCLE_TYPE)
  private String billCycleType;

  public static final String SERIALIZED_NAME_BILLING_PERIOD = "billingPeriod";
  @SerializedName(SERIALIZED_NAME_BILLING_PERIOD)
  private String billingPeriod;

  public static final String SERIALIZED_NAME_BILLING_PERIOD_ALIGNMENT = "billingPeriodAlignment";
  @SerializedName(SERIALIZED_NAME_BILLING_PERIOD_ALIGNMENT)
  private String billingPeriodAlignment;

  public static final String SERIALIZED_NAME_BILLING_TIMING = "billingTiming";
  @SerializedName(SERIALIZED_NAME_BILLING_TIMING)
  private String billingTiming;

  public static final String SERIALIZED_NAME_CHARGE_MODEL_CONFIGURATION = "chargeModelConfiguration";
  @SerializedName(SERIALIZED_NAME_CHARGE_MODEL_CONFIGURATION)
  private ChargeModelConfigurationType chargeModelConfiguration;

  public static final String SERIALIZED_NAME_DISCOUNT_AMOUNT = "discountAmount";
  @SerializedName(SERIALIZED_NAME_DISCOUNT_AMOUNT)
  private Double discountAmount;

  public static final String SERIALIZED_NAME_DISCOUNT_LEVEL = "discountLevel";
  @SerializedName(SERIALIZED_NAME_DISCOUNT_LEVEL)
  private String discountLevel;

  public static final String SERIALIZED_NAME_DISCOUNT_PERCENTAGE = "discountPercentage";
  @SerializedName(SERIALIZED_NAME_DISCOUNT_PERCENTAGE)
  private Double discountPercentage;

  public static final String SERIALIZED_NAME_END_DATE_CONDITION = "endDateCondition";
  @SerializedName(SERIALIZED_NAME_END_DATE_CONDITION)
  private String endDateCondition;

  public static final String SERIALIZED_NAME_EXCLUDE_ITEM_BILLING_FROM_REVENUE_ACCOUNTING = "excludeItemBillingFromRevenueAccounting";
  @SerializedName(SERIALIZED_NAME_EXCLUDE_ITEM_BILLING_FROM_REVENUE_ACCOUNTING)
  private Boolean excludeItemBillingFromRevenueAccounting = false;

  public static final String SERIALIZED_NAME_EXCLUDE_ITEM_BOOKING_FROM_REVENUE_ACCOUNTING = "excludeItemBookingFromRevenueAccounting";
  @SerializedName(SERIALIZED_NAME_EXCLUDE_ITEM_BOOKING_FROM_REVENUE_ACCOUNTING)
  private Boolean excludeItemBookingFromRevenueAccounting = false;

  public static final String SERIALIZED_NAME_INCLUDED_UNITS = "includedUnits";
  @SerializedName(SERIALIZED_NAME_INCLUDED_UNITS)
  private Double includedUnits;

  public static final String SERIALIZED_NAME_IS_ALLOCATION_ELIGIBLE = "isAllocationEligible";
  @SerializedName(SERIALIZED_NAME_IS_ALLOCATION_ELIGIBLE)
  private Boolean isAllocationEligible;

  public static final String SERIALIZED_NAME_IS_UNBILLED = "isUnbilled";
  @SerializedName(SERIALIZED_NAME_IS_UNBILLED)
  private Boolean isUnbilled;

  public static final String SERIALIZED_NAME_LIST_PRICE_BASE = "listPriceBase";
  @SerializedName(SERIALIZED_NAME_LIST_PRICE_BASE)
  private String listPriceBase;

  public static final String SERIALIZED_NAME_NUMBER = "number";
  @SerializedName(SERIALIZED_NAME_NUMBER)
  private String number;

  public static final String SERIALIZED_NAME_NUMBER_OF_PERIODS = "numberOfPeriods";
  @SerializedName(SERIALIZED_NAME_NUMBER_OF_PERIODS)
  private Long numberOfPeriods;

  public static final String SERIALIZED_NAME_ORIGINAL_ORDER_DATE = "originalOrderDate";
  @SerializedName(SERIALIZED_NAME_ORIGINAL_ORDER_DATE)
  private LocalDate originalOrderDate;

  public static final String SERIALIZED_NAME_OVERAGE_PRICE = "overagePrice";
  @SerializedName(SERIALIZED_NAME_OVERAGE_PRICE)
  private Double overagePrice;

  public static final String SERIALIZED_NAME_OVERAGE_UNUSED_UNITS_CREDIT_OPTION = "overageUnusedUnitsCreditOption";
  @SerializedName(SERIALIZED_NAME_OVERAGE_UNUSED_UNITS_CREDIT_OPTION)
  private String overageUnusedUnitsCreditOption;

  public static final String SERIALIZED_NAME_PRICE = "price";
  @SerializedName(SERIALIZED_NAME_PRICE)
  private Double price;

  public static final String SERIALIZED_NAME_PRICE_CHANGE_OPTION = "priceChangeOption";
  @SerializedName(SERIALIZED_NAME_PRICE_CHANGE_OPTION)
  private String priceChangeOption;

  public static final String SERIALIZED_NAME_PRICE_INCREASE_PERCENTAGE = "priceIncreasePercentage";
  @SerializedName(SERIALIZED_NAME_PRICE_INCREASE_PERCENTAGE)
  private Double priceIncreasePercentage;

  public static final String SERIALIZED_NAME_PRODUCT_RATE_PLAN_CHARGE_ID = "productRatePlanChargeId";
  @SerializedName(SERIALIZED_NAME_PRODUCT_RATE_PLAN_CHARGE_ID)
  private String productRatePlanChargeId;

  public static final String SERIALIZED_NAME_PRODUCT_RATE_PLAN_CHARGE_NUMBER = "productRatePlanChargeNumber";
  @SerializedName(SERIALIZED_NAME_PRODUCT_RATE_PLAN_CHARGE_NUMBER)
  private String productRatePlanChargeNumber;

  public static final String SERIALIZED_NAME_QUANTITY = "quantity";
  @SerializedName(SERIALIZED_NAME_QUANTITY)
  private Double quantity;

  public static final String SERIALIZED_NAME_RATING_GROUP = "ratingGroup";
  @SerializedName(SERIALIZED_NAME_RATING_GROUP)
  private String ratingGroup;

  public static final String SERIALIZED_NAME_SPECIFIC_BILLING_PERIOD = "specificBillingPeriod";
  @SerializedName(SERIALIZED_NAME_SPECIFIC_BILLING_PERIOD)
  private Long specificBillingPeriod;

  public static final String SERIALIZED_NAME_SPECIFIC_END_DATE = "specificEndDate";
  @SerializedName(SERIALIZED_NAME_SPECIFIC_END_DATE)
  private LocalDate specificEndDate;

  public static final String SERIALIZED_NAME_SPECIFIC_LIST_PRICE_BASE = "specificListPriceBase";
  @SerializedName(SERIALIZED_NAME_SPECIFIC_LIST_PRICE_BASE)
  private Integer specificListPriceBase;

  public static final String SERIALIZED_NAME_TIERS = "tiers";
  @SerializedName(SERIALIZED_NAME_TIERS)
  private List<POSTTierType> tiers = null;

  public static final String SERIALIZED_NAME_TRIGGER_DATE = "triggerDate";
  @SerializedName(SERIALIZED_NAME_TRIGGER_DATE)
  private LocalDate triggerDate;

  public static final String SERIALIZED_NAME_TRIGGER_EVENT = "triggerEvent";
  @SerializedName(SERIALIZED_NAME_TRIGGER_EVENT)
  private String triggerEvent;

  public static final String SERIALIZED_NAME_UNUSED_UNITS_CREDIT_RATES = "unusedUnitsCreditRates";
  @SerializedName(SERIALIZED_NAME_UNUSED_UNITS_CREDIT_RATES)
  private Double unusedUnitsCreditRates;

  public static final String SERIALIZED_NAME_UP_TO_PERIODS = "upToPeriods";
  @SerializedName(SERIALIZED_NAME_UP_TO_PERIODS)
  private Long upToPeriods;

  public static final String SERIALIZED_NAME_UP_TO_PERIODS_TYPE = "upToPeriodsType";
  @SerializedName(SERIALIZED_NAME_UP_TO_PERIODS_TYPE)
  private String upToPeriodsType;

  public PUTScAddTypeAllOf() {
  }

  public PUTScAddTypeAllOf description(String description) {
    
    
    
    
    this.description = description;
    return this;
  }

   /**
   * Description of the charge. 
   * @return description
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Description of the charge. ")

  public String getDescription() {
    return description;
  }


  public void setDescription(String description) {
    
    
    
    this.description = description;
  }


  public PUTScAddTypeAllOf amendedByOrderOn(String amendedByOrderOn) {
    
    
    
    
    this.amendedByOrderOn = amendedByOrderOn;
    return this;
  }

   /**
   * The date when the rate plan charge is amended through an order or amendment. This field is not updatable.  This field is to standardize the booking date information to increase audit ability and traceability of data between Zuora Billing and Zuora Revenue. It is mapped as the booking date for a sale order line in Zuora Revenue. 
   * @return amendedByOrderOn
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The date when the rate plan charge is amended through an order or amendment. This field is not updatable.  This field is to standardize the booking date information to increase audit ability and traceability of data between Zuora Billing and Zuora Revenue. It is mapped as the booking date for a sale order line in Zuora Revenue. ")

  public String getAmendedByOrderOn() {
    return amendedByOrderOn;
  }


  public void setAmendedByOrderOn(String amendedByOrderOn) {
    
    
    
    this.amendedByOrderOn = amendedByOrderOn;
  }


  public PUTScAddTypeAllOf applyDiscountTo(String applyDiscountTo) {
    
    
    
    
    this.applyDiscountTo = applyDiscountTo;
    return this;
  }

   /**
   * Specifies the type of charges that you want a specific discount to apply to.  Values:  * &#x60;ONETIME&#x60; * &#x60;RECURRING&#x60; * &#x60;USAGE&#x60; * &#x60;ONETIMERECURRING&#x60; * &#x60;ONETIMEUSAGE&#x60; * &#x60;RECURRINGUSAGE&#x60; * &#x60;ONETIMERECURRINGUSAGE&#x60;  Available for the following charge type for the Discount-Fixed Amount and Discount-Percentage charge models:  * Recurring 
   * @return applyDiscountTo
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Specifies the type of charges that you want a specific discount to apply to.  Values:  * `ONETIME` * `RECURRING` * `USAGE` * `ONETIMERECURRING` * `ONETIMEUSAGE` * `RECURRINGUSAGE` * `ONETIMERECURRINGUSAGE`  Available for the following charge type for the Discount-Fixed Amount and Discount-Percentage charge models:  * Recurring ")

  public String getApplyDiscountTo() {
    return applyDiscountTo;
  }


  public void setApplyDiscountTo(String applyDiscountTo) {
    
    
    
    this.applyDiscountTo = applyDiscountTo;
  }


  public PUTScAddTypeAllOf billCycleDay(String billCycleDay) {
    
    
    
    
    this.billCycleDay = billCycleDay;
    return this;
  }

   /**
   * Sets the bill cycle day (BCD) for the charge. The BCD determines which day of the month customer is billed.  Values: &#x60;1&#x60;-&#x60;31&#x60;  Available for the following charge types:  * Recurring * Usage-based 
   * @return billCycleDay
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Sets the bill cycle day (BCD) for the charge. The BCD determines which day of the month customer is billed.  Values: `1`-`31`  Available for the following charge types:  * Recurring * Usage-based ")

  public String getBillCycleDay() {
    return billCycleDay;
  }


  public void setBillCycleDay(String billCycleDay) {
    
    
    
    this.billCycleDay = billCycleDay;
  }


  public PUTScAddTypeAllOf billCycleType(String billCycleType) {
    
    
    
    
    this.billCycleType = billCycleType;
    return this;
  }

   /**
   * Specifies how to determine the billing day for the charge. When this field is set to &#x60;SpecificDayofMonth&#x60;, set the &#x60;BillCycleDay&#x60; field. When this field is set to &#x60;SpecificDayofWeek&#x60;, set the &#x60;weeklyBillCycleDay&#x60; field.  Values:  * &#x60;DefaultFromCustomer&#x60; * &#x60;SpecificDayofMonth&#x60; * &#x60;SubscriptionStartDay&#x60; * &#x60;ChargeTriggerDay&#x60; * &#x60;SpecificDayofWeek&#x60;  Available for the following charge types:  * Recurring * Usage-based 
   * @return billCycleType
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Specifies how to determine the billing day for the charge. When this field is set to `SpecificDayofMonth`, set the `BillCycleDay` field. When this field is set to `SpecificDayofWeek`, set the `weeklyBillCycleDay` field.  Values:  * `DefaultFromCustomer` * `SpecificDayofMonth` * `SubscriptionStartDay` * `ChargeTriggerDay` * `SpecificDayofWeek`  Available for the following charge types:  * Recurring * Usage-based ")

  public String getBillCycleType() {
    return billCycleType;
  }


  public void setBillCycleType(String billCycleType) {
    
    
    
    this.billCycleType = billCycleType;
  }


  public PUTScAddTypeAllOf billingPeriod(String billingPeriod) {
    
    
    
    
    this.billingPeriod = billingPeriod;
    return this;
  }

   /**
   * Billing period for the charge. The start day of the billing period is also called the bill cycle day (BCD). When you renew a subscription, the current subscription term is extended by creating a new term. If any charge in your subscription has the billing period set as &#x60;SubscriptionTerm&#x60;， a new charge segment is generated for the new term.  Values:  * &#x60;Month&#x60; * &#x60;Quarter&#x60; * &#x60;Semi_Annual&#x60; * &#x60;Annual&#x60; * &#x60;Eighteen_Months&#x60; * &#x60;Two_Years&#x60; * &#x60;Three_Years&#x60; * &#x60;Five_Years&#x60; * &#x60;Specific_Months&#x60; * &#x60;Subscription_Term&#x60; * &#x60;Week&#x60; * &#x60;Specific_Weeks&#x60;  Available for the following charge types:  * Recurring * Usage-based 
   * @return billingPeriod
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Billing period for the charge. The start day of the billing period is also called the bill cycle day (BCD). When you renew a subscription, the current subscription term is extended by creating a new term. If any charge in your subscription has the billing period set as `SubscriptionTerm`， a new charge segment is generated for the new term.  Values:  * `Month` * `Quarter` * `Semi_Annual` * `Annual` * `Eighteen_Months` * `Two_Years` * `Three_Years` * `Five_Years` * `Specific_Months` * `Subscription_Term` * `Week` * `Specific_Weeks`  Available for the following charge types:  * Recurring * Usage-based ")

  public String getBillingPeriod() {
    return billingPeriod;
  }


  public void setBillingPeriod(String billingPeriod) {
    
    
    
    this.billingPeriod = billingPeriod;
  }


  public PUTScAddTypeAllOf billingPeriodAlignment(String billingPeriodAlignment) {
    
    
    
    
    this.billingPeriodAlignment = billingPeriodAlignment;
    return this;
  }

   /**
   * Aligns charges within the same subscription if multiple charges begin on different dates.  Values:  * &#x60;AlignToCharge&#x60; * &#x60;AlignToSubscriptionStart&#x60; * &#x60;AlignToTermStart&#x60;  Available for the following charge types:  * Recurring * Usage-based 
   * @return billingPeriodAlignment
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Aligns charges within the same subscription if multiple charges begin on different dates.  Values:  * `AlignToCharge` * `AlignToSubscriptionStart` * `AlignToTermStart`  Available for the following charge types:  * Recurring * Usage-based ")

  public String getBillingPeriodAlignment() {
    return billingPeriodAlignment;
  }


  public void setBillingPeriodAlignment(String billingPeriodAlignment) {
    
    
    
    this.billingPeriodAlignment = billingPeriodAlignment;
  }


  public PUTScAddTypeAllOf billingTiming(String billingTiming) {
    
    
    
    
    this.billingTiming = billingTiming;
    return this;
  }

   /**
   * Billing timing for the charge for recurring charge types. Not avaliable for one time, usage and discount charges.  Values:  * &#x60;IN_ADVANCE&#x60; (default) * &#x60;IN_ARREARS&#x60; 
   * @return billingTiming
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Billing timing for the charge for recurring charge types. Not avaliable for one time, usage and discount charges.  Values:  * `IN_ADVANCE` (default) * `IN_ARREARS` ")

  public String getBillingTiming() {
    return billingTiming;
  }


  public void setBillingTiming(String billingTiming) {
    
    
    
    this.billingTiming = billingTiming;
  }


  public PUTScAddTypeAllOf chargeModelConfiguration(ChargeModelConfigurationType chargeModelConfiguration) {
    
    
    
    
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


  public PUTScAddTypeAllOf discountAmount(Double discountAmount) {
    
    
    
    
    this.discountAmount = discountAmount;
    return this;
  }

  public PUTScAddTypeAllOf discountAmount(Integer discountAmount) {
    
    
    
    
    this.discountAmount = discountAmount.doubleValue();
    return this;
  }

   /**
   * Specifies the amount of fixed-amount discount.  Available for the following charge type for the Discount-Fixed Amount charge model:  * Recurring 
   * @return discountAmount
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Specifies the amount of fixed-amount discount.  Available for the following charge type for the Discount-Fixed Amount charge model:  * Recurring ")

  public Double getDiscountAmount() {
    return discountAmount;
  }


  public void setDiscountAmount(Double discountAmount) {
    
    
    
    this.discountAmount = discountAmount;
  }


  public PUTScAddTypeAllOf discountLevel(String discountLevel) {
    
    
    
    
    this.discountLevel = discountLevel;
    return this;
  }

   /**
   * Specifies if the discount applies to the product rate plan only , the entire subscription, or to any activity in the account.  Values:  * &#x60;rateplan&#x60; * &#x60;subscription&#x60; * &#x60;account&#x60;  Available for the following charge type for the Discount-Fixed Amount and Discount-Percentage charge models:  * Recurring 
   * @return discountLevel
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Specifies if the discount applies to the product rate plan only , the entire subscription, or to any activity in the account.  Values:  * `rateplan` * `subscription` * `account`  Available for the following charge type for the Discount-Fixed Amount and Discount-Percentage charge models:  * Recurring ")

  public String getDiscountLevel() {
    return discountLevel;
  }


  public void setDiscountLevel(String discountLevel) {
    
    
    
    this.discountLevel = discountLevel;
  }


  public PUTScAddTypeAllOf discountPercentage(Double discountPercentage) {
    
    
    
    
    this.discountPercentage = discountPercentage;
    return this;
  }

  public PUTScAddTypeAllOf discountPercentage(Integer discountPercentage) {
    
    
    
    
    this.discountPercentage = discountPercentage.doubleValue();
    return this;
  }

   /**
   * Specifies the percentage of a percentage discount.   Available for the following charge type for the Discount-Percentage charge model:  * Recurring 
   * @return discountPercentage
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Specifies the percentage of a percentage discount.   Available for the following charge type for the Discount-Percentage charge model:  * Recurring ")

  public Double getDiscountPercentage() {
    return discountPercentage;
  }


  public void setDiscountPercentage(Double discountPercentage) {
    
    
    
    this.discountPercentage = discountPercentage;
  }


  public PUTScAddTypeAllOf endDateCondition(String endDateCondition) {
    
    
    
    
    this.endDateCondition = endDateCondition;
    return this;
  }

   /**
   * Defines when the charge ends after the charge trigger date. If the subscription ends before the charge end date, the charge ends when the subscription ends. But if the subscription end date is subsequently changed through a Renewal, or Terms and Conditions amendment, the charge will end on the charge end date.  Values:  * &#x60;Subscription_End&#x60; * &#x60;Fixed_Period&#x60; * &#x60;Specific_End_Date&#x60; * &#x60;One_Time&#x60; 
   * @return endDateCondition
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Defines when the charge ends after the charge trigger date. If the subscription ends before the charge end date, the charge ends when the subscription ends. But if the subscription end date is subsequently changed through a Renewal, or Terms and Conditions amendment, the charge will end on the charge end date.  Values:  * `Subscription_End` * `Fixed_Period` * `Specific_End_Date` * `One_Time` ")

  public String getEndDateCondition() {
    return endDateCondition;
  }


  public void setEndDateCondition(String endDateCondition) {
    
    
    
    this.endDateCondition = endDateCondition;
  }


  public PUTScAddTypeAllOf excludeItemBillingFromRevenueAccounting(Boolean excludeItemBillingFromRevenueAccounting) {
    
    
    
    
    this.excludeItemBillingFromRevenueAccounting = excludeItemBillingFromRevenueAccounting;
    return this;
  }

   /**
   * The flag to exclude rate plan charge related invoice items, invoice item adjustments, credit memo items, and debit memo items from revenue accounting.  **Note**: This field is only available if you have the Billing - Revenue Integration feature enabled. 
   * @return excludeItemBillingFromRevenueAccounting
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "false", value = "The flag to exclude rate plan charge related invoice items, invoice item adjustments, credit memo items, and debit memo items from revenue accounting.  **Note**: This field is only available if you have the Billing - Revenue Integration feature enabled. ")

  public Boolean getExcludeItemBillingFromRevenueAccounting() {
    return excludeItemBillingFromRevenueAccounting;
  }


  public void setExcludeItemBillingFromRevenueAccounting(Boolean excludeItemBillingFromRevenueAccounting) {
    
    
    
    this.excludeItemBillingFromRevenueAccounting = excludeItemBillingFromRevenueAccounting;
  }


  public PUTScAddTypeAllOf excludeItemBookingFromRevenueAccounting(Boolean excludeItemBookingFromRevenueAccounting) {
    
    
    
    
    this.excludeItemBookingFromRevenueAccounting = excludeItemBookingFromRevenueAccounting;
    return this;
  }

   /**
   * The flag to exclude rate plan charges from revenue accounting.  **Note**: This field is only available if you have the Billing - Revenue Integration feature enabled. 
   * @return excludeItemBookingFromRevenueAccounting
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "false", value = "The flag to exclude rate plan charges from revenue accounting.  **Note**: This field is only available if you have the Billing - Revenue Integration feature enabled. ")

  public Boolean getExcludeItemBookingFromRevenueAccounting() {
    return excludeItemBookingFromRevenueAccounting;
  }


  public void setExcludeItemBookingFromRevenueAccounting(Boolean excludeItemBookingFromRevenueAccounting) {
    
    
    
    this.excludeItemBookingFromRevenueAccounting = excludeItemBookingFromRevenueAccounting;
  }


  public PUTScAddTypeAllOf includedUnits(Double includedUnits) {
    
    
    
    
    this.includedUnits = includedUnits;
    return this;
  }

  public PUTScAddTypeAllOf includedUnits(Integer includedUnits) {
    
    
    
    
    this.includedUnits = includedUnits.doubleValue();
    return this;
  }

   /**
   * Specifies the number of units in the base set of units for this charge. Must be &gt;&#x3D;&#x60;0&#x60;.  Available for the following charge type for the Overage charge model:  * Usage-based 
   * @return includedUnits
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Specifies the number of units in the base set of units for this charge. Must be >=`0`.  Available for the following charge type for the Overage charge model:  * Usage-based ")

  public Double getIncludedUnits() {
    return includedUnits;
  }


  public void setIncludedUnits(Double includedUnits) {
    
    
    
    this.includedUnits = includedUnits;
  }


  public PUTScAddTypeAllOf isAllocationEligible(Boolean isAllocationEligible) {
    
    
    
    
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


  public PUTScAddTypeAllOf isUnbilled(Boolean isUnbilled) {
    
    
    
    
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


  public PUTScAddTypeAllOf listPriceBase(String listPriceBase) {
    
    
    
    
    this.listPriceBase = listPriceBase;
    return this;
  }

   /**
   * The list price base for the product rate plan charge.  Values:  * &#x60;Per_Billing_Period&#x60; * &#x60;Per_Month&#x60; * &#x60;Per_Week&#x60; * &#x60;Per_Year&#x60; * &#x60;Per_Specific_Months&#x60;  Available for the following charge type for the Flat Fee, Per Unit, Volume Pricing, and Tiered Pricing charge models:  * Recurring 
   * @return listPriceBase
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The list price base for the product rate plan charge.  Values:  * `Per_Billing_Period` * `Per_Month` * `Per_Week` * `Per_Year` * `Per_Specific_Months`  Available for the following charge type for the Flat Fee, Per Unit, Volume Pricing, and Tiered Pricing charge models:  * Recurring ")

  public String getListPriceBase() {
    return listPriceBase;
  }


  public void setListPriceBase(String listPriceBase) {
    
    
    
    this.listPriceBase = listPriceBase;
  }


  public PUTScAddTypeAllOf number(String number) {
    
    
    
    
    this.number = number;
    return this;
  }

   /**
   * Unique number that identifies the charge. System-generated if not provided. 
   * @return number
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Unique number that identifies the charge. System-generated if not provided. ")

  public String getNumber() {
    return number;
  }


  public void setNumber(String number) {
    
    
    
    this.number = number;
  }


  public PUTScAddTypeAllOf numberOfPeriods(Long numberOfPeriods) {
    
    
    
    
    this.numberOfPeriods = numberOfPeriods;
    return this;
  }

   /**
   * Specifies the number of periods to use when calculating charges in an overage smoothing charge model.  Available for the following charge type for the Overage and Tiered with Overage charge models:  * Usage-based 
   * @return numberOfPeriods
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Specifies the number of periods to use when calculating charges in an overage smoothing charge model.  Available for the following charge type for the Overage and Tiered with Overage charge models:  * Usage-based ")

  public Long getNumberOfPeriods() {
    return numberOfPeriods;
  }


  public void setNumberOfPeriods(Long numberOfPeriods) {
    
    
    
    this.numberOfPeriods = numberOfPeriods;
  }


  public PUTScAddTypeAllOf originalOrderDate(LocalDate originalOrderDate) {
    
    
    
    
    this.originalOrderDate = originalOrderDate;
    return this;
  }

   /**
   * The date when the rate plan charge is created through an order or amendment. This field is not updatable.  This field is to standardize the booking date information to increase audit ability and traceability of data between Zuora Billing and Zuora Revenue. It is mapped as the booking date for a sale order line in Zuora Revenue. 
   * @return originalOrderDate
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The date when the rate plan charge is created through an order or amendment. This field is not updatable.  This field is to standardize the booking date information to increase audit ability and traceability of data between Zuora Billing and Zuora Revenue. It is mapped as the booking date for a sale order line in Zuora Revenue. ")

  public LocalDate getOriginalOrderDate() {
    return originalOrderDate;
  }


  public void setOriginalOrderDate(LocalDate originalOrderDate) {
    
    
    
    this.originalOrderDate = originalOrderDate;
  }


  public PUTScAddTypeAllOf overagePrice(Double overagePrice) {
    
    
    
    
    this.overagePrice = overagePrice;
    return this;
  }

  public PUTScAddTypeAllOf overagePrice(Integer overagePrice) {
    
    
    
    
    this.overagePrice = overagePrice.doubleValue();
    return this;
  }

   /**
   * Price for units over the allowed amount.   Available for the following charge type for the Overage and Tiered with Overage charge models:  * Usage-based 
   * @return overagePrice
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Price for units over the allowed amount.   Available for the following charge type for the Overage and Tiered with Overage charge models:  * Usage-based ")

  public Double getOveragePrice() {
    return overagePrice;
  }


  public void setOveragePrice(Double overagePrice) {
    
    
    
    this.overagePrice = overagePrice;
  }


  public PUTScAddTypeAllOf overageUnusedUnitsCreditOption(String overageUnusedUnitsCreditOption) {
    
    
    
    
    this.overageUnusedUnitsCreditOption = overageUnusedUnitsCreditOption;
    return this;
  }

   /**
   * Determines whether to credit the customer with unused units of usage.  Values:  * &#x60;NoCredit&#x60; * &#x60;CreditBySpecificRate&#x60;  Available for the following charge type for the Overage and Tiered with Overage charge models:  * Usage-based 
   * @return overageUnusedUnitsCreditOption
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Determines whether to credit the customer with unused units of usage.  Values:  * `NoCredit` * `CreditBySpecificRate`  Available for the following charge type for the Overage and Tiered with Overage charge models:  * Usage-based ")

  public String getOverageUnusedUnitsCreditOption() {
    return overageUnusedUnitsCreditOption;
  }


  public void setOverageUnusedUnitsCreditOption(String overageUnusedUnitsCreditOption) {
    
    
    
    this.overageUnusedUnitsCreditOption = overageUnusedUnitsCreditOption;
  }


  public PUTScAddTypeAllOf price(Double price) {
    
    
    
    
    this.price = price;
    return this;
  }

  public PUTScAddTypeAllOf price(Integer price) {
    
    
    
    
    this.price = price.doubleValue();
    return this;
  }

   /**
   * Price for units in the subscription rate plan.  Supports all charge types for the Flat Fee and Per Unit charge models 
   * @return price
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Price for units in the subscription rate plan.  Supports all charge types for the Flat Fee and Per Unit charge models ")

  public Double getPrice() {
    return price;
  }


  public void setPrice(Double price) {
    
    
    
    this.price = price;
  }


  public PUTScAddTypeAllOf priceChangeOption(String priceChangeOption) {
    
    
    
    
    this.priceChangeOption = priceChangeOption;
    return this;
  }

   /**
   * Applies an automatic price change when a termed subscription is renewed. The Zuora Billing Admin setting Enable Automatic Price Change When Subscriptions are Renewed?  must be set to Yes to use this field.  See Define Default Subscription Settings for more information on setting this option.  Values:  * &#x60;NoChange&#x60; (default) * &#x60;SpecificPercentageValue&#x60; * &#x60;UseLatestProductCatalogPricing&#x60;  Available for the following charge types:  * Recurring * Usage-based * Not available for the Fixed-Amount Discount charge model. 
   * @return priceChangeOption
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Applies an automatic price change when a termed subscription is renewed. The Zuora Billing Admin setting Enable Automatic Price Change When Subscriptions are Renewed?  must be set to Yes to use this field.  See Define Default Subscription Settings for more information on setting this option.  Values:  * `NoChange` (default) * `SpecificPercentageValue` * `UseLatestProductCatalogPricing`  Available for the following charge types:  * Recurring * Usage-based * Not available for the Fixed-Amount Discount charge model. ")

  public String getPriceChangeOption() {
    return priceChangeOption;
  }


  public void setPriceChangeOption(String priceChangeOption) {
    
    
    
    this.priceChangeOption = priceChangeOption;
  }


  public PUTScAddTypeAllOf priceIncreasePercentage(Double priceIncreasePercentage) {
    
    
    
    
    this.priceIncreasePercentage = priceIncreasePercentage;
    return this;
  }

  public PUTScAddTypeAllOf priceIncreasePercentage(Integer priceIncreasePercentage) {
    
    
    
    
    this.priceIncreasePercentage = priceIncreasePercentage.doubleValue();
    return this;
  }

   /**
   * Specifies the percentage to increase or decrease the price of a termed subscription&#39;s renewal. Required if you set the &#x60;PriceChangeOption&#x60; field to &#x60;SpecificPercentageValue&#x60;.  Decimal between -100 and 100.  Available for the following charge types:  * Recurring * Usage-based  Not available for the Fixed-Amount Discount charge model. 
   * @return priceIncreasePercentage
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Specifies the percentage to increase or decrease the price of a termed subscription's renewal. Required if you set the `PriceChangeOption` field to `SpecificPercentageValue`.  Decimal between -100 and 100.  Available for the following charge types:  * Recurring * Usage-based  Not available for the Fixed-Amount Discount charge model. ")

  public Double getPriceIncreasePercentage() {
    return priceIncreasePercentage;
  }


  public void setPriceIncreasePercentage(Double priceIncreasePercentage) {
    
    
    
    this.priceIncreasePercentage = priceIncreasePercentage;
  }


  public PUTScAddTypeAllOf productRatePlanChargeId(String productRatePlanChargeId) {
    
    
    
    
    this.productRatePlanChargeId = productRatePlanChargeId;
    return this;
  }

   /**
   * 
   * @return productRatePlanChargeId
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")

  public String getProductRatePlanChargeId() {
    return productRatePlanChargeId;
  }


  public void setProductRatePlanChargeId(String productRatePlanChargeId) {
    
    
    
    this.productRatePlanChargeId = productRatePlanChargeId;
  }


  public PUTScAddTypeAllOf productRatePlanChargeNumber(String productRatePlanChargeNumber) {
    
    
    
    
    this.productRatePlanChargeNumber = productRatePlanChargeNumber;
    return this;
  }

   /**
   * Number of a product rate-plan charge for this subscription.                     
   * @return productRatePlanChargeNumber
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Number of a product rate-plan charge for this subscription.                     ")

  public String getProductRatePlanChargeNumber() {
    return productRatePlanChargeNumber;
  }


  public void setProductRatePlanChargeNumber(String productRatePlanChargeNumber) {
    
    
    
    this.productRatePlanChargeNumber = productRatePlanChargeNumber;
  }


  public PUTScAddTypeAllOf quantity(Double quantity) {
    
    
    
    
    this.quantity = quantity;
    return this;
  }

  public PUTScAddTypeAllOf quantity(Integer quantity) {
    
    
    
    
    this.quantity = quantity.doubleValue();
    return this;
  }

   /**
   * Number of units. Must be &gt;&#x3D;&#x60;0&#x60;.  Available for the following charge types for the Per Unit, Volume Pricing, and Tiered Pricing charge models:  * One-time * Recurring 
   * @return quantity
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Number of units. Must be >=`0`.  Available for the following charge types for the Per Unit, Volume Pricing, and Tiered Pricing charge models:  * One-time * Recurring ")

  public Double getQuantity() {
    return quantity;
  }


  public void setQuantity(Double quantity) {
    
    
    
    this.quantity = quantity;
  }


  public PUTScAddTypeAllOf ratingGroup(String ratingGroup) {
    
    
    
    
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


  public PUTScAddTypeAllOf specificBillingPeriod(Long specificBillingPeriod) {
    
    
    
    
    this.specificBillingPeriod = specificBillingPeriod;
    return this;
  }

   /**
   * Specifies the number of month or week for the charges billing period. Required if you set the value of the &#x60;billingPeriod&#x60; field to &#x60;Specific_Months&#x60; or &#x60;Specific_Weeks&#x60;.  Available for the following charge types:  * Recurring * Usage-based 
   * @return specificBillingPeriod
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Specifies the number of month or week for the charges billing period. Required if you set the value of the `billingPeriod` field to `Specific_Months` or `Specific_Weeks`.  Available for the following charge types:  * Recurring * Usage-based ")

  public Long getSpecificBillingPeriod() {
    return specificBillingPeriod;
  }


  public void setSpecificBillingPeriod(Long specificBillingPeriod) {
    
    
    
    this.specificBillingPeriod = specificBillingPeriod;
  }


  public PUTScAddTypeAllOf specificEndDate(LocalDate specificEndDate) {
    
    
    
    
    this.specificEndDate = specificEndDate;
    return this;
  }

   /**
   * Defines when the charge ends after the charge trigger date.  This field is only applicable when the &#x60;endDateCondition&#x60; field is set to &#x60;Specific_End_Date&#x60;.  If the subscription ends before the specific end date, the charge ends when the subscription ends. But if the subscription end date is subsequently changed through a Renewal, or Terms and Conditions amendment, the charge will end on the specific end date. 
   * @return specificEndDate
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Defines when the charge ends after the charge trigger date.  This field is only applicable when the `endDateCondition` field is set to `Specific_End_Date`.  If the subscription ends before the specific end date, the charge ends when the subscription ends. But if the subscription end date is subsequently changed through a Renewal, or Terms and Conditions amendment, the charge will end on the specific end date. ")

  public LocalDate getSpecificEndDate() {
    return specificEndDate;
  }


  public void setSpecificEndDate(LocalDate specificEndDate) {
    
    
    
    this.specificEndDate = specificEndDate;
  }


  public PUTScAddTypeAllOf specificListPriceBase(Integer specificListPriceBase) {
    if (specificListPriceBase != null && specificListPriceBase < 1) {
      throw new IllegalArgumentException("Invalid value for specificListPriceBase. Must be greater than or equal to 1.");
    }
    if (specificListPriceBase != null && specificListPriceBase > 200) {
      throw new IllegalArgumentException("Invalid value for specificListPriceBase. Must be less than or equal to 200.");
    }
    
    
    this.specificListPriceBase = specificListPriceBase;
    return this;
  }

   /**
   * The number of months for the list price base of the charge. This field is required if you set the value of the &#x60;listPriceBase&#x60; field to &#x60;Per_Specific_Months&#x60;.  **Note**:    - This field is available only if you have the &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Billing/Subscriptions/Product_Catalog/I_Annual_List_Price\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Annual List Price&lt;/a&gt; feature enabled.   - The value of this field is &#x60;null&#x60; if you do not set the value of the &#x60;listPriceBase&#x60; field to &#x60;Per_Specific_Months&#x60;. 
   * minimum: 1
   * maximum: 200
   * @return specificListPriceBase
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The number of months for the list price base of the charge. This field is required if you set the value of the `listPriceBase` field to `Per_Specific_Months`.  **Note**:    - This field is available only if you have the <a href=\"https://knowledgecenter.zuora.com/Billing/Subscriptions/Product_Catalog/I_Annual_List_Price\" target=\"_blank\">Annual List Price</a> feature enabled.   - The value of this field is `null` if you do not set the value of the `listPriceBase` field to `Per_Specific_Months`. ")

  public Integer getSpecificListPriceBase() {
    return specificListPriceBase;
  }


  public void setSpecificListPriceBase(Integer specificListPriceBase) {
    if (specificListPriceBase != null && specificListPriceBase < 1) {
      throw new IllegalArgumentException("Invalid value for specificListPriceBase. Must be greater than or equal to 1.");
    }
    if (specificListPriceBase != null && specificListPriceBase > 200) {
      throw new IllegalArgumentException("Invalid value for specificListPriceBase. Must be less than or equal to 200.");
    }
    
    this.specificListPriceBase = specificListPriceBase;
  }


  public PUTScAddTypeAllOf tiers(List<POSTTierType> tiers) {
    
    
    
    
    this.tiers = tiers;
    return this;
  }

  public PUTScAddTypeAllOf addTiersItem(POSTTierType tiersItem) {
    if (this.tiers == null) {
      this.tiers = new ArrayList<>();
    }
    this.tiers.add(tiersItem);
    return this;
  }

   /**
   * Container for Volume, Tiered or Tiered with Overage charge models. Supports the following charge types:  * One-time * Recurring * Usage-based 
   * @return tiers
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Container for Volume, Tiered or Tiered with Overage charge models. Supports the following charge types:  * One-time * Recurring * Usage-based ")

  public List<POSTTierType> getTiers() {
    return tiers;
  }


  public void setTiers(List<POSTTierType> tiers) {
    
    
    
    this.tiers = tiers;
  }


  public PUTScAddTypeAllOf triggerDate(LocalDate triggerDate) {
    
    
    
    
    this.triggerDate = triggerDate;
    return this;
  }

   /**
   * Specifies when to start billing the customer for the charge. Required if the &#x60;triggerEvent&#x60; field is set to &#x60;USD&#x60;. 
   * @return triggerDate
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Specifies when to start billing the customer for the charge. Required if the `triggerEvent` field is set to `USD`. ")

  public LocalDate getTriggerDate() {
    return triggerDate;
  }


  public void setTriggerDate(LocalDate triggerDate) {
    
    
    
    this.triggerDate = triggerDate;
  }


  public PUTScAddTypeAllOf triggerEvent(String triggerEvent) {
    
    
    
    
    this.triggerEvent = triggerEvent;
    return this;
  }

   /**
   * Specifies when to start billing the customer for the charge.  Values:  * &#x60;UCE&#x60; * &#x60;USA&#x60; * &#x60;UCA&#x60; * &#x60;USD&#x60; 
   * @return triggerEvent
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Specifies when to start billing the customer for the charge.  Values:  * `UCE` * `USA` * `UCA` * `USD` ")

  public String getTriggerEvent() {
    return triggerEvent;
  }


  public void setTriggerEvent(String triggerEvent) {
    
    
    
    this.triggerEvent = triggerEvent;
  }


  public PUTScAddTypeAllOf unusedUnitsCreditRates(Double unusedUnitsCreditRates) {
    
    
    
    
    this.unusedUnitsCreditRates = unusedUnitsCreditRates;
    return this;
  }

  public PUTScAddTypeAllOf unusedUnitsCreditRates(Integer unusedUnitsCreditRates) {
    
    
    
    
    this.unusedUnitsCreditRates = unusedUnitsCreditRates.doubleValue();
    return this;
  }

   /**
   * Specifies the rate to credit a customer for unused units of usage. This field applies only for overage charge models when the &#x60;OverageUnusedUnitsCreditOption&#x60; field is set to &#x60;CreditBySpecificRate&#x60;.  Available for the following charge type for the Overage and Tiered with Overage charge models:  * Usage-based 
   * @return unusedUnitsCreditRates
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Specifies the rate to credit a customer for unused units of usage. This field applies only for overage charge models when the `OverageUnusedUnitsCreditOption` field is set to `CreditBySpecificRate`.  Available for the following charge type for the Overage and Tiered with Overage charge models:  * Usage-based ")

  public Double getUnusedUnitsCreditRates() {
    return unusedUnitsCreditRates;
  }


  public void setUnusedUnitsCreditRates(Double unusedUnitsCreditRates) {
    
    
    
    this.unusedUnitsCreditRates = unusedUnitsCreditRates;
  }


  public PUTScAddTypeAllOf upToPeriods(Long upToPeriods) {
    
    
    
    
    this.upToPeriods = upToPeriods;
    return this;
  }

   /**
   * The period type used to define when the charge ends.   Values:  * &#x60;Billing_Periods&#x60; * &#x60;Days&#x60; * &#x60;Weeks&#x60; * &#x60;Months&#x60; * &#x60;Years&#x60;  You must use this field together with the &#x60;upToPeriods&#x60; field to specify the time period.  This field is applicable only when the &#x60;endDateCondition&#x60; field is set to &#x60;Fixed_Period&#x60;.  
   * @return upToPeriods
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The period type used to define when the charge ends.   Values:  * `Billing_Periods` * `Days` * `Weeks` * `Months` * `Years`  You must use this field together with the `upToPeriods` field to specify the time period.  This field is applicable only when the `endDateCondition` field is set to `Fixed_Period`.  ")

  public Long getUpToPeriods() {
    return upToPeriods;
  }


  public void setUpToPeriods(Long upToPeriods) {
    
    
    
    this.upToPeriods = upToPeriods;
  }


  public PUTScAddTypeAllOf upToPeriodsType(String upToPeriodsType) {
    
    
    
    
    this.upToPeriodsType = upToPeriodsType;
    return this;
  }

   /**
   * The period type used to define when the charge ends.   Values:  * &#x60;Billing_Periods&#x60; * &#x60;Days&#x60; * &#x60;Weeks&#x60; * &#x60;Months&#x60; * &#x60;Years&#x60;  You must use this field together with the &#x60;upToPeriods&#x60; field to specify the time period.  This field is applicable only when the &#x60;endDateCondition&#x60; field is set to &#x60;Fixed_Period&#x60;.  
   * @return upToPeriodsType
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The period type used to define when the charge ends.   Values:  * `Billing_Periods` * `Days` * `Weeks` * `Months` * `Years`  You must use this field together with the `upToPeriods` field to specify the time period.  This field is applicable only when the `endDateCondition` field is set to `Fixed_Period`.  ")

  public String getUpToPeriodsType() {
    return upToPeriodsType;
  }


  public void setUpToPeriodsType(String upToPeriodsType) {
    
    
    
    this.upToPeriodsType = upToPeriodsType;
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
   * @return the PUTScAddTypeAllOf instance itself
   */
  public PUTScAddTypeAllOf putAdditionalProperty(String key, Object value) {
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
    PUTScAddTypeAllOf puTScAddTypeAllOf = (PUTScAddTypeAllOf) o;
    return Objects.equals(this.description, puTScAddTypeAllOf.description) &&
        Objects.equals(this.amendedByOrderOn, puTScAddTypeAllOf.amendedByOrderOn) &&
        Objects.equals(this.applyDiscountTo, puTScAddTypeAllOf.applyDiscountTo) &&
        Objects.equals(this.billCycleDay, puTScAddTypeAllOf.billCycleDay) &&
        Objects.equals(this.billCycleType, puTScAddTypeAllOf.billCycleType) &&
        Objects.equals(this.billingPeriod, puTScAddTypeAllOf.billingPeriod) &&
        Objects.equals(this.billingPeriodAlignment, puTScAddTypeAllOf.billingPeriodAlignment) &&
        Objects.equals(this.billingTiming, puTScAddTypeAllOf.billingTiming) &&
        Objects.equals(this.chargeModelConfiguration, puTScAddTypeAllOf.chargeModelConfiguration) &&
        Objects.equals(this.discountAmount, puTScAddTypeAllOf.discountAmount) &&
        Objects.equals(this.discountLevel, puTScAddTypeAllOf.discountLevel) &&
        Objects.equals(this.discountPercentage, puTScAddTypeAllOf.discountPercentage) &&
        Objects.equals(this.endDateCondition, puTScAddTypeAllOf.endDateCondition) &&
        Objects.equals(this.excludeItemBillingFromRevenueAccounting, puTScAddTypeAllOf.excludeItemBillingFromRevenueAccounting) &&
        Objects.equals(this.excludeItemBookingFromRevenueAccounting, puTScAddTypeAllOf.excludeItemBookingFromRevenueAccounting) &&
        Objects.equals(this.includedUnits, puTScAddTypeAllOf.includedUnits) &&
        Objects.equals(this.isAllocationEligible, puTScAddTypeAllOf.isAllocationEligible) &&
        Objects.equals(this.isUnbilled, puTScAddTypeAllOf.isUnbilled) &&
        Objects.equals(this.listPriceBase, puTScAddTypeAllOf.listPriceBase) &&
        Objects.equals(this.number, puTScAddTypeAllOf.number) &&
        Objects.equals(this.numberOfPeriods, puTScAddTypeAllOf.numberOfPeriods) &&
        Objects.equals(this.originalOrderDate, puTScAddTypeAllOf.originalOrderDate) &&
        Objects.equals(this.overagePrice, puTScAddTypeAllOf.overagePrice) &&
        Objects.equals(this.overageUnusedUnitsCreditOption, puTScAddTypeAllOf.overageUnusedUnitsCreditOption) &&
        Objects.equals(this.price, puTScAddTypeAllOf.price) &&
        Objects.equals(this.priceChangeOption, puTScAddTypeAllOf.priceChangeOption) &&
        Objects.equals(this.priceIncreasePercentage, puTScAddTypeAllOf.priceIncreasePercentage) &&
        Objects.equals(this.productRatePlanChargeId, puTScAddTypeAllOf.productRatePlanChargeId) &&
        Objects.equals(this.productRatePlanChargeNumber, puTScAddTypeAllOf.productRatePlanChargeNumber) &&
        Objects.equals(this.quantity, puTScAddTypeAllOf.quantity) &&
        Objects.equals(this.ratingGroup, puTScAddTypeAllOf.ratingGroup) &&
        Objects.equals(this.specificBillingPeriod, puTScAddTypeAllOf.specificBillingPeriod) &&
        Objects.equals(this.specificEndDate, puTScAddTypeAllOf.specificEndDate) &&
        Objects.equals(this.specificListPriceBase, puTScAddTypeAllOf.specificListPriceBase) &&
        Objects.equals(this.tiers, puTScAddTypeAllOf.tiers) &&
        Objects.equals(this.triggerDate, puTScAddTypeAllOf.triggerDate) &&
        Objects.equals(this.triggerEvent, puTScAddTypeAllOf.triggerEvent) &&
        Objects.equals(this.unusedUnitsCreditRates, puTScAddTypeAllOf.unusedUnitsCreditRates) &&
        Objects.equals(this.upToPeriods, puTScAddTypeAllOf.upToPeriods) &&
        Objects.equals(this.upToPeriodsType, puTScAddTypeAllOf.upToPeriodsType)&&
        Objects.equals(this.additionalProperties, puTScAddTypeAllOf.additionalProperties);
  }

  @Override
  public int hashCode() {
    return Objects.hash(description, amendedByOrderOn, applyDiscountTo, billCycleDay, billCycleType, billingPeriod, billingPeriodAlignment, billingTiming, chargeModelConfiguration, discountAmount, discountLevel, discountPercentage, endDateCondition, excludeItemBillingFromRevenueAccounting, excludeItemBookingFromRevenueAccounting, includedUnits, isAllocationEligible, isUnbilled, listPriceBase, number, numberOfPeriods, originalOrderDate, overagePrice, overageUnusedUnitsCreditOption, price, priceChangeOption, priceIncreasePercentage, productRatePlanChargeId, productRatePlanChargeNumber, quantity, ratingGroup, specificBillingPeriod, specificEndDate, specificListPriceBase, tiers, triggerDate, triggerEvent, unusedUnitsCreditRates, upToPeriods, upToPeriodsType, additionalProperties);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PUTScAddTypeAllOf {\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    amendedByOrderOn: ").append(toIndentedString(amendedByOrderOn)).append("\n");
    sb.append("    applyDiscountTo: ").append(toIndentedString(applyDiscountTo)).append("\n");
    sb.append("    billCycleDay: ").append(toIndentedString(billCycleDay)).append("\n");
    sb.append("    billCycleType: ").append(toIndentedString(billCycleType)).append("\n");
    sb.append("    billingPeriod: ").append(toIndentedString(billingPeriod)).append("\n");
    sb.append("    billingPeriodAlignment: ").append(toIndentedString(billingPeriodAlignment)).append("\n");
    sb.append("    billingTiming: ").append(toIndentedString(billingTiming)).append("\n");
    sb.append("    chargeModelConfiguration: ").append(toIndentedString(chargeModelConfiguration)).append("\n");
    sb.append("    discountAmount: ").append(toIndentedString(discountAmount)).append("\n");
    sb.append("    discountLevel: ").append(toIndentedString(discountLevel)).append("\n");
    sb.append("    discountPercentage: ").append(toIndentedString(discountPercentage)).append("\n");
    sb.append("    endDateCondition: ").append(toIndentedString(endDateCondition)).append("\n");
    sb.append("    excludeItemBillingFromRevenueAccounting: ").append(toIndentedString(excludeItemBillingFromRevenueAccounting)).append("\n");
    sb.append("    excludeItemBookingFromRevenueAccounting: ").append(toIndentedString(excludeItemBookingFromRevenueAccounting)).append("\n");
    sb.append("    includedUnits: ").append(toIndentedString(includedUnits)).append("\n");
    sb.append("    isAllocationEligible: ").append(toIndentedString(isAllocationEligible)).append("\n");
    sb.append("    isUnbilled: ").append(toIndentedString(isUnbilled)).append("\n");
    sb.append("    listPriceBase: ").append(toIndentedString(listPriceBase)).append("\n");
    sb.append("    number: ").append(toIndentedString(number)).append("\n");
    sb.append("    numberOfPeriods: ").append(toIndentedString(numberOfPeriods)).append("\n");
    sb.append("    originalOrderDate: ").append(toIndentedString(originalOrderDate)).append("\n");
    sb.append("    overagePrice: ").append(toIndentedString(overagePrice)).append("\n");
    sb.append("    overageUnusedUnitsCreditOption: ").append(toIndentedString(overageUnusedUnitsCreditOption)).append("\n");
    sb.append("    price: ").append(toIndentedString(price)).append("\n");
    sb.append("    priceChangeOption: ").append(toIndentedString(priceChangeOption)).append("\n");
    sb.append("    priceIncreasePercentage: ").append(toIndentedString(priceIncreasePercentage)).append("\n");
    sb.append("    productRatePlanChargeId: ").append(toIndentedString(productRatePlanChargeId)).append("\n");
    sb.append("    productRatePlanChargeNumber: ").append(toIndentedString(productRatePlanChargeNumber)).append("\n");
    sb.append("    quantity: ").append(toIndentedString(quantity)).append("\n");
    sb.append("    ratingGroup: ").append(toIndentedString(ratingGroup)).append("\n");
    sb.append("    specificBillingPeriod: ").append(toIndentedString(specificBillingPeriod)).append("\n");
    sb.append("    specificEndDate: ").append(toIndentedString(specificEndDate)).append("\n");
    sb.append("    specificListPriceBase: ").append(toIndentedString(specificListPriceBase)).append("\n");
    sb.append("    tiers: ").append(toIndentedString(tiers)).append("\n");
    sb.append("    triggerDate: ").append(toIndentedString(triggerDate)).append("\n");
    sb.append("    triggerEvent: ").append(toIndentedString(triggerEvent)).append("\n");
    sb.append("    unusedUnitsCreditRates: ").append(toIndentedString(unusedUnitsCreditRates)).append("\n");
    sb.append("    upToPeriods: ").append(toIndentedString(upToPeriods)).append("\n");
    sb.append("    upToPeriodsType: ").append(toIndentedString(upToPeriodsType)).append("\n");
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
    openapiFields.add("amendedByOrderOn");
    openapiFields.add("applyDiscountTo");
    openapiFields.add("billCycleDay");
    openapiFields.add("billCycleType");
    openapiFields.add("billingPeriod");
    openapiFields.add("billingPeriodAlignment");
    openapiFields.add("billingTiming");
    openapiFields.add("chargeModelConfiguration");
    openapiFields.add("discountAmount");
    openapiFields.add("discountLevel");
    openapiFields.add("discountPercentage");
    openapiFields.add("endDateCondition");
    openapiFields.add("excludeItemBillingFromRevenueAccounting");
    openapiFields.add("excludeItemBookingFromRevenueAccounting");
    openapiFields.add("includedUnits");
    openapiFields.add("isAllocationEligible");
    openapiFields.add("isUnbilled");
    openapiFields.add("listPriceBase");
    openapiFields.add("number");
    openapiFields.add("numberOfPeriods");
    openapiFields.add("originalOrderDate");
    openapiFields.add("overagePrice");
    openapiFields.add("overageUnusedUnitsCreditOption");
    openapiFields.add("price");
    openapiFields.add("priceChangeOption");
    openapiFields.add("priceIncreasePercentage");
    openapiFields.add("productRatePlanChargeId");
    openapiFields.add("productRatePlanChargeNumber");
    openapiFields.add("quantity");
    openapiFields.add("ratingGroup");
    openapiFields.add("specificBillingPeriod");
    openapiFields.add("specificEndDate");
    openapiFields.add("specificListPriceBase");
    openapiFields.add("tiers");
    openapiFields.add("triggerDate");
    openapiFields.add("triggerEvent");
    openapiFields.add("unusedUnitsCreditRates");
    openapiFields.add("upToPeriods");
    openapiFields.add("upToPeriodsType");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
    openapiRequiredFields.add("productRatePlanChargeId");
  }

 /**
  * Validates the JSON Object and throws an exception if issues found
  *
  * @param jsonObj JSON Object
  * @throws IOException if the JSON Object is invalid with respect to PUTScAddTypeAllOf
  */
  public static void validateJsonObject(JsonObject jsonObj) throws IOException {
      if (jsonObj == null) {
        if (!PUTScAddTypeAllOf.openapiRequiredFields.isEmpty()) { // has required fields but JSON object is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in PUTScAddTypeAllOf is not found in the empty JSON string", PUTScAddTypeAllOf.openapiRequiredFields.toString()));
        }
      }

      // check to make sure all required properties/fields are present in the JSON string
      for (String requiredField : PUTScAddTypeAllOf.openapiRequiredFields) {
        if (jsonObj.get(requiredField) == null) {
          throw new IllegalArgumentException(String.format("The required field `%s` is not found in the JSON string: %s", requiredField, jsonObj.toString()));
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
      if ((jsonObj.get("billCycleDay") != null && !jsonObj.get("billCycleDay").isJsonNull()) && !jsonObj.get("billCycleDay").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `billCycleDay` to be a primitive type in the JSON string but got `%s`", jsonObj.get("billCycleDay").toString()));
      }
      if ((jsonObj.get("billCycleType") != null && !jsonObj.get("billCycleType").isJsonNull()) && !jsonObj.get("billCycleType").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `billCycleType` to be a primitive type in the JSON string but got `%s`", jsonObj.get("billCycleType").toString()));
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
      // validate the optional field `chargeModelConfiguration`
      if (jsonObj.get("chargeModelConfiguration") != null && !jsonObj.get("chargeModelConfiguration").isJsonNull()) {
        ChargeModelConfigurationType.validateJsonObject(jsonObj.getAsJsonObject("chargeModelConfiguration"));
      }
      if ((jsonObj.get("discountLevel") != null && !jsonObj.get("discountLevel").isJsonNull()) && !jsonObj.get("discountLevel").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `discountLevel` to be a primitive type in the JSON string but got `%s`", jsonObj.get("discountLevel").toString()));
      }
      if ((jsonObj.get("endDateCondition") != null && !jsonObj.get("endDateCondition").isJsonNull()) && !jsonObj.get("endDateCondition").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `endDateCondition` to be a primitive type in the JSON string but got `%s`", jsonObj.get("endDateCondition").toString()));
      }
      if ((jsonObj.get("listPriceBase") != null && !jsonObj.get("listPriceBase").isJsonNull()) && !jsonObj.get("listPriceBase").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `listPriceBase` to be a primitive type in the JSON string but got `%s`", jsonObj.get("listPriceBase").toString()));
      }
      if ((jsonObj.get("number") != null && !jsonObj.get("number").isJsonNull()) && !jsonObj.get("number").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `number` to be a primitive type in the JSON string but got `%s`", jsonObj.get("number").toString()));
      }
      if ((jsonObj.get("overageUnusedUnitsCreditOption") != null && !jsonObj.get("overageUnusedUnitsCreditOption").isJsonNull()) && !jsonObj.get("overageUnusedUnitsCreditOption").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `overageUnusedUnitsCreditOption` to be a primitive type in the JSON string but got `%s`", jsonObj.get("overageUnusedUnitsCreditOption").toString()));
      }
      if ((jsonObj.get("priceChangeOption") != null && !jsonObj.get("priceChangeOption").isJsonNull()) && !jsonObj.get("priceChangeOption").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `priceChangeOption` to be a primitive type in the JSON string but got `%s`", jsonObj.get("priceChangeOption").toString()));
      }
      if (!jsonObj.get("productRatePlanChargeId").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `productRatePlanChargeId` to be a primitive type in the JSON string but got `%s`", jsonObj.get("productRatePlanChargeId").toString()));
      }
      if ((jsonObj.get("productRatePlanChargeNumber") != null && !jsonObj.get("productRatePlanChargeNumber").isJsonNull()) && !jsonObj.get("productRatePlanChargeNumber").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `productRatePlanChargeNumber` to be a primitive type in the JSON string but got `%s`", jsonObj.get("productRatePlanChargeNumber").toString()));
      }
      if ((jsonObj.get("ratingGroup") != null && !jsonObj.get("ratingGroup").isJsonNull()) && !jsonObj.get("ratingGroup").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `ratingGroup` to be a primitive type in the JSON string but got `%s`", jsonObj.get("ratingGroup").toString()));
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
            POSTTierType.validateJsonObject(jsonArraytiers.get(i).getAsJsonObject());
          };
        }
      }
      if ((jsonObj.get("triggerEvent") != null && !jsonObj.get("triggerEvent").isJsonNull()) && !jsonObj.get("triggerEvent").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `triggerEvent` to be a primitive type in the JSON string but got `%s`", jsonObj.get("triggerEvent").toString()));
      }
      if ((jsonObj.get("upToPeriodsType") != null && !jsonObj.get("upToPeriodsType").isJsonNull()) && !jsonObj.get("upToPeriodsType").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `upToPeriodsType` to be a primitive type in the JSON string but got `%s`", jsonObj.get("upToPeriodsType").toString()));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!PUTScAddTypeAllOf.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'PUTScAddTypeAllOf' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<PUTScAddTypeAllOf> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(PUTScAddTypeAllOf.class));

       return (TypeAdapter<T>) new TypeAdapter<PUTScAddTypeAllOf>() {
           @Override
           public void write(JsonWriter out, PUTScAddTypeAllOf value) throws IOException {
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
           public PUTScAddTypeAllOf read(JsonReader in) throws IOException {
             JsonObject jsonObj = elementAdapter.read(in).getAsJsonObject();
             validateJsonObject(jsonObj);
             // store additional fields in the deserialized instance
             PUTScAddTypeAllOf instance = thisAdapter.fromJsonTree(jsonObj);
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
  * Create an instance of PUTScAddTypeAllOf given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of PUTScAddTypeAllOf
  * @throws IOException if the JSON string is invalid with respect to PUTScAddTypeAllOf
  */
  public static PUTScAddTypeAllOf fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, PUTScAddTypeAllOf.class);
  }

 /**
  * Convert an instance of PUTScAddTypeAllOf to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

