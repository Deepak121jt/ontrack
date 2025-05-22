package ontrack;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class TaskSubmissionTest {

    private TaskSubmission ts;

    @Before
    public void setUp() {
        ts = new TaskSubmission();
    }

    // Red-Green for duplicate submission (already done)
    @Test
    public void testSubmitTask_DuplicateSubmissionFails() {
        ts.submitTask("s12345", "First submission");
        String result = ts.submitTask("s12345", "Second submission");
        assertEquals("Error: Task already submitted for student: s12345", result);
    }

    // Test submitting task with empty student ID
    @Test
    public void testSubmitTask_EmptyStudentId() {
        String result = ts.submitTask("", "Task content");
        assertEquals("Error: Student ID is required.", result);
    }

    // Test submitting task with null student ID
    @Test
    public void testSubmitTask_NullStudentId() {
        String result = ts.submitTask(null, "Task content");
        assertEquals("Error: Student ID is required.", result);
    }

    // Test submitting task with empty content
    @Test
    public void testSubmitTask_EmptyTaskContent() {
        String result = ts.submitTask("s12345", "");
        assertEquals("Error: Task content cannot be empty.", result);
    }

    // Test submitting task with null content
    @Test
    public void testSubmitTask_NullTaskContent() {
        String result = ts.submitTask("s12345", null);
        assertEquals("Error: Task content cannot be empty.", result);
    }

    // Test successful submission returns success message
    @Test
    public void testSubmitTask_Success() {
        String result = ts.submitTask("s12345", "My task");
        assertEquals("Task submitted successfully for student: s12345", result);
    }

    // Test retrieving a submitted task
    @Test
    public void testGetTask_ReturnsCorrectContent() {
        ts.submitTask("s12345", "My task");
        String task = ts.getTask("s12345");
        assertEquals("My task", task);
    }

    // Test retrieving a task that does not exist returns null
    @Test
    public void testGetTask_NonExistentStudent() {
        String task = ts.getTask("no_such_student");
        assertNull(task);
    }
}
