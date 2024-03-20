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
import com.konfigthis.client.model.PostOrderResponseTypeAllOfOrderLineItems;
import com.konfigthis.client.model.PostOrderResponseTypeAllOfRamps;
import com.konfigthis.client.model.PostOrderResponseTypeAllOfRefunds;
import com.konfigthis.client.model.PostOrderResponseTypeAllOfSubscriptions;
import com.konfigthis.client.model.PostOrderResponseTypeAllOfWriteOff;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
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
 * PostOrderResponseTypeAllOf
 */@javax.annotation.Generated(value = "Generated by https://konfigthis.com")
public class PostOrderResponseTypeAllOf {
  public static final String SERIALIZED_NAME_ACCOUNT_ID = "accountId";
  @SerializedName(SERIALIZED_NAME_ACCOUNT_ID)
  private String accountId;

  public static final String SERIALIZED_NAME_ACCOUNT_NUMBER = "accountNumber";
  @SerializedName(SERIALIZED_NAME_ACCOUNT_NUMBER)
  private String accountNumber;

  public static final String SERIALIZED_NAME_CREDIT_MEMO_IDS = "creditMemoIds";
  @SerializedName(SERIALIZED_NAME_CREDIT_MEMO_IDS)
  private List<String> creditMemoIds = null;

  public static final String SERIALIZED_NAME_CREDIT_MEMO_NUMBERS = "creditMemoNumbers";
  @SerializedName(SERIALIZED_NAME_CREDIT_MEMO_NUMBERS)
  private List<String> creditMemoNumbers = null;

  public static final String SERIALIZED_NAME_INVOICE_IDS = "invoiceIds";
  @SerializedName(SERIALIZED_NAME_INVOICE_IDS)
  private List<String> invoiceIds = null;

  public static final String SERIALIZED_NAME_INVOICE_NUMBERS = "invoiceNumbers";
  @SerializedName(SERIALIZED_NAME_INVOICE_NUMBERS)
  private List<String> invoiceNumbers = null;

  public static final String SERIALIZED_NAME_ORDER_ID = "orderId";
  @SerializedName(SERIALIZED_NAME_ORDER_ID)
  private String orderId;

  public static final String SERIALIZED_NAME_ORDER_LINE_ITEMS = "orderLineItems";
  @SerializedName(SERIALIZED_NAME_ORDER_LINE_ITEMS)
  private List<PostOrderResponseTypeAllOfOrderLineItems> orderLineItems = null;

  public static final String SERIALIZED_NAME_ORDER_NUMBER = "orderNumber";
  @SerializedName(SERIALIZED_NAME_ORDER_NUMBER)
  private String orderNumber;

  public static final String SERIALIZED_NAME_PAID_AMOUNT = "paidAmount";
  @SerializedName(SERIALIZED_NAME_PAID_AMOUNT)
  private String paidAmount;

  public static final String SERIALIZED_NAME_PAYMENT_ID = "paymentId";
  @SerializedName(SERIALIZED_NAME_PAYMENT_ID)
  private String paymentId;

  public static final String SERIALIZED_NAME_PAYMENT_NUMBER = "paymentNumber";
  @SerializedName(SERIALIZED_NAME_PAYMENT_NUMBER)
  private String paymentNumber;

  public static final String SERIALIZED_NAME_RAMPS = "ramps";
  @SerializedName(SERIALIZED_NAME_RAMPS)
  private List<PostOrderResponseTypeAllOfRamps> ramps = null;

  public static final String SERIALIZED_NAME_REFUNDS = "refunds";
  @SerializedName(SERIALIZED_NAME_REFUNDS)
  private List<PostOrderResponseTypeAllOfRefunds> refunds = null;

  /**
   * Status of the order. &#x60;Pending&#x60; is only applicable for an order that contains a &#x60;CreateSubscription&#x60; order action.
   */
  @JsonAdapter(StatusEnum.Adapter.class)
 public enum StatusEnum {
    DRAFT("Draft"),
    
    PENDING("Pending"),
    
    COMPLETED("Completed");

    private String value;

    StatusEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static StatusEnum fromValue(String value) {
      for (StatusEnum b : StatusEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<StatusEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final StatusEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public StatusEnum read(final JsonReader jsonReader) throws IOException {
        String value =  jsonReader.nextString();
        return StatusEnum.fromValue(value);
      }
    }
  }

  public static final String SERIALIZED_NAME_STATUS = "status";
  @SerializedName(SERIALIZED_NAME_STATUS)
  private StatusEnum status;

  public static final String SERIALIZED_NAME_SUBSCRIPTION_IDS = "subscriptionIds";
  @SerializedName(SERIALIZED_NAME_SUBSCRIPTION_IDS)
  private List<String> subscriptionIds = null;

