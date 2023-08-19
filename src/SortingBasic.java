public class SortingBasic {

    public static void swap(int arr[], int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void bubbleSort(int arr[], int end, int start) {
        if (end==0) {
            return;
        }
        if(start < end) {
            if (arr[start] > arr[start+1]) {
                swap(arr, start, start+1);
            }
            bubbleSort(arr,end, start+1);
        }
        else{
            bubbleSort(arr, end-1, 0);
        }
    }

    public static void selectionSort(int arr[],int start, int end,int min){
        if(start==arr.length-1){
            return;
        }
        if(end<arr.length){
            if(arr[end]<arr[min]){
                min=end;
            }
            selectionSort(arr, start, end+1, min);
        }else{
            swap(arr, start, min);
            selectionSort(arr, start+1, start+2, start+1);
        }
    }

    public static void insertionSort(int arr[],int mstart,int start, boolean choice){
        if(mstart==arr.length){
            return;
        }
        if(start<mstart){
            if(arr[start]>arr[mstart] && choice==false){
                int temp = arr[mstart];
                for (int i = mstart; i > start; i--) {
                    arr[i] = arr[i - 1];
                }
                arr[start]=temp;
                choice=true;
            }
            insertionSort(arr, mstart, start+1,choice);

        }else{
            System.out.println("hii");
            insertionSort(arr, mstart+1, 0,false);
        }
    }

    public static void main(String[] args) {
        int arr[] = { 7, 11,3, 5, 1, 4,2 };
        //bubbleSort(arr, arr.length - 1, 0);
        //selectionSort(arr, 0,1,0);
        insertionSort(arr, 1, 0,false);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
