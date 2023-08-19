package extrass;
// next greater element to right 
//using stack
import java.util.*;
public class nextGreater {

    public static int[] nextGreaterRight(int arr[]){
        Stack<Integer> s= new Stack<>();
        int new_arr[] = new int[arr.length];
        
        for(int i=arr.length-1;i>=0;i--){
            boolean b = false;
            int data=-1;
            while(!s.isEmpty() && b==false){
                if(s.peek()<arr[i]){
                    s.pop();
                }else{
                    data=s.peek();
                    b=true;
                }
            }
            new_arr[i]=data;
            s.push(arr[i]);
        }

        return new_arr;
    }

    public static void main(String[] args) {
        int arr[] = {6,8,0,1,3};
        int arr1[] = nextGreaterRight(arr);
        for(int i=0;i<arr1.length;i++){
            System.out.println(arr1[i]);
        }
    }
}
