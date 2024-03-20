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
import java.time.OffsetDateTime;
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
 * ProxyGetProductRatePlanCharge
 */@javax.annotation.Generated(value = "Generated by https://konfigthis.com")
public class ProxyGetProductRatePlanCharge {
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
   * Specifies how to determine the billing day for the charge.                
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
   * The billing period for the charge. The start day of the billing period is also called the bill cycle day (BCD). 
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
   * Aligns charges within the same subscription if multiple charges begin on different dates. 
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
   * **Note**: This field is only available if you have the &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Bill_your_customers/Bill_for_usage_or_prepaid_products/Advanced_Consumption_Billing/Unbilled_Usage\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Unbilled Usage&lt;/a&gt; feature enabled.  To use this field, you must set the &#x60;X-Zuora-WSDL-Version&#x60; request header to &#x60;133&#x60; or higher. Otherwise, an error occurs.   This field defines the type of commitment. A prepaid charge can be &#x60;UNIT&#x60; or &#x60;CURRENCY&#x60;. A minimum commitment(in-arrears) charge can only be &#x60;CURRENCY&#x60; type. For topup(recurring or one-time) charges, this field indicates what type of funds are created.  * If UNIT, it will create a fund with given prepaidUom. * If CURRENCY, it will create a fund with the currency amount calculated in list price.    For drawdown(usage) charges, this field indicates what type of funds are drawdown from that created from topup charges. 
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
   * Determines how to calculate charges. Charge models must be individually activated in Zuora Billing administration. 
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

  public static final String SERIALIZED_NAME_CREATED_BY_ID = "CreatedById";
  @SerializedName(SERIALIZED_NAME_CREATED_BY_ID)
  private String createdById;

  public static final String SERIALIZED_NAME_CREATED_DATE = "CreatedDate";
  @SerializedName(SERIALIZED_NAME_CREATED_DATE)
  private OffsetDateTime createdDate;

  public static final String SERIALIZED_NAME_DEFAULT_QUANTITY = "DefaultQuantity";
  @SerializedName(SERIALIZED_NAME_DEFAULT_QUANTITY)
  private Double defaultQuantity;

  public static final String SERIALIZED_NAME_DEFERRED_REVENUE_ACCOUNT = "DeferredRevenueAccount";
  @SerializedName(SERIALIZED_NAME_DEFERRED_REVENUE_ACCOUNT)
  private String deferredRevenueAccount;

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

  /**
   * Defines when the charge ends after the charge trigger date.  **Values**:    - &#x60;SubscriptionEnd&#x60;: The charge ends on the subscription end date after a specified period based on the trigger date of the charge.    - &#x60;FixedPeriod&#x60;: The charge ends after a specified period based on the trigger date of the charge. If you set this field to &#x60;FixedPeriod&#x60;, you must specify the length of the period and a period type by defining the &#x60;UpToPeriods&#x60; and &#x60;UpToPeriodsType&#x60; fields.     **Note**: If the subscription ends before the charge end date, the charge ends when the subscription ends. But if the subscription end date is subsequently changed through a Renewal, or Terms and Conditions amendment, the charge will end on the charge end date. 
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
  private Boolean excludeItemBillingFromRevenueAccounting;

  public static final String SERIALIZED_NAME_EXCLUDE_ITEM_BOOKING_FROM_REVENUE_ACCOUNTING = "ExcludeItemBookingFromRevenueAccounting";
  @SerializedName(SERIALIZED_NAME_EXCLUDE_ITEM_BOOKING_FROM_REVENUE_ACCOUNTING)
  private Boolean excludeItemBookingFromRevenueAccounting;

  public static final String SERIALIZED_NAME_ID = "Id";
  @SerializedName(SERIALIZED_NAME_ID)
  private String id;

  public static final String SERIALIZED_NAME_INCLUDED_UNITS = "IncludedUnits";
  @SerializedName(SERIALIZED_NAME_INCLUDED_UNITS)
  private Double includedUnits;

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
    
    PERBILLINGPERIOD("PerBillingPeriod"),
    
    NULL("null");

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
      return null;
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
   * Applies an automatic price change when a termed subscription is renewed. 
   */
  @JsonAdapter(PriceChangeOptionEnum.Adapter.class)
 public enum PriceChangeOptionEnum {
    NOCHANGE("NoChange"),
    
    SPECIFICPERCENTAGEVALUE("SpecificPercentageValue"),
    
    USELATESTPRODUCTCATALOGPRICING("UseLatestProductCatalogPricing"),
    
    NULL("null");

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
      return null;
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

  public static final String SERIALIZED_NAME_PRICE_INCREASE_PERCENTAGE = "PriceIncreasePercentage";
  @SerializedName(SERIALIZED_NAME_PRICE_INCREASE_PERCENTAGE)
  private Double priceIncreasePercentage;

  public static final String SERIALIZED_NAME_PRODUCT_RATE_PLAN_ID = "ProductRatePlanId";
  @SerializedName(SERIALIZED_NAME_PRODUCT_RATE_PLAN_ID)
  private String productRatePlanId;

