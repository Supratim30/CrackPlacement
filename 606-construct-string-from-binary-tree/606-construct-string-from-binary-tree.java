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
//use a helper to add into the string builder
class Solution {
    StringBuilder sb;
    public String tree2str(TreeNode root) {
        sb = new StringBuilder();
        helper(root);
        return sb.toString();
    }
    private void helper(TreeNode node){
        if(node  == null) return;
        if(node.left == null && node.right == null){
            sb.append(node.val);
            return;
        }
        sb.append(node.val);
        sb.append('(');
        helper(node.left);
        sb.append(')');
        if(node.right != null){
            sb.append('(');
            helper(node.right);
            sb.append(')');
        }
        return;
    }
}