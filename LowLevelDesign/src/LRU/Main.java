package LRU;

public class Main {
    public static void main(String[] args) {
        LRUCache lru = new LRUCache(2);

        lru.put(1,101);
        lru.put(2,201);

        System.out.println("Key 1 : "+lru.get(1));

        lru.put(3, 301);

        System.out.println("Key 1 : "+lru.get(1));

    }
}

/*

1 - LRU
2 - MRU

GET - Interaction : 1

1 - MRU
2 - LRU

ADD
remove LRU : 2

1 - LRU
3 - MRU

*/
