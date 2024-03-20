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
import com.konfigthis.client.model.ProxyCreateOrModifyDeliverySchedule;
import com.konfigthis.client.model.ProxyCreateOrModifyProductRatePlanChargeChargeModelConfiguration;
import com.konfigthis.client.model.ProxyCreateOrModifyProductRatePlanChargeTierData;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
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
 * ProxyCreateProductRatePlanCharge
 */@javax.annotation.Generated(value = "Generated by https://konfigthis.com")
public class ProxyCreateProductRatePlanCharge {
  public static final String SERIALIZED_NAME_ACCOUNTING_CODE = "AccountingCode";
  @SerializedName(SERIALIZED_NAME_ACCOUNTING_CODE)
  private String accountingCode;

  /**
   * Specifies the type of charges that you want a specific discount to apply to. All field values are case sensitive and in all-caps. 
   */
  @JsonAdapter(ApplyDiscountToEnum.Adapter.class)
 public enum ApplyDiscountToEnum {
    ONETIME_1_("ONETIME (1)"),
    
    RECURRING_2_("RECURRING (2)"),
    
    USAGE_4_("USAGE (4)"),
    
    ONETIMERECURRING_3_("ONETIMERECURRING (3)"),
    
    ONETIMEUSAGE_5_("ONETIMEUSAGE (5)"),
    
    RECURRINGUSAGE_6_("RECURRINGUSAGE (6)"),
    
    ONETIMERECURRINGUSAGE_7_("ONETIMERECURRINGUSAGE (7)");

    private String value;

    ApplyDiscountToEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static ApplyDiscountToEnum fromValue(String value) {
      for (ApplyDiscountToEnum b : ApplyDiscountToEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<ApplyDiscountToEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final ApplyDiscountToEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public ApplyDiscountToEnum read(final JsonReader jsonReader) throws IOException {
        String value =  jsonReader.nextString();
        return ApplyDiscountToEnum.fromValue(value);
      }
    }
  }

  public static final String SERIALIZED_NAME_APPLY_DISCOUNT_TO = "ApplyDiscountTo";
  @SerializedName(SERIALIZED_NAME_APPLY_DISCOUNT_TO)
  private ApplyDiscountToEnum applyDiscountTo;

  public static final String SERIALIZED_NAME_BILL_CYCLE_DAY = "BillCycleDay";
  @SerializedName(SERIALIZED_NAME_BILL_CYCLE_DAY)
  private Integer billCycleDay;

  /**
   * Specifies how to determine the billing day for the charge.   **Notes**:   - If you set this field to &#x60;SpecificDayofMonth&#x60;, you must specify which day of the month as the billing day for the charge in the BillCycleDay field.    - If you set this field to &#x60;SpecificDayofWeek&#x60;, you must specify which day of the week as the billing day for the charge in the WeeklyBillCycleDay field.    - By default, &#x60;TermStartDay&#x60; and &#x60;TermEndDay&#x60; are only available for prepayment charges. But you can reach out to Zuora Global Support to request enabling it for non-prepaid recurring charges. Meanwhile, note the following rules applies to these options:     - The Term End Day option of the Billing Day field must be coupled with the Align to Term End option of the Billing Period Alignment field.     - For prepaid charges, the Term Start Day option of the Billing Day field must be coupled with the existing Align to Term Start option of the Billing Period Alignment field.     - For non-prepaid recurring charges: If Billing Day is set to Term Start Day, Billing Period Alignment must be Align to Term Start; If Billing Day is set to Term End Day, Billing Period Alignment can be set to other values. 
   */
  @JsonAdapter(BillCycleTypeEnum.Adapter.class)
 public enum BillCycleTypeEnum {
    DEFAULTFROMCUSTOMER("DefaultFromCustomer"),
    
    SPECIFICDAYOFMONTH("SpecificDayofMonth"),
    
    SUBSCRIPTIONSTARTDAY("SubscriptionStartDay"),
    
    CHARGETRIGGERDAY("ChargeTriggerDay"),
    
    SPECIFICDAYOFWEEK("SpecificDayofWeek"),
    
    TERMSTARTDAY("TermStartDay"),
    
    TERMENDDAY("TermEndDay");

    private String value;

    BillCycleTypeEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static BillCycleTypeEnum fromValue(String value) {
      for (BillCycleTypeEnum b : BillCycleTypeEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<BillCycleTypeEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final BillCycleTypeEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public BillCycleTypeEnum read(final JsonReader jsonReader) throws IOException {
        String value =  jsonReader.nextString();
        return BillCycleTypeEnum.fromValue(value);
      }
    }
  }

  public static final String SERIALIZED_NAME_BILL_CYCLE_TYPE = "BillCycleType";
  @SerializedName(SERIALIZED_NAME_BILL_CYCLE_TYPE)
  private BillCycleTypeEnum billCycleType;

  /**
   * The billing period for the charge. The start day of the billing period is also called the bill cycle day (BCD).  **Notes**:   - Specify the number of months or weeks in the SpecificBillingPeriod field if you set this field to &#x60;Specific Months&#x60; or &#x60;Specific Weeks&#x60;.   - The &#x60;Subscription Term&#x60; value is in **Limited Availability**. 
   */
  @JsonAdapter(BillingPeriodEnum.Adapter.class)
 public enum BillingPeriodEnum {
    MONTH("Month"),
    
    QUARTER("Quarter"),
    
    ANNUAL("Annual"),
    
    SEMI_ANNUAL("Semi-Annual"),
    
    SPECIFIC_MONTHS("Specific Months"),
    
    SUBSCRIPTION_TERM("Subscription Term"),
    
    WEEK("Week"),
    
    SPECIFIC_WEEKS("Specific Weeks"),
    
    SPECIFIC_DAYS("Specific Days");

    private String value;

    BillingPeriodEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static BillingPeriodEnum fromValue(String value) {
      for (BillingPeriodEnum b : BillingPeriodEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<BillingPeriodEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final BillingPeriodEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public BillingPeriodEnum read(final JsonReader jsonReader) throws IOException {
        String value =  jsonReader.nextString();
        return BillingPeriodEnum.fromValue(value);
      }
    }
  }

  public static final String SERIALIZED_NAME_BILLING_PERIOD = "BillingPeriod";
  @SerializedName(SERIALIZED_NAME_BILLING_PERIOD)
  private BillingPeriodEnum billingPeriod;

  /**
   * Aligns charges within the same subscription if multiple charges begin on different dates.  **Note:** The &#x60;AlignToTermEnd&#x60; value is only available for prepayment charges by default. Reach out to Zuora Global Support to enable it for non-prepaid recurring charges. 
   */
  @JsonAdapter(BillingPeriodAlignmentEnum.Adapter.class)
 public enum BillingPeriodAlignmentEnum {
    ALIGNTOCHARGE("AlignToCharge"),
    
    ALIGNTOSUBSCRIPTIONSTART("AlignToSubscriptionStart"),
    
    ALIGNTOTERMSTART("AlignToTermStart"),
    
    ALIGNTOTERMEND("AlignToTermEnd");

    private String value;

    BillingPeriodAlignmentEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static BillingPeriodAlignmentEnum fromValue(String value) {
      for (BillingPeriodAlignmentEnum b : BillingPeriodAlignmentEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<BillingPeriodAlignmentEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final BillingPeriodAlignmentEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public BillingPeriodAlignmentEnum read(final JsonReader jsonReader) throws IOException {
        String value =  jsonReader.nextString();
        return BillingPeriodAlignmentEnum.fromValue(value);
      }
    }
  }

  public static final String SERIALIZED_NAME_BILLING_PERIOD_ALIGNMENT = "BillingPeriodAlignment";
  @SerializedName(SERIALIZED_NAME_BILLING_PERIOD_ALIGNMENT)
  private BillingPeriodAlignmentEnum billingPeriodAlignment;

  /**
   * The billing timing for the charge. You can choose to bill in advance or in arrears for recurring charge types. This field is not used in one-time or usage based charge types.  This feature is in **Limited Availability**. If you wish to have access to the feature, submit a request at [Zuora Global Support](http://support.zuora.com/).  
   */
  @JsonAdapter(BillingTimingEnum.Adapter.class)
 public enum BillingTimingEnum {
    ADVANCE("In Advance"),
    
    ARREARS("In Arrears");

    private String value;

    BillingTimingEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static BillingTimingEnum fromValue(String value) {
      for (BillingTimingEnum b : BillingTimingEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<BillingTimingEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final BillingTimingEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public BillingTimingEnum read(final JsonReader jsonReader) throws IOException {
        String value =  jsonReader.nextString();
        return BillingTimingEnum.fromValue(value);
      }
    }
  }

  public static final String SERIALIZED_NAME_BILLING_TIMING = "BillingTiming";
  @SerializedName(SERIALIZED_NAME_BILLING_TIMING)
  private BillingTimingEnum billingTiming;

  /**
   * **Note**: This field is only available if you have the &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Bill_your_customers/Bill_for_usage_or_prepaid_products/Advanced_Consumption_Billing/Unbilled_Usage\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Unbilled Usage&lt;/a&gt; feature enabled.  To use this field, you must set the &#x60;X-Zuora-WSDL-Version&#x60; request header to &#x60;141&#x60; or higher. Otherwise, an error occurs.  This field defines what type of charge it is in Advanced Consumption Billing: * Standard: Normal charge with no Prepayment or Commitment or Drawdown. * Prepayment: For recurring charges. Unit or currency based prepaid charge. * CommitmentTrueUp: For recurring charges. Currency based minimum commitment charge. * Drawdown: For usage charges. Drawdown from prepaid funds. * DrawdownAndCreditCommitment: For usage charges. Drawdown from prepaid funds and then credit to minimum commitment funds. * CreditCommitment: For usage charges. Credit to minimum commitment funds. 
   */
  @JsonAdapter(ChargeFunctionEnum.Adapter.class)
 public enum ChargeFunctionEnum {
    STANDARD("Standard"),
    
    PREPAYMENT("Prepayment"),
    
    COMMITMENTTRUEUP("CommitmentTrueUp"),
    
    DRAWDOWN("Drawdown"),
    
    CREDITCOMMITMENT("CreditCommitment"),
    
    DRAWDOWNANDCREDITCOMMITMENT("DrawdownAndCreditCommitment");

    private String value;

    ChargeFunctionEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static ChargeFunctionEnum fromValue(String value) {
      for (ChargeFunctionEnum b : ChargeFunctionEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<ChargeFunctionEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final ChargeFunctionEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public ChargeFunctionEnum read(final JsonReader jsonReader) throws IOException {
        String value =  jsonReader.nextString();
        return ChargeFunctionEnum.fromValue(value);
      }
    }
  }

  public static final String SERIALIZED_NAME_CHARGE_FUNCTION = "ChargeFunction";
  @SerializedName(SERIALIZED_NAME_CHARGE_FUNCTION)
  private ChargeFunctionEnum chargeFunction;

  /**
   * **Note**: This field is only available if you have the &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Bill_your_customers/Bill_for_usage_or_prepaid_products/Advanced_Consumption_Billing/Unbilled_Usage\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Unbilled Usage&lt;/a&gt; feature enabled.  To use this field, you must set the &#x60;X-Zuora-WSDL-Version&#x60; request header to &#x60;133&#x60; or higher. Otherwise, an error occurs.   This field defines the type of commitment. A prepaid charge can be &#x60;UNIT&#x60; or &#x60;CURRENCY&#x60;. A minimum commitment(in-arrears) charge can only be &#x60;CURRENCY&#x60; type. For topup(recurring or one-time) charges, this field indicates what type of funds are created.  * If UNIT, it will create a fund with given prepaidUom. * If CURRENCY, it will create a fund with the currency amount calculated in list price.  For drawdown(usage) charges, this field indicates what type of funds are drawdown from that created from topup charges. 
   */
  @JsonAdapter(CommitmentTypeEnum.Adapter.class)
 public enum CommitmentTypeEnum {
    UNIT("UNIT"),
    
    CURRENCY("CURRENCY");

    private String value;

    CommitmentTypeEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static CommitmentTypeEnum fromValue(String value) {
      for (CommitmentTypeEnum b : CommitmentTypeEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<CommitmentTypeEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final CommitmentTypeEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public CommitmentTypeEnum read(final JsonReader jsonReader) throws IOException {
        String value =  jsonReader.nextString();
        return CommitmentTypeEnum.fromValue(value);
      }
    }
  }

  public static final String SERIALIZED_NAME_COMMITMENT_TYPE = "CommitmentType";
  @SerializedName(SERIALIZED_NAME_COMMITMENT_TYPE)
  private CommitmentTypeEnum commitmentType;

  /**
   * Determines how to calculate charges. Charge models must be individually activated in Zuora Billing administration.  **Notes:**   - The &#x60;Delivery Pricing&#x60; value is available only if you have the Delivery Pricing charge model enabled.   - The &#x60;MultiAttributePricing&#x60; value is available only if you have the Multi-Attribute Pricing charge model enabled. The charge model is available for customers with Enterprise and Nine editions by default. If you are a Growth customer, see [Zuora Editions](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/C_Zuora_Editions) for pricing information.          - The &#x60;PreratedPerUnit&#x60; and  value is available only if you have the Pre-rated Per Unit Pricing charge model enabled. The charge model is available for customers with Enterprise and Nine editions by default. If you are a Growth customer, see [Zuora Editions](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/C_Zuora_Editions) for pricing information.          - The &#x60;PreratedPricing&#x60; value is available only if you have the Pre-rated Pricing charge model enabled. The charge model is available for customers with Enterprise and Nine editions by default. If you are a Growth customer, see [Zuora Editions](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/C_Zuora_Editions) for pricing information.        - The &#x60;HighWatermarkVolumePricing&#x60;value is available only if you have the High Water Mark Volume Pricing charge model enabled. The charge model is available for customers with Enterprise and Nine editions by default. If you are a Growth customer, see [Zuora Editions](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/C_Zuora_Editions) for pricing information.          - The &#x60;HighWatermarkTieredPricing&#x60; value is available only if you have the High Water Mark Tiered Pricing charge model enabled. The charge model is available for customers with Enterprise and Nine editions by default. If you are a Growth customer, see [Zuora Editions](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/C_Zuora_Editions) for pricing information. 
   */
  @JsonAdapter(ChargeModelEnum.Adapter.class)
 public enum ChargeModelEnum {
    DISCOUNT_FIXED_AMOUNT("Discount-Fixed Amount"),
    
    DISCOUNT_PERCENTAGE("Discount-Percentage"),
    
    FLAT_FEE_PRICING("Flat Fee Pricing"),
    
    PER_UNIT_PRICING("Per Unit Pricing"),
    
    OVERAGE_PRICING("Overage Pricing"),
    
    TIERED_PRICING("Tiered Pricing"),
    
    TIERED_WITH_OVERAGE_PRICING("Tiered with Overage Pricing"),
    
    VOLUME_PRICING("Volume Pricing"),
    
    DELIVERY_PRICING("Delivery Pricing"),
    
    MULTIATTRIBUTEPRICING("MultiAttributePricing"),
    
    PRERATEDPERUNIT("PreratedPerUnit"),
    
    PRERATEDPRICING_("PreratedPricing`"),
    
    HIGHWATERMARKVOLUMEPRICING("HighWatermarkVolumePricing"),
    
    HIGHWATERMARKTIEREDPRICING("HighWatermarkTieredPricing");

    private String value;

    ChargeModelEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static ChargeModelEnum fromValue(String value) {
      for (ChargeModelEnum b : ChargeModelEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<ChargeModelEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final ChargeModelEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public ChargeModelEnum read(final JsonReader jsonReader) throws IOException {
        String value =  jsonReader.nextString();
        return ChargeModelEnum.fromValue(value);
      }
    }
  }

  public static final String SERIALIZED_NAME_CHARGE_MODEL = "ChargeModel";
  @SerializedName(SERIALIZED_NAME_CHARGE_MODEL)
  private ChargeModelEnum chargeModel;

  public static final String SERIALIZED_NAME_CHARGE_MODEL_CONFIGURATION = "ChargeModelConfiguration";
  @SerializedName(SERIALIZED_NAME_CHARGE_MODEL_CONFIGURATION)
  private ProxyCreateOrModifyProductRatePlanChargeChargeModelConfiguration chargeModelConfiguration;

  /**
   * Specifies the type of charge. 
   */
  @JsonAdapter(ChargeTypeEnum.Adapter.class)
 public enum ChargeTypeEnum {
    ONETIME("OneTime"),
    
    RECURRING("Recurring"),
    
    USAGE("Usage");

    private String value;

    ChargeTypeEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static ChargeTypeEnum fromValue(String value) {
      for (ChargeTypeEnum b : ChargeTypeEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<ChargeTypeEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final ChargeTypeEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public ChargeTypeEnum read(final JsonReader jsonReader) throws IOException {
        String value =  jsonReader.nextString();
        return ChargeTypeEnum.fromValue(value);
      }
    }
  }

  public static final String SERIALIZED_NAME_CHARGE_TYPE = "ChargeType";
  @SerializedName(SERIALIZED_NAME_CHARGE_TYPE)
  private ChargeTypeEnum chargeType;

  /**
   * **Note**: This field is only available if you have the [Prepaid with Drawdown](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/J_Billing_Operations/Prepaid_with_Drawdown) feature enabled.  To use this field, you must set the &#x60;X-Zuora-WSDL-Version&#x60; request header to 114 or higher. Otherwise, an error occurs.   The way to calculate credit. See [Credit Option](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/J_Billing_Operations/Prepaid_with_Drawdown/Create_prepayment_charge#Credit_Option) for more information.  
   */
  @JsonAdapter(CreditOptionEnum.Adapter.class)
 public enum CreditOptionEnum {
    TIMEBASED("TimeBased"),
    
    CONSUMPTIONBASED("ConsumptionBased"),
    
    FULLCREDITBACK("FullCreditBack");

    private String value;

    CreditOptionEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static CreditOptionEnum fromValue(String value) {
      for (CreditOptionEnum b : CreditOptionEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<CreditOptionEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final CreditOptionEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public CreditOptionEnum read(final JsonReader jsonReader) throws IOException {
        String value =  jsonReader.nextString();
        return CreditOptionEnum.fromValue(value);
      }
    }
  }

  public static final String SERIALIZED_NAME_CREDIT_OPTION = "CreditOption";
  @SerializedName(SERIALIZED_NAME_CREDIT_OPTION)
  private CreditOptionEnum creditOption;

  public static final String SERIALIZED_NAME_DEFAULT_QUANTITY = "DefaultQuantity";
  @SerializedName(SERIALIZED_NAME_DEFAULT_QUANTITY)
  private Double defaultQuantity;

  public static final String SERIALIZED_NAME_DEFERRED_REVENUE_ACCOUNT = "DeferredRevenueAccount";
  @SerializedName(SERIALIZED_NAME_DEFERRED_REVENUE_ACCOUNT)
  private String deferredRevenueAccount;

  public static final String SERIALIZED_NAME_DELIVERY_SCHEDULE = "DeliverySchedule";
  @SerializedName(SERIALIZED_NAME_DELIVERY_SCHEDULE)
  private ProxyCreateOrModifyDeliverySchedule deliverySchedule;

  public static final String SERIALIZED_NAME_DESCRIPTION = "Description";
  @SerializedName(SERIALIZED_NAME_DESCRIPTION)
  private String description;

  /**
   * Specifies if the discount applies to just the product rate plan, the entire subscription, or to any activity in the account. 
   */
  @JsonAdapter(DiscountLevelEnum.Adapter.class)
 public enum DiscountLevelEnum {
    RATEPLAN("rateplan"),
    
    SUBSCRIPTION("subscription"),
    
    ACCOUNT("account");

    private String value;

    DiscountLevelEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static DiscountLevelEnum fromValue(String value) {
      for (DiscountLevelEnum b : DiscountLevelEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<DiscountLevelEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final DiscountLevelEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public DiscountLevelEnum read(final JsonReader jsonReader) throws IOException {
        String value =  jsonReader.nextString();
        return DiscountLevelEnum.fromValue(value);
      }
    }
  }

  public static final String SERIALIZED_NAME_DISCOUNT_LEVEL = "DiscountLevel";
  @SerializedName(SERIALIZED_NAME_DISCOUNT_LEVEL)
  private DiscountLevelEnum discountLevel;

  public static final String SERIALIZED_NAME_DRAWDOWN_RATE = "DrawdownRate";
  @SerializedName(SERIALIZED_NAME_DRAWDOWN_RATE)
  private Double drawdownRate;

  public static final String SERIALIZED_NAME_DRAWDOWN_UOM = "DrawdownUom";
  @SerializedName(SERIALIZED_NAME_DRAWDOWN_UOM)
  private String drawdownUom;

  /**
   * Defines when the charge ends after the charge trigger date.  **Values**:    - &#x60;SubscriptionEnd&#x60;: The charge ends on the subscription end date after a specified period based on the trigger date of the charge.     - &#x60;FixedPeriod&#x60;: The charge ends after a specified period based on the trigger date of the charge. If you set this field to &#x60;FixedPeriod&#x60;, you must specify the length of the period and a period type by defining the &#x60;UpToPeriods&#x60; and &#x60;UpToPeriodsType&#x60; fields.       **Note**: If the subscription ends before the charge end date, the charge ends when the subscription ends. But if the subscription end date is subsequently changed through a Renewal, or Terms and Conditions amendment, the charge will end on the charge end date. 
   */
  @JsonAdapter(EndDateConditionEnum.Adapter.class)
 public enum EndDateConditionEnum {
    SUBSCRIPTIONEND("SubscriptionEnd"),
    
    FIXEDPERIOD("FixedPeriod");

    private String value;

    EndDateConditionEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static EndDateConditionEnum fromValue(String value) {
      for (EndDateConditionEnum b : EndDateConditionEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<EndDateConditionEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final EndDateConditionEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public EndDateConditionEnum read(final JsonReader jsonReader) throws IOException {
        String value =  jsonReader.nextString();
        return EndDateConditionEnum.fromValue(value);
      }
    }
  }

  public static final String SERIALIZED_NAME_END_DATE_CONDITION = "EndDateCondition";
  @SerializedName(SERIALIZED_NAME_END_DATE_CONDITION)
  private EndDateConditionEnum endDateCondition = EndDateConditionEnum.SUBSCRIPTIONEND;

  public static final String SERIALIZED_NAME_EXCLUDE_ITEM_BILLING_FROM_REVENUE_ACCOUNTING = "ExcludeItemBillingFromRevenueAccounting";
  @SerializedName(SERIALIZED_NAME_EXCLUDE_ITEM_BILLING_FROM_REVENUE_ACCOUNTING)
  private Boolean excludeItemBillingFromRevenueAccounting = false;

  public static final String SERIALIZED_NAME_EXCLUDE_ITEM_BOOKING_FROM_REVENUE_ACCOUNTING = "ExcludeItemBookingFromRevenueAccounting";
  @SerializedName(SERIALIZED_NAME_EXCLUDE_ITEM_BOOKING_FROM_REVENUE_ACCOUNTING)
  private Boolean excludeItemBookingFromRevenueAccounting = false;

  public static final String SERIALIZED_NAME_INCLUDED_UNITS = "IncludedUnits";
  @SerializedName(SERIALIZED_NAME_INCLUDED_UNITS)
  private Double includedUnits;

  public static final String SERIALIZED_NAME_IS_ALLOCATION_ELIGIBLE = "IsAllocationEligible";
  @SerializedName(SERIALIZED_NAME_IS_ALLOCATION_ELIGIBLE)
  private Boolean isAllocationEligible;

  public static final String SERIALIZED_NAME_IS_PREPAID = "IsPrepaid";
  @SerializedName(SERIALIZED_NAME_IS_PREPAID)
  private Boolean isPrepaid;

  public static final String SERIALIZED_NAME_IS_ROLLOVER = "IsRollover";
  @SerializedName(SERIALIZED_NAME_IS_ROLLOVER)
  private Boolean isRollover;

  public static final String SERIALIZED_NAME_IS_STACKED_DISCOUNT = "IsStackedDiscount";
  @SerializedName(SERIALIZED_NAME_IS_STACKED_DISCOUNT)
  private Boolean isStackedDiscount;

  public static final String SERIALIZED_NAME_IS_UNBILLED = "IsUnbilled";
  @SerializedName(SERIALIZED_NAME_IS_UNBILLED)
  private Boolean isUnbilled;

  public static final String SERIALIZED_NAME_LEGACY_REVENUE_REPORTING = "LegacyRevenueReporting";
  @SerializedName(SERIALIZED_NAME_LEGACY_REVENUE_REPORTING)
  private Boolean legacyRevenueReporting;

  /**
   * The list price base for the product rate plan charge. 
   */
  @JsonAdapter(ListPriceBaseEnum.Adapter.class)
 public enum ListPriceBaseEnum {
    BILLING_PERIOD("Per Billing Period"),
    
    MONTH("Per Month"),
    
    WEEK("Per Week"),
    
    YEAR("Per Year"),
    
    SPECIFIC_MONTHS("Per Specific Months");

    private String value;

    ListPriceBaseEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static ListPriceBaseEnum fromValue(String value) {
      for (ListPriceBaseEnum b : ListPriceBaseEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<ListPriceBaseEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final ListPriceBaseEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public ListPriceBaseEnum read(final JsonReader jsonReader) throws IOException {
        String value =  jsonReader.nextString();
        return ListPriceBaseEnum.fromValue(value);
      }
    }
  }

  public static final String SERIALIZED_NAME_LIST_PRICE_BASE = "ListPriceBase";
  @SerializedName(SERIALIZED_NAME_LIST_PRICE_BASE)
  private ListPriceBaseEnum listPriceBase;

