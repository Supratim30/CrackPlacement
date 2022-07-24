//leetcode 938

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
    public int rangeSumBST(TreeNode root, int low, int high) {
        if(root==null)
            return 0;
        Queue<TreeNode>q= new LinkedList<>();
        q.add(root);
        int sum=0;
        while(!q.isEmpty()){
         
    TreeNode curr=q.remove();
     if(curr.val>=low && curr.val<=high)
         sum+=curr.val;
     if(curr.left!=null && curr.val>low )
         q.add(curr.left);
     if(curr.right!=null && curr.val<high)
         q.add(curr.right);
 
        }
        return sum;
    }
    
}
