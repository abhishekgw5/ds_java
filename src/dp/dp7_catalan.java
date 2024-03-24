package dp;
import java.util.*;

// Cn = C0*Cn-1 + C1*Cn-2 + C2*Cn-3 + .... + Cn-1*C0

public class dp7_catalan {
    public static int catalanRec(int n){
        if(n==0 || n==1){
            return 1;
        }
        int ans=0;
        for(int i=0;i<=n-1;i++){
            ans += catalanRec(i) * catalanRec(n-i-1);
        }
        return ans;
    }

    public static int catalanMemo(int n, int[] dp){
        if(n==0 || n==1){
            return 1;
        }
        if(dp[n]!=-1){
            return dp[n];
        }
        int ans=0;
        for(int i=0;i<=n-1;i++){
            ans += catalanMemo(i,dp) * catalanMemo(n-i-1,dp);
        }
        dp[n]=ans;
        return ans;
    }

    public static int catalanTabu(int n){
        int dp[] = new int[n+1];
        dp[0]=dp[1]=1;
        for(int i=2;i<=n;i++){
            for(int j=0;j<i;j++){
                dp[i] += dp[j]*dp[i-j-1];
            }
        }
        return dp[n];
    }

    //total number of bst from given nodes
    //(countBST(n)) = Catalan number Cn 
    public static int countBST(int n){
        int dp[] = new int[n+1];
        dp[0]=dp[1]=1;
        for(int i=2;i<n+1;i++){
            for(int j=0;j<i;j++){
                int left = dp[j]; //left subtree nodes arrangements
                int right = dp[i-j-1]; //right subtree
                dp[i] += left * right;
            }
        }
        return dp[n];
    }

    //mountain ranges problem 
    //total number of ways to form different mountain ranges
    public static int mountainRanges(int n){
        int dp[] = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i=2;i<n+1;i++){
            for(int j=0;j<i;j++){
                int inside = dp[j]; //inside pairs
                int outside = dp[i-j-1];
                dp[i] += inside * outside;
            }

        }
        return dp[n];
    }

    public static void main(String[] args) {
        int n = 5;
        // int[] dp = new int[n+1];
        // Arrays.fill(dp,-1);
        // System.out.println(catalanMemo(n, dp));
        // System.out.println(catalanRec(n));
        // System.out.println(catalanTabu(n));

        //System.out.println(countBST(n));
        System.out.println(mountainRanges(3));
    }
}
