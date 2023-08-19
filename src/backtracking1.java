public class backtracking1 {

    public static void findSubsets(String str, int i, String ans){
        if(i==str.length()){
            if(ans.length()==0){
                System.out.println("null");
            }else{
                System.out.println(ans);
            }
            return;
        }

        findSubsets(str, i+1, ans+str.charAt(i));
        findSubsets(str, i+1, ans);
    }

    public static void findPermutations(String str, String ans){
        if(str.length()==0){
            System.out.println(ans);
            return;
        }

        for(int i=0;i<str.length();i++){
            char curr = str.charAt(i);
            String newStr = str.substring(0, i) + str.substring(i+1,str.length());
            findPermutations(newStr, ans+curr);
        }
    }

    public static void main(String[] args) {
        String str = "abc";
        //findPermutations(str, "");
        findSubsets(str, 0, "");
    }
}
