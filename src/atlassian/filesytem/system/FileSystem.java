package src.atlassian.filesytem.system;

import java.util.*;

public class FileSystem {
    public List<File> files;
    public Map<String, Collection> collections;
    public int totalSize;

    public FileSystem() {
        files = new ArrayList<>();
        collections = new HashMap<>();
        totalSize = 0;
    }

    public int getTotalSize() {
        return totalSize;
    }

    public List<String> topCollectionsBySize(int k) {
        List<String> ans = new ArrayList<>();
        PriorityQueue<Collection> pq = new PriorityQueue<>(k,(a,b) -> b.size - a.size);
        for (String name: collections.keySet()) {
            pq.offer(collections.get(name));
        }

        while(k >0 && !pq.isEmpty()) {
            ans.add(pq.poll().name);
            k--;
        }
        return ans;
    }

    public void addFile(File file, String collectionName) {
        if (collectionName == null) {
            this.files.add(file);
        } else {
           if (!collections.containsKey(collectionName)) {
               Collection newCollection = new Collection(collectionName);
               collections.put(collectionName, newCollection);
           }
           collections.get(collectionName).addFile(file);
        }

        totalSize+=file.size;
    }
}
