package extrass;

public class rotatedSortedArray {
    public static boolean fun(int[] arr,int start,int end, int target){
        if(start>end){
            return false;
        }
        int mid = start+ (end-start)/2;
        if(arr[mid]==target){
            return true;
        }
        if (arr[start] == arr[mid] && arr[mid] == arr[end]) {
            return fun(arr, start, mid - 1, target) || fun(arr, mid + 1, end, target);
        }
        if(arr[mid]>=arr[start]){
            if(arr[start]<=target && arr[mid]>=target){
                return fun(arr,start,mid-1,target);
            }else{
                return fun(arr,mid+1,end,target);
            }
        }
        else{
            if(arr[end]>=target && arr[mid]<=target){
                return fun(arr,mid+1,end,target);
            }else{
                return fun(arr,start,mid-1,target);
            }
        }
        //return false;
    }

    public static void main(String[] args) {
        int arr[] = {1,0,1,1,1};
        System.out.println(fun(arr, 0, arr.length-1, 0));
        
    }
}
