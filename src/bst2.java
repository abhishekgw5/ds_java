import java.util.*;
public class bst2 {
    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
            this.left=null;
            this.right=null;
        }
    }

    public static void printInOrder(Node root){
        if(root==null){
            return;
        }
        printInOrder(root.left);
        System.out.print(root.data + " ");
        printInOrder(root.right);
    }

    public static void inOrder(Node root,ArrayList<Integer> a){
        if(root==null){
            return;
        }
        inOrder(root.left, a);
        a.add(root.data);
        inOrder(root.right, a);
    }


    //sorted array to bst
    public static Node sortedArrayToBst(int arr[], int start, int end){
        if(start>end){
            return null;
        }

        int mid = (start+end)/2;
        Node newNode = new Node(arr[mid]);
        newNode.left = sortedArrayToBst(arr, start, mid-1);
        newNode.right = sortedArrayToBst(arr, mid+1, end);
        return newNode;
    }

    //sorted arraylist to bst
    public static Node sortedArrayListToBst(ArrayList<Integer> a, int start, int end){
        if(start>end){
            return null;
        }

        int mid = (start+end)/2;
        Node newNode = new Node(a.get(mid));
        newNode.left = sortedArrayListToBst(a, start, mid-1);
        newNode.right = sortedArrayListToBst(a, mid+1, end);
        return newNode;
    }

    //bst to balanced bst
    public static Node bstToBalancedBst(Node root){
        //first find inorder(it will be sorted) and then apply sorted array to bst function
        ArrayList<Integer> a = new ArrayList<>();
        inOrder(root, a);

        return sortedArrayListToBst(a, 0, a.size()-1);
    }

    //size of largest bst in binary tree
    static class Info {
        boolean isBST;
        int size;
        int min;
        int max;

        public Info(boolean isBST, int size, int min, int max){
            this.isBST=isBST;
            this.size=size;
            this.min=min;
            this.max=max;
        }
    }

    public static int maxBST =0;

    public static Info largestBST(Node root){
        if(root==null){
            return new Info(true, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }

        Info leftInfo = largestBST(root.left); 
        Info rightInfo = largestBST(root.right);
        int size = leftInfo.size + rightInfo.size + 1;
        int min = Math.min(root.data,Math.min(leftInfo.min,rightInfo.min));
        int max = Math.max(root.data,Math.max(leftInfo.max, rightInfo.max));

        if(root.data<=leftInfo.max || root.data>=rightInfo.min){
            return new Info(false, size, min, max);
        }

        if(leftInfo.isBST && rightInfo.isBST){
            maxBST = Math.max(size, maxBST);
            return new Info(true, size, min, max);
        }

        return new Info(false, size, min, max);
    }

    //merge two BSTs
    public static Node mergeBST(Node root1, Node root2){
        ArrayList<Integer> a1 = new ArrayList<>();
        ArrayList<Integer> a2 = new ArrayList<>();
        inOrder(root1, a1);
        inOrder(root2, a2);

        int x=0;
        int y=0;
        ArrayList<Integer> a3 = new ArrayList<>();
        while(x<a1.size() && y<a2.size()){
            if(a1.get(x)<a2.get(y)){
                a3.add(a1.get(x));
                x++;
            }else{
                a3.add(a2.get(y));
                y++;
            }
        }

        while(x<a1.size()){
            a3.add(a1.get(x));
            x++;
        }

        while(y<a2.size()){
            a3.add(a2.get(y));
            y++;
        }
        
        return sortedArrayListToBst(a3, 0, a3.size()-1);
    }

    public static void main(String[] args) {
        //
        // int arr[] = {1,2,3,4,5,6,7,8};
        // Node temp = sortedArrayToBst(arr, 0, arr.length-1);
        // printInOrder(temp);

        //
        // Node root = new Node(8);
        // root.left = new Node(6);
        // root.left.left = new Node(5);
        // root.left.left.left = new Node(3);
        // root.right = new Node(10);
        // root.right.right = new Node(11);
        // root.right.right.right = new Node(13);

        // Node temp = bstToBalancedBst(root);
        // printInOrder(temp);

        // //
        // Node root = new Node(50);
        // root.left = new Node(30);
        // root.left.left = new Node(5);
        // root.left.right = new Node(20);

        // root.right = new Node(60);
        // root.right.left = new Node(45);
        // root.right.right = new Node(70);
        // root.right.right.left = new Node(65);
        // root.right.right.right = new Node(80);

        // Info info = largestBST(root);
        // System.out.println("size = " + maxBST);

        //
        Node root1 = new Node(2);
        root1.left = new Node(1);
        root1.right= new Node(4);

        Node root2 = new Node(9);
        root2.left = new Node(3);
        root2.right = new Node(12);

        Node temp = mergeBST(root1, root2);
        printInOrder(temp);
    }
}