  public static final String SERIALIZED_NAME_SUBSCRIPTION_NUMBERS = "subscriptionNumbers";
  @SerializedName(SERIALIZED_NAME_SUBSCRIPTION_NUMBERS)
  private List<String> subscriptionNumbers = null;

  public static final String SERIALIZED_NAME_SUBSCRIPTIONS = "subscriptions";
  @SerializedName(SERIALIZED_NAME_SUBSCRIPTIONS)
  private List<PostOrderResponseTypeAllOfSubscriptions> subscriptions = null;

  public static final String SERIALIZED_NAME_WRITE_OFF = "writeOff";
  @SerializedName(SERIALIZED_NAME_WRITE_OFF)
  private List<PostOrderResponseTypeAllOfWriteOff> writeOff = null;

  public PostOrderResponseTypeAllOf() {
  }

  public PostOrderResponseTypeAllOf accountId(String accountId) {
    
    
    
    
    this.accountId = accountId;
    return this;
  }

   /**
   * The account ID for the order. This field is returned instead of the &#x60;accountNumber&#x60; field if the &#x60;returnIds&#x60; query parameter is set to &#x60;true&#x60;.
   * @return accountId
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The account ID for the order. This field is returned instead of the `accountNumber` field if the `returnIds` query parameter is set to `true`.")

  public String getAccountId() {
    return accountId;
  }


  public void setAccountId(String accountId) {
    
    
    
    this.accountId = accountId;
  }


  public PostOrderResponseTypeAllOf accountNumber(String accountNumber) {
    
    
    
    
    this.accountNumber = accountNumber;
    return this;
  }

   /**
   * The account number for the order.
   * @return accountNumber
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The account number for the order.")

  public String getAccountNumber() {
    return accountNumber;
  }


  public void setAccountNumber(String accountNumber) {
    
    
    
    this.accountNumber = accountNumber;
  }


  public PostOrderResponseTypeAllOf creditMemoIds(List<String> creditMemoIds) {
    
    
    
    
    this.creditMemoIds = creditMemoIds;
    return this;
  }

  public PostOrderResponseTypeAllOf addCreditMemoIdsItem(String creditMemoIdsItem) {
    if (this.creditMemoIds == null) {
      this.creditMemoIds = new ArrayList<>();
    }
    this.creditMemoIds.add(creditMemoIdsItem);
    return this;
  }

   /**
   * An array of the credit memo IDs generated in this order request. The credit memo is only available if you have the Invoice Settlement feature enabled. This field is returned instead of the &#x60;creditMemoNumbers&#x60; field if the &#x60;returnIds&#x60; query parameter is set to &#x60;true&#x60;.
   * @return creditMemoIds
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "An array of the credit memo IDs generated in this order request. The credit memo is only available if you have the Invoice Settlement feature enabled. This field is returned instead of the `creditMemoNumbers` field if the `returnIds` query parameter is set to `true`.")

  public List<String> getCreditMemoIds() {
    return creditMemoIds;
  }


  public void setCreditMemoIds(List<String> creditMemoIds) {
    
    
    
    this.creditMemoIds = creditMemoIds;
  }


  public PostOrderResponseTypeAllOf creditMemoNumbers(List<String> creditMemoNumbers) {
    
    
    
    
    this.creditMemoNumbers = creditMemoNumbers;
    return this;
  }

  public PostOrderResponseTypeAllOf addCreditMemoNumbersItem(String creditMemoNumbersItem) {
    if (this.creditMemoNumbers == null) {
      this.creditMemoNumbers = new ArrayList<>();
    }
    this.creditMemoNumbers.add(creditMemoNumbersItem);
    return this;
  }

   /**
   * An array of the credit memo numbers generated in this order request. The credit memo is only available if you have the Invoice Settlement feature enabled.
   * @return creditMemoNumbers
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "An array of the credit memo numbers generated in this order request. The credit memo is only available if you have the Invoice Settlement feature enabled.")

  public List<String> getCreditMemoNumbers() {
    return creditMemoNumbers;
  }


  public void setCreditMemoNumbers(List<String> creditMemoNumbers) {
    
    
    
    this.creditMemoNumbers = creditMemoNumbers;
  }


  public PostOrderResponseTypeAllOf invoiceIds(List<String> invoiceIds) {
    
    
    
    
    this.invoiceIds = invoiceIds;
    return this;
  }

  public PostOrderResponseTypeAllOf addInvoiceIdsItem(String invoiceIdsItem) {
    if (this.invoiceIds == null) {
      this.invoiceIds = new ArrayList<>();
    }
    this.invoiceIds.add(invoiceIdsItem);
    return this;
  }

   /**
   * An array of the invoice IDs generated in this order request. Normally it includes one invoice ID only, but can include multiple items when a subscription was tagged as invoice separately. This field is returned instead of the &#x60;invoiceNumbers&#x60; field if the &#x60;returnIds&#x60; query parameter is set to &#x60;true&#x60;.
   * @return invoiceIds
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "An array of the invoice IDs generated in this order request. Normally it includes one invoice ID only, but can include multiple items when a subscription was tagged as invoice separately. This field is returned instead of the `invoiceNumbers` field if the `returnIds` query parameter is set to `true`.")

  public List<String> getInvoiceIds() {
    return invoiceIds;
  }


  public void setInvoiceIds(List<String> invoiceIds) {
    
    
    
    this.invoiceIds = invoiceIds;
  }


  public PostOrderResponseTypeAllOf invoiceNumbers(List<String> invoiceNumbers) {
    
    
    
    
    this.invoiceNumbers = invoiceNumbers;
    return this;
  }

  public PostOrderResponseTypeAllOf addInvoiceNumbersItem(String invoiceNumbersItem) {
    if (this.invoiceNumbers == null) {
      this.invoiceNumbers = new ArrayList<>();
    }
    this.invoiceNumbers.add(invoiceNumbersItem);
    return this;
  }

   /**
   * An array of the invoice numbers generated in this order request. Normally it includes one invoice number only, but can include multiple items when a subscription was tagged as invoice separately.
   * @return invoiceNumbers
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "An array of the invoice numbers generated in this order request. Normally it includes one invoice number only, but can include multiple items when a subscription was tagged as invoice separately.")

  public List<String> getInvoiceNumbers() {
    return invoiceNumbers;
  }


  public void setInvoiceNumbers(List<String> invoiceNumbers) {
    
    
    
    this.invoiceNumbers = invoiceNumbers;
  }


  public PostOrderResponseTypeAllOf orderId(String orderId) {
    
    
    
    
    this.orderId = orderId;
    return this;
  }

   /**
   * The ID of the order created. This field is returned instead of the &#x60;orderNumber&#x60; field if the &#x60;returnIds&#x60; query parameter is set to &#x60;true&#x60;.
   * @return orderId
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The ID of the order created. This field is returned instead of the `orderNumber` field if the `returnIds` query parameter is set to `true`.")

  public String getOrderId() {
    return orderId;
  }


  public void setOrderId(String orderId) {
    
    
    
    this.orderId = orderId;
  }


  public PostOrderResponseTypeAllOf orderLineItems(List<PostOrderResponseTypeAllOfOrderLineItems> orderLineItems) {
    
    
    
    
    this.orderLineItems = orderLineItems;
    return this;
  }

  public PostOrderResponseTypeAllOf addOrderLineItemsItem(PostOrderResponseTypeAllOfOrderLineItems orderLineItemsItem) {
    if (this.orderLineItems == null) {
      this.orderLineItems = new ArrayList<>();
    }
    this.orderLineItems.add(orderLineItemsItem);
    return this;
  }

   /**
   * Get orderLineItems
   * @return orderLineItems
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public List<PostOrderResponseTypeAllOfOrderLineItems> getOrderLineItems() {
    return orderLineItems;
  }


  public void setOrderLineItems(List<PostOrderResponseTypeAllOfOrderLineItems> orderLineItems) {
    
    
    
    this.orderLineItems = orderLineItems;
  }


  public PostOrderResponseTypeAllOf orderNumber(String orderNumber) {
    
    
    
    
    this.orderNumber = orderNumber;
    return this;
  }

   /**
   * The order number of the order created.
   * @return orderNumber
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The order number of the order created.")

  public String getOrderNumber() {
    return orderNumber;
  }


  public void setOrderNumber(String orderNumber) {
    
    
    
    this.orderNumber = orderNumber;
  }


  public PostOrderResponseTypeAllOf paidAmount(String paidAmount) {
    
    
    if (paidAmount != null && paidAmount.length() < 9) {
      throw new IllegalArgumentException("Invalid value for paidAmount. Length must be greater than or equal to 9.");
    }
    
    this.paidAmount = paidAmount;
    return this;
  }

   /**
   * The total amount collected in this order request.
   * @return paidAmount
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The total amount collected in this order request.")

  public String getPaidAmount() {
    return paidAmount;
  }


  public void setPaidAmount(String paidAmount) {
    
    
    if (paidAmount != null && paidAmount.length() < 9) {
      throw new IllegalArgumentException("Invalid value for paidAmount. Length must be greater than or equal to 9.");
    }
    this.paidAmount = paidAmount;
  }


  public PostOrderResponseTypeAllOf paymentId(String paymentId) {
    
    
    
    
    this.paymentId = paymentId;
    return this;
  }

   /**
   * The payment Id that is collected in this order request. This field is returned instead of the &#x60;paymentNumber&#x60; field if the &#x60;returnIds&#x60; query parameter is set to &#x60;true&#x60;.
   * @return paymentId
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The payment Id that is collected in this order request. This field is returned instead of the `paymentNumber` field if the `returnIds` query parameter is set to `true`.")

  public String getPaymentId() {
    return paymentId;
  }


  public void setPaymentId(String paymentId) {
    
    
    
    this.paymentId = paymentId;
  }


  public PostOrderResponseTypeAllOf paymentNumber(String paymentNumber) {
    
    
    
    
    this.paymentNumber = paymentNumber;
    return this;
  }

   /**
   * The payment number that is collected in this order request.
   * @return paymentNumber
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The payment number that is collected in this order request.")

  public String getPaymentNumber() {
    return paymentNumber;
  }


  public void setPaymentNumber(String paymentNumber) {
    
    
    
    this.paymentNumber = paymentNumber;
  }


  public PostOrderResponseTypeAllOf ramps(List<PostOrderResponseTypeAllOfRamps> ramps) {
    
    
    
    
    this.ramps = ramps;
    return this;
  }

  public PostOrderResponseTypeAllOf addRampsItem(PostOrderResponseTypeAllOfRamps rampsItem) {
    if (this.ramps == null) {
      this.ramps = new ArrayList<>();
    }
    this.ramps.add(rampsItem);
    return this;
  }

   /**
   * **Note**: This field is only available if you have the Ramps feature enabled. The [Orders](https://knowledgecenter.zuora.com/Billing/Subscriptions/Orders/AA_Overview_of_Orders) feature must be enabled before you can access the [Ramps](https://knowledgecenter.zuora.com/Billing/Subscriptions/Orders/Ramps_and_Ramp_Metrics/A_Overview_of_Ramps_and_Ramp_Metrics) feature. The Ramps feature is available for customers with Enterprise and Nine editions by default. If you are a Growth customer, see [Zuora Editions](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/C_Zuora_Editions) for pricing information coming October 2020.  The ramp definitions created by this order request. 
   * @return ramps
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "**Note**: This field is only available if you have the Ramps feature enabled. The [Orders](https://knowledgecenter.zuora.com/Billing/Subscriptions/Orders/AA_Overview_of_Orders) feature must be enabled before you can access the [Ramps](https://knowledgecenter.zuora.com/Billing/Subscriptions/Orders/Ramps_and_Ramp_Metrics/A_Overview_of_Ramps_and_Ramp_Metrics) feature. The Ramps feature is available for customers with Enterprise and Nine editions by default. If you are a Growth customer, see [Zuora Editions](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/C_Zuora_Editions) for pricing information coming October 2020.  The ramp definitions created by this order request. ")

  public List<PostOrderResponseTypeAllOfRamps> getRamps() {
    return ramps;
  }


  public void setRamps(List<PostOrderResponseTypeAllOfRamps> ramps) {
    
    
    
    this.ramps = ramps;
  }


  public PostOrderResponseTypeAllOf refunds(List<PostOrderResponseTypeAllOfRefunds> refunds) {
    
    
    
    
    this.refunds = refunds;
    return this;
  }

  public PostOrderResponseTypeAllOf addRefundsItem(PostOrderResponseTypeAllOfRefunds refundsItem) {
    if (this.refunds == null) {
      this.refunds = new ArrayList<>();
    }
    this.refunds.add(refundsItem);
    return this;
  }

   /**
   * Get refunds
   * @return refunds
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public List<PostOrderResponseTypeAllOfRefunds> getRefunds() {
    return refunds;
  }


  public void setRefunds(List<PostOrderResponseTypeAllOfRefunds> refunds) {
    
    
    
    this.refunds = refunds;
  }


  public PostOrderResponseTypeAllOf status(StatusEnum status) {
    
    
    
    
    this.status = status;
    return this;
  }

   /**
   * Status of the order. &#x60;Pending&#x60; is only applicable for an order that contains a &#x60;CreateSubscription&#x60; order action.
   * @return status
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Status of the order. `Pending` is only applicable for an order that contains a `CreateSubscription` order action.")

  public StatusEnum getStatus() {
    return status;
  }


  public void setStatus(StatusEnum status) {
    
    
    
    this.status = status;
  }


  public PostOrderResponseTypeAllOf subscriptionIds(List<String> subscriptionIds) {
    
    
    
    
    this.subscriptionIds = subscriptionIds;
    return this;
  }

  public PostOrderResponseTypeAllOf addSubscriptionIdsItem(String subscriptionIdsItem) {
    if (this.subscriptionIds == null) {
      this.subscriptionIds = new ArrayList<>();
    }
    this.subscriptionIds.add(subscriptionIdsItem);
    return this;
  }

   /**
   * Container for the subscription IDs of the subscriptions in an order. This field is returned if the &#x60;returnIds&#x60; query parameter is set to &#x60;true&#x60;.
   * @return subscriptionIds
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Container for the subscription IDs of the subscriptions in an order. This field is returned if the `returnIds` query parameter is set to `true`.")

  public List<String> getSubscriptionIds() {
    return subscriptionIds;
  }


  public void setSubscriptionIds(List<String> subscriptionIds) {
    
    
    
    this.subscriptionIds = subscriptionIds;
  }


  public PostOrderResponseTypeAllOf subscriptionNumbers(List<String> subscriptionNumbers) {
    
    
    
    
    this.subscriptionNumbers = subscriptionNumbers;
    return this;
  }

  public PostOrderResponseTypeAllOf addSubscriptionNumbersItem(String subscriptionNumbersItem) {
    if (this.subscriptionNumbers == null) {
      this.subscriptionNumbers = new ArrayList<>();
    }
    this.subscriptionNumbers.add(subscriptionNumbersItem);
    return this;
  }

   /**
   * Container for the subscription numbers of the subscriptions in an order. Subscriptions in the response are displayed in the same sequence as the subscriptions defined in the request.
   * @return subscriptionNumbers
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Container for the subscription numbers of the subscriptions in an order. Subscriptions in the response are displayed in the same sequence as the subscriptions defined in the request.")

  public List<String> getSubscriptionNumbers() {
    return subscriptionNumbers;
  }


  public void setSubscriptionNumbers(List<String> subscriptionNumbers) {
    
    
    
    this.subscriptionNumbers = subscriptionNumbers;
  }


  public PostOrderResponseTypeAllOf subscriptions(List<PostOrderResponseTypeAllOfSubscriptions> subscriptions) {
    
    
    
    
    this.subscriptions = subscriptions;
    return this;
  }

  public PostOrderResponseTypeAllOf addSubscriptionsItem(PostOrderResponseTypeAllOfSubscriptions subscriptionsItem) {
    if (this.subscriptions == null) {
      this.subscriptions = new ArrayList<>();
    }
    this.subscriptions.add(subscriptionsItem);
    return this;
  }

   /**
   * **Note:** This field is in Zuora REST API version control. Supported minor versions are 223.0 or later [available versions](https://developer.zuora.com/api-references/api/overview/#section/API-Versions/Minor-Version). To use this field in the method, you must set the &#x60;zuora-version&#x60; parameter to the minor version number in the request header.  Container for the subscription numbers and statuses in an order. 
   * @return subscriptions
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "**Note:** This field is in Zuora REST API version control. Supported minor versions are 223.0 or later [available versions](https://developer.zuora.com/api-references/api/overview/#section/API-Versions/Minor-Version). To use this field in the method, you must set the `zuora-version` parameter to the minor version number in the request header.  Container for the subscription numbers and statuses in an order. ")

  public List<PostOrderResponseTypeAllOfSubscriptions> getSubscriptions() {
    return subscriptions;
  }


  public void setSubscriptions(List<PostOrderResponseTypeAllOfSubscriptions> subscriptions) {
    
    
    
    this.subscriptions = subscriptions;
  }


  public PostOrderResponseTypeAllOf writeOff(List<PostOrderResponseTypeAllOfWriteOff> writeOff) {
    
    
    
    
    this.writeOff = writeOff;
    return this;
  }

  public PostOrderResponseTypeAllOf addWriteOffItem(PostOrderResponseTypeAllOfWriteOff writeOffItem) {
    if (this.writeOff == null) {
      this.writeOff = new ArrayList<>();
    }
    this.writeOff.add(writeOffItem);
    return this;
  }

   /**
   * Get writeOff
   * @return writeOff
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public List<PostOrderResponseTypeAllOfWriteOff> getWriteOff() {
    return writeOff;
  }


  public void setWriteOff(List<PostOrderResponseTypeAllOfWriteOff> writeOff) {
    
    
    
    this.writeOff = writeOff;
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
   * @return the PostOrderResponseTypeAllOf instance itself
   */
  public PostOrderResponseTypeAllOf putAdditionalProperty(String key, Object value) {
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
    PostOrderResponseTypeAllOf postOrderResponseTypeAllOf = (PostOrderResponseTypeAllOf) o;
    return Objects.equals(this.accountId, postOrderResponseTypeAllOf.accountId) &&
        Objects.equals(this.accountNumber, postOrderResponseTypeAllOf.accountNumber) &&
        Objects.equals(this.creditMemoIds, postOrderResponseTypeAllOf.creditMemoIds) &&
        Objects.equals(this.creditMemoNumbers, postOrderResponseTypeAllOf.creditMemoNumbers) &&
        Objects.equals(this.invoiceIds, postOrderResponseTypeAllOf.invoiceIds) &&
        Objects.equals(this.invoiceNumbers, postOrderResponseTypeAllOf.invoiceNumbers) &&
        Objects.equals(this.orderId, postOrderResponseTypeAllOf.orderId) &&
        Objects.equals(this.orderLineItems, postOrderResponseTypeAllOf.orderLineItems) &&
        Objects.equals(this.orderNumber, postOrderResponseTypeAllOf.orderNumber) &&
        Objects.equals(this.paidAmount, postOrderResponseTypeAllOf.paidAmount) &&
        Objects.equals(this.paymentId, postOrderResponseTypeAllOf.paymentId) &&
        Objects.equals(this.paymentNumber, postOrderResponseTypeAllOf.paymentNumber) &&
        Objects.equals(this.ramps, postOrderResponseTypeAllOf.ramps) &&
        Objects.equals(this.refunds, postOrderResponseTypeAllOf.refunds) &&
        Objects.equals(this.status, postOrderResponseTypeAllOf.status) &&
        Objects.equals(this.subscriptionIds, postOrderResponseTypeAllOf.subscriptionIds) &&
        Objects.equals(this.subscriptionNumbers, postOrderResponseTypeAllOf.subscriptionNumbers) &&
        Objects.equals(this.subscriptions, postOrderResponseTypeAllOf.subscriptions) &&
        Objects.equals(this.writeOff, postOrderResponseTypeAllOf.writeOff)&&
        Objects.equals(this.additionalProperties, postOrderResponseTypeAllOf.additionalProperties);
  }

