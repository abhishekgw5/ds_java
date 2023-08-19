import java.util.*;

public class queueStack {
    static Stack<Integer> s1 = new Stack<>();
    static Stack<Integer> s2 = new Stack<>();

    static class Queue{
        public static boolean isEmpty(){
            return s1.isEmpty();
        }
        public static void enqueue(int n){
            while(!s1.isEmpty()){
                s2.push(s1.pop());
            }
            s1.push(n);
            while(!s2.isEmpty()){
                s1.push(s2.pop());
            }
        }

        public static int dequeue(){
            if(s1.isEmpty()){
                System.out.println("queue is empty");
                return -1;
            }
            return s1.pop();
        }

        public static int peek(){
            if(s1.isEmpty()){
                System.out.println("queue is empty");
                return -1;
            }
            return s1.peek();
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
