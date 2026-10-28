/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
private void serializeHelper(
        TreeNode root,
        StringBuilder data
    ) {
        if (root == null) {
            data.append("#,");
            return;
        }
        data.append(root.val).append(",");
        serializeHelper(root.left, data);
        serializeHelper(root.right, data);
    }
    private TreeNode deserializeHelper(
        String[] tokens,
        int[] index
    ) {
        if (tokens[index[0]].equals("#")) {
            index[0]++;
            return null;
        }
        TreeNode root = new TreeNode(
            Integer.parseInt(tokens[index[0]++])
        );
        root.left = deserializeHelper(tokens, index);
        root.right = deserializeHelper(tokens, index);
        return root;
    }
    public String serialize(TreeNode root) {
         StringBuilder data = new StringBuilder();
        serializeHelper(root, data);
        return data.toString();
    }
    public TreeNode deserialize(String data) {
        String[] tokens = data.split(",");
        int[] index = {0};
        return deserializeHelper(tokens, index);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));