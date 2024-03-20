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


package com.konfigthis.client.api;

import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.model.CommonResponse;
import com.konfigthis.client.model.CreateOrderNewAccount;
import com.konfigthis.client.model.GetAllOrdersResponseType;
import com.konfigthis.client.model.GetJobStatusAndResponseResponse;
import com.konfigthis.client.model.GetOrderResponse;
import com.konfigthis.client.model.GetOrdersResponse;
import java.time.LocalDate;
import com.konfigthis.client.model.OrderLineItemCommonPostOrder;
import com.konfigthis.client.model.POSTOrderAsyncRequestType;
import com.konfigthis.client.model.POSTOrderPreviewAsyncRequestType;
import com.konfigthis.client.model.POSTOrderPreviewRequestType;
import com.konfigthis.client.model.POSTOrderPreviewRequestTypeSubscriptionsInner;
import com.konfigthis.client.model.POSTOrderRequestType;
import com.konfigthis.client.model.POSTOrderRequestTypeSchedulingOptions;
import com.konfigthis.client.model.POSTOrderRequestTypeSubscriptionsInner;
import com.konfigthis.client.model.PUTOrderActionTriggerDatesRequestType;
import com.konfigthis.client.model.PUTOrderActionTriggerDatesRequestTypeSubscriptionsInner;
import com.konfigthis.client.model.PUTOrderPatchRequestType;
import com.konfigthis.client.model.PUTOrderPatchRequestTypeSubscriptionsInner;
import com.konfigthis.client.model.PUTOrderRequestType;
import com.konfigthis.client.model.PUTOrderTriggerDatesResponseType;
import com.konfigthis.client.model.PUTSubscriptionPatchRequestType;
import com.konfigthis.client.model.PUTSubscriptionPatchRequestTypeRatePlansInner;
import com.konfigthis.client.model.PostCreateOrderAsynchronouslyResponse;
import com.konfigthis.client.model.PostOrderPreviewResponseType;
import com.konfigthis.client.model.PostOrderResponseType;
import com.konfigthis.client.model.PostPreviewOrderAsynchronouslyResponse;
import com.konfigthis.client.model.PreviewAccountInfo;
import com.konfigthis.client.model.PreviewOptions;
import com.konfigthis.client.model.ProcessingOptionsOrders;
import com.konfigthis.client.model.ProcessingOptionsOrdersAsync;
import com.konfigthis.client.model.ProcessingOptionsOrdersWithDelayedCapturePayment;
import com.konfigthis.client.model.PutOrderCancelRequest;
import com.konfigthis.client.model.PutOrderCancelResponse;
import java.util.UUID;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for OrdersApi
 */
@Disabled
public class OrdersApiTest {

    private static OrdersApi api;

    
    @BeforeAll
    public static void beforeClass() {
        ApiClient apiClient = Configuration.getDefaultApiClient();
        api = new OrdersApi(apiClient);
    }

