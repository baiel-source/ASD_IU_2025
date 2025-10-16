package structures;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class LRUCache {
    private int capacity;
    private Map<Integer, LinkedListNode> cache;
    private LinkedList<LinkedListNode> lruList;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>();
        lruList = new LinkedList<>();
    };

    /**
     * Получение значения по ключу из кэша
     */
    public int get(int key) {
        if (cache.containsKey(key)) {
            LinkedListNode node = cache.get(key);
            lruList.remove(node);
            lruList.addFirst(node);
            return node.value;
        };
        return -1;
    };

    /**
     * Обновление элемента в кэше.
     * Если ключ в кэше уже есть, обновляется его значение и перемещается в начало списка.
     * Если нет и кэш достиг максимальной вместимости, вытесняется значение, которое давно не запрашивалось.
     */
    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            LinkedListNode node = cache.get(key);
            lruList.remove(node);
            node.value = value;
            lruList.addFirst(node);
        } else {
            if (cache.size() >= capacity) {
                // Чем дальше элемент от начала списка, тем давнее он в последний раз запрашивался
                LinkedListNode node = lruList.removeLast();
                cache.remove(node.key);
            };
            LinkedListNode node = new LinkedListNode(key, value);
            lruList.add(node);
            cache.put(key, node);
        };
    };

    public void putToHead(LinkedListNode node) {
        lruList.addFirst(node);
    };

    public void remove(LinkedListNode node) {
        lruList.remove(node);
    };

};
