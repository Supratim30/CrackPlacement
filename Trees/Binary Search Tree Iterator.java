//leetcode 173


class BSTIterator {
    ArrayList<Integer> arr = new ArrayList<>();
    int i = 0;
    public BSTIterator(TreeNode root) {
        inorder(root, arr);
    }
    
    public void inorder(TreeNode root, ArrayList<Integer> arr) {
        if (root == null) return;
        inorder(root.left, arr);
        arr.add(root.val);
        inorder(root.right, arr);
    }
    
    public int next() {
        return arr.get(i++);
    }
    
    public boolean hasNext() {
        return i < arr.size();
    }
}
