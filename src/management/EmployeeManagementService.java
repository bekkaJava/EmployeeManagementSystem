package management;

import employee.Employee;
import employee.Head;
import employee.RegularEmployee;
import employee.SubHead;
import enums.Position;
import exception.EmployeeAlreadyExistsException;
import exception.EmployeeNotFoundException;
import exception.TaskAlreadyAssignedException;
import exception.TaskNotFoundException;
import task.Task;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EmployeeManagementService implements EmployeeManagement {

    private Map<String, Employee> employees;
    private List<Task> tasks;

    public EmployeeManagementService() {
        this.employees = new HashMap<>();
        this.tasks = new ArrayList<>();
    }

    @Override
    public void addEmployee(Employee employee) {
        if (employees.containsKey(employee.getpId())) {
            throw new EmployeeAlreadyExistsException("Employee already exists");
        }
        employees.put(employee.getpId(), employee);
        System.out.println("Employee added");
    }

    @Override
    public Employee findEmployeeById(String pId) {
        return employees.
                values()
                .stream()
                .filter(e -> e.getpId().equals(pId))
                .findFirst()
                .orElseThrow(() -> new EmployeeNotFoundException("Employee with personalId " + pId + " not found"));
    }

    @Override
    public List<Employee> findAllEmployee() {

        List<Employee> allEmployees = new ArrayList<>(employees.values());

        return allEmployees;
    }


    @Override
    public void updateEmployee(String employeePid, Position newPosition, double newSalary) {

        Employee theEmployee = findEmployeeById(employeePid);

        theEmployee.setSalary(newSalary);
        theEmployee.setPosition(newPosition);

    }

    @Override
    public void deleteEmployee(String pId) {

        boolean isExists = employees.containsKey(pId);

        if (!isExists) {
            throw new EmployeeNotFoundException("Employee with id " + pId + " not exists");
        }

        employees.remove(pId);
        System.out.println("Employee removed");

    }

    @Override
    public List<Head> findAllHeads() {

        return employees
                .values()
                .stream()
                .filter(e -> e instanceof Head)
                .map(e -> (Head) e)
                .collect(Collectors.toList());

    }

    @Override
    public List<SubHead> findAllSubHeads() {

        return employees
                .values()
                .stream()
                .filter(e -> e instanceof SubHead)
                .map(e -> (SubHead) e)
                .collect(Collectors.toList());
    }

    @Override
    public List<RegularEmployee> findAllRegularEmployees() {

        return employees
                .values()
                .stream()
                .filter(e -> e instanceof RegularEmployee)
                .map(e -> (RegularEmployee) e)
                .collect(Collectors.toList());
    }

    @Override
    public void assignTask(Task theTask, String employeePid) {

        if (tasks.contains(theTask)) {
            throw new TaskAlreadyAssignedException("Task is already assigned");
        }

        Employee theEmployee = findEmployeeById(employeePid);
        theTask.setAssignedEmployee(theEmployee);
        tasks.add(theTask);
        theEmployee.getTasks().add(theTask);
        System.out.println("The task assigned to the employee");

    }

    @Override
    public Task findTaskById(int taskId) {

        return tasks.stream()
                .filter(t -> t.getTaskId() == taskId)
                .findFirst()
                .orElseThrow(() -> new TaskNotFoundException("Task with id " + taskId + " not found"));
    }

    @Override
    public void updateTask(int taskId, boolean isComplete) {

        Task theTask = findTaskById(taskId);
        theTask.setComplete(isComplete);
    }

    public double bonus(Employee theEmployee) {

        double bonus = theEmployee.getTasks().stream()
                .filter(t -> t.isComplete() && t.getEndDate().isBefore(t.getDueDate()))
                .map(Task::getAssignedEmployee)
                .mapToDouble(e -> e.getBonus() + 100)
                .sum();

        theEmployee.setBonus(bonus);
        return bonus;

    }

    public void saveEmployeesToFile() throws IOException {

        Path employeeDirectory = Paths.get("EmployeeSelection");
        if (Files.notExists(employeeDirectory)) {
            Files.createDirectories(employeeDirectory);
        }

        Path employeeSubDirectory = employeeDirectory.resolve("employeeSubDirectory");
        if (Files.notExists(employeeSubDirectory)) {
            Files.createDirectories(employeeSubDirectory);
        }

        for (Employee emp : employees.values()) {
            Path employeePath = employeeSubDirectory.resolve(emp.getpId().concat(".txt"));
            if (Files.notExists(employeePath)) {
                Files.createFile(employeePath);

                Files.writeString(employeePath, emp.toString());
            }
        }
    }

    public void readEmployeesFromFilesJavaNio() throws IOException {
        Path path = Paths.get("EmployeeSelection/employeeSubDirectory");

        for (Employee employee : employees.values()) {
            List<String> list = Files.readAllLines(path.resolve(employee.getpId().concat(".txt")));
            System.out.println(list);
        }
    }

    public void readEmployeesFromFilesJavaIo() throws IOException {
        Path path = Paths.get("EmployeeSelection/employeeSubDirectory");
        String line;

        for (Employee employee : employees.values()) {

            try (BufferedReader reader = new BufferedReader(
                                         new InputStreamReader(
                                         new FileInputStream(path.resolve(employee.getpId().concat(".txt")).toFile())));) {

                line = reader.readLine();
                System.out.println(line);

            }
        }
    }
}
