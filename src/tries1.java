public class tries1 {
    static class Node{
        Node child[] = new Node[26];
        boolean eow = false; //end of word

        Node(){
            for(int i=0;i<26;i++){
                child[i]=null;
            }
        }
    }

    public static Node root = new Node();

    public static void insert(String word){
        Node curr = root;
        for(int level=0;level<word.length();level++){
            int idx = word.charAt(level) - 'a';
            if(curr.child[idx]==null){
                curr.child[idx]=new Node();
            }
            curr=curr.child[idx];
        }

        curr.eow=true;
    }

    public static boolean search(String word){
        Node curr = root;
        for(int level=0;level<word.length();level++){
            int idx = word.charAt(level)-'a';
            if(curr.child[idx]==null){
                return false;
            }
            curr=curr.child[idx];
        }

        return curr.eow==true;
    }
    
    public static void main(String[] args) {
        String words[] = {"the", "a", "there", "their","thee"};
        for(int i=0;i<words.length;i++){
            insert(words[i]);
        }

        System.out.println(search("theei"));
    }
}
