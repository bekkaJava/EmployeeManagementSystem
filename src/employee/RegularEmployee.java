package employee;

import enums.Department;
import enums.Position;

public class RegularEmployee extends Employee {
    public RegularEmployee(String fullName, int age, String pId, String email,
                           Department department, double salary, Position position) {
        super(fullName, age, pId, email, department, salary, position);
    }
}
