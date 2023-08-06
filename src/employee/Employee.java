package employee;

import enums.Department;
import enums.Position;
import task.Task;

import java.util.ArrayList;
import java.util.List;

public abstract class Employee {
    protected String fullName;
    protected int age;
    protected String pId;
    protected String email;
    protected Department department;
    protected Position position;
    protected double salary;
    protected double bonus;
    protected List<Task> tasks;

    public Employee() {
        tasks = new ArrayList<>();
    }

    public Employee(String fullName,
                    int age,
                    String pId,
                    String email,
                    Department department,
                    double salary,
                    Position position) {
        this.fullName = fullName;
        this.age = age;
        this.pId = pId;
        this.email = email;
        this.department = department;
        this.salary = salary;
        this.position = position;
        this.tasks = new ArrayList<>();
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public String getpId() {
        return pId;
    }

    public void setpId(String pId) {
        this.pId = pId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "fullName='" + fullName + '\'' +
                ", age=" + age +
                ", pId='" + pId + '\'' +
                ", email='" + email + '\'' +
                ", department=" + department +
                ", position=" + position +
                ", salary=" + salary +
                ", bonus=" + bonus +
                '}';
    }
}
