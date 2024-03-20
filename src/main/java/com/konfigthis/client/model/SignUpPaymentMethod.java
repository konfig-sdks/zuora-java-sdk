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
import com.konfigthis.client.model.SignUpCreatePaymentMethodCardholderInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
import java.time.LocalDate;

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
 * SignUpPaymentMethod
 */@javax.annotation.Generated(value = "Generated by https://konfigthis.com")
public class SignUpPaymentMethod {
  /**
   * Type of payment method. The following types of the payment method are supported: 
   */
  @JsonAdapter(TypeEnum.Adapter.class)
 public enum TypeEnum {
    PAYPALEC("PayPalEC"),
    
    PAYPALNATIVEEC("PayPalNativeEC"),
    
    PAYPALADAPTIVE("PayPalAdaptive"),
    
    CREDITCARD("CreditCard"),
    
    CREDITCARDREFERENCETRANSACTION("CreditCardReferenceTransaction");

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

  public static final String SERIALIZED_NAME_TYPE = "type";
  @SerializedName(SERIALIZED_NAME_TYPE)
  private TypeEnum type;

  public static final String SERIALIZED_NAME_SECOND_TOKEN_ID = "secondTokenId";
  @SerializedName(SERIALIZED_NAME_SECOND_TOKEN_ID)
  private String secondTokenId;

  public static final String SERIALIZED_NAME_TOKEN_ID = "tokenId";
  @SerializedName(SERIALIZED_NAME_TOKEN_ID)
  private String tokenId;

  public static final String SERIALIZED_NAME_B_A_I_D = "BAID";
  @SerializedName(SERIALIZED_NAME_B_A_I_D)
  private String BAID;

  public static final String SERIALIZED_NAME_EMAIL = "email";
  @SerializedName(SERIALIZED_NAME_EMAIL)
  private String email;

  public static final String SERIALIZED_NAME_PREAPPROVAL_KEY = "preapprovalKey";
  @SerializedName(SERIALIZED_NAME_PREAPPROVAL_KEY)
  private String preapprovalKey;

  public static final String SERIALIZED_NAME_CARD_HOLDER_INFO = "cardHolderInfo";
  @SerializedName(SERIALIZED_NAME_CARD_HOLDER_INFO)
  private SignUpCreatePaymentMethodCardholderInfo cardHolderInfo;

  public static final String SERIALIZED_NAME_CARD_NUMBER = "cardNumber";
  @SerializedName(SERIALIZED_NAME_CARD_NUMBER)
  private String cardNumber;

  public static final String SERIALIZED_NAME_CARD_TYPE = "cardType";
  @SerializedName(SERIALIZED_NAME_CARD_TYPE)
  private String cardType;

  public static final String SERIALIZED_NAME_CHECK_DUPLICATED = "checkDuplicated";
  @SerializedName(SERIALIZED_NAME_CHECK_DUPLICATED)
  private Boolean checkDuplicated;

  public static final String SERIALIZED_NAME_EXPIRATION_MONTH = "expirationMonth";
  @SerializedName(SERIALIZED_NAME_EXPIRATION_MONTH)
  private String expirationMonth;

  public static final String SERIALIZED_NAME_EXPIRATION_YEAR = "expirationYear";
  @SerializedName(SERIALIZED_NAME_EXPIRATION_YEAR)
  private String expirationYear;

  public static final String SERIALIZED_NAME_MIT_CONSENT_AGREEMENT_REF = "mitConsentAgreementRef";
  @SerializedName(SERIALIZED_NAME_MIT_CONSENT_AGREEMENT_REF)
  private String mitConsentAgreementRef;

  /**
   * Required if you set the &#x60;mitProfileAction&#x60; field. Specifies how the consent agreement has been established with the customer. The allowed value is &#x60;External&#x60;. If you do not specify the &#x60;mitProfileAction&#x60; field, Zuora will automatically create a stored credential profile for the payment method, with the default value &#x60;External&#x60; set to this field. 
   */
  @JsonAdapter(MitConsentAgreementSrcEnum.Adapter.class)
 public enum MitConsentAgreementSrcEnum {
    EXTERNAL("External");

    private String value;

    MitConsentAgreementSrcEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static MitConsentAgreementSrcEnum fromValue(String value) {
      for (MitConsentAgreementSrcEnum b : MitConsentAgreementSrcEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<MitConsentAgreementSrcEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final MitConsentAgreementSrcEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public MitConsentAgreementSrcEnum read(final JsonReader jsonReader) throws IOException {
        String value =  jsonReader.nextString();
        return MitConsentAgreementSrcEnum.fromValue(value);
      }
    }
  }

