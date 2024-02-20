//Parent(i) = ⌊i/2⌋
//Left(i) = 2i
//Right(i) = 2i + 1


public class MaxHeap{

/*
 * constructor creates an empty array
 */
    private Task[] array;
    int heapSize;
    public MaxHeap(){
        this.array = new Task[]{};
        this.heapSize = this.array.length;
    }
/*
 * constructor creates an object to use as an array
 */
    public MaxHeap(Task[] A){
       this.array = A.clone();
       buildMaxHeap(this.array);
       this.heapSize = this.array.length;
    }

/*
 * Max_heapifydown
 * takes in a list of objects: A
 * takes in an index as an integer: i
 * 
 * Precondition:: Both the left and right subtrees of node i are max-heaps
 *  and i is less than or equal to the size of object A
 */
    private void maxHeapify( Task[] A, int i ){
    
        int right = 2 * i + 1; // defines the index for the right child
        int left = 2 * i; // defines the index for the left child

        int largest = i - 1;

        if(left <= A.length && (A[left].getPriority() > A[i].getPriority())){
            largest = left;
        }
        if(right <= A.length && A[right].getPriority() > A[i].getPriority()){
            largest = right;
        }
        if(largest != i){
            Task temp;
            temp = A[i];
            A[i] = A[largest];
            A[largest] = temp;

            maxHeapify(A, largest);
        }
        
    }

    // used to 
    public void increaseKey(int i, int key){
        if(key < this.array[i].getPriority()){
            System.out.println("Error: new key must be larger than old key");
        }
        this.array[i].setPriority(key);
        
        int parent_of_index = Math.floorDiv(i -1,2);
        while(i > 0 && this.array[parent_of_index].getPriority() < this.array[i].getPriority()){
            Task temp = this.array[i];
            this.array[i] = this.array[parent_of_index];
            this.array[parent_of_index] = temp;

            i = parent_of_index;
        }
    }
/*
 * Bottom up approach to creating a max heap, calls max_heapify
 * takes a list of objects:  A
 * returns a max heap version of the array passed in
 */
    private Task[] buildMaxHeap(Task[] A){
    
        int half_size_heap_size = Math.floorDiv(A.length  -1,2);

        for(int parent = half_size_heap_size; parent > 0; parent--){
            maxHeapify(A, parent);
        }

        return this.array;
    }

    public void heapSort(){
        buildMaxHeap(this.array);
        for(int i = this.heapSize -1; i > 1; i--){
            Task temp;
            temp = this.array[1];
            this.array[1] = this.array[i];
            this.array[i] = temp;
            this.heapSize--;
            maxHeapify(this.array, 0);


        }
    }
    public void insert(Task task, int n){
        if(this.heapSize -1 == n){
            System.out.println("Error: Heap overflow");
        }

        int k = task.getPriority();

        this.heapSize = this.heapSize +1;
        
        task.setPriority(Integer.MIN_VALUE);
        this.array[this.heapSize ] = task;
        increaseKey( this.heapSize, k);

    }

    public Task[] createDoubleSizeHeap(Task[] A){
        //Syste.arraycopy();
        return null;
    
        
    }
    
    //puts max value at the end of the array
    public Task extractMax(){
        Task max;
        if(this.isEmpty()){
            System.out.println("Error: Heap Underflow");
            return null;
        }
        else{
            max = max();

            this.array[0] = this.array[this.heapSize-1];
            this.heapSize = this.heapSize -1;
            maxHeapify(this.array, 0);
            return max;
        }
    }

    //returns max value
    public Task max(){
        if(this.isEmpty()){
            System.out.println("Error: Heap Underflow");
        }
        return this.array[0];
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
