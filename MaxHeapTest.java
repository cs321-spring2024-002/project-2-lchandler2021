

public class MaxHeapTest{


    

    public static void main(String[] args){
       
        //isempty method tests
        System.out.println("IsEmpty() method tests:");
        Task[] Test_A = {};
        
        MaxHeap maxHeapTest1 = new MaxHeap(Test_A);
        if(maxHeapTest1.isEmpty()){
            System.out.println("Test 1: Empty test passed");
        }else{
            System.out.println("Test 1: Empty test failed");
        }

        Task one;
        TaskGenerator Generator = new TaskGenerator(1);
        one = Generator.getNewTask(0, TaskInterface.TaskType.MINING,"ok");
        Task[] Test_B = {one};

        MaxHeap maxHeapTest2 = new MaxHeap(Test_B);
        if(maxHeapTest2.isEmpty()){
            System.out.println("Test 2: Empty test failed");
        }else{
            System.out.println("Test 2: Empty test passed");
        }

        //extract method tests

        Task one_1;
        Task two_1;
        one_1 = Generator.getNewTask(0, TaskInterface.TaskType.FISHING, "helpful");
        two_1 = Generator.getNewTask(0, TaskInterface.TaskType.MINING,"HELLO");

        Task[] Test_C = {one_1, two_1};

        MaxHeap maxHeapTest3 = new MaxHeap(Test_C);
        
        System.out.println(maxHeapTest3.extractMax());
        



        
        

        // tests the empty tests
       

    }
}