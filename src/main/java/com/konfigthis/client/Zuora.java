package com.konfigthis.client;

import com.konfigthis.client.api.ApiHealthApi;
import com.konfigthis.client.api.AccountingCodesApi;
import com.konfigthis.client.api.AccountingPeriodsApi;
import com.konfigthis.client.api.AccountsApi;
import com.konfigthis.client.api.ActionsApi;
import com.konfigthis.client.api.AggregateQueriesApi;
import com.konfigthis.client.api.AttachmentsApi;
import com.konfigthis.client.api.BillRunApi;
import com.konfigthis.client.api.BillRunHealthApi;
import com.konfigthis.client.api.BillingDocumentsApi;
import com.konfigthis.client.api.BillingPreviewRunApi;
import com.konfigthis.client.api.CatalogApi;
import com.konfigthis.client.api.CatalogGroupsApi;
import com.konfigthis.client.api.ConfigurationTemplatesApi;
import com.konfigthis.client.api.ContactSnapshotsApi;
import com.konfigthis.client.api.ContactsApi;
import com.konfigthis.client.api.CreditMemosApi;
import com.konfigthis.client.api.CustomEventTriggersApi;
import com.konfigthis.client.api.CustomExchangeRatesApi;
import com.konfigthis.client.api.CustomObjectDefinitionsApi;
import com.konfigthis.client.api.CustomObjectJobsApi;
import com.konfigthis.client.api.CustomObjectRecordsApi;
import com.konfigthis.client.api.CustomPaymentMethodTypesApi;
import com.konfigthis.client.api.CustomScheduledEventsApi;
import com.konfigthis.client.api.DataBackfillApi;
import com.konfigthis.client.api.DataLabelingApi;
import com.konfigthis.client.api.DataQueriesApi;
import com.konfigthis.client.api.DebitMemosApi;
import com.konfigthis.client.api.DeliveryAdjustmentsApi;
import com.konfigthis.client.api.DescribeApi;
import com.konfigthis.client.api.EInvoicingApi;
import com.konfigthis.client.api.ElectronicPaymentsHealthApi;
import com.konfigthis.client.api.FilesApi;
import com.konfigthis.client.api.FulfillmentsApi;
import com.konfigthis.client.api.HostedPagesApi;
import com.konfigthis.client.api.ImportsApi;
import com.konfigthis.client.api.InvoiceSchedulesApi;
import com.konfigthis.client.api.InvoicesApi;
import com.konfigthis.client.api.JournalRunsApi;
import com.konfigthis.client.api.MassUpdaterApi;
import com.konfigthis.client.api.MetadataApi;
import com.konfigthis.client.api.NotificationsApi;
import com.konfigthis.client.api.OAuthApi;
import com.konfigthis.client.api.OperationsApi;
import com.konfigthis.client.api.OrderActionsApi;
import com.konfigthis.client.api.OrderLineItemsApi;
import com.konfigthis.client.api.OrdersApi;
import com.konfigthis.client.api.PaymentAuthorizationApi;
import com.konfigthis.client.api.PaymentGatewayReconciliationApi;
import com.konfigthis.client.api.PaymentGatewaysApi;
import com.konfigthis.client.api.PaymentMethodSnapshotsApi;
import com.konfigthis.client.api.PaymentMethodTransactionLogsApi;
import com.konfigthis.client.api.PaymentMethodUpdaterApi;
import com.konfigthis.client.api.PaymentMethodsApi;
import com.konfigthis.client.api.PaymentRunsApi;
import com.konfigthis.client.api.PaymentSchedulesApi;
import com.konfigthis.client.api.PaymentTransactionLogsApi;
import com.konfigthis.client.api.PaymentsApi;
import com.konfigthis.client.api.PrepaidWithDrawdownApi;
import com.konfigthis.client.api.ProductChargeDefinitionsApi;
import com.konfigthis.client.api.ProductRatePlanChargeTiersApi;
import com.konfigthis.client.api.ProductRatePlanChargesApi;
import com.konfigthis.client.api.ProductRatePlanDefinitionsApi;
import com.konfigthis.client.api.ProductRatePlansApi;
import com.konfigthis.client.api.ProductsApi;
import com.konfigthis.client.api.RsaSignaturesApi;
import com.konfigthis.client.api.RampsApi;
import com.konfigthis.client.api.RatePlansApi;
import com.konfigthis.client.api.RefundsApi;
import com.konfigthis.client.api.RegenerateApi;
import com.konfigthis.client.api.SequenceSetsApi;
import com.konfigthis.client.api.SettingsApi;
import com.konfigthis.client.api.SignUpApi;
import com.konfigthis.client.api.SubscriptionsApi;
import com.konfigthis.client.api.SummaryJournalEntriesApi;
import com.konfigthis.client.api.TaxationItemsApi;
import com.konfigthis.client.api.UsageApi;
import com.konfigthis.client.api.WorkflowsApi;
import com.konfigthis.client.api.ZuoraRevenueIntegrationApi;

