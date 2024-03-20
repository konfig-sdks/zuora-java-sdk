

# DataItems

The array of data for each Invoice if you want to collect payment for particular items through one payment method. The grouped items are sent as one data record.  This field is available if the [Invoice Item Settlement](https://knowledgecenter.zuora.com/Zuora_Billing/Bill_your_customers/Adjust_invoice_amounts/Invoice_Settlement/Invoice_Item_Settlement/Overview_of_Invoice_Item_Settlement) permission is enabled.  Here is another example for a data item:   ```   {     \"accountId\": \"60c81b5bc51649e8a7d1b48303194790\",     \"documentId\": \"2c9081a03c63c94c013c6894af5602dd\",     \"documentType\": \"Invoice\",     \"dataItems\": [       {           \"documentItemId\": \"8a92ab0e8ab14c53018ac746961c10d1\",           \"amount\": 40       },       {           \"taxItemId\": \"8a92ab0e8ab14c53018ac746961c10d2\",           \"amount\": 40       }   ],     \"amount\": 80,     \"paymentMethodId\": \"2c9081a03c6d7b51013c6d7e4ada0a1c\",     \"paymentGatewayId\": \"d2abe8342e1811ea80e774b9452e17ea\",     \"comment\": \"Payment Comments\",     \"customField1__c\": \"cf_value1\",     \"customField2__c\": \"cf_value2\"   },   ``` 

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**amount** | **Double** | The total amount to be collected for the specified invoice/debit memo item. The sum of the item amount should be equal to document amount.  |  [optional] |
|**documentItemId** | **String** | The ID of a billing document of the invoice item or debit memo item.  |  [optional] |
|**taxItemId** | **String** | The tax ID of the invoice item or debit memo item.  |  [optional] |



