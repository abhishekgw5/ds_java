package dp;
public class dp2_knapsack {
    public static int knapsackRecur(int val[], int wt[], int W, int n){
        if(W==0 || n==0){
            return 0;
        }

        if(wt[n-1]<=W){ //valid
            //include
            int ans1 = val[n-1]+knapsackRecur(val, wt, W-wt[n-1], n-1);
            //exclude
            int ans2 = knapsackRecur(val, wt, W, n-1);
            return Math.max(ans1,ans2);
        }else{ //not valid
            return knapsackRecur(val, wt, W, n-1);
        }
    }

    //memoization 
    public static int knapsackMemoization(int val[],int wt[], int W, int n, int dp[][]){
        if(W==0 || n==0){
            return 0;
        }

        if(dp[n][W]!=-1){
            return dp[n][W];
        }

        if(wt[n-1]<=W){
            //include
            int ans1 = val[n-1]+knapsackMemoization(val, wt, W-wt[n-1], n-1, dp);
            //exclude
            int ans2 = knapsackMemoization(val, wt, W, n-1, dp);
            dp[n][W] = Math.max(ans1, ans2);
            return dp[n][W];
        }else{
            dp[n][W] = knapsackMemoization(val, wt, W, n-1, dp);
            return dp[n][W];
        }
    }

    //tabulation
    public static int knapsackTab(int val[],int wt[], int W){
        int n= val.length;
        int dp[][] = new int[n+1][W+1];
        for(int i=0;i<dp.length;i++){
            dp[i][0]=0;
        }
        for(int j=0;j<dp.length;j++){
            dp[0][j]=0;
        }

        for(int i=1;i<n+1;i++){
            for(int j=1;j<W+1;j++){
                int v = val[i-1]; //ith item val
                int w = wt[i-1]; //ith item wt
                if(w<=j){
                    int incProfit = v + dp[i-1][j-w];
                    int excProfit = dp[i-1][j];
                    dp[i][j]=Math.max(incProfit,excProfit);
                }else{
                    int excProfit = dp[i-1][j];
                    dp[i][j]=excProfit;
                }
            }
        }
        printMatrix(dp);
        return dp[n][W];
    }

    public static void printMatrix(int dp[][]){
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static boolean targetSumSubset(int arr[], int sum){
        int n = arr.length;
        boolean dp[][] = new boolean[n+1][sum+1];
        // i=items & j=target sum
        for(int i=0;i<n+1;i++){
            dp[i][0]=true;
        }

        for(int i=1;i<n+1;i++){
            for(int j=1;j<sum+1;j++){
                int v = arr[i-1];
                //include
                if(v<=j && dp[i-1][j-v]==true){
                    dp[i][j]=true;
                }
                //exclude
                else if(dp[i-1][j]==true){
                    dp[i][j]=true;
                }
            }
        }
        return dp[n][sum];
    }

    public static int unBoundedKnapsackTab(int val[],int wt[], int W){
        int n= val.length;
        int dp[][] = new int[n+1][W+1];
        for(int i=0;i<dp.length;i++){
            dp[i][0]=0;
        }
        for(int j=0;j<dp.length;j++){
            dp[0][j]=0;
        }

        for(int i=1;i<n+1;i++){
            for(int j=1;j<W+1;j++){
                int v = val[i-1]; //ith item val
                int w = wt[i-1]; //ith item wt
                if(w<=j){
                    int incProfit = v + dp[i][j-w];
                    int excProfit = dp[i-1][j];
                    dp[i][j]=Math.max(incProfit,excProfit);
                }else{
                    int excProfit = dp[i-1][j];
                    dp[i][j]=excProfit;
                }
            }
        }
        printMatrix(dp);
        return dp[n][W];
    }

    public static void main(String[] args) {
        int val[] = {15,14,10,45,30};
        int wt[] =  {2, 5, 1, 3, 4};
        int W = 7; //capacity of bag0

        //System.out.println(knapsackRecur(val, wt, W, val.length));

        //
        // int dp[][] = new int[val.length+1][W+1];
        // for(int i=0;i<dp.length;i++){
        //     for(int j=0;j<dp[0].length;j++){
        //         dp[i][j]=-1;
        //     }
        // }
        //System.out.println(knapsackMemoization(val, wt, W, val.length, dp));
        
        ////
        System.out.println(knapsackTab(val, wt, W));

        int arr[] = {4,2,7,1,3};
        int sum=10;
        System.out.println(targetSumSubset(arr, sum));

        System.out.println(unBoundedKnapsackTab(val, wt, W));
    }
}
