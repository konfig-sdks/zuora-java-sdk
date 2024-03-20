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
import com.konfigthis.client.model.GETSubscriptionTypeWithSuccess;
import com.konfigthis.client.model.GETSubscriptionWrapper;
import java.time.LocalDate;
import com.konfigthis.client.model.POSTSrpCreateType;
import com.konfigthis.client.model.POSTSubscriptionCancellationResponseType;
import com.konfigthis.client.model.POSTSubscriptionCancellationType;
import com.konfigthis.client.model.POSTSubscriptionPreviewResponseType;
import com.konfigthis.client.model.POSTSubscriptionPreviewType;
import com.konfigthis.client.model.POSTSubscriptionPreviewTypePreviewAccountInfo;
import com.konfigthis.client.model.POSTSubscriptionResponseType;
import com.konfigthis.client.model.POSTSubscriptionType;
import com.konfigthis.client.model.PUTDeleteSubscriptionResponseType;
import com.konfigthis.client.model.PUTRenewSubscriptionResponseType;
import com.konfigthis.client.model.PUTRenewSubscriptionType;
import com.konfigthis.client.model.PUTSrpAddType;
import com.konfigthis.client.model.PUTSrpChangeType;
import com.konfigthis.client.model.PUTSrpRemoveType;
import com.konfigthis.client.model.PUTSrpUpdateType;
import com.konfigthis.client.model.PUTSubscriptionPatchSpecificVersionRequestType;
import com.konfigthis.client.model.PUTSubscriptionPatchSpecificVersionRequestTypeRatePlansInner;
import com.konfigthis.client.model.PUTSubscriptionResponseType;
import com.konfigthis.client.model.PUTSubscriptionResumeResponseType;
import com.konfigthis.client.model.PUTSubscriptionResumeType;
import com.konfigthis.client.model.PUTSubscriptionSuspendResponseType;
import com.konfigthis.client.model.PUTSubscriptionSuspendType;
import com.konfigthis.client.model.PUTSubscriptionType;
import com.konfigthis.client.model.PreviewExistingSubscriptionRequest;
import com.konfigthis.client.model.PreviewExistingSubscriptionResponse;
import com.konfigthis.client.model.PreviewStartDate;
import com.konfigthis.client.model.PreviewThroughDate;
import com.konfigthis.client.model.QuantityForUsageCharges;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for SubscriptionsApi
 */
@Disabled
public class SubscriptionsApiTest {

    private static SubscriptionsApi api;

    
    @BeforeAll
    public static void beforeClass() {
        ApiClient apiClient = Configuration.getDefaultApiClient();
        api = new SubscriptionsApi(apiClient);
    }

