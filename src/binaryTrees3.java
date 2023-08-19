import java.util.*;

public record binaryTrees3() {
    static int min = 0;
    static int max = 0;

    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static class Info {
        Node node;
        int hd; //horizontal distance

        public Info(Node node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }

    public static void topView(Node root) {
        HashMap<Integer, Node> map = new HashMap<>();
        Queue<Info> q = new LinkedList<>();
        q.add(new Info(root, 0));
        q.add(null);
        
        while (q != null) {
            Info nodeInfo = q.remove();
            if (nodeInfo == null) {
                if (q.isEmpty()) {
                    break;
                } else {
                    q.add(null);
                }
            } else {
                if (!map.containsKey(nodeInfo.hd)) {
                    map.put(nodeInfo.hd, nodeInfo.node);
                }

                if (nodeInfo.node.left != null) {
                    q.add(new Info(nodeInfo.node.left, nodeInfo.hd - 1));
                    min = Math.min(min, nodeInfo.hd - 1);
                }

                if (nodeInfo.node.right != null) {
                    q.add(new Info(nodeInfo.node.right, nodeInfo.hd + 1));
                    max = Math.max(max, nodeInfo.hd + 1);
                }
            }

        }
        
        for (int i = min; i <= max; i++) {
            System.out.print(map.get(i).data + " ");
        }
        System.out.println();
    }

    //lowest common ancestor
    public static boolean getPath(Node root, int n, ArrayList<Node> path){
        if(root==null){
            return false;
        }
        path.add(root);

        if(root.data==n){
            return true;
        }
        boolean foundLeft = getPath(root.left, n, path);
        boolean foundRight = getPath(root.right, n, path);

        if(foundLeft || foundRight){
            return true;
        }
        path.remove(path.size()-1);
        return false;
    }

    public static Node lca(Node root, int n1, int n2){
        ArrayList<Node> path1 = new ArrayList<>();
        ArrayList<Node> path2 = new ArrayList<>();

        getPath(root,n1,path1);
        getPath(root,n2,path2);
        
        // for(int i=0;i<path1.size();i++){
        //     System.out.print(path1.get(i).data + " ");
        // }
        // for(int i=0;i<path2.size();i++){
        //     System.out.print(path2.get(i).data + " ");
        // }
        int i=0;
        for(i=0;i<path1.size() && i<path2.size();i++){
            if(path1.get(i)!=path2.get(i)){
                break;
            }
        }

        Node lca = path1.get(i-1);
        return lca;
    }

    //recurssive approach
    public static Node lca2(Node root,int n1,int n2){
        if(root==null||root.data==n1||root.data==n2){
            return root;
        }

        Node leftLca = lca2(root.left, n1, n2);
        Node rightLca = lca2(root.right, n1, n2);

        if(rightLca==null){
            return leftLca;
        }
        if(leftLca==null){
            return rightLca;
        }
        return root;
    }

    //distance between two nodes
    public static int lcaDist(Node root, int n1){
        if(root==null){
            return -1;
        }
        if(root.data==n1){
            return 0;
        }

        int lcaDist1 = lcaDist(root.left, n1);
        int lcaDist2 = lcaDist(root.right, n1);

        if(lcaDist1==-1 && lcaDist2==-1){
            return -1;
        }else if(lcaDist2==-1){
            return lcaDist1+1;
        }else{
            return lcaDist2+1;
        }

    }

    //minimum distance between nodes
    public static int minDist(Node root, int n1,int n2){
        Node lca = lca2(root, n1, n2);

        int dist1 = lcaDist(lca,n1);
        int dist2 = lcaDist(lca,n2);

        return dist1 + dist2;

    }

    //kth ancestor of node
    public static int ktha1(Node root,int n,int k){
        ArrayList<Node> a = new ArrayList<>();

        getPath(root, n, a);
        return a.get(a.size() - k-1).data;
    }
    
    //kth ancestor of node recurssive
    public static int ktha(Node root,int n,int k){
        if(root==null){
            return -1;
        }
        if(root.data==n){
            return 0;
        }
        
        int leftDist = ktha(root.left,n,k);
        int rightDist = ktha(root.right,n,k);

        if(leftDist==-1 && rightDist==-1){
            return -1;
        }
        int max= Math.max(leftDist,rightDist);
        if(max+1==k){
            System.out.println(root.data);
        }
        return max+1;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        //topView(root);
        //System.out.println(lca(root,4,5).data);
        //System.out.println(lca2(root,4,5).data);
        //System.out.println(minDist(root, 2, 7));
        ktha(root, 5, 2);
        System.out.println(ktha1(root,5,2));
        
    }
}
