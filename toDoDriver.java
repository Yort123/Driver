package toDoList;

public class toDoDriver {
    static ToDoList activity1 = new ToDoList("CS Lab", "11/8", 5);

    public static void main(String[] args) {
        System.out.println("Task 1");
        System.out.println(activity1.getActivity());
        System.out.println(activity1.getCompletedByDate());
        System.out.println(activity1.getUrgencyLevel());


    }

}
