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
    public boolean isValidBST(TreeNode root) {
        return checker(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    private boolean checker(TreeNode root, long start, long end){
        if(root == null) return true;
        
        if(root.val > start && root.val < end) return checker(root.left, start, root.val) && checker(root.right, root.val, end);
            
            return false;
    }
}