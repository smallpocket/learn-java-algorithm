package niuke.sword.offerII;

import java.util.ArrayList;

/**
 * @author Heper
 * @title
 * @date 2019/3/10 20:53
 */
public class FindPath {
    ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    ArrayList<Integer> temp = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if (root == null) {
            return res;
        }
        dfs(root, target);
        return res;
    }

    public void dfs(TreeNode root, int target) {
        if (root == null) {
            return;
        }
        target = target - root.val;
        temp.add(root.val);
        if (target == 0 && root.left == null && root.right == null) {
            res.add(new ArrayList<>(temp));
        }
        dfs(root, target);
        dfs(root, target);
        temp.remove(temp.size() - 1);
    }
}
