public class linkedListDoubly {
    private int size;
    private Node head;
    private linkedListDoubly(){
        this.size = 0;
    }

    private class Node{
        int val;
        Node next;
        Node prev;

        private Node(int val){
            this.val=val;
        }

        private Node(int val,Node next,Node prev){
            this.val=val;
            this.next=next;
            this.prev=prev;
        }
    }

    public void insertAtFirst(int val){
        Node n = new Node(val);
        n.next=head;
        n.prev=null;
        if(head!=null){
            head.prev=n;
        }
        head=n;
        size++;
    }

    public void insertAtLast(int val){
        Node n = new Node(val);
        if(size==0){
            insertAtFirst(val);
            return;
        }

        Node temp = head;
        while(temp.next!=null){
            temp=temp.next;
        }
        temp.next=n;
        n.prev=temp;
        n.next=null;
        size++;
    }

    public void insert(int index,int val){
        if(index==0){
            insertAtFirst(val);
            return;
        }
        else if(index==size){
            insertAtLast(val);
            return;
        }
        Node n = new Node(val);
        Node temp=head;
        for(int i=1;i<index-1;i++){
            temp=temp.next;
        }
        
        n.next=temp.next;
        temp.next=n;
        n.prev=temp;
        size++;
    }

    public void display(){
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.val + " -> ");
            temp=temp.next;
        }
        System.out.print("NULL");
    }

    public void displayRev(){
        Node temp = head;
        while(temp.next!=null){
            temp=temp.next;
        }
        while(temp!=null){
            System.out.print(temp.val + " -> ");
            temp=temp.prev;
        }
        System.out.print("NULL");
    }

    public static void main(String[] args) {
        linkedListDoubly ld1 = new linkedListDoubly();
        ld1.insertAtFirst(5);
        ld1.insertAtFirst(11);
        ld1.insertAtFirst(12);
        ld1.insertAtFirst(13);
        ld1.insertAtLast(10);
        ld1.display();
        System.out.println();
        ld1.insert(1, 111);
        ld1.display();
        
        // ld1.displayRev();
    }
}