    /**
     * Cancel a subscription
     *
     * This REST API reference describes how to cancel an active subscription.  **Note**: If you have the Invoice Settlement feature enabled, it is best practice to set the &#x60;zuora-version&#x60; parameter to &#x60;211.0&#x60; or later [available versions](https://developer.zuora.com/api-references/api/overview/#section/API-Versions/Minor-Version). Otherwise, an error occurs. 
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void cancelSubscriptionTest() throws ApiException {
        String cancellationPolicy = null;
        String subscriptionKey = null;
        List<String> applicationOrder = null;
        Boolean applyCredit = null;
        Boolean applyCreditBalance = null;
        LocalDate bookingDate = null;
        LocalDate cancellationEffectiveDate = null;
        Boolean collect = null;
        LocalDate contractEffectiveDate = null;
        String creditMemoReasonCode = null;
        LocalDate documentDate = null;
        Boolean invoice = null;
        Boolean invoiceCollect = null;
        LocalDate invoiceTargetDate = null;
        LocalDate orderDate = null;
        Boolean runBilling = null;
        LocalDate targetDate = null;
        String acceptEncoding = null;
        String contentEncoding = null;
        String authorization = null;
        String zuoraTrackId = null;
        String zuoraEntityIds = null;
        String zuoraOrgIds = null;
        String zuoraVersion = null;
        POSTSubscriptionCancellationResponseType response = api.cancelSubscription(cancellationPolicy, subscriptionKey)
                .applicationOrder(applicationOrder)
                .applyCredit(applyCredit)
                .applyCreditBalance(applyCreditBalance)
                .bookingDate(bookingDate)
                .cancellationEffectiveDate(cancellationEffectiveDate)
                .collect(collect)
                .contractEffectiveDate(contractEffectiveDate)
                .creditMemoReasonCode(creditMemoReasonCode)
                .documentDate(documentDate)
                .invoice(invoice)
                .invoiceCollect(invoiceCollect)
                .invoiceTargetDate(invoiceTargetDate)
                .orderDate(orderDate)
                .runBilling(runBilling)
                .targetDate(targetDate)
                .acceptEncoding(acceptEncoding)
                .contentEncoding(contentEncoding)
                .authorization(authorization)
                .zuoraTrackId(zuoraTrackId)
                .zuoraEntityIds(zuoraEntityIds)
                .zuoraOrgIds(zuoraOrgIds)
                .zuoraVersion(zuoraVersion)
                .execute();
        // TODO: test validations
    }

    /**
     * Delete a subscription by number
     *
     * This REST API reference describes how to delete a subscription of the specified subscription number. 
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void deleteSubscriptionTest() throws ApiException {
        String subscriptionKey = null;
        String acceptEncoding = null;
        String contentEncoding = null;
        String authorization = null;
        String zuoraTrackId = null;
        String zuoraEntityIds = null;
        String zuoraOrgIds = null;
        PUTDeleteSubscriptionResponseType response = api.deleteSubscription(subscriptionKey)
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
     * Preview a subscription
     *
     * The REST API reference describes how to create a new subscription in preview mode. This call does not require a valid customer account. It can be used to show potential new customers a preview of a subscription with complete details and charges before creating an account, or to let existing customers preview a subscription with all charges before committing.  ### Notes - The response of the Preview Subscription call is based on the REST API minor version you set in the request header. The response structure might be different if you use different minor version numbers.   - If you have the Invoice Settlement feature enabled, we recommend that you set the &#x60;zuora-version&#x60; parameter to &#x60;207.0&#x60; or later [available versions](https://developer.zuora.com/api-references/api/overview/#section/API-Versions/Minor-Version). Otherwise, an error is returned.   - Default values for **customerAcceptanceDate** and **serviceActivationDate** are set as follows.  |        | serviceActivationDate (SA) specified          | serviceActivationDate (SA) NOT specified  | | ------------- |:-------------:| -----:| | customerAcceptanceDate (CA) specified      | SA uses value in the request call; CA uses value in the request call| CA uses value in the request call;SA uses CE as default | | customerAcceptanceDate (CA) NOT specified      | SA uses value in the request call; CA uses SA as default |   SA and CA use CE as default | 
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void previewSubscriptionTest() throws ApiException {
        String accountKey = null;
        LocalDate contractEffectiveDate = null;
        LocalDate customerAcceptanceDate = null;
        LocalDate documentDate = null;
        Boolean includeExistingDraftDocItems = null;
        Boolean includeExistingDraftInvoiceItems = null;
        Long initialTerm = null;
        String initialTermPeriodType = null;
        String invoiceOwnerAccountKey = null;
        LocalDate invoiceTargetDate = null;
        String notes = null;
        POSTSubscriptionPreviewTypePreviewAccountInfo previewAccountInfo = null;
        String previewType = null;
        LocalDate serviceActivationDate = null;
        List<POSTSrpCreateType> subscribeToRatePlans = null;
        LocalDate targetDate = null;
        LocalDate termStartDate = null;
        String termType = null;
        String idempotencyKey = null;
        String acceptEncoding = null;
        String contentEncoding = null;
        String authorization = null;
        String zuoraTrackId = null;
        String zuoraEntityIds = null;
        String zuoraOrgIds = null;
        String zuoraVersion = null;
        POSTSubscriptionPreviewResponseType response = api.previewSubscription()
                .accountKey(accountKey)
                .contractEffectiveDate(contractEffectiveDate)
                .customerAcceptanceDate(customerAcceptanceDate)
                .documentDate(documentDate)
                .includeExistingDraftDocItems(includeExistingDraftDocItems)
                .includeExistingDraftInvoiceItems(includeExistingDraftInvoiceItems)
                .initialTerm(initialTerm)
                .initialTermPeriodType(initialTermPeriodType)
                .invoiceOwnerAccountKey(invoiceOwnerAccountKey)
                .invoiceTargetDate(invoiceTargetDate)
                .notes(notes)
                .previewAccountInfo(previewAccountInfo)
                .previewType(previewType)
                .serviceActivationDate(serviceActivationDate)
                .subscribeToRatePlans(subscribeToRatePlans)
                .targetDate(targetDate)
                .termStartDate(termStartDate)
                .termType(termType)
                .idempotencyKey(idempotencyKey)
                .acceptEncoding(acceptEncoding)
                .contentEncoding(contentEncoding)
                .authorization(authorization)
                .zuoraTrackId(zuoraTrackId)
                .zuoraEntityIds(zuoraEntityIds)
                .zuoraOrgIds(zuoraOrgIds)
                .zuoraVersion(zuoraVersion)
                .execute();
        // TODO: test validations
    }

    /**
     * Preview a subscription by subscription key
     *
     * Describes how to preview an existing subscription to view information about existing and future invoices or credit memos.    **Note**: The &#x60;zuora-version&#x60; parameter must be &#x60;207.0&#x60; or later.  
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void previewSubscriptionBySubscriptionKeyTest() throws ApiException {
        String subscriptionKey = null;
        PreviewStartDate previewStartDate = null;
        PreviewThroughDate previewThroughDate = null;
        List<QuantityForUsageCharges> quantityForUsageCharges = null;
        String acceptEncoding = null;
        String contentEncoding = null;
        String authorization = null;
        String zuoraTrackId = null;
        String zuoraEntityIds = null;
        String zuoraVersion = null;
        PreviewExistingSubscriptionResponse response = api.previewSubscriptionBySubscriptionKey(subscriptionKey)
                .previewStartDate(previewStartDate)
                .previewThroughDate(previewThroughDate)
                .quantityForUsageCharges(quantityForUsageCharges)
                .acceptEncoding(acceptEncoding)
                .contentEncoding(contentEncoding)
                .authorization(authorization)
                .zuoraTrackId(zuoraTrackId)
                .zuoraEntityIds(zuoraEntityIds)
                .zuoraVersion(zuoraVersion)
                .execute();
        // TODO: test validations
    }

    /**
     * Renew a subscription
     *
     * Renews a termed subscription using existing renewal terms.  When you renew a subscription, the current subscription term is extended by creating a new term.   If any charge in your subscription has the billing period set as &#x60;SubscriptionTerm&#x60;， a new charge segment is generated for the new term.   **Note**: If you have the Invoice Settlement feature enabled, it is best practice to set the &#x60;zuora-version&#x60; parameter to &#x60;211.0&#x60; or later [available versions](https://developer.zuora.com/api-references/api/overview/#section/API-Versions/Minor-Version). Otherwise, an error occurs. 
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void renewSubscriptionTest() throws ApiException {
        String subscriptionKey = null;
        List<String> applicationOrder = null;
        Boolean applyCredit = null;
        Boolean applyCreditBalance = null;
        Boolean collect = null;
        String creditMemoReasonCode = null;
        LocalDate documentDate = null;
        Boolean invoice = null;
        Boolean invoiceCollect = null;
        LocalDate invoiceTargetDate = null;
        LocalDate orderDate = null;
        Boolean runBilling = null;
        LocalDate targetDate = null;
        String acceptEncoding = null;
        String contentEncoding = null;
        String authorization = null;
        String zuoraTrackId = null;
        String zuoraEntityIds = null;
        String zuoraOrgIds = null;
        String zuoraVersion = null;
        PUTRenewSubscriptionResponseType response = api.renewSubscription(subscriptionKey)
                .applicationOrder(applicationOrder)
                .applyCredit(applyCredit)
                .applyCreditBalance(applyCreditBalance)
                .collect(collect)
                .creditMemoReasonCode(creditMemoReasonCode)
                .documentDate(documentDate)
                .invoice(invoice)
                .invoiceCollect(invoiceCollect)
                .invoiceTargetDate(invoiceTargetDate)
                .orderDate(orderDate)
                .runBilling(runBilling)
                .targetDate(targetDate)
                .acceptEncoding(acceptEncoding)
                .contentEncoding(contentEncoding)
                .authorization(authorization)
                .zuoraTrackId(zuoraTrackId)
                .zuoraEntityIds(zuoraEntityIds)
                .zuoraOrgIds(zuoraOrgIds)
                .zuoraVersion(zuoraVersion)
                .execute();
        // TODO: test validations
    }

    /**
     * Resume a subscription
     *
     * This REST API reference describes how to resume a suspended subscription.    **Note**: If you have the Invoice Settlement feature enabled, it is best practice to set the &#x60;zuora-version&#x60; parameter to &#x60;211.0&#x60; or later [available versions](https://developer.zuora.com/api-references/api/overview/#section/API-Versions/Minor-Version). Otherwise, an error occurs. 
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void resumeSubscriptionTest() throws ApiException {
        String resumePolicy = null;
        String subscriptionKey = null;
        List<String> applicationOrder = null;
        Boolean applyCredit = null;
        Boolean applyCreditBalance = null;
        LocalDate bookingDate = null;
        Boolean collect = null;
        LocalDate contractEffectiveDate = null;
        String creditMemoReasonCode = null;
        LocalDate documentDate = null;
        Boolean extendsTerm = null;
        Boolean invoice = null;
        Boolean invoiceCollect = null;
        LocalDate invoiceTargetDate = null;
        LocalDate orderDate = null;
        String resumePeriods = null;
        String resumePeriodsType = null;
        LocalDate resumeSpecificDate = null;
        Boolean runBilling = null;
        LocalDate targetDate = null;
        String acceptEncoding = null;
        String contentEncoding = null;
        String authorization = null;
        String zuoraTrackId = null;
        String zuoraEntityIds = null;
        String zuoraOrgIds = null;
        String zuoraVersion = null;
        PUTSubscriptionResumeResponseType response = api.resumeSubscription(resumePolicy, subscriptionKey)
                .applicationOrder(applicationOrder)
                .applyCredit(applyCredit)
                .applyCreditBalance(applyCreditBalance)
                .bookingDate(bookingDate)
                .collect(collect)
                .contractEffectiveDate(contractEffectiveDate)
                .creditMemoReasonCode(creditMemoReasonCode)
                .documentDate(documentDate)
                .extendsTerm(extendsTerm)
                .invoice(invoice)
                .invoiceCollect(invoiceCollect)
                .invoiceTargetDate(invoiceTargetDate)
                .orderDate(orderDate)
                .resumePeriods(resumePeriods)
                .resumePeriodsType(resumePeriodsType)
                .resumeSpecificDate(resumeSpecificDate)
                .runBilling(runBilling)
                .targetDate(targetDate)
                .acceptEncoding(acceptEncoding)
                .contentEncoding(contentEncoding)
                .authorization(authorization)
                .zuoraTrackId(zuoraTrackId)
                .zuoraEntityIds(zuoraEntityIds)
                .zuoraOrgIds(zuoraOrgIds)
                .zuoraVersion(zuoraVersion)
                .execute();
        // TODO: test validations
    }

    /**
     * Create a subscription
     *
     * This REST API reference describes how to create a new subscription for an existing customer account.  ### Notes  If you have the Invoice Settlement feature enabled, it is best practice to set the &#x60;zuora-version&#x60; parameter to &#x60;211.0&#x60; or later [available versions](https://developer.zuora.com/api-references/api/overview/#section/API-Versions/Minor-Version). Otherwise, an error occurs.  If &#x60;invoiceCollect&#x60; is &#x60;true&#x60;, the call will not return &#x60;success&#x60; &#x3D; &#x60;true&#x60; unless the subscription, invoice, and payment are all successful.  Default values for **customerAcceptanceDate** and **serviceActivationDate** are set as follows. This API operation does not support creating a pending subscription.  |        | serviceActivationDate(SA) specified          | serviceActivationDate (SA) NOT specified  | | ------------- |:-------------:| -----:| | customerAcceptanceDate (CA) specified| SA uses value in the request call; CA uses value in the request call| CA uses value in the request call;SA uses CE as default | | customerAcceptanceDate (CA) NOT specified      | SA uses value in the request call; CA uses SA as default |   SA and CA use CE as default | 
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void subscriptionTest() throws ApiException {
        String accountKey = null;
        List<String> applicationOrder = null;
        Boolean applyCredit = null;
        Boolean applyCreditBalance = null;
        Boolean autoRenew = null;
        Boolean collect = null;
        LocalDate contractEffectiveDate = null;
        String creditMemoReasonCode = null;
        LocalDate customerAcceptanceDate = null;
        LocalDate documentDate = null;
        String externallyManagedBy = null;
        String gatewayId = null;
        Long initialTerm = null;
        String initialTermPeriodType = null;
        Boolean invoice = null;
        Boolean invoiceCollect = null;
        String invoiceOwnerAccountKey = null;
        Boolean invoiceSeparately = null;
        LocalDate invoiceTargetDate = null;
        LocalDate lastBookingDate = null;
        String notes = null;
        String paymentMethodId = null;
        Boolean prepayment = null;
        String renewalSetting = null;
        Long renewalTerm = null;
        String renewalTermPeriodType = null;
        Boolean runBilling = null;
        LocalDate serviceActivationDate = null;
        List<POSTSrpCreateType> subscribeToRatePlans = null;
        String subscriptionNumber = null;
        LocalDate targetDate = null;
        LocalDate termStartDate = null;
        String termType = null;
        String cpqBundleJsonIdQT = null;
        LocalDate opportunityCloseDateQT = null;
        String opportunityNameQT = null;
        String quoteBusinessTypeQT = null;
        String quoteNumberQT = null;
        String quoteTypeQT = null;
        String integrationIdNS = null;
        String integrationStatusNS = null;
        String projectNS = null;
        String salesOrderNS = null;
        String syncDateNS = null;
        String idempotencyKey = null;
        String acceptEncoding = null;
        String contentEncoding = null;
        String authorization = null;
        String zuoraTrackId = null;
        String zuoraEntityIds = null;
        String zuoraOrgIds = null;
        String zuoraVersion = null;
        POSTSubscriptionResponseType response = api.subscription()
                .accountKey(accountKey)
                .applicationOrder(applicationOrder)
                .applyCredit(applyCredit)
                .applyCreditBalance(applyCreditBalance)
                .autoRenew(autoRenew)
                .collect(collect)
                .contractEffectiveDate(contractEffectiveDate)
                .creditMemoReasonCode(creditMemoReasonCode)
                .customerAcceptanceDate(customerAcceptanceDate)
                .documentDate(documentDate)
                .externallyManagedBy(externallyManagedBy)
                .gatewayId(gatewayId)
                .initialTerm(initialTerm)
                .initialTermPeriodType(initialTermPeriodType)
                .invoice(invoice)
                .invoiceCollect(invoiceCollect)
                .invoiceOwnerAccountKey(invoiceOwnerAccountKey)
                .invoiceSeparately(invoiceSeparately)
                .invoiceTargetDate(invoiceTargetDate)
                .lastBookingDate(lastBookingDate)
                .notes(notes)
                .paymentMethodId(paymentMethodId)
                .prepayment(prepayment)
                .renewalSetting(renewalSetting)
                .renewalTerm(renewalTerm)
                .renewalTermPeriodType(renewalTermPeriodType)
                .runBilling(runBilling)
                .serviceActivationDate(serviceActivationDate)
                .subscribeToRatePlans(subscribeToRatePlans)
                .subscriptionNumber(subscriptionNumber)
                .targetDate(targetDate)
                .termStartDate(termStartDate)
                .termType(termType)
                .cpqBundleJsonIdQT(cpqBundleJsonIdQT)
                .opportunityCloseDateQT(opportunityCloseDateQT)
                .opportunityNameQT(opportunityNameQT)
                .quoteBusinessTypeQT(quoteBusinessTypeQT)
                .quoteNumberQT(quoteNumberQT)
                .quoteTypeQT(quoteTypeQT)
                .integrationIdNS(integrationIdNS)
                .integrationStatusNS(integrationStatusNS)
                .projectNS(projectNS)
                .salesOrderNS(salesOrderNS)
                .syncDateNS(syncDateNS)
                .idempotencyKey(idempotencyKey)
                .acceptEncoding(acceptEncoding)
                .contentEncoding(contentEncoding)
                .authorization(authorization)
                .zuoraTrackId(zuoraTrackId)
                .zuoraEntityIds(zuoraEntityIds)
                .zuoraOrgIds(zuoraOrgIds)
                .zuoraVersion(zuoraVersion)
                .execute();
        // TODO: test validations
    }

    /**
     * Update a subscription
     *
     * Use this call to make the following kinds of changes to a subscription:   * Add a note   * Change the renewal term or auto-renewal flag   * Change the term length or change between evergreen and termed   * Add a new product rate plan   * Remove an existing subscription rate plan   * Change the quantity or price of an existing subscription rate plan   * Change rate plans - to replace the existing rate plans in a subscription with other rate plans. Changing rate plans is currently not supported for Billing - Revenue Integration. When Billing - Revenue Integration is enabled, changing rate plans will no longer be applicable in Zuora Billing.  ### Notes * The \&quot;Update a subscription\&quot; call creates a new subscription object that has a new version number and to which the subscription changes are applied. The new subscription object has the same subscription name but a new, different, subscription ID. The &#x60;Status&#x60; field of the new subscription object will be set to &#x60;Active&#x60; unless the change applied was a cancelation or suspension in which case the status reflects that. The &#x60;Status&#x60; field of the originating subscription object changes from &#x60;Active&#x60; to &#x60;Expired&#x60;. A status of &#x60;Expired&#x60; does not imply that the subscription itself has expired or ended, merely that this subscription object is no longer the most recent. * In one request, this call can make:   * Up to 9 combined add, update, and remove changes   * No more than 1 change to terms &amp; conditions * Updates are performed in the following sequence:   1. First change the notes on the existing subscription, if requested.   2. Then change the terms and conditions, if requested.   3. Then perform the remaining amendments based upon the effective dates specified. If multiple amendments have the same contract-effective dates, then execute adds before updates, and updates before removes. * The update operation is atomic. If any of the updates fails, the entire operation is rolled back. * The response of the Update Subscription call is based on the REST API minor version you set in the request header. The response structure might be different if you use different minor version numbers.  * If you have the Invoice Settlement feature enabled, it is best practice to set the &#x60;zuora-version&#x60; parameter to &#x60;211.0&#x60; or later [available versions](https://developer.zuora.com/api-references/api/overview/#section/API-Versions/Minor-Version). Otherwise, an error occurs.  ### Override a Tiered Price There are two ways you override a tiered price:  * Override a specific tier number For example: &#x60;tiers[{tier:1,price:8},{tier:2,price:6}]&#x60;  * Override the entire tier structure For example:  &#x60;tiers[{tier:1,price:8,startingUnit:1,endingUnit:100,priceFormat:\&quot;FlatFee\&quot;}, {tier:2,price:6,startingUnit:101,priceFormat:\&quot;FlatFee\&quot;}]&#x60;  If you just override a specific tier, do not include the &#x60;startingUnit&#x60; field in the request. 
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void subscription_0Test() throws ApiException {
        String subscriptionKey = null;
        List<PUTSrpAddType> add = null;
        List<String> applicationOrder = null;
        Boolean applyCredit = null;
        Boolean applyCreditBalance = null;
        Boolean autoRenew = null;
        LocalDate bookingDate = null;
        List<PUTSrpChangeType> change = null;
        Boolean collect = null;
        String creditMemoReasonCode = null;
        Long currentTerm = null;
        String currentTermPeriodType = null;
        LocalDate documentDate = null;
        String externallyManagedBy = null;
        Boolean includeExistingDraftDocItems = null;
        Boolean includeExistingDraftInvoiceItems = null;
        Boolean invoice = null;
        Boolean invoiceCollect = null;
        Boolean invoiceSeparately = null;
        LocalDate invoiceTargetDate = null;
        String notes = null;
        Boolean preview = null;
        String previewType = null;
        List<PUTSrpRemoveType> remove = null;
        String renewalSetting = null;
        Long renewalTerm = null;
        String renewalTermPeriodType = null;
        Boolean runBilling = null;
        LocalDate targetDate = null;
        LocalDate termStartDate = null;
        String termType = null;
        List<PUTSrpUpdateType> update = null;
        String cpqBundleJsonIdQT = null;
        LocalDate opportunityCloseDateQT = null;
        String opportunityNameQT = null;
        String quoteBusinessTypeQT = null;
        String quoteNumberQT = null;
        String quoteTypeQT = null;
        String integrationIdNS = null;
        String integrationStatusNS = null;
        String projectNS = null;
        String salesOrderNS = null;
        String syncDateNS = null;
        String acceptEncoding = null;
        String contentEncoding = null;
        String authorization = null;
        String zuoraTrackId = null;
        String zuoraEntityIds = null;
        String zuoraOrgIds = null;
        String zuoraVersion = null;
        PUTSubscriptionResponseType response = api.subscription_0(subscriptionKey)
                .add(add)
                .applicationOrder(applicationOrder)
                .applyCredit(applyCredit)
                .applyCreditBalance(applyCreditBalance)
                .autoRenew(autoRenew)
                .bookingDate(bookingDate)
                .change(change)
                .collect(collect)
                .creditMemoReasonCode(creditMemoReasonCode)
                .currentTerm(currentTerm)
                .currentTermPeriodType(currentTermPeriodType)
                .documentDate(documentDate)
                .externallyManagedBy(externallyManagedBy)
                .includeExistingDraftDocItems(includeExistingDraftDocItems)
                .includeExistingDraftInvoiceItems(includeExistingDraftInvoiceItems)
                .invoice(invoice)
                .invoiceCollect(invoiceCollect)
                .invoiceSeparately(invoiceSeparately)
                .invoiceTargetDate(invoiceTargetDate)
                .notes(notes)
                .preview(preview)
                .previewType(previewType)
                .remove(remove)
                .renewalSetting(renewalSetting)
                .renewalTerm(renewalTerm)
                .renewalTermPeriodType(renewalTermPeriodType)
                .runBilling(runBilling)
                .targetDate(targetDate)
                .termStartDate(termStartDate)
                .termType(termType)
                .update(update)
                .cpqBundleJsonIdQT(cpqBundleJsonIdQT)
                .opportunityCloseDateQT(opportunityCloseDateQT)
                .opportunityNameQT(opportunityNameQT)
                .quoteBusinessTypeQT(quoteBusinessTypeQT)
                .quoteNumberQT(quoteNumberQT)
                .quoteTypeQT(quoteTypeQT)
                .integrationIdNS(integrationIdNS)
                .integrationStatusNS(integrationStatusNS)
                .projectNS(projectNS)
                .salesOrderNS(salesOrderNS)
                .syncDateNS(syncDateNS)
                .acceptEncoding(acceptEncoding)
                .contentEncoding(contentEncoding)
                .authorization(authorization)
                .zuoraTrackId(zuoraTrackId)
                .zuoraEntityIds(zuoraEntityIds)
                .zuoraOrgIds(zuoraOrgIds)
                .zuoraVersion(zuoraVersion)
                .execute();
        // TODO: test validations
    }

    /**
     * List subscriptions by account key
     *
     * Retrieves all subscriptions associated with the specified account. Zuora only returns the latest version of the subscriptions.  Subscription data is returned in reverse chronological order based on &#x60;updatedDate&#x60;. Note that the rate plans inside the subscriptions are not sorted specifically and are returned in a random order. 
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void subscriptionsByAccountTest() throws ApiException {
        String accountKey = null;
        String acceptEncoding = null;
        String contentEncoding = null;
        String authorization = null;
        String zuoraTrackId = null;
        String zuoraEntityIds = null;
        String zuoraOrgIds = null;
        Integer page = null;
        Integer pageSize = null;
        String chargeDetail = null;
        Boolean excludeRatePlansWithNoCharges = null;
        GETSubscriptionWrapper response = api.subscriptionsByAccount(accountKey)
                .acceptEncoding(acceptEncoding)
                .contentEncoding(contentEncoding)
                .authorization(authorization)
                .zuoraTrackId(zuoraTrackId)
                .zuoraEntityIds(zuoraEntityIds)
                .zuoraOrgIds(zuoraOrgIds)
                .page(page)
                .pageSize(pageSize)
                .chargeDetail(chargeDetail)
                .excludeRatePlansWithNoCharges(excludeRatePlansWithNoCharges)
                .execute();
        // TODO: test validations
    }

    /**
     * Retrieve a subscription by key
     *
     * This REST API reference describes how to retrieve detailed information about a specified subscription in the latest version. 
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void subscriptionsByKeyTest() throws ApiException {
        String subscriptionKey = null;
        String acceptEncoding = null;
        String contentEncoding = null;
        String authorization = null;
        String zuoraTrackId = null;
        String zuoraEntityIds = null;
        String zuoraOrgIds = null;
        String chargeDetail = null;
        Boolean excludeRatePlansWithNoCharges = null;
        GETSubscriptionTypeWithSuccess response = api.subscriptionsByKey(subscriptionKey)
                .acceptEncoding(acceptEncoding)
                .contentEncoding(contentEncoding)
                .authorization(authorization)
                .zuoraTrackId(zuoraTrackId)
                .zuoraEntityIds(zuoraEntityIds)
                .zuoraOrgIds(zuoraOrgIds)
                .chargeDetail(chargeDetail)
                .excludeRatePlansWithNoCharges(excludeRatePlansWithNoCharges)
                .execute();
        // TODO: test validations
    }

    /**
     * Retrieve a subscription by key and version
     *
     * This REST API reference describes how to retrieve detailed information about a specified subscription in a specified version. When you create a subscription amendment, you create a new version of the subscription. You can use this method to retrieve information about a subscription in any version. 
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void subscriptionsByKeyAndVersionTest() throws ApiException {
        String subscriptionKey = null;
        String version = null;
        String acceptEncoding = null;
        String contentEncoding = null;
        String authorization = null;
        String zuoraTrackId = null;
        String zuoraEntityIds = null;
        String zuoraOrgIds = null;
        String chargeDetail = null;
        Boolean excludeRatePlansWithNoCharges = null;
        Boolean getDetailedMetrics = null;
        String asOfDay = null;
        GETSubscriptionTypeWithSuccess response = api.subscriptionsByKeyAndVersion(subscriptionKey, version)
                .acceptEncoding(acceptEncoding)
                .contentEncoding(contentEncoding)
                .authorization(authorization)
                .zuoraTrackId(zuoraTrackId)
                .zuoraEntityIds(zuoraEntityIds)
                .zuoraOrgIds(zuoraOrgIds)
                .chargeDetail(chargeDetail)
                .excludeRatePlansWithNoCharges(excludeRatePlansWithNoCharges)
                .getDetailedMetrics(getDetailedMetrics)
                .asOfDay(asOfDay)
                .execute();
        // TODO: test validations
    }

    /**
     * Suspend a subscription
     *
     * This REST API reference describes how to suspend an active subscription.   **Note**: If you have the Invoice Settlement feature enabled, it is best practice to set the &#x60;zuora-version&#x60; parameter to &#x60;211.0&#x60; or later [available versions](https://developer.zuora.com/api-references/api/overview/#section/API-Versions/Minor-Version). Otherwise, an error occurs. 
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void suspendSubscriptionTest() throws ApiException {
        String suspendPolicy = null;
        String subscriptionKey = null;
        List<String> applicationOrder = null;
        Boolean applyCredit = null;
        Boolean applyCreditBalance = null;
        LocalDate bookingDate = null;
        Boolean collect = null;
        LocalDate contractEffectiveDate = null;
        String creditMemoReasonCode = null;
        LocalDate documentDate = null;
        Boolean extendsTerm = null;
        Boolean invoice = null;
        Boolean invoiceCollect = null;
        LocalDate invoiceTargetDate = null;
        LocalDate orderDate = null;
        Boolean resume = null;
        String resumePeriods = null;
        String resumePeriodsType = null;
        String resumePolicy = null;
        LocalDate resumeSpecificDate = null;
        Boolean runBilling = null;
        String suspendPeriods = null;
        String suspendPeriodsType = null;
        LocalDate suspendSpecificDate = null;
        LocalDate targetDate = null;
        String acceptEncoding = null;
        String contentEncoding = null;
        String authorization = null;
        String zuoraTrackId = null;
        String zuoraEntityIds = null;
        String zuoraOrgIds = null;
        String zuoraVersion = null;
        PUTSubscriptionSuspendResponseType response = api.suspendSubscription(suspendPolicy, subscriptionKey)
                .applicationOrder(applicationOrder)
                .applyCredit(applyCredit)
                .applyCreditBalance(applyCreditBalance)
                .bookingDate(bookingDate)
                .collect(collect)
                .contractEffectiveDate(contractEffectiveDate)
                .creditMemoReasonCode(creditMemoReasonCode)
                .documentDate(documentDate)
                .extendsTerm(extendsTerm)
                .invoice(invoice)
                .invoiceCollect(invoiceCollect)
                .invoiceTargetDate(invoiceTargetDate)
                .orderDate(orderDate)
                .resume(resume)
                .resumePeriods(resumePeriods)
                .resumePeriodsType(resumePeriodsType)
                .resumePolicy(resumePolicy)
                .resumeSpecificDate(resumeSpecificDate)
                .runBilling(runBilling)
                .suspendPeriods(suspendPeriods)
                .suspendPeriodsType(suspendPeriodsType)
                .suspendSpecificDate(suspendSpecificDate)
                .targetDate(targetDate)
                .acceptEncoding(acceptEncoding)
                .contentEncoding(contentEncoding)
                .authorization(authorization)
                .zuoraTrackId(zuoraTrackId)
                .zuoraEntityIds(zuoraEntityIds)
                .zuoraOrgIds(zuoraOrgIds)
                .zuoraVersion(zuoraVersion)
                .execute();
        // TODO: test validations
    }

    /**
     * Update subscription custom fields of a subscription version
     *
     * Updates the custom fields of a specified subscription version. 
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void updateSubscriptionCustomFieldsOfASpecifiedVersionTest() throws ApiException {
        String subscriptionNumber = null;
        String version = null;
        Map<String, Object> customFields = null;
        List<PUTSubscriptionPatchSpecificVersionRequestTypeRatePlansInner> ratePlans = null;
        String acceptEncoding = null;
        String contentEncoding = null;
        String authorization = null;
        String zuoraTrackId = null;
        String zuoraEntityIds = null;
        String zuoraOrgIds = null;
        CommonResponse response = api.updateSubscriptionCustomFieldsOfASpecifiedVersion(subscriptionNumber, version)
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
