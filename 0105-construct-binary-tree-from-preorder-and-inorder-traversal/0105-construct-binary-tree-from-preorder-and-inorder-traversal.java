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
    private Map<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        if (n == 0){
            return null;
        }
        if (n == 1){
            return new TreeNode(preorder[0]);
        }

        // find root idx
        for (int i = 0; i < n; i++) {
            map.put(inorder[i], i);
        }
        return dfs(preorder, 0, n - 1, 0, n - 1);
    }
        private TreeNode dfs(int[] preorder, int preStart, int preEnd, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }
        int rootVal = preorder[preStart];
        TreeNode root = new TreeNode(rootVal);

        int rootIdx = map.get(rootVal);

        // found root idx
        root.left = dfs(preorder, preStart+1, preStart+rootIdx-inStart, inStart, rootIdx - 1);

        root.right = dfs(preorder, preStart+rootIdx-inStart +1, preEnd, rootIdx+1, inEnd);
        return root;
    }
}