  public static final String SERIALIZED_NAME_MIT_CONSENT_AGREEMENT_SRC = "mitConsentAgreementSrc";
  @SerializedName(SERIALIZED_NAME_MIT_CONSENT_AGREEMENT_SRC)
  private MitConsentAgreementSrcEnum mitConsentAgreementSrc;

  public static final String SERIALIZED_NAME_MIT_NETWORK_TRANSACTION_ID = "mitNetworkTransactionId";
  @SerializedName(SERIALIZED_NAME_MIT_NETWORK_TRANSACTION_ID)
  private String mitNetworkTransactionId;

  /**
   * Specifies how Zuora creates and activates the stored credential profile. If you do not specify this field, Zuora will automatically create a stored credential profile for the payment method, with the default value &#x60;Activate&#x60; set to this field. 
   */
  @JsonAdapter(MitProfileActionEnum.Adapter.class)
 public enum MitProfileActionEnum {
    ACTIVATE("Activate"),
    
    PERSIST("Persist");

    private String value;

    MitProfileActionEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static MitProfileActionEnum fromValue(String value) {
      for (MitProfileActionEnum b : MitProfileActionEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<MitProfileActionEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final MitProfileActionEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public MitProfileActionEnum read(final JsonReader jsonReader) throws IOException {
        String value =  jsonReader.nextString();
        return MitProfileActionEnum.fromValue(value);
      }
    }
  }

  public static final String SERIALIZED_NAME_MIT_PROFILE_ACTION = "mitProfileAction";
  @SerializedName(SERIALIZED_NAME_MIT_PROFILE_ACTION)
  private MitProfileActionEnum mitProfileAction;

  public static final String SERIALIZED_NAME_MIT_PROFILE_AGREED_ON = "mitProfileAgreedOn";
  @SerializedName(SERIALIZED_NAME_MIT_PROFILE_AGREED_ON)
  private LocalDate mitProfileAgreedOn;

  /**
   * Required if you set the &#x60;mitProfileAction&#x60; field. If you do not specify the &#x60;mitProfileAction&#x60; field, Zuora will automatically create a stored credential profile for the payment method, with the default value &#x60;Recurring&#x60; set to this field. 
   */
  @JsonAdapter(MitProfileTypeEnum.Adapter.class)
 public enum MitProfileTypeEnum {
    RECURRING("Recurring");

    private String value;

    MitProfileTypeEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static MitProfileTypeEnum fromValue(String value) {
      for (MitProfileTypeEnum b : MitProfileTypeEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<MitProfileTypeEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final MitProfileTypeEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public MitProfileTypeEnum read(final JsonReader jsonReader) throws IOException {
        String value =  jsonReader.nextString();
        return MitProfileTypeEnum.fromValue(value);
      }
    }
  }

  public static final String SERIALIZED_NAME_MIT_PROFILE_TYPE = "mitProfileType";
  @SerializedName(SERIALIZED_NAME_MIT_PROFILE_TYPE)
  private MitProfileTypeEnum mitProfileType;

  public static final String SERIALIZED_NAME_SECURITY_CODE = "securityCode";
  @SerializedName(SERIALIZED_NAME_SECURITY_CODE)
  private String securityCode;

  public static final String SERIALIZED_NAME_ACCOUNT_KEY = "accountKey";
  @SerializedName(SERIALIZED_NAME_ACCOUNT_KEY)
  private String accountKey;

  public static final String SERIALIZED_NAME_AUTH_GATEWAY = "authGateway";
  @SerializedName(SERIALIZED_NAME_AUTH_GATEWAY)
  private String authGateway;

  public static final String SERIALIZED_NAME_IP_ADDRESS = "ipAddress";
  @SerializedName(SERIALIZED_NAME_IP_ADDRESS)
  private String ipAddress;

  public static final String SERIALIZED_NAME_MAKE_DEFAULT = "makeDefault";
  @SerializedName(SERIALIZED_NAME_MAKE_DEFAULT)
  private Boolean makeDefault = false;

  public SignUpPaymentMethod() {
  }

  public SignUpPaymentMethod type(TypeEnum type) {
    
    
    
    
    this.type = type;
    return this;
  }

