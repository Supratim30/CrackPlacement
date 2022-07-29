//leetcode 257

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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> a = new ArrayList<>();
        addPath(a, root, "");
        return a;
    }
    private void addPath(List<String> ans, TreeNode root, String s){
        if(root.left == null && root.right == null) ans.add(s + root.val);
        
        if(root.left != null) addPath(ans, root.left, s + root.val + "->");
        if(root.right != null) addPath(ans, root.right, s + root.val + "->");

    }
}
