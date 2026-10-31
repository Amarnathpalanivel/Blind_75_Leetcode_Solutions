import javax.swing.tree.TreeNode;

public class Subtree_of_Another_Tree {
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
      private static final long FNV_OFFSET =
        0xcbf29ce484222325L;
    private static final long MIX_CONSTANT =
        0x9e3779b97f4a7c15L;
    private static final long NULL_HASH =
        911382323L;
    private long combineHash(
        long hashValue,
        long value
    ) {
        hashValue ^=
            value +
            MIX_CONSTANT +
            (hashValue << 6) +
            (hashValue >>> 2);

        return hashValue;
    }
    private long getHash(TreeNode root) {
        if (root == null) {
            return NULL_HASH;
        }
        long leftHash =
            getHash(root.left);
        long rightHash =
            getHash(root.right);
        long hashValue = FNV_OFFSET;
        hashValue =
            combineHash(hashValue, root.val);
        hashValue =
            combineHash(hashValue, leftHash);
        hashValue =
            combineHash(hashValue, rightHash);
        return hashValue;
    }
    private boolean isSameTree(
        TreeNode first,
        TreeNode second
    ) {
        if (first == null && second == null) {
            return true;
        }
        if (
            first == null ||
            second == null ||
            first.val != second.val
        ) {
            return false;
        }
        return isSameTree(first.left, second.left) &&
               isSameTree(first.right, second.right);
    }
    private long search(
        TreeNode root,
        TreeNode subRoot,
        long targetHash,
        boolean[] found
    ) {
        if (root == null) {
            return NULL_HASH;
        }
        long leftHash =
            search(
                root.left,
                subRoot,
                targetHash,
                found
            );
        long rightHash =
            search(
                root.right,
                subRoot,
                targetHash,
                found
            );
        long hashValue = FNV_OFFSET;
        hashValue =
            combineHash(hashValue, root.val);
        hashValue =
            combineHash(hashValue, leftHash);
        hashValue =
            combineHash(hashValue, rightHash);
        if (
            !found[0] &&
            hashValue == targetHash &&
            isSameTree(root, subRoot)
        ) {
            found[0] = true;
        }
        return hashValue;
    }
    public boolean isSubtree(
        TreeNode root,
        TreeNode subRoot
    ) {
        if (subRoot == null) {
            return true;
        }
        if (root == null) {
            return false;
        }
        long targetHash =
            getHash(subRoot);
        boolean[] found = {false};
        search(
            root,
            subRoot,
            targetHash,
            found
        );
        return found[0];
}
}
}
