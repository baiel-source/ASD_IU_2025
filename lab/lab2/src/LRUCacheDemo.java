/*
Реализовать «LRU Cache» — кэш с вытеснением на основе связанного
списка и хеш-таблицы. Прокомментировать код.
*/
import structures.LRUCache;

public class LRUCacheDemo {

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(5);
        lruCache.put(1, 10);
        lruCache.put(2, 20);
        lruCache.put(3, 30);
        lruCache.put(4, 40);
        lruCache.put(4, 50);
        lruCache.put(6, 60);
        System.out.println(lruCache.get(4));
    };

};

