import java.util.Scanner;

public class Q1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(), q = in.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = in.nextInt();
        }
        for(int i=0; i<q; i++){
            int numero = in.nextInt();
            System.out.println((binarySearch(arr,numero)+1));
        }        
    }

    public static int binarySearch(int[] arr, int i){
        int left = 0, right = arr.length;
        while(left < right){
            int mid = left + (right-left)/2;
            if(arr[mid] < i){
                left = mid+1;
            }else{
                right = mid;
            }
        }
        return left;
    }
}