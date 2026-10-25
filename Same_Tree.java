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
     static class NodePair {
        TreeNode first;
        TreeNode second;
 
        NodePair(TreeNode first, TreeNode second) {
            this.first = first;
            this.second = second;
        }
    }
    public boolean isSameTree(TreeNode p, TreeNode q) {
        Deque<NodePair> stack = new ArrayDeque<>();
        stack.push(new NodePair(p, q));
        while (!stack.isEmpty()) {
            NodePair pair = stack.pop();
            TreeNode nodeP = pair.first;
            TreeNode nodeQ = pair.second;
            if (nodeP == null && nodeQ == null) {
                continue;
            }
            if (nodeP == null || nodeQ == null) {
                return false;
            }
            if (nodeP.val != nodeQ.val) {
                return false;
            }
            stack.push(
                new NodePair(
                    nodeP.right,
                    nodeQ.right
                )
            );
            stack.push(
                new NodePair(
                    nodeP.left,
                    nodeQ.left
                )
            );
        }
        return true;
    }
}