package extrass;
import java.util.*;

public class prefixToInfixPostfix {
    public static String prefixToPostfix(String s){
        Stack<String> s1 = new Stack<>();

        for(int i=s.length()-1;i>=0;i--){
            char c = s.charAt(i);
            
            if(Character.isLetterOrDigit(c)){
                s1.push(c+"");
            }else{
                String string1 = s1.pop();
                String string2 = s1.pop();

                //s1.push("(" + string2+s.charAt(i)+string1 + ")");
                s1.push(string1 + string2 + c );
            }
            //System.out.println(s1.peek());
        }

        return s1.peek();
    }

    public static String prefixToInfix(String s){
        Stack<String> s1 = new Stack<>();

        for(int i=s.length()-1;i>=0;i--){
            char c = s.charAt(i);

            if(Character.isLetterOrDigit(c)){
                s1.push(c+"");
            }else{
                String string1 = s1.pop();
                String string2 = s1.pop();

                //s1.push("(" + string2+s.charAt(i)+string1 + ")");
                s1.push("("  + string1  + c + string2 +  ")");
            }
        }

        return s1.peek();
    }

    public static void main(String[] args) {
        String prefix = "*+a-bc/-de+-fgh";
        //System.out.println(prefixToInfix(prefix));
        System.out.println(prefixToPostfix(prefix));
    }
}
