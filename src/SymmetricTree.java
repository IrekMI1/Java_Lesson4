import javax.swing.tree.TreeNode;
import java.util.Stack;

public class SymmetricTree {
    public Boolean isSymmetric(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root.left);
        stack.push(root.right);

        while(!stack.isEmpty()) {
            TreeNode p = stack.pop();
            TreeNode q = stack.pop();
            if (p == null && q == null) {
                continue;
            }

            if ((p == null || q == null) ||
                    (p.val != q.val)) {
                return false;
            }

            stack.push(p.left);
            stack.push(q.right);

            stack.push(p.right);
            stack.push(q.left);
        }

        return true;
    }
}
