//Parent(i) = ⌊i/2⌋
//Left(i) = 2i
//Right(i) = 2i + 1
public class MaxHeap{

/*
 * constructor creates an empty array
 */
    private Object[] array;

    public MaxHeap(){
        this.array = new Object[]{};
    }
/*
 * constructor creates an object to use as an array
 */
    public MaxHeap(Object[] a){
        System.arraycopy(array , 0 ,this.array);
    }

/*
 * Max_heapifydown
 * takes in a list of objects: A
 * takes in an index as an integer: i
 * 
 * Precondition:: Both the left and right subtrees of node i are max-heaps
 *  and i is less than or equal to the size of object A
 */
    public void maxHeapify( Object[] A, int i ){
    
        int right = 2 * i + 1; // defines the index for the right child
        int left = 2 * i; // defines the index for the left child

        int largest = i;

        if(left <= A.length && (A[left].compareTo(A[i]) > 0)){
            largest = left;
        }
        if(right <= A.length && A[right].compareTo(A[i]) > 0)){
            largest = right;
        }
        if(largest != i){
            Object temp;
            temp = A[i];
            A[i] = A[largest];
            A[largest] = temp;

            maxHeapify(A, largest);
        }
        System.arraycopy(A, 0, this.array);
    }

/*
 * Bottom up approach to creating a max heap, calls max_heapify
 * takes a list of objects:  A
 * returns a max heap version of the array passed in
 */
    public Object buildMaxHeap(Object[] A){
    
        int half_size_heap_size = (int)A.length / (int)2;

        for(int parent = half_size_heap_size; parent > 0; parent--){
            maxHeapify(A, parent);
        }

        return this.array;
    }
    public boolean isEmpty(){
        if(this.array.length > 0){
            return false;
        }
        return true;
    }
    public static void main(String[] args){

    }
}
