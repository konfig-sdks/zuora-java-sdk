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
 * ProxyGetPaymentMethodSnapshot
 */@javax.annotation.Generated(value = "Generated by https://konfigthis.com")
public class ProxyGetPaymentMethodSnapshot {
  public static final String SERIALIZED_NAME_ACCOUNT_ID = "AccountId";
  @SerializedName(SERIALIZED_NAME_ACCOUNT_ID)
  private String accountId;

  public static final String SERIALIZED_NAME_ACH_ABA_CODE = "AchAbaCode";
  @SerializedName(SERIALIZED_NAME_ACH_ABA_CODE)
  private String achAbaCode;

  public static final String SERIALIZED_NAME_ACH_ACCOUNT_NAME = "AchAccountName";
  @SerializedName(SERIALIZED_NAME_ACH_ACCOUNT_NAME)
  private String achAccountName;

  public static final String SERIALIZED_NAME_ACH_ACCOUNT_NUMBER_MASK = "AchAccountNumberMask";
  @SerializedName(SERIALIZED_NAME_ACH_ACCOUNT_NUMBER_MASK)
  private String achAccountNumberMask;

  /**
   * The type of bank account associated with the ACH payment.
   */
  @JsonAdapter(AchAccountTypeEnum.Adapter.class)
 public enum AchAccountTypeEnum {
    BUSINESSCHECKING("BusinessChecking"),
    
    CHECKING("Checking"),
    
    SAVING("Saving");

    private String value;

    AchAccountTypeEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static AchAccountTypeEnum fromValue(String value) {
      for (AchAccountTypeEnum b : AchAccountTypeEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<AchAccountTypeEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final AchAccountTypeEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public AchAccountTypeEnum read(final JsonReader jsonReader) throws IOException {
        String value =  jsonReader.nextString();
        return AchAccountTypeEnum.fromValue(value);
      }
    }
  }

  public static final String SERIALIZED_NAME_ACH_ACCOUNT_TYPE = "AchAccountType";
  @SerializedName(SERIALIZED_NAME_ACH_ACCOUNT_TYPE)
  private AchAccountTypeEnum achAccountType;

  public static final String SERIALIZED_NAME_ACH_BANK_NAME = "AchBankName";
  @SerializedName(SERIALIZED_NAME_ACH_BANK_NAME)
  private String achBankName;

  public static final String SERIALIZED_NAME_BANK_BRANCH_CODE = "BankBranchCode";
  @SerializedName(SERIALIZED_NAME_BANK_BRANCH_CODE)
  private String bankBranchCode;

  public static final String SERIALIZED_NAME_BANK_CHECK_DIGIT = "BankCheckDigit";
  @SerializedName(SERIALIZED_NAME_BANK_CHECK_DIGIT)
  private String bankCheckDigit;

  public static final String SERIALIZED_NAME_BANK_CITY = "BankCity";
  @SerializedName(SERIALIZED_NAME_BANK_CITY)
  private String bankCity;

  public static final String SERIALIZED_NAME_BANK_CODE = "BankCode";
  @SerializedName(SERIALIZED_NAME_BANK_CODE)
  private String bankCode;

  public static final String SERIALIZED_NAME_BANK_IDENTIFICATION_NUMBER = "BankIdentificationNumber";
  @SerializedName(SERIALIZED_NAME_BANK_IDENTIFICATION_NUMBER)
  private String bankIdentificationNumber;

  public static final String SERIALIZED_NAME_BANK_NAME = "BankName";
  @SerializedName(SERIALIZED_NAME_BANK_NAME)
  private String bankName;

  public static final String SERIALIZED_NAME_BANK_POSTAL_CODE = "BankPostalCode";
  @SerializedName(SERIALIZED_NAME_BANK_POSTAL_CODE)
  private String bankPostalCode;

  public static final String SERIALIZED_NAME_BANK_STREET_NAME = "BankStreetName";
  @SerializedName(SERIALIZED_NAME_BANK_STREET_NAME)
  private String bankStreetName;

  public static final String SERIALIZED_NAME_BANK_STREET_NUMBER = "BankStreetNumber";
  @SerializedName(SERIALIZED_NAME_BANK_STREET_NUMBER)
  private String bankStreetNumber;

  public static final String SERIALIZED_NAME_BANK_TRANSFER_ACCOUNT_NAME = "BankTransferAccountName";
  @SerializedName(SERIALIZED_NAME_BANK_TRANSFER_ACCOUNT_NAME)
  private String bankTransferAccountName;

  public static final String SERIALIZED_NAME_BANK_TRANSFER_ACCOUNT_NUMBER_MASK = "BankTransferAccountNumberMask";
  @SerializedName(SERIALIZED_NAME_BANK_TRANSFER_ACCOUNT_NUMBER_MASK)
  private String bankTransferAccountNumberMask;

  public static final String SERIALIZED_NAME_BANK_TRANSFER_ACCOUNT_TYPE = "BankTransferAccountType";
  @SerializedName(SERIALIZED_NAME_BANK_TRANSFER_ACCOUNT_TYPE)
  private String bankTransferAccountType;

  /**
   * Specifies the type of direct debit transfer. The value of this field is dependent on the country of the user.  Possible Values:    * &#x60;AutomatischIncasso&#x60; (NL)  * &#x60;LastschriftDE&#x60; (Germany)  * &#x60;LastschriftAT&#x60; (Austria)  * &#x60;DemandeDePrelevement&#x60; (FR)  * &#x60;DirectDebitUK&#x60; (UK)  * &#x60;Domicil&#x60; (Belgium)  * &#x60;LastschriftCH&#x60; (CH)  * &#x60;RID&#x60; (Italy)  * &#x60;OrdenDeDomiciliacion&#x60; (Spain) * &#x60;Autogiro&#x60; (Sweden) * &#x60;Betalingsservice&#x60; (Denmark) 
   */
  @JsonAdapter(BankTransferTypeEnum.Adapter.class)
 public enum BankTransferTypeEnum {
    AUTOMATISCHINCASSO("AutomatischIncasso"),
    
    LASTSCHRIFTDE("LastschriftDE"),
    
    LASTSCHRIFTAT("LastschriftAT"),
    
    DEMANDEDEPRELEVEMENT("DemandeDePrelevement"),
    
    DIRECTDEBITUK("DirectDebitUK"),
    
    DOMICIL("Domicil"),
    
    LASTSCHRIFTCH("LastschriftCH"),
    
    RID("RID"),
    
    ORDENDEDOMICILIACION("OrdenDeDomiciliacion"),
    
    AUTOGIRO("Autogiro"),
    
    BETALINGSSERVICE("Betalingsservice");

    private String value;

    BankTransferTypeEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static BankTransferTypeEnum fromValue(String value) {
      for (BankTransferTypeEnum b : BankTransferTypeEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<BankTransferTypeEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final BankTransferTypeEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public BankTransferTypeEnum read(final JsonReader jsonReader) throws IOException {
        String value =  jsonReader.nextString();
        return BankTransferTypeEnum.fromValue(value);
      }
    }
  }

  public static final String SERIALIZED_NAME_BANK_TRANSFER_TYPE = "BankTransferType";
  @SerializedName(SERIALIZED_NAME_BANK_TRANSFER_TYPE)
  private BankTransferTypeEnum bankTransferType;

  public static final String SERIALIZED_NAME_BUSINESS_IDENTIFICATION_CODE = "BusinessIdentificationCode";
  @SerializedName(SERIALIZED_NAME_BUSINESS_IDENTIFICATION_CODE)
  private String businessIdentificationCode;

  public static final String SERIALIZED_NAME_CITY = "City";
  @SerializedName(SERIALIZED_NAME_CITY)
  private String city;

  public static final String SERIALIZED_NAME_COMPANY_NAME = "CompanyName";
  @SerializedName(SERIALIZED_NAME_COMPANY_NAME)
  private String companyName;

  public static final String SERIALIZED_NAME_COUNTRY = "Country";
  @SerializedName(SERIALIZED_NAME_COUNTRY)
  private String country;

  public static final String SERIALIZED_NAME_CREDIT_CARD_ADDRESS1 = "CreditCardAddress1";
  @SerializedName(SERIALIZED_NAME_CREDIT_CARD_ADDRESS1)
  private String creditCardAddress1;

  public static final String SERIALIZED_NAME_CREDIT_CARD_ADDRESS2 = "CreditCardAddress2";
  @SerializedName(SERIALIZED_NAME_CREDIT_CARD_ADDRESS2)
  private String creditCardAddress2;

  public static final String SERIALIZED_NAME_CREDIT_CARD_CITY = "CreditCardCity";
  @SerializedName(SERIALIZED_NAME_CREDIT_CARD_CITY)
  private String creditCardCity;

  public static final String SERIALIZED_NAME_CREDIT_CARD_COUNTRY = "CreditCardCountry";
  @SerializedName(SERIALIZED_NAME_CREDIT_CARD_COUNTRY)
  private String creditCardCountry;

  public static final String SERIALIZED_NAME_CREDIT_CARD_EXPIRATION_MONTH = "CreditCardExpirationMonth";
  @SerializedName(SERIALIZED_NAME_CREDIT_CARD_EXPIRATION_MONTH)
  private Integer creditCardExpirationMonth;

  public static final String SERIALIZED_NAME_CREDIT_CARD_EXPIRATION_YEAR = "CreditCardExpirationYear";
  @SerializedName(SERIALIZED_NAME_CREDIT_CARD_EXPIRATION_YEAR)
  private Integer creditCardExpirationYear;

  public static final String SERIALIZED_NAME_CREDIT_CARD_HOLDER_NAME = "CreditCardHolderName";
  @SerializedName(SERIALIZED_NAME_CREDIT_CARD_HOLDER_NAME)
  private String creditCardHolderName;

  public static final String SERIALIZED_NAME_CREDIT_CARD_MASK_NUMBER = "CreditCardMaskNumber";
  @SerializedName(SERIALIZED_NAME_CREDIT_CARD_MASK_NUMBER)
  private String creditCardMaskNumber;

  public static final String SERIALIZED_NAME_CREDIT_CARD_POSTAL_CODE = "CreditCardPostalCode";
  @SerializedName(SERIALIZED_NAME_CREDIT_CARD_POSTAL_CODE)
  private String creditCardPostalCode;

  public static final String SERIALIZED_NAME_CREDIT_CARD_STATE = "CreditCardState";
  @SerializedName(SERIALIZED_NAME_CREDIT_CARD_STATE)
  private String creditCardState;

  /**
   * The type of credit card or debit card.
   */
  @JsonAdapter(CreditCardTypeEnum.Adapter.class)
 public enum CreditCardTypeEnum {
    AMERICANEXPRESS("AmericanExpress"),
    
    DISCOVER("Discover"),
    
    MASTERCARD("MasterCard"),
    
    VISA("Visa");

    private String value;

    CreditCardTypeEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static CreditCardTypeEnum fromValue(String value) {
      for (CreditCardTypeEnum b : CreditCardTypeEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<CreditCardTypeEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final CreditCardTypeEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public CreditCardTypeEnum read(final JsonReader jsonReader) throws IOException {
        String value =  jsonReader.nextString();
        return CreditCardTypeEnum.fromValue(value);
      }
    }
  }

  public static final String SERIALIZED_NAME_CREDIT_CARD_TYPE = "CreditCardType";
  @SerializedName(SERIALIZED_NAME_CREDIT_CARD_TYPE)
  private CreditCardTypeEnum creditCardType;

  public static final String SERIALIZED_NAME_DEVICE_SESSION_ID = "DeviceSessionId";
  @SerializedName(SERIALIZED_NAME_DEVICE_SESSION_ID)
  private String deviceSessionId;

  public static final String SERIALIZED_NAME_EMAIL = "Email";
  @SerializedName(SERIALIZED_NAME_EMAIL)
  private String email;

  /**
   * Indicates if the customer has an existing mandate or a new mandate. Only applicable to direct debit payment methods.
   */
  @JsonAdapter(ExistingMandateEnum.Adapter.class)
 public enum ExistingMandateEnum {
    TRUE("true"),
    
    FALSE("false");

    private String value;

    ExistingMandateEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static ExistingMandateEnum fromValue(String value) {
      for (ExistingMandateEnum b : ExistingMandateEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<ExistingMandateEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final ExistingMandateEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public ExistingMandateEnum read(final JsonReader jsonReader) throws IOException {
        String value =  jsonReader.nextString();
        return ExistingMandateEnum.fromValue(value);
      }
    }
  }

  public static final String SERIALIZED_NAME_EXISTING_MANDATE = "ExistingMandate";
  @SerializedName(SERIALIZED_NAME_EXISTING_MANDATE)
  private ExistingMandateEnum existingMandate;

  public static final String SERIALIZED_NAME_FIRST_NAME = "FirstName";
  @SerializedName(SERIALIZED_NAME_FIRST_NAME)
  private String firstName;

