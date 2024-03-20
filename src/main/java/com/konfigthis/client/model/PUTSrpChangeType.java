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
import com.konfigthis.client.model.PUTScAddType;
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
 * PUTSrpChangeType
 */@javax.annotation.Generated(value = "Generated by https://konfigthis.com")
public class PUTSrpChangeType {
  public static final String SERIALIZED_NAME_BOOKING_DATE = "bookingDate";
  @SerializedName(SERIALIZED_NAME_BOOKING_DATE)
  private LocalDate bookingDate;

  public static final String SERIALIZED_NAME_CHARGE_OVERRIDES = "chargeOverrides";
  @SerializedName(SERIALIZED_NAME_CHARGE_OVERRIDES)
  private List<PUTScAddType> chargeOverrides = null;

  public static final String SERIALIZED_NAME_CONTRACT_EFFECTIVE_DATE = "contractEffectiveDate";
  @SerializedName(SERIALIZED_NAME_CONTRACT_EFFECTIVE_DATE)
  private LocalDate contractEffectiveDate;

  public static final String SERIALIZED_NAME_CUSTOMER_ACCEPTANCE_DATE = "customerAcceptanceDate";
  @SerializedName(SERIALIZED_NAME_CUSTOMER_ACCEPTANCE_DATE)
  private LocalDate customerAcceptanceDate;

  /**
   * The default value for the &#x60;effectivePolicy&#x60; field is as follows:   * If the rate plan change (from old to new) is an upgrade, the effective policy is &#x60;EffectiveImmediately&#x60; by default.   * If the rate plan change (from old to new) is a downgrade, the effective policy is &#x60;EffectiveEndOfBillingPeriod&#x60; by default.   * Otherwise, the effective policy is &#x60;SpecificDate&#x60; by default.  **Notes**:    * When setting this field to &#x60;EffectiveEndOfBillingPeriod&#x60;, you cannot set the &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Subscriptions/Subscriptions/W_Subscription_and_Amendment_Dates#Billing_Trigger_Dates\&quot; target&#x3D;\&quot;_blank\&quot;&gt;billing trigger dates&lt;/a&gt; for the subscription as the system will automatically set the trigger dates to the end of billing period.   * When setting this field to &#x60;SpecificDate&#x60;, you must also set the &#x60;contractEffectiveDate&#x60; field. 
   */
  @JsonAdapter(EffectivePolicyEnum.Adapter.class)
 public enum EffectivePolicyEnum {
    EFFECTIVEIMMEDIATELY("EffectiveImmediately"),
    
    EFFECTIVEENDOFBILLINGPERIOD("EffectiveEndOfBillingPeriod"),
    
    SPECIFICDATE("SpecificDate");

    private String value;

    EffectivePolicyEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static EffectivePolicyEnum fromValue(String value) {
      for (EffectivePolicyEnum b : EffectivePolicyEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<EffectivePolicyEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final EffectivePolicyEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public EffectivePolicyEnum read(final JsonReader jsonReader) throws IOException {
        String value =  jsonReader.nextString();
        return EffectivePolicyEnum.fromValue(value);
      }
    }
  }

  public static final String SERIALIZED_NAME_EFFECTIVE_POLICY = "effectivePolicy";
  @SerializedName(SERIALIZED_NAME_EFFECTIVE_POLICY)
  private EffectivePolicyEnum effectivePolicy;

  public static final String SERIALIZED_NAME_EXTERNAL_CATALOG_PLAN_ID = "externalCatalogPlanId";
  @SerializedName(SERIALIZED_NAME_EXTERNAL_CATALOG_PLAN_ID)
  private String externalCatalogPlanId;

  public static final String SERIALIZED_NAME_EXTERNAL_ID_SOURCE_SYSTEM = "externalIdSourceSystem";
  @SerializedName(SERIALIZED_NAME_EXTERNAL_ID_SOURCE_SYSTEM)
  private String externalIdSourceSystem;

  public static final String SERIALIZED_NAME_NEW_EXTERNAL_CATALOG_PLAN_ID = "newExternalCatalogPlanId";
  @SerializedName(SERIALIZED_NAME_NEW_EXTERNAL_CATALOG_PLAN_ID)
  private String newExternalCatalogPlanId;

  public static final String SERIALIZED_NAME_NEW_EXTERNAL_ID_SOURCE_SYSTEM = "newExternalIdSourceSystem";
  @SerializedName(SERIALIZED_NAME_NEW_EXTERNAL_ID_SOURCE_SYSTEM)
  private String newExternalIdSourceSystem;

  public static final String SERIALIZED_NAME_NEW_PRODUCT_RATE_PLAN_ID = "newProductRatePlanId";
  @SerializedName(SERIALIZED_NAME_NEW_PRODUCT_RATE_PLAN_ID)
  private String newProductRatePlanId;

