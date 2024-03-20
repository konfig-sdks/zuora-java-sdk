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
import com.konfigthis.client.model.ApplyPaymentType;
import com.konfigthis.client.model.CommonResponse;
import com.konfigthis.client.model.CreatePaymentType;
import com.konfigthis.client.model.CreatePaymentTypeAllOfFinanceInformation;
import com.konfigthis.client.model.CreatePaymentTypeAllOfGatewayOptions;
import com.konfigthis.client.model.GETARPaymentType;
import com.konfigthis.client.model.GETARPaymentTypeWithPaymentOption;
import com.konfigthis.client.model.GETPaymentItemPartCollectionType;
import com.konfigthis.client.model.GETPaymentItemPartType;
import com.konfigthis.client.model.GETPaymentPartType;
import com.konfigthis.client.model.GETPaymentPartsCollectionType;
import com.konfigthis.client.model.GETRefundPaymentType;
import com.konfigthis.client.model.GETRefundPaymentTypeAutoUnapply;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import com.konfigthis.client.model.PaymentCollectionResponseType;
import com.konfigthis.client.model.PaymentDebitMemoApplicationApplyRequestType;
import com.konfigthis.client.model.PaymentDebitMemoApplicationCreateRequestType;
import com.konfigthis.client.model.PaymentDebitMemoApplicationUnapplyRequestType;
import com.konfigthis.client.model.PaymentInvoiceApplicationApplyRequestType;
import com.konfigthis.client.model.PaymentInvoiceApplicationCreateRequestType;
import com.konfigthis.client.model.PaymentInvoiceApplicationUnapplyRequestType;
import com.konfigthis.client.model.PaymentSchedulePaymentOptionFields;
import com.konfigthis.client.model.PaymentWithCustomRatesType;
import com.konfigthis.client.model.PostRefundType;
import com.konfigthis.client.model.PostRefundTypeAllOfFinanceInformation;
import com.konfigthis.client.model.PostRefundTypeAllOfGatewayOptions;
import com.konfigthis.client.model.PostRefundwithAutoUnapplyType;
import com.konfigthis.client.model.PostRefundwithAutoUnapplyTypeAllOfWriteOffOptions;
import com.konfigthis.client.model.TransferPaymentType;
import com.konfigthis.client.model.UnapplyPaymentType;
import com.konfigthis.client.model.UpdatePaymentType;
import com.konfigthis.client.model.UpdatePaymentTypeAllOfFinanceInformation;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for PaymentsApi
 */
@Disabled
public class PaymentsApiTest {

    private static PaymentsApi api;

    
    @BeforeAll
    public static void beforeClass() {
        ApiClient apiClient = Configuration.getDefaultApiClient();
        api = new PaymentsApi(apiClient);
    }

