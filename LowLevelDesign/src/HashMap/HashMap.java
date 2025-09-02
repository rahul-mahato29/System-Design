package HashMap;

public class HashMap {
    private static final int INITIAL_SIZE = 1 << 4; //16
    private static final int MAXIMUM_SIZE = 1 << 30;

    Node[] hashTable;   //Array of type node, because each element will be storing node

    //when size is not specified
    public HashMap(){
        hashTable = new Node[INITIAL_SIZE];
    }

    //when size is specified
    public HashMap(int capacity) {
        //todo - check this capacity is present in form of (2 to the power or not) ??
        int tableSize = tableSizeFor(capacity);
        hashTable = new Node[tableSize];
    }

    //Integer - type-conversion (int --> Integer) : hashCode not work directly with primitive data type (int)
    public void put(Integer key, String value) {
        int hashcode = key.hashCode() % hashTable.length;
        Node node = hashTable[hashcode];

        //check at index (hashcode) is already filled
        if(node == null) {
            Node newNode = new Node(key, value);
            hashTable[hashcode] = newNode;
        }
        else {
            Node previousNode = node;
            while(node != null) {

                //if this key already present, then update the current with new value
                if(node.key == key) {
                    node.value = value;
                    return;
                }

                previousNode = node;   //taking the pointer to the last, so that we can insert the newNode at last
                node = node.next;
            }

            //create a new node
            Node newNode = new Node(key, value);
            previousNode.next = newNode;
        }

    }

    public String get(Integer key) {
        int hashcode = key.hashCode() % hashTable.length;
        Node node = hashTable[hashcode];

        while (node != null) {
            if(node.key == key) {
                return node.value;
            }
            node = node.next;
        }

        return null;
    }

    //todo - understand the actual working and why we use it ?
    final int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= MAXIMUM_SIZE) ? MAXIMUM_SIZE : n + 1;
    }
}
