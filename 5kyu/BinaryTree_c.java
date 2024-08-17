/*
 Your task is to return the list with elements from tree sorted by levels, 
 which means the root element goes first, then root children (from left to right) are second and third, and so on.

Return empty list if root is 'null'.

Example 1 - following tree:

                 2
            8        9
          1  3     4   5
Should return following list:

[2,8,9,1,3,4,5]
Example 2 - following tree:

                 1
            8        4
              3        5
                         7
Should return following list:

[1,8,4,3,5,7]
 */

import java.util.*;

public class BinaryTree_c {

    public static void main(String[] args) {
        System.out.println(treeByLevels(new Node(new Node(null, new Node(null, null, 4), 2),
                new Node(new Node(null, null, 5), new Node(null, null, 6), 3), 1)));
    }

    // public static List<Integer> treeByLevels(Node node) {
    //     if (node == null) return null;
    //     List<Node> level = new ArrayList<>();
    //     List<Node> _level = new ArrayList<>();
    //     List<Integer> res = new ArrayList<>();
    //     level.add(node);
    //     do {
    //         for (Node nd : level){
    //             res.add(nd.value);
    //             if (nd.left != null) _level.add(nd.left);
    //             if (nd.right != null) _level.add(nd.right);
    //         }
    //         level.clear();
    //         level.addAll(_level);
    //         _level.clear();
    //     } while (!level.isEmpty());
    //     return res;
    // }
    public static List<Integer> treeByLevels(Node node) {
        List<Integer> list = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();

        if (node != null) {
            queue.add(node);
        }

        while (!queue.isEmpty()) {
            Node n = queue.remove();
            if (n.left != null) {
                queue.add(n.left);
            }
            if (n.right != null) {
                queue.add(n.right);
            }

            list.add(n.value);
        }

        return list;
    }

    public static class Node {

        public Node left;
        public Node right;
        public int value;

        public Node(Node l, Node r, int v) {
            left = l;
            right = r;
            value = v;
        }
    }
}
