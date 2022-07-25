//leetcode 108

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
// Intuition: The input array is sorted. The middle element in the input array can be a possible candidate for the root of the binary tree, as it will divide the left and right subtree height by NOT more than 1.
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return converter(nums, 0, nums.length - 1);
    }
    public TreeNode converter(int[] nums, int left, int right){
        if(left > right) return null;
        
        int mid = (left+right)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = converter(nums, left, mid - 1);
        root.right = converter(nums, mid + 1, right);
        
        return root;
    }
}
