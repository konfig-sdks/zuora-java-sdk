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
import java.time.LocalDate;
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
 * PostOrderLineItemUpdateType
 */@javax.annotation.Generated(value = "Generated by https://konfigthis.com")
public class PostOrderLineItemUpdateType {
  public static final String SERIALIZED_NAME_ID = "id";
  @SerializedName(SERIALIZED_NAME_ID)
  private UUID id;

  public static final String SERIALIZED_NAME_DESCRIPTION = "description";
  @SerializedName(SERIALIZED_NAME_DESCRIPTION)
  private String description;

  public static final String SERIALIZED_NAME_U_O_M = "UOM";
  @SerializedName(SERIALIZED_NAME_U_O_M)
  private String UOM;

  public static final String SERIALIZED_NAME_ACCOUNTING_CODE = "accountingCode";
  @SerializedName(SERIALIZED_NAME_ACCOUNTING_CODE)
  private String accountingCode;

  public static final String SERIALIZED_NAME_ADJUSTMENT_LIABILITY_ACCOUNTING_CODE = "adjustmentLiabilityAccountingCode";
  @SerializedName(SERIALIZED_NAME_ADJUSTMENT_LIABILITY_ACCOUNTING_CODE)
  private String adjustmentLiabilityAccountingCode;

  public static final String SERIALIZED_NAME_ADJUSTMENT_REVENUE_ACCOUNTING_CODE = "adjustmentRevenueAccountingCode";
  @SerializedName(SERIALIZED_NAME_ADJUSTMENT_REVENUE_ACCOUNTING_CODE)
  private String adjustmentRevenueAccountingCode;

  public static final String SERIALIZED_NAME_AMOUNT_PER_UNIT = "amountPerUnit";
  @SerializedName(SERIALIZED_NAME_AMOUNT_PER_UNIT)
  private Double amountPerUnit;

  public static final String SERIALIZED_NAME_BILL_TARGET_DATE = "billTargetDate";
  @SerializedName(SERIALIZED_NAME_BILL_TARGET_DATE)
  private LocalDate billTargetDate;

  public static final String SERIALIZED_NAME_BILL_TO = "billTo";
  @SerializedName(SERIALIZED_NAME_BILL_TO)
  private String billTo;

  /**
   * The rule for billing of the Order Line Item (OLI).  You can update this field for a sales or return OLI only when it is in the &#x60;Executing&#x60; state (when the &#x60;itemState&#x60; field is set as &#x60;Executing&#x60;). 
   */
  @JsonAdapter(BillingRuleEnum.Adapter.class)
 public enum BillingRuleEnum {
    TRIGGERWITHOUTFULFILLMENT("TriggerWithoutFulfillment"),
    
    TRIGGERASFULFILLMENTOCCURS("TriggerAsFulfillmentOccurs");

    private String value;

    BillingRuleEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static BillingRuleEnum fromValue(String value) {
      for (BillingRuleEnum b : BillingRuleEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<BillingRuleEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final BillingRuleEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public BillingRuleEnum read(final JsonReader jsonReader) throws IOException {
        String value =  jsonReader.nextString();
        return BillingRuleEnum.fromValue(value);
      }
    }
  }

  public static final String SERIALIZED_NAME_BILLING_RULE = "billingRule";
  @SerializedName(SERIALIZED_NAME_BILLING_RULE)
  private BillingRuleEnum billingRule = BillingRuleEnum.TRIGGERWITHOUTFULFILLMENT;

  public static final String SERIALIZED_NAME_CONTRACT_ASSET_ACCOUNTING_CODE = "contractAssetAccountingCode";
  @SerializedName(SERIALIZED_NAME_CONTRACT_ASSET_ACCOUNTING_CODE)
  private String contractAssetAccountingCode;

  public static final String SERIALIZED_NAME_CONTRACT_LIABILITY_ACCOUNTING_CODE = "contractLiabilityAccountingCode";
  @SerializedName(SERIALIZED_NAME_CONTRACT_LIABILITY_ACCOUNTING_CODE)
  private String contractLiabilityAccountingCode;

  public static final String SERIALIZED_NAME_CONTRACT_RECOGNIZED_REVENUE_ACCOUNTING_CODE = "contractRecognizedRevenueAccountingCode";
  @SerializedName(SERIALIZED_NAME_CONTRACT_RECOGNIZED_REVENUE_ACCOUNTING_CODE)
  private String contractRecognizedRevenueAccountingCode;

  public static final String SERIALIZED_NAME_CUSTOM_FIELDS = "customFields";
  @SerializedName(SERIALIZED_NAME_CUSTOM_FIELDS)
  private Map<String, Object> customFields = null;

  public static final String SERIALIZED_NAME_DEFERRED_REVENUE_ACCOUNTING_CODE = "deferredRevenueAccountingCode";
  @SerializedName(SERIALIZED_NAME_DEFERRED_REVENUE_ACCOUNTING_CODE)
  private String deferredRevenueAccountingCode;

  public static final String SERIALIZED_NAME_EXCLUDE_ITEM_BILLING_FROM_REVENUE_ACCOUNTING = "excludeItemBillingFromRevenueAccounting";
  @SerializedName(SERIALIZED_NAME_EXCLUDE_ITEM_BILLING_FROM_REVENUE_ACCOUNTING)
  private Boolean excludeItemBillingFromRevenueAccounting;

  public static final String SERIALIZED_NAME_EXCLUDE_ITEM_BOOKING_FROM_REVENUE_ACCOUNTING = "excludeItemBookingFromRevenueAccounting";
  @SerializedName(SERIALIZED_NAME_EXCLUDE_ITEM_BOOKING_FROM_REVENUE_ACCOUNTING)
  private Boolean excludeItemBookingFromRevenueAccounting;

  public static final String SERIALIZED_NAME_INVOICE_GROUP_NUMBER = "invoiceGroupNumber";
  @SerializedName(SERIALIZED_NAME_INVOICE_GROUP_NUMBER)
  private String invoiceGroupNumber;

  public static final String SERIALIZED_NAME_INLINE_DISCOUNT_PER_UNIT = "inlineDiscountPerUnit";
  @SerializedName(SERIALIZED_NAME_INLINE_DISCOUNT_PER_UNIT)
  private Double inlineDiscountPerUnit;

  /**
   * You can update this field only for a sales OLI and only when the sales OLI is in the &#x60;Executing&#x60; state (when the &#x60;itemState&#x60; field is set as &#x60;Executing&#x60;).  Use this field to specify the inline discount type, which can be &#x60;Percentage&#x60;, &#x60;FixedAmount&#x60;, or &#x60;None&#x60;. The default value is &#x60;Percentage&#x60;.  Use this field together with the &#x60;inlineDiscountPerUnit&#x60; field to specify inline discounts for order line items. The inline discount is applied to the list price of an order line item.   Once you set the &#x60;inlineDiscountType&#x60;, &#x60;inlineDiscountPerUnit&#x60;, and &#x60;listPricePerUnit&#x60; fields, the system will automatically generate the &#x60;amountPerUnit&#x60; field. You shall not set the &#x60;amountPerUnit&#x60; field by yourself. 
   */
  @JsonAdapter(InlineDiscountTypeEnum.Adapter.class)
 public enum InlineDiscountTypeEnum {
    PERCENTAGE("Percentage"),
    
    FIXEDAMOUNT("FixedAmount"),
    
    NONE("None");

    private String value;

    InlineDiscountTypeEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static InlineDiscountTypeEnum fromValue(String value) {
      for (InlineDiscountTypeEnum b : InlineDiscountTypeEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<InlineDiscountTypeEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final InlineDiscountTypeEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public InlineDiscountTypeEnum read(final JsonReader jsonReader) throws IOException {
        String value =  jsonReader.nextString();
        return InlineDiscountTypeEnum.fromValue(value);
      }
    }
  }

  public static final String SERIALIZED_NAME_INLINE_DISCOUNT_TYPE = "inlineDiscountType";
  @SerializedName(SERIALIZED_NAME_INLINE_DISCOUNT_TYPE)
  private InlineDiscountTypeEnum inlineDiscountType;

  public static final String SERIALIZED_NAME_IS_ALLOCATION_ELIGIBLE = "isAllocationEligible";
  @SerializedName(SERIALIZED_NAME_IS_ALLOCATION_ELIGIBLE)
  private Boolean isAllocationEligible;

  public static final String SERIALIZED_NAME_IS_UNBILLED = "isUnbilled";
  @SerializedName(SERIALIZED_NAME_IS_UNBILLED)
  private Boolean isUnbilled;

  public static final String SERIALIZED_NAME_ITEM_NAME = "itemName";
  @SerializedName(SERIALIZED_NAME_ITEM_NAME)
  private String itemName;

  public static final String SERIALIZED_NAME_ITEM_NUMBER = "itemNumber";
  @SerializedName(SERIALIZED_NAME_ITEM_NUMBER)
  private String itemNumber;

  /**
   * The state of the Order Line Item (OLI). See [State transitions for an order, order line item, and fulfillment](https://knowledgecenter.zuora.com/Billing/Subscriptions/Orders/Order_Line_Items/AB_Order_Line_Item_States_and_Order_States) for more information.  To generate invoice for an OLI, you must set this field to &#x60;SentToBilling&#x60; and set the &#x60;billTargetDate&#x60; field .  You can update this field for a sales or return OLI only when the OLI is in the &#x60;Executing&#x60; or &#39;Booked&#39; or &#x60;SentToBilling&#x60;state (when the &#x60;itemState&#x60; field is set as &#x60;Executing&#x60; or &#x60;SentToBilling&#x60;). 
   */
  @JsonAdapter(ItemStateEnum.Adapter.class)
 public enum ItemStateEnum {
    EXECUTING("Executing"),
    
    BOOKED("Booked"),
    
    SENTTOBILLING("SentToBilling"),
    
    COMPLETE("Complete"),
    
    CANCELLED("Cancelled");

    private String value;

    ItemStateEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static ItemStateEnum fromValue(String value) {
      for (ItemStateEnum b : ItemStateEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<ItemStateEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final ItemStateEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public ItemStateEnum read(final JsonReader jsonReader) throws IOException {
        String value =  jsonReader.nextString();
        return ItemStateEnum.fromValue(value);
      }
    }
  }

  public static final String SERIALIZED_NAME_ITEM_STATE = "itemState";
  @SerializedName(SERIALIZED_NAME_ITEM_STATE)
  private ItemStateEnum itemState;

  /**
   * The type of the Order Line Item (OLI).   You can update this field only for a sales OLI and only when the sales OLI is in the &#x60;Executing&#x60; state (when the &#x60;itemState&#x60; field is set as &#x60;Executing&#x60;). 
   */
  @JsonAdapter(ItemTypeEnum.Adapter.class)
 public enum ItemTypeEnum {
    PRODUCT("Product"),
    
    FEE("Fee"),
    
    SERVICES("Services");

    private String value;

    ItemTypeEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static ItemTypeEnum fromValue(String value) {
      for (ItemTypeEnum b : ItemTypeEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<ItemTypeEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final ItemTypeEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public ItemTypeEnum read(final JsonReader jsonReader) throws IOException {
        String value =  jsonReader.nextString();
        return ItemTypeEnum.fromValue(value);
      }
    }
  }

