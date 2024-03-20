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
import com.konfigthis.client.model.PUTSrpAddType;
import com.konfigthis.client.model.PUTSrpChangeType;
import com.konfigthis.client.model.PUTSrpRemoveType;
import com.konfigthis.client.model.PUTSrpUpdateType;
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
 * PUTSubscriptionType
 */@javax.annotation.Generated(value = "Generated by https://konfigthis.com")
public class PUTSubscriptionType {
  public static final String SERIALIZED_NAME_ADD = "add";
  @SerializedName(SERIALIZED_NAME_ADD)
  private List<PUTSrpAddType> add = null;

  public static final String SERIALIZED_NAME_APPLICATION_ORDER = "applicationOrder";
  @SerializedName(SERIALIZED_NAME_APPLICATION_ORDER)
  private List<String> applicationOrder = null;

  public static final String SERIALIZED_NAME_APPLY_CREDIT = "applyCredit";
  @SerializedName(SERIALIZED_NAME_APPLY_CREDIT)
  private Boolean applyCredit;

  public static final String SERIALIZED_NAME_APPLY_CREDIT_BALANCE = "applyCreditBalance";
  @SerializedName(SERIALIZED_NAME_APPLY_CREDIT_BALANCE)
  private Boolean applyCreditBalance;

  public static final String SERIALIZED_NAME_AUTO_RENEW = "autoRenew";
  @SerializedName(SERIALIZED_NAME_AUTO_RENEW)
  private Boolean autoRenew;

  public static final String SERIALIZED_NAME_BOOKING_DATE = "bookingDate";
  @SerializedName(SERIALIZED_NAME_BOOKING_DATE)
  private LocalDate bookingDate;

  public static final String SERIALIZED_NAME_CHANGE = "change";
  @SerializedName(SERIALIZED_NAME_CHANGE)
  private List<PUTSrpChangeType> change = null;

  public static final String SERIALIZED_NAME_COLLECT = "collect";
  @SerializedName(SERIALIZED_NAME_COLLECT)
  private Boolean collect = false;

  public static final String SERIALIZED_NAME_CREDIT_MEMO_REASON_CODE = "creditMemoReasonCode";
  @SerializedName(SERIALIZED_NAME_CREDIT_MEMO_REASON_CODE)
  private String creditMemoReasonCode;

  public static final String SERIALIZED_NAME_CURRENT_TERM = "currentTerm";
  @SerializedName(SERIALIZED_NAME_CURRENT_TERM)
  private Long currentTerm;

  public static final String SERIALIZED_NAME_CURRENT_TERM_PERIOD_TYPE = "currentTermPeriodType";
  @SerializedName(SERIALIZED_NAME_CURRENT_TERM_PERIOD_TYPE)
  private String currentTermPeriodType;

  public static final String SERIALIZED_NAME_DOCUMENT_DATE = "documentDate";
  @SerializedName(SERIALIZED_NAME_DOCUMENT_DATE)
  private LocalDate documentDate;

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

  public static final String SERIALIZED_NAME_INCLUDE_EXISTING_DRAFT_DOC_ITEMS = "includeExistingDraftDocItems";
  @SerializedName(SERIALIZED_NAME_INCLUDE_EXISTING_DRAFT_DOC_ITEMS)
  private Boolean includeExistingDraftDocItems;

  public static final String SERIALIZED_NAME_INCLUDE_EXISTING_DRAFT_INVOICE_ITEMS = "includeExistingDraftInvoiceItems";
  @SerializedName(SERIALIZED_NAME_INCLUDE_EXISTING_DRAFT_INVOICE_ITEMS)
  private Boolean includeExistingDraftInvoiceItems;

  public static final String SERIALIZED_NAME_INVOICE = "invoice";
  @SerializedName(SERIALIZED_NAME_INVOICE)
  private Boolean invoice;

  public static final String SERIALIZED_NAME_INVOICE_COLLECT = "invoiceCollect";
  @SerializedName(SERIALIZED_NAME_INVOICE_COLLECT)
  private Boolean invoiceCollect = false;

  public static final String SERIALIZED_NAME_INVOICE_SEPARATELY = "invoiceSeparately";
  @SerializedName(SERIALIZED_NAME_INVOICE_SEPARATELY)
  private Boolean invoiceSeparately;

  public static final String SERIALIZED_NAME_INVOICE_TARGET_DATE = "invoiceTargetDate";
  @SerializedName(SERIALIZED_NAME_INVOICE_TARGET_DATE)
  private LocalDate invoiceTargetDate;

  public static final String SERIALIZED_NAME_NOTES = "notes";
  @SerializedName(SERIALIZED_NAME_NOTES)
  private String notes;

  public static final String SERIALIZED_NAME_PREVIEW = "preview";
  @SerializedName(SERIALIZED_NAME_PREVIEW)
  private Boolean preview;

  public static final String SERIALIZED_NAME_PREVIEW_TYPE = "previewType";
  @SerializedName(SERIALIZED_NAME_PREVIEW_TYPE)
  private String previewType;

  public static final String SERIALIZED_NAME_REMOVE = "remove";
  @SerializedName(SERIALIZED_NAME_REMOVE)
  private List<PUTSrpRemoveType> remove = null;

  public static final String SERIALIZED_NAME_RENEWAL_SETTING = "renewalSetting";
  @SerializedName(SERIALIZED_NAME_RENEWAL_SETTING)
  private String renewalSetting;

  public static final String SERIALIZED_NAME_RENEWAL_TERM = "renewalTerm";
  @SerializedName(SERIALIZED_NAME_RENEWAL_TERM)
  private Long renewalTerm;

  public static final String SERIALIZED_NAME_RENEWAL_TERM_PERIOD_TYPE = "renewalTermPeriodType";
  @SerializedName(SERIALIZED_NAME_RENEWAL_TERM_PERIOD_TYPE)
  private String renewalTermPeriodType;

