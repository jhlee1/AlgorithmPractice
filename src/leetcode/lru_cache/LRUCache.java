package leetcode.lru_cache;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

class LRUCache {
    class Item {
        Item prev;
        Item next;
        int key;
        int value;
        public Item(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private Item head;
    private Item tail;
    private Map<Integer, Item> items;
    private int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        items = new HashMap<>();
    }

    public int get(int key) {
        if (!items.containsKey(key)) {
            return -1;
        }

        Item item = items.get(key);

        if (item != head) {
            if (item == tail) {
                item.prev.next = null;
                tail = item.prev;
            } else {
                item.prev.next = item.next;
                item.next.prev = item.prev;
            }
            head.prev = item;
            item.next = head;
            head = item;
        }

        return item.value;
    }

    public void put(int key, int value) {
        if (items.containsKey(key)) {
            Item item = items.get(key);
            item.value = value;

            if (item != head) {
                if (item == tail) {
                    item.prev.next = null;
                    tail = item.prev;
                } else {
                    item.prev.next = item.next;
                    item.next.prev = item.prev;
                }
                head.prev = item;
                item.next = head;
                head = item;
            }
        } else {
            Item item = new Item(key, value);
            items.put(key, item);

            if (head == null) {
                head = item;
                tail = item;
            } else {
                head.prev = item;
                item.next = head;
                head = item;
            }

            if (items.size() > capacity) {
                items.remove(tail.key);
                tail = tail.prev;
                tail.next = null;
            }
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */