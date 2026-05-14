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
    
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        Queue<TreeNode> pq = new LinkedList<>();
        String res = "";
        if (root == null)
            return res;
        pq.offer(root);
        while (!pq.isEmpty()) {
            TreeNode x = pq.poll();
            if (x == null)
                res += "#,";
            else
            {
                res += (x.val) +",";
                pq.offer(x.left);
                pq.offer(x.right);
            }

        }

        System.out.println(res);
        return res;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data=="")
            return null;
        String[] vals= data.split(",");;
        Queue<TreeNode> q = new LinkedList<>();

        TreeNode root = new TreeNode(Integer.parseInt(vals[0]));
        q.offer(root);
        int i = 1;
        while(!q.isEmpty() && i < vals.length)
        {
            TreeNode node = q.poll();
            if (!vals[i].equals("#")) 
            {
                TreeNode left = new TreeNode(Integer.parseInt(vals[i]));
                node.left = left;
                q.offer(left); 
            }
            i++;
            if (i >= vals.length) 
                break;
            if (!vals[i].equals("#")) 
            {
                TreeNode right = new TreeNode(Integer.parseInt(vals[i]));
                node.right = right;
                q.offer(right); 
            }
            i++;
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;