  /**
   * Creates an invoice for a subscription. If you have the Invoice Settlement feature enabled, a credit memo might also be created based on the [invoice and credit memo generation rule](https://knowledgecenter.zuora.com/CB_Billing/Invoice_Settlement/Credit_and_Debit_Memos/Rules_for_Generating_Invoices_and_Credit_Memos).     The billing documents generated in this operation is only for this subscription, not for the entire customer account.   Possible values:  - &#x60;true&#x60;: An invoice is created. If you have the Invoice Settlement feature enabled, a credit memo might also be created.   - &#x60;false&#x60;: No invoice is created.   **Note:** This field is in Zuora REST API version control. Supported minor versions are &#x60;211.0&#x60; or later [available versions](https://developer.zuora.com/api-references/api/overview/#section/API-Versions/Minor-Version). To use this field in the method, you must set the &#x60;zuora-version&#x60; parameter to the minor version number in the request header. 
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
  private RunBillingEnum runBilling = false;

  public static final String SERIALIZED_NAME_TARGET_DATE = "targetDate";
  @SerializedName(SERIALIZED_NAME_TARGET_DATE)
  private LocalDate targetDate;

  public static final String SERIALIZED_NAME_TERM_START_DATE = "termStartDate";
  @SerializedName(SERIALIZED_NAME_TERM_START_DATE)
  private LocalDate termStartDate;

  public static final String SERIALIZED_NAME_TERM_TYPE = "termType";
  @SerializedName(SERIALIZED_NAME_TERM_TYPE)
  private String termType;

  public static final String SERIALIZED_NAME_UPDATE = "update";
  @SerializedName(SERIALIZED_NAME_UPDATE)
  private List<PUTSrpUpdateType> update = null;

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

  public PUTSubscriptionType() {
  }

  public PUTSubscriptionType add(List<PUTSrpAddType> add) {
    
    
    
    
    this.add = add;
    return this;
  }

  public PUTSubscriptionType addAddItem(PUTSrpAddType addItem) {
    if (this.add == null) {
      this.add = new ArrayList<>();
    }
    this.add.add(addItem);
    return this;
  }

   /**
   * Container for adding one or more rate plans. 
   * @return add
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Container for adding one or more rate plans. ")

  public List<PUTSrpAddType> getAdd() {
    return add;
  }


  public void setAdd(List<PUTSrpAddType> add) {
    
    
    
    this.add = add;
  }


  public PUTSubscriptionType applicationOrder(List<String> applicationOrder) {
    
    
    
    
    this.applicationOrder = applicationOrder;
    return this;
  }

  public PUTSubscriptionType addApplicationOrderItem(String applicationOrderItem) {
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


  public PUTSubscriptionType applyCredit(Boolean applyCredit) {
    
    
    
    
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


  public PUTSubscriptionType applyCreditBalance(Boolean applyCreditBalance) {
    
    
    
    
    this.applyCreditBalance = applyCreditBalance;
    return this;
  }

   /**
   * Whether to automatically apply a credit balance to an invoice.  If the value is &#x60;true&#x60;, the credit balance is applied to the invoice. If the value is &#x60;false&#x60;, no action is taken.   To view the credit balance adjustment, retrieve the details of the invoice using the Get Invoices method.  Prerequisite: &#x60;invoice&#x60; must be &#x60;true&#x60;.   **Note:**    - If you are using the field &#x60;invoiceCollect&#x60; rather than the field &#x60;invoice&#x60;, the &#x60;invoiceCollect&#x60; value must be &#x60;true&#x60;.   - This field is deprecated if you have the Invoice Settlement feature enabled. 
   * @return applyCreditBalance
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Whether to automatically apply a credit balance to an invoice.  If the value is `true`, the credit balance is applied to the invoice. If the value is `false`, no action is taken.   To view the credit balance adjustment, retrieve the details of the invoice using the Get Invoices method.  Prerequisite: `invoice` must be `true`.   **Note:**    - If you are using the field `invoiceCollect` rather than the field `invoice`, the `invoiceCollect` value must be `true`.   - This field is deprecated if you have the Invoice Settlement feature enabled. ")

  public Boolean getApplyCreditBalance() {
    return applyCreditBalance;
  }


  public void setApplyCreditBalance(Boolean applyCreditBalance) {
    
    
    
    this.applyCreditBalance = applyCreditBalance;
  }


  public PUTSubscriptionType autoRenew(Boolean autoRenew) {
    
    
    
    
    this.autoRenew = autoRenew;
    return this;
  }

   /**
   * If &#x60;true&#x60;, this subscription automatically renews at the end of the subscription term. Default is &#x60;false&#x60;. 
   * @return autoRenew
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "If `true`, this subscription automatically renews at the end of the subscription term. Default is `false`. ")

  public Boolean getAutoRenew() {
    return autoRenew;
  }


  public void setAutoRenew(Boolean autoRenew) {
    
    
    
    this.autoRenew = autoRenew;
  }


  public PUTSubscriptionType bookingDate(LocalDate bookingDate) {
    
    
    
    
    this.bookingDate = bookingDate;
    return this;
  }

   /**
   * The booking date that you want to set for the contract when you change the &#x60;termType&#x60; field of the subscription and as a result get a new version of subscription created. The booking date of an amendment is the equivalent of the order date of an order. This field must be in the &#x60;yyyy-mm-dd&#x60; format. The default value is the current date when you make the API call.  
   * @return bookingDate
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The booking date that you want to set for the contract when you change the `termType` field of the subscription and as a result get a new version of subscription created. The booking date of an amendment is the equivalent of the order date of an order. This field must be in the `yyyy-mm-dd` format. The default value is the current date when you make the API call.  ")

  public LocalDate getBookingDate() {
    return bookingDate;
  }


  public void setBookingDate(LocalDate bookingDate) {
    
    
    
    this.bookingDate = bookingDate;
  }


  public PUTSubscriptionType change(List<PUTSrpChangeType> change) {
    
    
    
    
    this.change = change;
    return this;
  }

  public PUTSubscriptionType addChangeItem(PUTSrpChangeType changeItem) {
    if (this.change == null) {
      this.change = new ArrayList<>();
    }
    this.change.add(changeItem);
    return this;
  }

   /**
   * Use this field to change one or more rate plans - to replace the existing rate plans in a subscription with other rate plans.  **Note**: Changing rate plans is currently not supported for Billing - Revenue Integration. When Billing - Revenue Integration is enabled, changing rate plans will no longer be applicable in Zuora Billing. 
   * @return change
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Use this field to change one or more rate plans - to replace the existing rate plans in a subscription with other rate plans.  **Note**: Changing rate plans is currently not supported for Billing - Revenue Integration. When Billing - Revenue Integration is enabled, changing rate plans will no longer be applicable in Zuora Billing. ")

  public List<PUTSrpChangeType> getChange() {
    return change;
  }


  public void setChange(List<PUTSrpChangeType> change) {
    
    
    
    this.change = change;
  }


  public PUTSubscriptionType collect(Boolean collect) {
    
    
    
    
    this.collect = collect;
    return this;
  }

   /**
   * Collects an automatic payment for a subscription. The collection generated in this operation is only for this subscription, not for the entire customer account.  If the value is &#x60;true&#x60;, the automatic payment is collected. If the value is &#x60;false&#x60;, no action is taken.  Prerequisite: The &#x60;invoice&#x60; or &#x60;runBilling&#x60; field must be &#x60;true&#x60;.   **Note**: This field is only available if you set the &#x60;zuora-version&#x60; request header to &#x60;196.0&#x60; or later [available versions](https://developer.zuora.com/api-references/api/overview/#section/API-Versions/Minor-Version). 
   * @return collect
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "false", value = "Collects an automatic payment for a subscription. The collection generated in this operation is only for this subscription, not for the entire customer account.  If the value is `true`, the automatic payment is collected. If the value is `false`, no action is taken.  Prerequisite: The `invoice` or `runBilling` field must be `true`.   **Note**: This field is only available if you set the `zuora-version` request header to `196.0` or later [available versions](https://developer.zuora.com/api-references/api/overview/#section/API-Versions/Minor-Version). ")

  public Boolean getCollect() {
    return collect;
  }


  public void setCollect(Boolean collect) {
    
    
    
    this.collect = collect;
  }


  public PUTSubscriptionType creditMemoReasonCode(String creditMemoReasonCode) {
    
    
    
    
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


  public PUTSubscriptionType currentTerm(Long currentTerm) {
    
    
    
    
    this.currentTerm = currentTerm;
    return this;
  }

   /**
   * The length of the period for the current subscription term. If &#x60;termType&#x60; is &#x60;TERMED&#x60;, this field is required and must be greater than &#x60;0&#x60;. If &#x60;termType&#x60; is &#x60;EVERGREEN&#x60;, this value is ignored. 
   * @return currentTerm
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The length of the period for the current subscription term. If `termType` is `TERMED`, this field is required and must be greater than `0`. If `termType` is `EVERGREEN`, this value is ignored. ")

  public Long getCurrentTerm() {
    return currentTerm;
  }


  public void setCurrentTerm(Long currentTerm) {
    
    
    
    this.currentTerm = currentTerm;
  }


  public PUTSubscriptionType currentTermPeriodType(String currentTermPeriodType) {
    
    
    
    
    this.currentTermPeriodType = currentTermPeriodType;
    return this;
  }

   /**
   * The period type for the current subscription term.  This field is used with the &#x60;CurrentTerm&#x60; field to specify the current subscription term.  Values are:  * &#x60;Month&#x60; (default) * &#x60;Year&#x60; * &#x60;Day&#x60; * &#x60;Week&#x60; 
   * @return currentTermPeriodType
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The period type for the current subscription term.  This field is used with the `CurrentTerm` field to specify the current subscription term.  Values are:  * `Month` (default) * `Year` * `Day` * `Week` ")

  public String getCurrentTermPeriodType() {
    return currentTermPeriodType;
  }


  public void setCurrentTermPeriodType(String currentTermPeriodType) {
    
    
    
    this.currentTermPeriodType = currentTermPeriodType;
  }


  public PUTSubscriptionType documentDate(LocalDate documentDate) {
    
    
    
    
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


  public PUTSubscriptionType externallyManagedBy(ExternallyManagedByEnum externallyManagedBy) {
    
    
    
    
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


  public PUTSubscriptionType includeExistingDraftDocItems(Boolean includeExistingDraftDocItems) {
    
    
    
    
    this.includeExistingDraftDocItems = includeExistingDraftDocItems;
    return this;
  }

   /**
   * Specifies whether to include draft invoice items in subscription previews. Values are:  * &#x60;true&#x60; (default). Includes draft invoice items in the preview result. * &#x60;false&#x60;. Excludes draft invoice items in the preview result.  **Note:** This field is in Zuora REST API version control. Supported minor versions are 207.0 or later [available versions](https://developer.zuora.com/api-references/api/overview/#section/API-Versions/Minor-Version). To use this field in the method, you must set the **zuora-version** parameter to the minor version number in the request header. 
   * @return includeExistingDraftDocItems
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Specifies whether to include draft invoice items in subscription previews. Values are:  * `true` (default). Includes draft invoice items in the preview result. * `false`. Excludes draft invoice items in the preview result.  **Note:** This field is in Zuora REST API version control. Supported minor versions are 207.0 or later [available versions](https://developer.zuora.com/api-references/api/overview/#section/API-Versions/Minor-Version). To use this field in the method, you must set the **zuora-version** parameter to the minor version number in the request header. ")

  public Boolean getIncludeExistingDraftDocItems() {
    return includeExistingDraftDocItems;
  }


  public void setIncludeExistingDraftDocItems(Boolean includeExistingDraftDocItems) {
    
    
    
    this.includeExistingDraftDocItems = includeExistingDraftDocItems;
  }


  public PUTSubscriptionType includeExistingDraftInvoiceItems(Boolean includeExistingDraftInvoiceItems) {
    
    
    
    
    this.includeExistingDraftInvoiceItems = includeExistingDraftInvoiceItems;
    return this;
  }

   /**
   * Specifies whether to include draft invoice items in subscription previews. Values are:  * &#x60;true&#x60; (default). Includes draft invoice items in the preview result. * &#x60;false&#x60;. Excludes draft invoice items in the preview result.  **Note:** This field is in Zuora REST API version control. Supported minor versions are 186.0, 187.0, 188.0, 189.0, 196.0, and 206.0. . 
   * @return includeExistingDraftInvoiceItems
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Specifies whether to include draft invoice items in subscription previews. Values are:  * `true` (default). Includes draft invoice items in the preview result. * `false`. Excludes draft invoice items in the preview result.  **Note:** This field is in Zuora REST API version control. Supported minor versions are 186.0, 187.0, 188.0, 189.0, 196.0, and 206.0. . ")

  public Boolean getIncludeExistingDraftInvoiceItems() {
    return includeExistingDraftInvoiceItems;
  }


  public void setIncludeExistingDraftInvoiceItems(Boolean includeExistingDraftInvoiceItems) {
    
    
    
    this.includeExistingDraftInvoiceItems = includeExistingDraftInvoiceItems;
  }


  public PUTSubscriptionType invoice(Boolean invoice) {
    
    
    
    
    this.invoice = invoice;
    return this;
  }

   /**
   * **Note:** This field has been replaced by the &#x60;runBilling&#x60; field. The &#x60;invoice&#x60; field is only available for backward compatibility.   Creates an invoice for a subscription. The invoice generated in this operation is only for this subscription, not for the entire customer account.   If the value is &#x60;true&#x60;, an invoice is created. If the value is &#x60;false&#x60;, no action is taken. The default value is &#x60;false&#x60;.    This field is in Zuora REST API version control. Supported minor versions are &#x60;196.0&#x60; and &#x60;207.0&#x60;. To use this field in the method, you must set the zuora-version parameter to the minor version number in the request header. 
   * @return invoice
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "**Note:** This field has been replaced by the `runBilling` field. The `invoice` field is only available for backward compatibility.   Creates an invoice for a subscription. The invoice generated in this operation is only for this subscription, not for the entire customer account.   If the value is `true`, an invoice is created. If the value is `false`, no action is taken. The default value is `false`.    This field is in Zuora REST API version control. Supported minor versions are `196.0` and `207.0`. To use this field in the method, you must set the zuora-version parameter to the minor version number in the request header. ")

  public Boolean getInvoice() {
    return invoice;
  }


  public void setInvoice(Boolean invoice) {
    
    
    
    this.invoice = invoice;
  }


  public PUTSubscriptionType invoiceCollect(Boolean invoiceCollect) {
    
    
    
    
    this.invoiceCollect = invoiceCollect;
    return this;
  }

   /**
   * **Note:** This field has been replaced by the &#x60;invoice&#x60; field and the &#x60;collect&#x60; field. &#x60;invoiceCollect&#x60; is available only for backward compatibility.   If &#x60;true&#x60;, an invoice is generated and payment collected automatically during the subscription process. If &#x60;false&#x60;, no invoicing or payment takes place.  The invoice generated in this operation is only for this subscription, not for the entire customer account.  **Note**: This field is only available if you set the &#x60;zuora-version&#x60; request header to &#x60;186.0&#x60;, &#x60;187.0&#x60;, &#x60;188.0&#x60;, or &#x60;189.0&#x60;. 
   * @return invoiceCollect
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "false", value = "**Note:** This field has been replaced by the `invoice` field and the `collect` field. `invoiceCollect` is available only for backward compatibility.   If `true`, an invoice is generated and payment collected automatically during the subscription process. If `false`, no invoicing or payment takes place.  The invoice generated in this operation is only for this subscription, not for the entire customer account.  **Note**: This field is only available if you set the `zuora-version` request header to `186.0`, `187.0`, `188.0`, or `189.0`. ")

  public Boolean getInvoiceCollect() {
    return invoiceCollect;
  }


  public void setInvoiceCollect(Boolean invoiceCollect) {
    
    
    
    this.invoiceCollect = invoiceCollect;
  }


  public PUTSubscriptionType invoiceSeparately(Boolean invoiceSeparately) {
    
    
    
    
    this.invoiceSeparately = invoiceSeparately;
    return this;
  }

   /**
   * Separates a single subscription from other subscriptions and invoices the charge independently.   If the value is &#x60;true&#x60;, the subscription is billed separately from other subscriptions. If the value is &#x60;false&#x60;, the subscription is included with other subscriptions in the account invoice.  The default value is &#x60;false&#x60;. Prerequisite: The default subscription setting Enable Subscriptions to be Invoiced Separately must be set to Yes. 
   * @return invoiceSeparately
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Separates a single subscription from other subscriptions and invoices the charge independently.   If the value is `true`, the subscription is billed separately from other subscriptions. If the value is `false`, the subscription is included with other subscriptions in the account invoice.  The default value is `false`. Prerequisite: The default subscription setting Enable Subscriptions to be Invoiced Separately must be set to Yes. ")

  public Boolean getInvoiceSeparately() {
    return invoiceSeparately;
  }


  public void setInvoiceSeparately(Boolean invoiceSeparately) {
    
    
    
    this.invoiceSeparately = invoiceSeparately;
  }


  public PUTSubscriptionType invoiceTargetDate(LocalDate invoiceTargetDate) {
    
    
    
    
    this.invoiceTargetDate = invoiceTargetDate;
    return this;
  }

   /**
   * **Note:** This field has been replaced by the &#x60;targetDate&#x60; field. The &#x60;invoiceTargetDate&#x60; field is only available for backward compatibility.   Date through which to calculate charges if an invoice is generated, as yyyy-mm-dd. Default is current date.   This field is in Zuora REST API version control. Supported minor versions are &#x60;207.0&#x60; and earlier [available versions](https://developer.zuora.com/api-references/api/overview/#section/API-Versions/Minor-Version). 
   * @return invoiceTargetDate
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "**Note:** This field has been replaced by the `targetDate` field. The `invoiceTargetDate` field is only available for backward compatibility.   Date through which to calculate charges if an invoice is generated, as yyyy-mm-dd. Default is current date.   This field is in Zuora REST API version control. Supported minor versions are `207.0` and earlier [available versions](https://developer.zuora.com/api-references/api/overview/#section/API-Versions/Minor-Version). ")

  public LocalDate getInvoiceTargetDate() {
    return invoiceTargetDate;
  }


  public void setInvoiceTargetDate(LocalDate invoiceTargetDate) {
    
    
    
    this.invoiceTargetDate = invoiceTargetDate;
  }


  public PUTSubscriptionType notes(String notes) {
    
    
    
    
    this.notes = notes;
    return this;
  }

   /**
   * String of up to 500 characters. 
   * @return notes
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "String of up to 500 characters. ")

  public String getNotes() {
    return notes;
  }


  public void setNotes(String notes) {
    
    
    
    this.notes = notes;
  }


  public PUTSubscriptionType preview(Boolean preview) {
    
    
    
    
    this.preview = preview;
    return this;
  }

   /**
   * If &#x60;true&#x60; the update is made in preview mode. The default setting is &#x60;false&#x60;. 
   * @return preview
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "If `true` the update is made in preview mode. The default setting is `false`. ")

  public Boolean getPreview() {
    return preview;
  }


  public void setPreview(Boolean preview) {
    
    
    
    this.preview = preview;
  }


  public PUTSubscriptionType previewType(String previewType) {
    
    
    
    
    this.previewType = previewType;
    return this;
  }

   /**
   * The type of preview you will receive.   This field is in Zuora REST API version control. The supported values of this field depend on the REST API minor version you specified in the request header.   * If you do not specify the REST API minor version or specify the minor version number to one of following values in the request header:    * 186.0   * 187.0   * 188.0   * 189.0   * 196.0   * 206.0    The following values are supported in the **previewType** field:    * InvoiceItem   * ChargeMetrics   * InvoiceItemChargeMetrics    The default value is InvoiceItem.  * If you specify the REST API minor version to 207.0 or later [available versions](https://developer.zuora.com/api-references/api/overview/#section/API-Versions/Minor-Version) in the request header, the following values are supported in the **previewType** field:    - LegalDoc   - ChargeMetrics   - LegalDocChargeMetrics    The default value is LegalDoc.  . 
   * @return previewType
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The type of preview you will receive.   This field is in Zuora REST API version control. The supported values of this field depend on the REST API minor version you specified in the request header.   * If you do not specify the REST API minor version or specify the minor version number to one of following values in the request header:    * 186.0   * 187.0   * 188.0   * 189.0   * 196.0   * 206.0    The following values are supported in the **previewType** field:    * InvoiceItem   * ChargeMetrics   * InvoiceItemChargeMetrics    The default value is InvoiceItem.  * If you specify the REST API minor version to 207.0 or later [available versions](https://developer.zuora.com/api-references/api/overview/#section/API-Versions/Minor-Version) in the request header, the following values are supported in the **previewType** field:    - LegalDoc   - ChargeMetrics   - LegalDocChargeMetrics    The default value is LegalDoc.  . ")

  public String getPreviewType() {
    return previewType;
  }


  public void setPreviewType(String previewType) {
    
    
    
    this.previewType = previewType;
  }


  public PUTSubscriptionType remove(List<PUTSrpRemoveType> remove) {
    
    
    
    
    this.remove = remove;
    return this;
  }

  public PUTSubscriptionType addRemoveItem(PUTSrpRemoveType removeItem) {
    if (this.remove == null) {
      this.remove = new ArrayList<>();
    }
    this.remove.add(removeItem);
    return this;
  }

   /**
   * Container for removing one or more rate plans. 
   * @return remove
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Container for removing one or more rate plans. ")

  public List<PUTSrpRemoveType> getRemove() {
    return remove;
  }


  public void setRemove(List<PUTSrpRemoveType> remove) {
    
    
    
    this.remove = remove;
  }


  public PUTSubscriptionType renewalSetting(String renewalSetting) {
    
    
    
    
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


  public PUTSubscriptionType renewalTerm(Long renewalTerm) {
    
    
    
    
    this.renewalTerm = renewalTerm;
    return this;
  }

   /**
   * The length of the period for the subscription renewal term. Default is &#x60;0&#x60;. 
   * @return renewalTerm
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The length of the period for the subscription renewal term. Default is `0`. ")

  public Long getRenewalTerm() {
    return renewalTerm;
  }


  public void setRenewalTerm(Long renewalTerm) {
    
    
    
    this.renewalTerm = renewalTerm;
  }


  public PUTSubscriptionType renewalTermPeriodType(String renewalTermPeriodType) {
    
    
    
    
    this.renewalTermPeriodType = renewalTermPeriodType;
    return this;
  }

   /**
   *  The period type for the subscription renewal term.  This field is used with the &#x60;renewalTerm&#x60; field to specify the subscription renewal term.  Values are:  * &#x60;Month&#x60; (default) * &#x60;Year&#x60; * &#x60;Day&#x60; * &#x60;Week&#x60; 
   * @return renewalTermPeriodType
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = " The period type for the subscription renewal term.  This field is used with the `renewalTerm` field to specify the subscription renewal term.  Values are:  * `Month` (default) * `Year` * `Day` * `Week` ")

  public String getRenewalTermPeriodType() {
    return renewalTermPeriodType;
  }


  public void setRenewalTermPeriodType(String renewalTermPeriodType) {
    
    
    
    this.renewalTermPeriodType = renewalTermPeriodType;
  }


  public PUTSubscriptionType runBilling(RunBillingEnum runBilling) {
    
    
    
    
    this.runBilling = runBilling;
    return this;
  }

   /**
   * Creates an invoice for a subscription. If you have the Invoice Settlement feature enabled, a credit memo might also be created based on the [invoice and credit memo generation rule](https://knowledgecenter.zuora.com/CB_Billing/Invoice_Settlement/Credit_and_Debit_Memos/Rules_for_Generating_Invoices_and_Credit_Memos).     The billing documents generated in this operation is only for this subscription, not for the entire customer account.   Possible values:  - &#x60;true&#x60;: An invoice is created. If you have the Invoice Settlement feature enabled, a credit memo might also be created.   - &#x60;false&#x60;: No invoice is created.   **Note:** This field is in Zuora REST API version control. Supported minor versions are &#x60;211.0&#x60; or later [available versions](https://developer.zuora.com/api-references/api/overview/#section/API-Versions/Minor-Version). To use this field in the method, you must set the &#x60;zuora-version&#x60; parameter to the minor version number in the request header. 
   * @return runBilling
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "FALSE", value = "Creates an invoice for a subscription. If you have the Invoice Settlement feature enabled, a credit memo might also be created based on the [invoice and credit memo generation rule](https://knowledgecenter.zuora.com/CB_Billing/Invoice_Settlement/Credit_and_Debit_Memos/Rules_for_Generating_Invoices_and_Credit_Memos).     The billing documents generated in this operation is only for this subscription, not for the entire customer account.   Possible values:  - `true`: An invoice is created. If you have the Invoice Settlement feature enabled, a credit memo might also be created.   - `false`: No invoice is created.   **Note:** This field is in Zuora REST API version control. Supported minor versions are `211.0` or later [available versions](https://developer.zuora.com/api-references/api/overview/#section/API-Versions/Minor-Version). To use this field in the method, you must set the `zuora-version` parameter to the minor version number in the request header. ")

  public RunBillingEnum getRunBilling() {
    return runBilling;
  }


  public void setRunBilling(RunBillingEnum runBilling) {
    
    
    
    this.runBilling = runBilling;
  }


  public PUTSubscriptionType targetDate(LocalDate targetDate) {
    
    
    
    
    this.targetDate = targetDate;
    return this;
  }

   /**
   * Date through which to calculate charges if an invoice or a credit memo is generated, as yyyy-mm-dd. Default is current date.   **Note:** The credit memo is only available if you have the Invoice Settlement feature enabled.   This field is in Zuora REST API version control. Supported minor versions are &#x60;211.0&#x60; and later. To use this field in the method, you must set the  &#x60;zuora-version&#x60; parameter to the minor version number in the request header. 
   * @return targetDate
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Date through which to calculate charges if an invoice or a credit memo is generated, as yyyy-mm-dd. Default is current date.   **Note:** The credit memo is only available if you have the Invoice Settlement feature enabled.   This field is in Zuora REST API version control. Supported minor versions are `211.0` and later. To use this field in the method, you must set the  `zuora-version` parameter to the minor version number in the request header. ")

  public LocalDate getTargetDate() {
    return targetDate;
  }


  public void setTargetDate(LocalDate targetDate) {
    
    
    
    this.targetDate = targetDate;
  }


  public PUTSubscriptionType termStartDate(LocalDate termStartDate) {
    
    
    
    
    this.termStartDate = termStartDate;
    return this;
  }

   /**
   * Date the subscription term begins, as yyyy-mm-dd. If this is a renewal subscription, this date is different from the subscription start date.  
   * @return termStartDate
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Date the subscription term begins, as yyyy-mm-dd. If this is a renewal subscription, this date is different from the subscription start date.  ")

  public LocalDate getTermStartDate() {
    return termStartDate;
  }


  public void setTermStartDate(LocalDate termStartDate) {
    
    
    
    this.termStartDate = termStartDate;
  }


  public PUTSubscriptionType termType(String termType) {
    
    
    
    
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


  public PUTSubscriptionType update(List<PUTSrpUpdateType> update) {
    
    
    
    
    this.update = update;
    return this;
  }

  public PUTSubscriptionType addUpdateItem(PUTSrpUpdateType updateItem) {
    if (this.update == null) {
      this.update = new ArrayList<>();
    }
    this.update.add(updateItem);
    return this;
  }

   /**
   * Container for updating one or more rate plans. 
   * @return update
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Container for updating one or more rate plans. ")

  public List<PUTSrpUpdateType> getUpdate() {
    return update;
  }


  public void setUpdate(List<PUTSrpUpdateType> update) {
    
    
    
    this.update = update;
  }


  public PUTSubscriptionType cpqBundleJsonIdQT(String cpqBundleJsonIdQT) {
    
    
    
    
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


  public PUTSubscriptionType opportunityCloseDateQT(LocalDate opportunityCloseDateQT) {
    
    
    
    
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


  public PUTSubscriptionType opportunityNameQT(String opportunityNameQT) {
    
    
    
    
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


  public PUTSubscriptionType quoteBusinessTypeQT(String quoteBusinessTypeQT) {
    
    
    
    
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


  public PUTSubscriptionType quoteNumberQT(String quoteNumberQT) {
    
    
    
    
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


  public PUTSubscriptionType quoteTypeQT(String quoteTypeQT) {
    
    
    
    
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


  public PUTSubscriptionType integrationIdNS(String integrationIdNS) {
    
    
    
    
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


  public PUTSubscriptionType integrationStatusNS(String integrationStatusNS) {
    
    
    
    
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


  public PUTSubscriptionType projectNS(String projectNS) {
    
    
    
    
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


  public PUTSubscriptionType salesOrderNS(String salesOrderNS) {
    
    
    
    
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


  public PUTSubscriptionType syncDateNS(String syncDateNS) {
    
    
    
    
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
   * @return the PUTSubscriptionType instance itself
   */
  public PUTSubscriptionType putAdditionalProperty(String key, Object value) {
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
    PUTSubscriptionType puTSubscriptionType = (PUTSubscriptionType) o;
    return Objects.equals(this.add, puTSubscriptionType.add) &&
        Objects.equals(this.applicationOrder, puTSubscriptionType.applicationOrder) &&
        Objects.equals(this.applyCredit, puTSubscriptionType.applyCredit) &&
        Objects.equals(this.applyCreditBalance, puTSubscriptionType.applyCreditBalance) &&
        Objects.equals(this.autoRenew, puTSubscriptionType.autoRenew) &&
        Objects.equals(this.bookingDate, puTSubscriptionType.bookingDate) &&
        Objects.equals(this.change, puTSubscriptionType.change) &&
        Objects.equals(this.collect, puTSubscriptionType.collect) &&
        Objects.equals(this.creditMemoReasonCode, puTSubscriptionType.creditMemoReasonCode) &&
        Objects.equals(this.currentTerm, puTSubscriptionType.currentTerm) &&
        Objects.equals(this.currentTermPeriodType, puTSubscriptionType.currentTermPeriodType) &&
        Objects.equals(this.documentDate, puTSubscriptionType.documentDate) &&
        Objects.equals(this.externallyManagedBy, puTSubscriptionType.externallyManagedBy) &&
        Objects.equals(this.includeExistingDraftDocItems, puTSubscriptionType.includeExistingDraftDocItems) &&
        Objects.equals(this.includeExistingDraftInvoiceItems, puTSubscriptionType.includeExistingDraftInvoiceItems) &&
        Objects.equals(this.invoice, puTSubscriptionType.invoice) &&
        Objects.equals(this.invoiceCollect, puTSubscriptionType.invoiceCollect) &&
        Objects.equals(this.invoiceSeparately, puTSubscriptionType.invoiceSeparately) &&
        Objects.equals(this.invoiceTargetDate, puTSubscriptionType.invoiceTargetDate) &&
        Objects.equals(this.notes, puTSubscriptionType.notes) &&
        Objects.equals(this.preview, puTSubscriptionType.preview) &&
        Objects.equals(this.previewType, puTSubscriptionType.previewType) &&
        Objects.equals(this.remove, puTSubscriptionType.remove) &&
        Objects.equals(this.renewalSetting, puTSubscriptionType.renewalSetting) &&
        Objects.equals(this.renewalTerm, puTSubscriptionType.renewalTerm) &&
        Objects.equals(this.renewalTermPeriodType, puTSubscriptionType.renewalTermPeriodType) &&
        Objects.equals(this.runBilling, puTSubscriptionType.runBilling) &&
        Objects.equals(this.targetDate, puTSubscriptionType.targetDate) &&
        Objects.equals(this.termStartDate, puTSubscriptionType.termStartDate) &&
        Objects.equals(this.termType, puTSubscriptionType.termType) &&
        Objects.equals(this.update, puTSubscriptionType.update) &&
        Objects.equals(this.cpqBundleJsonIdQT, puTSubscriptionType.cpqBundleJsonIdQT) &&
        Objects.equals(this.opportunityCloseDateQT, puTSubscriptionType.opportunityCloseDateQT) &&
        Objects.equals(this.opportunityNameQT, puTSubscriptionType.opportunityNameQT) &&
        Objects.equals(this.quoteBusinessTypeQT, puTSubscriptionType.quoteBusinessTypeQT) &&
        Objects.equals(this.quoteNumberQT, puTSubscriptionType.quoteNumberQT) &&
        Objects.equals(this.quoteTypeQT, puTSubscriptionType.quoteTypeQT) &&
        Objects.equals(this.integrationIdNS, puTSubscriptionType.integrationIdNS) &&
        Objects.equals(this.integrationStatusNS, puTSubscriptionType.integrationStatusNS) &&
        Objects.equals(this.projectNS, puTSubscriptionType.projectNS) &&
        Objects.equals(this.salesOrderNS, puTSubscriptionType.salesOrderNS) &&
        Objects.equals(this.syncDateNS, puTSubscriptionType.syncDateNS)&&
        Objects.equals(this.additionalProperties, puTSubscriptionType.additionalProperties);
  }

