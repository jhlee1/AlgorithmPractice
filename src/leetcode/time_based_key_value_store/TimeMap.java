package leetcode.time_based_key_value_store;

import java.util.*;

class TimeMap {
    Map<String, Map<Integer, String>> map;
    Map<String, List<Integer>> prevTimes;
    public TimeMap() {
        map = new HashMap<>();

    }

    public void set(String key, String value, int timestamp) {
        map.putIfAbsent(key, new HashMap<>());
        prevTimes.putIfAbsent(key, new ArrayList<>());
        map.get(key).put(timestamp, value);
        prevTimes.get(key).add(timestamp);
    }

    public String get(String key, int timestamp) {
        if (map.get(key).containsKey(timestamp)) {
            return map.get(key).get(timestamp);
        }

        int index = Collections.binarySearch(prevTimes.get(key), timestamp) * -1 -2;

        return map.get(key).get(index);
    }

}
