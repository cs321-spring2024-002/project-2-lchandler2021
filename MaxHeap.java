//Parent(i) = ⌊i/2⌋
//Left(i) = 2i
//Right(i) = 2i + 1

//import java.util.Arrays;
//import java.lang.Comparable;

public class MaxHeap{

/*
 * constructor creates an empty heap
 */
    protected Task[] heap; // heapsort store value
    private int heapSize; // the size of the heap used when making insert and 


    public MaxHeap(){
        this.heap = new Task[256];
        this.heapSize = 0;
    }
/*
 * constructor creates an object to use as an heap
 */
    public MaxHeap(Task[] A){
       this.heap = A.clone();
       buildMaxHeap(this.heap);
       this.heapSize = 0; // initialized heap heapsize is full array size
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
    
        int right = right(i); // defines the index for the right child
        int left = left(i); // defines the index for the left child

        int largest = i;

        if(left < this.heapSize && (A[left].compareTo(A[largest]) == 1)){
            largest = left;
        }
        if(right < this.heapSize && (A[right].compareTo(A[largest]) == 1)){
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

    //returns the parent of index
    int parent(int index){
        index = (index - 1) / 2;
        return index;
    }
    //returns the left child of a parent index
    int left(int index){
        index = 2 * index + 1;
        return index;
    }
    //returns the right child of a parent index
    int right(int index){
        index = (2 * index) + 2;
        return index;
    }
    /*
     * increases the key of task based on the position in the queue
     */
    public void increaseKey(int positon, Task task){

        if(this.heap[positon].compareTo(task) == 1){
            System.out.println("Error: new key must be larger than old key");
        }
        
        // task.setPriority(positon);
        this.heap[positon] = task;
        

        while(positon > 0 && this.heap[parent(positon)].compareTo(this.heap[positon]) == -1){ // used compare to method
            Task temp = this.heap[positon];
            this.heap[positon] = this.heap[parent(positon)];
            this.heap[parent(positon)] = temp;

            positon = parent(positon);
        }
    }
/*
 * Bottom up approach to creating a max heap, calls max_heapify
 * takes a list of objects:  A
 * returns a max heap version of the heap passed in
 */
    private Task[] buildMaxHeap(Task[] A){
    
        int half_size_heap_size = Math.floorDiv(A.length  -1,2);

        for(int parent = half_size_heap_size; parent > 0; parent--){
            maxHeapify(A, parent);
        }

        return this.heap;
    }

    //Sorting method for heapsort must be called on a heapsort object
    public void heapSort(){
        buildMaxHeap(this.heap);
        for(int i = this.heapSize -1; i > 1; i--){
            Task temp;
            temp = this.heap[1];
            this.heap[1] = this.heap[i];
            this.heap[i] = temp;
            this.heapSize--;
            maxHeapify(this.heap, 0);


        }
    }
    


    //method for inserting a value into heap
    public void insert(Task task){
        //unsure how to impliment this, have prof explain it
        if(this.heapSize == this.heap.length){
            Task[] temp;
            temp = new Task[this.heap.length*2];
            System.arraycopy(this.heap, 0, temp, 0, this.heap.length);
            this.heap = temp;
        }
        this.heapSize++;
        this.heap[heapSize -1] = task;
        increaseKey(this.heapSize-1, task);
        

        //unsure about doubleing size as well
    

    }

   
    
    //puts max value at the end of the heap
    public Task extractMax(){
        Task max;
        if(this.isEmpty()){
            System.out.println("Error: Heap Underflow");
            return null;
        }
        else{
            max = this.max();

            this.heap[0] = this.heap[this.heapSize-1];

            this.heapSize = this.heapSize -1;
            maxHeapify(this.heap, 0);
            return max;
        }
    }

    //returns max value of the heap
    public Task max(){
        if(this.isEmpty()){
            System.out.println("Error: Heap Underflow");
        }
        return this.heap[0];
    }
    // method for defineing whether or not an heap is empty
    public boolean isEmpty(){
        if(this.heapSize >= 0){
            return false;
        }
        return true;
    
    }
    //getter method for heapSize
    public int getHeapSize(){
        return this.heapSize;
    }
    //getter method for heap
    Task[] getHeap(){
        return this.heap;
    }
    

    
    
}
