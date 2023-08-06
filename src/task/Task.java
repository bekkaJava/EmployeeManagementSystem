package task;

import employee.Employee;
import enums.Priority;

import java.time.LocalDate;

public class Task {
    private int taskId;
    private Employee assignedEmployee;
    private String description;
    private Priority priority;
    private final LocalDate assignedDate;
    private LocalDate dueDate;
    private LocalDate endDate;
    private boolean isComplete;

    public Task(int taskId,
                String description,
                Priority priority,
                LocalDate dueDate,
                LocalDate endDate) {
        this.taskId = taskId;
        this.description = description;
        this.priority = priority;
        this.dueDate = dueDate;
        this.endDate = endDate;
        this.assignedDate = LocalDate.now();
    }

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public Employee getAssignedEmployee() {
        return assignedEmployee;
    }

    public void setAssignedEmployee(Employee assignedEmployee) {
        this.assignedEmployee = assignedEmployee;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public LocalDate getAssignedDate() {
        return assignedDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public boolean isComplete() {
        return isComplete;
    }

    public void setComplete(boolean complete) {
        isComplete = complete;
    }

    @Override
    public String toString() {
        return "Task{" +
                "taskId=" + taskId +
                ", assignedEmployee=" + assignedEmployee +
                ", description='" + description + '\'' +
                ", priority=" + priority +
                ", assignedDate=" + assignedDate +
                ", dueDate=" + dueDate +
                ", endDate=" + endDate +
                '}';
    }
}

