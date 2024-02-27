//Parent(i) = ⌊i/2⌋
//Left(i) = 2i
//Right(i) = 2i + 1

import java.util.Arrays;

public class MaxHeap{

/*
 * constructor creates an empty array
 */
    protected Task[] array; // heapsort store value
    private int heapSize; // the size of the heap used when making insert and 


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
       this.heapSize = this.array.length; // initialized array heapsize is full array size
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

        if(left <= A.length && (A[left].compareTo(A[right]) == 1)){
            largest = left;
        }
        if(right <= A.length && (A[right].compareTo(A[left]) == 1)){
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

    /*
     * increases the key of task based on the position in the queue
     */
    public void increaseKey(int positon, Task task){
        if(this.array[positon].compareTo(task) == 1){
            System.out.println("Error: new key must be larger than old key");
        }
        task.setPriority(positon);
        
        int parent_of_index = Math.floorDiv(positon - 1,2);

        while(positon > 0 && this.array[parent_of_index].compareTo(this.array[positon]) == -1){
            Task temp = this.array[positon];
            this.array[positon] = this.array[parent_of_index];
            this.array[parent_of_index] = temp;

            positon = parent_of_index;
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

    //Sorting method for heapsort must be called on a heapsort object
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
    


    //method for inserting a value into heap
    public void insert(Task task){
        Task[] Array_copy = new Task[this.heapSize *2];
        Array_copy = this.array.clone();
        
        Array_copy[this.heapSize + 1] = task;
        this.array = Array_copy.clone();
         
        maxHeapify(this.array, heapSize);


    

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

    //returns max value of the heap
    public Task max(){
        if(this.isEmpty()){
            System.out.println("Error: Heap Underflow");
        }
        return this.array[0];
    }
    // method for defineing whether or not an array is empty
    public boolean isEmpty(){
        if(this.heapSize > 0){
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
        return this.array;
    }
    

    
    
}
