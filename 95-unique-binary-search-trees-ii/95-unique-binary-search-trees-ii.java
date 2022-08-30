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
//Refer Notes
class Solution {
    public List<TreeNode> generateTrees(int n) {
        if(n == 0) return new ArrayList<>();
        
      return helper(1, n);  
    }
    
    private List<TreeNode> helper(int start, int end){
        List<TreeNode> res = new ArrayList<>();
        
        if(start > end) res.add(null);
        else{
            for(int i = start; i <= end; i++){
                List<TreeNode> leftSubT = helper(start, i - 1);
                List<TreeNode> rightSubT = helper(i + 1, end);
                
                for(TreeNode left : leftSubT){
                    for(TreeNode right : rightSubT){
                        TreeNode root = new TreeNode(i);
                        root.left = left;
                        root.right = right;
                        res.add(root);
                    }
                }
            }
        }
        
        return res;
    }
}