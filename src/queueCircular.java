public class queueCircular {
    static class Queue{
        static int[] arr;
        static int size;
        static int rear;
        static int front;

        Queue(int n){
            arr = new int[n];
            size=n;
            rear=-1;
            front=-1;
        }

        public static boolean isEmpty(){
            if(rear==-1 && front==-1){
                return true;
            }
            return false;
        }

        public static boolean isFull(){
            if((rear+1)%size == front){
                return true;
            }
            return false;
        }

        public static void enqueue(int n){
            if(isFull()){
                System.out.println("Queue is full!!");
                return;
            }
            if(front==-1){
                front=0;
            }
            rear=(rear+1)%size;
            arr[rear]=n;
        }

        public static int dequeue(){
            if(isEmpty()){
                System.out.println("Queue is Empty");
                return -1;
            }
            int result = arr[front];
            
            if(rear==front){
                rear=front=-1;
            }else{
                front=(front+1)%size;
            }
            return result;
        }

        public static int peek(){
            if(isEmpty()){
                System.out.println("Queue is Empty");
                return -1;
            }
            return arr[front];
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
