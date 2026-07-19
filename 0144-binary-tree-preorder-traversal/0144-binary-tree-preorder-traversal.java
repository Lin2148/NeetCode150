/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        
        List<Integer> list = new ArrayList<>(); 
        return dfs(root, list);
    }

    private List<Integer> dfs(TreeNode node, List<Integer> list){
        if (node != null){
            list.add(node.val);
            dfs(node.left, list);
            dfs(node.right, list);
        }
        return list;
    }
}