package src.atlassian.commodityPricing.pricingEngine;

import java.util.*;

public class TreeSetRunningCommodityPrice implements IRunningCommodityPrice {
    TreeSet<int[]> maxPriceStack;
    Map<Integer, int[]> timePriceMap;

    public TreeSetRunningCommodityPrice() {
        maxPriceStack = new TreeSet<>((a,b) -> b[1] - a[1]); // sorted by price
        timePriceMap = new HashMap<>();
    }

//    O(Log N)
    @Override
    public void upsertCommodityPrice(int time, int price) {
        if (timePriceMap.containsKey(time)) {
            int[] timePrice = timePriceMap.get(time);
            maxPriceStack.remove(timePrice);
        }
        int[] newPrice = new int[]{time, price};
        timePriceMap.put(time, newPrice);
        maxPriceStack.add(newPrice);
    }

//    O(Log N)
    @Override
    public int getMaxCommodityPrice() {
        if (maxPriceStack.isEmpty()) {
            return -1;
        }
        return maxPriceStack.first()[1];
    }
}
