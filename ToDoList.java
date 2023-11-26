package toDoList;

public class ToDoList { 
    private String activity; //establishing private instance variables
    private String completedByDate;
    private int urgencyLevel; //1-5

    public ToDoList(String activity, String completedByDate, int urgencyLevel){
        this.activity = activity; // using "this" to differentiate between instance variables and method parameters when assigning
        this.completedByDate = completedByDate;
        this.urgencyLevel = urgencyLevel;
    }
    //getters
    public String getActivity(){return activity;} //implementing accessors 
    public String getCompletedByDate(){return completedByDate;}
    public int getUrgencyLevel(){return urgencyLevel;}

    //setters
    public void setActivity(String activity){this.activity = activity;} // implementing mutators 
    public void setCompletedByDate(String completedByDate){this.completedByDate = completedByDate;}
    public void setUrgencyLevel(int urgencyLevel){this.urgencyLevel = urgencyLevel;}
}
