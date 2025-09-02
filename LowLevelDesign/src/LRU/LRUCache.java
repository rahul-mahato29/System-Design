package LRU;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    int capacity;
    Map<Integer, Node> map;
    DoublyLinkedList dll;

    public LRUCache(int capacity){
        this.capacity = capacity;
        //todo
        this.map = new HashMap<>();
        this.dll = new DoublyLinkedList();
    }

    //put method
    public void put(int key, int val) {
        if(map.containsKey(key)) {
            Node node = map.get(key);
            node.V = val;

            //recent-interaction : moveToFront
            dll.moveToFront(node);
        }
        else {
            if(map.size() == capacity) {
                Node lru = dll.removeLast();
                if(lru != null) map.remove(lru.K);
            }

            Node newNode = new Node(key, val);
            dll.addNode(newNode);
            map.put(key, newNode);
        }
    }

    //get method
    public Integer get(int key) {
        Node node = map.get(key);
        dll.moveToFront(node);
        return node.V;

    }
}