  @Override
  public int hashCode() {
    return Objects.hash(add, applicationOrder, applyCredit, applyCreditBalance, autoRenew, bookingDate, change, collect, creditMemoReasonCode, currentTerm, currentTermPeriodType, documentDate, externallyManagedBy, includeExistingDraftDocItems, includeExistingDraftInvoiceItems, invoice, invoiceCollect, invoiceSeparately, invoiceTargetDate, notes, preview, previewType, remove, renewalSetting, renewalTerm, renewalTermPeriodType, runBilling, targetDate, termStartDate, termType, update, cpqBundleJsonIdQT, opportunityCloseDateQT, opportunityNameQT, quoteBusinessTypeQT, quoteNumberQT, quoteTypeQT, integrationIdNS, integrationStatusNS, projectNS, salesOrderNS, syncDateNS, additionalProperties);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PUTSubscriptionType {\n");
    sb.append("    add: ").append(toIndentedString(add)).append("\n");
    sb.append("    applicationOrder: ").append(toIndentedString(applicationOrder)).append("\n");
    sb.append("    applyCredit: ").append(toIndentedString(applyCredit)).append("\n");
    sb.append("    applyCreditBalance: ").append(toIndentedString(applyCreditBalance)).append("\n");
    sb.append("    autoRenew: ").append(toIndentedString(autoRenew)).append("\n");
    sb.append("    bookingDate: ").append(toIndentedString(bookingDate)).append("\n");
    sb.append("    change: ").append(toIndentedString(change)).append("\n");
    sb.append("    collect: ").append(toIndentedString(collect)).append("\n");
    sb.append("    creditMemoReasonCode: ").append(toIndentedString(creditMemoReasonCode)).append("\n");
    sb.append("    currentTerm: ").append(toIndentedString(currentTerm)).append("\n");
    sb.append("    currentTermPeriodType: ").append(toIndentedString(currentTermPeriodType)).append("\n");
    sb.append("    documentDate: ").append(toIndentedString(documentDate)).append("\n");
    sb.append("    externallyManagedBy: ").append(toIndentedString(externallyManagedBy)).append("\n");
    sb.append("    includeExistingDraftDocItems: ").append(toIndentedString(includeExistingDraftDocItems)).append("\n");
    sb.append("    includeExistingDraftInvoiceItems: ").append(toIndentedString(includeExistingDraftInvoiceItems)).append("\n");
    sb.append("    invoice: ").append(toIndentedString(invoice)).append("\n");
    sb.append("    invoiceCollect: ").append(toIndentedString(invoiceCollect)).append("\n");
    sb.append("    invoiceSeparately: ").append(toIndentedString(invoiceSeparately)).append("\n");
    sb.append("    invoiceTargetDate: ").append(toIndentedString(invoiceTargetDate)).append("\n");
    sb.append("    notes: ").append(toIndentedString(notes)).append("\n");
    sb.append("    preview: ").append(toIndentedString(preview)).append("\n");
    sb.append("    previewType: ").append(toIndentedString(previewType)).append("\n");
    sb.append("    remove: ").append(toIndentedString(remove)).append("\n");
    sb.append("    renewalSetting: ").append(toIndentedString(renewalSetting)).append("\n");
    sb.append("    renewalTerm: ").append(toIndentedString(renewalTerm)).append("\n");
    sb.append("    renewalTermPeriodType: ").append(toIndentedString(renewalTermPeriodType)).append("\n");
    sb.append("    runBilling: ").append(toIndentedString(runBilling)).append("\n");
    sb.append("    targetDate: ").append(toIndentedString(targetDate)).append("\n");
    sb.append("    termStartDate: ").append(toIndentedString(termStartDate)).append("\n");
    sb.append("    termType: ").append(toIndentedString(termType)).append("\n");
    sb.append("    update: ").append(toIndentedString(update)).append("\n");
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
    openapiFields.add("add");
    openapiFields.add("applicationOrder");
    openapiFields.add("applyCredit");
    openapiFields.add("applyCreditBalance");
    openapiFields.add("autoRenew");
    openapiFields.add("bookingDate");
    openapiFields.add("change");
    openapiFields.add("collect");
    openapiFields.add("creditMemoReasonCode");
    openapiFields.add("currentTerm");
    openapiFields.add("currentTermPeriodType");
    openapiFields.add("documentDate");
    openapiFields.add("externallyManagedBy");
    openapiFields.add("includeExistingDraftDocItems");
    openapiFields.add("includeExistingDraftInvoiceItems");
    openapiFields.add("invoice");
    openapiFields.add("invoiceCollect");
    openapiFields.add("invoiceSeparately");
    openapiFields.add("invoiceTargetDate");
    openapiFields.add("notes");
    openapiFields.add("preview");
    openapiFields.add("previewType");
    openapiFields.add("remove");
    openapiFields.add("renewalSetting");
    openapiFields.add("renewalTerm");
    openapiFields.add("renewalTermPeriodType");
    openapiFields.add("runBilling");
    openapiFields.add("targetDate");
    openapiFields.add("termStartDate");
    openapiFields.add("termType");
    openapiFields.add("update");
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
  * @throws IOException if the JSON Object is invalid with respect to PUTSubscriptionType
  */
  public static void validateJsonObject(JsonObject jsonObj) throws IOException {
      if (jsonObj == null) {
        if (!PUTSubscriptionType.openapiRequiredFields.isEmpty()) { // has required fields but JSON object is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in PUTSubscriptionType is not found in the empty JSON string", PUTSubscriptionType.openapiRequiredFields.toString()));
        }
      }
      if (jsonObj.get("add") != null && !jsonObj.get("add").isJsonNull()) {
        JsonArray jsonArrayadd = jsonObj.getAsJsonArray("add");
        if (jsonArrayadd != null) {
          // ensure the json data is an array
          if (!jsonObj.get("add").isJsonArray()) {
            throw new IllegalArgumentException(String.format("Expected the field `add` to be an array in the JSON string but got `%s`", jsonObj.get("add").toString()));
          }

          // validate the optional field `add` (array)
          for (int i = 0; i < jsonArrayadd.size(); i++) {
            PUTSrpAddType.validateJsonObject(jsonArrayadd.get(i).getAsJsonObject());
          };
        }
      }
      // ensure the optional json data is an array if present
      if (jsonObj.get("applicationOrder") != null && !jsonObj.get("applicationOrder").isJsonArray()) {
        throw new IllegalArgumentException(String.format("Expected the field `applicationOrder` to be an array in the JSON string but got `%s`", jsonObj.get("applicationOrder").toString()));
      }
      if (jsonObj.get("change") != null && !jsonObj.get("change").isJsonNull()) {
        JsonArray jsonArraychange = jsonObj.getAsJsonArray("change");
        if (jsonArraychange != null) {
          // ensure the json data is an array
          if (!jsonObj.get("change").isJsonArray()) {
            throw new IllegalArgumentException(String.format("Expected the field `change` to be an array in the JSON string but got `%s`", jsonObj.get("change").toString()));
          }

          // validate the optional field `change` (array)
          for (int i = 0; i < jsonArraychange.size(); i++) {
            PUTSrpChangeType.validateJsonObject(jsonArraychange.get(i).getAsJsonObject());
          };
        }
      }
      if ((jsonObj.get("creditMemoReasonCode") != null && !jsonObj.get("creditMemoReasonCode").isJsonNull()) && !jsonObj.get("creditMemoReasonCode").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `creditMemoReasonCode` to be a primitive type in the JSON string but got `%s`", jsonObj.get("creditMemoReasonCode").toString()));
      }
      if ((jsonObj.get("currentTermPeriodType") != null && !jsonObj.get("currentTermPeriodType").isJsonNull()) && !jsonObj.get("currentTermPeriodType").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `currentTermPeriodType` to be a primitive type in the JSON string but got `%s`", jsonObj.get("currentTermPeriodType").toString()));
      }
      if ((jsonObj.get("externallyManagedBy") != null && !jsonObj.get("externallyManagedBy").isJsonNull()) && !jsonObj.get("externallyManagedBy").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `externallyManagedBy` to be a primitive type in the JSON string but got `%s`", jsonObj.get("externallyManagedBy").toString()));
      }
      if ((jsonObj.get("notes") != null && !jsonObj.get("notes").isJsonNull()) && !jsonObj.get("notes").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `notes` to be a primitive type in the JSON string but got `%s`", jsonObj.get("notes").toString()));
      }
      if ((jsonObj.get("previewType") != null && !jsonObj.get("previewType").isJsonNull()) && !jsonObj.get("previewType").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `previewType` to be a primitive type in the JSON string but got `%s`", jsonObj.get("previewType").toString()));
      }
      if (jsonObj.get("remove") != null && !jsonObj.get("remove").isJsonNull()) {
        JsonArray jsonArrayremove = jsonObj.getAsJsonArray("remove");
        if (jsonArrayremove != null) {
          // ensure the json data is an array
          if (!jsonObj.get("remove").isJsonArray()) {
            throw new IllegalArgumentException(String.format("Expected the field `remove` to be an array in the JSON string but got `%s`", jsonObj.get("remove").toString()));
          }

          // validate the optional field `remove` (array)
          for (int i = 0; i < jsonArrayremove.size(); i++) {
            PUTSrpRemoveType.validateJsonObject(jsonArrayremove.get(i).getAsJsonObject());
          };
        }
      }
      if ((jsonObj.get("renewalSetting") != null && !jsonObj.get("renewalSetting").isJsonNull()) && !jsonObj.get("renewalSetting").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `renewalSetting` to be a primitive type in the JSON string but got `%s`", jsonObj.get("renewalSetting").toString()));
      }
      if ((jsonObj.get("renewalTermPeriodType") != null && !jsonObj.get("renewalTermPeriodType").isJsonNull()) && !jsonObj.get("renewalTermPeriodType").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `renewalTermPeriodType` to be a primitive type in the JSON string but got `%s`", jsonObj.get("renewalTermPeriodType").toString()));
      }
      if ((jsonObj.get("termType") != null && !jsonObj.get("termType").isJsonNull()) && !jsonObj.get("termType").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `termType` to be a primitive type in the JSON string but got `%s`", jsonObj.get("termType").toString()));
      }
      if (jsonObj.get("update") != null && !jsonObj.get("update").isJsonNull()) {
        JsonArray jsonArrayupdate = jsonObj.getAsJsonArray("update");
        if (jsonArrayupdate != null) {
          // ensure the json data is an array
          if (!jsonObj.get("update").isJsonArray()) {
            throw new IllegalArgumentException(String.format("Expected the field `update` to be an array in the JSON string but got `%s`", jsonObj.get("update").toString()));
          }

          // validate the optional field `update` (array)
          for (int i = 0; i < jsonArrayupdate.size(); i++) {
            PUTSrpUpdateType.validateJsonObject(jsonArrayupdate.get(i).getAsJsonObject());
          };
        }
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
       if (!PUTSubscriptionType.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'PUTSubscriptionType' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<PUTSubscriptionType> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(PUTSubscriptionType.class));

       return (TypeAdapter<T>) new TypeAdapter<PUTSubscriptionType>() {
           @Override
           public void write(JsonWriter out, PUTSubscriptionType value) throws IOException {
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
           public PUTSubscriptionType read(JsonReader in) throws IOException {
             JsonObject jsonObj = elementAdapter.read(in).getAsJsonObject();
             validateJsonObject(jsonObj);
             // store additional fields in the deserialized instance
             PUTSubscriptionType instance = thisAdapter.fromJsonTree(jsonObj);
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
  * Create an instance of PUTSubscriptionType given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of PUTSubscriptionType
  * @throws IOException if the JSON string is invalid with respect to PUTSubscriptionType
  */
  public static PUTSubscriptionType fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, PUTSubscriptionType.class);
  }

 /**
  * Convert an instance of PUTSubscriptionType to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

