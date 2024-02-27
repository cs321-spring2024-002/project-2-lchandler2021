public class MyPriorityQueue extends MaxHeap{
    
    private MaxHeap heap;
    /*
     * the queue gets initilized
     */
    public MyPriorityQueue(){
        this.heap = new MaxHeap();
    }
    
    /*
     * call the insert function using task
     */
    public void enqueue(Task task){
        insert(task);
    }
    /*
     * extracts the max value from the queue and removes it from the heap
     */
    public Task dequeue(){
        return extractMax();
    }
    /*
     * checks the heap and returns whether it's empty or not
     * 
     */
    public boolean isEmpty(){
        return isEmpty();
    }
    /*
     * updates each item in the heap's priority
     */
    public void update(int timeToIncrementPriority, int maxPriority){
        for(int i = 0; i < heap.getHeapSize(); i++){
            if(array[i].getWaitingTime() >= timeToIncrementPriority){
                array[i].setWaitingTime(0);
                if(array[i].getPriority() < maxPriority){
                   array[i].setPriority(array[i].getPriority() + 1);
                   
                }
            }
        }
    }

}
