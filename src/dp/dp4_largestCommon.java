package dp;

import java.util.Arrays;
import java.util.HashSet;

public class largestCommon {
    //largest common subsequence
    public static int lcsRec(String str1, String str2, int n, int m){
        if(n==0 || m==0){
            return 0;
        }
        if(str1.charAt(n-1)== str2.charAt(m-1)){
            return lcsRec(str1, str2, n-1, m-1) + 1;
        }else{
            int ans1 = lcsRec(str1, str2, n-1, m);
            int ans2 = lcsRec(str1, str2, n, m-1);
            return Math.max(ans1, ans2);
        }
    }

    public static int lcsMemo(String str1, String str2, int n, int m, int dp[][]){
        if(n==0 || m==0){
            return 0;
        }
        if(dp[n][m]!=-1){
            return dp[n][m];
        }

        if(str1.charAt(n-1)==str2.charAt(m-1)){
            dp[n][m]=lcsMemo(str1, str2, n-1, m-1, dp) + 1;
            return dp[n][m];
        }else{
            int ans1 = lcsMemo(str1, str2, n-1, m, dp);
            int ans2 = lcsMemo(str1, str2, m, m-1, dp);
            dp[n][m]=Math.max(ans1, ans2);
            return dp[n][m];
        }
    }

    public static int lcsTabu(String str1, String str2){
        int n = str1.length();
        int m = str2.length();

        int dp[][] = new int[n+1][m+1];

        for(int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++){
                if(str1.charAt(i-1)==str2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]+1;
                }else{
                    int ans1 = dp[i-1][j];
                    int ans2 = dp[i][j-1];
                    dp[i][j]=Math.max(ans1, ans2);
                }
            }
        }
        return dp[n][m];
    }

    //largest common substring
    public static int lcsubstringTabu(String str1, String str2){
        int n = str1.length();
        int m = str2.length();

        int dp[][] = new int[n+1][m+1];
        int count=0;
        for(int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++){
                if(str1.charAt(i-1)==str2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1]+1;
                    count=Math.max(count,dp[i][j]);
                }else{
                    dp[i][j]=0;
                 }
            }
        }
        return count;
    }

    //longest coomon subsequence for numbers array
    public static int lcsNumbersTabu(int[] arr){
        int n = arr.length;
        //int[] arr2 = arr;
        //we want unique numbers
        HashSet<Integer> set = new HashSet<>();
        for(int i=0;i<n;i++){
            set.add(arr[i]);
        }
        int[] arr2 = new int[set.size()];
        int index=0;
        for(int num : set){
            arr2[index]=num;
            index++;
        }
        Arrays.sort(arr2);

        int m = arr2.length;
        int dp[][] = new int[n+1][m+1];
        for(int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++){
                if(arr[i-1]==arr2[j-1]){
                    dp[i][j] = dp[i-1][j-1]+1;
                }else{
                    int ans1=dp[i-1][j];
                    int ans2=dp[i][j-1];
                    dp[i][j] = Math.max(ans1,ans2);
                }
            }
        }
        return dp[n][m];
    }

    public static void main(String[] args) {
        String str1 = "abcdeg";
        String str2 = "abedg";
        // System.out.println(lcsRec(str1, str2, str1.length(), str2.length()));
        // //
        // int dp[][] = new int[str1.length()+1][str2.length()+1];
        // for(int[] arr : dp){
        //     Arrays.fill(arr, -1);
        // }
        // System.out.println(lcsMemo(str1, str2,str1.length(), str2.length(), dp));
        // //
        // System.out.println(lcsTabu(str1, str2));

        //
        System.out.println(lcsubstringTabu(str1, str2));
    }
}



