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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        if (n == 0){
            return null;
        }
        if (n == 1){
            return new TreeNode(preorder[0]);
        }

        TreeNode root = new TreeNode(preorder[0]);

        // find root idx
        int rootIdx = 0;
        while(inorder[rootIdx] != root.val){
            rootIdx++;
        }
        // found root idx 
        int[] leftInorder = Arrays.copyOfRange(inorder, 0, rootIdx);
        int[] leftPreorder = Arrays.copyOfRange(preorder, 1, rootIdx+1);

        int[] rightInorder = Arrays.copyOfRange(inorder, rootIdx+1, n);
        int[] rightPreorder = Arrays.copyOfRange(preorder, rootIdx+1, n);

        root.left = buildTree(leftPreorder, leftInorder);
        root.right = buildTree(rightPreorder, rightInorder);
        return root;
    }
}