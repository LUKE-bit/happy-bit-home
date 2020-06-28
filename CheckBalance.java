class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;
    public TreeNode(int val) {
        this.val = val;
    }
}
public class CheckBalance {
    public boolean isBalance(TreeNode root) {
        if (root==null) return true;
        int left = height(root.left);
        int right = height(root.right);
        return Math.abs(left - right) <= 1;
    }

    private int height(TreeNode root) {
        if (root == null) return 0;
        return Math.max(height(root.left),height(root.right)) + 1;
    }
}
