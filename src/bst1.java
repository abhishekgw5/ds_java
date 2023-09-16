import java.util.*;

public class bst1 {
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

    public static Node insert(Node root, int val){
        if(root==null){
            root = new Node(val);
            return root;
        }

        if(val>root.data){
            root.right = insert(root.right, val);
        }else{
            root.left = insert(root.left, val);
        }
        return root;
    }

    public static void inOrder(Node root){
        if(root==null){
            return;
        }
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);

    }

    public static boolean search(Node root,int val){
        if(root==null){
            return false;
        }
        
        if(root.data==val){
            return true;
        }
        if(root.data>val){
            return search(root.left, val);
        }else {
            return search(root.right, val);
        }
    }

    //inOrderSuccessor of root is leftmost node of right subtree
    public static Node inOrderSuccessor(Node root){
        while(root.right!=null){
            root = root.left;
        }
        return root;
    }

    public static Node delete(Node root,int val){
        if(root.data<val){
            root.right = delete(root.right, val);
        }
        else if(root.data>val){
            root.left = delete(root.left, val);
        }else{
            if(root.left == null && root.right==null){
                return null;
            }

            if(root.right==null){
                return root.left;
            }else if(root.left==null){
                return root.right;
            }

            Node IS = inOrderSuccessor(root.right);
            root.data = IS.data;
            root.right = delete(root.right, IS.data);
        }
        return root;
    }
    
    //print in range between k1 and k2
    public static void printRange(Node root, int k1,int k2){
        if(root==null){
            return;
        }
        if(root.data>=k1 && root.data<=k2){
            printRange(root.left, k1, k2);
            System.out.print(root.data + " ");
            printRange(root.right, k1, k2);
        }
        else if(root.data < k1){
            printRange(root.left, k1, k2);
        }
        else{
            printRange(root.right, k1, k2);
        }
    }

    public static void printPath(ArrayList<Integer> a){
        for(int i=0;i<a.size();i++){
            System.out.print(a.get(i)+" ");
        }
        System.out.print("->NULL");
        System.out.println();
    }

    //print root to leaf
    public static void printRootToLeaf(Node root,ArrayList<Integer> path){
        if(root==null){
            return;
        }

        path.add(root.data);
        if(root.left==null && root.right==null){
            printPath(path);
        }

        printRootToLeaf(root.left, path);
        printRootToLeaf(root.right, path);
        path.remove(path.size()-1);
    }

    //validate bst
    public static boolean isValid(Node root, Node min, Node max){
        if(root==null){
            return true;
        }

        if(min!=null && root.data<=min.data){
            return false;
        }
        else if(max!=null && root.data>=max.data){
            return false;
        }

        return isValid(root.left, min, root) && isValid(root.right, root, max);

    }

    //mirror bst
    public static Node createMirror(Node root){
        if(root==null){
            return null;
        }

        Node leftMirror = createMirror(root.left);
        Node rightMirror = createMirror(root.right);

        root.left=rightMirror;
        root.right=leftMirror;
        return root;
    }
    
    public static void main(String[] args) {
        int values[] = {8,5,3,1,4,6,10,11,14};
        //int values[] = {1,1,1};
        Node root=null;

        for(int i=0;i<values.length;i++){
            root = insert(root, values[i]);
        }
        inOrder(root);
        System.out.println();
        // System.out.println(search(root, 9));

        //delete(root, 5);
        //inOrder(root);
        //printRange(root, 5, 12);
        //printRootToLeaf(root, new ArrayList<>());
        System.out.println(isValid(root, null, null));
    }
}