  /**
   * A rating group based on which usage records are rated. Only applicable to Usage charges.  Possible values:   - &#x60;ByBillingPeriod&#x60;: The rating is based on all the usages in a billing period.   - &#x60;ByUsageStartDate&#x60;: The rating is based on all the usages on the same usage start date.    - &#x60;ByUsageRecord&#x60;: The rating is based on each usage record.   - &#x60;ByUsageUpload&#x60;: The rating is based on all the  usages in a uploaded usage file (&#x60;.xls&#x60; or &#x60;.csv&#x60;).   - &#x60;ByGroupId&#x60;: The rating is based on all the usages in a custom group.  For more information, see [Usage rating by group](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/J_Billing_Operations/Usage/Usage_Rating_by_Group). 
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
  private RatingGroupEnum ratingGroup;

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

  public static final String SERIALIZED_NAME_UPDATED_BY_ID = "UpdatedById";
  @SerializedName(SERIALIZED_NAME_UPDATED_BY_ID)
  private String updatedById;

  public static final String SERIALIZED_NAME_UPDATED_DATE = "UpdatedDate";
  @SerializedName(SERIALIZED_NAME_UPDATED_DATE)
  private OffsetDateTime updatedDate;

  public static final String SERIALIZED_NAME_USE_DISCOUNT_SPECIFIC_ACCOUNTING_CODE = "UseDiscountSpecificAccountingCode";
  @SerializedName(SERIALIZED_NAME_USE_DISCOUNT_SPECIFIC_ACCOUNTING_CODE)
  private Boolean useDiscountSpecificAccountingCode;

  public static final String SERIALIZED_NAME_USE_TENANT_DEFAULT_FOR_PRICE_CHANGE = "UseTenantDefaultForPriceChange";
  @SerializedName(SERIALIZED_NAME_USE_TENANT_DEFAULT_FOR_PRICE_CHANGE)
  private Boolean useTenantDefaultForPriceChange;

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

  public static final String SERIALIZED_NAME_IS_ALLOCATION_ELIGIBLE = "IsAllocationEligible";
  @SerializedName(SERIALIZED_NAME_IS_ALLOCATION_ELIGIBLE)
  private Boolean isAllocationEligible;

  public static final String SERIALIZED_NAME_IS_UNBILLED = "IsUnbilled";
  @SerializedName(SERIALIZED_NAME_IS_UNBILLED)
  private Boolean isUnbilled;

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

  public static final String SERIALIZED_NAME_APPLY_TO_BILLING_PERIOD_PARTIALLY = "ApplyToBillingPeriodPartially";
  @SerializedName(SERIALIZED_NAME_APPLY_TO_BILLING_PERIOD_PARTIALLY)
  private Boolean applyToBillingPeriodPartially;

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

  public ProxyGetProductRatePlanCharge() {
  }

  public ProxyGetProductRatePlanCharge accountingCode(String accountingCode) {
    
    
    
    
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


  public ProxyGetProductRatePlanCharge applyDiscountTo(ApplyDiscountToEnum applyDiscountTo) {
    
    
    
    
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


  public ProxyGetProductRatePlanCharge billCycleDay(Integer billCycleDay) {
    
    
    
    
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


  public ProxyGetProductRatePlanCharge billCycleType(BillCycleTypeEnum billCycleType) {
    
    
    
    
    this.billCycleType = billCycleType;
    return this;
  }

   /**
   * Specifies how to determine the billing day for the charge.                
   * @return billCycleType
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Specifies how to determine the billing day for the charge.                ")

  public BillCycleTypeEnum getBillCycleType() {
    return billCycleType;
  }


  public void setBillCycleType(BillCycleTypeEnum billCycleType) {
    
    
    
    this.billCycleType = billCycleType;
  }


  public ProxyGetProductRatePlanCharge billingPeriod(BillingPeriodEnum billingPeriod) {
    
    
    
    
    this.billingPeriod = billingPeriod;
    return this;
  }

   /**
   * The billing period for the charge. The start day of the billing period is also called the bill cycle day (BCD). 
   * @return billingPeriod
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The billing period for the charge. The start day of the billing period is also called the bill cycle day (BCD). ")

  public BillingPeriodEnum getBillingPeriod() {
    return billingPeriod;
  }


  public void setBillingPeriod(BillingPeriodEnum billingPeriod) {
    
    
    
    this.billingPeriod = billingPeriod;
  }


  public ProxyGetProductRatePlanCharge billingPeriodAlignment(BillingPeriodAlignmentEnum billingPeriodAlignment) {
    
    
    
    
    this.billingPeriodAlignment = billingPeriodAlignment;
    return this;
  }

   /**
   * Aligns charges within the same subscription if multiple charges begin on different dates. 
   * @return billingPeriodAlignment
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Aligns charges within the same subscription if multiple charges begin on different dates. ")

  public BillingPeriodAlignmentEnum getBillingPeriodAlignment() {
    return billingPeriodAlignment;
  }


  public void setBillingPeriodAlignment(BillingPeriodAlignmentEnum billingPeriodAlignment) {
    
    
    
    this.billingPeriodAlignment = billingPeriodAlignment;
  }


  public ProxyGetProductRatePlanCharge billingTiming(BillingTimingEnum billingTiming) {
    
    
    
    
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


  public ProxyGetProductRatePlanCharge chargeFunction(ChargeFunctionEnum chargeFunction) {
    
    
    
    
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


  public ProxyGetProductRatePlanCharge commitmentType(CommitmentTypeEnum commitmentType) {
    
    
    
    
    this.commitmentType = commitmentType;
    return this;
  }

   /**
   * **Note**: This field is only available if you have the &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Bill_your_customers/Bill_for_usage_or_prepaid_products/Advanced_Consumption_Billing/Unbilled_Usage\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Unbilled Usage&lt;/a&gt; feature enabled.  To use this field, you must set the &#x60;X-Zuora-WSDL-Version&#x60; request header to &#x60;133&#x60; or higher. Otherwise, an error occurs.   This field defines the type of commitment. A prepaid charge can be &#x60;UNIT&#x60; or &#x60;CURRENCY&#x60;. A minimum commitment(in-arrears) charge can only be &#x60;CURRENCY&#x60; type. For topup(recurring or one-time) charges, this field indicates what type of funds are created.  * If UNIT, it will create a fund with given prepaidUom. * If CURRENCY, it will create a fund with the currency amount calculated in list price.    For drawdown(usage) charges, this field indicates what type of funds are drawdown from that created from topup charges. 
   * @return commitmentType
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "**Note**: This field is only available if you have the <a href=\"https://knowledgecenter.zuora.com/Zuora_Billing/Bill_your_customers/Bill_for_usage_or_prepaid_products/Advanced_Consumption_Billing/Unbilled_Usage\" target=\"_blank\">Unbilled Usage</a> feature enabled.  To use this field, you must set the `X-Zuora-WSDL-Version` request header to `133` or higher. Otherwise, an error occurs.   This field defines the type of commitment. A prepaid charge can be `UNIT` or `CURRENCY`. A minimum commitment(in-arrears) charge can only be `CURRENCY` type. For topup(recurring or one-time) charges, this field indicates what type of funds are created.  * If UNIT, it will create a fund with given prepaidUom. * If CURRENCY, it will create a fund with the currency amount calculated in list price.    For drawdown(usage) charges, this field indicates what type of funds are drawdown from that created from topup charges. ")

  public CommitmentTypeEnum getCommitmentType() {
    return commitmentType;
  }


  public void setCommitmentType(CommitmentTypeEnum commitmentType) {
    
    
    
    this.commitmentType = commitmentType;
  }


  public ProxyGetProductRatePlanCharge chargeModel(ChargeModelEnum chargeModel) {
    
    
    
    
    this.chargeModel = chargeModel;
    return this;
  }

   /**
   * Determines how to calculate charges. Charge models must be individually activated in Zuora Billing administration. 
   * @return chargeModel
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Determines how to calculate charges. Charge models must be individually activated in Zuora Billing administration. ")

  public ChargeModelEnum getChargeModel() {
    return chargeModel;
  }


  public void setChargeModel(ChargeModelEnum chargeModel) {
    
    
    
    this.chargeModel = chargeModel;
  }


  public ProxyGetProductRatePlanCharge chargeType(ChargeTypeEnum chargeType) {
    
    
    
    
    this.chargeType = chargeType;
    return this;
  }

   /**
   * Specifies the type of charge. 
   * @return chargeType
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Specifies the type of charge. ")

  public ChargeTypeEnum getChargeType() {
    return chargeType;
  }


  public void setChargeType(ChargeTypeEnum chargeType) {
    
    
    
    this.chargeType = chargeType;
  }


  public ProxyGetProductRatePlanCharge createdById(String createdById) {
    
    
    
    
    this.createdById = createdById;
    return this;
  }

   /**
   * The automatically generated ID of the Zuora user who created the &#x60;ProductRatePlanCharge&#x60; object. 
   * @return createdById
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The automatically generated ID of the Zuora user who created the `ProductRatePlanCharge` object. ")

  public String getCreatedById() {
    return createdById;
  }


  public void setCreatedById(String createdById) {
    
    
    
    this.createdById = createdById;
  }


  public ProxyGetProductRatePlanCharge createdDate(OffsetDateTime createdDate) {
    
    
    
    
    this.createdDate = createdDate;
    return this;
  }

   /**
   * The date when the &#x60;ProductRatePlanCharge&#x60; object was created. 
   * @return createdDate
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The date when the `ProductRatePlanCharge` object was created. ")

  public OffsetDateTime getCreatedDate() {
    return createdDate;
  }


  public void setCreatedDate(OffsetDateTime createdDate) {
    
    
    
    this.createdDate = createdDate;
  }


  public ProxyGetProductRatePlanCharge defaultQuantity(Double defaultQuantity) {
    
    
    
    
    this.defaultQuantity = defaultQuantity;
    return this;
  }

   /**
   * The default quantity of units, such as the number of authors in a hosted wiki service. This field is required if you use a per-unit pricing model.  **Character limit**: 16  **Values**: a valid quantity value.  **Note**: When &#x60;ChargeModel&#x60; is &#x60;Tiered Pricing&#x60; or &#x60;Volume Pricing&#x60;, if this field is not specified, the value will default to &#x60;0&#x60;. 
   * @return defaultQuantity
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The default quantity of units, such as the number of authors in a hosted wiki service. This field is required if you use a per-unit pricing model.  **Character limit**: 16  **Values**: a valid quantity value.  **Note**: When `ChargeModel` is `Tiered Pricing` or `Volume Pricing`, if this field is not specified, the value will default to `0`. ")

  public Double getDefaultQuantity() {
    return defaultQuantity;
  }


  public void setDefaultQuantity(Double defaultQuantity) {
    
    
    
    this.defaultQuantity = defaultQuantity;
  }


  public ProxyGetProductRatePlanCharge deferredRevenueAccount(String deferredRevenueAccount) {
    
    
    
    
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


  public ProxyGetProductRatePlanCharge description(String description) {
    
    
    
    
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


  public ProxyGetProductRatePlanCharge discountLevel(DiscountLevelEnum discountLevel) {
    
    
    
    
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


  public ProxyGetProductRatePlanCharge endDateCondition(EndDateConditionEnum endDateCondition) {
    
    
    
    
    this.endDateCondition = endDateCondition;
    return this;
  }

   /**
   * Defines when the charge ends after the charge trigger date.  **Values**:    - &#x60;SubscriptionEnd&#x60;: The charge ends on the subscription end date after a specified period based on the trigger date of the charge.    - &#x60;FixedPeriod&#x60;: The charge ends after a specified period based on the trigger date of the charge. If you set this field to &#x60;FixedPeriod&#x60;, you must specify the length of the period and a period type by defining the &#x60;UpToPeriods&#x60; and &#x60;UpToPeriodsType&#x60; fields.     **Note**: If the subscription ends before the charge end date, the charge ends when the subscription ends. But if the subscription end date is subsequently changed through a Renewal, or Terms and Conditions amendment, the charge will end on the charge end date. 
   * @return endDateCondition
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "SUBSCRIPTIONEND", value = "Defines when the charge ends after the charge trigger date.  **Values**:    - `SubscriptionEnd`: The charge ends on the subscription end date after a specified period based on the trigger date of the charge.    - `FixedPeriod`: The charge ends after a specified period based on the trigger date of the charge. If you set this field to `FixedPeriod`, you must specify the length of the period and a period type by defining the `UpToPeriods` and `UpToPeriodsType` fields.     **Note**: If the subscription ends before the charge end date, the charge ends when the subscription ends. But if the subscription end date is subsequently changed through a Renewal, or Terms and Conditions amendment, the charge will end on the charge end date. ")

  public EndDateConditionEnum getEndDateCondition() {
    return endDateCondition;
  }


  public void setEndDateCondition(EndDateConditionEnum endDateCondition) {
    
    
    
    this.endDateCondition = endDateCondition;
  }


  public ProxyGetProductRatePlanCharge excludeItemBillingFromRevenueAccounting(Boolean excludeItemBillingFromRevenueAccounting) {
    
    
    
    
    this.excludeItemBillingFromRevenueAccounting = excludeItemBillingFromRevenueAccounting;
    return this;
  }

   /**
   * The flag to exclude the related invoice items, invoice item adjustments, credit memo items, and debit memo items from revenue accounting.  **Notes**:    - To use this field, you must set the &#x60;X-Zuora-WSDL-Version&#x60; request header to &#x60;115&#x60; or later. Otherwise, an error occurs.   - This field is only available if you have the Order to Revenue or Billing - Revenue Integration feature enabled.  
   * @return excludeItemBillingFromRevenueAccounting
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The flag to exclude the related invoice items, invoice item adjustments, credit memo items, and debit memo items from revenue accounting.  **Notes**:    - To use this field, you must set the `X-Zuora-WSDL-Version` request header to `115` or later. Otherwise, an error occurs.   - This field is only available if you have the Order to Revenue or Billing - Revenue Integration feature enabled.  ")

  public Boolean getExcludeItemBillingFromRevenueAccounting() {
    return excludeItemBillingFromRevenueAccounting;
  }


  public void setExcludeItemBillingFromRevenueAccounting(Boolean excludeItemBillingFromRevenueAccounting) {
    
    
    
    this.excludeItemBillingFromRevenueAccounting = excludeItemBillingFromRevenueAccounting;
  }


  public ProxyGetProductRatePlanCharge excludeItemBookingFromRevenueAccounting(Boolean excludeItemBookingFromRevenueAccounting) {
    
    
    
    
    this.excludeItemBookingFromRevenueAccounting = excludeItemBookingFromRevenueAccounting;
    return this;
  }

   /**
   * The flag to exclude the related rate plan charges and order line items from revenue accounting.  **Notes**:    - To use this field, you must set the &#x60;X-Zuora-WSDL-Version&#x60; request header to &#x60;115&#x60; or later. Otherwise, an error occurs.   - This field is only available if you have the Order to Revenue or Billing - Revenue Integration feature enabled.  
   * @return excludeItemBookingFromRevenueAccounting
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The flag to exclude the related rate plan charges and order line items from revenue accounting.  **Notes**:    - To use this field, you must set the `X-Zuora-WSDL-Version` request header to `115` or later. Otherwise, an error occurs.   - This field is only available if you have the Order to Revenue or Billing - Revenue Integration feature enabled.  ")

  public Boolean getExcludeItemBookingFromRevenueAccounting() {
    return excludeItemBookingFromRevenueAccounting;
  }


  public void setExcludeItemBookingFromRevenueAccounting(Boolean excludeItemBookingFromRevenueAccounting) {
    
    
    
    this.excludeItemBookingFromRevenueAccounting = excludeItemBookingFromRevenueAccounting;
  }


  public ProxyGetProductRatePlanCharge id(String id) {
    
    
    
    
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


  public ProxyGetProductRatePlanCharge includedUnits(Double includedUnits) {
    
    
    
    
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


  public ProxyGetProductRatePlanCharge legacyRevenueReporting(Boolean legacyRevenueReporting) {
    
    
    
    
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


  public ProxyGetProductRatePlanCharge listPriceBase(ListPriceBaseEnum listPriceBase) {
    
    
    
    
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


  public ProxyGetProductRatePlanCharge maxQuantity(Double maxQuantity) {
    
    
    
    
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


  public ProxyGetProductRatePlanCharge minQuantity(Double minQuantity) {
    
    
    
    
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


  public ProxyGetProductRatePlanCharge name(String name) {
    
    
    
    
    this.name = name;
    return this;
  }

   /**
   * The name of the product rate plan charge. 
   * @return name
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The name of the product rate plan charge. ")

  public String getName() {
    return name;
  }


  public void setName(String name) {
    
    
    
    this.name = name;
  }


  public ProxyGetProductRatePlanCharge numberOfPeriod(Long numberOfPeriod) {
    
    
    
    
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


  public ProxyGetProductRatePlanCharge overageCalculationOption(OverageCalculationOptionEnum overageCalculationOption) {
    
    
    
    
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


  public ProxyGetProductRatePlanCharge overageUnusedUnitsCreditOption(OverageUnusedUnitsCreditOptionEnum overageUnusedUnitsCreditOption) {
    
    
    
    
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


  public ProxyGetProductRatePlanCharge priceChangeOption(PriceChangeOptionEnum priceChangeOption) {
    
    
    
    
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


  public ProxyGetProductRatePlanCharge priceIncreasePercentage(Double priceIncreasePercentage) {
    
    
    
    
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


  public ProxyGetProductRatePlanCharge productRatePlanId(String productRatePlanId) {
    
    
    
    
    this.productRatePlanId = productRatePlanId;
    return this;
  }

   /**
   * The ID of the product rate plan associated with this product rate plan charge. 
   * @return productRatePlanId
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The ID of the product rate plan associated with this product rate plan charge. ")

  public String getProductRatePlanId() {
    return productRatePlanId;
  }


  public void setProductRatePlanId(String productRatePlanId) {
    
    
    
    this.productRatePlanId = productRatePlanId;
  }


  public ProxyGetProductRatePlanCharge ratingGroup(RatingGroupEnum ratingGroup) {
    
    
    
    
    this.ratingGroup = ratingGroup;
    return this;
  }

   /**
   * A rating group based on which usage records are rated. Only applicable to Usage charges.  Possible values:   - &#x60;ByBillingPeriod&#x60;: The rating is based on all the usages in a billing period.   - &#x60;ByUsageStartDate&#x60;: The rating is based on all the usages on the same usage start date.    - &#x60;ByUsageRecord&#x60;: The rating is based on each usage record.   - &#x60;ByUsageUpload&#x60;: The rating is based on all the  usages in a uploaded usage file (&#x60;.xls&#x60; or &#x60;.csv&#x60;).   - &#x60;ByGroupId&#x60;: The rating is based on all the usages in a custom group.  For more information, see [Usage rating by group](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/J_Billing_Operations/Usage/Usage_Rating_by_Group). 
   * @return ratingGroup
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "A rating group based on which usage records are rated. Only applicable to Usage charges.  Possible values:   - `ByBillingPeriod`: The rating is based on all the usages in a billing period.   - `ByUsageStartDate`: The rating is based on all the usages on the same usage start date.    - `ByUsageRecord`: The rating is based on each usage record.   - `ByUsageUpload`: The rating is based on all the  usages in a uploaded usage file (`.xls` or `.csv`).   - `ByGroupId`: The rating is based on all the usages in a custom group.  For more information, see [Usage rating by group](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/J_Billing_Operations/Usage/Usage_Rating_by_Group). ")

  public RatingGroupEnum getRatingGroup() {
    return ratingGroup;
  }


  public void setRatingGroup(RatingGroupEnum ratingGroup) {
    
    
    
    this.ratingGroup = ratingGroup;
  }


  public ProxyGetProductRatePlanCharge recognizedRevenueAccount(String recognizedRevenueAccount) {
    
    
    
    
    this.recognizedRevenueAccount = recognizedRevenueAccount;
    return this;
  }

   /**
   * The name of the recognized revenue account for this charge.   - Required when the Allow Blank Accounting Code setting is No.   - Optional when the Allow Blank Accounting Code setting is Yes.  This feature is in **Limited Availability**. If you wish to have access to the feature, submit a request at [Zuora Global Support](http://support.zuora.com/).  
   * @return recognizedRevenueAccount
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The name of the recognized revenue account for this charge.   - Required when the Allow Blank Accounting Code setting is No.   - Optional when the Allow Blank Accounting Code setting is Yes.  This feature is in **Limited Availability**. If you wish to have access to the feature, submit a request at [Zuora Global Support](http://support.zuora.com/).  ")

  public String getRecognizedRevenueAccount() {
    return recognizedRevenueAccount;
  }


  public void setRecognizedRevenueAccount(String recognizedRevenueAccount) {
    
    
    
    this.recognizedRevenueAccount = recognizedRevenueAccount;
  }


  public ProxyGetProductRatePlanCharge revRecCode(String revRecCode) {
    
    
    
    
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


  public ProxyGetProductRatePlanCharge revRecTriggerCondition(RevRecTriggerConditionEnum revRecTriggerCondition) {
    
    
    
    
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


  public ProxyGetProductRatePlanCharge revenueRecognitionRuleName(RevenueRecognitionRuleNameEnum revenueRecognitionRuleName) {
    
    
    
    
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


  public ProxyGetProductRatePlanCharge smoothingModel(SmoothingModelEnum smoothingModel) {
    
    
    
    
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


  public ProxyGetProductRatePlanCharge specificBillingPeriod(Long specificBillingPeriod) {
    
    
    
    
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


  public ProxyGetProductRatePlanCharge specificListPriceBase(Integer specificListPriceBase) {
    
    
    
    
    this.specificListPriceBase = specificListPriceBase;
    return this;
  }

   /**
   * The number of months for the list price base of the charge. The value of this field is &#x60;null&#x60; if you do not set the value of the &#x60;ListPriceBase&#x60; field to &#x60;Per Specific Months&#x60;.  **Notes**:    - This field is available only if you have the &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Billing/Subscriptions/Product_Catalog/I_Annual_List_Price\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Annual List Price&lt;/a&gt; feature enabled.   - To use this field, you must set the &#x60;X-Zuora-WSDL-Version&#x60; request header to &#x60;129&#x60; or later. Otherwise, an error occurs.   - The value of this field is &#x60;null&#x60; if you do not set the value of the &#x60;ListPriceBase&#x60; field to &#x60;Per Specific Months&#x60;. 
   * @return specificListPriceBase
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The number of months for the list price base of the charge. The value of this field is `null` if you do not set the value of the `ListPriceBase` field to `Per Specific Months`.  **Notes**:    - This field is available only if you have the <a href=\"https://knowledgecenter.zuora.com/Billing/Subscriptions/Product_Catalog/I_Annual_List_Price\" target=\"_blank\">Annual List Price</a> feature enabled.   - To use this field, you must set the `X-Zuora-WSDL-Version` request header to `129` or later. Otherwise, an error occurs.   - The value of this field is `null` if you do not set the value of the `ListPriceBase` field to `Per Specific Months`. ")

  public Integer getSpecificListPriceBase() {
    return specificListPriceBase;
  }


  public void setSpecificListPriceBase(Integer specificListPriceBase) {
    
    
    
    this.specificListPriceBase = specificListPriceBase;
  }


  public ProxyGetProductRatePlanCharge taxCode(String taxCode) {
    
    
    
    
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


  public ProxyGetProductRatePlanCharge taxMode(TaxModeEnum taxMode) {
    
    
    
    
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


  public ProxyGetProductRatePlanCharge taxable(Boolean taxable) {
    
    
    
    
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


  public ProxyGetProductRatePlanCharge triggerEvent(TriggerEventEnum triggerEvent) {
    
    
    
    
    this.triggerEvent = triggerEvent;
    return this;
  }

   /**
   * Specifies when to start billing the customer for the charge.  **Values**:   - &#x60;ContractEffective&#x60; is the date when the subscription&#39;s contract goes into effect and the charge is ready to be billed.   - &#x60;ServiceActivation&#x60; is the date when the services or products for a subscription have been activated and the customers have access.   - &#x60;CustomerAcceptance&#x60; is when the customer accepts the services or products for a subscription. 
   * @return triggerEvent
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Specifies when to start billing the customer for the charge.  **Values**:   - `ContractEffective` is the date when the subscription's contract goes into effect and the charge is ready to be billed.   - `ServiceActivation` is the date when the services or products for a subscription have been activated and the customers have access.   - `CustomerAcceptance` is when the customer accepts the services or products for a subscription. ")

  public TriggerEventEnum getTriggerEvent() {
    return triggerEvent;
  }


  public void setTriggerEvent(TriggerEventEnum triggerEvent) {
    
    
    
    this.triggerEvent = triggerEvent;
  }


  public ProxyGetProductRatePlanCharge UOM(String UOM) {
    
    
    
    
    this.UOM = UOM;
    return this;
  }

   /**
   * Specifies the units to measure usage.   **Note**: You must specify this field when creating the following charge models:   - Per Unit Pricing   - Volume Pricin   - Overage Pricing   - Tiered Pricing   - Tiered with Overage Pricing 
   * @return UOM
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Specifies the units to measure usage.   **Note**: You must specify this field when creating the following charge models:   - Per Unit Pricing   - Volume Pricin   - Overage Pricing   - Tiered Pricing   - Tiered with Overage Pricing ")

  public String getUOM() {
    return UOM;
  }


  public void setUOM(String UOM) {
    
    
    
    this.UOM = UOM;
  }


  public ProxyGetProductRatePlanCharge upToPeriods(Long upToPeriods) {
    
    
    
    
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


  public ProxyGetProductRatePlanCharge upToPeriodsType(UpToPeriodsTypeEnum upToPeriodsType) {
    
    
    
    
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


  public ProxyGetProductRatePlanCharge updatedById(String updatedById) {
    
    
    
    
    this.updatedById = updatedById;
    return this;
  }

   /**
   * The ID of the last user to update the object. 
   * @return updatedById
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The ID of the last user to update the object. ")

  public String getUpdatedById() {
    return updatedById;
  }


  public void setUpdatedById(String updatedById) {
    
    
    
    this.updatedById = updatedById;
  }


  public ProxyGetProductRatePlanCharge updatedDate(OffsetDateTime updatedDate) {
    
    
    
    
    this.updatedDate = updatedDate;
    return this;
  }

   /**
   * The date when the object was last updated. 
   * @return updatedDate
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The date when the object was last updated. ")

  public OffsetDateTime getUpdatedDate() {
    return updatedDate;
  }


  public void setUpdatedDate(OffsetDateTime updatedDate) {
    
    
    
    this.updatedDate = updatedDate;
  }


  public ProxyGetProductRatePlanCharge useDiscountSpecificAccountingCode(Boolean useDiscountSpecificAccountingCode) {
    
    
    
    
    this.useDiscountSpecificAccountingCode = useDiscountSpecificAccountingCode;
    return this;
  }

   /**
   * Determines whether to define a new accounting code for the new discount charge.  **Character limit**: 5  **Values**: &#x60;True&#x60;, &#x60;False&#x60; 
   * @return useDiscountSpecificAccountingCode
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Determines whether to define a new accounting code for the new discount charge.  **Character limit**: 5  **Values**: `True`, `False` ")

  public Boolean getUseDiscountSpecificAccountingCode() {
    return useDiscountSpecificAccountingCode;
  }


  public void setUseDiscountSpecificAccountingCode(Boolean useDiscountSpecificAccountingCode) {
    
    
    
    this.useDiscountSpecificAccountingCode = useDiscountSpecificAccountingCode;
  }


  public ProxyGetProductRatePlanCharge useTenantDefaultForPriceChange(Boolean useTenantDefaultForPriceChange) {
    
    
    
    
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


  public ProxyGetProductRatePlanCharge weeklyBillCycleDay(WeeklyBillCycleDayEnum weeklyBillCycleDay) {
    
    
    
    
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


  public ProxyGetProductRatePlanCharge isAllocationEligible(Boolean isAllocationEligible) {
    
    
    
    
    this.isAllocationEligible = isAllocationEligible;
    return this;
  }

   /**
   * Indicates whether the charge segment is allocation eligible in revenue recognition. The default value is &#x60;False&#x60;.  **Values**: &#x60;True&#x60;, &#x60;False&#x60;  **Notes**:    - This field is available only if you have the Additional Revenue Fields property enabled.   - To use this field, you must set the &#x60;X-Zuora-WSDL-Version&#x60; request header to 132 or later. 
   * @return isAllocationEligible
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Indicates whether the charge segment is allocation eligible in revenue recognition. The default value is `False`.  **Values**: `True`, `False`  **Notes**:    - This field is available only if you have the Additional Revenue Fields property enabled.   - To use this field, you must set the `X-Zuora-WSDL-Version` request header to 132 or later. ")

  public Boolean getIsAllocationEligible() {
    return isAllocationEligible;
  }


  public void setIsAllocationEligible(Boolean isAllocationEligible) {
    
    
    
    this.isAllocationEligible = isAllocationEligible;
  }


  public ProxyGetProductRatePlanCharge isUnbilled(Boolean isUnbilled) {
    
    
    
    
    this.isUnbilled = isUnbilled;
    return this;
  }

   /**
   * Specifies how to perform the accounting during revenue recognition. The default value is &#x60;False&#x60;.  **Values**: &#x60;True&#x60;, &#x60;False&#x60;  **Notes**:    - This field is available only if you have the Additional Revenue Fields property enabled.   - To use this field, you must set the &#x60;X-Zuora-WSDL-Version&#x60; request header to 132 or later.    
   * @return isUnbilled
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Specifies how to perform the accounting during revenue recognition. The default value is `False`.  **Values**: `True`, `False`  **Notes**:    - This field is available only if you have the Additional Revenue Fields property enabled.   - To use this field, you must set the `X-Zuora-WSDL-Version` request header to 132 or later.    ")

  public Boolean getIsUnbilled() {
    return isUnbilled;
  }


  public void setIsUnbilled(Boolean isUnbilled) {
    
    
    
    this.isUnbilled = isUnbilled;
  }


  public ProxyGetProductRatePlanCharge productCategory(String productCategory) {
    
    
    
    
    this.productCategory = productCategory;
    return this;
  }

   /**
   * This field is used to maintain the product category for integration with Zuora Revenue.   **Notes**:    - This field is available only if you have the Additional Revenue Fields property enabled.   - To use this field, you must set the &#x60;X-Zuora-WSDL-Version&#x60; request header to 132 or later. 
   * @return productCategory
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "This field is used to maintain the product category for integration with Zuora Revenue.   **Notes**:    - This field is available only if you have the Additional Revenue Fields property enabled.   - To use this field, you must set the `X-Zuora-WSDL-Version` request header to 132 or later. ")

  public String getProductCategory() {
    return productCategory;
  }


  public void setProductCategory(String productCategory) {
    
    
    
    this.productCategory = productCategory;
  }


  public ProxyGetProductRatePlanCharge productClass(String productClass) {
    
    
    
    
    this.productClass = productClass;
    return this;
  }

   /**
   * This field is used to maintain the product class for integration with Zuora Revenue.   **Notes**:    - This field is available only if you have the Additional Revenue Fields property enabled.    - To use this field, you must set the &#x60;X-Zuora-WSDL-Version&#x60; request header to 132 or later.    
   * @return productClass
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "This field is used to maintain the product class for integration with Zuora Revenue.   **Notes**:    - This field is available only if you have the Additional Revenue Fields property enabled.    - To use this field, you must set the `X-Zuora-WSDL-Version` request header to 132 or later.    ")

  public String getProductClass() {
    return productClass;
  }


  public void setProductClass(String productClass) {
    
    
    
    this.productClass = productClass;
  }


  public ProxyGetProductRatePlanCharge productFamily(String productFamily) {
    
    
    
    
    this.productFamily = productFamily;
    return this;
  }

   /**
   * This field is used to maintain the product family for integration with Zuora Revenue.   **Notes**:    - This field is available only if you have the Additional Revenue Fields property enabled.   - To use this field, you must set the &#x60;X-Zuora-WSDL-Version&#x60; request header to 132 or later. 
   * @return productFamily
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "This field is used to maintain the product family for integration with Zuora Revenue.   **Notes**:    - This field is available only if you have the Additional Revenue Fields property enabled.   - To use this field, you must set the `X-Zuora-WSDL-Version` request header to 132 or later. ")

  public String getProductFamily() {
    return productFamily;
  }


  public void setProductFamily(String productFamily) {
    
    
    
    this.productFamily = productFamily;
  }


  public ProxyGetProductRatePlanCharge productLine(String productLine) {
    
    
    
    
    this.productLine = productLine;
    return this;
  }

   /**
   * This field is used to maintain the product line for integration with Zuora Revenue.   **Notes**:    - This field is available only if you have the Additional Revenue Fields property enabled.    - To use this field, you must set the &#x60;X-Zuora-WSDL-Version&#x60; request header to 132 or later.            
   * @return productLine
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "This field is used to maintain the product line for integration with Zuora Revenue.   **Notes**:    - This field is available only if you have the Additional Revenue Fields property enabled.    - To use this field, you must set the `X-Zuora-WSDL-Version` request header to 132 or later.            ")

  public String getProductLine() {
    return productLine;
  }


  public void setProductLine(String productLine) {
    
    
    
    this.productLine = productLine;
  }


  public ProxyGetProductRatePlanCharge revenueRecognitionTiming(RevenueRecognitionTimingEnum revenueRecognitionTiming) {
    
    
    
    
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


  public ProxyGetProductRatePlanCharge revenueAmortizationMethod(RevenueAmortizationMethodEnum revenueAmortizationMethod) {
    
    
    
    
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


  public ProxyGetProductRatePlanCharge applyToBillingPeriodPartially(Boolean applyToBillingPeriodPartially) {
    
    
    
    
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


  public ProxyGetProductRatePlanCharge formula(String formula) {
    
    
    
    
    this.formula = formula;
    return this;
  }

   /**
   * The price lookup formula defined for the product rate plan charge, which is used to identify the correct and relevant charge definition based on the context.  For more information, see &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Build_products_and_prices/Attribute-based_pricing/Price_lookup_in_Attribute-based_Pricing\&quot;  target&#x3D;\&quot;_blank\&quot;&gt;Price lookup in Attribute-based Pricing&lt;/a&gt;.   **Notes**:    - This field is available only if the &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Build_products_and_prices/Attribute-based_pricing\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Attribute-based Pricing&lt;/a&gt; feature is enabled.   - To use this field, you must set the &#x60;X-Zuora-WSDL-Version&#x60; request header to 138 or higher. 
   * @return formula
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The price lookup formula defined for the product rate plan charge, which is used to identify the correct and relevant charge definition based on the context.  For more information, see <a href=\"https://knowledgecenter.zuora.com/Zuora_Billing/Build_products_and_prices/Attribute-based_pricing/Price_lookup_in_Attribute-based_Pricing\"  target=\"_blank\">Price lookup in Attribute-based Pricing</a>.   **Notes**:    - This field is available only if the <a href=\"https://knowledgecenter.zuora.com/Zuora_Billing/Build_products_and_prices/Attribute-based_pricing\" target=\"_blank\">Attribute-based Pricing</a> feature is enabled.   - To use this field, you must set the `X-Zuora-WSDL-Version` request header to 138 or higher. ")

  public String getFormula() {
    return formula;
  }


  public void setFormula(String formula) {
    
    
    
    this.formula = formula;
  }


  public ProxyGetProductRatePlanCharge classNS(String classNS) {
    
    
    
    
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


  public ProxyGetProductRatePlanCharge deferredRevAccountNS(String deferredRevAccountNS) {
    
    
    
    
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


  public ProxyGetProductRatePlanCharge departmentNS(String departmentNS) {
    
    
    
    
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


  public ProxyGetProductRatePlanCharge includeChildrenNS(IncludeChildrenNSEnum includeChildrenNS) {
    
    
    
    
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


  public ProxyGetProductRatePlanCharge integrationIdNS(String integrationIdNS) {
    
    
    
    
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


  public ProxyGetProductRatePlanCharge integrationStatusNS(String integrationStatusNS) {
    
    
    
    
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


  public ProxyGetProductRatePlanCharge itemTypeNS(ItemTypeNSEnum itemTypeNS) {
    
    
    
    
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


  public ProxyGetProductRatePlanCharge locationNS(String locationNS) {
    
    
    
    
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


  public ProxyGetProductRatePlanCharge recognizedRevAccountNS(String recognizedRevAccountNS) {
    
    
    
    
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


  public ProxyGetProductRatePlanCharge revRecEndNS(RevRecEndNSEnum revRecEndNS) {
    
    
    
    
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


  public ProxyGetProductRatePlanCharge revRecStartNS(RevRecStartNSEnum revRecStartNS) {
    
    
    
    
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


  public ProxyGetProductRatePlanCharge revRecTemplateTypeNS(String revRecTemplateTypeNS) {
    
    
    
    
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


  public ProxyGetProductRatePlanCharge subsidiaryNS(String subsidiaryNS) {
    
    
    
    
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


  public ProxyGetProductRatePlanCharge syncDateNS(String syncDateNS) {
    
    
    
    
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
   * @return the ProxyGetProductRatePlanCharge instance itself
   */
  public ProxyGetProductRatePlanCharge putAdditionalProperty(String key, Object value) {
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
    ProxyGetProductRatePlanCharge proxyGetProductRatePlanCharge = (ProxyGetProductRatePlanCharge) o;
    return Objects.equals(this.accountingCode, proxyGetProductRatePlanCharge.accountingCode) &&
        Objects.equals(this.applyDiscountTo, proxyGetProductRatePlanCharge.applyDiscountTo) &&
        Objects.equals(this.billCycleDay, proxyGetProductRatePlanCharge.billCycleDay) &&
        Objects.equals(this.billCycleType, proxyGetProductRatePlanCharge.billCycleType) &&
        Objects.equals(this.billingPeriod, proxyGetProductRatePlanCharge.billingPeriod) &&
        Objects.equals(this.billingPeriodAlignment, proxyGetProductRatePlanCharge.billingPeriodAlignment) &&
        Objects.equals(this.billingTiming, proxyGetProductRatePlanCharge.billingTiming) &&
        Objects.equals(this.chargeFunction, proxyGetProductRatePlanCharge.chargeFunction) &&
        Objects.equals(this.commitmentType, proxyGetProductRatePlanCharge.commitmentType) &&
        Objects.equals(this.chargeModel, proxyGetProductRatePlanCharge.chargeModel) &&
        Objects.equals(this.chargeType, proxyGetProductRatePlanCharge.chargeType) &&
        Objects.equals(this.createdById, proxyGetProductRatePlanCharge.createdById) &&
        Objects.equals(this.createdDate, proxyGetProductRatePlanCharge.createdDate) &&
        Objects.equals(this.defaultQuantity, proxyGetProductRatePlanCharge.defaultQuantity) &&
        Objects.equals(this.deferredRevenueAccount, proxyGetProductRatePlanCharge.deferredRevenueAccount) &&
        Objects.equals(this.description, proxyGetProductRatePlanCharge.description) &&
        Objects.equals(this.discountLevel, proxyGetProductRatePlanCharge.discountLevel) &&
        Objects.equals(this.endDateCondition, proxyGetProductRatePlanCharge.endDateCondition) &&
        Objects.equals(this.excludeItemBillingFromRevenueAccounting, proxyGetProductRatePlanCharge.excludeItemBillingFromRevenueAccounting) &&
        Objects.equals(this.excludeItemBookingFromRevenueAccounting, proxyGetProductRatePlanCharge.excludeItemBookingFromRevenueAccounting) &&
        Objects.equals(this.id, proxyGetProductRatePlanCharge.id) &&
        Objects.equals(this.includedUnits, proxyGetProductRatePlanCharge.includedUnits) &&
        Objects.equals(this.legacyRevenueReporting, proxyGetProductRatePlanCharge.legacyRevenueReporting) &&
        Objects.equals(this.listPriceBase, proxyGetProductRatePlanCharge.listPriceBase) &&
        Objects.equals(this.maxQuantity, proxyGetProductRatePlanCharge.maxQuantity) &&
        Objects.equals(this.minQuantity, proxyGetProductRatePlanCharge.minQuantity) &&
        Objects.equals(this.name, proxyGetProductRatePlanCharge.name) &&
        Objects.equals(this.numberOfPeriod, proxyGetProductRatePlanCharge.numberOfPeriod) &&
        Objects.equals(this.overageCalculationOption, proxyGetProductRatePlanCharge.overageCalculationOption) &&
        Objects.equals(this.overageUnusedUnitsCreditOption, proxyGetProductRatePlanCharge.overageUnusedUnitsCreditOption) &&
        Objects.equals(this.priceChangeOption, proxyGetProductRatePlanCharge.priceChangeOption) &&
        Objects.equals(this.priceIncreasePercentage, proxyGetProductRatePlanCharge.priceIncreasePercentage) &&
        Objects.equals(this.productRatePlanId, proxyGetProductRatePlanCharge.productRatePlanId) &&
        Objects.equals(this.ratingGroup, proxyGetProductRatePlanCharge.ratingGroup) &&
        Objects.equals(this.recognizedRevenueAccount, proxyGetProductRatePlanCharge.recognizedRevenueAccount) &&
        Objects.equals(this.revRecCode, proxyGetProductRatePlanCharge.revRecCode) &&
        Objects.equals(this.revRecTriggerCondition, proxyGetProductRatePlanCharge.revRecTriggerCondition) &&
        Objects.equals(this.revenueRecognitionRuleName, proxyGetProductRatePlanCharge.revenueRecognitionRuleName) &&
        Objects.equals(this.smoothingModel, proxyGetProductRatePlanCharge.smoothingModel) &&
        Objects.equals(this.specificBillingPeriod, proxyGetProductRatePlanCharge.specificBillingPeriod) &&
        Objects.equals(this.specificListPriceBase, proxyGetProductRatePlanCharge.specificListPriceBase) &&
        Objects.equals(this.taxCode, proxyGetProductRatePlanCharge.taxCode) &&
        Objects.equals(this.taxMode, proxyGetProductRatePlanCharge.taxMode) &&
        Objects.equals(this.taxable, proxyGetProductRatePlanCharge.taxable) &&
        Objects.equals(this.triggerEvent, proxyGetProductRatePlanCharge.triggerEvent) &&
        Objects.equals(this.UOM, proxyGetProductRatePlanCharge.UOM) &&
        Objects.equals(this.upToPeriods, proxyGetProductRatePlanCharge.upToPeriods) &&
        Objects.equals(this.upToPeriodsType, proxyGetProductRatePlanCharge.upToPeriodsType) &&
        Objects.equals(this.updatedById, proxyGetProductRatePlanCharge.updatedById) &&
        Objects.equals(this.updatedDate, proxyGetProductRatePlanCharge.updatedDate) &&
        Objects.equals(this.useDiscountSpecificAccountingCode, proxyGetProductRatePlanCharge.useDiscountSpecificAccountingCode) &&
        Objects.equals(this.useTenantDefaultForPriceChange, proxyGetProductRatePlanCharge.useTenantDefaultForPriceChange) &&
        Objects.equals(this.weeklyBillCycleDay, proxyGetProductRatePlanCharge.weeklyBillCycleDay) &&
        Objects.equals(this.isAllocationEligible, proxyGetProductRatePlanCharge.isAllocationEligible) &&
        Objects.equals(this.isUnbilled, proxyGetProductRatePlanCharge.isUnbilled) &&
        Objects.equals(this.productCategory, proxyGetProductRatePlanCharge.productCategory) &&
        Objects.equals(this.productClass, proxyGetProductRatePlanCharge.productClass) &&
        Objects.equals(this.productFamily, proxyGetProductRatePlanCharge.productFamily) &&
        Objects.equals(this.productLine, proxyGetProductRatePlanCharge.productLine) &&
        Objects.equals(this.revenueRecognitionTiming, proxyGetProductRatePlanCharge.revenueRecognitionTiming) &&
        Objects.equals(this.revenueAmortizationMethod, proxyGetProductRatePlanCharge.revenueAmortizationMethod) &&
        Objects.equals(this.applyToBillingPeriodPartially, proxyGetProductRatePlanCharge.applyToBillingPeriodPartially) &&
        Objects.equals(this.formula, proxyGetProductRatePlanCharge.formula) &&
        Objects.equals(this.classNS, proxyGetProductRatePlanCharge.classNS) &&
        Objects.equals(this.deferredRevAccountNS, proxyGetProductRatePlanCharge.deferredRevAccountNS) &&
        Objects.equals(this.departmentNS, proxyGetProductRatePlanCharge.departmentNS) &&
        Objects.equals(this.includeChildrenNS, proxyGetProductRatePlanCharge.includeChildrenNS) &&
        Objects.equals(this.integrationIdNS, proxyGetProductRatePlanCharge.integrationIdNS) &&
        Objects.equals(this.integrationStatusNS, proxyGetProductRatePlanCharge.integrationStatusNS) &&
        Objects.equals(this.itemTypeNS, proxyGetProductRatePlanCharge.itemTypeNS) &&
        Objects.equals(this.locationNS, proxyGetProductRatePlanCharge.locationNS) &&
        Objects.equals(this.recognizedRevAccountNS, proxyGetProductRatePlanCharge.recognizedRevAccountNS) &&
        Objects.equals(this.revRecEndNS, proxyGetProductRatePlanCharge.revRecEndNS) &&
        Objects.equals(this.revRecStartNS, proxyGetProductRatePlanCharge.revRecStartNS) &&
        Objects.equals(this.revRecTemplateTypeNS, proxyGetProductRatePlanCharge.revRecTemplateTypeNS) &&
        Objects.equals(this.subsidiaryNS, proxyGetProductRatePlanCharge.subsidiaryNS) &&
        Objects.equals(this.syncDateNS, proxyGetProductRatePlanCharge.syncDateNS)&&
        Objects.equals(this.additionalProperties, proxyGetProductRatePlanCharge.additionalProperties);
  }

