package extrass;
import java.util.*;

public class postfixToInfixPrefix {
    public static String postfixToPrefix(String s){
        Stack<String> s1 = new Stack<>();
        //String result = new String("");

        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);

            if(Character.isLetterOrDigit(c)){
                s1.push(c+"");
            }else{
                String string1 = s1.pop();
                String string2 = s1.pop();

                //s1.push("(" + string2+s.charAt(i)+string1 + ")");
                s1.push(c + string2 + string1);
            }
        }

        return s1.peek();
    }

    public static String postfixToInfix(String s){
        Stack<String> s1 = new Stack<>();
        //String result = new String("");

        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);

            if(Character.isLetterOrDigit(c)){
                s1.push(c+"");
            }else{
                String string1 = s1.pop();
                String string2 = s1.pop();

                s1.push("(" + string2+s.charAt(i)+string1 + ")");
            }
        }

        return s1.peek();
    }

    public static void main(String[] args) {
        String exp = "ab*c+";
        //System.out.println(postfixToInfix(exp));
        System.out.println(postfixToPrefix(exp));
    }
}
