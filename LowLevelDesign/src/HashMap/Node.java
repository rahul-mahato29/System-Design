package HashMap;

public class Node {
    Integer key;
    String value;
    Node next;

    public Node(Integer k, String v) {
        this.key = k;
        this.value = v;
        next = null;
    }

    public void setKey(Integer key) {
        this.key = key;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getKey() {
        return key;
    }


    public String  getValue() {
        return value;
    }
}

