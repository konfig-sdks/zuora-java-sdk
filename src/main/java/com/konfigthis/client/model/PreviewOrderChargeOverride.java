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
import com.konfigthis.client.model.EndConditions;
import com.konfigthis.client.model.PreviewOrderChargeOverrideBilling;
import com.konfigthis.client.model.PreviewOrderChargeOverridePricing;
import com.konfigthis.client.model.PreviewOrderTriggerParams;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

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
 * Charge associated with a rate plan. 
 */
@ApiModel(description = "Charge associated with a rate plan. ")@javax.annotation.Generated(value = "Generated by https://konfigthis.com")
public class PreviewOrderChargeOverride {
  public static final String SERIALIZED_NAME_DESCRIPTION = "description";
  @SerializedName(SERIALIZED_NAME_DESCRIPTION)
  private String description;

  public static final String SERIALIZED_NAME_ACCOUNT_RECEIVABLE_ACCOUNTING_CODE = "accountReceivableAccountingCode";
  @SerializedName(SERIALIZED_NAME_ACCOUNT_RECEIVABLE_ACCOUNTING_CODE)
  private String accountReceivableAccountingCode;

  public static final String SERIALIZED_NAME_ADJUSTMENT_LIABILITY_ACCOUNTING_CODE = "adjustmentLiabilityAccountingCode";
  @SerializedName(SERIALIZED_NAME_ADJUSTMENT_LIABILITY_ACCOUNTING_CODE)
  private String adjustmentLiabilityAccountingCode;

  public static final String SERIALIZED_NAME_ADJUSTMENT_REVENUE_ACCOUNTING_CODE = "adjustmentRevenueAccountingCode";
  @SerializedName(SERIALIZED_NAME_ADJUSTMENT_REVENUE_ACCOUNTING_CODE)
  private String adjustmentRevenueAccountingCode;

  public static final String SERIALIZED_NAME_BILLING = "billing";
  @SerializedName(SERIALIZED_NAME_BILLING)
  private PreviewOrderChargeOverrideBilling billing;

  public static final String SERIALIZED_NAME_CHARGE_MODEL = "chargeModel";
  @SerializedName(SERIALIZED_NAME_CHARGE_MODEL)
  private String chargeModel;

  public static final String SERIALIZED_NAME_CHARGE_NUMBER = "chargeNumber";
  @SerializedName(SERIALIZED_NAME_CHARGE_NUMBER)
  private String chargeNumber;

  public static final String SERIALIZED_NAME_CHARGE_TYPE = "chargeType";
  @SerializedName(SERIALIZED_NAME_CHARGE_TYPE)
  private String chargeType;

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

  public static final String SERIALIZED_NAME_DRAWDOWN_RATE = "drawdownRate";
  @SerializedName(SERIALIZED_NAME_DRAWDOWN_RATE)
  private Double drawdownRate;

  public static final String SERIALIZED_NAME_END_DATE = "endDate";
  @SerializedName(SERIALIZED_NAME_END_DATE)
  private EndConditions endDate;

  public static final String SERIALIZED_NAME_EXCLUDE_ITEM_BILLING_FROM_REVENUE_ACCOUNTING = "excludeItemBillingFromRevenueAccounting";
  @SerializedName(SERIALIZED_NAME_EXCLUDE_ITEM_BILLING_FROM_REVENUE_ACCOUNTING)
  private Boolean excludeItemBillingFromRevenueAccounting = false;

  public static final String SERIALIZED_NAME_EXCLUDE_ITEM_BOOKING_FROM_REVENUE_ACCOUNTING = "excludeItemBookingFromRevenueAccounting";
  @SerializedName(SERIALIZED_NAME_EXCLUDE_ITEM_BOOKING_FROM_REVENUE_ACCOUNTING)
  private Boolean excludeItemBookingFromRevenueAccounting = false;

  public static final String SERIALIZED_NAME_IS_ALLOCATION_ELIGIBLE = "isAllocationEligible";
  @SerializedName(SERIALIZED_NAME_IS_ALLOCATION_ELIGIBLE)
  private Boolean isAllocationEligible;

  public static final String SERIALIZED_NAME_IS_ROLLOVER = "isRollover";
  @SerializedName(SERIALIZED_NAME_IS_ROLLOVER)
  private Boolean isRollover;

  public static final String SERIALIZED_NAME_IS_UNBILLED = "isUnbilled";
  @SerializedName(SERIALIZED_NAME_IS_UNBILLED)
  private Boolean isUnbilled;

  public static final String SERIALIZED_NAME_NAME = "name";
  @SerializedName(SERIALIZED_NAME_NAME)
  private String name;

  public static final String SERIALIZED_NAME_POB_POLICY = "pobPolicy";
  @SerializedName(SERIALIZED_NAME_POB_POLICY)
  private String pobPolicy;

  public static final String SERIALIZED_NAME_PREPAID_QUANTITY = "prepaidQuantity";
  @SerializedName(SERIALIZED_NAME_PREPAID_QUANTITY)
  private Double prepaidQuantity;

  public static final String SERIALIZED_NAME_PRICING = "pricing";
  @SerializedName(SERIALIZED_NAME_PRICING)
  private PreviewOrderChargeOverridePricing pricing;

  public static final String SERIALIZED_NAME_PRODUCT_CATEGORY = "productCategory";
  @SerializedName(SERIALIZED_NAME_PRODUCT_CATEGORY)
  private String productCategory;

  public static final String SERIALIZED_NAME_PRODUCT_CLASS = "productClass";
  @SerializedName(SERIALIZED_NAME_PRODUCT_CLASS)
  private String productClass;

  public static final String SERIALIZED_NAME_PRODUCT_FAMILY = "productFamily";
  @SerializedName(SERIALIZED_NAME_PRODUCT_FAMILY)
  private String productFamily;

  public static final String SERIALIZED_NAME_PRODUCT_LINE = "productLine";
  @SerializedName(SERIALIZED_NAME_PRODUCT_LINE)
  private String productLine;

  public static final String SERIALIZED_NAME_PRODUCT_RATE_PLAN_CHARGE_ID = "productRatePlanChargeId";
  @SerializedName(SERIALIZED_NAME_PRODUCT_RATE_PLAN_CHARGE_ID)
  private String productRatePlanChargeId;

  public static final String SERIALIZED_NAME_PRODUCT_RATE_PLAN_CHARGE_NUMBER = "productRatePlanChargeNumber";
  @SerializedName(SERIALIZED_NAME_PRODUCT_RATE_PLAN_CHARGE_NUMBER)
  private String productRatePlanChargeNumber;

  public static final String SERIALIZED_NAME_RECOGNIZED_REVENUE_ACCOUNTING_CODE = "recognizedRevenueAccountingCode";
  @SerializedName(SERIALIZED_NAME_RECOGNIZED_REVENUE_ACCOUNTING_CODE)
  private String recognizedRevenueAccountingCode;

  public static final String SERIALIZED_NAME_REV_REC_CODE = "revRecCode";
  @SerializedName(SERIALIZED_NAME_REV_REC_CODE)
  private String revRecCode;

  /**
   * Specifies the revenue recognition trigger condition.    * &#x60;Contract Effective Date&#x60;    * &#x60;Service Activation Date&#x60;   * &#x60;Customer Acceptance Date&#x60; 
   */
  @JsonAdapter(RevRecTriggerConditionEnum.Adapter.class)
 public enum RevRecTriggerConditionEnum {
    CONTRACT_EFFECTIVE_DATE("Contract Effective Date"),
    
    SERVICE_ACTIVATION_DATE("Service Activation Date"),
    
    CUSTOMER_ACCEPTANCE_DATE("Customer Acceptance Date");

    private String value;

    RevRecTriggerConditionEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static RevRecTriggerConditionEnum fromValue(String value) {
      for (RevRecTriggerConditionEnum b : RevRecTriggerConditionEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<RevRecTriggerConditionEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final RevRecTriggerConditionEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public RevRecTriggerConditionEnum read(final JsonReader jsonReader) throws IOException {
        String value =  jsonReader.nextString();
        return RevRecTriggerConditionEnum.fromValue(value);
      }
    }
  }

  public static final String SERIALIZED_NAME_REV_REC_TRIGGER_CONDITION = "revRecTriggerCondition";
  @SerializedName(SERIALIZED_NAME_REV_REC_TRIGGER_CONDITION)
  private RevRecTriggerConditionEnum revRecTriggerCondition;

  public static final String SERIALIZED_NAME_REVENUE_RECOGNITION_RULE_NAME = "revenueRecognitionRuleName";
  @SerializedName(SERIALIZED_NAME_REVENUE_RECOGNITION_RULE_NAME)
  private String revenueRecognitionRuleName;

  /**
   * **Note**: This field is only available if you have the [Prepaid with Drawdown](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/J_Billing_Operations/Prepaid_with_Drawdown) feature enabled.  This field defines the priority of rollover, which is either first or last. 
   */
  @JsonAdapter(RolloverApplyEnum.Adapter.class)
 public enum RolloverApplyEnum {
    APPLYFIRST("ApplyFirst"),
    
    APPLYLAST("ApplyLast");

    private String value;

    RolloverApplyEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static RolloverApplyEnum fromValue(String value) {
      for (RolloverApplyEnum b : RolloverApplyEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<RolloverApplyEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final RolloverApplyEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public RolloverApplyEnum read(final JsonReader jsonReader) throws IOException {
        String value =  jsonReader.nextString();
        return RolloverApplyEnum.fromValue(value);
      }
    }
  }

  public static final String SERIALIZED_NAME_ROLLOVER_APPLY = "rolloverApply";
  @SerializedName(SERIALIZED_NAME_ROLLOVER_APPLY)
  private RolloverApplyEnum rolloverApply;

  public static final String SERIALIZED_NAME_ROLLOVER_PERIOD_LENGTH = "rolloverPeriodLength";
  @SerializedName(SERIALIZED_NAME_ROLLOVER_PERIOD_LENGTH)
  private Integer rolloverPeriodLength;

  public static final String SERIALIZED_NAME_ROLLOVER_PERIODS = "rolloverPeriods";
  @SerializedName(SERIALIZED_NAME_ROLLOVER_PERIODS)
  private Double rolloverPeriods;

  public static final String SERIALIZED_NAME_START_DATE = "startDate";
  @SerializedName(SERIALIZED_NAME_START_DATE)
  private PreviewOrderTriggerParams startDate;

  public static final String SERIALIZED_NAME_TAX_CODE = "taxCode";
  @SerializedName(SERIALIZED_NAME_TAX_CODE)
  private String taxCode;

  public static final String SERIALIZED_NAME_TAX_MODE = "taxMode";
  @SerializedName(SERIALIZED_NAME_TAX_MODE)
  private String taxMode;

