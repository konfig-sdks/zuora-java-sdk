

# TermInfo

Container for the terms and renewal settings of the subscription. 

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**autoRenew** | **Boolean** | Specifies whether the subscription automatically renews at the end of the each term. Only applicable if the type of the first term is &#x60;TERMED&#x60;.  |  [optional] |
|**initialTerm** | [**TermInfoInitialTerm**](TermInfoInitialTerm.md) |  |  |
|**renewalSetting** | [**RenewalSettingEnum**](#RenewalSettingEnum) | Specifies the type of the terms that follow the first term if the subscription is renewed. Only applicable if the type of the first term is &#x60;TERMED&#x60;.  * &#x60;RENEW_WITH_SPECIFIC_TERM&#x60; - Each renewal term has a predefined duration. The first entry in &#x60;renewalTerms&#x60; specifies the duration of the second term of the subscription, the second entry in &#x60;renewalTerms&#x60; specifies the duration of the third term of the subscription, and so on. The last entry in &#x60;renewalTerms&#x60; specifies the ultimate duration of each renewal term. * &#x60;RENEW_TO_EVERGREEN&#x60; - The second term of the subscription does not have a predefined duration.  |  [optional] |
|**renewalTerms** | [**TermInfoRenewalTerms**](TermInfoRenewalTerms.md) |  |  [optional] |



## Enum: RenewalSettingEnum

| Name | Value |
|---- | -----|
| WITH_SPECIFIC_TERM | &quot;RENEW_WITH_SPECIFIC_TERM&quot; |
| TO_EVERGREEN | &quot;RENEW_TO_EVERGREEN&quot; |



