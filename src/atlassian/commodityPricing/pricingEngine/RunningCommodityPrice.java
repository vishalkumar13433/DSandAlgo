package src.atlassian.commodityPricing.pricingEngine;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class RunningCommodityPrice implements IRunningCommodityPrice {
    PriorityQueue<int[]> pq;
    Map<Integer, int[]> timePriceMap;

    public RunningCommodityPrice() {
        pq = new PriorityQueue<>((a,b) -> b[1] - a[1]);
        timePriceMap = new HashMap<>();
    }

    // O(N)
    @Override
    public void upsertCommodityPrice(int time, int price) {
        if (timePriceMap.containsKey(time)) {
            pq.remove(timePriceMap.get(time));
        }
        int[] newPrice = new int[]{time, price};
        timePriceMap.put(time, newPrice);
        pq.offer(newPrice);
    }

    // O(1)
    @Override
    public int getMaxCommodityPrice() {
        if (pq.isEmpty()) {
            return -1;
        }
        return pq.peek()[1];
    }
}
