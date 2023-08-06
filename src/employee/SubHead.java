package employee;

import enums.Department;
import enums.Position;

public class SubHead extends Employee{
    public SubHead(String fullName, int age, String pId, String email,
                   Department department, double salary, Position position) {
        super(fullName, age, pId, email, department, salary, position);
    }
}
