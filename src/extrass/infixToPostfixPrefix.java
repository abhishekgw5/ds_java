package extrass;
import java.util.*;

public class infixToPostfixPrefix {
    static int Precedence(char ch) {
        switch (ch) {
            case '+':
            case '-':
                return 1;

            case '*':
            case '/':
                return 2;

            case '^':
                return 3;
        }
        return -1;
    }

    public static String reverse(String s){
        String snew = new String("");
        for(int i=s.length()-1;i>=0;i--){
            snew+=s.charAt(i);
        }
        return snew;
    }

    public static String infixToPrefix(String s){
        //String does not have reverse function

        String result = infixToPostfix(reverse(s));

        return reverse(result);
    }

    public static String infixToPostfix(String s) {
        String result = new String("");
        Stack<Character> s1 = new Stack<>();
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            
            if(Character.isLetterOrDigit(c)){
                result+=c;
            }
            else if(c=='('){
                s1.push(c);
            }
            else if(c==')'){
                while(!s1.isEmpty() && s1.peek()!='('){
                    result+=s1.pop();
                }
                s1.pop();
            }
            else{
                while(!s1.isEmpty() && Precedence(c)<=Precedence(s1.peek())){
                    result+=s1.pop();
                    
                }
                s1.push(c);
            }
        }

        while(!s1.isEmpty()){
            if(s1.peek()=='('){
                return "Invalid exp";
            }
            result+=s1.pop();
        }

        return result;
    }

    public static void main(String[] args) {
        String s = "a+b*c+d";
        String s2 = "(1+(4+5+2)-3)+(6+8)";
        System.out.println(infixToPostfix(s2));
        System.out.println(infixToPrefix(s));
    }
}