  @Override
  public int hashCode() {
    return Objects.hash(accountId, accountNumber, creditMemoIds, creditMemoNumbers, invoiceIds, invoiceNumbers, orderId, orderLineItems, orderNumber, paidAmount, paymentId, paymentNumber, ramps, refunds, status, subscriptionIds, subscriptionNumbers, subscriptions, writeOff, additionalProperties);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PostOrderResponseTypeAllOf {\n");
    sb.append("    accountId: ").append(toIndentedString(accountId)).append("\n");
    sb.append("    accountNumber: ").append(toIndentedString(accountNumber)).append("\n");
    sb.append("    creditMemoIds: ").append(toIndentedString(creditMemoIds)).append("\n");
    sb.append("    creditMemoNumbers: ").append(toIndentedString(creditMemoNumbers)).append("\n");
    sb.append("    invoiceIds: ").append(toIndentedString(invoiceIds)).append("\n");
    sb.append("    invoiceNumbers: ").append(toIndentedString(invoiceNumbers)).append("\n");
    sb.append("    orderId: ").append(toIndentedString(orderId)).append("\n");
    sb.append("    orderLineItems: ").append(toIndentedString(orderLineItems)).append("\n");
    sb.append("    orderNumber: ").append(toIndentedString(orderNumber)).append("\n");
    sb.append("    paidAmount: ").append(toIndentedString(paidAmount)).append("\n");
    sb.append("    paymentId: ").append(toIndentedString(paymentId)).append("\n");
    sb.append("    paymentNumber: ").append(toIndentedString(paymentNumber)).append("\n");
    sb.append("    ramps: ").append(toIndentedString(ramps)).append("\n");
    sb.append("    refunds: ").append(toIndentedString(refunds)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    subscriptionIds: ").append(toIndentedString(subscriptionIds)).append("\n");
    sb.append("    subscriptionNumbers: ").append(toIndentedString(subscriptionNumbers)).append("\n");
    sb.append("    subscriptions: ").append(toIndentedString(subscriptions)).append("\n");
    sb.append("    writeOff: ").append(toIndentedString(writeOff)).append("\n");
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
    openapiFields.add("accountNumber");
    openapiFields.add("creditMemoIds");
    openapiFields.add("creditMemoNumbers");
    openapiFields.add("invoiceIds");
    openapiFields.add("invoiceNumbers");
    openapiFields.add("orderId");
    openapiFields.add("orderLineItems");
    openapiFields.add("orderNumber");
    openapiFields.add("paidAmount");
    openapiFields.add("paymentId");
    openapiFields.add("paymentNumber");
    openapiFields.add("ramps");
    openapiFields.add("refunds");
    openapiFields.add("status");
    openapiFields.add("subscriptionIds");
    openapiFields.add("subscriptionNumbers");
    openapiFields.add("subscriptions");
    openapiFields.add("writeOff");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
  }

 /**
  * Validates the JSON Object and throws an exception if issues found
  *
  * @param jsonObj JSON Object
  * @throws IOException if the JSON Object is invalid with respect to PostOrderResponseTypeAllOf
  */
  public static void validateJsonObject(JsonObject jsonObj) throws IOException {
      if (jsonObj == null) {
        if (!PostOrderResponseTypeAllOf.openapiRequiredFields.isEmpty()) { // has required fields but JSON object is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in PostOrderResponseTypeAllOf is not found in the empty JSON string", PostOrderResponseTypeAllOf.openapiRequiredFields.toString()));
        }
      }
      if ((jsonObj.get("accountId") != null && !jsonObj.get("accountId").isJsonNull()) && !jsonObj.get("accountId").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `accountId` to be a primitive type in the JSON string but got `%s`", jsonObj.get("accountId").toString()));
      }
      if ((jsonObj.get("accountNumber") != null && !jsonObj.get("accountNumber").isJsonNull()) && !jsonObj.get("accountNumber").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `accountNumber` to be a primitive type in the JSON string but got `%s`", jsonObj.get("accountNumber").toString()));
      }
      // ensure the optional json data is an array if present
      if (jsonObj.get("creditMemoIds") != null && !jsonObj.get("creditMemoIds").isJsonArray()) {
        throw new IllegalArgumentException(String.format("Expected the field `creditMemoIds` to be an array in the JSON string but got `%s`", jsonObj.get("creditMemoIds").toString()));
      }
      // ensure the optional json data is an array if present
      if (jsonObj.get("creditMemoNumbers") != null && !jsonObj.get("creditMemoNumbers").isJsonArray()) {
        throw new IllegalArgumentException(String.format("Expected the field `creditMemoNumbers` to be an array in the JSON string but got `%s`", jsonObj.get("creditMemoNumbers").toString()));
      }
      // ensure the optional json data is an array if present
      if (jsonObj.get("invoiceIds") != null && !jsonObj.get("invoiceIds").isJsonArray()) {
        throw new IllegalArgumentException(String.format("Expected the field `invoiceIds` to be an array in the JSON string but got `%s`", jsonObj.get("invoiceIds").toString()));
      }
      // ensure the optional json data is an array if present
      if (jsonObj.get("invoiceNumbers") != null && !jsonObj.get("invoiceNumbers").isJsonArray()) {
        throw new IllegalArgumentException(String.format("Expected the field `invoiceNumbers` to be an array in the JSON string but got `%s`", jsonObj.get("invoiceNumbers").toString()));
      }
      if ((jsonObj.get("orderId") != null && !jsonObj.get("orderId").isJsonNull()) && !jsonObj.get("orderId").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `orderId` to be a primitive type in the JSON string but got `%s`", jsonObj.get("orderId").toString()));
      }
      if (jsonObj.get("orderLineItems") != null && !jsonObj.get("orderLineItems").isJsonNull()) {
        JsonArray jsonArrayorderLineItems = jsonObj.getAsJsonArray("orderLineItems");
        if (jsonArrayorderLineItems != null) {
          // ensure the json data is an array
          if (!jsonObj.get("orderLineItems").isJsonArray()) {
            throw new IllegalArgumentException(String.format("Expected the field `orderLineItems` to be an array in the JSON string but got `%s`", jsonObj.get("orderLineItems").toString()));
          }

          // validate the optional field `orderLineItems` (array)
          for (int i = 0; i < jsonArrayorderLineItems.size(); i++) {
            PostOrderResponseTypeAllOfOrderLineItems.validateJsonObject(jsonArrayorderLineItems.get(i).getAsJsonObject());
          };
        }
      }
      if ((jsonObj.get("orderNumber") != null && !jsonObj.get("orderNumber").isJsonNull()) && !jsonObj.get("orderNumber").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `orderNumber` to be a primitive type in the JSON string but got `%s`", jsonObj.get("orderNumber").toString()));
      }
      if ((jsonObj.get("paidAmount") != null && !jsonObj.get("paidAmount").isJsonNull()) && !jsonObj.get("paidAmount").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `paidAmount` to be a primitive type in the JSON string but got `%s`", jsonObj.get("paidAmount").toString()));
      }
      if ((jsonObj.get("paymentId") != null && !jsonObj.get("paymentId").isJsonNull()) && !jsonObj.get("paymentId").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `paymentId` to be a primitive type in the JSON string but got `%s`", jsonObj.get("paymentId").toString()));
      }
      if ((jsonObj.get("paymentNumber") != null && !jsonObj.get("paymentNumber").isJsonNull()) && !jsonObj.get("paymentNumber").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `paymentNumber` to be a primitive type in the JSON string but got `%s`", jsonObj.get("paymentNumber").toString()));
      }
      if (jsonObj.get("ramps") != null && !jsonObj.get("ramps").isJsonNull()) {
        JsonArray jsonArrayramps = jsonObj.getAsJsonArray("ramps");
        if (jsonArrayramps != null) {
          // ensure the json data is an array
          if (!jsonObj.get("ramps").isJsonArray()) {
            throw new IllegalArgumentException(String.format("Expected the field `ramps` to be an array in the JSON string but got `%s`", jsonObj.get("ramps").toString()));
          }

          // validate the optional field `ramps` (array)
          for (int i = 0; i < jsonArrayramps.size(); i++) {
            PostOrderResponseTypeAllOfRamps.validateJsonObject(jsonArrayramps.get(i).getAsJsonObject());
          };
        }
      }
      if (jsonObj.get("refunds") != null && !jsonObj.get("refunds").isJsonNull()) {
        JsonArray jsonArrayrefunds = jsonObj.getAsJsonArray("refunds");
        if (jsonArrayrefunds != null) {
          // ensure the json data is an array
          if (!jsonObj.get("refunds").isJsonArray()) {
            throw new IllegalArgumentException(String.format("Expected the field `refunds` to be an array in the JSON string but got `%s`", jsonObj.get("refunds").toString()));
          }

          // validate the optional field `refunds` (array)
          for (int i = 0; i < jsonArrayrefunds.size(); i++) {
            PostOrderResponseTypeAllOfRefunds.validateJsonObject(jsonArrayrefunds.get(i).getAsJsonObject());
          };
        }
      }
      if ((jsonObj.get("status") != null && !jsonObj.get("status").isJsonNull()) && !jsonObj.get("status").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `status` to be a primitive type in the JSON string but got `%s`", jsonObj.get("status").toString()));
      }
      // ensure the optional json data is an array if present
      if (jsonObj.get("subscriptionIds") != null && !jsonObj.get("subscriptionIds").isJsonArray()) {
        throw new IllegalArgumentException(String.format("Expected the field `subscriptionIds` to be an array in the JSON string but got `%s`", jsonObj.get("subscriptionIds").toString()));
      }
      // ensure the optional json data is an array if present
      if (jsonObj.get("subscriptionNumbers") != null && !jsonObj.get("subscriptionNumbers").isJsonArray()) {
        throw new IllegalArgumentException(String.format("Expected the field `subscriptionNumbers` to be an array in the JSON string but got `%s`", jsonObj.get("subscriptionNumbers").toString()));
      }
      if (jsonObj.get("subscriptions") != null && !jsonObj.get("subscriptions").isJsonNull()) {
        JsonArray jsonArraysubscriptions = jsonObj.getAsJsonArray("subscriptions");
        if (jsonArraysubscriptions != null) {
          // ensure the json data is an array
          if (!jsonObj.get("subscriptions").isJsonArray()) {
            throw new IllegalArgumentException(String.format("Expected the field `subscriptions` to be an array in the JSON string but got `%s`", jsonObj.get("subscriptions").toString()));
          }

          // validate the optional field `subscriptions` (array)
          for (int i = 0; i < jsonArraysubscriptions.size(); i++) {
            PostOrderResponseTypeAllOfSubscriptions.validateJsonObject(jsonArraysubscriptions.get(i).getAsJsonObject());
          };
        }
      }
      if (jsonObj.get("writeOff") != null && !jsonObj.get("writeOff").isJsonNull()) {
        JsonArray jsonArraywriteOff = jsonObj.getAsJsonArray("writeOff");
        if (jsonArraywriteOff != null) {
          // ensure the json data is an array
          if (!jsonObj.get("writeOff").isJsonArray()) {
            throw new IllegalArgumentException(String.format("Expected the field `writeOff` to be an array in the JSON string but got `%s`", jsonObj.get("writeOff").toString()));
          }

          // validate the optional field `writeOff` (array)
          for (int i = 0; i < jsonArraywriteOff.size(); i++) {
            PostOrderResponseTypeAllOfWriteOff.validateJsonObject(jsonArraywriteOff.get(i).getAsJsonObject());
          };
        }
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!PostOrderResponseTypeAllOf.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'PostOrderResponseTypeAllOf' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<PostOrderResponseTypeAllOf> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(PostOrderResponseTypeAllOf.class));

       return (TypeAdapter<T>) new TypeAdapter<PostOrderResponseTypeAllOf>() {
           @Override
           public void write(JsonWriter out, PostOrderResponseTypeAllOf value) throws IOException {
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
           public PostOrderResponseTypeAllOf read(JsonReader in) throws IOException {
             JsonObject jsonObj = elementAdapter.read(in).getAsJsonObject();
             validateJsonObject(jsonObj);
             // store additional fields in the deserialized instance
             PostOrderResponseTypeAllOf instance = thisAdapter.fromJsonTree(jsonObj);
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
  * Create an instance of PostOrderResponseTypeAllOf given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of PostOrderResponseTypeAllOf
  * @throws IOException if the JSON string is invalid with respect to PostOrderResponseTypeAllOf
  */
  public static PostOrderResponseTypeAllOf fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, PostOrderResponseTypeAllOf.class);
  }

 /**
  * Convert an instance of PostOrderResponseTypeAllOf to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

