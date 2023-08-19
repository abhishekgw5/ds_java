//using linkedlist
public class stack2 {
    static Node head;

    private static class Node{
        private int val;
        private Node next;

        private Node(int val){
            this.val = val;
            // this.next=null;
        }

        // private Node(int val,Node next){
        //     this.val=val;
        //     this.next=next;
        // }
    }

    static class Stack{
        
        public static boolean isEmpty(){
            return head==null;
        }

        public static void push(int val) {
            Node newNode = new Node(val);
            if(isEmpty()){
                head=newNode;
                return;
            }
            newNode.next = head;
            head = newNode;
        }

        public static int pop(){
            if(isEmpty()){
                return -1;
            }
            int n = head.val;
            head=head.next;
            return n;
        }

        public static int peek(){
            if(isEmpty()){
                return -1;
            }
            return head.val;
        }
    }

    public static void main(String[] args) {
        Stack s = new Stack();
        s.push(1);
        s.push(2);
        s.push(3);
        
        while(!s.isEmpty()){
            System.out.println(s.peek());
            s.pop();
        }
    }
}
