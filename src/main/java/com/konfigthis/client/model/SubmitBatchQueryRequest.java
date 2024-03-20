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
import com.konfigthis.client.model.BatchQuery;
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
 * SubmitBatchQueryRequest
 */@javax.annotation.Generated(value = "Generated by https://konfigthis.com")
public class SubmitBatchQueryRequest {
  public static final String SERIALIZED_NAME_VERSION = "version";
  @SerializedName(SERIALIZED_NAME_VERSION)
  private Float version;

  public static final String SERIALIZED_NAME_DATE_TIME_UTC = "dateTimeUtc";
  @SerializedName(SERIALIZED_NAME_DATE_TIME_UTC)
  private Boolean dateTimeUtc;

  /**
   * The format of the query. The default value is &#x60;csv&#x60;. 
   */
  @JsonAdapter(FormatEnum.Adapter.class)
 public enum FormatEnum {
    CSV("csv"),
    
    ZIP("zip"),
    
    GZIP("gzip");

    private String value;

    FormatEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static FormatEnum fromValue(String value) {
      for (FormatEnum b : FormatEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<FormatEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final FormatEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public FormatEnum read(final JsonReader jsonReader) throws IOException {
        String value =  jsonReader.nextString();
        return FormatEnum.fromValue(value);
      }
    }
  }

  public static final String SERIALIZED_NAME_FORMAT = "format";
  @SerializedName(SERIALIZED_NAME_FORMAT)
  private FormatEnum format;

  public static final String SERIALIZED_NAME_INCREMENTAL_TIME = "incrementalTime";
  @SerializedName(SERIALIZED_NAME_INCREMENTAL_TIME)
  private String incrementalTime;

  public static final String SERIALIZED_NAME_NAME = "name";
  @SerializedName(SERIALIZED_NAME_NAME)
  private String name;

  public static final String SERIALIZED_NAME_NOTIFY_URL = "notifyUrl";
  @SerializedName(SERIALIZED_NAME_NOTIFY_URL)
  private String notifyUrl;

  public static final String SERIALIZED_NAME_NULL_REPLACEMENT = "nullReplacement";
  @SerializedName(SERIALIZED_NAME_NULL_REPLACEMENT)
  private String nullReplacement;

  public static final String SERIALIZED_NAME_OFFSET = "offset";
  @SerializedName(SERIALIZED_NAME_OFFSET)
  private Double offset = 0d;

  public static final String SERIALIZED_NAME_PARTNER = "partner";
  @SerializedName(SERIALIZED_NAME_PARTNER)
  private String partner;

  public static final String SERIALIZED_NAME_PROJECT = "project";
  @SerializedName(SERIALIZED_NAME_PROJECT)
  private String project;

  public static final String SERIALIZED_NAME_QUERIES = "queries";
  @SerializedName(SERIALIZED_NAME_QUERIES)
  private List<BatchQuery> queries = null;

  /**
   * Specify the source this aggregate query runs against:  * &#x60;LIVE&#x60; represents the live transactional databases at Zuora (Data Query Live).  * &#x60;WAREHOUSE&#x60; represents Zuora Warehouse, which has better performance and fewer limitations than the live transactional database. This option is available only if you have the Zuora Warehouse feature enabled in your tenant. For more information, see &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Central_Platform/Zuora_Warehouse/A_Zuora_Warehouse_overview\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Zuora Warehouse&lt;/a&gt;. &lt;br&gt;If this option is selected, you can specify warehouse size in &#x60;warehouseSize&#x60;.  If this field is not specified, the default value &#x60;LIVE&#x60; will be used. 
   */
  @JsonAdapter(SourceDataEnum.Adapter.class)
 public enum SourceDataEnum {
    LIVE("LIVE"),
    
    WAREHOUSE("WAREHOUSE");

    private String value;

    SourceDataEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static SourceDataEnum fromValue(String value) {
      for (SourceDataEnum b : SourceDataEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<SourceDataEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final SourceDataEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public SourceDataEnum read(final JsonReader jsonReader) throws IOException {
        String value =  jsonReader.nextString();
        return SourceDataEnum.fromValue(value);
      }
    }
  }

  public static final String SERIALIZED_NAME_SOURCE_DATA = "sourceData";
  @SerializedName(SERIALIZED_NAME_SOURCE_DATA)
  private SourceDataEnum sourceData;

  public static final String SERIALIZED_NAME_USE_QUERY_LABELS = "useQueryLabels";
  @SerializedName(SERIALIZED_NAME_USE_QUERY_LABELS)
  private Boolean useQueryLabels;

  /**
   * Specify the size of Zuora Warehouse. This field is available only if the &#x60;sourceData&#x60; is &#x60;WAREHOUSE&#x60;.  If this field is not specified or set to &#x60;NULL&#x60;, the default value &#x60;xsmall&#x60; will be used. 
   */
  @JsonAdapter(WarehouseSizeEnum.Adapter.class)
 public enum WarehouseSizeEnum {
    XSMALL("xsmall"),
    
    NULL("NULL");

    private String value;

    WarehouseSizeEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static WarehouseSizeEnum fromValue(String value) {
      for (WarehouseSizeEnum b : WarehouseSizeEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<WarehouseSizeEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final WarehouseSizeEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public WarehouseSizeEnum read(final JsonReader jsonReader) throws IOException {
        String value =  jsonReader.nextString();
        return WarehouseSizeEnum.fromValue(value);
      }
    }
  }

  public static final String SERIALIZED_NAME_WAREHOUSE_SIZE = "warehouseSize";
  @SerializedName(SERIALIZED_NAME_WAREHOUSE_SIZE)
  private WarehouseSizeEnum warehouseSize;

  public SubmitBatchQueryRequest() {
  }

  public SubmitBatchQueryRequest version(Float version) {
    
    
    
    
    this.version = version;
    return this;
  }

