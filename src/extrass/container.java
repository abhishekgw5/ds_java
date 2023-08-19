package extrass;
//container with most water

public class container {

    public static int fun(int arr[],int mstart,int start,int max){
        if(mstart==arr.length){
            return max;
        }
        if(start<arr.length){
            int dif = (start-mstart)*Math.min(arr[mstart],arr[start]);
            if(dif>max){
                max=dif;
            }
            max = fun(arr, mstart, start+1, max);
        }
            
        max = fun(arr, mstart+1, mstart+1, max);
        
        //System.out.println(max);
        return max;
    }

    //2 pointer approach
    public static int fun2(int arr[]){
        int max=0;
        int lp=0;
        int rp=arr.length-1;

        while(lp<rp){
            int dif = (rp-lp)*Math.min(arr[lp],arr[rp]);
            max=Math.max(dif,max);

            if(arr[lp]<arr[rp]){
                lp++;
            }else{
                rp--;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int a[] = {1,8,6,2,5,4,8,3,7};
        
        //System.out.println(fun(a, 0, 0, 0));
        System.out.println(fun2(a));

    }
}
