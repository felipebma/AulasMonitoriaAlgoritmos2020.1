import java.util.Arrays;

public class HeapExample {
    public static void main(String[] args) {
        Heap h1 = new Heap();
        int[] arr = new int[]{7, 4, 8, 9 ,5, 100, 0, 5, 1293};
        for(int i : arr){
            h1.inserir(i);
        }
        Heap h2 = new Heap(arr);
        System.out.println(h1);
        System.out.println(h2);
    }
}

class Heap{
    int[] arr;
    int size;

    public Heap(){
        arr = new int[1];
        size = 0;
    }

    public Heap(int[] arr){
        size = arr.length;
        this.arr = Arrays.copyOf(arr, size);
        buildMaxHeapify();
    }

    public void inserir(int val){
        if(size == arr.length){
            duplicateArray();
        }
        arr[size] = val;
        siftUp(size++);
    }

    public Integer peek(){
        if(size == 0) return null;
        return arr[0];
    }

    public Integer poll(){
        swap(0, size-1);
        size--;
        siftDown(0);
        return arr[size];
    }

    private int parent(int pos){
        return (pos-1)/2;
    }

    private int left(int pos){
        return 2*pos + 1;
    }

    private int right(int pos){
        return 2*(pos + 1);
    }

    private void buildMaxHeapify(){
        for(int i = size/2; i >=0; i--){
            siftDown(i);
        }
    }

    private boolean compare(int a, int b){
        return a > b;
    }

    private void siftUp(int pos){
        if(pos == 0) return;
        int parent = parent(pos);
        if(compare(arr[pos], arr[parent])){
            swap(pos, parent);
            siftUp(parent);
        }
    }

    private void siftDown(int pos){
        if(left(pos) >= size) return;
        int left = arr[left(pos)];
        if(right(pos) < size){
            int right = arr[right(pos)];
            if(compare(right, left)){
                if(compare(right, arr[pos])){
                    swap(right(pos), pos);
                    siftDown(right(pos));
                }
                return;
            }
        }
        if(compare(left, arr[pos])){
            swap(left(pos), pos);
            siftDown(left(pos));
        }
    }

    private void swap(int p1, int p2){
        int aux = arr[p1];
        arr[p1] = arr[p2];
        arr[p2] = aux;
    }

    private void duplicateArray(){
        int[] aux = new int[2*arr.length];
        for(int i = 0; i < arr.length; i++){
            aux[i] = arr[i];
        }
        arr = aux;
    }

    @Override
    public String toString(){
        return Arrays.toString(this.arr);
    }
}