   /**
   * The API version you want to use.   The supported versions are as follows:   - &#x60;1.1&#x60;. It supports both modes   - &#x60;1.0&#x60;. Default. It supports stateless modes only.  See &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Central_Platform/API/AB_Aggregate_Query_API/BA_Stateless_and_Stateful_Modes\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Stateless and stateful modes&lt;/a&gt; for more information. 
   * @return version
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "1.1", value = "The API version you want to use.   The supported versions are as follows:   - `1.1`. It supports both modes   - `1.0`. Default. It supports stateless modes only.  See <a href=\"https://knowledgecenter.zuora.com/Zuora_Central_Platform/API/AB_Aggregate_Query_API/BA_Stateless_and_Stateful_Modes\" target=\"_blank\">Stateless and stateful modes</a> for more information. ")

  public Float getVersion() {
    return version;
  }


  public void setVersion(Float version) {
    
    
    
    this.version = version;
  }


  public SubmitBatchQueryRequest dateTimeUtc(Boolean dateTimeUtc) {
    
    
    
    
    this.dateTimeUtc = dateTimeUtc;
    return this;
  }

   /**
   * When using WSDL 69 and later you can ensure that the exported output of dateTime records are rendered according to ISO-8601 generic UTC form by setting &#x60;dateTimeUtc&#x60; to &#x60;true&#x60;.  When &#x60;dateTimeUtc&#x60; is set to &#x60;true&#x60;, exports of dateTime data types will be rendered in the following generic format: &#x60;YYYY-MM-DDThh:mm:ss-hhmm&#x60; or &#x60;YYYY-MM-DDThh:mm:ss+hhmm&#x60;.  **Note**: Regardless of what batchType query is used (&#x60;zoql&#x60; or &#x60;zoqlexport&#x60;), the query response output for datetime data types can be standardized by setting dateTimeUtc to &#x60;true&#x60;. When &#x60;true&#x60;, the results will display datetime types with the format: YYYY-MM-DDThh:mm:ss+/-hhmm. 
   * @return dateTimeUtc
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "true", value = "When using WSDL 69 and later you can ensure that the exported output of dateTime records are rendered according to ISO-8601 generic UTC form by setting `dateTimeUtc` to `true`.  When `dateTimeUtc` is set to `true`, exports of dateTime data types will be rendered in the following generic format: `YYYY-MM-DDThh:mm:ss-hhmm` or `YYYY-MM-DDThh:mm:ss+hhmm`.  **Note**: Regardless of what batchType query is used (`zoql` or `zoqlexport`), the query response output for datetime data types can be standardized by setting dateTimeUtc to `true`. When `true`, the results will display datetime types with the format: YYYY-MM-DDThh:mm:ss+/-hhmm. ")

  public Boolean getDateTimeUtc() {
    return dateTimeUtc;
  }


  public void setDateTimeUtc(Boolean dateTimeUtc) {
    
    
    
    this.dateTimeUtc = dateTimeUtc;
  }


  public SubmitBatchQueryRequest format(FormatEnum format) {
    
    
    
    
    this.format = format;
    return this;
  }

   /**
   * The format of the query. The default value is &#x60;csv&#x60;. 
   * @return format
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "CSV", value = "The format of the query. The default value is `csv`. ")

  public FormatEnum getFormat() {
    return format;
  }


  public void setFormat(FormatEnum format) {
    
    
    
    this.format = format;
  }


  public SubmitBatchQueryRequest incrementalTime(String incrementalTime) {
    
    
    
    
    this.incrementalTime = incrementalTime;
    return this;
  }

   /**
   * Allows you to override the time from which a Stateful AQuA job incrementally retrieves records that have been created or modified, using the &#x60;incrementalTime&#x60; parameter. For example, if you set &#x60;incrementalTime&#x60; &#x3D; &#x60;2015-01-21 10:30:01&#x60;, AQuA will retrieve records that have created or modified beginning at 10:30:01. If this parameter is not set, AQuA continues to use the Start Time of the last AQuA session to retrieve records incrementally.  The time zone of &#x60;incrementalTime&#x60; depends on which Zuora data center you use. For US Data Center customers, the time zone of &#x60;incrementalTime&#x60; is Pacific Time. For EU Data Center customers, the time zone of &#x60;incrementalTime&#x60; is UTC. If the time zone of your system is different from the time zone of &#x60;incrementalTime&#x60;, you will need to convert to the appropriate time zone before setting &#x60;incrementalTime&#x60;.  **Note**: This field can only be used in Stateful AQuA mode. 
   * @return incrementalTime
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Allows you to override the time from which a Stateful AQuA job incrementally retrieves records that have been created or modified, using the `incrementalTime` parameter. For example, if you set `incrementalTime` = `2015-01-21 10:30:01`, AQuA will retrieve records that have created or modified beginning at 10:30:01. If this parameter is not set, AQuA continues to use the Start Time of the last AQuA session to retrieve records incrementally.  The time zone of `incrementalTime` depends on which Zuora data center you use. For US Data Center customers, the time zone of `incrementalTime` is Pacific Time. For EU Data Center customers, the time zone of `incrementalTime` is UTC. If the time zone of your system is different from the time zone of `incrementalTime`, you will need to convert to the appropriate time zone before setting `incrementalTime`.  **Note**: This field can only be used in Stateful AQuA mode. ")

  public String getIncrementalTime() {
    return incrementalTime;
  }


  public void setIncrementalTime(String incrementalTime) {
    
    
    
    this.incrementalTime = incrementalTime;
  }


  public SubmitBatchQueryRequest name(String name) {
    
    
    
    
    this.name = name;
    return this;
  }

   /**
   * The name of the job. 32 character limit. 
   * @return name
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "Example", value = "The name of the job. 32 character limit. ")

  public String getName() {
    return name;
  }


  public void setName(String name) {
    
    
    
    this.name = name;
  }


  public SubmitBatchQueryRequest notifyUrl(String notifyUrl) {
    
    
    
    
    this.notifyUrl = notifyUrl;
    return this;
  }

   /**
   * If URL is provided, the AQuA job will call this &#x60;notifyUrl&#x60; once the job has completed. The value of &#x60;notifyUrl&#x60; needs to have &#x60;${JOBID}&#x60; and &#x60;${STATUS}&#x60; placeholders. These placeholders will be replaced by the actual job ID and status when returned in the response. Status will be &#x60;Completed&#x60; after the AQuA job is done.  If you submit an AQuA query with &#x60;notifyUrl&#x60; specified, the value of &#x60;notifyUrl&#x60; will be ignored if your organization has already &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Central_Platform/API/AB_Aggregate_Query_API/Callout_Notification_for_Completed_AQuA_Jobs\&quot; target&#x3D;\&quot;_blank\&quot;&gt;configured a callout notification through the Zuora user interface&lt;/a&gt;.  
   * @return notifyUrl
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "If URL is provided, the AQuA job will call this `notifyUrl` once the job has completed. The value of `notifyUrl` needs to have `${JOBID}` and `${STATUS}` placeholders. These placeholders will be replaced by the actual job ID and status when returned in the response. Status will be `Completed` after the AQuA job is done.  If you submit an AQuA query with `notifyUrl` specified, the value of `notifyUrl` will be ignored if your organization has already <a href=\"https://knowledgecenter.zuora.com/Zuora_Central_Platform/API/AB_Aggregate_Query_API/Callout_Notification_for_Completed_AQuA_Jobs\" target=\"_blank\">configured a callout notification through the Zuora user interface</a>.  ")

  public String getNotifyUrl() {
    return notifyUrl;
  }


  public void setNotifyUrl(String notifyUrl) {
    
    
    
    this.notifyUrl = notifyUrl;
  }


  public SubmitBatchQueryRequest nullReplacement(String nullReplacement) {
    
    
    
    
    this.nullReplacement = nullReplacement;
    return this;
  }

   /**
   * The string used to represent null values in the query results. If you do not set this parameter, null values are represented by the empty string in the query results. 
   * @return nullReplacement
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The string used to represent null values in the query results. If you do not set this parameter, null values are represented by the empty string in the query results. ")

  public String getNullReplacement() {
    return nullReplacement;
  }


  public void setNullReplacement(String nullReplacement) {
    
    
    
    this.nullReplacement = nullReplacement;
  }


  public SubmitBatchQueryRequest offset(Double offset) {
    
    
    
    
    this.offset = offset;
    return this;
  }

  public SubmitBatchQueryRequest offset(Integer offset) {
    
    
    
    
    this.offset = offset.doubleValue();
    return this;
  }

   /**
   * This field specifies the time offset for AQuA queries in stateful mode. It is an integer in the range 0 to 3,600 seconds.  For example, if you set this field to 600 seconds and you post a query in stateful mode at 2:00 AM, it will query against data created or updated between the completion time of the previous query and 1:50 AM.  The value of this field will override the value you configured in **Settings** &gt; **Administration** &gt; **AQuA API Stateful Mode Time Offset**.         
   * @return offset
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "0", value = "This field specifies the time offset for AQuA queries in stateful mode. It is an integer in the range 0 to 3,600 seconds.  For example, if you set this field to 600 seconds and you post a query in stateful mode at 2:00 AM, it will query against data created or updated between the completion time of the previous query and 1:50 AM.  The value of this field will override the value you configured in **Settings** > **Administration** > **AQuA API Stateful Mode Time Offset**.         ")

  public Double getOffset() {
    return offset;
  }


  public void setOffset(Double offset) {
    
    
    
    this.offset = offset;
  }


  public SubmitBatchQueryRequest partner(String partner) {
    
    
    
    
    this.partner = partner;
    return this;
  }

   /**
   * The partner field indicates the unique ID of a data integration partner. The dropdown list of this field displays partner IDs for the past thirty days. It must be used together with \&quot;project\&quot; field to uniquely identify a data integration target.  For example, if a continuous AQuA session is to retrieve data incrementally for a Salesforce.com Org 00170000011K3Ub, you can use partner as \&quot;Salesforce\&quot;, and \&quot;project\&quot; as \&quot;00170000011K3Ub.\&quot;  This field is required only if you are using AQuA in stateful mode. Otherwise, if you are using AQuA in stateless mode, partner field can be null.  **Note**: Zuora highly recommends you use the stateless mode instead of the stateful mode to extract bulk data. See &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Central_Platform/API/AB_Aggregate_Query_API/Bulk_data__extraction_from_Zuora_using_AQuA\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Bulk data extraction from Zuora using AQuA&lt;/a&gt; for best practices. **Note**: Submit a request at &lt;a href&#x3D;\&quot;http://support.zuora.com\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Zuora Global Support&lt;/a&gt; to obtain a partner ID. 
   * @return partner
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "salesforce", value = "The partner field indicates the unique ID of a data integration partner. The dropdown list of this field displays partner IDs for the past thirty days. It must be used together with \"project\" field to uniquely identify a data integration target.  For example, if a continuous AQuA session is to retrieve data incrementally for a Salesforce.com Org 00170000011K3Ub, you can use partner as \"Salesforce\", and \"project\" as \"00170000011K3Ub.\"  This field is required only if you are using AQuA in stateful mode. Otherwise, if you are using AQuA in stateless mode, partner field can be null.  **Note**: Zuora highly recommends you use the stateless mode instead of the stateful mode to extract bulk data. See <a href=\"https://knowledgecenter.zuora.com/Zuora_Central_Platform/API/AB_Aggregate_Query_API/Bulk_data__extraction_from_Zuora_using_AQuA\" target=\"_blank\">Bulk data extraction from Zuora using AQuA</a> for best practices. **Note**: Submit a request at <a href=\"http://support.zuora.com\" target=\"_blank\">Zuora Global Support</a> to obtain a partner ID. ")

  public String getPartner() {
    return partner;
  }


  public void setPartner(String partner) {
    
    
    
    this.partner = partner;
  }


  public SubmitBatchQueryRequest project(String project) {
    
    
    
    
    this.project = project;
    return this;
  }

   /**
   * The project field contains the unique ID of a data integration project for a particular partner. The dropdown list of this field displays project IDs for the past thirty days.  This field must be used together with partner field to uniquely identify a data integration target.   This field is required only if you are using AQuA in stateful mode. Otherwise, if you are using AQuA in stateless mode, partner field can be null. 
   * @return project
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "00170000011K3Ub", value = "The project field contains the unique ID of a data integration project for a particular partner. The dropdown list of this field displays project IDs for the past thirty days.  This field must be used together with partner field to uniquely identify a data integration target.   This field is required only if you are using AQuA in stateful mode. Otherwise, if you are using AQuA in stateless mode, partner field can be null. ")

  public String getProject() {
    return project;
  }


  public void setProject(String project) {
    
    
    
    this.project = project;
  }


  public SubmitBatchQueryRequest queries(List<BatchQuery> queries) {
    
    
    
    
    this.queries = queries;
    return this;
  }

  public SubmitBatchQueryRequest addQueriesItem(BatchQuery queriesItem) {
    if (this.queries == null) {
      this.queries = new ArrayList<>();
    }
    this.queries.add(queriesItem);
    return this;
  }

   /**
   * A JSON array object that contains a list of batch objects. 
   * @return queries
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "A JSON array object that contains a list of batch objects. ")

  public List<BatchQuery> getQueries() {
    return queries;
  }


  public void setQueries(List<BatchQuery> queries) {
    
    
    
    this.queries = queries;
  }


  public SubmitBatchQueryRequest sourceData(SourceDataEnum sourceData) {
    
    
    
    
    this.sourceData = sourceData;
    return this;
  }

   /**
   * Specify the source this aggregate query runs against:  * &#x60;LIVE&#x60; represents the live transactional databases at Zuora (Data Query Live).  * &#x60;WAREHOUSE&#x60; represents Zuora Warehouse, which has better performance and fewer limitations than the live transactional database. This option is available only if you have the Zuora Warehouse feature enabled in your tenant. For more information, see &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Central_Platform/Zuora_Warehouse/A_Zuora_Warehouse_overview\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Zuora Warehouse&lt;/a&gt;. &lt;br&gt;If this option is selected, you can specify warehouse size in &#x60;warehouseSize&#x60;.  If this field is not specified, the default value &#x60;LIVE&#x60; will be used. 
   * @return sourceData
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "LIVE", value = "Specify the source this aggregate query runs against:  * `LIVE` represents the live transactional databases at Zuora (Data Query Live).  * `WAREHOUSE` represents Zuora Warehouse, which has better performance and fewer limitations than the live transactional database. This option is available only if you have the Zuora Warehouse feature enabled in your tenant. For more information, see <a href=\"https://knowledgecenter.zuora.com/Zuora_Central_Platform/Zuora_Warehouse/A_Zuora_Warehouse_overview\" target=\"_blank\">Zuora Warehouse</a>. <br>If this option is selected, you can specify warehouse size in `warehouseSize`.  If this field is not specified, the default value `LIVE` will be used. ")

  public SourceDataEnum getSourceData() {
    return sourceData;
  }


  public void setSourceData(SourceDataEnum sourceData) {
    
    
    
    this.sourceData = sourceData;
  }


  public SubmitBatchQueryRequest useQueryLabels(Boolean useQueryLabels) {
    
    
    
    
    this.useQueryLabels = useQueryLabels;
    return this;
  }

   /**
   * When this optional flag is set to &#x60;true&#x60; the request will use object and field API names for the CSV header output instead of the field labels. Data integration projects should set &#x60;useQueryLabels&#x60; to &#x60;true&#x60; so that API names remain the same.  By default &#x60;useQueryLabels&#x60; is &#x60;false&#x60;, so that output CSV headers display the more user-friendly object and field labels.  
   * @return useQueryLabels
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "true", value = "When this optional flag is set to `true` the request will use object and field API names for the CSV header output instead of the field labels. Data integration projects should set `useQueryLabels` to `true` so that API names remain the same.  By default `useQueryLabels` is `false`, so that output CSV headers display the more user-friendly object and field labels.  ")

  public Boolean getUseQueryLabels() {
    return useQueryLabels;
  }


  public void setUseQueryLabels(Boolean useQueryLabels) {
    
    
    
    this.useQueryLabels = useQueryLabels;
  }


  public SubmitBatchQueryRequest warehouseSize(WarehouseSizeEnum warehouseSize) {
    
    
    
    
    this.warehouseSize = warehouseSize;
    return this;
  }

   /**
   * Specify the size of Zuora Warehouse. This field is available only if the &#x60;sourceData&#x60; is &#x60;WAREHOUSE&#x60;.  If this field is not specified or set to &#x60;NULL&#x60;, the default value &#x60;xsmall&#x60; will be used. 
   * @return warehouseSize
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Specify the size of Zuora Warehouse. This field is available only if the `sourceData` is `WAREHOUSE`.  If this field is not specified or set to `NULL`, the default value `xsmall` will be used. ")

  public WarehouseSizeEnum getWarehouseSize() {
    return warehouseSize;
  }


  public void setWarehouseSize(WarehouseSizeEnum warehouseSize) {
    
    
    
    this.warehouseSize = warehouseSize;
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
   * @return the SubmitBatchQueryRequest instance itself
   */
  public SubmitBatchQueryRequest putAdditionalProperty(String key, Object value) {
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
    SubmitBatchQueryRequest submitBatchQueryRequest = (SubmitBatchQueryRequest) o;
    return Objects.equals(this.version, submitBatchQueryRequest.version) &&
        Objects.equals(this.dateTimeUtc, submitBatchQueryRequest.dateTimeUtc) &&
        Objects.equals(this.format, submitBatchQueryRequest.format) &&
        Objects.equals(this.incrementalTime, submitBatchQueryRequest.incrementalTime) &&
        Objects.equals(this.name, submitBatchQueryRequest.name) &&
        Objects.equals(this.notifyUrl, submitBatchQueryRequest.notifyUrl) &&
        Objects.equals(this.nullReplacement, submitBatchQueryRequest.nullReplacement) &&
        Objects.equals(this.offset, submitBatchQueryRequest.offset) &&
        Objects.equals(this.partner, submitBatchQueryRequest.partner) &&
        Objects.equals(this.project, submitBatchQueryRequest.project) &&
        Objects.equals(this.queries, submitBatchQueryRequest.queries) &&
        Objects.equals(this.sourceData, submitBatchQueryRequest.sourceData) &&
        Objects.equals(this.useQueryLabels, submitBatchQueryRequest.useQueryLabels) &&
        Objects.equals(this.warehouseSize, submitBatchQueryRequest.warehouseSize)&&
        Objects.equals(this.additionalProperties, submitBatchQueryRequest.additionalProperties);
  }

