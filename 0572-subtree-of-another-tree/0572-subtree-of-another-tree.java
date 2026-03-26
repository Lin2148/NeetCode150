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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) return false;

        if (isSame(root,subRoot)) return true;

        return isSubtree(root.right, subRoot) || isSubtree(root.left, subRoot);
    }

    private boolean isSame(TreeNode root, TreeNode subRoot){
        // both null
        if ((root == null) && (subRoot == null)) return true;
        
        // one null
        if ((root == null) || (subRoot == null)) return false;

        // both have val. 
        if (root.val != subRoot.val) return false;

        return isSame(root.right, subRoot.right) && isSame(root.left, subRoot.left);
    }
}