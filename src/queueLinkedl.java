public class queueLinkedl {
    static Node head;
    
    public static class Node{
        public Node next;
        public int val;

        Node(int val){
            this.val=val;
        }
    }

    public static class Queue{
        
        public static boolean isEmpty(){
            if(head==null){
                return true;
            }
            return false;
        }


        public static void enqueue(int val){
            Node temp = head;
            Node node = new Node(val);
            if(head==null){
                head=node;
                return;
            }
            //tail can also be used
            while(temp.next!=null){
                temp=temp.next;
            }
            temp.next=node;
            node.next=null;
        }

        public static int dequeue(){
            if(isEmpty()){
                return -1;
            }
            int n = head.val;
            head=head.next;
            return n;
        }
        public static int peek(){
        return head.val;
    }
    }

    

    public static void main(String[] args) {
        Queue q = new Queue();
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);

        while(!q.isEmpty()){
            System.out.println(q.peek());
            q.dequeue();
        }
    }
}
