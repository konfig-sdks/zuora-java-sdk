# OrdersApi

All URIs are relative to *https://rest.zuora.com*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**allOrders**](OrdersApi.md#allOrders) | **GET** /v1/orders | List orders |
| [**createOrderAsynchronously**](OrdersApi.md#createOrderAsynchronously) | **POST** /v1/async/orders | Create an order asynchronously |
| [**jobStatusAndResponse**](OrdersApi.md#jobStatusAndResponse) | **GET** /v1/async-jobs/{jobId} | Retrieve the status and response of a job |
| [**order**](OrdersApi.md#order) | **POST** /v1/orders | Create an order |
| [**orderActivate**](OrdersApi.md#orderActivate) | **PUT** /v1/orders/{orderNumber}/activate | Activate an order |
| [**orderCancel**](OrdersApi.md#orderCancel) | **PUT** /v1/orders/{orderNumber}/cancel | Cancel an order |
| [**orderTriggerDates**](OrdersApi.md#orderTriggerDates) | **PUT** /v1/orders/{orderNumber}/triggerDates | Update order action trigger dates |
| [**order_0**](OrdersApi.md#order_0) | **GET** /v1/orders/{orderNumber} | Retrieve an order |
| [**order_1**](OrdersApi.md#order_1) | **PUT** /v1/orders/{orderNumber} | Update an order |
| [**order_2**](OrdersApi.md#order_2) | **DELETE** /v1/orders/{orderNumber} | Delete an order |
| [**ordersByInvoiceOwner**](OrdersApi.md#ordersByInvoiceOwner) | **GET** /v1/orders/invoiceOwner/{accountNumber} | List orders of an invoice owner |
| [**ordersBySubscriptionNumber**](OrdersApi.md#ordersBySubscriptionNumber) | **GET** /v1/orders/subscription/{subscriptionNumber} | List orders by subscription number |
| [**ordersBySubscriptionOwner**](OrdersApi.md#ordersBySubscriptionOwner) | **GET** /v1/orders/subscriptionOwner/{accountNumber} | List orders of a subscription owner |
| [**pendingOrdersBySubscriptionNumber**](OrdersApi.md#pendingOrdersBySubscriptionNumber) | **GET** /v1/orders/subscription/{subscription-key}/pending | List pending orders by subscription number |
| [**previewOrder**](OrdersApi.md#previewOrder) | **POST** /v1/orders/preview | Preview an order |
| [**previewOrderAsynchronously**](OrdersApi.md#previewOrderAsynchronously) | **POST** /v1/async/orders/preview | Preview an order asynchronously |
| [**updateOrderCustomFields**](OrdersApi.md#updateOrderCustomFields) | **PUT** /v1/orders/{orderNumber}/customFields | Update order custom fields |
| [**updateSubscriptionCustomFields**](OrdersApi.md#updateSubscriptionCustomFields) | **PUT** /v1/subscriptions/{subscriptionNumber}/customFields | Update subscription custom fields |


<a name="allOrders"></a>
# **allOrders**
> GetAllOrdersResponseType allOrders().acceptEncoding(acceptEncoding).contentEncoding(contentEncoding).authorization(authorization).zuoraTrackId(zuoraTrackId).zuoraEntityIds(zuoraEntityIds).zuoraOrgIds(zuoraOrgIds).page(page).pageSize(pageSize).dateFilterOption(dateFilterOption).startDate(startDate).endDate(endDate).status(status).execute();

List orders

**Note:** This feature is only available if you have the [Order Metrics](https://knowledgecenter.zuora.com/BC_Subscription_Management/Orders/AA_Overview_of_Orders#Order_Metrics) feature enabled. As of Zuora Billing Release 284, Orders is generally available and the Order Metrics feature is no longer available as a standalone feature. If you are an existing Subscribe and Amend customer and want Order Metrics only, you must turn on [Orders Harmonization](https://knowledgecenter.zuora.com/Billing/Subscriptions/Orders/Orders_Harmonization/Orders_Harmonization). You can still keep the existing Subscribe and Amend API integrations to create and manage subscriptions.  **Note:** The [Order Line Items](https://knowledgecenter.zuora.com/Billing/Subscriptions/Orders/Order_Line_Items/AA_Overview_of_Order_Line_Items) feature is now generally available to all Zuora customers. You need to enable the [Orders](https://knowledgecenter.zuora.com/BC_Subscription_Management/Orders/AA_Overview_of_Orders#Orders) feature to access the [Order Line Items](https://knowledgecenter.zuora.com/Billing/Subscriptions/Orders/Order_Line_Items/AA_Overview_of_Order_Line_Items) feature. As of Zuora Billing Release 313 (November 2021), new customers who onboard on [Orders](https://knowledgecenter.zuora.com/Billing/Subscriptions/Orders/AA_Overview_of_Orders) will have the [Order Line Items](https://knowledgecenter.zuora.com/Billing/Subscriptions/Orders/Order_Line_Items) feature enabled by default.          Retrieves information about all orders in your tenant. You can set the &#x60;status&#x60; query parameter to an order status to retrieve orders in that order status. If you do not set a value for this query parameter, the query parameter has a default value &#x60;all&#x60;, and orders of all statuses are returned.  By default, it returns the first page of the orders.  

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Zuora;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.OrdersApi;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Example {
  public static void main(String[] args) {
    Configuration configuration = new Configuration();
    configuration.host = "https://rest.zuora.com";
    Zuora client = new Zuora(configuration);
    String acceptEncoding = "acceptEncoding_example"; // Include the `Accept-Encoding: gzip` header to compress responses as a gzipped file. It can significantly reduce the bandwidth required for a response.   If specified, Zuora automatically compresses responses that contain over 1000 bytes of data, and the response contains a `Content-Encoding` header with the compression algorithm so that your client can decompress it. 
    String contentEncoding = "contentEncoding_example"; // Include the `Content-Encoding: gzip` header to compress a request. With this header specified, you should upload a gzipped file for the request payload instead of sending the JSON payload. 
    String authorization = "authorization_example"; // The value is in the `Bearer {token}` format where {token} is a valid OAuth token generated by calling [Create an OAuth token](https://developer.zuora.com/api-references/api/operation/createToken). 
    String zuoraTrackId = "zuoraTrackId_example"; // A custom identifier for tracing the API call. If you set a value for this header, Zuora returns the same value in the response headers. This header enables you to associate your system process identifiers with Zuora API calls, to assist with troubleshooting in the event of an issue.  The value of this field must use the US-ASCII character set and must not include any of the following characters: colon (`:`), semicolon (`;`), double quote (`\"`), and quote (`'`). 
    String zuoraEntityIds = "zuoraEntityIds_example"; // An entity ID. If you have [Zuora Multi-entity](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Multi-entity) enabled and the OAuth token is valid for more than one entity, you must use this header to specify which entity to perform the operation in. If the OAuth token is only valid for a single entity, or you do not have Zuora Multi-entity enabled, you do not need to set this header. 
    String zuoraOrgIds = "zuoraOrgIds_example"; // Comma separated IDs. If you have <a href=\"https://knowledgecenter.zuora.com/Zuora_Central_Platform/Multi-Org\" target=\"_blank\">Zuora Multi-Org</a> enabled,  you can use this header to specify which orgs to perform the operation in. If you do not have Zuora Multi-Org enabled, you should not set this header.  The IDs must be a sub-set of the user's accessible orgs. If you specify an org that the user does not have access to, the operation fails.  If the header is not set, the operation is performed in scope of the user's accessible orgs. 
    Integer page = 1; // The index number of the page that you want to retrieve. This parameter is dependent on `pageSize`. You must set `pageSize` before specifying `page`. For example, if you set `pageSize` to `20` and `page` to `2`, the 21st to 40th records are returned in the response. 
    Integer pageSize = 20; // The number of records returned per page in the response. 
    String dateFilterOption = "dateFilterOption_example"; // The date type to filter on. This field value can be orderDate or updatedDate. Default is orderDate. 
    LocalDate startDate = LocalDate.now(); // The result will only contain the orders with the date of dateFilterOption later than or equal to this date. 
    LocalDate endDate = LocalDate.now(); // The result will only contains orders with the date of dateFilterOption earlier than or equal to this date. 
    String status = "all"; // The status of orders.
    try {
      GetAllOrdersResponseType result = client
              .orders
              .allOrders()
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
      System.out.println(result);
      System.out.println(result.getNextPage());
      System.out.println(result.getOrders());
      System.out.println(result.getSuccess());
    } catch (ApiException e) {
      System.err.println("Exception when calling OrdersApi#allOrders");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<GetAllOrdersResponseType> response = client
              .orders
              .allOrders()
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
              .executeWithHttpInfo();
      System.out.println(response.getResponseBody());
      System.out.println(response.getResponseHeaders());
      System.out.println(response.getStatusCode());
      System.out.println(response.getRoundTripTime());
      System.out.println(response.getRequest());
    } catch (ApiException e) {
      System.err.println("Exception when calling OrdersApi#allOrders");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}

```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **acceptEncoding** | **String**| Include the &#x60;Accept-Encoding: gzip&#x60; header to compress responses as a gzipped file. It can significantly reduce the bandwidth required for a response.   If specified, Zuora automatically compresses responses that contain over 1000 bytes of data, and the response contains a &#x60;Content-Encoding&#x60; header with the compression algorithm so that your client can decompress it.  | [optional] |
| **contentEncoding** | **String**| Include the &#x60;Content-Encoding: gzip&#x60; header to compress a request. With this header specified, you should upload a gzipped file for the request payload instead of sending the JSON payload.  | [optional] |
| **authorization** | **String**| The value is in the &#x60;Bearer {token}&#x60; format where {token} is a valid OAuth token generated by calling [Create an OAuth token](https://developer.zuora.com/api-references/api/operation/createToken).  | [optional] |
| **zuoraTrackId** | **String**| A custom identifier for tracing the API call. If you set a value for this header, Zuora returns the same value in the response headers. This header enables you to associate your system process identifiers with Zuora API calls, to assist with troubleshooting in the event of an issue.  The value of this field must use the US-ASCII character set and must not include any of the following characters: colon (&#x60;:&#x60;), semicolon (&#x60;;&#x60;), double quote (&#x60;\&quot;&#x60;), and quote (&#x60;&#39;&#x60;).  | [optional] |
| **zuoraEntityIds** | **String**| An entity ID. If you have [Zuora Multi-entity](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Multi-entity) enabled and the OAuth token is valid for more than one entity, you must use this header to specify which entity to perform the operation in. If the OAuth token is only valid for a single entity, or you do not have Zuora Multi-entity enabled, you do not need to set this header.  | [optional] |
| **zuoraOrgIds** | **String**| Comma separated IDs. If you have &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Central_Platform/Multi-Org\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Zuora Multi-Org&lt;/a&gt; enabled,  you can use this header to specify which orgs to perform the operation in. If you do not have Zuora Multi-Org enabled, you should not set this header.  The IDs must be a sub-set of the user&#39;s accessible orgs. If you specify an org that the user does not have access to, the operation fails.  If the header is not set, the operation is performed in scope of the user&#39;s accessible orgs.  | [optional] |
| **page** | **Integer**| The index number of the page that you want to retrieve. This parameter is dependent on &#x60;pageSize&#x60;. You must set &#x60;pageSize&#x60; before specifying &#x60;page&#x60;. For example, if you set &#x60;pageSize&#x60; to &#x60;20&#x60; and &#x60;page&#x60; to &#x60;2&#x60;, the 21st to 40th records are returned in the response.  | [optional] [default to 1] |
| **pageSize** | **Integer**| The number of records returned per page in the response.  | [optional] [default to 20] |
| **dateFilterOption** | **String**| The date type to filter on. This field value can be orderDate or updatedDate. Default is orderDate.  | [optional] |
| **startDate** | **LocalDate**| The result will only contain the orders with the date of dateFilterOption later than or equal to this date.  | [optional] |
| **endDate** | **LocalDate**| The result will only contains orders with the date of dateFilterOption earlier than or equal to this date.  | [optional] |
| **status** | **String**| The status of orders. | [optional] [enum: all, cancelled, completed, draft, executing, failed, pending, scheduled] |

### Return type

[**GetAllOrdersResponseType**](GetAllOrdersResponseType.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** |  |  * Content-Encoding - This header is returned if you specify the &#x60;Accept-Encoding: gzip&#x60; request header and the response contains over 1000 bytes of data. Note that only the following MIME types support gzipped responses:   - &#x60;application/json&#x60;   - &#x60;application/xml&#x60;   - &#x60;text/html&#x60;   - &#x60;text/csv&#x60;   - &#x60;text/plain&#x60;  <br>  * RateLimit-Limit - The request limit quota for the time window closest to exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Remaining - The number of requests remaining in the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Reset - The number of seconds until the quota resets for the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Zuora-Request-Id - The Zuora internal identifier of the API call. You cannot control the value of this header.  <br>  * Zuora-Track-Id - A custom identifier for tracing the API call. If you specified a tracing identifier in the request headers, Zuora returns the same tracing identifier. Otherwise, Zuora does not set this header.  <br>  |

<a name="createOrderAsynchronously"></a>
# **createOrderAsynchronously**
> PostCreateOrderAsynchronouslyResponse createOrderAsynchronously(poSTOrderAsyncRequestType).idempotencyKey(idempotencyKey).acceptEncoding(acceptEncoding).contentEncoding(contentEncoding).authorization(authorization).zuoraTrackId(zuoraTrackId).zuoraEntityIds(zuoraEntityIds).zuoraOrgIds(zuoraOrgIds).returnIds(returnIds).zuoraVersion(zuoraVersion).execute();

Create an order asynchronously

**Note:** This operation is only available if you have the [Orders](https://knowledgecenter.zuora.com/BC_Subscription_Management/Orders/AA_Overview_of_Orders#Orders) feature enabled. If you are an existing Zuora &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Subscriptions/Subscriptions/Subscribe_and_Amend\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Subscribe and Amend&lt;/a&gt; customer, we recommend you enable &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Subscriptions/Subscriptions/Orders_Harmonization/A_Overview_of_Orders_Harmonization\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Orders Harmonization&lt;/a&gt; to access the &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Subscriptions/Subscriptions/Orders/AA_Overview_of_Orders/A_Overview_of_Orders\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Orders&lt;/a&gt; feature. With Orders, you can access both existing functions for subscription and billing management and the &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Subscriptions/Subscriptions/Orders_Harmonization/P_FAQ_about_Orders_Harmonization#New+features+through+Orders\&quot; target&#x3D;\&quot;_blank\&quot;&gt;new features&lt;/a&gt; on Zuora Billing.  **Note:** The [Order Line Items](https://knowledgecenter.zuora.com/Billing/Subscriptions/Orders/Order_Line_Items/AA_Overview_of_Order_Line_Items) feature is now generally available to all Zuora customers. You need to enable the [Orders](https://knowledgecenter.zuora.com/BC_Subscription_Management/Orders/AA_Overview_of_Orders#Orders) feature to access the [Order Line Items](https://knowledgecenter.zuora.com/Billing/Subscriptions/Orders/Order_Line_Items/AA_Overview_of_Order_Line_Items) feature. As of Zuora Billing Release 313 (November 2021), new customers who onboard on [Orders](https://knowledgecenter.zuora.com/Billing/Subscriptions/Orders/AA_Overview_of_Orders) will have the [Order Line Items](https://knowledgecenter.zuora.com/Billing/Subscriptions/Orders/Order_Line_Items) feature enabled by default.        In the case where a normal \&quot;Create an order\&quot; operation call will time out, use this operation instead to create an order asynchronously. A job will be creating the order in the back end; the job ID will be returned for tracking the job status and result.   Note that this operation doesn&#39;t support auto-refund and invoice write-off during subscription cancellation. Use the \&quot;Create an order\&quot; operation instead.  The limit of orders allowed on a subscription is 1000.  The limit of order line items allowed in an order is 100.  Zuora has the following limits on the Orders synchronous API to prevent performance degradation:  * Up to 50 subscriptions are allowed in a single [Create an order](https://developer.zuora.com/api-references/api/operation/POST_Order) or [Preview an order](https://developer.zuora.com/api-references/api/operation/POST_PreviewOrder) operation call. * Up to 50 order actions are allowed in a single [Create an order](https://developer.zuora.com/api-references/api/operation/POST_Order) or [Preview an order](https://developer.zuora.com/api-references/api/operation/POST_PreviewOrder) operation call. * Up to 50 order actions are allowed on a single subscription in a [Create an order](https://developer.zuora.com/api-references/api/operation/POST_Order) or [Preview an order](https://developer.zuora.com/api-references/api/operation/POST_PreviewOrder) operation call.  If you have an Order that exceeds any limits of the above, Zuora recommends you use the following asynchronous API operations: * [Create an order asynchronously](https://developer.zuora.com/api-references/api/operation/POST_CreateOrderAsynchronously) * [Preview an order asynchronously](https://developer.zuora.com/api-references/api/operation/POST_PreviewOrderAsynchronously) * [Retrieve the status and response of a job](https://developer.zuora.com/api-references/api/operation/GET_JobStatusAndResponse) for checking the status of the asynchronous API operations  Zuora has the following limits on the Orders asynchronous API operations to prevent performance degradation: * Up to 300 subscriptions are allowed in a single [Create an order asynchronously](https://developer.zuora.com/api-references/api/operation/POST_CreateOrderAsynchronously) or [Preview an order asynchronously](https://developer.zuora.com/api-references/api/operation/POST_PreviewOrderAsynchronously) operation call. * Up to 300 order actions are allowed in a single [Create an order asynchronously](https://developer.zuora.com/api-references/api/operation/POST_CreateOrderAsynchronously) or [Preview an order asynchronously](https://developer.zuora.com/api-references/api/operation/POST_PreviewOrderAsynchronously) operation call. * Up to 300 order actions are allowed on a single subscription in a [Create an order asynchronously](https://developer.zuora.com/api-references/api/operation/POST_CreateOrderAsynchronously) or [Preview an order asynchronously](https://developer.zuora.com/api-references/api/operation/POST_PreviewOrderAsynchronously) operation call. 

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Zuora;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.OrdersApi;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Example {
  public static void main(String[] args) {
    Configuration configuration = new Configuration();
    configuration.host = "https://rest.zuora.com";
    Zuora client = new Zuora(configuration);
    LocalDate orderDate = LocalDate.now(); // The date when the order is signed. All the order actions under this order will use this order date as the contract effective date if the contract effective date field is skipped or its value is left as null.
    String description = "description_example"; // A description of the order.
    String category = "NewSales"; // Category of the order to indicate a product sale or return. Default value is `NewSales`. 
    Map<String, Object> customFields = new HashMap(); // Container for custom fields of an Order object. 
    String existingAccountNumber = "existingAccountNumber_example"; // The account number that this order will be created under. Note that this actually specifies the invoice owner account of the subscriptions included in this order. 
    String externallyManagedBy = "Amazon"; // An enum field on the Subscription object to indicate the name of a third-party store. This field is used to represent subscriptions created through third-party stores. 
    CreateOrderNewAccount newAccount = new CreateOrderNewAccount();
    List<OrderLineItemCommonPostOrder> orderLineItems = Arrays.asList(); // [Order Line Items](https://knowledgecenter.zuora.com/Billing/Subscriptions/Orders/Order_Line_Items/AA_Overview_of_Order_Line_Items) are non subscription based items created by an Order, representing transactional charges such as one-time fees, physical goods, or professional service charges that are not sold as subscription services.   With the Order Line Items feature enabled, you can now launch non-subscription and unified monetization business models in Zuora, in addition to subscription business models.  **Note:** The [Order Line Items](https://knowledgecenter.zuora.com/Billing/Subscriptions/Orders/Order_Line_Items/AA_Overview_of_Order_Line_Items) feature is now generally available to all Zuora customers. You need to enable the [Orders](https://knowledgecenter.zuora.com/BC_Subscription_Management/Orders/AA_Overview_of_Orders#Orders) feature to access the [Order Line Items](https://knowledgecenter.zuora.com/Billing/Subscriptions/Orders/Order_Line_Items/AA_Overview_of_Order_Line_Items) feature. As of Zuora Billing Release 313 (November 2021), new customers who onboard on [Orders](https://knowledgecenter.zuora.com/Billing/Subscriptions/Orders/AA_Overview_of_Orders) will have the [Order Line Items](https://knowledgecenter.zuora.com/Billing/Subscriptions/Orders/Order_Line_Items) feature enabled by default.         
    String orderNumber = "orderNumber_example"; // The order number of the new order. If not provided, system will auto-generate a number for this order.    **Note:** Make sure the order number does not contain a slash. 
    ProcessingOptionsOrdersAsync processingOptions = new ProcessingOptionsOrdersAsync();
    String reasonCode = "reasonCode_example"; // Values of reason code configured in **Billing Settings** > **Configure Reason Codes** through Zuora UI. Indicates the reason when a return order line item occurs. 
    List<POSTOrderRequestTypeSubscriptionsInner> subscriptions = Arrays.asList(); // Each item includes a set of order actions, which will be applied to the same base subscription.
    String idempotencyKey = "idempotencyKey_example"; // Specify a unique idempotency key if you want to perform an idempotent POST or PATCH request. Do not use this header in other request types.   With this header specified, the Zuora server can identify subsequent retries of the same request using this value, which prevents the same operation from being performed multiple times by accident.  
    String acceptEncoding = "acceptEncoding_example"; // Include the `Accept-Encoding: gzip` header to compress responses as a gzipped file. It can significantly reduce the bandwidth required for a response.   If specified, Zuora automatically compresses responses that contain over 1000 bytes of data, and the response contains a `Content-Encoding` header with the compression algorithm so that your client can decompress it. 
    String contentEncoding = "contentEncoding_example"; // Include the `Content-Encoding: gzip` header to compress a request. With this header specified, you should upload a gzipped file for the request payload instead of sending the JSON payload. 
    String authorization = "authorization_example"; // The value is in the `Bearer {token}` format where {token} is a valid OAuth token generated by calling [Create an OAuth token](https://developer.zuora.com/api-references/api/operation/createToken). 
    String zuoraTrackId = "zuoraTrackId_example"; // A custom identifier for tracing the API call. If you set a value for this header, Zuora returns the same value in the response headers. This header enables you to associate your system process identifiers with Zuora API calls, to assist with troubleshooting in the event of an issue.  The value of this field must use the US-ASCII character set and must not include any of the following characters: colon (`:`), semicolon (`;`), double quote (`\"`), and quote (`'`). 
    String zuoraEntityIds = "zuoraEntityIds_example"; // An entity ID. If you have [Zuora Multi-entity](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Multi-entity) enabled and the OAuth token is valid for more than one entity, you must use this header to specify which entity to perform the operation in. If the OAuth token is only valid for a single entity, or you do not have Zuora Multi-entity enabled, you do not need to set this header. 
    String zuoraOrgIds = "zuoraOrgIds_example"; // Comma separated IDs. If you have <a href=\"https://knowledgecenter.zuora.com/Zuora_Central_Platform/Multi-Org\" target=\"_blank\">Zuora Multi-Org</a> enabled,  you can use this header to specify which orgs to perform the operation in. If you do not have Zuora Multi-Org enabled, you should not set this header.  The IDs must be a sub-set of the user's accessible orgs. If you specify an org that the user does not have access to, the operation fails.  If the header is not set, the operation is performed in scope of the user's accessible orgs. 
    Boolean returnIds = false; // Specify whether to return IDs for the [Get job status and response](https://developer.zuora.com/api-references/api/operation/GET_JobStatusAndResponse) operation. If you set this query parameter to `true`, the corresponding IDs, which are associated with the numbers returned in this operation, can be returned in the \"Get job status and response\" response body. 
    String zuoraVersion = "zuoraVersion_example"; //  The minor version of the Zuora REST API.   You need to set this parameter if you want to use the following fields: * subscriptions * subscriptionNumbers * subscriptionIds (when the `returnId` query parameter is set to `true`) 
    try {
      PostCreateOrderAsynchronouslyResponse result = client
              .orders
              .createOrderAsynchronously(orderDate)
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
      System.out.println(result);
      System.out.println(result.getJobId());
      System.out.println(result.getSuccess());
    } catch (ApiException e) {
      System.err.println("Exception when calling OrdersApi#createOrderAsynchronously");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<PostCreateOrderAsynchronouslyResponse> response = client
              .orders
              .createOrderAsynchronously(orderDate)
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
              .executeWithHttpInfo();
      System.out.println(response.getResponseBody());
      System.out.println(response.getResponseHeaders());
      System.out.println(response.getStatusCode());
      System.out.println(response.getRoundTripTime());
      System.out.println(response.getRequest());
    } catch (ApiException e) {
      System.err.println("Exception when calling OrdersApi#createOrderAsynchronously");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}

```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **poSTOrderAsyncRequestType** | [**POSTOrderAsyncRequestType**](POSTOrderAsyncRequestType.md)|  | |
| **idempotencyKey** | **String**| Specify a unique idempotency key if you want to perform an idempotent POST or PATCH request. Do not use this header in other request types.   With this header specified, the Zuora server can identify subsequent retries of the same request using this value, which prevents the same operation from being performed multiple times by accident.   | [optional] |
| **acceptEncoding** | **String**| Include the &#x60;Accept-Encoding: gzip&#x60; header to compress responses as a gzipped file. It can significantly reduce the bandwidth required for a response.   If specified, Zuora automatically compresses responses that contain over 1000 bytes of data, and the response contains a &#x60;Content-Encoding&#x60; header with the compression algorithm so that your client can decompress it.  | [optional] |
| **contentEncoding** | **String**| Include the &#x60;Content-Encoding: gzip&#x60; header to compress a request. With this header specified, you should upload a gzipped file for the request payload instead of sending the JSON payload.  | [optional] |
| **authorization** | **String**| The value is in the &#x60;Bearer {token}&#x60; format where {token} is a valid OAuth token generated by calling [Create an OAuth token](https://developer.zuora.com/api-references/api/operation/createToken).  | [optional] |
| **zuoraTrackId** | **String**| A custom identifier for tracing the API call. If you set a value for this header, Zuora returns the same value in the response headers. This header enables you to associate your system process identifiers with Zuora API calls, to assist with troubleshooting in the event of an issue.  The value of this field must use the US-ASCII character set and must not include any of the following characters: colon (&#x60;:&#x60;), semicolon (&#x60;;&#x60;), double quote (&#x60;\&quot;&#x60;), and quote (&#x60;&#39;&#x60;).  | [optional] |
| **zuoraEntityIds** | **String**| An entity ID. If you have [Zuora Multi-entity](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Multi-entity) enabled and the OAuth token is valid for more than one entity, you must use this header to specify which entity to perform the operation in. If the OAuth token is only valid for a single entity, or you do not have Zuora Multi-entity enabled, you do not need to set this header.  | [optional] |
| **zuoraOrgIds** | **String**| Comma separated IDs. If you have &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Central_Platform/Multi-Org\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Zuora Multi-Org&lt;/a&gt; enabled,  you can use this header to specify which orgs to perform the operation in. If you do not have Zuora Multi-Org enabled, you should not set this header.  The IDs must be a sub-set of the user&#39;s accessible orgs. If you specify an org that the user does not have access to, the operation fails.  If the header is not set, the operation is performed in scope of the user&#39;s accessible orgs.  | [optional] |
| **returnIds** | **Boolean**| Specify whether to return IDs for the [Get job status and response](https://developer.zuora.com/api-references/api/operation/GET_JobStatusAndResponse) operation. If you set this query parameter to &#x60;true&#x60;, the corresponding IDs, which are associated with the numbers returned in this operation, can be returned in the \&quot;Get job status and response\&quot; response body.  | [optional] [default to false] |
| **zuoraVersion** | **String**|  The minor version of the Zuora REST API.   You need to set this parameter if you want to use the following fields: * subscriptions * subscriptionNumbers * subscriptionIds (when the &#x60;returnId&#x60; query parameter is set to &#x60;true&#x60;)  | [optional] |

### Return type

[**PostCreateOrderAsynchronouslyResponse**](PostCreateOrderAsynchronouslyResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **202** | Accepted |  * Content-Encoding - This header is returned if you specify the &#x60;Accept-Encoding: gzip&#x60; request header and the response contains over 1000 bytes of data. Note that only the following MIME types support gzipped responses:   - &#x60;application/json&#x60;   - &#x60;application/xml&#x60;   - &#x60;text/html&#x60;   - &#x60;text/csv&#x60;   - &#x60;text/plain&#x60;  <br>  * Location - URL for accessing the job result, in the format of &#x60;/async-jobs/{jobId}&#x60;. For example, &#x60;/async-jobs/1bc24f315d7b48d3a20245bfe73bdceb&#x60; <br>  * RateLimit-Limit - The request limit quota for the time window closest to exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Remaining - The number of requests remaining in the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Reset - The number of seconds until the quota resets for the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Zuora-Request-Id - The Zuora internal identifier of the API call. You cannot control the value of this header.  <br>  * Zuora-Track-Id - A custom identifier for tracing the API call. If you specified a tracing identifier in the request headers, Zuora returns the same tracing identifier. Otherwise, Zuora does not set this header.  <br>  |

<a name="jobStatusAndResponse"></a>
# **jobStatusAndResponse**
> GetJobStatusAndResponseResponse jobStatusAndResponse(jobId).acceptEncoding(acceptEncoding).contentEncoding(contentEncoding).authorization(authorization).zuoraTrackId(zuoraTrackId).execute();

Retrieve the status and response of a job

**Note:** This operation is only available if you have the [Orders](https://knowledgecenter.zuora.com/BC_Subscription_Management/Orders/AA_Overview_of_Orders#Orders) feature enabled. If you are an existing Zuora &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Subscriptions/Subscriptions/Subscribe_and_Amend\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Subscribe and Amend&lt;/a&gt; customer, we recommend you enable &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Subscriptions/Subscriptions/Orders_Harmonization/A_Overview_of_Orders_Harmonization\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Orders Harmonization&lt;/a&gt; to access the &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Subscriptions/Subscriptions/Orders/AA_Overview_of_Orders/A_Overview_of_Orders\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Orders&lt;/a&gt; feature. With Orders, you can access both existing functions for subscription and billing management and the &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Subscriptions/Subscriptions/Orders_Harmonization/P_FAQ_about_Orders_Harmonization#New+features+through+Orders\&quot; target&#x3D;\&quot;_blank\&quot;&gt;new features&lt;/a&gt; on Zuora Billing.  **Note:** The [Order Line Items](https://knowledgecenter.zuora.com/Billing/Subscriptions/Orders/Order_Line_Items/AA_Overview_of_Order_Line_Items) feature is now generally available to all Zuora customers. You need to enable the [Orders](https://knowledgecenter.zuora.com/BC_Subscription_Management/Orders/AA_Overview_of_Orders#Orders) feature to access the [Order Line Items](https://knowledgecenter.zuora.com/Billing/Subscriptions/Orders/Order_Line_Items/AA_Overview_of_Order_Line_Items) feature. As of Zuora Billing Release 313 (November 2021), new customers who onboard on [Orders](https://knowledgecenter.zuora.com/Billing/Subscriptions/Orders/AA_Overview_of_Orders) will have the [Order Line Items](https://knowledgecenter.zuora.com/Billing/Subscriptions/Orders/Order_Line_Items) feature enabled by default.         Get the status and response of an asynchronous job. Currently, an asynchronous job created by \&quot;Create an order asynchronously\&quot; or \&quot;Preview an order asynchronously\&quot; is supported. 

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Zuora;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.OrdersApi;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Example {
  public static void main(String[] args) {
    Configuration configuration = new Configuration();
    configuration.host = "https://rest.zuora.com";
    Zuora client = new Zuora(configuration);
    UUID jobId = UUID.randomUUID(); // UUID of the asynchronous job created by an asynchronous API operation.
    String acceptEncoding = "acceptEncoding_example"; // Include the `Accept-Encoding: gzip` header to compress responses as a gzipped file. It can significantly reduce the bandwidth required for a response.   If specified, Zuora automatically compresses responses that contain over 1000 bytes of data, and the response contains a `Content-Encoding` header with the compression algorithm so that your client can decompress it. 
    String contentEncoding = "contentEncoding_example"; // Include the `Content-Encoding: gzip` header to compress a request. With this header specified, you should upload a gzipped file for the request payload instead of sending the JSON payload. 
    String authorization = "authorization_example"; // The value is in the `Bearer {token}` format where {token} is a valid OAuth token generated by calling [Create an OAuth token](https://developer.zuora.com/api-references/api/operation/createToken). 
    String zuoraTrackId = "zuoraTrackId_example"; // A custom identifier for tracing the API call. If you set a value for this header, Zuora returns the same value in the response headers. This header enables you to associate your system process identifiers with Zuora API calls, to assist with troubleshooting in the event of an issue.  The value of this field must use the US-ASCII character set and must not include any of the following characters: colon (`:`), semicolon (`;`), double quote (`\"`), and quote (`'`). 
    try {
      GetJobStatusAndResponseResponse result = client
              .orders
              .jobStatusAndResponse(jobId)
              .acceptEncoding(acceptEncoding)
              .contentEncoding(contentEncoding)
              .authorization(authorization)
              .zuoraTrackId(zuoraTrackId)
              .execute();
      System.out.println(result);
      System.out.println(result.getErrors());
      System.out.println(result.getResult());
      System.out.println(result.getStatus());
      System.out.println(result.getSuccess());
    } catch (ApiException e) {
      System.err.println("Exception when calling OrdersApi#jobStatusAndResponse");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<GetJobStatusAndResponseResponse> response = client
              .orders
              .jobStatusAndResponse(jobId)
              .acceptEncoding(acceptEncoding)
              .contentEncoding(contentEncoding)
              .authorization(authorization)
              .zuoraTrackId(zuoraTrackId)
              .executeWithHttpInfo();
      System.out.println(response.getResponseBody());
      System.out.println(response.getResponseHeaders());
      System.out.println(response.getStatusCode());
      System.out.println(response.getRoundTripTime());
      System.out.println(response.getRequest());
    } catch (ApiException e) {
      System.err.println("Exception when calling OrdersApi#jobStatusAndResponse");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}

```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **jobId** | **UUID**| UUID of the asynchronous job created by an asynchronous API operation. | |
| **acceptEncoding** | **String**| Include the &#x60;Accept-Encoding: gzip&#x60; header to compress responses as a gzipped file. It can significantly reduce the bandwidth required for a response.   If specified, Zuora automatically compresses responses that contain over 1000 bytes of data, and the response contains a &#x60;Content-Encoding&#x60; header with the compression algorithm so that your client can decompress it.  | [optional] |
| **contentEncoding** | **String**| Include the &#x60;Content-Encoding: gzip&#x60; header to compress a request. With this header specified, you should upload a gzipped file for the request payload instead of sending the JSON payload.  | [optional] |
| **authorization** | **String**| The value is in the &#x60;Bearer {token}&#x60; format where {token} is a valid OAuth token generated by calling [Create an OAuth token](https://developer.zuora.com/api-references/api/operation/createToken).  | [optional] |
| **zuoraTrackId** | **String**| A custom identifier for tracing the API call. If you set a value for this header, Zuora returns the same value in the response headers. This header enables you to associate your system process identifiers with Zuora API calls, to assist with troubleshooting in the event of an issue.  The value of this field must use the US-ASCII character set and must not include any of the following characters: colon (&#x60;:&#x60;), semicolon (&#x60;;&#x60;), double quote (&#x60;\&quot;&#x60;), and quote (&#x60;&#39;&#x60;).  | [optional] |

### Return type

[**GetJobStatusAndResponseResponse**](GetJobStatusAndResponseResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  * Content-Encoding - This header is returned if you specify the &#x60;Accept-Encoding: gzip&#x60; request header and the response contains over 1000 bytes of data. Note that only the following MIME types support gzipped responses:   - &#x60;application/json&#x60;   - &#x60;application/xml&#x60;   - &#x60;text/html&#x60;   - &#x60;text/csv&#x60;   - &#x60;text/plain&#x60;  <br>  * RateLimit-Limit - The request limit quota for the time window closest to exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Remaining - The number of requests remaining in the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Reset - The number of seconds until the quota resets for the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Zuora-Request-Id - The Zuora internal identifier of the API call. You cannot control the value of this header.  <br>  * Zuora-Track-Id - A custom identifier for tracing the API call. If you specified a tracing identifier in the request headers, Zuora returns the same tracing identifier. Otherwise, Zuora does not set this header.  <br>  |

<a name="order"></a>
# **order**
> PostOrderResponseType order(poSTOrderRequestType).idempotencyKey(idempotencyKey).acceptEncoding(acceptEncoding).contentEncoding(contentEncoding).authorization(authorization).zuoraTrackId(zuoraTrackId).zuoraEntityIds(zuoraEntityIds).zuoraOrgIds(zuoraOrgIds).returnIds(returnIds).zuoraVersion(zuoraVersion).execute();

Create an order

**Note:** This operation is only available if you have the [Orders](https://knowledgecenter.zuora.com/BC_Subscription_Management/Orders/AA_Overview_of_Orders#Orders) feature enabled. If you are an existing Zuora &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Subscriptions/Subscriptions/Subscribe_and_Amend\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Subscribe and Amend&lt;/a&gt; customer, we recommend you enable &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Subscriptions/Subscriptions/Orders_Harmonization/A_Overview_of_Orders_Harmonization\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Orders Harmonization&lt;/a&gt; to access the &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Subscriptions/Subscriptions/Orders/AA_Overview_of_Orders/A_Overview_of_Orders\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Orders&lt;/a&gt; feature. With Orders, you can access both existing functions for subscription and billing management and the &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Subscriptions/Subscriptions/Orders_Harmonization/P_FAQ_about_Orders_Harmonization#New+features+through+Orders\&quot; target&#x3D;\&quot;_blank\&quot;&gt;new features&lt;/a&gt; on Zuora Billing.  **Note:** The [Order Line Items](https://knowledgecenter.zuora.com/Billing/Subscriptions/Orders/Order_Line_Items/AA_Overview_of_Order_Line_Items) feature is now generally available to all Zuora customers. You need to enable the [Orders](https://knowledgecenter.zuora.com/BC_Subscription_Management/Orders/AA_Overview_of_Orders#Orders) feature to access the [Order Line Items](https://knowledgecenter.zuora.com/Billing/Subscriptions/Orders/Order_Line_Items/AA_Overview_of_Order_Line_Items) feature. As of Zuora Billing Release 313 (November 2021), new customers who onboard on [Orders](https://knowledgecenter.zuora.com/Billing/Subscriptions/Orders/AA_Overview_of_Orders) will have the [Order Line Items](https://knowledgecenter.zuora.com/Billing/Subscriptions/Orders/Order_Line_Items) feature enabled by default.         You can use this operation to create subscriptions and make changes to subscriptions by creating orders. You can also use this operation to create order line items by creating orders. The following tutorials demonstrate how to use this operation:   * [Create a Subscription](https://knowledgecenter.zuora.com/BC_Subscription_Management/Orders/AC_Orders_Tutorials/A_Create_a_Subscription)  * [Add a Product to a Subscription](https://knowledgecenter.zuora.com/BC_Subscription_Management/Orders/AC_Orders_Tutorials/A_Add_a_Product_to_a_Subscription)  * [Create a Ramp Deal](https://knowledgecenter.zuora.com/Billing/Subscriptions/Orders/Ramps_and_Ramp_Metrics/B_Create_a_Ramp_Deal)  * [Add a Product Mid-Interval Update on a Ramp Deal](https://knowledgecenter.zuora.com/Billing/Subscriptions/Orders/Ramps_and_Ramp_Metrics/E_Update_a_Product_in_a_Ramp_Deal)  * [Add a Product in a Ramp Deal](https://knowledgecenter.zuora.com/Billing/Subscriptions/Orders/Ramps_and_Ramp_Metrics/C_Add_a_Product_in_a_Ramp_Deal)  * [Change the Terms and Conditions of a Ramp Deal](https://knowledgecenter.zuora.com/Billing/Subscriptions/Orders/Ramps_and_Ramp_Metrics/D_Change_the_Terms_and_Conditions_of_a_Ramp_Deal_and_Update_the_Ramp)  * [Change the Owner of a Subscription](https://knowledgecenter.zuora.com/BC_Subscription_Management/Orders/AC_Orders_Tutorials/C_Change_the_Owner_of_a_Subscription)  * [Change the Terms and Conditions of a Subscription](https://knowledgecenter.zuora.com/BC_Subscription_Management/Orders/AC_Orders_Tutorials/C_Change_the_Terms_and_Conditions_of_a_Subscription)  * [Renew a Subscription](https://knowledgecenter.zuora.com/BC_Subscription_Management/Orders/AC_Orders_Tutorials/C_Renew_a_Subscription)  * [Renew a Subscription and Upgrade a Product](https://knowledgecenter.zuora.com/BC_Subscription_Management/Orders/AC_Orders_Tutorials/C_Renew_a_Subscription_and_Upgrade_a_Product)  * [Replace a Product in a Subscription](https://knowledgecenter.zuora.com/BC_Subscription_Management/Orders/AC_Orders_Tutorials/C_Replace_a_Product_in_a_Subscription)  * [Update a Product in a Subscription](https://knowledgecenter.zuora.com/BC_Subscription_Management/Orders/AC_Orders_Tutorials/C_Update_a_Product_in_a_Subscription)  * [Cancel a Subscription](https://knowledgecenter.zuora.com/BC_Subscription_Management/Orders/AC_Orders_Tutorials/D_Cancel_a_Subscription)  * [Remove a Product from a Subscription](https://knowledgecenter.zuora.com/BC_Subscription_Management/Orders/AC_Orders_Tutorials/D_Remove_a_Product_from_a_Subscription)  * [Create sales order line items](https://knowledgecenter.zuora.com/Zuora_Billing/Manage_non-subscription_transactions/Order_Line_Items/B_Manage_Order_Line_Items/AA_Create_a_sales_order_line_item_with_fulfillments)  * [Associate order line items with new subscriptions](https://knowledgecenter.zuora.com/Zuora_Billing/Manage_non-subscription_transactions/Order_Line_Items/B_Manage_Order_Line_Items/C_Associate_an_order_line_item_with_a_new_subscription)  * [Return order line items](https://knowledgecenter.zuora.com/Zuora_Billing/Manage_non-subscription_transactions/Order_Line_Items/B_Manage_Order_Line_Items/DA_Return_an_order_line_item_with_fulfillments)  You can also use this operation to create orders and save the orders as scehduled orders. To manage and access the &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Manage_subscription_transactions/Orders/AA_Overview_of_Orders/P_Scheduled_Orders\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Scheduled Orders&lt;/a&gt; feature from the self-service interface, see &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Configure_billing_settings/System_settings/Enable_billing_features_by_yourself\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Enable billing features by yourself&lt;/a&gt;.  In addition, you can use this operation to place a standalone order to subscribe without pre-defining a product catalog in Zuora Billing. For more information, see &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Manage_subscription_transactions/Orders/Standalone_Orders/Create_a_subscription_using_a_standalone_order\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Create a subscription using a standalone order&lt;/a&gt;. The &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Manage_subscription_transactions/Orders/Standalone_Orders/AA_Overview_of_Standalone_Orders\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Standalone Orders&lt;/a&gt; feature is in the **Early Adopter** phase. We are actively soliciting feedback from a small set of early adopters before releasing it as generally available. If you want to join this early adopter program, submit a request at [Zuora Global Support](https://support.zuora.com).  **Note:** If you received a timeout error message when creating an order, the call is still running in the backend and the order will be created.  The limit of orders allowed on a subscription is 1000.  The limit of order line items allowed in an order is 100.  Zuora has the following limits on the Orders synchronous API to prevent performance degradation:  * Up to 50 subscriptions are allowed in a single [Create an order](https://developer.zuora.com/api-references/api/operation/POST_Order) or [Preview an order](https://developer.zuora.com/api-references/api/operation/POST_PreviewOrder) operation call. * Up to 50 order actions are allowed in a single [Create an order](https://developer.zuora.com/api-references/api/operation/POST_Order) or [Preview an order](https://developer.zuora.com/api-references/api/operation/POST_PreviewOrder) operation call. * Up to 50 order actions are allowed on a single subscription in a [Create an order](https://developer.zuora.com/api-references/api/operation/POST_Order) or [Preview an order](https://developer.zuora.com/api-references/api/operation/POST_PreviewOrder) operation call.  If you have an Order that exceeds any limits of the above, Zuora recommends you use the following asynchronous API operations: * [Create an order asynchronously](https://developer.zuora.com/api-references/api/operation/POST_CreateOrderAsynchronously) * [Preview an order asynchronously](https://developer.zuora.com/api-references/api/operation/POST_PreviewOrderAsynchronously) * [Retrieve the status and response of a job](https://developer.zuora.com/api-references/api/operation/GET_JobStatusAndResponse) for checking the status of the asynchronous API operations  Zuora has the following limits on the Orders asynchronous API operations to prevent performance degradation: * Up to 300 subscriptions are allowed in a single [Create an order asynchronously](https://developer.zuora.com/api-references/api/operation/POST_CreateOrderAsynchronously) or [Preview an order asynchronously](https://developer.zuora.com/api-references/api/operation/POST_PreviewOrderAsynchronously) operation call. * Up to 300 order actions are allowed in a single [Create an order asynchronously](https://developer.zuora.com/api-references/api/operation/POST_CreateOrderAsynchronously) or [Preview an order asynchronously](https://developer.zuora.com/api-references/api/operation/POST_PreviewOrderAsynchronously) operation call. * Up to 300 order actions are allowed on a single subscription in a [Create an order asynchronously](https://developer.zuora.com/api-references/api/operation/POST_CreateOrderAsynchronously) or [Preview an order asynchronously](https://developer.zuora.com/api-references/api/operation/POST_PreviewOrderAsynchronously) operation call.   **Note:** When you are to suspend a subcription (via the &#x60;suspend&#x60; order action), if in the same \&quot;Create an order\&quot; call you are to perform other subsequent order actions on the supscription to suspend, you must first resume the subscription (via a &#x60;resume&#x60; order action).   **Note:** When using this operation to create an account, create a subscription, run billing, and collect payment in a single call, if any error occurs during the call, such as a payment processing failure and a tax engine failure, then all the other steps will be rolled back. This means that the invoice will not be generated, the subscription will not be created, and the account will not be created. 

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Zuora;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.OrdersApi;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Example {
  public static void main(String[] args) {
    Configuration configuration = new Configuration();
    configuration.host = "https://rest.zuora.com";
    Zuora client = new Zuora(configuration);
    LocalDate orderDate = LocalDate.now(); // The date when the order is signed. All the order actions under this order will use this order date as the contract effective date if the contract effective date field is skipped or its value is left as null.
    String description = "description_example"; // A description of the order.
    String category = "NewSales"; // Category of the order to indicate a product sale or return. Default value is `NewSales`. 
    Map<String, Object> customFields = new HashMap(); // Container for custom fields of an Order object. 
    String existingAccountNumber = "existingAccountNumber_example"; // The account number that this order will be created under. Note that this actually specifies the invoice owner account of the subscriptions included in this order. 
    String externallyManagedBy = "Amazon"; // An enum field on the Subscription object to indicate the name of a third-party store. This field is used to represent subscriptions created through third-party stores. 
    CreateOrderNewAccount newAccount = new CreateOrderNewAccount();
    List<OrderLineItemCommonPostOrder> orderLineItems = Arrays.asList(); // [Order Line Items](https://knowledgecenter.zuora.com/Billing/Subscriptions/Orders/Order_Line_Items/AA_Overview_of_Order_Line_Items) are non subscription based items created by an Order, representing transactional charges such as one-time fees, physical goods, or professional service charges that are not sold as subscription services.   With the Order Line Items feature enabled, you can now launch non-subscription and unified monetization business models in Zuora, in addition to subscription business models.  **Note:** The [Order Line Items](https://knowledgecenter.zuora.com/Billing/Subscriptions/Orders/Order_Line_Items/AA_Overview_of_Order_Line_Items) feature is now generally available to all Zuora customers. You need to enable the [Orders](https://knowledgecenter.zuora.com/BC_Subscription_Management/Orders/AA_Overview_of_Orders#Orders) feature to access the [Order Line Items](https://knowledgecenter.zuora.com/Billing/Subscriptions/Orders/Order_Line_Items/AA_Overview_of_Order_Line_Items) feature. As of Zuora Billing Release 313 (November 2021), new customers who onboard on [Orders](https://knowledgecenter.zuora.com/Billing/Subscriptions/Orders/AA_Overview_of_Orders) will have the [Order Line Items](https://knowledgecenter.zuora.com/Billing/Subscriptions/Orders/Order_Line_Items) feature enabled by default.         
    String orderNumber = "orderNumber_example"; // The order number of the new order. If not provided, system will auto-generate a number for this order.    **Note:** Make sure the order number does not contain a slash.  
    ProcessingOptionsOrdersWithDelayedCapturePayment processingOptions = new ProcessingOptionsOrdersWithDelayedCapturePayment();
    String reasonCode = "reasonCode_example"; // Values of reason code configured in **Billing Settings** > **Configure Reason Codes** through Zuora UI. Indicates the reason when a return order line item occurs. 
    POSTOrderRequestTypeSchedulingOptions schedulingOptions = new POSTOrderRequestTypeSchedulingOptions();
    String status = "Draft"; // The status of the order. The default value is `Completed`. The following values are supported: - `Draft`: The order is in draft status. - `Pending`: The order is in pending status. - `Completed`: The order is in completed status. - `Scheduled`: The order is in scheduled status and it is only valid if the Scheduled Orders feature is enabled. - `Executing`: The scheduled order is executed by a scheduler and it is only valid if the Scheduled Orders feature is enabled. - `Failed`: The scheduled order has failed.  **Note**: To manage and access the <a href=\\\"https://knowledgecenter.zuora.com/Zuora_Billing/Manage_subscription_transactions/Orders/AA_Overview_of_Orders/P_Scheduled_Orders\\\" target=\\\"_blank\\\">Scheduled Orders</a> from the self-service interface, see <a href=\\\"https://knowledgecenter.zuora.com/Zuora_Billing/Configure_billing_settings/System_settings/Enable_billing_features_by_yourself\\\" target=\\\"_blank\\\">Enable billing features by yourself</a>. 
    List<POSTOrderRequestTypeSubscriptionsInner> subscriptions = Arrays.asList(); // Each item includes a set of order actions, which will be applied to the same base subscription.
    String idempotencyKey = "idempotencyKey_example"; // Specify a unique idempotency key if you want to perform an idempotent POST or PATCH request. Do not use this header in other request types.   With this header specified, the Zuora server can identify subsequent retries of the same request using this value, which prevents the same operation from being performed multiple times by accident.  
    String acceptEncoding = "acceptEncoding_example"; // Include the `Accept-Encoding: gzip` header to compress responses as a gzipped file. It can significantly reduce the bandwidth required for a response.   If specified, Zuora automatically compresses responses that contain over 1000 bytes of data, and the response contains a `Content-Encoding` header with the compression algorithm so that your client can decompress it. 
    String contentEncoding = "contentEncoding_example"; // Include the `Content-Encoding: gzip` header to compress a request. With this header specified, you should upload a gzipped file for the request payload instead of sending the JSON payload. 
    String authorization = "authorization_example"; // The value is in the `Bearer {token}` format where {token} is a valid OAuth token generated by calling [Create an OAuth token](https://developer.zuora.com/api-references/api/operation/createToken). 
    String zuoraTrackId = "zuoraTrackId_example"; // A custom identifier for tracing the API call. If you set a value for this header, Zuora returns the same value in the response headers. This header enables you to associate your system process identifiers with Zuora API calls, to assist with troubleshooting in the event of an issue.  The value of this field must use the US-ASCII character set and must not include any of the following characters: colon (`:`), semicolon (`;`), double quote (`\"`), and quote (`'`). 
    String zuoraEntityIds = "zuoraEntityIds_example"; // An entity ID. If you have [Zuora Multi-entity](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Multi-entity) enabled and the OAuth token is valid for more than one entity, you must use this header to specify which entity to perform the operation in. If the OAuth token is only valid for a single entity, or you do not have Zuora Multi-entity enabled, you do not need to set this header. 
    String zuoraOrgIds = "zuoraOrgIds_example"; // Comma separated IDs. If you have <a href=\"https://knowledgecenter.zuora.com/Zuora_Central_Platform/Multi-Org\" target=\"_blank\">Zuora Multi-Org</a> enabled,  you can use this header to specify which orgs to perform the operation in. If you do not have Zuora Multi-Org enabled, you should not set this header.  The IDs must be a sub-set of the user's accessible orgs. If you specify an org that the user does not have access to, the operation fails.  If the header is not set, the operation is performed in scope of the user's accessible orgs. 
    Boolean returnIds = false; // Specify whether to return IDs associated with the numbers returned in the \"Create an order\" operation. 
    String zuoraVersion = "zuoraVersion_example"; //  The minor version of the Zuora REST API.   You need to set this parameter if you use the following fields: * subscriptions * subscriptionNumbers 
    try {
      PostOrderResponseType result = client
              .orders
              .order(orderDate)
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
      System.out.println(result);
      System.out.println(result.getProcessId());
      System.out.println(result.getReasons());
      System.out.println(result.getRequestId());
      System.out.println(result.getSuccess());
      System.out.println(result.getAccountId());
      System.out.println(result.getAccountNumber());
      System.out.println(result.getCreditMemoIds());
      System.out.println(result.getCreditMemoNumbers());
      System.out.println(result.getInvoiceIds());
      System.out.println(result.getInvoiceNumbers());
      System.out.println(result.getOrderId());
      System.out.println(result.getOrderLineItems());
      System.out.println(result.getOrderNumber());
      System.out.println(result.getPaidAmount());
      System.out.println(result.getPaymentId());
      System.out.println(result.getPaymentNumber());
      System.out.println(result.getRamps());
      System.out.println(result.getRefunds());
      System.out.println(result.getStatus());
      System.out.println(result.getSubscriptionIds());
      System.out.println(result.getSubscriptionNumbers());
      System.out.println(result.getSubscriptions());
      System.out.println(result.getWriteOff());
    } catch (ApiException e) {
      System.err.println("Exception when calling OrdersApi#order");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<PostOrderResponseType> response = client
              .orders
              .order(orderDate)
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
              .executeWithHttpInfo();
      System.out.println(response.getResponseBody());
      System.out.println(response.getResponseHeaders());
      System.out.println(response.getStatusCode());
      System.out.println(response.getRoundTripTime());
      System.out.println(response.getRequest());
    } catch (ApiException e) {
      System.err.println("Exception when calling OrdersApi#order");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}

```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **poSTOrderRequestType** | [**POSTOrderRequestType**](POSTOrderRequestType.md)|  | |
| **idempotencyKey** | **String**| Specify a unique idempotency key if you want to perform an idempotent POST or PATCH request. Do not use this header in other request types.   With this header specified, the Zuora server can identify subsequent retries of the same request using this value, which prevents the same operation from being performed multiple times by accident.   | [optional] |
| **acceptEncoding** | **String**| Include the &#x60;Accept-Encoding: gzip&#x60; header to compress responses as a gzipped file. It can significantly reduce the bandwidth required for a response.   If specified, Zuora automatically compresses responses that contain over 1000 bytes of data, and the response contains a &#x60;Content-Encoding&#x60; header with the compression algorithm so that your client can decompress it.  | [optional] |
| **contentEncoding** | **String**| Include the &#x60;Content-Encoding: gzip&#x60; header to compress a request. With this header specified, you should upload a gzipped file for the request payload instead of sending the JSON payload.  | [optional] |
| **authorization** | **String**| The value is in the &#x60;Bearer {token}&#x60; format where {token} is a valid OAuth token generated by calling [Create an OAuth token](https://developer.zuora.com/api-references/api/operation/createToken).  | [optional] |
| **zuoraTrackId** | **String**| A custom identifier for tracing the API call. If you set a value for this header, Zuora returns the same value in the response headers. This header enables you to associate your system process identifiers with Zuora API calls, to assist with troubleshooting in the event of an issue.  The value of this field must use the US-ASCII character set and must not include any of the following characters: colon (&#x60;:&#x60;), semicolon (&#x60;;&#x60;), double quote (&#x60;\&quot;&#x60;), and quote (&#x60;&#39;&#x60;).  | [optional] |
| **zuoraEntityIds** | **String**| An entity ID. If you have [Zuora Multi-entity](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Multi-entity) enabled and the OAuth token is valid for more than one entity, you must use this header to specify which entity to perform the operation in. If the OAuth token is only valid for a single entity, or you do not have Zuora Multi-entity enabled, you do not need to set this header.  | [optional] |
| **zuoraOrgIds** | **String**| Comma separated IDs. If you have &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Central_Platform/Multi-Org\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Zuora Multi-Org&lt;/a&gt; enabled,  you can use this header to specify which orgs to perform the operation in. If you do not have Zuora Multi-Org enabled, you should not set this header.  The IDs must be a sub-set of the user&#39;s accessible orgs. If you specify an org that the user does not have access to, the operation fails.  If the header is not set, the operation is performed in scope of the user&#39;s accessible orgs.  | [optional] |
| **returnIds** | **Boolean**| Specify whether to return IDs associated with the numbers returned in the \&quot;Create an order\&quot; operation.  | [optional] [default to false] |
| **zuoraVersion** | **String**|  The minor version of the Zuora REST API.   You need to set this parameter if you use the following fields: * subscriptions * subscriptionNumbers  | [optional] |

### Return type

[**PostOrderResponseType**](PostOrderResponseType.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** |  |  * Content-Encoding - This header is returned if you specify the &#x60;Accept-Encoding: gzip&#x60; request header and the response contains over 1000 bytes of data. Note that only the following MIME types support gzipped responses:   - &#x60;application/json&#x60;   - &#x60;application/xml&#x60;   - &#x60;text/html&#x60;   - &#x60;text/csv&#x60;   - &#x60;text/plain&#x60;  <br>  * RateLimit-Limit - The request limit quota for the time window closest to exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Remaining - The number of requests remaining in the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Reset - The number of seconds until the quota resets for the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Zuora-Request-Id - The Zuora internal identifier of the API call. You cannot control the value of this header.  <br>  * Zuora-Track-Id - A custom identifier for tracing the API call. If you specified a tracing identifier in the request headers, Zuora returns the same tracing identifier. Otherwise, Zuora does not set this header.  <br>  |

<a name="orderActivate"></a>
# **orderActivate**
> PostOrderResponseType orderActivate(orderNumber).acceptEncoding(acceptEncoding).contentEncoding(contentEncoding).authorization(authorization).zuoraTrackId(zuoraTrackId).zuoraEntityIds(zuoraEntityIds).zuoraOrgIds(zuoraOrgIds).execute();

Activate an order

**Note:** This operation is only available if you have the [Orders](https://knowledgecenter.zuora.com/BC_Subscription_Management/Orders/AA_Overview_of_Orders#Orders) feature enabled. If you are an existing Zuora &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Subscriptions/Subscriptions/Subscribe_and_Amend\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Subscribe and Amend&lt;/a&gt; customer, we recommend you enable &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Subscriptions/Subscriptions/Orders_Harmonization/A_Overview_of_Orders_Harmonization\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Orders Harmonization&lt;/a&gt; to access the &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Subscriptions/Subscriptions/Orders/AA_Overview_of_Orders/A_Overview_of_Orders\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Orders&lt;/a&gt; feature. With Orders, you can access both existing functions for subscription and billing management and the &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Subscriptions/Subscriptions/Orders_Harmonization/P_FAQ_about_Orders_Harmonization#New+features+through+Orders\&quot; target&#x3D;\&quot;_blank\&quot;&gt;new features&lt;/a&gt; on Zuora Billing.  Activate order is only available for draft orders. 

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Zuora;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.OrdersApi;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Example {
  public static void main(String[] args) {
    Configuration configuration = new Configuration();
    configuration.host = "https://rest.zuora.com";
    Zuora client = new Zuora(configuration);
    String orderNumber = "orderNumber_example"; // Order number of a order in which you are to activate.
    String acceptEncoding = "acceptEncoding_example"; // Include the `Accept-Encoding: gzip` header to compress responses as a gzipped file. It can significantly reduce the bandwidth required for a response.   If specified, Zuora automatically compresses responses that contain over 1000 bytes of data, and the response contains a `Content-Encoding` header with the compression algorithm so that your client can decompress it. 
    String contentEncoding = "contentEncoding_example"; // Include the `Content-Encoding: gzip` header to compress a request. With this header specified, you should upload a gzipped file for the request payload instead of sending the JSON payload. 
    String authorization = "authorization_example"; // The value is in the `Bearer {token}` format where {token} is a valid OAuth token generated by calling [Create an OAuth token](https://developer.zuora.com/api-references/api/operation/createToken). 
    String zuoraTrackId = "zuoraTrackId_example"; // A custom identifier for tracing the API call. If you set a value for this header, Zuora returns the same value in the response headers. This header enables you to associate your system process identifiers with Zuora API calls, to assist with troubleshooting in the event of an issue.  The value of this field must use the US-ASCII character set and must not include any of the following characters: colon (`:`), semicolon (`;`), double quote (`\"`), and quote (`'`). 
    String zuoraEntityIds = "zuoraEntityIds_example"; // An entity ID. If you have [Zuora Multi-entity](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Multi-entity) enabled and the OAuth token is valid for more than one entity, you must use this header to specify which entity to perform the operation in. If the OAuth token is only valid for a single entity, or you do not have Zuora Multi-entity enabled, you do not need to set this header. 
    String zuoraOrgIds = "zuoraOrgIds_example"; // Comma separated IDs. If you have <a href=\"https://knowledgecenter.zuora.com/Zuora_Central_Platform/Multi-Org\" target=\"_blank\">Zuora Multi-Org</a> enabled,  you can use this header to specify which orgs to perform the operation in. If you do not have Zuora Multi-Org enabled, you should not set this header.  The IDs must be a sub-set of the user's accessible orgs. If you specify an org that the user does not have access to, the operation fails.  If the header is not set, the operation is performed in scope of the user's accessible orgs. 
    try {
      PostOrderResponseType result = client
              .orders
              .orderActivate(orderNumber)
              .acceptEncoding(acceptEncoding)
              .contentEncoding(contentEncoding)
              .authorization(authorization)
              .zuoraTrackId(zuoraTrackId)
              .zuoraEntityIds(zuoraEntityIds)
              .zuoraOrgIds(zuoraOrgIds)
              .execute();
      System.out.println(result);
      System.out.println(result.getProcessId());
      System.out.println(result.getReasons());
      System.out.println(result.getRequestId());
      System.out.println(result.getSuccess());
      System.out.println(result.getAccountId());
      System.out.println(result.getAccountNumber());
      System.out.println(result.getCreditMemoIds());
      System.out.println(result.getCreditMemoNumbers());
      System.out.println(result.getInvoiceIds());
      System.out.println(result.getInvoiceNumbers());
      System.out.println(result.getOrderId());
      System.out.println(result.getOrderLineItems());
      System.out.println(result.getOrderNumber());
      System.out.println(result.getPaidAmount());
      System.out.println(result.getPaymentId());
      System.out.println(result.getPaymentNumber());
      System.out.println(result.getRamps());
      System.out.println(result.getRefunds());
      System.out.println(result.getStatus());
      System.out.println(result.getSubscriptionIds());
      System.out.println(result.getSubscriptionNumbers());
      System.out.println(result.getSubscriptions());
      System.out.println(result.getWriteOff());
    } catch (ApiException e) {
      System.err.println("Exception when calling OrdersApi#orderActivate");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<PostOrderResponseType> response = client
              .orders
              .orderActivate(orderNumber)
              .acceptEncoding(acceptEncoding)
              .contentEncoding(contentEncoding)
              .authorization(authorization)
              .zuoraTrackId(zuoraTrackId)
              .zuoraEntityIds(zuoraEntityIds)
              .zuoraOrgIds(zuoraOrgIds)
              .executeWithHttpInfo();
      System.out.println(response.getResponseBody());
      System.out.println(response.getResponseHeaders());
      System.out.println(response.getStatusCode());
      System.out.println(response.getRoundTripTime());
      System.out.println(response.getRequest());
    } catch (ApiException e) {
      System.err.println("Exception when calling OrdersApi#orderActivate");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}

```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **orderNumber** | **String**| Order number of a order in which you are to activate. | |
| **acceptEncoding** | **String**| Include the &#x60;Accept-Encoding: gzip&#x60; header to compress responses as a gzipped file. It can significantly reduce the bandwidth required for a response.   If specified, Zuora automatically compresses responses that contain over 1000 bytes of data, and the response contains a &#x60;Content-Encoding&#x60; header with the compression algorithm so that your client can decompress it.  | [optional] |
| **contentEncoding** | **String**| Include the &#x60;Content-Encoding: gzip&#x60; header to compress a request. With this header specified, you should upload a gzipped file for the request payload instead of sending the JSON payload.  | [optional] |
| **authorization** | **String**| The value is in the &#x60;Bearer {token}&#x60; format where {token} is a valid OAuth token generated by calling [Create an OAuth token](https://developer.zuora.com/api-references/api/operation/createToken).  | [optional] |
| **zuoraTrackId** | **String**| A custom identifier for tracing the API call. If you set a value for this header, Zuora returns the same value in the response headers. This header enables you to associate your system process identifiers with Zuora API calls, to assist with troubleshooting in the event of an issue.  The value of this field must use the US-ASCII character set and must not include any of the following characters: colon (&#x60;:&#x60;), semicolon (&#x60;;&#x60;), double quote (&#x60;\&quot;&#x60;), and quote (&#x60;&#39;&#x60;).  | [optional] |
| **zuoraEntityIds** | **String**| An entity ID. If you have [Zuora Multi-entity](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Multi-entity) enabled and the OAuth token is valid for more than one entity, you must use this header to specify which entity to perform the operation in. If the OAuth token is only valid for a single entity, or you do not have Zuora Multi-entity enabled, you do not need to set this header.  | [optional] |
| **zuoraOrgIds** | **String**| Comma separated IDs. If you have &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Central_Platform/Multi-Org\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Zuora Multi-Org&lt;/a&gt; enabled,  you can use this header to specify which orgs to perform the operation in. If you do not have Zuora Multi-Org enabled, you should not set this header.  The IDs must be a sub-set of the user&#39;s accessible orgs. If you specify an org that the user does not have access to, the operation fails.  If the header is not set, the operation is performed in scope of the user&#39;s accessible orgs.  | [optional] |

### Return type

[**PostOrderResponseType**](PostOrderResponseType.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** |  |  * Content-Encoding - This header is returned if you specify the &#x60;Accept-Encoding: gzip&#x60; request header and the response contains over 1000 bytes of data. Note that only the following MIME types support gzipped responses:   - &#x60;application/json&#x60;   - &#x60;application/xml&#x60;   - &#x60;text/html&#x60;   - &#x60;text/csv&#x60;   - &#x60;text/plain&#x60;  <br>  * RateLimit-Limit - The request limit quota for the time window closest to exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Remaining - The number of requests remaining in the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Reset - The number of seconds until the quota resets for the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Zuora-Request-Id - The Zuora internal identifier of the API call. You cannot control the value of this header.  <br>  * Zuora-Track-Id - A custom identifier for tracing the API call. If you specified a tracing identifier in the request headers, Zuora returns the same tracing identifier. Otherwise, Zuora does not set this header.  <br>  |

<a name="orderCancel"></a>
# **orderCancel**
> PutOrderCancelResponse orderCancel(orderNumber).acceptEncoding(acceptEncoding).contentEncoding(contentEncoding).authorization(authorization).zuoraTrackId(zuoraTrackId).zuoraEntityIds(zuoraEntityIds).zuoraOrgIds(zuoraOrgIds).putOrderCancelRequest(putOrderCancelRequest).execute();

Cancel an order

**Note:** This operation is only available if you have the [Orders](https://knowledgecenter.zuora.com/BC_Subscription_Management/Orders/AA_Overview_of_Orders#Orders) feature enabled. If you are an existing Zuora &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Subscriptions/Subscriptions/Subscribe_and_Amend\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Subscribe and Amend&lt;/a&gt; customer, we recommend you enable &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Subscriptions/Subscriptions/Orders_Harmonization/A_Overview_of_Orders_Harmonization\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Orders Harmonization&lt;/a&gt; to access the &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Subscriptions/Subscriptions/Orders/AA_Overview_of_Orders/A_Overview_of_Orders\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Orders&lt;/a&gt; feature. With Orders, you can access both existing functions for subscription and billing management and the &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Subscriptions/Subscriptions/Orders_Harmonization/P_FAQ_about_Orders_Harmonization#New+features+through+Orders\&quot; target&#x3D;\&quot;_blank\&quot;&gt;new features&lt;/a&gt; on Zuora Billing.  **Note:** Cancellation is only valid for draft or scheduled orders. If the order is not in draft or scheduled status, the API returns an error.  To manage and access the &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Manage_subscription_transactions/Orders/AA_Overview_of_Orders/P_Scheduled_Orders\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Scheduled Orders&lt;/a&gt; feature from the self-service interface, see &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Configure_billing_settings/System_settings/Enable_billing_features_by_yourself\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Enable billing features by yourself&lt;/a&gt;. 

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Zuora;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.OrdersApi;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Example {
  public static void main(String[] args) {
    Configuration configuration = new Configuration();
    configuration.host = "https://rest.zuora.com";
    Zuora client = new Zuora(configuration);
    String orderNumber = "orderNumber_example"; // The order number of the draft order you wish to cancel.
    String cancelReason = "cancelReason_example"; // The reason for cancelling the order.
    String acceptEncoding = "acceptEncoding_example"; // Include the `Accept-Encoding: gzip` header to compress responses as a gzipped file. It can significantly reduce the bandwidth required for a response.   If specified, Zuora automatically compresses responses that contain over 1000 bytes of data, and the response contains a `Content-Encoding` header with the compression algorithm so that your client can decompress it. 
    String contentEncoding = "contentEncoding_example"; // Include the `Content-Encoding: gzip` header to compress a request. With this header specified, you should upload a gzipped file for the request payload instead of sending the JSON payload. 
    String authorization = "authorization_example"; // The value is in the `Bearer {token}` format where {token} is a valid OAuth token generated by calling [Create an OAuth token](https://developer.zuora.com/api-references/api/operation/createToken). 
    String zuoraTrackId = "zuoraTrackId_example"; // A custom identifier for tracing the API call. If you set a value for this header, Zuora returns the same value in the response headers. This header enables you to associate your system process identifiers with Zuora API calls, to assist with troubleshooting in the event of an issue.  The value of this field must use the US-ASCII character set and must not include any of the following characters: colon (`:`), semicolon (`;`), double quote (`\"`), and quote (`'`). 
    String zuoraEntityIds = "zuoraEntityIds_example"; // An entity ID. If you have [Zuora Multi-entity](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Multi-entity) enabled and the OAuth token is valid for more than one entity, you must use this header to specify which entity to perform the operation in. If the OAuth token is only valid for a single entity, or you do not have Zuora Multi-entity enabled, you do not need to set this header. 
    String zuoraOrgIds = "zuoraOrgIds_example"; // Comma separated IDs. If you have <a href=\"https://knowledgecenter.zuora.com/Zuora_Central_Platform/Multi-Org\" target=\"_blank\">Zuora Multi-Org</a> enabled,  you can use this header to specify which orgs to perform the operation in. If you do not have Zuora Multi-Org enabled, you should not set this header.  The IDs must be a sub-set of the user's accessible orgs. If you specify an org that the user does not have access to, the operation fails.  If the header is not set, the operation is performed in scope of the user's accessible orgs. 
    try {
      PutOrderCancelResponse result = client
              .orders
              .orderCancel(orderNumber)
              .cancelReason(cancelReason)
              .acceptEncoding(acceptEncoding)
              .contentEncoding(contentEncoding)
              .authorization(authorization)
              .zuoraTrackId(zuoraTrackId)
              .zuoraEntityIds(zuoraEntityIds)
              .zuoraOrgIds(zuoraOrgIds)
              .execute();
      System.out.println(result);
      System.out.println(result.getProcessId());
      System.out.println(result.getReasons());
      System.out.println(result.getRequestId());
      System.out.println(result.getSuccess());
      System.out.println(result.getAccountNumber());
      System.out.println(result.getCancelReason());
      System.out.println(result.getOrderNumber());
      System.out.println(result.getStatus());
    } catch (ApiException e) {
      System.err.println("Exception when calling OrdersApi#orderCancel");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<PutOrderCancelResponse> response = client
              .orders
              .orderCancel(orderNumber)
              .cancelReason(cancelReason)
              .acceptEncoding(acceptEncoding)
              .contentEncoding(contentEncoding)
              .authorization(authorization)
              .zuoraTrackId(zuoraTrackId)
              .zuoraEntityIds(zuoraEntityIds)
              .zuoraOrgIds(zuoraOrgIds)
              .executeWithHttpInfo();
      System.out.println(response.getResponseBody());
      System.out.println(response.getResponseHeaders());
      System.out.println(response.getStatusCode());
      System.out.println(response.getRoundTripTime());
      System.out.println(response.getRequest());
    } catch (ApiException e) {
      System.err.println("Exception when calling OrdersApi#orderCancel");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}

```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **orderNumber** | **String**| The order number of the draft order you wish to cancel. | |
| **acceptEncoding** | **String**| Include the &#x60;Accept-Encoding: gzip&#x60; header to compress responses as a gzipped file. It can significantly reduce the bandwidth required for a response.   If specified, Zuora automatically compresses responses that contain over 1000 bytes of data, and the response contains a &#x60;Content-Encoding&#x60; header with the compression algorithm so that your client can decompress it.  | [optional] |
| **contentEncoding** | **String**| Include the &#x60;Content-Encoding: gzip&#x60; header to compress a request. With this header specified, you should upload a gzipped file for the request payload instead of sending the JSON payload.  | [optional] |
| **authorization** | **String**| The value is in the &#x60;Bearer {token}&#x60; format where {token} is a valid OAuth token generated by calling [Create an OAuth token](https://developer.zuora.com/api-references/api/operation/createToken).  | [optional] |
| **zuoraTrackId** | **String**| A custom identifier for tracing the API call. If you set a value for this header, Zuora returns the same value in the response headers. This header enables you to associate your system process identifiers with Zuora API calls, to assist with troubleshooting in the event of an issue.  The value of this field must use the US-ASCII character set and must not include any of the following characters: colon (&#x60;:&#x60;), semicolon (&#x60;;&#x60;), double quote (&#x60;\&quot;&#x60;), and quote (&#x60;&#39;&#x60;).  | [optional] |
| **zuoraEntityIds** | **String**| An entity ID. If you have [Zuora Multi-entity](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Multi-entity) enabled and the OAuth token is valid for more than one entity, you must use this header to specify which entity to perform the operation in. If the OAuth token is only valid for a single entity, or you do not have Zuora Multi-entity enabled, you do not need to set this header.  | [optional] |
| **zuoraOrgIds** | **String**| Comma separated IDs. If you have &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Central_Platform/Multi-Org\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Zuora Multi-Org&lt;/a&gt; enabled,  you can use this header to specify which orgs to perform the operation in. If you do not have Zuora Multi-Org enabled, you should not set this header.  The IDs must be a sub-set of the user&#39;s accessible orgs. If you specify an org that the user does not have access to, the operation fails.  If the header is not set, the operation is performed in scope of the user&#39;s accessible orgs.  | [optional] |
| **putOrderCancelRequest** | [**PutOrderCancelRequest**](PutOrderCancelRequest.md)|  | [optional] |

### Return type

[**PutOrderCancelResponse**](PutOrderCancelResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** |  |  * Content-Encoding - This header is returned if you specify the &#x60;Accept-Encoding: gzip&#x60; request header and the response contains over 1000 bytes of data. Note that only the following MIME types support gzipped responses:   - &#x60;application/json&#x60;   - &#x60;application/xml&#x60;   - &#x60;text/html&#x60;   - &#x60;text/csv&#x60;   - &#x60;text/plain&#x60;  <br>  * RateLimit-Limit - The request limit quota for the time window closest to exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Remaining - The number of requests remaining in the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Reset - The number of seconds until the quota resets for the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Zuora-Request-Id - The Zuora internal identifier of the API call. You cannot control the value of this header.  <br>  * Zuora-Track-Id - A custom identifier for tracing the API call. If you specified a tracing identifier in the request headers, Zuora returns the same tracing identifier. Otherwise, Zuora does not set this header.  <br>  |

<a name="orderTriggerDates"></a>
# **orderTriggerDates**
> PUTOrderTriggerDatesResponseType orderTriggerDates(orderNumber, puTOrderActionTriggerDatesRequestType).acceptEncoding(acceptEncoding).contentEncoding(contentEncoding).authorization(authorization).zuoraTrackId(zuoraTrackId).zuoraEntityIds(zuoraEntityIds).zuoraOrgIds(zuoraOrgIds).execute();

Update order action trigger dates

**Note:** This operation is only available if you have the [Orders](https://knowledgecenter.zuora.com/BC_Subscription_Management/Orders/AA_Overview_of_Orders#Orders) feature enabled. If you are an existing Zuora &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Subscriptions/Subscriptions/Subscribe_and_Amend\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Subscribe and Amend&lt;/a&gt; customer, we recommend you enable &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Subscriptions/Subscriptions/Orders_Harmonization/A_Overview_of_Orders_Harmonization\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Orders Harmonization&lt;/a&gt; to access the &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Subscriptions/Subscriptions/Orders/AA_Overview_of_Orders/A_Overview_of_Orders\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Orders&lt;/a&gt; feature. With Orders, you can access both existing functions for subscription and billing management and the &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Subscriptions/Subscriptions/Orders_Harmonization/P_FAQ_about_Orders_Harmonization#New+features+through+Orders\&quot; target&#x3D;\&quot;_blank\&quot;&gt;new features&lt;/a&gt; on Zuora Billing.  Updates the triggering dates for either of the following order actions:  * CreateSubscription  * AddProduct  * UpdateProduct  * RemoveProduct  * RenewSubscription  * TermsAndConditions 

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Zuora;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.OrdersApi;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Example {
  public static void main(String[] args) {
    Configuration configuration = new Configuration();
    configuration.host = "https://rest.zuora.com";
    Zuora client = new Zuora(configuration);
    String orderNumber = "orderNumber_example"; // Order number of a pending order in which you are to update an order action's triggering dates.
    List<PUTOrderActionTriggerDatesRequestTypeSubscriptionsInner> subscriptions = Arrays.asList();
    String acceptEncoding = "acceptEncoding_example"; // Include the `Accept-Encoding: gzip` header to compress responses as a gzipped file. It can significantly reduce the bandwidth required for a response.   If specified, Zuora automatically compresses responses that contain over 1000 bytes of data, and the response contains a `Content-Encoding` header with the compression algorithm so that your client can decompress it. 
    String contentEncoding = "contentEncoding_example"; // Include the `Content-Encoding: gzip` header to compress a request. With this header specified, you should upload a gzipped file for the request payload instead of sending the JSON payload. 
    String authorization = "authorization_example"; // The value is in the `Bearer {token}` format where {token} is a valid OAuth token generated by calling [Create an OAuth token](https://developer.zuora.com/api-references/api/operation/createToken). 
    String zuoraTrackId = "zuoraTrackId_example"; // A custom identifier for tracing the API call. If you set a value for this header, Zuora returns the same value in the response headers. This header enables you to associate your system process identifiers with Zuora API calls, to assist with troubleshooting in the event of an issue.  The value of this field must use the US-ASCII character set and must not include any of the following characters: colon (`:`), semicolon (`;`), double quote (`\"`), and quote (`'`). 
    String zuoraEntityIds = "zuoraEntityIds_example"; // An entity ID. If you have [Zuora Multi-entity](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Multi-entity) enabled and the OAuth token is valid for more than one entity, you must use this header to specify which entity to perform the operation in. If the OAuth token is only valid for a single entity, or you do not have Zuora Multi-entity enabled, you do not need to set this header. 
    String zuoraOrgIds = "zuoraOrgIds_example"; // Comma separated IDs. If you have <a href=\"https://knowledgecenter.zuora.com/Zuora_Central_Platform/Multi-Org\" target=\"_blank\">Zuora Multi-Org</a> enabled,  you can use this header to specify which orgs to perform the operation in. If you do not have Zuora Multi-Org enabled, you should not set this header.  The IDs must be a sub-set of the user's accessible orgs. If you specify an org that the user does not have access to, the operation fails.  If the header is not set, the operation is performed in scope of the user's accessible orgs. 
    try {
      PUTOrderTriggerDatesResponseType result = client
              .orders
              .orderTriggerDates(orderNumber)
              .subscriptions(subscriptions)
              .acceptEncoding(acceptEncoding)
              .contentEncoding(contentEncoding)
              .authorization(authorization)
              .zuoraTrackId(zuoraTrackId)
              .zuoraEntityIds(zuoraEntityIds)
              .zuoraOrgIds(zuoraOrgIds)
              .execute();
      System.out.println(result);
      System.out.println(result.getProcessId());
      System.out.println(result.getReasons());
      System.out.println(result.getRequestId());
      System.out.println(result.getSuccess());
      System.out.println(result.getAccountNumber());
      System.out.println(result.getOrderNumber());
      System.out.println(result.getStatus());
      System.out.println(result.getSubscriptions());
    } catch (ApiException e) {
      System.err.println("Exception when calling OrdersApi#orderTriggerDates");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<PUTOrderTriggerDatesResponseType> response = client
              .orders
              .orderTriggerDates(orderNumber)
              .subscriptions(subscriptions)
              .acceptEncoding(acceptEncoding)
              .contentEncoding(contentEncoding)
              .authorization(authorization)
              .zuoraTrackId(zuoraTrackId)
              .zuoraEntityIds(zuoraEntityIds)
              .zuoraOrgIds(zuoraOrgIds)
              .executeWithHttpInfo();
      System.out.println(response.getResponseBody());
      System.out.println(response.getResponseHeaders());
      System.out.println(response.getStatusCode());
      System.out.println(response.getRoundTripTime());
      System.out.println(response.getRequest());
    } catch (ApiException e) {
      System.err.println("Exception when calling OrdersApi#orderTriggerDates");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}

```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **orderNumber** | **String**| Order number of a pending order in which you are to update an order action&#39;s triggering dates. | |
| **puTOrderActionTriggerDatesRequestType** | [**PUTOrderActionTriggerDatesRequestType**](PUTOrderActionTriggerDatesRequestType.md)|  | |
| **acceptEncoding** | **String**| Include the &#x60;Accept-Encoding: gzip&#x60; header to compress responses as a gzipped file. It can significantly reduce the bandwidth required for a response.   If specified, Zuora automatically compresses responses that contain over 1000 bytes of data, and the response contains a &#x60;Content-Encoding&#x60; header with the compression algorithm so that your client can decompress it.  | [optional] |
| **contentEncoding** | **String**| Include the &#x60;Content-Encoding: gzip&#x60; header to compress a request. With this header specified, you should upload a gzipped file for the request payload instead of sending the JSON payload.  | [optional] |
| **authorization** | **String**| The value is in the &#x60;Bearer {token}&#x60; format where {token} is a valid OAuth token generated by calling [Create an OAuth token](https://developer.zuora.com/api-references/api/operation/createToken).  | [optional] |
| **zuoraTrackId** | **String**| A custom identifier for tracing the API call. If you set a value for this header, Zuora returns the same value in the response headers. This header enables you to associate your system process identifiers with Zuora API calls, to assist with troubleshooting in the event of an issue.  The value of this field must use the US-ASCII character set and must not include any of the following characters: colon (&#x60;:&#x60;), semicolon (&#x60;;&#x60;), double quote (&#x60;\&quot;&#x60;), and quote (&#x60;&#39;&#x60;).  | [optional] |
| **zuoraEntityIds** | **String**| An entity ID. If you have [Zuora Multi-entity](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Multi-entity) enabled and the OAuth token is valid for more than one entity, you must use this header to specify which entity to perform the operation in. If the OAuth token is only valid for a single entity, or you do not have Zuora Multi-entity enabled, you do not need to set this header.  | [optional] |
| **zuoraOrgIds** | **String**| Comma separated IDs. If you have &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Central_Platform/Multi-Org\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Zuora Multi-Org&lt;/a&gt; enabled,  you can use this header to specify which orgs to perform the operation in. If you do not have Zuora Multi-Org enabled, you should not set this header.  The IDs must be a sub-set of the user&#39;s accessible orgs. If you specify an org that the user does not have access to, the operation fails.  If the header is not set, the operation is performed in scope of the user&#39;s accessible orgs.  | [optional] |

### Return type

[**PUTOrderTriggerDatesResponseType**](PUTOrderTriggerDatesResponseType.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** |  |  * Content-Encoding - This header is returned if you specify the &#x60;Accept-Encoding: gzip&#x60; request header and the response contains over 1000 bytes of data. Note that only the following MIME types support gzipped responses:   - &#x60;application/json&#x60;   - &#x60;application/xml&#x60;   - &#x60;text/html&#x60;   - &#x60;text/csv&#x60;   - &#x60;text/plain&#x60;  <br>  * RateLimit-Limit - The request limit quota for the time window closest to exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Remaining - The number of requests remaining in the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Reset - The number of seconds until the quota resets for the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Zuora-Request-Id - The Zuora internal identifier of the API call. You cannot control the value of this header.  <br>  * Zuora-Track-Id - A custom identifier for tracing the API call. If you specified a tracing identifier in the request headers, Zuora returns the same tracing identifier. Otherwise, Zuora does not set this header.  <br>  |

<a name="order_0"></a>
# **order_0**
> GetOrderResponse order_0(orderNumber).acceptEncoding(acceptEncoding).contentEncoding(contentEncoding).authorization(authorization).zuoraTrackId(zuoraTrackId).zuoraEntityIds(zuoraEntityIds).zuoraOrgIds(zuoraOrgIds).execute();

Retrieve an order

**Note:** This feature is only available if you have the [Order Metrics](https://knowledgecenter.zuora.com/BC_Subscription_Management/Orders/AA_Overview_of_Orders#Order_Metrics) feature enabled. As of Zuora Billing Release 284, Orders is generally available and the Order Metrics feature is no longer available as a standalone feature. If you are an existing Subscribe and Amend customer and want Order Metrics only, you must turn on [Orders Harmonization](https://knowledgecenter.zuora.com/Billing/Subscriptions/Orders/Orders_Harmonization/Orders_Harmonization). You can still keep the existing Subscribe and Amend API integrations to create and manage subscriptions.  **Note:** The [Order Line Items](https://knowledgecenter.zuora.com/Billing/Subscriptions/Orders/Order_Line_Items/AA_Overview_of_Order_Line_Items) feature is now generally available to all Zuora customers. You need to enable the [Orders](https://knowledgecenter.zuora.com/BC_Subscription_Management/Orders/AA_Overview_of_Orders#Orders) feature to access the [Order Line Items](https://knowledgecenter.zuora.com/Billing/Subscriptions/Orders/Order_Line_Items/AA_Overview_of_Order_Line_Items) feature. As of Zuora Billing Release 313 (November 2021), new customers who onboard on [Orders](https://knowledgecenter.zuora.com/Billing/Subscriptions/Orders/AA_Overview_of_Orders) will have the [Order Line Items](https://knowledgecenter.zuora.com/Billing/Subscriptions/Orders/Order_Line_Items) feature enabled by default.         Retrieves the detailed information about a specified order. 

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Zuora;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.OrdersApi;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Example {
  public static void main(String[] args) {
    Configuration configuration = new Configuration();
    configuration.host = "https://rest.zuora.com";
    Zuora client = new Zuora(configuration);
    String orderNumber = "orderNumber_example"; // The order number to be retrieved.
    String acceptEncoding = "acceptEncoding_example"; // Include the `Accept-Encoding: gzip` header to compress responses as a gzipped file. It can significantly reduce the bandwidth required for a response.   If specified, Zuora automatically compresses responses that contain over 1000 bytes of data, and the response contains a `Content-Encoding` header with the compression algorithm so that your client can decompress it. 
    String contentEncoding = "contentEncoding_example"; // Include the `Content-Encoding: gzip` header to compress a request. With this header specified, you should upload a gzipped file for the request payload instead of sending the JSON payload. 
    String authorization = "authorization_example"; // The value is in the `Bearer {token}` format where {token} is a valid OAuth token generated by calling [Create an OAuth token](https://developer.zuora.com/api-references/api/operation/createToken). 
    String zuoraTrackId = "zuoraTrackId_example"; // A custom identifier for tracing the API call. If you set a value for this header, Zuora returns the same value in the response headers. This header enables you to associate your system process identifiers with Zuora API calls, to assist with troubleshooting in the event of an issue.  The value of this field must use the US-ASCII character set and must not include any of the following characters: colon (`:`), semicolon (`;`), double quote (`\"`), and quote (`'`). 
    String zuoraEntityIds = "zuoraEntityIds_example"; // An entity ID. If you have [Zuora Multi-entity](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Multi-entity) enabled and the OAuth token is valid for more than one entity, you must use this header to specify which entity to perform the operation in. If the OAuth token is only valid for a single entity, or you do not have Zuora Multi-entity enabled, you do not need to set this header. 
    String zuoraOrgIds = "zuoraOrgIds_example"; // Comma separated IDs. If you have <a href=\"https://knowledgecenter.zuora.com/Zuora_Central_Platform/Multi-Org\" target=\"_blank\">Zuora Multi-Org</a> enabled,  you can use this header to specify which orgs to perform the operation in. If you do not have Zuora Multi-Org enabled, you should not set this header.  The IDs must be a sub-set of the user's accessible orgs. If you specify an org that the user does not have access to, the operation fails.  If the header is not set, the operation is performed in scope of the user's accessible orgs. 
    try {
      GetOrderResponse result = client
              .orders
              .order_0(orderNumber)
              .acceptEncoding(acceptEncoding)
              .contentEncoding(contentEncoding)
              .authorization(authorization)
              .zuoraTrackId(zuoraTrackId)
              .zuoraEntityIds(zuoraEntityIds)
              .zuoraOrgIds(zuoraOrgIds)
              .execute();
      System.out.println(result);
      System.out.println(result.getProcessId());
      System.out.println(result.getReasons());
      System.out.println(result.getRequestId());
      System.out.println(result.getSuccess());
      System.out.println(result.getOrder());
    } catch (ApiException e) {
      System.err.println("Exception when calling OrdersApi#order_0");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<GetOrderResponse> response = client
              .orders
              .order_0(orderNumber)
              .acceptEncoding(acceptEncoding)
              .contentEncoding(contentEncoding)
              .authorization(authorization)
              .zuoraTrackId(zuoraTrackId)
              .zuoraEntityIds(zuoraEntityIds)
              .zuoraOrgIds(zuoraOrgIds)
              .executeWithHttpInfo();
      System.out.println(response.getResponseBody());
      System.out.println(response.getResponseHeaders());
      System.out.println(response.getStatusCode());
      System.out.println(response.getRoundTripTime());
      System.out.println(response.getRequest());
    } catch (ApiException e) {
      System.err.println("Exception when calling OrdersApi#order_0");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}

```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **orderNumber** | **String**| The order number to be retrieved. | |
| **acceptEncoding** | **String**| Include the &#x60;Accept-Encoding: gzip&#x60; header to compress responses as a gzipped file. It can significantly reduce the bandwidth required for a response.   If specified, Zuora automatically compresses responses that contain over 1000 bytes of data, and the response contains a &#x60;Content-Encoding&#x60; header with the compression algorithm so that your client can decompress it.  | [optional] |
| **contentEncoding** | **String**| Include the &#x60;Content-Encoding: gzip&#x60; header to compress a request. With this header specified, you should upload a gzipped file for the request payload instead of sending the JSON payload.  | [optional] |
| **authorization** | **String**| The value is in the &#x60;Bearer {token}&#x60; format where {token} is a valid OAuth token generated by calling [Create an OAuth token](https://developer.zuora.com/api-references/api/operation/createToken).  | [optional] |
| **zuoraTrackId** | **String**| A custom identifier for tracing the API call. If you set a value for this header, Zuora returns the same value in the response headers. This header enables you to associate your system process identifiers with Zuora API calls, to assist with troubleshooting in the event of an issue.  The value of this field must use the US-ASCII character set and must not include any of the following characters: colon (&#x60;:&#x60;), semicolon (&#x60;;&#x60;), double quote (&#x60;\&quot;&#x60;), and quote (&#x60;&#39;&#x60;).  | [optional] |
| **zuoraEntityIds** | **String**| An entity ID. If you have [Zuora Multi-entity](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Multi-entity) enabled and the OAuth token is valid for more than one entity, you must use this header to specify which entity to perform the operation in. If the OAuth token is only valid for a single entity, or you do not have Zuora Multi-entity enabled, you do not need to set this header.  | [optional] |
| **zuoraOrgIds** | **String**| Comma separated IDs. If you have &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Central_Platform/Multi-Org\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Zuora Multi-Org&lt;/a&gt; enabled,  you can use this header to specify which orgs to perform the operation in. If you do not have Zuora Multi-Org enabled, you should not set this header.  The IDs must be a sub-set of the user&#39;s accessible orgs. If you specify an org that the user does not have access to, the operation fails.  If the header is not set, the operation is performed in scope of the user&#39;s accessible orgs.  | [optional] |

### Return type

[**GetOrderResponse**](GetOrderResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** |  |  * Content-Encoding - This header is returned if you specify the &#x60;Accept-Encoding: gzip&#x60; request header and the response contains over 1000 bytes of data. Note that only the following MIME types support gzipped responses:   - &#x60;application/json&#x60;   - &#x60;application/xml&#x60;   - &#x60;text/html&#x60;   - &#x60;text/csv&#x60;   - &#x60;text/plain&#x60;  <br>  * RateLimit-Limit - The request limit quota for the time window closest to exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Remaining - The number of requests remaining in the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Reset - The number of seconds until the quota resets for the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Zuora-Request-Id - The Zuora internal identifier of the API call. You cannot control the value of this header.  <br>  * Zuora-Track-Id - A custom identifier for tracing the API call. If you specified a tracing identifier in the request headers, Zuora returns the same tracing identifier. Otherwise, Zuora does not set this header.  <br>  |

<a name="order_1"></a>
# **order_1**
> PostOrderResponseType order_1(orderNumber, puTOrderRequestType).acceptEncoding(acceptEncoding).contentEncoding(contentEncoding).authorization(authorization).zuoraTrackId(zuoraTrackId).zuoraEntityIds(zuoraEntityIds).zuoraOrgIds(zuoraOrgIds).execute();

Update an order

**Notes:**  - This operation is only available if you have the [Orders](https://knowledgecenter.zuora.com/BC_Subscription_Management/Orders/AA_Overview_of_Orders#Orders) feature enabled. If you are an existing Zuora &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Subscriptions/Subscriptions/Subscribe_and_Amend\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Subscribe and Amend&lt;/a&gt; customer, we recommend you enable &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Subscriptions/Subscriptions/Orders_Harmonization/A_Overview_of_Orders_Harmonization\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Orders Harmonization&lt;/a&gt; to access the &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Subscriptions/Subscriptions/Orders/AA_Overview_of_Orders/A_Overview_of_Orders\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Orders&lt;/a&gt; feature. With Orders, you can access both existing functions for subscription and billing management and the &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Subscriptions/Subscriptions/Orders_Harmonization/P_FAQ_about_Orders_Harmonization#New+features+through+Orders\&quot; target&#x3D;\&quot;_blank\&quot;&gt;new features&lt;/a&gt; on Zuora Billing. - Update an order is only valid for draft or scheduled orders. To manage and access the &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Manage_subscription_transactions/Orders/AA_Overview_of_Orders/P_Scheduled_Orders\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Scheduled Orders&lt;/a&gt; feature from the self-service interface, see &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Configure_billing_settings/System_settings/Enable_billing_features_by_yourself\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Enable billing features by yourself&lt;/a&gt;. - This operation doesn&#39;t support auto-refund and invoice write-off during subscription cancellation. Use the \&quot;Create an order\&quot; operation instead. - You must provide full payload when using the \&quot;Update an order\&quot; operation. That is, if you want to edit one order action, you need to provide all other order actions in the payload. Otherwise, the other order actions will be removed. 

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Zuora;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.OrdersApi;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Example {
  public static void main(String[] args) {
    Configuration configuration = new Configuration();
    configuration.host = "https://rest.zuora.com";
    Zuora client = new Zuora(configuration);
    LocalDate orderDate = LocalDate.now(); // The date when the order is signed. All the order actions under this order will use this order date as the contract effective date if the contract effective date field is skipped or its value is left as null.
    String orderNumber = "orderNumber_example"; // Order number of a order in which you are to update.
    String description = "description_example"; // A description of the order.
    String category = "NewSales"; // Category of the order to indicate a product sale or return. Default value is `NewSales`. 
    Map<String, Object> customFields = new HashMap(); // Container for custom fields of an Order object. 
    String existingAccountNumber = "existingAccountNumber_example"; // The account number that this order will be created under. Note that this actually specifies the invoice owner account of the subscriptions included in this order. 
    String externallyManagedBy = "Amazon"; // An enum field on the Subscription object to indicate the name of a third-party store. This field is used to represent subscriptions created through third-party stores. 
    List<OrderLineItemCommonPostOrder> orderLineItems = Arrays.asList(); // [Order Line Items](https://knowledgecenter.zuora.com/Billing/Subscriptions/Orders/Order_Line_Items/AA_Overview_of_Order_Line_Items) are non subscription based items created by an Order, representing transactional charges such as one-time fees, physical goods, or professional service charges that are not sold as subscription services.   With the Order Line Items feature enabled, you can now launch non-subscription and unified monetization business models in Zuora, in addition to subscription business models.  **Note:** The [Order Line Items](https://knowledgecenter.zuora.com/Billing/Subscriptions/Orders/Order_Line_Items/AA_Overview_of_Order_Line_Items) feature is now generally available to all Zuora customers. You need to enable the [Orders](https://knowledgecenter.zuora.com/BC_Subscription_Management/Orders/AA_Overview_of_Orders#Orders) feature to access the [Order Line Items](https://knowledgecenter.zuora.com/Billing/Subscriptions/Orders/Order_Line_Items/AA_Overview_of_Order_Line_Items) feature. As of Zuora Billing Release 313 (November 2021), new customers who onboard on [Orders](https://knowledgecenter.zuora.com/Billing/Subscriptions/Orders/AA_Overview_of_Orders) will have the [Order Line Items](https://knowledgecenter.zuora.com/Billing/Subscriptions/Orders/Order_Line_Items) feature enabled by default.         
    String orderNumber = "orderNumber_example"; // The order number of the new order. If not provided, system will auto-generate a number for this order.    **Note:** Make sure the order number does not contain a slash.  
    ProcessingOptionsOrders processingOptions = new ProcessingOptionsOrders();
    String reasonCode = "reasonCode_example"; // Values of reason code configured in **Billing Settings** > **Configure Reason Codes** through Zuora UI. Indicates the reason when a return order line item occurs. 
    POSTOrderRequestTypeSchedulingOptions schedulingOptions = new POSTOrderRequestTypeSchedulingOptions();
    String status = "Draft"; // The status of the order. The default value is `Completed`. The following values are supported: - `Draft`: The order is in draft status. - `Pending`: The order is in pending status. - `Completed`: The order is in completed status. - `Scheduled`: The order is in scheduled status and it is only valid if the Scheduled Orders feature is enabled. - `Executing`: The scheduled order is executed by a scheduler and it is only valid if the Scheduled Orders feature is enabled. - `Failed`: The scheduled order has failed.  **Note**: To manage and access the <a href=\\\"https://knowledgecenter.zuora.com/Zuora_Billing/Manage_subscription_transactions/Orders/AA_Overview_of_Orders/P_Scheduled_Orders\\\" target=\\\"_blank\\\">Scheduled Orders</a> feature from the self-service interface, see <a href=\\\"https://knowledgecenter.zuora.com/Zuora_Billing/Configure_billing_settings/System_settings/Enable_billing_features_by_yourself\\\" target=\\\"_blank\\\">Enable billing features by yourself</a>. 
    List<POSTOrderRequestTypeSubscriptionsInner> subscriptions = Arrays.asList(); // Each item includes a set of order actions, which will be applied to the same base subscription.
    String acceptEncoding = "acceptEncoding_example"; // Include the `Accept-Encoding: gzip` header to compress responses as a gzipped file. It can significantly reduce the bandwidth required for a response.   If specified, Zuora automatically compresses responses that contain over 1000 bytes of data, and the response contains a `Content-Encoding` header with the compression algorithm so that your client can decompress it. 
    String contentEncoding = "contentEncoding_example"; // Include the `Content-Encoding: gzip` header to compress a request. With this header specified, you should upload a gzipped file for the request payload instead of sending the JSON payload. 
    String authorization = "authorization_example"; // The value is in the `Bearer {token}` format where {token} is a valid OAuth token generated by calling [Create an OAuth token](https://developer.zuora.com/api-references/api/operation/createToken). 
    String zuoraTrackId = "zuoraTrackId_example"; // A custom identifier for tracing the API call. If you set a value for this header, Zuora returns the same value in the response headers. This header enables you to associate your system process identifiers with Zuora API calls, to assist with troubleshooting in the event of an issue.  The value of this field must use the US-ASCII character set and must not include any of the following characters: colon (`:`), semicolon (`;`), double quote (`\"`), and quote (`'`). 
    String zuoraEntityIds = "zuoraEntityIds_example"; // An entity ID. If you have [Zuora Multi-entity](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Multi-entity) enabled and the OAuth token is valid for more than one entity, you must use this header to specify which entity to perform the operation in. If the OAuth token is only valid for a single entity, or you do not have Zuora Multi-entity enabled, you do not need to set this header. 
    String zuoraOrgIds = "zuoraOrgIds_example"; // Comma separated IDs. If you have <a href=\"https://knowledgecenter.zuora.com/Zuora_Central_Platform/Multi-Org\" target=\"_blank\">Zuora Multi-Org</a> enabled,  you can use this header to specify which orgs to perform the operation in. If you do not have Zuora Multi-Org enabled, you should not set this header.  The IDs must be a sub-set of the user's accessible orgs. If you specify an org that the user does not have access to, the operation fails.  If the header is not set, the operation is performed in scope of the user's accessible orgs. 
    try {
      PostOrderResponseType result = client
              .orders
              .order_1(orderDate, orderNumber)
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
      System.out.println(result);
      System.out.println(result.getProcessId());
      System.out.println(result.getReasons());
      System.out.println(result.getRequestId());
      System.out.println(result.getSuccess());
      System.out.println(result.getAccountId());
      System.out.println(result.getAccountNumber());
      System.out.println(result.getCreditMemoIds());
      System.out.println(result.getCreditMemoNumbers());
      System.out.println(result.getInvoiceIds());
      System.out.println(result.getInvoiceNumbers());
      System.out.println(result.getOrderId());
      System.out.println(result.getOrderLineItems());
      System.out.println(result.getOrderNumber());
      System.out.println(result.getPaidAmount());
      System.out.println(result.getPaymentId());
      System.out.println(result.getPaymentNumber());
      System.out.println(result.getRamps());
      System.out.println(result.getRefunds());
      System.out.println(result.getStatus());
      System.out.println(result.getSubscriptionIds());
      System.out.println(result.getSubscriptionNumbers());
      System.out.println(result.getSubscriptions());
      System.out.println(result.getWriteOff());
    } catch (ApiException e) {
      System.err.println("Exception when calling OrdersApi#order_1");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<PostOrderResponseType> response = client
              .orders
              .order_1(orderDate, orderNumber)
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
              .executeWithHttpInfo();
      System.out.println(response.getResponseBody());
      System.out.println(response.getResponseHeaders());
      System.out.println(response.getStatusCode());
      System.out.println(response.getRoundTripTime());
      System.out.println(response.getRequest());
    } catch (ApiException e) {
      System.err.println("Exception when calling OrdersApi#order_1");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}

```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **orderNumber** | **String**| Order number of a order in which you are to update. | |
| **puTOrderRequestType** | [**PUTOrderRequestType**](PUTOrderRequestType.md)|  | |
| **acceptEncoding** | **String**| Include the &#x60;Accept-Encoding: gzip&#x60; header to compress responses as a gzipped file. It can significantly reduce the bandwidth required for a response.   If specified, Zuora automatically compresses responses that contain over 1000 bytes of data, and the response contains a &#x60;Content-Encoding&#x60; header with the compression algorithm so that your client can decompress it.  | [optional] |
| **contentEncoding** | **String**| Include the &#x60;Content-Encoding: gzip&#x60; header to compress a request. With this header specified, you should upload a gzipped file for the request payload instead of sending the JSON payload.  | [optional] |
| **authorization** | **String**| The value is in the &#x60;Bearer {token}&#x60; format where {token} is a valid OAuth token generated by calling [Create an OAuth token](https://developer.zuora.com/api-references/api/operation/createToken).  | [optional] |
| **zuoraTrackId** | **String**| A custom identifier for tracing the API call. If you set a value for this header, Zuora returns the same value in the response headers. This header enables you to associate your system process identifiers with Zuora API calls, to assist with troubleshooting in the event of an issue.  The value of this field must use the US-ASCII character set and must not include any of the following characters: colon (&#x60;:&#x60;), semicolon (&#x60;;&#x60;), double quote (&#x60;\&quot;&#x60;), and quote (&#x60;&#39;&#x60;).  | [optional] |
| **zuoraEntityIds** | **String**| An entity ID. If you have [Zuora Multi-entity](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Multi-entity) enabled and the OAuth token is valid for more than one entity, you must use this header to specify which entity to perform the operation in. If the OAuth token is only valid for a single entity, or you do not have Zuora Multi-entity enabled, you do not need to set this header.  | [optional] |
| **zuoraOrgIds** | **String**| Comma separated IDs. If you have &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Central_Platform/Multi-Org\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Zuora Multi-Org&lt;/a&gt; enabled,  you can use this header to specify which orgs to perform the operation in. If you do not have Zuora Multi-Org enabled, you should not set this header.  The IDs must be a sub-set of the user&#39;s accessible orgs. If you specify an org that the user does not have access to, the operation fails.  If the header is not set, the operation is performed in scope of the user&#39;s accessible orgs.  | [optional] |

### Return type

[**PostOrderResponseType**](PostOrderResponseType.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** |  |  * Content-Encoding - This header is returned if you specify the &#x60;Accept-Encoding: gzip&#x60; request header and the response contains over 1000 bytes of data. Note that only the following MIME types support gzipped responses:   - &#x60;application/json&#x60;   - &#x60;application/xml&#x60;   - &#x60;text/html&#x60;   - &#x60;text/csv&#x60;   - &#x60;text/plain&#x60;  <br>  * RateLimit-Limit - The request limit quota for the time window closest to exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Remaining - The number of requests remaining in the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Reset - The number of seconds until the quota resets for the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Zuora-Request-Id - The Zuora internal identifier of the API call. You cannot control the value of this header.  <br>  * Zuora-Track-Id - A custom identifier for tracing the API call. If you specified a tracing identifier in the request headers, Zuora returns the same tracing identifier. Otherwise, Zuora does not set this header.  <br>  |

<a name="order_2"></a>
# **order_2**
> CommonResponse order_2(orderNumber).acceptEncoding(acceptEncoding).contentEncoding(contentEncoding).authorization(authorization).zuoraTrackId(zuoraTrackId).zuoraEntityIds(zuoraEntityIds).zuoraOrgIds(zuoraOrgIds).execute();

Delete an order

**Note:** This operation is only available if you have the [Orders](https://knowledgecenter.zuora.com/BC_Subscription_Management/Orders/AA_Overview_of_Orders#Orders) feature enabled. If you are an existing Zuora &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Subscriptions/Subscriptions/Subscribe_and_Amend\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Subscribe and Amend&lt;/a&gt; customer, we recommend you enable &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Subscriptions/Subscriptions/Orders_Harmonization/A_Overview_of_Orders_Harmonization\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Orders Harmonization&lt;/a&gt; to access the &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Subscriptions/Subscriptions/Orders/AA_Overview_of_Orders/A_Overview_of_Orders\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Orders&lt;/a&gt; feature. With Orders, you can access both existing functions for subscription and billing management and the &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Subscriptions/Subscriptions/Orders_Harmonization/P_FAQ_about_Orders_Harmonization#New+features+through+Orders\&quot; target&#x3D;\&quot;_blank\&quot;&gt;new features&lt;/a&gt; on Zuora Billing.  **Note:** The [Order Line Items](https://knowledgecenter.zuora.com/Billing/Subscriptions/Orders/Order_Line_Items/AA_Overview_of_Order_Line_Items) feature is now generally available to all Zuora customers. You need to enable the [Orders](https://knowledgecenter.zuora.com/BC_Subscription_Management/Orders/AA_Overview_of_Orders#Orders) feature to access the [Order Line Items](https://knowledgecenter.zuora.com/Billing/Subscriptions/Orders/Order_Line_Items/AA_Overview_of_Order_Line_Items) feature. As of Zuora Billing Release 313 (November 2021), new customers who onboard on [Orders](https://knowledgecenter.zuora.com/Billing/Subscriptions/Orders/AA_Overview_of_Orders) will have the [Order Line Items](https://knowledgecenter.zuora.com/Billing/Subscriptions/Orders/Order_Line_Items) feature enabled by default.          Deletes a specified order.   * All the subscriptions changed by this order are deleted. After the deletion, the subscriptions are rolled back to the previous version.   * All the order line items created in this order are deleted.  You are not allowed to delete an order if the charges that are affected by this order are invoiced. 

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Zuora;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.OrdersApi;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Example {
  public static void main(String[] args) {
    Configuration configuration = new Configuration();
    configuration.host = "https://rest.zuora.com";
    Zuora client = new Zuora(configuration);
    String orderNumber = "orderNumber_example"; // The number of the order to be deleted.
    String acceptEncoding = "acceptEncoding_example"; // Include the `Accept-Encoding: gzip` header to compress responses as a gzipped file. It can significantly reduce the bandwidth required for a response.   If specified, Zuora automatically compresses responses that contain over 1000 bytes of data, and the response contains a `Content-Encoding` header with the compression algorithm so that your client can decompress it. 
    String contentEncoding = "contentEncoding_example"; // Include the `Content-Encoding: gzip` header to compress a request. With this header specified, you should upload a gzipped file for the request payload instead of sending the JSON payload. 
    String authorization = "authorization_example"; // The value is in the `Bearer {token}` format where {token} is a valid OAuth token generated by calling [Create an OAuth token](https://developer.zuora.com/api-references/api/operation/createToken). 
    String zuoraTrackId = "zuoraTrackId_example"; // A custom identifier for tracing the API call. If you set a value for this header, Zuora returns the same value in the response headers. This header enables you to associate your system process identifiers with Zuora API calls, to assist with troubleshooting in the event of an issue.  The value of this field must use the US-ASCII character set and must not include any of the following characters: colon (`:`), semicolon (`;`), double quote (`\"`), and quote (`'`). 
    String zuoraEntityIds = "zuoraEntityIds_example"; // An entity ID. If you have [Zuora Multi-entity](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Multi-entity) enabled and the OAuth token is valid for more than one entity, you must use this header to specify which entity to perform the operation in. If the OAuth token is only valid for a single entity, or you do not have Zuora Multi-entity enabled, you do not need to set this header. 
    String zuoraOrgIds = "zuoraOrgIds_example"; // Comma separated IDs. If you have <a href=\"https://knowledgecenter.zuora.com/Zuora_Central_Platform/Multi-Org\" target=\"_blank\">Zuora Multi-Org</a> enabled,  you can use this header to specify which orgs to perform the operation in. If you do not have Zuora Multi-Org enabled, you should not set this header.  The IDs must be a sub-set of the user's accessible orgs. If you specify an org that the user does not have access to, the operation fails.  If the header is not set, the operation is performed in scope of the user's accessible orgs. 
    try {
      CommonResponse result = client
              .orders
              .order_2(orderNumber)
              .acceptEncoding(acceptEncoding)
              .contentEncoding(contentEncoding)
              .authorization(authorization)
              .zuoraTrackId(zuoraTrackId)
              .zuoraEntityIds(zuoraEntityIds)
              .zuoraOrgIds(zuoraOrgIds)
              .execute();
      System.out.println(result);
      System.out.println(result.getProcessId());
      System.out.println(result.getReasons());
      System.out.println(result.getRequestId());
      System.out.println(result.getSuccess());
    } catch (ApiException e) {
      System.err.println("Exception when calling OrdersApi#order_2");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<CommonResponse> response = client
              .orders
              .order_2(orderNumber)
              .acceptEncoding(acceptEncoding)
              .contentEncoding(contentEncoding)
              .authorization(authorization)
              .zuoraTrackId(zuoraTrackId)
              .zuoraEntityIds(zuoraEntityIds)
              .zuoraOrgIds(zuoraOrgIds)
              .executeWithHttpInfo();
      System.out.println(response.getResponseBody());
      System.out.println(response.getResponseHeaders());
      System.out.println(response.getStatusCode());
      System.out.println(response.getRoundTripTime());
      System.out.println(response.getRequest());
    } catch (ApiException e) {
      System.err.println("Exception when calling OrdersApi#order_2");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}

```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **orderNumber** | **String**| The number of the order to be deleted. | |
| **acceptEncoding** | **String**| Include the &#x60;Accept-Encoding: gzip&#x60; header to compress responses as a gzipped file. It can significantly reduce the bandwidth required for a response.   If specified, Zuora automatically compresses responses that contain over 1000 bytes of data, and the response contains a &#x60;Content-Encoding&#x60; header with the compression algorithm so that your client can decompress it.  | [optional] |
| **contentEncoding** | **String**| Include the &#x60;Content-Encoding: gzip&#x60; header to compress a request. With this header specified, you should upload a gzipped file for the request payload instead of sending the JSON payload.  | [optional] |
| **authorization** | **String**| The value is in the &#x60;Bearer {token}&#x60; format where {token} is a valid OAuth token generated by calling [Create an OAuth token](https://developer.zuora.com/api-references/api/operation/createToken).  | [optional] |
| **zuoraTrackId** | **String**| A custom identifier for tracing the API call. If you set a value for this header, Zuora returns the same value in the response headers. This header enables you to associate your system process identifiers with Zuora API calls, to assist with troubleshooting in the event of an issue.  The value of this field must use the US-ASCII character set and must not include any of the following characters: colon (&#x60;:&#x60;), semicolon (&#x60;;&#x60;), double quote (&#x60;\&quot;&#x60;), and quote (&#x60;&#39;&#x60;).  | [optional] |
| **zuoraEntityIds** | **String**| An entity ID. If you have [Zuora Multi-entity](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Multi-entity) enabled and the OAuth token is valid for more than one entity, you must use this header to specify which entity to perform the operation in. If the OAuth token is only valid for a single entity, or you do not have Zuora Multi-entity enabled, you do not need to set this header.  | [optional] |
| **zuoraOrgIds** | **String**| Comma separated IDs. If you have &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Central_Platform/Multi-Org\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Zuora Multi-Org&lt;/a&gt; enabled,  you can use this header to specify which orgs to perform the operation in. If you do not have Zuora Multi-Org enabled, you should not set this header.  The IDs must be a sub-set of the user&#39;s accessible orgs. If you specify an org that the user does not have access to, the operation fails.  If the header is not set, the operation is performed in scope of the user&#39;s accessible orgs.  | [optional] |

### Return type

[**CommonResponse**](CommonResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** |  |  * Content-Encoding - This header is returned if you specify the &#x60;Accept-Encoding: gzip&#x60; request header and the response contains over 1000 bytes of data. Note that only the following MIME types support gzipped responses:   - &#x60;application/json&#x60;   - &#x60;application/xml&#x60;   - &#x60;text/html&#x60;   - &#x60;text/csv&#x60;   - &#x60;text/plain&#x60;  <br>  * RateLimit-Limit - The request limit quota for the time window closest to exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Remaining - The number of requests remaining in the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Reset - The number of seconds until the quota resets for the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Zuora-Request-Id - The Zuora internal identifier of the API call. You cannot control the value of this header.  <br>  * Zuora-Track-Id - A custom identifier for tracing the API call. If you specified a tracing identifier in the request headers, Zuora returns the same tracing identifier. Otherwise, Zuora does not set this header.  <br>  |

<a name="ordersByInvoiceOwner"></a>
# **ordersByInvoiceOwner**
> GetOrdersResponse ordersByInvoiceOwner(accountNumber).acceptEncoding(acceptEncoding).contentEncoding(contentEncoding).authorization(authorization).zuoraTrackId(zuoraTrackId).zuoraEntityIds(zuoraEntityIds).zuoraOrgIds(zuoraOrgIds).page(page).pageSize(pageSize).dateFilterOption(dateFilterOption).startDate(startDate).endDate(endDate).status(status).execute();

List orders of an invoice owner

**Note:** This feature is only available if you have the [Order Metrics](https://knowledgecenter.zuora.com/BC_Subscription_Management/Orders/AA_Overview_of_Orders#Order_Metrics) feature enabled. As of Zuora Billing Release 284, Orders is generally available and the Order Metrics feature is no longer available as a standalone feature. If you are an existing Subscribe and Amend customer and want Order Metrics only, you must turn on [Orders Harmonization](https://knowledgecenter.zuora.com/Billing/Subscriptions/Orders/Orders_Harmonization/Orders_Harmonization). You can still keep the existing Subscribe and Amend API integrations to create and manage subscriptions.  **Note:** The [Order Line Items](https://knowledgecenter.zuora.com/Billing/Subscriptions/Orders/Order_Line_Items/AA_Overview_of_Order_Line_Items) feature is now generally available to all Zuora customers. You need to enable the [Orders](https://knowledgecenter.zuora.com/BC_Subscription_Management/Orders/AA_Overview_of_Orders#Orders) feature to access the [Order Line Items](https://knowledgecenter.zuora.com/Billing/Subscriptions/Orders/Order_Line_Items/AA_Overview_of_Order_Line_Items) feature. As of Zuora Billing Release 313 (November 2021), new customers who onboard on [Orders](https://knowledgecenter.zuora.com/Billing/Subscriptions/Orders/AA_Overview_of_Orders) will have the [Order Line Items](https://knowledgecenter.zuora.com/Billing/Subscriptions/Orders/Order_Line_Items) feature enabled by default.          Retrieves the detailed information about all orders for a specified invoice owner. You can set the &#x60;status&#x60; query parameter to an order status to retrieve orders in that order status. If you do not set a value for this query parameter, the query parameter has a default value &#x60;all&#x60;, and orders of all statuses are returned. 

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Zuora;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.OrdersApi;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Example {
  public static void main(String[] args) {
    Configuration configuration = new Configuration();
    configuration.host = "https://rest.zuora.com";
    Zuora client = new Zuora(configuration);
    String accountNumber = "accountNumber_example"; // The invoice owner account number.
    String acceptEncoding = "acceptEncoding_example"; // Include the `Accept-Encoding: gzip` header to compress responses as a gzipped file. It can significantly reduce the bandwidth required for a response.   If specified, Zuora automatically compresses responses that contain over 1000 bytes of data, and the response contains a `Content-Encoding` header with the compression algorithm so that your client can decompress it. 
    String contentEncoding = "contentEncoding_example"; // Include the `Content-Encoding: gzip` header to compress a request. With this header specified, you should upload a gzipped file for the request payload instead of sending the JSON payload. 
    String authorization = "authorization_example"; // The value is in the `Bearer {token}` format where {token} is a valid OAuth token generated by calling [Create an OAuth token](https://developer.zuora.com/api-references/api/operation/createToken). 
    String zuoraTrackId = "zuoraTrackId_example"; // A custom identifier for tracing the API call. If you set a value for this header, Zuora returns the same value in the response headers. This header enables you to associate your system process identifiers with Zuora API calls, to assist with troubleshooting in the event of an issue.  The value of this field must use the US-ASCII character set and must not include any of the following characters: colon (`:`), semicolon (`;`), double quote (`\"`), and quote (`'`). 
    String zuoraEntityIds = "zuoraEntityIds_example"; // An entity ID. If you have [Zuora Multi-entity](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Multi-entity) enabled and the OAuth token is valid for more than one entity, you must use this header to specify which entity to perform the operation in. If the OAuth token is only valid for a single entity, or you do not have Zuora Multi-entity enabled, you do not need to set this header. 
    String zuoraOrgIds = "zuoraOrgIds_example"; // Comma separated IDs. If you have <a href=\"https://knowledgecenter.zuora.com/Zuora_Central_Platform/Multi-Org\" target=\"_blank\">Zuora Multi-Org</a> enabled,  you can use this header to specify which orgs to perform the operation in. If you do not have Zuora Multi-Org enabled, you should not set this header.  The IDs must be a sub-set of the user's accessible orgs. If you specify an org that the user does not have access to, the operation fails.  If the header is not set, the operation is performed in scope of the user's accessible orgs. 
    Integer page = 1; // The index number of the page that you want to retrieve. This parameter is dependent on `pageSize`. You must set `pageSize` before specifying `page`. For example, if you set `pageSize` to `20` and `page` to `2`, the 21st to 40th records are returned in the response. 
    Integer pageSize = 20; // The number of records returned per page in the response. 
    String dateFilterOption = "dateFilterOption_example"; // The date type to filter on. This field value can be orderDate or updatedDate. Default is orderDate. 
    LocalDate startDate = LocalDate.now(); // The result will only contain the orders with the date of dateFilterOption later than or equal to this date. 
    LocalDate endDate = LocalDate.now(); // The result will only contain the orders with the date of dateFilterOption earlier than or equal to this date. 
    String status = "all"; // The status of orders.
    try {
      GetOrdersResponse result = client
              .orders
              .ordersByInvoiceOwner(accountNumber)
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
      System.out.println(result);
      System.out.println(result.getProcessId());
      System.out.println(result.getReasons());
      System.out.println(result.getRequestId());
      System.out.println(result.getSuccess());
      System.out.println(result.getNextPage());
      System.out.println(result.getOrders());
    } catch (ApiException e) {
      System.err.println("Exception when calling OrdersApi#ordersByInvoiceOwner");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<GetOrdersResponse> response = client
              .orders
              .ordersByInvoiceOwner(accountNumber)
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
              .executeWithHttpInfo();
      System.out.println(response.getResponseBody());
      System.out.println(response.getResponseHeaders());
      System.out.println(response.getStatusCode());
      System.out.println(response.getRoundTripTime());
      System.out.println(response.getRequest());
    } catch (ApiException e) {
      System.err.println("Exception when calling OrdersApi#ordersByInvoiceOwner");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}

```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **accountNumber** | **String**| The invoice owner account number. | |
| **acceptEncoding** | **String**| Include the &#x60;Accept-Encoding: gzip&#x60; header to compress responses as a gzipped file. It can significantly reduce the bandwidth required for a response.   If specified, Zuora automatically compresses responses that contain over 1000 bytes of data, and the response contains a &#x60;Content-Encoding&#x60; header with the compression algorithm so that your client can decompress it.  | [optional] |
| **contentEncoding** | **String**| Include the &#x60;Content-Encoding: gzip&#x60; header to compress a request. With this header specified, you should upload a gzipped file for the request payload instead of sending the JSON payload.  | [optional] |
| **authorization** | **String**| The value is in the &#x60;Bearer {token}&#x60; format where {token} is a valid OAuth token generated by calling [Create an OAuth token](https://developer.zuora.com/api-references/api/operation/createToken).  | [optional] |
| **zuoraTrackId** | **String**| A custom identifier for tracing the API call. If you set a value for this header, Zuora returns the same value in the response headers. This header enables you to associate your system process identifiers with Zuora API calls, to assist with troubleshooting in the event of an issue.  The value of this field must use the US-ASCII character set and must not include any of the following characters: colon (&#x60;:&#x60;), semicolon (&#x60;;&#x60;), double quote (&#x60;\&quot;&#x60;), and quote (&#x60;&#39;&#x60;).  | [optional] |
| **zuoraEntityIds** | **String**| An entity ID. If you have [Zuora Multi-entity](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Multi-entity) enabled and the OAuth token is valid for more than one entity, you must use this header to specify which entity to perform the operation in. If the OAuth token is only valid for a single entity, or you do not have Zuora Multi-entity enabled, you do not need to set this header.  | [optional] |
| **zuoraOrgIds** | **String**| Comma separated IDs. If you have &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Central_Platform/Multi-Org\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Zuora Multi-Org&lt;/a&gt; enabled,  you can use this header to specify which orgs to perform the operation in. If you do not have Zuora Multi-Org enabled, you should not set this header.  The IDs must be a sub-set of the user&#39;s accessible orgs. If you specify an org that the user does not have access to, the operation fails.  If the header is not set, the operation is performed in scope of the user&#39;s accessible orgs.  | [optional] |
| **page** | **Integer**| The index number of the page that you want to retrieve. This parameter is dependent on &#x60;pageSize&#x60;. You must set &#x60;pageSize&#x60; before specifying &#x60;page&#x60;. For example, if you set &#x60;pageSize&#x60; to &#x60;20&#x60; and &#x60;page&#x60; to &#x60;2&#x60;, the 21st to 40th records are returned in the response.  | [optional] [default to 1] |
| **pageSize** | **Integer**| The number of records returned per page in the response.  | [optional] [default to 20] |
| **dateFilterOption** | **String**| The date type to filter on. This field value can be orderDate or updatedDate. Default is orderDate.  | [optional] |
| **startDate** | **LocalDate**| The result will only contain the orders with the date of dateFilterOption later than or equal to this date.  | [optional] |
| **endDate** | **LocalDate**| The result will only contain the orders with the date of dateFilterOption earlier than or equal to this date.  | [optional] |
| **status** | **String**| The status of orders. | [optional] [enum: all, cancelled, completed, draft, executing, failed, pending, scheduled] |

### Return type

[**GetOrdersResponse**](GetOrdersResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** |  |  * Content-Encoding - This header is returned if you specify the &#x60;Accept-Encoding: gzip&#x60; request header and the response contains over 1000 bytes of data. Note that only the following MIME types support gzipped responses:   - &#x60;application/json&#x60;   - &#x60;application/xml&#x60;   - &#x60;text/html&#x60;   - &#x60;text/csv&#x60;   - &#x60;text/plain&#x60;  <br>  * RateLimit-Limit - The request limit quota for the time window closest to exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Remaining - The number of requests remaining in the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Reset - The number of seconds until the quota resets for the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Zuora-Request-Id - The Zuora internal identifier of the API call. You cannot control the value of this header.  <br>  * Zuora-Track-Id - A custom identifier for tracing the API call. If you specified a tracing identifier in the request headers, Zuora returns the same tracing identifier. Otherwise, Zuora does not set this header.  <br>  |

<a name="ordersBySubscriptionNumber"></a>
# **ordersBySubscriptionNumber**
> GetOrdersResponse ordersBySubscriptionNumber(subscriptionNumber).acceptEncoding(acceptEncoding).contentEncoding(contentEncoding).authorization(authorization).zuoraTrackId(zuoraTrackId).zuoraEntityIds(zuoraEntityIds).zuoraOrgIds(zuoraOrgIds).page(page).pageSize(pageSize).dateFilterOption(dateFilterOption).startDate(startDate).endDate(endDate).status(status).execute();

List orders by subscription number

**Note:** This feature is only available if you have the [Order Metrics](https://knowledgecenter.zuora.com/BC_Subscription_Management/Orders/AA_Overview_of_Orders#Order_Metrics) feature enabled. As of Zuora Billing Release 284, Orders is generally available and the Order Metrics feature is no longer available as a standalone feature. If you are an existing Subscribe and Amend customer and want Order Metrics only, you must turn on [Orders Harmonization](https://knowledgecenter.zuora.com/Billing/Subscriptions/Orders/Orders_Harmonization/Orders_Harmonization). You can still keep the existing Subscribe and Amend API integrations to create and manage subscriptions.  **Note:** The [Order Line Items](https://knowledgecenter.zuora.com/Billing/Subscriptions/Orders/Order_Line_Items/AA_Overview_of_Order_Line_Items) feature is now generally available to all Zuora customers. You need to enable the [Orders](https://knowledgecenter.zuora.com/BC_Subscription_Management/Orders/AA_Overview_of_Orders#Orders) feature to access the [Order Line Items](https://knowledgecenter.zuora.com/Billing/Subscriptions/Orders/Order_Line_Items/AA_Overview_of_Order_Line_Items) feature. As of Zuora Billing Release 313 (November 2021), new customers who onboard on [Orders](https://knowledgecenter.zuora.com/Billing/Subscriptions/Orders/AA_Overview_of_Orders) will have the [Order Line Items](https://knowledgecenter.zuora.com/Billing/Subscriptions/Orders/Order_Line_Items) feature enabled by default.   Retrieves the detailed information about all orders for a specified subscription. You can set the &#x60;status&#x60; query parameter to an order status to retrieve orders in that order status. If you do not set a value for this query parameter, the query parameter has a default value &#x60;all&#x60;, and orders of all statuses are returned. 

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Zuora;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.OrdersApi;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Example {
  public static void main(String[] args) {
    Configuration configuration = new Configuration();
    configuration.host = "https://rest.zuora.com";
    Zuora client = new Zuora(configuration);
    String subscriptionNumber = "subscriptionNumber_example"; // The subscription number.
    String acceptEncoding = "acceptEncoding_example"; // Include the `Accept-Encoding: gzip` header to compress responses as a gzipped file. It can significantly reduce the bandwidth required for a response.   If specified, Zuora automatically compresses responses that contain over 1000 bytes of data, and the response contains a `Content-Encoding` header with the compression algorithm so that your client can decompress it. 
    String contentEncoding = "contentEncoding_example"; // Include the `Content-Encoding: gzip` header to compress a request. With this header specified, you should upload a gzipped file for the request payload instead of sending the JSON payload. 
    String authorization = "authorization_example"; // The value is in the `Bearer {token}` format where {token} is a valid OAuth token generated by calling [Create an OAuth token](https://developer.zuora.com/api-references/api/operation/createToken). 
    String zuoraTrackId = "zuoraTrackId_example"; // A custom identifier for tracing the API call. If you set a value for this header, Zuora returns the same value in the response headers. This header enables you to associate your system process identifiers with Zuora API calls, to assist with troubleshooting in the event of an issue.  The value of this field must use the US-ASCII character set and must not include any of the following characters: colon (`:`), semicolon (`;`), double quote (`\"`), and quote (`'`). 
    String zuoraEntityIds = "zuoraEntityIds_example"; // An entity ID. If you have [Zuora Multi-entity](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Multi-entity) enabled and the OAuth token is valid for more than one entity, you must use this header to specify which entity to perform the operation in. If the OAuth token is only valid for a single entity, or you do not have Zuora Multi-entity enabled, you do not need to set this header. 
    String zuoraOrgIds = "zuoraOrgIds_example"; // Comma separated IDs. If you have <a href=\"https://knowledgecenter.zuora.com/Zuora_Central_Platform/Multi-Org\" target=\"_blank\">Zuora Multi-Org</a> enabled,  you can use this header to specify which orgs to perform the operation in. If you do not have Zuora Multi-Org enabled, you should not set this header.  The IDs must be a sub-set of the user's accessible orgs. If you specify an org that the user does not have access to, the operation fails.  If the header is not set, the operation is performed in scope of the user's accessible orgs. 
    Integer page = 1; // The index number of the page that you want to retrieve. This parameter is dependent on `pageSize`. You must set `pageSize` before specifying `page`. For example, if you set `pageSize` to `20` and `page` to `2`, the 21st to 40th records are returned in the response. 
    Integer pageSize = 20; // The number of records returned per page in the response. 
    String dateFilterOption = "dateFilterOption_example"; // The date type to filter on. This field value can be 'orderDate' or 'updatedDate'. Default is orderDate. 
    LocalDate startDate = LocalDate.now(); // The result will only contain the orders with the date of 'dateFilterOption' later than or equal to this date. 
    LocalDate endDate = LocalDate.now(); // The result will only contain the orders with the date of 'dateFilterOption' earlier than or equal to this date. 
    String status = "all"; // The status of orders.
    try {
      GetOrdersResponse result = client
              .orders
              .ordersBySubscriptionNumber(subscriptionNumber)
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
      System.out.println(result);
      System.out.println(result.getProcessId());
      System.out.println(result.getReasons());
      System.out.println(result.getRequestId());
      System.out.println(result.getSuccess());
      System.out.println(result.getNextPage());
      System.out.println(result.getOrders());
    } catch (ApiException e) {
      System.err.println("Exception when calling OrdersApi#ordersBySubscriptionNumber");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<GetOrdersResponse> response = client
              .orders
              .ordersBySubscriptionNumber(subscriptionNumber)
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
              .executeWithHttpInfo();
      System.out.println(response.getResponseBody());
      System.out.println(response.getResponseHeaders());
      System.out.println(response.getStatusCode());
      System.out.println(response.getRoundTripTime());
      System.out.println(response.getRequest());
    } catch (ApiException e) {
      System.err.println("Exception when calling OrdersApi#ordersBySubscriptionNumber");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}

```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **subscriptionNumber** | **String**| The subscription number. | |
| **acceptEncoding** | **String**| Include the &#x60;Accept-Encoding: gzip&#x60; header to compress responses as a gzipped file. It can significantly reduce the bandwidth required for a response.   If specified, Zuora automatically compresses responses that contain over 1000 bytes of data, and the response contains a &#x60;Content-Encoding&#x60; header with the compression algorithm so that your client can decompress it.  | [optional] |
| **contentEncoding** | **String**| Include the &#x60;Content-Encoding: gzip&#x60; header to compress a request. With this header specified, you should upload a gzipped file for the request payload instead of sending the JSON payload.  | [optional] |
| **authorization** | **String**| The value is in the &#x60;Bearer {token}&#x60; format where {token} is a valid OAuth token generated by calling [Create an OAuth token](https://developer.zuora.com/api-references/api/operation/createToken).  | [optional] |
| **zuoraTrackId** | **String**| A custom identifier for tracing the API call. If you set a value for this header, Zuora returns the same value in the response headers. This header enables you to associate your system process identifiers with Zuora API calls, to assist with troubleshooting in the event of an issue.  The value of this field must use the US-ASCII character set and must not include any of the following characters: colon (&#x60;:&#x60;), semicolon (&#x60;;&#x60;), double quote (&#x60;\&quot;&#x60;), and quote (&#x60;&#39;&#x60;).  | [optional] |
| **zuoraEntityIds** | **String**| An entity ID. If you have [Zuora Multi-entity](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Multi-entity) enabled and the OAuth token is valid for more than one entity, you must use this header to specify which entity to perform the operation in. If the OAuth token is only valid for a single entity, or you do not have Zuora Multi-entity enabled, you do not need to set this header.  | [optional] |
| **zuoraOrgIds** | **String**| Comma separated IDs. If you have &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Central_Platform/Multi-Org\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Zuora Multi-Org&lt;/a&gt; enabled,  you can use this header to specify which orgs to perform the operation in. If you do not have Zuora Multi-Org enabled, you should not set this header.  The IDs must be a sub-set of the user&#39;s accessible orgs. If you specify an org that the user does not have access to, the operation fails.  If the header is not set, the operation is performed in scope of the user&#39;s accessible orgs.  | [optional] |
| **page** | **Integer**| The index number of the page that you want to retrieve. This parameter is dependent on &#x60;pageSize&#x60;. You must set &#x60;pageSize&#x60; before specifying &#x60;page&#x60;. For example, if you set &#x60;pageSize&#x60; to &#x60;20&#x60; and &#x60;page&#x60; to &#x60;2&#x60;, the 21st to 40th records are returned in the response.  | [optional] [default to 1] |
| **pageSize** | **Integer**| The number of records returned per page in the response.  | [optional] [default to 20] |
| **dateFilterOption** | **String**| The date type to filter on. This field value can be &#39;orderDate&#39; or &#39;updatedDate&#39;. Default is orderDate.  | [optional] |
| **startDate** | **LocalDate**| The result will only contain the orders with the date of &#39;dateFilterOption&#39; later than or equal to this date.  | [optional] |
| **endDate** | **LocalDate**| The result will only contain the orders with the date of &#39;dateFilterOption&#39; earlier than or equal to this date.  | [optional] |
| **status** | **String**| The status of orders. | [optional] [enum: all, cancelled, completed, draft, executing, failed, pending, scheduled] |

### Return type

[**GetOrdersResponse**](GetOrdersResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** |  |  * Content-Encoding - This header is returned if you specify the &#x60;Accept-Encoding: gzip&#x60; request header and the response contains over 1000 bytes of data. Note that only the following MIME types support gzipped responses:   - &#x60;application/json&#x60;   - &#x60;application/xml&#x60;   - &#x60;text/html&#x60;   - &#x60;text/csv&#x60;   - &#x60;text/plain&#x60;  <br>  * RateLimit-Limit - The request limit quota for the time window closest to exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Remaining - The number of requests remaining in the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Reset - The number of seconds until the quota resets for the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Zuora-Request-Id - The Zuora internal identifier of the API call. You cannot control the value of this header.  <br>  * Zuora-Track-Id - A custom identifier for tracing the API call. If you specified a tracing identifier in the request headers, Zuora returns the same tracing identifier. Otherwise, Zuora does not set this header.  <br>  |

<a name="ordersBySubscriptionOwner"></a>
# **ordersBySubscriptionOwner**
> GetOrdersResponse ordersBySubscriptionOwner(accountNumber).acceptEncoding(acceptEncoding).contentEncoding(contentEncoding).authorization(authorization).zuoraTrackId(zuoraTrackId).zuoraEntityIds(zuoraEntityIds).zuoraOrgIds(zuoraOrgIds).page(page).pageSize(pageSize).dateFilterOption(dateFilterOption).startDate(startDate).endDate(endDate).execute();

List orders of a subscription owner

**Note:** This feature is only available if you have the [Order Metrics](https://knowledgecenter.zuora.com/BC_Subscription_Management/Orders/AA_Overview_of_Orders#Order_Metrics) feature enabled. As of Zuora Billing Release 284, Orders is generally available and the Order Metrics feature is no longer available as a standalone feature. If you are an existing Subscribe and Amend customer and want Order Metrics only, you must turn on [Orders Harmonization](https://knowledgecenter.zuora.com/Billing/Subscriptions/Orders/Orders_Harmonization/Orders_Harmonization). You can still keep the existing Subscribe and Amend API integrations to create and manage subscriptions.  **Note:** The [Order Line Items](https://knowledgecenter.zuora.com/Billing/Subscriptions/Orders/Order_Line_Items/AA_Overview_of_Order_Line_Items) feature is now generally available to all Zuora customers. You need to enable the [Orders](https://knowledgecenter.zuora.com/BC_Subscription_Management/Orders/AA_Overview_of_Orders#Orders) feature to access the [Order Line Items](https://knowledgecenter.zuora.com/Billing/Subscriptions/Orders/Order_Line_Items/AA_Overview_of_Order_Line_Items) feature. As of Zuora Billing Release 313 (November 2021), new customers who onboard on [Orders](https://knowledgecenter.zuora.com/Billing/Subscriptions/Orders/AA_Overview_of_Orders) will have the [Order Line Items](https://knowledgecenter.zuora.com/Billing/Subscriptions/Orders/Order_Line_Items) feature enabled by default.          Retrieves the detailed information about all orders for a specified subscription owner. Any orders containing the changes on the subscriptions owned by this account are returned.  **Note**: You cannot retrieve detailed information about draft orders or scheduled orders through this operation. 

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Zuora;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.OrdersApi;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Example {
  public static void main(String[] args) {
    Configuration configuration = new Configuration();
    configuration.host = "https://rest.zuora.com";
    Zuora client = new Zuora(configuration);
    String accountNumber = "accountNumber_example"; // The subscription owner account number.
    String acceptEncoding = "acceptEncoding_example"; // Include the `Accept-Encoding: gzip` header to compress responses as a gzipped file. It can significantly reduce the bandwidth required for a response.   If specified, Zuora automatically compresses responses that contain over 1000 bytes of data, and the response contains a `Content-Encoding` header with the compression algorithm so that your client can decompress it. 
    String contentEncoding = "contentEncoding_example"; // Include the `Content-Encoding: gzip` header to compress a request. With this header specified, you should upload a gzipped file for the request payload instead of sending the JSON payload. 
    String authorization = "authorization_example"; // The value is in the `Bearer {token}` format where {token} is a valid OAuth token generated by calling [Create an OAuth token](https://developer.zuora.com/api-references/api/operation/createToken). 
    String zuoraTrackId = "zuoraTrackId_example"; // A custom identifier for tracing the API call. If you set a value for this header, Zuora returns the same value in the response headers. This header enables you to associate your system process identifiers with Zuora API calls, to assist with troubleshooting in the event of an issue.  The value of this field must use the US-ASCII character set and must not include any of the following characters: colon (`:`), semicolon (`;`), double quote (`\"`), and quote (`'`). 
    String zuoraEntityIds = "zuoraEntityIds_example"; // An entity ID. If you have [Zuora Multi-entity](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Multi-entity) enabled and the OAuth token is valid for more than one entity, you must use this header to specify which entity to perform the operation in. If the OAuth token is only valid for a single entity, or you do not have Zuora Multi-entity enabled, you do not need to set this header. 
    String zuoraOrgIds = "zuoraOrgIds_example"; // Comma separated IDs. If you have <a href=\"https://knowledgecenter.zuora.com/Zuora_Central_Platform/Multi-Org\" target=\"_blank\">Zuora Multi-Org</a> enabled,  you can use this header to specify which orgs to perform the operation in. If you do not have Zuora Multi-Org enabled, you should not set this header.  The IDs must be a sub-set of the user's accessible orgs. If you specify an org that the user does not have access to, the operation fails.  If the header is not set, the operation is performed in scope of the user's accessible orgs. 
    Integer page = 1; // The index number of the page that you want to retrieve. This parameter is dependent on `pageSize`. You must set `pageSize` before specifying `page`. For example, if you set `pageSize` to `20` and `page` to `2`, the 21st to 40th records are returned in the response. 
    Integer pageSize = 20; // The number of records returned per page in the response. 
    String dateFilterOption = "dateFilterOption_example"; // The date type to filter on. This field value can be 'orderDate' or 'updatedDate'. Default is orderDate. 
    LocalDate startDate = LocalDate.now(); // The result will only contain the orders with the date of 'dateFilterOption' later than or equal to this date. 
    LocalDate endDate = LocalDate.now(); // The result will only contain the orders with the date of 'dateFilterOption' earlier than or equal to this date. 
    try {
      GetOrdersResponse result = client
              .orders
              .ordersBySubscriptionOwner(accountNumber)
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
      System.out.println(result);
      System.out.println(result.getProcessId());
      System.out.println(result.getReasons());
      System.out.println(result.getRequestId());
      System.out.println(result.getSuccess());
      System.out.println(result.getNextPage());
      System.out.println(result.getOrders());
    } catch (ApiException e) {
      System.err.println("Exception when calling OrdersApi#ordersBySubscriptionOwner");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<GetOrdersResponse> response = client
              .orders
              .ordersBySubscriptionOwner(accountNumber)
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
              .executeWithHttpInfo();
      System.out.println(response.getResponseBody());
      System.out.println(response.getResponseHeaders());
      System.out.println(response.getStatusCode());
      System.out.println(response.getRoundTripTime());
      System.out.println(response.getRequest());
    } catch (ApiException e) {
      System.err.println("Exception when calling OrdersApi#ordersBySubscriptionOwner");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}

```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **accountNumber** | **String**| The subscription owner account number. | |
| **acceptEncoding** | **String**| Include the &#x60;Accept-Encoding: gzip&#x60; header to compress responses as a gzipped file. It can significantly reduce the bandwidth required for a response.   If specified, Zuora automatically compresses responses that contain over 1000 bytes of data, and the response contains a &#x60;Content-Encoding&#x60; header with the compression algorithm so that your client can decompress it.  | [optional] |
| **contentEncoding** | **String**| Include the &#x60;Content-Encoding: gzip&#x60; header to compress a request. With this header specified, you should upload a gzipped file for the request payload instead of sending the JSON payload.  | [optional] |
| **authorization** | **String**| The value is in the &#x60;Bearer {token}&#x60; format where {token} is a valid OAuth token generated by calling [Create an OAuth token](https://developer.zuora.com/api-references/api/operation/createToken).  | [optional] |
| **zuoraTrackId** | **String**| A custom identifier for tracing the API call. If you set a value for this header, Zuora returns the same value in the response headers. This header enables you to associate your system process identifiers with Zuora API calls, to assist with troubleshooting in the event of an issue.  The value of this field must use the US-ASCII character set and must not include any of the following characters: colon (&#x60;:&#x60;), semicolon (&#x60;;&#x60;), double quote (&#x60;\&quot;&#x60;), and quote (&#x60;&#39;&#x60;).  | [optional] |
| **zuoraEntityIds** | **String**| An entity ID. If you have [Zuora Multi-entity](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Multi-entity) enabled and the OAuth token is valid for more than one entity, you must use this header to specify which entity to perform the operation in. If the OAuth token is only valid for a single entity, or you do not have Zuora Multi-entity enabled, you do not need to set this header.  | [optional] |
| **zuoraOrgIds** | **String**| Comma separated IDs. If you have &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Central_Platform/Multi-Org\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Zuora Multi-Org&lt;/a&gt; enabled,  you can use this header to specify which orgs to perform the operation in. If you do not have Zuora Multi-Org enabled, you should not set this header.  The IDs must be a sub-set of the user&#39;s accessible orgs. If you specify an org that the user does not have access to, the operation fails.  If the header is not set, the operation is performed in scope of the user&#39;s accessible orgs.  | [optional] |
| **page** | **Integer**| The index number of the page that you want to retrieve. This parameter is dependent on &#x60;pageSize&#x60;. You must set &#x60;pageSize&#x60; before specifying &#x60;page&#x60;. For example, if you set &#x60;pageSize&#x60; to &#x60;20&#x60; and &#x60;page&#x60; to &#x60;2&#x60;, the 21st to 40th records are returned in the response.  | [optional] [default to 1] |
| **pageSize** | **Integer**| The number of records returned per page in the response.  | [optional] [default to 20] |
| **dateFilterOption** | **String**| The date type to filter on. This field value can be &#39;orderDate&#39; or &#39;updatedDate&#39;. Default is orderDate.  | [optional] |
| **startDate** | **LocalDate**| The result will only contain the orders with the date of &#39;dateFilterOption&#39; later than or equal to this date.  | [optional] |
| **endDate** | **LocalDate**| The result will only contain the orders with the date of &#39;dateFilterOption&#39; earlier than or equal to this date.  | [optional] |

### Return type

[**GetOrdersResponse**](GetOrdersResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** |  |  * Content-Encoding - This header is returned if you specify the &#x60;Accept-Encoding: gzip&#x60; request header and the response contains over 1000 bytes of data. Note that only the following MIME types support gzipped responses:   - &#x60;application/json&#x60;   - &#x60;application/xml&#x60;   - &#x60;text/html&#x60;   - &#x60;text/csv&#x60;   - &#x60;text/plain&#x60;  <br>  * RateLimit-Limit - The request limit quota for the time window closest to exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Remaining - The number of requests remaining in the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Reset - The number of seconds until the quota resets for the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Zuora-Request-Id - The Zuora internal identifier of the API call. You cannot control the value of this header.  <br>  * Zuora-Track-Id - A custom identifier for tracing the API call. If you specified a tracing identifier in the request headers, Zuora returns the same tracing identifier. Otherwise, Zuora does not set this header.  <br>  |

<a name="pendingOrdersBySubscriptionNumber"></a>
# **pendingOrdersBySubscriptionNumber**
> GetAllOrdersResponseType pendingOrdersBySubscriptionNumber(subscriptionKey).acceptEncoding(acceptEncoding).contentEncoding(contentEncoding).authorization(authorization).zuoraTrackId(zuoraTrackId).zuoraEntityIds(zuoraEntityIds).zuoraOrgIds(zuoraOrgIds).execute();

List pending orders by subscription number

**Note:** This feature is only available if you have the [Order Metrics](https://knowledgecenter.zuora.com/BC_Subscription_Management/Orders/AA_Overview_of_Orders#Order_Metrics) feature enabled. As of Zuora Billing Release 284, Orders is generally available and the Order Metrics feature is no longer available as a standalone feature. If you are an existing Subscribe and Amend customer and want Order Metrics only, you must turn on [Orders Harmonization](https://knowledgecenter.zuora.com/Billing/Subscriptions/Orders/Orders_Harmonization/Orders_Harmonization). You can still keep the existing Subscribe and Amend API integrations to create and manage subscriptions.  **Note:** The [Order Line Items](https://knowledgecenter.zuora.com/Billing/Subscriptions/Orders/Order_Line_Items/AA_Overview_of_Order_Line_Items) feature is now generally available to all Zuora customers. You need to enable the [Orders](https://knowledgecenter.zuora.com/BC_Subscription_Management/Orders/AA_Overview_of_Orders#Orders) feature to access the [Order Line Items](https://knowledgecenter.zuora.com/Billing/Subscriptions/Orders/Order_Line_Items/AA_Overview_of_Order_Line_Items) feature. As of Zuora Billing Release 313 (November 2021), new customers who onboard on [Orders](https://knowledgecenter.zuora.com/Billing/Subscriptions/Orders/AA_Overview_of_Orders) will have the [Order Line Items](https://knowledgecenter.zuora.com/Billing/Subscriptions/Orders/Order_Line_Items) feature enabled by default.   Retrieves the detailed information about all pending orders for a specified subscription. 

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Zuora;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.OrdersApi;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Example {
  public static void main(String[] args) {
    Configuration configuration = new Configuration();
    configuration.host = "https://rest.zuora.com";
    Zuora client = new Zuora(configuration);
    String subscriptionKey = "subscriptionKey_example"; // Subscription number. For example, A-S00000135. 
    String acceptEncoding = "acceptEncoding_example"; // Include the `Accept-Encoding: gzip` header to compress responses as a gzipped file. It can significantly reduce the bandwidth required for a response.   If specified, Zuora automatically compresses responses that contain over 1000 bytes of data, and the response contains a `Content-Encoding` header with the compression algorithm so that your client can decompress it. 
    String contentEncoding = "contentEncoding_example"; // Include the `Content-Encoding: gzip` header to compress a request. With this header specified, you should upload a gzipped file for the request payload instead of sending the JSON payload. 
    String authorization = "authorization_example"; // The value is in the `Bearer {token}` format where {token} is a valid OAuth token generated by calling [Create an OAuth token](https://developer.zuora.com/api-references/api/operation/createToken). 
    String zuoraTrackId = "zuoraTrackId_example"; // A custom identifier for tracing the API call. If you set a value for this header, Zuora returns the same value in the response headers. This header enables you to associate your system process identifiers with Zuora API calls, to assist with troubleshooting in the event of an issue.  The value of this field must use the US-ASCII character set and must not include any of the following characters: colon (`:`), semicolon (`;`), double quote (`\"`), and quote (`'`). 
    String zuoraEntityIds = "zuoraEntityIds_example"; // An entity ID. If you have [Zuora Multi-entity](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Multi-entity) enabled and the OAuth token is valid for more than one entity, you must use this header to specify which entity to perform the operation in. If the OAuth token is only valid for a single entity, or you do not have Zuora Multi-entity enabled, you do not need to set this header. 
    String zuoraOrgIds = "zuoraOrgIds_example"; // Comma separated IDs. If you have <a href=\"https://knowledgecenter.zuora.com/Zuora_Central_Platform/Multi-Org\" target=\"_blank\">Zuora Multi-Org</a> enabled,  you can use this header to specify which orgs to perform the operation in. If you do not have Zuora Multi-Org enabled, you should not set this header.  The IDs must be a sub-set of the user's accessible orgs. If you specify an org that the user does not have access to, the operation fails.  If the header is not set, the operation is performed in scope of the user's accessible orgs. 
    try {
      GetAllOrdersResponseType result = client
              .orders
              .pendingOrdersBySubscriptionNumber(subscriptionKey)
              .acceptEncoding(acceptEncoding)
              .contentEncoding(contentEncoding)
              .authorization(authorization)
              .zuoraTrackId(zuoraTrackId)
              .zuoraEntityIds(zuoraEntityIds)
              .zuoraOrgIds(zuoraOrgIds)
              .execute();
      System.out.println(result);
      System.out.println(result.getNextPage());
      System.out.println(result.getOrders());
      System.out.println(result.getSuccess());
    } catch (ApiException e) {
      System.err.println("Exception when calling OrdersApi#pendingOrdersBySubscriptionNumber");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<GetAllOrdersResponseType> response = client
              .orders
              .pendingOrdersBySubscriptionNumber(subscriptionKey)
              .acceptEncoding(acceptEncoding)
              .contentEncoding(contentEncoding)
              .authorization(authorization)
              .zuoraTrackId(zuoraTrackId)
              .zuoraEntityIds(zuoraEntityIds)
              .zuoraOrgIds(zuoraOrgIds)
              .executeWithHttpInfo();
      System.out.println(response.getResponseBody());
      System.out.println(response.getResponseHeaders());
      System.out.println(response.getStatusCode());
      System.out.println(response.getRoundTripTime());
      System.out.println(response.getRequest());
    } catch (ApiException e) {
      System.err.println("Exception when calling OrdersApi#pendingOrdersBySubscriptionNumber");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}

```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **subscriptionKey** | **String**| Subscription number. For example, A-S00000135.  | |
| **acceptEncoding** | **String**| Include the &#x60;Accept-Encoding: gzip&#x60; header to compress responses as a gzipped file. It can significantly reduce the bandwidth required for a response.   If specified, Zuora automatically compresses responses that contain over 1000 bytes of data, and the response contains a &#x60;Content-Encoding&#x60; header with the compression algorithm so that your client can decompress it.  | [optional] |
| **contentEncoding** | **String**| Include the &#x60;Content-Encoding: gzip&#x60; header to compress a request. With this header specified, you should upload a gzipped file for the request payload instead of sending the JSON payload.  | [optional] |
| **authorization** | **String**| The value is in the &#x60;Bearer {token}&#x60; format where {token} is a valid OAuth token generated by calling [Create an OAuth token](https://developer.zuora.com/api-references/api/operation/createToken).  | [optional] |
| **zuoraTrackId** | **String**| A custom identifier for tracing the API call. If you set a value for this header, Zuora returns the same value in the response headers. This header enables you to associate your system process identifiers with Zuora API calls, to assist with troubleshooting in the event of an issue.  The value of this field must use the US-ASCII character set and must not include any of the following characters: colon (&#x60;:&#x60;), semicolon (&#x60;;&#x60;), double quote (&#x60;\&quot;&#x60;), and quote (&#x60;&#39;&#x60;).  | [optional] |
| **zuoraEntityIds** | **String**| An entity ID. If you have [Zuora Multi-entity](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Multi-entity) enabled and the OAuth token is valid for more than one entity, you must use this header to specify which entity to perform the operation in. If the OAuth token is only valid for a single entity, or you do not have Zuora Multi-entity enabled, you do not need to set this header.  | [optional] |
| **zuoraOrgIds** | **String**| Comma separated IDs. If you have &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Central_Platform/Multi-Org\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Zuora Multi-Org&lt;/a&gt; enabled,  you can use this header to specify which orgs to perform the operation in. If you do not have Zuora Multi-Org enabled, you should not set this header.  The IDs must be a sub-set of the user&#39;s accessible orgs. If you specify an org that the user does not have access to, the operation fails.  If the header is not set, the operation is performed in scope of the user&#39;s accessible orgs.  | [optional] |

### Return type

[**GetAllOrdersResponseType**](GetAllOrdersResponseType.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** |  |  * Content-Encoding - This header is returned if you specify the &#x60;Accept-Encoding: gzip&#x60; request header and the response contains over 1000 bytes of data. Note that only the following MIME types support gzipped responses:   - &#x60;application/json&#x60;   - &#x60;application/xml&#x60;   - &#x60;text/html&#x60;   - &#x60;text/csv&#x60;   - &#x60;text/plain&#x60;  <br>  * RateLimit-Limit - The request limit quota for the time window closest to exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Remaining - The number of requests remaining in the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Reset - The number of seconds until the quota resets for the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Zuora-Request-Id - The Zuora internal identifier of the API call. You cannot control the value of this header.  <br>  * Zuora-Track-Id - A custom identifier for tracing the API call. If you specified a tracing identifier in the request headers, Zuora returns the same tracing identifier. Otherwise, Zuora does not set this header.  <br>  |

<a name="previewOrder"></a>
# **previewOrder**
> PostOrderPreviewResponseType previewOrder(poSTOrderPreviewRequestType).idempotencyKey(idempotencyKey).acceptEncoding(acceptEncoding).contentEncoding(contentEncoding).authorization(authorization).zuoraTrackId(zuoraTrackId).zuoraEntityIds(zuoraEntityIds).zuoraOrgIds(zuoraOrgIds).execute();

Preview an order

**Notes**:   - This operation is only available if you have the [Orders](https://knowledgecenter.zuora.com/BC_Subscription_Management/Orders/AA_Overview_of_Orders#Orders) feature enabled. If you are an existing Zuora &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Subscriptions/Subscriptions/Subscribe_and_Amend\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Subscribe and Amend&lt;/a&gt; customer, we recommend you enable &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Subscriptions/Subscriptions/Orders_Harmonization/A_Overview_of_Orders_Harmonization\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Orders Harmonization&lt;/a&gt; to access the &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Subscriptions/Subscriptions/Orders/AA_Overview_of_Orders/A_Overview_of_Orders\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Orders&lt;/a&gt; feature. With Orders, you can access both existing functions for subscription and billing management and the &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Subscriptions/Subscriptions/Orders_Harmonization/P_FAQ_about_Orders_Harmonization#New+features+through+Orders\&quot; target&#x3D;\&quot;_blank\&quot;&gt;new features&lt;/a&gt; on Zuora Billing.   - The [Order Line Items](https://knowledgecenter.zuora.com/Billing/Subscriptions/Orders/Order_Line_Items/AA_Overview_of_Order_Line_Items) feature is now generally available to all Zuora customers. You need to enable the [Orders](https://knowledgecenter.zuora.com/BC_Subscription_Management/Orders/AA_Overview_of_Orders#Orders) feature to access the [Order Line Items](https://knowledgecenter.zuora.com/Billing/Subscriptions/Orders/Order_Line_Items/AA_Overview_of_Order_Line_Items) feature. As of Zuora Billing Release 313 (November 2021), new customers who onboard on [Orders](https://knowledgecenter.zuora.com/Billing/Subscriptions/Orders/AA_Overview_of_Orders) will have the [Order Line Items](https://knowledgecenter.zuora.com/Billing/Subscriptions/Orders/Order_Line_Items) feature enabled by default.     - You cannot preview enhanced discounts.        Retrieves the preview of the charge metrics and invoice items of a specified order. Preview for subscriptions and order line items are both supported. This operation is only an order preview and no order is created.    You can also use this operation to preview billing for a standalone order. For more information, see &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Manage_subscription_transactions/Orders/Standalone_Orders/Preview_billing_for_a_standalone_order\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Preview billing for a standalone order&lt;/a&gt;. The &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Manage_subscription_transactions/Orders/Standalone_Orders/AA_Overview_of_Standalone_Orders\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Standalone Orders&lt;/a&gt; feature is in the **Early Adopter** phase. We are actively soliciting feedback from a small set of early adopters before releasing it as generally available. If you want to join this early adopter program, submit a request at [Zuora Global Support](https://support.zuora.com).  #### Billing preview behavior regarding draft invoices By default, the billing preview behavior regarding draft invoices is as below: * When you preview billing for your order and the order contains subscriptions only, the draft invoices are excluded. * When you preview billing for your order and the order contains order line items only, the draft invoices are included. * When you preview billing for an order that contains both subscriptions  order line items, the draft invoices are included for both subscriptions and order line items.  However, if you want to always exclude the draft invoices in billing preview, submit a request at [Zuora Global Support](https://support.zuora.com).  #### Limits on Orders API The limit of orders allowed on a subscription is 1000.  The limit of order line items allowed in an order is 100.  Zuora has the following limits on the Orders synchronous API to prevent performance degradation:  * Up to 50 subscriptions are allowed in a single [Create an order](https://developer.zuora.com/api-references/api/operation/POST_Order) or [Preview an order](https://developer.zuora.com/api-references/api/operation/POST_PreviewOrder) operation call. * Up to 50 order actions are allowed in a single [Create an order](https://developer.zuora.com/api-references/api/operation/POST_Order) or [Preview an order](https://developer.zuora.com/api-references/api/operation/POST_PreviewOrder) operation call. * Up to 50 order actions are allowed on a single subscription in a [Create an order](https://developer.zuora.com/api-references/api/operation/POST_Order) or [Preview an order](https://developer.zuora.com/api-references/api/operation/POST_PreviewOrder) operation call.  If you have an Order that exceeds any limits of the above, Zuora recommends you use the following asynchronous API operations: * [Create an order asynchronously](https://developer.zuora.com/api-references/api/operation/POST_CreateOrderAsynchronously) * [Preview an order asynchronously](https://developer.zuora.com/api-references/api/operation/POST_PreviewOrderAsynchronously) * [Retrieve the status and response of a job](https://developer.zuora.com/api-references/api/operation/GET_JobStatusAndResponse) for checking the status of the asynchronous API operations  Zuora has the following limits on the Orders asynchronous API operations to prevent performance degradation: * Up to 300 subscriptions are allowed in a single [Create an order asynchronously](https://developer.zuora.com/api-references/api/operation/POST_CreateOrderAsynchronously) or [Preview an order asynchronously](https://developer.zuora.com/api-references/api/operation/POST_PreviewOrderAsynchronously) operation call. * Up to 300 order actions are allowed in a single [Create an order asynchronously](https://developer.zuora.com/api-references/api/operation/POST_CreateOrderAsynchronously) or [Preview an order asynchronously](https://developer.zuora.com/api-references/api/operation/POST_PreviewOrderAsynchronously) operation call. * Up to 300 order actions are allowed on a single subscription in a [Create an order asynchronously](https://developer.zuora.com/api-references/api/operation/POST_CreateOrderAsynchronously) or [Preview an order asynchronously](https://developer.zuora.com/api-references/api/operation/POST_PreviewOrderAsynchronously) operation call. 

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Zuora;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.OrdersApi;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Example {
  public static void main(String[] args) {
    Configuration configuration = new Configuration();
    configuration.host = "https://rest.zuora.com";
    Zuora client = new Zuora(configuration);
    LocalDate orderDate = LocalDate.now(); // The date when the order is signed. All of the order actions under this order will use this order date as the contract effective date.
    PreviewOptions previewOptions = new PreviewOptions();
    String description = "description_example"; // A description of the order.
    String category = "NewSales"; // Category of the order to indicate a product sale or return. Default value is `NewSales`. 
    Map<String, Object> customFields = new HashMap(); // Container for custom fields of an Order object. 
    String existingAccountNumber = "existingAccountNumber_example"; // The account number that this order will be created under.  Note that invoice owner account of the subscriptions included in this order should be the same with the account of the order. 
    List<OrderLineItemCommonPostOrder> orderLineItems = Arrays.asList(); // [Order Line Items](https://knowledgecenter.zuora.com/Billing/Subscriptions/Orders/Order_Line_Items/AA_Overview_of_Order_Line_Items) are non subscription based items created by an Order, representing transactional charges such as one-time fees, physical goods, or professional service charges that are not sold as subscription services.   With the Order Line Items feature enabled, you can now launch non-subscription and unified monetization business models in Zuora, in addition to subscription business models.   **Note:** The [Order Line Items](https://knowledgecenter.zuora.com/Billing/Subscriptions/Orders/Order_Line_Items/AA_Overview_of_Order_Line_Items) feature is now generally available to all Zuora customers. You need to enable the [Orders](https://knowledgecenter.zuora.com/BC_Subscription_Management/Orders/AA_Overview_of_Orders#Orders) feature to access the [Order Line Items](https://knowledgecenter.zuora.com/Billing/Subscriptions/Orders/Order_Line_Items/AA_Overview_of_Order_Line_Items) feature. As of Zuora Billing Release 313 (November 2021), new customers who onboard on [Orders](https://knowledgecenter.zuora.com/Billing/Subscriptions/Orders/AA_Overview_of_Orders) will have the [Order Line Items](https://knowledgecenter.zuora.com/Billing/Subscriptions/Orders/Order_Line_Items) feature enabled by default.         
    String orderNumber = "orderNumber_example"; // The order number of this order.    **Note:** Make sure the order number does not contain a slash. 
    PreviewAccountInfo previewAccountInfo = new PreviewAccountInfo();
    String reasonCode = "reasonCode_example"; // Values of reason code configured in **Billing Settings** > **Configure Reason Codes** through Zuora UI. Indicates the reason when a return order line item occurs. 
    List<POSTOrderPreviewRequestTypeSubscriptionsInner> subscriptions = Arrays.asList(); // Each item includes a set of order actions, which will be applied to the same base subscription.
    String idempotencyKey = "idempotencyKey_example"; // Specify a unique idempotency key if you want to perform an idempotent POST or PATCH request. Do not use this header in other request types.   With this header specified, the Zuora server can identify subsequent retries of the same request using this value, which prevents the same operation from being performed multiple times by accident.  
    String acceptEncoding = "acceptEncoding_example"; // Include the `Accept-Encoding: gzip` header to compress responses as a gzipped file. It can significantly reduce the bandwidth required for a response.   If specified, Zuora automatically compresses responses that contain over 1000 bytes of data, and the response contains a `Content-Encoding` header with the compression algorithm so that your client can decompress it. 
    String contentEncoding = "contentEncoding_example"; // Include the `Content-Encoding: gzip` header to compress a request. With this header specified, you should upload a gzipped file for the request payload instead of sending the JSON payload. 
    String authorization = "authorization_example"; // The value is in the `Bearer {token}` format where {token} is a valid OAuth token generated by calling [Create an OAuth token](https://developer.zuora.com/api-references/api/operation/createToken). 
    String zuoraTrackId = "zuoraTrackId_example"; // A custom identifier for tracing the API call. If you set a value for this header, Zuora returns the same value in the response headers. This header enables you to associate your system process identifiers with Zuora API calls, to assist with troubleshooting in the event of an issue.  The value of this field must use the US-ASCII character set and must not include any of the following characters: colon (`:`), semicolon (`;`), double quote (`\"`), and quote (`'`). 
    String zuoraEntityIds = "zuoraEntityIds_example"; // An entity ID. If you have [Zuora Multi-entity](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Multi-entity) enabled and the OAuth token is valid for more than one entity, you must use this header to specify which entity to perform the operation in. If the OAuth token is only valid for a single entity, or you do not have Zuora Multi-entity enabled, you do not need to set this header. 
    String zuoraOrgIds = "zuoraOrgIds_example"; // Comma separated IDs. If you have <a href=\"https://knowledgecenter.zuora.com/Zuora_Central_Platform/Multi-Org\" target=\"_blank\">Zuora Multi-Org</a> enabled,  you can use this header to specify which orgs to perform the operation in. If you do not have Zuora Multi-Org enabled, you should not set this header.  The IDs must be a sub-set of the user's accessible orgs. If you specify an org that the user does not have access to, the operation fails.  If the header is not set, the operation is performed in scope of the user's accessible orgs. 
    try {
      PostOrderPreviewResponseType result = client
              .orders
              .previewOrder(orderDate, previewOptions)
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
      System.out.println(result);
      System.out.println(result.getProcessId());
      System.out.println(result.getReasons());
      System.out.println(result.getRequestId());
      System.out.println(result.getSuccess());
      System.out.println(result.getPreviewResult());
    } catch (ApiException e) {
      System.err.println("Exception when calling OrdersApi#previewOrder");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<PostOrderPreviewResponseType> response = client
              .orders
              .previewOrder(orderDate, previewOptions)
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
              .executeWithHttpInfo();
      System.out.println(response.getResponseBody());
      System.out.println(response.getResponseHeaders());
      System.out.println(response.getStatusCode());
      System.out.println(response.getRoundTripTime());
      System.out.println(response.getRequest());
    } catch (ApiException e) {
      System.err.println("Exception when calling OrdersApi#previewOrder");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}

```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **poSTOrderPreviewRequestType** | [**POSTOrderPreviewRequestType**](POSTOrderPreviewRequestType.md)|  | |
| **idempotencyKey** | **String**| Specify a unique idempotency key if you want to perform an idempotent POST or PATCH request. Do not use this header in other request types.   With this header specified, the Zuora server can identify subsequent retries of the same request using this value, which prevents the same operation from being performed multiple times by accident.   | [optional] |
| **acceptEncoding** | **String**| Include the &#x60;Accept-Encoding: gzip&#x60; header to compress responses as a gzipped file. It can significantly reduce the bandwidth required for a response.   If specified, Zuora automatically compresses responses that contain over 1000 bytes of data, and the response contains a &#x60;Content-Encoding&#x60; header with the compression algorithm so that your client can decompress it.  | [optional] |
| **contentEncoding** | **String**| Include the &#x60;Content-Encoding: gzip&#x60; header to compress a request. With this header specified, you should upload a gzipped file for the request payload instead of sending the JSON payload.  | [optional] |
| **authorization** | **String**| The value is in the &#x60;Bearer {token}&#x60; format where {token} is a valid OAuth token generated by calling [Create an OAuth token](https://developer.zuora.com/api-references/api/operation/createToken).  | [optional] |
| **zuoraTrackId** | **String**| A custom identifier for tracing the API call. If you set a value for this header, Zuora returns the same value in the response headers. This header enables you to associate your system process identifiers with Zuora API calls, to assist with troubleshooting in the event of an issue.  The value of this field must use the US-ASCII character set and must not include any of the following characters: colon (&#x60;:&#x60;), semicolon (&#x60;;&#x60;), double quote (&#x60;\&quot;&#x60;), and quote (&#x60;&#39;&#x60;).  | [optional] |
| **zuoraEntityIds** | **String**| An entity ID. If you have [Zuora Multi-entity](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Multi-entity) enabled and the OAuth token is valid for more than one entity, you must use this header to specify which entity to perform the operation in. If the OAuth token is only valid for a single entity, or you do not have Zuora Multi-entity enabled, you do not need to set this header.  | [optional] |
| **zuoraOrgIds** | **String**| Comma separated IDs. If you have &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Central_Platform/Multi-Org\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Zuora Multi-Org&lt;/a&gt; enabled,  you can use this header to specify which orgs to perform the operation in. If you do not have Zuora Multi-Org enabled, you should not set this header.  The IDs must be a sub-set of the user&#39;s accessible orgs. If you specify an org that the user does not have access to, the operation fails.  If the header is not set, the operation is performed in scope of the user&#39;s accessible orgs.  | [optional] |

### Return type

[**PostOrderPreviewResponseType**](PostOrderPreviewResponseType.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** |  |  * Content-Encoding - This header is returned if you specify the &#x60;Accept-Encoding: gzip&#x60; request header and the response contains over 1000 bytes of data. Note that only the following MIME types support gzipped responses:   - &#x60;application/json&#x60;   - &#x60;application/xml&#x60;   - &#x60;text/html&#x60;   - &#x60;text/csv&#x60;   - &#x60;text/plain&#x60;  <br>  * RateLimit-Limit - The request limit quota for the time window closest to exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Remaining - The number of requests remaining in the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Reset - The number of seconds until the quota resets for the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Zuora-Request-Id - The Zuora internal identifier of the API call. You cannot control the value of this header.  <br>  * Zuora-Track-Id - A custom identifier for tracing the API call. If you specified a tracing identifier in the request headers, Zuora returns the same tracing identifier. Otherwise, Zuora does not set this header.  <br>  |

<a name="previewOrderAsynchronously"></a>
# **previewOrderAsynchronously**
> PostPreviewOrderAsynchronouslyResponse previewOrderAsynchronously(poSTOrderPreviewAsyncRequestType).idempotencyKey(idempotencyKey).acceptEncoding(acceptEncoding).contentEncoding(contentEncoding).authorization(authorization).zuoraTrackId(zuoraTrackId).zuoraEntityIds(zuoraEntityIds).zuoraOrgIds(zuoraOrgIds).execute();

Preview an order asynchronously

**Notes:**  - This operation is only available if you have the [Orders](https://knowledgecenter.zuora.com/BC_Subscription_Management/Orders/AA_Overview_of_Orders#Orders) feature enabled. Orders is now generally available as of Zuora Billing Release 284 (August 2020). If you are an existing Zuora &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Subscriptions/Subscriptions/Subscribe_and_Amend\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Subscribe and Amend&lt;/a&gt; customer, we recommend you enable &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Subscriptions/Subscriptions/Orders_Harmonization/A_Overview_of_Orders_Harmonization\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Orders Harmonization&lt;/a&gt; to access the &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Subscriptions/Subscriptions/Orders/AA_Overview_of_Orders/A_Overview_of_Orders\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Orders&lt;/a&gt; feature. With Orders, you can access both existing functions for subscription and billing management and the &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Subscriptions/Subscriptions/Orders_Harmonization/P_FAQ_about_Orders_Harmonization#New+features+through+Orders\&quot; target&#x3D;\&quot;_blank\&quot;&gt;new features&lt;/a&gt; on Zuora Billing. - The [Order Line Items](https://knowledgecenter.zuora.com/Billing/Subscriptions/Orders/Order_Line_Items/AA_Overview_of_Order_Line_Items) feature is now generally available to all Zuora customers. You need to enable the [Orders](https://knowledgecenter.zuora.com/BC_Subscription_Management/Orders/AA_Overview_of_Orders#Orders) feature to access the [Order Line Items](https://knowledgecenter.zuora.com/Billing/Subscriptions/Orders/Order_Line_Items/AA_Overview_of_Order_Line_Items) feature. As of Zuora Billing Release 313 (November 2021), new customers who onboard on [Orders](https://knowledgecenter.zuora.com/Billing/Subscriptions/Orders/AA_Overview_of_Orders) will have the [Order Line Items](https://knowledgecenter.zuora.com/Billing/Subscriptions/Orders/Order_Line_Items) feature enabled by default.         - You cannot preview enhanced discounts.  In the case where a normal \&quot;Preview an order\&quot; operation call will time out, use this operation instead to preview an order asynchronously. A job will be previewing the order in the back end; the job ID will be returned for tracking the job status and result.  #### Billing preview behavior regarding draft invoices By default, the billing preview behavior regarding draft invoices is as below: * When you preview billing for your order and the order contains subscriptions only, the draft invoices are excluded. * When you preview billing for your order and the order contains order line items only, the draft invoices are included. * When you preview billing for an order that contains both subscriptions  order line items, the draft invoices are included for both subscriptions and order line items.  However, if you want to always exclude the draft invoices in billing preview, submit a request at [Zuora Global Support](https://support.zuora.com).  #### Limits on Orders API  The limit of orders allowed on a subscription is 1000.  The limit of order line items allowed in an order is 100.  Zuora has the following limits on the Orders synchronous API to prevent performance degradation:  * Up to 50 subscriptions are allowed in a single [Create an order](https://developer.zuora.com/api-references/api/operation/POST_Order) or [Preview an order](https://developer.zuora.com/api-references/api/operation/POST_PreviewOrder) operation call. * Up to 50 order actions are allowed in a single [Create an order](https://developer.zuora.com/api-references/api/operation/POST_Order) or [Preview an order](https://developer.zuora.com/api-references/api/operation/POST_PreviewOrder) operation call. * Up to 50 order actions are allowed on a single subscription in a [Create an order](https://developer.zuora.com/api-references/api/operation/POST_Order) or [Preview an order](https://developer.zuora.com/api-references/api/operation/POST_PreviewOrder) operation call.  If you have an Order that exceeds any limits of the above, Zuora recommends you use the following asynchronous API operations: * [Create an order asynchronously](https://developer.zuora.com/api-references/api/operation/POST_CreateOrderAsynchronously) * [Preview an order asynchronously](https://developer.zuora.com/api-references/api/operation/POST_PreviewOrderAsynchronously) * [Retrieve the status and response of a job](https://developer.zuora.com/api-references/api/operation/GET_JobStatusAndResponse) for checking the status of the asynchronous API operations  Zuora has the following limits on the Orders asynchronous API operations to prevent performance degradation: * Up to 300 subscriptions are allowed in a single [Create an order asynchronously](https://developer.zuora.com/api-references/api/operation/POST_CreateOrderAsynchronously) or [Preview an order asynchronously](https://developer.zuora.com/api-references/api/operation/POST_PreviewOrderAsynchronously) operation call. * Up to 300 order actions are allowed in a single [Create an order asynchronously](https://developer.zuora.com/api-references/api/operation/POST_CreateOrderAsynchronously) or [Preview an order asynchronously](https://developer.zuora.com/api-references/api/operation/POST_PreviewOrderAsynchronously) operation call. * Up to 300 order actions are allowed on a single subscription in a [Create an order asynchronously](https://developer.zuora.com/api-references/api/operation/POST_CreateOrderAsynchronously) or [Preview an order asynchronously](https://developer.zuora.com/api-references/api/operation/POST_PreviewOrderAsynchronously) operation call. 

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Zuora;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.OrdersApi;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Example {
  public static void main(String[] args) {
    Configuration configuration = new Configuration();
    configuration.host = "https://rest.zuora.com";
    Zuora client = new Zuora(configuration);
    LocalDate orderDate = LocalDate.now(); // The date when the order is signed. All of the order actions under this order will use this order date as the contract effective date.
    PreviewOptions previewOptions = new PreviewOptions();
    String description = "description_example"; // A description of the order.
    String category = "NewSales"; // Category of the order to indicate a product sale or return. Default value is `NewSales`. 
    Map<String, Object> customFields = new HashMap(); // Container for custom fields of an Order object. 
    String existingAccountNumber = "existingAccountNumber_example"; // The account number that this order will be created under.  Note that invoice owner account of the subscriptions included in this order should be the same with the account of the order. 
    List<OrderLineItemCommonPostOrder> orderLineItems = Arrays.asList(); // [Order Line Items](https://knowledgecenter.zuora.com/Billing/Subscriptions/Orders/Order_Line_Items/AA_Overview_of_Order_Line_Items) are non subscription based items created by an Order, representing transactional charges such as one-time fees, physical goods, or professional service charges that are not sold as subscription services.   With the Order Line Items feature enabled, you can now launch non-subscription and unified monetization business models in Zuora, in addition to subscription business models.   **Note:** The [Order Line Items](https://knowledgecenter.zuora.com/Billing/Subscriptions/Orders/Order_Line_Items/AA_Overview_of_Order_Line_Items) feature is now generally available to all Zuora customers. You need to enable the [Orders](https://knowledgecenter.zuora.com/BC_Subscription_Management/Orders/AA_Overview_of_Orders#Orders) feature to access the [Order Line Items](https://knowledgecenter.zuora.com/Billing/Subscriptions/Orders/Order_Line_Items/AA_Overview_of_Order_Line_Items) feature. As of Zuora Billing Release 313 (November 2021), new customers who onboard on [Orders](https://knowledgecenter.zuora.com/Billing/Subscriptions/Orders/AA_Overview_of_Orders) will have the [Order Line Items](https://knowledgecenter.zuora.com/Billing/Subscriptions/Orders/Order_Line_Items) feature enabled by default.        
    String orderNumber = "orderNumber_example"; // The order number of this order.    **Note:** Make sure the order number does not contain a slash. 
    PreviewAccountInfo previewAccountInfo = new PreviewAccountInfo();
    String reasonCode = "reasonCode_example"; // Values of reason code configured in **Billing Settings** > **Configure Reason Codes** through Zuora UI. Indicates the reason when a return order line item occurs. 
    List<POSTOrderPreviewRequestTypeSubscriptionsInner> subscriptions = Arrays.asList(); // Each item includes a set of order actions, which will be applied to the same base subscription.
    String idempotencyKey = "idempotencyKey_example"; // Specify a unique idempotency key if you want to perform an idempotent POST or PATCH request. Do not use this header in other request types.   With this header specified, the Zuora server can identify subsequent retries of the same request using this value, which prevents the same operation from being performed multiple times by accident.  
    String acceptEncoding = "acceptEncoding_example"; // Include the `Accept-Encoding: gzip` header to compress responses as a gzipped file. It can significantly reduce the bandwidth required for a response.   If specified, Zuora automatically compresses responses that contain over 1000 bytes of data, and the response contains a `Content-Encoding` header with the compression algorithm so that your client can decompress it. 
    String contentEncoding = "contentEncoding_example"; // Include the `Content-Encoding: gzip` header to compress a request. With this header specified, you should upload a gzipped file for the request payload instead of sending the JSON payload. 
    String authorization = "authorization_example"; // The value is in the `Bearer {token}` format where {token} is a valid OAuth token generated by calling [Create an OAuth token](https://developer.zuora.com/api-references/api/operation/createToken). 
    String zuoraTrackId = "zuoraTrackId_example"; // A custom identifier for tracing the API call. If you set a value for this header, Zuora returns the same value in the response headers. This header enables you to associate your system process identifiers with Zuora API calls, to assist with troubleshooting in the event of an issue.  The value of this field must use the US-ASCII character set and must not include any of the following characters: colon (`:`), semicolon (`;`), double quote (`\"`), and quote (`'`). 
    String zuoraEntityIds = "zuoraEntityIds_example"; // An entity ID. If you have [Zuora Multi-entity](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Multi-entity) enabled and the OAuth token is valid for more than one entity, you must use this header to specify which entity to perform the operation in. If the OAuth token is only valid for a single entity, or you do not have Zuora Multi-entity enabled, you do not need to set this header. 
    String zuoraOrgIds = "zuoraOrgIds_example"; // Comma separated IDs. If you have <a href=\"https://knowledgecenter.zuora.com/Zuora_Central_Platform/Multi-Org\" target=\"_blank\">Zuora Multi-Org</a> enabled,  you can use this header to specify which orgs to perform the operation in. If you do not have Zuora Multi-Org enabled, you should not set this header.  The IDs must be a sub-set of the user's accessible orgs. If you specify an org that the user does not have access to, the operation fails.  If the header is not set, the operation is performed in scope of the user's accessible orgs. 
    try {
      PostPreviewOrderAsynchronouslyResponse result = client
              .orders
              .previewOrderAsynchronously(orderDate, previewOptions)
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
      System.out.println(result);
      System.out.println(result.getJobId());
    } catch (ApiException e) {
      System.err.println("Exception when calling OrdersApi#previewOrderAsynchronously");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<PostPreviewOrderAsynchronouslyResponse> response = client
              .orders
              .previewOrderAsynchronously(orderDate, previewOptions)
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
              .executeWithHttpInfo();
      System.out.println(response.getResponseBody());
      System.out.println(response.getResponseHeaders());
      System.out.println(response.getStatusCode());
      System.out.println(response.getRoundTripTime());
      System.out.println(response.getRequest());
    } catch (ApiException e) {
      System.err.println("Exception when calling OrdersApi#previewOrderAsynchronously");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}

```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **poSTOrderPreviewAsyncRequestType** | [**POSTOrderPreviewAsyncRequestType**](POSTOrderPreviewAsyncRequestType.md)|  | |
| **idempotencyKey** | **String**| Specify a unique idempotency key if you want to perform an idempotent POST or PATCH request. Do not use this header in other request types.   With this header specified, the Zuora server can identify subsequent retries of the same request using this value, which prevents the same operation from being performed multiple times by accident.   | [optional] |
| **acceptEncoding** | **String**| Include the &#x60;Accept-Encoding: gzip&#x60; header to compress responses as a gzipped file. It can significantly reduce the bandwidth required for a response.   If specified, Zuora automatically compresses responses that contain over 1000 bytes of data, and the response contains a &#x60;Content-Encoding&#x60; header with the compression algorithm so that your client can decompress it.  | [optional] |
| **contentEncoding** | **String**| Include the &#x60;Content-Encoding: gzip&#x60; header to compress a request. With this header specified, you should upload a gzipped file for the request payload instead of sending the JSON payload.  | [optional] |
| **authorization** | **String**| The value is in the &#x60;Bearer {token}&#x60; format where {token} is a valid OAuth token generated by calling [Create an OAuth token](https://developer.zuora.com/api-references/api/operation/createToken).  | [optional] |
| **zuoraTrackId** | **String**| A custom identifier for tracing the API call. If you set a value for this header, Zuora returns the same value in the response headers. This header enables you to associate your system process identifiers with Zuora API calls, to assist with troubleshooting in the event of an issue.  The value of this field must use the US-ASCII character set and must not include any of the following characters: colon (&#x60;:&#x60;), semicolon (&#x60;;&#x60;), double quote (&#x60;\&quot;&#x60;), and quote (&#x60;&#39;&#x60;).  | [optional] |
| **zuoraEntityIds** | **String**| An entity ID. If you have [Zuora Multi-entity](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Multi-entity) enabled and the OAuth token is valid for more than one entity, you must use this header to specify which entity to perform the operation in. If the OAuth token is only valid for a single entity, or you do not have Zuora Multi-entity enabled, you do not need to set this header.  | [optional] |
| **zuoraOrgIds** | **String**| Comma separated IDs. If you have &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Central_Platform/Multi-Org\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Zuora Multi-Org&lt;/a&gt; enabled,  you can use this header to specify which orgs to perform the operation in. If you do not have Zuora Multi-Org enabled, you should not set this header.  The IDs must be a sub-set of the user&#39;s accessible orgs. If you specify an org that the user does not have access to, the operation fails.  If the header is not set, the operation is performed in scope of the user&#39;s accessible orgs.  | [optional] |

### Return type

[**PostPreviewOrderAsynchronouslyResponse**](PostPreviewOrderAsynchronouslyResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **202** | Accepted |  * Content-Encoding - This header is returned if you specify the &#x60;Accept-Encoding: gzip&#x60; request header and the response contains over 1000 bytes of data. Note that only the following MIME types support gzipped responses:   - &#x60;application/json&#x60;   - &#x60;application/xml&#x60;   - &#x60;text/html&#x60;   - &#x60;text/csv&#x60;   - &#x60;text/plain&#x60;  <br>  * Location - URL for accessing the job result, in the format of &#x60;/async-jobs/{jobId}&#x60;. For example, &#x60;/async-jobs/1bc24f315d7b48d3a20245bfe73bdceb&#x60; <br>  * RateLimit-Limit - The request limit quota for the time window closest to exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Remaining - The number of requests remaining in the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Reset - The number of seconds until the quota resets for the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Zuora-Request-Id - The Zuora internal identifier of the API call. You cannot control the value of this header.  <br>  * Zuora-Track-Id - A custom identifier for tracing the API call. If you specified a tracing identifier in the request headers, Zuora returns the same tracing identifier. Otherwise, Zuora does not set this header.  <br>  |

<a name="updateOrderCustomFields"></a>
# **updateOrderCustomFields**
> CommonResponse updateOrderCustomFields(orderNumber, puTOrderPatchRequestType).acceptEncoding(acceptEncoding).contentEncoding(contentEncoding).authorization(authorization).zuoraTrackId(zuoraTrackId).zuoraEntityIds(zuoraEntityIds).zuoraOrgIds(zuoraOrgIds).execute();

Update order custom fields

**Note:** This feature is only available if you have the [Order Metrics](https://knowledgecenter.zuora.com/BC_Subscription_Management/Orders/AA_Overview_of_Orders#Order_Metrics) feature enabled. As of Zuora Billing Release 284, Orders is generally available and the Order Metrics feature is no longer available as a standalone feature. If you are an existing Subscribe and Amend customer and want Order Metrics only, you must turn on [Orders Harmonization](https://knowledgecenter.zuora.com/Billing/Subscriptions/Orders/Orders_Harmonization/Orders_Harmonization). You can still keep the existing Subscribe and Amend API integrations to create and manage subscriptions.  **Note:** To update the custom fields of an order line item, you must use the \&quot;Update an order line item\&quot; or \&quot;Update order line items\&quot; operation.  Updates the custom fields of a specified order. 

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Zuora;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.OrdersApi;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Example {
  public static void main(String[] args) {
    Configuration configuration = new Configuration();
    configuration.host = "https://rest.zuora.com";
    Zuora client = new Zuora(configuration);
    String orderNumber = "orderNumber_example"; // The order number.
    Map<String, Object> customFields = new HashMap(); // Container for custom fields of an Order object. 
    List<PUTOrderPatchRequestTypeSubscriptionsInner> subscriptions = Arrays.asList();
    String acceptEncoding = "acceptEncoding_example"; // Include the `Accept-Encoding: gzip` header to compress responses as a gzipped file. It can significantly reduce the bandwidth required for a response.   If specified, Zuora automatically compresses responses that contain over 1000 bytes of data, and the response contains a `Content-Encoding` header with the compression algorithm so that your client can decompress it. 
    String contentEncoding = "contentEncoding_example"; // Include the `Content-Encoding: gzip` header to compress a request. With this header specified, you should upload a gzipped file for the request payload instead of sending the JSON payload. 
    String authorization = "authorization_example"; // The value is in the `Bearer {token}` format where {token} is a valid OAuth token generated by calling [Create an OAuth token](https://developer.zuora.com/api-references/api/operation/createToken). 
    String zuoraTrackId = "zuoraTrackId_example"; // A custom identifier for tracing the API call. If you set a value for this header, Zuora returns the same value in the response headers. This header enables you to associate your system process identifiers with Zuora API calls, to assist with troubleshooting in the event of an issue.  The value of this field must use the US-ASCII character set and must not include any of the following characters: colon (`:`), semicolon (`;`), double quote (`\"`), and quote (`'`). 
    String zuoraEntityIds = "zuoraEntityIds_example"; // An entity ID. If you have [Zuora Multi-entity](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Multi-entity) enabled and the OAuth token is valid for more than one entity, you must use this header to specify which entity to perform the operation in. If the OAuth token is only valid for a single entity, or you do not have Zuora Multi-entity enabled, you do not need to set this header. 
    String zuoraOrgIds = "zuoraOrgIds_example"; // Comma separated IDs. If you have <a href=\"https://knowledgecenter.zuora.com/Zuora_Central_Platform/Multi-Org\" target=\"_blank\">Zuora Multi-Org</a> enabled,  you can use this header to specify which orgs to perform the operation in. If you do not have Zuora Multi-Org enabled, you should not set this header.  The IDs must be a sub-set of the user's accessible orgs. If you specify an org that the user does not have access to, the operation fails.  If the header is not set, the operation is performed in scope of the user's accessible orgs. 
    try {
      CommonResponse result = client
              .orders
              .updateOrderCustomFields(orderNumber)
              .customFields(customFields)
              .subscriptions(subscriptions)
              .acceptEncoding(acceptEncoding)
              .contentEncoding(contentEncoding)
              .authorization(authorization)
              .zuoraTrackId(zuoraTrackId)
              .zuoraEntityIds(zuoraEntityIds)
              .zuoraOrgIds(zuoraOrgIds)
              .execute();
      System.out.println(result);
      System.out.println(result.getProcessId());
      System.out.println(result.getReasons());
      System.out.println(result.getRequestId());
      System.out.println(result.getSuccess());
    } catch (ApiException e) {
      System.err.println("Exception when calling OrdersApi#updateOrderCustomFields");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<CommonResponse> response = client
              .orders
              .updateOrderCustomFields(orderNumber)
              .customFields(customFields)
              .subscriptions(subscriptions)
              .acceptEncoding(acceptEncoding)
              .contentEncoding(contentEncoding)
              .authorization(authorization)
              .zuoraTrackId(zuoraTrackId)
              .zuoraEntityIds(zuoraEntityIds)
              .zuoraOrgIds(zuoraOrgIds)
              .executeWithHttpInfo();
      System.out.println(response.getResponseBody());
      System.out.println(response.getResponseHeaders());
      System.out.println(response.getStatusCode());
      System.out.println(response.getRoundTripTime());
      System.out.println(response.getRequest());
    } catch (ApiException e) {
      System.err.println("Exception when calling OrdersApi#updateOrderCustomFields");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}

```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **orderNumber** | **String**| The order number. | |
| **puTOrderPatchRequestType** | [**PUTOrderPatchRequestType**](PUTOrderPatchRequestType.md)|  | |
| **acceptEncoding** | **String**| Include the &#x60;Accept-Encoding: gzip&#x60; header to compress responses as a gzipped file. It can significantly reduce the bandwidth required for a response.   If specified, Zuora automatically compresses responses that contain over 1000 bytes of data, and the response contains a &#x60;Content-Encoding&#x60; header with the compression algorithm so that your client can decompress it.  | [optional] |
| **contentEncoding** | **String**| Include the &#x60;Content-Encoding: gzip&#x60; header to compress a request. With this header specified, you should upload a gzipped file for the request payload instead of sending the JSON payload.  | [optional] |
| **authorization** | **String**| The value is in the &#x60;Bearer {token}&#x60; format where {token} is a valid OAuth token generated by calling [Create an OAuth token](https://developer.zuora.com/api-references/api/operation/createToken).  | [optional] |
| **zuoraTrackId** | **String**| A custom identifier for tracing the API call. If you set a value for this header, Zuora returns the same value in the response headers. This header enables you to associate your system process identifiers with Zuora API calls, to assist with troubleshooting in the event of an issue.  The value of this field must use the US-ASCII character set and must not include any of the following characters: colon (&#x60;:&#x60;), semicolon (&#x60;;&#x60;), double quote (&#x60;\&quot;&#x60;), and quote (&#x60;&#39;&#x60;).  | [optional] |
| **zuoraEntityIds** | **String**| An entity ID. If you have [Zuora Multi-entity](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Multi-entity) enabled and the OAuth token is valid for more than one entity, you must use this header to specify which entity to perform the operation in. If the OAuth token is only valid for a single entity, or you do not have Zuora Multi-entity enabled, you do not need to set this header.  | [optional] |
| **zuoraOrgIds** | **String**| Comma separated IDs. If you have &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Central_Platform/Multi-Org\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Zuora Multi-Org&lt;/a&gt; enabled,  you can use this header to specify which orgs to perform the operation in. If you do not have Zuora Multi-Org enabled, you should not set this header.  The IDs must be a sub-set of the user&#39;s accessible orgs. If you specify an org that the user does not have access to, the operation fails.  If the header is not set, the operation is performed in scope of the user&#39;s accessible orgs.  | [optional] |

### Return type

[**CommonResponse**](CommonResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** |  |  * Content-Encoding - This header is returned if you specify the &#x60;Accept-Encoding: gzip&#x60; request header and the response contains over 1000 bytes of data. Note that only the following MIME types support gzipped responses:   - &#x60;application/json&#x60;   - &#x60;application/xml&#x60;   - &#x60;text/html&#x60;   - &#x60;text/csv&#x60;   - &#x60;text/plain&#x60;  <br>  * RateLimit-Limit - The request limit quota for the time window closest to exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Remaining - The number of requests remaining in the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Reset - The number of seconds until the quota resets for the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Zuora-Request-Id - The Zuora internal identifier of the API call. You cannot control the value of this header.  <br>  * Zuora-Track-Id - A custom identifier for tracing the API call. If you specified a tracing identifier in the request headers, Zuora returns the same tracing identifier. Otherwise, Zuora does not set this header.  <br>  |

<a name="updateSubscriptionCustomFields"></a>
# **updateSubscriptionCustomFields**
> CommonResponse updateSubscriptionCustomFields(subscriptionNumber, puTSubscriptionPatchRequestType).acceptEncoding(acceptEncoding).contentEncoding(contentEncoding).authorization(authorization).zuoraTrackId(zuoraTrackId).zuoraEntityIds(zuoraEntityIds).zuoraOrgIds(zuoraOrgIds).execute();

Update subscription custom fields

**Note:** This operation is only available if you have the [Orders](https://knowledgecenter.zuora.com/BC_Subscription_Management/Orders/AA_Overview_of_Orders#Orders) feature enabled. If you are an existing Zuora &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Subscriptions/Subscriptions/Subscribe_and_Amend\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Subscribe and Amend&lt;/a&gt; customer, we recommend you enable &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Subscriptions/Subscriptions/Orders_Harmonization/A_Overview_of_Orders_Harmonization\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Orders Harmonization&lt;/a&gt; to access the &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Subscriptions/Subscriptions/Orders/AA_Overview_of_Orders/A_Overview_of_Orders\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Orders&lt;/a&gt; feature. With Orders, you can access both existing functions for subscription and billing management and the &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Billing/Subscriptions/Subscriptions/Orders_Harmonization/P_FAQ_about_Orders_Harmonization#New+features+through+Orders\&quot; target&#x3D;\&quot;_blank\&quot;&gt;new features&lt;/a&gt; on Zuora Billing.  Updates the custom fields of a specified subscription. 

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Zuora;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.OrdersApi;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Example {
  public static void main(String[] args) {
    Configuration configuration = new Configuration();
    configuration.host = "https://rest.zuora.com";
    Zuora client = new Zuora(configuration);
    String subscriptionNumber = "subscriptionNumber_example"; // The subscription number to be updated.
    Map<String, Object> customFields = new HashMap(); // Container for custom fields of a Subscription object. 
    List<PUTSubscriptionPatchRequestTypeRatePlansInner> ratePlans = Arrays.asList();
    String acceptEncoding = "acceptEncoding_example"; // Include the `Accept-Encoding: gzip` header to compress responses as a gzipped file. It can significantly reduce the bandwidth required for a response.   If specified, Zuora automatically compresses responses that contain over 1000 bytes of data, and the response contains a `Content-Encoding` header with the compression algorithm so that your client can decompress it. 
    String contentEncoding = "contentEncoding_example"; // Include the `Content-Encoding: gzip` header to compress a request. With this header specified, you should upload a gzipped file for the request payload instead of sending the JSON payload. 
    String authorization = "authorization_example"; // The value is in the `Bearer {token}` format where {token} is a valid OAuth token generated by calling [Create an OAuth token](https://developer.zuora.com/api-references/api/operation/createToken). 
    String zuoraTrackId = "zuoraTrackId_example"; // A custom identifier for tracing the API call. If you set a value for this header, Zuora returns the same value in the response headers. This header enables you to associate your system process identifiers with Zuora API calls, to assist with troubleshooting in the event of an issue.  The value of this field must use the US-ASCII character set and must not include any of the following characters: colon (`:`), semicolon (`;`), double quote (`\"`), and quote (`'`). 
    String zuoraEntityIds = "zuoraEntityIds_example"; // An entity ID. If you have [Zuora Multi-entity](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Multi-entity) enabled and the OAuth token is valid for more than one entity, you must use this header to specify which entity to perform the operation in. If the OAuth token is only valid for a single entity, or you do not have Zuora Multi-entity enabled, you do not need to set this header. 
    String zuoraOrgIds = "zuoraOrgIds_example"; // Comma separated IDs. If you have <a href=\"https://knowledgecenter.zuora.com/Zuora_Central_Platform/Multi-Org\" target=\"_blank\">Zuora Multi-Org</a> enabled,  you can use this header to specify which orgs to perform the operation in. If you do not have Zuora Multi-Org enabled, you should not set this header.  The IDs must be a sub-set of the user's accessible orgs. If you specify an org that the user does not have access to, the operation fails.  If the header is not set, the operation is performed in scope of the user's accessible orgs. 
    try {
      CommonResponse result = client
              .orders
              .updateSubscriptionCustomFields(subscriptionNumber)
              .customFields(customFields)
              .ratePlans(ratePlans)
              .acceptEncoding(acceptEncoding)
              .contentEncoding(contentEncoding)
              .authorization(authorization)
              .zuoraTrackId(zuoraTrackId)
              .zuoraEntityIds(zuoraEntityIds)
              .zuoraOrgIds(zuoraOrgIds)
              .execute();
      System.out.println(result);
      System.out.println(result.getProcessId());
      System.out.println(result.getReasons());
      System.out.println(result.getRequestId());
      System.out.println(result.getSuccess());
    } catch (ApiException e) {
      System.err.println("Exception when calling OrdersApi#updateSubscriptionCustomFields");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<CommonResponse> response = client
              .orders
              .updateSubscriptionCustomFields(subscriptionNumber)
              .customFields(customFields)
              .ratePlans(ratePlans)
              .acceptEncoding(acceptEncoding)
              .contentEncoding(contentEncoding)
              .authorization(authorization)
              .zuoraTrackId(zuoraTrackId)
              .zuoraEntityIds(zuoraEntityIds)
              .zuoraOrgIds(zuoraOrgIds)
              .executeWithHttpInfo();
      System.out.println(response.getResponseBody());
      System.out.println(response.getResponseHeaders());
      System.out.println(response.getStatusCode());
      System.out.println(response.getRoundTripTime());
      System.out.println(response.getRequest());
    } catch (ApiException e) {
      System.err.println("Exception when calling OrdersApi#updateSubscriptionCustomFields");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}

```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **subscriptionNumber** | **String**| The subscription number to be updated. | |
| **puTSubscriptionPatchRequestType** | [**PUTSubscriptionPatchRequestType**](PUTSubscriptionPatchRequestType.md)|  | |
| **acceptEncoding** | **String**| Include the &#x60;Accept-Encoding: gzip&#x60; header to compress responses as a gzipped file. It can significantly reduce the bandwidth required for a response.   If specified, Zuora automatically compresses responses that contain over 1000 bytes of data, and the response contains a &#x60;Content-Encoding&#x60; header with the compression algorithm so that your client can decompress it.  | [optional] |
| **contentEncoding** | **String**| Include the &#x60;Content-Encoding: gzip&#x60; header to compress a request. With this header specified, you should upload a gzipped file for the request payload instead of sending the JSON payload.  | [optional] |
| **authorization** | **String**| The value is in the &#x60;Bearer {token}&#x60; format where {token} is a valid OAuth token generated by calling [Create an OAuth token](https://developer.zuora.com/api-references/api/operation/createToken).  | [optional] |
| **zuoraTrackId** | **String**| A custom identifier for tracing the API call. If you set a value for this header, Zuora returns the same value in the response headers. This header enables you to associate your system process identifiers with Zuora API calls, to assist with troubleshooting in the event of an issue.  The value of this field must use the US-ASCII character set and must not include any of the following characters: colon (&#x60;:&#x60;), semicolon (&#x60;;&#x60;), double quote (&#x60;\&quot;&#x60;), and quote (&#x60;&#39;&#x60;).  | [optional] |
| **zuoraEntityIds** | **String**| An entity ID. If you have [Zuora Multi-entity](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Multi-entity) enabled and the OAuth token is valid for more than one entity, you must use this header to specify which entity to perform the operation in. If the OAuth token is only valid for a single entity, or you do not have Zuora Multi-entity enabled, you do not need to set this header.  | [optional] |
| **zuoraOrgIds** | **String**| Comma separated IDs. If you have &lt;a href&#x3D;\&quot;https://knowledgecenter.zuora.com/Zuora_Central_Platform/Multi-Org\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Zuora Multi-Org&lt;/a&gt; enabled,  you can use this header to specify which orgs to perform the operation in. If you do not have Zuora Multi-Org enabled, you should not set this header.  The IDs must be a sub-set of the user&#39;s accessible orgs. If you specify an org that the user does not have access to, the operation fails.  If the header is not set, the operation is performed in scope of the user&#39;s accessible orgs.  | [optional] |

### Return type

[**CommonResponse**](CommonResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** |  |  * Content-Encoding - This header is returned if you specify the &#x60;Accept-Encoding: gzip&#x60; request header and the response contains over 1000 bytes of data. Note that only the following MIME types support gzipped responses:   - &#x60;application/json&#x60;   - &#x60;application/xml&#x60;   - &#x60;text/html&#x60;   - &#x60;text/csv&#x60;   - &#x60;text/plain&#x60;  <br>  * RateLimit-Limit - The request limit quota for the time window closest to exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Remaining - The number of requests remaining in the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * RateLimit-Reset - The number of seconds until the quota resets for the time window closest to quota exhaustion. See [rate limits](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Policies/Concurrent_Request_Limits#Rate_limits) for more information.  <br>  * Zuora-Request-Id - The Zuora internal identifier of the API call. You cannot control the value of this header.  <br>  * Zuora-Track-Id - A custom identifier for tracing the API call. If you specified a tracing identifier in the request headers, Zuora returns the same tracing identifier. Otherwise, Zuora does not set this header.  <br>  |

