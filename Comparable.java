public class Comparable implements ComparableInterface{
    
    public boolean compareTo(Task task_one, Task task_two){

        if(task_one.getPriority() > task_two.getPriority()){
            return true;
        }else if(task_one.getPriority() == task_two.getPriority()){
            if(task_one.getHourCreated() < task_two.getHourCreated()){
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }
    }
        
}