  public static final String SERIALIZED_NAME_NEW_PRODUCT_RATE_PLAN_NUMBER = "newProductRatePlanNumber";
  @SerializedName(SERIALIZED_NAME_NEW_PRODUCT_RATE_PLAN_NUMBER)
  private String newProductRatePlanNumber;

  public static final String SERIALIZED_NAME_PRODUCT_RATE_PLAN_ID = "productRatePlanId";
  @SerializedName(SERIALIZED_NAME_PRODUCT_RATE_PLAN_ID)
  private String productRatePlanId;

  public static final String SERIALIZED_NAME_PRODUCT_RATE_PLAN_NUMBER = "productRatePlanNumber";
  @SerializedName(SERIALIZED_NAME_PRODUCT_RATE_PLAN_NUMBER)
  private String productRatePlanNumber;

  public static final String SERIALIZED_NAME_RATE_PLAN_ID = "ratePlanId";
  @SerializedName(SERIALIZED_NAME_RATE_PLAN_ID)
  private String ratePlanId;

  public static final String SERIALIZED_NAME_RESET_BCD = "resetBcd";
  @SerializedName(SERIALIZED_NAME_RESET_BCD)
  private Boolean resetBcd = false;

  public static final String SERIALIZED_NAME_SERVICE_ACTIVATION_DATE = "serviceActivationDate";
  @SerializedName(SERIALIZED_NAME_SERVICE_ACTIVATION_DATE)
  private LocalDate serviceActivationDate;

  /**
   * Use this field to choose the sub type for your change plan amendment.   However, if you do not set this field, the field will be automatically generated by the system according to the following rules:  When the old and new rate plans are within the same Grading catalog group: * If the grade of new plan is greater than that of the old plan, this is an \&quot;Upgrade\&quot;. * If the grade of new plan is less than that of the old plan, this is a \&quot;Downgrade\&quot;. * If the grade of new plan equals that of the old plan, this is a \&quot;Crossgrade\&quot;.  When the old and new rate plans are not in the same Grading catalog group, or either has no group, this is \&quot;PlanChanged\&quot;. 
   */
  @JsonAdapter(SubTypeEnum.Adapter.class)
 public enum SubTypeEnum {
    UPGRADE("Upgrade"),
    
    DOWNGRADE("Downgrade"),
    
    CROSSGRADE("Crossgrade"),
    
    PLANCHANGED("PlanChanged");

    private String value;

    SubTypeEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static SubTypeEnum fromValue(String value) {
      for (SubTypeEnum b : SubTypeEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<SubTypeEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final SubTypeEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public SubTypeEnum read(final JsonReader jsonReader) throws IOException {
        String value =  jsonReader.nextString();
        return SubTypeEnum.fromValue(value);
      }
    }
  }

  public static final String SERIALIZED_NAME_SUB_TYPE = "subType";
  @SerializedName(SERIALIZED_NAME_SUB_TYPE)
  private SubTypeEnum subType;

  public static final String SERIALIZED_NAME_SUBSCRIPTION_RATE_PLAN_NUMBER = "subscriptionRatePlanNumber";
  @SerializedName(SERIALIZED_NAME_SUBSCRIPTION_RATE_PLAN_NUMBER)
  private String subscriptionRatePlanNumber;

  public PUTSrpChangeType() {
  }

  public PUTSrpChangeType bookingDate(LocalDate bookingDate) {
    
    
    
    
    this.bookingDate = bookingDate;
    return this;
  }

