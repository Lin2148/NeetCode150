class LRUCache {

    class Node {
        int key, value;
        Node prev, next;
        Node(int k, int v) {
            this.key = k;
            this.value = v;
        }
    }

    private int capacity;
    private Map<Integer, Node> map;
    private Node head, tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.head = new Node(-1,-1);
        this.tail = new Node(-1,-1);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        Node n = map.get(key);
        moveFront(n);
        return n.value;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)){
            Node n = map.get(key);
            n.value = value;
            moveFront(n);
        }else{
            Node n = new Node(key, value);
            map.put(key, n);
            addFront(n);
        }
        if (map.size() > capacity){
            Node n = removeTail();
            map.remove(n.key);
        }
    }


    private void addFront(Node n){
        n.prev = head;
        n.next = head.next;
        
        head.next.prev = n;    
        head.next = n;


    }

    private void moveFront(Node n){
        n.prev.next = n.next;
        n.next.prev = n.prev;
        
       addFront(n);
    }

    private Node removeTail(){
        Node n = tail.prev;
        n.prev.next = tail;
        tail.prev = n.prev;

        return n;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */