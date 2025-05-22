package ontrack;

import java.util.HashMap;
import java.util.Map;

public class TaskSubmission {
    
    private Map<String, String> taskDatabase;

    public TaskSubmission() {
        taskDatabase = new HashMap<>();
    }

    /**
     * Submits a task for a given student ID.
     * 
     * @param studentId     the student ID
     * @param taskContent   the content of the task
     * @return a confirmation message
     */
    public String submitTask(String studentId, String taskContent) {
        if (studentId == null || studentId.isEmpty()) {
            return "Error: Student ID is required.";
        }
        if (taskContent == null || taskContent.isEmpty()) {
            return "Error: Task content cannot be empty.";
        }
        
        // Check for duplicate submission
        if (taskDatabase.containsKey(studentId)) {
            return "Error: Task already submitted for student: " + studentId;
        }

        taskDatabase.put(studentId, taskContent);
        return "Task submitted successfully for student: " + studentId;
    }


    /**
     * Gets the submitted task for a student.
     * 
     * @param studentId the student ID
     * @return the task content or null if not found
     */
    public String getTask(String studentId) {
        return taskDatabase.get(studentId);
    }

    public static void main(String[] args) {
        TaskSubmission ts = new TaskSubmission();
        String result = ts.submitTask("s12345", "My Task Content");
        System.out.println(result);
    }
}
