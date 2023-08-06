package management;

import employee.Employee;
import employee.Head;
import employee.RegularEmployee;
import employee.SubHead;
import enums.Position;
import task.Task;

import java.util.List;

public interface EmployeeManagement {

    void addEmployee(Employee employee);

    void deleteEmployee(String pID);

    Employee findEmployeeById(String pId);

    List<Employee> findAllEmployee();

    void updateEmployee(String employeePid, Position newPosition, double newSalary);

    List<Head> findAllHeads();

    List<SubHead> findAllSubHeads();

    List<RegularEmployee> findAllRegularEmployees();

    Task findTaskById(int taskId);

    void updateTask(int taskId, boolean isComplete);

    void assignTask(Task theTask, String employeePid);

    double bonus(Employee theEmployee);
}