  public static final String SERIALIZED_NAME_I_B_A_N = "IBAN";
  @SerializedName(SERIALIZED_NAME_I_B_A_N)
  private String IBAN;

  public static final String SERIALIZED_NAME_IP_ADDRESS = "IPAddress";
  @SerializedName(SERIALIZED_NAME_IP_ADDRESS)
  private String ipAddress;

  public static final String SERIALIZED_NAME_ID = "Id";
  @SerializedName(SERIALIZED_NAME_ID)
  private String id;

  public static final String SERIALIZED_NAME_IDENTITY_NUMBER = "IdentityNumber";
  @SerializedName(SERIALIZED_NAME_IDENTITY_NUMBER)
  private String identityNumber;

  public static final String SERIALIZED_NAME_IS_COMPANY = "IsCompany";
  @SerializedName(SERIALIZED_NAME_IS_COMPANY)
  private Boolean isCompany;

  public static final String SERIALIZED_NAME_LAST_FAILED_SALE_TRANSACTION_DATE = "LastFailedSaleTransactionDate";
  @SerializedName(SERIALIZED_NAME_LAST_FAILED_SALE_TRANSACTION_DATE)
  private OffsetDateTime lastFailedSaleTransactionDate;

  public static final String SERIALIZED_NAME_LAST_NAME = "LastName";
  @SerializedName(SERIALIZED_NAME_LAST_NAME)
  private String lastName;

  public static final String SERIALIZED_NAME_LAST_TRANSACTION_DATE_TIME = "LastTransactionDateTime";
  @SerializedName(SERIALIZED_NAME_LAST_TRANSACTION_DATE_TIME)
  private OffsetDateTime lastTransactionDateTime;

  public static final String SERIALIZED_NAME_LAST_TRANSACTION_STATUS = "LastTransactionStatus";
  @SerializedName(SERIALIZED_NAME_LAST_TRANSACTION_STATUS)
  private String lastTransactionStatus;

  public static final String SERIALIZED_NAME_MANDATE_CREATION_DATE = "MandateCreationDate";
  @SerializedName(SERIALIZED_NAME_MANDATE_CREATION_DATE)
  private LocalDate mandateCreationDate;

  public static final String SERIALIZED_NAME_MANDATE_I_D = "MandateID";
  @SerializedName(SERIALIZED_NAME_MANDATE_I_D)
  private String mandateID;

  public static final String SERIALIZED_NAME_MANDATE_RECEIVED = "MandateReceived";
  @SerializedName(SERIALIZED_NAME_MANDATE_RECEIVED)
  private String mandateReceived;

  public static final String SERIALIZED_NAME_MANDATE_UPDATE_DATE = "MandateUpdateDate";
  @SerializedName(SERIALIZED_NAME_MANDATE_UPDATE_DATE)
  private LocalDate mandateUpdateDate;

  public static final String SERIALIZED_NAME_MAX_CONSECUTIVE_PAYMENT_FAILURES = "MaxConsecutivePaymentFailures";
  @SerializedName(SERIALIZED_NAME_MAX_CONSECUTIVE_PAYMENT_FAILURES)
  private Integer maxConsecutivePaymentFailures;

  public static final String SERIALIZED_NAME_NAME = "Name";
  @SerializedName(SERIALIZED_NAME_NAME)
  private String name;

  public static final String SERIALIZED_NAME_NUM_CONSECUTIVE_FAILURES = "NumConsecutiveFailures";
  @SerializedName(SERIALIZED_NAME_NUM_CONSECUTIVE_FAILURES)
  private Integer numConsecutiveFailures;

  public static final String SERIALIZED_NAME_PAYMENT_METHOD_ID = "PaymentMethodId";
  @SerializedName(SERIALIZED_NAME_PAYMENT_METHOD_ID)
  private String paymentMethodId;

  /**
   * Specifies the status of the payment method.
   */
  @JsonAdapter(PaymentMethodStatusEnum.Adapter.class)
 public enum PaymentMethodStatusEnum {
    ACTIVE("Active"),
    
    CLOSED("Closed");

    private String value;

    PaymentMethodStatusEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static PaymentMethodStatusEnum fromValue(String value) {
      for (PaymentMethodStatusEnum b : PaymentMethodStatusEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<PaymentMethodStatusEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final PaymentMethodStatusEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public PaymentMethodStatusEnum read(final JsonReader jsonReader) throws IOException {
        String value =  jsonReader.nextString();
        return PaymentMethodStatusEnum.fromValue(value);
      }
    }
  }

  public static final String SERIALIZED_NAME_PAYMENT_METHOD_STATUS = "PaymentMethodStatus";
  @SerializedName(SERIALIZED_NAME_PAYMENT_METHOD_STATUS)
  private PaymentMethodStatusEnum paymentMethodStatus;

  public static final String SERIALIZED_NAME_PAYMENT_RETRY_WINDOW = "PaymentRetryWindow";
  @SerializedName(SERIALIZED_NAME_PAYMENT_RETRY_WINDOW)
  private Integer paymentRetryWindow;

  public static final String SERIALIZED_NAME_PAYPAL_BAID = "PaypalBaid";
  @SerializedName(SERIALIZED_NAME_PAYPAL_BAID)
  private String paypalBaid;

  public static final String SERIALIZED_NAME_PAYPAL_EMAIL = "PaypalEmail";
  @SerializedName(SERIALIZED_NAME_PAYPAL_EMAIL)
  private String paypalEmail;

  public static final String SERIALIZED_NAME_PAYPAL_PREAPPROVAL_KEY = "PaypalPreapprovalKey";
  @SerializedName(SERIALIZED_NAME_PAYPAL_PREAPPROVAL_KEY)
  private String paypalPreapprovalKey;

  /**
   * Specifies the PayPal gateway: PayFlow Pro (Express Checkout) or Adaptive Payments.
   */
  @JsonAdapter(PaypalTypeEnum.Adapter.class)
 public enum PaypalTypeEnum {
    EXPRESSCHECKOUT("ExpressCheckout"),
    
    ADAPTIVEPAYMENTS("AdaptivePayments");

    private String value;

    PaypalTypeEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static PaypalTypeEnum fromValue(String value) {
      for (PaypalTypeEnum b : PaypalTypeEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<PaypalTypeEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final PaypalTypeEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public PaypalTypeEnum read(final JsonReader jsonReader) throws IOException {
        String value =  jsonReader.nextString();
        return PaypalTypeEnum.fromValue(value);
      }
    }
  }

  public static final String SERIALIZED_NAME_PAYPAL_TYPE = "PaypalType";
  @SerializedName(SERIALIZED_NAME_PAYPAL_TYPE)
  private PaypalTypeEnum paypalType;

  public static final String SERIALIZED_NAME_PHONE = "Phone";
  @SerializedName(SERIALIZED_NAME_PHONE)
  private String phone;

  public static final String SERIALIZED_NAME_POSTAL_CODE = "PostalCode";
  @SerializedName(SERIALIZED_NAME_POSTAL_CODE)
  private String postalCode;

  public static final String SERIALIZED_NAME_SECOND_TOKEN_ID = "SecondTokenId";
  @SerializedName(SERIALIZED_NAME_SECOND_TOKEN_ID)
  private String secondTokenId;

  public static final String SERIALIZED_NAME_STATE = "State";
  @SerializedName(SERIALIZED_NAME_STATE)
  private String state;

  public static final String SERIALIZED_NAME_STREET_NAME = "StreetName";
  @SerializedName(SERIALIZED_NAME_STREET_NAME)
  private String streetName;

  public static final String SERIALIZED_NAME_STREET_NUMBER = "StreetNumber";
  @SerializedName(SERIALIZED_NAME_STREET_NUMBER)
  private String streetNumber;

  public static final String SERIALIZED_NAME_TOKEN_ID = "TokenId";
  @SerializedName(SERIALIZED_NAME_TOKEN_ID)
  private String tokenId;

  public static final String SERIALIZED_NAME_TOTAL_NUMBER_OF_ERROR_PAYMENTS = "TotalNumberOfErrorPayments";
  @SerializedName(SERIALIZED_NAME_TOTAL_NUMBER_OF_ERROR_PAYMENTS)
  private Integer totalNumberOfErrorPayments;

  public static final String SERIALIZED_NAME_TOTAL_NUMBER_OF_PROCESSED_PAYMENTS = "TotalNumberOfProcessedPayments";
  @SerializedName(SERIALIZED_NAME_TOTAL_NUMBER_OF_PROCESSED_PAYMENTS)
  private Integer totalNumberOfProcessedPayments;

  /**
   * The type of payment method.
   */
  @JsonAdapter(TypeEnum.Adapter.class)
 public enum TypeEnum {
    ACH("ACH"),
    
    APPLEPAY("ApplePay"),
    
    BANKTRANSFER("BankTransfer"),
    
    CASH("Cash"),
    
    CHECK("Check"),
    
    CREDITCARD("CreditCard"),
    
    CREDITCARDREFERENCETRANSACTION("CreditCardReferenceTransaction"),
    
    DEBITCARD("DebitCard"),
    
    OTHER("Other"),
    
    PAYPAL("PayPal"),
    
    WIRETRANSFER("WireTransfer");

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

  public static final String SERIALIZED_NAME_TYPE = "Type";
  @SerializedName(SERIALIZED_NAME_TYPE)
  private TypeEnum type;

  public static final String SERIALIZED_NAME_USE_DEFAULT_RETRY_RULE = "UseDefaultRetryRule";
  @SerializedName(SERIALIZED_NAME_USE_DEFAULT_RETRY_RULE)
  private Boolean useDefaultRetryRule;

  public ProxyGetPaymentMethodSnapshot() {
  }

  public ProxyGetPaymentMethodSnapshot accountId(String accountId) {
    
    
    
    
    this.accountId = accountId;
    return this;
  }