  public static final String SERIALIZED_NAME_UN_BILLED_RECEIVABLES_ACCOUNTING_CODE = "unBilledReceivablesAccountingCode";
  @SerializedName(SERIALIZED_NAME_UN_BILLED_RECEIVABLES_ACCOUNTING_CODE)
  private String unBilledReceivablesAccountingCode;

  public static final String SERIALIZED_NAME_UNIQUE_TOKEN = "uniqueToken";
  @SerializedName(SERIALIZED_NAME_UNIQUE_TOKEN)
  private String uniqueToken;

  public static final String SERIALIZED_NAME_UPSELL_ORIGIN_CHARGE_NUMBER = "upsellOriginChargeNumber";
  @SerializedName(SERIALIZED_NAME_UPSELL_ORIGIN_CHARGE_NUMBER)
  private String upsellOriginChargeNumber;

  /**
   * **Note**: This field is only available if you have the [Prepaid with Drawdown](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/J_Billing_Operations/Prepaid_with_Drawdown) feature enabled.  The period in which the prepayment units are valid to use as defined in a [prepayment charge](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/J_Billing_Operations/Prepaid_with_Drawdown/Create_prepayment_charge).       
   */
  @JsonAdapter(ValidityPeriodTypeEnum.Adapter.class)
 public enum ValidityPeriodTypeEnum {
    SUBSCRIPTION_TERM("SUBSCRIPTION_TERM"),
    
    ANNUAL("ANNUAL"),
    
    SEMI_ANNUAL("SEMI_ANNUAL"),
    
    QUARTER("QUARTER"),
    
    MONTH("MONTH");

    private String value;

    ValidityPeriodTypeEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static ValidityPeriodTypeEnum fromValue(String value) {
      for (ValidityPeriodTypeEnum b : ValidityPeriodTypeEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<ValidityPeriodTypeEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final ValidityPeriodTypeEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public ValidityPeriodTypeEnum read(final JsonReader jsonReader) throws IOException {
        String value =  jsonReader.nextString();
        return ValidityPeriodTypeEnum.fromValue(value);
      }
    }
  }

  public static final String SERIALIZED_NAME_VALIDITY_PERIOD_TYPE = "validityPeriodType";
  @SerializedName(SERIALIZED_NAME_VALIDITY_PERIOD_TYPE)
  private ValidityPeriodTypeEnum validityPeriodType;

  public PreviewOrderChargeOverride() {
  }