  public static final String SERIALIZED_NAME_ITEM_TYPE = "itemType";
  @SerializedName(SERIALIZED_NAME_ITEM_TYPE)
  private ItemTypeEnum itemType;

  public static final String SERIALIZED_NAME_LIST_PRICE_PER_UNIT = "listPricePerUnit";
  @SerializedName(SERIALIZED_NAME_LIST_PRICE_PER_UNIT)
  private Double listPricePerUnit;

  public static final String SERIALIZED_NAME_OWNER_ACCOUNT_NUMBER = "ownerAccountNumber";
  @SerializedName(SERIALIZED_NAME_OWNER_ACCOUNT_NUMBER)
  private String ownerAccountNumber;

  public static final String SERIALIZED_NAME_PRODUCT_CODE = "productCode";
  @SerializedName(SERIALIZED_NAME_PRODUCT_CODE)
  private String productCode;

  public static final String SERIALIZED_NAME_PURCHASE_ORDER_NUMBER = "purchaseOrderNumber";
  @SerializedName(SERIALIZED_NAME_PURCHASE_ORDER_NUMBER)
  private String purchaseOrderNumber;

  public static final String SERIALIZED_NAME_QUANTITY = "quantity";
  @SerializedName(SERIALIZED_NAME_QUANTITY)
  private Double quantity;

  public static final String SERIALIZED_NAME_RECOGNIZED_REVENUE_ACCOUNTING_CODE = "recognizedRevenueAccountingCode";
  @SerializedName(SERIALIZED_NAME_RECOGNIZED_REVENUE_ACCOUNTING_CODE)
  private String recognizedRevenueAccountingCode;

  public static final String SERIALIZED_NAME_RELATED_SUBSCRIPTION_NUMBER = "relatedSubscriptionNumber";
  @SerializedName(SERIALIZED_NAME_RELATED_SUBSCRIPTION_NUMBER)
  private String relatedSubscriptionNumber;

  public static final String SERIALIZED_NAME_REVENUE_RECOGNITION_RULE = "revenueRecognitionRule";
  @SerializedName(SERIALIZED_NAME_REVENUE_RECOGNITION_RULE)
  private String revenueRecognitionRule;

  /**
   * Specifies the type of revenue recognition timing.  Predefined options are listed as enum values in this API Reference. Other options might also be avaliable depending on the &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Enable_Order_to_Revenue/Configure_revenue_settings/Configure_revenue_recognition_policy\&quot; target&#x3D;\&quot;_blank\&quot;&gt;revenue recognition policy configuration&lt;/a&gt; in the Zuora Billing UI.  You can update this field only for a sales OLI and only when the sales OLI is in the &#x60;Executing&#x60; state (when the &#x60;itemState&#x60; field is set as &#x60;Executing&#x60;).  **Note**: This field is only available if you have the Order to Revenue feature enabled.  
   */
  @JsonAdapter(RevenueRecognitionTimingEnum.Adapter.class)
 public enum RevenueRecognitionTimingEnum {
    BILLING_DOCUMENT_POSTING_DATE("Upon Billing Document Posting Date"),
    
    ORDER_ACTIVATION_DATE("Upon Order Activation Date");

    private String value;

    RevenueRecognitionTimingEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static RevenueRecognitionTimingEnum fromValue(String value) {
      for (RevenueRecognitionTimingEnum b : RevenueRecognitionTimingEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<RevenueRecognitionTimingEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final RevenueRecognitionTimingEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public RevenueRecognitionTimingEnum read(final JsonReader jsonReader) throws IOException {
        String value =  jsonReader.nextString();
        return RevenueRecognitionTimingEnum.fromValue(value);
      }
    }
  }

  public static final String SERIALIZED_NAME_REVENUE_RECOGNITION_TIMING = "revenueRecognitionTiming";
  @SerializedName(SERIALIZED_NAME_REVENUE_RECOGNITION_TIMING)
  private RevenueRecognitionTimingEnum revenueRecognitionTiming;

  /**
   * Specifies the type of revenue amortization method.  Predefined options are listed as enum values in this API Reference. Other options might also be avaliable depending on the &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Enable_Order_to_Revenue/Configure_revenue_settings/Configure_revenue_recognition_policy\&quot; target&#x3D;\&quot;_blank\&quot;&gt;revenue recognition policy configuration&lt;/a&gt; in the Zuora Billing UI.  You can update this field only for a sales OLI and only when the sales OLI is in the &#x60;Executing&#x60; state (when the &#x60;itemState&#x60; field is set as &#x60;Executing&#x60;).  **Note**: This field is only available if you have the Order to Revenue feature enabled.  
   */
  @JsonAdapter(RevenueAmortizationMethodEnum.Adapter.class)
 public enum RevenueAmortizationMethodEnum {
    IMMEDIATE("Immediate"),
    
    RATABLE_USING_START_AND_END_DATES("Ratable Using Start And End Dates");

    private String value;

    RevenueAmortizationMethodEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static RevenueAmortizationMethodEnum fromValue(String value) {
      for (RevenueAmortizationMethodEnum b : RevenueAmortizationMethodEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<RevenueAmortizationMethodEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final RevenueAmortizationMethodEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public RevenueAmortizationMethodEnum read(final JsonReader jsonReader) throws IOException {
        String value =  jsonReader.nextString();
        return RevenueAmortizationMethodEnum.fromValue(value);
      }
    }
  }

  public static final String SERIALIZED_NAME_REVENUE_AMORTIZATION_METHOD = "revenueAmortizationMethod";
  @SerializedName(SERIALIZED_NAME_REVENUE_AMORTIZATION_METHOD)
  private RevenueAmortizationMethodEnum revenueAmortizationMethod;

  public static final String SERIALIZED_NAME_SEQUENCE_SET_ID = "sequenceSetId";
  @SerializedName(SERIALIZED_NAME_SEQUENCE_SET_ID)
  private String sequenceSetId;

  public static final String SERIALIZED_NAME_SOLD_TO = "soldTo";
  @SerializedName(SERIALIZED_NAME_SOLD_TO)
  private String soldTo;

  public static final String SERIALIZED_NAME_TAX_CODE = "taxCode";
  @SerializedName(SERIALIZED_NAME_TAX_CODE)
  private String taxCode;

  /**
   * The tax mode for the Order Line Item (OLI).  You can update this field only for a sales OLI and only when the sales OLI is in the &#x60;Executing&#x60; state (when the &#x60;itemState&#x60; field is set as &#x60;Executing&#x60;). 
   */
  @JsonAdapter(TaxModeEnum.Adapter.class)
 public enum TaxModeEnum {
    TAXINCLUSIVE("TaxInclusive"),
    
    TAXEXCLUSIVE("TaxExclusive");

    private String value;

    TaxModeEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static TaxModeEnum fromValue(String value) {
      for (TaxModeEnum b : TaxModeEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<TaxModeEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final TaxModeEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public TaxModeEnum read(final JsonReader jsonReader) throws IOException {
        String value =  jsonReader.nextString();
        return TaxModeEnum.fromValue(value);
      }
    }
  }

  public static final String SERIALIZED_NAME_TAX_MODE = "taxMode";
  @SerializedName(SERIALIZED_NAME_TAX_MODE)
  private TaxModeEnum taxMode;

  public static final String SERIALIZED_NAME_TRANSACTION_END_DATE = "transactionEndDate";
  @SerializedName(SERIALIZED_NAME_TRANSACTION_END_DATE)
  private LocalDate transactionEndDate;

  public static final String SERIALIZED_NAME_TRANSACTION_START_DATE = "transactionStartDate";
  @SerializedName(SERIALIZED_NAME_TRANSACTION_START_DATE)
  private LocalDate transactionStartDate;

  public static final String SERIALIZED_NAME_UNBILLED_RECEIVABLES_ACCOUNTING_CODE = "unbilledReceivablesAccountingCode";
  @SerializedName(SERIALIZED_NAME_UNBILLED_RECEIVABLES_ACCOUNTING_CODE)
  private String unbilledReceivablesAccountingCode;

  public PostOrderLineItemUpdateType() {
  }

  public PostOrderLineItemUpdateType id(UUID id) {
    
    
    
    
    this.id = id;
    return this;
  }

