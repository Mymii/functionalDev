package streams.main;

import streams.model.Department;
import streams.model.Employee;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main3 {

    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        List<Department> departments = new ArrayList<>();

        populate(employees, departments);

        Map<String, String> result = departments.stream()
                .collect(Collectors.toMap(Department::getEmployeeId, d -> employees.stream()
                        .filter(e -> e.getEmployeeId().equals(d.getEmployeeId()))
                        .map(Employee::getEmployeeName)
                        .findFirst()
                        .orElse("-")));


        result.forEach((k, v) -> System.out.println(k + " : " + v));
    }

    private static void populate(List<Employee> employees, List<Department> departments) {
        Employee employee1 = new Employee("1001", "empl1");
        Employee employee2 = new Employee("1002", "empl2");
        Employee employee3 = new Employee("1003", "empl3");
        Employee employee4 = new Employee("1004", "empl2");
        Employee employee5 = new Employee("1005", "empl3");
        Employee employee6 = new Employee("1006", "empl2");
        Employee employee7 = new Employee("1007", "empl3");

        Collections.addAll(employees, employee1, employee2, employee3, employee4, employee5, employee6, employee7);

        Department department1 = new Department("1002");
        Department department2 = new Department("1003");
        Department department3 = new Department("1004");
        Department department4 = new Department("1008");

        Collections.addAll(departments, department1, department2, department3, department4);
    }
}
