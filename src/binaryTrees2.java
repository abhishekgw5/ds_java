
public class binaryTrees2 {
    // static int count=0;
    static class Node{
        Node right;
        Node left;
        int data;

        Node(int data){
            this.data = data;
            this.left=null;
            this.right=null;
        }
    }

    public static int height(Node root){
        if(root==null){
            return 0;
        }
        
        int h1 = height(root.left);
        int h2 = height(root.right);
        return Math.max(h1,h2) + 1;
    }

    public static int noOfNodes(Node root){
        if(root==null){
            return 0;
        }

        int leftCount = noOfNodes(root.left);
        int rightCount = noOfNodes(root.right);
        return leftCount + rightCount + 1;
        // count++;
        // noOfNodes(root.left);
        // noOfNodes(root.right);

        // return count;
    }

    //diameter is longest distance between nodes
    public static int diameter(Node root){ //O(N^2)
        if(root==null){
            return 0;
        }

        int leftD = diameter(root.left);
        int leftH = height(root.left);
        int rightD = diameter(root.right);
        int rightH = height(root.right);

        int selfD = leftH + rightH + 1;

        return Math.max(selfD,Math.max(leftD,rightD));
    }

    //O(n) approach for diameter
    static class Info{
        int diam;
        int ht;
        public Info(int diam,int ht){
            this.diam=diam;
            this.ht=ht;
        }
    }

    public static Info diameter2(Node root){
        if(root==null){
            return new Info(0, 0);
        }
        Info leftInfo = diameter2(root.left);
        Info righInfo = diameter2(root.right);

        int diam = Math.max(Math.max(leftInfo.diam, righInfo.diam), leftInfo.ht + righInfo.ht + 1);
        int ht = Math.max(leftInfo.ht, righInfo.ht) +1;
        return new Info(diam, ht);
    }

    //subtree checking
    public static boolean isIdentical(Node root, Node subroot){
        if(root==null && subroot==null){
            return true;
        }else if(root==null || subroot==null){
            return false;
        }

        if(root.data != subroot.data){
            return false;
        }

        if(!isIdentical(root.left, subroot.left)){
            return false;
        }
        if(!isIdentical(root.right, subroot.right)){
            return false;
        }
        return true;
    }

    public static boolean isSubTree(Node root, Node  subroot){
        
        if(root==null){
            return false;
        }

        if(root.data == subroot.data){
            if(isIdentical(root,subroot)){
                return true;
            }
        }

        return isSubTree(root.left, subroot) || isSubTree(root.right, subroot);
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right=new Node(3);
        root.left.left=new Node(4);
        root.left.right=new Node(5);
        root.right.right=new Node(6);

        // System.out.println(height(root));
        // System.out.println(noOfNodes(root));
        // System.out.println(diameter(root));

        //System.out.println(diameter2(root).diam);

        Node subroot = new Node(2);
        subroot.left = new Node(4);
        subroot.right = new Node(5);

        System.out.println(isSubTree(root, subroot));

    }

   
}
