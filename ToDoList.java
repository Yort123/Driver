package toDoList;

public class ToDoList {
    private String activity;
    private String completedByDate;
    private int urgencyLevel; //1-5

    public ToDoList(String activity, String completedByDate, int urgencyLevel){
        this.activity = activity;
        this.completedByDate = completedByDate;
        this.urgencyLevel = urgencyLevel;
    }
    //getters
    public String getActivity(){return activity;}
    public String getCompletedByDate(){return completedByDate;}
    public int getUrgencyLevel(){return urgencyLevel;}

    //setters
    public void setActivity(String activity){this.activity = activity;}
    public void setCompletedByDate(String completedByDate){this.completedByDate = completedByDate;}
    public void setUrgencyLevel(int urgencyLevel){this.urgencyLevel = urgencyLevel;}
}