   /**
   * The booking date that you want to set for the amendment contract. The booking date of an amendment is the equivalent of the order date of an order. This field must be in the &#x60;yyyy-mm-dd&#x60; format. The default value is the current date when you make the API call.  
   * @return bookingDate
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The booking date that you want to set for the amendment contract. The booking date of an amendment is the equivalent of the order date of an order. This field must be in the `yyyy-mm-dd` format. The default value is the current date when you make the API call.  ")

  public LocalDate getBookingDate() {
    return bookingDate;
  }


  public void setBookingDate(LocalDate bookingDate) {
    
    
    
    this.bookingDate = bookingDate;
  }


  public PUTSrpChangeType chargeOverrides(List<PUTScAddType> chargeOverrides) {
    
    
    
    
    this.chargeOverrides = chargeOverrides;
    return this;
  }

  public PUTSrpChangeType addChargeOverridesItem(PUTScAddType chargeOverridesItem) {
    if (this.chargeOverrides == null) {
      this.chargeOverrides = new ArrayList<>();
    }
    this.chargeOverrides.add(chargeOverridesItem);
    return this;
  }

   /**
   * This optional container is used to override one or more product rate plan charges for this subscription.
   * @return chargeOverrides
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "This optional container is used to override one or more product rate plan charges for this subscription.")

  public List<PUTScAddType> getChargeOverrides() {
    return chargeOverrides;
  }


  public void setChargeOverrides(List<PUTScAddType> chargeOverrides) {
    
    
    
    this.chargeOverrides = chargeOverrides;
  }


  public PUTSrpChangeType contractEffectiveDate(LocalDate contractEffectiveDate) {
    
    
    
    
    this.contractEffectiveDate = contractEffectiveDate;
    return this;
  }

   /**
   * Effective date of the new subscription, as yyyy-mm-dd.
   * @return contractEffectiveDate
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Effective date of the new subscription, as yyyy-mm-dd.")

  public LocalDate getContractEffectiveDate() {
    return contractEffectiveDate;
  }


  public void setContractEffectiveDate(LocalDate contractEffectiveDate) {
    
    
    
    this.contractEffectiveDate = contractEffectiveDate;
  }


  public PUTSrpChangeType customerAcceptanceDate(LocalDate customerAcceptanceDate) {
    
    
    
    
    this.customerAcceptanceDate = customerAcceptanceDate;
    return this;
  }

   /**
   * The date when the customer accepts the contract in yyyy-mm-dd format. When this field is not set: * If the &#x60;serviceActivationDate&#x60; field is not set, the value of this field is set to be the contract effective date. * If the &#x60;serviceActivationDate&#x60; field is set, the value of this field is set to be the service activation date.  The billing trigger dates must follow this rule: contractEffectiveDate &lt;&#x3D; serviceActivationDate &lt;&#x3D; contractAcceptanceDate 
   * @return customerAcceptanceDate
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The date when the customer accepts the contract in yyyy-mm-dd format. When this field is not set: * If the `serviceActivationDate` field is not set, the value of this field is set to be the contract effective date. * If the `serviceActivationDate` field is set, the value of this field is set to be the service activation date.  The billing trigger dates must follow this rule: contractEffectiveDate <= serviceActivationDate <= contractAcceptanceDate ")

  public LocalDate getCustomerAcceptanceDate() {
    return customerAcceptanceDate;
  }


  public void setCustomerAcceptanceDate(LocalDate customerAcceptanceDate) {
    
    
    
    this.customerAcceptanceDate = customerAcceptanceDate;
  }


  public PUTSrpChangeType effectivePolicy(EffectivePolicyEnum effectivePolicy) {
    
    
    
    
    this.effectivePolicy = effectivePolicy;
    return this;
  }

   /**
   * The default value for the &#x60;effectivePolicy&#x60; field is as follows:   * If the rate plan change (from old to new) is an upgrade, the effective policy is &#x60;EffectiveImmediately&#x60; by default.   * If the rate plan change (from old to new) is a downgrade, the effective policy is &#x60;EffectiveEndOfBillingPeriod&#x60; by default.   * Otherwise, the effective policy is &#x60;SpecificDate&#x60; by default.  **Notes**:    * When setting this field to &#x60;EffectiveEndOfBillingPeriod&#x60;, you cannot set the &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Subscriptions/Subscriptions/W_Subscription_and_Amendment_Dates#Billing_Trigger_Dates\&quot; target&#x3D;\&quot;_blank\&quot;&gt;billing trigger dates&lt;/a&gt; for the subscription as the system will automatically set the trigger dates to the end of billing period.   * When setting this field to &#x60;SpecificDate&#x60;, you must also set the &#x60;contractEffectiveDate&#x60; field. 
   * @return effectivePolicy
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The default value for the `effectivePolicy` field is as follows:   * If the rate plan change (from old to new) is an upgrade, the effective policy is `EffectiveImmediately` by default.   * If the rate plan change (from old to new) is a downgrade, the effective policy is `EffectiveEndOfBillingPeriod` by default.   * Otherwise, the effective policy is `SpecificDate` by default.  **Notes**:    * When setting this field to `EffectiveEndOfBillingPeriod`, you cannot set the <a href=\"https://knowledgecenter.zuora.com/Zuora_Billing/Subscriptions/Subscriptions/W_Subscription_and_Amendment_Dates#Billing_Trigger_Dates\" target=\"_blank\">billing trigger dates</a> for the subscription as the system will automatically set the trigger dates to the end of billing period.   * When setting this field to `SpecificDate`, you must also set the `contractEffectiveDate` field. ")

  public EffectivePolicyEnum getEffectivePolicy() {
    return effectivePolicy;
  }


  public void setEffectivePolicy(EffectivePolicyEnum effectivePolicy) {
    
    
    
    this.effectivePolicy = effectivePolicy;
  }


  public PUTSrpChangeType externalCatalogPlanId(String externalCatalogPlanId) {
    
    
    
    
    this.externalCatalogPlanId = externalCatalogPlanId;
    return this;
  }

   /**
   * An external ID of the rate plan to be removed. You can use this field to specify an existing rate plan in your subscription. The value of the &#x60;externalCatalogPlanId&#x60; field must match one of the values that are predefined in the &#x60;externallyManagedPlanIds&#x60; field on a product rate plan. However, if there are multiple rate plans with the same &#x60;productRatePlanId&#x60; value existing in the subscription, you must use the &#x60;ratePlanId&#x60; field to remove the rate plan. The &#x60;externalCatalogPlanId&#x60; field cannot be used to distinguish multiple rate plans in this case.  **Note:** Provide only one of &#x60;externalCatalogPlanId&#x60;, &#x60;ratePlanId&#x60; or &#x60;productRatePlanId&#x60;. If more than one field is provided then the request would fail. 
   * @return externalCatalogPlanId
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "An external ID of the rate plan to be removed. You can use this field to specify an existing rate plan in your subscription. The value of the `externalCatalogPlanId` field must match one of the values that are predefined in the `externallyManagedPlanIds` field on a product rate plan. However, if there are multiple rate plans with the same `productRatePlanId` value existing in the subscription, you must use the `ratePlanId` field to remove the rate plan. The `externalCatalogPlanId` field cannot be used to distinguish multiple rate plans in this case.  **Note:** Provide only one of `externalCatalogPlanId`, `ratePlanId` or `productRatePlanId`. If more than one field is provided then the request would fail. ")

  public String getExternalCatalogPlanId() {
    return externalCatalogPlanId;
  }


  public void setExternalCatalogPlanId(String externalCatalogPlanId) {
    
    
    
    this.externalCatalogPlanId = externalCatalogPlanId;
  }


  public PUTSrpChangeType externalIdSourceSystem(String externalIdSourceSystem) {
    
    
    
    
    this.externalIdSourceSystem = externalIdSourceSystem;
    return this;
  }

   /**
   * The ID of the external source system. You can use this field and &#x60;externalCatalogPlanId&#x60; to specify a product rate plan that is imported from an external system.  **Note:** If both &#x60;externalCatalogPlanId&#x60;, &#x60;externalIdSourceSystem&#x60; and &#x60;productRatePlanId&#x60; are provided. They must point to the same product rate plan. Otherwise, the request would fail. 
   * @return externalIdSourceSystem
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The ID of the external source system. You can use this field and `externalCatalogPlanId` to specify a product rate plan that is imported from an external system.  **Note:** If both `externalCatalogPlanId`, `externalIdSourceSystem` and `productRatePlanId` are provided. They must point to the same product rate plan. Otherwise, the request would fail. ")

  public String getExternalIdSourceSystem() {
    return externalIdSourceSystem;
  }


  public void setExternalIdSourceSystem(String externalIdSourceSystem) {
    
    
    
    this.externalIdSourceSystem = externalIdSourceSystem;
  }


  public PUTSrpChangeType newExternalCatalogPlanId(String newExternalCatalogPlanId) {
    
    
    
    
    this.newExternalCatalogPlanId = newExternalCatalogPlanId;
    return this;
  }

   /**
   * An external ID of the product rate plan to be added. You can use this field to specify a product rate plan that is imported from an external system. The value of the &#x60;externalCatalogPlanId&#x60; field must match one of the values that are predefined in the &#x60;externallyManagedPlanIds&#x60; field on a product rate plan.  **Note:** Provide only one of &#x60;newExternalCatalogPlanId&#x60; or &#x60;newProductRatePlanId&#x60;. If both fields are provided then the request would fail. 
   * @return newExternalCatalogPlanId
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "An external ID of the product rate plan to be added. You can use this field to specify a product rate plan that is imported from an external system. The value of the `externalCatalogPlanId` field must match one of the values that are predefined in the `externallyManagedPlanIds` field on a product rate plan.  **Note:** Provide only one of `newExternalCatalogPlanId` or `newProductRatePlanId`. If both fields are provided then the request would fail. ")

  public String getNewExternalCatalogPlanId() {
    return newExternalCatalogPlanId;
  }


  public void setNewExternalCatalogPlanId(String newExternalCatalogPlanId) {
    
    
    
    this.newExternalCatalogPlanId = newExternalCatalogPlanId;
  }


  public PUTSrpChangeType newExternalIdSourceSystem(String newExternalIdSourceSystem) {
    
    
    
    
    this.newExternalIdSourceSystem = newExternalIdSourceSystem;
    return this;
  }

   /**
   * The ID of the external source system. You can use this field and &#x60;newExternalCatalogPlanId&#x60; to specify a product rate plan that is imported from an external system.  **Note:** If both &#x60;newExternalCatalogPlanId&#x60;, &#x60;newExternalIdSourceSystem&#x60; and &#x60;newProductRatePlanId&#x60; are provided. They must point to the same product rate plan. Otherwise, the request would fail. 
   * @return newExternalIdSourceSystem
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The ID of the external source system. You can use this field and `newExternalCatalogPlanId` to specify a product rate plan that is imported from an external system.  **Note:** If both `newExternalCatalogPlanId`, `newExternalIdSourceSystem` and `newProductRatePlanId` are provided. They must point to the same product rate plan. Otherwise, the request would fail. ")

  public String getNewExternalIdSourceSystem() {
    return newExternalIdSourceSystem;
  }


  public void setNewExternalIdSourceSystem(String newExternalIdSourceSystem) {
    
    
    
    this.newExternalIdSourceSystem = newExternalIdSourceSystem;
  }


  public PUTSrpChangeType newProductRatePlanId(String newProductRatePlanId) {
    
    
    
    
    this.newProductRatePlanId = newProductRatePlanId;
    return this;
  }

   /**
   * ID of a product rate plan for this subscription.
   * @return newProductRatePlanId
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "ID of a product rate plan for this subscription.")

  public String getNewProductRatePlanId() {
    return newProductRatePlanId;
  }


  public void setNewProductRatePlanId(String newProductRatePlanId) {
    
    
    
    this.newProductRatePlanId = newProductRatePlanId;
  }


  public PUTSrpChangeType newProductRatePlanNumber(String newProductRatePlanNumber) {
    
    
    
    
    this.newProductRatePlanNumber = newProductRatePlanNumber;
    return this;
  }

   /**
   * Number of a product rate plan for this subscription.
   * @return newProductRatePlanNumber
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Number of a product rate plan for this subscription.")

  public String getNewProductRatePlanNumber() {
    return newProductRatePlanNumber;
  }


  public void setNewProductRatePlanNumber(String newProductRatePlanNumber) {
    
    
    
    this.newProductRatePlanNumber = newProductRatePlanNumber;
  }


  public PUTSrpChangeType productRatePlanId(String productRatePlanId) {
    
    
    
    
    this.productRatePlanId = productRatePlanId;
    return this;
  }

   /**
   * ID of the product rate plan that the removed rate plan is based on. 
   * @return productRatePlanId
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "ID of the product rate plan that the removed rate plan is based on. ")

  public String getProductRatePlanId() {
    return productRatePlanId;
  }


  public void setProductRatePlanId(String productRatePlanId) {
    
    
    
    this.productRatePlanId = productRatePlanId;
  }


  public PUTSrpChangeType productRatePlanNumber(String productRatePlanNumber) {
    
    
    
    
    this.productRatePlanNumber = productRatePlanNumber;
    return this;
  }

   /**
   * Number of a product rate plan for this subscription.    
   * @return productRatePlanNumber
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Number of a product rate plan for this subscription.    ")

  public String getProductRatePlanNumber() {
    return productRatePlanNumber;
  }


  public void setProductRatePlanNumber(String productRatePlanNumber) {
    
    
    
    this.productRatePlanNumber = productRatePlanNumber;
  }


  public PUTSrpChangeType ratePlanId(String ratePlanId) {
    
    
    
    
    this.ratePlanId = ratePlanId;
    return this;
  }

   /**
   * ID of a rate plan to remove. Note that the removal of a rate plan through the Change Plan amendment supports the function of &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Subscriptions/Subscriptions/Subscribe_and_Amend/E_Amendments/EB_Remove_rate_plan_on_subscription_before_future-dated_removals\&quot; target&#x3D;\&quot;_blank\&quot;&gt;removal before future-dated removals&lt;/a&gt;, as in a Remove Product amendment. 
   * @return ratePlanId
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "ID of a rate plan to remove. Note that the removal of a rate plan through the Change Plan amendment supports the function of <a href=\"https://knowledgecenter.zuora.com/Zuora_Billing/Subscriptions/Subscriptions/Subscribe_and_Amend/E_Amendments/EB_Remove_rate_plan_on_subscription_before_future-dated_removals\" target=\"_blank\">removal before future-dated removals</a>, as in a Remove Product amendment. ")

  public String getRatePlanId() {
    return ratePlanId;
  }


  public void setRatePlanId(String ratePlanId) {
    
    
    
    this.ratePlanId = ratePlanId;
  }


  public PUTSrpChangeType resetBcd(Boolean resetBcd) {
    
    
    
    
    this.resetBcd = resetBcd;
    return this;
  }

   /**
   * If resetBcd is true then reset the Account BCD to the effective date; if it is false keep the original BCD. 
   * @return resetBcd
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "false", value = "If resetBcd is true then reset the Account BCD to the effective date; if it is false keep the original BCD. ")

  public Boolean getResetBcd() {
    return resetBcd;
  }


  public void setResetBcd(Boolean resetBcd) {
    
    
    
    this.resetBcd = resetBcd;
  }


  public PUTSrpChangeType serviceActivationDate(LocalDate serviceActivationDate) {
    
    
    
    
    this.serviceActivationDate = serviceActivationDate;
    return this;
  }

   /**
   * The date when the change in the subscription is activated in yyyy-mm-dd format. You must specify a Service Activation date if the Customer Acceptance date is set. If the Customer Acceptance date is not set, the value of the &#x60;serviceActivationDate&#x60; field defaults to be the Contract Effective Date. The billing trigger dates must follow this rule: contractEffectiveDate &lt;&#x3D; serviceActivationDate &lt;&#x3D; contractAcceptanceDate
   * @return serviceActivationDate
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The date when the change in the subscription is activated in yyyy-mm-dd format. You must specify a Service Activation date if the Customer Acceptance date is set. If the Customer Acceptance date is not set, the value of the `serviceActivationDate` field defaults to be the Contract Effective Date. The billing trigger dates must follow this rule: contractEffectiveDate <= serviceActivationDate <= contractAcceptanceDate")

  public LocalDate getServiceActivationDate() {
    return serviceActivationDate;
  }


  public void setServiceActivationDate(LocalDate serviceActivationDate) {
    
    
    
    this.serviceActivationDate = serviceActivationDate;
  }


  public PUTSrpChangeType subType(SubTypeEnum subType) {
    
    
    
    
    this.subType = subType;
    return this;
  }

   /**
   * Use this field to choose the sub type for your change plan amendment.   However, if you do not set this field, the field will be automatically generated by the system according to the following rules:  When the old and new rate plans are within the same Grading catalog group: * If the grade of new plan is greater than that of the old plan, this is an \&quot;Upgrade\&quot;. * If the grade of new plan is less than that of the old plan, this is a \&quot;Downgrade\&quot;. * If the grade of new plan equals that of the old plan, this is a \&quot;Crossgrade\&quot;.  When the old and new rate plans are not in the same Grading catalog group, or either has no group, this is \&quot;PlanChanged\&quot;. 
   * @return subType
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Use this field to choose the sub type for your change plan amendment.   However, if you do not set this field, the field will be automatically generated by the system according to the following rules:  When the old and new rate plans are within the same Grading catalog group: * If the grade of new plan is greater than that of the old plan, this is an \"Upgrade\". * If the grade of new plan is less than that of the old plan, this is a \"Downgrade\". * If the grade of new plan equals that of the old plan, this is a \"Crossgrade\".  When the old and new rate plans are not in the same Grading catalog group, or either has no group, this is \"PlanChanged\". ")

  public SubTypeEnum getSubType() {
    return subType;
  }


  public void setSubType(SubTypeEnum subType) {
    
    
    
    this.subType = subType;
  }


  public PUTSrpChangeType subscriptionRatePlanNumber(String subscriptionRatePlanNumber) {
    
    
    
    
    this.subscriptionRatePlanNumber = subscriptionRatePlanNumber;
    return this;
  }

   /**
   * Number of a rate plan for this subscription.  
   * @return subscriptionRatePlanNumber
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Number of a rate plan for this subscription.  ")

  public String getSubscriptionRatePlanNumber() {
    return subscriptionRatePlanNumber;
  }


  public void setSubscriptionRatePlanNumber(String subscriptionRatePlanNumber) {
    
    
    
    this.subscriptionRatePlanNumber = subscriptionRatePlanNumber;
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
   * @return the PUTSrpChangeType instance itself
   */
  public PUTSrpChangeType putAdditionalProperty(String key, Object value) {
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
    PUTSrpChangeType puTSrpChangeType = (PUTSrpChangeType) o;
    return Objects.equals(this.bookingDate, puTSrpChangeType.bookingDate) &&
        Objects.equals(this.chargeOverrides, puTSrpChangeType.chargeOverrides) &&
        Objects.equals(this.contractEffectiveDate, puTSrpChangeType.contractEffectiveDate) &&
        Objects.equals(this.customerAcceptanceDate, puTSrpChangeType.customerAcceptanceDate) &&
        Objects.equals(this.effectivePolicy, puTSrpChangeType.effectivePolicy) &&
        Objects.equals(this.externalCatalogPlanId, puTSrpChangeType.externalCatalogPlanId) &&
        Objects.equals(this.externalIdSourceSystem, puTSrpChangeType.externalIdSourceSystem) &&
        Objects.equals(this.newExternalCatalogPlanId, puTSrpChangeType.newExternalCatalogPlanId) &&
        Objects.equals(this.newExternalIdSourceSystem, puTSrpChangeType.newExternalIdSourceSystem) &&
        Objects.equals(this.newProductRatePlanId, puTSrpChangeType.newProductRatePlanId) &&
        Objects.equals(this.newProductRatePlanNumber, puTSrpChangeType.newProductRatePlanNumber) &&
        Objects.equals(this.productRatePlanId, puTSrpChangeType.productRatePlanId) &&
        Objects.equals(this.productRatePlanNumber, puTSrpChangeType.productRatePlanNumber) &&
        Objects.equals(this.ratePlanId, puTSrpChangeType.ratePlanId) &&
        Objects.equals(this.resetBcd, puTSrpChangeType.resetBcd) &&
        Objects.equals(this.serviceActivationDate, puTSrpChangeType.serviceActivationDate) &&
        Objects.equals(this.subType, puTSrpChangeType.subType) &&
        Objects.equals(this.subscriptionRatePlanNumber, puTSrpChangeType.subscriptionRatePlanNumber)&&
        Objects.equals(this.additionalProperties, puTSrpChangeType.additionalProperties);
  }