   /**
   * Type of payment method. The following types of the payment method are supported: 
   * @return type
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "Type of payment method. The following types of the payment method are supported: ")

  public TypeEnum getType() {
    return type;
  }


  public void setType(TypeEnum type) {
    
    
    
    this.type = type;
  }


  public SignUpPaymentMethod secondTokenId(String secondTokenId) {
    
    
    
    
    this.secondTokenId = secondTokenId;
    return this;
  }

   /**
   * The second token id of CreditCardReferenceTransaction. 
   * @return secondTokenId
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The second token id of CreditCardReferenceTransaction. ")

  public String getSecondTokenId() {
    return secondTokenId;
  }


  public void setSecondTokenId(String secondTokenId) {
    
    
    
    this.secondTokenId = secondTokenId;
  }


  public SignUpPaymentMethod tokenId(String tokenId) {
    
    
    
    
    this.tokenId = tokenId;
    return this;
  }

   /**
   * The token id of payment method, required field of CreditCardReferenceTransaction type. 
   * @return tokenId
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The token id of payment method, required field of CreditCardReferenceTransaction type. ")

  public String getTokenId() {
    return tokenId;
  }


  public void setTokenId(String tokenId) {
    
    
    
    this.tokenId = tokenId;
  }


  public SignUpPaymentMethod BAID(String BAID) {
    
    
    
    
    this.BAID = BAID;
    return this;
  }

   /**
   * ID of a PayPal billing agreement, for example, I-1TJ3GAGG82Y9. 
   * @return BAID
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "ID of a PayPal billing agreement, for example, I-1TJ3GAGG82Y9. ")

  public String getBAID() {
    return BAID;
  }


  public void setBAID(String BAID) {
    
    
    
    this.BAID = BAID;
  }


  public SignUpPaymentMethod email(String email) {
    
    
    
    
    this.email = email;
    return this;
  }

   /**
   * Email address associated with the payment method. This field is only supported for PayPal payment methods and is required if you want to create any of the following PayPal payment methods:   - PayPal Express Checkout payment method    - PayPal Adaptive payment method   - PayPal Commerce Platform payment method 
   * @return email
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Email address associated with the payment method. This field is only supported for PayPal payment methods and is required if you want to create any of the following PayPal payment methods:   - PayPal Express Checkout payment method    - PayPal Adaptive payment method   - PayPal Commerce Platform payment method ")

  public String getEmail() {
    return email;
  }


  public void setEmail(String email) {
    
    
    
    this.email = email;
  }


  public SignUpPaymentMethod preapprovalKey(String preapprovalKey) {
    
    
    
    
    this.preapprovalKey = preapprovalKey;
    return this;
  }

   /**
   * The PayPal preapproval key. 
   * @return preapprovalKey
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The PayPal preapproval key. ")

  public String getPreapprovalKey() {
    return preapprovalKey;
  }


  public void setPreapprovalKey(String preapprovalKey) {
    
    
    
    this.preapprovalKey = preapprovalKey;
  }


  public SignUpPaymentMethod cardHolderInfo(SignUpCreatePaymentMethodCardholderInfo cardHolderInfo) {
    
    
    
    
    this.cardHolderInfo = cardHolderInfo;
    return this;
  }

   /**
   * Get cardHolderInfo
   * @return cardHolderInfo
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public SignUpCreatePaymentMethodCardholderInfo getCardHolderInfo() {
    return cardHolderInfo;
  }


  public void setCardHolderInfo(SignUpCreatePaymentMethodCardholderInfo cardHolderInfo) {
    
    
    
    this.cardHolderInfo = cardHolderInfo;
  }


  public SignUpPaymentMethod cardNumber(String cardNumber) {
    
    
    
    
    this.cardNumber = cardNumber;
    return this;
  }

   /**
   * Credit card number. 
   * @return cardNumber
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Credit card number. ")

  public String getCardNumber() {
    return cardNumber;
  }


  public void setCardNumber(String cardNumber) {
    
    
    
    this.cardNumber = cardNumber;
  }


  public SignUpPaymentMethod cardType(String cardType) {
    
    
    
    
    this.cardType = cardType;
    return this;
  }

   /**
   * The type of the credit card.  Possible values include &#x60;Visa&#x60;, &#x60;MasterCard&#x60;, &#x60;AmericanExpress&#x60;, &#x60;Discover&#x60;, &#x60;JCB&#x60;, and &#x60;Diners&#x60;. For more information about credit card types supported by different payment gateways, see [Supported Payment Gateways](https://knowledgecenter.zuora.com/CB_Billing/M_Payment_Gateways/Supported_Payment_Gateways). 
   * @return cardType
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The type of the credit card.  Possible values include `Visa`, `MasterCard`, `AmericanExpress`, `Discover`, `JCB`, and `Diners`. For more information about credit card types supported by different payment gateways, see [Supported Payment Gateways](https://knowledgecenter.zuora.com/CB_Billing/M_Payment_Gateways/Supported_Payment_Gateways). ")

  public String getCardType() {
    return cardType;
  }


  public void setCardType(String cardType) {
    
    
    
    this.cardType = cardType;
  }


  public SignUpPaymentMethod checkDuplicated(Boolean checkDuplicated) {
    
    
    
    
    this.checkDuplicated = checkDuplicated;
    return this;
  }

   /**
   * Get checkDuplicated
   * @return checkDuplicated
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public Boolean getCheckDuplicated() {
    return checkDuplicated;
  }


  public void setCheckDuplicated(Boolean checkDuplicated) {
    
    
    
    this.checkDuplicated = checkDuplicated;
  }


  public SignUpPaymentMethod expirationMonth(String expirationMonth) {
    
    
    
    
    this.expirationMonth = expirationMonth;
    return this;
  }

   /**
   * One or two digit expiration month (1-12) of the credit card. 
   * @return expirationMonth
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "One or two digit expiration month (1-12) of the credit card. ")

  public String getExpirationMonth() {
    return expirationMonth;
  }


  public void setExpirationMonth(String expirationMonth) {
    
    
    
    this.expirationMonth = expirationMonth;
  }


  public SignUpPaymentMethod expirationYear(String expirationYear) {
    
    
    
    
    this.expirationYear = expirationYear;
    return this;
  }

   /**
   * Four-digit expiration year of the credit card. 
   * @return expirationYear
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Four-digit expiration year of the credit card. ")

  public String getExpirationYear() {
    return expirationYear;
  }


  public void setExpirationYear(String expirationYear) {
    
    
    
    this.expirationYear = expirationYear;
  }


  public SignUpPaymentMethod mitConsentAgreementRef(String mitConsentAgreementRef) {
    
    
    
    
    this.mitConsentAgreementRef = mitConsentAgreementRef;
    return this;
  }

   /**
   * Specifies your reference for the stored credential consent agreement that you have established with the customer. Only applicable if you set the &#x60;mitProfileAction&#x60; field. 
   * @return mitConsentAgreementRef
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Specifies your reference for the stored credential consent agreement that you have established with the customer. Only applicable if you set the `mitProfileAction` field. ")

  public String getMitConsentAgreementRef() {
    return mitConsentAgreementRef;
  }


  public void setMitConsentAgreementRef(String mitConsentAgreementRef) {
    
    
    
    this.mitConsentAgreementRef = mitConsentAgreementRef;
  }


  public SignUpPaymentMethod mitConsentAgreementSrc(MitConsentAgreementSrcEnum mitConsentAgreementSrc) {
    
    
    
    
    this.mitConsentAgreementSrc = mitConsentAgreementSrc;
    return this;
  }

   /**
   * Required if you set the &#x60;mitProfileAction&#x60; field. Specifies how the consent agreement has been established with the customer. The allowed value is &#x60;External&#x60;. If you do not specify the &#x60;mitProfileAction&#x60; field, Zuora will automatically create a stored credential profile for the payment method, with the default value &#x60;External&#x60; set to this field. 
   * @return mitConsentAgreementSrc
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Required if you set the `mitProfileAction` field. Specifies how the consent agreement has been established with the customer. The allowed value is `External`. If you do not specify the `mitProfileAction` field, Zuora will automatically create a stored credential profile for the payment method, with the default value `External` set to this field. ")

  public MitConsentAgreementSrcEnum getMitConsentAgreementSrc() {
    return mitConsentAgreementSrc;
  }


  public void setMitConsentAgreementSrc(MitConsentAgreementSrcEnum mitConsentAgreementSrc) {
    
    
    
    this.mitConsentAgreementSrc = mitConsentAgreementSrc;
  }


  public SignUpPaymentMethod mitNetworkTransactionId(String mitNetworkTransactionId) {
    
    
    
    
    this.mitNetworkTransactionId = mitNetworkTransactionId;
    return this;
  }

   /**
   * Specifies the ID of a network transaction. Only applicable if you set the &#x60;mitProfileAction&#x60; field to &#x60;Persist&#x60;. 
   * @return mitNetworkTransactionId
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Specifies the ID of a network transaction. Only applicable if you set the `mitProfileAction` field to `Persist`. ")

  public String getMitNetworkTransactionId() {
    return mitNetworkTransactionId;
  }


  public void setMitNetworkTransactionId(String mitNetworkTransactionId) {
    
    
    
    this.mitNetworkTransactionId = mitNetworkTransactionId;
  }


  public SignUpPaymentMethod mitProfileAction(MitProfileActionEnum mitProfileAction) {
    
    
    
    
    this.mitProfileAction = mitProfileAction;
    return this;
  }

   /**
   * Specifies how Zuora creates and activates the stored credential profile. If you do not specify this field, Zuora will automatically create a stored credential profile for the payment method, with the default value &#x60;Activate&#x60; set to this field. 
   * @return mitProfileAction
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Specifies how Zuora creates and activates the stored credential profile. If you do not specify this field, Zuora will automatically create a stored credential profile for the payment method, with the default value `Activate` set to this field. ")

  public MitProfileActionEnum getMitProfileAction() {
    return mitProfileAction;
  }


  public void setMitProfileAction(MitProfileActionEnum mitProfileAction) {
    
    
    
    this.mitProfileAction = mitProfileAction;
  }


  public SignUpPaymentMethod mitProfileAgreedOn(LocalDate mitProfileAgreedOn) {
    
    
    
    
    this.mitProfileAgreedOn = mitProfileAgreedOn;
    return this;
  }

   /**
   * The date on which the profile is agreed. The date format is &#x60;yyyy-mm-dd&#x60;. 
   * @return mitProfileAgreedOn
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The date on which the profile is agreed. The date format is `yyyy-mm-dd`. ")

  public LocalDate getMitProfileAgreedOn() {
    return mitProfileAgreedOn;
  }


  public void setMitProfileAgreedOn(LocalDate mitProfileAgreedOn) {
    
    
    
    this.mitProfileAgreedOn = mitProfileAgreedOn;
  }


  public SignUpPaymentMethod mitProfileType(MitProfileTypeEnum mitProfileType) {
    
    
    
    
    this.mitProfileType = mitProfileType;
    return this;
  }

   /**
   * Required if you set the &#x60;mitProfileAction&#x60; field. If you do not specify the &#x60;mitProfileAction&#x60; field, Zuora will automatically create a stored credential profile for the payment method, with the default value &#x60;Recurring&#x60; set to this field. 
   * @return mitProfileType
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Required if you set the `mitProfileAction` field. If you do not specify the `mitProfileAction` field, Zuora will automatically create a stored credential profile for the payment method, with the default value `Recurring` set to this field. ")

  public MitProfileTypeEnum getMitProfileType() {
    return mitProfileType;
  }


  public void setMitProfileType(MitProfileTypeEnum mitProfileType) {
    
    
    
    this.mitProfileType = mitProfileType;
  }


  public SignUpPaymentMethod securityCode(String securityCode) {
    
    
    
    
    this.securityCode = securityCode;
    return this;
  }

   /**
   * CVV or CVV2 security code of the credit card.  To ensure PCI compliance, this value is not stored and cannot be queried. 
   * @return securityCode
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "CVV or CVV2 security code of the credit card.  To ensure PCI compliance, this value is not stored and cannot be queried. ")

  public String getSecurityCode() {
    return securityCode;
  }


  public void setSecurityCode(String securityCode) {
    
    
    
    this.securityCode = securityCode;
  }


  public SignUpPaymentMethod accountKey(String accountKey) {
    
    
    
    
    this.accountKey = accountKey;
    return this;
  }

   /**
   * Internal ID of the customer account that will own the payment method. 
   * @return accountKey
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Internal ID of the customer account that will own the payment method. ")

  public String getAccountKey() {
    return accountKey;
  }


  public void setAccountKey(String accountKey) {
    
    
    
    this.accountKey = accountKey;
  }


  public SignUpPaymentMethod authGateway(String authGateway) {
    
    
    
    
    this.authGateway = authGateway;
    return this;
  }

   /**
   * Internal ID of the payment gateway that Zuora will use to authorize the payments that are made with the payment method.  If you do not set this field, Zuora will use one of the following payment gateways instead:  * The default payment gateway of the customer account that owns the payment method, if the &#x60;accountKey&#x60; field is set. * The default payment gateway of your Zuora tenant, if the &#x60;accountKey&#x60; field is not set. 
   * @return authGateway
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Internal ID of the payment gateway that Zuora will use to authorize the payments that are made with the payment method.  If you do not set this field, Zuora will use one of the following payment gateways instead:  * The default payment gateway of the customer account that owns the payment method, if the `accountKey` field is set. * The default payment gateway of your Zuora tenant, if the `accountKey` field is not set. ")

  public String getAuthGateway() {
    return authGateway;
  }


  public void setAuthGateway(String authGateway) {
    
    
    
    this.authGateway = authGateway;
  }


  public SignUpPaymentMethod ipAddress(String ipAddress) {
    
    
    
    
    this.ipAddress = ipAddress;
    return this;
  }

   /**
   * The IPv4 or IPv6 information of the user when the payment method is created or updated. Some gateways use this field for fraud prevention. If this field is passed to Zuora, Zuora directly passes it to gateways.   If the IP address length is beyond 45 characters, a validation error occurs. 
   * @return ipAddress
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The IPv4 or IPv6 information of the user when the payment method is created or updated. Some gateways use this field for fraud prevention. If this field is passed to Zuora, Zuora directly passes it to gateways.   If the IP address length is beyond 45 characters, a validation error occurs. ")

  public String getIpAddress() {
    return ipAddress;
  }


  public void setIpAddress(String ipAddress) {
    
    
    
    this.ipAddress = ipAddress;
  }


  public SignUpPaymentMethod makeDefault(Boolean makeDefault) {
    
    
    
    
    this.makeDefault = makeDefault;
    return this;
  }

   /**
   * Specifies whether the payment method will be the default payment method of the customer account that owns the payment method. Only applicable if the &#x60;accountKey&#x60; field is set. 
   * @return makeDefault
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "false", value = "Specifies whether the payment method will be the default payment method of the customer account that owns the payment method. Only applicable if the `accountKey` field is set. ")

  public Boolean getMakeDefault() {
    return makeDefault;
  }


  public void setMakeDefault(Boolean makeDefault) {
    
    
    
    this.makeDefault = makeDefault;
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
   * @return the SignUpPaymentMethod instance itself
   */
  public SignUpPaymentMethod putAdditionalProperty(String key, Object value) {
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
    SignUpPaymentMethod signUpPaymentMethod = (SignUpPaymentMethod) o;
    return Objects.equals(this.type, signUpPaymentMethod.type) &&
        Objects.equals(this.secondTokenId, signUpPaymentMethod.secondTokenId) &&
        Objects.equals(this.tokenId, signUpPaymentMethod.tokenId) &&
        Objects.equals(this.BAID, signUpPaymentMethod.BAID) &&
        Objects.equals(this.email, signUpPaymentMethod.email) &&
        Objects.equals(this.preapprovalKey, signUpPaymentMethod.preapprovalKey) &&
        Objects.equals(this.cardHolderInfo, signUpPaymentMethod.cardHolderInfo) &&
        Objects.equals(this.cardNumber, signUpPaymentMethod.cardNumber) &&
        Objects.equals(this.cardType, signUpPaymentMethod.cardType) &&
        Objects.equals(this.checkDuplicated, signUpPaymentMethod.checkDuplicated) &&
        Objects.equals(this.expirationMonth, signUpPaymentMethod.expirationMonth) &&
        Objects.equals(this.expirationYear, signUpPaymentMethod.expirationYear) &&
        Objects.equals(this.mitConsentAgreementRef, signUpPaymentMethod.mitConsentAgreementRef) &&
        Objects.equals(this.mitConsentAgreementSrc, signUpPaymentMethod.mitConsentAgreementSrc) &&
        Objects.equals(this.mitNetworkTransactionId, signUpPaymentMethod.mitNetworkTransactionId) &&
        Objects.equals(this.mitProfileAction, signUpPaymentMethod.mitProfileAction) &&
        Objects.equals(this.mitProfileAgreedOn, signUpPaymentMethod.mitProfileAgreedOn) &&
        Objects.equals(this.mitProfileType, signUpPaymentMethod.mitProfileType) &&
        Objects.equals(this.securityCode, signUpPaymentMethod.securityCode) &&
        Objects.equals(this.accountKey, signUpPaymentMethod.accountKey) &&
        Objects.equals(this.authGateway, signUpPaymentMethod.authGateway) &&
        Objects.equals(this.ipAddress, signUpPaymentMethod.ipAddress) &&
        Objects.equals(this.makeDefault, signUpPaymentMethod.makeDefault)&&
        Objects.equals(this.additionalProperties, signUpPaymentMethod.additionalProperties);
  }

