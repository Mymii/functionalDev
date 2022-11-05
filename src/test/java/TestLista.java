import org.junit.jupiter.api.Test;
import streams.model.Department;
import streams.model.Employee;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestLista {

    private List<Employee> employeeList = new ArrayList<>();
    private List<Department> departmentList = new ArrayList<>();

    @Test
    public void givenDepartmentList_thenEmployeeListIsFilteredCorrectly() {
        populate(employeeList, departmentList);

        Map<String, String> result = new HashMap<>();

        departmentList.stream()
                .forEach(bd -> employeeList.stream()
                        .filter(param -> bd.getEmployeeId().equals(param.getEmployeeId()))
                        .findAny()
                        .ifPresentOrElse(
                                found -> result.put(found.getEmployeeId(), found.getEmployeeName()),
                                () -> result.put(bd.getEmployeeId(), "-")
                        )
                );

        System.out.println("----------------------");
        result.forEach((s, s2) -> System.out.println(s + " : " + s2));
        System.out.println("----------------------");

        assertTrue(result.containsKey("1002"));
    }
    private void populate(List<Employee> EmplList, List<Department> deptList) {
        Employee employee1 = new Employee("1001", "empl1");
        Employee employee2 = new Employee("1002", "empl2");
        Employee employee3 = new Employee("1003", "empl3");
        Employee employee4 = new Employee("1004", "empl2");
        Employee employee5 = new Employee("1005", "empl3");
        Employee employee6 = new Employee("1006", "empl2");
        Employee employee7 = new Employee("1007", "empl3");

        Collections.addAll(EmplList, employee1, employee2, employee3, employee4, employee5, employee6, employee7);

        Department department1 = new Department("1002");
        Department department2 = new Department("1003");
        Department department3 = new Department("1004");
        Department department4 = new Department("1008");

        Collections.addAll(deptList, department1, department2, department3, department4);
    }
}