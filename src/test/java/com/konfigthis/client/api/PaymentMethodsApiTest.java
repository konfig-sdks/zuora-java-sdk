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
import com.konfigthis.client.model.CreatePaymentMethodCardholderInfo;
import com.konfigthis.client.model.CreateStoredCredentialProfileRequest;
import com.konfigthis.client.model.DELETEUnresigerApplePayDomainResponse;
import com.konfigthis.client.model.GETListApplePayDomainsResponse;
import com.konfigthis.client.model.GETPaymentMethodResponse;
import com.konfigthis.client.model.GetStoredCredentialProfilesResponse;
import java.time.LocalDate;
import com.konfigthis.client.model.ModifiedStoredCredentialProfileResponse;
import com.konfigthis.client.model.POSTCreatePaymentSessionRequest;
import com.konfigthis.client.model.POSTCreatePaymentSessionResponse;
import com.konfigthis.client.model.POSTPaymentMethodDecryption;
import com.konfigthis.client.model.POSTPaymentMethodResponse;
import com.konfigthis.client.model.POSTPaymentMethodResponseDecryption;
import com.konfigthis.client.model.POSTRegisterApplePayDomainRequest;
import com.konfigthis.client.model.POSTRegisterApplePayDomainResponse;
import com.konfigthis.client.model.PUTPMAccountHolderInfo;
import com.konfigthis.client.model.PUTPaymentMethodRequest;
import com.konfigthis.client.model.PUTPaymentMethodRequestAllOfGatewayOptions;
import com.konfigthis.client.model.PUTPaymentMethodRequestAllOfMandateInfo;
import com.konfigthis.client.model.PUTPaymentMethodRequestAllOfProcessingOptions;
import com.konfigthis.client.model.PUTPaymentMethodResponse;
import com.konfigthis.client.model.PUTVerifyPaymentMethodResponseType;
import com.konfigthis.client.model.PUTVerifyPaymentMethodType;
import com.konfigthis.client.model.PUTVerifyPaymentMethodTypeGatewayOptions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for PaymentMethodsApi
 */
@Disabled
public class PaymentMethodsApiTest {

    private static PaymentMethodsApi api;

    
    @BeforeAll
    public static void beforeClass() {
        ApiClient apiClient = Configuration.getDefaultApiClient();
        api = new PaymentMethodsApi(apiClient);
    }