public class Zuora {
    private ApiClient apiClient;
    public final ApiHealthApi apiHealth;
    public final AccountingCodesApi accountingCodes;
    public final AccountingPeriodsApi accountingPeriods;
    public final AccountsApi accounts;
    public final ActionsApi actions;
    public final AggregateQueriesApi aggregateQueries;
    public final AttachmentsApi attachments;
    public final BillRunApi billRun;
    public final BillRunHealthApi billRunHealth;
    public final BillingDocumentsApi billingDocuments;
    public final BillingPreviewRunApi billingPreviewRun;
    public final CatalogApi catalog;
    public final CatalogGroupsApi catalogGroups;
    public final ConfigurationTemplatesApi configurationTemplates;
    public final ContactSnapshotsApi contactSnapshots;
    public final ContactsApi contacts;
    public final CreditMemosApi creditMemos;
    public final CustomEventTriggersApi customEventTriggers;
    public final CustomExchangeRatesApi customExchangeRates;
    public final CustomObjectDefinitionsApi customObjectDefinitions;
    public final CustomObjectJobsApi customObjectJobs;
    public final CustomObjectRecordsApi customObjectRecords;
    public final CustomPaymentMethodTypesApi customPaymentMethodTypes;
    public final CustomScheduledEventsApi customScheduledEvents;
    public final DataBackfillApi dataBackfill;
    public final DataLabelingApi dataLabeling;
    public final DataQueriesApi dataQueries;
    public final DebitMemosApi debitMemos;
    public final DeliveryAdjustmentsApi deliveryAdjustments;
    public final DescribeApi describe;
    public final EInvoicingApi eInvoicing;
    public final ElectronicPaymentsHealthApi electronicPaymentsHealth;
    public final FilesApi files;
    public final FulfillmentsApi fulfillments;
    public final HostedPagesApi hostedPages;
    public final ImportsApi imports;
    public final InvoiceSchedulesApi invoiceSchedules;
    public final InvoicesApi invoices;
    public final JournalRunsApi journalRuns;
    public final MassUpdaterApi massUpdater;
    public final MetadataApi metadata;
    public final NotificationsApi notifications;
    public final OAuthApi oAuth;
    public final OperationsApi operations;
    public final OrderActionsApi orderActions;
    public final OrderLineItemsApi orderLineItems;
    public final OrdersApi orders;
    public final PaymentAuthorizationApi paymentAuthorization;
    public final PaymentGatewayReconciliationApi paymentGatewayReconciliation;
    public final PaymentGatewaysApi paymentGateways;
    public final PaymentMethodSnapshotsApi paymentMethodSnapshots;
    public final PaymentMethodTransactionLogsApi paymentMethodTransactionLogs;
    public final PaymentMethodUpdaterApi paymentMethodUpdater;
    public final PaymentMethodsApi paymentMethods;
    public final PaymentRunsApi paymentRuns;
    public final PaymentSchedulesApi paymentSchedules;
    public final PaymentTransactionLogsApi paymentTransactionLogs;
    public final PaymentsApi payments;
    public final PrepaidWithDrawdownApi prepaidWithDrawdown;
    public final ProductChargeDefinitionsApi productChargeDefinitions;
    public final ProductRatePlanChargeTiersApi productRatePlanChargeTiers;
    public final ProductRatePlanChargesApi productRatePlanCharges;
    public final ProductRatePlanDefinitionsApi productRatePlanDefinitions;
    public final ProductRatePlansApi productRatePlans;
    public final ProductsApi products;
    public final RsaSignaturesApi rsaSignatures;
    public final RampsApi ramps;
    public final RatePlansApi ratePlans;
    public final RefundsApi refunds;
    public final RegenerateApi regenerate;
    public final SequenceSetsApi sequenceSets;
    public final SettingsApi settings;
    public final SignUpApi signUp;
    public final SubscriptionsApi subscriptions;
    public final SummaryJournalEntriesApi summaryJournalEntries;
    public final TaxationItemsApi taxationItems;
    public final UsageApi usage;
    public final WorkflowsApi workflows;
    public final ZuoraRevenueIntegrationApi zuoraRevenueIntegration;

    public Zuora() {
        this(null);
    }