   /**
   * The sytem generated Id for the Order Line Item(OLI). Use this field to specify which OLI to update. 
   * @return id
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "The sytem generated Id for the Order Line Item(OLI). Use this field to specify which OLI to update. ")

  public UUID getId() {
    return id;
  }


  public void setId(UUID id) {
    
    
    
    this.id = id;
  }


  public PostOrderLineItemUpdateType description(String description) {
    
    
    
    
    this.description = description;
    return this;
  }

   /**
   * The description of the Order Line Item (OLI).  You can update this field for a sales or return OLI only when the OLI is in the &#x60;Executing&#x60; state (when the &#x60;itemState&#x60; field is set as &#x60;Executing&#x60;). 
   * @return description
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The description of the Order Line Item (OLI).  You can update this field for a sales or return OLI only when the OLI is in the `Executing` state (when the `itemState` field is set as `Executing`). ")

  public String getDescription() {
    return description;
  }


  public void setDescription(String description) {
    
    
    
    this.description = description;
  }


  public PostOrderLineItemUpdateType UOM(String UOM) {
    
    
    
    
    this.UOM = UOM;
    return this;
  }

   /**
   * Specifies the units to measure usage.  You can update this field only for a sales OLI and only when the sales OLI is in the &#x60;Executing&#x60; state (when the &#x60;itemState&#x60; field is set as &#x60;Executing&#x60;). 
   * @return UOM
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Specifies the units to measure usage.  You can update this field only for a sales OLI and only when the sales OLI is in the `Executing` state (when the `itemState` field is set as `Executing`). ")

  public String getUOM() {
    return UOM;
  }


  public void setUOM(String UOM) {
    
    
    
    this.UOM = UOM;
  }


  public PostOrderLineItemUpdateType accountingCode(String accountingCode) {
    
    
    
    
    this.accountingCode = accountingCode;
    return this;
  }

   /**
   * The accountingCode for the Order Line Item (OLI).  You can update this field only for a sales OLI and only when the sales OLI is in the &#x60;Executing&#x60; state (when the &#x60;itemState&#x60; field is set as &#x60;Executing&#x60;). 
   * @return accountingCode
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The accountingCode for the Order Line Item (OLI).  You can update this field only for a sales OLI and only when the sales OLI is in the `Executing` state (when the `itemState` field is set as `Executing`). ")

  public String getAccountingCode() {
    return accountingCode;
  }


  public void setAccountingCode(String accountingCode) {
    
    
    
    this.accountingCode = accountingCode;
  }


  public PostOrderLineItemUpdateType adjustmentLiabilityAccountingCode(String adjustmentLiabilityAccountingCode) {
    
    
    
    
    this.adjustmentLiabilityAccountingCode = adjustmentLiabilityAccountingCode;
    return this;
  }

   /**
   * The accounting code on the Order Line Item object for customers using [Zuora Billing - Revenue Integration](https://knowledgecenter.zuora.com/Zuora_Revenue/Zuora_Billing_-_Revenue_Integration).  You can update this field only for a sales OLI and only when the sales OLI is in the &#x60;Executing&#x60; state (when the &#x60;itemState&#x60; field is set as &#x60;Executing&#x60;). 
   * @return adjustmentLiabilityAccountingCode
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The accounting code on the Order Line Item object for customers using [Zuora Billing - Revenue Integration](https://knowledgecenter.zuora.com/Zuora_Revenue/Zuora_Billing_-_Revenue_Integration).  You can update this field only for a sales OLI and only when the sales OLI is in the `Executing` state (when the `itemState` field is set as `Executing`). ")

  public String getAdjustmentLiabilityAccountingCode() {
    return adjustmentLiabilityAccountingCode;
  }


  public void setAdjustmentLiabilityAccountingCode(String adjustmentLiabilityAccountingCode) {
    
    
    
    this.adjustmentLiabilityAccountingCode = adjustmentLiabilityAccountingCode;
  }


  public PostOrderLineItemUpdateType adjustmentRevenueAccountingCode(String adjustmentRevenueAccountingCode) {
    
    
    
    
    this.adjustmentRevenueAccountingCode = adjustmentRevenueAccountingCode;
    return this;
  }

   /**
   * The accounting code on the Order Line Item object for customers using [Zuora Billing - Revenue Integration](https://knowledgecenter.zuora.com/Zuora_Revenue/Zuora_Billing_-_Revenue_Integration).  You can update this field only for a sales OLI and only when the sales OLI is in the &#x60;Executing&#x60; state (when the &#x60;itemState&#x60; field is set as &#x60;Executing&#x60;). 
   * @return adjustmentRevenueAccountingCode
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The accounting code on the Order Line Item object for customers using [Zuora Billing - Revenue Integration](https://knowledgecenter.zuora.com/Zuora_Revenue/Zuora_Billing_-_Revenue_Integration).  You can update this field only for a sales OLI and only when the sales OLI is in the `Executing` state (when the `itemState` field is set as `Executing`). ")

  public String getAdjustmentRevenueAccountingCode() {
    return adjustmentRevenueAccountingCode;
  }


  public void setAdjustmentRevenueAccountingCode(String adjustmentRevenueAccountingCode) {
    
    
    
    this.adjustmentRevenueAccountingCode = adjustmentRevenueAccountingCode;
  }


  public PostOrderLineItemUpdateType amountPerUnit(Double amountPerUnit) {
    
    
    
    
    this.amountPerUnit = amountPerUnit;
    return this;
  }

  public PostOrderLineItemUpdateType amountPerUnit(Integer amountPerUnit) {
    
    
    
    
    this.amountPerUnit = amountPerUnit.doubleValue();
    return this;
  }

   /**
   * The actual charged amount per unit for the Order Line Item (OLI).  You can update this field only for a sales OLI and only when the sales OLI is in the &#x60;Executing&#x60; state (when the &#x60;itemState&#x60; field is set as &#x60;Executing&#x60;). 
   * @return amountPerUnit
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The actual charged amount per unit for the Order Line Item (OLI).  You can update this field only for a sales OLI and only when the sales OLI is in the `Executing` state (when the `itemState` field is set as `Executing`). ")

  public Double getAmountPerUnit() {
    return amountPerUnit;
  }


  public void setAmountPerUnit(Double amountPerUnit) {
    
    
    
    this.amountPerUnit = amountPerUnit;
  }


  public PostOrderLineItemUpdateType billTargetDate(LocalDate billTargetDate) {
    
    
    
    
    this.billTargetDate = billTargetDate;
    return this;
  }

   /**
   * The target date for the Order Line Item (OLI) to be picked up by bill run for generating billing documents.  To generate billing documents for an OLI, you must set this field and set the &#x60;itemState&#x60; field to &#x60;SentToBilling&#x60;.  You can update this field for a sales or return OLI only when the OLI is in the &#x60;Executing&#x60; state (when the &#x60;itemState&#x60; field is set as &#x60;Executing&#x60;). 
   * @return billTargetDate
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The target date for the Order Line Item (OLI) to be picked up by bill run for generating billing documents.  To generate billing documents for an OLI, you must set this field and set the `itemState` field to `SentToBilling`.  You can update this field for a sales or return OLI only when the OLI is in the `Executing` state (when the `itemState` field is set as `Executing`). ")

  public LocalDate getBillTargetDate() {
    return billTargetDate;
  }


  public void setBillTargetDate(LocalDate billTargetDate) {
    
    
    
    this.billTargetDate = billTargetDate;
  }


  public PostOrderLineItemUpdateType billTo(String billTo) {
    
    
    
    
    this.billTo = billTo;
    return this;
  }

   /**
   * The ID of a contact that belongs to the billing account of the order line item. Use this field to assign an existing account as the bill-to contact of an order line item.  You can update this field only for a sales OLI and only when the sales OLI is in the &#x60;Executing&#x60; state (when the &#x60;itemState&#x60; field is set as &#x60;Executing&#x60;). 
   * @return billTo
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The ID of a contact that belongs to the billing account of the order line item. Use this field to assign an existing account as the bill-to contact of an order line item.  You can update this field only for a sales OLI and only when the sales OLI is in the `Executing` state (when the `itemState` field is set as `Executing`). ")

  public String getBillTo() {
    return billTo;
  }


  public void setBillTo(String billTo) {
    
    
    
    this.billTo = billTo;
  }


  public PostOrderLineItemUpdateType billingRule(BillingRuleEnum billingRule) {
    
    
    
    
    this.billingRule = billingRule;
    return this;
  }

   /**
   * The rule for billing of the Order Line Item (OLI).  You can update this field for a sales or return OLI only when it is in the &#x60;Executing&#x60; state (when the &#x60;itemState&#x60; field is set as &#x60;Executing&#x60;). 
   * @return billingRule
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "TRIGGERWITHOUTFULFILLMENT", value = "The rule for billing of the Order Line Item (OLI).  You can update this field for a sales or return OLI only when it is in the `Executing` state (when the `itemState` field is set as `Executing`). ")

  public BillingRuleEnum getBillingRule() {
    return billingRule;
  }


  public void setBillingRule(BillingRuleEnum billingRule) {
    
    
    
    this.billingRule = billingRule;
  }


  public PostOrderLineItemUpdateType contractAssetAccountingCode(String contractAssetAccountingCode) {
    
    
    
    
    this.contractAssetAccountingCode = contractAssetAccountingCode;
    return this;
  }

   /**
   * The accounting code on the Order Line Item object for customers using [Zuora Billing - Revenue Integration](https://knowledgecenter.zuora.com/Zuora_Revenue/Zuora_Billing_-_Revenue_Integration).  You can update this field only for a sales OLI and only when the sales OLI is in the &#x60;Executing&#x60; state (when the &#x60;itemState&#x60; field is set as &#x60;Executing&#x60;). 
   * @return contractAssetAccountingCode
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The accounting code on the Order Line Item object for customers using [Zuora Billing - Revenue Integration](https://knowledgecenter.zuora.com/Zuora_Revenue/Zuora_Billing_-_Revenue_Integration).  You can update this field only for a sales OLI and only when the sales OLI is in the `Executing` state (when the `itemState` field is set as `Executing`). ")

  public String getContractAssetAccountingCode() {
    return contractAssetAccountingCode;
  }


  public void setContractAssetAccountingCode(String contractAssetAccountingCode) {
    
    
    
    this.contractAssetAccountingCode = contractAssetAccountingCode;
  }


  public PostOrderLineItemUpdateType contractLiabilityAccountingCode(String contractLiabilityAccountingCode) {
    
    
    
    
    this.contractLiabilityAccountingCode = contractLiabilityAccountingCode;
    return this;
  }

   /**
   * The accounting code on the Order Line Item object for customers using [Zuora Billing - Revenue Integration](https://knowledgecenter.zuora.com/Zuora_Revenue/Zuora_Billing_-_Revenue_Integration).  You can update this field only for a sales OLI and only when the sales OLI is in the &#x60;Executing&#x60; state (when the &#x60;itemState&#x60; field is set as &#x60;Executing&#x60;). 
   * @return contractLiabilityAccountingCode
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The accounting code on the Order Line Item object for customers using [Zuora Billing - Revenue Integration](https://knowledgecenter.zuora.com/Zuora_Revenue/Zuora_Billing_-_Revenue_Integration).  You can update this field only for a sales OLI and only when the sales OLI is in the `Executing` state (when the `itemState` field is set as `Executing`). ")

  public String getContractLiabilityAccountingCode() {
    return contractLiabilityAccountingCode;
  }


  public void setContractLiabilityAccountingCode(String contractLiabilityAccountingCode) {
    
    
    
    this.contractLiabilityAccountingCode = contractLiabilityAccountingCode;
  }


  public PostOrderLineItemUpdateType contractRecognizedRevenueAccountingCode(String contractRecognizedRevenueAccountingCode) {
    
    
    
    
    this.contractRecognizedRevenueAccountingCode = contractRecognizedRevenueAccountingCode;
    return this;
  }

   /**
   * The accounting code on the Order Line Item object for customers using [Zuora Billing - Revenue Integration](https://knowledgecenter.zuora.com/Zuora_Revenue/Zuora_Billing_-_Revenue_Integration).  You can update this field only for a sales OLI and only when the sales OLI is in the &#x60;Executing&#x60; state (when the &#x60;itemState&#x60; field is set as &#x60;Executing&#x60;). 
   * @return contractRecognizedRevenueAccountingCode
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The accounting code on the Order Line Item object for customers using [Zuora Billing - Revenue Integration](https://knowledgecenter.zuora.com/Zuora_Revenue/Zuora_Billing_-_Revenue_Integration).  You can update this field only for a sales OLI and only when the sales OLI is in the `Executing` state (when the `itemState` field is set as `Executing`). ")

  public String getContractRecognizedRevenueAccountingCode() {
    return contractRecognizedRevenueAccountingCode;
  }


  public void setContractRecognizedRevenueAccountingCode(String contractRecognizedRevenueAccountingCode) {
    
    
    
    this.contractRecognizedRevenueAccountingCode = contractRecognizedRevenueAccountingCode;
  }


  public PostOrderLineItemUpdateType customFields(Map<String, Object> customFields) {
    
    
    
    
    this.customFields = customFields;
    return this;
  }

  public PostOrderLineItemUpdateType putCustomFieldsItem(String key, Object customFieldsItem) {
    if (this.customFields == null) {
      this.customFields = new HashMap<>();
    }
    this.customFields.put(key, customFieldsItem);
    return this;
  }

   /**
   * Container for custom fields of an Order Line Item object. 
   * @return customFields
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Container for custom fields of an Order Line Item object. ")

  public Map<String, Object> getCustomFields() {
    return customFields;
  }


  public void setCustomFields(Map<String, Object> customFields) {
    
    
    
    this.customFields = customFields;
  }


  public PostOrderLineItemUpdateType deferredRevenueAccountingCode(String deferredRevenueAccountingCode) {
    
    
    
    
    this.deferredRevenueAccountingCode = deferredRevenueAccountingCode;
    return this;
  }

   /**
   * The deferred revenue accounting code for the Order Line Item (OLI).  You can update this field only for a sales OLI and only when the sales OLI is in the &#x60;Executing&#x60; state (when the &#x60;itemState&#x60; field is set as &#x60;Executing&#x60;). 
   * @return deferredRevenueAccountingCode
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The deferred revenue accounting code for the Order Line Item (OLI).  You can update this field only for a sales OLI and only when the sales OLI is in the `Executing` state (when the `itemState` field is set as `Executing`). ")

  public String getDeferredRevenueAccountingCode() {
    return deferredRevenueAccountingCode;
  }


  public void setDeferredRevenueAccountingCode(String deferredRevenueAccountingCode) {
    
    
    
    this.deferredRevenueAccountingCode = deferredRevenueAccountingCode;
  }


  public PostOrderLineItemUpdateType excludeItemBillingFromRevenueAccounting(Boolean excludeItemBillingFromRevenueAccounting) {
    
    
    
    
    this.excludeItemBillingFromRevenueAccounting = excludeItemBillingFromRevenueAccounting;
    return this;
  }

   /**
   * Indicates whether to exclude the related invoice items, invoice item adjustments, credit memo items, and debit memo items from revenue accounting.  **Note**: This field is only available if you have the Order to Revenue or Billing - Revenue Integration feature enabled.  
   * @return excludeItemBillingFromRevenueAccounting
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Indicates whether to exclude the related invoice items, invoice item adjustments, credit memo items, and debit memo items from revenue accounting.  **Note**: This field is only available if you have the Order to Revenue or Billing - Revenue Integration feature enabled.  ")

  public Boolean getExcludeItemBillingFromRevenueAccounting() {
    return excludeItemBillingFromRevenueAccounting;
  }


  public void setExcludeItemBillingFromRevenueAccounting(Boolean excludeItemBillingFromRevenueAccounting) {
    
    
    
    this.excludeItemBillingFromRevenueAccounting = excludeItemBillingFromRevenueAccounting;
  }


  public PostOrderLineItemUpdateType excludeItemBookingFromRevenueAccounting(Boolean excludeItemBookingFromRevenueAccounting) {
    
    
    
    
    this.excludeItemBookingFromRevenueAccounting = excludeItemBookingFromRevenueAccounting;
    return this;
  }

   /**
   * Indicates whether to exclude the related rate plan charges and order line items from revenue accounting.  **Note**: This field is only available if you have the Order to Revenue or Billing - Revenue Integration feature enabled. 
   * @return excludeItemBookingFromRevenueAccounting
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Indicates whether to exclude the related rate plan charges and order line items from revenue accounting.  **Note**: This field is only available if you have the Order to Revenue or Billing - Revenue Integration feature enabled. ")

  public Boolean getExcludeItemBookingFromRevenueAccounting() {
    return excludeItemBookingFromRevenueAccounting;
  }


  public void setExcludeItemBookingFromRevenueAccounting(Boolean excludeItemBookingFromRevenueAccounting) {
    
    
    
    this.excludeItemBookingFromRevenueAccounting = excludeItemBookingFromRevenueAccounting;
  }


  public PostOrderLineItemUpdateType invoiceGroupNumber(String invoiceGroupNumber) {
    
    
    
    
    this.invoiceGroupNumber = invoiceGroupNumber;
    return this;
  }

   /**
   * The number of the invoice group associated with the order line item.  After enabling the Invoice Grouping feature, you can specify invoice group numbers to bill subscriptions and order line items based on specific criteria. For the same account, Zuora generates separate invoices for subscriptions and order line items, each identified by unique invoice group numbers. For more information, see [Invoice Grouping](https://knowledgecenter.zuora.com/Billing/Subscriptions/Invoice_Grouping).  **Note**:    - If you have the &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Bill_your_customers/Bill_customers_at_subscription_level/Flexible_Billing_Attributes\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Flexible Billing Attributes&lt;/a&gt; feature disabled, this field is unavailable in the request body and the value of this field is &#x60;null&#x60; in the response body.    - If you have the Flexible Billing Attributes feature enabled, and you do not specify this field in the request during subscription creation, the value of this field is automatically set to &#x60;null&#x60; in the response body. 
   * @return invoiceGroupNumber
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The number of the invoice group associated with the order line item.  After enabling the Invoice Grouping feature, you can specify invoice group numbers to bill subscriptions and order line items based on specific criteria. For the same account, Zuora generates separate invoices for subscriptions and order line items, each identified by unique invoice group numbers. For more information, see [Invoice Grouping](https://knowledgecenter.zuora.com/Billing/Subscriptions/Invoice_Grouping).  **Note**:    - If you have the <a href=\"https://knowledgecenter.zuora.com/Zuora_Billing/Bill_your_customers/Bill_customers_at_subscription_level/Flexible_Billing_Attributes\" target=\"_blank\">Flexible Billing Attributes</a> feature disabled, this field is unavailable in the request body and the value of this field is `null` in the response body.    - If you have the Flexible Billing Attributes feature enabled, and you do not specify this field in the request during subscription creation, the value of this field is automatically set to `null` in the response body. ")

  public String getInvoiceGroupNumber() {
    return invoiceGroupNumber;
  }


  public void setInvoiceGroupNumber(String invoiceGroupNumber) {
    
    
    
    this.invoiceGroupNumber = invoiceGroupNumber;
  }


  public PostOrderLineItemUpdateType inlineDiscountPerUnit(Double inlineDiscountPerUnit) {
    
    
    
    
    this.inlineDiscountPerUnit = inlineDiscountPerUnit;
    return this;
  }

  public PostOrderLineItemUpdateType inlineDiscountPerUnit(Integer inlineDiscountPerUnit) {
    
    
    
    
    this.inlineDiscountPerUnit = inlineDiscountPerUnit.doubleValue();
    return this;
  }

   /**
   * You can update this field only for a sales OLI and only when the sales OLI is in the &#x60;Executing&#x60; state (when the &#x60;itemState&#x60; field is set as &#x60;Executing&#x60;).  Use this field in accordance with the &#x60;inlineDiscountType&#x60; field, in the following manner: * If the &#x60;inlineDiscountType&#x60; field is set as &#x60;Percentage&#x60;, this field specifies the discount percentage for each unit of the order line item. For exmaple, if you specify &#x60;5&#x60; in this field, the discount percentage is 5%. * If the &#x60;inlineDiscountType&#x60; field is set as &#x60;FixedAmount&#x60;, this field specifies the discount amount on each unit of the order line item. For exmaple, if you specify &#x60;10&#x60; in this field, the discount amount on each unit of the order line item is 10.  Once you set the &#x60;inlineDiscountType&#x60;, &#x60;inlineDiscountPerUnit&#x60;, and &#x60;listPricePerUnit&#x60; fields, the system will automatically generate the &#x60;amountPerUnit&#x60; field. You shall not set the &#x60;amountPerUnit&#x60; field by yourself. 
   * @return inlineDiscountPerUnit
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "You can update this field only for a sales OLI and only when the sales OLI is in the `Executing` state (when the `itemState` field is set as `Executing`).  Use this field in accordance with the `inlineDiscountType` field, in the following manner: * If the `inlineDiscountType` field is set as `Percentage`, this field specifies the discount percentage for each unit of the order line item. For exmaple, if you specify `5` in this field, the discount percentage is 5%. * If the `inlineDiscountType` field is set as `FixedAmount`, this field specifies the discount amount on each unit of the order line item. For exmaple, if you specify `10` in this field, the discount amount on each unit of the order line item is 10.  Once you set the `inlineDiscountType`, `inlineDiscountPerUnit`, and `listPricePerUnit` fields, the system will automatically generate the `amountPerUnit` field. You shall not set the `amountPerUnit` field by yourself. ")

  public Double getInlineDiscountPerUnit() {
    return inlineDiscountPerUnit;
  }


  public void setInlineDiscountPerUnit(Double inlineDiscountPerUnit) {
    
    
    
    this.inlineDiscountPerUnit = inlineDiscountPerUnit;
  }


  public PostOrderLineItemUpdateType inlineDiscountType(InlineDiscountTypeEnum inlineDiscountType) {
    
    
    
    
    this.inlineDiscountType = inlineDiscountType;
    return this;
  }

   /**
   * You can update this field only for a sales OLI and only when the sales OLI is in the &#x60;Executing&#x60; state (when the &#x60;itemState&#x60; field is set as &#x60;Executing&#x60;).  Use this field to specify the inline discount type, which can be &#x60;Percentage&#x60;, &#x60;FixedAmount&#x60;, or &#x60;None&#x60;. The default value is &#x60;Percentage&#x60;.  Use this field together with the &#x60;inlineDiscountPerUnit&#x60; field to specify inline discounts for order line items. The inline discount is applied to the list price of an order line item.   Once you set the &#x60;inlineDiscountType&#x60;, &#x60;inlineDiscountPerUnit&#x60;, and &#x60;listPricePerUnit&#x60; fields, the system will automatically generate the &#x60;amountPerUnit&#x60; field. You shall not set the &#x60;amountPerUnit&#x60; field by yourself. 
   * @return inlineDiscountType
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "You can update this field only for a sales OLI and only when the sales OLI is in the `Executing` state (when the `itemState` field is set as `Executing`).  Use this field to specify the inline discount type, which can be `Percentage`, `FixedAmount`, or `None`. The default value is `Percentage`.  Use this field together with the `inlineDiscountPerUnit` field to specify inline discounts for order line items. The inline discount is applied to the list price of an order line item.   Once you set the `inlineDiscountType`, `inlineDiscountPerUnit`, and `listPricePerUnit` fields, the system will automatically generate the `amountPerUnit` field. You shall not set the `amountPerUnit` field by yourself. ")

  public InlineDiscountTypeEnum getInlineDiscountType() {
    return inlineDiscountType;
  }


  public void setInlineDiscountType(InlineDiscountTypeEnum inlineDiscountType) {
    
    
    
    this.inlineDiscountType = inlineDiscountType;
  }


  public PostOrderLineItemUpdateType isAllocationEligible(Boolean isAllocationEligible) {
    
    
    
    
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


  public PostOrderLineItemUpdateType isUnbilled(Boolean isUnbilled) {
    
    
    
    
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


  public PostOrderLineItemUpdateType itemName(String itemName) {
    
    
    
    
    this.itemName = itemName;
    return this;
  }

   /**
   * The name of the Order Line Item (OLI).  You can update this field for a sales or return OLI only when the OLI is in the &#x60;Executing&#x60; state (when the &#x60;itemState&#x60; field is set as &#x60;Executing&#x60;). 
   * @return itemName
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The name of the Order Line Item (OLI).  You can update this field for a sales or return OLI only when the OLI is in the `Executing` state (when the `itemState` field is set as `Executing`). ")

  public String getItemName() {
    return itemName;
  }


  public void setItemName(String itemName) {
    
    
    
    this.itemName = itemName;
  }


  public PostOrderLineItemUpdateType itemNumber(String itemNumber) {
    
    
    
    
    this.itemNumber = itemNumber;
    return this;
  }

   /**
   * The number for the Order Line Item (OLI).  You can update this field for a sales or return OLI only when the OLI is in the &#x60;Executing&#x60; state (when the &#x60;itemState&#x60; field is set as &#x60;Executing&#x60;). 
   * @return itemNumber
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The number for the Order Line Item (OLI).  You can update this field for a sales or return OLI only when the OLI is in the `Executing` state (when the `itemState` field is set as `Executing`). ")

  public String getItemNumber() {
    return itemNumber;
  }


  public void setItemNumber(String itemNumber) {
    
    
    
    this.itemNumber = itemNumber;
  }


  public PostOrderLineItemUpdateType itemState(ItemStateEnum itemState) {
    
    
    
    
    this.itemState = itemState;
    return this;
  }

   /**
   * The state of the Order Line Item (OLI). See [State transitions for an order, order line item, and fulfillment](https://knowledgecenter.zuora.com/Billing/Subscriptions/Orders/Order_Line_Items/AB_Order_Line_Item_States_and_Order_States) for more information.  To generate invoice for an OLI, you must set this field to &#x60;SentToBilling&#x60; and set the &#x60;billTargetDate&#x60; field .  You can update this field for a sales or return OLI only when the OLI is in the &#x60;Executing&#x60; or &#39;Booked&#39; or &#x60;SentToBilling&#x60;state (when the &#x60;itemState&#x60; field is set as &#x60;Executing&#x60; or &#x60;SentToBilling&#x60;). 
   * @return itemState
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The state of the Order Line Item (OLI). See [State transitions for an order, order line item, and fulfillment](https://knowledgecenter.zuora.com/Billing/Subscriptions/Orders/Order_Line_Items/AB_Order_Line_Item_States_and_Order_States) for more information.  To generate invoice for an OLI, you must set this field to `SentToBilling` and set the `billTargetDate` field .  You can update this field for a sales or return OLI only when the OLI is in the `Executing` or 'Booked' or `SentToBilling`state (when the `itemState` field is set as `Executing` or `SentToBilling`). ")

  public ItemStateEnum getItemState() {
    return itemState;
  }


  public void setItemState(ItemStateEnum itemState) {
    
    
    
    this.itemState = itemState;
  }


  public PostOrderLineItemUpdateType itemType(ItemTypeEnum itemType) {
    
    
    
    
    this.itemType = itemType;
    return this;
  }

   /**
   * The type of the Order Line Item (OLI).   You can update this field only for a sales OLI and only when the sales OLI is in the &#x60;Executing&#x60; state (when the &#x60;itemState&#x60; field is set as &#x60;Executing&#x60;). 
   * @return itemType
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The type of the Order Line Item (OLI).   You can update this field only for a sales OLI and only when the sales OLI is in the `Executing` state (when the `itemState` field is set as `Executing`). ")

  public ItemTypeEnum getItemType() {
    return itemType;
  }


  public void setItemType(ItemTypeEnum itemType) {
    
    
    
    this.itemType = itemType;
  }


  public PostOrderLineItemUpdateType listPricePerUnit(Double listPricePerUnit) {
    
    
    
    
    this.listPricePerUnit = listPricePerUnit;
    return this;
  }

  public PostOrderLineItemUpdateType listPricePerUnit(Integer listPricePerUnit) {
    
    
    
    
    this.listPricePerUnit = listPricePerUnit.doubleValue();
    return this;
  }

   /**
   * The list price per unit for the Order Line Item (OLI).  You can update this field only for a sales OLI and only when the sales OLI is in the &#x60;Executing&#x60; state (when the &#x60;itemState&#x60; field is set as &#x60;Executing&#x60;). 
   * @return listPricePerUnit
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The list price per unit for the Order Line Item (OLI).  You can update this field only for a sales OLI and only when the sales OLI is in the `Executing` state (when the `itemState` field is set as `Executing`). ")

  public Double getListPricePerUnit() {
    return listPricePerUnit;
  }


  public void setListPricePerUnit(Double listPricePerUnit) {
    
    
    
    this.listPricePerUnit = listPricePerUnit;
  }


  public PostOrderLineItemUpdateType ownerAccountNumber(String ownerAccountNumber) {
    
    
    
    
    this.ownerAccountNumber = ownerAccountNumber;
    return this;
  }

   /**
   * Use this field to assign an existing account as the owner of an order line item.  You can update this field only for a sales OLI and only when the sales OLI is in the &#x60;Executing&#x60; state (when the &#x60;itemState&#x60; field is set as &#x60;Executing&#x60;). 
   * @return ownerAccountNumber
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Use this field to assign an existing account as the owner of an order line item.  You can update this field only for a sales OLI and only when the sales OLI is in the `Executing` state (when the `itemState` field is set as `Executing`). ")

  public String getOwnerAccountNumber() {
    return ownerAccountNumber;
  }


  public void setOwnerAccountNumber(String ownerAccountNumber) {
    
    
    
    this.ownerAccountNumber = ownerAccountNumber;
  }


  public PostOrderLineItemUpdateType productCode(String productCode) {
    
    
    
    
    this.productCode = productCode;
    return this;
  }

   /**
   * The product code for the Order Line Item (OLI).  You can update this field only for a sales OLI and only when the sales OLI is in the &#x60;Executing&#x60; state (when the &#x60;itemState&#x60; field is set as &#x60;Executing&#x60;). 
   * @return productCode
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The product code for the Order Line Item (OLI).  You can update this field only for a sales OLI and only when the sales OLI is in the `Executing` state (when the `itemState` field is set as `Executing`). ")

  public String getProductCode() {
    return productCode;
  }


  public void setProductCode(String productCode) {
    
    
    
    this.productCode = productCode;
  }


  public PostOrderLineItemUpdateType purchaseOrderNumber(String purchaseOrderNumber) {
    
    
    
    
    this.purchaseOrderNumber = purchaseOrderNumber;
    return this;
  }

   /**
   * Used by customers to specify the Purchase Order Number provided by the buyer.  You can update this field only for a sales OLI and only when the sales OLI is in the &#x60;Executing&#x60; state (when the &#x60;itemState&#x60; field is set as &#x60;Executing&#x60;). 
   * @return purchaseOrderNumber
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Used by customers to specify the Purchase Order Number provided by the buyer.  You can update this field only for a sales OLI and only when the sales OLI is in the `Executing` state (when the `itemState` field is set as `Executing`). ")

  public String getPurchaseOrderNumber() {
    return purchaseOrderNumber;
  }


  public void setPurchaseOrderNumber(String purchaseOrderNumber) {
    
    
    
    this.purchaseOrderNumber = purchaseOrderNumber;
  }


  public PostOrderLineItemUpdateType quantity(Double quantity) {
    
    
    
    
    this.quantity = quantity;
    return this;
  }

  public PostOrderLineItemUpdateType quantity(Integer quantity) {
    
    
    
    
    this.quantity = quantity.doubleValue();
    return this;
  }

   /**
   * The quantity of units, such as the number of authors in a hosted wiki service.  You can update this field for a sales or return OLI only when the OLI in the &#x60;Executing&#x60; state (when the &#x60;itemState&#x60; field is set as &#x60;Executing&#x60;). 
   * @return quantity
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The quantity of units, such as the number of authors in a hosted wiki service.  You can update this field for a sales or return OLI only when the OLI in the `Executing` state (when the `itemState` field is set as `Executing`). ")

  public Double getQuantity() {
    return quantity;
  }


  public void setQuantity(Double quantity) {
    
    
    
    this.quantity = quantity;
  }


  public PostOrderLineItemUpdateType recognizedRevenueAccountingCode(String recognizedRevenueAccountingCode) {
    
    
    
    
    this.recognizedRevenueAccountingCode = recognizedRevenueAccountingCode;
    return this;
  }

   /**
   * The recognized revenue accounting code for the Order Line Item (OLI).  You can update this field only for a sales OLI and only when the sales OLI is in the &#x60;Executing&#x60; state (when the &#x60;itemState&#x60; field is set as &#x60;Executing&#x60;). 
   * @return recognizedRevenueAccountingCode
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The recognized revenue accounting code for the Order Line Item (OLI).  You can update this field only for a sales OLI and only when the sales OLI is in the `Executing` state (when the `itemState` field is set as `Executing`). ")

  public String getRecognizedRevenueAccountingCode() {
    return recognizedRevenueAccountingCode;
  }


  public void setRecognizedRevenueAccountingCode(String recognizedRevenueAccountingCode) {
    
    
    
    this.recognizedRevenueAccountingCode = recognizedRevenueAccountingCode;
  }


  public PostOrderLineItemUpdateType relatedSubscriptionNumber(String relatedSubscriptionNumber) {
    
    
    
    
    this.relatedSubscriptionNumber = relatedSubscriptionNumber;
    return this;
  }

   /**
   * Use this field to relate an order line item to an subscription. Specify this field to the subscription number of the subscription to relate.  You can update this field only for a sales OLI and only when the sales OLI is in the &#x60;Executing&#x60; state (when the &#x60;itemState&#x60; field is set as &#x60;Executing&#x60;). 
   * @return relatedSubscriptionNumber
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Use this field to relate an order line item to an subscription. Specify this field to the subscription number of the subscription to relate.  You can update this field only for a sales OLI and only when the sales OLI is in the `Executing` state (when the `itemState` field is set as `Executing`). ")

  public String getRelatedSubscriptionNumber() {
    return relatedSubscriptionNumber;
  }


  public void setRelatedSubscriptionNumber(String relatedSubscriptionNumber) {
    
    
    
    this.relatedSubscriptionNumber = relatedSubscriptionNumber;
  }


  public PostOrderLineItemUpdateType revenueRecognitionRule(String revenueRecognitionRule) {
    
    
    
    
    this.revenueRecognitionRule = revenueRecognitionRule;
    return this;
  }

   /**
   * The Revenue Recognition rule for the Order Line Item (OLI).  You can update this field only for a sales OLI and only when the sales OLI is in the &#x60;Executing&#x60; state (when the &#x60;itemState&#x60; field is set as &#x60;Executing&#x60;). 
   * @return revenueRecognitionRule
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The Revenue Recognition rule for the Order Line Item (OLI).  You can update this field only for a sales OLI and only when the sales OLI is in the `Executing` state (when the `itemState` field is set as `Executing`). ")

  public String getRevenueRecognitionRule() {
    return revenueRecognitionRule;
  }


  public void setRevenueRecognitionRule(String revenueRecognitionRule) {
    
    
    
    this.revenueRecognitionRule = revenueRecognitionRule;
  }


  public PostOrderLineItemUpdateType revenueRecognitionTiming(RevenueRecognitionTimingEnum revenueRecognitionTiming) {
    
    
    
    
    this.revenueRecognitionTiming = revenueRecognitionTiming;
    return this;
  }

   /**
   * Specifies the type of revenue recognition timing.  Predefined options are listed as enum values in this API Reference. Other options might also be avaliable depending on the &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Enable_Order_to_Revenue/Configure_revenue_settings/Configure_revenue_recognition_policy\&quot; target&#x3D;\&quot;_blank\&quot;&gt;revenue recognition policy configuration&lt;/a&gt; in the Zuora Billing UI.  You can update this field only for a sales OLI and only when the sales OLI is in the &#x60;Executing&#x60; state (when the &#x60;itemState&#x60; field is set as &#x60;Executing&#x60;).  **Note**: This field is only available if you have the Order to Revenue feature enabled.  
   * @return revenueRecognitionTiming
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Specifies the type of revenue recognition timing.  Predefined options are listed as enum values in this API Reference. Other options might also be avaliable depending on the <a href=\"https://knowledgecenter.zuora.com/Zuora_Billing/Enable_Order_to_Revenue/Configure_revenue_settings/Configure_revenue_recognition_policy\" target=\"_blank\">revenue recognition policy configuration</a> in the Zuora Billing UI.  You can update this field only for a sales OLI and only when the sales OLI is in the `Executing` state (when the `itemState` field is set as `Executing`).  **Note**: This field is only available if you have the Order to Revenue feature enabled.  ")

  public RevenueRecognitionTimingEnum getRevenueRecognitionTiming() {
    return revenueRecognitionTiming;
  }


  public void setRevenueRecognitionTiming(RevenueRecognitionTimingEnum revenueRecognitionTiming) {
    
    
    
    this.revenueRecognitionTiming = revenueRecognitionTiming;
  }


  public PostOrderLineItemUpdateType revenueAmortizationMethod(RevenueAmortizationMethodEnum revenueAmortizationMethod) {
    
    
    
    
    this.revenueAmortizationMethod = revenueAmortizationMethod;
    return this;
  }

   /**
   * Specifies the type of revenue amortization method.  Predefined options are listed as enum values in this API Reference. Other options might also be avaliable depending on the &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Enable_Order_to_Revenue/Configure_revenue_settings/Configure_revenue_recognition_policy\&quot; target&#x3D;\&quot;_blank\&quot;&gt;revenue recognition policy configuration&lt;/a&gt; in the Zuora Billing UI.  You can update this field only for a sales OLI and only when the sales OLI is in the &#x60;Executing&#x60; state (when the &#x60;itemState&#x60; field is set as &#x60;Executing&#x60;).  **Note**: This field is only available if you have the Order to Revenue feature enabled.  
   * @return revenueAmortizationMethod
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Specifies the type of revenue amortization method.  Predefined options are listed as enum values in this API Reference. Other options might also be avaliable depending on the <a href=\"https://knowledgecenter.zuora.com/Zuora_Billing/Enable_Order_to_Revenue/Configure_revenue_settings/Configure_revenue_recognition_policy\" target=\"_blank\">revenue recognition policy configuration</a> in the Zuora Billing UI.  You can update this field only for a sales OLI and only when the sales OLI is in the `Executing` state (when the `itemState` field is set as `Executing`).  **Note**: This field is only available if you have the Order to Revenue feature enabled.  ")

  public RevenueAmortizationMethodEnum getRevenueAmortizationMethod() {
    return revenueAmortizationMethod;
  }


  public void setRevenueAmortizationMethod(RevenueAmortizationMethodEnum revenueAmortizationMethod) {
    
    
    
    this.revenueAmortizationMethod = revenueAmortizationMethod;
  }


  public PostOrderLineItemUpdateType sequenceSetId(String sequenceSetId) {
    
    
    
    
    this.sequenceSetId = sequenceSetId;
    return this;
  }

   /**
   * The ID of the sequence set associated with the orderLineItem. 
   * @return sequenceSetId
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The ID of the sequence set associated with the orderLineItem. ")

  public String getSequenceSetId() {
    return sequenceSetId;
  }


  public void setSequenceSetId(String sequenceSetId) {
    
    
    
    this.sequenceSetId = sequenceSetId;
  }


  public PostOrderLineItemUpdateType soldTo(String soldTo) {
    
    
    
    
    this.soldTo = soldTo;
    return this;
  }

   /**
   * Use this field to assign an existing account as the sold-to contact of an order line item, by the following rules:  * If the &#x60;ownerAccountNumber&#x60; field is set, then this field must be the ID of a contact that belongs to the owner account of the order line item.  * If the &#x60;ownerAccountNumber&#x60; field is not set, then this field must be the ID of a contact that belongs to the billing account of the order line item.  You can update this field only for a sales OLI and only when the sales OLI is in the &#x60;Executing&#x60; state (when the &#x60;itemState&#x60; field is set as &#x60;Executing&#x60;). 
   * @return soldTo
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Use this field to assign an existing account as the sold-to contact of an order line item, by the following rules:  * If the `ownerAccountNumber` field is set, then this field must be the ID of a contact that belongs to the owner account of the order line item.  * If the `ownerAccountNumber` field is not set, then this field must be the ID of a contact that belongs to the billing account of the order line item.  You can update this field only for a sales OLI and only when the sales OLI is in the `Executing` state (when the `itemState` field is set as `Executing`). ")

  public String getSoldTo() {
    return soldTo;
  }


  public void setSoldTo(String soldTo) {
    
    
    
    this.soldTo = soldTo;
  }


  public PostOrderLineItemUpdateType taxCode(String taxCode) {
    
    
    
    
    this.taxCode = taxCode;
    return this;
  }

   /**
   * The tax code for the Order Line Item (OLI).  You can update this field only for a sales OLI and only when the sales OLI is in the &#x60;Executing&#x60; state (when the &#x60;itemState&#x60; field is set as &#x60;Executing&#x60;). 
   * @return taxCode
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The tax code for the Order Line Item (OLI).  You can update this field only for a sales OLI and only when the sales OLI is in the `Executing` state (when the `itemState` field is set as `Executing`). ")

  public String getTaxCode() {
    return taxCode;
  }


  public void setTaxCode(String taxCode) {
    
    
    
    this.taxCode = taxCode;
  }


  public PostOrderLineItemUpdateType taxMode(TaxModeEnum taxMode) {
    
    
    
    
    this.taxMode = taxMode;
    return this;
  }

   /**
   * The tax mode for the Order Line Item (OLI).  You can update this field only for a sales OLI and only when the sales OLI is in the &#x60;Executing&#x60; state (when the &#x60;itemState&#x60; field is set as &#x60;Executing&#x60;). 
   * @return taxMode
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The tax mode for the Order Line Item (OLI).  You can update this field only for a sales OLI and only when the sales OLI is in the `Executing` state (when the `itemState` field is set as `Executing`). ")

  public TaxModeEnum getTaxMode() {
    return taxMode;
  }


  public void setTaxMode(TaxModeEnum taxMode) {
    
    
    
    this.taxMode = taxMode;
  }


  public PostOrderLineItemUpdateType transactionEndDate(LocalDate transactionEndDate) {
    
    
    
    
    this.transactionEndDate = transactionEndDate;
    return this;
  }

   /**
   * The date a transaction is completed. The default value of this field is the transaction start date. Also, the value of this field should always equal or be later than the value of the &#x60;transactionStartDate&#x60; field.  You can update this field for a sales or return OLI only when the OLI is in the &#x60;Executing&#x60; state (when the &#x60;itemState&#x60; field is set as &#x60;Executing&#x60;). 
   * @return transactionEndDate
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The date a transaction is completed. The default value of this field is the transaction start date. Also, the value of this field should always equal or be later than the value of the `transactionStartDate` field.  You can update this field for a sales or return OLI only when the OLI is in the `Executing` state (when the `itemState` field is set as `Executing`). ")

  public LocalDate getTransactionEndDate() {
    return transactionEndDate;
  }


  public void setTransactionEndDate(LocalDate transactionEndDate) {
    
    
    
    this.transactionEndDate = transactionEndDate;
  }


  public PostOrderLineItemUpdateType transactionStartDate(LocalDate transactionStartDate) {
    
    
    
    
    this.transactionStartDate = transactionStartDate;
    return this;
  }

   /**
   * The date a transaction starts. The default value of this field is the order date.  You can update this field for a sales or return OLI only when the OLI is in the &#x60;Executing&#x60; state (when the &#x60;itemState&#x60; field is set as &#x60;Executing&#x60;). 
   * @return transactionStartDate
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The date a transaction starts. The default value of this field is the order date.  You can update this field for a sales or return OLI only when the OLI is in the `Executing` state (when the `itemState` field is set as `Executing`). ")

  public LocalDate getTransactionStartDate() {
    return transactionStartDate;
  }


  public void setTransactionStartDate(LocalDate transactionStartDate) {
    
    
    
    this.transactionStartDate = transactionStartDate;
  }


  public PostOrderLineItemUpdateType unbilledReceivablesAccountingCode(String unbilledReceivablesAccountingCode) {
    
    
    
    
    this.unbilledReceivablesAccountingCode = unbilledReceivablesAccountingCode;
    return this;
  }

   /**
   * The accounting code on the Order Line Item object for customers using [Zuora Billing - Revenue Integration](https://knowledgecenter.zuora.com/Zuora_Revenue/Zuora_Billing_-_Revenue_Integration).  You can update this field only for a sales OLI and only when the sales OLI is in the &#x60;Executing&#x60; state (when the &#x60;itemState&#x60; field is set as &#x60;Executing&#x60;). 
   * @return unbilledReceivablesAccountingCode
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The accounting code on the Order Line Item object for customers using [Zuora Billing - Revenue Integration](https://knowledgecenter.zuora.com/Zuora_Revenue/Zuora_Billing_-_Revenue_Integration).  You can update this field only for a sales OLI and only when the sales OLI is in the `Executing` state (when the `itemState` field is set as `Executing`). ")

  public String getUnbilledReceivablesAccountingCode() {
    return unbilledReceivablesAccountingCode;
  }


  public void setUnbilledReceivablesAccountingCode(String unbilledReceivablesAccountingCode) {
    
    
    
    this.unbilledReceivablesAccountingCode = unbilledReceivablesAccountingCode;
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
   * @return the PostOrderLineItemUpdateType instance itself
   */
  public PostOrderLineItemUpdateType putAdditionalProperty(String key, Object value) {
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
    PostOrderLineItemUpdateType postOrderLineItemUpdateType = (PostOrderLineItemUpdateType) o;
    return Objects.equals(this.id, postOrderLineItemUpdateType.id) &&
        Objects.equals(this.description, postOrderLineItemUpdateType.description) &&
        Objects.equals(this.UOM, postOrderLineItemUpdateType.UOM) &&
        Objects.equals(this.accountingCode, postOrderLineItemUpdateType.accountingCode) &&
        Objects.equals(this.adjustmentLiabilityAccountingCode, postOrderLineItemUpdateType.adjustmentLiabilityAccountingCode) &&
        Objects.equals(this.adjustmentRevenueAccountingCode, postOrderLineItemUpdateType.adjustmentRevenueAccountingCode) &&
        Objects.equals(this.amountPerUnit, postOrderLineItemUpdateType.amountPerUnit) &&
        Objects.equals(this.billTargetDate, postOrderLineItemUpdateType.billTargetDate) &&
        Objects.equals(this.billTo, postOrderLineItemUpdateType.billTo) &&
        Objects.equals(this.billingRule, postOrderLineItemUpdateType.billingRule) &&
        Objects.equals(this.contractAssetAccountingCode, postOrderLineItemUpdateType.contractAssetAccountingCode) &&
        Objects.equals(this.contractLiabilityAccountingCode, postOrderLineItemUpdateType.contractLiabilityAccountingCode) &&
        Objects.equals(this.contractRecognizedRevenueAccountingCode, postOrderLineItemUpdateType.contractRecognizedRevenueAccountingCode) &&
        Objects.equals(this.customFields, postOrderLineItemUpdateType.customFields) &&
        Objects.equals(this.deferredRevenueAccountingCode, postOrderLineItemUpdateType.deferredRevenueAccountingCode) &&
        Objects.equals(this.excludeItemBillingFromRevenueAccounting, postOrderLineItemUpdateType.excludeItemBillingFromRevenueAccounting) &&
        Objects.equals(this.excludeItemBookingFromRevenueAccounting, postOrderLineItemUpdateType.excludeItemBookingFromRevenueAccounting) &&
        Objects.equals(this.invoiceGroupNumber, postOrderLineItemUpdateType.invoiceGroupNumber) &&
        Objects.equals(this.inlineDiscountPerUnit, postOrderLineItemUpdateType.inlineDiscountPerUnit) &&
        Objects.equals(this.inlineDiscountType, postOrderLineItemUpdateType.inlineDiscountType) &&
        Objects.equals(this.isAllocationEligible, postOrderLineItemUpdateType.isAllocationEligible) &&
        Objects.equals(this.isUnbilled, postOrderLineItemUpdateType.isUnbilled) &&
        Objects.equals(this.itemName, postOrderLineItemUpdateType.itemName) &&
        Objects.equals(this.itemNumber, postOrderLineItemUpdateType.itemNumber) &&
        Objects.equals(this.itemState, postOrderLineItemUpdateType.itemState) &&
        Objects.equals(this.itemType, postOrderLineItemUpdateType.itemType) &&
        Objects.equals(this.listPricePerUnit, postOrderLineItemUpdateType.listPricePerUnit) &&
        Objects.equals(this.ownerAccountNumber, postOrderLineItemUpdateType.ownerAccountNumber) &&
        Objects.equals(this.productCode, postOrderLineItemUpdateType.productCode) &&
        Objects.equals(this.purchaseOrderNumber, postOrderLineItemUpdateType.purchaseOrderNumber) &&
        Objects.equals(this.quantity, postOrderLineItemUpdateType.quantity) &&
        Objects.equals(this.recognizedRevenueAccountingCode, postOrderLineItemUpdateType.recognizedRevenueAccountingCode) &&
        Objects.equals(this.relatedSubscriptionNumber, postOrderLineItemUpdateType.relatedSubscriptionNumber) &&
        Objects.equals(this.revenueRecognitionRule, postOrderLineItemUpdateType.revenueRecognitionRule) &&
        Objects.equals(this.revenueRecognitionTiming, postOrderLineItemUpdateType.revenueRecognitionTiming) &&
        Objects.equals(this.revenueAmortizationMethod, postOrderLineItemUpdateType.revenueAmortizationMethod) &&
        Objects.equals(this.sequenceSetId, postOrderLineItemUpdateType.sequenceSetId) &&
        Objects.equals(this.soldTo, postOrderLineItemUpdateType.soldTo) &&
        Objects.equals(this.taxCode, postOrderLineItemUpdateType.taxCode) &&
        Objects.equals(this.taxMode, postOrderLineItemUpdateType.taxMode) &&
        Objects.equals(this.transactionEndDate, postOrderLineItemUpdateType.transactionEndDate) &&
        Objects.equals(this.transactionStartDate, postOrderLineItemUpdateType.transactionStartDate) &&
        Objects.equals(this.unbilledReceivablesAccountingCode, postOrderLineItemUpdateType.unbilledReceivablesAccountingCode)&&
        Objects.equals(this.additionalProperties, postOrderLineItemUpdateType.additionalProperties);
  }