    /**
     * Cancel a stored credential profile
     *
     * Cancels a stored credential profile within a payment method.  Cancelling the stored credential profile indicates that the stored credentials are no longer valid, per a customer request. You cannot reactivate the stored credential profile after you have cancelled it. 
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void cancelStoredCredentialProfileTest() throws ApiException {
        String paymentMethodId = null;
        Integer profileNumber = null;
        String idempotencyKey = null;
        String acceptEncoding = null;
        String contentEncoding = null;
        String authorization = null;
        String zuoraTrackId = null;
        String zuoraEntityIds = null;
        String zuoraOrgIds = null;
        ModifiedStoredCredentialProfileResponse response = api.cancelStoredCredentialProfile(paymentMethodId, profileNumber)
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
     * Create a payment session
     *
     * When implementing Apple Pay integration by using Zuora&#39;s JavaScript SDK, use this operation to create a payment session on your server side. The response of this API operation contains a token for the payment session data. Send the token back to your client side to use in the subsequent implementation step. For more information, see [Set up Apple Pay through the JavaScript SDK approach](https://knowledgecenter.zuora.com/Zuora_Payments/Payment_Methods/B_Define_Payment_Methods/Set_up_Apple_Pay_for_gateway_integrations_other_than_Adyen_Integration_v2.0). 
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void createPaymentSessionTest() throws ApiException {
        String accountId = null;
        String currency = null;
        String paymentGateway = null;
        Boolean processPayment = null;
        Double amount = null;
        Double authAmount = null;
        String idempotencyKey = null;
        String acceptEncoding = null;
        String contentEncoding = null;
        String authorization = null;
        String zuoraTrackId = null;
        String zuoraEntityIds = null;
        String zuoraOrgIds = null;
        POSTCreatePaymentSessionResponse response = api.createPaymentSession(accountId, currency, paymentGateway, processPayment)
                .amount(amount)
                .authAmount(authAmount)
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
     * Create a stored credential profile
     *
     * Creates a stored credential profile within a payment method.  The stored credential profile represents a consent agreement that you have established with a customer. When you use the payment method in a transaction, Zuora may include information from the stored credential profile to inform the payment processor that the transaction is related to your pre-existing consent agreement with the customer. 
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void createStoredCredentialProfileTest() throws ApiException {
        String consentAgreementSrc = null;
        String status = null;
        String type = null;
        String paymentMethodId = null;
        String action = null;
        LocalDate agreedOn = null;
        String authGateway = null;
        String cardSecurityCode = null;
        String consentAgreementRef = null;
        String networkTransactionId = null;
        String idempotencyKey = null;
        String acceptEncoding = null;
        String contentEncoding = null;
        String authorization = null;
        String zuoraTrackId = null;
        String zuoraEntityIds = null;
        String zuoraOrgIds = null;
        ModifiedStoredCredentialProfileResponse response = api.createStoredCredentialProfile(consentAgreementSrc, status, type, paymentMethodId)
                .action(action)
                .agreedOn(agreedOn)
                .authGateway(authGateway)
                .cardSecurityCode(cardSecurityCode)
                .consentAgreementRef(consentAgreementRef)
                .networkTransactionId(networkTransactionId)
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
     * Expire a stored credential profile
     *
     * Expires a stored credential profile within a payment method.  Expiring the stored credential profile indicates that the stored credentials are no longer valid, per an expiration policy in the stored credential transaction framework. You cannot reactivate the stored credential profile after you have expired it. 
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void expireStoredCredentialProfileTest() throws ApiException {
        String paymentMethodId = null;
        Integer profileNumber = null;
        String idempotencyKey = null;
        String acceptEncoding = null;
        String contentEncoding = null;
        String authorization = null;
        String zuoraTrackId = null;
        String zuoraEntityIds = null;
        String zuoraOrgIds = null;
        ModifiedStoredCredentialProfileResponse response = api.expireStoredCredentialProfile(paymentMethodId, profileNumber)
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
     * List registered Apple Pay domains
     *
     * Use this operation to retrieve details of your domains that are already registered with Apple for Apple Pay button integration implemented through Zuora&#39;s JavaScript SDK.  You can use &#x60;domainName&#x60; as the query parameter to restrict domains returned in the response. Specify a domain name and the registered domains containing the specified domain name will be returned.  For more information about Zuora&#39;s JavaScript SDK for Apple Pay integration, see &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Payments/Payment_Methods/B_Define_Payment_Methods/Set_up_Apple_Pay_for_gateway_integrations_other_than_Adyen_Integration_v2.0\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Set up Apple Pay through the JavaScript SDK approach&lt;/a&gt;. 
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void listApplePayDomainsTest() throws ApiException {
        String idempotencyKey = null;
        String acceptEncoding = null;
        String contentEncoding = null;
        String authorization = null;
        String zuoraTrackId = null;
        String zuoraEntityIds = null;
        String zuoraOrgIds = null;
        String domainName = null;
        GETListApplePayDomainsResponse response = api.listApplePayDomains()
                .idempotencyKey(idempotencyKey)
                .acceptEncoding(acceptEncoding)
                .contentEncoding(contentEncoding)
                .authorization(authorization)
                .zuoraTrackId(zuoraTrackId)
                .zuoraEntityIds(zuoraEntityIds)
                .zuoraOrgIds(zuoraOrgIds)
                .domainName(domainName)
                .execute();
        // TODO: test validations
    }

    /**
     * Retrieve a payment method
     *
     * This operation allows you to get the detailed information about a payment method.  **Note:** This operation also supports retrieving the custom payment method created through the [Open Payment Method](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/MB_Set_up_custom_payment_gateways_and_payment_methods) service. 
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void paymentMethodTest() throws ApiException {
        String paymentMethodId = null;
        String acceptEncoding = null;
        String contentEncoding = null;
        String authorization = null;
        String zuoraTrackId = null;
        String zuoraEntityIds = null;
        String zuoraOrgIds = null;
        GETPaymentMethodResponse response = api.paymentMethod(paymentMethodId)
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
     * Update a payment method
     *
     * This operation allows you to update an existing payment method.   The following request body fields can be updated for any payment method types except for Credit Card Reference Transaction: * &#x60;authGateway&#x60; * &#x60;gatewayOptions&#x60; * &#x60;accountHolderInfo&#x60; * &#x60;ipAddress&#x60; * Custom fields  The following request body fields can be updated only for the Credit Card payment method: * &#x60;expirationMonth&#x60;  * &#x60;expirationYear&#x60; * &#x60;securityCode&#x60;  The following request body field can be updated for the Credit Card, Credit Card Reference Transaction, ACH, and Bank Transfer payment methods: * &#x60;mandateInfo&#x60;  
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void paymentMethod_0Test() throws ApiException {
        String paymentMethodId = null;
        PUTPMAccountHolderInfo accountHolderInfo = null;
        String accountKey = null;
        String authGateway = null;
        String currencyCode = null;
        PUTPaymentMethodRequestAllOfGatewayOptions gatewayOptions = null;
        String ipAddress = null;
        PUTPaymentMethodRequestAllOfMandateInfo mandateInfo = null;
        PUTPaymentMethodRequestAllOfProcessingOptions processingOptions = null;
        Integer expirationMonth = null;
        Integer expirationYear = null;
        String securityCode = null;
        String acceptEncoding = null;
        String contentEncoding = null;
        String authorization = null;
        String zuoraTrackId = null;
        String zuoraEntityIds = null;
        String zuoraOrgIds = null;
        PUTPaymentMethodResponse response = api.paymentMethod_0(paymentMethodId)
                .accountHolderInfo(accountHolderInfo)
                .accountKey(accountKey)
                .authGateway(authGateway)
                .currencyCode(currencyCode)
                .gatewayOptions(gatewayOptions)
                .ipAddress(ipAddress)
                .mandateInfo(mandateInfo)
                .processingOptions(processingOptions)
                .expirationMonth(expirationMonth)
                .expirationYear(expirationYear)
                .securityCode(securityCode)
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
     * Create a payment method
     *
     * You can use this operation to create either a payment method associated  with a specific customer account, or an orphan payment method that is not associated with any customer account. The orphan payment method must be associated with a customer account within 10 days. Otherwise, it will be deleted.  To view the applicable fields for each payment method type, select the payment method type from the &#x60;type&#x60; list. The following types of the payment methods are supported:    * &#x60;CreditCard&#x60; - Credit card payment method.    * &#x60;CreditCardReferenceTransaction&#x60; - Credit Card Reference   Transaction. See [Supported payment   methods](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/L_Payment_Methods/Supported_Payment_Methods)   for payment gateways that support this type of payment method.    * &#x60;ACH&#x60; - ACH payment method.    * &#x60;SEPA&#x60; - Single Euro Payments Area.    * &#x60;Betalingsservice&#x60; - Direct Debit DK.    * &#x60;Autogiro&#x60; - Direct Debit SE.    * &#x60;Bacs&#x60; - Direct Debit UK.    * &#x60;Becs&#x60; - Direct Entry AU.    * &#x60;Becsnz&#x60; - Direct Debit NZ.    * &#x60;PAD&#x60; - Pre-Authorized Debit.    * &#x60;PayPalCP&#x60; - PayPal Commerce Platform payment method. Use this type   if you are using a [PayPal Commerce Platform   Gateway](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/M_Payment_Gateways/Supported_Payment_Gateways/PayPal_Commerce_Platform_Gateway)   instance.    * &#x60;PayPalEC&#x60; - PayPal Express Checkout payment method. Use this type   if you are using a [PayPal Payflow Pro   Gateway](https://knowledgecenter.zuora.com/CB_Billing/M_Payment_Gateways/Supported_Payment_Gateways/PayPal_Payflow_Pro%2C_Website_Payments_Payflow_Edition%2C_Website_Pro_Payment_Gateway)   instance.    * &#x60;PayPalNativeEC&#x60; - PayPal Native Express Checkout payment method.   Use this type if you are using a [PayPal Express Checkout   Gateway](https://knowledgecenter.zuora.com/CB_Billing/M_Payment_Gateways/Supported_Payment_Gateways/PayPal_Express_Checkout_Gateway)   instance.    * &#x60;PayPalAdaptive&#x60; - PayPal Adaptive payment method. Use this type if   you are using a [PayPal Adaptive Payment   Gateway](https://knowledgecenter.zuora.com/CB_Billing/M_Payment_Gateways/Supported_Payment_Gateways/PayPal_Adaptive_Payments_Gateway)   instance.    * &#x60;AdyenApplePay&#x60; - Apple Pay on Adyen Integration v2.0. See [Set up   Adyen Apple   Pay](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/L_Payment_Methods/Payment_Method_Types/Apple_Pay_on_Web/Set_up_Adyen_Apple_Pay)   for details.    * &#x60;AdyenGooglePay&#x60; - Google Pay on Adyen Integration v2.0. See [Set up   Adyen Google   Pay](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/L_Payment_Methods/Payment_Method_Types/Set_up_Adyen_Google_Pay)   for details.    * &#x60;GooglePay&#x60; - Google Pay on Chase Paymentech Orbital gateway   integration. See [Set up Google Pay on   Chase](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/L_Payment_Methods/Payment_Method_Types/Set_up_Google_Pay_on_Chase)   for details.       You can also specify a custom payment method type. See [Set up   custom payment gateways and payment   methods](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/MB_Set_up_custom_payment_gateways_and_payment_methods)   for details. 
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void paymentMethodsTest() throws ApiException {
        String idempotencyKey = null;
        String acceptEncoding = null;
        String contentEncoding = null;
        String authorization = null;
        String zuoraTrackId = null;
        String zuoraEntityIds = null;
        String zuoraOrgIds = null;
        POSTPaymentMethodResponse response = api.paymentMethods()
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
     * Create an Apple Pay payment method
     *
     * The decryption API endpoint can conditionally perform 4 tasks in one atomic call:   * Decrypt Apple Pay Payment token   * Create Credit Card Payment Method in Zuora with decrypted Apple Pay information   * Create a stored credential profile within the Apple Pay payment method   * Process Payment on a specified Invoice (optional) 
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void paymentMethodsDecryptionTest() throws ApiException {
        String integrationType = null;
        String merchantID = null;
        Object paymentToken = null;
        String accountID = null;
        CreatePaymentMethodCardholderInfo cardHolderInfo = null;
        String invoiceId = null;
        String mitConsentAgreementSrc = null;
        String mitProfileAction = null;
        String mitProfileType = null;
        String paymentGateway = null;
        Boolean processPayment = null;
        String idempotencyKey = null;
        String acceptEncoding = null;
        String contentEncoding = null;
        String authorization = null;
        String zuoraTrackId = null;
        String zuoraEntityIds = null;
        String zuoraOrgIds = null;
        POSTPaymentMethodResponseDecryption response = api.paymentMethodsDecryption(integrationType, merchantID, paymentToken)
                .accountID(accountID)
                .cardHolderInfo(cardHolderInfo)
                .invoiceId(invoiceId)
                .mitConsentAgreementSrc(mitConsentAgreementSrc)
                .mitProfileAction(mitProfileAction)
                .mitProfileType(mitProfileType)
                .paymentGateway(paymentGateway)
                .processPayment(processPayment)
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
     * Delete a payment method
     *
     * Deletes a credit card payment method.  If the specified payment method is the account&#39;s default payment method, the request will fail.  In that case, you must first designate a different payment method for that customer to be the default. 
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void paymentMethods_0Test() throws ApiException {
        String paymentMethodId = null;
        String acceptEncoding = null;
        String contentEncoding = null;
        String authorization = null;
        String zuoraTrackId = null;
        String zuoraEntityIds = null;
        String zuoraOrgIds = null;
        CommonResponse response = api.paymentMethods_0(paymentMethodId)
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
     * Register an Apple Pay domain
     *
     * Before adding Apple Pay to your checkout flow by integrating with the JavaScript SDK provided by Zuora, your domains that will show the Apple Pay button must be registered with Apple. Use this operation to register a domain.   For more information about Zuora&#39;s JavaScript SDK for Apple Pay integration, see &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Payments/Payment_Methods/B_Define_Payment_Methods/Set_up_Apple_Pay_for_gateway_integrations_other_than_Adyen_Integration_v2.0\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Set up Apple Pay through the JavaScript SDK approach&lt;/a&gt;. 
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void registerApplePayDomainTest() throws ApiException {
        String domainName = null;
        String idempotencyKey = null;
        String acceptEncoding = null;
        String contentEncoding = null;
        String authorization = null;
        String zuoraTrackId = null;
        String zuoraEntityIds = null;
        String zuoraOrgIds = null;
        POSTRegisterApplePayDomainResponse response = api.registerApplePayDomain(domainName)
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
     * Scrub a payment method
     *
     *  This operation enables you to replace all sensitive data in a payment method, related payment method snapshot table, and four related log tables with dummy values that will be stored in Zuora databases.   This operation will scrub the sensitive data and soft-delete the specified payment method at the same time.   If you want to delete or anonymize personal data in Zuora, you must scrub the payment method before anonymizing the associated account and contact. See [Delete or anonymize personal data](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Responding_to_individual_requests_for_access%2C_correction%2C_and_deletion_of_data_under_applicable_privacy_laws#Edit_and_correct_personal_data) for more information.  **Note:** In order to use this operation, you must ensure that the **Scrub Sensitive Data of Specific Payment Method payments** permission is enabled in your user role. Contact your tenant administrator if you want to enable this permission. See [Scrub Payment Methods](https://knowledgecenter.zuora.com/CB_Billing/L_Payment_Methods/Scrub_Payment_Methods) for more information. 
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void scrubPaymentMethodsTest() throws ApiException {
        String paymentMethodId = null;
        String acceptEncoding = null;
        String contentEncoding = null;
        String authorization = null;
        String zuoraTrackId = null;
        String zuoraEntityIds = null;
        String zuoraOrgIds = null;
        CommonResponse response = api.scrubPaymentMethods(paymentMethodId)
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
     * List stored credential profiles of a payment method
     *
     * Retrieves the stored credential profiles within a payment method. 
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void storedCredentialProfilesTest() throws ApiException {
        String paymentMethodId = null;
        String acceptEncoding = null;
        String contentEncoding = null;
        String authorization = null;
        String zuoraTrackId = null;
        String zuoraEntityIds = null;
        String zuoraOrgIds = null;
        Boolean includeAll = null;
        GetStoredCredentialProfilesResponse response = api.storedCredentialProfiles(paymentMethodId)
                .acceptEncoding(acceptEncoding)
                .contentEncoding(contentEncoding)
                .authorization(authorization)
                .zuoraTrackId(zuoraTrackId)
                .zuoraEntityIds(zuoraEntityIds)
                .zuoraOrgIds(zuoraOrgIds)
                .includeAll(includeAll)
                .execute();
        // TODO: test validations
    }

    /**
     * Unregister an Apple Pay domain
     *
     * Use this operation to unregister a domain with Apple for Apple Pay button integration implemented through Zuora&#39;s JavaScript SDK.  For more information about Zuora&#39;s JavaScript SDK for Apple Pay integration, see &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Payments/Payment_Methods/B_Define_Payment_Methods/Set_up_Apple_Pay_for_gateway_integrations_other_than_Adyen_Integration_v2.0\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Set up Apple Pay through the JavaScript SDK approach&lt;/a&gt;. 
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void unregisterApplePayDomainTest() throws ApiException {
        String id = null;
        String idempotencyKey = null;
        String acceptEncoding = null;
        String contentEncoding = null;
        String authorization = null;
        String zuoraTrackId = null;
        String zuoraEntityIds = null;
        String zuoraOrgIds = null;
        DELETEUnresigerApplePayDomainResponse response = api.unregisterApplePayDomain(id)
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
     * Verify a payment method
     *
     * Sends an authorization request to the corresponding payment gateway to verify the payment method, even though no changes are made for the payment method. Supported payment methods are Credit Cards and Paypal.  Zuora now supports performing a standalone zero dollar verification or one dollar authorization for credit cards. It also supports a billing agreement status check on PayPal payment methods.  If a payment method is created by Hosted Payment Pages and is not assigned to any billing account, the payment method cannot be verified through this operation. 
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void verifyPaymentMethodsTest() throws ApiException {
        String paymentMethodId = null;
        String currencyCode = null;
        PUTVerifyPaymentMethodTypeGatewayOptions gatewayOptions = null;
        String paymentGatewayName = null;
        String securityCode = null;
        String acceptEncoding = null;
        String contentEncoding = null;
        String authorization = null;
        String zuoraTrackId = null;
        PUTVerifyPaymentMethodResponseType response = api.verifyPaymentMethods(paymentMethodId)
                .currencyCode(currencyCode)
                .gatewayOptions(gatewayOptions)
                .paymentGatewayName(paymentGatewayName)
                .securityCode(securityCode)
                .acceptEncoding(acceptEncoding)
                .contentEncoding(contentEncoding)
                .authorization(authorization)
                .zuoraTrackId(zuoraTrackId)
                .execute();
        // TODO: test validations
    }

}
