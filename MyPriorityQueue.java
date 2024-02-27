public class MyPriorityQueue extends MaxHeap{
    
    private MaxHeap heap;

    public MyPriorityQueue(){
        this.heap = new MaxHeap();
    }
    

    public void enqueue(Task task){
        insert(task);
    }
    
    public Task dequeue(){
        return extractMax();
    }
    
    public boolean isEmpty(){
        return isEmpty();
    }
    
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
