package streams.main;

import streams.model.Department;
import streams.model.Employee;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        List<Department> departments =
                Stream.generate(() -> generateString(2))
                        .limit(20)
                        .distinct()
                        .map(Department::new).toList();

        Map<String, String> employees =
                Stream.generate(() -> new Employee(generateString(2), generateString(10))).limit(500)
                        .collect(Collectors.toMap(Employee::getEmployeeId, Employee::getEmployeeName, (a, b) -> a));

        Map<String, String> result = departments.stream()
                .collect(Collectors.toMap(Department::getEmployeeId, d -> employees.getOrDefault(d.getEmployeeId(), "-")));

        System.out.println(result);


        List<Employee> employees2 =
                Stream.generate(() -> new Employee(generateString(2), generateString(10)))
                        .limit(500)
                        .toList();

        Map<String, String> result2 = departments.stream()
                .collect(Collectors.toMap(Department::getEmployeeId, d -> employees2.stream()
                        .filter(e -> e.getEmployeeId().equals(d.getEmployeeId()))
                        .map(Employee::getEmployeeName)
                        .findFirst()
                        .orElse("-")));
        System.out.println(result2);
    }

    private static String generateString(int len) {
        return IntStream.generate(() -> (int) (Math.random() * 24))
                .limit(len)
                .boxed()
                .reduce("", (String s, Integer i) -> s + (char) ('a' + i), (a, b) -> a);
    }

}