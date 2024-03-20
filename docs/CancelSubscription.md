

# CancelSubscription

Information about an order action of type `CancelSubscription`. 

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**cancellationEffectiveDate** | **LocalDate** |  |  [optional] |
|**cancellationPolicy** | [**CancellationPolicyEnum**](#CancellationPolicyEnum) |  |  |



## Enum: CancellationPolicyEnum

| Name | Value |
|---- | -----|
| ENDOFCURRENTTERM | &quot;EndOfCurrentTerm&quot; |
| ENDOFLASTINVOICEPERIOD | &quot;EndOfLastInvoicePeriod&quot; |
| SPECIFICDATE | &quot;SpecificDate&quot; |



