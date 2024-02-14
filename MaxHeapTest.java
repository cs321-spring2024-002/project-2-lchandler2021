public class MaxHeapTest{

    

    public static void main(String[] args){
        
        int[] Test_A;

        Test_A = new int[]{10,2,3,4,6,8,0,2,9,20};

        // tests the empty tests
        Test1 = MaxHeap();
        isEmptyTest = Test1.isEmpty();
        if(isEmptyTest){
            System.println("The empty test ran was successful");
        }
        else{
            System.println("The empty test ran was not successful");
        }
        

    }
}