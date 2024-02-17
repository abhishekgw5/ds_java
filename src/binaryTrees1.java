import java.util.*;

public class binaryTrees1 {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static class BinaryTree {
        static int index = -1;

        public static Node buildTree(int nodes[]) {
            index++;
            if (nodes[index] == -1) {
                return null;
            }

            Node newNode = new Node(nodes[index]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);

            return newNode;
        }

        public static void preOrder(Node root) {
            if (root == null) {
                return;
            }
            System.out.print(root.data + " ");
            preOrder(root.left);
            preOrder(root.right);
        }

        public static void postOrder(Node root) {
            if (root == null) {
                return;
            }
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.data + " ");
        }

        public static void levelOrder(Node root) {
            if (root == null) {
                return;
            }

            Queue<Node> q = new LinkedList<>();
            q.add(root);
            q.add(null);

            while (!q.isEmpty()) {
                Node currNode = q.remove();
                if (currNode == null) {
                    System.out.println();
                    if (q.isEmpty()) {
                        break;
                    } else {
                        q.add(null);
                    }
                } else {
                    System.out.print(currNode.data + " ");
                    if (currNode.left != null) {
                        q.add(currNode.left);
                    }
                    if (currNode.right != null) {
                        q.add(currNode.right);
                    }
                }
            }
        }

        //kth level
        public static void levelOrder2(Node root,int k_level){
            int level=1;
            if(root==null){
                return;
            }
            Queue<Node> q = new LinkedList<>();
            q.add(root);
            q.add(null);
            while(!q.isEmpty()){
                Node node = q.remove();
                if(node==null){
                    if(q.isEmpty()){
                        break;
                    }else{
                        q.add(null);
                    }
                    level++;
                }else{
                    if(level==k_level){
                            System.out.print(node.data + " ");
                        }
                    if(node.left!=null){
                        q.add(node.left);
                        
                    }
                    if(node.right!=null){
                        q.add(node.right);
                    }
                }
            }
        }

        public static void levelOrder2R(Node root, int level, int k_level){
            if(root==null){
                return;
            }
            if(level==k_level){
                System.out.print(root.data+" ");
                return;
            }

            levelOrder2R(root.left, level+1, k_level);
            levelOrder2R(root.right,level+1, k_level);
        }
    } 

    public static void main(String[] args) {
        //int nodes[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
        //Node root = tree.buildTree(nodes);
        
        Node root = new Node(1);
        root.left = new Node(2);
        root.right=new Node(3);
        root.left.left=new Node(4);
        root.left.right=new Node(5);
        root.right.right=new Node(6);
        BinaryTree tree = new BinaryTree();
        
        // System.out.println(root.data);
        // tree.preOrder(root);
        // System.out.println();
        // tree.postOrder(root);
        //tree.levelOrder(root);
        //tree.levelOrder2(root, 3);
        tree.levelOrder2R(root, 1, 3);
    }
}
