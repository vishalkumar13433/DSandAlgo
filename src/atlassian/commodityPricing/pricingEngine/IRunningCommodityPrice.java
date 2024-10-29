package src.atlassian.commodityPricing.pricingEngine;

public interface IRunningCommodityPrice {
    void upsertCommodityPrice(int time, int price);
    int getMaxCommodityPrice();
}