  public static final String SERIALIZED_NAME_MAX_QUANTITY = "MaxQuantity";
  @SerializedName(SERIALIZED_NAME_MAX_QUANTITY)
  private Double maxQuantity;

  public static final String SERIALIZED_NAME_MIN_QUANTITY = "MinQuantity";
  @SerializedName(SERIALIZED_NAME_MIN_QUANTITY)
  private Double minQuantity;

  public static final String SERIALIZED_NAME_NAME = "Name";
  @SerializedName(SERIALIZED_NAME_NAME)
  private String name;

  public static final String SERIALIZED_NAME_NUMBER_OF_PERIOD = "NumberOfPeriod";
  @SerializedName(SERIALIZED_NAME_NUMBER_OF_PERIOD)
  private Long numberOfPeriod;

  /**
   * Determines when to calculate overage charges. If the value of the SmoothingMode field is not specified, the value of this field is ignored.  **Values**:    - &#x60;EndOfSmoothingPeriod&#x60;: This option is used by default. The overage is charged at the end of the smoothing period.   - &#x60;PerBillingPeriod&#x60;: The overage is charged on-demand rather than waiting until the end of the smoothing period. 
   */
  @JsonAdapter(OverageCalculationOptionEnum.Adapter.class)
 public enum OverageCalculationOptionEnum {
    ENDOFSMOOTHINGPERIOD("EndOfSmoothingPeriod"),
    
    PERBILLINGPERIOD("PerBillingPeriod");

    private String value;

    OverageCalculationOptionEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static OverageCalculationOptionEnum fromValue(String value) {
      for (OverageCalculationOptionEnum b : OverageCalculationOptionEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<OverageCalculationOptionEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final OverageCalculationOptionEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public OverageCalculationOptionEnum read(final JsonReader jsonReader) throws IOException {
        String value =  jsonReader.nextString();
        return OverageCalculationOptionEnum.fromValue(value);
      }
    }
  }

  public static final String SERIALIZED_NAME_OVERAGE_CALCULATION_OPTION = "OverageCalculationOption";
  @SerializedName(SERIALIZED_NAME_OVERAGE_CALCULATION_OPTION)
  private OverageCalculationOptionEnum overageCalculationOption;

  /**
   * Determines whether to credit the customer with unused units of usage. 
   */
  @JsonAdapter(OverageUnusedUnitsCreditOptionEnum.Adapter.class)
 public enum OverageUnusedUnitsCreditOptionEnum {
    NOCREDIT("NoCredit"),
    
    CREDITBYSPECIFICRATE("CreditBySpecificRate"),
    
    NULL("null");

    private String value;

    OverageUnusedUnitsCreditOptionEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static OverageUnusedUnitsCreditOptionEnum fromValue(String value) {
      for (OverageUnusedUnitsCreditOptionEnum b : OverageUnusedUnitsCreditOptionEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      return null;
    }

    public static class Adapter extends TypeAdapter<OverageUnusedUnitsCreditOptionEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final OverageUnusedUnitsCreditOptionEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public OverageUnusedUnitsCreditOptionEnum read(final JsonReader jsonReader) throws IOException {
        String value =  jsonReader.nextString();
        return OverageUnusedUnitsCreditOptionEnum.fromValue(value);
      }
    }
  }

  public static final String SERIALIZED_NAME_OVERAGE_UNUSED_UNITS_CREDIT_OPTION = "OverageUnusedUnitsCreditOption";
  @SerializedName(SERIALIZED_NAME_OVERAGE_UNUSED_UNITS_CREDIT_OPTION)
  private OverageUnusedUnitsCreditOptionEnum overageUnusedUnitsCreditOption;

  /**
   * **Note**: This field is only available if you have the [Prepaid with Drawdown](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/J_Billing_Operations/Prepaid_with_Drawdown) feature enabled.  To use this field, you must set the &#x60;X-Zuora-WSDL-Version&#x60; request header to 114 or higher. Otherwise, an error occurs.   The type of this charge. It is either a prepayment (topup) charge or a drawdown charge.  
   */
  @JsonAdapter(PrepaidOperationTypeEnum.Adapter.class)
 public enum PrepaidOperationTypeEnum {
    TOPUP("topup"),
    
    DRAWDOWN("drawdown");

    private String value;

    PrepaidOperationTypeEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static PrepaidOperationTypeEnum fromValue(String value) {
      for (PrepaidOperationTypeEnum b : PrepaidOperationTypeEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<PrepaidOperationTypeEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final PrepaidOperationTypeEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public PrepaidOperationTypeEnum read(final JsonReader jsonReader) throws IOException {
        String value =  jsonReader.nextString();
        return PrepaidOperationTypeEnum.fromValue(value);
      }
    }
  }

  public static final String SERIALIZED_NAME_PREPAID_OPERATION_TYPE = "PrepaidOperationType";
  @SerializedName(SERIALIZED_NAME_PREPAID_OPERATION_TYPE)
  private PrepaidOperationTypeEnum prepaidOperationType;

  public static final String SERIALIZED_NAME_PREPAID_QUANTITY = "PrepaidQuantity";
  @SerializedName(SERIALIZED_NAME_PREPAID_QUANTITY)
  private Double prepaidQuantity;

  public static final String SERIALIZED_NAME_PREPAID_TOTAL_QUANTITY = "PrepaidTotalQuantity";
  @SerializedName(SERIALIZED_NAME_PREPAID_TOTAL_QUANTITY)
  private Double prepaidTotalQuantity;

  public static final String SERIALIZED_NAME_PREPAID_UOM = "PrepaidUom";
  @SerializedName(SERIALIZED_NAME_PREPAID_UOM)
  private String prepaidUom;

  /**
   * Applies an automatic price change when a termed subscription is renewed. 
   */
  @JsonAdapter(PriceChangeOptionEnum.Adapter.class)
 public enum PriceChangeOptionEnum {
    NOCHANGE("NoChange"),
    
    SPECIFICPERCENTAGEVALUE("SpecificPercentageValue"),
    
    USELATESTPRODUCTCATALOGPRICING("UseLatestProductCatalogPricing");

    private String value;

    PriceChangeOptionEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static PriceChangeOptionEnum fromValue(String value) {
      for (PriceChangeOptionEnum b : PriceChangeOptionEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<PriceChangeOptionEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final PriceChangeOptionEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public PriceChangeOptionEnum read(final JsonReader jsonReader) throws IOException {
        String value =  jsonReader.nextString();
        return PriceChangeOptionEnum.fromValue(value);
      }
    }
  }

  public static final String SERIALIZED_NAME_PRICE_CHANGE_OPTION = "PriceChangeOption";
  @SerializedName(SERIALIZED_NAME_PRICE_CHANGE_OPTION)
  private PriceChangeOptionEnum priceChangeOption = PriceChangeOptionEnum.NOCHANGE;

  /**
   * Applies an automatic price change when a termed subscription is renewed. 
   */
  @JsonAdapter(PriceIncreaseOptionEnum.Adapter.class)
 public enum PriceIncreaseOptionEnum {
    FROMTENANTPERCENTAGEVALUE("FromTenantPercentageValue"),
    
    SPECIFICPERCENTAGEVALUE("SpecificPercentageValue");

    private String value;

    PriceIncreaseOptionEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static PriceIncreaseOptionEnum fromValue(String value) {
      for (PriceIncreaseOptionEnum b : PriceIncreaseOptionEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<PriceIncreaseOptionEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final PriceIncreaseOptionEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public PriceIncreaseOptionEnum read(final JsonReader jsonReader) throws IOException {
        String value =  jsonReader.nextString();
        return PriceIncreaseOptionEnum.fromValue(value);
      }
    }
  }

  public static final String SERIALIZED_NAME_PRICE_INCREASE_OPTION = "PriceIncreaseOption";
  @SerializedName(SERIALIZED_NAME_PRICE_INCREASE_OPTION)
  private PriceIncreaseOptionEnum priceIncreaseOption;

  public static final String SERIALIZED_NAME_PRICE_INCREASE_PERCENTAGE = "PriceIncreasePercentage";
  @SerializedName(SERIALIZED_NAME_PRICE_INCREASE_PERCENTAGE)
  private Double priceIncreasePercentage;

  public static final String SERIALIZED_NAME_PRODUCT_CATEGORY = "ProductCategory";
  @SerializedName(SERIALIZED_NAME_PRODUCT_CATEGORY)
  private String productCategory;

  public static final String SERIALIZED_NAME_PRODUCT_CLASS = "ProductClass";
  @SerializedName(SERIALIZED_NAME_PRODUCT_CLASS)
  private String productClass;

  public static final String SERIALIZED_NAME_PRODUCT_FAMILY = "ProductFamily";
  @SerializedName(SERIALIZED_NAME_PRODUCT_FAMILY)
  private String productFamily;

  public static final String SERIALIZED_NAME_PRODUCT_LINE = "ProductLine";
  @SerializedName(SERIALIZED_NAME_PRODUCT_LINE)
  private String productLine;

  /**
   * Specifies the type of revenue recognition timing.  Predefined options are listed as enum values in this API Reference.  Other options might also be avaliable depending on  the &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Enable_Order_to_Revenue/Configure_revenue_settings/Configure_revenue_recognition_policy\&quot; target&#x3D;\&quot;_blank\&quot;&gt;revenue recognition policy configuration&lt;/a&gt; in the Zuora Billing UI.  **Note**: This field is only available if you have the Order to Revenue feature enabled.  
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

  public static final String SERIALIZED_NAME_REVENUE_RECOGNITION_TIMING = "RevenueRecognitionTiming";
  @SerializedName(SERIALIZED_NAME_REVENUE_RECOGNITION_TIMING)
  private RevenueRecognitionTimingEnum revenueRecognitionTiming;

  /**
   * Specifies the type of revenue amortization method.  Predefined options are listed as enum values in this API Reference.  Other options might also be avaliable depending on  the &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Enable_Order_to_Revenue/Configure_revenue_settings/Configure_revenue_recognition_policy\&quot; target&#x3D;\&quot;_blank\&quot;&gt;revenue recognition policy configuration&lt;/a&gt; in the Zuora Billing UI.  **Note**: This field is only available if you have the Order to Revenue feature enabled.  
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

  public static final String SERIALIZED_NAME_REVENUE_AMORTIZATION_METHOD = "RevenueAmortizationMethod";
  @SerializedName(SERIALIZED_NAME_REVENUE_AMORTIZATION_METHOD)
  private RevenueAmortizationMethodEnum revenueAmortizationMethod;

  public static final String SERIALIZED_NAME_PRODUCT_RATE_PLAN_CHARGE_NUMBER = "ProductRatePlanChargeNumber";
  @SerializedName(SERIALIZED_NAME_PRODUCT_RATE_PLAN_CHARGE_NUMBER)
  private String productRatePlanChargeNumber;

  public static final String SERIALIZED_NAME_PRODUCT_RATE_PLAN_CHARGE_TIER_DATA = "ProductRatePlanChargeTierData";
  @SerializedName(SERIALIZED_NAME_PRODUCT_RATE_PLAN_CHARGE_TIER_DATA)
  private ProxyCreateOrModifyProductRatePlanChargeTierData productRatePlanChargeTierData;

  public static final String SERIALIZED_NAME_PRODUCT_RATE_PLAN_ID = "ProductRatePlanId";
  @SerializedName(SERIALIZED_NAME_PRODUCT_RATE_PLAN_ID)
  private String productRatePlanId;

  /**
   * Specifies a rating group based on which usage records are rated.  Possible values:                   - &#x60;ByBillingPeriod&#x60;: The rating is based on all the usages in a billing period.    - &#x60;ByUsageStartDate&#x60;: The rating is based on all the usages on the same usage start date.    - &#x60;ByUsageRecord&#x60;: The rating is based on each usage record.   - &#x60;ByUsageUpload&#x60;: The rating is based on all the  usages in a uploaded usage file (&#x60;.xls&#x60; or &#x60;.csv&#x60;).   - &#x60;ByGroupId&#x60;: The rating is based on all the usages in a custom group.  **Notes:**    - The &#x60;ByBillingPeriod&#x60; value can be applied for all charge models.    - The &#x60;ByUsageStartDate&#x60;, &#x60;ByUsageRecord&#x60;, and &#x60;ByUsageUpload&#x60; values can only be applied for per unit, volume pricing, and tiered pricing charge models.    - The &#x60;ByGroupId&#x60; value is only available if you have the Active Rating feature enabled.   - Use this field only for Usage charges. One-Time Charges and Recurring Charges return &#x60;NULL&#x60;. 
   */
  @JsonAdapter(RatingGroupEnum.Adapter.class)
 public enum RatingGroupEnum {
    BYBILLINGPERIOD("ByBillingPeriod"),
    
    BYUSAGESTARTDATE("ByUsageStartDate"),
    
    BYUSAGERECORD("ByUsageRecord"),
    
    BYUSAGEUPLOAD("ByUsageUpload"),
    
    BYGROUPID("ByGroupId"),
    
    NULL("null");

    private String value;

    RatingGroupEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static RatingGroupEnum fromValue(String value) {
      for (RatingGroupEnum b : RatingGroupEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      return null;
    }

    public static class Adapter extends TypeAdapter<RatingGroupEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final RatingGroupEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public RatingGroupEnum read(final JsonReader jsonReader) throws IOException {
        String value =  jsonReader.nextString();
        return RatingGroupEnum.fromValue(value);
      }
    }
  }

  public static final String SERIALIZED_NAME_RATING_GROUP = "RatingGroup";
  @SerializedName(SERIALIZED_NAME_RATING_GROUP)
  private RatingGroupEnum ratingGroup = RatingGroupEnum.BYBILLINGPERIOD;

  public static final String SERIALIZED_NAME_RECOGNIZED_REVENUE_ACCOUNT = "RecognizedRevenueAccount";
  @SerializedName(SERIALIZED_NAME_RECOGNIZED_REVENUE_ACCOUNT)
  private String recognizedRevenueAccount;

  public static final String SERIALIZED_NAME_REV_REC_CODE = "RevRecCode";
  @SerializedName(SERIALIZED_NAME_REV_REC_CODE)
  private String revRecCode;

  /**
   * Specifies when revenue recognition begins. 
   */
  @JsonAdapter(RevRecTriggerConditionEnum.Adapter.class)
 public enum RevRecTriggerConditionEnum {
    CONTRACTEFFECTIVEDATE("ContractEffectiveDate"),
    
    SERVICEACTIVATIONDATE("ServiceActivationDate"),
    
    CUSTOMERACCEPTANCEDATE("CustomerAcceptanceDate"),
    
    NULL("null");

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
      return null;
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

  public static final String SERIALIZED_NAME_REV_REC_TRIGGER_CONDITION = "RevRecTriggerCondition";
  @SerializedName(SERIALIZED_NAME_REV_REC_TRIGGER_CONDITION)
  private RevRecTriggerConditionEnum revRecTriggerCondition;

  /**
   * Determines when to recognize the revenue for this charge. 
   */
  @JsonAdapter(RevenueRecognitionRuleNameEnum.Adapter.class)
 public enum RevenueRecognitionRuleNameEnum {
    UPON_INVOICING("Recognize upon invoicing"),
    
    DAILY_OVER_TIME("Recognize daily over time");

    private String value;

    RevenueRecognitionRuleNameEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static RevenueRecognitionRuleNameEnum fromValue(String value) {
      for (RevenueRecognitionRuleNameEnum b : RevenueRecognitionRuleNameEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<RevenueRecognitionRuleNameEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final RevenueRecognitionRuleNameEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public RevenueRecognitionRuleNameEnum read(final JsonReader jsonReader) throws IOException {
        String value =  jsonReader.nextString();
        return RevenueRecognitionRuleNameEnum.fromValue(value);
      }
    }
  }

  public static final String SERIALIZED_NAME_REVENUE_RECOGNITION_RULE_NAME = "RevenueRecognitionRuleName";
  @SerializedName(SERIALIZED_NAME_REVENUE_RECOGNITION_RULE_NAME)
  private RevenueRecognitionRuleNameEnum revenueRecognitionRuleName;

  /**
   * **Note**: This field is only available if you have the [Prepaid with Drawdown](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/J_Billing_Operations/Prepaid_with_Drawdown) feature enabled.  To use this field, you must set the &#x60;X-Zuora-WSDL-Version&#x60; request header to 114 or higher. Otherwise, an error occurs.  This field defines the priority of rollover, which is either first or last. 
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

  public static final String SERIALIZED_NAME_ROLLOVER_APPLY = "RolloverApply";
  @SerializedName(SERIALIZED_NAME_ROLLOVER_APPLY)
  private RolloverApplyEnum rolloverApply;

  public static final String SERIALIZED_NAME_ROLLOVER_PERIODS = "RolloverPeriods";
  @SerializedName(SERIALIZED_NAME_ROLLOVER_PERIODS)
  private Double rolloverPeriods;

  /**
   * Specifies the smoothing model for an overage smoothing charge model. 
   */
  @JsonAdapter(SmoothingModelEnum.Adapter.class)
 public enum SmoothingModelEnum {
    ROLLINGWINDOW("RollingWindow"),
    
    ROLLOVER("Rollover"),
    
    NULL("null");

    private String value;

    SmoothingModelEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static SmoothingModelEnum fromValue(String value) {
      for (SmoothingModelEnum b : SmoothingModelEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      return null;
    }

    public static class Adapter extends TypeAdapter<SmoothingModelEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final SmoothingModelEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public SmoothingModelEnum read(final JsonReader jsonReader) throws IOException {
        String value =  jsonReader.nextString();
        return SmoothingModelEnum.fromValue(value);
      }
    }
  }

  public static final String SERIALIZED_NAME_SMOOTHING_MODEL = "SmoothingModel";
  @SerializedName(SERIALIZED_NAME_SMOOTHING_MODEL)
  private SmoothingModelEnum smoothingModel;

  public static final String SERIALIZED_NAME_SPECIFIC_BILLING_PERIOD = "SpecificBillingPeriod";
  @SerializedName(SERIALIZED_NAME_SPECIFIC_BILLING_PERIOD)
  private Long specificBillingPeriod;

  public static final String SERIALIZED_NAME_SPECIFIC_LIST_PRICE_BASE = "SpecificListPriceBase";
  @SerializedName(SERIALIZED_NAME_SPECIFIC_LIST_PRICE_BASE)
  private Integer specificListPriceBase;

  public static final String SERIALIZED_NAME_TAX_CODE = "TaxCode";
  @SerializedName(SERIALIZED_NAME_TAX_CODE)
  private String taxCode;

  /**
   * Determines how to define taxation for the charge. Required when the Taxable field is set to &#x60;True&#x60;.  **Note**: This value affects the tax calculation of rate plan charges that come from the &#x60;ProductRatePlanCharge&#x60;. 
   */
  @JsonAdapter(TaxModeEnum.Adapter.class)
 public enum TaxModeEnum {
    TAXEXCLUSIVE("TaxExclusive"),
    
    TAXINCLUSIVE("TaxInclusive"),
    
    NULL("null");

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
      return null;
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

  public static final String SERIALIZED_NAME_TAX_MODE = "TaxMode";
  @SerializedName(SERIALIZED_NAME_TAX_MODE)
  private TaxModeEnum taxMode;

  public static final String SERIALIZED_NAME_TAXABLE = "Taxable";
  @SerializedName(SERIALIZED_NAME_TAXABLE)
  private Boolean taxable;

  /**
   * Specifies when to start billing the customer for the charge.  **Values**:   - &#x60;ContractEffective&#x60; is the date when the subscription&#39;s contract goes into effect and the charge is ready to be billed.   - &#x60;ServiceActivation&#x60; is the date when the services or products for a subscription have been activated and the customers have access.   - &#x60;CustomerAcceptance&#x60; is when the customer accepts the services or products for a subscription. 
   */
  @JsonAdapter(TriggerEventEnum.Adapter.class)
 public enum TriggerEventEnum {
    CONTRACTEFFECTIVE("ContractEffective"),
    
    SERVICEACTIVATION("ServiceActivation"),
    
    CUSTOMERACCEPTANCE("CustomerAcceptance");

    private String value;

    TriggerEventEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static TriggerEventEnum fromValue(String value) {
      for (TriggerEventEnum b : TriggerEventEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<TriggerEventEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final TriggerEventEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public TriggerEventEnum read(final JsonReader jsonReader) throws IOException {
        String value =  jsonReader.nextString();
        return TriggerEventEnum.fromValue(value);
      }
    }
  }

  public static final String SERIALIZED_NAME_TRIGGER_EVENT = "TriggerEvent";
  @SerializedName(SERIALIZED_NAME_TRIGGER_EVENT)
  private TriggerEventEnum triggerEvent;

  public static final String SERIALIZED_NAME_U_O_M = "UOM";
  @SerializedName(SERIALIZED_NAME_U_O_M)
  private String UOM;

  public static final String SERIALIZED_NAME_UP_TO_PERIODS = "UpToPeriods";
  @SerializedName(SERIALIZED_NAME_UP_TO_PERIODS)
  private Long upToPeriods;

  /**
   * The period type used to define when the charge ends.  **Notes**:   - You must use this field together with the &#x60;UpToPeriods&#x60; field to specify the time period.  - This field is applicable only when the &#x60;EndDateCondition&#x60; field is set to &#x60;FixedPeriod&#x60;.  
   */
  @JsonAdapter(UpToPeriodsTypeEnum.Adapter.class)
 public enum UpToPeriodsTypeEnum {
    BILLING_PERIODS("Billing Periods"),
    
    DAYS("Days"),
    
    WEEKS("Weeks"),
    
    MONTHS("Months"),
    
    YEARS("Years"),
    
    NULL("null");

    private String value;

    UpToPeriodsTypeEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static UpToPeriodsTypeEnum fromValue(String value) {
      for (UpToPeriodsTypeEnum b : UpToPeriodsTypeEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      return null;
    }

    public static class Adapter extends TypeAdapter<UpToPeriodsTypeEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final UpToPeriodsTypeEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public UpToPeriodsTypeEnum read(final JsonReader jsonReader) throws IOException {
        String value =  jsonReader.nextString();
        return UpToPeriodsTypeEnum.fromValue(value);
      }
    }
  }

  public static final String SERIALIZED_NAME_UP_TO_PERIODS_TYPE = "UpToPeriodsType";
  @SerializedName(SERIALIZED_NAME_UP_TO_PERIODS_TYPE)
  private UpToPeriodsTypeEnum upToPeriodsType = UpToPeriodsTypeEnum.BILLING_PERIODS;

  /**
   * Determines how Zuora processes usage records for per-unit usage charges.  
   */
  @JsonAdapter(UsageRecordRatingOptionEnum.Adapter.class)
 public enum UsageRecordRatingOptionEnum {
    ENDOFBILLINGPERIOD("EndOfBillingPeriod"),
    
    ONDEMAND("OnDemand"),
    
    NULL("null");

    private String value;

    UsageRecordRatingOptionEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static UsageRecordRatingOptionEnum fromValue(String value) {
      for (UsageRecordRatingOptionEnum b : UsageRecordRatingOptionEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      return null;
    }

    public static class Adapter extends TypeAdapter<UsageRecordRatingOptionEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final UsageRecordRatingOptionEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public UsageRecordRatingOptionEnum read(final JsonReader jsonReader) throws IOException {
        String value =  jsonReader.nextString();
        return UsageRecordRatingOptionEnum.fromValue(value);
      }
    }
  }

  public static final String SERIALIZED_NAME_USAGE_RECORD_RATING_OPTION = "UsageRecordRatingOption";
  @SerializedName(SERIALIZED_NAME_USAGE_RECORD_RATING_OPTION)
  private UsageRecordRatingOptionEnum usageRecordRatingOption = UsageRecordRatingOptionEnum.ENDOFBILLINGPERIOD;

  public static final String SERIALIZED_NAME_USE_DISCOUNT_SPECIFIC_ACCOUNTING_CODE = "UseDiscountSpecificAccountingCode";
  @SerializedName(SERIALIZED_NAME_USE_DISCOUNT_SPECIFIC_ACCOUNTING_CODE)
  private Boolean useDiscountSpecificAccountingCode;

  public static final String SERIALIZED_NAME_USE_TENANT_DEFAULT_FOR_PRICE_CHANGE = "UseTenantDefaultForPriceChange";
  @SerializedName(SERIALIZED_NAME_USE_TENANT_DEFAULT_FOR_PRICE_CHANGE)
  private Boolean useTenantDefaultForPriceChange;

  /**
   * **Note**: This field is only available if you have the [Prepaid with Drawdown](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/J_Billing_Operations/Prepaid_with_Drawdown) feature enabled.  To use this field, you must set the &#x60;X-Zuora-WSDL-Version&#x60; request header to 114 or higher. Otherwise, an error occurs.   The period in which the prepayment units are valid to use as defined in a [prepayment charge](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/J_Billing_Operations/Prepaid_with_Drawdown/Create_prepayment_charge). 
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

  public static final String SERIALIZED_NAME_VALIDITY_PERIOD_TYPE = "ValidityPeriodType";
  @SerializedName(SERIALIZED_NAME_VALIDITY_PERIOD_TYPE)
  private ValidityPeriodTypeEnum validityPeriodType;

  /**
   * Specifies which day of the week as the bill cycle day (BCD) for the charge.  This feature is in **Limited Availability**. If you wish to have access to the feature, submit a request at [Zuora Global Support](http://support.zuora.com/).  
   */
  @JsonAdapter(WeeklyBillCycleDayEnum.Adapter.class)
 public enum WeeklyBillCycleDayEnum {
    SUNDAY("Sunday"),
    
    MONDAY("Monday"),
    
    TUESDAY("Tuesday"),
    
    WEDNESDAY("Wednesday"),
    
    THURSDAY("Thursday"),
    
    FRIDAY("Friday"),
    
    SATURDAY("Saturday");

