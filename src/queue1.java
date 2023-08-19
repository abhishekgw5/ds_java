public class queue1 {
    
    static class Queue{
        static int[] arr;
        static int size;
        static int rear;

        Queue(int n){
            arr = new int[n];
            size=n;
            rear=-1;
        }

        public static boolean isEmpty(){
            if(rear==-1){
                return true;
            }
            return false;
        }

        public static void enqueue(int n){
            if(rear==arr.length - 1){
                System.out.println("Queue is full!!");
                return;
            }
            rear=rear+1;
            arr[rear]=n;
        }

        public static int dequeue(){
            if(isEmpty()){
                System.out.println("Queue is Empty");
                return -1;
            }
            int front = arr[0];
            for(int i=0;i<rear;i++){
                arr[i]=arr[i+1];
            }
            rear = rear-1;
            return front;
        }

        public static int peek(){
            if(isEmpty()){
                System.out.println("Queue is Empty");
                return -1;
            }
            int front = arr[0];
            return front;
        }
    }

    public static void main(String[] args) {
        Queue q = new Queue(5);
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        
        while(!q.isEmpty()){
            System.out.println(q.peek());
            q.dequeue();
        }
    }

}