    public Zuora(Configuration configuration) {
        this.apiClient = new ApiClient(null, configuration);
        this.apiHealth = new ApiHealthApi(this.apiClient);
        this.accountingCodes = new AccountingCodesApi(this.apiClient);
        this.accountingPeriods = new AccountingPeriodsApi(this.apiClient);
        this.accounts = new AccountsApi(this.apiClient);
        this.actions = new ActionsApi(this.apiClient);
        this.aggregateQueries = new AggregateQueriesApi(this.apiClient);
        this.attachments = new AttachmentsApi(this.apiClient);
        this.billRun = new BillRunApi(this.apiClient);
        this.billRunHealth = new BillRunHealthApi(this.apiClient);
        this.billingDocuments = new BillingDocumentsApi(this.apiClient);
        this.billingPreviewRun = new BillingPreviewRunApi(this.apiClient);
        this.catalog = new CatalogApi(this.apiClient);
        this.catalogGroups = new CatalogGroupsApi(this.apiClient);
        this.configurationTemplates = new ConfigurationTemplatesApi(this.apiClient);
        this.contactSnapshots = new ContactSnapshotsApi(this.apiClient);
        this.contacts = new ContactsApi(this.apiClient);
        this.creditMemos = new CreditMemosApi(this.apiClient);
        this.customEventTriggers = new CustomEventTriggersApi(this.apiClient);
        this.customExchangeRates = new CustomExchangeRatesApi(this.apiClient);
        this.customObjectDefinitions = new CustomObjectDefinitionsApi(this.apiClient);
        this.customObjectJobs = new CustomObjectJobsApi(this.apiClient);
        this.customObjectRecords = new CustomObjectRecordsApi(this.apiClient);
        this.customPaymentMethodTypes = new CustomPaymentMethodTypesApi(this.apiClient);
        this.customScheduledEvents = new CustomScheduledEventsApi(this.apiClient);
        this.dataBackfill = new DataBackfillApi(this.apiClient);
        this.dataLabeling = new DataLabelingApi(this.apiClient);
        this.dataQueries = new DataQueriesApi(this.apiClient);
        this.debitMemos = new DebitMemosApi(this.apiClient);
        this.deliveryAdjustments = new DeliveryAdjustmentsApi(this.apiClient);
        this.describe = new DescribeApi(this.apiClient);
        this.eInvoicing = new EInvoicingApi(this.apiClient);
        this.electronicPaymentsHealth = new ElectronicPaymentsHealthApi(this.apiClient);
        this.files = new FilesApi(this.apiClient);
        this.fulfillments = new FulfillmentsApi(this.apiClient);
        this.hostedPages = new HostedPagesApi(this.apiClient);
        this.imports = new ImportsApi(this.apiClient);
        this.invoiceSchedules = new InvoiceSchedulesApi(this.apiClient);
        this.invoices = new InvoicesApi(this.apiClient);
        this.journalRuns = new JournalRunsApi(this.apiClient);
        this.massUpdater = new MassUpdaterApi(this.apiClient);
        this.metadata = new MetadataApi(this.apiClient);
        this.notifications = new NotificationsApi(this.apiClient);
        this.oAuth = new OAuthApi(this.apiClient);
        this.operations = new OperationsApi(this.apiClient);
        this.orderActions = new OrderActionsApi(this.apiClient);
        this.orderLineItems = new OrderLineItemsApi(this.apiClient);
        this.orders = new OrdersApi(this.apiClient);
        this.paymentAuthorization = new PaymentAuthorizationApi(this.apiClient);
        this.paymentGatewayReconciliation = new PaymentGatewayReconciliationApi(this.apiClient);
        this.paymentGateways = new PaymentGatewaysApi(this.apiClient);
        this.paymentMethodSnapshots = new PaymentMethodSnapshotsApi(this.apiClient);
        this.paymentMethodTransactionLogs = new PaymentMethodTransactionLogsApi(this.apiClient);
        this.paymentMethodUpdater = new PaymentMethodUpdaterApi(this.apiClient);
        this.paymentMethods = new PaymentMethodsApi(this.apiClient);
        this.paymentRuns = new PaymentRunsApi(this.apiClient);
        this.paymentSchedules = new PaymentSchedulesApi(this.apiClient);
        this.paymentTransactionLogs = new PaymentTransactionLogsApi(this.apiClient);
        this.payments = new PaymentsApi(this.apiClient);
        this.prepaidWithDrawdown = new PrepaidWithDrawdownApi(this.apiClient);
        this.productChargeDefinitions = new ProductChargeDefinitionsApi(this.apiClient);
        this.productRatePlanChargeTiers = new ProductRatePlanChargeTiersApi(this.apiClient);
        this.productRatePlanCharges = new ProductRatePlanChargesApi(this.apiClient);
        this.productRatePlanDefinitions = new ProductRatePlanDefinitionsApi(this.apiClient);
        this.productRatePlans = new ProductRatePlansApi(this.apiClient);
        this.products = new ProductsApi(this.apiClient);
        this.rsaSignatures = new RsaSignaturesApi(this.apiClient);
        this.ramps = new RampsApi(this.apiClient);
        this.ratePlans = new RatePlansApi(this.apiClient);
        this.refunds = new RefundsApi(this.apiClient);
        this.regenerate = new RegenerateApi(this.apiClient);
        this.sequenceSets = new SequenceSetsApi(this.apiClient);
        this.settings = new SettingsApi(this.apiClient);
        this.signUp = new SignUpApi(this.apiClient);
        this.subscriptions = new SubscriptionsApi(this.apiClient);
        this.summaryJournalEntries = new SummaryJournalEntriesApi(this.apiClient);
        this.taxationItems = new TaxationItemsApi(this.apiClient);
        this.usage = new UsageApi(this.apiClient);
        this.workflows = new WorkflowsApi(this.apiClient);
        this.zuoraRevenueIntegration = new ZuoraRevenueIntegrationApi(this.apiClient);
    }

}
