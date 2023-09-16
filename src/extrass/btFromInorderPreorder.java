package extrass;

class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

public class btFromInorderPreorder {
    static int preIndex = 0;

    public static int search(int arr[], int start, int end, int val) {
        int i;
        for (i = start; i <= end; i++) {
            if (arr[i] == val) {
                return i;
            }
        }
        return i;
    }

    public static Node buidTree(int inorder[], int preorder[], int instart, int inend) {
        if (instart > inend) {
            return null;
        }

        Node tnode = new Node(preorder[preIndex++]);

        // no child case
        if (instart == inend) {
            return tnode;
        }

        int inindex = search(inorder, instart, inend, tnode.data);

        tnode.left = buidTree(inorder, preorder, instart, inindex - 1);
        tnode.right = buidTree(inorder, preorder, inindex + 1, inend);
        return tnode;
    }

    public static void printInorder(Node node) {
        if (node == null)
            return;

        /* first recur on left child */
        printInorder(node.left);

        /* then print the data of node */
        System.out.print(node.data + " ");

        /* now recur on right child */
        printInorder(node.right);
    }

    public static void main(String[] args) {
        // int inorder[] = { 3, 9, 20, 15, 7 };
        // int preorder[] = { 9, 3, 15, 20, 7 };
        int inorder[] = { -1 };
        int preorder[] = { -1 };

        int len = inorder.length - 1;
        Node root = buidTree(inorder, preorder, 0, len);
        printInorder(root);
    }
}