  private static <T> boolean equalsNullable(JsonNullable<T> a, JsonNullable<T> b) {
    return a == b || (a != null && b != null && a.isPresent() && b.isPresent() && Objects.deepEquals(a.get(), b.get()));
  }

  @Override
  public int hashCode() {
    return Objects.hash(accountingCode, applyDiscountTo, billCycleDay, billCycleType, billingPeriod, billingPeriodAlignment, billingTiming, chargeFunction, commitmentType, chargeModel, chargeType, createdById, createdDate, defaultQuantity, deferredRevenueAccount, description, discountLevel, endDateCondition, excludeItemBillingFromRevenueAccounting, excludeItemBookingFromRevenueAccounting, id, includedUnits, legacyRevenueReporting, listPriceBase, maxQuantity, minQuantity, name, numberOfPeriod, overageCalculationOption, overageUnusedUnitsCreditOption, priceChangeOption, priceIncreasePercentage, productRatePlanId, ratingGroup, recognizedRevenueAccount, revRecCode, revRecTriggerCondition, revenueRecognitionRuleName, smoothingModel, specificBillingPeriod, specificListPriceBase, taxCode, taxMode, taxable, triggerEvent, UOM, upToPeriods, upToPeriodsType, updatedById, updatedDate, useDiscountSpecificAccountingCode, useTenantDefaultForPriceChange, weeklyBillCycleDay, isAllocationEligible, isUnbilled, productCategory, productClass, productFamily, productLine, revenueRecognitionTiming, revenueAmortizationMethod, applyToBillingPeriodPartially, formula, classNS, deferredRevAccountNS, departmentNS, includeChildrenNS, integrationIdNS, integrationStatusNS, itemTypeNS, locationNS, recognizedRevAccountNS, revRecEndNS, revRecStartNS, revRecTemplateTypeNS, subsidiaryNS, syncDateNS, additionalProperties);
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
    sb.append("class ProxyGetProductRatePlanCharge {\n");
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
    sb.append("    chargeType: ").append(toIndentedString(chargeType)).append("\n");
    sb.append("    createdById: ").append(toIndentedString(createdById)).append("\n");
    sb.append("    createdDate: ").append(toIndentedString(createdDate)).append("\n");
    sb.append("    defaultQuantity: ").append(toIndentedString(defaultQuantity)).append("\n");
    sb.append("    deferredRevenueAccount: ").append(toIndentedString(deferredRevenueAccount)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    discountLevel: ").append(toIndentedString(discountLevel)).append("\n");
    sb.append("    endDateCondition: ").append(toIndentedString(endDateCondition)).append("\n");
    sb.append("    excludeItemBillingFromRevenueAccounting: ").append(toIndentedString(excludeItemBillingFromRevenueAccounting)).append("\n");
    sb.append("    excludeItemBookingFromRevenueAccounting: ").append(toIndentedString(excludeItemBookingFromRevenueAccounting)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    includedUnits: ").append(toIndentedString(includedUnits)).append("\n");
    sb.append("    legacyRevenueReporting: ").append(toIndentedString(legacyRevenueReporting)).append("\n");
    sb.append("    listPriceBase: ").append(toIndentedString(listPriceBase)).append("\n");
    sb.append("    maxQuantity: ").append(toIndentedString(maxQuantity)).append("\n");
    sb.append("    minQuantity: ").append(toIndentedString(minQuantity)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    numberOfPeriod: ").append(toIndentedString(numberOfPeriod)).append("\n");
    sb.append("    overageCalculationOption: ").append(toIndentedString(overageCalculationOption)).append("\n");
    sb.append("    overageUnusedUnitsCreditOption: ").append(toIndentedString(overageUnusedUnitsCreditOption)).append("\n");
    sb.append("    priceChangeOption: ").append(toIndentedString(priceChangeOption)).append("\n");
    sb.append("    priceIncreasePercentage: ").append(toIndentedString(priceIncreasePercentage)).append("\n");
    sb.append("    productRatePlanId: ").append(toIndentedString(productRatePlanId)).append("\n");
    sb.append("    ratingGroup: ").append(toIndentedString(ratingGroup)).append("\n");
    sb.append("    recognizedRevenueAccount: ").append(toIndentedString(recognizedRevenueAccount)).append("\n");
    sb.append("    revRecCode: ").append(toIndentedString(revRecCode)).append("\n");
    sb.append("    revRecTriggerCondition: ").append(toIndentedString(revRecTriggerCondition)).append("\n");
    sb.append("    revenueRecognitionRuleName: ").append(toIndentedString(revenueRecognitionRuleName)).append("\n");
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
    sb.append("    updatedById: ").append(toIndentedString(updatedById)).append("\n");
    sb.append("    updatedDate: ").append(toIndentedString(updatedDate)).append("\n");
    sb.append("    useDiscountSpecificAccountingCode: ").append(toIndentedString(useDiscountSpecificAccountingCode)).append("\n");
    sb.append("    useTenantDefaultForPriceChange: ").append(toIndentedString(useTenantDefaultForPriceChange)).append("\n");
    sb.append("    weeklyBillCycleDay: ").append(toIndentedString(weeklyBillCycleDay)).append("\n");
    sb.append("    isAllocationEligible: ").append(toIndentedString(isAllocationEligible)).append("\n");
    sb.append("    isUnbilled: ").append(toIndentedString(isUnbilled)).append("\n");
    sb.append("    productCategory: ").append(toIndentedString(productCategory)).append("\n");
    sb.append("    productClass: ").append(toIndentedString(productClass)).append("\n");
    sb.append("    productFamily: ").append(toIndentedString(productFamily)).append("\n");
    sb.append("    productLine: ").append(toIndentedString(productLine)).append("\n");
    sb.append("    revenueRecognitionTiming: ").append(toIndentedString(revenueRecognitionTiming)).append("\n");
    sb.append("    revenueAmortizationMethod: ").append(toIndentedString(revenueAmortizationMethod)).append("\n");
    sb.append("    applyToBillingPeriodPartially: ").append(toIndentedString(applyToBillingPeriodPartially)).append("\n");
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
    openapiFields.add("ChargeType");
    openapiFields.add("CreatedById");
    openapiFields.add("CreatedDate");
    openapiFields.add("DefaultQuantity");
    openapiFields.add("DeferredRevenueAccount");
    openapiFields.add("Description");
    openapiFields.add("DiscountLevel");
    openapiFields.add("EndDateCondition");
    openapiFields.add("ExcludeItemBillingFromRevenueAccounting");
    openapiFields.add("ExcludeItemBookingFromRevenueAccounting");
    openapiFields.add("Id");
    openapiFields.add("IncludedUnits");
    openapiFields.add("LegacyRevenueReporting");
    openapiFields.add("ListPriceBase");
    openapiFields.add("MaxQuantity");
    openapiFields.add("MinQuantity");
    openapiFields.add("Name");
    openapiFields.add("NumberOfPeriod");
    openapiFields.add("OverageCalculationOption");
    openapiFields.add("OverageUnusedUnitsCreditOption");
    openapiFields.add("PriceChangeOption");
    openapiFields.add("PriceIncreasePercentage");
    openapiFields.add("ProductRatePlanId");
    openapiFields.add("RatingGroup");
    openapiFields.add("RecognizedRevenueAccount");
    openapiFields.add("RevRecCode");
    openapiFields.add("RevRecTriggerCondition");
    openapiFields.add("RevenueRecognitionRuleName");
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
    openapiFields.add("UpdatedById");
    openapiFields.add("UpdatedDate");
    openapiFields.add("UseDiscountSpecificAccountingCode");
    openapiFields.add("UseTenantDefaultForPriceChange");
    openapiFields.add("WeeklyBillCycleDay");
    openapiFields.add("IsAllocationEligible");
    openapiFields.add("IsUnbilled");
    openapiFields.add("ProductCategory");
    openapiFields.add("ProductClass");
    openapiFields.add("ProductFamily");
    openapiFields.add("ProductLine");
    openapiFields.add("RevenueRecognitionTiming");
    openapiFields.add("RevenueAmortizationMethod");
    openapiFields.add("ApplyToBillingPeriodPartially");
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
  }

 /**
  * Validates the JSON Object and throws an exception if issues found
  *
  * @param jsonObj JSON Object
  * @throws IOException if the JSON Object is invalid with respect to ProxyGetProductRatePlanCharge
  */
  public static void validateJsonObject(JsonObject jsonObj) throws IOException {
      if (jsonObj == null) {
        if (!ProxyGetProductRatePlanCharge.openapiRequiredFields.isEmpty()) { // has required fields but JSON object is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in ProxyGetProductRatePlanCharge is not found in the empty JSON string", ProxyGetProductRatePlanCharge.openapiRequiredFields.toString()));
        }
      }
      if ((jsonObj.get("AccountingCode") != null && !jsonObj.get("AccountingCode").isJsonNull()) && !jsonObj.get("AccountingCode").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `AccountingCode` to be a primitive type in the JSON string but got `%s`", jsonObj.get("AccountingCode").toString()));
      }
      if ((jsonObj.get("ApplyDiscountTo") != null && !jsonObj.get("ApplyDiscountTo").isJsonNull()) && !jsonObj.get("ApplyDiscountTo").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `ApplyDiscountTo` to be a primitive type in the JSON string but got `%s`", jsonObj.get("ApplyDiscountTo").toString()));
      }
      if ((jsonObj.get("BillCycleType") != null && !jsonObj.get("BillCycleType").isJsonNull()) && !jsonObj.get("BillCycleType").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `BillCycleType` to be a primitive type in the JSON string but got `%s`", jsonObj.get("BillCycleType").toString()));
      }
      if ((jsonObj.get("BillingPeriod") != null && !jsonObj.get("BillingPeriod").isJsonNull()) && !jsonObj.get("BillingPeriod").isJsonPrimitive()) {
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
      if ((jsonObj.get("ChargeModel") != null && !jsonObj.get("ChargeModel").isJsonNull()) && !jsonObj.get("ChargeModel").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `ChargeModel` to be a primitive type in the JSON string but got `%s`", jsonObj.get("ChargeModel").toString()));
      }
      if ((jsonObj.get("ChargeType") != null && !jsonObj.get("ChargeType").isJsonNull()) && !jsonObj.get("ChargeType").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `ChargeType` to be a primitive type in the JSON string but got `%s`", jsonObj.get("ChargeType").toString()));
      }
      if ((jsonObj.get("CreatedById") != null && !jsonObj.get("CreatedById").isJsonNull()) && !jsonObj.get("CreatedById").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `CreatedById` to be a primitive type in the JSON string but got `%s`", jsonObj.get("CreatedById").toString()));
      }
      if ((jsonObj.get("DeferredRevenueAccount") != null && !jsonObj.get("DeferredRevenueAccount").isJsonNull()) && !jsonObj.get("DeferredRevenueAccount").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `DeferredRevenueAccount` to be a primitive type in the JSON string but got `%s`", jsonObj.get("DeferredRevenueAccount").toString()));
      }
      if ((jsonObj.get("Description") != null && !jsonObj.get("Description").isJsonNull()) && !jsonObj.get("Description").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `Description` to be a primitive type in the JSON string but got `%s`", jsonObj.get("Description").toString()));
      }
      if ((jsonObj.get("DiscountLevel") != null && !jsonObj.get("DiscountLevel").isJsonNull()) && !jsonObj.get("DiscountLevel").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `DiscountLevel` to be a primitive type in the JSON string but got `%s`", jsonObj.get("DiscountLevel").toString()));
      }
      if ((jsonObj.get("EndDateCondition") != null && !jsonObj.get("EndDateCondition").isJsonNull()) && !jsonObj.get("EndDateCondition").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `EndDateCondition` to be a primitive type in the JSON string but got `%s`", jsonObj.get("EndDateCondition").toString()));
      }
      if ((jsonObj.get("Id") != null && !jsonObj.get("Id").isJsonNull()) && !jsonObj.get("Id").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `Id` to be a primitive type in the JSON string but got `%s`", jsonObj.get("Id").toString()));
      }
      if ((jsonObj.get("ListPriceBase") != null && !jsonObj.get("ListPriceBase").isJsonNull()) && !jsonObj.get("ListPriceBase").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `ListPriceBase` to be a primitive type in the JSON string but got `%s`", jsonObj.get("ListPriceBase").toString()));
      }
      if ((jsonObj.get("Name") != null && !jsonObj.get("Name").isJsonNull()) && !jsonObj.get("Name").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `Name` to be a primitive type in the JSON string but got `%s`", jsonObj.get("Name").toString()));
      }
      if (!jsonObj.get("OverageCalculationOption").isJsonNull() && (jsonObj.get("OverageCalculationOption") != null && !jsonObj.get("OverageCalculationOption").isJsonNull()) && !jsonObj.get("OverageCalculationOption").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `OverageCalculationOption` to be a primitive type in the JSON string but got `%s`", jsonObj.get("OverageCalculationOption").toString()));
      }
      if (!jsonObj.get("OverageUnusedUnitsCreditOption").isJsonNull() && (jsonObj.get("OverageUnusedUnitsCreditOption") != null && !jsonObj.get("OverageUnusedUnitsCreditOption").isJsonNull()) && !jsonObj.get("OverageUnusedUnitsCreditOption").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `OverageUnusedUnitsCreditOption` to be a primitive type in the JSON string but got `%s`", jsonObj.get("OverageUnusedUnitsCreditOption").toString()));
      }
      if (!jsonObj.get("PriceChangeOption").isJsonNull() && (jsonObj.get("PriceChangeOption") != null && !jsonObj.get("PriceChangeOption").isJsonNull()) && !jsonObj.get("PriceChangeOption").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `PriceChangeOption` to be a primitive type in the JSON string but got `%s`", jsonObj.get("PriceChangeOption").toString()));
      }
      if ((jsonObj.get("ProductRatePlanId") != null && !jsonObj.get("ProductRatePlanId").isJsonNull()) && !jsonObj.get("ProductRatePlanId").isJsonPrimitive()) {
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
      if (!jsonObj.get("SmoothingModel").isJsonNull() && (jsonObj.get("SmoothingModel") != null && !jsonObj.get("SmoothingModel").isJsonNull()) && !jsonObj.get("SmoothingModel").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `SmoothingModel` to be a primitive type in the JSON string but got `%s`", jsonObj.get("SmoothingModel").toString()));
      }
      if ((jsonObj.get("TaxCode") != null && !jsonObj.get("TaxCode").isJsonNull()) && !jsonObj.get("TaxCode").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `TaxCode` to be a primitive type in the JSON string but got `%s`", jsonObj.get("TaxCode").toString()));
      }
      if (!jsonObj.get("TaxMode").isJsonNull() && (jsonObj.get("TaxMode") != null && !jsonObj.get("TaxMode").isJsonNull()) && !jsonObj.get("TaxMode").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `TaxMode` to be a primitive type in the JSON string but got `%s`", jsonObj.get("TaxMode").toString()));
      }
      if ((jsonObj.get("TriggerEvent") != null && !jsonObj.get("TriggerEvent").isJsonNull()) && !jsonObj.get("TriggerEvent").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `TriggerEvent` to be a primitive type in the JSON string but got `%s`", jsonObj.get("TriggerEvent").toString()));
      }
      if (!jsonObj.get("UOM").isJsonNull() && (jsonObj.get("UOM") != null && !jsonObj.get("UOM").isJsonNull()) && !jsonObj.get("UOM").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `UOM` to be a primitive type in the JSON string but got `%s`", jsonObj.get("UOM").toString()));
      }
      if (!jsonObj.get("UpToPeriodsType").isJsonNull() && (jsonObj.get("UpToPeriodsType") != null && !jsonObj.get("UpToPeriodsType").isJsonNull()) && !jsonObj.get("UpToPeriodsType").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `UpToPeriodsType` to be a primitive type in the JSON string but got `%s`", jsonObj.get("UpToPeriodsType").toString()));
      }
      if ((jsonObj.get("UpdatedById") != null && !jsonObj.get("UpdatedById").isJsonNull()) && !jsonObj.get("UpdatedById").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `UpdatedById` to be a primitive type in the JSON string but got `%s`", jsonObj.get("UpdatedById").toString()));
      }
      if ((jsonObj.get("WeeklyBillCycleDay") != null && !jsonObj.get("WeeklyBillCycleDay").isJsonNull()) && !jsonObj.get("WeeklyBillCycleDay").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `WeeklyBillCycleDay` to be a primitive type in the JSON string but got `%s`", jsonObj.get("WeeklyBillCycleDay").toString()));
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
       if (!ProxyGetProductRatePlanCharge.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'ProxyGetProductRatePlanCharge' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<ProxyGetProductRatePlanCharge> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(ProxyGetProductRatePlanCharge.class));

       return (TypeAdapter<T>) new TypeAdapter<ProxyGetProductRatePlanCharge>() {
           @Override
           public void write(JsonWriter out, ProxyGetProductRatePlanCharge value) throws IOException {
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
           public ProxyGetProductRatePlanCharge read(JsonReader in) throws IOException {
             JsonObject jsonObj = elementAdapter.read(in).getAsJsonObject();
             validateJsonObject(jsonObj);
             // store additional fields in the deserialized instance
             ProxyGetProductRatePlanCharge instance = thisAdapter.fromJsonTree(jsonObj);
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
  * Create an instance of ProxyGetProductRatePlanCharge given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of ProxyGetProductRatePlanCharge
  * @throws IOException if the JSON string is invalid with respect to ProxyGetProductRatePlanCharge
  */
  public static ProxyGetProductRatePlanCharge fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, ProxyGetProductRatePlanCharge.class);
  }

 /**
  * Convert an instance of ProxyGetProductRatePlanCharge to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

