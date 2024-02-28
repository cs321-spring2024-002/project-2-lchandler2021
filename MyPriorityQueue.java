public class MyPriorityQueue extends MaxHeap{
    
    private MaxHeap heap1;
    /*
     * the queue gets initilized
     */
    public MyPriorityQueue(){
        this.heap1 = new MaxHeap();
    }
    
    /*
     * call the insert function using task
     */
    public void enqueue(Task task){
        this.heap1.insert(task);
    }
    /*
     * extracts the max value from the queue and removes it from the heap
     */
    public Task dequeue(){
        return this.heap1.extractMax();
    }
    /*
     * checks the heap and returns whether it's empty or not
     * 
     */
    public boolean isEmpty(){
        return this.heap1.isEmpty();
    }
    /*
     * updates each item in the heap's priority
     */
    public void update(int timeToIncrementPriority, int maxPriority){
        
        for(int i = 0; i < heap1.getHeapSize(); i++){
            heap1.getHeap()[i].incrementWaitingTime();
            if(heap1.getHeap()[i].getWaitingTime() >= timeToIncrementPriority){
                this.heap1.getHeap()[i].setWaitingTime(0);
                if(heap1.getHeap()[i].getPriority() < maxPriority){
                   heap1.getHeap()[i].setPriority(heap1.getHeap()[i].getPriority() + 1);
                   
                }
            }
        }
    }

}
