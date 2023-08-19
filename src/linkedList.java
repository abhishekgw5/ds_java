public class linkedList {

    private int size;
    private Node head;
    private Node tail;

    public linkedList() {
        this.size=0;
    }

    private class Node{
        private int val;
        private Node next;

        private Node(int val){
            this.val = val;
        }

        private Node(int val,Node next){
            this.val=val;
            this.next=next;
        }

    }

    public void display() {
        Node temp = head;

        while(temp!=null){
            System.out.print(temp.val + " -> ");
            temp=temp.next;
        }

        System.out.println("NULL");
    }

    public void insertAtFirst(int val){
        Node n = new Node(val);
        if(head==null){
            head = tail = n;
            return;
        }
        n.next = head;
        head = n;
        size+=1;
    }

    public void insertAtEnd(int val){
        Node n = new Node(val);
        if(head==null){
            head = tail = n;
            return;
        }
        tail.next = n;
        tail=n;
        size++;
    }

    public void insert(int val,int index){
        if(index==0){
            insertAtFirst(val);
            return;
        }
        else if(index==size){
            insertAtEnd(val);
            return;
        }

        Node temp = head;
        
        for(int i=1; i<index;i++){
            temp=temp.next;
        }
        Node n = new Node(val,temp.next);
        n.next = temp.next.next;
        temp.next=n;
        size+=1;

    }

    public int deleteAtFirst(){
        if(size==0){
            return -1;
        }
        else if(size==1){
            int data = head.val;
            head = tail = null;
            return data;
        }
        int data = head.val;
        head = head.next;
        size--;

        return data;
    }

    public int deleteAtLast(){
        if(size==0){
            return -1;
        }
        else if(size==1){
            int data = head.val;
            head = tail = null;
            return data;
        }
        Node temp = head;
        while(temp.next.next!=null){
            temp=temp.next;
        }
        int data = temp.next.val;
        temp.next=null;
        tail = temp;
        size--;
        return data;
    }

    public int delete(int index){
        if(index==0){
            return deleteAtFirst();
        }
        else if(index==size-1){
            return deleteAtLast();
        }

        Node temp = head;
        for(int i=1;i<index-2;i++){
            temp=temp.next;
        }
        int data = temp.next.val;
        temp.next = temp.next.next;
        size--;
        return data;
    }

    public void reverse(){
        Node prev = null;
        Node current = tail = head;
        Node next;
        while(current!=null){
            next=current.next;
            current.next=prev;
            prev=current;
            current=next;
        }
        head=prev;
    }

    public Node findMid(Node head){
        Node slow = head;
        Node fast = head;

        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }

    public boolean checkPalindrome(){
        if(head==null || head.next==null){
            return true;
        }
        //find mid
        Node midNode = findMid(head);

        //reverse 2nd half
        Node prev = null;
        Node curr = midNode;
        Node next;
        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }

        Node left = head;
        Node right = prev; //2nd half head

        while(right!=null){
            if(left.val!=right.val){
                return false;
            }
            left = left.next;
            right = right.next;
        }
        return true;
    }

    public static void main(String[] args) {
        linkedList l1 = new linkedList();

        // l1.insertAtFirst(2);
        // l1.insertAtFirst(5);
        // l1.insertAtFirst(8);
        // l1.insertAtEnd(10);
        // l1.insertAtEnd(13);
        l1.insertAtFirst(1);
        l1.insertAtFirst(2);
        l1.insertAtEnd(1);
        l1.insertAtEnd(2);
        // l1.insert(15, 2);
        // l1.display();
        // System.out.println(l1.deleteAtFirst());
        // l1.display();
        // System.out.println(l1.deleteAtLast());
        // l1.display();
        // System.out.println(l1.delete(1));
        // l1.display();
        // l1.reverse();
        l1.display();
        System.out.println(l1.checkPalindrome());
    }
}
