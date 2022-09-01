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
    int count = 0;

    public int goodNodes(TreeNode root) {
        return counter(root, Integer.MIN_VALUE);
    }

    private int counter(TreeNode node, int max) {
        if (node == null) return 0;
//compare with previous max value
        if (node.val >= max) count++;

        counter(node.left, Math.max(node.val, max));
        counter(node.right, Math.max(node.val, max));

        return count;
    }
}
