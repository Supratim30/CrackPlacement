//leetcode 101
//ITERATIVE
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
//ITERATIVE
class Solution {
    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> q1 = new LinkedList<>();
        Queue<TreeNode> q2 = new LinkedList<>();
        q1.add(root.left);
        q2.add(root.right);
        
        while(!q1.isEmpty() && !q2.isEmpty()){
            TreeNode p = q1.poll();
            TreeNode q  = q2.poll();
            
            if(p==null && q==null) continue;
            
            if(p==null || q == null ||(p.val!=q.val)) return false;
            
            q1.add(p.right);
            q1.add(p.left);
            q2.add(q.left);
            q2.add(q.right);
        }
        return true;
    }
}

//RECURSIVE
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return false;
        
       return helper(root.left, root.right);
    }
    
    private boolean helper(TreeNode left, TreeNode right){
        if(left == null || right == null) return left == right;
        
        if(left.val != right.val) return false;
        
        return helper(left.left, right.right) && helper(left.right, right.left);
    }
}
