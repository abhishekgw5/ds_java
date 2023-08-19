public class likedListCircular {
    // private int size;
    private Node head;
    private Node tail;

    public likedListCircular() {
        this.head = null;
        this.tail = null;
    }

    private class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }
    }

    public void insert(int val) {
        Node n = new Node(val);
        if (head == null) {
            head = n;
            tail = n;
            return;
        }
        tail.next = n;
        n.next = head;
        tail = n;
    }

    public void display() {
        Node temp = head;
        if (head != null) {
            do {
                System.out.print(temp.val + " -> ");
                temp = temp.next;
            } while (temp != head);
        }
        System.out.println("HEAD");
    }

    public void delete(int val){
        Node temp = head;
        if(temp==null){
            return;
        }
        if(head==tail){
            head=null;
            tail=null;
            return;
        }
        if(temp.val==val){
            head=head.next;
            tail.next=head;
            return;
        }

        while(temp.next.val!=val){
            temp = temp.next;
        }
        temp.next = temp.next.next;
    }
    

    public static void main(String[] args) {
        likedListCircular lc1 = new likedListCircular();
        lc1.insert(1);
        lc1.insert(2);
        lc1.insert(3);

        lc1.display();
        lc1.delete(1);
        lc1.display();
    }
}