  private static <T> boolean equalsNullable(JsonNullable<T> a, JsonNullable<T> b) {
    return a == b || (a != null && b != null && a.isPresent() && b.isPresent() && Objects.deepEquals(a.get(), b.get()));
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, description, UOM, accountingCode, adjustmentLiabilityAccountingCode, adjustmentRevenueAccountingCode, amountPerUnit, billTargetDate, billTo, billingRule, contractAssetAccountingCode, contractLiabilityAccountingCode, contractRecognizedRevenueAccountingCode, customFields, deferredRevenueAccountingCode, excludeItemBillingFromRevenueAccounting, excludeItemBookingFromRevenueAccounting, invoiceGroupNumber, inlineDiscountPerUnit, inlineDiscountType, isAllocationEligible, isUnbilled, itemName, itemNumber, itemState, itemType, listPricePerUnit, ownerAccountNumber, productCode, purchaseOrderNumber, quantity, recognizedRevenueAccountingCode, relatedSubscriptionNumber, revenueRecognitionRule, revenueRecognitionTiming, revenueAmortizationMethod, sequenceSetId, soldTo, taxCode, taxMode, transactionEndDate, transactionStartDate, unbilledReceivablesAccountingCode, additionalProperties);
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
    sb.append("class PostOrderLineItemUpdateType {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    UOM: ").append(toIndentedString(UOM)).append("\n");
    sb.append("    accountingCode: ").append(toIndentedString(accountingCode)).append("\n");
    sb.append("    adjustmentLiabilityAccountingCode: ").append(toIndentedString(adjustmentLiabilityAccountingCode)).append("\n");
    sb.append("    adjustmentRevenueAccountingCode: ").append(toIndentedString(adjustmentRevenueAccountingCode)).append("\n");
    sb.append("    amountPerUnit: ").append(toIndentedString(amountPerUnit)).append("\n");
    sb.append("    billTargetDate: ").append(toIndentedString(billTargetDate)).append("\n");
    sb.append("    billTo: ").append(toIndentedString(billTo)).append("\n");
    sb.append("    billingRule: ").append(toIndentedString(billingRule)).append("\n");
    sb.append("    contractAssetAccountingCode: ").append(toIndentedString(contractAssetAccountingCode)).append("\n");
    sb.append("    contractLiabilityAccountingCode: ").append(toIndentedString(contractLiabilityAccountingCode)).append("\n");
    sb.append("    contractRecognizedRevenueAccountingCode: ").append(toIndentedString(contractRecognizedRevenueAccountingCode)).append("\n");
    sb.append("    customFields: ").append(toIndentedString(customFields)).append("\n");
    sb.append("    deferredRevenueAccountingCode: ").append(toIndentedString(deferredRevenueAccountingCode)).append("\n");
    sb.append("    excludeItemBillingFromRevenueAccounting: ").append(toIndentedString(excludeItemBillingFromRevenueAccounting)).append("\n");
    sb.append("    excludeItemBookingFromRevenueAccounting: ").append(toIndentedString(excludeItemBookingFromRevenueAccounting)).append("\n");
    sb.append("    invoiceGroupNumber: ").append(toIndentedString(invoiceGroupNumber)).append("\n");
    sb.append("    inlineDiscountPerUnit: ").append(toIndentedString(inlineDiscountPerUnit)).append("\n");
    sb.append("    inlineDiscountType: ").append(toIndentedString(inlineDiscountType)).append("\n");
    sb.append("    isAllocationEligible: ").append(toIndentedString(isAllocationEligible)).append("\n");
    sb.append("    isUnbilled: ").append(toIndentedString(isUnbilled)).append("\n");
    sb.append("    itemName: ").append(toIndentedString(itemName)).append("\n");
    sb.append("    itemNumber: ").append(toIndentedString(itemNumber)).append("\n");
    sb.append("    itemState: ").append(toIndentedString(itemState)).append("\n");
    sb.append("    itemType: ").append(toIndentedString(itemType)).append("\n");
    sb.append("    listPricePerUnit: ").append(toIndentedString(listPricePerUnit)).append("\n");
    sb.append("    ownerAccountNumber: ").append(toIndentedString(ownerAccountNumber)).append("\n");
    sb.append("    productCode: ").append(toIndentedString(productCode)).append("\n");
    sb.append("    purchaseOrderNumber: ").append(toIndentedString(purchaseOrderNumber)).append("\n");
    sb.append("    quantity: ").append(toIndentedString(quantity)).append("\n");
    sb.append("    recognizedRevenueAccountingCode: ").append(toIndentedString(recognizedRevenueAccountingCode)).append("\n");
    sb.append("    relatedSubscriptionNumber: ").append(toIndentedString(relatedSubscriptionNumber)).append("\n");
    sb.append("    revenueRecognitionRule: ").append(toIndentedString(revenueRecognitionRule)).append("\n");
    sb.append("    revenueRecognitionTiming: ").append(toIndentedString(revenueRecognitionTiming)).append("\n");
    sb.append("    revenueAmortizationMethod: ").append(toIndentedString(revenueAmortizationMethod)).append("\n");
    sb.append("    sequenceSetId: ").append(toIndentedString(sequenceSetId)).append("\n");
    sb.append("    soldTo: ").append(toIndentedString(soldTo)).append("\n");
    sb.append("    taxCode: ").append(toIndentedString(taxCode)).append("\n");
    sb.append("    taxMode: ").append(toIndentedString(taxMode)).append("\n");
    sb.append("    transactionEndDate: ").append(toIndentedString(transactionEndDate)).append("\n");
    sb.append("    transactionStartDate: ").append(toIndentedString(transactionStartDate)).append("\n");
    sb.append("    unbilledReceivablesAccountingCode: ").append(toIndentedString(unbilledReceivablesAccountingCode)).append("\n");
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
    openapiFields.add("id");
    openapiFields.add("description");
    openapiFields.add("UOM");
    openapiFields.add("accountingCode");
    openapiFields.add("adjustmentLiabilityAccountingCode");
    openapiFields.add("adjustmentRevenueAccountingCode");
    openapiFields.add("amountPerUnit");
    openapiFields.add("billTargetDate");
    openapiFields.add("billTo");
    openapiFields.add("billingRule");
    openapiFields.add("contractAssetAccountingCode");
    openapiFields.add("contractLiabilityAccountingCode");
    openapiFields.add("contractRecognizedRevenueAccountingCode");
    openapiFields.add("customFields");
    openapiFields.add("deferredRevenueAccountingCode");
    openapiFields.add("excludeItemBillingFromRevenueAccounting");
    openapiFields.add("excludeItemBookingFromRevenueAccounting");
    openapiFields.add("invoiceGroupNumber");
    openapiFields.add("inlineDiscountPerUnit");
    openapiFields.add("inlineDiscountType");
    openapiFields.add("isAllocationEligible");
    openapiFields.add("isUnbilled");
    openapiFields.add("itemName");
    openapiFields.add("itemNumber");
    openapiFields.add("itemState");
    openapiFields.add("itemType");
    openapiFields.add("listPricePerUnit");
    openapiFields.add("ownerAccountNumber");
    openapiFields.add("productCode");
    openapiFields.add("purchaseOrderNumber");
    openapiFields.add("quantity");
    openapiFields.add("recognizedRevenueAccountingCode");
    openapiFields.add("relatedSubscriptionNumber");
    openapiFields.add("revenueRecognitionRule");
    openapiFields.add("revenueRecognitionTiming");
    openapiFields.add("revenueAmortizationMethod");
    openapiFields.add("sequenceSetId");
    openapiFields.add("soldTo");
    openapiFields.add("taxCode");
    openapiFields.add("taxMode");
    openapiFields.add("transactionEndDate");
    openapiFields.add("transactionStartDate");
    openapiFields.add("unbilledReceivablesAccountingCode");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
    openapiRequiredFields.add("id");
  }

