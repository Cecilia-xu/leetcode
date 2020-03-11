// Solution 1: iteration
// Time complexity: O(n). 
// Space complexity: O(n). 
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            ArrayList<Integer> levelRes = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
                levelRes.add(node.val);
            }
            res.add(levelRes);
        }
        return res;
    }
}
// Solution 2: Recursion
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    private List<List<Integer>> res = new ArrayList<>();
    
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return res;
        }
        levelOrderTraversal(root, 0);
        return res;
    }
    
    private void levelOrderTraversal(TreeNode root, int level) {
        if (res.size() == level) {
            res.add(new ArrayList<Integer>());
        }
        res.get(level).add(root.val);
        if (root.left != null) {
            levelOrderTraversal(root.left, level + 1);
        }
        if (root.right != null) {
            levelOrderTraversal(root.right, level + 1);
        }
    }
}
