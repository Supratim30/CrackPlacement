//leetcode 530


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
    //inorder karo
    //uske baad difference b/w elements
    public int getMinimumDifference(TreeNode root) {
            ArrayList<Integer> arr = new ArrayList<>();
        InOrder(root, arr);
int difference = Integer.MAX_VALUE;
        for(int i = 1; i < arr.size(); i++){
            difference = Math.min(difference, arr.get(i) - arr.get(i - 1));
        }
        return difference;
    }
    private void InOrder(TreeNode root, ArrayList<Integer> arr){
        if(root.left != null) InOrder(root.left, arr);
        arr.add(root.val);
        if(root.right != null) InOrder(root.right, arr);
    } 
}
