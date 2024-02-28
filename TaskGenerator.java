
public class TaskGenerator implements TaskGeneratorInterface {
    
    public final int DEFAULT_ENERGY = 200;
	public final int SURVIVED = 0;
	public final int PASSED_OUT = 1;
	public final int DEATH = 2;

    public int currentEnergyStorage;
    public double m_taskGenerationProbability;
    public long SEED;

    public TaskGenerator(double taskGenerationProbability){
        this.m_taskGenerationProbability = taskGenerationProbability;
    }
    public TaskGenerator(double taskGenerationProbability, long seed){
        this.m_taskGenerationProbability = taskGenerationProbability;
        this.SEED = seed;
    }
    public Task getNewTask(int hourCreated, TaskInterface.TaskType taskType, String taskDescription){
        Task createdTask = new Task(0,taskType,0,hourCreated,taskDescription);   
        return createdTask;
    }

    public void decrementEnergyStorage(TaskInterface.TaskType taskType){
        currentEnergyStorage = currentEnergyStorage - taskType.getEnergyPerHour();
        if(currentEnergyStorage < 0){
            currentEnergyStorage = 0;
        }
    }

    //resets current energy storage to default energy
    public void resetCurrentEnergyStorage(){
        currentEnergyStorage = DEFAULT_ENERGY;
    }
    //returns the current energy storage
    public int getCurrentEnergyStorage(){
        return currentEnergyStorage;
    }
    //sets the current energy storage to a value between 1 and the maximum
    public void setCurrentEnergyStorage(int newEnergyNum){ 
        if(newEnergyNum < 201 && newEnergyNum > -1){
            currentEnergyStorage = newEnergyNum;
        }
    }

    //boolean return value for to generate a task
    public boolean generateTask(){
        return true;
    }

    /*
     * takes 2 parameters
     * task TASK TYPE
     * unluckyProbablility double
     * compares the unlucky probablility to the tasktypes probability
     * if unlucky probablitlity <= the task types probablility of passing out then returns 1 and decreases energy storage /2
     * if unlucky probablility <= the task types probablility of passing out and the unluckyProbablility <= the mining probability of dying(MINING)
     * returns 2 after decreaseing the energy storage by 3/4
     */
    public int getUnlucky(Task task, double unluckyProbability){
        if(unluckyProbability <= task.getTaskType().getPassingOutProbability()){
            if(unluckyProbability <= task.getTaskType().getDyingProbability()){
                currentEnergyStorage = (int)(currentEnergyStorage / .75f);
                task.setPriority(0);
                return 2;
            }
            else{
                currentEnergyStorage = currentEnergyStorage /2;
                return 1;
            }

        }else{
            return 0;
        }
        
    }
    /*
     * tostring override copied direclty from assignment
     */
    public String toString(Task task, TaskInterface.TaskType taskType) {
        if(taskType == TaskInterface.TaskType.MINING) {
            return "     Mining " + task.getTaskDescription() + " at " + currentEnergyStorage + " energy points (Priority:" + task.getPriority() +")";
        }
        if(taskType == TaskInterface.TaskType.FISHING) {
            return "     Fishing " + task.getTaskDescription() + " at " + currentEnergyStorage + " energy points (Priority:" + task.getPriority() +")" ;
        }
        if(taskType == TaskInterface.TaskType.FARM_MAINTENANCE) {
            return "     Farm Maintenance " + task.getTaskDescription() + " at " + currentEnergyStorage + " energy points (Priority:" + task.getPriority() +")";
        }
        if(taskType == TaskInterface.TaskType.FORAGING) {
            return "     Foraging " + task.getTaskDescription() + " at " + currentEnergyStorage + " energy points (Priority:" + task.getPriority() +")" ;
        }
        if(taskType == TaskInterface.TaskType.FEEDING) {
            return "     Feeding " + task.getTaskDescription() + " at " + currentEnergyStorage + " energy points (Priority:" + task.getPriority() +")";
        }
        if(taskType == TaskInterface.TaskType.SOCIALIZING) {
            return "     Socializing " + task.getTaskDescription() + " at " + currentEnergyStorage + " energy points (Priority:" + task.getPriority() +")";
        }
        else { return "nothing to see here..."; }
}


}
