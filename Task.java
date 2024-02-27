

class Task implements TaskInterface{

    public enum TaskType {

        MINING(100, 20, 0.1, 0.05),
        FISHING(150, 20, 0.1, 0),
        FARM_MAINTENANCE(25, 10, 0.1, 0),
        FEEDING(75, 10, 0.1, 0),
        FORAGING(75, 0, 0, 0),
        SOCIALIZING(25, 0, 0, 0);

        private final int moneyPerHour;
        private final int energyPerHour;
        private final double passingOutProbability;
        private final double dyingProbability;

        TaskType(int moneyPerHour, int energyPerHour, double passingOutProbability, double dyingProbability) {
            this.moneyPerHour = moneyPerHour;
            this.energyPerHour = energyPerHour;
            this.passingOutProbability = passingOutProbability;
            this.dyingProbability = dyingProbability;
        }

        public int getMoneyPerHour()
        {
            return moneyPerHour;
        }

        public int getEnergyPerHour()
        {
            return energyPerHour;
        }

        public double getPassingOutProbability()
        {
            return passingOutProbability;
        }

        public double getDyingProbability()
        {
            return dyingProbability;
        }
    }

    private int PRIORITY_LEVEL;
    private TaskInterface.TaskType TaskType;
    private int WAITING_TIME;
    private int HOUR_CREATED;
    private String DESCRIPTION;
    
    /*
     * Constructor for task object, takes 5 variables on creation
     * prority level is a integer
     * task type is a string
     * waiting time is an integer
     * hour created is an integer // subject to change
     * description is a string that explains what the task is
     */

    public Task(int priorityLevel, TaskInterface.TaskType taskType, int waitingTime, int hourCreated, String description){
        
        this.PRIORITY_LEVEL = priorityLevel;
        this.TaskType = taskType;
        this.WAITING_TIME = waitingTime;
        this.HOUR_CREATED = hourCreated;
        this.DESCRIPTION = description;

    }
    public int compareTo(Task task_two){
        if(this.getPriority() > task_two.getPriority()){
            return 1;
        }else if (this.getPriority() == task_two.getPriority()){
            if(this.getHourCreated() < task_two.getHourCreated()){
                return 1;
            }
            else{
                return -1;
            }
        }else{
            return -1;
        }
        
    }
    // getter method for priority level
    public int getPriority(){
        return this.PRIORITY_LEVEL;
    }
    // getter method for task type
    public TaskInterface.TaskType getTaskType(){
        return this.TaskType;
    }
    //getter method for waiting time
    public int getWaitingTime(){
        return this.WAITING_TIME;
    }
    public void setWaitingTime(int waitingTime){
        this.WAITING_TIME = waitingTime;
    }
    //getter method for hour created
    public int getHourCreated(){
        return this.HOUR_CREATED;
    }
    //gettter method for description
    public String getTaskDescription(){
        return this.DESCRIPTION;
    }

    public void setPriority(int priorityLevel){
        this.PRIORITY_LEVEL = priorityLevel;
    }

    public void incrementWaitingTime(){
        this.WAITING_TIME++;
    }
    public void resetWaitingTime(){
        this.WAITING_TIME = 0;
    }

}