  @Override
  public int hashCode() {
    return Objects.hash(version, dateTimeUtc, format, incrementalTime, name, notifyUrl, nullReplacement, offset, partner, project, queries, sourceData, useQueryLabels, warehouseSize, additionalProperties);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SubmitBatchQueryRequest {\n");
    sb.append("    version: ").append(toIndentedString(version)).append("\n");
    sb.append("    dateTimeUtc: ").append(toIndentedString(dateTimeUtc)).append("\n");
    sb.append("    format: ").append(toIndentedString(format)).append("\n");
    sb.append("    incrementalTime: ").append(toIndentedString(incrementalTime)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    notifyUrl: ").append(toIndentedString(notifyUrl)).append("\n");
    sb.append("    nullReplacement: ").append(toIndentedString(nullReplacement)).append("\n");
    sb.append("    offset: ").append(toIndentedString(offset)).append("\n");
    sb.append("    partner: ").append(toIndentedString(partner)).append("\n");
    sb.append("    project: ").append(toIndentedString(project)).append("\n");
    sb.append("    queries: ").append(toIndentedString(queries)).append("\n");
    sb.append("    sourceData: ").append(toIndentedString(sourceData)).append("\n");
    sb.append("    useQueryLabels: ").append(toIndentedString(useQueryLabels)).append("\n");
    sb.append("    warehouseSize: ").append(toIndentedString(warehouseSize)).append("\n");
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
    openapiFields.add("version");
    openapiFields.add("dateTimeUtc");
    openapiFields.add("format");
    openapiFields.add("incrementalTime");
    openapiFields.add("name");
    openapiFields.add("notifyUrl");
    openapiFields.add("nullReplacement");
    openapiFields.add("offset");
    openapiFields.add("partner");
    openapiFields.add("project");
    openapiFields.add("queries");
    openapiFields.add("sourceData");
    openapiFields.add("useQueryLabels");
    openapiFields.add("warehouseSize");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
  }

 /**
  * Validates the JSON Object and throws an exception if issues found
  *
  * @param jsonObj JSON Object
  * @throws IOException if the JSON Object is invalid with respect to SubmitBatchQueryRequest
  */
  public static void validateJsonObject(JsonObject jsonObj) throws IOException {
      if (jsonObj == null) {
        if (!SubmitBatchQueryRequest.openapiRequiredFields.isEmpty()) { // has required fields but JSON object is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in SubmitBatchQueryRequest is not found in the empty JSON string", SubmitBatchQueryRequest.openapiRequiredFields.toString()));
        }
      }
      if ((jsonObj.get("format") != null && !jsonObj.get("format").isJsonNull()) && !jsonObj.get("format").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `format` to be a primitive type in the JSON string but got `%s`", jsonObj.get("format").toString()));
      }
      if ((jsonObj.get("incrementalTime") != null && !jsonObj.get("incrementalTime").isJsonNull()) && !jsonObj.get("incrementalTime").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `incrementalTime` to be a primitive type in the JSON string but got `%s`", jsonObj.get("incrementalTime").toString()));
      }
      if ((jsonObj.get("name") != null && !jsonObj.get("name").isJsonNull()) && !jsonObj.get("name").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `name` to be a primitive type in the JSON string but got `%s`", jsonObj.get("name").toString()));
      }
      if ((jsonObj.get("notifyUrl") != null && !jsonObj.get("notifyUrl").isJsonNull()) && !jsonObj.get("notifyUrl").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `notifyUrl` to be a primitive type in the JSON string but got `%s`", jsonObj.get("notifyUrl").toString()));
      }
      if ((jsonObj.get("nullReplacement") != null && !jsonObj.get("nullReplacement").isJsonNull()) && !jsonObj.get("nullReplacement").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `nullReplacement` to be a primitive type in the JSON string but got `%s`", jsonObj.get("nullReplacement").toString()));
      }
      if ((jsonObj.get("partner") != null && !jsonObj.get("partner").isJsonNull()) && !jsonObj.get("partner").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `partner` to be a primitive type in the JSON string but got `%s`", jsonObj.get("partner").toString()));
      }
      if ((jsonObj.get("project") != null && !jsonObj.get("project").isJsonNull()) && !jsonObj.get("project").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `project` to be a primitive type in the JSON string but got `%s`", jsonObj.get("project").toString()));
      }
      if (jsonObj.get("queries") != null && !jsonObj.get("queries").isJsonNull()) {
        JsonArray jsonArrayqueries = jsonObj.getAsJsonArray("queries");
        if (jsonArrayqueries != null) {
          // ensure the json data is an array
          if (!jsonObj.get("queries").isJsonArray()) {
            throw new IllegalArgumentException(String.format("Expected the field `queries` to be an array in the JSON string but got `%s`", jsonObj.get("queries").toString()));
          }

          // validate the optional field `queries` (array)
          for (int i = 0; i < jsonArrayqueries.size(); i++) {
            BatchQuery.validateJsonObject(jsonArrayqueries.get(i).getAsJsonObject());
          };
        }
      }
      if ((jsonObj.get("sourceData") != null && !jsonObj.get("sourceData").isJsonNull()) && !jsonObj.get("sourceData").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `sourceData` to be a primitive type in the JSON string but got `%s`", jsonObj.get("sourceData").toString()));
      }
      if ((jsonObj.get("warehouseSize") != null && !jsonObj.get("warehouseSize").isJsonNull()) && !jsonObj.get("warehouseSize").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `warehouseSize` to be a primitive type in the JSON string but got `%s`", jsonObj.get("warehouseSize").toString()));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!SubmitBatchQueryRequest.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'SubmitBatchQueryRequest' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<SubmitBatchQueryRequest> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(SubmitBatchQueryRequest.class));

       return (TypeAdapter<T>) new TypeAdapter<SubmitBatchQueryRequest>() {
           @Override
           public void write(JsonWriter out, SubmitBatchQueryRequest value) throws IOException {
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
           public SubmitBatchQueryRequest read(JsonReader in) throws IOException {
             JsonObject jsonObj = elementAdapter.read(in).getAsJsonObject();
             validateJsonObject(jsonObj);
             // store additional fields in the deserialized instance
             SubmitBatchQueryRequest instance = thisAdapter.fromJsonTree(jsonObj);
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
  * Create an instance of SubmitBatchQueryRequest given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of SubmitBatchQueryRequest
  * @throws IOException if the JSON string is invalid with respect to SubmitBatchQueryRequest
  */
  public static SubmitBatchQueryRequest fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, SubmitBatchQueryRequest.class);
  }

 /**
  * Convert an instance of SubmitBatchQueryRequest to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