    /**
     * Apply a payment
     *
     * **Note:** This operation is only available if you have [Invoice Settlement](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/Invoice_Settlement) enabled. The Invoice Settlement feature is generally available as of Zuora Billing Release 296 (March 2021). This feature includes Unapplied Payments, Credit and Debit Memo, and Invoice Item Settlement. If you want to enable Invoice Settlement, see [Invoice Settlement Enablement and Checklist Guide](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/Invoice_Settlement/Invoice_Settlement_Migration_Checklist_and_Guide) for more information.   Applies an unapplied payment to invoices and debit memos.  When you apply a payment, the total number of invoice items and debit memo items that the payment will apply to must be less than or equal to 15,000.          If the limit is hit, you can follow the instructions: - If you want to apply one payment to multiple invoices or debit memos, decrease the number of invoices or debit memos in the request. - If you want to apply one payment to a single invoice or debit memo with a large volume of items, you have to specify invoice items in the request. The maximum number of invoice items that you can specify in the request is 1,000.  For more information, see [Apply Unapplied Payments to Invoices and Debit Memos](https://knowledgecenter.zuora.com/CB_Billing/Invoice_Settlement/A_Unapplied_Payments/Management_of_Unapplied_Payments/Apply_Unapplied_Payments_to_Invoices_and_Debit_Memos). 
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void applyPaymentTest() throws ApiException {
        String paymentKey = null;
        List<PaymentDebitMemoApplicationApplyRequestType> debitMemos = null;
        LocalDate effectiveDate = null;
        List<PaymentInvoiceApplicationApplyRequestType> invoices = null;
        String acceptEncoding = null;
        String contentEncoding = null;
        String authorization = null;
        String zuoraTrackId = null;
        String zuoraEntityIds = null;
        String zuoraOrgIds = null;
        GETARPaymentType response = api.applyPayment(paymentKey)
                .debitMemos(debitMemos)
                .effectiveDate(effectiveDate)
                .invoices(invoices)
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
     * Cancel a payment
     *
     * **Note:** This operation is only available if you have [Invoice Settlement](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/Invoice_Settlement) enabled. The Invoice Settlement feature is generally available as of Zuora Billing Release 296 (March 2021). This feature includes Unapplied Payments, Credit and Debit Memo, and Invoice Item Settlement. If you want to enable Invoice Settlement, see [Invoice Settlement Enablement and Checklist Guide](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/Invoice_Settlement/Invoice_Settlement_Migration_Checklist_and_Guide) for more information.   Cancels a payment.   If you have the Invoice Settlement feature enabled, overpayments applied to credit balance cannot be cancelled. 
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void cancelPaymentTest() throws ApiException {
        String paymentKey = null;
        String acceptEncoding = null;
        String contentEncoding = null;
        String authorization = null;
        String zuoraTrackId = null;
        String zuoraEntityIds = null;
        String zuoraOrgIds = null;
        GETARPaymentType response = api.cancelPayment(paymentKey)
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
     * Create a payment
     *
     * **Note:** This operation is only available if you have [Invoice Settlement](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/Invoice_Settlement) enabled. The Invoice Settlement feature is generally available as of Zuora Billing Release 296 (March 2021). This feature includes Unapplied Payments, Credit and Debit Memo, and Invoice Item Settlement. If you want to enable Invoice Settlement, see [Invoice Settlement Enablement and Checklist Guide](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/Invoice_Settlement/Invoice_Settlement_Migration_Checklist_and_Guide) for more information.   Creates a payment in the following scenarios:  - A full or partial payment on an invoice or a debit memo - A full or partial payment on several invoices and debit memos - An unapplied payment in the following situations:   - You do not know which customer account the payment belongs to.   - You know which customer account the payment belongs to, but you do not know which invoice the payment is applied to.   - You receive a payment from your customer that exceeds the balance on the invoice.   - You receive a payment from your customer before the invoice has been created.   - You intend to create a payment without any invoices or debit memos. - A standalone payment. If you only need to create and process an electronic payment in Zuora through a Zuora gateway integration but settle the payment outside of Zuora, you can create a standalone payment. For a standalone payment, you can specify a currency different from the payment currency in the customer account settings. When Standalone Payment is not enabled, the currency of the standalone payment can be different from the payment currency defined in the customer account settings if you have the [Multiple Currencies](https://knowledgecenter.zuora.com/Zuora_Billing/Bill_your_customers/Flexible_Billing/Multiple_Currencies) feature enabled.     The support for standalone payments is in the Early Adopter phase. To manage and access this feature through the self-service interface, see [Manage Features](https://knowledgecenter.zuora.com/Zuora_Payments/Payments_Settings/Manage_Features) in the Knowledge Center.   If you do not know to which customer account the payment belongs, you can create a payment without specifying a customer account.  When you create a payment, the total number of invoice items and debit memo items that the payment will apply to should be less than or equal to 15,000.  For more information, see [Create Payments](https://knowledgecenter.zuora.com/CB_Billing/Invoice_Settlement/A_Unapplied_Payments/Management_of_Unapplied_Payments/AA_Create_Payments) and [Create Payments Without Specifying Customer Accounts](https://knowledgecenter.zuora.com/CB_Billing/Invoice_Settlement/A_Unapplied_Payments/Management_of_Unapplied_Payments/AA_Create_Payments_Without_Specifying_Customer_Accounts).      
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void createPaymentTest() throws ApiException {
        String accountId = null;
        String accountNumber = null;
        Double amount = null;
        String authTransactionId = null;
        String comment = null;
        String currency = null;
        List<PaymentWithCustomRatesType> customRates = null;
        List<PaymentDebitMemoApplicationCreateRequestType> debitMemos = null;
        LocalDate effectiveDate = null;
        CreatePaymentTypeAllOfFinanceInformation financeInformation = null;
        String gatewayId = null;
        CreatePaymentTypeAllOfGatewayOptions gatewayOptions = null;
        String gatewayOrderId = null;
        List<PaymentInvoiceApplicationCreateRequestType> invoices = null;
        String mitTransactionSource = null;
        String paymentGatewayNumber = null;
        String paymentMethodId = null;
        String paymentMethodType = null;
        List<PaymentSchedulePaymentOptionFields> paymentOption = null;
        String paymentScheduleKey = null;
        Boolean prepayment = null;
        String referenceId = null;
        String softDescriptor = null;
        String softDescriptorPhone = null;
        Boolean standalone = null;
        String type = null;
        String integrationIdNS = null;
        String integrationStatusNS = null;
        String originNS = null;
        String syncDateNS = null;
        String transactionNS = null;
        String idempotencyKey = null;
        String acceptEncoding = null;
        String contentEncoding = null;
        String authorization = null;
        String zuoraTrackId = null;
        String zuoraEntityIds = null;
        String zuoraOrgIds = null;
        GETARPaymentTypeWithPaymentOption response = api.createPayment()
                .accountId(accountId)
                .accountNumber(accountNumber)
                .amount(amount)
                .authTransactionId(authTransactionId)
                .comment(comment)
                .currency(currency)
                .customRates(customRates)
                .debitMemos(debitMemos)
                .effectiveDate(effectiveDate)
                .financeInformation(financeInformation)
                .gatewayId(gatewayId)
                .gatewayOptions(gatewayOptions)
                .gatewayOrderId(gatewayOrderId)
                .invoices(invoices)
                .mitTransactionSource(mitTransactionSource)
                .paymentGatewayNumber(paymentGatewayNumber)
                .paymentMethodId(paymentMethodId)
                .paymentMethodType(paymentMethodType)
                .paymentOption(paymentOption)
                .paymentScheduleKey(paymentScheduleKey)
                .prepayment(prepayment)
                .referenceId(referenceId)
                .softDescriptor(softDescriptor)
                .softDescriptorPhone(softDescriptorPhone)
                .standalone(standalone)
                .type(type)
                .integrationIdNS(integrationIdNS)
                .integrationStatusNS(integrationStatusNS)
                .originNS(originNS)
                .syncDateNS(syncDateNS)
                .transactionNS(transactionNS)
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
     * Retrieve a payment
     *
     * **Note:** This operation is only available if you have [Invoice Settlement](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/Invoice_Settlement) enabled. The Invoice Settlement feature is generally available as of Zuora Billing Release 296 (March 2021). This feature includes Unapplied Payments, Credit and Debit Memo, and Invoice Item Settlement. If you want to enable Invoice Settlement, see [Invoice Settlement Enablement and Checklist Guide](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/Invoice_Settlement/Invoice_Settlement_Migration_Checklist_and_Guide) for more information.   Retrieves the information about one specific payment. 
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void paymentTest() throws ApiException {
        String paymentKey = null;
        String acceptEncoding = null;
        String contentEncoding = null;
        String authorization = null;
        String zuoraTrackId = null;
        String zuoraEntityIds = null;
        String zuoraOrgIds = null;
        GETARPaymentType response = api.payment(paymentKey)
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
     * Retrieve a payment part item
     *
     * **Note:** This operation is only available if you have the [Invoice Item Settlement](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/Invoice_Settlement/C_Invoice_Item_Settlement) feature enabled. Invoice Item Settlement must be used together with other Invoice Settlement features (Unapplied Payments, and Credit and Debit memos).  If you wish to enable Invoice Settlement, see [Invoice Settlement Enablement and Checklist Guide](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/Invoice_Settlement/Invoice_Settlement_Migration_Checklist_and_Guide) for more information.  Retrieves the information about a specific payment part item. A payment part item is a single line item in a payment part. A payment part can consist of several different types of items. 
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void paymentItemPartTest() throws ApiException {
        String partid = null;
        String itempartid = null;
        String paymentKey = null;
        String acceptEncoding = null;
        String contentEncoding = null;
        String authorization = null;
        String zuoraTrackId = null;
        String zuoraEntityIds = null;
        String zuoraOrgIds = null;
        GETPaymentItemPartType response = api.paymentItemPart(partid, itempartid, paymentKey)
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
     * List all payment part items
     *
     * **Note:** This operation is only available if you have the [Invoice Item Settlement](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/Invoice_Settlement/C_Invoice_Item_Settlement) feature enabled. Invoice Item Settlement must be used together with other Invoice Settlement features (Unapplied Payments, and Credit and Debit memos).  If you wish to enable Invoice Settlement, see [Invoice Settlement Enablement and Checklist Guide](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/Invoice_Settlement/Invoice_Settlement_Migration_Checklist_and_Guide) for more information.   Retrieves the information about all items of a payment part. A payment part item is a single line item in a payment part. A payment part can consist of several different types of items. 
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void paymentItemPartsTest() throws ApiException {
        String partid = null;
        String paymentKey = null;
        String acceptEncoding = null;
        String contentEncoding = null;
        String authorization = null;
        String zuoraTrackId = null;
        String zuoraEntityIds = null;
        String zuoraOrgIds = null;
        Integer page = null;
        Integer pageSize = null;
        GETPaymentItemPartCollectionType response = api.paymentItemParts(partid, paymentKey)
                .acceptEncoding(acceptEncoding)
                .contentEncoding(contentEncoding)
                .authorization(authorization)
                .zuoraTrackId(zuoraTrackId)
                .zuoraEntityIds(zuoraEntityIds)
                .zuoraOrgIds(zuoraOrgIds)
                .page(page)
                .pageSize(pageSize)
                .execute();
        // TODO: test validations
    }

    /**
     * Retrieve a payment part
     *
     * **Note:** This operation is only available if you have [Invoice Settlement](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/Invoice_Settlement) enabled. The Invoice Settlement feature is generally available as of Zuora Billing Release 296 (March 2021). This feature includes Unapplied Payments, Credit and Debit Memo, and Invoice Item Settlement. If you want to enable Invoice Settlement, see [Invoice Settlement Enablement and Checklist Guide](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/Invoice_Settlement/Invoice_Settlement_Migration_Checklist_and_Guide) for more information.   Retrieves the information about a specific payment part. A payment can consist of an unapplied part, and several parts applied to invoices and debit memos.  A fully refunded payment does not contain any payment part. 
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void paymentPartTest() throws ApiException {
        String partid = null;
        String paymentKey = null;
        String acceptEncoding = null;
        String contentEncoding = null;
        String authorization = null;
        String zuoraTrackId = null;
        String zuoraEntityIds = null;
        String zuoraOrgIds = null;
        GETPaymentPartType response = api.paymentPart(partid, paymentKey)
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
     * List all parts of a payment
     *
     * **Note:** This operation is only available if you have [Invoice Settlement](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/Invoice_Settlement) enabled. The Invoice Settlement feature is generally available as of Zuora Billing Release 296 (March 2021). This feature includes Unapplied Payments, Credit and Debit Memo, and Invoice Item Settlement. If you want to enable Invoice Settlement, see [Invoice Settlement Enablement and Checklist Guide](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/Invoice_Settlement/Invoice_Settlement_Migration_Checklist_and_Guide) for more information.   Retrieves the information about all parts of a payment. A payment can consist of an unapplied part, and several parts applied to invoices and debit memos. You can use this operation to get all the applied and unapplied portions of a payment. Note that a fully refunded payment does not contain any payment part. 
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void paymentPartsTest() throws ApiException {
        String paymentKey = null;
        String acceptEncoding = null;
        String contentEncoding = null;
        String authorization = null;
        String zuoraTrackId = null;
        String zuoraEntityIds = null;
        String zuoraOrgIds = null;
        Integer page = null;
        Integer pageSize = null;
        GETPaymentPartsCollectionType response = api.paymentParts(paymentKey)
                .acceptEncoding(acceptEncoding)
                .contentEncoding(contentEncoding)
                .authorization(authorization)
                .zuoraTrackId(zuoraTrackId)
                .zuoraEntityIds(zuoraEntityIds)
                .zuoraOrgIds(zuoraOrgIds)
                .page(page)
                .pageSize(pageSize)
                .execute();
        // TODO: test validations
    }

    /**
     * Delete a payment
     *
     * **Note:** This operation is only available if you have [Invoice Settlement](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/Invoice_Settlement) enabled. The Invoice Settlement feature is generally available as of Zuora Billing Release 296 (March 2021). This feature includes Unapplied Payments, Credit and Debit Memo, and Invoice Item Settlement. If you want to enable Invoice Settlement, see [Invoice Settlement Enablement and Checklist Guide](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/Invoice_Settlement/Invoice_Settlement_Migration_Checklist_and_Guide) for more information.   Deletes a payment. Only payments with the Cancelled status can be deleted.   If you have the Invoice Settlement feature enabled, overpayments applied to credit balance cannot be deleted. 
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void payment_0Test() throws ApiException {
        String paymentKey = null;
        String acceptEncoding = null;
        String contentEncoding = null;
        String authorization = null;
        String zuoraTrackId = null;
        String zuoraEntityIds = null;
        String zuoraOrgIds = null;
        CommonResponse response = api.payment_0(paymentKey)
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
     * Refund a payment
     *
     * **Note:** This operation is only available if you have [Invoice Settlement](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/Invoice_Settlement) enabled. The Invoice Settlement feature is generally available as of Zuora Billing Release 296 (March 2021). This feature includes Unapplied Payments, Credit and Debit Memo, and Invoice Item Settlement. If you want to enable Invoice Settlement, see [Invoice Settlement Enablement and Checklist Guide](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/Invoice_Settlement/Invoice_Settlement_Migration_Checklist_and_Guide) for more information.   Refunds a full or partial unapplied payment to your customers. To refund applied payments, you must unapply the applied payments from the invoices or debit memos, and then refund the unapplied payments to customers.  For more information, see [Refund Payments](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/Invoice_Settlement/A_Unapplied_Payments/Management_of_Unapplied_Payments/Y_Refund_Payments). 
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void refundPaymentTest() throws ApiException {
        String paymentKey = null;
        String comment = null;
        List<PaymentWithCustomRatesType> customRates = null;
        PostRefundTypeAllOfFinanceInformation financeInformation = null;
        PostRefundTypeAllOfGatewayOptions gatewayOptions = null;
        String methodType = null;
        String reasonCode = null;
        String referenceId = null;
        LocalDate refundDate = null;
        String secondRefundReferenceId = null;
        String softDescriptor = null;
        String softDescriptorPhone = null;
        Double totalAmount = null;
        String type = null;
        String refundTransactionType = null;
        String integrationIdNS = null;
        String integrationStatusNS = null;
        String originNS = null;
        String syncDateNS = null;
        String synctoNetSuiteNS = null;
        String idempotencyKey = null;
        String acceptEncoding = null;
        String contentEncoding = null;
        String authorization = null;
        String zuoraTrackId = null;
        String zuoraEntityIds = null;
        String zuoraOrgIds = null;
        GETRefundPaymentType response = api.refundPayment(paymentKey)
                .comment(comment)
                .customRates(customRates)
                .financeInformation(financeInformation)
                .gatewayOptions(gatewayOptions)
                .methodType(methodType)
                .reasonCode(reasonCode)
                .referenceId(referenceId)
                .refundDate(refundDate)
                .secondRefundReferenceId(secondRefundReferenceId)
                .softDescriptor(softDescriptor)
                .softDescriptorPhone(softDescriptorPhone)
                .totalAmount(totalAmount)
                .type(type)
                .refundTransactionType(refundTransactionType)
                .integrationIdNS(integrationIdNS)
                .integrationStatusNS(integrationStatusNS)
                .originNS(originNS)
                .syncDateNS(syncDateNS)
                .synctoNetSuiteNS(synctoNetSuiteNS)
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
     * Refund a payment with auto-unapplying
     *
     * **Note:** This operation is only available if you have [Invoice Settlement](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/Invoice_Settlement) enabled. The Invoice Settlement feature is generally available as of Zuora Billing Release 296 (March 2021). This feature includes Unapplied Payments, Credit and Debit Memo, and Invoice Item Settlement. If you want to enable Invoice Settlement, see [Invoice Settlement Enablement and Checklist Guide](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/Invoice_Settlement/Invoice_Settlement_Migration_Checklist_and_Guide) for more information.   Refunds a full or partial unapplied payment to your customers, without the need to unapply the payment first, followed by processing the refund. To refund applied payments, you can now leverage this API to unapply and refund the payment simultaneously.  For more information, see [Refund Payments](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/Invoice_Settlement/A_Unapplied_Payments/Management_of_Unapplied_Payments/Y_Refund_Payments). 
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void refundPaymentwithAutoUnapplyTest() throws ApiException {
        String paymentKey = null;
        String comment = null;
        List<PaymentDebitMemoApplicationApplyRequestType> debitMemos = null;
        PostRefundTypeAllOfFinanceInformation financeInformation = null;
        PostRefundTypeAllOfGatewayOptions gatewayOptions = null;
        List<PaymentInvoiceApplicationApplyRequestType> invoices = null;
        String methodType = null;
        String reasonCode = null;
        String referenceId = null;
        LocalDate refundDate = null;
        String secondRefundReferenceId = null;
        String softDescriptor = null;
        String softDescriptorPhone = null;
        Double totalAmount = null;
        String type = null;
        String refundTransactionType = null;
        Boolean writeOff = null;
        PostRefundwithAutoUnapplyTypeAllOfWriteOffOptions writeOffOptions = null;
        String integrationIdNS = null;
        String integrationStatusNS = null;
        String originNS = null;
        String syncDateNS = null;
        String synctoNetSuiteNS = null;
        String idempotencyKey = null;
        String acceptEncoding = null;
        String contentEncoding = null;
        String authorization = null;
        String zuoraTrackId = null;
        String zuoraEntityIds = null;
        String zuoraOrgIds = null;
        GETRefundPaymentTypeAutoUnapply response = api.refundPaymentwithAutoUnapply(paymentKey)
                .comment(comment)
                .debitMemos(debitMemos)
                .financeInformation(financeInformation)
                .gatewayOptions(gatewayOptions)
                .invoices(invoices)
                .methodType(methodType)
                .reasonCode(reasonCode)
                .referenceId(referenceId)
                .refundDate(refundDate)
                .secondRefundReferenceId(secondRefundReferenceId)
                .softDescriptor(softDescriptor)
                .softDescriptorPhone(softDescriptorPhone)
                .totalAmount(totalAmount)
                .type(type)
                .refundTransactionType(refundTransactionType)
                .writeOff(writeOff)
                .writeOffOptions(writeOffOptions)
                .integrationIdNS(integrationIdNS)
                .integrationStatusNS(integrationStatusNS)
                .originNS(originNS)
                .syncDateNS(syncDateNS)
                .synctoNetSuiteNS(synctoNetSuiteNS)
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
     * List payments
     *
     * **Note:** This operation is only available if you have [Invoice Settlement](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/Invoice_Settlement) enabled. The Invoice Settlement feature is generally available as of Zuora Billing Release 296 (March 2021). This feature includes Unapplied Payments, Credit and Debit Memo, and Invoice Item Settlement. If you want to enable Invoice Settlement, see [Invoice Settlement Enablement and Checklist Guide](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/Invoice_Settlement/Invoice_Settlement_Migration_Checklist_and_Guide) for more information.   Retrieves the information about all payments from all your customer accounts.  ### Filtering  You can use query parameters to restrict the data returned in the response. Each query parameter corresponds to one field in the response body.  If the value of a filterable field is string, you can set the corresponding query parameter to &#x60;null&#x60; when filtering. Then, you can get the response data with this field value being &#x60;null&#x60;.  Examples:  - /v1/payments?status&#x3D;Processed  - /v1/payments?currency&#x3D;USD&amp;status&#x3D;Processed  - /v1/payments?status&#x3D;Processed&amp;type&#x3D;External&amp;sort&#x3D;+number 
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void retrieveAllPaymentsTest() throws ApiException {
        String acceptEncoding = null;
        String contentEncoding = null;
        String authorization = null;
        String zuoraTrackId = null;
        String zuoraEntityIds = null;
        String zuoraOrgIds = null;
        Integer page = null;
        Integer pageSize = null;
        String accountId = null;
        Double amount = null;
        Double appliedAmount = null;
        String createdById = null;
        OffsetDateTime createdDate = null;
        Double creditBalanceAmount = null;
        String currency = null;
        OffsetDateTime effectiveDate = null;
        String number = null;
        Double refundAmount = null;
        String status = null;
        String type = null;
        Double unappliedAmount = null;
        String updatedById = null;
        OffsetDateTime updatedDate = null;
        String sort = null;
        PaymentCollectionResponseType response = api.retrieveAllPayments()
                .acceptEncoding(acceptEncoding)
                .contentEncoding(contentEncoding)
                .authorization(authorization)
                .zuoraTrackId(zuoraTrackId)
                .zuoraEntityIds(zuoraEntityIds)
                .zuoraOrgIds(zuoraOrgIds)
                .page(page)
                .pageSize(pageSize)
                .accountId(accountId)
                .amount(amount)
                .appliedAmount(appliedAmount)
                .createdById(createdById)
                .createdDate(createdDate)
                .creditBalanceAmount(creditBalanceAmount)
                .currency(currency)
                .effectiveDate(effectiveDate)
                .number(number)
                .refundAmount(refundAmount)
                .status(status)
                .type(type)
                .unappliedAmount(unappliedAmount)
                .updatedById(updatedById)
                .updatedDate(updatedDate)
                .sort(sort)
                .execute();
        // TODO: test validations
    }

    /**
     * Transfer a payment
     *
     * **Note:** This operation is only available if you have [Invoice Settlement](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/Invoice_Settlement) enabled. The Invoice Settlement feature is generally available as of Zuora Billing Release 296 (March 2021). This feature includes Unapplied Payments, Credit and Debit Memo, and Invoice Item Settlement. If you want to enable Invoice Settlement, see [Invoice Settlement Enablement and Checklist Guide](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/Invoice_Settlement/Invoice_Settlement_Migration_Checklist_and_Guide) for more information.   Transfers an unapplied payment.  For more information, see [Transfer Unapplied Payments](https://knowledgecenter.zuora.com/CB_Billing/Invoice_Settlement/A_Unapplied_Payments/Management_of_Unapplied_Payments/Transfer_Unapplied_Payments). 
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void transferPaymentTest() throws ApiException {
        String paymentKey = null;
        String accountId = null;
        String acceptEncoding = null;
        String contentEncoding = null;
        String authorization = null;
        String zuoraTrackId = null;
        String zuoraEntityIds = null;
        String zuoraOrgIds = null;
        GETARPaymentType response = api.transferPayment(paymentKey)
                .accountId(accountId)
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
     * Unapply a payment
     *
     * **Note:** This operation is only available if you have [Invoice Settlement](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/Invoice_Settlement) enabled. The Invoice Settlement feature is generally available as of Zuora Billing Release 296 (March 2021). This feature includes Unapplied Payments, Credit and Debit Memo, and Invoice Item Settlement. If you want to enable Invoice Settlement, see [Invoice Settlement Enablement and Checklist Guide](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/Invoice_Settlement/Invoice_Settlement_Migration_Checklist_and_Guide) for more information.   Unapplies an applied payment from invoices and debit memos.  When you unapply a payment, the total number of invoice items and debit memo items that the payment will unapply from must be less than or equal to 15,000.  If the limit is hit, you can follow the instructions: - If you want to unapply one payment without specifying invoices or debit memos, you have to specify the invoices or debit memos in the request. - If you want to unapply one payment from multiple specified invoices or debit memos, decrease the number of invoices or debit memos in the request. - If you want to unapply one payment from a single invoice or debit memo with a large volume of items, you have to specify invoice items in the request. The maximum number of invoice items that you can specify in the request is 1,000.  For more information, see [Unapply Payments from Invoices and Debit Memos](https://knowledgecenter.zuora.com/CB_Billing/Invoice_Settlement/A_Unapplied_Payments/Management_of_Unapplied_Payments/Unapply_Payments_from_Invoices_and_Debit_Memos). 
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void unapplyPaymentTest() throws ApiException {
        String paymentKey = null;
        List<PaymentDebitMemoApplicationUnapplyRequestType> debitMemos = null;
        LocalDate effectiveDate = null;
        List<PaymentInvoiceApplicationUnapplyRequestType> invoices = null;
        String acceptEncoding = null;
        String contentEncoding = null;
        String authorization = null;
        String zuoraTrackId = null;
        String zuoraEntityIds = null;
        String zuoraOrgIds = null;
        GETARPaymentType response = api.unapplyPayment(paymentKey)
                .debitMemos(debitMemos)
                .effectiveDate(effectiveDate)
                .invoices(invoices)
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
     * Update a payment
     *
     * **Note:** This operation is only available if you have [Invoice Settlement](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/Invoice_Settlement) enabled. The Invoice Settlement feature is generally available as of Zuora Billing Release 296 (March 2021). This feature includes Unapplied Payments, Credit and Debit Memo, and Invoice Item Settlement. If you want to enable Invoice Settlement, see [Invoice Settlement Enablement and Checklist Guide](https://knowledgecenter.zuora.com/Billing/Billing_and_Payments/Invoice_Settlement/Invoice_Settlement_Migration_Checklist_and_Guide) for more information.   Updates a payment. 
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void updatePaymentTest() throws ApiException {
        String paymentId = null;
        String comment = null;
        UpdatePaymentTypeAllOfFinanceInformation financeInformation = null;
        String gatewayState = null;
        String paymentScheduleKey = null;
        String referenceId = null;
        String integrationIdNS = null;
        String integrationStatusNS = null;
        String originNS = null;
        String syncDateNS = null;
        String transactionNS = null;
        String acceptEncoding = null;
        String contentEncoding = null;
        String authorization = null;
        String zuoraTrackId = null;
        String zuoraEntityIds = null;
        String zuoraOrgIds = null;
        GETARPaymentType response = api.updatePayment(paymentId)
                .comment(comment)
                .financeInformation(financeInformation)
                .gatewayState(gatewayState)
                .paymentScheduleKey(paymentScheduleKey)
                .referenceId(referenceId)
                .integrationIdNS(integrationIdNS)
                .integrationStatusNS(integrationStatusNS)
                .originNS(originNS)
                .syncDateNS(syncDateNS)
                .transactionNS(transactionNS)
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
