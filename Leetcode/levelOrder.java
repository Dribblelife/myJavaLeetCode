package Leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class levelOrder {
    public List<List<Integer>> levelOrder(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        List<List<Integer>> result = new LinkedList<>();
        if (root == null) return result;
        queue.offer(root);
        while (!queue.isEmpty()){
            int levelNum = queue.size();
            List<Integer> subList = new LinkedList<Integer>();
            for (int i=0; i<levelNum ;i++){
                if (queue.peek().left!=null) queue.offer(queue.peek().left);
                if (queue.peek().right!=null) queue.offer(queue.peek().right);
                subList.add(queue.poll().val);
            }
            result.add(subList);
        }
        return result;
    }
}
