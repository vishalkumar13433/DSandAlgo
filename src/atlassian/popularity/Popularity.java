package src.atlassian.popularity;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Popularity implements IPopularity{
    PriorityQueue<Integer> popularContents;
    Map<Integer, Integer> frequencyMap;

    public Popularity() {
        frequencyMap = new HashMap<>();
        popularContents = new PriorityQueue<>((a,b) -> frequencyMap.get(b) - frequencyMap.get(a));
    }

    @Override
    public void increasePopularity(Integer contentId) {
        frequencyMap.put(contentId, 1 + frequencyMap.getOrDefault(contentId, 0));
        popularContents.remove(contentId);
        popularContents.offer(contentId);
    }

    @Override
    public Integer mostPopular() {
        if (popularContents.isEmpty()) {
            return -1;
        }
        return popularContents.peek();
    }

    @Override
    public void decreasePopularity(Integer contentId) {
        if (!frequencyMap.containsKey(contentId)) {
            return;
        }
        int freq = frequencyMap.get(contentId) - 1;
        popularContents.remove(contentId);
        if (freq == 0) {
            frequencyMap.remove(contentId);
        } else {
            frequencyMap.put(contentId, freq);
            popularContents.offer(contentId);
        }
    }
}