 /**
  * Validates the JSON Object and throws an exception if issues found
  *
  * @param jsonObj JSON Object
  * @throws IOException if the JSON Object is invalid with respect to PostOrderLineItemUpdateType
  */
  public static void validateJsonObject(JsonObject jsonObj) throws IOException {
      if (jsonObj == null) {
        if (!PostOrderLineItemUpdateType.openapiRequiredFields.isEmpty()) { // has required fields but JSON object is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in PostOrderLineItemUpdateType is not found in the empty JSON string", PostOrderLineItemUpdateType.openapiRequiredFields.toString()));
        }
      }

      // check to make sure all required properties/fields are present in the JSON string
      for (String requiredField : PostOrderLineItemUpdateType.openapiRequiredFields) {
        if (jsonObj.get(requiredField) == null) {
          throw new IllegalArgumentException(String.format("The required field `%s` is not found in the JSON string: %s", requiredField, jsonObj.toString()));
        }
      }
      if (!jsonObj.get("id").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `id` to be a primitive type in the JSON string but got `%s`", jsonObj.get("id").toString()));
      }
      if ((jsonObj.get("description") != null && !jsonObj.get("description").isJsonNull()) && !jsonObj.get("description").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `description` to be a primitive type in the JSON string but got `%s`", jsonObj.get("description").toString()));
      }
      if ((jsonObj.get("UOM") != null && !jsonObj.get("UOM").isJsonNull()) && !jsonObj.get("UOM").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `UOM` to be a primitive type in the JSON string but got `%s`", jsonObj.get("UOM").toString()));
      }
      if ((jsonObj.get("accountingCode") != null && !jsonObj.get("accountingCode").isJsonNull()) && !jsonObj.get("accountingCode").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `accountingCode` to be a primitive type in the JSON string but got `%s`", jsonObj.get("accountingCode").toString()));
      }
      if ((jsonObj.get("adjustmentLiabilityAccountingCode") != null && !jsonObj.get("adjustmentLiabilityAccountingCode").isJsonNull()) && !jsonObj.get("adjustmentLiabilityAccountingCode").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `adjustmentLiabilityAccountingCode` to be a primitive type in the JSON string but got `%s`", jsonObj.get("adjustmentLiabilityAccountingCode").toString()));
      }
      if ((jsonObj.get("adjustmentRevenueAccountingCode") != null && !jsonObj.get("adjustmentRevenueAccountingCode").isJsonNull()) && !jsonObj.get("adjustmentRevenueAccountingCode").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `adjustmentRevenueAccountingCode` to be a primitive type in the JSON string but got `%s`", jsonObj.get("adjustmentRevenueAccountingCode").toString()));
      }
      if ((jsonObj.get("billTo") != null && !jsonObj.get("billTo").isJsonNull()) && !jsonObj.get("billTo").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `billTo` to be a primitive type in the JSON string but got `%s`", jsonObj.get("billTo").toString()));
      }
      if ((jsonObj.get("billingRule") != null && !jsonObj.get("billingRule").isJsonNull()) && !jsonObj.get("billingRule").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `billingRule` to be a primitive type in the JSON string but got `%s`", jsonObj.get("billingRule").toString()));
      }
      if ((jsonObj.get("contractAssetAccountingCode") != null && !jsonObj.get("contractAssetAccountingCode").isJsonNull()) && !jsonObj.get("contractAssetAccountingCode").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `contractAssetAccountingCode` to be a primitive type in the JSON string but got `%s`", jsonObj.get("contractAssetAccountingCode").toString()));
      }
      if ((jsonObj.get("contractLiabilityAccountingCode") != null && !jsonObj.get("contractLiabilityAccountingCode").isJsonNull()) && !jsonObj.get("contractLiabilityAccountingCode").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `contractLiabilityAccountingCode` to be a primitive type in the JSON string but got `%s`", jsonObj.get("contractLiabilityAccountingCode").toString()));
      }
      if ((jsonObj.get("contractRecognizedRevenueAccountingCode") != null && !jsonObj.get("contractRecognizedRevenueAccountingCode").isJsonNull()) && !jsonObj.get("contractRecognizedRevenueAccountingCode").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `contractRecognizedRevenueAccountingCode` to be a primitive type in the JSON string but got `%s`", jsonObj.get("contractRecognizedRevenueAccountingCode").toString()));
      }
      if ((jsonObj.get("deferredRevenueAccountingCode") != null && !jsonObj.get("deferredRevenueAccountingCode").isJsonNull()) && !jsonObj.get("deferredRevenueAccountingCode").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `deferredRevenueAccountingCode` to be a primitive type in the JSON string but got `%s`", jsonObj.get("deferredRevenueAccountingCode").toString()));
      }
      if (!jsonObj.get("invoiceGroupNumber").isJsonNull() && (jsonObj.get("invoiceGroupNumber") != null && !jsonObj.get("invoiceGroupNumber").isJsonNull()) && !jsonObj.get("invoiceGroupNumber").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `invoiceGroupNumber` to be a primitive type in the JSON string but got `%s`", jsonObj.get("invoiceGroupNumber").toString()));
      }
      if ((jsonObj.get("inlineDiscountType") != null && !jsonObj.get("inlineDiscountType").isJsonNull()) && !jsonObj.get("inlineDiscountType").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `inlineDiscountType` to be a primitive type in the JSON string but got `%s`", jsonObj.get("inlineDiscountType").toString()));
      }
      if ((jsonObj.get("itemName") != null && !jsonObj.get("itemName").isJsonNull()) && !jsonObj.get("itemName").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `itemName` to be a primitive type in the JSON string but got `%s`", jsonObj.get("itemName").toString()));
      }
      if ((jsonObj.get("itemNumber") != null && !jsonObj.get("itemNumber").isJsonNull()) && !jsonObj.get("itemNumber").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `itemNumber` to be a primitive type in the JSON string but got `%s`", jsonObj.get("itemNumber").toString()));
      }
      if ((jsonObj.get("itemState") != null && !jsonObj.get("itemState").isJsonNull()) && !jsonObj.get("itemState").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `itemState` to be a primitive type in the JSON string but got `%s`", jsonObj.get("itemState").toString()));
      }
      if ((jsonObj.get("itemType") != null && !jsonObj.get("itemType").isJsonNull()) && !jsonObj.get("itemType").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `itemType` to be a primitive type in the JSON string but got `%s`", jsonObj.get("itemType").toString()));
      }
      if ((jsonObj.get("ownerAccountNumber") != null && !jsonObj.get("ownerAccountNumber").isJsonNull()) && !jsonObj.get("ownerAccountNumber").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `ownerAccountNumber` to be a primitive type in the JSON string but got `%s`", jsonObj.get("ownerAccountNumber").toString()));
      }
      if ((jsonObj.get("productCode") != null && !jsonObj.get("productCode").isJsonNull()) && !jsonObj.get("productCode").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `productCode` to be a primitive type in the JSON string but got `%s`", jsonObj.get("productCode").toString()));
      }
      if ((jsonObj.get("purchaseOrderNumber") != null && !jsonObj.get("purchaseOrderNumber").isJsonNull()) && !jsonObj.get("purchaseOrderNumber").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `purchaseOrderNumber` to be a primitive type in the JSON string but got `%s`", jsonObj.get("purchaseOrderNumber").toString()));
      }
      if ((jsonObj.get("recognizedRevenueAccountingCode") != null && !jsonObj.get("recognizedRevenueAccountingCode").isJsonNull()) && !jsonObj.get("recognizedRevenueAccountingCode").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `recognizedRevenueAccountingCode` to be a primitive type in the JSON string but got `%s`", jsonObj.get("recognizedRevenueAccountingCode").toString()));
      }
      if ((jsonObj.get("relatedSubscriptionNumber") != null && !jsonObj.get("relatedSubscriptionNumber").isJsonNull()) && !jsonObj.get("relatedSubscriptionNumber").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `relatedSubscriptionNumber` to be a primitive type in the JSON string but got `%s`", jsonObj.get("relatedSubscriptionNumber").toString()));
      }
      if ((jsonObj.get("revenueRecognitionRule") != null && !jsonObj.get("revenueRecognitionRule").isJsonNull()) && !jsonObj.get("revenueRecognitionRule").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `revenueRecognitionRule` to be a primitive type in the JSON string but got `%s`", jsonObj.get("revenueRecognitionRule").toString()));
      }
      if ((jsonObj.get("revenueRecognitionTiming") != null && !jsonObj.get("revenueRecognitionTiming").isJsonNull()) && !jsonObj.get("revenueRecognitionTiming").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `revenueRecognitionTiming` to be a primitive type in the JSON string but got `%s`", jsonObj.get("revenueRecognitionTiming").toString()));
      }
      if ((jsonObj.get("revenueAmortizationMethod") != null && !jsonObj.get("revenueAmortizationMethod").isJsonNull()) && !jsonObj.get("revenueAmortizationMethod").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `revenueAmortizationMethod` to be a primitive type in the JSON string but got `%s`", jsonObj.get("revenueAmortizationMethod").toString()));
      }
      if ((jsonObj.get("sequenceSetId") != null && !jsonObj.get("sequenceSetId").isJsonNull()) && !jsonObj.get("sequenceSetId").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `sequenceSetId` to be a primitive type in the JSON string but got `%s`", jsonObj.get("sequenceSetId").toString()));
      }
      if ((jsonObj.get("soldTo") != null && !jsonObj.get("soldTo").isJsonNull()) && !jsonObj.get("soldTo").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `soldTo` to be a primitive type in the JSON string but got `%s`", jsonObj.get("soldTo").toString()));
      }
      if ((jsonObj.get("taxCode") != null && !jsonObj.get("taxCode").isJsonNull()) && !jsonObj.get("taxCode").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `taxCode` to be a primitive type in the JSON string but got `%s`", jsonObj.get("taxCode").toString()));
      }
      if ((jsonObj.get("taxMode") != null && !jsonObj.get("taxMode").isJsonNull()) && !jsonObj.get("taxMode").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `taxMode` to be a primitive type in the JSON string but got `%s`", jsonObj.get("taxMode").toString()));
      }
      if ((jsonObj.get("unbilledReceivablesAccountingCode") != null && !jsonObj.get("unbilledReceivablesAccountingCode").isJsonNull()) && !jsonObj.get("unbilledReceivablesAccountingCode").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `unbilledReceivablesAccountingCode` to be a primitive type in the JSON string but got `%s`", jsonObj.get("unbilledReceivablesAccountingCode").toString()));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!PostOrderLineItemUpdateType.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'PostOrderLineItemUpdateType' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<PostOrderLineItemUpdateType> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(PostOrderLineItemUpdateType.class));

       return (TypeAdapter<T>) new TypeAdapter<PostOrderLineItemUpdateType>() {
           @Override
           public void write(JsonWriter out, PostOrderLineItemUpdateType value) throws IOException {
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
           public PostOrderLineItemUpdateType read(JsonReader in) throws IOException {
             JsonObject jsonObj = elementAdapter.read(in).getAsJsonObject();
             validateJsonObject(jsonObj);
             // store additional fields in the deserialized instance
             PostOrderLineItemUpdateType instance = thisAdapter.fromJsonTree(jsonObj);
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
  * Create an instance of PostOrderLineItemUpdateType given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of PostOrderLineItemUpdateType
  * @throws IOException if the JSON string is invalid with respect to PostOrderLineItemUpdateType
  */
  public static PostOrderLineItemUpdateType fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, PostOrderLineItemUpdateType.class);
  }

 /**
  * Convert an instance of PostOrderLineItemUpdateType to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

