/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/
class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) return null;

        //  把list轉為 old -> copy -> old-> copy形式
        Node curr = head;
        while (curr != null){
            Node copy = new Node(curr.val);
            copy.next = curr.next;
            curr.next = copy;

            curr = curr.next.next;
        }

        // 調整random
        Node curr2 = head;
        while (curr2 != null){
            if (curr2.random != null){
                curr2.next.random = curr2.random.next;
            }
            curr2 = curr2.next.next;
        }

        // 拆list
        Node old = head;
        Node copy = head.next;
        Node curr3 = copy;
        while (old != null){
            old.next = old.next.next;
            if (curr3.next != null) {
                curr3.next = curr3.next.next;
            } else {
                curr3.next = null; // 到達新串列的終點了
            }
            old = old.next;
            curr3 = curr3.next;
        }
        return copy;
    }
}
/*
class Solution {
    public Node copyRandomList(Node head) {
        Map<Node, Node> map = new HashMap<>();
        Node curr = head;
        //traverse
        while (curr != null){
            map.putIfAbsent(curr, new Node(curr.val));
            
            if (curr.next != null) {
                map.putIfAbsent(curr.next, new Node(curr.next.val));
                map.get(curr).next = map.get(curr.next);
            }

            if (curr.random != null) {
                map.putIfAbsent(curr.random, new Node(curr.random.val));
                map.get(curr).random = map.get(curr.random);
            }

            curr = curr.next;
        }
        return map.get(head);
    }
}
*/