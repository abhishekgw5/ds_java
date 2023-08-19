//using arraylist
import java.util.ArrayList;

public class stack1 {
    static class stack{
        static ArrayList<Integer> list = new ArrayList<>();

        public static boolean isEmpty(){
            if(list.size()==0){
                return true;
            }
            return false;
        }

        public static void push(int n){
            list.add(n);
        }

        public static int pop(){
            int n = list.get(list.size()-1);
            list.remove(list.size()-1);
            return n;
        }

        public static int peek(){
            int n = list.get(list.size()-1);
            return n;
        }
    }

    public static void main(String[] args) {
        stack s = new stack();
        s.push(1);
        s.push(2);
        s.push(3);
        
        while(!s.isEmpty()){
            System.out.println(s.peek());
            s.pop();
        }
    }
}
