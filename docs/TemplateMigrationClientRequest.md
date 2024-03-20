

# TemplateMigrationClientRequest

Request to add a new Template migration. TemplateMigrationClientRequest object contains request details of target tenant, source tenant, and template information needed for migration. 

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**description** | **String** | Description of the migration. |  |
|**comments** | **String** |  |  [optional] |
|**emailIds** | **String** | List of Emails with comma separator. |  [optional] |
|**entityUuid** | **String** | Entity UUID |  |
|**metaData** | **Object** | Json node object contains metadata. |  [optional] |
|**name** | **String** | Name of the migration. |  |
|**request** | [**List&lt;MigrationComponentContent&gt;**](MigrationComponentContent.md) | List of settings need to be migrated. |  [optional] |
|**sendEmail** | **Boolean** | Flag determines whether or not to send an email. |  |