  @Override
  public int hashCode() {
    return Objects.hash(type, secondTokenId, tokenId, BAID, email, preapprovalKey, cardHolderInfo, cardNumber, cardType, checkDuplicated, expirationMonth, expirationYear, mitConsentAgreementRef, mitConsentAgreementSrc, mitNetworkTransactionId, mitProfileAction, mitProfileAgreedOn, mitProfileType, securityCode, accountKey, authGateway, ipAddress, makeDefault, additionalProperties);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SignUpPaymentMethod {\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    secondTokenId: ").append(toIndentedString(secondTokenId)).append("\n");
    sb.append("    tokenId: ").append(toIndentedString(tokenId)).append("\n");
    sb.append("    BAID: ").append(toIndentedString(BAID)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    preapprovalKey: ").append(toIndentedString(preapprovalKey)).append("\n");
    sb.append("    cardHolderInfo: ").append(toIndentedString(cardHolderInfo)).append("\n");
    sb.append("    cardNumber: ").append(toIndentedString(cardNumber)).append("\n");
    sb.append("    cardType: ").append(toIndentedString(cardType)).append("\n");
    sb.append("    checkDuplicated: ").append(toIndentedString(checkDuplicated)).append("\n");
    sb.append("    expirationMonth: ").append(toIndentedString(expirationMonth)).append("\n");
    sb.append("    expirationYear: ").append(toIndentedString(expirationYear)).append("\n");
    sb.append("    mitConsentAgreementRef: ").append(toIndentedString(mitConsentAgreementRef)).append("\n");
    sb.append("    mitConsentAgreementSrc: ").append(toIndentedString(mitConsentAgreementSrc)).append("\n");
    sb.append("    mitNetworkTransactionId: ").append(toIndentedString(mitNetworkTransactionId)).append("\n");
    sb.append("    mitProfileAction: ").append(toIndentedString(mitProfileAction)).append("\n");
    sb.append("    mitProfileAgreedOn: ").append(toIndentedString(mitProfileAgreedOn)).append("\n");
    sb.append("    mitProfileType: ").append(toIndentedString(mitProfileType)).append("\n");
    sb.append("    securityCode: ").append(toIndentedString(securityCode)).append("\n");
    sb.append("    accountKey: ").append(toIndentedString(accountKey)).append("\n");
    sb.append("    authGateway: ").append(toIndentedString(authGateway)).append("\n");
    sb.append("    ipAddress: ").append(toIndentedString(ipAddress)).append("\n");
    sb.append("    makeDefault: ").append(toIndentedString(makeDefault)).append("\n");
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
    openapiFields.add("type");
    openapiFields.add("secondTokenId");
    openapiFields.add("tokenId");
    openapiFields.add("BAID");
    openapiFields.add("email");
    openapiFields.add("preapprovalKey");
    openapiFields.add("cardHolderInfo");
    openapiFields.add("cardNumber");
    openapiFields.add("cardType");
    openapiFields.add("checkDuplicated");
    openapiFields.add("expirationMonth");
    openapiFields.add("expirationYear");
    openapiFields.add("mitConsentAgreementRef");
    openapiFields.add("mitConsentAgreementSrc");
    openapiFields.add("mitNetworkTransactionId");
    openapiFields.add("mitProfileAction");
    openapiFields.add("mitProfileAgreedOn");
    openapiFields.add("mitProfileType");
    openapiFields.add("securityCode");
    openapiFields.add("accountKey");
    openapiFields.add("authGateway");
    openapiFields.add("ipAddress");
    openapiFields.add("makeDefault");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
    openapiRequiredFields.add("type");
  }

 /**
  * Validates the JSON Object and throws an exception if issues found
  *
  * @param jsonObj JSON Object
  * @throws IOException if the JSON Object is invalid with respect to SignUpPaymentMethod
  */
  public static void validateJsonObject(JsonObject jsonObj) throws IOException {
      if (jsonObj == null) {
        if (!SignUpPaymentMethod.openapiRequiredFields.isEmpty()) { // has required fields but JSON object is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in SignUpPaymentMethod is not found in the empty JSON string", SignUpPaymentMethod.openapiRequiredFields.toString()));
        }
      }

      // check to make sure all required properties/fields are present in the JSON string
      for (String requiredField : SignUpPaymentMethod.openapiRequiredFields) {
        if (jsonObj.get(requiredField) == null) {
          throw new IllegalArgumentException(String.format("The required field `%s` is not found in the JSON string: %s", requiredField, jsonObj.toString()));
        }
      }
      if (!jsonObj.get("type").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `type` to be a primitive type in the JSON string but got `%s`", jsonObj.get("type").toString()));
      }
      if ((jsonObj.get("secondTokenId") != null && !jsonObj.get("secondTokenId").isJsonNull()) && !jsonObj.get("secondTokenId").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `secondTokenId` to be a primitive type in the JSON string but got `%s`", jsonObj.get("secondTokenId").toString()));
      }
      if ((jsonObj.get("tokenId") != null && !jsonObj.get("tokenId").isJsonNull()) && !jsonObj.get("tokenId").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `tokenId` to be a primitive type in the JSON string but got `%s`", jsonObj.get("tokenId").toString()));
      }
      if ((jsonObj.get("BAID") != null && !jsonObj.get("BAID").isJsonNull()) && !jsonObj.get("BAID").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `BAID` to be a primitive type in the JSON string but got `%s`", jsonObj.get("BAID").toString()));
      }
      if ((jsonObj.get("email") != null && !jsonObj.get("email").isJsonNull()) && !jsonObj.get("email").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `email` to be a primitive type in the JSON string but got `%s`", jsonObj.get("email").toString()));
      }
      if ((jsonObj.get("preapprovalKey") != null && !jsonObj.get("preapprovalKey").isJsonNull()) && !jsonObj.get("preapprovalKey").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `preapprovalKey` to be a primitive type in the JSON string but got `%s`", jsonObj.get("preapprovalKey").toString()));
      }
      // validate the optional field `cardHolderInfo`
      if (jsonObj.get("cardHolderInfo") != null && !jsonObj.get("cardHolderInfo").isJsonNull()) {
        SignUpCreatePaymentMethodCardholderInfo.validateJsonObject(jsonObj.getAsJsonObject("cardHolderInfo"));
      }
      if ((jsonObj.get("cardNumber") != null && !jsonObj.get("cardNumber").isJsonNull()) && !jsonObj.get("cardNumber").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `cardNumber` to be a primitive type in the JSON string but got `%s`", jsonObj.get("cardNumber").toString()));
      }
      if ((jsonObj.get("cardType") != null && !jsonObj.get("cardType").isJsonNull()) && !jsonObj.get("cardType").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `cardType` to be a primitive type in the JSON string but got `%s`", jsonObj.get("cardType").toString()));
      }
      if ((jsonObj.get("expirationMonth") != null && !jsonObj.get("expirationMonth").isJsonNull()) && !jsonObj.get("expirationMonth").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `expirationMonth` to be a primitive type in the JSON string but got `%s`", jsonObj.get("expirationMonth").toString()));
      }
      if ((jsonObj.get("expirationYear") != null && !jsonObj.get("expirationYear").isJsonNull()) && !jsonObj.get("expirationYear").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `expirationYear` to be a primitive type in the JSON string but got `%s`", jsonObj.get("expirationYear").toString()));
      }
      if ((jsonObj.get("mitConsentAgreementRef") != null && !jsonObj.get("mitConsentAgreementRef").isJsonNull()) && !jsonObj.get("mitConsentAgreementRef").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `mitConsentAgreementRef` to be a primitive type in the JSON string but got `%s`", jsonObj.get("mitConsentAgreementRef").toString()));
      }
      if ((jsonObj.get("mitConsentAgreementSrc") != null && !jsonObj.get("mitConsentAgreementSrc").isJsonNull()) && !jsonObj.get("mitConsentAgreementSrc").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `mitConsentAgreementSrc` to be a primitive type in the JSON string but got `%s`", jsonObj.get("mitConsentAgreementSrc").toString()));
      }
      if ((jsonObj.get("mitNetworkTransactionId") != null && !jsonObj.get("mitNetworkTransactionId").isJsonNull()) && !jsonObj.get("mitNetworkTransactionId").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `mitNetworkTransactionId` to be a primitive type in the JSON string but got `%s`", jsonObj.get("mitNetworkTransactionId").toString()));
      }
      if ((jsonObj.get("mitProfileAction") != null && !jsonObj.get("mitProfileAction").isJsonNull()) && !jsonObj.get("mitProfileAction").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `mitProfileAction` to be a primitive type in the JSON string but got `%s`", jsonObj.get("mitProfileAction").toString()));
      }
      if ((jsonObj.get("mitProfileType") != null && !jsonObj.get("mitProfileType").isJsonNull()) && !jsonObj.get("mitProfileType").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `mitProfileType` to be a primitive type in the JSON string but got `%s`", jsonObj.get("mitProfileType").toString()));
      }
      if ((jsonObj.get("securityCode") != null && !jsonObj.get("securityCode").isJsonNull()) && !jsonObj.get("securityCode").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `securityCode` to be a primitive type in the JSON string but got `%s`", jsonObj.get("securityCode").toString()));
      }
      if ((jsonObj.get("accountKey") != null && !jsonObj.get("accountKey").isJsonNull()) && !jsonObj.get("accountKey").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `accountKey` to be a primitive type in the JSON string but got `%s`", jsonObj.get("accountKey").toString()));
      }
      if ((jsonObj.get("authGateway") != null && !jsonObj.get("authGateway").isJsonNull()) && !jsonObj.get("authGateway").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `authGateway` to be a primitive type in the JSON string but got `%s`", jsonObj.get("authGateway").toString()));
      }
      if ((jsonObj.get("ipAddress") != null && !jsonObj.get("ipAddress").isJsonNull()) && !jsonObj.get("ipAddress").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `ipAddress` to be a primitive type in the JSON string but got `%s`", jsonObj.get("ipAddress").toString()));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!SignUpPaymentMethod.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'SignUpPaymentMethod' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<SignUpPaymentMethod> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(SignUpPaymentMethod.class));

       return (TypeAdapter<T>) new TypeAdapter<SignUpPaymentMethod>() {
           @Override
           public void write(JsonWriter out, SignUpPaymentMethod value) throws IOException {
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
           public SignUpPaymentMethod read(JsonReader in) throws IOException {
             JsonObject jsonObj = elementAdapter.read(in).getAsJsonObject();
             validateJsonObject(jsonObj);
             // store additional fields in the deserialized instance
             SignUpPaymentMethod instance = thisAdapter.fromJsonTree(jsonObj);
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
  * Create an instance of SignUpPaymentMethod given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of SignUpPaymentMethod
  * @throws IOException if the JSON string is invalid with respect to SignUpPaymentMethod
  */
  public static SignUpPaymentMethod fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, SignUpPaymentMethod.class);
  }

 /**
  * Convert an instance of SignUpPaymentMethod to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

