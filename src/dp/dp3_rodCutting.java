package dp;

import java.util.Arrays;

public class dp3_rodCutting {
    public static int rodMemo(int lengths[], int prices[], int flength, int n, int[][] dp){
        if(flength==0 || n==0){
            return 0;
        }
        if(dp[n][flength]!=-1){
            return dp[n][flength];
        }

        if(lengths[n-1]<=flength){
            //include
            int ans1 = prices[n-1] + rodMemo(lengths, prices, flength-lengths[n-1], n-1, dp);
            
            int ans2 = rodMemo(lengths, prices, flength, n-1, dp);

            dp[n][flength]=Math.max(ans1,ans2);
            return dp[n][flength];
        }else{
            dp[n][flength] = rodMemo(lengths, prices, flength, n-1, dp);
            return dp[n][flength];
        }
    }

    public static int rodTabu(int lengths[], int prices[], int flength){
        int n = lengths.length;
        int dp[][] = new int[n+1][flength+1];
        for(int i=0;i<dp.length;i++){
            dp[i][0]=0;
        }
        for(int j=0;j<dp.length;j++){
            dp[0][j]=0;
        }

        for(int i=1;i<n+1;i++){
            for(int j=1;j<flength+1;j++){
                if(lengths[i-1]<=j){
                    int ans1 = prices[i-1] + dp[i][j-lengths[i-1]];
                    int ans2 = dp[i-1][j];
                    dp[i][j] = Math.max(ans1, ans2);
                }else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        return dp[n][flength];
    }

    public static void main(String[] args) {
        int lengths[] = {1,2,3,4,5,6,7,8};
        int prices[] = {1,5,8,9,10,17,17,20};
        int flength = 8;
        // int dp[][] = new int[lengths.length+1][flength+1];
        // for(int[] arr : dp){
        //     Arrays.fill(arr, -1);
        // }
        // System.out.println(rodMemo(lengths, prices, flength, lengths.length, dp));
        //
        System.out.println(rodTabu(lengths, prices, flength));
    }
}
