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
    private int maxSum;
    public int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        findMaxGain(root);
        return maxSum;
    }
    private int findMaxGain(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftGain = Math.max(0, findMaxGain(root.left));
        int rightGain = Math.max(0, findMaxGain(root.right));
        int currentPath = root.val + leftGain + rightGain;
        maxSum = Math.max(maxSum, currentPath);
        return root.val + Math.max(leftGain, rightGain);
    }
}