  @Override
  public int hashCode() {
    return Objects.hash(bookingDate, chargeOverrides, contractEffectiveDate, customerAcceptanceDate, effectivePolicy, externalCatalogPlanId, externalIdSourceSystem, newExternalCatalogPlanId, newExternalIdSourceSystem, newProductRatePlanId, newProductRatePlanNumber, productRatePlanId, productRatePlanNumber, ratePlanId, resetBcd, serviceActivationDate, subType, subscriptionRatePlanNumber, additionalProperties);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PUTSrpChangeType {\n");
    sb.append("    bookingDate: ").append(toIndentedString(bookingDate)).append("\n");
    sb.append("    chargeOverrides: ").append(toIndentedString(chargeOverrides)).append("\n");
    sb.append("    contractEffectiveDate: ").append(toIndentedString(contractEffectiveDate)).append("\n");
    sb.append("    customerAcceptanceDate: ").append(toIndentedString(customerAcceptanceDate)).append("\n");
    sb.append("    effectivePolicy: ").append(toIndentedString(effectivePolicy)).append("\n");
    sb.append("    externalCatalogPlanId: ").append(toIndentedString(externalCatalogPlanId)).append("\n");
    sb.append("    externalIdSourceSystem: ").append(toIndentedString(externalIdSourceSystem)).append("\n");
    sb.append("    newExternalCatalogPlanId: ").append(toIndentedString(newExternalCatalogPlanId)).append("\n");
    sb.append("    newExternalIdSourceSystem: ").append(toIndentedString(newExternalIdSourceSystem)).append("\n");
    sb.append("    newProductRatePlanId: ").append(toIndentedString(newProductRatePlanId)).append("\n");
    sb.append("    newProductRatePlanNumber: ").append(toIndentedString(newProductRatePlanNumber)).append("\n");
    sb.append("    productRatePlanId: ").append(toIndentedString(productRatePlanId)).append("\n");
    sb.append("    productRatePlanNumber: ").append(toIndentedString(productRatePlanNumber)).append("\n");
    sb.append("    ratePlanId: ").append(toIndentedString(ratePlanId)).append("\n");
    sb.append("    resetBcd: ").append(toIndentedString(resetBcd)).append("\n");
    sb.append("    serviceActivationDate: ").append(toIndentedString(serviceActivationDate)).append("\n");
    sb.append("    subType: ").append(toIndentedString(subType)).append("\n");
    sb.append("    subscriptionRatePlanNumber: ").append(toIndentedString(subscriptionRatePlanNumber)).append("\n");
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
    openapiFields.add("bookingDate");
    openapiFields.add("chargeOverrides");
    openapiFields.add("contractEffectiveDate");
    openapiFields.add("customerAcceptanceDate");
    openapiFields.add("effectivePolicy");
    openapiFields.add("externalCatalogPlanId");
    openapiFields.add("externalIdSourceSystem");
    openapiFields.add("newExternalCatalogPlanId");
    openapiFields.add("newExternalIdSourceSystem");
    openapiFields.add("newProductRatePlanId");
    openapiFields.add("newProductRatePlanNumber");
    openapiFields.add("productRatePlanId");
    openapiFields.add("productRatePlanNumber");
    openapiFields.add("ratePlanId");
    openapiFields.add("resetBcd");
    openapiFields.add("serviceActivationDate");
    openapiFields.add("subType");
    openapiFields.add("subscriptionRatePlanNumber");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
  }

 /**
  * Validates the JSON Object and throws an exception if issues found
  *
  * @param jsonObj JSON Object
  * @throws IOException if the JSON Object is invalid with respect to PUTSrpChangeType
  */
  public static void validateJsonObject(JsonObject jsonObj) throws IOException {
      if (jsonObj == null) {
        if (!PUTSrpChangeType.openapiRequiredFields.isEmpty()) { // has required fields but JSON object is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in PUTSrpChangeType is not found in the empty JSON string", PUTSrpChangeType.openapiRequiredFields.toString()));
        }
      }
      if (jsonObj.get("chargeOverrides") != null && !jsonObj.get("chargeOverrides").isJsonNull()) {
        JsonArray jsonArraychargeOverrides = jsonObj.getAsJsonArray("chargeOverrides");
        if (jsonArraychargeOverrides != null) {
          // ensure the json data is an array
          if (!jsonObj.get("chargeOverrides").isJsonArray()) {
            throw new IllegalArgumentException(String.format("Expected the field `chargeOverrides` to be an array in the JSON string but got `%s`", jsonObj.get("chargeOverrides").toString()));
          }

          // validate the optional field `chargeOverrides` (array)
          for (int i = 0; i < jsonArraychargeOverrides.size(); i++) {
            PUTScAddType.validateJsonObject(jsonArraychargeOverrides.get(i).getAsJsonObject());
          };
        }
      }
      if ((jsonObj.get("effectivePolicy") != null && !jsonObj.get("effectivePolicy").isJsonNull()) && !jsonObj.get("effectivePolicy").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `effectivePolicy` to be a primitive type in the JSON string but got `%s`", jsonObj.get("effectivePolicy").toString()));
      }
      if ((jsonObj.get("externalCatalogPlanId") != null && !jsonObj.get("externalCatalogPlanId").isJsonNull()) && !jsonObj.get("externalCatalogPlanId").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `externalCatalogPlanId` to be a primitive type in the JSON string but got `%s`", jsonObj.get("externalCatalogPlanId").toString()));
      }
      if ((jsonObj.get("externalIdSourceSystem") != null && !jsonObj.get("externalIdSourceSystem").isJsonNull()) && !jsonObj.get("externalIdSourceSystem").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `externalIdSourceSystem` to be a primitive type in the JSON string but got `%s`", jsonObj.get("externalIdSourceSystem").toString()));
      }
      if ((jsonObj.get("newExternalCatalogPlanId") != null && !jsonObj.get("newExternalCatalogPlanId").isJsonNull()) && !jsonObj.get("newExternalCatalogPlanId").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `newExternalCatalogPlanId` to be a primitive type in the JSON string but got `%s`", jsonObj.get("newExternalCatalogPlanId").toString()));
      }
      if ((jsonObj.get("newExternalIdSourceSystem") != null && !jsonObj.get("newExternalIdSourceSystem").isJsonNull()) && !jsonObj.get("newExternalIdSourceSystem").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `newExternalIdSourceSystem` to be a primitive type in the JSON string but got `%s`", jsonObj.get("newExternalIdSourceSystem").toString()));
      }
      if ((jsonObj.get("newProductRatePlanId") != null && !jsonObj.get("newProductRatePlanId").isJsonNull()) && !jsonObj.get("newProductRatePlanId").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `newProductRatePlanId` to be a primitive type in the JSON string but got `%s`", jsonObj.get("newProductRatePlanId").toString()));
      }
      if ((jsonObj.get("newProductRatePlanNumber") != null && !jsonObj.get("newProductRatePlanNumber").isJsonNull()) && !jsonObj.get("newProductRatePlanNumber").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `newProductRatePlanNumber` to be a primitive type in the JSON string but got `%s`", jsonObj.get("newProductRatePlanNumber").toString()));
      }
      if ((jsonObj.get("productRatePlanId") != null && !jsonObj.get("productRatePlanId").isJsonNull()) && !jsonObj.get("productRatePlanId").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `productRatePlanId` to be a primitive type in the JSON string but got `%s`", jsonObj.get("productRatePlanId").toString()));
      }
      if ((jsonObj.get("productRatePlanNumber") != null && !jsonObj.get("productRatePlanNumber").isJsonNull()) && !jsonObj.get("productRatePlanNumber").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `productRatePlanNumber` to be a primitive type in the JSON string but got `%s`", jsonObj.get("productRatePlanNumber").toString()));
      }
      if ((jsonObj.get("ratePlanId") != null && !jsonObj.get("ratePlanId").isJsonNull()) && !jsonObj.get("ratePlanId").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `ratePlanId` to be a primitive type in the JSON string but got `%s`", jsonObj.get("ratePlanId").toString()));
      }
      if ((jsonObj.get("subType") != null && !jsonObj.get("subType").isJsonNull()) && !jsonObj.get("subType").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `subType` to be a primitive type in the JSON string but got `%s`", jsonObj.get("subType").toString()));
      }
      if ((jsonObj.get("subscriptionRatePlanNumber") != null && !jsonObj.get("subscriptionRatePlanNumber").isJsonNull()) && !jsonObj.get("subscriptionRatePlanNumber").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `subscriptionRatePlanNumber` to be a primitive type in the JSON string but got `%s`", jsonObj.get("subscriptionRatePlanNumber").toString()));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!PUTSrpChangeType.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'PUTSrpChangeType' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<PUTSrpChangeType> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(PUTSrpChangeType.class));

       return (TypeAdapter<T>) new TypeAdapter<PUTSrpChangeType>() {
           @Override
           public void write(JsonWriter out, PUTSrpChangeType value) throws IOException {
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
           public PUTSrpChangeType read(JsonReader in) throws IOException {
             JsonObject jsonObj = elementAdapter.read(in).getAsJsonObject();
             validateJsonObject(jsonObj);
             // store additional fields in the deserialized instance
             PUTSrpChangeType instance = thisAdapter.fromJsonTree(jsonObj);
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
  * Create an instance of PUTSrpChangeType given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of PUTSrpChangeType
  * @throws IOException if the JSON string is invalid with respect to PUTSrpChangeType
  */
  public static PUTSrpChangeType fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, PUTSrpChangeType.class);
  }

 /**
  * Convert an instance of PUTSrpChangeType to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

