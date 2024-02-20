public class MyPriorityQueue extends MaxHeap{
    
    private MaxHeap heap;

    public MyPriorityQueue(){
        this.heap = new MaxHeap();
    }

    public void enqueue(Task task){
        insert(task, task.getPriority());
    }
    
    public Task dequeue(){
        return extractMax();
    }
    
    public boolean isEmpty(){
        return isEmpty();
    }
    
    public void update(int timeToIncrementPriority, int maxPriority){
        
    }

}
