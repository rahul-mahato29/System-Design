package LRU;

public class DoublyLinkedList {
    Node head;
    Node tail;


    public DoublyLinkedList(){
        head = new Node(null, null);
        tail = new Node(null, null);
        head.next = tail;
        tail.prev = head;
    }

    public void addNode(Node node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    public void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public void moveToFront(Node node) {
        removeNode(node);  //remove from last
        addNode(node);     //add in front
    }

    public Node removeLast() {
        if(tail.prev == head) return null;
        Node last = tail.prev;
        removeNode(last);
        return last;
    }
}