    /**
     * List orders
     *
     * **Note:** This feature is only available if you have the [Order Metrics](https://knowledgecenter.zuora.com/BC_Subscription_Management/Orders/AA_Overview_of_Orders#Order_Metrics) feature enabled. As of Zuora Billing Release 284, Orders is generally available and the Order Metrics feature is no longer available as a standalone feature. If you are an existing Subscribe and Amend customer and want Order Metrics only, you must turn on [Orders Harmonization](https://knowledgecenter.zuora.com/Billing/Subscriptions/Orders/Orders_Harmonization/Orders_Harmonization). You can still keep the existing Subscribe and Amend API integrations to create and manage subscriptions.  **Note:** The [Order Line Items](https://knowledgecenter.zuora.com/Billing/Subscriptions/Orders/Order_Line_Items/AA_Overview_of_Order_Line_Items) feature is now generally available to all Zuora customers. You need to enable the [Orders](https://knowledgecenter.zuora.com/BC_Subscription_Management/Orders/AA_Overview_of_Orders#Orders) feature to access the [Order Line Items](https://knowledgecenter.zuora.com/Billing/Subscriptions/Orders/Order_Line_Items/AA_Overview_of_Order_Line_Items) feature. As of Zuora Billing Release 313 (November 2021), new customers who onboard on [Orders](https://knowledgecenter.zuora.com/Billing/Subscriptions/Orders/AA_Overview_of_Orders) will have the [Order Line Items](https://knowledgecenter.zuora.com/Billing/Subscriptions/Orders/Order_Line_Items) feature enabled by default.          Retrieves information about all orders in your tenant. You can set the &#x60;status&#x60; query parameter to an order status to retrieve orders in that order status. If you do not set a value for this query parameter, the query parameter has a default value &#x60;all&#x60;, and orders of all statuses are returned.  By default, it returns the first page of the orders.  
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void allOrdersTest() throws ApiException {
        String acceptEncoding = null;
        String contentEncoding = null;
        String authorization = null;
        String zuoraTrackId = null;
        String zuoraEntityIds = null;
        String zuoraOrgIds = null;
        Integer page = null;
        Integer pageSize = null;
        String dateFilterOption = null;
        LocalDate startDate = null;
        LocalDate endDate = null;
        String status = null;
        GetAllOrdersResponseType response = api.allOrders()
                .acceptEncoding(acceptEncoding)
                .contentEncoding(contentEncoding)
                .authorization(authorization)
                .zuoraTrackId(zuoraTrackId)
                .zuoraEntityIds(zuoraEntityIds)
                .zuoraOrgIds(zuoraOrgIds)
                .page(page)
                .pageSize(pageSize)
                .dateFilterOption(dateFilterOption)
                .startDate(startDate)
                .endDate(endDate)
                .status(status)
                .execute();
        // TODO: test validations
    }

    /**
     * Create an order asynchronously
     *
     * **Note:** This operation is only available if you have the [Orders](https://knowledgecenter.zuora.com/BC_Subscription_Management/Orders/AA_Overview_of_Orders#Orders) feature enabled. If you are an existing Zuora &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Subscriptions/Subscriptions/Subscribe_and_Amend\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Subscribe and Amend&lt;/a&gt; customer, we recommend you enable &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Subscriptions/Subscriptions/Orders_Harmonization/A_Overview_of_Orders_Harmonization\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Orders Harmonization&lt;/a&gt; to access the &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Subscriptions/Subscriptions/Orders/AA_Overview_of_Orders/A_Overview_of_Orders\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Orders&lt;/a&gt; feature. With Orders, you can access both existing functions for subscription and billing management and the &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Subscriptions/Subscriptions/Orders_Harmonization/P_FAQ_about_Orders_Harmonization#New+features+through+Orders\&quot; target&#x3D;\&quot;_blank\&quot;&gt;new features&lt;/a&gt; on Zuora Billing.  **Note:** The [Order Line Items](https://knowledgecenter.zuora.com/Billing/Subscriptions/Orders/Order_Line_Items/AA_Overview_of_Order_Line_Items) feature is now generally available to all Zuora customers. You need to enable the [Orders](https://knowledgecenter.zuora.com/BC_Subscription_Management/Orders/AA_Overview_of_Orders#Orders) feature to access the [Order Line Items](https://knowledgecenter.zuora.com/Billing/Subscriptions/Orders/Order_Line_Items/AA_Overview_of_Order_Line_Items) feature. As of Zuora Billing Release 313 (November 2021), new customers who onboard on [Orders](https://knowledgecenter.zuora.com/Billing/Subscriptions/Orders/AA_Overview_of_Orders) will have the [Order Line Items](https://knowledgecenter.zuora.com/Billing/Subscriptions/Orders/Order_Line_Items) feature enabled by default.        In the case where a normal \&quot;Create an order\&quot; operation call will time out, use this operation instead to create an order asynchronously. A job will be creating the order in the back end; the job ID will be returned for tracking the job status and result.   Note that this operation doesn&#39;t support auto-refund and invoice write-off during subscription cancellation. Use the \&quot;Create an order\&quot; operation instead.  The limit of orders allowed on a subscription is 1000.  The limit of order line items allowed in an order is 100.  Zuora has the following limits on the Orders synchronous API to prevent performance degradation:  * Up to 50 subscriptions are allowed in a single [Create an order](https://developer.zuora.com/api-references/api/operation/POST_Order) or [Preview an order](https://developer.zuora.com/api-references/api/operation/POST_PreviewOrder) operation call. * Up to 50 order actions are allowed in a single [Create an order](https://developer.zuora.com/api-references/api/operation/POST_Order) or [Preview an order](https://developer.zuora.com/api-references/api/operation/POST_PreviewOrder) operation call. * Up to 50 order actions are allowed on a single subscription in a [Create an order](https://developer.zuora.com/api-references/api/operation/POST_Order) or [Preview an order](https://developer.zuora.com/api-references/api/operation/POST_PreviewOrder) operation call.  If you have an Order that exceeds any limits of the above, Zuora recommends you use the following asynchronous API operations: * [Create an order asynchronously](https://developer.zuora.com/api-references/api/operation/POST_CreateOrderAsynchronously) * [Preview an order asynchronously](https://developer.zuora.com/api-references/api/operation/POST_PreviewOrderAsynchronously) * [Retrieve the status and response of a job](https://developer.zuora.com/api-references/api/operation/GET_JobStatusAndResponse) for checking the status of the asynchronous API operations  Zuora has the following limits on the Orders asynchronous API operations to prevent performance degradation: * Up to 300 subscriptions are allowed in a single [Create an order asynchronously](https://developer.zuora.com/api-references/api/operation/POST_CreateOrderAsynchronously) or [Preview an order asynchronously](https://developer.zuora.com/api-references/api/operation/POST_PreviewOrderAsynchronously) operation call. * Up to 300 order actions are allowed in a single [Create an order asynchronously](https://developer.zuora.com/api-references/api/operation/POST_CreateOrderAsynchronously) or [Preview an order asynchronously](https://developer.zuora.com/api-references/api/operation/POST_PreviewOrderAsynchronously) operation call. * Up to 300 order actions are allowed on a single subscription in a [Create an order asynchronously](https://developer.zuora.com/api-references/api/operation/POST_CreateOrderAsynchronously) or [Preview an order asynchronously](https://developer.zuora.com/api-references/api/operation/POST_PreviewOrderAsynchronously) operation call. 
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void createOrderAsynchronouslyTest() throws ApiException {
        LocalDate orderDate = null;
        String description = null;
        String category = null;
        Map<String, Object> customFields = null;
        String existingAccountNumber = null;
        String externallyManagedBy = null;
        CreateOrderNewAccount newAccount = null;
        List<OrderLineItemCommonPostOrder> orderLineItems = null;
        String orderNumber = null;
        ProcessingOptionsOrdersAsync processingOptions = null;
        String reasonCode = null;
        List<POSTOrderRequestTypeSubscriptionsInner> subscriptions = null;
        String idempotencyKey = null;
        String acceptEncoding = null;
        String contentEncoding = null;
        String authorization = null;
        String zuoraTrackId = null;
        String zuoraEntityIds = null;
        String zuoraOrgIds = null;
        Boolean returnIds = null;
        String zuoraVersion = null;
        PostCreateOrderAsynchronouslyResponse response = api.createOrderAsynchronously(orderDate)
                .description(description)
                .category(category)
                .customFields(customFields)
                .existingAccountNumber(existingAccountNumber)
                .externallyManagedBy(externallyManagedBy)
                .newAccount(newAccount)
                .orderLineItems(orderLineItems)
                .orderNumber(orderNumber)
                .processingOptions(processingOptions)
                .reasonCode(reasonCode)
                .subscriptions(subscriptions)
                .idempotencyKey(idempotencyKey)
                .acceptEncoding(acceptEncoding)
                .contentEncoding(contentEncoding)
                .authorization(authorization)
                .zuoraTrackId(zuoraTrackId)
                .zuoraEntityIds(zuoraEntityIds)
                .zuoraOrgIds(zuoraOrgIds)
                .returnIds(returnIds)
                .zuoraVersion(zuoraVersion)
                .execute();
        // TODO: test validations
    }

    /**
     * Retrieve the status and response of a job
     *
     * **Note:** This operation is only available if you have the [Orders](https://knowledgecenter.zuora.com/BC_Subscription_Management/Orders/AA_Overview_of_Orders#Orders) feature enabled. If you are an existing Zuora &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Subscriptions/Subscriptions/Subscribe_and_Amend\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Subscribe and Amend&lt;/a&gt; customer, we recommend you enable &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Subscriptions/Subscriptions/Orders_Harmonization/A_Overview_of_Orders_Harmonization\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Orders Harmonization&lt;/a&gt; to access the &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Subscriptions/Subscriptions/Orders/AA_Overview_of_Orders/A_Overview_of_Orders\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Orders&lt;/a&gt; feature. With Orders, you can access both existing functions for subscription and billing management and the &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Subscriptions/Subscriptions/Orders_Harmonization/P_FAQ_about_Orders_Harmonization#New+features+through+Orders\&quot; target&#x3D;\&quot;_blank\&quot;&gt;new features&lt;/a&gt; on Zuora Billing.  **Note:** The [Order Line Items](https://knowledgecenter.zuora.com/Billing/Subscriptions/Orders/Order_Line_Items/AA_Overview_of_Order_Line_Items) feature is now generally available to all Zuora customers. You need to enable the [Orders](https://knowledgecenter.zuora.com/BC_Subscription_Management/Orders/AA_Overview_of_Orders#Orders) feature to access the [Order Line Items](https://knowledgecenter.zuora.com/Billing/Subscriptions/Orders/Order_Line_Items/AA_Overview_of_Order_Line_Items) feature. As of Zuora Billing Release 313 (November 2021), new customers who onboard on [Orders](https://knowledgecenter.zuora.com/Billing/Subscriptions/Orders/AA_Overview_of_Orders) will have the [Order Line Items](https://knowledgecenter.zuora.com/Billing/Subscriptions/Orders/Order_Line_Items) feature enabled by default.         Get the status and response of an asynchronous job. Currently, an asynchronous job created by \&quot;Create an order asynchronously\&quot; or \&quot;Preview an order asynchronously\&quot; is supported. 
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void jobStatusAndResponseTest() throws ApiException {
        UUID jobId = null;
        String acceptEncoding = null;
        String contentEncoding = null;
        String authorization = null;
        String zuoraTrackId = null;
        GetJobStatusAndResponseResponse response = api.jobStatusAndResponse(jobId)
                .acceptEncoding(acceptEncoding)
                .contentEncoding(contentEncoding)
                .authorization(authorization)
                .zuoraTrackId(zuoraTrackId)
                .execute();
        // TODO: test validations
    }

    /**
     * Create an order
     *
     * **Note:** This operation is only available if you have the [Orders](https://knowledgecenter.zuora.com/BC_Subscription_Management/Orders/AA_Overview_of_Orders#Orders) feature enabled. If you are an existing Zuora &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Subscriptions/Subscriptions/Subscribe_and_Amend\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Subscribe and Amend&lt;/a&gt; customer, we recommend you enable &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Subscriptions/Subscriptions/Orders_Harmonization/A_Overview_of_Orders_Harmonization\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Orders Harmonization&lt;/a&gt; to access the &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Subscriptions/Subscriptions/Orders/AA_Overview_of_Orders/A_Overview_of_Orders\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Orders&lt;/a&gt; feature. With Orders, you can access both existing functions for subscription and billing management and the &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Subscriptions/Subscriptions/Orders_Harmonization/P_FAQ_about_Orders_Harmonization#New+features+through+Orders\&quot; target&#x3D;\&quot;_blank\&quot;&gt;new features&lt;/a&gt; on Zuora Billing.  **Note:** The [Order Line Items](https://knowledgecenter.zuora.com/Billing/Subscriptions/Orders/Order_Line_Items/AA_Overview_of_Order_Line_Items) feature is now generally available to all Zuora customers. You need to enable the [Orders](https://knowledgecenter.zuora.com/BC_Subscription_Management/Orders/AA_Overview_of_Orders#Orders) feature to access the [Order Line Items](https://knowledgecenter.zuora.com/Billing/Subscriptions/Orders/Order_Line_Items/AA_Overview_of_Order_Line_Items) feature. As of Zuora Billing Release 313 (November 2021), new customers who onboard on [Orders](https://knowledgecenter.zuora.com/Billing/Subscriptions/Orders/AA_Overview_of_Orders) will have the [Order Line Items](https://knowledgecenter.zuora.com/Billing/Subscriptions/Orders/Order_Line_Items) feature enabled by default.         You can use this operation to create subscriptions and make changes to subscriptions by creating orders. You can also use this operation to create order line items by creating orders. The following tutorials demonstrate how to use this operation:   * [Create a Subscription](https://knowledgecenter.zuora.com/BC_Subscription_Management/Orders/AC_Orders_Tutorials/A_Create_a_Subscription)  * [Add a Product to a Subscription](https://knowledgecenter.zuora.com/BC_Subscription_Management/Orders/AC_Orders_Tutorials/A_Add_a_Product_to_a_Subscription)  * [Create a Ramp Deal](https://knowledgecenter.zuora.com/Billing/Subscriptions/Orders/Ramps_and_Ramp_Metrics/B_Create_a_Ramp_Deal)  * [Add a Product Mid-Interval Update on a Ramp Deal](https://knowledgecenter.zuora.com/Billing/Subscriptions/Orders/Ramps_and_Ramp_Metrics/E_Update_a_Product_in_a_Ramp_Deal)  * [Add a Product in a Ramp Deal](https://knowledgecenter.zuora.com/Billing/Subscriptions/Orders/Ramps_and_Ramp_Metrics/C_Add_a_Product_in_a_Ramp_Deal)  * [Change the Terms and Conditions of a Ramp Deal](https://knowledgecenter.zuora.com/Billing/Subscriptions/Orders/Ramps_and_Ramp_Metrics/D_Change_the_Terms_and_Conditions_of_a_Ramp_Deal_and_Update_the_Ramp)  * [Change the Owner of a Subscription](https://knowledgecenter.zuora.com/BC_Subscription_Management/Orders/AC_Orders_Tutorials/C_Change_the_Owner_of_a_Subscription)  * [Change the Terms and Conditions of a Subscription](https://knowledgecenter.zuora.com/BC_Subscription_Management/Orders/AC_Orders_Tutorials/C_Change_the_Terms_and_Conditions_of_a_Subscription)  * [Renew a Subscription](https://knowledgecenter.zuora.com/BC_Subscription_Management/Orders/AC_Orders_Tutorials/C_Renew_a_Subscription)  * [Renew a Subscription and Upgrade a Product](https://knowledgecenter.zuora.com/BC_Subscription_Management/Orders/AC_Orders_Tutorials/C_Renew_a_Subscription_and_Upgrade_a_Product)  * [Replace a Product in a Subscription](https://knowledgecenter.zuora.com/BC_Subscription_Management/Orders/AC_Orders_Tutorials/C_Replace_a_Product_in_a_Subscription)  * [Update a Product in a Subscription](https://knowledgecenter.zuora.com/BC_Subscription_Management/Orders/AC_Orders_Tutorials/C_Update_a_Product_in_a_Subscription)  * [Cancel a Subscription](https://knowledgecenter.zuora.com/BC_Subscription_Management/Orders/AC_Orders_Tutorials/D_Cancel_a_Subscription)  * [Remove a Product from a Subscription](https://knowledgecenter.zuora.com/BC_Subscription_Management/Orders/AC_Orders_Tutorials/D_Remove_a_Product_from_a_Subscription)  * [Create sales order line items](https://knowledgecenter.zuora.com/Zuora_Billing/Manage_non-subscription_transactions/Order_Line_Items/B_Manage_Order_Line_Items/AA_Create_a_sales_order_line_item_with_fulfillments)  * [Associate order line items with new subscriptions](https://knowledgecenter.zuora.com/Zuora_Billing/Manage_non-subscription_transactions/Order_Line_Items/B_Manage_Order_Line_Items/C_Associate_an_order_line_item_with_a_new_subscription)  * [Return order line items](https://knowledgecenter.zuora.com/Zuora_Billing/Manage_non-subscription_transactions/Order_Line_Items/B_Manage_Order_Line_Items/DA_Return_an_order_line_item_with_fulfillments)  You can also use this operation to create orders and save the orders as scehduled orders. To manage and access the &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Manage_subscription_transactions/Orders/AA_Overview_of_Orders/P_Scheduled_Orders\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Scheduled Orders&lt;/a&gt; feature from the self-service interface, see &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Configure_billing_settings/System_settings/Enable_billing_features_by_yourself\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Enable billing features by yourself&lt;/a&gt;.  In addition, you can use this operation to place a standalone order to subscribe without pre-defining a product catalog in Zuora Billing. For more information, see &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Manage_subscription_transactions/Orders/Standalone_Orders/Create_a_subscription_using_a_standalone_order\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Create a subscription using a standalone order&lt;/a&gt;. The &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Manage_subscription_transactions/Orders/Standalone_Orders/AA_Overview_of_Standalone_Orders\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Standalone Orders&lt;/a&gt; feature is in the **Early Adopter** phase. We are actively soliciting feedback from a small set of early adopters before releasing it as generally available. If you want to join this early adopter program, submit a request at [Zuora Global Support](https://support.zuora.com).  **Note:** If you received a timeout error message when creating an order, the call is still running in the backend and the order will be created.  The limit of orders allowed on a subscription is 1000.  The limit of order line items allowed in an order is 100.  Zuora has the following limits on the Orders synchronous API to prevent performance degradation:  * Up to 50 subscriptions are allowed in a single [Create an order](https://developer.zuora.com/api-references/api/operation/POST_Order) or [Preview an order](https://developer.zuora.com/api-references/api/operation/POST_PreviewOrder) operation call. * Up to 50 order actions are allowed in a single [Create an order](https://developer.zuora.com/api-references/api/operation/POST_Order) or [Preview an order](https://developer.zuora.com/api-references/api/operation/POST_PreviewOrder) operation call. * Up to 50 order actions are allowed on a single subscription in a [Create an order](https://developer.zuora.com/api-references/api/operation/POST_Order) or [Preview an order](https://developer.zuora.com/api-references/api/operation/POST_PreviewOrder) operation call.  If you have an Order that exceeds any limits of the above, Zuora recommends you use the following asynchronous API operations: * [Create an order asynchronously](https://developer.zuora.com/api-references/api/operation/POST_CreateOrderAsynchronously) * [Preview an order asynchronously](https://developer.zuora.com/api-references/api/operation/POST_PreviewOrderAsynchronously) * [Retrieve the status and response of a job](https://developer.zuora.com/api-references/api/operation/GET_JobStatusAndResponse) for checking the status of the asynchronous API operations  Zuora has the following limits on the Orders asynchronous API operations to prevent performance degradation: * Up to 300 subscriptions are allowed in a single [Create an order asynchronously](https://developer.zuora.com/api-references/api/operation/POST_CreateOrderAsynchronously) or [Preview an order asynchronously](https://developer.zuora.com/api-references/api/operation/POST_PreviewOrderAsynchronously) operation call. * Up to 300 order actions are allowed in a single [Create an order asynchronously](https://developer.zuora.com/api-references/api/operation/POST_CreateOrderAsynchronously) or [Preview an order asynchronously](https://developer.zuora.com/api-references/api/operation/POST_PreviewOrderAsynchronously) operation call. * Up to 300 order actions are allowed on a single subscription in a [Create an order asynchronously](https://developer.zuora.com/api-references/api/operation/POST_CreateOrderAsynchronously) or [Preview an order asynchronously](https://developer.zuora.com/api-references/api/operation/POST_PreviewOrderAsynchronously) operation call.   **Note:** When you are to suspend a subcription (via the &#x60;suspend&#x60; order action), if in the same \&quot;Create an order\&quot; call you are to perform other subsequent order actions on the supscription to suspend, you must first resume the subscription (via a &#x60;resume&#x60; order action).   **Note:** When using this operation to create an account, create a subscription, run billing, and collect payment in a single call, if any error occurs during the call, such as a payment processing failure and a tax engine failure, then all the other steps will be rolled back. This means that the invoice will not be generated, the subscription will not be created, and the account will not be created. 
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void orderTest() throws ApiException {
        LocalDate orderDate = null;
        String description = null;
        String category = null;
        Map<String, Object> customFields = null;
        String existingAccountNumber = null;
        String externallyManagedBy = null;
        CreateOrderNewAccount newAccount = null;
        List<OrderLineItemCommonPostOrder> orderLineItems = null;
        String orderNumber = null;
        ProcessingOptionsOrdersWithDelayedCapturePayment processingOptions = null;
        String reasonCode = null;
        POSTOrderRequestTypeSchedulingOptions schedulingOptions = null;
        String status = null;
        List<POSTOrderRequestTypeSubscriptionsInner> subscriptions = null;
        String idempotencyKey = null;
        String acceptEncoding = null;
        String contentEncoding = null;
        String authorization = null;
        String zuoraTrackId = null;
        String zuoraEntityIds = null;
        String zuoraOrgIds = null;
        Boolean returnIds = null;
        String zuoraVersion = null;
        PostOrderResponseType response = api.order(orderDate)
                .description(description)
                .category(category)
                .customFields(customFields)
                .existingAccountNumber(existingAccountNumber)
                .externallyManagedBy(externallyManagedBy)
                .newAccount(newAccount)
                .orderLineItems(orderLineItems)
                .orderNumber(orderNumber)
                .processingOptions(processingOptions)
                .reasonCode(reasonCode)
                .schedulingOptions(schedulingOptions)
                .status(status)
                .subscriptions(subscriptions)
                .idempotencyKey(idempotencyKey)
                .acceptEncoding(acceptEncoding)
                .contentEncoding(contentEncoding)
                .authorization(authorization)
                .zuoraTrackId(zuoraTrackId)
                .zuoraEntityIds(zuoraEntityIds)
                .zuoraOrgIds(zuoraOrgIds)
                .returnIds(returnIds)
                .zuoraVersion(zuoraVersion)
                .execute();
        // TODO: test validations
    }

    /**
     * Activate an order
     *
     * **Note:** This operation is only available if you have the [Orders](https://knowledgecenter.zuora.com/BC_Subscription_Management/Orders/AA_Overview_of_Orders#Orders) feature enabled. If you are an existing Zuora &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Subscriptions/Subscriptions/Subscribe_and_Amend\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Subscribe and Amend&lt;/a&gt; customer, we recommend you enable &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Subscriptions/Subscriptions/Orders_Harmonization/A_Overview_of_Orders_Harmonization\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Orders Harmonization&lt;/a&gt; to access the &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Subscriptions/Subscriptions/Orders/AA_Overview_of_Orders/A_Overview_of_Orders\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Orders&lt;/a&gt; feature. With Orders, you can access both existing functions for subscription and billing management and the &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Subscriptions/Subscriptions/Orders_Harmonization/P_FAQ_about_Orders_Harmonization#New+features+through+Orders\&quot; target&#x3D;\&quot;_blank\&quot;&gt;new features&lt;/a&gt; on Zuora Billing.  Activate order is only available for draft orders. 
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void orderActivateTest() throws ApiException {
        String orderNumber = null;
        String acceptEncoding = null;
        String contentEncoding = null;
        String authorization = null;
        String zuoraTrackId = null;
        String zuoraEntityIds = null;
        String zuoraOrgIds = null;
        PostOrderResponseType response = api.orderActivate(orderNumber)
                .acceptEncoding(acceptEncoding)
                .contentEncoding(contentEncoding)
                .authorization(authorization)
                .zuoraTrackId(zuoraTrackId)
                .zuoraEntityIds(zuoraEntityIds)
                .zuoraOrgIds(zuoraOrgIds)
                .execute();
        // TODO: test validations
    }

    /**
     * Cancel an order
     *
     * **Note:** This operation is only available if you have the [Orders](https://knowledgecenter.zuora.com/BC_Subscription_Management/Orders/AA_Overview_of_Orders#Orders) feature enabled. If you are an existing Zuora &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Subscriptions/Subscriptions/Subscribe_and_Amend\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Subscribe and Amend&lt;/a&gt; customer, we recommend you enable &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Subscriptions/Subscriptions/Orders_Harmonization/A_Overview_of_Orders_Harmonization\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Orders Harmonization&lt;/a&gt; to access the &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Subscriptions/Subscriptions/Orders/AA_Overview_of_Orders/A_Overview_of_Orders\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Orders&lt;/a&gt; feature. With Orders, you can access both existing functions for subscription and billing management and the &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Subscriptions/Subscriptions/Orders_Harmonization/P_FAQ_about_Orders_Harmonization#New+features+through+Orders\&quot; target&#x3D;\&quot;_blank\&quot;&gt;new features&lt;/a&gt; on Zuora Billing.  **Note:** Cancellation is only valid for draft or scheduled orders. If the order is not in draft or scheduled status, the API returns an error.  To manage and access the &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Manage_subscription_transactions/Orders/AA_Overview_of_Orders/P_Scheduled_Orders\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Scheduled Orders&lt;/a&gt; feature from the self-service interface, see &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Configure_billing_settings/System_settings/Enable_billing_features_by_yourself\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Enable billing features by yourself&lt;/a&gt;. 
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void orderCancelTest() throws ApiException {
        String orderNumber = null;
        String cancelReason = null;
        String acceptEncoding = null;
        String contentEncoding = null;
        String authorization = null;
        String zuoraTrackId = null;
        String zuoraEntityIds = null;
        String zuoraOrgIds = null;
        PutOrderCancelResponse response = api.orderCancel(orderNumber)
                .cancelReason(cancelReason)
                .acceptEncoding(acceptEncoding)
                .contentEncoding(contentEncoding)
                .authorization(authorization)
                .zuoraTrackId(zuoraTrackId)
                .zuoraEntityIds(zuoraEntityIds)
                .zuoraOrgIds(zuoraOrgIds)
                .execute();
        // TODO: test validations
    }

    /**
     * Update order action trigger dates
     *
     * **Note:** This operation is only available if you have the [Orders](https://knowledgecenter.zuora.com/BC_Subscription_Management/Orders/AA_Overview_of_Orders#Orders) feature enabled. If you are an existing Zuora &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Subscriptions/Subscriptions/Subscribe_and_Amend\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Subscribe and Amend&lt;/a&gt; customer, we recommend you enable &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Subscriptions/Subscriptions/Orders_Harmonization/A_Overview_of_Orders_Harmonization\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Orders Harmonization&lt;/a&gt; to access the &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Subscriptions/Subscriptions/Orders/AA_Overview_of_Orders/A_Overview_of_Orders\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Orders&lt;/a&gt; feature. With Orders, you can access both existing functions for subscription and billing management and the &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Subscriptions/Subscriptions/Orders_Harmonization/P_FAQ_about_Orders_Harmonization#New+features+through+Orders\&quot; target&#x3D;\&quot;_blank\&quot;&gt;new features&lt;/a&gt; on Zuora Billing.  Updates the triggering dates for either of the following order actions:  * CreateSubscription  * AddProduct  * UpdateProduct  * RemoveProduct  * RenewSubscription  * TermsAndConditions 
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void orderTriggerDatesTest() throws ApiException {
        String orderNumber = null;
        List<PUTOrderActionTriggerDatesRequestTypeSubscriptionsInner> subscriptions = null;
        String acceptEncoding = null;
        String contentEncoding = null;
        String authorization = null;
        String zuoraTrackId = null;
        String zuoraEntityIds = null;
        String zuoraOrgIds = null;
        PUTOrderTriggerDatesResponseType response = api.orderTriggerDates(orderNumber)
                .subscriptions(subscriptions)
                .acceptEncoding(acceptEncoding)
                .contentEncoding(contentEncoding)
                .authorization(authorization)
                .zuoraTrackId(zuoraTrackId)
                .zuoraEntityIds(zuoraEntityIds)
                .zuoraOrgIds(zuoraOrgIds)
                .execute();
        // TODO: test validations
    }

    /**
     * Retrieve an order
     *
     * **Note:** This feature is only available if you have the [Order Metrics](https://knowledgecenter.zuora.com/BC_Subscription_Management/Orders/AA_Overview_of_Orders#Order_Metrics) feature enabled. As of Zuora Billing Release 284, Orders is generally available and the Order Metrics feature is no longer available as a standalone feature. If you are an existing Subscribe and Amend customer and want Order Metrics only, you must turn on [Orders Harmonization](https://knowledgecenter.zuora.com/Billing/Subscriptions/Orders/Orders_Harmonization/Orders_Harmonization). You can still keep the existing Subscribe and Amend API integrations to create and manage subscriptions.  **Note:** The [Order Line Items](https://knowledgecenter.zuora.com/Billing/Subscriptions/Orders/Order_Line_Items/AA_Overview_of_Order_Line_Items) feature is now generally available to all Zuora customers. You need to enable the [Orders](https://knowledgecenter.zuora.com/BC_Subscription_Management/Orders/AA_Overview_of_Orders#Orders) feature to access the [Order Line Items](https://knowledgecenter.zuora.com/Billing/Subscriptions/Orders/Order_Line_Items/AA_Overview_of_Order_Line_Items) feature. As of Zuora Billing Release 313 (November 2021), new customers who onboard on [Orders](https://knowledgecenter.zuora.com/Billing/Subscriptions/Orders/AA_Overview_of_Orders) will have the [Order Line Items](https://knowledgecenter.zuora.com/Billing/Subscriptions/Orders/Order_Line_Items) feature enabled by default.         Retrieves the detailed information about a specified order. 
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void order_0Test() throws ApiException {
        String orderNumber = null;
        String acceptEncoding = null;
        String contentEncoding = null;
        String authorization = null;
        String zuoraTrackId = null;
        String zuoraEntityIds = null;
        String zuoraOrgIds = null;
        GetOrderResponse response = api.order_0(orderNumber)
                .acceptEncoding(acceptEncoding)
                .contentEncoding(contentEncoding)
                .authorization(authorization)
                .zuoraTrackId(zuoraTrackId)
                .zuoraEntityIds(zuoraEntityIds)
                .zuoraOrgIds(zuoraOrgIds)
                .execute();
        // TODO: test validations
    }

    /**
     * Update an order
     *
     * **Notes:**  - This operation is only available if you have the [Orders](https://knowledgecenter.zuora.com/BC_Subscription_Management/Orders/AA_Overview_of_Orders#Orders) feature enabled. If you are an existing Zuora &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Subscriptions/Subscriptions/Subscribe_and_Amend\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Subscribe and Amend&lt;/a&gt; customer, we recommend you enable &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Subscriptions/Subscriptions/Orders_Harmonization/A_Overview_of_Orders_Harmonization\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Orders Harmonization&lt;/a&gt; to access the &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Subscriptions/Subscriptions/Orders/AA_Overview_of_Orders/A_Overview_of_Orders\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Orders&lt;/a&gt; feature. With Orders, you can access both existing functions for subscription and billing management and the &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Subscriptions/Subscriptions/Orders_Harmonization/P_FAQ_about_Orders_Harmonization#New+features+through+Orders\&quot; target&#x3D;\&quot;_blank\&quot;&gt;new features&lt;/a&gt; on Zuora Billing. - Update an order is only valid for draft or scheduled orders. To manage and access the &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Manage_subscription_transactions/Orders/AA_Overview_of_Orders/P_Scheduled_Orders\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Scheduled Orders&lt;/a&gt; feature from the self-service interface, see &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Configure_billing_settings/System_settings/Enable_billing_features_by_yourself\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Enable billing features by yourself&lt;/a&gt;. - This operation doesn&#39;t support auto-refund and invoice write-off during subscription cancellation. Use the \&quot;Create an order\&quot; operation instead. - You must provide full payload when using the \&quot;Update an order\&quot; operation. That is, if you want to edit one order action, you need to provide all other order actions in the payload. Otherwise, the other order actions will be removed. 
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void order_1Test() throws ApiException {
        LocalDate orderDate = null;
        String orderNumber = null;
        String description = null;
        String category = null;
        Map<String, Object> customFields = null;
        String existingAccountNumber = null;
        String externallyManagedBy = null;
        List<OrderLineItemCommonPostOrder> orderLineItems = null;
        String orderNumber = null;
        ProcessingOptionsOrders processingOptions = null;
        String reasonCode = null;
        POSTOrderRequestTypeSchedulingOptions schedulingOptions = null;
        String status = null;
        List<POSTOrderRequestTypeSubscriptionsInner> subscriptions = null;
        String acceptEncoding = null;
        String contentEncoding = null;
        String authorization = null;
        String zuoraTrackId = null;
        String zuoraEntityIds = null;
        String zuoraOrgIds = null;
        PostOrderResponseType response = api.order_1(orderDate, orderNumber)
                .description(description)
                .category(category)
                .customFields(customFields)
                .existingAccountNumber(existingAccountNumber)
                .externallyManagedBy(externallyManagedBy)
                .orderLineItems(orderLineItems)
                .orderNumber(orderNumber)
                .processingOptions(processingOptions)
                .reasonCode(reasonCode)
                .schedulingOptions(schedulingOptions)
                .status(status)
                .subscriptions(subscriptions)
                .acceptEncoding(acceptEncoding)
                .contentEncoding(contentEncoding)
                .authorization(authorization)
                .zuoraTrackId(zuoraTrackId)
                .zuoraEntityIds(zuoraEntityIds)
                .zuoraOrgIds(zuoraOrgIds)
                .execute();
        // TODO: test validations
    }

    /**
     * Delete an order
     *
     * **Note:** This operation is only available if you have the [Orders](https://knowledgecenter.zuora.com/BC_Subscription_Management/Orders/AA_Overview_of_Orders#Orders) feature enabled. If you are an existing Zuora &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Subscriptions/Subscriptions/Subscribe_and_Amend\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Subscribe and Amend&lt;/a&gt; customer, we recommend you enable &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Subscriptions/Subscriptions/Orders_Harmonization/A_Overview_of_Orders_Harmonization\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Orders Harmonization&lt;/a&gt; to access the &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Subscriptions/Subscriptions/Orders/AA_Overview_of_Orders/A_Overview_of_Orders\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Orders&lt;/a&gt; feature. With Orders, you can access both existing functions for subscription and billing management and the &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Subscriptions/Subscriptions/Orders_Harmonization/P_FAQ_about_Orders_Harmonization#New+features+through+Orders\&quot; target&#x3D;\&quot;_blank\&quot;&gt;new features&lt;/a&gt; on Zuora Billing.  **Note:** The [Order Line Items](https://knowledgecenter.zuora.com/Billing/Subscriptions/Orders/Order_Line_Items/AA_Overview_of_Order_Line_Items) feature is now generally available to all Zuora customers. You need to enable the [Orders](https://knowledgecenter.zuora.com/BC_Subscription_Management/Orders/AA_Overview_of_Orders#Orders) feature to access the [Order Line Items](https://knowledgecenter.zuora.com/Billing/Subscriptions/Orders/Order_Line_Items/AA_Overview_of_Order_Line_Items) feature. As of Zuora Billing Release 313 (November 2021), new customers who onboard on [Orders](https://knowledgecenter.zuora.com/Billing/Subscriptions/Orders/AA_Overview_of_Orders) will have the [Order Line Items](https://knowledgecenter.zuora.com/Billing/Subscriptions/Orders/Order_Line_Items) feature enabled by default.          Deletes a specified order.   * All the subscriptions changed by this order are deleted. After the deletion, the subscriptions are rolled back to the previous version.   * All the order line items created in this order are deleted.  You are not allowed to delete an order if the charges that are affected by this order are invoiced. 
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void order_2Test() throws ApiException {
        String orderNumber = null;
        String acceptEncoding = null;
        String contentEncoding = null;
        String authorization = null;
        String zuoraTrackId = null;
        String zuoraEntityIds = null;
        String zuoraOrgIds = null;
        CommonResponse response = api.order_2(orderNumber)
                .acceptEncoding(acceptEncoding)
                .contentEncoding(contentEncoding)
                .authorization(authorization)
                .zuoraTrackId(zuoraTrackId)
                .zuoraEntityIds(zuoraEntityIds)
                .zuoraOrgIds(zuoraOrgIds)
                .execute();
        // TODO: test validations
    }

    /**
     * List orders of an invoice owner
     *
     * **Note:** This feature is only available if you have the [Order Metrics](https://knowledgecenter.zuora.com/BC_Subscription_Management/Orders/AA_Overview_of_Orders#Order_Metrics) feature enabled. As of Zuora Billing Release 284, Orders is generally available and the Order Metrics feature is no longer available as a standalone feature. If you are an existing Subscribe and Amend customer and want Order Metrics only, you must turn on [Orders Harmonization](https://knowledgecenter.zuora.com/Billing/Subscriptions/Orders/Orders_Harmonization/Orders_Harmonization). You can still keep the existing Subscribe and Amend API integrations to create and manage subscriptions.  **Note:** The [Order Line Items](https://knowledgecenter.zuora.com/Billing/Subscriptions/Orders/Order_Line_Items/AA_Overview_of_Order_Line_Items) feature is now generally available to all Zuora customers. You need to enable the [Orders](https://knowledgecenter.zuora.com/BC_Subscription_Management/Orders/AA_Overview_of_Orders#Orders) feature to access the [Order Line Items](https://knowledgecenter.zuora.com/Billing/Subscriptions/Orders/Order_Line_Items/AA_Overview_of_Order_Line_Items) feature. As of Zuora Billing Release 313 (November 2021), new customers who onboard on [Orders](https://knowledgecenter.zuora.com/Billing/Subscriptions/Orders/AA_Overview_of_Orders) will have the [Order Line Items](https://knowledgecenter.zuora.com/Billing/Subscriptions/Orders/Order_Line_Items) feature enabled by default.          Retrieves the detailed information about all orders for a specified invoice owner. You can set the &#x60;status&#x60; query parameter to an order status to retrieve orders in that order status. If you do not set a value for this query parameter, the query parameter has a default value &#x60;all&#x60;, and orders of all statuses are returned. 
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void ordersByInvoiceOwnerTest() throws ApiException {
        String accountNumber = null;
        String acceptEncoding = null;
        String contentEncoding = null;
        String authorization = null;
        String zuoraTrackId = null;
        String zuoraEntityIds = null;
        String zuoraOrgIds = null;
        Integer page = null;
        Integer pageSize = null;
        String dateFilterOption = null;
        LocalDate startDate = null;
        LocalDate endDate = null;
        String status = null;
        GetOrdersResponse response = api.ordersByInvoiceOwner(accountNumber)
                .acceptEncoding(acceptEncoding)
                .contentEncoding(contentEncoding)
                .authorization(authorization)
                .zuoraTrackId(zuoraTrackId)
                .zuoraEntityIds(zuoraEntityIds)
                .zuoraOrgIds(zuoraOrgIds)
                .page(page)
                .pageSize(pageSize)
                .dateFilterOption(dateFilterOption)
                .startDate(startDate)
                .endDate(endDate)
                .status(status)
                .execute();
        // TODO: test validations
    }

    /**
     * List orders by subscription number
     *
     * **Note:** This feature is only available if you have the [Order Metrics](https://knowledgecenter.zuora.com/BC_Subscription_Management/Orders/AA_Overview_of_Orders#Order_Metrics) feature enabled. As of Zuora Billing Release 284, Orders is generally available and the Order Metrics feature is no longer available as a standalone feature. If you are an existing Subscribe and Amend customer and want Order Metrics only, you must turn on [Orders Harmonization](https://knowledgecenter.zuora.com/Billing/Subscriptions/Orders/Orders_Harmonization/Orders_Harmonization). You can still keep the existing Subscribe and Amend API integrations to create and manage subscriptions.  **Note:** The [Order Line Items](https://knowledgecenter.zuora.com/Billing/Subscriptions/Orders/Order_Line_Items/AA_Overview_of_Order_Line_Items) feature is now generally available to all Zuora customers. You need to enable the [Orders](https://knowledgecenter.zuora.com/BC_Subscription_Management/Orders/AA_Overview_of_Orders#Orders) feature to access the [Order Line Items](https://knowledgecenter.zuora.com/Billing/Subscriptions/Orders/Order_Line_Items/AA_Overview_of_Order_Line_Items) feature. As of Zuora Billing Release 313 (November 2021), new customers who onboard on [Orders](https://knowledgecenter.zuora.com/Billing/Subscriptions/Orders/AA_Overview_of_Orders) will have the [Order Line Items](https://knowledgecenter.zuora.com/Billing/Subscriptions/Orders/Order_Line_Items) feature enabled by default.   Retrieves the detailed information about all orders for a specified subscription. You can set the &#x60;status&#x60; query parameter to an order status to retrieve orders in that order status. If you do not set a value for this query parameter, the query parameter has a default value &#x60;all&#x60;, and orders of all statuses are returned. 
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void ordersBySubscriptionNumberTest() throws ApiException {
        String subscriptionNumber = null;
        String acceptEncoding = null;
        String contentEncoding = null;
        String authorization = null;
        String zuoraTrackId = null;
        String zuoraEntityIds = null;
        String zuoraOrgIds = null;
        Integer page = null;
        Integer pageSize = null;
        String dateFilterOption = null;
        LocalDate startDate = null;
        LocalDate endDate = null;
        String status = null;
        GetOrdersResponse response = api.ordersBySubscriptionNumber(subscriptionNumber)
                .acceptEncoding(acceptEncoding)
                .contentEncoding(contentEncoding)
                .authorization(authorization)
                .zuoraTrackId(zuoraTrackId)
                .zuoraEntityIds(zuoraEntityIds)
                .zuoraOrgIds(zuoraOrgIds)
                .page(page)
                .pageSize(pageSize)
                .dateFilterOption(dateFilterOption)
                .startDate(startDate)
                .endDate(endDate)
                .status(status)
                .execute();
        // TODO: test validations
    }

    /**
     * List orders of a subscription owner
     *
     * **Note:** This feature is only available if you have the [Order Metrics](https://knowledgecenter.zuora.com/BC_Subscription_Management/Orders/AA_Overview_of_Orders#Order_Metrics) feature enabled. As of Zuora Billing Release 284, Orders is generally available and the Order Metrics feature is no longer available as a standalone feature. If you are an existing Subscribe and Amend customer and want Order Metrics only, you must turn on [Orders Harmonization](https://knowledgecenter.zuora.com/Billing/Subscriptions/Orders/Orders_Harmonization/Orders_Harmonization). You can still keep the existing Subscribe and Amend API integrations to create and manage subscriptions.  **Note:** The [Order Line Items](https://knowledgecenter.zuora.com/Billing/Subscriptions/Orders/Order_Line_Items/AA_Overview_of_Order_Line_Items) feature is now generally available to all Zuora customers. You need to enable the [Orders](https://knowledgecenter.zuora.com/BC_Subscription_Management/Orders/AA_Overview_of_Orders#Orders) feature to access the [Order Line Items](https://knowledgecenter.zuora.com/Billing/Subscriptions/Orders/Order_Line_Items/AA_Overview_of_Order_Line_Items) feature. As of Zuora Billing Release 313 (November 2021), new customers who onboard on [Orders](https://knowledgecenter.zuora.com/Billing/Subscriptions/Orders/AA_Overview_of_Orders) will have the [Order Line Items](https://knowledgecenter.zuora.com/Billing/Subscriptions/Orders/Order_Line_Items) feature enabled by default.          Retrieves the detailed information about all orders for a specified subscription owner. Any orders containing the changes on the subscriptions owned by this account are returned.  **Note**: You cannot retrieve detailed information about draft orders or scheduled orders through this operation. 
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void ordersBySubscriptionOwnerTest() throws ApiException {
        String accountNumber = null;
        String acceptEncoding = null;
        String contentEncoding = null;
        String authorization = null;
        String zuoraTrackId = null;
        String zuoraEntityIds = null;
        String zuoraOrgIds = null;
        Integer page = null;
        Integer pageSize = null;
        String dateFilterOption = null;
        LocalDate startDate = null;
        LocalDate endDate = null;
        GetOrdersResponse response = api.ordersBySubscriptionOwner(accountNumber)
                .acceptEncoding(acceptEncoding)
                .contentEncoding(contentEncoding)
                .authorization(authorization)
                .zuoraTrackId(zuoraTrackId)
                .zuoraEntityIds(zuoraEntityIds)
                .zuoraOrgIds(zuoraOrgIds)
                .page(page)
                .pageSize(pageSize)
                .dateFilterOption(dateFilterOption)
                .startDate(startDate)
                .endDate(endDate)
                .execute();
        // TODO: test validations
    }

    /**
     * List pending orders by subscription number
     *
     * **Note:** This feature is only available if you have the [Order Metrics](https://knowledgecenter.zuora.com/BC_Subscription_Management/Orders/AA_Overview_of_Orders#Order_Metrics) feature enabled. As of Zuora Billing Release 284, Orders is generally available and the Order Metrics feature is no longer available as a standalone feature. If you are an existing Subscribe and Amend customer and want Order Metrics only, you must turn on [Orders Harmonization](https://knowledgecenter.zuora.com/Billing/Subscriptions/Orders/Orders_Harmonization/Orders_Harmonization). You can still keep the existing Subscribe and Amend API integrations to create and manage subscriptions.  **Note:** The [Order Line Items](https://knowledgecenter.zuora.com/Billing/Subscriptions/Orders/Order_Line_Items/AA_Overview_of_Order_Line_Items) feature is now generally available to all Zuora customers. You need to enable the [Orders](https://knowledgecenter.zuora.com/BC_Subscription_Management/Orders/AA_Overview_of_Orders#Orders) feature to access the [Order Line Items](https://knowledgecenter.zuora.com/Billing/Subscriptions/Orders/Order_Line_Items/AA_Overview_of_Order_Line_Items) feature. As of Zuora Billing Release 313 (November 2021), new customers who onboard on [Orders](https://knowledgecenter.zuora.com/Billing/Subscriptions/Orders/AA_Overview_of_Orders) will have the [Order Line Items](https://knowledgecenter.zuora.com/Billing/Subscriptions/Orders/Order_Line_Items) feature enabled by default.   Retrieves the detailed information about all pending orders for a specified subscription. 
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void pendingOrdersBySubscriptionNumberTest() throws ApiException {
        String subscriptionKey = null;
        String acceptEncoding = null;
        String contentEncoding = null;
        String authorization = null;
        String zuoraTrackId = null;
        String zuoraEntityIds = null;
        String zuoraOrgIds = null;
        GetAllOrdersResponseType response = api.pendingOrdersBySubscriptionNumber(subscriptionKey)
                .acceptEncoding(acceptEncoding)
                .contentEncoding(contentEncoding)
                .authorization(authorization)
                .zuoraTrackId(zuoraTrackId)
                .zuoraEntityIds(zuoraEntityIds)
                .zuoraOrgIds(zuoraOrgIds)
                .execute();
        // TODO: test validations
    }

    /**
     * Preview an order
     *
     * **Notes**:   - This operation is only available if you have the [Orders](https://knowledgecenter.zuora.com/BC_Subscription_Management/Orders/AA_Overview_of_Orders#Orders) feature enabled. If you are an existing Zuora &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Subscriptions/Subscriptions/Subscribe_and_Amend\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Subscribe and Amend&lt;/a&gt; customer, we recommend you enable &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Subscriptions/Subscriptions/Orders_Harmonization/A_Overview_of_Orders_Harmonization\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Orders Harmonization&lt;/a&gt; to access the &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Subscriptions/Subscriptions/Orders/AA_Overview_of_Orders/A_Overview_of_Orders\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Orders&lt;/a&gt; feature. With Orders, you can access both existing functions for subscription and billing management and the &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Subscriptions/Subscriptions/Orders_Harmonization/P_FAQ_about_Orders_Harmonization#New+features+through+Orders\&quot; target&#x3D;\&quot;_blank\&quot;&gt;new features&lt;/a&gt; on Zuora Billing.   - The [Order Line Items](https://knowledgecenter.zuora.com/Billing/Subscriptions/Orders/Order_Line_Items/AA_Overview_of_Order_Line_Items) feature is now generally available to all Zuora customers. You need to enable the [Orders](https://knowledgecenter.zuora.com/BC_Subscription_Management/Orders/AA_Overview_of_Orders#Orders) feature to access the [Order Line Items](https://knowledgecenter.zuora.com/Billing/Subscriptions/Orders/Order_Line_Items/AA_Overview_of_Order_Line_Items) feature. As of Zuora Billing Release 313 (November 2021), new customers who onboard on [Orders](https://knowledgecenter.zuora.com/Billing/Subscriptions/Orders/AA_Overview_of_Orders) will have the [Order Line Items](https://knowledgecenter.zuora.com/Billing/Subscriptions/Orders/Order_Line_Items) feature enabled by default.     - You cannot preview enhanced discounts.        Retrieves the preview of the charge metrics and invoice items of a specified order. Preview for subscriptions and order line items are both supported. This operation is only an order preview and no order is created.    You can also use this operation to preview billing for a standalone order. For more information, see &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Manage_subscription_transactions/Orders/Standalone_Orders/Preview_billing_for_a_standalone_order\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Preview billing for a standalone order&lt;/a&gt;. The &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Manage_subscription_transactions/Orders/Standalone_Orders/AA_Overview_of_Standalone_Orders\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Standalone Orders&lt;/a&gt; feature is in the **Early Adopter** phase. We are actively soliciting feedback from a small set of early adopters before releasing it as generally available. If you want to join this early adopter program, submit a request at [Zuora Global Support](https://support.zuora.com).  #### Billing preview behavior regarding draft invoices By default, the billing preview behavior regarding draft invoices is as below: * When you preview billing for your order and the order contains subscriptions only, the draft invoices are excluded. * When you preview billing for your order and the order contains order line items only, the draft invoices are included. * When you preview billing for an order that contains both subscriptions  order line items, the draft invoices are included for both subscriptions and order line items.  However, if you want to always exclude the draft invoices in billing preview, submit a request at [Zuora Global Support](https://support.zuora.com).  #### Limits on Orders API The limit of orders allowed on a subscription is 1000.  The limit of order line items allowed in an order is 100.  Zuora has the following limits on the Orders synchronous API to prevent performance degradation:  * Up to 50 subscriptions are allowed in a single [Create an order](https://developer.zuora.com/api-references/api/operation/POST_Order) or [Preview an order](https://developer.zuora.com/api-references/api/operation/POST_PreviewOrder) operation call. * Up to 50 order actions are allowed in a single [Create an order](https://developer.zuora.com/api-references/api/operation/POST_Order) or [Preview an order](https://developer.zuora.com/api-references/api/operation/POST_PreviewOrder) operation call. * Up to 50 order actions are allowed on a single subscription in a [Create an order](https://developer.zuora.com/api-references/api/operation/POST_Order) or [Preview an order](https://developer.zuora.com/api-references/api/operation/POST_PreviewOrder) operation call.  If you have an Order that exceeds any limits of the above, Zuora recommends you use the following asynchronous API operations: * [Create an order asynchronously](https://developer.zuora.com/api-references/api/operation/POST_CreateOrderAsynchronously) * [Preview an order asynchronously](https://developer.zuora.com/api-references/api/operation/POST_PreviewOrderAsynchronously) * [Retrieve the status and response of a job](https://developer.zuora.com/api-references/api/operation/GET_JobStatusAndResponse) for checking the status of the asynchronous API operations  Zuora has the following limits on the Orders asynchronous API operations to prevent performance degradation: * Up to 300 subscriptions are allowed in a single [Create an order asynchronously](https://developer.zuora.com/api-references/api/operation/POST_CreateOrderAsynchronously) or [Preview an order asynchronously](https://developer.zuora.com/api-references/api/operation/POST_PreviewOrderAsynchronously) operation call. * Up to 300 order actions are allowed in a single [Create an order asynchronously](https://developer.zuora.com/api-references/api/operation/POST_CreateOrderAsynchronously) or [Preview an order asynchronously](https://developer.zuora.com/api-references/api/operation/POST_PreviewOrderAsynchronously) operation call. * Up to 300 order actions are allowed on a single subscription in a [Create an order asynchronously](https://developer.zuora.com/api-references/api/operation/POST_CreateOrderAsynchronously) or [Preview an order asynchronously](https://developer.zuora.com/api-references/api/operation/POST_PreviewOrderAsynchronously) operation call. 
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void previewOrderTest() throws ApiException {
        LocalDate orderDate = null;
        PreviewOptions previewOptions = null;
        String description = null;
        String category = null;
        Map<String, Object> customFields = null;
        String existingAccountNumber = null;
        List<OrderLineItemCommonPostOrder> orderLineItems = null;
        String orderNumber = null;
        PreviewAccountInfo previewAccountInfo = null;
        String reasonCode = null;
        List<POSTOrderPreviewRequestTypeSubscriptionsInner> subscriptions = null;
        String idempotencyKey = null;
        String acceptEncoding = null;
        String contentEncoding = null;
        String authorization = null;
        String zuoraTrackId = null;
        String zuoraEntityIds = null;
        String zuoraOrgIds = null;
        PostOrderPreviewResponseType response = api.previewOrder(orderDate, previewOptions)
                .description(description)
                .category(category)
                .customFields(customFields)
                .existingAccountNumber(existingAccountNumber)
                .orderLineItems(orderLineItems)
                .orderNumber(orderNumber)
                .previewAccountInfo(previewAccountInfo)
                .reasonCode(reasonCode)
                .subscriptions(subscriptions)
                .idempotencyKey(idempotencyKey)
                .acceptEncoding(acceptEncoding)
                .contentEncoding(contentEncoding)
                .authorization(authorization)
                .zuoraTrackId(zuoraTrackId)
                .zuoraEntityIds(zuoraEntityIds)
                .zuoraOrgIds(zuoraOrgIds)
                .execute();
        // TODO: test validations
    }

    /**
     * Preview an order asynchronously
     *
     * **Notes:**  - This operation is only available if you have the [Orders](https://knowledgecenter.zuora.com/BC_Subscription_Management/Orders/AA_Overview_of_Orders#Orders) feature enabled. Orders is now generally available as of Zuora Billing Release 284 (August 2020). If you are an existing Zuora &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Subscriptions/Subscriptions/Subscribe_and_Amend\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Subscribe and Amend&lt;/a&gt; customer, we recommend you enable &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Subscriptions/Subscriptions/Orders_Harmonization/A_Overview_of_Orders_Harmonization\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Orders Harmonization&lt;/a&gt; to access the &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Subscriptions/Subscriptions/Orders/AA_Overview_of_Orders/A_Overview_of_Orders\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Orders&lt;/a&gt; feature. With Orders, you can access both existing functions for subscription and billing management and the &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Subscriptions/Subscriptions/Orders_Harmonization/P_FAQ_about_Orders_Harmonization#New+features+through+Orders\&quot; target&#x3D;\&quot;_blank\&quot;&gt;new features&lt;/a&gt; on Zuora Billing. - The [Order Line Items](https://knowledgecenter.zuora.com/Billing/Subscriptions/Orders/Order_Line_Items/AA_Overview_of_Order_Line_Items) feature is now generally available to all Zuora customers. You need to enable the [Orders](https://knowledgecenter.zuora.com/BC_Subscription_Management/Orders/AA_Overview_of_Orders#Orders) feature to access the [Order Line Items](https://knowledgecenter.zuora.com/Billing/Subscriptions/Orders/Order_Line_Items/AA_Overview_of_Order_Line_Items) feature. As of Zuora Billing Release 313 (November 2021), new customers who onboard on [Orders](https://knowledgecenter.zuora.com/Billing/Subscriptions/Orders/AA_Overview_of_Orders) will have the [Order Line Items](https://knowledgecenter.zuora.com/Billing/Subscriptions/Orders/Order_Line_Items) feature enabled by default.         - You cannot preview enhanced discounts.  In the case where a normal \&quot;Preview an order\&quot; operation call will time out, use this operation instead to preview an order asynchronously. A job will be previewing the order in the back end; the job ID will be returned for tracking the job status and result.  #### Billing preview behavior regarding draft invoices By default, the billing preview behavior regarding draft invoices is as below: * When you preview billing for your order and the order contains subscriptions only, the draft invoices are excluded. * When you preview billing for your order and the order contains order line items only, the draft invoices are included. * When you preview billing for an order that contains both subscriptions  order line items, the draft invoices are included for both subscriptions and order line items.  However, if you want to always exclude the draft invoices in billing preview, submit a request at [Zuora Global Support](https://support.zuora.com).  #### Limits on Orders API  The limit of orders allowed on a subscription is 1000.  The limit of order line items allowed in an order is 100.  Zuora has the following limits on the Orders synchronous API to prevent performance degradation:  * Up to 50 subscriptions are allowed in a single [Create an order](https://developer.zuora.com/api-references/api/operation/POST_Order) or [Preview an order](https://developer.zuora.com/api-references/api/operation/POST_PreviewOrder) operation call. * Up to 50 order actions are allowed in a single [Create an order](https://developer.zuora.com/api-references/api/operation/POST_Order) or [Preview an order](https://developer.zuora.com/api-references/api/operation/POST_PreviewOrder) operation call. * Up to 50 order actions are allowed on a single subscription in a [Create an order](https://developer.zuora.com/api-references/api/operation/POST_Order) or [Preview an order](https://developer.zuora.com/api-references/api/operation/POST_PreviewOrder) operation call.  If you have an Order that exceeds any limits of the above, Zuora recommends you use the following asynchronous API operations: * [Create an order asynchronously](https://developer.zuora.com/api-references/api/operation/POST_CreateOrderAsynchronously) * [Preview an order asynchronously](https://developer.zuora.com/api-references/api/operation/POST_PreviewOrderAsynchronously) * [Retrieve the status and response of a job](https://developer.zuora.com/api-references/api/operation/GET_JobStatusAndResponse) for checking the status of the asynchronous API operations  Zuora has the following limits on the Orders asynchronous API operations to prevent performance degradation: * Up to 300 subscriptions are allowed in a single [Create an order asynchronously](https://developer.zuora.com/api-references/api/operation/POST_CreateOrderAsynchronously) or [Preview an order asynchronously](https://developer.zuora.com/api-references/api/operation/POST_PreviewOrderAsynchronously) operation call. * Up to 300 order actions are allowed in a single [Create an order asynchronously](https://developer.zuora.com/api-references/api/operation/POST_CreateOrderAsynchronously) or [Preview an order asynchronously](https://developer.zuora.com/api-references/api/operation/POST_PreviewOrderAsynchronously) operation call. * Up to 300 order actions are allowed on a single subscription in a [Create an order asynchronously](https://developer.zuora.com/api-references/api/operation/POST_CreateOrderAsynchronously) or [Preview an order asynchronously](https://developer.zuora.com/api-references/api/operation/POST_PreviewOrderAsynchronously) operation call. 
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void previewOrderAsynchronouslyTest() throws ApiException {
        LocalDate orderDate = null;
        PreviewOptions previewOptions = null;
        String description = null;
        String category = null;
        Map<String, Object> customFields = null;
        String existingAccountNumber = null;
        List<OrderLineItemCommonPostOrder> orderLineItems = null;
        String orderNumber = null;
        PreviewAccountInfo previewAccountInfo = null;
        String reasonCode = null;
        List<POSTOrderPreviewRequestTypeSubscriptionsInner> subscriptions = null;
        String idempotencyKey = null;
        String acceptEncoding = null;
        String contentEncoding = null;
        String authorization = null;
        String zuoraTrackId = null;
        String zuoraEntityIds = null;
        String zuoraOrgIds = null;
        PostPreviewOrderAsynchronouslyResponse response = api.previewOrderAsynchronously(orderDate, previewOptions)
                .description(description)
                .category(category)
                .customFields(customFields)
                .existingAccountNumber(existingAccountNumber)
                .orderLineItems(orderLineItems)
                .orderNumber(orderNumber)
                .previewAccountInfo(previewAccountInfo)
                .reasonCode(reasonCode)
                .subscriptions(subscriptions)
                .idempotencyKey(idempotencyKey)
                .acceptEncoding(acceptEncoding)
                .contentEncoding(contentEncoding)
                .authorization(authorization)
                .zuoraTrackId(zuoraTrackId)
                .zuoraEntityIds(zuoraEntityIds)
                .zuoraOrgIds(zuoraOrgIds)
                .execute();
        // TODO: test validations
    }

    /**
     * Update order custom fields
     *
     * **Note:** This feature is only available if you have the [Order Metrics](https://knowledgecenter.zuora.com/BC_Subscription_Management/Orders/AA_Overview_of_Orders#Order_Metrics) feature enabled. As of Zuora Billing Release 284, Orders is generally available and the Order Metrics feature is no longer available as a standalone feature. If you are an existing Subscribe and Amend customer and want Order Metrics only, you must turn on [Orders Harmonization](https://knowledgecenter.zuora.com/Billing/Subscriptions/Orders/Orders_Harmonization/Orders_Harmonization). You can still keep the existing Subscribe and Amend API integrations to create and manage subscriptions.  **Note:** To update the custom fields of an order line item, you must use the \&quot;Update an order line item\&quot; or \&quot;Update order line items\&quot; operation.  Updates the custom fields of a specified order. 
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void updateOrderCustomFieldsTest() throws ApiException {
        String orderNumber = null;
        Map<String, Object> customFields = null;
        List<PUTOrderPatchRequestTypeSubscriptionsInner> subscriptions = null;
        String acceptEncoding = null;
        String contentEncoding = null;
        String authorization = null;
        String zuoraTrackId = null;
        String zuoraEntityIds = null;
        String zuoraOrgIds = null;
        CommonResponse response = api.updateOrderCustomFields(orderNumber)
                .customFields(customFields)
                .subscriptions(subscriptions)
                .acceptEncoding(acceptEncoding)
                .contentEncoding(contentEncoding)
                .authorization(authorization)
                .zuoraTrackId(zuoraTrackId)
                .zuoraEntityIds(zuoraEntityIds)
                .zuoraOrgIds(zuoraOrgIds)
                .execute();
        // TODO: test validations
    }

    /**
     * Update subscription custom fields
     *
     * **Note:** This operation is only available if you have the [Orders](https://knowledgecenter.zuora.com/BC_Subscription_Management/Orders/AA_Overview_of_Orders#Orders) feature enabled. If you are an existing Zuora &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Subscriptions/Subscriptions/Subscribe_and_Amend\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Subscribe and Amend&lt;/a&gt; customer, we recommend you enable &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Subscriptions/Subscriptions/Orders_Harmonization/A_Overview_of_Orders_Harmonization\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Orders Harmonization&lt;/a&gt; to access the &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Subscriptions/Subscriptions/Orders/AA_Overview_of_Orders/A_Overview_of_Orders\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Orders&lt;/a&gt; feature. With Orders, you can access both existing functions for subscription and billing management and the &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Subscriptions/Subscriptions/Orders_Harmonization/P_FAQ_about_Orders_Harmonization#New+features+through+Orders\&quot; target&#x3D;\&quot;_blank\&quot;&gt;new features&lt;/a&gt; on Zuora Billing.  Updates the custom fields of a specified subscription. 
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void updateSubscriptionCustomFieldsTest() throws ApiException {
        String subscriptionNumber = null;
        Map<String, Object> customFields = null;
        List<PUTSubscriptionPatchRequestTypeRatePlansInner> ratePlans = null;
        String acceptEncoding = null;
        String contentEncoding = null;
        String authorization = null;
        String zuoraTrackId = null;
        String zuoraEntityIds = null;
        String zuoraOrgIds = null;
        CommonResponse response = api.updateSubscriptionCustomFields(subscriptionNumber)
                .customFields(customFields)
                .ratePlans(ratePlans)
                .acceptEncoding(acceptEncoding)
                .contentEncoding(contentEncoding)
                .authorization(authorization)
                .zuoraTrackId(zuoraTrackId)
                .zuoraEntityIds(zuoraEntityIds)
                .zuoraOrgIds(zuoraOrgIds)
                .execute();
        // TODO: test validations
    }

}