   /**
   * The ID of the customer account associated with this payment method.
   * @return accountId
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The ID of the customer account associated with this payment method.")

  public String getAccountId() {
    return accountId;
  }


  public void setAccountId(String accountId) {
    
    
    
    this.accountId = accountId;
  }


  public ProxyGetPaymentMethodSnapshot achAbaCode(String achAbaCode) {
    
    
    
    
    this.achAbaCode = achAbaCode;
    return this;
  }

   /**
   * The nine-digit routing number or ABA number used by banks. Applicable to ACH payment methods.
   * @return achAbaCode
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The nine-digit routing number or ABA number used by banks. Applicable to ACH payment methods.")

  public String getAchAbaCode() {
    return achAbaCode;
  }


  public void setAchAbaCode(String achAbaCode) {
    
    
    
    this.achAbaCode = achAbaCode;
  }


  public ProxyGetPaymentMethodSnapshot achAccountName(String achAccountName) {
    
    
    
    
    this.achAccountName = achAccountName;
    return this;
  }

   /**
   * The name of the account holder, which can be either a person or a company. Applicable to ACH payment methods.
   * @return achAccountName
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The name of the account holder, which can be either a person or a company. Applicable to ACH payment methods.")

  public String getAchAccountName() {
    return achAccountName;
  }


  public void setAchAccountName(String achAccountName) {
    
    
    
    this.achAccountName = achAccountName;
  }


  public ProxyGetPaymentMethodSnapshot achAccountNumberMask(String achAccountNumberMask) {
    
    
    
    
    this.achAccountNumberMask = achAccountNumberMask;
    return this;
  }

   /**
   * This is a masked displayable version of the ACH account number, used for security purposes. For example: &#x60;XXXXXXXXX54321&#x60;.
   * @return achAccountNumberMask
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "This is a masked displayable version of the ACH account number, used for security purposes. For example: `XXXXXXXXX54321`.")

  public String getAchAccountNumberMask() {
    return achAccountNumberMask;
  }


  public void setAchAccountNumberMask(String achAccountNumberMask) {
    
    
    
    this.achAccountNumberMask = achAccountNumberMask;
  }


  public ProxyGetPaymentMethodSnapshot achAccountType(AchAccountTypeEnum achAccountType) {
    
    
    
    
    this.achAccountType = achAccountType;
    return this;
  }

   /**
   * The type of bank account associated with the ACH payment.
   * @return achAccountType
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The type of bank account associated with the ACH payment.")

  public AchAccountTypeEnum getAchAccountType() {
    return achAccountType;
  }


  public void setAchAccountType(AchAccountTypeEnum achAccountType) {
    
    
    
    this.achAccountType = achAccountType;
  }


  public ProxyGetPaymentMethodSnapshot achBankName(String achBankName) {
    
    
    
    
    this.achBankName = achBankName;
    return this;
  }

   /**
   * The name of the bank where the ACH payment account is held.
   * @return achBankName
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The name of the bank where the ACH payment account is held.")

  public String getAchBankName() {
    return achBankName;
  }


  public void setAchBankName(String achBankName) {
    
    
    
    this.achBankName = achBankName;
  }


  public ProxyGetPaymentMethodSnapshot bankBranchCode(String bankBranchCode) {
    
    
    
    
    this.bankBranchCode = bankBranchCode;
    return this;
  }

   /**
   * The branch code of the bank used for direct debit.
   * @return bankBranchCode
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The branch code of the bank used for direct debit.")

  public String getBankBranchCode() {
    return bankBranchCode;
  }


  public void setBankBranchCode(String bankBranchCode) {
    
    
    
    this.bankBranchCode = bankBranchCode;
  }


  public ProxyGetPaymentMethodSnapshot bankCheckDigit(String bankCheckDigit) {
    
    
    
    
    this.bankCheckDigit = bankCheckDigit;
    return this;
  }

   /**
   * The check digit in the international bank account number, which confirms the validity of the account. Applicable to direct debit payment methods.
   * @return bankCheckDigit
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The check digit in the international bank account number, which confirms the validity of the account. Applicable to direct debit payment methods.")

  public String getBankCheckDigit() {
    return bankCheckDigit;
  }


  public void setBankCheckDigit(String bankCheckDigit) {
    
    
    
    this.bankCheckDigit = bankCheckDigit;
  }


  public ProxyGetPaymentMethodSnapshot bankCity(String bankCity) {
    
    
    
    
    this.bankCity = bankCity;
    return this;
  }

   /**
   * The city of the direct debit bank.
   * @return bankCity
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The city of the direct debit bank.")

  public String getBankCity() {
    return bankCity;
  }


  public void setBankCity(String bankCity) {
    
    
    
    this.bankCity = bankCity;
  }


  public ProxyGetPaymentMethodSnapshot bankCode(String bankCode) {
    
    
    
    
    this.bankCode = bankCode;
    return this;
  }

   /**
   * The sort code or number that identifies the bank. This is also known as the sort code.
   * @return bankCode
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The sort code or number that identifies the bank. This is also known as the sort code.")

  public String getBankCode() {
    return bankCode;
  }


  public void setBankCode(String bankCode) {
    
    
    
    this.bankCode = bankCode;
  }


  public ProxyGetPaymentMethodSnapshot bankIdentificationNumber(String bankIdentificationNumber) {
    
    
    
    
    this.bankIdentificationNumber = bankIdentificationNumber;
    return this;
  }

   /**
   * The first six or eight digits of the payment method&#39;s number, such as the credit card number or account number. Banks use this number to identify a payment method.
   * @return bankIdentificationNumber
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The first six or eight digits of the payment method's number, such as the credit card number or account number. Banks use this number to identify a payment method.")

  public String getBankIdentificationNumber() {
    return bankIdentificationNumber;
  }


  public void setBankIdentificationNumber(String bankIdentificationNumber) {
    
    
    
    this.bankIdentificationNumber = bankIdentificationNumber;
  }


  public ProxyGetPaymentMethodSnapshot bankName(String bankName) {
    
    
    
    
    this.bankName = bankName;
    return this;
  }

   /**
   * The name of the direct debit bank.
   * @return bankName
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The name of the direct debit bank.")

  public String getBankName() {
    return bankName;
  }


  public void setBankName(String bankName) {
    
    
    
    this.bankName = bankName;
  }


  public ProxyGetPaymentMethodSnapshot bankPostalCode(String bankPostalCode) {
    
    
    
    
    this.bankPostalCode = bankPostalCode;
    return this;
  }

   /**
   * The zip code or postal code of the direct debit bank.
   * @return bankPostalCode
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The zip code or postal code of the direct debit bank.")

  public String getBankPostalCode() {
    return bankPostalCode;
  }


  public void setBankPostalCode(String bankPostalCode) {
    
    
    
    this.bankPostalCode = bankPostalCode;
  }


  public ProxyGetPaymentMethodSnapshot bankStreetName(String bankStreetName) {
    
    
    
    
    this.bankStreetName = bankStreetName;
    return this;
  }

   /**
   * The name of the street of the direct debit bank.
   * @return bankStreetName
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The name of the street of the direct debit bank.")

  public String getBankStreetName() {
    return bankStreetName;
  }


  public void setBankStreetName(String bankStreetName) {
    
    
    
    this.bankStreetName = bankStreetName;
  }


  public ProxyGetPaymentMethodSnapshot bankStreetNumber(String bankStreetNumber) {
    
    
    
    
    this.bankStreetNumber = bankStreetNumber;
    return this;
  }

   /**
   * The number of the direct debit bank.
   * @return bankStreetNumber
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The number of the direct debit bank.")

  public String getBankStreetNumber() {
    return bankStreetNumber;
  }


  public void setBankStreetNumber(String bankStreetNumber) {
    
    
    
    this.bankStreetNumber = bankStreetNumber;
  }


  public ProxyGetPaymentMethodSnapshot bankTransferAccountName(String bankTransferAccountName) {
    
    
    
    
    this.bankTransferAccountName = bankTransferAccountName;
    return this;
  }

   /**
   * The name on the direct debit bank account.
   * @return bankTransferAccountName
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The name on the direct debit bank account.")

  public String getBankTransferAccountName() {
    return bankTransferAccountName;
  }


  public void setBankTransferAccountName(String bankTransferAccountName) {
    
    
    
    this.bankTransferAccountName = bankTransferAccountName;
  }


  public ProxyGetPaymentMethodSnapshot bankTransferAccountNumberMask(String bankTransferAccountNumberMask) {
    
    
    
    
    this.bankTransferAccountNumberMask = bankTransferAccountNumberMask;
    return this;
  }

   /**
   * This is a masked displayable version of the bank account number, used for security purposes. For example: &#x60;XXXXXXXXX54321&#x60;.
   * @return bankTransferAccountNumberMask
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "This is a masked displayable version of the bank account number, used for security purposes. For example: `XXXXXXXXX54321`.")

  public String getBankTransferAccountNumberMask() {
    return bankTransferAccountNumberMask;
  }


  public void setBankTransferAccountNumberMask(String bankTransferAccountNumberMask) {
    
    
    
    this.bankTransferAccountNumberMask = bankTransferAccountNumberMask;
  }


  public ProxyGetPaymentMethodSnapshot bankTransferAccountType(String bankTransferAccountType) {
    
    
    
    
    this.bankTransferAccountType = bankTransferAccountType;
    return this;
  }

   /**
   * The type of the customer&#39;s bank account. Applicable to direct debit payment methods.
   * @return bankTransferAccountType
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The type of the customer's bank account. Applicable to direct debit payment methods.")

  public String getBankTransferAccountType() {
    return bankTransferAccountType;
  }


  public void setBankTransferAccountType(String bankTransferAccountType) {
    
    
    
    this.bankTransferAccountType = bankTransferAccountType;
  }


  public ProxyGetPaymentMethodSnapshot bankTransferType(BankTransferTypeEnum bankTransferType) {
    
    
    
    
    this.bankTransferType = bankTransferType;
    return this;
  }

   /**
   * Specifies the type of direct debit transfer. The value of this field is dependent on the country of the user.  Possible Values:    * &#x60;AutomatischIncasso&#x60; (NL)  * &#x60;LastschriftDE&#x60; (Germany)  * &#x60;LastschriftAT&#x60; (Austria)  * &#x60;DemandeDePrelevement&#x60; (FR)  * &#x60;DirectDebitUK&#x60; (UK)  * &#x60;Domicil&#x60; (Belgium)  * &#x60;LastschriftCH&#x60; (CH)  * &#x60;RID&#x60; (Italy)  * &#x60;OrdenDeDomiciliacion&#x60; (Spain) * &#x60;Autogiro&#x60; (Sweden) * &#x60;Betalingsservice&#x60; (Denmark) 
   * @return bankTransferType
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Specifies the type of direct debit transfer. The value of this field is dependent on the country of the user.  Possible Values:    * `AutomatischIncasso` (NL)  * `LastschriftDE` (Germany)  * `LastschriftAT` (Austria)  * `DemandeDePrelevement` (FR)  * `DirectDebitUK` (UK)  * `Domicil` (Belgium)  * `LastschriftCH` (CH)  * `RID` (Italy)  * `OrdenDeDomiciliacion` (Spain) * `Autogiro` (Sweden) * `Betalingsservice` (Denmark) ")

  public BankTransferTypeEnum getBankTransferType() {
    return bankTransferType;
  }


  public void setBankTransferType(BankTransferTypeEnum bankTransferType) {
    
    
    
    this.bankTransferType = bankTransferType;
  }


  public ProxyGetPaymentMethodSnapshot businessIdentificationCode(String businessIdentificationCode) {
    
    
    
    
    this.businessIdentificationCode = businessIdentificationCode;
    return this;
  }

   /**
   * The business identification code for Swiss direct payment methods that use the Global Collect payment gateway. Only applicable to direct debit payments in Switzerland with Global Collect.
   * @return businessIdentificationCode
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The business identification code for Swiss direct payment methods that use the Global Collect payment gateway. Only applicable to direct debit payments in Switzerland with Global Collect.")

  public String getBusinessIdentificationCode() {
    return businessIdentificationCode;
  }


  public void setBusinessIdentificationCode(String businessIdentificationCode) {
    
    
    
    this.businessIdentificationCode = businessIdentificationCode;
  }


  public ProxyGetPaymentMethodSnapshot city(String city) {
    
    
    
    
    this.city = city;
    return this;
  }

   /**
   * The city of the customer&#39;s address. Applicable to debit payment methods.
   * @return city
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The city of the customer's address. Applicable to debit payment methods.")

  public String getCity() {
    return city;
  }


  public void setCity(String city) {
    
    
    
    this.city = city;
  }


  public ProxyGetPaymentMethodSnapshot companyName(String companyName) {
    
    
    
    
    this.companyName = companyName;
    return this;
  }

   /**
   * The name of the company. 
   * @return companyName
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The name of the company. ")

  public String getCompanyName() {
    return companyName;
  }


  public void setCompanyName(String companyName) {
    
    
    
    this.companyName = companyName;
  }


  public ProxyGetPaymentMethodSnapshot country(String country) {
    
    
    
    
    this.country = country;
    return this;
  }

   /**
   * The two-letter country code of the customer&#39;s address. Applicable to direct debit payment methods.
   * @return country
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The two-letter country code of the customer's address. Applicable to direct debit payment methods.")

  public String getCountry() {
    return country;
  }


  public void setCountry(String country) {
    
    
    
    this.country = country;
  }


  public ProxyGetPaymentMethodSnapshot creditCardAddress1(String creditCardAddress1) {
    
    
    
    
    this.creditCardAddress1 = creditCardAddress1;
    return this;
  }

   /**
   * The first line of the card holder&#39;s address, which is often a street address or business name. Applicable to credit card and direct debit payment methods.
   * @return creditCardAddress1
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The first line of the card holder's address, which is often a street address or business name. Applicable to credit card and direct debit payment methods.")

  public String getCreditCardAddress1() {
    return creditCardAddress1;
  }


  public void setCreditCardAddress1(String creditCardAddress1) {
    
    
    
    this.creditCardAddress1 = creditCardAddress1;
  }


  public ProxyGetPaymentMethodSnapshot creditCardAddress2(String creditCardAddress2) {
    
    
    
    
    this.creditCardAddress2 = creditCardAddress2;
    return this;
  }

   /**
   * The second line of the card holder&#39;s address. Applicable to credit card and direct debit payment methods.
   * @return creditCardAddress2
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The second line of the card holder's address. Applicable to credit card and direct debit payment methods.")

  public String getCreditCardAddress2() {
    return creditCardAddress2;
  }


  public void setCreditCardAddress2(String creditCardAddress2) {
    
    
    
    this.creditCardAddress2 = creditCardAddress2;
  }


  public ProxyGetPaymentMethodSnapshot creditCardCity(String creditCardCity) {
    
    
    
    
    this.creditCardCity = creditCardCity;
    return this;
  }

   /**
   * The city of the card holder&#39;s address. Applicable to credit card and direct debit payment methods.
   * @return creditCardCity
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The city of the card holder's address. Applicable to credit card and direct debit payment methods.")

  public String getCreditCardCity() {
    return creditCardCity;
  }


  public void setCreditCardCity(String creditCardCity) {
    
    
    
    this.creditCardCity = creditCardCity;
  }


  public ProxyGetPaymentMethodSnapshot creditCardCountry(String creditCardCountry) {
    
    
    
    
    this.creditCardCountry = creditCardCountry;
    return this;
  }

   /**
   * The country of the card holder&#39;s address.
   * @return creditCardCountry
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The country of the card holder's address.")

  public String getCreditCardCountry() {
    return creditCardCountry;
  }


  public void setCreditCardCountry(String creditCardCountry) {
    
    
    
    this.creditCardCountry = creditCardCountry;
  }


  public ProxyGetPaymentMethodSnapshot creditCardExpirationMonth(Integer creditCardExpirationMonth) {
    
    
    
    
    this.creditCardExpirationMonth = creditCardExpirationMonth;
    return this;
  }

   /**
   * The expiration month of the credit card or debit card. Applicable to credit card and direct debit payment methods.
   * @return creditCardExpirationMonth
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The expiration month of the credit card or debit card. Applicable to credit card and direct debit payment methods.")

  public Integer getCreditCardExpirationMonth() {
    return creditCardExpirationMonth;
  }


  public void setCreditCardExpirationMonth(Integer creditCardExpirationMonth) {
    
    
    
    this.creditCardExpirationMonth = creditCardExpirationMonth;
  }


  public ProxyGetPaymentMethodSnapshot creditCardExpirationYear(Integer creditCardExpirationYear) {
    
    
    
    
    this.creditCardExpirationYear = creditCardExpirationYear;
    return this;
  }

   /**
   * The expiration month of the credit card or debit card. Applicable to credit card and direct debit payment methods.
   * @return creditCardExpirationYear
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The expiration month of the credit card or debit card. Applicable to credit card and direct debit payment methods.")

  public Integer getCreditCardExpirationYear() {
    return creditCardExpirationYear;
  }


  public void setCreditCardExpirationYear(Integer creditCardExpirationYear) {
    
    
    
    this.creditCardExpirationYear = creditCardExpirationYear;
  }


  public ProxyGetPaymentMethodSnapshot creditCardHolderName(String creditCardHolderName) {
    
    
    
    
    this.creditCardHolderName = creditCardHolderName;
    return this;
  }

   /**
   * The full name of the card holder. Applicable to credit card and direct debit payment methods.
   * @return creditCardHolderName
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The full name of the card holder. Applicable to credit card and direct debit payment methods.")

  public String getCreditCardHolderName() {
    return creditCardHolderName;
  }


  public void setCreditCardHolderName(String creditCardHolderName) {
    
    
    
    this.creditCardHolderName = creditCardHolderName;
  }


  public ProxyGetPaymentMethodSnapshot creditCardMaskNumber(String creditCardMaskNumber) {
    
    
    
    
    this.creditCardMaskNumber = creditCardMaskNumber;
    return this;
  }

   /**
   * A masked version of the credit or debit card number.
   * @return creditCardMaskNumber
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "A masked version of the credit or debit card number.")

  public String getCreditCardMaskNumber() {
    return creditCardMaskNumber;
  }


  public void setCreditCardMaskNumber(String creditCardMaskNumber) {
    
    
    
    this.creditCardMaskNumber = creditCardMaskNumber;
  }


  public ProxyGetPaymentMethodSnapshot creditCardPostalCode(String creditCardPostalCode) {
    
    
    
    
    this.creditCardPostalCode = creditCardPostalCode;
    return this;
  }

   /**
   * The billing address&#39;s zip code.
   * @return creditCardPostalCode
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The billing address's zip code.")

  public String getCreditCardPostalCode() {
    return creditCardPostalCode;
  }


  public void setCreditCardPostalCode(String creditCardPostalCode) {
    
    
    
    this.creditCardPostalCode = creditCardPostalCode;
  }


  public ProxyGetPaymentMethodSnapshot creditCardState(String creditCardState) {
    
    
    
    
    this.creditCardState = creditCardState;
    return this;
  }

   /**
   * The billing address&#39;s state. Applicable if &#x60;CreditCardCountry&#x60; is either Canada or the US.
   * @return creditCardState
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The billing address's state. Applicable if `CreditCardCountry` is either Canada or the US.")

  public String getCreditCardState() {
    return creditCardState;
  }


  public void setCreditCardState(String creditCardState) {
    
    
    
    this.creditCardState = creditCardState;
  }


  public ProxyGetPaymentMethodSnapshot creditCardType(CreditCardTypeEnum creditCardType) {
    
    
    
    
    this.creditCardType = creditCardType;
    return this;
  }

   /**
   * The type of credit card or debit card.
   * @return creditCardType
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The type of credit card or debit card.")

  public CreditCardTypeEnum getCreditCardType() {
    return creditCardType;
  }


  public void setCreditCardType(CreditCardTypeEnum creditCardType) {
    
    
    
    this.creditCardType = creditCardType;
  }


  public ProxyGetPaymentMethodSnapshot deviceSessionId(String deviceSessionId) {
    
    
    
    
    this.deviceSessionId = deviceSessionId;
    return this;
  }

   /**
   * The session ID of the user when the &#x60;PaymentMethod&#x60; was created or updated.
   * @return deviceSessionId
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The session ID of the user when the `PaymentMethod` was created or updated.")

  public String getDeviceSessionId() {
    return deviceSessionId;
  }


  public void setDeviceSessionId(String deviceSessionId) {
    
    
    
    this.deviceSessionId = deviceSessionId;
  }


  public ProxyGetPaymentMethodSnapshot email(String email) {
    
    
    
    
    this.email = email;
    return this;
  }

   /**
   * An email address for the payment method in addition to the bill to contact email address.
   * @return email
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "An email address for the payment method in addition to the bill to contact email address.")

  public String getEmail() {
    return email;
  }


  public void setEmail(String email) {
    
    
    
    this.email = email;
  }


  public ProxyGetPaymentMethodSnapshot existingMandate(ExistingMandateEnum existingMandate) {
    
    
    
    
    this.existingMandate = existingMandate;
    return this;
  }

   /**
   * Indicates if the customer has an existing mandate or a new mandate. Only applicable to direct debit payment methods.
   * @return existingMandate
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Indicates if the customer has an existing mandate or a new mandate. Only applicable to direct debit payment methods.")

  public ExistingMandateEnum getExistingMandate() {
    return existingMandate;
  }


  public void setExistingMandate(ExistingMandateEnum existingMandate) {
    
    
    
    this.existingMandate = existingMandate;
  }


  public ProxyGetPaymentMethodSnapshot firstName(String firstName) {
    
    
    
    
    this.firstName = firstName;
    return this;
  }

   /**
   * The customer&#39;s first name. Only applicable to direct debit payment methods.
   * @return firstName
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The customer's first name. Only applicable to direct debit payment methods.")

  public String getFirstName() {
    return firstName;
  }


  public void setFirstName(String firstName) {
    
    
    
    this.firstName = firstName;
  }


  public ProxyGetPaymentMethodSnapshot IBAN(String IBAN) {
    
    
    
    
    this.IBAN = IBAN;
    return this;
  }

   /**
   * The International Bank Account Number. Only applicable to direct debit payment methods.
   * @return IBAN
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The International Bank Account Number. Only applicable to direct debit payment methods.")

  public String getIBAN() {
    return IBAN;
  }


  public void setIBAN(String IBAN) {
    
    
    
    this.IBAN = IBAN;
  }


  public ProxyGetPaymentMethodSnapshot ipAddress(String ipAddress) {
    
    
    
    
    this.ipAddress = ipAddress;
    return this;
  }

   /**
   * The IP address of the user when the payment method was created or updated.
   * @return ipAddress
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The IP address of the user when the payment method was created or updated.")

  public String getIpAddress() {
    return ipAddress;
  }


  public void setIpAddress(String ipAddress) {
    
    
    
    this.ipAddress = ipAddress;
  }


  public ProxyGetPaymentMethodSnapshot id(String id) {
    
    
    
    
    this.id = id;
    return this;
  }

   /**
   * Object identifier.
   * @return id
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Object identifier.")

  public String getId() {
    return id;
  }


  public void setId(String id) {
    
    
    
    this.id = id;
  }


  public ProxyGetPaymentMethodSnapshot identityNumber(String identityNumber) {
    
    
    
    
    this.identityNumber = identityNumber;
    return this;
  }

   /**
   * The unique identity number of the customer account.  
   * @return identityNumber
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The unique identity number of the customer account.  ")

  public String getIdentityNumber() {
    return identityNumber;
  }


  public void setIdentityNumber(String identityNumber) {
    
    
    
    this.identityNumber = identityNumber;
  }


  public ProxyGetPaymentMethodSnapshot isCompany(Boolean isCompany) {
    
    
    
    
    this.isCompany = isCompany;
    return this;
  }

   /**
   * Whether the customer account is a company. 
   * @return isCompany
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Whether the customer account is a company. ")

  public Boolean getIsCompany() {
    return isCompany;
  }


  public void setIsCompany(Boolean isCompany) {
    
    
    
    this.isCompany = isCompany;
  }


  public ProxyGetPaymentMethodSnapshot lastFailedSaleTransactionDate(OffsetDateTime lastFailedSaleTransactionDate) {
    
    
    
    
    this.lastFailedSaleTransactionDate = lastFailedSaleTransactionDate;
    return this;
  }

   /**
   * The date of the last failed attempt to collect payment with this payment method.
   * @return lastFailedSaleTransactionDate
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The date of the last failed attempt to collect payment with this payment method.")

  public OffsetDateTime getLastFailedSaleTransactionDate() {
    return lastFailedSaleTransactionDate;
  }


  public void setLastFailedSaleTransactionDate(OffsetDateTime lastFailedSaleTransactionDate) {
    
    
    
    this.lastFailedSaleTransactionDate = lastFailedSaleTransactionDate;
  }


  public ProxyGetPaymentMethodSnapshot lastName(String lastName) {
    
    
    
    
    this.lastName = lastName;
    return this;
  }

   /**
   * The customer&#39;s last name. Only applicable to direct debit payment methods.
   * @return lastName
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The customer's last name. Only applicable to direct debit payment methods.")

  public String getLastName() {
    return lastName;
  }


  public void setLastName(String lastName) {
    
    
    
    this.lastName = lastName;
  }


  public ProxyGetPaymentMethodSnapshot lastTransactionDateTime(OffsetDateTime lastTransactionDateTime) {
    
    
    
    
    this.lastTransactionDateTime = lastTransactionDateTime;
    return this;
  }

   /**
   * The date of the most recent transaction.
   * @return lastTransactionDateTime
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The date of the most recent transaction.")

  public OffsetDateTime getLastTransactionDateTime() {
    return lastTransactionDateTime;
  }


  public void setLastTransactionDateTime(OffsetDateTime lastTransactionDateTime) {
    
    
    
    this.lastTransactionDateTime = lastTransactionDateTime;
  }


  public ProxyGetPaymentMethodSnapshot lastTransactionStatus(String lastTransactionStatus) {
    
    
    
    
    this.lastTransactionStatus = lastTransactionStatus;
    return this;
  }

   /**
   * The status of the most recent transaction.
   * @return lastTransactionStatus
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The status of the most recent transaction.")

  public String getLastTransactionStatus() {
    return lastTransactionStatus;
  }


  public void setLastTransactionStatus(String lastTransactionStatus) {
    
    
    
    this.lastTransactionStatus = lastTransactionStatus;
  }


  public ProxyGetPaymentMethodSnapshot mandateCreationDate(LocalDate mandateCreationDate) {
    
    
    
    
    this.mandateCreationDate = mandateCreationDate;
    return this;
  }

   /**
   * The date when the mandate was created, in &#x60;yyyy-mm-dd&#x60; format. A mandate is a signed authorization for UK and NL customers. Only applicable to direct debit payment methods.
   * @return mandateCreationDate
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The date when the mandate was created, in `yyyy-mm-dd` format. A mandate is a signed authorization for UK and NL customers. Only applicable to direct debit payment methods.")

  public LocalDate getMandateCreationDate() {
    return mandateCreationDate;
  }


  public void setMandateCreationDate(LocalDate mandateCreationDate) {
    
    
    
    this.mandateCreationDate = mandateCreationDate;
  }


  public ProxyGetPaymentMethodSnapshot mandateID(String mandateID) {
    
    
    
    
    this.mandateID = mandateID;
    return this;
  }

   /**
   * The ID of the mandate. A mandate is a signed authorization for UK and NL customers. Only applicable to direct debit payment methods.
   * @return mandateID
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The ID of the mandate. A mandate is a signed authorization for UK and NL customers. Only applicable to direct debit payment methods.")

  public String getMandateID() {
    return mandateID;
  }


  public void setMandateID(String mandateID) {
    
    
    
    this.mandateID = mandateID;
  }


  public ProxyGetPaymentMethodSnapshot mandateReceived(String mandateReceived) {
    
    
    
    
    this.mandateReceived = mandateReceived;
    return this;
  }

   /**
   * Indicates if  the mandate was received. A mandate is a signed authorization for UK and NL customers. Only applicable to direct debit payment methods.
   * @return mandateReceived
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Indicates if  the mandate was received. A mandate is a signed authorization for UK and NL customers. Only applicable to direct debit payment methods.")

  public String getMandateReceived() {
    return mandateReceived;
  }


  public void setMandateReceived(String mandateReceived) {
    
    
    
    this.mandateReceived = mandateReceived;
  }


  public ProxyGetPaymentMethodSnapshot mandateUpdateDate(LocalDate mandateUpdateDate) {
    
    
    
    
    this.mandateUpdateDate = mandateUpdateDate;
    return this;
  }

   /**
   * The date when the mandate was last updated, in &#x60;yyyy-mm-dd&#x60; format. A mandate is a signed authorization for UK and NL customers. Only applicable to direct debit payment methods.
   * @return mandateUpdateDate
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The date when the mandate was last updated, in `yyyy-mm-dd` format. A mandate is a signed authorization for UK and NL customers. Only applicable to direct debit payment methods.")

  public LocalDate getMandateUpdateDate() {
    return mandateUpdateDate;
  }


  public void setMandateUpdateDate(LocalDate mandateUpdateDate) {
    
    
    
    this.mandateUpdateDate = mandateUpdateDate;
  }


  public ProxyGetPaymentMethodSnapshot maxConsecutivePaymentFailures(Integer maxConsecutivePaymentFailures) {
    
    
    
    
    this.maxConsecutivePaymentFailures = maxConsecutivePaymentFailures;
    return this;
  }

   /**
   * The number of allowable consecutive failures Zuora attempts with the payment method before stopping.
   * @return maxConsecutivePaymentFailures
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The number of allowable consecutive failures Zuora attempts with the payment method before stopping.")

  public Integer getMaxConsecutivePaymentFailures() {
    return maxConsecutivePaymentFailures;
  }


  public void setMaxConsecutivePaymentFailures(Integer maxConsecutivePaymentFailures) {
    
    
    
    this.maxConsecutivePaymentFailures = maxConsecutivePaymentFailures;
  }


  public ProxyGetPaymentMethodSnapshot name(String name) {
    
    
    
    
    this.name = name;
    return this;
  }

   /**
   * The name of the payment method.
   * @return name
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The name of the payment method.")

  public String getName() {
    return name;
  }


  public void setName(String name) {
    
    
    
    this.name = name;
  }


  public ProxyGetPaymentMethodSnapshot numConsecutiveFailures(Integer numConsecutiveFailures) {
    
    
    
    
    this.numConsecutiveFailures = numConsecutiveFailures;
    return this;
  }

   /**
   * The number of consecutive failed payment for the payment method.
   * @return numConsecutiveFailures
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The number of consecutive failed payment for the payment method.")

  public Integer getNumConsecutiveFailures() {
    return numConsecutiveFailures;
  }


  public void setNumConsecutiveFailures(Integer numConsecutiveFailures) {
    
    
    
    this.numConsecutiveFailures = numConsecutiveFailures;
  }


  public ProxyGetPaymentMethodSnapshot paymentMethodId(String paymentMethodId) {
    
    
    
    
    this.paymentMethodId = paymentMethodId;
    return this;
  }

   /**
   * Object identifier of the payment method.
   * @return paymentMethodId
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Object identifier of the payment method.")

  public String getPaymentMethodId() {
    return paymentMethodId;
  }


  public void setPaymentMethodId(String paymentMethodId) {
    
    
    
    this.paymentMethodId = paymentMethodId;
  }


  public ProxyGetPaymentMethodSnapshot paymentMethodStatus(PaymentMethodStatusEnum paymentMethodStatus) {
    
    
    
    
    this.paymentMethodStatus = paymentMethodStatus;
    return this;
  }

   /**
   * Specifies the status of the payment method.
   * @return paymentMethodStatus
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Specifies the status of the payment method.")

  public PaymentMethodStatusEnum getPaymentMethodStatus() {
    return paymentMethodStatus;
  }


  public void setPaymentMethodStatus(PaymentMethodStatusEnum paymentMethodStatus) {
    
    
    
    this.paymentMethodStatus = paymentMethodStatus;
  }


  public ProxyGetPaymentMethodSnapshot paymentRetryWindow(Integer paymentRetryWindow) {
    
    
    
    
    this.paymentRetryWindow = paymentRetryWindow;
    return this;
  }

   /**
   * The retry interval setting, which prevents making a payment attempt if the last failed attempt was within the last specified number of hours.
   * @return paymentRetryWindow
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The retry interval setting, which prevents making a payment attempt if the last failed attempt was within the last specified number of hours.")

  public Integer getPaymentRetryWindow() {
    return paymentRetryWindow;
  }


  public void setPaymentRetryWindow(Integer paymentRetryWindow) {
    
    
    
    this.paymentRetryWindow = paymentRetryWindow;
  }


  public ProxyGetPaymentMethodSnapshot paypalBaid(String paypalBaid) {
    
    
    
    
    this.paypalBaid = paypalBaid;
    return this;
  }

   /**
   * The PayPal billing agreement ID, which is a contract between two PayPal accounts.
   * @return paypalBaid
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The PayPal billing agreement ID, which is a contract between two PayPal accounts.")

  public String getPaypalBaid() {
    return paypalBaid;
  }


  public void setPaypalBaid(String paypalBaid) {
    
    
    
    this.paypalBaid = paypalBaid;
  }


  public ProxyGetPaymentMethodSnapshot paypalEmail(String paypalEmail) {
    
    
    
    
    this.paypalEmail = paypalEmail;
    return this;
  }

   /**
   * The email address associated with the account holder&#39;s PayPal account or of the PayPal account of the person paying for the service.
   * @return paypalEmail
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The email address associated with the account holder's PayPal account or of the PayPal account of the person paying for the service.")

  public String getPaypalEmail() {
    return paypalEmail;
  }


  public void setPaypalEmail(String paypalEmail) {
    
    
    
    this.paypalEmail = paypalEmail;
  }


  public ProxyGetPaymentMethodSnapshot paypalPreapprovalKey(String paypalPreapprovalKey) {
    
    
    
    
    this.paypalPreapprovalKey = paypalPreapprovalKey;
    return this;
  }

   /**
   * PayPal&#39;s Adaptive Payments API key.
   * @return paypalPreapprovalKey
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "PayPal's Adaptive Payments API key.")

  public String getPaypalPreapprovalKey() {
    return paypalPreapprovalKey;
  }


  public void setPaypalPreapprovalKey(String paypalPreapprovalKey) {
    
    
    
    this.paypalPreapprovalKey = paypalPreapprovalKey;
  }


  public ProxyGetPaymentMethodSnapshot paypalType(PaypalTypeEnum paypalType) {
    
    
    
    
    this.paypalType = paypalType;
    return this;
  }

   /**
   * Specifies the PayPal gateway: PayFlow Pro (Express Checkout) or Adaptive Payments.
   * @return paypalType
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Specifies the PayPal gateway: PayFlow Pro (Express Checkout) or Adaptive Payments.")

  public PaypalTypeEnum getPaypalType() {
    return paypalType;
  }


  public void setPaypalType(PaypalTypeEnum paypalType) {
    
    
    
    this.paypalType = paypalType;
  }


  public ProxyGetPaymentMethodSnapshot phone(String phone) {
    
    
    
    
    this.phone = phone;
    return this;
  }

   /**
   * The phone number that the account holder registered with the bank. This field is used for credit card validation when passing to a gateway.
   * @return phone
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The phone number that the account holder registered with the bank. This field is used for credit card validation when passing to a gateway.")

  public String getPhone() {
    return phone;
  }


  public void setPhone(String phone) {
    
    
    
    this.phone = phone;
  }


  public ProxyGetPaymentMethodSnapshot postalCode(String postalCode) {
    
    
    
    
    this.postalCode = postalCode;
    return this;
  }

   /**
   * The zip code of the customer&#39;s address. Only applicable to direct debit payment methods.
   * @return postalCode
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The zip code of the customer's address. Only applicable to direct debit payment methods.")

  public String getPostalCode() {
    return postalCode;
  }


  public void setPostalCode(String postalCode) {
    
    
    
    this.postalCode = postalCode;
  }


  public ProxyGetPaymentMethodSnapshot secondTokenId(String secondTokenId) {
    
    
    
    
    this.secondTokenId = secondTokenId;
    return this;
  }

   /**
   * A gateway unique identifier that replaces sensitive payment method data. Applicable to CC Reference Transaction payment methods.
   * @return secondTokenId
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "A gateway unique identifier that replaces sensitive payment method data. Applicable to CC Reference Transaction payment methods.")

  public String getSecondTokenId() {
    return secondTokenId;
  }


  public void setSecondTokenId(String secondTokenId) {
    
    
    
    this.secondTokenId = secondTokenId;
  }


  public ProxyGetPaymentMethodSnapshot state(String state) {
    
    
    
    
    this.state = state;
    return this;
  }

   /**
   * The state of the customer&#39;s address. Only applicable to direct debit payment methods.
   * @return state
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The state of the customer's address. Only applicable to direct debit payment methods.")

  public String getState() {
    return state;
  }


  public void setState(String state) {
    
    
    
    this.state = state;
  }


  public ProxyGetPaymentMethodSnapshot streetName(String streetName) {
    
    
    
    
    this.streetName = streetName;
    return this;
  }

   /**
   * The street name of the customer&#39;s address. Only applicable to direct debit payment methods.
   * @return streetName
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The street name of the customer's address. Only applicable to direct debit payment methods.")

  public String getStreetName() {
    return streetName;
  }


  public void setStreetName(String streetName) {
    
    
    
    this.streetName = streetName;
  }


  public ProxyGetPaymentMethodSnapshot streetNumber(String streetNumber) {
    
    
    
    
    this.streetNumber = streetNumber;
    return this;
  }

   /**
   * The street number of the customer&#39;s address. Only applicable to direct debit payment methods.
   * @return streetNumber
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The street number of the customer's address. Only applicable to direct debit payment methods.")

  public String getStreetNumber() {
    return streetNumber;
  }


  public void setStreetNumber(String streetNumber) {
    
    
    
    this.streetNumber = streetNumber;
  }


  public ProxyGetPaymentMethodSnapshot tokenId(String tokenId) {
    
    
    
    
    this.tokenId = tokenId;
    return this;
  }

   /**
   * A gateway unique identifier that replaces sensitive payment method data or represents a gateway&#39;s unique customer profile. Applicable to CC Reference Transaction payment methods.
   * @return tokenId
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "A gateway unique identifier that replaces sensitive payment method data or represents a gateway's unique customer profile. Applicable to CC Reference Transaction payment methods.")

  public String getTokenId() {
    return tokenId;
  }


  public void setTokenId(String tokenId) {
    
    
    
    this.tokenId = tokenId;
  }


  public ProxyGetPaymentMethodSnapshot totalNumberOfErrorPayments(Integer totalNumberOfErrorPayments) {
    
    
    
    
    this.totalNumberOfErrorPayments = totalNumberOfErrorPayments;
    return this;
  }

   /**
   * The number of error payments that used this payment method.
   * @return totalNumberOfErrorPayments
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The number of error payments that used this payment method.")

  public Integer getTotalNumberOfErrorPayments() {
    return totalNumberOfErrorPayments;
  }


  public void setTotalNumberOfErrorPayments(Integer totalNumberOfErrorPayments) {
    
    
    
    this.totalNumberOfErrorPayments = totalNumberOfErrorPayments;
  }


  public ProxyGetPaymentMethodSnapshot totalNumberOfProcessedPayments(Integer totalNumberOfProcessedPayments) {
    
    
    
    
    this.totalNumberOfProcessedPayments = totalNumberOfProcessedPayments;
    return this;
  }

   /**
   * The number of successful payments that used this payment method.
   * @return totalNumberOfProcessedPayments
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The number of successful payments that used this payment method.")

  public Integer getTotalNumberOfProcessedPayments() {
    return totalNumberOfProcessedPayments;
  }


  public void setTotalNumberOfProcessedPayments(Integer totalNumberOfProcessedPayments) {
    
    
    
    this.totalNumberOfProcessedPayments = totalNumberOfProcessedPayments;
  }


  public ProxyGetPaymentMethodSnapshot type(TypeEnum type) {
    
    
    
    
    this.type = type;
    return this;
  }

   /**
   * The type of payment method.
   * @return type
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The type of payment method.")

  public TypeEnum getType() {
    return type;
  }


  public void setType(TypeEnum type) {
    
    
    
    this.type = type;
  }


  public ProxyGetPaymentMethodSnapshot useDefaultRetryRule(Boolean useDefaultRetryRule) {
    
    
    
    
    this.useDefaultRetryRule = useDefaultRetryRule;
    return this;
  }

   /**
   * Determines whether to use the default retry rules configured in the Zuora Payments settings.
   * @return useDefaultRetryRule
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Determines whether to use the default retry rules configured in the Zuora Payments settings.")

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
   * @return the ProxyGetPaymentMethodSnapshot instance itself
   */
  public ProxyGetPaymentMethodSnapshot putAdditionalProperty(String key, Object value) {
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
    ProxyGetPaymentMethodSnapshot proxyGetPaymentMethodSnapshot = (ProxyGetPaymentMethodSnapshot) o;
    return Objects.equals(this.accountId, proxyGetPaymentMethodSnapshot.accountId) &&
        Objects.equals(this.achAbaCode, proxyGetPaymentMethodSnapshot.achAbaCode) &&
        Objects.equals(this.achAccountName, proxyGetPaymentMethodSnapshot.achAccountName) &&
        Objects.equals(this.achAccountNumberMask, proxyGetPaymentMethodSnapshot.achAccountNumberMask) &&
        Objects.equals(this.achAccountType, proxyGetPaymentMethodSnapshot.achAccountType) &&
        Objects.equals(this.achBankName, proxyGetPaymentMethodSnapshot.achBankName) &&
        Objects.equals(this.bankBranchCode, proxyGetPaymentMethodSnapshot.bankBranchCode) &&
        Objects.equals(this.bankCheckDigit, proxyGetPaymentMethodSnapshot.bankCheckDigit) &&
        Objects.equals(this.bankCity, proxyGetPaymentMethodSnapshot.bankCity) &&
        Objects.equals(this.bankCode, proxyGetPaymentMethodSnapshot.bankCode) &&
        Objects.equals(this.bankIdentificationNumber, proxyGetPaymentMethodSnapshot.bankIdentificationNumber) &&
        Objects.equals(this.bankName, proxyGetPaymentMethodSnapshot.bankName) &&
        Objects.equals(this.bankPostalCode, proxyGetPaymentMethodSnapshot.bankPostalCode) &&
        Objects.equals(this.bankStreetName, proxyGetPaymentMethodSnapshot.bankStreetName) &&
        Objects.equals(this.bankStreetNumber, proxyGetPaymentMethodSnapshot.bankStreetNumber) &&
        Objects.equals(this.bankTransferAccountName, proxyGetPaymentMethodSnapshot.bankTransferAccountName) &&
        Objects.equals(this.bankTransferAccountNumberMask, proxyGetPaymentMethodSnapshot.bankTransferAccountNumberMask) &&
        Objects.equals(this.bankTransferAccountType, proxyGetPaymentMethodSnapshot.bankTransferAccountType) &&
        Objects.equals(this.bankTransferType, proxyGetPaymentMethodSnapshot.bankTransferType) &&
        Objects.equals(this.businessIdentificationCode, proxyGetPaymentMethodSnapshot.businessIdentificationCode) &&
        Objects.equals(this.city, proxyGetPaymentMethodSnapshot.city) &&
        Objects.equals(this.companyName, proxyGetPaymentMethodSnapshot.companyName) &&
        Objects.equals(this.country, proxyGetPaymentMethodSnapshot.country) &&
        Objects.equals(this.creditCardAddress1, proxyGetPaymentMethodSnapshot.creditCardAddress1) &&
        Objects.equals(this.creditCardAddress2, proxyGetPaymentMethodSnapshot.creditCardAddress2) &&
        Objects.equals(this.creditCardCity, proxyGetPaymentMethodSnapshot.creditCardCity) &&
        Objects.equals(this.creditCardCountry, proxyGetPaymentMethodSnapshot.creditCardCountry) &&
        Objects.equals(this.creditCardExpirationMonth, proxyGetPaymentMethodSnapshot.creditCardExpirationMonth) &&
        Objects.equals(this.creditCardExpirationYear, proxyGetPaymentMethodSnapshot.creditCardExpirationYear) &&
        Objects.equals(this.creditCardHolderName, proxyGetPaymentMethodSnapshot.creditCardHolderName) &&
        Objects.equals(this.creditCardMaskNumber, proxyGetPaymentMethodSnapshot.creditCardMaskNumber) &&
        Objects.equals(this.creditCardPostalCode, proxyGetPaymentMethodSnapshot.creditCardPostalCode) &&
        Objects.equals(this.creditCardState, proxyGetPaymentMethodSnapshot.creditCardState) &&
        Objects.equals(this.creditCardType, proxyGetPaymentMethodSnapshot.creditCardType) &&
        Objects.equals(this.deviceSessionId, proxyGetPaymentMethodSnapshot.deviceSessionId) &&
        Objects.equals(this.email, proxyGetPaymentMethodSnapshot.email) &&
        Objects.equals(this.existingMandate, proxyGetPaymentMethodSnapshot.existingMandate) &&
        Objects.equals(this.firstName, proxyGetPaymentMethodSnapshot.firstName) &&
        Objects.equals(this.IBAN, proxyGetPaymentMethodSnapshot.IBAN) &&
        Objects.equals(this.ipAddress, proxyGetPaymentMethodSnapshot.ipAddress) &&
        Objects.equals(this.id, proxyGetPaymentMethodSnapshot.id) &&
        Objects.equals(this.identityNumber, proxyGetPaymentMethodSnapshot.identityNumber) &&
        Objects.equals(this.isCompany, proxyGetPaymentMethodSnapshot.isCompany) &&
        Objects.equals(this.lastFailedSaleTransactionDate, proxyGetPaymentMethodSnapshot.lastFailedSaleTransactionDate) &&
        Objects.equals(this.lastName, proxyGetPaymentMethodSnapshot.lastName) &&
        Objects.equals(this.lastTransactionDateTime, proxyGetPaymentMethodSnapshot.lastTransactionDateTime) &&
        Objects.equals(this.lastTransactionStatus, proxyGetPaymentMethodSnapshot.lastTransactionStatus) &&
        Objects.equals(this.mandateCreationDate, proxyGetPaymentMethodSnapshot.mandateCreationDate) &&
        Objects.equals(this.mandateID, proxyGetPaymentMethodSnapshot.mandateID) &&
        Objects.equals(this.mandateReceived, proxyGetPaymentMethodSnapshot.mandateReceived) &&
        Objects.equals(this.mandateUpdateDate, proxyGetPaymentMethodSnapshot.mandateUpdateDate) &&
        Objects.equals(this.maxConsecutivePaymentFailures, proxyGetPaymentMethodSnapshot.maxConsecutivePaymentFailures) &&
        Objects.equals(this.name, proxyGetPaymentMethodSnapshot.name) &&
        Objects.equals(this.numConsecutiveFailures, proxyGetPaymentMethodSnapshot.numConsecutiveFailures) &&
        Objects.equals(this.paymentMethodId, proxyGetPaymentMethodSnapshot.paymentMethodId) &&
        Objects.equals(this.paymentMethodStatus, proxyGetPaymentMethodSnapshot.paymentMethodStatus) &&
        Objects.equals(this.paymentRetryWindow, proxyGetPaymentMethodSnapshot.paymentRetryWindow) &&
        Objects.equals(this.paypalBaid, proxyGetPaymentMethodSnapshot.paypalBaid) &&
        Objects.equals(this.paypalEmail, proxyGetPaymentMethodSnapshot.paypalEmail) &&
        Objects.equals(this.paypalPreapprovalKey, proxyGetPaymentMethodSnapshot.paypalPreapprovalKey) &&
        Objects.equals(this.paypalType, proxyGetPaymentMethodSnapshot.paypalType) &&
        Objects.equals(this.phone, proxyGetPaymentMethodSnapshot.phone) &&
        Objects.equals(this.postalCode, proxyGetPaymentMethodSnapshot.postalCode) &&
        Objects.equals(this.secondTokenId, proxyGetPaymentMethodSnapshot.secondTokenId) &&
        Objects.equals(this.state, proxyGetPaymentMethodSnapshot.state) &&
        Objects.equals(this.streetName, proxyGetPaymentMethodSnapshot.streetName) &&
        Objects.equals(this.streetNumber, proxyGetPaymentMethodSnapshot.streetNumber) &&
        Objects.equals(this.tokenId, proxyGetPaymentMethodSnapshot.tokenId) &&
        Objects.equals(this.totalNumberOfErrorPayments, proxyGetPaymentMethodSnapshot.totalNumberOfErrorPayments) &&
        Objects.equals(this.totalNumberOfProcessedPayments, proxyGetPaymentMethodSnapshot.totalNumberOfProcessedPayments) &&
        Objects.equals(this.type, proxyGetPaymentMethodSnapshot.type) &&
        Objects.equals(this.useDefaultRetryRule, proxyGetPaymentMethodSnapshot.useDefaultRetryRule)&&
        Objects.equals(this.additionalProperties, proxyGetPaymentMethodSnapshot.additionalProperties);
  }

