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


//RECURSIVE

class Solution {
    public int rangeSumBST(TreeNode root, int low, int high) {
            int sum = 0;

        if(root == null) return 0;
        if(root.val >= low && root.val <= high){
            sum+= root.val;
        }
        if(root.val < high) sum += rangeSumBST(root.right, low, high);
        if(root.val > low) sum += rangeSumBST(root.left, low, high);
        
        return sum;
    }
}
