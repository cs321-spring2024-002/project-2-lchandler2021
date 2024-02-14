class Task{


    private int PRIORITY_LEVEL;
    private TaskType TASK_TYPE;
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

    public Task(int priorityLevel, TaskType taskType, int waitingTime, int hourCreated, String description){
        
        this.PRIORITY_LEVEL = priorityLevel;
        this.TASK_TYPE = taskType;
        this.WAITING_TIME = waitingTime;
        this.HOUR_CREATED = hourCreated;
        this.DESCRIPTION = description;

    }

    // getter method for priority level
    public int getPriorityLevel(){
        return this.PRIORITY_LEVEL;
    }
    // getter method for task type
    public TaskType getTaskType(){
        return this.TASK_TYPE;
    }
    //getter method for waiting time
    public int getWaitingTime(){
        return this.WAITING_TIME;
    }
    //getter method for hour created
    public int getHourCreated(){
        return this.HOUR_CREATED;
    }
    //gettter method for description
    public String getTaskDescription(){
        return this.DESCRIPTION;
    }

    public setPriority(int priorityLevel){
        this.PRIORITY_LEVEL = priorityLevel;
    }

    public void incrementWaitingTime(){
        this.WAITING_TIME++;
    }
    public void resetWaitingTime(){
        this.WAITING_TIME = 0;
    }

}