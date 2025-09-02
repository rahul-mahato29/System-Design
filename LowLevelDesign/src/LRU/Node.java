package LRU;

public class Node {
    Integer K;
    Integer V;
    Node prev, next;

    public Node(Integer k, Integer v) {
        K = k;
        V = v;
        prev = next = null;
    }

}
