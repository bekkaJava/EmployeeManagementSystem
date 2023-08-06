package employee;

import enums.Department;
import enums.Position;

public class Head extends Employee {

    public Head(String fullName, int age, String pId, String email,
                Department department, double salary, Position position) {
        super(fullName, age, pId, email, department, salary, position);
    }
}