    private String value;

    WeeklyBillCycleDayEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static WeeklyBillCycleDayEnum fromValue(String value) {
      for (WeeklyBillCycleDayEnum b : WeeklyBillCycleDayEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<WeeklyBillCycleDayEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final WeeklyBillCycleDayEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public WeeklyBillCycleDayEnum read(final JsonReader jsonReader) throws IOException {
        String value =  jsonReader.nextString();
        return WeeklyBillCycleDayEnum.fromValue(value);
      }
    }
  }

  public static final String SERIALIZED_NAME_WEEKLY_BILL_CYCLE_DAY = "WeeklyBillCycleDay";
  @SerializedName(SERIALIZED_NAME_WEEKLY_BILL_CYCLE_DAY)
  private WeeklyBillCycleDayEnum weeklyBillCycleDay;

  public static final String SERIALIZED_NAME_APPLY_TO_BILLING_PERIOD_PARTIALLY = "ApplyToBillingPeriodPartially";
  @SerializedName(SERIALIZED_NAME_APPLY_TO_BILLING_PERIOD_PARTIALLY)
  private Boolean applyToBillingPeriodPartially;

  public static final String SERIALIZED_NAME_ROLLOVER_PERIOD_LENGTH = "RolloverPeriodLength";
  @SerializedName(SERIALIZED_NAME_ROLLOVER_PERIOD_LENGTH)
  private Integer rolloverPeriodLength;

  public static final String SERIALIZED_NAME_FORMULA = "Formula";
  @SerializedName(SERIALIZED_NAME_FORMULA)
  private String formula;

  public static final String SERIALIZED_NAME_CLASS_N_S = "Class__NS";
  @SerializedName(SERIALIZED_NAME_CLASS_N_S)
  private String classNS;

  public static final String SERIALIZED_NAME_DEFERRED_REV_ACCOUNT_N_S = "DeferredRevAccount__NS";
  @SerializedName(SERIALIZED_NAME_DEFERRED_REV_ACCOUNT_N_S)
  private String deferredRevAccountNS;

  public static final String SERIALIZED_NAME_DEPARTMENT_N_S = "Department__NS";
  @SerializedName(SERIALIZED_NAME_DEPARTMENT_N_S)
  private String departmentNS;

  /**
   * Specifies whether the corresponding item in NetSuite is visible under child subsidiaries. Only available if you have installed the [Zuora Connector for NetSuite](https://www.zuora.com/connect/app/?appId&#x3D;265). 
   */
  @JsonAdapter(IncludeChildrenNSEnum.Adapter.class)
 public enum IncludeChildrenNSEnum {
    TRUE("true"),
    
    FALSE("false");

    private String value;

    IncludeChildrenNSEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static IncludeChildrenNSEnum fromValue(String value) {
      for (IncludeChildrenNSEnum b : IncludeChildrenNSEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<IncludeChildrenNSEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final IncludeChildrenNSEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public IncludeChildrenNSEnum read(final JsonReader jsonReader) throws IOException {
        String value =  jsonReader.nextString();
        return IncludeChildrenNSEnum.fromValue(value);
      }
    }
  }

  public static final String SERIALIZED_NAME_INCLUDE_CHILDREN_N_S = "IncludeChildren__NS";
  @SerializedName(SERIALIZED_NAME_INCLUDE_CHILDREN_N_S)
  private IncludeChildrenNSEnum includeChildrenNS;

  public static final String SERIALIZED_NAME_INTEGRATION_ID_N_S = "IntegrationId__NS";
  @SerializedName(SERIALIZED_NAME_INTEGRATION_ID_N_S)
  private String integrationIdNS;

  public static final String SERIALIZED_NAME_INTEGRATION_STATUS_N_S = "IntegrationStatus__NS";
  @SerializedName(SERIALIZED_NAME_INTEGRATION_STATUS_N_S)
  private String integrationStatusNS;

  /**
   * Type of item that is created in NetSuite for the product rate plan charge. Only available if you have installed the [Zuora Connector for NetSuite](https://www.zuora.com/connect/app/?appId&#x3D;265). 
   */
  @JsonAdapter(ItemTypeNSEnum.Adapter.class)
 public enum ItemTypeNSEnum {
    INVENTORY("Inventory"),
    
    NON_INVENTORY("Non Inventory"),
    
    SERVICE("Service");

    private String value;

    ItemTypeNSEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static ItemTypeNSEnum fromValue(String value) {
      for (ItemTypeNSEnum b : ItemTypeNSEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<ItemTypeNSEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final ItemTypeNSEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public ItemTypeNSEnum read(final JsonReader jsonReader) throws IOException {
        String value =  jsonReader.nextString();
        return ItemTypeNSEnum.fromValue(value);
      }
    }
  }

  public static final String SERIALIZED_NAME_ITEM_TYPE_N_S = "ItemType__NS";
  @SerializedName(SERIALIZED_NAME_ITEM_TYPE_N_S)
  private ItemTypeNSEnum itemTypeNS;

  public static final String SERIALIZED_NAME_LOCATION_N_S = "Location__NS";
  @SerializedName(SERIALIZED_NAME_LOCATION_N_S)
  private String locationNS;

  public static final String SERIALIZED_NAME_RECOGNIZED_REV_ACCOUNT_N_S = "RecognizedRevAccount__NS";
  @SerializedName(SERIALIZED_NAME_RECOGNIZED_REV_ACCOUNT_N_S)
  private String recognizedRevAccountNS;

  /**
   * End date condition of the corresponding item in NetSuite. Only available if you have installed the [Zuora Connector for NetSuite](https://www.zuora.com/connect/app/?appId&#x3D;265). 
   */
  @JsonAdapter(RevRecEndNSEnum.Adapter.class)
 public enum RevRecEndNSEnum {
    CHARGE_PERIOD_START("Charge Period Start"),
    
    REV_REC_TRIGGER_DATE("Rev Rec Trigger Date"),
    
    USE_NETSUITE_REV_REC_TEMPLATE("Use NetSuite Rev Rec Template");

    private String value;

    RevRecEndNSEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static RevRecEndNSEnum fromValue(String value) {
      for (RevRecEndNSEnum b : RevRecEndNSEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<RevRecEndNSEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final RevRecEndNSEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public RevRecEndNSEnum read(final JsonReader jsonReader) throws IOException {
        String value =  jsonReader.nextString();
        return RevRecEndNSEnum.fromValue(value);
      }
    }
  }

  public static final String SERIALIZED_NAME_REV_REC_END_N_S = "RevRecEnd__NS";
  @SerializedName(SERIALIZED_NAME_REV_REC_END_N_S)
  private RevRecEndNSEnum revRecEndNS;

  /**
   * Start date condition of the corresponding item in NetSuite. Only available if you have installed the [Zuora Connector for NetSuite](https://www.zuora.com/connect/app/?appId&#x3D;265). 
   */
  @JsonAdapter(RevRecStartNSEnum.Adapter.class)
 public enum RevRecStartNSEnum {
    CHARGE_PERIOD_START("Charge Period Start"),
    
    REV_REC_TRIGGER_DATE("Rev Rec Trigger Date"),
    
    USE_NETSUITE_REV_REC_TEMPLATE("Use NetSuite Rev Rec Template");

    private String value;

    RevRecStartNSEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static RevRecStartNSEnum fromValue(String value) {
      for (RevRecStartNSEnum b : RevRecStartNSEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<RevRecStartNSEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final RevRecStartNSEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public RevRecStartNSEnum read(final JsonReader jsonReader) throws IOException {
        String value =  jsonReader.nextString();
        return RevRecStartNSEnum.fromValue(value);
      }
    }
  }

  public static final String SERIALIZED_NAME_REV_REC_START_N_S = "RevRecStart__NS";
  @SerializedName(SERIALIZED_NAME_REV_REC_START_N_S)
  private RevRecStartNSEnum revRecStartNS;

  public static final String SERIALIZED_NAME_REV_REC_TEMPLATE_TYPE_N_S = "RevRecTemplateType__NS";
  @SerializedName(SERIALIZED_NAME_REV_REC_TEMPLATE_TYPE_N_S)
  private String revRecTemplateTypeNS;

  public static final String SERIALIZED_NAME_SUBSIDIARY_N_S = "Subsidiary__NS";
  @SerializedName(SERIALIZED_NAME_SUBSIDIARY_N_S)
  private String subsidiaryNS;

  public static final String SERIALIZED_NAME_SYNC_DATE_N_S = "SyncDate__NS";
  @SerializedName(SERIALIZED_NAME_SYNC_DATE_N_S)
  private String syncDateNS;

  public ProxyCreateProductRatePlanCharge() {
  }

  public ProxyCreateProductRatePlanCharge accountingCode(String accountingCode) {
    
    
    
    
    this.accountingCode = accountingCode;
    return this;
  }

