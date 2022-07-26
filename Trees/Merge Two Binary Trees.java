//leetcode 617
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
//RECURSIVE
class Solution {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if(root1==null && root2==null) return null;
        if(root1 == null) return root2;
        if(root2 == null) return root1;
        
        root1.val += root2.val;
        
        root1.left = mergeTrees(root1.left, root2.left);
        root1.right = mergeTrees(root1.right, root2.right);
        
        return root1;
    }
}

//ITERATIVE
class Solution {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if(root1 == null) return root2;
        if(root2 == null) return root1;
        
        Stack<TreeNode[]> st = new Stack<>();
        st.push(new TreeNode[]{root1, root2});
        
        while(!st.isEmpty()){
            TreeNode[] curr = st.pop();
            
            curr[0].val += curr[1].val;
            
            if(curr[0].left == null) curr[0].left = curr[1].left;
            else if(curr[1].left != null) st.push(new TreeNode[]{curr[0].left, curr[1].left});
            
            if(curr[0].right == null) curr[0].right = curr[1].right;
            else if(curr[1].right != null) st.push(new TreeNode[]{curr[0].right, curr[1].right});
        }
        return root1;
    }
}