  public PreviewOrderChargeOverride description(String description) {
    
    
    
    
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


  public PreviewOrderChargeOverride accountReceivableAccountingCode(String accountReceivableAccountingCode) {
    
    
    
    
    this.accountReceivableAccountingCode = accountReceivableAccountingCode;
    return this;
  }

   /**
   * The accountReceivableAccountingCode of a standalone charge.  **Note:** This field is available when the &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Manage_subscription_transactions/Orders/Standalone_Orders/AA_Overview_of_Standalone_Orders\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Standalone Orders&lt;/a&gt;, &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Payments/Zuora_Finance\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Zuora Finance&lt;/a&gt;, and &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Bill_your_customers/Adjust_invoice_amounts/Invoice_Settlement/Get_started_with_Invoice_Settlement/AA_Overview_of_Invoice_Settlement\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Invoice Settlement&lt;/a&gt; features are enabled. 
   * @return accountReceivableAccountingCode
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The accountReceivableAccountingCode of a standalone charge.  **Note:** This field is available when the <a href=\"https://knowledgecenter.zuora.com/Zuora_Billing/Manage_subscription_transactions/Orders/Standalone_Orders/AA_Overview_of_Standalone_Orders\" target=\"_blank\">Standalone Orders</a>, <a href=\"https://knowledgecenter.zuora.com/Zuora_Payments/Zuora_Finance\" target=\"_blank\">Zuora Finance</a>, and <a href=\"https://knowledgecenter.zuora.com/Zuora_Billing/Bill_your_customers/Adjust_invoice_amounts/Invoice_Settlement/Get_started_with_Invoice_Settlement/AA_Overview_of_Invoice_Settlement\" target=\"_blank\">Invoice Settlement</a> features are enabled. ")

  public String getAccountReceivableAccountingCode() {
    return accountReceivableAccountingCode;
  }


  public void setAccountReceivableAccountingCode(String accountReceivableAccountingCode) {
    
    
    
    this.accountReceivableAccountingCode = accountReceivableAccountingCode;
  }


  public PreviewOrderChargeOverride adjustmentLiabilityAccountingCode(String adjustmentLiabilityAccountingCode) {
    
    
    
    
    this.adjustmentLiabilityAccountingCode = adjustmentLiabilityAccountingCode;
    return this;
  }

   /**
   * The adjustmentLiabilityAccountingCode of a standalone charge.  **Note:** This field is available when the &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Manage_subscription_transactions/Orders/Standalone_Orders/AA_Overview_of_Standalone_Orders\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Standalone Orders&lt;/a&gt; feature and the &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Revenue/Zuora_Billing_-_Revenue_Integration\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Billing - Revenue Integration&lt;/a&gt; or &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Enable_Order_to_Revenue/Order_to_Revenue_introduction/AA_Overview_of_Order_to_Revenue\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Order to Revenue&lt;/a&gt; feature are enabled. 
   * @return adjustmentLiabilityAccountingCode
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The adjustmentLiabilityAccountingCode of a standalone charge.  **Note:** This field is available when the <a href=\"https://knowledgecenter.zuora.com/Zuora_Billing/Manage_subscription_transactions/Orders/Standalone_Orders/AA_Overview_of_Standalone_Orders\" target=\"_blank\">Standalone Orders</a> feature and the <a href=\"https://knowledgecenter.zuora.com/Zuora_Revenue/Zuora_Billing_-_Revenue_Integration\" target=\"_blank\">Billing - Revenue Integration</a> or <a href=\"https://knowledgecenter.zuora.com/Zuora_Billing/Enable_Order_to_Revenue/Order_to_Revenue_introduction/AA_Overview_of_Order_to_Revenue\" target=\"_blank\">Order to Revenue</a> feature are enabled. ")

  public String getAdjustmentLiabilityAccountingCode() {
    return adjustmentLiabilityAccountingCode;
  }


  public void setAdjustmentLiabilityAccountingCode(String adjustmentLiabilityAccountingCode) {
    
    
    
    this.adjustmentLiabilityAccountingCode = adjustmentLiabilityAccountingCode;
  }


  public PreviewOrderChargeOverride adjustmentRevenueAccountingCode(String adjustmentRevenueAccountingCode) {
    
    
    
    
    this.adjustmentRevenueAccountingCode = adjustmentRevenueAccountingCode;
    return this;
  }

   /**
   * The adjustmentRevenueAccountingCode of a standalone charge.  **Note:** This field is available when the &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Manage_subscription_transactions/Orders/Standalone_Orders/AA_Overview_of_Standalone_Orders\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Standalone Orders&lt;/a&gt; feature and the &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Revenue/Zuora_Billing_-_Revenue_Integration\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Billing - Revenue Integration&lt;/a&gt; or &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Enable_Order_to_Revenue/Order_to_Revenue_introduction/AA_Overview_of_Order_to_Revenue\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Order to Revenue&lt;/a&gt; feature are enabled. 
   * @return adjustmentRevenueAccountingCode
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The adjustmentRevenueAccountingCode of a standalone charge.  **Note:** This field is available when the <a href=\"https://knowledgecenter.zuora.com/Zuora_Billing/Manage_subscription_transactions/Orders/Standalone_Orders/AA_Overview_of_Standalone_Orders\" target=\"_blank\">Standalone Orders</a> feature and the <a href=\"https://knowledgecenter.zuora.com/Zuora_Revenue/Zuora_Billing_-_Revenue_Integration\" target=\"_blank\">Billing - Revenue Integration</a> or <a href=\"https://knowledgecenter.zuora.com/Zuora_Billing/Enable_Order_to_Revenue/Order_to_Revenue_introduction/AA_Overview_of_Order_to_Revenue\" target=\"_blank\">Order to Revenue</a> feature are enabled. ")

  public String getAdjustmentRevenueAccountingCode() {
    return adjustmentRevenueAccountingCode;
  }


  public void setAdjustmentRevenueAccountingCode(String adjustmentRevenueAccountingCode) {
    
    
    
    this.adjustmentRevenueAccountingCode = adjustmentRevenueAccountingCode;
  }


  public PreviewOrderChargeOverride billing(PreviewOrderChargeOverrideBilling billing) {
    
    
    
    
    this.billing = billing;
    return this;
  }

   /**
   * Get billing
   * @return billing
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public PreviewOrderChargeOverrideBilling getBilling() {
    return billing;
  }


  public void setBilling(PreviewOrderChargeOverrideBilling billing) {
    
    
    
    this.billing = billing;
  }


  public PreviewOrderChargeOverride chargeModel(String chargeModel) {
    
    
    
    
    this.chargeModel = chargeModel;
    return this;
  }

   /**
   * The chargeModel of a standalone charge. Supported charge models: * &#x60;FlatFee&#x60; * &#x60;PerUnit&#x60; * &#x60;Volume&#x60;  **Note:** This field is available when the &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Manage_subscription_transactions/Orders/Standalone_Orders/AA_Overview_of_Standalone_Orders\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Standalone Orders&lt;/a&gt; feature is enabled. 
   * @return chargeModel
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The chargeModel of a standalone charge. Supported charge models: * `FlatFee` * `PerUnit` * `Volume`  **Note:** This field is available when the <a href=\"https://knowledgecenter.zuora.com/Zuora_Billing/Manage_subscription_transactions/Orders/Standalone_Orders/AA_Overview_of_Standalone_Orders\" target=\"_blank\">Standalone Orders</a> feature is enabled. ")

  public String getChargeModel() {
    return chargeModel;
  }


  public void setChargeModel(String chargeModel) {
    
    
    
    this.chargeModel = chargeModel;
  }


  public PreviewOrderChargeOverride chargeNumber(String chargeNumber) {
    
    
    
    
    this.chargeNumber = chargeNumber;
    return this;
  }

   /**
   * Charge number of the charge. For example, C-00000307.  If you do not set this field, Zuora will generate the charge number. 
   * @return chargeNumber
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Charge number of the charge. For example, C-00000307.  If you do not set this field, Zuora will generate the charge number. ")

  public String getChargeNumber() {
    return chargeNumber;
  }


  public void setChargeNumber(String chargeNumber) {
    
    
    
    this.chargeNumber = chargeNumber;
  }


  public PreviewOrderChargeOverride chargeType(String chargeType) {
    
    
    
    
    this.chargeType = chargeType;
    return this;
  }

   /**
   * The chargeType of a standalone charge. Supported charge types: * &#x60;OneTime&#x60; * &#x60;Recurring&#x60; * &#x60;Usage&#x60; * &#x60;DiscountFixedAmount&#x60; * &#x60;DiscountPercentage&#x60;  **Note:** This field is available when the &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Manage_subscription_transactions/Orders/Standalone_Orders/AA_Overview_of_Standalone_Orders\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Standalone Orders&lt;/a&gt; feature is enabled. 
   * @return chargeType
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The chargeType of a standalone charge. Supported charge types: * `OneTime` * `Recurring` * `Usage` * `DiscountFixedAmount` * `DiscountPercentage`  **Note:** This field is available when the <a href=\"https://knowledgecenter.zuora.com/Zuora_Billing/Manage_subscription_transactions/Orders/Standalone_Orders/AA_Overview_of_Standalone_Orders\" target=\"_blank\">Standalone Orders</a> feature is enabled. ")

  public String getChargeType() {
    return chargeType;
  }


  public void setChargeType(String chargeType) {
    
    
    
    this.chargeType = chargeType;
  }


  public PreviewOrderChargeOverride contractAssetAccountingCode(String contractAssetAccountingCode) {
    
    
    
    
    this.contractAssetAccountingCode = contractAssetAccountingCode;
    return this;
  }

   /**
   * The contractAssetAccountingCode of a standalone charge.  **Note:** This field is available when the &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Manage_subscription_transactions/Orders/Standalone_Orders/AA_Overview_of_Standalone_Orders\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Standalone Orders&lt;/a&gt; feature and the &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Revenue/Zuora_Billing_-_Revenue_Integration\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Billing - Revenue Integration&lt;/a&gt; or &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Enable_Order_to_Revenue/Order_to_Revenue_introduction/AA_Overview_of_Order_to_Revenue\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Order to Revenue&lt;/a&gt; feature are enabled. 
   * @return contractAssetAccountingCode
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The contractAssetAccountingCode of a standalone charge.  **Note:** This field is available when the <a href=\"https://knowledgecenter.zuora.com/Zuora_Billing/Manage_subscription_transactions/Orders/Standalone_Orders/AA_Overview_of_Standalone_Orders\" target=\"_blank\">Standalone Orders</a> feature and the <a href=\"https://knowledgecenter.zuora.com/Zuora_Revenue/Zuora_Billing_-_Revenue_Integration\" target=\"_blank\">Billing - Revenue Integration</a> or <a href=\"https://knowledgecenter.zuora.com/Zuora_Billing/Enable_Order_to_Revenue/Order_to_Revenue_introduction/AA_Overview_of_Order_to_Revenue\" target=\"_blank\">Order to Revenue</a> feature are enabled. ")

  public String getContractAssetAccountingCode() {
    return contractAssetAccountingCode;
  }


  public void setContractAssetAccountingCode(String contractAssetAccountingCode) {
    
    
    
    this.contractAssetAccountingCode = contractAssetAccountingCode;
  }


  public PreviewOrderChargeOverride contractLiabilityAccountingCode(String contractLiabilityAccountingCode) {
    
    
    
    
    this.contractLiabilityAccountingCode = contractLiabilityAccountingCode;
    return this;
  }

   /**
   * The contractLiabilityAccountingCode of a standalone charge.  **Note:** This field is available when the &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Manage_subscription_transactions/Orders/Standalone_Orders/AA_Overview_of_Standalone_Orders\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Standalone Orders&lt;/a&gt; feature and the &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Revenue/Zuora_Billing_-_Revenue_Integration\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Billing - Revenue Integration&lt;/a&gt; or &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Enable_Order_to_Revenue/Order_to_Revenue_introduction/AA_Overview_of_Order_to_Revenue\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Order to Revenue&lt;/a&gt; feature are enabled. 
   * @return contractLiabilityAccountingCode
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The contractLiabilityAccountingCode of a standalone charge.  **Note:** This field is available when the <a href=\"https://knowledgecenter.zuora.com/Zuora_Billing/Manage_subscription_transactions/Orders/Standalone_Orders/AA_Overview_of_Standalone_Orders\" target=\"_blank\">Standalone Orders</a> feature and the <a href=\"https://knowledgecenter.zuora.com/Zuora_Revenue/Zuora_Billing_-_Revenue_Integration\" target=\"_blank\">Billing - Revenue Integration</a> or <a href=\"https://knowledgecenter.zuora.com/Zuora_Billing/Enable_Order_to_Revenue/Order_to_Revenue_introduction/AA_Overview_of_Order_to_Revenue\" target=\"_blank\">Order to Revenue</a> feature are enabled. ")

  public String getContractLiabilityAccountingCode() {
    return contractLiabilityAccountingCode;
  }


  public void setContractLiabilityAccountingCode(String contractLiabilityAccountingCode) {
    
    
    
    this.contractLiabilityAccountingCode = contractLiabilityAccountingCode;
  }


  public PreviewOrderChargeOverride contractRecognizedRevenueAccountingCode(String contractRecognizedRevenueAccountingCode) {
    
    
    
    
    this.contractRecognizedRevenueAccountingCode = contractRecognizedRevenueAccountingCode;
    return this;
  }

   /**
   * The contractRecognizedRevenueAccountingCode of a standalone charge.  **Note:** This field is available when the &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Manage_subscription_transactions/Orders/Standalone_Orders/AA_Overview_of_Standalone_Orders\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Standalone Orders&lt;/a&gt; feature and the &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Revenue/Zuora_Billing_-_Revenue_Integration\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Billing - Revenue Integration&lt;/a&gt; or &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Enable_Order_to_Revenue/Order_to_Revenue_introduction/AA_Overview_of_Order_to_Revenue\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Order to Revenue&lt;/a&gt; feature are enabled. 
   * @return contractRecognizedRevenueAccountingCode
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The contractRecognizedRevenueAccountingCode of a standalone charge.  **Note:** This field is available when the <a href=\"https://knowledgecenter.zuora.com/Zuora_Billing/Manage_subscription_transactions/Orders/Standalone_Orders/AA_Overview_of_Standalone_Orders\" target=\"_blank\">Standalone Orders</a> feature and the <a href=\"https://knowledgecenter.zuora.com/Zuora_Revenue/Zuora_Billing_-_Revenue_Integration\" target=\"_blank\">Billing - Revenue Integration</a> or <a href=\"https://knowledgecenter.zuora.com/Zuora_Billing/Enable_Order_to_Revenue/Order_to_Revenue_introduction/AA_Overview_of_Order_to_Revenue\" target=\"_blank\">Order to Revenue</a> feature are enabled. ")

  public String getContractRecognizedRevenueAccountingCode() {
    return contractRecognizedRevenueAccountingCode;
  }


  public void setContractRecognizedRevenueAccountingCode(String contractRecognizedRevenueAccountingCode) {
    
    
    
    this.contractRecognizedRevenueAccountingCode = contractRecognizedRevenueAccountingCode;
  }


  public PreviewOrderChargeOverride customFields(Map<String, Object> customFields) {
    
    
    
    
    this.customFields = customFields;
    return this;
  }

  public PreviewOrderChargeOverride putCustomFieldsItem(String key, Object customFieldsItem) {
    if (this.customFields == null) {
      this.customFields = new HashMap<>();
    }
    this.customFields.put(key, customFieldsItem);
    return this;
  }

   /**
   * Container for custom fields of a Rate Plan Charge object. 
   * @return customFields
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Container for custom fields of a Rate Plan Charge object. ")

  public Map<String, Object> getCustomFields() {
    return customFields;
  }


  public void setCustomFields(Map<String, Object> customFields) {
    
    
    
    this.customFields = customFields;
  }


  public PreviewOrderChargeOverride deferredRevenueAccountingCode(String deferredRevenueAccountingCode) {
    
    
    
    
    this.deferredRevenueAccountingCode = deferredRevenueAccountingCode;
    return this;
  }

   /**
   * The deferredRevenueAccountingCode of a standalone charge.  **Note:** This field is available when the &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Manage_subscription_transactions/Orders/Standalone_Orders/AA_Overview_of_Standalone_Orders\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Standalone Orders&lt;/a&gt; and &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Payments/Zuora_Finance\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Zuora Finance&lt;/a&gt; features are enabled. 
   * @return deferredRevenueAccountingCode
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The deferredRevenueAccountingCode of a standalone charge.  **Note:** This field is available when the <a href=\"https://knowledgecenter.zuora.com/Zuora_Billing/Manage_subscription_transactions/Orders/Standalone_Orders/AA_Overview_of_Standalone_Orders\" target=\"_blank\">Standalone Orders</a> and <a href=\"https://knowledgecenter.zuora.com/Zuora_Payments/Zuora_Finance\" target=\"_blank\">Zuora Finance</a> features are enabled. ")

  public String getDeferredRevenueAccountingCode() {
    return deferredRevenueAccountingCode;
  }


  public void setDeferredRevenueAccountingCode(String deferredRevenueAccountingCode) {
    
    
    
    this.deferredRevenueAccountingCode = deferredRevenueAccountingCode;
  }


  public PreviewOrderChargeOverride drawdownRate(Double drawdownRate) {
    
    
    
    
    this.drawdownRate = drawdownRate;
    return this;
  }

  public PreviewOrderChargeOverride drawdownRate(Integer drawdownRate) {
    
    
    
    
    this.drawdownRate = drawdownRate.doubleValue();
    return this;
  }

   /**
   * **Note**: This field is only available if you have the [Prepaid with Drawdown](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/J_Billing_Operations/Prepaid_with_Drawdown) feature enabled.  The [conversion rate](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/J_Billing_Operations/Prepaid_with_Drawdown/Create_drawdown_charge#UOM_Conversion) between Usage UOM and Drawdown UOM for a [drawdown charge](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/J_Billing_Operations/Prepaid_with_Drawdown/Create_drawdown_charge). Must be a positive number (&gt;0). 
   * @return drawdownRate
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "**Note**: This field is only available if you have the [Prepaid with Drawdown](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/J_Billing_Operations/Prepaid_with_Drawdown) feature enabled.  The [conversion rate](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/J_Billing_Operations/Prepaid_with_Drawdown/Create_drawdown_charge#UOM_Conversion) between Usage UOM and Drawdown UOM for a [drawdown charge](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/J_Billing_Operations/Prepaid_with_Drawdown/Create_drawdown_charge). Must be a positive number (>0). ")

  public Double getDrawdownRate() {
    return drawdownRate;
  }


  public void setDrawdownRate(Double drawdownRate) {
    
    
    
    this.drawdownRate = drawdownRate;
  }


  public PreviewOrderChargeOverride endDate(EndConditions endDate) {
    
    
    
    
    this.endDate = endDate;
    return this;
  }

   /**
   * Get endDate
   * @return endDate
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public EndConditions getEndDate() {
    return endDate;
  }


  public void setEndDate(EndConditions endDate) {
    
    
    
    this.endDate = endDate;
  }


  public PreviewOrderChargeOverride excludeItemBillingFromRevenueAccounting(Boolean excludeItemBillingFromRevenueAccounting) {
    
    
    
    
    this.excludeItemBillingFromRevenueAccounting = excludeItemBillingFromRevenueAccounting;
    return this;
  }

   /**
   * The flag to exclude rate plan charge related invoice items, invoice item adjustments, credit memo items, and debit memo items from revenue accounting.  If both the following features in &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Bill_your_customers/Bill_for_usage_or_prepaid_products/Advanced_Consumption_Billing\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Advanced Consumption Billing&lt;/a&gt; are enabled in your tenant, you must ensure the &#x60;excludeItemBillingFromRevenueAccounting&#x60; field is set consistently for a prepayment charge and the corresponding drawdown charge. In addition, if the &#x60;excludeItemBookingFromRevenueAccounting&#x60; field in a Create Subscription or Add Product order action is set to &#x60;false&#x60;, you must also set the &#x60;excludeItemBillingFromRevenueAccounting&#x60; field in this order action to &#x60;false&#x60;.   * Prepaid with Drawdown   * Unbilled Usage  **Note**: This field is only available if you have the &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Enable_Order_to_Revenue\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Order to Revenue&lt;/a&gt; or [Zuora Billing - Revenue Integration](https://knowledgecenter.zuora.com/Zuora_Revenue/Zuora_Billing_-_Revenue_Integration) feature enabled. 
   * @return excludeItemBillingFromRevenueAccounting
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "false", value = "The flag to exclude rate plan charge related invoice items, invoice item adjustments, credit memo items, and debit memo items from revenue accounting.  If both the following features in <a href=\"https://knowledgecenter.zuora.com/Zuora_Billing/Bill_your_customers/Bill_for_usage_or_prepaid_products/Advanced_Consumption_Billing\" target=\"_blank\">Advanced Consumption Billing</a> are enabled in your tenant, you must ensure the `excludeItemBillingFromRevenueAccounting` field is set consistently for a prepayment charge and the corresponding drawdown charge. In addition, if the `excludeItemBookingFromRevenueAccounting` field in a Create Subscription or Add Product order action is set to `false`, you must also set the `excludeItemBillingFromRevenueAccounting` field in this order action to `false`.   * Prepaid with Drawdown   * Unbilled Usage  **Note**: This field is only available if you have the <a href=\"https://knowledgecenter.zuora.com/Zuora_Billing/Enable_Order_to_Revenue\" target=\"_blank\">Order to Revenue</a> or [Zuora Billing - Revenue Integration](https://knowledgecenter.zuora.com/Zuora_Revenue/Zuora_Billing_-_Revenue_Integration) feature enabled. ")

  public Boolean getExcludeItemBillingFromRevenueAccounting() {
    return excludeItemBillingFromRevenueAccounting;
  }


  public void setExcludeItemBillingFromRevenueAccounting(Boolean excludeItemBillingFromRevenueAccounting) {
    
    
    
    this.excludeItemBillingFromRevenueAccounting = excludeItemBillingFromRevenueAccounting;
  }


  public PreviewOrderChargeOverride excludeItemBookingFromRevenueAccounting(Boolean excludeItemBookingFromRevenueAccounting) {
    
    
    
    
    this.excludeItemBookingFromRevenueAccounting = excludeItemBookingFromRevenueAccounting;
    return this;
  }

   /**
   * The flag to exclude rate plan charges from revenue accounting.  If both the following features in &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Bill_your_customers/Bill_for_usage_or_prepaid_products/Advanced_Consumption_Billing\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Advanced Consumption Billing&lt;/a&gt; are enabled in your tenant, you must ensure the &#x60;excludeItemBookingFromRevenueAccounting&#x60; field is set consistently for a prepayment charge and the corresponding drawdown charge.   * Prepaid with Drawdown   * Unbilled Usage  **Note**: This field is only available if you have the &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Enable_Order_to_Revenue\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Order to Revenue&lt;/a&gt; or [Zuora Billing - Revenue Integration](https://knowledgecenter.zuora.com/Zuora_Revenue/Zuora_Billing_-_Revenue_Integration) feature enabled. 
   * @return excludeItemBookingFromRevenueAccounting
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "false", value = "The flag to exclude rate plan charges from revenue accounting.  If both the following features in <a href=\"https://knowledgecenter.zuora.com/Zuora_Billing/Bill_your_customers/Bill_for_usage_or_prepaid_products/Advanced_Consumption_Billing\" target=\"_blank\">Advanced Consumption Billing</a> are enabled in your tenant, you must ensure the `excludeItemBookingFromRevenueAccounting` field is set consistently for a prepayment charge and the corresponding drawdown charge.   * Prepaid with Drawdown   * Unbilled Usage  **Note**: This field is only available if you have the <a href=\"https://knowledgecenter.zuora.com/Zuora_Billing/Enable_Order_to_Revenue\" target=\"_blank\">Order to Revenue</a> or [Zuora Billing - Revenue Integration](https://knowledgecenter.zuora.com/Zuora_Revenue/Zuora_Billing_-_Revenue_Integration) feature enabled. ")

  public Boolean getExcludeItemBookingFromRevenueAccounting() {
    return excludeItemBookingFromRevenueAccounting;
  }


  public void setExcludeItemBookingFromRevenueAccounting(Boolean excludeItemBookingFromRevenueAccounting) {
    
    
    
    this.excludeItemBookingFromRevenueAccounting = excludeItemBookingFromRevenueAccounting;
  }


  public PreviewOrderChargeOverride isAllocationEligible(Boolean isAllocationEligible) {
    
    
    
    
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


  public PreviewOrderChargeOverride isRollover(Boolean isRollover) {
    
    
    
    
    this.isRollover = isRollover;
    return this;
  }

   /**
   * **Note**: This field is only available if you have the [Prepaid with Drawdown](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/J_Billing_Operations/Prepaid_with_Drawdown) feature enabled.  The value is either \&quot;True\&quot; or \&quot;False\&quot;. It determines whether the rollover fields are needed. 
   * @return isRollover
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "**Note**: This field is only available if you have the [Prepaid with Drawdown](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/J_Billing_Operations/Prepaid_with_Drawdown) feature enabled.  The value is either \"True\" or \"False\". It determines whether the rollover fields are needed. ")

  public Boolean getIsRollover() {
    return isRollover;
  }


  public void setIsRollover(Boolean isRollover) {
    
    
    
    this.isRollover = isRollover;
  }


  public PreviewOrderChargeOverride isUnbilled(Boolean isUnbilled) {
    
    
    
    
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


  public PreviewOrderChargeOverride name(String name) {
    
    
    
    
    this.name = name;
    return this;
  }

   /**
   * The name of a standalone charge.  **Note:** This field is available when the &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Manage_subscription_transactions/Orders/Standalone_Orders/AA_Overview_of_Standalone_Orders\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Standalone Orders&lt;/a&gt; feature is enabled. 
   * @return name
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The name of a standalone charge.  **Note:** This field is available when the <a href=\"https://knowledgecenter.zuora.com/Zuora_Billing/Manage_subscription_transactions/Orders/Standalone_Orders/AA_Overview_of_Standalone_Orders\" target=\"_blank\">Standalone Orders</a> feature is enabled. ")

  public String getName() {
    return name;
  }


  public void setName(String name) {
    
    
    
    this.name = name;
  }


  public PreviewOrderChargeOverride pobPolicy(String pobPolicy) {
    
    
    
    
    this.pobPolicy = pobPolicy;
    return this;
  }

   /**
   * The pobPolicy of a standalone charge.  **Note:** This field is available when the &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Manage_subscription_transactions/Orders/Standalone_Orders/AA_Overview_of_Standalone_Orders\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Standalone Orders&lt;/a&gt; feature is enabled. 
   * @return pobPolicy
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The pobPolicy of a standalone charge.  **Note:** This field is available when the <a href=\"https://knowledgecenter.zuora.com/Zuora_Billing/Manage_subscription_transactions/Orders/Standalone_Orders/AA_Overview_of_Standalone_Orders\" target=\"_blank\">Standalone Orders</a> feature is enabled. ")

  public String getPobPolicy() {
    return pobPolicy;
  }


  public void setPobPolicy(String pobPolicy) {
    
    
    
    this.pobPolicy = pobPolicy;
  }


  public PreviewOrderChargeOverride prepaidQuantity(Double prepaidQuantity) {
    
    
    
    
    this.prepaidQuantity = prepaidQuantity;
    return this;
  }

  public PreviewOrderChargeOverride prepaidQuantity(Integer prepaidQuantity) {
    
    
    
    
    this.prepaidQuantity = prepaidQuantity.doubleValue();
    return this;
  }

   /**
   * **Note**: This field is only available if you have the [Prepaid with Drawdown](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/J_Billing_Operations/Prepaid_with_Drawdown) feature enabled.  The number of units included in a [prepayment charge](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/J_Billing_Operations/Prepaid_with_Drawdown/Create_prepayment_charge). Must be a positive number (&gt;0). 
   * @return prepaidQuantity
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "**Note**: This field is only available if you have the [Prepaid with Drawdown](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/J_Billing_Operations/Prepaid_with_Drawdown) feature enabled.  The number of units included in a [prepayment charge](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/J_Billing_Operations/Prepaid_with_Drawdown/Create_prepayment_charge). Must be a positive number (>0). ")

  public Double getPrepaidQuantity() {
    return prepaidQuantity;
  }


  public void setPrepaidQuantity(Double prepaidQuantity) {
    
    
    
    this.prepaidQuantity = prepaidQuantity;
  }


  public PreviewOrderChargeOverride pricing(PreviewOrderChargeOverridePricing pricing) {
    
    
    
    
    this.pricing = pricing;
    return this;
  }

   /**
   * Get pricing
   * @return pricing
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public PreviewOrderChargeOverridePricing getPricing() {
    return pricing;
  }


  public void setPricing(PreviewOrderChargeOverridePricing pricing) {
    
    
    
    this.pricing = pricing;
  }


  public PreviewOrderChargeOverride productCategory(String productCategory) {
    
    
    
    
    this.productCategory = productCategory;
    return this;
  }

   /**
   * The productCategory of a standalone charge.  **Note:** This field is available when the &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Manage_subscription_transactions/Orders/Standalone_Orders/AA_Overview_of_Standalone_Orders\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Standalone Orders&lt;/a&gt; feature is enabled. 
   * @return productCategory
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The productCategory of a standalone charge.  **Note:** This field is available when the <a href=\"https://knowledgecenter.zuora.com/Zuora_Billing/Manage_subscription_transactions/Orders/Standalone_Orders/AA_Overview_of_Standalone_Orders\" target=\"_blank\">Standalone Orders</a> feature is enabled. ")

  public String getProductCategory() {
    return productCategory;
  }


  public void setProductCategory(String productCategory) {
    
    
    
    this.productCategory = productCategory;
  }


  public PreviewOrderChargeOverride productClass(String productClass) {
    
    
    
    
    this.productClass = productClass;
    return this;
  }

   /**
   * The productClass of a standalone charge.  **Note:** This field is available when the &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Manage_subscription_transactions/Orders/Standalone_Orders/AA_Overview_of_Standalone_Orders\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Standalone Orders&lt;/a&gt; feature is enabled. 
   * @return productClass
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The productClass of a standalone charge.  **Note:** This field is available when the <a href=\"https://knowledgecenter.zuora.com/Zuora_Billing/Manage_subscription_transactions/Orders/Standalone_Orders/AA_Overview_of_Standalone_Orders\" target=\"_blank\">Standalone Orders</a> feature is enabled. ")

  public String getProductClass() {
    return productClass;
  }


  public void setProductClass(String productClass) {
    
    
    
    this.productClass = productClass;
  }


  public PreviewOrderChargeOverride productFamily(String productFamily) {
    
    
    
    
    this.productFamily = productFamily;
    return this;
  }

   /**
   * The productFamily of a standalone charge.  **Note:** This field is available when the &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Manage_subscription_transactions/Orders/Standalone_Orders/AA_Overview_of_Standalone_Orders\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Standalone Orders&lt;/a&gt; feature is enabled. 
   * @return productFamily
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The productFamily of a standalone charge.  **Note:** This field is available when the <a href=\"https://knowledgecenter.zuora.com/Zuora_Billing/Manage_subscription_transactions/Orders/Standalone_Orders/AA_Overview_of_Standalone_Orders\" target=\"_blank\">Standalone Orders</a> feature is enabled. ")

  public String getProductFamily() {
    return productFamily;
  }


  public void setProductFamily(String productFamily) {
    
    
    
    this.productFamily = productFamily;
  }


  public PreviewOrderChargeOverride productLine(String productLine) {
    
    
    
    
    this.productLine = productLine;
    return this;
  }

   /**
   * The productLine of a standalone charge.  **Note:** This field is available when the &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Manage_subscription_transactions/Orders/Standalone_Orders/AA_Overview_of_Standalone_Orders\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Standalone Orders&lt;/a&gt; feature is enabled. 
   * @return productLine
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The productLine of a standalone charge.  **Note:** This field is available when the <a href=\"https://knowledgecenter.zuora.com/Zuora_Billing/Manage_subscription_transactions/Orders/Standalone_Orders/AA_Overview_of_Standalone_Orders\" target=\"_blank\">Standalone Orders</a> feature is enabled. ")

  public String getProductLine() {
    return productLine;
  }


  public void setProductLine(String productLine) {
    
    
    
    this.productLine = productLine;
  }


  public PreviewOrderChargeOverride productRatePlanChargeId(String productRatePlanChargeId) {
    
    
    
    
    this.productRatePlanChargeId = productRatePlanChargeId;
    return this;
  }

   /**
   * Internal identifier of the product rate plan charge that the charge is based on. 
   * @return productRatePlanChargeId
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "Internal identifier of the product rate plan charge that the charge is based on. ")

  public String getProductRatePlanChargeId() {
    return productRatePlanChargeId;
  }


  public void setProductRatePlanChargeId(String productRatePlanChargeId) {
    
    
    
    this.productRatePlanChargeId = productRatePlanChargeId;
  }


  public PreviewOrderChargeOverride productRatePlanChargeNumber(String productRatePlanChargeNumber) {
    
    
    
    
    this.productRatePlanChargeNumber = productRatePlanChargeNumber;
    return this;
  }

   /**
   * Number of a product rate-plan charge for this subscription. 
   * @return productRatePlanChargeNumber
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Number of a product rate-plan charge for this subscription. ")

  public String getProductRatePlanChargeNumber() {
    return productRatePlanChargeNumber;
  }


  public void setProductRatePlanChargeNumber(String productRatePlanChargeNumber) {
    
    
    
    this.productRatePlanChargeNumber = productRatePlanChargeNumber;
  }


  public PreviewOrderChargeOverride recognizedRevenueAccountingCode(String recognizedRevenueAccountingCode) {
    
    
    
    
    this.recognizedRevenueAccountingCode = recognizedRevenueAccountingCode;
    return this;
  }

   /**
   * The recognizedRevenueAccountingCode of a standalone charge.  **Note:** This field is available when the &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Manage_subscription_transactions/Orders/Standalone_Orders/AA_Overview_of_Standalone_Orders\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Standalone Orders&lt;/a&gt; and &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Payments/Zuora_Finance\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Zuora Finance&lt;/a&gt; features are enabled. 
   * @return recognizedRevenueAccountingCode
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The recognizedRevenueAccountingCode of a standalone charge.  **Note:** This field is available when the <a href=\"https://knowledgecenter.zuora.com/Zuora_Billing/Manage_subscription_transactions/Orders/Standalone_Orders/AA_Overview_of_Standalone_Orders\" target=\"_blank\">Standalone Orders</a> and <a href=\"https://knowledgecenter.zuora.com/Zuora_Payments/Zuora_Finance\" target=\"_blank\">Zuora Finance</a> features are enabled. ")

  public String getRecognizedRevenueAccountingCode() {
    return recognizedRevenueAccountingCode;
  }


  public void setRecognizedRevenueAccountingCode(String recognizedRevenueAccountingCode) {
    
    
    
    this.recognizedRevenueAccountingCode = recognizedRevenueAccountingCode;
  }


  public PreviewOrderChargeOverride revRecCode(String revRecCode) {
    
    
    
    
    this.revRecCode = revRecCode;
    return this;
  }

   /**
   * Revenue Recognition Code 
   * @return revRecCode
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Revenue Recognition Code ")

  public String getRevRecCode() {
    return revRecCode;
  }


  public void setRevRecCode(String revRecCode) {
    
    
    
    this.revRecCode = revRecCode;
  }


  public PreviewOrderChargeOverride revRecTriggerCondition(RevRecTriggerConditionEnum revRecTriggerCondition) {
    
    
    
    
    this.revRecTriggerCondition = revRecTriggerCondition;
    return this;
  }

   /**
   * Specifies the revenue recognition trigger condition.    * &#x60;Contract Effective Date&#x60;    * &#x60;Service Activation Date&#x60;   * &#x60;Customer Acceptance Date&#x60; 
   * @return revRecTriggerCondition
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Specifies the revenue recognition trigger condition.    * `Contract Effective Date`    * `Service Activation Date`   * `Customer Acceptance Date` ")

  public RevRecTriggerConditionEnum getRevRecTriggerCondition() {
    return revRecTriggerCondition;
  }


  public void setRevRecTriggerCondition(RevRecTriggerConditionEnum revRecTriggerCondition) {
    
    
    
    this.revRecTriggerCondition = revRecTriggerCondition;
  }


  public PreviewOrderChargeOverride revenueRecognitionRuleName(String revenueRecognitionRuleName) {
    
    
    
    
    this.revenueRecognitionRuleName = revenueRecognitionRuleName;
    return this;
  }

   /**
   * Specifies the revenue recognition rule, such as &#x60;Recognize upon invoicing&#x60; or &#x60;Recognize daily over time&#x60;. 
   * @return revenueRecognitionRuleName
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Specifies the revenue recognition rule, such as `Recognize upon invoicing` or `Recognize daily over time`. ")

  public String getRevenueRecognitionRuleName() {
    return revenueRecognitionRuleName;
  }


  public void setRevenueRecognitionRuleName(String revenueRecognitionRuleName) {
    
    
    
    this.revenueRecognitionRuleName = revenueRecognitionRuleName;
  }


  public PreviewOrderChargeOverride rolloverApply(RolloverApplyEnum rolloverApply) {
    
    
    
    
    this.rolloverApply = rolloverApply;
    return this;
  }

   /**
   * **Note**: This field is only available if you have the [Prepaid with Drawdown](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/J_Billing_Operations/Prepaid_with_Drawdown) feature enabled.  This field defines the priority of rollover, which is either first or last. 
   * @return rolloverApply
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "**Note**: This field is only available if you have the [Prepaid with Drawdown](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/J_Billing_Operations/Prepaid_with_Drawdown) feature enabled.  This field defines the priority of rollover, which is either first or last. ")

  public RolloverApplyEnum getRolloverApply() {
    return rolloverApply;
  }


  public void setRolloverApply(RolloverApplyEnum rolloverApply) {
    
    
    
    this.rolloverApply = rolloverApply;
  }


  public PreviewOrderChargeOverride rolloverPeriodLength(Integer rolloverPeriodLength) {
    
    
    
    
    this.rolloverPeriodLength = rolloverPeriodLength;
    return this;
  }

   /**
   * **Note**: This field is only available if you have the [Prepaid with Drawdown](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/J_Billing_Operations/Prepaid_with_Drawdown) feature enabled.  The period length of the rollover fund. 
   * @return rolloverPeriodLength
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "**Note**: This field is only available if you have the [Prepaid with Drawdown](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/J_Billing_Operations/Prepaid_with_Drawdown) feature enabled.  The period length of the rollover fund. ")

  public Integer getRolloverPeriodLength() {
    return rolloverPeriodLength;
  }


  public void setRolloverPeriodLength(Integer rolloverPeriodLength) {
    
    
    
    this.rolloverPeriodLength = rolloverPeriodLength;
  }


  public PreviewOrderChargeOverride rolloverPeriods(Double rolloverPeriods) {
    
    
    
    
    this.rolloverPeriods = rolloverPeriods;
    return this;
  }

  public PreviewOrderChargeOverride rolloverPeriods(Integer rolloverPeriods) {
    
    
    
    
    this.rolloverPeriods = rolloverPeriods.doubleValue();
    return this;
  }

   /**
   * **Note**: This field is only available if you have the [Prepaid with Drawdown](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/J_Billing_Operations/Prepaid_with_Drawdown) feature enabled.  This field defines the number of rollover periods, it is restricted to 3. 
   * @return rolloverPeriods
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "**Note**: This field is only available if you have the [Prepaid with Drawdown](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/J_Billing_Operations/Prepaid_with_Drawdown) feature enabled.  This field defines the number of rollover periods, it is restricted to 3. ")

  public Double getRolloverPeriods() {
    return rolloverPeriods;
  }


  public void setRolloverPeriods(Double rolloverPeriods) {
    
    
    
    this.rolloverPeriods = rolloverPeriods;
  }


  public PreviewOrderChargeOverride startDate(PreviewOrderTriggerParams startDate) {
    
    
    
    
    this.startDate = startDate;
    return this;
  }

   /**
   * Get startDate
   * @return startDate
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public PreviewOrderTriggerParams getStartDate() {
    return startDate;
  }


  public void setStartDate(PreviewOrderTriggerParams startDate) {
    
    
    
    this.startDate = startDate;
  }


  public PreviewOrderChargeOverride taxCode(String taxCode) {
    
    
    
    
    this.taxCode = taxCode;
    return this;
  }

   /**
   * The taxCode of a standalone charge.  **Note:** This field is available when the &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Manage_subscription_transactions/Orders/Standalone_Orders/AA_Overview_of_Standalone_Orders\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Standalone Orders&lt;/a&gt; feature is enabled. 
   * @return taxCode
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The taxCode of a standalone charge.  **Note:** This field is available when the <a href=\"https://knowledgecenter.zuora.com/Zuora_Billing/Manage_subscription_transactions/Orders/Standalone_Orders/AA_Overview_of_Standalone_Orders\" target=\"_blank\">Standalone Orders</a> feature is enabled. ")

  public String getTaxCode() {
    return taxCode;
  }


  public void setTaxCode(String taxCode) {
    
    
    
    this.taxCode = taxCode;
  }


  public PreviewOrderChargeOverride taxMode(String taxMode) {
    
    
    
    
    this.taxMode = taxMode;
    return this;
  }

   /**
   * The taxMode of a standalone charge.  Values: * &#x60;TaxExclusive&#x60; * &#x60;TaxInclusive&#x60;  **Note:** This field is available when the &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Manage_subscription_transactions/Orders/Standalone_Orders/AA_Overview_of_Standalone_Orders\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Standalone Orders&lt;/a&gt; feature is enabled. 
   * @return taxMode
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The taxMode of a standalone charge.  Values: * `TaxExclusive` * `TaxInclusive`  **Note:** This field is available when the <a href=\"https://knowledgecenter.zuora.com/Zuora_Billing/Manage_subscription_transactions/Orders/Standalone_Orders/AA_Overview_of_Standalone_Orders\" target=\"_blank\">Standalone Orders</a> feature is enabled. ")

  public String getTaxMode() {
    return taxMode;
  }


  public void setTaxMode(String taxMode) {
    
    
    
    this.taxMode = taxMode;
  }


  public PreviewOrderChargeOverride unBilledReceivablesAccountingCode(String unBilledReceivablesAccountingCode) {
    
    
    
    
    this.unBilledReceivablesAccountingCode = unBilledReceivablesAccountingCode;
    return this;
  }

   /**
   * The unBilledReceivablesAccountingCode of a standalone charge.  **Note:** This field is available when the &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Manage_subscription_transactions/Orders/Standalone_Orders/AA_Overview_of_Standalone_Orders\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Standalone Orders&lt;/a&gt; feature and the &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Revenue/Zuora_Billing_-_Revenue_Integration\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Billing - Revenue Integration&lt;/a&gt; or &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Enable_Order_to_Revenue/Order_to_Revenue_introduction/AA_Overview_of_Order_to_Revenue\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Order to Revenue&lt;/a&gt; feature are enabled. 
   * @return unBilledReceivablesAccountingCode
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The unBilledReceivablesAccountingCode of a standalone charge.  **Note:** This field is available when the <a href=\"https://knowledgecenter.zuora.com/Zuora_Billing/Manage_subscription_transactions/Orders/Standalone_Orders/AA_Overview_of_Standalone_Orders\" target=\"_blank\">Standalone Orders</a> feature and the <a href=\"https://knowledgecenter.zuora.com/Zuora_Revenue/Zuora_Billing_-_Revenue_Integration\" target=\"_blank\">Billing - Revenue Integration</a> or <a href=\"https://knowledgecenter.zuora.com/Zuora_Billing/Enable_Order_to_Revenue/Order_to_Revenue_introduction/AA_Overview_of_Order_to_Revenue\" target=\"_blank\">Order to Revenue</a> feature are enabled. ")

  public String getUnBilledReceivablesAccountingCode() {
    return unBilledReceivablesAccountingCode;
  }


  public void setUnBilledReceivablesAccountingCode(String unBilledReceivablesAccountingCode) {
    
    
    
    this.unBilledReceivablesAccountingCode = unBilledReceivablesAccountingCode;
  }


  public PreviewOrderChargeOverride uniqueToken(String uniqueToken) {
    
    
    
    
    this.uniqueToken = uniqueToken;
    return this;
  }

   /**
   * Unique identifier for the charge. This identifier enables you to refer to the charge before the charge has an internal identifier in Zuora.  For instance, suppose that you want to use a single order to add a product to a subscription and later update the same product. When you add the product, you can set a unique identifier for the charge. Then when you update the product, you can use the same unique identifier to specify which charge to modify. 
   * @return uniqueToken
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Unique identifier for the charge. This identifier enables you to refer to the charge before the charge has an internal identifier in Zuora.  For instance, suppose that you want to use a single order to add a product to a subscription and later update the same product. When you add the product, you can set a unique identifier for the charge. Then when you update the product, you can use the same unique identifier to specify which charge to modify. ")

  public String getUniqueToken() {
    return uniqueToken;
  }


  public void setUniqueToken(String uniqueToken) {
    
    
    
    this.uniqueToken = uniqueToken;
  }


  public PreviewOrderChargeOverride upsellOriginChargeNumber(String upsellOriginChargeNumber) {
    
    
    
    
    this.upsellOriginChargeNumber = upsellOriginChargeNumber;
    return this;
  }

   /**
   * The identifier of the original upselling charge associated with the current charge.  For a termed subscription, you can now use the \&quot;Create an order\&quot; API operation to perform an Add Product order action to make a product quantity upsell for per unit recurring charges. The benefit is that the charge added by this approach will be automatically combined with the original existing charge for which you want to upsell when the subscription is renewed. The approach is as follows: * Use an Add Product order action to add a charge that is of the same charge type, charge model, and charge end date as the existing per unit recurring charge for which you want to make a quantity upsell.  * In the preceding charge to add, use the &#x60;upsellOriginChargeNumber&#x60; field to specify the existing rate plan charge for which you want to make the quantity upsell.  Note that a termed subscription with such upsell charges can not be changed to an evergreen subscription.     **Note**: The Quantity Upsell feature is in the **Early Adopter** phase. We are actively soliciting feedback from a small set of early adopters before releasing it as generally available. If you want to join this early adopter program, submit a request at [Zuora Global   Support](https://support.zuora.com).   
   * @return upsellOriginChargeNumber
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The identifier of the original upselling charge associated with the current charge.  For a termed subscription, you can now use the \"Create an order\" API operation to perform an Add Product order action to make a product quantity upsell for per unit recurring charges. The benefit is that the charge added by this approach will be automatically combined with the original existing charge for which you want to upsell when the subscription is renewed. The approach is as follows: * Use an Add Product order action to add a charge that is of the same charge type, charge model, and charge end date as the existing per unit recurring charge for which you want to make a quantity upsell.  * In the preceding charge to add, use the `upsellOriginChargeNumber` field to specify the existing rate plan charge for which you want to make the quantity upsell.  Note that a termed subscription with such upsell charges can not be changed to an evergreen subscription.     **Note**: The Quantity Upsell feature is in the **Early Adopter** phase. We are actively soliciting feedback from a small set of early adopters before releasing it as generally available. If you want to join this early adopter program, submit a request at [Zuora Global   Support](https://support.zuora.com).   ")

  public String getUpsellOriginChargeNumber() {
    return upsellOriginChargeNumber;
  }


  public void setUpsellOriginChargeNumber(String upsellOriginChargeNumber) {
    
    
    
    this.upsellOriginChargeNumber = upsellOriginChargeNumber;
  }


  public PreviewOrderChargeOverride validityPeriodType(ValidityPeriodTypeEnum validityPeriodType) {
    
    
    
    
    this.validityPeriodType = validityPeriodType;
    return this;
  }

   /**
   * **Note**: This field is only available if you have the [Prepaid with Drawdown](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/J_Billing_Operations/Prepaid_with_Drawdown) feature enabled.  The period in which the prepayment units are valid to use as defined in a [prepayment charge](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/J_Billing_Operations/Prepaid_with_Drawdown/Create_prepayment_charge).       
   * @return validityPeriodType
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "**Note**: This field is only available if you have the [Prepaid with Drawdown](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/J_Billing_Operations/Prepaid_with_Drawdown) feature enabled.  The period in which the prepayment units are valid to use as defined in a [prepayment charge](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/J_Billing_Operations/Prepaid_with_Drawdown/Create_prepayment_charge).       ")

  public ValidityPeriodTypeEnum getValidityPeriodType() {
    return validityPeriodType;
  }


  public void setValidityPeriodType(ValidityPeriodTypeEnum validityPeriodType) {
    
    
    
    this.validityPeriodType = validityPeriodType;
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
   * @return the PreviewOrderChargeOverride instance itself
   */
  public PreviewOrderChargeOverride putAdditionalProperty(String key, Object value) {
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
    PreviewOrderChargeOverride previewOrderChargeOverride = (PreviewOrderChargeOverride) o;
    return Objects.equals(this.description, previewOrderChargeOverride.description) &&
        Objects.equals(this.accountReceivableAccountingCode, previewOrderChargeOverride.accountReceivableAccountingCode) &&
        Objects.equals(this.adjustmentLiabilityAccountingCode, previewOrderChargeOverride.adjustmentLiabilityAccountingCode) &&
        Objects.equals(this.adjustmentRevenueAccountingCode, previewOrderChargeOverride.adjustmentRevenueAccountingCode) &&
        Objects.equals(this.billing, previewOrderChargeOverride.billing) &&
        Objects.equals(this.chargeModel, previewOrderChargeOverride.chargeModel) &&
        Objects.equals(this.chargeNumber, previewOrderChargeOverride.chargeNumber) &&
        Objects.equals(this.chargeType, previewOrderChargeOverride.chargeType) &&
        Objects.equals(this.contractAssetAccountingCode, previewOrderChargeOverride.contractAssetAccountingCode) &&
        Objects.equals(this.contractLiabilityAccountingCode, previewOrderChargeOverride.contractLiabilityAccountingCode) &&
        Objects.equals(this.contractRecognizedRevenueAccountingCode, previewOrderChargeOverride.contractRecognizedRevenueAccountingCode) &&
        Objects.equals(this.customFields, previewOrderChargeOverride.customFields) &&
        Objects.equals(this.deferredRevenueAccountingCode, previewOrderChargeOverride.deferredRevenueAccountingCode) &&
        Objects.equals(this.drawdownRate, previewOrderChargeOverride.drawdownRate) &&
        Objects.equals(this.endDate, previewOrderChargeOverride.endDate) &&
        Objects.equals(this.excludeItemBillingFromRevenueAccounting, previewOrderChargeOverride.excludeItemBillingFromRevenueAccounting) &&
        Objects.equals(this.excludeItemBookingFromRevenueAccounting, previewOrderChargeOverride.excludeItemBookingFromRevenueAccounting) &&
        Objects.equals(this.isAllocationEligible, previewOrderChargeOverride.isAllocationEligible) &&
        Objects.equals(this.isRollover, previewOrderChargeOverride.isRollover) &&
        Objects.equals(this.isUnbilled, previewOrderChargeOverride.isUnbilled) &&
        Objects.equals(this.name, previewOrderChargeOverride.name) &&
        Objects.equals(this.pobPolicy, previewOrderChargeOverride.pobPolicy) &&
        Objects.equals(this.prepaidQuantity, previewOrderChargeOverride.prepaidQuantity) &&
        Objects.equals(this.pricing, previewOrderChargeOverride.pricing) &&
        Objects.equals(this.productCategory, previewOrderChargeOverride.productCategory) &&
        Objects.equals(this.productClass, previewOrderChargeOverride.productClass) &&
        Objects.equals(this.productFamily, previewOrderChargeOverride.productFamily) &&
        Objects.equals(this.productLine, previewOrderChargeOverride.productLine) &&
        Objects.equals(this.productRatePlanChargeId, previewOrderChargeOverride.productRatePlanChargeId) &&
        Objects.equals(this.productRatePlanChargeNumber, previewOrderChargeOverride.productRatePlanChargeNumber) &&
        Objects.equals(this.recognizedRevenueAccountingCode, previewOrderChargeOverride.recognizedRevenueAccountingCode) &&
        Objects.equals(this.revRecCode, previewOrderChargeOverride.revRecCode) &&
        Objects.equals(this.revRecTriggerCondition, previewOrderChargeOverride.revRecTriggerCondition) &&
        Objects.equals(this.revenueRecognitionRuleName, previewOrderChargeOverride.revenueRecognitionRuleName) &&
        Objects.equals(this.rolloverApply, previewOrderChargeOverride.rolloverApply) &&
        Objects.equals(this.rolloverPeriodLength, previewOrderChargeOverride.rolloverPeriodLength) &&
        Objects.equals(this.rolloverPeriods, previewOrderChargeOverride.rolloverPeriods) &&
        Objects.equals(this.startDate, previewOrderChargeOverride.startDate) &&
        Objects.equals(this.taxCode, previewOrderChargeOverride.taxCode) &&
        Objects.equals(this.taxMode, previewOrderChargeOverride.taxMode) &&
        Objects.equals(this.unBilledReceivablesAccountingCode, previewOrderChargeOverride.unBilledReceivablesAccountingCode) &&
        Objects.equals(this.uniqueToken, previewOrderChargeOverride.uniqueToken) &&
        Objects.equals(this.upsellOriginChargeNumber, previewOrderChargeOverride.upsellOriginChargeNumber) &&
        Objects.equals(this.validityPeriodType, previewOrderChargeOverride.validityPeriodType)&&
        Objects.equals(this.additionalProperties, previewOrderChargeOverride.additionalProperties);
  }

  @Override
  public int hashCode() {
    return Objects.hash(description, accountReceivableAccountingCode, adjustmentLiabilityAccountingCode, adjustmentRevenueAccountingCode, billing, chargeModel, chargeNumber, chargeType, contractAssetAccountingCode, contractLiabilityAccountingCode, contractRecognizedRevenueAccountingCode, customFields, deferredRevenueAccountingCode, drawdownRate, endDate, excludeItemBillingFromRevenueAccounting, excludeItemBookingFromRevenueAccounting, isAllocationEligible, isRollover, isUnbilled, name, pobPolicy, prepaidQuantity, pricing, productCategory, productClass, productFamily, productLine, productRatePlanChargeId, productRatePlanChargeNumber, recognizedRevenueAccountingCode, revRecCode, revRecTriggerCondition, revenueRecognitionRuleName, rolloverApply, rolloverPeriodLength, rolloverPeriods, startDate, taxCode, taxMode, unBilledReceivablesAccountingCode, uniqueToken, upsellOriginChargeNumber, validityPeriodType, additionalProperties);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PreviewOrderChargeOverride {\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    accountReceivableAccountingCode: ").append(toIndentedString(accountReceivableAccountingCode)).append("\n");
    sb.append("    adjustmentLiabilityAccountingCode: ").append(toIndentedString(adjustmentLiabilityAccountingCode)).append("\n");
    sb.append("    adjustmentRevenueAccountingCode: ").append(toIndentedString(adjustmentRevenueAccountingCode)).append("\n");
    sb.append("    billing: ").append(toIndentedString(billing)).append("\n");
    sb.append("    chargeModel: ").append(toIndentedString(chargeModel)).append("\n");
    sb.append("    chargeNumber: ").append(toIndentedString(chargeNumber)).append("\n");
    sb.append("    chargeType: ").append(toIndentedString(chargeType)).append("\n");
    sb.append("    contractAssetAccountingCode: ").append(toIndentedString(contractAssetAccountingCode)).append("\n");
    sb.append("    contractLiabilityAccountingCode: ").append(toIndentedString(contractLiabilityAccountingCode)).append("\n");
    sb.append("    contractRecognizedRevenueAccountingCode: ").append(toIndentedString(contractRecognizedRevenueAccountingCode)).append("\n");
    sb.append("    customFields: ").append(toIndentedString(customFields)).append("\n");
    sb.append("    deferredRevenueAccountingCode: ").append(toIndentedString(deferredRevenueAccountingCode)).append("\n");
    sb.append("    drawdownRate: ").append(toIndentedString(drawdownRate)).append("\n");
    sb.append("    endDate: ").append(toIndentedString(endDate)).append("\n");
    sb.append("    excludeItemBillingFromRevenueAccounting: ").append(toIndentedString(excludeItemBillingFromRevenueAccounting)).append("\n");
    sb.append("    excludeItemBookingFromRevenueAccounting: ").append(toIndentedString(excludeItemBookingFromRevenueAccounting)).append("\n");
    sb.append("    isAllocationEligible: ").append(toIndentedString(isAllocationEligible)).append("\n");
    sb.append("    isRollover: ").append(toIndentedString(isRollover)).append("\n");
    sb.append("    isUnbilled: ").append(toIndentedString(isUnbilled)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    pobPolicy: ").append(toIndentedString(pobPolicy)).append("\n");
    sb.append("    prepaidQuantity: ").append(toIndentedString(prepaidQuantity)).append("\n");
    sb.append("    pricing: ").append(toIndentedString(pricing)).append("\n");
    sb.append("    productCategory: ").append(toIndentedString(productCategory)).append("\n");
    sb.append("    productClass: ").append(toIndentedString(productClass)).append("\n");
    sb.append("    productFamily: ").append(toIndentedString(productFamily)).append("\n");
    sb.append("    productLine: ").append(toIndentedString(productLine)).append("\n");
    sb.append("    productRatePlanChargeId: ").append(toIndentedString(productRatePlanChargeId)).append("\n");
    sb.append("    productRatePlanChargeNumber: ").append(toIndentedString(productRatePlanChargeNumber)).append("\n");
    sb.append("    recognizedRevenueAccountingCode: ").append(toIndentedString(recognizedRevenueAccountingCode)).append("\n");
    sb.append("    revRecCode: ").append(toIndentedString(revRecCode)).append("\n");
    sb.append("    revRecTriggerCondition: ").append(toIndentedString(revRecTriggerCondition)).append("\n");
    sb.append("    revenueRecognitionRuleName: ").append(toIndentedString(revenueRecognitionRuleName)).append("\n");
    sb.append("    rolloverApply: ").append(toIndentedString(rolloverApply)).append("\n");
    sb.append("    rolloverPeriodLength: ").append(toIndentedString(rolloverPeriodLength)).append("\n");
    sb.append("    rolloverPeriods: ").append(toIndentedString(rolloverPeriods)).append("\n");
    sb.append("    startDate: ").append(toIndentedString(startDate)).append("\n");
    sb.append("    taxCode: ").append(toIndentedString(taxCode)).append("\n");
    sb.append("    taxMode: ").append(toIndentedString(taxMode)).append("\n");
    sb.append("    unBilledReceivablesAccountingCode: ").append(toIndentedString(unBilledReceivablesAccountingCode)).append("\n");
    sb.append("    uniqueToken: ").append(toIndentedString(uniqueToken)).append("\n");
    sb.append("    upsellOriginChargeNumber: ").append(toIndentedString(upsellOriginChargeNumber)).append("\n");
    sb.append("    validityPeriodType: ").append(toIndentedString(validityPeriodType)).append("\n");
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
    openapiFields.add("accountReceivableAccountingCode");
    openapiFields.add("adjustmentLiabilityAccountingCode");
    openapiFields.add("adjustmentRevenueAccountingCode");
    openapiFields.add("billing");
    openapiFields.add("chargeModel");
    openapiFields.add("chargeNumber");
    openapiFields.add("chargeType");
    openapiFields.add("contractAssetAccountingCode");
    openapiFields.add("contractLiabilityAccountingCode");
    openapiFields.add("contractRecognizedRevenueAccountingCode");
    openapiFields.add("customFields");
    openapiFields.add("deferredRevenueAccountingCode");
    openapiFields.add("drawdownRate");
    openapiFields.add("endDate");
    openapiFields.add("excludeItemBillingFromRevenueAccounting");
    openapiFields.add("excludeItemBookingFromRevenueAccounting");
    openapiFields.add("isAllocationEligible");
    openapiFields.add("isRollover");
    openapiFields.add("isUnbilled");
    openapiFields.add("name");
    openapiFields.add("pobPolicy");
    openapiFields.add("prepaidQuantity");
    openapiFields.add("pricing");
    openapiFields.add("productCategory");
    openapiFields.add("productClass");
    openapiFields.add("productFamily");
    openapiFields.add("productLine");
    openapiFields.add("productRatePlanChargeId");
    openapiFields.add("productRatePlanChargeNumber");
    openapiFields.add("recognizedRevenueAccountingCode");
    openapiFields.add("revRecCode");
    openapiFields.add("revRecTriggerCondition");
    openapiFields.add("revenueRecognitionRuleName");
    openapiFields.add("rolloverApply");
    openapiFields.add("rolloverPeriodLength");
    openapiFields.add("rolloverPeriods");
    openapiFields.add("startDate");
    openapiFields.add("taxCode");
    openapiFields.add("taxMode");
    openapiFields.add("unBilledReceivablesAccountingCode");
    openapiFields.add("uniqueToken");
    openapiFields.add("upsellOriginChargeNumber");
    openapiFields.add("validityPeriodType");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
    openapiRequiredFields.add("productRatePlanChargeId");
  }

 /**
  * Validates the JSON Object and throws an exception if issues found
  *
  * @param jsonObj JSON Object
  * @throws IOException if the JSON Object is invalid with respect to PreviewOrderChargeOverride
  */
  public static void validateJsonObject(JsonObject jsonObj) throws IOException {
      if (jsonObj == null) {
        if (!PreviewOrderChargeOverride.openapiRequiredFields.isEmpty()) { // has required fields but JSON object is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in PreviewOrderChargeOverride is not found in the empty JSON string", PreviewOrderChargeOverride.openapiRequiredFields.toString()));
        }
      }

      // check to make sure all required properties/fields are present in the JSON string
      for (String requiredField : PreviewOrderChargeOverride.openapiRequiredFields) {
        if (jsonObj.get(requiredField) == null) {
          throw new IllegalArgumentException(String.format("The required field `%s` is not found in the JSON string: %s", requiredField, jsonObj.toString()));
        }
      }
      if ((jsonObj.get("description") != null && !jsonObj.get("description").isJsonNull()) && !jsonObj.get("description").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `description` to be a primitive type in the JSON string but got `%s`", jsonObj.get("description").toString()));
      }
      if ((jsonObj.get("accountReceivableAccountingCode") != null && !jsonObj.get("accountReceivableAccountingCode").isJsonNull()) && !jsonObj.get("accountReceivableAccountingCode").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `accountReceivableAccountingCode` to be a primitive type in the JSON string but got `%s`", jsonObj.get("accountReceivableAccountingCode").toString()));
      }
      if ((jsonObj.get("adjustmentLiabilityAccountingCode") != null && !jsonObj.get("adjustmentLiabilityAccountingCode").isJsonNull()) && !jsonObj.get("adjustmentLiabilityAccountingCode").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `adjustmentLiabilityAccountingCode` to be a primitive type in the JSON string but got `%s`", jsonObj.get("adjustmentLiabilityAccountingCode").toString()));
      }
      if ((jsonObj.get("adjustmentRevenueAccountingCode") != null && !jsonObj.get("adjustmentRevenueAccountingCode").isJsonNull()) && !jsonObj.get("adjustmentRevenueAccountingCode").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `adjustmentRevenueAccountingCode` to be a primitive type in the JSON string but got `%s`", jsonObj.get("adjustmentRevenueAccountingCode").toString()));
      }
      // validate the optional field `billing`
      if (jsonObj.get("billing") != null && !jsonObj.get("billing").isJsonNull()) {
        PreviewOrderChargeOverrideBilling.validateJsonObject(jsonObj.getAsJsonObject("billing"));
      }
      if ((jsonObj.get("chargeModel") != null && !jsonObj.get("chargeModel").isJsonNull()) && !jsonObj.get("chargeModel").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `chargeModel` to be a primitive type in the JSON string but got `%s`", jsonObj.get("chargeModel").toString()));
      }
      if ((jsonObj.get("chargeNumber") != null && !jsonObj.get("chargeNumber").isJsonNull()) && !jsonObj.get("chargeNumber").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `chargeNumber` to be a primitive type in the JSON string but got `%s`", jsonObj.get("chargeNumber").toString()));
      }
      if ((jsonObj.get("chargeType") != null && !jsonObj.get("chargeType").isJsonNull()) && !jsonObj.get("chargeType").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `chargeType` to be a primitive type in the JSON string but got `%s`", jsonObj.get("chargeType").toString()));
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
      // validate the optional field `endDate`
      if (jsonObj.get("endDate") != null && !jsonObj.get("endDate").isJsonNull()) {
        EndConditions.validateJsonObject(jsonObj.getAsJsonObject("endDate"));
      }
      if ((jsonObj.get("name") != null && !jsonObj.get("name").isJsonNull()) && !jsonObj.get("name").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `name` to be a primitive type in the JSON string but got `%s`", jsonObj.get("name").toString()));
      }
      if ((jsonObj.get("pobPolicy") != null && !jsonObj.get("pobPolicy").isJsonNull()) && !jsonObj.get("pobPolicy").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `pobPolicy` to be a primitive type in the JSON string but got `%s`", jsonObj.get("pobPolicy").toString()));
      }
      // validate the optional field `pricing`
      if (jsonObj.get("pricing") != null && !jsonObj.get("pricing").isJsonNull()) {
        PreviewOrderChargeOverridePricing.validateJsonObject(jsonObj.getAsJsonObject("pricing"));
      }
      if ((jsonObj.get("productCategory") != null && !jsonObj.get("productCategory").isJsonNull()) && !jsonObj.get("productCategory").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `productCategory` to be a primitive type in the JSON string but got `%s`", jsonObj.get("productCategory").toString()));
      }
      if ((jsonObj.get("productClass") != null && !jsonObj.get("productClass").isJsonNull()) && !jsonObj.get("productClass").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `productClass` to be a primitive type in the JSON string but got `%s`", jsonObj.get("productClass").toString()));
      }
      if ((jsonObj.get("productFamily") != null && !jsonObj.get("productFamily").isJsonNull()) && !jsonObj.get("productFamily").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `productFamily` to be a primitive type in the JSON string but got `%s`", jsonObj.get("productFamily").toString()));
      }
      if ((jsonObj.get("productLine") != null && !jsonObj.get("productLine").isJsonNull()) && !jsonObj.get("productLine").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `productLine` to be a primitive type in the JSON string but got `%s`", jsonObj.get("productLine").toString()));
      }
      if (!jsonObj.get("productRatePlanChargeId").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `productRatePlanChargeId` to be a primitive type in the JSON string but got `%s`", jsonObj.get("productRatePlanChargeId").toString()));
      }
      if ((jsonObj.get("productRatePlanChargeNumber") != null && !jsonObj.get("productRatePlanChargeNumber").isJsonNull()) && !jsonObj.get("productRatePlanChargeNumber").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `productRatePlanChargeNumber` to be a primitive type in the JSON string but got `%s`", jsonObj.get("productRatePlanChargeNumber").toString()));
      }
      if ((jsonObj.get("recognizedRevenueAccountingCode") != null && !jsonObj.get("recognizedRevenueAccountingCode").isJsonNull()) && !jsonObj.get("recognizedRevenueAccountingCode").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `recognizedRevenueAccountingCode` to be a primitive type in the JSON string but got `%s`", jsonObj.get("recognizedRevenueAccountingCode").toString()));
      }
      if ((jsonObj.get("revRecCode") != null && !jsonObj.get("revRecCode").isJsonNull()) && !jsonObj.get("revRecCode").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `revRecCode` to be a primitive type in the JSON string but got `%s`", jsonObj.get("revRecCode").toString()));
      }
      if ((jsonObj.get("revRecTriggerCondition") != null && !jsonObj.get("revRecTriggerCondition").isJsonNull()) && !jsonObj.get("revRecTriggerCondition").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `revRecTriggerCondition` to be a primitive type in the JSON string but got `%s`", jsonObj.get("revRecTriggerCondition").toString()));
      }
      if ((jsonObj.get("revenueRecognitionRuleName") != null && !jsonObj.get("revenueRecognitionRuleName").isJsonNull()) && !jsonObj.get("revenueRecognitionRuleName").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `revenueRecognitionRuleName` to be a primitive type in the JSON string but got `%s`", jsonObj.get("revenueRecognitionRuleName").toString()));
      }
      if ((jsonObj.get("rolloverApply") != null && !jsonObj.get("rolloverApply").isJsonNull()) && !jsonObj.get("rolloverApply").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `rolloverApply` to be a primitive type in the JSON string but got `%s`", jsonObj.get("rolloverApply").toString()));
      }
      // validate the optional field `startDate`
      if (jsonObj.get("startDate") != null && !jsonObj.get("startDate").isJsonNull()) {
        PreviewOrderTriggerParams.validateJsonObject(jsonObj.getAsJsonObject("startDate"));
      }
      if ((jsonObj.get("taxCode") != null && !jsonObj.get("taxCode").isJsonNull()) && !jsonObj.get("taxCode").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `taxCode` to be a primitive type in the JSON string but got `%s`", jsonObj.get("taxCode").toString()));
      }
      if ((jsonObj.get("taxMode") != null && !jsonObj.get("taxMode").isJsonNull()) && !jsonObj.get("taxMode").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `taxMode` to be a primitive type in the JSON string but got `%s`", jsonObj.get("taxMode").toString()));
      }
      if ((jsonObj.get("unBilledReceivablesAccountingCode") != null && !jsonObj.get("unBilledReceivablesAccountingCode").isJsonNull()) && !jsonObj.get("unBilledReceivablesAccountingCode").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `unBilledReceivablesAccountingCode` to be a primitive type in the JSON string but got `%s`", jsonObj.get("unBilledReceivablesAccountingCode").toString()));
      }
      if ((jsonObj.get("uniqueToken") != null && !jsonObj.get("uniqueToken").isJsonNull()) && !jsonObj.get("uniqueToken").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `uniqueToken` to be a primitive type in the JSON string but got `%s`", jsonObj.get("uniqueToken").toString()));
      }
      if ((jsonObj.get("upsellOriginChargeNumber") != null && !jsonObj.get("upsellOriginChargeNumber").isJsonNull()) && !jsonObj.get("upsellOriginChargeNumber").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `upsellOriginChargeNumber` to be a primitive type in the JSON string but got `%s`", jsonObj.get("upsellOriginChargeNumber").toString()));
      }
      if ((jsonObj.get("validityPeriodType") != null && !jsonObj.get("validityPeriodType").isJsonNull()) && !jsonObj.get("validityPeriodType").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `validityPeriodType` to be a primitive type in the JSON string but got `%s`", jsonObj.get("validityPeriodType").toString()));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!PreviewOrderChargeOverride.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'PreviewOrderChargeOverride' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<PreviewOrderChargeOverride> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(PreviewOrderChargeOverride.class));

       return (TypeAdapter<T>) new TypeAdapter<PreviewOrderChargeOverride>() {
           @Override
           public void write(JsonWriter out, PreviewOrderChargeOverride value) throws IOException {
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
           public PreviewOrderChargeOverride read(JsonReader in) throws IOException {
             JsonObject jsonObj = elementAdapter.read(in).getAsJsonObject();
             validateJsonObject(jsonObj);
             // store additional fields in the deserialized instance
             PreviewOrderChargeOverride instance = thisAdapter.fromJsonTree(jsonObj);
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
  * Create an instance of PreviewOrderChargeOverride given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of PreviewOrderChargeOverride
  * @throws IOException if the JSON string is invalid with respect to PreviewOrderChargeOverride
  */
  public static PreviewOrderChargeOverride fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, PreviewOrderChargeOverride.class);
  }

 /**
  * Convert an instance of PreviewOrderChargeOverride to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

