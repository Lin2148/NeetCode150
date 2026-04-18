/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    private Map<Node, Node> visit = new HashMap<>();

    public Node cloneGraph(Node node) {
        if (node == null) return null;
        return dfs(node); 
    }

    private Node dfs(Node node) {
    if (visit.containsKey(node)) return visit.get(node);

    Node newNode = new Node(node.val);
    visit.put(node, newNode);

    for (Node n : node.neighbors) {
        newNode.neighbors.add(dfs(n));
    }
    return newNode;
    }
}