package dp;
import java.util.*;

public class fibonacci {
    public static int fibMemoization(int n,int fb[]){
        if(n==0 || n==1){
            return n;
        }
        if(fb[n]!=0){ //already calculated
            return fb[n];
        }
        fb[n] = fibMemoization(n-1,fb) + fibMemoization(n-2,fb);
        return fb[n];
    } 

    public static int fibTabulation(int n){
        int dp[] = new int[n+1];
        dp[0]=0;
        dp[1]=1;
        for(int i=2;i<=n;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
    }

    //climbing stairs problem
    //one can climb 1 or 2 stairs then find number of ways to reach nth stair
    public static int countWays(int n, int ways[]){
        if(n<=2){
            return n;
        }
        if(ways[n]!=0){
            return ways[n];
        }
        ways[n] = countWays(n-1, ways) + countWays(n-2, ways);
        return ways[n];
    }
    // public static int countWays(int n, int ways[]){
    //     if(n==0){
    //         return 1;
    //     }
    //     if(n<0){
    //         return 0;
    //     }
    //     if(ways[n]!=-1){
    //         return ways[n];
    //     }
    //     ways[n] = countWays(n-1, ways) + countWays(n-2, ways);
    //     return ways[n];
    // }

    public static int countWaysTab(int n){
        int dp[] = new int[n+1];
        dp[0]=1;

        for(int i=1;i<=n;i++){
            if(i==1){
                dp[i]=dp[i-1] + 0;
            }else{
                dp[i]=dp[i-1]+dp[i-2];
            }
        }
        return dp[n];
    }

    //now one can climb 1,2 or 3 stairs
    public static int countWays2(int n, int ways[]){
        if(n<=2){
            return n;
        }else if(n==3){
            return 4;
        }
        if(ways[n]!=0){
            return ways[n];
        }
        ways[n] = countWays2(n-1, ways) + countWays2(n-2, ways) + countWays2(n-3, ways);
        return ways[n];
    }
 

    public static void main(String[] args) {
        int n=5;
        int fb[] = new int[n+1]; //array for storing previously calculated fibonaaci's
        // System.out.println(fibMemoization(n,fb));
        // System.out.println(fibTabulation(n));

        // //Arrays.fill(fb,-1);
    
        // System.out.println(countWays(n, fb));
        // System.out.println(countWaysTab(n));
        System.out.println(countWays2(n, fb));
    }
}