  @Override
  public int hashCode() {
    return Objects.hash(accountId, achAbaCode, achAccountName, achAccountNumberMask, achAccountType, achBankName, bankBranchCode, bankCheckDigit, bankCity, bankCode, bankIdentificationNumber, bankName, bankPostalCode, bankStreetName, bankStreetNumber, bankTransferAccountName, bankTransferAccountNumberMask, bankTransferAccountType, bankTransferType, businessIdentificationCode, city, companyName, country, creditCardAddress1, creditCardAddress2, creditCardCity, creditCardCountry, creditCardExpirationMonth, creditCardExpirationYear, creditCardHolderName, creditCardMaskNumber, creditCardPostalCode, creditCardState, creditCardType, deviceSessionId, email, existingMandate, firstName, IBAN, ipAddress, id, identityNumber, isCompany, lastFailedSaleTransactionDate, lastName, lastTransactionDateTime, lastTransactionStatus, mandateCreationDate, mandateID, mandateReceived, mandateUpdateDate, maxConsecutivePaymentFailures, name, numConsecutiveFailures, paymentMethodId, paymentMethodStatus, paymentRetryWindow, paypalBaid, paypalEmail, paypalPreapprovalKey, paypalType, phone, postalCode, secondTokenId, state, streetName, streetNumber, tokenId, totalNumberOfErrorPayments, totalNumberOfProcessedPayments, type, useDefaultRetryRule, additionalProperties);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ProxyGetPaymentMethodSnapshot {\n");
    sb.append("    accountId: ").append(toIndentedString(accountId)).append("\n");
    sb.append("    achAbaCode: ").append(toIndentedString(achAbaCode)).append("\n");
    sb.append("    achAccountName: ").append(toIndentedString(achAccountName)).append("\n");
    sb.append("    achAccountNumberMask: ").append(toIndentedString(achAccountNumberMask)).append("\n");
    sb.append("    achAccountType: ").append(toIndentedString(achAccountType)).append("\n");
    sb.append("    achBankName: ").append(toIndentedString(achBankName)).append("\n");
    sb.append("    bankBranchCode: ").append(toIndentedString(bankBranchCode)).append("\n");
    sb.append("    bankCheckDigit: ").append(toIndentedString(bankCheckDigit)).append("\n");
    sb.append("    bankCity: ").append(toIndentedString(bankCity)).append("\n");
    sb.append("    bankCode: ").append(toIndentedString(bankCode)).append("\n");
    sb.append("    bankIdentificationNumber: ").append(toIndentedString(bankIdentificationNumber)).append("\n");
    sb.append("    bankName: ").append(toIndentedString(bankName)).append("\n");
    sb.append("    bankPostalCode: ").append(toIndentedString(bankPostalCode)).append("\n");
    sb.append("    bankStreetName: ").append(toIndentedString(bankStreetName)).append("\n");
    sb.append("    bankStreetNumber: ").append(toIndentedString(bankStreetNumber)).append("\n");
    sb.append("    bankTransferAccountName: ").append(toIndentedString(bankTransferAccountName)).append("\n");
    sb.append("    bankTransferAccountNumberMask: ").append(toIndentedString(bankTransferAccountNumberMask)).append("\n");
    sb.append("    bankTransferAccountType: ").append(toIndentedString(bankTransferAccountType)).append("\n");
    sb.append("    bankTransferType: ").append(toIndentedString(bankTransferType)).append("\n");
    sb.append("    businessIdentificationCode: ").append(toIndentedString(businessIdentificationCode)).append("\n");
    sb.append("    city: ").append(toIndentedString(city)).append("\n");
    sb.append("    companyName: ").append(toIndentedString(companyName)).append("\n");
    sb.append("    country: ").append(toIndentedString(country)).append("\n");
    sb.append("    creditCardAddress1: ").append(toIndentedString(creditCardAddress1)).append("\n");
    sb.append("    creditCardAddress2: ").append(toIndentedString(creditCardAddress2)).append("\n");
    sb.append("    creditCardCity: ").append(toIndentedString(creditCardCity)).append("\n");
    sb.append("    creditCardCountry: ").append(toIndentedString(creditCardCountry)).append("\n");
    sb.append("    creditCardExpirationMonth: ").append(toIndentedString(creditCardExpirationMonth)).append("\n");
    sb.append("    creditCardExpirationYear: ").append(toIndentedString(creditCardExpirationYear)).append("\n");
    sb.append("    creditCardHolderName: ").append(toIndentedString(creditCardHolderName)).append("\n");
    sb.append("    creditCardMaskNumber: ").append(toIndentedString(creditCardMaskNumber)).append("\n");
    sb.append("    creditCardPostalCode: ").append(toIndentedString(creditCardPostalCode)).append("\n");
    sb.append("    creditCardState: ").append(toIndentedString(creditCardState)).append("\n");
    sb.append("    creditCardType: ").append(toIndentedString(creditCardType)).append("\n");
    sb.append("    deviceSessionId: ").append(toIndentedString(deviceSessionId)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    existingMandate: ").append(toIndentedString(existingMandate)).append("\n");
    sb.append("    firstName: ").append(toIndentedString(firstName)).append("\n");
    sb.append("    IBAN: ").append(toIndentedString(IBAN)).append("\n");
    sb.append("    ipAddress: ").append(toIndentedString(ipAddress)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    identityNumber: ").append(toIndentedString(identityNumber)).append("\n");
    sb.append("    isCompany: ").append(toIndentedString(isCompany)).append("\n");
    sb.append("    lastFailedSaleTransactionDate: ").append(toIndentedString(lastFailedSaleTransactionDate)).append("\n");
    sb.append("    lastName: ").append(toIndentedString(lastName)).append("\n");
    sb.append("    lastTransactionDateTime: ").append(toIndentedString(lastTransactionDateTime)).append("\n");
    sb.append("    lastTransactionStatus: ").append(toIndentedString(lastTransactionStatus)).append("\n");
    sb.append("    mandateCreationDate: ").append(toIndentedString(mandateCreationDate)).append("\n");
    sb.append("    mandateID: ").append(toIndentedString(mandateID)).append("\n");
    sb.append("    mandateReceived: ").append(toIndentedString(mandateReceived)).append("\n");
    sb.append("    mandateUpdateDate: ").append(toIndentedString(mandateUpdateDate)).append("\n");
    sb.append("    maxConsecutivePaymentFailures: ").append(toIndentedString(maxConsecutivePaymentFailures)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    numConsecutiveFailures: ").append(toIndentedString(numConsecutiveFailures)).append("\n");
    sb.append("    paymentMethodId: ").append(toIndentedString(paymentMethodId)).append("\n");
    sb.append("    paymentMethodStatus: ").append(toIndentedString(paymentMethodStatus)).append("\n");
    sb.append("    paymentRetryWindow: ").append(toIndentedString(paymentRetryWindow)).append("\n");
    sb.append("    paypalBaid: ").append(toIndentedString(paypalBaid)).append("\n");
    sb.append("    paypalEmail: ").append(toIndentedString(paypalEmail)).append("\n");
    sb.append("    paypalPreapprovalKey: ").append(toIndentedString(paypalPreapprovalKey)).append("\n");
    sb.append("    paypalType: ").append(toIndentedString(paypalType)).append("\n");
    sb.append("    phone: ").append(toIndentedString(phone)).append("\n");
    sb.append("    postalCode: ").append(toIndentedString(postalCode)).append("\n");
    sb.append("    secondTokenId: ").append(toIndentedString(secondTokenId)).append("\n");
    sb.append("    state: ").append(toIndentedString(state)).append("\n");
    sb.append("    streetName: ").append(toIndentedString(streetName)).append("\n");
    sb.append("    streetNumber: ").append(toIndentedString(streetNumber)).append("\n");
    sb.append("    tokenId: ").append(toIndentedString(tokenId)).append("\n");
    sb.append("    totalNumberOfErrorPayments: ").append(toIndentedString(totalNumberOfErrorPayments)).append("\n");
    sb.append("    totalNumberOfProcessedPayments: ").append(toIndentedString(totalNumberOfProcessedPayments)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
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
    openapiFields.add("AccountId");
    openapiFields.add("AchAbaCode");
    openapiFields.add("AchAccountName");
    openapiFields.add("AchAccountNumberMask");
    openapiFields.add("AchAccountType");
    openapiFields.add("AchBankName");
    openapiFields.add("BankBranchCode");
    openapiFields.add("BankCheckDigit");
    openapiFields.add("BankCity");
    openapiFields.add("BankCode");
    openapiFields.add("BankIdentificationNumber");
    openapiFields.add("BankName");
    openapiFields.add("BankPostalCode");
    openapiFields.add("BankStreetName");
    openapiFields.add("BankStreetNumber");
    openapiFields.add("BankTransferAccountName");
    openapiFields.add("BankTransferAccountNumberMask");
    openapiFields.add("BankTransferAccountType");
    openapiFields.add("BankTransferType");
    openapiFields.add("BusinessIdentificationCode");
    openapiFields.add("City");
    openapiFields.add("CompanyName");
    openapiFields.add("Country");
    openapiFields.add("CreditCardAddress1");
    openapiFields.add("CreditCardAddress2");
    openapiFields.add("CreditCardCity");
    openapiFields.add("CreditCardCountry");
    openapiFields.add("CreditCardExpirationMonth");
    openapiFields.add("CreditCardExpirationYear");
    openapiFields.add("CreditCardHolderName");
    openapiFields.add("CreditCardMaskNumber");
    openapiFields.add("CreditCardPostalCode");
    openapiFields.add("CreditCardState");
    openapiFields.add("CreditCardType");
    openapiFields.add("DeviceSessionId");
    openapiFields.add("Email");
    openapiFields.add("ExistingMandate");
    openapiFields.add("FirstName");
    openapiFields.add("IBAN");
    openapiFields.add("IPAddress");
    openapiFields.add("Id");
    openapiFields.add("IdentityNumber");
    openapiFields.add("IsCompany");
    openapiFields.add("LastFailedSaleTransactionDate");
    openapiFields.add("LastName");
    openapiFields.add("LastTransactionDateTime");
    openapiFields.add("LastTransactionStatus");
    openapiFields.add("MandateCreationDate");
    openapiFields.add("MandateID");
    openapiFields.add("MandateReceived");
    openapiFields.add("MandateUpdateDate");
    openapiFields.add("MaxConsecutivePaymentFailures");
    openapiFields.add("Name");
    openapiFields.add("NumConsecutiveFailures");
    openapiFields.add("PaymentMethodId");
    openapiFields.add("PaymentMethodStatus");
    openapiFields.add("PaymentRetryWindow");
    openapiFields.add("PaypalBaid");
    openapiFields.add("PaypalEmail");
    openapiFields.add("PaypalPreapprovalKey");
    openapiFields.add("PaypalType");
    openapiFields.add("Phone");
    openapiFields.add("PostalCode");
    openapiFields.add("SecondTokenId");
    openapiFields.add("State");
    openapiFields.add("StreetName");
    openapiFields.add("StreetNumber");
    openapiFields.add("TokenId");
    openapiFields.add("TotalNumberOfErrorPayments");
    openapiFields.add("TotalNumberOfProcessedPayments");
    openapiFields.add("Type");
    openapiFields.add("UseDefaultRetryRule");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
  }

 /**
  * Validates the JSON Object and throws an exception if issues found
  *
  * @param jsonObj JSON Object
  * @throws IOException if the JSON Object is invalid with respect to ProxyGetPaymentMethodSnapshot
  */
  public static void validateJsonObject(JsonObject jsonObj) throws IOException {
      if (jsonObj == null) {
        if (!ProxyGetPaymentMethodSnapshot.openapiRequiredFields.isEmpty()) { // has required fields but JSON object is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in ProxyGetPaymentMethodSnapshot is not found in the empty JSON string", ProxyGetPaymentMethodSnapshot.openapiRequiredFields.toString()));
        }
      }
      if ((jsonObj.get("AccountId") != null && !jsonObj.get("AccountId").isJsonNull()) && !jsonObj.get("AccountId").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `AccountId` to be a primitive type in the JSON string but got `%s`", jsonObj.get("AccountId").toString()));
      }
      if ((jsonObj.get("AchAbaCode") != null && !jsonObj.get("AchAbaCode").isJsonNull()) && !jsonObj.get("AchAbaCode").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `AchAbaCode` to be a primitive type in the JSON string but got `%s`", jsonObj.get("AchAbaCode").toString()));
      }
      if ((jsonObj.get("AchAccountName") != null && !jsonObj.get("AchAccountName").isJsonNull()) && !jsonObj.get("AchAccountName").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `AchAccountName` to be a primitive type in the JSON string but got `%s`", jsonObj.get("AchAccountName").toString()));
      }
      if ((jsonObj.get("AchAccountNumberMask") != null && !jsonObj.get("AchAccountNumberMask").isJsonNull()) && !jsonObj.get("AchAccountNumberMask").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `AchAccountNumberMask` to be a primitive type in the JSON string but got `%s`", jsonObj.get("AchAccountNumberMask").toString()));
      }
      if ((jsonObj.get("AchAccountType") != null && !jsonObj.get("AchAccountType").isJsonNull()) && !jsonObj.get("AchAccountType").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `AchAccountType` to be a primitive type in the JSON string but got `%s`", jsonObj.get("AchAccountType").toString()));
      }
      if ((jsonObj.get("AchBankName") != null && !jsonObj.get("AchBankName").isJsonNull()) && !jsonObj.get("AchBankName").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `AchBankName` to be a primitive type in the JSON string but got `%s`", jsonObj.get("AchBankName").toString()));
      }
      if ((jsonObj.get("BankBranchCode") != null && !jsonObj.get("BankBranchCode").isJsonNull()) && !jsonObj.get("BankBranchCode").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `BankBranchCode` to be a primitive type in the JSON string but got `%s`", jsonObj.get("BankBranchCode").toString()));
      }
      if ((jsonObj.get("BankCheckDigit") != null && !jsonObj.get("BankCheckDigit").isJsonNull()) && !jsonObj.get("BankCheckDigit").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `BankCheckDigit` to be a primitive type in the JSON string but got `%s`", jsonObj.get("BankCheckDigit").toString()));
      }
      if ((jsonObj.get("BankCity") != null && !jsonObj.get("BankCity").isJsonNull()) && !jsonObj.get("BankCity").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `BankCity` to be a primitive type in the JSON string but got `%s`", jsonObj.get("BankCity").toString()));
      }
      if ((jsonObj.get("BankCode") != null && !jsonObj.get("BankCode").isJsonNull()) && !jsonObj.get("BankCode").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `BankCode` to be a primitive type in the JSON string but got `%s`", jsonObj.get("BankCode").toString()));
      }
      if ((jsonObj.get("BankIdentificationNumber") != null && !jsonObj.get("BankIdentificationNumber").isJsonNull()) && !jsonObj.get("BankIdentificationNumber").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `BankIdentificationNumber` to be a primitive type in the JSON string but got `%s`", jsonObj.get("BankIdentificationNumber").toString()));
      }
      if ((jsonObj.get("BankName") != null && !jsonObj.get("BankName").isJsonNull()) && !jsonObj.get("BankName").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `BankName` to be a primitive type in the JSON string but got `%s`", jsonObj.get("BankName").toString()));
      }
      if ((jsonObj.get("BankPostalCode") != null && !jsonObj.get("BankPostalCode").isJsonNull()) && !jsonObj.get("BankPostalCode").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `BankPostalCode` to be a primitive type in the JSON string but got `%s`", jsonObj.get("BankPostalCode").toString()));
      }
      if ((jsonObj.get("BankStreetName") != null && !jsonObj.get("BankStreetName").isJsonNull()) && !jsonObj.get("BankStreetName").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `BankStreetName` to be a primitive type in the JSON string but got `%s`", jsonObj.get("BankStreetName").toString()));
      }
      if ((jsonObj.get("BankStreetNumber") != null && !jsonObj.get("BankStreetNumber").isJsonNull()) && !jsonObj.get("BankStreetNumber").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `BankStreetNumber` to be a primitive type in the JSON string but got `%s`", jsonObj.get("BankStreetNumber").toString()));
      }
      if ((jsonObj.get("BankTransferAccountName") != null && !jsonObj.get("BankTransferAccountName").isJsonNull()) && !jsonObj.get("BankTransferAccountName").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `BankTransferAccountName` to be a primitive type in the JSON string but got `%s`", jsonObj.get("BankTransferAccountName").toString()));
      }
      if ((jsonObj.get("BankTransferAccountNumberMask") != null && !jsonObj.get("BankTransferAccountNumberMask").isJsonNull()) && !jsonObj.get("BankTransferAccountNumberMask").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `BankTransferAccountNumberMask` to be a primitive type in the JSON string but got `%s`", jsonObj.get("BankTransferAccountNumberMask").toString()));
      }
      if ((jsonObj.get("BankTransferAccountType") != null && !jsonObj.get("BankTransferAccountType").isJsonNull()) && !jsonObj.get("BankTransferAccountType").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `BankTransferAccountType` to be a primitive type in the JSON string but got `%s`", jsonObj.get("BankTransferAccountType").toString()));
      }
      if ((jsonObj.get("BankTransferType") != null && !jsonObj.get("BankTransferType").isJsonNull()) && !jsonObj.get("BankTransferType").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `BankTransferType` to be a primitive type in the JSON string but got `%s`", jsonObj.get("BankTransferType").toString()));
      }
      if ((jsonObj.get("BusinessIdentificationCode") != null && !jsonObj.get("BusinessIdentificationCode").isJsonNull()) && !jsonObj.get("BusinessIdentificationCode").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `BusinessIdentificationCode` to be a primitive type in the JSON string but got `%s`", jsonObj.get("BusinessIdentificationCode").toString()));
      }
      if ((jsonObj.get("City") != null && !jsonObj.get("City").isJsonNull()) && !jsonObj.get("City").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `City` to be a primitive type in the JSON string but got `%s`", jsonObj.get("City").toString()));
      }
      if ((jsonObj.get("CompanyName") != null && !jsonObj.get("CompanyName").isJsonNull()) && !jsonObj.get("CompanyName").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `CompanyName` to be a primitive type in the JSON string but got `%s`", jsonObj.get("CompanyName").toString()));
      }
      if ((jsonObj.get("Country") != null && !jsonObj.get("Country").isJsonNull()) && !jsonObj.get("Country").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `Country` to be a primitive type in the JSON string but got `%s`", jsonObj.get("Country").toString()));
      }
      if ((jsonObj.get("CreditCardAddress1") != null && !jsonObj.get("CreditCardAddress1").isJsonNull()) && !jsonObj.get("CreditCardAddress1").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `CreditCardAddress1` to be a primitive type in the JSON string but got `%s`", jsonObj.get("CreditCardAddress1").toString()));
      }
      if ((jsonObj.get("CreditCardAddress2") != null && !jsonObj.get("CreditCardAddress2").isJsonNull()) && !jsonObj.get("CreditCardAddress2").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `CreditCardAddress2` to be a primitive type in the JSON string but got `%s`", jsonObj.get("CreditCardAddress2").toString()));
      }
      if ((jsonObj.get("CreditCardCity") != null && !jsonObj.get("CreditCardCity").isJsonNull()) && !jsonObj.get("CreditCardCity").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `CreditCardCity` to be a primitive type in the JSON string but got `%s`", jsonObj.get("CreditCardCity").toString()));
      }
      if ((jsonObj.get("CreditCardCountry") != null && !jsonObj.get("CreditCardCountry").isJsonNull()) && !jsonObj.get("CreditCardCountry").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `CreditCardCountry` to be a primitive type in the JSON string but got `%s`", jsonObj.get("CreditCardCountry").toString()));
      }
      if ((jsonObj.get("CreditCardHolderName") != null && !jsonObj.get("CreditCardHolderName").isJsonNull()) && !jsonObj.get("CreditCardHolderName").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `CreditCardHolderName` to be a primitive type in the JSON string but got `%s`", jsonObj.get("CreditCardHolderName").toString()));
      }
      if ((jsonObj.get("CreditCardMaskNumber") != null && !jsonObj.get("CreditCardMaskNumber").isJsonNull()) && !jsonObj.get("CreditCardMaskNumber").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `CreditCardMaskNumber` to be a primitive type in the JSON string but got `%s`", jsonObj.get("CreditCardMaskNumber").toString()));
      }
      if ((jsonObj.get("CreditCardPostalCode") != null && !jsonObj.get("CreditCardPostalCode").isJsonNull()) && !jsonObj.get("CreditCardPostalCode").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `CreditCardPostalCode` to be a primitive type in the JSON string but got `%s`", jsonObj.get("CreditCardPostalCode").toString()));
      }
      if ((jsonObj.get("CreditCardState") != null && !jsonObj.get("CreditCardState").isJsonNull()) && !jsonObj.get("CreditCardState").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `CreditCardState` to be a primitive type in the JSON string but got `%s`", jsonObj.get("CreditCardState").toString()));
      }
      if ((jsonObj.get("CreditCardType") != null && !jsonObj.get("CreditCardType").isJsonNull()) && !jsonObj.get("CreditCardType").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `CreditCardType` to be a primitive type in the JSON string but got `%s`", jsonObj.get("CreditCardType").toString()));
      }
      if ((jsonObj.get("DeviceSessionId") != null && !jsonObj.get("DeviceSessionId").isJsonNull()) && !jsonObj.get("DeviceSessionId").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `DeviceSessionId` to be a primitive type in the JSON string but got `%s`", jsonObj.get("DeviceSessionId").toString()));
      }
      if ((jsonObj.get("Email") != null && !jsonObj.get("Email").isJsonNull()) && !jsonObj.get("Email").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `Email` to be a primitive type in the JSON string but got `%s`", jsonObj.get("Email").toString()));
      }
      if ((jsonObj.get("ExistingMandate") != null && !jsonObj.get("ExistingMandate").isJsonNull()) && !jsonObj.get("ExistingMandate").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `ExistingMandate` to be a primitive type in the JSON string but got `%s`", jsonObj.get("ExistingMandate").toString()));
      }
      if ((jsonObj.get("FirstName") != null && !jsonObj.get("FirstName").isJsonNull()) && !jsonObj.get("FirstName").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `FirstName` to be a primitive type in the JSON string but got `%s`", jsonObj.get("FirstName").toString()));
      }
      if ((jsonObj.get("IBAN") != null && !jsonObj.get("IBAN").isJsonNull()) && !jsonObj.get("IBAN").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `IBAN` to be a primitive type in the JSON string but got `%s`", jsonObj.get("IBAN").toString()));
      }
      if ((jsonObj.get("IPAddress") != null && !jsonObj.get("IPAddress").isJsonNull()) && !jsonObj.get("IPAddress").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `IPAddress` to be a primitive type in the JSON string but got `%s`", jsonObj.get("IPAddress").toString()));
      }
      if ((jsonObj.get("Id") != null && !jsonObj.get("Id").isJsonNull()) && !jsonObj.get("Id").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `Id` to be a primitive type in the JSON string but got `%s`", jsonObj.get("Id").toString()));
      }
      if ((jsonObj.get("IdentityNumber") != null && !jsonObj.get("IdentityNumber").isJsonNull()) && !jsonObj.get("IdentityNumber").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `IdentityNumber` to be a primitive type in the JSON string but got `%s`", jsonObj.get("IdentityNumber").toString()));
      }
      if ((jsonObj.get("LastName") != null && !jsonObj.get("LastName").isJsonNull()) && !jsonObj.get("LastName").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `LastName` to be a primitive type in the JSON string but got `%s`", jsonObj.get("LastName").toString()));
      }
      if ((jsonObj.get("LastTransactionStatus") != null && !jsonObj.get("LastTransactionStatus").isJsonNull()) && !jsonObj.get("LastTransactionStatus").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `LastTransactionStatus` to be a primitive type in the JSON string but got `%s`", jsonObj.get("LastTransactionStatus").toString()));
      }
      if ((jsonObj.get("MandateID") != null && !jsonObj.get("MandateID").isJsonNull()) && !jsonObj.get("MandateID").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `MandateID` to be a primitive type in the JSON string but got `%s`", jsonObj.get("MandateID").toString()));
      }
      if ((jsonObj.get("MandateReceived") != null && !jsonObj.get("MandateReceived").isJsonNull()) && !jsonObj.get("MandateReceived").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `MandateReceived` to be a primitive type in the JSON string but got `%s`", jsonObj.get("MandateReceived").toString()));
      }
      if ((jsonObj.get("Name") != null && !jsonObj.get("Name").isJsonNull()) && !jsonObj.get("Name").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `Name` to be a primitive type in the JSON string but got `%s`", jsonObj.get("Name").toString()));
      }
      if ((jsonObj.get("PaymentMethodId") != null && !jsonObj.get("PaymentMethodId").isJsonNull()) && !jsonObj.get("PaymentMethodId").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `PaymentMethodId` to be a primitive type in the JSON string but got `%s`", jsonObj.get("PaymentMethodId").toString()));
      }
      if ((jsonObj.get("PaymentMethodStatus") != null && !jsonObj.get("PaymentMethodStatus").isJsonNull()) && !jsonObj.get("PaymentMethodStatus").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `PaymentMethodStatus` to be a primitive type in the JSON string but got `%s`", jsonObj.get("PaymentMethodStatus").toString()));
      }
      if ((jsonObj.get("PaypalBaid") != null && !jsonObj.get("PaypalBaid").isJsonNull()) && !jsonObj.get("PaypalBaid").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `PaypalBaid` to be a primitive type in the JSON string but got `%s`", jsonObj.get("PaypalBaid").toString()));
      }
      if ((jsonObj.get("PaypalEmail") != null && !jsonObj.get("PaypalEmail").isJsonNull()) && !jsonObj.get("PaypalEmail").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `PaypalEmail` to be a primitive type in the JSON string but got `%s`", jsonObj.get("PaypalEmail").toString()));
      }
      if ((jsonObj.get("PaypalPreapprovalKey") != null && !jsonObj.get("PaypalPreapprovalKey").isJsonNull()) && !jsonObj.get("PaypalPreapprovalKey").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `PaypalPreapprovalKey` to be a primitive type in the JSON string but got `%s`", jsonObj.get("PaypalPreapprovalKey").toString()));
      }
      if ((jsonObj.get("PaypalType") != null && !jsonObj.get("PaypalType").isJsonNull()) && !jsonObj.get("PaypalType").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `PaypalType` to be a primitive type in the JSON string but got `%s`", jsonObj.get("PaypalType").toString()));
      }
      if ((jsonObj.get("Phone") != null && !jsonObj.get("Phone").isJsonNull()) && !jsonObj.get("Phone").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `Phone` to be a primitive type in the JSON string but got `%s`", jsonObj.get("Phone").toString()));
      }
      if ((jsonObj.get("PostalCode") != null && !jsonObj.get("PostalCode").isJsonNull()) && !jsonObj.get("PostalCode").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `PostalCode` to be a primitive type in the JSON string but got `%s`", jsonObj.get("PostalCode").toString()));
      }
      if ((jsonObj.get("SecondTokenId") != null && !jsonObj.get("SecondTokenId").isJsonNull()) && !jsonObj.get("SecondTokenId").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `SecondTokenId` to be a primitive type in the JSON string but got `%s`", jsonObj.get("SecondTokenId").toString()));
      }
      if ((jsonObj.get("State") != null && !jsonObj.get("State").isJsonNull()) && !jsonObj.get("State").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `State` to be a primitive type in the JSON string but got `%s`", jsonObj.get("State").toString()));
      }
      if ((jsonObj.get("StreetName") != null && !jsonObj.get("StreetName").isJsonNull()) && !jsonObj.get("StreetName").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `StreetName` to be a primitive type in the JSON string but got `%s`", jsonObj.get("StreetName").toString()));
      }
      if ((jsonObj.get("StreetNumber") != null && !jsonObj.get("StreetNumber").isJsonNull()) && !jsonObj.get("StreetNumber").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `StreetNumber` to be a primitive type in the JSON string but got `%s`", jsonObj.get("StreetNumber").toString()));
      }
      if ((jsonObj.get("TokenId") != null && !jsonObj.get("TokenId").isJsonNull()) && !jsonObj.get("TokenId").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `TokenId` to be a primitive type in the JSON string but got `%s`", jsonObj.get("TokenId").toString()));
      }
      if ((jsonObj.get("Type") != null && !jsonObj.get("Type").isJsonNull()) && !jsonObj.get("Type").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `Type` to be a primitive type in the JSON string but got `%s`", jsonObj.get("Type").toString()));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!ProxyGetPaymentMethodSnapshot.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'ProxyGetPaymentMethodSnapshot' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<ProxyGetPaymentMethodSnapshot> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(ProxyGetPaymentMethodSnapshot.class));

       return (TypeAdapter<T>) new TypeAdapter<ProxyGetPaymentMethodSnapshot>() {
           @Override
           public void write(JsonWriter out, ProxyGetPaymentMethodSnapshot value) throws IOException {
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
           public ProxyGetPaymentMethodSnapshot read(JsonReader in) throws IOException {
             JsonObject jsonObj = elementAdapter.read(in).getAsJsonObject();
             validateJsonObject(jsonObj);
             // store additional fields in the deserialized instance
             ProxyGetPaymentMethodSnapshot instance = thisAdapter.fromJsonTree(jsonObj);
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
  * Create an instance of ProxyGetPaymentMethodSnapshot given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of ProxyGetPaymentMethodSnapshot
  * @throws IOException if the JSON string is invalid with respect to ProxyGetPaymentMethodSnapshot
  */
  public static ProxyGetPaymentMethodSnapshot fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, ProxyGetPaymentMethodSnapshot.class);
  }

 /**
  * Convert an instance of ProxyGetPaymentMethodSnapshot to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