   /**
   * The accounting code for the charge. Accounting codes group transactions that contain similar accounting attributes. 
   * @return accountingCode
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The accounting code for the charge. Accounting codes group transactions that contain similar accounting attributes. ")

  public String getAccountingCode() {
    return accountingCode;
  }


  public void setAccountingCode(String accountingCode) {
    
    
    
    this.accountingCode = accountingCode;
  }


  public ProxyCreateProductRatePlanCharge applyDiscountTo(ApplyDiscountToEnum applyDiscountTo) {
    
    
    
    
    this.applyDiscountTo = applyDiscountTo;
    return this;
  }

   /**
   * Specifies the type of charges that you want a specific discount to apply to. All field values are case sensitive and in all-caps. 
   * @return applyDiscountTo
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Specifies the type of charges that you want a specific discount to apply to. All field values are case sensitive and in all-caps. ")

  public ApplyDiscountToEnum getApplyDiscountTo() {
    return applyDiscountTo;
  }


  public void setApplyDiscountTo(ApplyDiscountToEnum applyDiscountTo) {
    
    
    
    this.applyDiscountTo = applyDiscountTo;
  }


  public ProxyCreateProductRatePlanCharge billCycleDay(Integer billCycleDay) {
    
    
    
    
    this.billCycleDay = billCycleDay;
    return this;
  }

   /**
   * Sets the bill cycle day (BCD) for the charge. The BCD determines which day of the month customer is billed. The BCD value in the account can override the BCD in this object.  **Character limit**: 2  **Values**: a valid BCD integer, 1 - 31 
   * @return billCycleDay
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Sets the bill cycle day (BCD) for the charge. The BCD determines which day of the month customer is billed. The BCD value in the account can override the BCD in this object.  **Character limit**: 2  **Values**: a valid BCD integer, 1 - 31 ")

  public Integer getBillCycleDay() {
    return billCycleDay;
  }


  public void setBillCycleDay(Integer billCycleDay) {
    
    
    
    this.billCycleDay = billCycleDay;
  }


  public ProxyCreateProductRatePlanCharge billCycleType(BillCycleTypeEnum billCycleType) {
    
    
    
    
    this.billCycleType = billCycleType;
    return this;
  }

   /**
   * Specifies how to determine the billing day for the charge.   **Notes**:   - If you set this field to &#x60;SpecificDayofMonth&#x60;, you must specify which day of the month as the billing day for the charge in the BillCycleDay field.    - If you set this field to &#x60;SpecificDayofWeek&#x60;, you must specify which day of the week as the billing day for the charge in the WeeklyBillCycleDay field.    - By default, &#x60;TermStartDay&#x60; and &#x60;TermEndDay&#x60; are only available for prepayment charges. But you can reach out to Zuora Global Support to request enabling it for non-prepaid recurring charges. Meanwhile, note the following rules applies to these options:     - The Term End Day option of the Billing Day field must be coupled with the Align to Term End option of the Billing Period Alignment field.     - For prepaid charges, the Term Start Day option of the Billing Day field must be coupled with the existing Align to Term Start option of the Billing Period Alignment field.     - For non-prepaid recurring charges: If Billing Day is set to Term Start Day, Billing Period Alignment must be Align to Term Start; If Billing Day is set to Term End Day, Billing Period Alignment can be set to other values. 
   * @return billCycleType
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "Specifies how to determine the billing day for the charge.   **Notes**:   - If you set this field to `SpecificDayofMonth`, you must specify which day of the month as the billing day for the charge in the BillCycleDay field.    - If you set this field to `SpecificDayofWeek`, you must specify which day of the week as the billing day for the charge in the WeeklyBillCycleDay field.    - By default, `TermStartDay` and `TermEndDay` are only available for prepayment charges. But you can reach out to Zuora Global Support to request enabling it for non-prepaid recurring charges. Meanwhile, note the following rules applies to these options:     - The Term End Day option of the Billing Day field must be coupled with the Align to Term End option of the Billing Period Alignment field.     - For prepaid charges, the Term Start Day option of the Billing Day field must be coupled with the existing Align to Term Start option of the Billing Period Alignment field.     - For non-prepaid recurring charges: If Billing Day is set to Term Start Day, Billing Period Alignment must be Align to Term Start; If Billing Day is set to Term End Day, Billing Period Alignment can be set to other values. ")

  public BillCycleTypeEnum getBillCycleType() {
    return billCycleType;
  }


  public void setBillCycleType(BillCycleTypeEnum billCycleType) {
    
    
    
    this.billCycleType = billCycleType;
  }


  public ProxyCreateProductRatePlanCharge billingPeriod(BillingPeriodEnum billingPeriod) {
    
    
    
    
    this.billingPeriod = billingPeriod;
    return this;
  }

   /**
   * The billing period for the charge. The start day of the billing period is also called the bill cycle day (BCD).  **Notes**:   - Specify the number of months or weeks in the SpecificBillingPeriod field if you set this field to &#x60;Specific Months&#x60; or &#x60;Specific Weeks&#x60;.   - The &#x60;Subscription Term&#x60; value is in **Limited Availability**. 
   * @return billingPeriod
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "The billing period for the charge. The start day of the billing period is also called the bill cycle day (BCD).  **Notes**:   - Specify the number of months or weeks in the SpecificBillingPeriod field if you set this field to `Specific Months` or `Specific Weeks`.   - The `Subscription Term` value is in **Limited Availability**. ")

  public BillingPeriodEnum getBillingPeriod() {
    return billingPeriod;
  }


  public void setBillingPeriod(BillingPeriodEnum billingPeriod) {
    
    
    
    this.billingPeriod = billingPeriod;
  }


  public ProxyCreateProductRatePlanCharge billingPeriodAlignment(BillingPeriodAlignmentEnum billingPeriodAlignment) {
    
    
    
    
    this.billingPeriodAlignment = billingPeriodAlignment;
    return this;
  }

   /**
   * Aligns charges within the same subscription if multiple charges begin on different dates.  **Note:** The &#x60;AlignToTermEnd&#x60; value is only available for prepayment charges by default. Reach out to Zuora Global Support to enable it for non-prepaid recurring charges. 
   * @return billingPeriodAlignment
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Aligns charges within the same subscription if multiple charges begin on different dates.  **Note:** The `AlignToTermEnd` value is only available for prepayment charges by default. Reach out to Zuora Global Support to enable it for non-prepaid recurring charges. ")

  public BillingPeriodAlignmentEnum getBillingPeriodAlignment() {
    return billingPeriodAlignment;
  }


  public void setBillingPeriodAlignment(BillingPeriodAlignmentEnum billingPeriodAlignment) {
    
    
    
    this.billingPeriodAlignment = billingPeriodAlignment;
  }


  public ProxyCreateProductRatePlanCharge billingTiming(BillingTimingEnum billingTiming) {
    
    
    
    
    this.billingTiming = billingTiming;
    return this;
  }

   /**
   * The billing timing for the charge. You can choose to bill in advance or in arrears for recurring charge types. This field is not used in one-time or usage based charge types.  This feature is in **Limited Availability**. If you wish to have access to the feature, submit a request at [Zuora Global Support](http://support.zuora.com/).  
   * @return billingTiming
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The billing timing for the charge. You can choose to bill in advance or in arrears for recurring charge types. This field is not used in one-time or usage based charge types.  This feature is in **Limited Availability**. If you wish to have access to the feature, submit a request at [Zuora Global Support](http://support.zuora.com/).  ")

  public BillingTimingEnum getBillingTiming() {
    return billingTiming;
  }


  public void setBillingTiming(BillingTimingEnum billingTiming) {
    
    
    
    this.billingTiming = billingTiming;
  }


  public ProxyCreateProductRatePlanCharge chargeFunction(ChargeFunctionEnum chargeFunction) {
    
    
    
    
    this.chargeFunction = chargeFunction;
    return this;
  }

   /**
   * **Note**: This field is only available if you have the &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Bill_your_customers/Bill_for_usage_or_prepaid_products/Advanced_Consumption_Billing/Unbilled_Usage\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Unbilled Usage&lt;/a&gt; feature enabled.  To use this field, you must set the &#x60;X-Zuora-WSDL-Version&#x60; request header to &#x60;141&#x60; or higher. Otherwise, an error occurs.  This field defines what type of charge it is in Advanced Consumption Billing: * Standard: Normal charge with no Prepayment or Commitment or Drawdown. * Prepayment: For recurring charges. Unit or currency based prepaid charge. * CommitmentTrueUp: For recurring charges. Currency based minimum commitment charge. * Drawdown: For usage charges. Drawdown from prepaid funds. * DrawdownAndCreditCommitment: For usage charges. Drawdown from prepaid funds and then credit to minimum commitment funds. * CreditCommitment: For usage charges. Credit to minimum commitment funds. 
   * @return chargeFunction
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "**Note**: This field is only available if you have the <a href=\"https://knowledgecenter.zuora.com/Zuora_Billing/Bill_your_customers/Bill_for_usage_or_prepaid_products/Advanced_Consumption_Billing/Unbilled_Usage\" target=\"_blank\">Unbilled Usage</a> feature enabled.  To use this field, you must set the `X-Zuora-WSDL-Version` request header to `141` or higher. Otherwise, an error occurs.  This field defines what type of charge it is in Advanced Consumption Billing: * Standard: Normal charge with no Prepayment or Commitment or Drawdown. * Prepayment: For recurring charges. Unit or currency based prepaid charge. * CommitmentTrueUp: For recurring charges. Currency based minimum commitment charge. * Drawdown: For usage charges. Drawdown from prepaid funds. * DrawdownAndCreditCommitment: For usage charges. Drawdown from prepaid funds and then credit to minimum commitment funds. * CreditCommitment: For usage charges. Credit to minimum commitment funds. ")

  public ChargeFunctionEnum getChargeFunction() {
    return chargeFunction;
  }


  public void setChargeFunction(ChargeFunctionEnum chargeFunction) {
    
    
    
    this.chargeFunction = chargeFunction;
  }


  public ProxyCreateProductRatePlanCharge commitmentType(CommitmentTypeEnum commitmentType) {
    
    
    
    
    this.commitmentType = commitmentType;
    return this;
  }

   /**
   * **Note**: This field is only available if you have the &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Bill_your_customers/Bill_for_usage_or_prepaid_products/Advanced_Consumption_Billing/Unbilled_Usage\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Unbilled Usage&lt;/a&gt; feature enabled.  To use this field, you must set the &#x60;X-Zuora-WSDL-Version&#x60; request header to &#x60;133&#x60; or higher. Otherwise, an error occurs.   This field defines the type of commitment. A prepaid charge can be &#x60;UNIT&#x60; or &#x60;CURRENCY&#x60;. A minimum commitment(in-arrears) charge can only be &#x60;CURRENCY&#x60; type. For topup(recurring or one-time) charges, this field indicates what type of funds are created.  * If UNIT, it will create a fund with given prepaidUom. * If CURRENCY, it will create a fund with the currency amount calculated in list price.  For drawdown(usage) charges, this field indicates what type of funds are drawdown from that created from topup charges. 
   * @return commitmentType
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "**Note**: This field is only available if you have the <a href=\"https://knowledgecenter.zuora.com/Zuora_Billing/Bill_your_customers/Bill_for_usage_or_prepaid_products/Advanced_Consumption_Billing/Unbilled_Usage\" target=\"_blank\">Unbilled Usage</a> feature enabled.  To use this field, you must set the `X-Zuora-WSDL-Version` request header to `133` or higher. Otherwise, an error occurs.   This field defines the type of commitment. A prepaid charge can be `UNIT` or `CURRENCY`. A minimum commitment(in-arrears) charge can only be `CURRENCY` type. For topup(recurring or one-time) charges, this field indicates what type of funds are created.  * If UNIT, it will create a fund with given prepaidUom. * If CURRENCY, it will create a fund with the currency amount calculated in list price.  For drawdown(usage) charges, this field indicates what type of funds are drawdown from that created from topup charges. ")

  public CommitmentTypeEnum getCommitmentType() {
    return commitmentType;
  }


  public void setCommitmentType(CommitmentTypeEnum commitmentType) {
    
    
    
    this.commitmentType = commitmentType;
  }


  public ProxyCreateProductRatePlanCharge chargeModel(ChargeModelEnum chargeModel) {
    
    
    
    
    this.chargeModel = chargeModel;
    return this;
  }

   /**
   * Determines how to calculate charges. Charge models must be individually activated in Zuora Billing administration.  **Notes:**   - The &#x60;Delivery Pricing&#x60; value is available only if you have the Delivery Pricing charge model enabled.   - The &#x60;MultiAttributePricing&#x60; value is available only if you have the Multi-Attribute Pricing charge model enabled. The charge model is available for customers with Enterprise and Nine editions by default. If you are a Growth customer, see [Zuora Editions](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/C_Zuora_Editions) for pricing information.          - The &#x60;PreratedPerUnit&#x60; and  value is available only if you have the Pre-rated Per Unit Pricing charge model enabled. The charge model is available for customers with Enterprise and Nine editions by default. If you are a Growth customer, see [Zuora Editions](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/C_Zuora_Editions) for pricing information.          - The &#x60;PreratedPricing&#x60; value is available only if you have the Pre-rated Pricing charge model enabled. The charge model is available for customers with Enterprise and Nine editions by default. If you are a Growth customer, see [Zuora Editions](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/C_Zuora_Editions) for pricing information.        - The &#x60;HighWatermarkVolumePricing&#x60;value is available only if you have the High Water Mark Volume Pricing charge model enabled. The charge model is available for customers with Enterprise and Nine editions by default. If you are a Growth customer, see [Zuora Editions](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/C_Zuora_Editions) for pricing information.          - The &#x60;HighWatermarkTieredPricing&#x60; value is available only if you have the High Water Mark Tiered Pricing charge model enabled. The charge model is available for customers with Enterprise and Nine editions by default. If you are a Growth customer, see [Zuora Editions](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/C_Zuora_Editions) for pricing information. 
   * @return chargeModel
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "Determines how to calculate charges. Charge models must be individually activated in Zuora Billing administration.  **Notes:**   - The `Delivery Pricing` value is available only if you have the Delivery Pricing charge model enabled.   - The `MultiAttributePricing` value is available only if you have the Multi-Attribute Pricing charge model enabled. The charge model is available for customers with Enterprise and Nine editions by default. If you are a Growth customer, see [Zuora Editions](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/C_Zuora_Editions) for pricing information.          - The `PreratedPerUnit` and  value is available only if you have the Pre-rated Per Unit Pricing charge model enabled. The charge model is available for customers with Enterprise and Nine editions by default. If you are a Growth customer, see [Zuora Editions](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/C_Zuora_Editions) for pricing information.          - The `PreratedPricing` value is available only if you have the Pre-rated Pricing charge model enabled. The charge model is available for customers with Enterprise and Nine editions by default. If you are a Growth customer, see [Zuora Editions](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/C_Zuora_Editions) for pricing information.        - The `HighWatermarkVolumePricing`value is available only if you have the High Water Mark Volume Pricing charge model enabled. The charge model is available for customers with Enterprise and Nine editions by default. If you are a Growth customer, see [Zuora Editions](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/C_Zuora_Editions) for pricing information.          - The `HighWatermarkTieredPricing` value is available only if you have the High Water Mark Tiered Pricing charge model enabled. The charge model is available for customers with Enterprise and Nine editions by default. If you are a Growth customer, see [Zuora Editions](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/C_Zuora_Editions) for pricing information. ")

  public ChargeModelEnum getChargeModel() {
    return chargeModel;
  }


  public void setChargeModel(ChargeModelEnum chargeModel) {
    
    
    
    this.chargeModel = chargeModel;
  }


  public ProxyCreateProductRatePlanCharge chargeModelConfiguration(ProxyCreateOrModifyProductRatePlanChargeChargeModelConfiguration chargeModelConfiguration) {
    
    
    
    
    this.chargeModelConfiguration = chargeModelConfiguration;
    return this;
  }

   /**
   * Get chargeModelConfiguration
   * @return chargeModelConfiguration
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public ProxyCreateOrModifyProductRatePlanChargeChargeModelConfiguration getChargeModelConfiguration() {
    return chargeModelConfiguration;
  }


  public void setChargeModelConfiguration(ProxyCreateOrModifyProductRatePlanChargeChargeModelConfiguration chargeModelConfiguration) {
    
    
    
    this.chargeModelConfiguration = chargeModelConfiguration;
  }


  public ProxyCreateProductRatePlanCharge chargeType(ChargeTypeEnum chargeType) {
    
    
    
    
    this.chargeType = chargeType;
    return this;
  }

   /**
   * Specifies the type of charge. 
   * @return chargeType
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "Specifies the type of charge. ")

  public ChargeTypeEnum getChargeType() {
    return chargeType;
  }


  public void setChargeType(ChargeTypeEnum chargeType) {
    
    
    
    this.chargeType = chargeType;
  }


  public ProxyCreateProductRatePlanCharge creditOption(CreditOptionEnum creditOption) {
    
    
    
    
    this.creditOption = creditOption;
    return this;
  }

   /**
   * **Note**: This field is only available if you have the [Prepaid with Drawdown](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/J_Billing_Operations/Prepaid_with_Drawdown) feature enabled.  To use this field, you must set the &#x60;X-Zuora-WSDL-Version&#x60; request header to 114 or higher. Otherwise, an error occurs.   The way to calculate credit. See [Credit Option](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/J_Billing_Operations/Prepaid_with_Drawdown/Create_prepayment_charge#Credit_Option) for more information.  
   * @return creditOption
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "**Note**: This field is only available if you have the [Prepaid with Drawdown](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/J_Billing_Operations/Prepaid_with_Drawdown) feature enabled.  To use this field, you must set the `X-Zuora-WSDL-Version` request header to 114 or higher. Otherwise, an error occurs.   The way to calculate credit. See [Credit Option](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/J_Billing_Operations/Prepaid_with_Drawdown/Create_prepayment_charge#Credit_Option) for more information.  ")

  public CreditOptionEnum getCreditOption() {
    return creditOption;
  }


  public void setCreditOption(CreditOptionEnum creditOption) {
    
    
    
    this.creditOption = creditOption;
  }


  public ProxyCreateProductRatePlanCharge defaultQuantity(Double defaultQuantity) {
    
    
    
    
    this.defaultQuantity = defaultQuantity;
    return this;
  }

   /**
   * The default quantity of units, such as the number of authors in a hosted wiki service. This field is required if you use a per-unit pricing model.   **Character limit**: 16  **Values**: a valid quantity value.   **Note:** When the &#x60;ChargeModel&#x60; field is set to &#x60;Tiered Pricing&#x60; or &#x60;Volume Pricing&#x60;, if this field is not specified, the value will default to &#x60;0&#x60;. 
   * @return defaultQuantity
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The default quantity of units, such as the number of authors in a hosted wiki service. This field is required if you use a per-unit pricing model.   **Character limit**: 16  **Values**: a valid quantity value.   **Note:** When the `ChargeModel` field is set to `Tiered Pricing` or `Volume Pricing`, if this field is not specified, the value will default to `0`. ")

  public Double getDefaultQuantity() {
    return defaultQuantity;
  }


  public void setDefaultQuantity(Double defaultQuantity) {
    
    
    
    this.defaultQuantity = defaultQuantity;
  }


  public ProxyCreateProductRatePlanCharge deferredRevenueAccount(String deferredRevenueAccount) {
    
    
    
    
    this.deferredRevenueAccount = deferredRevenueAccount;
    return this;
  }

   /**
   * The name of the deferred revenue account for this charge.  This feature is in **Limited Availability**. If you wish to have access to the feature, submit a request at [Zuora Global Support](http://support.zuora.com/).  
   * @return deferredRevenueAccount
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The name of the deferred revenue account for this charge.  This feature is in **Limited Availability**. If you wish to have access to the feature, submit a request at [Zuora Global Support](http://support.zuora.com/).  ")

  public String getDeferredRevenueAccount() {
    return deferredRevenueAccount;
  }


  public void setDeferredRevenueAccount(String deferredRevenueAccount) {
    
    
    
    this.deferredRevenueAccount = deferredRevenueAccount;
  }


  public ProxyCreateProductRatePlanCharge deliverySchedule(ProxyCreateOrModifyDeliverySchedule deliverySchedule) {
    
    
    
    
    this.deliverySchedule = deliverySchedule;
    return this;
  }

   /**
   * Get deliverySchedule
   * @return deliverySchedule
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public ProxyCreateOrModifyDeliverySchedule getDeliverySchedule() {
    return deliverySchedule;
  }


  public void setDeliverySchedule(ProxyCreateOrModifyDeliverySchedule deliverySchedule) {
    
    
    
    this.deliverySchedule = deliverySchedule;
  }


  public ProxyCreateProductRatePlanCharge description(String description) {
    
    
    
    
    this.description = description;
    return this;
  }

   /**
   * A description of the charge. 
   * @return description
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "A description of the charge. ")

  public String getDescription() {
    return description;
  }


  public void setDescription(String description) {
    
    
    
    this.description = description;
  }


  public ProxyCreateProductRatePlanCharge discountLevel(DiscountLevelEnum discountLevel) {
    
    
    
    
    this.discountLevel = discountLevel;
    return this;
  }

   /**
   * Specifies if the discount applies to just the product rate plan, the entire subscription, or to any activity in the account. 
   * @return discountLevel
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Specifies if the discount applies to just the product rate plan, the entire subscription, or to any activity in the account. ")

  public DiscountLevelEnum getDiscountLevel() {
    return discountLevel;
  }


  public void setDiscountLevel(DiscountLevelEnum discountLevel) {
    
    
    
    this.discountLevel = discountLevel;
  }


  public ProxyCreateProductRatePlanCharge drawdownRate(Double drawdownRate) {
    
    
    
    
    this.drawdownRate = drawdownRate;
    return this;
  }

  public ProxyCreateProductRatePlanCharge drawdownRate(Integer drawdownRate) {
    
    
    
    
    this.drawdownRate = drawdownRate.doubleValue();
    return this;
  }

   /**
   * **Note**: This field is only available if you have the [Prepaid with Drawdown](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/J_Billing_Operations/Prepaid_with_Drawdown) feature enabled.  To use this field, you must set the &#x60;X-Zuora-WSDL-Version&#x60; request header to 114 or higher. Otherwise, an error occurs.  The [conversion rate](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/J_Billing_Operations/Prepaid_with_Drawdown/Create_drawdown_charge#UOM_Conversion) between Usage UOM and Drawdown UOM for a [drawdown charge](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/J_Billing_Operations/Prepaid_with_Drawdown/Create_drawdown_charge). See [Fields related to Prepaid with Drawdown](https://knowledgecenter.zuora.com/Central_Platform/API/G_SOAP_API/E1_SOAP_API_Object_Reference/ProductRatePlanCharge#Fields_related_to_Prepaid_with_Drawdown) for more information. 
   * @return drawdownRate
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "**Note**: This field is only available if you have the [Prepaid with Drawdown](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/J_Billing_Operations/Prepaid_with_Drawdown) feature enabled.  To use this field, you must set the `X-Zuora-WSDL-Version` request header to 114 or higher. Otherwise, an error occurs.  The [conversion rate](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/J_Billing_Operations/Prepaid_with_Drawdown/Create_drawdown_charge#UOM_Conversion) between Usage UOM and Drawdown UOM for a [drawdown charge](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/J_Billing_Operations/Prepaid_with_Drawdown/Create_drawdown_charge). See [Fields related to Prepaid with Drawdown](https://knowledgecenter.zuora.com/Central_Platform/API/G_SOAP_API/E1_SOAP_API_Object_Reference/ProductRatePlanCharge#Fields_related_to_Prepaid_with_Drawdown) for more information. ")

  public Double getDrawdownRate() {
    return drawdownRate;
  }


  public void setDrawdownRate(Double drawdownRate) {
    
    
    
    this.drawdownRate = drawdownRate;
  }


  public ProxyCreateProductRatePlanCharge drawdownUom(String drawdownUom) {
    
    
    
    
    this.drawdownUom = drawdownUom;
    return this;
  }

   /**
   * **Note**: This field is only available if you have the [Prepaid with Drawdown](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/J_Billing_Operations/Prepaid_with_Drawdown) feature enabled.  To use this field, you must set the &#x60;X-Zuora-WSDL-Version&#x60; request header to 114 or higher. Otherwise, an error occurs.   Unit of measurement for a [drawdown charge](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/J_Billing_Operations/Prepaid_with_Drawdown/Create_drawdown_charge).  
   * @return drawdownUom
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "**Note**: This field is only available if you have the [Prepaid with Drawdown](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/J_Billing_Operations/Prepaid_with_Drawdown) feature enabled.  To use this field, you must set the `X-Zuora-WSDL-Version` request header to 114 or higher. Otherwise, an error occurs.   Unit of measurement for a [drawdown charge](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/J_Billing_Operations/Prepaid_with_Drawdown/Create_drawdown_charge).  ")

  public String getDrawdownUom() {
    return drawdownUom;
  }


  public void setDrawdownUom(String drawdownUom) {
    
    
    
    this.drawdownUom = drawdownUom;
  }


  public ProxyCreateProductRatePlanCharge endDateCondition(EndDateConditionEnum endDateCondition) {
    
    
    
    
    this.endDateCondition = endDateCondition;
    return this;
  }

   /**
   * Defines when the charge ends after the charge trigger date.  **Values**:    - &#x60;SubscriptionEnd&#x60;: The charge ends on the subscription end date after a specified period based on the trigger date of the charge.     - &#x60;FixedPeriod&#x60;: The charge ends after a specified period based on the trigger date of the charge. If you set this field to &#x60;FixedPeriod&#x60;, you must specify the length of the period and a period type by defining the &#x60;UpToPeriods&#x60; and &#x60;UpToPeriodsType&#x60; fields.       **Note**: If the subscription ends before the charge end date, the charge ends when the subscription ends. But if the subscription end date is subsequently changed through a Renewal, or Terms and Conditions amendment, the charge will end on the charge end date. 
   * @return endDateCondition
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "SUBSCRIPTIONEND", value = "Defines when the charge ends after the charge trigger date.  **Values**:    - `SubscriptionEnd`: The charge ends on the subscription end date after a specified period based on the trigger date of the charge.     - `FixedPeriod`: The charge ends after a specified period based on the trigger date of the charge. If you set this field to `FixedPeriod`, you must specify the length of the period and a period type by defining the `UpToPeriods` and `UpToPeriodsType` fields.       **Note**: If the subscription ends before the charge end date, the charge ends when the subscription ends. But if the subscription end date is subsequently changed through a Renewal, or Terms and Conditions amendment, the charge will end on the charge end date. ")

  public EndDateConditionEnum getEndDateCondition() {
    return endDateCondition;
  }


  public void setEndDateCondition(EndDateConditionEnum endDateCondition) {
    
    
    
    this.endDateCondition = endDateCondition;
  }


  public ProxyCreateProductRatePlanCharge excludeItemBillingFromRevenueAccounting(Boolean excludeItemBillingFromRevenueAccounting) {
    
    
    
    
    this.excludeItemBillingFromRevenueAccounting = excludeItemBillingFromRevenueAccounting;
    return this;
  }

   /**
   * The flag to exclude the related invoice items, invoice item adjustments, credit memo items, and debit memo items from revenue accounting.  **Notes**:    - To use this field, you must set the &#x60;X-Zuora-WSDL-Version&#x60; request header to &#x60;115&#x60; or later. Otherwise, an error occurs.   - This field is only available if you have the Order to Revenue or Billing - Revenue Integration feature enabled.  
   * @return excludeItemBillingFromRevenueAccounting
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "false", value = "The flag to exclude the related invoice items, invoice item adjustments, credit memo items, and debit memo items from revenue accounting.  **Notes**:    - To use this field, you must set the `X-Zuora-WSDL-Version` request header to `115` or later. Otherwise, an error occurs.   - This field is only available if you have the Order to Revenue or Billing - Revenue Integration feature enabled.  ")

  public Boolean getExcludeItemBillingFromRevenueAccounting() {
    return excludeItemBillingFromRevenueAccounting;
  }


  public void setExcludeItemBillingFromRevenueAccounting(Boolean excludeItemBillingFromRevenueAccounting) {
    
    
    
    this.excludeItemBillingFromRevenueAccounting = excludeItemBillingFromRevenueAccounting;
  }


  public ProxyCreateProductRatePlanCharge excludeItemBookingFromRevenueAccounting(Boolean excludeItemBookingFromRevenueAccounting) {
    
    
    
    
    this.excludeItemBookingFromRevenueAccounting = excludeItemBookingFromRevenueAccounting;
    return this;
  }

   /**
   * The flag to exclude the related rate plan charges and order line items from revenue accounting.  **Notes**:    - To use this field, you must set the &#x60;X-Zuora-WSDL-Version&#x60; request header to &#x60;115&#x60; or later. Otherwise, an error occurs.   - This field is only available if you have the Order to Revenue or Billing - Revenue Integration feature enabled.  
   * @return excludeItemBookingFromRevenueAccounting
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "false", value = "The flag to exclude the related rate plan charges and order line items from revenue accounting.  **Notes**:    - To use this field, you must set the `X-Zuora-WSDL-Version` request header to `115` or later. Otherwise, an error occurs.   - This field is only available if you have the Order to Revenue or Billing - Revenue Integration feature enabled.  ")

  public Boolean getExcludeItemBookingFromRevenueAccounting() {
    return excludeItemBookingFromRevenueAccounting;
  }


  public void setExcludeItemBookingFromRevenueAccounting(Boolean excludeItemBookingFromRevenueAccounting) {
    
    
    
    this.excludeItemBookingFromRevenueAccounting = excludeItemBookingFromRevenueAccounting;
  }


  public ProxyCreateProductRatePlanCharge includedUnits(Double includedUnits) {
    
    
    
    
    this.includedUnits = includedUnits;
    return this;
  }

   /**
   * Specifies the number of units in the base set of units.  **Character limit**: 16  **Values**: a positive decimal value 
   * @return includedUnits
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Specifies the number of units in the base set of units.  **Character limit**: 16  **Values**: a positive decimal value ")

  public Double getIncludedUnits() {
    return includedUnits;
  }


  public void setIncludedUnits(Double includedUnits) {
    
    
    
    this.includedUnits = includedUnits;
  }


  public ProxyCreateProductRatePlanCharge isAllocationEligible(Boolean isAllocationEligible) {
    
    
    
    
    this.isAllocationEligible = isAllocationEligible;
    return this;
  }

   /**
   * Indicates whether the charge segment is allocation eligible in revenue recognition. The default value is &#x60;False&#x60;.  **Values**: &#x60;True&#x60;, &#x60;False&#x60;  **Notes**:    - This field is available only if you have the Additional Revenue Fields property enabled.   - To use this field, you must set the &#x60;X-Zuora-WSDL-Version&#x60; request header to 132 or later.  
   * @return isAllocationEligible
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Indicates whether the charge segment is allocation eligible in revenue recognition. The default value is `False`.  **Values**: `True`, `False`  **Notes**:    - This field is available only if you have the Additional Revenue Fields property enabled.   - To use this field, you must set the `X-Zuora-WSDL-Version` request header to 132 or later.  ")

  public Boolean getIsAllocationEligible() {
    return isAllocationEligible;
  }


  public void setIsAllocationEligible(Boolean isAllocationEligible) {
    
    
    
    this.isAllocationEligible = isAllocationEligible;
  }


  public ProxyCreateProductRatePlanCharge isPrepaid(Boolean isPrepaid) {
    
    
    
    
    this.isPrepaid = isPrepaid;
    return this;
  }

   /**
   * **Note**: This field is only available if you have the [Prepaid with Drawdown](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/J_Billing_Operations/Prepaid_with_Drawdown) feature enabled.  To use this field, you must set the &#x60;X-Zuora-WSDL-Version&#x60; request header to 114 or higher. Otherwise, an error occurs.   Indicates whether this charge is a prepayment (topup) charge or a drawdown charge.   **Values**: &#x60;true&#x60; or &#x60;false&#x60;. 
   * @return isPrepaid
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "**Note**: This field is only available if you have the [Prepaid with Drawdown](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/J_Billing_Operations/Prepaid_with_Drawdown) feature enabled.  To use this field, you must set the `X-Zuora-WSDL-Version` request header to 114 or higher. Otherwise, an error occurs.   Indicates whether this charge is a prepayment (topup) charge or a drawdown charge.   **Values**: `true` or `false`. ")

  public Boolean getIsPrepaid() {
    return isPrepaid;
  }


  public void setIsPrepaid(Boolean isPrepaid) {
    
    
    
    this.isPrepaid = isPrepaid;
  }


  public ProxyCreateProductRatePlanCharge isRollover(Boolean isRollover) {
    
    
    
    
    this.isRollover = isRollover;
    return this;
  }

   /**
   * **Note**: This field is only available if you have the [Prepaid with Drawdown](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/J_Billing_Operations/Prepaid_with_Drawdown) feature enabled.  To use this field, you must set the &#x60;X-Zuora-WSDL-Version&#x60; request header to 114 or higher. Otherwise, an error occurs.  The value is either \&quot;True\&quot; or \&quot;False\&quot;. It determines whether the rollover fields are needed. 
   * @return isRollover
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "**Note**: This field is only available if you have the [Prepaid with Drawdown](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/J_Billing_Operations/Prepaid_with_Drawdown) feature enabled.  To use this field, you must set the `X-Zuora-WSDL-Version` request header to 114 or higher. Otherwise, an error occurs.  The value is either \"True\" or \"False\". It determines whether the rollover fields are needed. ")

  public Boolean getIsRollover() {
    return isRollover;
  }


  public void setIsRollover(Boolean isRollover) {
    
    
    
    this.isRollover = isRollover;
  }


  public ProxyCreateProductRatePlanCharge isStackedDiscount(Boolean isStackedDiscount) {
    
    
    
    
    this.isStackedDiscount = isStackedDiscount;
    return this;
  }

   /**
   * **Note**: This field is only applicable to the Discount - Percentage charge model.  To use this field, you must set the &#x60;X-Zuora-WSDL-Version&#x60; request header to 130 or higher. Otherwise, an error occurs.  This field indicates whether the discount is to be calculated as stacked discount. Possible values are as follows:   - &#x60;True&#x60;: This is a stacked discount, which should be calculated by stacking with other discounts.   - &#x60;False&#x60;: This is not a stacked discount, which should be calculated in sequence with other discounts.  For more information, see [Stacked discounts](https://knowledgecenter.zuora.com/Zuora_Billing/Products/Product_Catalog/B_Charge_Models/B_Discount_Charge_Models). 
   * @return isStackedDiscount
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "**Note**: This field is only applicable to the Discount - Percentage charge model.  To use this field, you must set the `X-Zuora-WSDL-Version` request header to 130 or higher. Otherwise, an error occurs.  This field indicates whether the discount is to be calculated as stacked discount. Possible values are as follows:   - `True`: This is a stacked discount, which should be calculated by stacking with other discounts.   - `False`: This is not a stacked discount, which should be calculated in sequence with other discounts.  For more information, see [Stacked discounts](https://knowledgecenter.zuora.com/Zuora_Billing/Products/Product_Catalog/B_Charge_Models/B_Discount_Charge_Models). ")

  public Boolean getIsStackedDiscount() {
    return isStackedDiscount;
  }


  public void setIsStackedDiscount(Boolean isStackedDiscount) {
    
    
    
    this.isStackedDiscount = isStackedDiscount;
  }


  public ProxyCreateProductRatePlanCharge isUnbilled(Boolean isUnbilled) {
    
    
    
    
    this.isUnbilled = isUnbilled;
    return this;
  }

   /**
   * Specifies how to perform the accounting during revenue recognition. The default value is &#x60;False&#x60;.  **Values**: &#x60;True&#x60;, &#x60;False&#x60;  **Notes**:    - This field is available only if you have the Additional Revenue Fields property enabled.   - To use this field, you must set the &#x60;X-Zuora-WSDL-Version&#x60; request header to 132 or later.     
   * @return isUnbilled
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Specifies how to perform the accounting during revenue recognition. The default value is `False`.  **Values**: `True`, `False`  **Notes**:    - This field is available only if you have the Additional Revenue Fields property enabled.   - To use this field, you must set the `X-Zuora-WSDL-Version` request header to 132 or later.     ")

  public Boolean getIsUnbilled() {
    return isUnbilled;
  }


  public void setIsUnbilled(Boolean isUnbilled) {
    
    
    
    this.isUnbilled = isUnbilled;
  }


  public ProxyCreateProductRatePlanCharge legacyRevenueReporting(Boolean legacyRevenueReporting) {
    
    
    
    
    this.legacyRevenueReporting = legacyRevenueReporting;
    return this;
  }

   /**
   * 
   * @return legacyRevenueReporting
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public Boolean getLegacyRevenueReporting() {
    return legacyRevenueReporting;
  }


  public void setLegacyRevenueReporting(Boolean legacyRevenueReporting) {
    
    
    
    this.legacyRevenueReporting = legacyRevenueReporting;
  }


  public ProxyCreateProductRatePlanCharge listPriceBase(ListPriceBaseEnum listPriceBase) {
    
    
    
    
    this.listPriceBase = listPriceBase;
    return this;
  }

   /**
   * The list price base for the product rate plan charge. 
   * @return listPriceBase
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The list price base for the product rate plan charge. ")

  public ListPriceBaseEnum getListPriceBase() {
    return listPriceBase;
  }


  public void setListPriceBase(ListPriceBaseEnum listPriceBase) {
    
    
    
    this.listPriceBase = listPriceBase;
  }


  public ProxyCreateProductRatePlanCharge maxQuantity(Double maxQuantity) {
    
    
    
    
    this.maxQuantity = maxQuantity;
    return this;
  }

   /**
   * Specifies the maximum number of units for this charge. Use this field and the &#x60;MinQuantity&#x60; field to create a range of units allowed in a product rate plan charge.  **Character limit**: 16  **Values**: a positive decimal value 
   * @return maxQuantity
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Specifies the maximum number of units for this charge. Use this field and the `MinQuantity` field to create a range of units allowed in a product rate plan charge.  **Character limit**: 16  **Values**: a positive decimal value ")

  public Double getMaxQuantity() {
    return maxQuantity;
  }


  public void setMaxQuantity(Double maxQuantity) {
    
    
    
    this.maxQuantity = maxQuantity;
  }


  public ProxyCreateProductRatePlanCharge minQuantity(Double minQuantity) {
    
    
    
    
    this.minQuantity = minQuantity;
    return this;
  }

   /**
   * Specifies the minimum number of units for this charge. Use this field and the &#x60;MaxQuantity&#x60; field to create a range of units allowed in a product rate plan charge.  **Character limit**: 16  **Values**: a positive decimal value 
   * @return minQuantity
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Specifies the minimum number of units for this charge. Use this field and the `MaxQuantity` field to create a range of units allowed in a product rate plan charge.  **Character limit**: 16  **Values**: a positive decimal value ")

  public Double getMinQuantity() {
    return minQuantity;
  }


  public void setMinQuantity(Double minQuantity) {
    
    
    
    this.minQuantity = minQuantity;
  }


  public ProxyCreateProductRatePlanCharge name(String name) {
    
    
    
    
    this.name = name;
    return this;
  }

   /**
   * The name of the product rate plan charge. 
   * @return name
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "The name of the product rate plan charge. ")

  public String getName() {
    return name;
  }


  public void setName(String name) {
    
    
    
    this.name = name;
  }


  public ProxyCreateProductRatePlanCharge numberOfPeriod(Long numberOfPeriod) {
    
    
    
    
    this.numberOfPeriod = numberOfPeriod;
    return this;
  }

   /**
   * Specifies the number of periods to use when calculating charges in an overage smoothing charge model. The valid value is a positive whole number. 
   * @return numberOfPeriod
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Specifies the number of periods to use when calculating charges in an overage smoothing charge model. The valid value is a positive whole number. ")

  public Long getNumberOfPeriod() {
    return numberOfPeriod;
  }


  public void setNumberOfPeriod(Long numberOfPeriod) {
    
    
    
    this.numberOfPeriod = numberOfPeriod;
  }


  public ProxyCreateProductRatePlanCharge overageCalculationOption(OverageCalculationOptionEnum overageCalculationOption) {
    
    
    
    
    this.overageCalculationOption = overageCalculationOption;
    return this;
  }

   /**
   * Determines when to calculate overage charges. If the value of the SmoothingMode field is not specified, the value of this field is ignored.  **Values**:    - &#x60;EndOfSmoothingPeriod&#x60;: This option is used by default. The overage is charged at the end of the smoothing period.   - &#x60;PerBillingPeriod&#x60;: The overage is charged on-demand rather than waiting until the end of the smoothing period. 
   * @return overageCalculationOption
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Determines when to calculate overage charges. If the value of the SmoothingMode field is not specified, the value of this field is ignored.  **Values**:    - `EndOfSmoothingPeriod`: This option is used by default. The overage is charged at the end of the smoothing period.   - `PerBillingPeriod`: The overage is charged on-demand rather than waiting until the end of the smoothing period. ")

  public OverageCalculationOptionEnum getOverageCalculationOption() {
    return overageCalculationOption;
  }


  public void setOverageCalculationOption(OverageCalculationOptionEnum overageCalculationOption) {
    
    
    
    this.overageCalculationOption = overageCalculationOption;
  }


  public ProxyCreateProductRatePlanCharge overageUnusedUnitsCreditOption(OverageUnusedUnitsCreditOptionEnum overageUnusedUnitsCreditOption) {
    
    
    
    
    this.overageUnusedUnitsCreditOption = overageUnusedUnitsCreditOption;
    return this;
  }

   /**
   * Determines whether to credit the customer with unused units of usage. 
   * @return overageUnusedUnitsCreditOption
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Determines whether to credit the customer with unused units of usage. ")

  public OverageUnusedUnitsCreditOptionEnum getOverageUnusedUnitsCreditOption() {
    return overageUnusedUnitsCreditOption;
  }


  public void setOverageUnusedUnitsCreditOption(OverageUnusedUnitsCreditOptionEnum overageUnusedUnitsCreditOption) {
    
    
    
    this.overageUnusedUnitsCreditOption = overageUnusedUnitsCreditOption;
  }


  public ProxyCreateProductRatePlanCharge prepaidOperationType(PrepaidOperationTypeEnum prepaidOperationType) {
    
    
    
    
    this.prepaidOperationType = prepaidOperationType;
    return this;
  }

   /**
   * **Note**: This field is only available if you have the [Prepaid with Drawdown](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/J_Billing_Operations/Prepaid_with_Drawdown) feature enabled.  To use this field, you must set the &#x60;X-Zuora-WSDL-Version&#x60; request header to 114 or higher. Otherwise, an error occurs.   The type of this charge. It is either a prepayment (topup) charge or a drawdown charge.  
   * @return prepaidOperationType
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "**Note**: This field is only available if you have the [Prepaid with Drawdown](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/J_Billing_Operations/Prepaid_with_Drawdown) feature enabled.  To use this field, you must set the `X-Zuora-WSDL-Version` request header to 114 or higher. Otherwise, an error occurs.   The type of this charge. It is either a prepayment (topup) charge or a drawdown charge.  ")

  public PrepaidOperationTypeEnum getPrepaidOperationType() {
    return prepaidOperationType;
  }


  public void setPrepaidOperationType(PrepaidOperationTypeEnum prepaidOperationType) {
    
    
    
    this.prepaidOperationType = prepaidOperationType;
  }


  public ProxyCreateProductRatePlanCharge prepaidQuantity(Double prepaidQuantity) {
    
    
    
    
    this.prepaidQuantity = prepaidQuantity;
    return this;
  }

  public ProxyCreateProductRatePlanCharge prepaidQuantity(Integer prepaidQuantity) {
    
    
    
    
    this.prepaidQuantity = prepaidQuantity.doubleValue();
    return this;
  }

   /**
   * **Note**: This field is only available if you have the [Prepaid with Drawdown](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/J_Billing_Operations/Prepaid_with_Drawdown) feature enabled.  To use this field, you must set the &#x60;X-Zuora-WSDL-Version&#x60; request header to 114 or higher. Otherwise, an error occurs.   The number of units included in a [prepayment charge](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/J_Billing_Operations/Prepaid_with_Drawdown/Create_prepayment_charge). Must be a positive number. 
   * @return prepaidQuantity
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "**Note**: This field is only available if you have the [Prepaid with Drawdown](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/J_Billing_Operations/Prepaid_with_Drawdown) feature enabled.  To use this field, you must set the `X-Zuora-WSDL-Version` request header to 114 or higher. Otherwise, an error occurs.   The number of units included in a [prepayment charge](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/J_Billing_Operations/Prepaid_with_Drawdown/Create_prepayment_charge). Must be a positive number. ")

  public Double getPrepaidQuantity() {
    return prepaidQuantity;
  }


  public void setPrepaidQuantity(Double prepaidQuantity) {
    
    
    
    this.prepaidQuantity = prepaidQuantity;
  }


  public ProxyCreateProductRatePlanCharge prepaidTotalQuantity(Double prepaidTotalQuantity) {
    
    
    
    
    this.prepaidTotalQuantity = prepaidTotalQuantity;
    return this;
  }

  public ProxyCreateProductRatePlanCharge prepaidTotalQuantity(Integer prepaidTotalQuantity) {
    
    
    
    
    this.prepaidTotalQuantity = prepaidTotalQuantity.doubleValue();
    return this;
  }

   /**
   * **Note**: This field is only available if you have the [Prepaid with Drawdown](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/J_Billing_Operations/Prepaid_with_Drawdown) feature enabled.  To use this field, you must set the &#x60;X-Zuora-WSDL-Version&#x60; request header to 114 or higher. Otherwise, an error occurs.   The total amount of units that end customers can use during a validity period when they subscribe to a [prepayment charge](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/J_Billing_Operations/Prepaid_with_Drawdown/Create_prepayment_charge). 
   * @return prepaidTotalQuantity
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "**Note**: This field is only available if you have the [Prepaid with Drawdown](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/J_Billing_Operations/Prepaid_with_Drawdown) feature enabled.  To use this field, you must set the `X-Zuora-WSDL-Version` request header to 114 or higher. Otherwise, an error occurs.   The total amount of units that end customers can use during a validity period when they subscribe to a [prepayment charge](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/J_Billing_Operations/Prepaid_with_Drawdown/Create_prepayment_charge). ")

  public Double getPrepaidTotalQuantity() {
    return prepaidTotalQuantity;
  }


  public void setPrepaidTotalQuantity(Double prepaidTotalQuantity) {
    
    
    
    this.prepaidTotalQuantity = prepaidTotalQuantity;
  }


  public ProxyCreateProductRatePlanCharge prepaidUom(String prepaidUom) {
    
    
    
    
    this.prepaidUom = prepaidUom;
    return this;
  }

   /**
   * **Note**: This field is only available if you have the [Prepaid with Drawdown](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/J_Billing_Operations/Prepaid_with_Drawdown) feature enabled.  To use this field, you must set the &#x60;X-Zuora-WSDL-Version&#x60; request header to 114 or higher. Otherwise, an error occurs.  Unit of measurement for a [prepayment charge](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/J_Billing_Operations/Prepaid_with_Drawdown/Create_prepayment_charge). 
   * @return prepaidUom
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "**Note**: This field is only available if you have the [Prepaid with Drawdown](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/J_Billing_Operations/Prepaid_with_Drawdown) feature enabled.  To use this field, you must set the `X-Zuora-WSDL-Version` request header to 114 or higher. Otherwise, an error occurs.  Unit of measurement for a [prepayment charge](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/J_Billing_Operations/Prepaid_with_Drawdown/Create_prepayment_charge). ")

  public String getPrepaidUom() {
    return prepaidUom;
  }


  public void setPrepaidUom(String prepaidUom) {
    
    
    
    this.prepaidUom = prepaidUom;
  }


  public ProxyCreateProductRatePlanCharge priceChangeOption(PriceChangeOptionEnum priceChangeOption) {
    
    
    
    
    this.priceChangeOption = priceChangeOption;
    return this;
  }

   /**
   * Applies an automatic price change when a termed subscription is renewed. 
   * @return priceChangeOption
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "NOCHANGE", value = "Applies an automatic price change when a termed subscription is renewed. ")

  public PriceChangeOptionEnum getPriceChangeOption() {
    return priceChangeOption;
  }


  public void setPriceChangeOption(PriceChangeOptionEnum priceChangeOption) {
    
    
    
    this.priceChangeOption = priceChangeOption;
  }


  public ProxyCreateProductRatePlanCharge priceIncreaseOption(PriceIncreaseOptionEnum priceIncreaseOption) {
    
    
    
    
    this.priceIncreaseOption = priceIncreaseOption;
    return this;
  }

   /**
   * Applies an automatic price change when a termed subscription is renewed. 
   * @return priceIncreaseOption
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Applies an automatic price change when a termed subscription is renewed. ")

  public PriceIncreaseOptionEnum getPriceIncreaseOption() {
    return priceIncreaseOption;
  }


  public void setPriceIncreaseOption(PriceIncreaseOptionEnum priceIncreaseOption) {
    
    
    
    this.priceIncreaseOption = priceIncreaseOption;
  }


  public ProxyCreateProductRatePlanCharge priceIncreasePercentage(Double priceIncreasePercentage) {
    
    
    
    
    this.priceIncreasePercentage = priceIncreasePercentage;
    return this;
  }

   /**
   * Specifies the percentage to increase or decrease the price of a termed subscription&#39;s renewal. Use this field if you set the value to &#x60;SpecificPercentageValue&#x60;.  **Character limit**: 16  **Values**: a decimal value between -100 and 100 
   * @return priceIncreasePercentage
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Specifies the percentage to increase or decrease the price of a termed subscription's renewal. Use this field if you set the value to `SpecificPercentageValue`.  **Character limit**: 16  **Values**: a decimal value between -100 and 100 ")

  public Double getPriceIncreasePercentage() {
    return priceIncreasePercentage;
  }


  public void setPriceIncreasePercentage(Double priceIncreasePercentage) {
    
    
    
    this.priceIncreasePercentage = priceIncreasePercentage;
  }


  public ProxyCreateProductRatePlanCharge productCategory(String productCategory) {
    
    
    
    
    this.productCategory = productCategory;
    return this;
  }

   /**
   * This field is used to maintain the product category for integration with Zuora Revenue.   **Notes**:    - This field is available only if you have the Additional Revenue Fields property enabled.   - To use this field, you must set the &#x60;X-Zuora-WSDL-Version&#x60; request header to 132 or later.  
   * @return productCategory
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "This field is used to maintain the product category for integration with Zuora Revenue.   **Notes**:    - This field is available only if you have the Additional Revenue Fields property enabled.   - To use this field, you must set the `X-Zuora-WSDL-Version` request header to 132 or later.  ")

  public String getProductCategory() {
    return productCategory;
  }


  public void setProductCategory(String productCategory) {
    
    
    
    this.productCategory = productCategory;
  }


  public ProxyCreateProductRatePlanCharge productClass(String productClass) {
    
    
    
    
    this.productClass = productClass;
    return this;
  }

   /**
   * This field is used to maintain the product class for integration with Zuora Revenue.   **Notes**:    - This field is available only if you have the Additional Revenue Fields property enabled.   - To use this field, you must set the &#x60;X-Zuora-WSDL-Version&#x60; request header to 132 or later.  
   * @return productClass
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "This field is used to maintain the product class for integration with Zuora Revenue.   **Notes**:    - This field is available only if you have the Additional Revenue Fields property enabled.   - To use this field, you must set the `X-Zuora-WSDL-Version` request header to 132 or later.  ")

  public String getProductClass() {
    return productClass;
  }


  public void setProductClass(String productClass) {
    
    
    
    this.productClass = productClass;
  }


  public ProxyCreateProductRatePlanCharge productFamily(String productFamily) {
    
    
    
    
    this.productFamily = productFamily;
    return this;
  }

   /**
   * This field is used to maintain the product family for integration with Zuora Revenue.   **Notes**:    - This field is available only if you have the Additional Revenue Fields property enabled.   - To use this field, you must set the &#x60;X-Zuora-WSDL-Version&#x60; request header to 132 or later.  
   * @return productFamily
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "This field is used to maintain the product family for integration with Zuora Revenue.   **Notes**:    - This field is available only if you have the Additional Revenue Fields property enabled.   - To use this field, you must set the `X-Zuora-WSDL-Version` request header to 132 or later.  ")

  public String getProductFamily() {
    return productFamily;
  }


  public void setProductFamily(String productFamily) {
    
    
    
    this.productFamily = productFamily;
  }


  public ProxyCreateProductRatePlanCharge productLine(String productLine) {
    
    
    
    
    this.productLine = productLine;
    return this;
  }

   /**
   * This field is used to maintain the product line for integration with Zuora Revenue.   **Notes**:    - This field is available only if you have the Additional Revenue Fields property enabled.   - To use this field, you must set the &#x60;X-Zuora-WSDL-Version&#x60; request header to 132 or later.          
   * @return productLine
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "This field is used to maintain the product line for integration with Zuora Revenue.   **Notes**:    - This field is available only if you have the Additional Revenue Fields property enabled.   - To use this field, you must set the `X-Zuora-WSDL-Version` request header to 132 or later.          ")

  public String getProductLine() {
    return productLine;
  }


  public void setProductLine(String productLine) {
    
    
    
    this.productLine = productLine;
  }


  public ProxyCreateProductRatePlanCharge revenueRecognitionTiming(RevenueRecognitionTimingEnum revenueRecognitionTiming) {
    
    
    
    
    this.revenueRecognitionTiming = revenueRecognitionTiming;
    return this;
  }

   /**
   * Specifies the type of revenue recognition timing.  Predefined options are listed as enum values in this API Reference.  Other options might also be avaliable depending on  the &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Enable_Order_to_Revenue/Configure_revenue_settings/Configure_revenue_recognition_policy\&quot; target&#x3D;\&quot;_blank\&quot;&gt;revenue recognition policy configuration&lt;/a&gt; in the Zuora Billing UI.  **Note**: This field is only available if you have the Order to Revenue feature enabled.  
   * @return revenueRecognitionTiming
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Specifies the type of revenue recognition timing.  Predefined options are listed as enum values in this API Reference.  Other options might also be avaliable depending on  the <a href=\"https://knowledgecenter.zuora.com/Zuora_Billing/Enable_Order_to_Revenue/Configure_revenue_settings/Configure_revenue_recognition_policy\" target=\"_blank\">revenue recognition policy configuration</a> in the Zuora Billing UI.  **Note**: This field is only available if you have the Order to Revenue feature enabled.  ")

  public RevenueRecognitionTimingEnum getRevenueRecognitionTiming() {
    return revenueRecognitionTiming;
  }


  public void setRevenueRecognitionTiming(RevenueRecognitionTimingEnum revenueRecognitionTiming) {
    
    
    
    this.revenueRecognitionTiming = revenueRecognitionTiming;
  }


  public ProxyCreateProductRatePlanCharge revenueAmortizationMethod(RevenueAmortizationMethodEnum revenueAmortizationMethod) {
    
    
    
    
    this.revenueAmortizationMethod = revenueAmortizationMethod;
    return this;
  }

   /**
   * Specifies the type of revenue amortization method.  Predefined options are listed as enum values in this API Reference.  Other options might also be avaliable depending on  the &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Enable_Order_to_Revenue/Configure_revenue_settings/Configure_revenue_recognition_policy\&quot; target&#x3D;\&quot;_blank\&quot;&gt;revenue recognition policy configuration&lt;/a&gt; in the Zuora Billing UI.  **Note**: This field is only available if you have the Order to Revenue feature enabled.  
   * @return revenueAmortizationMethod
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Specifies the type of revenue amortization method.  Predefined options are listed as enum values in this API Reference.  Other options might also be avaliable depending on  the <a href=\"https://knowledgecenter.zuora.com/Zuora_Billing/Enable_Order_to_Revenue/Configure_revenue_settings/Configure_revenue_recognition_policy\" target=\"_blank\">revenue recognition policy configuration</a> in the Zuora Billing UI.  **Note**: This field is only available if you have the Order to Revenue feature enabled.  ")

  public RevenueAmortizationMethodEnum getRevenueAmortizationMethod() {
    return revenueAmortizationMethod;
  }


  public void setRevenueAmortizationMethod(RevenueAmortizationMethodEnum revenueAmortizationMethod) {
    
    
    
    this.revenueAmortizationMethod = revenueAmortizationMethod;
  }


  public ProxyCreateProductRatePlanCharge productRatePlanChargeNumber(String productRatePlanChargeNumber) {
    
    
    
    
    this.productRatePlanChargeNumber = productRatePlanChargeNumber;
    return this;
  }

   /**
   * The natural key of the product rate plan charge.  **Values**:    - leave null for automatically generated string   - an alphanumeric string of 100 characters or fewer  **Note**: This field is only available if you set the &#x60;X-Zuora-WSDL-Version&#x60; request header to &#x60;133&#x60; or later. 
   * @return productRatePlanChargeNumber
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The natural key of the product rate plan charge.  **Values**:    - leave null for automatically generated string   - an alphanumeric string of 100 characters or fewer  **Note**: This field is only available if you set the `X-Zuora-WSDL-Version` request header to `133` or later. ")

  public String getProductRatePlanChargeNumber() {
    return productRatePlanChargeNumber;
  }


  public void setProductRatePlanChargeNumber(String productRatePlanChargeNumber) {
    
    
    
    this.productRatePlanChargeNumber = productRatePlanChargeNumber;
  }


  public ProxyCreateProductRatePlanCharge productRatePlanChargeTierData(ProxyCreateOrModifyProductRatePlanChargeTierData productRatePlanChargeTierData) {
    
    
    
    
    this.productRatePlanChargeTierData = productRatePlanChargeTierData;
    return this;
  }

   /**
   * Get productRatePlanChargeTierData
   * @return productRatePlanChargeTierData
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")

  public ProxyCreateOrModifyProductRatePlanChargeTierData getProductRatePlanChargeTierData() {
    return productRatePlanChargeTierData;
  }


  public void setProductRatePlanChargeTierData(ProxyCreateOrModifyProductRatePlanChargeTierData productRatePlanChargeTierData) {
    
    
    
    this.productRatePlanChargeTierData = productRatePlanChargeTierData;
  }


  public ProxyCreateProductRatePlanCharge productRatePlanId(String productRatePlanId) {
    
    
    
    
    this.productRatePlanId = productRatePlanId;
    return this;
  }

   /**
   * The ID of the product rate plan associated with this product rate plan charge. 
   * @return productRatePlanId
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "The ID of the product rate plan associated with this product rate plan charge. ")

  public String getProductRatePlanId() {
    return productRatePlanId;
  }


  public void setProductRatePlanId(String productRatePlanId) {
    
    
    
    this.productRatePlanId = productRatePlanId;
  }


  public ProxyCreateProductRatePlanCharge ratingGroup(RatingGroupEnum ratingGroup) {
    
    
    
    
    this.ratingGroup = ratingGroup;
    return this;
  }

   /**
   * Specifies a rating group based on which usage records are rated.  Possible values:                   - &#x60;ByBillingPeriod&#x60;: The rating is based on all the usages in a billing period.    - &#x60;ByUsageStartDate&#x60;: The rating is based on all the usages on the same usage start date.    - &#x60;ByUsageRecord&#x60;: The rating is based on each usage record.   - &#x60;ByUsageUpload&#x60;: The rating is based on all the  usages in a uploaded usage file (&#x60;.xls&#x60; or &#x60;.csv&#x60;).   - &#x60;ByGroupId&#x60;: The rating is based on all the usages in a custom group.  **Notes:**    - The &#x60;ByBillingPeriod&#x60; value can be applied for all charge models.    - The &#x60;ByUsageStartDate&#x60;, &#x60;ByUsageRecord&#x60;, and &#x60;ByUsageUpload&#x60; values can only be applied for per unit, volume pricing, and tiered pricing charge models.    - The &#x60;ByGroupId&#x60; value is only available if you have the Active Rating feature enabled.   - Use this field only for Usage charges. One-Time Charges and Recurring Charges return &#x60;NULL&#x60;. 
   * @return ratingGroup
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "BYBILLINGPERIOD", value = "Specifies a rating group based on which usage records are rated.  Possible values:                   - `ByBillingPeriod`: The rating is based on all the usages in a billing period.    - `ByUsageStartDate`: The rating is based on all the usages on the same usage start date.    - `ByUsageRecord`: The rating is based on each usage record.   - `ByUsageUpload`: The rating is based on all the  usages in a uploaded usage file (`.xls` or `.csv`).   - `ByGroupId`: The rating is based on all the usages in a custom group.  **Notes:**    - The `ByBillingPeriod` value can be applied for all charge models.    - The `ByUsageStartDate`, `ByUsageRecord`, and `ByUsageUpload` values can only be applied for per unit, volume pricing, and tiered pricing charge models.    - The `ByGroupId` value is only available if you have the Active Rating feature enabled.   - Use this field only for Usage charges. One-Time Charges and Recurring Charges return `NULL`. ")

  public RatingGroupEnum getRatingGroup() {
    return ratingGroup;
  }


  public void setRatingGroup(RatingGroupEnum ratingGroup) {
    
    
    
    this.ratingGroup = ratingGroup;
  }


  public ProxyCreateProductRatePlanCharge recognizedRevenueAccount(String recognizedRevenueAccount) {
    
    
    
    
    this.recognizedRevenueAccount = recognizedRevenueAccount;
    return this;
  }

   /**
   * The name of the recognized revenue account for this charge.   - Required when the Allow Blank Accounting Code setting is No.   - Optional when the Allow Blank Accounting Code setting is Yes.    This feature is in **Limited Availability**. If you wish to have access to the feature, submit a request at [Zuora Global Support](http://support.zuora.com/).  
   * @return recognizedRevenueAccount
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The name of the recognized revenue account for this charge.   - Required when the Allow Blank Accounting Code setting is No.   - Optional when the Allow Blank Accounting Code setting is Yes.    This feature is in **Limited Availability**. If you wish to have access to the feature, submit a request at [Zuora Global Support](http://support.zuora.com/).  ")

  public String getRecognizedRevenueAccount() {
    return recognizedRevenueAccount;
  }


  public void setRecognizedRevenueAccount(String recognizedRevenueAccount) {
    
    
    
    this.recognizedRevenueAccount = recognizedRevenueAccount;
  }


  public ProxyCreateProductRatePlanCharge revRecCode(String revRecCode) {
    
    
    
    
    this.revRecCode = revRecCode;
    return this;
  }

   /**
   * Associates this product rate plan charge with a specific revenue recognition code. 
   * @return revRecCode
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Associates this product rate plan charge with a specific revenue recognition code. ")

  public String getRevRecCode() {
    return revRecCode;
  }


  public void setRevRecCode(String revRecCode) {
    
    
    
    this.revRecCode = revRecCode;
  }


  public ProxyCreateProductRatePlanCharge revRecTriggerCondition(RevRecTriggerConditionEnum revRecTriggerCondition) {
    
    
    
    
    this.revRecTriggerCondition = revRecTriggerCondition;
    return this;
  }

   /**
   * Specifies when revenue recognition begins. 
   * @return revRecTriggerCondition
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Specifies when revenue recognition begins. ")

  public RevRecTriggerConditionEnum getRevRecTriggerCondition() {
    return revRecTriggerCondition;
  }


  public void setRevRecTriggerCondition(RevRecTriggerConditionEnum revRecTriggerCondition) {
    
    
    
    this.revRecTriggerCondition = revRecTriggerCondition;
  }


  public ProxyCreateProductRatePlanCharge revenueRecognitionRuleName(RevenueRecognitionRuleNameEnum revenueRecognitionRuleName) {
    
    
    
    
    this.revenueRecognitionRuleName = revenueRecognitionRuleName;
    return this;
  }

   /**
   * Determines when to recognize the revenue for this charge. 
   * @return revenueRecognitionRuleName
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Determines when to recognize the revenue for this charge. ")

  public RevenueRecognitionRuleNameEnum getRevenueRecognitionRuleName() {
    return revenueRecognitionRuleName;
  }


  public void setRevenueRecognitionRuleName(RevenueRecognitionRuleNameEnum revenueRecognitionRuleName) {
    
    
    
    this.revenueRecognitionRuleName = revenueRecognitionRuleName;
  }


  public ProxyCreateProductRatePlanCharge rolloverApply(RolloverApplyEnum rolloverApply) {
    
    
    
    
    this.rolloverApply = rolloverApply;
    return this;
  }

   /**
   * **Note**: This field is only available if you have the [Prepaid with Drawdown](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/J_Billing_Operations/Prepaid_with_Drawdown) feature enabled.  To use this field, you must set the &#x60;X-Zuora-WSDL-Version&#x60; request header to 114 or higher. Otherwise, an error occurs.  This field defines the priority of rollover, which is either first or last. 
   * @return rolloverApply
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "**Note**: This field is only available if you have the [Prepaid with Drawdown](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/J_Billing_Operations/Prepaid_with_Drawdown) feature enabled.  To use this field, you must set the `X-Zuora-WSDL-Version` request header to 114 or higher. Otherwise, an error occurs.  This field defines the priority of rollover, which is either first or last. ")

  public RolloverApplyEnum getRolloverApply() {
    return rolloverApply;
  }


  public void setRolloverApply(RolloverApplyEnum rolloverApply) {
    
    
    
    this.rolloverApply = rolloverApply;
  }


  public ProxyCreateProductRatePlanCharge rolloverPeriods(Double rolloverPeriods) {
    
    
    
    
    this.rolloverPeriods = rolloverPeriods;
    return this;
  }

  public ProxyCreateProductRatePlanCharge rolloverPeriods(Integer rolloverPeriods) {
    
    
    
    
    this.rolloverPeriods = rolloverPeriods.doubleValue();
    return this;
  }

   /**
   * **Note**: This field is only available if you have the [Prepaid with Drawdown](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/J_Billing_Operations/Prepaid_with_Drawdown) feature enabled.  To use this field, you must set the &#x60;X-Zuora-WSDL-Version&#x60; request header to 114 or higher. Otherwise, an error occurs.  This field defines the number of rollover periods, it is restricted to 3. 
   * @return rolloverPeriods
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "**Note**: This field is only available if you have the [Prepaid with Drawdown](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/J_Billing_Operations/Prepaid_with_Drawdown) feature enabled.  To use this field, you must set the `X-Zuora-WSDL-Version` request header to 114 or higher. Otherwise, an error occurs.  This field defines the number of rollover periods, it is restricted to 3. ")

  public Double getRolloverPeriods() {
    return rolloverPeriods;
  }


  public void setRolloverPeriods(Double rolloverPeriods) {
    
    
    
    this.rolloverPeriods = rolloverPeriods;
  }


  public ProxyCreateProductRatePlanCharge smoothingModel(SmoothingModelEnum smoothingModel) {
    
    
    
    
    this.smoothingModel = smoothingModel;
    return this;
  }

   /**
   * Specifies the smoothing model for an overage smoothing charge model. 
   * @return smoothingModel
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Specifies the smoothing model for an overage smoothing charge model. ")

  public SmoothingModelEnum getSmoothingModel() {
    return smoothingModel;
  }


  public void setSmoothingModel(SmoothingModelEnum smoothingModel) {
    
    
    
    this.smoothingModel = smoothingModel;
  }


  public ProxyCreateProductRatePlanCharge specificBillingPeriod(Long specificBillingPeriod) {
    
    
    
    
    this.specificBillingPeriod = specificBillingPeriod;
    return this;
  }

   /**
   * Customizes the number of months or weeks for the charges billing period. This field is required if you set the value of the BillingPeriod field to &#x60;Specific Months&#x60; or &#x60;Specific Weeks&#x60;. The valid value is a positive integer. 
   * @return specificBillingPeriod
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Customizes the number of months or weeks for the charges billing period. This field is required if you set the value of the BillingPeriod field to `Specific Months` or `Specific Weeks`. The valid value is a positive integer. ")

  public Long getSpecificBillingPeriod() {
    return specificBillingPeriod;
  }


  public void setSpecificBillingPeriod(Long specificBillingPeriod) {
    
    
    
    this.specificBillingPeriod = specificBillingPeriod;
  }


  public ProxyCreateProductRatePlanCharge specificListPriceBase(Integer specificListPriceBase) {
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
   * The number of months for the list price base of the charge. This field is required if you set the value of the &#x60;ListPriceBase&#x60; field to &#x60;Per Specific Months&#x60;.  **Notes**:    - This field is available only if you have the &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Billing/Subscriptions/Product_Catalog/I_Annual_List_Price\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Annual List Price&lt;/a&gt; feature enabled.   - To use this field, you must set the &#x60;X-Zuora-WSDL-Version&#x60; request header to &#x60;129&#x60; or later. Otherwise, an error occurs.   - The value of this field is &#x60;null&#x60; if you do not set the value of the &#x60;ListPriceBase&#x60; field to &#x60;Per Specific Months&#x60;. 
   * minimum: 1
   * maximum: 200
   * @return specificListPriceBase
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The number of months for the list price base of the charge. This field is required if you set the value of the `ListPriceBase` field to `Per Specific Months`.  **Notes**:    - This field is available only if you have the <a href=\"https://knowledgecenter.zuora.com/Billing/Subscriptions/Product_Catalog/I_Annual_List_Price\" target=\"_blank\">Annual List Price</a> feature enabled.   - To use this field, you must set the `X-Zuora-WSDL-Version` request header to `129` or later. Otherwise, an error occurs.   - The value of this field is `null` if you do not set the value of the `ListPriceBase` field to `Per Specific Months`. ")

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


  public ProxyCreateProductRatePlanCharge taxCode(String taxCode) {
    
    
    
    
    this.taxCode = taxCode;
    return this;
  }

   /**
   * Specifies the tax code for taxation rules. Required when the Taxable field is set to &#x60;True&#x60;.  **Note**: This value affects the tax calculation of rate plan charges that come from the &#x60;ProductRatePlanCharge&#x60;. 
   * @return taxCode
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Specifies the tax code for taxation rules. Required when the Taxable field is set to `True`.  **Note**: This value affects the tax calculation of rate plan charges that come from the `ProductRatePlanCharge`. ")

  public String getTaxCode() {
    return taxCode;
  }


  public void setTaxCode(String taxCode) {
    
    
    
    this.taxCode = taxCode;
  }


  public ProxyCreateProductRatePlanCharge taxMode(TaxModeEnum taxMode) {
    
    
    
    
    this.taxMode = taxMode;
    return this;
  }

   /**
   * Determines how to define taxation for the charge. Required when the Taxable field is set to &#x60;True&#x60;.  **Note**: This value affects the tax calculation of rate plan charges that come from the &#x60;ProductRatePlanCharge&#x60;. 
   * @return taxMode
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Determines how to define taxation for the charge. Required when the Taxable field is set to `True`.  **Note**: This value affects the tax calculation of rate plan charges that come from the `ProductRatePlanCharge`. ")

  public TaxModeEnum getTaxMode() {
    return taxMode;
  }


  public void setTaxMode(TaxModeEnum taxMode) {
    
    
    
    this.taxMode = taxMode;
  }


  public ProxyCreateProductRatePlanCharge taxable(Boolean taxable) {
    
    
    
    
    this.taxable = taxable;
    return this;
  }

   /**
   * Determines whether the charge is taxable. When set to &#x60;True&#x60;, the TaxMode and TaxCode fields are required when creating or updating th ProductRatePlanCharge object.  **Character limit**: 5  **Values**: &#x60;True&#x60;, &#x60;False&#x60;  **Note**: This value affects the tax calculation of rate plan charges that come from the &#x60;ProductRatePlanCharge&#x60;. 
   * @return taxable
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Determines whether the charge is taxable. When set to `True`, the TaxMode and TaxCode fields are required when creating or updating th ProductRatePlanCharge object.  **Character limit**: 5  **Values**: `True`, `False`  **Note**: This value affects the tax calculation of rate plan charges that come from the `ProductRatePlanCharge`. ")

  public Boolean getTaxable() {
    return taxable;
  }


  public void setTaxable(Boolean taxable) {
    
    
    
    this.taxable = taxable;
  }


  public ProxyCreateProductRatePlanCharge triggerEvent(TriggerEventEnum triggerEvent) {
    
    
    
    
    this.triggerEvent = triggerEvent;
    return this;
  }

   /**
   * Specifies when to start billing the customer for the charge.  **Values**:   - &#x60;ContractEffective&#x60; is the date when the subscription&#39;s contract goes into effect and the charge is ready to be billed.   - &#x60;ServiceActivation&#x60; is the date when the services or products for a subscription have been activated and the customers have access.   - &#x60;CustomerAcceptance&#x60; is when the customer accepts the services or products for a subscription. 
   * @return triggerEvent
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "Specifies when to start billing the customer for the charge.  **Values**:   - `ContractEffective` is the date when the subscription's contract goes into effect and the charge is ready to be billed.   - `ServiceActivation` is the date when the services or products for a subscription have been activated and the customers have access.   - `CustomerAcceptance` is when the customer accepts the services or products for a subscription. ")

  public TriggerEventEnum getTriggerEvent() {
    return triggerEvent;
  }


  public void setTriggerEvent(TriggerEventEnum triggerEvent) {
    
    
    
    this.triggerEvent = triggerEvent;
  }


  public ProxyCreateProductRatePlanCharge UOM(String UOM) {
    
    
    
    
    this.UOM = UOM;
    return this;
  }

   /**
   * Specifies a configured unit to measure usage.   **Note**: You must specify this field when creating the following charge models:   - Per Unit Pricing   - Volume Pricing   - Overage Pricing   - Tiered Pricing   - Tiered with Overage Pricing 
   * @return UOM
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Specifies a configured unit to measure usage.   **Note**: You must specify this field when creating the following charge models:   - Per Unit Pricing   - Volume Pricing   - Overage Pricing   - Tiered Pricing   - Tiered with Overage Pricing ")

  public String getUOM() {
    return UOM;
  }


  public void setUOM(String UOM) {
    
    
    
    this.UOM = UOM;
  }


  public ProxyCreateProductRatePlanCharge upToPeriods(Long upToPeriods) {
    
    
    
    
    this.upToPeriods = upToPeriods;
    return this;
  }

   /**
   * Specifies the length of the period during which the charge is active. If this period ends before the subscription ends, the charge ends when this period ends.  **Character limit**: 5  **Values**: a whole number between 0 and 65535, exclusive  **Notes**:   - You must use this field together with the &#x60;UpToPeriodsType&#x60; field to specify the time period. This field is applicable only when the &#x60;EndDateCondition&#x60; field is set to &#x60;FixedPeriod&#x60;.    - If the subscription end date is subsequently changed through a Renewal, or Terms and Conditions amendment, the charge end date will change accordingly up to the original period end. 
   * @return upToPeriods
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Specifies the length of the period during which the charge is active. If this period ends before the subscription ends, the charge ends when this period ends.  **Character limit**: 5  **Values**: a whole number between 0 and 65535, exclusive  **Notes**:   - You must use this field together with the `UpToPeriodsType` field to specify the time period. This field is applicable only when the `EndDateCondition` field is set to `FixedPeriod`.    - If the subscription end date is subsequently changed through a Renewal, or Terms and Conditions amendment, the charge end date will change accordingly up to the original period end. ")

  public Long getUpToPeriods() {
    return upToPeriods;
  }


  public void setUpToPeriods(Long upToPeriods) {
    
    
    
    this.upToPeriods = upToPeriods;
  }


  public ProxyCreateProductRatePlanCharge upToPeriodsType(UpToPeriodsTypeEnum upToPeriodsType) {
    
    
    
    
    this.upToPeriodsType = upToPeriodsType;
    return this;
  }

   /**
   * The period type used to define when the charge ends.  **Notes**:   - You must use this field together with the &#x60;UpToPeriods&#x60; field to specify the time period.  - This field is applicable only when the &#x60;EndDateCondition&#x60; field is set to &#x60;FixedPeriod&#x60;.  
   * @return upToPeriodsType
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "BILLING_PERIODS", value = "The period type used to define when the charge ends.  **Notes**:   - You must use this field together with the `UpToPeriods` field to specify the time period.  - This field is applicable only when the `EndDateCondition` field is set to `FixedPeriod`.  ")

  public UpToPeriodsTypeEnum getUpToPeriodsType() {
    return upToPeriodsType;
  }


  public void setUpToPeriodsType(UpToPeriodsTypeEnum upToPeriodsType) {
    
    
    
    this.upToPeriodsType = upToPeriodsType;
  }


  public ProxyCreateProductRatePlanCharge usageRecordRatingOption(UsageRecordRatingOptionEnum usageRecordRatingOption) {
    
    
    
    
    this.usageRecordRatingOption = usageRecordRatingOption;
    return this;
  }

   /**
   * Determines how Zuora processes usage records for per-unit usage charges.  
   * @return usageRecordRatingOption
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "ENDOFBILLINGPERIOD", value = "Determines how Zuora processes usage records for per-unit usage charges.  ")

  public UsageRecordRatingOptionEnum getUsageRecordRatingOption() {
    return usageRecordRatingOption;
  }


  public void setUsageRecordRatingOption(UsageRecordRatingOptionEnum usageRecordRatingOption) {
    
    
    
    this.usageRecordRatingOption = usageRecordRatingOption;
  }


  public ProxyCreateProductRatePlanCharge useDiscountSpecificAccountingCode(Boolean useDiscountSpecificAccountingCode) {
    
    
    
    
    this.useDiscountSpecificAccountingCode = useDiscountSpecificAccountingCode;
    return this;
  }

   /**
   * Determines whether to define a new accounting code for the new discount charge.  **Character limit**: 5  **Values**: &#x60;True&#x60;, &#x60;False&#x60; 
   * @return useDiscountSpecificAccountingCode
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(required = true, value = "Determines whether to define a new accounting code for the new discount charge.  **Character limit**: 5  **Values**: `True`, `False` ")

  public Boolean getUseDiscountSpecificAccountingCode() {
    return useDiscountSpecificAccountingCode;
  }


  public void setUseDiscountSpecificAccountingCode(Boolean useDiscountSpecificAccountingCode) {
    
    
    
    this.useDiscountSpecificAccountingCode = useDiscountSpecificAccountingCode;
  }


  public ProxyCreateProductRatePlanCharge useTenantDefaultForPriceChange(Boolean useTenantDefaultForPriceChange) {
    
    
    
    
    this.useTenantDefaultForPriceChange = useTenantDefaultForPriceChange;
    return this;
  }

   /**
   * Applies the tenant-level percentage uplift value for an automatic price change to a termed subscription&#39;s renewal.   **Character limit**: 5  **Values**: &#x60;true&#x60;, &#x60;false&#x60; 
   * @return useTenantDefaultForPriceChange
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Applies the tenant-level percentage uplift value for an automatic price change to a termed subscription's renewal.   **Character limit**: 5  **Values**: `true`, `false` ")

  public Boolean getUseTenantDefaultForPriceChange() {
    return useTenantDefaultForPriceChange;
  }


  public void setUseTenantDefaultForPriceChange(Boolean useTenantDefaultForPriceChange) {
    
    
    
    this.useTenantDefaultForPriceChange = useTenantDefaultForPriceChange;
  }


  public ProxyCreateProductRatePlanCharge validityPeriodType(ValidityPeriodTypeEnum validityPeriodType) {
    
    
    
    
    this.validityPeriodType = validityPeriodType;
    return this;
  }

   /**
   * **Note**: This field is only available if you have the [Prepaid with Drawdown](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/J_Billing_Operations/Prepaid_with_Drawdown) feature enabled.  To use this field, you must set the &#x60;X-Zuora-WSDL-Version&#x60; request header to 114 or higher. Otherwise, an error occurs.   The period in which the prepayment units are valid to use as defined in a [prepayment charge](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/J_Billing_Operations/Prepaid_with_Drawdown/Create_prepayment_charge). 
   * @return validityPeriodType
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "**Note**: This field is only available if you have the [Prepaid with Drawdown](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/J_Billing_Operations/Prepaid_with_Drawdown) feature enabled.  To use this field, you must set the `X-Zuora-WSDL-Version` request header to 114 or higher. Otherwise, an error occurs.   The period in which the prepayment units are valid to use as defined in a [prepayment charge](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/J_Billing_Operations/Prepaid_with_Drawdown/Create_prepayment_charge). ")

  public ValidityPeriodTypeEnum getValidityPeriodType() {
    return validityPeriodType;
  }


  public void setValidityPeriodType(ValidityPeriodTypeEnum validityPeriodType) {
    
    
    
    this.validityPeriodType = validityPeriodType;
  }


  public ProxyCreateProductRatePlanCharge weeklyBillCycleDay(WeeklyBillCycleDayEnum weeklyBillCycleDay) {
    
    
    
    
    this.weeklyBillCycleDay = weeklyBillCycleDay;
    return this;
  }

   /**
   * Specifies which day of the week as the bill cycle day (BCD) for the charge.  This feature is in **Limited Availability**. If you wish to have access to the feature, submit a request at [Zuora Global Support](http://support.zuora.com/).  
   * @return weeklyBillCycleDay
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Specifies which day of the week as the bill cycle day (BCD) for the charge.  This feature is in **Limited Availability**. If you wish to have access to the feature, submit a request at [Zuora Global Support](http://support.zuora.com/).  ")

  public WeeklyBillCycleDayEnum getWeeklyBillCycleDay() {
    return weeklyBillCycleDay;
  }


  public void setWeeklyBillCycleDay(WeeklyBillCycleDayEnum weeklyBillCycleDay) {
    
    
    
    this.weeklyBillCycleDay = weeklyBillCycleDay;
  }


  public ProxyCreateProductRatePlanCharge applyToBillingPeriodPartially(Boolean applyToBillingPeriodPartially) {
    
    
    
    
    this.applyToBillingPeriodPartially = applyToBillingPeriodPartially;
    return this;
  }

   /**
   * Allow the discount duration to be aligned with the billing period partially.  **Note**: You must enable the [Enhanced Discount](https://knowledgecenter.zuora.com/Zuora_Billing/Build_products_and_prices/Basic_concepts_and_terms/B_Charge_Models/D_Manage_Enhanced_Discount) feature to access this field. 
   * @return applyToBillingPeriodPartially
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Allow the discount duration to be aligned with the billing period partially.  **Note**: You must enable the [Enhanced Discount](https://knowledgecenter.zuora.com/Zuora_Billing/Build_products_and_prices/Basic_concepts_and_terms/B_Charge_Models/D_Manage_Enhanced_Discount) feature to access this field. ")

  public Boolean getApplyToBillingPeriodPartially() {
    return applyToBillingPeriodPartially;
  }


  public void setApplyToBillingPeriodPartially(Boolean applyToBillingPeriodPartially) {
    
    
    
    this.applyToBillingPeriodPartially = applyToBillingPeriodPartially;
  }


  public ProxyCreateProductRatePlanCharge rolloverPeriodLength(Integer rolloverPeriodLength) {
    
    
    
    
    this.rolloverPeriodLength = rolloverPeriodLength;
    return this;
  }

   /**
   * **Note**: This field is only available if you have the [Prepaid with Drawdown](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/J_Billing_Operations/Prepaid_with_Drawdown) feature enabled.  To use this field, you must set the &#x60;X-Zuora-WSDL-Version&#x60; request header to 137 or higher. Otherwise, an error occurs.  The period length of the rollover fund. If this field is set as optional, then you can modify the value. The limit for the value should be 1 which should be lesser than equal to the specified period that is lesser than equal to the validity period&#39;s length. 
   * @return rolloverPeriodLength
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "**Note**: This field is only available if you have the [Prepaid with Drawdown](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/J_Billing_Operations/Prepaid_with_Drawdown) feature enabled.  To use this field, you must set the `X-Zuora-WSDL-Version` request header to 137 or higher. Otherwise, an error occurs.  The period length of the rollover fund. If this field is set as optional, then you can modify the value. The limit for the value should be 1 which should be lesser than equal to the specified period that is lesser than equal to the validity period's length. ")

  public Integer getRolloverPeriodLength() {
    return rolloverPeriodLength;
  }


  public void setRolloverPeriodLength(Integer rolloverPeriodLength) {
    
    
    
    this.rolloverPeriodLength = rolloverPeriodLength;
  }


  public ProxyCreateProductRatePlanCharge formula(String formula) {
    
    
    
    
    this.formula = formula;
    return this;
  }

   /**
   * The price lookup formula defined for the product rate plan charge, which is used to identify the correct and relevant charge definition based on the context.  For more information, see &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Build_products_and_prices/Attribute-based_pricing/Price_lookup_in_Attribute-based_Pricing\&quot;  target&#x3D;\&quot;_blank\&quot;&gt;Price lookup in Attribute-based Pricing&lt;/a&gt;.  **Notes**:    - This field is available only if the &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Build_products_and_prices/Attribute-based_pricing\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Attribute-based Pricing&lt;/a&gt; feature is enabled.   - To use this field, you must set the &#x60;X-Zuora-WSDL-Version&#x60; request header to 138 or higher. 
   * @return formula
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The price lookup formula defined for the product rate plan charge, which is used to identify the correct and relevant charge definition based on the context.  For more information, see <a href=\"https://knowledgecenter.zuora.com/Zuora_Billing/Build_products_and_prices/Attribute-based_pricing/Price_lookup_in_Attribute-based_Pricing\"  target=\"_blank\">Price lookup in Attribute-based Pricing</a>.  **Notes**:    - This field is available only if the <a href=\"https://knowledgecenter.zuora.com/Zuora_Billing/Build_products_and_prices/Attribute-based_pricing\" target=\"_blank\">Attribute-based Pricing</a> feature is enabled.   - To use this field, you must set the `X-Zuora-WSDL-Version` request header to 138 or higher. ")

  public String getFormula() {
    return formula;
  }


  public void setFormula(String formula) {
    
    
    
    this.formula = formula;
  }


  public ProxyCreateProductRatePlanCharge classNS(String classNS) {
    
    
    
    
    this.classNS = classNS;
    return this;
  }

   /**
   * Class associated with the corresponding item in NetSuite. Only available if you have installed the [Zuora Connector for NetSuite](https://www.zuora.com/connect/app/?appId&#x3D;265). 
   * @return classNS
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Class associated with the corresponding item in NetSuite. Only available if you have installed the [Zuora Connector for NetSuite](https://www.zuora.com/connect/app/?appId=265). ")

  public String getClassNS() {
    return classNS;
  }


  public void setClassNS(String classNS) {
    
    
    
    this.classNS = classNS;
  }


  public ProxyCreateProductRatePlanCharge deferredRevAccountNS(String deferredRevAccountNS) {
    
    
    
    
    this.deferredRevAccountNS = deferredRevAccountNS;
    return this;
  }

   /**
   * Deferrred revenue account associated with the corresponding item in NetSuite. Only available if you have installed the [Zuora Connector for NetSuite](https://www.zuora.com/connect/app/?appId&#x3D;265). 
   * @return deferredRevAccountNS
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Deferrred revenue account associated with the corresponding item in NetSuite. Only available if you have installed the [Zuora Connector for NetSuite](https://www.zuora.com/connect/app/?appId=265). ")

  public String getDeferredRevAccountNS() {
    return deferredRevAccountNS;
  }


  public void setDeferredRevAccountNS(String deferredRevAccountNS) {
    
    
    
    this.deferredRevAccountNS = deferredRevAccountNS;
  }


  public ProxyCreateProductRatePlanCharge departmentNS(String departmentNS) {
    
    
    
    
    this.departmentNS = departmentNS;
    return this;
  }

   /**
   * Department associated with the corresponding item in NetSuite. Only available if you have installed the [Zuora Connector for NetSuite](https://www.zuora.com/connect/app/?appId&#x3D;265). 
   * @return departmentNS
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Department associated with the corresponding item in NetSuite. Only available if you have installed the [Zuora Connector for NetSuite](https://www.zuora.com/connect/app/?appId=265). ")

  public String getDepartmentNS() {
    return departmentNS;
  }


  public void setDepartmentNS(String departmentNS) {
    
    
    
    this.departmentNS = departmentNS;
  }


  public ProxyCreateProductRatePlanCharge includeChildrenNS(IncludeChildrenNSEnum includeChildrenNS) {
    
    
    
    
    this.includeChildrenNS = includeChildrenNS;
    return this;
  }

   /**
   * Specifies whether the corresponding item in NetSuite is visible under child subsidiaries. Only available if you have installed the [Zuora Connector for NetSuite](https://www.zuora.com/connect/app/?appId&#x3D;265). 
   * @return includeChildrenNS
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Specifies whether the corresponding item in NetSuite is visible under child subsidiaries. Only available if you have installed the [Zuora Connector for NetSuite](https://www.zuora.com/connect/app/?appId=265). ")

  public IncludeChildrenNSEnum getIncludeChildrenNS() {
    return includeChildrenNS;
  }


  public void setIncludeChildrenNS(IncludeChildrenNSEnum includeChildrenNS) {
    
    
    
    this.includeChildrenNS = includeChildrenNS;
  }


  public ProxyCreateProductRatePlanCharge integrationIdNS(String integrationIdNS) {
    
    
    
    
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


  public ProxyCreateProductRatePlanCharge integrationStatusNS(String integrationStatusNS) {
    
    
    
    
    this.integrationStatusNS = integrationStatusNS;
    return this;
  }

   /**
   * Status of the product rate plan charge&#39;s synchronization with NetSuite. Only available if you have installed the [Zuora Connector for NetSuite](https://www.zuora.com/connect/app/?appId&#x3D;265). 
   * @return integrationStatusNS
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Status of the product rate plan charge's synchronization with NetSuite. Only available if you have installed the [Zuora Connector for NetSuite](https://www.zuora.com/connect/app/?appId=265). ")

  public String getIntegrationStatusNS() {
    return integrationStatusNS;
  }


  public void setIntegrationStatusNS(String integrationStatusNS) {
    
    
    
    this.integrationStatusNS = integrationStatusNS;
  }


  public ProxyCreateProductRatePlanCharge itemTypeNS(ItemTypeNSEnum itemTypeNS) {
    
    
    
    
    this.itemTypeNS = itemTypeNS;
    return this;
  }

   /**
   * Type of item that is created in NetSuite for the product rate plan charge. Only available if you have installed the [Zuora Connector for NetSuite](https://www.zuora.com/connect/app/?appId&#x3D;265). 
   * @return itemTypeNS
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Type of item that is created in NetSuite for the product rate plan charge. Only available if you have installed the [Zuora Connector for NetSuite](https://www.zuora.com/connect/app/?appId=265). ")

  public ItemTypeNSEnum getItemTypeNS() {
    return itemTypeNS;
  }


  public void setItemTypeNS(ItemTypeNSEnum itemTypeNS) {
    
    
    
    this.itemTypeNS = itemTypeNS;
  }


  public ProxyCreateProductRatePlanCharge locationNS(String locationNS) {
    
    
    
    
    this.locationNS = locationNS;
    return this;
  }

   /**
   * Location associated with the corresponding item in NetSuite. Only available if you have installed the [Zuora Connector for NetSuite](https://www.zuora.com/connect/app/?appId&#x3D;265). 
   * @return locationNS
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Location associated with the corresponding item in NetSuite. Only available if you have installed the [Zuora Connector for NetSuite](https://www.zuora.com/connect/app/?appId=265). ")

  public String getLocationNS() {
    return locationNS;
  }


  public void setLocationNS(String locationNS) {
    
    
    
    this.locationNS = locationNS;
  }


  public ProxyCreateProductRatePlanCharge recognizedRevAccountNS(String recognizedRevAccountNS) {
    
    
    
    
    this.recognizedRevAccountNS = recognizedRevAccountNS;
    return this;
  }

   /**
   * Recognized revenue account associated with the corresponding item in NetSuite. Only available if you have installed the [Zuora Connector for NetSuite](https://www.zuora.com/connect/app/?appId&#x3D;265). 
   * @return recognizedRevAccountNS
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Recognized revenue account associated with the corresponding item in NetSuite. Only available if you have installed the [Zuora Connector for NetSuite](https://www.zuora.com/connect/app/?appId=265). ")

  public String getRecognizedRevAccountNS() {
    return recognizedRevAccountNS;
  }


  public void setRecognizedRevAccountNS(String recognizedRevAccountNS) {
    
    
    
    this.recognizedRevAccountNS = recognizedRevAccountNS;
  }


  public ProxyCreateProductRatePlanCharge revRecEndNS(RevRecEndNSEnum revRecEndNS) {
    
    
    
    
    this.revRecEndNS = revRecEndNS;
    return this;
  }

   /**
   * End date condition of the corresponding item in NetSuite. Only available if you have installed the [Zuora Connector for NetSuite](https://www.zuora.com/connect/app/?appId&#x3D;265). 
   * @return revRecEndNS
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "End date condition of the corresponding item in NetSuite. Only available if you have installed the [Zuora Connector for NetSuite](https://www.zuora.com/connect/app/?appId=265). ")

  public RevRecEndNSEnum getRevRecEndNS() {
    return revRecEndNS;
  }


  public void setRevRecEndNS(RevRecEndNSEnum revRecEndNS) {
    
    
    
    this.revRecEndNS = revRecEndNS;
  }


  public ProxyCreateProductRatePlanCharge revRecStartNS(RevRecStartNSEnum revRecStartNS) {
    
    
    
    
    this.revRecStartNS = revRecStartNS;
    return this;
  }

   /**
   * Start date condition of the corresponding item in NetSuite. Only available if you have installed the [Zuora Connector for NetSuite](https://www.zuora.com/connect/app/?appId&#x3D;265). 
   * @return revRecStartNS
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Start date condition of the corresponding item in NetSuite. Only available if you have installed the [Zuora Connector for NetSuite](https://www.zuora.com/connect/app/?appId=265). ")

  public RevRecStartNSEnum getRevRecStartNS() {
    return revRecStartNS;
  }


  public void setRevRecStartNS(RevRecStartNSEnum revRecStartNS) {
    
    
    
    this.revRecStartNS = revRecStartNS;
  }


  public ProxyCreateProductRatePlanCharge revRecTemplateTypeNS(String revRecTemplateTypeNS) {
    
    
    
    
    this.revRecTemplateTypeNS = revRecTemplateTypeNS;
    return this;
  }

   /**
   * Only available if you have installed the [Zuora Connector for NetSuite](https://www.zuora.com/connect/app/?appId&#x3D;265). 
   * @return revRecTemplateTypeNS
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Only available if you have installed the [Zuora Connector for NetSuite](https://www.zuora.com/connect/app/?appId=265). ")

  public String getRevRecTemplateTypeNS() {
    return revRecTemplateTypeNS;
  }


  public void setRevRecTemplateTypeNS(String revRecTemplateTypeNS) {
    
    
    
    this.revRecTemplateTypeNS = revRecTemplateTypeNS;
  }


  public ProxyCreateProductRatePlanCharge subsidiaryNS(String subsidiaryNS) {
    
    
    
    
    this.subsidiaryNS = subsidiaryNS;
    return this;
  }

   /**
   * Subsidiary associated with the corresponding item in NetSuite. Only available if you have installed the [Zuora Connector for NetSuite](https://www.zuora.com/connect/app/?appId&#x3D;265). 
   * @return subsidiaryNS
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Subsidiary associated with the corresponding item in NetSuite. Only available if you have installed the [Zuora Connector for NetSuite](https://www.zuora.com/connect/app/?appId=265). ")

  public String getSubsidiaryNS() {
    return subsidiaryNS;
  }


  public void setSubsidiaryNS(String subsidiaryNS) {
    
    
    
    this.subsidiaryNS = subsidiaryNS;
  }


  public ProxyCreateProductRatePlanCharge syncDateNS(String syncDateNS) {
    
    
    
    
    this.syncDateNS = syncDateNS;
    return this;
  }

   /**
   * Date when the product rate plan charge was synchronized with NetSuite. Only available if you have installed the [Zuora Connector for NetSuite](https://www.zuora.com/connect/app/?appId&#x3D;265). 
   * @return syncDateNS
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Date when the product rate plan charge was synchronized with NetSuite. Only available if you have installed the [Zuora Connector for NetSuite](https://www.zuora.com/connect/app/?appId=265). ")

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
   * @return the ProxyCreateProductRatePlanCharge instance itself
   */
  public ProxyCreateProductRatePlanCharge putAdditionalProperty(String key, Object value) {
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
    ProxyCreateProductRatePlanCharge proxyCreateProductRatePlanCharge = (ProxyCreateProductRatePlanCharge) o;
    return Objects.equals(this.accountingCode, proxyCreateProductRatePlanCharge.accountingCode) &&
        Objects.equals(this.applyDiscountTo, proxyCreateProductRatePlanCharge.applyDiscountTo) &&
        Objects.equals(this.billCycleDay, proxyCreateProductRatePlanCharge.billCycleDay) &&
        Objects.equals(this.billCycleType, proxyCreateProductRatePlanCharge.billCycleType) &&
        Objects.equals(this.billingPeriod, proxyCreateProductRatePlanCharge.billingPeriod) &&
        Objects.equals(this.billingPeriodAlignment, proxyCreateProductRatePlanCharge.billingPeriodAlignment) &&
        Objects.equals(this.billingTiming, proxyCreateProductRatePlanCharge.billingTiming) &&
        Objects.equals(this.chargeFunction, proxyCreateProductRatePlanCharge.chargeFunction) &&
        Objects.equals(this.commitmentType, proxyCreateProductRatePlanCharge.commitmentType) &&
        Objects.equals(this.chargeModel, proxyCreateProductRatePlanCharge.chargeModel) &&
        Objects.equals(this.chargeModelConfiguration, proxyCreateProductRatePlanCharge.chargeModelConfiguration) &&
        Objects.equals(this.chargeType, proxyCreateProductRatePlanCharge.chargeType) &&
        Objects.equals(this.creditOption, proxyCreateProductRatePlanCharge.creditOption) &&
        Objects.equals(this.defaultQuantity, proxyCreateProductRatePlanCharge.defaultQuantity) &&
        Objects.equals(this.deferredRevenueAccount, proxyCreateProductRatePlanCharge.deferredRevenueAccount) &&
        Objects.equals(this.deliverySchedule, proxyCreateProductRatePlanCharge.deliverySchedule) &&
        Objects.equals(this.description, proxyCreateProductRatePlanCharge.description) &&
        Objects.equals(this.discountLevel, proxyCreateProductRatePlanCharge.discountLevel) &&
        Objects.equals(this.drawdownRate, proxyCreateProductRatePlanCharge.drawdownRate) &&
        Objects.equals(this.drawdownUom, proxyCreateProductRatePlanCharge.drawdownUom) &&
        Objects.equals(this.endDateCondition, proxyCreateProductRatePlanCharge.endDateCondition) &&
        Objects.equals(this.excludeItemBillingFromRevenueAccounting, proxyCreateProductRatePlanCharge.excludeItemBillingFromRevenueAccounting) &&
        Objects.equals(this.excludeItemBookingFromRevenueAccounting, proxyCreateProductRatePlanCharge.excludeItemBookingFromRevenueAccounting) &&
        Objects.equals(this.includedUnits, proxyCreateProductRatePlanCharge.includedUnits) &&
        Objects.equals(this.isAllocationEligible, proxyCreateProductRatePlanCharge.isAllocationEligible) &&
        Objects.equals(this.isPrepaid, proxyCreateProductRatePlanCharge.isPrepaid) &&
        Objects.equals(this.isRollover, proxyCreateProductRatePlanCharge.isRollover) &&
        Objects.equals(this.isStackedDiscount, proxyCreateProductRatePlanCharge.isStackedDiscount) &&
        Objects.equals(this.isUnbilled, proxyCreateProductRatePlanCharge.isUnbilled) &&
        Objects.equals(this.legacyRevenueReporting, proxyCreateProductRatePlanCharge.legacyRevenueReporting) &&
        Objects.equals(this.listPriceBase, proxyCreateProductRatePlanCharge.listPriceBase) &&
        Objects.equals(this.maxQuantity, proxyCreateProductRatePlanCharge.maxQuantity) &&
        Objects.equals(this.minQuantity, proxyCreateProductRatePlanCharge.minQuantity) &&
        Objects.equals(this.name, proxyCreateProductRatePlanCharge.name) &&
        Objects.equals(this.numberOfPeriod, proxyCreateProductRatePlanCharge.numberOfPeriod) &&
        Objects.equals(this.overageCalculationOption, proxyCreateProductRatePlanCharge.overageCalculationOption) &&
        Objects.equals(this.overageUnusedUnitsCreditOption, proxyCreateProductRatePlanCharge.overageUnusedUnitsCreditOption) &&
        Objects.equals(this.prepaidOperationType, proxyCreateProductRatePlanCharge.prepaidOperationType) &&
        Objects.equals(this.prepaidQuantity, proxyCreateProductRatePlanCharge.prepaidQuantity) &&
        Objects.equals(this.prepaidTotalQuantity, proxyCreateProductRatePlanCharge.prepaidTotalQuantity) &&
        Objects.equals(this.prepaidUom, proxyCreateProductRatePlanCharge.prepaidUom) &&
        Objects.equals(this.priceChangeOption, proxyCreateProductRatePlanCharge.priceChangeOption) &&
        Objects.equals(this.priceIncreaseOption, proxyCreateProductRatePlanCharge.priceIncreaseOption) &&
        Objects.equals(this.priceIncreasePercentage, proxyCreateProductRatePlanCharge.priceIncreasePercentage) &&
        Objects.equals(this.productCategory, proxyCreateProductRatePlanCharge.productCategory) &&
        Objects.equals(this.productClass, proxyCreateProductRatePlanCharge.productClass) &&
        Objects.equals(this.productFamily, proxyCreateProductRatePlanCharge.productFamily) &&
        Objects.equals(this.productLine, proxyCreateProductRatePlanCharge.productLine) &&
        Objects.equals(this.revenueRecognitionTiming, proxyCreateProductRatePlanCharge.revenueRecognitionTiming) &&
        Objects.equals(this.revenueAmortizationMethod, proxyCreateProductRatePlanCharge.revenueAmortizationMethod) &&
        Objects.equals(this.productRatePlanChargeNumber, proxyCreateProductRatePlanCharge.productRatePlanChargeNumber) &&
        Objects.equals(this.productRatePlanChargeTierData, proxyCreateProductRatePlanCharge.productRatePlanChargeTierData) &&
        Objects.equals(this.productRatePlanId, proxyCreateProductRatePlanCharge.productRatePlanId) &&
        Objects.equals(this.ratingGroup, proxyCreateProductRatePlanCharge.ratingGroup) &&
        Objects.equals(this.recognizedRevenueAccount, proxyCreateProductRatePlanCharge.recognizedRevenueAccount) &&
        Objects.equals(this.revRecCode, proxyCreateProductRatePlanCharge.revRecCode) &&
        Objects.equals(this.revRecTriggerCondition, proxyCreateProductRatePlanCharge.revRecTriggerCondition) &&
        Objects.equals(this.revenueRecognitionRuleName, proxyCreateProductRatePlanCharge.revenueRecognitionRuleName) &&
        Objects.equals(this.rolloverApply, proxyCreateProductRatePlanCharge.rolloverApply) &&
        Objects.equals(this.rolloverPeriods, proxyCreateProductRatePlanCharge.rolloverPeriods) &&
        Objects.equals(this.smoothingModel, proxyCreateProductRatePlanCharge.smoothingModel) &&
        Objects.equals(this.specificBillingPeriod, proxyCreateProductRatePlanCharge.specificBillingPeriod) &&
        Objects.equals(this.specificListPriceBase, proxyCreateProductRatePlanCharge.specificListPriceBase) &&
        Objects.equals(this.taxCode, proxyCreateProductRatePlanCharge.taxCode) &&
        Objects.equals(this.taxMode, proxyCreateProductRatePlanCharge.taxMode) &&
        Objects.equals(this.taxable, proxyCreateProductRatePlanCharge.taxable) &&
        Objects.equals(this.triggerEvent, proxyCreateProductRatePlanCharge.triggerEvent) &&
        Objects.equals(this.UOM, proxyCreateProductRatePlanCharge.UOM) &&
        Objects.equals(this.upToPeriods, proxyCreateProductRatePlanCharge.upToPeriods) &&
        Objects.equals(this.upToPeriodsType, proxyCreateProductRatePlanCharge.upToPeriodsType) &&
        Objects.equals(this.usageRecordRatingOption, proxyCreateProductRatePlanCharge.usageRecordRatingOption) &&
        Objects.equals(this.useDiscountSpecificAccountingCode, proxyCreateProductRatePlanCharge.useDiscountSpecificAccountingCode) &&
        Objects.equals(this.useTenantDefaultForPriceChange, proxyCreateProductRatePlanCharge.useTenantDefaultForPriceChange) &&
        Objects.equals(this.validityPeriodType, proxyCreateProductRatePlanCharge.validityPeriodType) &&
        Objects.equals(this.weeklyBillCycleDay, proxyCreateProductRatePlanCharge.weeklyBillCycleDay) &&
        Objects.equals(this.applyToBillingPeriodPartially, proxyCreateProductRatePlanCharge.applyToBillingPeriodPartially) &&
        Objects.equals(this.rolloverPeriodLength, proxyCreateProductRatePlanCharge.rolloverPeriodLength) &&
        Objects.equals(this.formula, proxyCreateProductRatePlanCharge.formula) &&
        Objects.equals(this.classNS, proxyCreateProductRatePlanCharge.classNS) &&
        Objects.equals(this.deferredRevAccountNS, proxyCreateProductRatePlanCharge.deferredRevAccountNS) &&
        Objects.equals(this.departmentNS, proxyCreateProductRatePlanCharge.departmentNS) &&
        Objects.equals(this.includeChildrenNS, proxyCreateProductRatePlanCharge.includeChildrenNS) &&
        Objects.equals(this.integrationIdNS, proxyCreateProductRatePlanCharge.integrationIdNS) &&
        Objects.equals(this.integrationStatusNS, proxyCreateProductRatePlanCharge.integrationStatusNS) &&
        Objects.equals(this.itemTypeNS, proxyCreateProductRatePlanCharge.itemTypeNS) &&
        Objects.equals(this.locationNS, proxyCreateProductRatePlanCharge.locationNS) &&
        Objects.equals(this.recognizedRevAccountNS, proxyCreateProductRatePlanCharge.recognizedRevAccountNS) &&
        Objects.equals(this.revRecEndNS, proxyCreateProductRatePlanCharge.revRecEndNS) &&
        Objects.equals(this.revRecStartNS, proxyCreateProductRatePlanCharge.revRecStartNS) &&
        Objects.equals(this.revRecTemplateTypeNS, proxyCreateProductRatePlanCharge.revRecTemplateTypeNS) &&
        Objects.equals(this.subsidiaryNS, proxyCreateProductRatePlanCharge.subsidiaryNS) &&
        Objects.equals(this.syncDateNS, proxyCreateProductRatePlanCharge.syncDateNS)&&
        Objects.equals(this.additionalProperties, proxyCreateProductRatePlanCharge.additionalProperties);
  }

