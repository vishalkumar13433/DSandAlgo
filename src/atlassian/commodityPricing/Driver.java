package src.atlassian.commodityPricing;

import src.atlassian.commodityPricing.pricingEngine.IRunningCommodityPrice;
import src.atlassian.commodityPricing.pricingEngine.RunningCommodityPrice;
import src.atlassian.commodityPricing.pricingEngine.TreeSetRunningCommodityPrice;

public class Driver {
    public static void main(String[] args) {
//        IRunningCommodityPrice r = new RunningCommodityPrice();
        IRunningCommodityPrice r = new TreeSetRunningCommodityPrice();
        r.upsertCommodityPrice(4,27);
        r.upsertCommodityPrice(6,26);
        r.upsertCommodityPrice(9,25);
        System.out.println(r.getMaxCommodityPrice());
        r.upsertCommodityPrice(4,28);
        System.out.println(r.getMaxCommodityPrice());
        r.upsertCommodityPrice(4,23); // test case to remember.. reducing the max commodity price in future
        System.out.println(r.getMaxCommodityPrice());
    }
}