  private static <T> boolean equalsNullable(JsonNullable<T> a, JsonNullable<T> b) {
    return a == b || (a != null && b != null && a.isPresent() && b.isPresent() && Objects.deepEquals(a.get(), b.get()));
  }

  @Override
  public int hashCode() {
    return Objects.hash(accountingCode, applyDiscountTo, billCycleDay, billCycleType, billingPeriod, billingPeriodAlignment, billingTiming, chargeFunction, commitmentType, chargeModel, chargeModelConfiguration, chargeType, creditOption, defaultQuantity, deferredRevenueAccount, deliverySchedule, description, discountLevel, drawdownRate, drawdownUom, endDateCondition, excludeItemBillingFromRevenueAccounting, excludeItemBookingFromRevenueAccounting, includedUnits, isAllocationEligible, isPrepaid, isRollover, isStackedDiscount, isUnbilled, legacyRevenueReporting, listPriceBase, maxQuantity, minQuantity, name, numberOfPeriod, overageCalculationOption, overageUnusedUnitsCreditOption, prepaidOperationType, prepaidQuantity, prepaidTotalQuantity, prepaidUom, priceChangeOption, priceIncreaseOption, priceIncreasePercentage, productCategory, productClass, productFamily, productLine, revenueRecognitionTiming, revenueAmortizationMethod, productRatePlanChargeNumber, productRatePlanChargeTierData, productRatePlanId, ratingGroup, recognizedRevenueAccount, revRecCode, revRecTriggerCondition, revenueRecognitionRuleName, rolloverApply, rolloverPeriods, smoothingModel, specificBillingPeriod, specificListPriceBase, taxCode, taxMode, taxable, triggerEvent, UOM, upToPeriods, upToPeriodsType, usageRecordRatingOption, useDiscountSpecificAccountingCode, useTenantDefaultForPriceChange, validityPeriodType, weeklyBillCycleDay, applyToBillingPeriodPartially, rolloverPeriodLength, formula, classNS, deferredRevAccountNS, departmentNS, includeChildrenNS, integrationIdNS, integrationStatusNS, itemTypeNS, locationNS, recognizedRevAccountNS, revRecEndNS, revRecStartNS, revRecTemplateTypeNS, subsidiaryNS, syncDateNS, additionalProperties);
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
    sb.append("class ProxyCreateProductRatePlanCharge {\n");
    sb.append("    accountingCode: ").append(toIndentedString(accountingCode)).append("\n");
    sb.append("    applyDiscountTo: ").append(toIndentedString(applyDiscountTo)).append("\n");
    sb.append("    billCycleDay: ").append(toIndentedString(billCycleDay)).append("\n");
    sb.append("    billCycleType: ").append(toIndentedString(billCycleType)).append("\n");
    sb.append("    billingPeriod: ").append(toIndentedString(billingPeriod)).append("\n");
    sb.append("    billingPeriodAlignment: ").append(toIndentedString(billingPeriodAlignment)).append("\n");
    sb.append("    billingTiming: ").append(toIndentedString(billingTiming)).append("\n");
    sb.append("    chargeFunction: ").append(toIndentedString(chargeFunction)).append("\n");
    sb.append("    commitmentType: ").append(toIndentedString(commitmentType)).append("\n");
    sb.append("    chargeModel: ").append(toIndentedString(chargeModel)).append("\n");
    sb.append("    chargeModelConfiguration: ").append(toIndentedString(chargeModelConfiguration)).append("\n");
    sb.append("    chargeType: ").append(toIndentedString(chargeType)).append("\n");
    sb.append("    creditOption: ").append(toIndentedString(creditOption)).append("\n");
    sb.append("    defaultQuantity: ").append(toIndentedString(defaultQuantity)).append("\n");
    sb.append("    deferredRevenueAccount: ").append(toIndentedString(deferredRevenueAccount)).append("\n");
    sb.append("    deliverySchedule: ").append(toIndentedString(deliverySchedule)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    discountLevel: ").append(toIndentedString(discountLevel)).append("\n");
    sb.append("    drawdownRate: ").append(toIndentedString(drawdownRate)).append("\n");
    sb.append("    drawdownUom: ").append(toIndentedString(drawdownUom)).append("\n");
    sb.append("    endDateCondition: ").append(toIndentedString(endDateCondition)).append("\n");
    sb.append("    excludeItemBillingFromRevenueAccounting: ").append(toIndentedString(excludeItemBillingFromRevenueAccounting)).append("\n");
    sb.append("    excludeItemBookingFromRevenueAccounting: ").append(toIndentedString(excludeItemBookingFromRevenueAccounting)).append("\n");
    sb.append("    includedUnits: ").append(toIndentedString(includedUnits)).append("\n");
    sb.append("    isAllocationEligible: ").append(toIndentedString(isAllocationEligible)).append("\n");
    sb.append("    isPrepaid: ").append(toIndentedString(isPrepaid)).append("\n");
    sb.append("    isRollover: ").append(toIndentedString(isRollover)).append("\n");
    sb.append("    isStackedDiscount: ").append(toIndentedString(isStackedDiscount)).append("\n");
    sb.append("    isUnbilled: ").append(toIndentedString(isUnbilled)).append("\n");
    sb.append("    legacyRevenueReporting: ").append(toIndentedString(legacyRevenueReporting)).append("\n");
    sb.append("    listPriceBase: ").append(toIndentedString(listPriceBase)).append("\n");
    sb.append("    maxQuantity: ").append(toIndentedString(maxQuantity)).append("\n");
    sb.append("    minQuantity: ").append(toIndentedString(minQuantity)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    numberOfPeriod: ").append(toIndentedString(numberOfPeriod)).append("\n");
    sb.append("    overageCalculationOption: ").append(toIndentedString(overageCalculationOption)).append("\n");
    sb.append("    overageUnusedUnitsCreditOption: ").append(toIndentedString(overageUnusedUnitsCreditOption)).append("\n");
    sb.append("    prepaidOperationType: ").append(toIndentedString(prepaidOperationType)).append("\n");
    sb.append("    prepaidQuantity: ").append(toIndentedString(prepaidQuantity)).append("\n");
    sb.append("    prepaidTotalQuantity: ").append(toIndentedString(prepaidTotalQuantity)).append("\n");
    sb.append("    prepaidUom: ").append(toIndentedString(prepaidUom)).append("\n");
    sb.append("    priceChangeOption: ").append(toIndentedString(priceChangeOption)).append("\n");
    sb.append("    priceIncreaseOption: ").append(toIndentedString(priceIncreaseOption)).append("\n");
    sb.append("    priceIncreasePercentage: ").append(toIndentedString(priceIncreasePercentage)).append("\n");
    sb.append("    productCategory: ").append(toIndentedString(productCategory)).append("\n");
    sb.append("    productClass: ").append(toIndentedString(productClass)).append("\n");
    sb.append("    productFamily: ").append(toIndentedString(productFamily)).append("\n");
    sb.append("    productLine: ").append(toIndentedString(productLine)).append("\n");
    sb.append("    revenueRecognitionTiming: ").append(toIndentedString(revenueRecognitionTiming)).append("\n");
    sb.append("    revenueAmortizationMethod: ").append(toIndentedString(revenueAmortizationMethod)).append("\n");
    sb.append("    productRatePlanChargeNumber: ").append(toIndentedString(productRatePlanChargeNumber)).append("\n");
    sb.append("    productRatePlanChargeTierData: ").append(toIndentedString(productRatePlanChargeTierData)).append("\n");
    sb.append("    productRatePlanId: ").append(toIndentedString(productRatePlanId)).append("\n");
    sb.append("    ratingGroup: ").append(toIndentedString(ratingGroup)).append("\n");
    sb.append("    recognizedRevenueAccount: ").append(toIndentedString(recognizedRevenueAccount)).append("\n");
    sb.append("    revRecCode: ").append(toIndentedString(revRecCode)).append("\n");
    sb.append("    revRecTriggerCondition: ").append(toIndentedString(revRecTriggerCondition)).append("\n");
    sb.append("    revenueRecognitionRuleName: ").append(toIndentedString(revenueRecognitionRuleName)).append("\n");
    sb.append("    rolloverApply: ").append(toIndentedString(rolloverApply)).append("\n");
    sb.append("    rolloverPeriods: ").append(toIndentedString(rolloverPeriods)).append("\n");
    sb.append("    smoothingModel: ").append(toIndentedString(smoothingModel)).append("\n");
    sb.append("    specificBillingPeriod: ").append(toIndentedString(specificBillingPeriod)).append("\n");
    sb.append("    specificListPriceBase: ").append(toIndentedString(specificListPriceBase)).append("\n");
    sb.append("    taxCode: ").append(toIndentedString(taxCode)).append("\n");
    sb.append("    taxMode: ").append(toIndentedString(taxMode)).append("\n");
    sb.append("    taxable: ").append(toIndentedString(taxable)).append("\n");
    sb.append("    triggerEvent: ").append(toIndentedString(triggerEvent)).append("\n");
    sb.append("    UOM: ").append(toIndentedString(UOM)).append("\n");
    sb.append("    upToPeriods: ").append(toIndentedString(upToPeriods)).append("\n");
    sb.append("    upToPeriodsType: ").append(toIndentedString(upToPeriodsType)).append("\n");
    sb.append("    usageRecordRatingOption: ").append(toIndentedString(usageRecordRatingOption)).append("\n");
    sb.append("    useDiscountSpecificAccountingCode: ").append(toIndentedString(useDiscountSpecificAccountingCode)).append("\n");
    sb.append("    useTenantDefaultForPriceChange: ").append(toIndentedString(useTenantDefaultForPriceChange)).append("\n");
    sb.append("    validityPeriodType: ").append(toIndentedString(validityPeriodType)).append("\n");
    sb.append("    weeklyBillCycleDay: ").append(toIndentedString(weeklyBillCycleDay)).append("\n");
    sb.append("    applyToBillingPeriodPartially: ").append(toIndentedString(applyToBillingPeriodPartially)).append("\n");
    sb.append("    rolloverPeriodLength: ").append(toIndentedString(rolloverPeriodLength)).append("\n");
    sb.append("    formula: ").append(toIndentedString(formula)).append("\n");
    sb.append("    classNS: ").append(toIndentedString(classNS)).append("\n");
    sb.append("    deferredRevAccountNS: ").append(toIndentedString(deferredRevAccountNS)).append("\n");
    sb.append("    departmentNS: ").append(toIndentedString(departmentNS)).append("\n");
    sb.append("    includeChildrenNS: ").append(toIndentedString(includeChildrenNS)).append("\n");
    sb.append("    integrationIdNS: ").append(toIndentedString(integrationIdNS)).append("\n");
    sb.append("    integrationStatusNS: ").append(toIndentedString(integrationStatusNS)).append("\n");
    sb.append("    itemTypeNS: ").append(toIndentedString(itemTypeNS)).append("\n");
    sb.append("    locationNS: ").append(toIndentedString(locationNS)).append("\n");
    sb.append("    recognizedRevAccountNS: ").append(toIndentedString(recognizedRevAccountNS)).append("\n");
    sb.append("    revRecEndNS: ").append(toIndentedString(revRecEndNS)).append("\n");
    sb.append("    revRecStartNS: ").append(toIndentedString(revRecStartNS)).append("\n");
    sb.append("    revRecTemplateTypeNS: ").append(toIndentedString(revRecTemplateTypeNS)).append("\n");
    sb.append("    subsidiaryNS: ").append(toIndentedString(subsidiaryNS)).append("\n");
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
    openapiFields.add("AccountingCode");
    openapiFields.add("ApplyDiscountTo");
    openapiFields.add("BillCycleDay");
    openapiFields.add("BillCycleType");
    openapiFields.add("BillingPeriod");
    openapiFields.add("BillingPeriodAlignment");
    openapiFields.add("BillingTiming");
    openapiFields.add("ChargeFunction");
    openapiFields.add("CommitmentType");
    openapiFields.add("ChargeModel");
    openapiFields.add("ChargeModelConfiguration");
    openapiFields.add("ChargeType");
    openapiFields.add("CreditOption");
    openapiFields.add("DefaultQuantity");
    openapiFields.add("DeferredRevenueAccount");
    openapiFields.add("DeliverySchedule");
    openapiFields.add("Description");
    openapiFields.add("DiscountLevel");
    openapiFields.add("DrawdownRate");
    openapiFields.add("DrawdownUom");
    openapiFields.add("EndDateCondition");
    openapiFields.add("ExcludeItemBillingFromRevenueAccounting");
    openapiFields.add("ExcludeItemBookingFromRevenueAccounting");
    openapiFields.add("IncludedUnits");
    openapiFields.add("IsAllocationEligible");
    openapiFields.add("IsPrepaid");
    openapiFields.add("IsRollover");
    openapiFields.add("IsStackedDiscount");
    openapiFields.add("IsUnbilled");
    openapiFields.add("LegacyRevenueReporting");
    openapiFields.add("ListPriceBase");
    openapiFields.add("MaxQuantity");
    openapiFields.add("MinQuantity");
    openapiFields.add("Name");
    openapiFields.add("NumberOfPeriod");
    openapiFields.add("OverageCalculationOption");
    openapiFields.add("OverageUnusedUnitsCreditOption");
    openapiFields.add("PrepaidOperationType");
    openapiFields.add("PrepaidQuantity");
    openapiFields.add("PrepaidTotalQuantity");
    openapiFields.add("PrepaidUom");
    openapiFields.add("PriceChangeOption");
    openapiFields.add("PriceIncreaseOption");
    openapiFields.add("PriceIncreasePercentage");
    openapiFields.add("ProductCategory");
    openapiFields.add("ProductClass");
    openapiFields.add("ProductFamily");
    openapiFields.add("ProductLine");
    openapiFields.add("RevenueRecognitionTiming");
    openapiFields.add("RevenueAmortizationMethod");
    openapiFields.add("ProductRatePlanChargeNumber");
    openapiFields.add("ProductRatePlanChargeTierData");
    openapiFields.add("ProductRatePlanId");
    openapiFields.add("RatingGroup");
    openapiFields.add("RecognizedRevenueAccount");
    openapiFields.add("RevRecCode");
    openapiFields.add("RevRecTriggerCondition");
    openapiFields.add("RevenueRecognitionRuleName");
    openapiFields.add("RolloverApply");
    openapiFields.add("RolloverPeriods");
    openapiFields.add("SmoothingModel");
    openapiFields.add("SpecificBillingPeriod");
    openapiFields.add("SpecificListPriceBase");
    openapiFields.add("TaxCode");
    openapiFields.add("TaxMode");
    openapiFields.add("Taxable");
    openapiFields.add("TriggerEvent");
    openapiFields.add("UOM");
    openapiFields.add("UpToPeriods");
    openapiFields.add("UpToPeriodsType");
    openapiFields.add("UsageRecordRatingOption");
    openapiFields.add("UseDiscountSpecificAccountingCode");
    openapiFields.add("UseTenantDefaultForPriceChange");
    openapiFields.add("ValidityPeriodType");
    openapiFields.add("WeeklyBillCycleDay");
    openapiFields.add("ApplyToBillingPeriodPartially");
    openapiFields.add("RolloverPeriodLength");
    openapiFields.add("Formula");
    openapiFields.add("Class__NS");
    openapiFields.add("DeferredRevAccount__NS");
    openapiFields.add("Department__NS");
    openapiFields.add("IncludeChildren__NS");
    openapiFields.add("IntegrationId__NS");
    openapiFields.add("IntegrationStatus__NS");
    openapiFields.add("ItemType__NS");
    openapiFields.add("Location__NS");
    openapiFields.add("RecognizedRevAccount__NS");
    openapiFields.add("RevRecEnd__NS");
    openapiFields.add("RevRecStart__NS");
    openapiFields.add("RevRecTemplateType__NS");
    openapiFields.add("Subsidiary__NS");
    openapiFields.add("SyncDate__NS");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
    openapiRequiredFields.add("BillCycleType");
    openapiRequiredFields.add("BillingPeriod");
    openapiRequiredFields.add("ChargeModel");
    openapiRequiredFields.add("ChargeType");
    openapiRequiredFields.add("Name");
    openapiRequiredFields.add("ProductRatePlanChargeTierData");
    openapiRequiredFields.add("ProductRatePlanId");
    openapiRequiredFields.add("TriggerEvent");
    openapiRequiredFields.add("UseDiscountSpecificAccountingCode");
  }

 /**
  * Validates the JSON Object and throws an exception if issues found
  *
  * @param jsonObj JSON Object
  * @throws IOException if the JSON Object is invalid with respect to ProxyCreateProductRatePlanCharge
  */
  public static void validateJsonObject(JsonObject jsonObj) throws IOException {
      if (jsonObj == null) {
        if (!ProxyCreateProductRatePlanCharge.openapiRequiredFields.isEmpty()) { // has required fields but JSON object is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in ProxyCreateProductRatePlanCharge is not found in the empty JSON string", ProxyCreateProductRatePlanCharge.openapiRequiredFields.toString()));
        }
      }

      // check to make sure all required properties/fields are present in the JSON string
      for (String requiredField : ProxyCreateProductRatePlanCharge.openapiRequiredFields) {
        if (jsonObj.get(requiredField) == null) {
          throw new IllegalArgumentException(String.format("The required field `%s` is not found in the JSON string: %s", requiredField, jsonObj.toString()));
        }
      }
      if ((jsonObj.get("AccountingCode") != null && !jsonObj.get("AccountingCode").isJsonNull()) && !jsonObj.get("AccountingCode").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `AccountingCode` to be a primitive type in the JSON string but got `%s`", jsonObj.get("AccountingCode").toString()));
      }
      if ((jsonObj.get("ApplyDiscountTo") != null && !jsonObj.get("ApplyDiscountTo").isJsonNull()) && !jsonObj.get("ApplyDiscountTo").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `ApplyDiscountTo` to be a primitive type in the JSON string but got `%s`", jsonObj.get("ApplyDiscountTo").toString()));
      }
      if (!jsonObj.get("BillCycleType").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `BillCycleType` to be a primitive type in the JSON string but got `%s`", jsonObj.get("BillCycleType").toString()));
      }
      if (!jsonObj.get("BillingPeriod").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `BillingPeriod` to be a primitive type in the JSON string but got `%s`", jsonObj.get("BillingPeriod").toString()));
      }
      if ((jsonObj.get("BillingPeriodAlignment") != null && !jsonObj.get("BillingPeriodAlignment").isJsonNull()) && !jsonObj.get("BillingPeriodAlignment").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `BillingPeriodAlignment` to be a primitive type in the JSON string but got `%s`", jsonObj.get("BillingPeriodAlignment").toString()));
      }
      if ((jsonObj.get("BillingTiming") != null && !jsonObj.get("BillingTiming").isJsonNull()) && !jsonObj.get("BillingTiming").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `BillingTiming` to be a primitive type in the JSON string but got `%s`", jsonObj.get("BillingTiming").toString()));
      }
      if ((jsonObj.get("ChargeFunction") != null && !jsonObj.get("ChargeFunction").isJsonNull()) && !jsonObj.get("ChargeFunction").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `ChargeFunction` to be a primitive type in the JSON string but got `%s`", jsonObj.get("ChargeFunction").toString()));
      }
      if ((jsonObj.get("CommitmentType") != null && !jsonObj.get("CommitmentType").isJsonNull()) && !jsonObj.get("CommitmentType").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `CommitmentType` to be a primitive type in the JSON string but got `%s`", jsonObj.get("CommitmentType").toString()));
      }
      if (!jsonObj.get("ChargeModel").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `ChargeModel` to be a primitive type in the JSON string but got `%s`", jsonObj.get("ChargeModel").toString()));
      }
      // validate the optional field `ChargeModelConfiguration`
      if (jsonObj.get("ChargeModelConfiguration") != null && !jsonObj.get("ChargeModelConfiguration").isJsonNull()) {
        ProxyCreateOrModifyProductRatePlanChargeChargeModelConfiguration.validateJsonObject(jsonObj.getAsJsonObject("ChargeModelConfiguration"));
      }
      if (!jsonObj.get("ChargeType").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `ChargeType` to be a primitive type in the JSON string but got `%s`", jsonObj.get("ChargeType").toString()));
      }
      if ((jsonObj.get("CreditOption") != null && !jsonObj.get("CreditOption").isJsonNull()) && !jsonObj.get("CreditOption").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `CreditOption` to be a primitive type in the JSON string but got `%s`", jsonObj.get("CreditOption").toString()));
      }
      if ((jsonObj.get("DeferredRevenueAccount") != null && !jsonObj.get("DeferredRevenueAccount").isJsonNull()) && !jsonObj.get("DeferredRevenueAccount").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `DeferredRevenueAccount` to be a primitive type in the JSON string but got `%s`", jsonObj.get("DeferredRevenueAccount").toString()));
      }
      // validate the optional field `DeliverySchedule`
      if (jsonObj.get("DeliverySchedule") != null && !jsonObj.get("DeliverySchedule").isJsonNull()) {
        ProxyCreateOrModifyDeliverySchedule.validateJsonObject(jsonObj.getAsJsonObject("DeliverySchedule"));
      }
      if ((jsonObj.get("Description") != null && !jsonObj.get("Description").isJsonNull()) && !jsonObj.get("Description").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `Description` to be a primitive type in the JSON string but got `%s`", jsonObj.get("Description").toString()));
      }
      if ((jsonObj.get("DiscountLevel") != null && !jsonObj.get("DiscountLevel").isJsonNull()) && !jsonObj.get("DiscountLevel").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `DiscountLevel` to be a primitive type in the JSON string but got `%s`", jsonObj.get("DiscountLevel").toString()));
      }
      if ((jsonObj.get("DrawdownUom") != null && !jsonObj.get("DrawdownUom").isJsonNull()) && !jsonObj.get("DrawdownUom").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `DrawdownUom` to be a primitive type in the JSON string but got `%s`", jsonObj.get("DrawdownUom").toString()));
      }
      if ((jsonObj.get("EndDateCondition") != null && !jsonObj.get("EndDateCondition").isJsonNull()) && !jsonObj.get("EndDateCondition").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `EndDateCondition` to be a primitive type in the JSON string but got `%s`", jsonObj.get("EndDateCondition").toString()));
      }
      if ((jsonObj.get("ListPriceBase") != null && !jsonObj.get("ListPriceBase").isJsonNull()) && !jsonObj.get("ListPriceBase").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `ListPriceBase` to be a primitive type in the JSON string but got `%s`", jsonObj.get("ListPriceBase").toString()));
      }
      if (!jsonObj.get("Name").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `Name` to be a primitive type in the JSON string but got `%s`", jsonObj.get("Name").toString()));
      }
      if ((jsonObj.get("OverageCalculationOption") != null && !jsonObj.get("OverageCalculationOption").isJsonNull()) && !jsonObj.get("OverageCalculationOption").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `OverageCalculationOption` to be a primitive type in the JSON string but got `%s`", jsonObj.get("OverageCalculationOption").toString()));
      }
      if (!jsonObj.get("OverageUnusedUnitsCreditOption").isJsonNull() && (jsonObj.get("OverageUnusedUnitsCreditOption") != null && !jsonObj.get("OverageUnusedUnitsCreditOption").isJsonNull()) && !jsonObj.get("OverageUnusedUnitsCreditOption").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `OverageUnusedUnitsCreditOption` to be a primitive type in the JSON string but got `%s`", jsonObj.get("OverageUnusedUnitsCreditOption").toString()));
      }
      if ((jsonObj.get("PrepaidOperationType") != null && !jsonObj.get("PrepaidOperationType").isJsonNull()) && !jsonObj.get("PrepaidOperationType").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `PrepaidOperationType` to be a primitive type in the JSON string but got `%s`", jsonObj.get("PrepaidOperationType").toString()));
      }
      if ((jsonObj.get("PrepaidUom") != null && !jsonObj.get("PrepaidUom").isJsonNull()) && !jsonObj.get("PrepaidUom").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `PrepaidUom` to be a primitive type in the JSON string but got `%s`", jsonObj.get("PrepaidUom").toString()));
      }
      if ((jsonObj.get("PriceChangeOption") != null && !jsonObj.get("PriceChangeOption").isJsonNull()) && !jsonObj.get("PriceChangeOption").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `PriceChangeOption` to be a primitive type in the JSON string but got `%s`", jsonObj.get("PriceChangeOption").toString()));
      }
      if ((jsonObj.get("PriceIncreaseOption") != null && !jsonObj.get("PriceIncreaseOption").isJsonNull()) && !jsonObj.get("PriceIncreaseOption").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `PriceIncreaseOption` to be a primitive type in the JSON string but got `%s`", jsonObj.get("PriceIncreaseOption").toString()));
      }
      if ((jsonObj.get("ProductCategory") != null && !jsonObj.get("ProductCategory").isJsonNull()) && !jsonObj.get("ProductCategory").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `ProductCategory` to be a primitive type in the JSON string but got `%s`", jsonObj.get("ProductCategory").toString()));
      }
      if ((jsonObj.get("ProductClass") != null && !jsonObj.get("ProductClass").isJsonNull()) && !jsonObj.get("ProductClass").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `ProductClass` to be a primitive type in the JSON string but got `%s`", jsonObj.get("ProductClass").toString()));
      }
      if ((jsonObj.get("ProductFamily") != null && !jsonObj.get("ProductFamily").isJsonNull()) && !jsonObj.get("ProductFamily").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `ProductFamily` to be a primitive type in the JSON string but got `%s`", jsonObj.get("ProductFamily").toString()));
      }
      if ((jsonObj.get("ProductLine") != null && !jsonObj.get("ProductLine").isJsonNull()) && !jsonObj.get("ProductLine").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `ProductLine` to be a primitive type in the JSON string but got `%s`", jsonObj.get("ProductLine").toString()));
      }
      if ((jsonObj.get("RevenueRecognitionTiming") != null && !jsonObj.get("RevenueRecognitionTiming").isJsonNull()) && !jsonObj.get("RevenueRecognitionTiming").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `RevenueRecognitionTiming` to be a primitive type in the JSON string but got `%s`", jsonObj.get("RevenueRecognitionTiming").toString()));
      }
      if ((jsonObj.get("RevenueAmortizationMethod") != null && !jsonObj.get("RevenueAmortizationMethod").isJsonNull()) && !jsonObj.get("RevenueAmortizationMethod").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `RevenueAmortizationMethod` to be a primitive type in the JSON string but got `%s`", jsonObj.get("RevenueAmortizationMethod").toString()));
      }
      if ((jsonObj.get("ProductRatePlanChargeNumber") != null && !jsonObj.get("ProductRatePlanChargeNumber").isJsonNull()) && !jsonObj.get("ProductRatePlanChargeNumber").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `ProductRatePlanChargeNumber` to be a primitive type in the JSON string but got `%s`", jsonObj.get("ProductRatePlanChargeNumber").toString()));
      }
      // validate the required field `ProductRatePlanChargeTierData`
      ProxyCreateOrModifyProductRatePlanChargeTierData.validateJsonObject(jsonObj.getAsJsonObject("ProductRatePlanChargeTierData"));
      if (!jsonObj.get("ProductRatePlanId").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `ProductRatePlanId` to be a primitive type in the JSON string but got `%s`", jsonObj.get("ProductRatePlanId").toString()));
      }
      if (!jsonObj.get("RatingGroup").isJsonNull() && (jsonObj.get("RatingGroup") != null && !jsonObj.get("RatingGroup").isJsonNull()) && !jsonObj.get("RatingGroup").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `RatingGroup` to be a primitive type in the JSON string but got `%s`", jsonObj.get("RatingGroup").toString()));
      }
      if ((jsonObj.get("RecognizedRevenueAccount") != null && !jsonObj.get("RecognizedRevenueAccount").isJsonNull()) && !jsonObj.get("RecognizedRevenueAccount").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `RecognizedRevenueAccount` to be a primitive type in the JSON string but got `%s`", jsonObj.get("RecognizedRevenueAccount").toString()));
      }
      if (!jsonObj.get("RevRecCode").isJsonNull() && (jsonObj.get("RevRecCode") != null && !jsonObj.get("RevRecCode").isJsonNull()) && !jsonObj.get("RevRecCode").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `RevRecCode` to be a primitive type in the JSON string but got `%s`", jsonObj.get("RevRecCode").toString()));
      }
      if (!jsonObj.get("RevRecTriggerCondition").isJsonNull() && (jsonObj.get("RevRecTriggerCondition") != null && !jsonObj.get("RevRecTriggerCondition").isJsonNull()) && !jsonObj.get("RevRecTriggerCondition").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `RevRecTriggerCondition` to be a primitive type in the JSON string but got `%s`", jsonObj.get("RevRecTriggerCondition").toString()));
      }
      if ((jsonObj.get("RevenueRecognitionRuleName") != null && !jsonObj.get("RevenueRecognitionRuleName").isJsonNull()) && !jsonObj.get("RevenueRecognitionRuleName").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `RevenueRecognitionRuleName` to be a primitive type in the JSON string but got `%s`", jsonObj.get("RevenueRecognitionRuleName").toString()));
      }
      if ((jsonObj.get("RolloverApply") != null && !jsonObj.get("RolloverApply").isJsonNull()) && !jsonObj.get("RolloverApply").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `RolloverApply` to be a primitive type in the JSON string but got `%s`", jsonObj.get("RolloverApply").toString()));
      }
      if (!jsonObj.get("SmoothingModel").isJsonNull() && (jsonObj.get("SmoothingModel") != null && !jsonObj.get("SmoothingModel").isJsonNull()) && !jsonObj.get("SmoothingModel").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `SmoothingModel` to be a primitive type in the JSON string but got `%s`", jsonObj.get("SmoothingModel").toString()));
      }
      if ((jsonObj.get("TaxCode") != null && !jsonObj.get("TaxCode").isJsonNull()) && !jsonObj.get("TaxCode").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `TaxCode` to be a primitive type in the JSON string but got `%s`", jsonObj.get("TaxCode").toString()));
      }
      if (!jsonObj.get("TaxMode").isJsonNull() && (jsonObj.get("TaxMode") != null && !jsonObj.get("TaxMode").isJsonNull()) && !jsonObj.get("TaxMode").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `TaxMode` to be a primitive type in the JSON string but got `%s`", jsonObj.get("TaxMode").toString()));
      }
      if (!jsonObj.get("TriggerEvent").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `TriggerEvent` to be a primitive type in the JSON string but got `%s`", jsonObj.get("TriggerEvent").toString()));
      }
      if (!jsonObj.get("UOM").isJsonNull() && (jsonObj.get("UOM") != null && !jsonObj.get("UOM").isJsonNull()) && !jsonObj.get("UOM").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `UOM` to be a primitive type in the JSON string but got `%s`", jsonObj.get("UOM").toString()));
      }
      if (!jsonObj.get("UpToPeriodsType").isJsonNull() && (jsonObj.get("UpToPeriodsType") != null && !jsonObj.get("UpToPeriodsType").isJsonNull()) && !jsonObj.get("UpToPeriodsType").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `UpToPeriodsType` to be a primitive type in the JSON string but got `%s`", jsonObj.get("UpToPeriodsType").toString()));
      }
      if (!jsonObj.get("UsageRecordRatingOption").isJsonNull() && (jsonObj.get("UsageRecordRatingOption") != null && !jsonObj.get("UsageRecordRatingOption").isJsonNull()) && !jsonObj.get("UsageRecordRatingOption").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `UsageRecordRatingOption` to be a primitive type in the JSON string but got `%s`", jsonObj.get("UsageRecordRatingOption").toString()));
      }
      if ((jsonObj.get("ValidityPeriodType") != null && !jsonObj.get("ValidityPeriodType").isJsonNull()) && !jsonObj.get("ValidityPeriodType").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `ValidityPeriodType` to be a primitive type in the JSON string but got `%s`", jsonObj.get("ValidityPeriodType").toString()));
      }
      if ((jsonObj.get("WeeklyBillCycleDay") != null && !jsonObj.get("WeeklyBillCycleDay").isJsonNull()) && !jsonObj.get("WeeklyBillCycleDay").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `WeeklyBillCycleDay` to be a primitive type in the JSON string but got `%s`", jsonObj.get("WeeklyBillCycleDay").toString()));
      }
      if ((jsonObj.get("Formula") != null && !jsonObj.get("Formula").isJsonNull()) && !jsonObj.get("Formula").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `Formula` to be a primitive type in the JSON string but got `%s`", jsonObj.get("Formula").toString()));
      }
      if ((jsonObj.get("Class__NS") != null && !jsonObj.get("Class__NS").isJsonNull()) && !jsonObj.get("Class__NS").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `Class__NS` to be a primitive type in the JSON string but got `%s`", jsonObj.get("Class__NS").toString()));
      }
      if ((jsonObj.get("DeferredRevAccount__NS") != null && !jsonObj.get("DeferredRevAccount__NS").isJsonNull()) && !jsonObj.get("DeferredRevAccount__NS").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `DeferredRevAccount__NS` to be a primitive type in the JSON string but got `%s`", jsonObj.get("DeferredRevAccount__NS").toString()));
      }
      if ((jsonObj.get("Department__NS") != null && !jsonObj.get("Department__NS").isJsonNull()) && !jsonObj.get("Department__NS").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `Department__NS` to be a primitive type in the JSON string but got `%s`", jsonObj.get("Department__NS").toString()));
      }
      if ((jsonObj.get("IncludeChildren__NS") != null && !jsonObj.get("IncludeChildren__NS").isJsonNull()) && !jsonObj.get("IncludeChildren__NS").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `IncludeChildren__NS` to be a primitive type in the JSON string but got `%s`", jsonObj.get("IncludeChildren__NS").toString()));
      }
      if ((jsonObj.get("IntegrationId__NS") != null && !jsonObj.get("IntegrationId__NS").isJsonNull()) && !jsonObj.get("IntegrationId__NS").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `IntegrationId__NS` to be a primitive type in the JSON string but got `%s`", jsonObj.get("IntegrationId__NS").toString()));
      }
      if ((jsonObj.get("IntegrationStatus__NS") != null && !jsonObj.get("IntegrationStatus__NS").isJsonNull()) && !jsonObj.get("IntegrationStatus__NS").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `IntegrationStatus__NS` to be a primitive type in the JSON string but got `%s`", jsonObj.get("IntegrationStatus__NS").toString()));
      }
      if ((jsonObj.get("ItemType__NS") != null && !jsonObj.get("ItemType__NS").isJsonNull()) && !jsonObj.get("ItemType__NS").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `ItemType__NS` to be a primitive type in the JSON string but got `%s`", jsonObj.get("ItemType__NS").toString()));
      }
      if ((jsonObj.get("Location__NS") != null && !jsonObj.get("Location__NS").isJsonNull()) && !jsonObj.get("Location__NS").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `Location__NS` to be a primitive type in the JSON string but got `%s`", jsonObj.get("Location__NS").toString()));
      }
      if ((jsonObj.get("RecognizedRevAccount__NS") != null && !jsonObj.get("RecognizedRevAccount__NS").isJsonNull()) && !jsonObj.get("RecognizedRevAccount__NS").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `RecognizedRevAccount__NS` to be a primitive type in the JSON string but got `%s`", jsonObj.get("RecognizedRevAccount__NS").toString()));
      }
      if ((jsonObj.get("RevRecEnd__NS") != null && !jsonObj.get("RevRecEnd__NS").isJsonNull()) && !jsonObj.get("RevRecEnd__NS").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `RevRecEnd__NS` to be a primitive type in the JSON string but got `%s`", jsonObj.get("RevRecEnd__NS").toString()));
      }
      if ((jsonObj.get("RevRecStart__NS") != null && !jsonObj.get("RevRecStart__NS").isJsonNull()) && !jsonObj.get("RevRecStart__NS").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `RevRecStart__NS` to be a primitive type in the JSON string but got `%s`", jsonObj.get("RevRecStart__NS").toString()));
      }
      if ((jsonObj.get("RevRecTemplateType__NS") != null && !jsonObj.get("RevRecTemplateType__NS").isJsonNull()) && !jsonObj.get("RevRecTemplateType__NS").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `RevRecTemplateType__NS` to be a primitive type in the JSON string but got `%s`", jsonObj.get("RevRecTemplateType__NS").toString()));
      }
      if ((jsonObj.get("Subsidiary__NS") != null && !jsonObj.get("Subsidiary__NS").isJsonNull()) && !jsonObj.get("Subsidiary__NS").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `Subsidiary__NS` to be a primitive type in the JSON string but got `%s`", jsonObj.get("Subsidiary__NS").toString()));
      }
      if ((jsonObj.get("SyncDate__NS") != null && !jsonObj.get("SyncDate__NS").isJsonNull()) && !jsonObj.get("SyncDate__NS").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `SyncDate__NS` to be a primitive type in the JSON string but got `%s`", jsonObj.get("SyncDate__NS").toString()));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!ProxyCreateProductRatePlanCharge.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'ProxyCreateProductRatePlanCharge' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<ProxyCreateProductRatePlanCharge> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(ProxyCreateProductRatePlanCharge.class));

       return (TypeAdapter<T>) new TypeAdapter<ProxyCreateProductRatePlanCharge>() {
           @Override
           public void write(JsonWriter out, ProxyCreateProductRatePlanCharge value) throws IOException {
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
           public ProxyCreateProductRatePlanCharge read(JsonReader in) throws IOException {
             JsonObject jsonObj = elementAdapter.read(in).getAsJsonObject();
             validateJsonObject(jsonObj);
             // store additional fields in the deserialized instance
             ProxyCreateProductRatePlanCharge instance = thisAdapter.fromJsonTree(jsonObj);
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
  * Create an instance of ProxyCreateProductRatePlanCharge given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of ProxyCreateProductRatePlanCharge
  * @throws IOException if the JSON string is invalid with respect to ProxyCreateProductRatePlanCharge
  */
  public static ProxyCreateProductRatePlanCharge fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, ProxyCreateProductRatePlanCharge.class);
  }

 /**
  * Convert an instance of ProxyCreateProductRatePlanCharge to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

